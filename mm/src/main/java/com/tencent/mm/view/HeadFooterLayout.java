package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.n;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0015\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0016\u0018\u0000 y2\u00020\u00012\u00020\u0002:\u0002yzB\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020\u00152\b\b\u0002\u0010C\u001a\u00020!J\u0018\u0010D\u001a\u0002002\u0006\u0010B\u001a\u00020\u00152\b\b\u0002\u0010C\u001a\u00020!J\u0010\u0010E\u001a\u0004\u0018\u00010\u00152\u0006\u0010F\u001a\u00020\nJ\u0010\u0010G\u001a\u0004\u0018\u00010\u00152\u0006\u0010F\u001a\u00020\nJ\u000e\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020<J\u000e\u0010J\u001a\u00020!2\u0006\u0010I\u001a\u00020<J\u0016\u0010K\u001a\u00020!2\u0006\u0010I\u001a\u00020<2\u0006\u0010L\u001a\u00020\nJ\b\u0010M\u001a\u00020!H\u0016J\u0010\u0010N\u001a\u0002002\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010O\u001a\u000200H\u0014J\u0018\u0010P\u001a\u0002002\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\nH\u0014J0\u0010S\u001a\u0002002\u0006\u0010I\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\nH\u0016J8\u0010W\u001a\u0002002\u0006\u0010I\u001a\u00020\u00152\u0006\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010V\u001a\u00020\nH\u0016J(\u0010\\\u001a\u0002002\u0006\u0010]\u001a\u00020\u00152\u0006\u0010^\u001a\u00020\u00152\u0006\u0010_\u001a\u00020\n2\u0006\u0010`\u001a\u00020\nH\u0016J0\u0010a\u001a\u0002002\u0006\u0010I\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\nH\u0016JP\u0010b\u001a\u0002002\u0006\u0010;\u001a\u00020<2\u0006\u0010c\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020!2\u0006\u0010f\u001a\u00020!2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\n2\u0006\u0010g\u001a\u00020!H\u0016J(\u0010h\u001a\u00020!2\u0006\u0010i\u001a\u00020\u00152\u0006\u0010I\u001a\u00020\u00152\u0006\u0010j\u001a\u00020\n2\u0006\u0010V\u001a\u00020\nH\u0016J\u0018\u0010k\u001a\u0002002\u0006\u0010I\u001a\u00020\u00152\u0006\u0010V\u001a\u00020\nH\u0016J \u0010l\u001a\u0002002\u0006\u0010;\u001a\u00020<2\u0006\u0010c\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\nH\u0016J\u0012\u0010m\u001a\u0002002\b\u0010i\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010n\u001a\u0002002\u0006\u0010o\u001a\u00020p2\b\b\u0002\u0010q\u001a\u00020!J\u0018\u0010r\u001a\u0002002\u0006\u0010B\u001a\u00020\u00152\b\b\u0002\u0010C\u001a\u00020!J\u0018\u0010s\u001a\u0002002\u0006\u0010B\u001a\u00020\u00152\b\b\u0002\u0010C\u001a\u00020!J\b\u0010t\u001a\u000200H\u0016J\b\u0010u\u001a\u000200H\u0016J\u0010\u0010v\u001a\u0002002\u0006\u0010w\u001a\u00020xH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010(\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\"\"\u0004\b)\u0010$RL\u0010*\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\n¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006{"}, hxF = {"Lcom/tencent/mm/view/HeadFooterLayout;", "Landroid/widget/LinearLayout;", "Landroid/support/v4/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "decoratedBounds", "Landroid/graphics/Rect;", "extraOverScrollFooterDx", "getExtraOverScrollFooterDx", "()I", "setExtraOverScrollFooterDx", "(I)V", "footerViews", "Ljava/util/LinkedList;", "Landroid/view/View;", "getFooterViews", "()Ljava/util/LinkedList;", "footersHeight", "getFootersHeight", "setFootersHeight", "headerViews", "getHeaderViews", "headersHeight", "getHeadersHeight", "setHeadersHeight", "isConsumeOverScroll", "", "()Z", "setConsumeOverScroll", "(Z)V", "isDirtyLayout", "isEnableNestedScroll", "setEnableNestedScroll", "isSuperNestedScroll", "setSuperNestedScroll", "onTranslateYCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "dx", "dy", "", "getOnTranslateYCallback", "()Lkotlin/jvm/functions/Function2;", "setOnTranslateYCallback", "(Lkotlin/jvm/functions/Function2;)V", "overCallback", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "getOverCallback", "()Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "setOverCallback", "(Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "addFooter", "view", "isDirty", "addHeader", "getFooter", "id", "getHeader", "isFirstItemReachTop", "target", "isLastItemBottomVisible", "isLastItemReachBottom", "offset", "isNestedScrollingEnabled", "onBindRecyclerView", "onFinishInflate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedPreScroll", "consumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "p0", "p1", "p2", "p3", "onNotOverScroll", "onOverScroll", "parent", "dampingDy", "isEnd", "isVertical", "isTopOverScroll", "onStartNestedScroll", "child", "axes", "onStopNestedScroll", "onStopScroll", "onViewAdded", SharePatchInfo.FINGER_PRINT, "log", "", "isVerbose", "removeFooter", "removeHeader", "requestLayout", "resetChildren", "setTranslationY", "translationY", "", "Companion", "OverCallback", "libmmui_release"})
public class HeadFooterLayout extends LinearLayout implements n {
    public static final a RjA = new a((byte) 0);
    private b Rjo;
    private boolean Rjp;
    boolean Rjq = true;
    boolean Rjr;
    private m<? super Integer, ? super Integer, x> Rjs;
    private final Rect Rjt = new Rect();
    private final LinkedList<View> Rju = new LinkedList<>();
    private final LinkedList<View> Rjv = new LinkedList<>();
    private int Rjw;
    private int Rjx;
    private boolean Rjy;
    private int Rjz;
    public RecyclerView hak;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H&J0\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\r"}, hxF = {"Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "", "onOverEnd", "", "dx", "", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "", "libmmui_release"})
    public interface b {
        boolean IJ(int i2);

        void ddr();

        boolean u(int i2, int i3, boolean z);
    }

    static {
        AppMethodBeat.i(164536);
        AppMethodBeat.o(164536);
    }

    public final b getOverCallback() {
        return this.Rjo;
    }

    public final void setOverCallback(b bVar) {
        this.Rjo = bVar;
    }

    public final void setConsumeOverScroll(boolean z) {
        this.Rjp = z;
    }

    public final void setEnableNestedScroll(boolean z) {
        this.Rjq = z;
    }

    public final void setSuperNestedScroll(boolean z) {
        this.Rjr = z;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.Integer, kotlin.x>, kotlin.g.a.m<java.lang.Integer, java.lang.Integer, kotlin.x> */
    public final m<Integer, Integer, x> getOnTranslateYCallback() {
        return this.Rjs;
    }

    public final void setOnTranslateYCallback(m<? super Integer, ? super Integer, x> mVar) {
        this.Rjs = mVar;
    }

    public void setTranslationY(float f2) {
        AppMethodBeat.i(204951);
        super.setTranslationY(f2);
        m<? super Integer, ? super Integer, x> mVar = this.Rjs;
        if (mVar != null) {
            mVar.invoke(0, Integer.valueOf((int) f2));
            AppMethodBeat.o(204951);
            return;
        }
        AppMethodBeat.o(204951);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01ad  */
    @Override // android.support.v4.view.n
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r13, int r14, int r15, int[] r16, int r17) {
        /*
        // Method dump skipped, instructions count: 486
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.view.HeadFooterLayout.a(android.view.View, int, int, int[], int):void");
    }

    public void a(View view, int i2, int[] iArr) {
        AppMethodBeat.i(164515);
        p.h(view, "target");
        p.h(iArr, "consumed");
        AppMethodBeat.o(164515);
    }

    public static boolean w(RecyclerView recyclerView) {
        View findViewByPosition;
        View findViewByPosition2;
        AppMethodBeat.i(164516);
        p.h(recyclerView, "target");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] n = ((StaggeredGridLayoutManager) layoutManager).n(null);
            p.g(n, "firstVisibleInfo");
            boolean z = false;
            for (int i2 : n) {
                if (i2 == 0) {
                    z = true;
                }
            }
            if (z && (findViewByPosition2 = layoutManager.findViewByPosition(0)) != null) {
                if (findViewByPosition2.getTop() >= 0) {
                    AppMethodBeat.o(164516);
                    return true;
                }
                AppMethodBeat.o(164516);
                return false;
            }
        } else if ((layoutManager instanceof LinearLayoutManager) && (findViewByPosition = layoutManager.findViewByPosition(0)) != null) {
            if (findViewByPosition.getTop() >= 0) {
                AppMethodBeat.o(164516);
                return true;
            }
            AppMethodBeat.o(164516);
            return false;
        }
        AppMethodBeat.o(164516);
        return false;
    }

    public final boolean x(RecyclerView recyclerView) {
        int ku;
        View findViewByPosition;
        View findViewByPosition2;
        AppMethodBeat.i(204952);
        p.h(recyclerView, "target");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] o = ((StaggeredGridLayoutManager) layoutManager).o(null);
            p.g(o, "lastVisibleInfo");
            int length = o.length;
            int i2 = 0;
            boolean z = false;
            while (i2 < length) {
                boolean z2 = o[i2] == ((StaggeredGridLayoutManager) layoutManager).getItemCount() - 1 ? true : z;
                i2++;
                z = z2;
            }
            if (z) {
                boolean z3 = false;
                int i3 = 0;
                for (int i4 : o) {
                    if (!(i4 == -1 || (findViewByPosition2 = layoutManager.findViewByPosition(i4)) == null)) {
                        RecyclerView.getDecoratedBoundsWithMargins(findViewByPosition2, this.Rjt);
                        int i5 = this.Rjt.bottom;
                        if (findViewByPosition2.getBottom() > i3) {
                            z3 = i5 <= recyclerView.getHeight() && i5 >= recyclerView.getHeight() + 0;
                            i3 = findViewByPosition2.getBottom();
                        }
                    }
                }
                AppMethodBeat.o(204952);
                return z3;
            }
        } else if ((layoutManager instanceof LinearLayoutManager) && (ku = ((LinearLayoutManager) layoutManager).ku()) == ((LinearLayoutManager) layoutManager).getItemCount() - 1 && (findViewByPosition = layoutManager.findViewByPosition(ku)) != null) {
            RecyclerView.getDecoratedBoundsWithMargins(findViewByPosition, this.Rjt);
            int i6 = this.Rjt.bottom;
            if (i6 <= recyclerView.getHeight() && i6 >= recyclerView.getHeight() + 0) {
                AppMethodBeat.o(204952);
                return true;
            }
        }
        AppMethodBeat.o(204952);
        return false;
    }

    @Override // android.support.v4.view.n
    public void k(View view, int i2) {
        AppMethodBeat.i(164518);
        p.h(view, "target");
        b bVar = this.Rjo;
        if (bVar != null) {
            bVar.ddr();
        }
        this.Rjp = false;
        if (!(view instanceof RecyclerView) || !(((RecyclerView) view).getLayoutManager() instanceof LinearLayoutManager) || !p.j(view, getRecyclerView())) {
            if ((view instanceof RecyclerView) && (((RecyclerView) view).getLayoutManager() instanceof StaggeredGridLayoutManager) && p.j(view, getRecyclerView())) {
                a(getRecyclerView(), this, i2);
            }
            AppMethodBeat.o(164518);
            return;
        }
        a(getRecyclerView(), this, i2);
        AppMethodBeat.o(164518);
    }

    @Override // android.support.v4.view.n
    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(164521);
        p.h(view, "target");
        super.onNestedScroll(view, i2, i3, i4, i5);
        AppMethodBeat.o(164521);
    }

    @Override // android.support.v4.view.n
    public void b(View view, View view2, int i2, int i3) {
        AppMethodBeat.i(164520);
        p.h(view, "p0");
        p.h(view2, "p1");
        AppMethodBeat.o(164520);
    }

    @Override // android.support.v4.view.n
    public boolean a(View view, View view2, int i2, int i3) {
        AppMethodBeat.i(164519);
        p.h(view, "child");
        p.h(view2, "target");
        if (this.Rjr) {
            boolean startNestedScroll = super.startNestedScroll(i2);
            AppMethodBeat.o(164519);
            return startNestedScroll;
        }
        boolean z = this.Rjq;
        AppMethodBeat.o(164519);
        return z;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/view/HeadFooterLayout$Companion;", "", "()V", "TAG", "", "isDebug", "", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public LinkedList<View> getHeaderViews() {
        return this.Rju;
    }

    public LinkedList<View> getFooterViews() {
        return this.Rjv;
    }

    public int getHeadersHeight() {
        return this.Rjw;
    }

    public void setHeadersHeight(int i2) {
        this.Rjw = i2;
    }

    public int getFootersHeight() {
        return this.Rjx;
    }

    public void setFootersHeight(int i2) {
        this.Rjx = i2;
    }

    public RecyclerView getRecyclerView() {
        AppMethodBeat.i(164522);
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        AppMethodBeat.o(164522);
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        AppMethodBeat.i(164523);
        p.h(recyclerView, "<set-?>");
        this.hak = recyclerView;
        AppMethodBeat.o(164523);
    }

    public HeadFooterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(164534);
        AppMethodBeat.o(164534);
    }

    public HeadFooterLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(164535);
        AppMethodBeat.o(164535);
    }

    public final void W(View view, boolean z) {
        AppMethodBeat.i(164524);
        p.h(view, "view");
        getHeaderViews().add(view);
        this.Rjy = z;
        requestLayout();
        AppMethodBeat.o(164524);
    }

    public final void X(View view, boolean z) {
        AppMethodBeat.i(204953);
        p.h(view, "view");
        if (getHeaderViews().remove(view)) {
            removeView(view);
            this.Rjy = z;
            requestLayout();
        }
        AppMethodBeat.o(204953);
    }

    public final void Y(View view, boolean z) {
        AppMethodBeat.i(164525);
        p.h(view, "view");
        getFooterViews().add(view);
        this.Rjy = z;
        requestLayout();
        dD("[addFooter] view=" + view + " isDirty=" + z + " hash=" + hashCode(), false);
        AppMethodBeat.o(164525);
    }

    public final View getFooter$7529eef0() {
        T t;
        boolean z;
        AppMethodBeat.i(204954);
        Iterator<T> it = getFooterViews().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (R.id.cu5 == next.getId()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        T t2 = t;
        AppMethodBeat.o(204954);
        return t2;
    }

    public final void Z(View view, boolean z) {
        AppMethodBeat.i(204955);
        p.h(view, "view");
        if (getFooterViews().remove(view)) {
            this.Rjy = z;
            removeView(view);
            requestLayout();
            dD("[removeFooter] view=" + view + " isDirty=" + z + " hash=" + hashCode(), false);
        }
        AppMethodBeat.o(204955);
    }

    public void requestLayout() {
        AppMethodBeat.i(164526);
        super.requestLayout();
        if (this.Rjy) {
            this.Rjy = false;
            hfE();
        }
        AppMethodBeat.o(164526);
    }

    private void hfE() {
        AppMethodBeat.i(164527);
        removeAllViews();
        Iterator<View> it = getHeaderViews().iterator();
        while (it.hasNext()) {
            addView(it.next());
        }
        addView(getRecyclerView(), getRecyclerView().getLayoutParams());
        Iterator<View> it2 = getFooterViews().iterator();
        while (it2.hasNext()) {
            addView(it2.next());
        }
        AppMethodBeat.o(164527);
    }

    public boolean isNestedScrollingEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(164528);
        super.onFinishInflate();
        hfE();
        AppMethodBeat.o(164528);
    }

    public void onViewAdded(View view) {
        AppMethodBeat.i(164529);
        super.onViewAdded(view);
        if (view instanceof RecyclerView) {
            setRecyclerView((RecyclerView) view);
        }
        AppMethodBeat.o(164529);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        AppMethodBeat.i(164530);
        setFootersHeight(0);
        setHeadersHeight(0);
        if (getRecyclerView().getVisibility() == 0) {
            getRecyclerView().measure(i2, i3);
        }
        int measuredHeight = getRecyclerView().getMeasuredHeight();
        if (getRecyclerView().getVisibility() == 8) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!p.j(childAt, getRecyclerView()) && !getHeaderViews().contains(childAt) && !getFooterViews().contains(childAt)) {
                    childAt.measure(i2, i3);
                    i5 += View.MeasureSpec.getSize(i3);
                }
            }
            i4 = i5;
        } else {
            i4 = measuredHeight;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0);
        for (T t : getHeaderViews()) {
            t.measure(i2, makeMeasureSpec);
            i4 += t.getMeasuredHeight();
            setHeadersHeight(t.getMeasuredHeight() + getHeadersHeight());
        }
        for (T t2 : getFooterViews()) {
            t2.measure(i2, makeMeasureSpec);
            i4 += t2.getMeasuredHeight();
            setFootersHeight(t2.getMeasuredHeight() + getFootersHeight());
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i2), i4);
        AppMethodBeat.o(164530);
    }

    public static void dD(String str, boolean z) {
        AppMethodBeat.i(204956);
        p.h(str, "log");
        if (!z) {
            Log.i("HeadFooterLayout", str);
        }
        AppMethodBeat.o(204956);
    }

    public void a(RecyclerView recyclerView, HeadFooterLayout headFooterLayout, int i2) {
        AppMethodBeat.i(164532);
        p.h(recyclerView, "recyclerView");
        p.h(headFooterLayout, "parent");
        AppMethodBeat.o(164532);
    }

    public final int getExtraOverScrollFooterDx() {
        return this.Rjz;
    }

    public final void setExtraOverScrollFooterDx(int i2) {
        this.Rjz = i2;
    }

    public void a(RecyclerView recyclerView, HeadFooterLayout headFooterLayout, int i2, int i3, boolean z, boolean z2, int[] iArr, int i4, boolean z3) {
        int clamp;
        AppMethodBeat.i(164533);
        p.h(recyclerView, "recyclerView");
        p.h(headFooterLayout, "parent");
        p.h(iArr, "consumed");
        if (z && z3) {
            clamp = android.support.v4.b.a.clamp(((int) getTranslationY()) - i3, ((-getHeadersHeight()) - getFootersHeight()) - this.Rjz, 0);
        } else if (z) {
            clamp = android.support.v4.b.a.clamp(((int) getTranslationY()) - i3, ((-getHeadersHeight()) - getFootersHeight()) - this.Rjz, -getHeadersHeight());
        } else {
            clamp = android.support.v4.b.a.clamp(((int) getTranslationY()) - i3, -getHeadersHeight(), 0);
        }
        if (getTranslationY() != (-((float) getHeadersHeight()))) {
            iArr[1] = i2;
        }
        if (getTranslationY() != ((float) clamp)) {
            setTranslationY((float) clamp);
            iArr[1] = i2;
        }
        dD("onOverScroll dy:" + i2 + " dampingDy:" + i3 + " isEnd:" + z + " consumed[1]:" + iArr + "[1] translationY:" + getTranslationY() + " targetY:" + clamp + " headersHeight:" + getHeadersHeight() + " footersHeight:" + getFootersHeight(), true);
        AppMethodBeat.o(164533);
    }
}
