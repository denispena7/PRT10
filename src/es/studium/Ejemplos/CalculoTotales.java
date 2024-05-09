package es.studium.Ejemplos;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CalculoTotales
{
	public static void main(String[] args)
	{
		String nombreArchivo = "Inventario.xlsx";
		String rutaArchivo = "C:\\Ficheros Excel\\"+nombreArchivo;
		Double total = 0.0, subtotal, aux;
		int contador;
		boolean cabeceras = true;
		
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
				contador = 0;
				aux = 0.0;
				subtotal = 0.0;
				// Se recorre cada celda de cada fila del bucle anterior
				while (cellIterator.hasNext())
				{
					// Se obtiene la celda en específico y se muestra
					cell = cellIterator.next();
					System.out.print(cell.getStringCellValue()+" | ");
					if(!cabeceras)
					{
						switch(contador)
						{
						case 2:
							aux =
							Double.parseDouble(cell.getStringCellValue()); // Cogemos el precio
							break;
						case 3:
							subtotal =
							aux*Integer.parseInt(cell.getStringCellValue());
							break;
						}
					}
					contador++;
					total += subtotal;
				}
				if(cabeceras)
				{
					System.out.println("Subtotal");
				}
				else
				{
					System.out.printf("%.2f €",subtotal);
					System.out.println();
				}
				cabeceras = false;
			}
			System.out.printf("Total inventario = %.2f €",total);
			libro.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}