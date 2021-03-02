package com.tencent.mm.plugin.multitask.ui.minusscreen.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u001c\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bJ \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\bJ\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/utils/MultiTaskViewUtils;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "calcTextWidth", "", "context", "Landroid/content/Context;", "length", "checkTitle", "title", "MAX_SHOW_TITLE_COUNT", "getFileResIcon", "fileExt", "getMultiTaskResIcon", "viewType", "getNickName", "", "tv", "Landroid/widget/TextView;", "spanText", "maxNameCount", "setAuthIcon", "", "view", "Landroid/widget/ImageView;", "authIconType", "authIconUrl", "ui-multitask_release"})
public final class a {
    public static final a Aep = new a();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(236508);
        AppMethodBeat.o(236508);
    }

    private a() {
    }

    private static int Z(Context context, int i2) {
        AppMethodBeat.i(236504);
        p.h(context, "context");
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, (i2 * 12) + 1);
        AppMethodBeat.o(236504);
        return fromDPToPix;
    }

    public static CharSequence a(TextView textView, CharSequence charSequence, int i2) {
        AppMethodBeat.i(236505);
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
            AppMethodBeat.o(236505);
            return charSequence;
        }
        int lineEnd = staticLayout.getLineEnd(0);
        Context context3 = textView.getContext();
        StringBuilder sb = new StringBuilder();
        String obj = charSequence.toString();
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(236505);
            throw tVar;
        }
        String substring = obj.substring(0, lineEnd);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context3, sb.append(substring).append("...").toString());
        p.g(c2, "MMSpanManager.spanForSmi…0, ellipseStart) + \"...\")");
        SpannableString spannableString = c2;
        AppMethodBeat.o(236505);
        return spannableString;
    }

    public static void a(ImageView imageView, int i2, String str) {
        boolean z;
        AppMethodBeat.i(236506);
        p.h(imageView, "view");
        imageView.setVisibility(8);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(null);
        }
        Log.i(TAG, "authType = " + i2 + ", authIconUrl = " + str);
        imageView.setVisibility(0);
        if (i2 > 0) {
            switch (i2) {
                case 1:
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        m mVar = m.uJa;
                        d<o> djY = m.djY();
                        com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(str, x.FULL_IMAGE);
                        m mVar2 = m.uJa;
                        djY.a(pVar, imageView, m.a(m.a.TIMELINE));
                        AppMethodBeat.o(236506);
                        return;
                    }
                    imageView.setImageDrawable(ar.m(imageView.getContext(), R.raw.icons_filled_star_identify, com.tencent.mm.cb.a.n(imageView.getContext(), R.color.a3b)));
                    AppMethodBeat.o(236506);
                    return;
                case 2:
                    imageView.setImageResource(R.raw.icons_filled_star_identify_enterprise);
                    AppMethodBeat.o(236506);
                    return;
                case 100:
                    imageView.setVisibility(8);
                    AppMethodBeat.o(236506);
                    return;
                default:
                    imageView.setVisibility(8);
                    AppMethodBeat.o(236506);
                    return;
            }
        } else {
            imageView.setVisibility(8);
            AppMethodBeat.o(236506);
        }
    }

    public static int aGN(String str) {
        AppMethodBeat.i(236507);
        Integer agX = com.tencent.mm.plugin.ball.f.d.agX(str);
        if (agX == null) {
            agX = com.tencent.mm.plugin.ball.f.d.agX("unknown");
        }
        p.g(agX, "iconRes");
        int intValue = agX.intValue();
        AppMethodBeat.o(236507);
        return intValue;
    }

    public static int RR(int i2) {
        switch (i2) {
            case 1:
                return R.raw.icons_filled_mini_program2;
            case 2:
            default:
                return R.raw.icons_filled_link;
            case 3:
                return R.raw.bottomsheet_icon_fav;
            case 4:
                return R.raw.icons_filled_documentation;
            case 8:
                return R.raw.icons_filled_news;
            case 22:
                return R.raw.icons_filled_play2;
        }
    }
}
