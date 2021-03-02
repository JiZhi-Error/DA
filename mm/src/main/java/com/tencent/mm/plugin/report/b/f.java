package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.r;
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.wx.util.WXUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class f {
    public static boolean aMt(String str) {
        AppMethodBeat.i(143794);
        o oVar = new o("/sdcard/cov.txt");
        if (!oVar.exists()) {
            Log.w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
            AppMethodBeat.o(143794);
            return false;
        }
        String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "never_login_crash");
        a(aA, oVar, str);
        String a2 = r.a(oVar, false, "/sdcard/cov/cov_" + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".zip");
        if (a2 == null) {
            Log.e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
            AppMethodBeat.o(143794);
            return false;
        }
        oVar.delete();
        Log.i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :".concat(String.valueOf(aA)));
        aa.a(a2, aA, false, false, 10, 20004);
        AppMethodBeat.o(143794);
        return true;
    }

    private static void a(String str, o oVar, String str2) {
        AppMethodBeat.i(176168);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#username=".concat(String.valueOf(str)));
        stringBuffer.append("\n");
        stringBuffer.append("#rev=" + BuildInfo.REV);
        stringBuffer.append("\n");
        stringBuffer.append("#path=" + BuildInfo.SVNPATH);
        stringBuffer.append("\n");
        if (str2.length() > 0) {
            stringBuffer.append("#startrev=".concat(String.valueOf(str2)));
            stringBuffer.append("\n");
        }
        String z = com.tencent.mm.vfs.aa.z(oVar.her());
        byte[] bytes = stringBuffer.toString().getBytes();
        s.e(z, bytes, bytes.length);
        AppMethodBeat.o(176168);
    }
}
