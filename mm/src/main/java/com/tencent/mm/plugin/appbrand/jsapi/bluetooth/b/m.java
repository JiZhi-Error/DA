package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PendingRespStructure;", "", "device", "Landroid/bluetooth/BluetoothDevice;", "requestId", "", "offset", "(Landroid/bluetooth/BluetoothDevice;II)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getOffset", "()I", "getRequestId", "luggage-commons-jsapi-connectivity-ext_release"})
public final class m {
    final BluetoothDevice lLD;
    final int offset;
    final int requestId;

    public m(BluetoothDevice bluetoothDevice, int i2, int i3) {
        p.h(bluetoothDevice, "device");
        AppMethodBeat.i(144772);
        this.lLD = bluetoothDevice;
        this.requestId = i2;
        this.offset = i3;
        AppMethodBeat.o(144772);
    }
}
