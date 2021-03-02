package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.c.d;
import com.tencent.mm.modelvoiceaddr.a;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.c;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.List;

public final class b implements i {
    private static final String jwd = (ar.NSe + "voice_temp.silk");
    private h GtC;
    private int GtE;
    public boolean GtF = false;
    public boolean GtG = false;
    private g.b jwA;
    public a jwn = null;

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(185264);
        bVar.n(false, true);
        AppMethodBeat.o(185264);
    }

    static {
        AppMethodBeat.i(102631);
        AppMethodBeat.o(102631);
    }

    public b(h hVar, int i2, g.b bVar) {
        this.GtC = hVar;
        this.GtE = i2;
        this.jwA = bVar;
    }

    public final void start() {
        int i2;
        AppMethodBeat.i(102627);
        Log.i("MicroMsg.SceneVoiceInputAddr2", "start trans, time: %s.", Long.valueOf(System.currentTimeMillis()));
        c Fu = d.aXu().Fu("100235");
        if (Fu.isValid()) {
            i2 = Util.getInt(Fu.gzz().get("MMVoipVadOn"), 0);
        } else {
            i2 = 0;
        }
        this.jwn = new com.tencent.mm.modelvoiceaddr.c(jwd, this.GtC, String.valueOf(i2), this.GtE);
        com.tencent.mm.kernel.g.azz().a(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, this);
        if (!((com.tencent.mm.modelvoiceaddr.c) this.jwn).bir() || !com.tencent.mm.kernel.g.azz().a(this.jwn, 0)) {
            fAt();
        }
        AppMethodBeat.o(102627);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(102628);
        String[] bin = ((a) qVar).bin();
        List<String> biq = ((a) qVar).biq();
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(bin == null ? -1 : bin.length);
        objArr[4] = Integer.valueOf(qVar.hashCode());
        objArr[5] = Integer.valueOf(this.jwn == null ? -1 : this.jwn.hashCode());
        Log.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd time: %s errType: %s errCode: %s list: %s scene.hashCode(): %s this.hashCode(): %s.", objArr);
        if (this.jwn == null || qVar.hashCode() != this.jwn.hashCode()) {
            Log.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
            AppMethodBeat.o(102628);
            return;
        }
        if (this.jwA != null) {
            if (i3 == 0 && i2 == 0) {
                this.jwA.b(bin, biq);
                if ((qVar instanceof com.tencent.mm.modelvoiceaddr.c) && ((com.tencent.mm.modelvoiceaddr.c) qVar).jvN.biB()) {
                    this.jwA.biz();
                    az(this.GtF, false);
                }
            } else {
                if (str != null && str.equalsIgnoreCase("SecurityCheckError")) {
                    this.jwA.c(13, 132, -1, -1);
                } else if (str == null || !str.equalsIgnoreCase("ReadFileLengthError")) {
                    this.jwA.c(11, i2, i3, (long) ((a) qVar).bip());
                } else {
                    this.jwA.c(13, 133, -1, -1);
                }
                az(false, false);
                AppMethodBeat.o(102628);
                return;
            }
        }
        AppMethodBeat.o(102628);
    }

    public final void fAt() {
        AppMethodBeat.i(185261);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.transvoice.a.b.AnonymousClass1 */
            final /* synthetic */ int GtH = 13;
            final /* synthetic */ int val$errCode = -1;
            final /* synthetic */ int val$errType = TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE;

            public final void run() {
                AppMethodBeat.i(185260);
                Log.i("MicroMsg.SceneVoiceInputAddr2", "error localCode = %s, errType = %s, errCode = %s.", Integer.valueOf(this.GtH), Integer.valueOf(this.val$errType), Integer.valueOf(this.val$errCode));
                if (b.this.jwA != null) {
                    b.this.jwA.c(this.GtH, this.val$errType, this.val$errCode, -1);
                }
                b.b(b.this);
                AppMethodBeat.o(185260);
            }
        });
        AppMethodBeat.o(185261);
    }

    public final void cancel(boolean z) {
        AppMethodBeat.i(102629);
        az(false, z);
        AppMethodBeat.o(102629);
    }

    public final void az(boolean z, boolean z2) {
        AppMethodBeat.i(185262);
        Log.i("MicroMsg.SceneVoiceInputAddr2", "continuable: %s, cancel fromUI = %s.", Boolean.valueOf(z), Boolean.valueOf(z2));
        n(z, z2);
        AppMethodBeat.o(185262);
    }

    private void n(boolean z, boolean z2) {
        AppMethodBeat.i(185263);
        Log.i("MicroMsg.SceneVoiceInputAddr2", "reset continuable = %s, sendLastScene = %s.", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z) {
            this.GtG = true;
            AppMethodBeat.o(185263);
            return;
        }
        this.GtG = false;
        if (this.jwn instanceof com.tencent.mm.modelvoiceaddr.c) {
            this.jwn.bim();
        }
        if (this.jwn instanceof com.tencent.mm.modelvoiceaddr.c) {
            Log.i("MicroMsg.SceneVoiceInputAddr2", "reset call stop, sendLastScene: %s.", Boolean.valueOf(z2));
            if (z2) {
                ((com.tencent.mm.modelvoiceaddr.c) this.jwn).bis();
            }
            com.tencent.mm.kernel.g.azz().b(TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, this);
        }
        this.jwn = null;
        this.jwA = null;
        AppMethodBeat.o(185263);
    }
}
