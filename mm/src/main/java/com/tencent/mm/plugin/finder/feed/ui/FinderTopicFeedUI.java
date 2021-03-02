package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.av;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.dcz;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.t;

public final class FinderTopicFeedUI extends MMFinderUI {
    private static ConcurrentHashMap<Long, FinderItem> tZo = new ConcurrentHashMap<>();
    public static final a udw = new a((byte) 0);
    private final String TAG = "Finder.FinderTopicFeedUI";
    private HashMap _$_findViewCache;
    private final int pLU = ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL;
    private int tTm;
    private av.a tqH;
    private av.b tqI;
    private FinderTopicFeedLoader tqJ;
    private final int tqu = 10001;
    private final int tqv = 10002;
    private bcc tvs;
    private final int udt = ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL;
    private atv udu;
    private final c udv = new c();

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245594);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245594);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245593);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245593);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderTopicFeedUI() {
        AppMethodBeat.i(245589);
        AppMethodBeat.o(245589);
    }

    public static final /* synthetic */ av.a e(FinderTopicFeedUI finderTopicFeedUI) {
        AppMethodBeat.i(166282);
        av.a aVar = finderTopicFeedUI.tqH;
        if (aVar == null) {
            p.btv("presenter");
        }
        AppMethodBeat.o(166282);
        return aVar;
    }

    public static final /* synthetic */ FinderTopicFeedLoader g(FinderTopicFeedUI finderTopicFeedUI) {
        AppMethodBeat.i(245591);
        FinderTopicFeedLoader finderTopicFeedLoader = finderTopicFeedUI.tqJ;
        if (finderTopicFeedLoader == null) {
            p.btv("feedLoader");
        }
        AppMethodBeat.o(245591);
        return finderTopicFeedLoader;
    }

    public static final /* synthetic */ av.b h(FinderTopicFeedUI finderTopicFeedUI) {
        AppMethodBeat.i(245592);
        av.b bVar = finderTopicFeedUI.tqI;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(245592);
        return bVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(178306);
        AppMethodBeat.o(178306);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.akp;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        boolean z;
        com.tencent.mm.bw.b bVar;
        v vVar;
        FinderTopicFeedLoader.e eVar;
        String str;
        ArrayList<bo> arrayList;
        AppMethodBeat.i(166276);
        super.onCreate(bundle);
        overridePendingTransition(R.anim.eq, R.anim.s);
        setBackBtn(new b(this));
        setActionbarColor(getResources().getColor(R.color.f3045c));
        tZo.clear();
        int intExtra = getIntent().getIntExtra("key_topic_type", 1);
        String stringExtra = getIntent().getStringExtra("key_topic_title");
        String stringExtra2 = getIntent().getStringExtra("KEY_FOLLOW_ID");
        getIntent().getStringExtra("KEY_MUSIC_INFO");
        long longExtra = getIntent().getLongExtra("KEY_TOPIC_ID", 0);
        String stringExtra3 = getIntent().getStringExtra("KEY_TOPIC_NONCE_ID");
        this.tTm = getIntent().getIntExtra("KEY_TAB_TYPE", 0);
        Log.i(this.TAG, "type:" + intExtra + ", topic:" + stringExtra);
        setMMTitle("");
        bcc bcc = new bcc();
        try {
            bcc.parseFrom(getIntent().getByteArrayExtra("KEY_SECTION_INFO"));
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            bcc = null;
        }
        this.tvs = bcc;
        atv atv = new atv();
        try {
            atv.parseFrom(getIntent().getByteArrayExtra("KEY_TOPIC_RSP"));
        } catch (Exception e3) {
            Log.printDebugStack("safeParser", "", e3);
            atv = null;
        }
        this.udu = atv;
        p.g(stringExtra, "topic");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderTopicFeedLoader finderTopicFeedLoader = new FinderTopicFeedLoader(intExtra, stringExtra, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx());
        Intent intent = getIntent();
        p.g(intent, "intent");
        finderTopicFeedLoader.initFromCache(intent);
        finderTopicFeedLoader.tTG = stringExtra2;
        this.tqJ = finderTopicFeedLoader;
        FinderTopicFeedUI finderTopicFeedUI = this;
        getCommentScene();
        FinderTopicFeedLoader finderTopicFeedLoader2 = this.tqJ;
        if (finderTopicFeedLoader2 == null) {
            p.btv("feedLoader");
        }
        av.a aVar2 = new av.a(finderTopicFeedUI, finderTopicFeedLoader2);
        aVar2.atn(stringExtra);
        aVar2.type = intExtra;
        this.tqH = aVar2;
        av.a aVar3 = this.tqH;
        if (aVar3 == null) {
            p.btv("presenter");
        }
        aVar3.tTm = this.tTm;
        av.b bVar2 = new av.b(this, getCommentScene(), (byte) 0);
        bVar2.atn(stringExtra);
        bVar2.type = intExtra;
        bVar2.tTG = stringExtra2;
        bVar2.twp = longExtra;
        bVar2.twq = stringExtra3;
        this.tqI = bVar2;
        av.b bVar3 = this.tqI;
        if (bVar3 == null) {
            p.btv("viewCallback");
        }
        av.a aVar4 = this.tqH;
        if (aVar4 == null) {
            p.btv("presenter");
        }
        bVar3.a(aVar4);
        av.b bVar4 = this.tqI;
        if (bVar4 == null) {
            p.btv("viewCallback");
        }
        if (this.udu == null) {
            z = true;
        } else {
            z = false;
        }
        bVar4.tTJ = z;
        av.a aVar5 = this.tqH;
        if (aVar5 == null) {
            p.btv("presenter");
        }
        av.b bVar5 = this.tqI;
        if (bVar5 == null) {
            p.btv("viewCallback");
        }
        aVar5.a(bVar5);
        if (!(this.udu == null || this.udu == null)) {
            av.a aVar6 = this.tqH;
            if (aVar6 == null) {
                p.btv("presenter");
            }
            atv atv2 = this.udu;
            if (atv2 == null) {
                p.hyc();
            }
            bcc bcc2 = this.tvs;
            p.h(atv2, "rsp");
            FinderTopicFeedLoader.e eVar2 = new FinderTopicFeedLoader.e(0, 0, null, null);
            com.tencent.mm.plugin.finder.feed.model.h cache = aVar6.tFM.getCache();
            if (cache != null) {
                bVar = cache.lastBuffer;
            } else {
                bVar = null;
            }
            eVar2.setLastBuffer(bVar);
            eVar2.tTn = atv2.tTn;
            y yVar = y.vXH;
            com.tencent.mm.plugin.finder.feed.model.h cache2 = aVar6.tFM.getCache();
            if (cache2 == null || (arrayList = cache2.kgc) == null) {
                vVar = v.SXr;
                eVar = eVar2;
            } else {
                vVar = arrayList;
                eVar = eVar2;
            }
            eVar.setIncrementList(y.a(vVar, BaseFinderFeed.class));
            eVar2.setHasMore(true);
            eVar2.tXS = atv2.tTT;
            eVar2.setPullType(1);
            dcz dcz = atv2.LEI;
            if (dcz == null || (str = dcz.MIg) == null) {
                str = "";
            }
            eVar2.oqZ = str;
            BaseFinderFeedLoader baseFinderFeedLoader = aVar6.tFM;
            if (baseFinderFeedLoader == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
                AppMethodBeat.o(166276);
                throw tVar;
            }
            ((FinderTopicFeedLoader) baseFinderFeedLoader).tvs = bcc2;
            aVar6.tFM.onFetchDone(eVar2);
        }
        com.tencent.mm.ui.widget.a.e eVar3 = new com.tencent.mm.ui.widget.a.e((Context) this, 0, false);
        eVar3.a(new d(this));
        eVar3.a(new e(this));
        av.a aVar7 = this.tqH;
        if (aVar7 == null) {
            p.btv("presenter");
        }
        if (aVar7.type == 4) {
            eVar3.b(new f(this));
            eVar3.b(new g(this));
        }
        eVar3.b(h.udy);
        addIconOptionMenu(this.tqu, R.drawable.bw_, new i(eVar3));
        int intExtra2 = getIntent().getIntExtra("key_report_scene", 0);
        if (intExtra2 != 0) {
            String stringExtra4 = getIntent().getStringExtra("key_from_user");
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            k kVar = k.vfA;
            k.e(intExtra2, stringExtra4, stringExtra, intExtra);
            if (getIntent().getIntExtra("key_topic_type", 1) == 4) {
                k kVar2 = k.vfA;
                k.a(getIntent().getLongExtra("key_ref_object_id", 0), intExtra2, 4L, stringExtra4, 0, 2);
            }
        }
        av.b bVar6 = this.tqI;
        if (bVar6 == null) {
            p.btv("viewCallback");
        }
        bVar6.tLS.getRecyclerView().a(this.udv);
        AppMethodBeat.o(166276);
    }

    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderTopicFeedUI udx;

        b(FinderTopicFeedUI finderTopicFeedUI) {
            this.udx = finderTopicFeedUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(166270);
            FinderTopicFeedUI.a(this.udx);
            AppMethodBeat.o(166270);
            return true;
        }
    }

    static final class d implements o.f {
        final /* synthetic */ FinderTopicFeedUI udx;

        d(FinderTopicFeedUI finderTopicFeedUI) {
            this.udx = finderTopicFeedUI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(166272);
            p.g(mVar, "menu");
            if (mVar.gKQ()) {
                String string = this.udx.getContext().getString(R.string.yz);
                p.g(string, "context.getString(R.string.app_share_to_weixin)");
                String string2 = this.udx.getContext().getString(R.string.d9p);
                p.g(string2, "context.getString(R.string.finder_share_timeline)");
                if (FinderTopicFeedUI.b(this.udx)) {
                    y yVar = y.vXH;
                    string = y.dP("", R.string.d8u);
                    y yVar2 = y.vXH;
                    string2 = y.dP("", R.string.d8v);
                    z = true;
                    z2 = true;
                } else {
                    z = false;
                    z2 = false;
                }
                AppCompatActivity context = this.udx.getContext();
                p.g(context, "context");
                mVar.a(this.udx.tqv, string, R.raw.finder_icons_filled_share, context.getResources().getColor(R.color.Brand), z2);
                mVar.a(this.udx.pLU, string2, R.raw.bottomsheet_icon_moment, 0, z);
            }
            AppMethodBeat.o(166272);
        }
    }

    static final class e implements o.g {
        final /* synthetic */ FinderTopicFeedUI udx;

        e(FinderTopicFeedUI finderTopicFeedUI) {
            this.udx = finderTopicFeedUI;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(166273);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId != this.udx.tqv) {
                if (itemId == this.udx.pLU) {
                    if (FinderTopicFeedUI.b(this.udx)) {
                        u.makeText(this.udx, (int) R.string.d8v, 0).show();
                        AppMethodBeat.o(166273);
                        return;
                    } else if (FinderTopicFeedUI.e(this.udx).type == 4) {
                        s.a aVar = s.vWt;
                        s.a.a(this.udx, FinderTopicFeedUI.f(this.udx), FinderTopicFeedUI.e(this.udx).type, FinderTopicFeedUI.e(this.udx).tTn, FinderTopicFeedUI.e(this.udx).getIconUrl(), this.udx.getString(R.string.dah, new Object[]{com.tencent.mm.plugin.finder.utils.k.Gb(FinderTopicFeedUI.e(this.udx).tTn)}), FinderTopicFeedUI.g(this.udx).tXM, 49, FinderTopicFeedUI.h(this.udx).tTG);
                        AppMethodBeat.o(166273);
                        return;
                    } else {
                        s.a aVar2 = s.vWt;
                        s.a.a(this.udx, FinderTopicFeedUI.e(this.udx).dST, FinderTopicFeedUI.e(this.udx).type, FinderTopicFeedUI.e(this.udx).tTn, FinderTopicFeedUI.e(this.udx).getIconUrl(), this.udx.getString(R.string.dah, new Object[]{com.tencent.mm.plugin.finder.utils.k.Gb(FinderTopicFeedUI.e(this.udx).tTn)}), FinderTopicFeedUI.g(this.udx).tXM, 9, "");
                    }
                }
                AppMethodBeat.o(166273);
            } else if (FinderTopicFeedUI.b(this.udx)) {
                u.makeText(this.udx, (int) R.string.d8u, 0).show();
                AppMethodBeat.o(166273);
            } else if (FinderTopicFeedUI.e(this.udx).type == 4) {
                s.a.a(s.vWt, this.udx, FinderTopicFeedUI.f(this.udx), FinderTopicFeedUI.e(this.udx).type, FinderTopicFeedUI.e(this.udx).tTn, FinderTopicFeedUI.e(this.udx).getIconUrl(), this.udx.getString(R.string.dah, new Object[]{com.tencent.mm.plugin.finder.utils.k.Gb(FinderTopicFeedUI.e(this.udx).tTn)}), FinderTopicFeedUI.g(this.udx).tXM, 49, FinderTopicFeedUI.h(this.udx).tTG);
                AppMethodBeat.o(166273);
            } else {
                s.a.a(s.vWt, this.udx, FinderTopicFeedUI.e(this.udx).dST, FinderTopicFeedUI.e(this.udx).type, FinderTopicFeedUI.e(this.udx).tTn, FinderTopicFeedUI.e(this.udx).getIconUrl(), this.udx.getString(R.string.dah, new Object[]{com.tencent.mm.plugin.finder.utils.k.Gb(FinderTopicFeedUI.e(this.udx).tTn)}), FinderTopicFeedUI.g(this.udx).tXM, 9, "");
                AppMethodBeat.o(166273);
            }
        }
    }

    static final class f implements o.f {
        final /* synthetic */ FinderTopicFeedUI udx;

        f(FinderTopicFeedUI finderTopicFeedUI) {
            this.udx = finderTopicFeedUI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(245582);
            p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.b(this.udx.udt, this.udx.getContext().getString(R.string.f3g), R.raw.icons_outlined_report_problem);
            }
            AppMethodBeat.o(245582);
        }
    }

    static final class g implements o.g {
        final /* synthetic */ FinderTopicFeedUI udx;

        g(FinderTopicFeedUI finderTopicFeedUI) {
            this.udx = finderTopicFeedUI;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            String str;
            AppMethodBeat.i(245583);
            p.g(menuItem, "menuItem");
            if (menuItem.getItemId() != this.udx.udt || (str = FinderTopicFeedUI.h(this.udx).tTG) == null) {
                AppMethodBeat.o(245583);
                return;
            }
            com.tencent.mm.plugin.finder.feed.logic.a aVar = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
            com.tencent.mm.plugin.finder.feed.logic.a.aC(this.udx, str);
            AppMethodBeat.o(245583);
        }
    }

    static final class h implements e.b {
        public static final h udy = new h();

        static {
            AppMethodBeat.i(245584);
            AppMethodBeat.o(245584);
        }

        h() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
        }
    }

    static final class i implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ com.tencent.mm.ui.widget.a.e nkZ;

        i(com.tencent.mm.ui.widget.a.e eVar) {
            this.nkZ = eVar;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245585);
            this.nkZ.dGm();
            AppMethodBeat.o(245585);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(166278);
        av.a aVar = this.tqH;
        if (aVar == null) {
            p.btv("presenter");
        }
        aVar.onDetach();
        tZo.clear();
        av.b bVar = this.tqI;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        bVar.tLS.getRecyclerView().b(this.udv);
        super.onDestroy();
        AppMethodBeat.o(166278);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(245586);
        int intExtra = getIntent().getIntExtra("key_topic_type", 1);
        if (intExtra == 1) {
            AppMethodBeat.o(245586);
            return 22;
        } else if (intExtra == 4) {
            AppMethodBeat.o(245586);
            return 49;
        } else if (intExtra == 5) {
            AppMethodBeat.o(245586);
            return 64;
        } else {
            AppMethodBeat.o(245586);
            return 26;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(245587);
        super.onResume();
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "26", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        AppMethodBeat.o(245587);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(245588);
        super.onPause();
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "26", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        AppMethodBeat.o(245588);
    }

    public static final class c extends RecyclerView.l {
        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(245581);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(245581);
        }

        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(245580);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "26", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(245580);
        }
    }

    public static final /* synthetic */ void a(FinderTopicFeedUI finderTopicFeedUI) {
        AppMethodBeat.i(166279);
        finderTopicFeedUI.finish();
        AppMethodBeat.o(166279);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ boolean b(com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI r6) {
        /*
            r5 = 166281(0x28989, float:2.3301E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.tencent.mm.plugin.finder.feed.av$a r0 = r6.tqH
            if (r0 != 0) goto L_0x0010
            java.lang.String r1 = "presenter"
            kotlin.g.b.p.btv(r1)
        L_0x0010:
            java.lang.String r0 = r0.dST
            boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r0 != 0) goto L_0x002c
            com.tencent.mm.plugin.finder.feed.av$a r0 = r6.tqH
            if (r0 != 0) goto L_0x0022
            java.lang.String r1 = "presenter"
            kotlin.g.b.p.btv(r1)
        L_0x0022:
            java.lang.String r0 = r0.getIconUrl()
            boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r0 == 0) goto L_0x0061
        L_0x002c:
            r0 = 1
        L_0x002d:
            java.lang.String r1 = r6.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "notShare "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = ", "
            java.lang.StringBuilder r2 = r2.append(r3)
            com.tencent.mm.plugin.finder.feed.av$a r3 = r6.tqH
            if (r3 != 0) goto L_0x004c
            java.lang.String r4 = "presenter"
            kotlin.g.b.p.btv(r4)
        L_0x004c:
            java.lang.String r3 = r3.dST
            boolean r3 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r3)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.tencent.mm.sdk.platformtools.Log.i(r1, r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return r0
        L_0x0061:
            r0 = 0
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI.b(com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (r0 == null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.String f(com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI r7) {
        /*
            r0 = 0
            r6 = 245590(0x3bf56, float:3.44145E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.mm.plugin.finder.feed.av$a r1 = r7.tqH
            if (r1 != 0) goto L_0x0011
            java.lang.String r2 = "presenter"
            kotlin.g.b.p.btv(r2)
        L_0x0011:
            com.tencent.mm.protocal.protobuf.bdr r1 = r1.bgmInfo
            if (r1 == 0) goto L_0x0025
            com.tencent.mm.protocal.protobuf.azk r2 = r1.musicInfo
            if (r2 == 0) goto L_0x0037
            com.tencent.mm.protocal.protobuf.azk r1 = r1.musicInfo
            if (r1 == 0) goto L_0x001f
            java.lang.String r0 = r1.name
        L_0x001f:
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L_0x0023:
            if (r0 != 0) goto L_0x0033
        L_0x0025:
            com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI r7 = (com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI) r7
            com.tencent.mm.plugin.finder.feed.av$a r0 = r7.tqH
            if (r0 != 0) goto L_0x0031
            java.lang.String r1 = "presenter"
            kotlin.g.b.p.btv(r1)
        L_0x0031:
            java.lang.String r0 = r0.dST
        L_0x0033:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return r0
        L_0x0037:
            android.support.v7.app.AppCompatActivity r2 = r7.getContext()
            r3 = 2131759788(0x7f1012ac, float:1.9150578E38)
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            com.tencent.mm.protocal.protobuf.FinderContact r1 = r1.contact
            if (r1 == 0) goto L_0x0048
            java.lang.String r0 = r1.nickname
        L_0x0048:
            r4[r5] = r0
            java.lang.String r0 = r2.getString(r3, r4)
            java.lang.String r1 = "context.getString(R.stri…tle,it.contact?.nickname)"
            kotlin.g.b.p.g(r0, r1)
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI.f(com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI):java.lang.String");
    }
}
