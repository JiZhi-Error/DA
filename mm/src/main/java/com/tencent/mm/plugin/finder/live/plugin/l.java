package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u001a\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isSecondDaryDevice", "", "()Z", "setSecondDaryDevice", "(Z)V", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "canClearScreen", "notifyCloseLive", "", "resume", "showQuitBottomSheet", "showSecondConfirmBottomSheet", "showSecondaryBottomSheet", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class l extends d {
    com.tencent.mm.ui.widget.a.e hOv;
    private int hOw;
    private final o.g hOx = new a(this);
    final com.tencent.mm.live.c.b hOy;
    private final View hRd;
    public boolean umP;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(246450);
        this.hOy = bVar;
        this.hRd = viewGroup.findViewById(R.id.end);
        this.hOw = au.aD(viewGroup.getContext());
        this.hRd.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.l.AnonymousClass1 */
            final /* synthetic */ l umQ;

            {
                this.umQ = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246441);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.umQ.hOy, b.c.hLC);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246441);
            }
        });
        if (isLandscape() && viewGroup.getLayoutParams() != null && (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            switch (getCurrentOrientation()) {
                case 1:
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(au.aD(viewGroup.getContext()));
                        break;
                    } else {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(246450);
                        throw tVar;
                    }
                case 3:
                    ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                    if (layoutParams2 != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginEnd(at.fromDPToPix(viewGroup.getContext(), 16));
                        break;
                    } else {
                        t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(246450);
                        throw tVar2;
                    }
            }
        }
        m mVar = m.vVH;
        m.a((d) this, false);
        m mVar2 = m.vVH;
        m.a(this);
        AppMethodBeat.o(246450);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class a implements o.g {
        final /* synthetic */ l umQ;

        a(l lVar) {
            this.umQ = lVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(246443);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            o.g gVar = o.g.hHa;
            if (itemId != o.g.aFE()) {
                o.g gVar2 = o.g.hHa;
                if (itemId == o.g.aFG()) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL", true);
                    bundle.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_IF_CLOSE_LIVE", false);
                    this.umQ.hOy.statusChange(b.c.hLV, bundle);
                }
                AppMethodBeat.o(246443);
            } else if (this.umQ.umP) {
                l lVar = this.umQ;
                com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(lVar.hwr.getContext(), 1, true);
                eVar.hbr();
                eVar.setTitleView(aa.jQ(lVar.hwr.getContext()).inflate(R.layout.af_, (ViewGroup) null));
                eVar.a(new d(lVar));
                eVar.a(new e(lVar));
                eVar.dGm();
                AppMethodBeat.o(246443);
            } else {
                l.a(this.umQ);
                AppMethodBeat.o(246443);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class d implements o.f {
        final /* synthetic */ l umQ;

        d(l lVar) {
            this.umQ = lVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(246445);
            p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                o.g gVar = o.g.hHa;
                int aFE = o.g.aFE();
                Context context = this.umQ.hwr.getContext();
                p.g(context, "root.context");
                int color = context.getResources().getColor(R.color.Red);
                Context context2 = this.umQ.hwr.getContext();
                p.g(context2, "root.context");
                mVar.a(aFE, color, context2.getResources().getString(R.string.ehb));
            }
            AppMethodBeat.o(246445);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class e implements o.g {
        final /* synthetic */ l umQ;

        e(l lVar) {
            this.umQ = lVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(246446);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            o.g gVar = o.g.hHa;
            if (itemId == o.g.aFE()) {
                l.a(this.umQ);
            }
            AppMethodBeat.o(246446);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class b implements o.f {
        final /* synthetic */ ArrayList hOB;
        final /* synthetic */ ArrayList hOC;
        final /* synthetic */ l umQ;

        b(l lVar, ArrayList arrayList, ArrayList arrayList2) {
            this.umQ = lVar;
            this.hOB = arrayList;
            this.hOC = arrayList2;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(246444);
            com.tencent.mm.ui.widget.a.e eVar = this.umQ.hOv;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            int size = this.hOB.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = this.hOC.get(i2);
                p.g(obj, "ids[i]");
                int intValue = ((Number) obj).intValue();
                Context context = this.umQ.hwr.getContext();
                p.g(context, "root.context");
                mVar.a(intValue, context.getResources().getColor(R.color.xq), (CharSequence) this.hOB.get(i2));
            }
            AppMethodBeat.o(246444);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class c implements e.b {
        final /* synthetic */ l umQ;

        c(l lVar) {
            this.umQ = lVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            this.umQ.hOv = null;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class f implements o.f {
        final /* synthetic */ ArrayList hOB;
        final /* synthetic */ ArrayList hOC;
        final /* synthetic */ l umQ;

        f(l lVar, ArrayList arrayList, ArrayList arrayList2) {
            this.umQ = lVar;
            this.hOB = arrayList;
            this.hOC = arrayList2;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(246447);
            com.tencent.mm.ui.widget.a.e eVar = this.umQ.hOv;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            int size = this.hOB.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = this.hOC.get(i2);
                p.g(obj, "ids[i]");
                mVar.d(((Number) obj).intValue(), (CharSequence) this.hOB.get(i2));
            }
            AppMethodBeat.o(246447);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class g implements e.b {
        final /* synthetic */ l umQ;

        g(l lVar) {
            this.umQ = lVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            this.umQ.hOv = null;
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(246448);
        super.resume();
        int aD = au.aD(this.hwr.getContext());
        if (aD == 0) {
            aD = at.fromDPToPix(this.hwr.getContext(), 16);
        }
        this.hOw = aD;
        AppMethodBeat.o(246448);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(246449);
        p.h(cVar, "status");
        switch (m.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (this.umP) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Context context = this.hwr.getContext();
                    p.g(context, "root.context");
                    arrayList.add(context.getResources().getString(R.string.cyr));
                    o.g gVar = o.g.hHa;
                    arrayList2.add(Integer.valueOf(o.g.aFG()));
                    if (this.hOv == null) {
                        this.hOv = new com.tencent.mm.ui.widget.a.e(this.hwr.getContext(), 1, true);
                        View inflate = View.inflate(this.hwr.getContext(), R.layout.b0l, null);
                        TextView textView = (TextView) inflate.findViewById(R.id.eg6);
                        p.g(textView, "bottomSheetTitleTv");
                        textView.setText(this.hwr.getContext().getString(R.string.cys));
                        textView.setTextSize(1, 12.0f);
                        com.tencent.mm.ui.widget.a.e eVar = this.hOv;
                        if (eVar != null) {
                            eVar.V(inflate, true);
                        }
                        com.tencent.mm.ui.widget.a.e eVar2 = this.hOv;
                        if (eVar2 != null) {
                            eVar2.hbr();
                        }
                        com.tencent.mm.ui.widget.a.e eVar3 = this.hOv;
                        if (eVar3 != null) {
                            eVar3.a(new f(this, arrayList, arrayList2));
                        }
                        com.tencent.mm.ui.widget.a.e eVar4 = this.hOv;
                        if (eVar4 != null) {
                            eVar4.a(this.hOx);
                        }
                        com.tencent.mm.ui.widget.a.e eVar5 = this.hOv;
                        if (eVar5 != null) {
                            eVar5.b(new g(this));
                        }
                    }
                    com.tencent.mm.ui.widget.a.e eVar6 = this.hOv;
                    if (eVar6 != null) {
                        eVar6.dGm();
                        AppMethodBeat.o(246449);
                        return;
                    }
                    AppMethodBeat.o(246449);
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                Context context2 = this.hwr.getContext();
                p.g(context2, "root.context");
                arrayList3.add(context2.getResources().getString(R.string.ehb));
                o.g gVar2 = o.g.hHa;
                arrayList4.add(Integer.valueOf(o.g.aFE()));
                if (this.hOv == null) {
                    this.hOv = new com.tencent.mm.ui.widget.a.e(this.hwr.getContext(), 1, false);
                }
                com.tencent.mm.ui.widget.a.e eVar7 = this.hOv;
                if (eVar7 != null) {
                    eVar7.hbr();
                }
                com.tencent.mm.ui.widget.a.e eVar8 = this.hOv;
                if (eVar8 != null) {
                    eVar8.a(new b(this, arrayList3, arrayList4));
                }
                com.tencent.mm.ui.widget.a.e eVar9 = this.hOv;
                if (eVar9 != null) {
                    eVar9.a(this.hOx);
                }
                com.tencent.mm.ui.widget.a.e eVar10 = this.hOv;
                if (eVar10 != null) {
                    eVar10.b(new c(this));
                }
                com.tencent.mm.ui.widget.a.e eVar11 = this.hOv;
                if (eVar11 != null) {
                    eVar11.dGm();
                    AppMethodBeat.o(246449);
                    return;
                }
                AppMethodBeat.o(246449);
                return;
            case 2:
            case 3:
            case 4:
                rg(8);
                AppMethodBeat.o(246449);
                return;
            case 5:
                rg(0);
                AppMethodBeat.o(246449);
                return;
            case 6:
                m mVar = m.vVH;
                m.a((d) this, false);
                m mVar2 = m.vVH;
                m.a(this);
                break;
        }
        AppMethodBeat.o(246449);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    public static final /* synthetic */ void a(l lVar) {
        AppMethodBeat.i(246451);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL", true);
        bundle.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_IF_CLOSE_LIVE", true);
        lVar.hOy.statusChange(b.c.hLV, bundle);
        AppMethodBeat.o(246451);
    }
}
