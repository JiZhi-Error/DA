package com.tencent.mm.audio.mix.d;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.e;
import com.tencent.mm.audio.mix.h.c;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.music.g.a;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class d extends c {
    private static int dvE = 0;
    private static int dvF = 0;
    private int BUFFER_SIZE = 14144;
    private byte[] buffer = new byte[this.BUFFER_SIZE];
    private int dtP = 2;
    private long duration = 0;
    private g dvA;
    private byte[] dvB = new byte[3536];
    private int dvC = 3536;
    private byte[] dvD = new byte[3536];
    private MediaExtractor dvy;
    private z dvz;
    private int mSize = 0;
    private String mime = null;
    private long presentationTimeUs = 0;

    public d(com.tencent.mm.audio.mix.g.d dVar, c cVar) {
        super(dVar, cVar);
        AppMethodBeat.i(136799);
        AppMethodBeat.o(136799);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.d.c
    public final void Ze() {
        MediaFormat mediaFormat;
        boolean z;
        int i2;
        boolean z2;
        AppMethodBeat.i(136800);
        b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "onDecode");
        this.dvy = new MediaExtractor();
        try {
            if (Build.VERSION.SDK_INT < 23 || this.dvk.dvn == null || !this.dvk.dvn.startsWith("wxblob://") || this.dvk.iJU == null) {
                this.dvy.setDataSource(this.sourcePath);
            } else {
                b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "decode AudioMediaDataSource");
                a aVar = new a(this.dvk.iJU);
                if (this.dvA != null) {
                    this.dvA.close();
                }
                this.dvA = new g(aVar);
                this.dvy.setDataSource(this.dvA);
            }
            try {
                int trackCount = this.dvy.getTrackCount();
                b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "tractCount is %d", Integer.valueOf(trackCount));
                int i3 = 0;
                while (true) {
                    if (i3 >= trackCount) {
                        mediaFormat = null;
                        break;
                    }
                    MediaFormat trackFormat = this.dvy.getTrackFormat(i3);
                    this.mime = trackFormat.getString("mime");
                    if (!TextUtils.isEmpty(this.mime) && this.mime.startsWith("audio/")) {
                        mediaFormat = trackFormat;
                        break;
                    }
                    i3++;
                }
                if (mediaFormat == null) {
                    b.e("MicroMsg.Mix.AudioDecoderMediaCodec", "format is null");
                    this.dvm = 703;
                    onError(this.dvm);
                    Zm();
                    AppMethodBeat.o(136800);
                    return;
                }
                b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "format:%s", mediaFormat);
                this.sampleRate = mediaFormat.getInteger("sample-rate");
                this.channels = mediaFormat.getInteger("channel-count");
                this.duration = mediaFormat.getLong("durationUs");
                if (com.tencent.mm.audio.mix.b.a.Yw().gD(this.sourcePath)) {
                    File file = new File(com.tencent.mm.audio.mix.i.a.hr(this.sourcePath));
                    File file2 = new File(com.tencent.mm.audio.mix.i.a.S(this.dvk.appId, this.sourcePath));
                    if (file.exists() || file2.exists()) {
                        com.tencent.mm.audio.mix.a.d Za = Za();
                        Za.reset();
                        Za.duration = this.duration / 1000;
                        com.tencent.mm.audio.mix.c.b bVar = new com.tencent.mm.audio.mix.c.b(this.sourcePath, !file.exists() && file2.exists(), this.dvk.appId);
                        boolean z3 = false;
                        b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "read cache begin");
                        while (true) {
                            if (YZ()) {
                                break;
                            }
                            Zb();
                            byte[] YO = bVar.YO();
                            if (YO != null) {
                                this.sampleRate = 44100;
                                this.channels = 2;
                                this.dtP = 2;
                                b(Za, YO);
                            }
                            if (Za.size() <= 0 || YO != null) {
                                if (Za.size() != 0 || YO != null) {
                                    if (YO != null) {
                                        if (YO == null) {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    Za.reset();
                                    break;
                                }
                            } else {
                                Za.complete();
                                dvE++;
                                z3 = true;
                                break;
                            }
                        }
                        b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "read cache end，loadSuc:%b", Boolean.valueOf(z3));
                        b.i("MicroMsg.Mix.AudioConvertCacheReader", "release");
                        try {
                            if (bVar.inputStream != null) {
                                bVar.inputStream.close();
                                bVar.inputStream = null;
                            }
                        } catch (Exception e2) {
                            b.printErrStackTrace("MicroMsg.Mix.AudioConvertCacheReader", e2, "inputStream close", new Object[0]);
                        }
                        if (z3) {
                            Za.dtU = this.dvj.ZU().dtU;
                            Zm();
                            b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "read cache success loadCacheFromPcmCount:%d", Integer.valueOf(dvE));
                            AppMethodBeat.o(136800);
                            return;
                        }
                    } else {
                        b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "cache file is not exist");
                        com.tencent.mm.audio.mix.b.a.Yw().gC(this.sourcePath);
                    }
                }
                try {
                    this.dvz = z.DZ(this.mime);
                    this.dvz.a(mediaFormat, (Surface) null, 0);
                    this.dvz.start();
                    try {
                        ByteBuffer[] inputBuffers = this.dvz.getInputBuffers();
                        ByteBuffer[] outputBuffers = this.dvz.getOutputBuffers();
                        b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "Track info: extractorFormat: %s mime: %s", mediaFormat, this.mime);
                        b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "sampleRate:%d, channels:%d, bitDepth:%d, duration:%d, audioId:%s,", Integer.valueOf(this.sampleRate), Integer.valueOf(this.channels), Integer.valueOf(this.dtP), Long.valueOf(this.duration), this.dvj.ZU().dtX);
                        this.dvy.selectTrack(0);
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        int i4 = 0;
                        com.tencent.mm.audio.mix.a.d Za2 = Za();
                        Za2.reset();
                        if (!com.tencent.mm.audio.mix.g.a.I(this.sampleRate, this.channels, this.dtP)) {
                            b.e("MicroMsg.Mix.AudioDecoderMediaCodec", "track param is not support config");
                            this.dvl = new e(Za2, this.sampleRate, this.channels, this.dtP, this.sourcePath);
                        } else {
                            dvF++;
                            b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "track support supportConfigCount:%d", Integer.valueOf(dvF));
                        }
                        Za2.duration = this.duration / 1000;
                        boolean z4 = false;
                        ByteBuffer[] byteBufferArr = outputBuffers;
                        boolean z5 = false;
                        while (!z5 && i4 < 50) {
                            try {
                                if (!YZ()) {
                                    Zb();
                                    i4++;
                                    if (!z4) {
                                        int dequeueInputBuffer = this.dvz.dequeueInputBuffer(1000);
                                        if (dequeueInputBuffer >= 0) {
                                            int readSampleData = this.dvy.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                                            if (readSampleData < 0) {
                                                b.e("MicroMsg.Mix.AudioDecoderMediaCodec", "saw input EOS. Stopping playback");
                                                z2 = true;
                                                readSampleData = 0;
                                            } else {
                                                this.presentationTimeUs = this.dvy.getSampleTime();
                                                z2 = z4;
                                            }
                                            this.dvz.a(dequeueInputBuffer, readSampleData, this.presentationTimeUs, z2 ? 4 : 0);
                                            if (!z2) {
                                                this.dvy.advance();
                                            }
                                            z4 = z2;
                                        } else {
                                            b.e("MicroMsg.Mix.AudioDecoderMediaCodec", "inputBufIndex ".concat(String.valueOf(dequeueInputBuffer)));
                                        }
                                    }
                                    int dequeueOutputBuffer = this.dvz.dequeueOutputBuffer(bufferInfo, 1000);
                                    if (dequeueOutputBuffer >= 0) {
                                        if (bufferInfo.size > 0) {
                                            i2 = 0;
                                        } else {
                                            i2 = i4;
                                        }
                                        ByteBuffer byteBuffer = byteBufferArr[dequeueOutputBuffer];
                                        int i5 = bufferInfo.size;
                                        if (i5 > 0) {
                                            a(Za2, byteBuffer, i5);
                                        }
                                        byteBuffer.clear();
                                        this.dvz.releaseOutputBuffer(dequeueOutputBuffer, false);
                                        if ((bufferInfo.flags & 4) != 0) {
                                            b.e("MicroMsg.Mix.AudioDecoderMediaCodec", "saw output EOS.");
                                            z5 = true;
                                        }
                                        i4 = i2;
                                    } else if (dequeueOutputBuffer == -3) {
                                        ByteBuffer[] outputBuffers2 = this.dvz.getOutputBuffers();
                                        b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "output buffers have changed.");
                                        byteBufferArr = outputBuffers2;
                                    } else if (dequeueOutputBuffer == -2) {
                                        MediaFormat outputFormat = this.dvz.getOutputFormat();
                                        b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "output format has changed to ".concat(String.valueOf(outputFormat)));
                                        this.sampleRate = outputFormat.getInteger("sample-rate");
                                        this.channels = outputFormat.getInteger("channel-count");
                                        if (outputFormat.containsKey("pcm-encoding")) {
                                            this.dtP = outputFormat.getInteger("pcm-encoding");
                                        } else if (outputFormat.containsKey("bit-width")) {
                                            int integer = outputFormat.getInteger("bit-width");
                                            if (integer == 16) {
                                                this.dtP = 2;
                                            } else if (integer == 8) {
                                                this.dtP = 3;
                                            }
                                        }
                                        b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "sampleRate:%d, channels:%d, bitDepth:%d, audioId:%s, sourcePath:%s", Integer.valueOf(this.sampleRate), Integer.valueOf(this.channels), Integer.valueOf(this.dtP), this.dvj.ZU().dtX, this.sourcePath);
                                        switch (this.dtP) {
                                            case 1:
                                            case 2:
                                            case 3:
                                                z = true;
                                                break;
                                            default:
                                                z = false;
                                                break;
                                        }
                                        if (!z) {
                                            b.e("MicroMsg.Mix.AudioDecoderMediaCodec", "bitDepth:%d is not support!", Integer.valueOf(this.dtP));
                                            this.dvm = 709;
                                            onError(this.dvm);
                                            Zm();
                                            Zn();
                                            AppMethodBeat.o(136800);
                                            return;
                                        } else if (com.tencent.mm.audio.mix.g.a.I(this.sampleRate, this.channels, this.dtP) && this.dvl != null) {
                                            b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "support audio Config");
                                            this.dvl.YR();
                                            this.dvl.release();
                                            this.dvl = null;
                                        } else if (this.dvl != null) {
                                            b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "update config param");
                                            this.dvl.G(this.sampleRate, this.channels, this.dtP);
                                        }
                                    } else {
                                        b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "dequeueOutputBuffer returned ".concat(String.valueOf(dequeueOutputBuffer)));
                                    }
                                }
                            } catch (Exception e3) {
                                b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e3, "onDecode", new Object[0]);
                                this.dvm = 706;
                                onError(this.dvm);
                                Zm();
                                Zn();
                            } catch (Throwable th) {
                                Zm();
                                Zn();
                                AppMethodBeat.o(136800);
                                throw th;
                            }
                        }
                        boolean z6 = (this.duration / 1000) - (this.presentationTimeUs / 1000) < 2000;
                        if (i4 >= 50) {
                            b.e("MicroMsg.Mix.AudioDecoderMediaCodec", "onError, noOutputCounter:%d", Integer.valueOf(i4));
                            this.dvm = 706;
                            onError(this.dvm);
                        } else {
                            b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "onStop, isComplete:%b", Boolean.valueOf(z6));
                            if (z6) {
                                b(Za2);
                            } else {
                                Za2.reset();
                            }
                        }
                        Zm();
                        Zn();
                        Za2.dtU = this.dvj.ZU().dtU;
                        b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "stopping...");
                        AppMethodBeat.o(136800);
                    } catch (IllegalStateException e4) {
                        b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e4, "getInputBuffers or getOutputBuffers", new Object[0]);
                        this.dvm = 716;
                        onError(this.dvm);
                        Zm();
                        Zn();
                        AppMethodBeat.o(136800);
                    }
                } catch (Exception e5) {
                    b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e5, "createDecoderByType", new Object[0]);
                    this.dvm = 704;
                    onError(this.dvm);
                    Zm();
                    Zn();
                    AppMethodBeat.o(136800);
                }
            } catch (Exception e6) {
                b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e6, "get media format from media extractor", new Object[0]);
                this.dvm = 705;
                onError(this.dvm);
                Zm();
                AppMethodBeat.o(136800);
            }
        } catch (Exception e7) {
            b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e7, "set extractor data source, sourcePath:%s", this.sourcePath);
            this.dvm = 702;
            YX();
            Zo();
            AppMethodBeat.o(136800);
        }
    }

    /* access modifiers changed from: protected */
    public void a(com.tencent.mm.audio.mix.a.d dVar, ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(136801);
        if (this.dvl != null) {
            if (i2 != this.dvC) {
                this.dvC = i2;
                this.dvB = new byte[i2];
            }
            byteBuffer.get(this.dvB);
            if (this.dvj.ZU().iJS) {
                com.tencent.mm.audio.mix.c.a.a(this.dvB, Zk().iJG);
            }
            this.dvl.X(this.dvB);
            AppMethodBeat.o(136801);
            return;
        }
        b(dVar, byteBuffer, i2);
        AppMethodBeat.o(136801);
    }

    /* access modifiers changed from: protected */
    public final void b(com.tencent.mm.audio.mix.a.d dVar, ByteBuffer byteBuffer, int i2) {
        byte[] bArr;
        AppMethodBeat.i(136802);
        if (3536 == i2) {
            bArr = new byte[i2];
            byteBuffer.get(bArr);
        } else {
            if (i2 != this.dvC) {
                this.dvC = i2;
                this.dvB = new byte[i2];
            }
            Arrays.fill(this.dvB, 0, this.dvC, (byte) 0);
            byteBuffer.get(this.dvB, 0, this.dvC);
            bArr = this.dvB;
        }
        if (this.dvj.ZU().iJS) {
            com.tencent.mm.audio.mix.c.a.a(bArr, Zk().iJG);
        }
        a(dVar, bArr);
        AppMethodBeat.o(136802);
    }

    /* access modifiers changed from: protected */
    public void b(com.tencent.mm.audio.mix.a.d dVar) {
        AppMethodBeat.i(136803);
        if (this.dvl != null) {
            this.dvl.YR();
            com.tencent.mm.audio.mix.b.a.Yw().gB(dVar.dtT);
            if (YZ()) {
                b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache");
                this.dvl.flushCache();
                AppMethodBeat.o(136803);
            } else if (YY()) {
                b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache and readCacheAndPlay");
                this.dvl.flushCache();
                Zf();
                AppMethodBeat.o(136803);
            } else {
                b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "writeCacheAndPlay");
                a(dVar);
                AppMethodBeat.o(136803);
            }
        } else {
            c(dVar);
            dVar.complete();
            AppMethodBeat.o(136803);
        }
    }

    /* access modifiers changed from: protected */
    public final void c(com.tencent.mm.audio.mix.a.d dVar) {
        AppMethodBeat.i(136804);
        if (this.mSize <= 0) {
            AppMethodBeat.o(136804);
            return;
        }
        if (this.mSize > 3536) {
            int i2 = this.mSize;
            int i3 = i2 / 3536;
            int i4 = i2 % 3536;
            for (int i5 = 0; i5 < i3; i5++) {
                byte[] bArr = new byte[3536];
                System.arraycopy(this.buffer, i5 * 3536, bArr, 0, 3536);
                b(dVar, bArr);
            }
            System.arraycopy(this.buffer, i3 * 3536, this.dvD, 0, i4);
            Arrays.fill(this.buffer, 0, this.BUFFER_SIZE, (byte) 0);
            System.arraycopy(this.dvD, 0, this.buffer, 0, i4);
            this.mSize = i4;
        }
        if (this.mSize <= 3536) {
            byte[] bArr2 = new byte[3536];
            System.arraycopy(this.buffer, 0, bArr2, 0, this.mSize);
            b(dVar, bArr2);
            this.mSize = 0;
        }
        AppMethodBeat.o(136804);
    }

    private void a(com.tencent.mm.audio.mix.a.d dVar, byte[] bArr) {
        AppMethodBeat.i(136805);
        if (bArr == null) {
            b.e("MicroMsg.Mix.AudioDecoderMediaCodec", "pushBuffer chunk is null");
            AppMethodBeat.o(136805);
            return;
        }
        int length = bArr.length;
        if (length == 3536) {
            if (this.mSize > 0) {
                c(dVar);
            }
            b(dVar, bArr);
            AppMethodBeat.o(136805);
            return;
        }
        if (length != 3536) {
            if (length > this.BUFFER_SIZE) {
                while (this.BUFFER_SIZE < length) {
                    this.BUFFER_SIZE += 3536;
                }
                byte[] bArr2 = new byte[this.BUFFER_SIZE];
                if (this.mSize > 0) {
                    System.arraycopy(this.buffer, 0, bArr2, 0, this.mSize);
                }
                this.buffer = bArr2;
            }
            int i2 = this.mSize + length;
            System.arraycopy(bArr, 0, this.buffer, this.mSize, length);
            int i3 = i2 / 3536;
            int i4 = i2 % 3536;
            for (int i5 = 0; i5 < i3; i5++) {
                byte[] bArr3 = new byte[3536];
                System.arraycopy(this.buffer, i5 * 3536, bArr3, 0, 3536);
                b(dVar, bArr3);
            }
            System.arraycopy(this.buffer, i3 * 3536, this.dvD, 0, i4);
            Arrays.fill(this.buffer, 0, this.BUFFER_SIZE, (byte) 0);
            System.arraycopy(this.dvD, 0, this.buffer, 0, i4);
            this.mSize = i4;
        }
        AppMethodBeat.o(136805);
    }

    private void b(com.tencent.mm.audio.mix.a.d dVar, byte[] bArr) {
        AppMethodBeat.i(136806);
        com.tencent.mm.audio.mix.a.e YI = com.tencent.mm.audio.mix.b.e.YJ().YI();
        YI.dtQ = bArr;
        YI.sampleRate = this.sampleRate;
        YI.channels = this.channels;
        YI.dtP = this.dtP;
        dVar.a(YI);
        a(YI);
        AppMethodBeat.o(136806);
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public void onRelease() {
        AppMethodBeat.i(136807);
        Zm();
        Zn();
        if (this.dvl != null) {
            this.dvl.YR();
            this.dvl.release();
            this.dvl = null;
        }
        this.sourcePath = null;
        this.mime = null;
        this.sampleRate = 0;
        this.channels = 0;
        this.presentationTimeUs = 0;
        this.duration = 0;
        AppMethodBeat.o(136807);
    }

    private void Zm() {
        AppMethodBeat.i(136808);
        try {
            if (this.dvy != null) {
                this.dvy.release();
                this.dvy = null;
            }
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e2, "releaseMediaExtractor", new Object[0]);
        }
        Zo();
        AppMethodBeat.o(136808);
    }

    private void Zn() {
        AppMethodBeat.i(136809);
        try {
            if (this.dvz != null) {
                this.dvz.stop();
                this.dvz.release();
                this.dvz = null;
            }
            AppMethodBeat.o(136809);
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e2, "releaseMediaCodec", new Object[0]);
            AppMethodBeat.o(136809);
        }
    }

    private void Zo() {
        AppMethodBeat.i(198106);
        try {
            if (this.dvA != null) {
                this.dvA.close();
                this.dvA = null;
            }
            AppMethodBeat.o(198106);
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", e2, "releaseDataSource", new Object[0]);
            AppMethodBeat.o(198106);
        }
    }
}
