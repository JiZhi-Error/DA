package com.tencent.mm.plugin.profile.ui.tab.view;

import android.content.Context;
import android.support.v4.view.k;
import android.util.AttributeSet;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB+\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J,\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J4\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\nH\u0016J2\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J:\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0011H\u0016J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\nH\u0016J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\nH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileListView;", "Landroid/widget/ListView;", "Landroid/support/v4/view/NestedScrollingChild2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mScrollingChildHelper", "Landroid/support/v4/view/NestedScrollingChildHelper;", "dispatchNestedFling", "", "velocityX", "", "velocityY", "consumed", "dispatchNestedPreFling", "dispatchNestedPreScroll", "dx", "dy", "", "offsetInWindow", "type", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "hasNestedScrollingParent", "isNestedScrollingEnabled", "setNestedScrollingEnabled", "", "enabled", "startNestedScroll", "axes", "stopNestedScroll", "app_release"})
public final class BizProfileListView extends ListView implements k {
    private final android.support.v4.view.l atb = new android.support.v4.view.l(this);

    public BizProfileListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(230878);
        setNestedScrollingEnabled(true);
        AppMethodBeat.o(230878);
    }

    public BizProfileListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(230879);
        setNestedScrollingEnabled(true);
        AppMethodBeat.o(230879);
    }

    @Override // android.support.v4.view.j
    public final void setNestedScrollingEnabled(boolean z) {
        AppMethodBeat.i(230868);
        this.atb.setNestedScrollingEnabled(z);
        AppMethodBeat.o(230868);
    }

    @Override // android.support.v4.view.j
    public final boolean isNestedScrollingEnabled() {
        AppMethodBeat.i(230869);
        boolean isNestedScrollingEnabled = this.atb.isNestedScrollingEnabled();
        AppMethodBeat.o(230869);
        return isNestedScrollingEnabled;
    }

    public final boolean startNestedScroll(int i2) {
        AppMethodBeat.i(230870);
        boolean startNestedScroll = this.atb.startNestedScroll(i2);
        AppMethodBeat.o(230870);
        return startNestedScroll;
    }

    @Override // android.support.v4.view.j
    public final void stopNestedScroll() {
        AppMethodBeat.i(230871);
        this.atb.stopNestedScroll();
        AppMethodBeat.o(230871);
    }

    public final boolean hasNestedScrollingParent() {
        AppMethodBeat.i(230872);
        boolean hasNestedScrollingParent = this.atb.hasNestedScrollingParent();
        AppMethodBeat.o(230872);
        return hasNestedScrollingParent;
    }

    public final boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        AppMethodBeat.i(230873);
        boolean dispatchNestedScroll = this.atb.dispatchNestedScroll(i2, i3, i4, i5, iArr);
        AppMethodBeat.o(230873);
        return dispatchNestedScroll;
    }

    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(230874);
        boolean dispatchNestedPreScroll = this.atb.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        AppMethodBeat.o(230874);
        return dispatchNestedPreScroll;
    }

    public final boolean dispatchNestedFling(float f2, float f3, boolean z) {
        AppMethodBeat.i(230875);
        boolean dispatchNestedFling = this.atb.dispatchNestedFling(f2, f3, z);
        AppMethodBeat.o(230875);
        return dispatchNestedFling;
    }

    public final boolean dispatchNestedPreFling(float f2, float f3) {
        AppMethodBeat.i(230876);
        boolean dispatchNestedPreFling = this.atb.dispatchNestedPreFling(f2, f3);
        AppMethodBeat.o(230876);
        return dispatchNestedPreFling;
    }

    @Override // android.support.v4.view.k
    public final void aM(int i2) {
        AppMethodBeat.i(230877);
        this.atb.aM(i2);
        AppMethodBeat.o(230877);
    }
}
