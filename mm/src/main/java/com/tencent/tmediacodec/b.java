package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.b.c;
import com.tencent.tmediacodec.g.d;
import com.tencent.tmediacodec.g.e;
import java.io.IOException;
import java.util.Map;

public final class b {
    public boolean Slj;
    public boolean Slk;
    public c Sll;
    public com.tencent.tmediacodec.a.a Slm;
    final com.tencent.tmediacodec.f.a Sln;
    public boolean Slo = true;
    private boolean Slp;
    final String Slq;
    EnumC2217b Slr;

    public static abstract class a {
        public abstract void onError(b bVar, MediaCodec.CodecException codecException);

        public abstract void onInputBufferAvailable(b bVar, int i2);

        public abstract void onOutputBufferAvailable(b bVar, int i2, MediaCodec.BufferInfo bufferInfo);

        public abstract void onOutputFormatChanged(b bVar, MediaFormat mediaFormat);
    }

    public b(String str, EnumC2217b bVar) {
        AppMethodBeat.i(190089);
        this.Slq = str;
        this.Slr = bVar;
        this.Sln = new com.tencent.tmediacodec.f.a(d.by(this.Slq));
        AppMethodBeat.o(190089);
    }

    public final void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto) {
        AppMethodBeat.i(190090);
        if (this.Slp) {
            new StringBuilder("configure ignored, mediaFormat:").append(mediaFormat).append(" surface:").append(surface).append(" crypto:").append(mediaCrypto).append(" flags:0 stack:").append(Log.getStackTraceString(new Throwable()));
            com.tencent.tmediacodec.g.b.bqS("TMediaCodec");
            AppMethodBeat.o(190090);
            return;
        }
        this.Slp = true;
        hpp();
        try {
            this.Sll = a.hpn().a(mediaFormat, surface, mediaCrypto, this);
        } catch (IOException e2) {
            "createCodec mediaFormat:".concat(String.valueOf(mediaFormat));
            com.tencent.tmediacodec.g.b.bqV("TMediaCodec");
        }
        hpq();
        AppMethodBeat.o(190090);
    }

    public final void start() {
        AppMethodBeat.i(190091);
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder("start codecWrapper:").append(this.Sll);
            com.tencent.tmediacodec.g.b.bqQ("TMediaCodec");
        }
        this.Sln.SmP = System.currentTimeMillis();
        if (this.Sll != null) {
            this.Sll.start();
        }
        hpr();
        AppMethodBeat.o(190091);
    }

    private void hpp() {
        AppMethodBeat.i(190092);
        this.Sln.hpE();
        this.Sln.hpF();
        this.Sln.Ed(this.Slj);
        AppMethodBeat.o(190092);
    }

    private void hpq() {
        AppMethodBeat.i(190093);
        this.Sln.Ee(this.Slk);
        e.bb(new Runnable() {
            /* class com.tencent.tmediacodec.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(190080);
                if (b.this.Sll != null) {
                    b.this.Sll.a(b.this.Slm);
                }
                if (b.this.Slm != null) {
                    b.this.Slm.onCreate(Boolean.valueOf(b.this.Slk));
                }
                AppMethodBeat.o(190080);
            }
        });
        AppMethodBeat.o(190093);
    }

    private void hpr() {
        AppMethodBeat.i(190094);
        this.Sln.hpG();
        e.bb(new Runnable() {
            /* class com.tencent.tmediacodec.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(190081);
                if (b.this.Slm != null) {
                    com.tencent.tmediacodec.a.a aVar = b.this.Slm;
                    Boolean valueOf = Boolean.valueOf(b.this.Slk);
                    com.tencent.tmediacodec.f.a aVar2 = b.this.Sln;
                    if (TextUtils.isEmpty(aVar2.SmT)) {
                        StringBuilder sb = new StringBuilder("{");
                        sb.append("\"isVideo\":");
                        sb.append(aVar2.SmU + " ,");
                        if (aVar2.SmS) {
                            sb.append("\"isReuse\":");
                            sb.append(aVar2.SmQ + " ,");
                        }
                        sb.append("\"reuseEnable\":");
                        sb.append(aVar2.SmR + " ,");
                        long j2 = 0;
                        for (Map.Entry<String, Long> entry : aVar2.SmO.entrySet()) {
                            if (entry != null) {
                                j2 += entry.getValue().longValue();
                            }
                            sb.append("\"" + ((Object) entry.getKey()) + "\":");
                            sb.append(entry.getValue().longValue() + " ,");
                        }
                        sb.append("\"totalCodec\":");
                        sb.append(j2);
                        sb.append("}");
                        aVar2.SmT = sb.toString();
                    }
                    aVar.onStarted(valueOf, aVar2.SmT);
                }
                AppMethodBeat.o(190081);
            }
        });
        AppMethodBeat.o(190094);
    }

    public final void a(int i2, MediaCodec.CryptoInfo cryptoInfo, long j2, int i3) {
        MediaCodec hps;
        AppMethodBeat.i(190095);
        if (!(this.Sll == null || (hps = this.Sll.hps()) == null)) {
            hps.queueSecureInputBuffer(i2, 0, cryptoInfo, j2, i3);
        }
        AppMethodBeat.o(190095);
    }

    public final void a(int i2, int i3, long j2, int i4) {
        AppMethodBeat.i(190096);
        if (this.Sll != null) {
            this.Sll.a(i2, i3, j2, i4);
        }
        AppMethodBeat.o(190096);
    }

    public final int dequeueInputBuffer(long j2) {
        AppMethodBeat.i(190097);
        if (this.Sll != null) {
            int dequeueInputBuffer = this.Sll.dequeueInputBuffer(j2);
            AppMethodBeat.o(190097);
            return dequeueInputBuffer;
        }
        AppMethodBeat.o(190097);
        return -1000;
    }

    public final void releaseOutputBuffer(int i2, boolean z) {
        AppMethodBeat.i(190098);
        if (this.Sll != null) {
            this.Sll.releaseOutputBuffer(i2, z);
        }
        AppMethodBeat.o(190098);
    }

    @TargetApi(21)
    public static final class c extends MediaCodec.Callback {
        private final b Slw;
        private final a Slx;

        public c(b bVar, a aVar) {
            this.Slw = bVar;
            this.Slx = aVar;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
            AppMethodBeat.i(190085);
            if (this.Slx != null) {
                this.Slx.onOutputBufferAvailable(this.Slw, i2, bufferInfo);
            }
            AppMethodBeat.o(190085);
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
            AppMethodBeat.i(190086);
            if (this.Slx != null) {
                this.Slx.onInputBufferAvailable(this.Slw, i2);
            }
            AppMethodBeat.o(190086);
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.i(190087);
            if (this.Slx != null) {
                this.Slx.onOutputFormatChanged(this.Slw, mediaFormat);
            }
            AppMethodBeat.o(190087);
        }

        public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            AppMethodBeat.i(190088);
            if (this.Slx != null) {
                this.Slx.onError(this.Slw, codecException);
            }
            AppMethodBeat.o(190088);
        }
    }

    /* renamed from: com.tencent.tmediacodec.b$b  reason: collision with other inner class name */
    public enum EnumC2217b {
        CreateByName,
        CreateByType;

        public static EnumC2217b valueOf(String str) {
            AppMethodBeat.i(190083);
            EnumC2217b bVar = (EnumC2217b) Enum.valueOf(EnumC2217b.class, str);
            AppMethodBeat.o(190083);
            return bVar;
        }

        static {
            AppMethodBeat.i(190084);
            AppMethodBeat.o(190084);
        }
    }
}
