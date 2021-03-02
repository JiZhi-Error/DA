package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h implements f {
    private final r[] bcc;
    final com.google.android.exoplayer2.g.h bcd;
    private final g bce;
    private final i bcf;
    final CopyOnWriteArraySet<q.a> bcg;
    private final w.b bch;
    private final w.a bci;
    boolean bcj;
    boolean bck;
    int bcl;
    int bcm;
    int bcn;
    w bco;
    Object bcp;
    r bcq;
    g bcr;
    p bcs;
    i.b bct;
    int bcu;
    int bcv;
    long bcw;
    private final Handler eventHandler;
    boolean isLoading;
    private int repeatMode;

    @SuppressLint({"HandlerLeak"})
    public h(r[] rVarArr, com.google.android.exoplayer2.g.h hVar, m mVar) {
        AppMethodBeat.i(91891);
        new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.bHH).append("]");
        a.checkState(rVarArr.length > 0);
        this.bcc = (r[]) a.checkNotNull(rVarArr);
        this.bcd = (com.google.android.exoplayer2.g.h) a.checkNotNull(hVar);
        this.bck = false;
        this.repeatMode = 0;
        this.bcl = 1;
        this.bcg = new CopyOnWriteArraySet<>();
        this.bce = new g(new f[rVarArr.length]);
        this.bco = w.bel;
        this.bch = new w.b();
        this.bci = new w.a();
        this.bcq = r.bxh;
        this.bcr = this.bce;
        this.bcs = p.bdM;
        this.eventHandler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) {
            /* class com.google.android.exoplayer2.h.AnonymousClass1 */

            public final void handleMessage(Message message) {
                boolean z;
                AppMethodBeat.i(91890);
                h hVar = h.this;
                switch (message.what) {
                    case 0:
                        hVar.bcn--;
                        AppMethodBeat.o(91890);
                        return;
                    case 1:
                        hVar.bcl = message.arg1;
                        Iterator<q.a> it = hVar.bcg.iterator();
                        while (it.hasNext()) {
                            it.next().c(hVar.bck, hVar.bcl);
                        }
                        AppMethodBeat.o(91890);
                        return;
                    case 2:
                        if (message.arg1 != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        hVar.isLoading = z;
                        Iterator<q.a> it2 = hVar.bcg.iterator();
                        while (it2.hasNext()) {
                            it2.next().aR(hVar.isLoading);
                        }
                        AppMethodBeat.o(91890);
                        return;
                    case 3:
                        if (hVar.bcn == 0) {
                            com.google.android.exoplayer2.g.i iVar = (com.google.android.exoplayer2.g.i) message.obj;
                            hVar.bcj = true;
                            hVar.bcq = iVar.bEF;
                            hVar.bcr = iVar.bEG;
                            hVar.bcd.ah(iVar.info);
                            Iterator<q.a> it3 = hVar.bcg.iterator();
                            while (it3.hasNext()) {
                                it3.next().tz();
                            }
                            AppMethodBeat.o(91890);
                            return;
                        }
                        break;
                    case 4:
                        int i2 = hVar.bcm - 1;
                        hVar.bcm = i2;
                        if (i2 == 0) {
                            hVar.bct = (i.b) message.obj;
                            if (hVar.bco.isEmpty()) {
                                hVar.bcv = 0;
                                hVar.bcu = 0;
                                hVar.bcw = 0;
                            }
                            if (message.arg1 != 0) {
                                Iterator<q.a> it4 = hVar.bcg.iterator();
                                while (it4.hasNext()) {
                                    it4.next().tA();
                                }
                                AppMethodBeat.o(91890);
                                return;
                            }
                        }
                        break;
                    case 5:
                        if (hVar.bcm == 0) {
                            hVar.bct = (i.b) message.obj;
                            Iterator<q.a> it5 = hVar.bcg.iterator();
                            while (it5.hasNext()) {
                                it5.next().tA();
                            }
                            AppMethodBeat.o(91890);
                            return;
                        }
                        break;
                    case 6:
                        i.d dVar = (i.d) message.obj;
                        hVar.bcm -= dVar.bdk;
                        if (hVar.bcn == 0) {
                            hVar.bco = dVar.bco;
                            hVar.bcp = dVar.bcp;
                            hVar.bct = dVar.bct;
                            if (hVar.bcm == 0 && hVar.bco.isEmpty()) {
                                hVar.bcv = 0;
                                hVar.bcu = 0;
                                hVar.bcw = 0;
                            }
                            Iterator<q.a> it6 = hVar.bcg.iterator();
                            while (it6.hasNext()) {
                                it6.next().ty();
                            }
                            AppMethodBeat.o(91890);
                            return;
                        }
                        break;
                    case 7:
                        p pVar = (p) message.obj;
                        if (!hVar.bcs.equals(pVar)) {
                            hVar.bcs = pVar;
                            Iterator<q.a> it7 = hVar.bcg.iterator();
                            while (it7.hasNext()) {
                                it7.next().b(pVar);
                            }
                            AppMethodBeat.o(91890);
                            return;
                        }
                        break;
                    case 8:
                        e eVar = (e) message.obj;
                        Iterator<q.a> it8 = hVar.bcg.iterator();
                        while (it8.hasNext()) {
                            it8.next().a(eVar);
                        }
                        AppMethodBeat.o(91890);
                        return;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException();
                        AppMethodBeat.o(91890);
                        throw illegalStateException;
                }
                AppMethodBeat.o(91890);
            }
        };
        this.bct = new i.b(0);
        this.bcf = new i(rVarArr, hVar, mVar, this.bck, this.repeatMode, this.eventHandler, this.bct, this);
        AppMethodBeat.o(91891);
    }

    @Override // com.google.android.exoplayer2.q
    public final void a(q.a aVar) {
        AppMethodBeat.i(91892);
        this.bcg.add(aVar);
        AppMethodBeat.o(91892);
    }

    @Override // com.google.android.exoplayer2.q
    public final void b(q.a aVar) {
        AppMethodBeat.i(91893);
        this.bcg.remove(aVar);
        AppMethodBeat.o(91893);
    }

    @Override // com.google.android.exoplayer2.q
    public final int ti() {
        return this.bcl;
    }

    @Override // com.google.android.exoplayer2.q
    public final void aO(boolean z) {
        int i2;
        AppMethodBeat.i(91895);
        if (this.bck != z) {
            this.bck = z;
            Handler handler = this.bcf.handler;
            if (z) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            handler.obtainMessage(1, i2, 0).sendToTarget();
            Iterator<q.a> it = this.bcg.iterator();
            while (it.hasNext()) {
                it.next().c(z, this.bcl);
            }
        }
        AppMethodBeat.o(91895);
    }

    @Override // com.google.android.exoplayer2.q
    public final boolean tj() {
        return this.bck;
    }

    @Override // com.google.android.exoplayer2.q
    public final void setRepeatMode(int i2) {
        AppMethodBeat.i(91896);
        if (this.repeatMode != i2) {
            this.repeatMode = i2;
            this.bcf.handler.obtainMessage(12, i2, 0).sendToTarget();
            Iterator<q.a> it = this.bcg.iterator();
            while (it.hasNext()) {
                it.next().aA(i2);
            }
        }
        AppMethodBeat.o(91896);
    }

    @Override // com.google.android.exoplayer2.q
    public final boolean isLoading() {
        return this.isLoading;
    }

    @Override // com.google.android.exoplayer2.q
    public final void seekTo(long j2) {
        long w;
        AppMethodBeat.i(91897);
        int tk = tk();
        if (tk < 0 || (!this.bco.isEmpty() && tk >= this.bco.tD())) {
            l lVar = new l(this.bco, tk, j2);
            AppMethodBeat.o(91897);
            throw lVar;
        }
        this.bcm++;
        this.bcu = tk;
        if (this.bco.isEmpty()) {
            this.bcv = 0;
        } else {
            this.bco.a(tk, this.bch);
            if (j2 == -9223372036854775807L) {
                w = this.bch.beA;
            } else {
                w = b.w(j2);
            }
            int i2 = this.bch.bey;
            long j3 = this.bch.beB + w;
            long j4 = this.bco.a(i2, this.bci, false).bdJ;
            while (j4 != -9223372036854775807L && j3 >= j4 && i2 < this.bch.bez) {
                j3 -= j4;
                i2++;
                j4 = this.bco.a(i2, this.bci, false).bdJ;
            }
            this.bcv = i2;
        }
        if (j2 == -9223372036854775807L) {
            this.bcw = 0;
            this.bcf.a(this.bco, tk, -9223372036854775807L);
            AppMethodBeat.o(91897);
            return;
        }
        this.bcw = j2;
        this.bcf.a(this.bco, tk, b.w(j2));
        Iterator<q.a> it = this.bcg.iterator();
        while (it.hasNext()) {
            it.next().tA();
        }
        AppMethodBeat.o(91897);
    }

    @Override // com.google.android.exoplayer2.q
    public final void a(p pVar) {
        AppMethodBeat.i(91898);
        if (pVar == null) {
            pVar = p.bdM;
        }
        this.bcf.handler.obtainMessage(4, pVar).sendToTarget();
        AppMethodBeat.o(91898);
    }

    @Override // com.google.android.exoplayer2.q
    public final void stop() {
        AppMethodBeat.i(91899);
        this.bcf.handler.sendEmptyMessage(5);
        AppMethodBeat.o(91899);
    }

    @Override // com.google.android.exoplayer2.q
    public final void release() {
        AppMethodBeat.i(91900);
        new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.bHH).append("] [").append(j.tu()).append("]");
        this.bcf.release();
        this.eventHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(91900);
    }

    @Override // com.google.android.exoplayer2.f
    public final void a(f.c... cVarArr) {
        AppMethodBeat.i(91901);
        i iVar = this.bcf;
        if (!iVar.released) {
            iVar.bcJ++;
            iVar.handler.obtainMessage(11, cVarArr).sendToTarget();
        }
        AppMethodBeat.o(91901);
    }

    @Override // com.google.android.exoplayer2.f
    public final void b(f.c... cVarArr) {
        AppMethodBeat.i(91902);
        this.bcf.b(cVarArr);
        AppMethodBeat.o(91902);
    }

    private int tk() {
        AppMethodBeat.i(91903);
        if (this.bco.isEmpty() || this.bcm > 0) {
            int i2 = this.bcu;
            AppMethodBeat.o(91903);
            return i2;
        }
        int i3 = this.bco.a(this.bct.bdd.bwx, this.bci, false).bdi;
        AppMethodBeat.o(91903);
        return i3;
    }

    @Override // com.google.android.exoplayer2.q
    public final long getDuration() {
        boolean z;
        AppMethodBeat.i(91904);
        if (this.bco.isEmpty()) {
            AppMethodBeat.o(91904);
            return -9223372036854775807L;
        }
        if (this.bco.isEmpty() || this.bcm != 0 || !this.bct.bdd.isAd()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            k.b bVar = this.bct.bdd;
            this.bco.a(bVar.bwx, this.bci, false);
            long v = b.v(this.bci.bb(bVar.bwy, bVar.bwz));
            AppMethodBeat.o(91904);
            return v;
        }
        long v2 = b.v(this.bco.a(tk(), this.bch).bdJ);
        AppMethodBeat.o(91904);
        return v2;
    }

    @Override // com.google.android.exoplayer2.q
    public final long getCurrentPosition() {
        AppMethodBeat.i(91905);
        if (this.bco.isEmpty() || this.bcm > 0) {
            long j2 = this.bcw;
            AppMethodBeat.o(91905);
            return j2;
        }
        long y = y(this.bct.bdg);
        AppMethodBeat.o(91905);
        return y;
    }

    @Override // com.google.android.exoplayer2.q
    public final long getBufferedPosition() {
        AppMethodBeat.i(91906);
        if (this.bco.isEmpty() || this.bcm > 0) {
            long j2 = this.bcw;
            AppMethodBeat.o(91906);
            return j2;
        }
        long y = y(this.bct.bdh);
        AppMethodBeat.o(91906);
        return y;
    }

    @Override // com.google.android.exoplayer2.q
    public final int getBufferedPercentage() {
        AppMethodBeat.i(91907);
        if (this.bco.isEmpty()) {
            AppMethodBeat.o(91907);
            return 0;
        }
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            AppMethodBeat.o(91907);
            return 0;
        } else if (duration == 0) {
            AppMethodBeat.o(91907);
            return 100;
        } else {
            int s = x.s((int) ((bufferedPosition * 100) / duration), 0, 100);
            AppMethodBeat.o(91907);
            return s;
        }
    }

    private long y(long j2) {
        AppMethodBeat.i(91908);
        long v = b.v(j2);
        if (!this.bct.bdd.isAd()) {
            this.bco.a(this.bct.bdd.bwx, this.bci, false);
            v += b.v(this.bci.ben);
        }
        AppMethodBeat.o(91908);
        return v;
    }

    @Override // com.google.android.exoplayer2.f
    public final void a(k kVar) {
        AppMethodBeat.i(91894);
        if (!this.bco.isEmpty() || this.bcp != null) {
            this.bco = w.bel;
            this.bcp = null;
            Iterator<q.a> it = this.bcg.iterator();
            while (it.hasNext()) {
                it.next().ty();
            }
        }
        if (this.bcj) {
            this.bcj = false;
            this.bcq = r.bxh;
            this.bcr = this.bce;
            this.bcd.ah(null);
            Iterator<q.a> it2 = this.bcg.iterator();
            while (it2.hasNext()) {
                it2.next().tz();
            }
        }
        this.bcn++;
        this.bcf.handler.obtainMessage(0, 1, 0, kVar).sendToTarget();
        AppMethodBeat.o(91894);
    }
}
