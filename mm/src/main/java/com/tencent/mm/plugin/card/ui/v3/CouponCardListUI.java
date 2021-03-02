package com.tencent.mm.plugin.card.ui.v3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.card.model.a.a;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.tz;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 G2\u00020\u0001:\u0004FGHIB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004H\u0002J\b\u00100\u001a\u00020-H\u0002J\u0012\u00101\u001a\u00020-2\b\b\u0002\u00102\u001a\u00020\u0014H\u0002J\b\u00103\u001a\u00020\u0006H\u0014J\u0010\u00104\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u00020-H\u0014J\b\u00106\u001a\u00020-H\u0002J\u0012\u00107\u001a\u00020-2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020-H\u0014J\u0018\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0014H\u0016J\b\u0010>\u001a\u00020-H\u0014J\b\u0010?\u001a\u00020-H\u0002J\b\u0010@\u001a\u00020-H\u0002J\b\u0010A\u001a\u00020-H\u0002J\b\u0010B\u001a\u00020-H\u0002J\u0010\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020EH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\b\u0012\u00060\tR\u00020\u00000\bj\f\u0012\b\u0012\u00060\tR\u00020\u0000`\nX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u00060\tR\u00020\u00000\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCouponCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lkotlin/collections/ArrayList;", "mCouponCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mCouponCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIsAll", "mIsLoading", "mNeedRefreshMch", "mOffset", "mPreviousSortInfo", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mScene", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortTv", "Landroid/widget/TextView;", "mViewHeight", "mViewWidth", "mVisitMchId", "mVisitMchTime", "", "doDeleteVipCard", "", "merchantId", "cardId", "doGetMchInfo", "doLoadCouponCardList", "refresh", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortDialog", "updateIconMenu", "updateSortView", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "CardSpan", "Companion", "CouponCardConvertData", "CouponCardConverter", "plugin-card_release"})
public final class CouponCardListUI extends CardNewBaseUI {
    public static final b qhM = new b((byte) 0);
    private final String TAG = "MicroMsg.CouponCardListUI";
    private int aYN;
    private int aYO;
    private int fs;
    private boolean mGR = true;
    private int mScene;
    private boolean mwr;
    private ViewGroup qgI;
    private RefreshLoadMoreLayout qgY;
    private ViewGroup qgZ;
    private WxRecyclerAdapter<c> qhA;
    private final ArrayList<c> qhB = new ArrayList<>();
    private int qhC = 10;
    private boolean qhD;
    private String qhE = "";
    private long qhF;
    private un qhG;
    private String qhH;
    private uw qhI;
    private String qhJ = "";
    private int qhK;
    private int qhL;
    private boolean qhf;
    private boolean qhg;
    private int qhk;
    private WxRecyclerView qhy;
    private TextView qhz;

    static {
        AppMethodBeat.i(201535);
        AppMethodBeat.o(201535);
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class e<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CouponCardListUI qhN;

        e(CouponCardListUI couponCardListUI) {
            this.qhN = couponCardListUI;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            boolean z = true;
            AppMethodBeat.i(201509);
            c.a aVar = (c.a) obj;
            Log.i(this.qhN.TAG, "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                bko bko = (bko) aVar.iLC;
                Log.i(this.qhN.TAG, "retCode: %s, refresh: %s", Integer.valueOf(bko.pTZ), Integer.valueOf(bko.LTB));
                if (bko.pTZ != 0) {
                    com.tencent.mm.plugin.card.d.l.aq(this.qhN.getContext(), bko.pUa);
                } else if (bko.LTB == 1) {
                    CouponCardListUI.b(this.qhN, true);
                } else if (bko.LTA.Lds.size() == 0) {
                    if (this.qhN.qhB.isEmpty()) {
                        z = false;
                    }
                    if (z) {
                        Iterator it = this.qhN.qhB.iterator();
                        int i2 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (p.j(((c) it.next()).cxr().Ldn, bko.LTA.Ldn)) {
                                this.qhN.qhB.remove(i2);
                                CouponCardListUI.s(this.qhN).notifyDataSetChanged();
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                } else {
                    if (!this.qhN.qhB.isEmpty()) {
                        Iterator it2 = this.qhN.qhB.iterator();
                        int i3 = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            c cVar = (c) it2.next();
                            if (p.j(cVar.cxr().Ldn, bko.LTA.Ldn)) {
                                ud udVar = bko.LTA;
                                p.g(udVar, "card_pkg_mch_info");
                                cVar.a(udVar);
                                if (this.qhN.qhK <= 0 || this.qhN.qhI == null) {
                                    CouponCardListUI.s(this.qhN).ci(i3);
                                } else {
                                    CouponCardListUI.s(this.qhN).ci(i3 + 1);
                                }
                            } else {
                                i3++;
                            }
                        }
                    }
                }
            } else {
                com.tencent.mm.plugin.card.d.l.ar(this.qhN.getContext(), "");
            }
            this.qhN.qhD = false;
            x xVar = x.SXb;
            AppMethodBeat.o(201509);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<c.a<bma>, x> {
        final /* synthetic */ boolean qgO;
        final /* synthetic */ CouponCardListUI qhN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(CouponCardListUI couponCardListUI, boolean z) {
            super(1);
            this.qhN = couponCardListUI;
            this.qgO = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(c.a<bma> aVar) {
            T t;
            boolean z;
            AppMethodBeat.i(201510);
            c.a<bma> aVar2 = aVar;
            if (aVar2 != null) {
                Log.i(this.qhN.TAG, "errType: " + aVar2.errType + ", errCode: " + aVar2.errCode + ", errMsg: " + aVar2.errMsg);
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    bma bma = (bma) aVar2.iLC;
                    if (bma != null) {
                        Log.i(this.qhN.TAG, "retcode: " + bma.pTZ + ", retmsg: " + bma.pUa);
                        if (bma.pTZ == 0) {
                            this.qhN.fs = bma.qGg;
                            this.qhN.qhf = bma.LUO > 0;
                            this.qhN.qhg = true;
                            this.qhN.qhI = bma.LUU;
                            uw uwVar = this.qhN.qhI;
                            if (uwVar != null) {
                                if (bma.LUS == 1) {
                                    LinkedList<uv> linkedList = uwVar.Let;
                                    p.g(linkedList, "card_sort_info");
                                    Iterator<T> it = linkedList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            t = null;
                                            break;
                                        }
                                        T next = it.next();
                                        if (next.Leq == bma.LUT) {
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
                                        this.qhN.qhK = t2.Leq;
                                        CouponCardListUI couponCardListUI = this.qhN;
                                        String str = t2.Les;
                                        p.g(str, "find.sort_wording");
                                        couponCardListUI.qhJ = str;
                                        this.qhN.qhC = t2.Ler;
                                    }
                                } else if (this.qhN.qhK == 0) {
                                    LinkedList<uv> linkedList2 = uwVar.Let;
                                    p.g(linkedList2, "card_sort_info");
                                    uv first = linkedList2.getFirst();
                                    this.qhN.qhK = first.Leq;
                                    CouponCardListUI couponCardListUI2 = this.qhN;
                                    String str2 = first.Les;
                                    p.g(str2, "first.sort_wording");
                                    couponCardListUI2.qhJ = str2;
                                    this.qhN.qhC = first.Ler;
                                }
                            }
                            CouponCardListUI.l(this.qhN);
                            this.qhN.qhG = bma.LUQ;
                            this.qhN.qhH = bma.LUR;
                            CouponCardListUI.n(this.qhN);
                            if (this.qgO) {
                                this.qhN.qhB.clear();
                            }
                            CouponCardListUI.a(this.qhN, bma);
                        } else {
                            com.tencent.mm.plugin.card.d.l.aq(this.qhN.getContext(), bma.pUa);
                            this.qhN.qhK = this.qhN.qhL;
                        }
                    }
                    if (this.qhN.mGR) {
                        this.qhN.mGR = false;
                    }
                } else {
                    com.tencent.mm.plugin.card.d.l.ar(this.qhN.getContext(), "");
                    this.qhN.qhK = this.qhN.qhL;
                }
                CouponCardListUI.l(this.qhN);
            }
            this.qhN.mwr = false;
            CouponCardListUI.f(this.qhN).apT(0);
            x xVar = x.SXb;
            AppMethodBeat.o(201510);
            return xVar;
        }
    }

    public CouponCardListUI() {
        AppMethodBeat.i(201534);
        AppMethodBeat.o(201534);
    }

    public static final /* synthetic */ void a(CouponCardListUI couponCardListUI, bma bma) {
        AppMethodBeat.i(201542);
        couponCardListUI.a(bma);
        AppMethodBeat.o(201542);
    }

    public static final /* synthetic */ void b(CouponCardListUI couponCardListUI, boolean z) {
        AppMethodBeat.i(201538);
        couponCardListUI.kA(z);
        AppMethodBeat.o(201538);
    }

    public static final /* synthetic */ RefreshLoadMoreLayout f(CouponCardListUI couponCardListUI) {
        AppMethodBeat.i(201539);
        RefreshLoadMoreLayout refreshLoadMoreLayout = couponCardListUI.qgY;
        if (refreshLoadMoreLayout == null) {
            p.btv("mRefreshLayout");
        }
        AppMethodBeat.o(201539);
        return refreshLoadMoreLayout;
    }

    public static final /* synthetic */ void l(CouponCardListUI couponCardListUI) {
        AppMethodBeat.i(201540);
        couponCardListUI.cxq();
        AppMethodBeat.o(201540);
    }

    public static final /* synthetic */ void n(CouponCardListUI couponCardListUI) {
        AppMethodBeat.i(201541);
        couponCardListUI.cxp();
        AppMethodBeat.o(201541);
    }

    public static final /* synthetic */ WxRecyclerAdapter s(CouponCardListUI couponCardListUI) {
        AppMethodBeat.i(201543);
        WxRecyclerAdapter<c> wxRecyclerAdapter = couponCardListUI.qhA;
        if (wxRecyclerAdapter == null) {
            p.btv("mCouponCardListAdapter");
        }
        AppMethodBeat.o(201543);
        return wxRecyclerAdapter;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$Companion;", "", "()V", "CONVERT_TYPE_COUPON_CARD", "", "CONVERT_TYPE_HEADER", "SORT_TYPE_DEFAULT", "SORT_TYPE_DISTANCE", "SORT_TYPE_EXPIRETIME", "SORT_TYPE_RCTIME", "plugin-card_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(201525);
        super.onCreate(bundle);
        initView();
        String stringExtra = getIntent().getStringExtra("title");
        String str = stringExtra;
        if (!(str == null || str.length() == 0)) {
            setMMTitle(stringExtra);
        } else {
            setMMTitle(R.string.ao_);
        }
        setActionbarColor(getResources().getColor(R.color.f3043a));
        hideActionbarLine();
        setBackBtn(new j(this));
        this.mScene = getIntent().getIntExtra("scene", 0);
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        bma cuk = a.C0902a.cuk();
        if (cuk != null) {
            this.fs = cuk.qGg;
            this.qhI = cuk.LUU;
            this.qhG = cuk.LUQ;
            this.qhH = cuk.LUR;
            cxp();
            a(cuk);
        }
        a.C0902a aVar2 = com.tencent.mm.plugin.card.model.a.a.pVg;
        uv cuo = a.C0902a.cuo();
        if (cuo != null) {
            this.qhK = cuo.Leq;
            String str2 = cuo.Les;
            p.g(str2, "cardSortInfo.sort_wording");
            this.qhJ = str2;
            this.qhC = cuo.Ler;
            this.qhL = this.qhK;
        }
        if (this.qhI != null && this.mScene == 1) {
            uw uwVar = this.qhI;
            if (uwVar == null) {
                p.hyc();
            }
            Iterator<uv> it = uwVar.Let.iterator();
            while (it.hasNext()) {
                uv next = it.next();
                if (next.Leq == 2) {
                    this.qhK = 2;
                    String str3 = next.Les;
                    p.g(str3, "sortInfo.sort_wording");
                    this.qhJ = str3;
                }
            }
        }
        cxq();
        cxq();
        if (this.qhK != 1) {
            kA(true);
        }
        AppMethodBeat.o(201525);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class j implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ CouponCardListUI qhN;

        j(CouponCardListUI couponCardListUI) {
            this.qhN = couponCardListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201518);
            this.qhN.finish();
            AppMethodBeat.o(201518);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(201526);
        View findViewById = findViewById(R.id.b2o);
        p.g(findViewById, "findViewById(R.id.chpvv3_rv)");
        this.qhy = (WxRecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.b2m);
        p.g(findViewById2, "findViewById(R.id.chpvv3_refresh_layout)");
        this.qgY = (RefreshLoadMoreLayout) findViewById2;
        View findViewById3 = findViewById(R.id.b2k);
        p.g(findViewById3, "findViewById(R.id.chpvv3_empty_layout)");
        this.qgI = (ViewGroup) findViewById3;
        WxRecyclerView wxRecyclerView = this.qhy;
        if (wxRecyclerView == null) {
            p.btv("mCouponCardListRv");
        }
        getContext();
        wxRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        this.qhA = new WxRecyclerAdapter<>(new g(this), this.qhB);
        WxRecyclerView wxRecyclerView2 = this.qhy;
        if (wxRecyclerView2 == null) {
            p.btv("mCouponCardListRv");
        }
        WxRecyclerAdapter<c> wxRecyclerAdapter = this.qhA;
        if (wxRecyclerAdapter == null) {
            p.btv("mCouponCardListAdapter");
        }
        wxRecyclerView2.setAdapter(wxRecyclerAdapter);
        LayoutInflater layoutInflater = getLayoutInflater();
        WxRecyclerView wxRecyclerView3 = this.qhy;
        if (wxRecyclerView3 == null) {
            p.btv("mCouponCardListRv");
        }
        View inflate = layoutInflater.inflate(R.layout.nn, (ViewGroup) wxRecyclerView3, false);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(201526);
            throw tVar;
        }
        this.qgZ = (ViewGroup) inflate;
        ViewGroup viewGroup = this.qgZ;
        if (viewGroup == null) {
            p.btv("mHeaderView");
        }
        ViewGroup viewGroup2 = this.qgZ;
        if (viewGroup2 == null) {
            p.btv("mHeaderView");
        }
        viewGroup.setPadding(0, viewGroup2.getPaddingTop(), 0, com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 12));
        ViewGroup viewGroup3 = this.qgZ;
        if (viewGroup3 == null) {
            p.btv("mHeaderView");
        }
        View findViewById4 = viewGroup3.findViewById(R.id.b2q);
        p.g(findViewById4, "mHeaderView.findViewById(R.id.chpvv3_sort_tv)");
        this.qhz = (TextView) findViewById4;
        ViewGroup viewGroup4 = this.qgZ;
        if (viewGroup4 == null) {
            p.btv("mHeaderView");
        }
        viewGroup4.setOnClickListener(new h(this));
        WxRecyclerAdapter<c> wxRecyclerAdapter2 = this.qhA;
        if (wxRecyclerAdapter2 == null) {
            p.btv("mCouponCardListAdapter");
        }
        ViewGroup viewGroup5 = this.qgZ;
        if (viewGroup5 == null) {
            p.btv("mHeaderView");
        }
        wxRecyclerAdapter2.f(viewGroup5, 2, false);
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.qgY;
        if (refreshLoadMoreLayout == null) {
            p.btv("mRefreshLayout");
        }
        refreshLoadMoreLayout.setEnableRefresh(false);
        RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.qgY;
        if (refreshLoadMoreLayout2 == null) {
            p.btv("mRefreshLayout");
        }
        refreshLoadMoreLayout2.setActionCallback(new i(this));
        AppMethodBeat.o(201526);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
    public static final class g implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ CouponCardListUI qhN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(CouponCardListUI couponCardListUI) {
            this.qhN = couponCardListUI;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(201511);
            d dVar = new d();
            AppMethodBeat.o(201511);
            return dVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class h implements View.OnClickListener {
        final /* synthetic */ CouponCardListUI qhN;

        h(CouponCardListUI couponCardListUI) {
            this.qhN = couponCardListUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(201512);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.d(this.qhN.TAG, "click header view");
            CouponCardListUI.c(this.qhN);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(201512);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"})
    public static final class i extends RefreshLoadMoreLayout.a {
        final /* synthetic */ CouponCardListUI qhN;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(201516);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(201516);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(201517);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(201517);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(CouponCardListUI couponCardListUI) {
            this.qhN = couponCardListUI;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(201514);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            Log.d(this.qhN.TAG, "on load more");
            com.tencent.mm.ac.d.h(new a(this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(201514);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(201515);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            Log.d(this.qhN.TAG, "on load more end: " + this.qhN.qhk);
            if (this.qhN.qhf) {
                CouponCardListUI.f(this.qhN).h((RefreshLoadMoreLayout.c<Object>) null);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(201515);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ i qhS;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(i iVar) {
                super(0);
                this.qhS = iVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(201513);
                CouponCardListUI.b(this.qhS.qhN, false);
                x xVar = x.SXb;
                AppMethodBeat.o(201513);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(201527);
        super.onResume();
        Log.i(this.TAG, "do get mch infoset: %s", Boolean.valueOf(this.qhD));
        if (this.qhD) {
            new com.tencent.mm.plugin.card.model.a.f(this.qhE, this.qhF, (double) this.latitude, (double) this.dTj, this.qhK, 1).aYH().aYI().b(new e(this)).a(this);
        }
        AppMethodBeat.o(201527);
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(201528);
        super.onDestroy();
        if (!this.qhg) {
            Log.i(this.TAG, "no data to save snapshot");
            AppMethodBeat.o(201528);
            return;
        }
        bma bma = new bma();
        bma.BaseResponse = new BaseResponse();
        bma.BaseResponse.ErrMsg = new dqi();
        bma.LUP = new uh();
        Iterator<c> it = this.qhB.iterator();
        while (it.hasNext()) {
            ud cxr = it.next().cxr();
            if (cxr != null) {
                bma.LUP.LdI.add(cxr);
            }
        }
        bma.LUU = this.qhI;
        bma.qGg = this.fs;
        bma.LUR = this.qhH;
        bma.LUQ = this.qhG;
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        p.h(bma, "response");
        Log.d(com.tencent.mm.plugin.card.model.a.a.TAG, "save vip card list snapshot");
        com.tencent.mm.ac.d.i(new a.C0902a.b(bma));
        uv uvVar = new uv();
        uvVar.Leq = this.qhK;
        uvVar.Les = this.qhJ;
        uvVar.Ler = this.qhC;
        a.C0902a aVar2 = com.tencent.mm.plugin.card.model.a.a.pVg;
        p.h(uvVar, "sortInfo");
        Log.d(com.tencent.mm.plugin.card.model.a.a.TAG, "save vip card list snapshot");
        com.tencent.mm.ac.d.i(new a.C0902a.d(uvVar));
        AppMethodBeat.o(201528);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ni;
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI
    public final void ad(int i2, boolean z) {
        AppMethodBeat.i(201529);
        if (!this.mGR || this.qhK != 1) {
            if (!z) {
                cxi();
            }
            AppMethodBeat.o(201529);
            return;
        }
        kA(true);
        AppMethodBeat.o(201529);
    }

    private final void cxp() {
        AppMethodBeat.i(201530);
        un unVar = this.qhG;
        if (unVar != null) {
            removeAllOptionMenu();
            addIconOptionMenu(0, 0, R.raw.icons_outlined_more, new m(unVar, this));
            AppMethodBeat.o(201530);
            return;
        }
        AppMethodBeat.o(201530);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$updateIconMenu$1$1"})
    public static final class m implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ CouponCardListUI qhN;
        final /* synthetic */ un qhU;

        m(un unVar, CouponCardListUI couponCardListUI) {
            this.qhU = unVar;
            this.qhN = couponCardListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201524);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.qhN.getContext(), 1, false);
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.card.ui.v3.CouponCardListUI.m.AnonymousClass1 */
                final /* synthetic */ m qhV;

                {
                    this.qhV = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(201522);
                    mVar.add(0, 0, 1, this.qhV.qhN.qhH);
                    AppMethodBeat.o(201522);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.card.ui.v3.CouponCardListUI.m.AnonymousClass2 */
                final /* synthetic */ m qhV;

                {
                    this.qhV = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(201523);
                    p.g(menuItem, "menuItem");
                    if (menuItem.getItemId() == 0) {
                        com.tencent.mm.plugin.card.d.b.H(this.qhV.qhU.Hwr, this.qhV.qhU.Hws, this.qhV.qhU.IhZ);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 2, 2);
                    }
                    AppMethodBeat.o(201523);
                }
            });
            eVar.dGm();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 2, 1);
            AppMethodBeat.o(201524);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class k implements o.f {
        final /* synthetic */ CouponCardListUI qhN;

        k(CouponCardListUI couponCardListUI) {
            this.qhN = couponCardListUI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(201519);
            uw uwVar = this.qhN.qhI;
            if (uwVar == null) {
                p.hyc();
            }
            Iterator<uv> it = uwVar.Let.iterator();
            while (it.hasNext()) {
                uv next = it.next();
                mVar.add(0, next.Leq, 1, next.Les);
            }
            AppMethodBeat.o(201519);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class l implements o.g {
        final /* synthetic */ CouponCardListUI qhN;

        l(CouponCardListUI couponCardListUI) {
            this.qhN = couponCardListUI;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(201521);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            Log.i(this.qhN.TAG, "click item: %s", Integer.valueOf(itemId));
            if (itemId != 1) {
                this.qhN.qhL = this.qhN.qhK;
                this.qhN.qhK = itemId;
                this.qhN.qhJ = menuItem.getTitle().toString();
                CouponCardListUI.l(this.qhN);
                CouponCardListUI.b(this.qhN, true);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 2, 6);
                AppMethodBeat.o(201521);
            } else if (!this.qhN.qgs) {
                com.tencent.mm.ui.base.h.a((Context) this.qhN.getContext(), this.qhN.getString(R.string.aq9), this.qhN.getString(R.string.flp), this.qhN.getString(R.string.e_k), this.qhN.getString(R.string.b96), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.card.ui.v3.CouponCardListUI.l.AnonymousClass1 */
                    final /* synthetic */ l qhT;

                    {
                        this.qhT = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(201520);
                        this.qhT.qhN.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
                        AppMethodBeat.o(201520);
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(201521);
            } else {
                this.qhN.qhL = this.qhN.qhK;
                this.qhN.qhK = 1;
                this.qhN.qhJ = menuItem.getTitle().toString();
                CouponCardListUI.l(this.qhN);
                CouponCardListUI.b(this.qhN, true);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 2, 5);
                AppMethodBeat.o(201521);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void cxq() {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.ui.v3.CouponCardListUI.cxq():void");
    }

    private final void kA(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(201532);
        Log.i(this.TAG, "do load vip card list: " + this.mwr + ", " + this.fs + ", " + this.qhK);
        if (this.qhf && !z) {
            Log.w(this.TAG, "already load complete");
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.qgY;
            if (refreshLoadMoreLayout == null) {
                p.btv("mRefreshLayout");
            }
            refreshLoadMoreLayout.apT(0);
            AppMethodBeat.o(201532);
        } else if (this.mwr) {
            Log.w(this.TAG, "is loading");
            AppMethodBeat.o(201532);
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
            com.tencent.mm.co.f aYI = new com.tencent.mm.plugin.card.model.b.a(i2, this.qhC, (double) this.latitude, (double) this.dTj, this.qhK).aYH().aYI();
            p.g(aYI, "CgiGetCouponHomePage(off…ntCancelAfterDead().run()");
            com.tencent.mm.ac.d.b(aYI, new f(this, z)).b(this);
            AppMethodBeat.o(201532);
        }
    }

    private final void a(bma bma) {
        AppMethodBeat.i(201533);
        if (bma.LUP == null || bma.LUP.LdI.isEmpty()) {
            AppMethodBeat.o(201533);
            return;
        }
        Iterator<ud> it = bma.LUP.LdI.iterator();
        while (it.hasNext()) {
            ud next = it.next();
            c cVar = new c();
            p.g(next, "cardInfo");
            cVar.a(next);
            this.qhB.add(cVar);
        }
        if (this.qhB.isEmpty()) {
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
        WxRecyclerAdapter<c> wxRecyclerAdapter = this.qhA;
        if (wxRecyclerAdapter == null) {
            p.btv("mCouponCardListAdapter");
        }
        wxRecyclerAdapter.notifyDataSetChanged();
        AppMethodBeat.o(201533);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J4\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J$\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J$\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0016JD\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0016J \u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J$\u0010\"\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J$\u0010#\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J$\u0010$\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u001e\u0010%\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020*H\u0002J,\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "headerClickListener", "Landroid/view/View$OnClickListener;", "addCouponView", "", "view", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "appendCouponView", "offset", "", "len", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "collapseCouponLayout", "expandCouponLayout", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "updateExpandLayout", "isExpended", "plugin-card_release"})
    public final class d extends com.tencent.mm.view.recyclerview.e<c> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, c cVar, int i2, int i3, boolean z, List list) {
            boolean z2;
            AppMethodBeat.i(201501);
            c cVar2 = cVar;
            p.h(hVar, "holder");
            p.h(cVar2, "item");
            ud cxr = cVar2.cxr();
            String str = cxr.Ldo;
            if (!(str == null || str.length() == 0)) {
                View Mn = hVar.Mn(R.id.b20);
                p.g(Mn, "holder.getView(R.id.chpi_logo_iv)");
                String str2 = cxr.Ldo;
                p.g(str2, "couponCardInfo.card_element_mch_icon");
                com.tencent.mm.plugin.card.d.m.a((ImageView) Mn, str2, true, R.raw.card_default_merchant_icon, 0, 0, 100);
            } else {
                ((ImageView) hVar.Mn(R.id.b20)).setImageResource(R.raw.card_default_merchant_icon);
            }
            e eVar = new e(this, hVar);
            ((ImageView) hVar.Mn(R.id.b20)).setOnClickListener(eVar);
            TextView textView = (TextView) hVar.Mn(R.id.b24);
            String str3 = cxr.Ldp;
            if (!(str3 == null || str3.length() == 0)) {
                CouponCardListUI couponCardListUI = CouponCardListUI.this;
                AppCompatActivity context = CouponCardListUI.this.getContext();
                p.g(context, "context");
                int color = context.getResources().getColor(R.color.a2x);
                AppCompatActivity context2 = CouponCardListUI.this.getContext();
                p.g(context2, "context");
                a aVar = new a(couponCardListUI, color, context2.getResources().getColor(R.color.a91), new f(eVar));
                SpannableString spannableString = new SpannableString(cxr.Ldp);
                spannableString.setSpan(aVar, 0, spannableString.length(), 18);
                p.g(textView, "usernameTv");
                textView.setClickable(true);
                textView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(CouponCardListUI.this.getContext()));
                textView.setText(spannableString);
            } else {
                p.g(textView, "usernameTv");
                textView.setText("");
            }
            if (!cVar2.qfr) {
                z2 = cxr.Ldx == 1;
            } else {
                z2 = cVar2.qfs;
            }
            ViewGroup viewGroup = (ViewGroup) hVar.Mn(R.id.b1t);
            ViewGroup viewGroup2 = (ViewGroup) hVar.Mn(R.id.b1w);
            viewGroup.removeAllViews();
            if (z2) {
                LinkedList<ua> linkedList = cxr.Lds;
                p.g(linkedList, "couponCardInfo.card_element_coupon_list");
                if (!linkedList.isEmpty()) {
                    a(-1, cxr.Lds.size(), hVar, cVar2, i2);
                    p.g(viewGroup, "chpiCouponLayout");
                    viewGroup.setVisibility(0);
                    cVar2.qfs = true;
                } else {
                    p.g(viewGroup, "chpiCouponLayout");
                    viewGroup.setVisibility(8);
                }
                String str4 = cxr.Ldt;
                if (!(str4 == null || str4.length() == 0)) {
                    a(hVar, cVar2);
                    p.g(viewGroup2, "chpiExpandLayout");
                    viewGroup2.setVisibility(0);
                } else if (cxr.Ldz < cxr.Lds.size()) {
                    b(hVar, cVar2, i2);
                } else {
                    p.g(viewGroup2, "chpiExpandLayout");
                    viewGroup2.setVisibility(8);
                }
            } else {
                LinkedList<ua> linkedList2 = cxr.Lds;
                p.g(linkedList2, "couponCardInfo.card_element_coupon_list");
                if (!linkedList2.isEmpty()) {
                    a(-1, cxr.Ldz, hVar, cVar2, i2);
                    p.g(viewGroup, "chpiCouponLayout");
                    viewGroup.setVisibility(0);
                    cVar2.qfs = false;
                } else {
                    p.g(viewGroup, "chpiCouponLayout");
                    viewGroup.setVisibility(8);
                }
                if (cxr.Ldz >= cxr.Lds.size()) {
                    String str5 = cxr.Ldt;
                    if (!(str5 == null || str5.length() == 0)) {
                        a(hVar, cVar2);
                        p.g(viewGroup2, "chpiExpandLayout");
                        viewGroup2.setVisibility(0);
                    } else {
                        p.g(viewGroup2, "chpiExpandLayout");
                        viewGroup2.setVisibility(8);
                    }
                } else {
                    a(hVar, cVar2, i2);
                    p.g(viewGroup2, "chpiExpandLayout");
                    viewGroup2.setVisibility(0);
                }
            }
            cVar2.qfr = true;
            AppMethodBeat.o(201501);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.nh;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
            AppMethodBeat.i(201500);
            p.h(recyclerView, "recyclerView");
            p.h(hVar, "holder");
            AppMethodBeat.o(201500);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class e implements View.OnClickListener {
            final /* synthetic */ d qhP;
            final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

            e(d dVar, com.tencent.mm.view.recyclerview.h hVar) {
                this.qhP = dVar;
                this.qhp = hVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(201495);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$onBindViewHolder$headerClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i(CouponCardListUI.this.TAG, "click header view: " + this.qhp.lR());
                ud cxr = ((c) this.qhp.hgv()).cxr();
                if (cxr != null) {
                    switch (cxr.Ldc) {
                        case 1:
                            CouponCardListUI.this.qhD = true;
                            CouponCardListUI couponCardListUI = CouponCardListUI.this;
                            String str = cxr.Ldn;
                            p.g(str, "card_pack_merchant_id");
                            couponCardListUI.qhE = str;
                            CouponCardListUI.this.qhF = cxr.LdA;
                            AppCompatActivity context = CouponCardListUI.this.getContext();
                            if (context != null) {
                                com.tencent.mm.plugin.card.d.b.a((MMActivity) context, cxr.Ldd);
                                break;
                            } else {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                                AppMethodBeat.o(201495);
                                throw tVar;
                            }
                        case 2:
                            CouponCardListUI.this.qhD = true;
                            CouponCardListUI couponCardListUI2 = CouponCardListUI.this;
                            String str2 = cxr.Ldn;
                            p.g(str2, "card_pack_merchant_id");
                            couponCardListUI2.qhE = str2;
                            CouponCardListUI.this.qhF = cxr.LdA;
                            un unVar = cxr.Lde;
                            com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                            break;
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$onBindViewHolder$headerClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(201495);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$onBindViewHolder$span$1", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "onClick", "", "widget", "Landroid/view/View;", "hrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "plugin-card_release"})
        public static final class f extends com.tencent.mm.pluginsdk.ui.span.j {
            final /* synthetic */ View.OnClickListener qfW;

            f(View.OnClickListener onClickListener) {
                this.qfW = onClickListener;
            }

            @Override // com.tencent.mm.pluginsdk.ui.span.j
            public final void a(View view, u uVar) {
                AppMethodBeat.i(201496);
                this.qfW.onClick(view);
                AppMethodBeat.o(201496);
            }
        }

        private static void a(com.tencent.mm.view.recyclerview.h hVar, c cVar) {
            AppMethodBeat.i(201502);
            ud cxr = cVar.cxr();
            TextView textView = (TextView) hVar.Mn(R.id.b1x);
            ImageView imageView = (ImageView) hVar.Mn(R.id.b1v);
            ViewGroup viewGroup = (ViewGroup) hVar.Mn(R.id.b1w);
            if (!Util.isNullOrNil(cxr.Ldt)) {
                if (!Util.isNullOrNil(cxr.Ldu)) {
                    textView.setTextColor(Color.parseColor(cxr.Ldu));
                }
                p.g(textView, "chpiExpandTv");
                textView.setText(cxr.Ldt);
                imageView.setImageResource(R.drawable.c1h);
                viewGroup.setOnClickListener(new i(cxr));
            }
            AppMethodBeat.o(201502);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class i implements View.OnClickListener {
            final /* synthetic */ ud qfS;

            i(ud udVar) {
                this.qfS = udVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(201499);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showMiniAppLayout$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.qfS.Ldv != null) {
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(this.qfS.Ldv != null);
                    Log.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", objArr);
                    com.tencent.mm.plugin.card.d.b.H(this.qfS.Ldv.Hwr, this.qfS.Ldv.Hws, this.qfS.Ldv.IhZ);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showMiniAppLayout$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(201499);
            }
        }

        private final void a(com.tencent.mm.view.recyclerview.h hVar, c cVar, int i2) {
            AppMethodBeat.i(201503);
            ud cxr = cVar.cxr();
            TextView textView = (TextView) hVar.Mn(R.id.b1x);
            ImageView imageView = (ImageView) hVar.Mn(R.id.b1v);
            ViewGroup viewGroup = (ViewGroup) hVar.Mn(R.id.b1w);
            p.g(textView, "chpiExpandTv");
            Resources resources = MMApplicationContext.getResources();
            Object[] objArr = new Object[1];
            if (cxr == null) {
                p.hyc();
            }
            objArr[0] = Integer.valueOf(cxr.Ldy - cxr.Ldz);
            textView.setText(resources.getString(R.string.apo, objArr));
            viewGroup.setOnClickListener(new h(this, hVar, cVar, i2));
            imageView.setImageResource(R.drawable.c2_);
            p.g(imageView, "chpiExpandIv");
            imageView.setVisibility(0);
            AppMethodBeat.o(201503);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class h implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ d qhP;
            final /* synthetic */ c qhR;
            final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

            h(d dVar, com.tencent.mm.view.recyclerview.h hVar, c cVar, int i2) {
                this.qhP = dVar;
                this.qhp = hVar;
                this.qhR = cVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(201498);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d(CouponCardListUI.this.TAG, "do expand coupon layout");
                d dVar = this.qhP;
                com.tencent.mm.view.recyclerview.h hVar = this.qhp;
                c cVar = this.qhR;
                int i2 = this.gUj;
                ud cxr = cVar.cxr();
                hVar.Mn(R.id.b1x);
                hVar.Mn(R.id.b1v);
                ViewGroup viewGroup = (ViewGroup) hVar.Mn(R.id.b1w);
                ViewGroup viewGroup2 = (ViewGroup) hVar.Mn(R.id.b1t);
                p.g(viewGroup2, "chpiCouponLayout");
                int childCount = viewGroup2.getChildCount();
                if (cxr == null) {
                    p.hyc();
                }
                if (childCount < cxr.Ldy) {
                    dVar.a(cxr.Ldz, -1, hVar, cVar, i2);
                    if (cxr.Ldz >= cxr.Ldy) {
                        p.g(viewGroup, "chpiExpandLayout");
                        viewGroup.setVisibility(8);
                    } else {
                        dVar.a(true, hVar, cVar, i2);
                    }
                }
                this.qhR.qfs = true;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(201498);
            }
        }

        private final void b(com.tencent.mm.view.recyclerview.h hVar, c cVar, int i2) {
            AppMethodBeat.i(201504);
            cVar.cxr();
            TextView textView = (TextView) hVar.Mn(R.id.b1x);
            ImageView imageView = (ImageView) hVar.Mn(R.id.b1v);
            p.g(textView, "chpiExpandTv");
            textView.setText(MMApplicationContext.getResources().getString(R.string.apm));
            ((ViewGroup) hVar.Mn(R.id.b1w)).setOnClickListener(new g(this, hVar, cVar, i2));
            imageView.setImageResource(R.drawable.c2a);
            p.g(imageView, "chpiExpandIv");
            imageView.setVisibility(0);
            AppMethodBeat.o(201504);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class g implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ d qhP;
            final /* synthetic */ c qhR;
            final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

            g(d dVar, com.tencent.mm.view.recyclerview.h hVar, c cVar, int i2) {
                this.qhP = dVar;
                this.qhp = hVar;
                this.qhR = cVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(201497);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
                d dVar = this.qhP;
                com.tencent.mm.view.recyclerview.h hVar = this.qhp;
                c cVar = this.qhR;
                int i2 = this.gUj;
                ud cxr = cVar.cxr();
                ViewGroup viewGroup = (ViewGroup) hVar.Mn(R.id.b1t);
                p.g(viewGroup, "chpiCouponLayout");
                if (viewGroup.getChildCount() > cxr.Ldz) {
                    String str = CouponCardListUI.this.TAG;
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(viewGroup.getChildCount());
                    if (cxr == null) {
                        p.hyc();
                    }
                    objArr[1] = Integer.valueOf(cxr.Ldz);
                    Log.d(str, "collapse count: %s, limit: %s", objArr);
                    int childCount = viewGroup.getChildCount() - 1;
                    int i3 = cxr.Ldz;
                    if (childCount >= i3) {
                        while (true) {
                            viewGroup.removeViewAt(childCount);
                            if (childCount == i3) {
                                break;
                            }
                            childCount--;
                        }
                    }
                }
                dVar.a(false, hVar, cVar, i2);
                this.qhR.qfs = false;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(201497);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(boolean z, com.tencent.mm.view.recyclerview.h hVar, c cVar, int i2) {
            AppMethodBeat.i(201505);
            ud cxr = cVar.cxr();
            if (!z) {
                a(hVar, cVar, i2);
                AppMethodBeat.o(201505);
            } else if (!Util.isNullOrNil(cxr.Ldt)) {
                a(hVar, cVar);
                AppMethodBeat.o(201505);
            } else {
                b(hVar, cVar, i2);
                AppMethodBeat.o(201505);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, int i3, com.tencent.mm.view.recyclerview.h hVar, c cVar, int i4) {
            AppMethodBeat.i(201506);
            ud cxr = cVar.cxr();
            ViewGroup viewGroup = (ViewGroup) hVar.Mn(R.id.b1t);
            int i5 = 0;
            LinkedList<ua> linkedList = cxr.Lds;
            p.g(linkedList, "el.card_element_coupon_list");
            int i6 = 0;
            for (T t : linkedList) {
                if (i5 >= i2) {
                    z.f fVar = new z.f();
                    if (t.LcU == 1) {
                        p.g(viewGroup, "chpiCouponLayout");
                        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.n8, viewGroup, false);
                        if (inflate == null) {
                            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(201506);
                            throw tVar;
                        }
                        fVar.SYG = (T) ((ViewGroup) inflate);
                        TextView textView = (TextView) fVar.SYG.findViewById(R.id.b1f);
                        CdnImageView cdnImageView = (CdnImageView) fVar.SYG.findViewById(R.id.b1c);
                        TextView textView2 = (TextView) fVar.SYG.findViewById(R.id.b1d);
                        LinearLayout linearLayout = (LinearLayout) fVar.SYG.findViewById(R.id.b1e);
                        if (!Util.isNullOrNil(t.LcX)) {
                            textView.setTextColor(com.tencent.mm.plugin.card.d.l.cT(t.LcX, t.LcY));
                        }
                        p.g(textView, "titleTv");
                        textView.setText(t.LcO);
                        cdnImageView.setUrl(t.LcV);
                        if (!Util.isNullOrNil(t.LcZ)) {
                            textView2.setTextColor(com.tencent.mm.plugin.card.d.l.cT(t.LcZ, t.Lda));
                        }
                        p.g(textView2, "descTv");
                        textView2.setText(t.LcP);
                        LinkedList<tz> linkedList2 = t.LcT;
                        p.g(linkedList2, "coupon.coupon_label");
                        p.g(linearLayout, "labelLayout");
                        a(linkedList2, linearLayout);
                        viewGroup.getChildCount();
                        fVar.SYG.setOnClickListener(new a(this, cxr, t, i5, i4));
                        fVar.SYG.setTag(t.KDM);
                        b(fVar.SYG, viewGroup);
                    } else if (t.LcU == 2) {
                        p.g(viewGroup, "chpiCouponLayout");
                        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.n7, viewGroup, false);
                        if (inflate2 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(201506);
                            throw tVar2;
                        }
                        fVar.SYG = (T) ((ViewGroup) inflate2);
                        TextView textView3 = (TextView) fVar.SYG.findViewById(R.id.b1f);
                        TextView textView4 = (TextView) fVar.SYG.findViewById(R.id.b1d);
                        LinearLayout linearLayout2 = (LinearLayout) fVar.SYG.findViewById(R.id.b1e);
                        MemberCardTopCropImageView memberCardTopCropImageView = (MemberCardTopCropImageView) fVar.SYG.findViewById(R.id.b1a);
                        ImageView imageView = (ImageView) fVar.SYG.findViewById(R.id.b1b);
                        if (!Util.isNullOrNil(t.LcX)) {
                            textView3.setTextColor(com.tencent.mm.plugin.card.d.l.cT(t.LcX, t.LcY));
                        }
                        p.g(textView3, "titleTv");
                        textView3.setText(t.LcO);
                        p.g(textView4, "descTv");
                        textView4.setText(t.LcP);
                        p.g(memberCardTopCropImageView, "bgIv");
                        memberCardTopCropImageView.setRadius((float) com.tencent.mm.cb.a.fromDPToPix(memberCardTopCropImageView.getContext(), 2));
                        if (!Util.isNullOrNil(t.LcS)) {
                            View findViewById = fVar.SYG.findViewById(R.id.b1a);
                            p.g(findViewById, "view.findViewById(R.id.chpc_bg_iv)");
                            C0913d dVar = new C0913d(this, (MemberCardTopCropImageView) findViewById, t);
                            if (CouponCardListUI.this.aYO <= 0 || CouponCardListUI.this.aYN <= 0) {
                                CouponCardListUI.this.aYO = fVar.SYG.getHeight();
                                CouponCardListUI.this.aYN = fVar.SYG.getWidth();
                                if (CouponCardListUI.this.aYO <= 0 || CouponCardListUI.this.aYN <= 0) {
                                    hVar.aus.post(new b(this, fVar, dVar));
                                } else {
                                    dVar.invoke();
                                }
                            } else {
                                dVar.invoke();
                            }
                            p.g(imageView, "shadowBgIv");
                            imageView.setVisibility(0);
                        } else if (!Util.isNullOrNil(t.LcR)) {
                            memberCardTopCropImageView.setImageDrawable(new ColorDrawable(Color.parseColor(t.LcR)));
                            p.g(imageView, "shadowBgIv");
                            imageView.setVisibility(0);
                        }
                        LinkedList<tz> linkedList3 = t.LcT;
                        p.g(linkedList3, "coupon.coupon_label");
                        p.g(linearLayout2, "labelLayout");
                        a(linkedList3, linearLayout2);
                        viewGroup.getChildCount();
                        fVar.SYG.setOnClickListener(new c(this, cxr, t));
                        fVar.SYG.setTag(t.KDM);
                        b(fVar.SYG, viewGroup);
                    }
                    if (i3 > 0 && (i6 = i6 + 1) >= i3) {
                        break;
                    }
                }
                i5++;
                i6 = i6;
            }
            AppMethodBeat.o(201506);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class a implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ int hAM;
            final /* synthetic */ ud qfQ;
            final /* synthetic */ ua qfR;
            final /* synthetic */ d qhP;

            a(d dVar, ud udVar, ua uaVar, int i2, int i3) {
                this.qhP = dVar;
                this.qfQ = udVar;
                this.qfR = uaVar;
                this.hAM = i2;
                this.gUj = i3;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(201491);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CouponCardListUI.this.qhD = true;
                CouponCardListUI couponCardListUI = CouponCardListUI.this;
                String str = this.qfQ.Ldn;
                p.g(str, "el.card_pack_merchant_id");
                couponCardListUI.qhE = str;
                CouponCardListUI.this.qhF = this.qfQ.LdA;
                CouponCardListUI couponCardListUI2 = CouponCardListUI.this;
                String str2 = this.qfR.KDM;
                p.g(str2, "coupon.user_card_id");
                CouponCardListUI.b(couponCardListUI2, str2);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(19748, 1, Long.valueOf(System.currentTimeMillis() / 1000), this.qfR.KDM, Integer.valueOf(this.hAM), Integer.valueOf(this.gUj));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(201491);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class b implements Runnable {
            final /* synthetic */ kotlin.g.a.a qgW;
            final /* synthetic */ d qhP;
            final /* synthetic */ z.f qhQ;

            b(d dVar, z.f fVar, kotlin.g.a.a aVar) {
                this.qhP = dVar;
                this.qhQ = fVar;
                this.qgW = aVar;
            }

            public final void run() {
                AppMethodBeat.i(201492);
                CouponCardListUI.this.aYO = this.qhQ.SYG.getHeight();
                CouponCardListUI.this.aYN = this.qhQ.SYG.getWidth();
                this.qgW.invoke();
                AppMethodBeat.o(201492);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class c implements View.OnClickListener {
            final /* synthetic */ ud qfQ;
            final /* synthetic */ ua qfR;
            final /* synthetic */ d qhP;

            c(d dVar, ud udVar, ua uaVar) {
                this.qhP = dVar;
                this.qfQ = udVar;
                this.qfR = uaVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(201493);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CouponCardListUI.this.qhD = true;
                CouponCardListUI couponCardListUI = CouponCardListUI.this;
                String str = this.qfQ.Ldn;
                p.g(str, "el.card_pack_merchant_id");
                couponCardListUI.qhE = str;
                CouponCardListUI.this.qhF = this.qfQ.LdA;
                CouponCardListUI couponCardListUI2 = CouponCardListUI.this;
                String str2 = this.qfR.KDM;
                p.g(str2, "coupon.user_card_id");
                CouponCardListUI.b(couponCardListUI2, str2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(201493);
            }
        }

        private final void a(List<? extends tz> list, LinearLayout linearLayout) {
            AppMethodBeat.i(201507);
            for (tz tzVar : list) {
                CardTagTextView cardTagTextView = new CardTagTextView(CouponCardListUI.this.getContext());
                AppCompatActivity context = CouponCardListUI.this.getContext();
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
            AppMethodBeat.o(201507);
        }

        private static void b(View view, ViewGroup viewGroup) {
            AppMethodBeat.i(201508);
            if (viewGroup.getChildCount() == 0) {
                viewGroup.addView(view);
                AppMethodBeat.o(201508);
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(viewGroup.getContext(), 84));
            marginLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(viewGroup.getContext(), 8);
            viewGroup.addView(view, new LinearLayout.LayoutParams(marginLayoutParams));
            AppMethodBeat.o(201508);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v3.CouponCardListUI$d$d  reason: collision with other inner class name */
        public static final class C0913d extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ ua qfR;
            final /* synthetic */ d qhP;
            final /* synthetic */ MemberCardTopCropImageView qhq;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0913d(d dVar, MemberCardTopCropImageView memberCardTopCropImageView, ua uaVar) {
                super(0);
                this.qhP = dVar;
                this.qhq = memberCardTopCropImageView;
                this.qfR = uaVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(201494);
                Log.i(CouponCardListUI.this.TAG, "view height: " + CouponCardListUI.this.aYO + ", view width: " + CouponCardListUI.this.aYN);
                this.qhq.itemPadding = CouponCardListUI.this.getResources().getDimensionPixelSize(R.dimen.ci);
                this.qhq.kn = CouponCardListUI.this.aYO;
                this.qhq.setRadius((float) CouponCardListUI.this.getResources().getDimensionPixelSize(R.dimen.bt));
                this.qhq.getLayoutParams().height = CouponCardListUI.this.aYO;
                String str = this.qfR.LcS;
                if (str != null) {
                    com.tencent.mm.plugin.card.d.m.a(this.qhq, str, false, 0, CouponCardListUI.this.aYN, CouponCardListUI.this.aYO, 28);
                    x xVar = x.SXb;
                    AppMethodBeat.o(201494);
                    return xVar;
                }
                AppMethodBeat.o(201494);
                return null;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "couponCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getCouponCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setCouponCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "getItemId", "", "getItemType", "", "plugin-card_release"})
    public final class c implements com.tencent.mm.view.recyclerview.a {
        boolean qfr;
        boolean qfs;
        public ud qhO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        public final void a(ud udVar) {
            AppMethodBeat.i(201489);
            p.h(udVar, "<set-?>");
            this.qhO = udVar;
            AppMethodBeat.o(201489);
        }

        public final ud cxr() {
            AppMethodBeat.i(201488);
            ud udVar = this.qhO;
            if (udVar == null) {
                p.btv("couponCardInfo");
            }
            AppMethodBeat.o(201488);
            return udVar;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            AppMethodBeat.i(201490);
            ud udVar = this.qhO;
            if (udVar == null) {
                p.btv("couponCardInfo");
            }
            long hashCode = (long) udVar.Ldn.hashCode();
            AppMethodBeat.o(201490);
            return hashCode;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 1;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CardSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "linkColor", "", "bgColor", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;IILcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "plugin-card_release"})
    public final class a extends com.tencent.mm.pluginsdk.ui.span.p {
        final /* synthetic */ CouponCardListUI qhN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CouponCardListUI couponCardListUI, int i2, int i3, com.tencent.mm.pluginsdk.ui.span.j jVar) {
            super(i2, i3);
            p.h(jVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.qhN = couponCardListUI;
            AppMethodBeat.i(201487);
            this.mClickListener = jVar;
            AppMethodBeat.o(201487);
        }

        @Override // com.tencent.mm.pluginsdk.ui.span.p
        public final void onClick(View view) {
            AppMethodBeat.i(201486);
            p.h(view, "widget");
            if (this.mClickListener != null) {
                this.mClickListener.a(view, null);
            }
            AppMethodBeat.o(201486);
        }
    }

    public static final /* synthetic */ void b(CouponCardListUI couponCardListUI, String str) {
        AppMethodBeat.i(201536);
        Log.i(couponCardListUI.TAG, "go to card detail ui");
        Intent intent = new Intent(couponCardListUI.getContext(), CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.addFlags(131072);
        intent.putExtra("key_from_scene", 3);
        AppCompatActivity context = couponCardListUI.getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI", "gotoCardDetailUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(201536);
    }

    public static final /* synthetic */ void c(CouponCardListUI couponCardListUI) {
        AppMethodBeat.i(201537);
        Log.i(couponCardListUI.TAG, "show sort dialog");
        if (couponCardListUI.qhI != null) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) couponCardListUI.getContext(), 1, false);
            eVar.a(new k(couponCardListUI));
            eVar.a(new l(couponCardListUI));
            eVar.dGm();
        }
        AppMethodBeat.o(201537);
    }
}
