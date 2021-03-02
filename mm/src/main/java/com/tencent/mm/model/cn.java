package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.bb.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
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

public final class cn implements h {
    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        NamedNodeMap attributes;
        Node namedItem;
        AppMethodBeat.i(150190);
        de deVar = aVar.heO;
        if (deVar == null || deVar.KHn == null) {
            Log.f("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension failed, invalid cmdAM");
            AppMethodBeat.o(150190);
        } else {
            Log.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension start");
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(z.a(deVar.KHn).getBytes(ProtocolPackage.ServerEncoding))));
                parse.normalize();
                NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("updatepackage");
                if (elementsByTagName != null && elementsByTagName.getLength() == 1) {
                    NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i2 = 0; i2 < length; i2++) {
                        Node item = childNodes.item(i2);
                        if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("pack") || (attributes = item.getAttributes()) == null || (namedItem = attributes.getNamedItem("type")) == null)) {
                            g.aAg().hqi.a(new n(Util.getInt(namedItem.getNodeValue(), 0)), 0);
                        }
                    }
                }
                Log.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension end");
                AppMethodBeat.o(150190);
            } catch (Exception e2) {
                Log.e("MicroMsg.UpdatePackageMsgExtension", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(150190);
            }
        }
        return null;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }
}
