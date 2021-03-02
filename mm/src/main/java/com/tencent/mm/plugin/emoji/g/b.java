package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class b {
    public static ArrayList<ait> amR(String str) {
        AppMethodBeat.i(108731);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            AppMethodBeat.o(108731);
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("EmojiMd5");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList<ait> arrayList = new ArrayList<>();
                int length = elementsByTagName.getLength();
                for (int i2 = 0; i2 < length; i2++) {
                    Node item = elementsByTagName.item(i2);
                    ait ait = new ait();
                    String lowerCase = item.getTextContent().toLowerCase();
                    NamedNodeMap attributes = item.getAttributes();
                    Node namedItem = attributes.getNamedItem("thumburl");
                    if (namedItem != null) {
                        ait.ThumbUrl = namedItem.getNodeValue();
                    }
                    Node namedItem2 = attributes.getNamedItem("cdnurl");
                    if (namedItem2 != null) {
                        ait.Url = namedItem2.getNodeValue();
                    }
                    Node namedItem3 = attributes.getNamedItem("productid");
                    if (namedItem3 != null) {
                        ait.ProductID = namedItem3.getNodeValue();
                    }
                    Node namedItem4 = attributes.getNamedItem("designerid");
                    if (namedItem4 != null) {
                        ait.Lsl = namedItem4.getNodeValue();
                    }
                    Node namedItem5 = attributes.getNamedItem("aeskey");
                    if (namedItem5 != null) {
                        ait.AesKey = namedItem5.getNodeValue();
                    }
                    Node namedItem6 = attributes.getNamedItem("encrypturl");
                    if (namedItem6 != null) {
                        ait.EncryptUrl = namedItem6.getNodeValue();
                    }
                    Node namedItem7 = attributes.getNamedItem("activityid");
                    if (namedItem7 != null) {
                        ait.ActivityID = namedItem7.getNodeValue();
                    }
                    ait.Md5 = lowerCase;
                    arrayList.add(ait);
                }
                AppMethodBeat.o(108731);
                return arrayList;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", e2.toString());
        }
        AppMethodBeat.o(108731);
        return null;
    }

    public static ArrayList<String> amS(String str) {
        AppMethodBeat.i(108732);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            AppMethodBeat.o(108732);
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("ProductID");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                int length = elementsByTagName.getLength();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(elementsByTagName.item(i2).getTextContent());
                }
                AppMethodBeat.o(108732);
                return arrayList;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", e2.toString());
        }
        AppMethodBeat.o(108732);
        return null;
    }
}
