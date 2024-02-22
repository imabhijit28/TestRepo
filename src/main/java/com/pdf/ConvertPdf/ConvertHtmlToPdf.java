package com.pdf.ConvertPdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

public class ConvertHtmlToPdf {

	 Document document = new Document(PageSize.LEGAL_LANDSCAPE.rotate(), 10, 10, 20, 60);
     PdfWriter writer = PdfWriter.getInstance(document,
             new FileOutputStream("C:\\Users\\Md.Alam\\Desktop\\test78_wfReport.pdf"));
     writer.setInitialLeading(12.5f);
     document.open();
     CSSResolver cssResolver = XMLWorkerHelper.getInstance().getDefaultCssResolver(false);
     HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
     htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
     htmlContext.autoBookmark(false);
     PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
     HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
     CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
     XMLWorker worker = new XMLWorker(css, true);
     XMLParser p = new XMLParser(worker);
     p.parse(new FileInputStream("C:\\Users\\Md.Alam\\Desktop\\test78_wfReport.html"));
     System.out.println("parsed");
}
