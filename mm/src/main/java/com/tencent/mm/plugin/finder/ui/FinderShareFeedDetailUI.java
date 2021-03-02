package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.feed.k;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010I\u001a\u00020;H\u0016J\b\u0010J\u001a\u00020;H\u0014J\b\u0010K\u001a\u00020\u0003H\u0016J\b\u0010L\u001a\u00020;H\u0016J\b\u0010M\u001a\u00020\u0002H\u0016J\b\u0010N\u001a\u00020OH\u0016J\u0006\u0010P\u001a\u00020OJ\b\u0010Q\u001a\u00020OH\u0016J\u0006\u0010R\u001a\u00020OJ\b\u0010S\u001a\u00020OH\u0014J\b\u0010T\u001a\u00020OH\u0014R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\b\"\u0004\b&\u0010\u0012R\u000e\u0010'\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\b\"\u0004\b8\u0010\u0012R\u000e\u00109\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\u000e\u0010C\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010!\"\u0004\bF\u0010#R\u000e\u0010G\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006U"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "encryptedObjectId", "getEncryptedObjectId", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "finderLiveNoticePreLoader$delegate", "firstResume", "", "getFirstResume", "()Z", "setFirstResume", "(Z)V", "fromUser", "getFromUser", "setFromUser", "isShareClickReport", "jumpBtn", "Landroid/view/View;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "reportScene", "", "getReportScene", "()I", "setReportScene", "(I)V", "scene", "getScene", "setScene", "showFinderEntry", "showJumpEntry", "getShowJumpEntry", "setShowJumpEntry", "tipsLayout", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onDestroy", "onResume", "plugin-finder_release"})
public final class FinderShareFeedDetailUI extends FinderBaseFeedUI<k.b, i> {
    final String TAG = "Finder.FinderShareFeedDetailUI";
    private HashMap _$_findViewCache;
    String dRL = "";
    long hFK;
    com.tencent.mm.bw.b likeBuffer;
    private String objectNonceId = "";
    int sQn;
    private int scene = 2;
    private String tNK = "";
    BaseFinderFeed tNO;
    private final f tRX = g.ah(new a(this));
    private final f tRY = g.ah(new b(this));
    private View uNf;
    private k.b vMw;
    private i vOE;
    boolean vOF = true;
    private boolean vOG = ((aj) com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry();
    private View vOH;
    private boolean vOI = true;
    private boolean vOJ;

    private com.tencent.mm.plugin.finder.feed.model.f dcX() {
        AppMethodBeat.i(252700);
        com.tencent.mm.plugin.finder.feed.model.f fVar = (com.tencent.mm.plugin.finder.feed.model.f) this.tRY.getValue();
        AppMethodBeat.o(252700);
        return fVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252703);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252703);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252702);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252702);
        return view;
    }

    public final com.tencent.mm.plugin.finder.feed.model.d dcW() {
        AppMethodBeat.i(252699);
        com.tencent.mm.plugin.finder.feed.model.d dVar = (com.tencent.mm.plugin.finder.feed.model.d) this.tRX.getValue();
        AppMethodBeat.o(252699);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<Integer, bo> {
        final /* synthetic */ FinderShareFeedDetailUI vOK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderShareFeedDetailUI finderShareFeedDetailUI) {
            super(1);
            this.vOK = finderShareFeedDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ bo invoke(Integer num) {
            BaseFinderFeed baseFinderFeed;
            AppMethodBeat.i(252697);
            if (num.intValue() == 0) {
                bo dcJ = FinderShareFeedDetailUI.a(this.vOK).dcJ();
                if (dcJ instanceof BaseFinderFeed) {
                    baseFinderFeed = (BaseFinderFeed) dcJ;
                } else {
                    baseFinderFeed = null;
                }
                BaseFinderFeed baseFinderFeed2 = baseFinderFeed;
                AppMethodBeat.o(252697);
                return baseFinderFeed2;
            }
            AppMethodBeat.o(252697);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
    static final class d extends q implements m<Integer, Integer, LinkedList<bo>> {
        final /* synthetic */ FinderShareFeedDetailUI vOK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderShareFeedDetailUI finderShareFeedDetailUI) {
            super(2);
            this.vOK = finderShareFeedDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ LinkedList<bo> invoke(Integer num, Integer num2) {
            AppMethodBeat.i(252698);
            num.intValue();
            num2.intValue();
            bo dcJ = FinderShareFeedDetailUI.a(this.vOK).dcJ();
            if (dcJ != null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(dcJ);
                AppMethodBeat.o(252698);
                return linkedList;
            }
            AppMethodBeat.o(252698);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
    static final class e<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ FinderShareFeedDetailUI vOK;

        e(FinderShareFeedDetailUI finderShareFeedDetailUI) {
            this.vOK = finderShareFeedDetailUI;
        }

        /* JADX WARNING: Removed duplicated region for block: B:71:0x0194  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x01a4  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01d8  */
        @Override // com.tencent.mm.vending.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object call(java.lang.Object r13) {
            /*
            // Method dump skipped, instructions count: 552
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI.e.call(java.lang.Object):java.lang.Object");
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$1$1$1", "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$1"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ BaseFinderFeed vOL;
            final /* synthetic */ FinderObject vOM;
            final /* synthetic */ e vON;

            a(BaseFinderFeed baseFinderFeed, FinderObject finderObject, e eVar) {
                this.vOL = baseFinderFeed;
                this.vOM = finderObject;
                this.vON = eVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(167669);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h hVar = h.veu;
                h.dnS();
                ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).resetLastTimelineExitTime();
                String uuid = UUID.randomUUID().toString();
                p.g(uuid, "UUID.randomUUID().toString()");
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.gS(uuid, "Enter");
                Intent intent = new Intent();
                intent.putExtra("key_context_id", uuid);
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.a((Context) this.vON.vOK, intent, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI$onResume$1$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(167669);
            }
        }
    }

    public FinderShareFeedDetailUI() {
        AppMethodBeat.i(167676);
        AppMethodBeat.o(167676);
    }

    public static final /* synthetic */ i a(FinderShareFeedDetailUI finderShareFeedDetailUI) {
        AppMethodBeat.i(167677);
        i iVar = finderShareFeedDetailUI.vOE;
        if (iVar == null) {
            p.btv("presenter");
        }
        AppMethodBeat.o(167677);
        return iVar;
    }

    public static final /* synthetic */ k.b f(FinderShareFeedDetailUI finderShareFeedDetailUI) {
        AppMethodBeat.i(167678);
        k.b bVar = finderShareFeedDetailUI.vMw;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(167678);
        return bVar;
    }

    public static final /* synthetic */ View g(FinderShareFeedDetailUI finderShareFeedDetailUI) {
        AppMethodBeat.i(167679);
        View view = finderShareFeedDetailUI.uNf;
        if (view == null) {
            p.btv("tipsLayout");
        }
        AppMethodBeat.o(167679);
        return view;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.b$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI
    public final /* synthetic */ i ddQ() {
        AppMethodBeat.i(167674);
        i dAg = dAg();
        AppMethodBeat.o(167674);
        return dAg;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(167671);
        super.onResume();
        long j2 = this.hFK;
        String str = this.objectNonceId;
        int commentScene = getCommentScene();
        String str2 = this.tNK;
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this);
        new af(j2, str, commentScene, 2, "", true, null, null, 0, null, false, false, str2, fH != null ? fH.dIx() : null, 0, 20416).aYI().b(new e(this));
        AppMethodBeat.o(167671);
    }

    private i dAg() {
        AppMethodBeat.i(252701);
        i iVar = this.vOE;
        if (iVar == null) {
            p.btv("presenter");
        }
        AppMethodBeat.o(252701);
        return iVar;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ajx;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        com.tencent.mm.plugin.finder.event.base.c a2;
        com.tencent.mm.plugin.finder.event.base.c a3;
        AppMethodBeat.i(178446);
        if (this.sQn != 0 && !this.vOJ) {
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            long j2 = this.hFK;
            int i2 = this.sQn;
            String str = this.dRL;
            if (str == null) {
                str = "";
            }
            com.tencent.mm.plugin.finder.report.k.a(kVar, j2, i2, str, 0);
            this.vOJ = true;
        }
        dcW().onDetach();
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        AppCompatActivity context = getContext();
        p.g(context, "context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (!(fH == null || (a3 = FinderReporterUIC.a(fH)) == null)) {
            a3.b(dcW());
        }
        dcX().onDetach();
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        AppCompatActivity context2 = getContext();
        p.g(context2, "context");
        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(context2);
        if (!(fH2 == null || (a2 = FinderReporterUIC.a(fH2)) == null)) {
            a2.b(dcX());
        }
        dAg().onDetach();
        super.onDestroy();
        AppMethodBeat.o(178446);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 25;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.d> {
        final /* synthetic */ FinderShareFeedDetailUI vOK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderShareFeedDetailUI finderShareFeedDetailUI) {
            super(0);
            this.vOK = finderShareFeedDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.feed.model.d invoke() {
            AppMethodBeat.i(252695);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.feed.model.d dVar = ((FinderCommentPreloaderUIC) com.tencent.mm.ui.component.a.b(this.vOK).get(FinderCommentPreloaderUIC.class)).tLy;
            AppMethodBeat.o(252695);
            return dVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.f> {
        final /* synthetic */ FinderShareFeedDetailUI vOK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderShareFeedDetailUI finderShareFeedDetailUI) {
            super(0);
            this.vOK = finderShareFeedDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.feed.model.f invoke() {
            AppMethodBeat.i(252696);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.feed.model.f fVar = ((FinderLiveNoticePreLoadUIC) com.tencent.mm.ui.component.a.b(this.vOK).get(FinderLiveNoticePreLoadUIC.class)).wyi;
            AppMethodBeat.o(252696);
            return fVar;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI
    public final void initOnCreate() {
        com.tencent.mm.plugin.finder.event.base.c a2;
        com.tencent.mm.plugin.finder.event.base.c a3;
        boolean z = true;
        AppMethodBeat.i(167672);
        this.hFK = getIntent().getLongExtra("feed_object_id", 0);
        String stringExtra = getIntent().getStringExtra("feed_encrypted_object_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.tNK = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("feed_object_nonceId");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.objectNonceId = stringExtra2;
        this.sQn = getIntent().getIntExtra("report_scene", 0);
        this.dRL = getIntent().getStringExtra("from_user");
        this.vOF = getIntent().getBooleanExtra("key_show_jump_entry", true);
        String stringExtra3 = getIntent().getStringExtra("key_like_buffer");
        if (stringExtra3 != null && !Util.isNullOrNil(stringExtra3)) {
            this.likeBuffer = com.tencent.mm.bw.b.cD(Util.decodeHexString(stringExtra3));
        }
        if (this.hFK == 0 && Util.isNullOrNil(this.tNK)) {
            Log.w(this.TAG, "objectId " + this.hFK + ", encryptedObjectId " + this.tNK + ", finish");
            finish();
        }
        this.vOE = new i(this.scene, this, !this.vOG);
        FinderShareFeedDetailUI finderShareFeedDetailUI = this;
        i iVar = this.vOE;
        if (iVar == null) {
            p.btv("presenter");
        }
        i iVar2 = iVar;
        int i2 = this.scene;
        int commentScene = getCommentScene();
        if (this.vOG) {
            z = false;
        }
        this.vMw = new k.b(finderShareFeedDetailUI, iVar2, i2, commentScene, z);
        if (this.hFK != 0) {
            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
            FinderItem Fy = e.a.Fy(this.hFK);
            if (Fy != null) {
                c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                this.tNO = c.a.s(Fy);
                i iVar3 = this.vOE;
                if (iVar3 == null) {
                    p.btv("presenter");
                }
                ArrayList<bo> arrayList = iVar3.feedList;
                if (arrayList != null) {
                    BaseFinderFeed baseFinderFeed = this.tNO;
                    if (baseFinderFeed == null) {
                        p.hyc();
                    }
                    arrayList.add(baseFinderFeed);
                }
            }
        }
        if (this.sQn != 0) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1278, 14, 1, false);
        }
        dcW().a(this.scene, getCommentScene(), new c(this));
        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
        AppCompatActivity context = getContext();
        p.g(context, "context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (!(fH == null || (a3 = FinderReporterUIC.a(fH)) == null)) {
            a3.a(dcW());
        }
        dcX().e(new d(this));
        FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
        AppCompatActivity context2 = getContext();
        p.g(context2, "context");
        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(context2);
        if (fH2 == null || (a2 = FinderReporterUIC.a(fH2)) == null) {
            AppMethodBeat.o(167672);
            return;
        }
        a2.a(dcX());
        AppMethodBeat.o(167672);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI
    public final void ddP() {
        AppMethodBeat.i(167673);
        setMMTitle(R.string.da9);
        View findViewById = findViewById(R.id.hpd);
        p.g(findViewById, "findViewById(R.id.share_feed_detail_tips_layout)");
        this.uNf = findViewById;
        View view = this.uNf;
        if (view == null) {
            p.btv("tipsLayout");
        }
        view.setVisibility(8);
        AppMethodBeat.o(167673);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.b$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI
    public final /* synthetic */ k.b ddR() {
        AppMethodBeat.i(167675);
        k.b bVar = this.vMw;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        k.b bVar2 = bVar;
        AppMethodBeat.o(167675);
        return bVar2;
    }
}
