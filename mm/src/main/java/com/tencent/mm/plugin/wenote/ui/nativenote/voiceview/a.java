package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

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

public class a implements k.a, k.b, SensorController.SensorEventCallBack {
    private static volatile a JLm = null;
    List<AbstractC2008a> callbacks = new LinkedList();
    private int dLt;
    private long lastShakeTime = -1;
    public String path;
    public k qUl = ((l) g.af(l.class)).Xa();
    private boolean qUm = true;
    private boolean qUn;
    private boolean qUo = false;
    private ShakeManager qUp;
    private SensorController qUq;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a$a  reason: collision with other inner class name */
    public interface AbstractC2008a {
        void alV(String str);

        void cEB();
    }

    private a() {
        AppMethodBeat.i(30900);
        bg.aVF();
        Boolean bool = (Boolean) c.azQ().get(26, Boolean.FALSE);
        this.qUn = bool.booleanValue();
        this.qUm = !bool.booleanValue();
        if (this.qUl != null) {
            this.qUl.a((k.a) this);
            this.qUl.a((k.b) this);
            this.qUl.cU(this.qUm);
        } else {
            Log.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
        }
        if (this.qUq == null) {
            this.qUq = new SensorController(MMApplicationContext.getContext());
        }
        if (this.qUp == null) {
            this.qUp = new ShakeManager(MMApplicationContext.getContext());
        }
        AppMethodBeat.o(30900);
    }

    public static a gkl() {
        AppMethodBeat.i(30901);
        if (JLm == null) {
            synchronized (a.class) {
                try {
                    if (JLm == null) {
                        JLm = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(30901);
                    throw th;
                }
            }
        }
        a aVar = JLm;
        AppMethodBeat.o(30901);
        return aVar;
    }

    public final void destroy() {
        AppMethodBeat.i(179754);
        stopPlay();
        this.qUq = null;
        this.qUp = null;
        this.callbacks.clear();
        AppMethodBeat.o(179754);
    }

    public final void a(AbstractC2008a aVar) {
        AppMethodBeat.i(30902);
        if (aVar == null) {
            AppMethodBeat.o(30902);
            return;
        }
        for (AbstractC2008a aVar2 : this.callbacks) {
            if (aVar == aVar2) {
                AppMethodBeat.o(30902);
                return;
            }
        }
        this.callbacks.add(aVar);
        AppMethodBeat.o(30902);
    }

    private void cED() {
        AppMethodBeat.i(30903);
        if (this.qUq != null && !this.qUq.hasRegistered()) {
            this.qUq.setSensorCallBack(this);
            if (this.qUp.startShake(new Runnable() {
                /* class com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(30899);
                    a.this.lastShakeTime = Util.currentTicks();
                    AppMethodBeat.o(30899);
                }
            })) {
                this.lastShakeTime = 0;
                AppMethodBeat.o(30903);
                return;
            }
            this.lastShakeTime = -1;
        }
        AppMethodBeat.o(30903);
    }

    private void cEE() {
        AppMethodBeat.i(30904);
        if (this.qUq != null) {
            this.qUq.removeSensorCallBack();
        }
        if (this.qUp != null) {
            this.qUp.stopShake();
        }
        AppMethodBeat.o(30904);
    }

    public final boolean cZ(String str, int i2) {
        AppMethodBeat.i(30905);
        if (this.qUl == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i2));
            AppMethodBeat.o(30905);
            return false;
        }
        this.qUl.stop();
        cED();
        this.path = str;
        this.dLt = i2;
        if (Util.isNullOrNil(str) || !this.qUl.a(str, this.qUm, true, i2)) {
            AppMethodBeat.o(30905);
            return false;
        }
        MMEntryLock.lock("keep_app_silent");
        for (AbstractC2008a aVar : this.callbacks) {
            if (aVar != null) {
                aVar.alV(str);
            }
        }
        AppMethodBeat.o(30905);
        return true;
    }

    public final void stopPlay() {
        AppMethodBeat.i(30906);
        Log.i("MicroMsg.RecordVoiceHelper", "stop play");
        MMEntryLock.unlock("keep_app_silent");
        if (this.qUl != null) {
            this.qUl.stop();
            for (AbstractC2008a aVar : this.callbacks) {
                if (aVar != null) {
                    aVar.cEB();
                }
            }
        }
        cEE();
        AppMethodBeat.o(30906);
    }

    public final boolean cEF() {
        AppMethodBeat.i(30907);
        if (this.qUl == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
            AppMethodBeat.o(30907);
            return false;
        }
        boolean isPlaying = this.qUl.isPlaying();
        AppMethodBeat.o(30907);
        return isPlaying;
    }

    public final double ZY() {
        AppMethodBeat.i(30908);
        if (this.qUl == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
            AppMethodBeat.o(30908);
            return 0.0d;
        }
        double ZY = this.qUl.ZY();
        AppMethodBeat.o(30908);
        return ZY;
    }

    @Override // com.tencent.mm.ak.k.b
    public final void onError() {
        AppMethodBeat.i(30909);
        Log.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        stopPlay();
        AppMethodBeat.o(30909);
    }

    @Override // com.tencent.mm.ak.k.a
    public final void onCompletion() {
        AppMethodBeat.i(30910);
        Log.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        stopPlay();
        AppMethodBeat.o(30910);
    }

    @Override // com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack
    public void onSensorEvent(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(30911);
        if (Util.isNullOrNil(this.path)) {
            AppMethodBeat.o(30911);
        } else if (this.qUo) {
            if (z) {
                z2 = false;
            }
            this.qUo = z2;
            AppMethodBeat.o(30911);
        } else if (z || this.lastShakeTime == -1 || Util.ticksToNow(this.lastShakeTime) <= 400) {
            this.qUo = false;
            if (this.qUl != null && this.qUl.isCalling()) {
                AppMethodBeat.o(30911);
            } else if (this.qUn) {
                if (this.qUl != null) {
                    this.qUl.cU(false);
                }
                this.qUm = false;
                AppMethodBeat.o(30911);
            } else if (this.qUl == null || this.qUl.isPlaying()) {
                if (this.qUl != null) {
                    this.qUl.cU(z);
                }
                this.qUm = z;
                if (!z) {
                    cZ(this.path, this.dLt);
                }
                AppMethodBeat.o(30911);
            } else {
                this.qUl.cU(true);
                this.qUm = true;
                AppMethodBeat.o(30911);
            }
        } else {
            this.qUo = true;
            AppMethodBeat.o(30911);
        }
    }
}
