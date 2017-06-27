package com.testvagrant.stepdefs.utils;


import com.testvagrant.stepdefs.builders.ElementBuilder;
import com.testvagrant.stepdefs.exceptions.SheetNotFoundException;
import com.testvagrant.stepdefs.finder.App;
import com.testvagrant.stepdefs.finder.Element;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelToObjectConverter {

    private String workBookName;
    private Workbook workbook;
    private Sheet sheet;
    private String extension=null;
    private static Map<String,List<Element>> elementsMap = new HashMap<>();
    private static final String xLFileLocation =  System.getProperty("user.dir") + "/src/test/resources/elements/";
    private ExcelToObjectConverter(String workBookName) {
        this.workBookName = workBookName;
    }

    public static ExcelToObjectConverter converter(String workBookName) {
        return new ExcelToObjectConverter(workBookName);
    }

    public ExcelToObjectConverter withExtension(String extension) {
        this.extension = extension;
        return this;
    }

    public App convert(String sheetName) throws IOException, SheetNotFoundException {
        if(elementsMap.size()==0) {
            workbook = new XSSFWorkbook(new FileInputStream(new File(xLFileLocation+workBookName+getExtension())));
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            while (sheetIterator.hasNext()) {
                sheet = sheetIterator.next();
                List<Element> elements = getElements(sheet);
                elementsMap.put(sheet.getSheetName(),elements);
            }
        }
        return getAppFromSheet(sheetName);
    }

    private App getAppFromSheet(String sheetName) throws IOException, SheetNotFoundException {
        App app = new App();
        List<Element> elements = elementsMap.get(sheetName);
        if(elements==null) {
            throw new SheetNotFoundException(sheetName,workBookName+getExtension());
        }
        app.setElements(elements);
        return app;
    }

    private List<Element> getElements(Sheet sheet) {
        Iterator<Row> rows = sheet.rowIterator();
        List<Element>  elements = new ArrayList<>();
        while (rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Map<String,String> tempCellMap = new HashMap<>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                tempCellMap.put(getColomnName(cell.getColumnIndex()),cell.getStringCellValue());
             }
             Element element = new ElementBuilder().withElementName(tempCellMap.get("elementName"))
                     .withIdentifier(tempCellMap.get("identifier"))
                     .withValue(tempCellMap.get("value"))
                     .withWaitFor(tempCellMap.get("waitFor"))
                     .withReferTo(tempCellMap.get("referTo"))
                     .build();
            elements.add(element);
        }
        if(elements.size()>0) {
            elements.remove(0);
        }
        return elements;
    }


    private String getColomnName(int index) {
        Row row  = sheet.getRow(0);
        Cell cell = row.getCell(index);
        return cell.getStringCellValue();
    }

    private String getExtension() {
        return extension != null ? extension : ".xlsx";
    }
}
