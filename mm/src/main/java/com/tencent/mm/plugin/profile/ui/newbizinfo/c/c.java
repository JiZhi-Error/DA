package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.d;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ab;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;

public final class c {
    public static final void I(String str, int i2, long j2) {
        AppMethodBeat.i(231964);
        h aKz = d.eDO().aKz(str);
        String str2 = aKz != null ? aKz.field_decryptUserName : "";
        Log.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s, enterTimestamp: %d", str, 3, Integer.valueOf(i2), 4, str2, Long.valueOf(j2));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13307, str, 3, Integer.valueOf(i2), 4, str2, Integer.valueOf(ab.getSessionId()), 0, Long.valueOf(j2));
        AppMethodBeat.o(231964);
    }

    public static final void c(String str, int i2, int i3, long j2) {
        AppMethodBeat.i(231965);
        h aKz = d.eDO().aKz(str);
        String str2 = aKz != null ? aKz.field_decryptUserName : "";
        Log.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s, profileScene: %d, enterTimestamp: %s", str, 3, Integer.valueOf(i2), 4, str2, Integer.valueOf(i3), Long.valueOf(j2));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13307, str, 3, Integer.valueOf(i2), 4, str2, Integer.valueOf(ab.getSessionId()), Integer.valueOf(i3), Long.valueOf(j2));
        AppMethodBeat.o(231965);
    }

    public static final ArrayList<String> fd(final String str, final int i2) {
        AppMethodBeat.i(231966);
        h aKz = d.eDO().aKz(str);
        final String str2 = aKz != null ? aKz.field_decryptUserName : "";
        final String valueOf = String.valueOf(ab.getSessionId());
        Log.d("MicroMsg.Kv13307", "getArgs username:%s scene::%s optype:%d opscene:%d decryptUserName:%s profileScene:%d", str, 3, 1302, 4, str2, Integer.valueOf(i2));
        AnonymousClass1 r2 = new ArrayList<String>() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.AnonymousClass1 */
            final /* synthetic */ int BlM = 1302;

            {
                AppMethodBeat.i(27594);
                add(str);
                add(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                add(String.valueOf(this.BlM));
                add("4");
                add(str2);
                add(valueOf);
                add(String.valueOf(i2));
                AppMethodBeat.o(27594);
            }
        };
        AppMethodBeat.o(231966);
        return r2;
    }
}
