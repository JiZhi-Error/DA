package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.support.v4.view.m;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ,\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0016J0\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0016J \u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\nH\u0016J \u0010)\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010'\u001a\u00020\u000fH\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroid/support/v4/view/NestedScrollingParent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "nestedScrollTarget", "Landroid/view/View;", "nestedScrollTargetIsBeingDragged", "", "nestedScrollTargetWasUnableToScroll", "skipsTouchInterception", "dispatchNestedPreScroll", "dx", "dy", "consumed", "", "offsetInWindow", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "e", "onNestedScroll", "", "target", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "plugin-finder_release"})
public final class FinderLiveRecyclerView extends WxRecyclerView implements m {
    private final String TAG = "Finder.FinderLiveRecyclerView";
    private View uzT;
    private boolean uzU;
    private boolean uzV;
    private boolean uzW;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(247565);
        AppMethodBeat.o(247565);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(247566);
        AppMethodBeat.o(247566);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(247558);
        boolean z = this.uzT != null;
        if (z) {
            this.uzW = true;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (z) {
            this.uzW = false;
            if (!dispatchTouchEvent || this.uzV) {
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            }
        }
        AppMethodBeat.o(247558);
        return dispatchTouchEvent;
    }

    @Override // android.support.v7.widget.RecyclerView
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(247559);
        if (this.uzW || !super.onInterceptTouchEvent(motionEvent)) {
            AppMethodBeat.o(247559);
            return false;
        }
        AppMethodBeat.o(247559);
        return true;
    }

    @Override // android.support.v4.view.m
    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(247560);
        p.h(view, "target");
        Log.i(this.TAG, "onNestedScroll");
        if (view == this.uzT && !this.uzU && i3 != 0) {
            this.uzU = true;
            this.uzV = false;
        }
        AppMethodBeat.o(247560);
    }

    @Override // android.support.v7.widget.RecyclerView
    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(247561);
        if (this.uzT != null) {
            View view = this.uzT;
            if (view == null) {
                p.hyc();
            }
            if (view.getId() == R.id.cpr) {
                AppMethodBeat.o(247561);
                return false;
            }
        }
        AppMethodBeat.o(247561);
        return true;
    }

    @Override // android.support.v4.view.m
    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        AppMethodBeat.i(247562);
        p.h(view, "child");
        p.h(view2, "target");
        Log.i(this.TAG, "onNestedScrollAccepted");
        if ((i2 & 2) != 0) {
            this.uzT = view2;
            this.uzU = false;
            this.uzV = false;
        }
        super.onNestedScrollAccepted(view, view2, i2);
        AppMethodBeat.o(247562);
    }

    @Override // android.support.v4.view.m
    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        AppMethodBeat.i(247563);
        p.h(view, "child");
        p.h(view2, "target");
        if ((i2 & 2) != 0) {
            AppMethodBeat.o(247563);
            return true;
        }
        AppMethodBeat.o(247563);
        return false;
    }

    @Override // android.support.v4.view.m
    public final void onStopNestedScroll(View view) {
        AppMethodBeat.i(247564);
        p.h(view, "child");
        Log.i(this.TAG, "onStopNestedScroll");
        this.uzT = null;
        this.uzU = false;
        this.uzV = false;
        AppMethodBeat.o(247564);
    }
}
