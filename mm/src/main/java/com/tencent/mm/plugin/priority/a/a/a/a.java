package com.tencent.mm.plugin.priority.a.a.a;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class a {
    public static final boolean aKb(String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(40497);
        if (!ab.IS(str) || !ab.JJ(str)) {
            z = false;
        } else {
            z = true;
        }
        if (!ab.Eq(str) || ab.JI(str)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z || z2) {
            AppMethodBeat.o(40497);
            return true;
        }
        AppMethodBeat.o(40497);
        return false;
    }

    public static final boolean eCR() {
        AppMethodBeat.i(40498);
        if (!eCS()) {
            AppMethodBeat.o(40498);
            return false;
        } else if (!eCT()) {
            AppMethodBeat.o(40498);
            return false;
        } else {
            AppMethodBeat.o(40498);
            return true;
        }
    }

    public static final boolean eCS() {
        AppMethodBeat.i(40499);
        if (!b.baS()) {
            AppMethodBeat.o(40499);
            return true;
        }
        AppMethodBeat.o(40499);
        return false;
    }

    public static final boolean eCT() {
        AppMethodBeat.i(40500);
        int i2 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ChatImgAutoDownload"), 1);
        if (i2 == 3) {
            Log.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i2)));
            AppMethodBeat.o(40500);
            return false;
        } else if (i2 == 2 && !NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            AppMethodBeat.o(40500);
            return false;
        } else if (i2 != 1) {
            AppMethodBeat.o(40500);
            return false;
        } else if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            boolean eCU = eCU();
            AppMethodBeat.o(40500);
            return eCU;
        } else {
            AppMethodBeat.o(40500);
            return true;
        }
    }

    private static boolean eCU() {
        AppMethodBeat.i(40501);
        long j2 = (long) Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ChatImgAutoDownloadMax"), 0);
        long nullAs = Util.nullAs((Long) g.aAh().azQ().get(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, (Object) null), 0);
        long safeParseLong = Util.safeParseLong((String) DateFormat.format("M", System.currentTimeMillis()));
        long nullAs2 = Util.nullAs((Long) g.aAh().azQ().get(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, (Object) null), 0);
        Log.d("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "currentmonth " + safeParseLong + " month " + nullAs2 + " maxcount " + j2 + " current " + nullAs);
        if (safeParseLong != nullAs2) {
            Log.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "update month %d ", Long.valueOf(safeParseLong));
            g.aAh().azQ().set(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, (Object) 0L);
            g.aAh().azQ().set(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(safeParseLong));
            nullAs = 0;
        }
        if (nullAs <= j2 || j2 <= 0) {
            AppMethodBeat.o(40501);
            return true;
        }
        Log.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "this month had auto download " + nullAs + " C2C image, can not auto download.");
        AppMethodBeat.o(40501);
        return false;
    }
}
