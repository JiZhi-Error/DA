package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class h {
    public static String kz(String str, String str2) {
        AppMethodBeat.i(97318);
        String str3 = few() + kB(str, str2);
        AppMethodBeat.o(97318);
        return str3;
    }

    public static String kA(String str, String str2) {
        AppMethodBeat.i(97319);
        s.boN(few());
        String str3 = few() + str + "_sight_" + MD5Util.getMD5String(str2);
        AppMethodBeat.o(97319);
        return str3;
    }

    private static String kB(String str, String str2) {
        AppMethodBeat.i(97320);
        String str3 = str + "_img_" + MD5Util.getMD5String(str2);
        AppMethodBeat.o(97320);
        return str3;
    }

    private static String kC(String str, String str2) {
        AppMethodBeat.i(203155);
        String str3 = str + "_sight_" + MD5Util.getMD5String(str2);
        AppMethodBeat.o(203155);
        return str3;
    }

    public static Bitmap kD(String str, String str2) {
        Bitmap bitmap = null;
        AppMethodBeat.i(97321);
        if (Util.isNullOrNil(str2) || Util.isNullOrNil(str)) {
            AppMethodBeat.o(97321);
        } else {
            try {
                String kz = kz(str, str2);
                if (!TextUtils.isEmpty(kz) && s.YS(kz)) {
                    bitmap = BitmapUtil.decodeFile(kz);
                    AppMethodBeat.o(97321);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.AdLandingPagesDownloadResourceHelper", "%s", Util.stackTraceToString(e2));
            }
            AppMethodBeat.o(97321);
        }
        return bitmap;
    }

    public static void a(String str, int i2, f.a aVar) {
        AppMethodBeat.i(97322);
        a("adId", str, false, i2, aVar);
        AppMethodBeat.o(97322);
    }

    public static void a(String str, boolean z, f.a aVar) {
        AppMethodBeat.i(203156);
        b("adId", str, z, 41, 0, aVar);
        AppMethodBeat.o(203156);
    }

    private static void b(String str, String str2, boolean z, int i2, int i3, f.a aVar) {
        AppMethodBeat.i(203157);
        Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download img for " + str2 + " for adid:" + str);
        e.a(str2, kz(str, str2), z, i2, 0, aVar);
        AppMethodBeat.o(203157);
    }

    public static void a(String str, String str2, boolean z, int i2, f.a aVar) {
        AppMethodBeat.i(97325);
        if (Util.isNullOrNil(str2) || Util.isNullOrNil(str)) {
            aVar.eWO();
            AppMethodBeat.o(97325);
        } else if (AdLandingPagesProxy.getInstance().isUseSnsDownloadImage()) {
            a(str, str2, aVar);
            AppMethodBeat.o(97325);
        } else {
            b(str, str2, z, i2, 0, aVar);
            AppMethodBeat.o(97325);
        }
    }

    private static void a(String str, String str2, f.a aVar) {
        AppMethodBeat.i(97326);
        if (Util.isNullOrNil(str2) || Util.isNullOrNil(str)) {
            aVar.eWO();
            AppMethodBeat.o(97326);
            return;
        }
        Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download new img for " + str2 + " for adid:" + str);
        e.a(str2, few(), kB(str, str2), 0, aVar);
        AppMethodBeat.o(97326);
    }

    public static void b(String str, String str2, f.a aVar) {
        AppMethodBeat.i(203158);
        if (Util.isNullOrNil(str2) || Util.isNullOrNil(str)) {
            aVar.eWO();
            AppMethodBeat.o(203158);
            return;
        }
        Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPagesByCdn, url=" + str2 + ", adId=" + str);
        e.a(str2, few(), kC(str, str2), 1, aVar);
        AppMethodBeat.o(203158);
    }

    public static void b(String str, String str2, boolean z, int i2, f.a aVar) {
        AppMethodBeat.i(97327);
        Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPages, url=" + str2 + ", adId=" + str);
        e.a(str2, kA(str, str2), z, i2, 0, aVar);
        AppMethodBeat.o(97327);
    }

    public static String few() {
        AppMethodBeat.i(97328);
        String str = b.aKJ() + "sns_ad_landingpages/";
        AppMethodBeat.o(97328);
        return str;
    }
}
