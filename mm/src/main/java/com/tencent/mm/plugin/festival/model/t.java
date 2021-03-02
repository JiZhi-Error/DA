package com.tencent.mm.plugin.festival.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.festival.b.e;
import com.tencent.mm.plugin.festival.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalOperationMgr;", "Lcom/tencent/mm/plugin/festival/model/FestivalWishConfigProvider$OnConfigUpdatedListener;", "()V", "TAG", "", "forbiddenStatusFlag", "", "map", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/festival/model/IForbiddenCallback;", "Lkotlin/collections/ArrayList;", "addToMayForbiddenPluginList", "", "callback", "create", "destroy", "isBitFlagSet", "", "flagBit", "onConfigUpdated", "config", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishConfig;", "plugin-festival_release"})
public final class t implements z.a {
    private static int UyQ = z.Uzb.hRC().UAP;
    public static final t UyR = new t();
    public static final Map<Integer, ArrayList<ag>> map = new LinkedHashMap();

    static {
        AppMethodBeat.i(263051);
        AppMethodBeat.o(263051);
    }

    private t() {
    }

    public static void a(ag agVar) {
        AppMethodBeat.i(263049);
        if (agVar != null) {
            ArrayList<ag> arrayList = map.get(Integer.valueOf(agVar.dCX()));
            if (arrayList != null) {
                arrayList.add(agVar);
            } else {
                map.put(Integer.valueOf(agVar.dCX()), new ArrayList<>());
                ArrayList<ag> arrayList2 = map.get(Integer.valueOf(agVar.dCX()));
                if (arrayList2 != null) {
                    arrayList2.add(agVar);
                }
            }
            UyQ = z.Uzb.hRC().UAP;
            agVar.Fe(awC(agVar.dCX()));
            Log.i("FestivalOperationMgr", "addTo callback bitFlag: " + agVar.dCX() + " currentFlag:" + UyQ);
            AppMethodBeat.o(263049);
            return;
        }
        AppMethodBeat.o(263049);
    }

    @Override // com.tencent.mm.plugin.festival.model.z.a
    public final void a(e eVar) {
        AppMethodBeat.i(263050);
        p.h(eVar, "config");
        int i2 = UyQ;
        int i3 = eVar.UAP;
        if (UyQ == i3) {
            AppMethodBeat.o(263050);
            return;
        }
        Log.i("FestivalOperationMgr", "onConfigUpdated forbiddenStatusFlag: " + i3 + " old:" + i2);
        UyQ = i3;
        d.h(new a(i2));
        AppMethodBeat.o(263050);
    }

    public static boolean awC(int i2) {
        return (UyQ & i2) == i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int UyS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(int i2) {
            super(0);
            this.UyS = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(263048);
            t tVar = t.UyR;
            for (Map.Entry entry : t.map.entrySet()) {
                int intValue = ((Number) entry.getKey()).intValue();
                ArrayList<ag> arrayList = (ArrayList) entry.getValue();
                boolean z = (this.UyS & intValue) == intValue;
                t tVar2 = t.UyR;
                boolean z2 = (t.UyQ & intValue) == intValue;
                Log.d("FestivalOperationMgr", new StringBuilder().append(intValue).append(' ').append(arrayList.size()).append(' ').append(z).append(' ').append(z2).toString());
                if (z2 != z) {
                    for (ag agVar : arrayList) {
                        agVar.Fe(z2);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(263048);
            return xVar;
        }
    }
}
