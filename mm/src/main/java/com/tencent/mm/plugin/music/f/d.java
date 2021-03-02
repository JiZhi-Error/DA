package com.tencent.mm.plugin.music.f;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ay.c;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.c.b;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class d extends a {
    boolean AhL;
    f Ajg;
    public boolean Aju = false;
    b AlR;
    boolean AlS;
    private c AlT;
    b.AbstractC1532b AlU = new b.AbstractC1532b() {
        /* class com.tencent.mm.plugin.music.f.d.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.music.c.b.AbstractC1532b
        public final void SK(final int i2) {
            AppMethodBeat.i(137334);
            if (i2 == 1) {
                if (!(d.this.Alw == null || d.this.AhL || d.this.AlR == null)) {
                    d.this.AlR.aHY(com.tencent.mm.plugin.music.h.b.bT(d.this.Alw.AiZ.jeV, d.this.Alw.tcf));
                    d dVar = d.this;
                    if (k.eul().requestFocus()) {
                        Log.i("MicroMsg.Music.MusicPlayer", "startPlay");
                        try {
                            if (dVar.AlR != null) {
                                dVar.AlR.play();
                            }
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", e2, "startPlay", new Object[0]);
                        }
                        dVar.AhL = true;
                        dVar.AlS = false;
                        AppMethodBeat.o(137334);
                        return;
                    }
                    Log.e("MicroMsg.Music.MusicPlayer", "request focus error");
                    AppMethodBeat.o(137334);
                    return;
                }
            } else if (i2 == -2 || i2 == 5 || i2 == 19) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.music.f.d.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(137332);
                        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f_5), 0).show();
                        d.a(d.this, d.this.Ajg, i2);
                        AppMethodBeat.o(137332);
                    }
                });
                AppMethodBeat.o(137334);
                return;
            } else if (i2 == -1 || i2 == 6 || i2 == 4) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.music.f.d.AnonymousClass2.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(137333);
                        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f_5), 1).show();
                        AppMethodBeat.o(137333);
                    }
                });
                d.a(d.this, d.this.Ajg, i2);
            }
            AppMethodBeat.o(137334);
        }
    };
    com.tencent.mm.plugin.music.c.b Alw;

    public d() {
        AppMethodBeat.i(137335);
        AppMethodBeat.o(137335);
    }

    @Override // com.tencent.mm.plugin.music.f.a
    public final void h(f fVar) {
        AppMethodBeat.i(137336);
        super.h(fVar);
        Log.i("MicroMsg.Music.MusicPlayer", "init and start download");
        stopPlay();
        if (fVar == null) {
            Log.i("MicroMsg.Music.MusicPlayer", "music is null");
            AppMethodBeat.o(137336);
            return;
        }
        this.Alw = new com.tencent.mm.plugin.music.c.b(fVar, e.aHw(fVar.jeV));
        this.Alw.Aje = this.AlU;
        if (this.AlJ != null) {
            this.AlJ.v(fVar);
            Log.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
            this.AlJ.etX();
            this.AlJ.a(this.Alw);
        }
        this.Ajg = fVar;
        b(fVar, false);
        Log.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", fVar.jfb, fVar.playUrl);
        this.Alw.start();
        euP();
        AppMethodBeat.o(137336);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.music.f.a
    public final void etM() {
        AppMethodBeat.i(137337);
        this.AlJ = (com.tencent.mm.plugin.music.e.d) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.d.class);
        this.AlK = k.euj().AjC;
        AppMethodBeat.o(137337);
    }

    /* access modifiers changed from: package-private */
    public final void b(f fVar, boolean z) {
        AppMethodBeat.i(137338);
        if (this.AlR == null) {
            if (z || !com.tencent.mm.compatible.util.d.oF(15)) {
                Log.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
                this.AlR = new b();
            } else {
                Log.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
                this.AlR = new c();
            }
            this.AlR.R(fVar);
            this.AlR.a(new com.tencent.mm.plugin.music.f.a.f() {
                /* class com.tencent.mm.plugin.music.f.d.AnonymousClass1 */
                long AlV;

                @Override // com.tencent.mm.plugin.music.f.a.f
                public final void n(f fVar) {
                    AppMethodBeat.i(137328);
                    Log.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
                    d.this.I(fVar);
                    AppMethodBeat.o(137328);
                }

                /* JADX WARNING: Removed duplicated region for block: B:41:0x00e2  */
                @Override // com.tencent.mm.plugin.music.f.a.f
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void Q(com.tencent.mm.ay.f r12) {
                    /*
                    // Method dump skipped, instructions count: 311
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.f.d.AnonymousClass1.Q(com.tencent.mm.ay.f):void");
                }

                @Override // com.tencent.mm.plugin.music.f.a.f
                public final void c(f fVar, boolean z) {
                    AppMethodBeat.i(137330);
                    Log.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
                    f etU = k.euj().etU();
                    if (etU == null) {
                        AppMethodBeat.o(137330);
                        return;
                    }
                    if (etU.f(fVar)) {
                        d.this.stopPlay();
                    }
                    d.this.L(d.this.Ajg);
                    if (z) {
                        d.this.O(d.this.Ajg);
                    }
                    AppMethodBeat.o(137330);
                }

                @Override // com.tencent.mm.plugin.music.f.a.f
                public final void d(f fVar, boolean z) {
                    AppMethodBeat.i(137331);
                    f etU = k.euj().etU();
                    if (etU == null) {
                        AppMethodBeat.o(137331);
                        return;
                    }
                    Log.i("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", Boolean.valueOf(z));
                    if (z) {
                        d.a(d.this, fVar, 20);
                    } else {
                        d.a(d.this, fVar, 21);
                    }
                    if (etU.f(fVar)) {
                        Log.i("MicroMsg.Music.MusicPlayer", "stop");
                        d.this.stopPlay();
                        if (z) {
                            Log.i("MicroMsg.Music.MusicPlayer", "retry system media player again");
                            d.this.b(etU, true);
                            d.this.Alw = new com.tencent.mm.plugin.music.c.b(fVar, e.aHw(fVar.jeV));
                            d.this.Alw.Aje = d.this.AlU;
                            d.this.Alw.start();
                            if (d.this.AlJ != null) {
                                d.this.AlJ.a(d.this.Alw);
                                AppMethodBeat.o(137331);
                                return;
                            }
                        } else {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.music.f.d.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(137327);
                                    if (System.currentTimeMillis() - AnonymousClass1.this.AlV > 10000) {
                                        AnonymousClass1.this.AlV = System.currentTimeMillis();
                                        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f8c), 0).show();
                                    }
                                    AppMethodBeat.o(137327);
                                }
                            });
                            d.this.L(d.this.Ajg);
                            AppMethodBeat.o(137331);
                            return;
                        }
                    } else {
                        Log.i("MicroMsg.Music.MusicPlayer", "send stop event");
                        d.this.L(d.this.Ajg);
                    }
                    AppMethodBeat.o(137331);
                }
            });
        }
        AppMethodBeat.o(137338);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void pause() {
        AppMethodBeat.i(137339);
        this.Aju = false;
        Log.i("MicroMsg.Music.MusicPlayer", "pause");
        try {
            if (this.AlR != null && this.AlR.isPlaying()) {
                this.AlR.pause();
                this.AlS = true;
                K(this.Ajg);
            }
            AppMethodBeat.o(137339);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", e2, "pause", new Object[0]);
            AppMethodBeat.o(137339);
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void eth() {
        AppMethodBeat.i(137340);
        Log.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
        pause();
        k.eul().bLZ();
        AppMethodBeat.o(137340);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean bed() {
        return this.AhL && this.Aju;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void esU() {
        AppMethodBeat.i(137341);
        this.Aju = true;
        Log.i("MicroMsg.Music.MusicPlayer", "passivePause");
        try {
            if (this.AlR != null && this.AlR.isPlaying()) {
                this.AlR.pause();
                K(this.Ajg);
            }
            AppMethodBeat.o(137341);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", e2, "passivePause", new Object[0]);
            AppMethodBeat.o(137341);
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void resume() {
        AppMethodBeat.i(137342);
        try {
            if (this.AlR == null || this.AlR.isPlaying()) {
                Log.i("MicroMsg.Music.MusicPlayer", "music is playing");
                AppMethodBeat.o(137342);
                return;
            }
            Log.i("MicroMsg.Music.MusicPlayer", "resume");
            if (k.eul().requestFocus()) {
                this.AlR.play();
                J(this.Ajg);
                AppMethodBeat.o(137342);
                return;
            }
            Log.e("MicroMsg.Music.MusicPlayer", "request focus error");
            AppMethodBeat.o(137342);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", e2, "resume", new Object[0]);
            AppMethodBeat.o(137342);
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean bec() {
        boolean z = false;
        AppMethodBeat.i(137343);
        if (this.AlR != null) {
            try {
                z = this.AlR.isPlaying();
                AppMethodBeat.o(137343);
            } catch (Throwable th) {
                AppMethodBeat.o(137343);
            }
        } else {
            AppMethodBeat.o(137343);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean bee() {
        return this.AhL;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void stopPlay() {
        AppMethodBeat.i(137344);
        Log.i("MicroMsg.Music.MusicPlayer", "stopPlay");
        if (this.AlR != null && (this.AlR instanceof c)) {
            aHZ(this.AlR.ZV());
        }
        try {
            if (this.Alw != null) {
                this.Alw.isStop = true;
                this.Alw = null;
            }
            if (this.AlR != null) {
                this.AlR.stop();
                this.AlR = null;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", e2, "stopPlay", new Object[0]);
        }
        k.eul().bLZ();
        this.AhL = false;
        this.Aju = false;
        AppMethodBeat.o(137344);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final int etn() {
        AppMethodBeat.i(137345);
        if (this.AlR != null) {
            int euS = this.AlR.euS();
            AppMethodBeat.o(137345);
            return euS;
        }
        AppMethodBeat.o(137345);
        return -1;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final int getDuration() {
        AppMethodBeat.i(137346);
        if (this.AlR != null) {
            int duration = this.AlR.getDuration();
            AppMethodBeat.o(137346);
            return duration;
        }
        AppMethodBeat.o(137346);
        return -1;
    }

    private int getDownloadPercent() {
        int i2;
        AppMethodBeat.i(137347);
        if (this.Alw != null) {
            com.tencent.mm.plugin.music.c.b bVar = this.Alw;
            if (bVar.tcf) {
                Log.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", Long.valueOf(bVar.Aja.AiX), Long.valueOf(bVar.Aja.AiV));
                i2 = bVar.Aja.AiX != 0 ? (int) ((bVar.Aja.AiV * 100) / bVar.Aja.AiX) : 0;
            } else {
                Log.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", Long.valueOf(bVar.Aja.AiU), Long.valueOf(bVar.Aja.AiT));
                i2 = bVar.Aja.AiU != 0 ? (int) ((bVar.Aja.AiT * 100) / bVar.Aja.AiU) : 0;
            }
            if (i2 > 0) {
                AppMethodBeat.o(137347);
                return i2;
            }
            AppMethodBeat.o(137347);
            return 0;
        }
        AppMethodBeat.o(137347);
        return 0;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean tG(int i2) {
        AppMethodBeat.i(137348);
        Log.i("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", Integer.valueOf(i2));
        try {
            int duration = getDuration();
            int downloadPercent = getDownloadPercent();
            if (duration < 0 || i2 > duration) {
                Log.e("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
                stopPlay();
                AppMethodBeat.o(137348);
                return false;
            }
            int i3 = (int) ((((double) downloadPercent) / 100.0d) * ((double) duration));
            if (downloadPercent != 100 && i2 > i3) {
                i2 = i3 - 2000;
                Log.i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", Integer.valueOf(i2));
            }
            if (this.AlR != null && i2 >= 0) {
                this.AlR.seek((long) i2);
                M(this.Ajg);
                AppMethodBeat.o(137348);
                return true;
            }
            AppMethodBeat.o(137348);
            return false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", e2, "seekTo", new Object[0]);
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final c esW() {
        boolean z;
        int i2;
        AppMethodBeat.i(137349);
        int duration = getDuration();
        int etn = etn();
        if (bec()) {
            i2 = 1;
        } else {
            if (!this.AhL || (!this.AlS && !this.AhH)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                i2 = 0;
            } else {
                i2 = 2;
            }
        }
        Log.i("MicroMsg.Music.MusicPlayer", "get music status = %d", Integer.valueOf(i2));
        int downloadPercent = getDownloadPercent();
        if (duration <= 0) {
            downloadPercent = 0;
        }
        if (this.AlT != null) {
            this.AlT.t(duration, etn, i2, downloadPercent);
        } else {
            this.AlT = new c(duration, etn, i2, downloadPercent);
        }
        this.AlT.dSG = false;
        this.AlT.jeQ = euQ();
        c cVar = this.AlT;
        AppMethodBeat.o(137349);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean esV() {
        return false;
    }

    private void aHZ(String str) {
        AppMethodBeat.i(137350);
        if (this.AlJ != null) {
            this.AlJ.a(this.Ajg, str);
        }
        AppMethodBeat.o(137350);
    }

    static /* synthetic */ void a(d dVar, f fVar, int i2) {
        int i3 = 0;
        AppMethodBeat.i(137351);
        if (fVar == null) {
            Log.e("MicroMsg.Music.MusicPlayer", "currentMusic is null, don't idKeyReportMusicError");
            AppMethodBeat.o(137351);
            return;
        }
        Log.i("MicroMsg.Music.MusicPlayer", "idKeyReportMusicError, action:%d", Integer.valueOf(i2));
        if (dVar.AlR != null && (dVar.AlR instanceof c)) {
            i3 = ((c) dVar.AlR).dvm;
        }
        if (dVar.AlJ != null) {
            dVar.AlJ.c(dVar.Ajg, i2, i3);
        }
        AppMethodBeat.o(137351);
    }
}
