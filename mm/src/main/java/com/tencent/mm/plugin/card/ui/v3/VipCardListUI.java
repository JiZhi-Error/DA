package com.tencent.mm.plugin.card.ui.v3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.card.model.a.a;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.ui.v4.HistoryCardListUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.tz;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 U2\u00020\u0001:\u0003UVWB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0004H\u0002J\u0012\u00106\u001a\u0002042\b\b\u0002\u00107\u001a\u00020\fH\u0002J\b\u00108\u001a\u00020\u0006H\u0014J\u0010\u00109\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0004H\u0002J\u0010\u0010:\u001a\u0002042\u0006\u00105\u001a\u00020\u0004H\u0002J\u0012\u0010;\u001a\u0002042\b\u0010<\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010=\u001a\u000204H\u0014J\b\u0010>\u001a\u000204H\u0002J\u0012\u0010?\u001a\u0002042\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u000204H\u0014J\u0018\u0010C\u001a\u0002042\u0006\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\fH\u0016J\b\u0010F\u001a\u000204H\u0014J\u0012\u0010G\u001a\u0002042\b\u0010H\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010I\u001a\u000204H\u0002J\u0017\u0010J\u001a\u0002042\b\u0010K\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u000204H\u0002J\b\u0010N\u001a\u000204H\u0002J\u0018\u0010O\u001a\u0002042\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\b\u0010Q\u001a\u000204H\u0002J\u0010\u0010R\u001a\u0002042\u0006\u0010S\u001a\u00020TH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020-00X.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X.¢\u0006\u0002\n\u0000¨\u0006X"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIconMoreList", "", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "mIsAll", "mIsLoading", "mNeedRefreshList", "mOffset", "mPhoneMemberEntranceWording", "mPhoneMemberMenuEntranceWording", "mPhoneMemberMiniAppInfo", "mPreviousSortInfo", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortLayout", "mSortTv", "Landroid/widget/TextView;", "mTopPhoneVipCardLayout", "mTopPhoneVipCardTv", "mViewHeight", "mViewWidth", "mVipCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lkotlin/collections/ArrayList;", "mVipCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mVipCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "doDeleteVipCard", "", "cardId", "doLoadVipCardList", "refresh", "getLayoutId", "getPositionByUserCardId", "gotoCardDetailUI", "gotoVipHistoryCardListUI", "title", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "performMenuItemClicked", "item", "saveSnapshot", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "showSortDialog", "updateIconMenu", "updateIconMenuByV4Protocol", "iconMenuData", "updateTopHeaderLayout", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "Companion", "VipCardConvertData", "VipCardConverter", "plugin-card_release"})
public final class VipCardListUI extends CardNewBaseUI {
    public static final a qih = new a((byte) 0);
    private final String TAG = "MicroMsg.VipCardListUI";
    private int aYN;
    private int aYO;
    private int fs;
    private q gxX;
    private boolean mGR = true;
    private boolean mwr;
    private ViewGroup qgI;
    private RefreshLoadMoreLayout qgY;
    private ViewGroup qgZ;
    private int qhC = 10;
    private un qhG;
    private String qhH;
    private uw qhI;
    private String qhJ = "";
    private int qhK;
    private int qhL;
    private WxRecyclerView qhW;
    private ViewGroup qhX;
    private ViewGroup qhY;
    private TextView qhZ;
    private boolean qhf;
    private boolean qhg;
    private int qhk;
    private TextView qhz;
    private WxRecyclerAdapter<b> qia;
    private final ArrayList<b> qib = new ArrayList<>();
    private boolean qic;
    private un qid;
    private String qie;
    private String qif;
    private List<? extends ue> qig;

    static {
        AppMethodBeat.i(201589);
        AppMethodBeat.o(201589);
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String qgl;
        final /* synthetic */ VipCardListUI qij;

        d(VipCardListUI vipCardListUI, String str) {
            this.qij = vipCardListUI;
            this.qgl = str;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(201557);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                agn agn = (agn) aVar.iLC;
                Log.i("MicroMsg.CardHomePageNewUI", "retCode: %s", Integer.valueOf(agn.pTZ));
                if (agn.pTZ == 0) {
                    Iterator it = this.qij.qib.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        if (p.j(bVar.cxt().KDM, this.qgl)) {
                            this.qij.qib.remove(bVar);
                            VipCardListUI.x(this.qij).notifyDataSetChanged();
                            break;
                        }
                    }
                } else {
                    com.tencent.mm.plugin.card.d.l.aq(this.qij, agn.pUa);
                }
            } else {
                com.tencent.mm.plugin.card.d.l.ar(this.qij, "");
            }
            VipCardListUI.a(this.qij, Boolean.FALSE);
            x xVar = x.SXb;
            AppMethodBeat.o(201557);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.b<c.a<bqk>, x> {
        final /* synthetic */ boolean qgO;
        final /* synthetic */ VipCardListUI qij;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(VipCardListUI vipCardListUI, boolean z) {
            super(1);
            this.qij = vipCardListUI;
            this.qgO = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(c.a<bqk> aVar) {
            T t;
            boolean z;
            AppMethodBeat.i(201558);
            c.a<bqk> aVar2 = aVar;
            if (aVar2 != null) {
                Log.i(this.qij.TAG, "errType: " + aVar2.errType + ", errCode: " + aVar2.errCode + ", errMsg: " + aVar2.errMsg);
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    bqk bqk = (bqk) aVar2.iLC;
                    if (bqk != null) {
                        Log.i(this.qij.TAG, "retcode: " + bqk.pTZ + ", retmsg: " + bqk.pUa);
                        if (bqk.pTZ == 0) {
                            this.qij.fs = bqk.qGg;
                            this.qij.qhf = bqk.LUO > 0;
                            this.qij.qhg = true;
                            this.qij.qhI = bqk.LUU;
                            uw uwVar = this.qij.qhI;
                            if (uwVar != null) {
                                if (bqk.LUS == 1) {
                                    LinkedList<uv> linkedList = uwVar.Let;
                                    p.g(linkedList, "card_sort_info");
                                    Iterator<T> it = linkedList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            t = null;
                                            break;
                                        }
                                        T next = it.next();
                                        if (next.Leq == bqk.LUT) {
                                            z = true;
                                            continue;
                                        } else {
                                            z = false;
                                            continue;
                                        }
                                        if (z) {
                                            t = next;
                                            break;
                                        }
                                    }
                                    T t2 = t;
                                    if (t2 != null) {
                                        this.qij.qhK = t2.Leq;
                                        VipCardListUI vipCardListUI = this.qij;
                                        String str = t2.Les;
                                        p.g(str, "find.sort_wording");
                                        vipCardListUI.qhJ = str;
                                        this.qij.qhC = t2.Ler;
                                    }
                                } else if (this.qij.qhK == 0) {
                                    LinkedList<uv> linkedList2 = uwVar.Let;
                                    p.g(linkedList2, "card_sort_info");
                                    uv first = linkedList2.getFirst();
                                    this.qij.qhK = first.Leq;
                                    VipCardListUI vipCardListUI2 = this.qij;
                                    String str2 = first.Les;
                                    p.g(str2, "first.sort_wording");
                                    vipCardListUI2.qhJ = str2;
                                    this.qij.qhC = first.Ler;
                                }
                            }
                            this.qij.qhG = bqk.LUQ;
                            this.qij.qig = bqk.LUK;
                            this.qij.qhH = bqk.LUR;
                            this.qij.qid = bqk.LYc;
                            this.qij.qie = bqk.LYe;
                            this.qij.qif = bqk.LYd;
                            VipCardListUI.s(this.qij);
                            if (this.qgO) {
                                this.qij.qib.clear();
                            }
                            VipCardListUI.a(this.qij, bqk);
                        } else {
                            com.tencent.mm.plugin.card.d.l.aq(this.qij.getContext(), bqk.pUa);
                            this.qij.qhK = this.qij.qhL;
                        }
                    }
                    if (this.qij.mGR) {
                        this.qij.mGR = false;
                    }
                } else {
                    com.tencent.mm.plugin.card.d.l.ar(this.qij.getContext(), "");
                    this.qij.qhK = this.qij.qhL;
                }
                VipCardListUI.k(this.qij);
            }
            this.qij.mwr = false;
            VipCardListUI.f(this.qij).apT(0);
            x xVar = x.SXb;
            AppMethodBeat.o(201558);
            return xVar;
        }
    }

    public VipCardListUI() {
        AppMethodBeat.i(201588);
        AppMethodBeat.o(201588);
    }

    public static final /* synthetic */ void a(VipCardListUI vipCardListUI, bqk bqk) {
        AppMethodBeat.i(201598);
        vipCardListUI.a(bqk);
        AppMethodBeat.o(201598);
    }

    public static final /* synthetic */ void a(VipCardListUI vipCardListUI, Boolean bool) {
        AppMethodBeat.i(201601);
        vipCardListUI.j(bool);
        AppMethodBeat.o(201601);
    }

    public static final /* synthetic */ void a(VipCardListUI vipCardListUI, boolean z) {
        AppMethodBeat.i(201593);
        vipCardListUI.kB(z);
        AppMethodBeat.o(201593);
    }

    public static final /* synthetic */ RefreshLoadMoreLayout f(VipCardListUI vipCardListUI) {
        AppMethodBeat.i(201594);
        RefreshLoadMoreLayout refreshLoadMoreLayout = vipCardListUI.qgY;
        if (refreshLoadMoreLayout == null) {
            p.btv("mRefreshLayout");
        }
        AppMethodBeat.o(201594);
        return refreshLoadMoreLayout;
    }

    public static final /* synthetic */ void k(VipCardListUI vipCardListUI) {
        AppMethodBeat.i(201595);
        vipCardListUI.cxs();
        AppMethodBeat.o(201595);
    }

    public static final /* synthetic */ void s(VipCardListUI vipCardListUI) {
        AppMethodBeat.i(201597);
        vipCardListUI.cxp();
        AppMethodBeat.o(201597);
    }

    public static final /* synthetic */ WxRecyclerAdapter x(VipCardListUI vipCardListUI) {
        AppMethodBeat.i(201600);
        WxRecyclerAdapter<b> wxRecyclerAdapter = vipCardListUI.qia;
        if (wxRecyclerAdapter == null) {
            p.btv("mVipCardListAdapter");
        }
        AppMethodBeat.o(201600);
        return wxRecyclerAdapter;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$Companion;", "", "()V", "CONVERT_TYPE_HEADER", "", "CONVERT_TYPE_VIP_CARD", "SORT_TYPE_DEFAULT", "SORT_TYPE_DISTANCE", "SORT_TYPE_EXPIRETIME", "SORT_TYPE_RCTIME", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(201577);
        super.onCreate(bundle);
        initView();
        setMMTitle(R.string.ar9);
        setActionbarColor(getResources().getColor(R.color.f3043a));
        hideActionbarLine();
        setBackBtn(new h(this));
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        bqk cui = a.C0902a.cui();
        if (cui != null) {
            this.fs = cui.qGg;
            this.qhI = cui.LUU;
            this.qhG = cui.LUQ;
            this.qig = cui.LUK;
            this.qhH = cui.LUR;
            this.qid = cui.LYc;
            this.qie = cui.LYe;
            this.qif = cui.LYd;
            cxp();
            a(cui);
        }
        a.C0902a aVar2 = com.tencent.mm.plugin.card.model.a.a.pVg;
        uv cuj = a.C0902a.cuj();
        if (cuj != null) {
            this.qhK = cuj.Leq;
            String str = cuj.Les;
            p.g(str, "cardSortInfo.sort_wording");
            this.qhJ = str;
            this.qhC = cuj.Ler;
            this.qhL = this.qhK;
        }
        cxs();
        if (this.qhK != 1) {
            kB(true);
        }
        AppMethodBeat.o(201577);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class h implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ VipCardListUI qij;

        h(VipCardListUI vipCardListUI) {
            this.qij = vipCardListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201565);
            this.qij.finish();
            AppMethodBeat.o(201565);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(201578);
        View findViewById = findViewById(R.id.b2o);
        p.g(findViewById, "findViewById(R.id.chpvv3_rv)");
        this.qhW = (WxRecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.b2m);
        p.g(findViewById2, "findViewById(R.id.chpvv3_refresh_layout)");
        this.qgY = (RefreshLoadMoreLayout) findViewById2;
        View findViewById3 = findViewById(R.id.b2k);
        p.g(findViewById3, "findViewById(R.id.chpvv3_empty_layout)");
        this.qgI = (ViewGroup) findViewById3;
        WxRecyclerView wxRecyclerView = this.qhW;
        if (wxRecyclerView == null) {
            p.btv("mVipCardListRv");
        }
        getContext();
        wxRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        this.qia = new WxRecyclerAdapter<>(new f(this), this.qib);
        WxRecyclerAdapter<b> wxRecyclerAdapter = this.qia;
        if (wxRecyclerAdapter == null) {
            p.btv("mVipCardListAdapter");
        }
        wxRecyclerAdapter.au(true);
        WxRecyclerView wxRecyclerView2 = this.qhW;
        if (wxRecyclerView2 == null) {
            p.btv("mVipCardListRv");
        }
        WxRecyclerAdapter<b> wxRecyclerAdapter2 = this.qia;
        if (wxRecyclerAdapter2 == null) {
            p.btv("mVipCardListAdapter");
        }
        wxRecyclerView2.setAdapter(wxRecyclerAdapter2);
        w wVar = new w(getContext(), 1);
        wVar.setDrawable(getResources().getDrawable(R.drawable.lk));
        WxRecyclerView wxRecyclerView3 = this.qhW;
        if (wxRecyclerView3 == null) {
            p.btv("mVipCardListRv");
        }
        wxRecyclerView3.b(wVar);
        LayoutInflater layoutInflater = getLayoutInflater();
        WxRecyclerView wxRecyclerView4 = this.qhW;
        if (wxRecyclerView4 == null) {
            p.btv("mVipCardListRv");
        }
        View inflate = layoutInflater.inflate(R.layout.nn, (ViewGroup) wxRecyclerView4, false);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(201578);
            throw tVar;
        }
        this.qgZ = (ViewGroup) inflate;
        ViewGroup viewGroup = this.qgZ;
        if (viewGroup == null) {
            p.btv("mHeaderView");
        }
        View findViewById4 = viewGroup.findViewById(R.id.b2q);
        p.g(findViewById4, "mHeaderView.findViewById(R.id.chpvv3_sort_tv)");
        this.qhz = (TextView) findViewById4;
        ViewGroup viewGroup2 = this.qgZ;
        if (viewGroup2 == null) {
            p.btv("mHeaderView");
        }
        View findViewById5 = viewGroup2.findViewById(R.id.b2p);
        p.g(findViewById5, "mHeaderView.findViewById(R.id.chpvv3_sort_layout)");
        this.qhX = (ViewGroup) findViewById5;
        ViewGroup viewGroup3 = this.qgZ;
        if (viewGroup3 == null) {
            p.btv("mHeaderView");
        }
        View findViewById6 = viewGroup3.findViewById(R.id.b2s);
        p.g(findViewById6, "mHeaderView.findViewById…top_phone_vipcard_layout)");
        this.qhY = (ViewGroup) findViewById6;
        ViewGroup viewGroup4 = this.qgZ;
        if (viewGroup4 == null) {
            p.btv("mHeaderView");
        }
        View findViewById7 = viewGroup4.findViewById(R.id.b2t);
        p.g(findViewById7, "mHeaderView.findViewById…vv3_top_phone_vipcard_tv)");
        this.qhZ = (TextView) findViewById7;
        WxRecyclerAdapter<b> wxRecyclerAdapter3 = this.qia;
        if (wxRecyclerAdapter3 == null) {
            p.btv("mVipCardListAdapter");
        }
        ViewGroup viewGroup5 = this.qgZ;
        if (viewGroup5 == null) {
            p.btv("mHeaderView");
        }
        wxRecyclerAdapter3.f(viewGroup5, 2, false);
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.qgY;
        if (refreshLoadMoreLayout == null) {
            p.btv("mRefreshLayout");
        }
        refreshLoadMoreLayout.setEnableRefresh(false);
        RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.qgY;
        if (refreshLoadMoreLayout2 == null) {
            p.btv("mRefreshLayout");
        }
        refreshLoadMoreLayout2.setActionCallback(new g(this));
        AppMethodBeat.o(201578);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
    public static final class f implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ VipCardListUI qij;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(VipCardListUI vipCardListUI) {
            this.qij = vipCardListUI;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(201559);
            c cVar = new c();
            AppMethodBeat.o(201559);
            return cVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"})
    public static final class g extends RefreshLoadMoreLayout.a {
        final /* synthetic */ VipCardListUI qij;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(201563);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(201563);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(201564);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(201564);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(VipCardListUI vipCardListUI) {
            this.qij = vipCardListUI;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(201561);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            Log.d(this.qij.TAG, "on load more");
            com.tencent.mm.ac.d.h(new a(this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(201561);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(201562);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            Log.d(this.qij.TAG, "on load more end: " + this.qij.qhk);
            if (this.qij.qhf) {
                VipCardListUI.f(this.qij).h((RefreshLoadMoreLayout.c<Object>) null);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(201562);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ g qio;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(0);
                this.qio = gVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(201560);
                VipCardListUI.a(this.qio.qij, false);
                x xVar = x.SXb;
                AppMethodBeat.o(201560);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(201579);
        if (this.qic) {
            kB(true);
            this.qic = false;
        }
        super.onResume();
        AppMethodBeat.o(201579);
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(201580);
        super.onDestroy();
        if (!this.qhg) {
            Log.i(this.TAG, "no data to save snapshot");
            AppMethodBeat.o(201580);
            return;
        }
        bqk bqk = new bqk();
        bqk.BaseResponse = new BaseResponse();
        bqk.BaseResponse.ErrMsg = new dqi();
        Iterator<b> it = this.qib.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.cxt() != null) {
                bqk.Lds.add(next.cxt());
            }
        }
        bqk.LUU = this.qhI;
        bqk.qGg = this.fs;
        bqk.LUR = this.qhH;
        bqk.LUQ = this.qhG;
        bqk.LUK = (LinkedList) this.qig;
        bqk.LYc = this.qid;
        bqk.LYd = this.qif;
        bqk.LYe = this.qie;
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        p.h(bqk, "response");
        Log.d(com.tencent.mm.plugin.card.model.a.a.TAG, "save vip card list snapshot");
        com.tencent.mm.ac.d.i(new a.C0902a.g(bqk));
        uv uvVar = new uv();
        uvVar.Leq = this.qhK;
        uvVar.Les = this.qhJ;
        uvVar.Ler = this.qhC;
        a.C0902a aVar2 = com.tencent.mm.plugin.card.model.a.a.pVg;
        p.h(uvVar, "sortInfo");
        Log.d(com.tencent.mm.plugin.card.model.a.a.TAG, "save vip card list snapshot");
        com.tencent.mm.ac.d.i(new a.C0902a.h(uvVar));
        AppMethodBeat.o(201580);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.np;
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI
    public final void ad(int i2, boolean z) {
        AppMethodBeat.i(201581);
        if (!this.mGR || this.qhK != 1) {
            if (!z) {
                cxi();
            }
            AppMethodBeat.o(201581);
            return;
        }
        kB(true);
        AppMethodBeat.o(201581);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class i implements o.f {
        final /* synthetic */ VipCardListUI qij;

        i(VipCardListUI vipCardListUI) {
            this.qij = vipCardListUI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(201566);
            uw uwVar = this.qij.qhI;
            if (uwVar == null) {
                p.hyc();
            }
            Iterator<uv> it = uwVar.Let.iterator();
            while (it.hasNext()) {
                uv next = it.next();
                mVar.add(0, next.Leq, 1, next.Les);
            }
            AppMethodBeat.o(201566);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class j implements o.g {
        final /* synthetic */ VipCardListUI qij;

        j(VipCardListUI vipCardListUI) {
            this.qij = vipCardListUI;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(201568);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            Log.i(this.qij.TAG, "click item: %s", Integer.valueOf(itemId));
            if (itemId != 1) {
                this.qij.qhL = this.qij.qhK;
                this.qij.qhK = itemId;
                this.qij.qhJ = menuItem.getTitle().toString();
                VipCardListUI.k(this.qij);
                VipCardListUI.a(this.qij, true);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 1, 6);
                AppMethodBeat.o(201568);
            } else if (!this.qij.qgs) {
                com.tencent.mm.ui.base.h.a((Context) this.qij.getContext(), this.qij.getString(R.string.aq9), this.qij.getString(R.string.flp), this.qij.getString(R.string.e_k), this.qij.getString(R.string.b96), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.card.ui.v3.VipCardListUI.j.AnonymousClass1 */
                    final /* synthetic */ j qip;

                    {
                        this.qip = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(201567);
                        this.qip.qij.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
                        AppMethodBeat.o(201567);
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(201568);
            } else {
                this.qij.qhL = this.qij.qhK;
                this.qij.qhK = 1;
                this.qij.qhJ = menuItem.getTitle().toString();
                VipCardListUI.k(this.qij);
                VipCardListUI.a(this.qij, true);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 1, 5);
                AppMethodBeat.o(201568);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void cxs() {
        /*
        // Method dump skipped, instructions count: 250
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.ui.v3.VipCardListUI.cxs():void");
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class m implements View.OnClickListener {
        final /* synthetic */ VipCardListUI qij;

        m(VipCardListUI vipCardListUI) {
            this.qij = vipCardListUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(201575);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.d(this.qij.TAG, "click header view");
            VipCardListUI.l(this.qij);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(201575);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class n implements View.OnClickListener {
        final /* synthetic */ VipCardListUI qij;

        n(VipCardListUI vipCardListUI) {
            this.qij = vipCardListUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(201576);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.qij.qic = true;
            un unVar = this.qij.qid;
            if (unVar == null) {
                p.hyc();
            }
            String str = unVar.Hwr;
            un unVar2 = this.qij.qid;
            if (unVar2 == null) {
                p.hyc();
            }
            String str2 = unVar2.Hws;
            un unVar3 = this.qij.qid;
            if (unVar3 == null) {
                p.hyc();
            }
            com.tencent.mm.plugin.card.d.b.H(str, str2, unVar3.IhZ);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 1, 8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(201576);
        }
    }

    private final void kB(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(201583);
        Log.i(this.TAG, "do load vip card list: " + this.mwr + ", " + this.fs + ", " + this.qhK);
        if (this.qhf && !z) {
            Log.w(this.TAG, "already load complete");
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.qgY;
            if (refreshLoadMoreLayout == null) {
                p.btv("mRefreshLayout");
            }
            refreshLoadMoreLayout.apT(0);
            AppMethodBeat.o(201583);
        } else if (this.mwr) {
            Log.w(this.TAG, "is loading");
            AppMethodBeat.o(201583);
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
            com.tencent.mm.co.f aYI = new com.tencent.mm.plugin.card.model.b.b(i2, this.qhC, (double) this.latitude, (double) this.dTj, this.qhK).aYH().aYI();
            p.g(aYI, "CgiGetMemberCardHomePage…ntCancelAfterDead().run()");
            com.tencent.mm.ac.d.b(aYI, new e(this, z)).b(this);
            AppMethodBeat.o(201583);
        }
    }

    private final void cxp() {
        AppMethodBeat.i(201584);
        List<? extends ue> list = this.qig;
        if (!(list == null || list.isEmpty())) {
            cW(this.qig);
            AppMethodBeat.o(201584);
            return;
        }
        z.a aVar = new z.a();
        aVar.SYB = false;
        z.a aVar2 = new z.a();
        aVar2.SYB = false;
        if (this.qid != null) {
            String str = this.qif;
            if (!(str == null || str.length() == 0)) {
                aVar.SYB = true;
            }
        }
        if (this.qhG != null) {
            aVar2.SYB = true;
        }
        if (aVar.SYB || aVar2.SYB) {
            removeAllOptionMenu();
            addIconOptionMenu(0, 0, R.raw.icons_outlined_more, new k(this, aVar, aVar2));
        }
        AppMethodBeat.o(201584);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class k implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ VipCardListUI qij;
        final /* synthetic */ z.a qiq;
        final /* synthetic */ z.a qir;

        k(VipCardListUI vipCardListUI, z.a aVar, z.a aVar2) {
            this.qij = vipCardListUI;
            this.qiq = aVar;
            this.qir = aVar2;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201571);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.qij.getContext(), 1, false);
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.card.ui.v3.VipCardListUI.k.AnonymousClass1 */
                final /* synthetic */ k qis;

                {
                    this.qis = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(201569);
                    if (this.qis.qiq.SYB) {
                        mVar.add(0, 1, 0, this.qis.qij.qif);
                    }
                    if (this.qis.qir.SYB) {
                        mVar.add(0, 2, 1, this.qis.qij.qhH);
                    }
                    AppMethodBeat.o(201569);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.card.ui.v3.VipCardListUI.k.AnonymousClass2 */
                final /* synthetic */ k qis;

                {
                    this.qis = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(201570);
                    p.g(menuItem, "menuItem");
                    if (menuItem.getItemId() == 1) {
                        this.qis.qij.qic = true;
                        un unVar = this.qis.qij.qid;
                        if (unVar == null) {
                            p.hyc();
                        }
                        String str = unVar.Hwr;
                        un unVar2 = this.qis.qij.qid;
                        if (unVar2 == null) {
                            p.hyc();
                        }
                        String str2 = unVar2.Hws;
                        un unVar3 = this.qis.qij.qid;
                        if (unVar3 == null) {
                            p.hyc();
                        }
                        com.tencent.mm.plugin.card.d.b.H(str, str2, unVar3.IhZ);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 1, 7);
                        AppMethodBeat.o(201570);
                        return;
                    }
                    if (menuItem.getItemId() == 2) {
                        un unVar4 = this.qis.qij.qhG;
                        if (unVar4 == null) {
                            p.hyc();
                        }
                        String str3 = unVar4.Hwr;
                        un unVar5 = this.qis.qij.qhG;
                        if (unVar5 == null) {
                            p.hyc();
                        }
                        String str4 = unVar5.Hws;
                        un unVar6 = this.qis.qij.qhG;
                        if (unVar6 == null) {
                            p.hyc();
                        }
                        com.tencent.mm.plugin.card.d.b.H(str3, str4, unVar6.IhZ);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 1, 2);
                    }
                    AppMethodBeat.o(201570);
                }
            });
            eVar.dGm();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 1, 1);
            AppMethodBeat.o(201571);
            return false;
        }
    }

    private final void cW(List<? extends ue> list) {
        AppMethodBeat.i(201585);
        if (list != null) {
            removeAllOptionMenu();
            addIconOptionMenu(0, 0, R.raw.icons_outlined_more, new l(list, this, list));
            AppMethodBeat.o(201585);
            return;
        }
        AppMethodBeat.o(201585);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateIconMenuByV4Protocol$1$1"})
    public static final class l implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ VipCardListUI qij;
        final /* synthetic */ List qit;
        final /* synthetic */ List qiu;

        l(List list, VipCardListUI vipCardListUI, List list2) {
            this.qit = list;
            this.qij = vipCardListUI;
            this.qiu = list2;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201574);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.qij.getContext(), 1, false);
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.card.ui.v3.VipCardListUI.l.AnonymousClass1 */
                final /* synthetic */ l qiv;

                {
                    this.qiv = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(201572);
                    int i2 = 0;
                    for (Object obj : this.qiv.qit) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            kotlin.a.j.hxH();
                        }
                        ue ueVar = (ue) obj;
                        mVar.add(0, i2, 1, ueVar.LdB);
                        Log.i(this.qiv.qij.TAG, "Icon menu content, index: " + i2 + ", wording: " + ueVar.LdB + ", jumpType:" + ueVar.LdC + ' ');
                        i2 = i3;
                    }
                    AppMethodBeat.o(201572);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.card.ui.v3.VipCardListUI.l.AnonymousClass2 */
                final /* synthetic */ l qiv;

                {
                    this.qiv = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(201573);
                    VipCardListUI.a(this.qiv.qij, (ue) this.qiv.qiu.get(i2));
                    AppMethodBeat.o(201573);
                }
            });
            eVar.dGm();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 1, 1);
            AppMethodBeat.o(201574);
            return false;
        }
    }

    private final void a(bqk bqk) {
        AppMethodBeat.i(201586);
        this.qhI = bqk.LUU;
        Iterator<ua> it = bqk.Lds.iterator();
        while (it.hasNext()) {
            ua next = it.next();
            b bVar = new b();
            p.g(next, "cardInfo");
            bVar.a(next);
            this.qib.add(bVar);
        }
        if (this.qib.isEmpty()) {
            ViewGroup viewGroup = this.qgI;
            if (viewGroup == null) {
                p.btv("mEmptyView");
            }
            viewGroup.setVisibility(0);
        } else {
            ViewGroup viewGroup2 = this.qgI;
            if (viewGroup2 == null) {
                p.btv("mEmptyView");
            }
            viewGroup2.setVisibility(8);
        }
        WxRecyclerAdapter<b> wxRecyclerAdapter = this.qia;
        if (wxRecyclerAdapter == null) {
            p.btv("mVipCardListAdapter");
        }
        wxRecyclerAdapter.notifyDataSetChanged();
        AppMethodBeat.o(201586);
    }

    private final void j(Boolean bool) {
        q qVar;
        AppMethodBeat.i(201587);
        if (bool == null) {
            AppMethodBeat.o(201587);
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
        AppMethodBeat.o(201587);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010\u0018\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showDeleteConfirmDialog", "cardId", "", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "plugin-card_release"})
    public final class c extends com.tencent.mm.view.recyclerview.e<b> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, b bVar, int i2, int i3, boolean z, List list) {
            String str;
            String str2;
            AppMethodBeat.i(201556);
            b bVar2 = bVar;
            p.h(hVar, "holder");
            p.h(bVar2, "item");
            TextView textView = (TextView) hVar.Mn(R.id.b2r);
            p.g(textView, "titleText");
            textView.setText(bVar2.cxt().LcO);
            ao.a(textView.getPaint(), 0.8f);
            hVar.e(R.id.b2j, bVar2.cxt().LcP);
            ImageView imageView = (ImageView) hVar.Mn(R.id.b2l);
            if (bVar2.cxt().Ldb != null) {
                int dimensionPixelSize = VipCardListUI.this.getResources().getDimensionPixelSize(R.dimen.cn);
                p.g(imageView, "iconIv");
                String str3 = bVar2.cxt().Ldb;
                p.g(str3, "item.vipCardInfo.card_icon_url");
                com.tencent.mm.plugin.card.d.m.a(imageView, str3, false, R.raw.card_default_merchant_icon, dimensionPixelSize, dimensionPixelSize, 12);
            }
            LinearLayout linearLayout = (LinearLayout) hVar.Mn(R.id.b2n);
            p.g(linearLayout, "labelLayout");
            if (linearLayout.getChildCount() > 0) {
                linearLayout.removeAllViews();
            }
            if (!bVar2.cxt().LcT.isEmpty()) {
                LinkedList<tz> linkedList = bVar2.cxt().LcT;
                p.g(linkedList, "item.vipCardInfo.coupon_label");
                for (tz tzVar : linkedList) {
                    CardTagTextView cardTagTextView = new CardTagTextView(VipCardListUI.this.getContext());
                    AppCompatActivity context = VipCardListUI.this.getContext();
                    cardTagTextView.setMinHeight(com.tencent.mm.cb.a.fromDPToPix((Context) context, 18));
                    cardTagTextView.setMinWidth(com.tencent.mm.cb.a.fromDPToPix((Context) context, 56));
                    int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) context, 8);
                    int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix((Context) context, 4);
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
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
            View Mn = hVar.Mn(R.id.b2i);
            p.g(Mn, "holder.getView(R.id.chpvv3_card_bg_iv)");
            MemberCardTopCropImageView memberCardTopCropImageView = (MemberCardTopCropImageView) Mn;
            Object tag = memberCardTopCropImageView.getTag();
            ua cxt = bVar2.cxt();
            if (cxt == null || (str2 = cxt.KDM) == null) {
                str = "";
            } else {
                str = str2;
            }
            if (!(tag instanceof String) || TextUtils.isEmpty((CharSequence) tag) || !tag.equals(str)) {
                memberCardTopCropImageView.setTag(str);
                b bVar3 = new b(this, memberCardTopCropImageView, bVar2);
                if (VipCardListUI.this.aYO <= 0 || VipCardListUI.this.aYN <= 0) {
                    VipCardListUI vipCardListUI = VipCardListUI.this;
                    View view = hVar.aus;
                    p.g(view, "holder.itemView");
                    vipCardListUI.aYO = view.getHeight();
                    VipCardListUI vipCardListUI2 = VipCardListUI.this;
                    View view2 = hVar.aus;
                    p.g(view2, "holder.itemView");
                    vipCardListUI2.aYN = view2.getWidth();
                    if (VipCardListUI.this.aYO <= 0 || VipCardListUI.this.aYN <= 0) {
                        hVar.aus.post(new a(this, hVar, bVar3));
                        AppMethodBeat.o(201556);
                        return;
                    }
                }
                bVar3.invoke();
            }
            AppMethodBeat.o(201556);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.no;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
            AppMethodBeat.i(201555);
            p.h(recyclerView, "recyclerView");
            p.h(hVar, "holder");
            ((RoundCornerImageView) hVar.Mn(R.id.b2l)).lx(com.tencent.mm.cb.a.fromDPToPix((Context) VipCardListUI.this.getContext(), 1), VipCardListUI.this.getResources().getColor(R.color.am));
            hVar.aus.setOnClickListener(new View$OnClickListenerC0914c(this, hVar));
            hVar.aus.setOnLongClickListener(new d(this, hVar));
            AppMethodBeat.o(201555);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v3.VipCardListUI$c$c  reason: collision with other inner class name */
        static final class View$OnClickListenerC0914c implements View.OnClickListener {
            final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
            final /* synthetic */ c qik;

            View$OnClickListenerC0914c(c cVar, com.tencent.mm.view.recyclerview.h hVar) {
                this.qik = cVar;
                this.qhp = hVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(201549);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b bVar2 = (b) this.qhp.hgv();
                ua cxt = bVar2.cxt();
                if (cxt.Ldc == 1) {
                    com.tencent.mm.plugin.card.d.b.a((MMActivity) VipCardListUI.this.getContext(), cxt.Ldd);
                } else if (cxt.Ldc == 2) {
                    com.tencent.mm.plugin.card.d.b.H(cxt.Lde.Hwr, cxt.Lde.Hws, cxt.Lde.IhZ);
                } else {
                    VipCardListUI vipCardListUI = VipCardListUI.this;
                    String str = bVar2.cxt().KDM;
                    p.g(str, "vipCardConvertData.vipCardInfo.user_card_id");
                    VipCardListUI.a(vipCardListUI, str);
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                VipCardListUI vipCardListUI2 = VipCardListUI.this;
                String str2 = bVar2.cxt().KDM;
                p.g(str2, "vipCardConvertData.vipCardInfo.user_card_id");
                hVar.a(19748, 1, Long.valueOf(System.currentTimeMillis() / 1000), bVar2.cxt().KDM, Integer.valueOf(VipCardListUI.b(vipCardListUI2, str2)), 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(201549);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
        static final class d implements View.OnLongClickListener {
            final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
            final /* synthetic */ c qik;

            d(c cVar, com.tencent.mm.view.recyclerview.h hVar) {
                this.qik = cVar;
                this.qhp = hVar;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(201552);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                final b bVar2 = (b) this.qhp.hgv();
                com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(VipCardListUI.this.getContext(), view);
                aVar.a(new View.OnCreateContextMenuListener(this) {
                    /* class com.tencent.mm.plugin.card.ui.v3.VipCardListUI.c.d.AnonymousClass1 */
                    final /* synthetic */ d qim;

                    {
                        this.qim = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(201550);
                        contextMenu.add(0, 1, 0, VipCardListUI.this.getString(R.string.tf));
                        AppMethodBeat.o(201550);
                    }
                });
                aVar.a(new o.g(this) {
                    /* class com.tencent.mm.plugin.card.ui.v3.VipCardListUI.c.d.AnonymousClass2 */
                    final /* synthetic */ d qim;

                    {
                        this.qim = r1;
                    }

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(201551);
                        c cVar = this.qim.qik;
                        String str = bVar2.cxt().KDM;
                        p.g(str, "vipCardConvertData.vipCardInfo.user_card_id");
                        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) VipCardListUI.this.getContext(), 1, true);
                        TextView textView = new TextView(VipCardListUI.this.getContext());
                        textView.setText(VipCardListUI.this.getString(R.string.apx));
                        textView.setTextSize(1, 14.0f);
                        textView.setTextColor(VipCardListUI.this.getResources().getColor(R.color.u_));
                        textView.setGravity(17);
                        int dimensionPixelSize = VipCardListUI.this.getResources().getDimensionPixelSize(R.dimen.ct);
                        int dimensionPixelSize2 = VipCardListUI.this.getResources().getDimensionPixelSize(R.dimen.cb);
                        textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
                        eVar.V(textView, false);
                        eVar.a(new e(cVar));
                        eVar.a(new f(cVar, str));
                        eVar.dGm();
                        AppMethodBeat.o(201551);
                    }
                });
                p.g(view, LocaleUtil.ITALIAN);
                Point dB = com.tencent.mm.plugin.card.d.m.dB(view);
                aVar.ez(dB.x, dB.y);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 1, 3);
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(201552);
                return false;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
        static final class e implements o.f {
            final /* synthetic */ c qik;

            e(c cVar) {
                this.qik = cVar;
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(201553);
                mVar.a(1, VipCardListUI.this.getResources().getColor(R.color.a5e), VipCardListUI.this.getString(R.string.tf));
                AppMethodBeat.o(201553);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
        static final class f implements o.g {
            final /* synthetic */ String qgl;
            final /* synthetic */ c qik;

            f(c cVar, String str) {
                this.qik = cVar;
                this.qgl = str;
            }

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(201554);
                p.g(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case 1:
                        VipCardListUI.c(VipCardListUI.this, this.qgl);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 1, 4);
                        break;
                }
                AppMethodBeat.o(201554);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ kotlin.g.a.a qgW;
            final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
            final /* synthetic */ c qik;

            a(c cVar, com.tencent.mm.view.recyclerview.h hVar, kotlin.g.a.a aVar) {
                this.qik = cVar;
                this.qhp = hVar;
                this.qgW = aVar;
            }

            public final void run() {
                AppMethodBeat.i(201547);
                VipCardListUI vipCardListUI = VipCardListUI.this;
                View view = this.qhp.aus;
                p.g(view, "holder.itemView");
                vipCardListUI.aYO = view.getHeight();
                VipCardListUI vipCardListUI2 = VipCardListUI.this;
                View view2 = this.qhp.aus;
                p.g(view2, "holder.itemView");
                vipCardListUI2.aYN = view2.getWidth();
                this.qgW.invoke();
                AppMethodBeat.o(201547);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ MemberCardTopCropImageView qhq;
            final /* synthetic */ c qik;
            final /* synthetic */ b qil;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(c cVar, MemberCardTopCropImageView memberCardTopCropImageView, b bVar) {
                super(0);
                this.qik = cVar;
                this.qhq = memberCardTopCropImageView;
                this.qil = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                boolean z;
                AppMethodBeat.i(201548);
                Log.d(VipCardListUI.this.TAG, "view height: " + VipCardListUI.this.aYO);
                this.qhq.itemPadding = VipCardListUI.this.getResources().getDimensionPixelSize(R.dimen.ci);
                this.qhq.kn = VipCardListUI.this.aYO;
                this.qhq.setRadius((float) VipCardListUI.this.getResources().getDimensionPixelSize(R.dimen.ct));
                this.qhq.getLayoutParams().height = VipCardListUI.this.aYO;
                String str = this.qil.cxt().LcS;
                if (!(str == null || str.length() == 0)) {
                    com.tencent.mm.plugin.card.ui.v4.b.a(this.qhq, this.qil.cxt().LcS, VipCardListUI.this.aYN, VipCardListUI.this.aYO);
                } else {
                    String str2 = this.qil.cxt().LcR;
                    if (str2 == null || str2.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        this.qhq.setImageDrawable(com.tencent.mm.plugin.card.ui.v4.b.EE(Color.parseColor(this.qil.cxt().LcR)));
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(201548);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "vipCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "getVipCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "setVipCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
    public static final class b implements com.tencent.mm.view.recyclerview.a {
        public ua qii;

        public final void a(ua uaVar) {
            AppMethodBeat.i(201545);
            p.h(uaVar, "<set-?>");
            this.qii = uaVar;
            AppMethodBeat.o(201545);
        }

        public final ua cxt() {
            AppMethodBeat.i(201544);
            ua uaVar = this.qii;
            if (uaVar == null) {
                p.btv("vipCardInfo");
            }
            AppMethodBeat.o(201544);
            return uaVar;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            AppMethodBeat.i(201546);
            ua uaVar = this.qii;
            if (uaVar == null) {
                p.btv("vipCardInfo");
            }
            long hashCode = (long) uaVar.KDM.hashCode();
            AppMethodBeat.o(201546);
            return hashCode;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 1;
        }
    }

    public static final /* synthetic */ void a(VipCardListUI vipCardListUI, String str) {
        AppMethodBeat.i(201590);
        Log.i(vipCardListUI.TAG, "go to card detail ui");
        Intent intent = new Intent(vipCardListUI.getContext(), CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.addFlags(131072);
        intent.putExtra("key_from_scene", 3);
        AppCompatActivity context = vipCardListUI.getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/card/ui/v3/VipCardListUI", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(201590);
    }

    public static final /* synthetic */ int b(VipCardListUI vipCardListUI, String str) {
        AppMethodBeat.i(201591);
        int i2 = 0;
        for (T t : vipCardListUI.qib) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            if (p.j(t.cxt().KDM, str)) {
                AppMethodBeat.o(201591);
                return i2;
            }
            i2 = i3;
        }
        AppMethodBeat.o(201591);
        return -1;
    }

    public static final /* synthetic */ void c(VipCardListUI vipCardListUI, String str) {
        AppMethodBeat.i(201592);
        Log.i(vipCardListUI.TAG, "do delete card: ".concat(String.valueOf(str)));
        vipCardListUI.j(Boolean.TRUE);
        new com.tencent.mm.plugin.card.model.a.c(str).aYI().b(new d(vipCardListUI, str));
        AppMethodBeat.o(201592);
    }

    public static final /* synthetic */ void l(VipCardListUI vipCardListUI) {
        AppMethodBeat.i(201596);
        Log.i(vipCardListUI.TAG, "show sort dialog");
        if (vipCardListUI.qhI != null) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) vipCardListUI.getContext(), 1, false);
            eVar.a(new i(vipCardListUI));
            eVar.a(new j(vipCardListUI));
            eVar.dGm();
        }
        AppMethodBeat.o(201596);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(VipCardListUI vipCardListUI, ue ueVar) {
        AppMethodBeat.i(201599);
        if (ueVar != null) {
            switch (ueVar.LdC) {
                case 1:
                    String str = ueVar.LdD;
                    if (str != null) {
                        com.tencent.mm.plugin.card.d.b.a(vipCardListUI, str);
                        AppMethodBeat.o(201599);
                        return;
                    }
                    AppMethodBeat.o(201599);
                    return;
                case 2:
                    un unVar = ueVar.LdE;
                    if (unVar != null) {
                        com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                        AppMethodBeat.o(201599);
                        return;
                    }
                    AppMethodBeat.o(201599);
                    return;
                case 3:
                    String str2 = ueVar.LdF;
                    if (str2 != null) {
                        switch (str2.hashCode()) {
                            case 1405997705:
                                if (str2.equals("weixin://mktcard/membercardhistory")) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 1, 2);
                                    String str3 = ueVar.LdB;
                                    Log.i(vipCardListUI.TAG, "go to vip history card list");
                                    Intent intent = new Intent(vipCardListUI.getContext(), HistoryCardListUI.class);
                                    intent.putExtra("title", str3);
                                    intent.putExtra("card_type", 3);
                                    AppCompatActivity context = vipCardListUI.getContext();
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/card/ui/v3/VipCardListUI", "gotoVipHistoryCardListUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    context.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI", "gotoVipHistoryCardListUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.o(201599);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(201599);
            return;
        }
        AppMethodBeat.o(201599);
    }
}
