package com.tencent.mm.plugin.textstatus.i;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.g.r;
import java.util.HashMap;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ(\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/third/ThirdSpeciaViewManger;", "", "()V", "TAG", "", "singletons", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/textstatus/third/ISpecialViewSingleton;", "Lkotlin/collections/HashMap;", "getView", "Landroid/view/View;", "sourceId", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getViewAndRefresh", "callback", "Lkotlin/Function0;", "", "release", "plugin-textstatus_release"})
public final class d {
    private static final HashMap<String, b> FYa;
    public static final d Gcq = new d();

    static {
        AppMethodBeat.i(216343);
        HashMap<String, b> hashMap = new HashMap<>();
        FYa = hashMap;
        hashMap.put("demo@inner", new a());
        FYa.put("live_player@inner", new c());
        FYa.put("wedraw@inner", new e());
        AppMethodBeat.o(216343);
    }

    private d() {
    }

    public static View a(String str, r rVar) {
        View view;
        AppMethodBeat.i(216340);
        p.h(str, "sourceId");
        p.h(rVar, "jumpInfo");
        b bVar = FYa.get(str);
        if (bVar != null) {
            view = bVar.a(rVar);
        } else {
            view = null;
        }
        AppMethodBeat.o(216340);
        return view;
    }

    public static View a(String str, r rVar, a<x> aVar) {
        View view;
        AppMethodBeat.i(216341);
        p.h(str, "sourceId");
        p.h(rVar, "jumpInfo");
        p.h(aVar, "callback");
        b bVar = FYa.get(str);
        if (bVar != null) {
            view = bVar.a(rVar, aVar);
        } else {
            view = null;
        }
        AppMethodBeat.o(216341);
        return view;
    }

    public static void b(String str, r rVar) {
        AppMethodBeat.i(216342);
        p.h(str, "sourceId");
        p.h(rVar, "jumpInfo");
        b bVar = FYa.get(str);
        if (bVar != null) {
            bVar.b(rVar);
            AppMethodBeat.o(216342);
            return;
        }
        AppMethodBeat.o(216342);
    }
}
