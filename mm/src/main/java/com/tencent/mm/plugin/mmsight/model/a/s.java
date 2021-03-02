package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.b;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.a;
import com.tencent.mm.plugin.mmsight.model.a.f;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.tav.coremedia.TimeUtil;
import java.nio.ByteBuffer;

@TargetApi(16)
public class s implements f {
    private ByteBuffer[] bfQ;
    private int bitrate = 0;
    private ByteBuffer[] btv;
    private MediaCodec.BufferInfo bufferInfo;
    int colorFormat;
    boolean dyL = false;
    int frameCount;
    private int frameRate;
    private long hlh = 0;
    private int idB;
    protected z ieT;
    private final Object iff = new Object();
    boolean isQ = false;
    private boolean isStart = false;
    private int jtj = -1;
    private int jtk = -1;
    private boolean jtl = false;
    private int kxW;
    private int kxX;
    protected MediaFormat mediaFormat;
    private long startTime = 0;
    int targetHeight;
    int targetWidth;
    private p zvN;
    private boolean zvP = false;
    private boolean zvR = true;
    int zwB = -1;
    int zwC = -1;
    int zwD = -1;
    int zwE = -1;
    a zwF = new a(this.zwH);
    f.a zwG;
    private a.AbstractC1480a zwH = new a.AbstractC1480a() {
        /* class com.tencent.mm.plugin.mmsight.model.a.s.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.mmsight.model.a.a.AbstractC1480a
        public final void output(byte[] bArr) {
            AppMethodBeat.i(89586);
            long currentTicks = Util.currentTicks();
            boolean ejV = s.this.zwF.ejV();
            s.this.d(bArr, ejV && s.this.dyL);
            b.jtf.k(bArr);
            Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "markStop: %s isEnd %s costTime %d", Boolean.valueOf(s.this.dyL), Boolean.valueOf(ejV), Long.valueOf(Util.ticksToNow(currentTicks)));
            if (ejV && s.this.dyL) {
                s.this.ekk();
            }
            AppMethodBeat.o(89586);
        }
    };
    private long zwc = 0;

    static /* synthetic */ void a(s sVar) {
        AppMethodBeat.i(89601);
        sVar.aMi();
        AppMethodBeat.o(89601);
    }

    public s(int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        AppMethodBeat.i(89588);
        this.kxW = i2;
        this.kxX = i3;
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", Integer.valueOf(i4), Integer.valueOf(i5));
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", Integer.valueOf(i4), Integer.valueOf(i5));
        this.targetWidth = i4;
        this.targetHeight = i5;
        this.frameRate = i8;
        this.idB = i7;
        this.zvN = null;
        this.bufferInfo = new MediaCodec.BufferInfo();
        this.bitrate = i6;
        this.isQ = z;
        this.zvR = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ignore_mediacodec_lock, true);
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", Integer.valueOf(this.kxW), Integer.valueOf(this.kxX), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight), Integer.valueOf(i6), Boolean.valueOf(z), null);
        AppMethodBeat.o(89588);
    }

    public final void start() {
        AppMethodBeat.i(89589);
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start");
        this.isStart = true;
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start：isStart：" + this.isStart);
        this.startTime = System.nanoTime();
        AppMethodBeat.o(89589);
    }

    public int ha(int i2, int i3) {
        int i4 = -1;
        AppMethodBeat.i(89590);
        try {
            this.zwB = i3;
            i4 = bhL();
            AppMethodBeat.o(89590);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "init error: %s, try to re-init again", e2.getMessage());
            try {
                if (CaptureMMProxy.getInstance() != null) {
                    CaptureMMProxy.getInstance().set(ar.a.USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT, -1);
                }
                i4 = bhL();
                AppMethodBeat.o(89590);
            } catch (Exception e3) {
                Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "re-init again error: %s", e3.getMessage());
                l.aNJ();
                AppMethodBeat.o(89590);
            }
        }
        return i4;
    }

    private int bhL() {
        MediaCodecInfo mediaCodecInfo;
        boolean z;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        boolean z2;
        String[] supportedTypes;
        AppMethodBeat.i(89591);
        long currentTicks = Util.currentTicks();
        int codecCount = MediaCodecList.getCodecCount();
        int i2 = 0;
        loop0:
        while (true) {
            if (i2 >= codecCount) {
                mediaCodecInfo = null;
                break;
            }
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    if (str.equalsIgnoreCase("video/avc")) {
                        mediaCodecInfo = codecInfoAt;
                        break loop0;
                    }
                }
                continue;
            }
            i2++;
        }
        if (mediaCodecInfo == null) {
            Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "Unable to find an appropriate codec for video/avc");
            l.aNJ();
            AppMethodBeat.o(89591);
            return -1;
        }
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found codec: %s, used %sms", mediaCodecInfo.getName(), Long.valueOf(Util.ticksToNow(currentTicks)));
        long currentTicks2 = Util.currentTicks();
        int i3 = -1;
        if (CaptureMMProxy.getInstance() != null) {
            i3 = CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT, -1);
        }
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "saveColorFormat: %s", Integer.valueOf(i3));
        if (i3 <= 0) {
            i3 = 0;
            long currentTicks3 = Util.currentTicks();
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
            Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "getCapabilitiesForType used %sms", Long.valueOf(Util.ticksToNow(currentTicks3)));
            Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
            for (int i4 = 0; i4 < capabilitiesForType.colorFormats.length; i4++) {
                int i5 = capabilitiesForType.colorFormats[i4];
                Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "capabilities colorFormat: %s", Integer.valueOf(i5));
                switch (i5) {
                    case 19:
                    case 21:
                    case 2130706688:
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (z && (i5 > i3 || i5 == 21)) {
                    i3 = i5;
                }
            }
            Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i3));
        }
        this.colorFormat = i3;
        long ticksToNow = Util.ticksToNow(currentTicks2);
        if (this.colorFormat > 0 && ticksToNow > 200 && CaptureMMProxy.getInstance() != null) {
            CaptureMMProxy.getInstance().set(ar.a.USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT, Integer.valueOf(this.colorFormat));
        }
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found colorFormat: %s, used %sms", Integer.valueOf(this.colorFormat), Long.valueOf(ticksToNow));
        long currentTicks4 = Util.currentTicks();
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "initRotate: %s", Integer.valueOf(this.zwB));
        if (this.isQ) {
            this.mediaFormat = MediaFormat.createVideoFormat("video/avc", (this.zwB == 180 || this.zwB == 0) ? this.targetWidth : this.targetHeight, (this.zwB == 180 || this.zwB == 0) ? this.targetHeight : this.targetWidth);
        } else {
            this.mediaFormat = MediaFormat.createVideoFormat("video/avc", (this.zwB == 180 || this.zwB == 0) ? this.targetHeight : this.targetWidth, (this.zwB == 180 || this.zwB == 0) ? this.targetWidth : this.targetHeight);
        }
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "createVideoFormat used %sms", Long.valueOf(Util.ticksToNow(currentTicks4)));
        if (mediaCodecInfo != null) {
            if (d.oD(23)) {
                try {
                    MediaCodecInfo.CodecCapabilities capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                    if (!(capabilitiesForType2 == null || (codecProfileLevelArr = capabilitiesForType2.profileLevels) == null)) {
                        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                        codecProfileLevel.level = 0;
                        codecProfileLevel.profile = 0;
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                            int i6 = codecProfileLevel2.profile;
                            int i7 = codecProfileLevel2.level;
                            Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "profile: %s, level: %s", Integer.valueOf(i6), Integer.valueOf(i7));
                            switch (i6) {
                                case 1:
                                case 2:
                                case 8:
                                    z2 = true;
                                    break;
                                default:
                                    z2 = false;
                                    break;
                            }
                            if (z2 && i6 >= codecProfileLevel.profile && i7 >= codecProfileLevel.level) {
                                codecProfileLevel.profile = i6;
                                codecProfileLevel.level = i7;
                            }
                        }
                        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                        if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                            this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                            this.mediaFormat.setInteger("level", 256);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetProfile error: %s", e2.getMessage());
                }
            }
            try {
                if (d.oD(21)) {
                    this.mediaFormat.setInteger("bitrate-mode", 1);
                }
            } catch (Exception e3) {
                Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetBitRateMode error: %s", e3.getMessage());
            }
        }
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.mediaFormat.setInteger("frame-rate", this.frameRate);
        this.mediaFormat.setInteger("color-format", this.colorFormat);
        this.mediaFormat.setInteger("i-frame-interval", this.idB);
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "mediaFormat: %s", this.mediaFormat);
        this.ieT = z.Eb(mediaCodecInfo.getName());
        this.ieT.a(this.mediaFormat, (Surface) null, 1);
        this.ieT.start();
        if (this.zvR) {
            AppMethodBeat.o(89591);
            return 0;
        }
        synchronized (this.iff) {
            try {
                this.zvP = false;
            } catch (Throwable th) {
                AppMethodBeat.o(89591);
                throw th;
            }
        }
        AppMethodBeat.o(89591);
        return 0;
    }

    public final void d(byte[] bArr, boolean z) {
        AppMethodBeat.i(89592);
        if (!this.zvR) {
            synchronized (this.iff) {
                try {
                    if (this.zvP) {
                        return;
                    }
                } finally {
                    AppMethodBeat.o(89592);
                }
            }
        }
        try {
            if (!this.isStart) {
                Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, not start!");
                AppMethodBeat.o(89592);
            } else if (this.ieT == null) {
                Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
                AppMethodBeat.o(89592);
            } else {
                if (this.zvN != null && this.zvN.ekh() <= 0) {
                    this.zvN.eki();
                }
                long currentTicks = Util.currentTicks();
                this.btv = this.ieT.getInputBuffers();
                this.bfQ = this.ieT.getOutputBuffers();
                int dequeueInputBuffer = this.ieT.dequeueInputBuffer(100);
                this.jtj = dequeueInputBuffer;
                if (dequeueInputBuffer < 0) {
                    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "video no input available, drain first");
                    aMn();
                }
                if (this.ieT == null) {
                    Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
                    AppMethodBeat.o(89592);
                    return;
                }
                Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "inputBufferIndex: %s", Integer.valueOf(this.jtj));
                long currentTicks2 = Util.currentTicks();
                if (this.jtj >= 0) {
                    long nanoTime = ((System.nanoTime() - ((((long) bArr.length) * 1000000000) / 1600000)) - (this.zvN != null ? this.zvN.ekh() : this.startTime)) / 1000;
                    if (nanoTime < 0 && this.zwc <= 0) {
                        this.zwc = -nanoTime;
                    }
                    long j2 = nanoTime + this.zwc;
                    Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "presentationTime: ".concat(String.valueOf(j2)));
                    ByteBuffer byteBuffer = this.btv[this.jtj];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    if (!this.isStart || z) {
                        Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "end of stream");
                        this.jtl = true;
                        this.ieT.a(this.jtj, bArr.length, j2, 4);
                    } else {
                        this.ieT.a(this.jtj, bArr.length, j2, 0);
                    }
                } else {
                    Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "input buffer not available");
                }
                aMn();
                Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder used %sms %sms", Long.valueOf(Util.ticksToNow(currentTicks)), Long.valueOf(Util.ticksToNow(currentTicks2)));
                AppMethodBeat.o(89592);
            }
        } catch (Exception e2) {
            l.aNK();
            Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData error: %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecRecorder", e2, "", new Object[0]);
            AppMethodBeat.o(89592);
        }
    }

    private void aMn() {
        AppMethodBeat.i(89593);
        this.jtk = this.ieT.dequeueOutputBuffer(this.bufferInfo, 100);
        Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "outputBufferIndex-->" + this.jtk);
        while (true) {
            if (this.jtk == -1) {
                Log.d("MicroMsg.MMSightYUVMediaCodecRecorder", "no output from encoder available, break encoderEndStream %s", Boolean.valueOf(this.jtl));
                if (!this.jtl) {
                    break;
                }
            } else if (this.jtk == -3) {
                this.bfQ = this.ieT.getOutputBuffers();
                Log.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output buffers changed");
            } else if (this.jtk == -2) {
                MediaFormat outputFormat = this.ieT.getOutputFormat();
                Log.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(outputFormat)));
                if (this.zvN != null) {
                    this.zvN.g(outputFormat);
                }
            } else if (this.jtk < 0) {
                Log.w("MicroMsg.MMSightYUVMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.jtk);
            } else {
                Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "perform encoding");
                ByteBuffer byteBuffer = this.bfQ[this.jtk];
                if (byteBuffer == null) {
                    RuntimeException runtimeException = new RuntimeException("encoderOutputBuffer " + this.jtk + " was null");
                    AppMethodBeat.o(89593);
                    throw runtimeException;
                }
                this.frameCount++;
                if ((this.bufferInfo.flags & 2) != 0) {
                    Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", Integer.valueOf(this.bufferInfo.size), Boolean.FALSE);
                }
                if (this.bufferInfo.size != 0) {
                    if (this.zvN != null && !this.zvN.ekj()) {
                        this.zvN.g(this.ieT.getOutputFormat());
                    }
                    byteBuffer.position(this.bufferInfo.offset);
                    byteBuffer.limit(this.bufferInfo.offset + this.bufferInfo.size);
                    i(byteBuffer, this.bufferInfo);
                }
                this.ieT.releaseOutputBuffer(this.jtk, false);
                if ((this.bufferInfo.flags & 4) != 0) {
                    if (!this.dyL) {
                        Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "reached end of stream unexpectedly");
                        AppMethodBeat.o(89593);
                        return;
                    }
                    Log.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder");
                    aMi();
                    if (this.zwG != null) {
                        this.zwG.ejZ();
                        this.zwG = null;
                        AppMethodBeat.o(89593);
                        return;
                    }
                }
            }
            this.jtk = this.ieT.dequeueOutputBuffer(this.bufferInfo, 100);
            if (this.jtk <= 0) {
                Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "get outputBufferIndex %d", Integer.valueOf(this.jtk));
            }
            if (this.jtk < 0 && !this.jtl) {
                break;
            }
        }
        AppMethodBeat.o(89593);
    }

    /* access modifiers changed from: protected */
    public void i(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo2) {
        AppMethodBeat.i(89594);
        if (this.zvN != null && (bufferInfo2.flags & 4) == 0) {
            this.zvN.k(byteBuffer, bufferInfo2);
        }
        AppMethodBeat.o(89594);
    }

    public final void a(f.a aVar) {
        AppMethodBeat.i(89595);
        this.zwG = aVar;
        this.dyL = true;
        boolean ejV = this.zwF.ejV();
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "!!!stop, isStart!!: %s %s isEnd %s", Boolean.valueOf(this.isStart), this.zwG, Boolean.valueOf(ejV));
        if (ejV) {
            ekk();
        }
        AppMethodBeat.o(89595);
    }

    /* access modifiers changed from: package-private */
    public final void ekk() {
        AppMethodBeat.i(89596);
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stopImp %s  isStart:%b", Util.getStack().toString(), Boolean.valueOf(this.isStart));
        try {
            if (this.isStart) {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.mmsight.model.a.s.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(89587);
                        s.a(s.this);
                        if (s.this.zwG != null) {
                            s.this.zwG.ejZ();
                            s.this.zwG = null;
                        }
                        AppMethodBeat.o(89587);
                    }
                }, 500);
            }
            AppMethodBeat.o(89596);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "stop error: %s", e2.getMessage());
            AppMethodBeat.o(89596);
        }
    }

    public final long aMm() {
        AppMethodBeat.i(89597);
        if (this.startTime <= 0) {
            Log.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do not start record");
            AppMethodBeat.o(89597);
            return 0;
        }
        long nanoTime = (System.nanoTime() - this.startTime) / TimeUtil.SECOND_TO_US;
        AppMethodBeat.o(89597);
        return nanoTime;
    }

    public void clear() {
        AppMethodBeat.i(89598);
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "clear");
        aMi();
        AppMethodBeat.o(89598);
    }

    private void aMi() {
        AppMethodBeat.i(89599);
        if (this.zvR) {
            ekl();
            AppMethodBeat.o(89599);
            return;
        }
        synchronized (this.iff) {
            try {
                if (!this.zvP && 0 != this.startTime) {
                    this.zvP = true;
                    ekl();
                    AppMethodBeat.o(89599);
                }
            } finally {
                AppMethodBeat.o(89599);
            }
        }
    }

    private void ekl() {
        AppMethodBeat.i(89600);
        try {
            if (this.zwF != null) {
                this.zwF.stop();
            }
            if (this.ieT != null) {
                Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stop encoder");
                this.ieT.stop();
                this.ieT.release();
                this.isStart = false;
                this.ieT = null;
            }
            AppMethodBeat.o(89600);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "clear error: %s", e2.getMessage());
            AppMethodBeat.o(89600);
        }
    }
}
