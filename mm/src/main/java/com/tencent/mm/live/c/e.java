package com.tencent.mm.live.c;

import android.app.Activity;
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
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u001a\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "closeBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "resume", "", "showQuitBottomSheet", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class e extends a {
    private final TextView hOu;
    com.tencent.mm.ui.widget.a.e hOv;
    private int hOw;
    private final o.g hOx;
    final b hOy;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(207899);
        this.hOy = bVar;
        this.hOu = (TextView) viewGroup.findViewById(R.id.ef0);
        this.hOw = au.aD(viewGroup.getContext());
        this.hOx = new a(this, viewGroup);
        this.hOu.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.e.AnonymousClass1 */
            final /* synthetic */ e hOz;

            {
                this.hOz = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207893);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.hOz.hOy, b.c.hLC);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207893);
            }
        });
        if (isLandscape() && viewGroup.getLayoutParams() != null && (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            switch (getCurrentOrientation()) {
                case 1:
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(207899);
                        throw tVar;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(au.aD(viewGroup.getContext()));
                    AppMethodBeat.o(207899);
                    return;
                case 3:
                    ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                    if (layoutParams2 != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginEnd(at.fromDPToPix(viewGroup.getContext(), 16));
                        break;
                    } else {
                        t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(207899);
                        throw tVar2;
                    }
            }
        }
        AppMethodBeat.o(207899);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class a implements o.g {
        final /* synthetic */ ViewGroup hOA;
        final /* synthetic */ e hOz;

        a(e eVar, ViewGroup viewGroup) {
            this.hOz = eVar;
            this.hOA = viewGroup;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(207895);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            o.g gVar = o.g.hHa;
            if (itemId == o.g.aFE()) {
                Context context = this.hOA.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(207895);
                    throw tVar;
                }
                ((Activity) context).getIntent().putExtra("key_is_live_finished", true);
                b.C0376b.a(this.hOz.hOy, b.c.hLV);
                com.tencent.mm.live.d.a.aIb();
            }
            AppMethodBeat.o(207895);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class b implements o.f {
        final /* synthetic */ ArrayList hOB;
        final /* synthetic */ ArrayList hOC;
        final /* synthetic */ e hOz;

        b(e eVar, ArrayList arrayList, ArrayList arrayList2) {
            this.hOz = eVar;
            this.hOB = arrayList;
            this.hOC = arrayList2;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(207896);
            com.tencent.mm.ui.widget.a.e eVar = this.hOz.hOv;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            int size = this.hOB.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = this.hOC.get(i2);
                p.g(obj, "ids[i]");
                int intValue = ((Number) obj).intValue();
                Context context = this.hOz.hwr.getContext();
                p.g(context, "root.context");
                mVar.a(intValue, context.getResources().getColor(R.color.xq), (CharSequence) this.hOB.get(i2));
            }
            AppMethodBeat.o(207896);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class c implements e.b {
        final /* synthetic */ e hOz;

        c(e eVar) {
            this.hOz = eVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            this.hOz.hOv = null;
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(207897);
        super.resume();
        int aD = au.aD(this.hwr.getContext());
        if (aD == 0) {
            aD = at.fromDPToPix(this.hwr.getContext(), 16);
        }
        this.hOw = aD;
        AppMethodBeat.o(207897);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(207898);
        p.h(cVar, "status");
        switch (f.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Context context = this.hwr.getContext();
                p.g(context, "root.context");
                arrayList.add(context.getResources().getString(R.string.ehb));
                o.g gVar = o.g.hHa;
                arrayList2.add(Integer.valueOf(o.g.aFE()));
                if (this.hOv == null) {
                    this.hOv = new com.tencent.mm.ui.widget.a.e(this.hwr.getContext(), 1, false);
                }
                com.tencent.mm.ui.widget.a.e eVar = this.hOv;
                if (eVar != null) {
                    eVar.hbr();
                }
                com.tencent.mm.ui.widget.a.e eVar2 = this.hOv;
                if (eVar2 != null) {
                    eVar2.a(new b(this, arrayList, arrayList2));
                }
                com.tencent.mm.ui.widget.a.e eVar3 = this.hOv;
                if (eVar3 != null) {
                    eVar3.a(this.hOx);
                }
                com.tencent.mm.ui.widget.a.e eVar4 = this.hOv;
                if (eVar4 != null) {
                    eVar4.b(new c(this));
                }
                com.tencent.mm.ui.widget.a.e eVar5 = this.hOv;
                if (eVar5 != null) {
                    eVar5.dGm();
                    AppMethodBeat.o(207898);
                    return;
                }
                AppMethodBeat.o(207898);
                return;
            case 2:
            case 3:
            case 4:
                rg(8);
                AppMethodBeat.o(207898);
                return;
            case 5:
                rg(0);
                AppMethodBeat.o(207898);
                return;
            case 6:
                if (this.hwr.getLayoutParams() != null && (this.hwr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    switch (getCurrentOrientation()) {
                        case 1:
                            ViewGroup.LayoutParams layoutParams = this.hwr.getLayoutParams();
                            if (layoutParams != null) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(at.fromDPToPix(this.hwr.getContext(), 16));
                                break;
                            } else {
                                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                AppMethodBeat.o(207898);
                                throw tVar;
                            }
                        case 3:
                            ViewGroup.LayoutParams layoutParams2 = this.hwr.getLayoutParams();
                            if (layoutParams2 == null) {
                                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                AppMethodBeat.o(207898);
                                throw tVar2;
                            }
                            ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginEnd(this.hOw);
                            AppMethodBeat.o(207898);
                            return;
                    }
                }
                break;
        }
        AppMethodBeat.o(207898);
    }
}
