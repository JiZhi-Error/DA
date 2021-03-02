package com.tencent.mm.plugin.card.ui.v2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.card.model.a.a;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.protocal.protobuf.bqo;
import com.tencent.mm.protocal.protobuf.tz;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.protocal.protobuf.ul;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.smtt.sdk.WebView;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.kernel.i
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0005OPQRSB\u0005¢\u0006\u0002\u0010\u0002J\b\u00101\u001a\u0004\u0018\u00010\u0005J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020+J\b\u00105\u001a\u000203H\u0002J\u0018\u00106\u001a\u0002032\u0006\u00104\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020\nH\u0014J\b\u0010:\u001a\u000203H\u0002J\b\u0010;\u001a\u000203H\u0014J\u0006\u0010<\u001a\u00020\u0011J\u0012\u0010=\u001a\u0002032\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u000203H\u0014J\u0018\u0010A\u001a\u0002032\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0011H\u0016J\b\u0010D\u001a\u000203H\u0014J\u0006\u0010E\u001a\u000203J\u0006\u0010F\u001a\u000203J\b\u0010G\u001a\u000203H\u0002J$\u0010H\u001a\u0002032\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010NR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00060\u001aR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R&\u0010(\u001a\u001a\u0012\b\u0012\u00060\bR\u00020\u00000\u0004j\f\u0012\b\u0012\u00060\bR\u00020\u0000`\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0018\u00010\bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0018\u00010\bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R&\u0010/\u001a\u001a\u0012\b\u0012\u00060\bR\u00020\u00000\u0004j\f\u0012\b\u0012\u00060\bR\u00020\u0000`\u0006X\u0004¢\u0006\u0002\n\u0000R&\u00100\u001a\u001a\u0012\b\u0012\u00060\bR\u00020\u00000\u0004j\f\u0012\b\u0012\u00060\bR\u00020\u0000`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "cardSortInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "Lkotlin/collections/ArrayList;", "cardTitleModel", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "clickArea", "", "clickedCardHomePageElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "emptyModel", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "firstLoad", "", "getCardHomePageScene", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "isAll", "isGotoItem", "isLoading", "mDivider", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "mHomePageAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "mLoadingView", "Landroid/view/ViewGroup;", "mLoadingView2", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "markReloadHomePage", "needReloadHomePage", "offset", "reqNum", "scene", "shouldShowTicket", "showSort", "sortType", "storeModelList", "ticketModel", "ticketNum", "", "tipsDialog", "Landroid/app/Dialog;", "titleSectionModel", "topCellList", "underModelList", "cardSortInfo", "doDeleteMchInList", "", "merchantId", "doGetCardHomePage", "doGetMchInfo", "lastReceiveTime", "", "getLayoutId", "initFirstScreen", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "setFaqIconMenu", "showSortSheet", "updateModelList", "storePageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underPageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "_topCellList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "CardListModel", "CardSpan", "Companion", "HomePageAdapter", "HomePageVH", "plugin-card_release"})
public final class CardHomePageNewUI extends CardNewBaseUI {
    private static final int dse = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    private static final int qfm = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
    private static final int qfn = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    public static final c qfo = new c((byte) 0);
    private boolean gWt = true;
    private boolean isLoading;
    private Dialog jUV;
    private int offset;
    private int pVu;
    private LoadMoreRecyclerView qeN;
    private d qeO;
    private ViewGroup qeP;
    private RecyclerView.h qeQ;
    private ViewGroup qeR;
    private int qeS = 10;
    private boolean qeT;
    private String qeU = "";
    private final ArrayList<a> qeV = new ArrayList<>();
    private final ArrayList<a> qeW = new ArrayList<>();
    private final ArrayList<a> qeX = new ArrayList<>();
    private a qeY;
    private a qeZ;
    private a qfa;
    private a qfb;
    private boolean qfc;
    private int qfd = -1;
    private boolean qfe = true;
    private int qff;
    private ArrayList<uv> qfg = new ArrayList<>();
    private boolean qfh;
    private ue qfi = new ue();
    private ud qfj;
    private boolean qfk;
    private com.tencent.mm.plugin.card.model.a.g qfl;
    private int scene;

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "call"})
    static final class f<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String qfX;
        final /* synthetic */ CardHomePageNewUI qfv;

        f(CardHomePageNewUI cardHomePageNewUI, String str) {
            this.qfv = cardHomePageNewUI;
            this.qfX = str;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(112441);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                T t = aVar.iLC;
                ags ags = (ags) t;
                Log.i("MicroMsg.CardHomePageNewUI", "retCode: %s", Integer.valueOf(ags.pTZ));
                if (ags.pTZ == 0) {
                    CardHomePageNewUI.q(this.qfv).ajL(this.qfX);
                } else {
                    com.tencent.mm.plugin.card.d.l.aq(this.qfv, ags.pUa);
                }
                AppMethodBeat.o(112441);
                return t;
            }
            com.tencent.mm.plugin.card.d.l.ar(this.qfv, "");
            x xVar = x.SXb;
            AppMethodBeat.o(112441);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "call"})
    public static final class g<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CardHomePageNewUI qfv;

        g(CardHomePageNewUI cardHomePageNewUI) {
            this.qfv = cardHomePageNewUI;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            boolean z;
            AppMethodBeat.i(112442);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (this.qfv.jUV != null) {
                Dialog dialog = this.qfv.jUV;
                if (dialog == null) {
                    kotlin.g.b.p.hyc();
                }
                dialog.dismiss();
            }
            this.qfv.qfl = null;
            CardHomePageNewUI.w(this.qfv).setVisibility(8);
            this.qfv.isLoading = false;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                T t = aVar.iLC;
                bqo bqo = (bqo) t;
                Log.i("MicroMsg.CardHomePageNewUI", "retCode: %s", Integer.valueOf(bqo.pTZ));
                if (bqo.pTZ == 0) {
                    this.qfv.offset = bqo.qGg;
                    CardHomePageNewUI cardHomePageNewUI = this.qfv;
                    if (bqo.LUO == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cardHomePageNewUI.qeT = z;
                    this.qfv.qfg.clear();
                    if (bqo.LUU != null) {
                        this.qfv.qfg.addAll(bqo.LUU.Let);
                    }
                    if (!Util.isNullOrNil(bqo.LYi)) {
                        this.qfv.qeU = bqo.LYi;
                    }
                    if (this.qfv.qeT) {
                        CardHomePageNewUI.j(this.qfv).showLoading(false);
                        this.qfv.qfi = bqo.LYh;
                        this.qfv.cwX();
                    } else {
                        CardHomePageNewUI.j(this.qfv).showLoading(true);
                    }
                    if (this.qfv.gWt || this.qfv.qfk) {
                        this.qfv.qeW.clear();
                        this.qfv.qeX.clear();
                        this.qfv.qeV.clear();
                        this.qfv.qeZ = null;
                        if (this.qfv.gWt) {
                            this.qfv.gWt = false;
                        }
                        this.qfv.qfk = false;
                    } else {
                        bqo.LYj = null;
                    }
                    this.qfv.a(bqo.LUP, bqo.LYg, bqo.LYj);
                    RecyclerView.a adapter = CardHomePageNewUI.j(this.qfv).getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    if (this.qfv.gWt) {
                        this.qfv.gWt = false;
                    }
                    com.tencent.mm.plugin.card.d.l.aq(this.qfv, bqo.pUa);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 31);
                }
                if (bqo.LUS == 1) {
                    this.qfv.qfk = true;
                    this.qfv.offset = 0;
                    this.qfv.pVu = bqo.LUT;
                    CardHomePageNewUI.r(this.qfv);
                }
                AppMethodBeat.o(112442);
                return t;
            }
            this.qfv.pVu = 0;
            if (this.qfv.gWt) {
                this.qfv.gWt = false;
            }
            com.tencent.mm.plugin.card.d.l.ar(this.qfv, "");
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 31);
            x xVar = x.SXb;
            AppMethodBeat.o(112442);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class h<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String qfX;
        final /* synthetic */ CardHomePageNewUI qfv;

        h(CardHomePageNewUI cardHomePageNewUI, String str) {
            this.qfv = cardHomePageNewUI;
            this.qfX = str;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(112443);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                bko bko = (bko) aVar.iLC;
                Log.i("MicroMsg.CardHomePageNewUI", "retCode: %s, refresh: %s", Integer.valueOf(bko.pTZ), Integer.valueOf(bko.LTB));
                if (bko.pTZ != 0) {
                    com.tencent.mm.plugin.card.d.l.aq(this.qfv, bko.pUa);
                } else if (bko.LTB == 1) {
                    this.qfv.qfk = true;
                    this.qfv.offset = 0;
                    CardHomePageNewUI.r(this.qfv);
                } else if (this.qfv.qfd != 0) {
                    d q = CardHomePageNewUI.q(this.qfv);
                    String str = this.qfX;
                    ud udVar = bko.LTA;
                    kotlin.g.b.p.g(udVar, "card_pkg_mch_info");
                    q.a(str, udVar);
                } else if (bko.LTA.Lds.size() == 0) {
                    CardHomePageNewUI.q(this.qfv).ajL(this.qfX);
                } else {
                    d q2 = CardHomePageNewUI.q(this.qfv);
                    String str2 = this.qfX;
                    ud udVar2 = bko.LTA;
                    kotlin.g.b.p.g(udVar2, "card_pkg_mch_info");
                    q2.a(str2, udVar2);
                }
            } else {
                com.tencent.mm.plugin.card.d.l.ar(this.qfv, "");
            }
            this.qfv.qfd = -1;
            x xVar = x.SXb;
            AppMethodBeat.o(112443);
            return xVar;
        }
    }

    public CardHomePageNewUI() {
        AppMethodBeat.i(112469);
        AppMethodBeat.o(112469);
    }

    public static final /* synthetic */ LoadMoreRecyclerView j(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.i(112471);
        LoadMoreRecyclerView loadMoreRecyclerView = cardHomePageNewUI.qeN;
        if (loadMoreRecyclerView == null) {
            kotlin.g.b.p.btv("mRecyclerView");
        }
        AppMethodBeat.o(112471);
        return loadMoreRecyclerView;
    }

    public static final /* synthetic */ d q(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.i(112473);
        d dVar = cardHomePageNewUI.qeO;
        if (dVar == null) {
            kotlin.g.b.p.btv("mHomePageAdapter");
        }
        AppMethodBeat.o(112473);
        return dVar;
    }

    public static final /* synthetic */ void r(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.i(112474);
        cardHomePageNewUI.cwZ();
        AppMethodBeat.o(112474);
    }

    public static final /* synthetic */ ViewGroup w(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.i(112475);
        ViewGroup viewGroup = cardHomePageNewUI.qeR;
        if (viewGroup == null) {
            kotlin.g.b.p.btv("mLoadingView2");
        }
        AppMethodBeat.o(112475);
        return viewGroup;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$Companion;", "", "()V", "DP_1", "", "getDP_1", "()I", "DP_16", "getDP_16", "FOOTER_HEIGHT", "getFOOTER_HEIGHT", "LIST_ITEM_TYPE_CARD_TITLE", "LIST_ITEM_TYPE_EMPTY", "LIST_ITEM_TYPE_FIRST", "LIST_ITEM_TYPE_STORE", "LIST_ITEM_TYPE_TICKET", "LIST_ITEM_TYPE_TITLE", "LIST_ITEM_TYPE_TOP_CELL", "LIST_ITEM_TYPE_UNDER", "SORT_TYPE_DEFAULT", "SORT_TYPE_DISTANCE", "SORT_TYPE_EXPIRETIME", "SORT_TYPE_RCTIME", "TAG", "", "plugin-card_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(112470);
        AppMethodBeat.o(112470);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(112460);
        fixStatusbar(true);
        super.onCreate(bundle);
        hideActionbarLine();
        setMMTitle(R.string.aq7);
        this.scene = getIntent().getIntExtra("key_home_page_from_scene", 0);
        initView();
        this.qff = 1;
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        this.pVu = aAh.azQ().getInt(ar.a.USERINFO_CARD_ENTRANCE_SORT_TYPE_INT_SYNC, 1);
        if (this.pVu == 0) {
            this.pVu = 1;
        }
        if (this.qff == 1) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 14);
        }
        Log.i("MicroMsg.CardHomePageNewUI", "on create, scene: %s", Integer.valueOf(this.scene));
        setBackBtn(new m(this));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 4);
        ((com.tencent.mm.pluginsdk.wallet.b) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.b.class)).he(8, 2);
        AppMethodBeat.o(112460);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class m implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ CardHomePageNewUI qfv;

        m(CardHomePageNewUI cardHomePageNewUI) {
            this.qfv = cardHomePageNewUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(112453);
            this.qfv.finish();
            AppMethodBeat.o(112453);
            return false;
        }
    }

    public final void cwX() {
        AppMethodBeat.i(112461);
        ue ueVar = this.qfi;
        if (ueVar != null) {
            if (!Util.isNullOrNil(ueVar.LdB)) {
                removeAllOptionMenu();
                addIconOptionMenu(0, 0, R.raw.icons_outlined_more, new n(ueVar, this));
            }
            AppMethodBeat.o(112461);
            return;
        }
        AppMethodBeat.o(112461);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$setFaqIconMenu$1$1"})
    public static final class n implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ CardHomePageNewUI qfv;
        final /* synthetic */ ue qgc;

        n(ue ueVar, CardHomePageNewUI cardHomePageNewUI) {
            this.qgc = ueVar;
            this.qfv = cardHomePageNewUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(112456);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.qfv.getContext(), 1, false);
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.n.AnonymousClass1 */
                final /* synthetic */ n qgd;

                {
                    this.qgd = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(112454);
                    mVar.add(0, 0, 1, this.qgd.qgc.LdB);
                    AppMethodBeat.o(112454);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.n.AnonymousClass2 */
                final /* synthetic */ n qgd;

                {
                    this.qgd = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(112455);
                    kotlin.g.b.p.g(menuItem, "menuItem");
                    if (menuItem.getItemId() == 0) {
                        switch (this.qgd.qgc.LdC) {
                            case 1:
                                com.tencent.mm.plugin.card.d.b.a(this.qgd.qfv, this.qgd.qgc.LdD);
                                AppMethodBeat.o(112455);
                                return;
                            case 2:
                                un unVar = this.qgd.qgc.LdE;
                                com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                                break;
                        }
                    }
                    AppMethodBeat.o(112455);
                }
            });
            eVar.dGm();
            AppMethodBeat.o(112456);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        String str;
        AppMethodBeat.i(112462);
        super.onDestroy();
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_CARD_ENTRANCE_SORT_TYPE_INT_SYNC, Integer.valueOf(this.pVu));
        if (this.qfl != null) {
            com.tencent.mm.plugin.card.model.a.g gVar = this.qfl;
            if (gVar == null) {
                kotlin.g.b.p.hyc();
            }
            gVar.cancel();
            this.qfl = null;
        }
        com.tencent.mm.plugin.card.b.k.ctF();
        Log.i("MicroMsg.CardHomePageNewUI", "do save snap shot");
        uh uhVar = new uh();
        uhVar.LdI = new LinkedList<>();
        Iterator<a> it = this.qeW.iterator();
        while (it.hasNext()) {
            ud udVar = it.next().qfp;
            if (udVar != null) {
                uhVar.LdI.add(udVar);
            }
        }
        ul ulVar = new ul();
        a aVar = this.qeZ;
        if (aVar != null) {
            str = aVar.cxc();
        } else {
            str = null;
        }
        ulVar.LdU = str;
        ulVar.LdI = new LinkedList<>();
        Iterator<a> it2 = this.qeX.iterator();
        while (it2.hasNext()) {
            ud udVar2 = it2.next().qfp;
            if (udVar2 != null) {
                ulVar.LdI.add(udVar2);
            }
        }
        uk ukVar = new uk();
        Iterator<a> it3 = this.qeV.iterator();
        while (it3.hasNext()) {
            ui uiVar = it3.next().qft;
            if (uiVar != null) {
                ukVar.LdT.add(uiVar);
            }
        }
        uw uwVar = new uw();
        uwVar.Let.addAll(this.qfg);
        a.C0902a aVar2 = com.tencent.mm.plugin.card.model.a.a.pVg;
        ue ueVar = this.qfi;
        kotlin.g.b.p.h(uhVar, "storeList");
        kotlin.g.b.p.h(ulVar, "underList");
        kotlin.g.b.p.h(ukVar, "topList");
        kotlin.g.b.p.h(uwVar, "sortInfoList");
        Log.i(com.tencent.mm.plugin.card.model.a.a.TAG, "save home page snapshot");
        byte[] byteArray = uhVar.toByteArray();
        kotlin.g.b.p.g(byteArray, "storeList.toByteArray()");
        String str2 = new String(byteArray, kotlin.n.d.ISO_8859_1);
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_CARD_STORE_LIST_STRING_SYNC, str2);
        byte[] byteArray2 = ulVar.toByteArray();
        kotlin.g.b.p.g(byteArray2, "underList.toByteArray()");
        String str3 = new String(byteArray2, kotlin.n.d.ISO_8859_1);
        com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
        aAh3.azQ().set(ar.a.USERINFO_CARD_UNDER_LIST_STRING_SYNC, str3);
        byte[] byteArray3 = ukVar.toByteArray();
        kotlin.g.b.p.g(byteArray3, "topList.toByteArray()");
        String str4 = new String(byteArray3, kotlin.n.d.ISO_8859_1);
        com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
        aAh4.azQ().set(ar.a.USERINFO_CARD_TOP_LIST_STRING_SYNC, str4);
        byte[] byteArray4 = uwVar.toByteArray();
        kotlin.g.b.p.g(byteArray4, "sortInfoList.toByteArray()");
        String str5 = new String(byteArray4, kotlin.n.d.ISO_8859_1);
        com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
        aAh5.azQ().set(ar.a.USERINFO_CARD_SORT_INFO_LIST_STRING_SYNC, str5);
        if (ueVar != null) {
            byte[] byteArray5 = ueVar.toByteArray();
            kotlin.g.b.p.g(byteArray5, "faqItem.toByteArray()");
            String str6 = new String(byteArray5, kotlin.n.d.ISO_8859_1);
            com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh6, "MMKernel.storage()");
            aAh6.azQ().set(ar.a.USERINFO_CARD_FAQ_ITEM_STRING_SYNC, str6);
        }
        AppMethodBeat.o(112462);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(112463);
        super.onResume();
        if (!this.qfc || this.qfj == null || this.qfd == -1) {
            if (this.qfh) {
                this.qfk = true;
                this.offset = 0;
                this.qfh = false;
                cwZ();
            }
            AppMethodBeat.o(112463);
            return;
        }
        ud udVar = this.qfj;
        if (udVar == null) {
            kotlin.g.b.p.hyc();
        }
        String str = udVar.Ldn;
        kotlin.g.b.p.g(str, "clickedCardHomePageElement!!.card_pack_merchant_id");
        ud udVar2 = this.qfj;
        if (udVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        long j2 = udVar2.LdA;
        Log.i("MicroMsg.CardHomePageNewUI", "do get mch infoset: %s", str);
        new com.tencent.mm.plugin.card.model.a.f(str, j2, (double) this.latitude, (double) this.dTj, this.pVu).aYI().b(new h(this, str));
        this.qfc = false;
        this.qfj = null;
        AppMethodBeat.o(112463);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.nf;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(112464);
        View findViewById = findViewById(R.id.b2e);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.chpu_rv)");
        this.qeN = (LoadMoreRecyclerView) findViewById;
        LoadMoreRecyclerView loadMoreRecyclerView = this.qeN;
        if (loadMoreRecyclerView == null) {
            kotlin.g.b.p.btv("mRecyclerView");
        }
        getContext();
        loadMoreRecyclerView.setLayoutManager(new LinearLayoutManager());
        this.qeO = new d();
        LoadMoreRecyclerView loadMoreRecyclerView2 = this.qeN;
        if (loadMoreRecyclerView2 == null) {
            kotlin.g.b.p.btv("mRecyclerView");
        }
        d dVar = this.qeO;
        if (dVar == null) {
            kotlin.g.b.p.btv("mHomePageAdapter");
        }
        loadMoreRecyclerView2.setAdapter(dVar);
        LayoutInflater from = LayoutInflater.from(this);
        LoadMoreRecyclerView loadMoreRecyclerView3 = this.qeN;
        if (loadMoreRecyclerView3 == null) {
            kotlin.g.b.p.btv("mRecyclerView");
        }
        View inflate = from.inflate(R.layout.nc, (ViewGroup) loadMoreRecyclerView3, false);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(112464);
            throw tVar;
        }
        this.qeP = (ViewGroup) inflate;
        View findViewById2 = findViewById(R.id.b2d);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.chpu_loading_layout)");
        this.qeR = (ViewGroup) findViewById2;
        LoadMoreRecyclerView loadMoreRecyclerView4 = this.qeN;
        if (loadMoreRecyclerView4 == null) {
            kotlin.g.b.p.btv("mRecyclerView");
        }
        ViewGroup viewGroup = this.qeP;
        if (viewGroup == null) {
            kotlin.g.b.p.btv("mLoadingView");
        }
        loadMoreRecyclerView4.setLoadingView(viewGroup);
        this.qeQ = new i(this);
        LoadMoreRecyclerView loadMoreRecyclerView5 = this.qeN;
        if (loadMoreRecyclerView5 == null) {
            kotlin.g.b.p.btv("mRecyclerView");
        }
        RecyclerView.h hVar = this.qeQ;
        if (hVar == null) {
            kotlin.g.b.p.btv("mDivider");
        }
        loadMoreRecyclerView5.b(hVar);
        LoadMoreRecyclerView loadMoreRecyclerView6 = this.qeN;
        if (loadMoreRecyclerView6 == null) {
            kotlin.g.b.p.btv("mRecyclerView");
        }
        loadMoreRecyclerView6.setOnLoadingStateChangedListener(new j(this));
        LoadMoreRecyclerView loadMoreRecyclerView7 = this.qeN;
        if (loadMoreRecyclerView7 == null) {
            kotlin.g.b.p.btv("mRecyclerView");
        }
        loadMoreRecyclerView7.setOnItemClickListener(new k(this));
        LoadMoreRecyclerView loadMoreRecyclerView8 = this.qeN;
        if (loadMoreRecyclerView8 == null) {
            kotlin.g.b.p.btv("mRecyclerView");
        }
        loadMoreRecyclerView8.setOnItemLongClickListener(new l(this));
        uh uhVar = new uh();
        ul ulVar = new ul();
        uk ukVar = new uk();
        uw uwVar = new uw();
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        ue ueVar = this.qfi;
        kotlin.g.b.p.h(uhVar, "storeList");
        kotlin.g.b.p.h(ulVar, "underList");
        kotlin.g.b.p.h(ukVar, "topList");
        kotlin.g.b.p.h(uwVar, "cardSortInfoList");
        Log.i(com.tencent.mm.plugin.card.model.a.a.TAG, "load home page snapshot");
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        String str = (String) aAh.azQ().i(ar.a.USERINFO_CARD_STORE_LIST_STRING_SYNC);
        if (str != null) {
            Charset charset = kotlin.n.d.ISO_8859_1;
            if (str == null) {
                t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(112464);
                throw tVar2;
            }
            byte[] bytes = str.getBytes(charset);
            kotlin.g.b.p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            uhVar.parseFrom(bytes);
            z = true;
        }
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
        String str2 = (String) aAh2.azQ().i(ar.a.USERINFO_CARD_UNDER_LIST_STRING_SYNC);
        if (str2 != null) {
            Charset charset2 = kotlin.n.d.ISO_8859_1;
            if (str2 == null) {
                t tVar3 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(112464);
                throw tVar3;
            }
            byte[] bytes2 = str2.getBytes(charset2);
            kotlin.g.b.p.g(bytes2, "(this as java.lang.String).getBytes(charset)");
            ulVar.parseFrom(bytes2);
            z = true;
        }
        com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
        String str3 = (String) aAh3.azQ().i(ar.a.USERINFO_CARD_TOP_LIST_STRING_SYNC);
        if (str3 != null) {
            Charset charset3 = kotlin.n.d.ISO_8859_1;
            if (str3 == null) {
                t tVar4 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(112464);
                throw tVar4;
            }
            byte[] bytes3 = str3.getBytes(charset3);
            kotlin.g.b.p.g(bytes3, "(this as java.lang.String).getBytes(charset)");
            ukVar.parseFrom(bytes3);
            z = true;
        }
        com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
        String str4 = (String) aAh4.azQ().i(ar.a.USERINFO_CARD_SORT_INFO_LIST_STRING_SYNC);
        if (str4 != null) {
            Charset charset4 = kotlin.n.d.ISO_8859_1;
            if (str4 == null) {
                t tVar5 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(112464);
                throw tVar5;
            }
            byte[] bytes4 = str4.getBytes(charset4);
            kotlin.g.b.p.g(bytes4, "(this as java.lang.String).getBytes(charset)");
            uwVar.parseFrom(bytes4);
            z = true;
        }
        com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
        String str5 = (String) aAh5.azQ().i(ar.a.USERINFO_CARD_FAQ_ITEM_STRING_SYNC);
        if (str5 == null) {
            z2 = z;
        } else if (ueVar != null) {
            Charset charset5 = kotlin.n.d.ISO_8859_1;
            if (str5 == null) {
                t tVar6 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(112464);
                throw tVar6;
            }
            byte[] bytes5 = str5.getBytes(charset5);
            kotlin.g.b.p.g(bytes5, "(this as java.lang.String).getBytes(charset)");
            ueVar.parseFrom(bytes5);
        }
        this.qfg.clear();
        this.qfg.addAll(uwVar.Let);
        a(uhVar, ulVar, ukVar);
        if (!z2 && this.qeW.isEmpty() && this.qeX.isEmpty()) {
            Log.i("MicroMsg.CardHomePageNewUI", "show init view");
            a aVar2 = new a();
            aVar2.type = 3;
            a aVar3 = new a();
            aVar3.type = 3;
            this.qeW.add(aVar2);
            this.qeW.add(aVar3);
        }
        cwX();
        LoadMoreRecyclerView loadMoreRecyclerView9 = this.qeN;
        if (loadMoreRecyclerView9 == null) {
            kotlin.g.b.p.btv("mRecyclerView");
        }
        RecyclerView.a adapter = loadMoreRecyclerView9.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
            AppMethodBeat.o(112464);
            return;
        }
        AppMethodBeat.o(112464);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint2", "getPaint2", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "plugin-card_release"})
    public static final class i extends RecyclerView.h {
        private final Paint paint = new Paint();
        private final Paint qfY = new Paint();
        final /* synthetic */ CardHomePageNewUI qfv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(CardHomePageNewUI cardHomePageNewUI) {
            this.qfv = cardHomePageNewUI;
            AppMethodBeat.i(112446);
            this.paint.setColor(cardHomePageNewUI.getResources().getColor(R.color.a7t));
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setFlags(1);
            this.qfY.setColor(cardHomePageNewUI.getResources().getColor(R.color.afz));
            this.qfY.setStyle(Paint.Style.FILL);
            this.qfY.setFlags(1);
            AppMethodBeat.o(112446);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(112444);
            kotlin.g.b.p.h(rect, "outRect");
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(recyclerView, "parent");
            kotlin.g.b.p.h(sVar, "state");
            super.a(rect, view, recyclerView, sVar);
            if (RecyclerView.bw(view) == CardHomePageNewUI.q(this.qfv).getItemCount() - 1) {
                Log.d("MicroMsg.CardHomePageNewUI", "is last");
                c cVar = CardHomePageNewUI.qfo;
                rect.bottom = CardHomePageNewUI.dse;
                AppMethodBeat.o(112444);
                return;
            }
            rect.bottom = 1;
            AppMethodBeat.o(112444);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
            int i2;
            AppMethodBeat.i(112445);
            kotlin.g.b.p.h(canvas, "c");
            kotlin.g.b.p.h(recyclerView, "parent");
            kotlin.g.b.p.h(sVar, "state");
            super.a(canvas, recyclerView, sVar);
            LoadMoreRecyclerView j2 = CardHomePageNewUI.j(this.qfv);
            if (j2 != null) {
                int paddingLeft = j2.getPaddingLeft();
                c cVar = CardHomePageNewUI.qfo;
                int i3 = paddingLeft + CardHomePageNewUI.qfn;
                int width = j2.getWidth() - j2.getPaddingRight();
                int childCount = j2.getChildCount();
                for (int i4 = 0; i4 < childCount - 1; i4++) {
                    View childAt = j2.getChildAt(i4);
                    kotlin.g.b.p.g(childAt, "child");
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams == null) {
                        t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                        AppMethodBeat.o(112445);
                        throw tVar;
                    }
                    int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
                    if (i4 == childCount - 1) {
                        c cVar2 = CardHomePageNewUI.qfo;
                        i2 = CardHomePageNewUI.dse;
                    } else {
                        i2 = 1;
                    }
                    int i5 = bottom + i2;
                    if (canvas != null) {
                        canvas.drawRect((float) i3, (float) bottom, (float) width, (float) i5, this.paint);
                    }
                    if (canvas != null) {
                        canvas.drawRect(0.0f, (float) bottom, (float) i3, (float) i5, this.qfY);
                    }
                }
                AppMethodBeat.o(112445);
                return;
            }
            AppMethodBeat.o(112445);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    public static final class j implements LoadMoreRecyclerView.a {
        final /* synthetic */ CardHomePageNewUI qfv;

        j(CardHomePageNewUI cardHomePageNewUI) {
            this.qfv = cardHomePageNewUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a
        public final void bYy() {
            AppMethodBeat.i(112447);
            CardHomePageNewUI.r(this.qfv);
            AppMethodBeat.o(112447);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    public static final class k implements MRecyclerView.a {
        final /* synthetic */ CardHomePageNewUI qfv;

        k(CardHomePageNewUI cardHomePageNewUI) {
            this.qfv = cardHomePageNewUI;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a
        public final void S(View view, int i2) {
            AppMethodBeat.i(112448);
            a Ex = CardHomePageNewUI.q(this.qfv).Ex(i2);
            if (Ex != null) {
                Log.i("MicroMsg.CardHomePageNewUI", "click type: %s", Integer.valueOf(Ex.type));
                switch (Ex.type) {
                    case 2:
                        this.qfv.qfc = true;
                        this.qfv.qfd = 1;
                        this.qfv.qfj = Ex.qfp;
                        ud udVar = Ex.qfp;
                        if (udVar == null) {
                            kotlin.g.b.p.hyc();
                        }
                        switch (udVar.Ldc) {
                            case 1:
                                CardHomePageNewUI cardHomePageNewUI = this.qfv;
                                ud udVar2 = Ex.qfp;
                                if (udVar2 == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                com.tencent.mm.plugin.card.d.b.a(cardHomePageNewUI, udVar2.Ldd);
                                break;
                            case 2:
                                ud udVar3 = Ex.qfp;
                                if (udVar3 == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                un unVar = udVar3.Lde;
                                com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                                break;
                        }
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                        Object[] objArr = new Object[7];
                        objArr[0] = 2;
                        ud udVar4 = Ex.qfp;
                        if (udVar4 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        objArr[1] = udVar4.Ldn;
                        objArr[2] = 0;
                        objArr[3] = 0;
                        objArr[4] = 1;
                        objArr[5] = Integer.valueOf(i2);
                        objArr[6] = Integer.valueOf(this.qfv.pVu);
                        hVar.a(16324, objArr);
                        AppMethodBeat.o(112448);
                        return;
                    case 4:
                        Log.i("MicroMsg.CardHomePageNewUI", "click ticket item");
                        Intent intent = new Intent(this.qfv, CardTicketListUI.class);
                        CardHomePageNewUI cardHomePageNewUI2 = this.qfv;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(cardHomePageNewUI2, bl.axQ(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        cardHomePageNewUI2.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(cardHomePageNewUI2, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 5);
                        AppMethodBeat.o(112448);
                        return;
                    case 5:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 13);
                        AppMethodBeat.o(112448);
                        return;
                    case 6:
                        ui uiVar = Ex.qft;
                        if (uiVar == null) {
                            kotlin.g.b.p.hyc();
                        }
                        switch (uiVar.LdM) {
                            case 1:
                                CardHomePageNewUI cardHomePageNewUI3 = this.qfv;
                                ui uiVar2 = Ex.qft;
                                if (uiVar2 == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                com.tencent.mm.plugin.card.d.b.a(cardHomePageNewUI3, uiVar2.LdN);
                                this.qfv.qfh = true;
                                break;
                            case 2:
                                ui uiVar3 = Ex.qft;
                                if (uiVar3 == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                un unVar2 = uiVar3.LdO;
                                com.tencent.mm.plugin.card.d.b.H(unVar2.Hwr, unVar2.Hws, unVar2.IhZ);
                                this.qfv.qfh = true;
                                break;
                            case 3:
                                StringBuilder sb = new StringBuilder("click native url: ");
                                ui uiVar4 = Ex.qft;
                                if (uiVar4 == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                Log.i("MicroMsg.CardHomePageNewUI", sb.append(uiVar4.LdP).toString());
                                ui uiVar5 = Ex.qft;
                                if (uiVar5 == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                if (kotlin.g.b.p.j("weixin://mktcard/cert", uiVar5.LdP)) {
                                    Intent intent2 = new Intent(this.qfv, CardTicketListUI.class);
                                    CardHomePageNewUI cardHomePageNewUI4 = this.qfv;
                                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                                    com.tencent.mm.hellhoundlib.a.a.a(cardHomePageNewUI4, bl2.axQ(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    cardHomePageNewUI4.startActivity((Intent) bl2.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(cardHomePageNewUI4, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$3", "onItemClick", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    this.qfv.qfh = true;
                                    break;
                                }
                                break;
                        }
                        ui uiVar6 = Ex.qft;
                        if (uiVar6 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        uiVar6.LdR = 0;
                        ui uiVar7 = Ex.qft;
                        if (uiVar7 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        uiVar7.LdQ = 0;
                        CardHomePageNewUI.q(this.qfv).ci(i2);
                        break;
                }
                AppMethodBeat.o(112448);
                return;
            }
            AppMethodBeat.o(112448);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
    public static final class l implements MRecyclerView.b {
        final /* synthetic */ CardHomePageNewUI qfv;

        l(CardHomePageNewUI cardHomePageNewUI) {
            this.qfv = cardHomePageNewUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b
        public final boolean T(View view, int i2) {
            AppMethodBeat.i(112452);
            a Ex = CardHomePageNewUI.q(this.qfv).Ex(i2);
            if (Ex != null) {
                Log.i("MicroMsg.CardHomePageNewUI", "long click type: %s", Integer.valueOf(Ex.type));
                switch (Ex.type) {
                    case 2:
                        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this.qfv.getContext());
                        lVar.a(new a(this, i2));
                        lVar.a(new b(Ex, this, i2));
                        lVar.gXI();
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                        Object[] objArr = new Object[7];
                        objArr[0] = 2;
                        ud udVar = Ex.qfp;
                        if (udVar == null) {
                            kotlin.g.b.p.hyc();
                        }
                        objArr[1] = udVar.Ldn;
                        objArr[2] = 0;
                        objArr[3] = 0;
                        objArr[4] = 7;
                        objArr[5] = Integer.valueOf(i2);
                        objArr[6] = Integer.valueOf(this.qfv.pVu);
                        hVar.a(16324, objArr);
                        break;
                }
            }
            AppMethodBeat.o(112452);
            return false;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$1"})
        static final class a implements o.f {
            final /* synthetic */ int oeZ;
            final /* synthetic */ l qfZ;

            a(l lVar, int i2) {
                this.qfZ = lVar;
                this.oeZ = i2;
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(112449);
                mVar.d(1, this.qfZ.qfv.getString(R.string.tf));
                AppMethodBeat.o(112449);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2"})
        static final class b implements o.g {
            final /* synthetic */ int oeZ;
            final /* synthetic */ l qfZ;
            final /* synthetic */ a qga;

            b(a aVar, l lVar, int i2) {
                this.qga = aVar;
                this.qfZ = lVar;
                this.oeZ = i2;
            }

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(112451);
                kotlin.g.b.p.g(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case 1:
                        com.tencent.mm.ui.base.h.a((Context) this.qfZ.qfv.getContext(), this.qfZ.qfv.getString(R.string.aqd), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {
                            /* class com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.l.b.AnonymousClass1 */
                            final /* synthetic */ b qgb;

                            {
                                this.qgb = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(112450);
                                CardHomePageNewUI cardHomePageNewUI = this.qgb.qfZ.qfv;
                                ud udVar = this.qgb.qga.qfp;
                                if (udVar == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                String str = udVar.Ldn;
                                kotlin.g.b.p.g(str, "element!!.card_pack_merchant_id");
                                kotlin.g.b.p.h(str, "merchantId");
                                Log.i("MicroMsg.CardHomePageNewUI", "do delete merchant: %s", str);
                                new com.tencent.mm.plugin.card.model.a.d(str).aYI().b(new f(cardHomePageNewUI, str));
                                dialogInterface.dismiss();
                                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                                Object[] objArr = new Object[7];
                                objArr[0] = 2;
                                ud udVar2 = this.qgb.qga.qfp;
                                if (udVar2 == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                objArr[1] = udVar2.Ldn;
                                objArr[2] = 0;
                                objArr[3] = 0;
                                objArr[4] = 9;
                                objArr[5] = Integer.valueOf(this.qgb.oeZ);
                                objArr[6] = Integer.valueOf(this.qgb.qfZ.qfv.pVu);
                                hVar.a(16324, objArr);
                                AppMethodBeat.o(112450);
                            }
                        });
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                        Object[] objArr = new Object[7];
                        objArr[0] = 2;
                        ud udVar = this.qga.qfp;
                        if (udVar == null) {
                            kotlin.g.b.p.hyc();
                        }
                        objArr[1] = udVar.Ldn;
                        objArr[2] = 0;
                        objArr[3] = 0;
                        objArr[4] = 8;
                        objArr[5] = Integer.valueOf(this.oeZ);
                        objArr[6] = Integer.valueOf(this.qfZ.qfv.pVu);
                        hVar.a(16324, objArr);
                        break;
                }
                AppMethodBeat.o(112451);
            }
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI
    public final void ad(int i2, boolean z) {
        AppMethodBeat.i(112465);
        Log.i("MicroMsg.CardHomePageNewUI", "location finish: [%s, %s], ret: %s, isOk: %s", Float.valueOf(this.latitude), Float.valueOf(this.dTj), Integer.valueOf(i2), Boolean.valueOf(z));
        if (this.gWt) {
            if (this.qff == 1 && i2 < 0 && this.pVu == 1) {
                this.pVu = 0;
                if (i2 == -2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 30);
                }
            }
            cwZ();
            AppMethodBeat.o(112465);
            return;
        }
        if (!z) {
            cxi();
        }
        AppMethodBeat.o(112465);
    }

    public final uv cwY() {
        AppMethodBeat.i(112466);
        Iterator<uv> it = this.qfg.iterator();
        while (it.hasNext()) {
            uv next = it.next();
            if (next.Leq == this.pVu) {
                AppMethodBeat.o(112466);
                return next;
            }
        }
        AppMethodBeat.o(112466);
        return null;
    }

    public final void a(uh uhVar, ul ulVar, uk ukVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(112467);
        if (uhVar != null) {
            LinkedList<ud> linkedList = uhVar.LdI;
            kotlin.g.b.p.g(linkedList, "card_home_page_element");
            if (!linkedList.isEmpty()) {
                Iterator<ud> it = uhVar.LdI.iterator();
                while (it.hasNext()) {
                    a aVar = new a();
                    aVar.qfp = it.next();
                    aVar.type = 0;
                    this.qeW.add(aVar);
                }
            }
        }
        if (ulVar != null) {
            LinkedList<ud> linkedList2 = ulVar.LdI;
            kotlin.g.b.p.g(linkedList2, "card_home_page_element");
            if (!linkedList2.isEmpty()) {
                if (Util.isNullOrNil(ulVar.LdU)) {
                    ulVar.LdU = getString(R.string.apn);
                }
                if (this.qeZ == null) {
                    this.qeZ = new a();
                    a aVar2 = this.qeZ;
                    if (aVar2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    aVar2.type = 1;
                }
                a aVar3 = this.qeZ;
                if (aVar3 == null) {
                    kotlin.g.b.p.hyc();
                }
                String str = ulVar.LdU;
                kotlin.g.b.p.g(str, "section_title");
                aVar3.ajK(str);
                Iterator<ud> it2 = ulVar.LdI.iterator();
                while (it2.hasNext()) {
                    a aVar4 = new a();
                    aVar4.qfp = it2.next();
                    aVar4.type = 2;
                    this.qeX.add(aVar4);
                }
            }
        }
        if (ukVar != null) {
            LinkedList<ui> linkedList3 = ukVar.LdT;
            kotlin.g.b.p.g(linkedList3, "card_home_page_top_cell");
            if (!linkedList3.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                LinkedList<ui> linkedList4 = ukVar.LdT;
                kotlin.g.b.p.g(linkedList4, "card_home_page_top_cell");
                Iterator<T> it3 = linkedList4.iterator();
                int i2 = 0;
                while (it3.hasNext()) {
                    a aVar5 = new a();
                    aVar5.qft = it3.next();
                    aVar5.type = 6;
                    if (i2 == ukVar.LdT.size() - 1) {
                        aVar5.qfu = true;
                    }
                    this.qeV.add(aVar5);
                    i2++;
                }
            }
        }
        this.qfb = new a();
        a aVar6 = this.qfb;
        if (aVar6 == null) {
            kotlin.g.b.p.hyc();
        }
        aVar6.type = 5;
        if (this.qeW.isEmpty() && this.qeX.isEmpty()) {
            if (!this.qeV.isEmpty()) {
                z2 = true;
            }
            if (z2) {
                this.qeY = new a();
                a aVar7 = this.qeY;
                if (aVar7 == null) {
                    kotlin.g.b.p.hyc();
                }
                aVar7.type = 7;
                AppMethodBeat.o(112467);
                return;
            }
        }
        this.qeY = null;
        AppMethodBeat.o(112467);
    }

    private final void cwZ() {
        AppMethodBeat.i(112468);
        Log.i("MicroMsg.CardHomePageNewUI", "do get card Home page: %s, %s", Boolean.valueOf(this.qeT), Boolean.valueOf(this.isLoading));
        if (this.qfk || (!this.qeT && !this.isLoading)) {
            this.isLoading = true;
            if (this.qfk) {
                ViewGroup viewGroup = this.qeR;
                if (viewGroup == null) {
                    kotlin.g.b.p.btv("mLoadingView2");
                }
                viewGroup.setVisibility(0);
                if (this.qfa != null) {
                    ViewGroup viewGroup2 = this.qeR;
                    if (viewGroup2 == null) {
                        kotlin.g.b.p.btv("mLoadingView2");
                    }
                    ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
                    if (layoutParams == null) {
                        t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(112468);
                        throw tVar;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 80);
                    ViewGroup viewGroup3 = this.qeR;
                    if (viewGroup3 == null) {
                        kotlin.g.b.p.btv("mLoadingView2");
                    }
                    viewGroup3.setLayoutParams(layoutParams2);
                }
            }
            uv cwY = cwY();
            this.qeS = cwY != null ? cwY.Ler : 10;
            if (this.jUV != null) {
                Dialog dialog = this.jUV;
                if (dialog == null) {
                    kotlin.g.b.p.hyc();
                }
                dialog.dismiss();
            }
            if (this.qeW.isEmpty()) {
                getContext().getString(R.string.ty);
                this.jUV = com.tencent.mm.ui.base.h.a((Context) getContext(), getContext().getString(R.string.ekc), true, (DialogInterface.OnCancelListener) null);
            }
            this.qfl = new com.tencent.mm.plugin.card.model.a.g(this.offset, this.qeS, (double) this.latitude, (double) this.dTj, this.pVu);
            com.tencent.mm.plugin.card.model.a.g gVar = this.qfl;
            if (gVar == null) {
                kotlin.g.b.p.hyc();
            }
            gVar.aYH().aYI().b(new g(this)).a(this);
        }
        AppMethodBeat.o(112468);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bR\u00020\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0014\u0010\r\u001a\b\u0018\u00010\bR\u00020\u00032\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0015\u001a\u00020\u00062\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\u0015\u001a\u00020\u00062\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0006J\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0014¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "appendUnderList", "", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByMerchantId", "merchantId", "", "moveStoreToUnderList", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByMId", "removeTitleSection", "replaceModelByMId", "mchInfo", "plugin-card_release"})
    public final class d extends RecyclerView.a<e> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ e a(ViewGroup viewGroup, int i2) {
            int i3 = R.layout.ne;
            AppMethodBeat.i(112408);
            kotlin.g.b.p.h(viewGroup, "parent");
            switch (i2) {
                case 0:
                    i3 = R.layout.nb;
                    break;
                case 1:
                    i3 = R.layout.nd;
                    break;
                case 2:
                case 3:
                    i3 = R.layout.n5;
                    break;
                case 4:
                case 6:
                    break;
                case 5:
                    i3 = R.layout.n6;
                    break;
                case 7:
                    i3 = R.layout.n_;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
            CardHomePageNewUI cardHomePageNewUI = CardHomePageNewUI.this;
            kotlin.g.b.p.g(inflate, "itemView");
            e eVar = new e(cardHomePageNewUI, inflate, i2);
            AppMethodBeat.o(112408);
            return eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(e eVar, int i2) {
            AppMethodBeat.i(112411);
            e eVar2 = eVar;
            kotlin.g.b.p.h(eVar2, "holder");
            Log.d("MicroMsg.CardHomePageNewUI", "bind view: %s", Integer.valueOf(i2));
            a Ex = Ex(i2);
            if (Ex != null) {
                e.a(eVar2, Ex, i2);
                AppMethodBeat.o(112411);
                return;
            }
            AppMethodBeat.o(112411);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(e eVar, int i2, List list) {
            boolean z;
            AppMethodBeat.i(112412);
            e eVar2 = eVar;
            kotlin.g.b.p.h(eVar2, "holder");
            kotlin.g.b.p.h(list, "payloads");
            if (!list.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (!z || !kotlin.g.b.p.j(list.get(0), Boolean.TRUE)) {
                super.a(eVar2, i2, list);
                AppMethodBeat.o(112412);
                return;
            }
            a Ex = Ex(i2);
            if (Ex != null) {
                eVar2.a(Ex, i2);
                AppMethodBeat.o(112412);
                return;
            }
            AppMethodBeat.o(112412);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8 = 1;
            AppMethodBeat.i(112409);
            ArrayList arrayList = CardHomePageNewUI.this.qeW;
            if (arrayList != null) {
                i2 = arrayList.size();
            } else {
                i2 = 0;
            }
            ArrayList arrayList2 = CardHomePageNewUI.this.qeX;
            if (arrayList2 != null) {
                i3 = arrayList2.size();
            } else {
                i3 = 0;
            }
            if (CardHomePageNewUI.this.qeZ != null) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            if (CardHomePageNewUI.this.qfa != null) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (CardHomePageNewUI.this.qfb != null) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            ArrayList arrayList3 = CardHomePageNewUI.this.qeV;
            if (arrayList3 != null) {
                i7 = arrayList3.size();
            } else {
                i7 = 0;
            }
            if (CardHomePageNewUI.this.qeY == null) {
                i8 = 0;
            }
            int i9 = i2 + i3 + i4 + i5 + i6 + i7 + i8;
            AppMethodBeat.o(112409);
            return i9;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(112410);
            a Ex = Ex(i2);
            if (Ex != null) {
                int i3 = Ex.type;
                AppMethodBeat.o(112410);
                return i3;
            }
            AppMethodBeat.o(112410);
            return 3;
        }

        public final a Ex(int i2) {
            Integer num;
            boolean z;
            int i3 = 0;
            AppMethodBeat.i(112413);
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i2);
            ArrayList arrayList = CardHomePageNewUI.this.qeW;
            objArr[1] = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
            ArrayList arrayList2 = CardHomePageNewUI.this.qeW;
            if (arrayList2 != null) {
                num = Integer.valueOf(arrayList2.size());
            } else {
                num = null;
            }
            objArr[2] = num;
            if (CardHomePageNewUI.this.qeZ != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[3] = Boolean.valueOf(z);
            Log.d("MicroMsg.CardHomePageNewUI", "pos: %s, sSize: %s, uSize: %s, title: %s", objArr);
            ArrayList arrayList3 = CardHomePageNewUI.this.qeV;
            if (arrayList3 != null) {
                if (i2 + 0 < arrayList3.size()) {
                    a aVar = (a) arrayList3.get(i2 + 0);
                    AppMethodBeat.o(112413);
                    return aVar;
                }
                i3 = arrayList3.size();
            }
            a aVar2 = CardHomePageNewUI.this.qfb;
            if (aVar2 != null) {
                if (i2 == i3) {
                    AppMethodBeat.o(112413);
                    return aVar2;
                }
                i3++;
            }
            a aVar3 = CardHomePageNewUI.this.qeY;
            if (aVar3 == null || i2 != i3) {
                ArrayList arrayList4 = CardHomePageNewUI.this.qeW;
                if (arrayList4 != null) {
                    if (i2 - i3 < arrayList4.size()) {
                        a aVar4 = (a) arrayList4.get(i2 - i3);
                        AppMethodBeat.o(112413);
                        return aVar4;
                    }
                    i3 = arrayList4.size() - 1;
                }
                if (CardHomePageNewUI.this.qeZ == null || i2 != (i3 = i3 + 1)) {
                    ArrayList arrayList5 = CardHomePageNewUI.this.qeX;
                    if (arrayList5 == null || i2 <= i3 || i2 > arrayList5.size() + i3) {
                        AppMethodBeat.o(112413);
                        return null;
                    }
                    a aVar5 = (a) arrayList5.get((i2 - i3) - 1);
                    AppMethodBeat.o(112413);
                    return aVar5;
                }
                a aVar6 = CardHomePageNewUI.this.qeZ;
                AppMethodBeat.o(112413);
                return aVar6;
            }
            AppMethodBeat.o(112413);
            return aVar3;
        }

        public final void ajL(String str) {
            String str2;
            AppMethodBeat.i(112414);
            kotlin.g.b.p.h(str, "merchantId");
            Iterator it = CardHomePageNewUI.this.qeW.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                ud udVar = aVar.qfp;
                if (kotlin.g.b.p.j(udVar != null ? udVar.Ldn : null, str)) {
                    CardHomePageNewUI.this.qeW.remove(aVar);
                    RecyclerView.a adapter = CardHomePageNewUI.j(CardHomePageNewUI.this).getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                        AppMethodBeat.o(112414);
                        return;
                    }
                    AppMethodBeat.o(112414);
                    return;
                }
            }
            Iterator it2 = CardHomePageNewUI.this.qeX.iterator();
            while (it2.hasNext()) {
                a aVar2 = (a) it2.next();
                ud udVar2 = aVar2.qfp;
                if (udVar2 != null) {
                    str2 = udVar2.Ldn;
                } else {
                    str2 = null;
                }
                if (kotlin.g.b.p.j(str2, str)) {
                    CardHomePageNewUI.this.qeX.remove(aVar2);
                    if (CardHomePageNewUI.this.qeX.size() == 0) {
                        CardHomePageNewUI.this.qeZ = null;
                        RecyclerView.a adapter2 = CardHomePageNewUI.j(CardHomePageNewUI.this).getAdapter();
                        if (adapter2 != null) {
                            adapter2.notifyDataSetChanged();
                            AppMethodBeat.o(112414);
                            return;
                        }
                    }
                    AppMethodBeat.o(112414);
                    return;
                }
            }
            AppMethodBeat.o(112414);
        }

        private int ajM(String str) {
            int i2;
            int i3;
            int i4 = 0;
            AppMethodBeat.i(112415);
            kotlin.g.b.p.h(str, "merchantId");
            int i5 = CardHomePageNewUI.this.qeV != null ? 1 : 0;
            if (CardHomePageNewUI.this.qfb != null) {
                i2 = i5 + 1;
            } else {
                i2 = i5;
            }
            int i6 = 0;
            for (a aVar : CardHomePageNewUI.this.qeW) {
                ud udVar = aVar.qfp;
                if (kotlin.g.b.p.j(udVar != null ? udVar.Ldn : null, str)) {
                    int i7 = i2 + i6;
                    AppMethodBeat.o(112415);
                    return i7;
                }
                i6++;
            }
            int size = (CardHomePageNewUI.this.qeW.size() + i2) - 1;
            if (CardHomePageNewUI.this.qeZ != null) {
                i3 = size + 1;
            } else {
                i3 = size;
            }
            for (a aVar2 : CardHomePageNewUI.this.qeX) {
                ud udVar2 = aVar2.qfp;
                if (kotlin.g.b.p.j(udVar2 != null ? udVar2.Ldn : null, str)) {
                    int i8 = i3 + i4 + 1;
                    AppMethodBeat.o(112415);
                    return i8;
                }
                i4++;
            }
            AppMethodBeat.o(112415);
            return -1;
        }

        public final void a(String str, ud udVar) {
            String str2;
            RecyclerView.a adapter;
            String str3;
            RecyclerView.a adapter2;
            AppMethodBeat.i(112416);
            kotlin.g.b.p.h(str, "merchantId");
            kotlin.g.b.p.h(udVar, "mchInfo");
            Iterator it = CardHomePageNewUI.this.qeW.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                ud udVar2 = aVar.qfp;
                if (udVar2 != null) {
                    str3 = udVar2.Ldn;
                } else {
                    str3 = null;
                }
                if (kotlin.g.b.p.j(str3, str)) {
                    aVar.qfp = udVar;
                    int ajM = ajM(str);
                    if (ajM < 0 || (adapter2 = CardHomePageNewUI.j(CardHomePageNewUI.this).getAdapter()) == null) {
                        AppMethodBeat.o(112416);
                        return;
                    }
                    adapter2.b(ajM, Boolean.TRUE);
                    AppMethodBeat.o(112416);
                    return;
                }
            }
            Iterator it2 = CardHomePageNewUI.this.qeX.iterator();
            while (it2.hasNext()) {
                a aVar2 = (a) it2.next();
                ud udVar3 = aVar2.qfp;
                if (udVar3 != null) {
                    str2 = udVar3.Ldn;
                } else {
                    str2 = null;
                }
                if (kotlin.g.b.p.j(str2, str)) {
                    aVar2.qfp = udVar;
                    int ajM2 = ajM(str);
                    if (ajM2 < 0 || (adapter = CardHomePageNewUI.j(CardHomePageNewUI.this).getAdapter()) == null) {
                        AppMethodBeat.o(112416);
                        return;
                    }
                    adapter.b(ajM2, Boolean.TRUE);
                    AppMethodBeat.o(112416);
                    return;
                }
            }
            AppMethodBeat.o(112416);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0003J \u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u0005H\u0002J\u0010\u0010\\\u001a\u00020V2\u0006\u0010[\u001a\u00020\u0005H\u0002J\u0010\u0010]\u001a\u00020V2\u0006\u0010[\u001a\u00020\u0005H\u0002J\u000e\u0010^\u001a\u00020V2\u0006\u0010_\u001a\u00020`J(\u0010a\u001a\u00020V2\u0006\u0010b\u001a\u00020\u00142\u0006\u0010c\u001a\u00020`2\u0006\u0010d\u001a\u00020e2\b\b\u0002\u0010f\u001a\u00020\u0005J\u0016\u0010g\u001a\u00020V2\u0006\u0010b\u001a\u00020\u00142\u0006\u0010c\u001a\u00020`J$\u0010P\u001a\u00020V2\n\u0010K\u001a\u00060LR\u00020M2\u0006\u0010[\u001a\u00020\u00052\b\b\u0002\u0010h\u001a\u00020iJ\u0010\u0010j\u001a\u00020V2\u0006\u0010[\u001a\u00020\u0005H\u0002J\u0010\u0010k\u001a\u00020V2\u0006\u0010[\u001a\u00020\u0005H\u0002J\u0010\u0010l\u001a\u00020V2\u0006\u0010[\u001a\u00020\u0005H\u0002J\u001c\u0010m\u001a\u00020V2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020p0o2\u0006\u0010q\u001a\u00020\bJ\u0014\u0010m\u001a\u00020V2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020s0oJ\u0018\u0010t\u001a\u00020V2\u0006\u0010u\u001a\u00020i2\u0006\u0010[\u001a\u00020\u0005H\u0002R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001a\u0010\"\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001a\u0010%\u001a\u00020&X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R\u001a\u00104\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\u001a\u00107\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0016\"\u0004\b>\u0010\u0018R\u001a\u0010?\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0010\"\u0004\bA\u0010\u0012R\u001a\u0010B\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0016\"\u0004\bD\u0010\u0018R\u001a\u0010E\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0016\"\u0004\bG\u0010\u0018R\u001a\u0010H\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0010\"\u0004\bJ\u0010\u0012R \u0010K\u001a\b\u0018\u00010LR\u00020MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0010\"\u0004\bT\u0010\u0012¨\u0006v"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroid/view/View;I)V", "chpiCouponLayout", "Landroid/widget/LinearLayout;", "getChpiCouponLayout", "()Landroid/widget/LinearLayout;", "setChpiCouponLayout", "(Landroid/widget/LinearLayout;)V", "chpiDescTv", "Landroid/widget/TextView;", "getChpiDescTv", "()Landroid/widget/TextView;", "setChpiDescTv", "(Landroid/widget/TextView;)V", "chpiExpandIv", "Landroid/widget/ImageView;", "getChpiExpandIv", "()Landroid/widget/ImageView;", "setChpiExpandIv", "(Landroid/widget/ImageView;)V", "chpiExpandLayout", "getChpiExpandLayout", "setChpiExpandLayout", "chpiExpandTv", "getChpiExpandTv", "setChpiExpandTv", "chpiHeaderLayout", "getChpiHeaderLayout", "setChpiHeaderLayout", "chpiLabelLayout", "getChpiLabelLayout", "setChpiLabelLayout", "chpiLogoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getChpiLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setChpiLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "chpiMchLabelTv", "Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "getChpiMchLabelTv", "()Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "setChpiMchLabelTv", "(Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;)V", "chpiNameTv", "getChpiNameTv", "setChpiNameTv", "chtiDescTv", "getChtiDescTv", "setChtiDescTv", "chtiDivider", "getChtiDivider", "()Landroid/view/View;", "setChtiDivider", "(Landroid/view/View;)V", "chtiIconIv", "getChtiIconIv", "setChtiIconIv", "chtiNewTv", "getChtiNewTv", "setChtiNewTv", "chtiRedDotIv", "getChtiRedDotIv", "setChtiRedDotIv", "chtiRightIv", "getChtiRightIv", "setChtiRightIv", "chtiTitleTv", "getChtiTitleTv", "setChtiTitleTv", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "getModel", "()Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "setModel", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;)V", "sectionTitleTv", "getSectionTitleTv", "setSectionTitleTv", "addCouponView", "", "view", "appendCouponView", "offset", "len", "position", "collapseCouponLayout", "expandCouponLayout", "gotoCardDetailUI", "cardId", "", "setCardBg", "imageView", "url", "radius", "", "defaultRes", "setIcon", "useBackendExpandState", "", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "labelList", "Lcom/tencent/mm/protocal/protobuf/CardElementMchLabel;", "updateExpandLayout", "isExpended", "plugin-card_release"})
    public final class e extends RecyclerView.v {
        public LinearLayout qfA;
        public LinearLayout qfB;
        public LinearLayout qfC;
        public LinearLayout qfD;
        public TextView qfE;
        public ImageView qfF;
        public CardLabelTextView qfG;
        public ImageView qfH;
        public TextView qfI;
        public TextView qfJ;
        public ImageView qfK;
        public ImageView qfL;
        public TextView qfM;
        public View qfN;
        a qfO;
        final /* synthetic */ CardHomePageNewUI qfv;
        public TextView qfw;
        public CdnImageView qfx;
        public TextView qfy;
        public TextView qfz;

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(CardHomePageNewUI cardHomePageNewUI, View view, int i2) {
            super(view);
            kotlin.g.b.p.h(view, "itemView");
            this.qfv = cardHomePageNewUI;
            AppMethodBeat.i(112438);
            switch (i2) {
                case 0:
                    View findViewById = view.findViewById(R.id.b20);
                    kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.id.chpi_logo_iv)");
                    this.qfx = (CdnImageView) findViewById;
                    View findViewById2 = view.findViewById(R.id.b24);
                    kotlin.g.b.p.g(findViewById2, "itemView.findViewById(R.id.chpi_username_tv)");
                    this.qfy = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.b1u);
                    kotlin.g.b.p.g(findViewById3, "itemView.findViewById(R.id.chpi_desc_tv)");
                    this.qfz = (TextView) findViewById3;
                    View findViewById4 = view.findViewById(R.id.b1z);
                    kotlin.g.b.p.g(findViewById4, "itemView.findViewById(R.id.chpi_label_layout)");
                    this.qfB = (LinearLayout) findViewById4;
                    View findViewById5 = view.findViewById(R.id.b1t);
                    kotlin.g.b.p.g(findViewById5, "itemView.findViewById(R.id.chpi_coupon_layout)");
                    this.qfC = (LinearLayout) findViewById5;
                    View findViewById6 = view.findViewById(R.id.b1w);
                    kotlin.g.b.p.g(findViewById6, "itemView.findViewById(R.id.chpi_expand_layout)");
                    this.qfD = (LinearLayout) findViewById6;
                    View findViewById7 = view.findViewById(R.id.b1v);
                    kotlin.g.b.p.g(findViewById7, "itemView.findViewById(R.id.chpi_expand_iv)");
                    this.qfF = (ImageView) findViewById7;
                    View findViewById8 = view.findViewById(R.id.b1x);
                    kotlin.g.b.p.g(findViewById8, "itemView.findViewById(R.id.chpi_expand_tv)");
                    this.qfE = (TextView) findViewById8;
                    View findViewById9 = view.findViewById(R.id.b21);
                    kotlin.g.b.p.g(findViewById9, "itemView.findViewById(R.id.chpi_mch_label_tv)");
                    this.qfG = (CardLabelTextView) findViewById9;
                    View findViewById10 = view.findViewById(R.id.b1y);
                    kotlin.g.b.p.g(findViewById10, "itemView.findViewById(R.id.chpi_header_layout)");
                    this.qfA = (LinearLayout) findViewById10;
                    AppMethodBeat.o(112438);
                    return;
                case 1:
                    View findViewById11 = view.findViewById(R.id.b22);
                    kotlin.g.b.p.g(findViewById11, "itemView.findViewById(R.id.chpi_section_title)");
                    this.qfw = (TextView) findViewById11;
                    AppMethodBeat.o(112438);
                    return;
                case 2:
                    View findViewById12 = view.findViewById(R.id.b20);
                    kotlin.g.b.p.g(findViewById12, "itemView.findViewById(R.id.chpi_logo_iv)");
                    this.qfx = (CdnImageView) findViewById12;
                    View findViewById13 = view.findViewById(R.id.b24);
                    kotlin.g.b.p.g(findViewById13, "itemView.findViewById(R.id.chpi_username_tv)");
                    this.qfy = (TextView) findViewById13;
                    View findViewById14 = view.findViewById(R.id.b1u);
                    kotlin.g.b.p.g(findViewById14, "itemView.findViewById(R.id.chpi_desc_tv)");
                    this.qfz = (TextView) findViewById14;
                    View findViewById15 = view.findViewById(R.id.b21);
                    kotlin.g.b.p.g(findViewById15, "itemView.findViewById(R.id.chpi_mch_label_tv)");
                    this.qfG = (CardLabelTextView) findViewById15;
                    AppMethodBeat.o(112438);
                    return;
                case 3:
                    View findViewById16 = view.findViewById(R.id.b20);
                    kotlin.g.b.p.g(findViewById16, "itemView.findViewById(R.id.chpi_logo_iv)");
                    this.qfx = (CdnImageView) findViewById16;
                    View findViewById17 = view.findViewById(R.id.b24);
                    kotlin.g.b.p.g(findViewById17, "itemView.findViewById(R.id.chpi_username_tv)");
                    this.qfy = (TextView) findViewById17;
                    View findViewById18 = view.findViewById(R.id.b1u);
                    kotlin.g.b.p.g(findViewById18, "itemView.findViewById(R.id.chpi_desc_tv)");
                    this.qfz = (TextView) findViewById18;
                    AppMethodBeat.o(112438);
                    return;
                case 4:
                    View findViewById19 = view.findViewById(R.id.b2x);
                    kotlin.g.b.p.g(findViewById19, "itemView.findViewById(R.id.chti_icon_iv)");
                    this.qfH = (ImageView) findViewById19;
                    View findViewById20 = view.findViewById(R.id.b31);
                    kotlin.g.b.p.g(findViewById20, "itemView.findViewById(R.id.chti_title_tv)");
                    this.qfI = (TextView) findViewById20;
                    View findViewById21 = view.findViewById(R.id.b2v);
                    kotlin.g.b.p.g(findViewById21, "itemView.findViewById(R.id.chti_desc_tv)");
                    this.qfJ = (TextView) findViewById21;
                    View findViewById22 = view.findViewById(R.id.b30);
                    kotlin.g.b.p.g(findViewById22, "itemView.findViewById(R.id.chti_right_iv)");
                    this.qfK = (ImageView) findViewById22;
                    AppMethodBeat.o(112438);
                    return;
                case 5:
                    View findViewById23 = view.findViewById(R.id.b2x);
                    kotlin.g.b.p.g(findViewById23, "itemView.findViewById(R.id.chti_icon_iv)");
                    this.qfH = (ImageView) findViewById23;
                    View findViewById24 = view.findViewById(R.id.b31);
                    kotlin.g.b.p.g(findViewById24, "itemView.findViewById(R.id.chti_title_tv)");
                    this.qfI = (TextView) findViewById24;
                    View findViewById25 = view.findViewById(R.id.b2v);
                    kotlin.g.b.p.g(findViewById25, "itemView.findViewById(R.id.chti_desc_tv)");
                    this.qfJ = (TextView) findViewById25;
                    View findViewById26 = view.findViewById(R.id.b30);
                    kotlin.g.b.p.g(findViewById26, "itemView.findViewById(R.id.chti_right_iv)");
                    this.qfK = (ImageView) findViewById26;
                    AppMethodBeat.o(112438);
                    return;
                case 6:
                    View findViewById27 = view.findViewById(R.id.b2x);
                    kotlin.g.b.p.g(findViewById27, "itemView.findViewById(R.id.chti_icon_iv)");
                    this.qfH = (ImageView) findViewById27;
                    View findViewById28 = view.findViewById(R.id.b31);
                    kotlin.g.b.p.g(findViewById28, "itemView.findViewById(R.id.chti_title_tv)");
                    this.qfI = (TextView) findViewById28;
                    View findViewById29 = view.findViewById(R.id.b2v);
                    kotlin.g.b.p.g(findViewById29, "itemView.findViewById(R.id.chti_desc_tv)");
                    this.qfJ = (TextView) findViewById29;
                    View findViewById30 = view.findViewById(R.id.b30);
                    kotlin.g.b.p.g(findViewById30, "itemView.findViewById(R.id.chti_right_iv)");
                    this.qfK = (ImageView) findViewById30;
                    View findViewById31 = view.findViewById(R.id.b2z);
                    kotlin.g.b.p.g(findViewById31, "itemView.findViewById(R.id.chti_reddot_iv)");
                    this.qfL = (ImageView) findViewById31;
                    View findViewById32 = view.findViewById(R.id.b2y);
                    kotlin.g.b.p.g(findViewById32, "itemView.findViewById(R.id.chti_new_tv)");
                    this.qfM = (TextView) findViewById32;
                    View findViewById33 = view.findViewById(R.id.b2w);
                    kotlin.g.b.p.g(findViewById33, "itemView.findViewById(R.id.chti_divider)");
                    this.qfN = findViewById33;
                    break;
            }
            AppMethodBeat.o(112438);
        }

        public static /* synthetic */ void a(e eVar, a aVar, int i2) {
            AppMethodBeat.i(112427);
            eVar.a(aVar, i2);
            AppMethodBeat.o(112427);
        }

        public final void a(a aVar, int i2) {
            int i3;
            int i4;
            boolean z;
            AppMethodBeat.i(112426);
            kotlin.g.b.p.h(aVar, "model");
            this.qfO = aVar;
            ud udVar = aVar.qfp;
            switch (aVar.type) {
                case 0:
                    if (udVar == null) {
                        kotlin.g.b.p.hyc();
                    }
                    CdnImageView cdnImageView = this.qfx;
                    if (cdnImageView == null) {
                        kotlin.g.b.p.btv("chpiLogoIv");
                    }
                    cdnImageView.setRoundCorner(true);
                    if (!Util.isNullOrNil(udVar.Ldo)) {
                        CdnImageView cdnImageView2 = this.qfx;
                        if (cdnImageView2 == null) {
                            kotlin.g.b.p.btv("chpiLogoIv");
                        }
                        String str = udVar.Ldo;
                        kotlin.g.b.p.g(str, "card_element_mch_icon");
                        b(cdnImageView2, str);
                    } else {
                        CdnImageView cdnImageView3 = this.qfx;
                        if (cdnImageView3 == null) {
                            kotlin.g.b.p.btv("chpiLogoIv");
                        }
                        cdnImageView3.setImageResource(R.raw.card_default_merchant_icon);
                    }
                    c cVar = new c(udVar, this, udVar, i2, false, aVar);
                    CdnImageView cdnImageView4 = this.qfx;
                    if (cdnImageView4 == null) {
                        kotlin.g.b.p.btv("chpiLogoIv");
                    }
                    cdnImageView4.setOnClickListener(cVar);
                    CardHomePageNewUI cardHomePageNewUI = this.qfv;
                    AppCompatActivity context = this.qfv.getContext();
                    kotlin.g.b.p.g(context, "context");
                    int color = context.getResources().getColor(R.color.a2x);
                    AppCompatActivity context2 = this.qfv.getContext();
                    kotlin.g.b.p.g(context2, "context");
                    b bVar = new b(cardHomePageNewUI, color, context2.getResources().getColor(R.color.a91), new d(cVar));
                    SpannableString spannableString = new SpannableString(udVar.Ldp);
                    spannableString.setSpan(bVar, 0, spannableString.length(), 18);
                    TextView textView = this.qfy;
                    if (textView == null) {
                        kotlin.g.b.p.btv("chpiNameTv");
                    }
                    textView.setClickable(true);
                    TextView textView2 = this.qfy;
                    if (textView2 == null) {
                        kotlin.g.b.p.btv("chpiNameTv");
                    }
                    textView2.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this.qfv));
                    TextView textView3 = this.qfy;
                    if (textView3 == null) {
                        kotlin.g.b.p.btv("chpiNameTv");
                    }
                    textView3.setText(spannableString);
                    if (!Util.isNullOrNil(udVar.Ldq)) {
                        TextView textView4 = this.qfz;
                        if (textView4 == null) {
                            kotlin.g.b.p.btv("chpiDescTv");
                        }
                        textView4.setText(udVar.Ldq);
                        TextView textView5 = this.qfz;
                        if (textView5 == null) {
                            kotlin.g.b.p.btv("chpiDescTv");
                        }
                        textView5.setVisibility(0);
                        TextView textView6 = this.qfz;
                        if (textView6 == null) {
                            kotlin.g.b.p.btv("chpiDescTv");
                        }
                        textView6.setOnClickListener(cVar);
                    } else {
                        TextView textView7 = this.qfz;
                        if (textView7 == null) {
                            kotlin.g.b.p.btv("chpiDescTv");
                        }
                        textView7.setVisibility(8);
                    }
                    if (udVar.Ldw == null) {
                        CardLabelTextView cardLabelTextView = this.qfG;
                        if (cardLabelTextView == null) {
                            kotlin.g.b.p.btv("chpiMchLabelTv");
                        }
                        cardLabelTextView.setText("");
                        CardLabelTextView cardLabelTextView2 = this.qfG;
                        if (cardLabelTextView2 == null) {
                            kotlin.g.b.p.btv("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(8);
                    } else if (!Util.isNullOrNil(udVar.Ldw.Ldh)) {
                        CardLabelTextView cardLabelTextView3 = this.qfG;
                        if (cardLabelTextView3 == null) {
                            kotlin.g.b.p.btv("chpiMchLabelTv");
                        }
                        cardLabelTextView3.setText(udVar.Ldw.Ldh);
                        if (!Util.isNullOrNil(udVar.Ldw.Ldi)) {
                            CardLabelTextView cardLabelTextView4 = this.qfG;
                            if (cardLabelTextView4 == null) {
                                kotlin.g.b.p.btv("chpiMchLabelTv");
                            }
                            cardLabelTextView4.setTextColor(Color.parseColor(udVar.Ldw.Ldi));
                        } else {
                            CardLabelTextView cardLabelTextView5 = this.qfG;
                            if (cardLabelTextView5 == null) {
                                kotlin.g.b.p.btv("chpiMchLabelTv");
                            }
                            cardLabelTextView5.setTextColor(this.qfv.getResources().getColor(R.color.afz));
                        }
                        if (!Util.isNullOrNil(udVar.Ldw.Ldj)) {
                            CardLabelTextView cardLabelTextView6 = this.qfG;
                            if (cardLabelTextView6 == null) {
                                kotlin.g.b.p.btv("chpiMchLabelTv");
                            }
                            cardLabelTextView6.setFillColor(com.tencent.mm.plugin.card.d.l.cT(udVar.Ldw.Ldj, udVar.Ldw.Ldm));
                        } else {
                            CardLabelTextView cardLabelTextView7 = this.qfG;
                            if (cardLabelTextView7 == null) {
                                kotlin.g.b.p.btv("chpiMchLabelTv");
                            }
                            cardLabelTextView7.setFillColor(0);
                        }
                        CardLabelTextView cardLabelTextView8 = this.qfG;
                        if (cardLabelTextView8 == null) {
                            kotlin.g.b.p.btv("chpiMchLabelTv");
                        }
                        cardLabelTextView8.setVisibility(0);
                    } else {
                        CardLabelTextView cardLabelTextView9 = this.qfG;
                        if (cardLabelTextView9 == null) {
                            kotlin.g.b.p.btv("chpiMchLabelTv");
                        }
                        cardLabelTextView9.setVisibility(8);
                    }
                    LinearLayout linearLayout = this.qfC;
                    if (linearLayout == null) {
                        kotlin.g.b.p.btv("chpiCouponLayout");
                    }
                    linearLayout.removeAllViews();
                    if (aVar.qfr) {
                        z = aVar.qfs;
                    } else if (udVar.Ldx == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        LinkedList<ua> linkedList = udVar.Lds;
                        kotlin.g.b.p.g(linkedList, "card_element_coupon_list");
                        if (!linkedList.isEmpty()) {
                            V(-1, udVar.Lds.size(), i2);
                            LinearLayout linearLayout2 = this.qfC;
                            if (linearLayout2 == null) {
                                kotlin.g.b.p.btv("chpiCouponLayout");
                            }
                            linearLayout2.setVisibility(0);
                            aVar.qfs = true;
                        } else {
                            LinearLayout linearLayout3 = this.qfC;
                            if (linearLayout3 == null) {
                                kotlin.g.b.p.btv("chpiCouponLayout");
                            }
                            linearLayout3.setVisibility(8);
                        }
                        if (!Util.isNullOrNil(udVar.Ldt)) {
                            Ey(i2);
                            LinearLayout linearLayout4 = this.qfD;
                            if (linearLayout4 == null) {
                                kotlin.g.b.p.btv("chpiExpandLayout");
                            }
                            linearLayout4.setVisibility(0);
                        } else if (udVar.Ldz < udVar.Lds.size()) {
                            EA(i2);
                        } else {
                            LinearLayout linearLayout5 = this.qfD;
                            if (linearLayout5 == null) {
                                kotlin.g.b.p.btv("chpiExpandLayout");
                            }
                            linearLayout5.setVisibility(8);
                        }
                    } else {
                        LinkedList<ua> linkedList2 = udVar.Lds;
                        kotlin.g.b.p.g(linkedList2, "card_element_coupon_list");
                        if (!linkedList2.isEmpty()) {
                            V(-1, udVar.Ldz, i2);
                            LinearLayout linearLayout6 = this.qfC;
                            if (linearLayout6 == null) {
                                kotlin.g.b.p.btv("chpiCouponLayout");
                            }
                            linearLayout6.setVisibility(0);
                            aVar.qfs = false;
                        } else {
                            LinearLayout linearLayout7 = this.qfC;
                            if (linearLayout7 == null) {
                                kotlin.g.b.p.btv("chpiCouponLayout");
                            }
                            linearLayout7.setVisibility(8);
                        }
                        if (udVar.Ldz < udVar.Lds.size()) {
                            Ez(i2);
                            LinearLayout linearLayout8 = this.qfD;
                            if (linearLayout8 == null) {
                                kotlin.g.b.p.btv("chpiExpandLayout");
                            }
                            linearLayout8.setVisibility(0);
                        } else if (!Util.isNullOrNil(udVar.Ldt)) {
                            Ey(i2);
                            LinearLayout linearLayout9 = this.qfD;
                            if (linearLayout9 == null) {
                                kotlin.g.b.p.btv("chpiExpandLayout");
                            }
                            linearLayout9.setVisibility(0);
                        } else {
                            LinearLayout linearLayout10 = this.qfD;
                            if (linearLayout10 == null) {
                                kotlin.g.b.p.btv("chpiExpandLayout");
                            }
                            linearLayout10.setVisibility(8);
                        }
                    }
                    LinkedList<ub> linkedList3 = udVar.Ldr;
                    kotlin.g.b.p.g(linkedList3, "card_element_mch_label");
                    cV(linkedList3);
                    x xVar = x.SXb;
                    break;
                case 1:
                    TextView textView8 = this.qfw;
                    if (textView8 == null) {
                        kotlin.g.b.p.btv("sectionTitleTv");
                    }
                    textView8.setText(aVar.cxc());
                    break;
                case 2:
                    if (udVar == null) {
                        kotlin.g.b.p.hyc();
                    }
                    CdnImageView cdnImageView5 = this.qfx;
                    if (cdnImageView5 == null) {
                        kotlin.g.b.p.btv("chpiLogoIv");
                    }
                    cdnImageView5.setRoundCorner(true);
                    CdnImageView cdnImageView6 = this.qfx;
                    if (cdnImageView6 == null) {
                        kotlin.g.b.p.btv("chpiLogoIv");
                    }
                    cdnImageView6.setUrl(udVar.Ldo);
                    TextView textView9 = this.qfy;
                    if (textView9 == null) {
                        kotlin.g.b.p.btv("chpiNameTv");
                    }
                    textView9.setText(udVar.Ldp);
                    if (!Util.isNullOrNil(udVar.Ldq)) {
                        TextView textView10 = this.qfz;
                        if (textView10 == null) {
                            kotlin.g.b.p.btv("chpiDescTv");
                        }
                        textView10.setText(udVar.Ldq);
                        TextView textView11 = this.qfz;
                        if (textView11 == null) {
                            kotlin.g.b.p.btv("chpiDescTv");
                        }
                        textView11.setVisibility(0);
                    } else {
                        TextView textView12 = this.qfz;
                        if (textView12 == null) {
                            kotlin.g.b.p.btv("chpiDescTv");
                        }
                        textView12.setVisibility(8);
                    }
                    if (udVar.Ldw == null) {
                        CardLabelTextView cardLabelTextView10 = this.qfG;
                        if (cardLabelTextView10 == null) {
                            kotlin.g.b.p.btv("chpiMchLabelTv");
                        }
                        cardLabelTextView10.setText("");
                        CardLabelTextView cardLabelTextView11 = this.qfG;
                        if (cardLabelTextView11 == null) {
                            kotlin.g.b.p.btv("chpiMchLabelTv");
                        }
                        cardLabelTextView11.setVisibility(8);
                    } else if (!Util.isNullOrNil(udVar.Ldw.Ldh)) {
                        CardLabelTextView cardLabelTextView12 = this.qfG;
                        if (cardLabelTextView12 == null) {
                            kotlin.g.b.p.btv("chpiMchLabelTv");
                        }
                        cardLabelTextView12.setText(udVar.Ldw.Ldh);
                        if (!Util.isNullOrNil(udVar.Ldw.Ldi)) {
                            CardLabelTextView cardLabelTextView13 = this.qfG;
                            if (cardLabelTextView13 == null) {
                                kotlin.g.b.p.btv("chpiMchLabelTv");
                            }
                            cardLabelTextView13.setTextColor(Color.parseColor(udVar.Ldw.Ldi));
                        } else {
                            CardLabelTextView cardLabelTextView14 = this.qfG;
                            if (cardLabelTextView14 == null) {
                                kotlin.g.b.p.btv("chpiMchLabelTv");
                            }
                            cardLabelTextView14.setTextColor(this.qfv.getResources().getColor(R.color.afz));
                        }
                        if (!Util.isNullOrNil(udVar.Ldw.Ldj)) {
                            CardLabelTextView cardLabelTextView15 = this.qfG;
                            if (cardLabelTextView15 == null) {
                                kotlin.g.b.p.btv("chpiMchLabelTv");
                            }
                            cardLabelTextView15.setFillColor(com.tencent.mm.plugin.card.d.l.cT(udVar.Ldw.Ldj, udVar.Ldw.Ldm));
                        } else {
                            CardLabelTextView cardLabelTextView16 = this.qfG;
                            if (cardLabelTextView16 == null) {
                                kotlin.g.b.p.btv("chpiMchLabelTv");
                            }
                            cardLabelTextView16.setFillColor(0);
                        }
                        CardLabelTextView cardLabelTextView17 = this.qfG;
                        if (cardLabelTextView17 == null) {
                            kotlin.g.b.p.btv("chpiMchLabelTv");
                        }
                        cardLabelTextView17.setVisibility(0);
                    } else {
                        CardLabelTextView cardLabelTextView18 = this.qfG;
                        if (cardLabelTextView18 == null) {
                            kotlin.g.b.p.btv("chpiMchLabelTv");
                        }
                        cardLabelTextView18.setVisibility(8);
                    }
                    x xVar2 = x.SXb;
                    break;
                case 3:
                    CdnImageView cdnImageView7 = this.qfx;
                    if (cdnImageView7 == null) {
                        kotlin.g.b.p.btv("chpiLogoIv");
                    }
                    cdnImageView7.setRoundCorner(true);
                    CdnImageView cdnImageView8 = this.qfx;
                    if (cdnImageView8 == null) {
                        kotlin.g.b.p.btv("chpiLogoIv");
                    }
                    cdnImageView8.setImageResource(R.raw.card_default_merchant_icon);
                    TextView textView13 = this.qfy;
                    if (textView13 == null) {
                        kotlin.g.b.p.btv("chpiNameTv");
                    }
                    textView13.setText(MMApplicationContext.getResources().getString(R.string.app));
                    TextView textView14 = this.qfz;
                    if (textView14 == null) {
                        kotlin.g.b.p.btv("chpiDescTv");
                    }
                    textView14.setVisibility(8);
                    break;
                case 4:
                    TextView textView15 = this.qfI;
                    if (textView15 == null) {
                        kotlin.g.b.p.btv("chtiTitleTv");
                    }
                    textView15.setText(R.string.hod);
                    if (this.qfv.qeU != null) {
                        TextView textView16 = this.qfJ;
                        if (textView16 == null) {
                            kotlin.g.b.p.btv("chtiDescTv");
                        }
                        textView16.setText(this.qfv.qeU);
                        x xVar3 = x.SXb;
                        break;
                    }
                    break;
                case 5:
                    TextView textView17 = this.qfI;
                    if (textView17 == null) {
                        kotlin.g.b.p.btv("chtiTitleTv");
                    }
                    textView17.setText(R.string.arq);
                    if (this.qfv.qff != 1) {
                        TextView textView18 = this.qfJ;
                        if (textView18 == null) {
                            kotlin.g.b.p.btv("chtiDescTv");
                        }
                        textView18.setVisibility(8);
                        ImageView imageView = this.qfK;
                        if (imageView == null) {
                            kotlin.g.b.p.btv("chtiRightIv");
                        }
                        imageView.setVisibility(8);
                        break;
                    } else {
                        TextView textView19 = this.qfJ;
                        if (textView19 == null) {
                            kotlin.g.b.p.btv("chtiDescTv");
                        }
                        textView19.setVisibility(0);
                        ImageView imageView2 = this.qfK;
                        if (imageView2 == null) {
                            kotlin.g.b.p.btv("chtiRightIv");
                        }
                        imageView2.setVisibility(0);
                        uv cwY = this.qfv.cwY();
                        if (cwY == null) {
                            TextView textView20 = this.qfJ;
                            if (textView20 == null) {
                                kotlin.g.b.p.btv("chtiDescTv");
                            }
                            textView20.setText("");
                        } else {
                            TextView textView21 = this.qfJ;
                            if (textView21 == null) {
                                kotlin.g.b.p.btv("chtiDescTv");
                            }
                            textView21.setText(cwY.Les);
                        }
                        TextView textView22 = this.qfJ;
                        if (textView22 == null) {
                            kotlin.g.b.p.btv("chtiDescTv");
                        }
                        textView22.setOnClickListener(new View$OnClickListenerC0910e(this));
                        ImageView imageView3 = this.qfK;
                        if (imageView3 == null) {
                            kotlin.g.b.p.btv("chtiRightIv");
                        }
                        imageView3.setOnClickListener(new f(this));
                        ImageView imageView4 = this.qfK;
                        if (imageView4 == null) {
                            kotlin.g.b.p.btv("chtiRightIv");
                        }
                        Util.expandViewTouchArea(imageView4, 50, 50, 50, 50);
                        break;
                    }
                case 6:
                    ui uiVar = aVar.qft;
                    if (uiVar != null) {
                        TextView textView23 = this.qfI;
                        if (textView23 == null) {
                            kotlin.g.b.p.btv("chtiTitleTv");
                        }
                        textView23.setText(uiVar.LdK);
                        TextView textView24 = this.qfJ;
                        if (textView24 == null) {
                            kotlin.g.b.p.btv("chtiDescTv");
                        }
                        textView24.setText(uiVar.LdL);
                        ImageView imageView5 = this.qfH;
                        if (imageView5 == null) {
                            kotlin.g.b.p.btv("chtiIconIv");
                        }
                        String str2 = uiVar.LdJ;
                        kotlin.g.b.p.g(str2, "card_top_cell_icon");
                        b(imageView5, str2);
                        TextView textView25 = this.qfM;
                        if (textView25 == null) {
                            kotlin.g.b.p.btv("chtiNewTv");
                        }
                        if (uiVar.LdR == 1) {
                            i3 = 0;
                        } else {
                            i3 = 8;
                        }
                        textView25.setVisibility(i3);
                        ImageView imageView6 = this.qfL;
                        if (imageView6 == null) {
                            kotlin.g.b.p.btv("chtiRedDotIv");
                        }
                        if (uiVar.LdQ == 1) {
                            i4 = 0;
                        } else {
                            i4 = 8;
                        }
                        imageView6.setVisibility(i4);
                        x xVar4 = x.SXb;
                    }
                    if (!aVar.qfu) {
                        View view = this.qfN;
                        if (view == null) {
                            kotlin.g.b.p.btv("chtiDivider");
                        }
                        view.setVisibility(8);
                        break;
                    } else {
                        View view2 = this.qfN;
                        if (view2 == null) {
                            kotlin.g.b.p.btv("chtiDivider");
                        }
                        view2.setVisibility(0);
                        break;
                    }
            }
            aVar.qfr = true;
            AppMethodBeat.o(112426);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$headerClickListener$1"})
        public static final class c implements View.OnClickListener {
            final /* synthetic */ int oeZ;
            final /* synthetic */ e qfP;
            final /* synthetic */ ud qfS;
            final /* synthetic */ ud qfT;
            final /* synthetic */ boolean qfU = false;
            final /* synthetic */ a qfV;

            c(ud udVar, e eVar, ud udVar2, int i2, boolean z, a aVar) {
                this.qfS = udVar;
                this.qfP = eVar;
                this.qfT = udVar2;
                this.oeZ = i2;
                this.qfV = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(112419);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.CardHomePageNewUI", "click header");
                this.qfP.qfv.qfc = true;
                this.qfP.qfv.qfd = 0;
                this.qfP.qfv.qfj = this.qfT;
                switch (this.qfS.Ldc) {
                    case 1:
                        View view2 = this.qfP.aus;
                        kotlin.g.b.p.g(view2, "itemView");
                        Context context = view2.getContext();
                        if (context != null) {
                            com.tencent.mm.plugin.card.d.b.a((MMActivity) context, this.qfS.Ldd);
                            break;
                        } else {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                            AppMethodBeat.o(112419);
                            throw tVar;
                        }
                    case 2:
                        un unVar = this.qfS.Lde;
                        com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                        break;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16324, 1, this.qfS.Ldn, 0, 0, 1, Integer.valueOf(this.oeZ), Integer.valueOf(this.qfP.qfv.pVu));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112419);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$span$1", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "onClick", "", "widget", "Landroid/view/View;", "hrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "plugin-card_release"})
        public static final class d extends com.tencent.mm.pluginsdk.ui.span.j {
            final /* synthetic */ View.OnClickListener qfW;

            d(View.OnClickListener onClickListener) {
                this.qfW = onClickListener;
            }

            @Override // com.tencent.mm.pluginsdk.ui.span.j
            public final void a(View view, u uVar) {
                AppMethodBeat.i(112420);
                this.qfW.onClick(view);
                AppMethodBeat.o(112420);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$e$e  reason: collision with other inner class name */
        public static final class View$OnClickListenerC0910e implements View.OnClickListener {
            final /* synthetic */ e qfP;

            View$OnClickListenerC0910e(e eVar) {
                this.qfP = eVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(112421);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CardHomePageNewUI.p(this.qfP.qfv);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112421);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class f implements View.OnClickListener {
            final /* synthetic */ e qfP;

            f(e eVar) {
                this.qfP = eVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(112422);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CardHomePageNewUI.p(this.qfP.qfv);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112422);
            }
        }

        private final void V(int i2, int i3, int i4) {
            AppMethodBeat.i(112428);
            a aVar = this.qfO;
            if (aVar == null) {
                kotlin.g.b.p.hyc();
            }
            ud udVar = aVar.qfp;
            if (udVar == null) {
                kotlin.g.b.p.hyc();
            }
            LinkedList<ua> linkedList = udVar.Lds;
            kotlin.g.b.p.g(linkedList, "el!!.card_element_coupon_list");
            int i5 = 0;
            int i6 = 0;
            for (T t : linkedList) {
                if (i5 >= i2) {
                    if (t.LcU == 1) {
                        LinearLayout linearLayout = this.qfC;
                        if (linearLayout == null) {
                            kotlin.g.b.p.btv("chpiCouponLayout");
                        }
                        LayoutInflater from = LayoutInflater.from(linearLayout.getContext());
                        LinearLayout linearLayout2 = this.qfC;
                        if (linearLayout2 == null) {
                            kotlin.g.b.p.btv("chpiCouponLayout");
                        }
                        View inflate = from.inflate(R.layout.n8, (ViewGroup) linearLayout2, false);
                        if (inflate == null) {
                            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(112428);
                            throw tVar;
                        }
                        ViewGroup viewGroup = (ViewGroup) inflate;
                        TextView textView = (TextView) viewGroup.findViewById(R.id.b1f);
                        CdnImageView cdnImageView = (CdnImageView) viewGroup.findViewById(R.id.b1c);
                        TextView textView2 = (TextView) viewGroup.findViewById(R.id.b1d);
                        LinearLayout linearLayout3 = (LinearLayout) viewGroup.findViewById(R.id.b1e);
                        if (!Util.isNullOrNil(t.LcX)) {
                            textView.setTextColor(com.tencent.mm.plugin.card.d.l.cT(t.LcX, t.LcY));
                        }
                        kotlin.g.b.p.g(textView, "titleTv");
                        textView.setText(t.LcO);
                        cdnImageView.setUrl(t.LcV);
                        if (!Util.isNullOrNil(t.LcZ)) {
                            textView2.setTextColor(com.tencent.mm.plugin.card.d.l.cT(t.LcZ, t.Lda));
                        }
                        kotlin.g.b.p.g(textView2, "descTv");
                        textView2.setText(t.LcP);
                        LinkedList<tz> linkedList2 = t.LcT;
                        kotlin.g.b.p.g(linkedList2, "coupon.coupon_label");
                        kotlin.g.b.p.g(linearLayout3, "labelLayout");
                        a(linkedList2, linearLayout3);
                        LinearLayout linearLayout4 = this.qfC;
                        if (linearLayout4 == null) {
                            kotlin.g.b.p.btv("chpiCouponLayout");
                        }
                        viewGroup.setOnClickListener(new a(this, udVar, t, linearLayout4.getChildCount(), i4));
                        dA(viewGroup);
                    } else if (t.LcU == 2) {
                        LinearLayout linearLayout5 = this.qfC;
                        if (linearLayout5 == null) {
                            kotlin.g.b.p.btv("chpiCouponLayout");
                        }
                        LayoutInflater from2 = LayoutInflater.from(linearLayout5.getContext());
                        LinearLayout linearLayout6 = this.qfC;
                        if (linearLayout6 == null) {
                            kotlin.g.b.p.btv("chpiCouponLayout");
                        }
                        View inflate2 = from2.inflate(R.layout.n7, (ViewGroup) linearLayout6, false);
                        if (inflate2 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(112428);
                            throw tVar2;
                        }
                        ViewGroup viewGroup2 = (ViewGroup) inflate2;
                        TextView textView3 = (TextView) viewGroup2.findViewById(R.id.b1f);
                        TextView textView4 = (TextView) viewGroup2.findViewById(R.id.b1d);
                        LinearLayout linearLayout7 = (LinearLayout) viewGroup2.findViewById(R.id.b1e);
                        MemberCardTopCropImageView memberCardTopCropImageView = (MemberCardTopCropImageView) viewGroup2.findViewById(R.id.b1a);
                        ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.b1b);
                        if (!Util.isNullOrNil(t.LcX)) {
                            textView3.setTextColor(com.tencent.mm.plugin.card.d.l.cT(t.LcX, t.LcY));
                        }
                        kotlin.g.b.p.g(textView3, "titleTv");
                        textView3.setText(t.LcO);
                        kotlin.g.b.p.g(textView4, "descTv");
                        textView4.setText(t.LcP);
                        kotlin.g.b.p.g(memberCardTopCropImageView, "bgIv");
                        memberCardTopCropImageView.setRadius((float) com.tencent.mm.cb.a.fromDPToPix(memberCardTopCropImageView.getContext(), 2));
                        if (!Util.isNullOrNil(t.LcS)) {
                            MemberCardTopCropImageView memberCardTopCropImageView2 = memberCardTopCropImageView;
                            String str = t.LcS;
                            kotlin.g.b.p.g(str, "coupon.coupon_back_url");
                            kotlin.g.b.p.h(memberCardTopCropImageView2, "imageView");
                            kotlin.g.b.p.h(str, "url");
                            c.a aVar2 = new c.a();
                            aVar2.OT(com.tencent.mm.loader.j.b.aKJ());
                            aVar2.a(q.bcW());
                            aVar2.OS(com.tencent.mm.plugin.card.model.m.ajp(str));
                            aVar2.bdp();
                            aVar2.bdu();
                            aVar2.bdo();
                            aVar2.ty(R.drawable.le);
                            aVar2.tx(com.tencent.mm.cb.a.fromDPToPix(memberCardTopCropImageView2.getContext(), 84));
                            aVar2.tw(com.tencent.mm.cb.a.jn(memberCardTopCropImageView2.getContext()));
                            q.bcV().a(str, memberCardTopCropImageView2, aVar2.bdv());
                            memberCardTopCropImageView2.setImageMatrix(new Matrix());
                            kotlin.g.b.p.g(imageView, "shadowBgIv");
                            imageView.setVisibility(0);
                        } else if (!Util.isNullOrNil(t.LcR)) {
                            memberCardTopCropImageView.setImageDrawable(new ColorDrawable(Color.parseColor(t.LcR)));
                            kotlin.g.b.p.g(imageView, "shadowBgIv");
                            imageView.setVisibility(0);
                        }
                        LinkedList<tz> linkedList3 = t.LcT;
                        kotlin.g.b.p.g(linkedList3, "coupon.coupon_label");
                        kotlin.g.b.p.g(linearLayout7, "labelLayout");
                        a(linkedList3, linearLayout7);
                        LinearLayout linearLayout8 = this.qfC;
                        if (linearLayout8 == null) {
                            kotlin.g.b.p.btv("chpiCouponLayout");
                        }
                        viewGroup2.setOnClickListener(new b(this, udVar, t, linearLayout8.getChildCount(), i4));
                        dA(viewGroup2);
                    }
                    if (i3 > 0 && (i6 = i6 + 1) >= i3) {
                        break;
                    }
                }
                i5++;
                i6 = i6;
            }
            AppMethodBeat.o(112428);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class a implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ int puW;
            final /* synthetic */ e qfP;
            final /* synthetic */ ud qfQ;
            final /* synthetic */ ua qfR;

            a(e eVar, ud udVar, ua uaVar, int i2, int i3) {
                this.qfP = eVar;
                this.qfQ = udVar;
                this.qfR = uaVar;
                this.puW = i2;
                this.gUj = i3;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(112417);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.qfP.qfv.qfc = true;
                this.qfP.qfv.qfd = 0;
                this.qfP.qfv.qfj = this.qfQ;
                e eVar = this.qfP;
                String str = this.qfR.KDM;
                kotlin.g.b.p.g(str, "coupon.user_card_id");
                eVar.ajN(str);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16324, 1, this.qfQ.Ldn, Integer.valueOf(this.puW), this.qfR.KDM, 2, Integer.valueOf(this.gUj), Integer.valueOf(this.qfP.qfv.pVu));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112417);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class b implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ int puW;
            final /* synthetic */ e qfP;
            final /* synthetic */ ud qfQ;
            final /* synthetic */ ua qfR;

            b(e eVar, ud udVar, ua uaVar, int i2, int i3) {
                this.qfP = eVar;
                this.qfQ = udVar;
                this.qfR = uaVar;
                this.puW = i2;
                this.gUj = i3;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(112418);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.qfP.qfv.qfc = true;
                this.qfP.qfv.qfd = 0;
                this.qfP.qfv.qfj = this.qfQ;
                e eVar = this.qfP;
                String str = this.qfR.KDM;
                kotlin.g.b.p.g(str, "coupon.user_card_id");
                eVar.ajN(str);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16324, 1, this.qfQ.Ldn, Integer.valueOf(this.puW), this.qfR.KDM, 2, Integer.valueOf(this.gUj), Integer.valueOf(this.qfP.qfv.pVu));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$appendCouponView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112418);
            }
        }

        public final void ajN(String str) {
            AppMethodBeat.i(112429);
            kotlin.g.b.p.h(str, "cardId");
            Log.i("MicroMsg.CardHomePageNewUI", "go to card detail: %s", str);
            View view = this.aus;
            kotlin.g.b.p.g(view, "itemView");
            Intent intent = new Intent(view.getContext(), CardDetailUI.class);
            intent.putExtra("key_card_id", str);
            intent.addFlags(131072);
            intent.putExtra("key_from_scene", 3);
            View view2 = this.aus;
            kotlin.g.b.p.g(view2, "itemView");
            Context context = view2.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(112429);
        }

        private void dA(View view) {
            AppMethodBeat.i(112430);
            kotlin.g.b.p.h(view, "view");
            LinearLayout linearLayout = this.qfC;
            if (linearLayout == null) {
                kotlin.g.b.p.btv("chpiCouponLayout");
            }
            if (linearLayout.getChildCount() == 0) {
                LinearLayout linearLayout2 = this.qfC;
                if (linearLayout2 == null) {
                    kotlin.g.b.p.btv("chpiCouponLayout");
                }
                linearLayout2.addView(view);
                AppMethodBeat.o(112430);
                return;
            }
            LinearLayout linearLayout3 = this.qfC;
            if (linearLayout3 == null) {
                kotlin.g.b.p.btv("chpiCouponLayout");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(linearLayout3.getContext(), 84));
            LinearLayout linearLayout4 = this.qfC;
            if (linearLayout4 == null) {
                kotlin.g.b.p.btv("chpiCouponLayout");
            }
            marginLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(linearLayout4.getContext(), 8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(marginLayoutParams);
            LinearLayout linearLayout5 = this.qfC;
            if (linearLayout5 == null) {
                kotlin.g.b.p.btv("chpiCouponLayout");
            }
            linearLayout5.addView(view, layoutParams);
            AppMethodBeat.o(112430);
        }

        private void cV(List<? extends ub> list) {
            AppMethodBeat.i(112431);
            kotlin.g.b.p.h(list, "labelList");
            LinearLayout linearLayout = this.qfB;
            if (linearLayout == null) {
                kotlin.g.b.p.btv("chpiLabelLayout");
            }
            linearLayout.removeAllViews();
            if (list.isEmpty()) {
                LinearLayout linearLayout2 = this.qfB;
                if (linearLayout2 == null) {
                    kotlin.g.b.p.btv("chpiLabelLayout");
                }
                linearLayout2.setVisibility(8);
                AppMethodBeat.o(112431);
                return;
            }
            int i2 = 0;
            for (T t : list) {
                LinearLayout linearLayout3 = this.qfB;
                if (linearLayout3 == null) {
                    kotlin.g.b.p.btv("chpiLabelLayout");
                }
                Context context = linearLayout3.getContext();
                kotlin.g.b.p.g(context, "chpiLabelLayout.context");
                CardLabelTextView cardLabelTextView = new CardLabelTextView(context);
                LinearLayout linearLayout4 = this.qfB;
                if (linearLayout4 == null) {
                    kotlin.g.b.p.btv("chpiLabelLayout");
                }
                Context context2 = linearLayout4.getContext();
                cardLabelTextView.setTextSize(1, 12.0f);
                cardLabelTextView.setText(t.Ldh);
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context2, 4);
                cardLabelTextView.setPadding(fromDPToPix, 0, fromDPToPix, 0);
                cardLabelTextView.setGravity(16);
                if (!Util.isNullOrNil(t.Ldi)) {
                    cardLabelTextView.setTextColor(Color.parseColor(t.Ldi));
                } else {
                    cardLabelTextView.setTextColor(-1);
                }
                if (!Util.isNullOrNil(t.Ldj)) {
                    cardLabelTextView.setFillColor(com.tencent.mm.plugin.card.d.l.cT(t.Ldj, t.Ldm));
                } else {
                    cardLabelTextView.setFillColor(0);
                }
                if (i2 > 0) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                    marginLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(context2, 4);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(marginLayoutParams);
                    LinearLayout linearLayout5 = this.qfB;
                    if (linearLayout5 == null) {
                        kotlin.g.b.p.btv("chpiLabelLayout");
                    }
                    linearLayout5.addView(cardLabelTextView, layoutParams);
                } else {
                    LinearLayout linearLayout6 = this.qfB;
                    if (linearLayout6 == null) {
                        kotlin.g.b.p.btv("chpiLabelLayout");
                    }
                    linearLayout6.addView(cardLabelTextView);
                }
                i2++;
            }
            LinearLayout linearLayout7 = this.qfB;
            if (linearLayout7 == null) {
                kotlin.g.b.p.btv("chpiLabelLayout");
            }
            linearLayout7.setVisibility(0);
            AppMethodBeat.o(112431);
        }

        private void a(List<? extends tz> list, LinearLayout linearLayout) {
            AppMethodBeat.i(112432);
            kotlin.g.b.p.h(list, "couponLabelList");
            kotlin.g.b.p.h(linearLayout, "labelLayout");
            for (tz tzVar : list) {
                LinearLayout linearLayout2 = this.qfC;
                if (linearLayout2 == null) {
                    kotlin.g.b.p.btv("chpiCouponLayout");
                }
                CardTagTextView cardTagTextView = new CardTagTextView(linearLayout2.getContext());
                LinearLayout linearLayout3 = this.qfC;
                if (linearLayout3 == null) {
                    kotlin.g.b.p.btv("chpiCouponLayout");
                }
                Context context = linearLayout3.getContext();
                cardTagTextView.setMinHeight(com.tencent.mm.cb.a.fromDPToPix(context, 18));
                cardTagTextView.setMinWidth(com.tencent.mm.cb.a.fromDPToPix(context, 56));
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 8);
                int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(context, 4);
                cardTagTextView.setPadding(fromDPToPix, fromDPToPix2, fromDPToPix, fromDPToPix2);
                cardTagTextView.setText(tzVar.LcI);
                cardTagTextView.setTextSize(1, 10.0f);
                if (!Util.isNullOrNil(tzVar.LcJ)) {
                    cardTagTextView.setTextColor(Color.parseColor(tzVar.LcJ));
                } else {
                    cardTagTextView.setTextColor(-1);
                }
                if (!Util.isNullOrNil(tzVar.LcK)) {
                    cardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.cT(tzVar.LcK, tzVar.LcN));
                } else {
                    cardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.fj(WebView.NIGHT_MODE_COLOR, 26));
                }
                linearLayout.addView(cardTagTextView);
            }
            AppMethodBeat.o(112432);
        }

        private static void b(ImageView imageView, String str) {
            AppMethodBeat.i(112433);
            kotlin.g.b.p.h(imageView, "imageView");
            kotlin.g.b.p.h(str, "url");
            c.a aVar = new c.a();
            aVar.OT(com.tencent.mm.loader.j.b.aKJ());
            aVar.a(q.bcW());
            aVar.OS(com.tencent.mm.plugin.card.model.m.ajp(str));
            aVar.bdp();
            aVar.bdt();
            aVar.bdu();
            aVar.bdo();
            aVar.ty(R.raw.card_default_merchant_icon);
            q.bcV().a(str, imageView, aVar.bdv());
            AppMethodBeat.o(112433);
        }

        private final void Ey(int i2) {
            AppMethodBeat.i(112434);
            a aVar = this.qfO;
            if (aVar == null) {
                kotlin.g.b.p.hyc();
            }
            ud udVar = aVar.qfp;
            if (udVar == null) {
                kotlin.g.b.p.hyc();
            }
            if (!Util.isNullOrNil(udVar.Ldt)) {
                if (!Util.isNullOrNil(udVar.Ldu)) {
                    TextView textView = this.qfE;
                    if (textView == null) {
                        kotlin.g.b.p.btv("chpiExpandTv");
                    }
                    textView.setTextColor(Color.parseColor(udVar.Ldu));
                }
                TextView textView2 = this.qfE;
                if (textView2 == null) {
                    kotlin.g.b.p.btv("chpiExpandTv");
                }
                textView2.setText(udVar.Ldt);
                ImageView imageView = this.qfF;
                if (imageView == null) {
                    kotlin.g.b.p.btv("chpiExpandIv");
                }
                imageView.setImageResource(R.drawable.c1h);
                LinearLayout linearLayout = this.qfD;
                if (linearLayout == null) {
                    kotlin.g.b.p.btv("chpiExpandLayout");
                }
                linearLayout.setOnClickListener(new i(udVar, this, i2));
            }
            AppMethodBeat.o(112434);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$1$1"})
        public static final class i implements View.OnClickListener {
            final /* synthetic */ int oeZ;
            final /* synthetic */ e qfP;
            final /* synthetic */ ud qfS;

            i(ud udVar, e eVar, int i2) {
                this.qfS = udVar;
                this.qfP = eVar;
                this.oeZ = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(112425);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.qfS.Ldv != null) {
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(this.qfS.Ldv != null);
                    Log.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", objArr);
                    this.qfP.qfv.qfc = true;
                    this.qfP.qfv.qfd = 0;
                    this.qfP.qfv.qfj = this.qfS;
                    com.tencent.mm.plugin.card.d.b.H(this.qfS.Ldv.Hwr, this.qfS.Ldv.Hws, this.qfS.Ldv.IhZ);
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr2 = new Object[7];
                objArr2[0] = 1;
                a aVar = this.qfP.qfO;
                if (aVar == null) {
                    kotlin.g.b.p.hyc();
                }
                ud udVar = aVar.qfp;
                if (udVar == null) {
                    kotlin.g.b.p.hyc();
                }
                objArr2[1] = udVar.Ldn;
                objArr2[2] = 0;
                objArr2[3] = 0;
                objArr2[4] = 6;
                objArr2[5] = Integer.valueOf(this.oeZ);
                objArr2[6] = Integer.valueOf(this.qfP.qfv.pVu);
                hVar.a(16324, objArr2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112425);
            }
        }

        private final void Ez(int i2) {
            AppMethodBeat.i(112435);
            a aVar = this.qfO;
            if (aVar == null) {
                kotlin.g.b.p.hyc();
            }
            ud udVar = aVar.qfp;
            TextView textView = this.qfE;
            if (textView == null) {
                kotlin.g.b.p.btv("chpiExpandTv");
            }
            Resources resources = MMApplicationContext.getResources();
            Object[] objArr = new Object[1];
            if (udVar == null) {
                kotlin.g.b.p.hyc();
            }
            objArr[0] = Integer.valueOf(udVar.Ldy - udVar.Ldz);
            textView.setText(resources.getString(R.string.apo, objArr));
            LinearLayout linearLayout = this.qfD;
            if (linearLayout == null) {
                kotlin.g.b.p.btv("chpiExpandLayout");
            }
            linearLayout.setOnClickListener(new h(this, i2, udVar));
            ImageView imageView = this.qfF;
            if (imageView == null) {
                kotlin.g.b.p.btv("chpiExpandIv");
            }
            imageView.setImageResource(R.drawable.c2_);
            ImageView imageView2 = this.qfF;
            if (imageView2 == null) {
                kotlin.g.b.p.btv("chpiExpandIv");
            }
            imageView2.setVisibility(0);
            AppMethodBeat.o(112435);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class h implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ e qfP;
            final /* synthetic */ ud qfQ;

            h(e eVar, int i2, ud udVar) {
                this.qfP = eVar;
                this.gUj = i2;
                this.qfQ = udVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(112424);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.CardHomePageNewUI", "do expand coupon layout");
                e.a(this.qfP, this.gUj);
                a aVar = this.qfP.qfO;
                if (aVar != null) {
                    aVar.qfs = true;
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[7];
                objArr[0] = 1;
                ud udVar = this.qfQ;
                if (udVar == null) {
                    kotlin.g.b.p.hyc();
                }
                objArr[1] = udVar.Ldn;
                objArr[2] = 0;
                objArr[3] = 0;
                objArr[4] = 4;
                objArr[5] = Integer.valueOf(this.gUj);
                objArr[6] = Integer.valueOf(this.qfP.qfv.pVu);
                hVar.a(16324, objArr);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112424);
            }
        }

        private final void EA(int i2) {
            AppMethodBeat.i(112436);
            a aVar = this.qfO;
            if (aVar == null) {
                kotlin.g.b.p.hyc();
            }
            ud udVar = aVar.qfp;
            TextView textView = this.qfE;
            if (textView == null) {
                kotlin.g.b.p.btv("chpiExpandTv");
            }
            textView.setText(MMApplicationContext.getResources().getString(R.string.apm));
            LinearLayout linearLayout = this.qfD;
            if (linearLayout == null) {
                kotlin.g.b.p.btv("chpiExpandLayout");
            }
            linearLayout.setOnClickListener(new g(this, i2, udVar));
            ImageView imageView = this.qfF;
            if (imageView == null) {
                kotlin.g.b.p.btv("chpiExpandIv");
            }
            imageView.setImageResource(R.drawable.c2a);
            ImageView imageView2 = this.qfF;
            if (imageView2 == null) {
                kotlin.g.b.p.btv("chpiExpandIv");
            }
            imageView2.setVisibility(0);
            AppMethodBeat.o(112436);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class g implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ e qfP;
            final /* synthetic */ ud qfQ;

            g(e eVar, int i2, ud udVar) {
                this.qfP = eVar;
                this.gUj = i2;
                this.qfQ = udVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(112423);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
                e.b(this.qfP, this.gUj);
                a aVar = this.qfP.qfO;
                if (aVar != null) {
                    aVar.qfs = false;
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[7];
                objArr[0] = 1;
                ud udVar = this.qfQ;
                if (udVar == null) {
                    kotlin.g.b.p.hyc();
                }
                objArr[1] = udVar.Ldn;
                objArr[2] = 0;
                objArr[3] = 0;
                objArr[4] = 5;
                objArr[5] = Integer.valueOf(this.gUj);
                objArr[6] = Integer.valueOf(this.qfP.qfv.pVu);
                hVar.a(16324, objArr);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112423);
            }
        }

        private final void C(boolean z, int i2) {
            AppMethodBeat.i(112437);
            a aVar = this.qfO;
            if (aVar == null) {
                kotlin.g.b.p.hyc();
            }
            ud udVar = aVar.qfp;
            if (z) {
                if (!Util.isNullOrNil(udVar != null ? udVar.Ldt : null)) {
                    Ey(i2);
                    AppMethodBeat.o(112437);
                    return;
                }
                EA(i2);
                AppMethodBeat.o(112437);
                return;
            }
            Ez(i2);
            AppMethodBeat.o(112437);
        }

        public static final /* synthetic */ void a(e eVar, int i2) {
            AppMethodBeat.i(112439);
            a aVar = eVar.qfO;
            if (aVar == null) {
                kotlin.g.b.p.hyc();
            }
            ud udVar = aVar.qfp;
            LinearLayout linearLayout = eVar.qfC;
            if (linearLayout == null) {
                kotlin.g.b.p.btv("chpiCouponLayout");
            }
            int childCount = linearLayout.getChildCount();
            if (udVar == null) {
                kotlin.g.b.p.hyc();
            }
            if (childCount < udVar.Ldy) {
                eVar.V(udVar.Ldz, -1, i2);
                if (udVar.Ldz >= udVar.Ldy) {
                    LinearLayout linearLayout2 = eVar.qfD;
                    if (linearLayout2 == null) {
                        kotlin.g.b.p.btv("chpiExpandLayout");
                    }
                    linearLayout2.setVisibility(8);
                    AppMethodBeat.o(112439);
                    return;
                }
                eVar.C(true, i2);
            }
            AppMethodBeat.o(112439);
        }

        public static final /* synthetic */ void b(e eVar, int i2) {
            AppMethodBeat.i(112440);
            a aVar = eVar.qfO;
            if (aVar == null) {
                kotlin.g.b.p.hyc();
            }
            ud udVar = aVar.qfp;
            LinearLayout linearLayout = eVar.qfC;
            if (linearLayout == null) {
                kotlin.g.b.p.btv("chpiCouponLayout");
            }
            int childCount = linearLayout.getChildCount();
            if (udVar == null) {
                kotlin.g.b.p.hyc();
            }
            if (childCount > udVar.Ldz) {
                Object[] objArr = new Object[2];
                LinearLayout linearLayout2 = eVar.qfC;
                if (linearLayout2 == null) {
                    kotlin.g.b.p.btv("chpiCouponLayout");
                }
                objArr[0] = Integer.valueOf(linearLayout2.getChildCount());
                objArr[1] = Integer.valueOf(udVar.Ldz);
                Log.d("MicroMsg.CardHomePageNewUI", "collapse count: %s, limit: %s", objArr);
                LinearLayout linearLayout3 = eVar.qfC;
                if (linearLayout3 == null) {
                    kotlin.g.b.p.btv("chpiCouponLayout");
                }
                int childCount2 = linearLayout3.getChildCount() - 1;
                int i3 = udVar.Ldz;
                if (childCount2 >= i3) {
                    while (true) {
                        LinearLayout linearLayout4 = eVar.qfC;
                        if (linearLayout4 == null) {
                            kotlin.g.b.p.btv("chpiCouponLayout");
                        }
                        linearLayout4.removeViewAt(childCount2);
                        if (childCount2 == i3) {
                            break;
                        }
                        childCount2--;
                    }
                }
            }
            eVar.C(false, i2);
            AppMethodBeat.o(112440);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$1"})
    public static final class o implements o.f {
        final /* synthetic */ CardHomePageNewUI qfv;

        o(CardHomePageNewUI cardHomePageNewUI) {
            this.qfv = cardHomePageNewUI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(112457);
            int i2 = 0;
            for (uv uvVar : this.qfv.qfg) {
                mVar.add(0, i2, 1, uvVar.Les);
                i2++;
            }
            AppMethodBeat.o(112457);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$2"})
    public static final class p implements o.g {
        final /* synthetic */ CardHomePageNewUI qfv;

        p(CardHomePageNewUI cardHomePageNewUI) {
            this.qfv = cardHomePageNewUI;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(112459);
            kotlin.g.b.p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            Log.i("MicroMsg.CardHomePageNewUI", "click item: %s, sortType: %s", Integer.valueOf(itemId), Integer.valueOf(this.qfv.pVu));
            Object obj = this.qfv.qfg.get(itemId);
            kotlin.g.b.p.g(obj, "cardSortInfoList[itemId]");
            uv uvVar = (uv) obj;
            this.qfv.qeS = uvVar.Ler;
            if (uvVar.Leq != 1 || this.qfv.pVu == 1) {
                if (uvVar.Leq != 2 || this.qfv.pVu == 2) {
                    if (uvVar.Leq == 3 && this.qfv.pVu != 3) {
                        this.qfv.qfk = true;
                        this.qfv.offset = 0;
                        this.qfv.pVu = 3;
                        CardHomePageNewUI.r(this.qfv);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 17);
                    }
                    AppMethodBeat.o(112459);
                    return;
                }
                this.qfv.qfk = true;
                this.qfv.offset = 0;
                this.qfv.pVu = 2;
                CardHomePageNewUI.r(this.qfv);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 16);
                AppMethodBeat.o(112459);
            } else if (!this.qfv.qgs) {
                com.tencent.mm.ui.base.h.a((Context) this.qfv.getContext(), this.qfv.getString(R.string.aq9), this.qfv.getString(R.string.flp), this.qfv.getString(R.string.e_k), this.qfv.getString(R.string.b96), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.p.AnonymousClass1 */
                    final /* synthetic */ p qge;

                    {
                        this.qge = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(112458);
                        this.qge.qfv.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
                        AppMethodBeat.o(112458);
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(112459);
            } else {
                this.qfv.qfk = true;
                this.qfv.offset = 0;
                this.qfv.pVu = 1;
                CardHomePageNewUI.r(this.qfv);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 15);
                AppMethodBeat.o(112459);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "sectionTitle", "", "getSectionTitle", "()Ljava/lang/String;", "setSectionTitle", "(Ljava/lang/String;)V", "showDivider", "getShowDivider", "setShowDivider", "topElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "getTopElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "setTopElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;)V", "type", "", "getType", "()I", "setType", "(I)V", "plugin-card_release"})
    public final class a {
        ud qfp;
        public String qfq;
        boolean qfr;
        boolean qfs;
        ui qft;
        boolean qfu;
        int type;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public final void ajK(String str) {
            AppMethodBeat.i(112405);
            kotlin.g.b.p.h(str, "<set-?>");
            this.qfq = str;
            AppMethodBeat.o(112405);
        }

        public final String cxc() {
            AppMethodBeat.i(112404);
            String str = this.qfq;
            if (str == null) {
                kotlin.g.b.p.btv("sectionTitle");
            }
            AppMethodBeat.o(112404);
            return str;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "linkColor", "", "bgColor", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;IILcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "plugin-card_release"})
    public final class b extends com.tencent.mm.pluginsdk.ui.span.p {
        final /* synthetic */ CardHomePageNewUI qfv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CardHomePageNewUI cardHomePageNewUI, int i2, int i3, com.tencent.mm.pluginsdk.ui.span.j jVar) {
            super(i2, i3);
            kotlin.g.b.p.h(jVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.qfv = cardHomePageNewUI;
            AppMethodBeat.i(112407);
            this.mClickListener = jVar;
            AppMethodBeat.o(112407);
        }

        @Override // com.tencent.mm.pluginsdk.ui.span.p
        public final void onClick(View view) {
            AppMethodBeat.i(112406);
            kotlin.g.b.p.h(view, "widget");
            if (this.mClickListener != null) {
                this.mClickListener.a(view, null);
            }
            AppMethodBeat.o(112406);
        }
    }

    public static final /* synthetic */ void p(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.i(112472);
        if (cardHomePageNewUI.qfg != null) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) cardHomePageNewUI.getContext(), 1, false);
            eVar.a(new o(cardHomePageNewUI));
            eVar.a(new p(cardHomePageNewUI));
            eVar.dGm();
        }
        AppMethodBeat.o(112472);
    }
}
