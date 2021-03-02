package com.tencent.mm.bk;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

public final class c {
    private ByteBuffer[] bfQ;
    private int bitrate = 0;
    private ByteBuffer[] btv;
    protected int bufId = -1;
    private MediaCodec.BufferInfo bufferInfo;
    private int colorFormat;
    private boolean dyL = false;
    private int frameCount;
    private int frameRate;
    private int idB;
    protected z ieT;
    boolean isStart = false;
    a jth;
    private int jti;
    private int jtj = -1;
    private int jtk = -1;
    private boolean jtl = false;
    private byte[] jtm;
    private int jtn;
    protected MediaFormat mediaFormat;
    private int targetHeight;
    private int targetWidth;

    public interface a {
        void a(int i2, ByteBuffer byteBuffer, int i3);
    }

    private void i(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo2) {
        AppMethodBeat.i(127066);
        if (!(byteBuffer == null || bufferInfo2 == null || this.jth == null)) {
            this.jth.a(this.bufId, byteBuffer, bufferInfo2.size);
        }
        AppMethodBeat.o(127066);
    }

    public c(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(127067);
        Log.i("MicroMsg.MediaCodecTransCodeEncoder", "create MediaCodecTransCodeEncoder, init targetWidth: %d, targetHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.targetWidth = i2;
        this.targetHeight = i3;
        this.frameRate = i5;
        this.idB = 1;
        this.bufferInfo = new MediaCodec.BufferInfo();
        this.bitrate = i4;
        Log.i("MicroMsg.MediaCodecTransCodeEncoder", "create MMSightRemuxMediaCodecEncoder, targetWidth: %s, targetHeight: %s, bitrate: %s", Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight), Integer.valueOf(i4));
        AppMethodBeat.o(127067);
    }

    public final int ug(int i2) {
        AppMethodBeat.i(127068);
        try {
            this.bufId = i2;
            int bhL = bhL();
            AppMethodBeat.o(127068);
            return bhL;
        } catch (Exception e2) {
            Log.e("MicroMsg.MediaCodecTransCodeEncoder", "init error: %s, try to re-init again", e2.getMessage());
            try {
                int bhL2 = bhL();
                AppMethodBeat.o(127068);
                return bhL2;
            } catch (Exception e3) {
                Log.e("MicroMsg.MediaCodecTransCodeEncoder", "re-init again error: %s", e3.getMessage());
                AppMethodBeat.o(127068);
                return -1;
            }
        }
    }

    private int bhL() {
        AppMethodBeat.i(127069);
        long currentTicks = Util.currentTicks();
        MediaCodecInfo selectCodec = selectCodec("video/avc");
        if (selectCodec == null) {
            Log.e("MicroMsg.MediaCodecTransCodeEncoder", "Unable to find an appropriate codec for video/avc");
            AppMethodBeat.o(127069);
            return -1;
        }
        Log.i("MicroMsg.MediaCodecTransCodeEncoder", "found codec: %s, used %sms", selectCodec.getName(), Long.valueOf(Util.ticksToNow(currentTicks)));
        long currentTicks2 = Util.currentTicks();
        this.colorFormat = selectColorFormat(selectCodec, "video/avc");
        Log.i("MicroMsg.MediaCodecTransCodeEncoder", "found colorFormat: %s, used %sms", Integer.valueOf(this.colorFormat), Long.valueOf(Util.ticksToNow(currentTicks2)));
        if (this.colorFormat == 19) {
            this.jtn = 2;
        } else {
            this.jtn = 1;
        }
        long currentTicks3 = Util.currentTicks();
        this.mediaFormat = MediaFormat.createVideoFormat("video/avc", this.targetWidth, this.targetHeight);
        Log.i("MicroMsg.MediaCodecTransCodeEncoder", "createVideoFormat used %sms", Long.valueOf(Util.ticksToNow(currentTicks3)));
        if (selectCodec != null) {
            trySetProfile(selectCodec);
            trySetBitRateMode(selectCodec);
        }
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.mediaFormat.setInteger("frame-rate", this.frameRate);
        this.mediaFormat.setInteger("color-format", this.colorFormat);
        this.mediaFormat.setInteger("i-frame-interval", this.idB);
        Log.i("MicroMsg.MediaCodecTransCodeEncoder", "mediaFormat: %s", this.mediaFormat);
        this.ieT = z.Eb(selectCodec.getName());
        this.ieT.a(this.mediaFormat, (Surface) null, 1);
        this.ieT.start();
        AppMethodBeat.o(127069);
        return 0;
    }

    private void trySetProfile(MediaCodecInfo mediaCodecInfo) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        AppMethodBeat.i(127070);
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
                        Log.i("MicroMsg.MediaCodecTransCodeEncoder", "profile: %s, level: %s", Integer.valueOf(i2), Integer.valueOf(i3));
                        if (isRecognizedProfile(i2) && i2 >= codecProfileLevel.profile && i3 >= codecProfileLevel.level) {
                            codecProfileLevel.profile = i2;
                            codecProfileLevel.level = i3;
                        }
                    }
                    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                    if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                        this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                        this.mediaFormat.setInteger("level", 256);
                    }
                }
                AppMethodBeat.o(127070);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetProfile error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(127070);
    }

    private void trySetBitRateMode(MediaCodecInfo mediaCodecInfo) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        MediaCodecInfo.EncoderCapabilities encoderCapabilities;
        AppMethodBeat.i(127071);
        try {
            if (!(!d.oD(21) || (capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc")) == null || (encoderCapabilities = capabilitiesForType.getEncoderCapabilities()) == null)) {
                if (encoderCapabilities.isBitrateModeSupported(2)) {
                    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "support cbr bitrate mode");
                    this.mediaFormat.setInteger("bitrate-mode", 2);
                    AppMethodBeat.o(127071);
                    return;
                } else if (encoderCapabilities.isBitrateModeSupported(0)) {
                    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "support cq bitrate mode");
                    this.mediaFormat.setInteger("bitrate-mode", 0);
                    AppMethodBeat.o(127071);
                    return;
                } else {
                    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "both cbr and cq bitrate mode not support!");
                }
            }
            AppMethodBeat.o(127071);
        } catch (Exception e2) {
            Log.e("MicroMsg.MediaCodecTransCodeEncoder", "trySetBitRateMode error: %s", e2.getMessage());
            AppMethodBeat.o(127071);
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

    public final void a(byte[] bArr, int i2, int i3, int i4, int i5, boolean z, long j2, int i6) {
        boolean z2;
        AppMethodBeat.i(127072);
        if (z || bArr == null) {
            b(this.jtm, true, j2);
            AppMethodBeat.o(127072);
            return;
        }
        if (i4 == this.targetWidth && i5 == this.targetHeight) {
            z2 = false;
        } else {
            z2 = true;
        }
        Log.d("MicroMsg.MediaCodecTransCodeEncoder", "writeData, needScale: %s, srcSize: [%s, %s] [%s, %s], targetSize: [%s, %s], pts: %s, srcColorFormat: %s, dstColorFormat: %s, data.size:%s", Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight), Long.valueOf(j2), Integer.valueOf(i6), Integer.valueOf(this.jtn), Integer.valueOf(bArr.length));
        if (this.jtm == null) {
            this.jtm = new byte[(((this.targetWidth * this.targetHeight) * 3) >> 1)];
        }
        if (this.jtm.length != bArr.length) {
            this.jtm = new byte[bArr.length];
        }
        if (this.colorFormat != 19 || z2) {
            MP4MuxerJNI.yuv420pTo420XXAndScaleLock(bArr, i6, this.jtm, this.jtn, i2, i3, i4, i5, this.targetWidth, this.targetHeight);
        } else {
            System.arraycopy(bArr, 0, this.jtm, 0, bArr.length);
        }
        this.jti++;
        b(this.jtm, false, j2);
        AppMethodBeat.o(127072);
    }

    private void b(byte[] bArr, boolean z, long j2) {
        AppMethodBeat.i(127073);
        try {
            if (!this.isStart) {
                Log.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData, not start!");
                AppMethodBeat.o(127073);
            } else if (this.ieT == null) {
                Log.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
                AppMethodBeat.o(127073);
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
                    Log.i("MicroMsg.MediaCodecTransCodeEncoder", "video no input available, drain first");
                    aMn();
                    i2++;
                }
                if (this.ieT == null) {
                    Log.e("MicroMsg.MediaCodecTransCodeEncoder", "encoder is null");
                    AppMethodBeat.o(127073);
                    return;
                }
                Log.v("MicroMsg.MediaCodecTransCodeEncoder", "inputBufferIndex: %s", Integer.valueOf(this.jtj));
                long currentTicks2 = Util.currentTicks();
                if (this.jtj < 0) {
                    Log.v("MicroMsg.MediaCodecTransCodeEncoder", "input buffer not available");
                } else if (!this.isStart || z || bArr == null) {
                    Log.v("MicroMsg.MediaCodecTransCodeEncoder", "end of stream");
                    this.jtl = true;
                    this.ieT.a(this.jtj, 0, j2, 4);
                    this.dyL = true;
                } else {
                    Log.v("MicroMsg.MediaCodecTransCodeEncoder", "presentationTime: ".concat(String.valueOf(j2)));
                    ByteBuffer byteBuffer = this.btv[this.jtj];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    this.ieT.a(this.jtj, bArr.length, j2, 0);
                }
                aMn();
                Log.v("MicroMsg.MediaCodecTransCodeEncoder", "encoder used %sms %sms", Long.valueOf(Util.ticksToNow(currentTicks)), Long.valueOf(Util.ticksToNow(currentTicks2)));
                AppMethodBeat.o(127073);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.MediaCodecTransCodeEncoder", "writeData error: %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.MediaCodecTransCodeEncoder", e2, "", new Object[0]);
            AppMethodBeat.o(127073);
        }
    }

    private void aMn() {
        AppMethodBeat.i(127074);
        this.jtk = this.ieT.dequeueOutputBuffer(this.bufferInfo, 600);
        Log.v("MicroMsg.MediaCodecTransCodeEncoder", "outputBufferIndex-->" + this.jtk);
        while (true) {
            if (this.jtk == -1) {
                Log.d("MicroMsg.MediaCodecTransCodeEncoder", "no output from encoder available, break encoderEndStream %s", Boolean.valueOf(this.jtl));
                if (!this.jtl) {
                    break;
                }
            } else if (this.jtk == -3) {
                this.bfQ = this.ieT.getOutputBuffers();
                Log.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output buffers changed");
            } else if (this.jtk == -2) {
                Log.d("MicroMsg.MediaCodecTransCodeEncoder", "encoder output format changed: ".concat(String.valueOf(this.ieT.getOutputFormat())));
            } else if (this.jtk < 0) {
                Log.w("MicroMsg.MediaCodecTransCodeEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.jtk);
            } else {
                Log.v("MicroMsg.MediaCodecTransCodeEncoder", "perform encoding");
                ByteBuffer byteBuffer = this.bfQ[this.jtk];
                if (byteBuffer == null) {
                    RuntimeException runtimeException = new RuntimeException("encoderOutputBuffer " + this.jtk + " was null");
                    AppMethodBeat.o(127074);
                    throw runtimeException;
                }
                this.frameCount++;
                if ((this.bufferInfo.flags & 2) != 0) {
                    Log.v("MicroMsg.MediaCodecTransCodeEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", Integer.valueOf(this.bufferInfo.size), Boolean.FALSE);
                }
                if (this.bufferInfo.size != 0) {
                    byteBuffer.position(this.bufferInfo.offset);
                    byteBuffer.limit(this.bufferInfo.offset + this.bufferInfo.size);
                    i(byteBuffer, this.bufferInfo);
                }
                this.ieT.releaseOutputBuffer(this.jtk, false);
                if ((this.bufferInfo.flags & 4) != 0) {
                    if (!this.dyL) {
                        Log.e("MicroMsg.MediaCodecTransCodeEncoder", "reached end of stream unexpectedly");
                        AppMethodBeat.o(127074);
                        return;
                    }
                    Log.w("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", Integer.valueOf(this.frameCount), Integer.valueOf(this.jti));
                    try {
                        this.ieT.stop();
                        this.ieT.release();
                        this.ieT = null;
                        this.isStart = false;
                        AppMethodBeat.o(127074);
                        return;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.MediaCodecTransCodeEncoder", "do stop encoder error: %s", e2.getMessage());
                        AppMethodBeat.o(127074);
                        return;
                    }
                }
            }
            this.jtk = this.ieT.dequeueOutputBuffer(this.bufferInfo, 600);
            if (this.jtk <= 0) {
                Log.v("MicroMsg.MediaCodecTransCodeEncoder", "get outputBufferIndex %d", Integer.valueOf(this.jtk));
            }
            if (this.jtk < 0 && !this.jtl) {
                break;
            }
        }
        AppMethodBeat.o(127074);
    }

    private static int selectColorFormat(MediaCodecInfo mediaCodecInfo, String str) {
        int i2;
        AppMethodBeat.i(127075);
        long currentTicks = Util.currentTicks();
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        Log.i("MicroMsg.MediaCodecTransCodeEncoder", "getCapabilitiesForType used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        Log.i("MicroMsg.MediaCodecTransCodeEncoder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= capabilitiesForType.colorFormats.length) {
                i2 = i4;
                break;
            }
            i2 = capabilitiesForType.colorFormats[i3];
            Log.i("MicroMsg.MediaCodecTransCodeEncoder", "capabilities colorFormat: %s", Integer.valueOf(i2));
            if (isRecognizedFormat(i2) && i2 > i4) {
                if (i2 == 21) {
                    break;
                }
                i4 = i2;
            }
            i3++;
        }
        Log.i("MicroMsg.MediaCodecTransCodeEncoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i2));
        AppMethodBeat.o(127075);
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
        AppMethodBeat.i(127076);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        AppMethodBeat.o(127076);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(127076);
        return null;
    }
}
