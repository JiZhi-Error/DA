package com.tencent.mm.plugin.profile.ui.tab.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.tools.o;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010/\u001a\u00020\u0018J\b\u00100\u001a\u00020\u0018H\u0003J\u0006\u00101\u001a\u00020\u0018J\u000e\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\tJ\u0006\u00104\u001a\u00020\u0018J\u0006\u00105\u001a\u00020\u0018J\u0006\u00106\u001a\u00020\u0018J\u0006\u00107\u001a\u00020\u0018J\u0006\u00108\u001a\u00020\u0018J\b\u0010,\u001a\u00020\tH\u0002R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR7\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0018\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u0011\u0010,\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMsgIndicator", "Landroid/view/View;", "mMsgLayout", "Landroid/view/ViewGroup;", "mMsgTextView", "Landroid/widget/TextView;", "mServiceLayout", "mServiceTextView", "mVideoIndicator", "mVideoLayout", "mVideoTextView", "onMsgTabSelected", "Lkotlin/Function0;", "", "getOnMsgTabSelected", "()Lkotlin/jvm/functions/Function0;", "setOnMsgTabSelected", "(Lkotlin/jvm/functions/Function0;)V", "onServiceTabSelected", "getOnServiceTabSelected", "setOnServiceTabSelected", "onTabSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "getOnTabSelected", "()Lkotlin/jvm/functions/Function1;", "setOnTabSelected", "(Lkotlin/jvm/functions/Function1;)V", "onVideoTabSelected", "getOnVideoTabSelected", "setOnVideoTabSelected", "tabCount", "getTabCount", "()I", "hideAllTab", "initView", "selectFirstTab", "selectIndex", FirebaseAnalytics.b.INDEX, "selectMsgTab", "selectVideoTab", "showMsgTab", "showServiceTab", "showVideoTab", "app_release"})
public final class BizProfileTabLayout extends ConstraintLayout {
    private TextView BnQ;
    private TextView BnR;
    private TextView BnS;
    public ViewGroup BnT;
    public ViewGroup BnU;
    public ViewGroup BnV;
    private View BnW;
    private View BnX;
    private kotlin.g.a.a<x> BnY;
    private kotlin.g.a.a<x> BnZ;
    private kotlin.g.a.a<x> Boa;
    private kotlin.g.a.b<? super Integer, x> Bob;

    public static final /* synthetic */ ViewGroup a(BizProfileTabLayout bizProfileTabLayout) {
        AppMethodBeat.i(230890);
        ViewGroup viewGroup = bizProfileTabLayout.BnT;
        if (viewGroup == null) {
            p.btv("mMsgLayout");
        }
        AppMethodBeat.o(230890);
        return viewGroup;
    }

    public final kotlin.g.a.a<x> getOnServiceTabSelected() {
        return this.BnY;
    }

    public final void setOnServiceTabSelected(kotlin.g.a.a<x> aVar) {
        this.BnY = aVar;
    }

    public final kotlin.g.a.a<x> getOnMsgTabSelected() {
        return this.BnZ;
    }

    public final void setOnMsgTabSelected(kotlin.g.a.a<x> aVar) {
        this.BnZ = aVar;
    }

    public final kotlin.g.a.a<x> getOnVideoTabSelected() {
        return this.Boa;
    }

    public final void setOnVideoTabSelected(kotlin.g.a.a<x> aVar) {
        this.Boa = aVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, kotlin.x>, kotlin.g.a.b<java.lang.Integer, kotlin.x> */
    public final kotlin.g.a.b<Integer, x> getOnTabSelected() {
        return this.Bob;
    }

    public final void setOnTabSelected(kotlin.g.a.b<? super Integer, x> bVar) {
        this.Bob = bVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BizProfileTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(230888);
        initView();
        AppMethodBeat.o(230888);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BizProfileTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(230889);
        initView();
        AppMethodBeat.o(230889);
    }

    @SuppressLint({"ResourceType"})
    private final void initView() {
        AppMethodBeat.i(230884);
        aa.jQ(getContext()).inflate(R.layout.x5, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.a65);
        p.g(findViewById, "findViewById(R.id.biz_profile_menu_msg)");
        this.BnQ = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.a6b);
        p.g(findViewById2, "findViewById(R.id.biz_profile_menu_video)");
        this.BnR = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.a68);
        p.g(findViewById3, "findViewById(R.id.biz_profile_menu_service)");
        this.BnS = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.a67);
        p.g(findViewById4, "findViewById(R.id.biz_profile_menu_msg_layout)");
        this.BnT = (ViewGroup) findViewById4;
        View findViewById5 = findViewById(R.id.a6d);
        p.g(findViewById5, "findViewById(R.id.biz_profile_menu_video_layout)");
        this.BnU = (ViewGroup) findViewById5;
        View findViewById6 = findViewById(R.id.a69);
        p.g(findViewById6, "findViewById(R.id.biz_profile_menu_service_layout)");
        this.BnV = (ViewGroup) findViewById6;
        ViewGroup viewGroup = this.BnT;
        if (viewGroup == null) {
            p.btv("mMsgLayout");
        }
        o.hp(viewGroup);
        ViewGroup viewGroup2 = this.BnU;
        if (viewGroup2 == null) {
            p.btv("mVideoLayout");
        }
        o.hp(viewGroup2);
        ViewGroup viewGroup3 = this.BnV;
        if (viewGroup3 == null) {
            p.btv("mServiceLayout");
        }
        o.hp(viewGroup3);
        View findViewById7 = findViewById(R.id.a66);
        p.g(findViewById7, "findViewById(R.id.biz_profile_menu_msg_indicator)");
        this.BnW = findViewById7;
        View findViewById8 = findViewById(R.id.a6c);
        p.g(findViewById8, "findViewById(R.id.biz_pr…ile_menu_video_indicator)");
        this.BnX = findViewById8;
        ViewGroup viewGroup4 = this.BnV;
        if (viewGroup4 == null) {
            p.btv("mServiceLayout");
        }
        viewGroup4.setOnClickListener(new a(this));
        ViewGroup viewGroup5 = this.BnT;
        if (viewGroup5 == null) {
            p.btv("mMsgLayout");
        }
        viewGroup5.setOnClickListener(new b(this));
        ViewGroup viewGroup6 = this.BnU;
        if (viewGroup6 == null) {
            p.btv("mVideoLayout");
        }
        viewGroup6.setOnClickListener(new c(this));
        AppMethodBeat.o(230884);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ BizProfileTabLayout Boc;

        a(BizProfileTabLayout bizProfileTabLayout) {
            this.Boc = bizProfileTabLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230880);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> onServiceTabSelected = this.Boc.getOnServiceTabSelected();
            if (onServiceTabSelected != null) {
                onServiceTabSelected.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230880);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ BizProfileTabLayout Boc;

        b(BizProfileTabLayout bizProfileTabLayout) {
            this.Boc = bizProfileTabLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230881);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> onMsgTabSelected = this.Boc.getOnMsgTabSelected();
            if (onMsgTabSelected != null) {
                onMsgTabSelected.invoke();
            }
            kotlin.g.a.b<Integer, x> onTabSelected = this.Boc.getOnTabSelected();
            if (onTabSelected != null) {
                onTabSelected.invoke(0);
            }
            this.Boc.eFQ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230881);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ BizProfileTabLayout Boc;

        c(BizProfileTabLayout bizProfileTabLayout) {
            this.Boc = bizProfileTabLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230882);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b<Integer, x> onTabSelected = this.Boc.getOnTabSelected();
            if (onTabSelected != null) {
                onTabSelected.invoke(Integer.valueOf(BizProfileTabLayout.a(this.Boc).getVisibility() == 0 ? 1 : 0));
            }
            kotlin.g.a.a<x> onVideoTabSelected = this.Boc.getOnVideoTabSelected();
            if (onVideoTabSelected != null) {
                onVideoTabSelected.invoke();
            }
            this.Boc.eFR();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230882);
        }
    }

    public final void eFP() {
        AppMethodBeat.i(230885);
        ViewGroup viewGroup = this.BnT;
        if (viewGroup == null) {
            p.btv("mMsgLayout");
        }
        viewGroup.setVisibility(8);
        ViewGroup viewGroup2 = this.BnU;
        if (viewGroup2 == null) {
            p.btv("mVideoLayout");
        }
        viewGroup2.setVisibility(8);
        ViewGroup viewGroup3 = this.BnV;
        if (viewGroup3 == null) {
            p.btv("mServiceLayout");
        }
        viewGroup3.setVisibility(8);
        AppMethodBeat.o(230885);
    }

    public final void eFQ() {
        AppMethodBeat.i(230886);
        ViewGroup viewGroup = this.BnT;
        if (viewGroup == null) {
            p.btv("mMsgLayout");
        }
        viewGroup.setVisibility(0);
        View view = this.BnW;
        if (view == null) {
            p.btv("mMsgIndicator");
        }
        view.setVisibility(0);
        View view2 = this.BnX;
        if (view2 == null) {
            p.btv("mVideoIndicator");
        }
        view2.setVisibility(8);
        TextView textView = this.BnQ;
        if (textView == null) {
            p.btv("mMsgTextView");
        }
        Context context = getContext();
        p.g(context, "context");
        textView.setTextColor(context.getResources().getColor(R.color.a2x));
        TextView textView2 = this.BnR;
        if (textView2 == null) {
            p.btv("mVideoTextView");
        }
        Context context2 = getContext();
        p.g(context2, "context");
        textView2.setTextColor(context2.getResources().getColor(R.color.l3));
        AppMethodBeat.o(230886);
    }

    public final void eFR() {
        AppMethodBeat.i(230887);
        ViewGroup viewGroup = this.BnU;
        if (viewGroup == null) {
            p.btv("mVideoLayout");
        }
        viewGroup.setVisibility(0);
        View view = this.BnX;
        if (view == null) {
            p.btv("mVideoIndicator");
        }
        view.setVisibility(0);
        View view2 = this.BnW;
        if (view2 == null) {
            p.btv("mMsgIndicator");
        }
        view2.setVisibility(8);
        TextView textView = this.BnR;
        if (textView == null) {
            p.btv("mVideoTextView");
        }
        Context context = getContext();
        p.g(context, "context");
        textView.setTextColor(context.getResources().getColor(R.color.a2x));
        TextView textView2 = this.BnQ;
        if (textView2 == null) {
            p.btv("mMsgTextView");
        }
        Context context2 = getContext();
        p.g(context2, "context");
        textView2.setTextColor(context2.getResources().getColor(R.color.l3));
        AppMethodBeat.o(230887);
    }

    public final int getTabCount() {
        AppMethodBeat.i(230883);
        int i2 = 0;
        ViewGroup viewGroup = this.BnT;
        if (viewGroup == null) {
            p.btv("mMsgLayout");
        }
        if (viewGroup.getVisibility() == 0) {
            i2 = 1;
        }
        ViewGroup viewGroup2 = this.BnU;
        if (viewGroup2 == null) {
            p.btv("mVideoLayout");
        }
        if (viewGroup2.getVisibility() == 0) {
            i2++;
        }
        ViewGroup viewGroup3 = this.BnV;
        if (viewGroup3 == null) {
            p.btv("mServiceLayout");
        }
        if (viewGroup3.getVisibility() == 0) {
            i2++;
        }
        AppMethodBeat.o(230883);
        return i2;
    }
}
