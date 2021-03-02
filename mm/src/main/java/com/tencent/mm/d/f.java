package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class f {
    private static boolean djs = false;

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e.CTRL_INDEX);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e.CTRL_INDEX);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e.CTRL_INDEX);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fb, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084 A[ExcHandler: SAXException (e org.xml.sax.SAXException), Splitter:B:19:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0089 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:19:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:19:0x0061] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> P(java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 257
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.d.f.P(java.lang.String, java.lang.String):java.util.Map");
    }

    private static void a(Map<String, String> map, String str, String str2, Node node, int i2) {
        String str3;
        AppMethodBeat.i(968);
        if (node.getNodeName().equals("#text")) {
            map.put(str, node.getNodeValue());
            map.put(str2, node.getNodeValue());
            AppMethodBeat.o(968);
        } else if (node.getNodeName().equals("#cdata-section")) {
            map.put(str, node.getNodeValue());
            map.put(str2, node.getNodeValue());
            AppMethodBeat.o(968);
        } else {
            String str4 = String.valueOf(str) + "." + node.getNodeName();
            String str5 = String.valueOf(str2) + "." + node.getNodeName();
            if (i2 > 0) {
                str4 = String.valueOf(str4) + i2;
                map.put(str4, node.getNodeValue());
                String str6 = String.valueOf(str5) + "#" + i2;
                map.put(str6, node.getNodeValue());
                str3 = str6;
            } else {
                map.put(str4, node.getNodeValue());
                map.put(str5, node.getNodeValue());
                str3 = str5;
            }
            NamedNodeMap attributes = node.getAttributes();
            if (attributes != null) {
                for (int i3 = 0; i3 < attributes.getLength(); i3++) {
                    Node item = attributes.item(i3);
                    map.put(String.valueOf(str4) + ".$" + item.getNodeName(), item.getNodeValue());
                    map.put(String.valueOf(str3) + ".$" + item.getNodeName(), item.getNodeValue());
                }
            }
            HashMap hashMap = new HashMap();
            NodeList childNodes = node.getChildNodes();
            for (int i4 = 0; i4 < childNodes.getLength(); i4++) {
                Node item2 = childNodes.item(i4);
                Integer num = (Integer) hashMap.get(item2.getNodeName());
                int intValue = num == null ? 0 : num.intValue();
                a(map, str4, str3, item2, intValue);
                hashMap.put(item2.getNodeName(), Integer.valueOf(intValue + 1));
            }
            AppMethodBeat.o(968);
        }
    }

    private static void q(Map<String, String> map) {
        AppMethodBeat.i(969);
        if (map.size() <= 0) {
            System.err.println("empty values");
            AppMethodBeat.o(969);
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.err.println("key=" + entry.getKey() + " value=" + entry.getValue());
        }
        AppMethodBeat.o(969);
    }
}
