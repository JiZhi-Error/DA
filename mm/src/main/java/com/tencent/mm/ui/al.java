package com.tencent.mm.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/ui/TouchDelegateWrapper;", "Landroid/view/TouchDelegate;", "bounds", "Landroid/graphics/Rect;", "delegateView", "Landroid/view/View;", "(Landroid/graphics/Rect;Landroid/view/View;)V", "getBounds", "()Landroid/graphics/Rect;", "setBounds", "(Landroid/graphics/Rect;)V", "getDelegateView", "()Landroid/view/View;", "setDelegateView", "(Landroid/view/View;)V", "getTouchEventDistance", "", "event", "Landroid/view/MotionEvent;", "libmmui_release"})
public final class al extends TouchDelegate {
    View OLE;
    private Rect hN;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public al(Rect rect, View view) {
        super(rect, view);
        p.h(rect, "bounds");
        p.h(view, "delegateView");
        AppMethodBeat.i(204791);
        this.OLE = view;
        this.hN = rect;
        AppMethodBeat.o(204791);
    }
}
