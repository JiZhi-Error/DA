package com.tencent.mm.plugin.editor.widget.voiceview;

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

public class a implements k.a, k.b, SensorController.SensorEventCallBack {
    public static volatile a qUk = null;
    public List<AbstractC0951a> callbacks = new LinkedList();
    private int dLt;
    private long lastShakeTime = -1;
    public String path;
    public k qUl = ((l) g.af(l.class)).Xa();
    private boolean qUm = true;
    private boolean qUn;
    private boolean qUo = false;
    public ShakeManager qUp;
    public SensorController qUq;

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.editor.widget.voiceview.a$a  reason: collision with other inner class name */
    public interface AbstractC0951a {
        void alV(String str);

        void cEB();
    }

    private a() {
        AppMethodBeat.i(182004);
        Boolean bool = (Boolean) g.aAh().azQ().get(26, Boolean.FALSE);
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
        AppMethodBeat.o(182004);
    }

    public static a cEC() {
        AppMethodBeat.i(182005);
        if (qUk == null) {
            synchronized (a.class) {
                try {
                    if (qUk == null) {
                        qUk = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(182005);
                    throw th;
                }
            }
        }
        a aVar = qUk;
        AppMethodBeat.o(182005);
        return aVar;
    }

    private void cED() {
        AppMethodBeat.i(182006);
        if (this.qUq != null && !this.qUq.hasRegistered()) {
            this.qUq.setSensorCallBack(this);
            if (this.qUp.startShake(new Runnable() {
                /* class com.tencent.mm.plugin.editor.widget.voiceview.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(182003);
                    a.this.lastShakeTime = Util.currentTicks();
                    AppMethodBeat.o(182003);
                }
            })) {
                this.lastShakeTime = 0;
                AppMethodBeat.o(182006);
                return;
            }
            this.lastShakeTime = -1;
        }
        AppMethodBeat.o(182006);
    }

    private void cEE() {
        AppMethodBeat.i(182007);
        if (this.qUq != null) {
            this.qUq.removeSensorCallBack();
        }
        if (this.qUp != null) {
            this.qUp.stopShake();
        }
        AppMethodBeat.o(182007);
    }

    public final boolean cZ(String str, int i2) {
        AppMethodBeat.i(182008);
        if (this.qUl == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i2));
            AppMethodBeat.o(182008);
            return false;
        }
        this.qUl.stop();
        cED();
        this.path = str;
        this.dLt = i2;
        if (Util.isNullOrNil(str) || !this.qUl.a(str, this.qUm, true, i2)) {
            AppMethodBeat.o(182008);
            return false;
        }
        MMEntryLock.lock("keep_app_silent");
        for (AbstractC0951a aVar : this.callbacks) {
            if (aVar != null) {
                aVar.alV(str);
            }
        }
        AppMethodBeat.o(182008);
        return true;
    }

    public final void stopPlay() {
        AppMethodBeat.i(182009);
        Log.i("MicroMsg.RecordVoiceHelper", "stop play");
        MMEntryLock.unlock("keep_app_silent");
        if (this.qUl != null) {
            this.qUl.stop();
            for (AbstractC0951a aVar : this.callbacks) {
                if (aVar != null) {
                    aVar.cEB();
                }
            }
        }
        cEE();
        AppMethodBeat.o(182009);
    }

    public final boolean cEF() {
        AppMethodBeat.i(182010);
        if (this.qUl == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
            AppMethodBeat.o(182010);
            return false;
        }
        boolean isPlaying = this.qUl.isPlaying();
        AppMethodBeat.o(182010);
        return isPlaying;
    }

    public final double ZY() {
        AppMethodBeat.i(182011);
        if (this.qUl == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
            AppMethodBeat.o(182011);
            return 0.0d;
        }
        double ZY = this.qUl.ZY();
        AppMethodBeat.o(182011);
        return ZY;
    }

    @Override // com.tencent.mm.ak.k.b
    public final void onError() {
        AppMethodBeat.i(182012);
        Log.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        stopPlay();
        AppMethodBeat.o(182012);
    }

    @Override // com.tencent.mm.ak.k.a
    public final void onCompletion() {
        AppMethodBeat.i(182013);
        Log.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        stopPlay();
        AppMethodBeat.o(182013);
    }

    @Override // com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack
    public void onSensorEvent(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(182014);
        if (Util.isNullOrNil(this.path)) {
            AppMethodBeat.o(182014);
        } else if (this.qUo) {
            if (z) {
                z2 = false;
            }
            this.qUo = z2;
            AppMethodBeat.o(182014);
        } else if (z || this.lastShakeTime == -1 || Util.ticksToNow(this.lastShakeTime) <= 400) {
            this.qUo = false;
            if (this.qUl != null && this.qUl.isCalling()) {
                AppMethodBeat.o(182014);
            } else if (this.qUn) {
                if (this.qUl != null) {
                    this.qUl.cU(false);
                }
                this.qUm = false;
                AppMethodBeat.o(182014);
            } else if (this.qUl == null || this.qUl.isPlaying()) {
                if (this.qUl != null) {
                    this.qUl.cU(z);
                }
                this.qUm = z;
                if (!z) {
                    cZ(this.path, this.dLt);
                }
                AppMethodBeat.o(182014);
            } else {
                this.qUl.cU(true);
                this.qUm = true;
                AppMethodBeat.o(182014);
            }
        } else {
            this.qUo = true;
            AppMethodBeat.o(182014);
        }
    }
}
