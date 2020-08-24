package controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import model.*;
import java.io.*;
import java.util.ArrayList;
//import sandbox.WrapToTest;

/**
 * controller to save, load and export data
 */
public class IOController {

	/**
	 * the file in which the status is saved
	 */
	private static final File SAVE_FILE = new File("save");


	/**
	 * Reference to the VirtualKanbanController, that every controller has
	 */
	private VirtualKanbanController virtualKanbanController;

	/**
	 * teh IOController constructor
	 * @param virtualKanbanController reference to the main-controller
	 */
	public IOController(VirtualKanbanController virtualKanbanController) {
		this.virtualKanbanController = virtualKanbanController;
	}

	/**
	 * loads the last state of the Program after launching VirtualKanban
	 *
	 * @throws IOException is thrown if an error occurs while loading
	 */
	public VirtualKanban load() throws IOException {
		if (SAVE_FILE.exists()) {
			try {
				ObjectInputStream stream = new ObjectInputStream(new FileInputStream(SAVE_FILE));
				VirtualKanban virtualKanban = (VirtualKanban) stream.readObject();
				stream.close();
				return virtualKanban;
			} catch (IOException exception) {
				throw new IOException("error loading file");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * saves the current state of the program when it gets closed
	 *
	 * @throws IOException is thrown if an error occurs while saving a file
	 */
	public void save() throws IOException {
		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
			stream.writeObject(virtualKanbanController.getVirtualKanban());
			stream.close();
		} catch (IOException ioex) {
			System.err.println("Fehler beim Speichern aufgetreten.");
			ioex.printStackTrace();
		}
	}

	/**
	 *exports all projects to a PDF
	 *
	 * @param dest destination file for the pdf
	 * @param projects list of projects which are exported
	 * @throws IOException occurs if FileOutputStream could not be created
	 * @throws DocumentException occurs if could not get instance of a PdfWriter
	 */
	public void exportAllTable(File dest,ArrayList<Project> projects) throws IOException, DocumentException {
		Document document = new Document(PageSize.A4,0,0,0,0 );
		PdfWriter.getInstance(document, new FileOutputStream(dest));
		document.open();

		document.setPageSize(PageSize.A4);
		document.newPage();

		for(Project project : projects ) {
			PdfPTable table = createPdfTable(project);
			document.newPage();
			document.add(table);
		}

		document.close();
	}

	/**
	 * exports a single project as PDF
	 *
	 * @param dest destination file for the pdf
	 * @param project project which is exported
	 * @throws IOException occurs if FileOutputStream could not be created
	 * @throws DocumentException occurs if could not get instance of a PdfWriter
	 */
	public void exportATable(File dest,Project project) throws IOException, DocumentException {
		Document document = new Document(PageSize.A4,0,0,0,0 );
		PdfWriter.getInstance(document, new FileOutputStream(dest));
		document.open();

		document.setPageSize(PageSize.A4);
		document.newPage();

		PdfPTable table = createPdfTable(project);
		document.add(table);
		document.close();
	}

	/**
	 * converts a project into a PdfPTable
	 *
	 * @param project the converted project
	 * @return a PdfPTable which contains the Kanban-Status of the project
	 */
	public PdfPTable createPdfTable(Project project) {
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100);
		table.setSpacingBefore(0f);
		table.setSpacingAfter(0f);
		PdfPCell cell = new PdfPCell(new Phrase("Project"+" "+project.getName()));
		cell.setColspan(8);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(06.0f);
		cell.setBackgroundColor(new BaseColor(144, 221, 8));
		table.addCell(cell);
		//projects = virtualKanbanController.getVirtualKanban().getProject() ;
		int longestStage = findLongestStage(project);
		for(StageList stageList : project.getStageList()) {
			PdfPTable tableColumn = new PdfPTable(1);
			//table_new.addCell(stageList.getStage().toString());
			tableColumn.addCell(getStageName(stageList));
			int columnsFilled = 0;
			for (Task task : stageList.getTask()) {
				tableColumn.addCell(task.getName());
				columnsFilled++;
			}
			while(columnsFilled<longestStage) {
				tableColumn.addCell("");
				columnsFilled++;
			}
			table.addCell(tableColumn);
		}
		return table;
	}

	/**
	 * searches for the stagelist with the most tasks and returns the count of tasks in that stageList
	 *
	 * @param proect project from which the longest stage is returned
	 * @return the highest number of tasks in one stage
	 */
	public int findLongestStage(Project proect) {
		int max = 0;
		for(StageList stageList : proect.getStageList()) {
			if(stageList.getTask().size()>max) {
				max = stageList.getTask().size();
			}
		}
		return max;
	}

	/**
	 * creates for every Stagelist one name as a String and returns that
	 *
	 * @param stageList list whose name is converted to a string
	 * @return a string of the name of a stage
	 */
	public String getStageName(StageList stageList) {
		if(stageList.getStage().equals(Stage.NEW)) {
			return "Neu";
		}
		if(stageList.getStage().equals(Stage.ANALYSE_IN_PROGRESS)) {
			return "Ana. Arbeit";
		}
		if(stageList.getStage().equals(Stage.ANALYSE_FINISHED)) {
			return "Ana. fertig";
		}
		if(stageList.getStage().equals(Stage.IMPLEMENTATION_IN_PROGRESS)) {
			return "Impl. Arbeit";
		}
		if(stageList.getStage().equals(Stage.IMPLEMENTATION_FINISHED)) {
			return "Impl. fertig";
		}
		if(stageList.getStage().equals(Stage.TEST_IN_PROGRESS)) {
			return "Test Arbeit";
		}
		if(stageList.getStage().equals(Stage.TEST_FINISHED)) {
			return "Test fertig";
		}
		else return "Abgeschl.";

	}
}






