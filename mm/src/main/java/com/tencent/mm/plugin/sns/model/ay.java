package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ay {
    public static String cs(int i2, String str) {
        AppMethodBeat.i(95954);
        String a2 = c.a("snsvideo", (long) i2, "sns", str);
        if (Util.isNullOrNil(a2)) {
            AppMethodBeat.o(95954);
            return null;
        }
        AppMethodBeat.o(95954);
        return a2;
    }

    public static String Qv(String str) {
        AppMethodBeat.i(95955);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(95955);
            return "";
        }
        String concat = "SNS_".concat(String.valueOf(str));
        Log.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", str, concat);
        AppMethodBeat.o(95955);
        return concat;
    }

    public static String aPq(String str) {
        AppMethodBeat.i(95956);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(95956);
            return "";
        }
        int indexOf = str.indexOf("SNS_");
        if (indexOf < 0) {
            AppMethodBeat.o(95956);
            return "";
        }
        String str2 = "";
        try {
            str2 = str.substring(indexOf + 4);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(95956);
        return str2;
    }

    public static String aPr(String str) {
        AppMethodBeat.i(95957);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(95957);
            return null;
        }
        String ki = ar.ki(aj.getAccSnsPath(), str);
        Log.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", ki, str);
        AppMethodBeat.o(95957);
        return ki;
    }

    public static String E(cnb cnb) {
        AppMethodBeat.i(95958);
        if (cnb == null) {
            AppMethodBeat.o(95958);
            return null;
        }
        String str = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.j(cnb);
        Log.i("MicroMsg.SnsVideoLogic", "get sns video path %s", str);
        AppMethodBeat.o(95958);
        return str;
    }

    public static boolean fE(String str, int i2) {
        AppMethodBeat.i(95960);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
            AppMethodBeat.o(95960);
            return false;
        }
        String Qv = Qv(str);
        s sVar = new s();
        sVar.fileName = Qv;
        sVar.createTime = Util.nowSecond();
        sVar.status = 130;
        sVar.gqW = i2;
        boolean b2 = o.bhj().b(sVar);
        Log.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", Qv, Boolean.valueOf(b2));
        AppMethodBeat.o(95960);
        return b2;
    }

    public static boolean kk(String str, String str2) {
        boolean z;
        boolean c2;
        AppMethodBeat.i(95962);
        s aPs = aPs(str);
        if (aPs == null) {
            aPs = new s();
            aPs.fileName = Qv(str);
            z = true;
        } else {
            z = false;
        }
        aPs.createTime = Util.nowSecond();
        aPs.ebj = str2;
        aPs.status = 199;
        if (z) {
            c2 = o.bhj().b(aPs);
        } else {
            aPs.cSx = 33555200;
            c2 = o.bhj().c(aPs);
        }
        Log.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", str, str2, Boolean.valueOf(c2));
        AppMethodBeat.o(95962);
        return c2;
    }

    public static s aPs(String str) {
        AppMethodBeat.i(95963);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(95963);
            return null;
        }
        s QN = u.QN(Qv(str));
        AppMethodBeat.o(95963);
        return QN;
    }

    public static String a(String str, cnb cnb) {
        String str2;
        AppMethodBeat.i(95959);
        if (cnb == null) {
            str2 = null;
        } else {
            str2 = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.p(cnb);
            Log.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", str2);
        }
        if (com.tencent.mm.vfs.s.YS(str2)) {
            Log.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", str, str2);
            AppMethodBeat.o(95959);
            return str2;
        }
        String E = E(cnb);
        boolean YS = com.tencent.mm.vfs.s.YS(E);
        s aPs = aPs(str);
        if (aPs == null) {
            if (YS) {
                Log.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", str, E);
                AppMethodBeat.o(95959);
                return E;
            }
            Log.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", str);
            AppMethodBeat.o(95959);
            return null;
        } else if (!YS || !aPs.bhy()) {
            Log.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", str, Boolean.valueOf(YS), Integer.valueOf(aPs.status));
            AppMethodBeat.o(95959);
            return null;
        } else {
            Log.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", str, E);
            AppMethodBeat.o(95959);
            return E;
        }
    }

    public static boolean c(s sVar, int i2) {
        AppMethodBeat.i(95961);
        sVar.status = 130;
        sVar.gqW = i2;
        sVar.cSx = 268435712;
        boolean c2 = o.bhj().c(sVar);
        Log.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", sVar.getFileName(), Boolean.valueOf(c2));
        AppMethodBeat.o(95961);
        return c2;
    }
}
