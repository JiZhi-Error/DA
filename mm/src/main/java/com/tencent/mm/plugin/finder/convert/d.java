package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u000bJ \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u000bJ\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u000bJ(\u0010%\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000bH\u0002J\u0016\u0010(\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0016JZ\u0010)\u001a\u00020 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010+2\b\u0010/\u001a\u0004\u0018\u00010\u001b2\u0006\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderCommentConvertUtil;", "", "()V", "TAG", "", "lastProfileUsername", "getLastProfileUsername", "()Ljava/lang/String;", "setLastProfileUsername", "(Ljava/lang/String;)V", "calcTextWidth", "", "context", "Landroid/content/Context;", "length", "ellipseText", "tp", "Landroid/text/TextPaint;", "text", "maxWidth", "maxWithEllipseWidth", "getNickName", "", "paint", "spanText", "maxNameCount", "tv", "Landroid/widget/TextView;", "getTextViewWidth", "getTextWidth", "", "jumpProfile", "", ch.COL_USERNAME, "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "commentScene", "measureByStaticLayout", "width", "extraMaxWidth", "setNickName", "setNicknameCalculateWidth", "feedCommentLayout", "Landroid/view/View;", "nickNameTv", "commentTime", "awesomeIv", "awesomeNumTv", "ownerTv", "friendTv", "nickNameCharsequence", "commentTimeText", "plugin-finder_release"})
public final class d {
    private static final String TAG = TAG;
    private static String tyY = "";
    public static final d tyZ = new d();

    static {
        AppMethodBeat.i(178099);
        AppMethodBeat.o(178099);
    }

    private d() {
    }

    public static void asR(String str) {
        AppMethodBeat.i(178093);
        p.h(str, "<set-?>");
        tyY = str;
        AppMethodBeat.o(178093);
    }

    public static void a(String str, s sVar, Context context, int i2) {
        AppMethodBeat.i(178094);
        p.h(str, ch.COL_USERNAME);
        p.h(sVar, "item");
        p.h(context, "context");
        if (Util.isNullOrNil(str) || !Util.isEqual(tyY, str) || !(context instanceof FinderProfileTimeLineUI)) {
            Intent intent = new Intent();
            intent.putExtra("finder_username", str);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(context, intent, sVar.uOf.field_feedId, 5, false, 64);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context, intent);
            k kVar = k.vfA;
            k.a(5, sVar.uOf.field_feedId, i2, 1, str);
            AppMethodBeat.o(178094);
            return;
        }
        ((FinderProfileTimeLineUI) context).finish();
        AppMethodBeat.o(178094);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ View tza;
        final /* synthetic */ TextView tzb;
        final /* synthetic */ String tzc;
        final /* synthetic */ View tzd;
        final /* synthetic */ TextView tze;
        final /* synthetic */ TextView tzf;
        final /* synthetic */ TextView tzg;
        final /* synthetic */ TextView tzh;

        a(View view, Context context, TextView textView, String str, View view2, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
            this.tza = view;
            this.$context = context;
            this.tzb = textView;
            this.tzc = str;
            this.tzd = view2;
            this.tze = textView2;
            this.tzf = textView3;
            this.tzg = textView4;
            this.tzh = textView5;
        }

        public final void run() {
            int i2;
            int i3;
            AppMethodBeat.i(178092);
            if (this.tza.getWidth() > 0) {
                int width = this.tza.getWidth() - com.tencent.mm.cb.a.aG(this.$context, R.dimen.cs);
                float measureText = this.tzb.getPaint().measureText(this.tzc) + ((float) com.tencent.mm.cb.a.aG(this.$context, R.dimen.ct));
                if (this.tzd == null || this.tzd.getVisibility() != 0) {
                    i2 = 0;
                    i3 = 0;
                } else {
                    i3 = this.tzd.getWidth();
                    i2 = (this.tze == null || this.tze.getVisibility() != 0) ? 0 : this.tze.getWidth() + com.tencent.mm.cb.a.aG(this.$context, R.dimen.bt);
                }
                d dVar = d.tyZ;
                int l = d.l(this.tzf) + com.tencent.mm.cb.a.aG(this.$context, R.dimen.bt);
                d dVar2 = d.tyZ;
                this.tzh.setMaxWidth((int) ((((float) width) - (((float) i2) + ((((float) (l + (d.l(this.tzg) + com.tencent.mm.cb.a.aG(this.$context, R.dimen.bt)))) + measureText) + ((float) i3)))) - ((float) com.tencent.mm.cb.a.aG(this.$context, R.dimen.ct))));
            }
            AppMethodBeat.o(178092);
        }
    }

    public static void a(Context context, View view, TextView textView, TextView textView2, View view2, TextView textView3, TextView textView4, TextView textView5, CharSequence charSequence, String str) {
        AppMethodBeat.i(178095);
        p.h(context, "context");
        p.h(view, "feedCommentLayout");
        p.h(textView, "nickNameTv");
        p.h(textView2, "commentTime");
        p.h(textView4, "ownerTv");
        p.h(textView5, "friendTv");
        p.h(charSequence, "nickNameCharsequence");
        p.h(str, "commentTimeText");
        view.post(new a(view, context, textView2, str, view2, textView3, textView4, textView5, textView));
        AppMethodBeat.o(178095);
    }

    public static int Z(Context context, int i2) {
        AppMethodBeat.i(178096);
        p.h(context, "context");
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, (i2 * 15) + 1);
        AppMethodBeat.o(178096);
        return fromDPToPix;
    }

    public static String a(TextPaint textPaint, String str, int i2, int i3) {
        AppMethodBeat.i(178097);
        p.h(textPaint, "tp");
        if (str == null || Util.isNullOrNil(str)) {
            if (str == null) {
                str = "";
            }
            AppMethodBeat.o(178097);
            return str;
        }
        try {
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), str);
            StaticLayout staticLayout = new StaticLayout(c2, 0, c2.length(), textPaint, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            if (new StaticLayout(c2, 0, c2.length(), textPaint, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount() <= 1) {
                AppMethodBeat.o(178097);
                return str;
            }
            int lineEnd = staticLayout.getLineEnd(0);
            StringBuilder sb = new StringBuilder();
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(178097);
                throw tVar;
            }
            String substring = str.substring(0, lineEnd);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String sb2 = sb.append(substring).append("...").toString();
            AppMethodBeat.o(178097);
            return sb2;
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "ellipseText: ".concat(String.valueOf(str)), new Object[0]);
            AppMethodBeat.o(178097);
            return str;
        }
    }

    public final void d(TextView textView, CharSequence charSequence) {
        AppMethodBeat.i(178098);
        p.h(textView, "tv");
        p.h(charSequence, "spanText");
        textView.setText(e(textView, charSequence));
        AppMethodBeat.o(178098);
    }

    public static /* synthetic */ CharSequence e(TextView textView, CharSequence charSequence) {
        AppMethodBeat.i(242772);
        c cVar = c.vCb;
        CharSequence a2 = a(textView, charSequence, c.drZ());
        AppMethodBeat.o(242772);
        return a2;
    }

    public static CharSequence a(TextView textView, CharSequence charSequence, int i2) {
        AppMethodBeat.i(242771);
        p.h(textView, "tv");
        p.h(charSequence, "spanText");
        Context context = textView.getContext();
        p.g(context, "tv.context");
        int Z = Z(context, i2);
        Context context2 = textView.getContext();
        p.g(context2, "tv.context");
        int Z2 = Z(context2, i2 + 1);
        StaticLayout staticLayout = new StaticLayout(charSequence, 0, charSequence.length(), textView.getPaint(), Z, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        if (new StaticLayout(charSequence, 0, charSequence.length(), textView.getPaint(), Z2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount() <= 1) {
            AppMethodBeat.o(242771);
            return charSequence;
        }
        int lineEnd = staticLayout.getLineEnd(0);
        Context context3 = textView.getContext();
        StringBuilder sb = new StringBuilder();
        String obj = charSequence.toString();
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(242771);
            throw tVar;
        }
        String substring = obj.substring(0, lineEnd);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context3, sb.append(substring).append("...").toString());
        p.g(c2, "MMSpanManager.spanForSmi…0, ellipseStart) + \"...\")");
        SpannableString spannableString = c2;
        AppMethodBeat.o(242771);
        return spannableString;
    }

    public static /* synthetic */ CharSequence a(Context context, TextPaint textPaint, CharSequence charSequence) {
        AppMethodBeat.i(242773);
        c cVar = c.vCb;
        int drZ = c.drZ();
        p.h(context, "context");
        p.h(textPaint, "paint");
        p.h(charSequence, "spanText");
        int Z = Z(context, drZ);
        int Z2 = Z(context, drZ + 1);
        StaticLayout staticLayout = new StaticLayout(charSequence, 0, charSequence.length(), textPaint, Z, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        if (new StaticLayout(charSequence, 0, charSequence.length(), textPaint, Z2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount() <= 1) {
            AppMethodBeat.o(242773);
            return charSequence;
        }
        int lineEnd = staticLayout.getLineEnd(0);
        StringBuilder sb = new StringBuilder();
        String obj = charSequence.toString();
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(242773);
            throw tVar;
        }
        String substring = obj.substring(0, lineEnd);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context, sb.append(substring).append("...").toString());
        p.g(c2, "MMSpanManager.spanForSmi…0, ellipseStart) + \"...\")");
        SpannableString spannableString = c2;
        AppMethodBeat.o(242773);
        return spannableString;
    }

    public static final /* synthetic */ int l(TextView textView) {
        AppMethodBeat.i(178100);
        if (textView.getVisibility() != 0) {
            AppMethodBeat.o(178100);
            return 0;
        }
        int measureText = ((int) textView.getPaint().measureText(textView.getText().toString())) + 1;
        AppMethodBeat.o(178100);
        return measureText;
    }
}
