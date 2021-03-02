package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanDotsAnimationControllerFactory;", "", "()V", "create", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "type", "", "context", "Landroid/content/Context;", "dotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "Type", "plugin-scan_release"})
public final class i {
    public static final i CPN = new i();

    static {
        AppMethodBeat.i(52288);
        AppMethodBeat.o(52288);
    }

    private i() {
    }

    public static final e a(int i2, Context context, d dVar) {
        AppMethodBeat.i(52287);
        p.h(context, "context");
        p.h(dVar, "dotsView");
        if (i2 == 1) {
            b bVar = new b(context, dVar);
            AppMethodBeat.o(52287);
            return bVar;
        } else if (i2 == 2) {
            f fVar = new f(context, dVar);
            AppMethodBeat.o(52287);
            return fVar;
        } else {
            f fVar2 = new f(context, dVar);
            AppMethodBeat.o(52287);
            return fVar2;
        }
    }
}
