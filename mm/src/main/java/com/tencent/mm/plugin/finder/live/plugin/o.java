package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ak;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkAnchorView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveLayoutManager;
import com.tencent.mm.plugin.finder.live.view.FinderLiveTextIndicator;
import com.tencent.mm.plugin.finder.live.view.adapter.j;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.live.widget.t;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0006\u0010&\u001a\u00020!J\u0018\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0017H\u0016J\u0006\u0010+\u001a\u00020!J\b\u0010,\u001a\u00020)H\u0016J\b\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020!H\u0002J\b\u0010/\u001a\u00020!H\u0002J\u0006\u00100\u001a\u00020!R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0011*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u0011*\u0004\u0018\u00010\u001b0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n \u0011*\u0004\u0018\u00010\u001f0\u001fX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyPageAdapter;", "applyPageList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "Lkotlin/collections/ArrayList;", "blankArea", "Landroid/view/View;", "kotlin.jvm.PlatformType", "closeGroup", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "contentScrollArea", "curPosition", "", "inviteAnchorWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget;", "pageListView", "Landroid/support/v7/widget/RecyclerView;", "pagerSnapHelper", "Landroid/support/v7/widget/PagerSnapHelper;", "tabIndicator", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveTextIndicator;", "applyState", "", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "hideApplyLinkList", "keyboardChange", "show", "", "height", "notifyDataUpdate", "onBackPress", "setupApplyPages", "showApplyLinkList", "smartScroll", "tryUpdateLinkList", "plugin-finder_release"})
public final class o extends d {
    int FDK;
    private final String TAG = "Finder.FinderLiveAnchorLinkListPlugin";
    final RecyclerView ULk;
    public final FinderLiveTextIndicator ULl;
    private final View ULm;
    public final t ULn;
    public final j ULo;
    private final ArrayList<FinderLiveApplyLinkView> ULp;
    private final ak ULq;
    final com.tencent.mm.live.c.b hOp;
    private final View hRx;
    public final LiveBottomSheetPanel hRy;
    private final View umX;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "position", "", "child", "Landroid/view/View;", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$2$1"})
    static final class b extends q implements m<Integer, View, x> {
        final /* synthetic */ o ung;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(o oVar) {
            super(2);
            this.ung = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, View view) {
            AppMethodBeat.i(260550);
            int intValue = num.intValue();
            p.h(view, "child");
            this.ung.FDK = intValue;
            x xVar = x.SXb;
            AppMethodBeat.o(260550);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(final ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246477);
        this.hOp = bVar;
        this.ULk = (RecyclerView) viewGroup.findViewById(R.id.jwk);
        this.ULl = (FinderLiveTextIndicator) viewGroup.findViewById(R.id.cnk);
        this.hRy = (LiveBottomSheetPanel) viewGroup.findViewById(R.id.cn9);
        this.hRx = viewGroup.findViewById(R.id.cn6);
        this.umX = viewGroup.findViewById(R.id.cn8);
        this.ULm = viewGroup.findViewById(R.id.jwg);
        View findViewById = viewGroup.findViewById(R.id.jxj);
        p.g(findViewById, "root.findViewById<Linear…vite_anchor_link_ui_root)");
        this.ULn = new t((ViewGroup) findViewById, this.hOp, this);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        this.ULo = new j(com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant());
        this.ULp = new ArrayList<>();
        this.ULq = new ak();
        RecyclerView recyclerView = this.ULk;
        p.g(recyclerView, "pageListView");
        recyclerView.getLayoutParams().height = (((au.az(viewGroup.getContext()).y * 2) / 3) - at.fromDPToPix(viewGroup.getContext(), 68)) - au.aD(viewGroup.getContext());
        LiveBottomSheetPanel liveBottomSheetPanel = this.hRy;
        p.g(liveBottomSheetPanel, "contentGroup");
        liveBottomSheetPanel.setTranslationY((float) au.az(viewGroup.getContext()).y);
        if (!isLandscape()) {
            RecyclerView recyclerView2 = this.ULk;
            p.g(recyclerView2, "pageListView");
            ViewGroup.LayoutParams layoutParams = recyclerView2.getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(246477);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += au.aD(viewGroup.getContext());
        }
        this.hRy.setOnVisibilityListener(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.o.AnonymousClass1 */
            final /* synthetic */ o ung;

            {
                this.ung = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(246459);
                if (!bool.booleanValue()) {
                    b.C0376b.a(this.ung.hOp, b.c.hNN);
                    Iterator<T> it = this.ung.ULo.jmY.iterator();
                    while (it.hasNext()) {
                        it.next().hTH();
                    }
                    this.ung.ULn.hTI();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(246459);
                return xVar;
            }
        });
        Context context = this.hwr.getContext();
        p.g(context, "root.context");
        FinderLiveApplyLinkVisitorView finderLiveApplyLinkVisitorView = new FinderLiveApplyLinkVisitorView(context);
        finderLiveApplyLinkVisitorView.setOnVisitorApplyListListener(new c(this));
        this.ULp.add(finderLiveApplyLinkVisitorView);
        Context context2 = this.hwr.getContext();
        p.g(context2, "root.context");
        FinderLiveApplyLinkAnchorView finderLiveApplyLinkAnchorView = new FinderLiveApplyLinkAnchorView(context2);
        finderLiveApplyLinkAnchorView.setOnAnchorApplyListListener(new d(this));
        this.ULp.add(finderLiveApplyLinkAnchorView);
        j jVar = this.ULo;
        ArrayList<FinderLiveApplyLinkView> arrayList = this.ULp;
        p.h(arrayList, "data");
        jVar.jmY.clear();
        jVar.jmY.addAll(arrayList);
        Context context3 = viewGroup.getContext();
        p.g(context3, "root.context");
        FinderLiveLayoutManager finderLiveLayoutManager = new FinderLiveLayoutManager(context3, 0);
        finderLiveLayoutManager.uyJ = new b(this);
        RecyclerView recyclerView3 = this.ULk;
        p.g(recyclerView3, "pageListView");
        recyclerView3.setLayoutManager(finderLiveLayoutManager);
        this.ULk.a(new RecyclerView.l(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.o.AnonymousClass3 */
            final /* synthetic */ o ung;

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
            /* renamed from: com.tencent.mm.plugin.finder.live.plugin.o$3$a */
            static final class a extends q implements kotlin.g.a.b<e, Boolean> {
                public static final a ULr = new a();

                static {
                    AppMethodBeat.i(260552);
                    AppMethodBeat.o(260552);
                }

                a() {
                    super(1);
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ Boolean invoke(e eVar) {
                    boolean z;
                    AppMethodBeat.i(260551);
                    if (!eVar.UPN) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(260551);
                    return valueOf;
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
            /* renamed from: com.tencent.mm.plugin.finder.live.plugin.o$3$b */
            static final class b extends q implements kotlin.g.a.b<e, Boolean> {
                public static final b ULs = new b();

                static {
                    AppMethodBeat.i(260554);
                    AppMethodBeat.o(260554);
                }

                b() {
                    super(1);
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ Boolean invoke(e eVar) {
                    AppMethodBeat.i(260553);
                    Boolean valueOf = Boolean.valueOf(eVar.UPN);
                    AppMethodBeat.o(260553);
                    return valueOf;
                }
            }

            {
                this.ung = r1;
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                boolean z;
                boolean z2 = true;
                AppMethodBeat.i(260555);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                p.h(recyclerView, "recyclerView");
                if (i2 == 0) {
                    switch (this.ung.FDK) {
                        case 0:
                            List<e> list = this.ung.getLiveData().UPY;
                            p.g(list, "liveData.newLinkMicUserList");
                            kotlin.a.j.c((List) list, (kotlin.g.a.b) a.ULr);
                            FinderLiveTextIndicator finderLiveTextIndicator = this.ung.ULl;
                            if (this.ung.getLiveData().hTU() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            finderLiveTextIndicator.Fy(z);
                            k kVar = k.vkd;
                            k.a(s.x.ENTER_VISITOR_LINKMIC_TAB, "", -1, -1);
                            break;
                        case 1:
                            List<e> list2 = this.ung.getLiveData().UPY;
                            p.g(list2, "liveData.newLinkMicUserList");
                            kotlin.a.j.c((List) list2, (kotlin.g.a.b) b.ULs);
                            FinderLiveTextIndicator finderLiveTextIndicator2 = this.ung.ULl;
                            if (this.ung.getLiveData().hTV() <= 0) {
                                z2 = false;
                            }
                            finderLiveTextIndicator2.Fz(z2);
                            k kVar2 = k.vkd;
                            k.a(s.x.ENTER_ANCHOR_LINKMIC_TAB, "", -1, -1);
                            break;
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(260555);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                int measuredWidth;
                int measuredWidth2;
                AppMethodBeat.i(260556);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                p.h(recyclerView, "recyclerView");
                FinderLiveTextIndicator finderLiveTextIndicator = this.ung.ULl;
                int i4 = au.az(viewGroup.getContext()).x;
                float abs = (((float) Math.abs(i2)) / ((float) i4)) * 0.3f;
                if (i2 > 0) {
                    finderLiveTextIndicator.uyN.setAlpha(kotlin.k.j.aI(finderLiveTextIndicator.uyN.getAlpha() - abs, 0.5f));
                    finderLiveTextIndicator.uyP.setAlpha(kotlin.k.j.aJ(abs + finderLiveTextIndicator.uyP.getAlpha(), 0.8f));
                } else {
                    finderLiveTextIndicator.uyN.setAlpha(kotlin.k.j.aJ(finderLiveTextIndicator.uyN.getAlpha() + abs, 0.8f));
                    finderLiveTextIndicator.uyP.setAlpha(kotlin.k.j.aI(finderLiveTextIndicator.uyP.getAlpha() - abs, 0.5f));
                }
                ViewGroup.LayoutParams layoutParams = finderLiveTextIndicator.uyS.getLayoutParams();
                if (layoutParams == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(260556);
                    throw tVar;
                }
                int marginStart = ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart() + finderLiveTextIndicator.uyN.getMeasuredWidth() + finderLiveTextIndicator.uyO.getMeasuredWidth();
                float abs2 = (((float) Math.abs(i2)) / ((float) i4)) * ((float) marginStart);
                if (i2 > 0) {
                    finderLiveTextIndicator.KtF.setTranslationX(kotlin.k.j.aJ(abs2 + finderLiveTextIndicator.KtF.getTranslationX(), (float) marginStart));
                } else {
                    finderLiveTextIndicator.KtF.setTranslationX(kotlin.k.j.aI(finderLiveTextIndicator.KtF.getTranslationX() - abs2, 0.0f));
                }
                int abs3 = Math.abs(finderLiveTextIndicator.uyN.getMeasuredWidth() - finderLiveTextIndicator.uyP.getMeasuredWidth());
                if (abs3 == 0) {
                    finderLiveTextIndicator.KtF.getLayoutParams().width = finderLiveTextIndicator.uyN.getMeasuredWidth();
                } else {
                    if (finderLiveTextIndicator.uyN.getMeasuredWidth() > finderLiveTextIndicator.uyP.getMeasuredWidth()) {
                        measuredWidth = finderLiveTextIndicator.uyN.getMeasuredWidth();
                        measuredWidth2 = finderLiveTextIndicator.uyP.getMeasuredWidth();
                    } else {
                        measuredWidth = finderLiveTextIndicator.uyP.getMeasuredWidth();
                        measuredWidth2 = finderLiveTextIndicator.uyN.getMeasuredWidth();
                    }
                    float abs4 = (((float) Math.abs(i2)) / ((float) i4)) * ((float) abs3);
                    if (finderLiveTextIndicator.uyN.getMeasuredWidth() > finderLiveTextIndicator.uyP.getMeasuredWidth()) {
                        if (i2 <= 0) {
                            finderLiveTextIndicator.KtF.getLayoutParams().width = kotlin.k.j.na(((int) abs4) + finderLiveTextIndicator.KtF.getLayoutParams().width, measuredWidth);
                        }
                    } else if (i2 > 0) {
                        finderLiveTextIndicator.KtF.getLayoutParams().width = kotlin.k.j.na(((int) abs4) + finderLiveTextIndicator.KtF.getLayoutParams().width, measuredWidth);
                    }
                    finderLiveTextIndicator.KtF.getLayoutParams().width = kotlin.k.j.mZ(finderLiveTextIndicator.KtF.getLayoutParams().width - ((int) abs4), measuredWidth2);
                }
                finderLiveTextIndicator.KtF.requestLayout();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(260556);
            }
        });
        RecyclerView recyclerView4 = this.ULk;
        p.g(recyclerView4, "pageListView");
        recyclerView4.setAdapter(this.ULo);
        this.ULq.f(this.ULk);
        this.hRx.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.o.AnonymousClass4 */
            final /* synthetic */ o ung;

            {
                this.ung = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246462);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.ung.ULn.isVisible()) {
                    this.ung.ULn.hUk();
                } else {
                    this.ung.hRy.hide();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246462);
            }
        });
        this.umX.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.o.AnonymousClass5 */
            final /* synthetic */ o ung;

            {
                this.ung = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246463);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.ung.hRy.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246463);
            }
        });
        this.ULl.setOnTabSelectedListener(new kotlin.g.a.b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.o.AnonymousClass6 */
            final /* synthetic */ o ung;

            {
                this.ung = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(260557);
                int intValue = num.intValue();
                RecyclerView recyclerView = this.ung.ULk;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(intValue, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$6", "invoke", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$6", "invoke", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
                x xVar = x.SXb;
                AppMethodBeat.o(260557);
                return xVar;
            }
        });
        AppMethodBeat.o(246477);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$setupApplyPages$1$1", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$IOnVisitorApplyListListener;", "onAcceptItemClick", "", "linkUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "onHungupItemClick", "plugin-finder_release"})
    public static final class c implements FinderLiveApplyLinkVisitorView.b {
        final /* synthetic */ o ung;

        c(o oVar) {
            this.ung = oVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView.b
        public final void a(e eVar) {
            AppMethodBeat.i(260558);
            p.h(eVar, "linkUser");
            Bundle bundle = new Bundle();
            bundle.putString("PARAM_FINDER_LIVE_MIC_ID", eVar.sessionId);
            this.ung.hOp.statusChange(b.c.hNO, bundle);
            AppMethodBeat.o(260558);
        }

        @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView.b
        public final void b(e eVar) {
            AppMethodBeat.i(260559);
            p.h(eVar, "linkUser");
            Bundle bundle = new Bundle();
            bundle.putString("PARAM_FINDER_LIVE_MIC_ID", eVar.sessionId);
            this.ung.hOp.statusChange(b.c.hNP, bundle);
            AppMethodBeat.o(260559);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin$setupApplyPages$2$1", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkAnchorView$IOnAnchorApplyListListener;", "onAcceptItemClick", "", "linkUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "onInviteAnchorClick", "plugin-finder_release"})
    public static final class d implements FinderLiveApplyLinkAnchorView.b {
        final /* synthetic */ o ung;

        d(o oVar) {
            this.ung = oVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkAnchorView.b
        public final void a(e eVar) {
            AppMethodBeat.i(260560);
            p.h(eVar, "linkUser");
            List<e> list = this.ung.getLiveData().UPZ;
            p.g(list, "liveData.audienceLinkMicUserList");
            if (!list.isEmpty()) {
                Context context = this.ung.hwr.getContext();
                Context context2 = this.ung.hwr.getContext();
                p.g(context2, "root.context");
                u.makeText(context, context2.getResources().getString(R.string.ja1), 0).show();
                AppMethodBeat.o(260560);
            } else if (Util.isEqual(this.ung.getLiveData().uEB, eVar.username)) {
                b.C0376b.a(this.ung.hOp, b.c.hNP);
                AppMethodBeat.o(260560);
            } else {
                this.ung.hRy.hide();
                this.ung.getLiveData().uEB = eVar;
                b.C0376b.a(this.ung.hOp, b.c.vSe);
                AppMethodBeat.o(260560);
            }
        }

        @Override // com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkAnchorView.b
        public final void hTu() {
            AppMethodBeat.i(260561);
            t tVar = this.ung.ULn;
            ArrayList<avn> arrayList = tVar.URa;
            if (arrayList == null || arrayList.isEmpty()) {
                tVar.hUj();
            } else {
                tVar.hTI();
            }
            tVar.hwr.setVisibility(0);
            tVar.hwr.animate().translationX(0.0f).setListener(null).start();
            k kVar = k.vkd;
            k.a(s.x.ENTER_INVITE_ANCHOR_LINKMIC_TAB, "", -1, -1);
            AppMethodBeat.o(260561);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ o ung;

        a(o oVar) {
            this.ung = oVar;
        }

        public final void run() {
            ArrayList arrayList;
            ArrayList arrayList2;
            AppMethodBeat.i(246470);
            this.ung.hRy.show();
            o oVar = this.ung;
            List<e> list = oVar.getLiveData().UPX;
            p.g(list, "liveData.linkMicUserList");
            List<e> list2 = list;
            synchronized (list2) {
                try {
                    ArrayList arrayList3 = new ArrayList();
                    for (T t : list2) {
                        if (!t.UPN) {
                            arrayList3.add(t);
                        }
                    }
                    arrayList = arrayList3;
                } finally {
                    AppMethodBeat.o(246470);
                }
            }
            List<e> list3 = oVar.getLiveData().UPX;
            p.g(list3, "liveData.linkMicUserList");
            List<e> list4 = list3;
            synchronized (list4) {
                try {
                    ArrayList arrayList4 = new ArrayList();
                    for (T t2 : list4) {
                        if (t2.UPN) {
                            arrayList4.add(t2);
                        }
                    }
                    arrayList2 = arrayList4;
                } finally {
                    AppMethodBeat.o(246470);
                }
            }
            if (oVar.getLiveData().hTV() > 0) {
                RecyclerView recyclerView = oVar.ULk;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin", "smartScroll", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin", "smartScroll", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                AppMethodBeat.o(246470);
            } else if (oVar.getLiveData().hTU() > 0) {
                RecyclerView recyclerView2 = oVar.ULk;
                com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, a3.axQ(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin", "smartScroll", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView2.smoothScrollToPosition(((Integer) a3.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin", "smartScroll", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                AppMethodBeat.o(246470);
            } else {
                if (arrayList.isEmpty()) {
                    if (!(arrayList2.isEmpty())) {
                        RecyclerView recyclerView3 = oVar.ULk;
                        com.tencent.mm.hellhoundlib.b.a a4 = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView3, a4.axQ(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin", "smartScroll", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                        recyclerView3.smoothScrollToPosition(((Integer) a4.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView3, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin", "smartScroll", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                        AppMethodBeat.o(246470);
                        return;
                    }
                }
                if (!(arrayList.isEmpty())) {
                    if (arrayList2.isEmpty()) {
                        RecyclerView recyclerView4 = oVar.ULk;
                        com.tencent.mm.hellhoundlib.b.a a5 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView4, a5.axQ(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin", "smartScroll", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                        recyclerView4.smoothScrollToPosition(((Integer) a5.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView4, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin", "smartScroll", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                        AppMethodBeat.o(246470);
                        return;
                    }
                }
                if (arrayList.isEmpty()) {
                    if (arrayList2.isEmpty()) {
                        RecyclerView recyclerView5 = oVar.ULk;
                        com.tencent.mm.hellhoundlib.b.a a6 = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView5, a6.axQ(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin", "smartScroll", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                        recyclerView5.smoothScrollToPosition(((Integer) a6.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView5, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin", "smartScroll", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                    }
                }
            }
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void B(int i2, Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(260563);
        if (com.tencent.mm.ac.d.cW(i2, 16384)) {
            rg(0);
            t tVar = this.ULn;
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                finderLiveAssistant.a(new t.d(tVar));
            }
            this.ULo.liveData = getLiveData();
            this.ULo.notifyDataSetChanged();
            this.ULl.Fy(getLiveData().hTU() > 0);
            FinderLiveTextIndicator finderLiveTextIndicator = this.ULl;
            if (getLiveData().hTV() <= 0) {
                z = false;
            }
            finderLiveTextIndicator.Fz(z);
            this.hRy.post(new a(this));
            Log.i(this.TAG, "showApplyLinkList :" + getLiveData().UPX.size());
            AppMethodBeat.o(260563);
            return;
        }
        rg(8);
        AppMethodBeat.o(260563);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(246476);
        if (this.ULn.isVisible()) {
            this.ULn.hUk();
            AppMethodBeat.o(246476);
            return true;
        } else if (this.hwr.getVisibility() == 0) {
            this.hRy.hide();
            AppMethodBeat.o(246476);
            return true;
        } else {
            boolean onBackPress = super.onBackPress();
            AppMethodBeat.o(246476);
            return onBackPress;
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void keyboardChange(boolean z, int i2) {
        AppMethodBeat.i(260564);
        Iterator<T> it = this.ULo.jmY.iterator();
        while (it.hasNext()) {
            it.next().aj(z, i2);
        }
        t tVar = this.ULn;
        Log.i(t.TAG, "keyboardChange show:" + z + " height:" + i2);
        if (z) {
            tVar.hUj();
            tVar.hwr.post(new t.c(tVar));
        }
        AppMethodBeat.o(260564);
    }

    public final void aQG() {
        FinderLiveApplyLinkView finderLiveApplyLinkView;
        AppMethodBeat.i(260562);
        if (this.hwr.getVisibility() != 0 || (finderLiveApplyLinkView = (FinderLiveApplyLinkView) kotlin.a.j.kt(this.ULp)) == null) {
            AppMethodBeat.o(260562);
            return;
        }
        finderLiveApplyLinkView.cCu();
        AppMethodBeat.o(260562);
    }
}
