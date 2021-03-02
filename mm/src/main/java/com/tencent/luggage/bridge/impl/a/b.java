package com.tencent.luggage.bridge.impl.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class b implements a {
    private final List<a.AbstractC0580a> csY = new LinkedList();

    public b() {
        AppMethodBeat.i(140362);
        a(new c());
        AppMethodBeat.o(140362);
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a
    public final Bitmap cR(String str) {
        AppMethodBeat.i(140363);
        Bitmap a2 = a(str, (Rect) null, (a.b) null);
        AppMethodBeat.o(140363);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a
    public final Bitmap a(String str, Rect rect, a.b bVar) {
        AppMethodBeat.i(140364);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(140364);
            return null;
        }
        for (a.AbstractC0580a aVar : this.csY) {
            if (aVar.match(str)) {
                Bitmap b2 = aVar.b(str, rect, bVar);
                AppMethodBeat.o(140364);
                return b2;
            }
        }
        AppMethodBeat.o(140364);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a
    public final void a(String str, a.c cVar) {
        AppMethodBeat.i(221177);
        a(str, (Map<String, String>) null, cVar);
        AppMethodBeat.o(221177);
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a
    public final void a(String str, Map<String, String> map, a.c cVar) {
        AppMethodBeat.i(221178);
        if (!TextUtils.isEmpty(str)) {
            for (a.AbstractC0580a aVar : this.csY) {
                if (aVar.match(str)) {
                    aVar.a(str, map, cVar);
                    AppMethodBeat.o(221178);
                    return;
                }
            }
        } else if (cVar != null) {
            cVar.C(null);
            AppMethodBeat.o(221178);
            return;
        }
        AppMethodBeat.o(221178);
    }

    /* access modifiers changed from: protected */
    public final void a(a.AbstractC0580a aVar) {
        AppMethodBeat.i(140366);
        this.csY.remove(aVar);
        this.csY.add(aVar);
        AppMethodBeat.o(140366);
    }
}
