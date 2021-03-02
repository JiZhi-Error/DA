package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.luggage.game.d.a.a.b;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/menu/ShowPkgInfoKt;", "", "()V", "showWAGameInfoIfNeeded", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "plugin-appbrand-integration_release"})
public final class v {
    public static final v nfC = new v();

    static {
        AppMethodBeat.i(50885);
        AppMethodBeat.o(50885);
    }

    private v() {
    }

    public static void a(StringBuilder sb, s sVar) {
        s sVar2;
        AppMethodBeat.i(50884);
        p.h(sb, "sb");
        if (!(sVar instanceof d)) {
            sVar2 = null;
        } else {
            sVar2 = sVar;
        }
        d dVar = (d) sVar2;
        b bVar = dVar != null ? (b) dVar.S(b.class) : null;
        if (bVar == null) {
            AppMethodBeat.o(50884);
            return;
        }
        e magicBrush = bVar.getMagicBrush();
        if (magicBrush == null) {
            sb.append("\n[renderer] ").append("unknown");
            AppMethodBeat.o(50884);
            return;
        }
        sb.append("\n[renderer] ").append("mbruntime");
        sb.append("\n[renderer] ").append("commandbuffer ").append(magicBrush.Rk().use_command_buffer);
        sb.append("\n[renderer] ").append("cmd pool ").append(magicBrush.Rk().cmd_pool_type);
        sb.append("\n[renderer] ").append("antialias ").append(magicBrush.Rk().allow_antialias_ ? "allowed" : "disallowed");
        sb.append("\n[renderer] ").append("surface ").append(((Boolean) com.tencent.mm.plugin.appbrand.game.a.s.lrT.aLT()).booleanValue() ? "surfacetexture" : "legacysurface");
        sb.append("\n[renderer] ").append("jsengine ").append(((Boolean) r.lrS.aLT()).booleanValue() ? "node" : "j2v8");
        AppMethodBeat.o(50884);
    }
}
