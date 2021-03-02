package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.util.Locale;

public abstract class AbsReader implements ICommLibReader {
    private volatile String kJU;
    private volatile String kJV;
    private volatile i kJW;
    private volatile String versionName;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ICommLibReader iCommLibReader) {
        ICommLibReader iCommLibReader2 = iCommLibReader;
        if (iCommLibReader2 == null) {
            return -1;
        }
        if (iCommLibReader2.getClass() == getClass() && iCommLibReader2.bvd() > 0 && iCommLibReader2.bvd() == bvd()) {
            return 0;
        }
        return bvb().compareTo(iCommLibReader2.bvb());
    }

    protected AbsReader() {
    }

    private i bva() {
        if (this.kJW == null) {
            synchronized (this) {
                if (this.kJW == null) {
                    String UM = UM("WAVersion.json");
                    if (TextUtils.isEmpty(UM)) {
                        Log.e("MicroMsg.AppBrand.AbsReader", "getVersionMetaJson EMPTY WAVersion.json, info=%s", bve());
                    }
                    try {
                        this.kJW = TextUtils.isEmpty(UM) ? new i() : new i(UM);
                    } catch (g e2) {
                        Log.printErrStackTrace("MicroMsg.AppBrand.AbsReader", e2, "parse WAVersion.json[%s] ", UM);
                        return new i();
                    }
                }
            }
        }
        return this.kJW;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.o
    public final String UM(String str) {
        InputStream openRead = openRead(str);
        if (openRead == null) {
            return null;
        }
        long currentTicks = Util.currentTicks();
        String convertStreamToString = d.convertStreamToString(openRead);
        Util.qualityClose(openRead);
        Log.v("MicroMsg.AppBrand.AbsReader", "readAsString(%s), cost %dms", str, Long.valueOf(Util.currentTicks() - currentTicks));
        return convertStreamToString;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.o
    public final String bvb() {
        String str;
        if (TextUtils.isEmpty(this.versionName)) {
            String str2 = "";
            String str3 = "";
            try {
                i bva = bva();
                str2 = bva.getString("version");
                str3 = bva.getString(ch.COL_UPDATETIME);
                Log.i("MicroMsg.AppBrand.AbsReader", "AbsReader version parsed wx.version[%s | %s]", str2, str3);
                str = str2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrand.AbsReader", e2, "get WAVersion.json failed.", new Object[0]);
                str = str2;
            }
            if (str == null) {
                str = "";
            }
            this.versionName = str;
            this.kJU = str3;
            this.kJV = String.format(Locale.US, "%s (%s)", this.versionName, this.kJU);
        }
        return this.versionName;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.o
    public final String bvc() {
        bvb();
        return Util.nullAsNil(this.kJV);
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.o
    public final int bvd() {
        return bve().pkgVersion();
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader
    public final String UN(String str) {
        i FK;
        if (!TextUtils.isEmpty(str) && (FK = bva().FK("features")) != null) {
            return FK.optString(str, null);
        }
        return null;
    }
}
