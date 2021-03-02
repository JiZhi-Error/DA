package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g {
    private static String TAG = "MicroMsg.SnsPostDescUtil";

    public static m a(Context context, String str, float f2, boolean z, Object obj) {
        AppMethodBeat.i(204006);
        m mVar = new m(l.a(context, str, (int) f2, 2, z, obj));
        AppMethodBeat.o(204006);
        return mVar;
    }

    public static CharSequence d(Spannable spannable) {
        p[] pVarArr;
        String str;
        AppMethodBeat.i(204007);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannable);
        try {
            if (!Util.isNullOrNil(spannable) && (pVarArr = (p[]) spannable.getSpans(0, spannable.length(), p.class)) != null && pVarArr.length > 0) {
                for (p pVar : pVarArr) {
                    if (pVar.getType() == 1 && (str = pVar.getHrefInfo().url) != null && str.length() > ah.DKc && spannableStringBuilder.toString().contains(str)) {
                        String str2 = str.substring(0, ah.DKc) + "...";
                        SpannableString spannableString = new SpannableString(str2);
                        spannableString.setSpan(new p(2, pVar.getHrefInfo()), 0, str2.length(), 33);
                        int indexOf = spannableStringBuilder.toString().indexOf(str);
                        spannableStringBuilder.replace(indexOf, str.length() + indexOf, (CharSequence) spannableString);
                    }
                }
            }
        } catch (Exception e2) {
            Log.w(TAG, "compressedPostDesc fail:%s", spannable);
        }
        AppMethodBeat.o(204007);
        return spannableStringBuilder;
    }
}
