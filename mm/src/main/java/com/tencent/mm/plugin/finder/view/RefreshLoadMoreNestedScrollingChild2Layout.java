package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.support.v4.view.k;
import android.support.v4.view.o;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\nH\u0016J4\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\nH\u0016J:\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\rH\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J(\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\rH\u0016J \u0010/\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0016J0\u00100\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\nH\u0016J8\u00101\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016J(\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020+2\u0006\u0010*\u001a\u00020+2\u0006\u00104\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016J(\u00105\u001a\u00020\r2\u0006\u00103\u001a\u00020+2\u0006\u0010*\u001a\u00020+2\u0006\u00104\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0018\u00106\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\rH\u0016J\u0018\u00109\u001a\u00020\r2\u0006\u00104\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010:\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\nH\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/RefreshLoadMoreNestedScrollingChild2Layout;", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "Landroid/support/v4/view/NestedScrollingChild2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isDebug", "", "nestedScrollingChildHelper", "Landroid/support/v4/view/NestedScrollingChildHelper;", "nestedScrollingParentHelper", "Landroid/support/v4/view/NestedScrollingParentHelper;", "parentOffsetInWindow", "", "parentScrollConsumed", "canScrollVertically", TencentLocation.EXTRA_DIRECTION, "dispatchNestedPreScroll", "dx", "dy", "consumed", "offsetInWindow", "type", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "getNestedScrollAxes", "hasNestedScrollingParent", "isNestedScrollingEnabled", "log", "", "msg", "", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "onNestedPreFling", "onNestedPreScroll", "onNestedScroll", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "setNestedScrollingEnabled", "enabled", "startNestedScroll", "stopNestedScroll", "plugin-finder_release"})
public final class RefreshLoadMoreNestedScrollingChild2Layout extends RefreshLoadMoreLayout implements k {
    private final boolean cWq;
    private final int[] wqE;
    private final int[] wqF;
    private final android.support.v4.view.l wqG;
    private final o wqs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RefreshLoadMoreNestedScrollingChild2Layout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(255087);
        this.wqE = new int[2];
        this.wqF = new int[2];
        this.wqs = new o(this);
        this.wqG = new android.support.v4.view.l(this);
        setNestedScrollingEnabled(true);
        AppMethodBeat.o(255087);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RefreshLoadMoreNestedScrollingChild2Layout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(255088);
        this.wqE = new int[2];
        this.wqF = new int[2];
        this.wqs = new o(this);
        this.wqG = new android.support.v4.view.l(this);
        setNestedScrollingEnabled(true);
        AppMethodBeat.o(255088);
    }

    public final boolean canScrollVertically(int i2) {
        AppMethodBeat.i(255074);
        boolean canScrollVertically = getRecyclerView().canScrollVertically(i2);
        AppMethodBeat.o(255074);
        return canScrollVertically;
    }

    @Override // android.support.v4.view.n, com.tencent.mm.view.HeadFooterLayout, com.tencent.mm.view.RefreshLoadMoreLayout
    public final boolean a(View view, View view2, int i2, int i3) {
        AppMethodBeat.i(255075);
        p.h(view, "child");
        p.h(view2, "target");
        AppMethodBeat.o(255075);
        return true;
    }

    @Override // android.support.v4.view.n, com.tencent.mm.view.HeadFooterLayout
    public final void b(View view, View view2, int i2, int i3) {
        AppMethodBeat.i(255076);
        p.h(view, "child");
        p.h(view2, "target");
        this.wqs.aP(i2);
        log("startNestedScroll ret:".concat(String.valueOf(this.wqG.A(i2, i3))));
        super.b(view, view2, i2, i3);
        AppMethodBeat.o(255076);
    }

    @Override // android.support.v4.view.n, com.tencent.mm.view.HeadFooterLayout
    public final void a(View view, int i2, int i3, int[] iArr, int i4) {
        Integer num;
        Integer num2 = null;
        AppMethodBeat.i(255077);
        p.h(view, "target");
        p.h(iArr, "consumed");
        log("before onNestedPreScroll, dx:" + i2 + " dy:" + i3 + " consumed[0]:" + iArr[0] + " consumed[1]:" + iArr[1] + " type:" + i4);
        StringBuilder append = new StringBuilder("dispatchNestedPreScroll, ret:").append(this.wqG.a(i2, i3, iArr, null, i4)).append(" dx:").append(i2).append(" dy:").append(i3).append(" consumed[0]:");
        if (iArr != null) {
            num = Integer.valueOf(iArr[0]);
        } else {
            num = null;
        }
        StringBuilder append2 = append.append(num).append(" consumed[1]:");
        if (iArr != null) {
            num2 = Integer.valueOf(iArr[1]);
        }
        log(append2.append(num2).append(" type:").append(i4).toString());
        int[] iArr2 = this.wqE;
        iArr2[0] = 0;
        iArr2[1] = 0;
        super.a(view, i2 - iArr[0], i3 - iArr[1], iArr2, i4);
        iArr[0] = iArr[0] + iArr2[0];
        iArr[1] = iArr[1] + iArr2[1];
        log("after onNestedPreScroll, dx:" + i2 + " dy:" + i3 + " consumed[0]:" + iArr[0] + " consumed[1]:" + iArr[1] + " type:" + i4);
        AppMethodBeat.o(255077);
    }

    @Override // android.support.v4.view.m, com.tencent.mm.view.RefreshLoadMoreLayout
    public final boolean onNestedPreFling(View view, float f2, float f3) {
        AppMethodBeat.i(255079);
        p.h(view, "target");
        boolean dispatchNestedPreFling = this.wqG.dispatchNestedPreFling(f2, f3);
        AppMethodBeat.o(255079);
        return dispatchNestedPreFling;
    }

    @Override // android.support.v4.view.n, com.tencent.mm.view.HeadFooterLayout
    public final void k(View view, int i2) {
        AppMethodBeat.i(255080);
        p.h(view, "target");
        this.wqs.fC();
        super.k(view, i2);
        aM(i2);
        AppMethodBeat.o(255080);
    }

    @Override // android.support.v4.view.m, com.tencent.mm.view.RefreshLoadMoreLayout
    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        AppMethodBeat.i(255081);
        p.h(view, "target");
        boolean dispatchNestedFling = this.wqG.dispatchNestedFling(f2, f3, z);
        AppMethodBeat.o(255081);
        return dispatchNestedFling;
    }

    public final int getNestedScrollAxes() {
        AppMethodBeat.i(255082);
        int nestedScrollAxes = super.getNestedScrollAxes();
        AppMethodBeat.o(255082);
        return nestedScrollAxes;
    }

    @Override // android.support.v4.view.j
    public final void setNestedScrollingEnabled(boolean z) {
        AppMethodBeat.i(255083);
        this.wqG.setNestedScrollingEnabled(z);
        AppMethodBeat.o(255083);
    }

    @Override // android.support.v4.view.j, com.tencent.mm.view.HeadFooterLayout, com.tencent.mm.view.RefreshLoadMoreLayout
    public final boolean isNestedScrollingEnabled() {
        AppMethodBeat.i(255084);
        boolean isNestedScrollingEnabled = this.wqG.isNestedScrollingEnabled();
        AppMethodBeat.o(255084);
        return isNestedScrollingEnabled;
    }

    @Override // android.support.v4.view.k
    public final void aM(int i2) {
        AppMethodBeat.i(255085);
        log("stopNestedScroll");
        this.wqG.aM(i2);
        AppMethodBeat.o(255085);
    }

    private final void log(String str) {
        AppMethodBeat.i(255086);
        if (this.cWq) {
            Log.i("RefreshLoadMoreNestedScrollingChild2Layout", str);
        }
        AppMethodBeat.o(255086);
    }

    @Override // android.support.v4.view.n, com.tencent.mm.view.HeadFooterLayout
    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(255078);
        p.h(view, "target");
        log("dispatchNestedScroll ret:".concat(String.valueOf(this.wqG.a(i2, i3, i4, i5, null, i6))));
        super.a(view, i2, i3, i4, i5, i6);
        AppMethodBeat.o(255078);
    }
}
