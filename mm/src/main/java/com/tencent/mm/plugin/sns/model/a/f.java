package com.tencent.mm.plugin.sns.model.a;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.a.c;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class f extends c {
    protected boolean DPU = false;
    protected boolean DPV = false;
    protected boolean DPW = false;
    protected boolean DPX = false;
    protected boolean DPY = false;

    public f(c.a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final String aPI(String str) {
        Exception e2;
        String str2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        try {
            String value = h.aqJ().getValue("SnsCloseDownloadWebp");
            if ((!Util.isNullOrNil(value) ? Util.safeParseInt(value) : 0) != 0) {
                z = false;
            } else if (Build.VERSION.SDK_INT < 14) {
                z = false;
            } else if (ae.gKE.gHI == 2) {
                z = false;
            } else if (!Util.isNullOrNil(ac.jPu)) {
                z = false;
            } else {
                z = true;
            }
            if (!n.aot()) {
                z2 = false;
            } else if (!aj.fbg()) {
                z2 = false;
            } else if (!Util.isNullOrNil(ac.jPu)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!n.aot()) {
                z3 = false;
            } else if (!aj.fbd()) {
                z3 = false;
            } else if (!Util.isNullOrNil(ac.jPu)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (n.aot() && aj.fbe() && Util.isNullOrNil(ac.jPu)) {
                z4 = true;
            }
            if (!Util.isNullOrNil(ac.jPt) || !Util.isNullOrNil(ac.jPu)) {
                if (!Util.isNullOrNil(ac.jPt)) {
                    String[] split = str.split("(//?)");
                    StringBuilder sb = new StringBuilder();
                    sb.append(split[0]).append("//").append(ac.jPt);
                    for (int i2 = 2; i2 < split.length; i2++) {
                        sb.append(FilePathGenerator.ANDROID_DIR_SEP).append(split[i2]);
                    }
                    str = sb.toString();
                    Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
                }
                if (!Util.isNullOrNil(ac.jPu)) {
                    str = m(str, "tp=" + ac.jPu);
                    Log.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(str)));
                }
            } else if (z4) {
                this.DPt.DIq.mediaType = 4;
                str = m(str, "tp=wxpic");
                Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (z2) {
                str = m(str, "tp=wxpc");
                Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (z3) {
                str = m(str, "tp=hevc");
                Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (z) {
                str = m(str, "tp=webp");
                Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            }
            if (!(this.DPt == null || this.DPt.DIq.MsK == 0)) {
                str = m(str, "enc=1");
                Log.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.DPt.DIq.MsL + " " + this.DPt.DIq.MsK + " " + str);
                b.pl(r.CTRL_INDEX);
                this.DPY = true;
            }
            str2 = str;
            try {
                if (this.DPt == null || this.DPt.DIq == null) {
                    return str2;
                }
                cnb cnb = this.DPt.DIq;
                String str3 = this.DPt.DPm ? cnb.MsP : cnb.viB;
                int i3 = this.DPt.DPm ? cnb.MsQ : cnb.MsN;
                if (TextUtils.isEmpty(str3)) {
                    return str2;
                }
                return m(str2, "token=".concat(String.valueOf(str3)), "idx=".concat(String.valueOf(i3)));
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e2.getMessage());
                return str2;
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = str;
            Log.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e2.getMessage());
            return str2;
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final String b(String str, cnb cnb) {
        Exception e2;
        String str2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (cnb == null) {
            Log.i("MicroMsg.SnsDownloadImageBase", "appendUrlArg, media is null.");
            return aPI(str);
        }
        try {
            String value = h.aqJ().getValue("SnsCloseDownloadWebp");
            if ((!Util.isNullOrNil(value) ? Util.safeParseInt(value) : 0) != 0) {
                z = false;
            } else if (Build.VERSION.SDK_INT < 14) {
                z = false;
            } else if (ae.gKE.gHI == 2) {
                z = false;
            } else if (!Util.isNullOrNil(ac.jPu)) {
                z = false;
            } else {
                z = true;
            }
            if (!n.aot()) {
                z2 = false;
            } else if (!aj.fbg()) {
                z2 = false;
            } else if (!Util.isNullOrNil(ac.jPu)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!n.aot()) {
                z3 = false;
            } else if (!aj.fbd()) {
                z3 = false;
            } else if (!Util.isNullOrNil(ac.jPu)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (n.aot() && aj.fbe() && Util.isNullOrNil(ac.jPu)) {
                z4 = true;
            }
            if (!Util.isNullOrNil(ac.jPt) || !Util.isNullOrNil(ac.jPu)) {
                if (!Util.isNullOrNil(ac.jPt)) {
                    String[] split = str.split("(//?)");
                    StringBuilder sb = new StringBuilder();
                    sb.append(split[0]).append("//").append(ac.jPt);
                    for (int i2 = 2; i2 < split.length; i2++) {
                        sb.append(FilePathGenerator.ANDROID_DIR_SEP).append(split[i2]);
                    }
                    str = sb.toString();
                    Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
                }
                if (!Util.isNullOrNil(ac.jPu)) {
                    str = m(str, "tp=" + ac.jPu);
                    Log.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(str)));
                }
            } else if (z4) {
                str = m(str, "tp=wxpic");
                Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (z2) {
                str = m(str, "tp=wxpc");
                Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (z3) {
                str = m(str, "tp=hevc");
                Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (z) {
                str = m(str, "tp=webp");
                Log.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            }
            if (cnb.MsK != 0) {
                str = m(str, "enc=1");
                Log.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + cnb.MsL + " " + cnb.MsK + " " + str);
                b.pl(r.CTRL_INDEX);
                this.DPY = true;
            }
            str2 = str;
            try {
                String str3 = this.DPt.DPm ? cnb.MsP : cnb.viB;
                int i3 = this.DPt.DPm ? cnb.MsQ : cnb.MsN;
                if (TextUtils.isEmpty(str3)) {
                    return str2;
                }
                return m(str2, "token=".concat(String.valueOf(str3)), "idx=".concat(String.valueOf(i3)));
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e2.getMessage());
                return str2;
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = str;
            Log.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e2.getMessage());
            return str2;
        }
    }

    private static String m(String str, String... strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str.contains("?") ? "&" : "?");
        boolean z = true;
        for (String str2 : strArr) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(str2);
        }
        return sb.toString();
    }
}
