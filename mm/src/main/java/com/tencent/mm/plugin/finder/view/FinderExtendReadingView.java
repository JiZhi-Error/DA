package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010;\u001a\u00020\u000fJ\u0001\u0010<\u001a\u00020\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f0\u00132K\u0010-\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000f0.J\u0006\u0010=\u001a\u00020\u000fJ\u001e\u0010>\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\tJ\u000e\u0010?\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\fJ+\u0010@\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010AR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R*\u0010\"\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000RU\u0010-\u001aI\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000f\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R(\u00101\u001a\u0004\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u0010 R(\u00104\u001a\u0004\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010 R\u000e\u00107\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R(\u0010/\u001a\u0004\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001e\"\u0004\b9\u0010 R\u000e\u0010:\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "emptyClickListener", "Lkotlin/Function0;", "", "failedLayout", "Landroid/view/View;", "filledClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "isVerifyState", "", "()Z", "setVerifyState", "(Z)V", "value", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "normalLayout", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "getStyle", "()Ljava/lang/Integer;", "setStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "succIocn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "succLayout", "succTv", "Landroid/widget/TextView;", "tipsClickListener", "Lkotlin/Function3;", "title", "tipsLayout", "tipsLink", "getTipsLink", "setTipsLink", "tipsTitle", "getTipsTitle", "setTipsTitle", "tipsTv", "getTitle", "setTitle", "verifyingLayout", "setFailedState", "setListeners", "setOriginState", "setSuccState", "setVerifyingState", "updateVerifiedTips", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "plugin-finder_release"})
public final class FinderExtendReadingView extends LinearLayout {
    private final String TAG = "Finder.FinderExtendReadingView";
    public q<? super String, ? super String, ? super Integer, x> UVt;
    private Integer UVu = 0;
    private final WeImageView UVv;
    private String link;
    private final TextView pJV;
    private String title;
    private final View uNf;
    public kotlin.g.a.a<x> wlL;
    public kotlin.g.a.b<? super String, x> wlM;
    private String wlO;
    private String wlP;
    private final View wlQ;
    private final View wlR;
    private final View wlS;
    private final View wlT;
    private final TextView wlU;
    public boolean wlV;

    public FinderExtendReadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(168331);
        setOrientation(1);
        View inflate = aa.jQ(getContext()).inflate(R.layout.a_l, (ViewGroup) null);
        addView(inflate, new LinearLayout.LayoutParams(-1, -2));
        View findViewById = inflate.findViewById(R.id.c7e);
        p.g(findViewById, "view.findViewById(R.id.e…ding_normal_state_layout)");
        this.wlQ = findViewById;
        View findViewById2 = inflate.findViewById(R.id.c7l);
        p.g(findViewById2, "view.findViewById(R.id.e…g_verifying_state_layout)");
        this.wlR = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.c7c);
        p.g(findViewById3, "view.findViewById(R.id.e…ding_failed_state_layout)");
        this.wlS = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.c7g);
        p.g(findViewById4, "view.findViewById(R.id.e…eading_succ_state_layout)");
        this.wlT = findViewById4;
        View findViewById5 = inflate.findViewById(R.id.c7h);
        p.g(findViewById5, "view.findViewById(R.id.extend_reading_tips_layout)");
        this.uNf = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.c7i);
        p.g(findViewById6, "view.findViewById(R.id.extend_reading_tips_tv)");
        this.pJV = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.c7j);
        p.g(findViewById7, "view.findViewById(R.id.extend_reading_title_tv)");
        this.wlU = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.c7f);
        p.g(findViewById8, "view.findViewById(R.id.extend_reading_succ_icon)");
        this.UVv = (WeImageView) findViewById8;
        dGG();
        AppMethodBeat.o(168331);
    }

    public FinderExtendReadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(168332);
        setOrientation(1);
        View inflate = aa.jQ(getContext()).inflate(R.layout.a_l, (ViewGroup) null);
        addView(inflate, new LinearLayout.LayoutParams(-1, -2));
        View findViewById = inflate.findViewById(R.id.c7e);
        p.g(findViewById, "view.findViewById(R.id.e…ding_normal_state_layout)");
        this.wlQ = findViewById;
        View findViewById2 = inflate.findViewById(R.id.c7l);
        p.g(findViewById2, "view.findViewById(R.id.e…g_verifying_state_layout)");
        this.wlR = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.c7c);
        p.g(findViewById3, "view.findViewById(R.id.e…ding_failed_state_layout)");
        this.wlS = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.c7g);
        p.g(findViewById4, "view.findViewById(R.id.e…eading_succ_state_layout)");
        this.wlT = findViewById4;
        View findViewById5 = inflate.findViewById(R.id.c7h);
        p.g(findViewById5, "view.findViewById(R.id.extend_reading_tips_layout)");
        this.uNf = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.c7i);
        p.g(findViewById6, "view.findViewById(R.id.extend_reading_tips_tv)");
        this.pJV = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.c7j);
        p.g(findViewById7, "view.findViewById(R.id.extend_reading_title_tv)");
        this.wlU = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.c7f);
        p.g(findViewById8, "view.findViewById(R.id.extend_reading_succ_icon)");
        this.UVv = (WeImageView) findViewById8;
        dGG();
        AppMethodBeat.o(168332);
    }

    public final String getTipsLink() {
        return this.wlO;
    }

    public final void setTipsLink(String str) {
        AppMethodBeat.i(168323);
        Log.i(this.TAG, "set tipsLink ".concat(String.valueOf(str)));
        this.wlO = str;
        AppMethodBeat.o(168323);
    }

    public final String getTipsTitle() {
        return this.wlP;
    }

    public final void setTipsTitle(String str) {
        AppMethodBeat.i(168324);
        Log.i(this.TAG, "set tipsTitle ".concat(String.valueOf(str)));
        this.wlP = str;
        AppMethodBeat.o(168324);
    }

    public final String getLink() {
        return this.link;
    }

    public final void setLink(String str) {
        AppMethodBeat.i(168325);
        Log.i(this.TAG, "set link ".concat(String.valueOf(str)));
        this.link = str;
        AppMethodBeat.o(168325);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        AppMethodBeat.i(168326);
        Log.i(this.TAG, "set title ".concat(String.valueOf(str)));
        this.title = str;
        AppMethodBeat.o(168326);
    }

    public final Integer getStyle() {
        return this.UVu;
    }

    public final void setStyle(Integer num) {
        AppMethodBeat.i(261531);
        Log.i(this.TAG, "set style ".concat(String.valueOf(num)));
        this.UVu = num;
        AppMethodBeat.o(261531);
    }

    public final void setVerifyState(boolean z) {
        this.wlV = z;
    }

    public final void dGG() {
        AppMethodBeat.i(168327);
        this.wlV = false;
        this.wlQ.setVisibility(0);
        this.wlR.setVisibility(8);
        this.wlS.setVisibility(8);
        this.wlT.setVisibility(8);
        c(this.wlP, this.wlO, this.UVu);
        this.wlQ.setOnClickListener(new a(this));
        AppMethodBeat.o(168327);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ FinderExtendReadingView wlW;

        a(FinderExtendReadingView finderExtendReadingView) {
            this.wlW = finderExtendReadingView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168319);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setOriginState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a aVar = this.wlW.wlL;
            if (aVar != null) {
                aVar.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setOriginState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168319);
        }
    }

    public final void setVerifyingState(String str) {
        AppMethodBeat.i(168328);
        p.h(str, "link");
        this.wlV = true;
        this.wlQ.setVisibility(8);
        this.wlR.setVisibility(0);
        this.wlS.setVisibility(8);
        this.wlT.setVisibility(8);
        this.uNf.setVisibility(8);
        setLink(str);
        this.wlR.setOnClickListener(new c(this, str));
        AppMethodBeat.o(168328);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ String nNF;
        final /* synthetic */ FinderExtendReadingView wlW;

        c(FinderExtendReadingView finderExtendReadingView, String str) {
            this.wlW = finderExtendReadingView;
            this.nNF = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168321);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setVerifyingState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b bVar2 = this.wlW.wlM;
            if (bVar2 != null) {
                bVar2.invoke(this.nNF);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setVerifyingState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168321);
        }
    }

    public final void ay(String str, String str2, int i2) {
        AppMethodBeat.i(261532);
        p.h(str, "title");
        p.h(str2, "link");
        this.wlV = false;
        this.wlQ.setVisibility(8);
        this.wlR.setVisibility(8);
        this.wlS.setVisibility(8);
        this.wlT.setVisibility(0);
        this.uNf.setVisibility(8);
        setTitle(str);
        setLink(str2);
        setStyle(Integer.valueOf(i2));
        this.wlU.setText(str);
        switch (i2) {
            case 0:
                this.UVv.setImageDrawable(ar.m(getContext(), R.raw.icons_outlined_link, com.tencent.mm.cb.a.n(getContext(), R.color.Orange)));
                break;
            case 1:
                this.UVv.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_red_envelope, com.tencent.mm.cb.a.n(getContext(), R.color.Orange)));
                break;
        }
        this.wlT.setOnClickListener(new b(this, str2));
        AppMethodBeat.o(261532);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ String nNF;
        final /* synthetic */ FinderExtendReadingView wlW;

        b(FinderExtendReadingView finderExtendReadingView, String str) {
            this.wlW = finderExtendReadingView;
            this.nNF = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168320);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setSuccState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b bVar2 = this.wlW.wlM;
            if (bVar2 != null) {
                bVar2.invoke(this.nNF);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setSuccState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168320);
        }
    }

    public final void c(String str, String str2, Integer num) {
        AppMethodBeat.i(261533);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            this.uNf.setVisibility(8);
            AppMethodBeat.o(261533);
            return;
        }
        if (this.wlQ.getVisibility() != 0) {
            this.uNf.setVisibility(8);
        } else {
            this.uNf.setVisibility(0);
        }
        setTipsLink(str2);
        setTipsTitle(str);
        this.pJV.setText(getContext().getString(R.string.cm6, str));
        this.pJV.setOnClickListener(new d(this, str, str2, num));
        AppMethodBeat.o(261533);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ Integer UVw;
        final /* synthetic */ String nNF;
        final /* synthetic */ String tzM;
        final /* synthetic */ FinderExtendReadingView wlW;

        d(FinderExtendReadingView finderExtendReadingView, String str, String str2, Integer num) {
            this.wlW = finderExtendReadingView;
            this.tzM = str;
            this.nNF = str2;
            this.UVw = num;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168322);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$updateVerifiedTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            q qVar = this.wlW.UVt;
            if (qVar != null) {
                String str = this.tzM;
                if (str == null) {
                    p.hyc();
                }
                String str2 = this.nNF;
                if (str2 == null) {
                    p.hyc();
                }
                Integer num = this.UVw;
                if (num == null) {
                    p.hyc();
                }
                qVar.d(str, str2, num);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$updateVerifiedTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168322);
        }
    }
}
