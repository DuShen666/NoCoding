package org.ds.nocoding.xml;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XMLDocumentHolder implements DocumentHolder {

    private final Map<String, Document> docs = new HashMap<>();

    @Override
    public Document getDocument(String filePath) {
        Document doc = this.docs.get(filePath);//用HashMap先根据路径获取文档
        if (doc == null) {
            this.docs.put(filePath, readDocument(filePath)); //如果为空，把路径和文档放进去
        }
        return this.docs.get(filePath);
    }

    private Document readDocument(String filePath) {
        Document doc = null;
        try {
            SAXReader reader = new SAXReader(true);//借用dom4j的解析器
            File xmlFile = new File(filePath); //根据路径创建文件

            doc = reader.read(xmlFile);//用dom4j自带的reader读取去读返回一个Document
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }
}
