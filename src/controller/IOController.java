package controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import model.*;

import java.io.*;
import java.util.ArrayList;
//import sandbox.WrapToTest;

public class IOController {

	/**
	 * the file in which the status is saved
	 */
	private static final File SAVE_File = new File("save");
	private static final File src = new File("KanbanBoard.pdf");

	/**
	 * the file in which the PDF exports are saved
	 */
	//private static final File DEST = new File("KanbanBoard");

	/**
	 * Reference to the VirtualKanbanController, that every controller has
	 */
	private VirtualKanbanController virtualKanbanController;

	public IOController(VirtualKanbanController virtualKanbanController) {
		this.virtualKanbanController = virtualKanbanController;
	}

	/**
	 * loads the last state of the Program after launching VirtualKanban
	 *
	 * @throws IOException is thrown if an error occurs while loading
	 */
	public VirtualKanban load() throws IOException {
		if (SAVE_File.exists()) {
			try {
				ObjectInputStream stream = new ObjectInputStream(new FileInputStream(SAVE_File));
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
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(SAVE_File));
			stream.writeObject(virtualKanbanController.getVirtualKanban());
			stream.close();
		} catch (IOException ioex) {
			System.err.println("Fehler beim Speichern aufgetreten.");
			ioex.printStackTrace();
		}
	}
	public void exportAllTable(File dest,Project [] projects) throws IOException, DocumentException {
		for(Project project : projects ) {
			exportATable(dest, project);
		}
	}
	public void exportATable(File dest,Project project) throws IOException, DocumentException {
		Document document = new Document(PageSize.A4,0,0,0,0 );
		PdfWriter.getInstance(document, new FileOutputStream(dest));
		document.open();

		document.setPageSize(PageSize.A4);
		document.newPage();

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
			PdfPTable table_column = new PdfPTable(1);
			//table_new.addCell(stageList.getStage().toString());
			table_column.addCell(getStageName(stageList));
			int columnsFilled = 0;
			for (Task task : stageList.getTask()) {
				table_column.addCell(task.getName());
				columnsFilled++;
			}
			while(columnsFilled<longestStage) {
				table_column.addCell("");
				columnsFilled++;
			}
			table.addCell(table_column);
		}

		document.add(table);
		document.close();
	}

	public int findLongestStage(Project proect) {
		int max = 0;
		for(StageList stageList : proect.getStageList()) {
			if(stageList.getTask().size()>max) {
				max = stageList.getTask().size();
			}
		}
		return max;
	}

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






