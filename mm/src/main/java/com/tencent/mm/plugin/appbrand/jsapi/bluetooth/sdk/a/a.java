package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(18)
public final class a extends BluetoothGattCallback {
    private final e lMt;

    public a(e eVar) {
        this.lMt = eVar;
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
        AppMethodBeat.i(144532);
        this.lMt.onConnectionStateChange(bluetoothGatt, i2, i3);
        AppMethodBeat.o(144532);
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
        AppMethodBeat.i(144533);
        this.lMt.onServicesDiscovered(bluetoothGatt, i2);
        AppMethodBeat.o(144533);
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
        AppMethodBeat.i(144534);
        this.lMt.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i2);
        AppMethodBeat.o(144534);
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
        AppMethodBeat.i(144535);
        this.lMt.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i2);
        AppMethodBeat.o(144535);
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        AppMethodBeat.i(144536);
        this.lMt.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        AppMethodBeat.o(144536);
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
        AppMethodBeat.i(144537);
        this.lMt.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i2);
        AppMethodBeat.o(144537);
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
        AppMethodBeat.i(144538);
        this.lMt.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i2);
        AppMethodBeat.o(144538);
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i2) {
        AppMethodBeat.i(144539);
        this.lMt.onReliableWriteCompleted(bluetoothGatt, i2);
        AppMethodBeat.o(144539);
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i2, int i3) {
        AppMethodBeat.i(144540);
        this.lMt.onReadRemoteRssi(bluetoothGatt, i2, i3);
        AppMethodBeat.o(144540);
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i2, int i3) {
        AppMethodBeat.i(144541);
        this.lMt.onMtuChanged(bluetoothGatt, i2, i3);
        AppMethodBeat.o(144541);
    }
}
