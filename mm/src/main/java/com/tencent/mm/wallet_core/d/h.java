package com.tencent.mm.wallet_core.d;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public final class h {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(final com.tencent.mm.wallet_core.ui.WalletBaseUI r10, final com.tencent.mm.ak.q r11, int r12, final int r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 364
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.wallet_core.d.h.a(com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.ak.q, int, int, java.lang.String):boolean");
    }

    private static void b(final WalletBaseUI walletBaseUI, final int i2, String str) {
        AppMethodBeat.i(72854);
        com.tencent.mm.ui.base.h.a((Context) walletBaseUI, false, str, "", walletBaseUI.getString(R.string.icf), walletBaseUI.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.wallet_core.d.h.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(72842);
                f.bn(walletBaseUI, "https://www.payu.co.za/wechat/contact-us/");
                if (walletBaseUI.isTransparent() || walletBaseUI.getContentViewVisibility() != 0) {
                    walletBaseUI.finish();
                }
                AppMethodBeat.o(72842);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.wallet_core.d.h.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(72843);
                a.c(walletBaseUI, walletBaseUI.getInput(), i2);
                if (walletBaseUI.isTransparent() || walletBaseUI.getContentViewVisibility() != 0) {
                    walletBaseUI.finish();
                }
                AppMethodBeat.o(72843);
            }
        });
        AppMethodBeat.o(72854);
    }
}
