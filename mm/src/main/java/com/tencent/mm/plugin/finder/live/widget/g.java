package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0015H\u0002J\u0006\u0010!\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\n \u000e*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u000e*\u0004\u0018\u00010\u00170\u0017X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\n \u000e*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u000e*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget;", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "licenseContainer", "Landroid/view/ViewGroup;", "callback", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "blankArea", "Landroid/view/View;", "kotlin.jvm.PlatformType", "btnGroup", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "cancelBtn", "Landroid/widget/TextView;", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "getLicenseContainer", "()Landroid/view/ViewGroup;", "okBtn", "tipTv", "hideLicensePanel", "onBackPressed", "", "setLicenseText", "tv", "showLicensePanel", "plugin-finder_release"})
public final class g {
    final MMActivity activity;
    private final View hRx = this.uGC.findViewById(R.id.cwp);
    public final LiveBottomSheetPanel hRy = ((LiveBottomSheetPanel) this.uGC.findViewById(R.id.cws));
    private final TextView jBS = ((TextView) this.uGC.findViewById(R.id.cwu));
    private final TextView kaq = ((TextView) this.uGC.findViewById(R.id.cwr));
    private final View uGB = this.uGC.findViewById(R.id.cwq);
    public final ViewGroup uGC;
    kotlin.g.a.a<x> uGD;
    private final TextView uvg = ((TextView) this.uGC.findViewById(R.id.cww));

    public g(MMActivity mMActivity, ViewGroup viewGroup, kotlin.g.a.a<x> aVar) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(viewGroup, "licenseContainer");
        AppMethodBeat.i(248103);
        this.activity = mMActivity;
        this.uGC = viewGroup;
        this.uGD = aVar;
        LiveBottomSheetPanel liveBottomSheetPanel = this.hRy;
        p.g(liveBottomSheetPanel, "contentGroup");
        liveBottomSheetPanel.setTranslationY((float) au.az(this.activity).y);
        this.hRy.setOnVisibilityListener(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.g.AnonymousClass1 */
            final /* synthetic */ g uGE;

            {
                this.uGE = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(248095);
                if (!bool.booleanValue()) {
                    this.uGE.uGC.setVisibility(8);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248095);
                return xVar;
            }
        });
        View view = this.uGB;
        p.g(view, "btnGroup");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(248103);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += au.aD(this.uGC.getContext());
        TextView textView = this.jBS;
        p.g(textView, "tipTv");
        Context context = textView.getContext();
        p.g(context, "tv.context");
        String string = context.getResources().getString(R.string.cqu);
        p.g(string, "tv.context.resources.get…inder_live_anchor_iterms)");
        Context context2 = textView.getContext();
        p.g(context2, "tv.context");
        String string2 = context2.getResources().getString(R.string.cqy);
        p.g(string2, "tv.context.resources.get…der_live_anchor_standard)");
        ae aeVar = ae.SYK;
        Context context3 = textView.getContext();
        p.g(context3, "tv.context");
        String string3 = context3.getResources().getString(R.string.ctf);
        p.g(string3, "tv.context.resources.get….finder_live_license_tip)");
        String format = String.format(string3, Arrays.copyOf(new Object[]{string, string2}, 2));
        p.g(format, "java.lang.String.format(format, *args)");
        int a2 = n.a((CharSequence) format, string, 0, false, 6);
        int length = a2 + string.length();
        int a3 = n.a((CharSequence) format, string2, 0, false, 6);
        int length2 = a3 + string2.length();
        SpannableString spannableString = new SpannableString(format);
        a aVar2 = new a(this);
        b bVar = new b(this);
        spannableString.setSpan(aVar2, a2, length, 33);
        spannableString.setSpan(bVar, a3, length2, 33);
        Context context4 = textView.getContext();
        p.g(context4, "tv.context");
        textView.setHighlightColor(context4.getResources().getColor(17170445));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.uvg.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.g.AnonymousClass2 */
            final /* synthetic */ g uGE;

            {
                this.uGE = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248096);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uGE.hRy.hide();
                kotlin.g.a.a<x> aVar = this.uGE.uGD;
                if (aVar != null) {
                    aVar.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248096);
            }
        });
        this.kaq.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.g.AnonymousClass3 */
            final /* synthetic */ g uGE;

            {
                this.uGE = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248097);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uGE.hRy.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248097);
            }
        });
        this.hRx.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.g.AnonymousClass4 */
            final /* synthetic */ g uGE;

            {
                this.uGE = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248098);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uGE.hRy.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248098);
            }
        });
        AppMethodBeat.o(248103);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget$setLicenseText$firstClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
    public static final class a extends ClickableSpan {
        final /* synthetic */ g uGE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(g gVar) {
            this.uGE = gVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248099);
            p.h(view, "widget");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy");
            c.b(this.uGE.activity, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(248099);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(248100);
            p.h(textPaint, "ds");
            textPaint.setColor(Color.parseColor("#7D90A9"));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
            AppMethodBeat.o(248100);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget$setLicenseText$secondClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
    public static final class b extends ClickableSpan {
        final /* synthetic */ g uGE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(g gVar) {
            this.uGE = gVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248101);
            p.h(view, "widget");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_up_privacy");
            c.b(this.uGE.activity, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(248101);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(248102);
            p.h(textPaint, "ds");
            textPaint.setColor(Color.parseColor("#7D90A9"));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
            AppMethodBeat.o(248102);
        }
    }
}
