package com.tencent.mm.plugin.music.f;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ay.c;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.g.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.net.URL;

public final class e extends a {
    CommonPlayer AhJ;
    boolean AhL;
    private b AhO;
    private long AhP = 0;
    private boolean AhQ = false;
    private PlayerListenerCallback AhS = new PlayerListenerCallback() {
        /* class com.tencent.mm.plugin.music.f.e.AnonymousClass1 */
        f Amb = null;

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i2) {
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
            AppMethodBeat.i(137353);
            Log.i("MicroMsg.Music.QQMusicPlayer", "onCompletion");
            AppMethodBeat.o(137353);
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i2) {
            AppMethodBeat.i(137354);
            Log.i("MicroMsg.Music.QQMusicPlayer", "onSeekComplete seekPosition:%d", Integer.valueOf(i2));
            if (e.this.dvv != 0) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", Integer.valueOf(e.this.dvv));
                e.this.dvv = 0;
                AppMethodBeat.o(137354);
                return;
            }
            Log.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
            if (this.Amb == null) {
                Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                AppMethodBeat.o(137354);
                return;
            }
            e.this.M(this.Amb);
            if (e.this.bec()) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
                e.this.J(this.Amb);
            }
            AppMethodBeat.o(137354);
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public final void onError(BaseMediaPlayer baseMediaPlayer, int i2, int i3, int i4) {
            AppMethodBeat.i(137355);
            Log.e("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            f etU = k.euj().etU();
            if (etU == null) {
                Log.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
                AppMethodBeat.o(137355);
                return;
            }
            this.Amb = e.this.Ajg;
            if (this.Amb == null) {
                Log.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
                AppMethodBeat.o(137355);
                return;
            }
            boolean isNetworkConnected = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
            if (i3 == 80 && isNetworkConnected) {
                Log.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
            }
            if (e.this.bFM > 0) {
                Log.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", Integer.valueOf(e.this.bFM));
                AppMethodBeat.o(137355);
                return;
            }
            e.this.bFM++;
            e.a(e.this);
            e.a(e.this, this.Amb, i3);
            if (etU.f(this.Amb)) {
                e.this.stopPlay();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.music.f.e.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(137352);
                        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f8c), 0).show();
                        AppMethodBeat.o(137352);
                    }
                });
            }
            e.this.L(this.Amb);
            e.this.d(this.Amb, i3);
            if (e.this.AlZ != null) {
                e.this.AlZ.isStop = true;
                e.this.AlZ = null;
            }
            if (i2 == 91 && i3 == 55) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
                g.aHD(e.this.dus);
            }
            AppMethodBeat.o(137355);
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
            AppMethodBeat.i(137356);
            Log.i("MicroMsg.Music.QQMusicPlayer", "onPrepared");
            AppMethodBeat.o(137356);
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public final void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i2) {
            AppMethodBeat.i(137357);
            Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", Integer.valueOf(i2));
            if (i2 == 3) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
                Log.i("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
                this.Amb = e.this.Ajg;
                if (this.Amb == null) {
                    Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.o(137357);
                    return;
                }
                e.this.G(this.Amb);
                AppMethodBeat.o(137357);
            } else if (i2 == 2) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
                Log.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
                if (e.this.dvv != 0) {
                    Log.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", Integer.valueOf(e.this.dvv));
                    e.this.tG(e.this.dvv);
                }
                Log.i("MicroMsg.Music.QQMusicPlayer", "start to play");
                if (!k.eul().requestFocus()) {
                    Log.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
                    AppMethodBeat.o(137357);
                } else if (e.this.Ajg == null) {
                    Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.o(137357);
                } else {
                    e.this.H(e.this.Ajg);
                    try {
                        if (e.this.AhJ != null) {
                            e.this.AhJ.start();
                            if (!(e.this.AhJ.getCurrentAudioInformation() == null || e.this.AhJ.getCurrentAudioInformation().getAudioType() == null)) {
                                Log.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", Integer.valueOf(e.this.AhJ.getCurrentAudioInformation().getAudioType().getValue()));
                                e.this.audioType = e.this.AhJ.getCurrentAudioInformation().getAudioType();
                                e.b(e.this);
                            }
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e2, "_onPrepared", new Object[0]);
                        e.this.d(e.this.Ajg, 502);
                        e.a(e.this, e.this.Ajg, 502);
                    }
                    e.this.AhL = true;
                    AppMethodBeat.o(137357);
                }
            } else if (i2 == 4) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
                Log.i("MicroMsg.Music.QQMusicPlayer", "_onStart");
                this.Amb = e.this.Ajg;
                if (this.Amb == null) {
                    Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.o(137357);
                    return;
                }
                e.this.iJF = SystemClock.elapsedRealtime();
                if (e.this.AlI == "pause") {
                    e.this.J(this.Amb);
                } else {
                    e.this.I(this.Amb);
                }
                if (e.this.AlZ != null) {
                    e.this.AlZ.isStop = true;
                }
                e.this.AlZ = new a(e.this, (byte) 0);
                a aVar = e.this.AlZ;
                aVar.isStop = false;
                ThreadPool.post(aVar, "music_play_progress_runnable");
                AppMethodBeat.o(137357);
            } else if (i2 == 5) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
                Log.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
                if (this.Amb == null) {
                    Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.o(137357);
                    return;
                }
                e.this.AlL += SystemClock.elapsedRealtime() - e.this.iJF;
                e.this.K(this.Amb);
                AppMethodBeat.o(137357);
            } else if (i2 == 6) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
                Log.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
                if (this.Amb == null) {
                    Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.o(137357);
                    return;
                }
                f etU = k.euj().etU();
                if (etU == null) {
                    Log.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
                    AppMethodBeat.o(137357);
                } else if (etU.f(this.Amb)) {
                    e.this.L(this.Amb);
                    AppMethodBeat.o(137357);
                } else {
                    f fVar = this.Amb;
                    Log.i("MicroMsg.Music.BaseMusicPlayer", "onStopForReportEvent");
                    mx mxVar = new mx();
                    mxVar.dSE.action = 18;
                    mxVar.dSE.dSy = fVar;
                    EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
                    AppMethodBeat.o(137357);
                }
            } else if (i2 == 7) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
                Log.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
                if (this.Amb == null) {
                    Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.o(137357);
                    return;
                }
                e.a(e.this);
                e.this.AhL = false;
                e.this.O(e.this.Ajg);
                if (e.this.AlZ != null) {
                    e.this.AlZ.isStop = true;
                    e.this.AlZ = null;
                }
                AppMethodBeat.o(137357);
            } else if (i2 == 8) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
                Log.i("MicroMsg.Music.QQMusicPlayer", "_onEnd");
                AppMethodBeat.o(137357);
            } else {
                if (i2 == 9) {
                    Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
                }
                AppMethodBeat.o(137357);
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
        public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
            AppMethodBeat.i(137358);
            Log.i("MicroMsg.Music.QQMusicPlayer", "onStarted");
            AppMethodBeat.o(137358);
        }
    };
    f Ajg;
    private c Ajh;
    public boolean Aju = false;
    a AlZ;
    private String Ama;
    AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
    int bFM = 0;
    String dus = "";
    int dvv = 0;

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(137380);
        eVar.euU();
        AppMethodBeat.o(137380);
    }

    static /* synthetic */ void a(e eVar, f fVar, int i2) {
        AppMethodBeat.i(137381);
        eVar.e(fVar, i2);
        AppMethodBeat.o(137381);
    }

    public e() {
        AppMethodBeat.i(137361);
        com.tencent.mm.plugin.music.f.a.a.euV();
        AppMethodBeat.o(137361);
    }

    @Override // com.tencent.mm.plugin.music.f.a
    public final void h(f fVar) {
        AppMethodBeat.i(137362);
        super.h(fVar);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.AhP;
        if (this.Ajg != null && this.Ajg.f(fVar) && j2 <= 20) {
            this.Ajg = fVar;
            Log.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", this.dus, Long.valueOf(j2));
            AppMethodBeat.o(137362);
        } else if (fVar == null) {
            Log.e("MicroMsg.Music.QQMusicPlayer", "music is null");
            AppMethodBeat.o(137362);
        } else {
            this.bmy = 0;
            this.iJF = SystemClock.elapsedRealtime();
            this.AlL = 0;
            this.duration = 0;
            if (this.AlJ != null) {
                this.AlJ.v(fVar);
            }
            this.AhP = currentTimeMillis;
            this.Ajg = fVar;
            Log.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", Long.valueOf(currentTimeMillis), Integer.valueOf(fVar.dvv));
            if (this.AhJ != null && bec()) {
                this.AhJ.stop();
            }
            com.tencent.mm.plugin.music.f.a.a.euW();
            this.bFM = 0;
            this.dvv = fVar.dvv;
            this.audioType = null;
            this.AhQ = false;
            Log.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
            this.dus = this.Ajg.playUrl;
            this.Ama = this.Ajg.jfh;
            Log.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", this.dus, this.Ama);
            Log.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", this.Ajg.jfb);
            if (!Util.isNullOrNil(this.dus) && Util.isNullOrNil(this.Ama)) {
                g.aHx(this.dus);
                g.eT(this.dus, 0);
                g.eU(this.dus, 0);
            }
            if (!Util.isNullOrNil(this.Ama)) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", this.Ama);
                if (this.AhJ == null) {
                    this.AhJ = new CommonPlayer(this.AhS);
                }
                this.AhJ.reset();
                if (this.Ama.startsWith("file://")) {
                    this.Ama = this.Ama.substring(7);
                }
                try {
                    this.AhJ.setDataSource(this.Ama);
                    this.AhJ.prepare();
                } catch (Exception e2) {
                    Log.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + e2.getMessage());
                    Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e2, "initPlayer", new Object[0]);
                    d(this.Ajg, 501);
                    e(this.Ajg, 501);
                }
            } else {
                URL url = null;
                try {
                    url = new URL(this.dus);
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e3, "initPlayer", new Object[0]);
                    Log.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + e3.getMessage());
                }
                if (url == null) {
                    Log.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
                    d(this.Ajg, 500);
                    e(this.Ajg, 500);
                    euP();
                    AppMethodBeat.o(137362);
                }
                if (this.AhJ == null) {
                    this.AhJ = new CommonPlayer(this.AhS);
                }
                this.AhJ.reset();
                if (this.AhO == null) {
                    this.AhO = new b();
                }
                String str = this.Ajg == null ? "invalidReferrer" : this.Ajg.iJQ;
                Log.i("MicroMsg.Music.QQMusicPlayer", "initPlayer, referrer: ".concat(String.valueOf(str)));
                this.AhO.jb(this.dus, str);
                try {
                    this.AhJ.setDataSource(this.AhO, Uri.parse(url.toString()));
                    this.AhJ.prepare();
                } catch (Exception e4) {
                    Log.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + e4.getMessage());
                    Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e4, "initPlayer", new Object[0]);
                    d(this.Ajg, 501);
                    e(this.Ajg, 501);
                }
            }
            bE((float) this.Ajg.iJH);
            setVolume(this.Ajg.volume);
            euP();
            AppMethodBeat.o(137362);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.music.f.a
    public final void etM() {
        AppMethodBeat.i(137363);
        this.AlJ = (d) com.tencent.mm.plugin.music.f.c.b.aS(d.class);
        this.AlK = k.euj().AjC;
        AppMethodBeat.o(137363);
    }

    private void bE(float f2) {
        AppMethodBeat.i(198180);
        if (this.AhJ == null) {
            AppMethodBeat.o(198180);
        } else if (f2 < 0.5f || f2 > 2.0f) {
            this.AhJ.setSpeed(1.0f);
            AppMethodBeat.o(198180);
        } else {
            Log.i("MicroMsg.Music.QQMusicPlayer", "set speed :%f", Float.valueOf(f2));
            this.AhJ.setSpeed(f2);
            AppMethodBeat.o(198180);
        }
    }

    private void setVolume(float f2) {
        AppMethodBeat.i(198181);
        if (this.AhJ != null && f2 >= 0.0f) {
            this.AhJ.setVolume(f2, f2);
        }
        AppMethodBeat.o(198181);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void pause() {
        AppMethodBeat.i(137364);
        this.Aju = false;
        Log.i("MicroMsg.Music.QQMusicPlayer", "pause");
        if (this.AhJ != null && bec()) {
            try {
                this.AhJ.pause();
                AppMethodBeat.o(137364);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e2, "pause", new Object[0]);
                d(this.Ajg, 503);
                e(this.Ajg, 503);
            }
        }
        AppMethodBeat.o(137364);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void eth() {
        AppMethodBeat.i(137365);
        Log.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
        pause();
        k.eul().bLZ();
        AppMethodBeat.o(137365);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean bed() {
        return this.AhL && this.Aju;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void esU() {
        AppMethodBeat.i(137366);
        this.Aju = true;
        Log.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
        if (this.AhJ != null && bec()) {
            try {
                this.AhJ.pause();
                AppMethodBeat.o(137366);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e2, "passivePause", new Object[0]);
                d(this.Ajg, 503);
                e(this.Ajg, 503);
            }
        }
        AppMethodBeat.o(137366);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void resume() {
        AppMethodBeat.i(137367);
        this.bFM = 0;
        boolean dFr = dFr();
        boolean bec = bec();
        Log.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, paused:%b, isPrepared:%b", Boolean.valueOf(dFr), Boolean.valueOf(bec), Boolean.valueOf(isPaused()), Boolean.valueOf(asa()));
        if (this.AhJ != null && ((isPaused() || asa()) && !bec)) {
            if (k.eul().requestFocus()) {
                try {
                    this.AhJ.start();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e2, "resume", new Object[0]);
                    d(this.Ajg, 502);
                    e(this.Ajg, 502);
                }
            } else {
                Log.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
            }
            this.AhL = true;
        }
        AppMethodBeat.o(137367);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean bec() {
        AppMethodBeat.i(137368);
        if (this.AhJ == null) {
            AppMethodBeat.o(137368);
            return false;
        } else if (this.AhJ.getPlayerState() == 4) {
            AppMethodBeat.o(137368);
            return true;
        } else {
            AppMethodBeat.o(137368);
            return false;
        }
    }

    private boolean dFr() {
        AppMethodBeat.i(137369);
        if (this.AhJ == null) {
            AppMethodBeat.o(137369);
            return false;
        } else if (this.AhJ.getPlayerState() == 3) {
            AppMethodBeat.o(137369);
            return true;
        } else {
            AppMethodBeat.o(137369);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean bee() {
        AppMethodBeat.i(137370);
        if (!this.AhL || dFr()) {
            AppMethodBeat.o(137370);
            return false;
        }
        AppMethodBeat.o(137370);
        return true;
    }

    private boolean asa() {
        AppMethodBeat.i(198182);
        if (this.AhJ == null) {
            AppMethodBeat.o(198182);
            return false;
        } else if (this.AhJ.getPlayerState() == 2) {
            AppMethodBeat.o(198182);
            return true;
        } else {
            AppMethodBeat.o(198182);
            return false;
        }
    }

    private boolean isPaused() {
        AppMethodBeat.i(198183);
        if (this.AhJ == null) {
            AppMethodBeat.o(198183);
            return false;
        } else if (this.AhJ.getPlayerState() == 5) {
            AppMethodBeat.o(198183);
            return true;
        } else {
            AppMethodBeat.o(198183);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void stopPlay() {
        AppMethodBeat.i(137371);
        Log.i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
        try {
            euU();
            if (this.AhJ != null) {
                this.AhJ.stop();
            }
            if (this.AlZ != null) {
                this.AlZ.isStop = true;
                this.AlZ = null;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e2, "stopPlay", new Object[0]);
            d(this.Ajg, 504);
            e(this.Ajg, 504);
        }
        k.eul().bLZ();
        this.AhL = false;
        this.Aju = false;
        AppMethodBeat.o(137371);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final int etn() {
        AppMethodBeat.i(137372);
        if (this.AhJ != null) {
            int currentPosition = (int) this.AhJ.getCurrentPosition();
            AppMethodBeat.o(137372);
            return currentPosition;
        }
        AppMethodBeat.o(137372);
        return -1;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final int getDuration() {
        AppMethodBeat.i(137373);
        if (this.AhJ != null) {
            int duration = this.AhJ.getDuration();
            AppMethodBeat.o(137373);
            return duration;
        }
        AppMethodBeat.o(137373);
        return -1;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean tG(int i2) {
        AppMethodBeat.i(137374);
        int duration = getDuration();
        Log.i("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i2), Integer.valueOf(duration));
        if (duration < 0 || i2 > duration) {
            Log.e("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i2), Integer.valueOf(duration));
            stopPlay();
            AppMethodBeat.o(137374);
            return false;
        }
        if (this.AhJ != null) {
            N(this.Ajg);
            this.AhJ.seekTo(i2);
        }
        AppMethodBeat.o(137374);
        return true;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final c esW() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(137375);
        int duration = getDuration();
        int etn = etn();
        boolean bec = bec();
        if (this.AhJ != null) {
            i2 = this.AhJ.getBufferedPercentage();
        } else {
            i2 = 0;
        }
        if (i2 < 0 || i2 > 100) {
            i2 = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (this.Ajh != null) {
            c cVar = this.Ajh;
            if (bec) {
                i3 = 1;
            }
            cVar.t(duration, etn, i3, i2);
        } else {
            if (bec) {
                i3 = 1;
            }
            this.Ajh = new c(duration, etn, i3, i2);
        }
        this.Ajh.dSG = true;
        this.Ajh.jeQ = euQ();
        c cVar2 = this.Ajh;
        AppMethodBeat.o(137375);
        return cVar2;
    }

    public final void release() {
        AppMethodBeat.i(137376);
        Log.i("MicroMsg.Music.QQMusicPlayer", "release");
        if (this.AhJ != null) {
            this.AhJ.release();
            this.AhJ = null;
        }
        esT();
        AppMethodBeat.o(137376);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        boolean isStop;

        private a() {
            this.isStop = true;
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(137360);
            Log.i("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (e.this.AhJ != null && e.this.bec()) {
                        e.this.etp();
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.Music.QQMusicPlayer", "PlayProgressTask run exception:" + e2.getMessage());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e3) {
                }
            }
            AppMethodBeat.o(137360);
        }
    }

    public final void etp() {
        AppMethodBeat.i(137377);
        f etU = k.euj().etU();
        if (etU == null) {
            AppMethodBeat.o(137377);
            return;
        }
        if (etU.f(this.Ajg) && this.AhJ != null && bec()) {
            int currentPosition = (int) this.AhJ.getCurrentPosition();
            int duration = this.AhJ.getDuration();
            if (currentPosition > 0 && duration > 0) {
                fn(currentPosition, duration);
            }
        }
        AppMethodBeat.o(137377);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean esV() {
        return true;
    }

    private void e(f fVar, int i2) {
        AppMethodBeat.i(137378);
        if (this.AlJ != null) {
            this.AlJ.b(fVar, i2);
        }
        AppMethodBeat.o(137378);
    }

    private void euU() {
        AppMethodBeat.i(137379);
        if (this.AhJ != null) {
            this.bmy = (long) etn();
            this.AlL += SystemClock.elapsedRealtime() - this.iJF;
            this.duration = (long) getDuration();
            if (this.AlJ != null) {
                this.AlJ.a(this.Ajg, this.bmy, this.AlL, this.duration);
            }
        }
        AppMethodBeat.o(137379);
    }

    @Override // com.tencent.mm.plugin.music.f.a
    public final void m(f fVar) {
        AppMethodBeat.i(198184);
        if (this.Ajg != null && this.Ajg.f(fVar)) {
            Log.i("MicroMsg.Music.QQMusicPlayer", "updateCurrentMusicWrapper src:%s", this.dus);
            if (fVar.iJH > 0.0d && fVar.iJH != this.Ajg.iJH) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "setPlaybackRate playbackRate:%f", Double.valueOf(fVar.iJH));
                bE((float) fVar.iJH);
                this.Ajg.iJH = fVar.iJH;
            }
            if (fVar.volume >= 0.0f && fVar.volume != this.Ajg.volume) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "setVolume volume:%f", Float.valueOf(fVar.volume));
                setVolume(fVar.volume);
                this.Ajg.volume = fVar.volume;
            }
        }
        AppMethodBeat.o(198184);
    }

    static /* synthetic */ void b(e eVar) {
        AppMethodBeat.i(137382);
        if (eVar.audioType != null) {
            Log.i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType audioType:%d, isStatMineType:%b", Integer.valueOf(eVar.audioType.getValue()), Boolean.valueOf(eVar.AhQ));
            if (!eVar.AhQ) {
                Log.i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType OK");
                eVar.AhQ = true;
                if (eVar.AlJ != null) {
                    eVar.AlJ.c(eVar.Ajg, eVar.audioType.getValue());
                }
            }
        }
        AppMethodBeat.o(137382);
    }
}
