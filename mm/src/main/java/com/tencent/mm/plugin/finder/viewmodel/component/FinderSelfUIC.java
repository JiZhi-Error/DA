package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.feed.ui.FinderLikeFeedGridUI;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.FinderExposeUI;
import com.tencent.mm.plugin.finder.ui.FinderFollowListUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.protocal.protobuf.fhn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.view.e;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import kotlin.g.b.z;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u0002062\u0006\u0010o\u001a\u000206J\u0016\u0010p\u001a\u00020m2\u0006\u0010n\u001a\u0002062\u0006\u0010o\u001a\u000206J\u0016\u0010q\u001a\u00020m2\u0006\u0010n\u001a\u0002062\u0006\u0010o\u001a\u000206J\b\u0010r\u001a\u00020mH\u0002J\b\u0010s\u001a\u00020mH\u0002J\u0006\u0010t\u001a\u00020\u001eJ\b\u0010u\u001a\u00020mH\u0002J\b\u0010v\u001a\u00020mH\u0002J\u0010\u0010w\u001a\u00020m2\u0006\u0010x\u001a\u00020fH\u0002J\b\u0010y\u001a\u00020\u001eH\u0002J\b\u0010z\u001a\u00020\u001eH\u0016J\b\u0010{\u001a\u00020\u001eH\u0002J\b\u0010|\u001a\u00020\bH\u0002J\"\u0010}\u001a\u00020m2\u0006\u0010~\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u001eH\u0016J\t\u0010\u0001\u001a\u00020mH\u0002J\t\u0010\u0001\u001a\u00020mH\u0002J\t\u0010\u0001\u001a\u00020mH\u0002J\u0017\u0010\u0001\u001a\u00020m2\u0006\u0010n\u001a\u0002062\u0006\u0010o\u001a\u000206J\u0017\u0010\u0001\u001a\u00020m2\u0006\u0010n\u001a\u0002062\u0006\u0010o\u001a\u000206J'\u0010\u0001\u001a\u00020m2\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u001e2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0015\u0010\u0001\u001a\u00020m2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020mH\u0016J4\u0010\u0001\u001a\u00020m2\u0007\u0010\u0001\u001a\u00020\u001e2\u0010\u0010\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020<0\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020mH\u0016J2\u0010\u0001\u001a\u00020m2\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\u001e2\t\u0010\u0001\u001a\u0004\u0018\u00010<2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020mH\u0016J\t\u0010\u0001\u001a\u00020mH\u0002J\t\u0010\u0001\u001a\u00020mH\u0002R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\bXD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0014\u0010\u001b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\nR\u000e\u0010\u001d\u001a\u00020\u001eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eXD¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\n\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X.¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000206X.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000203X.¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u001a\u0010D\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010>\"\u0004\bF\u0010@R\u001a\u0010G\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010>\"\u0004\bI\u0010@R\u001a\u0010J\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R\u001a\u0010M\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010>\"\u0004\bO\u0010@R\u001a\u0010P\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010#\"\u0004\bR\u0010%R\u000e\u0010S\u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010[\u001a\u00020\\8BX\u0002¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\b]\u0010^R\u0010\u0010a\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020d0cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX.¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010#\"\u0004\bk\u0010%¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "BANNER_TYPE_CREATOR_ENTRANCE", "", "getBANNER_TYPE_CREATOR_ENTRANCE", "()J", "BANNER_TYPE_FAV", "getBANNER_TYPE_FAV", "BANNER_TYPE_FINDER_MSG", "getBANNER_TYPE_FINDER_MSG", "BANNER_TYPE_FINDER_PRIVATE_MESSAGE", "BANNER_TYPE_FINDER_PRIVATE_MESSAGE$annotations", "()V", "getBANNER_TYPE_FINDER_PRIVATE_MESSAGE", "BANNER_TYPE_FOLLOW", "getBANNER_TYPE_FOLLOW", "BANNER_TYPE_LIKE", "getBANNER_TYPE_LIKE", "BANNER_TYPE_LIVE_INCOME", "getBANNER_TYPE_LIVE_INCOME", "BANNER_TYPE_WX_MSG", "getBANNER_TYPE_WX_MSG", "BANNER_TYPE_WX_PRIVATE_MESSAGE", "getBANNER_TYPE_WX_PRIVATE_MESSAGE", "MENU_ID_CREATE_NOTICE", "", "MENU_ID_OPEN_LIVE", "autoShow", "", "getAutoShow", "()Z", "setAutoShow", "(Z)V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "dialogCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "enterTimeStamp", "getEnterTimeStamp", "setEnterTimeStamp", "(J)V", "finderCanPostNoContact", "Landroid/widget/TextView;", "finderLiveCanPostNoContact", "finderLivePosBtn", "Landroid/view/View;", "finderLivePostNewFeed", "finderPosBtn", "finderPostNewFeed", "finderRedPackEntrance", "hasExposeCreatorEntranceTips", "", "getHasExposeCreatorEntranceTips", "()Ljava/lang/String;", "setHasExposeCreatorEntranceTips", "(Ljava/lang/String;)V", "hasExposeFinderHiMsgTips", "getHasExposeFinderHiMsgTips", "setHasExposeFinderHiMsgTips", "hasExposeFinderMsgTips", "getHasExposeFinderMsgTips", "setHasExposeFinderMsgTips", "hasExposeLiveEntranceTips", "getHasExposeLiveEntranceTips", "setHasExposeLiveEntranceTips", "hasExposeProfileEntranceTips", "getHasExposeProfileEntranceTips", "setHasExposeProfileEntranceTips", "hasExposeWXMsgTips", "getHasExposeWXMsgTips", "setHasExposeWXMsgTips", "hasReportFinderMsg", "getHasReportFinderMsg", "setHasReportFinderMsg", "isEnableSendMsgEntrance", "isFromSnsPost", "isReportRedDotExpose", "lastFavTipsId", "liveBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "livePostHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelper;", "livePostUic", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "getLivePostUic", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "livePostUic$delegate", "Lkotlin/Lazy;", "myFinderUsername", "postItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressBar", "Landroid/widget/ProgressBar;", "redDotExistOnEnter", "getRedDotExistOnEnter", "setRedDotExistOnEnter", "accountAbnormal", "", "hasContactContainer", "noContactContainer", "canPostButNoAccountUi", "canPostButRevingUi", "checkAutoShowPost", "checkTeenMode", "checkUserState", "doClickPostAction", "doPrepareUser", "doReviewJump", "prepareResponse", "getEntranceType", "getLayoutId", "getWXMsgCount", "getWxFinderPrivateMsgRedDotCount", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "scene", "initLiveRewardGainCell", "initPostBtn", "initView", "noPostQualityUI", "normalOrAbNomalUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshSelf", "reportTabExposure", "plugin-finder_release"})
public final class FinderSelfUIC extends UIComponent implements com.tencent.mm.ak.i, com.tencent.mm.plugin.finder.api.f {
    private boolean UVP;
    private ProgressBar progressBar;
    long sTp;
    private bed udb;
    private HashMap<Integer, ddk> udg = new HashMap<>();
    private final kotlin.f vaj;
    String wAa = "";
    String wAb = "";
    String wAc = "";
    String wAd = "";
    String wAe = "";
    private boolean wAf;
    private final boolean wAg;
    private String wAh;
    private final int wyj = 10001;
    private final int wyk = 10002;
    private com.tencent.mm.ui.widget.a.e wyl;
    private String wzE;
    private boolean wzF;
    private com.tencent.mm.plugin.finder.ui.g wzG;
    private View wzH;
    private TextView wzI;
    private TextView wzJ;
    private View wzK;
    private TextView wzL;
    private TextView wzM;
    private View wzN;
    final long wzO = 1;
    final long wzP = 2;
    final long wzQ = 3;
    final long wzR = 4;
    final long wzS = 5;
    final long wzT = 8;
    final long wzU = 9;
    final long wzV = 6;
    final long wzW = 7;
    boolean wzX;
    private boolean wzY;
    String wzZ = "";

    private final FinderLivePostBtnUIC dIC() {
        AppMethodBeat.i(255934);
        FinderLivePostBtnUIC finderLivePostBtnUIC = (FinderLivePostBtnUIC) this.vaj.getValue();
        AppMethodBeat.o(255934);
        return finderLivePostBtnUIC;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class aa<T> implements Observer<h.a> {
        final /* synthetic */ FinderSelfUIC wAi;

        aa(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            boolean z;
            Integer num;
            com.tencent.mm.plugin.finder.extension.reddot.k kVar;
            bbn bbn;
            com.tencent.mm.plugin.finder.extension.reddot.k kVar2;
            bbn bbn2;
            com.tencent.mm.plugin.finder.extension.reddot.k kVar3;
            AppMethodBeat.i(255924);
            h.a aVar2 = aVar;
            StringBuilder sb = new StringBuilder("[finderMessage] red=");
            if (aVar2 == null || !aVar2.dEF) {
                z = false;
            } else {
                z = true;
            }
            StringBuilder append = sb.append(z).append(" ctrlType=");
            if (aVar2 == null || (kVar3 = aVar2.tKT) == null) {
                num = null;
            } else {
                num = Integer.valueOf(kVar3.field_ctrInfo.type);
            }
            Log.i("SimpleUIComponent", append.append(num).toString());
            if (aVar2 != null && (kVar2 = aVar2.tKT) != null && kVar2.field_ctrInfo.type == 1007 && aVar2.dEF) {
                View findViewById = this.wAi.findViewById(R.id.d3h);
                kotlin.g.b.p.g(findViewById, "findViewById<View>(R.id.finder_send_msg_redot)");
                findViewById.setVisibility(8);
                View findViewById2 = this.wAi.findViewById(R.id.cmb);
                kotlin.g.b.p.g(findViewById2, "findViewById<View>(R.id.finder_hello_msg_redot)");
                findViewById2.setVisibility(0);
                com.tencent.mm.plugin.finder.extension.reddot.k kVar4 = aVar2.tKT;
                bdo atl = kVar4.atl("finder_private_msg_entrance");
                if (atl != null) {
                    String str = kVar4.field_ctrInfo.LKM;
                    if (str == null) {
                        str = "";
                    }
                    kotlin.g.b.p.g(str, "ctrlInfo.field_ctrInfo.tips_id ?: \"\"");
                    if (!kotlin.g.b.p.j(str, this.wAi.wAa)) {
                        FinderSelfUIC finderSelfUIC = this.wAi;
                        kotlin.g.b.p.h(str, "<set-?>");
                        finderSelfUIC.wAa = str;
                        com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                        if (fH != null) {
                            bbn2 = fH.dIx();
                        } else {
                            bbn2 = null;
                        }
                        com.tencent.mm.plugin.finder.report.j.a("4", kVar4, atl, 1, bbn2, 0, 0, 96);
                        AppMethodBeat.o(255924);
                        return;
                    }
                }
            } else if (aVar2 == null || (kVar = aVar2.tKT) == null || kVar.field_ctrInfo.type != 1006 || !aVar2.dEF) {
                View findViewById3 = this.wAi.findViewById(R.id.d3h);
                kotlin.g.b.p.g(findViewById3, "findViewById<View>(R.id.finder_send_msg_redot)");
                findViewById3.setVisibility(8);
                View findViewById4 = this.wAi.findViewById(R.id.cmb);
                kotlin.g.b.p.g(findViewById4, "findViewById<View>(R.id.finder_hello_msg_redot)");
                findViewById4.setVisibility(8);
            } else {
                View findViewById5 = this.wAi.findViewById(R.id.cmb);
                kotlin.g.b.p.g(findViewById5, "findViewById<View>(R.id.finder_hello_msg_redot)");
                findViewById5.setVisibility(8);
                bdo bdo = aVar2.tKS;
                int i2 = bdo != null ? bdo.count : 0;
                if (i2 > 0) {
                    View findViewById6 = this.wAi.findViewById(R.id.d3h);
                    kotlin.g.b.p.g(findViewById6, "findViewById<View>(R.id.finder_send_msg_redot)");
                    findViewById6.setVisibility(0);
                    View findViewById7 = this.wAi.findViewById(R.id.d3h);
                    kotlin.g.b.p.g(findViewById7, "findViewById<TextView>(R.id.finder_send_msg_redot)");
                    ((TextView) findViewById7).setText(i2 > 999 ? "999+" : String.valueOf(i2));
                    ((TextView) this.wAi.findViewById(R.id.d3h)).setBackgroundResource(com.tencent.mm.ui.tools.v.aQ(this.wAi.getContext(), i2));
                    ((TextView) this.wAi.findViewById(R.id.d3h)).setTextSize(0, com.tencent.mm.cb.a.ji(this.wAi.getContext()) * ((float) com.tencent.mm.cb.a.aH(this.wAi.getContext(), R.dimen.ane)));
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                    kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                    bdo asW = ((PluginFinder) ah).getRedDotManager().asW("finder_private_msg_entrance");
                    com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                    kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                    com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("finder_private_msg_entrance");
                    if (!(asW == null || asX == null)) {
                        String str2 = asX.field_ctrInfo.LKM;
                        if (str2 == null) {
                            str2 = "";
                        }
                        kotlin.g.b.p.g(str2, "ctrlInfo.field_ctrInfo.tips_id ?: \"\"");
                        if (!kotlin.g.b.p.j(str2, this.wAi.wzZ)) {
                            FinderSelfUIC finderSelfUIC2 = this.wAi;
                            kotlin.g.b.p.h(str2, "<set-?>");
                            finderSelfUIC2.wzZ = str2;
                            com.tencent.mm.plugin.finder.report.j jVar2 = com.tencent.mm.plugin.finder.report.j.vft;
                            FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wAi.getActivity());
                            if (fH2 != null) {
                                bbn = fH2.dIx();
                            } else {
                                bbn = null;
                            }
                            com.tencent.mm.plugin.finder.report.j.a("4", asX, asW, 1, bbn, 0, 0, 96);
                            AppMethodBeat.o(255924);
                            return;
                        }
                    }
                } else {
                    View findViewById8 = this.wAi.findViewById(R.id.d3h);
                    kotlin.g.b.p.g(findViewById8, "findViewById<View>(R.id.finder_send_msg_redot)");
                    findViewById8.setVisibility(8);
                    Log.e("SimpleUIComponent", "LOCAL_FINDER_MESSAGE is show,but count is zero.");
                    com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class);
                    kotlin.g.b.p.g(ah3, "MMKernel.plugin(IPluginFinder::class.java)");
                    ((com.tencent.mm.plugin.i.a.aj) ah3).getRedDotManager().asV("finder_private_msg_entrance");
                    AppMethodBeat.o(255924);
                    return;
                }
            }
            AppMethodBeat.o(255924);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class ab<T> implements Observer<h.a> {
        final /* synthetic */ FinderSelfUIC wAi;

        ab(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            int i2;
            AppMethodBeat.i(255925);
            h.a aVar2 = aVar;
            Log.i("SimpleUIComponent", "[finderWxMessage] red=" + (aVar2 != null && aVar2.dEF));
            if (aVar2 == null || !aVar2.dEF) {
                View findViewById = this.wAi.findViewById(R.id.d4b);
                kotlin.g.b.p.g(findViewById, "findViewById<View>(R.id.finder_wx_private_msg_tv)");
                findViewById.setVisibility(8);
            } else {
                bdo bdo = aVar2.tKS;
                if (bdo != null) {
                    i2 = bdo.count;
                } else {
                    i2 = 0;
                }
                if (i2 > 0) {
                    View findViewById2 = this.wAi.findViewById(R.id.d4b);
                    kotlin.g.b.p.g(findViewById2, "findViewById<View>(R.id.finder_wx_private_msg_tv)");
                    findViewById2.setVisibility(0);
                    View findViewById3 = this.wAi.findViewById(R.id.d4b);
                    kotlin.g.b.p.g(findViewById3, "findViewById<TextView>(R…finder_wx_private_msg_tv)");
                    ((TextView) findViewById3).setText(i2 > 999 ? "999+" : String.valueOf(i2));
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                    kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                    bdo asW = ((PluginFinder) ah).getRedDotManager().asW("finder_wx_private_msg_entrance");
                    com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                    kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                    com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("finder_wx_private_msg_entrance");
                    if (!(asW == null || asX == null)) {
                        String str = asX.field_ctrInfo.LKM;
                        if (str == null) {
                            str = "";
                        }
                        kotlin.g.b.p.g(str, "ctrlInfo.field_ctrInfo.tips_id ?: \"\"");
                        if (!kotlin.g.b.p.j(str, this.wAi.wAb)) {
                            FinderSelfUIC finderSelfUIC = this.wAi;
                            kotlin.g.b.p.h(str, "<set-?>");
                            finderSelfUIC.wAb = str;
                            com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                            com.tencent.mm.plugin.finder.report.j.a("4", asX, asW, 1, fH != null ? fH.dIx() : null, 0, 0, 96);
                            AppMethodBeat.o(255925);
                            return;
                        }
                    }
                } else {
                    View findViewById4 = this.wAi.findViewById(R.id.d4b);
                    kotlin.g.b.p.g(findViewById4, "findViewById<View>(R.id.finder_wx_private_msg_tv)");
                    findViewById4.setVisibility(8);
                    AppMethodBeat.o(255925);
                    return;
                }
            }
            AppMethodBeat.o(255925);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice;", "invoke"})
    static final class ai extends kotlin.g.b.q implements kotlin.g.a.r<Integer, Integer, String, au, kotlin.x> {
        final /* synthetic */ FinderSelfUIC wAi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ai(FinderSelfUIC finderSelfUIC) {
            super(4);
            this.wAi = finderSelfUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ kotlin.x invoke(Integer num, Integer num2, String str, au auVar) {
            awt awt;
            byte[] bArr;
            awt awt2;
            int i2;
            AppMethodBeat.i(255932);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            au auVar2 = auVar;
            if (intValue == 0 && intValue2 == 0) {
                apz cYf = auVar2 != null ? auVar2.cYf() : null;
                if (cYf != null) {
                    awt = cYf.live_notice_info;
                } else {
                    awt = null;
                }
                if (awt != null) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    s.ab abVar = s.ab.LIVE_CREATE_BOOK_SUCC;
                    awt awt3 = cYf.live_notice_info;
                    if (awt3 != null) {
                        i2 = awt3.dvv;
                    } else {
                        i2 = 0;
                    }
                    com.tencent.mm.plugin.finder.report.live.k.a(abVar, String.valueOf(((long) i2) * 1000));
                }
                Intent intent = new Intent();
                intent.putExtra("finder_username", com.tencent.mm.model.z.aUg());
                intent.putExtra("KEY_FINDER_SELF_FLAG", true);
                if (cYf == null || (awt2 = cYf.live_notice_info) == null) {
                    bArr = null;
                } else {
                    bArr = awt2.toByteArray();
                }
                intent.putExtra("KEY_FINDER_LIVE_NOTICE_INFO", bArr);
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC.a.a(this.wAi.getActivity(), intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(this.wAi.getActivity(), intent);
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(s.ab.LIVE_JUMP_PROFILE_PAGE, "");
            } else {
                com.tencent.mm.ui.base.u.u(this.wAi.getActivity(), this.wAi.getActivity().getResources().getString(R.string.cxy), R.raw.icons_filled_close);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(255932);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    public static final class e<T> implements Observer<h.a> {
        final /* synthetic */ FinderSelfUIC wAi;

        e(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            boolean z;
            AppMethodBeat.i(255901);
            h.a aVar2 = aVar;
            StringBuilder sb = new StringBuilder("[SHOW NEW] red=");
            if (aVar2 == null || !aVar2.dEF) {
                z = false;
            } else {
                z = true;
            }
            Log.i("SimpleUIComponent", sb.append(z).toString());
            if (aVar2 == null || !aVar2.dEF) {
                FinderSelfUIC.h(this.wAi).setVisibility(8);
                AppMethodBeat.o(255901);
                return;
            }
            FinderSelfUIC.h(this.wAi).setVisibility(0);
            AppMethodBeat.o(255901);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    public static final class f<T> implements Observer<h.a> {
        final /* synthetic */ FinderSelfUIC wAi;

        f(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            String str;
            AppMethodBeat.i(261569);
            final h.a aVar2 = aVar;
            if (aVar2 != null && aVar2.dEF) {
                String aUg = com.tencent.mm.model.z.aUg();
                if (aUg == null || aUg.length() == 0) {
                    View findViewById = this.wAi.findViewById(R.id.gy5);
                    kotlin.g.b.p.g(findViewById, "findViewById<View>(R.id.red_pack)");
                    com.tencent.mm.view.f.a(findViewById, new e.b(this) {
                        /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderSelfUIC.f.AnonymousClass1 */
                        final /* synthetic */ f UVQ;

                        /* JADX WARN: Incorrect args count in method signature: ()V */
                        {
                            this.UVQ = r1;
                        }

                        @Override // com.tencent.mm.view.e.b
                        public final void p(View view, boolean z) {
                            AppMethodBeat.i(261567);
                            kotlin.g.b.p.h(view, "view");
                            if (z) {
                                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                                com.tencent.mm.plugin.finder.report.k.dC(1, "");
                                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                                kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                                bdo asW = ((PluginFinder) ah).getRedDotManager().asW("CreateFinderEntrance");
                                com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                                kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                                com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("CreateFinderEntrance");
                                if (!(asX == null || asW == null)) {
                                    com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.UVQ.wAi.getActivity());
                                    com.tencent.mm.plugin.finder.report.j.a("4", asX, asW, 1, fH != null ? fH.dIx() : null, 0, 0, 96);
                                }
                            }
                            AppMethodBeat.o(261567);
                        }
                    });
                    View findViewById2 = this.wAi.findViewById(R.id.gy5);
                    kotlin.g.b.p.g(findViewById2, "findViewById<View>(R.id.red_pack)");
                    findViewById2.setVisibility(0);
                    View findViewById3 = this.wAi.findViewById(R.id.gy6);
                    kotlin.g.b.p.g(findViewById3, "findViewById<TextView>(R.id.red_pack_text)");
                    TextView textView = (TextView) findViewById3;
                    bdo bdo = aVar2.tKS;
                    textView.setText((bdo == null || (str = bdo.title) == null) ? "" : str);
                    this.wAi.findViewById(R.id.gy5).setOnClickListener(new View.OnClickListener(this) {
                        /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderSelfUIC.f.AnonymousClass2 */
                        final /* synthetic */ f UVQ;

                        {
                            this.UVQ = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.finder.extension.reddot.k kVar;
                            bbj bbj;
                            com.tencent.mm.bw.b bVar;
                            AppMethodBeat.i(261568);
                            com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
                            bVar2.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButNoAccountUi$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar2.axR());
                            h.a aVar = aVar2;
                            if (!(aVar == null || (kVar = aVar.tKT) == null || (bbj = kVar.tLm) == null || (bVar = bbj.VjF) == null)) {
                                fhn fhn = new fhn();
                                fhn.parseFrom(bVar.toByteArray());
                                String str = fhn.VjW;
                                String str2 = fhn.KDW;
                                if (!(str == null || str2 == null)) {
                                    com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                                    int i2 = fhn.KDY;
                                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                                    com.tencent.mm.plugin.finder.utils.a.a(this.UVQ.wAi.getContext(), str, str2, i2, "", (Boolean) com.tencent.mm.plugin.finder.storage.c.hVg().value());
                                }
                                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                                com.tencent.mm.plugin.finder.report.k.dC(2, "");
                            }
                            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                            bdo asW = ((PluginFinder) ah).getRedDotManager().asW("CreateFinderEntrance");
                            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                            kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("CreateFinderEntrance");
                            if (!(asX == null || asW == null)) {
                                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                                FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.UVQ.wAi.getActivity());
                                com.tencent.mm.plugin.finder.report.j.a("4", asX, asW, 2, fH != null ? fH.dIx() : null, 0, 0, 96);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButNoAccountUi$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(261568);
                        }
                    });
                    AppMethodBeat.o(261569);
                    return;
                }
            }
            View findViewById4 = this.wAi.findViewById(R.id.gy5);
            kotlin.g.b.p.g(findViewById4, "findViewById<View>(R.id.red_pack)");
            findViewById4.setVisibility(8);
            AppMethodBeat.o(261569);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    public static final class n<T> implements Observer<h.a> {
        final /* synthetic */ FinderSelfUIC wAi;
        final /* synthetic */ com.tencent.mm.plugin.finder.extension.reddot.k wAl;
        final /* synthetic */ bdo wAm;

        n(FinderSelfUIC finderSelfUIC, com.tencent.mm.plugin.finder.extension.reddot.k kVar, bdo bdo) {
            this.wAi = finderSelfUIC;
            this.wAl = kVar;
            this.wAm = bdo;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            String str;
            bbi bbi;
            AppMethodBeat.i(255911);
            h.a aVar2 = aVar;
            if (aVar2 == null || !aVar2.dEF) {
                TextView textView = this.wAi.wzM;
                if (textView != null) {
                    textView.setVisibility(8);
                    AppMethodBeat.o(255911);
                    return;
                }
            } else {
                TextView textView2 = this.wAi.wzM;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                com.tencent.mm.plugin.finder.extension.reddot.k kVar = this.wAl;
                if (kVar == null || (bbi = kVar.field_ctrInfo) == null || (str = bbi.LKM) == null) {
                    str = "";
                }
                kotlin.g.b.p.g(str, "ctrInfo?.field_ctrInfo?.tips_id ?: \"\"");
                if (!kotlin.g.b.p.j(str, this.wAi.wAd)) {
                    FinderSelfUIC finderSelfUIC = this.wAi;
                    kotlin.g.b.p.h(str, "<set-?>");
                    finderSelfUIC.wAd = str;
                    com.tencent.mm.plugin.finder.extension.reddot.k kVar2 = this.wAl;
                    bdo bdo = this.wAm;
                    if (!(kVar2 == null || bdo == null)) {
                        com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                        com.tencent.mm.plugin.finder.report.j.a("4", kVar2, bdo, 1, fH != null ? fH.dIx() : null, 0, 0, 96);
                        AppMethodBeat.o(255911);
                        return;
                    }
                }
            }
            AppMethodBeat.o(255911);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class q<T> implements Observer<h.a> {
        final /* synthetic */ FinderSelfUIC wAi;

        q(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            String str;
            bbn bbn;
            bbi bbi;
            bdo bdo;
            String str2;
            TextView textView;
            String str3;
            int i2;
            int i3 = 4;
            AppMethodBeat.i(255914);
            h.a aVar2 = aVar;
            Log.i("SimpleUIComponent", "original finderProfileSetting");
            View findViewById = this.wAi.findViewById(R.id.d3e);
            TextView textView2 = (TextView) this.wAi.findViewById(R.id.d3f);
            if (findViewById != null) {
                if (aVar2 == null || !aVar2.dEF) {
                    i2 = 4;
                } else {
                    i2 = 0;
                }
                findViewById.setVisibility(i2);
            }
            if (textView2 != null) {
                if (aVar2 != null) {
                    if (aVar2.dEF) {
                        bdo bdo2 = aVar2.tKS;
                        if (bdo2 == null || (str3 = bdo2.title) == null) {
                            textView = textView2;
                        } else {
                            if (str3.length() > 0) {
                                i3 = 0;
                                textView = textView2;
                            }
                        }
                    }
                    textView = textView2;
                } else {
                    textView = textView2;
                }
                textView.setVisibility(i3);
            }
            if (textView2 != null) {
                textView2.setText((aVar2 == null || (bdo = aVar2.tKS) == null || (str2 = bdo.title) == null) ? "" : str2);
            }
            if (aVar2 != null) {
                if (aVar2.dEF) {
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                    kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                    bdo asW = ((PluginFinder) ah).getRedDotManager().asW("ProfileEntrance");
                    com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                    kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                    com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("ProfileEntrance");
                    if (asX == null || (bbi = asX.field_ctrInfo) == null || (str = bbi.LKM) == null) {
                        str = "";
                    }
                    kotlin.g.b.p.g(str, "ctrInfo?.field_ctrInfo?.tips_id ?: \"\"");
                    if (!kotlin.g.b.p.j(str, this.wAi.wAc)) {
                        FinderSelfUIC finderSelfUIC = this.wAi;
                        kotlin.g.b.p.h(str, "<set-?>");
                        finderSelfUIC.wAc = str;
                        if (!(asX == null || asW == null)) {
                            com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                            if (fH != null) {
                                bbn = fH.dIx();
                            } else {
                                bbn = null;
                            }
                            com.tencent.mm.plugin.finder.report.j.a("4", asX, asW, 1, bbn, 0, 0, 96);
                        }
                    }
                }
                AppMethodBeat.o(255914);
                return;
            }
            AppMethodBeat.o(255914);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class s<T> implements Observer<h.a> {
        final /* synthetic */ FinderSelfUIC wAi;

        s(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            String str;
            Integer num;
            bbi bbi;
            Integer num2 = null;
            AppMethodBeat.i(255916);
            h.a aVar2 = aVar;
            View findViewById = this.wAi.findViewById(R.id.bi_);
            Log.i("SimpleUIComponent", "finderCreatorEntrance, reddot show:" + (aVar2 != null ? Boolean.valueOf(aVar2.dEF) : null));
            if (aVar2 == null || !aVar2.dEF) {
                kotlin.g.b.p.g(findViewById, "dotView");
                findViewById.setVisibility(8);
                AppMethodBeat.o(255916);
                return;
            }
            kotlin.g.b.p.g(findViewById, "dotView");
            findViewById.setVisibility(0);
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah).getRedDotManager().asW("CreatorCenter");
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("CreatorCenter");
            if (asX == null || (bbi = asX.field_ctrInfo) == null || (str = bbi.LKM) == null) {
                str = "";
            }
            kotlin.g.b.p.g(str, "ctrInfo?.field_ctrInfo?.tips_id ?: \"\"");
            if (!kotlin.g.b.p.j(str, this.wAi.wAe)) {
                FinderSelfUIC finderSelfUIC = this.wAi;
                kotlin.g.b.p.h(str, "<set-?>");
                finderSelfUIC.wAe = str;
                if (!(asX == null || asW == null)) {
                    com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                    FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                    com.tencent.mm.plugin.finder.report.j.a("4", asX, asW, 1, fH != null ? fH.dIx() : null, 0, 0, 96);
                }
            }
            StringBuilder sb = new StringBuilder("finderCreatorEntrance, showtype:");
            if (asW != null) {
                num = Integer.valueOf(asW.xGz);
            } else {
                num = null;
            }
            Log.i("SimpleUIComponent", sb.append(num).append(",title:").append(asW != null ? asW.title : null).toString());
            if (asW != null) {
                num2 = Integer.valueOf(asW.xGz);
            }
            if (num2 != null && num2.intValue() == 1) {
                View findViewById2 = this.wAi.findViewById(R.id.bi9);
                kotlin.g.b.p.g(findViewById2, "findViewById<View>(R.id.…tor_entrance_title_redot)");
                findViewById2.setVisibility(8);
                View findViewById3 = this.wAi.findViewById(R.id.bi8);
                kotlin.g.b.p.g(findViewById3, "findViewById<View>(R.id.creator_entrance_redot)");
                findViewById3.setVisibility(0);
                AppMethodBeat.o(255916);
            } else if (num2 != null && num2.intValue() == 17) {
                View findViewById4 = this.wAi.findViewById(R.id.bi9);
                kotlin.g.b.p.g(findViewById4, "findViewById<View>(R.id.…tor_entrance_title_redot)");
                findViewById4.setVisibility(0);
                View findViewById5 = this.wAi.findViewById(R.id.bi8);
                kotlin.g.b.p.g(findViewById5, "findViewById<View>(R.id.creator_entrance_redot)");
                findViewById5.setVisibility(8);
                View findViewById6 = this.wAi.findViewById(R.id.bi9);
                kotlin.g.b.p.g(findViewById6, "findViewById<TextView>(R…tor_entrance_title_redot)");
                TextView textView = (TextView) findViewById6;
                String str2 = asW.title;
                textView.setText(str2 != null ? str2 : "");
                AppMethodBeat.o(255916);
            } else if (num2 == null) {
                AppMethodBeat.o(255916);
            } else if (num2.intValue() == 3) {
                View findViewById7 = this.wAi.findViewById(R.id.bi9);
                kotlin.g.b.p.g(findViewById7, "findViewById<View>(R.id.…tor_entrance_title_redot)");
                findViewById7.setVisibility(0);
                View findViewById8 = this.wAi.findViewById(R.id.bi8);
                kotlin.g.b.p.g(findViewById8, "findViewById<View>(R.id.creator_entrance_redot)");
                findViewById8.setVisibility(0);
                View findViewById9 = this.wAi.findViewById(R.id.bi9);
                kotlin.g.b.p.g(findViewById9, "findViewById<TextView>(R…tor_entrance_title_redot)");
                TextView textView2 = (TextView) findViewById9;
                String str3 = asW.title;
                textView2.setText(str3 != null ? str3 : "");
                AppMethodBeat.o(255916);
            } else {
                AppMethodBeat.o(255916);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class y<T> implements Observer<h.a> {
        final /* synthetic */ FinderSelfUIC wAi;

        y(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            String str;
            String str2;
            AppMethodBeat.i(255922);
            h.a aVar2 = aVar;
            Log.i("SimpleUIComponent", "[SHOW first_fav] red=" + (aVar2 != null && aVar2.dEF));
            if (aVar2 == null || !aVar2.dEF) {
                View findViewById = this.wAi.findViewById(R.id.cm7);
                kotlin.g.b.p.g(findViewById, "findViewById<View>(R.id.finder_first_fav)");
                findViewById.setVisibility(8);
            } else {
                View findViewById2 = this.wAi.findViewById(R.id.cm7);
                kotlin.g.b.p.g(findViewById2, "findViewById<View>(R.id.finder_first_fav)");
                findViewById2.setVisibility(0);
                com.tencent.mm.plugin.finder.extension.reddot.k kVar = aVar2.tKT;
                if (kVar == null || (str2 = kVar.field_tipsId) == null) {
                    str = "";
                } else {
                    str = str2;
                }
                if (!kotlin.g.b.p.j(str, this.wAi.wAh)) {
                    com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                    FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                    com.tencent.mm.plugin.finder.report.k.a("4", 6, 1, 0, 0, 0, (String) null, (String) null, 0, fH != null ? fH.dIx() : null, 0, 0, 3520);
                    this.wAi.wAh = str;
                    com.tencent.mm.plugin.finder.extension.reddot.k kVar3 = aVar2.tKT;
                    bdo bdo = aVar2.tKS;
                    if (!(kVar3 == null || bdo == null)) {
                        com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                        FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wAi.getActivity());
                        com.tencent.mm.plugin.finder.report.j.a("4", kVar3, bdo, 1, fH2 != null ? fH2.dIx() : null, 0, 0, 96);
                        AppMethodBeat.o(255922);
                        return;
                    }
                }
            }
            AppMethodBeat.o(255922);
        }
    }

    public static final /* synthetic */ FinderLivePostBtnUIC c(FinderSelfUIC finderSelfUIC) {
        AppMethodBeat.i(255951);
        FinderLivePostBtnUIC dIC = finderSelfUIC.dIC();
        AppMethodBeat.o(255951);
        return dIC;
    }

    public static final /* synthetic */ long dII() {
        AppMethodBeat.i(255950);
        long dIH = dIH();
        AppMethodBeat.o(255950);
        return dIH;
    }

    public static final /* synthetic */ void e(FinderSelfUIC finderSelfUIC) {
        AppMethodBeat.i(255952);
        finderSelfUIC.det();
        AppMethodBeat.o(255952);
    }

    public static final /* synthetic */ View g(FinderSelfUIC finderSelfUIC) {
        AppMethodBeat.i(255953);
        View view = finderSelfUIC.wzH;
        if (view == null) {
            kotlin.g.b.p.btv("finderPosBtn");
        }
        AppMethodBeat.o(255953);
        return view;
    }

    public static final /* synthetic */ TextView h(FinderSelfUIC finderSelfUIC) {
        AppMethodBeat.i(255954);
        TextView textView = finderSelfUIC.wzJ;
        if (textView == null) {
            kotlin.g.b.p.btv("finderCanPostNoContact");
        }
        AppMethodBeat.o(255954);
        return textView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderSelfUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255949);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wAg = com.tencent.mm.plugin.finder.storage.c.dtG().value().intValue() > 0;
        this.vaj = kotlin.g.ah(new ac(this));
        this.wAh = "";
        AppMethodBeat.o(255949);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.ajs;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0403  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x042a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x042d  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0445  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0448  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x044b  */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r19) {
        /*
        // Method dump skipped, instructions count: 1102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderSelfUIC.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        int i4;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        AppMethodBeat.i(255936);
        if (intent != null) {
            FinderSelfUI.a aVar = FinderSelfUI.vOh;
            i4 = intent.getIntExtra(FinderSelfUI.vOe, 0);
        } else {
            i4 = 0;
        }
        FinderSelfUI.a aVar2 = FinderSelfUI.vOh;
        if (i2 == FinderSelfUI.vOc) {
            bed bed = this.udb;
            if (bed != null && bed.LNS == i4) {
                z4 = true;
            }
            z2 = true;
            z3 = z4;
        } else {
            FinderSelfUI.a aVar3 = FinderSelfUI.vOh;
            if (i2 == FinderSelfUI.vOd) {
                bed bed2 = this.udb;
                if (bed2 != null && bed2.LNR == i4) {
                    z4 = true;
                }
                z2 = z4;
                z3 = true;
            } else {
                if (i2 == 10001 || i2 == 10000) {
                    com.tencent.mm.ui.widget.a.e eVar = this.wyl;
                    if (eVar != null) {
                        eVar.bMo();
                    }
                    com.tencent.mm.plugin.finder.ui.g gVar = this.wzG;
                    if (gVar != null) {
                        Log.i(gVar.TAG, "onActivityResult,requestCode:" + i2 + ",resultCode:" + i3 + ",face verify result:" + (intent != null ? Integer.valueOf(intent.getIntExtra("FACE_VERIFY_RESULT", 0)) : null));
                        if (i2 == 10000 && i3 == -1) {
                            if (intent == null) {
                                z2 = true;
                                z3 = true;
                            } else if (intent.getIntExtra("FACE_VERIFY_RESULT", 0) == 1) {
                                gVar.b((aqb) null);
                            }
                        }
                        z2 = true;
                        z3 = true;
                    }
                }
                z2 = true;
                z3 = true;
            }
        }
        if (!z3 || !z2) {
            Log.i("SimpleUIComponent", "ifFavCountEquals = " + z3 + ",ifLikeCountEquals = " + z2);
            doPrepareUser();
        }
        AppMethodBeat.o(255936);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(255937);
        kotlin.g.b.p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        kotlin.g.b.p.h(iArr, "grantResults");
        com.tencent.mm.plugin.finder.ui.g gVar = this.wzG;
        if (gVar != null) {
            kotlin.g.b.p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
            kotlin.g.b.p.h(iArr, "grantResults");
            if (i2 == 16 || i2 == 80) {
                if (iArr.length == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    z3 = false;
                }
                if (!z3 || iArr[0] != 0) {
                    Log.i(gVar.TAG, "FinderLive request permission " + i2 + " failed");
                } else {
                    gVar.c(gVar.vKV);
                    AppMethodBeat.o(255937);
                    return;
                }
            }
            AppMethodBeat.o(255937);
            return;
        }
        AppMethodBeat.o(255937);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class p implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        p(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255913);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(this.wAi.getActivity(), intent, 0, 0, false, 124);
            intent.setClass(this.wAi.getActivity(), FinderFollowListUI.class);
            AppCompatActivity activity = this.wAi.getActivity();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a((Context) this.wAi.getActivity(), this.wAi.sTp, this.wAi.wzX, 2L, this.wAi.wzO, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255913);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class u implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        u(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            long j2 = 0;
            AppMethodBeat.i(255918);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(this.wAi.getActivity(), intent, 0, 0, false, 124);
            intent.setClass(this.wAi.getActivity(), FinderLikeFeedGridUI.class);
            intent.putExtra("finder_username", com.tencent.mm.model.z.aUg());
            AppCompatActivity activity = this.wAi.getActivity();
            FinderSelfUI.a aVar2 = FinderSelfUI.vOh;
            activity.startActivityForResult(intent, FinderSelfUI.vOd);
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            AppCompatActivity activity2 = this.wAi.getActivity();
            long j3 = this.wAi.sTp;
            boolean z = this.wAi.wzX;
            long j4 = this.wAi.wzP;
            bed bed = this.wAi.udb;
            if (bed != null) {
                j2 = (long) bed.LNR;
            }
            com.tencent.mm.plugin.finder.report.k.a((Context) activity2, j3, z, 2L, j4, false, j2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255918);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class v implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        v(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            long j2;
            AppMethodBeat.i(255919);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah).getRedDotManager().asW("Personal_Center_FavList_Entrance");
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("Personal_Center_FavList_Entrance");
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!(asW == null || asX == null)) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                com.tencent.mm.plugin.finder.report.k.a("4", 6, 2, 0, 0, 0, (String) null, (String) null, 0, fH != null ? fH.dIx() : null, 0, 0, 3520);
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wAi.getActivity());
                com.tencent.mm.plugin.finder.report.j.a("4", asX, asW, 2, fH2 != null ? fH2.dIx() : null, 0, 0, 96);
            }
            com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class);
            kotlin.g.b.p.g(ah3, "MMKernel.plugin(IPluginFinder::class.java)");
            ((com.tencent.mm.plugin.i.a.aj) ah3).getRedDotManager().asV("Personal_Center_FavList_Entrance");
            Intent intent = new Intent();
            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(this.wAi.getActivity(), intent, 0, 0, false, 124);
            com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
            AppCompatActivity activity = this.wAi.getActivity();
            if (activity == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255919);
                throw tVar;
            }
            FinderSelfUI.a aVar5 = FinderSelfUI.vOh;
            com.tencent.mm.plugin.finder.utils.a.b((MMActivity) activity, intent, FinderSelfUI.vOc);
            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
            AppCompatActivity activity2 = this.wAi.getActivity();
            long j3 = this.wAi.sTp;
            boolean z = this.wAi.wzX;
            long j4 = this.wAi.wzQ;
            bed bed = this.wAi.udb;
            if (bed != null) {
                j2 = (long) bed.LNS;
            } else {
                j2 = 0;
            }
            com.tencent.mm.plugin.finder.report.k.a((Context) activity2, j3, z, 2L, j4, false, j2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255919);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class w implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        w(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255920);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fB(this.wAi.getActivity());
            long dII = FinderSelfUIC.dII();
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(this.wAi.getActivity(), this.wAi.sTp, this.wAi.wzX, 2, this.wAi.wzW, dII > 0, dII);
            com.tencent.mm.plugin.finder.report.d dVar = com.tencent.mm.plugin.finder.report.d.vdp;
            com.tencent.mm.plugin.finder.report.d.dnF().R(2, 0);
            com.tencent.mm.plugin.finder.report.d dVar2 = com.tencent.mm.plugin.finder.report.d.vdp;
            com.tencent.mm.plugin.finder.report.d.dnJ().vdE = FinderSelfUIC.dII();
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah).getRedDotManager().asW("finder_wx_private_msg_entrance");
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("finder_wx_private_msg_entrance");
            if (!(asW == null || asX == null)) {
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                com.tencent.mm.plugin.finder.report.j.a("4", asX, asW, 3, fH != null ? fH.dIx() : null, 0, 0, 96);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255920);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class x implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        x(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255921);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fu(this.wAi.getActivity());
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a((Context) this.wAi.getActivity(), this.wAi.sTp, this.wAi.wzX, 2L, this.wAi.wzR, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255921);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class z implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        z(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            bbn bbn;
            AppMethodBeat.i(255923);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah).getRedDotManager().asX("finder_private_msg_entrance");
            bdo atl = asX != null ? asX.atl("finder_private_msg_entrance") : null;
            if (asX != null && asX.field_ctrInfo.type == 1007) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a((Context) this.wAi.getActivity(), this.wAi.sTp, this.wAi.wzX, 2L, this.wAi.wzV, true, 0L);
                if (atl != null) {
                    com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                    if (fH != null) {
                        bbn = fH.dIx();
                    } else {
                        bbn = null;
                    }
                    com.tencent.mm.plugin.finder.report.j.a("4", asX, atl, 2, bbn, 0, 0, 96);
                }
            } else if (asX == null || asX.field_ctrInfo.type != 1006) {
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a((Context) this.wAi.getActivity(), this.wAi.sTp, this.wAi.wzX, 2L, this.wAi.wzV, false, 0L);
            } else {
                int i2 = atl != null ? atl.count : 0;
                com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a((Context) this.wAi.getActivity(), this.wAi.sTp, this.wAi.wzX, 2L, this.wAi.wzV, true, (long) i2);
                if (atl != null) {
                    com.tencent.mm.plugin.finder.report.j jVar2 = com.tencent.mm.plugin.finder.report.j.vft;
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wAi.getActivity());
                    com.tencent.mm.plugin.finder.report.j.a("4", asX, atl, 3, fH2 != null ? fH2.dIx() : null, 0, 0, 96);
                }
            }
            com.tencent.mm.plugin.finder.report.d dVar = com.tencent.mm.plugin.finder.report.d.vdp;
            com.tencent.mm.plugin.finder.report.d.dnF().R(1, 0);
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class);
            kotlin.g.b.p.g(ah2, "MMKernel.plugin(IPluginFinder::class.java)");
            ((com.tencent.mm.plugin.i.a.aj) ah2).getRedDotManager().asV("finder_private_msg_entrance");
            ((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderConversationUI(this.wAi.getActivity());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255923);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class r implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        r(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255915);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fD(this.wAi.getActivity());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255915);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class t implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;
        final /* synthetic */ z.f wAn;

        t(FinderSelfUIC finderSelfUIC, z.f fVar) {
            this.wAi = finderSelfUIC;
            this.wAn = fVar;
        }

        public final void onClick(View view) {
            boolean z = false;
            AppMethodBeat.i(255917);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah).getRedDotManager().asW("CreatorCenter");
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("CreatorCenter");
            if (!(asX == null || asW == null)) {
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                com.tencent.mm.plugin.finder.report.j.a("4", asX, asW, 2, fH != null ? fH.dIx() : null, 0, 0, 96);
            }
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            Activity context = this.wAi.getContext();
            long j2 = this.wAi.sTp;
            boolean z2 = this.wAi.wzX;
            long j3 = this.wAi.wzT;
            if (asW != null) {
                z = true;
            }
            com.tencent.mm.plugin.finder.report.k.a(context, j2, z2, 2, j3, z);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", (String) this.wAn.SYG);
            com.tencent.mm.br.c.b(this.wAi.getActivity(), "webview", ".ui.tools.WebViewUI", intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255917);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0096, code lost:
        if (r4 == false) goto L_0x00bc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void dID() {
        /*
        // Method dump skipped, instructions count: 203
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderSelfUIC.dID():void");
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class l implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        l(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255909);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initLiveRewardGainCell$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ((com.tencent.mm.plugin.wallet.wecoin.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).bN(this.wAi.getActivity(), "");
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a((Context) this.wAi.getActivity(), this.wAi.sTp, false, 2L, this.wAi.wzU, false, 0L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initLiveRewardGainCell$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255909);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x01a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void dIE() {
        /*
        // Method dump skipped, instructions count: 421
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderSelfUIC.dIE():void");
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class m implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;
        final /* synthetic */ com.tencent.mm.plugin.finder.extension.reddot.k wAl;
        final /* synthetic */ bdo wAm;

        m(FinderSelfUIC finderSelfUIC, com.tencent.mm.plugin.finder.extension.reddot.k kVar, bdo bdo) {
            this.wAi = finderSelfUIC;
            this.wAl = kVar;
            this.wAm = bdo;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255910);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initPostBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderSelfUIC.c(this.wAi).dIn();
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().a(s.ao.FINDER_PROFILE);
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.q(s.a.PROFILE_LIVE_BTN_CLICK.hlf, "");
            TextView textView = this.wAi.wzM;
            if (textView != null) {
                textView.setVisibility(8);
            }
            com.tencent.mm.plugin.finder.extension.reddot.k kVar3 = this.wAl;
            bdo bdo = this.wAm;
            if (!(kVar3 == null || bdo == null)) {
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                com.tencent.mm.plugin.finder.report.j.a("4", kVar3, bdo, 2, fH != null ? fH.dIx() : null, 0, 0, 96);
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                ((PluginFinder) ah).getRedDotManager().asV("FinderSelfLiveEntrance");
                com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                ((PluginFinder) ah2).getRedDotManager().e("FinderEntrance", new int[]{1010});
                com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                kotlin.g.b.p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
                ((PluginFinder) ah3).getRedDotManager().e("TLPersonalCenter", new int[]{1010});
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initPostBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255910);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class o implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        o(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255912);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initPostBtn$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderSelfUIC.e(this.wAi);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$initPostBtn$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255912);
        }
    }

    private final void dIF() {
        String str;
        azn azn;
        azn azn2;
        bbn bbn;
        AppMethodBeat.i(255940);
        dID();
        dIE();
        this.wzE = com.tencent.mm.model.z.aUg();
        Log.i("SimpleUIComponent", "myFinderUser " + this.wzE);
        View findViewById = findViewById(R.id.dn7);
        View findViewById2 = findViewById(R.id.fzo);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        switch (com.tencent.mm.plugin.finder.utils.y.dCL()) {
            case 1:
                kotlin.g.b.p.g(findViewById, "hasContactContainer");
                kotlin.g.b.p.g(findViewById2, "noContactContainer");
                kotlin.g.b.p.h(findViewById, "hasContactContainer");
                kotlin.g.b.p.h(findViewById2, "noContactContainer");
                Log.d("SimpleUIComponent", "账户无发表权限");
                findViewById2.setVisibility(0);
                findViewById.setVisibility(8);
                break;
            case 2:
                kotlin.g.b.p.g(findViewById, "hasContactContainer");
                kotlin.g.b.p.g(findViewById2, "noContactContainer");
                kotlin.g.b.p.h(findViewById, "hasContactContainer");
                kotlin.g.b.p.h(findViewById2, "noContactContainer");
                Log.d("SimpleUIComponent", "有发表权限但未创建账号");
                findViewById2.setVisibility(8);
                findViewById.setVisibility(0);
                View findViewById3 = findViewById(R.id.fml);
                kotlin.g.b.p.g(findViewById3, "findViewById<View>(R.id.msg_ll)");
                findViewById3.setVisibility(8);
                View findViewById4 = findViewById(R.id.cj6);
                kotlin.g.b.p.g(findViewById4, "findViewById<View>(R.id.finder_account_area)");
                findViewById4.setVisibility(8);
                View findViewById5 = findViewById(R.id.hjv);
                kotlin.g.b.p.g(findViewById5, "findViewById<View>(R.id.sendMsgLayout)");
                findViewById5.setVisibility(8);
                z.a aVar = new z.a();
                Intent intent = getIntent();
                FinderSelfUI.a aVar2 = FinderSelfUI.vOh;
                aVar.SYB = intent.getBooleanExtra(FinderSelfUI.vOg, false);
                View view = this.wzH;
                if (view == null) {
                    kotlin.g.b.p.btv("finderPosBtn");
                }
                view.setOnClickListener(new c(this, aVar));
                if (aVar.SYB && this.udb != null) {
                    View view2 = this.wzH;
                    if (view2 == null) {
                        kotlin.g.b.p.btv("finderPosBtn");
                    }
                    view2.post(new d(this));
                    Intent intent2 = getIntent();
                    FinderSelfUI.a aVar3 = FinderSelfUI.vOh;
                    intent2.removeExtra(FinderSelfUI.vOg);
                }
                com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
                com.tencent.mm.plugin.finder.extension.reddot.h hVar2 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
                com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daL(), getActivity(), new e(this));
                View view3 = this.wzK;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                View findViewById6 = findViewById(R.id.ehc);
                kotlin.g.b.p.g(findViewById6, "findViewById<View>(R.id.live_income_ll)");
                findViewById6.setVisibility(8);
                com.tencent.mm.plugin.finder.extension.reddot.h hVar3 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
                com.tencent.mm.plugin.finder.extension.reddot.h hVar4 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
                com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.hSH(), getActivity(), new f(this));
                break;
            case 3:
            case 6:
                kotlin.g.b.p.g(findViewById, "hasContactContainer");
                kotlin.g.b.p.g(findViewById2, "noContactContainer");
                kotlin.g.b.p.h(findViewById, "hasContactContainer");
                kotlin.g.b.p.h(findViewById2, "noContactContainer");
                Log.d("SimpleUIComponent", "账户正常");
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class);
                kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
                ((com.tencent.mm.plugin.i.a.aj) ah).getRedDotManager().asV("TLCamera");
                findViewById2.setVisibility(8);
                findViewById.setVisibility(0);
                View findViewById7 = findViewById(R.id.cj6);
                View findViewById8 = findViewById(R.id.fml);
                ImageView imageView = (ImageView) findViewById(R.id.ckb);
                TextView textView = (TextView) findViewById(R.id.d0p);
                TextView textView2 = (TextView) findViewById(R.id.d0d);
                c.a aVar4 = com.tencent.mm.plugin.finder.api.c.tsp;
                String str2 = this.wzE;
                if (str2 == null) {
                    kotlin.g.b.p.hyc();
                }
                com.tencent.mm.plugin.finder.api.g asG = c.a.asG(str2);
                ImageView imageView2 = (ImageView) findViewById(R.id.w0);
                if (this.wAg) {
                    View findViewById9 = findViewById(R.id.hjv);
                    kotlin.g.b.p.g(findViewById9, "findViewById<View>(R.id.sendMsgLayout)");
                    findViewById9.setVisibility(0);
                } else {
                    View findViewById10 = findViewById(R.id.hjv);
                    kotlin.g.b.p.g(findViewById10, "findViewById<View>(R.id.sendMsgLayout)");
                    findViewById10.setVisibility(8);
                }
                if (asG != null) {
                    com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                    com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
                    com.tencent.mm.plugin.finder.loader.a aVar5 = new com.tencent.mm.plugin.finder.loader.a(asG.cXH());
                    kotlin.g.b.p.g(imageView, "finderAvatar");
                    com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                    dka.a(aVar5, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
                    kotlin.g.b.p.g(textView, "finderNickname");
                    textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getActivity(), asG.getNickname()));
                    ao.a(textView.getPaint(), 0.8f);
                    com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                    kotlin.g.b.p.g(imageView2, "authIcon");
                    com.tencent.mm.plugin.finder.utils.y.a(imageView2, asG.field_authInfo);
                    com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                    kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                    int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_FANS_COUNT_INT_SYNC, 0);
                    if (i2 > 0) {
                        View findViewById11 = findViewById(R.id.cm9);
                        kotlin.g.b.p.g(findViewById11, "findViewById<View>(R.id.finder_follow_count)");
                        findViewById11.setVisibility(0);
                        View findViewById12 = findViewById(R.id.cm9);
                        kotlin.g.b.p.g(findViewById12, "findViewById<TextView>(R.id.finder_follow_count)");
                        ((TextView) findViewById12).setText(getActivity().getResources().getString(R.string.cm9, String.valueOf(i2)));
                    } else {
                        View findViewById13 = findViewById(R.id.cm9);
                        kotlin.g.b.p.g(findViewById13, "findViewById<View>(R.id.finder_follow_count)");
                        findViewById13.setVisibility(8);
                    }
                }
                kotlin.g.b.p.g(findViewById7, "finderAccountArea");
                findViewById7.setVisibility(0);
                kotlin.g.b.p.g(findViewById8, "finderMsgArea");
                findViewById8.setVisibility(0);
                i.a aVar6 = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
                int[] dbo = i.a.dbo();
                int i3 = dbo[0];
                int i4 = dbo[1];
                int i5 = dbo[2];
                int i6 = dbo[3];
                Log.i("SimpleUIComponent", "redDot check likeCount :" + i3 + " commentCount " + i4 + " followCount " + i5 + ' ');
                findViewById7.setOnClickListener(new ad(this));
                com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("AuthorProfileNotify");
                com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                kotlin.g.b.p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
                bdo asW = ((PluginFinder) ah3).getRedDotManager().asW("AuthorProfileNotify");
                findViewById8.setOnClickListener(new ae(this, i6, asX, asW));
                if (i6 > 0) {
                    kotlin.g.b.p.g(textView2, "finderMsg");
                    textView2.setVisibility(0);
                    textView2.setText(i6 > 999 ? "999+" : String.valueOf(i6));
                    if (!this.wzF) {
                        this.wzF = true;
                        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                        int i7 = com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1 ? 0 : 2;
                        if (i6 > 0) {
                            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                            FinderReporterUIC.a aVar7 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH = FinderReporterUIC.a.fH(getActivity());
                            if (fH != null) {
                                bbn = fH.dIx();
                            } else {
                                bbn = null;
                            }
                            com.tencent.mm.plugin.finder.report.k.a("4", 1, 1, 5, i7, i6, (String) null, (String) null, 0, bbn, 0, 0, 3520);
                        }
                        if (!(asX == null || asW == null)) {
                            com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                            FinderReporterUIC.a aVar8 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(getActivity());
                            com.tencent.mm.plugin.finder.report.j.a("4", asX, asW, 1, fH2 != null ? fH2.dIx() : null, 0, 0, 96);
                        }
                    }
                } else {
                    kotlin.g.b.p.g(textView2, "finderMsg");
                    textView2.setVisibility(8);
                }
                View view4 = this.wzH;
                if (view4 == null) {
                    kotlin.g.b.p.btv("finderPosBtn");
                }
                view4.setOnClickListener(new af(this));
                View view5 = this.wzH;
                if (view5 == null) {
                    kotlin.g.b.p.btv("finderPosBtn");
                }
                view5.setVisibility(0);
                View view6 = this.wzK;
                if (view6 != null) {
                    view6.setVisibility(0);
                }
                Intent intent3 = getIntent();
                FinderSelfUI.a aVar9 = FinderSelfUI.vOh;
                if (intent3.getBooleanExtra(FinderSelfUI.vOg, false)) {
                    View view7 = this.wzH;
                    if (view7 == null) {
                        kotlin.g.b.p.btv("finderPosBtn");
                    }
                    view7.post(new ag(this));
                    Intent intent4 = getIntent();
                    FinderSelfUI.a aVar10 = FinderSelfUI.vOh;
                    intent4.removeExtra(FinderSelfUI.vOg);
                }
                if (!this.wzY) {
                    com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                    com.tencent.mm.plugin.finder.report.k.a(getActivity(), this.sTp, this.wzX, 1, this.wzS, i6 > 0, (long) i6);
                    this.wzY = true;
                }
                Log.i("SimpleUIComponent", "show finder msg red, totalCount:".concat(String.valueOf(i6)));
                break;
            case 4:
                kotlin.g.b.p.g(findViewById, "hasContactContainer");
                kotlin.g.b.p.g(findViewById2, "noContactContainer");
                kotlin.g.b.p.h(findViewById, "hasContactContainer");
                kotlin.g.b.p.h(findViewById2, "noContactContainer");
                Log.d("SimpleUIComponent", "账户封禁");
                findViewById2.setVisibility(8);
                findViewById.setVisibility(0);
                View findViewById14 = findViewById(R.id.fml);
                kotlin.g.b.p.g(findViewById14, "findViewById<View>(R.id.msg_ll)");
                findViewById14.setVisibility(8);
                View view8 = this.wzH;
                if (view8 == null) {
                    kotlin.g.b.p.btv("finderPosBtn");
                }
                view8.setVisibility(8);
                View view9 = this.wzK;
                if (view9 != null) {
                    view9.setVisibility(8);
                }
                com.tencent.mm.plugin.finder.loader.m mVar3 = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka2 = com.tencent.mm.plugin.finder.loader.m.dka();
                com.tencent.mm.plugin.finder.loader.a aVar11 = new com.tencent.mm.plugin.finder.loader.a("");
                View findViewById15 = findViewById(R.id.ckb);
                kotlin.g.b.p.g(findViewById15, "findViewById<ImageView>(R.id.finder_avatar_iv)");
                com.tencent.mm.plugin.finder.loader.m mVar4 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dka2.a(aVar11, (ImageView) findViewById15, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
                View findViewById16 = findViewById(R.id.d0p);
                kotlin.g.b.p.g(findViewById16, "findViewById<TextView>(R.id.finder_nick_tv)");
                ((TextView) findViewById16).setText(getResources().getString(R.string.cgf));
                View findViewById17 = findViewById(R.id.d3e);
                kotlin.g.b.p.g(findViewById17, "findViewById<View>(R.id.finder_self_msg_tv)");
                findViewById17.setVisibility(0);
                findViewById(R.id.cj6).setOnClickListener(new a(this));
                Intent intent5 = getIntent();
                FinderSelfUI.a aVar12 = FinderSelfUI.vOh;
                if (intent5.getBooleanExtra(FinderSelfUI.vOg, false)) {
                    findViewById(R.id.cj6).post(new b(this));
                    Intent intent6 = getIntent();
                    FinderSelfUI.a aVar13 = FinderSelfUI.vOh;
                    intent6.removeExtra(FinderSelfUI.vOg);
                }
                View findViewById18 = findViewById(R.id.hjv);
                kotlin.g.b.p.g(findViewById18, "findViewById<View>(R.id.sendMsgLayout)");
                findViewById18.setVisibility(8);
                break;
            case 5:
                kotlin.g.b.p.g(findViewById, "hasContactContainer");
                kotlin.g.b.p.g(findViewById2, "noContactContainer");
                kotlin.g.b.p.h(findViewById, "hasContactContainer");
                kotlin.g.b.p.h(findViewById2, "noContactContainer");
                Log.d("SimpleUIComponent", "账户审核中");
                findViewById2.setVisibility(8);
                findViewById.setVisibility(0);
                ImageView imageView3 = (ImageView) findViewById(R.id.ckb);
                TextView textView3 = (TextView) findViewById(R.id.d0p);
                TextView textView4 = (TextView) findViewById(R.id.d3t);
                View findViewById19 = findViewById(R.id.fml);
                kotlin.g.b.p.g(findViewById19, "findViewById<View>(R.id.msg_ll)");
                findViewById19.setVisibility(8);
                View view10 = this.wzH;
                if (view10 == null) {
                    kotlin.g.b.p.btv("finderPosBtn");
                }
                view10.setVisibility(8);
                View view11 = this.wzK;
                if (view11 != null) {
                    view11.setVisibility(8);
                }
                com.tencent.mm.plugin.finder.loader.m mVar5 = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka3 = com.tencent.mm.plugin.finder.loader.m.dka();
                bed bed = this.udb;
                if (bed == null || (azn2 = bed.verifyInfo) == null || (str = azn2.kog) == null) {
                    str = "";
                }
                com.tencent.mm.plugin.finder.loader.a aVar14 = new com.tencent.mm.plugin.finder.loader.a(str);
                kotlin.g.b.p.g(imageView3, "finderAvatar");
                com.tencent.mm.plugin.finder.loader.m mVar6 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dka3.a(aVar14, imageView3, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
                kotlin.g.b.p.g(textView3, "finderNickname");
                AppCompatActivity activity = getActivity();
                bed bed2 = this.udb;
                textView3.setText(com.tencent.mm.pluginsdk.ui.span.l.c(activity, (bed2 == null || (azn = bed2.verifyInfo) == null) ? null : azn.LJq));
                ao.a(textView3.getPaint(), 0.8f);
                kotlin.g.b.p.g(textView4, "finderState");
                textView4.setVisibility(0);
                textView4.setText(getResources().getString(R.string.d8n));
                View findViewById20 = findViewById(R.id.fml);
                kotlin.g.b.p.g(findViewById20, "findViewById<View>(R.id.msg_ll)");
                findViewById20.setVisibility(8);
                findViewById(R.id.cj6).setOnClickListener(new g(this));
                Intent intent7 = getIntent();
                FinderSelfUI.a aVar15 = FinderSelfUI.vOh;
                if (intent7.getBooleanExtra(FinderSelfUI.vOg, false) && this.udb != null) {
                    findViewById(R.id.cj6).post(new h(this));
                    Intent intent8 = getIntent();
                    FinderSelfUI.a aVar16 = FinderSelfUI.vOh;
                    intent8.removeExtra(FinderSelfUI.vOg);
                }
                View findViewById21 = findViewById(R.id.hjv);
                kotlin.g.b.p.g(findViewById21, "findViewById<View>(R.id.sendMsgLayout)");
                findViewById21.setVisibility(8);
                break;
            default:
                Log.d("SimpleUIComponent", "not one of six state");
                break;
        }
        bed bed3 = this.udb;
        if (bed3 != null) {
            if (bed3.LNR > 0) {
                View findViewById22 = findViewById(R.id.ebd);
                kotlin.g.b.p.g(findViewById22, "findViewById<TextView>(R.id.like_feed_count)");
                ((TextView) findViewById22).setText(com.tencent.mm.plugin.finder.utils.k.Lw(bed3.LNR));
                View findViewById23 = findViewById(R.id.ebd);
                kotlin.g.b.p.g(findViewById23, "findViewById<TextView>(R.id.like_feed_count)");
                ((TextView) findViewById23).setVisibility(0);
            } else {
                View findViewById24 = findViewById(R.id.ebd);
                kotlin.g.b.p.g(findViewById24, "findViewById<TextView>(R.id.like_feed_count)");
                ((TextView) findViewById24).setVisibility(8);
            }
            if (bed3.LNS > 0) {
                View findViewById25 = findViewById(R.id.cbx);
                kotlin.g.b.p.g(findViewById25, "findViewById<TextView>(R.id.fav_feed_count)");
                ((TextView) findViewById25).setText(com.tencent.mm.plugin.finder.utils.k.Lw(bed3.LNS));
                View findViewById26 = findViewById(R.id.cbx);
                kotlin.g.b.p.g(findViewById26, "findViewById<TextView>(R.id.fav_feed_count)");
                ((TextView) findViewById26).setVisibility(0);
            } else {
                View findViewById27 = findViewById(R.id.cbx);
                kotlin.g.b.p.g(findViewById27, "findViewById<TextView>(R.id.fav_feed_count)");
                ((TextView) findViewById27).setVisibility(8);
            }
            Log.i("SimpleUIComponent", "likeCount = " + bed3.LNR + ",favCount = " + bed3.LNS);
        }
        TextView textView5 = this.wzI;
        if (textView5 == null) {
            kotlin.g.b.p.btv("finderPostNewFeed");
        }
        ao.a(textView5.getPaint(), 0.8f);
        TextView textView6 = this.wzL;
        ao.a(textView6 != null ? textView6.getPaint() : null, 0.8f);
        View findViewById28 = findViewById(R.id.d34);
        kotlin.g.b.p.g(findViewById28, "findViewById<View>(R.id.finder_self_account_state)");
        findViewById28.setVisibility(0);
        Intent intent9 = getIntent();
        FinderSelfUI.a aVar17 = FinderSelfUI.vOh;
        if (intent9.getBooleanExtra(FinderSelfUI.vOg, false)) {
            View view12 = this.wzH;
            if (view12 == null) {
                kotlin.g.b.p.btv("finderPosBtn");
            }
            if (view12 != null) {
                view12.post(new aj(view12));
            }
            Intent intent10 = getIntent();
            FinderSelfUI.a aVar18 = FinderSelfUI.vOh;
            intent10.removeExtra(FinderSelfUI.vOg);
        }
        Log.i("SimpleUIComponent", "[checkAutoShowPost] autoShow" + this.UVP);
        com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
        int dCL = com.tencent.mm.plugin.finder.utils.y.dCL();
        if (!this.UVP || !(dCL == 3 || dCL == 6)) {
            Log.i("SimpleUIComponent", "[checkAutoShowPost] not autoShow");
            AppMethodBeat.o(255940);
            return;
        }
        det();
        Log.i("SimpleUIComponent", "[checkAutoShowPost] has autoShow post bottom sheet ,set false");
        this.UVP = false;
        AppMethodBeat.o(255940);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class aj implements Runnable {
        final /* synthetic */ View tzy;

        aj(View view) {
            this.tzy = view;
        }

        public final void run() {
            AppMethodBeat.i(255933);
            this.tzy.performClick();
            AppMethodBeat.o(255933);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;
        final /* synthetic */ z.a wAj;

        c(FinderSelfUIC finderSelfUIC, z.a aVar) {
            this.wAi = finderSelfUIC;
            this.wAj = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255899);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButNoAccountUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.H(false, this.wAi.wAf ? 4 : 3);
            com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.as(this.wAi.wAf ? 4 : 3, false);
            com.tencent.mm.plugin.finder.report.i iVar3 = com.tencent.mm.plugin.finder.report.i.vfo;
            StringBuilder sb = new StringBuilder();
            kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
            com.tencent.mm.plugin.finder.report.i.auI(sb.append(com.tencent.mm.kernel.a.ayV()).append('_').append(Util.nowMilliSecond()).toString());
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah).getRedDotManager().asW("TLCamera");
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("TLCamera");
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!(asW == null || asX == null)) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                int i2 = com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1 ? 0 : 1;
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                com.tencent.mm.plugin.finder.report.k.a("4", 2, 2, 1, i2, 0, (String) null, (String) null, 0, fH != null ? fH.dIx() : null, 0, 0, 3520);
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wAi.getActivity());
                com.tencent.mm.plugin.finder.report.j.a("4", asX, asW, 2, fH2 != null ? fH2.dIx() : null, 0, 0, 96);
            }
            com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class);
            kotlin.g.b.p.g(ah3, "MMKernel.plugin(IPluginFinder::class.java)");
            ((com.tencent.mm.plugin.i.a.aj) ah3).getRedDotManager().asV("TLCamera");
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (com.tencent.mm.plugin.finder.utils.y.bE(this.wAi.getActivity())) {
                Intent intent = new Intent();
                if (this.wAj.SYB) {
                    intent.putExtra("key_create_scene", 4);
                } else {
                    intent.putExtra("key_create_scene", 1);
                }
                intent.putExtra("scene", 2);
                bed bed = this.wAi.udb;
                if (bed != null) {
                    intent.putExtra("key_prepare_resp", bed.toByteArray());
                }
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.w(this.wAi.getActivity(), intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButNoAccountUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255899);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ FinderSelfUIC wAi;

        d(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void run() {
            AppMethodBeat.i(255900);
            FinderSelfUIC.g(this.wAi).performClick();
            AppMethodBeat.o(255900);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class g implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        g(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255903);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButRevingUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            bed bed = this.wAi.udb;
            if (bed != null) {
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (com.tencent.mm.plugin.finder.utils.y.bE(this.wAi.getActivity())) {
                    FinderSelfUIC.a(this.wAi, bed);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButRevingUi$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255903);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ FinderSelfUIC wAi;

        h(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void run() {
            AppMethodBeat.i(255904);
            this.wAi.findViewById(R.id.cj6).performClick();
            AppMethodBeat.o(255904);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class ad implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        ad(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255927);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah).getRedDotManager().asW("ProfileEntrance");
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("ProfileEntrance");
            if (!(asX == null || asW == null)) {
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                com.tencent.mm.plugin.finder.report.j.a("4", asX, asW, 2, fH != null ? fH.dIx() : null, 0, 0, 96);
            }
            com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah3).getRedDotManager().asV("ProfileEntrance");
            Intent intent = new Intent();
            c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(com.tencent.mm.model.z.aUg());
            if (asG == null) {
                kotlin.g.b.p.hyc();
            }
            if (asG.isBlock()) {
                intent.setClass(this.wAi.getActivity(), FinderExposeUI.class);
                AppCompatActivity activity = this.wAi.getActivity();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else {
                intent.putExtra("finder_username", this.wAi.wzE);
                intent.putExtra("KEY_FINDER_SELF_FLAG", true);
                FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                FinderReporterUIC.a.a(this.wAi.getActivity(), intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(this.wAi.getActivity(), intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255927);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class ae implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;
        final /* synthetic */ int wAo;
        final /* synthetic */ com.tencent.mm.plugin.finder.extension.reddot.k wAp;
        final /* synthetic */ bdo wAq;

        ae(FinderSelfUIC finderSelfUIC, int i2, com.tencent.mm.plugin.finder.extension.reddot.k kVar, bdo bdo) {
            this.wAi = finderSelfUIC;
            this.wAo = i2;
            this.wAp = kVar;
            this.wAq = bdo;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255928);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.wAo > 0) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                int i2 = com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1 ? 0 : 2;
                if (this.wAo > 0) {
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    int i3 = this.wAo;
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.wAi.getActivity());
                    com.tencent.mm.plugin.finder.report.k.a("4", 1, 2, 5, i2, i3, (String) null, (String) null, 0, fH != null ? fH.dIx() : null, 0, 0, 3520);
                }
            }
            com.tencent.mm.plugin.finder.extension.reddot.k kVar2 = this.wAp;
            bdo bdo = this.wAq;
            if (!(kVar2 == null || bdo == null)) {
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.wAi.getActivity());
                com.tencent.mm.plugin.finder.report.j.a("4", kVar2, bdo, 2, fH2 != null ? fH2.dIx() : null, 0, 0, 96);
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                ((PluginFinder) ah).getRedDotManager().asV("AuthorProfileNotify");
            }
            com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(this.wAi.getActivity(), this.wAi.sTp, this.wAi.wzX, 2, this.wAi.wzS, this.wAo > 0, (long) this.wAo);
            Intent intent = new Intent();
            c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(com.tencent.mm.model.z.aUg());
            if (asG == null) {
                kotlin.g.b.p.hyc();
            }
            if (asG.isBlock()) {
                intent.setClass(this.wAi.getActivity(), FinderExposeUI.class);
                AppCompatActivity activity = this.wAi.getActivity();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else {
                FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
                FinderReporterUIC.a.a(this.wAi.getActivity(), intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar5 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.Y(this.wAi.getActivity(), intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255928);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class af implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        af(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255929);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderSelfUIC.e(this.wAi);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$normalOrAbNomalUi$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255929);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class ag implements Runnable {
        final /* synthetic */ FinderSelfUIC wAi;

        ag(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void run() {
            AppMethodBeat.i(255930);
            FinderSelfUIC.g(this.wAi).performClick();
            AppMethodBeat.o(255930);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStop() {
        AppMethodBeat.i(255941);
        super.onStop();
        this.wzY = false;
        this.wzZ = "";
        this.wAa = "";
        this.wAb = "";
        this.wAc = "";
        this.wAd = "";
        this.wAe = "";
        AppMethodBeat.o(255941);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ FinderSelfUIC wAi;

        a(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255897);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$accountAbnormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.wAi.getIntent().putExtra("finder_username", this.wAi.wzE);
            this.wAi.getIntent().putExtra("KEY_FINDER_SELF_FLAG", true);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(this.wAi.getActivity(), this.wAi.getIntent(), 0, 0, false, 124);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(this.wAi.getActivity(), this.wAi.getIntent());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$accountAbnormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255897);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ FinderSelfUIC wAi;

        b(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        public final void run() {
            AppMethodBeat.i(255898);
            this.wAi.findViewById(R.id.cj6).performClick();
            AppMethodBeat.o(255898);
        }
    }

    private static void doPrepareUser() {
        AppMethodBeat.i(255942);
        com.tencent.mm.kernel.g.azz().b(new cd(8));
        AppMethodBeat.o(255942);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "invoke"})
    static final class ac extends kotlin.g.b.q implements kotlin.g.a.a<FinderLivePostBtnUIC> {
        final /* synthetic */ FinderSelfUIC wAi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ac(FinderSelfUIC finderSelfUIC) {
            super(0);
            this.wAi = finderSelfUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderLivePostBtnUIC invoke() {
            AppMethodBeat.i(255926);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderLivePostBtnUIC finderLivePostBtnUIC = (FinderLivePostBtnUIC) com.tencent.mm.ui.component.a.b(this.wAi.getActivity()).get(FinderLivePostBtnUIC.class);
            AppMethodBeat.o(255926);
            return finderLivePostBtnUIC;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        boolean z2;
        AppMethodBeat.i(255943);
        super.onResume();
        com.tencent.mm.plugin.finder.api.e finderSyncExtension = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension();
        if (finderSyncExtension == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.FinderSyncExtension");
            AppMethodBeat.o(255943);
            throw tVar;
        }
        ((com.tencent.mm.plugin.finder.extension.a) finderSyncExtension).fX(45097, 1);
        this.wzE = com.tencent.mm.model.z.aUg();
        if (this.udb != null) {
            dIF();
            dIG();
            com.tencent.mm.plugin.finder.ui.g gVar = this.wzG;
            if (gVar != null) {
                gVar.a(this.udb);
            }
        } else {
            if (Util.isNullOrNil(this.wzE)) {
                ProgressBar progressBar2 = this.progressBar;
                if (progressBar2 == null) {
                    kotlin.g.b.p.btv("progressBar");
                }
                progressBar2.setVisibility(0);
            } else {
                dIF();
            }
            doPrepareUser();
        }
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        com.tencent.mm.plugin.finder.extension.reddot.a aVar = ((PluginFinder) ah).getRedDotManager().tJB;
        aVar.handler.removeMessages(4);
        aVar.handler.sendEmptyMessage(4);
        aVar.handler.removeMessages(6);
        aVar.handler.sendEmptyMessage(6);
        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.H(true, this.wAf ? 4 : 3);
        View view = this.wzK;
        if (view == null || view.getVisibility() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            if (!com.tencent.mm.plugin.finder.report.live.k.dpl().vmk) {
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.q(s.a.PROFILE_LIVE_BTN_EXPOSE.hlf, "");
            }
        }
        com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.bxB("ProfileEntrance");
        com.tencent.mm.plugin.finder.extension.reddot.h hVar2 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.bxB("CreateFinderEntrance");
        AppMethodBeat.o(255943);
    }

    @Override // com.tencent.mm.plugin.finder.api.f
    public final void a(apf apf, int i2, int i3) {
        AppMethodBeat.i(255944);
        kotlin.g.b.p.h(apf, "cmdItem");
        Log.i("SimpleUIComponent", "cmdId " + apf.cmdId);
        switch (apf.cmdId) {
            case 101:
                dIF();
                break;
        }
        AppMethodBeat.o(255944);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(255945);
        Log.i("SimpleUIComponent", "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        if (qVar instanceof cd) {
            ProgressBar progressBar2 = this.progressBar;
            if (progressBar2 == null) {
                kotlin.g.b.p.btv("progressBar");
            }
            progressBar2.setVisibility(8);
            if (i2 == 0 && i3 == 0) {
                if (this.udb == null) {
                    if (qVar == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
                        AppMethodBeat.o(255945);
                        throw tVar;
                    }
                    this.udb = ((cd) qVar).cZc();
                    dIG();
                }
                if (qVar == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
                    AppMethodBeat.o(255945);
                    throw tVar2;
                }
                this.udb = ((cd) qVar).cZc();
                com.tencent.mm.plugin.finder.ui.g gVar = this.wzG;
                if (gVar != null) {
                    gVar.a(this.udb);
                }
                dIF();
                AppMethodBeat.o(255945);
                return;
            }
            dIG();
            com.tencent.mm.ui.base.u.makeText(getActivity(), (int) R.string.d5v, 1).show();
        }
        AppMethodBeat.o(255945);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255946);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(3761, this);
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().b(101, this);
        i.a aVar = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
        int i2 = i.a.dbo()[3];
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        if (i2 + aAh.azQ().getInt(ar.a.USERINFO_FINDER_FANS_ADDCOUNT_INT_SYNC, 0) <= 0) {
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah).getRedDotManager().Iy(2);
        }
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah2).getRedDotManager().tJB.dat();
        com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        kotlin.g.b.p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah3).getRedDotManager().tJB.das();
        com.tencent.mm.plugin.finder.ui.g gVar = this.wzG;
        if (gVar != null) {
            Log.i(gVar.TAG, "destroy");
            com.tencent.mm.kernel.g.azz().b(5231, gVar);
            AppMethodBeat.o(255946);
            return;
        }
        AppMethodBeat.o(255946);
    }

    private final int hVA() {
        AppMethodBeat.i(261570);
        com.tencent.mm.plugin.finder.activity.b bVar = com.tencent.mm.plugin.finder.activity.b.tqg;
        if (com.tencent.mm.plugin.finder.activity.b.b(null, 5)) {
            AppMethodBeat.o(261570);
            return 9;
        } else if (this.wAf) {
            AppMethodBeat.o(261570);
            return 4;
        } else {
            AppMethodBeat.o(261570);
            return 3;
        }
    }

    private final void det() {
        AppMethodBeat.i(261571);
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (com.tencent.mm.plugin.finder.spam.a.avp("post")) {
            AppMethodBeat.o(261571);
            return;
        }
        StringBuilder sb = new StringBuilder();
        kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        String sb2 = sb.append(com.tencent.mm.kernel.a.ayV()).append('_').append(Util.nowMilliSecond()).toString();
        int hVA = hVA();
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.fr(getActivity());
        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.as(hVA, false);
        com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.auI(sb2);
        com.tencent.mm.plugin.finder.report.i iVar3 = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.H(false, hVA);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) getActivity(), 1, true);
        View inflate = com.tencent.mm.ui.aa.jQ(getActivity()).inflate(R.layout.ak1, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.fzc);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.wm);
        c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(com.tencent.mm.model.z.aUg());
        if (asG != null) {
            kotlin.g.b.p.g(textView, "nicknameTv");
            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getActivity(), asG.getNickname()));
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar4 = new com.tencent.mm.plugin.finder.loader.a(asG.field_avatarUrl);
            kotlin.g.b.p.g(imageView, "avatarIv");
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            dka.a(aVar4, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
        }
        com.tencent.mm.plugin.finder.report.i iVar4 = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.auH(sb2);
        eVar.V(inflate, true);
        eVar.a(new i(this));
        eVar.a(new j(this, sb2));
        eVar.b(k.wAk);
        eVar.dGm();
        AppMethodBeat.o(261571);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class i implements o.f {
        final /* synthetic */ FinderSelfUIC wAi;

        i(FinderSelfUIC finderSelfUIC) {
            this.wAi = finderSelfUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(255905);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(1001, R.string.um);
                mVar.kV(1002, R.string.uv);
                com.tencent.mm.plugin.finder.utils.r rVar = com.tencent.mm.plugin.finder.utils.r.vWn;
                com.tencent.mm.plugin.finder.utils.r.a(this.wAi.udg, mVar);
            }
            AppMethodBeat.o(255905);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class j implements o.g {
        final /* synthetic */ String uPz;
        final /* synthetic */ FinderSelfUIC wAi;

        j(FinderSelfUIC finderSelfUIC, String str) {
            this.wAi = finderSelfUIC;
            this.uPz = str;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(255906);
            Intent intent = new Intent();
            kotlin.g.b.p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == 1001) {
                kotlin.g.b.p.g(intent.putExtra("key_finder_post_router", 2), "intent.putExtra(Constant…uterUI.ROUTER_TAKE_PHOTO)");
            } else if (menuItem.getItemId() == 1002) {
                kotlin.g.b.p.g(intent.putExtra("key_finder_post_router", 3), "intent.putExtra(Constant…erUI.ROUTER_SELECT_PHOTO)");
            } else if (this.wAi.udg.containsKey(Integer.valueOf(menuItem.getItemId()))) {
                com.tencent.mm.plugin.finder.utils.r rVar = com.tencent.mm.plugin.finder.utils.r.vWn;
                com.tencent.mm.plugin.finder.utils.r.a(this.wAi.getActivity(), (ddk) this.wAi.udg.get(Integer.valueOf(menuItem.getItemId())));
                com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
                com.tencent.mm.plugin.finder.report.i.as(this.wAi.wAf ? 4 : 3, false);
            }
            intent.putExtra("key_finder_post_from", 5);
            intent.putExtra("key_finder_post_id", this.uPz);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(this.wAi.getActivity(), intent);
            AppMethodBeat.o(255906);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class k implements e.b {
        public static final k wAk = new k();

        static {
            AppMethodBeat.i(255908);
            AppMethodBeat.o(255908);
        }

        k() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(255907);
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.Ks(6);
            AppMethodBeat.o(255907);
        }
    }

    private final void dIG() {
        long j2;
        long j3;
        int i2;
        AppMethodBeat.i(255947);
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a((Context) getActivity(), this.sTp, this.wzX, 1L, this.wzO, false);
        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
        AppCompatActivity activity = getActivity();
        long j4 = this.sTp;
        boolean z2 = this.wzX;
        long j5 = this.wzP;
        bed bed = this.udb;
        if (bed != null) {
            j2 = (long) bed.LNR;
        } else {
            j2 = 0;
        }
        com.tencent.mm.plugin.finder.report.k.a((Context) activity, j4, z2, 1L, j5, false, j2);
        com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
        AppCompatActivity activity2 = getActivity();
        long j6 = this.sTp;
        boolean z3 = this.wzX;
        long j7 = this.wzQ;
        bed bed2 = this.udb;
        if (bed2 != null) {
            j3 = (long) bed2.LNS;
        } else {
            j3 = 0;
        }
        com.tencent.mm.plugin.finder.report.k.a((Context) activity2, j6, z3, 1L, j7, false, j3);
        com.tencent.mm.plugin.finder.report.k kVar4 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a((Context) getActivity(), this.sTp, this.wzX, 1L, this.wzR, false);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah).getRedDotManager().asX("finder_private_msg_entrance");
        bdo atl = asX != null ? asX.atl("finder_private_msg_entrance") : null;
        com.tencent.mm.plugin.finder.report.k kVar5 = com.tencent.mm.plugin.finder.report.k.vfA;
        AppCompatActivity activity3 = getActivity();
        long j8 = this.sTp;
        boolean z4 = this.wzX;
        long j9 = this.wzV;
        boolean z5 = atl != null;
        if (atl != null) {
            i2 = atl.count;
        } else {
            i2 = 0;
        }
        com.tencent.mm.plugin.finder.report.k.a(activity3, j8, z4, 1, j9, z5, (long) i2);
        long dIH = dIH();
        com.tencent.mm.plugin.finder.report.k kVar6 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a(getActivity(), this.sTp, this.wzX, 1, this.wzW, dIH > 0, dIH);
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
        bdo asW = ((PluginFinder) ah2).getRedDotManager().asW("CreatorCenter");
        com.tencent.mm.plugin.finder.report.k kVar7 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a(getActivity(), this.sTp, this.wzX, 1, this.wzT, asW != null);
        View findViewById = findViewById(R.id.ehc);
        kotlin.g.b.p.g(findViewById, LocaleUtil.ITALIAN);
        if (!(findViewById.getVisibility() == 0)) {
            findViewById = null;
        }
        if (findViewById != null) {
            com.tencent.mm.plugin.finder.report.k kVar8 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a((Context) getActivity(), this.sTp, false, 1L, this.wzU, false, 0L);
        }
        AppMethodBeat.o(255947);
    }

    private static long dIH() {
        AppMethodBeat.i(255948);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        bdo asW = ((PluginFinder) ah).getRedDotManager().asW("finder_wx_private_msg_entrance");
        if (asW != null) {
            long j2 = (long) asW.count;
            AppMethodBeat.o(255948);
            return j2;
        }
        AppMethodBeat.o(255948);
        return 0;
    }

    public static final /* synthetic */ void a(FinderSelfUIC finderSelfUIC, bed bed) {
        AppMethodBeat.i(255955);
        int i2 = bed.actionType;
        Log.i("SimpleUIComponent", "actionType ".concat(String.valueOf(i2)));
        switch (i2) {
            case 3:
                azn azn = bed.verifyInfo;
                if (azn != null) {
                    ((com.tencent.mm.plugin.appbrand.service.r) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(finderSelfUIC.getActivity(), azn.appName, "", 0, 0, azn.LJp, new AppBrandStatObject());
                    AppMethodBeat.o(255955);
                    return;
                }
                AppMethodBeat.o(255955);
                return;
            case 2:
                Intent intent = new Intent();
                intent.putExtra("finder_username", finderSelfUIC.wzE);
                intent.putExtra("KEY_FINDER_SELF_FLAG", true);
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC.a.a(finderSelfUIC.getActivity(), intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(finderSelfUIC.getActivity(), intent);
                break;
        }
        AppMethodBeat.o(255955);
    }
}
