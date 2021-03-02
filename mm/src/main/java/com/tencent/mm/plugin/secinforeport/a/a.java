package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.coy;
import com.tencent.mm.protocal.protobuf.fay;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public enum a {
    INSTANCE;
    
    private static b CWE = new b() {
        /* class com.tencent.mm.plugin.secinforeport.a.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.secinforeport.a.b
        public final void a(int i2, String str, int i3, byte[] bArr) {
            AppMethodBeat.i(145641);
            Log.i("MicroMsg.ClipBordReport", "!! Dummy implementation !!");
            AppMethodBeat.o(145641);
        }
    };

    public static a valueOf(String str) {
        AppMethodBeat.i(145643);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(145643);
        return aVar;
    }

    static {
        AppMethodBeat.i(145647);
        AppMethodBeat.o(145647);
    }

    public static void a(b bVar) {
        if (bVar != null) {
            CWE = bVar;
        }
    }

    public static void q(int i2, String str, int i3) {
        AppMethodBeat.i(145644);
        Log.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d", Integer.valueOf(i2), str, Integer.valueOf(i3));
        CWE.a(i2, str, i3, null);
        AppMethodBeat.o(145644);
    }

    public static void k(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(145645);
        Log.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d, %d, %s", 3, str, Integer.valueOf(i2), Integer.valueOf(i3), str2);
        fay fay = new fay();
        fay.Mro = i3;
        fay.Nxq = str2;
        byte[] bArr = null;
        try {
            bArr = fay.toByteArray();
        } catch (IOException e2) {
            Log.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", e2.getMessage());
        }
        CWE.a(3, str, i2, bArr);
        AppMethodBeat.o(145645);
    }

    public static void N(int i2, String str, String str2) {
        AppMethodBeat.i(145646);
        Log.v("MicroMsg.ClipBordReport", "report reportMiniProgram %d, %d, %s, %s", 5, Integer.valueOf(i2), str, str2);
        coy coy = new coy();
        coy.dNI = str;
        coy.Cqk = str2;
        byte[] bArr = null;
        try {
            bArr = coy.toByteArray();
        } catch (IOException e2) {
            Log.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", e2.getMessage());
        }
        CWE.a(5, "", i2, bArr);
        AppMethodBeat.o(145646);
    }
}
