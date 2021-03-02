package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.protocal.protobuf.efl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\n\u0010(\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u001bH\u0014J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020,H\u0014J\u0018\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u000203H\u0016J,\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001b2\b\u00107\u001a\u0004\u0018\u00010\u00052\b\u00108\u001a\u0004\u0018\u000109H\u0016J(\u0010:\u001a\u00020,2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u001bJ \u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u001bH\u0002J\u0018\u0010E\u001a\u00020,2\u0006\u0010C\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u001bH\u0002J\b\u0010F\u001a\u00020,H\u0002J\b\u0010G\u001a\u00020,H\u0014J\b\u0010H\u001a\u00020,H\u0002J\b\u0010I\u001a\u00020,H\u0014J\u0012\u0010J\u001a\u00020,2\b\u0010K\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010L\u001a\u00020,H\u0014J\b\u0010M\u001a\u00020,H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000fj\b\u0012\u0004\u0012\u00020\u0005`\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, hxF = {"Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailUI;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "currentSearchId", "", "getCurrentSearchId", "()J", "setCurrentSearchId", "(J)V", "detailAdapter", "Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailAdapter;", "exposeSugSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pardusNetScene", "Lcom/tencent/mm/plugin/websearch/api/NetScenePardusSearch;", "relevantSearchLayout", "Landroid/widget/LinearLayout;", "searchResponse", "Lcom/tencent/mm/protocal/protobuf/PardusSearchResponse;", "sessionId", "getSessionId", "setSessionId", "showWebEntry", "", "webSearchBarLayout", "Landroid/view/View;", "webSearchDescTV", "Landroid/widget/TextView;", "webSearchDivider", "webSearchFooter", "webSearchLayout", "webSearchTitleTV", "createFTSBaseAdapter", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseAdapter;", "uiComponent", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;", "getFooterView", "getHint", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnd", "resultCount", "isFinished", "", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "reportSugAction", "relatedSugItem", "Lcom/tencent/mm/protocal/protobuf/FTSRelatedSugItem;", "response", "type", "reportWebSearchBarAction", "resetUI", "setNoResultView", "startPardusSearch", "startSearch", "startWebSearch", SearchIntents.EXTRA_QUERY, "stopSearch", "updateFooterView", "ui-fts_release"})
public final class FTSBizDetailUI extends FTSBaseUI implements i {
    private final String TAG = "MicroMsg.FTS.FTSBizDetailUI";
    private long sessionId = d.Ni(69);
    f xaV;
    private View xaW;
    private View xaX;
    View xaY;
    private View xaZ;
    int xat = 1;
    LinearLayout xba;
    private TextView xbb;
    private TextView xbc;
    czf xbd;
    private u xbe;
    private long xbf;
    HashSet<String> xbg = new HashSet<>();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FTSBizDetailUI() {
        AppMethodBeat.i(235440);
        AppMethodBeat.o(235440);
    }

    public static final /* synthetic */ void a(FTSBizDetailUI fTSBizDetailUI, alv alv, czf czf) {
        AppMethodBeat.i(235443);
        fTSBizDetailUI.a(alv, czf, 3);
        AppMethodBeat.o(235443);
    }

    public static final /* synthetic */ void a(FTSBizDetailUI fTSBizDetailUI, czf czf) {
        AppMethodBeat.i(235442);
        fTSBizDetailUI.a(czf, 3);
        AppMethodBeat.o(235442);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(235427);
        super.onCreate(bundle);
        com.tencent.mm.kernel.b.a ah = g.ah(n.class);
        p.g(ah, "MMKernel.plugin(IPluginFTS::class.java)");
        ((n) ah).getFTSImageLoader().dOn();
        g.azz().a(1076, this);
        com.tencent.mm.ui.search.a dPn = dPn();
        p.g(dPn, "ftsSearchView");
        dPn.getFtsEditText().gWY();
        com.tencent.mm.ui.search.a dPn2 = dPn();
        p.g(dPn2, "ftsSearchView");
        dPn2.getFtsEditText().awD();
        com.tencent.mm.ui.search.a dPn3 = dPn();
        p.g(dPn3, "ftsSearchView");
        dPn3.getFtsEditText().awC();
        AppMethodBeat.o(235427);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void onDestroy() {
        AppMethodBeat.i(235428);
        g.azz().b(1076, this);
        com.tencent.mm.kernel.b.a ah = g.ah(n.class);
        p.g(ah, "MMKernel.plugin(IPluginFTS::class.java)");
        ((n) ah).getFTSImageLoader().dOl();
        f fVar = this.xaV;
        if (fVar != null) {
            fVar.finish();
        }
        super.onDestroy();
        AppMethodBeat.o(235428);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.an0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final d a(e eVar) {
        AppMethodBeat.i(235429);
        f fVar = this.xaV;
        if (fVar != null) {
            f fVar2 = fVar;
            AppMethodBeat.o(235429);
            return fVar2;
        }
        f fVar3 = new f(this);
        this.xaV = fVar3;
        f fVar4 = fVar3;
        AppMethodBeat.o(235429);
        return fVar4;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPk() {
        AppMethodBeat.i(235430);
        super.dPk();
        TextView dPo = dPo();
        if (dPo != null) {
            dPo.setText(getString(R.string.bi3));
        }
        ListView dPi = dPi();
        p.g(dPi, "searchResultLV");
        dPi.setVisibility(0);
        AppMethodBeat.o(235430);
    }

    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final String getHint() {
        AppMethodBeat.i(235431);
        String string = getString(R.string.gga, new Object[]{getString(R.string.dje)});
        p.g(string, "getString(R.string.searc…R.string.fts_header_biz))");
        AppMethodBeat.o(235431);
        return string;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final View getFooterView() {
        AppMethodBeat.i(235432);
        this.xaW = getLayoutInflater().inflate(R.layout.ao1, (ViewGroup) null, false);
        View view = this.xaW;
        if (view != null) {
            this.xaY = view.findViewById(R.id.jkc);
            this.xaX = view.findViewById(R.id.jkf);
            this.xaZ = view.findViewById(R.id.jke);
            this.xbb = (TextView) view.findViewById(R.id.jkg);
            this.xbc = (TextView) view.findViewById(R.id.jkd);
            this.xba = (LinearLayout) view.findViewById(R.id.gzw);
        }
        View view2 = this.xaZ;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        TextView textView = this.xbc;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view3 = this.xaY;
        if (view3 != null) {
            view3.setOnClickListener(new a(this));
        }
        View view4 = this.xaW;
        AppMethodBeat.o(235432);
        return view4;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ FTSBizDetailUI xbh;

        a(FTSBizDetailUI fTSBizDetailUI) {
            this.xbh = fTSBizDetailUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(235425);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$getFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FTSBizDetailUI.a(this.xbh, this.xbh.getQuery());
            czf czf = this.xbh.xbd;
            if (czf != null) {
                FTSBizDetailUI.a(this.xbh, czf);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$getFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235425);
        }
    }

    private final void cHi() {
        efl efl;
        LinkedList<efk> linkedList;
        AppMethodBeat.i(235433);
        LinearLayout linearLayout = this.xba;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        View view = this.xaX;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.xaY;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        TextView textView = this.xbb;
        if (textView != null) {
            textView.setText(f.a(getString(R.string.dkc), getString(R.string.dju), getQuery() + "  "));
        }
        czf czf = this.xbd;
        if (!(czf == null || (efl = czf.MEy) == null || (linkedList = efl.KKx) == null)) {
            if (!(linkedList.size() > 0)) {
                linkedList = null;
            }
            if (linkedList != null) {
                int i2 = 0;
                for (T t : linkedList) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        j.hxH();
                    }
                    T t2 = t;
                    View inflate = getLayoutInflater().inflate(R.layout.ao5, (ViewGroup) this.xba, false);
                    inflate.setOnClickListener(new b(this));
                    TextView textView2 = (TextView) inflate.findViewById(R.id.be9);
                    p.g(textView2, "contentTV");
                    textView2.setText(t2.MGp);
                    alv alv = new alv();
                    alv.Lux = t2;
                    alv.xuA = i2;
                    p.g(inflate, "relatedItemView");
                    inflate.setTag(alv);
                    LinearLayout linearLayout2 = this.xba;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(inflate);
                        i2 = i3;
                    } else {
                        i2 = i3;
                    }
                }
                LinearLayout linearLayout3 = this.xba;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                    AppMethodBeat.o(235433);
                    return;
                }
                AppMethodBeat.o(235433);
                return;
            }
        }
        AppMethodBeat.o(235433);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$2$1$1", "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$$special$$inlined$forEachIndexed$lambda$1"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ FTSBizDetailUI xbh;

        b(FTSBizDetailUI fTSBizDetailUI) {
            this.xbh = fTSBizDetailUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(235426);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            p.g(view, LocaleUtil.ITALIAN);
            Object tag = view.getTag();
            if (tag != null && (tag instanceof alv)) {
                FTSBizDetailUI.a(this.xbh, ((alv) tag).Lux.MGp);
                czf czf = this.xbh.xbd;
                if (czf != null) {
                    FTSBizDetailUI.a(this.xbh, (alv) tag, czf);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235426);
        }
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.a, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void ay(int i2, boolean z) {
        AppMethodBeat.i(235434);
        super.ay(i2, z);
        cHi();
        AppMethodBeat.o(235434);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPc() {
        AppMethodBeat.i(235435);
        super.dPc();
        if (this.xbe != null) {
            g.azz().a(this.xbe);
            this.xbe = null;
        }
        this.xbf = d.Ni(69);
        cze cze = new cze();
        cze.KXA = getQuery();
        cze.SessionId = String.valueOf(this.sessionId);
        cze.Mba = String.valueOf(this.xbf);
        cze.Scene = 69;
        cze.xMB = 1;
        u uVar = new u(cze);
        g.azz().b(uVar);
        this.xbe = uVar;
        AppMethodBeat.o(235435);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void stopSearch() {
        AppMethodBeat.i(235436);
        super.stopSearch();
        this.xat = 1;
        this.xbd = null;
        View view = this.xaX;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.xaY;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        this.xbg.clear();
        if (this.xbe != null) {
            g.azz().a(this.xbe);
            this.xbe = null;
        }
        AppMethodBeat.o(235436);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        efl efl;
        LinkedList<efk> linkedList;
        Integer num = null;
        AppMethodBeat.i(235437);
        u uVar = this.xbe;
        if (uVar != null) {
            if (!p.j(qVar, uVar)) {
                uVar = null;
            }
            if (uVar != null) {
                this.xbd = uVar.fXO();
                String str3 = this.TAG;
                StringBuilder sb = new StringBuilder("onSceneEnd searchResponse GuideText:");
                czf czf = this.xbd;
                if (czf != null) {
                    str2 = czf.MEw;
                } else {
                    str2 = null;
                }
                StringBuilder append = sb.append(str2).append(" size:");
                czf czf2 = this.xbd;
                if (!(czf2 == null || (efl = czf2.MEy) == null || (linkedList = efl.KKx) == null)) {
                    num = Integer.valueOf(linkedList.size());
                }
                Log.i(str3, append.append(num).toString());
                cHi();
                AppMethodBeat.o(235437);
                return;
            }
        }
        AppMethodBeat.o(235437);
    }

    /* access modifiers changed from: package-private */
    public final void a(czf czf, int i2) {
        AppMethodBeat.i(235438);
        doc doc = new doc();
        doc.MRe = "bizsugresultreport=1&searchid=" + czf.Mbb + "&query=" + com.tencent.mm.compatible.util.q.encode(getQuery(), "utf8") + "&scene=69&businesstype=1&type=" + i2 + "&clienttimestamp=" + cl.aWA() + "&iss1sitem=1&docid=" + com.tencent.mm.compatible.util.q.encode(getQuery(), "utf8");
        Log.i(this.TAG, "reportWebSearchBarAction " + doc.MRe);
        g.azz().b(new ad(doc));
        AppMethodBeat.o(235438);
    }

    /* access modifiers changed from: package-private */
    public final void a(alv alv, czf czf, int i2) {
        AppMethodBeat.i(235439);
        doc doc = new doc();
        doc.MRe = "bizsugresultreport=1&searchid=" + czf.Mbb + "&query=" + com.tencent.mm.compatible.util.q.encode(getQuery(), "utf8") + "&scene=69&businesstype=1&type=" + i2 + "&clienttimestamp=" + cl.aWA() + "&docid=" + alv.Lux.MEq + "&sugpos=" + (alv.xuA + 1) + "&iss1sitem=0&sugresult=" + com.tencent.mm.compatible.util.q.encode(alv.Lux.MGp, "utf8");
        Log.i(this.TAG, "reportSugAction " + doc.MRe);
        g.azz().b(new ad(doc));
        AppMethodBeat.o(235439);
    }

    public static final /* synthetic */ void a(FTSBizDetailUI fTSBizDetailUI, String str) {
        String str2;
        AppMethodBeat.i(235441);
        String valueOf = String.valueOf(e.wVm);
        HashMap hashMap = new HashMap();
        hashMap.put("sceneActionType", "1");
        hashMap.put("isHomePage", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        HashMap hashMap2 = hashMap;
        ae aeVar = ae.SYK;
        Object[] objArr = new Object[4];
        objArr[0] = 35;
        czf czf = fTSBizDetailUI.xbd;
        if (czf == null || (str2 = czf.Mbb) == null) {
            str2 = "";
        }
        objArr[1] = str2;
        objArr[2] = str;
        objArr[3] = Long.valueOf(fTSBizDetailUI.xbf);
        String format = String.format("%s:%s:%s:%s", Arrays.copyOf(objArr, 4));
        p.g(format, "java.lang.String.format(format, *args)");
        hashMap2.put("parentSearchID", format);
        hashMap.put("businessType", "1");
        ((h) g.af(h.class)).a((Context) fTSBizDetailUI, 69, str, valueOf, false, (Map<String, String>) hashMap, 1);
        AppMethodBeat.o(235441);
    }
}
