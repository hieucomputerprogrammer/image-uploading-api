package io.hieu.imagesapi.service.impl;

import io.hieu.imagesapi.dto.model.ImageDto;
import io.hieu.imagesapi.service.ExportToMsExcelService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ExportToMsExcelServiceImpl implements ExportToMsExcelService {
    private final Logger logger = LoggerFactory.getLogger(ExportToPdfServiceImpl.class);
    private XSSFWorkbook xssWorkbook;
    private XSSFSheet xssfSheet;
    private List<ImageDto> imageDtos;

    public ExportToMsExcelServiceImpl(List<ImageDto> imageDtos) {
        this.imageDtos = imageDtos;
        this.xssWorkbook = new XSSFWorkbook();
    }

    @Override
    public void writeHeaderLine() {
        this.logger.info("INFO: Export to MS Excel Service - writeHeaderLine() method called.");
        this.logger.debug("DEBUG: Export to MS Excel Service - writeHeaderLine() method called.");
        this.logger.trace("TRACE: Export to MS Excel Service - writeHeaderLine() method called.");
        this.logger.warn("WARN: Export to MS Excel Service - writeHeaderLine() method called.");
        this.logger.error("ERROR: Export to MS Excel Service - writeHeaderLine() method called.");

        this.xssfSheet = this.xssWorkbook.createSheet("Images");
        Row row = this.xssfSheet.createRow(0);

        CellStyle style = this.xssWorkbook.createCellStyle();
        XSSFFont font = this.xssWorkbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Image ID", style);
        createCell(row, 1, "Image as Base64 Format", style);
        createCell(row, 2, "Image Title", style);
        createCell(row, 3, "Owner Name", style);
        createCell(row, 4, "Owner Phone Number", style);
        createCell(row, 5, "Owner E-Mail", style);
    }

    @Override
    public void createCell(Row row, int columnCount, Object value, CellStyle style) {
        this.logger.info("INFO: Export to MS Excel Service - createCell() method called.");
        this.logger.debug("DEBUG: Export to MS Excel Service - createCell() method called.");
        this.logger.trace("TRACE: Export to MS Excel Service - createCell() method called.");
        this.logger.warn("WARN: Export to MS Excel Service - createCell() method called.");
        this.logger.error("ERROR: Export to MS Excel Service - createCell() method called.");

        this.xssfSheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    @Override
    public void writeDataLines() {
        this.logger.info("INFO: Export to MS Excel Service - writeDataLines() method called.");
        this.logger.debug("DEBUG: Export to MS Excel Service - writeDataLines() method called.");
        this.logger.trace("TRACE: Export to MS Excel Service - writeDataLines() method called.");
        this.logger.warn("WARN: Export to MS Excel Service - writeDataLines() method called.");
        this.logger.error("ERROR: Export to MS Excel Service - writeDataLines() method called.");

        int rowCount = 1;

        CellStyle style = this.xssWorkbook.createCellStyle();
        XSSFFont font = this.xssWorkbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (ImageDto imageDto : this.imageDtos) {
            Row row = this.xssfSheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, imageDto.getId().toString(), style);
            createCell(row, columnCount++, imageDto.getImageAsBase64Format().toString(), style);
            createCell(row, columnCount++, imageDto.getImageTitle(), style);
            createCell(row, columnCount++, imageDto.getOwnerName(), style);
            createCell(row, columnCount++, imageDto.getOwnerPhoneNumber(), style);
            createCell(row, columnCount++, imageDto.getOwnerEmail(), style);
        }
    }

    @Override
    public void export(HttpServletResponse httpServletResponse) throws IOException {
        this.logger.info("INFO: Export to MS Excel Service - export() method called.");
        this.logger.debug("DEBUG: Export to MS Excel Service - export() method called.");
        this.logger.trace("TRACE: Export to MS Excel Service - export() method called.");
        this.logger.warn("WARN: Export to MS Excel Service - export() method called.");
        this.logger.error("ERROR: Export to MS Excel Service - export() method called.");

        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        this.xssWorkbook.write(outputStream);
        this.xssWorkbook.close();

        outputStream.close();
    }
}