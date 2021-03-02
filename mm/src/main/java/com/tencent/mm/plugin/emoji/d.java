package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class d {
    public static void CK(long j2) {
        AppMethodBeat.i(104532);
        Log.i("MicroMsg.emoji.EmojiReportHepler", "report id stat key:%d, value:%d", Long.valueOf(j2), 1L);
        h.INSTANCE.idkeyStat(96, j2, 1, false);
        AppMethodBeat.o(104532);
    }

    public static void a(String str, int i2, int i3, int i4, String str2, int i5, String str3) {
        AppMethodBeat.i(104533);
        Log.i("MicroMsg.emoji.EmojiReportHepler", "report kv stat md5:%s, downType:%d donwloadResult:%d verifyResult:%d productID:%s", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str2);
        h.INSTANCE.a(12007, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5), str3);
        AppMethodBeat.o(104533);
    }
}
