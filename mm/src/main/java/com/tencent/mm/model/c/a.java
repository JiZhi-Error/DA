package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class a {
    private static DocumentBuilder iHe = null;

    /* renamed from: com.tencent.mm.model.c.a$a  reason: collision with other inner class name */
    public static class C0444a {
        public List<c> iHf = new LinkedList();
        public List<com.tencent.mm.storage.a> iHg = new LinkedList();

        public C0444a() {
            AppMethodBeat.i(153104);
            AppMethodBeat.o(153104);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0184, code lost:
        if (r7.field_startTime == 0) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01b3, code lost:
        if (r7.field_endTime == 0) goto L_0x01b5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0326 A[LOOP:2: B:114:0x0320->B:116:0x0326, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.model.c.a.C0444a Ld(java.lang.String r21) {
        /*
        // Method dump skipped, instructions count: 884
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.c.a.Ld(java.lang.String):com.tencent.mm.model.c.a$a");
    }

    public static Map<String, String> Le(String str) {
        AppMethodBeat.i(153106);
        HashMap hashMap = new HashMap();
        Element Lf = Lf(str);
        if (Lf == null) {
            Log.e("MicroMsg.ABTestParser", "Raw XML string parsing failed, xml: %s", str);
            AppMethodBeat.o(153106);
            return hashMap;
        }
        NodeList elementsByTagName = Lf.getElementsByTagName("args");
        if (elementsByTagName.getLength() > 0) {
            NodeList childNodes = elementsByTagName.item(0).getChildNodes();
            for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                Node item = childNodes.item(i2);
                if (item.getNodeType() == 1 && item.getNodeName().equals("arg")) {
                    NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("key");
                    NodeList elementsByTagName3 = ((Element) item).getElementsByTagName("value");
                    if (!(elementsByTagName2.getLength() == 0 || elementsByTagName3.getLength() == 0)) {
                        hashMap.put(elementsByTagName2.item(0).getTextContent(), elementsByTagName3.item(0).getTextContent());
                    }
                }
            }
        }
        AppMethodBeat.o(153106);
        return hashMap;
    }

    private static Element Lf(String str) {
        DocumentBuilder newDocumentBuilder;
        AppMethodBeat.i(153107);
        try {
            InputSource inputSource = new InputSource(new ByteArrayInputStream(str.getBytes()));
            if (iHe != null) {
                newDocumentBuilder = iHe;
            } else {
                newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                iHe = newDocumentBuilder;
            }
            Document parse = newDocumentBuilder.parse(inputSource);
            parse.normalize();
            Element documentElement = parse.getDocumentElement();
            AppMethodBeat.o(153107);
            return documentElement;
        } catch (Exception e2) {
            Log.e("MicroMsg.ABTestParser", e2.toString());
            AppMethodBeat.o(153107);
            return null;
        }
    }

    private static String a(Node node) {
        AppMethodBeat.i(153108);
        StringWriter stringWriter = new StringWriter();
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (TransformerException e2) {
            Log.printErrStackTrace("MicroMsg.ABTestParser", e2, "nodeToString", new Object[0]);
        }
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(153108);
        return stringWriter2;
    }
}
