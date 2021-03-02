package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J*\u0010\u0017\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J@\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0016J \u0010\"\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0016J*\u0010%\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010&\u001a\u00020'H\u0016JB\u0010(\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010)\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\nH\u0016J\u001a\u0010*\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "Landroid/bluetooth/BluetoothGattServerCallback;", "()V", "bluetoothDevices", "Ljava/util/HashSet;", "Landroid/bluetooth/BluetoothDevice;", "getBluetoothDevices", "()Ljava/util/HashSet;", "pendingWriteReqList", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PendingRespStructure;", "getPendingWriteReqList", "()Ljava/util/Map;", "server", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "getServer", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "setServer", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;)V", "deviceNotExist", "", "device", "onCharacteristicReadRequest", "", "requestId", "offset", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicWriteRequest", "preparedWrite", "responseNeeded", "value", "", "onConnectionStateChange", "status", "newState", "onDescriptorReadRequest", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWriteRequest", "onNotificationSent", "onServiceAdded", "service", "Landroid/bluetooth/BluetoothGattService;", "Companion", "luggage-commons-jsapi-connectivity-ext_release"})
public final class b extends BluetoothGattServerCallback {
    public static final a lLm = new a((byte) 0);
    final HashSet<BluetoothDevice> lLj = new HashSet<>();
    final Map<Integer, m> lLk = new ConcurrentHashMap();
    public n lLl;

    static {
        AppMethodBeat.i(144747);
        AppMethodBeat.o(144747);
    }

    public b() {
        AppMethodBeat.i(144746);
        AppMethodBeat.o(144746);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-connectivity-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onDescriptorReadRequest(BluetoothDevice bluetoothDevice, int i2, int i3, BluetoothGattDescriptor bluetoothGattDescriptor) {
        AppMethodBeat.i(144738);
        p.h(bluetoothGattDescriptor, "descriptor");
        super.onDescriptorReadRequest(bluetoothDevice, i2, i3, bluetoothGattDescriptor);
        Log.i("MicroMsg.BLE.GattServerCallbackImpl", "Device tried to read descriptor: " + bluetoothGattDescriptor.getUuid());
        Log.i("MicroMsg.BLE.GattServerCallbackImpl", "Value: " + Arrays.toString(bluetoothGattDescriptor.getValue()));
        if (i3 != 0) {
            n nVar = this.lLl;
            if (nVar == null) {
                p.btv("server");
            }
            nVar.bFi().sendResponse(bluetoothDevice, i2, 7, i3, null);
            AppMethodBeat.o(144738);
            return;
        }
        n nVar2 = this.lLl;
        if (nVar2 == null) {
            p.btv("server");
        }
        nVar2.bFi().sendResponse(bluetoothDevice, i2, 0, i3, bluetoothGattDescriptor.getValue());
        AppMethodBeat.o(144738);
    }

    public final void onNotificationSent(BluetoothDevice bluetoothDevice, int i2) {
        AppMethodBeat.i(144739);
        super.onNotificationSent(bluetoothDevice, i2);
        Log.v("MicroMsg.BLE.GattServerCallbackImpl", "Notification sent. Status: ".concat(String.valueOf(i2)));
        AppMethodBeat.o(144739);
    }

    public final void onServiceAdded(int i2, BluetoothGattService bluetoothGattService) {
        A a2;
        B b2;
        AppMethodBeat.i(144740);
        super.onServiceAdded(i2, bluetoothGattService);
        if (bluetoothGattService == null) {
            AppMethodBeat.o(144740);
            return;
        }
        Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onServiceAdded: " + bluetoothGattService.getUuid());
        n nVar = this.lLl;
        if (nVar == null) {
            p.btv("server");
        }
        o<kotlin.g.a.b<Boolean, x>, Timer> oVar = nVar.lLG.get(bluetoothGattService.getUuid());
        if (!(oVar == null || (b2 = oVar.second) == null)) {
            b2.cancel();
        }
        n nVar2 = this.lLl;
        if (nVar2 == null) {
            p.btv("server");
        }
        o<kotlin.g.a.b<Boolean, x>, Timer> oVar2 = nVar2.lLG.get(bluetoothGattService.getUuid());
        if (!(oVar2 == null || (a2 = oVar2.first) == null)) {
            a2.invoke(Boolean.TRUE);
        }
        n nVar3 = this.lLl;
        if (nVar3 == null) {
            p.btv("server");
        }
        nVar3.lLG.remove(bluetoothGattService.getUuid());
        AppMethodBeat.o(144740);
    }

    public final void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i3, byte[] bArr) {
        int bFA;
        AppMethodBeat.i(144741);
        p.h(bluetoothDevice, "device");
        p.h(bluetoothGattCharacteristic, "characteristic");
        p.h(bArr, "value");
        super.onCharacteristicWriteRequest(bluetoothDevice, i2, bluetoothGattCharacteristic, z, z2, i3, bArr);
        StringBuilder sb = new StringBuilder("Characteristic Write request: ");
        String arrays = Arrays.toString(bArr);
        p.g(arrays, "java.util.Arrays.toString(this)");
        Log.v("MicroMsg.BLE.GattServerCallbackImpl", sb.append(arrays).toString());
        if (a(bluetoothDevice)) {
            AppMethodBeat.o(144741);
        } else if (i3 != 0) {
            n nVar = this.lLl;
            if (nVar == null) {
                p.btv("server");
            }
            nVar.bFi().sendResponse(bluetoothDevice, i2, 7, i3, bluetoothGattCharacteristic.getValue());
            AppMethodBeat.o(144741);
        } else {
            do {
                bFA = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bFA();
            } while (this.lLk.containsKey(Integer.valueOf(bFA)));
            Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: callbackId = %d", Integer.valueOf(bFA));
            byte[] encode = Base64.encode(bArr, 2);
            n nVar2 = this.lLl;
            if (nVar2 == null) {
                p.btv("server");
            }
            f NN = nVar2.NN();
            n nVar3 = this.lLl;
            if (nVar3 == null) {
                p.btv("server");
            }
            int i4 = nVar3.ktp;
            BluetoothGattService service = bluetoothGattCharacteristic.getService();
            p.g(service, "characteristic.service");
            String uuid = service.getUuid().toString();
            p.g(uuid, "characteristic.service.uuid.toString()");
            String uuid2 = bluetoothGattCharacteristic.getUuid().toString();
            p.g(uuid2, "characteristic.uuid.toString()");
            p.g(encode, "base64Value");
            if (a.a(NN, i4, uuid, uuid2, bFA, new String(encode, d.UTF_8))) {
                m mVar = new m(bluetoothDevice, i2, i3);
                Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: pendingWriteReqList res = " + this.lLk.put(Integer.valueOf(bFA), mVar) + ", id = " + bFA);
            }
            AppMethodBeat.o(144741);
        }
    }

    public final void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i2, int i3, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        int bFA;
        AppMethodBeat.i(144742);
        p.h(bluetoothGattCharacteristic, "characteristic");
        super.onCharacteristicReadRequest(bluetoothDevice, i2, i3, bluetoothGattCharacteristic);
        Log.i("MicroMsg.BLE.GattServerCallbackImpl", "Device tried to read characteristic: " + bluetoothGattCharacteristic.getUuid());
        Log.i("MicroMsg.BLE.GattServerCallbackImpl", "Value: " + Arrays.toString(bluetoothGattCharacteristic.getValue()));
        if (a(bluetoothDevice)) {
            AppMethodBeat.o(144742);
        } else if (i3 != 0) {
            n nVar = this.lLl;
            if (nVar == null) {
                p.btv("server");
            }
            nVar.bFi().sendResponse(bluetoothDevice, i2, 7, i3, bluetoothGattCharacteristic.getValue());
            AppMethodBeat.o(144742);
        } else {
            do {
                bFA = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bFA();
            } while (this.lLk.containsKey(Integer.valueOf(bFA)));
            Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: callbackId = %d", Integer.valueOf(bFA));
            n nVar2 = this.lLl;
            if (nVar2 == null) {
                p.btv("server");
            }
            f NN = nVar2.NN();
            n nVar3 = this.lLl;
            if (nVar3 == null) {
                p.btv("server");
            }
            int i4 = nVar3.ktp;
            BluetoothGattService service = bluetoothGattCharacteristic.getService();
            p.g(service, "characteristic.service");
            String uuid = service.getUuid().toString();
            p.g(uuid, "characteristic.service.uuid.toString()");
            String uuid2 = bluetoothGattCharacteristic.getUuid().toString();
            p.g(uuid2, "characteristic.uuid.toString()");
            if (a.a(NN, i4, uuid, uuid2, bFA)) {
                if (bluetoothDevice == null) {
                    p.hyc();
                }
                m mVar = new m(bluetoothDevice, i2, i3);
                Log.i("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: pendingWriteReqList ret = " + this.lLk.put(Integer.valueOf(bFA), mVar) + " id = " + bFA);
            }
            AppMethodBeat.o(144742);
        }
    }

    private final boolean a(BluetoothDevice bluetoothDevice) {
        AppMethodBeat.i(144743);
        if (bluetoothDevice == null) {
            Log.i("MicroMsg.BLE.GattServerCallbackImpl", "deviceNotExist: device == null");
            AppMethodBeat.o(144743);
            return true;
        }
        HashSet<BluetoothDevice> hashSet = this.lLj;
        ArrayList arrayList = new ArrayList(j.a(hashSet, 10));
        Iterator<T> it = hashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAddress());
        }
        if (!arrayList.contains(bluetoothDevice.getAddress())) {
            Log.i("MicroMsg.BLE.GattServerCallbackImpl", "deviceNotExist: is not contain device");
            AppMethodBeat.o(144743);
            return true;
        }
        AppMethodBeat.o(144743);
        return false;
    }

    public final void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i2, int i3) {
        AppMethodBeat.i(144744);
        p.h(bluetoothDevice, "device");
        super.onConnectionStateChange(bluetoothDevice, i2, i3);
        if (i2 != 0) {
            this.lLj.remove(bluetoothDevice);
            Log.e("MicroMsg.BLE.GattServerCallbackImpl", "Error when connecting: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(144744);
        } else if (i3 == 2) {
            this.lLj.add(bluetoothDevice);
            n nVar = this.lLl;
            if (nVar == null) {
                p.btv("server");
            }
            f NN = nVar.NN();
            String address = bluetoothDevice.getAddress();
            p.g(address, "device.address");
            n nVar2 = this.lLl;
            if (nVar2 == null) {
                p.btv("server");
            }
            a.a(NN, address, String.valueOf(nVar2.ktp), true);
            n nVar3 = this.lLl;
            if (nVar3 == null) {
                p.btv("server");
            }
            nVar3.a(p.CONNECTED);
            Log.v("MicroMsg.BLE.GattServerCallbackImpl", "Connected to device: " + bluetoothDevice.getAddress());
            AppMethodBeat.o(144744);
        } else {
            if (i3 == 0) {
                this.lLj.remove(bluetoothDevice);
                n nVar4 = this.lLl;
                if (nVar4 == null) {
                    p.btv("server");
                }
                f NN2 = nVar4.NN();
                String address2 = bluetoothDevice.getAddress();
                p.g(address2, "device.address");
                n nVar5 = this.lLl;
                if (nVar5 == null) {
                    p.btv("server");
                }
                a.a(NN2, address2, String.valueOf(nVar5.ktp), false);
                n nVar6 = this.lLl;
                if (nVar6 == null) {
                    p.btv("server");
                }
                nVar6.a(p.CREATED);
                Log.v("MicroMsg.BLE.GattServerCallbackImpl", "Disconnected from device");
            }
            AppMethodBeat.o(144744);
        }
    }

    public final void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i2, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i3, byte[] bArr) {
        AppMethodBeat.i(144745);
        p.h(bluetoothGattDescriptor, "descriptor");
        p.h(bArr, "value");
        super.onDescriptorWriteRequest(bluetoothDevice, i2, bluetoothGattDescriptor, z, z2, i3, bArr);
        Log.v("MicroMsg.BLE.GattServerCallbackImpl", "Descriptor Write Request " + bluetoothGattDescriptor.getUuid() + " " + Arrays.toString(bArr));
        if (z2) {
            n nVar = this.lLl;
            if (nVar == null) {
                p.btv("server");
            }
            nVar.bFi().sendResponse(bluetoothDevice, i2, 0, 0, null);
        }
        AppMethodBeat.o(144745);
    }
}
