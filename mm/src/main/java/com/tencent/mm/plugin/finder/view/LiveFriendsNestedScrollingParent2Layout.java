package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0012\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0014J(\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0011H\u0016J \u0010%\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J0\u0010&\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\r2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010$\u001a\u00020)2\u0006\u0010*\u001a\u00020\nH\u0016J8\u0010+\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\r2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0016J(\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u00102\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0016J(\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0014J(\u00108\u001a\u00020\u00112\u0006\u00101\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u00102\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0016J\u0018\u00109\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\r2\u0006\u0010*\u001a\u00020\nH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/LiveFriendsNestedScrollingParent2Layout;", "Landroid/widget/LinearLayout;", "Landroid/support/v4/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clLayout", "Landroid/view/View;", "headLayout", "headLayoutHeight", "isDebug", "", "nestedScrollingParentHelper", "Landroid/support/v4/view/NestedScrollingParentHelper;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getNestedScrollAxes", "log", "", "msg", "", "onFinishInflate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "target", "velocityX", "", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onSizeChanged", "w", "h", "oldw", "oldh", "onStartNestedScroll", "onStopNestedScroll", "Companion", "plugin-finder_release"})
public final class LiveFriendsNestedScrollingParent2Layout extends LinearLayout implements n {
    public static final a wqw = new a((byte) 0);
    private final boolean cWq;
    private RefreshLoadMoreLayout tLS;
    private final o wqs = new o(this);
    private View wqt;
    private View wqu;
    private int wqv;

    static {
        AppMethodBeat.i(255060);
        AppMethodBeat.o(255060);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveFriendsNestedScrollingParent2Layout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(255058);
        setOrientation(1);
        Log.i("LiveFriendsNestedScrollingParent2Layout", "init, orientation:" + getOrientation());
        AppMethodBeat.o(255058);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveFriendsNestedScrollingParent2Layout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(255059);
        setOrientation(1);
        Log.i("LiveFriendsNestedScrollingParent2Layout", "init, orientation:" + getOrientation());
        AppMethodBeat.o(255059);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/LiveFriendsNestedScrollingParent2Layout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.view.n
    public final boolean a(View view, View view2, int i2, int i3) {
        AppMethodBeat.i(255046);
        p.h(view, "child");
        p.h(view2, "target");
        log("onStartNestedScroll");
        if ((i2 & 2) != 0) {
            AppMethodBeat.o(255046);
            return true;
        }
        AppMethodBeat.o(255046);
        return false;
    }

    @Override // android.support.v4.view.n
    public final void b(View view, View view2, int i2, int i3) {
        AppMethodBeat.i(255047);
        p.h(view, "child");
        p.h(view2, "target");
        log("onNestedScrollAccepted");
        this.wqs.aP(i2);
        AppMethodBeat.o(255047);
    }

    @Override // android.support.v4.view.n
    public final void a(View view, int i2, int i3, int[] iArr, int i4) {
        boolean z;
        AppMethodBeat.i(255048);
        p.h(view, "target");
        p.h(iArr, "consumed");
        log("before onNestedPreScroll, headLayoutHeight:" + this.wqv + " dx:" + i2 + " dy:" + i3 + " consumed[0]:" + iArr[0] + " consumed[1]:" + iArr[1] + " type:" + i4);
        boolean z2 = i3 > 0 && getScrollY() < this.wqv;
        if (i3 >= 0 || getScrollY() < 0 || view.canScrollVertically(-1)) {
            z = false;
        } else {
            z = true;
        }
        if (z2 || z) {
            iArr[1] = i3;
            if (getScrollY() + i3 > this.wqv) {
                i3 = this.wqv - getScrollY();
                iArr[1] = this.wqv - getScrollY();
            }
            if (getScrollY() + i3 < 0) {
                i3 = -getScrollY();
                iArr[1] = 0;
            }
            scrollBy(0, i3);
        }
        log("after onNestedPreScroll, headLayoutHeight:" + this.wqv + " hideTop:" + z2 + " showTop:" + z + "  dx:" + i2 + " dy:" + i3 + " consumed[0]:" + iArr[0] + " consumed[1]:" + iArr[1] + " type:" + i4);
        AppMethodBeat.o(255048);
    }

    @Override // android.support.v4.view.n
    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(255049);
        p.h(view, "target");
        log("onNestedScroll dyUnconsumed:".concat(String.valueOf(i5)));
        if (i5 < 0) {
            if (getScrollY() + i5 < 0) {
                i5 = -getScrollY();
            }
            scrollBy(0, i5);
        }
        AppMethodBeat.o(255049);
    }

    @Override // android.support.v4.view.m
    public final boolean onNestedPreFling(View view, float f2, float f3) {
        AppMethodBeat.i(255050);
        p.h(view, "target");
        log("onNestedPreFling, velocityX:" + f2 + " velocityY:" + f3);
        AppMethodBeat.o(255050);
        return false;
    }

    @Override // android.support.v4.view.n
    public final void k(View view, int i2) {
        AppMethodBeat.i(255051);
        p.h(view, "target");
        this.wqs.fC();
        AppMethodBeat.o(255051);
    }

    @Override // android.support.v4.view.m
    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        AppMethodBeat.i(255052);
        p.h(view, "target");
        log("onNestedFling, velocityX:" + f2 + " velocityY:" + f3 + " consumed:" + z);
        AppMethodBeat.o(255052);
        return false;
    }

    public final int getNestedScrollAxes() {
        AppMethodBeat.i(255053);
        int nestedScrollAxes = this.wqs.getNestedScrollAxes();
        AppMethodBeat.o(255053);
        return nestedScrollAxes;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(255054);
        super.onMeasure(i2, i3);
        View view = this.wqu;
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            int measuredHeight = getMeasuredHeight();
            View view2 = this.wqt;
            layoutParams.height = (view2 != null ? view2.getMeasuredHeight() : 0) + measuredHeight;
        }
        View view3 = this.wqu;
        if (view3 != null) {
            view3.setLayoutParams(layoutParams);
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(255054);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(255055);
        super.onSizeChanged(i2, i3, i4, i5);
        View view = this.wqt;
        this.wqv = view != null ? view.getMeasuredHeight() : 0;
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout != null) {
            refreshLoadMoreLayout.setExtraOverScrollFooterDx(this.wqv);
            AppMethodBeat.o(255055);
            return;
        }
        AppMethodBeat.o(255055);
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        AppMethodBeat.i(255056);
        super.onFinishInflate();
        this.wqu = findViewById(R.id.b36);
        this.tLS = (RefreshLoadMoreLayout) findViewById(R.id.h7t);
        AppMethodBeat.o(255056);
    }

    private final void log(String str) {
        AppMethodBeat.i(255057);
        if (this.cWq) {
            Log.i("LiveFriendsNestedScrollingParent2Layout", str);
        }
        AppMethodBeat.o(255057);
    }
}
