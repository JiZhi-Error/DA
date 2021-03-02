package com.tencent.mm.plugin.vlog.report;

import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kk;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\f\u0010\u0011\u001a\u00020\u0004*\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/vlog/report/VideoCompositionPerformanceReport;", "", "()V", "TAG", "", "reportMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "Lkotlin/collections/HashMap;", "doReport", "", "key", "getReportStruct", "initBasicInfo", "struct", "initOutputVideoInfo", "videoPath", "getReportKey", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "plugin-vlog_release"})
public final class b {
    public static final b GDm = new b();
    private static final HashMap<String, kk> ral = new HashMap<>();

    static {
        AppMethodBeat.i(190894);
        AppMethodBeat.o(190894);
    }

    private b() {
    }

    public static kk aUh(String str) {
        AppMethodBeat.i(190891);
        p.h(str, "key");
        if (!ral.containsKey(str)) {
            ral.put(str, new kk());
            kk kkVar = ral.get(str);
            if (kkVar == null) {
                p.hyc();
            }
            p.g(kkVar, "reportMap[key]!!");
            kkVar.xI(str);
            kk kkVar2 = ral.get(str);
            if (kkVar2 == null) {
                p.hyc();
            }
            p.g(kkVar2, "reportMap[key]!!");
            kk kkVar3 = kkVar2;
            List<String> a2 = n.a((CharSequence) "2.2-275", new char[]{'-'});
            h.hkS();
            if (a2.size() == 2) {
                kkVar3.tl(Long.parseLong(a2.get(1)) + ((long) (Float.parseFloat(a2.get(0)) * 1000000.0f)));
            }
        }
        kk kkVar4 = ral.get(str);
        if (kkVar4 == null) {
            p.hyc();
        }
        kk kkVar5 = kkVar4;
        AppMethodBeat.o(190891);
        return kkVar5;
    }

    public static void a(kk kkVar, String str) {
        a aNx;
        AppMethodBeat.i(190892);
        p.h(kkVar, "struct");
        if (!s.YS(str) || (aNx = e.aNx(str)) == null) {
            AppMethodBeat.o(190892);
            return;
        }
        kkVar.xH(aNx.toString());
        kkVar.tq((long) aNx.frameRate);
        kkVar.tt((long) aNx.videoDuration);
        kkVar.xG(new StringBuilder().append(aNx.width / 100).append('x').append(aNx.height / 100).toString());
        AppMethodBeat.o(190892);
    }

    public static void aUi(String str) {
        AppMethodBeat.i(190893);
        p.h(str, "key");
        kk kkVar = ral.get(str);
        if (kkVar != null) {
            kkVar.bfK();
        }
        ral.remove(str);
        "do report key:".concat(String.valueOf(str));
        h.hkS();
        AppMethodBeat.o(190893);
    }
}
