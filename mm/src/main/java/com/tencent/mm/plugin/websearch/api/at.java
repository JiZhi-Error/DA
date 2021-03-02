package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import org.json.JSONObject;

public final class at {
    private int IFu = 1;
    private long IFv;
    private String IFw;
    String IFx;
    private String IFy;
    private String IFz;

    public at(String str, String str2, String str3) {
        this.IFw = str;
        this.IFx = str2;
        this.IFy = str3;
    }

    public final int bbw() {
        AppMethodBeat.i(117791);
        if (this.IFu <= 1 || fYr().lastModified() > this.IFv) {
            fYq();
        }
        int i2 = this.IFu;
        AppMethodBeat.o(117791);
        return i2;
    }

    public final void fYq() {
        AppMethodBeat.i(117792);
        this.IFu = Integer.valueOf(ai.X(fYr()).getProperty("version", "1")).intValue();
        this.IFv = System.currentTimeMillis();
        AppMethodBeat.o(117792);
    }

    private o fYr() {
        AppMethodBeat.i(117793);
        o oVar = new o(fYs(), "config.conf");
        AppMethodBeat.o(117793);
        return oVar;
    }

    public final String fYs() {
        AppMethodBeat.i(117794);
        o oVar = new o(b.aKC(), this.IFw);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        String z = aa.z(oVar.her());
        AppMethodBeat.o(117794);
        return z;
    }

    public final String fYt() {
        AppMethodBeat.i(117795);
        if (TextUtils.isEmpty(this.IFy)) {
            AppMethodBeat.o(117795);
            return "config.conf";
        }
        String str = this.IFy + "/config.conf";
        AppMethodBeat.o(117795);
        return str;
    }

    private String fYu() {
        AppMethodBeat.i(117796);
        if (TextUtils.isEmpty(this.IFy)) {
            AppMethodBeat.o(117796);
            return "config.conf";
        }
        String str = this.IFy + FilePathGenerator.ANDROID_DIR_SEP + this.IFx;
        AppMethodBeat.o(117796);
        return str;
    }

    public final String fYv() {
        AppMethodBeat.i(117797);
        String str = fYs() + "/app.html";
        AppMethodBeat.o(117797);
        return str;
    }

    public final String fYw() {
        AppMethodBeat.i(187868);
        String str = fYs() + "/dist/build.js";
        AppMethodBeat.o(187868);
        return str;
    }

    public final String fYx() {
        AppMethodBeat.i(187869);
        if (Util.isNullOrNil(this.IFz)) {
            this.IFz = s.bhK(aa.z(new o(fYw()).her()));
        }
        String str = this.IFz;
        AppMethodBeat.o(187869);
        return str;
    }

    public static String fYy() {
        return "app.html";
    }

    public final boolean fYz() {
        AppMethodBeat.i(117798);
        String property = ai.X(fYr()).getProperty("md5map");
        if (TextUtils.isEmpty(property)) {
            AppMethodBeat.o(117798);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(property);
            Iterator<String> keys = jSONObject.keys();
            while (keys != null && keys.hasNext()) {
                String next = keys.next();
                o oVar = new o(fYs(), next);
                if (!oVar.exists()) {
                    Log.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, file not exist %s", aa.z(oVar.her()));
                    AppMethodBeat.o(117798);
                    return false;
                }
                String bhK = s.bhK(aa.z(oVar.her()));
                String string = jSONObject.getString(next);
                if (TextUtils.isEmpty(bhK) || !bhK.equals(string)) {
                    Log.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, fileName %s, fileMd5 %s, expect md5 %s", next, bhK, string);
                    AppMethodBeat.o(117798);
                    return false;
                } else if (next.equals("dist/build.js")) {
                    this.IFz = bhK;
                }
            }
            AppMethodBeat.o(117798);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", e2, "", new Object[0]);
            AppMethodBeat.o(117798);
            return false;
        }
    }

    public final int bbx() {
        AppMethodBeat.i(117799);
        String str = "assets:///" + fYt();
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = s.openRead(str);
            properties.load(inputStream);
            aa.closeQuietly(inputStream);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", e2, "getAssetH5Version", new Object[0]);
            aa.closeQuietly(inputStream);
        } catch (Throwable th) {
            aa.closeQuietly(inputStream);
            AppMethodBeat.o(117799);
            throw th;
        }
        int intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
        AppMethodBeat.o(117799);
        return intValue;
    }

    public final void fYA() {
        AppMethodBeat.i(117800);
        try {
            byte[] aW = s.aW("assets:///" + fYu(), 0, -1);
            o oVar = new o(MMApplicationContext.getContext().getCacheDir(), "websearch/temp.zip");
            if (oVar.exists()) {
                oVar.delete();
            }
            oVar.heq().mkdirs();
            s.f(aa.z(oVar.her()), aW, aW.length);
            aXj(aa.z(oVar.her()));
            AppMethodBeat.o(117800);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", e2, "initAssetTemplateToPath", new Object[0]);
            AppMethodBeat.o(117800);
        }
    }

    public final void aXj(String str) {
        AppMethodBeat.i(117801);
        if (s.YS(fYs())) {
            s.dy(fYs(), true);
        }
        s.boN(fYs());
        o oVar = new o(fYs(), FilePathGenerator.NO_MEDIA_FILENAME);
        if (!oVar.exists()) {
            try {
                oVar.createNewFile();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", e2, "create nomedia file error", new Object[0]);
            }
        }
        int fW = s.fW(str, fYs());
        if (fW < 0) {
            Log.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + fW + ", zipFilePath = " + str + ", unzipPath = " + fYs());
            AppMethodBeat.o(117801);
            return;
        }
        fYq();
        Log.i("MicroMsg.WebSearch.WebSearchTemplate", "Unzip Path=%s version=%d", fYs(), Integer.valueOf(bbw()));
        AppMethodBeat.o(117801);
    }

    public static int aXk(String str) {
        AppMethodBeat.i(117802);
        o oVar = new o(MMApplicationContext.getContext().getCacheDir(), "websearch/temp");
        if (oVar.exists()) {
            s.dy(aa.z(oVar.her()), true);
        }
        oVar.mkdirs();
        int fW = s.fW(str, aa.z(oVar.her()));
        if (fW < 0) {
            Log.e("MicroMsg.WebSearch.WebSearchTemplate", "unzip fail, ret = " + fW + ", zipFilePath = " + str + ", unzipPath = " + aa.z(oVar.her()));
            AppMethodBeat.o(117802);
            return 1;
        }
        o oVar2 = new o(oVar, "config.conf");
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = s.ao(oVar2);
            properties.load(inputStream);
            aa.closeQuietly(inputStream);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", e2, "getZipFileVersion %s", str);
            aa.closeQuietly(inputStream);
        } catch (Throwable th) {
            aa.closeQuietly(inputStream);
            AppMethodBeat.o(117802);
            throw th;
        }
        int intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
        AppMethodBeat.o(117802);
        return intValue;
    }
}
