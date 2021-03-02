package com.tencent.mm.plugin.d.a.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public static boolean eL(Context context) {
        AppMethodBeat.i(22628);
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        Log.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", Boolean.valueOf(hasSystemFeature));
        AppMethodBeat.o(22628);
        return hasSystemFeature;
    }

    public static boolean ckN() {
        boolean z;
        AppMethodBeat.i(22629);
        if (BluetoothAdapter.getDefaultAdapter() != null) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.exdevice.BluetoothSDKUtil", "isSupportBC: %b", Boolean.valueOf(z));
        AppMethodBeat.o(22629);
        return z;
    }

    public static boolean ckP() {
        AppMethodBeat.i(22630);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            AppMethodBeat.o(22630);
            return false;
        }
        boolean isEnabled = defaultAdapter.isEnabled();
        Log.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBluetoothOpen: %b", Boolean.valueOf(isEnabled));
        AppMethodBeat.o(22630);
        return isEnabled;
    }

    @Deprecated
    public static String BC(long j2) {
        AppMethodBeat.i(258841);
        String Dj = b.Dj(j2);
        AppMethodBeat.o(258841);
        return Dj;
    }
}
