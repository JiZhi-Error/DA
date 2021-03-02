package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.p;
import java.util.HashMap;
import java.util.Map;

public final class i {
    public String djt;
    private Map<String, a> dju = new HashMap();
    public int versionCode;

    public i(String str, int i2) {
        AppMethodBeat.i(953);
        if (str == null) {
            this.djt = "http://dldir1.qq.com/weixin/android/";
        } else {
            this.djt = str;
        }
        this.versionCode = i2;
        AppMethodBeat.o(953);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(954);
        this.dju.put(aVar.djv, aVar);
        AppMethodBeat.o(954);
    }

    public final a fQ(String str) {
        AppMethodBeat.i(p.CTRL_INDEX);
        a aVar = this.dju.get(str);
        AppMethodBeat.o(p.CTRL_INDEX);
        return aVar;
    }

    public final String VO() {
        AppMethodBeat.i(956);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", this.djt, Integer.valueOf(this.dju.size()), Integer.valueOf(this.versionCode)));
        for (Map.Entry<String, a> entry : this.dju.entrySet()) {
            a value = entry.getValue();
            sb.append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", value.djv, value.djw, value.patchMd5, value.url, Integer.valueOf(value.size)));
        }
        sb.append("</patchupdate>");
        String sb2 = sb.toString();
        AppMethodBeat.o(956);
        return sb2;
    }

    public static i fR(String str) {
        boolean z;
        AppMethodBeat.i(957);
        Map<String, String> P = f.P(str, "patchupdate");
        if (P == null) {
            AppMethodBeat.o(957);
            return null;
        }
        i iVar = new i(P.get(".patchupdate.$base"), j.cL(P.get(".patchupdate.$versioncode")));
        int cL = j.cL(P.get(".patchupdate.$count"));
        int i2 = 0;
        while (i2 < cL) {
            String str2 = ".patchupdate.item" + (i2 > 0 ? Integer.valueOf(i2) : "");
            a aVar = new a(P.get(String.valueOf(str2) + ".$old"), P.get(String.valueOf(str2) + ".$new"), P.get(String.valueOf(str2) + ".$patch"), P.get(String.valueOf(str2) + ".$url"), j.cL(P.get(String.valueOf(str2) + ".$size")));
            if (aVar.djv == null || aVar.djw == null || aVar.patchMd5 == null || aVar.url == null) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                iVar.dju.put(aVar.djv, aVar);
            }
            i2++;
        }
        AppMethodBeat.o(957);
        return iVar;
    }

    public static class a {
        String djv;
        public String djw;
        public String patchMd5;
        public int size;
        public String url;

        public a(String str, String str2, String str3, String str4, int i2) {
            this.djv = str;
            this.djw = str2;
            this.patchMd5 = str3;
            this.size = i2;
            this.url = str4;
        }
    }
}
