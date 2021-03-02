package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.support.v7.widget.ak;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiPagerScrollHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "onPageSelectedListener", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "targetSnapPos", "", "attachToRecyclerView", "", "createScroller", "Landroid/support/v7/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "findSnapView", "Landroid/view/View;", "findTargetSnapPosition", "velocityX", "velocityY", "OnPageSelectedListener", "plugin-textstatus_release"})
public final class h extends ak {
    a VcY;
    RecyclerView hak;
    private int uMA = -1;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-textstatus_release"})
    public interface a {
        void onPageSelected(int i2);
    }

    @Override // android.support.v7.widget.at
    public final void f(RecyclerView recyclerView) {
        AppMethodBeat.i(258342);
        super.f(recyclerView);
        this.hak = recyclerView;
        AppMethodBeat.o(258342);
    }

    @Override // android.support.v7.widget.at
    public final RecyclerView.r g(RecyclerView.LayoutManager layoutManager) {
        Context context = null;
        AppMethodBeat.i(258343);
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            AppMethodBeat.o(258343);
            return null;
        }
        RecyclerView recyclerView = this.hak;
        if (recyclerView != null) {
            context = recyclerView.getContext();
        }
        b bVar = new b(this, context);
        AppMethodBeat.o(258343);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/textstatus/emoji/ImeEmojiPagerScrollHelper$createScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", NativeProtocol.WEB_DIALOG_ACTION, "Landroid/support/v7/widget/RecyclerView$SmoothScroller$Action;", "plugin-textstatus_release"})
    public static final class b extends ae {
        final /* synthetic */ h VcZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar, Context context) {
            super(context);
            this.VcZ = hVar;
        }

        @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
        public final void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
            AppMethodBeat.i(258340);
            p.h(view, "targetView");
            p.h(sVar, "state");
            p.h(aVar, NativeProtocol.WEB_DIALOG_ACTION);
            if (this.VcZ.hak != null) {
                h hVar = this.VcZ;
                RecyclerView recyclerView = this.VcZ.hak;
                RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
                if (layoutManager == null) {
                    p.hyc();
                }
                int[] a2 = hVar.a(layoutManager, view);
                if (a2 == null) {
                    p.hyc();
                }
                int i2 = a2[0];
                int i3 = a2[1];
                int cc = cc(Math.max(Math.abs(i2), Math.abs(i3)));
                if (cc > 0) {
                    aVar.a(i2, i3, cc, this.VQ);
                    AppMethodBeat.o(258340);
                    return;
                }
                aVar.a(i2, i3, 1, this.VQ);
            }
            AppMethodBeat.o(258340);
        }

        @Override // android.support.v7.widget.ae
        public final float a(DisplayMetrics displayMetrics) {
            AppMethodBeat.i(258341);
            p.h(displayMetrics, "displayMetrics");
            float f2 = 50.0f / ((float) displayMetrics.densityDpi);
            AppMethodBeat.o(258341);
            return f2;
        }
    }

    @Override // android.support.v7.widget.at, android.support.v7.widget.ak
    public final int a(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        AppMethodBeat.i(258344);
        int a2 = super.a(layoutManager, i2, i3);
        this.uMA = a2;
        a aVar = this.VcY;
        if (aVar != null) {
            aVar.onPageSelected(a2);
        }
        AppMethodBeat.o(258344);
        return a2;
    }

    @Override // android.support.v7.widget.at, android.support.v7.widget.ak
    public final View a(RecyclerView.LayoutManager layoutManager) {
        a aVar;
        AppMethodBeat.i(258345);
        View a2 = super.a(layoutManager);
        ViewGroup.LayoutParams layoutParams = a2 != null ? a2.getLayoutParams() : null;
        if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
            layoutParams = null;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        int lG = layoutParams2 != null ? layoutParams2.lG() : -1;
        if (this.uMA == -1 && (aVar = this.VcY) != null) {
            aVar.onPageSelected(lG);
        }
        this.uMA = -1;
        AppMethodBeat.o(258345);
        return a2;
    }
}
