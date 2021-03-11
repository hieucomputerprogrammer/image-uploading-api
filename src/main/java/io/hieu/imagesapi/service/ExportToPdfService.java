package io.hieu.imagesapi.service;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ExportToPdfService {
    void writeTableHeader(PdfPTable table);

    void writeTableData(PdfPTable table);

    void export(HttpServletResponse response) throws DocumentException, IOException;
}