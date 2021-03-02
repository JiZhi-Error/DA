package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.a;
import com.tencent.mm.protocal.d;

public final class c {
    public static final String USER_AGENT = ("weixin/" + d.ics + "/0x" + Integer.toHexString(d.KyO));

    static {
        AppMethodBeat.i(198577);
        AppMethodBeat.o(198577);
    }

    public static void a(String str, String str2, String str3, a.AbstractC1611a aVar) {
        AppMethodBeat.i(198576);
        b bVar = new b(str, str2, aVar);
        Bundle bundle = new Bundle();
        bundle.putString("param_cookie", str3);
        bVar.y(bundle);
        AppMethodBeat.o(198576);
    }
}
