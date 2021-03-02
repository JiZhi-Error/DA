package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.o;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.xweb.z;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/live/ui/dialog/LiveVisitorGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionBtn", "Landroid/widget/Button;", "actionGroup", "Landroid/view/View;", "actionIcon", "Landroid/widget/ImageView;", "actionTv", "Landroid/widget/TextView;", "contentGroup", "isAcceptAgreement", "", "maskView", "onHideListener", "Lkotlin/Function0;", "", "getOnHideListener", "()Lkotlin/jvm/functions/Function0;", "setOnHideListener", "(Lkotlin/jvm/functions/Function0;)V", "onOkListener", "getOnOkListener", "setOnOkListener", "titleIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "setupAction", "setupContentView", "setupMask", "setupTitle", "plugin-logic_release"})
public final class LiveVisitorGuideView extends RelativeLayout {
    private boolean hVA;
    private kotlin.g.a.a<x> hVB;
    private kotlin.g.a.a<x> hVC;
    private final ImageView hVu;
    private final TextView hVv;
    private final Button hVw;
    private final WeImageView hVx;
    private final View hVy;
    private final View hVz;
    private final View maskView;
    private final MMWebView webView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveVisitorGuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(208483);
        View.inflate(context, R.layout.b1w, this);
        MMWebView a2 = MMWebView.a.a(context, this, R.id.enl);
        p.g(a2, "MMWebView.Factory.findVi…ve_visitor_guide_content)");
        this.webView = a2;
        View findViewById = findViewById(R.id.enj);
        p.g(findViewById, "findViewById(R.id.live_visitor_guide_action_icon)");
        this.hVu = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.enk);
        p.g(findViewById2, "findViewById(R.id.live_visitor_guide_action_tv)");
        this.hVv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.eng);
        p.g(findViewById3, "findViewById(R.id.live_visitor_guide_action_btn)");
        this.hVw = (Button) findViewById3;
        View findViewById4 = findViewById(R.id.enp);
        p.g(findViewById4, "findViewById(R.id.live_visitor_guide_title_icon)");
        this.hVx = (WeImageView) findViewById4;
        View findViewById5 = findViewById(R.id.enh);
        p.g(findViewById5, "findViewById(R.id.live_v…_guide_action_desc_group)");
        this.hVy = findViewById5;
        View findViewById6 = findViewById(R.id.enm);
        p.g(findViewById6, "findViewById(R.id.live_v…itor_guide_content_group)");
        this.hVz = findViewById6;
        View findViewById7 = findViewById(R.id.enn);
        p.g(findViewById7, "findViewById(R.id.live_visitor_guide_mask)");
        this.maskView = findViewById7;
        this.hVz.getLayoutParams().height = (au.az(context).y * 3) / 4;
        z settings = this.webView.getSettings();
        p.g(settings, "webView.getSettings()");
        settings.setJavaScriptEnabled(true);
        MMWebView mMWebView = this.webView;
        o.a aVar = o.hGl;
        mMWebView.loadUrl(o.hGj);
        this.hVx.setOnClickListener(new c(this));
        this.hVu.setImageResource(R.drawable.p5);
        this.hVy.setOnClickListener(new a(this));
        this.hVw.setEnabled(false);
        this.hVw.setOnClickListener(new b(this));
        if (ao.isDarkMode()) {
            View view = this.maskView;
            Context context2 = getContext();
            p.g(context2, "context");
            view.setBackground(context2.getResources().getDrawable(R.raw.live_visitor_guide_mask_dark));
            AppMethodBeat.o(208483);
            return;
        }
        View view2 = this.maskView;
        Context context3 = getContext();
        p.g(context3, "context");
        view2.setBackground(context3.getResources().getDrawable(R.raw.live_visitor_guide_mask_normal));
        AppMethodBeat.o(208483);
    }

    public final kotlin.g.a.a<x> getOnHideListener() {
        return this.hVB;
    }

    public final void setOnHideListener(kotlin.g.a.a<x> aVar) {
        this.hVB = aVar;
    }

    public final kotlin.g.a.a<x> getOnOkListener() {
        return this.hVC;
    }

    public final void setOnOkListener(kotlin.g.a.a<x> aVar) {
        this.hVC = aVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LiveVisitorGuideView(Context context) {
        this(context, null, 0);
        p.h(context, "context");
        AppMethodBeat.i(208484);
        AppMethodBeat.o(208484);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LiveVisitorGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(208485);
        AppMethodBeat.o(208485);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ LiveVisitorGuideView hVD;

        c(LiveVisitorGuideView liveVisitorGuideView) {
            this.hVD = liveVisitorGuideView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208482);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupTitle$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> onHideListener = this.hVD.getOnHideListener();
            if (onHideListener != null) {
                onHideListener.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupTitle$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208482);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ LiveVisitorGuideView hVD;

        a(LiveVisitorGuideView liveVisitorGuideView) {
            this.hVD = liveVisitorGuideView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208480);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.hVD.hVA = !this.hVD.hVA;
            if (this.hVD.hVA) {
                this.hVD.hVu.setImageResource(R.raw.checkbox_selected);
                this.hVD.hVw.setEnabled(true);
            } else {
                this.hVD.hVu.setImageResource(R.drawable.p5);
                this.hVD.hVw.setEnabled(false);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208480);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ LiveVisitorGuideView hVD;

        b(LiveVisitorGuideView liveVisitorGuideView) {
            this.hVD = liveVisitorGuideView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208481);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> onOkListener = this.hVD.getOnOkListener();
            if (onOkListener != null) {
                onOkListener.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorGuideView$setupAction$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208481);
        }
    }
}
