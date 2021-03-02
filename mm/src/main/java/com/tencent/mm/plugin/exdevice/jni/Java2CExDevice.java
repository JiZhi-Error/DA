package com.tencent.mm.plugin.exdevice.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

public final class Java2CExDevice {

    public static class AccessoryCmd {
        public long channelID;
        public int reqCmdID;
        public int respCmdID;
    }

    public static class LongWrapper {
        public long value;
    }

    public static native void cancelWCLanDeviceTask(int i2);

    public static native void closeBluetoothAccessoryLib();

    public static native int connectWCLanDevice(byte[] bArr, boolean z);

    public static native int createChannel(long j2, LongWrapper longWrapper);

    public static native void destroyChannel(long j2);

    public static native int disconnectWCLanDevice(byte[] bArr);

    public static native int getWCLanDeviceService(byte[] bArr, byte[] bArr2);

    public static native void initBluetoothAccessoryLib();

    public static native void initWCLanDeviceLib();

    public static native void onBluetoothConnected(long j2);

    public static native void onBluetoothDisconnected(long j2);

    public static native void onBluetoothError(long j2, int i2);

    public static native void onBluetoothRecvData(long j2, byte[] bArr);

    public static native void onBluetoothSendDataCompleted(long j2);

    public static native void onBluetoothSessionCreated(long j2, long j3, long j4);

    public static native void onCreate();

    public static native int readFileDataFromWCLanDevice(byte[] bArr, byte[] bArr2);

    public static native void releaseWCLanDeviceLib();

    public static native int sendFileToWCLanDevice(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native void setChannelSessionKey(long j2, byte[] bArr);

    public static native int startAirKiss(String str, String str2, byte[] bArr, long j2);

    public static native int startAirKissWithInter(String str, String str2, byte[] bArr, long j2, int i2, int i3);

    public static native int startChannelService(long j2);

    public static native void startScanWCLanDevice(byte[] bArr, int i2);

    public static native int startTask(long j2, short s, AccessoryCmd accessoryCmd, byte[] bArr);

    public static native void stopAirKiss();

    public static native void stopChannelService(long j2);

    public static native void stopScanWCLanDevice();

    public static native void stopTask(long j2);

    public static native int useWCLanDeviceService(byte[] bArr, byte[] bArr2);

    public static native int writeFileDataToWCLanDevice(byte[] bArr, byte[] bArr2);

    static {
        AppMethodBeat.i(23194);
        Java2CExDevice.class.getClassLoader();
        j.Ed("wechataccessory");
        onCreate();
        initBluetoothAccessoryLib();
        AppMethodBeat.o(23194);
    }
}
