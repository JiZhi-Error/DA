package com.tencent.pb.common.c;

import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.f;
import com.tencent.pb.common.b.h;
import java.util.ArrayList;
import java.util.HashMap;

public final class e {
    private static HashMap<String, String> RGV = new HashMap<>();
    private static Object sLock = new Object();

    public static void U(int i2, int i3, String str) {
        if (str == null) {
            b.w("gyz", "addEmergencyRecord value is null");
            return;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i2);
            stringBuffer.append("---");
            stringBuffer.append(i3);
            synchronized (sLock) {
                String str2 = RGV.get(stringBuffer.toString());
                if (str2 != null && str2.length() > 0) {
                    StringBuffer stringBuffer2 = new StringBuffer(str2);
                    stringBuffer2.append("---");
                    stringBuffer2.append(str);
                    str = stringBuffer2.toString();
                }
                RGV.put(stringBuffer.toString(), str);
            }
        } catch (Throwable th) {
            b.w("gyz", th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r4.hasNext() == false) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        r0 = r4.next();
        r1 = r0.split("---");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (r1.length < 2) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        r5 = r1[0];
        r6 = r1[1];
        r1 = com.tencent.pb.common.c.e.sLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0 = com.tencent.pb.common.c.e.RGV.get(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r0 == null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (r0.length() == 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r7 = r0.split("---");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r7 == null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        if (r7.length == 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        r8 = r7.length;
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
        if (r1 >= r8) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005e, code lost:
        r0 = r7[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
        if (r0 == null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (r0.length() == 0) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0068, code lost:
        r9 = r0.split("%");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0070, code lost:
        if (r9.length != 2) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0072, code lost:
        r0 = r9[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0074, code lost:
        r9 = new com.tencent.pb.common.b.a.a.a.y();
        r9.sXO = r5;
        r3.setLength(0);
        r3.append(r6);
        r3.append("%");
        r3.append(r0);
        r9.REJ = r3.toString();
        r13.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0093, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        r3 = new java.lang.StringBuffer();
        r4 = r0.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void bv(java.util.ArrayList<com.tencent.pb.common.b.a.a.a.y> r13) {
        /*
        // Method dump skipped, instructions count: 157
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.pb.common.c.e.bv(java.util.ArrayList):void");
    }

    public static void clearData() {
        synchronized (sLock) {
            RGV.clear();
        }
    }

    public static void hjp() {
        a.c cVar;
        if (!h.isNetworkConnected()) {
            b.w("StatisticsUtil", "reportStatisticsData network is false");
            return;
        }
        ArrayList arrayList = new ArrayList();
        bv(arrayList);
        if (arrayList.size() > 0) {
            cVar = new a.c();
            a.y[] yVarArr = new a.y[arrayList.size()];
            arrayList.toArray(yVarArr);
            cVar.RDp = yVarArr;
        } else {
            cVar = null;
        }
        if (cVar == null) {
            b.w("StatisticsUtil", "reportStatisticsData CSClientReportReq is null");
            return;
        }
        b.w("yunying", "reportStatisticsData");
        b.d("StatisticsUtil", "reportStatisticsData start ret: ", Integer.valueOf(f.hiZ().a(new com.tencent.pb.common.b.a() {
            /* class com.tencent.pb.common.c.e.AnonymousClass1 */

            @Override // com.tencent.pb.common.b.a
            public final void hu(String str, int i2) {
                if ("CsCmd.Cmd_CSClientReportReq".equals(str)) {
                    if (i2 == 0) {
                        e.clearData();
                    }
                    b.w("yunying", "reportStatisticsData isCommonData:  errCode: ".concat(String.valueOf(i2)));
                }
            }
        }, "CsCmd.Cmd_CSClientReportReq", cVar)));
    }
}
