package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u001c\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u000bJ\u0006\u0010\u001e\u001a\u00020\u000bJ\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u000bJ\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J6\u0010&\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0004J>\u0010&\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderOriginalUtil;", "", "()V", "ORIGINAL_TERMS_URL", "", "getORIGINAL_TERMS_URL", "()Ljava/lang/String;", "setORIGINAL_TERMS_URL", "(Ljava/lang/String;)V", "TAG", "debugOriginalNeedCheck", "", "getDebugOriginalNeedCheck", "()Z", "setDebugOriginalNeedCheck", "(Z)V", "checkInsertOriginalRedDot", "", "checkPostNeedOriginal", "context", "Lcom/tencent/mm/ui/MMActivity;", "continuePost", "Lkotlin/Function0;", "getRemainApplyCount", "", "getRemainForwardCount", "getSelfOriginalEntranceFlag", "getSelfOriginalFlag", "getSpamDay", "getSpamYearFlag", "isSelfOriginal", "isSelfOriginalNeedCheck", "isSelfOriginalSpam", "setSpanTouch", "tv", "Landroid/widget/TextView;", "text", "Landroid/text/Spannable;", "spanLink", "Landroid/content/Context;", "h5url", "allText", "linkText", "descTv", "logTag", "rawDescText", "startTag", "endTag", "plugin-finder_release"})
public final class p {
    public static final String TAG = TAG;
    private static String vVX = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/cgi-bin/readtemplate?t=finder_appeal");
    public static final p vVY = new p();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "url", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String vVZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, Context context) {
            super(1);
            this.vVZ = str;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(253458);
            String str2 = str;
            kotlin.g.b.p.h(str2, "url");
            Log.i(this.vVZ, "click ".concat(String.valueOf(str2)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            c.b(this.$context, "webview", ".ui.tools.WebViewUI", intent);
            x xVar = x.SXb;
            AppMethodBeat.o(253458);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(253466);
        AppMethodBeat.o(253466);
    }

    private p() {
    }

    public static String dBT() {
        return vVX;
    }

    public static void a(Context context, String str, String str2, String str3, TextView textView, String str4) {
        AppMethodBeat.i(253459);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(str, "h5url");
        kotlin.g.b.p.h(str2, "allText");
        kotlin.g.b.p.h(str3, "linkText");
        kotlin.g.b.p.h(textView, "descTv");
        kotlin.g.b.p.h(str4, "logTag");
        int a2 = n.a((CharSequence) str2, str3, 0, false, 6);
        int length = a2 + str3.length();
        SpannableString spannableString = new SpannableString(str2);
        if (a2 >= 0 && length <= str2.length()) {
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            int color = context2.getResources().getColor(R.color.x0);
            Context context3 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context3, "MMApplicationContext.getContext()");
            spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(str, color, context3.getResources().getColor(R.color.BW_0_Alpha_0_2), new b(str4, context)), a2, length, 17);
        }
        textView.setText(spannableString);
        textView.setOnTouchListener(new a(spannableString, textView));
        AppMethodBeat.o(253459);
    }

    public static int dBU() {
        AppMethodBeat.i(253460);
        e aAh = g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_MY_FINDER_ORIGINAL_REPOST_COUNT_INT_SYNC, (Object) 1);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(253460);
            throw tVar;
        }
        int intValue = ((Integer) obj).intValue();
        if (intValue < 0) {
            AppMethodBeat.o(253460);
            return 0;
        }
        AppMethodBeat.o(253460);
        return intValue;
    }

    public static boolean dBV() {
        AppMethodBeat.i(253461);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.duA().value().intValue() != 1) {
            e aAh = g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            if (!kotlin.g.b.p.j(aAh.azQ().get(ar.a.USERINFO_MY_FINDER_ORIGINAL_ENTRANCE2_INT_SYNC, (Object) 0), 1)) {
                AppMethodBeat.o(253461);
                return false;
            }
        }
        AppMethodBeat.o(253461);
        return true;
    }

    public static int dBW() {
        AppMethodBeat.i(253462);
        e aAh = g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_MY_FINDER_ORIGINAL_FLAG2_INT_SYNC, 0);
        AppMethodBeat.o(253462);
        return i2;
    }

    public static boolean dBX() {
        AppMethodBeat.i(253463);
        e aAh = g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        if (aAh.azQ().getInt(ar.a.USERINFO_MY_FINDER_ORIGINAL_PUNISH_YEAR_FLAG_INT_SYNC, 0) > 0) {
            AppMethodBeat.o(253463);
            return true;
        }
        AppMethodBeat.o(253463);
        return false;
    }

    public static int dBY() {
        AppMethodBeat.i(253464);
        e aAh = g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_MY_FINDER_ORIGINAL_PUNISH_INT_SYNC, 0);
        AppMethodBeat.o(253464);
        return i2;
    }

    public static boolean dBZ() {
        AppMethodBeat.i(253465);
        if (dBW() == 2) {
            AppMethodBeat.o(253465);
            return true;
        }
        AppMethodBeat.o(253465);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class a implements View.OnTouchListener {
        final /* synthetic */ TextView tPp;
        final /* synthetic */ Spannable vJd;

        a(Spannable spannable, TextView textView) {
            this.vJd = spannable;
            this.tPp = textView;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z;
            ClickableSpan[] clickableSpanArr;
            AppMethodBeat.i(253457);
            kotlin.g.b.p.g(motionEvent, "event");
            int action = motionEvent.getAction();
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(253457);
                throw tVar;
            }
            TextView textView = (TextView) view;
            Spannable spannable = this.vJd;
            if ((action == 1 || action == 3) && (clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, this.vJd.length(), ClickableSpan.class)) != null) {
                for (ClickableSpan clickableSpan : clickableSpanArr) {
                    if (clickableSpan instanceof com.tencent.mm.pluginsdk.ui.span.p) {
                        ((com.tencent.mm.pluginsdk.ui.span.p) clickableSpan).setIsPressed(false);
                        this.tPp.invalidate();
                    }
                }
            }
            if (action == 1 || action == 0) {
                int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                int scrollX = x + textView.getScrollX();
                int scrollY = y + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
                ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr2.length != 0) {
                    ClickableSpan clickableSpan2 = clickableSpanArr2[0];
                    if (action == 1) {
                        clickableSpan2.onClick(textView);
                    } else if (action == 0) {
                        if (clickableSpan2 instanceof com.tencent.mm.pluginsdk.ui.span.p) {
                            ((com.tencent.mm.pluginsdk.ui.span.p) clickableSpan2).setIsPressed(true);
                            this.tPp.invalidate();
                        }
                        Selection.setSelection(spannable, spannable.getSpanStart(clickableSpan2), spannable.getSpanEnd(clickableSpan2));
                    }
                    z = true;
                    p pVar = p.vVY;
                    Log.i(p.TAG, "touch " + motionEvent.getX() + ", " + motionEvent.getY() + ", ret:" + z);
                    AppMethodBeat.o(253457);
                    return z;
                }
                Selection.removeSelection(spannable);
            }
            z = false;
            p pVar2 = p.vVY;
            Log.i(p.TAG, "touch " + motionEvent.getX() + ", " + motionEvent.getY() + ", ret:" + z);
            AppMethodBeat.o(253457);
            return z;
        }
    }
}
