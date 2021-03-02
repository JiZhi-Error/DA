package com.tencent.mm.plugin.finder.event.base;

import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.k;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020GH\u0002J\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0013H\u0016J\b\u0010M\u001a\u00020\u0002H\u0016J\u0018\u0010N\u001a\u00020K2\u0006\u00107\u001a\u0002082\u0006\u0010L\u001a\u00020\u0013H\u0016J\u0010\u0010O\u001a\u00020P2\u0006\u00107\u001a\u000208H\u0016J\b\u0010Q\u001a\u00020PH\u0016J\b\u0010R\u001a\u00020PH\u0016J\u0018\u0010S\u001a\u00020P2\u0006\u00107\u001a\u0002082\u0006\u0010L\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010$R\u001a\u0010%\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001a\u0010(\u001a\u00020)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001a\u00101\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R\u001a\u00104\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0011\u00109\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0015R\u001a\u0010;\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u0010\u0017R\u001a\u0010>\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0015\"\u0004\b@\u0010\u0017R\u000e\u0010A\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010B\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010E¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "PostDelayTime", "", "getPostDelayTime", "()J", "TAG", "", "adapterDataObserver", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "getAdapterDataObserver", "()Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "config", "Landroid/view/ViewConfiguration;", "currentStats", "", "getCurrentStats", "()I", "setCurrentStats", "(I)V", "dataChangeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getDataChangeHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "globalVisibleRect", "Landroid/graphics/Rect;", "getGlobalVisibleRect", "()Landroid/graphics/Rect;", "setGlobalVisibleRect", "(Landroid/graphics/Rect;)V", "isOpenTPPlayerScroll", "", "()Z", "last5Index", "getLast5Index", "setLast5Index", "last5Offset", "", "getLast5Offset", "()[I", "setLast5Offset", "([I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "scaledTouchSlop", "getScaledTouchSlop", "sessionScrollOffset", "getSessionScrollOffset", "setSessionScrollOffset", "sumOffset", "getSumOffset", "setSumOffset", "visible", "visibleRunnable", "Ljava/lang/Runnable;", "getVisibleRunnable", "()Ljava/lang/Runnable;", "calculateVariance", "", "array", "average", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "newState", "getBehavior", "handleEvent", "onBindRecyclerView", "", "onInvisible", "onVisible", "publish", "plugin-finder_release"})
public abstract class f extends e<RecyclerView.l> {
    final String TAG;
    RecyclerView hak;
    public int ptb;
    protected int ptc;
    private final ViewConfiguration tIe;
    protected Rect tIf;
    final int tIg;
    final boolean tIh;
    int tIi;
    int tIj;
    int tIk;
    int tIl;
    int[] tIm;
    final long tIn;
    public final RecyclerView.c tIo;
    private final Runnable tIp;
    final MMHandler tIq;
    private boolean visible;

    private /* synthetic */ f() {
        this(null);
    }

    public f(c cVar) {
        super(cVar);
        this.TAG = "Finder.FinderFeedFlowEventSubscriber";
        ViewConfiguration viewConfiguration = ViewConfiguration.get(MMApplicationContext.getContext());
        p.g(viewConfiguration, "ViewConfiguration.get(MM…tionContext.getContext())");
        this.tIe = viewConfiguration;
        this.tIf = new Rect();
        this.ptb = Integer.MAX_VALUE;
        this.ptc = Integer.MAX_VALUE;
        this.tIg = this.tIe.getScaledTouchSlop();
        com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.thumbplayer.a.a.class);
        p.g(ah, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
        this.tIh = ((com.tencent.mm.plugin.thumbplayer.a.a) ah).isOpenTPPlayerScroll();
        this.tIm = new int[5];
        this.tIn = 500;
        this.tIo = new a(this);
        this.tIp = new RunnableC1107f(this);
        this.tIq = new b(this, Looper.getMainLooper());
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
    public static final class c extends RecyclerView.l {
        final /* synthetic */ f tIr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(f fVar) {
            this.tIr = fVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(243456);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (this.tIr.tIf.isEmpty()) {
                recyclerView.getGlobalVisibleRect(this.tIr.tIf);
            }
            if (this.tIr.tIi != i2) {
                this.tIr.tIj = this.tIr.tIi;
                this.tIr.tIi = i2;
            }
            this.tIr.f(recyclerView, i2);
            if (this.tIr.tIi == 0) {
                f fVar = this.tIr;
                int[] iArr = new int[5];
                p.h(iArr, "<set-?>");
                fVar.tIm = iArr;
                this.tIr.tIl = 0;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(243456);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            RecyclerView.LayoutManager layoutManager;
            double d2;
            AppMethodBeat.i(243457);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            if (this.tIr.tIh && (layoutManager = recyclerView.getLayoutManager()) != null) {
                if (!layoutManager.canScrollHorizontally()) {
                    i2 = i3;
                }
                int abs = Math.abs(i2);
                this.tIr.tIk += abs;
                this.tIr.tIm[this.tIr.tIl] = abs;
                this.tIr.tIl = (this.tIr.tIl + 1) % this.tIr.tIm.length;
                if (this.tIr.tIi == 1) {
                    if (this.tIr.tIk > this.tIr.tIg * 5) {
                        this.tIr.f(recyclerView, 3);
                        this.tIr.tIk = 0;
                    }
                } else if (this.tIr.tIi == 2) {
                    int[] iArr = this.tIr.tIm;
                    p.h(iArr, "$this$average");
                    double d3 = 0.0d;
                    int i4 = 0;
                    for (int i5 : iArr) {
                        d3 += (double) i5;
                        i4++;
                    }
                    if (i4 == 0) {
                        k kVar = k.SYw;
                        d2 = k.hxY();
                    } else {
                        d2 = d3 / ((double) i4);
                    }
                    int[] iArr2 = this.tIr.tIm;
                    double d4 = 0.0d;
                    for (int i6 : iArr2) {
                        d4 += Math.pow(((double) i6) - d2, 2.0d);
                    }
                    double length = d4 / ((double) iArr2.length);
                    if (d2 < 50.0d && length < 50.0d && this.tIr.tIk > this.tIr.tIg * 5) {
                        Log.i(this.tIr.TAG, "publish LOW_SPEED_FLING");
                        this.tIr.f(recyclerView, 8);
                        this.tIr.tIk = 0;
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(243457);
        }
    }

    public final RecyclerView.l dap() {
        return new c(this);
    }

    public final void f(RecyclerView recyclerView, int i2) {
        b g2;
        p.h(recyclerView, "recyclerView");
        String str = this.TAG;
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        if (p.j(mainLooper.getThread(), Thread.currentThread())) {
            long uptimeMillis = SystemClock.uptimeMillis();
            b g3 = g(recyclerView, i2);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            if (uptimeMillis2 >= 50) {
                Log.w(str, "[checkUICost] ".concat(String.valueOf("what are you doing? guy! This operation is so slow in ui thread.[" + uptimeMillis2 + "ms]")));
            }
            g2 = g3;
        } else {
            g2 = g(recyclerView, i2);
        }
        recyclerView.post(new e(this, g2));
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ f tIr;
        final /* synthetic */ b tIt;

        e(f fVar, b bVar) {
            this.tIr = fVar;
            this.tIt = bVar;
        }

        public final void run() {
            AppMethodBeat.i(243461);
            this.tIr.c(this.tIt);
            AppMethodBeat.o(243461);
        }
    }

    public b g(RecyclerView recyclerView, int i2) {
        p.h(recyclerView, "recyclerView");
        return It(i2);
    }

    public b It(int i2) {
        return new b();
    }

    public final void m(RecyclerView recyclerView) {
        p.h(recyclerView, "recyclerView");
        this.hak = recyclerView;
        recyclerView.a(dap());
        recyclerView.a(new d(this, recyclerView));
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter != null && (adapter instanceof WxRecyclerAdapter)) {
            adapter.a(this.tIo);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$onBindRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$OnChildAttachStateChangeListener;", "isFirst", "", "()Z", "setFirst", "(Z)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "plugin-finder_release"})
    public static final class d implements RecyclerView.i {
        private boolean isFirst = true;
        final /* synthetic */ RecyclerView tDJ;
        final /* synthetic */ f tIr;

        d(f fVar, RecyclerView recyclerView) {
            this.tIr = fVar;
            this.tDJ = recyclerView;
        }

        @Override // android.support.v7.widget.RecyclerView.i
        public final void bE(View view) {
            AppMethodBeat.i(243459);
            p.h(view, "view");
            AppMethodBeat.o(243459);
        }

        @Override // android.support.v7.widget.RecyclerView.i
        public final void bD(View view) {
            AppMethodBeat.i(243460);
            p.h(view, "view");
            if (this.isFirst) {
                this.isFirst = false;
                this.tDJ.post(new a(this));
            }
            AppMethodBeat.o(243460);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ d tIs;

            a(d dVar) {
                this.tIs = dVar;
            }

            public final void run() {
                AppMethodBeat.i(243458);
                this.tIs.tIr.dap().onScrollStateChanged(this.tIs.tDJ, 4);
                AppMethodBeat.o(243458);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$adapterDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "plugin-finder_release"})
    public static final class a extends RecyclerView.c {
        final /* synthetic */ f tIr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(f fVar) {
            this.tIr = fVar;
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3) {
            AppMethodBeat.i(243450);
            Log.d(this.tIr.TAG, "onItemRangeChanged " + i2 + ' ' + i3);
            this.tIr.tIq.removeMessages(0);
            this.tIr.tIq.sendEmptyMessageDelayed(1, this.tIr.tIn);
            AppMethodBeat.o(243450);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeInserted(int i2, int i3) {
            AppMethodBeat.i(243451);
            Log.d(this.tIr.TAG, "onItemRangeInserted " + i2 + ' ' + i3);
            this.tIr.tIq.removeMessages(0);
            this.tIr.tIq.sendEmptyMessageDelayed(0, this.tIr.tIn);
            AppMethodBeat.o(243451);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeMoved(int i2, int i3, int i4) {
            AppMethodBeat.i(243452);
            Log.d(this.tIr.TAG, "onItemRangeMoved " + i2 + ' ' + i3 + ' ' + i4);
            this.tIr.tIq.removeMessages(0);
            this.tIr.tIq.sendEmptyMessageDelayed(0, this.tIr.tIn);
            AppMethodBeat.o(243452);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeRemoved(int i2, int i3) {
            AppMethodBeat.i(243453);
            Log.d(this.tIr.TAG, "onItemRangeRemoved " + i2 + ' ' + i3);
            this.tIr.tIq.removeMessages(0);
            this.tIr.tIq.sendEmptyMessageDelayed(0, this.tIr.tIn);
            AppMethodBeat.o(243453);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onChanged() {
            AppMethodBeat.i(243454);
            Log.d(this.tIr.TAG, "onChanged");
            this.tIr.tIq.removeMessages(0);
            this.tIr.tIq.sendEmptyMessageDelayed(0, this.tIr.tIn);
            AppMethodBeat.o(243454);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.finder.event.base.f$f  reason: collision with other inner class name */
    static final class RunnableC1107f implements Runnable {
        final /* synthetic */ f tIr;

        RunnableC1107f(f fVar) {
            this.tIr = fVar;
        }

        public final void run() {
            AppMethodBeat.i(243462);
            RecyclerView recyclerView = this.tIr.hak;
            if (recyclerView != null) {
                this.tIr.f(recyclerView, 5);
                AppMethodBeat.o(243462);
                return;
            }
            AppMethodBeat.o(243462);
        }
    }

    public final void onVisible() {
        Log.i(this.TAG, "onVisible " + this.ptb + ' ' + this.ptc);
        this.visible = true;
        this.ptb = Integer.MAX_VALUE;
        this.ptc = Integer.MAX_VALUE;
        MMHandlerThread.postToMainThreadDelayed(this.tIp, 200);
        RecyclerView recyclerView = this.hak;
        if (recyclerView != null) {
            f(recyclerView, 7);
        }
    }

    public void onInvisible() {
        this.visible = false;
        MMHandlerThread.removeRunnable(this.tIp);
        this.tIq.removeMessages(0);
        RecyclerView recyclerView = this.hak;
        if (recyclerView != null) {
            f(recyclerView, 10);
        }
        Log.i(this.TAG, "onInvisible " + this.ptb + ' ' + this.ptc);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$dataChangeHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder_release"})
    public static final class b extends MMHandler {
        final /* synthetic */ f tIr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(f fVar, Looper looper) {
            super(looper);
            this.tIr = fVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(243455);
            if (message != null) {
                switch (message.what) {
                    case 0:
                        RecyclerView recyclerView = this.tIr.hak;
                        if (recyclerView != null) {
                            this.tIr.f(recyclerView, 5);
                            AppMethodBeat.o(243455);
                            return;
                        }
                        AppMethodBeat.o(243455);
                        return;
                    case 1:
                        RecyclerView recyclerView2 = this.tIr.hak;
                        if (recyclerView2 != null) {
                            this.tIr.f(recyclerView2, 9);
                            AppMethodBeat.o(243455);
                            return;
                        }
                        break;
                }
                AppMethodBeat.o(243455);
                return;
            }
            AppMethodBeat.o(243455);
        }
    }
}
