package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001f\u001a\u00020\u0013H\u0014J\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nJ(\u0010'\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J(\u0010(\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\u000e\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R7\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveTextIndicator;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "line", "Landroid/view/View;", "onTabSelectedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.b.INDEX, "", "getOnTabSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnTabSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "tab1Group", "tab1RedDot", "tab1Tv", "Landroid/widget/TextView;", "tab2Group", "tab2RedDot", "tab2Tv", "onAttachedToWindow", "onClick", "v", "onScroll", "dx", "dy", "totalX", "totalY", "runLineAnimation", "runTabColorAnimation", "showTab1RedDot", "show", "", "showTab2RedDot", "Companion", "plugin-finder_release"})
public final class FinderLiveTextIndicator extends RelativeLayout implements View.OnClickListener {
    private static final String TAG = TAG;
    public static final a UNV = new a((byte) 0);
    public final View KtF;
    private b<? super Integer, x> UNU;
    public final TextView uyN;
    public final View uyO;
    public final TextView uyP;
    private final View uyQ;
    private final View uyR;
    public final View uyS;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveTextIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(260843);
        View.inflate(context, R.layout.cfd, this);
        View findViewById = findViewById(R.id.jyq);
        p.g(findViewById, "findViewById(R.id.finder_live_text_indicator_tab1)");
        this.uyN = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.jyt);
        p.g(findViewById2, "findViewById(R.id.finder_live_text_indicator_tab2)");
        this.uyP = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.jys);
        p.g(findViewById3, "findViewById(R.id.finder…t_indicator_tab1_red_dot)");
        this.uyO = findViewById3;
        View findViewById4 = findViewById(R.id.jyv);
        p.g(findViewById4, "findViewById(R.id.finder…t_indicator_tab2_red_dot)");
        this.uyQ = findViewById4;
        View findViewById5 = findViewById(R.id.jyr);
        p.g(findViewById5, "findViewById(R.id.finder…ext_indicator_tab1_group)");
        this.uyR = findViewById5;
        View findViewById6 = findViewById(R.id.jyu);
        p.g(findViewById6, "findViewById(R.id.finder…ext_indicator_tab2_group)");
        this.uyS = findViewById6;
        View findViewById7 = findViewById(R.id.jyp);
        p.g(findViewById7, "findViewById(R.id.finder_live_text_indicator_line)");
        this.KtF = findViewById7;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a.FinderLiveTextIndicator);
            p.g(obtainStyledAttributes, "context.obtainStyledAttr….FinderLiveTextIndicator)");
            this.uyN.setText(obtainStyledAttributes.getString(0));
            this.uyP.setText(obtainStyledAttributes.getString(1));
            obtainStyledAttributes.recycle();
        }
        this.uyN.setAlpha(0.8f);
        this.uyN.setOnClickListener(this);
        this.uyP.setOnClickListener(this);
        this.KtF.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveTextIndicator.AnonymousClass1 */
            final /* synthetic */ FinderLiveTextIndicator UNW;

            {
                this.UNW = r1;
            }

            public final void run() {
                AppMethodBeat.i(260838);
                Log.i(FinderLiveTextIndicator.TAG, "post tab1Tv.measuredWidth:" + this.UNW.uyN.getMeasuredWidth());
                this.UNW.KtF.getLayoutParams().width = this.UNW.uyN.getMeasuredWidth();
                AppMethodBeat.o(260838);
            }
        });
        AppMethodBeat.o(260843);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveTextIndicator$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260845);
        AppMethodBeat.o(260845);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveTextIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(260844);
        AppMethodBeat.o(260844);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, kotlin.x>, kotlin.g.a.b<java.lang.Integer, kotlin.x> */
    public final kotlin.g.a.b<Integer, x> getOnTabSelectedListener() {
        return this.UNU;
    }

    public final void setOnTabSelectedListener(kotlin.g.a.b<? super Integer, x> bVar) {
        this.UNU = bVar;
    }

    public final void Fy(boolean z) {
        AppMethodBeat.i(260839);
        this.uyO.setVisibility(z ? 0 : 4);
        AppMethodBeat.o(260839);
    }

    public final void Fz(boolean z) {
        AppMethodBeat.i(260840);
        this.uyQ.setVisibility(z ? 0 : 4);
        AppMethodBeat.o(260840);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(260841);
        super.onAttachedToWindow();
        Log.i(TAG, "onAttachedToWindow tab1Tv.measuredWidth:" + this.uyN.getMeasuredWidth());
        AppMethodBeat.o(260841);
    }

    public final void onClick(View view) {
        kotlin.g.a.b<? super Integer, x> bVar;
        AppMethodBeat.i(260842);
        com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
        bVar2.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveTextIndicator", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar2.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.jyq) {
            kotlin.g.a.b<? super Integer, x> bVar3 = this.UNU;
            if (bVar3 != null) {
                bVar3.invoke(0);
            }
        } else if (!(valueOf == null || valueOf.intValue() != R.id.jyt || (bVar = this.UNU) == null)) {
            bVar.invoke(1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveTextIndicator", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(260842);
    }
}
