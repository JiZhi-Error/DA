package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.ui.au;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0006\u0010\u001b\u001a\u00020\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \t*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "blankArea", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "licenseState", "", "lisenceCheck", "Landroid/widget/CheckBox;", "lisenceContainer", "lisenceTv", "Landroid/widget/TextView;", "okBtn", "hideLisencePanel", "", "saveLicenseState", "setLicenseText", "tv", "shakeIt", "showLisencePanel", "plugin-finder_release"})
public final class bv extends d {
    final com.tencent.mm.live.c.b hOp;
    private final View hRx;
    public final LiveBottomSheetPanel hRy;
    final TextView uvg;
    private final View uvi;
    final CheckBox uvj;
    private final TextView uvk;
    final View uvl;
    int uvm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bv(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(247156);
        this.hOp = bVar;
        this.hRx = viewGroup.findViewById(R.id.cnq);
        this.uvi = viewGroup.findViewById(R.id.cnp);
        this.uvg = (TextView) viewGroup.findViewById(R.id.cnw);
        this.uvj = (CheckBox) viewGroup.findViewById(R.id.cnt);
        this.uvk = (TextView) viewGroup.findViewById(R.id.cnv);
        this.uvl = viewGroup.findViewById(R.id.cnu);
        View findViewById = viewGroup.findViewById(R.id.cnr);
        p.g(findViewById, "root.findViewById(R.id.f…_lisence_ui_content_area)");
        this.hRy = (LiveBottomSheetPanel) findViewById;
        this.hRy.setTranslationY((float) au.az(viewGroup.getContext()).y);
        this.hRy.setOnVisibilityListener(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bv.AnonymousClass1 */
            final /* synthetic */ bv uvn;

            {
                this.uvn = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(247145);
                if (!bool.booleanValue()) {
                    this.uvn.rg(8);
                    b.C0376b.a(this.uvn.hOp, b.c.hNU);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(247145);
                return xVar;
            }
        });
        this.uvl.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bv.AnonymousClass2 */
            final /* synthetic */ bv uvn;

            {
                this.uvn = r1;
            }

            public final void onClick(View view) {
                boolean z;
                int i2 = 1;
                AppMethodBeat.i(247146);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CheckBox checkBox = this.uvn.uvj;
                p.g(checkBox, "lisenceCheck");
                CheckBox checkBox2 = this.uvn.uvj;
                p.g(checkBox2, "lisenceCheck");
                if (!checkBox2.isChecked()) {
                    z = true;
                } else {
                    z = false;
                }
                checkBox.setChecked(z);
                bv bvVar = this.uvn;
                CheckBox checkBox3 = this.uvn.uvj;
                p.g(checkBox3, "lisenceCheck");
                if (!checkBox3.isChecked()) {
                    i2 = 0;
                }
                bvVar.uvm = i2;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247146);
            }
        });
        this.uvj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bv.AnonymousClass3 */
            final /* synthetic */ bv uvn;

            {
                this.uvn = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i2;
                boolean z2 = true;
                AppMethodBeat.i(247147);
                bv bvVar = this.uvn;
                CheckBox checkBox = this.uvn.uvj;
                p.g(checkBox, "lisenceCheck");
                if (checkBox.isChecked()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                bvVar.uvm = i2;
                TextView textView = this.uvn.uvg;
                p.g(textView, "okBtn");
                if (this.uvn.uvm == 0) {
                    z2 = false;
                }
                textView.setActivated(z2);
                AppMethodBeat.o(247147);
            }
        });
        TextView textView = this.uvk;
        p.g(textView, "lisenceTv");
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
        String string3 = context3.getResources().getString(R.string.cqn);
        p.g(string3, "tv.context.resources.get…ng.finder_live_agree_new)");
        String format = String.format(string3, Arrays.copyOf(new Object[]{string, string2}, 2));
        p.g(format, "java.lang.String.format(format, *args)");
        int a2 = n.a((CharSequence) format, string, 0, false, 6);
        int length = a2 + string.length();
        int a3 = n.a((CharSequence) format, string2, 0, false, 6);
        int length2 = a3 + string2.length();
        SpannableString spannableString = new SpannableString(format);
        a aVar = new a(this);
        b bVar2 = new b(this);
        spannableString.setSpan(aVar, a2, length, 33);
        spannableString.setSpan(bVar2, a3, length2, 33);
        Context context4 = textView.getContext();
        p.g(context4, "tv.context");
        textView.setHighlightColor(context4.getResources().getColor(17170445));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.uvi.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bv.AnonymousClass4 */
            final /* synthetic */ bv uvn;

            {
                this.uvn = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(247148);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uvn.hRy.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247148);
            }
        });
        this.hRx.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bv.AnonymousClass5 */
            final /* synthetic */ bv uvn;

            {
                this.uvn = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(247149);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uvn.hRy.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247149);
            }
        });
        this.uvg.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bv.AnonymousClass6 */
            final /* synthetic */ bv uvn;

            {
                this.uvn = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(247150);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.uvn.uvm != 1) {
                    bv bvVar = this.uvn;
                    bvVar.uvl.startAnimation(AnimationUtils.loadAnimation(bvVar.hwr.getContext(), R.anim.a1));
                } else {
                    bv bvVar2 = this.uvn;
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    com.tencent.mm.plugin.finder.storage.c.KW(bvVar2.uvm);
                    b.C0376b.a(this.uvn.hOp, b.c.hNV);
                    this.uvn.hRy.hide();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247150);
            }
        });
        if (!isLandscape()) {
            this.hRy.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom() + au.aD(viewGroup.getContext()));
        }
        AppMethodBeat.o(247156);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin$setLicenseText$firstClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
    public static final class a extends ClickableSpan {
        final /* synthetic */ bv uvn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(bv bvVar) {
            this.uvn = bvVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(247151);
            p.h(view, "widget");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy");
            com.tencent.mm.br.c.b(this.uvn.hwr.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(247151);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(247152);
            p.h(textPaint, "ds");
            textPaint.setColor(Color.parseColor("#7D90A9"));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
            AppMethodBeat.o(247152);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin$setLicenseText$secondClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
    public static final class b extends ClickableSpan {
        final /* synthetic */ bv uvn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(bv bvVar) {
            this.uvn = bvVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(247153);
            p.h(view, "widget");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_up_privacy");
            com.tencent.mm.br.c.b(this.uvn.hwr.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(247153);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(247154);
            p.h(textPaint, "ds");
            textPaint.setColor(Color.parseColor("#7D90A9"));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
            AppMethodBeat.o(247154);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ bv uvn;

        public c(bv bvVar) {
            this.uvn = bvVar;
        }

        public final void run() {
            AppMethodBeat.i(247155);
            TextView textView = this.uvn.uvg;
            p.g(textView, "okBtn");
            textView.setActivated(this.uvn.uvm != 0);
            this.uvn.hRy.show();
            AppMethodBeat.o(247155);
        }
    }
}
