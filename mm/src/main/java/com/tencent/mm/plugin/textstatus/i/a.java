package com.tencent.mm.plugin.textstatus.i;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.g.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/third/DemoSingleton;", "Lcom/tencent/mm/plugin/textstatus/third/ISpecialViewSingleton;", "()V", "getView", "Landroid/view/View;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getViewAndRefresh", "refreshCallback", "Lkotlin/Function0;", "", "release", "plugin-textstatus_release"})
public final class a implements b {
    @Override // com.tencent.mm.plugin.textstatus.i.b
    public final View a(r rVar) {
        AppMethodBeat.i(216329);
        p.h(rVar, "jumpInfo");
        n nVar = new n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(216329);
        throw nVar;
    }

    @Override // com.tencent.mm.plugin.textstatus.i.b
    public final View a(r rVar, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(216330);
        p.h(rVar, "jumpInfo");
        p.h(aVar, "refreshCallback");
        n nVar = new n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(216330);
        throw nVar;
    }

    @Override // com.tencent.mm.plugin.textstatus.i.b
    public final void b(r rVar) {
        AppMethodBeat.i(216331);
        p.h(rVar, "jumpInfo");
        n nVar = new n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
        AppMethodBeat.o(216331);
        throw nVar;
    }
}
