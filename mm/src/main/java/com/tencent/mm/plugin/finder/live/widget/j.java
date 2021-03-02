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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020)H\u0002J\u0006\u0010-\u001a\u00020)J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020#H\u0002J\u0006\u00100\u001a\u00020)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget;", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "licenseContainer", "Landroid/view/ViewGroup;", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "setContainer", "(Landroid/view/View;)V", "lastAction", "", "getLicenseContainer", "()Landroid/view/ViewGroup;", "licenseState", "getLicenseState", "()I", "setLicenseState", "(I)V", "licenseTxt", "Landroid/widget/TextView;", "getLicenseTxt", "()Landroid/widget/TextView;", "setLicenseTxt", "(Landroid/widget/TextView;)V", "checkLicenseState", "", "isReady", "", "reportOnClick", "saveLicenseState", "setLicenseText", "tv", "shakeIt", "plugin-finder_release"})
public final class j {
    final MMActivity activity;
    public CheckBox checkBox;
    public View jxm = this.uGC;
    private final ViewGroup uGC;
    public final FinderLivePostUIC.e uGJ;
    private TextView uGX;
    private int uGY;
    public int uvm = c.duQ();

    public j(MMActivity mMActivity, ViewGroup viewGroup, FinderLivePostUIC.e eVar) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(viewGroup, "licenseContainer");
        p.h(eVar, "callback");
        AppMethodBeat.i(248123);
        this.activity = mMActivity;
        this.uGC = viewGroup;
        this.uGJ = eVar;
        c cVar = c.vCb;
        this.jxm.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.j.AnonymousClass1 */
            final /* synthetic */ j uGZ;

            {
                this.uGZ = r1;
            }

            public final void onClick(View view) {
                int i2 = 1;
                AppMethodBeat.i(248115);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uGZ.getCheckBox().setChecked(!this.uGZ.getCheckBox().isChecked());
                j jVar = this.uGZ;
                if (!this.uGZ.getCheckBox().isChecked()) {
                    i2 = 0;
                }
                jVar.uvm = i2;
                this.uGZ.uGJ.onChange();
                j.a(this.uGZ);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248115);
            }
        });
        View findViewById = this.jxm.findViewById(R.id.gfd);
        p.g(findViewById, "container.findViewById(R.id.post_license_checkbox)");
        this.checkBox = (CheckBox) findViewById;
        CheckBox checkBox2 = this.checkBox;
        if (checkBox2 == null) {
            p.btv("checkBox");
        }
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.j.AnonymousClass2 */
            final /* synthetic */ j uGZ;

            {
                this.uGZ = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i2;
                AppMethodBeat.i(248116);
                j jVar = this.uGZ;
                if (this.uGZ.getCheckBox().isChecked()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jVar.uvm = i2;
                this.uGZ.uGJ.onChange();
                j.a(this.uGZ);
                AppMethodBeat.o(248116);
            }
        });
        View findViewById2 = this.jxm.findViewById(R.id.gff);
        p.g(findViewById2, "container.findViewById(R.id.post_license_tv)");
        this.uGX = (TextView) findViewById2;
        TextView textView = this.uGX;
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
        b bVar = new b(this);
        spannableString.setSpan(aVar, a2, length, 33);
        spannableString.setSpan(bVar, a3, length2, 33);
        Context context4 = textView.getContext();
        p.g(context4, "tv.context");
        textView.setHighlightColor(context4.getResources().getColor(17170445));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.uGY = s.ai.LIVE_RULE_CHECK_NO.action;
        AppMethodBeat.o(248123);
    }

    public final CheckBox getCheckBox() {
        AppMethodBeat.i(248121);
        CheckBox checkBox2 = this.checkBox;
        if (checkBox2 == null) {
            p.btv("checkBox");
        }
        AppMethodBeat.o(248121);
        return checkBox2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$setLicenseText$firstClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
    public static final class a extends ClickableSpan {
        final /* synthetic */ j uGZ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(j jVar) {
            this.uGZ = jVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248117);
            p.h(view, "widget");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy");
            com.tencent.mm.br.c.b(this.uGZ.activity, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(248117);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(248118);
            p.h(textPaint, "ds");
            textPaint.setColor(Color.parseColor("#7D90A9"));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
            AppMethodBeat.o(248118);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget$setLicenseText$secondClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
    public static final class b extends ClickableSpan {
        final /* synthetic */ j uGZ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(j jVar) {
            this.uGZ = jVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248119);
            p.h(view, "widget");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_up_privacy");
            com.tencent.mm.br.c.b(this.uGZ.activity, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(248119);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(248120);
            p.h(textPaint, "ds");
            textPaint.setColor(Color.parseColor("#7D90A9"));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
            AppMethodBeat.o(248120);
        }
    }

    public final boolean isReady() {
        return this.uvm == 1;
    }

    public final void djL() {
        AppMethodBeat.i(248122);
        c cVar = c.vCb;
        c.KW(this.uvm);
        AppMethodBeat.o(248122);
    }

    public static final /* synthetic */ void a(j jVar) {
        int i2;
        AppMethodBeat.i(248124);
        if (jVar.uvm == 1) {
            i2 = s.ai.LIVE_RULE_CHECK_YES.action;
        } else {
            i2 = s.ai.LIVE_RULE_CHECK_NO.action;
        }
        if (jVar.uGY != i2) {
            k kVar = k.vkd;
            k.q(s.a.LIVE_RULE.hlf, String.valueOf(i2));
            k kVar2 = k.vkd;
            k.KI(i2);
            jVar.uGY = i2;
        }
        AppMethodBeat.o(248124);
    }
}
