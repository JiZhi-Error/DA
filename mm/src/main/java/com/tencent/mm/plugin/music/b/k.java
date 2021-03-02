package com.tencent.mm.plugin.music.b;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.d;
import com.tencent.mm.g.a.y;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.g.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.net.URL;

public final class k extends i {
    CommonPlayer AhJ;
    private d AhK;
    boolean AhL;
    boolean AhM;
    a AhN;
    private b AhO;
    private long AhP;
    boolean AhQ;
    long AhR;
    private PlayerListenerCallback AhS;
    com.tencent.mm.plugin.music.b.a.d Ahi;
    AudioFormat.AudioType audioType;
    boolean autoPlay;
    int bFM;
    protected com.tencent.mm.ai.b dCT;
    String dtX;
    String dus;
    int dvv;
    long hlh;
    boolean iJV;
    MMHandler ndA;
    int rxv;

    static /* synthetic */ void a(k kVar, int i2) {
        AppMethodBeat.i(198177);
        kVar.Su(i2);
        AppMethodBeat.o(198177);
    }

    static /* synthetic */ void b(k kVar) {
        AppMethodBeat.i(137143);
        kVar.dlb();
        AppMethodBeat.o(137143);
    }

    public k() {
        AppMethodBeat.i(137114);
        this.dtX = "";
        this.AhM = false;
        this.iJV = false;
        this.dus = "";
        this.bFM = 0;
        this.rxv = 0;
        this.dvv = 0;
        this.autoPlay = false;
        this.AhP = 0;
        this.audioType = AudioFormat.AudioType.UNSUPPORT;
        this.AhQ = false;
        this.AhR = 0;
        this.hlh = 0;
        this.AhS = new PlayerListenerCallback() {
            /* class com.tencent.mm.plugin.music.b.k.AnonymousClass1 */
            com.tencent.mm.ai.b AhT = null;

            @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
            public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i2) {
            }

            @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
            public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
                AppMethodBeat.i(137100);
                Log.i("MicroMsg.Audio.QQAudioPlayer", "onCompletion");
                AppMethodBeat.o(137100);
            }

            @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
            public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer, final int i2) {
                AppMethodBeat.i(137101);
                k.this.ndA.post(new Runnable() {
                    /* class com.tencent.mm.plugin.music.b.k.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(137097);
                        Log.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", Integer.valueOf(i2));
                        if (k.this.dvv != 0) {
                            Log.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", Integer.valueOf(k.this.dvv));
                            k.this.dvv = 0;
                            AppMethodBeat.o(137097);
                            return;
                        }
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        Log.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
                        k.this.etd();
                        if (k.this.bec()) {
                            Log.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
                            k.this.eta();
                        }
                        AppMethodBeat.o(137097);
                    }
                });
                AppMethodBeat.o(137101);
            }

            @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
            public final void onError(BaseMediaPlayer baseMediaPlayer, int i2, int i3, int i4) {
                AppMethodBeat.i(137102);
                Log.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), k.this.dtX);
                if (this.AhT == null) {
                    Log.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
                    AppMethodBeat.o(137102);
                    return;
                }
                boolean isNetworkConnected = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
                if (i3 == 80 && isNetworkConnected) {
                    Log.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
                }
                if (k.this.bFM > 0) {
                    Log.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", Integer.valueOf(k.this.bFM));
                    AppMethodBeat.o(137102);
                    return;
                }
                k.this.AhL = false;
                k.this.bFM++;
                k.this.rxv = i3;
                k.this.hlh = System.currentTimeMillis();
                k.a(k.this, i3);
                if (k.this.dtX.equalsIgnoreCase(this.AhT.dtX)) {
                    k.this.stopPlay();
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.music.b.k.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            boolean z;
                            AppMethodBeat.i(137098);
                            if (e.etK()) {
                                z = ((c) com.tencent.mm.plugin.music.f.c.b.aS(c.class)).etD();
                            } else {
                                Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
                                z = false;
                            }
                            if (z) {
                                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f8c), 0).show();
                            }
                            AppMethodBeat.o(137098);
                        }
                    });
                }
                k.this.St(i3);
                if (k.this.AhN != null) {
                    k.this.AhN.isStop = true;
                    k.this.AhN = null;
                }
                if (i2 == 91 && i3 == 55) {
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
                    g.aHD(k.this.dus);
                }
                AppMethodBeat.o(137102);
            }

            @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
            public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
                AppMethodBeat.i(137103);
                Log.i("MicroMsg.Audio.QQAudioPlayer", "onPrepared");
                AppMethodBeat.o(137103);
            }

            @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
            public final void onStateChanged(BaseMediaPlayer baseMediaPlayer, final int i2) {
                AppMethodBeat.i(137104);
                k.this.ndA.post(new Runnable() {
                    /* class com.tencent.mm.plugin.music.b.k.AnonymousClass1.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(137099);
                        Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", Integer.valueOf(i2), k.this.dtX);
                        if (i2 == 3) {
                            Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
                            AnonymousClass1.a(AnonymousClass1.this);
                            k.this.AhR = System.currentTimeMillis();
                            AppMethodBeat.o(137099);
                        } else if (i2 == 2) {
                            Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
                            Log.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", Long.valueOf(System.currentTimeMillis() - k.this.AhR));
                            AnonymousClass1.b(AnonymousClass1.this);
                            AppMethodBeat.o(137099);
                        } else if (i2 == 4) {
                            Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
                            Log.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", Long.valueOf(System.currentTimeMillis() - k.this.AhR));
                            AnonymousClass1.c(AnonymousClass1.this);
                            AppMethodBeat.o(137099);
                        } else if (i2 == 5) {
                            Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
                            AnonymousClass1.d(AnonymousClass1.this);
                            AppMethodBeat.o(137099);
                        } else if (i2 == 6) {
                            Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED!");
                            AnonymousClass1.e(AnonymousClass1.this);
                            AppMethodBeat.o(137099);
                        } else if (i2 == 7) {
                            Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
                            AnonymousClass1.f(AnonymousClass1.this);
                            AppMethodBeat.o(137099);
                        } else if (i2 == 8) {
                            Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
                            AnonymousClass1.etq();
                            AppMethodBeat.o(137099);
                        } else {
                            if (i2 == 9) {
                                Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
                            }
                            AppMethodBeat.o(137099);
                        }
                    }
                });
                AppMethodBeat.o(137104);
            }

            @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
            public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
                AppMethodBeat.i(137105);
                Log.i("MicroMsg.Audio.QQAudioPlayer", "onStarted");
                AppMethodBeat.o(137105);
            }

            static /* synthetic */ void a(AnonymousClass1 r5) {
                AppMethodBeat.i(198173);
                Log.i("MicroMsg.Audio.QQAudioPlayer", "_onPreparing");
                r5.AhT = k.this.dCT;
                if (r5.AhT == null) {
                    Log.e("MicroMsg.Audio.QQAudioPlayer", "cbMusic is null");
                    AppMethodBeat.o(198173);
                } else if (k.this.iJV || k.this.AhM) {
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                    AppMethodBeat.o(198173);
                } else {
                    k kVar = k.this;
                    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onPreparintEvent");
                    y yVar = new y();
                    yVar.dCW.action = 9;
                    yVar.dCW.state = "waiting";
                    yVar.dCW.dtX = kVar.esX();
                    yVar.dCW.appId = kVar.getAppId();
                    EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
                    AppMethodBeat.o(198173);
                }
            }

            static /* synthetic */ void b(AnonymousClass1 r9) {
                AppMethodBeat.i(198174);
                Log.i("MicroMsg.Audio.QQAudioPlayer", "_onPrepared");
                r9.AhT = k.this.dCT;
                if (k.this.iJV || k.this.AhM) {
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                    if (k.this.iJV && k.this.AhJ != null) {
                        k.this.AhJ.stop();
                    }
                    if (k.this.AhM) {
                        k.this.etb();
                    }
                    AppMethodBeat.o(198174);
                    return;
                }
                if (k.this.dvv != 0) {
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "seek to startTime:%d", Integer.valueOf(k.this.dvv));
                    k.this.tG(k.this.dvv);
                }
                if (!(k.this.AhJ == null || k.this.AhJ.getCurrentAudioInformation() == null || k.this.AhJ.getCurrentAudioInformation().getAudioType() == null)) {
                    k.this.audioType = k.this.AhJ.getCurrentAudioInformation().getAudioType();
                    if (k.this.audioType != null) {
                        Log.i("MicroMsg.Audio.QQAudioPlayer", "getAudioType:%d", Integer.valueOf(k.this.audioType.getValue()));
                    }
                    k kVar = k.this;
                    if (kVar.audioType != null) {
                        Log.i("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType audioType:%d, isStatMineType:%b", Integer.valueOf(kVar.audioType.getValue()), Boolean.valueOf(kVar.AhQ));
                        if (!kVar.AhQ) {
                            Log.i("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType OK");
                            kVar.AhQ = true;
                            if (kVar.Ahi != null) {
                                kVar.Ahi.Sx(kVar.audioType.getValue());
                            }
                        }
                    }
                }
                k.this.esY();
                if (!k.this.autoPlay) {
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "autoplay is false, don't start auto play!");
                    AppMethodBeat.o(198174);
                    return;
                }
                Log.i("MicroMsg.Audio.QQAudioPlayer", "start to play");
                try {
                    if (k.this.AhJ != null) {
                        k.this.AhJ.setVolume((float) k.this.dCT.iJG, (float) k.this.dCT.iJG);
                        k.this.eti();
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e2, "_onPrepared", new Object[0]);
                    k.this.St(502);
                    k.a(k.this, 502);
                }
                k.this.AhL = true;
                AppMethodBeat.o(198174);
            }

            static /* synthetic */ void c(AnonymousClass1 r12) {
                AppMethodBeat.i(137108);
                Log.i("MicroMsg.Audio.QQAudioPlayer", "_onStart");
                if (k.this.Ahi != null) {
                    k.this.Ahi.a(k.this.dCT.dtX, k.this.dCT.dvn, System.currentTimeMillis() - k.this.dCT.iJI, k.this.dCT.iJJ, k.this.dCT.iJK);
                }
                r12.AhT = k.this.dCT;
                if (k.this.iJV || k.this.AhM) {
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                    if (k.this.AhJ != null && k.this.AhL) {
                        k.this.AhL = false;
                        k.this.AhJ.stop();
                    }
                    AppMethodBeat.o(137108);
                    return;
                }
                k.this.esZ();
                if (k.this.AhN != null) {
                    k.this.AhN.isStop = true;
                }
                k.this.AhN = new a(k.this, (byte) 0);
                k.this.AhN.isStop = false;
                AppMethodBeat.o(137108);
            }

            static /* synthetic */ void d(AnonymousClass1 r3) {
                AppMethodBeat.i(137109);
                Log.i("MicroMsg.Audio.QQAudioPlayer", "_onPause");
                k.this.etb();
                AppMethodBeat.o(137109);
            }

            static /* synthetic */ void e(AnonymousClass1 r5) {
                AppMethodBeat.i(137110);
                Log.i("MicroMsg.Audio.QQAudioPlayer", "_onStop");
                if (r5.AhT == null) {
                    Log.e("MicroMsg.Audio.QQAudioPlayer", "currentMusic is null");
                    AppMethodBeat.o(137110);
                    return;
                }
                k.this.AhL = false;
                k.this.hlh = System.currentTimeMillis();
                if (k.this.dtX.equalsIgnoreCase(r5.AhT.dtX)) {
                    if (k.this.iJV) {
                        Log.i("MicroMsg.Audio.QQAudioPlayer", "stop play, but send pause state event");
                        k.this.etb();
                        AppMethodBeat.o(137110);
                        return;
                    }
                    k.this.etc();
                }
                AppMethodBeat.o(137110);
            }

            static /* synthetic */ void f(AnonymousClass1 r8) {
                AppMethodBeat.i(137111);
                Log.i("MicroMsg.Audio.QQAudioPlayer", "_onCompletion");
                if (!k.this.dCT.loop) {
                    k.this.ete();
                }
                if (k.this.AhN != null) {
                    k.this.AhN.isStop = true;
                    k.this.AhN = null;
                }
                k.this.hlh = System.currentTimeMillis();
                Log.i("MicroMsg.Audio.QQAudioPlayer", "play end, isPausedOnBackground:%b, playParam.loop:%b, isStartPlaying:%b, ", Boolean.valueOf(k.this.iJV), Boolean.valueOf(k.this.dCT.loop), Boolean.valueOf(k.this.AhL));
                if (k.this.iJV) {
                    k.this.AhL = false;
                    k.this.dvv = 0;
                    k.this.autoPlay = true;
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground is true, do stop player and don't play again");
                    AppMethodBeat.o(137111);
                } else if (k.this.AhM) {
                    k.this.AhL = false;
                    k.this.dvv = 0;
                    k.this.autoPlay = true;
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "isForcePause is true, do stop player and don't play again");
                    AppMethodBeat.o(137111);
                } else if (!k.this.dCT.loop || !k.this.AhL) {
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "play end, but not loop play");
                    k.this.AhL = false;
                    k.this.dvv = 0;
                    k.this.autoPlay = true;
                    AppMethodBeat.o(137111);
                } else {
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "play end normally and loop play again");
                    k.this.AhL = false;
                    k.this.dvv = 0;
                    k.this.autoPlay = true;
                    k.b(k.this);
                    AppMethodBeat.o(137111);
                }
            }

            static /* synthetic */ void etq() {
                AppMethodBeat.i(137112);
                Log.i("MicroMsg.Audio.QQAudioPlayer", "_onEnd");
                AppMethodBeat.o(137112);
            }
        };
        this.dtX = g.esG();
        com.tencent.mm.plugin.music.f.a.a.euV();
        h esI = h.esI();
        synchronized (esI.Ahm) {
            try {
                if (!esI.Ahm.contains(this)) {
                    esI.Ahm.add(this);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(137114);
                throw th;
            }
        }
        Log.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
        this.ndA = new MMHandler(Looper.myLooper());
        AppMethodBeat.o(137114);
    }

    public final void aHp(String str) {
        AppMethodBeat.i(137115);
        Log.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", str);
        this.dtX = str;
        AppMethodBeat.o(137115);
    }

    public final void g(com.tencent.mm.ai.b bVar) {
        AppMethodBeat.i(137116);
        this.dCT = bVar;
        this.dvv = bVar.dvv;
        this.autoPlay = bVar.iJE;
        if (this.AhJ != null && bec()) {
            Log.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", this.dtX, this.dus, Double.valueOf(this.dCT.iJG));
            this.AhJ.setVolume((float) this.dCT.iJG, (float) this.dCT.iJG);
            if (this.dCT.iJH > 0.0d) {
                Log.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", Double.valueOf(this.dCT.iJH));
                this.AhJ.setSpeed((float) this.dCT.iJH);
                AppMethodBeat.o(137116);
                return;
            }
            this.AhJ.setSpeed(1.0f);
        }
        AppMethodBeat.o(137116);
    }

    public final void s(com.tencent.mm.ai.b bVar) {
        AppMethodBeat.i(137117);
        if (bVar == null) {
            Log.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
            etf();
            AppMethodBeat.o(137117);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.AhP;
        if (this.dCT == null || !this.dCT.j(bVar) || j2 > 20) {
            this.Ahi = (com.tencent.mm.plugin.music.b.a.d) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.b.a.d.class);
            if (this.Ahi != null) {
                this.Ahi.Sw(bVar.fromScene);
            }
            this.AhP = currentTimeMillis;
            this.dCT = bVar;
            Log.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", Integer.valueOf(this.dCT.fromScene), this.dtX);
            if (this.AhJ != null && bec()) {
                this.AhJ.stop();
            }
            this.bFM = 0;
            this.dvv = bVar.dvv;
            this.autoPlay = bVar.iJE;
            this.audioType = null;
            this.AhQ = false;
            this.iJV = false;
            this.AhM = false;
            dlb();
            AppMethodBeat.o(137117);
            return;
        }
        this.dCT = bVar;
        this.dvv = bVar.dvv;
        this.autoPlay = bVar.iJE;
        Log.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", this.dus, Long.valueOf(j2));
        AppMethodBeat.o(137117);
    }

    private void dlb() {
        URL url;
        AppMethodBeat.i(137118);
        Log.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
        if (r(this.dCT)) {
            Log.i("MicroMsg.Audio.QQAudioPlayer", "play with pByteBuff");
            if (this.AhJ == null) {
                this.AhJ = new CommonPlayer(this.AhS);
            }
            this.AhJ.reset();
            try {
                this.AhJ.setDataSource(new com.tencent.mm.plugin.music.g.c(this.dCT.iJU));
                this.AhJ.prepare();
            } catch (Exception e2) {
                Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e2.getMessage());
                Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e2, "initPlayer", new Object[0]);
                St(501);
                Su(501);
            }
        } else if (!TextUtils.isEmpty(this.dCT.filePath) && this.dCT.iJR == null) {
            Log.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", this.dCT.filePath);
            if (this.AhJ == null) {
                this.AhJ = new CommonPlayer(this.AhS);
            }
            this.AhJ.reset();
            try {
                this.AhJ.setDataSource(this.dCT.filePath);
                this.AhJ.prepare();
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e3, "initPlayer exception", new Object[0]);
                St(501);
                Su(501);
            }
        } else if (TextUtils.isEmpty(this.dCT.filePath) || this.dCT.iJR == null) {
            Log.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", this.dCT.dvn);
            etg();
            try {
                url = new URL(this.dus);
            } catch (Exception e4) {
                Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e4, "initPlayer", new Object[0]);
                url = null;
            }
            if (url == null) {
                Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
                St(500);
                Su(500);
                AppMethodBeat.o(137118);
                return;
            }
            if (this.AhJ == null) {
                this.AhJ = new CommonPlayer(this.AhS);
            }
            this.AhJ.reset();
            if (this.AhO == null) {
                this.AhO = new b();
            }
            this.AhO.jb(this.dus, this.dCT.iJQ);
            try {
                this.AhJ.setDataSource(this.AhO, Uri.parse(url.toString()));
                this.AhJ.prepare();
            } catch (Exception e5) {
                Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e5.getMessage());
                Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e5, "initPlayer", new Object[0]);
                St(501);
                Su(501);
            }
        } else {
            Log.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", this.dCT.filePath);
            if (this.AhJ == null) {
                this.AhJ = new CommonPlayer(this.AhS);
            }
            this.AhJ.reset();
            try {
                this.AhJ.setDataSource(new com.tencent.mm.plugin.music.g.c(this.dCT.iJR));
                this.AhJ.prepare();
            } catch (Exception e6) {
                Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e6.getMessage());
                Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e6, "initPlayer", new Object[0]);
                St(501);
                Su(501);
            }
        }
        float f2 = 0.0f;
        if (this.dCT != null) {
            f2 = (float) this.dCT.iJH;
        }
        if (this.AhJ != null) {
            if (f2 < 0.5f || f2 > 2.0f) {
                this.AhJ.setSpeed(1.0f);
            } else {
                Log.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", Float.valueOf(f2));
                this.AhJ.setSpeed(f2);
                AppMethodBeat.o(137118);
                return;
            }
        }
        AppMethodBeat.o(137118);
    }

    private static boolean r(com.tencent.mm.ai.b bVar) {
        AppMethodBeat.i(198175);
        if (bVar == null || !bVar.dvn.startsWith("wxblob://") || bVar.iJU == null) {
            AppMethodBeat.o(198175);
            return false;
        }
        AppMethodBeat.o(198175);
        return true;
    }

    private void etg() {
        boolean z;
        AppMethodBeat.i(137119);
        this.dus = this.dCT.dvn;
        if (com.tencent.mm.plugin.music.h.e.aIg(this.dus)) {
            Log.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", this.dus);
        g.aHx(this.dus);
        g.bS(this.dus, z);
        AppMethodBeat.o(137119);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void pause() {
        AppMethodBeat.i(137120);
        Log.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", this.dtX);
        this.AhM = true;
        if (this.AhJ == null || !bec()) {
            if (this.AhJ != null && isCompleted()) {
                Log.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
                this.AhL = false;
            }
            AppMethodBeat.o(137120);
            return;
        }
        try {
            Log.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
            this.AhJ.pause();
            AppMethodBeat.o(137120);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e2, "pause", new Object[0]);
            St(503);
            Su(503);
            AppMethodBeat.o(137120);
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void eth() {
        AppMethodBeat.i(137121);
        Log.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
        pause();
        AppMethodBeat.o(137121);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void resume() {
        AppMethodBeat.i(137122);
        this.bFM = 0;
        boolean dFr = dFr();
        boolean bec = bec();
        this.AhM = false;
        this.iJV = false;
        Log.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", Boolean.valueOf(dFr), Boolean.valueOf(bec), Boolean.valueOf(this.AhL), this.dtX);
        if (this.AhJ != null && !asa() && !dFr && !bec && !this.AhL) {
            Log.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
            this.dvv = 0;
            this.autoPlay = true;
            dlb();
            if (this.Ahi != null) {
                this.Ahi.Sw(this.dCT.fromScene);
                AppMethodBeat.o(137122);
                return;
            }
        } else if (this.AhJ != null && ((isPaused() || asa()) && !bec)) {
            Log.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
            try {
                this.AhJ.setVolume((float) this.dCT.iJG, (float) this.dCT.iJG);
                eti();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e2, "resume", new Object[0]);
                St(502);
                Su(502);
            }
            this.AhL = true;
        }
        AppMethodBeat.o(137122);
    }

    /* access modifiers changed from: package-private */
    public final void eti() {
        AppMethodBeat.i(198176);
        if (asa() || isPaused()) {
            this.AhJ.setAudioStreamType(h.esI().getStreamType());
        }
        this.AhJ.start();
        AppMethodBeat.o(198176);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean bec() {
        AppMethodBeat.i(137123);
        if (this.AhJ == null) {
            AppMethodBeat.o(137123);
            return false;
        } else if (this.AhJ.getPlayerState() == 4) {
            AppMethodBeat.o(137123);
            return true;
        } else {
            AppMethodBeat.o(137123);
            return false;
        }
    }

    public final boolean dFr() {
        AppMethodBeat.i(137124);
        if (this.AhJ == null) {
            AppMethodBeat.o(137124);
            return false;
        } else if (this.AhJ.getPlayerState() == 3) {
            AppMethodBeat.o(137124);
            return true;
        } else {
            AppMethodBeat.o(137124);
            return false;
        }
    }

    public final boolean asa() {
        AppMethodBeat.i(137125);
        if (this.AhJ == null) {
            AppMethodBeat.o(137125);
            return false;
        } else if (this.AhJ.getPlayerState() == 2) {
            AppMethodBeat.o(137125);
            return true;
        } else {
            AppMethodBeat.o(137125);
            return false;
        }
    }

    public final boolean isPaused() {
        AppMethodBeat.i(137126);
        if (this.AhJ == null) {
            AppMethodBeat.o(137126);
            return false;
        } else if (this.AhJ.getPlayerState() == 5) {
            AppMethodBeat.o(137126);
            return true;
        } else {
            AppMethodBeat.o(137126);
            return false;
        }
    }

    public final boolean isCompleted() {
        AppMethodBeat.i(137127);
        if (this.AhJ == null) {
            AppMethodBeat.o(137127);
            return false;
        } else if (this.AhJ.getPlayerState() == 7) {
            AppMethodBeat.o(137127);
            return true;
        } else {
            AppMethodBeat.o(137127);
            return false;
        }
    }

    public final boolean isStopped() {
        AppMethodBeat.i(137128);
        if (this.AhJ == null) {
            AppMethodBeat.o(137128);
            return false;
        } else if (this.AhJ.getPlayerState() == 6) {
            AppMethodBeat.o(137128);
            return true;
        } else {
            AppMethodBeat.o(137128);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean bee() {
        AppMethodBeat.i(137129);
        if (!this.AhL || dFr()) {
            AppMethodBeat.o(137129);
            return false;
        }
        AppMethodBeat.o(137129);
        return true;
    }

    public final void etj() {
        AppMethodBeat.i(137130);
        Log.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
        this.iJV = true;
        this.AhM = true;
        AppMethodBeat.o(137130);
    }

    public final void etk() {
        AppMethodBeat.i(137131);
        Log.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
        this.iJV = true;
        etm();
        AppMethodBeat.o(137131);
    }

    public final void etl() {
        AppMethodBeat.i(137132);
        this.iJV = false;
        this.AhM = true;
        etc();
        this.hlh = System.currentTimeMillis();
        AppMethodBeat.o(137132);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void stopPlay() {
        AppMethodBeat.i(137133);
        Log.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
        this.iJV = false;
        etm();
        AppMethodBeat.o(137133);
    }

    private void etm() {
        AppMethodBeat.i(137134);
        try {
            if (this.AhJ != null) {
                this.AhJ.setVolume(0.0f, 0.0f);
                if (asa() || isPaused() || bec()) {
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "stop");
                    this.AhJ.stop();
                } else if (this.iJV) {
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "stop play, but send pause state event");
                    this.AhJ.reset();
                    etb();
                } else {
                    Log.i("MicroMsg.Audio.QQAudioPlayer", "reset and send stop event");
                    this.AhJ.reset();
                    etc();
                }
            }
            if (this.AhN != null) {
                this.AhN.isStop = true;
                this.AhN = null;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e2, "stopPlay", new Object[0]);
            St(504);
            Su(504);
        }
        this.AhL = false;
        this.AhM = true;
        this.hlh = System.currentTimeMillis();
        AppMethodBeat.o(137134);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final int etn() {
        AppMethodBeat.i(137135);
        if (this.AhJ != null) {
            int currentPosition = (int) this.AhJ.getCurrentPosition();
            AppMethodBeat.o(137135);
            return currentPosition;
        }
        AppMethodBeat.o(137135);
        return -1;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final int getDuration() {
        AppMethodBeat.i(137136);
        if (this.AhJ != null) {
            int duration = this.AhJ.getDuration();
            AppMethodBeat.o(137136);
            return duration;
        }
        AppMethodBeat.o(137136);
        return -1;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean tG(int i2) {
        AppMethodBeat.i(137137);
        int duration = getDuration();
        Log.i("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i2), Integer.valueOf(duration));
        if (duration < 0) {
            Log.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i2), Integer.valueOf(duration));
            stopPlay();
            AppMethodBeat.o(137137);
            return false;
        } else if (i2 > duration) {
            Log.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i2), Integer.valueOf(duration));
            AppMethodBeat.o(137137);
            return false;
        } else {
            if (this.AhJ != null) {
                Log.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
                y yVar = new y();
                yVar.dCW.action = 10;
                yVar.dCW.state = "seeking";
                yVar.dCW.dtX = esX();
                yVar.dCW.appId = getAppId();
                EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
                this.AhJ.seekTo(i2);
            }
            AppMethodBeat.o(137137);
            return true;
        }
    }

    public final d eto() {
        int i2;
        boolean z = false;
        AppMethodBeat.i(137138);
        if (this.AhK == null) {
            this.AhK = new d();
        }
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
        this.AhK.dCS = etn;
        this.AhK.duration = duration;
        d dVar = this.AhK;
        if (!bec) {
            z = true;
        }
        dVar.tN = z;
        this.AhK.iJV = this.iJV;
        this.AhK.iJW = (i2 * duration) / 100;
        if (this.dCT != null) {
            this.AhK.dvv = this.dCT.iJD;
            this.AhK.dtT = this.dCT.dvn;
            this.AhK.iJP = this.dCT.iJP;
            d dVar2 = this.AhK;
            AppMethodBeat.o(137138);
            return dVar2;
        }
        AppMethodBeat.o(137138);
        return null;
    }

    @Override // com.tencent.mm.plugin.music.b.i
    public final String esX() {
        return this.dtX;
    }

    @Override // com.tencent.mm.plugin.music.b.i
    public final String getAppId() {
        if (this.dCT != null) {
            return this.dCT.appId;
        }
        return "";
    }

    private void Su(int i2) {
        AppMethodBeat.i(137139);
        if (this.Ahi != null) {
            this.Ahi.ho(this.dCT.fromScene, i2);
        }
        AppMethodBeat.o(137139);
    }

    public final void release() {
        AppMethodBeat.i(137140);
        Log.i("MicroMsg.Audio.QQAudioPlayer", "release");
        this.Ahw = null;
        if (this.AhJ != null) {
            this.AhJ.release();
            this.AhJ = null;
        }
        h esI = h.esI();
        synchronized (esI.Ahm) {
            try {
                if (esI.Ahm.contains(this)) {
                    esI.Ahm.remove(this);
                }
            } finally {
                AppMethodBeat.o(137140);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        boolean isStop;

        private a() {
            this.isStop = true;
        }

        /* synthetic */ a(k kVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(137113);
            Log.i("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (k.this.AhJ != null && k.this.bec()) {
                        k.this.etp();
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.Audio.QQAudioPlayer", "PlayProgressTask run exception:" + e2.getMessage());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e3) {
                }
            }
            AppMethodBeat.o(137113);
        }
    }

    public final void etp() {
        AppMethodBeat.i(137141);
        if (this.dtX.equalsIgnoreCase(this.dCT.dtX) && this.AhJ != null && bec()) {
            int currentPosition = (int) this.AhJ.getCurrentPosition();
            int duration = this.AhJ.getDuration();
            if (currentPosition > 0 && duration > 0 && this.AhI != null) {
                this.AhI.fn(currentPosition, duration);
            }
        }
        AppMethodBeat.o(137141);
    }

    @Override // com.tencent.mm.plugin.music.b.i, com.tencent.mm.plugin.music.f.a.d
    public final boolean esV() {
        return true;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void b(d.a aVar) {
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void c(d.a aVar) {
    }
}
