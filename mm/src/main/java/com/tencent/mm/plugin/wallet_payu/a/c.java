package com.tencent.mm.plugin.wallet_payu.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.f;
import junit.framework.Assert;

public final class c {
    public static void a(final Context context, TextView textView) {
        AppMethodBeat.i(72053);
        Assert.assertTrue(textView != null);
        l lVar = new l(context);
        lVar.IgH = new l.a() {
            /* class com.tencent.mm.plugin.wallet_payu.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
            public final void onClick(View view) {
                AppMethodBeat.i(72051);
                Log.i("MicroMsg.PayUUtil", "hy: user clicked the span");
                f.bn(context, "https://www.payu.co.za/wechat/terms-and-conditions/");
                AppMethodBeat.o(72051);
            }
        };
        l lVar2 = new l(context);
        lVar2.IgH = new l.a() {
            /* class com.tencent.mm.plugin.wallet_payu.a.c.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
            public final void onClick(View view) {
                AppMethodBeat.i(72052);
                Log.i("MicroMsg.PayUUtil", "hy: user clicked the tos span");
                f.bn(context, com.tencent.mm.pluginsdk.wallet.c.KxC);
                AppMethodBeat.o(72052);
            }
        };
        String charSequence = context.getText(R.string.ios).toString();
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(lVar, 94, 115, 33);
        spannableString.setSpan(lVar2, charSequence.length() - 3, charSequence.length(), 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(72053);
    }
}
