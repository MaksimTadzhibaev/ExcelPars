package ru.tadzh.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Service
public class ExcelColorService {

    public void pointCell() throws IOException {
        //взял файл
        File file = new File("excel/studentList.xlsx"); // заменить путь на нужный, возможно передать его сюда
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        //взял лист
        XSSFSheet sheet = workbook.getSheetAt(0);
        //Шрифт и размер
        XSSFFont font = workbook.createFont();
        font.setFontName ("Times New Roman");
        font.setFontHeightInPoints ((short) 12);
        //задал стиль RED
        XSSFCellStyle styleRed = workbook.createCellStyle();
        styleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        styleRed.setFillPattern(CellStyle.ALIGN_CENTER);
        styleRed.setBorderBottom(BorderStyle.THIN);
        styleRed.setBorderLeft(BorderStyle.THIN);
        styleRed.setBorderRight(BorderStyle.THIN);
        styleRed.setBorderTop(BorderStyle.THIN);
        styleRed.setAlignment(HorizontalAlignment.CENTER);
        styleRed.setFont(font);
        styleRed.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 0, 0), new DefaultIndexedColorMap()));
        //задал стиль GREEN
        XSSFCellStyle styleGreen = workbook.createCellStyle();
        styleGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        styleGreen.setFillPattern(CellStyle.ALIGN_CENTER);
        styleGreen.setBorderBottom(BorderStyle.THIN);
        styleGreen.setBorderLeft(BorderStyle.THIN);
        styleGreen.setBorderRight(BorderStyle.THIN);
        styleGreen.setBorderTop(BorderStyle.THIN);
        styleGreen.setAlignment(HorizontalAlignment.CENTER);
        styleGreen.setFont(font);
        styleGreen.setFillForegroundColor(new XSSFColor(new java.awt.Color(0, 255, 12), new DefaultIndexedColorMap()));
        //задал стиль YELLOW
        XSSFCellStyle styleYellow = workbook.createCellStyle();
        styleYellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        styleYellow.setFillPattern(CellStyle.ALIGN_CENTER);
        styleYellow.setBorderBottom(BorderStyle.THIN);
        styleYellow.setBorderLeft(BorderStyle.THIN);
        styleYellow.setBorderRight(BorderStyle.THIN);
        styleYellow.setBorderTop(BorderStyle.THIN);
        styleYellow.setAlignment(HorizontalAlignment.CENTER);
        styleYellow.setFont(font);
        styleYellow.setFillForegroundColor(new XSSFColor(new java.awt.Color(234, 192, 27), new DefaultIndexedColorMap()));
        //задал стиль YELLOW
        //поиск по всем ячейкам
        int a = 0;
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (getCellText(cell).equals("имя студента")) { // для BS "цвет строки"
                    a = cell.getColumnIndex();
                    System.out.println(a);
                    break;
                }
            }
        }
        for (Row row : sheet) {
            switch (getCellText(row.getCell(a))) {
                case "red":
                    for (int i = 0; i < a+2; i++) {
                        row.getCell(i).setCellStyle(styleRed);
                    }
                    break;
                case "green":
                    for (int i = 0; i < a+2; i++) {
                        row.getCell(i).setCellStyle(styleGreen);
                    }
                    break;
                case "yellow":
                    for (int i = 0; i < a+2; i++) {
                        row.getCell(i).setCellStyle(styleYellow);
                    }
                    break;
                default:
                    break;
            }
            //закрыл поток
            inputStream.close();

            //записал изменения
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
        }
    }

    //метод для проверки ячейки любого формата(перевод в текстовый)
    public String getCellText(Cell cell){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String result = "";
        switch (cell.getCellType()) {
            case STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result =  sdf.format(cell.getDateCellValue());
                } else {
                    result = Double.toString(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                result = Boolean.toString(cell.getBooleanCellValue());
                break;
            case FORMULA:
                result = cell.getCellFormula().toString();
                break;
            default:
                break;
        }
        return result;
    }
}
