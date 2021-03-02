package com.tencent.ilink.network;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceInterface {
    private static final String TAG = "DeviceInterface";
    private static DeviceInterface instance;
    public DeviceCallbackInterface deviceCallback;

    public static native void SetLonglinkIplist(byte[] bArr);

    public static native void SetProxyInfo(byte[] bArr);

    public static native void SetShortlinkIplist(byte[] bArr);

    public static native void Start(byte[] bArr);

    public static native void Stop();

    public static native boolean isAlreadyGetStrategy();

    public static DeviceInterface getInstance() {
        AppMethodBeat.i(187955);
        if (instance == null) {
            instance = new DeviceInterface();
        }
        DeviceInterface deviceInterface = instance;
        AppMethodBeat.o(187955);
        return deviceInterface;
    }

    public void setDeviceCallback(DeviceCallbackInterface deviceCallbackInterface) {
        this.deviceCallback = deviceCallbackInterface;
    }

    public DeviceCallbackInterface getDeviceCallback() {
        return this.deviceCallback;
    }
}
