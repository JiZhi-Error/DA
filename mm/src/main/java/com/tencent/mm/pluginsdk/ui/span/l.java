package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.c;
import java.util.LinkedList;

public final class l {
    static LinkedList<i> Krd = new LinkedList<>();
    private static boolean Kre = Util.isOverseasUser(MMApplicationContext.getContext());
    public static final a Krf = new a() {
        /* class com.tencent.mm.pluginsdk.ui.span.l.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.ui.span.l.a
        public final void a(r rVar) {
            boolean z;
            AppMethodBeat.i(223850);
            if (l.Krg.enable()) {
                z = true;
            } else {
                z = false;
            }
            rVar.KrV = z;
            AppMethodBeat.o(223850);
        }
    };
    public static b Krg = new b() {
        /* class com.tencent.mm.pluginsdk.ui.span.l.AnonymousClass2 */

        @Override // com.tencent.mm.pluginsdk.ui.span.l.b
        public final boolean enable() {
            return false;
        }
    };

    public interface a {
        void a(r rVar);
    }

    public interface b {
        boolean enable();
    }

    static {
        AppMethodBeat.i(152309);
        AppMethodBeat.o(152309);
    }

    public static void a(i iVar) {
        AppMethodBeat.i(152275);
        Krd.add(iVar);
        AppMethodBeat.o(152275);
    }

    public static void b(i iVar) {
        AppMethodBeat.i(152276);
        Krd.remove(iVar);
        AppMethodBeat.o(152276);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i2, boolean z, Object obj) {
        AppMethodBeat.i(152277);
        r rVar = new r(context);
        rVar.KrR = true;
        rVar.KrG = true;
        rVar.KrT = true;
        rVar.KrY = 1;
        rVar.KrO = false;
        rVar.Ksa = true;
        r C = rVar.C(null);
        C.KrM = true;
        C.KrP = true;
        if (obj != null) {
            C.Ksb = obj;
        }
        SpannableString b2 = C.b(charSequence, i2, z);
        AppMethodBeat.o(152277);
        return b2;
    }

    public static SpannableString a(TextView textView, Object obj) {
        AppMethodBeat.i(152278);
        SpannableString a2 = a(textView, true, obj);
        AppMethodBeat.o(152278);
        return a2;
    }

    public static SpannableString a(TextView textView, boolean z, Object obj) {
        AppMethodBeat.i(152279);
        if (textView == null) {
            Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(152279);
            return spannableString;
        }
        SpannableString a2 = a(textView.getContext(), textView, (int) textView.getTextSize(), z, 1, obj);
        AppMethodBeat.o(152279);
        return a2;
    }

    public static SpannableString p(TextView textView, int i2) {
        AppMethodBeat.i(152280);
        SpannableString a2 = a(textView, i2, 0, (Object) null);
        AppMethodBeat.o(152280);
        return a2;
    }

    public static SpannableString a(TextView textView, int i2, int i3, Object obj) {
        AppMethodBeat.i(223851);
        SpannableString a2 = a(textView, i2, i3, obj, (a) null);
        AppMethodBeat.o(223851);
        return a2;
    }

    public static SpannableString a(TextView textView, int i2, int i3, Object obj, a aVar) {
        AppMethodBeat.i(223852);
        if (textView == null) {
            Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(223852);
            return spannableString;
        }
        SpannableString a2 = a(textView.getContext(), textView, (int) textView.getTextSize(), i2, i3, obj, aVar);
        AppMethodBeat.o(223852);
        return a2;
    }

    public static SpannableString a(TextView textView, a aVar, Object obj) {
        AppMethodBeat.i(223853);
        if (textView == null) {
            Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(223853);
            return spannableString;
        }
        r rVar = new r(textView.getContext());
        rVar.KrK = true;
        rVar.KrG = true;
        rVar.KrH = true;
        rVar.KrJ = Kre;
        rVar.KrY = 2;
        rVar.KrL = true;
        rVar.KrO = false;
        rVar.KrQ = aiK(2);
        rVar.Ksa = true;
        rVar.Ksb = obj;
        r C = rVar.C(textView);
        C.gwE = 2;
        C.mAdTagClickCallback = aVar;
        C.mAdTagClickScene = 30;
        C.KrM = false;
        C.KrP = false;
        SpannableString b2 = C.b(textView.getText(), (int) textView.getTextSize(), true);
        AppMethodBeat.o(223853);
        return b2;
    }

    public static SpannableString a(TextView textView, Object obj, a aVar) {
        AppMethodBeat.i(223854);
        if (textView == null) {
            Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(223854);
            return spannableString;
        }
        Context context = textView.getContext();
        int textSize = (int) textView.getTextSize();
        r rVar = new r(context);
        rVar.KrK = true;
        rVar.KrG = true;
        rVar.KrH = true;
        rVar.KrJ = Kre;
        rVar.KrY = 1;
        rVar.KrL = true;
        rVar.KrO = false;
        rVar.Ksa = true;
        r C = rVar.C(textView);
        C.Ksb = obj;
        C.mSessionId = null;
        C.KrM = true;
        C.KrP = true;
        if (aVar != null) {
            aVar.a(C);
        }
        SpannableString b2 = C.b(textView.getText(), textSize, true);
        AppMethodBeat.o(223854);
        return b2;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i2, int i3, Object obj, String str) {
        AppMethodBeat.i(152282);
        SpannableString a2 = a(context, charSequence, i2, i3, obj, str, 0, null);
        AppMethodBeat.o(152282);
        return a2;
    }

    public static SpannableString c(Context context, CharSequence charSequence, int i2) {
        AppMethodBeat.i(223855);
        r rVar = new r(context);
        rVar.KrK = false;
        rVar.KrG = false;
        rVar.KrH = false;
        rVar.KrJ = Kre;
        rVar.KrY = 1;
        rVar.KrL = false;
        rVar.KrO = false;
        rVar.KrQ = aiK(1);
        rVar.Ksa = true;
        rVar.KrT = true;
        SpannableString b2 = rVar.b(charSequence, i2, false);
        AppMethodBeat.o(223855);
        return b2;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i2, int i3, Object obj, String str, int i4, a aVar) {
        AppMethodBeat.i(223856);
        r a2 = a(context, i3, obj, str);
        a2.gwE = i4;
        if (aVar != null) {
            aVar.a(a2);
        }
        SpannableString b2 = a2.b(charSequence, i2, true);
        AppMethodBeat.o(223856);
        return b2;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i2, Object obj, String str, a aVar) {
        AppMethodBeat.i(223857);
        r a2 = a(context, 1, obj, str);
        a2.KrG = false;
        if (aVar != null) {
            aVar.a(a2);
        }
        SpannableString b2 = a2.b(charSequence, i2, true);
        AppMethodBeat.o(223857);
        return b2;
    }

    private static SpannableString a(Context context, TextView textView, int i2, int i3, int i4, Object obj, a aVar) {
        AppMethodBeat.i(223858);
        r rVar = new r(context);
        rVar.KrK = true;
        rVar.KrG = true;
        rVar.KrH = true;
        rVar.KrJ = Kre;
        rVar.KrY = i3;
        rVar.KrL = true;
        rVar.KrO = false;
        rVar.KrQ = aiK(i3);
        rVar.Ksa = true;
        rVar.Ksb = obj;
        r C = rVar.C(textView);
        C.gwE = i4;
        if (i3 == 1) {
            C.KrM = true;
            C.KrP = true;
        } else if (i3 == 2) {
            C.KrM = false;
            C.KrP = false;
        }
        if (aVar != null) {
            aVar.a(C);
        }
        SpannableString b2 = C.b(textView.getText(), i2, true);
        AppMethodBeat.o(223858);
        return b2;
    }

    private static r a(Context context, int i2, Object obj, String str) {
        AppMethodBeat.i(152285);
        r rVar = new r(context);
        rVar.KrK = true;
        rVar.KrG = true;
        rVar.KrH = true;
        rVar.KrJ = Kre;
        rVar.KrY = i2;
        rVar.KrL = true;
        rVar.KrO = false;
        rVar.Ksa = true;
        r C = rVar.C(null);
        C.Ksb = obj;
        C.mSessionId = str;
        if (i2 == 1 || i2 == 4) {
            C.KrM = true;
            C.KrP = true;
        } else if (i2 == 2) {
            C.KrM = false;
            C.KrP = false;
        }
        if (LocaleUtil.CHINA.equals(LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()))) {
            C.KrN = true;
        }
        C.KrQ = aiK(i2);
        AppMethodBeat.o(152285);
        return C;
    }

    private static SpannableString a(Context context, TextView textView, int i2, boolean z, int i3, Object obj) {
        AppMethodBeat.i(223859);
        r rVar = new r(context);
        rVar.KrK = true;
        rVar.KrG = true;
        rVar.KrH = true;
        rVar.KrR = true;
        rVar.KrT = true;
        rVar.KrY = 1;
        rVar.KrL = true;
        rVar.KrO = false;
        rVar.Ksa = true;
        r C = rVar.C(textView);
        C.KrM = true;
        C.KrP = true;
        if (obj != null) {
            C.Ksb = obj;
        }
        SpannableString b2 = C.b(textView.getText(), i2, z);
        AppMethodBeat.o(223859);
        return b2;
    }

    public static SpannableString e(Context context, CharSequence charSequence, int i2) {
        AppMethodBeat.i(152287);
        SpannableString a2 = a(context, charSequence, i2, true);
        AppMethodBeat.o(152287);
        return a2;
    }

    public static SpannableString b(Context context, CharSequence charSequence, float f2) {
        AppMethodBeat.i(152288);
        SpannableString a2 = a(context, charSequence, (int) f2, true);
        AppMethodBeat.o(152288);
        return a2;
    }

    public static SpannableString d(Context context, CharSequence charSequence, float f2) {
        AppMethodBeat.i(152289);
        SpannableString a2 = a(context, charSequence, (int) f2, false);
        AppMethodBeat.o(152289);
        return a2;
    }

    public static SpannableString f(Context context, CharSequence charSequence, int i2) {
        AppMethodBeat.i(152290);
        r rVar = new r(context);
        rVar.KrL = false;
        rVar.KrM = false;
        rVar.KrG = false;
        rVar.KrH = false;
        rVar.KrO = false;
        rVar.KrY = i2;
        rVar.KrK = false;
        rVar.Ksa = false;
        SpannableString b2 = rVar.b(charSequence, 0, true);
        e(b2);
        AppMethodBeat.o(152290);
        return b2;
    }

    private static void e(Spannable spannable) {
        ClickableSpan[] clickableSpanArr;
        AppMethodBeat.i(152291);
        for (ClickableSpan clickableSpan : (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class)) {
            spannable.removeSpan(clickableSpan);
        }
        AppMethodBeat.o(152291);
    }

    private static boolean aiK(int i2) {
        AppMethodBeat.i(223860);
        if (i2 == 2 || i2 == 3) {
            c cVar = c.QYz;
            if (c.hdg()) {
                AppMethodBeat.o(223860);
                return true;
            }
            b.a aVar = b.a.clicfg_open_inline_tag_sns_flag;
            c cVar2 = c.QYz;
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, c.hdj()) == 1) {
                AppMethodBeat.o(223860);
                return true;
            }
            AppMethodBeat.o(223860);
            return false;
        }
        c cVar3 = c.QYz;
        if (c.hdg()) {
            AppMethodBeat.o(223860);
            return true;
        }
        b.a aVar2 = b.a.clicfg_open_inline_tag_c2c_flag;
        c cVar4 = c.QYz;
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar2, c.hdi()) == 1) {
            AppMethodBeat.o(223860);
            return true;
        }
        AppMethodBeat.o(223860);
        return false;
    }

    public static SpannableString c(Context context, CharSequence charSequence) {
        AppMethodBeat.i(152292);
        SpannableString a2 = a(context, charSequence, 0, true);
        AppMethodBeat.o(152292);
        return a2;
    }

    private static SpannableString a(Context context, CharSequence charSequence, int i2, boolean z) {
        AppMethodBeat.i(152293);
        r rVar = new r(context);
        rVar.KrL = false;
        rVar.KrM = false;
        rVar.KrG = false;
        rVar.KrH = false;
        rVar.KrO = false;
        rVar.KrK = false;
        rVar.Ksa = false;
        SpannableString b2 = rVar.b(charSequence, i2, z);
        e(b2);
        AppMethodBeat.o(152293);
        return b2;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i2, int i3, boolean z, Object obj) {
        AppMethodBeat.i(223861);
        SpannableString a2 = a(context, charSequence, i2, i3, z, obj, (a) null);
        AppMethodBeat.o(223861);
        return a2;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i2, int i3, boolean z, Object obj, a aVar) {
        AppMethodBeat.i(223862);
        r rVar = new r(context);
        rVar.KrK = true;
        rVar.KrG = true;
        rVar.KrH = true;
        rVar.KrJ = Kre;
        rVar.KrY = i3;
        rVar.KrL = true;
        rVar.KrO = false;
        rVar.Ksa = true;
        rVar.KrQ = aiK(i3);
        rVar.Ksb = obj;
        if (i3 == 1) {
            rVar.KrM = true;
            rVar.KrP = true;
        } else if (i3 == 2) {
            rVar.KrM = false;
            rVar.KrP = false;
            rVar.KrW = z;
            rVar.gwE = 2;
        }
        if (aVar != null) {
            aVar.a(rVar);
        }
        SpannableString b2 = rVar.b(charSequence, i2, true);
        AppMethodBeat.o(223862);
        return b2;
    }

    public static SpannableString g(Context context, CharSequence charSequence, int i2) {
        AppMethodBeat.i(152296);
        r rVar = new r(context);
        rVar.KrK = true;
        rVar.KrG = true;
        rVar.KrH = true;
        rVar.KrJ = Kre;
        rVar.KrT = true;
        rVar.KrY = 1;
        rVar.KrL = true;
        rVar.KrO = false;
        rVar.Ksa = true;
        rVar.Ksb = null;
        rVar.KrM = true;
        rVar.KrP = true;
        SpannableString b2 = rVar.b(charSequence, i2, true);
        AppMethodBeat.o(152296);
        return b2;
    }

    public static SpannableString h(Context context, CharSequence charSequence, int i2) {
        AppMethodBeat.i(223863);
        r rVar = new r(context);
        rVar.KrK = false;
        rVar.KrG = true;
        rVar.KrH = false;
        rVar.KrJ = Kre;
        rVar.KrT = false;
        rVar.KrY = 1;
        rVar.KrL = true;
        rVar.KrO = false;
        rVar.Ksa = true;
        rVar.KrM = false;
        rVar.KrP = false;
        SpannableString b2 = rVar.b(charSequence, i2, true);
        AppMethodBeat.o(223863);
        return b2;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i2, Object obj) {
        AppMethodBeat.i(152297);
        SpannableString a2 = a(context, charSequence, i2, 1, obj, false);
        AppMethodBeat.o(152297);
        return a2;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i2, int i3, Object obj, boolean z) {
        AppMethodBeat.i(162013);
        r rVar = new r(context);
        rVar.KrK = true;
        rVar.KrG = true;
        rVar.KrH = true;
        rVar.KrJ = Kre;
        rVar.KrT = true;
        rVar.KrY = i3;
        rVar.KrL = true;
        rVar.KrO = false;
        rVar.Ksa = true;
        rVar.Ksb = obj;
        rVar.KrX = z;
        if (i3 == 1) {
            rVar.KrM = true;
            rVar.KrP = true;
        } else if (i3 == 2) {
            rVar.KrM = false;
            rVar.KrP = false;
        }
        SpannableString b2 = rVar.b(charSequence, i2, false);
        AppMethodBeat.o(162013);
        return b2;
    }

    public static SpannableString i(Context context, CharSequence charSequence, int i2) {
        AppMethodBeat.i(152299);
        SpannableString b2 = b(context, charSequence, i2, true);
        AppMethodBeat.o(152299);
        return b2;
    }

    public static SpannableString e(Context context, CharSequence charSequence, float f2) {
        AppMethodBeat.i(152300);
        SpannableString b2 = b(context, charSequence, (int) f2, false);
        AppMethodBeat.o(152300);
        return b2;
    }

    private static SpannableString b(Context context, CharSequence charSequence, int i2, boolean z) {
        AppMethodBeat.i(152301);
        r rVar = new r(context);
        rVar.KrK = false;
        rVar.KrG = true;
        rVar.KrH = true;
        rVar.KrR = true;
        rVar.KrS = z;
        rVar.KrT = true;
        rVar.KrY = 1;
        rVar.KrL = false;
        rVar.KrO = false;
        rVar.KrM = false;
        rVar.KrP = false;
        rVar.Ksa = false;
        SpannableString b2 = rVar.b(charSequence, i2, true);
        AppMethodBeat.o(152301);
        return b2;
    }

    public static String bfh(String str) {
        AppMethodBeat.i(152302);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(152302);
            return str;
        }
        r rVar = new r(MMApplicationContext.getContext());
        rVar.KrK = false;
        rVar.KrG = true;
        rVar.KrH = true;
        rVar.KrR = true;
        rVar.KrS = true;
        rVar.KrT = true;
        rVar.KrY = 1;
        rVar.KrL = false;
        rVar.KrO = false;
        rVar.KrM = false;
        rVar.KrP = false;
        rVar.KrU = false;
        rVar.Ksa = false;
        String spannableString = rVar.b(str, 0, false).toString();
        AppMethodBeat.o(152302);
        return spannableString;
    }

    public static void clearCache() {
        AppMethodBeat.i(152303);
        Log.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
        r.clearCache();
        AppMethodBeat.o(152303);
    }

    public static SpannableString B(TextView textView) {
        AppMethodBeat.i(152304);
        SpannableString a2 = a(textView.getContext(), textView, (int) textView.getTextSize(), (Object) null, (a) null);
        AppMethodBeat.o(152304);
        return a2;
    }

    public static SpannableString b(TextView textView, Object obj, a aVar) {
        AppMethodBeat.i(223864);
        if (textView == null) {
            Log.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(223864);
            return spannableString;
        }
        SpannableString a2 = a(textView.getContext(), textView, (int) textView.getTextSize(), obj, aVar);
        AppMethodBeat.o(223864);
        return a2;
    }

    private static SpannableString a(Context context, TextView textView, int i2, Object obj, a aVar) {
        AppMethodBeat.i(223865);
        r rVar = new r(context);
        rVar.KrK = false;
        rVar.KrG = false;
        rVar.KrH = false;
        rVar.KrJ = false;
        rVar.KrL = false;
        rVar.KrO = false;
        rVar.Ksa = true;
        r C = rVar.C(textView);
        C.Ksb = obj;
        C.KrY = 1;
        C.KrM = false;
        C.KrP = false;
        if (aVar != null) {
            aVar.a(C);
        }
        SpannableString b2 = C.b(textView.getText(), i2, false);
        AppMethodBeat.o(223865);
        return b2;
    }

    public static CharSequence d(Context context, CharSequence charSequence) {
        AppMethodBeat.i(152305);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(charSequence);
        int length = charSequence.length();
        spannableStringBuilder.append((CharSequence) " ");
        Drawable drawable = context.getResources().getDrawable(R.raw.open_im_title_logo);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.setSpan(new com.tencent.mm.ui.widget.a(drawable, 1), length, length + 1, 18);
        AppMethodBeat.o(152305);
        return spannableStringBuilder;
    }

    public static SpannableString j(Context context, CharSequence charSequence, int i2) {
        AppMethodBeat.i(152307);
        r rVar = new r(context);
        rVar.KrK = false;
        rVar.KrG = true;
        rVar.KrH = true;
        rVar.KrI = false;
        rVar.KrR = false;
        rVar.KrS = false;
        rVar.KrT = false;
        rVar.KrY = 1;
        rVar.KrL = false;
        rVar.KrO = false;
        rVar.KrM = false;
        rVar.KrP = false;
        rVar.Ksa = true;
        SpannableString b2 = rVar.b(charSequence, i2, true);
        AppMethodBeat.o(152307);
        return b2;
    }

    public static SpannableString d(Context context, CharSequence charSequence, int i2) {
        AppMethodBeat.i(152284);
        r rVar = new r(context);
        rVar.KrK = true;
        rVar.KrG = true;
        rVar.KrH = true;
        rVar.KrJ = Kre;
        rVar.KrY = 1;
        rVar.KrL = true;
        rVar.KrO = false;
        rVar.Ksa = false;
        r C = rVar.C(null);
        C.Ksb = null;
        C.mSessionId = null;
        C.KrM = true;
        C.KrP = true;
        SpannableString b2 = C.b(charSequence, i2, true);
        AppMethodBeat.o(152284);
        return b2;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(162012);
        SpannableString a2 = a(context, charSequence, i2, i3, false, (Object) null);
        AppMethodBeat.o(162012);
        return a2;
    }
}
