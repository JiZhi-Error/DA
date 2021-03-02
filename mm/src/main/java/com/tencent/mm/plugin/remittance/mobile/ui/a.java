package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.remittance.mobile.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.a.g;

public final class a {
    public static void a(final MMActivity mMActivity, final boolean z, final String str) {
        AppMethodBeat.i(213712);
        final g gVar = new g(mMActivity, 1, 3);
        gVar.b(mMActivity.getString(R.string.f21), mMActivity.getString(R.string.aaw));
        View inflate = View.inflate(mMActivity, R.layout.i7, null);
        TextView textView = (TextView) inflate.findViewById(R.id.ipm);
        ao.a(textView.getPaint(), 0.8f);
        if (z) {
            textView.setText(R.string.aax);
            char[] charArray = str.toCharArray();
            String str2 = "";
            for (int i2 = 0; i2 < charArray.length; i2++) {
                if (i2 % 4 == 0 && i2 > 0) {
                    str2 = str2 + " ";
                }
                str2 = str2 + charArray[i2];
            }
            b.VY(4);
            str = str2;
        } else {
            textView.setText(R.string.aay);
            b.VY(1);
        }
        View inflate2 = View.inflate(mMActivity, R.layout.i6, null);
        ((TextView) inflate2.findViewById(R.id.be9)).setText(str);
        gVar.a(new g.a() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.a.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.a.g.a
            public final void onClick() {
                AppMethodBeat.i(213710);
                Log.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click cancel!");
                gVar.bMo();
                if (z) {
                    b.VY(5);
                    AppMethodBeat.o(213710);
                    return;
                }
                b.VY(2);
                AppMethodBeat.o(213710);
            }
        }, new g.a() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.a.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.a.g.a
            public final void onClick() {
                AppMethodBeat.i(213711);
                Log.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click confirm!");
                Intent intent = new Intent();
                if (z) {
                    intent.putExtra("key_content", str);
                    c.b(mMActivity, "remittance", ".bankcard.ui.BankRemitBankcardInputUI", intent);
                    b.VY(6);
                } else {
                    intent.putExtra("key_content", str);
                    if (com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_MOBILE_REMITTANCE_WELOCOME_PAGE_SHOW_BOOLEAN_SYNC, true)) {
                        c.b(mMActivity, "remittance", ".mobile.ui.MobileRemitWelcomeUI", intent);
                    } else {
                        c.b(mMActivity, "remittance", ".mobile.ui.MobileRemitNumberInputUI", intent);
                    }
                    b.VY(3);
                }
                gVar.bMo();
                AppMethodBeat.o(213711);
            }
        });
        gVar.setHeaderView(inflate);
        gVar.setCustomView(inflate2);
        gVar.dGm();
        AppMethodBeat.o(213712);
    }
}
