package com.tencent.mm.plugin.websearch.widget.c;

import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.hv;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;

public final class c {
    public static void d(String str, String str2, String... strArr) {
        AppMethodBeat.i(116657);
        Log.e("WidgetPermissionUtil", "permissionFailed appid %s, api %s, args %s", str, str2, Arrays.toString(strArr));
        h.INSTANCE.dN(930, 0);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 <= 0; i2++) {
            sb.append(q.encode(strArr[0])).append("&");
        }
        hv hvVar = new hv();
        hvVar.eMz = hvVar.x(ProviderConstants.API_PATH, str2, true);
        hvVar.enR = hvVar.x("appid", str, true);
        hv qW = hvVar.qW(System.currentTimeMillis());
        qW.eMA = qW.x("arg", sb.toString(), true);
        qW.bfK();
        AppMethodBeat.o(116657);
    }

    public static boolean ak(long j2, int i2) {
        return (((long) (1 << i2)) & j2) > 0;
    }
}
