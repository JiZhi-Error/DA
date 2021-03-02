package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

public final class e implements a {
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
    protected int videoTrackIndex = -1;
    protected h zxa;
    private boolean zxd = false;

    public e() {
        AppMethodBeat.i(89620);
        AppMethodBeat.o(89620);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.b.a
    public final int e(String str, long j2, long j3, int i2) {
        MediaCodecInfo mediaCodecInfo;
        boolean z;
        String[] supportedTypes;
        AppMethodBeat.i(89621);
        if (!Util.isNullOrNil(str)) {
            Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "initDecoder, srcFilePath: %s, startTime: %s, endTime: %s, videoFps: %s", str, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2));
            try {
                this.jto = new c();
                this.jto.setDataSource(str);
                int i3 = 0;
                while (true) {
                    if (i3 >= this.jto.gLF.getTrackCount()) {
                        break;
                    }
                    MediaFormat trackFormat = this.jto.getTrackFormat(i3);
                    if (trackFormat.getString("mime").toLowerCase().startsWith("video/")) {
                        this.videoTrackIndex = i3;
                        this.jtq = trackFormat;
                        break;
                    }
                    i3++;
                }
                if (this.videoTrackIndex < 0) {
                    AppMethodBeat.o(89621);
                    return -1;
                }
                this.jpU = str;
                this.startTimeMs = j2;
                this.endTimeMs = j3;
                this.jto.selectTrack(this.videoTrackIndex);
                String string = this.jtq.getString("mime");
                this.iec = z.DZ(string);
                int codecCount = MediaCodecList.getCodecCount();
                int i4 = 0;
                loop1:
                while (true) {
                    if (i4 >= codecCount) {
                        mediaCodecInfo = null;
                        break;
                    }
                    MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i4);
                    if (!codecInfoAt.isEncoder()) {
                        for (String str2 : codecInfoAt.getSupportedTypes()) {
                            if (str2.equalsIgnoreCase(string)) {
                                mediaCodecInfo = codecInfoAt;
                                break loop1;
                            }
                        }
                        continue;
                    }
                    i4++;
                }
                Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found codec: %s", mediaCodecInfo);
                if (mediaCodecInfo != null) {
                    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec name: %s", mediaCodecInfo.getName());
                    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", string, mediaCodecInfo);
                    int i5 = 0;
                    long currentTicks = Util.currentTicks();
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(string);
                    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "getCapabilitiesForType used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
                    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
                    for (int i6 = 0; i6 < capabilitiesForType.colorFormats.length; i6++) {
                        int i7 = capabilitiesForType.colorFormats[i6];
                        Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "capabilities colorFormat: %s", Integer.valueOf(i7));
                        switch (i7) {
                            case 19:
                            case 21:
                                z = true;
                                break;
                            case 20:
                            default:
                                z = false;
                                break;
                        }
                        if (z && (i7 > i5 || i7 == 21)) {
                            i5 = i7;
                        }
                    }
                    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i5));
                    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found colorFormat: %s", Integer.valueOf(i5));
                    this.jtq.setInteger("color-format", i5);
                }
                this.iec.a(this.jtq, (Surface) null, 0);
                this.iec.start();
                AppMethodBeat.o(89621);
                return 0;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", e2, "Init decoder failed : %s", e2.getMessage());
                AppMethodBeat.o(89621);
                return -1;
            }
        } else {
            AppMethodBeat.o(89621);
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.tencent.mm.compatible.i.c r14) {
        /*
        // Method dump skipped, instructions count: 247
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.model.b.e.a(com.tencent.mm.compatible.i.c):boolean");
    }

    private boolean aMg() {
        boolean z;
        AppMethodBeat.i(89623);
        if (this.iec == null) {
            Log.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "drainDecoder, decoder is null");
            AppMethodBeat.o(89623);
            return true;
        }
        ByteBuffer[] outputBuffers = this.iec.getOutputBuffers();
        Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderOutputByteBuffers length: %s", Integer.valueOf(outputBuffers.length));
        int dequeueOutputBuffer = this.iec.dequeueOutputBuffer(this.bufferInfo, Util.MILLSECONDS_OF_MINUTE);
        Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "outputBufferIndex-->".concat(String.valueOf(dequeueOutputBuffer)));
        while (true) {
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer != -2) {
                        if (dequeueOutputBuffer >= 0) {
                            Log.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "perform decoding");
                            ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                            if (byteBuffer == null) {
                                break;
                            }
                            long j2 = this.bufferInfo.presentationTimeUs;
                            if (j2 < this.startTimeMs * 1000 && (this.bufferInfo.flags & 4) == 0) {
                                this.iec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder pts: %s, not reach start: %s", Long.valueOf(j2), Long.valueOf(this.startTimeMs * 1000));
                                AppMethodBeat.o(89623);
                                return false;
                            } else if (this.bufferInfo.size != 0) {
                                byteBuffer.position(this.bufferInfo.offset);
                                byteBuffer.limit(this.bufferInfo.offset + this.bufferInfo.size);
                                long currentTicks = Util.currentTicks();
                                MediaCodec.BufferInfo bufferInfo2 = this.bufferInfo;
                                if (byteBuffer == null) {
                                    Log.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
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
                                            Log.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "get output format error");
                                        }
                                        byteBuffer.get(this.jtr, 0, byteBuffer.remaining());
                                        Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", byteBuffer, bufferInfo2, Integer.valueOf(bufferInfo2.size), Long.valueOf(Util.ticksToNow(currentTicks2)));
                                        if (this.zxa != null) {
                                            boolean z2 = this.endTimeMs != 1 && bufferInfo2.presentationTimeUs >= this.endTimeMs * 1000;
                                            h hVar = this.zxa;
                                            byte[] bArr = this.jtr;
                                            if (this.jtr == null || this.zxd || z2) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            hVar.a(bArr, z, bufferInfo2.presentationTimeUs / 1000);
                                        }
                                    }
                                }
                                Log.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer %s", Long.valueOf(Util.ticksToNow(currentTicks)));
                                this.iec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                if (this.endTimeMs != 1 && j2 >= this.endTimeMs * 1000) {
                                    Log.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "exceed endTimeMs");
                                    this.zxd = true;
                                    AppMethodBeat.o(89623);
                                    return true;
                                } else if ((this.bufferInfo.flags & 4) != 0) {
                                    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "receive end of stream");
                                    try {
                                        this.iec.stop();
                                        this.iec.release();
                                        this.zxd = true;
                                        this.iec = null;
                                    } catch (Exception e3) {
                                        Log.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "stop and release decoder error: %s", e3.getMessage());
                                    }
                                    AppMethodBeat.o(89623);
                                    return true;
                                } else {
                                    AppMethodBeat.o(89623);
                                    return false;
                                }
                            } else {
                                this.iec.releaseOutputBuffer(dequeueOutputBuffer, false);
                            }
                        } else {
                            Log.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
                        }
                    } else {
                        this.jtq = this.iec.getOutputFormat();
                        Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output format changed: " + this.jtq);
                    }
                } else {
                    outputBuffers = this.iec.getOutputBuffers();
                    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output buffers changed");
                }
                dequeueOutputBuffer = this.iec.dequeueOutputBuffer(this.bufferInfo, Util.MILLSECONDS_OF_MINUTE);
                if (dequeueOutputBuffer < 0) {
                    break;
                }
            } else {
                Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "no output from decoder available, break");
                break;
            }
        }
        AppMethodBeat.o(89623);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0068, code lost:
        if (aMg() == false) goto L_0x006a;
     */
    @Override // com.tencent.mm.plugin.mmsight.model.b.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ekm() {
        /*
        // Method dump skipped, instructions count: 192
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.model.b.e.ekm():void");
    }

    @Override // com.tencent.mm.plugin.mmsight.model.b.a
    public final void a(h hVar) {
        this.zxa = hVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.b.a
    public final int bhK() {
        AppMethodBeat.i(89625);
        int integer = this.jtq.getInteger("color-format");
        Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "src color format: %s", Integer.valueOf(integer));
        switch (integer) {
            case 19:
                AppMethodBeat.o(89625);
                return 2;
            case 21:
            case 2130706688:
                AppMethodBeat.o(89625);
                return 1;
            default:
                AppMethodBeat.o(89625);
                return 1;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.b.a
    public final Point bhJ() {
        AppMethodBeat.i(89626);
        Point point = new Point(this.jtq.getInteger("width"), this.jtq.getInteger("height"));
        AppMethodBeat.o(89626);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.b.a
    public final void uf(int i2) {
        AppMethodBeat.i(89627);
        Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "setFrameDropInterval: %s", Integer.valueOf(i2));
        this.ies = i2;
        AppMethodBeat.o(89627);
    }
}
