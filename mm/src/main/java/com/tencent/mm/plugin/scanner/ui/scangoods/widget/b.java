package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/DefaultScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "startAnimation", "", "stopAnimation", "Companion", "plugin-scan_release"})
public final class b extends a {
    public static final a CPs = new a((byte) 0);

    static {
        AppMethodBeat.i(52254);
        AppMethodBeat.o(52254);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, d dVar) {
        super(context, dVar);
        p.h(context, "context");
        p.h(dVar, "scanDotsView");
        AppMethodBeat.i(52253);
        AppMethodBeat.o(52253);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/DefaultScanDotsAnimationController$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.a, com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public final void startAnimation() {
        AppMethodBeat.i(52251);
        super.startAnimation();
        AppMethodBeat.o(52251);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.a, com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public final void stopAnimation() {
        AppMethodBeat.i(52252);
        super.stopAnimation();
        AppMethodBeat.o(52252);
    }
}
