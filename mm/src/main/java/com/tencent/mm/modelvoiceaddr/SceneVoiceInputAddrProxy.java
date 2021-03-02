package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;

public class SceneVoiceInputAddrProxy extends a implements b {
    private static SceneVoiceInputAddrProxy jwH;
    private d gVN;
    private b jwI;
    private g.b jwJ;

    public static void create(d dVar) {
        AppMethodBeat.i(148569);
        jwH = new SceneVoiceInputAddrProxy(dVar);
        AppMethodBeat.o(148569);
    }

    public static SceneVoiceInputAddrProxy getInstance() {
        AppMethodBeat.i(148570);
        if (jwH == null) {
            create(new d(MMApplicationContext.getContext()));
        }
        SceneVoiceInputAddrProxy sceneVoiceInputAddrProxy = jwH;
        AppMethodBeat.o(148570);
        return sceneVoiceInputAddrProxy;
    }

    public SceneVoiceInputAddrProxy(d dVar) {
        super(dVar);
        AppMethodBeat.i(148571);
        if (dVar == null) {
            AppMethodBeat.o(148571);
            return;
        }
        this.gVN = dVar;
        dVar.connect(new Runnable() {
            /* class com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(148564);
                Log.i("SceneVoiceInputAddrProxy", "remote service connected");
                AppMethodBeat.o(148564);
            }
        });
        AppMethodBeat.o(148571);
    }

    public boolean isConnected() {
        AppMethodBeat.i(148572);
        if (this.gVN == null) {
            AppMethodBeat.o(148572);
            return false;
        }
        boolean isConnected = this.gVN.isConnected();
        AppMethodBeat.o(148572);
        return isConnected;
    }

    public void connect(Runnable runnable) {
        AppMethodBeat.i(148573);
        if (this.gVN == null) {
            AppMethodBeat.o(148573);
            return;
        }
        this.gVN.connect(runnable);
        AppMethodBeat.o(148573);
    }

    @Override // com.tencent.mm.modelvoiceaddr.b
    @e
    public void cancel(boolean z) {
        AppMethodBeat.i(148574);
        REMOTE_CALL("cancelMM", Boolean.valueOf(z));
        AppMethodBeat.o(148574);
    }

    @f
    public void cancelMM(boolean z) {
        AppMethodBeat.i(148575);
        if (getInstance().jwI != null) {
            getInstance().jwI.cancel(z);
        }
        AppMethodBeat.o(148575);
    }

    @Override // com.tencent.mm.modelvoiceaddr.b
    @e
    public void stop(boolean z) {
        AppMethodBeat.i(148576);
        REMOTE_CALL("stopMM", Boolean.valueOf(z));
        AppMethodBeat.o(148576);
    }

    @f
    public void stopMM(boolean z) {
        AppMethodBeat.i(148577);
        if (getInstance().jwI != null) {
            getInstance().jwI.stop(z);
        }
        AppMethodBeat.o(148577);
    }

    @Override // com.tencent.mm.modelvoiceaddr.b
    @e
    public void start() {
        AppMethodBeat.i(148578);
        REMOTE_CALL("startMM", new Object[0]);
        AppMethodBeat.o(148578);
    }

    @f
    public void startMM() {
        AppMethodBeat.i(148579);
        if (getInstance().jwI != null) {
            getInstance().jwI.start();
        }
        AppMethodBeat.o(148579);
    }

    @Override // com.tencent.mm.modelvoiceaddr.b
    @e
    public int getMaxAmplitudeRate() {
        AppMethodBeat.i(148580);
        Integer num = (Integer) REMOTE_CALL("getMaxAmplitudeRateMM", new Object[0]);
        if (num == null) {
            AppMethodBeat.o(148580);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(148580);
        return intValue;
    }

    @Override // com.tencent.mm.modelvoiceaddr.b
    public void init(int i2, int i3, g.b bVar) {
        AppMethodBeat.i(148581);
        getInstance().jwJ = bVar;
        REMOTE_CALL("initMM", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(148581);
    }

    @f
    public void initMM(int i2, int i3) {
        AppMethodBeat.i(148582);
        getInstance().jwI = new g(i2, i3, new g.b() {
            /* class com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy.AnonymousClass2 */

            @Override // com.tencent.mm.modelvoiceaddr.g.b
            public final void b(String[] strArr, List<String> list) {
                AppMethodBeat.i(148565);
                SceneVoiceInputAddrProxy.this.CLIENT_CALL("onResCli", strArr, list);
                AppMethodBeat.o(148565);
            }

            @Override // com.tencent.mm.modelvoiceaddr.g.b
            public final void c(int i2, int i3, int i4, long j2) {
                AppMethodBeat.i(148566);
                SceneVoiceInputAddrProxy.this.CLIENT_CALL("onErrorCli", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2));
                AppMethodBeat.o(148566);
            }

            @Override // com.tencent.mm.modelvoiceaddr.g.b
            public final void biv() {
                AppMethodBeat.i(148567);
                SceneVoiceInputAddrProxy.this.CLIENT_CALL("onRecordFinCli", new Object[0]);
                AppMethodBeat.o(148567);
            }

            @Override // com.tencent.mm.modelvoiceaddr.g.b
            public final void biz() {
                AppMethodBeat.i(148568);
                SceneVoiceInputAddrProxy.this.CLIENT_CALL("onRecognizeFinishCli", new Object[0]);
                AppMethodBeat.o(148568);
            }
        });
        AppMethodBeat.o(148582);
    }

    @f
    public int getMaxAmplitudeRateMM() {
        AppMethodBeat.i(148583);
        if (getInstance().jwI != null) {
            int maxAmplitudeRate = getInstance().jwI.getMaxAmplitudeRate();
            AppMethodBeat.o(148583);
            return maxAmplitudeRate;
        }
        AppMethodBeat.o(148583);
        return 0;
    }

    @e
    public void onResCli(String[] strArr, List<String> list) {
        AppMethodBeat.i(148584);
        if (getInstance().jwJ != null) {
            getInstance().jwJ.b(strArr, list);
        }
        AppMethodBeat.o(148584);
    }

    @e
    public void onErrorCli(int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(148585);
        if (getInstance().jwJ != null) {
            getInstance().jwJ.c(i2, i3, i4, j2);
        }
        AppMethodBeat.o(148585);
    }

    @e
    public void onRecordFinCli() {
        AppMethodBeat.i(148586);
        if (getInstance().jwJ != null) {
            getInstance().jwJ.biv();
        }
        AppMethodBeat.o(148586);
    }

    @e
    public void onRecognizeFinishCli() {
        AppMethodBeat.i(148587);
        if (getInstance().jwJ != null) {
            getInstance().jwJ.biz();
        }
        AppMethodBeat.o(148587);
    }
}
