package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.MediaBanner;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\"\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010'\u001a\u00020&2\u0006\u0010#\u001a\u00020\u0007H\u0016J(\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\f\u0010*\u001a\b\u0018\u00010+R\u00020,2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020\u0007H\u0016J\u0018\u0010/\u001a\u00020&2\u0006\u0010.\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0016J(\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\f\u0010*\u001a\b\u0018\u00010+R\u00020,2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\tH\u0016J$\u00105\u001a\u00020&2\b\u00106\u001a\u0004\u0018\u00010,2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010.\u001a\u00020\u0007H\u0016R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001f\u0010\u0012¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderLinearLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "Lcom/tencent/mm/view/MediaBanner$ILayoutManagerScrollEnableCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "canScrollVertically", "getCanScrollVertically", "()Z", "setCanScrollVertically", "(Z)V", "extraLayoutSpace", "getExtraLayoutSpace", "()I", "setExtraLayoutSpace", "(I)V", "isSupportScrollConflictAdapt", "setSupportScrollConflictAdapt", "scrollState", "smoothScrollerSpeed", "", "getSmoothScrollerSpeed", "()F", "setSmoothScrollerSpeed", "(F)V", "touchSlop", "getTouchSlop", "touchSlop$delegate", "Lkotlin/Lazy;", "canScrollHorizontally", "state", "Landroid/support/v7/widget/RecyclerView$State;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setScrollVerticallyEnable", "enable", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-finder_release"})
public final class FinderLinearLayoutManager extends LinearLayoutManager implements MediaBanner.b {
    public static final a wtm = new a((byte) 0);
    private Context context;
    public int qOi;
    private int vp;
    private final f wcJ = g.ah(new c(this));
    public float wsx;
    private boolean wtk;
    public boolean wtl;

    static {
        AppMethodBeat.i(255279);
        AppMethodBeat.o(255279);
    }

    private final int getTouchSlop() {
        AppMethodBeat.i(255267);
        int intValue = ((Number) this.wcJ.getValue()).intValue();
        AppMethodBeat.o(255267);
        return intValue;
    }

    public static final /* synthetic */ Context a(FinderLinearLayoutManager finderLinearLayoutManager) {
        AppMethodBeat.i(255280);
        Context context2 = finderLinearLayoutManager.context;
        if (context2 == null) {
            p.btv("context");
        }
        AppMethodBeat.o(255280);
        return context2;
    }

    public FinderLinearLayoutManager(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(255277);
        setItemPrefetchEnabled(true);
        ca(6);
        this.wsx = 5.0f;
        this.qOi = -1;
        this.wtl = true;
        init(context2);
        AppMethodBeat.o(255277);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLinearLayoutManager(Context context2, byte b2) {
        super(0, false);
        p.h(context2, "context");
        AppMethodBeat.i(255278);
        setItemPrefetchEnabled(true);
        ca(6);
        this.wsx = 5.0f;
        this.qOi = -1;
        this.wtl = true;
        init(context2);
        AppMethodBeat.o(255278);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderLinearLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private void init(Context context2) {
        AppMethodBeat.i(255268);
        p.h(context2, "context");
        this.context = context2;
        AppMethodBeat.o(255268);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public final int b(RecyclerView.s sVar) {
        AppMethodBeat.i(261565);
        if (this.qOi == -1) {
            int b2 = super.b(sVar);
            AppMethodBeat.o(261565);
            return b2;
        }
        int i2 = this.qOi;
        AppMethodBeat.o(261565);
        return i2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void scrollToPosition(int i2) {
        AppMethodBeat.i(255269);
        super.scrollToPosition(i2);
        Log.i("Finder.FinderLayoutManager", "[scrollToPosition] position=".concat(String.valueOf(i2)));
        AppMethodBeat.o(255269);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public final void ah(int i2, int i3) {
        AppMethodBeat.i(255270);
        super.ah(i2, i3);
        Log.i("Finder.FinderLayoutManager", "[scrollToPositionWithOffset] position=" + i2 + " offset=" + i3);
        AppMethodBeat.o(255270);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/view/manager/FinderLinearLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"})
    public static final class b extends ae {
        final /* synthetic */ FinderLinearLayoutManager wtn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderLinearLayoutManager finderLinearLayoutManager, Context context) {
            super(context);
            this.wtn = finderLinearLayoutManager;
        }

        @Override // android.support.v7.widget.ae
        public final float a(DisplayMetrics displayMetrics) {
            AppMethodBeat.i(255265);
            p.h(displayMetrics, "displayMetrics");
            float f2 = this.wtn.wsx / ((float) displayMetrics.densityDpi);
            AppMethodBeat.o(255265);
            return f2;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(255271);
        Log.i("Finder.FinderLayoutManager", "[smoothScrollToPosition] position=".concat(String.valueOf(i2)));
        Context context2 = this.context;
        if (context2 == null) {
            p.btv("context");
        }
        b bVar = new b(this, context2);
        bVar.ct(i2);
        startSmoothScroll(bVar);
        AppMethodBeat.o(255271);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(255272);
        if (!this.wtk || Math.abs(i2) < getTouchSlop()) {
            int scrollHorizontallyBy = super.scrollHorizontallyBy(i2, nVar, sVar);
            if (scrollHorizontallyBy == 0 && i2 != 0 && this.vp == 2) {
                View childAt = getChildAt(0);
                ViewParent parent = childAt != null ? childAt.getParent() : null;
                if (!(parent instanceof RecyclerView)) {
                    parent = null;
                }
                RecyclerView recyclerView = (RecyclerView) parent;
                Log.i("Finder.FinderLayoutManager", "horizontal fling to end, " + i2 + ' ' + scrollHorizontallyBy + ", " + recyclerView);
                if (recyclerView != null) {
                    recyclerView.kQ();
                }
            }
            AppMethodBeat.o(255272);
            return scrollHorizontallyBy;
        }
        super.scrollHorizontallyBy(i2, nVar, sVar);
        AppMethodBeat.o(255272);
        return i2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public final void onScrollStateChanged(int i2) {
        AppMethodBeat.i(255273);
        super.onScrollStateChanged(i2);
        this.vp = i2;
        AppMethodBeat.o(255273);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(255274);
        if (!this.wtk || Math.abs(i2) < getTouchSlop()) {
            int scrollVerticallyBy = super.scrollVerticallyBy(i2, nVar, sVar);
            if (scrollVerticallyBy == 0 && i2 != 0 && this.vp == 2) {
                View childAt = getChildAt(0);
                ViewParent parent = childAt != null ? childAt.getParent() : null;
                if (!(parent instanceof RecyclerView)) {
                    parent = null;
                }
                RecyclerView recyclerView = (RecyclerView) parent;
                Log.i("Finder.FinderLayoutManager", "vertical fling to end, " + i2 + ' ' + scrollVerticallyBy + ", " + recyclerView);
                if (recyclerView != null) {
                    recyclerView.kQ();
                }
            }
            AppMethodBeat.o(255274);
            return scrollVerticallyBy;
        }
        super.scrollVerticallyBy(i2, nVar, sVar);
        AppMethodBeat.o(255274);
        return i2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollVertically() {
        AppMethodBeat.i(255275);
        if (!this.wtl || !super.canScrollVertically()) {
            AppMethodBeat.o(255275);
            return false;
        }
        AppMethodBeat.o(255275);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollHorizontally() {
        AppMethodBeat.i(255276);
        boolean canScrollHorizontally = super.canScrollHorizontally();
        AppMethodBeat.o(255276);
        return canScrollHorizontally;
    }

    @Override // com.tencent.mm.view.MediaBanner.b
    public final void pc(boolean z) {
        this.wtl = z;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderLinearLayoutManager wtn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderLinearLayoutManager finderLinearLayoutManager) {
            super(0);
            this.wtn = finderLinearLayoutManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(255266);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(FinderLinearLayoutManager.a(this.wtn));
            p.g(viewConfiguration, "ViewConfiguration.get(context)");
            Integer valueOf = Integer.valueOf(viewConfiguration.getScaledTouchSlop());
            AppMethodBeat.o(255266);
            return valueOf;
        }
    }
}
