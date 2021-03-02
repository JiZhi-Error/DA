package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ak;
import android.support.v7.widget.at;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 22\u00020\u0001:\u0003234B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010%\u001a\u00020$H\u0016J \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0016J\u0012\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010$H\u0016J\u000e\u0010.\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0016\u0010/\u001a\u00020'2\f\u00100\u001a\b\u0012\u0002\b\u0003\u0018\u000101H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00065"}, hxF = {"Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "frozeTouch", "", "getFrozeTouch", "()Z", "setFrozeTouch", "(Z)V", "historicalX", "", "onInterceptTouchEvent", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "getOnInterceptTouchEvent", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "setOnInterceptTouchEvent", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;)V", "pageChangeListener", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "getPageChangeListener", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "setPageChangeListener", "(Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;)V", "snapHelper", "Landroid/support/v7/widget/SnapHelper;", "getSnapHelper", "()Landroid/support/v7/widget/SnapHelper;", "setSnapHelper", "(Landroid/support/v7/widget/SnapHelper;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "event", "onPageChange", "", "position", "", "isIdle", "isAuto", "onTouchEvent", "e", "selectViewAt", "setAdapter", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Companion", "IPageChangeCallback", "OnInterceptTouchEvent", "libmmui_release"})
public class RecyclerHorizontalViewPager extends RecyclerView {
    public static final a RlD = new a((byte) 0);
    private at RlA;
    private boolean RlB;
    private c RlC;
    private b Rlz;
    private float historicalX;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "libmmui_release"})
    public interface b {
        void aC(int i2, boolean z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$OnInterceptTouchEvent;", "", "isIntercept", "", TencentLocation.EXTRA_DIRECTION, "", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "onDispatchTouchEvent", "", "ev", "libmmui_release"})
    public interface c {
        boolean b(MotionEvent motionEvent, boolean z);

        void n(MotionEvent motionEvent);
    }

    static {
        AppMethodBeat.i(164570);
        AppMethodBeat.o(164570);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/view/RecyclerHorizontalViewPager$Companion;", "", "()V", "TAG", "", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerHorizontalViewPager(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(164568);
        AppMethodBeat.o(164568);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerHorizontalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(164569);
        AppMethodBeat.o(164569);
    }

    public final b getPageChangeListener() {
        return this.Rlz;
    }

    public final void setPageChangeListener(b bVar) {
        this.Rlz = bVar;
    }

    public final at getSnapHelper() {
        return this.RlA;
    }

    public final void setSnapHelper(at atVar) {
        this.RlA = atVar;
    }

    public final boolean getFrozeTouch() {
        return this.RlB;
    }

    public final void setFrozeTouch(boolean z) {
        this.RlB = z;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.a<?> aVar) {
        AppMethodBeat.i(164564);
        if (this.RlA == null) {
            this.RlA = new ak();
        }
        at atVar = this.RlA;
        if (atVar != null) {
            atVar.f(this);
        }
        super.setAdapter(aVar);
        a(new d(this));
        AppMethodBeat.o(164564);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0005¨\u0006\u0014"}, hxF = {"com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "firstRect", "Landroid/graphics/Rect;", "getFirstRect", "()Landroid/graphics/Rect;", "lastPos", "", "getLastPos", "()I", "setLastPos", "(I)V", "secondRect", "getSecondRect", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "dy", "libmmui_release"})
    public static final class d extends RecyclerView.l {
        private final Rect RlE = new Rect();
        private final Rect RlF = new Rect();
        final /* synthetic */ RecyclerHorizontalViewPager RlG;
        private int tex = -1;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(204981);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(204981);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(RecyclerHorizontalViewPager recyclerHorizontalViewPager) {
            this.RlG = recyclerHorizontalViewPager;
            AppMethodBeat.i(164563);
            AppMethodBeat.o(164563);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            View view = null;
            AppMethodBeat.i(164562);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            RecyclerView.LayoutManager layoutManager = this.RlG.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(164562);
                throw tVar;
            }
            int ks = ((LinearLayoutManager) layoutManager).ks();
            RecyclerView.LayoutManager layoutManager2 = this.RlG.getLayoutManager();
            if (layoutManager2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(164562);
                throw tVar2;
            }
            int ku = ((LinearLayoutManager) layoutManager2).ku();
            RecyclerView.v ch = recyclerView.ch(ks);
            View view2 = ch != null ? ch.aus : null;
            RecyclerView.v ch2 = recyclerView.ch(ku);
            if (ch2 != null) {
                view = ch2.aus;
            }
            if (view2 != null) {
                view2.getLocalVisibleRect(this.RlE);
            }
            if (view != null) {
                view.getLocalVisibleRect(this.RlF);
            }
            if (this.RlE.width() <= this.RlF.width()) {
                ks = ku;
            }
            if (!(ks == this.tex || ks == -1)) {
                this.RlG.post(new a(this, ks));
                this.tex = ks;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/RecyclerHorizontalViewPager$setAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(164562);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ int AvD;
            final /* synthetic */ d RlH;

            a(d dVar, int i2) {
                this.RlH = dVar;
                this.AvD = i2;
            }

            public final void run() {
                AppMethodBeat.i(164561);
                this.RlH.RlG.e(this.AvD, true, true);
                AppMethodBeat.o(164561);
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(164565);
        p.h(motionEvent, "ev");
        if (motionEvent.getActionMasked() == 3) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 1, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
            AppMethodBeat.o(164565);
            return dispatchTouchEvent;
        }
        c cVar = this.RlC;
        if (cVar != null) {
            cVar.n(motionEvent);
        }
        boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(164565);
        return dispatchTouchEvent2;
    }

    public void e(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(204982);
        b bVar = this.Rlz;
        if (bVar != null) {
            bVar.aC(i2, z);
            AppMethodBeat.o(204982);
            return;
        }
        AppMethodBeat.o(204982);
    }

    public final c getOnInterceptTouchEvent() {
        return this.RlC;
    }

    public final void setOnInterceptTouchEvent(c cVar) {
        this.RlC = cVar;
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(164567);
        p.h(motionEvent, "event");
        if (this.RlB) {
            AppMethodBeat.o(164567);
            return false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        c cVar = this.RlC;
        if (cVar != null) {
            if (motionEvent.getAction() == 0) {
                this.historicalX = motionEvent.getX();
            }
            motionEvent.getX(0);
            boolean b2 = cVar.b(motionEvent, onInterceptTouchEvent);
            if (!b2) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                p.g(obtain, "cancelEvent");
                obtain.setAction(3);
                onTouchEvent(obtain);
            }
            AppMethodBeat.o(164567);
            return b2;
        }
        AppMethodBeat.o(164567);
        return onInterceptTouchEvent;
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(204983);
        if (this.RlB) {
            AppMethodBeat.o(204983);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(204983);
        return onTouchEvent;
    }
}
