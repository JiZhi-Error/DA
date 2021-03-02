package com.tencent.mm.plugin.normsg.a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.c;
import com.tencent.mm.normsgext.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;

public enum d implements a {
    INSTANCE;
    
    private static final byte[] AEG = new byte[0];
    private static a AEH = new a((byte) 0);

    public static d valueOf(String str) {
        AppMethodBeat.i(155509);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(155509);
        return dVar;
    }

    static {
        AppMethodBeat.i(155541);
        AppMethodBeat.o(155541);
    }

    static class a implements a {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final byte[] TJ(int i2) {
            AppMethodBeat.i(155477);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            byte[] bArr = new byte[0];
            AppMethodBeat.o(155477);
            return bArr;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void au(int i2, int i3, int i4) {
            AppMethodBeat.i(155478);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155478);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final String aIJ(String str) {
            AppMethodBeat.i(155479);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155479);
            return str;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final String TK(int i2) {
            AppMethodBeat.i(155480);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155480);
            return "";
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final String sv(boolean z) {
            AppMethodBeat.i(155481);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155481);
            return "";
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final String exG() {
            AppMethodBeat.i(155482);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155482);
            return "";
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final boolean exH() {
            AppMethodBeat.i(155483);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155483);
            return false;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final boolean exI() {
            AppMethodBeat.i(155484);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155484);
            return false;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final boolean c(Object obj, Class cls) {
            AppMethodBeat.i(155485);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155485);
            return false;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final byte[] exJ() {
            AppMethodBeat.i(155486);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            byte[] bArr = new byte[0];
            AppMethodBeat.o(155486);
            return bArr;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final boolean dH(Object obj) {
            AppMethodBeat.i(155487);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155487);
            return false;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void a(View view, Class<? extends IEvent> cls) {
            AppMethodBeat.i(155488);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155488);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void TL(int i2) {
            AppMethodBeat.i(155489);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155489);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final boolean a(int i2, byte[] bArr, int i3, int i4, PInt pInt, PInt pInt2, PByteArray pByteArray) {
            AppMethodBeat.i(155490);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155490);
            return false;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final boolean a(int i2, byte[] bArr, int i3, int i4, PByteArray pByteArray) {
            AppMethodBeat.i(155491);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155491);
            return false;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void aIL(String str) {
            AppMethodBeat.i(155492);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155492);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void aIM(String str) {
            AppMethodBeat.i(155493);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155493);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void aIN(String str) {
            AppMethodBeat.i(155494);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155494);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final boolean aIO(String str) {
            AppMethodBeat.i(155495);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155495);
            return false;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final byte[] aIP(String str) {
            AppMethodBeat.i(155496);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            byte[] bArr = new byte[0];
            AppMethodBeat.o(155496);
            return bArr;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void aA(String str, String str2, String str3) {
            AppMethodBeat.i(192287);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(192287);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void jf(String str, String str2) {
            AppMethodBeat.i(155497);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155497);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void a(String str, MotionEvent motionEvent) {
            AppMethodBeat.i(155498);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155498);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void aIQ(String str) {
            AppMethodBeat.i(155499);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155499);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final boolean aIR(String str) {
            AppMethodBeat.i(155500);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155500);
            return false;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final byte[] aIS(String str) {
            AppMethodBeat.i(155501);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            byte[] bArr = new byte[0];
            AppMethodBeat.o(155501);
            return bArr;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final String aIT(String str) {
            AppMethodBeat.i(192288);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(192288);
            return "";
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final byte[] exK() {
            AppMethodBeat.i(155502);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            byte[] bArr = new byte[0];
            AppMethodBeat.o(155502);
            return bArr;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final byte[] TM(int i2) {
            AppMethodBeat.i(155503);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            byte[] bArr = new byte[0];
            AppMethodBeat.o(155503);
            return bArr;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final boolean K(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(155504);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155504);
            return false;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final boolean exL() {
            AppMethodBeat.i(155505);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155505);
            return false;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final byte[] exM() {
            AppMethodBeat.i(155506);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            byte[] bArr = new byte[0];
            AppMethodBeat.o(155506);
            return bArr;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final String aoK() {
            AppMethodBeat.i(155507);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(155507);
            return "";
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final boolean exN() {
            AppMethodBeat.i(192289);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(192289);
            return false;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final String exO() {
            AppMethodBeat.i(192290);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(192290);
            return "";
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final String exP() {
            AppMethodBeat.i(192291);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(192291);
            return "";
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final String exQ() {
            AppMethodBeat.i(192292);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(192292);
            return "";
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final com.tencent.mm.normsg.a exR() {
            AppMethodBeat.i(192293);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(192293);
            return null;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final com.tencent.mm.normsgext.a exS() {
            AppMethodBeat.i(192294);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(192294);
            return null;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final String[] aIU(String str) {
            AppMethodBeat.i(192295);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            String[] strArr = new String[0];
            AppMethodBeat.o(192295);
            return strArr;
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void exT() {
            AppMethodBeat.i(192296);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(192296);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void eW(String str, int i2) {
            AppMethodBeat.i(192297);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(192297);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void a(b bVar) {
            AppMethodBeat.i(192298);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(192298);
        }

        @Override // com.tencent.mm.plugin.normsg.a.a
        public final void sw(boolean z) {
            AppMethodBeat.i(192299);
            Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            AppMethodBeat.o(192299);
        }
    }

    public static void a(a aVar) {
        AppMethodBeat.i(192300);
        if (!(AEH instanceof a)) {
            Log.w("MicroMsg.NormsgSource", "[!] Impl was already injected.");
            AppMethodBeat.o(192300);
            return;
        }
        synchronized (AEG) {
            try {
                if (!(AEH instanceof a)) {
                    Log.w("MicroMsg.NormsgSource", "[!] Impl was already injected.");
                } else if (aVar != null) {
                    c.q.c0(aVar.exR());
                    d.n.c0(aVar.exS());
                    aVar.exT();
                    AEH = aVar;
                }
            } finally {
                AppMethodBeat.o(192300);
            }
        }
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] TJ(int i2) {
        AppMethodBeat.i(155510);
        byte[] TJ = AEH.TJ(i2);
        AppMethodBeat.o(155510);
        return TJ;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void au(int i2, int i3, int i4) {
        AppMethodBeat.i(155511);
        AEH.au(i2, i3, i4);
        AppMethodBeat.o(155511);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String aIJ(String str) {
        AppMethodBeat.i(155512);
        String aIJ = AEH.aIJ(str);
        AppMethodBeat.o(155512);
        return aIJ;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String TK(int i2) {
        AppMethodBeat.i(155513);
        String TK = AEH.TK(i2);
        AppMethodBeat.o(155513);
        return TK;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String sv(boolean z) {
        AppMethodBeat.i(155514);
        String sv = AEH.sv(z);
        AppMethodBeat.o(155514);
        return sv;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String exG() {
        AppMethodBeat.i(155515);
        String exG = AEH.exG();
        AppMethodBeat.o(155515);
        return exG;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean exH() {
        AppMethodBeat.i(155516);
        boolean exH = AEH.exH();
        AppMethodBeat.o(155516);
        return exH;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean exI() {
        AppMethodBeat.i(155517);
        boolean exI = AEH.exI();
        AppMethodBeat.o(155517);
        return exI;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean c(Object obj, Class cls) {
        AppMethodBeat.i(155518);
        boolean c2 = AEH.c(obj, cls);
        AppMethodBeat.o(155518);
        return c2;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] exJ() {
        AppMethodBeat.i(155519);
        byte[] exJ = AEH.exJ();
        AppMethodBeat.o(155519);
        return exJ;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean dH(Object obj) {
        AppMethodBeat.i(155520);
        boolean dH = AEH.dH(obj);
        AppMethodBeat.o(155520);
        return dH;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void a(View view, Class<? extends IEvent> cls) {
        AppMethodBeat.i(155521);
        AEH.a(view, cls);
        AppMethodBeat.o(155521);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void TL(int i2) {
        AppMethodBeat.i(155522);
        AEH.TL(i2);
        AppMethodBeat.o(155522);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean a(int i2, byte[] bArr, int i3, int i4, PInt pInt, PInt pInt2, PByteArray pByteArray) {
        AppMethodBeat.i(155523);
        boolean a2 = AEH.a(i2, bArr, i3, i4, pInt, pInt2, pByteArray);
        AppMethodBeat.o(155523);
        return a2;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean a(int i2, byte[] bArr, int i3, int i4, PByteArray pByteArray) {
        AppMethodBeat.i(155524);
        boolean a2 = AEH.a(i2, bArr, i3, i4, pByteArray);
        AppMethodBeat.o(155524);
        return a2;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void aIL(String str) {
        AppMethodBeat.i(155525);
        AEH.aIL(str);
        AppMethodBeat.o(155525);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void aIM(String str) {
        AppMethodBeat.i(155526);
        AEH.aIM(str);
        AppMethodBeat.o(155526);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void aIN(String str) {
        AppMethodBeat.i(155527);
        AEH.aIN(str);
        AppMethodBeat.o(155527);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean aIO(String str) {
        AppMethodBeat.i(155528);
        boolean aIO = AEH.aIO(str);
        AppMethodBeat.o(155528);
        return aIO;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] aIP(String str) {
        AppMethodBeat.i(155529);
        byte[] aIP = AEH.aIP(str);
        AppMethodBeat.o(155529);
        return aIP;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void aA(String str, String str2, String str3) {
        AppMethodBeat.i(192301);
        AEH.aA(str, str2, str3);
        AppMethodBeat.o(192301);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void jf(String str, String str2) {
        AppMethodBeat.i(155530);
        AEH.jf(str, str2);
        AppMethodBeat.o(155530);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void a(String str, MotionEvent motionEvent) {
        AppMethodBeat.i(155531);
        AEH.a(str, motionEvent);
        AppMethodBeat.o(155531);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void aIQ(String str) {
        AppMethodBeat.i(155532);
        AEH.aIQ(str);
        AppMethodBeat.o(155532);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean aIR(String str) {
        AppMethodBeat.i(155533);
        boolean aIR = AEH.aIR(str);
        AppMethodBeat.o(155533);
        return aIR;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] aIS(String str) {
        AppMethodBeat.i(155534);
        byte[] aIS = AEH.aIS(str);
        AppMethodBeat.o(155534);
        return aIS;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String aIT(String str) {
        AppMethodBeat.i(192302);
        String aIT = AEH.aIT(str);
        AppMethodBeat.o(192302);
        return aIT;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] exK() {
        AppMethodBeat.i(155535);
        byte[] exK = AEH.exK();
        AppMethodBeat.o(155535);
        return exK;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] TM(int i2) {
        AppMethodBeat.i(155536);
        byte[] TM = AEH.TM(i2);
        AppMethodBeat.o(155536);
        return TM;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean K(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(155537);
        boolean K = AEH.K(bArr, i2, i3);
        AppMethodBeat.o(155537);
        return K;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean exL() {
        AppMethodBeat.i(155538);
        boolean exL = AEH.exL();
        AppMethodBeat.o(155538);
        return exL;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] exM() {
        AppMethodBeat.i(155539);
        byte[] exM = AEH.exM();
        AppMethodBeat.o(155539);
        return exM;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String aoK() {
        AppMethodBeat.i(155540);
        String aoK = AEH.aoK();
        AppMethodBeat.o(155540);
        return aoK;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean exN() {
        AppMethodBeat.i(192303);
        boolean exN = AEH.exN();
        AppMethodBeat.o(192303);
        return exN;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String exO() {
        AppMethodBeat.i(192304);
        String exO = AEH.exO();
        AppMethodBeat.o(192304);
        return exO;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String exP() {
        AppMethodBeat.i(192305);
        String exP = AEH.exP();
        AppMethodBeat.o(192305);
        return exP;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String exQ() {
        AppMethodBeat.i(192306);
        String exQ = AEH.exQ();
        AppMethodBeat.o(192306);
        return exQ;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final com.tencent.mm.normsg.a exR() {
        AppMethodBeat.i(192307);
        com.tencent.mm.normsg.a exR = AEH.exR();
        AppMethodBeat.o(192307);
        return exR;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final com.tencent.mm.normsgext.a exS() {
        AppMethodBeat.i(192308);
        com.tencent.mm.normsgext.a exS = AEH.exS();
        AppMethodBeat.o(192308);
        return exS;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String[] aIU(String str) {
        AppMethodBeat.i(192309);
        String[] aIU = AEH.aIU(str);
        AppMethodBeat.o(192309);
        return aIU;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void exT() {
        AppMethodBeat.i(192310);
        AEH.exT();
        AppMethodBeat.o(192310);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void eW(String str, int i2) {
        AppMethodBeat.i(192311);
        AEH.eW(str, i2);
        AppMethodBeat.o(192311);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void a(b bVar) {
        AppMethodBeat.i(192312);
        AEH.a(bVar);
        AppMethodBeat.o(192312);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void sw(boolean z) {
        AppMethodBeat.i(192313);
        AEH.sw(z);
        AppMethodBeat.o(192313);
    }
}
