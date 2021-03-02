package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.support.v4.view.n;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nJ\b\u0010\u001d\u001a\u00020\u001aH\u0014J0\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0014J0\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\nH\u0016J8\u0010+\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0016J(\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00172\u0006\u00102\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0016J(\u00103\u001a\u00020 2\u0006\u00101\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00172\u0006\u00102\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0016J\u0018\u00104\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\nH\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/NestedLimitScrollView;", "Landroid/widget/FrameLayout;", "Landroid/support/v4/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "leftLimit", "getLeftLimit", "()I", "setLeftLimit", "(I)V", "rightLimit", "getRightLimit", "setRightLimit", "targetChild", "Landroid/view/View;", "targetChildWidth", "clampScroll", "", "getCanScroll", "dx", "onFinishInflate", "onLayout", "changed", "", "left", "top", "right", "bottom", "onNestedPreScroll", "target", "dy", "comsumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "plugin-vlog_release"})
public final class NestedLimitScrollView extends FrameLayout implements n {
    private View GPN;
    private int GPO;
    private int GPP;
    private int GPQ;
    private final String TAG;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedLimitScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(192141);
        this.TAG = "MicroMsg.ThumbCropView";
        this.GPN = getChildCount() > 0 ? getChildAt(0) : null;
        AppMethodBeat.o(192141);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NestedLimitScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(192142);
        AppMethodBeat.o(192142);
    }

    public final int getLeftLimit() {
        return this.GPP;
    }

    public final void setLeftLimit(int i2) {
        this.GPP = i2;
    }

    public final int getRightLimit() {
        return this.GPQ;
    }

    public final void setRightLimit(int i2) {
        this.GPQ = i2;
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        AppMethodBeat.i(192134);
        this.GPN = getChildCount() > 0 ? getChildAt(0) : null;
        super.onFinishInflate();
        AppMethodBeat.o(192134);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(192135);
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.GPN;
        this.GPO = view != null ? view.getWidth() : 0;
        AppMethodBeat.o(192135);
    }

    @Override // android.support.v4.view.n
    public final boolean a(View view, View view2, int i2, int i3) {
        AppMethodBeat.i(192136);
        p.h(view, "child");
        p.h(view2, "target");
        Log.i(this.TAG, "onStartNestedScroll: ");
        if (i2 == 1) {
            AppMethodBeat.o(192136);
            return true;
        }
        AppMethodBeat.o(192136);
        return false;
    }

    @Override // android.support.v4.view.n
    public final void b(View view, View view2, int i2, int i3) {
        AppMethodBeat.i(192137);
        p.h(view, "child");
        p.h(view2, "target");
        Log.i(this.TAG, "onNestedScrollAccepted: ");
        AppMethodBeat.o(192137);
    }

    @Override // android.support.v4.view.n
    public final void a(View view, int i2, int i3, int[] iArr, int i4) {
        AppMethodBeat.i(192138);
        p.h(view, "target");
        p.h(iArr, "comsumed");
        Log.i(this.TAG, "onNestedPreScroll: " + i2 + ", " + getScrollX());
        if (i2 <= 0 || getScrollX() >= 0) {
            if (i2 >= 0 || getScrollX() <= 0) {
                i2 = 0;
            } else if (getScrollX() + i2 < 0) {
                i2 = -getScrollX();
            }
        } else if (getScrollX() + i2 > 0) {
            i2 = -getScrollX();
        }
        iArr[0] = i2;
        setScrollX(iArr[0] + getScrollX());
        iArr[1] = i3;
        AppMethodBeat.o(192138);
    }

    @Override // android.support.v4.view.n
    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(192139);
        p.h(view, "target");
        Log.i(this.TAG, "onNestedScroll: " + i2 + ", " + i4 + ", " + getScrollX());
        if (getScrollX() + i4 > this.GPQ) {
            setScrollX(this.GPQ);
            AppMethodBeat.o(192139);
        } else if (getScrollX() + i4 < (-this.GPP)) {
            setScrollX(-this.GPP);
            AppMethodBeat.o(192139);
        } else {
            setScrollX(getScrollX() + i4);
            AppMethodBeat.o(192139);
        }
    }

    @Override // android.support.v4.view.n
    public final void k(View view, int i2) {
        AppMethodBeat.i(192140);
        p.h(view, "target");
        Log.i(this.TAG, "onStopNestedScroll: ");
        AppMethodBeat.o(192140);
    }
}
