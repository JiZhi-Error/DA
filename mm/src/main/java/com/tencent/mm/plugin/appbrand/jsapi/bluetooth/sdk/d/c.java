package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Method;
import java.util.UUID;

public final class c {
    public static synchronized BluetoothManager bFB() {
        BluetoothManager bluetoothManager;
        synchronized (c.class) {
            AppMethodBeat.i(144657);
            bluetoothManager = (BluetoothManager) MMApplicationContext.getContext().getSystemService("bluetooth");
            AppMethodBeat.o(144657);
        }
        return bluetoothManager;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static synchronized BluetoothAdapter bFC() {
        BluetoothAdapter bluetoothAdapter;
        synchronized (c.class) {
            AppMethodBeat.i(144658);
            BluetoothManager bFB = bFB();
            if (bFB != null) {
                bluetoothAdapter = bFB.getAdapter();
                AppMethodBeat.o(144658);
            } else {
                a.e("MicroMsg.Ble.BleHelper", "BluetoothManager is null err", new Object[0]);
                bluetoothAdapter = null;
                AppMethodBeat.o(144658);
            }
        }
        return bluetoothAdapter;
    }

    public static boolean bFD() {
        AppMethodBeat.i(144659);
        if (d.oE(18) || !bFF()) {
            AppMethodBeat.o(144659);
            return false;
        }
        AppMethodBeat.o(144659);
        return true;
    }

    public static boolean ZG(String str) {
        AppMethodBeat.i(144660);
        if (b.checkSelfPermission(MMApplicationContext.getContext(), str) == 0) {
            AppMethodBeat.o(144660);
            return true;
        }
        AppMethodBeat.o(144660);
        return false;
    }

    public static boolean bFE() {
        AppMethodBeat.i(144661);
        if (bFC() == null) {
            AppMethodBeat.o(144661);
            return false;
        }
        boolean isEnabled = bFC().isEnabled();
        AppMethodBeat.o(144661);
        return isEnabled;
    }

    private static boolean bFF() {
        AppMethodBeat.i(144662);
        boolean hasSystemFeature = MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        AppMethodBeat.o(144662);
        return hasSystemFeature;
    }

    public static boolean wU(int i2) {
        if ((i2 & 2) > 0) {
            return true;
        }
        return false;
    }

    public static boolean wV(int i2) {
        if ((i2 & 8) > 0) {
            return true;
        }
        return false;
    }

    public static boolean wW(int i2) {
        if ((i2 & 4) > 0) {
            return true;
        }
        return false;
    }

    public static boolean wX(int i2) {
        if ((i2 & 16) > 0) {
            return true;
        }
        return false;
    }

    public static boolean wY(int i2) {
        if ((i2 & 32) > 0) {
            return true;
        }
        return false;
    }

    public static boolean ZH(String str) {
        AppMethodBeat.i(144663);
        try {
            UUID.fromString(str);
            AppMethodBeat.o(144663);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(144663);
            return false;
        }
    }

    public static byte[] aK(byte[] bArr) {
        AppMethodBeat.i(183548);
        if (bArr == null || bArr.length == 0) {
            a.e("MicroMsg.Ble.BleHelper", "data is null", new Object[0]);
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(183548);
            return bArr2;
        }
        AppMethodBeat.o(183548);
        return bArr;
    }

    @TargetApi(18)
    public static boolean a(BluetoothGatt bluetoothGatt) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(144665);
        if (bluetoothGatt != null) {
            try {
                Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    z = ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                    z2 = z;
                    AppMethodBeat.o(144665);
                    return z2;
                }
            } catch (Exception e2) {
            }
        }
        z = false;
        z2 = z;
        AppMethodBeat.o(144665);
        return z2;
    }
}
