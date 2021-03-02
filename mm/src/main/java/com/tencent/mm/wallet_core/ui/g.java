package com.tencent.mm.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;

public final class g {
    private static String lAr = null;
    private static int rxH = 0;
    private static int rxv = 0;

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(final com.tencent.mm.wallet_core.ui.WalletBaseUI r8, int r9, int r10, java.lang.String r11, final com.tencent.mm.ak.q r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 564
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.wallet_core.ui.g.a(com.tencent.mm.wallet_core.ui.WalletBaseUI, int, int, java.lang.String, com.tencent.mm.ak.q, boolean):void");
    }

    public static void clearErr() {
        rxH = 0;
        rxv = 0;
        lAr = null;
    }

    static /* synthetic */ void c(WalletBaseUI walletBaseUI) {
        AppMethodBeat.i(73059);
        if (rxH == 1000) {
            switch (rxv) {
                case 1:
                    if (!walletBaseUI.onProgressFinish()) {
                        walletBaseUI.setContentViewVisibility(0);
                    }
                    walletBaseUI.cleanUiData(0);
                    break;
                case 2:
                default:
                    if (!walletBaseUI.isTransparent() && walletBaseUI.getContentViewVisibility() == 0) {
                        walletBaseUI.cleanUiData(0);
                        break;
                    } else {
                        walletBaseUI.finish();
                        break;
                    }
                    break;
                case 3:
                    a.c(walletBaseUI.getContext(), walletBaseUI.getInput(), rxv);
                    break;
            }
        } else {
            a.s(walletBaseUI.getContext(), rxv);
        }
        rxH = 0;
        rxv = 0;
        lAr = null;
        AppMethodBeat.o(73059);
    }
}
