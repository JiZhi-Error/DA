package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader;
import com.tencent.mm.plugin.finder.feed.z;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.y;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u001dH\u0014J\b\u0010\"\u001a\u00020\u001dH\u0014J\b\u0010#\u001a\u00020\u001dH\u0014J\u0006\u0010$\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u001dR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "lastEnterTime", "", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "presenter$delegate", "snsFeedId", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "viewCallback$delegate", "getCommentScene", "", "getLayoutId", "getReportSourceId", "getReportType", "goBack", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "reportClickPhone", "reportGoToMap", "setIconMenu", "Action", "Companion", "plugin-finder_release"})
public final class FinderPoiFeedUI extends MMFinderUI {
    public static final int tqu = 10001;
    public static final b uce = new b((byte) 0);
    private HashMap _$_findViewCache;
    private final kotlin.f tPy = kotlin.g.ah(new c(this));
    private long taC;
    private final kotlin.f ucb = kotlin.g.ah(new e(this));
    private final kotlin.f ucc = kotlin.g.ah(new j(this));
    private String ucd;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI$Action;", "", "(Ljava/lang/String;I)V", "ACTION_UNKNOWN", "ACTION_ENTER_POI_FEED_UI", "ACTION_GO_TO_MAP", "ACTION_CLICK_PHONE", "ACTION_SHARE_TO_CHAT", "ACTION_ADD_TO_FAV", "ACTION_REPORT_POI_ERROR", "ACTION_GO_TO_FINDER_PROFILE", "ACTION_LEAVE_POI_FEED_UI", "plugin-finder_release"})
    public enum a {
        ACTION_UNKNOWN,
        ACTION_ENTER_POI_FEED_UI,
        ACTION_GO_TO_MAP,
        ACTION_CLICK_PHONE,
        ACTION_SHARE_TO_CHAT,
        ACTION_ADD_TO_FAV,
        ACTION_REPORT_POI_ERROR,
        ACTION_GO_TO_FINDER_PROFILE,
        ACTION_LEAVE_POI_FEED_UI;

        static {
            AppMethodBeat.i(245448);
            AppMethodBeat.o(245448);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(245450);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(245450);
            return aVar;
        }
    }

    private final z.a del() {
        AppMethodBeat.i(245459);
        z.a aVar = (z.a) this.ucb.getValue();
        AppMethodBeat.o(245459);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245474);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245474);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245473);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245473);
        return view;
    }

    public final z.b dem() {
        AppMethodBeat.i(245460);
        z.b bVar = (z.b) this.ucc.getValue();
        AppMethodBeat.o(245460);
        return bVar;
    }

    public final FinderPoiFeedLoader den() {
        AppMethodBeat.i(245461);
        FinderPoiFeedLoader finderPoiFeedLoader = (FinderPoiFeedLoader) this.tPy.getValue();
        AppMethodBeat.o(245461);
        return finderPoiFeedLoader;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderPoiFeedUI() {
        AppMethodBeat.i(245467);
        AppMethodBeat.o(245467);
    }

    public static final /* synthetic */ FinderPoiFeedLoader b(FinderPoiFeedUI finderPoiFeedUI) {
        AppMethodBeat.i(245470);
        FinderPoiFeedLoader den = finderPoiFeedUI.den();
        AppMethodBeat.o(245470);
        return den;
    }

    public static final /* synthetic */ z.b c(FinderPoiFeedUI finderPoiFeedUI) {
        AppMethodBeat.i(245471);
        z.b dem = finderPoiFeedUI.dem();
        AppMethodBeat.o(245471);
        return dem;
    }

    public static final /* synthetic */ String d(FinderPoiFeedUI finderPoiFeedUI) {
        AppMethodBeat.i(245472);
        String deo = finderPoiFeedUI.deo();
        AppMethodBeat.o(245472);
        return deo;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI$Companion;", "", "()V", "MENU_ID_MORE", "", "MENU_ID_SHARE_TO_CHAT", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245468);
        AppMethodBeat.o(245468);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ai2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245462);
        super.onCreate(bundle);
        setBackBtn(new d(this));
        setActionbarColor(getResources().getColor(R.color.f3045c));
        setMMTitle("");
        FinderPoiFeedLoader den = den();
        eaa eaa = new eaa();
        try {
            eaa.parseFrom(getIntent().getByteArrayExtra("key_location"));
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            eaa = null;
        }
        den.tWy = eaa;
        FinderPoiFeedLoader den2 = den();
        Serializable serializableExtra = getIntent().getSerializableExtra("key_from_type");
        if (!(serializableExtra instanceof y.a)) {
            serializableExtra = null;
        }
        den2.tWz = (y.a) serializableExtra;
        this.ucd = getIntent().getStringExtra("key_sns_feed_id");
        dem().a(del());
        del().onAttach(dem());
        AppMethodBeat.o(245462);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderPoiFeedUI ucp;

        d(FinderPoiFeedUI finderPoiFeedUI) {
            this.ucp = finderPoiFeedUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245452);
            FinderPoiFeedUI.a(this.ucp);
            AppMethodBeat.o(245452);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class f implements o.f {
        final /* synthetic */ FinderPoiFeedUI ucp;

        public f(FinderPoiFeedUI finderPoiFeedUI) {
            this.ucp = finderPoiFeedUI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(245454);
            p.g(mVar, "menu");
            if (mVar.gKQ()) {
                String string = this.ucp.getContext().getString(R.string.yz);
                p.g(string, "context.getString(R.string.app_share_to_weixin)");
                boolean z = false;
                if (FinderPoiFeedUI.b(this.ucp).tWy == null) {
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    string = com.tencent.mm.plugin.finder.utils.y.dP("", R.string.d8u);
                    z = true;
                }
                AppCompatActivity context = this.ucp.getContext();
                p.g(context, "context");
                mVar.a(10002, string, R.raw.finder_icons_filled_share, context.getResources().getColor(R.color.Brand), z);
            }
            AppMethodBeat.o(245454);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class g implements o.g {
        final /* synthetic */ FinderPoiFeedUI ucp;

        public g(FinderPoiFeedUI finderPoiFeedUI) {
            this.ucp = finderPoiFeedUI;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            String str;
            AppMethodBeat.i(245455);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 10002:
                    eaa eaa = FinderPoiFeedUI.b(this.ucp).tWy;
                    String str2 = FinderPoiFeedUI.c(this.ucp).tPa;
                    if (eaa != null) {
                        k kVar = k.vfA;
                        a aVar = a.ACTION_SHARE_TO_CHAT;
                        long j2 = FinderPoiFeedUI.c(this.ucp).tPc;
                        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.ucp);
                        bbn dIx = fH != null ? fH.dIx() : null;
                        eaa eaa2 = FinderPoiFeedUI.b(this.ucp).tWy;
                        if (eaa2 != null) {
                            str = eaa2.LIb;
                        } else {
                            str = null;
                        }
                        k.a(aVar, j2, dIx, str, FinderPoiFeedUI.c(this.ucp).tPd, FinderPoiFeedUI.d(this.ucp));
                        s.a aVar3 = s.vWt;
                        FinderPoiFeedUI finderPoiFeedUI = this.ucp;
                        p.h(finderPoiFeedUI, "context");
                        p.h(eaa, FirebaseAnalytics.b.LOCATION);
                        p.h(str2, "poiCategories");
                        com.tencent.mm.plugin.finder.spam.a aVar4 = com.tencent.mm.plugin.finder.spam.a.vwk;
                        if (!com.tencent.mm.plugin.finder.spam.a.avp("share")) {
                            k.b bVar = new k.b();
                            com.tencent.mm.plugin.i.a.g gVar = new com.tencent.mm.plugin.i.a.g();
                            gVar.wDZ.LLz = String.valueOf(eaa.LbC);
                            gVar.wDZ.LLy = String.valueOf(eaa.LbD);
                            gVar.wDZ.LIb = eaa.LIb;
                            gVar.wDZ.LLA = String.valueOf(eaa.Mpu);
                            gVar.wDZ.JTr = eaa.Mpt;
                            gVar.wDZ.iUO = eaa.ErZ;
                            gVar.wDZ.kHV = eaa.kHV;
                            gVar.wDZ.tPa = str2;
                            bVar.a(gVar);
                            bVar.type = 75;
                            bVar.izD = 2;
                            bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
                            bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
                            Intent intent = new Intent();
                            intent.putExtra("Retr_Msg_Type", 28);
                            intent.putExtra("Multi_Retr", true);
                            intent.putExtra("Retr_Msg_content", k.b.a(bVar, null, null));
                            intent.putExtra("Retr_go_to_chattingUI", false);
                            intent.putExtra("Retr_show_success_tips", true);
                            com.tencent.mm.br.c.a(finderPoiFeedUI, ".ui.transmit.MsgRetransmitUI", intent, 1001, new s.a.i(aVar3, gVar));
                            break;
                        }
                    } else {
                        u.makeText(this.ucp, (int) R.string.d8u, 0).show();
                        AppMethodBeat.o(245455);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(245455);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class h implements e.b {
        public static final h ucq = new h();

        static {
            AppMethodBeat.i(245456);
            AppMethodBeat.o(245456);
        }

        h() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class i implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ com.tencent.mm.ui.widget.a.e nkZ;

        public i(com.tencent.mm.ui.widget.a.e eVar) {
            this.nkZ = eVar;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245457);
            this.nkZ.dGm();
            AppMethodBeat.o(245457);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        bbn bbn;
        String str = null;
        AppMethodBeat.i(245463);
        super.onResume();
        this.taC = cl.aWA();
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        a aVar = a.ACTION_ENTER_POI_FEED_UI;
        long j2 = dem().tPc;
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this);
        if (fH != null) {
            bbn = fH.dIx();
        } else {
            bbn = null;
        }
        eaa eaa = den().tWy;
        if (eaa != null) {
            str = eaa.LIb;
        }
        com.tencent.mm.plugin.finder.report.k.a(aVar, j2, bbn, str, dem().tPd, deo());
        AppMethodBeat.o(245463);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        bbn bbn;
        String str = null;
        AppMethodBeat.i(245464);
        super.onPause();
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        a aVar = a.ACTION_LEAVE_POI_FEED_UI;
        long j2 = dem().tPc;
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this);
        if (fH != null) {
            bbn = fH.dIx();
        } else {
            bbn = null;
        }
        eaa eaa = den().tWy;
        if (eaa != null) {
            str = eaa.LIb;
        }
        com.tencent.mm.plugin.finder.report.k.a(aVar, j2, bbn, str, dem().tPd, deo(), cl.aWA() - this.taC);
        AppMethodBeat.o(245464);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245465);
        del().onDetach();
        super.onDestroy();
        AppMethodBeat.o(245465);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 81;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 3;
    }

    public final String deo() {
        AppMethodBeat.i(245466);
        String str = this.ucd;
        if (str == null) {
            str = com.tencent.mm.model.z.aTY();
        }
        AppMethodBeat.o(245466);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "invoke"})
    static final class e extends q implements kotlin.g.a.a<z.a> {
        final /* synthetic */ FinderPoiFeedUI ucp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderPoiFeedUI finderPoiFeedUI) {
            super(0);
            this.ucp = finderPoiFeedUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ z.a invoke() {
            AppMethodBeat.i(245453);
            z.a aVar = new z.a(this.ucp, FinderPoiFeedUI.b(this.ucp));
            AppMethodBeat.o(245453);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "invoke"})
    static final class j extends q implements kotlin.g.a.a<z.b> {
        final /* synthetic */ FinderPoiFeedUI ucp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderPoiFeedUI finderPoiFeedUI) {
            super(0);
            this.ucp = finderPoiFeedUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ z.b invoke() {
            AppMethodBeat.i(245458);
            z.b bVar = new z.b(this.ucp);
            AppMethodBeat.o(245458);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<FinderPoiFeedLoader> {
        final /* synthetic */ FinderPoiFeedUI ucp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderPoiFeedUI finderPoiFeedUI) {
            super(0);
            this.ucp = finderPoiFeedUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderPoiFeedLoader invoke() {
            AppMethodBeat.i(245451);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderPoiFeedLoader finderPoiFeedLoader = new FinderPoiFeedLoader(((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.ucp).get(FinderReporterUIC.class)).dIx());
            AppMethodBeat.o(245451);
            return finderPoiFeedLoader;
        }
    }

    public static final /* synthetic */ void a(FinderPoiFeedUI finderPoiFeedUI) {
        AppMethodBeat.i(245469);
        finderPoiFeedUI.finish();
        AppMethodBeat.o(245469);
    }
}
