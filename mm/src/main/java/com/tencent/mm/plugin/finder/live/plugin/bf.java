package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.finder.cgi.s;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.view.adapter.h;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingPanel;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.fhd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 c2\u00020\u00012\u00020\u0002:\u0001cB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\tH\u0002J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u00020.H\u0002J\b\u00104\u001a\u00020.H\u0002J\b\u00105\u001a\u00020.H\u0002J\b\u00106\u001a\u00020.H\u0002J\b\u00107\u001a\u00020.H\u0002J\u0006\u00108\u001a\u00020.J\b\u00109\u001a\u00020\u001aH\u0016J\u0012\u0010:\u001a\u00020.2\b\u0010;\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010<\u001a\u00020.H\u0002J\u0012\u0010=\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0010\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020\u001aH\u0002J\u0012\u0010B\u001a\u00020.2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J$\u0010E\u001a\u00020.2\b\u0010F\u001a\u0004\u0018\u00010?2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010O\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010P\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010Q\u001a\u00020.H\u0002J\u0010\u0010R\u001a\u00020.2\u0006\u0010S\u001a\u00020\tH\u0002J\u0010\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020VH\u0002J\b\u0010W\u001a\u00020.H\u0002J,\u0010X\u001a\u00020.2\u0006\u0010U\u001a\u00020V2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010Z2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u001a\u0010\\\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010]\u001a\u00020\u001aJ\b\u0010^\u001a\u00020.H\u0002J\u001a\u0010_\u001a\u00020.2\u0006\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010?H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TITLE_GROUP_HEIGHT", "", "getTITLE_GROUP_HEIGHT", "()I", "setTITLE_GROUP_HEIGHT", "(I)V", "blankArea", "Landroid/view/View;", "close", "Landroid/widget/ImageView;", "contentGroup", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingPanel;", "emptyAction", "Landroid/widget/TextView;", "emptyGroup", "footer", "footerTv", "hasNotifyVisitorShopping", "", "loadingBar", "Landroid/widget/ProgressBar;", "loadingMore", "maskHideAnim", "Landroid/animation/ObjectAnimator;", "maskShowAnim", "maskView", "notifyVisitorShoppingTimes", "order", "productsTitle", "retryTip", "shoppingList", "Landroid/support/v7/widget/RecyclerView;", "shoppingListAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;", "titleGroup", "touchLoc", "", "addProduct", "", "checkLoadMore", "lastVisiblePosition", "gotoShoppingOrder", "hideMaskView", "hideShoppingContent", "initLandscapeLogic", "initPortraitLogic", "initTitleGroupHeight", "initView", "notifyVisitorShopping", "onBackPress", "onClick", "v", "onGetShoppingListFail", "onGetShoppingListSuccess", "info", "Landroid/os/Bundle;", "onLoadMoreFinish", "success", "onNewIntent", "intent", "Landroid/content/Intent;", "onPortraitDelayAction", "extraMsg", "extraData", "", "delayMs", "", "openFullScreenMiniprogram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "openFullScreenMiniprogramImpl", "openHalfScreenMiniprogram", "openHalfScreenMiniprogramImpl", "reportWhenAddProduct", "setFooterTvVisibility", "visibility", "showEmptyContent", "data", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "showMaskView", "showProductList", "productList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "showShoppingContent", "refresh", "showShoppingLoading", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Companion", "plugin-finder_release"})
public final class bf extends d implements View.OnClickListener {
    private static final String TAG = TAG;
    private static final String utU = utU;
    private static final String utV = utV;
    public static final g utW = new g((byte) 0);
    private final com.tencent.mm.live.c.b hOp;
    private TextView hRL;
    private ProgressBar hRO;
    private View hRR;
    private View hRx;
    private View maskView;
    private View qdl;
    private TextView unG;
    private boolean unJ;
    private View ush;
    private int utH;
    private FinderLiveShoppingPanel utI;
    private ImageView utJ;
    private TextView utK;
    private RecyclerView utL;
    private TextView utM;
    private TextView utN;
    private com.tencent.mm.plugin.finder.live.view.adapter.h utO;
    private ObjectAnimator utP;
    private ObjectAnimator utQ;
    private int utR;
    private boolean utS;
    private int[] utT = new int[2];

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$1"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.api.g, kotlin.x> {
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(bf bfVar) {
            super(1);
            this.utX = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(com.tencent.mm.plugin.appbrand.api.g gVar) {
            AppMethodBeat.i(246982);
            com.tencent.mm.plugin.appbrand.api.g gVar2 = gVar;
            kotlin.g.b.p.h(gVar2, "bundle");
            bf.b(this.utX, gVar2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246982);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "success", "", "invoke"})
    public static final class aa extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ bf utX;
        final /* synthetic */ Bundle uua;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aa(bf bfVar, Bundle bundle) {
            super(1);
            this.utX = bfVar;
            this.uua = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(247013);
            boolean booleanValue = bool.booleanValue();
            if (this.utX.hwr.getVisibility() == 0) {
                if (booleanValue) {
                    bf.b(this.utX, this.uua);
                } else {
                    bf.j(this.utX);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(247013);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$2"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.api.g, kotlin.x> {
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(bf bfVar) {
            super(1);
            this.utX = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(com.tencent.mm.plugin.appbrand.api.g gVar) {
            AppMethodBeat.i(246983);
            com.tencent.mm.plugin.appbrand.api.g gVar2 = gVar;
            kotlin.g.b.p.h(gVar2, "bundle");
            bf.a(this.utX, gVar2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246983);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "empty", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$3"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(bf bfVar) {
            super(1);
            this.utX = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(246984);
            if (bool.booleanValue() && this.utX.hwr.getVisibility() == 0) {
                bf bfVar = this.utX;
                if (this.utX.getLiveData().uEl == null) {
                    new awc();
                }
                bf.k(bfVar);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246984);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "promting", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$4"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(bf bfVar) {
            super(1);
            this.utX = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(246985);
            if (bool.booleanValue()) {
                bf.s(this.utX);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246985);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, hxF = {"<anonymous>", "", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$ShoppingViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;", "itemView", "Landroid/view/View;", "pos", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$5"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.q<h.b, View, Integer, kotlin.x> {
        final /* synthetic */ bf utX;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.view.adapter.h utY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(com.tencent.mm.plugin.finder.live.view.adapter.h hVar, bf bfVar) {
            super(3);
            this.utY = hVar;
            this.utX = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(h.b bVar, View view, Integer num) {
            AppMethodBeat.i(246986);
            h.b bVar2 = bVar;
            View view2 = view;
            int intValue = num.intValue();
            kotlin.g.b.p.h(bVar2, "holder");
            kotlin.g.b.p.h(view2, "itemView");
            if (this.utX.utT[0] == 0 || this.utX.utT[1] == 0) {
                g gVar = bf.utW;
                Log.i(bf.TAG, "onItemLongClickCallback before change x:" + this.utX.utT[0] + ", original y:" + this.utX.utT[1]);
                view2.getLocationOnScreen(this.utX.utT);
                g gVar2 = bf.utW;
                Log.i(bf.TAG, "onItemLongClickCallback after change x:" + this.utX.utT[0] + ", original y:" + this.utX.utT[1]);
            }
            com.tencent.mm.plugin.finder.live.view.adapter.h hVar = this.utY;
            int i2 = this.utX.utT[0];
            int i3 = this.utX.utT[1];
            kotlin.g.b.p.h(bVar2, "holder");
            kotlin.g.b.p.h(view2, "itemView");
            bo awN = hVar.awN(intValue);
            if (awN instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
                StringBuilder append = new StringBuilder("show popup menu,pos:").append(intValue).append(",desc:");
                TextView textView = bVar2.uBM;
                kotlin.g.b.p.g(textView, "holder.productDesc");
                Log.i("Finder.LiveShoppingListAdapter", append.append(textView.getText()).append(",anchorPosX:").append(i2).append(",anchorPosY:").append(i3).toString());
                hVar.pqr.gNq();
                hVar.pqr.a(view2, new h.View$OnCreateContextMenuListenerC1199h(hVar), new h.i(hVar, bVar2, intValue, awN), i2, i3);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246986);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "productId", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$6"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.b<Long, kotlin.x> {
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(bf bfVar) {
            super(1);
            this.utX = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Long l) {
            AppMethodBeat.i(246987);
            long longValue = l.longValue();
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                finderLiveAssistant.EH(longValue);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246987);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "gotoHalfScreen", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke"})
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.m<Boolean, com.tencent.mm.plugin.appbrand.api.g, kotlin.x> {
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(bf bfVar) {
            super(2);
            this.utX = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Boolean bool, com.tencent.mm.plugin.appbrand.api.g gVar) {
            AppMethodBeat.i(246989);
            boolean booleanValue = bool.booleanValue();
            com.tencent.mm.plugin.appbrand.api.g gVar2 = gVar;
            if (gVar2 != null) {
                com.tencent.mm.plugin.finder.live.g gVar3 = com.tencent.mm.plugin.finder.live.g.ufT;
                com.tencent.mm.plugin.finder.live.g.c(gVar2);
                if (booleanValue) {
                    bf.a(this.utX, gVar2);
                } else {
                    bf.b(this.utX, gVar2);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246989);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "success", "", "invoke"})
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(bf bfVar) {
            super(1);
            this.utX = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(246990);
            boolean booleanValue = bool.booleanValue();
            bf.f(this.utX);
            this.utX.unJ = false;
            bf.a(this.utX, booleanValue);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246990);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "gotoHalfScreen", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.m<Boolean, com.tencent.mm.plugin.appbrand.api.g, kotlin.x> {
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(bf bfVar) {
            super(2);
            this.utX = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Boolean bool, com.tencent.mm.plugin.appbrand.api.g gVar) {
            AppMethodBeat.i(246991);
            boolean booleanValue = bool.booleanValue();
            com.tencent.mm.plugin.appbrand.api.g gVar2 = gVar;
            if (gVar2 != null) {
                com.tencent.mm.plugin.finder.live.g gVar3 = com.tencent.mm.plugin.finder.live.g.ufT;
                com.tencent.mm.plugin.finder.live.g.c(gVar2);
                if (booleanValue) {
                    bf.a(this.utX, gVar2);
                } else {
                    bf.b(this.utX, gVar2);
                }
                if (this.utX.hOp.getLiveRole() == 0) {
                    com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.au.CommerceActionGoodsOrderButtonClick, gVar2.dCw, (String) null);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246991);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "isShow", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$2$1"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(bf bfVar) {
            super(1);
            this.utX = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(246998);
            if (!bool.booleanValue()) {
                bf.b(this.utX);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246998);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "isShow", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$2$1"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ bf utX;
        final /* synthetic */ int utZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(bf bfVar, int i2) {
            super(1);
            this.utX = bfVar;
            this.utZ = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(247003);
            if (!bool.booleanValue()) {
                bf.b(this.utX);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(247003);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bf(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        kotlin.g.b.p.h(viewGroup, "root");
        kotlin.g.b.p.h(bVar, "statusMonitor");
        AppMethodBeat.i(247031);
        this.hOp = bVar;
        Context context = viewGroup.getContext();
        kotlin.g.b.p.g(context, "root.context");
        this.utO = new com.tencent.mm.plugin.finder.live.view.adapter.h(context, this.hOp, getLiveData());
        com.tencent.mm.plugin.finder.live.view.adapter.h hVar = this.utO;
        hVar.uBB = new a(this);
        hVar.uBC = new b(this);
        hVar.uBD = new c(this);
        hVar.uBE = new d(this);
        hVar.uBF = new e(hVar, this);
        hVar.uBG = new f(this);
        View findViewById = this.hwr.findViewById(R.id.cxr);
        kotlin.g.b.p.g(findViewById, "root.findViewById(R.id.finder_live_shopping_mask)");
        this.maskView = findViewById;
        View findViewById2 = this.hwr.findViewById(R.id.d3n);
        kotlin.g.b.p.g(findViewById2, "root.findViewById(R.id.f…shopping_list_blank_area)");
        this.hRx = findViewById2;
        View findViewById3 = this.hwr.findViewById(R.id.d3o);
        kotlin.g.b.p.g(findViewById3, "root.findViewById(R.id.f…opping_list_content_area)");
        this.utI = (FinderLiveShoppingPanel) findViewById3;
        View findViewById4 = this.hwr.findViewById(R.id.cxq);
        kotlin.g.b.p.g(findViewById4, "root.findViewById(R.id.f…hopping_list_title_group)");
        this.hRR = findViewById4;
        View view = this.hRR;
        if (view == null) {
            kotlin.g.b.p.btv("titleGroup");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        this.utH = layoutParams != null ? layoutParams.height : 0;
        if (this.utH <= 0) {
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            this.utH = context2.getResources().getDimensionPixelOffset(R.dimen.cr);
        }
        Log.i(TAG, "initTitleGroupHeight:" + this.utH);
        View findViewById5 = this.hwr.findViewById(R.id.cxg);
        kotlin.g.b.p.g(findViewById5, "root.findViewById(R.id.f…live_shopping_list_close)");
        this.utJ = (ImageView) findViewById5;
        View findViewById6 = this.hwr.findViewById(R.id.cxm);
        kotlin.g.b.p.g(findViewById6, "root.findViewById(R.id.f…live_shopping_list_order)");
        this.utK = (TextView) findViewById6;
        View findViewById7 = this.hwr.findViewById(R.id.cxh);
        kotlin.g.b.p.g(findViewById7, "root.findViewById(R.id.f…ve_shopping_list_content)");
        this.utL = (RecyclerView) findViewById7;
        View findViewById8 = this.hwr.findViewById(R.id.cxl);
        kotlin.g.b.p.g(findViewById8, "root.findViewById(R.id.f…ve_shopping_list_loading)");
        this.hRO = (ProgressBar) findViewById8;
        View findViewById9 = this.hwr.findViewById(R.id.cxn);
        kotlin.g.b.p.g(findViewById9, "root.findViewById(R.id.f…_shopping_list_retry_tip)");
        this.hRL = (TextView) findViewById9;
        View findViewById10 = this.hwr.findViewById(R.id.cxj);
        kotlin.g.b.p.g(findViewById10, "root.findViewById(R.id.f…hopping_list_empty_group)");
        this.ush = findViewById10;
        View findViewById11 = this.hwr.findViewById(R.id.cxi);
        kotlin.g.b.p.g(findViewById11, "root.findViewById(R.id.f…opping_list_empty_action)");
        this.utM = (TextView) findViewById11;
        View findViewById12 = this.hwr.findViewById(R.id.cxf);
        kotlin.g.b.p.g(findViewById12, "root.findViewById(R.id.f…der_live_shopping_footer)");
        this.qdl = findViewById12;
        View view2 = this.qdl;
        if (view2 == null) {
            kotlin.g.b.p.btv("footer");
        }
        View findViewById13 = view2.findViewById(R.id.ep1);
        kotlin.g.b.p.g(findViewById13, "footer.findViewById(R.id.load_more_footer_tip_tv)");
        this.unG = (TextView) findViewById13;
        View findViewById14 = this.hwr.findViewById(R.id.cxp);
        kotlin.g.b.p.g(findViewById14, "root.findViewById(R.id.f…live_shopping_list_title)");
        this.utN = (TextView) findViewById14;
        if (isLandscape()) {
            RecyclerView recyclerView = this.utL;
            if (recyclerView == null) {
                kotlin.g.b.p.btv("shoppingList");
            }
            this.hwr.getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager(1, false));
            recyclerView.setAdapter(this.utO);
            recyclerView.a(new m(this));
            recyclerView.a(new n(this));
            recyclerView.getLayoutParams().height = au.az(this.hwr.getContext()).y - this.utH;
            Log.i(TAG, "shoppingList height:" + recyclerView.getLayoutParams().height);
            FinderLiveShoppingPanel finderLiveShoppingPanel = this.utI;
            if (finderLiveShoppingPanel == null) {
                kotlin.g.b.p.btv("contentGroup");
            }
            finderLiveShoppingPanel.setTranslationX((float) au.az(this.hwr.getContext()).y);
            finderLiveShoppingPanel.setOnVisibilityListener(new o(this));
            FinderLiveShoppingPanel finderLiveShoppingPanel2 = this.utI;
            if (finderLiveShoppingPanel2 == null) {
                kotlin.g.b.p.btv("contentGroup");
            }
            ViewGroup.LayoutParams layoutParams2 = finderLiveShoppingPanel2.getLayoutParams();
            if (layoutParams2 == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                AppMethodBeat.o(247031);
                throw tVar;
            }
            ((ConstraintLayout.LayoutParams) layoutParams2).width = au.az(this.hwr.getContext()).y;
            TextView textView = this.utN;
            if (textView == null) {
                kotlin.g.b.p.btv("productsTitle");
            }
            ao.a(textView.getPaint(), 0.8f);
            View view3 = this.hRx;
            if (view3 == null) {
                kotlin.g.b.p.btv("blankArea");
            }
            view3.setOnClickListener(this);
            ImageView imageView = this.utJ;
            if (imageView == null) {
                kotlin.g.b.p.btv("close");
            }
            imageView.setOnClickListener(this);
            TextView textView2 = this.utK;
            if (textView2 == null) {
                kotlin.g.b.p.btv("order");
            }
            textView2.setOnClickListener(this);
            TextView textView3 = this.hRL;
            if (textView3 == null) {
                kotlin.g.b.p.btv("retryTip");
            }
            textView3.setOnClickListener(this);
            TextView textView4 = this.utM;
            if (textView4 == null) {
                kotlin.g.b.p.btv("emptyAction");
            }
            textView4.setOnClickListener(this);
            AppMethodBeat.o(247031);
            return;
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int duX = (int) (((float) au.az(MMApplicationContext.getContext()).y) * (((float) com.tencent.mm.plugin.finder.storage.c.duX()) / 100.0f));
        RecyclerView recyclerView2 = this.utL;
        if (recyclerView2 == null) {
            kotlin.g.b.p.btv("shoppingList");
        }
        this.hwr.getContext();
        recyclerView2.setLayoutManager(new LinearLayoutManager(1, false));
        recyclerView2.setAdapter(this.utO);
        recyclerView2.a(new p(this, duX));
        recyclerView2.a(new q(this, duX));
        recyclerView2.getLayoutParams().height = duX - this.utH;
        Log.i(TAG, "shoppingList height:" + recyclerView2.getLayoutParams().height);
        FinderLiveShoppingPanel finderLiveShoppingPanel3 = this.utI;
        if (finderLiveShoppingPanel3 == null) {
            kotlin.g.b.p.btv("contentGroup");
        }
        finderLiveShoppingPanel3.setTranslationY((float) au.az(this.hwr.getContext()).y);
        finderLiveShoppingPanel3.setOnVisibilityListener(new r(this, duX));
        finderLiveShoppingPanel3.getLayoutParams().height = duX;
        Log.i(finderLiveShoppingPanel3.getTAG(), "contentGroup height:" + finderLiveShoppingPanel3.getLayoutParams().height);
        TextView textView5 = this.utN;
        if (textView5 == null) {
            kotlin.g.b.p.btv("productsTitle");
        }
        ao.a(textView5.getPaint(), 0.8f);
        View view4 = this.hRx;
        if (view4 == null) {
            kotlin.g.b.p.btv("blankArea");
        }
        view4.setOnClickListener(this);
        ImageView imageView2 = this.utJ;
        if (imageView2 == null) {
            kotlin.g.b.p.btv("close");
        }
        imageView2.setOnClickListener(this);
        TextView textView6 = this.utK;
        if (textView6 == null) {
            kotlin.g.b.p.btv("order");
        }
        textView6.setOnClickListener(this);
        TextView textView7 = this.hRL;
        if (textView7 == null) {
            kotlin.g.b.p.btv("retryTip");
        }
        textView7.setOnClickListener(this);
        TextView textView8 = this.utM;
        if (textView8 == null) {
            kotlin.g.b.p.btv("emptyAction");
        }
        textView8.setOnClickListener(this);
        AppMethodBeat.o(247031);
    }

    public static final /* synthetic */ View c(bf bfVar) {
        AppMethodBeat.i(247035);
        View view = bfVar.qdl;
        if (view == null) {
            kotlin.g.b.p.btv("footer");
        }
        AppMethodBeat.o(247035);
        return view;
    }

    public static final /* synthetic */ void c(bf bfVar, com.tencent.mm.plugin.appbrand.api.g gVar) {
        AppMethodBeat.i(247051);
        bfVar.e(gVar);
        AppMethodBeat.o(247051);
    }

    public static final /* synthetic */ TextView d(bf bfVar) {
        AppMethodBeat.i(247036);
        TextView textView = bfVar.unG;
        if (textView == null) {
            kotlin.g.b.p.btv("footerTv");
        }
        AppMethodBeat.o(247036);
        return textView;
    }

    public static final /* synthetic */ void d(bf bfVar, com.tencent.mm.plugin.appbrand.api.g gVar) {
        AppMethodBeat.i(247052);
        bfVar.f(gVar);
        AppMethodBeat.o(247052);
    }

    public static final /* synthetic */ void f(bf bfVar) {
        AppMethodBeat.i(247037);
        bfVar.Jk(8);
        AppMethodBeat.o(247037);
    }

    public static final /* synthetic */ FinderLiveShoppingPanel i(bf bfVar) {
        AppMethodBeat.i(247039);
        FinderLiveShoppingPanel finderLiveShoppingPanel = bfVar.utI;
        if (finderLiveShoppingPanel == null) {
            kotlin.g.b.p.btv("contentGroup");
        }
        AppMethodBeat.o(247039);
        return finderLiveShoppingPanel;
    }

    public static final /* synthetic */ TextView l(bf bfVar) {
        AppMethodBeat.i(247044);
        TextView textView = bfVar.hRL;
        if (textView == null) {
            kotlin.g.b.p.btv("retryTip");
        }
        AppMethodBeat.o(247044);
        return textView;
    }

    public static final /* synthetic */ ProgressBar m(bf bfVar) {
        AppMethodBeat.i(247045);
        ProgressBar progressBar = bfVar.hRO;
        if (progressBar == null) {
            kotlin.g.b.p.btv("loadingBar");
        }
        AppMethodBeat.o(247045);
        return progressBar;
    }

    public static final /* synthetic */ View n(bf bfVar) {
        AppMethodBeat.i(247046);
        View view = bfVar.hRR;
        if (view == null) {
            kotlin.g.b.p.btv("titleGroup");
        }
        AppMethodBeat.o(247046);
        return view;
    }

    public static final /* synthetic */ RecyclerView o(bf bfVar) {
        AppMethodBeat.i(247047);
        RecyclerView recyclerView = bfVar.utL;
        if (recyclerView == null) {
            kotlin.g.b.p.btv("shoppingList");
        }
        AppMethodBeat.o(247047);
        return recyclerView;
    }

    public static final /* synthetic */ View p(bf bfVar) {
        AppMethodBeat.i(247048);
        View view = bfVar.ush;
        if (view == null) {
            kotlin.g.b.p.btv("emptyGroup");
        }
        AppMethodBeat.o(247048);
        return view;
    }

    public static final /* synthetic */ void s(bf bfVar) {
        AppMethodBeat.i(247053);
        bfVar.dhN();
        AppMethodBeat.o(247053);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$Companion;", "", "()V", "LOAD_MORE_THRESHOLD", "", "NOTIFY_VISITOR_SHOPPING_THRESHOLD", bf.utU, "", "getPORTRAIT_ACTION_FULL_SCREEN_MINIPRO", "()Ljava/lang/String;", bf.utV, "getPORTRAIT_ACTION_HALF_SCREEN_MINIPRO", "TAG", "getTAG", "plugin-finder_release"})
    public static final class g {
        private g() {
        }

        public /* synthetic */ g(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(247032);
        AppMethodBeat.o(247032);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$1$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
    public static final class m extends RecyclerView.l {
        final /* synthetic */ bf utX;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(246995);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(246995);
        }

        m(bf bfVar) {
            this.utX = bfVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(246994);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(246994);
                throw tVar;
            }
            bf.a(this.utX, ((LinearLayoutManager) layoutManager).kv());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(246994);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$1$2", "Landroid/support/v7/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroid/support/v7/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-finder_release"})
    public static final class n implements RecyclerView.k {
        final /* synthetic */ bf utX;

        n(bf bfVar) {
            this.utX = bfVar;
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final void b(RecyclerView recyclerView, MotionEvent motionEvent) {
            AppMethodBeat.i(246996);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "p0");
            kotlin.g.b.p.h(motionEvent, "p1");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(246996);
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            AppMethodBeat.i(246997);
            kotlin.g.b.p.h(recyclerView, "rv");
            kotlin.g.b.p.h(motionEvent, "motionEvent");
            this.utX.utT[0] = (int) motionEvent.getRawX();
            this.utX.utT[1] = (int) motionEvent.getRawY();
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (com.tencent.mm.plugin.finder.utils.y.dCM()) {
                g gVar = bf.utW;
                Log.i(bf.TAG, "recyclerView, onTouchEvent() (%s, %s)", Integer.valueOf(this.utX.utT[0]), Integer.valueOf(this.utX.utT[1]));
            }
            AppMethodBeat.o(246997);
            return false;
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final void ah(boolean z) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$1$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
    public static final class p extends RecyclerView.l {
        final /* synthetic */ bf utX;
        final /* synthetic */ int utZ;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(247000);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(247000);
        }

        p(bf bfVar, int i2) {
            this.utX = bfVar;
            this.utZ = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(246999);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(246999);
                throw tVar;
            }
            bf.a(this.utX, ((LinearLayoutManager) layoutManager).kv());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(246999);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$1$2", "Landroid/support/v7/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroid/support/v7/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-finder_release"})
    public static final class q implements RecyclerView.k {
        final /* synthetic */ bf utX;
        final /* synthetic */ int utZ;

        q(bf bfVar, int i2) {
            this.utX = bfVar;
            this.utZ = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final void b(RecyclerView recyclerView, MotionEvent motionEvent) {
            AppMethodBeat.i(247001);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "p0");
            kotlin.g.b.p.h(motionEvent, "p1");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(247001);
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            AppMethodBeat.i(247002);
            kotlin.g.b.p.h(recyclerView, "rv");
            kotlin.g.b.p.h(motionEvent, "motionEvent");
            this.utX.utT[0] = (int) motionEvent.getRawX();
            this.utX.utT[1] = (int) motionEvent.getRawY();
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (com.tencent.mm.plugin.finder.utils.y.dCM()) {
                g gVar = bf.utW;
                Log.i(bf.TAG, "recyclerView, onTouchEvent() (%s, %s)", Integer.valueOf(this.utX.utT[0]), Integer.valueOf(this.utX.utT[1]));
            }
            AppMethodBeat.o(247002);
            return false;
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final void ah(boolean z) {
        }
    }

    private final void Jk(int i2) {
        AppMethodBeat.i(247016);
        com.tencent.mm.ac.d.h(new y(this, i2));
        AppMethodBeat.o(247016);
    }

    private final void dhM() {
        AppMethodBeat.i(247017);
        if (this.utP == null) {
            View view = this.maskView;
            if (view == null) {
                kotlin.g.b.p.btv("maskView");
            }
            this.utP = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        }
        ObjectAnimator objectAnimator = this.utP;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.utP;
        if (objectAnimator2 != null) {
            objectAnimator2.start();
            AppMethodBeat.o(247017);
            return;
        }
        AppMethodBeat.o(247017);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$hideMaskView$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class k implements Animator.AnimatorListener {
        final /* synthetic */ bf utX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(bf bfVar) {
            this.utX = bfVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(246992);
            b.C0376b.a(this.utX.hOp, b.c.hNa);
            AppMethodBeat.o(246992);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void onNewIntent(Intent intent) {
        boolean z2 = false;
        AppMethodBeat.i(247019);
        if (intent != null) {
            z2 = intent.getBooleanExtra("extra_start_by_half_screen_empty_area_click_scene", false);
        }
        Log.i(TAG, "clickEmptyAreaClose = ".concat(String.valueOf(z2)));
        if (z2) {
            dhN();
        }
        AppMethodBeat.o(247019);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(247020);
        kotlin.g.b.p.h(cVar, "status");
        switch (bg.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                getLiveData().djd();
                rg(8);
                AppMethodBeat.o(247020);
                return;
            case 3:
                com.tencent.mm.ac.d.h(new ac(this));
                AppMethodBeat.o(247020);
                return;
            case 4:
                Log.i(TAG, "refresh shop page,view visibility:" + this.hwr.getVisibility());
                if (this.hwr.getVisibility() == 0) {
                    c((Bundle) null, true);
                    break;
                }
                break;
        }
        AppMethodBeat.o(247020);
    }

    private final void dhN() {
        AppMethodBeat.i(247021);
        Log.i(TAG, "hideShoppingContent:" + Util.getStack());
        FinderLiveShoppingPanel finderLiveShoppingPanel = this.utI;
        if (finderLiveShoppingPanel == null) {
            kotlin.g.b.p.btv("contentGroup");
        }
        finderLiveShoppingPanel.post(new l(this));
        AppMethodBeat.o(247021);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class l implements Runnable {
        final /* synthetic */ bf utX;

        l(bf bfVar) {
            this.utX = bfVar;
        }

        public final void run() {
            AppMethodBeat.i(246993);
            bf.i(this.utX).hide();
            AppMethodBeat.o(246993);
        }
    }

    public static /* synthetic */ void a(bf bfVar, Bundle bundle) {
        AppMethodBeat.i(247023);
        bfVar.c(bundle, false);
        AppMethodBeat.o(247023);
    }

    private void c(Bundle bundle, boolean z2) {
        AppMethodBeat.i(247022);
        Log.i(TAG, "showShoppingContent is refresh:".concat(String.valueOf(z2)));
        com.tencent.mm.plugin.finder.live.h.ufY.a(getLiveData());
        rg(0);
        dhO();
        getLiveData().djd();
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            s.a.a(finderLiveAssistant, getLiveData().liveInfo.liveId, getLiveData().hFK, new aa(this, bundle));
            AppMethodBeat.o(247022);
            return;
        }
        AppMethodBeat.o(247022);
    }

    private final void dhO() {
        AppMethodBeat.i(247024);
        ProgressBar progressBar = this.hRO;
        if (progressBar == null) {
            kotlin.g.b.p.btv("loadingBar");
        }
        progressBar.setVisibility(0);
        TextView textView = this.hRL;
        if (textView == null) {
            kotlin.g.b.p.btv("retryTip");
        }
        textView.setVisibility(8);
        View view = this.ush;
        if (view == null) {
            kotlin.g.b.p.btv("emptyGroup");
        }
        view.setVisibility(8);
        View view2 = this.hRR;
        if (view2 == null) {
            kotlin.g.b.p.btv("titleGroup");
        }
        view2.setVisibility(8);
        RecyclerView recyclerView = this.utL;
        if (recyclerView == null) {
            kotlin.g.b.p.btv("shoppingList");
        }
        recyclerView.setVisibility(8);
        Jk(8);
        FinderLiveShoppingPanel finderLiveShoppingPanel = this.utI;
        if (finderLiveShoppingPanel == null) {
            kotlin.g.b.p.btv("contentGroup");
        }
        finderLiveShoppingPanel.post(new ab(this));
        dhM();
        AppMethodBeat.o(247024);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class ab implements Runnable {
        final /* synthetic */ bf utX;

        ab(bf bfVar) {
            this.utX = bfVar;
        }

        public final void run() {
            AppMethodBeat.i(247014);
            bf.i(this.utX).show();
            AppMethodBeat.o(247014);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$showProductList$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
    public static final class z implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ bf utX;

        z(bf bfVar, int i2) {
            this.utX = bfVar;
            this.gUj = i2;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(247012);
            bf.o(this.utX).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            RecyclerView.LayoutManager layoutManager = bf.o(this.utX).getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                linearLayoutManager.ah(this.gUj, 0);
            }
            g gVar = bf.utW;
            Log.i(bf.TAG, "showProductList size:" + this.utX.utO.ppH.size() + ",scrollToPosition:" + this.gUj);
            AppMethodBeat.o(247012);
        }
    }

    public final void dhP() {
        AppMethodBeat.i(247025);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (!com.tencent.mm.plugin.finder.utils.m.dBP() || this.utS) {
            AppMethodBeat.o(247025);
        } else if (getLiveData().liveInfo.liveId == 0) {
            AppMethodBeat.o(247025);
        } else {
            Log.i(TAG, "has notify visitor shopping:" + this.utS);
            this.utR++;
            if (this.utR >= 3) {
                this.utR = 0;
                AppMethodBeat.o(247025);
                return;
            }
            int i2 = getLiveData().uDA | 16;
            long j2 = getLiveData().liveInfo.liveId;
            long j3 = getLiveData().hFK;
            String aUg = com.tencent.mm.model.z.aUg();
            kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
            new com.tencent.mm.plugin.finder.cgi.s(j2, j3, i2, aUg, 2, new s(this)).aYI();
            AppMethodBeat.o(247025);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$notifyVisitorShopping$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "plugin-finder_release"})
    public static final class s implements s.a {
        final /* synthetic */ bf utX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        s(bf bfVar) {
            this.utX = bfVar;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.s.a
        public final void onSuccess(int i2) {
            AppMethodBeat.i(247004);
            this.utX.utS = true;
            g gVar = bf.utW;
            Log.i(bf.TAG, "notify visitor shopping success times:" + this.utX.utR);
            AppMethodBeat.o(247004);
        }

        @Override // com.tencent.mm.plugin.finder.cgi.s.a
        public final void b(int i2, int i3, String str, int i4) {
            AppMethodBeat.i(247005);
            g gVar = bf.utW;
            Log.i(bf.TAG, "notify visitor shopping fail times:" + this.utX.utR);
            this.utX.dhP();
            AppMethodBeat.o(247005);
        }
    }

    private final void dhQ() {
        String str;
        String str2;
        String str3;
        bo boVar;
        awe awe;
        awc awc;
        String str4 = null;
        AppMethodBeat.i(247026);
        String str5 = TAG;
        StringBuilder sb = new StringBuilder("add product appId:");
        awc awc2 = getLiveData().uEl;
        if (awc2 != null) {
            str = awc2.LGD;
        } else {
            str = null;
        }
        StringBuilder append = sb.append(str).append(",path:");
        awc awc3 = getLiveData().uEl;
        if (awc3 != null) {
            str2 = awc3.LGB;
        } else {
            str2 = null;
        }
        Log.i(str5, append.append(str2).toString());
        com.tencent.mm.plugin.finder.live.g gVar = com.tencent.mm.plugin.finder.live.g.ufT;
        com.tencent.mm.plugin.finder.live.g.b(getLiveData(), new h(this));
        if (this.hOp.getLiveRole() == 1) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", s.aa.LIVE_ADD_GOODS.action);
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            jSONObject.put("sessionid", com.tencent.mm.plugin.finder.report.live.k.dpl().vlJ);
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            if (dfZ == null || (awc = dfZ.uEl) == null || (str3 = awc.vtD) == null) {
                str3 = "";
            }
            jSONObject.put("shopwindowid", str3);
            com.tencent.mm.plugin.finder.live.model.o oVar2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            if (dfZ2 == null || !dfZ2.djk()) {
                com.tencent.mm.plugin.finder.live.model.o oVar3 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ3 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                if (dfZ3 == null) {
                    AppMethodBeat.o(247026);
                    return;
                } else if (dfZ3.isLiveStarted()) {
                    com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.dpl().vmo = true;
                    com.tencent.mm.plugin.finder.live.model.o oVar4 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ4 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                    if (dfZ4 != null) {
                        str4 = dfZ4.uEq;
                    }
                    jSONObject.put("appid", str4);
                    com.tencent.mm.plugin.finder.live.model.o oVar5 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ5 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                    long j2 = (dfZ5 == null || (awe = dfZ5.liveInfo) == null) ? -1 : awe.liveId;
                    if (j2 < 0) {
                        jSONObject.put("liveid", "");
                    } else {
                        jSONObject.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.zs(j2));
                    }
                    c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                    jSONObject.put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEB);
                    c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                    c.a.apD("");
                    com.tencent.mm.plugin.finder.live.model.o oVar6 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ6 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                    jSONObject.put("productid", (dfZ6 == null || (boVar = dfZ6.UPW) == null) ? "" : Long.valueOf(boVar.lT()));
                    com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_COMMERCE, jSONObject.toString());
                }
            } else {
                com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_COMMERCE.hlf, jSONObject.toString());
                AppMethodBeat.o(247026);
                return;
            }
        }
        AppMethodBeat.o(247026);
    }

    public final void onClick(View view) {
        String str;
        String str2 = null;
        AppMethodBeat.i(247027);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if ((valueOf != null && valueOf.intValue() == R.id.cxg) || (valueOf != null && valueOf.intValue() == R.id.d3n)) {
            dhN();
        } else if (valueOf != null && valueOf.intValue() == R.id.cxm) {
            b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
            if (b.a.aDp()) {
                String str3 = TAG;
                StringBuilder sb = new StringBuilder("gotoShoppingOrder appId:");
                awc awc = getLiveData().uEl;
                if (awc != null) {
                    str = awc.LGE;
                } else {
                    str = null;
                }
                StringBuilder append = sb.append(str).append(",path:");
                awc awc2 = getLiveData().uEl;
                if (awc2 != null) {
                    str2 = awc2.LGA;
                }
                Log.i(str3, append.append(str2).toString());
                com.tencent.mm.plugin.finder.live.g gVar = com.tencent.mm.plugin.finder.live.g.ufT;
                com.tencent.mm.plugin.finder.live.g.a(getLiveData(), new j(this));
            } else {
                dhQ();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.cxn) {
            c((Bundle) null, true);
        } else if (valueOf != null && valueOf.intValue() == R.id.cxi) {
            dhQ();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247027);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void a(Bundle bundle, Object obj, long j2) {
        String str;
        AppMethodBeat.i(260720);
        if (bundle == null || (str = bundle.getString("ACTION_POST_PORTRAIT", "")) == null) {
            str = "";
        }
        if (kotlin.g.b.p.j(str, utU)) {
            com.tencent.mm.ac.d.a(j2, new w(this, obj, j2));
            AppMethodBeat.o(260720);
            return;
        }
        if (kotlin.g.b.p.j(str, utV)) {
            com.tencent.mm.ac.d.a(j2, new x(this, obj, j2));
        }
        AppMethodBeat.o(260720);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class w implements Runnable {
        final /* synthetic */ Object ULH;
        final /* synthetic */ long utG;
        final /* synthetic */ bf utX;

        w(bf bfVar, Object obj, long j2) {
            this.utX = bfVar;
            this.ULH = obj;
            this.utG = j2;
        }

        public final void run() {
            AppMethodBeat.i(247009);
            if (!this.utX.isFinished()) {
                Object obj = this.ULH;
                if (!(obj instanceof com.tencent.mm.plugin.appbrand.api.g)) {
                    obj = null;
                }
                if (((com.tencent.mm.plugin.appbrand.api.g) obj) != null) {
                    bf.c(this.utX, (com.tencent.mm.plugin.appbrand.api.g) this.ULH);
                    AppMethodBeat.o(247009);
                    return;
                }
                AppMethodBeat.o(247009);
                return;
            }
            g gVar = bf.utW;
            Log.i(bf.TAG, "openFullScreenMiniprogramImpl delayMs:" + this.utG + ",isFinished!");
            AppMethodBeat.o(247009);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class x implements Runnable {
        final /* synthetic */ Object ULH;
        final /* synthetic */ long utG;
        final /* synthetic */ bf utX;

        x(bf bfVar, Object obj, long j2) {
            this.utX = bfVar;
            this.ULH = obj;
            this.utG = j2;
        }

        public final void run() {
            AppMethodBeat.i(247010);
            if (!this.utX.isFinished()) {
                Object obj = this.ULH;
                if (!(obj instanceof com.tencent.mm.plugin.appbrand.api.g)) {
                    obj = null;
                }
                if (((com.tencent.mm.plugin.appbrand.api.g) obj) != null) {
                    bf.d(this.utX, (com.tencent.mm.plugin.appbrand.api.g) this.ULH);
                    AppMethodBeat.o(247010);
                    return;
                }
                AppMethodBeat.o(247010);
                return;
            }
            g gVar = bf.utW;
            Log.i(bf.TAG, "openHalfScreenMiniprogramImpl delayMs:" + this.utG + ",isFinished!");
            AppMethodBeat.o(247010);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(247018);
        if (this.hwr.getVisibility() == 0) {
            dhN();
            AppMethodBeat.o(247018);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(247018);
        return onBackPress;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class y extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ int uhP;
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(bf bfVar, int i2) {
            super(0);
            this.utX = bfVar;
            this.uhP = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(247011);
            bf.c(this.utX).setVisibility(this.uhP);
            bf.d(this.utX).setVisibility(this.uhP);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(247011);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class v extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ boolean $success;
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(bf bfVar, boolean z) {
            super(0);
            this.utX = bfVar;
            this.$success = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            LinkedList<bo> linkedList;
            AppMethodBeat.i(247008);
            g gVar = bf.utW;
            String str = bf.TAG;
            StringBuilder append = new StringBuilder("load more product finish,success:").append(this.$success).append(",product size:");
            LinkedList<bo> linkedList2 = this.utX.getLiveData().LGy;
            Log.i(str, append.append(linkedList2 != null ? Integer.valueOf(linkedList2.size()) : null).toString());
            if (this.$success && (linkedList = this.utX.getLiveData().LGy) != null) {
                this.utX.utO.ao(linkedList);
                this.utX.utO.notifyDataSetChanged();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(247008);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ac extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ac(bf bfVar) {
            super(0);
            this.utX = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            int i2;
            int i3 = 3;
            int i4 = 0;
            AppMethodBeat.i(247015);
            com.tencent.mm.plugin.finder.live.view.adapter.h hVar = this.utX.utO;
            bo boVar = this.utX.getLiveData().UPW;
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
                if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
                    Log.i("Finder.LiveShoppingListAdapter", "updatePromotingProduct,desc:" + ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).title + ",id:" + ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).uko + ",platformId:" + ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).LHO);
                    int itemCount = hVar.getItemCount();
                    if (itemCount >= 0) {
                        while (true) {
                            bo awN = hVar.awN(i4);
                            if (!(awN instanceof com.tencent.mm.plugin.finder.live.view.a.c) || ((com.tencent.mm.plugin.finder.live.view.a.c) awN).uko != ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).uko) {
                                if (i4 == itemCount) {
                                    break;
                                }
                                i4++;
                            } else {
                                if (((com.tencent.mm.plugin.finder.live.view.a.c) boVar).LHK == 1) {
                                    i2 = 3;
                                } else {
                                    i2 = 4;
                                }
                                hVar.b(i4, Integer.valueOf(i2));
                            }
                        }
                    }
                } else if (boVar instanceof fhd) {
                    Log.i("Finder.LiveShoppingListAdapter", "updatePromotingProduct,desc:" + ((fhd) boVar).title + ",id:" + ((fhd) boVar).UPE + ",platformId:" + ((fhd) boVar).UPH);
                    int itemCount2 = hVar.getItemCount();
                    if (itemCount2 >= 0) {
                        while (true) {
                            bo awN2 = hVar.awN(i4);
                            if (!(awN2 instanceof fhd) || ((fhd) awN2).UPE != ((fhd) boVar).UPE) {
                                if (i4 == itemCount2) {
                                    break;
                                }
                                i4++;
                            } else {
                                if (((fhd) boVar).LHK != 1) {
                                    i3 = 4;
                                }
                                hVar.b(i4, Integer.valueOf(i3));
                            }
                        }
                    }
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(247015);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class u extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ bf utX;
        final /* synthetic */ Bundle uua;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(bf bfVar, Bundle bundle) {
            super(0);
            this.utX = bfVar;
            this.uua = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            Integer num;
            AppMethodBeat.i(247007);
            if (this.utX.getLiveData().uEl == null) {
                new awc();
            }
            LinkedList<bo> linkedList = this.utX.getLiveData().LGy;
            if (linkedList == null || linkedList.isEmpty()) {
                bf.k(this.utX);
            } else {
                bf.a(this.utX, this.utX.getLiveData().LGy, this.uua);
                this.utX.dhP();
            }
            g gVar = bf.utW;
            String str = bf.TAG;
            StringBuilder sb = new StringBuilder("onGetShoppingListSuccess size:");
            LinkedList<bo> linkedList2 = this.utX.getLiveData().LGy;
            if (linkedList2 != null) {
                num = Integer.valueOf(linkedList2.size());
            } else {
                num = null;
            }
            Log.i(str, sb.append(num).toString());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(247007);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class t extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ bf utX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(bf bfVar) {
            super(0);
            this.utX = bfVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(247006);
            bf.l(this.utX).setVisibility(0);
            bf.m(this.utX).setVisibility(8);
            bf.n(this.utX).setVisibility(8);
            bf.o(this.utX).setVisibility(8);
            bf.p(this.utX).setVisibility(8);
            g gVar = bf.utW;
            Log.i(bf.TAG, "onGetShoppingListFail");
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(247006);
            return xVar;
        }
    }

    private final void e(com.tencent.mm.plugin.appbrand.api.g gVar) {
        AppMethodBeat.i(247028);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            ViewGroup viewGroup = this.hwr;
            Context context = viewGroup != null ? viewGroup.getContext() : null;
            kotlin.g.b.p.g(context, "root?.context");
            s.a.a(finderLiveAssistant, context, gVar);
            AppMethodBeat.o(247028);
            return;
        }
        AppMethodBeat.o(247028);
    }

    private final void f(com.tencent.mm.plugin.appbrand.api.g gVar) {
        AppMethodBeat.i(247029);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            ViewGroup viewGroup = this.hwr;
            Context context = viewGroup != null ? viewGroup.getContext() : null;
            kotlin.g.b.p.g(context, "root?.context");
            finderLiveAssistant.c(context, gVar);
            AppMethodBeat.o(247029);
            return;
        }
        AppMethodBeat.o(247029);
    }

    public static final /* synthetic */ void a(bf bfVar, int i2) {
        Integer num;
        com.tencent.mm.bw.b bVar = null;
        AppMethodBeat.i(247033);
        if (i2 >= 0 && i2 >= bfVar.utO.getItemCount() - 3) {
            awc awc = bfVar.getLiveData().uEl;
            if (awc == null || awc.continueFlag != 1 || bfVar.unJ) {
                awc awc2 = bfVar.getLiveData().uEl;
                if (awc2 == null || awc2.continueFlag != 1) {
                    bfVar.Jk(8);
                }
            } else {
                String str = TAG;
                StringBuilder sb = new StringBuilder("load more product,product size:");
                LinkedList<bo> linkedList = bfVar.getLiveData().LGy;
                if (linkedList != null) {
                    num = Integer.valueOf(linkedList.size());
                } else {
                    num = null;
                }
                Log.i(str, sb.append(num).toString());
                bfVar.unJ = true;
                bfVar.Jk(0);
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    long j2 = bfVar.getLiveData().liveInfo.liveId;
                    long j3 = bfVar.getLiveData().hFK;
                    awc awc3 = bfVar.getLiveData().uEl;
                    if (awc3 != null) {
                        bVar = awc3.tVM;
                    }
                    finderLiveAssistant.a(j2, j3, bVar, new i(bfVar));
                    AppMethodBeat.o(247033);
                    return;
                }
                AppMethodBeat.o(247033);
                return;
            }
        }
        AppMethodBeat.o(247033);
    }

    public static final /* synthetic */ void b(bf bfVar) {
        AppMethodBeat.i(247034);
        if (bfVar.utQ == null) {
            View view = bfVar.maskView;
            if (view == null) {
                kotlin.g.b.p.btv("maskView");
            }
            bfVar.utQ = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            ObjectAnimator objectAnimator = bfVar.utQ;
            if (objectAnimator != null) {
                objectAnimator.addListener(new k(bfVar));
            }
        }
        ObjectAnimator objectAnimator2 = bfVar.utQ;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = bfVar.utQ;
        if (objectAnimator3 != null) {
            objectAnimator3.start();
        }
        Log.printInfoStack(TAG, "hideMaskView", new Object[0]);
        AppMethodBeat.o(247034);
    }

    public static final /* synthetic */ void a(bf bfVar, boolean z2) {
        AppMethodBeat.i(247038);
        com.tencent.mm.ac.d.h(new v(bfVar, z2));
        AppMethodBeat.o(247038);
    }

    public static final /* synthetic */ void b(bf bfVar, Bundle bundle) {
        AppMethodBeat.i(247040);
        com.tencent.mm.ac.d.h(new u(bfVar, bundle));
        AppMethodBeat.o(247040);
    }

    public static final /* synthetic */ void j(bf bfVar) {
        AppMethodBeat.i(247041);
        com.tencent.mm.ac.d.h(new t(bfVar));
        AppMethodBeat.o(247041);
    }

    public static final /* synthetic */ void k(bf bfVar) {
        AppMethodBeat.i(247042);
        View view = bfVar.ush;
        if (view == null) {
            kotlin.g.b.p.btv("emptyGroup");
        }
        view.setVisibility(0);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            TextView textView = bfVar.utM;
            if (textView == null) {
                kotlin.g.b.p.btv("emptyAction");
            }
            textView.setVisibility(0);
        } else {
            TextView textView2 = bfVar.utM;
            if (textView2 == null) {
                kotlin.g.b.p.btv("emptyAction");
            }
            textView2.setVisibility(8);
        }
        ProgressBar progressBar = bfVar.hRO;
        if (progressBar == null) {
            kotlin.g.b.p.btv("loadingBar");
        }
        progressBar.setVisibility(8);
        View view2 = bfVar.hRR;
        if (view2 == null) {
            kotlin.g.b.p.btv("titleGroup");
        }
        view2.setVisibility(0);
        RecyclerView recyclerView = bfVar.utL;
        if (recyclerView == null) {
            kotlin.g.b.p.btv("shoppingList");
        }
        recyclerView.setVisibility(8);
        TextView textView3 = bfVar.utK;
        if (textView3 == null) {
            kotlin.g.b.p.btv("order");
        }
        b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
        textView3.setText(b.a.aDp() ? bfVar.hwr.getContext().getString(R.string.cz9) : "");
        TextView textView4 = bfVar.hRL;
        if (textView4 == null) {
            kotlin.g.b.p.btv("retryTip");
        }
        textView4.setVisibility(8);
        AppMethodBeat.o(247042);
    }

    public static final /* synthetic */ void a(bf bfVar, LinkedList linkedList, Bundle bundle) {
        int i2;
        boolean z2;
        AppMethodBeat.i(260721);
        View view = bfVar.ush;
        if (view == null) {
            kotlin.g.b.p.btv("emptyGroup");
        }
        view.setVisibility(8);
        ProgressBar progressBar = bfVar.hRO;
        if (progressBar == null) {
            kotlin.g.b.p.btv("loadingBar");
        }
        progressBar.setVisibility(8);
        View view2 = bfVar.hRR;
        if (view2 == null) {
            kotlin.g.b.p.btv("titleGroup");
        }
        view2.setVisibility(0);
        RecyclerView recyclerView = bfVar.utL;
        if (recyclerView == null) {
            kotlin.g.b.p.btv("shoppingList");
        }
        recyclerView.setVisibility(0);
        TextView textView = bfVar.hRL;
        if (textView == null) {
            kotlin.g.b.p.btv("retryTip");
        }
        textView.setVisibility(8);
        TextView textView2 = bfVar.utK;
        if (textView2 == null) {
            kotlin.g.b.p.btv("order");
        }
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        textView2.setText(com.tencent.mm.plugin.finder.utils.m.dBP() ? bfVar.hwr.getContext().getString(R.string.cz3) : bfVar.hwr.getContext().getString(R.string.cz9));
        bfVar.utO.ao(linkedList);
        bfVar.utO.notifyDataSetChanged();
        if (bundle != null && (bundle.containsKey("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID") || bundle.containsKey("PARAM_FINDER_LIVE_BUBBLE_ADID"))) {
            long j2 = bundle.getLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", 0);
            long j3 = bundle.getLong("PARAM_FINDER_LIVE_BUBBLE_ADID", 0);
            if (j2 != 0) {
                Iterator<bo> it = bfVar.utO.ppH.iterator();
                i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    bo next = it.next();
                    if ((next instanceof com.tencent.mm.plugin.finder.live.view.a.c) && ((com.tencent.mm.plugin.finder.live.view.a.c) next).uko != 0 && ((com.tencent.mm.plugin.finder.live.view.a.c) next).uko == j2) {
                        break;
                    }
                    i2++;
                }
            } else if (j3 != 0) {
                Iterator<bo> it2 = bfVar.utO.ppH.iterator();
                i2 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    bo next2 = it2.next();
                    if (!(next2 instanceof com.tencent.mm.plugin.finder.live.view.a.b) || ((com.tencent.mm.plugin.finder.live.view.a.b) next2).UPE == 0 || ((com.tencent.mm.plugin.finder.live.view.a.b) next2).UPE != j3) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        break;
                    }
                    i2++;
                }
            } else {
                i2 = -1;
            }
            if (i2 >= 0 && i2 < bfVar.utO.ppH.size()) {
                RecyclerView recyclerView2 = bfVar.utL;
                if (recyclerView2 == null) {
                    kotlin.g.b.p.btv("shoppingList");
                }
                recyclerView2.getViewTreeObserver().addOnGlobalLayoutListener(new z(bfVar, i2));
            }
        }
        AppMethodBeat.o(260721);
    }

    public static final /* synthetic */ void a(bf bfVar, com.tencent.mm.plugin.appbrand.api.g gVar) {
        AppMethodBeat.i(247049);
        boolean isLandscape = bfVar.isLandscape();
        Log.i(TAG, "openHalfScreenMiniprogram isLandscape:".concat(String.valueOf(isLandscape)));
        if (isLandscape) {
            d.a(bfVar, utV, gVar, 0, 4);
            AppMethodBeat.o(247049);
            return;
        }
        bfVar.f(gVar);
        AppMethodBeat.o(247049);
    }

    public static final /* synthetic */ void b(bf bfVar, com.tencent.mm.plugin.appbrand.api.g gVar) {
        AppMethodBeat.i(247050);
        boolean isLandscape = bfVar.isLandscape();
        Log.i(TAG, "openFullScreenMiniprogram isLandscape:".concat(String.valueOf(isLandscape)));
        if (isLandscape) {
            d.a(bfVar, utU, gVar, 0, 4);
            AppMethodBeat.o(247050);
            return;
        }
        bfVar.e(gVar);
        AppMethodBeat.o(247050);
    }
}
