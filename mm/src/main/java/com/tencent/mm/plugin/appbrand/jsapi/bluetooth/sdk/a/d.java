package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class d implements e {
    public final String cDW = ("MicroMsg.Ble.BleConnectWorker#" + hashCode());
    public final Context context;
    public String dGL;
    volatile h lMB;
    volatile g lMC;
    public volatile b lMF;
    public volatile BluetoothGatt lMG;
    private List<e> lMH;
    public volatile Map<String, List<c>> lMI;
    private final c lMJ;

    public d(Context context2, String str, c cVar) {
        AppMethodBeat.i(183544);
        this.context = context2;
        this.dGL = str;
        this.lMJ = cVar;
        AppMethodBeat.o(183544);
    }

    public final synchronized void init() {
        AppMethodBeat.i(215154);
        a.i(this.cDW, "init deviceId:%s", this.dGL);
        this.lMF = bFs();
        this.lMI = new ConcurrentHashMap();
        AppMethodBeat.o(215154);
    }

    public final synchronized void uninit() {
        AppMethodBeat.i(215155);
        a.i(this.cDW, "uninit deviceId:%s", this.dGL);
        hr(true);
        b bVar = this.lMF;
        if (bVar != null) {
            bVar.uninit();
            this.lMF = null;
        }
        if (this.lMH != null) {
            this.lMH.clear();
            this.lMH = null;
        }
        Map<String, List<c>> map = this.lMI;
        if (map != null) {
            map.clear();
            this.lMI = null;
        }
        AppMethodBeat.o(215155);
    }

    public final BluetoothGatt bFr() {
        return this.lMG;
    }

    private synchronized b bFs() {
        b bVar;
        AppMethodBeat.i(215156);
        bVar = this.lMF;
        if (bVar == null) {
            bVar = new b();
            bVar.init();
            this.lMF = bVar;
        }
        AppMethodBeat.o(215156);
        return bVar;
    }

    public final Context getContext() {
        return this.context;
    }

    public final synchronized void hq(boolean z) {
        AppMethodBeat.i(144558);
        a.i(this.cDW, "closeMyself deviceId:%s", this.dGL);
        hr(z);
        b bVar = this.lMF;
        if (bVar != null) {
            bVar.uninit();
            this.lMF = null;
        }
        if (this.lMH != null) {
            this.lMH.clear();
            this.lMH = null;
        }
        Map<String, List<c>> map = this.lMI;
        if (map != null) {
            map.clear();
            this.lMI = null;
        }
        c cVar = this.lMJ;
        String str = this.dGL;
        if (cVar.lMA == null) {
            a.w("MicroMsg.Ble.BleConnectMgr", "removeWorker, connectWorkers is null", new Object[0]);
            AppMethodBeat.o(144558);
        } else {
            cVar.lMA.remove(str);
            AppMethodBeat.o(144558);
        }
    }

    private synchronized void hr(boolean z) {
        AppMethodBeat.i(183545);
        BluetoothGatt bluetoothGatt = this.lMG;
        if (bluetoothGatt != null) {
            a.i(this.cDW, "deviceId:%s innerCloseMyself", this.dGL);
            if (z) {
                aq(this.dGL, false);
            }
            if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMo) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.a(this.lMG);
            }
            bluetoothGatt.close();
            this.lMG = null;
        }
        AppMethodBeat.o(183545);
    }

    public final synchronized List<e> getServices() {
        ArrayList arrayList = null;
        synchronized (this) {
            AppMethodBeat.i(175630);
            BluetoothGatt bluetoothGatt = this.lMG;
            if (bluetoothGatt == null) {
                a.e(this.cDW, "[getServices] bluetoothGatt is null, err", new Object[0]);
                AppMethodBeat.o(175630);
            } else if (Util.isNullOrNil(this.dGL)) {
                a.e(this.cDW, "[getServices] deviceId is null, err", new Object[0]);
                AppMethodBeat.o(175630);
            } else {
                if (this.lMH == null) {
                    List<BluetoothGattService> services = bluetoothGatt.getServices();
                    if (services == null) {
                        a.w(this.cDW, "[getServices] bluetoothGattServices is null, err", new Object[0]);
                        AppMethodBeat.o(175630);
                    } else {
                        this.lMH = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (BluetoothGattService bluetoothGattService : services) {
                            e eVar = new e();
                            eVar.uuid = bluetoothGattService.getUuid().toString().toUpperCase();
                            eVar.lNt = bluetoothGattService.getType() == 0;
                            if (eVar.uuid.equals("00001800-0000-1000-8000-00805F9B34FB") || eVar.uuid.equals("00001801-0000-1000-8000-00805F9B34FB")) {
                                arrayList2.add(eVar);
                            } else {
                                this.lMH.add(eVar);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            this.lMH.addAll(arrayList2);
                        }
                    }
                } else {
                    a.i(this.cDW, "[getServices] use cache", new Object[0]);
                }
                arrayList = new ArrayList(this.lMH);
                AppMethodBeat.o(175630);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
        AppMethodBeat.i(144559);
        String str = this.cDW;
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = f.wR(i2);
        objArr[2] = i3 == 2 ? "CONNECTED" : "DISCONNECTED";
        a.i(str, "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s", objArr);
        b bVar = this.lMF;
        if (bVar == null) {
            AppMethodBeat.o(144559);
            return;
        }
        bVar.onConnectionStateChange(bluetoothGatt, i2, i3);
        if (i2 != 0 || (i3 != 2 && i3 == 0)) {
            hq(true);
        }
        AppMethodBeat.o(144559);
    }

    private void aq(String str, boolean z) {
        AppMethodBeat.i(144560);
        h hVar = this.lMB;
        if (hVar == null) {
            a.w(this.cDW, "notifyConnectionStateChange, onBleConnectionStateChange is null", new Object[0]);
            AppMethodBeat.o(144560);
            return;
        }
        hVar.ap(str, z);
        AppMethodBeat.o(144560);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
        AppMethodBeat.i(144561);
        String str = this.cDW;
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = f.wR(i2);
        a.i(str, "[onServicesDiscovered]gatt deviceId:%s status:%s", objArr);
        b bVar = this.lMF;
        if (bVar == null) {
            AppMethodBeat.o(144561);
            return;
        }
        bVar.onServicesDiscovered(bluetoothGatt, i2);
        if (bluetoothGatt == null) {
            AppMethodBeat.o(144561);
            return;
        }
        if (i2 == 0) {
            aq(bluetoothGatt.getDevice().getAddress(), true);
        }
        AppMethodBeat.o(144561);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
        AppMethodBeat.i(144562);
        String str = this.cDW;
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        objArr[2] = f.wR(i2);
        a.i(str, "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s", objArr);
        b bVar = this.lMF;
        if (bVar == null) {
            AppMethodBeat.o(144562);
            return;
        }
        bVar.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i2);
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null) {
            AppMethodBeat.o(144562);
        } else if (i2 != 0) {
            AppMethodBeat.o(144562);
        } else {
            g gVar = this.lMC;
            if (gVar == null) {
                a.w(this.cDW, "[change] onBleCharacteristicValueChange is null", new Object[0]);
                AppMethodBeat.o(144562);
                return;
            }
            String str2 = new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2));
            String address = bluetoothGatt.getDevice().getAddress();
            String upperCase = bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
            String upperCase2 = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
            a.i(this.cDW, "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", address, upperCase, upperCase2, str2);
            gVar.g(address, upperCase, upperCase2, str2);
            AppMethodBeat.o(144562);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
        AppMethodBeat.i(144563);
        String str = this.cDW;
        Object[] objArr = new Object[4];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        objArr[2] = bluetoothGattCharacteristic != null ? Arrays.asList(bluetoothGattCharacteristic.getValue()) : "";
        objArr[3] = f.wR(i2);
        a.i(str, "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s", objArr);
        b bVar = this.lMF;
        if (bVar == null) {
            AppMethodBeat.o(144563);
            return;
        }
        bVar.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i2);
        AppMethodBeat.o(144563);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        AppMethodBeat.i(144564);
        String str = this.cDW;
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        a.i(str, "[onCharacteristicChanged]gatt deviceId:%s characteristicId:%s", objArr);
        b bVar = this.lMF;
        if (bVar == null) {
            AppMethodBeat.o(144564);
            return;
        }
        bVar.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null) {
            AppMethodBeat.o(144564);
            return;
        }
        g gVar = this.lMC;
        if (gVar == null) {
            a.w(this.cDW, "[change] onBleCharacteristicValueChange is null", new Object[0]);
            AppMethodBeat.o(144564);
            return;
        }
        String str2 = new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2));
        String address = bluetoothGatt.getDevice().getAddress();
        String upperCase = bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
        String upperCase2 = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        a.i(this.cDW, "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", address, upperCase, upperCase2, str2);
        gVar.g(address, upperCase, upperCase2, str2);
        AppMethodBeat.o(144564);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
        AppMethodBeat.i(144565);
        String str = this.cDW;
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getUuid().toString().toUpperCase() : "";
        a.i(str, "[onDescriptorRead]gatt deviceId:%s descriptorId:%s", objArr);
        b bVar = this.lMF;
        if (bVar == null) {
            AppMethodBeat.o(144565);
            return;
        }
        bVar.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i2);
        AppMethodBeat.o(144565);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
        AppMethodBeat.i(144566);
        String str = this.cDW;
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getUuid().toString().toUpperCase() : "";
        a.i(str, "[onDescriptorWrite]gatt deviceId:%s descriptorId:%s", objArr);
        b bVar = this.lMF;
        if (bVar == null) {
            AppMethodBeat.o(144566);
            return;
        }
        bVar.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i2);
        AppMethodBeat.o(144566);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i2) {
        AppMethodBeat.i(144567);
        String str = this.cDW;
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = f.wR(i2);
        a.i(str, "[onReliableWriteCompleted]gatt deviceId:%s status:%s", objArr);
        b bVar = this.lMF;
        if (bVar == null) {
            AppMethodBeat.o(144567);
            return;
        }
        bVar.onReliableWriteCompleted(bluetoothGatt, i2);
        AppMethodBeat.o(144567);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i2, int i3) {
        AppMethodBeat.i(144568);
        String str = this.cDW;
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = f.wR(i3);
        a.i(str, "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s", objArr);
        b bVar = this.lMF;
        if (bVar == null) {
            AppMethodBeat.o(144568);
            return;
        }
        bVar.onReadRemoteRssi(bluetoothGatt, i2, i3);
        AppMethodBeat.o(144568);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i2, int i3) {
        AppMethodBeat.i(144569);
        String str = this.cDW;
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = f.wR(i3);
        a.i(str, "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s", objArr);
        b bVar = this.lMF;
        if (bVar == null) {
            AppMethodBeat.o(144569);
            return;
        }
        bVar.onMtuChanged(bluetoothGatt, i2, i3);
        AppMethodBeat.o(144569);
    }
}
