package com.tencent.liteav.audio.impl.Record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.tav.decoder.EncoderWriter;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Vector;

public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private MediaCodec.BufferInfo f167a;

    /* renamed from: b  reason: collision with root package name */
    private MediaCodecInfo f168b;

    /* renamed from: c  reason: collision with root package name */
    private MediaFormat f169c;

    /* renamed from: d  reason: collision with root package name */
    private MediaCodec f170d;

    /* renamed from: e  reason: collision with root package name */
    private Vector<byte[]> f171e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<e> f172f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f173g = false;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f174h = false;

    /* renamed from: i  reason: collision with root package name */
    private final Object f175i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private long f176j = 0;
    private int k = 48000;
    private int l = 1;
    private int m = 16;
    private byte[] n;

    static {
        AppMethodBeat.i(221926);
        f.f();
        AppMethodBeat.o(221926);
    }

    @TargetApi(16)
    public b() {
        super("TXAudioRecordThread");
        AppMethodBeat.i(221914);
        AppMethodBeat.o(221914);
    }

    public void a(int i2, int i3, int i4, int i5, WeakReference<e> weakReference) {
        AppMethodBeat.i(221915);
        this.f172f = weakReference;
        this.f167a = new MediaCodec.BufferInfo();
        this.f171e = new Vector<>();
        this.k = i3;
        this.l = i4;
        this.m = i5;
        b();
        AppMethodBeat.o(221915);
    }

    public void a(byte[] bArr, long j2) {
        AppMethodBeat.i(221916);
        if (!(this.f171e == null || bArr == null)) {
            synchronized (this.f171e) {
                try {
                    if (this.f171e != null) {
                        this.f171e.add(bArr);
                    } else {
                        return;
                    }
                } finally {
                    AppMethodBeat.o(221916);
                }
            }
        }
        synchronized (this.f175i) {
            try {
                this.f175i.notify();
            } finally {
                AppMethodBeat.o(221916);
            }
        }
    }

    public void a() {
        AppMethodBeat.i(221917);
        c();
        AppMethodBeat.o(221917);
    }

    private void b() {
        int i2 = 32000;
        AppMethodBeat.i(221918);
        this.f168b = a(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE);
        if (this.f168b == null) {
            TXCLog.e("AudioCenter:TXCAudioHWEncoder", "Unable to find an appropriate codec for audio/mp4a-latm");
            AppMethodBeat.o(221918);
            return;
        }
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "selected codec: " + this.f168b.getName());
        if (this.k >= 32000) {
            i2 = 64000;
        }
        this.f169c = MediaFormat.createAudioFormat(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE, this.k, this.l);
        this.f169c.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i2);
        this.f169c.setInteger("channel-count", this.l);
        this.f169c.setInteger("sample-rate", this.k);
        this.f169c.setInteger("aac-profile", 2);
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "format: " + this.f169c);
        try {
            d();
        } catch (Exception e2) {
            TXCLog.e("AudioCenter:TXCAudioHWEncoder", "start media codec failed.", e2);
        }
        start();
        AppMethodBeat.o(221918);
    }

    private void c() {
        this.f174h = true;
    }

    @TargetApi(16)
    private void d() {
        AppMethodBeat.i(221919);
        if (this.f170d != null) {
            AppMethodBeat.o(221919);
            return;
        }
        this.f170d = MediaCodec.createEncoderByType(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE);
        this.f170d.configure(this.f169c, (Surface) null, (MediaCrypto) null, 1);
        this.f170d.start();
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "prepare finishing");
        this.f173g = true;
        AppMethodBeat.o(221919);
    }

    private void e() {
        AppMethodBeat.i(221920);
        if (this.f170d != null) {
            this.f170d.stop();
            this.f170d.release();
            this.f170d = null;
        }
        this.f173g = false;
        AppMethodBeat.o(221920);
    }

    public void run() {
        boolean isEmpty;
        byte[] remove;
        ByteBuffer byteBuffer;
        AppMethodBeat.i(221921);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
        while (!this.f174h) {
            if (this.f173g) {
                synchronized (this.f171e) {
                    try {
                        isEmpty = this.f171e.isEmpty();
                    } finally {
                        AppMethodBeat.o(221921);
                    }
                }
                if (isEmpty) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e2) {
                    }
                } else {
                    synchronized (this.f171e) {
                        try {
                            remove = this.f171e.remove(0);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (remove != null) {
                        try {
                            allocateDirect.clear();
                            if (remove.length > allocateDirect.capacity()) {
                                allocateDirect = ByteBuffer.allocateDirect(remove.length);
                            }
                            allocateDirect.clear();
                            allocateDirect.put(remove);
                            allocateDirect.flip();
                            a(allocateDirect, remove.length, f());
                        } catch (Exception e3) {
                            byteBuffer = allocateDirect;
                            TXCLog.e("AudioCenter:TXCAudioHWEncoder", "encode frame failed.", e3);
                        }
                    } else {
                        byteBuffer = allocateDirect;
                        allocateDirect = byteBuffer;
                    }
                }
            } else {
                synchronized (this.f175i) {
                    try {
                        this.f175i.wait();
                    } catch (InterruptedException e4) {
                    }
                    try {
                    } catch (Throwable th2) {
                        AppMethodBeat.o(221921);
                        throw th2;
                    }
                }
            }
        }
        e();
        AppMethodBeat.o(221921);
    }

    private void a(ByteBuffer byteBuffer, int i2, long j2) {
        int dequeueOutputBuffer;
        AppMethodBeat.i(221922);
        if (this.f174h) {
            AppMethodBeat.o(221922);
            return;
        }
        ByteBuffer[] inputBuffers = this.f170d.getInputBuffers();
        int dequeueInputBuffer = this.f170d.dequeueInputBuffer(10000);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
            byteBuffer2.clear();
            if (byteBuffer != null) {
                byteBuffer2.put(byteBuffer);
            }
            if (i2 <= 0) {
                TXCLog.i("AudioCenter:TXCAudioHWEncoder", "send BUFFER_FLAG_END_OF_STREAM");
                this.f170d.queueInputBuffer(dequeueInputBuffer, 0, 0, j2, 4);
            } else {
                this.f170d.queueInputBuffer(dequeueInputBuffer, 0, i2, j2, 0);
            }
        }
        ByteBuffer[] outputBuffers = this.f170d.getOutputBuffers();
        do {
            dequeueOutputBuffer = this.f170d.dequeueOutputBuffer(this.f167a, 10000);
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f170d.getOutputBuffers();
                    continue;
                } else if (dequeueOutputBuffer == -2) {
                    this.f170d.getOutputFormat();
                    continue;
                } else if (dequeueOutputBuffer >= 0) {
                    ByteBuffer byteBuffer3 = outputBuffers[dequeueOutputBuffer];
                    if ((this.f167a.flags & 2) != 0) {
                        TXCLog.d("AudioCenter:TXCAudioHWEncoder", "drain:BUFFER_FLAG_CODEC_CONFIG");
                        this.f167a.size = 0;
                    }
                    if (this.f167a.size != 0) {
                        this.f167a.presentationTimeUs = f();
                        this.n = new byte[byteBuffer3.limit()];
                        byteBuffer3.get(this.n);
                        b(this.n, this.f167a.presentationTimeUs);
                        this.f176j = this.f167a.presentationTimeUs;
                    }
                    this.f170d.releaseOutputBuffer(dequeueOutputBuffer, false);
                    continue;
                } else {
                    continue;
                }
            }
        } while (dequeueOutputBuffer >= 0);
        AppMethodBeat.o(221922);
    }

    private long f() {
        AppMethodBeat.i(221923);
        long timeTick = TXCTimeUtil.getTimeTick();
        if (timeTick < this.f176j) {
            timeTick += this.f176j - timeTick;
        }
        AppMethodBeat.o(221923);
        return timeTick;
    }

    private static final MediaCodecInfo a(String str) {
        MediaCodecInfo mediaCodecInfo;
        AppMethodBeat.i(221924);
        TXCLog.v("AudioCenter:TXCAudioHWEncoder", "selectAudioCodec:");
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
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (int i3 = 0; i3 < supportedTypes.length; i3++) {
                    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "supportedType:" + codecInfoAt.getName() + ",MIME=" + supportedTypes[i3]);
                    if (supportedTypes[i3].equalsIgnoreCase(str)) {
                        mediaCodecInfo = codecInfoAt;
                        break loop0;
                    }
                }
                continue;
            }
            i2++;
        }
        AppMethodBeat.o(221924);
        return mediaCodecInfo;
    }

    private void b(byte[] bArr, long j2) {
        e eVar;
        AppMethodBeat.i(221925);
        if (!(this.f172f == null || (eVar = this.f172f.get()) == null)) {
            eVar.onRecordEncData(bArr, j2, this.k, this.l, this.m);
        }
        AppMethodBeat.o(221925);
    }
}
