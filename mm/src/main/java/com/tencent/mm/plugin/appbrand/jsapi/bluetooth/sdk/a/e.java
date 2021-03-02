package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

public interface e {
    void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic);

    void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2);

    void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2);

    void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3);

    void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2);

    void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2);

    void onMtuChanged(BluetoothGatt bluetoothGatt, int i2, int i3);

    void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i2, int i3);

    void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i2);

    void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2);
}
