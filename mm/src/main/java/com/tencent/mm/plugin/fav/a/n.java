package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k;
import com.tencent.mm.ak.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class n implements k.a, k.b, SensorController.SensorEventCallBack {
    static SensorController qUq;
    private List<a> callbacks = new LinkedList();
    private int dLt;
    private long lastShakeTime = -1;
    public String path;
    public k qUl = ((l) g.af(l.class)).Xa();
    private boolean qUm = true;
    private boolean qUn;
    private boolean qUo = false;
    ShakeManager qUp;
    boolean tbh;
    private int tbi;

    public interface a {
        void dt(String str, int i2);

        void onFinish();

        void onPause();
    }

    public n() {
        AppMethodBeat.i(103442);
        Boolean bool = (Boolean) g.aAh().azQ().get(26, Boolean.FALSE);
        this.qUn = bool.booleanValue();
        this.qUm = !bool.booleanValue();
        if (this.qUl != null) {
            this.qUl.a((k.a) this);
            this.qUl.a((k.b) this);
            this.qUl.cU(this.qUm);
        } else {
            Log.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
        }
        if (qUq == null) {
            qUq = new SensorController(MMApplicationContext.getContext());
        }
        if (this.qUp == null) {
            this.qUp = new ShakeManager(MMApplicationContext.getContext());
        }
        AppMethodBeat.o(103442);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(103443);
        for (a aVar2 : this.callbacks) {
            if (aVar == aVar2) {
                AppMethodBeat.o(103443);
                return;
            }
        }
        this.callbacks.add(aVar);
        AppMethodBeat.o(103443);
    }

    public final void destroy() {
        AppMethodBeat.i(103444);
        pause();
        cEE();
        qUq = null;
        this.callbacks.clear();
        AppMethodBeat.o(103444);
    }

    public final void pause() {
        AppMethodBeat.i(103445);
        if (this.qUl == null) {
            Log.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
            AppMethodBeat.o(103445);
            return;
        }
        if (this.qUl.isPlaying()) {
            cUJ();
        }
        for (a aVar : this.callbacks) {
            aVar.onPause();
        }
        AppMethodBeat.o(103445);
    }

    public final boolean cZ(String str, int i2) {
        AppMethodBeat.i(103446);
        if (this.qUl == null) {
            Log.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i2));
            AppMethodBeat.o(103446);
            return false;
        }
        this.qUl.stop();
        for (a aVar : this.callbacks) {
            aVar.dt(str, 0);
        }
        if (qUq != null && !qUq.hasRegistered()) {
            qUq.setSensorCallBack(this);
            if (this.qUp.startShake(new Runnable() {
                /* class com.tencent.mm.plugin.fav.a.n.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(103440);
                    n.this.lastShakeTime = Util.currentTicks();
                    AppMethodBeat.o(103440);
                }
            })) {
                this.lastShakeTime = 0;
            } else {
                this.lastShakeTime = -1;
            }
        }
        this.path = str;
        this.dLt = i2;
        if (Util.isNullOrNil(str) || !this.qUl.a(str, this.qUm, true, i2)) {
            AppMethodBeat.o(103446);
            return false;
        }
        MMEntryLock.lock("keep_app_silent");
        AppMethodBeat.o(103446);
        return true;
    }

    public final boolean ab(String str, int i2, int i3) {
        AppMethodBeat.i(103447);
        if (this.qUl == null) {
            Log.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i2));
            AppMethodBeat.o(103447);
            return false;
        }
        this.qUl.stop();
        for (a aVar : this.callbacks) {
            aVar.dt(str, i3);
        }
        if (qUq != null && !qUq.hasRegistered()) {
            qUq.setSensorCallBack(this);
            if (this.qUp.startShake(new Runnable() {
                /* class com.tencent.mm.plugin.fav.a.n.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(103441);
                    n.this.lastShakeTime = Util.currentTicks();
                    AppMethodBeat.o(103441);
                }
            })) {
                this.lastShakeTime = 0;
            } else {
                this.lastShakeTime = -1;
            }
        }
        this.path = str;
        this.dLt = i2;
        if (Util.isNullOrNil(str) || !this.qUl.a(str, this.qUm, i2, i3)) {
            AppMethodBeat.o(103447);
            return false;
        }
        MMEntryLock.lock("keep_app_silent");
        com.tencent.mm.plugin.audio.c.a.cea().cV(this.qUm);
        AppMethodBeat.o(103447);
        return true;
    }

    public final boolean cEF() {
        AppMethodBeat.i(103448);
        if (this.qUl == null) {
            Log.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
            AppMethodBeat.o(103448);
            return false;
        }
        boolean isPlaying = this.qUl.isPlaying();
        AppMethodBeat.o(103448);
        return isPlaying;
    }

    public final boolean cUI() {
        AppMethodBeat.i(103449);
        Log.i("MicroMsg.FavVoiceLogic", "resume play");
        MMEntryLock.lock("keep_app_silent");
        if (this.qUl == null) {
            Log.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
            AppMethodBeat.o(103449);
            return false;
        }
        boolean resume = this.qUl.resume();
        AppMethodBeat.o(103449);
        return resume;
    }

    public final boolean cUJ() {
        AppMethodBeat.i(103450);
        Log.i("MicroMsg.FavVoiceLogic", "pause play");
        MMEntryLock.unlock("keep_app_silent");
        if (this.qUl == null) {
            Log.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
            AppMethodBeat.o(103450);
            return false;
        }
        boolean pause = this.qUl.pause();
        AppMethodBeat.o(103450);
        return pause;
    }

    public final void stopPlay() {
        AppMethodBeat.i(103451);
        Log.d("MicroMsg.FavVoiceLogic", "stop play");
        MMEntryLock.unlock("keep_app_silent");
        if (this.qUl != null) {
            this.qUl.stop();
        }
        cEE();
        AppMethodBeat.o(103451);
    }

    @Override // com.tencent.mm.ak.k.b
    public final void onError() {
        AppMethodBeat.i(103452);
        Log.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
        stopPlay();
        for (a aVar : this.callbacks) {
            aVar.onFinish();
        }
        AppMethodBeat.o(103452);
    }

    @Override // com.tencent.mm.ak.k.a
    public final void onCompletion() {
        AppMethodBeat.i(103453);
        Log.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
        stopPlay();
        for (a aVar : this.callbacks) {
            aVar.onFinish();
        }
        AppMethodBeat.o(103453);
    }

    private void cEE() {
        AppMethodBeat.i(103454);
        if (qUq != null) {
            qUq.removeSensorCallBack();
        }
        if (this.qUp != null) {
            this.qUp.stopShake();
        }
        AppMethodBeat.o(103454);
    }

    @Override // com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack
    public final void onSensorEvent(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(103455);
        if (Util.isNullOrNil(this.path)) {
            AppMethodBeat.o(103455);
        } else if (this.qUo) {
            if (z) {
                z2 = false;
            }
            this.qUo = z2;
            AppMethodBeat.o(103455);
        } else if (z || this.lastShakeTime == -1 || Util.ticksToNow(this.lastShakeTime) <= 400) {
            this.qUo = false;
            if (this.qUl != null && this.qUl.isCalling()) {
                AppMethodBeat.o(103455);
            } else if (this.qUn) {
                if (this.qUl != null) {
                    this.qUl.cU(false);
                }
                com.tencent.mm.plugin.audio.c.a.cea().cV(false);
                this.qUm = false;
                AppMethodBeat.o(103455);
            } else if (this.qUl != null && !this.qUl.isPlaying() && !this.tbh) {
                this.qUl.cU(true);
                this.qUm = true;
                AppMethodBeat.o(103455);
            } else if (com.tencent.mm.plugin.audio.c.a.ceb()) {
                Log.d("MicroMsg.FavVoiceLogic", "onSensorEvent, connecting bluetooth, omit sensor event");
                AppMethodBeat.o(103455);
            } else {
                if (this.qUl != null) {
                    this.qUl.cU(z);
                }
                this.qUm = z;
                if (!this.tbh || z) {
                    if (!z) {
                        cZ(this.path, this.dLt);
                    }
                    AppMethodBeat.o(103455);
                    return;
                }
                ab(this.path, this.dLt, this.tbi);
                AppMethodBeat.o(103455);
            }
        } else {
            this.qUo = true;
            AppMethodBeat.o(103455);
        }
    }
}
