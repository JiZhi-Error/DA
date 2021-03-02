package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    Context f1342a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1343b = h.class.getSimpleName();

    public h(Context context) {
        AppMethodBeat.i(180795);
        this.f1342a = context;
        AppMethodBeat.o(180795);
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
        // Method dump skipped, instructions count: 783
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.tools.internal.h.a():boolean");
    }

    private int a(Context context) {
        boolean z;
        AppMethodBeat.i(180797);
        List<p> a2 = x.a(x.b(context, t.q, BuildConfig.KINDA_DEFAULT));
        if (a2.isEmpty()) {
            AppMethodBeat.o(180797);
            return 0;
        }
        Context context2 = this.f1342a;
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        new ArrayList();
        ArrayList<String> b2 = x.b(x.a(context2, x.f1424a));
        if (b2 != null) {
            arrayList.addAll(b2);
            if (y.f1437e == 1) {
                ArrayList<String> b3 = x.b(x.a(context2, x.f1426c + File.separator + t.F[s.a(this.f1342a).f1397a]));
                if (b3 != null) {
                    arrayList.addAll(b3);
                }
            }
        }
        if (arrayList.size() == 0) {
            g.a(this.f1342a).a("DLC", "localComp file error");
            AppMethodBeat.o(180797);
            return 1;
        }
        String b4 = x.b(this.f1342a, t.v, "preference_default");
        List<p> a3 = x.a(b4);
        if (b4.equals("preference_default") || a3.isEmpty() || !x.a(a2, a3)) {
            boolean z2 = true;
            for (p pVar : a2) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    String[] split = ((String) it.next()).split(",");
                    if (split.length == 3 && pVar.f1390c.equals(split[0]) && String.valueOf(pVar.f1391d).equals(split[1]) && pVar.f1392e.equals(split[2])) {
                        z = true;
                        break;
                    }
                }
                z2 = !z ? false : z2;
            }
            if (z2) {
                AppMethodBeat.o(180797);
                return 4;
            }
            AppMethodBeat.o(180797);
            return 3;
        }
        AppMethodBeat.o(180797);
        return 2;
    }

    private void a(String str) {
        AppMethodBeat.i(180798);
        File file = new File(x.b(this.f1342a, str));
        if (file.exists()) {
            file.delete();
        }
        AppMethodBeat.o(180798);
    }
}
