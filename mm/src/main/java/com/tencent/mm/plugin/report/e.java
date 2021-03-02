package com.tencent.mm.plugin.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Map;

public enum e implements d {
    INSTANCE;
    
    d Cxw = new a((byte) 0);

    private e(String str) {
        AppMethodBeat.i(125133);
        AppMethodBeat.o(125133);
    }

    public static e valueOf(String str) {
        AppMethodBeat.i(125132);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(125132);
        return eVar;
    }

    static {
        AppMethodBeat.i(125145);
        AppMethodBeat.o(125145);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void a(int i2, Object... objArr) {
        AppMethodBeat.i(125134);
        this.Cxw.a(i2, objArr);
        AppMethodBeat.o(125134);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void kvStat(int i2, String str) {
        AppMethodBeat.i(125135);
        this.Cxw.kvStat(i2, str);
        AppMethodBeat.o(125135);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void a(int i2, String str, boolean z, boolean z2) {
        AppMethodBeat.i(125136);
        this.Cxw.a(i2, str, z, z2);
        AppMethodBeat.o(125136);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void a(int i2, boolean z, boolean z2, boolean z3, Object... objArr) {
        AppMethodBeat.i(200828);
        this.Cxw.a(i2, z, z2, z3, objArr);
        AppMethodBeat.o(200828);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void a(int i2, int i3, String str, boolean z, boolean z2) {
        AppMethodBeat.i(200829);
        this.Cxw.a(i2, i3, str, z, z2);
        AppMethodBeat.o(200829);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void a(int i2, boolean z, boolean z2, Object... objArr) {
        AppMethodBeat.i(125137);
        this.Cxw.a(i2, z, z2, objArr);
        AppMethodBeat.o(125137);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void idkeyStat(long j2, long j3, long j4, boolean z) {
        AppMethodBeat.i(125138);
        Log.d("MicroMsg.ReportService", "idkeyStat [%d, %d] -> %d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        this.Cxw.idkeyStat(j2, j3, j4, z);
        AppMethodBeat.o(125138);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void b(ArrayList<IDKey> arrayList, boolean z) {
        AppMethodBeat.i(125139);
        this.Cxw.b(arrayList, z);
        AppMethodBeat.o(125139);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void a(int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        AppMethodBeat.i(125140);
        Log.d("MicroMsg.ReportService", "idkeyGroupForPair [%d, %d] -> %d / [%d, %d] -> %d", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i7));
        this.Cxw.a(i2, i3, i4, i5, i6, i7, z);
        AppMethodBeat.o(125140);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void b(int i2, int i3, int i4, int i5, boolean z) {
        AppMethodBeat.i(125141);
        Log.d("MicroMsg.ReportService", "idkeyGroupForPairAverger [%d, %d] -> %d / [%d, %d] -> 1", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i4));
        this.Cxw.b(i2, i3, i4, i5, z);
        AppMethodBeat.o(125141);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void setUin(int i2) {
        AppMethodBeat.i(125142);
        this.Cxw.setUin(i2);
        AppMethodBeat.o(125142);
    }

    static class a implements d {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.report.d
        public final void idkeyStat(long j2, long j3, long j4, boolean z) {
            AppMethodBeat.i(125121);
            Log.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(125121);
        }

        @Override // com.tencent.mm.plugin.report.d
        public final void setUin(int i2) {
            AppMethodBeat.i(125122);
            Log.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(125122);
        }

        @Override // com.tencent.mm.plugin.report.d
        public final void a(int i2, Object... objArr) {
            AppMethodBeat.i(125123);
            Log.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(125123);
        }

        @Override // com.tencent.mm.plugin.report.d
        public final void kvStat(int i2, String str) {
            AppMethodBeat.i(125124);
            Log.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(125124);
        }

        @Override // com.tencent.mm.plugin.report.d
        public final void a(int i2, String str, boolean z, boolean z2) {
            AppMethodBeat.i(125125);
            Log.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(125125);
        }

        @Override // com.tencent.mm.plugin.report.d
        public final void a(int i2, boolean z, boolean z2, boolean z3, Object... objArr) {
            AppMethodBeat.i(200826);
            Log.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(200826);
        }

        @Override // com.tencent.mm.plugin.report.d
        public final void a(int i2, int i3, String str, boolean z, boolean z2) {
            AppMethodBeat.i(200827);
            Log.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(200827);
        }

        @Override // com.tencent.mm.plugin.report.d
        public final void a(int i2, boolean z, boolean z2, Object... objArr) {
            AppMethodBeat.i(125126);
            Log.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(125126);
        }

        @Override // com.tencent.mm.plugin.report.d
        public final void a(int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
            AppMethodBeat.i(125127);
            Log.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(125127);
        }

        @Override // com.tencent.mm.plugin.report.d
        public final void b(int i2, int i3, int i4, int i5, boolean z) {
            AppMethodBeat.i(125128);
            Log.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(125128);
        }

        @Override // com.tencent.mm.plugin.report.d
        public final void e(String str, String str2, Map<String, Object> map) {
            AppMethodBeat.i(125129);
            Log.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(125129);
        }

        @Override // com.tencent.mm.plugin.report.d
        public final void b(ArrayList<IDKey> arrayList, boolean z) {
            AppMethodBeat.i(125130);
            Log.i("MicroMsg.ReportService", "this is DummyReportService");
            AppMethodBeat.o(125130);
        }
    }

    public static Object a(int i2, int[] iArr, Object[] objArr) {
        if (iArr.length <= 0 || iArr.length + 1 != objArr.length) {
            return null;
        }
        if (i2 <= iArr[0]) {
            return objArr[0];
        }
        for (int i3 = 0; i3 < iArr.length - 1; i3++) {
            if (iArr[i3] >= iArr[i3 + 1]) {
                return null;
            }
            if (i2 > iArr[i3] && i2 <= iArr[i3 + 1]) {
                return objArr[i3 + 1];
            }
        }
        return objArr[objArr.length - 1];
    }

    public static Object a(int i2, int[] iArr, int i3, int i4) {
        AppMethodBeat.i(125143);
        if (iArr == null || iArr.length <= 0 || i4 <= i3 || i4 > 255 || iArr.length != i4 - i3) {
            AppMethodBeat.o(125143);
            return null;
        } else if (i2 <= iArr[0]) {
            Integer valueOf = Integer.valueOf(i3);
            AppMethodBeat.o(125143);
            return valueOf;
        } else {
            for (int i5 = 0; i5 < iArr.length - 1; i5++) {
                if (iArr[i5] >= iArr[i5 + 1]) {
                    AppMethodBeat.o(125143);
                    return null;
                } else if (i2 > iArr[i5] && i2 <= iArr[i5 + 1]) {
                    Integer valueOf2 = Integer.valueOf(i5 + i3 + 1);
                    AppMethodBeat.o(125143);
                    return valueOf2;
                }
            }
            Integer valueOf3 = Integer.valueOf(i4);
            AppMethodBeat.o(125143);
            return valueOf3;
        }
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void e(String str, String str2, Map<String, Object> map) {
        AppMethodBeat.i(125144);
        this.Cxw.e(str, str2, map);
        AppMethodBeat.o(125144);
    }
}
