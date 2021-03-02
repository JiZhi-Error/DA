package com.tencent.mm.model.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class c {
    b iGA = null;
    b iGz = null;

    /* access modifiers changed from: package-private */
    public final void KS(String str) {
        AppMethodBeat.i(153091);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.abtest.AbTestManager", "[Abtest] parse xml faild. xml is null.");
            AppMethodBeat.o(153091);
            return;
        }
        Log.i("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML content:%s", str);
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("testcase");
            if (elementsByTagName != null) {
                for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                    b bVar = new b();
                    NodeList childNodes = elementsByTagName.item(i2).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i3 = 0; i3 < length; i3++) {
                        Node item = childNodes.item(i3);
                        if (item != null && item.getNodeName() != null && item.getNodeName().equals("testpoint")) {
                            NamedNodeMap attributes = item.getAttributes();
                            e eVar = new e();
                            if (attributes != null) {
                                Node namedItem = attributes.getNamedItem("id");
                                if (namedItem != null) {
                                    String nodeValue = namedItem.getNodeValue();
                                    Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] idValue:%s", nodeValue);
                                    eVar.id = nodeValue;
                                }
                                Node namedItem2 = attributes.getNamedItem("reportid");
                                if (namedItem2 != null) {
                                    String nodeValue2 = namedItem2.getNodeValue();
                                    Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] reportIdValue:%s", nodeValue2);
                                    eVar.iGB = nodeValue2;
                                }
                            }
                            String textContent = item.getTextContent();
                            Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] casePointContent:%s", textContent);
                            eVar.value = textContent;
                            bVar.iGy.put(eVar.id, eVar);
                        } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("verifymd5")) {
                            String textContent2 = item.getTextContent();
                            Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] verifymd5Content:%s", textContent2);
                            bVar.gWQ = textContent2;
                        } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("testcaseid")) {
                            String textContent3 = item.getTextContent();
                            Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] testcaseidContent:%s", textContent3);
                            bVar.iGw = textContent3;
                        } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("starttime")) {
                            String textContent4 = item.getTextContent();
                            Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] starttimeContent:%s", textContent4);
                            bVar.iGx = textContent4;
                        } else if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("endtime"))) {
                            String textContent5 = item.getTextContent();
                            Log.d("MicroMsg.abtest.AbTestManager", "[Abtest] endtimeContent:%s", textContent5);
                            bVar.endTime = textContent5;
                        }
                    }
                    if (Util.isNullOrNil(bVar.iGw) || !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(bVar.iGw)) {
                        this.iGz = bVar;
                    } else {
                        this.iGA = bVar;
                    }
                }
            }
            AppMethodBeat.o(153091);
        } catch (Exception e2) {
            Log.e("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML exception:%s", e2.toString());
            AppMethodBeat.o(153091);
        }
    }

    public final boolean aWR() {
        if (this.iGz == null) {
            return false;
        }
        return true;
    }

    public final e KR(String str) {
        AppMethodBeat.i(153092);
        e eVar = null;
        if (this.iGz != null) {
            eVar = this.iGz.KR(str);
        }
        if (eVar == null && this.iGA != null) {
            eVar = this.iGA.KR(str);
        }
        AppMethodBeat.o(153092);
        return eVar;
    }
}
