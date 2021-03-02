package com.tencent.mm.plugin.n;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.f.c.d;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class j implements c {
    Looper zrN;
    MMHandler zrO;
    HandlerThread zrP;
    HandlerThread zrQ;
    a zrR;
    public k zrS;
    public d zrT;
    private MMHandler.Callback zrU;

    public j(Looper looper) {
        this(looper, (byte) 0);
    }

    private j(Looper looper, byte b2) {
        this(looper, 0);
        AppMethodBeat.i(133915);
        AppMethodBeat.o(133915);
    }

    public j(Looper looper, int i2) {
        AppMethodBeat.i(208744);
        this.zrU = new MMHandler.Callback() {
            /* class com.tencent.mm.plugin.n.j.AnonymousClass1 */

            public final boolean handleMessage(Message message) {
                AppMethodBeat.i(133914);
                int i2 = message.what;
                switch (i2) {
                    case 1:
                        Log.i("MicroMsg.VideoPlayer", "%s call prepared ", j.this.info());
                        if (j.this.zrT != null) {
                            j.this.zrT.tf();
                            break;
                        }
                        break;
                    case 2:
                        Log.i("MicroMsg.VideoPlayer", "%s call completion ", j.this.info());
                        if (j.this.zrT != null) {
                            j.this.zrT.onCompletion();
                            break;
                        }
                        break;
                    case 3:
                        Log.i("MicroMsg.VideoPlayer", "%s call seek completion ", j.this.info());
                        if (j.this.zrT != null) {
                            j.this.zrT.cJH();
                            break;
                        }
                        break;
                    case 4:
                        Log.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", j.this.info(), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2), Integer.valueOf(((Integer) message.obj).intValue()));
                        if (j.this.zrT != null) {
                            j.this.zrT.aa(message.arg1, message.arg2, ((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 5:
                        Log.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", j.this.info(), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
                        if (j.this.zrT != null) {
                            j.this.zrT.onError(message.arg1, message.arg2);
                            break;
                        }
                        break;
                    case 6:
                        try {
                            j jVar = j.this;
                            Log.i("MicroMsg.VideoPlayer", "%s clear now.", jVar.info());
                            jVar.zrR.quit();
                            jVar.zrP.quitSafely();
                            if (jVar.zrQ != null) {
                                jVar.zrQ.quitSafely();
                            }
                            jVar.zrO.removeMessages(1);
                            jVar.zrO.removeMessages(2);
                            jVar.zrO.removeMessages(3);
                            jVar.zrO.removeMessages(4);
                            jVar.zrO.removeMessages(5);
                            jVar.zrP = null;
                            jVar.zrO = null;
                            jVar.zrN = null;
                            jVar.zrT = null;
                            jVar.zrS = null;
                            break;
                        } catch (Exception e2) {
                            break;
                        }
                    default:
                        Log.w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", j.this.info(), Integer.valueOf(i2));
                        break;
                }
                AppMethodBeat.o(133914);
                return false;
            }
        };
        this.zrR = a.bqt("VideoPlayer:inner");
        this.zrP = d.hA("VideoPlayer:video", 10);
        this.zrP.start();
        this.zrQ = d.hA("VideoPlayer:audio", 10);
        Log.i("MicroMsg.VideoPlayer", "VideoPlayer init 4");
        this.zrQ.start();
        this.zrN = looper;
        this.zrO = new MMHandler(this.zrN, this.zrU);
        this.zrS = new k(this.zrO, this.zrR, this.zrP.getLooper(), this.zrQ.getLooper(), false, i2);
        AppMethodBeat.o(208744);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void setPath(String str) {
        AppMethodBeat.i(133916);
        Log.i("MicroMsg.VideoPlayer", "%s video player set path %s", info(), str);
        this.zrS.setPath(str);
        AppMethodBeat.o(133916);
    }

    public final void a(d dVar) {
        this.zrT = dVar;
    }

    public final void setIOnlineCache(b bVar) {
        if (bVar != null && this.zrS != null) {
            this.zrS.zsb.zrF = bVar;
        }
    }

    public final void ra(boolean z) {
        this.zrS.zsb.zso = z;
    }

    public final void setNeedResetExtractor(boolean z) {
        AppMethodBeat.i(133917);
        if (this.zrS != null) {
            k kVar = this.zrS;
            Log.i("MicroMsg.VideoPlayerImpl", "%s setNeedResetExtractor [%b]", kVar.info(), Boolean.valueOf(z));
            if (kVar.zrC != null) {
                kVar.zrC.rsr = z;
            }
        }
        AppMethodBeat.o(133917);
    }

    public final void setIsOnlineVideoType(boolean z) {
        AppMethodBeat.i(133918);
        if (this.zrS != null) {
            k kVar = this.zrS;
            if (kVar.zrC != null) {
                Log.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", kVar.info(), Boolean.valueOf(z));
                kVar.zrC.rss = z;
            }
        }
        AppMethodBeat.o(133918);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void setSurface(Surface surface) {
        AppMethodBeat.i(133919);
        if (surface != null) {
            this.zrS.setSurface(surface);
        }
        AppMethodBeat.o(133919);
    }

    public final void i(Surface surface) {
        AppMethodBeat.i(133920);
        if (surface != null) {
            k kVar = this.zrS;
            Log.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", kVar.info(), Integer.valueOf(surface.hashCode()));
            l lVar = kVar.zsb;
            Log.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", lVar.info());
            lVar.surface = surface;
            if (com.tencent.mm.compatible.util.d.oD(23)) {
                lVar.ejp();
                AppMethodBeat.o(133920);
                return;
            }
            lVar.ejq();
        }
        AppMethodBeat.o(133920);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final boolean prepare() {
        AppMethodBeat.i(133921);
        this.zrS.prepare();
        AppMethodBeat.o(133921);
        return true;
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void start() {
        AppMethodBeat.i(133922);
        if (Log.getLogLevel() > 0) {
            Log.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", info(), Integer.valueOf(this.zrS.state), Util.getStack());
        }
        if (e.Qy(this.zrS.state) || e.Qw(this.zrS.state)) {
            Log.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", info());
            AppMethodBeat.o(133922);
            return;
        }
        this.zrS.start();
        AppMethodBeat.o(133922);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void pause() {
        AppMethodBeat.i(133923);
        if (Log.getLogLevel() > 0) {
            Log.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", info(), Integer.valueOf(this.zrS.state), Util.getStack());
        }
        if (e.Qy(this.zrS.state) || e.Qw(this.zrS.state)) {
            Log.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", info());
            AppMethodBeat.o(133923);
            return;
        }
        this.zrS.pause();
        AppMethodBeat.o(133923);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void seek(int i2) {
        AppMethodBeat.i(133924);
        this.zrS.seek(i2);
        AppMethodBeat.o(133924);
    }

    public final void QC(int i2) {
        AppMethodBeat.i(133925);
        this.zrS.QC(i2);
        AppMethodBeat.o(133925);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(133926);
        try {
            if (this.zrS != null) {
                k kVar = this.zrS;
                if (kVar.zsd != null) {
                    Log.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", kVar.info(), Boolean.valueOf(z));
                    kVar.zsd.setMute(z);
                }
            }
            AppMethodBeat.o(133926);
        } catch (Exception e2) {
            AppMethodBeat.o(133926);
        }
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void stop() {
        AppMethodBeat.i(133927);
        this.zrS.stop();
        AppMethodBeat.o(133927);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void release() {
        AppMethodBeat.i(133928);
        try {
            this.zrS.release();
            AppMethodBeat.o(133928);
        } catch (Exception e2) {
            AppMethodBeat.o(133928);
        }
    }

    @Override // com.tencent.mm.plugin.n.c
    public final long getDurationMs() {
        return this.zrS.durationMs;
    }

    public final int ejm() {
        int i2;
        AppMethodBeat.i(133929);
        if (this.zrS != null) {
            k kVar = this.zrS;
            if (kVar.zrC != null) {
                i2 = (int) (kVar.zrC.zrt / 1000);
                int i3 = (int) kVar.zrC.zrs;
                if (i3 != -1) {
                    i2 = Math.max(i2, i3);
                }
                if (((long) i2) < kVar.zrC.zru / 1000) {
                    i2 = (int) (kVar.zrC.zru / 1000);
                }
                if (i2 != kVar.zse) {
                    Log.i("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", kVar.info(), Integer.valueOf(i2), Long.valueOf(kVar.zrC.zrt), Long.valueOf(kVar.zrC.zru));
                }
                kVar.zse = i2;
            } else {
                i2 = 0;
            }
            AppMethodBeat.o(133929);
            return i2;
        }
        AppMethodBeat.o(133929);
        return 0;
    }

    public final void setPlayRate(float f2) {
        if (this.zrS != null) {
            k kVar = this.zrS;
            if (kVar.zsb != null) {
                l lVar = kVar.zsb;
                if (f2 > 0.0f) {
                    lVar.mwH = f2;
                }
            }
        }
    }

    public final float getPlayRate() {
        if (this.zrS == null) {
            return 1.0f;
        }
        k kVar = this.zrS;
        if (kVar.zsb != null) {
            return kVar.zsb.mwH;
        }
        return 1.0f;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(133930);
        if (this.zrS != null) {
            boolean Qu = e.Qu(this.zrS.state);
            AppMethodBeat.o(133930);
            return Qu;
        }
        AppMethodBeat.o(133930);
        return false;
    }

    public final String info() {
        AppMethodBeat.i(133931);
        if (this.zrS != null) {
            String info = this.zrS.info();
            AppMethodBeat.o(133931);
            return info;
        }
        AppMethodBeat.o(133931);
        return "has no player!";
    }
}
