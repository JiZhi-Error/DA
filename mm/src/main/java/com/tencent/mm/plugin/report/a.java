package com.tencent.mm.plugin.report;

import android.os.Process;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a {
    private static int Cxo = 1;
    private static final f<Integer, Long> sLp = new h(50);

    public abstract String abV();

    public abstract String abW();

    public abstract int getId();

    public static String t(Object... objArr) {
        if (objArr.length <= 0) {
            Log.w("MicroMsg.AbsReportStruct", "vals is null, use '' as value");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length - 1;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(String.valueOf(objArr[i2])).append(',');
        }
        sb.append(String.valueOf(objArr[length]));
        return sb.toString();
    }

    public final boolean bfK() {
        int id = getId();
        String abV = abV();
        Log.d("MicroMsg.AbsReportStruct", "report %d %s", Integer.valueOf(getId()), abV());
        if (id <= 0 || Util.isNullOrNil(abV)) {
            return false;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(getId(), abV());
        return true;
    }

    public final boolean eOp() {
        int id = getId();
        String abV = abV();
        Log.d("MicroMsg.AbsReportStruct", "report %d %s", Integer.valueOf(getId()), abV());
        if (id <= 0 || Util.isNullOrNil(abV)) {
            return false;
        }
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        com.tencent.mm.plugin.report.service.h.c(getId(), abV(), false, true);
        return true;
    }

    public final boolean eOq() {
        long j2;
        int id = getId();
        String abV = abV();
        if (id <= 0 || Util.isNullOrNil(abV)) {
            return false;
        }
        String str = id + "," + abV;
        int hashCode = str.hashCode();
        Long l = sLp.get(Integer.valueOf(hashCode));
        if (l != null) {
            j2 = l.longValue();
        } else {
            j2 = 0;
        }
        if (Util.milliSecondsToNow(j2) < 300000) {
            Log.v("MicroMsg.AbsReportStruct", "clock report [%s] less than 5 min, don't report", str);
            return false;
        }
        sLp.put(Integer.valueOf(hashCode), Long.valueOf(Util.nowMilliSecond()));
        return bfK();
    }

    /* access modifiers changed from: protected */
    public final void jN(String str, String str2) {
        Log.w("MicroMsg.AbsReportStruct", "error report [%d] msg[%s %s]", Integer.valueOf(getId()), str, str2);
    }

    /* access modifiers changed from: protected */
    public final boolean bi(String str, long j2) {
        if (j2 <= 0) {
            jN(str, String.valueOf(j2));
            return false;
        } else if (j2 < Util.MILLSECONDS_OF_HOUR) {
            return true;
        } else {
            jN(str, String.valueOf(j2));
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean bj(String str, long j2) {
        if (j2 > 151473600000L) {
            return true;
        }
        jN(str, String.valueOf(j2));
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean bk(String str, long j2) {
        if (j2 > 151473600) {
            return true;
        }
        jN(str, String.valueOf(j2));
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean aMq(String str) {
        if (Util.isNullOrNil(str)) {
            jN("", "check rpt value is null.");
            return false;
        } else if (str.length() < 7168) {
            return true;
        } else {
            jN("", "check rpt value more than 7k.");
            return false;
        }
    }

    public final String x(String str, String str2, boolean z) {
        if (Util.isNullOrNil(str2) || !str2.contains(",")) {
            return str2;
        }
        if (WeChatSomeFeatureSwitch.blockCNMobile() || !z || (!BuildInfo.DEBUG && !BuildInfo.IS_FLAVOR_RED)) {
            jN(str, "value contain comma, please confirm your logic. value :".concat(String.valueOf(str2)));
        } else {
            Assert.fail("value contain comma, please confirm your logic.log id:" + getId() + " field:" + str + " value:" + str2);
        }
        return str2.replace(',', ' ');
    }

    protected static boolean getBoolean(String str) {
        if (Util.getInt(str, 0) != 0) {
            return true;
        }
        return false;
    }

    public static List<String> aMr(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            int ceil = (int) Math.ceil(((double) str.length()) / 5120.0d);
            for (int i2 = 0; i2 < ceil; i2++) {
                arrayList.add(str.substring(i2 * 5120, Math.min((i2 + 1) * 5120, str.length())));
            }
            return arrayList;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AbsReportStruct", e2, "check to report list error [%s]", e2.toString());
            return null;
        }
    }

    public static int eOr() {
        StringBuilder append = new StringBuilder().append(Process.myPid()).append("_").append(Util.nowMilliSecond()).append("_");
        int i2 = Cxo;
        Cxo = i2 + 1;
        return Math.abs(append.append(i2).toString().hashCode());
    }
}
