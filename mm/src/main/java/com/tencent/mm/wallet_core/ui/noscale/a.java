package com.tencent.mm.wallet_core.ui.noscale;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a {
    public static void hL(final View view) {
        AppMethodBeat.i(214350);
        if (com.tencent.mm.cc.a.gvi() != 1.0f) {
            view.post(new Runnable() {
                /* class com.tencent.mm.wallet_core.ui.noscale.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(214349);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    if (marginLayoutParams != null) {
                        float gvi = com.tencent.mm.cc.a.gvi();
                        if (marginLayoutParams.height > 0) {
                            marginLayoutParams.height = (int) (((float) marginLayoutParams.height) / gvi);
                        }
                        if (marginLayoutParams.width > 0) {
                            marginLayoutParams.width = (int) (((float) marginLayoutParams.width) / gvi);
                        }
                        marginLayoutParams.topMargin = (int) (((float) marginLayoutParams.topMargin) / gvi);
                        marginLayoutParams.bottomMargin = (int) (((float) marginLayoutParams.bottomMargin) / gvi);
                        marginLayoutParams.leftMargin = (int) (((float) marginLayoutParams.leftMargin) / gvi);
                        marginLayoutParams.rightMargin = (int) (((float) marginLayoutParams.rightMargin) / gvi);
                        view.setLayoutParams(marginLayoutParams);
                    }
                    AppMethodBeat.o(214349);
                }
            });
        }
        AppMethodBeat.o(214350);
    }

    public static int axx(int i2) {
        AppMethodBeat.i(258763);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), i2);
        if (com.tencent.mm.cc.a.gvi() != 1.0f) {
            fromDPToPix = (int) (((float) fromDPToPix) / com.tencent.mm.cc.a.gvi());
        }
        AppMethodBeat.o(258763);
        return fromDPToPix;
    }
}
