package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\"\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/GetBLEDeviceRSSIAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "()V", "myTag", "", "doActionImpl", "", "getName", "onReadRemoteRssi", "gatt", "Landroid/bluetooth/BluetoothGatt;", "rssi", "", "status", "luggage-commons-jsapi-connectivity-ext_release"})
public final class c extends a {
    private final String lMQ = ("MicroMsg.AppBrand.GetBLEDeviceRSSIAction#" + hashCode());

    public c() {
        AppMethodBeat.i(183550);
        AppMethodBeat.o(183550);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final String getName() {
        return "GetBLEDeviceRSSIAction";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final void bFt() {
        AppMethodBeat.i(175636);
        if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "Bluetooth is not enable.", new Object[0]);
            a(j.lNx);
            done();
            AppMethodBeat.o(175636);
            return;
        }
        d dVar = this.lNb;
        p.g(dVar, "worker");
        BluetoothGatt bFr = dVar.bFr();
        if (bFr == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "bluetoothGatt is null", new Object[0]);
            a(j.lNC);
            done();
            AppMethodBeat.o(175636);
            return;
        }
        if (!bFr.readRemoteRssi()) {
            a(j.lNE);
            done();
        }
        AppMethodBeat.o(175636);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i2, int i3) {
        AppMethodBeat.i(175637);
        super.onReadRemoteRssi(bluetoothGatt, i2, i3);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMQ, "onReadRemoteRssi, rssi: %d, status: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != 0) {
            a(j.lNv);
            done();
            AppMethodBeat.o(175637);
            return;
        }
        d dVar = this.lNb;
        p.g(dVar, "worker");
        if (!p.j(dVar.bFr(), bluetoothGatt)) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "bluetoothGatt is not match", new Object[0]);
            a(j.lNv);
            done();
            AppMethodBeat.o(175637);
            return;
        }
        a(j.cF(Integer.valueOf(i2)));
        done();
        AppMethodBeat.o(175637);
    }
}
