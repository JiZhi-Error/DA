package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.view.FinderLiveLinkMicStateContainer;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\tH\u0002J\u0006\u0010&\u001a\u00020\u001eJ\u0012\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010)\u001a\u00020\u001eJ\u001a\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0006\u0010/\u001a\u00020\u001eR\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u000e*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u000e*\u0004\u0018\u00010\u00160\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u000e*\u0004\u0018\u00010\u00190\u0019X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u000e*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001cX\u0004¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicStatePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "SHEET_ITEM_CLOSE_LINK_APPLY", "", "TAG", "", "hangupBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "linkUserNameTv", "Landroid/widget/TextView;", "linkedGroup", "linkingTip", "rootView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer;", "unlinkedGroup", "unlinkedIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "unlinkedTv", "waveIcon", "Lorg/libpag/PAGView;", "buildCloseDialog", "", "canClearScreen", "", "clickRoot", "drawLinkedState", "drawReadyState", "drawWaitingState", "icon", "hideStatePanel", "onClick", "v", "showStatePanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateByState", "plugin-finder_release"})
public final class bw extends d implements View.OnClickListener {
    private final String TAG = "Finder.FinderLiveVisitorLinkMicStatePlugin";
    private final com.tencent.mm.live.c.b hOp;
    private final FinderLiveLinkMicStateContainer unj;
    private final View unk;
    private final View unm;
    private final PAGView unn;
    private final TextView uuC;
    private final int uvo;
    private final View uvp;
    private final WeImageView uvq;
    private final TextView uvr;
    private final TextView uvs;
    private com.tencent.mm.ui.widget.a.e uvt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bw(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(247172);
        this.hOp = bVar;
        this.unj = (FinderLiveLinkMicStateContainer) viewGroup.findViewById(R.id.ctw);
        this.uvp = viewGroup.findViewById(R.id.ctx);
        this.unk = viewGroup.findViewById(R.id.ctq);
        this.uvq = (WeImageView) viewGroup.findViewById(R.id.cty);
        this.uvr = (TextView) viewGroup.findViewById(R.id.ctz);
        this.uvs = (TextView) viewGroup.findViewById(R.id.ctt);
        this.unm = viewGroup.findViewById(R.id.cts);
        this.unn = (PAGView) viewGroup.findViewById(R.id.ctv);
        this.uuC = (TextView) viewGroup.findViewById(R.id.ctu);
        this.unj.setOnClick(new kotlin.g.a.b<View, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bw.AnonymousClass1 */
            final /* synthetic */ bw uvu;

            {
                this.uvu = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(View view) {
                AppMethodBeat.i(247157);
                p.h(view, LocaleUtil.ITALIAN);
                bw.k(this.uvu);
                x xVar = x.SXb;
                AppMethodBeat.o(247157);
                return xVar;
            }
        });
        this.unj.diw();
        this.unm.setOnClickListener(this);
        PAGView pAGView = this.unn;
        p.g(pAGView, "waveIcon");
        Context context = viewGroup.getContext();
        p.g(context, "root.context");
        pAGView.setFile(PAGFile.Load(context.getAssets(), "finder_live_shopping_promoting.pag"));
        this.unn.setRepeatCount(-1);
        AppMethodBeat.o(247172);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class a implements o.f {
        final /* synthetic */ bw uvu;

        a(bw bwVar) {
            this.uvu = bwVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(247159);
            com.tencent.mm.ui.widget.a.e eVar = this.uvu.uvt;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            int i2 = this.uvu.uvo;
            Context context = this.uvu.hwr.getContext();
            p.g(context, "root.context");
            int color = context.getResources().getColor(R.color.xq);
            Context context2 = this.uvu.hwr.getContext();
            p.g(context2, "root.context");
            mVar.a(i2, color, context2.getResources().getString(R.string.ctt));
            AppMethodBeat.o(247159);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    public static final class b implements o.g {
        final /* synthetic */ bw uvu;

        b(bw bwVar) {
            this.uvu = bwVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(247160);
            p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == this.uvu.uvo) {
                com.tencent.mm.ui.widget.a.e eVar = this.uvu.uvt;
                if (eVar != null) {
                    eVar.bMo();
                }
                this.uvu.dgX();
                com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                com.tencent.mm.plugin.finder.report.live.m.ou(true);
                b.C0376b.a(this.uvu.hOp, b.c.hNP);
            }
            AppMethodBeat.o(247160);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class c implements e.b {
        final /* synthetic */ bw uvu;

        c(bw bwVar) {
            this.uvu = bwVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(247161);
            this.uvu.uvt = null;
            AppMethodBeat.o(247161);
        }
    }

    public final void dhY() {
        AppMethodBeat.i(247167);
        com.tencent.mm.ac.d.h(new f(this));
        AppMethodBeat.o(247167);
    }

    public final void dgW() {
        AppMethodBeat.i(247168);
        com.tencent.mm.ac.d.h(new e(this));
        AppMethodBeat.o(247168);
    }

    public final void dgX() {
        AppMethodBeat.i(247169);
        com.tencent.mm.ac.d.h(new d(this));
        AppMethodBeat.o(247169);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(247170);
        p.h(cVar, "status");
        switch (bx.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (getLiveData().djr() && !getLiveData().diZ()) {
                    dgX();
                    b.C0376b.a(this.hOp, b.c.hNP);
                    break;
                }
        }
        AppMethodBeat.o(247170);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(247171);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicStatePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.cts && getLiveData().djs()) {
            dgX();
            com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
            com.tencent.mm.plugin.finder.report.live.m.ou(true);
            b.C0376b.a(this.hOp, b.c.hNP);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicStatePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247171);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bw uvu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(bw bwVar) {
            super(0);
            this.uvu = bwVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            AppMethodBeat.i(247166);
            switch (this.uvu.getLiveData().uEC) {
                case 0:
                    View view = this.uvu.uvp;
                    p.g(view, "unlinkedGroup");
                    view.setVisibility(0);
                    View view2 = this.uvu.unk;
                    p.g(view2, "linkedGroup");
                    view2.setVisibility(8);
                    bw.g(this.uvu);
                    break;
                case 1:
                case 2:
                    View view3 = this.uvu.uvp;
                    p.g(view3, "unlinkedGroup");
                    view3.setVisibility(0);
                    View view4 = this.uvu.unk;
                    p.g(view4, "linkedGroup");
                    view4.setVisibility(8);
                    if (this.uvu.getLiveData().uEC == 2) {
                        i2 = R.raw.icons_filled_video_call;
                    } else {
                        i2 = R.raw.icons_filled_call;
                    }
                    bw.a(this.uvu, i2);
                    break;
                case 3:
                    View view5 = this.uvu.uvp;
                    p.g(view5, "unlinkedGroup");
                    view5.setVisibility(8);
                    View view6 = this.uvu.unk;
                    p.g(view6, "linkedGroup");
                    view6.setVisibility(0);
                    bw.h(this.uvu);
                    break;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(247166);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bw uvu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(bw bwVar) {
            super(0);
            this.uvu = bwVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247165);
            this.uvu.rg(0);
            this.uvu.dhY();
            this.uvu.unj.Q(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.bw.e.AnonymousClass1 */
                final /* synthetic */ e uvw;

                {
                    this.uvw = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(247164);
                    this.uvw.uvu.dhY();
                    x xVar = x.SXb;
                    AppMethodBeat.o(247164);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(247165);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bw uvu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(bw bwVar) {
            super(0);
            this.uvu = bwVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247163);
            this.uvu.unn.stop();
            this.uvu.unj.R(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.bw.d.AnonymousClass1 */
                final /* synthetic */ d uvv;

                {
                    this.uvv = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(247162);
                    this.uvv.uvu.rg(8);
                    x xVar = x.SXb;
                    AppMethodBeat.o(247162);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(247163);
            return xVar;
        }
    }

    public static final /* synthetic */ void g(bw bwVar) {
        AppMethodBeat.i(247173);
        WeImageView weImageView = bwVar.uvq;
        Context context = bwVar.hwr.getContext();
        p.g(context, "root.context");
        weImageView.setImageDrawable(context.getResources().getDrawable(R.raw.icons_filled_done));
        TextView textView = bwVar.uvr;
        p.g(textView, "unlinkedTv");
        Context context2 = bwVar.hwr.getContext();
        p.g(context2, "root.context");
        textView.setText(context2.getResources().getString(R.string.cuf));
        AppMethodBeat.o(247173);
    }

    public static final /* synthetic */ void a(bw bwVar, int i2) {
        AppMethodBeat.i(247174);
        WeImageView weImageView = bwVar.uvq;
        Context context = bwVar.hwr.getContext();
        p.g(context, "root.context");
        weImageView.setImageDrawable(context.getResources().getDrawable(i2));
        TextView textView = bwVar.uvr;
        p.g(textView, "unlinkedTv");
        Context context2 = bwVar.hwr.getContext();
        p.g(context2, "root.context");
        textView.setText(context2.getResources().getString(R.string.cug));
        AppMethodBeat.o(247174);
    }

    public static final /* synthetic */ void h(bw bwVar) {
        AppMethodBeat.i(247175);
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = bwVar.getLiveData().uEB;
        if (eVar != null) {
            TextView textView = bwVar.uvs;
            p.g(textView, "linkUserNameTv");
            com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
            TextView textView2 = bwVar.uvs;
            p.g(textView2, "linkUserNameTv");
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            textView.setText(com.tencent.mm.plugin.finder.convert.d.e(textView2, com.tencent.mm.plugin.finder.utils.m.hm(eVar.username, eVar.nickname)));
            bwVar.unn.play();
            if (Util.isEqual(bwVar.getLiveData().djq(), eVar.uCo)) {
                TextView textView3 = bwVar.uuC;
                p.g(textView3, "linkingTip");
                textView3.setVisibility(8);
                View view = bwVar.unm;
                p.g(view, "hangupBtn");
                view.setVisibility(0);
            } else {
                TextView textView4 = bwVar.uuC;
                p.g(textView4, "linkingTip");
                textView4.setVisibility(0);
                View view2 = bwVar.unm;
                p.g(view2, "hangupBtn");
                view2.setVisibility(8);
            }
        }
        Log.i(bwVar.TAG, "curlinkedUser:".concat(String.valueOf(eVar)));
        AppMethodBeat.o(247175);
    }

    public static final /* synthetic */ void k(bw bwVar) {
        AppMethodBeat.i(247176);
        if (bwVar.getLiveData().djr()) {
            if (bwVar.uvt == null) {
                bwVar.uvt = new com.tencent.mm.ui.widget.a.e(bwVar.hwr.getContext(), 1, true);
                com.tencent.mm.ui.widget.a.e eVar = bwVar.uvt;
                if (eVar != null) {
                    eVar.hbs();
                }
            }
            com.tencent.mm.ui.widget.a.e eVar2 = bwVar.uvt;
            if (eVar2 != null) {
                eVar2.hbr();
            }
            com.tencent.mm.ui.widget.a.e eVar3 = bwVar.uvt;
            if (eVar3 != null) {
                eVar3.Dp(false);
            }
            com.tencent.mm.ui.widget.a.e eVar4 = bwVar.uvt;
            if (eVar4 != null) {
                eVar4.a(new a(bwVar));
            }
            com.tencent.mm.ui.widget.a.e eVar5 = bwVar.uvt;
            if (eVar5 != null) {
                eVar5.a(new b(bwVar));
            }
            com.tencent.mm.ui.widget.a.e eVar6 = bwVar.uvt;
            if (eVar6 != null) {
                eVar6.b(new c(bwVar));
            }
            com.tencent.mm.ui.widget.a.e eVar7 = bwVar.uvt;
            if (eVar7 != null) {
                eVar7.dGm();
                AppMethodBeat.o(247176);
                return;
            }
        }
        AppMethodBeat.o(247176);
    }
}
