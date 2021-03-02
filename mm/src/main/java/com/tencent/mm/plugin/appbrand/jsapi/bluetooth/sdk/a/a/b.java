package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.sdk.platformtools.ErrorCode;

@TargetApi(18)
public final class b extends a {
    public String dGL;
    public boolean lMK;
    public String lML = "LE";
    public long lMM = 0;
    public String lMN = null;

    public b(String str) {
        this.dGL = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final void bFt() {
        BluetoothGatt connectGatt;
        boolean z = false;
        AppMethodBeat.i(144571);
        BluetoothAdapter bFC = c.bFC();
        if (bFC == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "action:%s, bluetoothGatt is null", this);
            a(j.lNC);
            done();
            AppMethodBeat.o(144571);
        } else if (this.dGL == null || !BluetoothAdapter.checkBluetoothAddress(this.dGL)) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "action:%s, unspecified deviceId", this);
            a(j.lNL);
            done();
            AppMethodBeat.o(144571);
        } else if (!c.bFE()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "bluetooth is not enable.", new Object[0]);
            a(j.lNx);
            done();
            AppMethodBeat.o(144571);
        } else if (this.lNb.lMG != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "already connect, please close", new Object[0]);
            a(j.lNK);
            done();
            AppMethodBeat.o(144571);
        } else {
            BluetoothDevice remoteDevice = bFC.getRemoteDevice(this.dGL);
            if (remoteDevice != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "autoConnect:%b transport:%s", Boolean.valueOf(this.lMK), this.lML);
                if (Build.VERSION.SDK_INT >= 23) {
                    String upperCase = this.lML.toUpperCase();
                    char c2 = 65535;
                    switch (upperCase.hashCode()) {
                        case 2425:
                            if (upperCase.equals("LE")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 2020783:
                            if (upperCase.equals("AUTO")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 63463747:
                            if (upperCase.equals("BREDR")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            connectGatt = remoteDevice.connectGatt(this.lNb.context, this.lMK, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.lNb), 2);
                            break;
                        case 1:
                            connectGatt = remoteDevice.connectGatt(this.lNb.context, this.lMK, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.lNb), 0);
                            break;
                        case 2:
                            connectGatt = remoteDevice.connectGatt(this.lNb.context, this.lMK, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.lNb), 1);
                            break;
                        default:
                            connectGatt = remoteDevice.connectGatt(this.lNb.context, this.lMK, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.lNb), 2);
                            break;
                    }
                } else {
                    connectGatt = remoteDevice.connectGatt(this.lNb.context, this.lMK, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(this.lNb));
                }
                if (connectGatt != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "mBluetoothGatt:%s", connectGatt);
                    Object[] objArr = new Object[2];
                    objArr[0] = this.dGL;
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        z = true;
                    }
                    objArr[1] = Boolean.valueOf(z);
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "create a new connection deviceId=%s mainthread:%b", objArr);
                    this.lNb.lMG = connectGatt;
                    AppMethodBeat.o(144571);
                    return;
                }
                Object[] objArr2 = new Object[2];
                objArr2[0] = this.dGL;
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    z = true;
                }
                objArr2[1] = Boolean.valueOf(z);
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "Get Gatt fail!, deviceId=%s mainthread:%b", objArr2);
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "Device not found, deviceId=%s", this.dGL);
            }
            a(j.lNv);
            done();
            AppMethodBeat.o(144571);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final String getName() {
        return "ConnectAction";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final void b(j jVar) {
        AppMethodBeat.i(144572);
        switch (jVar.errCode) {
            case 10012:
                this.lNb.hq(false);
                break;
        }
        AppMethodBeat.o(144572);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onConnectionStateChange(final BluetoothGatt bluetoothGatt, final int i2, int i3) {
        AppMethodBeat.i(144573);
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.toString() : "";
        objArr[1] = f.wR(i2);
        objArr[2] = i3 == 2 ? "CONNECTED" : "DISCONNECTED";
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange]gatt:%s gattStatus:%s, newState:%s", objArr);
        this.lNb.lMG = bluetoothGatt;
        if (i3 != 2) {
            if (i3 == 0) {
                this.aDv.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(183547);
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "close", new Object[0]);
                        b.this.lNb.hq(false);
                        b bVar = b.this;
                        int i2 = i2;
                        bVar.a(new j((int) ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, "fail:connection fail" + " " + "status:" + i2));
                        b.this.done();
                        AppMethodBeat.o(183547);
                    }
                });
            }
            AppMethodBeat.o(144573);
        } else if (bluetoothGatt == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange] gatt is null", new Object[0]);
            AppMethodBeat.o(144573);
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange] discoverServicesDelayMills: " + this.lMM, new Object[0]);
            this.aDv.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b.AnonymousClass1 */

                /* JADX WARNING: Removed duplicated region for block: B:7:0x001f  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 166
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b.AnonymousClass1.run():void");
                }
            }, this.lMM);
            AppMethodBeat.o(144573);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
        AppMethodBeat.i(144574);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onServicesDiscovered] status:%s", f.wR(i2));
        this.lNb.lMG = bluetoothGatt;
        if (i2 == 0) {
            a(j.lNu);
        } else {
            a(j.lNM);
        }
        done();
        AppMethodBeat.o(144574);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final String toString() {
        AppMethodBeat.i(144575);
        String str = "ConnectAction#" + this.lNi + "{deviceId='" + this.dGL + '\'' + ", debug=" + this.aXs + ", mainThread=" + this.lMh + ", serial=" + this.lMj + '}';
        AppMethodBeat.o(144575);
        return str;
    }
}
