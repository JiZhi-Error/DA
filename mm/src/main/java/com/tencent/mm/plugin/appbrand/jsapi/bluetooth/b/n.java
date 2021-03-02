package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 M2\u00020\u0001:\u0001MB\u0005¢\u0006\u0002\u0010\u0002J1\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u0002032!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0018J\b\u00105\u001a\u00020\u0019H\u0002J.\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020\u0019H\u0002J\b\u0010>\u001a\u00020\u001dH\u0002J\u0010\u0010?\u001a\u00020\u001d2\u0006\u00104\u001a\u00020#H\u0002J\u0016\u0010@\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\u0006\u0010A\u001a\u00020\u001dJ6\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020#J\u000e\u0010L\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020JR\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0013RH\u0010\u0014\u001a9\u0012\u0004\u0012\u00020\u0016\u0012/\u0012-\u0012#\u0012!\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0018j\u0002`\u001e\u0012\u0004\u0012\u00020\u001f0\u00170\u0015¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "", "()V", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "setComponent", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "gattServer", "Landroid/bluetooth/BluetoothGattServer;", "getGattServer", "()Landroid/bluetooth/BluetoothGattServer;", "setGattServer", "(Landroid/bluetooth/BluetoothGattServer;)V", "gattServerCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "isPostingAdvertising", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "jsCallbacks", "", "Ljava/util/UUID;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsCallback;", "Ljava/util/Timer;", "getJsCallbacks", "()Ljava/util/Map;", "realAdvertiseCallback", "Landroid/bluetooth/le/AdvertiseCallback;", "serverId", "", "getServerId", "()I", "setServerId", "(I)V", "status", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "getStatus", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "setStatus", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;)V", "userCallbackLock", "addService", "service", "Landroid/bluetooth/BluetoothGattService;", "callback", "checkBleIsWork", "handleCharacteristicWriteAction", "serviceId", "characteristicId", "needNotify", "callbackId", "base64Value", "", "isAdvertising", "offAdvertising", "onAdvertising", "onCreate", "onDestroy", "startBLEPeripheralAdvertising", "settings", "Landroid/bluetooth/le/AdvertiseSettings;", "advertiseData", "Landroid/bluetooth/le/AdvertiseData;", "scanResponse", "deviceName", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "userCallback", "stopBLEPeripheralAdvertising", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class n {
    public static final a lLL = new a((byte) 0);
    int ktp = -1;
    p lLE = p.INIT;
    public BluetoothGattServer lLF;
    final Map<UUID, o<kotlin.g.a.b<Boolean, x>, Timer>> lLG = new HashMap();
    private final AdvertiseCallback lLH = new c(this);
    AdvertiseCallback lLI;
    final AtomicBoolean lLJ = new AtomicBoolean(false);
    private b lLK;
    public f lqg;

    static {
        AppMethodBeat.i(144781);
        AppMethodBeat.o(144781);
    }

    public n() {
        AppMethodBeat.i(144780);
        AppMethodBeat.o(144780);
    }

    public static final /* synthetic */ boolean b(n nVar) {
        AppMethodBeat.i(215127);
        boolean bFj = nVar.bFj();
        AppMethodBeat.o(215127);
        return bFj;
    }

    public final void a(p pVar) {
        AppMethodBeat.i(144774);
        p.h(pVar, "<set-?>");
        this.lLE = pVar;
        AppMethodBeat.o(144774);
    }

    public final BluetoothGattServer bFi() {
        AppMethodBeat.i(144775);
        BluetoothGattServer bluetoothGattServer = this.lLF;
        if (bluetoothGattServer == null) {
            p.btv("gattServer");
        }
        AppMethodBeat.o(144775);
        return bluetoothGattServer;
    }

    public final f NN() {
        AppMethodBeat.i(144776);
        f fVar = this.lqg;
        if (fVar == null) {
            p.btv("component");
        }
        AppMethodBeat.o(144776);
        return fVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-connectivity-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void c(f fVar, int i2) {
        AppMethodBeat.i(144777);
        p.h(fVar, "component");
        BluetoothManager bFB = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFB();
        if ((!(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFD() & true & com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bFz()) || !com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE()) || bFB == null) {
            p pVar = p.TROUBLESOME;
            AppMethodBeat.o(144777);
            return;
        }
        this.lLE = p.CREATED;
        this.lqg = fVar;
        this.ktp = i2;
        this.lLK = new b();
        BluetoothGattServer openGattServer = bFB.openGattServer(MMApplicationContext.getContext(), this.lLK);
        p.g(openGattServer, "bluetoothManager.openGat…xt(), gattServerCallback)");
        this.lLF = openGattServer;
        b bVar = this.lLK;
        if (bVar == null) {
            p.hyc();
        }
        n nVar = this;
        p.h(nVar, "<set-?>");
        bVar.lLl = nVar;
        AppMethodBeat.o(144777);
    }

    public final void onDestroy() {
        Map<Integer, m> map;
        AppMethodBeat.i(144778);
        this.lLG.clear();
        BluetoothGattServer bluetoothGattServer = this.lLF;
        if (bluetoothGattServer == null) {
            p.btv("gattServer");
        }
        bluetoothGattServer.close();
        BluetoothAdapter bFC = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFC();
        if (bFC != null) {
            p.g(bFC, LocaleUtil.ITALIAN);
            a(bFC);
        }
        b bVar = this.lLK;
        if (!(bVar == null || (map = bVar.lLk) == null)) {
            map.clear();
        }
        this.lLK = null;
        this.lLE = p.DESTROYED;
        AppMethodBeat.o(144778);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer$realAdvertiseCallback$1", "Landroid/bluetooth/le/AdvertiseCallback;", "onStartFailure", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "luggage-commons-jsapi-connectivity-ext_release"})
    public static final class c extends AdvertiseCallback {
        final /* synthetic */ n lLM;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(n nVar) {
            this.lLM = nVar;
        }

        public final void onStartSuccess(AdvertiseSettings advertiseSettings) {
            AppMethodBeat.i(215124);
            super.onStartSuccess(advertiseSettings);
            if (n.b(this.lLM)) {
                AdvertiseCallback advertiseCallback = this.lLM.lLI;
                if (advertiseCallback == null) {
                    p.hyc();
                }
                advertiseCallback.onStartSuccess(advertiseSettings);
            }
            AppMethodBeat.o(215124);
        }

        public final void onStartFailure(int i2) {
            AppMethodBeat.i(215125);
            super.onStartFailure(i2);
            AdvertiseCallback advertiseCallback = this.lLM.lLI;
            if (advertiseCallback == null) {
                p.hyc();
            }
            advertiseCallback.onStartFailure(i2);
            this.lLM.lLI = null;
            AppMethodBeat.o(215125);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean bFj() {
        return this.lLI != null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ n lLM;
        final /* synthetic */ BluetoothAdapter lLN;
        final /* synthetic */ String lLO;
        final /* synthetic */ AdvertiseSettings lLP;
        final /* synthetic */ AdvertiseData lLQ;
        final /* synthetic */ AdvertiseData lLR;

        d(n nVar, BluetoothAdapter bluetoothAdapter, String str, AdvertiseSettings advertiseSettings, AdvertiseData advertiseData, AdvertiseData advertiseData2) {
            this.lLM = nVar;
            this.lLN = bluetoothAdapter;
            this.lLO = str;
            this.lLP = advertiseSettings;
            this.lLQ = advertiseData;
            this.lLR = advertiseData2;
        }

        public final void run() {
            AppMethodBeat.i(215126);
            if ((!kotlin.n.n.aL(this.lLO)) && (!p.j(this.lLN.getName(), this.lLO))) {
                if (!this.lLN.setName(this.lLO)) {
                    Log.w("MicroMsg.BLE.PeripheralBleServer", "set BLE adapter name fail, may under wrong state! [%d]", Integer.valueOf(this.lLN.getState()));
                }
                for (int i2 = 0; i2 <= 20; i2++) {
                    String name = this.lLN.getName();
                    Log.i("MicroMsg.BLE.PeripheralBleServer", "round [%d] sys = [%s], want = [%s]", Integer.valueOf(i2), name, this.lLO);
                    if (p.j(this.lLO, name)) {
                        break;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e2) {
                        InterruptedException interruptedException = e2;
                        AppMethodBeat.o(215126);
                        throw interruptedException;
                    }
                }
            }
            BluetoothLeAdvertiser bluetoothLeAdvertiser = this.lLN.getBluetoothLeAdvertiser();
            if (bluetoothLeAdvertiser != null) {
                bluetoothLeAdvertiser.startAdvertising(this.lLP, this.lLQ, this.lLR, this.lLM.lLH);
            }
            this.lLM.lLJ.set(false);
            AppMethodBeat.o(215126);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
    public static final class b extends TimerTask {
        final /* synthetic */ kotlin.g.a.b ipQ;

        public b(kotlin.g.a.b bVar) {
            this.ipQ = bVar;
        }

        public final void run() {
            AppMethodBeat.i(144773);
            this.ipQ.invoke(Boolean.FALSE);
            cancel();
            AppMethodBeat.o(144773);
        }
    }

    public final void a(BluetoothAdapter bluetoothAdapter) {
        AppMethodBeat.i(183549);
        p.h(bluetoothAdapter, "adapter");
        BluetoothLeAdvertiser bluetoothLeAdvertiser = bluetoothAdapter.getBluetoothLeAdvertiser();
        if (bluetoothLeAdvertiser == null) {
            AppMethodBeat.o(183549);
            return;
        }
        bluetoothLeAdvertiser.stopAdvertising(this.lLH);
        this.lLI = null;
        AppMethodBeat.o(183549);
    }

    public final void a(UUID uuid, UUID uuid2, boolean z, int i2, String str) {
        AppMethodBeat.i(144779);
        p.h(uuid, "serviceId");
        p.h(uuid2, "characteristicId");
        p.h(str, "base64Value");
        BluetoothGattServer bluetoothGattServer = this.lLF;
        if (bluetoothGattServer == null) {
            p.btv("gattServer");
        }
        BluetoothGattService service = bluetoothGattServer.getService(uuid);
        if (service == null) {
            Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: server == null");
            AppMethodBeat.o(144779);
            return;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
        if (characteristic == null) {
            Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: characteristic == null");
            AppMethodBeat.o(144779);
            return;
        }
        characteristic.setValue(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aK(Base64.decode(str, 2)));
        if (z) {
            b bVar = this.lLK;
            if (bVar == null) {
                p.hyc();
            }
            for (T t : bVar.lLj) {
                BluetoothGattServer bluetoothGattServer2 = this.lLF;
                if (bluetoothGattServer2 == null) {
                    p.btv("gattServer");
                }
                Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", String.valueOf(bluetoothGattServer2.notifyCharacteristicChanged(t, characteristic, false)));
            }
        } else {
            b bVar2 = this.lLK;
            if (bVar2 == null) {
                p.hyc();
            }
            for (T t2 : bVar2.lLj) {
                BluetoothGattServer bluetoothGattServer3 = this.lLF;
                if (bluetoothGattServer3 == null) {
                    p.btv("gattServer");
                }
                Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", String.valueOf(bluetoothGattServer3.notifyCharacteristicChanged(t2, characteristic, true)));
            }
        }
        b bVar3 = this.lLK;
        if (bVar3 == null) {
            p.hyc();
        }
        m mVar = bVar3.lLk.get(Integer.valueOf(i2));
        if (mVar == null) {
            Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: #" + i2 + " callbackId -> pendingResp is null");
            AppMethodBeat.o(144779);
            return;
        }
        Log.i("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: device = %s, requestId = %s", mVar.lLD.toString(), String.valueOf(mVar.requestId));
        BluetoothGattServer bluetoothGattServer4 = this.lLF;
        if (bluetoothGattServer4 == null) {
            p.btv("gattServer");
        }
        if (!bluetoothGattServer4.sendResponse(mVar.lLD, mVar.requestId, 0, mVar.offset, characteristic.getValue())) {
            Log.e("MicroMsg.BLE.PeripheralBleServer", "sendPendingRespFail");
        }
        b bVar4 = this.lLK;
        if (bVar4 == null) {
            p.hyc();
        }
        bVar4.lLk.remove(Integer.valueOf(i2));
        AppMethodBeat.o(144779);
    }
}
