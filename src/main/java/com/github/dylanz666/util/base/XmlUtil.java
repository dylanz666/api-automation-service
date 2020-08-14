package com.github.dylanz666.util.base;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
@Service
public class XmlUtil {
    public static String getElementText(String xml, String path) throws Exception {
        Element element = getElement(xml, path);
        return element.getText();
    }

    public static List getElements(String xml, String path) throws Exception {
        Element element = getElement(xml, path);
        return element.elements();
    }

    public static List<Element> filterSubElements(List elements, String filterNodeName) {
        List<Element> filtered = new ArrayList<>();
        for (Iterator it = elements.iterator(); it.hasNext(); ) {
            Element element = (Element) it.next();
            String elementName = element.getName();
            if (filterNodeName.equals(elementName)) {
                filtered.add(element);
            }
        }
        return filtered;
    }

    public static List<Element> removeSubElement(List elements, String subNodeName) {
        List<Element> handledList = new ArrayList<>();
        for (Iterator it = elements.iterator(); it.hasNext(); ) {
            Element element = (Element) it.next();

            List e = element.elements();
            for (Iterator newIt = e.iterator(); newIt.hasNext(); ) {
                Element subElement = (Element) newIt.next();
                if (subNodeName.equals(subElement.getName())) {
                    element.remove(subElement);
                }
            }
            handledList.add(element);
        }
        return handledList;
    }

    public static Element getElement(String xml, String path) throws Exception {
        Document document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        String[] pathArray = path.split("\\.");

        Element element = root;
        for (int i = 0; i < pathArray.length; i++) {
            if (pathArray[i].contains("[") && pathArray[i].contains("]")) {
                int index = Integer.parseInt(pathArray[i].substring(pathArray[i].indexOf("[") + 1, pathArray[i].length() - 1));
                pathArray[i] = pathArray[i].substring(0, pathArray[i].indexOf("["));
                element = element.element(pathArray[i]);
                List list = element.elements();
                element = (Element) list.get(index);
                continue;
            }
            element = element.element(pathArray[i]);
        }
        if (null == element) {
            throw new Exception("No elements found in XML!");
        }
        return element;
    }
}
