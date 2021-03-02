package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.tav.decoder.EncoderWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class g {
    private long endTimeMs;
    MediaFormat ieU;
    VideoTransPara jtV;
    private c jto;
    MediaFormat jtq;
    String mime = null;
    private long startTimeMs;
    z zyo;
    z zyp;
    boolean zyq = true;
    List<byte[]> zyr = null;
    private boolean zys = false;
    private boolean zyt = false;
    private byte[] zyu;
    private HandlerThread zyv = null;
    private MMHandler zyw = null;

    public g(c cVar, MediaFormat mediaFormat, long j2, long j3, VideoTransPara videoTransPara) {
        AppMethodBeat.i(107645);
        this.jto = cVar;
        this.jtq = mediaFormat;
        this.startTimeMs = j2;
        this.endTimeMs = j3;
        this.jtV = videoTransPara;
        this.mime = mediaFormat.getString("mime");
        this.zyr = new ArrayList();
        Log.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", Long.valueOf(j2), Long.valueOf(j3), this.mime, mediaFormat, videoTransPara);
        AppMethodBeat.o(107645);
    }

    public final void eku() {
        boolean z;
        AppMethodBeat.i(107646);
        this.zys = false;
        this.zyt = false;
        while (this.zyo != null && this.jto != null) {
            try {
                ByteBuffer[] inputBuffers = this.zyo.getInputBuffers();
                int dequeueInputBuffer = this.zyo.dequeueInputBuffer(20000);
                if (dequeueInputBuffer < 0) {
                    Log.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
                    aMe();
                }
                if (dequeueInputBuffer >= 0) {
                    Log.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", Integer.valueOf(dequeueInputBuffer));
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.position(0);
                    int readSampleData = this.jto.readSampleData(byteBuffer, 0);
                    long sampleTime = this.jto.gLF.getSampleTime();
                    this.jto.gLF.advance();
                    Log.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", Integer.valueOf(readSampleData), Long.valueOf(sampleTime));
                    if (sampleTime >= this.endTimeMs * 1000 || sampleTime <= 0 || readSampleData <= 0) {
                        Log.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
                        this.zyt = true;
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.mmsight.segment.g.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(107643);
                                try {
                                    if (g.this.zyo != null) {
                                        Log.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                                        g.this.zyo.stop();
                                        g.this.zyo.release();
                                        g.this.zyo = null;
                                    }
                                    AppMethodBeat.o(107643);
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.MediaCodecAACTranscoder", "delayStopDecoder error: %s", e2.getMessage());
                                    AppMethodBeat.o(107643);
                                }
                            }
                        }, 500);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.zyo == null) {
                        AppMethodBeat.o(107646);
                        return;
                    } else if (z) {
                        Log.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
                        this.zyo.a(dequeueInputBuffer, readSampleData, sampleTime, 4);
                    } else {
                        this.zyo.a(dequeueInputBuffer, readSampleData, sampleTime, 0);
                    }
                }
                aMe();
                if (this.zyt && this.zyp == null) {
                    AppMethodBeat.o(107646);
                    return;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e2, "startTranscodeBlockLoop error: %s", e2.getMessage());
                AppMethodBeat.o(107646);
                return;
            }
        }
        Log.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
        AppMethodBeat.o(107646);
    }

    private void aMe() {
        AppMethodBeat.i(107647);
        if (this.zyo == null) {
            AppMethodBeat.o(107647);
            return;
        }
        try {
            ByteBuffer[] outputBuffers = this.zyo.getOutputBuffers();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            ByteBuffer[] byteBufferArr = outputBuffers;
            while (true) {
                int dequeueOutputBuffer = this.zyo.dequeueOutputBuffer(bufferInfo, 20000);
                Log.d("MicroMsg.MediaCodecAACTranscoder", "decoderOutputBufferIndex: %s", Integer.valueOf(dequeueOutputBuffer));
                if (dequeueOutputBuffer == -1) {
                    Log.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
                    AppMethodBeat.o(107647);
                    return;
                } else if (dequeueOutputBuffer == -3) {
                    byteBufferArr = this.zyo.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    this.jtq = this.zyo.getOutputFormat();
                    Log.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", this.jtq);
                } else if (dequeueOutputBuffer < 0) {
                    Log.e("MicroMsg.MediaCodecAACTranscoder", "unexpected decoderOutputBufferIndex: %s", Integer.valueOf(dequeueOutputBuffer));
                } else {
                    Log.v("MicroMsg.MediaCodecAACTranscoder", "perform decoding");
                    ByteBuffer byteBuffer = byteBufferArr[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        Log.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve decoderOutputBuffer is null!!");
                        AppMethodBeat.o(107647);
                        return;
                    }
                    if ((bufferInfo.flags & 2) != 0) {
                        Log.e("MicroMsg.MediaCodecAACTranscoder", "ignore BUFFER_FLAG_CODEC_CONFIG");
                        bufferInfo.size = 0;
                    }
                    if (bufferInfo.size > 0) {
                        byteBuffer.position(bufferInfo.offset);
                        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        a(byteBuffer, bufferInfo, (bufferInfo.flags & 4) != 0);
                    }
                    this.zyo.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((bufferInfo.flags & 4) != 0) {
                        Log.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
                        if (this.zyo != null) {
                            this.zyo.stop();
                            this.zyo.release();
                            this.zyo = null;
                            AppMethodBeat.o(107647);
                            return;
                        }
                        AppMethodBeat.o(107647);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e2, "drainDecoder error: %s", e2.getMessage());
            AppMethodBeat.o(107647);
        }
    }

    private void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, boolean z) {
        AppMethodBeat.i(107648);
        if (byteBuffer == null) {
            AppMethodBeat.o(107648);
            return;
        }
        Log.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", Boolean.valueOf(z), Boolean.valueOf(this.zyt));
        if (this.zyq) {
            if (!this.zys) {
                ekv();
                this.zys = true;
            }
            if (this.zyu == null) {
                this.zyu = new byte[byteBuffer.remaining()];
                byteBuffer.get(this.zyu, 0, byteBuffer.remaining());
            }
            c(this.zyu, bufferInfo.presentationTimeUs, z);
            AppMethodBeat.o(107648);
            return;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr, 0, byteBuffer.remaining());
        this.zyr.add(bArr);
        if (this.zyt || z) {
            try {
                this.zyo.stop();
                this.zyo.release();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e2, "", new Object[0]);
            }
            ekv();
            this.zys = true;
            int i2 = 0;
            for (byte[] bArr2 : this.zyr) {
                c(bArr2, bufferInfo.presentationTimeUs, i2 >= this.zyr.size() - 1);
                i2++;
            }
        }
        AppMethodBeat.o(107648);
    }

    private void ekv() {
        AppMethodBeat.i(107649);
        if (this.zyp == null || !this.zyq || this.zys) {
            try {
                this.ieU = new MediaFormat();
                this.ieU.setString("mime", EncoderWriter.OUTPUT_AUDIO_MIME_TYPE);
                this.ieU.setInteger("aac-profile", 2);
                this.ieU.setInteger("sample-rate", this.jtV.audioSampleRate);
                this.ieU.setInteger("channel-count", 1);
                this.ieU.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.jtV.audioBitrate);
                this.ieU.setInteger("max-input-size", 16384);
                this.zyp = z.q(this.mime, false);
                this.zyp.a(this.ieU, (Surface) null, 1);
                this.zyp.start();
                Log.i("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, create new encoder");
                AppMethodBeat.o(107649);
            } catch (Exception e2) {
                Log.e("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, error: %s", e2.getMessage());
                AppMethodBeat.o(107649);
            }
        } else {
            this.zyo.start();
            AppMethodBeat.o(107649);
        }
    }

    private void c(byte[] bArr, long j2, boolean z) {
        boolean z2;
        AppMethodBeat.i(107650);
        if (this.zyp == null || bArr == null) {
            AppMethodBeat.o(107650);
            return;
        }
        ByteBuffer[] inputBuffers = this.zyp.getInputBuffers();
        int dequeueInputBuffer = this.zyp.dequeueInputBuffer(20000);
        if (dequeueInputBuffer < 0) {
            Log.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
            aMn();
        }
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.position(0);
            byteBuffer.put(bArr);
            if (z) {
                Log.i("MicroMsg.MediaCodecAACTranscoder", "last, send EOS and try delay stop encoder");
                z2 = true;
                ekw();
            } else {
                z2 = false;
            }
            if (this.zyp == null) {
                AppMethodBeat.o(107650);
                return;
            } else if (z2) {
                Log.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
                this.zyp.a(dequeueInputBuffer, bArr.length, j2, 4);
            } else {
                this.zyp.a(dequeueInputBuffer, bArr.length, j2, 0);
            }
        }
        aMn();
        AppMethodBeat.o(107650);
    }

    private void aMn() {
        AppMethodBeat.i(107651);
        if (this.zyp == null) {
            AppMethodBeat.o(107651);
            return;
        }
        try {
            ByteBuffer[] outputBuffers = this.zyp.getOutputBuffers();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            while (true) {
                int dequeueOutputBuffer = this.zyp.dequeueOutputBuffer(bufferInfo, 20000);
                Log.d("MicroMsg.MediaCodecAACTranscoder", "encoderOutputBufferIndex: %s", Integer.valueOf(dequeueOutputBuffer));
                if (dequeueOutputBuffer == -1) {
                    Log.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
                    AppMethodBeat.o(107651);
                    return;
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.zyp.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    this.ieU = this.zyp.getOutputFormat();
                    Log.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", this.ieU);
                } else if (dequeueOutputBuffer < 0) {
                    Log.e("MicroMsg.MediaCodecAACTranscoder", "unexpected encoderOutputBufferIndex: %s", Integer.valueOf(dequeueOutputBuffer));
                } else {
                    Log.v("MicroMsg.MediaCodecAACTranscoder", "perform encoding");
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        Log.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve encoderOutputBuffer is null!!");
                        AppMethodBeat.o(107651);
                        return;
                    }
                    if (bufferInfo.size > 0) {
                        byteBuffer.position(bufferInfo.offset);
                        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        l(byteBuffer, bufferInfo);
                    }
                    this.zyp.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((bufferInfo.flags & 4) != 0) {
                        Log.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
                        if (this.zyp != null) {
                            this.zyp.stop();
                            this.zyp.release();
                            this.zyp = null;
                            AppMethodBeat.o(107651);
                            return;
                        }
                        AppMethodBeat.o(107651);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e2, "drainEncoder error: %s", e2.getMessage());
            AppMethodBeat.o(107651);
        }
    }

    private static void l(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(107652);
        if (byteBuffer != null) {
            MP4MuxerJNI.writeAACData(0, byteBuffer, bufferInfo.size);
        }
        AppMethodBeat.o(107652);
    }

    private void ekw() {
        AppMethodBeat.i(107653);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.segment.g.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(107644);
                try {
                    if (g.this.zyp != null) {
                        Log.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
                        g.this.zyp.stop();
                        g.this.zyp.release();
                        g.this.zyp = null;
                    }
                    AppMethodBeat.o(107644);
                } catch (Exception e2) {
                    Log.e("MicroMsg.MediaCodecAACTranscoder", "delayStopEncoder error: %s", e2.getMessage());
                    AppMethodBeat.o(107644);
                }
            }
        }, 500);
        AppMethodBeat.o(107653);
    }
}
