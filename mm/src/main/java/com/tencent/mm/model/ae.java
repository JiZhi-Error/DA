package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class ae implements h {
    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        NamedNodeMap attributes;
        Node namedItem;
        AppMethodBeat.i(150155);
        de deVar = aVar.heO;
        if (deVar == null || deVar.KHn == null) {
            Log.f("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension failed, invalid cmdAM");
            AppMethodBeat.o(150155);
        } else {
            Log.i("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension start");
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(z.a(deVar.KHn).getBytes(ProtocolPackage.ServerEncoding))));
                parse.normalize();
                NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("deletepackage");
                if (elementsByTagName != null && elementsByTagName.getLength() == 1) {
                    NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i2 = 0; i2 < length; i2++) {
                        Node item = childNodes.item(i2);
                        if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("pack") || (attributes = item.getAttributes()) == null || (namedItem = attributes.getNamedItem("type")) == null)) {
                            int i3 = Util.getInt(namedItem.getNodeValue(), 0);
                            cw cwVar = new cw();
                            cwVar.dFY.packageType = i3;
                            EventCenter.instance.publish(cwVar);
                        }
                    }
                }
                Log.i("MicroMsg.DeletePackageMsgExtension", "[oneliang]DeletePackageMsgExtension end");
                AppMethodBeat.o(150155);
            } catch (Exception e2) {
                Log.e("MicroMsg.DeletePackageMsgExtension", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(150155);
            }
        }
        return null;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }
}
