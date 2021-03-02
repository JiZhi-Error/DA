package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.w;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.card.model.a.a;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.protocal.protobuf.agl;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0014J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020\u001dH\u0014J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\tH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\u0012\u0010'\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u001dH\u0014J\u0018\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020\u001dH\u0002J\u001a\u0010/\u001a\u00020\u001d2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0002J\u0012\u00104\u001a\u00020\u001d2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0017\u00105\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u00107J\u0012\u00108\u001a\u00020\u001d2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\b\u0010;\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "isAll", "isLoading", "isShowClearBtn", "mInvalidTicketList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "getMTicketAdapter", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "setMTicketAdapter", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;)V", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getMTicketRv", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "setMTicketRv", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;)V", "offset", "", "reqNum", "doClearInvalidTicketList", "", "doDeleteInvalidTicket", "cardId", "", "doGetInvalidTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "invalidTicketIds", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "showDeleteCardAlert", "ticketElement", "Lcom/tencent/mm/protocal/protobuf/PageTicketElement;", "item", "Landroid/view/View;", "showDeleteConfirmDialog", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateModelList", "ticketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "updateOptionMenu", "Companion", "plugin-card_release"})
public final class CardInvalidTicketListUI extends CardNewBaseUI {
    public static final a qgj = new a((byte) 0);
    private boolean gWt = true;
    private q gxX;
    private boolean isLoading;
    private int offset;
    private int qeS = 10;
    private boolean qeT;
    public LoadMoreRecyclerView qgf;
    public a qgg;
    private ArrayList<b> qgh = new ArrayList<>();
    private boolean qgi;

    static {
        AppMethodBeat.i(112498);
        AppMethodBeat.o(112498);
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CardInvalidTicketListUI qgk;
        final /* synthetic */ String qgl;

        b(CardInvalidTicketListUI cardInvalidTicketListUI, String str) {
            this.qgk = cardInvalidTicketListUI;
            this.qgl = str;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(112477);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.CardInvalidTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                agl agl = (agl) aVar.iLC;
                Log.i("MicroMsg.CardInvalidTicketListUI", "retCode: %s", Integer.valueOf(agl.pTZ));
                if (agl.pTZ == 0) {
                    this.qgk.cxe().ajO(this.qgl);
                } else {
                    com.tencent.mm.plugin.card.d.l.aq(this.qgk, agl.pUa);
                }
            } else {
                com.tencent.mm.plugin.card.d.l.ar(this.qgk, "");
            }
            CardInvalidTicketListUI.a(this.qgk, Boolean.FALSE);
            x xVar = x.SXb;
            AppMethodBeat.o(112477);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktInvalidTicketHomePageResponse;", "call"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CardInvalidTicketListUI qgk;

        c(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.qgk = cardInvalidTicketListUI;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(112478);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.CardInvalidTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            this.qgk.isLoading = false;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                T t = aVar.iLC;
                bqs bqs = (bqs) t;
                Log.i("MicroMsg.CardInvalidTicketListUI", "retCode: %s", Integer.valueOf(bqs.pTZ));
                if (bqs.pTZ == 0) {
                    this.qgk.offset = bqs.qGg;
                    CardInvalidTicketListUI cardInvalidTicketListUI = this.qgk;
                    if (bqs.LUO == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cardInvalidTicketListUI.qeT = z;
                    CardInvalidTicketListUI cardInvalidTicketListUI2 = this.qgk;
                    if (bqs.LYo == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    cardInvalidTicketListUI2.qgi = z2;
                    CardInvalidTicketListUI.d(this.qgk);
                    if (this.qgk.qeT) {
                        this.qgk.cxd().showLoading(false);
                    } else {
                        this.qgk.cxd().showLoading(true);
                    }
                    if (this.qgk.gWt) {
                        this.qgk.qgh.clear();
                        this.qgk.gWt = false;
                    }
                    CardInvalidTicketListUI.a(this.qgk, bqs.LYn);
                } else {
                    if (this.qgk.gWt) {
                        this.qgk.gWt = false;
                    }
                    com.tencent.mm.plugin.card.d.l.aq(this.qgk, bqs.pUa);
                }
                AppMethodBeat.o(112478);
                return t;
            }
            if (this.qgk.gWt) {
                this.qgk.gWt = false;
            }
            com.tencent.mm.plugin.card.d.l.ar(this.qgk, "");
            x xVar = x.SXb;
            AppMethodBeat.o(112478);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public CardInvalidTicketListUI() {
        AppMethodBeat.i(112497);
        AppMethodBeat.o(112497);
    }

    public static final /* synthetic */ void a(CardInvalidTicketListUI cardInvalidTicketListUI) {
        AppMethodBeat.i(112499);
        cardInvalidTicketListUI.cxf();
        AppMethodBeat.o(112499);
    }

    public static final /* synthetic */ void a(CardInvalidTicketListUI cardInvalidTicketListUI, cys cys) {
        AppMethodBeat.i(112503);
        cardInvalidTicketListUI.a(cys);
        AppMethodBeat.o(112503);
    }

    public static final /* synthetic */ void a(CardInvalidTicketListUI cardInvalidTicketListUI, Boolean bool) {
        AppMethodBeat.i(201398);
        cardInvalidTicketListUI.j(bool);
        AppMethodBeat.o(201398);
    }

    public final LoadMoreRecyclerView cxd() {
        AppMethodBeat.i(112489);
        LoadMoreRecyclerView loadMoreRecyclerView = this.qgf;
        if (loadMoreRecyclerView == null) {
            p.btv("mTicketRv");
        }
        AppMethodBeat.o(112489);
        return loadMoreRecyclerView;
    }

    public final a cxe() {
        AppMethodBeat.i(112490);
        a aVar = this.qgg;
        if (aVar == null) {
            p.btv("mTicketAdapter");
        }
        AppMethodBeat.o(112490);
        return aVar;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(112491);
        fixStatusbar(true);
        super.onCreate(bundle);
        hideActionbarLine();
        initView();
        cys cys = new cys();
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        p.h(cys, "invalidTicketList");
        Log.d(com.tencent.mm.plugin.card.model.a.a.TAG, "load invalid ticket page snapshot");
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String str = (String) aAh.azQ().i(ar.a.USERINFO_CARD_INVALID_TICKET_STRING_SYNC);
        if (str != null) {
            Charset charset = kotlin.n.d.ISO_8859_1;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(112491);
                throw tVar;
            }
            byte[] bytes = str.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            cys.parseFrom(bytes);
        }
        a(cys);
        setMMTitle(R.string.hoc);
        setBackBtn(new g(this));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 9);
        AppMethodBeat.o(112491);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class g implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ CardInvalidTicketListUI qgk;

        g(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.qgk = cardInvalidTicketListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(112484);
            this.qgk.finish();
            AppMethodBeat.o(112484);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(112492);
        View findViewById = findViewById(R.id.bjb);
        p.g(findViewById, "findViewById(R.id.ctlu_rv)");
        this.qgf = (LoadMoreRecyclerView) findViewById;
        this.qgg = new a(true);
        a aVar = this.qgg;
        if (aVar == null) {
            p.btv("mTicketAdapter");
        }
        aVar.au(true);
        LoadMoreRecyclerView loadMoreRecyclerView = this.qgf;
        if (loadMoreRecyclerView == null) {
            p.btv("mTicketRv");
        }
        a aVar2 = this.qgg;
        if (aVar2 == null) {
            p.btv("mTicketAdapter");
        }
        loadMoreRecyclerView.setAdapter(aVar2);
        LoadMoreRecyclerView loadMoreRecyclerView2 = this.qgf;
        if (loadMoreRecyclerView2 == null) {
            p.btv("mTicketRv");
        }
        getContext();
        loadMoreRecyclerView2.setLayoutManager(new LinearLayoutManager());
        LoadMoreRecyclerView loadMoreRecyclerView3 = this.qgf;
        if (loadMoreRecyclerView3 == null) {
            p.btv("mTicketRv");
        }
        loadMoreRecyclerView3.setEmptyView(findViewById(R.id.b1h));
        LoadMoreRecyclerView loadMoreRecyclerView4 = this.qgf;
        if (loadMoreRecyclerView4 == null) {
            p.btv("mTicketRv");
        }
        TextView textView = (TextView) loadMoreRecyclerView4.getEmptyView().findViewById(R.id.b1i);
        p.g(textView, "emptyTv");
        textView.setText(getString(R.string.aq1));
        LoadMoreRecyclerView loadMoreRecyclerView5 = this.qgf;
        if (loadMoreRecyclerView5 == null) {
            p.btv("mTicketRv");
        }
        WeImageView weImageView = (WeImageView) loadMoreRecyclerView5.getEmptyView().findViewById(R.id.b1g);
        weImageView.setImageResource(R.raw.icon_history_card_empty);
        weImageView.setIconColor(getResources().getColor(R.color.FG_2));
        w wVar = new w(this, 1);
        wVar.setDrawable(getResources().getDrawable(R.drawable.lc));
        LoadMoreRecyclerView loadMoreRecyclerView6 = this.qgf;
        if (loadMoreRecyclerView6 == null) {
            p.btv("mTicketRv");
        }
        loadMoreRecyclerView6.b(wVar);
        LoadMoreRecyclerView loadMoreRecyclerView7 = this.qgf;
        if (loadMoreRecyclerView7 == null) {
            p.btv("mTicketRv");
        }
        loadMoreRecyclerView7.setLoadingView(R.layout.nc);
        LoadMoreRecyclerView loadMoreRecyclerView8 = this.qgf;
        if (loadMoreRecyclerView8 == null) {
            p.btv("mTicketRv");
        }
        loadMoreRecyclerView8.setOnLoadingStateChangedListener(new d(this));
        LoadMoreRecyclerView loadMoreRecyclerView9 = this.qgf;
        if (loadMoreRecyclerView9 == null) {
            p.btv("mTicketRv");
        }
        loadMoreRecyclerView9.setOnItemClickListener(new e(this));
        LoadMoreRecyclerView loadMoreRecyclerView10 = this.qgf;
        if (loadMoreRecyclerView10 == null) {
            p.btv("mTicketRv");
        }
        loadMoreRecyclerView10.setOnItemLongClickListener(new f(this));
        AppMethodBeat.o(112492);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    public static final class d implements LoadMoreRecyclerView.a {
        final /* synthetic */ CardInvalidTicketListUI qgk;

        d(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.qgk = cardInvalidTicketListUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a
        public final void bYy() {
            AppMethodBeat.i(112479);
            CardInvalidTicketListUI.a(this.qgk);
            AppMethodBeat.o(112479);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    public static final class e implements MRecyclerView.a {
        final /* synthetic */ CardInvalidTicketListUI qgk;

        e(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.qgk = cardInvalidTicketListUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a
        public final void S(View view, int i2) {
            AppMethodBeat.i(112480);
            Log.i("MicroMsg.CardInvalidTicketListUI", "click item");
            b EB = this.qgk.cxe().EB(i2);
            if (EB != null) {
                switch (EB.type) {
                    case 2:
                        cyp cyp = EB.qgG;
                        if (cyp != null) {
                            CardInvalidTicketListUI cardInvalidTicketListUI = this.qgk;
                            String str = cyp.KDM;
                            p.g(str, "user_card_id");
                            CardInvalidTicketListUI.a(cardInvalidTicketListUI, str);
                            AppMethodBeat.o(112480);
                            return;
                        }
                        break;
                }
                AppMethodBeat.o(112480);
                return;
            }
            AppMethodBeat.o(112480);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
    public static final class f implements MRecyclerView.b {
        final /* synthetic */ CardInvalidTicketListUI qgk;

        f(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.qgk = cardInvalidTicketListUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b
        public final boolean T(View view, int i2) {
            AppMethodBeat.i(112483);
            Log.i("MicroMsg.CardInvalidTicketListUI", "long click item");
            b EB = this.qgk.cxe().EB(i2);
            if (EB != null) {
                switch (EB.type) {
                    case 2:
                        cyp cyp = EB.qgG;
                        CardInvalidTicketListUI cardInvalidTicketListUI = this.qgk;
                        p.g(view, "view");
                        CardInvalidTicketListUI.a(cardInvalidTicketListUI, cyp, view);
                        break;
                }
            }
            AppMethodBeat.o(112483);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$showDeleteCardAlert$1$1"})
    public static final class h implements View.OnCreateContextMenuListener {
        final /* synthetic */ CardInvalidTicketListUI qgk;
        final /* synthetic */ View qgm;
        final /* synthetic */ cyp qgn;

        h(CardInvalidTicketListUI cardInvalidTicketListUI, View view, cyp cyp) {
            this.qgk = cardInvalidTicketListUI;
            this.qgm = view;
            this.qgn = cyp;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(201390);
            contextMenu.add(0, 1, 0, this.qgk.getString(R.string.tf));
            AppMethodBeat.o(201390);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$showDeleteCardAlert$1$2"})
    public static final class i implements o.g {
        final /* synthetic */ CardInvalidTicketListUI qgk;
        final /* synthetic */ View qgm;
        final /* synthetic */ cyp qgn;

        i(CardInvalidTicketListUI cardInvalidTicketListUI, View view, cyp cyp) {
            this.qgk = cardInvalidTicketListUI;
            this.qgm = view;
            this.qgn = cyp;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(201391);
            CardInvalidTicketListUI.a(this.qgk, this.qgn);
            AppMethodBeat.o(201391);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class j implements o.f {
        final /* synthetic */ CardInvalidTicketListUI qgk;

        j(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.qgk = cardInvalidTicketListUI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(201392);
            mVar.a(1, this.qgk.getResources().getColor(R.color.a5e), this.qgk.getString(R.string.tf));
            AppMethodBeat.o(201392);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    public static final class k implements o.g {
        final /* synthetic */ CardInvalidTicketListUI qgk;
        final /* synthetic */ cyp qgo;

        k(CardInvalidTicketListUI cardInvalidTicketListUI, cyp cyp) {
            this.qgk = cardInvalidTicketListUI;
            this.qgo = cyp;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(201393);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 1:
                    CardInvalidTicketListUI cardInvalidTicketListUI = this.qgk;
                    cyp cyp = this.qgo;
                    if (cyp == null) {
                        p.hyc();
                    }
                    String str = cyp.KDM;
                    p.g(str, "ticketElement!!.user_card_id");
                    CardInvalidTicketListUI.b(cardInvalidTicketListUI, str);
                    break;
            }
            AppMethodBeat.o(201393);
        }
    }

    private final void j(Boolean bool) {
        q qVar;
        AppMethodBeat.i(201394);
        if (bool == null) {
            AppMethodBeat.o(201394);
            return;
        }
        if (bool.booleanValue()) {
            qVar = q.a(getContext(), getString(R.string.a06), true, 3, null);
        } else {
            q qVar2 = this.gxX;
            if (qVar2 != null) {
                qVar2.dismiss();
            }
            qVar = null;
        }
        this.gxX = qVar;
        AppMethodBeat.o(201394);
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(112493);
        super.onDestroy();
        cys cys = new cys();
        cys.MDL = new LinkedList<>();
        Iterator<b> it = this.qgh.iterator();
        while (it.hasNext()) {
            cyp cyp = it.next().qgG;
            if (cyp != null) {
                cys.MDL.add(cyp);
            }
        }
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        p.h(cys, "invalidTicketList");
        Log.d(com.tencent.mm.plugin.card.model.a.a.TAG, "save invalid ticket snapshot");
        byte[] byteArray = cys.toByteArray();
        p.g(byteArray, "invalidTicketList.toByteArray()");
        String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_CARD_INVALID_TICKET_STRING_SYNC, str);
        AppMethodBeat.o(112493);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.p8;
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI
    public final void ad(int i2, boolean z) {
        AppMethodBeat.i(112494);
        Log.i("MicroMsg.CardInvalidTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", Float.valueOf(this.latitude), Float.valueOf(this.dTj), Integer.valueOf(i2), Boolean.valueOf(z));
        if (this.gWt) {
            cxf();
            AppMethodBeat.o(112494);
            return;
        }
        if (!z) {
            cxi();
        }
        AppMethodBeat.o(112494);
    }

    private final void a(cys cys) {
        AppMethodBeat.i(112495);
        if (cys != null) {
            LinkedList<cyp> linkedList = cys.MDL;
            p.g(linkedList, "page_ticket_element");
            if (!linkedList.isEmpty()) {
                Iterator<cyp> it = cys.MDL.iterator();
                while (it.hasNext()) {
                    b bVar = new b();
                    bVar.qgG = it.next();
                    bVar.type = 2;
                    this.qgh.add(bVar);
                }
            }
        }
        a aVar = this.qgg;
        if (aVar == null) {
            p.btv("mTicketAdapter");
        }
        aVar.a(null, this.qgh, null, null);
        AppMethodBeat.o(112495);
    }

    private final void cxf() {
        AppMethodBeat.i(112496);
        Log.i("MicroMsg.CardInvalidTicketListUI", "do get invalid ticket: %s, %s, %s, %s", Integer.valueOf(this.offset), Integer.valueOf(this.qeS), Boolean.valueOf(this.qeT), Boolean.valueOf(this.isLoading));
        if (!this.qeT && !this.isLoading) {
            this.isLoading = true;
            new com.tencent.mm.plugin.card.model.a.h(this.offset, this.qeS, (double) this.latitude, (double) this.dTj).aYI().b(new c(this));
        }
        AppMethodBeat.o(112496);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class l implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ CardInvalidTicketListUI qgk;

        l(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.qgk = cardInvalidTicketListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(112488);
            com.tencent.mm.ui.base.h.a((Context) this.qgk.getContext(), false, this.qgk.getString(R.string.aqc), "", this.qgk.getString(R.string.b98), this.qgk.getString(R.string.b96), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {
                /* class com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI.l.AnonymousClass1 */
                final /* synthetic */ l qgp;

                {
                    this.qgp = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(112485);
                    CardInvalidTicketListUI.cxg();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 11);
                    AppMethodBeat.o(112485);
                }
            }, (DialogInterface.OnClickListener) AnonymousClass2.qgq);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 10);
            AppMethodBeat.o(112488);
            return false;
        }
    }

    public static final /* synthetic */ void a(CardInvalidTicketListUI cardInvalidTicketListUI, String str) {
        AppMethodBeat.i(112500);
        Log.i("MicroMsg.CardTicketListUI", "go to card detail: %s", str);
        Intent intent = new Intent(cardInvalidTicketListUI.getContext(), CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.addFlags(131072);
        intent.putExtra("key_from_scene", 3);
        cardInvalidTicketListUI.getContext().startActivityForResult(intent, 256);
        AppMethodBeat.o(112500);
    }

    public static final /* synthetic */ void a(CardInvalidTicketListUI cardInvalidTicketListUI, cyp cyp, View view) {
        AppMethodBeat.i(201395);
        if (cyp != null) {
            com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(cardInvalidTicketListUI.getContext(), view);
            aVar.a(new h(cardInvalidTicketListUI, view, cyp));
            aVar.a(new i(cardInvalidTicketListUI, view, cyp));
            Point dB = com.tencent.mm.plugin.card.d.m.dB(view);
            aVar.ez(dB.x, dB.y);
        }
        AppMethodBeat.o(201395);
    }

    public static final /* synthetic */ void a(CardInvalidTicketListUI cardInvalidTicketListUI, cyp cyp) {
        AppMethodBeat.i(201396);
        if (cyp != null) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) cardInvalidTicketListUI.getContext(), 1, true);
            TextView textView = new TextView(cardInvalidTicketListUI.getContext());
            textView.setText(cardInvalidTicketListUI.getString(R.string.apu));
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(cardInvalidTicketListUI.getResources().getColor(R.color.u_));
            textView.setGravity(17);
            int dimensionPixelSize = cardInvalidTicketListUI.getResources().getDimensionPixelSize(R.dimen.ct);
            int dimensionPixelSize2 = cardInvalidTicketListUI.getResources().getDimensionPixelSize(R.dimen.cb);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
            eVar.V(textView, false);
            eVar.a(new j(cardInvalidTicketListUI));
            eVar.a(new k(cardInvalidTicketListUI, cyp));
            eVar.dGm();
        }
        AppMethodBeat.o(201396);
    }

    public static final /* synthetic */ void b(CardInvalidTicketListUI cardInvalidTicketListUI, String str) {
        AppMethodBeat.i(112501);
        Log.i("MicroMsg.CardInvalidTicketListUI", "do delete ticket: %s", str);
        cardInvalidTicketListUI.j(Boolean.TRUE);
        new com.tencent.mm.plugin.card.model.a.b(str).aYI().b(new b(cardInvalidTicketListUI, str));
        AppMethodBeat.o(112501);
    }

    public static final /* synthetic */ void d(CardInvalidTicketListUI cardInvalidTicketListUI) {
        AppMethodBeat.i(112502);
        Log.i("MicroMsg.CardInvalidTicketListUI", "update clear btn: %s", Boolean.valueOf(cardInvalidTicketListUI.qgi));
        if (cardInvalidTicketListUI.qgi) {
            cardInvalidTicketListUI.addTextOptionMenu(0, cardInvalidTicketListUI.getString(R.string.anu), new l(cardInvalidTicketListUI));
            if (cardInvalidTicketListUI.qgh.isEmpty()) {
                cardInvalidTicketListUI.enableOptionMenu(0, false);
                AppMethodBeat.o(112502);
                return;
            }
            cardInvalidTicketListUI.enableOptionMenu(0, true);
            AppMethodBeat.o(112502);
            return;
        }
        cardInvalidTicketListUI.removeOptionMenu(0);
        AppMethodBeat.o(112502);
    }

    public static final /* synthetic */ void cxg() {
        AppMethodBeat.i(201397);
        Log.i("MicroMsg.CardInvalidTicketListUI", "do clear invalid ticket list");
        AppMethodBeat.o(201397);
    }
}
