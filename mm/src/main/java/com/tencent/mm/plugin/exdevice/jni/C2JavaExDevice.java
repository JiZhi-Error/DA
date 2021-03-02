package com.tencent.mm.plugin.exdevice.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.service.a;
import com.tencent.mm.plugin.exdevice.service.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class C2JavaExDevice {
    private static final String TAG = "MicroMsg.exdevice.C2JavaExDevice";

    public static void C2Java_onTaskEnd(long j2, int i2, int i3, String str, byte[] bArr) {
        AppMethodBeat.i(23179);
        a.c(j2, i2, i3, str);
        AppMethodBeat.o(23179);
    }

    public static void C2Java_onStateChange(long j2, int i2, int i3, int i4) {
        AppMethodBeat.i(23180);
        a.a(j2, i2, i3, i4);
        AppMethodBeat.o(23180);
    }

    public static void onDeviceRequest(long j2, short s, short s2, byte[] bArr, int i2) {
        AppMethodBeat.i(23181);
        a.onDeviceRequest(j2, s, s2, bArr, i2);
        AppMethodBeat.o(23181);
    }

    public static void createSession(long j2, long j3) {
        AppMethodBeat.i(23182);
        b.createSession(j2, j3);
        AppMethodBeat.o(23182);
    }

    public static boolean sendData(long j2, byte[] bArr) {
        AppMethodBeat.i(23183);
        boolean sendData = b.sendData(j2, bArr);
        AppMethodBeat.o(23183);
        return sendData;
    }

    public static boolean connect(long j2) {
        AppMethodBeat.i(23184);
        boolean connect = b.connect(j2);
        AppMethodBeat.o(23184);
        return connect;
    }

    public static void destroySession(long j2) {
        AppMethodBeat.i(23185);
        b.destroySession(j2);
        AppMethodBeat.o(23185);
    }

    public static void onAirKissCallback(int i2, int i3) {
        AppMethodBeat.i(23186);
        Log.v(TAG, "onAirKissCallback(errType : %d, errCode : %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        j.cKC().i(0, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(23186);
    }

    public static void onReceiveWCLanDeviceDiscPackage(byte[] bArr) {
        AppMethodBeat.i(23187);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        Log.i(TAG, "onReceiveWCLanDeviceDiscPackage, dataLen(%d).", objArr);
        j.cKC().i(10, bArr);
        AppMethodBeat.o(23187);
    }

    public static void onWCLanDeviceUdpError(int i2) {
        AppMethodBeat.i(23188);
        Log.i(TAG, "onWCLanDeviceUdpError, errCode(%d).", Integer.valueOf(i2));
        j.cKC().i(11, Integer.valueOf(i2));
        AppMethodBeat.o(23188);
    }

    public static void onWCLanReceiveResponse(int i2, byte[] bArr) {
        AppMethodBeat.i(23189);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        Log.i(TAG, "onWCLanReceiveResponse, cmdId(%d), data(%d).", objArr);
        j.cKC().i(12, Integer.valueOf(i2), bArr);
        AppMethodBeat.o(23189);
    }

    public static void onWCLanDeviceConnectStateNotify(String str, int i2) {
        AppMethodBeat.i(23190);
        Log.i(TAG, "onWCLanDeviceConnectStateNotify, devclassinfo(%s), stateCode(%d).", str, Integer.valueOf(i2));
        j.cKC().i(13, str, Integer.valueOf(i2));
        AppMethodBeat.o(23190);
    }

    public static void onReceiveWCLanDeviceProfile(byte[] bArr) {
        AppMethodBeat.i(23191);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        Log.i(TAG, "onReceiveWCLanDeviceProfile, data(%d).", objArr);
        j.cKC().i(14, bArr);
        AppMethodBeat.o(23191);
    }

    public static void onWCLanFileTransferUpdate(int i2, byte[] bArr) {
        AppMethodBeat.i(23192);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        Log.i(TAG, "onWCLanFileTransferUpdate, cmdId(%d), data(%d).", objArr);
        j.cKC().i(15, Integer.valueOf(i2), bArr);
        AppMethodBeat.o(23192);
    }

    public static void onWCLanReceiveNotify(String str, byte[] bArr) {
        AppMethodBeat.i(23193);
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        Log.i(TAG, "onWCLanReceiveNotify, devclassinfo(%s), data(%d).", objArr);
        j.cKC().i(16, str, bArr);
        AppMethodBeat.o(23193);
    }
}
