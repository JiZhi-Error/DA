package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.UUID;

@TargetApi(18)
public final class d extends a {
    private final boolean enable;
    private final String lMR;
    private final String lko;

    public d(String str, String str2, boolean z) {
        this.lko = str;
        this.lMR = str2;
        this.enable = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final void bFt() {
        AppMethodBeat.i(144576);
        BluetoothGatt bluetoothGatt = this.lNb.lMG;
        if (bluetoothGatt == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            a(j.lNC);
            done();
            AppMethodBeat.o(144576);
            return;
        }
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(this.lko));
        if (service == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
            a(j.lNA);
            done();
            AppMethodBeat.o(144576);
        } else if (!c.ZH(this.lMR)) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
            a(j.lNB);
            done();
            AppMethodBeat.o(144576);
        } else {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(this.lMR));
            if (characteristic == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", this);
                a(j.lNB);
                done();
                AppMethodBeat.o(144576);
            } else if (!c.wY(characteristic.getProperties())) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support indicate", this);
                a(j.lND);
                done();
                AppMethodBeat.o(144576);
            } else if (!bluetoothGatt.setCharacteristicNotification(characteristic, this.enable)) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.setCharacteristicNotification fail", this);
                a(j.lNE);
                done();
                AppMethodBeat.o(144576);
            } else {
                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b.a.lNa);
                if (descriptor == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattCharacteristic.getDescriptor fail", this);
                    a(j.lNG);
                    done();
                    AppMethodBeat.o(144576);
                    return;
                }
                if (!descriptor.setValue(this.enable ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattDescriptor.setValue fail", this);
                    a(j.lNH);
                    done();
                    AppMethodBeat.o(144576);
                } else if (!bluetoothGatt.writeDescriptor(descriptor)) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeDescriptor fail", this);
                    a(j.lNI);
                    done();
                    AppMethodBeat.o(144576);
                } else {
                    a(j.lNu);
                    AppMethodBeat.o(144576);
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
        AppMethodBeat.i(144577);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onDescriptorWrite status:%s", this, f.wR(i2));
        done();
        AppMethodBeat.o(144577);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final String getName() {
        return "IndicateCharacteristicAction";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final String toString() {
        AppMethodBeat.i(144578);
        String str = "IndicateCharacteristicAction#" + this.lNi + "{serviceId='" + this.lko + '\'' + ", characteristicId='" + this.lMR + '\'' + ", enable=" + this.enable + ", debug=" + this.aXs + ", mainThread=" + this.lMh + ", serial=" + this.lMj + '}';
        AppMethodBeat.o(144578);
        return str;
    }
}
