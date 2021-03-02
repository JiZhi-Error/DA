package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/StringSpanHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class af {
    public static final a ohG = new a((byte) 0);

    static {
        AppMethodBeat.i(229598);
        AppMethodBeat.o(229598);
    }

    public static final Pair<SpannableString, Integer> a(Context context, int i2, int i3, int i4, ClickableSpan clickableSpan) {
        AppMethodBeat.i(229600);
        Pair<SpannableString, Integer> a2 = a.a(context, i2, 4, i3, i4, clickableSpan);
        AppMethodBeat.o(229600);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0007JH\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/StringSpanHelper$Companion;", "", "()V", "emptySpanIcon", "Landroid/util/Pair;", "Landroid/text/SpannableString;", "", "context", "Landroid/content/Context;", "getLineStartAndEnd", "", "Landroid/graphics/Point;", "tp", "Landroid/text/TextPaint;", "cs", "", "lineWidth", "makeSpanIcon", "iconResId", "leftMarginDp", "widthDp", "heightDp", "clickableSpan", "Landroid/text/style/ClickableSpan;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static Pair<SpannableString, Integer> a(Context context, int i2, int i3, int i4, int i5, ClickableSpan clickableSpan) {
            AppMethodBeat.i(229597);
            p.h(context, "context");
            Drawable drawable = context.getResources().getDrawable(i2);
            p.g(drawable, "context.resources.getDrawable(iconResId)");
            drawable.setBounds(o.zE(i3), 0, o.zE(i4 + i3), o.zE(i5));
            com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
            SpannableString spannableString = new SpannableString("@");
            spannableString.setSpan(aVar, 0, 1, 33);
            if (clickableSpan != null) {
                spannableString.setSpan(clickableSpan, 0, 1, 33);
            }
            Pair<SpannableString, Integer> pair = new Pair<>(spannableString, Integer.valueOf(drawable.getBounds().right));
            AppMethodBeat.o(229597);
            return pair;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/utils/StringSpanHelper$Companion$emptySpanIcon$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.utils.af$a$a  reason: collision with other inner class name */
        public static final class C0813a extends ClickableSpan {
            C0813a() {
            }

            public final void onClick(View view) {
                AppMethodBeat.i(229596);
                p.h(view, "widget");
                AppMethodBeat.o(229596);
            }
        }
    }

    public static final List<Point> a(TextPaint textPaint, CharSequence charSequence, int i2) {
        AppMethodBeat.i(229599);
        p.h(textPaint, "tp");
        p.h(charSequence, "cs");
        StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        int lineCount = staticLayout.getLineCount();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < lineCount; i3++) {
            arrayList.add(new Point(staticLayout.getLineStart(i3), staticLayout.getLineEnd(i3)));
        }
        AppMethodBeat.o(229599);
        return arrayList;
    }

    public static final Pair<SpannableString, Integer> es(Context context) {
        AppMethodBeat.i(229601);
        p.h(context, "context");
        Pair<SpannableString, Integer> a2 = a.a(context, R.drawable.ta, 1, 0, 0, new a.C0813a());
        AppMethodBeat.o(229601);
        return a2;
    }
}
