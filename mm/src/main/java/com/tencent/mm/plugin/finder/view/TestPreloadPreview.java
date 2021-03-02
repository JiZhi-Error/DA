package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.xu;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.c;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0004\u000e\"*-\u0018\u0000 V2\u00020\u0001:\u0004VWXYB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0001\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u00112\b\u0010@\u001a\u0004\u0018\u00010'2\b\u0010A\u001a\u0004\u0018\u00010'2\u0006\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t2\b\u0010D\u001a\u0004\u0018\u00010'2\u0006\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\tH\u0002J(\u0010I\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00150JH\u0002J\u0010\u0010K\u001a\u00020(2\u0006\u0010L\u001a\u00020'H\u0002J\u0010\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020\u0015H\u0002J\u001e\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00142\u0006\u0010B\u001a\u00020\tH\u0002J\b\u0010P\u001a\u00020QH\u0002J8\u0010R\u001a\u00020Q2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00150J2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u00106\u001a\u0002072\b\u0010S\u001a\u0004\u0018\u00010T2\u0006\u00105\u001a\u00020\tH\u0007J\b\u0010U\u001a\u00020QH\u0014J\u0010\u0010:\u001a\u00020'2\u0006\u00109\u001a\u00020\u0011H\u0002R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u0013X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0004¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0004¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u00020-X\u0004¢\u0006\u0004\n\u0002\u0010.R\u000e\u0010/\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018FX\u0002¢\u0006\f\n\u0004\b4\u0010\u001c\u001a\u0004\b2\u00103R\u000e\u00105\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X.¢\u0006\u0002\n\u0000¨\u0006Z"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bufferSet", "Ljava/util/concurrent/ConcurrentHashMap;", "callback", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1;", "centerFeedId", "", "data", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "globalPreloadTv", "Landroid/widget/TextView;", "getGlobalPreloadTv", "()Landroid/widget/TextView;", "globalPreloadTv$delegate", "Lkotlin/Lazy;", "headerCount", "isCreated", "", "isOpenMultiBitRateDownload", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1;", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaCache", "", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "notifyListener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1;", "observer", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1;", "playingIndex", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "tabType", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "buildText", "feedId", "simpleFeedId", "mediaId", "isVideo", "percent", "preloadPercent", "preloadMinSize", "fileFormat", "codingFormat", "position", "size", "hasPlayed", "relatedFeedId", "desc", "isLongVideo", "likeCount", "createDataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "findCacheInfo", "originalMediaId", "getDesc", "feed", "getItem", "notifyChange", "", "onCreate", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "onDetachedFromWindow", "Companion", "Info", "TestAdapter", "TestHolder", "plugin-finder_release"})
public final class TestPreloadPreview extends FrameLayout {
    public static final a wqQ = new a((byte) 0);
    private int dLS;
    private boolean dbG;
    private final MMHandler mainHandler;
    private List<? extends o<? extends bo, ? extends cjl>> qzs;
    private com.tencent.mm.plugin.finder.video.k tCD;
    private long tIC;
    private final boolean uUD;
    private final kotlin.f vau = kotlin.g.ah(new l(this));
    private final ConcurrentHashMap<Integer, Integer> wqH = new ConcurrentHashMap<>();
    private final kotlin.f wqI = kotlin.g.ah(new f(this));
    private int wqJ;
    private final ConcurrentHashMap<String, b> wqK;
    private final e wqL;
    private int wqM;
    private final i wqN;
    private final g wqO;
    private final j wqP;

    static {
        AppMethodBeat.i(255125);
        AppMethodBeat.o(255125);
    }

    public final TextView getGlobalPreloadTv() {
        AppMethodBeat.i(255119);
        TextView textView = (TextView) this.wqI.getValue();
        AppMethodBeat.o(255119);
        return textView;
    }

    public final RecyclerView getRecyclerView() {
        AppMethodBeat.i(255118);
        RecyclerView recyclerView = (RecyclerView) this.vau.getValue();
        AppMethodBeat.o(255118);
        return recyclerView;
    }

    public static final /* synthetic */ List a(TestPreloadPreview testPreloadPreview) {
        AppMethodBeat.i(255126);
        List<? extends o<? extends bo, ? extends cjl>> list = testPreloadPreview.qzs;
        if (list == null) {
            p.btv("data");
        }
        AppMethodBeat.o(255126);
        return list;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TestPreloadPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(255123);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.uUD = com.tencent.mm.plugin.finder.storage.c.dsh();
        setId(R.id.ijo);
        LayoutInflater.from(getContext()).inflate(R.layout.c24, (ViewGroup) this, true);
        final View findViewById = findViewById(R.id.ijn);
        final View findViewById2 = findViewById(R.id.c6m);
        p.g(findViewById2, "expandBtn");
        findViewById2.setTag(Boolean.FALSE);
        getRecyclerView().setLayoutFrozen(true);
        findViewById.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.view.TestPreloadPreview.AnonymousClass1 */
            final /* synthetic */ TestPreloadPreview wqR;

            {
                this.wqR = r1;
            }

            public final void run() {
                AppMethodBeat.i(255089);
                View view = r1;
                p.g(view, "container");
                view.setTranslationY((-((float) this.wqR.getRecyclerView().getHeight())) - ((float) this.wqR.getGlobalPreloadTv().getHeight()));
                AppMethodBeat.o(255089);
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.TestPreloadPreview.AnonymousClass2 */
            final /* synthetic */ TestPreloadPreview wqR;

            {
                this.wqR = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(255093);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                View view2 = r2;
                p.g(view2, "expandBtn");
                if (p.j(view2.getTag(), Boolean.TRUE)) {
                    r1.animate().cancel();
                    r1.animate().translationY((-((float) this.wqR.getRecyclerView().getHeight())) - ((float) this.wqR.getGlobalPreloadTv().getHeight())).setListener(new Animator.AnimatorListener(this) {
                        /* class com.tencent.mm.plugin.finder.view.TestPreloadPreview.AnonymousClass2.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass2 wqT;

                        /* JADX WARN: Incorrect args count in method signature: ()V */
                        {
                            this.wqT = r1;
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(255090);
                            this.wqT.wqR.getRecyclerView().setLayoutFrozen(true);
                            AppMethodBeat.o(255090);
                        }

                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationStart(Animator animator) {
                        }
                    }).setInterpolator(new DecelerateInterpolator(1.6f)).setDuration(220).start();
                    View view3 = r2;
                    p.g(view3, "expandBtn");
                    view3.setTag(Boolean.FALSE);
                } else {
                    r1.animate().cancel();
                    r1.animate().translationY(0.0f).setListener(new Animator.AnimatorListener(this) {
                        /* class com.tencent.mm.plugin.finder.view.TestPreloadPreview.AnonymousClass2.AnonymousClass2 */
                        final /* synthetic */ AnonymousClass2 wqT;

                        /* JADX WARN: Incorrect args count in method signature: ()V */
                        {
                            this.wqT = r1;
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(255091);
                            View view = r1;
                            p.g(view, "container");
                            view.setTranslationY(0.0f);
                            this.wqT.wqR.getRecyclerView().setLayoutFrozen(false);
                            AppMethodBeat.o(255091);
                        }

                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationStart(Animator animator) {
                        }
                    }).setInterpolator(new DecelerateInterpolator(1.6f)).setDuration(220).start();
                    this.wqR.mainHandler.postDelayed(new Runnable(this) {
                        /* class com.tencent.mm.plugin.finder.view.TestPreloadPreview.AnonymousClass2.AnonymousClass3 */
                        final /* synthetic */ AnonymousClass2 wqT;

                        {
                            this.wqT = r1;
                        }

                        public final void run() {
                            boolean z;
                            AppMethodBeat.i(255092);
                            Iterator it = TestPreloadPreview.a(this.wqT.wqR).iterator();
                            int i2 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i2 = -1;
                                    break;
                                }
                                if (((o) it.next()).first.lT() == this.wqT.wqR.tIC) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    break;
                                }
                                i2++;
                            }
                            RecyclerView.LayoutManager layoutManager = this.wqT.wqR.getRecyclerView().getLayoutManager();
                            if (layoutManager == null) {
                                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                                AppMethodBeat.o(255092);
                                throw tVar;
                            }
                            ((LinearLayoutManager) layoutManager).ah(Math.max(0, i2), 0);
                            AppMethodBeat.o(255092);
                        }
                    }, 20);
                    View view4 = r2;
                    p.g(view4, "expandBtn");
                    view4.setTag(Boolean.TRUE);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(255093);
            }
        });
        this.wqK = new ConcurrentHashMap<>();
        this.wqL = new e(this);
        this.wqM = -1;
        this.mainHandler = new MMHandler(Looper.getMainLooper());
        this.wqN = new i(this);
        this.wqO = new g(this);
        this.wqP = new j(this);
        AppMethodBeat.o(255123);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TestPreloadPreview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(255124);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.uUD = com.tencent.mm.plugin.finder.storage.c.dsh();
        setId(R.id.ijo);
        LayoutInflater.from(getContext()).inflate(R.layout.c24, (ViewGroup) this, true);
        final View findViewById = findViewById(R.id.ijn);
        final View findViewById2 = findViewById(R.id.c6m);
        p.g(findViewById2, "expandBtn");
        findViewById2.setTag(Boolean.FALSE);
        getRecyclerView().setLayoutFrozen(true);
        findViewById.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.view.TestPreloadPreview.AnonymousClass1 */
            final /* synthetic */ TestPreloadPreview wqR;

            {
                this.wqR = r1;
            }

            public final void run() {
                AppMethodBeat.i(255089);
                View view = findViewById;
                p.g(view, "container");
                view.setTranslationY((-((float) this.wqR.getRecyclerView().getHeight())) - ((float) this.wqR.getGlobalPreloadTv().getHeight()));
                AppMethodBeat.o(255089);
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.TestPreloadPreview.AnonymousClass2 */
            final /* synthetic */ TestPreloadPreview wqR;

            {
                this.wqR = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(255093);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                View view2 = findViewById2;
                p.g(view2, "expandBtn");
                if (p.j(view2.getTag(), Boolean.TRUE)) {
                    findViewById.animate().cancel();
                    findViewById.animate().translationY((-((float) this.wqR.getRecyclerView().getHeight())) - ((float) this.wqR.getGlobalPreloadTv().getHeight())).setListener(new Animator.AnimatorListener(this) {
                        /* class com.tencent.mm.plugin.finder.view.TestPreloadPreview.AnonymousClass2.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass2 wqT;

                        /* JADX WARN: Incorrect args count in method signature: ()V */
                        {
                            this.wqT = r1;
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(255090);
                            this.wqT.wqR.getRecyclerView().setLayoutFrozen(true);
                            AppMethodBeat.o(255090);
                        }

                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationStart(Animator animator) {
                        }
                    }).setInterpolator(new DecelerateInterpolator(1.6f)).setDuration(220).start();
                    View view3 = findViewById2;
                    p.g(view3, "expandBtn");
                    view3.setTag(Boolean.FALSE);
                } else {
                    findViewById.animate().cancel();
                    findViewById.animate().translationY(0.0f).setListener(new Animator.AnimatorListener(this) {
                        /* class com.tencent.mm.plugin.finder.view.TestPreloadPreview.AnonymousClass2.AnonymousClass2 */
                        final /* synthetic */ AnonymousClass2 wqT;

                        /* JADX WARN: Incorrect args count in method signature: ()V */
                        {
                            this.wqT = r1;
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(255091);
                            View view = findViewById;
                            p.g(view, "container");
                            view.setTranslationY(0.0f);
                            this.wqT.wqR.getRecyclerView().setLayoutFrozen(false);
                            AppMethodBeat.o(255091);
                        }

                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationStart(Animator animator) {
                        }
                    }).setInterpolator(new DecelerateInterpolator(1.6f)).setDuration(220).start();
                    this.wqR.mainHandler.postDelayed(new Runnable(this) {
                        /* class com.tencent.mm.plugin.finder.view.TestPreloadPreview.AnonymousClass2.AnonymousClass3 */
                        final /* synthetic */ AnonymousClass2 wqT;

                        {
                            this.wqT = r1;
                        }

                        public final void run() {
                            boolean z;
                            AppMethodBeat.i(255092);
                            Iterator it = TestPreloadPreview.a(this.wqT.wqR).iterator();
                            int i2 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i2 = -1;
                                    break;
                                }
                                if (((o) it.next()).first.lT() == this.wqT.wqR.tIC) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    break;
                                }
                                i2++;
                            }
                            RecyclerView.LayoutManager layoutManager = this.wqT.wqR.getRecyclerView().getLayoutManager();
                            if (layoutManager == null) {
                                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                                AppMethodBeat.o(255092);
                                throw tVar;
                            }
                            ((LinearLayoutManager) layoutManager).ah(Math.max(0, i2), 0);
                            AppMethodBeat.o(255092);
                        }
                    }, 20);
                    View view4 = findViewById2;
                    p.g(view4, "expandBtn");
                    view4.setTag(Boolean.TRUE);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(255093);
            }
        });
        this.wqK = new ConcurrentHashMap<>();
        this.wqL = new e(this);
        this.wqM = -1;
        this.mainHandler = new MMHandler(Looper.getMainLooper());
        this.wqN = new i(this);
        this.wqO = new g(this);
        this.wqP = new j(this);
        AppMethodBeat.o(255124);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static List<o<bo, cjl>> a(DataBuffer<bo> dataBuffer) {
        BaseFinderFeed baseFinderFeed;
        FinderItem finderItem;
        LinkedList<cjl> mediaList;
        cjl cjl;
        AppMethodBeat.i(255120);
        LinkedList linkedList = new LinkedList();
        for (bo boVar : dataBuffer) {
            if (boVar instanceof BaseFinderFeed) {
                FeedData.a aVar = FeedData.Companion;
                cjl cjl2 = (cjl) kotlin.a.j.kt(FeedData.a.s((BaseFinderFeed) boVar).getMediaList());
                if (cjl2 != null) {
                    linkedList.add(new o(boVar, cjl2));
                }
            } else if (boVar instanceof bm) {
                cjl cjl3 = (cjl) kotlin.a.j.kt(((bm) boVar).dkV());
                if (cjl3 != null) {
                    linkedList.add(new o(boVar, cjl3));
                }
            } else if (!(!(boVar instanceof ag) || (baseFinderFeed = (BaseFinderFeed) kotlin.a.j.kt(((ag) boVar).rvFeedList)) == null || (finderItem = baseFinderFeed.feedObject) == null || (mediaList = finderItem.getMediaList()) == null || (cjl = (cjl) kotlin.a.j.kt(mediaList)) == null)) {
                linkedList.add(new o(boVar, cjl));
            }
        }
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(255120);
        return linkedList2;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void a(DataBuffer<bo> dataBuffer, int i2, com.tencent.mm.plugin.finder.video.k kVar, com.tencent.mm.plugin.finder.event.base.c cVar, int i3) {
        AppMethodBeat.i(255121);
        p.h(dataBuffer, "data");
        p.h(kVar, "videoCore");
        this.dbG = true;
        this.qzs = a(dataBuffer);
        this.dLS = i3;
        this.tCD = kVar;
        this.wqJ = i2;
        RecyclerView recyclerView = getRecyclerView();
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        c cVar2 = new c();
        cVar2.au(true);
        getRecyclerView().setAdapter(cVar2);
        getRecyclerView().setHasFixedSize(true);
        if (cVar != null) {
            cVar.a(this.wqP);
        }
        this.wqO.alive();
        this.wqN.alive();
        MediaPreloadCore mediaPreloadCore = kVar.weU;
        if (mediaPreloadCore != null) {
            mediaPreloadCore.a(this.wqL);
        }
        getRecyclerView().setOnTouchListener(new k(this));
        AppMethodBeat.o(255121);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    public static final class k implements View.OnTouchListener {
        final /* synthetic */ TestPreloadPreview wqR;

        k(TestPreloadPreview testPreloadPreview) {
            this.wqR = testPreloadPreview;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(255116);
            p.g(motionEvent, "event");
            if (motionEvent.getAction() == 0) {
                this.wqR.mainHandler.removeCallbacksAndMessages(null);
            } else if (motionEvent.getAction() == 1) {
                this.wqR.mainHandler.removeCallbacksAndMessages(null);
                this.wqR.mainHandler.postDelayed(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.view.TestPreloadPreview.k.AnonymousClass1 */
                    final /* synthetic */ k wqY;

                    {
                        this.wqY = r1;
                    }

                    public final void run() {
                        boolean z;
                        AppMethodBeat.i(255115);
                        Iterator it = TestPreloadPreview.a(this.wqY.wqR).iterator();
                        int i2 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                                break;
                            }
                            if (((o) it.next()).first.lT() == this.wqY.wqR.tIC) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                break;
                            }
                            i2++;
                        }
                        RecyclerView.LayoutManager layoutManager = this.wqY.wqR.getRecyclerView().getLayoutManager();
                        if (layoutManager == null) {
                            t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                            AppMethodBeat.o(255115);
                            throw tVar;
                        }
                        ((LinearLayoutManager) layoutManager).ah(Math.max(0, i2), 0);
                        AppMethodBeat.o(255115);
                    }
                }, 3000);
            }
            AppMethodBeat.o(255116);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestHolder;", "(Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;)V", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "plugin-finder_release"})
    public final class c extends RecyclerView.a<d> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ d a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(255094);
            p.h(viewGroup, "p0");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c22, viewGroup, false);
            p.g(inflate, "LayoutInflater.from(p0.c…oad_item_view, p0, false)");
            d dVar = new d(inflate);
            AppMethodBeat.o(255094);
            return dVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(d dVar, int i2) {
            boolean z;
            CharSequence charSequence;
            long j2;
            String str;
            String str2;
            int i3;
            String str3;
            int i4;
            AppMethodBeat.i(255097);
            d dVar2 = dVar;
            p.h(dVar2, "holder");
            o a2 = TestPreloadPreview.a(TestPreloadPreview.this, i2);
            if (a2 == null) {
                TextView textView = dVar2.wqV;
                p.g(textView, "holder.mediaIdTv");
                textView.setText("unknown");
                AppMethodBeat.o(255097);
                return;
            }
            A a3 = a2.first;
            String Gy = TestPreloadPreview.Gy(a3.lT());
            B b2 = a2.second;
            String str4 = b2.mediaId;
            if (str4 == null || str4.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                TextView textView2 = dVar2.wqV;
                p.g(textView2, "holder.mediaIdTv");
                textView2.setText("unknown feedType(" + a3.cxn() + ')');
                AppMethodBeat.o(255097);
                return;
            }
            ConcurrentHashMap concurrentHashMap = TestPreloadPreview.this.wqK;
            String str5 = b2.mediaId;
            if (str5 == null) {
                str5 = "";
            }
            b bVar = (b) concurrentHashMap.get(str5);
            TextView textView3 = dVar2.wqV;
            p.g(textView3, "holder.mediaIdTv");
            TestPreloadPreview testPreloadPreview = TestPreloadPreview.this;
            long lT = a3.lT();
            String str6 = b2.mediaId;
            if (str6 != null) {
                String str7 = b2.mediaId;
                charSequence = str6.subSequence(0, kotlin.k.j.na(5, str7 != null ? str7.length() : 0));
            } else {
                charSequence = null;
            }
            String valueOf = String.valueOf(charSequence);
            boolean z2 = b2.mediaType == 4;
            int max = Math.max(bVar != null ? bVar.percent : 0, bVar != null ? bVar.dHn() : 0);
            int dHn = bVar != null ? bVar.dHn() : 0;
            if (bVar != null) {
                j2 = bVar.preloadMinSize;
            } else {
                j2 = 0;
            }
            if (bVar != null) {
                str = bVar.dVY;
            } else {
                str = null;
            }
            if (bVar != null) {
                str2 = bVar.uUI;
            } else {
                str2 = null;
            }
            if (bVar != null) {
                i3 = bVar.size;
            } else {
                i3 = 0;
            }
            if (bVar != null) {
                str3 = bVar.wqU;
            } else {
                str3 = null;
            }
            textView3.setText(TestPreloadPreview.a(testPreloadPreview, lT, Gy, valueOf, z2, max, dHn, j2, str, str2, i2, i3, str3, a3.lT(), TestPreloadPreview.d((bo) a3), a3 instanceof BaseFinderFeed ? a3.feedObject.isLongVideo() : false, a3 instanceof BaseFinderFeed ? a3.feedObject.getLikeCount() : 0));
            if (bVar != null) {
                i4 = bVar.state;
            } else {
                i4 = 0;
            }
            if (TestPreloadPreview.this.tIC == a3.lT()) {
                TextView textView4 = dVar2.wqV;
                Context context = TestPreloadPreview.this.getContext();
                p.g(context, "context");
                textView4.setTextColor(context.getResources().getColor(R.color.Red));
                AppMethodBeat.o(255097);
            } else if (i4 >= 2) {
                TextView textView5 = dVar2.wqV;
                Context context2 = TestPreloadPreview.this.getContext();
                p.g(context2, "context");
                textView5.setTextColor(context2.getResources().getColor(R.color.Green));
                AppMethodBeat.o(255097);
            } else {
                TextView textView6 = dVar2.wqV;
                Context context3 = TestPreloadPreview.this.getContext();
                p.g(context3, "context");
                textView6.setTextColor(context3.getResources().getColor(R.color.am));
                AppMethodBeat.o(255097);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(255095);
            int size = TestPreloadPreview.a(TestPreloadPreview.this).size();
            AppMethodBeat.o(255095);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final long getItemId(int i2) {
            A a2;
            AppMethodBeat.i(255096);
            o a3 = TestPreloadPreview.a(TestPreloadPreview.this, i2);
            if (a3 == null || (a2 = a3.first) == null) {
                AppMethodBeat.o(255096);
                return 0;
            }
            long lT = a2.lT();
            AppMethodBeat.o(255096);
            return lT;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mediaIdTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getMediaIdTv", "()Landroid/widget/TextView;", "plugin-finder_release"})
    public static final class d extends RecyclerView.v {
        final TextView wqV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(255098);
            this.wqV = (TextView) view.findViewById(R.id.fbo);
            AppMethodBeat.o(255098);
        }
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> concurrentLinkedQueue;
        AppMethodBeat.i(255122);
        super.onDetachedFromWindow();
        if (this.dbG) {
            this.wqO.dead();
            this.wqN.dead();
            com.tencent.mm.plugin.finder.video.k kVar = this.tCD;
            if (kVar == null) {
                p.btv("videoCore");
            }
            MediaPreloadCore mediaPreloadCore = kVar.weU;
            if (mediaPreloadCore != null) {
                e eVar = this.wqL;
                p.h(eVar, "callback");
                com.tencent.mm.plugin.finder.preload.worker.b bVar = mediaPreloadCore.uTQ;
                if (!(bVar == null || (concurrentLinkedQueue = bVar.uVL) == null)) {
                    kotlin.a.j.a((Iterable) concurrentLinkedQueue, (kotlin.g.a.b) new MediaPreloadCore.e(eVar));
                }
            }
            this.dbG = false;
        }
        AppMethodBeat.o(255122);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u00108FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010!\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "", "()V", "codingFormat", "", "getCodingFormat", "()Ljava/lang/String;", "setCodingFormat", "(Ljava/lang/String;)V", "fileFormat", "getFileFormat", "setFileFormat", "hasPlayed", "getHasPlayed", "setHasPlayed", "percent", "", "getPercent", "()I", "setPercent", "(I)V", "preloadMinSize", "", "getPreloadMinSize", "()J", "setPreloadMinSize", "(J)V", "preloadPercent", "getPreloadPercent", "setPreloadPercent", "size", "getSize", "setSize", "state", "getState", "setState", "plugin-finder_release"})
    public static final class b {
        String dVY;
        int gqZ;
        int percent;
        long preloadMinSize;
        int size;
        int state;
        String uUI;
        String wqU;

        public final int dHn() {
            return this.gqZ == 0 ? this.percent : this.gqZ;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J8\u0010\f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J(\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0017"}, hxF = {"com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getOriginalMediaId", "", "mediaId", "onCancel", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"})
    public static final class e implements com.tencent.mm.plugin.finder.preload.b {
        final /* synthetic */ TestPreloadPreview wqR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(TestPreloadPreview testPreloadPreview) {
            this.wqR = testPreloadPreview;
        }

        private static String awS(String str) {
            int i2;
            boolean z;
            AppMethodBeat.i(255099);
            String j2 = n.j(str, "finder_video_", "", false);
            String str2 = j2;
            int length = str2.length();
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i2 = -1;
                    break;
                }
                if (str2.charAt(i3) == '_') {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 >= 0) {
                String obj = j2.subSequence(i2 + 1, j2.length()).toString();
                AppMethodBeat.o(255099);
                return obj;
            }
            AppMethodBeat.o(255099);
            return str;
        }

        @Override // com.tencent.mm.plugin.finder.preload.b
        public final void a(String str, int i2, String str2, String str3, com.tencent.mm.plugin.finder.preload.c cVar) {
            AppMethodBeat.i(255100);
            p.h(str, "mediaId");
            p.h(str2, "fileFormat");
            p.h(str3, "codingFormat");
            p.h(cVar, "task");
            b a2 = TestPreloadPreview.a(this.wqR, awS(str));
            a2.gqZ = i2;
            a2.state = 2;
            a2.uUI = str3;
            a2.dVY = str2;
            a2.preloadMinSize = cVar.preloadMinSize;
            TestPreloadPreview.g(this.wqR);
            AppMethodBeat.o(255100);
        }

        @Override // com.tencent.mm.plugin.finder.preload.b
        public final void dx(String str, int i2) {
            AppMethodBeat.i(255101);
            p.h(str, "mediaId");
            b a2 = TestPreloadPreview.a(this.wqR, awS(str));
            a2.gqZ = i2;
            a2.state = 2;
            TestPreloadPreview.g(this.wqR);
            AppMethodBeat.o(255101);
        }

        @Override // com.tencent.mm.plugin.finder.preload.b
        public final void a(String str, boolean z, int i2, com.tencent.mm.plugin.finder.preload.c cVar) {
            AppMethodBeat.i(255102);
            p.h(str, "mediaId");
            p.h(cVar, "task");
            b a2 = TestPreloadPreview.a(this.wqR, awS(str));
            a2.preloadMinSize = cVar.preloadMinSize;
            a2.gqZ = i2;
            a2.state = 3;
            TestPreloadPreview.g(this.wqR);
            AppMethodBeat.o(255102);
        }

        @Override // com.tencent.mm.plugin.finder.preload.b
        public final void a(String str, String str2, com.tencent.mm.plugin.finder.preload.c cVar) {
            AppMethodBeat.i(255103);
            p.h(str, "mediaId");
            p.h(str2, "msg");
            p.h(cVar, "task");
            AppMethodBeat.o(255103);
        }

        @Override // com.tencent.mm.plugin.finder.preload.b
        public final void aum(String str) {
            AppMethodBeat.i(255104);
            p.h(str, "mediaId");
            AppMethodBeat.o(255104);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/TestPreloadPreviewNotifyEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class i extends IListener<xu> {
        final /* synthetic */ TestPreloadPreview wqR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(TestPreloadPreview testPreloadPreview) {
            this.wqR = testPreloadPreview;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xu xuVar) {
            AppMethodBeat.i(255109);
            xu xuVar2 = xuVar;
            p.h(xuVar2, "event");
            this.wqR.wqH.put(Integer.valueOf(xuVar2.eee.dLS), Integer.valueOf(xuVar2.eee.eef));
            TestPreloadPreview.g(this.wqR);
            AppMethodBeat.o(255109);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/PreloadProcessChangeEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class g extends IListener<pw> {
        final /* synthetic */ TestPreloadPreview wqR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(TestPreloadPreview testPreloadPreview) {
            this.wqR = testPreloadPreview;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pw pwVar) {
            int i2;
            AppMethodBeat.i(255106);
            pw pwVar2 = pwVar;
            p.h(pwVar2, "event");
            String str = pwVar2.dVW.mediaId;
            if (str != null) {
                b a2 = TestPreloadPreview.a(this.wqR, str);
                if (pwVar2.dVW.type == 2) {
                    a2.size = pwVar2.dVW.size;
                } else {
                    a2.percent = pwVar2.dVW.process;
                    a2.state = 1;
                    a2.dVY = pwVar2.dVW.dVY;
                    a2.wqU = String.valueOf(pwVar2.dVW.dVX);
                    TestPreloadPreview testPreloadPreview = this.wqR;
                    int i3 = 0;
                    Iterator it = TestPreloadPreview.a(this.wqR).iterator();
                    while (true) {
                        i2 = i3;
                        if (!it.hasNext()) {
                            i2 = -1;
                            break;
                        } else if (p.j(((o) it.next()).second.mediaId, pwVar2.dVW.mediaId)) {
                            break;
                        } else {
                            i3 = i2 + 1;
                        }
                    }
                    testPreloadPreview.wqM = i2;
                }
                TestPreloadPreview.g(this.wqR);
            }
            AppMethodBeat.o(255106);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ TestPreloadPreview wqR;

        h(TestPreloadPreview testPreloadPreview) {
            this.wqR = testPreloadPreview;
        }

        public final void run() {
            AppMethodBeat.i(255108);
            int recentAverageSpeed = CdnLogic.getRecentAverageSpeed(2);
            com.tencent.mm.plugin.finder.preload.model.a mediaPreloadModel = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel();
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class);
            p.g(viewModel, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
            final String str = recentAverageSpeed + "kb/s | " + mediaPreloadModel.uUu + ':' + mediaPreloadModel.uUt + ':' + mediaPreloadModel.uUm + ':' + mediaPreloadModel.uUn + ':' + mediaPreloadModel.uUq + " | video=" + FinderVideoRecycler.a((FinderVideoRecycler) viewModel) + " | buf=" + ((Integer) this.wqR.wqH.get(Integer.valueOf(this.wqR.dLS)));
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.view.TestPreloadPreview.h.AnonymousClass1 */
                final /* synthetic */ h wqW;

                {
                    this.wqW = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(255107);
                    this.wqW.wqR.getGlobalPreloadTv().setText(str);
                    RecyclerView.a adapter = this.wqW.wqR.getRecyclerView().getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(255107);
                    return xVar;
                }
            });
            AppMethodBeat.o(255108);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
    public static final class j extends com.tencent.mm.plugin.finder.event.base.d {
        final /* synthetic */ TestPreloadPreview wqR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(TestPreloadPreview testPreloadPreview) {
            this.wqR = testPreloadPreview;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
            AppMethodBeat.i(255113);
            p.h(bVar, "ev");
            if (bVar instanceof com.tencent.mm.plugin.finder.event.base.a) {
                com.tencent.mm.ac.d.h(new a(this));
                AppMethodBeat.o(255113);
            } else if (bVar instanceof com.tencent.mm.plugin.finder.event.base.h) {
                com.tencent.mm.ac.d.h(new b(this, bVar));
                AppMethodBeat.o(255113);
            } else {
                if (bVar instanceof c.a) {
                    com.tencent.mm.ac.d.h(new c(this, bVar));
                }
                AppMethodBeat.o(255113);
            }
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean cZD() {
            return true;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
            AppMethodBeat.i(255114);
            p.h(cVar, "dispatcher");
            p.h(bVar, "event");
            if (bVar instanceof com.tencent.mm.plugin.finder.event.base.h) {
                if (((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 0) {
                    AppMethodBeat.o(255114);
                    return true;
                }
                AppMethodBeat.o(255114);
                return false;
            } else if (bVar instanceof com.tencent.mm.plugin.finder.event.base.a) {
                AppMethodBeat.o(255114);
                return true;
            } else if (!(bVar instanceof c.a)) {
                AppMethodBeat.o(255114);
                return false;
            } else if (((c.a) bVar).type == 1) {
                AppMethodBeat.o(255114);
                return true;
            } else {
                AppMethodBeat.o(255114);
                return false;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ j wqX;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(j jVar) {
                super(0);
                this.wqX = jVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(255110);
                RecyclerView.a adapter = this.wqX.wqR.getRecyclerView().getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(255110);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ com.tencent.mm.plugin.finder.event.base.b tCk;
            final /* synthetic */ j wqX;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(j jVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
                super(0);
                this.wqX = jVar;
                this.tCk = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(255111);
                this.wqX.wqR.tIC = ((com.tencent.mm.plugin.finder.event.base.h) this.tCk).tIC;
                TestPreloadPreview.g(this.wqX.wqR);
                x xVar = x.SXb;
                AppMethodBeat.o(255111);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ com.tencent.mm.plugin.finder.event.base.b tCk;
            final /* synthetic */ j wqX;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(j jVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
                super(0);
                this.wqX = jVar;
                this.tCk = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(255112);
                if (((c.a) this.tCk).type == 1) {
                    TestPreloadPreview.g(this.wqX.wqR);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(255112);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l extends q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ TestPreloadPreview wqR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(TestPreloadPreview testPreloadPreview) {
            super(0);
            this.wqR = testPreloadPreview;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(255117);
            RecyclerView recyclerView = (RecyclerView) this.wqR.findViewById(R.id.gg_);
            AppMethodBeat.o(255117);
            return recyclerView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ TestPreloadPreview wqR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(TestPreloadPreview testPreloadPreview) {
            super(0);
            this.wqR = testPreloadPreview;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(255105);
            TextView textView = (TextView) this.wqR.findViewById(R.id.dkb);
            AppMethodBeat.o(255105);
            return textView;
        }
    }

    public static final /* synthetic */ o a(TestPreloadPreview testPreloadPreview, int i2) {
        AppMethodBeat.i(255127);
        List<? extends o<? extends bo, ? extends cjl>> list = testPreloadPreview.qzs;
        if (list == null) {
            p.btv("data");
        }
        o oVar = (o) kotlin.a.j.L(list, i2);
        AppMethodBeat.o(255127);
        return oVar;
    }

    public static final /* synthetic */ String Gy(long j2) {
        AppMethodBeat.i(255128);
        String zs = com.tencent.mm.ac.d.zs(j2);
        String obj = zs.subSequence(Math.max(0, zs.length() - 4), zs.length()).toString();
        AppMethodBeat.o(255128);
        return obj;
    }

    public static final /* synthetic */ String a(TestPreloadPreview testPreloadPreview, long j2, String str, String str2, boolean z, int i2, int i3, long j3, String str3, String str4, int i4, int i5, String str5, long j4, String str6, boolean z2, int i6) {
        AppMethodBeat.i(255129);
        StringBuilder sb = new StringBuilder();
        if (j4 != 0) {
            sb.append("> ");
        }
        if (z2) {
            sb.append("[LV-" + i4 + '#' + str + "] ");
        } else if (z) {
            sb.append("[V-" + i4 + '#' + str + "] ");
        } else {
            sb.append("[P-" + i4 + '#' + str + "] ");
        }
        sb.append(str2 + ' ');
        if (testPreloadPreview.uUD && str3 != null) {
            sb.append(str3);
        }
        if (!testPreloadPreview.uUD && str4 != null) {
            sb.append(" ".concat(String.valueOf(str4)));
        }
        if (z) {
            sb.append(" " + i2 + "% (" + i3 + "%:" + Util.getSizeKB(j3) + ") ");
            if (testPreloadPreview.tIC == j2) {
                sb.append(String.valueOf(str5));
            }
        } else {
            p.g(sb.append("size=" + Util.getSizeKB((long) i5)), "ss.append(\"size=${Util.getSizeKB(size.toLong())}\")");
        }
        sb.append(" " + str6 + ' ' + i6);
        String sb2 = sb.toString();
        p.g(sb2, "ss.toString()");
        AppMethodBeat.o(255129);
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
        if (r0 == null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bc, code lost:
        if (r0 == null) goto L_0x00be;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.String d(com.tencent.mm.plugin.finder.model.bo r5) {
        /*
        // Method dump skipped, instructions count: 206
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.view.TestPreloadPreview.d(com.tencent.mm.plugin.finder.model.bo):java.lang.String");
    }

    public static final /* synthetic */ b a(TestPreloadPreview testPreloadPreview, String str) {
        AppMethodBeat.i(255131);
        b bVar = testPreloadPreview.wqK.get(str);
        if (bVar == null) {
            b bVar2 = new b();
            testPreloadPreview.wqK.put(str, bVar2);
            bVar = bVar2;
        }
        AppMethodBeat.o(255131);
        return bVar;
    }

    public static final /* synthetic */ void g(TestPreloadPreview testPreloadPreview) {
        AppMethodBeat.i(255132);
        com.tencent.f.h.RTc.aX(new h(testPreloadPreview));
        AppMethodBeat.o(255132);
    }
}
