package com.tencent.mm.plugin.appbrand.media.record.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.appbrand.media.encode.M4aAudioFormatJni;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class a extends c {
    private final int TIMEOUT_USEC = 100;
    private String mFilePath = "";
    int neb = 2;
    private z nec;
    MediaCodec.BufferInfo ned;

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public final boolean i(String str, int i2, int i3, int i4) {
        boolean z;
        AppMethodBeat.i(146337);
        Log.i("MicroMsg.Record.AACAudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        this.mFilePath = str;
        try {
            Log.i("MicroMsg.Record.AACAudioEncoder", "initCodec");
            this.ned = new MediaCodec.BufferInfo();
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.nef, i2, i3);
            createAudioFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i4);
            createAudioFormat.setInteger("aac-profile", this.neb);
            this.nec = z.q(this.nef, false);
            this.nec.a(createAudioFormat, (Surface) null, 1);
            this.nec.start();
            Log.i("MicroMsg.Record.AACAudioEncoder", "encoder start to work");
            z = false;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", e2, "initCodec", new Object[0]);
            z = true;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", e3, "initCodec", new Object[0]);
            z = true;
        }
        if (z) {
            Log.i("MicroMsg.Record.AACAudioEncoder", "initCodec  fail,");
            j.yz(21);
            AppMethodBeat.o(146337);
            return false;
        }
        Log.i("MicroMsg.Record.AACAudioEncoder", "initCodec ok");
        if (M4aAudioFormatJni.createM4aFile(str, i3, i2, this.neb) == 0) {
            Log.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api ok,");
            AppMethodBeat.o(146337);
            return true;
        }
        Log.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api fail,");
        j.yz(22);
        AppMethodBeat.o(146337);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public final boolean a(boolean z, byte[] bArr, int i2) {
        AppMethodBeat.i(146338);
        if (bArr == null) {
            Log.e("MicroMsg.Record.AACAudioEncoder", "pcm is null");
            AppMethodBeat.o(146338);
            return false;
        } else if (this.nec != null) {
            Log.i("MicroMsg.Record.AACAudioEncoder", "encodePCMToAAC endOfStream:%b", Boolean.valueOf(z));
            ByteBuffer[] inputBuffers = this.nec.getInputBuffers();
            ByteBuffer[] outputBuffers = this.nec.getOutputBuffers();
            int dequeueInputBuffer = this.nec.dequeueInputBuffer(100);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                byteBuffer.position(0);
                byteBuffer.limit(bArr.length);
                Log.i("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex:%d, data length:%d", Integer.valueOf(dequeueInputBuffer), Integer.valueOf(bArr.length));
                if (z) {
                    this.nec.a(dequeueInputBuffer, bArr.length, System.nanoTime(), 4);
                } else {
                    this.nec.a(dequeueInputBuffer, bArr.length, System.nanoTime(), 0);
                }
            } else {
                Log.e("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex %d", Integer.valueOf(dequeueInputBuffer));
            }
            while (true) {
                int dequeueOutputBuffer = this.nec.dequeueOutputBuffer(this.ned, 100);
                if (dequeueOutputBuffer == -1) {
                    Log.d("MicroMsg.Record.AACAudioEncoder", "no output available, break");
                    break;
                } else if (dequeueOutputBuffer == -3) {
                    Log.e("MicroMsg.Record.AACAudioEncoder", "output buff change");
                    outputBuffers = this.nec.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    Log.e("MicroMsg.Record.AACAudioEncoder", "encoder output format changed: ".concat(String.valueOf(this.nec.getOutputFormat())));
                } else if (dequeueOutputBuffer < 0) {
                    Log.e("MicroMsg.Record.AACAudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: %s", Integer.valueOf(dequeueOutputBuffer));
                } else {
                    Log.i("MicroMsg.Record.AACAudioEncoder", "outputBufferIndex %d", Integer.valueOf(dequeueOutputBuffer));
                    ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer2 == null) {
                        RuntimeException runtimeException = new RuntimeException("outputBuffer " + dequeueOutputBuffer + " was null");
                        AppMethodBeat.o(146338);
                        throw runtimeException;
                    }
                    if ((this.ned.flags & 2) != 0) {
                        Log.e("MicroMsg.Record.AACAudioEncoder", "flags is BUFFER_FLAG_CODEC_CONFIG, don't writ data into file");
                    } else {
                        int i3 = this.ned.size;
                        byte[] bArr2 = new byte[i3];
                        byteBuffer2.get(bArr2, 0, i3);
                        int writeAudioBuff = M4aAudioFormatJni.writeAudioBuff(bArr2, i3);
                        d(bArr2, i3, false);
                        if (writeAudioBuff == 0) {
                            Log.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff ok,");
                        } else {
                            Log.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff fail,");
                        }
                    }
                    this.nec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.ned.flags & 4) != 0) {
                        if (!z) {
                            Log.w("MicroMsg.Record.AACAudioEncoder", "reached end of stream unexpectedly");
                        } else {
                            Log.e("MicroMsg.Record.AACAudioEncoder", "reach the end, and end to encode the data");
                        }
                    }
                }
            }
            AppMethodBeat.o(146338);
            return true;
        } else {
            Log.e("MicroMsg.Record.AACAudioEncoder", "mEncoder is null");
            AppMethodBeat.o(146338);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public final void flush() {
        AppMethodBeat.i(146339);
        Log.i("MicroMsg.Record.AACAudioEncoder", "flush");
        d(new byte[0], 0, true);
        AppMethodBeat.o(146339);
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public final void close() {
        AppMethodBeat.i(146340);
        Log.i("MicroMsg.Record.AACAudioEncoder", "close");
        if (this.nec != null) {
            this.nec.stop();
            this.nec.release();
            this.nec = null;
        }
        M4aAudioFormatJni.closeM4aFile();
        AppMethodBeat.o(146340);
    }
}
