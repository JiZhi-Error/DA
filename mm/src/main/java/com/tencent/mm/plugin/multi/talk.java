package com.tencent.mm.plugin.multi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.wecall.talkroom.model.i;
import java.util.concurrent.atomic.AtomicInteger;

public class talk {
    public static int VOICE_FRAME_DURATION = 20;
    public static int VOICE_SAMPLERATE = TXRecordCommon.AUDIO_SAMPLERATE_8000;
    public static int zGz = 9;
    public byte[] field_capInfo = null;
    public int field_localImgHeight = 0;
    public int field_localImgWidth = 0;
    public int field_remoteImgChannel = 0;
    public int field_remoteImgChannel_screen = 0;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgHeight_screen = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgLength_screen = 0;
    public int field_remoteImgOrien = 0;
    public int field_remoteImgOrien_screen = 0;
    public int field_remoteImgWidth = 0;
    public int field_remoteImgWidth_screen = 0;

    public interface a {
        void keep_OnError(int i2);

        void keep_OnNotify(int i2);

        void keep_OnOpenSuccess();

        void keep_OnReportChannel(String str);

        void keep_OnReportEngineRecv(String str, int i2);

        void keep_OnReportEngineSend(String str);
    }

    public native int GetAudioData(byte[] bArr, int i2, AtomicInteger atomicInteger, AtomicInteger atomicInteger2);

    public native int GetVoiceActivity(int i2);

    public native int IsSilenceFrame();

    public native void OnMembersChanged(int[] iArr);

    public native int Open(a aVar, i iVar, int i2, int i3, int i4, long j2, String[] strArr, short[] sArr, int i5, int[] iArr, byte[] bArr, boolean z, int i6, String[] strArr2, short[] sArr2, int i7, int i8, int i9, byte[] bArr2, int[] iArr2, int i10, int i11);

    public native int Redirect(String[] strArr, short[] sArr, String[] strArr2, short[] sArr2, int i2);

    public native int SendAudio(byte[] bArr, short s, int i2);

    public native int SendScreen(byte[] bArr, int i2, int i3, int i4, int i5);

    public native int SendVideo(byte[] bArr, int i2, int i3, int i4, int i5, int i6);

    public native void SetAVEncryptType(int i2, int i3);

    public native int SetCurrentMicId(int i2);

    public native int close();

    public native int getChannelBytes(AtomicInteger atomicInteger, AtomicInteger atomicInteger2);

    public native int getSampleRate(AtomicInteger atomicInteger, AtomicInteger atomicInteger2);

    public native int init(int i2, int i3, int i4, String str);

    public native int onNetworkChange(int i2);

    public native int screenDecode(byte[] bArr, int[] iArr, int i2);

    public native int screenTrans(byte[] bArr, int i2, int i3, int i4, byte[] bArr2, int i5, int i6, int i7);

    public native int setAppCmd(int i2, byte[] bArr, int i3);

    public native int setMVSvrCfg(int[] iArr, int i2);

    public native int uninit();

    public native int videoDecode(int[] iArr);

    public native int videoTrans(byte[] bArr, int i2, int i3, int i4, int i5, int[] iArr);

    static {
        AppMethodBeat.i(62794);
        try {
            if (com.tencent.pb.common.a.a.RCk && com.tencent.pb.common.a.a.RCB) {
                System.loadLibrary("stlport_shared");
                System.loadLibrary("wechatxlog");
                System.loadLibrary("voipMain");
            }
            AppMethodBeat.o(62794);
        } catch (Throwable th) {
            b.w("loadLibrary: ", th);
            AppMethodBeat.o(62794);
        }
    }

    public final int setAppCmd(int i2) {
        AppMethodBeat.i(62793);
        int appCmd = setAppCmd(i2, new byte[]{5}, 1);
        AppMethodBeat.o(62793);
        return appCmd;
    }
}
