package com.tencent.i.a.b.a;

import android.content.Context;
import com.tencent.h.a.a.a;
import com.tencent.i.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d;
import java.util.ArrayList;

public class b {
    private static b Sri;
    private a Srj = new a();

    private b() {
        AppMethodBeat.i(214700);
        AppMethodBeat.o(214700);
    }

    public static b hqm() {
        AppMethodBeat.i(214701);
        if (Sri == null) {
            synchronized (b.class) {
                try {
                    if (Sri == null) {
                        Sri = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(214701);
                    throw th;
                }
            }
        }
        b bVar = Sri;
        AppMethodBeat.o(214701);
        return bVar;
    }

    public static int hqn() {
        return 5;
    }

    public static a a(c cVar, ArrayList<d> arrayList, ArrayList<String> arrayList2) {
        byte[] bArr;
        a aVar = null;
        AppMethodBeat.i(214702);
        if (arrayList.isEmpty()) {
            AppMethodBeat.o(214702);
        } else {
            Context context = cVar.mAppContext;
            if (context == null || arrayList == null || arrayList.isEmpty()) {
                bArr = null;
            } else {
                byte[] bB = a.bB(arrayList);
                a.b bVar = new a.b();
                bVar.rcD = "com.tencent.turingsmi";
                bVar.SpP = "V_301096_2_C_" + com.tencent.h.c.c.getAppVersionName(context) + "_" + com.tencent.h.c.c.getAppVersionCode(context);
                bVar.SpQ = "1.0.1";
                bVar.mSdkVersion = "2";
                bArr = a.a(bVar, bB);
            }
            if (bArr != null) {
                aVar = new a();
                aVar.Srg = bArr;
                aVar.Srh = new ArrayList<>(arrayList2);
            }
            arrayList2.clear();
            arrayList.clear();
            AppMethodBeat.o(214702);
        }
        return aVar;
    }
}
