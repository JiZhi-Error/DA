package com.tencent.mm.ui.appbrand;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class a implements e {
    private static String TAG = "MicroMsg.AppBrandConversationService";

    @Override // com.tencent.mm.plugin.appbrand.service.e
    public final boolean bVr() {
        AppMethodBeat.i(232736);
        if (((l) g.af(l.class)).aST().bjY("appbrandcustomerservicemsg") == null) {
            AppMethodBeat.o(232736);
            return false;
        }
        AppMethodBeat.o(232736);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.e
    public final void c(az azVar) {
        AppMethodBeat.i(232738);
        az bjY = ((l) g.af(l.class)).aST().bjY("appbrandcustomerservicemsg");
        if (bjY == null) {
            Log.i(TAG, "create parentConv");
            az azVar2 = new az("appbrandcustomerservicemsg");
            azVar2.gCr();
            a(azVar, azVar2);
            ((l) g.af(l.class)).aST().e(azVar2);
            AppMethodBeat.o(232738);
            return;
        }
        Log.i(TAG, "appBrandSuperConv is created");
        bjY.Co(null);
        a(azVar, bjY);
        ((l) g.af(l.class)).aST().a(bjY, "appbrandcustomerservicemsg");
        AppMethodBeat.o(232738);
    }

    private static void a(az azVar, az azVar2) {
        az azVar3;
        ca caVar;
        az azVar4;
        String str = null;
        AppMethodBeat.i(232737);
        Cursor c2 = ((l) g.af(l.class)).aST().c(ab.iCL, null, "appbrandcustomerservicemsg");
        if (c2 != null) {
            if (c2.getCount() <= 0 || !c2.moveToFirst()) {
                azVar4 = null;
            } else {
                azVar4 = new az();
                azVar4.convertFrom(c2);
            }
            c2.close();
            azVar3 = azVar4;
        } else {
            azVar3 = null;
        }
        if (azVar3 != null) {
            Log.e(TAG, "The lastest app brand conversation username is %s", azVar3.field_username);
            caVar = ((l) g.af(l.class)).eiy().aEx(azVar3.field_username);
        } else if (azVar != null) {
            Log.e(TAG, "The lastest app brand conversation is null");
            caVar = ((l) g.af(l.class)).eiy().aEx(azVar.field_username);
        } else {
            caVar = null;
        }
        if (caVar == null || caVar.field_msgId <= 0) {
            Log.e(TAG, "the last of msg is null'");
            azVar2.gCr();
            AppMethodBeat.o(232737);
            return;
        }
        azVar2.aX(caVar);
        azVar2.setContent(caVar.field_talker + ":" + caVar.field_content);
        azVar2.Cl(Integer.toString(caVar.getType()));
        bw.b Xh = ((l) g.af(l.class)).aST().Xh();
        if (Xh != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            if (azVar3 != null) {
                caVar.Cy(azVar3.field_parentRef);
            } else if (azVar != null) {
                caVar.Cy(azVar.field_parentRef);
            }
            caVar.setContent(azVar2.field_content);
            Xh.a(caVar, pString, pString2, pInt, true);
            int type = caVar.getType();
            String str2 = caVar.field_content;
            if (!Util.isNullOrNil(str2)) {
                switch (type) {
                    case 49:
                        Map<String, String> parseXml = XmlParser.parseXml(str2, "msg", null);
                        if (parseXml != null) {
                            String str3 = parseXml.get(".msg.appmsg.title");
                            Log.d(TAG, "[oneliang][parseConversationMsgContentTitle] title:%s", str3);
                            str = str3;
                            break;
                        }
                        break;
                }
            }
            azVar2.Cm(Util.nullAsNil(pString.value).concat(Util.isNullOrNil(str) ? "" : " " + Util.nullAsNil(str)));
            azVar2.Cn(pString2.value);
            azVar2.nw(pInt.value);
        }
        AppMethodBeat.o(232737);
    }
}
