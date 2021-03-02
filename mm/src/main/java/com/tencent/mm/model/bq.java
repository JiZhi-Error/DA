package com.tencent.mm.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class bq {
    private static final Queue<Integer> iEN = new ConcurrentLinkedQueue();
    public static final long[] iEO = {0, 2000, 5000, 10000, 30000, Util.MILLSECONDS_OF_MINUTE, 180000, 300000, 600000, 1800000, Util.MILLSECONDS_OF_HOUR};
    public static final int[] iEP = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public static final int[] iEQ = {30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
    public static final int[] iER = {160, 161, TbsListener.ErrorCode.STARTDOWNLOAD_3, TbsListener.ErrorCode.STARTDOWNLOAD_4, TbsListener.ErrorCode.STARTDOWNLOAD_5, TbsListener.ErrorCode.STARTDOWNLOAD_6, 166, TbsListener.ErrorCode.STARTDOWNLOAD_8, 168, 169, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE};
    public static final int[] iES = {FacebookRequestErrorClassification.EC_INVALID_TOKEN, 191, 192, 193, 194, 195, 196, 197, z.CTRL_INDEX, 199, 200};
    private static bq iET;
    public long[] iEU = new long[12];
    public long[] iEV;

    static {
        AppMethodBeat.i(42979);
        AppMethodBeat.o(42979);
    }

    public static bq aVU() {
        AppMethodBeat.i(42977);
        if (iET == null) {
            iET = new bq();
        }
        bq bqVar = iET;
        AppMethodBeat.o(42977);
        return bqVar;
    }

    private bq() {
        int i2 = 0;
        AppMethodBeat.i(42978);
        String[] split = ((String) g.aAh().azQ().get(ar.a.USERINFO_FOREGROUND_DELAY_REPORT_LAST_TIMESTAMP_STRING_SYNC, "0,0,0,0,0,0,0,0,0,0,0,0")).split(",");
        int i3 = 0;
        while (true) {
            if (i3 >= (split.length < 12 ? split.length : 12)) {
                break;
            }
            this.iEU[i3] = Util.getLong(split[i3], 0);
            i3++;
        }
        this.iEV = new long[12];
        String[] split2 = ((String) g.aAh().azQ().get(ar.a.USERINFO_BACKGROUND_DELAY_REPORT_LAST_TIMESTAMP_STRING_SYNC, "0,0,0,0,0,0,0,0,0,0,0,0")).split(",");
        while (true) {
            if (i2 < (split2.length < 12 ? split2.length : 12)) {
                this.iEV[i2] = Util.getLong(split2[i2], 0);
                i2++;
            } else {
                AppMethodBeat.o(42978);
                return;
            }
        }
    }
}
