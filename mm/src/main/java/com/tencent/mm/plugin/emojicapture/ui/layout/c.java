package com.tencent.mm.plugin.emojicapture.ui.layout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.af;
import android.support.v7.widget.aj;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.ae;
import com.tencent.mm.plugin.appbrand.jsapi.k.ah;
import com.tencent.mm.plugin.appbrand.jsapi.k.k;
import com.tencent.mm.plugin.appbrand.jsapi.k.w;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\u0018\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper;", "Landroid/support/v7/widget/LinearSnapHelper;", "()V", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "onPageSelectedListener", "Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "verticalHelper", "attachToRecyclerView", "", "createScroller", "Landroid/support/v7/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "findCenterView", "Landroid/view/View;", "helper", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "getHorizontalHelper", "getVerticalHelper", "OnPageSelectedListener", "plugin-emojicapture_release"})
public final class c extends af {
    RecyclerView hak;
    private aj hbL;
    private aj hbM;
    public a rwT;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-emojicapture_release"})
    public interface a {
        void onPageSelected(int i2);
    }

    @Override // android.support.v7.widget.at
    public final void f(RecyclerView recyclerView) {
        AppMethodBeat.i(ah.CTRL_INDEX);
        super.f(recyclerView);
        this.hak = recyclerView;
        AppMethodBeat.o(ah.CTRL_INDEX);
    }

    @Override // android.support.v7.widget.at
    public final RecyclerView.r g(RecyclerView.LayoutManager layoutManager) {
        Context context = null;
        AppMethodBeat.i(ae.CTRL_INDEX);
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            AppMethodBeat.o(ae.CTRL_INDEX);
            return null;
        }
        RecyclerView recyclerView = this.hak;
        if (recyclerView != null) {
            context = recyclerView.getContext();
        }
        b bVar = new b(this, context);
        AppMethodBeat.o(ae.CTRL_INDEX);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$createScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", NativeProtocol.WEB_DIALOG_ACTION, "Landroid/support/v7/widget/RecyclerView$SmoothScroller$Action;", "plugin-emojicapture_release"})
    public static final class b extends android.support.v7.widget.ae {
        final /* synthetic */ c rwU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, Context context) {
            super(context);
            this.rwU = cVar;
        }

        @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
        public final void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
            AppMethodBeat.i(w.CTRL_INDEX);
            p.h(view, "targetView");
            p.h(sVar, "state");
            p.h(aVar, NativeProtocol.WEB_DIALOG_ACTION);
            if (this.rwU.hak != null) {
                c cVar = this.rwU;
                RecyclerView recyclerView = this.rwU.hak;
                RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
                if (layoutManager == null) {
                    p.hyc();
                }
                int[] a2 = cVar.a(layoutManager, view);
                if (a2 == null) {
                    p.hyc();
                }
                int i2 = a2[0];
                int i3 = a2[1];
                int cc = cc(Math.max(Math.abs(i2), Math.abs(i3)));
                if (cc > 0) {
                    aVar.a(i2, i3, cc, this.VQ);
                    AppMethodBeat.o(w.CTRL_INDEX);
                    return;
                }
                aVar.a(i2, i3, 1, this.VQ);
            }
            AppMethodBeat.o(w.CTRL_INDEX);
        }
    }

    @Override // android.support.v7.widget.at, android.support.v7.widget.af
    public final int a(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        AppMethodBeat.i(k.CTRL_INDEX);
        int a2 = super.a(layoutManager, i2, i3);
        a aVar = this.rwT;
        if (aVar != null) {
            aVar.onPageSelected(a2);
        }
        AppMethodBeat.o(k.CTRL_INDEX);
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if ((r0 != null ? r0.getLayoutManager() : null) != r11) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0061, code lost:
        if (r0 != r11) goto L_0x0063;
     */
    @Override // android.support.v7.widget.at, android.support.v7.widget.af
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(android.support.v7.widget.RecyclerView.LayoutManager r11) {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emojicapture.ui.layout.c.a(android.support.v7.widget.RecyclerView$LayoutManager):android.view.View");
    }
}
