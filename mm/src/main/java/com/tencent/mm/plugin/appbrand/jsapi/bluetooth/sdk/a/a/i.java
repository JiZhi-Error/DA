package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.Arrays;
import java.util.UUID;

@TargetApi(18)
public final class i extends a {
    private final String lMR;
    private final String lko;
    private final String value;

    public i(String str, String str2, String str3) {
        this.lko = str;
        this.lMR = str2;
        this.value = str3;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final void bFt() {
        AppMethodBeat.i(144585);
        BluetoothGatt bluetoothGatt = this.lNb.lMG;
        if (bluetoothGatt == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            a(j.lNC);
            done();
            AppMethodBeat.o(144585);
        } else if (!c.ZH(this.lko)) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", this);
            a(j.lNA);
            done();
            AppMethodBeat.o(144585);
        } else {
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(this.lko));
            if (service == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
                a(j.lNA);
                done();
                AppMethodBeat.o(144585);
            } else if (!c.ZH(this.lMR)) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
                a(j.lNB);
                done();
                AppMethodBeat.o(144585);
            } else {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(this.lMR));
                if (characteristic == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", this);
                    a(j.lNB);
                    done();
                    AppMethodBeat.o(144585);
                } else if (c.wV(characteristic.getProperties()) || c.wW(characteristic.getProperties())) {
                    byte[] aK = c.aK(Base64.decode(this.value, 2));
                    characteristic.setValue(aK);
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(aK != null ? aK.length : 0);
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "dataToWrite's length:%d", objArr);
                    if (this.aXs) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "dataToWrite:%s", Arrays.toString(aK));
                    }
                    if (!bluetoothGatt.writeCharacteristic(characteristic)) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", this);
                        a(j.lNE);
                        done();
                        AppMethodBeat.o(144585);
                        return;
                    }
                    if (!c.wV(characteristic.getProperties()) && c.wW(characteristic.getProperties())) {
                        a(j.lNu);
                        done();
                    }
                    AppMethodBeat.o(144585);
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support write & writeNoResponse", this);
                    a(j.lND);
                    done();
                    AppMethodBeat.o(144585);
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
        AppMethodBeat.i(144586);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", this, f.wR(i2));
        if (i2 == 0) {
            a(j.lNu);
        }
        done();
        AppMethodBeat.o(144586);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final String getName() {
        return "WriteCharacteristicAction";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final String toString() {
        AppMethodBeat.i(144587);
        String str = "WriteCharacteristicAction#" + this.lNi + "{serviceId='" + this.lko + '\'' + ", characteristicId='" + this.lMR + '\'' + ", value='" + this.value + '\'' + ", debug=" + this.aXs + ", mainThread=" + this.lMh + ", serial=" + this.lMj + '}';
        AppMethodBeat.o(144587);
        return str;
    }
}
