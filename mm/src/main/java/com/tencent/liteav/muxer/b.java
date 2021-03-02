package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(18)
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static float f823a = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    public static float f824b = 0.8f;

    /* renamed from: c  reason: collision with root package name */
    public static float f825c = 1.25f;

    /* renamed from: d  reason: collision with root package name */
    public static float f826d = 2.0f;

    /* renamed from: e  reason: collision with root package name */
    private int f827e = 2;

    /* renamed from: f  reason: collision with root package name */
    private MediaMuxer f828f;

    /* renamed from: g  reason: collision with root package name */
    private String f829g = null;

    /* renamed from: h  reason: collision with root package name */
    private MediaFormat f830h = null;

    /* renamed from: i  reason: collision with root package name */
    private MediaFormat f831i = null;

    /* renamed from: j  reason: collision with root package name */
    private int f832j = 0;
    private int k = 0;
    private boolean l = false;
    private boolean m = false;
    private ConcurrentLinkedQueue<a> n = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<a> o = new ConcurrentLinkedQueue<>();
    private long p = -1;
    private long q = -1;
    private long r = -1;

    public b() {
        AppMethodBeat.i(14931);
        AppMethodBeat.o(14931);
    }

    /* access modifiers changed from: package-private */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        ByteBuffer f833a;

        /* renamed from: b  reason: collision with root package name */
        MediaCodec.BufferInfo f834b;

        public a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            this.f833a = byteBuffer;
            this.f834b = bufferInfo;
        }

        public ByteBuffer a() {
            return this.f833a;
        }

        public MediaCodec.BufferInfo b() {
            return this.f834b;
        }
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized void a(MediaFormat mediaFormat) {
        AppMethodBeat.i(14932);
        TXCLog.d("TXCMP4HWMuxer", "addVideoTrack:".concat(String.valueOf(mediaFormat)));
        this.f830h = mediaFormat;
        this.n.clear();
        AppMethodBeat.o(14932);
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized void b(MediaFormat mediaFormat) {
        AppMethodBeat.i(14933);
        TXCLog.d("TXCMP4HWMuxer", "addAudioTrack:".concat(String.valueOf(mediaFormat)));
        this.f831i = mediaFormat;
        this.o.clear();
        AppMethodBeat.o(14933);
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized boolean c() {
        boolean z;
        if (this.f830h != null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized int a() {
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(14934);
            if (this.f829g == null || this.f829g.isEmpty()) {
                TXCLog.e("TXCMP4HWMuxer", "target path not set yet!");
                i2 = -1;
                AppMethodBeat.o(14934);
            } else if (!c()) {
                TXCLog.e("TXCMP4HWMuxer", "video track not set yet!");
                i2 = -2;
                AppMethodBeat.o(14934);
            } else if (this.f828f != null) {
                TXCLog.w("TXCMP4HWMuxer", "start has been called. stop must be called before start");
                AppMethodBeat.o(14934);
            } else {
                TXCLog.d("TXCMP4HWMuxer", "start");
                try {
                    this.f828f = new MediaMuxer(this.f829g, 0);
                    if (this.f830h != null) {
                        try {
                            this.k = this.f828f.addTrack(this.f830h);
                        } catch (IllegalArgumentException e2) {
                            TXCLog.e("TXCMP4HWMuxer", "addVideoTrack IllegalArgumentException: ".concat(String.valueOf(e2)));
                            i2 = -5;
                            AppMethodBeat.o(14934);
                        } catch (IllegalStateException e3) {
                            TXCLog.e("TXCMP4HWMuxer", "addVideoTrack IllegalStateException: ".concat(String.valueOf(e3)));
                            i2 = -6;
                            AppMethodBeat.o(14934);
                        }
                    }
                    if (this.f831i != null) {
                        try {
                            this.f832j = this.f828f.addTrack(this.f831i);
                        } catch (IllegalArgumentException e4) {
                            TXCLog.e("TXCMP4HWMuxer", "addAudioTrack IllegalArgumentException: ".concat(String.valueOf(e4)));
                            i2 = -7;
                            AppMethodBeat.o(14934);
                        } catch (IllegalStateException e5) {
                            TXCLog.e("TXCMP4HWMuxer", "addAudioTrack IllegalStateException: ".concat(String.valueOf(e5)));
                            i2 = -8;
                            AppMethodBeat.o(14934);
                        }
                    }
                    this.f828f.start();
                    this.p = -1;
                    this.l = true;
                    this.m = false;
                    this.q = -1;
                    this.r = -1;
                    AppMethodBeat.o(14934);
                } catch (IOException e6) {
                    TXCLog.e("TXCMP4HWMuxer", "create MediaMuxer exception:".concat(String.valueOf(e6)));
                    i2 = -4;
                    AppMethodBeat.o(14934);
                }
            }
        }
        return i2;
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized int b() {
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(14935);
            if (this.f828f != null) {
                TXCLog.d("TXCMP4HWMuxer", "stop. start flag = " + this.l + ", video key frame set = " + this.m);
                try {
                    if (this.l && this.m) {
                        this.f828f.stop();
                    }
                    this.f828f.release();
                    this.l = false;
                    this.f828f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.f830h = null;
                    this.f831i = null;
                    this.q = -1;
                    this.r = -1;
                } catch (Exception e2) {
                    TXCLog.e("TXCMP4HWMuxer", "muxer stop/release exception: ".concat(String.valueOf(e2)));
                    this.l = false;
                    this.f828f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.f830h = null;
                    this.f831i = null;
                    this.q = -1;
                    this.r = -1;
                    i2 = -1;
                    AppMethodBeat.o(14935);
                } catch (Throwable th) {
                    this.l = false;
                    this.f828f = null;
                    this.m = false;
                    this.n.clear();
                    this.o.clear();
                    this.f830h = null;
                    this.f831i = null;
                    this.q = -1;
                    this.r = -1;
                    AppMethodBeat.o(14935);
                    throw th;
                }
            }
            AppMethodBeat.o(14935);
        }
        return i2;
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized void a(String str) {
        AppMethodBeat.i(182270);
        this.f829g = str;
        if (!TextUtils.isEmpty(this.f829g)) {
            File file = new File(this.f829g);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
                AppMethodBeat.o(182270);
            } catch (IOException e2) {
                TXCLog.e("TXCMP4HWMuxer", "create new file failed.", e2);
            }
        }
        AppMethodBeat.o(182270);
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized void b(byte[] bArr, int i2, int i3, long j2, int i4) {
        AppMethodBeat.i(14936);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3);
        allocateDirect.put(bArr, i2, i3);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.presentationTimeUs = j2;
        bufferInfo.offset = 0;
        bufferInfo.size = i3;
        bufferInfo.flags = i4;
        a(allocateDirect, bufferInfo);
        AppMethodBeat.o(14936);
    }

    @Override // com.tencent.liteav.muxer.a
    public synchronized void a(byte[] bArr, int i2, int i3, long j2, int i4) {
        AppMethodBeat.i(14937);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3);
        allocateDirect.put(bArr, i2, i3);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.presentationTimeUs = j2;
        bufferInfo.offset = 0;
        bufferInfo.size = i3;
        bufferInfo.flags = i4;
        b(allocateDirect, bufferInfo);
        AppMethodBeat.o(14937);
    }

    public synchronized void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(14938);
        if (this.f828f == null) {
            a(true, byteBuffer, bufferInfo);
            TXCLog.w("TXCMP4HWMuxer", "cache frame before muexer ready. ptsUs: " + bufferInfo.presentationTimeUs);
            AppMethodBeat.o(14938);
        } else if (this.p < 0) {
            a(true, byteBuffer, bufferInfo);
            this.p = d();
            TXCLog.d("TXCMP4HWMuxer", "first frame offset = " + this.p);
            e();
            AppMethodBeat.o(14938);
        } else {
            c(byteBuffer, bufferInfo);
            AppMethodBeat.o(14938);
        }
    }

    public synchronized void b(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(14939);
        if (this.f828f == null || this.p < 0) {
            TXCLog.d("TXCMP4HWMuxer", "cache sample before muexer ready. ptsUs: " + bufferInfo.presentationTimeUs);
            a(false, byteBuffer, bufferInfo);
            AppMethodBeat.o(14939);
        } else {
            d(byteBuffer, bufferInfo);
            AppMethodBeat.o(14939);
        }
    }

    private void c(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        long j2 = 0;
        AppMethodBeat.i(14940);
        long j3 = bufferInfo.presentationTimeUs - this.p;
        if (j3 < 0) {
            TXCLog.e("TXCMP4HWMuxer", "pts error! first frame offset timeus = " + this.p + ", current timeus = " + bufferInfo.presentationTimeUs);
            if (this.q > 0) {
                j2 = this.q;
            }
        } else {
            j2 = j3;
        }
        if (j2 < this.q) {
            TXCLog.w("TXCMP4HWMuxer", "video is not in chronological order. current frame's pts(" + j2 + ") smaller than pre frame's pts(" + this.q + ")");
        } else {
            this.q = j2;
        }
        if (this.f827e != 2) {
            if (this.f827e == 3) {
                j2 = (long) (((float) j2) * f824b);
            } else if (this.f827e == 4) {
                j2 = (long) (((float) j2) * f823a);
            } else if (this.f827e == 1) {
                j2 = (long) (((float) j2) * f825c);
            } else if (this.f827e == 0) {
                j2 = (long) (((float) j2) * f826d);
            }
        }
        bufferInfo.presentationTimeUs = j2;
        try {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            this.f828f.writeSampleData(this.k, byteBuffer, bufferInfo);
            if ((bufferInfo.flags & 1) != 0) {
                this.m = true;
            }
            AppMethodBeat.o(14940);
        } catch (IllegalStateException e2) {
            TXCLog.e("TXCMP4HWMuxer", "write frame IllegalStateException: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(14940);
        } catch (IllegalArgumentException e3) {
            TXCLog.e("TXCMP4HWMuxer", "write frame IllegalArgumentException: ".concat(String.valueOf(e3)));
            AppMethodBeat.o(14940);
        }
    }

    private void d(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(14941);
        long j2 = bufferInfo.presentationTimeUs - this.p;
        if (this.p < 0 || j2 < 0) {
            TXCLog.w("TXCMP4HWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + bufferInfo.presentationTimeUs);
            AppMethodBeat.o(14941);
            return;
        }
        if (j2 < this.r) {
            TXCLog.e("TXCMP4HWMuxer", "audio is not in chronological order. current audio's pts pts(" + j2 + ") must larger than pre audio's pts(" + this.r + ")");
            j2 = this.r + 1;
        } else {
            this.r = j2;
        }
        if (this.f827e != 2) {
            if (this.f827e == 3) {
                j2 = (long) (((float) j2) * f824b);
            } else if (this.f827e == 4) {
                j2 = (long) (((float) j2) * f823a);
            } else if (this.f827e == 1) {
                j2 = (long) (((float) j2) * f825c);
            } else if (this.f827e == 0) {
                j2 = (long) (((float) j2) * f826d);
            }
        }
        bufferInfo.presentationTimeUs = j2;
        try {
            this.f828f.writeSampleData(this.f832j, byteBuffer, bufferInfo);
            AppMethodBeat.o(14941);
        } catch (IllegalStateException e2) {
            TXCLog.e("TXCMP4HWMuxer", "write sample IllegalStateException: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(14941);
        } catch (IllegalArgumentException e3) {
            TXCLog.e("TXCMP4HWMuxer", "write sample IllegalArgumentException: ".concat(String.valueOf(e3)));
            AppMethodBeat.o(14941);
        }
    }

    private void a(boolean z, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(14942);
        if (byteBuffer == null || bufferInfo == null) {
            AppMethodBeat.o(14942);
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
        if (z) {
            if (this.n.size() < 200) {
                this.n.add(aVar);
                AppMethodBeat.o(14942);
                return;
            }
            TXCLog.e("TXCMP4HWMuxer", "drop video frame. video cache size is larger than 200");
            AppMethodBeat.o(14942);
        } else if (this.o.size() < 600) {
            this.o.add(aVar);
            AppMethodBeat.o(14942);
        } else {
            TXCLog.e("TXCMP4HWMuxer", "drop audio frame. audio cache size is larger than 600");
            AppMethodBeat.o(14942);
        }
    }

    private long d() {
        long j2;
        a peek;
        AppMethodBeat.i(14943);
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
        AppMethodBeat.o(14943);
        return j2;
    }

    private void e() {
        AppMethodBeat.i(14944);
        while (this.n.size() > 0) {
            a poll = this.n.poll();
            c(poll.a(), poll.b());
        }
        while (this.o.size() > 0) {
            a poll2 = this.o.poll();
            d(poll2.a(), poll2.b());
        }
        AppMethodBeat.o(14944);
    }
}
