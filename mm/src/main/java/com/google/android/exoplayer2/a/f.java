package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.coremedia.TimeUtil;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public final class f {
    public static boolean bfb = false;
    public static boolean bfc = false;
    p bcs;
    int beh;
    b bei;
    private long bfA;
    private boolean bfB;
    private long bfC;
    private Method bfD;
    int bfE;
    long bfF;
    long bfG;
    int bfH;
    private long bfI;
    private long bfJ;
    int bfK;
    int bfL;
    long bfM;
    private long bfN;
    private long bfO;
    private d[] bfP;
    private ByteBuffer[] bfQ;
    ByteBuffer bfR;
    private byte[] bfS;
    private int bfT;
    private int bfU;
    boolean bfV;
    boolean bfW;
    boolean bfX;
    boolean bfY;
    long bfZ;
    private final c bfd;
    final g bfe;
    private final l bff;
    final d[] bfg;
    final AbstractC0099f bfh;
    final ConditionVariable bfi = new ConditionVariable(true);
    private final long[] bfj;
    final a bfk;
    final LinkedList<g> bfl;
    AudioTrack bfm;
    AudioTrack bfn;
    int bfo;
    boolean bfp;
    long bfq;
    p bfr;
    private long bft;
    private long bfu;
    private ByteBuffer bfv;
    int bfw;
    private int bfx;
    private int bfy;
    private long bfz;
    int bufferSize;
    int channelConfig;
    int encoding;
    private ByteBuffer outputBuffer;
    int sampleRate;
    float volume;

    /* renamed from: com.google.android.exoplayer2.a.f$f  reason: collision with other inner class name */
    public interface AbstractC0099f {
        void dG(int i2);

        void e(int i2, long j2, long j3);

        void tA();
    }

    public static final class c extends Exception {
        public c(Throwable th) {
            super(th);
        }

        public c(String str) {
            super(str);
        }
    }

    public static final class d extends Exception {
        public final int bgn;

        public d(int i2, int i3, int i4, int i5) {
            super("AudioTrack init failed: " + i2 + ", Config(" + i3 + ", " + i4 + ", " + i5 + ")");
            AppMethodBeat.i(91783);
            this.bgn = i2;
            AppMethodBeat.o(91783);
        }
    }

    public static final class h extends Exception {
        public final int errorCode;

        public h(int i2) {
            super("AudioTrack write failed: ".concat(String.valueOf(i2)));
            AppMethodBeat.i(91784);
            this.errorCode = i2;
            AppMethodBeat.o(91784);
        }
    }

    public static final class e extends RuntimeException {
        public e(String str) {
            super(str);
        }
    }

    public f(c cVar, d[] dVarArr, AbstractC0099f fVar) {
        AppMethodBeat.i(91785);
        this.bfd = cVar;
        this.bfh = fVar;
        if (x.SDK_INT >= 18) {
            try {
                this.bfD = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e2) {
            }
        }
        if (x.SDK_INT >= 19) {
            this.bfk = new b();
        } else {
            this.bfk = new a((byte) 0);
        }
        this.bfe = new g();
        this.bff = new l();
        this.bfg = new d[(dVarArr.length + 3)];
        this.bfg[0] = new j();
        this.bfg[1] = this.bfe;
        System.arraycopy(dVarArr, 0, this.bfg, 2, dVarArr.length);
        this.bfg[dVarArr.length + 2] = this.bff;
        this.bfj = new long[10];
        this.volume = 1.0f;
        this.bfL = 0;
        this.bei = b.beJ;
        this.beh = 0;
        this.bcs = p.bdM;
        this.bfU = -1;
        this.bfP = new d[0];
        this.bfQ = new ByteBuffer[0];
        this.bfl = new LinkedList<>();
        AppMethodBeat.o(91785);
    }

    public final boolean bd(String str) {
        boolean z;
        AppMethodBeat.i(91786);
        if (this.bfd != null) {
            if (Arrays.binarySearch(this.bfd.supportedEncodings, be(str)) >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(91786);
                return true;
            }
        }
        AppMethodBeat.o(91786);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void tK() {
        AppMethodBeat.i(91788);
        ArrayList arrayList = new ArrayList();
        d[] dVarArr = this.bfg;
        for (d dVar : dVarArr) {
            if (dVar.isActive()) {
                arrayList.add(dVar);
            } else {
                dVar.flush();
            }
        }
        int size = arrayList.size();
        this.bfP = (d[]) arrayList.toArray(new d[size]);
        this.bfQ = new ByteBuffer[size];
        for (int i2 = 0; i2 < size; i2++) {
            d dVar2 = this.bfP[i2];
            dVar2.flush();
            this.bfQ[i2] = dVar2.tJ();
        }
        AppMethodBeat.o(91788);
    }

    public final void play() {
        AppMethodBeat.i(91789);
        this.bfW = true;
        if (isInitialized()) {
            this.bfN = System.nanoTime() / 1000;
            this.bfn.play();
        }
        AppMethodBeat.o(91789);
    }

    /* access modifiers changed from: package-private */
    public final void G(long j2) {
        AppMethodBeat.i(91790);
        int length = this.bfP.length;
        int i2 = length;
        while (i2 >= 0) {
            ByteBuffer byteBuffer = i2 > 0 ? this.bfQ[i2 - 1] : this.bfR != null ? this.bfR : d.beO;
            if (i2 == length) {
                a(byteBuffer, j2);
            } else {
                d dVar = this.bfP[i2];
                dVar.f(byteBuffer);
                ByteBuffer tJ = dVar.tJ();
                this.bfQ[i2] = tJ;
                if (tJ.hasRemaining()) {
                    i2++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                AppMethodBeat.o(91790);
                return;
            }
            i2--;
        }
        AppMethodBeat.o(91790);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ByteBuffer byteBuffer, long j2) {
        int write;
        boolean z;
        boolean z2;
        AppMethodBeat.i(91791);
        if (!byteBuffer.hasRemaining()) {
            AppMethodBeat.o(91791);
            return true;
        }
        if (this.outputBuffer != null) {
            if (this.outputBuffer == byteBuffer) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.google.android.exoplayer2.i.a.checkArgument(z2);
        } else {
            this.outputBuffer = byteBuffer;
            if (x.SDK_INT < 21) {
                int remaining = byteBuffer.remaining();
                if (this.bfS == null || this.bfS.length < remaining) {
                    this.bfS = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.bfS, 0, remaining);
                byteBuffer.position(position);
                this.bfT = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (x.SDK_INT < 21) {
            int tU = this.bufferSize - ((int) (this.bfI - (this.bfk.tU() * ((long) this.bfH))));
            if (tU > 0) {
                write = this.bfn.write(this.bfS, this.bfT, Math.min(remaining2, tU));
                if (write > 0) {
                    this.bfT += write;
                    byteBuffer.position(byteBuffer.position() + write);
                }
            } else {
                write = 0;
            }
        } else if (this.bfX) {
            if (j2 != -9223372036854775807L) {
                z = true;
            } else {
                z = false;
            }
            com.google.android.exoplayer2.i.a.checkState(z);
            write = a(this.bfn, byteBuffer, remaining2, j2);
        } else {
            write = this.bfn.write(byteBuffer, remaining2, 1);
        }
        this.bfZ = SystemClock.elapsedRealtime();
        if (write < 0) {
            h hVar = new h(write);
            AppMethodBeat.o(91791);
            throw hVar;
        }
        if (!this.bfp) {
            this.bfI += (long) write;
        }
        if (write == remaining2) {
            if (this.bfp) {
                this.bfJ += (long) this.bfK;
            }
            this.outputBuffer = null;
            AppMethodBeat.o(91791);
            return true;
        }
        AppMethodBeat.o(91791);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean tL() {
        boolean z;
        AppMethodBeat.i(91792);
        if (this.bfU == -1) {
            this.bfU = this.bfp ? this.bfP.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (this.bfU < this.bfP.length) {
            d dVar = this.bfP[this.bfU];
            if (z) {
                dVar.tI();
            }
            G(-9223372036854775807L);
            if (!dVar.tB()) {
                AppMethodBeat.o(91792);
                return false;
            }
            this.bfU++;
            z = true;
        }
        if (this.outputBuffer != null) {
            a(this.outputBuffer, -9223372036854775807L);
            if (this.outputBuffer != null) {
                AppMethodBeat.o(91792);
                return false;
            }
        }
        this.bfU = -1;
        AppMethodBeat.o(91792);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r2 != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean tM() {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            r6 = 91793(0x16691, float:1.2863E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            boolean r2 = r7.isInitialized()
            if (r2 == 0) goto L_0x003c
            long r2 = r7.tQ()
            com.google.android.exoplayer2.a.f$a r4 = r7.bfk
            long r4 = r4.tU()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0036
            boolean r2 = r7.tS()
            if (r2 == 0) goto L_0x003a
            android.media.AudioTrack r2 = r7.bfn
            int r2 = r2.getPlayState()
            r3 = 2
            if (r2 != r3) goto L_0x003a
            android.media.AudioTrack r2 = r7.bfn
            int r2 = r2.getPlaybackHeadPosition()
            if (r2 != 0) goto L_0x003a
            r2 = r0
        L_0x0034:
            if (r2 == 0) goto L_0x003c
        L_0x0036:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0039:
            return r0
        L_0x003a:
            r2 = r1
            goto L_0x0034
        L_0x003c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            r0 = r1
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.f.tM():boolean");
    }

    public final p c(p pVar) {
        p pVar2;
        AppMethodBeat.i(91794);
        if (this.bfp) {
            this.bcs = p.bdM;
            p pVar3 = this.bcs;
            AppMethodBeat.o(91794);
            return pVar3;
        }
        l lVar = this.bff;
        lVar.bdN = x.k(pVar.bdN, 0.1f, 8.0f);
        float f2 = lVar.bdN;
        l lVar2 = this.bff;
        float f3 = pVar.pitch;
        lVar2.pitch = x.k(f3, 0.1f, 8.0f);
        p pVar4 = new p(f2, f3);
        if (this.bfr != null) {
            pVar2 = this.bfr;
        } else if (!this.bfl.isEmpty()) {
            pVar2 = this.bfl.getLast().bcs;
        } else {
            pVar2 = this.bcs;
        }
        if (!pVar4.equals(pVar2)) {
            if (isInitialized()) {
                this.bfr = pVar4;
            } else {
                this.bcs = pVar4;
            }
        }
        p pVar5 = this.bcs;
        AppMethodBeat.o(91794);
        return pVar5;
    }

    /* access modifiers changed from: package-private */
    public final void tN() {
        AppMethodBeat.i(91795);
        if (isInitialized()) {
            if (x.SDK_INT >= 21) {
                this.bfn.setVolume(this.volume);
                AppMethodBeat.o(91795);
                return;
            }
            AudioTrack audioTrack = this.bfn;
            float f2 = this.volume;
            audioTrack.setStereoVolume(f2, f2);
        }
        AppMethodBeat.o(91795);
    }

    public final void reset() {
        AppMethodBeat.i(91796);
        if (isInitialized()) {
            this.bfF = 0;
            this.bfG = 0;
            this.bfI = 0;
            this.bfJ = 0;
            this.bfK = 0;
            if (this.bfr != null) {
                this.bcs = this.bfr;
                this.bfr = null;
            } else if (!this.bfl.isEmpty()) {
                this.bcs = this.bfl.getLast().bcs;
            }
            this.bfl.clear();
            this.bft = 0;
            this.bfu = 0;
            this.bfR = null;
            this.outputBuffer = null;
            for (int i2 = 0; i2 < this.bfP.length; i2++) {
                d dVar = this.bfP[i2];
                dVar.flush();
                this.bfQ[i2] = dVar.tJ();
            }
            this.bfV = false;
            this.bfU = -1;
            this.bfv = null;
            this.bfw = 0;
            this.bfL = 0;
            this.bfO = 0;
            tR();
            if (this.bfn.getPlayState() == 3) {
                this.bfn.pause();
            }
            final AudioTrack audioTrack = this.bfn;
            this.bfn = null;
            this.bfk.a(null, false);
            this.bfi.close();
            new Thread() {
                /* class com.google.android.exoplayer2.a.f.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(91771);
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        f.this.bfi.open();
                        AppMethodBeat.o(91771);
                    }
                }
            }.start();
        }
        AppMethodBeat.o(91796);
    }

    /* access modifiers changed from: package-private */
    public final void tO() {
        AppMethodBeat.i(91797);
        if (this.bfm == null) {
            AppMethodBeat.o(91797);
            return;
        }
        final AudioTrack audioTrack = this.bfm;
        this.bfm = null;
        new Thread() {
            /* class com.google.android.exoplayer2.a.f.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(91772);
                audioTrack.release();
                AppMethodBeat.o(91772);
            }
        }.start();
        AppMethodBeat.o(91797);
    }

    private long H(long j2) {
        AppMethodBeat.i(91798);
        while (!this.bfl.isEmpty() && j2 >= this.bfl.getFirst().bdg) {
            g remove = this.bfl.remove();
            this.bcs = remove.bcs;
            this.bfu = remove.bdg;
            this.bft = remove.bgo - this.bfM;
        }
        if (this.bcs.bdN == 1.0f) {
            long j3 = (this.bft + j2) - this.bfu;
            AppMethodBeat.o(91798);
            return j3;
        } else if (!this.bfl.isEmpty() || this.bff.bhc < 1024) {
            long j4 = this.bft + ((long) (((double) this.bcs.bdN) * ((double) (j2 - this.bfu))));
            AppMethodBeat.o(91798);
            return j4;
        } else {
            long b2 = x.b(j2 - this.bfu, this.bff.bhb, this.bff.bhc) + this.bft;
            AppMethodBeat.o(91798);
            return b2;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isInitialized() {
        return this.bfn != null;
    }

    /* access modifiers changed from: package-private */
    public final long I(long j2) {
        return (TimeUtil.SECOND_TO_US * j2) / ((long) this.sampleRate);
    }

    /* access modifiers changed from: package-private */
    public final long J(long j2) {
        return (((long) this.sampleRate) * j2) / TimeUtil.SECOND_TO_US;
    }

    /* access modifiers changed from: package-private */
    public final long tP() {
        return this.bfp ? this.bfG : this.bfF / ((long) this.bfE);
    }

    /* access modifiers changed from: package-private */
    public final long tQ() {
        return this.bfp ? this.bfJ : this.bfI / ((long) this.bfH);
    }

    /* access modifiers changed from: package-private */
    public final void tR() {
        this.bfz = 0;
        this.bfy = 0;
        this.bfx = 0;
        this.bfA = 0;
        this.bfB = false;
        this.bfC = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean tS() {
        return x.SDK_INT < 23 && (this.bfo == 5 || this.bfo == 6);
    }

    /* access modifiers changed from: package-private */
    public final AudioTrack tT() {
        AudioTrack audioTrack;
        AudioAttributes audioAttributes;
        AppMethodBeat.i(91799);
        if (x.SDK_INT >= 21) {
            if (this.bfX) {
                audioAttributes = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
            } else {
                b bVar = this.bei;
                if (bVar.beM == null) {
                    bVar.beM = new AudioAttributes.Builder().setContentType(bVar.beK).setFlags(bVar.flags).setUsage(bVar.beL).build();
                }
                audioAttributes = bVar.beM;
            }
            audioTrack = new AudioTrack(audioAttributes, new AudioFormat.Builder().setChannelMask(this.channelConfig).setEncoding(this.bfo).setSampleRate(this.sampleRate).build(), this.bufferSize, 1, this.beh != 0 ? this.beh : 0);
        } else {
            int fh = x.fh(this.bei.beL);
            if (this.beh == 0) {
                audioTrack = new AudioTrack(fh, this.sampleRate, this.channelConfig, this.bfo, this.bufferSize, 1);
            } else {
                audioTrack = new AudioTrack(fh, this.sampleRate, this.channelConfig, this.bfo, this.bufferSize, 1, this.beh);
            }
        }
        int state = audioTrack.getState();
        if (state != 1) {
            try {
                audioTrack.release();
            } catch (Exception e2) {
            }
            d dVar = new d(state, this.sampleRate, this.channelConfig, this.bufferSize);
            AppMethodBeat.o(91799);
            throw dVar;
        }
        AppMethodBeat.o(91799);
        return audioTrack;
    }

    static int be(String str) {
        AppMethodBeat.i(91800);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c2 = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                AppMethodBeat.o(91800);
                return 5;
            case 1:
                AppMethodBeat.o(91800);
                return 6;
            case 2:
                AppMethodBeat.o(91800);
                return 7;
            case 3:
                AppMethodBeat.o(91800);
                return 8;
            default:
                AppMethodBeat.o(91800);
                return 0;
        }
    }

    @TargetApi(21)
    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        AppMethodBeat.i(91801);
        if (this.bfv == null) {
            this.bfv = ByteBuffer.allocate(16);
            this.bfv.order(ByteOrder.BIG_ENDIAN);
            this.bfv.putInt(1431633921);
        }
        if (this.bfw == 0) {
            this.bfv.putInt(4, i2);
            this.bfv.putLong(8, 1000 * j2);
            this.bfv.position(0);
            this.bfw = i2;
        }
        int remaining = this.bfv.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.bfv, remaining, 1);
            if (write < 0) {
                this.bfw = 0;
                AppMethodBeat.o(91801);
                return write;
            } else if (write < remaining) {
                AppMethodBeat.o(91801);
                return 0;
            }
        }
        int write2 = audioTrack.write(byteBuffer, i2, 1);
        if (write2 < 0) {
            this.bfw = 0;
            AppMethodBeat.o(91801);
            return write2;
        }
        this.bfw -= write2;
        AppMethodBeat.o(91801);
        return write2;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        protected AudioTrack bfn;
        private boolean bgc;
        private long bgd;
        private long bge;
        private long bgf;
        private long bgg;
        private long bgh;
        private long bgi;
        private int sampleRate;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public void a(AudioTrack audioTrack, boolean z) {
            AppMethodBeat.i(91773);
            this.bfn = audioTrack;
            this.bgc = z;
            this.bgg = -9223372036854775807L;
            this.bgd = 0;
            this.bge = 0;
            this.bgf = 0;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
            AppMethodBeat.o(91773);
        }

        public final void K(long j2) {
            AppMethodBeat.i(91774);
            this.bgh = tU();
            this.bgg = SystemClock.elapsedRealtime() * 1000;
            this.bgi = j2;
            this.bfn.stop();
            AppMethodBeat.o(91774);
        }

        public final void pause() {
            AppMethodBeat.i(91775);
            if (this.bgg != -9223372036854775807L) {
                AppMethodBeat.o(91775);
                return;
            }
            this.bfn.pause();
            AppMethodBeat.o(91775);
        }

        public final long tU() {
            AppMethodBeat.i(91776);
            if (this.bgg != -9223372036854775807L) {
                long min = Math.min(this.bgi, ((((SystemClock.elapsedRealtime() * 1000) - this.bgg) * ((long) this.sampleRate)) / TimeUtil.SECOND_TO_US) + this.bgh);
                AppMethodBeat.o(91776);
                return min;
            }
            int playState = this.bfn.getPlayState();
            if (playState == 1) {
                AppMethodBeat.o(91776);
                return 0;
            }
            long playbackHeadPosition = Util.MAX_32BIT_VALUE & ((long) this.bfn.getPlaybackHeadPosition());
            if (this.bgc) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.bgf = this.bgd;
                }
                playbackHeadPosition += this.bgf;
            }
            if (this.bgd > playbackHeadPosition) {
                this.bge++;
            }
            this.bgd = playbackHeadPosition;
            long j2 = playbackHeadPosition + (this.bge << 32);
            AppMethodBeat.o(91776);
            return j2;
        }

        public final long tV() {
            AppMethodBeat.i(91777);
            long tU = (tU() * TimeUtil.SECOND_TO_US) / ((long) this.sampleRate);
            AppMethodBeat.o(91777);
            return tU;
        }

        public boolean tW() {
            return false;
        }

        public long tX() {
            AppMethodBeat.i(91778);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(91778);
            throw unsupportedOperationException;
        }

        public long tY() {
            AppMethodBeat.i(91779);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(91779);
            throw unsupportedOperationException;
        }
    }

    @TargetApi(19)
    static class b extends a {
        private final AudioTimestamp bgj = new AudioTimestamp();
        private long bgk;
        private long bgl;
        private long bgm;

        public b() {
            super((byte) 0);
            AppMethodBeat.i(91780);
            AppMethodBeat.o(91780);
        }

        @Override // com.google.android.exoplayer2.a.f.a
        public final void a(AudioTrack audioTrack, boolean z) {
            AppMethodBeat.i(91781);
            super.a(audioTrack, z);
            this.bgk = 0;
            this.bgl = 0;
            this.bgm = 0;
            AppMethodBeat.o(91781);
        }

        @Override // com.google.android.exoplayer2.a.f.a
        public final boolean tW() {
            AppMethodBeat.i(91782);
            boolean timestamp = this.bfn.getTimestamp(this.bgj);
            if (timestamp) {
                long j2 = this.bgj.framePosition;
                if (this.bgl > j2) {
                    this.bgk++;
                }
                this.bgl = j2;
                this.bgm = j2 + (this.bgk << 32);
            }
            AppMethodBeat.o(91782);
            return timestamp;
        }

        @Override // com.google.android.exoplayer2.a.f.a
        public final long tX() {
            return this.bgj.nanoTime;
        }

        @Override // com.google.android.exoplayer2.a.f.a
        public final long tY() {
            return this.bgm;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class g {
        final p bcs;
        final long bdg;
        final long bgo;

        /* synthetic */ g(p pVar, long j2, long j3, byte b2) {
            this(pVar, j2, j3);
        }

        private g(p pVar, long j2, long j3) {
            this.bcs = pVar;
            this.bgo = j2;
            this.bdg = j3;
        }
    }

    public final long aS(boolean z) {
        boolean z2;
        long j2;
        AppMethodBeat.i(91787);
        if (!isInitialized() || this.bfL == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            AppMethodBeat.o(91787);
            return Long.MIN_VALUE;
        }
        if (this.bfn.getPlayState() == 3) {
            long tV = this.bfk.tV();
            if (tV != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.bfA >= 30000) {
                    this.bfj[this.bfx] = tV - nanoTime;
                    this.bfx = (this.bfx + 1) % 10;
                    if (this.bfy < 10) {
                        this.bfy++;
                    }
                    this.bfA = nanoTime;
                    this.bfz = 0;
                    for (int i2 = 0; i2 < this.bfy; i2++) {
                        this.bfz += this.bfj[i2] / ((long) this.bfy);
                    }
                }
                if (!tS() && nanoTime - this.bfC >= 500000) {
                    this.bfB = this.bfk.tW();
                    if (this.bfB) {
                        long tX = this.bfk.tX() / 1000;
                        long tY = this.bfk.tY();
                        if (tX >= this.bfN) {
                            if (Math.abs(tX - nanoTime) > 5000000) {
                                String str = "Spurious audio timestamp (system clock mismatch): " + tY + ", " + tX + ", " + nanoTime + ", " + tV + ", " + tP() + ", " + tQ();
                                if (bfc) {
                                    e eVar = new e(str);
                                    AppMethodBeat.o(91787);
                                    throw eVar;
                                }
                                this.bfB = false;
                            } else if (Math.abs(I(tY) - tV) > 5000000) {
                                String str2 = "Spurious audio timestamp (frame position mismatch): " + tY + ", " + tX + ", " + nanoTime + ", " + tV + ", " + tP() + ", " + tQ();
                                if (bfc) {
                                    e eVar2 = new e(str2);
                                    AppMethodBeat.o(91787);
                                    throw eVar2;
                                }
                            }
                        }
                        this.bfB = false;
                    }
                    if (this.bfD != null && !this.bfp) {
                        try {
                            this.bfO = (((long) ((Integer) this.bfD.invoke(this.bfn, null)).intValue()) * 1000) - this.bfq;
                            this.bfO = Math.max(this.bfO, 0L);
                            if (this.bfO > 5000000) {
                                new StringBuilder("Ignoring impossibly large audio latency: ").append(this.bfO);
                                this.bfO = 0;
                            }
                        } catch (Exception e2) {
                            this.bfD = null;
                        }
                    }
                    this.bfC = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.bfB) {
            j2 = I(J(nanoTime2 - (this.bfk.tX() / 1000)) + this.bfk.tY());
        } else {
            if (this.bfy == 0) {
                j2 = this.bfk.tV();
            } else {
                j2 = nanoTime2 + this.bfz;
            }
            if (!z) {
                j2 -= this.bfO;
            }
        }
        long H = H(j2) + this.bfM;
        AppMethodBeat.o(91787);
        return H;
    }
}
