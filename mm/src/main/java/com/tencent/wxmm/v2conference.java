package com.tencent.wxmm;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class v2conference {
    private static final String TAG = "WXMM.Conference";
    public int[] audioChannels = {1};
    public int[] audioFrameLen = {20};
    public int[] audioSampleRate = {8000};
    public int defaultHeight = 480;
    public int defaultWidth = 640;
    public int field_HWEncH = 0;
    public int field_HWEncW = 0;
    public int field_localImgHeight = 0;
    public int field_localImgWidth = 0;
    public int field_remoteImgFormat = 0;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgMember = -1;
    public int field_remoteImgWidth = 0;
    public int field_remoteScreenImgFormat = 0;
    public int field_remoteScreenImgHeight = 0;
    public int field_remoteScreenImgLength = 0;
    public int field_remoteScreenImgMember = -1;
    public int field_remoteScreenImgWidth = 0;
    private IConfCallBack mUiConfCallback = null;
    public int maxMemberSize = 100;
    public int[] memberVadlist = null;
    public byte[] remoteImgBuffer = null;

    private native int GetVideoData(byte[] bArr, int i2);

    public native int Accept(int i2);

    public native int Ack();

    public native int Add(byte[] bArr, int i2);

    public native int ExitRoom(int i2);

    public native int GetAudioData(byte[] bArr, int i2);

    public native int GetAudioFormat(int[] iArr, int[] iArr2, int[] iArr3);

    public native int GetVADStatus(int[] iArr);

    public native int GetVoiceActivity(int i2);

    public native int Hangup(int i2);

    public native int Init(byte[] bArr, int i2);

    public native int Invite(byte[] bArr, int i2);

    public native int JoinRoom(byte[] bArr, int i2);

    public native int OnNetworkChange(int i2, byte[] bArr);

    public native int PutExternalplayAudioData(byte[] bArr, int i2, int i3, int i4, int i5);

    public native int RecvNotify(byte[] bArr, int i2, int i3);

    public native int SendAudioData(byte[] bArr, int i2, int i3);

    public native int SendVideoData(byte[] bArr, int i2, int i3, int i4, int i5);

    public native int SetAppCmd(int i2, byte[] bArr, int i3);

    public native int SubscribeVideo(byte[] bArr, int i2);

    public native int SwitchAV(int i2, int i3, int i4);

    public native int SwitchAudio(int i2);

    public native int SwitchVideo(int i2);

    public native int UnInit();

    public native int UpdateAuthKey(byte[] bArr, int i2);

    public native int videoHWProcess(byte[] bArr, int i2, int i3, int i4, int i5, byte[] bArr2, int i6, int i7);

    public native int videoTrans(byte[] bArr, int i2, int i3, int i4, int i5, int[] iArr);

    static {
        AppMethodBeat.i(40774);
        System.loadLibrary("c++_shared");
        System.loadLibrary("ilink_xlog");
        System.loadLibrary("ilink_network");
        System.loadLibrary("confService");
        AppMethodBeat.o(40774);
    }

    public v2conference() {
        AppMethodBeat.i(40766);
        AppMethodBeat.o(40766);
    }

    public byte[] CallbackFromConferenceSDK(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(40767);
        if (this.mUiConfCallback != null) {
            byte[] callBackFromConf = this.mUiConfCallback.callBackFromConf(i2, i3, bArr);
            AppMethodBeat.o(40767);
            return callBackFromConf;
        }
        AppMethodBeat.o(40767);
        return null;
    }

    public void CallbackWriteLogFromSDK(int i2, String str, String str2, int i3, String str3, String str4, int i4) {
        AppMethodBeat.i(40768);
        if (this.mUiConfCallback != null) {
            this.mUiConfCallback.callbackWriteLog(i2, str, str2, i3, str3, str4, i4);
        }
        AppMethodBeat.o(40768);
    }

    public void SetUICallback(IConfCallBack iConfCallBack) {
        this.mUiConfCallback = iConfCallBack;
    }

    public int GetDecodeVideoData(byte[] bArr, int i2) {
        AppMethodBeat.i(188582);
        if (1 == GetVideoData(bArr, i2)) {
            AppMethodBeat.o(188582);
            return 1;
        }
        AppMethodBeat.o(188582);
        return 0;
    }

    public int GetAudioDeviceFmt(AudDataFmt audDataFmt) {
        AppMethodBeat.i(40770);
        int GetAudioFormat = GetAudioFormat(this.audioSampleRate, this.audioFrameLen, this.audioChannels);
        audDataFmt.nChannesl = this.audioChannels[0];
        audDataFmt.nFramelen = this.audioFrameLen[0];
        audDataFmt.nSamplerate = this.audioSampleRate[0];
        AppMethodBeat.o(40770);
        return GetAudioFormat;
    }

    public int InitSDK(byte[] bArr, int i2, IConfCallBack iConfCallBack) {
        AppMethodBeat.i(40771);
        this.mUiConfCallback = iConfCallBack;
        this.remoteImgBuffer = new byte[(((this.defaultWidth * this.defaultHeight) * 3) / 2)];
        this.memberVadlist = new int[this.maxMemberSize];
        int Init = Init(bArr, i2);
        AppMethodBeat.o(40771);
        return Init;
    }

    public int UninitSDK() {
        AppMethodBeat.i(40772);
        this.mUiConfCallback = null;
        this.memberVadlist = null;
        UnInit();
        AppMethodBeat.o(40772);
        return 0;
    }

    public int GetMembersVadStatus(int[] iArr) {
        AppMethodBeat.i(40773);
        if (iArr == null || this.memberVadlist == null) {
            AppMethodBeat.o(40773);
            return -1;
        }
        int GetVADStatus = GetVADStatus(this.memberVadlist);
        if (GetVADStatus > 0) {
            int length = iArr.length;
            if (GetVADStatus <= length) {
                length = GetVADStatus;
            }
            System.arraycopy(this.memberVadlist, 0, iArr, 0, length);
            AppMethodBeat.o(40773);
            return length;
        }
        AppMethodBeat.o(40773);
        return GetVADStatus;
    }
}
