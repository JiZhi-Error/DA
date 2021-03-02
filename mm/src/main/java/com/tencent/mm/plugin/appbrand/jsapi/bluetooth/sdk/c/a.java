package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e;
import java.util.List;
import junit.framework.Assert;

public abstract class a implements e {
    protected final Handler aDv = new Handler(Looper.getMainLooper());
    public boolean aXs = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().aXs;
    public volatile boolean brr = false;
    public boolean lMh = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMh;
    public boolean lMj = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMj;
    public d lNb;
    protected b lNc;
    public b lNd;
    private final Runnable lNe = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(144589);
            if (a.this.brr) {
                AppMethodBeat.o(144589);
                return;
            }
            a.this.a(j.lNJ);
            a.this.done();
            AppMethodBeat.o(144589);
        }
    };
    public long lNf = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMe;
    public long lNg = ((long) com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMn);
    public j lNh;
    protected int lNi = hashCode();

    public abstract void bFt();

    public abstract String getName();

    public final void a(b bVar) {
        this.lNc = bVar;
    }

    public final void a(final j jVar) {
        this.lNh = jVar;
        if (this.lMh) {
            this.aDv.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(144590);
                    a.this.lNd.a(jVar);
                    AppMethodBeat.o(144590);
                }
            });
        } else {
            this.lNd.a(jVar);
        }
    }

    public final void done() {
        this.aDv.removeCallbacks(this.lNe);
        this.brr = true;
        b(this.lNh);
        b bVar = this.lNc;
        Object obj = this.lNh;
        Object[] objArr = new Object[2];
        objArr[0] = this;
        if (obj == null) {
            obj = "";
        }
        objArr[1] = obj;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback action:%s result:%s", objArr);
        if (this.lMj) {
            bVar.bFo();
            return;
        }
        List<a> list = bVar.lMw;
        if (list != null) {
            list.remove(this);
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback, runActions is null", new Object[0]);
        }
    }

    public void b(j jVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i2, int i3) {
    }

    public String toString() {
        return "Action#" + this.lNi + "{action='" + getName() + '\'' + ", debug=" + this.aXs + ", mainThread=" + this.lMh + ", serial=" + this.lMj + '}';
    }

    public final void doAction() {
        Assert.assertNotNull(this.lNb);
        Assert.assertNotNull(this.lNc);
        Assert.assertNotNull(this.lNd);
        this.aDv.postDelayed(this.lNe, this.lNf);
        bFt();
    }
}
