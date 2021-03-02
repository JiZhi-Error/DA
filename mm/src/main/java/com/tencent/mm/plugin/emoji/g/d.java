package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class d {
    public static ArrayList<EmojiGroupInfo> amT(String str) {
        AppMethodBeat.i(108735);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] parse xml faild. xml is null.");
            AppMethodBeat.o(108735);
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("Emotion");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList<EmojiGroupInfo> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                    EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                    NodeList childNodes = elementsByTagName.item(i2).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i3 = 0; i3 < length; i3++) {
                        Node item = childNodes.item(i3);
                        if (item != null && item.getNodeName() != null && item.getNodeName().equals("ProductID")) {
                            String textContent = item.getTextContent();
                            Log.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] productId:%s", textContent);
                            emojiGroupInfo.field_productID = textContent;
                        } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("RecType")) {
                            String textContent2 = item.getTextContent();
                            Log.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] RecType:%s", textContent2);
                            emojiGroupInfo.field_recommandType = Integer.valueOf(textContent2).intValue();
                        } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("RecWord")) {
                            String textContent3 = item.getTextContent();
                            Log.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] recWord:%s", textContent3);
                            emojiGroupInfo.field_recommandWord = textContent3;
                        } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("Name")) {
                            String textContent4 = item.getTextContent();
                            Log.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] Name:%s", textContent4);
                            emojiGroupInfo.field_packName = textContent4;
                        } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("Panel")) {
                            String textContent5 = item.getTextContent();
                            Log.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] iconUrl:%s", textContent5);
                            emojiGroupInfo.field_packGrayIconUrl = textContent5;
                        } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("Icon")) {
                            String textContent6 = item.getTextContent();
                            Log.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] BigIconUrl:%s", textContent6);
                            emojiGroupInfo.field_BigIconUrl = textContent6;
                        } else if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("ButtonType"))) {
                            String textContent7 = item.getTextContent();
                            Log.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] buttonType:%s", textContent7);
                            emojiGroupInfo.field_buttonType = Integer.valueOf(textContent7).intValue();
                        }
                    }
                    if (!Util.isNullOrNil(emojiGroupInfo.field_productID)) {
                        emojiGroupInfo.field_recommand = 1;
                        emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
                        emojiGroupInfo.field_sort = 0;
                        h.INSTANCE.a(12068, 1, emojiGroupInfo.field_productID, Integer.valueOf(emojiGroupInfo.field_recommandType));
                        arrayList.add(emojiGroupInfo);
                    }
                }
                AppMethodBeat.o(108735);
                return arrayList;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiRecommendXMLParser", "[parser] parseXML exception:%s", e2.toString());
        }
        AppMethodBeat.o(108735);
        return null;
    }
}
