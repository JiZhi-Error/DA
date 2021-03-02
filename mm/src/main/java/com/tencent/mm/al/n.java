package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ewt;
import com.tencent.mm.protocal.protobuf.ewu;
import com.tencent.mm.protocal.protobuf.eww;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class n {
    public static eww Nt(String str) {
        AppMethodBeat.i(212176);
        try {
            byte[] decodeBytes = MultiProcessMMKV.getMMKV("brandService", 1).decodeBytes(Nv(str));
            eww eww = new eww();
            eww.parseFrom(decodeBytes);
            AppMethodBeat.o(212176);
            return eww;
        } catch (Throwable th) {
            AppMethodBeat.o(212176);
            return null;
        }
    }

    public static void Nu(final String str) {
        AppMethodBeat.i(212177);
        ewt ewt = new ewt();
        ewt.Nun = 0;
        g.aAg().hqi.a(new v(str, ewt, new v.a<ewu>(new ewu()) {
            /* class com.tencent.mm.al.n.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.al.v.a
            public final /* synthetic */ void e(ewu ewu) {
                AppMethodBeat.i(212175);
                ewu ewu2 = ewu;
                if (ewu2.Nuo != null) {
                    try {
                        MultiProcessMMKV.getMMKV("brandService", 1).encode(n.Nv(str), ewu2.Nuo.toByteArray());
                        AppMethodBeat.o(212175);
                        return;
                    } catch (Throwable th) {
                    }
                }
                AppMethodBeat.o(212175);
            }
        }), 0);
        AppMethodBeat.o(212177);
    }

    static String Nv(String str) {
        AppMethodBeat.i(212178);
        StringBuilder sb = new StringBuilder();
        sb.append("mmkv_biztransfer").append(str);
        sb.append("_2");
        String sb2 = sb.toString();
        AppMethodBeat.o(212178);
        return sb2;
    }
}
