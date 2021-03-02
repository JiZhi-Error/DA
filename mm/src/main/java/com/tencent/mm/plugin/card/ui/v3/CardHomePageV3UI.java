package com.tencent.mm.plugin.card.ui.v3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.w;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.card.model.a.a;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.ui.v2.CardTicketListUI;
import com.tencent.mm.plugin.card.ui.v4.CouponAndGiftCardListV4UI;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.dmt;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.protobuf.uf;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.kernel.i
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 N2\u00020\u0001:\u0003LMNB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0012H\u0002J\u0016\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004J\b\u0010,\u001a\u00020\u0006H\u0014J\u0010\u0010-\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0004H\u0002J\b\u0010.\u001a\u00020'H\u0002J\u0012\u0010/\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u00101\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u00102\u001a\u00020'H\u0002J\b\u00103\u001a\u00020'H\u0002J\b\u00104\u001a\u00020'H\u0014J\b\u00105\u001a\u00020'H\u0002J\"\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\u0012\u0010;\u001a\u00020'2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020'H\u0014J\b\u0010?\u001a\u00020'H\u0014J\u0010\u0010@\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0004H\u0002J\b\u0010A\u001a\u00020'H\u0002J\b\u0010B\u001a\u00020'H\u0002J\u0012\u0010C\u001a\u00020'2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0012\u0010F\u001a\u00020'2\b\u0010G\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010H\u001a\u00020'2\b\u0010I\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010J\u001a\u00020'H\u0002J\u0012\u0010K\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "loadCount", "", "loadingDialog", "Landroid/app/Dialog;", "mCardDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lkotlin/collections/ArrayList;", "mCardHomePageTopCellGroup", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellGroup;", "mFAQItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "mHasLoadedSuccess", "", "mHeaderContainerLayout", "Landroid/view/ViewGroup;", "mHeaderView", "mHomePageEmptyView", "Landroid/view/View;", "mHomePageRecentlyUsedCardTitleTv", "Landroid/widget/TextView;", "mIsAll", "mIsLoading", "mNeedRefreshPage", "mOffset", "mPageAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mPageRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mViewHeight", "mViewWidth", "doLoadHomePage", "", "refresh", "doRemoveRecentlyCard", "cardId", "userCardId", "getLayoutId", "gotoCardDetailUI", "gotoCertListUI", "gotoCouponCardListUI", "title", "gotoCouponGiftCardListUI", "gotoVipCardListUI", "hideLoading", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "removeCardByCardId", "saveSnapshot", "showLoading", "updateCardList", "cardList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedList;", "updateFAQ", "faqItem", "updateHeader", "topCellGroup", "updateRecentlyUsedCardTitleLayout", "updateRecentlyUsedTitle", "CardConvertData", "CardConverter", "Companion", "plugin-card_release"})
public final class CardHomePageV3UI extends MMActivity {
    public static final c qhl = new c((byte) 0);
    String TAG = "MicroMsg.CardHomePageV3UI";
    private int aYN;
    private int aYO;
    private int fs;
    private boolean mwr;
    private WxRecyclerView qgX;
    private RefreshLoadMoreLayout qgY;
    private ViewGroup qgZ;
    private ViewGroup qha;
    private TextView qhb;
    private View qhc;
    private WxRecyclerAdapter<a> qhd;
    private ArrayList<a> qhe = new ArrayList<>();
    private boolean qhf;
    private boolean qhg;
    private boolean qhh;
    private uj qhi;
    private ue qhj;
    private int qhk;

    static {
        AppMethodBeat.i(201468);
        AppMethodBeat.o(201468);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<c.a<bqq>, x> {
        final /* synthetic */ boolean qgO;
        final /* synthetic */ CardHomePageV3UI qhn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(CardHomePageV3UI cardHomePageV3UI, boolean z) {
            super(1);
            this.qhn = cardHomePageV3UI;
            this.qgO = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(c.a<bqq> aVar) {
            AppMethodBeat.i(201443);
            c.a<bqq> aVar2 = aVar;
            if (aVar2 != null) {
                Log.i(this.qhn.TAG, "errType: " + aVar2.errType + ", errCode: " + aVar2.errCode + ", errMsg: " + aVar2.errMsg);
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    bqq bqq = (bqq) aVar2.iLC;
                    if (bqq != null) {
                        Log.i(this.qhn.TAG, "retcode: " + bqq.pTZ + ", retmsg: " + bqq.pUa);
                        if (bqq.pTZ == 0) {
                            this.qhn.fs = bqq.qGg;
                            this.qhn.qhf = bqq.LUO > 0;
                            this.qhn.qhg = true;
                            CardHomePageV3UI.b(this.qhn, bqq.LYm);
                            CardHomePageV3UI.a(this.qhn, bqq.LYk);
                            if (this.qgO) {
                                this.qhn.qhe.clear();
                            }
                            CardHomePageV3UI.a(this.qhn, bqq.LYl);
                            CardHomePageV3UI.a(this.qhn, bqq.LYh);
                        } else {
                            com.tencent.mm.plugin.card.d.l.aq(this.qhn.getContext(), bqq.pUa);
                        }
                    }
                } else {
                    com.tencent.mm.plugin.card.d.l.ar(this.qhn.getContext(), "");
                }
            }
            this.qhn.mwr = false;
            if (!this.qgO) {
                CardHomePageV3UI.g(this.qhn).apT(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(201443);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
    static final class e extends q implements kotlin.g.a.b<c.a<dmt>, x> {
        final /* synthetic */ CardHomePageV3UI qhn;
        final /* synthetic */ String qhu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(CardHomePageV3UI cardHomePageV3UI, String str) {
            super(1);
            this.qhn = cardHomePageV3UI;
            this.qhu = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(c.a<dmt> aVar) {
            AppMethodBeat.i(201444);
            c.a<dmt> aVar2 = aVar;
            CardHomePageV3UI.cxl();
            if (aVar2 != null) {
                Log.i(this.qhn.TAG, "errType: " + aVar2.errType + ", errCode: " + aVar2.errCode + ", errMsg: " + aVar2.errMsg);
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    dmt dmt = (dmt) aVar2.iLC;
                    if (dmt != null) {
                        Log.i(this.qhn.TAG, "retcode: " + dmt.pTZ + ", retmsg: " + dmt.pUa);
                        if (dmt.pTZ == 0) {
                            CardHomePageV3UI.c(this.qhn, this.qhu);
                            CardHomePageV3UI.k(this.qhn);
                        } else {
                            com.tencent.mm.plugin.card.d.l.aq(this.qhn.getContext(), dmt.pUa);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(201444);
                        return xVar;
                    }
                    AppMethodBeat.o(201444);
                    return null;
                }
                com.tencent.mm.plugin.card.d.l.ar(this.qhn.getContext(), "");
                x xVar2 = x.SXb;
                AppMethodBeat.o(201444);
                return xVar2;
            }
            AppMethodBeat.o(201444);
            return null;
        }
    }

    public CardHomePageV3UI() {
        AppMethodBeat.i(201467);
        AppMethodBeat.o(201467);
    }

    public static final /* synthetic */ void a(CardHomePageV3UI cardHomePageV3UI, ue ueVar) {
        AppMethodBeat.i(201475);
        cardHomePageV3UI.a(ueVar);
        AppMethodBeat.o(201475);
    }

    public static final /* synthetic */ void a(CardHomePageV3UI cardHomePageV3UI, ug ugVar) {
        AppMethodBeat.i(201474);
        cardHomePageV3UI.a(ugVar);
        AppMethodBeat.o(201474);
    }

    public static final /* synthetic */ void a(CardHomePageV3UI cardHomePageV3UI, uj ujVar) {
        AppMethodBeat.i(201473);
        cardHomePageV3UI.a(ujVar);
        AppMethodBeat.o(201473);
    }

    public static final /* synthetic */ void b(CardHomePageV3UI cardHomePageV3UI, String str) {
        AppMethodBeat.i(201472);
        cardHomePageV3UI.ajS(str);
        AppMethodBeat.o(201472);
    }

    public static final /* synthetic */ void cxl() {
    }

    public static final /* synthetic */ void d(CardHomePageV3UI cardHomePageV3UI) {
        AppMethodBeat.i(201470);
        cardHomePageV3UI.kz(false);
        AppMethodBeat.o(201470);
    }

    public static final /* synthetic */ RefreshLoadMoreLayout g(CardHomePageV3UI cardHomePageV3UI) {
        AppMethodBeat.i(201471);
        RefreshLoadMoreLayout refreshLoadMoreLayout = cardHomePageV3UI.qgY;
        if (refreshLoadMoreLayout == null) {
            p.btv("mRefreshLayout");
        }
        AppMethodBeat.o(201471);
        return refreshLoadMoreLayout;
    }

    public static final /* synthetic */ void k(CardHomePageV3UI cardHomePageV3UI) {
        AppMethodBeat.i(201477);
        cardHomePageV3UI.cxk();
        AppMethodBeat.o(201477);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$Companion;", "", "()V", "CONVERT_TYPE_CARD", "", "CONVERT_TYPE_HEADER", "REQUEST_CODE_CARD_DETAIL", "REQUEST_CODE_COUPON", "REQUEST_CODE_COUPON_GIFT_CARD", "REQUEST_CODE_TICKET", "REQUEST_CODE_VIP", "plugin-card_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(201456);
        super.onCreate(bundle);
        initView();
        setMMTitle(R.string.aq7);
        setActionbarColor(getResources().getColor(R.color.f3043a));
        hideActionbarLine();
        setBackBtn(new h(this));
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        bqq cuh = a.C0902a.cuh();
        if (cuh != null) {
            this.fs = cuh.qGg;
            ajS(cuh.LYm);
            a(cuh.LYk);
            a(cuh.LYl);
            a(cuh.LYh);
        }
        kz(true);
        AppMethodBeat.o(201456);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class h implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ CardHomePageV3UI qhn;

        h(CardHomePageV3UI cardHomePageV3UI) {
            this.qhn = cardHomePageV3UI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201451);
            this.qhn.finish();
            AppMethodBeat.o(201451);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(201457);
        View findViewById = findViewById(R.id.b2g);
        p.g(findViewById, "findViewById(R.id.chpuv3_rv)");
        this.qgX = (WxRecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.b2f);
        p.g(findViewById2, "findViewById(R.id.chpuv3_refresh_layout)");
        this.qgY = (RefreshLoadMoreLayout) findViewById2;
        WxRecyclerView wxRecyclerView = this.qgX;
        if (wxRecyclerView == null) {
            p.btv("mPageRv");
        }
        getContext();
        wxRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        this.qhd = new WxRecyclerAdapter<>(new f(this), this.qhe);
        WxRecyclerAdapter<a> wxRecyclerAdapter = this.qhd;
        if (wxRecyclerAdapter == null) {
            p.btv("mPageAdapter");
        }
        wxRecyclerAdapter.au(true);
        WxRecyclerView wxRecyclerView2 = this.qgX;
        if (wxRecyclerView2 == null) {
            p.btv("mPageRv");
        }
        WxRecyclerAdapter<a> wxRecyclerAdapter2 = this.qhd;
        if (wxRecyclerAdapter2 == null) {
            p.btv("mPageAdapter");
        }
        wxRecyclerView2.setAdapter(wxRecyclerAdapter2);
        w wVar = new w(getContext(), 1);
        wVar.setDrawable(getResources().getDrawable(R.drawable.lk));
        WxRecyclerView wxRecyclerView3 = this.qgX;
        if (wxRecyclerView3 == null) {
            p.btv("mPageRv");
        }
        wxRecyclerView3.b(wVar);
        LayoutInflater layoutInflater = getLayoutInflater();
        WxRecyclerView wxRecyclerView4 = this.qgX;
        if (wxRecyclerView4 == null) {
            p.btv("mPageRv");
        }
        View inflate = layoutInflater.inflate(R.layout.nk, (ViewGroup) wxRecyclerView4, false);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(201457);
            throw tVar;
        }
        this.qgZ = (ViewGroup) inflate;
        ViewGroup viewGroup = this.qgZ;
        if (viewGroup == null) {
            p.btv("mHeaderView");
        }
        View findViewById3 = viewGroup.findViewById(R.id.b1n);
        p.g(findViewById3, "mHeaderView.findViewById…_header_container_layout)");
        this.qha = (ViewGroup) findViewById3;
        ViewGroup viewGroup2 = this.qgZ;
        if (viewGroup2 == null) {
            p.btv("mHeaderView");
        }
        View findViewById4 = viewGroup2.findViewById(R.id.b1p);
        p.g(findViewById4, "mHeaderView.findViewById…hphv3_home_page_title_tv)");
        this.qhb = (TextView) findViewById4;
        ViewGroup viewGroup3 = this.qgZ;
        if (viewGroup3 == null) {
            p.btv("mHeaderView");
        }
        View findViewById5 = viewGroup3.findViewById(R.id.b1o);
        p.g(findViewById5, "mHeaderView.findViewById…3_home_page_empty_layout)");
        this.qhc = findViewById5;
        WxRecyclerAdapter<a> wxRecyclerAdapter3 = this.qhd;
        if (wxRecyclerAdapter3 == null) {
            p.btv("mPageAdapter");
        }
        ViewGroup viewGroup4 = this.qgZ;
        if (viewGroup4 == null) {
            p.btv("mHeaderView");
        }
        wxRecyclerAdapter3.f(viewGroup4, 2, false);
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.qgY;
        if (refreshLoadMoreLayout == null) {
            p.btv("mRefreshLayout");
        }
        refreshLoadMoreLayout.setEnableRefresh(false);
        RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.qgY;
        if (refreshLoadMoreLayout2 == null) {
            p.btv("mRefreshLayout");
        }
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 1200);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        refreshLoadMoreLayout2.setLimitTopRequest(fromDPToPix - ((int) context.getResources().getDimension(R.dimen.bx)));
        RefreshLoadMoreLayout refreshLoadMoreLayout3 = this.qgY;
        if (refreshLoadMoreLayout3 == null) {
            p.btv("mRefreshLayout");
        }
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        refreshLoadMoreLayout3.setRefreshTargetY(((int) context2.getResources().getDimension(R.dimen.cp)) - com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 1200));
        RefreshLoadMoreLayout refreshLoadMoreLayout4 = this.qgY;
        if (refreshLoadMoreLayout4 == null) {
            p.btv("mRefreshLayout");
        }
        refreshLoadMoreLayout4.setDamping(1.85f);
        RefreshLoadMoreLayout refreshLoadMoreLayout5 = this.qgY;
        if (refreshLoadMoreLayout5 == null) {
            p.btv("mRefreshLayout");
        }
        refreshLoadMoreLayout5.setActionCallback(new g(this));
        AppMethodBeat.o(201457);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
    public static final class f implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ CardHomePageV3UI qhn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(CardHomePageV3UI cardHomePageV3UI) {
            this.qhn = cardHomePageV3UI;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(201445);
            b bVar = new b();
            AppMethodBeat.o(201445);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-card_release"})
    public static final class g extends RefreshLoadMoreLayout.a {
        final /* synthetic */ CardHomePageV3UI qhn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(CardHomePageV3UI cardHomePageV3UI) {
            this.qhn = cardHomePageV3UI;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(201447);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            Log.d(this.qhn.TAG, "on load more");
            com.tencent.mm.ac.d.h(new a(this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(201447);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(201448);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            Log.d(this.qhn.TAG, "on load more end: " + this.qhn.qhk);
            if (this.qhn.qhf) {
                CardHomePageV3UI.g(this.qhn).h((RefreshLoadMoreLayout.c<Object>) null);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(201448);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(201449);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            Log.d(this.qhn.TAG, "on begin refresh");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(201449);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(201450);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            Log.d(this.qhn.TAG, "on refresh end");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(201450);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ g qhv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(0);
                this.qhv = gVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(201446);
                CardHomePageV3UI.d(this.qhv.qhn);
                x xVar = x.SXb;
                AppMethodBeat.o(201446);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(201458);
        super.onResume();
        if (this.qhh) {
            kz(true);
            this.qhh = false;
        }
        AppMethodBeat.o(201458);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(201459);
        super.onDestroy();
        if (!this.qhg) {
            Log.i(this.TAG, "no data to save snapshot");
            AppMethodBeat.o(201459);
            return;
        }
        bqq bqq = new bqq();
        bqq.BaseResponse = new BaseResponse();
        bqq.BaseResponse.ErrMsg = new dqi();
        bqq.LYk = this.qhi;
        TextView textView = this.qhb;
        if (textView == null) {
            p.btv("mHomePageRecentlyUsedCardTitleTv");
        }
        bqq.LYm = textView.getText().toString();
        bqq.LYl = new ug();
        bqq.qGg = this.fs;
        bqq.LYh = this.qhj;
        Iterator<a> it = this.qhe.iterator();
        while (it.hasNext()) {
            uf cxm = it.next().cxm();
            if (cxm != null) {
                bqq.LYl.LdH.add(cxm);
            }
        }
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        p.h(bqq, "response");
        Log.d(com.tencent.mm.plugin.card.model.a.a.TAG, "save home page v3 snapshot");
        com.tencent.mm.ac.d.i(new a.C0902a.e(bqq));
        AppMethodBeat.o(201459);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.nm;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(201460);
        switch (i2) {
            case 1:
                kz(true);
                break;
            case 2:
                kz(true);
                break;
            case 3:
            case 5:
                kz(true);
                break;
            case 4:
                kz(true);
                break;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(201460);
    }

    private final void kz(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(201461);
        Log.i(this.TAG, "do load home page");
        if (this.qhf && !z) {
            Log.w(this.TAG, "already load complete");
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.qgY;
            if (refreshLoadMoreLayout == null) {
                p.btv("mRefreshLayout");
            }
            refreshLoadMoreLayout.apT(0);
            AppMethodBeat.o(201461);
        } else if (this.mwr) {
            Log.w(this.TAG, "is loading");
            AppMethodBeat.o(201461);
        } else {
            this.mwr = true;
            int i3 = this.fs;
            if (z) {
                RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.qgY;
                if (refreshLoadMoreLayout2 == null) {
                    p.btv("mRefreshLayout");
                }
                refreshLoadMoreLayout2.setHasBottomMore(true);
            } else {
                i2 = i3;
            }
            com.tencent.mm.co.f aYI = new com.tencent.mm.plugin.card.model.b.c(i2).aYI();
            p.g(aYI, "CgiGetMktCardHomePageV3(offset, 10).run()");
            com.tencent.mm.ac.d.b(aYI, new d(this, z));
            AppMethodBeat.o(201461);
        }
    }

    private final void a(ue ueVar) {
        AppMethodBeat.i(201462);
        if (ueVar != null) {
            this.qhj = ueVar;
            if (!Util.isNullOrNil(ueVar.LdB)) {
                removeAllOptionMenu();
                addIconOptionMenu(0, 0, R.raw.icons_outlined_more, new i(ueVar, this));
            }
            AppMethodBeat.o(201462);
            return;
        }
        AppMethodBeat.o(201462);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateFAQ$1$1"})
    public static final class i implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ue qgc;
        final /* synthetic */ CardHomePageV3UI qhn;

        i(ue ueVar, CardHomePageV3UI cardHomePageV3UI) {
            this.qgc = ueVar;
            this.qhn = cardHomePageV3UI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201454);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.qhn.getContext(), 1, false);
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI.i.AnonymousClass1 */
                final /* synthetic */ i qhw;

                {
                    this.qhw = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(201452);
                    mVar.add(0, 0, 1, this.qhw.qgc.LdB);
                    AppMethodBeat.o(201452);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI.i.AnonymousClass2 */
                final /* synthetic */ i qhw;

                {
                    this.qhw = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(201453);
                    p.g(menuItem, "menuItem");
                    if (menuItem.getItemId() == 0) {
                        switch (this.qhw.qgc.LdC) {
                            case 1:
                                com.tencent.mm.plugin.card.d.b.a((MMActivity) this.qhw.qhn.getContext(), this.qhw.qgc.LdD);
                                AppMethodBeat.o(201453);
                                return;
                            case 2:
                                un unVar = this.qhw.qgc.LdE;
                                com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                                break;
                        }
                    }
                    AppMethodBeat.o(201453);
                }
            });
            eVar.dGm();
            AppMethodBeat.o(201454);
            return false;
        }
    }

    private final void a(ug ugVar) {
        AppMethodBeat.i(201463);
        if (ugVar != null) {
            Iterator<uf> it = ugVar.LdH.iterator();
            while (it.hasNext()) {
                uf next = it.next();
                a aVar = new a();
                p.g(next, "cell");
                aVar.a(next);
                this.qhe.add(aVar);
            }
            WxRecyclerAdapter<a> wxRecyclerAdapter = this.qhd;
            if (wxRecyclerAdapter == null) {
                p.btv("mPageAdapter");
            }
            wxRecyclerAdapter.notifyDataSetChanged();
        }
        cxk();
        AppMethodBeat.o(201463);
    }

    private final void cxk() {
        AppMethodBeat.i(201464);
        if (this.qhe.isEmpty()) {
            View view = this.qhc;
            if (view == null) {
                p.btv("mHomePageEmptyView");
            }
            view.setVisibility(0);
            TextView textView = this.qhb;
            if (textView == null) {
                p.btv("mHomePageRecentlyUsedCardTitleTv");
            }
            textView.setVisibility(8);
            AppMethodBeat.o(201464);
            return;
        }
        View view2 = this.qhc;
        if (view2 == null) {
            p.btv("mHomePageEmptyView");
        }
        view2.setVisibility(8);
        TextView textView2 = this.qhb;
        if (textView2 == null) {
            p.btv("mHomePageRecentlyUsedCardTitleTv");
        }
        textView2.setVisibility(0);
        AppMethodBeat.o(201464);
    }

    private final void ajS(String str) {
        AppMethodBeat.i(201465);
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            TextView textView = this.qhb;
            if (textView == null) {
                p.btv("mHomePageRecentlyUsedCardTitleTv");
            }
            textView.setText(str);
        }
        AppMethodBeat.o(201465);
    }

    private final void a(uj ujVar) {
        AppMethodBeat.i(201466);
        Log.i(this.TAG, "do update header");
        if (ujVar == null) {
            AppMethodBeat.o(201466);
            return;
        }
        this.qhi = ujVar;
        ViewGroup viewGroup = this.qha;
        if (viewGroup == null) {
            p.btv("mHeaderContainerLayout");
        }
        viewGroup.removeAllViews();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ct);
        LinkedList<uk> linkedList = ujVar.LdS;
        p.g(linkedList, "topCellGroup.card_home_page_top_cell_list");
        for (T t : linkedList) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setPadding(0, 0, 0, dimensionPixelSize);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinkedList<ui> linkedList2 = t.LdT;
            p.g(linkedList2, "group.card_home_page_top_cell");
            int i2 = 0;
            for (T t2 : linkedList2) {
                View inflate = getLayoutInflater().inflate(R.layout.nj, (ViewGroup) linearLayout, false);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.b1l);
                TextView textView = (TextView) inflate.findViewById(R.id.b1m);
                TextView textView2 = (TextView) inflate.findViewById(R.id.b1j);
                TextView textView3 = (TextView) inflate.findViewById(R.id.b1q);
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.b1r);
                ImageView imageView3 = (ImageView) inflate.findViewById(R.id.b1s);
                String str = t2.LdL;
                if (!(str == null || str.length() == 0) && t2.LdQ == 1) {
                    p.g(textView2, "descTv");
                    textView2.setText(t2.LdL);
                    p.g(imageView3, "reddot2Iv");
                    imageView3.setVisibility(0);
                    p.g(imageView2, "reddot1Iv");
                    imageView2.setVisibility(8);
                    p.g(textView3, "newIv");
                    textView3.setVisibility(8);
                } else if (t2.LdR == 1) {
                    p.g(textView3, "newIv");
                    textView3.setVisibility(0);
                    p.g(textView2, "descTv");
                    textView2.setText("");
                    p.g(imageView3, "reddot2Iv");
                    imageView3.setVisibility(8);
                    p.g(imageView2, "reddot1Iv");
                    imageView2.setVisibility(8);
                } else if (t2.LdQ == 1) {
                    p.g(textView2, "descTv");
                    textView2.setText("");
                    p.g(imageView2, "reddot1Iv");
                    imageView2.setVisibility(0);
                    p.g(textView3, "newIv");
                    textView3.setVisibility(8);
                    p.g(imageView3, "reddot2Iv");
                    imageView3.setVisibility(8);
                } else {
                    p.g(textView2, "descTv");
                    textView2.setText("");
                    p.g(imageView2, "reddot1Iv");
                    imageView2.setVisibility(8);
                    p.g(textView3, "newIv");
                    textView3.setVisibility(8);
                    p.g(imageView3, "reddot2Iv");
                    imageView3.setVisibility(8);
                }
                String str2 = t2.LdJ;
                if (str2 != null) {
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ce);
                    Log.i(this.TAG, "cell icon top height and width ".concat(String.valueOf(dimensionPixelSize2)));
                    p.g(imageView, "iconIv");
                    com.tencent.mm.plugin.card.d.m.a(imageView, str2, false, 0, dimensionPixelSize2, dimensionPixelSize2, 28);
                }
                p.g(textView, "titleTv");
                textView.setText(t2.LdK);
                if (i2 == t.LdT.size() - 1) {
                    View findViewById = inflate.findViewById(R.id.b1k);
                    p.g(findViewById, "cellView.findViewById<Vi…header_cell_divider_view)");
                    findViewById.setVisibility(8);
                }
                inflate.setOnClickListener(new j(this, t2));
                linearLayout.addView(inflate);
                i2++;
            }
            ViewGroup viewGroup2 = this.qha;
            if (viewGroup2 == null) {
                p.btv("mHeaderContainerLayout");
            }
            viewGroup2.addView(linearLayout, layoutParams);
        }
        AppMethodBeat.o(201466);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class j implements View.OnClickListener {
        final /* synthetic */ CardHomePageV3UI qhn;
        final /* synthetic */ ui qhx;

        j(CardHomePageV3UI cardHomePageV3UI, ui uiVar) {
            this.qhn = cardHomePageV3UI;
            this.qhx = uiVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(201455);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            switch (this.qhx.LdM) {
                case 1:
                    com.tencent.mm.plugin.card.d.b.a((MMActivity) this.qhn.getContext(), this.qhx.LdN);
                    break;
                case 2:
                    un unVar = this.qhx.LdO;
                    if (unVar != null) {
                        com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                        this.qhn.qhh = true;
                        break;
                    }
                    break;
                case 3:
                    if (!"weixin://mktcard/cert".equals(this.qhx.LdP)) {
                        if (!"weixin://mktcard/membercard".equals(this.qhx.LdP)) {
                            if (!"weixin://mktcard/coupon".equals(this.qhx.LdP)) {
                                if ("weixin://mktcard/couponv2".equals(this.qhx.LdP)) {
                                    CardHomePageV3UI.e(this.qhn, this.qhx.LdK);
                                    break;
                                }
                            } else {
                                CardHomePageV3UI.d(this.qhn, this.qhx.LdK);
                                break;
                            }
                        } else {
                            CardHomePageV3UI.n(this.qhn);
                            break;
                        }
                    } else {
                        CardHomePageV3UI.m(this.qhn);
                        break;
                    }
                    break;
                default:
                    Log.w(this.qhn.TAG, "unknown type " + this.qhx.LdM);
                    break;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(19673, this.qhx.LdK, Long.valueOf(System.currentTimeMillis() / 1000));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(201455);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0016J@\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;)V", "clearShadowLayer", "", "textview", "Landroid/widget/TextView;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setShadowLayer", "showDeleteConfirmDialog", "cardId", "", "userCardId", "plugin-card_release"})
    public final class b extends com.tencent.mm.view.recyclerview.e<a> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, a aVar, int i2, int i3, boolean z, List list) {
            String str;
            String str2;
            AppMethodBeat.i(201440);
            a aVar2 = aVar;
            p.h(hVar, "holder");
            p.h(aVar2, "item");
            hVar.e(R.id.b2b, aVar2.cxm().gTG);
            View Mn = hVar.Mn(R.id.b2b);
            p.g(Mn, "holder.getView<TextView>(R.id.chpiv3_title_tv)");
            ao.a(((TextView) Mn).getPaint(), 0.8f);
            hVar.e(R.id.b27, aVar2.cxm().title);
            View view = hVar.aus;
            p.g(view, "holder.itemView");
            Object tag = view.getTag();
            uf cxm = aVar2.cxm();
            if (cxm == null || (str2 = cxm.KDM) == null) {
                str = "";
            } else {
                str = str2;
            }
            if (!(tag instanceof String) || TextUtils.isEmpty((CharSequence) tag) || !tag.equals(str)) {
                View view2 = hVar.aus;
                p.g(view2, "holder.itemView");
                view2.setTag(str);
                RoundCornerImageView roundCornerImageView = (RoundCornerImageView) hVar.Mn(R.id.b28);
                roundCornerImageView.lx(com.tencent.mm.cb.a.fromDPToPix((Context) CardHomePageV3UI.this.getContext(), 1), CardHomePageV3UI.this.getResources().getColor(R.color.am));
                roundCornerImageView.setImageDrawable(null);
                String str3 = aVar2.cxm().qGB;
                if (str3 != null) {
                    int dimensionPixelSize = CardHomePageV3UI.this.getResources().getDimensionPixelSize(R.dimen.cn);
                    p.g(roundCornerImageView, "iconIv");
                    com.tencent.mm.plugin.card.d.m.a(roundCornerImageView, str3, true, R.raw.card_default_merchant_icon, dimensionPixelSize, dimensionPixelSize);
                }
                if (aVar2.cxm().nHh == 3) {
                    hVar.me(R.id.b2b, CardHomePageV3UI.this.getResources().getColor(R.color.fq));
                    hVar.me(R.id.b27, CardHomePageV3UI.this.getResources().getColor(R.color.fq));
                    View Mn2 = hVar.Mn(R.id.b2b);
                    p.g(Mn2, "holder.getView(R.id.chpiv3_title_tv)");
                    j((TextView) Mn2);
                    View Mn3 = hVar.Mn(R.id.b27);
                    p.g(Mn3, "holder.getView(R.id.chpiv3_desc_tv)");
                    j((TextView) Mn3);
                    hVar.mf(R.id.b26, 8);
                    hVar.mf(R.id.b29, 0);
                    hVar.mf(R.id.b25, 8);
                    AppMethodBeat.o(201440);
                    return;
                }
                hVar.me(R.id.b2b, CardHomePageV3UI.this.getResources().getColor(R.color.am));
                hVar.me(R.id.b27, CardHomePageV3UI.this.getResources().getColor(R.color.BW_100_Alpha_0_8));
                View Mn4 = hVar.Mn(R.id.b2b);
                p.g(Mn4, "holder.getView(R.id.chpiv3_title_tv)");
                k((TextView) Mn4);
                View Mn5 = hVar.Mn(R.id.b27);
                p.g(Mn5, "holder.getView(R.id.chpiv3_desc_tv)");
                k((TextView) Mn5);
                hVar.mf(R.id.b29, 8);
                View Mn6 = hVar.Mn(R.id.b26);
                p.g(Mn6, "holder.getView(R.id.chpiv3_card_bg_iv)");
                MemberCardTopCropImageView memberCardTopCropImageView = (MemberCardTopCropImageView) Mn6;
                memberCardTopCropImageView.setImageDrawable(null);
                C0912b bVar = new C0912b(this, hVar, memberCardTopCropImageView, aVar2);
                if (CardHomePageV3UI.this.aYO <= 0 || CardHomePageV3UI.this.aYN <= 0) {
                    CardHomePageV3UI cardHomePageV3UI = CardHomePageV3UI.this;
                    View view3 = hVar.aus;
                    p.g(view3, "holder.itemView");
                    cardHomePageV3UI.aYO = view3.getHeight();
                    CardHomePageV3UI cardHomePageV3UI2 = CardHomePageV3UI.this;
                    View view4 = hVar.aus;
                    p.g(view4, "holder.itemView");
                    cardHomePageV3UI2.aYN = view4.getWidth();
                    if (CardHomePageV3UI.this.aYO <= 0 || CardHomePageV3UI.this.aYN <= 0) {
                        hVar.aus.post(new a(this, hVar, bVar));
                        AppMethodBeat.o(201440);
                        return;
                    }
                }
                bVar.invoke();
            }
            AppMethodBeat.o(201440);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.nl;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
            AppMethodBeat.i(201439);
            p.h(recyclerView, "recyclerView");
            p.h(hVar, "holder");
            ViewGroup viewGroup = (ViewGroup) hVar.Mn(R.id.b2a);
            viewGroup.setOnClickListener(new c(this, hVar));
            viewGroup.setOnLongClickListener(new d(this, hVar));
            AppMethodBeat.o(201439);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class c implements View.OnClickListener {
            final /* synthetic */ b qho;
            final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

            c(b bVar, com.tencent.mm.view.recyclerview.h hVar) {
                this.qho = bVar;
                this.qhp = hVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(201433);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = (a) this.qhp.hgv();
                switch (aVar.cxm().Ldc) {
                    case 1:
                        com.tencent.mm.plugin.card.d.b.a((MMActivity) CardHomePageV3UI.this.getContext(), aVar.cxm().Ldd);
                        break;
                    case 2:
                        un unVar = aVar.cxm().Lde;
                        if (unVar != null) {
                            com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                            break;
                        }
                        break;
                    case 3:
                        CardHomePageV3UI cardHomePageV3UI = CardHomePageV3UI.this;
                        String str = aVar.cxm().KDM;
                        p.g(str, "cardConvertData.recentlyUsedCell.user_card_id");
                        CardHomePageV3UI.a(cardHomePageV3UI, str);
                        break;
                    default:
                        Log.w(CardHomePageV3UI.this.TAG, "unknown type " + aVar.cxm().Ldc);
                        CardHomePageV3UI cardHomePageV3UI2 = CardHomePageV3UI.this;
                        String str2 = aVar.cxm().KDM;
                        p.g(str2, "cardConvertData.recentlyUsedCell.user_card_id");
                        CardHomePageV3UI.a(cardHomePageV3UI2, str2);
                        break;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(19674, 1, Integer.valueOf(aVar.cxm().nHh), aVar.cxm().KDM, Long.valueOf(System.currentTimeMillis() / 1000));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(201433);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
        static final class d implements View.OnLongClickListener {
            final /* synthetic */ b qho;
            final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

            d(b bVar, com.tencent.mm.view.recyclerview.h hVar) {
                this.qho = bVar;
                this.qhp = hVar;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(201436);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                final a aVar = (a) this.qhp.hgv();
                com.tencent.mm.ui.widget.b.a aVar2 = new com.tencent.mm.ui.widget.b.a(CardHomePageV3UI.this.getContext(), view);
                aVar2.a(new View.OnCreateContextMenuListener(this) {
                    /* class com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI.b.d.AnonymousClass1 */
                    final /* synthetic */ d qhs;

                    {
                        this.qhs = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(201434);
                        contextMenu.add(0, 1, 0, CardHomePageV3UI.this.getString(R.string.aq6));
                        AppMethodBeat.o(201434);
                    }
                });
                aVar2.a(new o.g(this) {
                    /* class com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI.b.d.AnonymousClass2 */
                    final /* synthetic */ d qhs;

                    {
                        this.qhs = r1;
                    }

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(201435);
                        b bVar = this.qhs.qho;
                        String str = aVar.cxm().eaO;
                        p.g(str, "cardConvertData.recentlyUsedCell.card_id");
                        String str2 = aVar.cxm().KDM;
                        p.g(str2, "cardConvertData.recentlyUsedCell.user_card_id");
                        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) CardHomePageV3UI.this.getContext(), 1, true);
                        TextView textView = new TextView(CardHomePageV3UI.this.getContext());
                        textView.setText(CardHomePageV3UI.this.getString(R.string.aq5));
                        textView.setTextSize(1, 14.0f);
                        textView.setTextColor(CardHomePageV3UI.this.getResources().getColor(R.color.u_));
                        textView.setGravity(17);
                        int dimensionPixelSize = CardHomePageV3UI.this.getResources().getDimensionPixelSize(R.dimen.ct);
                        int dimensionPixelSize2 = CardHomePageV3UI.this.getResources().getDimensionPixelSize(R.dimen.cb);
                        textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
                        eVar.V(textView, false);
                        eVar.a(new e(bVar));
                        eVar.a(new f(bVar, str, str2));
                        eVar.dGm();
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(19674, 2, Integer.valueOf(aVar.cxm().nHh), aVar.cxm().KDM, Long.valueOf(System.currentTimeMillis() / 1000));
                        AppMethodBeat.o(201435);
                    }
                });
                p.g(view, LocaleUtil.ITALIAN);
                Point dB = com.tencent.mm.plugin.card.d.m.dB(view);
                aVar2.ez(dB.x, dB.y);
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(201436);
                return false;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
        static final class e implements o.f {
            final /* synthetic */ b qho;

            e(b bVar) {
                this.qho = bVar;
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(201437);
                mVar.a(1, CardHomePageV3UI.this.getResources().getColor(R.color.a5e), CardHomePageV3UI.this.getString(R.string.x_));
                AppMethodBeat.o(201437);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
        static final class f implements o.g {
            final /* synthetic */ String qgl;
            final /* synthetic */ b qho;
            final /* synthetic */ String qhu;

            f(b bVar, String str, String str2) {
                this.qho = bVar;
                this.qgl = str;
                this.qhu = str2;
            }

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(201438);
                p.g(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case 1:
                        CardHomePageV3UI cardHomePageV3UI = CardHomePageV3UI.this;
                        String str = this.qgl;
                        String str2 = this.qhu;
                        p.h(str, "cardId");
                        p.h(str2, "userCardId");
                        Log.i(cardHomePageV3UI.TAG, "do remove recently: " + str + ", " + str2);
                        com.tencent.mm.co.f aYI = new com.tencent.mm.plugin.card.model.b.d(str, str2).aYH().aYI();
                        p.g(aYI, "CgiRemoveCardInRecentlyU…ntCancelAfterDead().run()");
                        com.tencent.mm.ac.d.b(aYI, new e(cardHomePageV3UI, str2)).b(cardHomePageV3UI);
                        break;
                }
                AppMethodBeat.o(201438);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ kotlin.g.a.a qgW;
            final /* synthetic */ b qho;
            final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

            a(b bVar, com.tencent.mm.view.recyclerview.h hVar, kotlin.g.a.a aVar) {
                this.qho = bVar;
                this.qhp = hVar;
                this.qgW = aVar;
            }

            public final void run() {
                AppMethodBeat.i(201431);
                CardHomePageV3UI cardHomePageV3UI = CardHomePageV3UI.this;
                View view = this.qhp.aus;
                p.g(view, "holder.itemView");
                cardHomePageV3UI.aYO = view.getHeight();
                CardHomePageV3UI cardHomePageV3UI2 = CardHomePageV3UI.this;
                View view2 = this.qhp.aus;
                p.g(view2, "holder.itemView");
                cardHomePageV3UI2.aYN = view2.getWidth();
                this.qgW.invoke();
                AppMethodBeat.o(201431);
            }
        }

        private static void j(TextView textView) {
            AppMethodBeat.i(201441);
            textView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            AppMethodBeat.o(201441);
        }

        private final void k(TextView textView) {
            AppMethodBeat.i(201442);
            textView.setShadowLayer((float) com.tencent.mm.cb.a.fromDPToPix(textView.getContext(), 4), 0.0f, 0.0f, CardHomePageV3UI.this.getResources().getColor(R.color.ab));
            AppMethodBeat.o(201442);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI$b$b  reason: collision with other inner class name */
        static final class C0912b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b qho;
            final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
            final /* synthetic */ MemberCardTopCropImageView qhq;
            final /* synthetic */ a qhr;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0912b(b bVar, com.tencent.mm.view.recyclerview.h hVar, MemberCardTopCropImageView memberCardTopCropImageView, a aVar) {
                super(0);
                this.qho = bVar;
                this.qhp = hVar;
                this.qhq = memberCardTopCropImageView;
                this.qhr = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                boolean z;
                AppMethodBeat.i(201432);
                Log.d(CardHomePageV3UI.this.TAG, "view height: " + CardHomePageV3UI.this.aYO);
                this.qhp.mf(R.id.b25, 0);
                this.qhq.setVisibility(0);
                this.qhq.itemPadding = CardHomePageV3UI.this.getResources().getDimensionPixelSize(R.dimen.ci);
                this.qhq.kn = CardHomePageV3UI.this.aYO;
                this.qhq.setRadius((float) CardHomePageV3UI.this.getResources().getDimensionPixelSize(R.dimen.ct));
                this.qhq.getLayoutParams().height = CardHomePageV3UI.this.aYO;
                String str = this.qhr.cxm().LdG;
                if (!(str == null || str.length() == 0)) {
                    com.tencent.mm.plugin.card.ui.v4.b.a(this.qhq, this.qhr.cxm().LdG, CardHomePageV3UI.this.aYN, CardHomePageV3UI.this.aYO);
                } else {
                    String str2 = this.qhr.cxm().LcR;
                    if (str2 == null || str2.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        this.qhq.setImageDrawable(com.tencent.mm.plugin.card.ui.v4.b.EE(Color.parseColor(this.qhr.cxm().LcR)));
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(201432);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "recentlyUsedCell", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "getRecentlyUsedCell", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "setRecentlyUsedCell", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
    public static final class a implements com.tencent.mm.view.recyclerview.a {
        public uf qhm;

        public final void a(uf ufVar) {
            AppMethodBeat.i(201429);
            p.h(ufVar, "<set-?>");
            this.qhm = ufVar;
            AppMethodBeat.o(201429);
        }

        public final uf cxm() {
            AppMethodBeat.i(201428);
            uf ufVar = this.qhm;
            if (ufVar == null) {
                p.btv("recentlyUsedCell");
            }
            AppMethodBeat.o(201428);
            return ufVar;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            AppMethodBeat.i(201430);
            uf ufVar = this.qhm;
            if (ufVar == null) {
                p.btv("recentlyUsedCell");
            }
            long hashCode = (long) ufVar.eaO.hashCode();
            AppMethodBeat.o(201430);
            return hashCode;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 1;
        }
    }

    public static final /* synthetic */ void a(CardHomePageV3UI cardHomePageV3UI, String str) {
        AppMethodBeat.i(201469);
        Log.i(cardHomePageV3UI.TAG, "go to card detail: %s", str);
        Intent intent = new Intent(cardHomePageV3UI.getContext(), CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.addFlags(131072);
        intent.putExtra("key_from_scene", 3);
        cardHomePageV3UI.startActivityForResult(intent, 4);
        AppMethodBeat.o(201469);
    }

    public static final /* synthetic */ void c(CardHomePageV3UI cardHomePageV3UI, String str) {
        boolean z;
        AppMethodBeat.i(201476);
        int size = cardHomePageV3UI.qhe.size() - 1;
        while (true) {
            if (size < 0) {
                z = false;
                break;
            } else if (p.j(cardHomePageV3UI.qhe.get(size).cxm().KDM, str)) {
                cardHomePageV3UI.qhe.remove(size);
                z = true;
                break;
            } else {
                size--;
            }
        }
        if (z) {
            WxRecyclerAdapter<a> wxRecyclerAdapter = cardHomePageV3UI.qhd;
            if (wxRecyclerAdapter == null) {
                p.btv("mPageAdapter");
            }
            wxRecyclerAdapter.notifyDataSetChanged();
        }
        AppMethodBeat.o(201476);
    }

    public static final /* synthetic */ void m(CardHomePageV3UI cardHomePageV3UI) {
        AppMethodBeat.i(201478);
        Log.i(cardHomePageV3UI.TAG, "go to cert list");
        cardHomePageV3UI.startActivityForResult(new Intent(cardHomePageV3UI.getContext(), CardTicketListUI.class), 2);
        AppMethodBeat.o(201478);
    }

    public static final /* synthetic */ void n(CardHomePageV3UI cardHomePageV3UI) {
        AppMethodBeat.i(201479);
        Log.i(cardHomePageV3UI.TAG, "go to vip card list");
        cardHomePageV3UI.startActivityForResult(new Intent(cardHomePageV3UI.getContext(), VipCardListUI.class), 1);
        AppMethodBeat.o(201479);
    }

    public static final /* synthetic */ void d(CardHomePageV3UI cardHomePageV3UI, String str) {
        AppMethodBeat.i(201480);
        Log.i(cardHomePageV3UI.TAG, "go to vip card list");
        Intent intent = new Intent(cardHomePageV3UI.getContext(), CouponCardListUI.class);
        intent.putExtra("title", str);
        cardHomePageV3UI.startActivityForResult(intent, 3);
        AppMethodBeat.o(201480);
    }

    public static final /* synthetic */ void e(CardHomePageV3UI cardHomePageV3UI, String str) {
        AppMethodBeat.i(201481);
        Log.i(cardHomePageV3UI.TAG, "go to coupon gift card list");
        Intent intent = new Intent(cardHomePageV3UI.getContext(), CouponAndGiftCardListV4UI.class);
        intent.putExtra("title", str);
        cardHomePageV3UI.startActivityForResult(intent, 5);
        AppMethodBeat.o(201481);
    }
}
