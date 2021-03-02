package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.platformtools.Util;

public final class f {
    public static void aAr(String str) {
        AppMethodBeat.i(41683);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41683);
            return;
        }
        FileDownloadTaskInfo alg = com.tencent.mm.plugin.downloader.model.f.cBv().alg(str);
        d aAs = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSM().aAs(str);
        if (alg == null || alg.id <= 0) {
            if (aAs != null) {
                a(str, 0, "", 0, 3, 0, aAs.field_noWifi, aAs.field_noSdcard, aAs.field_noEnoughSpace, aAs.field_lowBattery, aAs.field_continueDelay);
                AppMethodBeat.o(41683);
                return;
            }
            a(str, 0, "", 0, 3, 0, false, false, false, false, false);
            AppMethodBeat.o(41683);
        } else if (aAs != null) {
            a(str, alg.id, alg.url, alg.oJj == 0 ? 0 : (int) ((alg.qJe * 100) / alg.oJj), 3, 0, aAs.field_noWifi, aAs.field_noSdcard, aAs.field_noEnoughSpace, aAs.field_lowBattery, aAs.field_continueDelay);
            AppMethodBeat.o(41683);
        } else {
            a(str, alg.id, alg.url, alg.oJj == 0 ? 0 : (int) ((alg.qJe * 100) / alg.oJj), 3, 0, false, false, false, false, false);
            AppMethodBeat.o(41683);
        }
    }

    static void ap(String str, int i2, int i3) {
        AppMethodBeat.i(41684);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41684);
            return;
        }
        if (((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSM().aAs(str) != null) {
            P(str, i2, i3);
        }
        AppMethodBeat.o(41684);
    }

    static void P(String str, int i2, int i3) {
        AppMethodBeat.i(41685);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41685);
            return;
        }
        FileDownloadTaskInfo alg = com.tencent.mm.plugin.downloader.model.f.cBv().alg(str);
        if (alg == null || alg.id <= 0) {
            a(str, 0, "", 0, i2, i3, false, false, false, false, false);
            AppMethodBeat.o(41685);
            return;
        }
        a(str, alg.id, alg.url, alg.oJj == 0 ? 0 : (int) ((alg.qJe * 100) / alg.oJj), i2, i3, false, false, false, false, false);
        AppMethodBeat.o(41685);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r7, long r8, java.lang.String r10, int r11, int r12, int r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18) {
        /*
        // Method dump skipped, instructions count: 300
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.model.a.f.a(java.lang.String, long, java.lang.String, int, int, int, boolean, boolean, boolean, boolean, boolean):void");
    }

    private static String s(Object... objArr) {
        AppMethodBeat.i(41687);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 11; i2++) {
            sb.append(String.valueOf(objArr[i2])).append(',');
        }
        sb.append(String.valueOf(objArr[11]));
        String sb2 = sb.toString();
        AppMethodBeat.o(41687);
        return sb2;
    }
}
