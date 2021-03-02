package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum d implements c {
    INSTANCE;
    
    private static c CWH = new a((byte) 0);

    public static d valueOf(String str) {
        AppMethodBeat.i(145656);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(145656);
        return dVar;
    }

    static {
        AppMethodBeat.i(145664);
        AppMethodBeat.o(145664);
    }

    static class a implements c {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.secinforeport.a.c
        public final boolean aF(int i2, long j2) {
            AppMethodBeat.i(145648);
            Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(145648);
            return false;
        }

        @Override // com.tencent.mm.plugin.secinforeport.a.c
        public final void ik(int i2, int i3) {
            AppMethodBeat.i(145649);
            Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(145649);
        }

        @Override // com.tencent.mm.plugin.secinforeport.a.c
        public final void Xj(int i2) {
            AppMethodBeat.i(145650);
            Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(145650);
        }

        @Override // com.tencent.mm.plugin.secinforeport.a.c
        public final void r(int i2, byte[] bArr) {
            AppMethodBeat.i(145651);
            Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(145651);
        }

        @Override // com.tencent.mm.plugin.secinforeport.a.c
        public final boolean aG(int i2, long j2) {
            AppMethodBeat.i(145652);
            Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(145652);
            return false;
        }

        @Override // com.tencent.mm.plugin.secinforeport.a.c
        public final void eSt() {
            AppMethodBeat.i(145653);
            Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(145653);
        }

        @Override // com.tencent.mm.plugin.secinforeport.a.c
        public final void asyncReportPaySecurityInfoThroughCgi() {
            AppMethodBeat.i(145654);
            Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(145654);
        }

        @Override // com.tencent.mm.plugin.secinforeport.a.c
        public final void Xi(int i2) {
            AppMethodBeat.i(187531);
            Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(187531);
        }

        @Override // com.tencent.mm.plugin.secinforeport.a.c
        public final void asyncReportFinderSecurityInfoThroughCgi(int i2) {
            AppMethodBeat.i(187532);
            Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(187532);
        }

        @Override // com.tencent.mm.plugin.secinforeport.a.c
        public final void u(String str, byte[] bArr) {
            AppMethodBeat.i(187533);
            Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(187533);
        }

        @Override // com.tencent.mm.plugin.secinforeport.a.c
        public final void ca(byte[] bArr) {
            AppMethodBeat.i(187534);
            Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.o(187534);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            CWH = cVar;
        }
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final boolean aF(int i2, long j2) {
        AppMethodBeat.i(145657);
        boolean aF = CWH.aF(i2, j2);
        AppMethodBeat.o(145657);
        return aF;
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void ik(int i2, int i3) {
        AppMethodBeat.i(145658);
        CWH.ik(i2, i3);
        AppMethodBeat.o(145658);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void Xj(int i2) {
        AppMethodBeat.i(145659);
        CWH.Xj(i2);
        AppMethodBeat.o(145659);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void r(int i2, byte[] bArr) {
        AppMethodBeat.i(145660);
        CWH.r(i2, bArr);
        AppMethodBeat.o(145660);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final boolean aG(int i2, long j2) {
        AppMethodBeat.i(145661);
        boolean aG = CWH.aG(i2, j2);
        AppMethodBeat.o(145661);
        return aG;
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void eSt() {
        AppMethodBeat.i(145662);
        CWH.eSt();
        AppMethodBeat.o(145662);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void asyncReportPaySecurityInfoThroughCgi() {
        AppMethodBeat.i(145663);
        CWH.asyncReportPaySecurityInfoThroughCgi();
        AppMethodBeat.o(145663);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void Xi(int i2) {
        AppMethodBeat.i(187535);
        CWH.Xi(i2);
        AppMethodBeat.o(187535);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void asyncReportFinderSecurityInfoThroughCgi(int i2) {
        AppMethodBeat.i(187536);
        CWH.asyncReportFinderSecurityInfoThroughCgi(i2);
        AppMethodBeat.o(187536);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void u(String str, byte[] bArr) {
        AppMethodBeat.i(187537);
        CWH.u(str, bArr);
        AppMethodBeat.o(187537);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void ca(byte[] bArr) {
        AppMethodBeat.i(187538);
        CWH.ca(bArr);
        AppMethodBeat.o(187538);
    }
}
