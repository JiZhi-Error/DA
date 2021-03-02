package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.w;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.card.model.a.a;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.cyq;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001c\u0018\u0000 F2\u00020\u0001:\u0001FB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010#\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0018H\u0014J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\u001fH\u0014J\b\u0010(\u001a\u00020\u001fH\u0002J\"\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0012\u0010.\u001a\u00020\u001f2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u001fH\u0014J\u0018\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0004H\u0016J\b\u00105\u001a\u00020\u001fH\u0014J\b\u00106\u001a\u00020\u001fH\u0002J\u001a\u00107\u001a\u00020\u001f2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;H\u0002J\u0012\u0010<\u001a\u00020\u001f2\b\u00108\u001a\u0004\u0018\u000109H\u0002J\u0017\u0010=\u001a\u00020\u001f2\b\u0010>\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010?J0\u0010@\u001a\u00020\u001f2\b\u0010\t\u001a\u0004\u0018\u00010A2\b\u0010\u001a\u001a\u0004\u0018\u00010B2\b\u0010\f\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\b\u0010E\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "getMktTicketHomePage", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "isAll", "isLoading", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "licenseList", "mEmptyView", "Landroid/view/ViewGroup;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "medicareCard", "needRefreshList", "offset", "", "reqNum", "ticketList", "weAppOpenUICallback", "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$weAppOpenUICallback$1", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI$weAppOpenUICallback$1;", "adjustFooterView", "", "doDeleteTicket", "cardId", "", "doGetTicketHomePage", "refresh", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showDeleteCardAlert", "ticketElement", "Lcom/tencent/mm/protocal/protobuf/PageTicketElement;", "item", "Landroid/view/View;", "showDeleteConfirmDialog", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateModelList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "underList", "Lcom/tencent/mm/protocal/protobuf/PageUnderList;", "updateTextMenu", "Companion", "plugin-card_release"})
public final class CardTicketListUI extends CardNewBaseUI {
    public static final a qgM = new a((byte) 0);
    private boolean gWt = true;
    private q gxX;
    private boolean isLoading;
    private int offset;
    private int qeS = 10;
    private boolean qeT;
    private b qgC;
    private ViewGroup qgI;
    private boolean qgJ;
    private final m qgK = new m(this);
    private com.tencent.mm.plugin.card.model.a.i qgL;
    private LoadMoreRecyclerView qgf;
    private a qgg;
    private final ArrayList<b> qgx = new ArrayList<>();
    private final ArrayList<b> qgy = new ArrayList<>();
    private final ArrayList<b> qgz = new ArrayList<>();

    static {
        AppMethodBeat.i(112545);
        AppMethodBeat.o(112545);
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CardTicketListUI qgN;
        final /* synthetic */ String qgl;

        b(CardTicketListUI cardTicketListUI, String str) {
            this.qgN = cardTicketListUI;
            this.qgl = str;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(112525);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.CardTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                agn agn = (agn) aVar.iLC;
                Log.i("MicroMsg.CardTicketListUI", "retCode: %s", Integer.valueOf(agn.pTZ));
                if (agn.pTZ == 0) {
                    CardTicketListUI.b(this.qgN).ajO(this.qgl);
                } else {
                    com.tencent.mm.plugin.card.d.l.aq(this.qgN, agn.pUa);
                }
            } else {
                com.tencent.mm.plugin.card.d.l.ar(this.qgN, "");
            }
            CardTicketListUI.a(this.qgN, Boolean.FALSE);
            x xVar = x.SXb;
            AppMethodBeat.o(112525);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "call"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CardTicketListUI qgN;
        final /* synthetic */ boolean qgO;

        c(CardTicketListUI cardTicketListUI, boolean z) {
            this.qgN = cardTicketListUI;
            this.qgO = z;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            boolean z;
            AppMethodBeat.i(112526);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.CardTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            this.qgN.isLoading = false;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                T t = aVar.iLC;
                bqu bqu = (bqu) t;
                Log.i("MicroMsg.CardTicketListUI", "retCode: %s", Integer.valueOf(bqu.pTZ));
                if (bqu.pTZ == 0) {
                    this.qgN.offset = bqu.qGg;
                    CardTicketListUI cardTicketListUI = this.qgN;
                    if (bqu.LUO == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cardTicketListUI.qeT = z;
                    if (this.qgN.qeT) {
                        CardTicketListUI.g(this.qgN).showLoading(false);
                    } else {
                        CardTicketListUI.g(this.qgN).showLoading(true);
                    }
                    if (this.qgN.gWt || this.qgO) {
                        this.qgN.qgz.clear();
                        this.qgN.qgx.clear();
                        this.qgN.qgy.clear();
                        this.qgN.qgC = null;
                        this.qgN.gWt = false;
                    }
                    Log.d("MicroMsg.CardTicketListUI", "page_under_list: %s", bqu.LYs);
                    CardTicketListUI.a(this.qgN, bqu.LYp, bqu.LYq, bqu.LYr, bqu.LYs);
                } else {
                    com.tencent.mm.plugin.card.d.l.aq(this.qgN, bqu.pUa);
                    if (this.qgN.gWt) {
                        this.qgN.gWt = false;
                    }
                }
                AppMethodBeat.o(112526);
                return t;
            }
            if (this.qgN.gWt) {
                this.qgN.gWt = false;
            }
            com.tencent.mm.plugin.card.d.l.ar(this.qgN, "");
            x xVar = x.SXb;
            AppMethodBeat.o(112526);
            return xVar;
        }
    }

    public CardTicketListUI() {
        AppMethodBeat.i(112544);
        AppMethodBeat.o(112544);
    }

    public static final /* synthetic */ void a(CardTicketListUI cardTicketListUI, cyr cyr, cys cys, cys cys2, cyt cyt) {
        AppMethodBeat.i(201423);
        cardTicketListUI.a(cyr, cys, cys2, cyt);
        AppMethodBeat.o(201423);
    }

    public static final /* synthetic */ void a(CardTicketListUI cardTicketListUI, Boolean bool) {
        AppMethodBeat.i(201422);
        cardTicketListUI.j(bool);
        AppMethodBeat.o(201422);
    }

    public static final /* synthetic */ a b(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.i(112547);
        a aVar = cardTicketListUI.qgg;
        if (aVar == null) {
            p.btv("mTicketAdapter");
        }
        AppMethodBeat.o(112547);
        return aVar;
    }

    public static final /* synthetic */ void b(CardTicketListUI cardTicketListUI, String str) {
        AppMethodBeat.i(112549);
        cardTicketListUI.ajR(str);
        AppMethodBeat.o(112549);
    }

    public static final /* synthetic */ LoadMoreRecyclerView g(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.i(112551);
        LoadMoreRecyclerView loadMoreRecyclerView = cardTicketListUI.qgf;
        if (loadMoreRecyclerView == null) {
            p.btv("mTicketRv");
        }
        AppMethodBeat.o(112551);
        return loadMoreRecyclerView;
    }

    public static final /* synthetic */ void n(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.i(201424);
        cardTicketListUI.ky(true);
        AppMethodBeat.o(201424);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI$Companion;", "", "()V", "REQ_CARD_DETAIL", "", "TAG", "", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$weAppOpenUICallback$1", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "onAppBrandPreconditionError", "", "onAppBrandProcessDied", "onAppBrandUIEnter", "onAppBrandUIExit", "isFinish", "", "plugin-card_release"})
    public static final class m implements com.tencent.mm.plugin.appbrand.api.i {
        final /* synthetic */ CardTicketListUI qgN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        m(CardTicketListUI cardTicketListUI) {
            this.qgN = cardTicketListUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.api.i
        public final void bud() {
            AppMethodBeat.i(201411);
            Log.i("MicroMsg.CardTicketListUI", "onAppBrandPreconditionError");
            AppMethodBeat.o(201411);
        }

        @Override // com.tencent.mm.plugin.appbrand.api.i
        public final void bue() {
            AppMethodBeat.i(201412);
            Log.i("MicroMsg.CardTicketListUI", "onAppBrandUIEnter");
            AppMethodBeat.o(201412);
        }

        @Override // com.tencent.mm.plugin.appbrand.api.i
        public final void gC(boolean z) {
            AppMethodBeat.i(201413);
            Log.i("MicroMsg.CardTicketListUI", "onAppBrandUIExit(isFinish=" + z + ')');
            CardTicketListUI.n(this.qgN);
            AppMethodBeat.o(201413);
        }

        @Override // com.tencent.mm.plugin.appbrand.api.i
        public final void buf() {
            AppMethodBeat.i(201414);
            Log.i("MicroMsg.CardTicketListUI", "onAppBrandProcessDied");
            CardTicketListUI.n(this.qgN);
            AppMethodBeat.o(201414);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(112536);
        fixStatusbar(true);
        super.onCreate(bundle);
        hideActionbarLine();
        initView();
        cyr cyr = new cyr();
        cys cys = new cys();
        cys cys2 = new cys();
        cyt cyt = new cyt();
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        p.h(cyr, "jumpList");
        p.h(cys, "ticketList");
        p.h(cys2, "licenseList");
        p.h(cyt, "underList");
        Log.d(com.tencent.mm.plugin.card.model.a.a.TAG, "load ticket page snapshot");
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String str = (String) aAh.azQ().i(ar.a.USERINFO_CARD_JUMP_LIST_STRING_SYNC);
        if (str != null) {
            Charset charset = kotlin.n.d.ISO_8859_1;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(112536);
                throw tVar;
            }
            byte[] bytes = str.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            cyr.parseFrom(bytes);
        }
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        String str2 = (String) aAh2.azQ().i(ar.a.USERINFO_CARD_TICKET_LIST_STRING_SYNC);
        if (str2 != null) {
            Charset charset2 = kotlin.n.d.ISO_8859_1;
            if (str2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(112536);
                throw tVar2;
            }
            byte[] bytes2 = str2.getBytes(charset2);
            p.g(bytes2, "(this as java.lang.String).getBytes(charset)");
            cys.parseFrom(bytes2);
        }
        com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh3, "MMKernel.storage()");
        String str3 = (String) aAh3.azQ().i(ar.a.USERINFO_CARD_LICENSE_LIST_STRING_SYNC);
        if (str3 != null) {
            Charset charset3 = kotlin.n.d.ISO_8859_1;
            if (str3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(112536);
                throw tVar3;
            }
            byte[] bytes3 = str3.getBytes(charset3);
            p.g(bytes3, "(this as java.lang.String).getBytes(charset)");
            cys2.parseFrom(bytes3);
        }
        com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh4, "MMKernel.storage()");
        String str4 = (String) aAh4.azQ().i(ar.a.USERINFO_CARD_UNDER_TICKET_LIST_STRING_SYNC);
        if (str4 != null) {
            Charset charset4 = kotlin.n.d.ISO_8859_1;
            if (str4 == null) {
                t tVar4 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(112536);
                throw tVar4;
            }
            byte[] bytes4 = str4.getBytes(charset4);
            p.g(bytes4, "(this as java.lang.String).getBytes(charset)");
            cyt.parseFrom(bytes4);
        }
        a(cyr, cys, cys2, cyt);
        setMMTitle(R.string.hod);
        setBackBtn(new g(this));
        addIconOptionMenu(0, R.raw.icons_outlined_more, new l(this));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 6);
        AppMethodBeat.o(112536);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class g implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ CardTicketListUI qgN;

        g(CardTicketListUI cardTicketListUI) {
            this.qgN = cardTicketListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(112535);
            this.qgN.finish();
            AppMethodBeat.o(112535);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(112537);
        View findViewById = findViewById(R.id.bjb);
        p.g(findViewById, "findViewById(R.id.ctlu_rv)");
        this.qgf = (LoadMoreRecyclerView) findViewById;
        this.qgg = new a();
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
        w wVar = new w(this, 1);
        wVar.setDrawable(getResources().getDrawable(R.drawable.lc));
        LoadMoreRecyclerView loadMoreRecyclerView3 = this.qgf;
        if (loadMoreRecyclerView3 == null) {
            p.btv("mTicketRv");
        }
        loadMoreRecyclerView3.b(wVar);
        LoadMoreRecyclerView loadMoreRecyclerView4 = this.qgf;
        if (loadMoreRecyclerView4 == null) {
            p.btv("mTicketRv");
        }
        loadMoreRecyclerView4.setLoadingView(R.layout.nc);
        View findViewById2 = findViewById(R.id.b1h);
        p.g(findViewById2, "findViewById(R.id.chpe_root_layout)");
        this.qgI = (ViewGroup) findViewById2;
        LoadMoreRecyclerView loadMoreRecyclerView5 = this.qgf;
        if (loadMoreRecyclerView5 == null) {
            p.btv("mTicketRv");
        }
        ViewGroup viewGroup = this.qgI;
        if (viewGroup == null) {
            p.btv("mEmptyView");
        }
        loadMoreRecyclerView5.setEmptyView(viewGroup);
        LoadMoreRecyclerView loadMoreRecyclerView6 = this.qgf;
        if (loadMoreRecyclerView6 == null) {
            p.btv("mTicketRv");
        }
        loadMoreRecyclerView6.setOnLoadingStateChangedListener(new d(this));
        LoadMoreRecyclerView loadMoreRecyclerView7 = this.qgf;
        if (loadMoreRecyclerView7 == null) {
            p.btv("mTicketRv");
        }
        loadMoreRecyclerView7.setOnItemClickListener(new e(this));
        LoadMoreRecyclerView loadMoreRecyclerView8 = this.qgf;
        if (loadMoreRecyclerView8 == null) {
            p.btv("mTicketRv");
        }
        loadMoreRecyclerView8.setOnItemLongClickListener(new f(this));
        AppMethodBeat.o(112537);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    public static final class d implements LoadMoreRecyclerView.a {
        final /* synthetic */ CardTicketListUI qgN;

        d(CardTicketListUI cardTicketListUI) {
            this.qgN = cardTicketListUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a
        public final void bYy() {
            AppMethodBeat.i(201401);
            CardTicketListUI.a(this.qgN);
            AppMethodBeat.o(201401);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    public static final class e implements MRecyclerView.a {
        final /* synthetic */ CardTicketListUI qgN;

        e(CardTicketListUI cardTicketListUI) {
            this.qgN = cardTicketListUI;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a
        public final void S(View view, int i2) {
            AppMethodBeat.i(201402);
            Log.i("MicroMsg.CardTicketListUI", "click item");
            b EB = CardTicketListUI.b(this.qgN).EB(i2);
            if (EB != null) {
                switch (EB.type) {
                    case 1:
                        cyq cyq = EB.qgF;
                        if (cyq != null) {
                            switch (cyq.MtC) {
                                case 1:
                                    com.tencent.mm.plugin.card.d.b.a(this.qgN, cyq.MDH);
                                    break;
                                case 2:
                                    un unVar = cyq.MDI;
                                    if (unVar != null) {
                                        com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                                        break;
                                    }
                                    break;
                            }
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 7);
                        AppMethodBeat.o(201402);
                        return;
                    case 2:
                        cyp cyp = EB.qgG;
                        if (cyp != null) {
                            CardTicketListUI cardTicketListUI = this.qgN;
                            String str = cyp.KDM;
                            p.g(str, "user_card_id");
                            CardTicketListUI.a(cardTicketListUI, str);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 10);
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                            a b2 = CardTicketListUI.b(this.qgN);
                            String str2 = cyp.KDM;
                            p.g(str2, "user_card_id");
                            hVar.a(16326, Integer.valueOf(cyp.MDA), cyp.KDM, Integer.valueOf(b2.cQ(str2, cyp.MDA)), 1);
                            AppMethodBeat.o(201402);
                            return;
                        }
                        AppMethodBeat.o(201402);
                        return;
                    case 3:
                        cnf cnf = EB.qgH;
                        if (cnf != null) {
                            switch (cnf.MtC) {
                                case 1:
                                    com.tencent.mm.plugin.card.d.b.a(this.qgN, cnf.MtD);
                                    this.qgN.qgJ = true;
                                    AppMethodBeat.o(201402);
                                    return;
                                case 2:
                                    un unVar2 = cnf.MtE;
                                    if (unVar2 != null) {
                                        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                                        gVar.username = unVar2.Hwr;
                                        gVar.kHw = unVar2.Hws;
                                        gVar.version = unVar2.IhZ;
                                        gVar.scene = TXLiteAVCode.EVT_SW_ENCODER_START_SUCC;
                                        gVar.kHN = this.qgN.qgK;
                                        ((r) com.tencent.mm.kernel.g.af(r.class)).a(this.qgN, gVar);
                                        AppMethodBeat.o(201402);
                                        return;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(201402);
                            return;
                        }
                        break;
                }
                AppMethodBeat.o(201402);
                return;
            }
            AppMethodBeat.o(201402);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
    public static final class f implements MRecyclerView.b {
        final /* synthetic */ CardTicketListUI qgN;

        f(CardTicketListUI cardTicketListUI) {
            this.qgN = cardTicketListUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b
        public final boolean T(View view, int i2) {
            AppMethodBeat.i(201403);
            Log.i("MicroMsg.CardTicketListUI", "long click item");
            b EB = CardTicketListUI.b(this.qgN).EB(i2);
            if (EB != null) {
                cyp cyp = EB.qgG;
                switch (EB.type) {
                    case 2:
                        CardTicketListUI cardTicketListUI = this.qgN;
                        p.g(view, "view");
                        CardTicketListUI.a(cardTicketListUI, cyp, view);
                        break;
                }
            }
            AppMethodBeat.o(201403);
            return false;
        }
    }

    private final void j(Boolean bool) {
        q qVar;
        AppMethodBeat.i(201415);
        if (bool == null) {
            AppMethodBeat.o(201415);
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
        AppMethodBeat.o(201415);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$showDeleteCardAlert$1$1"})
    public static final class h implements View.OnCreateContextMenuListener {
        final /* synthetic */ CardTicketListUI qgN;
        final /* synthetic */ View qgm;
        final /* synthetic */ cyp qgn;

        h(CardTicketListUI cardTicketListUI, View view, cyp cyp) {
            this.qgN = cardTicketListUI;
            this.qgm = view;
            this.qgn = cyp;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(201404);
            contextMenu.add(0, 1, 0, this.qgN.getString(R.string.tf));
            AppMethodBeat.o(201404);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$showDeleteCardAlert$1$2"})
    public static final class i implements o.g {
        final /* synthetic */ CardTicketListUI qgN;
        final /* synthetic */ View qgm;
        final /* synthetic */ cyp qgn;

        i(CardTicketListUI cardTicketListUI, View view, cyp cyp) {
            this.qgN = cardTicketListUI;
            this.qgm = view;
            this.qgn = cyp;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(201405);
            CardTicketListUI.a(this.qgN, this.qgn);
            AppMethodBeat.o(201405);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class j implements o.f {
        final /* synthetic */ CardTicketListUI qgN;

        j(CardTicketListUI cardTicketListUI) {
            this.qgN = cardTicketListUI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(201406);
            mVar.a(1, this.qgN.getResources().getColor(R.color.a5e), this.qgN.getString(R.string.tf));
            AppMethodBeat.o(201406);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    public static final class k implements o.g {
        final /* synthetic */ CardTicketListUI qgN;
        final /* synthetic */ cyp qgo;

        k(CardTicketListUI cardTicketListUI, cyp cyp) {
            this.qgN = cardTicketListUI;
            this.qgo = cyp;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(201407);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 1:
                    CardTicketListUI cardTicketListUI = this.qgN;
                    cyp cyp = this.qgo;
                    if (cyp == null) {
                        p.hyc();
                    }
                    String str = cyp.KDM;
                    p.g(str, "ticketElement!!.user_card_id");
                    CardTicketListUI.b(cardTicketListUI, str);
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    Object[] objArr = new Object[4];
                    cyp cyp2 = this.qgo;
                    if (cyp2 == null) {
                        p.hyc();
                    }
                    objArr[0] = Integer.valueOf(cyp2.MDA);
                    cyp cyp3 = this.qgo;
                    if (cyp3 == null) {
                        p.hyc();
                    }
                    objArr[1] = cyp3.KDM;
                    a b2 = CardTicketListUI.b(this.qgN);
                    cyp cyp4 = this.qgo;
                    if (cyp4 == null) {
                        p.hyc();
                    }
                    String str2 = cyp4.KDM;
                    p.g(str2, "ticketElement!!.user_card_id");
                    cyp cyp5 = this.qgo;
                    if (cyp5 == null) {
                        p.hyc();
                    }
                    objArr[2] = Integer.valueOf(b2.cQ(str2, cyp5.MDA));
                    objArr[3] = 4;
                    hVar.a(16326, objArr);
                    break;
            }
            AppMethodBeat.o(201407);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(201416);
        if (this.qgJ) {
            ky(true);
            this.qgJ = false;
        }
        super.onResume();
        AppMethodBeat.o(201416);
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(112538);
        super.onDestroy();
        com.tencent.mm.plugin.card.model.a.i iVar = this.qgL;
        if (iVar != null) {
            iVar.cancel();
        }
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(this.qgK);
        Log.i("MicroMsg.CardTicketListUI", "do save snapshot");
        cyr cyr = new cyr();
        cyr.MDK = new LinkedList<>();
        Iterator<b> it = this.qgz.iterator();
        while (it.hasNext()) {
            cyq cyq = it.next().qgF;
            if (cyq != null) {
                cyr.MDK.add(cyq);
            }
        }
        cys cys = new cys();
        cys.MDL = new LinkedList<>();
        Iterator<b> it2 = this.qgx.iterator();
        while (it2.hasNext()) {
            cyp cyp = it2.next().qgG;
            if (cyp != null) {
                cys.MDL.add(cyp);
            }
        }
        cys cys2 = new cys();
        cys2.MDL = new LinkedList<>();
        Iterator<b> it3 = this.qgy.iterator();
        while (it3.hasNext()) {
            cyp cyp2 = it3.next().qgG;
            if (cyp2 != null) {
                cys2.MDL.add(cyp2);
            }
        }
        cyt cyt = new cyt();
        b bVar = this.qgC;
        if (bVar != null) {
            cyt.MDM = bVar.qgH;
        }
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        p.h(cyr, "jumpList");
        p.h(cys, "ticketList");
        p.h(cys2, "licenseList");
        p.h(cyt, "underList");
        Log.d(com.tencent.mm.plugin.card.model.a.a.TAG, "save ticket page snapshot");
        byte[] byteArray = cyr.toByteArray();
        p.g(byteArray, "jumpList.toByteArray()");
        String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_CARD_JUMP_LIST_STRING_SYNC, str);
        byte[] byteArray2 = cys.toByteArray();
        p.g(byteArray2, "ticketList.toByteArray()");
        String str2 = new String(byteArray2, kotlin.n.d.ISO_8859_1);
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_CARD_TICKET_LIST_STRING_SYNC, str2);
        byte[] byteArray3 = cys2.toByteArray();
        p.g(byteArray3, "licenseList.toByteArray()");
        String str3 = new String(byteArray3, kotlin.n.d.ISO_8859_1);
        com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh3, "MMKernel.storage()");
        aAh3.azQ().set(ar.a.USERINFO_CARD_LICENSE_LIST_STRING_SYNC, str3);
        byte[] byteArray4 = cyt.toByteArray();
        p.g(byteArray4, "underList.toByteArray()");
        String str4 = new String(byteArray4, kotlin.n.d.ISO_8859_1);
        com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh4, "MMKernel.storage()");
        aAh4.azQ().set(ar.a.USERINFO_CARD_UNDER_TICKET_LIST_STRING_SYNC, str4);
        AppMethodBeat.o(112538);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.p8;
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        String str = null;
        AppMethodBeat.i(112539);
        if (i2 == 256 && i3 == -1) {
            Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("key_finish_action", -1)) : null;
            if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 2)) {
                if (intent != null) {
                    str = intent.getStringExtra("key_card_id");
                }
                p.g(str, "cardId");
                ajR(str);
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(112539);
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI
    public final void ad(int i2, boolean z) {
        AppMethodBeat.i(112540);
        Log.i("MicroMsg.CardTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", Float.valueOf(this.latitude), Float.valueOf(this.dTj), Integer.valueOf(i2), Boolean.valueOf(z));
        if (this.gWt) {
            ky(false);
            AppMethodBeat.o(112540);
            return;
        }
        if (!z) {
            cxi();
        }
        AppMethodBeat.o(112540);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ee, code lost:
        if ((!r7.qgx.isEmpty()) != false) goto L_0x00f0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0139  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(com.tencent.mm.protocal.protobuf.cyr r8, com.tencent.mm.protocal.protobuf.cys r9, com.tencent.mm.protocal.protobuf.cys r10, com.tencent.mm.protocal.protobuf.cyt r11) {
        /*
        // Method dump skipped, instructions count: 373
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.a(com.tencent.mm.protocal.protobuf.cyr, com.tencent.mm.protocal.protobuf.cys, com.tencent.mm.protocal.protobuf.cys, com.tencent.mm.protocal.protobuf.cyt):void");
    }

    private final void ajR(String str) {
        AppMethodBeat.i(112542);
        Log.i("MicroMsg.CardTicketListUI", "do delete ticket: %s", str);
        j(Boolean.TRUE);
        new com.tencent.mm.plugin.card.model.a.c(str).aYI().b(new b(this, str));
        AppMethodBeat.o(112542);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class l implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ CardTicketListUI qgN;

        l(CardTicketListUI cardTicketListUI) {
            this.qgN = cardTicketListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201410);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.qgN.getContext(), 1, false);
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.l.AnonymousClass1 */
                final /* synthetic */ l qgP;

                {
                    this.qgP = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(201408);
                    mVar.add(0, 0, 1, this.qgP.qgN.getString(R.string.hoc));
                    AppMethodBeat.o(201408);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.l.AnonymousClass2 */
                final /* synthetic */ l qgP;

                {
                    this.qgP = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(201409);
                    p.g(menuItem, "menuItem");
                    if (menuItem.getItemId() == 0) {
                        Log.i("MicroMsg.CardTicketListUI", "click history wording");
                        Intent intent = new Intent(this.qgP.qgN, CardInvalidTicketListUI.class);
                        CardTicketListUI cardTicketListUI = this.qgP.qgN;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(cardTicketListUI, bl.axQ(), "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$updateTextMenu$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        cardTicketListUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(cardTicketListUI, "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$updateTextMenu$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 8);
                    }
                    AppMethodBeat.o(201409);
                }
            });
            eVar.dGm();
            AppMethodBeat.o(201410);
            return false;
        }
    }

    static /* synthetic */ void a(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.i(201419);
        cardTicketListUI.ky(false);
        AppMethodBeat.o(201419);
    }

    private final void ky(boolean z) {
        int i2;
        AppMethodBeat.i(201418);
        Log.i("MicroMsg.CardTicketListUI", "do get ticket: %s, %s, %s, %s", Integer.valueOf(this.offset), Integer.valueOf(this.qeS), Boolean.valueOf(this.qeT), Boolean.valueOf(this.isLoading));
        if (z || (!this.qeT && !this.isLoading)) {
            this.isLoading = true;
            int i3 = this.qeS;
            if (z) {
                if (this.offset * 2 < this.qeS) {
                    i2 = this.qeS;
                } else {
                    i2 = this.offset * 2;
                }
                this.offset = 0;
                i3 = i2;
            }
            this.qgL = new com.tencent.mm.plugin.card.model.a.i(this.offset, i3, (double) this.latitude, (double) this.dTj);
            com.tencent.mm.plugin.card.model.a.i iVar = this.qgL;
            if (iVar == null) {
                p.hyc();
            }
            iVar.aYI().b(new c(this, z));
        }
        AppMethodBeat.o(201418);
    }

    public static final /* synthetic */ void a(CardTicketListUI cardTicketListUI, String str) {
        AppMethodBeat.i(112548);
        Log.i("MicroMsg.CardTicketListUI", "go to card detail: %s", str);
        Intent intent = new Intent(cardTicketListUI.getContext(), CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.addFlags(131072);
        intent.putExtra("key_from_scene", 3);
        cardTicketListUI.startActivityForResult(intent, 256);
        AppMethodBeat.o(112548);
    }

    public static final /* synthetic */ void a(CardTicketListUI cardTicketListUI, cyp cyp, View view) {
        AppMethodBeat.i(201420);
        if (cyp != null) {
            com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(cardTicketListUI.getContext(), view);
            aVar.a(new h(cardTicketListUI, view, cyp));
            aVar.a(new i(cardTicketListUI, view, cyp));
            Point dB = com.tencent.mm.plugin.card.d.m.dB(view);
            aVar.ez(dB.x, dB.y);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(cyp.MDA);
            objArr[1] = cyp.KDM;
            a aVar2 = cardTicketListUI.qgg;
            if (aVar2 == null) {
                p.btv("mTicketAdapter");
            }
            String str = cyp.KDM;
            p.g(str, "user_card_id");
            objArr[2] = Integer.valueOf(aVar2.cQ(str, cyp.MDA));
            objArr[3] = 2;
            hVar.a(16326, objArr);
            AppMethodBeat.o(201420);
            return;
        }
        AppMethodBeat.o(201420);
    }

    public static final /* synthetic */ void a(CardTicketListUI cardTicketListUI, cyp cyp) {
        AppMethodBeat.i(201421);
        if (cyp != null) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) cardTicketListUI.getContext(), 1, true);
            TextView textView = new TextView(cardTicketListUI.getContext());
            textView.setText(cardTicketListUI.getString(R.string.apu));
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(cardTicketListUI.getResources().getColor(R.color.u_));
            textView.setGravity(17);
            int dimensionPixelSize = cardTicketListUI.getResources().getDimensionPixelSize(R.dimen.ct);
            int dimensionPixelSize2 = cardTicketListUI.getResources().getDimensionPixelSize(R.dimen.cb);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
            eVar.V(textView, false);
            eVar.a(new j(cardTicketListUI));
            eVar.a(new k(cardTicketListUI, cyp));
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(cyp.MDA);
            objArr[1] = cyp.KDM;
            a aVar = cardTicketListUI.qgg;
            if (aVar == null) {
                p.btv("mTicketAdapter");
            }
            String str = cyp.KDM;
            p.g(str, "ticketElement!!.user_card_id");
            objArr[2] = Integer.valueOf(aVar.cQ(str, cyp.MDA));
            objArr[3] = 3;
            hVar.a(16326, objArr);
            eVar.dGm();
        }
        AppMethodBeat.o(201421);
    }
}
