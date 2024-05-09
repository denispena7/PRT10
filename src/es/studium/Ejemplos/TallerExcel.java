package es.studium.Ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TallerExcel
{
	public static void main(String[] args)
	{
		String nombreArchivo="Inventario.xlsx";
		String rutaArchivo= "C:\\Ficheros Excel\\"+nombreArchivo;
		String hoja="Hoja1";
		XSSFWorkbook libro = new XSSFWorkbook();
		XSSFSheet hoja1 = libro.createSheet(hoja);
		// Cabeceras de la hoja de excel
		String [] header= new String[]{"Código", "Producto","Precio","Unidades"};
		// Contenido de la hoja de excel
		String [][] document= new String [][]{
			{"AP150","ACCESS POINT TP-LINK TL-WA901ND 450Mbps Wireless N 1RJ45 10-100 3Ant.","112.00","50"},
			{"RTP150","ROUTER TP-LINK TL-WR940ND 10-100Mbpps LAN WAN 2.4 - 2.4835Ghz","19.60","25"},
			{"TRT881","TARJETA DE RED TPLINK TL-WN881ND 300Mpbs Wire-N PCIExp.","10.68","15"},
			{"TRT881B","TARJETA DE RED TPLINK TL-WN881ND 300Mpbs Wire-N PCIExp.","10.68","15"},
			{"TR0","TARJETA DE RED TPLINK TL-WN881ND 300Mpbs Wire-N PCIExp.","10.68","15"}
		};
		// Poner en negrita la cabecera
		CellStyle style = libro.createCellStyle();
		XSSFFont font = libro.createFont();
		font.setBold(true);
		style.setFont(font);
		
		// Generar los datos para el fichero
		for (int i = 0; i <= document.length; i++)
		{
			XSSFRow row = hoja1.createRow(i); // Se crean las filas
			for (int j = 0; j <header.length; j++)
			{
				if (i==0)
				{ // Para la cabecera
					XSSFCell cell= row.createCell(j); // Se crean las celdas para la cabecera, junto con la posición
					cell.setCellStyle(style); // Se añade el style creado anteriormente
					cell.setCellValue(header[j]); // Se añade el contenido
				}
				else
				{ // Para el contenido
					XSSFCell cell= row.createCell(j); // Se crean las celdas para la cabecera, junto con la posición
					cell.setCellValue(document[i-1][j]); // Se añade el contenido
				}
			}
		}
		
		File file;
		file = new File(rutaArchivo);
		try (FileOutputStream fileOuS = new FileOutputStream(file))
		{
			if (file.exists())
			{ // Si el archivo ya existe, se elimina
				file.delete();
				System.out.println("Archivo eliminado");
			}
			// Se guarda la información en el fichero
			libro.write(fileOuS);
			fileOuS.flush();
			fileOuS.close();
			System.out.println("Archivo Creado");
			libro.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("El archivo no se encuentra o está en uso...");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}