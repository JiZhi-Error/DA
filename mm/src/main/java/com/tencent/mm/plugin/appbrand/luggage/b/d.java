package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.c;
import com.tencent.mm.ce.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.widget.input.a.b;
import com.tencent.mm.pointers.PInt;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J8\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/customize/LuggageEmojiCompatByWechat;", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat;", "()V", "getEmojiItemBySoftBank", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat$EmojiInfo;", "codePoint", "", "getSmileySpan", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "source", "", "sizePx", "", "replaceEmojiSpan", "Landroid/text/Spannable;", "ss", "sizeInPx", "maxNum", "Lcom/tencent/mm/pointers/PInt;", "factory", "Landroid/text/Spannable$Factory;", "plugin-appbrand-integration_release"})
public final class d implements b {
    public static final d nae = new d();

    static {
        AppMethodBeat.i(50854);
        j.UJ("com.tencent.mm.plugin.emoji.PluginEmoji");
        AppMethodBeat.o(50854);
    }

    private d() {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.a.b
    public final SpannableString a(Context context, CharSequence charSequence, float f2) {
        AppMethodBeat.i(50851);
        SpannableString a2 = g.gxZ().a(context, charSequence, f2);
        p.g(a2, "SmileyManager.getInstanc…(context, source, sizePx)");
        AppMethodBeat.o(50851);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.a.b
    public final b.a ys(int i2) {
        AppMethodBeat.i(50852);
        c ajN = com.tencent.mm.ce.b.gxI().ajN(i2);
        if (ajN != null) {
            b.a aVar = new b.a();
            aVar.owH = ajN.owH;
            aVar.owI = ajN.owI;
            aVar.owJ = ajN.owJ;
            AppMethodBeat.o(50852);
            return aVar;
        }
        AppMethodBeat.o(50852);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.a.b
    public final Spannable a(Spannable spannable, int i2, PInt pInt, Spannable.Factory factory) {
        AppMethodBeat.i(50853);
        p.h(factory, "factory");
        Spannable a2 = com.tencent.mm.ce.b.gxI().a(spannable, i2, pInt, factory);
        AppMethodBeat.o(50853);
        return a2;
    }
}
