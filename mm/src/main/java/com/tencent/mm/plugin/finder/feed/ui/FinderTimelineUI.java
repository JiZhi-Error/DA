package com.tencent.mm.plugin.finder.feed.ui;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.convert.aj;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.feed.ai;
import com.tencent.mm.plugin.finder.feed.at;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.upload.b;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u00022\u00020\u0003:\u00019B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u0006H\u0014J \u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0016J\"\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020\u001cH\u0016J\u0012\u0010.\u001a\u00020\u001c2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u001cH\u0014J\b\u00102\u001a\u00020\u001cH\u0014J\b\u00103\u001a\u00020\u001cH\u0014J,\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\n2\b\u0010'\u001a\u0004\u0018\u000108H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_POST", "", "MENU_ID_POST_NO_PERMISSION", "MENU_ID_PROFILE", "contextId", "", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "postItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "Lkotlin/collections/HashMap;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "progressDlg", "Landroid/app/ProgressDialog;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "addAllMenu", "", "addPostEducation", "continuePost", "doClickPostAction", "doPrepareUser", "showPostRed", "getLayoutId", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "scene", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderTimelineUI extends MMFinderUI implements com.tencent.mm.ak.i, com.tencent.mm.plugin.finder.api.f {
    public static final a udh = new a((byte) 0);
    private HashMap _$_findViewCache;
    private ProgressDialog kkd;
    private boolean qgs;
    private String sGQ;
    private ai.b tRV;
    private ai.a tTf;
    private bed udb;
    private final int udc = 1;
    private final int udd = 2;
    private final int ude = 3;
    private final FinderGlobalLocationVM udf;
    private HashMap<Integer, ddk> udg;

    static {
        AppMethodBeat.i(166265);
        AppMethodBeat.o(166265);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245579);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245579);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245578);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245578);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class n<T> implements Observer<h.a> {
        final /* synthetic */ FinderTimelineUI udi;

        n(FinderTimelineUI finderTimelineUI) {
            this.udi = finderTimelineUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            AppMethodBeat.i(178304);
            h.a aVar2 = aVar;
            Log.i("Finder.FinderTimelineUI", "[MENU_ID_PROFILE] red=" + (aVar2 != null && aVar2.dEF));
            if (aVar2 == null || !aVar2.dEF) {
                this.udi.getController().updateOptionMenuRedDot(this.udi.udc, false);
                AppMethodBeat.o(178304);
                return;
            }
            i.a aVar3 = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
            if (i.a.dbp()) {
                this.udi.getController().updateOptionMenuRedDot(this.udi.udc, true);
                AppMethodBeat.o(178304);
                return;
            }
            this.udi.getController().updateOptionMenuRedDot(this.udi.udc, false);
            Log.w("Finder.FinderTimelineUI", "has red dot,but not count.");
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1347, 1, 1);
            AppMethodBeat.o(178304);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class o<T> implements Observer<h.a> {
        final /* synthetic */ FinderTimelineUI udi;

        o(FinderTimelineUI finderTimelineUI) {
            this.udi = finderTimelineUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            boolean z;
            AppMethodBeat.i(178305);
            h.a aVar2 = aVar;
            StringBuilder sb = new StringBuilder("[MENU_ID_POST] red=");
            if (aVar2 == null || !aVar2.dEF) {
                z = false;
            } else {
                z = true;
            }
            Log.i("Finder.FinderTimelineUI", sb.append(z).toString());
            if (aVar2 == null || !aVar2.dEF) {
                this.udi.getController().updateOptionMenuRedDot(this.udi.udd, false);
                AppMethodBeat.o(178305);
                return;
            }
            this.udi.getController().updateOptionMenuRedDot(this.udi.udd, true);
            AppMethodBeat.o(178305);
        }
    }

    public FinderTimelineUI() {
        AppMethodBeat.i(245576);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(PluginFin…alLocationVM::class.java)");
        this.udf = (FinderGlobalLocationVM) viewModel;
        this.udg = new HashMap<>();
        AppMethodBeat.o(245576);
    }

    public static final /* synthetic */ ai.b a(FinderTimelineUI finderTimelineUI) {
        AppMethodBeat.i(166266);
        ai.b bVar = finderTimelineUI.tRV;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        AppMethodBeat.o(166266);
        return bVar;
    }

    public static final /* synthetic */ ai.a b(FinderTimelineUI finderTimelineUI) {
        AppMethodBeat.i(245577);
        ai.a aVar = finderTimelineUI.tTf;
        if (aVar == null) {
            kotlin.g.b.p.btv("presenter");
        }
        AppMethodBeat.o(245577);
        return aVar;
    }

    public static final /* synthetic */ void g(FinderTimelineUI finderTimelineUI) {
        AppMethodBeat.i(166269);
        finderTimelineUI.det();
        AppMethodBeat.o(166269);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$Companion;", "", "()V", "REQUEST_CODE_LIVE", "", "REQUEST_CODE_POST_ACTIONSHEET", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_TAKE_PHOTO", "REQUEST_CODE_TEXT_CARD", "REQ_GPS_PERMISSION", "REQ_OPEN_GPS", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.akn;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        bbn bbn;
        AppMethodBeat.i(166253);
        com.tencent.mm.pluginsdk.h.q(this);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_context_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.sGQ = stringExtra;
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        String str = this.sGQ;
        if (str == null) {
            kotlin.g.b.p.btv("contextId");
        }
        com.tencent.mm.plugin.finder.report.k.gS(str, "OnCreate");
        int intExtra = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah).getRedDotManager().Iw(intExtra);
        this.qgs = FinderGlobalLocationVM.h(this);
        if (this.qgs) {
            this.udf.cxh();
        }
        ao aoVar = ao.tuE;
        ao.cYb();
        b.a aVar = com.tencent.mm.plugin.finder.upload.b.vRM;
        com.tencent.mm.plugin.finder.upload.b.vRL.dAP();
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        setMMTitle(context.getResources().getString(R.string.da9));
        com.tencent.mm.ac.d.i(j.udq);
        setBackBtn(new k(this));
        this.tTf = new at(this, null);
        FinderTimelineUI finderTimelineUI = this;
        ai.a aVar2 = this.tTf;
        if (aVar2 == null) {
            kotlin.g.b.p.btv("presenter");
        }
        View contentView = getContentView();
        kotlin.g.b.p.g(contentView, "contentView");
        this.tRV = new au(finderTimelineUI, aVar2, contentView, null);
        ai.a aVar3 = this.tTf;
        if (aVar3 == null) {
            kotlin.g.b.p.btv("presenter");
        }
        ai.b bVar = this.tRV;
        if (bVar == null) {
            kotlin.g.b.p.btv("viewCallback");
        }
        aVar3.onAttach(bVar);
        g.a aVar4 = com.tencent.mm.plugin.finder.upload.g.vSJ;
        com.tencent.mm.plugin.finder.upload.g.vSH.dAZ();
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().a(104, this);
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().a(108, this);
        com.tencent.mm.pluginsdk.h.r(this);
        setTitleBarClickListener(new l(this), m.udr);
        if (((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).showPostEntry()) {
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah2).getRedDotManager().asW("TLCamera");
            com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah3).getRedDotManager().asX("TLCamera");
            y yVar = y.vXH;
            if (!(asW == null || asX == null)) {
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this);
                com.tencent.mm.plugin.finder.report.j.a("2", asX, asW, 1, fH != null ? fH.dIx() : null, 0, 0, 96);
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                FinderReporterUIC.a aVar6 = FinderReporterUIC.wzC;
                FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this);
                com.tencent.mm.plugin.finder.report.k.a("2", 2, 1, 1, 1, 0, (String) null, (String) null, 0, fH2 != null ? fH2.dIx() : null, 0, 0, 3520);
            }
            removeOptionMenu(this.udd);
            addIconOptionMenu(this.udd, -1, R.raw.icons_outlined_camera, new b(this, asW, asX));
        } else {
            removeOptionMenu(this.ude);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.drx()) {
                addIconOptionMenu(this.ude, -1, R.raw.finder_no_permission_post_camera, new e(this));
            }
        }
        removeOptionMenu(this.udc);
        com.tencent.mm.kernel.b.a ah4 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        kotlin.g.b.p.g(ah4, "MMKernel.plugin(PluginFinder::class.java)");
        bdo asW2 = ((PluginFinder) ah4).getRedDotManager().asW("TLPersonalCenter");
        com.tencent.mm.kernel.b.a ah5 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        kotlin.g.b.p.g(ah5, "MMKernel.plugin(PluginFinder::class.java)");
        com.tencent.mm.plugin.finder.extension.reddot.k asX2 = ((PluginFinder) ah5).getRedDotManager().asX("TLPersonalCenter");
        addIconOptionMenu(this.udc, -1, R.raw.icons_outlined_me, new c(this, asW2, asX2), d.udn);
        y yVar2 = y.vXH;
        if (!(asW2 == null || asX2 == null)) {
            com.tencent.mm.plugin.finder.report.j jVar2 = com.tencent.mm.plugin.finder.report.j.vft;
            FinderReporterUIC.a aVar7 = FinderReporterUIC.wzC;
            FinderReporterUIC fH3 = FinderReporterUIC.a.fH(this);
            com.tencent.mm.plugin.finder.report.j.a("2", asX2, asW2, 1, fH3 != null ? fH3.dIx() : null, 0, 0, 96);
            com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
            String str2 = asX2.field_tipsId;
            FinderReporterUIC.a aVar8 = FinderReporterUIC.wzC;
            FinderReporterUIC fH4 = FinderReporterUIC.a.fH(this);
            if (fH4 != null) {
                bbn = fH4.dIx();
            } else {
                bbn = null;
            }
            com.tencent.mm.plugin.finder.report.k.a("2", 1, 1, 1, 2, 0, str2, (String) null, 0, bbn, 0, 0, 3456);
        }
        com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar2 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daN(), this, new n(this));
        com.tencent.mm.plugin.finder.extension.reddot.h hVar3 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar4 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daL(), this, new o(this));
        AppMethodBeat.o(166253);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class k implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderTimelineUI udi;

        k(FinderTimelineUI finderTimelineUI) {
            this.udi = finderTimelineUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(166244);
            this.udi.onBackPressed();
            AppMethodBeat.o(166244);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class l implements Runnable {
        final /* synthetic */ FinderTimelineUI udi;

        l(FinderTimelineUI finderTimelineUI) {
            this.udi = finderTimelineUI;
        }

        public final void run() {
            AppMethodBeat.i(166245);
            RecyclerView.LayoutManager layoutManager = FinderTimelineUI.a(this.udi).getRecyclerView().getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(166245);
                throw tVar;
            }
            if (((LinearLayoutManager) layoutManager).ks() <= 12) {
                RecyclerView recyclerView = FinderTimelineUI.a(this.udi).getRecyclerView();
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            } else {
                RecyclerView recyclerView2 = FinderTimelineUI.a(this.udi).getRecyclerView();
                com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, a3.axQ(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView2.scrollToPosition(((Integer) a3.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            }
            aj.a aVar = aj.tEf;
            aj.a.a(FinderTimelineUI.a(this.udi), FinderTimelineUI.b(this.udi).getTabType());
            AppMethodBeat.o(166245);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class m implements Runnable {
        public static final m udr = new m();

        static {
            AppMethodBeat.i(166246);
            AppMethodBeat.o(166246);
        }

        m() {
        }

        public final void run() {
        }
    }

    private final void det() {
        AppMethodBeat.i(166254);
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (com.tencent.mm.plugin.finder.spam.a.avp("post")) {
            AppMethodBeat.o(166254);
            return;
        }
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.fs(this);
        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.as(1, false);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) getContext(), 1, true);
        View inflate = aa.jQ(getContext()).inflate(R.layout.ak1, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.fzc);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.wm);
        c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
        if (asG != null) {
            kotlin.g.b.p.g(textView, "nicknameTv");
            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getBaseContext(), asG.getNickname()));
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar4 = new com.tencent.mm.plugin.finder.loader.a(asG.field_avatarUrl);
            kotlin.g.b.p.g(imageView, "avatarIv");
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            dka.a(aVar4, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
        }
        eVar.V(inflate, true);
        eVar.a(new f(this));
        eVar.a(new g(this));
        eVar.b(h.udo);
        eVar.dGm();
        AppMethodBeat.o(166254);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class f implements o.f {
        final /* synthetic */ FinderTimelineUI udi;

        f(FinderTimelineUI finderTimelineUI) {
            this.udi = finderTimelineUI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(245571);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(1001, R.string.um);
                mVar.kV(1002, R.string.uv);
                mVar.kV(1004, R.string.cs4);
                r rVar = r.vWn;
                r.a(this.udi.udg, mVar);
            }
            AppMethodBeat.o(245571);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class g implements o.g {
        final /* synthetic */ FinderTimelineUI udi;

        g(FinderTimelineUI finderTimelineUI) {
            this.udi = finderTimelineUI;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(245572);
            Intent intent = new Intent();
            kotlin.g.b.p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == 1001) {
                intent.putExtra("key_finder_post_router", 2);
                intent.putExtra("key_finder_post_from", 5);
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                AppCompatActivity context = this.udi.getContext();
                kotlin.g.b.p.g(context, "context");
                com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(context, intent);
                AppMethodBeat.o(245572);
            } else if (menuItem.getItemId() == 1002) {
                intent.putExtra("key_finder_post_router", 3);
                intent.putExtra("key_finder_post_from", 5);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                AppCompatActivity context2 = this.udi.getContext();
                kotlin.g.b.p.g(context2, "context");
                com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(context2, intent);
                AppMethodBeat.o(245572);
            } else if (menuItem.getItemId() == 1004) {
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                AppCompatActivity context3 = this.udi.getContext();
                kotlin.g.b.p.g(context3, "context");
                com.tencent.mm.plugin.finder.utils.a.a(context3, 0, "", null, false, null, null, null, null, null, null, null, null, 16376);
                AppMethodBeat.o(245572);
            } else {
                if (this.udi.udg.containsKey(Integer.valueOf(menuItem.getItemId()))) {
                    r rVar = r.vWn;
                    r.a(this.udi, (ddk) this.udi.udg.get(Integer.valueOf(menuItem.getItemId())));
                    com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
                    com.tencent.mm.plugin.finder.report.i.as(1, false);
                }
                AppMethodBeat.o(245572);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class h implements e.b {
        public static final h udo = new h();

        static {
            AppMethodBeat.i(245574);
            AppMethodBeat.o(245574);
        }

        h() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(245573);
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.Ks(6);
            AppMethodBeat.o(245573);
        }
    }

    @Override // com.tencent.mm.plugin.finder.api.f
    public final void a(apf apf, int i2, int i3) {
        AppMethodBeat.i(245575);
        kotlin.g.b.p.h(apf, "cmdItem");
        switch (apf.cmdId) {
            case 108:
                ai.a aVar = this.tTf;
                if (aVar == null) {
                    kotlin.g.b.p.btv("presenter");
                }
                aVar.dcO();
                break;
        }
        AppMethodBeat.o(245575);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderTimelineUI udi;
        final /* synthetic */ bdo udj;
        final /* synthetic */ com.tencent.mm.plugin.finder.extension.reddot.k udk;

        b(FinderTimelineUI finderTimelineUI, bdo bdo, com.tencent.mm.plugin.finder.extension.reddot.k kVar) {
            this.udi = finderTimelineUI;
            this.udj = bdo;
            this.udk = kVar;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(178302);
            y yVar = y.vXH;
            bdo bdo = this.udj;
            com.tencent.mm.plugin.finder.extension.reddot.k kVar = this.udk;
            if (!(bdo == null || kVar == null)) {
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.udi);
                com.tencent.mm.plugin.finder.report.j.a("2", kVar, bdo, 2, fH != null ? fH.dIx() : null, 0, 0, 96);
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.udi);
                com.tencent.mm.plugin.finder.report.k.a("2", 2, 2, 1, 1, 0, (String) null, (String) null, 0, fH2 != null ? fH2.dIx() : null, 0, 0, 3520);
            }
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
            ((com.tencent.mm.plugin.i.a.aj) ah).getRedDotManager().asV("TLCamera");
            if (!Util.isNullOrNil(z.aUg())) {
                FinderTimelineUI.g(this.udi);
            } else if (this.udi.udb == null) {
                Log.i("Finder.FinderTimelineUI", "need prepare user");
                com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
                h.a value = com.tencent.mm.plugin.finder.extension.reddot.h.daL().getValue();
                FinderTimelineUI.a(this.udi, value != null && value.dEF);
                AppMethodBeat.o(178302);
                return true;
            } else {
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_PREPARE_USER_FLAG_INT_SYNC, 0);
                Log.i("Finder.FinderTimelineUI", "userFlag %d", Integer.valueOf(i2));
                if ((i2 & 2) != 0) {
                    com.tencent.mm.ui.base.h.X(this.udi, this.udi.getString(R.string.d8n), "");
                } else {
                    y yVar2 = y.vXH;
                    if (y.bE(this.udi)) {
                        y yVar3 = y.vXH;
                        y.a(this.udi, this.udi.getString(R.string.da1), this.udi.udb);
                    }
                }
            }
            AppMethodBeat.o(178302);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderTimelineUI udi;
        final /* synthetic */ bdo udl;
        final /* synthetic */ com.tencent.mm.plugin.finder.extension.reddot.k udm;

        c(FinderTimelineUI finderTimelineUI, bdo bdo, com.tencent.mm.plugin.finder.extension.reddot.k kVar) {
            this.udi = finderTimelineUI;
            this.udl = bdo;
            this.udm = kVar;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(178303);
            y yVar = y.vXH;
            bdo bdo = this.udl;
            com.tencent.mm.plugin.finder.extension.reddot.k kVar = this.udm;
            if (!(bdo == null || kVar == null)) {
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.udi);
                com.tencent.mm.plugin.finder.report.j.a("2", kVar, bdo, 2, fH != null ? fH.dIx() : null, 0, 0, 96);
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                String str = kVar.field_tipsId;
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.udi);
                com.tencent.mm.plugin.finder.report.k.a("2", 1, 2, 1, 2, 0, str, (String) null, 0, fH2 != null ? fH2.dIx() : null, 0, 0, 3456);
            }
            com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.z(this.udi, null);
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
            ((com.tencent.mm.plugin.i.a.aj) ah).getRedDotManager().asV("TLPersonalCenter");
            AppMethodBeat.o(178303);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d implements View.OnLongClickListener {
        public static final d udn = new d();

        static {
            AppMethodBeat.i(245568);
            AppMethodBeat.o(245568);
        }

        d() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(245567);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addAllMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addAllMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(245567);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class e implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderTimelineUI udi;

        e(FinderTimelineUI finderTimelineUI) {
            this.udi = finderTimelineUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245570);
            dl dlVar = new dl();
            dlVar.afd();
            dlVar.bfK();
            Log.i("Finder.FinderTimelineUI", "report18939 postEdu: " + dlVar.afe());
            com.tencent.mm.plugin.finder.view.d dVar = new com.tencent.mm.plugin.finder.view.d(this.udi.getContext());
            dVar.Ml(R.layout.aib);
            TextView textView = (TextView) dVar.lJI.findViewById(R.id.fzy);
            TextView textView2 = (TextView) dVar.lJI.findViewById(R.id.fzw);
            kotlin.g.b.p.g(textView, "titleTv");
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            textView.setText(com.tencent.mm.plugin.finder.storage.c.dry());
            kotlin.g.b.p.g(textView2, "descTv");
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            textView2.setText(com.tencent.mm.plugin.finder.storage.c.drz());
            ((TextView) dVar.lJI.findViewById(R.id.fzx)).setOnClickListener(new a(dVar));
            dVar.dGm();
            AppMethodBeat.o(245570);
            return true;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ com.tencent.mm.plugin.finder.view.d tru;

            a(com.tencent.mm.plugin.finder.view.d dVar) {
                this.tru = dVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(245569);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addPostEducation$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.tru.bMo();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addPostEducation$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(245569);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class i implements DialogInterface.OnCancelListener {
        final /* synthetic */ FinderTimelineUI udi;
        final /* synthetic */ cd udp;

        i(FinderTimelineUI finderTimelineUI, cd cdVar) {
            this.udi = finderTimelineUI;
            this.udp = cdVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(166241);
            com.tencent.mm.kernel.g.azz().a(this.udp);
            com.tencent.mm.kernel.g.azz().b(3761, this.udi);
            AppMethodBeat.o(166241);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(166258);
        Log.i("Finder.FinderTimelineUI", "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        ProgressDialog progressDialog = this.kkd;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        if (qVar != null) {
            if (qVar.getType() == 3761) {
                com.tencent.mm.kernel.g.azz().b(3761, this);
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                    kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                    int i4 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_PREPARE_USER_FLAG_INT_SYNC, 0);
                    Log.i("Finder.FinderTimelineUI", "userFlag %d", Integer.valueOf(i4));
                    if ((i4 & 2) != 0) {
                        this.udb = ((cd) qVar).cZc();
                        com.tencent.mm.ui.base.h.X(this, getString(R.string.d8n), "");
                        AppMethodBeat.o(166258);
                        return;
                    }
                    y yVar = y.vXH;
                    if (y.bE(this)) {
                        y yVar2 = y.vXH;
                        if (y.a(this, getString(R.string.da1), ((cd) qVar).twh, this.udb)) {
                            det();
                        }
                    }
                    AppMethodBeat.o(166258);
                    return;
                }
                u.makeText(this, (int) R.string.d5v, 1).show();
            }
            AppMethodBeat.o(166258);
            return;
        }
        AppMethodBeat.o(166258);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(166259);
        ai.a aVar = this.tTf;
        if (aVar == null) {
            kotlin.g.b.p.btv("presenter");
        }
        aVar.onBackPressed();
        AppMethodBeat.o(166259);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(166260);
        super.onResume();
        boolean z = this.qgs;
        this.qgs = FinderGlobalLocationVM.dHO();
        if (this.qgs && !z) {
            this.udf.cxh();
        }
        ai.a aVar = this.tTf;
        if (aVar == null) {
            kotlin.g.b.p.btv("presenter");
        }
        aVar.onUIResume();
        g.a aVar2 = com.tencent.mm.plugin.finder.upload.g.vSJ;
        if (com.tencent.mm.plugin.finder.upload.g.vSI) {
            ai.b bVar = this.tRV;
            if (bVar == null) {
                kotlin.g.b.p.btv("viewCallback");
            }
            RecyclerView recyclerView = bVar.getRecyclerView();
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            g.a aVar3 = com.tencent.mm.plugin.finder.upload.g.vSJ;
            com.tencent.mm.plugin.finder.upload.g.vSI = false;
        }
        AppMethodBeat.o(166260);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(166261);
        super.onPause();
        ai.a aVar = this.tTf;
        if (aVar == null) {
            kotlin.g.b.p.btv("presenter");
        }
        aVar.onUIPause();
        if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class) != null) {
            ((com.tencent.mm.plugin.ball.c.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class)).d(102, false, false);
        }
        AppMethodBeat.o(166261);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(166262);
        super.onDestroy();
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().b(104, this);
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().b(108, this);
        com.tencent.mm.kernel.g.azz().b(3761, this);
        ai.a aVar = this.tTf;
        if (aVar == null) {
            kotlin.g.b.p.btv("presenter");
        }
        aVar.onDetach();
        com.tencent.mm.plugin.finder.model.n nVar = com.tencent.mm.plugin.finder.model.n.uNU;
        com.tencent.mm.plugin.finder.model.n.release();
        com.tencent.mm.ac.d.i(p.uds);
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        String str = this.sGQ;
        if (str == null) {
            kotlin.g.b.p.btv("contextId");
        }
        com.tencent.mm.plugin.finder.report.k.gS(str, "Exit");
        AppMethodBeat.o(166262);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(166264);
        super.onActivityResult(i2, i3, intent);
        Log.i("Finder.FinderTimelineUI", "[onActivityResult] requestCode=" + i2 + " resultCode=" + i3);
        switch (i2) {
            case 500:
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.plugin.finder.view.e eVar = ((FinderCommentDrawerUIC) com.tencent.mm.ui.component.a.b(this).get(FinderCommentDrawerUIC.class)).tLT;
                if (eVar != null) {
                    eVar.d(i2, intent);
                    AppMethodBeat.o(166264);
                    return;
                }
                AppMethodBeat.o(166264);
                return;
            case 563:
                this.udf.cxh();
                AppMethodBeat.o(166264);
                return;
            case 564:
                this.qgs = FinderGlobalLocationVM.dHO();
                AppMethodBeat.o(166264);
                return;
            default:
                super.onActivityResult(i2, i3, intent);
                AppMethodBeat.o(166264);
                return;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final j udq = new j();

        static {
            AppMethodBeat.i(166243);
            AppMethodBeat.o(166243);
        }

        j() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(166242);
            Log.i("Finder.FinderTimelineUI", "initialize packageInfo:%s", BuildInfo.info());
            x xVar = x.SXb;
            AppMethodBeat.o(166242);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final p uds = new p();

        static {
            AppMethodBeat.i(166248);
            AppMethodBeat.o(166248);
        }

        p() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(166247);
            com.tencent.mm.plugin.finder.utils.j jVar = com.tencent.mm.plugin.finder.utils.j.vVA;
            com.tencent.mm.plugin.finder.utils.j.dBI();
            x xVar = x.SXb;
            AppMethodBeat.o(166247);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(FinderTimelineUI finderTimelineUI, boolean z) {
        AppMethodBeat.i(169672);
        cd cdVar = new cd(3);
        cdVar.twh = z;
        com.tencent.mm.kernel.g.azz().b(cdVar);
        com.tencent.mm.kernel.g.azz().a(3761, finderTimelineUI);
        finderTimelineUI.kkd = com.tencent.mm.ui.base.h.a((Context) finderTimelineUI, finderTimelineUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new i(finderTimelineUI, cdVar));
        AppMethodBeat.o(169672);
    }
}
