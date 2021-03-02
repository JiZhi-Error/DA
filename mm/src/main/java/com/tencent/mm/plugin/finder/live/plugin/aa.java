package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGiftPanelIndicator;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGiftPreviewView;
import com.tencent.mm.plugin.finder.live.widget.o;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.plugin.wallet.wecoin.a.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.t;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 x2\u00020\u00012\u00020\u0002:\u0002xyB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010F\u001a\u000209H\u0016J\b\u0010G\u001a\u00020\u0015H\u0002J\u0012\u0010H\u001a\u0002092\b\u0010I\u001a\u0004\u0018\u00010\tH\u0002J,\u0010J\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u00142\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010M\u001a\u000209H\u0002J\u000e\u0010N\u001a\b\u0012\u0004\u0012\u00020P0OH\u0002J\b\u0010Q\u001a\u00020\u0015H\u0002J\u000e\u0010R\u001a\b\u0012\u0004\u0012\u00020S0OH\u0002J\b\u0010T\u001a\u00020\u0015H\u0002J\b\u0010U\u001a\u000209H\u0002J4\u0010V\u001a\u00020\u00152\"\u0010W\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020Y0Xj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020Y`Z2\u0006\u0010[\u001a\u000209H\u0016J\b\u0010\\\u001a\u000209H\u0016J\u0012\u0010]\u001a\u00020\u00152\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010_\u001a\u00020\u00152\u0006\u00103\u001a\u000202H\u0002J\b\u0010`\u001a\u00020\u0015H\u0002J\b\u0010a\u001a\u00020\u0015H\u0002J\u0010\u0010b\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u0014H\u0002J\u0010\u0010c\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0011H\u0002J\b\u0010d\u001a\u00020\u0015H\u0002J\b\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010f\u001a\u00020\u00152\u0006\u0010g\u001a\u00020)H\u0002J\u0012\u0010h\u001a\u00020\u00152\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0014J\b\u0010j\u001a\u00020\u0015H\u0002J\u001a\u0010k\u001a\u00020\u00152\b\u00101\u001a\u0004\u0018\u00010\t2\u0006\u00103\u001a\u000202H\u0002J\u001a\u0010l\u001a\u00020\u00152\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010pH\u0016J\b\u0010q\u001a\u00020\u0015H\u0016J\u0016\u0010r\u001a\u00020\u00152\f\u0010s\u001a\b\u0012\u0004\u0012\u00020P0OH\u0002J\u0017\u0010t\u001a\u00020\u00152\b\u0010g\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010uJ\u0010\u0010v\u001a\u0002092\u0006\u0010w\u001a\u000202H\u0002R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000Rv\u0010+\u001a^\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\t¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(1\u0012\u0013\u0012\u001102¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0015\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u000209X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010?\u001a\n A*\u0004\u0018\u00010@0@X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000¨\u0006z"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "anchorContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getAnchorContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "backBtn", "Landroid/widget/ImageView;", "blankArea", "Landroid/view/View;", "bottomSheetClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin$SendGiftTargetContact;", "", "chooseTargetSheet", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "chooseTargetSheetContainer", "Landroid/widget/LinearLayout;", "chooseTargetTitleAvatar", "chooseTargetTitleLayout", "chooseTargetTitleNickName", "Landroid/widget/TextView;", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "curGiftId", "curSelectedView", "giftPreviewView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftPreviewView;", "giftViewPager", "Landroid/support/v4/view/ViewPager;", "giftViewPagerAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftViewPagerAdapter;", "lastClickTime", "", "loadingGroup", "onGiftItemClick", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "view", "curThumbView", "giftId", "", "bottomMargin", "getOnGiftItemClick", "()Lkotlin/jvm/functions/Function4;", "setOnGiftItemClick", "(Lkotlin/jvm/functions/Function4;)V", "panelHiding", "", "panelIndicator", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftPanelIndicator;", "retryGroup", "sendGiftTargetContact", "titleTv", "vibrator", "", "kotlin.jvm.PlatformType", "wecoinDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "wecoinGroup", "wecoinTv", "canClearScreen", "checkGiftEnable", "checkIsSelf", "userName", "createBottomSheetItem", "contact", "clickListener", "isAnchor", "getCacheGiftList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftInfo;", "getGiftListFromCgi", "getValidLinkMicUserList", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "hideGiftListContent", "isFastClick", "onAudienceMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "onBackPress", "onClick", "v", "playPreviewAnimation", "refreshSendGiftTargetBottomSheet", "refreshSendGiftTargetTitleLayout", "refreshTargetContact", "removeViewFromParent", "restoreTargetContactToAnchor", "resume", "setBalance", "balance", "showGiftListContent", "target", "showGiftPage", "showPreviewGift", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateGiftPage", "giftCache", "updateWecoinBalance", "(Ljava/lang/Long;)V", "vibrateAndShowGiftAnimation", "clickCnt", "Companion", "SendGiftTargetContact", "plugin-finder_release"})
public final class aa extends d implements View.OnClickListener {
    private static final String ULP;
    private static final int upo = 8;
    private static final int upp = 6;
    private static final int upq = 500;
    private static final float upr = upr;
    public static final a ups = new a((byte) 0);
    private final String TAG = "Finder.FinderLiveGiftPanelPlugin";
    private final com.tencent.mm.plugin.finder.view.d ULI;
    private final LinearLayout ULJ;
    private final kotlin.g.a.b<l, x> ULK;
    private l ULL;
    private final LinearLayout ULM;
    private final ImageView ULN;
    private final TextView ULO;
    private final ImageView hNZ;
    private final com.tencent.mm.live.c.b hOp;
    private final Object hQn;
    private final View hRx;
    private final LiveBottomSheetPanel hRy;
    private long lastClickTime;
    private final TextView titleTv;
    private final ViewPager upb;
    private final TextView upc;
    private final View upd;
    private final com.tencent.mm.plugin.finder.live.view.adapter.e upe = new com.tencent.mm.plugin.finder.live.view.adapter.e();
    private ViewGroup upf;
    private final FinderLiveGiftPreviewView upg;
    private final TextView uph;
    private final View upi;
    private com.tencent.mm.plugin.wallet.wecoin.a.d upj;
    private volatile boolean upk;
    private FinderLiveGiftPanelIndicator upl;
    private String upm;
    private kotlin.g.a.r<? super ViewGroup, ? super View, ? super String, ? super Integer, x> upn;

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "succ", "", "errCode", "", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.m<Boolean, Integer, x> {
        final /* synthetic */ aa upt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(aa aaVar) {
            super(2);
            this.upt = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, Integer num) {
            AppMethodBeat.i(246629);
            final boolean booleanValue = bool.booleanValue();
            final int intValue = num.intValue();
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.aa.b.AnonymousClass1 */
                final /* synthetic */ b upu;

                {
                    this.upu = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(246628);
                    this.upu.upt.upd.setVisibility(8);
                    if (booleanValue) {
                        aa.a(this.upu.upt, aa.h(this.upu.upt));
                    } else {
                        this.upu.upt.upc.setVisibility(0);
                        Log.w(this.upu.upt.TAG, "getGiftListFromCgi fail,:" + intValue + '!');
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(246628);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(246629);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "viewGroup", "Landroid/view/ViewGroup;", "curThumbView", "Landroid/view/View;", "giftId", "", "bottomMargin", "", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.r<ViewGroup, View, String, Integer, x> {
        final /* synthetic */ aa upt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(aa aaVar) {
            super(4);
            this.upt = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(ViewGroup viewGroup, View view, String str, Integer num) {
            View findViewById;
            ViewPropertyAnimator animate;
            ViewPropertyAnimator alpha;
            ViewPropertyAnimator duration;
            View findViewById2;
            ViewPropertyAnimator animate2;
            ViewPropertyAnimator alpha2;
            ViewPropertyAnimator duration2;
            AppMethodBeat.i(246634);
            ViewGroup viewGroup2 = viewGroup;
            String str2 = str;
            num.intValue();
            kotlin.g.b.p.h(viewGroup2, "viewGroup");
            kotlin.g.b.p.h(view, "curThumbView");
            kotlin.g.b.p.h(str2, "giftId");
            Log.i(this.upt.TAG, "onGiftItemClick giftId:" + str2 + " click,panelHiding:" + this.upt.upk + '!');
            if (!this.upt.upk) {
                ViewGroup viewGroup3 = this.upt.upf;
                if (!(viewGroup3 == null || (findViewById2 = viewGroup3.findViewById(R.id.dk4)) == null || (animate2 = findViewById2.animate()) == null || (alpha2 = animate2.alpha(1.0f)) == null || (duration2 = alpha2.setDuration(100)) == null)) {
                    duration2.start();
                }
                this.upt.upf = viewGroup2;
                ViewGroup viewGroup4 = this.upt.upf;
                if (!(viewGroup4 == null || (findViewById = viewGroup4.findViewById(R.id.dk4)) == null || (animate = findViewById.animate()) == null || (alpha = animate.alpha(0.0f)) == null || (duration = alpha.setDuration(100)) == null)) {
                    duration.start();
                }
                aa.a(this.upt, str2);
                if (this.upt.hOp.getLiveRole() == 0) {
                    com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                    com.tencent.mm.plugin.finder.report.live.m.a(s.aw.CLICK_GIFT_BOARD_INNER_GITF, str2, 0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246634);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.b<Long, x> {
        final /* synthetic */ aa upt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(aa aaVar) {
            super(1);
            this.upt = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Long l) {
            AppMethodBeat.i(246639);
            aa.a(this.upt, l.longValue());
            x xVar = x.SXb;
            AppMethodBeat.o(246639);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    public static final class m<T, R> implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.o, Bitmap> {
        final /* synthetic */ ImageView ULQ;
        final /* synthetic */ aa upt;

        m(aa aaVar, ImageView imageView) {
            this.upt = aaVar;
            this.ULQ = imageView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<com.tencent.mm.plugin.finder.loader.o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(260608);
            final Bitmap bitmap2 = bitmap;
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.aa.m.AnonymousClass1 */
                final /* synthetic */ m ULR;

                {
                    this.ULR = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(260607);
                    if (bitmap2 != null) {
                        this.ULR.ULQ.setImageBitmap(bitmap2);
                    } else {
                        ImageView imageView = this.ULR.ULQ;
                        Context context = this.ULR.upt.ULN.getContext();
                        kotlin.g.b.p.g(context, "chooseTargetTitleAvatar.context");
                        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.bcd));
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(260607);
                    return xVar;
                }
            });
            AppMethodBeat.o(260608);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    public static final class n<T, R> implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.o, Bitmap> {
        final /* synthetic */ ImageView ULQ;
        final /* synthetic */ aa upt;

        n(aa aaVar, ImageView imageView) {
            this.upt = aaVar;
            this.ULQ = imageView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<com.tencent.mm.plugin.finder.loader.o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(260610);
            final Bitmap bitmap2 = bitmap;
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.aa.n.AnonymousClass1 */
                final /* synthetic */ n ULS;

                {
                    this.ULS = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(260609);
                    if (bitmap2 != null) {
                        this.ULS.ULQ.setImageBitmap(bitmap2);
                    } else {
                        ImageView imageView = this.ULS.ULQ;
                        Context context = this.ULS.upt.ULN.getContext();
                        kotlin.g.b.p.g(context, "chooseTargetTitleAvatar.context");
                        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.bcd));
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(260609);
                    return xVar;
                }
            });
            AppMethodBeat.o(260610);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    public static final class q<T, R> implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.o, Bitmap> {
        final /* synthetic */ aa upt;

        q(aa aaVar) {
            this.upt = aaVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<com.tencent.mm.plugin.finder.loader.o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(260614);
            final Bitmap bitmap2 = bitmap;
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.aa.q.AnonymousClass1 */
                final /* synthetic */ q ULV;

                {
                    this.ULV = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(260613);
                    if (bitmap2 != null) {
                        this.ULV.upt.ULN.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(bitmap2, false, ((float) bitmap2.getWidth()) / 2.0f));
                    } else {
                        ImageView imageView = this.ULV.upt.ULN;
                        Context context = this.ULV.upt.ULN.getContext();
                        kotlin.g.b.p.g(context, "chooseTargetTitleAvatar.context");
                        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.bcd));
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(260613);
                    return xVar;
                }
            });
            AppMethodBeat.o(260614);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aa(final ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        kotlin.g.b.p.h(viewGroup, "root");
        kotlin.g.b.p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246654);
        this.hOp = bVar;
        Context context = viewGroup.getContext();
        kotlin.g.b.p.g(context, "root.context");
        this.upg = new FinderLiveGiftPreviewView(context);
        this.hQn = viewGroup.getContext().getSystemService("vibrator");
        this.ULI = new com.tencent.mm.plugin.finder.view.d(viewGroup.getContext());
        this.upn = new g(this);
        View findViewById = viewGroup.findViewById(R.id.cqn);
        kotlin.g.b.p.g(findViewById, "root.findViewById(R.id.f…live_gift_panel_title_tv)");
        this.titleTv = (TextView) findViewById;
        this.titleTv.setTextSize(1, 15.0f);
        View findViewById2 = viewGroup.findViewById(R.id.cqi);
        kotlin.g.b.p.g(findViewById2, "root.findViewById(R.id.f…live_gift_panel_icon_btn)");
        this.hNZ = (ImageView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.cqf);
        kotlin.g.b.p.g(findViewById3, "root.findViewById(R.id.f…ve_gift_panel_blank_area)");
        this.hRx = findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.cr6);
        kotlin.g.b.p.g(findViewById4, "root.findViewById(R.id.finder_live_gift_viewpager)");
        this.upb = (ViewPager) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.cqh);
        kotlin.g.b.p.g(findViewById5, "root.findViewById(R.id.f…_gift_panel_content_area)");
        this.hRy = (LiveBottomSheetPanel) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.cql);
        kotlin.g.b.p.g(findViewById6, "root.findViewById(R.id.f…ive_gift_panel_retry_tip)");
        this.upc = (TextView) findViewById6;
        this.upc.setTextSize(1, 15.0f);
        View findViewById7 = viewGroup.findViewById(R.id.cqk);
        kotlin.g.b.p.g(findViewById7, "root.findViewById(R.id.f…_live_gift_panel_loading)");
        this.upd = findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.cqs);
        kotlin.g.b.p.g(findViewById8, "root.findViewById(R.id.f…ive_gift_panel_wecoin_tv)");
        this.uph = (TextView) findViewById8;
        this.uph.setTextSize(1, 14.0f);
        View findViewById9 = viewGroup.findViewById(R.id.cqq);
        kotlin.g.b.p.g(findViewById9, "root.findViewById(R.id.f…_gift_panel_wecoin_group)");
        this.upi = findViewById9;
        View findViewById10 = viewGroup.findViewById(R.id.cqd);
        kotlin.g.b.p.g(findViewById10, "root.findViewById(R.id.finder_live_gift_indicator)");
        this.upl = (FinderLiveGiftPanelIndicator) findViewById10;
        View findViewById11 = viewGroup.findViewById(R.id.k0c);
        kotlin.g.b.p.g(findViewById11, "root.findViewById(R.id.ll_choose_target)");
        this.ULM = (LinearLayout) findViewById11;
        View findViewById12 = viewGroup.findViewById(R.id.jx3);
        kotlin.g.b.p.g(findViewById12, "root.findViewById(R.id.f…t_panel_choose_target_tv)");
        this.ULO = (TextView) findViewById12;
        View findViewById13 = viewGroup.findViewById(R.id.jx2);
        kotlin.g.b.p.g(findViewById13, "root.findViewById(R.id.f…nel_choose_target_avatar)");
        this.ULN = (ImageView) findViewById13;
        this.upg.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.aa.AnonymousClass1 */
            final /* synthetic */ aa upt;

            {
                this.upt = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246624);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i(this.upt.TAG, "giftPreviewView:" + this.upt.upm + " click!, sendGiftTargetContact = " + this.upt.ULL);
                if (aa.m(this.upt)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(246624);
                    return;
                }
                this.upt.getLiveData().EN(Util.safeParseLong(this.upt.uph.getText().toString()));
                aa.n(this.upt);
                aa.l(this.upt);
                com.tencent.mm.live.c.b bVar2 = this.upt.hOp;
                b.c cVar = b.c.hMN;
                Bundle bundle = new Bundle();
                bundle.putString("PARAM_FINDER_LIVE_GIFT_ID", this.upt.upm);
                l lVar = this.upt.ULL;
                if (lVar != null) {
                    bundle.putString("PARAM_FINDER_LIVE_SEND_GIFT_TARGET_USER_NAME", lVar.userName);
                }
                bVar2.statusChange(cVar, bundle);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246624);
            }
        });
        TextView textView = this.titleTv;
        Context context2 = viewGroup.getContext();
        kotlin.g.b.p.g(context2, "root.context");
        textView.setText(context2.getResources().getString(R.string.csu));
        this.hRy.setOnVisibilityListener(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.aa.AnonymousClass2 */
            final /* synthetic */ aa upt;

            {
                this.upt = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(246625);
                if (bool.booleanValue()) {
                    this.upt.upk = false;
                    aa.o(this.upt);
                } else {
                    this.upt.rg(8);
                    b.C0376b.a(this.upt.hOp, b.c.hMH);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(246625);
                return xVar;
            }
        });
        this.upb.setAdapter(this.upe);
        this.hNZ.setOnClickListener(this);
        this.hRx.setOnClickListener(this);
        this.upi.setOnClickListener(this);
        this.upc.setOnClickListener(this);
        this.ULM.setOnClickListener(this);
        viewGroup.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.aa.AnonymousClass3 */
            final /* synthetic */ aa upt;

            {
                this.upt = r1;
            }

            public final void run() {
                AppMethodBeat.i(246626);
                int aD = au.aD(viewGroup.getContext());
                if (!this.upt.isLandscape()) {
                    ViewGroup.LayoutParams layoutParams = this.upt.hRy.getLayoutParams();
                    Context context = MMApplicationContext.getContext();
                    a aVar = aa.ups;
                    layoutParams.height = com.tencent.mm.view.d.e(context, aa.upr) + aD;
                    this.upt.hRy.setTranslationY((float) au.az(viewGroup.getContext()).y);
                    this.upt.hRy.setPadding(this.upt.hRy.getPaddingLeft(), this.upt.hRy.getPaddingTop(), this.upt.hRy.getPaddingRight(), aD + this.upt.hRy.getPaddingBottom());
                    AppMethodBeat.o(246626);
                    return;
                }
                this.upt.hRy.getLayoutParams().width = au.az(viewGroup.getContext()).y;
                this.upt.hRy.setTranslationX((float) au.az(viewGroup.getContext()).x);
                AppMethodBeat.o(246626);
            }
        });
        c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEC = false;
        com.tencent.mm.plugin.finder.api.g hTx = hTx();
        String str = (hTx == null || (str = hTx.getNickname()) == null) ? ULP : str;
        com.tencent.mm.plugin.finder.api.g hTx2 = hTx();
        this.ULL = new l("", str, hTx2 != null ? hTx2.cXH() : null);
        this.ULI.Ml(R.layout.cey);
        this.ULI.hVw();
        this.ULI.hVx();
        this.ULI.hVy();
        View findViewById14 = this.ULI.lJI.findViewById(R.id.k0b);
        kotlin.g.b.p.g(findViewById14, "chooseTargetSheet.rootVi…l_bottom_sheet_container)");
        this.ULJ = (LinearLayout) findViewById14;
        this.ULK = new kotlin.g.a.b<l, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.aa.AnonymousClass4 */
            final /* synthetic */ aa upt;

            {
                this.upt = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(l lVar) {
                AppMethodBeat.i(260603);
                l lVar2 = lVar;
                kotlin.g.b.p.h(lVar2, "contact");
                Log.i(this.upt.TAG, "bottomSheetClickListener contact:".concat(String.valueOf(lVar2)));
                aa.a(this.upt, lVar2);
                aa.s(this.upt);
                this.upt.ULI.bMo();
                x xVar = x.SXb;
                AppMethodBeat.o(260603);
                return xVar;
            }
        };
        AppMethodBeat.o(246654);
    }

    public static final /* synthetic */ void a(aa aaVar, long j2) {
        AppMethodBeat.i(246659);
        aaVar.EM(j2);
        AppMethodBeat.o(246659);
    }

    public static final /* synthetic */ void a(aa aaVar, View view) {
        AppMethodBeat.i(246656);
        aaVar.dX(view);
        AppMethodBeat.o(246656);
    }

    public static final /* synthetic */ void a(aa aaVar, List list) {
        AppMethodBeat.i(246657);
        aaVar.ec(list);
        AppMethodBeat.o(246657);
    }

    public static final /* synthetic */ List h(aa aaVar) {
        AppMethodBeat.i(246658);
        List<com.tencent.mm.plugin.finder.storage.s> dhh = aaVar.dhh();
        AppMethodBeat.o(246658);
        return dhh;
    }

    public static final /* synthetic */ void l(aa aaVar) {
        AppMethodBeat.i(246660);
        aaVar.dhg();
        AppMethodBeat.o(246660);
    }

    public static final /* synthetic */ void o(aa aaVar) {
        AppMethodBeat.i(246664);
        aaVar.dhi();
        AppMethodBeat.o(246664);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.finder.api.g r(aa aaVar) {
        AppMethodBeat.i(260622);
        com.tencent.mm.plugin.finder.api.g hTx = aaVar.hTx();
        AppMethodBeat.o(260622);
        return hTx;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin$Companion;", "", "()V", "DEFAULT_ANCHOR_NAME", "", "FAST_CLICK_DELAY_TIME_MS", "", "getFAST_CLICK_DELAY_TIME_MS", "()I", "GIFT_PANEL_HEIGHT", "", "getGIFT_PANEL_HEIGHT", "()F", "MAX_PAGE_SIZE", "getMAX_PAGE_SIZE", "PAGE_GIFT_SIZE", "getPAGE_GIFT_SIZE", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(246655);
        String string = MMApplicationContext.getResources().getString(R.string.cr0);
        kotlin.g.b.p.g(string, "MMApplicationContext.get…nder_live_anchor_tag_txt)");
        ULP = string;
        AppMethodBeat.o(246655);
    }

    private final com.tencent.mm.plugin.finder.api.g hTx() {
        AppMethodBeat.i(260616);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(getLiveData().hwd);
        AppMethodBeat.o(260616);
        return asG;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin$SendGiftTargetContact;", "", "userName", "", "nickName", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "isChecked", "", "()Z", "setChecked", "(Z)V", "getNickName", "setNickName", "getUserName", "setUserName", "component1", "component2", "component3", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-finder_release"})
    public static final class l {
        boolean edw;
        String kog;
        String nickName;
        String userName;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
            if (kotlin.g.b.p.j(r3.kog, r4.kog) != false) goto L_0x002c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 260606(0x3f9fe, float:3.65187E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x002c
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.plugin.aa.l
                if (r0 == 0) goto L_0x0031
                com.tencent.mm.plugin.finder.live.plugin.aa$l r4 = (com.tencent.mm.plugin.finder.live.plugin.aa.l) r4
                java.lang.String r0 = r3.userName
                java.lang.String r1 = r4.userName
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0031
                java.lang.String r0 = r3.nickName
                java.lang.String r1 = r4.nickName
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0031
                java.lang.String r0 = r3.kog
                java.lang.String r1 = r4.kog
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0031
            L_0x002c:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0030:
                return r0
            L_0x0031:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0030
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.aa.l.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(260605);
            String str = this.userName;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.nickName;
            int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
            String str3 = this.kog;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            int i3 = hashCode2 + i2;
            AppMethodBeat.o(260605);
            return i3;
        }

        public l(String str, String str2, String str3) {
            this.userName = str;
            this.nickName = str2;
            this.kog = str3;
        }

        public final String toString() {
            AppMethodBeat.i(260604);
            String str = "username=" + this.userName + ", nickname=" + this.nickName;
            AppMethodBeat.o(260604);
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0021 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.tencent.mm.plugin.finder.live.viewmodel.e> hTy() {
        /*
            r9 = this;
            r8 = 260617(0x3fa09, float:3.65202E-40)
            r3 = 1
            r4 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
            com.tencent.mm.plugin.finder.live.viewmodel.g r0 = r9.getLiveData()
            java.util.List<com.tencent.mm.plugin.finder.live.viewmodel.e> r0 = r0.UPZ
            java.lang.String r1 = "liveData.audienceLinkMicUserList"
            kotlin.g.b.p.g(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r5 = r0.iterator()
        L_0x0021:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0058
            java.lang.Object r2 = r5.next()
            r0 = r2
            com.tencent.mm.plugin.finder.live.viewmodel.e r0 = (com.tencent.mm.plugin.finder.live.viewmodel.e) r0
            int r6 = r0.UPP
            r7 = 16
            boolean r6 = com.tencent.mm.ac.d.cW(r6, r7)
            if (r6 != 0) goto L_0x0056
            java.lang.String r0 = r0.username
            com.tencent.mm.plugin.finder.utils.y r6 = com.tencent.mm.plugin.finder.utils.y.vXH
            boolean r6 = com.tencent.mm.plugin.finder.utils.y.In(r0)
            if (r6 != 0) goto L_0x004a
            com.tencent.mm.plugin.finder.utils.y r6 = com.tencent.mm.plugin.finder.utils.y.vXH
            boolean r0 = com.tencent.mm.plugin.finder.utils.y.awn(r0)
            if (r0 == 0) goto L_0x0054
        L_0x004a:
            r0 = r3
        L_0x004b:
            if (r0 != 0) goto L_0x0056
            r0 = r3
        L_0x004e:
            if (r0 == 0) goto L_0x0021
            r1.add(r2)
            goto L_0x0021
        L_0x0054:
            r0 = r4
            goto L_0x004b
        L_0x0056:
            r0 = r4
            goto L_0x004e
        L_0x0058:
            java.util.List r1 = (java.util.List) r1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.aa.hTy():java.util.List");
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class o implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.b ULT;
        final /* synthetic */ l ULU;

        o(kotlin.g.a.b bVar, l lVar) {
            this.ULT = bVar;
            this.ULU = lVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260611);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin$createBottomSheetItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.ULT.invoke(this.ULU);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin$createBottomSheetItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260611);
        }
    }

    public static /* synthetic */ void p(aa aaVar) {
        AppMethodBeat.i(260620);
        aaVar.a((l) null);
        AppMethodBeat.o(260620);
    }

    public final void a(l lVar) {
        AppMethodBeat.i(260619);
        if (!getLiveData().dja()) {
            Log.i(this.TAG, "showGiftListContent liveData.enableGift:" + getLiveData().dja());
            AppMethodBeat.o(260619);
            return;
        }
        g((Long) null);
        com.tencent.mm.ac.d.h(new j(this, lVar));
        b.C0376b.a(this.hOp, b.c.hMO);
        AppMethodBeat.o(260619);
    }

    private final void dhg() {
        AppMethodBeat.i(246640);
        com.tencent.mm.ac.d.h(new c(this));
        AppMethodBeat.o(246640);
    }

    private final void dX(View view) {
        AppMethodBeat.i(246641);
        try {
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(view);
                AppMethodBeat.o(246641);
                return;
            }
            AppMethodBeat.o(246641);
        } catch (Exception e2) {
            y yVar = y.vXH;
            y.a(e2, this.TAG + ":removeViewFromParent");
            AppMethodBeat.o(246641);
        }
    }

    private final List<com.tencent.mm.plugin.finder.storage.s> dhh() {
        AppMethodBeat.i(246642);
        com.tencent.mm.plugin.finder.live.model.e eVar = com.tencent.mm.plugin.finder.live.model.e.uiD;
        ArrayList arrayList = new ArrayList();
        for (T t : com.tencent.mm.plugin.finder.live.model.e.dfw().values()) {
            T t2 = t;
            boolean dxN = t2.dxN();
            boolean dxP = t2.dxP();
            boolean dxO = t2.dxO();
            boolean z = (dxN && dxP && dxO) || (!dxN && dxO);
            if (!z) {
                Log.i(this.TAG, "updateGiftFromCache invalid gift:" + ((com.tencent.mm.plugin.finder.storage.s) t2).field_name + ",isFullPagGift:" + dxN + ",pagFullFetched:" + dxP + ",pagPreFetched:" + dxO);
            }
            if (z) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        Log.i(this.TAG, "getCacheGiftList cacheGiftListSize:" + arrayList2.size());
        AppMethodBeat.o(246642);
        return arrayList2;
    }

    private final void ec(List<com.tencent.mm.plugin.finder.storage.s> list) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(246643);
        if (list.isEmpty()) {
            this.upc.setVisibility(0);
            AppMethodBeat.o(246643);
            return;
        }
        this.upb.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        y yVar = y.vXH;
        if (y.dCM()) {
            o.a aVar = com.tencent.mm.plugin.finder.live.widget.o.uHD;
            if (com.tencent.mm.plugin.finder.live.widget.o.uHC) {
                arrayList.addAll(list);
            }
        }
        int size = arrayList.size();
        if (size % upo == 0) {
            i2 = size / upo;
        } else {
            i2 = (size / upo) + 1;
        }
        if (i2 > upp) {
            i3 = upp;
        } else {
            i3 = i2;
        }
        Log.i(this.TAG, "updateGiftPage giftSize:" + size + ",calPageSize:" + i2 + ", pageSize:" + i3);
        ArrayList arrayList2 = new ArrayList();
        int i5 = au.az(this.hwr.getContext()).x;
        int i6 = au.az(this.hwr.getContext()).y;
        int i7 = upo / 2;
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ct);
        Context context2 = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
        int dimensionPixelOffset2 = context2.getResources().getDimensionPixelOffset(R.dimen.bu);
        if (!isLandscape()) {
            i4 = ((i5 - ((i7 - 1) * dimensionPixelOffset)) - (i7 * dimensionPixelOffset2)) / 2;
        } else {
            i4 = ((i6 - ((i7 - 1) * dimensionPixelOffset)) - (i7 * dimensionPixelOffset2)) / 2;
        }
        for (int i8 = 0; i8 < i3; i8++) {
            GridView gridView = new GridView(this.hwr.getContext());
            Context context3 = this.hwr.getContext();
            kotlin.g.b.p.g(context3, "root.context");
            com.tencent.mm.plugin.finder.live.view.adapter.d dVar = new com.tencent.mm.plugin.finder.live.view.adapter.d(context3);
            dVar.r(arrayList, i8);
            dVar.upn = this.upn;
            gridView.setAdapter((ListAdapter) dVar);
            gridView.setColumnWidth(dimensionPixelOffset2);
            gridView.setNumColumns(i7);
            gridView.setHorizontalSpacing(dimensionPixelOffset);
            gridView.setStretchMode(0);
            gridView.setVerticalSpacing(dimensionPixelOffset);
            gridView.setGravity(17);
            gridView.setPadding(i4, gridView.getPaddingTop(), gridView.getPaddingRight(), gridView.getPaddingBottom());
            arrayList2.add(gridView);
        }
        com.tencent.mm.plugin.finder.live.view.adapter.e eVar = this.upe;
        ArrayList arrayList3 = arrayList2;
        kotlin.g.b.p.h(arrayList3, "gridList");
        if (eVar.uAT.size() > 0) {
            eVar.uAT.clear();
        }
        eVar.uAT.addAll(arrayList3);
        eVar.notifyDataSetChanged();
        this.upl.setIndicatorSize(i3);
        FinderLiveGiftPanelIndicator finderLiveGiftPanelIndicator = this.upl;
        ViewPager viewPager = this.upb;
        kotlin.g.b.p.h(viewPager, "viewpager");
        viewPager.addOnPageChangeListener(new FinderLiveGiftPanelIndicator.a(finderLiveGiftPanelIndicator));
        this.upl.setCurrentChoosedIndicator(0);
        this.upb.setCurrentItem(0, false);
        AppMethodBeat.o(246643);
    }

    private final void dhi() {
        boolean z;
        AppMethodBeat.i(246644);
        Log.i(this.TAG, "showGiftPage");
        List<com.tencent.mm.plugin.finder.storage.s> dhh = dhh();
        if (dhh.isEmpty()) {
            String str = this.TAG;
            StringBuilder sb = new StringBuilder("getGiftListFromCgi loading:");
            if (this.upd.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            Log.i(str, sb.append(z).append('!').toString());
            this.upd.setVisibility(0);
            this.upb.setVisibility(8);
            this.upc.setVisibility(8);
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                getLiveData();
                getLiveData();
                getLiveData();
                finderLiveAssistant.f(new b(this));
                AppMethodBeat.o(246644);
                return;
            }
            AppMethodBeat.o(246644);
            return;
        }
        com.tencent.mm.plugin.finder.live.model.o oVar2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant2 = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant2 != null) {
            getLiveData();
            getLiveData();
            getLiveData();
            finderLiveAssistant2.f(null);
        }
        ec(dhh);
        AppMethodBeat.o(246644);
    }

    private final void g(Long l2) {
        AppMethodBeat.i(246645);
        if (l2 == null) {
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                finderLiveAssistant.E(new k(this));
                AppMethodBeat.o(246645);
                return;
            }
            AppMethodBeat.o(246645);
            return;
        }
        EM(l2.longValue());
        AppMethodBeat.o(246645);
    }

    private final void EM(long j2) {
        AppMethodBeat.i(246646);
        com.tencent.mm.ac.d.h(new i(this, j2));
        AppMethodBeat.o(246646);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ aa upt;

        h(aa aaVar) {
            this.upt = aaVar;
        }

        public final void run() {
            AppMethodBeat.i(246635);
            this.upt.upg.setVisibility(0);
            FinderLiveGiftPreviewView finderLiveGiftPreviewView = this.upt.upg;
            com.tencent.mm.plugin.finder.live.model.e eVar = com.tencent.mm.plugin.finder.live.model.e.uiD;
            String bf = com.tencent.mm.plugin.finder.live.model.e.bf(this.upt.upm, true);
            if (bf == null) {
                bf = "";
            }
            kotlin.g.b.p.h(bf, "path");
            com.tencent.mm.plugin.finder.live.model.e eVar2 = com.tencent.mm.plugin.finder.live.model.e.uiD;
            if (com.tencent.mm.plugin.finder.live.model.e.getDebug()) {
                PAGView pAGView = finderLiveGiftPreviewView.uyw;
                Context context = finderLiveGiftPreviewView.getContext();
                kotlin.g.b.p.g(context, "context");
                pAGView.setFile(PAGFile.Load(context.getAssets(), bf));
                finderLiveGiftPreviewView.uyw.setRepeatCount(-1);
                finderLiveGiftPreviewView.uyw.play();
            } else {
                finderLiveGiftPreviewView.uyw.setFile(PAGFile.Load(bf));
                finderLiveGiftPreviewView.uyw.setRepeatCount(-1);
                finderLiveGiftPreviewView.uyw.play();
            }
            this.upt.upg.animate().setDuration(300).alpha(1.0f).setInterpolator(new DecelerateInterpolator()).start();
            AppMethodBeat.o(246635);
        }
    }

    public final void onClick(View view) {
        com.tencent.mm.plugin.wallet.wecoin.a.d dVar;
        String str;
        String str2;
        AppMethodBeat.i(246647);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if ((valueOf != null && valueOf.intValue() == R.id.cqi) || (valueOf != null && valueOf.intValue() == R.id.cqf)) {
            dhg();
            if (this.hOp.getLiveRole() == 0) {
                com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                com.tencent.mm.plugin.finder.report.live.m.a(s.aw.RETURN_LIVE_ROOM_FROM_GIFT_BOARD, "", 0);
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.cqq) {
            if (this.hwr.getContext() instanceof FragmentActivity) {
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                if (finderLiveAssistant != null && true == finderLiveAssistant.dfq()) {
                    if (this.hOp.getLiveRole() == 0) {
                        com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
                        com.tencent.mm.plugin.finder.report.live.m.a(s.aw.CLICK_GIFT_BOARD_RIGHT_GREEN_ENTER_RECHARGE_UI, "", 0);
                    }
                    com.tencent.mm.plugin.finder.live.model.o oVar2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                    com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant2 = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                    if (finderLiveAssistant2 != null) {
                        Context context = this.hwr.getContext();
                        if (context == null) {
                            t tVar = new t("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
                            AppMethodBeat.o(246647);
                            throw tVar;
                        }
                        dVar = finderLiveAssistant2.a((FragmentActivity) context, 1, new d(this));
                    } else {
                        dVar = null;
                    }
                    this.upj = dVar;
                    com.tencent.mm.plugin.wallet.wecoin.a.d dVar2 = this.upj;
                    if (dVar2 != null) {
                        dVar2.a(new e(this));
                    }
                    com.tencent.mm.plugin.wallet.wecoin.a.d dVar3 = this.upj;
                    if (dVar3 != null) {
                        dVar3.b(new f(this));
                    }
                }
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.cql) {
            dhi();
        } else if (valueOf != null && valueOf.intValue() == R.id.k0c) {
            dhg();
            this.ULJ.removeAllViews();
            com.tencent.mm.plugin.finder.api.g hTx = hTx();
            if (hTx == null || (str = hTx.getNickname()) == null) {
                str = ULP;
            }
            com.tencent.mm.plugin.finder.api.g hTx2 = hTx();
            l lVar = new l("", str, hTx2 != null ? hTx2.cXH() : null);
            l lVar2 = this.ULL;
            lVar.edw = lVar2 != null && (str2 = lVar2.userName) != null && str2.equals("");
            this.ULJ.addView(a(lVar, (kotlin.g.a.b<? super l, x>) this.ULK, true));
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> hTy = hTy();
            synchronized (hTy) {
                try {
                    for (T t : hTy) {
                        l lVar3 = new l(t.username, t.nickname, t.headUrl);
                        String str3 = t.username;
                        l lVar4 = this.ULL;
                        lVar3.edw = kotlin.g.b.p.j(str3, lVar4 != null ? lVar4.userName : null);
                        this.ULJ.addView(a(lVar3, (kotlin.g.a.b<? super l, x>) this.ULK, false));
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(246647);
                    throw th;
                }
            }
            this.ULI.dGm();
            this.ULI.a(new p(this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246647);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class e implements d.a {
        final /* synthetic */ aa upt;

        e(aa aaVar) {
            this.upt = aaVar;
        }

        @Override // com.tencent.mm.plugin.wallet.wecoin.a.d.a
        public final void dhl() {
            AppMethodBeat.i(246632);
            aa.l(this.upt);
            AppMethodBeat.o(246632);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class p implements d.a {
        final /* synthetic */ aa upt;

        p(aa aaVar) {
            this.upt = aaVar;
        }

        @Override // com.tencent.mm.plugin.finder.view.d.a
        public final void onDismiss() {
            AppMethodBeat.i(260612);
            this.upt.a(this.upt.ULL);
            AppMethodBeat.o(260612);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(246648);
        super.resume();
        if (this.hwr.getVisibility() == 0) {
            g((Long) null);
        }
        AppMethodBeat.o(246648);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(246650);
        super.unMount();
        this.upg.uyw.stop();
        AppMethodBeat.o(246650);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        Long l2;
        AppMethodBeat.i(246651);
        kotlin.g.b.p.h(cVar, "status");
        switch (ab.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (bundle == null) {
                    l2 = null;
                } else if (bundle.containsKey("PARAM_FINDER_LIVE_GIFT_UPDATE_WECOIN")) {
                    l2 = Long.valueOf(bundle.getLong("PARAM_FINDER_LIVE_GIFT_UPDATE_WECOIN"));
                } else {
                    l2 = null;
                }
                if (l2 != null) {
                    g(l2);
                    AppMethodBeat.o(246651);
                    return;
                }
                g((Long) null);
                AppMethodBeat.o(246651);
                return;
            case 2:
                if (!getLiveData().dja()) {
                    if (this.hwr.getVisibility() == 0) {
                        dhg();
                    }
                    com.tencent.mm.plugin.wallet.wecoin.a.d dVar = this.upj;
                    if (dVar != null) {
                        dVar.bMo();
                        AppMethodBeat.o(246651);
                        return;
                    }
                }
                AppMethodBeat.o(246651);
                return;
            case 3:
                com.tencent.mm.plugin.wallet.wecoin.a.d dVar2 = this.upj;
                if (dVar2 != null) {
                    dVar2.bMo();
                    AppMethodBeat.o(246651);
                    return;
                }
                break;
        }
        AppMethodBeat.o(246651);
    }

    @Override // com.tencent.mm.live.c.a
    public final void a(LinkedHashMap<String, Rect> linkedHashMap, boolean z) {
        AppMethodBeat.i(260621);
        kotlin.g.b.p.h(linkedHashMap, "micUserMap");
        if (linkedHashMap.isEmpty()) {
            com.tencent.mm.ac.d.h(new r(this));
        }
        AppMethodBeat.o(260621);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    static final class f implements com.tencent.mm.plugin.wallet.wecoin.a.a {
        final /* synthetic */ aa upt;

        f(aa aaVar) {
            this.upt = aaVar;
        }

        @Override // com.tencent.mm.plugin.wallet.wecoin.a.a
        public final void onClick() {
            AppMethodBeat.i(246633);
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                finderLiveAssistant.dfo();
                AppMethodBeat.o(246633);
                return;
            }
            AppMethodBeat.o(246633);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ aa upt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(aa aaVar) {
            super(0);
            this.upt = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            String str2;
            AppMethodBeat.i(260615);
            Log.i(this.upt.TAG, "restoreTargetContactToAnchor");
            l lVar = this.upt.ULL;
            if (lVar != null) {
                lVar.userName = "";
            }
            l lVar2 = this.upt.ULL;
            if (lVar2 != null) {
                com.tencent.mm.plugin.finder.api.g r = aa.r(this.upt);
                if (r == null || (str2 = r.getNickname()) == null) {
                    str2 = aa.ULP;
                }
                lVar2.nickName = str2;
            }
            l lVar3 = this.upt.ULL;
            if (lVar3 != null) {
                com.tencent.mm.plugin.finder.api.g r2 = aa.r(this.upt);
                if (r2 != null) {
                    str = r2.cXH();
                } else {
                    str = null;
                }
                lVar3.kog = str;
            }
            aa.s(this.upt);
            this.upt.ULI.bMo();
            x xVar = x.SXb;
            AppMethodBeat.o(260615);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ l ULW;
        final /* synthetic */ aa upt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(aa aaVar, l lVar) {
            super(0);
            this.upt = aaVar;
            this.ULW = lVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str = null;
            AppMethodBeat.i(246638);
            if (this.ULW != null) {
                if (Util.isEqual(this.ULW.userName, this.upt.getLiveData().hwd)) {
                    aa aaVar = this.upt;
                    com.tencent.mm.plugin.finder.api.g r = aa.r(this.upt);
                    String nickname = r != null ? r.getNickname() : null;
                    com.tencent.mm.plugin.finder.api.g r2 = aa.r(this.upt);
                    if (r2 != null) {
                        str = r2.cXH();
                    }
                    aa.a(aaVar, new l("", nickname, str));
                } else {
                    aa.a(this.upt, this.ULW);
                }
            }
            Log.i(this.upt.TAG, "showGiftListContent");
            this.upt.rg(0);
            this.upt.upc.setVisibility(8);
            this.upt.upd.setVisibility(8);
            this.upt.hRy.post(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.aa.j.AnonymousClass1 */
                final /* synthetic */ j upw;

                {
                    this.upw = r1;
                }

                public final void run() {
                    AppMethodBeat.i(246637);
                    this.upw.upt.hRy.show();
                    AppMethodBeat.o(246637);
                }
            });
            aa.s(this.upt);
            c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEC = true;
            x xVar = x.SXb;
            AppMethodBeat.o(246638);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ aa upt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(aa aaVar) {
            super(0);
            this.upt = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            View findViewById;
            AppMethodBeat.i(246630);
            this.upt.upk = true;
            Log.i(this.upt.TAG, "hideGiftListContent");
            ViewGroup viewGroup = this.upt.upf;
            if (!(viewGroup == null || (findViewById = viewGroup.findViewById(R.id.dk4)) == null)) {
                findViewById.setAlpha(1.0f);
            }
            this.upt.upg.uyw.stop();
            aa.a(this.upt, (View) this.upt.upg);
            this.upt.hRy.hide();
            this.upt.upg.uyw.stop();
            c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEC = false;
            x xVar = x.SXb;
            AppMethodBeat.o(246630);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ aa upt;
        final /* synthetic */ long upv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(aa aaVar, long j2) {
            super(0);
            this.upt = aaVar;
            this.upv = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246636);
            if (this.upv < 0) {
                Log.i(this.upt.TAG, "setBalance balance:" + this.upv);
            } else {
                this.upt.getLiveData().EN(this.upv);
                this.upt.uph.setText(String.valueOf(this.upt.getLiveData().uEM));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246636);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ aa upt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(aa aaVar) {
            super(0);
            this.upt = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246631);
            if (this.upt.hwr.getVisibility() != 0) {
                b.C0376b.a(this.upt.hOp, b.c.hMG);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246631);
            return xVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.View a(com.tencent.mm.plugin.finder.live.plugin.aa.l r10, kotlin.g.a.b<? super com.tencent.mm.plugin.finder.live.plugin.aa.l, kotlin.x> r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.aa.a(com.tencent.mm.plugin.finder.live.plugin.aa$l, kotlin.g.a.b, boolean):android.view.View");
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(246649);
        if (this.hwr.getVisibility() == 0) {
            dhg();
            if (this.hOp.getLiveRole() == 0) {
                com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                com.tencent.mm.plugin.finder.report.live.m.a(s.aw.RETURN_LIVE_ROOM_FROM_GIFT_BOARD, "", 0);
            }
            AppMethodBeat.o(246649);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(246649);
        return onBackPress;
    }

    public static final /* synthetic */ void s(aa aaVar) {
        String str;
        String str2 = null;
        AppMethodBeat.i(260623);
        if (aaVar.hTy().isEmpty()) {
            Log.i(aaVar.TAG, "refreshSendGiftTargetTitleLayout: validList is empty");
            aaVar.ULM.setVisibility(8);
            TextView textView = aaVar.titleTv;
            Context context = aaVar.hwr.getContext();
            kotlin.g.b.p.g(context, "root.context");
            textView.setText(context.getResources().getString(R.string.csu));
            AppMethodBeat.o(260623);
            return;
        }
        Log.i(aaVar.TAG, "refreshSendGiftTargetTitleLayout: sendGiftTargetContact = " + aaVar.ULL);
        aaVar.ULM.setVisibility(0);
        TextView textView2 = aaVar.titleTv;
        Context context2 = aaVar.hwr.getContext();
        kotlin.g.b.p.g(context2, "root.context");
        textView2.setText(context2.getResources().getString(R.string.j_s));
        TextView textView3 = aaVar.ULO;
        Context context3 = aaVar.ULO.getContext();
        l lVar = aaVar.ULL;
        if (lVar != null) {
            str = lVar.nickName;
        } else {
            str = null;
        }
        textView3.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context3, str, aaVar.ULO.getTextSize()));
        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
        l lVar2 = aaVar.ULL;
        if (lVar2 != null) {
            str2 = lVar2.kog;
        }
        com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(str2);
        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        dka.a(aVar, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR)).a(new q(aaVar)).vC();
        AppMethodBeat.o(260623);
    }

    public static final /* synthetic */ void a(aa aaVar, l lVar) {
        AppMethodBeat.i(260624);
        Log.i(aaVar.TAG, "refreshTargetContact: contact = ".concat(String.valueOf(lVar)));
        l lVar2 = aaVar.ULL;
        if (lVar2 != null) {
            lVar2.userName = lVar.userName;
        }
        l lVar3 = aaVar.ULL;
        if (lVar3 != null) {
            lVar3.nickName = lVar.nickName;
        }
        l lVar4 = aaVar.ULL;
        if (lVar4 != null) {
            lVar4.kog = lVar.kog;
            AppMethodBeat.o(260624);
            return;
        }
        AppMethodBeat.o(260624);
    }

    public static final /* synthetic */ void a(aa aaVar, String str) {
        AppMethodBeat.i(246661);
        com.tencent.mm.plugin.finder.live.model.e eVar = com.tencent.mm.plugin.finder.live.model.e.uiD;
        boolean bg = com.tencent.mm.plugin.finder.live.model.e.bg(str, true);
        if (str != null && bg) {
            aaVar.upg.uyw.stop();
            aaVar.dX(aaVar.upg);
            aaVar.rg(0);
            aaVar.upm = str;
            aaVar.upg.setTranslationY(0.0f);
            aaVar.upg.setAlpha(0.0f);
            aaVar.upg.setVisibility(8);
            ViewGroup viewGroup = aaVar.upf;
            if (viewGroup != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(viewGroup.getMeasuredWidth(), viewGroup.getMeasuredHeight());
                if (viewGroup.indexOfChild(aaVar.upg) == -1) {
                    viewGroup.addView(aaVar.upg, layoutParams);
                }
                aaVar.upg.post(new h(aaVar));
            }
        }
        Log.i(aaVar.TAG, "showPreviewGift, giftId:" + str + " giftValid:" + bg);
        AppMethodBeat.o(246661);
    }

    public static final /* synthetic */ boolean m(aa aaVar) {
        AppMethodBeat.i(246662);
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - aaVar.lastClickTime >= ((long) upq)) {
            z = false;
        }
        aaVar.lastClickTime = currentTimeMillis;
        AppMethodBeat.o(246662);
        return z;
    }

    public static final /* synthetic */ boolean n(aa aaVar) {
        AppMethodBeat.i(246663);
        com.tencent.mm.plugin.finder.live.model.e eVar = com.tencent.mm.plugin.finder.live.model.e.uiD;
        boolean bg = com.tencent.mm.plugin.finder.live.model.e.bg(aaVar.upm, false);
        if (aaVar.upm == null || !bg) {
            AppMethodBeat.o(246663);
            return false;
        }
        if (aaVar.hQn instanceof Vibrator) {
            ((Vibrator) aaVar.hQn).vibrate(50);
        }
        AppMethodBeat.o(246663);
        return true;
    }
}
