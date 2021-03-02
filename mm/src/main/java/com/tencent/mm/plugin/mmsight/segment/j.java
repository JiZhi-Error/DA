package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

@TargetApi(21)
public final class j extends i {
    public static String TAG = "MicroMsg.MediaCodecTranscodeDecoder21";

    public j(c cVar, MediaFormat mediaFormat, int i2) {
        super(cVar, mediaFormat, i2);
        AppMethodBeat.i(107676);
        Log.i(TAG, "init ");
        AppMethodBeat.o(107676);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mmsight.segment.i
    public final int selectColorFormat(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(107677);
        Log.i(TAG, "selectColorFormat, mimeType: %s, codecInfo: %s", str, mediaCodecInfo);
        long currentTicks = Util.currentTicks();
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        Log.i(TAG, "getCapabilitiesForType used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        Log.i(TAG, "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i2 = 0;
        for (int i3 = 0; i3 < capabilitiesForType.colorFormats.length; i3++) {
            int i4 = capabilitiesForType.colorFormats[i3];
            Log.i(TAG, "capabilities colorFormat: %s", Integer.valueOf(i4));
            if (isRecognizedFormat(i4) && (i4 > i2 || i4 == 2135033992)) {
                i2 = i4;
            }
        }
        Log.i(TAG, "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i2));
        AppMethodBeat.o(107677);
        return i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mmsight.segment.i
    public final boolean isRecognizedFormat(int i2) {
        switch (i2) {
            case 2135033992:
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mmsight.segment.i
    public final boolean aMg() {
        AppMethodBeat.i(107678);
        if (this.iec == null) {
            Log.e(TAG, "drainDecoder, decoder is null");
            AppMethodBeat.o(107678);
            return true;
        }
        int dequeueOutputBuffer = this.iec.dequeueOutputBuffer(this.bufferInfo, Util.MILLSECONDS_OF_MINUTE);
        Log.i(TAG, "outputBufferIndex-->".concat(String.valueOf(dequeueOutputBuffer)));
        while (true) {
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -3) {
                    Log.i(TAG, "decoder output buffers changed");
                } else if (dequeueOutputBuffer == -2) {
                    this.jtq = this.iec.getOutputFormat();
                    Log.i(TAG, "decoder output format changed: " + this.jtq);
                } else if (dequeueOutputBuffer < 0) {
                    Log.w(TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
                } else {
                    Log.v(TAG, "perform decoding");
                    long currentTicks = Util.currentTicks();
                    byte[] b2 = b(this.iec.getOutputImage(dequeueOutputBuffer));
                    Log.v(TAG, "perform decoding costImage %s", Long.valueOf(Util.ticksToNow(currentTicks)));
                    if (b2 == null) {
                        break;
                    } else if (b2.length != 0) {
                        MediaCodec.BufferInfo bufferInfo = this.bufferInfo;
                        if (b2 == null) {
                            Log.e(TAG, "processDecodeOutputBuffer error! byteBuffer is null");
                        } else {
                            Log.i(TAG, "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d", b2, bufferInfo, Integer.valueOf(bufferInfo.size));
                            this.jtq = this.iec.getOutputFormat();
                            if (this.zxX != null) {
                                this.zxX.bJ(b2);
                            }
                        }
                        this.iec.releaseOutputBuffer(dequeueOutputBuffer, false);
                        long j2 = this.bufferInfo.presentationTimeUs;
                        if (this.endTimeMs != 1 && j2 >= this.endTimeMs * 1000) {
                            Log.e(TAG, "exceed endTimeMs");
                            AppMethodBeat.o(107678);
                            return true;
                        } else if ((this.bufferInfo.flags & 4) != 0) {
                            Log.i(TAG, "receive end of stream");
                            try {
                                this.iec.stop();
                                this.iec.release();
                                this.iec = null;
                            } catch (Exception e2) {
                                Log.e(TAG, "stop and release decoder error: %s", e2.getMessage());
                            }
                            AppMethodBeat.o(107678);
                            return true;
                        } else {
                            AppMethodBeat.o(107678);
                            return false;
                        }
                    } else {
                        this.iec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    }
                }
                dequeueOutputBuffer = this.iec.dequeueOutputBuffer(this.bufferInfo, Util.MILLSECONDS_OF_MINUTE);
                if (dequeueOutputBuffer < 0) {
                    break;
                }
            } else {
                Log.i(TAG, "no output from decoder available, break");
                break;
            }
        }
        AppMethodBeat.o(107678);
        return false;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.i, com.tencent.mm.plugin.mmsight.segment.e
    public final int bhK() {
        return 2;
    }

    private static byte[] b(Image image) {
        AppMethodBeat.i(107679);
        int format = image.getFormat();
        int width = image.getWidth();
        int height = image.getHeight();
        int i2 = 0;
        Image.Plane[] planes = image.getPlanes();
        int bitsPerPixel = ((width * height) * ImageFormat.getBitsPerPixel(format)) / 8;
        Log.i(TAG, "planes len %d, datalen: %s width %d height %d format %d", Integer.valueOf(planes.length), Integer.valueOf(bitsPerPixel), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(format));
        byte[] h2 = k.zwi.h(Integer.valueOf(bitsPerPixel));
        int i3 = 0;
        while (i3 < planes.length) {
            ByteBuffer buffer = planes[i3].getBuffer();
            int rowStride = planes[i3].getRowStride();
            int pixelStride = planes[i3].getPixelStride();
            int i4 = i3 == 0 ? width : width / 2;
            int i5 = i3 == 0 ? height : height / 2;
            Log.v(TAG, "row planes rowStride %d w %d h %d pixelStride %d", Integer.valueOf(rowStride), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(pixelStride));
            byte[] h3 = k.zwi.h(Integer.valueOf(rowStride));
            for (int i6 = 0; i6 < i5; i6++) {
                int bitsPerPixel2 = ImageFormat.getBitsPerPixel(35) / 8;
                if (pixelStride == bitsPerPixel2) {
                    int i7 = bitsPerPixel2 * i4;
                    buffer.get(h2, i2, i7);
                    if (i5 - i6 != 1) {
                        buffer.position((buffer.position() + rowStride) - i7);
                    }
                    i2 += i7;
                } else {
                    if (i5 - i6 == 1) {
                        buffer.get(h3, 0, (width - pixelStride) + 1);
                    } else {
                        buffer.get(h3, 0, rowStride);
                    }
                    int i8 = 0;
                    while (i8 < i4) {
                        h2[i2] = h3[i8 * pixelStride];
                        i8++;
                        i2++;
                    }
                }
            }
            k.zwi.k(h3);
            i3++;
        }
        AppMethodBeat.o(107679);
        return h2;
    }
}
