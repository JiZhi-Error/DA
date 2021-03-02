package com.tencent.liteav.videodecoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.component.TAVPlayer;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;

public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    private MediaCodec.BufferInfo f1225a = new MediaCodec.BufferInfo();

    /* renamed from: b  reason: collision with root package name */
    private MediaCodec f1226b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f1227c = "video/avc";

    /* renamed from: d  reason: collision with root package name */
    private int f1228d = TAVPlayer.VIDEO_PLAYER_WIDTH;

    /* renamed from: e  reason: collision with root package name */
    private int f1229e = 960;

    /* renamed from: f  reason: collision with root package name */
    private long f1230f = 0;

    /* renamed from: g  reason: collision with root package name */
    private long f1231g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1232h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1233i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1234j = false;
    private Surface k = null;
    private int l = 0;
    private ArrayList<TXSNALPacket> m = new ArrayList<>();
    private ArrayList<Long> n = new ArrayList<>();
    private long o = 0;
    private int p = 0;
    private JSONArray q = null;
    private g r;
    private d s = new d();
    private boolean t = false;
    private WeakReference<b> u;

    public f() {
        AppMethodBeat.i(259946);
        AppMethodBeat.o(259946);
    }

    @Override // com.tencent.liteav.videodecoder.b
    public void setListener(g gVar) {
        this.r = gVar;
    }

    @Override // com.tencent.liteav.videodecoder.b
    public void setNotifyListener(WeakReference<b> weakReference) {
        this.u = weakReference;
    }

    @Override // com.tencent.liteav.videodecoder.b
    public int config(Surface surface) {
        if (surface == null) {
            return -1;
        }
        this.k = surface;
        return 0;
    }

    @Override // com.tencent.liteav.videodecoder.b
    public void decode(TXSNALPacket tXSNALPacket) {
        AppMethodBeat.i(259947);
        a(tXSNALPacket.codecId == 1);
        if (tXSNALPacket.codecId != 1) {
            a(tXSNALPacket);
        }
        this.m.add(tXSNALPacket);
        while (!this.m.isEmpty()) {
            int size = this.m.size();
            try {
                b();
            } catch (Exception e2) {
                TXCLog.e("MediaCodecDecoder", "decode: doDecode Exception!! " + e2.toString());
            }
            if (size == this.m.size()) {
                break;
            }
        }
        AppMethodBeat.o(259947);
    }

    @Override // com.tencent.liteav.videodecoder.b
    public int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        AppMethodBeat.i(259948);
        int a2 = a(byteBuffer, byteBuffer2, z2);
        AppMethodBeat.o(259948);
        return a2;
    }

    @Override // com.tencent.liteav.videodecoder.b
    public void stop() {
        AppMethodBeat.i(259949);
        a();
        AppMethodBeat.o(259949);
    }

    @Override // com.tencent.liteav.videodecoder.b
    public int GetDecodeCost() {
        return this.p;
    }

    public void a(JSONArray jSONArray) {
        this.q = jSONArray;
    }

    @Override // com.tencent.liteav.videodecoder.b
    public void enableLimitDecCache(boolean z) {
        AppMethodBeat.i(259950);
        this.t = z;
        TXCLog.i("MediaCodecDecoder", "decode: enable limit dec cache: ".concat(String.valueOf(z)));
        AppMethodBeat.o(259950);
    }

    public void a(int i2, int i3) {
        AppMethodBeat.i(259951);
        if (i2 > 0 && i3 > 0) {
            this.f1228d = i2;
            this.f1229e = i3;
            TXCLog.w("MediaCodecDecoder", "decode: init with video size: " + this.f1228d + ", " + this.f1229e);
        }
        AppMethodBeat.o(259951);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0090 A[SYNTHETIC, Splitter:B:29:0x0090] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(java.nio.ByteBuffer r12, java.nio.ByteBuffer r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 464
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videodecoder.f.a(java.nio.ByteBuffer, java.nio.ByteBuffer, boolean):int");
    }

    private void a() {
        AppMethodBeat.i(259953);
        if (this.f1226b != null) {
            try {
                this.f1226b.stop();
                TXCLog.w("MediaCodecDecoder", "decode: stop decoder sucess");
                try {
                    this.f1226b.release();
                    TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
                    this.f1226b = null;
                } catch (Exception e2) {
                    TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + e2.toString());
                    this.f1226b = null;
                } catch (Throwable th) {
                    this.f1226b = null;
                    AppMethodBeat.o(259953);
                    throw th;
                }
            } catch (Exception e3) {
                TXCLog.e("MediaCodecDecoder", "decode: stop decoder Exception: " + e3.toString());
                try {
                    this.f1226b.release();
                    TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
                    this.f1226b = null;
                } catch (Exception e4) {
                    TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + e4.toString());
                    this.f1226b = null;
                } catch (Throwable th2) {
                    this.f1226b = null;
                    AppMethodBeat.o(259953);
                    throw th2;
                }
            } catch (Throwable th3) {
                try {
                    this.f1226b.release();
                    TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
                    this.f1226b = null;
                } catch (Exception e5) {
                    TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + e5.toString());
                    this.f1226b = null;
                } catch (Throwable th4) {
                    this.f1226b = null;
                    AppMethodBeat.o(259953);
                    throw th4;
                }
                AppMethodBeat.o(259953);
                throw th3;
            }
        }
        this.m.clear();
        this.f1230f = 0;
        this.f1232h = true;
        this.f1233i = false;
        AppMethodBeat.o(259953);
    }

    @TargetApi(16)
    private void b() {
        ByteBuffer[] byteBufferArr;
        int i2;
        int i3;
        long j2;
        AppMethodBeat.i(259954);
        if (this.f1226b == null) {
            TXCLog.e("MediaCodecDecoder", "null decoder");
            AppMethodBeat.o(259954);
            return;
        }
        TXSNALPacket tXSNALPacket = this.m.get(0);
        if (tXSNALPacket == null || tXSNALPacket.nalData.length == 0) {
            TXCLog.e("MediaCodecDecoder", "decode: empty buffer");
            this.m.remove(0);
            AppMethodBeat.o(259954);
            return;
        }
        long timeTick = TXCTimeUtil.getTimeTick();
        if (this.o == 0) {
            this.o = timeTick;
        }
        try {
            byteBufferArr = this.f1226b.getInputBuffers();
        } catch (Exception e2) {
            TXCLog.e("MediaCodecDecoder", "decode: getInputBuffers Exception!! " + e2.toString());
            byteBufferArr = null;
        }
        if (byteBufferArr == null || byteBufferArr.length == 0) {
            TXCLog.e("MediaCodecDecoder", "decode: getInputBuffers failed");
            AppMethodBeat.o(259954);
            return;
        }
        try {
            i2 = this.f1226b.dequeueInputBuffer(10000);
        } catch (Exception e3) {
            TXCLog.e("MediaCodecDecoder", "decode: dequeueInputBuffer Exception!! " + e3.toString());
            i2 = -10000;
        }
        if (i2 >= 0) {
            byteBufferArr[i2].put(tXSNALPacket.nalData);
            try {
                this.f1226b.queueInputBuffer(i2, 0, tXSNALPacket.nalData.length, tXSNALPacket.pts, 0);
                this.m.remove(0);
            } catch (Exception e4) {
                f();
            }
            if (this.f1230f == 0) {
                TXCLog.w("MediaCodecDecoder", "decode: input buffer available, dequeueInputBuffer index: ".concat(String.valueOf(i2)));
            }
        } else {
            TXCLog.w("MediaCodecDecoder", "decode: input buffer not available, dequeueInputBuffer failed");
        }
        try {
            i3 = this.f1226b.dequeueOutputBuffer(this.f1225a, 10000);
        } catch (Exception e5) {
            f();
            TXCLog.e("MediaCodecDecoder", "decode: dequeueOutputBuffer exception!!".concat(String.valueOf(e5)));
            i3 = -10000;
        }
        if (i3 >= 0) {
            a(i3, this.f1225a.presentationTimeUs, this.f1225a.presentationTimeUs, tXSNALPacket.rotation);
            this.l = 0;
        } else if (i3 == -1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e6) {
            }
            TXCLog.i("MediaCodecDecoder", "decode: no output from decoder available when timeout fail count " + this.l);
            f();
        } else if (i3 == -3) {
            TXCLog.i("MediaCodecDecoder", "decode: output buffers changed");
        } else if (i3 == -2) {
            c();
        } else {
            TXCLog.e("MediaCodecDecoder", "decode: unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i3)));
        }
        long timeTick2 = TXCTimeUtil.getTimeTick();
        this.n.add(Long.valueOf(timeTick2 - timeTick));
        if (timeTick2 > this.o + 1000) {
            Iterator<Long> it = this.n.iterator();
            long j3 = 0;
            while (it.hasNext()) {
                Long next = it.next();
                if (next.longValue() > j3) {
                    j2 = next.longValue();
                } else {
                    j2 = j3;
                }
                j3 = j2;
            }
            this.n.clear();
            this.o = timeTick2;
            this.p = (int) (3 * j3);
        }
        AppMethodBeat.o(259954);
    }

    private void a(int i2, long j2, long j3, int i3) {
        AppMethodBeat.i(259955);
        this.f1226b.releaseOutputBuffer(i2, true);
        if ((this.f1225a.flags & 4) != 0) {
            TXCLog.i("MediaCodecDecoder", "output EOS");
        }
        try {
            if (this.r != null) {
                this.r.onDecodeFrame(null, this.f1228d, this.f1229e, j2, j3, i3);
            }
        } catch (Exception e2) {
            TXCLog.e("MediaCodecDecoder", "onDecodeFrame failed.", e2);
        }
        d();
        AppMethodBeat.o(259955);
    }

    private void c() {
        AppMethodBeat.i(259956);
        MediaFormat outputFormat = this.f1226b.getOutputFormat();
        TXCLog.i("MediaCodecDecoder", "decode output format changed: ".concat(String.valueOf(outputFormat)));
        int integer = outputFormat.getInteger("width");
        int integer2 = outputFormat.getInteger("height");
        int min = Math.min(Math.abs(outputFormat.getInteger("crop-right") - outputFormat.getInteger("crop-left")) + 1, integer);
        int min2 = Math.min(Math.abs(outputFormat.getInteger("crop-bottom") - outputFormat.getInteger("crop-top")) + 1, integer2);
        if (min == this.f1228d && min2 == this.f1229e) {
            if (this.f1232h) {
                this.f1232h = false;
                if (this.r != null) {
                    this.r.onVideoSizeChange(this.f1228d, this.f1229e);
                }
            }
            AppMethodBeat.o(259956);
            return;
        }
        if (this.f1234j && !e.b(min, min2, 20)) {
            e();
            Monitor.a(2, String.format(Locale.getDefault(), "outputFormatChange: dynamic change resolution but change to a not support resolution: %s, oldwidth = %d,oldheight = %d, newwidth = %d, newheight=", TXCCommonUtil.getDeviceInfo(), Integer.valueOf(this.f1228d), Integer.valueOf(this.f1229e), Integer.valueOf(min), Integer.valueOf(min2)), "", 0);
        }
        this.f1228d = min;
        this.f1229e = min2;
        try {
            if (this.r != null) {
                this.r.onVideoSizeChange(this.f1228d, this.f1229e);
            }
        } catch (Exception e2) {
            TXCLog.e("MediaCodecDecoder", "onVideoSizeChange failed.", e2);
        }
        TXCLog.i("MediaCodecDecoder", "decode: video size change to w:" + min + ",h:" + min2);
        AppMethodBeat.o(259956);
    }

    private void d() {
        AppMethodBeat.i(259957);
        if (this.f1230f == 0) {
            TXCLog.w("MediaCodecDecoder", "decode first frame sucess");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f1230f > 0 && currentTimeMillis > this.f1230f + 1000 && currentTimeMillis > this.f1231g + 2000 && this.f1231g != 0) {
            TXCLog.e("MediaCodecDecoder", "frame interval[" + (currentTimeMillis - this.f1230f) + "] > 1000");
            this.f1231g = currentTimeMillis;
        }
        if (this.f1231g == 0) {
            this.f1231g = currentTimeMillis;
        }
        this.f1230f = currentTimeMillis;
        AppMethodBeat.o(259957);
    }

    private void e() {
        int i2 = 1;
        AppMethodBeat.i(259958);
        if (!this.f1233i) {
            this.f1233i = true;
            TXCLog.e("MediaCodecDecoder", "[Video][Decoder] notify HWDecoder error, isHEVC:" + this.f1234j);
            if (this.f1234j) {
                com.tencent.liteav.basic.util.f.a(this.u, -2304, "h265 Decoding failed");
                Locale locale = Locale.getDefault();
                Object[] objArr = new Object[3];
                objArr[0] = TXCCommonUtil.getDeviceInfo();
                objArr[1] = Integer.valueOf(e.b(1920, 1080, 20) ? 1 : 0);
                if (!e.a(1920, 1080, 20)) {
                    i2 = 0;
                }
                objArr[2] = Integer.valueOf(i2);
                String format = String.format(locale, "VideoDecoder: hevc hardware decoder error. %s, %d, %d", objArr);
                Monitor.a(2, format, "", 0);
                TXCLog.w("MediaCodecDecoder", format);
            } else {
                com.tencent.liteav.basic.util.f.a(this.u, 2106, "Failed to enable hardware decoding，use software decoding.");
            }
            if (this.r != null) {
                this.r.onDecodeFailed(-1);
            }
        }
        AppMethodBeat.o(259958);
    }

    private void f() {
        AppMethodBeat.i(259959);
        if (this.l >= 40) {
            e();
            this.l = 0;
            AppMethodBeat.o(259959);
            return;
        }
        this.l++;
        AppMethodBeat.o(259959);
    }

    private void a(boolean z) {
        AppMethodBeat.i(259960);
        if (this.f1234j != z) {
            TXCLog.i("MediaCodecDecoder", "[Video][Decoder] nal data format changed, from:" + (this.f1234j ? "h265" : "h264") + " to:" + (z ? "h265" : "h264"));
            this.f1234j = z;
            if (!this.f1234j || e.b(this.f1228d, this.f1229e, 20)) {
                a();
                a(null, null, this.f1234j);
                if (this.r != null) {
                    this.r.onDecoderChange(this.f1227c, this.f1234j);
                }
            } else {
                a();
                e();
                AppMethodBeat.o(259960);
                return;
            }
        }
        AppMethodBeat.o(259960);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0085, code lost:
        r0 = r1 - r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.tencent.liteav.basic.structs.TXSNALPacket r9) {
        /*
        // Method dump skipped, instructions count: 256
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videodecoder.f.a(com.tencent.liteav.basic.structs.TXSNALPacket):void");
    }
}
