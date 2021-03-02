package com.tencent.mm.websocket.libwcwss;

import android.support.annotation.Keep;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

@Keep
public class WcwssNative {
    public static int INIT_ERROR = -1002;
    public static int NEW_WCWSS_ERROR = -1000;
    public static int REPEAT_INIT_ERROR = -1001;
    public static String TAG = "WcwssNative";
    private volatile boolean initCallBackFlag = false;
    private volatile long mNativeInst = 0;
    private volatile String mStrNativeInst = AppEventsConstants.EVENT_PARAM_VALUE_NO;

    @Keep
    public interface IWcWssReportListener {
        @Keep
        int getNetworkType();

        @Keep
        void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3);

        @Keep
        void onKvStat(int i2, String str);
    }

    @Keep
    public interface IWcWssWebSocketListener {
        @Keep
        int doCertificateVerify(String str, long j2, String str2, byte[][] bArr);

        @Keep
        void onStateChange(String str, long j2, int i2);
    }

    private native void destoryBindingWcwss(long j2);

    private native void doOnRunningStateWcwss(String str, long j2);

    private native long initBindingWcwss(long j2, long j3, long j4);

    private native int initCallBack(long j2, IWcWssWebSocketListener iWcWssWebSocketListener, IWcWssReportListener iWcWssReportListener);

    private native void initConfigWcwss(String str, long j2, HashMap<String, String> hashMap);

    private native void initConfigWhiteBlackList(String str, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2);

    private native void testBindingWcwss(long j2);

    private native void updateNativeInterface(String str, long j2, long j3, int i2);

    static {
        AppMethodBeat.i(3504);
        AppMethodBeat.o(3504);
    }

    @Keep
    public String initWcwss(long j2, long j3, long j4) {
        AppMethodBeat.i(224179);
        this.mNativeInst = initBindingWcwss(j2, j3, j4);
        this.mStrNativeInst = String.valueOf(this.mNativeInst);
        new StringBuilder("WcwssNative MMWcWss initWcwss str_contextId:").append(this.mStrNativeInst);
        String str = this.mStrNativeInst;
        AppMethodBeat.o(224179);
        return str;
    }

    @Keep
    public void destoryWcwss() {
        AppMethodBeat.i(224180);
        new StringBuilder("WcwssNative MMWcWss destoryWcwss mNativeInst:").append(this.mNativeInst);
        if (this.mNativeInst <= 0) {
            AppMethodBeat.o(224180);
            return;
        }
        if (this.initCallBackFlag) {
            this.initCallBackFlag = false;
            destoryBindingWcwss(this.mNativeInst);
            this.mNativeInst = -1;
        }
        AppMethodBeat.o(224180);
    }

    @Keep
    public int setCallback(IWcWssWebSocketListener iWcWssWebSocketListener, IWcWssReportListener iWcWssReportListener) {
        AppMethodBeat.i(224181);
        if (this.mNativeInst <= 0) {
            int i2 = NEW_WCWSS_ERROR;
            AppMethodBeat.o(224181);
            return i2;
        } else if (!this.initCallBackFlag) {
            int initCallBack = initCallBack(this.mNativeInst, iWcWssWebSocketListener, iWcWssReportListener);
            if (initCallBack == 0) {
                this.initCallBackFlag = true;
                AppMethodBeat.o(224181);
                return initCallBack;
            }
            int i3 = INIT_ERROR;
            AppMethodBeat.o(224181);
            return i3;
        } else {
            int i4 = REPEAT_INIT_ERROR;
            AppMethodBeat.o(224181);
            return i4;
        }
    }

    @Keep
    public void initConfig(HashMap<String, String> hashMap) {
        AppMethodBeat.i(224182);
        initConfigWcwss(this.mStrNativeInst, this.mNativeInst, hashMap);
        AppMethodBeat.o(224182);
    }

    @Keep
    public void initConfigWhiteBlack(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        AppMethodBeat.i(224183);
        initConfigWhiteBlackList(this.mStrNativeInst, this.mNativeInst, arrayList, arrayList2);
        AppMethodBeat.o(224183);
    }

    @Keep
    public void updateInterface(long j2, int i2) {
        AppMethodBeat.i(224184);
        updateNativeInterface(this.mStrNativeInst, this.mNativeInst, j2, i2);
        AppMethodBeat.o(224184);
    }

    @Keep
    public void doOnRunningState() {
        AppMethodBeat.i(224185);
        doOnRunningStateWcwss(this.mStrNativeInst, this.mNativeInst);
        AppMethodBeat.o(224185);
    }

    public void testBindWcwss(String str) {
        AppMethodBeat.i(3503);
        testBindingWcwss(Long.parseLong(str));
        AppMethodBeat.o(3503);
    }
}
