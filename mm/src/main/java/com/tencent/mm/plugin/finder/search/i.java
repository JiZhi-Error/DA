package com.tencent.mm.plugin.finder.search;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bJ\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\b2\u0006\u0010!\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderSearchLogic;", "", "()V", "FeedItemWidth", "", "getFeedItemWidth", "()I", "HighLightWordEnd", "", "getHighLightWordEnd", "()Ljava/lang/String;", "HighLightWordReplaceEnd", "getHighLightWordReplaceEnd", "HighLightWordReplaceStart", "getHighLightWordReplaceStart", "HighLightWordStart", "getHighLightWordStart", "finderDataCache", "Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "getFinderDataCache", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "setFinderDataCache", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;)V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "processHighLight", "Landroid/text/Spanned;", FirebaseAnalytics.b.ORIGIN, "textPaint", "Landroid/text/TextPaint;", "width", "removeHighLightTag", "plugin-finder_release"})
public final class i {
    private static ConcurrentHashMap<Long, FinderItem> tZo = new ConcurrentHashMap<>();
    private static final String vvo = vvo;
    private static final String vvp = vvp;
    private static final String vvq = vvq;
    private static final String vvr = vvr;
    private static final int vvs = (a.jn(MMApplicationContext.getContext()) - a.fromDPToPix(MMApplicationContext.getContext(), 72));
    private static aqw vvt;
    public static final i vvu = new i();

    static {
        AppMethodBeat.i(166868);
        AppMethodBeat.o(166868);
    }

    private i() {
    }

    public static String auY(String str) {
        AppMethodBeat.i(166865);
        p.h(str, FirebaseAnalytics.b.ORIGIN);
        k kVar = new k(vvo);
        String e2 = new k(vvp).e(kVar.e(str, ""), "");
        AppMethodBeat.o(166865);
        return e2;
    }

    public static Spanned auZ(String str) {
        ForegroundColorSpan[] foregroundColorSpanArr;
        AppMethodBeat.i(166866);
        p.h(str, FirebaseAnalytics.b.ORIGIN);
        Spanned fromHtml = Html.fromHtml(new k(vvp).e(new k(vvo).e(str, vvq), vvr));
        if ((fromHtml instanceof SpannableStringBuilder) && (foregroundColorSpanArr = (ForegroundColorSpan[]) fromHtml.getSpans(0, fromHtml.length(), ForegroundColorSpan.class)) != null) {
            for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
                Log.i("Finder.Hightlight", new StringBuilder().append(fromHtml.getSpanStart(foregroundColorSpan)).append(' ').append(fromHtml.getSpanEnd(foregroundColorSpan)).toString());
            }
        }
        p.g(fromHtml, "spanStr");
        AppMethodBeat.o(166866);
        return fromHtml;
    }

    public static Spanned a(String str, TextPaint textPaint, int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(166867);
        p.h(str, FirebaseAnalytics.b.ORIGIN);
        p.h(textPaint, "textPaint");
        Spanned fromHtml = Html.fromHtml(new k(vvp).e(new k(vvo).e(str, vvq), vvr));
        if (textPaint.measureText(fromHtml.toString()) <= ((float) i2) || !(fromHtml instanceof SpannableStringBuilder)) {
            p.g(fromHtml, "spanStr");
            AppMethodBeat.o(166867);
            return fromHtml;
        }
        float textSize = ((float) i2) - (textPaint.getTextSize() * 2.0f);
        float measureText = textPaint.measureText("…");
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) fromHtml.getSpans(0, fromHtml.length(), ForegroundColorSpan.class);
        if (foregroundColorSpanArr != null) {
            i4 = 0;
            i3 = 0;
            for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
                i3 = fromHtml.getSpanStart(foregroundColorSpan);
                i4 = fromHtml.getSpanEnd(foregroundColorSpan);
            }
        } else {
            i4 = 0;
            i3 = 0;
        }
        if (i4 == 0) {
            AppMethodBeat.o(166867);
            return fromHtml;
        }
        float measureText2 = textPaint.measureText(fromHtml, 0, i3);
        float measureText3 = textPaint.measureText(fromHtml, i3, i4);
        float measureText4 = textPaint.measureText(fromHtml, i4, fromHtml.length());
        CharSequence subSequence = fromHtml.subSequence(0, i3);
        CharSequence subSequence2 = fromHtml.subSequence(i3, i4);
        CharSequence subSequence3 = fromHtml.subSequence(i4, fromHtml.length());
        if (measureText2 + measureText3 + measureText < textSize) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(subSequence);
            spannableStringBuilder.append(subSequence2);
            spannableStringBuilder.append(TextUtils.ellipsize(subSequence3, textPaint, (textSize - measureText2) - measureText3, TextUtils.TruncateAt.END));
            SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
            AppMethodBeat.o(166867);
            return spannableStringBuilder2;
        } else if (measureText + measureText3 + measureText4 < textSize) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
            spannableStringBuilder3.append(TextUtils.ellipsize(subSequence, textPaint, (textSize - measureText3) - measureText4, TextUtils.TruncateAt.START));
            spannableStringBuilder3.append(subSequence2);
            spannableStringBuilder3.append(subSequence3);
            SpannableStringBuilder spannableStringBuilder4 = spannableStringBuilder3;
            AppMethodBeat.o(166867);
            return spannableStringBuilder4;
        } else if (measureText + measureText3 + measureText >= textSize) {
            SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder();
            spannableStringBuilder5.append(TextUtils.ellipsize(subSequence2, textPaint, textSize, TextUtils.TruncateAt.END));
            SpannableStringBuilder spannableStringBuilder6 = spannableStringBuilder5;
            AppMethodBeat.o(166867);
            return spannableStringBuilder6;
        } else {
            SpannableStringBuilder spannableStringBuilder7 = new SpannableStringBuilder();
            float f2 = (textSize - measureText3) / 2.0f;
            spannableStringBuilder7.append(TextUtils.ellipsize(subSequence, textPaint, f2, TextUtils.TruncateAt.START));
            spannableStringBuilder7.append(subSequence2);
            spannableStringBuilder7.append(TextUtils.ellipsize(subSequence3, textPaint, f2, TextUtils.TruncateAt.END));
            SpannableStringBuilder spannableStringBuilder8 = spannableStringBuilder7;
            AppMethodBeat.o(166867);
            return spannableStringBuilder8;
        }
    }

    public static int dpZ() {
        return vvs;
    }

    public static void a(aqw aqw) {
        vvt = aqw;
    }

    public static aqw dqa() {
        return vvt;
    }

    public static ConcurrentHashMap<Long, FinderItem> dqb() {
        return tZo;
    }
}
