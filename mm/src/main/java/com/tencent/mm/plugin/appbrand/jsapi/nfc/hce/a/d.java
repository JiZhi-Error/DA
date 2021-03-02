package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class d {
    private static boolean bHV() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @TargetApi(21)
    public static boolean bHW() {
        AppMethodBeat.i(136185);
        if (bHV()) {
            boolean hasSystemFeature = MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
            AppMethodBeat.o(136185);
            return hasSystemFeature;
        }
        AppMethodBeat.o(136185);
        return false;
    }

    public static boolean bHX() {
        AppMethodBeat.i(136186);
        Context context = MMApplicationContext.getContext();
        if (!context.getPackageManager().hasSystemFeature("android.hardware.nfc")) {
            AppMethodBeat.o(136186);
            return false;
        } else if (NfcAdapter.getDefaultAdapter(context) == null) {
            AppMethodBeat.o(136186);
            return false;
        } else {
            AppMethodBeat.o(136186);
            return true;
        }
    }

    public static boolean bHY() {
        AppMethodBeat.i(136187);
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext());
        if (defaultAdapter == null) {
            Log.i("MicroMsg.HceUtils", "alvinluo no nfc chip !");
            AppMethodBeat.o(136187);
            return false;
        } else if (!defaultAdapter.isEnabled()) {
            AppMethodBeat.o(136187);
            return false;
        } else {
            AppMethodBeat.o(136187);
            return true;
        }
    }
}
