package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "deviceId", "", "pin", "", "timeoutMs", "", "forcePair", "", "useOldImpl", "(Ljava/lang/String;[BJZZ)V", "myTag", "pairReceiver", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "doActionImpl", "", "getName", "onDone", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "PairReceiver", "luggage-commons-jsapi-connectivity-ext_release"})
public final class f extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a {
    private final String dGL;
    final String lMQ = ("MicroMsg.AppBrand.PairAction#" + hashCode());
    private a lMS;
    final byte[] lMT;
    private final boolean lMU;
    final boolean lMV;

    public f(String str, byte[] bArr, long j2, boolean z, boolean z2) {
        p.h(str, "deviceId");
        AppMethodBeat.i(215132);
        this.dGL = str;
        this.lMT = bArr;
        this.lMU = z;
        this.lMV = z2;
        this.lNf = j2;
        AppMethodBeat.o(215132);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final String getName() {
        return "PairAction";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final void bFt() {
        Set<BluetoothDevice> bondedDevices;
        AppMethodBeat.i(215130);
        if (!c.bFE()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "Bluetooth is not enable.", new Object[0]);
            a(j.lNx);
            done();
            AppMethodBeat.o(215130);
        } else if (!BluetoothAdapter.checkBluetoothAddress(this.dGL)) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "Invalid deviceId", new Object[0]);
            a(j.lNL);
            done();
            AppMethodBeat.o(215130);
        } else {
            BluetoothAdapter bFC = c.bFC();
            if (bFC == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "Bluetooth is not enable.", new Object[0]);
                a(j.lNx);
                done();
                AppMethodBeat.o(215130);
                return;
            }
            BluetoothDevice remoteDevice = bFC.getRemoteDevice(this.dGL);
            if (this.lMU || (bondedDevices = bFC.getBondedDevices()) == null || true != bondedDevices.contains(remoteDevice)) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMQ, "createBond", new Object[0]);
                if (!remoteDevice.createBond()) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "startPairing is false", new Object[0]);
                    a(j.lNE);
                    done();
                    AppMethodBeat.o(215130);
                    return;
                }
                d dVar = this.lNb;
                p.g(dVar, "worker");
                Context context = dVar.getContext();
                if (context == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMQ, "context is null", new Object[0]);
                    a(j.lNE);
                    done();
                    AppMethodBeat.o(215130);
                    return;
                }
                p.g(remoteDevice, "device");
                this.lMS = new a(this, context, remoteDevice);
                a aVar = this.lMS;
                if (aVar != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(aVar.lMW.lMQ, "pairReceiver.registerSelf", new Object[0]);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
                    intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
                    aVar.context.registerReceiver(aVar, intentFilter);
                    AppMethodBeat.o(215130);
                    return;
                }
                AppMethodBeat.o(215130);
                return;
            }
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMQ, "already paired", new Object[0]);
            a(j.lNu);
            done();
            AppMethodBeat.o(215130);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
    public final void b(j jVar) {
        AppMethodBeat.i(215131);
        super.b(jVar);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMQ, "onDone, result: ".concat(String.valueOf(jVar)), new Object[0]);
        a aVar = this.lMS;
        if (aVar != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(aVar.lMW.lMQ, "pairReceiver.unregisterSelf", new Object[0]);
            aVar.context.unregisterReceiver(aVar);
        }
        this.lMS = null;
        AppMethodBeat.o(215131);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "device", "Landroid/bluetooth/BluetoothDevice;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "onReceive", "", "intent", "Landroid/content/Intent;", "registerSelf", "unregisterSelf", "luggage-commons-jsapi-connectivity-ext_release"})
    final class a extends BroadcastReceiver {
        final Context context;
        private final BluetoothDevice lLD;
        final /* synthetic */ f lMW;

        public a(f fVar, Context context2, BluetoothDevice bluetoothDevice) {
            p.h(context2, "context");
            p.h(bluetoothDevice, "device");
            this.lMW = fVar;
            AppMethodBeat.i(215129);
            this.context = context2;
            this.lLD = bluetoothDevice;
            AppMethodBeat.o(215129);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void onReceive(Context context2, Intent intent) {
            AppMethodBeat.i(215128);
            if (!p.j(this.lLD, intent != null ? intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE") : null)) {
                AppMethodBeat.o(215128);
                return;
            }
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMW.lMQ, "onReceive, intent: ".concat(String.valueOf(intent)), new Object[0]);
            if (!p.j("android.bluetooth.device.action.PAIRING_REQUEST", intent.getAction())) {
                if (p.j("android.bluetooth.device.action.BOND_STATE_CHANGED", intent.getAction())) {
                    if (intent.hasExtra("android.bluetooth.device.extra.BOND_STATE")) {
                        switch (intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) {
                            case 10:
                                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMW.lMQ, "BOND_NONE, reason: " + intent.getIntExtra("android.bluetooth.device.extra.REASON", -1), new Object[0]);
                                this.lMW.a(j.lNv);
                                this.lMW.done();
                                AppMethodBeat.o(215128);
                                return;
                            case 11:
                                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMW.lMQ, "BOND_BONDING", new Object[0]);
                                AppMethodBeat.o(215128);
                                return;
                            case 12:
                                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMW.lMQ, "BOND_BONDED", new Object[0]);
                                this.lMW.a(j.lNu);
                                this.lMW.done();
                                break;
                        }
                    } else {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMW.lMQ, "Cannot find EXTRA_BOND_STATE", new Object[0]);
                        AppMethodBeat.o(215128);
                        return;
                    }
                }
            } else if (!intent.hasExtra("android.bluetooth.device.extra.PAIRING_VARIANT")) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.lMW.lMQ, "Cannot find EXTRA_PAIRING_VARIANT", new Object[0]);
                AppMethodBeat.o(215128);
                return;
            } else {
                switch (intent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", -1)) {
                    case 0:
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMW.lMQ, "PAIRING_VARIANT_PIN", new Object[0]);
                        if (this.lMW.lMT == null) {
                            this.lMW.a(j.lNN);
                            this.lMW.done();
                            AppMethodBeat.o(215128);
                            return;
                        }
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMW.lMQ, "setPin", new Object[0]);
                        if (this.lLD.setPin(this.lMW.lMT) && !this.lMW.lMV) {
                            this.lMW.a(j.lNu);
                            this.lMW.done();
                            AppMethodBeat.o(215128);
                            return;
                        }
                    case 1:
                    default:
                        AppMethodBeat.o(215128);
                        return;
                    case 2:
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.lMW.lMQ, "PAIRING_VARIANT_PASSKEY_CONFIRMATION", new Object[0]);
                        AppMethodBeat.o(215128);
                        return;
                }
            }
            AppMethodBeat.o(215128);
        }
    }
}
