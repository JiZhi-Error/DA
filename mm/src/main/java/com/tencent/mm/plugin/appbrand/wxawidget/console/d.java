package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    private static final Map<String, List<a>> hno = new ConcurrentHashMap();
    private static List<a> oFF = new LinkedList();
    private static final e oFG = new e() {
        /* class com.tencent.mm.plugin.appbrand.wxawidget.console.d.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Bundle bundle) {
            AppMethodBeat.i(121617);
            Bundle bundle2 = bundle;
            ArrayList parcelableArrayList = bundle2.getParcelableArrayList("logList");
            if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                Log.i("MicroMsg.ConsoleLogger", "logList is null or nil.");
                AppMethodBeat.o(121617);
                return;
            }
            d.e(bundle2.getString("id"), parcelableArrayList);
            AppMethodBeat.o(121617);
        }
    };

    static {
        AppMethodBeat.i(121621);
        AppMethodBeat.o(121621);
    }

    public static boolean a(a aVar) {
        AppMethodBeat.i(121618);
        if (oFF.contains(aVar)) {
            AppMethodBeat.o(121618);
            return false;
        }
        if (hno.isEmpty() && oFF.isEmpty()) {
            c cVar = c.oFE;
            e eVar = oFG;
            f fVar = cVar.hnu;
            String str = cVar.event;
            if (!(str == null || str.length() == 0 || eVar == null)) {
                Bundle bundle = new Bundle();
                bundle.putString("Token", f.bo(eVar));
                bundle.putString("Event", str);
                h.a(fVar.hmX, bundle, f.a.class, eVar);
            }
        }
        boolean add = oFF.add(aVar);
        AppMethodBeat.o(121618);
        return add;
    }

    public static boolean b(a aVar) {
        AppMethodBeat.i(121619);
        boolean remove = oFF.remove(aVar);
        if (hno.isEmpty() && oFF.isEmpty()) {
            c cVar = c.oFE;
            e eVar = oFG;
            f fVar = cVar.hnu;
            String str = cVar.event;
            if (!(str == null || str.length() == 0 || eVar == null)) {
                Bundle bundle = new Bundle();
                bundle.putString("Token", f.bo(eVar));
                bundle.putString("Event", str);
                h.a(fVar.hmX, bundle, f.b.class, null);
            }
        }
        AppMethodBeat.o(121619);
        return remove;
    }

    static /* synthetic */ void e(String str, ArrayList arrayList) {
        AppMethodBeat.i(121620);
        if (Util.isNullOrNil(str) || arrayList == null || arrayList.isEmpty()) {
            AppMethodBeat.o(121620);
            return;
        }
        for (a aVar : new LinkedList(oFF)) {
            aVar.bY(arrayList);
        }
        List<a> list = hno.get(str);
        if (list != null) {
            for (a aVar2 : new LinkedList(list)) {
                aVar2.bY(arrayList);
            }
        }
        AppMethodBeat.o(121620);
    }
}
