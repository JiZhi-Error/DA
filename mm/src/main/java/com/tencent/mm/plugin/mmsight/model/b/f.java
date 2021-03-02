package com.tencent.mm.plugin.mmsight.model.b;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

public final class f {
    private ByteBuffer[] bfQ;
    private int bitrate = 0;
    private ByteBuffer[] btv;
    protected int bufId = -1;
    private MediaCodec.BufferInfo bufferInfo;
    int colorFormat;
    private boolean dyL = false;
    int frameCount;
    private int frameRate;
    private int idB;
    protected z ieT;
    boolean isStart = false;
    int jti;
    private int jtj = -1;
    private int jtk = -1;
    private boolean jtl = false;
    byte[] jtm;
    int jtn;
    private int kxW;
    private int kxX;
    protected MediaFormat mediaFormat;
    int targetHeight;
    int targetWidth;
    a zxf;

    public interface a {
        void a(int i2, ByteBuffer byteBuffer, int i3);
    }

    private void i(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo2) {
        AppMethodBeat.i(89628);
        if (!(byteBuffer == null || bufferInfo2 == null || this.zxf == null)) {
            this.zxf.a(this.bufId, byteBuffer, bufferInfo2.size);
        }
        AppMethodBeat.o(89628);
    }

    public f(int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(89629);
        this.kxW = i2;
        this.kxX = i3;
        Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, init targetWidth: %d, targetHeight: %d", Integer.valueOf(i4), Integer.valueOf(i5));
        this.targetWidth = i4;
        this.targetHeight = i5;
        this.frameRate = i7;
        this.idB = 1;
        this.bufferInfo = new MediaCodec.BufferInfo();
        this.bitrate = i6;
        Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s", Integer.valueOf(this.kxW), Integer.valueOf(this.kxX), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight), Integer.valueOf(i6));
        AppMethodBeat.o(89629);
    }

    public final int ug(int i2) {
        AppMethodBeat.i(89630);
        try {
            this.bufId = i2;
            int bhL = bhL();
            AppMethodBeat.o(89630);
            return bhL;
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "init error: %s, try to re-init again", e2.getMessage());
            try {
                int bhL2 = bhL();
                AppMethodBeat.o(89630);
                return bhL2;
            } catch (Exception e3) {
                Log.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "re-init again error: %s", e3.getMessage());
                l.aNJ();
                AppMethodBeat.o(89630);
                return -1;
            }
        }
    }

    private int bhL() {
        AppMethodBeat.i(89631);
        long currentTicks = Util.currentTicks();
        MediaCodecInfo selectCodec = selectCodec("video/avc");
        if (selectCodec == null) {
            Log.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "Unable to find an appropriate codec for video/avc");
            l.aNJ();
            AppMethodBeat.o(89631);
            return -1;
        }
        Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found codec: %s, used %sms", selectCodec.getName(), Long.valueOf(Util.ticksToNow(currentTicks)));
        long currentTicks2 = Util.currentTicks();
        this.colorFormat = selectColorFormat(selectCodec, "video/avc");
        Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", Integer.valueOf(this.colorFormat), Long.valueOf(Util.ticksToNow(currentTicks2)));
        if (this.colorFormat == 19) {
            this.jtn = 2;
        } else {
            this.jtn = 1;
        }
        long currentTicks3 = Util.currentTicks();
        this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.targetWidth, this.targetHeight);
        Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", Long.valueOf(Util.ticksToNow(currentTicks3)));
        if (selectCodec != null) {
            trySetProfile(selectCodec);
            trySetBitRateMode(selectCodec);
        }
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.mediaFormat.setInteger("frame-rate", this.frameRate);
        this.mediaFormat.setInteger("color-format", this.colorFormat);
        this.mediaFormat.setInteger("i-frame-interval", this.idB);
        Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", this.mediaFormat);
        this.ieT = z.Eb(selectCodec.getName());
        this.ieT.a(this.mediaFormat, (Surface) null, 1);
        this.ieT.start();
        AppMethodBeat.o(89631);
        return 0;
    }

    private void trySetProfile(MediaCodecInfo mediaCodecInfo) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        AppMethodBeat.i(89632);
        if (d.oD(23)) {
            try {
                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                if (!(capabilitiesForType == null || (codecProfileLevelArr = capabilitiesForType.profileLevels) == null)) {
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel.level = 0;
                    codecProfileLevel.profile = 0;
                    for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                        int i2 = codecProfileLevel2.profile;
                        int i3 = codecProfileLevel2.level;
                        Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", Integer.valueOf(i2), Integer.valueOf(i3));
                        if (isRecognizedProfile(i2) && i2 >= codecProfileLevel.profile && i3 >= codecProfileLevel.level) {
                            codecProfileLevel.profile = i2;
                            codecProfileLevel.level = i3;
                        }
                    }
                    Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                    if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                        this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                        this.mediaFormat.setInteger("level", 256);
                    }
                }
                AppMethodBeat.o(89632);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetProfile error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(89632);
    }

    private void trySetBitRateMode(MediaCodecInfo mediaCodecInfo) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        MediaCodecInfo.EncoderCapabilities encoderCapabilities;
        AppMethodBeat.i(89633);
        try {
            if (!(!d.oD(21) || (capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc")) == null || (encoderCapabilities = capabilitiesForType.getEncoderCapabilities()) == null)) {
                if (encoderCapabilities.isBitrateModeSupported(2)) {
                    Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
                    this.mediaFormat.setInteger("bitrate-mode", 2);
                    AppMethodBeat.o(89633);
                    return;
                } else if (encoderCapabilities.isBitrateModeSupported(0)) {
                    Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
                    this.mediaFormat.setInteger("bitrate-mode", 0);
                    AppMethodBeat.o(89633);
                    return;
                } else {
                    Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
                }
            }
            AppMethodBeat.o(89633);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetBitRateMode error: %s", e2.getMessage());
            AppMethodBeat.o(89633);
        }
    }

    private static boolean isRecognizedProfile(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public final void b(byte[] bArr, boolean z, long j2) {
        AppMethodBeat.i(89634);
        try {
            if (!this.isStart) {
                Log.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, not start!");
                AppMethodBeat.o(89634);
            } else if (this.ieT == null) {
                Log.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
                AppMethodBeat.o(89634);
            } else {
                long currentTicks = Util.currentTicks();
                this.btv = this.ieT.getInputBuffers();
                this.bfQ = this.ieT.getOutputBuffers();
                int i2 = 0;
                while (this.ieT != null) {
                    int dequeueInputBuffer = this.ieT.dequeueInputBuffer(600);
                    this.jtj = dequeueInputBuffer;
                    if (dequeueInputBuffer >= 0 || i2 >= 10) {
                        break;
                    }
                    Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "video no input available, drain first");
                    aMn();
                    i2++;
                }
                if (this.ieT == null) {
                    Log.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
                    AppMethodBeat.o(89634);
                    return;
                }
                Log.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "inputBufferIndex: %s", Integer.valueOf(this.jtj));
                long currentTicks2 = Util.currentTicks();
                if (this.jtj < 0) {
                    Log.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "input buffer not available");
                } else if (!this.isStart || z || bArr == null) {
                    Log.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "end of stream");
                    this.jtl = true;
                    this.ieT.a(this.jtj, 0, j2, 4);
                    this.dyL = true;
                } else {
                    Log.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "presentationTime: ".concat(String.valueOf(j2)));
                    ByteBuffer byteBuffer = this.btv[this.jtj];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    this.ieT.a(this.jtj, bArr.length, j2, 0);
                }
                aMn();
                Log.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder used %sms %sms", Long.valueOf(Util.ticksToNow(currentTicks)), Long.valueOf(Util.ticksToNow(currentTicks2)));
                AppMethodBeat.o(89634);
            }
        } catch (Exception e2) {
            l.aNK();
            Log.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData error: %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecEncoder", e2, "", new Object[0]);
            AppMethodBeat.o(89634);
        }
    }

    private void aMn() {
        AppMethodBeat.i(89635);
        this.jtk = this.ieT.dequeueOutputBuffer(this.bufferInfo, 600);
        Log.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "outputBufferIndex-->" + this.jtk);
        while (true) {
            if (this.jtk == -1) {
                Log.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "no output from encoder available, break encoderEndStream %s", Boolean.valueOf(this.jtl));
                if (!this.jtl) {
                    break;
                }
            } else if (this.jtk == -3) {
                this.bfQ = this.ieT.getOutputBuffers();
                Log.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output buffers changed");
            } else if (this.jtk == -2) {
                Log.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output format changed: ".concat(String.valueOf(this.ieT.getOutputFormat())));
            } else if (this.jtk < 0) {
                Log.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.jtk);
            } else {
                Log.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "perform encoding");
                ByteBuffer byteBuffer = this.bfQ[this.jtk];
                if (byteBuffer == null) {
                    RuntimeException runtimeException = new RuntimeException("encoderOutputBuffer " + this.jtk + " was null");
                    AppMethodBeat.o(89635);
                    throw runtimeException;
                }
                this.frameCount++;
                if ((this.bufferInfo.flags & 2) != 0) {
                    Log.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", Integer.valueOf(this.bufferInfo.size), Boolean.FALSE);
                }
                if (this.bufferInfo.size != 0) {
                    byteBuffer.position(this.bufferInfo.offset);
                    byteBuffer.limit(this.bufferInfo.offset + this.bufferInfo.size);
                    i(byteBuffer, this.bufferInfo);
                }
                this.ieT.releaseOutputBuffer(this.jtk, false);
                if ((this.bufferInfo.flags & 4) != 0) {
                    if (!this.dyL) {
                        Log.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "reached end of stream unexpectedly");
                        AppMethodBeat.o(89635);
                        return;
                    }
                    Log.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", Integer.valueOf(this.frameCount), Integer.valueOf(this.jti));
                    try {
                        this.ieT.stop();
                        this.ieT.release();
                        this.ieT = null;
                        this.isStart = false;
                        AppMethodBeat.o(89635);
                        return;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder error: %s", e2.getMessage());
                        AppMethodBeat.o(89635);
                        return;
                    }
                }
            }
            this.jtk = this.ieT.dequeueOutputBuffer(this.bufferInfo, 600);
            if (this.jtk <= 0) {
                Log.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "get outputBufferIndex %d", Integer.valueOf(this.jtk));
            }
            if (this.jtk < 0 && !this.jtl) {
                break;
            }
        }
        AppMethodBeat.o(89635);
    }

    private static int selectColorFormat(MediaCodecInfo mediaCodecInfo, String str) {
        int i2;
        AppMethodBeat.i(89636);
        long currentTicks = Util.currentTicks();
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "getCapabilitiesForType used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= capabilitiesForType.colorFormats.length) {
                i2 = i4;
                break;
            }
            i2 = capabilitiesForType.colorFormats[i3];
            Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "capabilities colorFormat: %s", Integer.valueOf(i2));
            if (isRecognizedFormat(i2) && i2 > i4) {
                if (i2 == 19) {
                    break;
                }
                i4 = i2;
            }
            i3++;
        }
        Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i2));
        AppMethodBeat.o(89636);
        return i2;
    }

    private static boolean isRecognizedFormat(int i2) {
        switch (i2) {
            case 19:
            case 21:
            case 2130706688:
                return true;
            default:
                return false;
        }
    }

    private static MediaCodecInfo selectCodec(String str) {
        String[] supportedTypes;
        AppMethodBeat.i(89637);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        AppMethodBeat.o(89637);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(89637);
        return null;
    }
}
