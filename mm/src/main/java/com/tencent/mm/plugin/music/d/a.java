package com.tencent.mm.plugin.music.d;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.v;
import com.pay.tool.APPluginConstants;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import java.io.IOException;
import java.net.URL;

public final class a extends com.tencent.mm.plugin.music.f.a implements d.a, e.a {
    boolean AhL;
    private long AhP = 0;
    com.tencent.mm.ay.f Ajg;
    private com.tencent.mm.ay.c Ajh;
    int Aji = 0;
    v Ajj;
    private com.google.android.exoplayer2.g.c Ajk;
    private l Ajl;
    private g.a Ajm;
    private k Ajn;
    f Ajo = new f((byte) 0);
    C1533a Ajp = new C1533a(this, (byte) 0);
    e Ajq = new e(this, (byte) 0);
    d Ajr = new d(this, (byte) 0);
    b Ajs = new c();
    boolean Ajt = false;
    public boolean Aju = false;
    Handler aDv = new Handler(Looper.myLooper()) {
        /* class com.tencent.mm.plugin.music.d.a.AnonymousClass1 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(137225);
            if (100 == message.what) {
                Log.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", Long.valueOf(a.this.Ajj.getDuration()), Long.valueOf(a.this.Ajj.getCurrentPosition()), Long.valueOf(a.this.Ajj.getBufferedPosition()), Long.valueOf((long) a.this.Ajj.getBufferedPercentage()));
                a.this.aDv.removeMessages(100);
                if (a.this.AhL) {
                    a.this.aDv.sendEmptyMessageDelayed(100, 5000);
                }
            }
            AppMethodBeat.o(137225);
        }
    };
    int bFM = 0;
    boolean byX = false;
    private String dus = "";
    int dvv = 0;
    private long startTimeMs;
    protected String userAgent;

    public interface b {
        void SL(int i2);

        void etO();

        void etP();

        void etQ();

        void etR();

        void etS();

        void etT();

        void hs(int i2, int i3);
    }

    static /* synthetic */ void a(a aVar, com.tencent.mm.ay.f fVar, int i2, int i3) {
        AppMethodBeat.i(137277);
        aVar.b(fVar, i2, i3);
        AppMethodBeat.o(137277);
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(137279);
        aVar.hq(TXLiteAVCode.ERR_MIX_PARAM_INVALID, -40);
        AppMethodBeat.o(137279);
    }

    public a() {
        AppMethodBeat.i(137252);
        com.tencent.mm.plugin.music.f.b.a.euZ();
        AppMethodBeat.o(137252);
    }

    @Override // com.tencent.mm.plugin.music.f.a
    public final void h(com.tencent.mm.ay.f fVar) {
        AppMethodBeat.i(137253);
        super.h(fVar);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.AhP;
        if (this.Ajg != null && this.Ajg.f(fVar) && j2 <= 1000) {
            this.Ajg = fVar;
            Log.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", this.dus, Long.valueOf(j2));
            AppMethodBeat.o(137253);
        } else if (fVar == null) {
            Log.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
            AppMethodBeat.o(137253);
        } else {
            if (this.AlJ != null) {
                this.AlJ.v(fVar);
            }
            this.AhP = currentTimeMillis;
            Log.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", Long.valueOf(currentTimeMillis), Integer.valueOf(fVar.dvv));
            if (this.Ajj != null && bec()) {
                this.Ajj.stop();
            }
            this.bFM = 0;
            this.dvv = fVar.dvv;
            this.startTimeMs = SystemClock.elapsedRealtime();
            this.Ajg = fVar;
            G(this.Ajg);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", Integer.valueOf(this.dvv));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.music.d.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(137226);
                    a.a(a.this);
                    AppMethodBeat.o(137226);
                }
            });
            AppMethodBeat.o(137253);
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a
    public final void etM() {
        AppMethodBeat.i(137254);
        this.AlJ = (com.tencent.mm.plugin.music.e.d) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.d.class);
        this.AlK = com.tencent.mm.plugin.music.e.k.euj().AjC;
        AppMethodBeat.o(137254);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void pause() {
        AppMethodBeat.i(137255);
        this.Aju = false;
        Log.i("MicroMsg.Music.ExoMusicPlayer", "pause");
        if (this.Ajj != null) {
            this.Aji = 2;
            this.Ajj.aO(false);
        }
        AppMethodBeat.o(137255);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean bed() {
        return this.AhL && this.Aju;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void esU() {
        AppMethodBeat.i(137256);
        this.Aju = true;
        Log.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
        if (this.Ajj != null) {
            this.Aji = 2;
            this.Ajj.aO(false);
        }
        AppMethodBeat.o(137256);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void eth() {
        AppMethodBeat.i(137257);
        Log.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
        pause();
        com.tencent.mm.plugin.music.e.k.eul().bLZ();
        AppMethodBeat.o(137257);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void resume() {
        AppMethodBeat.i(137258);
        this.bFM = 0;
        Log.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", Boolean.valueOf(dFr()), Boolean.valueOf(bec()));
        if (this.Ajj != null) {
            if (com.tencent.mm.plugin.music.e.k.eul().requestFocus()) {
                this.Aji = 1;
                this.Ajj.aO(true);
                J(this.Ajg);
            } else {
                Log.e("MicroMsg.Music.ExoMusicPlayer", "request focus error");
            }
            this.AhL = true;
        }
        AppMethodBeat.o(137258);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean bec() {
        AppMethodBeat.i(137259);
        if (this.Ajj == null) {
            AppMethodBeat.o(137259);
            return false;
        }
        switch (this.Ajj.ti()) {
            case 1:
            case 3:
                boolean tj = this.Ajj.tj();
                AppMethodBeat.o(137259);
                return tj;
            case 2:
            default:
                AppMethodBeat.o(137259);
                return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean dFr() {
        AppMethodBeat.i(137260);
        if (this.Ajj != null) {
            boolean isLoading = this.Ajj.isLoading();
            AppMethodBeat.o(137260);
            return isLoading;
        }
        AppMethodBeat.o(137260);
        return false;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean bee() {
        AppMethodBeat.i(137261);
        if (!this.AhL || dFr()) {
            AppMethodBeat.o(137261);
            return false;
        }
        AppMethodBeat.o(137261);
        return true;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void stopPlay() {
        AppMethodBeat.i(137262);
        Log.i("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
        try {
            if (this.Ajj != null) {
                this.Aji = 3;
                this.Ajj.aO(false);
                this.Ajj.stop();
                L(this.Ajg);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e2, "stopPlay", new Object[0]);
            d(this.Ajg, 504);
            b(this.Ajg, TXLiteAVCode.ERR_REQUEST_ACC_BY_HOST_IP, -42);
        }
        com.tencent.mm.plugin.music.e.k.eul().bLZ();
        this.AhL = false;
        this.Aju = false;
        this.aDv.removeMessages(100);
        AppMethodBeat.o(137262);
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final int etn() {
        AppMethodBeat.i(137263);
        if (this.Ajj != null) {
            int currentPosition = (int) this.Ajj.getCurrentPosition();
            AppMethodBeat.o(137263);
            return currentPosition;
        }
        AppMethodBeat.o(137263);
        return 0;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final int getDuration() {
        AppMethodBeat.i(137264);
        if (this.Ajj != null) {
            int duration = (int) this.Ajj.getDuration();
            AppMethodBeat.o(137264);
            return duration;
        }
        AppMethodBeat.o(137264);
        return 0;
    }

    public final int getDownloadPercent() {
        AppMethodBeat.i(137265);
        if (this.Ajj != null) {
            int bufferedPercentage = this.Ajj.getBufferedPercentage();
            AppMethodBeat.o(137265);
            return bufferedPercentage;
        }
        AppMethodBeat.o(137265);
        return 0;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean tG(int i2) {
        boolean z = false;
        AppMethodBeat.i(137266);
        int duration = getDuration();
        Log.i("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i2), Integer.valueOf(duration));
        if (duration < 0 || i2 > duration) {
            Log.e("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i2), Integer.valueOf(duration));
            AppMethodBeat.o(137266);
            return false;
        }
        if (this.Ajj != null) {
            N(this.Ajg);
            f fVar = this.Ajo;
            if ((this.Ajo.mCA[3] & ShareElfFile.SectionHeader.SHF_MASKPROC) != 0) {
                z = true;
            }
            fVar.q(z, 100);
            this.Aji = 4;
            this.Ajj.seekTo((long) i2);
        }
        AppMethodBeat.o(137266);
        return true;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final com.tencent.mm.ay.c esW() {
        int i2 = 0;
        AppMethodBeat.i(137267);
        int duration = getDuration();
        int etn = etn();
        boolean bec = bec();
        int downloadPercent = getDownloadPercent();
        if (downloadPercent < 0) {
            downloadPercent = 0;
        }
        if ((this.Ajn instanceof h) && !this.byX) {
            duration = 0;
        }
        if (this.Ajh != null) {
            com.tencent.mm.ay.c cVar = this.Ajh;
            if (bec) {
                i2 = 1;
            }
            cVar.t(duration, etn, i2, downloadPercent);
        } else {
            if (bec) {
                i2 = 1;
            }
            this.Ajh = new com.tencent.mm.ay.c(duration, etn, i2, downloadPercent);
        }
        this.Ajh.dSG = true;
        this.Ajh.jeQ = euQ();
        com.tencent.mm.ay.c cVar2 = this.Ajh;
        AppMethodBeat.o(137267);
        return cVar2;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean esV() {
        return true;
    }

    public final void release() {
        AppMethodBeat.i(137268);
        Log.i("MicroMsg.Music.ExoMusicPlayer", "release");
        this.aDv.removeMessages(100);
        esT();
        if (this.Ajj != null) {
            this.Ajj.b(this.Ajp);
            this.Ajj.bdU.remove(this);
            this.Ajj.release();
            this.Ajj = null;
        }
        if (this.Ajn != null) {
            this.Ajn.vu();
            this.Ajn = null;
        }
        this.Ajk = null;
        this.Ajm = null;
        AppMethodBeat.o(137268);
    }

    public class c implements b {
        public c() {
        }

        @Override // com.tencent.mm.plugin.music.d.a.b
        public final void etO() {
            AppMethodBeat.i(137232);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
            if (a.this.Ajg != null) {
                a.this.H(a.this.Ajg);
            }
            if (a.this.dvv > 0) {
                Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", Integer.valueOf(a.this.dvv));
                a.this.tG(a.this.dvv);
            }
            if (a.this.dvv == 0 && !a.this.Ajj.tj()) {
                Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
                a.this.Ajj.aO(true);
            }
            AppMethodBeat.o(137232);
        }

        @Override // com.tencent.mm.plugin.music.d.a.b
        public final void etP() {
            AppMethodBeat.i(137233);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
            if (a.this.Ajg != null) {
                a.this.I(a.this.Ajg);
            }
            AppMethodBeat.o(137233);
        }

        @Override // com.tencent.mm.plugin.music.d.a.b
        public final void etQ() {
            AppMethodBeat.i(137234);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (a.this.Ajg != null && !a.this.Ajj.tj()) {
                a.this.K(a.this.Ajg);
            }
            AppMethodBeat.o(137234);
        }

        @Override // com.tencent.mm.plugin.music.d.a.b
        public final void etR() {
            AppMethodBeat.i(137235);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
            if (a.this.Ajg != null) {
                a.this.L(a.this.Ajg);
            }
            AppMethodBeat.o(137235);
        }

        @Override // com.tencent.mm.plugin.music.d.a.b
        public final void etS() {
            AppMethodBeat.i(137236);
            if (a.this.dFr()) {
                a.this.Ajt = true;
                AppMethodBeat.o(137236);
                return;
            }
            a.b(a.this);
            AppMethodBeat.o(137236);
        }

        @Override // com.tencent.mm.plugin.music.d.a.b
        public final void etT() {
            AppMethodBeat.i(137237);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
            if (a.this.Ajg != null) {
                a.this.O(a.this.Ajg);
            }
            a.this.AhL = false;
            a.this.aDv.removeMessages(100);
            AppMethodBeat.o(137237);
        }

        @Override // com.tencent.mm.plugin.music.d.a.b
        public final void SL(int i2) {
            AppMethodBeat.i(137238);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", Integer.valueOf(i2));
            AppMethodBeat.o(137238);
        }

        @Override // com.tencent.mm.plugin.music.d.a.b
        public final void hs(int i2, int i3) {
            AppMethodBeat.i(137239);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (a.this.Ajg != null) {
                a.this.a(a.this.Ajg, i2, i3);
            }
            if (a.this.Ajj != null) {
                a.this.Ajj.aO(false);
                a.this.Ajj.stop();
            }
            a.this.AhL = false;
            a.this.aDv.removeMessages(100);
            a.this.bFM++;
            if (a.this.bFM == 1) {
                a.a(a.this, a.this.Ajg, i2, i3);
            }
            AppMethodBeat.o(137239);
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a
    public final void a(com.tencent.mm.ay.f fVar, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(137269);
        Log.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.AlI = "error";
        mx mxVar = new mx();
        mxVar.dSE.action = 4;
        mxVar.dSE.dSy = fVar;
        mxVar.dSE.state = "error";
        mxVar.dSE.duration = (long) getDuration();
        mxVar.dSE.dSG = true;
        mx.a aVar = mxVar.dSE;
        Log.i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", Integer.valueOf(i2));
        switch (i2) {
            case -4999:
                i4 = -1;
                break;
            case TXLiteAVCode.ERR_REQUEST_ACC_BY_HOST_IP:
            case TXLiteAVCode.ERR_MIX_PARAM_INVALID:
            case TXLiteAVCode.ERR_USER_DEFINE_RECORD_ID_INVALID:
            case TXLiteAVCode.ERR_CUSTOM_STREAM_INVALID:
                i4 = 10001;
                break;
            case TXLiteAVCode.ERR_REQUEST_QUERY_CONFIG_TIMEOUT:
                i4 = ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL;
                break;
            case -4000:
                i4 = 10002;
                break;
        }
        aVar.errCode = i4;
        mx.a aVar2 = mxVar.dSE;
        StringBuilder sb = new StringBuilder();
        sb.append("errCode:" + i3 + ", err:");
        switch (i3) {
            case TXLiteAVCode.ERR_MIX_PARAM_INVALID:
                sb.append("load error");
                break;
            case TXLiteAVCode.ERR_USER_DEFINE_RECORD_ID_INVALID:
                sb.append("MediaCodec decoder init exception");
                break;
            case TXLiteAVCode.ERR_CUSTOM_STREAM_INVALID:
                sb.append("illegal state exception");
                break;
            case TXLiteAVCode.ERR_REQUEST_QUERY_CONFIG_TIMEOUT:
                sb.append("UnrecognizedInputFormatException");
                break;
            case APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException:
                sb.append("error url format");
                break;
            case APPluginConstants.ERROR_IO_SSLException_SSLKeyException:
                sb.append("stop error");
                break;
            case APPluginConstants.ERROR_IO_SSLException_SSLHandshakeException:
                sb.append("prepare error");
                break;
            case APPluginConstants.ERROR_IO_InvalidPropertiesFormatException:
                sb.append(" network error");
                break;
            case -13:
                sb.append(" network respCode 502");
                break;
            case -12:
                sb.append(" network respCode 500");
                break;
            case -11:
                sb.append(" network respCode 404");
                break;
            case -10:
                sb.append(" network respCode 403");
                break;
            case -3:
                sb.append("connect fail");
                break;
            case -2:
                sb.append(" no network");
                break;
            case -1:
                sb.append("unknow exception");
                break;
        }
        aVar2.errMsg = sb.toString();
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
        AppMethodBeat.o(137269);
    }

    /* access modifiers changed from: package-private */
    public final void hq(int i2, int i3) {
        AppMethodBeat.i(137270);
        Log.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.Ajs != null) {
            this.Ajs.hs(i2, i3);
        }
        AppMethodBeat.o(137270);
    }

    /* access modifiers changed from: package-private */
    public final void hr(int i2, int i3) {
        AppMethodBeat.i(137271);
        Log.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + i2 + "," + i3 + "]");
        if (this.Ajs != null && (i2 == 701 || i2 == 702)) {
            this.Ajs.SL(i3);
        }
        AppMethodBeat.o(137271);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.music.d.a$a  reason: collision with other inner class name */
    public class C1533a implements f.a {
        private C1533a() {
        }

        /* synthetic */ C1533a(a aVar, byte b2) {
            this();
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void ty() {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void tz() {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void aR(boolean z) {
            AppMethodBeat.i(137227);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + z + "]");
            if (!z && a.this.Ajt) {
                a.this.Ajt = false;
                a.b(a.this);
            }
            AppMethodBeat.o(137227);
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void c(boolean z, int i2) {
            AppMethodBeat.i(137228);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "state [" + a.this.etN() + ", " + z + ", " + com.tencent.mm.plugin.music.f.b.a.Td(i2) + "]");
            a aVar = a.this;
            if (aVar.Ajj != null) {
                boolean tj = aVar.Ajj.tj();
                int ti = aVar.Ajj.ti();
                if (tj && ti == 3) {
                    Log.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
                    if (aVar.Ajs != null) {
                        aVar.Ajs.etP();
                    }
                } else if (!tj && ti == 3 && aVar.Aji == 2) {
                    Log.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
                    if (aVar.Ajs != null) {
                        aVar.Ajs.etQ();
                    }
                } else if (!tj && ti == 3 && aVar.Aji == 3) {
                    Log.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
                    if (aVar.Ajs != null) {
                        aVar.Ajs.etR();
                    }
                }
                int r = f.r(tj, ti);
                if (r != aVar.Ajo.mCA[3]) {
                    Log.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + tj + "," + ti + "]");
                    aVar.Ajo.q(tj, ti);
                    if (r == f.r(true, 4)) {
                        Log.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
                        if (aVar.Ajs != null) {
                            aVar.Ajs.etT();
                        }
                        AppMethodBeat.o(137228);
                        return;
                    }
                    if (aVar.Ajo.a(new int[]{f.r(false, 1), f.r(false, 2), f.r(false, 3)}, false)) {
                        Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
                        if (aVar.Ajs != null) {
                            aVar.Ajs.etO();
                        }
                        AppMethodBeat.o(137228);
                        return;
                    } else if ((aVar.Ajo.a(new int[]{100, 2, 3}, true) | aVar.Ajo.a(new int[]{2, 100, 3}, true)) || aVar.Ajo.a(new int[]{100, 3, 2, 3}, true)) {
                        Log.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
                        if (aVar.Ajs != null) {
                            aVar.Ajs.etS();
                        }
                        AppMethodBeat.o(137228);
                        return;
                    } else {
                        if (aVar.Ajo.a(new int[]{f.r(true, 3), f.r(true, 2)}, false)) {
                            Log.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
                            aVar.hr(701, aVar.getDownloadPercent());
                            AppMethodBeat.o(137228);
                            return;
                        }
                        if (aVar.Ajo.a(new int[]{f.r(true, 2), f.r(true, 3)}, false)) {
                            Log.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
                            aVar.hr(702, aVar.getDownloadPercent());
                        }
                    }
                }
            }
            AppMethodBeat.o(137228);
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void aA(int i2) {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void a(com.google.android.exoplayer2.e eVar) {
            AppMethodBeat.i(137229);
            Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", eVar, "playerFailed [" + a.this.etN() + "]", new Object[0]);
            a aVar = a.this;
            if (eVar != null) {
                Throwable cause = eVar.getCause();
                if (cause == null) {
                    aVar.hq(-4999, -1);
                } else if (cause instanceof s.c) {
                    if (cause.toString().contains("Unable to connect")) {
                        boolean isNetworkConnected = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
                        Log.e("MicroMsg.Music.ExoMusicPlayer", "ExoPlaybackException hasNetwork=" + isNetworkConnected + " caused by:\n" + cause.toString());
                        if (!isNetworkConnected) {
                            aVar.hq(-4000, -2);
                            AppMethodBeat.o(137229);
                            return;
                        }
                        aVar.hq(-4000, -3);
                        AppMethodBeat.o(137229);
                        return;
                    } else if (cause instanceof s.e) {
                        String th = cause.toString();
                        if (th.contains("403")) {
                            aVar.hq(-4000, -10);
                        } else if (th.contains("404")) {
                            aVar.hq(-4000, -11);
                        } else if (th.contains("500")) {
                            aVar.hq(-4000, -12);
                        } else if (th.contains("502")) {
                            aVar.hq(-4000, -13);
                        } else {
                            aVar.hq(-4000, -30);
                        }
                    }
                } else if (cause instanceof com.google.android.exoplayer2.source.s) {
                    aVar.hq(TXLiteAVCode.ERR_REQUEST_QUERY_CONFIG_TIMEOUT, -1);
                } else if (cause instanceof IllegalStateException) {
                    aVar.hq(TXLiteAVCode.ERR_CUSTOM_STREAM_INVALID, -1);
                } else if (cause instanceof b.a) {
                    aVar.hq(TXLiteAVCode.ERR_USER_DEFINE_RECORD_ID_INVALID, -1);
                } else {
                    aVar.hq(-4999, -1);
                }
            }
            Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", eVar, "ExoPlaybackException", new Object[0]);
            AppMethodBeat.o(137229);
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void tA() {
            AppMethodBeat.i(137230);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
            AppMethodBeat.o(137230);
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void b(p pVar) {
            AppMethodBeat.i(137231);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", Float.valueOf(pVar.bdN), Float.valueOf(pVar.pitch)));
            AppMethodBeat.o(137231);
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements com.google.android.exoplayer2.source.b, h.a {
        private d() {
        }

        /* synthetic */ d(a aVar, byte b2) {
            this();
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void a(j jVar, int i2, Format format, long j2, long j3, long j4) {
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void a(j jVar, int i2, Format format, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z) {
            AppMethodBeat.i(177347);
            a.a(a.this, "loadError", iOException);
            if (!(jVar == null || format == null)) {
                Log.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", jVar.uri, format.toString());
            }
            a.c(a.this);
            AppMethodBeat.o(177347);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void c(j jVar, int i2, Format format, long j2, long j3, long j4) {
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void b(j jVar, int i2, Format format, long j2, long j3, long j4) {
            AppMethodBeat.i(177348);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
            AppMethodBeat.o(177348);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void a(int i2, Format format, long j2) {
        }

        @Override // com.google.android.exoplayer2.source.h.a
        public final void onLoadError(IOException iOException) {
            AppMethodBeat.i(137242);
            a.a(a.this, "loadError", iOException);
            Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", iOException, "onLoadError", new Object[0]);
            a.c(a.this);
            AppMethodBeat.o(137242);
        }

        @Override // com.google.android.exoplayer2.source.b
        public final void vl() {
            AppMethodBeat.i(137243);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
            a.this.byX = true;
            AppMethodBeat.o(137243);
        }
    }

    @Override // com.google.android.exoplayer2.metadata.e.a
    public final void b(Metadata metadata) {
        AppMethodBeat.i(137272);
        Log.i("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
        com.tencent.mm.plugin.music.f.b.a.a(metadata, "  ");
        Log.i("MicroMsg.Music.ExoMusicPlayer", "]");
        AppMethodBeat.o(137272);
    }

    /* access modifiers changed from: package-private */
    public class e implements com.google.android.exoplayer2.a.e {
        private e() {
        }

        /* synthetic */ e(a aVar, byte b2) {
            this();
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void c(com.google.android.exoplayer2.b.d dVar) {
            AppMethodBeat.i(137244);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + a.this.etN() + "]");
            AppMethodBeat.o(137244);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void dG(int i2) {
            AppMethodBeat.i(137245);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + i2 + "]");
            AppMethodBeat.o(137245);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void c(String str, long j2, long j3) {
            AppMethodBeat.i(137246);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + a.this.etN() + ", " + str + "]");
            AppMethodBeat.o(137246);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void d(Format format) {
            AppMethodBeat.i(137247);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + a.this.etN() + ", " + Format.a(format) + "]");
            AppMethodBeat.o(137247);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void d(com.google.android.exoplayer2.b.d dVar) {
            AppMethodBeat.i(137248);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + a.this.etN() + "]");
            AppMethodBeat.o(137248);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void d(int i2, long j2, long j3) {
            AppMethodBeat.i(137249);
            a.a(a.this, "audioTrackUnderrun [" + i2 + ", " + j2 + ", " + j3 + "]", (Exception) null);
            AppMethodBeat.o(137249);
        }
    }

    /* access modifiers changed from: package-private */
    public final String etN() {
        AppMethodBeat.i(137273);
        String Hq = com.tencent.mm.plugin.music.f.b.a.Hq(SystemClock.elapsedRealtime() - this.startTimeMs);
        AppMethodBeat.o(137273);
        return Hq;
    }

    /* access modifiers changed from: package-private */
    public static class f {
        int[] mCA;

        private f() {
            AppMethodBeat.i(137250);
            this.mCA = new int[]{1, 1, 1, 1};
            AppMethodBeat.o(137250);
        }

        /* synthetic */ f(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void q(boolean z, int i2) {
            AppMethodBeat.i(137251);
            int r = r(z, i2);
            Log.i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + z + "," + i2 + "], lastState=" + this.mCA[3] + ",newState=" + r);
            if (this.mCA[3] == r) {
                AppMethodBeat.o(137251);
                return;
            }
            this.mCA[0] = this.mCA[1];
            this.mCA[1] = this.mCA[2];
            this.mCA[2] = this.mCA[3];
            this.mCA[3] = r;
            Log.v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.mCA[0] + "," + this.mCA[1] + "," + this.mCA[2] + "," + this.mCA[3] + "]");
            AppMethodBeat.o(137251);
        }

        static int r(boolean z, int i2) {
            return (z ? ShareElfFile.SectionHeader.SHF_MASKPROC : 0) | i2;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(int[] iArr, boolean z) {
            int i2 = z ? 268435455 : -1;
            int length = this.mCA.length - iArr.length;
            boolean z2 = true;
            for (int i3 = length; i3 < this.mCA.length; i3++) {
                z2 &= (this.mCA[i3] & i2) == (iArr[i3 - length] & i2);
            }
            return z2;
        }
    }

    private void b(com.tencent.mm.ay.f fVar, int i2, int i3) {
        AppMethodBeat.i(137274);
        if (this.AlJ != null) {
            this.AlJ.d(fVar, i2, i3);
        }
        AppMethodBeat.o(137274);
    }

    static /* synthetic */ void a(a aVar) {
        String str;
        URL url;
        AppMethodBeat.i(137275);
        Log.i("MicroMsg.Music.ExoMusicPlayer", "initPlayer");
        boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
        PBool pBool = new PBool();
        if (Util.isNullOrNil(aVar.Ajg.jfb)) {
            str = aVar.Ajg.jfd;
        } else {
            str = aVar.Ajg.jfb;
        }
        aVar.dus = com.tencent.mm.plugin.music.h.e.a(str, aVar.Ajg.jfc, isWifi, pBool);
        Log.i("MicroMsg.Music.ExoMusicPlayer", "mSrc:%s", aVar.dus);
        Log.i("MicroMsg.Music.ExoMusicPlayer", "field_songWifiUrl:%s", aVar.Ajg.jfb);
        try {
            url = new URL(aVar.dus);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e2, "initPlayer", new Object[0]);
            Log.e("MicroMsg.Music.ExoMusicPlayer", "new URL exception:" + e2.getMessage());
            url = null;
        }
        if (url == null) {
            Log.e("MicroMsg.Music.ExoMusicPlayer", "initPlayer url is null");
            aVar.d(aVar.Ajg, 500);
            aVar.b(aVar.Ajg, TXLiteAVCode.ERR_REQUEST_ACC_BY_HOST_IP, -43);
            AppMethodBeat.o(137275);
            return;
        }
        if (aVar.Ajj != null && (aVar.Aji != 3 || aVar.Ajj.tj())) {
            Log.i("MicroMsg.Music.ExoMusicPlayer", "stop it first!");
            aVar.Aji = 3;
            aVar.Ajj.aO(false);
            aVar.Ajj.stop();
        }
        aVar.Ajo.mCA = new int[]{1, 1, 1, 1};
        aVar.userAgent = x.h(MMApplicationContext.getContext(), "wechat");
        Uri parse = Uri.parse(aVar.dus);
        if (aVar.Ajj == null) {
            aVar.Ajl = new l(aVar.aDv, aVar);
            aVar.Ajk = new com.google.android.exoplayer2.g.c();
            aVar.Ajj = com.google.android.exoplayer2.g.a(MMApplicationContext.getContext(), aVar.Ajk, new com.google.android.exoplayer2.c());
        }
        if (aVar.Ajm == null) {
            aVar.Ajm = new n(MMApplicationContext.getContext(), aVar.Ajl, new com.google.android.exoplayer2.h.p(aVar.userAgent, aVar.Ajl));
        }
        try {
            aVar.byX = false;
            aVar.Ajn = new com.google.android.exoplayer2.source.b.h(parse, aVar.Ajm, aVar.aDv, aVar.Ajr);
            aVar.Ajj.a(aVar.Ajp);
            aVar.Ajj.bdU.add(aVar);
            aVar.Ajj.bed = aVar.Ajq;
            aVar.Aji = 0;
            if (aVar.dvv == 0) {
                Log.i("MicroMsg.Music.ExoMusicPlayer", "startTime is 0, play it when ready!");
                aVar.Ajj.aO(true);
            } else {
                aVar.Ajj.aO(false);
            }
            aVar.Ajj.a(aVar.Ajn);
            aVar.AhL = true;
            aVar.aDv.sendEmptyMessageDelayed(100, 5000);
            AppMethodBeat.o(137275);
        } catch (Exception e3) {
            Log.e("MicroMsg.Music.ExoMusicPlayer", "initPlayer exception:" + e3.getMessage());
            Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e3, "initPlayer", new Object[0]);
            aVar.d(aVar.Ajg, 501);
            aVar.b(aVar.Ajg, TXLiteAVCode.ERR_REQUEST_ACC_BY_HOST_IP, -41);
            AppMethodBeat.o(137275);
        }
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(137276);
        Log.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
        if (aVar.Ajg != null) {
            aVar.M(aVar.Ajg);
        }
        if (aVar.dvv > 0 && aVar.Ajj != null && !aVar.Ajj.tj()) {
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete, stay play hls");
            aVar.dvv = 0;
            aVar.Ajj.aO(true);
        }
        AppMethodBeat.o(137276);
    }

    static /* synthetic */ void a(a aVar, String str, Exception exc) {
        AppMethodBeat.i(137278);
        Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", exc, "internalError [" + aVar.etN() + ", " + str + "]", new Object[0]);
        AppMethodBeat.o(137278);
    }
}
