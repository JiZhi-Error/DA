package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.ao;

public final class f implements p.a {
    private Context mContext;
    private String version = "";

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.tencent.mm.plugin.appbrand.ac.p.a
    public final String Nv() {
        return " MicroMessenger/";
    }

    @Override // com.tencent.mm.plugin.appbrand.ac.p.a
    public final String version() {
        PackageInfo packageInfo;
        String str;
        AppMethodBeat.i(103126);
        if (!TextUtils.isEmpty(this.version)) {
            String str2 = this.version;
            AppMethodBeat.o(103126);
            return str2;
        }
        try {
            packageInfo = b.getPackageInfo(this.mContext, MMApplicationContext.getPackageName());
        } catch (Exception e2) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            this.version += ChannelUtil.formatVersion(null, d.KyO);
            this.version += "." + packageInfo.versionCode;
            this.version += "(" + String.format("0x%08X", Integer.valueOf(d.KyO)) + ")";
            StringBuilder append = new StringBuilder().append(this.version).append(" Process/");
            String lowerCase = MMApplicationContext.getPackageName().trim().toLowerCase();
            String lowerCase2 = MMApplicationContext.getProcessName().trim().toLowerCase();
            if (lowerCase2.equals(lowerCase)) {
                str = "mm";
            } else if (lowerCase2.startsWith(lowerCase)) {
                str = lowerCase2.substring(lowerCase.length() + 1);
            } else {
                str = "unknown";
            }
            this.version = append.append(str).toString();
            this.version += " WeChat/" + (q.is64BitRuntime() ? "arm64" : "arm32");
            this.version += " " + WeChatBrands.AppInfo.current().getUserAgent();
            if (ChannelUtil.isGPVersion()) {
                this.version += " GPVersion/1";
            }
        }
        this.version = acq(this.version);
        String str3 = this.version;
        AppMethodBeat.o(103126);
        return str3;
    }

    public static String acq(String str) {
        AppMethodBeat.i(224209);
        if (!ao.gJH()) {
            AppMethodBeat.o(224209);
            return str;
        }
        String nullAsNil = Util.nullAsNil(str);
        if (!nullAsNil.contains("Android Tablet")) {
            nullAsNil = nullAsNil + " Android Tablet";
        }
        AppMethodBeat.o(224209);
        return nullAsNil;
    }
}
