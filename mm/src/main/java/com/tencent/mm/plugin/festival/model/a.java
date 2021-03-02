package com.tencent.mm.plugin.festival.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.i;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.festival.ui.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalBenchmarkInfo;", "", "()V", "TAG", "", "defaultEffectList", "", "Lcom/tencent/mm/plugin/festival/ui/FestivalEffect;", "effect", "benchmark", "", "getEffect", "xconfig", "plugin-festival_release"})
public final class a {
    private static final List<d> Uxs;
    private static d Uxt;
    public static final a Uxu = new a();

    static {
        AppMethodBeat.i(262890);
        ArrayList arrayList = new ArrayList();
        d dVar = new d();
        dVar.UBC = 1;
        dVar.UBD = 10000;
        dVar.UBE = 150;
        dVar.jbl = false;
        arrayList.add(dVar);
        d dVar2 = new d();
        dVar2.UBC = 7;
        dVar2.UBD = 10000;
        dVar2.UBE = 150;
        dVar2.jbl = true;
        arrayList.add(dVar2);
        d dVar3 = new d();
        dVar3.UBC = 21;
        dVar3.UBD = g.sHCENCODEVIDEOTIMEOUT;
        dVar3.UBE = 300;
        dVar3.jbl = true;
        arrayList.add(dVar3);
        Uxs = arrayList;
        AppMethodBeat.o(262890);
    }

    private a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v23. Raw type applied. Possible types: java.util.List<com.tencent.mm.plugin.festival.ui.d> */
    public static d gFf() {
        List list;
        int i2 = 0;
        AppMethodBeat.i(262889);
        if (Uxt != null) {
            Log.i("FestivalBenchmarkInfo", "benchmark: cache " + Uxt);
            d dVar = Uxt;
            if (dVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(262889);
            return dVar;
        }
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(af, "MMKernel.service(IConfigService::class.java)");
        int i3 = ((com.tencent.mm.plugin.zero.b.a) af).aqJ().getInt("ClientBenchmarkLevel", -1);
        Log.i("FestivalBenchmarkInfo", "benchmark: ".concat(String.valueOf(i3)));
        if (i3 == -2) {
            Log.i("FestivalBenchmarkInfo", "benchmark: is low");
            d dVar2 = Uxs.get(0);
            Uxt = dVar2;
            if (dVar2 == null) {
                p.hyc();
            }
            AppMethodBeat.o(262889);
            return dVar2;
        } else if (i3 == 0) {
            Log.i("FestivalBenchmarkInfo", "benchmark: is low");
            d dVar3 = Uxs.get(0);
            Uxt = dVar3;
            if (dVar3 == null) {
                p.hyc();
            }
            AppMethodBeat.o(262889);
            return dVar3;
        } else if (i3 == -1) {
            Log.i("FestivalBenchmarkInfo", "benchmark: is undefined, default hight");
            d dVar4 = Uxs.get(2);
            Uxt = dVar4;
            if (dVar4 == null) {
                p.hyc();
            }
            AppMethodBeat.o(262889);
            return dVar4;
        } else {
            String a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_festival2021_benchmark, "");
            p.g(a2, "MMKernel.service(IExptSe…stival2021_benchmark, \"\")");
            Log.i("FestivalBenchmarkInfo", "benchmark: xconfig ".concat(String.valueOf(a2)));
            List arrayList = new ArrayList();
            try {
                f fVar = new f(a2);
                int length = fVar.length();
                for (int i4 = 0; i4 < length; i4++) {
                    i pY = fVar.pY(i4);
                    d dVar5 = new d();
                    dVar5.UBC = pY.getInt("bmk");
                    dVar5.UBD = pY.getInt("max");
                    dVar5.UBE = pY.getInt("pps");
                    dVar5.jbl = pY.getBoolean("blr");
                    arrayList.add(dVar5);
                }
                list = arrayList;
            } catch (Exception e2) {
                if (!org.apache.commons.b.g.byL(a2)) {
                    Log.printErrStackTrace("FestivalBenchmarkInfo", e2, "xconfig fail", new Object[0]);
                }
                list = Uxs;
            }
            d dVar6 = null;
            int size = list.size();
            while (i2 < size) {
                d dVar7 = (d) list.get(i2);
                Log.i("FestivalBenchmarkInfo", "benchmark, xconfig: configBenchmark " + dVar7.UBC + ' ');
                if (i3 < dVar7.UBC) {
                    break;
                }
                i2++;
                dVar6 = dVar7;
            }
            if (dVar6 == null) {
                Log.i("FestivalBenchmarkInfo", "benchmark, no hit");
                d dVar8 = Uxs.get(1);
                Uxt = dVar8;
                if (dVar8 == null) {
                    p.hyc();
                }
                AppMethodBeat.o(262889);
                return dVar8;
            }
            Log.i("FestivalBenchmarkInfo", "benchmark, hit: ".concat(String.valueOf(dVar6)));
            Uxt = dVar6;
            if (dVar6 == null) {
                p.hyc();
            }
            AppMethodBeat.o(262889);
            return dVar6;
        }
    }
}
