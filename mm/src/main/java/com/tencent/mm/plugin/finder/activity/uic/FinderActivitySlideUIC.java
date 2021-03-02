package com.tencent.mm.plugin.finder.activity.uic;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import org.xwalk.core.Log;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b*\u0001 \u0018\u00002\u00020\u0001:\u0001KB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020%H\u0002J\b\u0010>\u001a\u00020;H\u0002J\b\u0010?\u001a\u00020;H\u0002J\b\u0010@\u001a\u00020;H\u0002J\b\u0010A\u001a\u00020;H\u0002J\u0012\u0010B\u001a\u00020;2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u00020;H\u0016J\b\u0010F\u001a\u00020;H\u0002J\b\u0010G\u001a\u00020;H\u0002J\u0018\u0010H\u001a\u00020;2\u0006\u0010I\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020\u0012H\u0002R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR#\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\n \u0007*\u0004\u0018\u00010\u00140\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0018\u001a\n \u0007*\u0004\u0018\u00010\u00190\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R#\u0010&\u001a\n \u0007*\u0004\u0018\u00010'0'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b(\u0010)R#\u0010+\u001a\n \u0007*\u0004\u0018\u00010'0'8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u000b\u001a\u0004\b,\u0010)R\u000e\u0010.\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\u0004\u0018\u0001008BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R#\u00105\u001a\n \u0007*\u0004\u0018\u00010'0'8BX\u0002¢\u0006\f\n\u0004\b7\u0010\u000b\u001a\u0004\b6\u0010)R\u000e\u00108\u001a\u000209X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "actionBarNicknameTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getActionBarNicknameTv", "()Landroid/widget/TextView;", "actionBarNicknameTv$delegate", "Lkotlin/Lazy;", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "getAppBarLayout", "()Landroid/support/design/widget/AppBarLayout;", "appBarLayout$delegate", "appBarLayoutOffset", "", "backBtnIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getBackBtnIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "backBtnIv$delegate", "coordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "getCoordinatorLayout", "()Landroid/support/design/widget/CoordinatorLayout;", "coordinatorLayout$delegate", "coverAlphaView", "Landroid/view/View;", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC$finderTopicInfoListener$1;", "isAvatarLoaded", "", "lastActionBarProgress", "", "moreBtn", "Landroid/widget/LinearLayout;", "getMoreBtn", "()Landroid/widget/LinearLayout;", "moreBtn$delegate", "myActionBar", "getMyActionBar", "myActionBar$delegate", "normalActionBarColor", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "userInfoLayout", "getUserInfoLayout", "userInfoLayout$delegate", ch.COL_USERNAME, "", "changeViewAlpha", "", "progress", "alpha", "fixActionBarStatus", "hideActionBar", "initCustomActionBar", "loadAvatar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setCoveredStyle", "setNormalStyle", "setVisibleStats", "view", "visibleStat", "OnOffsetChangedListener", "plugin-finder_release"})
public final class FinderActivitySlideUIC extends UIComponent {
    private final f UHA = new f(this);
    private View UHy;
    private boolean UHz;
    private bds dMU;
    private final kotlin.f uZS;
    private final kotlin.f uZT;
    private final kotlin.f uZV;
    private final kotlin.f uZW;
    private final kotlin.f uZZ;
    private String username = "";
    private final kotlin.f vaa;
    private final kotlin.f vac;
    private int vaf;
    private float vai;
    private int vak;

    private final AppBarLayout dmf() {
        AppMethodBeat.i(260131);
        AppBarLayout appBarLayout = (AppBarLayout) this.uZS.getValue();
        AppMethodBeat.o(260131);
        return appBarLayout;
    }

    private final LinearLayout dmg() {
        AppMethodBeat.i(260134);
        LinearLayout linearLayout = (LinearLayout) this.uZV.getValue();
        AppMethodBeat.o(260134);
        return linearLayout;
    }

    private final LinearLayout dmi() {
        AppMethodBeat.i(260133);
        LinearLayout linearLayout = (LinearLayout) this.uZZ.getValue();
        AppMethodBeat.o(260133);
        return linearLayout;
    }

    private final TextView dmk() {
        AppMethodBeat.i(260132);
        TextView textView = (TextView) this.vac.getValue();
        AppMethodBeat.o(260132);
        return textView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderActivitySlideUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(260138);
        this.uZS = kotlin.g.ah(new c(appCompatActivity));
        this.vaa = kotlin.g.ah(new e(appCompatActivity));
        this.vac = kotlin.g.ah(new b(appCompatActivity));
        this.uZZ = kotlin.g.ah(new i(appCompatActivity));
        this.uZT = kotlin.g.ah(new d(appCompatActivity));
        this.uZW = kotlin.g.ah(new g(appCompatActivity));
        this.uZV = kotlin.g.ah(new h(appCompatActivity));
        this.vaf = appCompatActivity.getResources().getColor(R.color.pd);
        AppMethodBeat.o(260138);
    }

    public static final /* synthetic */ LinearLayout b(FinderActivitySlideUIC finderActivitySlideUIC) {
        AppMethodBeat.i(260139);
        LinearLayout dmg = finderActivitySlideUIC.dmg();
        AppMethodBeat.o(260139);
        return dmg;
    }

    public static final /* synthetic */ LinearLayout c(FinderActivitySlideUIC finderActivitySlideUIC) {
        AppMethodBeat.i(260140);
        LinearLayout dmi = finderActivitySlideUIC.dmi();
        AppMethodBeat.o(260140);
        return dmi;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class f extends IListener<ih> {
        final /* synthetic */ FinderActivitySlideUIC UHB;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(FinderActivitySlideUIC finderActivitySlideUIC) {
            this.UHB = finderActivitySlideUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ih ihVar) {
            bds bds;
            aqk aqk;
            ih.a aVar;
            ih.a aVar2;
            String str = null;
            AppMethodBeat.i(260127);
            ih ihVar2 = ihVar;
            switch ((ihVar2 == null || (aVar2 = ihVar2.dMT) == null) ? 0 : aVar2.responseCode) {
                case 0:
                    FinderActivitySlideUIC finderActivitySlideUIC = this.UHB;
                    if (ihVar2 == null || (aVar = ihVar2.dMT) == null) {
                        bds = null;
                    } else {
                        bds = aVar.dMU;
                    }
                    finderActivitySlideUIC.dMU = bds;
                    FinderActivitySlideUIC.g(this.UHB);
                    bds bds2 = this.UHB.dMU;
                    if (!(bds2 == null || (aqk = bds2.LNz) == null)) {
                        str = aqk.coverImgUrl;
                    }
                    if (!Util.isNullOrNil(str)) {
                        FinderActivitySlideUIC.i(this.UHB);
                        break;
                    } else {
                        FinderActivitySlideUIC.h(this.UHB);
                        break;
                    }
            }
            AppMethodBeat.o(260127);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(260135);
        super.onCreate(bundle);
        this.UHA.alive();
        String stringExtra = getActivity().getIntent().getStringExtra("key_creator_finder_name");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.username = stringExtra;
        Window window = getActivity().getWindow();
        p.g(window, "activity.window");
        View decorView = window.getDecorView();
        p.g(decorView, "activity.window.decorView");
        decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        com.tencent.mm.ui.b.e(getActivity(), false);
        ActionBar supportActionBar = getActivity().getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setBackgroundDrawable(new ColorDrawable(0));
            supportActionBar.hide();
        }
        int statusBarHeight = au.getStatusBarHeight(getActivity());
        LinearLayout dmg = dmg();
        p.g(dmg, "myActionBar");
        ViewGroup.LayoutParams layoutParams = dmg.getLayoutParams();
        layoutParams.height += statusBarHeight;
        LinearLayout dmg2 = dmg();
        p.g(dmg2, "myActionBar");
        dmg2.setLayoutParams(layoutParams);
        dmg().setPadding(0, statusBarHeight, 0, 0);
        LinearLayout dmi = dmi();
        p.g(dmi, "userInfoLayout");
        dmi.setAlpha(0.0f);
        this.UHy = getActivity().findViewById(R.id.jt4);
        AppBarLayout dmf = dmf();
        a aVar = new a();
        AppBarLayout dmf2 = dmf();
        p.g(dmf2, "appBarLayout");
        aVar.c(dmf2, 0);
        dmf.a(aVar);
        AppMethodBeat.o(260135);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(260136);
        super.onDestroy();
        this.UHA.dead();
        AppMethodBeat.o(260136);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC$OnOffsetChangedListener;", "Landroid/support/design/widget/AppBarLayout$OnOffsetChangedListener;", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivitySlideUIC;)V", "onOffsetChanged", "", "view", "Landroid/support/design/widget/AppBarLayout;", "offset", "", "plugin-finder_release"})
    public final class a implements AppBarLayout.b {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.support.design.widget.AppBarLayout.a, android.support.design.widget.AppBarLayout.b
        public final void c(AppBarLayout appBarLayout, int i2) {
            float f2;
            AppMethodBeat.i(260122);
            p.h(appBarLayout, "view");
            FinderActivitySlideUIC.this.vak = i2;
            float abs = (((float) Math.abs(i2)) * 1.0f) / ((float) appBarLayout.getTotalScrollRange());
            if (abs == FinderActivitySlideUIC.this.vai) {
                AppMethodBeat.o(260122);
                return;
            }
            FinderActivitySlideUIC.this.vai = abs;
            if (abs < 0.5f) {
                f2 = (0.5f - abs) / 0.5f;
                FinderActivitySlideUIC.b(FinderActivitySlideUIC.this).setBackgroundColor(FinderActivitySlideUIC.this.getResources().getColor(R.color.ac_));
                LinearLayout c2 = FinderActivitySlideUIC.c(FinderActivitySlideUIC.this);
                p.g(c2, "userInfoLayout");
                c2.setAlpha(0.0f);
                FinderActivitySlideUIC.a(FinderActivitySlideUIC.this, abs, f2);
            } else {
                f2 = (abs - 0.5f) / 0.5f;
                FinderActivitySlideUIC.b(FinderActivitySlideUIC.this).setBackgroundColor(ar.fj(FinderActivitySlideUIC.this.vaf, (int) (255.0f * f2)));
                LinearLayout c3 = FinderActivitySlideUIC.c(FinderActivitySlideUIC.this);
                p.g(c3, "userInfoLayout");
                c3.setAlpha(f2);
                FinderActivitySlideUIC.a(FinderActivitySlideUIC.this, abs, f2);
            }
            View view = FinderActivitySlideUIC.this.UHy;
            if (view != null) {
                view.setAlpha(abs);
            }
            Log.i("SimpleUIComponent", "alpha : ".concat(String.valueOf(f2)));
            AppMethodBeat.o(260122);
        }
    }

    private static void ah(View view, int i2) {
        AppMethodBeat.i(260137);
        if (view.getVisibility() != i2) {
            view.setVisibility(i2);
        }
        AppMethodBeat.o(260137);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/design/widget/AppBarLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<AppBarLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AppBarLayout invoke() {
            AppMethodBeat.i(260124);
            AppBarLayout appBarLayout = (AppBarLayout) this.uQi.findViewById(R.id.sm);
            AppMethodBeat.o(260124);
            return appBarLayout;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/design/widget/CoordinatorLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<CoordinatorLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ CoordinatorLayout invoke() {
            AppMethodBeat.i(260126);
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.uQi.findViewById(R.id.bg4);
            AppMethodBeat.o(260126);
            return coordinatorLayout;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(260123);
            TextView textView = (TextView) this.uQi.findViewById(R.id.e7);
            AppMethodBeat.o(260123);
            return textView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(260130);
            LinearLayout linearLayout = (LinearLayout) this.uQi.findViewById(R.id.gl0);
            AppMethodBeat.o(260130);
            return linearLayout;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(260125);
            WeImageView weImageView = (WeImageView) this.uQi.findViewById(R.id.ck4);
            AppMethodBeat.o(260125);
            return weImageView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(260128);
            LinearLayout linearLayout = (LinearLayout) this.uQi.findViewById(R.id.ck5);
            AppMethodBeat.o(260128);
            return linearLayout;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(260129);
            LinearLayout linearLayout = (LinearLayout) this.uQi.findViewById(R.id.fd);
            AppMethodBeat.o(260129);
            return linearLayout;
        }
    }

    public static final /* synthetic */ void a(FinderActivitySlideUIC finderActivitySlideUIC, float f2, float f3) {
        AppMethodBeat.i(260141);
        if (((double) f2) < 0.5d) {
            TextView dmk = finderActivitySlideUIC.dmk();
            p.g(dmk, "actionBarNicknameTv");
            ah(dmk, 4);
        } else {
            TextView dmk2 = finderActivitySlideUIC.dmk();
            p.g(dmk2, "actionBarNicknameTv");
            ah(dmk2, 0);
        }
        WeImageView weImageView = (WeImageView) finderActivitySlideUIC.uZT.getValue();
        p.g(weImageView, "backBtnIv");
        weImageView.setAlpha(f3);
        LinearLayout linearLayout = (LinearLayout) finderActivitySlideUIC.uZW.getValue();
        p.g(linearLayout, "moreBtn");
        linearLayout.setAlpha(f3);
        AppMethodBeat.o(260141);
    }

    public static final /* synthetic */ void g(FinderActivitySlideUIC finderActivitySlideUIC) {
        String str;
        aqk aqk;
        String str2;
        AppMethodBeat.i(260142);
        if (!finderActivitySlideUIC.UHz) {
            finderActivitySlideUIC.UHz = true;
            TextView dmk = finderActivitySlideUIC.dmk();
            p.g(dmk, "actionBarNicknameTv");
            AppCompatActivity activity = finderActivitySlideUIC.getActivity();
            bds bds = finderActivitySlideUIC.dMU;
            if (bds != null && (aqk = bds.LNz) != null && (str2 = aqk.eventName) != null) {
                str = str2;
            }
            dmk.setText(com.tencent.mm.pluginsdk.ui.span.l.c(activity, str));
        }
        AppMethodBeat.o(260142);
    }

    public static final /* synthetic */ void h(FinderActivitySlideUIC finderActivitySlideUIC) {
        AppMethodBeat.i(260143);
        finderActivitySlideUIC.vaf = finderActivitySlideUIC.getActivity().getResources().getColor(R.color.f3043a);
        finderActivitySlideUIC.dmk().setTextColor(finderActivitySlideUIC.getResources().getColor(R.color.a2x));
        AppMethodBeat.o(260143);
    }

    public static final /* synthetic */ void i(FinderActivitySlideUIC finderActivitySlideUIC) {
        AppMethodBeat.i(260144);
        finderActivitySlideUIC.dmk().setTextColor(finderActivitySlideUIC.getResources().getColor(R.color.agm));
        AppMethodBeat.o(260144);
    }
}
