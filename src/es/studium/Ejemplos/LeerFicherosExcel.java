package es.studium.Ejemplos;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerFicherosExcel
{
	public static void main(String[] args)
	{
		String nombreArchivo = "Inventario.xlsx";
		String rutaArchivo = "C:\\Ficheros Excel\\"+nombreArchivo;
		
		try (FileInputStream file = new FileInputStream(new File(rutaArchivo)))
		{
			// Leer el archivo excel
			XSSFWorkbook libro = new XSSFWorkbook(file);
			// Obtener la hoja que se va leer
			XSSFSheet hoja = libro.getSheetAt(0);
			// Obtener todas las filas de la hoja excel
			Iterator<Row> rowIterator = hoja.iterator();
			Row row;
			// Se recorre cada fila hasta el final
			while (rowIterator.hasNext())
			{
				row = rowIterator.next();
				// Se obtienen las celdas por fila
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;
				// Se recorre cada celda de cada fila del bucle anterior
				while (cellIterator.hasNext())
				{
					// Se obtiene la celda en específico y se muestra
					cell = cellIterator.next();
					System.out.print(cell.getStringCellValue()+" | ");
				}
				System.out.println();
			}
			libro.close();
		}
		catch (Exception e)
		{
			e.getMessage();
		}
	}
}