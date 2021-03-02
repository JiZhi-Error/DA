package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010!\u001a\u00020\u001cJ\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u001cJ\u0016\u0010$\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tJ\u0016\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tJ\u0006\u0010)\u001a\u00020\u001cR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R7\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "curIndex", "indicator", "Landroid/view/View;", "longTabWidth", "shortTabWidth", "tab1Group", "tab1RedDot", "tab1Tv", "Landroid/widget/TextView;", "tab2Group", "tab2RedDot", "tab2Tv", "tabOnclickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.b.INDEX, "", "getTabOnclickListener", "()Lkotlin/jvm/functions/Function1;", "setTabOnclickListener", "(Lkotlin/jvm/functions/Function1;)V", "hideRedDotTip", "onDisplay", "onHide", "onScrollStateChanged", "newState", "onScrolling", "dx", "dy", "showRedDotTip", "plugin-finder_release"})
public final class FinderLiveLinkIndicator extends FrameLayout {
    private final View uyM;
    private final TextView uyN;
    private final View uyO;
    private final TextView uyP;
    private final View uyQ;
    private final View uyR;
    private final View uyS;
    private b<? super Integer, x> uyT;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveLinkIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(247473);
        View.inflate(context, R.layout.ae6, this);
        View findViewById = findViewById(R.id.csf);
        p.g(findViewById, "findViewById(R.id.finder_live_link_indicator)");
        this.uyM = findViewById;
        View findViewById2 = findViewById(R.id.cu2);
        p.g(findViewById2, "findViewById(R.id.finder_live_link_tab1_tv)");
        this.uyN = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.cu1);
        p.g(findViewById3, "findViewById(R.id.finder_live_link_tab1_red_dot)");
        this.uyO = findViewById3;
        View findViewById4 = findViewById(R.id.cu4);
        p.g(findViewById4, "findViewById(R.id.finder_live_link_tab2_tv)");
        this.uyP = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.cu3);
        p.g(findViewById5, "findViewById(R.id.finder_live_link_tab2_red_dot)");
        this.uyQ = findViewById5;
        View findViewById6 = findViewById(R.id.csg);
        p.g(findViewById6, "findViewById(R.id.finder…ink_indicator_tab1_group)");
        this.uyR = findViewById6;
        View findViewById7 = findViewById(R.id.csh);
        p.g(findViewById7, "findViewById(R.id.finder…ink_indicator_tab2_group)");
        this.uyS = findViewById7;
        this.uyM.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveLinkIndicator.AnonymousClass1 */
            final /* synthetic */ FinderLiveLinkIndicator uyU;

            {
                this.uyU = r1;
            }

            public final void run() {
                AppMethodBeat.i(247470);
                this.uyU.uyM.getLayoutParams().width = this.uyU.uyN.getMeasuredWidth();
                this.uyU.uyM.requestLayout();
                AppMethodBeat.o(247470);
            }
        });
        this.uyR.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveLinkIndicator.AnonymousClass2 */
            final /* synthetic */ FinderLiveLinkIndicator uyU;

            {
                this.uyU = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(247471);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b<Integer, x> tabOnclickListener = this.uyU.getTabOnclickListener();
                if (tabOnclickListener != null) {
                    tabOnclickListener.invoke(0);
                }
                a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247471);
            }
        });
        this.uyS.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveLinkIndicator.AnonymousClass3 */
            final /* synthetic */ FinderLiveLinkIndicator uyU;

            {
                this.uyU = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(247472);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b<Integer, x> tabOnclickListener = this.uyU.getTabOnclickListener();
                if (tabOnclickListener != null) {
                    tabOnclickListener.invoke(1);
                }
                a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247472);
            }
        });
        AppMethodBeat.o(247473);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, kotlin.x>, kotlin.g.a.b<java.lang.Integer, kotlin.x> */
    public final b<Integer, x> getTabOnclickListener() {
        return this.uyT;
    }

    public final void setTabOnclickListener(b<? super Integer, x> bVar) {
        this.uyT = bVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveLinkIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(247474);
        AppMethodBeat.o(247474);
    }
}
