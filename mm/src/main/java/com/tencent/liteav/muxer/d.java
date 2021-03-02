package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(18)
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public static float f837a = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    public static float f838b = 0.8f;

    /* renamed from: c  reason: collision with root package name */
    public static float f839c = 1.25f;

    /* renamed from: d  reason: collision with root package name */
    public static float f840d = 2.0f;

    /* renamed from: e  reason: collision with root package name */
    private int f841e = 2;

    /* renamed from: f  reason: collision with root package name */
    private TXSWMuxerJNI f842f;

    /* renamed from: g  reason: collision with root package name */
    private String f843g = null;

    /* renamed from: h  reason: collision with root package name */
    private MediaFormat f844h = null;

    /* renamed from: i  reason: collision with root package name */
    private MediaFormat f845i = null;

    /* renamed from: j  reason: collision with root package name */
    private int f846j = 0;
    private int k = 0;
    private boolean l = false;
    private boolean m = false;
    private ConcurrentLinkedQueue<a> n = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<a> o = new ConcurrentLinkedQueue<>();
    private long p = -1;
    private long q = -1;
    private long r = -1;

    public d() {
        AppMethodBeat.i(14911);
        AppMethodBeat.o(14911);
    }

    /* access modifiers changed from: package-private */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        ByteBuffer f847a;

        /* renamed from: b  reason: collision with root package name */
        MediaCodec.BufferInfo f848b;

        public a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            this.f847a = byteBuffer;
            this.f848b = bufferInfo;
        }

        public ByteBuffer a() {
            return this.f847a;
        }

        public MediaCodec.BufferInfo b() {
            return this.f848b;
        }
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized void a(MediaFormat mediaFormat) {
        AppMethodBeat.i(14912);
        TXCLog.d("TXCMP4SWMuxer", "addVideoTrack:".concat(String.valueOf(mediaFormat)));
        this.f844h = mediaFormat;
        this.n.clear();
        AppMethodBeat.o(14912);
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized void b(MediaFormat mediaFormat) {
        AppMethodBeat.i(14913);
        TXCLog.d("TXCMP4SWMuxer", "addAudioTrack:".concat(String.valueOf(mediaFormat)));
        this.f845i = mediaFormat;
        this.o.clear();
        AppMethodBeat.o(14913);
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized boolean c() {
        boolean z;
        if (this.f844h != null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private ByteBuffer d() {
        AppMethodBeat.i(14914);
        ByteBuffer byteBuffer = this.f845i.getByteBuffer("csd-0");
        if (byteBuffer != null) {
            byteBuffer.position(0);
        }
        AppMethodBeat.o(14914);
        return byteBuffer;
    }

    private ByteBuffer e() {
        AppMethodBeat.i(14915);
        ByteBuffer byteBuffer = this.f844h.getByteBuffer("csd-0");
        AppMethodBeat.o(14915);
        return byteBuffer;
    }

    private ByteBuffer f() {
        AppMethodBeat.i(14916);
        ByteBuffer byteBuffer = this.f844h.getByteBuffer("csd-1");
        AppMethodBeat.o(14916);
        return byteBuffer;
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized int a() {
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(14917);
            if (this.f843g == null || this.f843g.isEmpty()) {
                TXCLog.e("TXCMP4SWMuxer", "target path not set yet!");
                i2 = -1;
                AppMethodBeat.o(14917);
            } else if (!c()) {
                TXCLog.e("TXCMP4SWMuxer", "video track not set yet!");
                i2 = -2;
                AppMethodBeat.o(14917);
            } else if (this.f842f != null) {
                TXCLog.w("TXCMP4SWMuxer", "start has been called. stop must be called before start");
                AppMethodBeat.o(14917);
            } else {
                TXCLog.d("TXCMP4SWMuxer", "start");
                this.f842f = new TXSWMuxerJNI();
                TXSWMuxerJNI.AVOptions aVOptions = new TXSWMuxerJNI.AVOptions();
                if (this.f844h != null) {
                    int integer = this.f844h.getInteger("width");
                    aVOptions.videoHeight = this.f844h.getInteger("height");
                    aVOptions.videoWidth = integer;
                    aVOptions.videoGOP = this.f844h.containsKey("i-frame-interval") ? this.f844h.getInteger("i-frame-interval") : 3;
                }
                if (this.f845i != null) {
                    int integer2 = this.f845i.getInteger("channel-count");
                    int integer3 = this.f845i.getInteger("sample-rate");
                    aVOptions.audioChannels = integer2;
                    aVOptions.audioSampleRate = integer3;
                }
                ByteBuffer e2 = e();
                ByteBuffer f2 = f();
                ByteBuffer byteBuffer = null;
                if (this.f845i != null) {
                    byteBuffer = d();
                }
                if (e2 == null || f2 == null) {
                    TXCLog.e("TXCMP4SWMuxer", "video format contains error csd!");
                    AppMethodBeat.o(14917);
                    i2 = -3;
                } else if (this.f845i == null || byteBuffer != null) {
                    this.f842f.a(e2, e2.capacity(), f2, f2.capacity());
                    if (this.f845i != null) {
                        this.f842f.a(byteBuffer, byteBuffer.capacity());
                    }
                    this.f842f.a(aVOptions);
                    this.f842f.a(this.f843g);
                    this.f842f.a();
                    this.p = -1;
                    this.l = true;
                    this.m = false;
                    this.q = -1;
                    this.r = -1;
                    AppMethodBeat.o(14917);
                } else {
                    TXCLog.e("TXCMP4SWMuxer", "audio format contains error csd!");
                    AppMethodBeat.o(14917);
                    i2 = -3;
                }
            }
        }
        return i2;
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized int b() {
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(14918);
            if (this.f842f != null) {
                h();
                TXCLog.d("TXCMP4SWMuxer", "stop. start flag = " + this.l + ", video key frame set = " + this.m);
                try {
                    if (this.l && this.m) {
                        this.f842f.b();
                    }
                    this.f842f.c();
                    this.f842f = null;
                    this.l = false;
                    this.f842f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.f844h = null;
                    this.f845i = null;
                    this.q = -1;
                    this.r = -1;
                } catch (Exception e2) {
                    TXCLog.e("TXCMP4SWMuxer", "muxer stop/release exception: ".concat(String.valueOf(e2)));
                    this.l = false;
                    this.f842f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.f844h = null;
                    this.f845i = null;
                    this.q = -1;
                    this.r = -1;
                    i2 = -1;
                    AppMethodBeat.o(14918);
                } catch (Throwable th) {
                    this.l = false;
                    this.f842f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.f844h = null;
                    this.f845i = null;
                    this.q = -1;
                    this.r = -1;
                    AppMethodBeat.o(14918);
                    throw th;
                }
            }
            AppMethodBeat.o(14918);
        }
        return i2;
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized void a(String str) {
        AppMethodBeat.i(14919);
        this.f843g = str;
        if (!TextUtils.isEmpty(this.f843g)) {
            File file = new File(this.f843g);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
                AppMethodBeat.o(14919);
            } catch (IOException e2) {
                TXCLog.e("TXCMP4SWMuxer", "create new file failed.", e2);
            }
        }
        AppMethodBeat.o(14919);
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized void b(byte[] bArr, int i2, int i3, long j2, int i4) {
        AppMethodBeat.i(14920);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3);
        allocateDirect.put(bArr, i2, i3);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.presentationTimeUs = j2;
        bufferInfo.offset = 0;
        bufferInfo.size = i3;
        bufferInfo.flags = i4;
        a(allocateDirect, bufferInfo);
        AppMethodBeat.o(14920);
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized void a(byte[] bArr, int i2, int i3, long j2, int i4) {
        AppMethodBeat.i(14921);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3);
        allocateDirect.put(bArr, i2, i3);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.presentationTimeUs = j2;
        bufferInfo.offset = 0;
        bufferInfo.size = i3;
        bufferInfo.flags = i4;
        b(allocateDirect, bufferInfo);
        AppMethodBeat.o(14921);
    }

    public synchronized void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(14922);
        if (this.f842f == null) {
            a(true, byteBuffer, bufferInfo);
            TXCLog.w("TXCMP4SWMuxer", "cache frame before muexer ready. ptsUs: " + bufferInfo.presentationTimeUs);
            AppMethodBeat.o(14922);
        } else if (this.p < 0) {
            a(true, byteBuffer, bufferInfo);
            this.p = g();
            TXCLog.d("TXCMP4SWMuxer", "first frame offset = " + this.p);
            i();
            AppMethodBeat.o(14922);
        } else {
            a(bufferInfo.presentationTimeUs);
            c(byteBuffer, bufferInfo);
            AppMethodBeat.o(14922);
        }
    }

    public synchronized void b(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(14923);
        a(false, byteBuffer, bufferInfo);
        AppMethodBeat.o(14923);
    }

    private void c(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        long j2 = 0;
        int i2 = 1;
        AppMethodBeat.i(14924);
        long j3 = bufferInfo.presentationTimeUs - this.p;
        if (j3 < 0) {
            TXCLog.e("TXCMP4SWMuxer", "pts error! first frame offset timeus = " + this.p + ", current timeus = " + bufferInfo.presentationTimeUs);
            if (this.q > 0) {
                j2 = this.q;
            }
        } else {
            j2 = j3;
        }
        if (j2 < this.q) {
            TXCLog.w("TXCMP4SWMuxer", "video is not in chronological order. current frame's pts(" + j2 + ") smaller than pre frame's pts(" + this.q + ")");
        } else {
            this.q = j2;
        }
        if (this.f841e != 2) {
            if (this.f841e == 3) {
                j2 = (long) (((float) j2) * f838b);
            } else if (this.f841e == 4) {
                j2 = (long) (((float) j2) * f837a);
            } else if (this.f841e == 1) {
                j2 = (long) (((float) j2) * f839c);
            } else if (this.f841e == 0) {
                j2 = (long) (((float) j2) * f840d);
            }
        }
        bufferInfo.presentationTimeUs = j2;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            TXSWMuxerJNI tXSWMuxerJNI = this.f842f;
            int i3 = bufferInfo.offset;
            int i4 = bufferInfo.size;
            if (bufferInfo.flags != 1) {
                i2 = 0;
            }
            tXSWMuxerJNI.a(byteBuffer, 1, i3, i4, i2, bufferInfo.presentationTimeUs);
            if ((bufferInfo.flags & 1) != 0) {
                this.m = true;
            }
            AppMethodBeat.o(14924);
        } catch (IllegalStateException e2) {
            TXCLog.e("TXCMP4SWMuxer", "write frame IllegalStateException: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(14924);
        } catch (IllegalArgumentException e3) {
            TXCLog.e("TXCMP4SWMuxer", "write frame IllegalArgumentException: ".concat(String.valueOf(e3)));
            AppMethodBeat.o(14924);
        }
    }

    private void d(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(14925);
        long j2 = bufferInfo.presentationTimeUs - this.p;
        if (this.p < 0 || j2 < 0) {
            TXCLog.w("TXCMP4SWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + bufferInfo.presentationTimeUs);
            AppMethodBeat.o(14925);
            return;
        }
        if (j2 < this.r) {
            TXCLog.e("TXCMP4SWMuxer", "audio is not in chronological order. current audio's pts pts(" + j2 + ") must larger than pre audio's pts(" + this.r + ")");
            j2 = this.r + 1;
        } else {
            this.r = j2;
        }
        if (this.f841e != 2) {
            if (this.f841e == 3) {
                j2 = (long) (((float) j2) * f838b);
            } else if (this.f841e == 4) {
                j2 = (long) (((float) j2) * f837a);
            } else if (this.f841e == 1) {
                j2 = (long) (((float) j2) * f839c);
            } else if (this.f841e == 0) {
                j2 = (long) (((float) j2) * f840d);
            }
        }
        bufferInfo.presentationTimeUs = j2;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            this.f842f.a(byteBuffer, 0, bufferInfo.offset, bufferInfo.size, bufferInfo.flags, bufferInfo.presentationTimeUs);
            AppMethodBeat.o(14925);
        } catch (IllegalStateException e2) {
            TXCLog.e("TXCMP4SWMuxer", "write sample IllegalStateException: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(14925);
        } catch (IllegalArgumentException e3) {
            TXCLog.e("TXCMP4SWMuxer", "write sample IllegalArgumentException: ".concat(String.valueOf(e3)));
            AppMethodBeat.o(14925);
        }
    }

    private void a(boolean z, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(14926);
        if (byteBuffer == null || bufferInfo == null) {
            AppMethodBeat.o(14926);
            return;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.capacity());
        byteBuffer.rewind();
        if (bufferInfo.size > 0) {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.size);
        }
        allocateDirect.rewind();
        allocateDirect.put(byteBuffer);
        MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
        bufferInfo2.set(bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
        a aVar = new a(allocateDirect, bufferInfo2);
        if (!z) {
            this.o.add(aVar);
            AppMethodBeat.o(14926);
        } else if (this.n.size() < 200) {
            this.n.add(aVar);
            AppMethodBeat.o(14926);
        } else {
            TXCLog.e("TXCMP4SWMuxer", "drop video frame. video cache size is larger than 200");
            AppMethodBeat.o(14926);
        }
    }

    private long g() {
        long j2;
        a peek;
        AppMethodBeat.i(14927);
        if (this.n.size() > 0) {
            j2 = this.n.peek().b().presentationTimeUs;
        } else {
            j2 = 0;
        }
        if (!(this.o.size() <= 0 || (peek = this.o.peek()) == null || peek.b() == null)) {
            long j3 = this.o.peek().b().presentationTimeUs;
            if (j2 > j3) {
                j2 = j3;
            }
        }
        AppMethodBeat.o(14927);
        return j2;
    }

    private void h() {
        AppMethodBeat.i(14928);
        while (this.n.size() > 0) {
            a poll = this.n.poll();
            c(poll.a(), poll.b());
        }
        while (this.o.size() > 0) {
            a poll2 = this.o.poll();
            d(poll2.a(), poll2.b());
        }
        AppMethodBeat.o(14928);
    }

    private void i() {
        AppMethodBeat.i(14929);
        while (this.n.size() > 0) {
            a poll = this.n.poll();
            a(poll.b().presentationTimeUs);
            c(poll.a(), poll.b());
        }
        AppMethodBeat.o(14929);
    }

    private void a(long j2) {
        AppMethodBeat.i(14930);
        while (this.o.size() > 0) {
            if (this.o.peek().b() != null) {
                if (this.o.peek().b().presentationTimeUs >= j2) {
                    break;
                }
                a poll = this.o.poll();
                d(poll.a(), poll.b());
            } else {
                TXCLog.e("TXCMP4SWMuxer", "flushAudioCache, bufferInfo is null");
                this.o.remove();
            }
        }
        AppMethodBeat.o(14930);
    }
}
