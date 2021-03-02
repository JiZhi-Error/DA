package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.view.FinderLiveLinkMicStateContainer;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\u0006\u0010\"\u001a\u00020\u001dJ\u0012\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u001dR\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u000e*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u000e*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u000e*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u000e*\u0004\u0018\u00010\u001b0\u001bX\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkMicStatePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "SHEET_ITEM_CLOSE_LINK_APPLY", "", "TAG", "", "hangupBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "linkedGroup", "linkedUserNameTv", "Landroid/widget/TextView;", "rootView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer;", "waitGroup", "waitIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "waitTv", "waveIcon", "Lorg/libpag/PAGView;", "buildCloseDialog", "", "canClearScreen", "", "clickRoot", "fillLinkMicUserInfo", "hideStatePanel", "onClick", "v", "showStatePanel", "updateLinkStateUI", "plugin-finder_release"})
public final class p extends d implements View.OnClickListener {
    private final String TAG = "Finder.FinderLiveLinkMicStatePlugin";
    private final com.tencent.mm.live.c.b hOp;
    private final FinderLiveLinkMicStateContainer unj;
    private final View unk;
    private final TextView unl;
    private final View unm;
    private final PAGView unn;
    private final View uno;
    private final WeImageView unp;
    private final TextView unq;
    private final int uvo;
    private com.tencent.mm.ui.widget.a.e uvt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        kotlin.g.b.p.h(viewGroup, "root");
        kotlin.g.b.p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246486);
        this.hOp = bVar;
        this.unj = (FinderLiveLinkMicStateContainer) viewGroup.findViewById(R.id.ctw);
        this.unk = viewGroup.findViewById(R.id.ctq);
        this.unl = (TextView) viewGroup.findViewById(R.id.ctt);
        this.unm = viewGroup.findViewById(R.id.cts);
        this.unn = (PAGView) viewGroup.findViewById(R.id.ctv);
        this.uno = viewGroup.findViewById(R.id.cu0);
        this.unp = (WeImageView) viewGroup.findViewById(R.id.cto);
        this.unq = (TextView) viewGroup.findViewById(R.id.ctp);
        this.unj.setOnClick(new kotlin.g.a.b<View, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.p.AnonymousClass1 */
            final /* synthetic */ p unr;

            {
                this.unr = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(View view) {
                AppMethodBeat.i(260565);
                kotlin.g.b.p.h(view, LocaleUtil.ITALIAN);
                p.k(this.unr);
                x xVar = x.SXb;
                AppMethodBeat.o(260565);
                return xVar;
            }
        });
        this.unj.diw();
        this.unm.setOnClickListener(this);
        PAGView pAGView = this.unn;
        kotlin.g.b.p.g(pAGView, "waveIcon");
        Context context = viewGroup.getContext();
        kotlin.g.b.p.g(context, "root.context");
        pAGView.setFile(PAGFile.Load(context.getAssets(), "finder_live_shopping_promoting.pag"));
        this.unn.setRepeatCount(-1);
        AppMethodBeat.o(246486);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class d implements o.f {
        final /* synthetic */ p unr;

        d(p pVar) {
            this.unr = pVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(260566);
            com.tencent.mm.ui.widget.a.e eVar = this.unr.uvt;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            int i2 = this.unr.uvo;
            Context context = this.unr.hwr.getContext();
            kotlin.g.b.p.g(context, "root.context");
            int color = context.getResources().getColor(R.color.xq);
            Context context2 = this.unr.hwr.getContext();
            kotlin.g.b.p.g(context2, "root.context");
            mVar.a(i2, color, context2.getResources().getString(R.string.ctt));
            AppMethodBeat.o(260566);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    public static final class e implements o.g {
        final /* synthetic */ p unr;

        e(p pVar) {
            this.unr = pVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(260567);
            kotlin.g.b.p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == this.unr.uvo) {
                com.tencent.mm.ui.widget.a.e eVar = this.unr.uvt;
                if (eVar != null) {
                    eVar.bMo();
                }
                b.C0376b.a(this.unr.hOp, b.c.hNP);
                k kVar = k.vkd;
                k.dpl().vlK = true;
            }
            AppMethodBeat.o(260567);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class f implements e.b {
        final /* synthetic */ p unr;

        f(p pVar) {
            this.unr = pVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(260568);
            this.unr.uvt = null;
            AppMethodBeat.o(260568);
        }
    }

    public final void dgW() {
        AppMethodBeat.i(246483);
        com.tencent.mm.ac.d.h(new b(this));
        AppMethodBeat.o(246483);
    }

    public final void dgX() {
        AppMethodBeat.i(246484);
        com.tencent.mm.ac.d.h(new a(this));
        AppMethodBeat.o(246484);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(246485);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkMicStatePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.cts) {
            b.C0376b.a(this.hOp, b.c.hNP);
            k kVar = k.vkd;
            k.dpl().vlK = true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkMicStatePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246485);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ p unr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(p pVar) {
            super(0);
            this.unr = pVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246481);
            switch (this.unr.getLiveData().uEC) {
                case 1:
                    View view = this.unr.uno;
                    kotlin.g.b.p.g(view, "waitGroup");
                    view.setVisibility(0);
                    View view2 = this.unr.unk;
                    kotlin.g.b.p.g(view2, "linkedGroup");
                    view2.setVisibility(8);
                    WeImageView weImageView = this.unr.unp;
                    WeImageView weImageView2 = this.unr.unp;
                    kotlin.g.b.p.g(weImageView2, "waitIv");
                    Context context = weImageView2.getContext();
                    kotlin.g.b.p.g(context, "waitIv.context");
                    weImageView.setImageDrawable(context.getResources().getDrawable(R.raw.icons_filled_call));
                    break;
                case 2:
                    View view3 = this.unr.uno;
                    kotlin.g.b.p.g(view3, "waitGroup");
                    view3.setVisibility(0);
                    View view4 = this.unr.unk;
                    kotlin.g.b.p.g(view4, "linkedGroup");
                    view4.setVisibility(8);
                    WeImageView weImageView3 = this.unr.unp;
                    WeImageView weImageView4 = this.unr.unp;
                    kotlin.g.b.p.g(weImageView4, "waitIv");
                    Context context2 = weImageView4.getContext();
                    kotlin.g.b.p.g(context2, "waitIv.context");
                    weImageView3.setImageDrawable(context2.getResources().getDrawable(R.raw.icons_filled_video_call));
                    break;
                case 3:
                    View view5 = this.unr.uno;
                    kotlin.g.b.p.g(view5, "waitGroup");
                    view5.setVisibility(8);
                    View view6 = this.unr.unk;
                    kotlin.g.b.p.g(view6, "linkedGroup");
                    view6.setVisibility(0);
                    p.d(this.unr);
                    break;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246481);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ p unr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(p pVar) {
            super(0);
            this.unr = pVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246480);
            this.unr.rg(0);
            com.tencent.mm.ac.d.h(new c(this.unr));
            FinderLiveLinkMicStateContainer.a(this.unr.unj);
            x xVar = x.SXb;
            AppMethodBeat.o(246480);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ p unr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(p pVar) {
            super(0);
            this.unr = pVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246479);
            this.unr.unn.stop();
            this.unr.unj.R(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.p.a.AnonymousClass1 */
                final /* synthetic */ a uns;

                {
                    this.uns = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(246478);
                    this.uns.unr.rg(8);
                    x xVar = x.SXb;
                    AppMethodBeat.o(246478);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(246479);
            return xVar;
        }
    }

    public static final /* synthetic */ void d(p pVar) {
        AppMethodBeat.i(246487);
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = pVar.getLiveData().uEB;
        if (eVar != null) {
            TextView textView = pVar.unl;
            kotlin.g.b.p.g(textView, "linkedUserNameTv");
            com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
            TextView textView2 = pVar.unl;
            kotlin.g.b.p.g(textView2, "linkedUserNameTv");
            y yVar = y.vXH;
            textView.setText(com.tencent.mm.plugin.finder.convert.d.e(textView2, y.hf(eVar.username, eVar.nickname)));
            pVar.unn.play();
            View view = pVar.unm;
            kotlin.g.b.p.g(view, "hangupBtn");
            view.setVisibility(0);
        }
        Log.i(pVar.TAG, "curlinkedUser:".concat(String.valueOf(eVar)));
        AppMethodBeat.o(246487);
    }

    public static final /* synthetic */ void k(p pVar) {
        AppMethodBeat.i(260569);
        if (pVar.getLiveData().djr()) {
            if (pVar.uvt == null) {
                pVar.uvt = new com.tencent.mm.ui.widget.a.e(pVar.hwr.getContext(), 1, true);
                com.tencent.mm.ui.widget.a.e eVar = pVar.uvt;
                if (eVar != null) {
                    eVar.hbs();
                }
            }
            com.tencent.mm.ui.widget.a.e eVar2 = pVar.uvt;
            if (eVar2 != null) {
                eVar2.hbr();
            }
            com.tencent.mm.ui.widget.a.e eVar3 = pVar.uvt;
            if (eVar3 != null) {
                eVar3.Dp(false);
            }
            com.tencent.mm.ui.widget.a.e eVar4 = pVar.uvt;
            if (eVar4 != null) {
                eVar4.a(new d(pVar));
            }
            com.tencent.mm.ui.widget.a.e eVar5 = pVar.uvt;
            if (eVar5 != null) {
                eVar5.a(new e(pVar));
            }
            com.tencent.mm.ui.widget.a.e eVar6 = pVar.uvt;
            if (eVar6 != null) {
                eVar6.b(new f(pVar));
            }
            com.tencent.mm.ui.widget.a.e eVar7 = pVar.uvt;
            if (eVar7 != null) {
                eVar7.dGm();
                AppMethodBeat.o(260569);
                return;
            }
        }
        AppMethodBeat.o(260569);
    }
}
