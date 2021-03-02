package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J \u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/SetMtuAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "mtuSize", "", "deviceId", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "isTimeOut", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/Integer;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "doActionImpl", "", "getName", "onMtuChanged", "gatt", "Landroid/bluetooth/BluetoothGatt;", "mtu", "status", "luggage-commons-jsapi-connectivity-ext_release"})
public final class h extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a {
    private final String dGL;
    final AtomicBoolean lMX = new AtomicBoolean(false);
    private final Integer lMY;
    private final MTimerHandler timerHandler = new MTimerHandler(new a(this), false);

    public h(Integer num, String str) {
        AppMethodBeat.i(144794);
        this.lMY = num;
        this.dGL = str;
        AppMethodBeat.o(144794);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final String getName() {
        return "SetMtuAction";
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class a implements MTimerHandler.CallBack {
        final /* synthetic */ h lMZ;

        a(h hVar) {
            this.lMZ = hVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(144791);
            this.lMZ.lMX.set(true);
            this.lMZ.a(j.lNJ);
            AppMethodBeat.o(144791);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final void bFt() {
        AppMethodBeat.i(144792);
        if (c.bFC() == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            a(j.lNC);
            done();
            AppMethodBeat.o(144792);
        } else if (this.dGL == null || !BluetoothAdapter.checkBluetoothAddress(this.dGL) || this.lMY == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.Action", "action:%s, unspecified deviceId", this);
            a(j.lNL);
            done();
            AppMethodBeat.o(144792);
        } else if (!c.bFE()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "bluetooth is not enable.", new Object[0]);
            a(j.lNx);
            done();
            AppMethodBeat.o(144792);
        } else {
            d dVar = this.lNb;
            p.g(dVar, "worker");
            BluetoothGatt bFr = dVar.bFr();
            if (bFr == null) {
                a(j.lNC);
                done();
                AppMethodBeat.o(144792);
            } else if (this.lMY.intValue() > 512) {
                a(new j(10013, "fail:invalid data, DEFAULT_MAX_MTU = 512"));
                done();
                AppMethodBeat.o(144792);
            } else if (this.lMY.intValue() < 23) {
                a(new j(10013, "fail:invalid data, DEFAULT_MIN_MTU = 23"));
                done();
                AppMethodBeat.o(144792);
            } else if (!bFr.requestMtu(this.lMY.intValue())) {
                a(j.lNE);
                done();
                AppMethodBeat.o(144792);
            } else {
                this.timerHandler.startTimer(500, MAlarmHandler.NEXT_FIRE_INTERVAL);
                AppMethodBeat.o(144792);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i2, int i3) {
        AppMethodBeat.i(144793);
        p.h(bluetoothGatt, "gatt");
        super.onMtuChanged(bluetoothGatt, i2, i3);
        if (this.lMX.get()) {
            this.lMX.set(false);
            AppMethodBeat.o(144793);
            return;
        }
        Log.d("MicroMsg.Ble.Action", "onMtuChanged: mtu = %d, status = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        Integer num = this.lMY;
        if (num != null && i2 == num.intValue() && i3 == 0) {
            a(j.lNu);
            done();
            AppMethodBeat.o(144793);
            return;
        }
        a(j.lNv);
        done();
        AppMethodBeat.o(144793);
    }
}
