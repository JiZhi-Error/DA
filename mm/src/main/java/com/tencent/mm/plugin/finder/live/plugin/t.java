package com.tencent.mm.plugin.finder.live.plugin;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.live.widget.e;
import com.tencent.mm.plugin.finder.live.widget.h;
import com.tencent.mm.plugin.finder.live.widget.i;
import com.tencent.mm.plugin.finder.live.widget.j;
import com.tencent.mm.plugin.finder.live.widget.k;
import com.tencent.mm.plugin.finder.live.widget.n;
import com.tencent.mm.plugin.finder.live.widget.u;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBeforePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "postUIC", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;", "keyboardChange", "", "show", "", "height", "", "setupData", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class t extends d {
    public static final a unY = new a((byte) 0);
    private final b hOp;
    public FinderLivePostUIC unX;

    static {
        AppMethodBeat.i(246527);
        AppMethodBeat.o(246527);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        String str;
        Long l;
        Long l2;
        int i2;
        String str2;
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246526);
        this.hOp = bVar;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        Context context = viewGroup.getContext();
        if (context == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(246526);
            throw tVar;
        }
        ViewModel viewModel = com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderLivePostUIC.class);
        p.g(viewModel, "UICProvider.of(root.cont…rLivePostUIC::class.java)");
        this.unX = (FinderLivePostUIC) viewModel;
        FinderLivePostUIC finderLivePostUIC = this.unX;
        ViewGroup viewGroup2 = viewGroup;
        b bVar2 = this.hOp;
        g liveData = getLiveData();
        AnonymousClass1 r0 = new kotlin.g.a.b<FinderObjectDesc, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.t.AnonymousClass1 */
            final /* synthetic */ t unZ;

            {
                this.unZ = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(FinderObjectDesc finderObjectDesc) {
                AppMethodBeat.i(246522);
                FinderObjectDesc finderObjectDesc2 = finderObjectDesc;
                p.h(finderObjectDesc2, LocaleUtil.ITALIAN);
                b bVar = this.unZ.hOp;
                b.c cVar = b.c.hMx;
                Bundle bundle = new Bundle();
                bundle.putByteArray("PARAM_KEY_POST_OBJECT_DESC", finderObjectDesc2.toByteArray());
                bVar.statusChange(cVar, bundle);
                x xVar = x.SXb;
                AppMethodBeat.o(246522);
                return xVar;
            }
        };
        p.h(viewGroup2, "rootView");
        p.h(bVar2, "statusMonitor");
        p.h(liveData, "liveData");
        p.h(r0, "onStartLive");
        finderLivePostUIC.hOp = bVar2;
        finderLivePostUIC.liveData = liveData;
        finderLivePostUIC.uCD = viewGroup2;
        b.a aVar2 = com.tencent.mm.live.core.core.a.b.hyv;
        View view = finderLivePostUIC.uCD;
        if (view == null) {
            p.btv("postLayout");
        }
        view.getContext();
        finderLivePostUIC.hOO = b.a.aDo();
        finderLivePostUIC.uCZ = r0;
        View view2 = finderLivePostUIC.uCD;
        if (view2 == null) {
            p.btv("postLayout");
        }
        View findViewById = view2.findViewById(R.id.cwc);
        p.g(findViewById, "postLayout.findViewById(R.id.finder_live_post_btn)");
        finderLivePostUIC.uCE = (TextView) findViewById;
        AppCompatActivity activity = finderLivePostUIC.getActivity();
        if (activity == null) {
            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(246526);
            throw tVar2;
        }
        MMActivity mMActivity = (MMActivity) activity;
        View view3 = finderLivePostUIC.uCD;
        if (view3 == null) {
            p.btv("postLayout");
        }
        View findViewById2 = view3.findViewById(R.id.cwg);
        p.g(findViewById2, "postLayout.findViewById(…r_live_post_cover_layout)");
        finderLivePostUIC.uCG = new h(mMActivity, (ViewGroup) findViewById2, finderLivePostUIC.uDa);
        AppCompatActivity activity2 = finderLivePostUIC.getActivity();
        if (activity2 == null) {
            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(246526);
            throw tVar3;
        }
        finderLivePostUIC.uCF = new k((MMActivity) activity2, viewGroup2);
        AppCompatActivity activity3 = finderLivePostUIC.getActivity();
        if (activity3 == null) {
            kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(246526);
            throw tVar4;
        }
        MMActivity mMActivity2 = (MMActivity) activity3;
        View view4 = finderLivePostUIC.uCD;
        if (view4 == null) {
            p.btv("postLayout");
        }
        View findViewById3 = view4.findViewById(R.id.gfe);
        p.g(findViewById3, "postLayout.findViewById(…d.post_license_container)");
        finderLivePostUIC.uCH = new j(mMActivity2, (ViewGroup) findViewById3, finderLivePostUIC.uDa);
        AppCompatActivity activity4 = finderLivePostUIC.getActivity();
        if (activity4 == null) {
            kotlin.t tVar5 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(246526);
            throw tVar5;
        }
        MMActivity mMActivity3 = (MMActivity) activity4;
        View view5 = finderLivePostUIC.uCD;
        if (view5 == null) {
            p.btv("postLayout");
        }
        finderLivePostUIC.uCJ = new i(mMActivity3, view5);
        View view6 = finderLivePostUIC.uCD;
        if (view6 == null) {
            p.btv("postLayout");
        }
        View findViewById4 = view6.findViewById(R.id.cw7);
        p.g(findViewById4, "postLayout.findViewById(…_notice_time_info_layout)");
        finderLivePostUIC.uCM = findViewById4;
        View view7 = finderLivePostUIC.uCD;
        if (view7 == null) {
            p.btv("postLayout");
        }
        View findViewById5 = view7.findViewById(R.id.cyt);
        p.g(findViewById5, "postLayout.findViewById(…inder_live_visibility_tv)");
        finderLivePostUIC.uCN = (TextView) findViewById5;
        View view8 = finderLivePostUIC.uCD;
        if (view8 == null) {
            p.btv("postLayout");
        }
        View findViewById6 = view8.findViewById(R.id.jz0);
        p.g(findViewById6, "postLayout.findViewById(…_visibility_range_layout)");
        finderLivePostUIC.UPQ = findViewById6;
        View view9 = finderLivePostUIC.uCD;
        if (view9 == null) {
            p.btv("postLayout");
        }
        View findViewById7 = view9.findViewById(R.id.cw8);
        p.g(findViewById7, "postLayout.findViewById(…der_live_notice_time_txt)");
        finderLivePostUIC.uCO = (TextView) findViewById7;
        View view10 = finderLivePostUIC.uCD;
        if (view10 == null) {
            p.btv("postLayout");
        }
        View findViewById8 = view10.findViewById(R.id.cop);
        p.g(findViewById8, "postLayout.findViewById(…_before_camera_opt_panel)");
        finderLivePostUIC.uCP = (RecyclerView) findViewById8;
        View view11 = finderLivePostUIC.uCD;
        if (view11 == null) {
            p.btv("postLayout");
        }
        View findViewById9 = view11.findViewById(R.id.cwk);
        p.g(findViewById9, "postLayout.findViewById(…d.finder_live_post_group)");
        finderLivePostUIC.uCQ = findViewById9;
        View view12 = finderLivePostUIC.uCD;
        if (view12 == null) {
            p.btv("postLayout");
        }
        View findViewById10 = view12.findViewById(R.id.cwf);
        p.g(findViewById10, "postLayout.findViewById(…r_live_post_content_root)");
        finderLivePostUIC.uCR = findViewById10;
        View view13 = finderLivePostUIC.uCD;
        if (view13 == null) {
            p.btv("postLayout");
        }
        View findViewById11 = view13.findViewById(R.id.cwy);
        p.g(findViewById11, "postLayout.findViewById(…id.finder_live_post_mask)");
        finderLivePostUIC.maskView = findViewById11;
        View view14 = finderLivePostUIC.uCD;
        if (view14 == null) {
            p.btv("postLayout");
        }
        View findViewById12 = view14.findViewById(R.id.cx6);
        p.g(findViewById12, "postLayout.findViewById(…inder_live_post_top_more)");
        finderLivePostUIC.uCU = findViewById12;
        View view15 = finderLivePostUIC.uCD;
        if (view15 == null) {
            p.btv("postLayout");
        }
        View findViewById13 = view15.findViewById(R.id.cp5);
        p.g(findViewById13, "postLayout.findViewById(…_camera_opt_panel_filter)");
        finderLivePostUIC.uCS = (RelativeLayout) findViewById13;
        View view16 = finderLivePostUIC.uCD;
        if (view16 == null) {
            p.btv("postLayout");
        }
        View findViewById14 = view16.findViewById(R.id.cow);
        p.g(findViewById14, "postLayout.findViewById(…_camera_opt_panel_beauty)");
        finderLivePostUIC.uCT = (RelativeLayout) findViewById14;
        View view17 = finderLivePostUIC.uCD;
        if (view17 == null) {
            p.btv("postLayout");
        }
        View findViewById15 = view17.findViewById(R.id.cy9);
        p.g(findViewById15, "postLayout.findViewById(…d.finder_live_tag_layout)");
        finderLivePostUIC.uCV = new n((LinearLayout) findViewById15, liveData);
        AppCompatActivity activity5 = finderLivePostUIC.getActivity();
        if (activity5 == null) {
            kotlin.t tVar6 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(246526);
            throw tVar6;
        }
        MMActivity mMActivity4 = (MMActivity) activity5;
        View view18 = finderLivePostUIC.uCD;
        if (view18 == null) {
            p.btv("postLayout");
        }
        View findViewById16 = view18.findViewById(R.id.cwo);
        p.g(findViewById16, "postLayout.findViewById(…st_license_panel_ui_root)");
        finderLivePostUIC.uCI = new com.tencent.mm.plugin.finder.live.widget.g(mMActivity4, (ViewGroup) findViewById16, new FinderLivePostUIC.h(finderLivePostUIC));
        View view19 = finderLivePostUIC.uCD;
        if (view19 == null) {
            p.btv("postLayout");
        }
        View findViewById17 = view19.findViewById(R.id.jy0);
        p.g(findViewById17, "postLayout.findViewById(…_live_lucky_money_layout)");
        finderLivePostUIC.UPR = new u((LinearLayout) findViewById17, liveData);
        h hVar = finderLivePostUIC.uCG;
        if (hVar == null) {
            p.btv("coverWidget");
        }
        c.a aVar3 = c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
        Log.i(hVar.TAG, "setCover liveCover:" + (asG != null ? asG.field_liveCoverImg : null));
        if (!Util.isNullOrNil(asG != null ? asG.field_liveCoverImg : null)) {
            hVar.uEu = (asG == null || (str2 = asG.field_liveCoverImg) == null) ? "" : str2;
            m mVar = m.uJa;
            d<o> dkc = m.dkc();
            com.tencent.mm.plugin.finder.loader.a aVar4 = new com.tencent.mm.plugin.finder.loader.a(hVar.uEu);
            ImageView imageView = hVar.puw;
            m mVar2 = m.uJa;
            dkc.a(aVar4, imageView, m.a(m.a.WX_AVATAR));
        } else {
            if (!Util.isNullOrNil(asG != null ? asG.field_avatarUrl : null)) {
                hVar.kog = (asG == null || (str = asG.field_avatarUrl) == null) ? "" : str;
                m mVar3 = m.uJa;
                d<o> dkc2 = m.dkc();
                com.tencent.mm.plugin.finder.loader.a aVar5 = new com.tencent.mm.plugin.finder.loader.a(hVar.kog);
                ImageView imageView2 = hVar.puw;
                m mVar4 = m.uJa;
                dkc2.a(aVar5, imageView2, m.a(m.a.WX_AVATAR));
            }
        }
        hVar.uGJ.onChange();
        j jVar = finderLivePostUIC.uCH;
        if (jVar == null) {
            p.btv("licenseWidget");
        }
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        if (!com.tencent.mm.plugin.finder.report.live.k.dpl().vmk) {
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            if (!com.tencent.mm.plugin.finder.report.live.k.dpl().vml) {
                if (jVar.uvm == 1) {
                    jVar.uGJ.onChange();
                    jVar.jxm.setVisibility(8);
                    i2 = s.ai.LIVE_RULE_ALREADY_OK.action;
                } else {
                    jVar.jxm.setVisibility(0);
                    i2 = s.ai.LIVE_RULE_SHOW.action;
                }
                com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_RULE.hlf, String.valueOf(i2));
                com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.KI(i2);
            }
        }
        View view20 = finderLivePostUIC.uCD;
        if (view20 == null) {
            p.btv("postLayout");
        }
        View findViewById18 = view20.findViewById(R.id.cx2);
        p.g(findViewById18, "postLayout.findViewById(…nder_live_post_top_group)");
        finderLivePostUIC.uCK = (RelativeLayout) findViewById18;
        RelativeLayout relativeLayout = finderLivePostUIC.uCK;
        if (relativeLayout == null) {
            p.btv("topContainer");
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (layoutParams == null) {
            kotlin.t tVar7 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(246526);
            throw tVar7;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = au.getStatusBarHeight(finderLivePostUIC.getActivity()) + marginLayoutParams.topMargin;
        View view21 = finderLivePostUIC.uCR;
        if (view21 == null) {
            p.btv("contentRoot");
        }
        View view22 = finderLivePostUIC.uCR;
        if (view22 == null) {
            p.btv("contentRoot");
        }
        int paddingLeft = view22.getPaddingLeft();
        View view23 = finderLivePostUIC.uCR;
        if (view23 == null) {
            p.btv("contentRoot");
        }
        int paddingTop = view23.getPaddingTop();
        View view24 = finderLivePostUIC.uCR;
        if (view24 == null) {
            p.btv("contentRoot");
        }
        int paddingRight = view24.getPaddingRight();
        View view25 = finderLivePostUIC.uCR;
        if (view25 == null) {
            p.btv("contentRoot");
        }
        view21.setPadding(paddingLeft, paddingTop, paddingRight, au.aD(finderLivePostUIC.getActivity()) + view25.getPaddingBottom());
        RelativeLayout relativeLayout2 = finderLivePostUIC.uCS;
        if (relativeLayout2 == null) {
            p.btv("filterRootView");
        }
        RelativeLayout relativeLayout3 = finderLivePostUIC.uCS;
        if (relativeLayout3 == null) {
            p.btv("filterRootView");
        }
        int paddingLeft2 = relativeLayout3.getPaddingLeft();
        RelativeLayout relativeLayout4 = finderLivePostUIC.uCS;
        if (relativeLayout4 == null) {
            p.btv("filterRootView");
        }
        int paddingTop2 = relativeLayout4.getPaddingTop();
        RelativeLayout relativeLayout5 = finderLivePostUIC.uCS;
        if (relativeLayout5 == null) {
            p.btv("filterRootView");
        }
        int paddingRight2 = relativeLayout5.getPaddingRight();
        RelativeLayout relativeLayout6 = finderLivePostUIC.uCS;
        if (relativeLayout6 == null) {
            p.btv("filterRootView");
        }
        relativeLayout2.setPadding(paddingLeft2, paddingTop2, paddingRight2, au.aD(finderLivePostUIC.getActivity()) + relativeLayout6.getPaddingBottom());
        RelativeLayout relativeLayout7 = finderLivePostUIC.uCT;
        if (relativeLayout7 == null) {
            p.btv("beautyRootView");
        }
        RelativeLayout relativeLayout8 = finderLivePostUIC.uCT;
        if (relativeLayout8 == null) {
            p.btv("beautyRootView");
        }
        int paddingLeft3 = relativeLayout8.getPaddingLeft();
        RelativeLayout relativeLayout9 = finderLivePostUIC.uCT;
        if (relativeLayout9 == null) {
            p.btv("beautyRootView");
        }
        int paddingTop3 = relativeLayout9.getPaddingTop();
        RelativeLayout relativeLayout10 = finderLivePostUIC.uCT;
        if (relativeLayout10 == null) {
            p.btv("beautyRootView");
        }
        int paddingRight3 = relativeLayout10.getPaddingRight();
        RelativeLayout relativeLayout11 = finderLivePostUIC.uCT;
        if (relativeLayout11 == null) {
            p.btv("beautyRootView");
        }
        relativeLayout7.setPadding(paddingLeft3, paddingTop3, paddingRight3, au.aD(finderLivePostUIC.getActivity()) + relativeLayout11.getPaddingBottom());
        View view26 = finderLivePostUIC.uCD;
        if (view26 == null) {
            p.btv("postLayout");
        }
        View findViewById19 = view26.findViewById(R.id.cx1);
        p.g(findViewById19, "postLayout.findViewById(…nder_live_post_top_close)");
        finderLivePostUIC.uCL = (WeImageView) findViewById19;
        WeImageView weImageView = finderLivePostUIC.uCL;
        if (weImageView == null) {
            p.btv("topBack");
        }
        weImageView.post(new FinderLivePostUIC.i(finderLivePostUIC));
        WeImageView weImageView2 = finderLivePostUIC.uCL;
        if (weImageView2 == null) {
            p.btv("topBack");
        }
        weImageView2.setOnClickListener(finderLivePostUIC);
        View view27 = finderLivePostUIC.uCU;
        if (view27 == null) {
            p.btv("topMoreActionBtn");
        }
        view27.setOnClickListener(finderLivePostUIC);
        RelativeLayout relativeLayout12 = finderLivePostUIC.uCS;
        if (relativeLayout12 == null) {
            p.btv("filterRootView");
        }
        relativeLayout12.setOnClickListener(finderLivePostUIC);
        RelativeLayout relativeLayout13 = finderLivePostUIC.uCT;
        if (relativeLayout13 == null) {
            p.btv("beautyRootView");
        }
        relativeLayout13.setOnClickListener(finderLivePostUIC);
        View view28 = finderLivePostUIC.maskView;
        if (view28 == null) {
            p.btv("maskView");
        }
        view28.setOnClickListener(finderLivePostUIC);
        RelativeLayout relativeLayout14 = finderLivePostUIC.uCS;
        if (relativeLayout14 == null) {
            p.btv("filterRootView");
        }
        finderLivePostUIC.umJ = new e(relativeLayout14, finderLivePostUIC.hOO);
        RelativeLayout relativeLayout15 = finderLivePostUIC.uCT;
        if (relativeLayout15 == null) {
            p.btv("beautyRootView");
        }
        finderLivePostUIC.umK = new com.tencent.mm.plugin.finder.live.widget.d(relativeLayout15, finderLivePostUIC.hOO);
        e eVar = finderLivePostUIC.umJ;
        if (eVar == null) {
            p.btv("filterWidget");
        }
        eVar.uFO = new FinderLivePostUIC.j(finderLivePostUIC);
        com.tencent.mm.plugin.finder.live.widget.d dVar = finderLivePostUIC.umK;
        if (dVar == null) {
            p.btv("beautyWidget");
        }
        dVar.uFO = new FinderLivePostUIC.k(finderLivePostUIC);
        View view29 = finderLivePostUIC.uCQ;
        if (view29 == null) {
            p.btv("postBtnGroup");
        }
        view29.setEnabled(true);
        View view30 = finderLivePostUIC.uCQ;
        if (view30 == null) {
            p.btv("postBtnGroup");
        }
        view30.setOnClickListener(new FinderLivePostUIC.l(finderLivePostUIC));
        TextView textView = finderLivePostUIC.uCE;
        if (textView == null) {
            p.btv("postBtn");
        }
        textView.setTextColor(finderLivePostUIC.getActivity().getResources().getColor(R.color.am));
        TextView textView2 = finderLivePostUIC.uCE;
        if (textView2 == null) {
            p.btv("postBtn");
        }
        ao.a(textView2.getPaint(), 0.8f);
        finderLivePostUIC.uCX = new FinderLivePostUIC.m(finderLivePostUIC);
        finderLivePostUIC.diY();
        RecyclerView recyclerView = finderLivePostUIC.uCP;
        if (recyclerView == null) {
            p.btv("cameraOptPanel");
        }
        recyclerView.setAdapter(new FinderLivePostUIC.a());
        RecyclerView recyclerView2 = finderLivePostUIC.uCP;
        if (recyclerView2 == null) {
            p.btv("cameraOptPanel");
        }
        View view31 = finderLivePostUIC.uCD;
        if (view31 == null) {
            p.btv("postLayout");
        }
        view31.getContext();
        recyclerView2.setLayoutManager(new LinearLayoutManager(0, false));
        c.a aVar6 = c.tsp;
        finderLivePostUIC.uCY = c.a.asG(z.aUg());
        com.tencent.mm.plugin.finder.utils.m mVar5 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.api.g gVar = finderLivePostUIC.uCY;
        if (!com.tencent.mm.plugin.finder.utils.m.Gc(gVar != null ? gVar.field_liveSwitchFlag : 0)) {
            finderLivePostUIC.diR();
        }
        com.tencent.mm.plugin.finder.utils.m mVar6 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.api.g gVar2 = finderLivePostUIC.uCY;
        if (!com.tencent.mm.plugin.finder.utils.m.Gd(gVar2 != null ? gVar2.field_liveSwitchFlag : 0)) {
            finderLivePostUIC.diU();
        }
        String str3 = FinderLivePostUIC.TAG;
        StringBuilder sb = new StringBuilder("setupConfig selfContact.anchorStatus:");
        com.tencent.mm.plugin.finder.api.g gVar3 = finderLivePostUIC.uCY;
        if (gVar3 != null) {
            l = Long.valueOf(gVar3.field_liveAnchorStatusFlag);
        } else {
            l = null;
        }
        StringBuilder append = sb.append(l).append(" switchFlag:");
        com.tencent.mm.plugin.finder.api.g gVar4 = finderLivePostUIC.uCY;
        if (gVar4 != null) {
            l2 = Long.valueOf(gVar4.field_liveSwitchFlag);
        } else {
            l2 = null;
        }
        Log.i(str3, append.append(l2).toString());
        finderLivePostUIC.hTS();
        ArrayList<String> stringArrayListExtra = finderLivePostUIC.getActivity().getIntent().getStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME");
        Log.i(FinderLivePostUIC.TAG, "onCreate REQUEST_CODE_SELECT_LUCKY_MONEY_ROOM chatroomList:".concat(String.valueOf(stringArrayListExtra)));
        if (stringArrayListExtra != null) {
            if (!stringArrayListExtra.isEmpty()) {
                finderLivePostUIC.bE(stringArrayListExtra);
                ArrayList<String> arrayList = liveData.UQg;
                if (arrayList != null) {
                    arrayList.clear();
                    x xVar = x.SXb;
                }
                ArrayList<String> arrayList2 = liveData.UQf;
                if (arrayList2 != null) {
                    Boolean.valueOf(arrayList2.addAll(stringArrayListExtra));
                }
                liveData.uFa = 2;
            }
        }
        finderLivePostUIC.hTT();
        AppMethodBeat.o(246526);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBeforePlugin$Companion;", "", "()V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void keyboardChange(boolean z, int i2) {
        AppMethodBeat.i(246524);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        Context context = this.hwr.getContext();
        if (context == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(246524);
            throw tVar;
        }
        ViewModel viewModel = com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderLivePostUIC.class);
        p.g(viewModel, "UICProvider.of(root.cont…rLivePostUIC::class.java)");
        i iVar = ((FinderLivePostUIC) viewModel).uCJ;
        if (iVar == null) {
            p.btv("descWidget");
        }
        if (iVar != null) {
            if (z) {
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                i2 = au.aD(iVar.activity) + i2 + context2.getResources().getDimensionPixelOffset(R.dimen.cb);
            }
            ViewGroup.LayoutParams layoutParams = iVar.uGQ.getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(246524);
                throw tVar2;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i2;
            if (z) {
                if (iVar.uGO.indexOfChild(iVar.uGP) != -1) {
                    iVar.uGO.removeView(iVar.uGP);
                }
                iVar.uGR.addView(iVar.uGP);
                iVar.uGQ.setVisibility(0);
                iVar.uhh.setVisibility(4);
                iVar.uGS.setText(new StringBuilder().append(iVar.uGV).append('/').append(iVar.MAX_INPUT_SIZE).toString());
                iVar.uGP.requestFocus();
                iVar.uGP.postDelayed(new i.d(iVar), 200);
                AppMethodBeat.o(246524);
                return;
            }
            if (iVar.uGR.indexOfChild(iVar.uGP) != -1) {
                iVar.uGR.removeView(iVar.uGP);
            }
            iVar.uGO.addView(iVar.uGP);
            iVar.uGQ.setVisibility(4);
            iVar.uhh.setVisibility(0);
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_DESCRIPTION.hlf, iVar.getDesc());
            AppMethodBeat.o(246524);
            return;
        }
        AppMethodBeat.o(246524);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(246525);
        p.h(cVar, "status");
        switch (u.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                Context context = this.hwr.getContext();
                if (context != null) {
                    ViewModel viewModel = com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderLivePostUIC.class);
                    p.g(viewModel, "UICProvider.of(root.cont…rLivePostUIC::class.java)");
                    ((FinderLivePostUIC) viewModel).diW();
                    break;
                } else {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(246525);
                    throw tVar;
                }
        }
        AppMethodBeat.o(246525);
    }
}
