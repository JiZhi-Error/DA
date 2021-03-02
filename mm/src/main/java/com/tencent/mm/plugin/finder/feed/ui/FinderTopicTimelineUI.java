package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0015\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\tH\u0014J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020'H\u0014J\b\u0010)\u001a\u00020'H\u0014J\b\u0010*\u001a\u00020'H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "()V", "TAG", "", "commentScene", "", "feedLoader", "finderHotTopicBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getFinderHotTopicBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setFinderHotTopicBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "followID", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "onHellScrollerListener", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1;", "presenter", "scene", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "topic", "topicId", "", "type", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class FinderTopicTimelineUI extends FinderLoaderFeedUI<FinderTopicTimelineUIContract.Loader, FinderTopicTimelineUIContract.d, FinderTopicTimelineUIContract.b> {
    private final String TAG = "Finder.FinderTopicTimelineUI";
    private HashMap _$_findViewCache;
    private String dST = "";
    private axt location;
    private final int scene = 2;
    private final int tCE = 9;
    private bcc tvs;
    private long twp;
    private int type;
    private FinderTopicTimelineUIContract.d udA;
    private FinderTopicTimelineUIContract.Loader udB;
    private com.tencent.mm.bw.b udC;
    private String udD;
    private final c udE = new c(this);
    private FinderTopicTimelineUIContract.b udz;

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245605);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245605);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245604);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245604);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderTopicTimelineUI() {
        AppMethodBeat.i(245602);
        AppMethodBeat.o(245602);
    }

    public static final /* synthetic */ FinderTopicTimelineUIContract.d a(FinderTopicTimelineUI finderTopicTimelineUI) {
        AppMethodBeat.i(166288);
        FinderTopicTimelineUIContract.d dVar = finderTopicTimelineUI.udA;
        if (dVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(166288);
        return dVar;
    }

    public static final /* synthetic */ FinderTopicTimelineUIContract.Loader b(FinderTopicTimelineUI finderTopicTimelineUI) {
        AppMethodBeat.i(245603);
        FinderTopicTimelineUIContract.Loader loader = finderTopicTimelineUI.udB;
        if (loader == null) {
            p.btv("feedLoader");
        }
        AppMethodBeat.o(245603);
        return loader;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final void initOnCreate() {
        AppMethodBeat.i(166284);
        this.type = getIntent().getIntExtra("key_topic_type", 1);
        String stringExtra = getIntent().getStringExtra("key_topic_title");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.dST = stringExtra;
        this.twp = getIntent().getLongExtra("KEY_TOPIC_ID", 0);
        this.udD = getIntent().getStringExtra("KEY_FOLLOW_ID");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("KEY_HOT_TOPIC_BUFFER");
        if (byteArrayExtra != null) {
            this.udC = new com.tencent.mm.bw.b(byteArrayExtra);
        }
        switch (this.type) {
            case 1:
                setMMTitle("#" + this.dST);
                break;
            case 7:
                setMMTitle("");
                break;
            default:
                setMMTitle(String.valueOf(this.dST));
                break;
        }
        this.location = new axt();
        byte[] byteArrayExtra2 = getIntent().getByteArrayExtra("KEY_FINDER_LOCATION");
        if (byteArrayExtra2 != null) {
            axt axt = this.location;
            if (axt == null) {
                p.btv(FirebaseAnalytics.b.LOCATION);
            }
            axt.parseFrom(byteArrayExtra2);
        }
        bcc bcc = new bcc();
        try {
            bcc.parseFrom(getIntent().getByteArrayExtra("KEY_SECTION_INFO"));
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            bcc = null;
        }
        this.tvs = bcc;
        Log.i(this.TAG, "type:" + this.type + ", topic:" + this.dST + ',');
        this.udz = new FinderTopicTimelineUIContract.b(this, this.scene, this.type);
        FinderTopicTimelineUI finderTopicTimelineUI = this;
        FinderTopicTimelineUIContract.b bVar = this.udz;
        if (bVar == null) {
            p.btv("presenter");
        }
        this.udA = new FinderTopicTimelineUIContract.d(finderTopicTimelineUI, bVar, this.scene, this.tCE);
        int i2 = this.type;
        String str = this.dST;
        long j2 = this.twp;
        axt axt2 = this.location;
        if (axt2 == null) {
            p.btv(FirebaseAnalytics.b.LOCATION);
        }
        e eVar = e.FEED_TOPIC_TIMELINE;
        bcc bcc2 = this.tvs;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderTopicTimelineUIContract.Loader loader = new FinderTopicTimelineUIContract.Loader(i2, str, j2, axt2, eVar, bcc2, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx());
        Intent intent = getIntent();
        p.g(intent, "intent");
        loader.initFromCache(intent);
        loader.groupId = this.udD;
        loader.setInitDone(new a(loader, this));
        loader.refObjectId = getIntent().getLongExtra("key_ref_object_id", 0);
        loader.tTS = new b(this);
        if (loader.type == 7) {
            loader.twd = getIntent().getLongExtra("key_activity_id", 0);
            loader.tTH = getIntent().getIntExtra("key_activity_inner_tab_type", 1);
        }
        loader.tTR = this.udC;
        this.udB = loader;
        FinderTopicTimelineUIContract.d dVar = this.udA;
        if (dVar == null) {
            p.btv("viewCallback");
        }
        dVar.tLS.getRecyclerView().a(this.udE);
        AppMethodBeat.o(166284);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$initOnCreate$3$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a implements h {
        final /* synthetic */ FinderTopicTimelineUIContract.Loader udF;
        final /* synthetic */ FinderTopicTimelineUI udG;

        a(FinderTopicTimelineUIContract.Loader loader, FinderTopicTimelineUI finderTopicTimelineUI) {
            this.udF = loader;
            this.udG = finderTopicTimelineUI;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            com.tencent.mm.plugin.finder.feed.model.a aVar;
            AppMethodBeat.i(245595);
            RecyclerView.LayoutManager layoutManager = FinderTopicTimelineUI.a(this.udG).tLS.getRecyclerView().getLayoutManager();
            if (layoutManager != null) {
                if (layoutManager == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                    AppMethodBeat.o(245595);
                    throw tVar;
                }
                ((FinderLinearLayoutManager) layoutManager).ah(this.udF.getInitPos(), 0);
            }
            com.tencent.mm.plugin.finder.feed.model.h cache = this.udF.getCache();
            if (cache != null) {
                aVar = cache.tXU;
            } else {
                aVar = null;
            }
            if (aVar instanceof FinderTopicTimelineUIContract.c) {
                FinderTopicTimelineUI.b(this.udG).tTT = ((FinderTopicTimelineUIContract.c) aVar).tUb;
            }
            AppMethodBeat.o(245595);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(178307);
        FinderTopicTimelineUIContract.d dVar = this.udA;
        if (dVar == null) {
            p.btv("viewCallback");
        }
        dVar.tLS.getRecyclerView().b(this.udE);
        super.onDestroy();
        AppMethodBeat.o(178307);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.akw;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(245599);
        int intExtra = getIntent().getIntExtra("key_topic_type", 1);
        if (intExtra == 1) {
            AppMethodBeat.o(245599);
            return 9;
        } else if (intExtra == 4) {
            AppMethodBeat.o(245599);
            return 52;
        } else if (intExtra == 5) {
            AppMethodBeat.o(245599);
            return 64;
        } else if (intExtra == 7) {
            AppMethodBeat.o(245599);
            return 60;
        } else {
            AppMethodBeat.o(245599);
            return 27;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(245600);
        super.onResume();
        FinderTopicTimelineUIContract.a aVar = FinderTopicTimelineUIContract.tTP;
        com.tencent.mm.vending.j.c<s.p, String> IK = FinderTopicTimelineUIContract.a.IK(this.type);
        k kVar = k.vkd;
        FinderTopicTimelineUIContract.d dVar = this.udA;
        if (dVar == null) {
            p.btv("viewCallback");
        }
        RecyclerView recyclerView = dVar.tLS.getRecyclerView();
        s.p hdM = IK.hdM();
        p.g(hdM, "tuple2.`$1`()");
        String hdN = IK.hdN();
        p.g(hdN, "tuple2.`$2`()");
        k.b(recyclerView, hdM, hdN, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        AppMethodBeat.o(245600);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(245601);
        super.onPause();
        FinderTopicTimelineUIContract.a aVar = FinderTopicTimelineUIContract.tTP;
        com.tencent.mm.vending.j.c<s.p, String> IK = FinderTopicTimelineUIContract.a.IK(this.type);
        k kVar = k.vkd;
        FinderTopicTimelineUIContract.d dVar = this.udA;
        if (dVar == null) {
            p.btv("viewCallback");
        }
        RecyclerView recyclerView = dVar.tLS.getRecyclerView();
        s.p hdM = IK.hdM();
        p.g(hdM, "tuple2.`$1`()");
        String hdN = IK.hdN();
        p.g(hdN, "tuple2.`$2`()");
        k.b(recyclerView, hdM, hdN, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        AppMethodBeat.o(245601);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class c extends RecyclerView.l {
        final /* synthetic */ FinderTopicTimelineUI udG;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(245598);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(245598);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderTopicTimelineUI finderTopicTimelineUI) {
            this.udG = finderTopicTimelineUI;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(245597);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            FinderTopicTimelineUIContract.a aVar = FinderTopicTimelineUIContract.tTP;
            com.tencent.mm.vending.j.c<s.p, String> IK = FinderTopicTimelineUIContract.a.IK(this.udG.type);
            k kVar = k.vkd;
            s.p hdM = IK.hdM();
            p.g(hdM, "tuple2.`$1`()");
            String hdN = IK.hdN();
            p.g(hdN, "tuple2.`$2`()");
            k.b(recyclerView, hdM, hdN, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$onHellScrollerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(245597);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicTimelineUI$initOnCreate$3$2"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderTopicTimelineUI udG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderTopicTimelineUI finderTopicTimelineUI) {
            super(0);
            this.udG = finderTopicTimelineUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(245596);
            View loadMoreFooter = FinderTopicTimelineUI.a(this.udG).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter == null || (textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                textView3.setText(R.string.d0m);
            }
            View loadMoreFooter2 = FinderTopicTimelineUI.a(this.udG).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                textView2.setTextColor(this.udG.getResources().getColor(R.color.FG_2));
            }
            View loadMoreFooter3 = FinderTopicTimelineUI.a(this.udG).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter3 == null || (textView = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                textView.setVisibility(8);
            }
            View loadMoreFooter4 = FinderTopicTimelineUI.a(this.udG).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter4 == null || (findViewById = loadMoreFooter4.findViewById(R.id.ep0)) == null)) {
                findViewById.setVisibility(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245596);
            return xVar;
        }
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderTopicTimelineUIContract.b ddK() {
        AppMethodBeat.i(166285);
        FinderTopicTimelineUIContract.b bVar = this.udz;
        if (bVar == null) {
            p.btv("presenter");
        }
        FinderTopicTimelineUIContract.b bVar2 = bVar;
        AppMethodBeat.o(166285);
        return bVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.v$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderTopicTimelineUIContract.d ddL() {
        AppMethodBeat.i(166286);
        FinderTopicTimelineUIContract.d dVar = this.udA;
        if (dVar == null) {
            p.btv("viewCallback");
        }
        FinderTopicTimelineUIContract.d dVar2 = dVar;
        AppMethodBeat.o(166286);
        return dVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
    public final /* synthetic */ FinderTopicTimelineUIContract.Loader ddM() {
        AppMethodBeat.i(166287);
        FinderTopicTimelineUIContract.Loader loader = this.udB;
        if (loader == null) {
            p.btv("feedLoader");
        }
        FinderTopicTimelineUIContract.Loader loader2 = loader;
        AppMethodBeat.o(166287);
        return loader2;
    }
}
