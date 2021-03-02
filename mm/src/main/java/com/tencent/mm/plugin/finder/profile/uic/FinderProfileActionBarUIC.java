package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLivePostBtnUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.z;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ~2\u00020\u00012\u00020\u0002:\u0004~\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020@2\u0006\u0010f\u001a\u00020@H\u0002J\b\u0010g\u001a\u00020dH\u0002J\b\u0010h\u001a\u00020dH\u0002J\b\u0010i\u001a\u00020dH\u0002J\b\u0010j\u001a\u00020dH\u0002J\b\u0010k\u001a\u00020dH\u0002J\b\u0010l\u001a\u000209H\u0002J\b\u0010m\u001a\u00020dH\u0002J\b\u0010n\u001a\u00020dH\u0002J\u0012\u0010o\u001a\u00020d2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J\b\u0010r\u001a\u00020dH\u0016J\b\u0010s\u001a\u00020dH\u0016J*\u0010t\u001a\u00020d2\u0006\u0010u\u001a\u00020 2\u0006\u0010v\u001a\u00020 2\b\u0010w\u001a\u0004\u0018\u00010b2\u0006\u0010x\u001a\u00020yH\u0016J\u0018\u0010z\u001a\u00020d2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020 H\u0002R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0012\u001a\n \b*\u0004\u0018\u00010\u00130\u00138FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u0017\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0018\u0010\u0010R#\u0010\u001a\u001a\n \b*\u0004\u0018\u00010\u001b0\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R#\u0010!\u001a\n \b*\u0004\u0018\u00010\"0\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R#\u0010&\u001a\n \b*\u0004\u0018\u00010\u00130\u00138BX\u0002¢\u0006\f\n\u0004\b(\u0010\f\u001a\u0004\b'\u0010\u0015R#\u0010)\u001a\n \b*\u0004\u0018\u00010*0*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b+\u0010,R#\u0010.\u001a\n \b*\u0004\u0018\u00010/0/8BX\u0002¢\u0006\f\n\u0004\b2\u0010\f\u001a\u0004\b0\u00101R#\u00103\u001a\n \b*\u0004\u0018\u000104048FX\u0002¢\u0006\f\n\u0004\b7\u0010\f\u001a\u0004\b5\u00106R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u0002098BX\u0002¢\u0006\f\n\u0004\b<\u0010\f\u001a\u0004\b:\u0010;R\u001b\u0010=\u001a\u0002098BX\u0002¢\u0006\f\n\u0004\b>\u0010\f\u001a\u0004\b=\u0010;R\u000e\u0010?\u001a\u00020@X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020B8BX\u0002¢\u0006\f\n\u0004\bE\u0010\f\u001a\u0004\bC\u0010DR#\u0010F\u001a\n \b*\u0004\u0018\u00010\"0\"8BX\u0002¢\u0006\f\n\u0004\bH\u0010\f\u001a\u0004\bG\u0010$R#\u0010I\u001a\n \b*\u0004\u0018\u00010\u00130\u00138BX\u0002¢\u0006\f\n\u0004\bK\u0010\f\u001a\u0004\bJ\u0010\u0015R#\u0010L\u001a\n \b*\u0004\u0018\u00010\"0\"8FX\u0002¢\u0006\f\n\u0004\bN\u0010\f\u001a\u0004\bM\u0010$R\u000e\u0010O\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R#\u0010P\u001a\n \b*\u0004\u0018\u00010\"0\"8BX\u0002¢\u0006\f\n\u0004\bR\u0010\f\u001a\u0004\bQ\u0010$R#\u0010S\u001a\n \b*\u0004\u0018\u00010\u00130\u00138BX\u0002¢\u0006\f\n\u0004\bU\u0010\f\u001a\u0004\bT\u0010\u0015R*\u0010V\u001a\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020X0Wj\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020X`YX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Z\u001a\u0004\u0018\u00010[8BX\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R#\u0010^\u001a\n \b*\u0004\u0018\u00010\"0\"8BX\u0002¢\u0006\f\n\u0004\b`\u0010\f\u001a\u0004\b_\u0010$R\u000e\u0010a\u001a\u00020bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "actionBarAvatarIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getActionBarAvatarIv", "()Landroid/widget/ImageView;", "actionBarAvatarIv$delegate", "Lkotlin/Lazy;", "actionBarFollowText", "Landroid/widget/TextView;", "getActionBarFollowText", "()Landroid/widget/TextView;", "actionBarFollowText$delegate", "actionBarFollowedIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getActionBarFollowedIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "actionBarFollowedIv$delegate", "actionBarNicknameTv", "getActionBarNicknameTv", "actionBarNicknameTv$delegate", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "getAppBarLayout", "()Landroid/support/design/widget/AppBarLayout;", "appBarLayout$delegate", "appBarLayoutOffset", "", "backBtn", "Landroid/widget/LinearLayout;", "getBackBtn", "()Landroid/widget/LinearLayout;", "backBtn$delegate", "backBtnIv", "getBackBtnIv", "backBtnIv$delegate", "contentLayout", "Lcom/tencent/mm/view/HardTouchableLayout;", "getContentLayout", "()Lcom/tencent/mm/view/HardTouchableLayout;", "contentLayout$delegate", "coordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "getCoordinatorLayout", "()Landroid/support/design/widget/CoordinatorLayout;", "coordinatorLayout$delegate", "followContainer", "Landroid/widget/FrameLayout;", "getFollowContainer", "()Landroid/widget/FrameLayout;", "followContainer$delegate", "hasFinderEntry", "", "isSelf", "()Z", "isSelf$delegate", "isSelfFlag", "isSelfFlag$delegate", "lastActionBarProgress", "", "livePostUic", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "getLivePostUic", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "livePostUic$delegate", "moreBtn", "getMoreBtn", "moreBtn$delegate", "moreBtnIv", "getMoreBtnIv", "moreBtnIv$delegate", "myActionBar", "getMyActionBar", "myActionBar$delegate", "normalActionBarColor", "postBtn", "getPostBtn", "postBtn$delegate", "postBtnIv", "getPostBtnIv", "postBtnIv$delegate", "postItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "Lkotlin/collections/HashMap;", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "userInfoLayout", "getUserInfoLayout", "userInfoLayout$delegate", ch.COL_USERNAME, "", "changeFollowView", "", "progress", "alpha", "doClickMoreAction", "doClickPostAction", "doClickPostLiveAction", "doShowPostBottomSheet", "fixActionBarStatus", "hasSetCoverImg", "hideActionBar", "initCustomActionBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisibleStats", "view", "Landroid/view/View;", "visibleStat", "Companion", "OnOffsetChangedListener", "OverScrollListener", "plugin-finder_release"})
public final class FinderProfileActionBarUIC extends UIComponent implements com.tencent.mm.ak.i {
    public static final a vam = new a((byte) 0);
    private final kotlin.f tZl = g.ah(new x(this));
    private final kotlin.f uZN;
    private final kotlin.f uZO;
    private final kotlin.f uZP;
    final kotlin.f uZQ;
    final kotlin.f uZR;
    private final kotlin.f uZS;
    private final kotlin.f uZT;
    private final kotlin.f uZU;
    private final kotlin.f uZV;
    private final kotlin.f uZW;
    private final kotlin.f uZX;
    private final kotlin.f uZY;
    private final kotlin.f uZZ;
    private HashMap<Integer, ddk> udg = new HashMap<>();
    private String username = "";
    private final kotlin.f vaa;
    private final kotlin.f vab;
    private final kotlin.f vac;
    private final int vaf;
    private final kotlin.f vag = g.ah(new w(this));
    private final boolean vah = ((aj) com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry();
    private float vai;
    private final kotlin.f vaj;
    private int vak;

    static {
        AppMethodBeat.i(250079);
        AppMethodBeat.o(250079);
    }

    private final LinearLayout dmd() {
        AppMethodBeat.i(250062);
        LinearLayout linearLayout = (LinearLayout) this.uZO.getValue();
        AppMethodBeat.o(250062);
        return linearLayout;
    }

    private final AppBarLayout dmf() {
        AppMethodBeat.i(250064);
        AppBarLayout appBarLayout = (AppBarLayout) this.uZS.getValue();
        AppMethodBeat.o(250064);
        return appBarLayout;
    }

    private final LinearLayout dmh() {
        AppMethodBeat.i(250066);
        LinearLayout linearLayout = (LinearLayout) this.uZW.getValue();
        AppMethodBeat.o(250066);
        return linearLayout;
    }

    private final LinearLayout dmi() {
        AppMethodBeat.i(250067);
        LinearLayout linearLayout = (LinearLayout) this.uZZ.getValue();
        AppMethodBeat.o(250067);
        return linearLayout;
    }

    private final ImageView dmj() {
        AppMethodBeat.i(250068);
        ImageView imageView = (ImageView) this.vab.getValue();
        AppMethodBeat.o(250068);
        return imageView;
    }

    private final TextView dmk() {
        AppMethodBeat.i(250069);
        TextView textView = (TextView) this.vac.getValue();
        AppMethodBeat.o(250069);
        return textView;
    }

    private final boolean isSelf() {
        AppMethodBeat.i(250072);
        boolean booleanValue = ((Boolean) this.vag.getValue()).booleanValue();
        AppMethodBeat.o(250072);
        return booleanValue;
    }

    public final FrameLayout dme() {
        AppMethodBeat.i(250063);
        FrameLayout frameLayout = (FrameLayout) this.uZP.getValue();
        AppMethodBeat.o(250063);
        return frameLayout;
    }

    public final LinearLayout dmg() {
        AppMethodBeat.i(250065);
        LinearLayout linearLayout = (LinearLayout) this.uZV.getValue();
        AppMethodBeat.o(250065);
        return linearLayout;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProfileActionBarUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(250078);
        this.uZN = g.ah(new j(appCompatActivity));
        this.uZO = g.ah(new ah(appCompatActivity));
        this.uZP = g.ah(new v(appCompatActivity));
        this.uZQ = g.ah(new e(appCompatActivity));
        this.uZR = g.ah(new d(appCompatActivity));
        this.uZS = g.ah(new i(appCompatActivity));
        this.uZT = g.ah(new k(appCompatActivity));
        this.uZU = g.ah(new ai(appCompatActivity));
        this.uZV = g.ah(new ab(appCompatActivity));
        this.uZW = g.ah(new z(appCompatActivity));
        this.uZX = g.ah(new aa(appCompatActivity));
        this.uZY = g.ah(new l(appCompatActivity));
        this.uZZ = g.ah(new al(appCompatActivity));
        this.vaa = g.ah(new m(appCompatActivity));
        this.vab = g.ah(new c(appCompatActivity));
        this.vac = g.ah(new f(appCompatActivity));
        this.vaf = appCompatActivity.getResources().getColor(R.color.f3045c);
        this.vaj = g.ah(new y(appCompatActivity));
        AppMethodBeat.o(250078);
    }

    public static final /* synthetic */ LinearLayout b(FinderProfileActionBarUIC finderProfileActionBarUIC) {
        AppMethodBeat.i(250080);
        LinearLayout dmi = finderProfileActionBarUIC.dmi();
        AppMethodBeat.o(250080);
        return dmi;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.finder.api.g k(FinderProfileActionBarUIC finderProfileActionBarUIC) {
        AppMethodBeat.i(250087);
        com.tencent.mm.plugin.finder.api.g profileContact = finderProfileActionBarUIC.getProfileContact();
        AppMethodBeat.o(250087);
        return profileContact;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$Companion;", "", "()V", "MENU_ID_ACCOUNT_DETAIL", "", "MENU_ID_CREATE_NOTICE", "MENU_ID_EXPOSE", "MENU_ID_OPEN_LIVE", "MENU_ID_POST_FEED", "MENU_ID_POST_LIVE", "MENU_ID_RECOMMEND", "MENU_ID_SET_NO_SEE", "REQUEST_CODE_POST_ACTIONSHEET", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_TAKE_PHOTO", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final com.tencent.mm.plugin.finder.api.g getProfileContact() {
        AppMethodBeat.i(250073);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(this.username);
        AppMethodBeat.o(250073);
        return asG;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(250074);
        super.onCreate(bundle);
        String stringExtra = getActivity().getIntent().getStringExtra("finder_username");
        kotlin.g.b.p.g(stringExtra, "activity.intent.getStrin…leUI.KEY_FINDER_USERNAME)");
        this.username = stringExtra;
        com.tencent.mm.kernel.g.azz().a(3736, this);
        Window window = getActivity().getWindow();
        kotlin.g.b.p.g(window, "activity.window");
        View decorView = window.getDecorView();
        kotlin.g.b.p.g(decorView, "activity.window.decorView");
        decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        com.tencent.mm.ui.b.e(getActivity(), false);
        ActionBar supportActionBar = getActivity().getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setBackgroundDrawable(new ColorDrawable(0));
            supportActionBar.hide();
        }
        int statusBarHeight = au.getStatusBarHeight(getActivity());
        LinearLayout dmg = dmg();
        kotlin.g.b.p.g(dmg, "myActionBar");
        ViewGroup.LayoutParams layoutParams = dmg.getLayoutParams();
        layoutParams.height += statusBarHeight;
        LinearLayout dmg2 = dmg();
        kotlin.g.b.p.g(dmg2, "myActionBar");
        dmg2.setLayoutParams(layoutParams);
        dmg().setPadding(0, statusBarHeight, 0, 0);
        LinearLayout dmi = dmi();
        kotlin.g.b.p.g(dmi, "userInfoLayout");
        dmi.setAlpha(0.0f);
        com.tencent.mm.plugin.finder.api.g profileContact = getProfileContact();
        if (profileContact != null) {
            TextView dmk = dmk();
            kotlin.g.b.p.g(dmk, "actionBarNicknameTv");
            dmk.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getActivity(), profileContact.getNickname()));
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(profileContact.field_avatarUrl);
            ImageView dmj = dmj();
            kotlin.g.b.p.g(dmj, "actionBarAvatarIv");
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            dka.a(aVar, dmj, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
        }
        AppBarLayout dmf = dmf();
        b bVar = new b();
        AppBarLayout dmf2 = dmf();
        kotlin.g.b.p.g(dmf2, "appBarLayout");
        bVar.c(dmf2, 0);
        dmf.a(bVar);
        ((LinearLayout) this.uZN.getValue()).setOnClickListener(new ac(this));
        LinearLayout dmd = dmd();
        kotlin.g.b.p.g(dmd, "postBtn");
        dmd.setVisibility(8);
        LinearLayout dmh = dmh();
        kotlin.g.b.p.g(dmh, "moreBtn");
        dmh.setVisibility(8);
        if (!isSelf() || !((Boolean) this.tZl.getValue()).booleanValue()) {
            if (this.vah) {
                FrameLayout dme = dme();
                kotlin.g.b.p.g(dme, "followContainer");
                ah(dme, 8);
                LinearLayout dmh2 = dmh();
                kotlin.g.b.p.g(dmh2, "moreBtn");
                dmh2.setVisibility(0);
                dmh().setOnClickListener(new ae(this));
                if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
                    dmh().setOnLongClickListener(new af(this));
                    AppMethodBeat.o(250074);
                    return;
                }
            } else {
                LinearLayout dmh3 = dmh();
                kotlin.g.b.p.g(dmh3, "moreBtn");
                dmh3.setVisibility(0);
                dmh().setOnClickListener(new ag(this));
            }
            AppMethodBeat.o(250074);
            return;
        }
        LinearLayout dmd2 = dmd();
        kotlin.g.b.p.g(dmd2, "postBtn");
        dmd2.setVisibility(0);
        dmd().setOnClickListener(new ad(this));
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.f(getActivity(), 1, 1);
        AppMethodBeat.o(250074);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class ac implements View.OnClickListener {
        final /* synthetic */ FinderProfileActionBarUIC van;

        ac(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            this.van = finderProfileActionBarUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250052);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderProfileFloatBallUIC) com.tencent.mm.ui.component.a.b(this.van.getActivity()).get(FinderProfileFloatBallUIC.class)).vbf = true;
            this.van.getActivity().finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250052);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class ad implements View.OnClickListener {
        final /* synthetic */ FinderProfileActionBarUIC van;

        ad(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            this.van = finderProfileActionBarUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250053);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderProfileActionBarUIC.g(this.van);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250053);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class ae implements View.OnClickListener {
        final /* synthetic */ FinderProfileActionBarUIC van;

        ae(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            this.van = finderProfileActionBarUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250054);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderProfileActionBarUIC.h(this.van);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250054);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class af implements View.OnLongClickListener {
        final /* synthetic */ FinderProfileActionBarUIC van;

        af(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            this.van = finderProfileActionBarUIC;
        }

        public final boolean onLongClick(View view) {
            awt awt;
            String str = null;
            AppMethodBeat.i(250055);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            StringBuilder sb = new StringBuilder();
            FinderProfileHeaderUIC.a aVar = FinderProfileHeaderUIC.vbZ;
            FinderProfileHeaderUIC.b bVar2 = (FinderProfileHeaderUIC.b) FinderProfileHeaderUIC.userExtInfoCache.get(this.van.username);
            if (bVar2 != null) {
                awt = bVar2.vca;
            } else {
                awt = null;
            }
            sb.append("finderUsername:" + this.van.username + '\n');
            StringBuilder sb2 = new StringBuilder("noticeId:");
            if (awt != null) {
                str = awt.dDJ;
            }
            sb.append(sb2.append(str).toString());
            FinderDebugUIC.a aVar2 = FinderDebugUIC.wvw;
            String sb3 = sb.toString();
            kotlin.g.b.p.g(sb3, "sb.toString()");
            FinderDebugUIC.a.aG(this.van.getActivity(), sb3);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(250055);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class ag implements View.OnClickListener {
        final /* synthetic */ FinderProfileActionBarUIC van;

        ag(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            this.van = finderProfileActionBarUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250056);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderProfileActionBarUIC.h(this.van);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250056);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(261271);
        super.onResume();
        AppMethodBeat.o(261271);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(250075);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(3736, this);
        AppMethodBeat.o(250075);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class n implements o.f {
        final /* synthetic */ FinderProfileActionBarUIC van;

        n(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            this.van = finderProfileActionBarUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(250036);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                com.tencent.mm.plugin.finder.api.g k = FinderProfileActionBarUIC.k(this.van);
                if (((k != null ? k.field_extFlag : 0) & 1048576) == 0) {
                    mVar.kV(10002, R.string.d79);
                }
                if (this.van.vah && (!kotlin.g.b.p.j(this.van.username, com.tencent.mm.model.z.aUg()))) {
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                    if (com.tencent.mm.plugin.finder.utils.y.j(c.a.asG(this.van.username))) {
                        mVar.kV(10010, R.string.dan);
                    } else {
                        mVar.kV(10010, R.string.cii);
                    }
                }
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_ACCOUNT_DETAIL_URL_STRING_SYNC, "");
                if (obj == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(250036);
                    throw tVar;
                }
                if (((String) obj).length() > 0) {
                    mVar.kV(CdnLogic.kMediaTypeBeatificFile, R.string.cge);
                }
                mVar.kV(ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, R.string.d6q);
            }
            AppMethodBeat.o(250036);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class o implements o.g {
        final /* synthetic */ FinderProfileActionBarUIC van;

        o(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            this.van = finderProfileActionBarUIC;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            boolean z = false;
            AppMethodBeat.i(250037);
            kotlin.g.b.p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 10002:
                    com.tencent.mm.plugin.finder.api.g k = FinderProfileActionBarUIC.k(this.van);
                    if (k != null) {
                        s.a aVar = com.tencent.mm.plugin.finder.utils.s.vWt;
                        AppCompatActivity activity = this.van.getActivity();
                        if (activity == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                            AppMethodBeat.o(250037);
                            throw tVar;
                        }
                        s.a.a(aVar, (MMActivity) activity, k);
                        AppMethodBeat.o(250037);
                        return;
                    }
                    AppMethodBeat.o(250037);
                    return;
                case ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL /*{ENCODED_INT: 10004}*/:
                    String string = this.van.getActivity().getString(R.string.cm2, new Object[]{LocaleUtil.getApplicationLanguage(), this.van.username});
                    kotlin.g.b.p.g(string, "activity.getString(R.str…tionLanguage(), username)");
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", string);
                    com.tencent.mm.br.c.b(this.van.getActivity(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(250037);
                    return;
                case 10010:
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    FinderProfileHeaderUIC finderProfileHeaderUIC = (FinderProfileHeaderUIC) com.tencent.mm.ui.component.a.b(this.van.getActivity()).get(FinderProfileHeaderUIC.class);
                    z.a aVar3 = new z.a();
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    c.a aVar4 = com.tencent.mm.plugin.finder.api.c.tsp;
                    aVar3.SYB = com.tencent.mm.plugin.finder.utils.y.j(c.a.asG(finderProfileHeaderUIC.username));
                    if (!aVar3.SYB) {
                        c.a aVar5 = com.tencent.mm.plugin.finder.api.c.tsp;
                        if (c.a.asJ(finderProfileHeaderUIC.username)) {
                            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) finderProfileHeaderUIC.getContext(), 1, true);
                            eVar.o(finderProfileHeaderUIC.getContext().getResources().getString(R.string.d1h), 17);
                            eVar.a(new FinderProfileHeaderUIC.bf(finderProfileHeaderUIC));
                            eVar.a(new FinderProfileHeaderUIC.bg(finderProfileHeaderUIC, aVar3));
                            eVar.dGm();
                            AppMethodBeat.o(250037);
                            return;
                        }
                    }
                    if (!aVar3.SYB) {
                        z = true;
                    }
                    FinderProfileHeaderUIC.b(finderProfileHeaderUIC, z);
                    AppMethodBeat.o(250037);
                    return;
                case CdnLogic.kMediaTypeBeatificFile:
                    com.tencent.mm.plugin.finder.utils.a aVar6 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.fE(this.van.getActivity());
                    break;
            }
            AppMethodBeat.o(250037);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class s implements o.f {
        final /* synthetic */ FinderProfileActionBarUIC van;

        s(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            this.van = finderProfileActionBarUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(250042);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(10012, R.string.d5i);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                if (((FinderProfileHeaderUIC) com.tencent.mm.ui.component.a.b(this.van.getActivity()).get(FinderProfileHeaderUIC.class)).vbV) {
                    mVar.kV(10013, R.string.d76);
                }
            }
            AppMethodBeat.o(250042);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class t implements o.g {
        final /* synthetic */ FinderProfileActionBarUIC van;

        t(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            this.van = finderProfileActionBarUIC;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(250043);
            kotlin.g.b.p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 10012:
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    com.tencent.mm.plugin.finder.report.k.f(this.van.getActivity(), 2, 2);
                    FinderProfileActionBarUIC.l(this.van);
                    AppMethodBeat.o(250043);
                    return;
                case 10013:
                    com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                    com.tencent.mm.plugin.finder.report.k.f(this.van.getActivity(), 2, 3);
                    com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.dpl().a(s.ao.FINDER_PROFILE_RIGHT_CORNER);
                    com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.q(s.a.PROFILE_LIVE_BTN_CLICK.hlf, "");
                    FinderProfileActionBarUIC.m(this.van);
                    break;
            }
            AppMethodBeat.o(250043);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class u implements e.b {
        final /* synthetic */ FinderProfileActionBarUIC van;

        u(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            this.van = finderProfileActionBarUIC;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(250044);
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.f(this.van.getActivity(), 2, 4);
            AppMethodBeat.o(250044);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class p implements o.f {
        final /* synthetic */ FinderProfileActionBarUIC van;

        p(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            this.van = finderProfileActionBarUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(250038);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(1, R.string.um);
                mVar.kV(2, R.string.uv);
                com.tencent.mm.plugin.finder.utils.r rVar = com.tencent.mm.plugin.finder.utils.r.vWn;
                com.tencent.mm.plugin.finder.utils.r.a(this.van.udg, mVar);
            }
            AppMethodBeat.o(250038);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class q implements o.g {
        final /* synthetic */ String uPz;
        final /* synthetic */ FinderProfileActionBarUIC van;
        final /* synthetic */ AppCompatActivity vao;

        q(FinderProfileActionBarUIC finderProfileActionBarUIC, String str, AppCompatActivity appCompatActivity) {
            this.van = finderProfileActionBarUIC;
            this.uPz = str;
            this.vao = appCompatActivity;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(250039);
            Intent intent = new Intent();
            kotlin.g.b.p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == 1) {
                kotlin.g.b.p.g(intent.putExtra("key_finder_post_router", 2), "intent.putExtra(Constant…uterUI.ROUTER_TAKE_PHOTO)");
            } else if (menuItem.getItemId() == 2) {
                kotlin.g.b.p.g(intent.putExtra("key_finder_post_router", 3), "intent.putExtra(Constant…erUI.ROUTER_SELECT_PHOTO)");
            } else if (this.van.udg.containsKey(Integer.valueOf(menuItem.getItemId()))) {
                com.tencent.mm.plugin.finder.utils.r rVar = com.tencent.mm.plugin.finder.utils.r.vWn;
                com.tencent.mm.plugin.finder.utils.r.a(this.van.getActivity(), (ddk) this.van.udg.get(Integer.valueOf(menuItem.getItemId())));
                com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
                com.tencent.mm.plugin.finder.report.i.as(2, false);
            }
            intent.putExtra("key_finder_post_from", 1);
            intent.putExtra("key_finder_post_id", this.uPz);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(this.vao, intent);
            AppMethodBeat.o(250039);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class r implements e.b {
        public static final r vap = new r();

        static {
            AppMethodBeat.i(250041);
            AppMethodBeat.o(250041);
        }

        r() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(250040);
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.Ks(6);
            AppMethodBeat.o(250040);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC$OnOffsetChangedListener;", "Landroid/support/design/widget/AppBarLayout$OnOffsetChangedListener;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActionBarUIC;)V", "onOffsetChanged", "", "view", "Landroid/support/design/widget/AppBarLayout;", "offset", "", "plugin-finder_release"})
    public final class b implements AppBarLayout.b {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.support.design.widget.AppBarLayout.a, android.support.design.widget.AppBarLayout.b
        public final void c(AppBarLayout appBarLayout, int i2) {
            float f2;
            AppMethodBeat.i(250024);
            kotlin.g.b.p.h(appBarLayout, "view");
            FinderProfileActionBarUIC.this.vak = i2;
            float abs = (((float) Math.abs(i2)) * 1.0f) / ((float) appBarLayout.getTotalScrollRange());
            if (abs == FinderProfileActionBarUIC.this.vai) {
                AppMethodBeat.o(250024);
                return;
            }
            FinderProfileActionBarUIC.this.vai = abs;
            if (abs < 0.5f) {
                float f3 = (0.5f - abs) / 0.5f;
                FinderProfileActionBarUIC.this.dmg().setBackgroundColor(FinderProfileActionBarUIC.this.getResources().getColor(R.color.ac_));
                AppCompatActivity activity = FinderProfileActionBarUIC.this.getActivity();
                if (activity == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(250024);
                    throw tVar;
                }
                ((MMActivity) activity).getController().updataStatusBarIcon(ao.isDarkMode());
                AppCompatActivity activity2 = FinderProfileActionBarUIC.this.getActivity();
                if (activity2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(250024);
                    throw tVar2;
                }
                ((MMActivity) activity2).getController().p(FinderProfileActionBarUIC.this.getActivity(), FinderProfileActionBarUIC.this.getResources().getColor(R.color.ac_));
                LinearLayout b2 = FinderProfileActionBarUIC.b(FinderProfileActionBarUIC.this);
                kotlin.g.b.p.g(b2, "userInfoLayout");
                b2.setAlpha(0.0f);
                FinderProfileActionBarUIC.a(FinderProfileActionBarUIC.this, abs, f3);
                f2 = f3;
            } else {
                float f4 = (abs - 0.5f) / 0.5f;
                int i3 = (int) (255.0f * f4);
                FinderProfileActionBarUIC.this.dmg().setBackgroundColor(com.tencent.mm.ui.ar.fj(FinderProfileActionBarUIC.this.vaf, i3));
                AppCompatActivity activity3 = FinderProfileActionBarUIC.this.getActivity();
                if (activity3 == null) {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(250024);
                    throw tVar3;
                }
                ((MMActivity) activity3).getController().setStatusBarColor(com.tencent.mm.ui.ar.fj(FinderProfileActionBarUIC.this.vaf, i3));
                LinearLayout b3 = FinderProfileActionBarUIC.b(FinderProfileActionBarUIC.this);
                kotlin.g.b.p.g(b3, "userInfoLayout");
                b3.setAlpha(f4);
                FinderProfileActionBarUIC.a(FinderProfileActionBarUIC.this, abs, f4);
                f2 = f4;
            }
            WeImageView e2 = FinderProfileActionBarUIC.e(FinderProfileActionBarUIC.this);
            kotlin.g.b.p.g(e2, "backBtnIv");
            e2.setAlpha(f2);
            WeImageView f5 = FinderProfileActionBarUIC.f(FinderProfileActionBarUIC.this);
            kotlin.g.b.p.g(f5, "postBtnIv");
            f5.setAlpha(f2);
            AppMethodBeat.o(250024);
        }
    }

    private static void ah(View view, int i2) {
        AppMethodBeat.i(250076);
        if (view.getVisibility() != i2) {
            view.setVisibility(i2);
        }
        AppMethodBeat.o(250076);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        String str2;
        AppMethodBeat.i(250077);
        kotlin.g.b.p.h(qVar, "scene");
        if (i2 == 0 && i3 == 0 && (qVar instanceof cn)) {
            StringBuilder append = new StringBuilder("username=").append(this.username).append(", scene username=");
            FinderContact cZk = ((cn) qVar).cZk();
            Log.i("Finder.SelfProfileActionBarUIC", append.append(cZk != null ? cZk.username : null).toString());
            FinderContact cZk2 = ((cn) qVar).cZk();
            if (!(cZk2 == null || (str2 = cZk2.username) == null)) {
                kotlin.g.b.p.g(str2, LocaleUtil.ITALIAN);
                this.username = str2;
            }
            com.tencent.mm.plugin.finder.api.g profileContact = getProfileContact();
            if (profileContact == null) {
                AppMethodBeat.o(250077);
                return;
            }
            TextView dmk = dmk();
            kotlin.g.b.p.g(dmk, "actionBarNicknameTv");
            dmk.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getActivity(), profileContact.getNickname()));
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(profileContact.field_avatarUrl);
            ImageView dmj = dmj();
            kotlin.g.b.p.g(dmj, "actionBarAvatarIv");
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            dka.a(aVar, dmj, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
        }
        AppMethodBeat.o(250077);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(250032);
            LinearLayout linearLayout = (LinearLayout) this.uQi.findViewById(R.id.xq);
            AppMethodBeat.o(250032);
            return linearLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ah extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ah(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(250057);
            LinearLayout linearLayout = (LinearLayout) this.uQi.findViewById(R.id.ger);
            AppMethodBeat.o(250057);
            return linearLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class v extends kotlin.g.b.q implements kotlin.g.a.a<FrameLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FrameLayout invoke() {
            AppMethodBeat.i(250045);
            FrameLayout frameLayout = (FrameLayout) this.uQi.findViewById(R.id.e0);
            AppMethodBeat.o(250045);
            return frameLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(250027);
            WeImageView weImageView = (WeImageView) this.uQi.findViewById(R.id.e2);
            AppMethodBeat.o(250027);
            return weImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250026);
            TextView textView = (TextView) this.uQi.findViewById(R.id.e1);
            AppMethodBeat.o(250026);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/design/widget/AppBarLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<AppBarLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AppBarLayout invoke() {
            AppMethodBeat.i(250031);
            AppBarLayout appBarLayout = (AppBarLayout) this.uQi.findViewById(R.id.sm);
            AppMethodBeat.o(250031);
            return appBarLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(250033);
            WeImageView weImageView = (WeImageView) this.uQi.findViewById(R.id.xr);
            AppMethodBeat.o(250033);
            return weImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ai extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ai(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(250058);
            WeImageView weImageView = (WeImageView) this.uQi.findViewById(R.id.ges);
            AppMethodBeat.o(250058);
            return weImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ab extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ab(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(250051);
            LinearLayout linearLayout = (LinearLayout) this.uQi.findViewById(R.id.fsn);
            AppMethodBeat.o(250051);
            return linearLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class z extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(250049);
            LinearLayout linearLayout = (LinearLayout) this.uQi.findViewById(R.id.fjo);
            AppMethodBeat.o(250049);
            return linearLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class aa extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aa(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(250050);
            WeImageView weImageView = (WeImageView) this.uQi.findViewById(R.id.fjp);
            AppMethodBeat.o(250050);
            return weImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/HardTouchableLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<HardTouchableLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ HardTouchableLayout invoke() {
            AppMethodBeat.i(250034);
            HardTouchableLayout hardTouchableLayout = (HardTouchableLayout) this.uQi.findViewById(R.id.bea);
            AppMethodBeat.o(250034);
            return hardTouchableLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class al extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        al(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(250061);
            LinearLayout linearLayout = (LinearLayout) this.uQi.findViewById(R.id.gl0);
            AppMethodBeat.o(250061);
            return linearLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/design/widget/CoordinatorLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<CoordinatorLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ CoordinatorLayout invoke() {
            AppMethodBeat.i(250035);
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.uQi.findViewById(R.id.bg4);
            AppMethodBeat.o(250035);
            return coordinatorLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(250025);
            ImageView imageView = (ImageView) this.uQi.findViewById(R.id.dq);
            AppMethodBeat.o(250025);
            return imageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250028);
            TextView textView = (TextView) this.uQi.findViewById(R.id.e7);
            AppMethodBeat.o(250028);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class x extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderProfileActionBarUIC van;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            super(0);
            this.van = finderProfileActionBarUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(250047);
            Boolean valueOf = Boolean.valueOf(this.van.getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false));
            AppMethodBeat.o(250047);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderProfileActionBarUIC van;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(FinderProfileActionBarUIC finderProfileActionBarUIC) {
            super(0);
            this.van = finderProfileActionBarUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(250046);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(this.van.username, com.tencent.mm.model.z.aUg()));
            AppMethodBeat.o(250046);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePostBtnUIC;", "invoke"})
    static final class y extends kotlin.g.b.q implements kotlin.g.a.a<FinderLivePostBtnUIC> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderLivePostBtnUIC invoke() {
            AppMethodBeat.i(250048);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderLivePostBtnUIC finderLivePostBtnUIC = (FinderLivePostBtnUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(FinderLivePostBtnUIC.class);
            AppMethodBeat.o(250048);
            return finderLivePostBtnUIC;
        }
    }

    public static final /* synthetic */ void a(FinderProfileActionBarUIC finderProfileActionBarUIC, float f2, float f3) {
        AppMethodBeat.i(250082);
        if (!finderProfileActionBarUIC.isSelf()) {
            if (((double) f2) < 0.5d) {
                LinearLayout dmh = finderProfileActionBarUIC.dmh();
                kotlin.g.b.p.g(dmh, "moreBtn");
                ah(dmh, 0);
                FrameLayout dme = finderProfileActionBarUIC.dme();
                kotlin.g.b.p.g(dme, "followContainer");
                ah(dme, 8);
                LinearLayout dmh2 = finderProfileActionBarUIC.dmh();
                kotlin.g.b.p.g(dmh2, "moreBtn");
                dmh2.setAlpha(f3);
                AppMethodBeat.o(250082);
                return;
            }
            LinearLayout dmh3 = finderProfileActionBarUIC.dmh();
            kotlin.g.b.p.g(dmh3, "moreBtn");
            ah(dmh3, 8);
            FrameLayout dme2 = finderProfileActionBarUIC.dme();
            kotlin.g.b.p.g(dme2, "followContainer");
            ah(dme2, 0);
            FrameLayout dme3 = finderProfileActionBarUIC.dme();
            kotlin.g.b.p.g(dme3, "followContainer");
            dme3.setAlpha(f3);
        }
        AppMethodBeat.o(250082);
    }

    public static final /* synthetic */ WeImageView e(FinderProfileActionBarUIC finderProfileActionBarUIC) {
        AppMethodBeat.i(250083);
        WeImageView weImageView = (WeImageView) finderProfileActionBarUIC.uZT.getValue();
        AppMethodBeat.o(250083);
        return weImageView;
    }

    public static final /* synthetic */ WeImageView f(FinderProfileActionBarUIC finderProfileActionBarUIC) {
        AppMethodBeat.i(250084);
        WeImageView weImageView = (WeImageView) finderProfileActionBarUIC.uZU.getValue();
        AppMethodBeat.o(250084);
        return weImageView;
    }

    public static final /* synthetic */ void g(FinderProfileActionBarUIC finderProfileActionBarUIC) {
        AppMethodBeat.i(250085);
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.f(finderProfileActionBarUIC.getActivity(), 1, 2);
        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.f(finderProfileActionBarUIC.getActivity(), 1, 3);
        com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.f(finderProfileActionBarUIC.getActivity(), 2, 1);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) finderProfileActionBarUIC.getActivity(), 1, false);
        eVar.a(new s(finderProfileActionBarUIC));
        eVar.a(new t(finderProfileActionBarUIC));
        eVar.b(new u(finderProfileActionBarUIC));
        eVar.dGm();
        AppMethodBeat.o(250085);
    }

    public static final /* synthetic */ void h(FinderProfileActionBarUIC finderProfileActionBarUIC) {
        AppMethodBeat.i(250086);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) finderProfileActionBarUIC.getActivity(), 1, false);
        eVar.a(new n(finderProfileActionBarUIC));
        eVar.a(new o(finderProfileActionBarUIC));
        eVar.dGm();
        AppMethodBeat.o(250086);
    }

    public static final /* synthetic */ void l(FinderProfileActionBarUIC finderProfileActionBarUIC) {
        AppMethodBeat.i(250088);
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (!com.tencent.mm.plugin.finder.spam.a.avp("post")) {
            AppCompatActivity activity = finderProfileActionBarUIC.getActivity();
            StringBuilder sb = new StringBuilder();
            kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
            String sb2 = sb.append(com.tencent.mm.kernel.a.ayV()).append('_').append(Util.nowMilliSecond()).toString();
            com.tencent.mm.plugin.finder.activity.b bVar = com.tencent.mm.plugin.finder.activity.b.tqg;
            int i2 = com.tencent.mm.plugin.finder.activity.b.b(null, 5) ? 9 : 2;
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fs(activity);
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.as(i2, false);
            com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.auI(sb2);
            com.tencent.mm.plugin.finder.report.i iVar3 = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.H(false, i2);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) activity, 1, false);
            View inflate = com.tencent.mm.ui.aa.jQ(activity).inflate(R.layout.ak1, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.fzc);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.wm);
            c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(com.tencent.mm.model.z.aUg());
            if (asG != null) {
                kotlin.g.b.p.g(textView, "nicknameTv");
                textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(activity, asG.getNickname()));
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
            eVar.a(new p(finderProfileActionBarUIC));
            eVar.a(new q(finderProfileActionBarUIC, sb2, activity));
            eVar.b(r.vap);
            eVar.dGm();
        }
        AppMethodBeat.o(250088);
    }

    public static final /* synthetic */ void m(FinderProfileActionBarUIC finderProfileActionBarUIC) {
        AppMethodBeat.i(250089);
        ((FinderLivePostBtnUIC) finderProfileActionBarUIC.vaj.getValue()).dIn();
        AppMethodBeat.o(250089);
    }
}
