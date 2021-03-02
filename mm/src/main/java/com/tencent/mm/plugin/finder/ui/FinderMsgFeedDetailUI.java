package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.feed.k;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\n*\u0001\u0018\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u00105\u001a\u00020\fH\u0016J\b\u00106\u001a\u00020\fH\u0014J\b\u00107\u001a\u00020\u0003H\u0016J\b\u00108\u001a\u00020\fH\u0016J\b\u00109\u001a\u00020\u0002H\u0016J\b\u0010:\u001a\u00020;H\u0016J\u0006\u0010<\u001a\u00020;J\b\u0010=\u001a\u00020;H\u0016J\u0006\u0010>\u001a\u00020;J\b\u0010?\u001a\u00020;H\u0016J\b\u0010@\u001a\u00020;H\u0014J\b\u0010A\u001a\u00020;H\u0014J\b\u0010B\u001a\u00020;H\u0002J\u0010\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020$H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001a\u0010,\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\b\"\u0004\b.\u0010\nR\u000e\u0010/\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000e\"\u0004\b2\u0010\u0010R\u0010\u00103\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()I", "setCreateTime", "(I)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feedDeleteListener", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1;", "fromCommentUI", "", "getFromCommentUI", "()Z", "setFromCommentUI", "(Z)V", "hasShowTopComment", "isSelf", "setSelf", "mentionId", "", "getMentionId", "()J", "setMentionId", "(J)V", "objectId", "getObjectId", "setObjectId", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "scene", "getScene", "setScene", ch.COL_USERNAME, "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onBackPressed", "onDestroy", "onResume", "openLikeDrawer", "setTopComment", "refCommentId", "plugin-finder_release"})
public final class FinderMsgFeedDetailUI extends FinderBaseFeedUI<k.b, k.a> {
    String TAG = "Finder.FinderMsgFeedDetailUI";
    private HashMap _$_findViewCache;
    boolean dJM;
    long hFK;
    private int iXu = -1;
    private String objectNonceId = "";
    private int scene;
    BaseFinderFeed tNO;
    private long tZB = -1;
    private String username;
    private k.a vMv;
    private k.b vMw;
    private boolean vMx;
    private final a vMy = new a(this);
    private boolean vMz;

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252554);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252554);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252553);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252553);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderMsgFeedDetailUI() {
        AppMethodBeat.i(167470);
        AppMethodBeat.o(167470);
    }

    public static final /* synthetic */ k.b a(FinderMsgFeedDetailUI finderMsgFeedDetailUI) {
        AppMethodBeat.i(167472);
        k.b bVar = finderMsgFeedDetailUI.vMw;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(167472);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class a extends IListener<hg> {
        final /* synthetic */ FinderMsgFeedDetailUI vMA;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(FinderMsgFeedDetailUI finderMsgFeedDetailUI) {
            this.vMA = finderMsgFeedDetailUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hg hgVar) {
            AppMethodBeat.i(167461);
            hg hgVar2 = hgVar;
            if (hgVar2 != null) {
                d.h(new C1292a(this, hgVar2));
            }
            AppMethodBeat.o(167461);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMsgFeedDetailUI$feedDeleteListener$1$callback$1$1"})
        /* renamed from: com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI$a$a  reason: collision with other inner class name */
        static final class C1292a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ hg $event$inlined;
            final /* synthetic */ a vMB;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1292a(a aVar, hg hgVar) {
                super(0);
                this.vMB = aVar;
                this.$event$inlined = hgVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(167460);
                if (this.$event$inlined.dLJ.id == this.vMB.vMA.hFK) {
                    Log.i(this.vMB.vMA.TAG, this.$event$inlined.dLJ.id + " delete, finish");
                    this.vMB.vMA.finish();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(167460);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI, com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(252551);
        k.b bVar = this.vMw;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        if (bVar.dcn().dGs()) {
            k.b bVar2 = this.vMw;
            if (bVar2 == null) {
                p.btv("viewCallback");
            }
            bVar2.dcn().dGr();
            AppMethodBeat.o(252551);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(252551);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008b, code lost:
        if (r0.subType == 3) goto L_0x008d;
     */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResume() {
        /*
        // Method dump skipped, instructions count: 188
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI.onResume():void");
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(167464);
        super.onDestroy();
        this.vMy.dead();
        AppMethodBeat.o(167464);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ FinderMsgFeedDetailUI vMA;
        final /* synthetic */ long vMC;

        c(FinderMsgFeedDetailUI finderMsgFeedDetailUI, long j2) {
            this.vMA = finderMsgFeedDetailUI;
            this.vMC = j2;
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(167462);
            BaseFinderFeed baseFinderFeed = this.vMA.tNO;
            if (baseFinderFeed != null) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vMA).get(FinderReporterUIC.class));
                if (b2 != null) {
                    b2.cZR().En(baseFinderFeed.lT());
                }
                if (!this.vMA.dJM) {
                    y yVar = y.vXH;
                    if (!y.h(baseFinderFeed)) {
                        y yVar2 = y.vXH;
                        if (y.i(baseFinderFeed.contact)) {
                            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                            com.tencent.mm.plugin.finder.storage.c.KQ(2);
                            z = true;
                            e.a(FinderMsgFeedDetailUI.a(this.vMA).dcm(), baseFinderFeed.feedObject, this.vMC, true, false, z, null, 434);
                            AppMethodBeat.o(167462);
                            return;
                        }
                    }
                }
                z = false;
                e.a(FinderMsgFeedDetailUI.a(this.vMA).dcm(), baseFinderFeed.feedObject, this.vMC, true, false, z, null, 434);
                AppMethodBeat.o(167462);
                return;
            }
            AppMethodBeat.o(167462);
        }
    }

    private final void FX(long j2) {
        AppMethodBeat.i(167465);
        getContentView().post(new c(this, j2));
        AppMethodBeat.o(167465);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ FinderMsgFeedDetailUI vMA;

        b(FinderMsgFeedDetailUI finderMsgFeedDetailUI) {
            this.vMA = finderMsgFeedDetailUI;
        }

        public final void run() {
            AppMethodBeat.i(252550);
            BaseFinderFeed baseFinderFeed = this.vMA.tNO;
            if (baseFinderFeed != null) {
                FinderMsgFeedDetailUI.a(this.vMA).dcn().a(baseFinderFeed.feedObject, null);
                AppMethodBeat.o(252550);
                return;
            }
            AppMethodBeat.o(252550);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ah1;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(252552);
        int intExtra = getIntent().getIntExtra("from_scene", 2);
        y yVar = y.vXH;
        if (y.LC(intExtra)) {
            AppMethodBeat.o(252552);
            return 7;
        }
        AppMethodBeat.o(252552);
        return 5;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI
    public final void initOnCreate() {
        AppMethodBeat.i(167466);
        this.username = getIntent().getStringExtra("feed_username");
        this.hFK = getIntent().getLongExtra("feed_object_id", -1);
        String stringExtra = getIntent().getStringExtra("feed_object_nonceid");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.objectNonceId = stringExtra;
        this.scene = getIntent().getIntExtra("from_scene", 2);
        this.dJM = getIntent().getBooleanExtra("feed_is_self", false);
        this.tZB = getIntent().getLongExtra("mention_id", -1);
        this.iXu = getIntent().getIntExtra("mention_create_time", -1);
        if (this.hFK == 0) {
            Log.w(this.TAG, "objectId 0, finish");
            finish();
        }
        this.vMx = getIntent().getBooleanExtra("from_comment_ui", false);
        this.vMv = new k.a(this.scene, this, false, this.dJM, 4);
        FinderMsgFeedDetailUI finderMsgFeedDetailUI = this;
        k.a aVar = this.vMv;
        if (aVar == null) {
            p.btv("presenter");
        }
        this.vMw = new k.b(finderMsgFeedDetailUI, aVar, this.scene, getCommentScene(), false);
        e.a aVar2 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        FinderItem Fy = e.a.Fy(this.hFK);
        if (Fy != null) {
            c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            this.tNO = c.a.s(Fy);
            k.a aVar4 = this.vMv;
            if (aVar4 == null) {
                p.btv("presenter");
            }
            ArrayList<bo> arrayList = aVar4.feedList;
            if (arrayList != null) {
                BaseFinderFeed baseFinderFeed = this.tNO;
                if (baseFinderFeed == null) {
                    p.hyc();
                }
                arrayList.add(baseFinderFeed);
            }
        }
        if (this.tNO == null) {
            Log.w(this.TAG, "feed null, finish");
            finish();
        }
        this.vMy.alive();
        AppMethodBeat.o(167466);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI
    public final void ddP() {
        AppMethodBeat.i(167467);
        setMMTitle(R.string.da9);
        AppMethodBeat.o(167467);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.b$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI
    public final /* synthetic */ k.a ddQ() {
        AppMethodBeat.i(167468);
        k.a aVar = this.vMv;
        if (aVar == null) {
            p.btv("presenter");
        }
        k.a aVar2 = aVar;
        AppMethodBeat.o(167468);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.b$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI
    public final /* synthetic */ k.b ddR() {
        AppMethodBeat.i(167469);
        k.b bVar = this.vMw;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        k.b bVar2 = bVar;
        AppMethodBeat.o(167469);
        return bVar2;
    }
}
