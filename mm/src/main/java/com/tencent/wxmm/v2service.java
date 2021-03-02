package com.tencent.wxmm;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class v2service {
    private static final String TAG = "WXMM.Voip";
    public byte[] callbackOutData = null;
    public int defaultHeight = 544;
    public int defaultWidth = 704;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgWidth = 0;
    public int field_remoteScreenImgHeight = 0;
    public int field_remoteScreenImgLength = 0;
    public int field_remoteScreenImgWidth = 0;
    private IVoipCallBack mUiCallBack = null;
    public byte[] remoteImgBuffer = null;

    private native int Init(byte[] bArr, int i2);

    private native int UnInit();

    public native int Accept(int i2);

    public native int Ack();

    public native int Hangup(int i2);

    public native int Invite(int i2, byte[] bArr, int i3, int i4);

    public native int OnNetworkChange(int i2);

    public native int RecvNotify(byte[] bArr, int i2, int i3);

    public native int SwitchAVCmd(int i2);

    public native int UpdateAuthKey(byte[] bArr, int i2);

    public native int playCallback(byte[] bArr, int i2);

    public native int recordCallback(byte[] bArr, int i2, int i3);

    public native int setAppCmd(int i2, byte[] bArr, int i3);

    public native int videoDecode(byte[] bArr);

    public native int videoEncodeToSend(byte[] bArr, int i2, int i3, int i4, int i5);

    static {
        AppMethodBeat.i(40806);
        System.loadLibrary("c++_shared");
        System.loadLibrary("marsbridgexlog");
        System.loadLibrary("marsbridgenetwork");
        System.loadLibrary("voipService");
        AppMethodBeat.o(40806);
    }

    public int setAppCmd(int i2) {
        AppMethodBeat.i(40801);
        int appCmd = setAppCmd(i2, new byte[]{0}, 1);
        if (appCmd < 0) {
            v2helper.Logd(TAG, "setAppCmd: type:" + appCmd + ":ret:" + appCmd);
        }
        AppMethodBeat.o(40801);
        return appCmd;
    }

    public int InitSDK(byte[] bArr, int i2, IVoipCallBack iVoipCallBack) {
        AppMethodBeat.i(40802);
        this.mUiCallBack = iVoipCallBack;
        this.remoteImgBuffer = new byte[(((this.defaultWidth * this.defaultHeight) * 3) / 2)];
        int Init = Init(bArr, i2);
        v2helper.Logd(TAG, "protocal init ret :" + Init + " " + i2);
        AppMethodBeat.o(40802);
        return Init;
    }

    public int UninitSDK() {
        AppMethodBeat.i(40803);
        this.mUiCallBack = null;
        UnInit();
        AppMethodBeat.o(40803);
        return 0;
    }

    public int IntCallbackFromVoipSDK(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(40804);
        if (this.mUiCallBack != null) {
            this.mUiCallBack.callBackFromVoip1(i2, i3, bArr);
        }
        AppMethodBeat.o(40804);
        return 0;
    }

    public byte[] ByteArrayCallbackFromVoipSDK(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(40805);
        if (this.mUiCallBack != null) {
            byte[] callBackFromVoip2 = this.mUiCallBack.callBackFromVoip2(i2, i3, bArr);
            AppMethodBeat.o(40805);
            return callBackFromVoip2;
        }
        AppMethodBeat.o(40805);
        return null;
    }
}
