package com.tencent.e.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static com.tencent.e.b.a RKS = null;

    public interface a {
        void g(int i2, byte[] bArr);
    }

    public static void a(Context context, a aVar) {
        AppMethodBeat.i(138305);
        if (RKS == null) {
            RKS = new com.tencent.e.b.a(context);
        }
        com.tencent.e.b.a aVar2 = RKS;
        try {
            List<a> md = com.tencent.e.f.a.md(aVar2.mContext);
            if (md.size() == 0) {
                aVar.g(-10, null);
                AppMethodBeat.o(138305);
                return;
            }
            com.tencent.e.c.b.a aVar3 = new com.tencent.e.c.b.a();
            aVar3.RLy = com.tencent.e.b.a.hku();
            aVar3.RLw = new com.tencent.e.c.b.c();
            aVar3.RLw.RLZ = 6;
            aVar3.RLw.RLr = 1;
            aVar3.RLw.requestType = 0;
            aVar3.RLw.RMa = 0;
            aVar3.RLw.RMb = 0;
            aVar3.RLw.RMc = null;
            aVar3.RLw.RMd = 0;
            aVar3.RLw.RMh = 1;
            aVar3.RLx = new ArrayList<>();
            for (int i2 = 0; i2 < md.size(); i2++) {
                aVar3.RLx.add(com.tencent.e.b.a.a(aVar2.mContext, md.get(i2), i2));
            }
            byte[] a2 = aVar2.RKV.a(aVar3);
            if (a2 == null) {
                aVar.g(-20, null);
                AppMethodBeat.o(138305);
                return;
            }
            aVar.g(0, a2);
            AppMethodBeat.o(138305);
        } catch (Throwable th) {
            aVar.g(-100, null);
            AppMethodBeat.o(138305);
        }
    }
}
