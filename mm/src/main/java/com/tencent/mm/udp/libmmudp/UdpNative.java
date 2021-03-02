package com.tencent.mm.udp.libmmudp;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class UdpNative {
    public static int INIT_ERROR = -1002;
    public static int NEW_UDP_ERROR = -1000;
    public static int REPEAT_INIT_ERROR = -1001;
    public static int SEND_BUFFER_ERROR = -1003;
    public static String TAG = "UdpNative";
    private boolean initCallBackFlag = false;
    volatile long mNativeInst = 0;

    @Keep
    public interface NativeCallBackInterface {
        @Keep
        void onCallBack(long j2, String str);
    }

    private native void destoryBindingUdp(long j2);

    private native long initBindingUdp(long j2, long j3, long j4);

    private native int initCallBack(long j2, NativeCallBackInterface nativeCallBackInterface);

    private native void serviceReceive(String str, int i2, String str2);

    private native void testBindingUdp(long j2);

    private native void testBindingUdp2(long j2);

    private native void updateNativeInterface(long j2, long j3);

    @Keep
    public UdpNative(long j2, long j3, long j4) {
        AppMethodBeat.i(237140);
        new StringBuilder("UdpNative isolate_ptr:").append(j2).append(",context_ptr:").append(j3).append(",uvloop_ptr:").append(j4);
        this.mNativeInst = initBindingUdp(j2, j3, j4);
        AppMethodBeat.o(237140);
    }

    @Keep
    public void destoryUdp() {
        AppMethodBeat.i(62490);
        if (this.mNativeInst == -1) {
            AppMethodBeat.o(62490);
            return;
        }
        if (this.initCallBackFlag) {
            this.initCallBackFlag = false;
            destoryBindingUdp(this.mNativeInst);
            this.mNativeInst = -1;
        }
        AppMethodBeat.o(62490);
    }

    @Keep
    public int InitCallBack(final NativeCallBackInterface nativeCallBackInterface) {
        AppMethodBeat.i(62491);
        if (this.mNativeInst == -1) {
            int i2 = NEW_UDP_ERROR;
            AppMethodBeat.o(62491);
            return i2;
        } else if (!this.initCallBackFlag) {
            int initCallBack = initCallBack(this.mNativeInst, new NativeCallBackInterface() {
                /* class com.tencent.mm.udp.libmmudp.UdpNative.AnonymousClass1 */

                @Override // com.tencent.mm.udp.libmmudp.UdpNative.NativeCallBackInterface
                @Keep
                public void onCallBack(long j2, String str) {
                    AppMethodBeat.i(62488);
                    nativeCallBackInterface.onCallBack(j2, str);
                    AppMethodBeat.o(62488);
                }
            });
            if (initCallBack == 0) {
                this.initCallBackFlag = true;
                AppMethodBeat.o(62491);
                return initCallBack;
            }
            int i3 = INIT_ERROR;
            AppMethodBeat.o(62491);
            return i3;
        } else {
            int i4 = REPEAT_INIT_ERROR;
            AppMethodBeat.o(62491);
            return i4;
        }
    }

    @Keep
    public void update(long j2) {
        AppMethodBeat.i(62492);
        if (this.mNativeInst == -1) {
            AppMethodBeat.o(62492);
            return;
        }
        updateNativeInterface(this.mNativeInst, j2);
        AppMethodBeat.o(62492);
    }

    public void testBind() {
        AppMethodBeat.i(62493);
        if (this.mNativeInst == -1) {
            AppMethodBeat.o(62493);
            return;
        }
        testBindingUdp(this.mNativeInst);
        AppMethodBeat.o(62493);
    }

    public void testBind2() {
        AppMethodBeat.i(62494);
        if (this.mNativeInst == -1) {
            AppMethodBeat.o(62494);
            return;
        }
        testBindingUdp2(this.mNativeInst);
        AppMethodBeat.o(62494);
    }

    public void testServiceReceive(String str, int i2, String str2) {
        AppMethodBeat.i(62495);
        if (this.mNativeInst == -1) {
            AppMethodBeat.o(62495);
            return;
        }
        serviceReceive(str, i2, str2);
        AppMethodBeat.o(62495);
    }
}
