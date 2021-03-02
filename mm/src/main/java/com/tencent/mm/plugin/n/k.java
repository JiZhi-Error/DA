package com.tencent.mm.plugin.n;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class k implements c {
    long bdG;
    public long durationMs;
    boolean guh;
    public int state;
    public h zrC;
    MMHandler zrD;
    MMHandler zrW;
    MMHandler zrX;
    MMHandler zrY;
    long zrZ;
    boolean zsa = false;
    public l zsb;
    boolean zsc = false;
    a zsd;
    int zse = -1;
    private MMHandler.Callback zsf = new MMHandler.Callback() {
        /* class com.tencent.mm.plugin.n.k.AnonymousClass1 */
        private int tIj = -1;
        private int zsi = -1;
        private int zsj = -1;
        private long zsk = -1;

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final boolean handleMessage(Message message) {
            boolean z;
            AppMethodBeat.i(133932);
            int i2 = message.what;
            if (!(this.zsk > 0 && Util.ticksToNow(this.zsk) <= 500 && this.zsi == i2 && this.tIj == k.this.state && this.zsj == k.this.zsb.state)) {
                Log.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", k.this.info(), Integer.valueOf(i2), Integer.valueOf(k.this.state), Integer.valueOf(k.this.zsb.state));
                this.zsk = Util.currentTicks();
                this.zsi = i2;
                this.tIj = k.this.state;
                this.zsj = k.this.zsb.state;
            }
            switch (i2) {
                case 0:
                    if (k.this.zsa && (k.this.guh || k.this.zsc)) {
                        k.this.zrD.obtainMessage(6).sendToTarget();
                    }
                    AppMethodBeat.o(133932);
                    break;
                case 2:
                    if (k.this.state < 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        boolean Qt = e.Qt(k.this.zsb.state);
                        if (k.this.zsd != null) {
                            Qt &= e.Qt(k.this.zsd.state);
                        }
                        if (Qt) {
                            k.this.setState(2);
                            k.this.zrD.obtainMessage(1).sendToTarget();
                        }
                        AppMethodBeat.o(133932);
                        break;
                    } else {
                        AppMethodBeat.o(133932);
                        break;
                    }
                case 7:
                    k.a(k.this);
                    AppMethodBeat.o(133932);
                    break;
                case 9:
                    if (!e.Qx(k.this.state)) {
                        if (!e.Qy(k.this.state) && !e.Qw(k.this.state)) {
                            boolean Qx = e.Qx(k.this.zsb.state);
                            if (k.this.zsd != null) {
                                Qx &= e.Qx(k.this.zsd.state);
                            }
                            if (Qx) {
                                k.this.setState(9);
                                k.this.zrD.obtainMessage(2).sendToTarget();
                            }
                            AppMethodBeat.o(133932);
                            break;
                        } else {
                            k.this.setState(9);
                            k.this.zrD.obtainMessage(2).sendToTarget();
                            AppMethodBeat.o(133932);
                            break;
                        }
                    } else {
                        AppMethodBeat.o(133932);
                        break;
                    }
                default:
                    AppMethodBeat.o(133932);
                    break;
            }
            return false;
        }
    };
    private MMHandler.Callback zsg = new MMHandler.Callback() {
        /* class com.tencent.mm.plugin.n.k.AnonymousClass2 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final boolean handleMessage(Message message) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(133933);
            switch (message.what) {
                case 1:
                    if (!k.this.zsb.prepare()) {
                        k.this.zrD.obtainMessage(5, -1, -1).sendToTarget();
                        AppMethodBeat.o(133933);
                        break;
                    } else {
                        k.this.durationMs = k.this.zsb.durationMs;
                        k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0);
                        AppMethodBeat.o(133933);
                        break;
                    }
                case 2:
                    h hVar = k.this.zrC;
                    long ticksToNow = Util.ticksToNow(hVar.zrv);
                    if (hVar.zrv > 0 && ticksToNow >= 30) {
                        Log.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", hVar.info(), Long.valueOf(hVar.zrv), Long.valueOf(ticksToNow));
                        hVar.zrw = 0;
                    }
                    if (e.Qx(k.this.zsb.state)) {
                        k.this.zrY.obtainMessage(9).sendToTarget();
                        k.this.zrW.removeMessages(2);
                    } else {
                        int Z = k.this.zsb.Z(k.this.bdG, k.this.zrZ);
                        if (e.Qt(Z)) {
                            k.this.zrY.obtainMessage(2).sendToTarget();
                        }
                        if (Z == 7) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            k.this.zrY.obtainMessage(7).sendToTarget();
                            k.this.zrW.removeMessages(2);
                        } else if (e.Qz(Z)) {
                            k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0);
                            k.this.zrC.zrv = Util.currentTicks();
                        } else {
                            if (k.this.state == 3) {
                                k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), k.this.zrC.zrw);
                            } else if (k.this.state == 5) {
                                k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0);
                            } else if (k.this.state == 1) {
                                k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0);
                            } else if (k.this.state == 0) {
                                k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0);
                            } else if (k.this.state == 6) {
                                k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0);
                            } else {
                                k.this.zrW.removeMessages(2);
                            }
                            k.this.zrC.zrv = Util.currentTicks();
                        }
                    }
                    AppMethodBeat.o(133933);
                    break;
                case 3:
                    k.this.QD(3);
                    k.this.zsb.start();
                    k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0);
                    AppMethodBeat.o(133933);
                    break;
                case 4:
                    k.this.QD(4);
                    k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0);
                    k.this.zsb.pause();
                    AppMethodBeat.o(133933);
                    break;
                case 5:
                    if (message.obj instanceof int[]) {
                        int[] iArr = (int[]) message.obj;
                        if (iArr.length == 2) {
                            int i2 = iArr[0];
                            boolean z3 = iArr[1] == 1;
                            long QB = k.this.zsb.QB(i2);
                            if (!z3 || QB < 0 || QB >= ((long) i2)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            Log.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", k.this.info(), Boolean.valueOf(z), Long.valueOf(QB), Integer.valueOf(i2));
                            k.this.zsb.setState(6);
                            k.this.setState(6);
                            if (z) {
                                k.this.zrC.zrs = (long) i2;
                            } else {
                                k.this.zrC.zrs = QB;
                            }
                            k.this.QD(6);
                            k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0);
                        } else {
                            Log.e("MicroMsg.VideoPlayerImpl", "seek data length error");
                        }
                    } else {
                        Log.e("MicroMsg.VideoPlayerImpl", "seek data type error");
                    }
                    AppMethodBeat.o(133933);
                    break;
                case 6:
                default:
                    AppMethodBeat.o(133933);
                    break;
                case 7:
                    k.this.zsb.release();
                    k.this.zsa = true;
                    k.this.zrY.obtainMessage(0).sendToTarget();
                    AppMethodBeat.o(133933);
                    break;
                case 8:
                    k.this.zsb.ejj();
                    AppMethodBeat.o(133933);
                    break;
            }
            return false;
        }
    };
    private MMHandler.Callback zsh = new MMHandler.Callback() {
        /* class com.tencent.mm.plugin.n.k.AnonymousClass3 */

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(133934);
            if (k.this.zsd == null) {
                AppMethodBeat.o(133934);
            } else {
                switch (message.what) {
                    case 1:
                        if (!k.this.zsd.prepare()) {
                            Log.i("MicroMsg.VideoPlayerImpl", "%s audio track prepare error, release now.", k.this.info());
                            k.this.zsd.release();
                            k.this.zsc = true;
                            k.this.zsd = null;
                        }
                        k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 2:
                        if (!e.Qx(k.this.zsd.state)) {
                            if (e.Qt(k.this.zsd.Z(k.this.bdG, k.this.zrZ))) {
                                k.this.zrY.sendMessageDelayed(k.this.zrY.obtainMessage(2), 10);
                            }
                            if (k.this.state != 3) {
                                if (k.this.state != 5) {
                                    if (k.this.state != 1) {
                                        if (k.this.state != 0) {
                                            k.this.zrX.removeMessages(2);
                                            break;
                                        } else {
                                            k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), 0);
                                            break;
                                        }
                                    } else {
                                        k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), 0);
                                        break;
                                    }
                                } else {
                                    k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), 0);
                                    break;
                                }
                            } else {
                                k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), k.this.zrC.zrw);
                                break;
                            }
                        } else {
                            k.this.zrY.obtainMessage(9).sendToTarget();
                            k.this.zrX.removeMessages(2);
                            break;
                        }
                    case 3:
                        k.this.zsd.start();
                        k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 4:
                        k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), 0);
                        k.this.zsd.pause();
                        break;
                    case 7:
                        k.this.zsd.release();
                        k.this.zsc = true;
                        k.this.zrY.obtainMessage(0).sendToTarget();
                        break;
                }
                AppMethodBeat.o(133934);
            }
            return false;
        }
    };

    static /* synthetic */ void a(k kVar) {
        AppMethodBeat.i(133952);
        kVar.ejo();
        AppMethodBeat.o(133952);
    }

    static /* synthetic */ void a(k kVar, MMHandler mMHandler, long j2, long j3) {
        AppMethodBeat.i(133953);
        kVar.a(mMHandler, j2, j3);
        AppMethodBeat.o(133953);
    }

    public k(MMHandler mMHandler, a aVar, Looper looper, Looper looper2, boolean z, int i2) {
        AppMethodBeat.i(208745);
        this.zrD = mMHandler;
        this.guh = false;
        this.zrC = new h(this.guh, i2);
        this.zrY = new MMHandler(aVar, this.zsf);
        this.zrY.setLogging(false);
        this.zsb = new l(this.zrC, this.zrD);
        this.zrW = new MMHandler(looper, this.zsg);
        if (looper2 != null) {
            this.zsd = new a(this.zrC, this.zrD);
            this.zrX = new MMHandler(looper2, this.zsh);
            this.zrX.setLogging(false);
        }
        AppMethodBeat.o(208745);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void setPath(String str) {
        AppMethodBeat.i(133936);
        Log.i("MicroMsg.VideoPlayerImpl", "%s set path %s", info(), str);
        this.zsb.setPath(str);
        if (this.zsd != null) {
            this.zsd.setPath(str);
        }
        AppMethodBeat.o(133936);
    }

    public final void ejn() {
        AppMethodBeat.i(133937);
        Log.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", info(), Long.valueOf(this.zrC.zrt));
        if (this.zsb != null) {
            this.zsb.aa(this.zrC.zrt, -1);
            this.zsb.ejj();
            this.zsb.zrG = 0;
        }
        AppMethodBeat.o(133937);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void setSurface(Surface surface) {
        AppMethodBeat.i(133938);
        Log.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", info(), Integer.valueOf(surface.hashCode()));
        this.zsb.surface = surface;
        AppMethodBeat.o(133938);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final boolean prepare() {
        AppMethodBeat.i(133939);
        Log.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", info());
        this.zrW.obtainMessage(1).sendToTarget();
        if (this.zsd != null) {
            this.zrX.obtainMessage(1).sendToTarget();
        }
        AppMethodBeat.o(133939);
        return true;
    }

    public final void bLe() {
        AppMethodBeat.i(133940);
        if (this.zsb != null) {
            Log.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", info());
            this.zsb.setState(10);
            a(this.zrW, SystemClock.elapsedRealtime(), 0);
        }
        AppMethodBeat.o(133940);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void start() {
        AppMethodBeat.i(133941);
        setState(3);
        this.zrW.removeMessages(3);
        this.zrW.obtainMessage(3).sendToTarget();
        if (this.zsd != null) {
            this.zrX.removeMessages(3);
            this.zrX.obtainMessage(3).sendToTarget();
        }
        AppMethodBeat.o(133941);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void pause() {
        AppMethodBeat.i(133942);
        setState(4);
        this.zrW.removeMessages(4);
        this.zrW.obtainMessage(4).sendToTarget();
        if (this.zsd != null) {
            this.zrX.removeMessages(4);
            this.zrX.obtainMessage(4).sendToTarget();
        }
        AppMethodBeat.o(133942);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void seek(int i2) {
        AppMethodBeat.i(133943);
        Log.i("MicroMsg.VideoPlayerImpl", "%s seek to mSeekSec %d", info(), Integer.valueOf(i2));
        Log.printDebugStack("MicroMsg.VideoPlayerImpl", "seek stack", new Object[0]);
        if (this.state < 2) {
            Log.w("MicroMsg.VideoPlayerImpl", "%s player is not ready[%d], how to seek[%d]?", info(), Integer.valueOf(this.state), Integer.valueOf(i2));
            AppMethodBeat.o(133943);
            return;
        }
        this.zsb.pause();
        if (this.zsd != null) {
            this.zsd.pause();
        }
        setState(5);
        if (((long) i2) >= this.durationMs) {
            this.zrY.obtainMessage(9).sendToTarget();
            AppMethodBeat.o(133943);
            return;
        }
        this.zsb.ejj();
        this.zrC.zrs = this.zsb.QB(i2);
        this.zsb.setState(5);
        QD(5);
        ejo();
        AppMethodBeat.o(133943);
    }

    public final void QC(int i2) {
        AppMethodBeat.i(133944);
        Log.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", info(), Integer.valueOf(i2), Boolean.TRUE);
        Log.printDebugStack("MicroMsg.VideoPlayerImpl", "seek stack", new Object[0]);
        if (this.state < 2) {
            Log.w("MicroMsg.VideoPlayerImpl", "%s player is not ready[%d], how to seek[%d]?", info(), Integer.valueOf(this.state), Integer.valueOf(i2));
            AppMethodBeat.o(133944);
            return;
        }
        this.zsb.pause();
        this.zrW.removeMessages(4);
        if (this.zsd != null) {
            this.zsd.pause();
            this.zrX.removeMessages(4);
        }
        if (((long) i2) >= this.durationMs) {
            Log.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", Integer.valueOf(i2), Long.valueOf(this.durationMs));
            setState(6);
            this.zrY.obtainMessage(9).sendToTarget();
            AppMethodBeat.o(133944);
            return;
        }
        this.zrW.obtainMessage(8).sendToTarget();
        this.zrW.obtainMessage(5, new int[]{i2, 1}).sendToTarget();
        AppMethodBeat.o(133944);
    }

    private void ejo() {
        AppMethodBeat.i(133945);
        Log.i("MicroMsg.VideoPlayerImpl", "%s seek done", info());
        this.zsb.setState(5);
        if (this.zsd != null) {
            this.zsd.ejj();
            this.zrC.zru = this.zsd.QB((int) this.zrC.zrs);
            this.zsd.setState(5);
        }
        QD(7);
        setState(4);
        this.zrD.obtainMessage(3, 0, 0).sendToTarget();
        this.zrC.zrt = this.zrC.zrs * 1000;
        this.zrC.zrs = -1;
        AppMethodBeat.o(133945);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void stop() {
        AppMethodBeat.i(133946);
        setState(8);
        AppMethodBeat.o(133946);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void release() {
        AppMethodBeat.i(133947);
        setState(9);
        this.zrY.removeMessages(2);
        this.zrY.removeMessages(9);
        this.zrW.removeMessages(1);
        this.zrW.removeMessages(2);
        this.zrW.removeMessages(3);
        this.zrW.removeMessages(4);
        this.zrW.removeMessages(6);
        this.zrW.removeCallbacksAndMessages(null);
        if (((b) g.af(b.class)).a(b.a.clicfg_video_player_release_direct_releasedecoder, 1) == 1) {
            try {
                this.zsb.setState(9);
                l lVar = this.zsb;
                Log.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", lVar.info(), Boolean.valueOf(lVar.zsm));
                if (lVar.zsm && d.oF(19)) {
                    this.zsb.releaseDecoder();
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VideoPlayerImpl", e2, "%s release error %s", info(), e2.toString());
            }
        }
        this.zrW.removeMessages(7);
        this.zrW.obtainMessage(7).sendToTarget();
        if (this.zrX != null) {
            this.zrX.removeMessages(1);
            this.zrX.removeMessages(2);
            this.zrX.removeMessages(3);
            this.zrX.removeMessages(4);
            this.zrX.removeMessages(6);
            this.zrX.removeMessages(7);
            this.zrX.obtainMessage(7).sendToTarget();
        }
        h hVar = this.zrC;
        hVar.eiq = 0;
        hVar.zrr = 0;
        hVar.zrs = -1;
        hVar.bdG = 0;
        hVar.zrt = 0;
        hVar.zru = 0;
        AppMethodBeat.o(133947);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final long getDurationMs() {
        return this.durationMs;
    }

    /* access modifiers changed from: protected */
    public final void setState(int i2) {
        AppMethodBeat.i(133948);
        Log.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d", info(), Integer.valueOf(this.state), Integer.valueOf(i2));
        this.state = i2;
        this.zrC.zrv = 0;
        AppMethodBeat.o(133948);
    }

    /* access modifiers changed from: package-private */
    public final void QD(int i2) {
        AppMethodBeat.i(133949);
        Log.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", info(), Integer.valueOf(i2), Long.valueOf(this.zrC.eiq), Long.valueOf(this.zrC.zrr), Long.valueOf(this.zrC.bdG));
        switch (i2) {
            case 3:
                if (this.zrC.zrr > 0) {
                    this.zrC.bdG += this.zrC.zrr - this.zrC.eiq;
                    this.zrC.zrr = 0;
                }
                this.zrC.eiq = SystemClock.elapsedRealtime();
                break;
            case 4:
                if (this.zrC.eiq > 0) {
                    this.zrC.zrr = SystemClock.elapsedRealtime();
                    break;
                } else {
                    this.zrC.zrr = 0;
                    break;
                }
            case 5:
                this.zrC.bdG = this.zrC.zrs;
                this.zrC.eiq = SystemClock.elapsedRealtime();
                this.zrC.zrr = 0;
                h hVar = this.zrC;
                this.zrC.zru = 0;
                hVar.zrt = 0;
                break;
            case 6:
                this.zrC.bdG = this.zrC.zrs;
                h hVar2 = this.zrC;
                this.zrC.zrr = 0;
                hVar2.eiq = 0;
                h hVar3 = this.zrC;
                this.zrC.zru = 0;
                hVar3.zrt = 0;
                break;
            case 7:
                this.zrC.bdG = this.zrC.zrs;
                h hVar4 = this.zrC;
                this.zrC.zrr = 0;
                hVar4.eiq = 0;
                break;
        }
        this.zrZ = this.zrC.eiq;
        this.bdG = this.zrC.bdG;
        Log.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", info(), Integer.valueOf(i2), Long.valueOf(this.zrZ), Long.valueOf(this.bdG));
        AppMethodBeat.o(133949);
    }

    public final String info() {
        AppMethodBeat.i(133950);
        String str = this.zrC.info() + "_" + Process.myTid();
        AppMethodBeat.o(133950);
        return str;
    }

    private void a(MMHandler mMHandler, long j2, long j3) {
        AppMethodBeat.i(133951);
        if (e.Qx(this.state)) {
            Log.w("MicroMsg.VideoPlayerImpl", "isEnd state=%s", Integer.valueOf(this.state));
            AppMethodBeat.o(133951);
        } else if (mMHandler.isQuit()) {
            Log.w("MicroMsg.VideoPlayerImpl", "handler has quit");
            AppMethodBeat.o(133951);
        } else {
            mMHandler.removeMessages(2);
            long elapsedRealtime = (j2 + j3) - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                mMHandler.sendEmptyMessage(2);
                AppMethodBeat.o(133951);
                return;
            }
            mMHandler.sendEmptyMessageDelayed(2, elapsedRealtime);
            AppMethodBeat.o(133951);
        }
    }
}
