package com.tencent.mm.plugin.qqmail.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public class c implements k<IPCVoid, IPCString> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.ipcinvoker.k
    public final /* synthetic */ IPCString invoke(IPCVoid iPCVoid) {
        AppMethodBeat.i(198580);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_EXT_BIND_XMAIL_STRING_SYNC, (Object) null);
        Log.i("MicroMsg.GetBindMailTask", "last bind xmail %s", str);
        int i2 = g.aAh().azQ().getInt(9, 0);
        Log.i("MicroMsg.GetBindMailTask", "bindXMail %s, bindQQ %d, extUserStatus %d", str, Integer.valueOf(i2), Integer.valueOf(g.aAh().azQ().getInt(ar.a.USERINFO_EXT_USER_STATUS_INT_SYNC, 0)));
        if (Util.isNullOrNil(str)) {
            if (i2 != 0) {
                str = i2 + "@qq.com";
            } else {
                str = "";
            }
        }
        IPCString iPCString = new IPCString(str);
        AppMethodBeat.o(198580);
        return iPCString;
    }
}
