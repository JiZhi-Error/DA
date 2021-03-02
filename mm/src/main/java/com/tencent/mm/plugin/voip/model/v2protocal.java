package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Message;
import android.text.format.Formatter;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.g.d;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.ety;
import com.tencent.mm.protocal.protobuf.eub;
import com.tencent.mm.protocal.protobuf.eur;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.wxmm.v2helper;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class v2protocal {
    public static boolean Hap = false;
    public static boolean Haq = false;
    public static boolean Har = false;
    public static int Has = 0;
    public static int Hbf = 0;
    public static d HcA = null;
    public static Surface HcC = null;
    public static d HcD = null;
    private static int Hcc = 10;
    public static final int VOICE_FRAME_BYTES;
    public static final int VOICE_SAMPLERATE;
    protected static int cpuFlag0;
    public static SurfaceTexture mSurfaceTexture;
    public int HaA = 0;
    public byte[] HaB = null;
    public int HaC = 500;
    public int HaD = 30;
    public int HaE = 999;
    public int HaF = 0;
    public byte[] HaG = null;
    public byte[] HaH = null;
    public byte[] HaI = new byte[10];
    public int HaJ = 20;
    public int HaK = 0;
    public int HaL = 0;
    public int HaM = 0;
    public int HaN = 0;
    public int HaO = 65536;
    public int HaP = 0;
    public int HaQ = 0;
    public int HaR = 0;
    public int HaS = 7;
    public int HaT = 3;
    public int HaU = 3;
    public int HaV = 0;
    public int HaW = 0;
    public int HaX = -1;
    public int HaY = -1;
    public int HaZ = 0;
    public int Hat = 0;
    public int Hau = 0;
    public int Hav = 0;
    public long Haw = 0;
    public byte[] Hax = null;
    public volatile byte[] Hay = null;
    public byte[] Haz = null;
    public int HbA = 0;
    public int HbB = 0;
    public int HbC = 0;
    public int HbD = 0;
    public int HbE = 0;
    public int[] HbF = null;
    public int HbG = 0;
    public int HbH = 0;
    public int HbI = 0;
    public int HbJ = 0;
    public byte[] HbK = null;
    public int HbL = 0;
    public int HbM = 0;
    public int HbN = 0;
    public int HbO = 0;
    public byte[] HbP = new byte[1500];
    public int HbQ = 0;
    public byte[] HbR = null;
    public byte[] HbS = null;
    public int HbT = 0;
    public int HbU = 0;
    public int HbV = 0;
    public int HbW = 0;
    public int HbX = 0;
    public int HbY = 0;
    public byte[] HbZ = null;
    public int Hba = 0;
    public int Hbb = 0;
    public int Hbc = 0;
    public int Hbd = 0;
    public int Hbe = 0;
    public String Hbg = "";
    public int Hbh = 0;
    public int Hbi = 0;
    public int Hbj = 0;
    public int Hbk = 0;
    public int Hbl = 100;
    public int Hbm = 300;
    public int Hbn = 1;
    public int Hbo = 1;
    public int Hbp = 0;
    public int Hbq = 1;
    public int Hbr = 0;
    public int Hbs = 0;
    public int Hbt = 0;
    public int Hbu = 0;
    public int Hbv = 0;
    public int Hbw = 0;
    public int Hbx = 0;
    public int Hby = 0;
    public int Hbz = 0;
    int HcB = 8;
    public byte[] Hca = null;
    public byte[] Hcb = null;
    public ArrayBlockingQueue<byte[]> Hcd = new ArrayBlockingQueue<>(Hcc);
    long Hce = 0;
    public byte[] Hcf = new byte[8];
    public int Hcg = 0;
    public int Hch = 0;
    public int Hci = 0;
    public int Hcj = 0;
    public int Hck = 0;
    byte[] Hcl = new byte[4096];
    byte[] Hcm = new byte[2048];
    byte[] Hcn = new byte[2048];
    byte[] Hco = new byte[4096];
    byte[] Hcp = new byte[4096];
    byte[] Hcq = new byte[2048];
    byte[] Hcr = new byte[4096];
    public byte[] Hcs = new byte[2048];
    public byte[] Hct = new byte[2048];
    public int[] Hcu = new int[30];
    int Hcv = 0;
    public o Hcw = new o();
    public int Hcx = 0;
    private int Hcy = 0;
    public volatile e Hcz = null;
    int bitrate = 300;
    public int channelStrategy = 0;
    public int defaultHeight = 240;
    public int defaultWidth = 320;
    public int[] field_ChannelReportDial = null;
    public int[] field_EngineReportStatFromApp = null;
    public int field_HWEncH = 0;
    public int field_HWEncW = 0;
    public int field_audioDuration = 0;
    public byte[] field_capInfo = null;
    int field_channelReportLength = 0;
    int field_channelStatLength = 0;
    public int field_connectingStatusKey = 0;
    int field_engine2ndReportLength = 0;
    int field_engine2ndStatLength = 0;
    int field_engineQosStatLength = 0;
    int field_engineVersionStatLength = 0;
    public int[] field_jbmBitratRsSvrParamArray = null;
    public double[] field_jbmBitratRsSvrParamDoubleArray = null;
    public int field_jbmParamArraySize = 0;
    public int field_jbmParamDoubleArraySize = 0;
    public int field_localImgHeight = 0;
    public int field_localImgWidth = 0;
    public int field_mGetValidSample = 0;
    public int[] field_natSvrArray = null;
    int field_netFlowRecv = 0;
    int field_netFlowSent = 0;
    int field_newEngineExtStatLength = 0;
    int field_newEngineReportLength = 0;
    int field_newEngineStatLength = 0;
    public byte[] field_peerId = null;
    public int field_pstnChannelInfoLength = 0;
    public int field_pstnEngineInfoLength = 0;
    public int field_realLinkQualityInfoBuffLen = 0;
    public int field_recvVideoLen = 120;
    public int field_relayDataSyncKey = 0;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgOrien = 0;
    public int field_remoteImgWidth = 0;
    public int field_sendVideoLen = 100;
    int field_speedTestInfoLength = 0;
    int field_statInfoLength = 0;
    public int field_statusSyncKey = 0;
    public int field_videoDuration = 0;
    public String haD = "";
    private MMHandler handler = null;
    public int height = 480;
    protected boolean iCs = false;
    public long iXv = 0;
    public int netType = 0;
    public int qDA = 0;
    public boolean qtK = false;
    public int roomId = 0;
    public int width = 640;
    public long ypH = 0;
    public int ypJ = 0;
    public int ypO = 0;
    public int zNX = 0;

    private native int forceredirect(int i2, int i3, byte[] bArr, int i4);

    private native int setsvraddr(int i2, int i3, int i4, String str, String str2, int i5, byte[] bArr, int i6);

    private native int uninit(int i2, long j2, int i3);

    public native int ActivateConn(int i2);

    public native int AddNewDirectConns(byte[] bArr, int i2, int i3);

    public native int AddNewRelayConns(byte[] bArr, int i2, int i3);

    public native int GetAudioFormat(AtomicInteger atomicInteger, AtomicInteger atomicInteger2, AtomicInteger atomicInteger3);

    public native int GetNetBottleneckSide();

    public native int GetNicInfo(int i2, byte[] bArr, AtomicInteger atomicInteger, AtomicInteger atomicInteger2, AtomicInteger atomicInteger3, byte[] bArr2, AtomicInteger atomicInteger4, AtomicInteger atomicInteger5, AtomicInteger atomicInteger6);

    public native int InactivateConn(int i2);

    public native int QueryNicWanIp(byte[] bArr, int i2);

    public native int SendDTMF(int i2);

    public native int SendRUDP(byte[] bArr, int i2);

    public native int SetDTMFPayload(int i2);

    public native int StartSpeedTest(byte[] bArr, int i2);

    public native int StopSpeedTest();

    public native int app2EngineDataEx(int i2, int i3, byte[] bArr, int i4, int i5);

    public native int app2EngineLinkQualityEx(int i2, byte[] bArr);

    public native int connectToPeer();

    public native int connectToPeerDirect();

    public native int connectToPeerRelay();

    public native int doubleLinkSwitch(int i2);

    public native int exchangeCabInfo(byte[] bArr, int i2);

    public native int freeJNIReport();

    public native int getAVDuration(byte[] bArr, int i2);

    public native int getChannelInfo(byte[] bArr, int i2, int i3, int i4, int i5, int i6);

    public native int getChannelReport(byte[] bArr, int i2);

    public native int getCurrentConnType();

    public native int getEngine2ndInfo(byte[] bArr, int i2);

    public native int getEngine2ndInfoReport(byte[] bArr, int i2);

    public native int getEngineQosInfo(byte[] bArr, int i2);

    public native int getEngineVersionInfo(byte[] bArr, int i2);

    public native String[] getMPDirectReport();

    public native String[] getMPEngineReport();

    public native String[] getMPRelayReport();

    public native String[] getNatReport();

    public native int getNewEngineExtInfo(byte[] bArr, int i2);

    public native int getNewEngineInfo(byte[] bArr, int i2);

    public native int getNewEngineInfoReport(byte[] bArr, int i2);

    public native int getPstnChannelInfo(byte[] bArr, int i2, int i3, int i4);

    public native int getPstnEngineInfo(byte[] bArr, int i2);

    public native int getStatInfo(byte[] bArr, int i2, int[] iArr, int i3);

    public native int getVideoHWDecode(int[] iArr, byte[] bArr, int i2);

    public native int getVoipcsChannelInfo(byte[] bArr, int i2, int i3);

    public native int getVoipcsEngineInfo(byte[] bArr, int i2);

    public native int getcurstrategy();

    public native int handleCommand(int i2, byte[] bArr, int i3);

    /* access modifiers changed from: protected */
    public native int init(int i2, int i3, int i4, int i5, int i6, int i7, String str, int i8, long j2, int i9);

    public native int isDCReady();

    public native int isDCSameLan();

    public native int isRelayConnReady();

    public native int parseSyncKeyBuff(byte[] bArr, int i2);

    public native int playCallback(byte[] bArr, int i2);

    public native int recordCallback(byte[] bArr, int i2, int i3);

    public native int setActive();

    public native int setAppCmd(int i2, byte[] bArr, int i3);

    public native int setConfigInfo(int i2, long j2, int i3, long j3, byte[] bArr, int i4, int i5, int i6, int i7, int i8, byte[] bArr2, int i9, int i10, int i11, int i12, byte[] bArr3, int i13, int i14, int i15, byte[] bArr4, int i16, int i17, int i18, int i19, String str, String str2, int i20);

    public native int setInactive();

    public native int setJNIAppCmd(int i2, byte[] bArr, int i3);

    public native int setNetSignalValue(int i2, int i3);

    public native int setSvrConfig(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, byte[] bArr);

    public native int setjbmbitraterssvrparam();

    public native int startEngine();

    public native int videoDecode(byte[] bArr);

    public native int videoDecode(int[] iArr);

    public native int videoDecodeBB(ByteBuffer byteBuffer);

    public native int videoEncodeToLocal(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr);

    public native int videoEncodeToLocal2(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr);

    public native int videoEncodeToSend(byte[] bArr, int i2, int i3, int i4, int i5);

    public native int videoEncodeToSend2(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5);

    public native int videoHWDecode(byte[] bArr);

    public native int videoHWProcess(byte[] bArr, int i2, int i3, int i4, int i5, byte[] bArr2);

    public native int videoHWProcess2(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer2);

    public native int videoRorate90D(byte[] bArr, int i2, int i3, int i4, int i5, byte[] bArr2, int i6, int i7, int i8, int i9);

    static {
        AppMethodBeat.i(115291);
        v2protocal.class.getClassLoader();
        j.Ed("voipMain");
        int aon = m.aon();
        cpuFlag0 = aon;
        int i2 = (aon & 1024) != 0 ? 16000 : TXRecordCommon.AUDIO_SAMPLERATE_8000;
        VOICE_SAMPLERATE = i2;
        VOICE_FRAME_BYTES = (i2 / 1000) * 20 * 2;
        AppMethodBeat.o(115291);
    }

    public final int setAppCmd(int i2) {
        AppMethodBeat.i(115259);
        int appCmd = setAppCmd(i2, new byte[]{0}, 1);
        if (appCmd < 0) {
            e.Logi("MicroMsg.Voip", "setAppCmd: type:" + appCmd + ":ret:" + appCmd);
        }
        AppMethodBeat.o(115259);
        return appCmd;
    }

    public final int a(eur eur) {
        AppMethodBeat.i(115260);
        if (this.Hce != 0) {
            e.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
            AppMethodBeat.o(115260);
            return -1;
        }
        this.Hce = eur.NsG;
        ety ety = new ety();
        ety.Nrb = eur.NsG;
        for (int i2 = 0; i2 < eur.NsL; i2++) {
            eub eub = new eub();
            eub.Ngz = eur.NsM.get(i2).NbG.NgC;
            eub.port = eur.NsM.get(i2).NbG.MKe;
            eub.HiN = eur.NsM.get(i2).NbF;
            eub.gap = eur.NsM.get(i2).Ncl;
            eub.timeout = eur.NsM.get(i2).Ncm;
            eub.Nrv = eur.NsM.get(i2).Ncn;
            ety.Nrc.add(eub);
        }
        try {
            e.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest ret :".concat(String.valueOf(StartSpeedTest(ety.toByteArray(), ety.toByteArray().length))));
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.Voip", e2, "StartVoipSpeedTest exception", new Object[0]);
        }
        AppMethodBeat.o(115260);
        return 0;
    }

    private static String fIL() {
        AppMethodBeat.i(115261);
        String str = Build.MANUFACTURER;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.MODEL;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        String str3 = Build.VERSION.SDK;
        if (str3.contains(",")) {
            str3 = str3.replace(',', ' ');
        }
        String str4 = Build.VERSION.RELEASE;
        if (str4.contains(",")) {
            str4 = str3.replace(',', ' ');
        }
        String str5 = "," + str + "," + str2 + "," + str3 + "," + str4;
        AppMethodBeat.o(115261);
        return str5;
    }

    public static long cn(byte[] bArr) {
        AppMethodBeat.i(115262);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        long j2 = wrap.getLong();
        AppMethodBeat.o(115262);
        return j2;
    }

    private String fIM() {
        long j2;
        long j3 = 0;
        AppMethodBeat.i(115263);
        if (this.zNX == 0 && this.HaL == 0) {
            this.Hcw.GXt = 0;
        } else if (this.HaL != 0 && this.zNX != 0) {
            this.Hcw.GXt = 3;
        } else if (this.HaL != 0) {
            this.Hcw.GXt = 1;
        } else if (this.zNX != 0) {
            this.Hcw.GXt = 2;
        }
        this.Hcw.GXB = e.getNetType(MMApplicationContext.getContext());
        this.Hcw.GXA = this.field_videoDuration;
        this.Hcw.GXz = this.field_audioDuration;
        this.HaP = a.ced();
        if (this.Hcw.GXJ <= 0 || this.Hcw.GXD <= this.Hcw.GXJ) {
            j2 = 0;
        } else {
            j2 = this.Hcw.GXD - this.Hcw.GXJ;
        }
        e.Logd("MicroMsg.Voip", "voipreport:acceptcalltime:".concat(String.valueOf(j2)));
        setJNIAppCmd(1, this.Hcf, this.Hcf.length);
        long cn = cn(this.Hcf);
        this.Hcw.GXK = (cn <= this.Hcw.GXH || this.Hcw.GXH <= 0) ? 0 : cn - this.Hcw.GXH;
        o oVar = this.Hcw;
        if (cn > this.Hcw.GXJ && this.Hcw.GXJ > 0) {
            j3 = cn - this.Hcw.GXJ;
        }
        oVar.GXL = j3;
        e.Logd("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.Hcw.GXK + " lCalledWaitTime:" + this.Hcw.GXL);
        int i2 = cpuFlag0 & 255;
        boolean fFj = c.fFj();
        int a2 = ((b) g.af(b.class)).a(b.a.mmvoip_multipath_switch, 0);
        StringBuilder append = new StringBuilder().append(this.HaK).append(",").append(this.roomId).append(",").append(this.ypH).append(",").append(this.ypO).append(",").append(this.Hcw.GXc).append(",").append(this.Hcw.GXo).append(",").append(this.Hcw.GXp).append(",").append(this.Hcw.GXq).append(",").append(this.Hcw.GXr).append(",").append(this.Hcw.GXs).append(",").append(this.Hcw.GXt).append(",").append((int) this.Hcw.GXm).append(",").append(this.Hcw.GXu).append(",").append(this.Hcw.GXv).append(",").append(this.Hcw.GXw).append(",").append(this.Hcw.GXx).append(",").append(this.Hcw.GXy).append(",").append(this.Hcw.GXz).append(",").append(this.Hcw.GXA).append(",").append(this.Hcw.GXB).append(fIS()).append(fIT()).append(fIL()).append(",").append(this.Hcw.GXC).append(",").append(this.HaO).append(",").append(this.HaP).append(",").append(j2).append(",").append(this.Hcw.GXK).append(",").append(this.Hcw.GXL).append(",").append(this.HaQ).append(",").append(this.Hau).append(fIN()).append(",").append(i2).append(",").append(this.HaX).append(",").append(this.HaY);
        String str = Build.VERSION.INCREMENTAL;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.DISPLAY;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        String sb = append.append("," + str + "," + str2).append(",").append(this.Hcw.GXE).append(",").append(this.Hcw.GXG).append(",").append(this.Hcw.GXF).append(",0,").append(this.Hcw.GXM).append(",").append(this.Hcw.GUE).append(",").append(this.Hcw.GUF).append(",").append(this.Hcw.GXN).append(",0,0,0,").append(this.HaZ).append(",").append(this.Hba).append(",").append(this.HaR).append(",").append(this.Hbb).append(",").append(this.Hbc).append(",").append(this.Hbd).append(",").append(this.Hcx).append(",").append(this.Hbg).append(",").append(this.Hbe).append(",").append(Hbf).append(",").append(a2).append(",").append(fFj).toString();
        e.Logi("MicroMsg.Voip", "voipreport:initNetType:" + this.Hau);
        e.Logi("MicroMsg.Voip", ":".concat(String.valueOf(sb)));
        e.Logi("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + fIN());
        e.Logi("MicroMsg.Voip", "lInterruptStartTime:" + this.Hcw.GUE + ",lInterruptEndTime:" + this.Hcw.GUF + ",mIinterruptCnt:" + this.Hcw.GXN + ",iPlayMinBufSize:" + this.HaZ + ",iRecordMinBufSize:" + this.Hba);
        e.Logi("MicroMsg.Voip", "steve:[simucall]voipreport::iSimulCallStatus:" + this.Hcx);
        AppMethodBeat.o(115263);
        return sb;
    }

    private String fIN() {
        AppMethodBeat.i(115264);
        String str = "," + this.channelStrategy;
        AppMethodBeat.o(115264);
        return str;
    }

    /* access modifiers changed from: protected */
    public final String fIO() {
        AppMethodBeat.i(115265);
        if (this.field_videoDuration == 0) {
            e.Logd("MicroMsg.Voip", "captureFrames:" + this.Hcg + ", videoduration: 0");
            AppMethodBeat.o(115265);
            return ",0";
        }
        e.Logd("MicroMsg.Voip", "capturefps:" + (this.Hcg / this.field_videoDuration) + " framecount:" + this.Hcg + " videoDuration:" + this.field_videoDuration);
        String str = "," + (this.Hcg / this.field_videoDuration);
        AppMethodBeat.o(115265);
        return str;
    }

    public final int fIP() {
        if (this.Hcy > 0) {
            return this.Hcy;
        }
        if (this.field_videoDuration == 0) {
            return 0;
        }
        return this.Hcg / this.field_videoDuration;
    }

    public final void fIQ() {
        AppMethodBeat.i(235703);
        this.Hcy = 0;
        Log.i("MicroMsg.Voip", "resetCaptureFps");
        AppMethodBeat.o(235703);
    }

    private void fIR() {
        AppMethodBeat.i(184064);
        if (this.Hcg <= 0 || this.field_videoDuration <= 0) {
            AppMethodBeat.o(184064);
            return;
        }
        this.Hcy = this.Hcg / this.field_videoDuration;
        Log.i("MicroMsg.Voip", "calcCpatureFps:%s", Integer.valueOf(this.Hcy));
        AppMethodBeat.o(184064);
    }

    private String fIS() {
        AppMethodBeat.i(115266);
        e.Logd("MicroMsg.Voip", "usePreConnect:" + this.Hbj);
        String str = "," + this.Hbj;
        AppMethodBeat.o(115266);
        return str;
    }

    private String fIT() {
        AppMethodBeat.i(115267);
        e.Logd("MicroMsg.Voip", "preConnectSuccess:" + this.Hbk);
        String str = "," + this.Hbk;
        AppMethodBeat.o(115267);
        return str;
    }

    private String fIU() {
        AppMethodBeat.i(115268);
        this.HaT = a.cea().audioManager.getMode();
        this.HaU = a.cea().audioManager.getMode();
        if (ae.gKu.gEe >= 0) {
            this.HaT = ae.gKu.gEe;
        }
        if (Build.VERSION.SDK_INT >= 11 && k.alh() && 2 == ae.gKE.gGF) {
            this.HaU = 2;
        }
        if (ae.gKu.gEf >= 0) {
            this.HaU = ae.gKu.gEf;
        }
        if (Build.VERSION.SDK_INT < 11) {
            this.HaS = 1;
        } else {
            this.HaS = 7;
        }
        if (ae.gKu.gDA) {
            this.HaS = 1;
        }
        if (ae.gKu.gEd >= 0) {
            this.HaS = ae.gKu.gEd;
        }
        if (ae.gKu.gDB > 0) {
            this.HaV = 3;
            this.HaW = 0;
        } else if (ae.gKu.gEg >= 0) {
            this.HaV = ae.gKu.gEg;
            this.HaW = ae.gKu.gEg;
        }
        if (ae.gKu.gEh >= 0) {
            this.HaV = ae.gKu.gEh;
        }
        if (ae.gKu.gEi >= 0) {
            this.HaW = ae.gKu.gEi;
        }
        String str = "," + this.HaT + "," + this.HaU + "," + this.HaS + "," + this.HaV + "," + this.HaW;
        AppMethodBeat.o(115268);
        return str;
    }

    /* access modifiers changed from: package-private */
    public final String fIV() {
        AppMethodBeat.i(115269);
        getChannelInfo(this.Hco, this.Hco.length, this.HbG, this.HbH, this.HbI, this.HbJ);
        e.Logi("MicroMsg.Voip", "voipreport:oldChannelString: ".concat(String.valueOf(this.ypH + "," + this.roomId + "," + this.ypO + this.Hcw.fGX() + ("," + this.Hcw.GXs) + new String(this.Hco, 0, this.field_channelStatLength))));
        getChannelReport(this.Hco, this.Hco.length);
        String str = new String(this.Hco, 0, this.field_channelReportLength);
        e.Logi("MicroMsg.Voip", "voipreport:newChannelString: ".concat(String.valueOf(str)));
        AppMethodBeat.o(115269);
        return str;
    }

    private String fIW() {
        AppMethodBeat.i(115270);
        getNewEngineInfo(this.Hcp, this.Hcp.length);
        getNewEngineExtInfo(this.Hcq, this.Hcq.length);
        e.Logi("MicroMsg.Voip", "voipreport:oldNewEngineString:".concat(String.valueOf(this.ypO + "," + this.ypH + this.Hcw.fGX() + "," + this.zNX + "," + this.HaL + fIO() + new String(this.Hcp, 0, this.field_newEngineStatLength) + "," + this.HaM + "," + this.HaN + fIU() + new String(this.Hcq, 0, this.field_newEngineExtStatLength))));
        getNewEngineInfoReport(this.Hcp, this.Hcp.length);
        String str = this.ypO + "," + this.ypH + this.Hcw.fGX() + "," + this.zNX + "," + this.HaL + fIO() + new String(this.Hcp, 0, this.field_newEngineReportLength);
        e.Logi("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:".concat(String.valueOf(str)));
        AppMethodBeat.o(115270);
        return str;
    }

    /* access modifiers changed from: package-private */
    public final String fIX() {
        AppMethodBeat.i(115271);
        getEngine2ndInfo(this.Hcr, this.Hcr.length);
        e.Logi("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:".concat(String.valueOf(this.ypH + "," + this.roomId + "," + this.ypO + new String(this.Hcr, 0, this.field_engine2ndStatLength))));
        getEngine2ndInfoReport(this.Hcr, this.Hcr.length);
        String str = this.ypH + "," + this.roomId + "," + this.ypO + new String(this.Hcr, 0, this.field_engine2ndReportLength);
        e.Logi("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:".concat(String.valueOf(str)));
        AppMethodBeat.o(115271);
        return str;
    }

    public final String fIY() {
        AppMethodBeat.i(115272);
        String str = fIL() + "," + this.Hbh + "," + (cpuFlag0 & 255) + fIU() + "," + this.HaY;
        AppMethodBeat.o(115272);
        return str;
    }

    public v2protocal(MMHandler mMHandler) {
        AppMethodBeat.i(115273);
        this.handler = mMHandler;
        AppMethodBeat.o(115273);
    }

    public int keep_onNotifyFromJni(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(115274);
        e.Logd("MicroMsg.VoipService", "callByJni : arg1:" + i2 + " arg2:" + i3);
        if (i2 == 100) {
            e.outputJniLog(bArr, "MicroMsg.Voip", i3);
            AppMethodBeat.o(115274);
        } else if (i2 == 101) {
            e.outputJniLog(bArr, "MicroMsg.v2Core", i3);
            AppMethodBeat.o(115274);
        } else {
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i2;
            message.arg2 = i3;
            message.obj = bArr;
            this.handler.sendMessage(message);
            AppMethodBeat.o(115274);
        }
        return 0;
    }

    public int keep_onNotifyFromJniInt(int i2, int i3, int[] iArr) {
        AppMethodBeat.i(115275);
        if (iArr != null) {
            e.Logd("MicroMsg.VoipService", "callByJniInt : arg1:" + i2 + " arg2:" + i3);
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i2;
            message.arg2 = i3;
            message.obj = iArr;
            this.handler.sendMessage(message);
        }
        AppMethodBeat.o(115275);
        return 0;
    }

    public final boolean fIZ() {
        return this.iCs;
    }

    public static int fJa() {
        AppMethodBeat.i(115276);
        DhcpInfo dhcpInfo = ((WifiManager) MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
        e.Logd("MicroMsg.Voip", "get wifi route ip:".concat(String.valueOf(Formatter.formatIpAddress(dhcpInfo.gateway))));
        int i2 = dhcpInfo.gateway;
        AppMethodBeat.o(115276);
        return i2;
    }

    public final int fJb() {
        AppMethodBeat.i(115278);
        this.netType = e.getNetType(MMApplicationContext.getContext());
        if (this.netType == 5) {
            this.netType = 4;
        }
        this.HbF = new int[(this.defaultWidth * this.defaultHeight)];
        g.aAf();
        this.qDA = com.tencent.mm.kernel.a.getUin();
        int aon = m.aon();
        int i2 = Build.VERSION.SDK_INT;
        int gLVersion = OpenGlRender.getGLVersion();
        Display defaultDisplay = ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
        int width2 = defaultDisplay.getWidth();
        int init = init(this.netType, 65538, (this.defaultWidth << 16) | this.defaultHeight, (width2 << 16) | defaultDisplay.getHeight(), this.qDA, (gLVersion << 24) | (i2 << 16) | aon, com.tencent.mm.loader.j.b.aKA() + "lib/", 4, 0, 0);
        e.Logd("MicroMsg.Voip", "protocalInitForPstn protocal init ret :" + init + ",uin= " + this.qDA + ", groupRsCap = 0");
        this.iCs = true;
        if (init < 0) {
            reset();
        }
        AppMethodBeat.o(115278);
        return init;
    }

    public final int ftD() {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        int i3;
        AppMethodBeat.i(115279);
        this.netType = e.getNetType(MMApplicationContext.getContext());
        this.Hau = this.netType;
        if (this.netType == 5) {
            this.netType = 4;
        }
        boolean z4 = this.Hau >= 4 && (cpuFlag0 & 1024) != 0 && (cpuFlag0 & 255) >= 26;
        boolean z5 = z4 && (cpuFlag0 & 255) >= 30;
        boolean z6 = z5 && (cpuFlag0 & 255) >= 60;
        boolean z7 = z6 && (cpuFlag0 & 255) >= 71;
        boolean z8 = ae.gKt.gGc > 0 && ae.gKt.gFE.width >= 480 && ae.gKt.gFE.height >= 360 && ae.gKt.gFG.width >= 480 && ae.gKt.gFG.height >= 360;
        boolean z9 = ae.gKt.gGc >= 2 && ae.gKt.gFE.width >= 640 && ae.gKt.gFE.height >= 480 && ae.gKt.gFG.width >= 640 && ae.gKt.gFG.height >= 480;
        boolean z10 = ae.gKt.gGc == 2;
        boolean z11 = ae.gKt.gGc == 3;
        boolean z12 = ae.gKt.gGc >= 4;
        boolean z13 = ae.gKt.gGc == 0;
        boolean z14 = ae.gKt.gGd == 0;
        boolean z15 = ae.gKt.gGd > 0;
        boolean z16 = ae.gKt.gGe > 0;
        boolean z17 = ((b) g.af(b.class)).a(b.a.clicfg_voip_enable_720p_encode, 0) != 0;
        boolean z18 = ((b) g.af(b.class)).a(b.a.clicfg_voip_enable_720p_capture, 0) != 0;
        Haq = (z7 && z12) || (z7 && z17);
        Har = (z6 && z16) || (z6 && z18);
        if (ae.gKt.gFE.width >= 480 || ae.gKt.gFG.width >= 480) {
            e.Logi("MicroMsg.Voip", "hseasun:Close the 720p force due to configuration from svr");
            Haq = false;
            Har = false;
        }
        if (Haq) {
            Har = true;
        }
        Has = 0;
        this.qtK = false;
        if (!z14) {
            boolean z19 = z5 && aFU("video/avc");
            boolean z20 = z6 && aFU(TPDecoderType.TP_CODEC_MIMETYPE_HEVC);
            boolean z21 = z20 && z11;
            if (z15) {
                z = (ae.gKt.gGd & 16) != 0;
                z3 = z21 && (ae.gKt.gGd & 32) != 0;
                z2 = z19 && (ae.gKt.gGd & 15) != 0;
            } else {
                z = false;
                z2 = z19;
                z3 = z21;
            }
            this.qtK = z3 || z2;
            e.Logi("MicroMsg.Voip", "hwH264Local:" + z19 + ",hwHEVCLocal:" + z20 + ", bSupportH264HW:" + z2 + ", bSupportHEVCSW:" + z + ", bSupportHEVCHW:" + z3 + ", svrHWCfg:" + ae.gKt.gGd + ", 720p jcchen " + z6 + "-" + (!z10) + "-" + z12 + "-" + Haq + " svr 480p:" + ae.gKt.gGc);
            if (z2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (z) {
                i3 |= 2;
            }
            i2 = z3 ? i3 | 4 : i3;
        } else {
            i2 = 0;
        }
        if ((z4 || z8) && !z13) {
            if (this.qtK || z9) {
                this.defaultWidth = 640;
                this.defaultHeight = 480;
                if (z6 && !z10) {
                    this.defaultWidth = TAVExporter.VIDEO_EXPORT_HEIGHT;
                    this.defaultHeight = TAVExporter.VIDEO_EXPORT_WIDTH;
                }
            } else {
                this.defaultWidth = 480;
                this.defaultHeight = v2helper.VOIP_ENC_HEIGHT_LV1;
            }
            Hap = true;
            e.Logi("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        }
        e.Logi("MicroMsg.Voip", "steve: Android CPUFlag:" + (cpuFlag0 & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z4 + ", bEnable480FromSvr:" + z8 + ", bDisable480FromSvr:" + z13 + ", bEnable640FromLocal:" + z5 + ", bEnable640FromSvr:" + z9);
        this.HbF = new int[(this.defaultWidth * this.defaultHeight)];
        g.aAf();
        this.qDA = com.tencent.mm.kernel.a.getUin();
        int i4 = Build.VERSION.SDK_INT;
        int gLVersion = OpenGlRender.getGLVersion();
        Display defaultDisplay = ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
        int width2 = defaultDisplay.getWidth();
        int height2 = defaultDisplay.getHeight();
        int i5 = ae.gKE.gHf;
        long j2 = 0;
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_voip_fullbandflag, -1);
        Log.i("MicroMsg.Voip", "kerrizhang, fullbandmode = %d", Integer.valueOf(a2));
        int i6 = ae.gKu.gEr;
        Log.i("MicroMsg.Voip", "kerrizhang SrvDeviceInfo.mAudioInfo.voipfullbandcfg %d", Integer.valueOf(i6));
        if (a2 > 0 && i6 > 0) {
            j2 = ((long) (((double) a2) * 100000.0d)) + 456;
            Log.i("MicroMsg.Voip", "kerrizhang typectrl %d", Long.valueOf(j2));
        }
        int a3 = ((b) g.af(b.class)).a(b.a.clicfg_voip_opuswb_switch, 0);
        Log.i("MicroMsg.Voip", "winterwang get server opuswbswitch %d", Integer.valueOf(a3));
        byte[] bArr = new byte[4];
        bArr[0] = (byte) a3;
        Log.i("MicroMsg.Voip", "winterwang setJNIAppCmd  EMethod_AudioOptionSwitch ,ret: %d", Integer.valueOf(setJNIAppCmd(5, bArr, 4)));
        int init = init((i2 << 8) | this.netType, 2, this.defaultHeight | (this.defaultWidth << 16), (width2 << 16) | height2, this.qDA, (gLVersion << 24) | (i4 << 16) | cpuFlag0, com.tencent.mm.loader.j.b.aKA() + "lib/", 0, j2, i5);
        e.Logi("MicroMsg.Voip", "protocalInit protocal init ret :" + init + ",uin= " + this.qDA + ", gl_vs:" + gLVersion + ", cpuFlag0=" + cpuFlag0 + ", hwCap= " + i2 + ", groupRsCap = " + i5);
        this.iCs = true;
        if (init < 0) {
            reset();
        }
        AppMethodBeat.o(115279);
        return init;
    }

    public final String xh(boolean z) {
        AppMethodBeat.i(115280);
        if (this.iCs) {
            e.Logi("MicroMsg.Voip", "call protocalUninit now...needStatInfo=".concat(String.valueOf(z)));
            this.field_ChannelReportDial = new int[6];
            this.field_ChannelReportDial[0] = this.Hcw.GXm;
            this.field_ChannelReportDial[1] = this.Hcw.GXs;
            this.field_ChannelReportDial[2] = this.HbG;
            this.field_ChannelReportDial[3] = this.HbH;
            this.field_ChannelReportDial[4] = this.HbI;
            this.field_ChannelReportDial[5] = this.HbJ;
            this.field_EngineReportStatFromApp = new int[17];
            fIU();
            this.field_EngineReportStatFromApp[0] = this.HaM;
            this.field_EngineReportStatFromApp[1] = this.HaN;
            this.field_EngineReportStatFromApp[2] = this.HaT;
            this.field_EngineReportStatFromApp[3] = this.HaU;
            this.field_EngineReportStatFromApp[4] = this.HaS;
            this.field_EngineReportStatFromApp[5] = this.HaV;
            this.field_EngineReportStatFromApp[6] = this.HaW;
            this.field_EngineReportStatFromApp[7] = -1;
            if (this.Hcz != null) {
                this.field_EngineReportStatFromApp[8] = this.Hcz.qsj;
                this.field_EngineReportStatFromApp[9] = this.Hcz.qsl;
                this.field_EngineReportStatFromApp[10] = this.Hcz.qsb;
            } else {
                this.field_EngineReportStatFromApp[8] = 0;
                this.field_EngineReportStatFromApp[9] = 0;
                this.field_EngineReportStatFromApp[10] = 0;
            }
            if (HcA != null) {
                this.field_EngineReportStatFromApp[11] = HcA.zLC;
            } else {
                this.field_EngineReportStatFromApp[11] = 0;
            }
            this.field_EngineReportStatFromApp[12] = this.HbW;
            this.field_EngineReportStatFromApp[13] = this.HbX;
            this.field_EngineReportStatFromApp[14] = this.HbY;
            if (Har) {
                this.field_EngineReportStatFromApp[15] = 1280;
                this.field_EngineReportStatFromApp[16] = 720;
            } else {
                this.field_EngineReportStatFromApp[15] = 640;
                this.field_EngineReportStatFromApp[16] = 480;
            }
            this.iCs = false;
            uninit(this.roomId, this.ypH, this.ypO);
            Hap = false;
            Has = 0;
            if (this.Hcz != null) {
                this.Hcz.emB();
                this.Hcz = null;
            }
            if (HcA != null) {
                HcA.interrupt();
                d dVar = HcA;
                dVar.zLv = false;
                dVar.zLw = false;
                dVar.zLy = 0;
                Log.d("MeidaCodec[HWDec]", "steve: Stop Decode Thread!");
                try {
                    if (dVar.outputStream != null) {
                        dVar.outputStream.flush();
                        dVar.outputStream.close();
                    }
                    if (dVar.zLm != null) {
                        dVar.zLm.flush();
                        dVar.zLm.close();
                    }
                } catch (IOException e2) {
                    Log.e("MeidaCodec[HWDec]", " error:" + e2.toString());
                }
                HcA = null;
            }
            if (HcC != null) {
                HcC.release();
            }
            HcC = null;
            e.Logi("MicroMsg.Voip", "uninit over.");
            if (z) {
                getStatInfo(this.Hcl, this.Hcl.length, this.Hcu, 30);
                getEngineVersionInfo(this.Hcm, this.Hcm.length);
                getEngineQosInfo(this.Hcn, this.Hcn.length);
                StringBuilder sb = new StringBuilder();
                long j2 = (long) this.qDA;
                if (this.qDA < 0) {
                    j2 = ((long) this.qDA) + 4294967296L;
                }
                StringBuilder append = new StringBuilder().append(j2).append(",").append(this.ypH).append(",").append(this.roomId).append(",").append(this.ypO).append(",");
                o oVar = this.Hcw;
                String sb2 = append.append(oVar.GXc + "," + oVar.GXd + "," + oVar.GXe + "," + oVar.GXf + "," + ((int) oVar.GXg) + "," + ((int) oVar.GXh) + "," + ((int) oVar.GXi) + "," + ((int) oVar.GXj) + "," + ((int) oVar.GXk) + "," + ((int) oVar.GXl) + "," + ((int) oVar.GXm)).toString();
                e.Logi("MicroMsg.Voip", "voipreport:DailStatString:".concat(String.valueOf(sb2)));
                StringBuilder append2 = sb.append(sb2).append(new String(this.Hcl, 0, this.field_statInfoLength)).append(fIL()).append(fIN()).append("," + this.Hcw.GXn).append(new String(this.Hcm, 0, this.field_engineVersionStatLength)).append(fIO());
                e.Logd("MicroMsg.Voip", "cpuCapacity:" + cpuFlag0);
                String sb3 = append2.append("," + cpuFlag0).append(fIS()).append(fIT()).append(new String(this.Hcn, 0, this.field_engineQosStatLength)).toString();
                e.Logi("MicroMsg.Voip", "statInfoBuffer = " + new String(this.Hcl, 0, this.field_statInfoLength));
                e.Logi("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.Hcm, 0, this.field_engineVersionStatLength));
                e.Logi("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.Hcn, 0, this.field_engineQosStatLength));
                e.Logi("MicroMsg.Voip", "voipreport:StatString = ".concat(String.valueOf(sb3)));
                ay.a.iDr.dl(this.field_netFlowRecv, this.field_netFlowSent);
                e.Logd("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
                AppMethodBeat.o(115280);
                return sb3;
            }
        }
        AppMethodBeat.o(115280);
        return "";
    }

    public static String fJc() {
        return "\u0000";
    }

    public final String fJd() {
        AppMethodBeat.i(115281);
        String fIM = fIM();
        AppMethodBeat.o(115281);
        return fIM;
    }

    public final String[] fJe() {
        AppMethodBeat.i(115282);
        String[] natReport = getNatReport();
        e.Loge("MicroMsg.Voip", "nat_report size:" + natReport.length);
        for (int i2 = 0; i2 < natReport.length; i2++) {
            e.Loge("MicroMsg.Voip", "nat_report:" + natReport[i2]);
        }
        AppMethodBeat.o(115282);
        return natReport;
    }

    public final String[] fJf() {
        AppMethodBeat.i(115283);
        String[] mPDirectReport = getMPDirectReport();
        e.Loge("MicroMsg.Voip", "direct_report_string size:" + mPDirectReport.length);
        for (int i2 = 0; i2 < mPDirectReport.length; i2++) {
            e.Loge("MicroMsg.Voip", "direct_report_string:" + mPDirectReport[i2]);
        }
        AppMethodBeat.o(115283);
        return mPDirectReport;
    }

    public final String[] fJg() {
        AppMethodBeat.i(115284);
        String[] mPRelayReport = getMPRelayReport();
        e.Loge("MicroMsg.Voip", "relay_report_string size:" + mPRelayReport.length);
        for (int i2 = 0; i2 < mPRelayReport.length; i2++) {
            e.Loge("MicroMsg.Voip", "relay_report_string:" + mPRelayReport[i2]);
        }
        AppMethodBeat.o(115284);
        return mPRelayReport;
    }

    public final String[] fJh() {
        AppMethodBeat.i(115285);
        String[] mPEngineReport = getMPEngineReport();
        e.Loge("MicroMsg.Voip", "engine_report_string size:" + mPEngineReport.length);
        for (int i2 = 0; i2 < mPEngineReport.length; i2++) {
            mPEngineReport[i2] = this.ypH + "," + this.ypO + mPEngineReport[i2];
            e.Loge("MicroMsg.Voip", "engine_report_string:" + mPEngineReport[i2]);
        }
        AppMethodBeat.o(115285);
        return mPEngineReport;
    }

    public final String fJi() {
        AppMethodBeat.i(115286);
        String fIW = fIW();
        AppMethodBeat.o(115286);
        return fIW;
    }

    public final void reset() {
        AppMethodBeat.i(115287);
        Log.printInfoStack("MicroMsg.Voip", "v2protocal reset!", new Object[0]);
        fIR();
        this.field_natSvrArray = null;
        this.field_peerId = null;
        this.field_capInfo = null;
        this.roomId = 0;
        this.Haw = 0;
        this.Hav = 0;
        this.ypO = 0;
        this.ypH = 0;
        this.channelStrategy = 0;
        this.ypJ = 0;
        this.iXv = 0;
        this.Hax = null;
        this.Hay = null;
        this.Haz = null;
        this.HaA = 0;
        this.HaB = null;
        this.HbJ = 0;
        this.HbK = null;
        this.HbL = 0;
        this.HbM = 0;
        this.HaG = null;
        this.HaH = null;
        this.HbR = null;
        this.HbS = null;
        this.HbZ = null;
        this.Hca = null;
        this.Hcb = null;
        this.Hcg = 0;
        this.Hch = 0;
        this.Hci = 0;
        this.Hcj = 0;
        this.Hck = 0;
        this.field_videoDuration = 0;
        this.field_audioDuration = 0;
        this.Hcv = 0;
        this.Hbk = 0;
        this.Hbj = 0;
        this.field_engineVersionStatLength = 0;
        this.field_engineQosStatLength = 0;
        this.field_statusSyncKey = 0;
        this.field_relayDataSyncKey = 0;
        this.field_connectingStatusKey = 0;
        this.HaM = 0;
        this.HaN = 0;
        this.HaO = 65536;
        this.HaP = 0;
        this.HaQ = 0;
        this.HaR = 0;
        this.HaY = -1;
        this.Hbh = 0;
        this.HbV = 0;
        this.Hat = 0;
        this.haD = "";
        this.HbT = 0;
        this.HbU = 0;
        this.Hcw.reset();
        this.Hcw.fGW();
        Hap = false;
        Has = 0;
        this.field_jbmBitratRsSvrParamArray = null;
        this.field_jbmParamArraySize = 0;
        this.field_jbmBitratRsSvrParamDoubleArray = null;
        this.field_jbmParamDoubleArraySize = 0;
        this.Hbb = 0;
        this.Hbc = 0;
        this.Hbd = 0;
        this.Hbe = 0;
        Hbf = 0;
        this.Hbg = "";
        this.Hcx = 0;
        c.fFi();
        e.Logi("MicroMsg.Voip", "freeJNIReport : " + freeJNIReport() + ". [0: null, no need to free, 1: free success!]");
        AppMethodBeat.o(115287);
    }

    @SuppressLint({"NewApi"})
    private static boolean aFU(String str) {
        boolean z;
        Exception e2;
        AppMethodBeat.i(115288);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                z = false;
                for (int codecCount = MediaCodecList.getCodecCount() - 1; codecCount >= 0; codecCount--) {
                    try {
                        MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(codecCount);
                        e.Logi("MicroMsg.Voip", "steve codecInfo : " + codecInfoAt.getName());
                        String[] supportedTypes = codecInfoAt.getSupportedTypes();
                        String name = codecInfoAt.getName();
                        for (String str2 : supportedTypes) {
                            if (str2.equalsIgnoreCase(str)) {
                                for (String str3 : e.supportedH264HwCodecPrefixes) {
                                    if (name.startsWith(str3)) {
                                        try {
                                            e.Logi("MicroMsg.Voip", "steve : H.264 HW encoder found:".concat(String.valueOf(name)));
                                            z = true;
                                        } catch (Exception e3) {
                                            e2 = e3;
                                            z = true;
                                            Log.printErrStackTrace("MicroMsg.Voip", e2, "SupportAvcCodec error: %s", e2.getMessage());
                                            AppMethodBeat.o(115288);
                                            return z;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        Log.printErrStackTrace("MicroMsg.Voip", e2, "SupportAvcCodec error: %s", e2.getMessage());
                        AppMethodBeat.o(115288);
                        return z;
                    }
                }
            } else {
                z = false;
            }
        } catch (Exception e5) {
            e2 = e5;
            z = false;
            Log.printErrStackTrace("MicroMsg.Voip", e2, "SupportAvcCodec error: %s", e2.getMessage());
            AppMethodBeat.o(115288);
            return z;
        }
        AppMethodBeat.o(115288);
        return z;
    }

    public final int a(a aVar) {
        AppMethodBeat.i(115289);
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicInteger atomicInteger2 = new AtomicInteger();
        AtomicInteger atomicInteger3 = new AtomicInteger();
        int GetAudioFormat = GetAudioFormat(atomicInteger, atomicInteger2, atomicInteger3);
        if (GetAudioFormat == 0) {
            aVar.channels = atomicInteger3.get();
            aVar.GSV = atomicInteger2.get();
            aVar.Bry = atomicInteger.get();
            aVar.GSU = 0;
        } else {
            aVar.Bry = (m.aon() & 1024) != 0 ? 16000 : TXRecordCommon.AUDIO_SAMPLERATE_8000;
            aVar.channels = 1;
            aVar.GSV = 20;
            aVar.GSU = 0;
        }
        e.Logi("MicroMsg.Voip", "V2Protocal: GetAudioDeviceFmt ret :" + GetAudioFormat + ",samplerate = " + aVar.Bry + ", framelenms =" + aVar.GSV + ", channels =" + aVar.channels);
        AppMethodBeat.o(115289);
        return GetAudioFormat;
    }

    public final int bv(LinkedList<csu> linkedList) {
        AppMethodBeat.i(115290);
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicInteger atomicInteger2 = new AtomicInteger();
        AtomicInteger atomicInteger3 = new AtomicInteger();
        byte[] bArr = new byte[20];
        AtomicInteger atomicInteger4 = new AtomicInteger();
        AtomicInteger atomicInteger5 = new AtomicInteger();
        AtomicInteger atomicInteger6 = new AtomicInteger();
        byte[] bArr2 = new byte[20];
        int GetNicInfo = GetNicInfo(20, bArr, atomicInteger, atomicInteger2, atomicInteger3, bArr2, atomicInteger4, atomicInteger5, atomicInteger6);
        if (GetNicInfo == 0) {
            if (atomicInteger.get() > 0) {
                csu csu = new csu();
                csu.LYu = new String(bArr, 0, atomicInteger.get());
                csu.MxQ = atomicInteger3.get();
                csu.Loh = atomicInteger2.get();
                linkedList.add(csu);
            }
            if (atomicInteger4.get() > 0) {
                csu csu2 = new csu();
                csu2.LYu = new String(bArr2, 0, atomicInteger4.get());
                csu2.MxQ = atomicInteger6.get();
                csu2.Loh = atomicInteger5.get();
                linkedList.add(csu2);
            }
        }
        AppMethodBeat.o(115290);
        return GetNicInfo;
    }
}
