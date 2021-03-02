package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k;
import com.tencent.mm.ak.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class u implements k.a, k.b, SensorController.SensorEventCallBack {
    public static SensorController qUq;
    public List<a> callbacks = new LinkedList();
    private int dLt;
    private long lastShakeTime = -1;
    public String path;
    public k qUl = ((l) g.af(l.class)).Xa();
    private boolean qUm = true;
    private boolean qUn;
    private boolean qUo = false;
    private ShakeManager qUp;

    public interface a {
        void aKZ(String str);

        void onFinish();
    }

    public u() {
        AppMethodBeat.i(27818);
        bg.aVF();
        Boolean bool = (Boolean) c.azQ().get(26, Boolean.FALSE);
        this.qUn = bool.booleanValue();
        this.qUm = !bool.booleanValue();
        if (this.qUl != null) {
            this.qUl.a((k.a) this);
            this.qUl.a((k.b) this);
            if (com.tencent.mm.plugin.audio.c.a.cdW() || com.tencent.mm.plugin.audio.c.a.ceb()) {
                this.qUl.cU(false);
            } else {
                this.qUl.cU(this.qUm);
            }
        } else {
            Log.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
        }
        if (qUq == null) {
            qUq = new SensorController(MMApplicationContext.getContext());
        }
        if (this.qUp == null) {
            this.qUp = new ShakeManager(MMApplicationContext.getContext());
        }
        AppMethodBeat.o(27818);
    }

    public final boolean cZ(String str, int i2) {
        AppMethodBeat.i(27819);
        if (this.qUl == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i2));
            AppMethodBeat.o(27819);
            return false;
        }
        this.qUl.stop();
        for (a aVar : this.callbacks) {
            aVar.aKZ(str);
        }
        if (qUq != null && !qUq.hasRegistered()) {
            qUq.setSensorCallBack(this);
            if (this.qUp.startShake(new Runnable() {
                /* class com.tencent.mm.plugin.record.b.u.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(27817);
                    u.this.lastShakeTime = Util.currentTicks();
                    AppMethodBeat.o(27817);
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
            AppMethodBeat.o(27819);
            return false;
        }
        MMEntryLock.lock("keep_app_silent");
        AppMethodBeat.o(27819);
        return true;
    }

    public final boolean cEF() {
        AppMethodBeat.i(27820);
        if (this.qUl == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
            AppMethodBeat.o(27820);
            return false;
        }
        boolean isPlaying = this.qUl.isPlaying();
        AppMethodBeat.o(27820);
        return isPlaying;
    }

    public final void stopPlay() {
        AppMethodBeat.i(27821);
        Log.d("MicroMsg.RecordVoiceHelper", "stop play");
        MMEntryLock.unlock("keep_app_silent");
        if (this.qUl != null) {
            this.qUl.stop();
        }
        cEE();
        AppMethodBeat.o(27821);
    }

    @Override // com.tencent.mm.ak.k.b
    public final void onError() {
        AppMethodBeat.i(27822);
        Log.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        stopPlay();
        for (a aVar : this.callbacks) {
            aVar.onFinish();
        }
        AppMethodBeat.o(27822);
    }

    @Override // com.tencent.mm.ak.k.a
    public final void onCompletion() {
        AppMethodBeat.i(27823);
        Log.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        stopPlay();
        for (a aVar : this.callbacks) {
            aVar.onFinish();
        }
        AppMethodBeat.o(27823);
    }

    public final void cEE() {
        AppMethodBeat.i(27824);
        if (qUq != null) {
            qUq.removeSensorCallBack();
        }
        if (this.qUp != null) {
            this.qUp.stopShake();
        }
        AppMethodBeat.o(27824);
    }

    @Override // com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack
    public final void onSensorEvent(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(27825);
        if (Util.isNullOrNil(this.path)) {
            AppMethodBeat.o(27825);
        } else if (this.qUo) {
            if (z) {
                z2 = false;
            }
            this.qUo = z2;
            AppMethodBeat.o(27825);
        } else if (z || this.lastShakeTime == -1 || Util.ticksToNow(this.lastShakeTime) <= 400) {
            this.qUo = false;
            if (this.qUl != null && this.qUl.isCalling()) {
                AppMethodBeat.o(27825);
            } else if (this.qUn) {
                if (this.qUl != null) {
                    this.qUl.cU(false);
                }
                this.qUm = false;
                AppMethodBeat.o(27825);
            } else if (this.qUl == null || this.qUl.isPlaying()) {
                if (this.qUl != null) {
                    this.qUl.cU(z);
                }
                this.qUm = z;
                if (!z) {
                    cZ(this.path, this.dLt);
                }
                AppMethodBeat.o(27825);
            } else {
                this.qUl.cU(true);
                this.qUm = true;
                AppMethodBeat.o(27825);
            }
        } else {
            this.qUo = true;
            AppMethodBeat.o(27825);
        }
    }
}
