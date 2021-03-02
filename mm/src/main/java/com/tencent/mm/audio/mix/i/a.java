package com.tencent.mm.audio.mix.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private static boolean dxX = false;

    public static o ZW() {
        AppMethodBeat.i(198129);
        o X = o.X(MMApplicationContext.getContext().getExternalCacheDir());
        if (X == null) {
            X = o.X(MMApplicationContext.getContext().getCacheDir());
        }
        o oVar = new o(X, "MixAudio");
        oVar.mkdirs();
        AppMethodBeat.o(198129);
        return oVar;
    }

    public static String hr(String str) {
        AppMethodBeat.i(136954);
        String z = aa.z(new o(ZW(), c.getMD5String(new StringBuilder().append(str.hashCode()).toString()) + "_convert.pcm").mUri);
        AppMethodBeat.o(136954);
        return z;
    }

    public static o hs(String str) {
        AppMethodBeat.i(177346);
        o oVar = new o(str);
        if (!oVar.exists()) {
            try {
                oVar.createNewFile();
            } catch (Exception e2) {
                b.printErrStackTrace("MicroMsg.Mix.FileUtil", e2, "createNewFile", new Object[0]);
            }
        }
        AppMethodBeat.o(177346);
        return oVar;
    }

    public static File ht(String str) {
        AppMethodBeat.i(198130);
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e2) {
                b.printErrStackTrace("MicroMsg.Mix.FileUtil", e2, "createNewFile", new Object[0]);
            }
        }
        AppMethodBeat.o(198130);
        return file;
    }

    public static String S(String str, String str2) {
        AppMethodBeat.i(136956);
        o ZW = ZW();
        String str3 = c.getMD5String(new StringBuilder().append(str2.hashCode()).toString()) + "_cache.pcm";
        o oVar = new o(aa.z(ZW.mUri) + FilePathGenerator.ANDROID_DIR_SEP + str);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        b.i("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", aa.z(oVar.mUri), str);
        String z = aa.z(new o(oVar, str3).mUri);
        AppMethodBeat.o(136956);
        return z;
    }

    public static void c(String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(136957);
        if (arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String S = S(str, it.next());
                o oVar = new o(S);
                if (oVar.exists()) {
                    oVar.delete();
                    b.i("MicroMsg.Mix.FileUtil", "delete pcm cache file, file:%s", S);
                }
            }
        }
        AppMethodBeat.o(136957);
    }

    public static boolean hu(String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(136958);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(136958);
            return false;
        }
        o oVar = new o(str);
        if (!oVar.exists()) {
            AppMethodBeat.o(136958);
            return false;
        } else if (oVar.isDirectory()) {
            AppMethodBeat.o(136958);
            return false;
        } else {
            if (str.endsWith(".wav")) {
                if (oVar.length() >= 5000000) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    AppMethodBeat.o(136958);
                    return false;
                }
            }
            if (!str.endsWith(".wav")) {
                if (oVar.length() >= 2000000) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(136958);
                    return false;
                }
            }
            AppMethodBeat.o(136958);
            return true;
        }
    }

    public static boolean bu(long j2) {
        if (j2 >= 2000000) {
            return true;
        }
        return false;
    }

    public static long hv(String str) {
        AppMethodBeat.i(136959);
        o oVar = new o(str);
        if (oVar.exists()) {
            long length = oVar.length();
            AppMethodBeat.o(136959);
            return length;
        }
        AppMethodBeat.o(136959);
        return 0;
    }

    public static String T(String str, String str2) {
        AppMethodBeat.i(198131);
        o oVar = new o(aa.z(ZW().mUri) + FilePathGenerator.ANDROID_DIR_SEP + str);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        b.i("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", aa.z(oVar.mUri), str);
        String z = aa.z(new o(oVar, str2).mUri);
        AppMethodBeat.o(198131);
        return z;
    }
}
