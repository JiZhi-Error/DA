package com.tencent.mm.pluginsdk.model.app;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;

public class v implements b<Bundle, IPCBoolean> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(Bundle bundle, d<IPCBoolean> dVar) {
        AppMethodBeat.i(151801);
        Bundle bundle2 = bundle;
        if (bundle2 == null || !MainProcessIPCService.dkO.equals(g.axZ())) {
            AppMethodBeat.o(151801);
            return;
        }
        String string = bundle2.getString("appId");
        String string2 = bundle2.getString(IssueStorage.COLUMN_EXT_INFO);
        g cX = h.cX(string, true);
        if (cX != null) {
            WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
            wXAppExtendObject.extInfo = string2;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
            wXMediaMessage.sdkVer = Build.SDK_INT;
            wXMediaMessage.messageExt = string2;
            boolean a2 = h.a(MMApplicationContext.getContext(), cX.field_appId, wXMediaMessage, 2, (al) null, (Bundle) null);
            if (dVar != null) {
                dVar.bn(new IPCBoolean(a2));
            }
        }
        AppMethodBeat.o(151801);
    }
}
