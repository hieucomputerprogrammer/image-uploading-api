package io.hieu.imagesapi.service.impl;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import io.hieu.imagesapi.dto.model.ImageDto;
import io.hieu.imagesapi.service.ExportToPdfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ExportToPdfServiceImpl implements ExportToPdfService {
    private final Logger logger = LoggerFactory.getLogger(ExportToPdfServiceImpl.class);
    private List<ImageDto> imageDtos;

    public ExportToPdfServiceImpl(List<ImageDto> imageDtos) {
        this.imageDtos = imageDtos;
    }

    @Override
    public void writeTableHeader(PdfPTable pdfPTable) {
        this.logger.info("INFO: Export to PDF Service - writeTableHeader() method called.");
        this.logger.debug("DEBUG: Export to PDF Service - writeTableHeader() method called.");
        this.logger.trace("TRACE: Export to PDF Service - writeTableHeader() method called.");
        this.logger.warn("WARN: Export to PDF Service - writeTableHeader() method called.");
        this.logger.error("ERROR: Export to PDF Service - writeTableHeader() method called.");

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.ORANGE);
        cell.setPadding(8);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Image ID", font));
        pdfPTable.addCell(cell);
        cell.setPhrase(new Phrase("Image as Base64 Format", font));
        pdfPTable.addCell(cell);
        cell.setPhrase(new Phrase("Image Title", font));
        pdfPTable.addCell(cell);
        cell.setPhrase(new Phrase("Owner's Name", font));
        pdfPTable.addCell(cell);
        cell.setPhrase(new Phrase("Owner's Phone Number", font));
        pdfPTable.addCell(cell);
        cell.setPhrase(new Phrase("Owner's E-Mail", font));
        pdfPTable.addCell(cell);
    }

    @Override
    public void writeTableData(PdfPTable pdfPTable) {
        this.logger.info("INFO: Export to PDF Service - writeTableData() method called.");
        this.logger.debug("DEBUG: Export to PDF Service - writeTableData() method called.");
        this.logger.trace("TRACE: Export to PDF Service - writeTableData() method called.");
        this.logger.warn("WARN: Export to PDF Service - writeTableData() method called.");
        this.logger.error("ERROR: Export to PDF Service - writeTableData() method called.");

        for (ImageDto imageDto : imageDtos) {
            pdfPTable.addCell(String.valueOf(imageDto.getId()));
            pdfPTable.addCell(String.valueOf(imageDto.getImageAsBase64Format()));
            pdfPTable.addCell(String.valueOf(imageDto.getImageTitle()));
            pdfPTable.addCell(String.valueOf(imageDto.getOwnerName()));
            pdfPTable.addCell(String.valueOf(imageDto.getOwnerPhoneNumber()));
            pdfPTable.addCell(String.valueOf(imageDto.getOwnerEmail()));
        }
    }

    @Override
    public void export(HttpServletResponse httpServletResponse) throws DocumentException, IOException {
        this.logger.info("INFO: Export to PDF Service - export() method called.");
        this.logger.debug("DEBUG: Export to PDF Service - export() method called.");
        this.logger.trace("TRACE: Export to PDF Service - export() method called.");
        this.logger.warn("WARN: Export to PDF Service - export() method called.");
        this.logger.error("ERROR: Export to PDF Service - export() method called.");

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, httpServletResponse.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(40);
        font.setColor(Color.BLUE);

        Paragraph paragraph = new Paragraph("IMAGES", font);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {10.0f, 20.0f, 20.0f, 15.0f, 20.0f, 25.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }
}