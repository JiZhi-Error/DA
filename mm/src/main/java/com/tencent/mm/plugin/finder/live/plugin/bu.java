package com.tencent.mm.plugin.finder.live.plugin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorExplainWecoinHotPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blankArea", "Landroid/view/View;", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "okBtn", "Landroid/widget/TextView;", "title", "hideMembersList", "", "onBackPress", "", "showMembersListContent", "plugin-finder_release"})
public final class bu extends d {
    final b hOy;
    private final View hRx;
    public final LiveBottomSheetPanel hRy;
    private final TextView hbb;
    private final TextView uvg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bu(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(247144);
        this.hOy = bVar;
        View findViewById = viewGroup.findViewById(R.id.cle);
        p.g(findViewById, "root.findViewById(R.id.f…_wecoin_hot_content_area)");
        this.hRy = (LiveBottomSheetPanel) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.clc);
        p.g(findViewById2, "root.findViewById(R.id.f…in_wecoin_hot_blank_area)");
        this.hRx = findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.cld);
        p.g(findViewById3, "root.findViewById(R.id.f…r_explain_wecoin_hot_btn)");
        this.uvg = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.clg);
        p.g(findViewById4, "root.findViewById(R.id.f…explain_wecoin_hot_title)");
        this.hbb = (TextView) findViewById4;
        this.hRy.setTranslationY((float) au.az(viewGroup.getContext()).y);
        this.hRy.setOnVisibilityListener(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bu.AnonymousClass1 */
            final /* synthetic */ bu uvh;

            {
                this.uvh = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(247139);
                if (!bool.booleanValue()) {
                    this.uvh.rg(8);
                    b.C0376b.a(this.uvh.hOy, b.c.hNX);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(247139);
                return xVar;
            }
        });
        this.hRx.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bu.AnonymousClass2 */
            final /* synthetic */ bu uvh;

            {
                this.uvh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(247140);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorExplainWecoinHotPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uvh.hRy.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorExplainWecoinHotPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247140);
            }
        });
        this.uvg.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bu.AnonymousClass3 */
            final /* synthetic */ bu uvh;

            {
                this.uvh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(247141);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorExplainWecoinHotPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uvh.hRy.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorExplainWecoinHotPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247141);
            }
        });
        if (!isLandscape()) {
            ViewGroup.LayoutParams layoutParams = this.uvg.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(247144);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += au.aD(viewGroup.getContext());
        }
        ao.a(this.hbb.getPaint(), 0.8f);
        AppMethodBeat.o(247144);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ bu uvh;

        public a(bu buVar) {
            this.uvh = buVar;
        }

        public final void run() {
            AppMethodBeat.i(247142);
            this.uvh.hRy.show();
            AppMethodBeat.o(247142);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(247143);
        if (this.hwr.getVisibility() == 0) {
            this.hRy.hide();
            AppMethodBeat.o(247143);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(247143);
        return onBackPress;
    }
}
