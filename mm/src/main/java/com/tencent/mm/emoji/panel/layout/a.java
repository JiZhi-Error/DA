package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0002\u0004&\u0018\u0000 >2\u00020\u0001:\u0004>?@AB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00100\u001a\u0002012\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0006\u00102\u001a\u000201J\u0014\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0014J\u001a\u00107\u001a\u0004\u0018\u0001082\u0006\u00105\u001a\u0002062\u0006\u00109\u001a\u00020\u0007H\u0002J\u0014\u0010:\u001a\u0004\u0018\u0001082\b\u00105\u001a\u0004\u0018\u000106H\u0016J \u0010;\u001a\u00020)2\u0006\u00105\u001a\u0002062\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u00105\u001a\u000206H\u0002J\u0010\u0010.\u001a\u00020\u00072\u0006\u00105\u001a\u000206H\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0004¢\u0006\u0004\n\u0002\u0010'R\u001e\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000b¨\u0006B"}, hxF = {"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "dataObserver", "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$dataObserver$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$dataObserver$1;", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "getHorizontalHelper", "()Landroid/support/v7/widget/OrientationHelper;", "setHorizontalHelper", "(Landroid/support/v7/widget/OrientationHelper;)V", "isDragging", "", "()Z", "setDragging", "(Z)V", "onPageSelectedListener", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;)V", "onPageSettledListener", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "getOnPageSettledListener", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "setOnPageSettledListener", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;)V", "onPageStartChangeListener", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "getOnPageStartChangeListener", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "setOnPageStartChangeListener", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "scrollListener", "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1;", "<set-?>", "", "snapPosition", "getSnapPosition", "()I", "verticalHelper", "getVerticalHelper", "setVerticalHelper", "attachToRecyclerView", "", "checkSettle", "createScroller", "Landroid/support/v7/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "findCenterView", "Landroid/view/View;", "helper", "findSnapView", "findTargetSnapPosition", "velocityX", "velocityY", "Companion", "OnPageSelectedListener", "OnPageSettledListener", "OnPageStartChangeListener", "plugin-emojisdk_release"})
public final class a extends ak {
    public static final C0333a hbU = new C0333a((byte) 0);
    private RecyclerView hak;
    private aj hbL;
    private aj hbM;
    public boolean hbN;
    private final g hbO = new g(this);
    private final f hbP = new f(this);
    public int hbQ = -1;
    public b hbR;
    public c hbS;
    public d hbT;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-emojisdk_release"})
    public interface b {
        void onPageSelected(int i2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "", "onPageSettle", "", "position", "", "plugin-emojisdk_release"})
    public interface c {
        void pq(int i2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "", "onPageStartChange", "", "position", "", "plugin-emojisdk_release"})
    public interface d {
        void pr(int i2);
    }

    static {
        AppMethodBeat.i(199997);
        AppMethodBeat.o(199997);
    }

    public a() {
        AppMethodBeat.i(199996);
        AppMethodBeat.o(199996);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.panel.layout.a$a  reason: collision with other inner class name */
    public static final class C0333a {
        private C0333a() {
        }

        public /* synthetic */ C0333a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"})
    public static final class g extends RecyclerView.l {
        final /* synthetic */ a hbV;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(199990);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(199990);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(a aVar) {
            this.hbV = aVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(199989);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            Log.i("MicroMsg.CenterPagerSnapHelper", "onScrollStateChanged:" + i2 + ", snapPosition:" + this.hbV.hbQ);
            if (i2 == 0) {
                this.hbV.hbN = false;
                this.hbV.avW();
            }
            if (i2 == 1) {
                this.hbV.hbN = true;
                d dVar = this.hbV.hbT;
                if (dVar != null) {
                    dVar.pr(this.hbV.hbQ);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(199989);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$dataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "plugin-emojisdk_release"})
    public static final class f extends RecyclerView.c {
        final /* synthetic */ a hbV;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(a aVar) {
            this.hbV = aVar;
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onChanged() {
            RecyclerView recyclerView;
            AppMethodBeat.i(199987);
            super.onChanged();
            if (this.hbV.hbQ != -1 || (recyclerView = this.hbV.hak) == null) {
                AppMethodBeat.o(199987);
                return;
            }
            recyclerView.post(new RunnableC0334a(this));
            AppMethodBeat.o(199987);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.emoji.panel.layout.a$f$a  reason: collision with other inner class name */
        static final class RunnableC0334a implements Runnable {
            final /* synthetic */ f hbW;

            RunnableC0334a(f fVar) {
                this.hbW = fVar;
            }

            public final void run() {
                AppMethodBeat.i(199985);
                this.hbW.hbV.avW();
                AppMethodBeat.o(199985);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeInserted(int i2, int i3) {
            RecyclerView recyclerView;
            AppMethodBeat.i(199988);
            super.onItemRangeInserted(i2, i3);
            if (this.hbV.hbQ != -1 || (recyclerView = this.hbV.hak) == null) {
                AppMethodBeat.o(199988);
                return;
            }
            recyclerView.post(new b(this));
            AppMethodBeat.o(199988);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ f hbW;

            b(f fVar) {
                this.hbW = fVar;
            }

            public final void run() {
                AppMethodBeat.i(199986);
                this.hbW.hbV.avW();
                AppMethodBeat.o(199986);
            }
        }
    }

    @Override // android.support.v7.widget.at
    public final void f(RecyclerView recyclerView) {
        RecyclerView.a adapter;
        RecyclerView.a adapter2;
        AppMethodBeat.i(199991);
        super.f(recyclerView);
        RecyclerView recyclerView2 = this.hak;
        if (recyclerView2 != null) {
            recyclerView2.b(this.hbO);
        }
        RecyclerView recyclerView3 = this.hak;
        if (!(recyclerView3 == null || (adapter2 = recyclerView3.getAdapter()) == null)) {
            adapter2.b(this.hbP);
        }
        this.hak = recyclerView;
        RecyclerView recyclerView4 = this.hak;
        if (recyclerView4 != null) {
            recyclerView4.a(this.hbO);
        }
        RecyclerView recyclerView5 = this.hak;
        if (!(recyclerView5 == null || (adapter = recyclerView5.getAdapter()) == null)) {
            adapter.a(this.hbP);
        }
        avW();
        AppMethodBeat.o(199991);
    }

    @Override // android.support.v7.widget.at
    public final RecyclerView.r g(RecyclerView.LayoutManager layoutManager) {
        Context context = null;
        AppMethodBeat.i(199992);
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            AppMethodBeat.o(199992);
            return null;
        }
        RecyclerView recyclerView = this.hak;
        if (recyclerView != null) {
            context = recyclerView.getContext();
        }
        e eVar = new e(this, layoutManager, context);
        AppMethodBeat.o(199992);
        return eVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014¨\u0006\u000e"}, hxF = {"com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$createScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", NativeProtocol.WEB_DIALOG_ACTION, "Landroid/support/v7/widget/RecyclerView$SmoothScroller$Action;", "plugin-emojisdk_release"})
    public static final class e extends ae {
        final /* synthetic */ RecyclerView.LayoutManager $layoutManager;
        final /* synthetic */ a hbV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar, RecyclerView.LayoutManager layoutManager, Context context) {
            super(context);
            this.hbV = aVar;
            this.$layoutManager = layoutManager;
        }

        @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
        public final void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
            AppMethodBeat.i(199983);
            p.h(view, "targetView");
            p.h(sVar, "state");
            p.h(aVar, NativeProtocol.WEB_DIALOG_ACTION);
            if (this.hbV.hak != null) {
                int[] a2 = this.hbV.a(this.$layoutManager, view);
                if (a2 == null) {
                    p.hyc();
                }
                int i2 = a2[0];
                int i3 = a2[1];
                int cc = cc(Math.max(Math.abs(i2), Math.abs(i3)));
                if (cc > 0) {
                    aVar.a(i2, i3, cc, this.VQ);
                    AppMethodBeat.o(199983);
                    return;
                }
                aVar.a(i2, i3, 1, this.VQ);
            }
            AppMethodBeat.o(199983);
        }

        @Override // android.support.v7.widget.ae
        public final float a(DisplayMetrics displayMetrics) {
            AppMethodBeat.i(199984);
            p.h(displayMetrics, "displayMetrics");
            float f2 = 50.0f / ((float) displayMetrics.densityDpi);
            AppMethodBeat.o(199984);
            return f2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        if (r0.getLayoutManager() != r11) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        if (r0.getLayoutManager() != r11) goto L_0x0060;
     */
    @Override // android.support.v7.widget.at, android.support.v7.widget.ak
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(android.support.v7.widget.RecyclerView.LayoutManager r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 298
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.panel.layout.a.a(android.support.v7.widget.RecyclerView$LayoutManager, int, int):int");
    }

    @Override // android.support.v7.widget.at, android.support.v7.widget.ak
    public final View a(RecyclerView.LayoutManager layoutManager) {
        AppMethodBeat.i(199994);
        View a2 = super.a(layoutManager);
        ViewGroup.LayoutParams layoutParams = a2 != null ? a2.getLayoutParams() : null;
        if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
            layoutParams = null;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        int lG = layoutParams2 != null ? layoutParams2.lG() : -1;
        if (this.hbQ != lG) {
            this.hbQ = lG;
            b bVar = this.hbR;
            if (bVar != null) {
                bVar.onPageSelected(this.hbQ);
            }
        }
        AppMethodBeat.o(199994);
        return a2;
    }

    public final void avW() {
        RecyclerView.LayoutManager layoutManager;
        c cVar;
        AppMethodBeat.i(199995);
        if (this.hbS == null) {
            AppMethodBeat.o(199995);
            return;
        }
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            AppMethodBeat.o(199995);
            return;
        }
        p.g(layoutManager, "recyclerView?.layoutManager ?: return");
        View a2 = a(layoutManager);
        if (a2 == null) {
            AppMethodBeat.o(199995);
            return;
        }
        int[] a3 = a(layoutManager, a2);
        if (a3 == null) {
            AppMethodBeat.o(199995);
        } else if ((a3[0] == 0 || a3[1] == 0) && (cVar = this.hbS) != null) {
            cVar.pq(this.hbQ);
            AppMethodBeat.o(199995);
        } else {
            AppMethodBeat.o(199995);
        }
    }
}
