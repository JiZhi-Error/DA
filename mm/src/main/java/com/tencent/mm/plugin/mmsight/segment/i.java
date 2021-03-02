package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.mmsight.segment.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

public class i implements e {
    protected MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    protected long endTimeMs;
    private int frameCount = 0;
    protected z iec;
    protected int ies;
    protected String jpU = null;
    protected c jto;
    protected MediaFormat jtq;
    private byte[] jtr;
    protected int sampleSize;
    protected long startTimeMs;
    protected int videoTrackIndex;
    protected e.a zxX;

    public i(c cVar, MediaFormat mediaFormat, int i2) {
        AppMethodBeat.i(107665);
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", cVar, mediaFormat, Integer.valueOf(i2));
        this.jto = cVar;
        this.jtq = mediaFormat;
        this.videoTrackIndex = i2;
        AppMethodBeat.o(107665);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public final int n(String str, long j2, long j3) {
        AppMethodBeat.i(107666);
        this.jpU = str;
        this.startTimeMs = j2;
        this.endTimeMs = j3;
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.jtq + "]");
        try {
            String string = this.jtq.getString("mime");
            this.iec = z.DZ(string);
            MediaCodecInfo selectCodec = selectCodec(string);
            Log.i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", selectCodec);
            if (selectCodec != null) {
                Log.i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", selectCodec.getName());
                int selectColorFormat = selectColorFormat(selectCodec, string);
                Log.i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", Integer.valueOf(selectColorFormat));
                this.jtq.setInteger("color-format", selectColorFormat);
            }
            this.iec.a(this.jtq, (Surface) null, 0);
            this.iec.start();
            AppMethodBeat.o(107666);
            return 0;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e2, "Init decoder failed : %s", e2.getMessage());
            AppMethodBeat.o(107666);
            return -1;
        }
    }

    private static MediaCodecInfo selectCodec(String str) {
        String[] supportedTypes;
        AppMethodBeat.i(107667);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (!codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        AppMethodBeat.o(107667);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(107667);
        return null;
    }

    /* access modifiers changed from: protected */
    public int selectColorFormat(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(107668);
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", str, mediaCodecInfo);
        long currentTicks = Util.currentTicks();
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i2 = 0;
        for (int i3 = 0; i3 < capabilitiesForType.colorFormats.length; i3++) {
            int i4 = capabilitiesForType.colorFormats[i3];
            Log.i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", Integer.valueOf(i4));
            if (isRecognizedFormat(i4) && (i4 > i2 || i4 == 21)) {
                i2 = i4;
            }
        }
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i2));
        AppMethodBeat.o(107668);
        return i2;
    }

    /* access modifiers changed from: protected */
    public boolean isRecognizedFormat(int i2) {
        switch (i2) {
            case 19:
            case 21:
                return true;
            case 20:
            default:
                return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.tencent.mm.compatible.i.c r14) {
        /*
        // Method dump skipped, instructions count: 247
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.i.a(com.tencent.mm.compatible.i.c):boolean");
    }

    /* access modifiers changed from: protected */
    public boolean aMg() {
        AppMethodBeat.i(107670);
        if (this.iec == null) {
            Log.e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
            AppMethodBeat.o(107670);
            return true;
        }
        ByteBuffer[] outputBuffers = this.iec.getOutputBuffers();
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", Integer.valueOf(outputBuffers.length));
        int dequeueOutputBuffer = this.iec.dequeueOutputBuffer(this.bufferInfo, Util.MILLSECONDS_OF_MINUTE);
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "outputBufferIndex-->".concat(String.valueOf(dequeueOutputBuffer)));
        while (true) {
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer != -2) {
                        if (dequeueOutputBuffer >= 0) {
                            Log.v("MicroMsg.MediaCodecTranscodeDecoder", "perform decoding");
                            ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                            if (byteBuffer == null) {
                                break;
                            }
                            long j2 = this.bufferInfo.presentationTimeUs;
                            if (j2 < this.startTimeMs * 1000 && (this.bufferInfo.flags & 4) == 0) {
                                this.iec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                Log.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", Long.valueOf(j2), Long.valueOf(this.startTimeMs * 1000));
                                AppMethodBeat.o(107670);
                                return false;
                            } else if (this.bufferInfo.size != 0) {
                                byteBuffer.position(this.bufferInfo.offset);
                                byteBuffer.limit(this.bufferInfo.offset + this.bufferInfo.size);
                                long currentTicks = Util.currentTicks();
                                MediaCodec.BufferInfo bufferInfo2 = this.bufferInfo;
                                if (byteBuffer == null) {
                                    Log.e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
                                } else {
                                    this.frameCount++;
                                    if (this.ies <= 1 || this.frameCount % this.ies != 0) {
                                        if (this.jtr == null) {
                                            this.jtr = new byte[byteBuffer.remaining()];
                                        }
                                        long currentTicks2 = Util.currentTicks();
                                        try {
                                            this.jtq = this.iec.getOutputFormat();
                                        } catch (Exception e2) {
                                            Log.e("MicroMsg.MediaCodecTranscodeDecoder", "get output format error");
                                        }
                                        byteBuffer.get(this.jtr, 0, byteBuffer.remaining());
                                        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", byteBuffer, bufferInfo2, Integer.valueOf(bufferInfo2.size), Long.valueOf(Util.ticksToNow(currentTicks2)));
                                        if (this.zxX != null) {
                                            this.zxX.bJ(this.jtr);
                                        }
                                    }
                                }
                                Log.v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", Long.valueOf(Util.ticksToNow(currentTicks)));
                                this.iec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                if (this.endTimeMs != 1 && j2 >= this.endTimeMs * 1000) {
                                    Log.e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
                                    AppMethodBeat.o(107670);
                                    return true;
                                } else if ((this.bufferInfo.flags & 4) != 0) {
                                    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "receive end of stream");
                                    try {
                                        this.iec.stop();
                                        this.iec.release();
                                        this.iec = null;
                                    } catch (Exception e3) {
                                        Log.e("MicroMsg.MediaCodecTranscodeDecoder", "stop and release decoder error: %s", e3.getMessage());
                                    }
                                    AppMethodBeat.o(107670);
                                    return true;
                                } else {
                                    AppMethodBeat.o(107670);
                                    return false;
                                }
                            } else {
                                this.iec.releaseOutputBuffer(dequeueOutputBuffer, false);
                            }
                        } else {
                            Log.w("MicroMsg.MediaCodecTranscodeDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
                        }
                    } else {
                        this.jtq = this.iec.getOutputFormat();
                        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.jtq);
                    }
                } else {
                    outputBuffers = this.iec.getOutputBuffers();
                    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
                }
                dequeueOutputBuffer = this.iec.dequeueOutputBuffer(this.bufferInfo, Util.MILLSECONDS_OF_MINUTE);
                if (dequeueOutputBuffer < 0) {
                    break;
                }
            } else {
                Log.i("MicroMsg.MediaCodecTranscodeDecoder", "no output from decoder available, break");
                break;
            }
        }
        AppMethodBeat.o(107670);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0066, code lost:
        if (aMg() == false) goto L_0x0068;
     */
    @Override // com.tencent.mm.plugin.mmsight.segment.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void J(java.lang.Runnable r11) {
        /*
        // Method dump skipped, instructions count: 184
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.i.J(java.lang.Runnable):void");
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public final void a(e.a aVar) {
        this.zxX = aVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public int bhK() {
        AppMethodBeat.i(107672);
        int integer = this.jtq.getInteger("color-format");
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "src color format: %s", Integer.valueOf(integer));
        switch (integer) {
            case 19:
                AppMethodBeat.o(107672);
                return 2;
            case 21:
            case 2130706688:
                AppMethodBeat.o(107672);
                return 1;
            default:
                AppMethodBeat.o(107672);
                return 1;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public final Point bhJ() {
        AppMethodBeat.i(107673);
        Point point = new Point(this.jtq.getInteger("width"), this.jtq.getInteger("height"));
        AppMethodBeat.o(107673);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public final void stop() {
        AppMethodBeat.i(107674);
        if (this.iec != null) {
            try {
                Log.i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
                this.iec.stop();
                this.iec.release();
                this.iec = null;
                AppMethodBeat.o(107674);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e2, "stop decoder error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(107674);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public final void uf(int i2) {
        AppMethodBeat.i(107675);
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "setFrameDropInterval: %s", Integer.valueOf(i2));
        this.ies = i2;
        AppMethodBeat.o(107675);
    }
}
