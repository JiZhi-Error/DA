package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.UUID;

@TargetApi(18)
public final class g extends a {
    private final String lMR;
    private final String lko;

    public g(String str, String str2) {
        this.lko = str;
        this.lMR = str2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final void bFt() {
        AppMethodBeat.i(144582);
        BluetoothGatt bluetoothGatt = this.lNb.lMG;
        if (bluetoothGatt == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            a(j.lNC);
            done();
            AppMethodBeat.o(144582);
        } else if (!c.ZH(this.lko)) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", this);
            a(j.lNA);
            done();
            AppMethodBeat.o(144582);
        } else {
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(this.lko));
            if (service == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
                a(j.lNA);
                done();
                AppMethodBeat.o(144582);
            } else if (!c.ZH(this.lMR)) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
                a(j.lNB);
                done();
                AppMethodBeat.o(144582);
            } else {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(this.lMR));
                if (characteristic == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", this);
                    a(j.lNB);
                    done();
                    AppMethodBeat.o(144582);
                } else if (!c.wU(characteristic.getProperties())) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support read", this);
                    a(j.lND);
                    done();
                    AppMethodBeat.o(144582);
                } else if (!bluetoothGatt.readCharacteristic(characteristic)) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.readCharacteristic fail", this);
                    a(j.lNE);
                    done();
                    AppMethodBeat.o(144582);
                } else {
                    a(j.lNu);
                    AppMethodBeat.o(144582);
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
        AppMethodBeat.i(144583);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicRead status:%s", this, f.wR(i2));
        done();
        AppMethodBeat.o(144583);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final String getName() {
        return "ReadCharacteristicAction";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final String toString() {
        AppMethodBeat.i(144584);
        String str = "ReadCharacteristicAction#" + this.lNi + "{serviceId='" + this.lko + '\'' + ", characteristicId='" + this.lMR + '\'' + ", debug=" + this.aXs + ", mainThread=" + this.lMh + ", serial=" + this.lMj + '}';
        AppMethodBeat.o(144584);
        return str;
    }
}
