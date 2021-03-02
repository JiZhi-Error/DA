package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBottomTipPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "actionBtn1", "Landroid/widget/Button;", "actionBtn2", "actionGroup", "Landroid/widget/RelativeLayout;", "blankArea", "Landroid/view/View;", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "tipMsg", "Landroid/widget/TextView;", "tipTitle", "hidePanel", "", "onBackPress", "", "showTipPanel", "scene", "", "action1Listener", "Landroid/view/View$OnClickListener;", "action2Listener", "plugin-finder_release"})
public final class aq extends d {
    private final TextView POc;
    private final RelativeLayout ULt;
    private final Button ULu;
    private final Button ULv;
    private final TextView ULw;
    private final b hOp;
    private final View hRx;
    public final LiveBottomSheetPanel hRy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aq(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(260580);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.jwr);
        p.g(findViewById, "root.findViewById(R.id.f…ve_bottom_tip_blank_area)");
        this.hRx = findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.jws);
        p.g(findViewById2, "root.findViewById(R.id.f…_bottom_tip_content_area)");
        this.hRy = (LiveBottomSheetPanel) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.jwo);
        p.g(findViewById3, "root.findViewById(R.id.f…_bottom_tip_action_group)");
        this.ULt = (RelativeLayout) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.jwp);
        p.g(findViewById4, "root.findViewById(R.id.f…ve_bottom_tip_action_one)");
        this.ULu = (Button) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.jwq);
        p.g(findViewById5, "root.findViewById(R.id.f…ve_bottom_tip_action_two)");
        this.ULv = (Button) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.jwu);
        p.g(findViewById6, "root.findViewById(R.id.f…er_live_bottom_tip_title)");
        this.ULw = (TextView) findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.jwt);
        p.g(findViewById7, "root.findViewById(R.id.finder_live_bottom_tip_msg)");
        this.POc = (TextView) findViewById7;
        this.hRy.setTranslationY((float) au.az(viewGroup.getContext()).y);
        ViewGroup.LayoutParams layoutParams = this.ULt.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(260580);
            throw tVar;
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin += au.aD(viewGroup.getContext());
        this.hRy.setOnVisibilityListener(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.aq.AnonymousClass1 */
            final /* synthetic */ aq ULx;

            {
                this.ULx = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(260575);
                if (!bool.booleanValue()) {
                    this.ULx.rg(8);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(260575);
                return xVar;
            }
        });
        this.hRx.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.aq.AnonymousClass2 */
            final /* synthetic */ aq ULx;

            {
                this.ULx = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(260576);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveBottomTipPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.ULx.hRy.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveBottomTipPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(260576);
            }
        });
        AppMethodBeat.o(260580);
    }

    public final void a(int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        AppMethodBeat.i(260578);
        rg(0);
        switch (i2) {
            case 0:
                TextView textView = this.ULw;
                Context context = this.hwr.getContext();
                p.g(context, "root.context");
                textView.setText(context.getResources().getString(R.string.jaf));
                TextView textView2 = this.POc;
                Context context2 = this.hwr.getContext();
                p.g(context2, "root.context");
                textView2.setText(context2.getResources().getString(R.string.jae));
                Button button = this.ULu;
                Context context3 = this.hwr.getContext();
                p.g(context3, "root.context");
                button.setText(context3.getResources().getString(R.string.jah));
                Button button2 = this.ULv;
                Context context4 = this.hwr.getContext();
                p.g(context4, "root.context");
                button2.setText(context4.getResources().getString(R.string.jad));
                Button button3 = this.ULu;
                Context context5 = this.hwr.getContext();
                p.g(context5, "root.context");
                button3.setBackground(context5.getResources().getDrawable(R.drawable.a01));
                Button button4 = this.ULv;
                Context context6 = this.hwr.getContext();
                p.g(context6, "root.context");
                button4.setBackground(context6.getResources().getDrawable(R.drawable.cup));
                break;
            case 1:
                TextView textView3 = this.ULw;
                Context context7 = this.hwr.getContext();
                p.g(context7, "root.context");
                textView3.setText(context7.getResources().getString(R.string.jbq));
                TextView textView4 = this.POc;
                Context context8 = this.hwr.getContext();
                p.g(context8, "root.context");
                textView4.setText(context8.getResources().getString(R.string.jbp));
                Button button5 = this.ULu;
                Context context9 = this.hwr.getContext();
                p.g(context9, "root.context");
                button5.setText(context9.getResources().getString(R.string.jbo));
                Button button6 = this.ULv;
                Context context10 = this.hwr.getContext();
                p.g(context10, "root.context");
                button6.setText(context10.getResources().getString(R.string.jbr));
                Button button7 = this.ULu;
                Context context11 = this.hwr.getContext();
                p.g(context11, "root.context");
                button7.setBackground(context11.getResources().getDrawable(R.drawable.cup));
                Button button8 = this.ULv;
                Context context12 = this.hwr.getContext();
                p.g(context12, "root.context");
                button8.setBackground(context12.getResources().getDrawable(R.drawable.a01));
                break;
            case 2:
                TextView textView5 = this.ULw;
                Context context13 = this.hwr.getContext();
                p.g(context13, "root.context");
                textView5.setText(context13.getResources().getString(R.string.jbn));
                TextView textView6 = this.POc;
                Context context14 = this.hwr.getContext();
                p.g(context14, "root.context");
                textView6.setText(context14.getResources().getString(R.string.jbm));
                Button button9 = this.ULu;
                Context context15 = this.hwr.getContext();
                p.g(context15, "root.context");
                button9.setText(context15.getResources().getString(R.string.jbo));
                Button button10 = this.ULv;
                Context context16 = this.hwr.getContext();
                p.g(context16, "root.context");
                button10.setText(context16.getResources().getString(R.string.jbr));
                Button button11 = this.ULu;
                Context context17 = this.hwr.getContext();
                p.g(context17, "root.context");
                button11.setBackground(context17.getResources().getDrawable(R.drawable.cup));
                Button button12 = this.ULv;
                Context context18 = this.hwr.getContext();
                p.g(context18, "root.context");
                button12.setBackground(context18.getResources().getDrawable(R.drawable.a01));
                break;
        }
        this.ULu.setOnClickListener(onClickListener);
        this.ULv.setOnClickListener(onClickListener2);
        this.hRy.post(new a(this));
        AppMethodBeat.o(260578);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ aq ULx;

        a(aq aqVar) {
            this.ULx = aqVar;
        }

        public final void run() {
            AppMethodBeat.i(260577);
            this.ULx.hRy.show();
            AppMethodBeat.o(260577);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(260579);
        if (this.hwr.getVisibility() == 0) {
            this.hRy.hide();
            AppMethodBeat.o(260579);
            return true;
        }
        AppMethodBeat.o(260579);
        return false;
    }
}
