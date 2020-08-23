package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.*;

import java.io.*;
import java.lang.UnsupportedOperationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * controller to save and load the programms status and export PDF's
 */
public class IOController {

	/**
	 * the file in which the status is saved
	 */
	private static final File SAVE_File = new File("save");

	/**
	 * the file in which the PDF exports are saved
	 */
	private static final File Table_PDF = new File("?");

    /**
 	 * Reference to the VirtualKanbanController, that every controller has
 	 */
    private VirtualKanbanController virtualKanbanController;

    public IOController(VirtualKanbanController virtualKanbanController) {
    	this.virtualKanbanController =  virtualKanbanController ;
    }

    /**
 	 *
 	 * loads the last state of the Program after launching VirtualKanban
 	 * @throws IOException
 	 *	 	 	is thrown if an error occurs while loading
 	 */
    public VirtualKanban load() throws IOException{
		if (SAVE_File.exists()) {
			try {
				ObjectInputStream stream = new ObjectInputStream(new FileInputStream(SAVE_File));
				VirtualKanban virtualKanban = (VirtualKanban) stream.readObject();
				stream.close();
				return virtualKanban;
			} catch(IOException exception) {
				throw new IOException("error loading file");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

    /**
 	 *
 	 * saves the current state of the program when it gets closed
 	 * @throws IOException
 	 *	 	 	is thrown if an error occurs while saving a file
 	 */
    public void save() throws IOException {
		try{
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(SAVE_File));
			stream.writeObject(virtualKanbanController.getVirtualKanban());
			stream.close();
		} catch (IOException ioex ) {
			System.err.println("Fehler beim Speichern aufgetreten.");
			ioex.printStackTrace();
		}
    }

	/***
	 *
	 * @param allproject is the list of all the project of the program
	 * @throws FileNotFoundException will be call if a File can't be found
	 * @throws DocumentException will be call if there's a problem with this document
	 */
	public void exportPdf(ArrayList<Project> allproject) throws FileNotFoundException, DocumentException {
    	Document document = new Document() ;
    	FileOutputStream place =  new FileOutputStream(Table_PDF) ;/* is this the correct DESTINATION ? */
    	PdfWriter.getInstance(document,place);

		for(Project x : allproject) {
			document.open();
			Paragraph intro = new Paragraph(x.getName());
			Paragraph space = new Paragraph("  ");
			PdfPTable table = new PdfPTable(8);
			// creating cells for the table
			PdfPCell c1 = new PdfPCell(new Paragraph(Stage.NEW.name()));
			PdfPCell c2 = new PdfPCell(new Paragraph(Stage.ANALYSE_IN_PROGRESS.name()));
			PdfPCell c3 = new PdfPCell(new Paragraph(Stage.ANALYSE_FINISHED.name()));
			PdfPCell c4 = new PdfPCell(new Paragraph(Stage.IMPLEMENTATION_IN_PROGRESS.name()));
			PdfPCell c5 = new PdfPCell(new Paragraph(Stage.IMPLEMENTATION_FINISHED.name()));
			PdfPCell c6 = new PdfPCell(new Paragraph(Stage.TEST_IN_PROGRESS.name()));
			PdfPCell c7 = new PdfPCell(new Paragraph(Stage.TEST_FINISHED.name()));
			PdfPCell c8 = new PdfPCell(new Paragraph(Stage.COMPLETED.name()));
			//add cells to the table
			PdfPCell [] CELS ={c1,c2,c3,c4,c5,c6,c7,c8};
			int i= CELS.length;
			while (i>0){table.addCell(CELS[i--]);}
			StageList stgl1 = new StageList(Stage.NEW);
			StageList stgl2 = new StageList(Stage.ANALYSE_IN_PROGRESS);
			StageList stgl3 = new StageList(Stage.ANALYSE_FINISHED);
			StageList stgl4 = new StageList(Stage.IMPLEMENTATION_IN_PROGRESS);
			StageList stgl5 = new StageList(Stage.IMPLEMENTATION_FINISHED);
			StageList stgl6 = new StageList(Stage.TEST_IN_PROGRESS);
			StageList stgl7 = new StageList(Stage.TEST_FINISHED);
			StageList stgl8 = new StageList(Stage.COMPLETED);
			int j=0;
			int index = 0 ;
			StageList [] STGL = {stgl1,stgl2,stgl3,stgl4,stgl5,stgl6,stgl7,stgl8};
			// add in the table all task that are in a Stage
			for(StageList s : STGL ) {
				ArrayList<Task> TaskForAStageList = s.getTask();
				for (Task t : TaskForAStageList) {
					CELS[j] = new PdfPCell(new Paragraph(t.toString()));
					//add the task t to the table
					table.addCell(CELS[j]);
				}
				j++;
			}
			// now adding the Object to the Document :
			document.add(intro);
			document.add(space);
			document.add(table);
			//closing the document with
			document.close();
		}
	}

	/***
	 *
	 * @param project , i'm doing a table of this project
	 * @throws FileNotFoundException will be call if a File can't be found
	 * @throws DocumentException will be call if there's a problem with this document
	 */
	public void exportPdf(Project project) throws FileNotFoundException, DocumentException {
        Document document = new Document() ;
		FileOutputStream place =  new FileOutputStream(Table_PDF) ;/* is this the correct destination ? */
		PdfWriter.getInstance(document,place);
		document.open();
		Paragraph intro = new Paragraph(project.getName());
		Paragraph space = new Paragraph("  ");
		PdfPTable table = new PdfPTable(8);
		// creating cells for the table
		PdfPCell c1 = new PdfPCell(new Paragraph(Stage.NEW.name()));
		PdfPCell c2 = new PdfPCell(new Paragraph(Stage.ANALYSE_IN_PROGRESS.name()));
		PdfPCell c3 = new PdfPCell(new Paragraph(Stage.ANALYSE_FINISHED.name()));
		PdfPCell c4 = new PdfPCell(new Paragraph(Stage.IMPLEMENTATION_IN_PROGRESS.name()));
		PdfPCell c5 = new PdfPCell(new Paragraph(Stage.IMPLEMENTATION_FINISHED.name()));
		PdfPCell c6 = new PdfPCell(new Paragraph(Stage.TEST_IN_PROGRESS.name()));
		PdfPCell c7 = new PdfPCell(new Paragraph(Stage.TEST_FINISHED.name()));
		PdfPCell c8 = new PdfPCell(new Paragraph(Stage.COMPLETED.name()));
		//add cells to the table
		PdfPCell [] CELS ={c1,c2,c3,c4,c5,c6,c7,c8};
		int i= CELS.length;
		while (i>0){table.addCell(CELS[i--]);}
		StageList stgl1 = new StageList(Stage.NEW);
		StageList stgl2 = new StageList(Stage.ANALYSE_IN_PROGRESS);
		StageList stgl3 = new StageList(Stage.ANALYSE_FINISHED);
		StageList stgl4 = new StageList(Stage.IMPLEMENTATION_IN_PROGRESS);
		StageList stgl5 = new StageList(Stage.IMPLEMENTATION_FINISHED);
		StageList stgl6 = new StageList(Stage.TEST_IN_PROGRESS);
		StageList stgl7 = new StageList(Stage.TEST_FINISHED);
		StageList stgl8 = new StageList(Stage.COMPLETED);
		int j=0;
		int index = 0 ;
		StageList [] STGL = {stgl1,stgl2,stgl3,stgl4,stgl5,stgl6,stgl7,stgl8};
		// add in the table all task that are in a Stage
		for(StageList s : STGL ) {
			ArrayList<Task> TaskForAStageList = s.getTask();
			for (Task t : TaskForAStageList) {
				CELS[j] = new PdfPCell(new Paragraph(t.toString()));
				//add the task t to the table
				table.addCell(CELS[j]);
			}
			j++;
		}
		// now adding the Object to the Document :
		document.add(intro);
		document.add(space);
		document.add(table);
		//closing the document with
		document.close();
	}
}
