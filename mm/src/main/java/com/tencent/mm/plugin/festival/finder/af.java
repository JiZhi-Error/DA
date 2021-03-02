package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.festival.model.ag;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u001a\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveNewVisitorPostPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/festival/model/IForbiddenCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DISABLE_TXT", "", "ENABLE_TXT", "TAG", "autoInputMsg", "postContainer", "Landroid/view/View;", "kotlin.jvm.PlatformType", "postHint", "Landroid/widget/TextView;", "canClearScreen", "", "checkComment", "", "getFlagBit", "", "onForbiddenChange", "isBitFlagSet", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-festival_release"})
public final class af extends p implements ag {
    private final String TAG = "Finder.FestivalFinderLiveNewVisitorPostPlugin";
    final b hOp;
    private final View uto;
    final TextView utp;
    String utq;
    final String utr;
    final String uts;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public af(final ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262451);
        this.hOp = bVar;
        this.uto = viewGroup.findViewById(R.id.cz8);
        this.utp = (TextView) viewGroup.findViewById(R.id.cz6);
        this.utq = "";
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        String string = context.getResources().getString(R.string.crr);
        p.g(string, "MMApplicationContext.get….finder_live_comment_tip)");
        this.utr = string;
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        String string2 = context2.getResources().getString(R.string.d5g);
        p.g(string2, "MMApplicationContext.get…finder_post_disable_hint)");
        this.uts = string2;
        this.uto.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.af.AnonymousClass1 */
            final /* synthetic */ af Uty;

            {
                this.Uty = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(262444);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveNewVisitorPostPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!this.Uty.getLiveData().uDB || !this.Uty.getLiveData().uDC) {
                    Context context = viewGroup.getContext();
                    Context context2 = MMApplicationContext.getContext();
                    p.g(context2, "MMApplicationContext.getContext()");
                    u.makeText(context, context2.getResources().getString(R.string.cyx), 0).show();
                } else {
                    TextView textView = this.Uty.utp;
                    p.g(textView, "postHint");
                    if (p.j(textView.getText(), this.Uty.utr)) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
                        bundle.putString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG", this.Uty.utq);
                        this.Uty.hOp.statusChange(b.c.hMd, bundle);
                    } else {
                        TextView textView2 = this.Uty.utp;
                        p.g(textView2, "postHint");
                        if (p.j(textView2.getText(), this.Uty.uts)) {
                            Context context3 = viewGroup.getContext();
                            Context context4 = MMApplicationContext.getContext();
                            p.g(context4, "MMApplicationContext.getContext()");
                            u.a(context3, context4.getResources().getString(R.string.crg), AnonymousClass1.Utz);
                        }
                    }
                }
                this.Uty.utq = "";
                a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveNewVisitorPostPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(262444);
            }
        });
        viewGroup.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.af.AnonymousClass2 */
            final /* synthetic */ af Uty;

            {
                this.Uty = r1;
            }

            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                AppMethodBeat.i(262445);
                if (!this.Uty.isLandscape()) {
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(262445);
                        throw tVar;
                    }
                    p.g(windowInsets, "insets");
                    int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
                    Context context = viewGroup.getContext();
                    p.g(context, "root.context");
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = systemWindowInsetBottom + context.getResources().getDimensionPixelSize(R.dimen.ce);
                    viewGroup.requestLayout();
                }
                AppMethodBeat.o(262445);
                return windowInsets;
            }
        });
        m mVar = m.vVH;
        m.a((d) this, true);
        AppMethodBeat.o(262451);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    public final void dhK() {
        AppMethodBeat.i(262447);
        if (!getLiveData().uDB || !getLiveData().uDD || !getLiveData().uDC) {
            TextView textView = this.utp;
            p.g(textView, "postHint");
            textView.setText(this.uts);
        } else {
            TextView textView2 = this.utp;
            p.g(textView2, "postHint");
            textView2.setText(this.utr);
        }
        Log.i(this.TAG, "riskControlEnableComment:" + getLiveData().uDB + ",enableLiveRoomComment:" + getLiveData().uDD + ",enableCustomerComment:" + getLiveData().uDC);
        AppMethodBeat.o(262447);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        String str;
        AppMethodBeat.i(262448);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (ag.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                rg(8);
                AppMethodBeat.o(262448);
                return;
            case 3:
                dhK();
                AppMethodBeat.o(262448);
                return;
            case 4:
                m mVar = m.vVH;
                m.a((d) this, true);
                AppMethodBeat.o(262448);
                return;
            case 5:
                if (bundle == null || (str = bundle.getString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG")) == null) {
                    str = "";
                }
                this.utq = str;
                this.uto.performClick();
                break;
        }
        AppMethodBeat.o(262448);
    }

    @Override // com.tencent.mm.plugin.festival.model.ag
    public final void Fe(boolean z) {
        AppMethodBeat.i(262449);
        Log.i(this.TAG, "onForbiddenChange :".concat(String.valueOf(z)));
        if (z) {
            rg(8);
        }
        AppMethodBeat.o(262449);
    }

    @Override // com.tencent.mm.plugin.festival.model.ag
    public final int dCX() {
        return 8;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(262450);
        while (i2 == 0) {
            com.tencent.mm.plugin.festival.model.t tVar = com.tencent.mm.plugin.festival.model.t.UyR;
            if (!com.tencent.mm.plugin.festival.model.t.awC(8)) {
                break;
            }
            i2 = 8;
        }
        super.rg(i2);
        AppMethodBeat.o(262450);
    }
}
