package com.tencent.mm.plugin.multitalk.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Map;
import kotlin.a.ae;
import kotlin.l;
import kotlin.s;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u00013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020$J\u000e\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020)J\u0018\u00100\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020$H\u0002J\u0006\u00101\u001a\u00020)J\u0006\u00102\u001a\u00020)R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper;", "", "()V", "IDKEY_ID", "", "IDKEY_KEY_SCREEN_HW_DECODE", "IDKEY_KEY_SCREEN_HW_TIME", "IDKEY_KEY_SCREEN_RENDER", "IDKEY_KEY_SCREEN_SOFT_DECODE", "IDKEY_KEY_SCREEN_SOFT_TIME", "IDKEY_KEY_SWITCH_TO_HW", "IDKEY_KEY_SWITCH_TO_SOFT", "IDKEY_KEY_VIDEO_DECODE", "IDKEY_KEY_VIDEO_RENDER", "SCREEN_DECODE_TYPE_HW", "SCREEN_DECODE_TYPE_NONE", "SCREEN_DECODE_TYPE_SOFT", "SCREEN_HW_DECODE_COST", "SCREEN_RENDER_COST", "SCREEN_SOFT_DECODE_COST", "SWITCH_TO_HW", "SWITCH_TO_SOFT", "TAG", "", "VIDEO_DECODE_COST", "VIDEO_RENDER_COST", "costArray", "", "Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "[Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "curScreenDecodeType", "incArray", "", "keyMap", "", "receiveScreenTime", "", "screenHwDecodeTime", "screenSoftDecodeTime", "startReceiveTime", "append", "", "key", "cost", "decodeTypeSwitch", "curType", "inc", "report", "reportAvg", "reset", "stopReceiveScreen", "CostInfo", "plugin-multitalk_release"})
public final class d {
    private static final a[] zYS;
    private static final Map<Integer, Integer> zYT = ae.e(s.U(0, 0), s.U(1, 3), s.U(2, 6), s.U(3, 9), s.U(4, 12));
    private static final int[] zYU = new int[2];
    private static long zYV;
    private static long zYW;
    private static long zYX;
    private static long zYY;
    private static int zYZ;
    public static final d zZa = new d();

    static {
        AppMethodBeat.i(240097);
        a[] aVarArr = new a[5];
        for (int i2 = 0; i2 < 5; i2++) {
            aVarArr[i2] = new a(i2);
        }
        zYS = aVarArr;
        AppMethodBeat.o(240097);
    }

    private d() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkReportHelper$CostInfo;", "", "idx", "", "totalCost", "", "times", "(IJI)V", "getIdx", "()I", "getTimes", "setTimes", "(I)V", "getTotalCost", "()J", "setTotalCost", "(J)V", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-multitalk_release"})
    public static final class a {
        int hjI = 0;
        final int idx;
        long zZb = 0;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.idx == aVar.idx && this.zZb == aVar.zZb && this.hjI == aVar.hjI)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.zZb;
            return (((this.idx * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.hjI;
        }

        public final String toString() {
            AppMethodBeat.i(240092);
            String str = "CostInfo(idx=" + this.idx + ", totalCost=" + this.zZb + ", times=" + this.hjI + ")";
            AppMethodBeat.o(240092);
            return str;
        }

        public a(int i2) {
            this.idx = i2;
        }
    }

    public static void RC(int i2) {
        AppMethodBeat.i(240093);
        if (zYZ == 0) {
            zYV = System.currentTimeMillis();
        }
        if (i2 != zYZ) {
            if (i2 == 1) {
                RD(0);
                long currentTimeMillis = System.currentTimeMillis() - zYV;
                zYX += currentTimeMillis;
                zYW = currentTimeMillis + zYW;
            } else if (i2 == 2) {
                RD(1);
                long currentTimeMillis2 = System.currentTimeMillis() - zYV;
                zYY += currentTimeMillis2;
                zYW = currentTimeMillis2 + zYW;
            }
            zYV = System.currentTimeMillis();
            zYZ = i2;
        }
        AppMethodBeat.o(240093);
    }

    public static void eof() {
        AppMethodBeat.i(240094);
        if (zYZ == 1) {
            long currentTimeMillis = System.currentTimeMillis() - zYV;
            zYX += currentTimeMillis;
            zYW = currentTimeMillis + zYW;
            AppMethodBeat.o(240094);
            return;
        }
        if (zYZ == 2) {
            long currentTimeMillis2 = System.currentTimeMillis() - zYV;
            zYY += currentTimeMillis2;
            zYW = currentTimeMillis2 + zYW;
        }
        AppMethodBeat.o(240094);
    }

    public static void append(int i2, long j2) {
        a aVar = zYS[i2];
        aVar.hjI++;
        aVar.zZb += j2;
    }

    private static void RD(int i2) {
        int[] iArr = zYU;
        iArr[i2] = iArr[i2] + 1;
    }

    public static void report() {
        AppMethodBeat.i(240095);
        a[] aVarArr = zYS;
        ArrayList<a> arrayList = new ArrayList();
        for (a aVar : aVarArr) {
            if (aVar.hjI > 5) {
                arrayList.add(aVar);
            }
        }
        for (a aVar2 : arrayList) {
            Integer num = zYT.get(Integer.valueOf(aVar2.idx));
            if (num != null) {
                au(num.intValue(), aVar2.zZb / ((long) aVar2.hjI));
            }
        }
        if (zYW > 0) {
            au(15, (long) zYU[0]);
            au(18, (long) zYU[1]);
            au(21, (long) ((((float) zYX) / ((float) zYW)) * 100.0f));
            au(24, (long) ((((float) zYY) / ((float) zYW)) * 100.0f));
        }
        reset();
        AppMethodBeat.o(240095);
    }

    public static void reset() {
        a[] aVarArr = zYS;
        for (a aVar : aVarArr) {
            aVar.zZb = 0;
            aVar.hjI = 0;
        }
        int length = zYU.length;
        for (int i2 = 0; i2 < length; i2++) {
            zYU[i2] = 0;
        }
        zYV = 0;
        zYW = 0;
        zYY = 0;
        zYX = 0;
        zYZ = 0;
    }

    private static void au(int i2, long j2) {
        AppMethodBeat.i(240096);
        Log.i("MultitalkReportHelper", "report avg key: " + i2 + " value: " + j2);
        h.INSTANCE.b(1438, i2, i2 + 1, (int) j2, false);
        AppMethodBeat.o(240096);
    }
}
