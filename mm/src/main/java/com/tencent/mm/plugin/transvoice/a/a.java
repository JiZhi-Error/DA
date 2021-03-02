package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.modelvoiceaddr.a.c;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class a {
    private static final String jwd = (ar.NSe + "voice_temp.silk");
    private final int GtA = 16000;
    private IListener GtB;
    private h GtC;
    private c jwB;
    private c.a jwC = new c.a() {
        /* class com.tencent.mm.plugin.transvoice.a.a.AnonymousClass2 */
        byte[] jwF;

        @Override // com.tencent.mm.modelvoiceaddr.a.c.a
        public final void b(short[] sArr, int i2) {
            AppMethodBeat.i(102620);
            if (sArr == null) {
                AppMethodBeat.o(102620);
                return;
            }
            if (this.jwF == null || this.jwF.length < i2 * 2) {
                this.jwF = new byte[(i2 * 2)];
            }
            for (int i3 = 0; i3 < i2; i3++) {
                this.jwF[i3 * 2] = (byte) (sArr[i3] & 255);
                this.jwF[(i3 * 2) + 1] = (byte) ((sArr[i3] & 65280) >> 8);
            }
            if (-1 == (a.this.jwl != null ? a.this.jwl.a(new g.a(this.jwF, i2 * 2), 0, true) : -1)) {
                a.error(2);
                Log.e("MicroMsg.CutShortSentence", "write to file failed");
            }
            AppMethodBeat.o(102620);
        }

        @Override // com.tencent.mm.modelvoiceaddr.a.c.a
        public final void biy() {
            AppMethodBeat.i(102621);
            Log.i("MicroMsg.CutShortSentence", "onSilentToSpeak.");
            if (a.this.GtC != null) {
                Log.i("MicroMsg.CutShortSentence", "onSilentToSpeak, createNewShortSentence.");
                a.this.GtC.biC();
            }
            if (a.this.jwl != null && !a.this.jwl.abQ()) {
                a.error(1);
            }
            AppMethodBeat.o(102621);
        }

        @Override // com.tencent.mm.modelvoiceaddr.a.c.a
        public final void bix() {
            AppMethodBeat.i(102622);
            int boW = (int) s.boW(a.jwd);
            Log.i("MicroMsg.CutShortSentence", "onSpeakToSilent nowLen: %d.", Integer.valueOf(boW));
            if (boW > 0 && a.this.GtC != null) {
                Log.i("MicroMsg.CutShortSentence", "onSpeakToSilent, cutShortSentence.");
                a.this.GtC.ul(boW);
            }
            AppMethodBeat.o(102622);
        }

        @Override // com.tencent.mm.modelvoiceaddr.a.c.a
        public final void Yh() {
            AppMethodBeat.i(102623);
            Log.i("MicroMsg.CutShortSentence", "Silent enough to finish time %s.", Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(102623);
        }
    };
    private com.tencent.mm.audio.e.a jwl;

    static {
        AppMethodBeat.i(102626);
        AppMethodBeat.o(102626);
    }

    public a() {
        AppMethodBeat.i(185257);
        Log.d("MicroMsg.CutShortSentence", "new CutShortSentence, %s.", this);
        this.GtB = new IListener<tq>() {
            /* class com.tencent.mm.plugin.transvoice.a.a.AnonymousClass1 */
            short[] jwD;

            {
                AppMethodBeat.i(160477);
                this.__eventId = tq.class.getName().hashCode();
                AppMethodBeat.o(160477);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(tq tqVar) {
                AppMethodBeat.i(102619);
                boolean a2 = a(tqVar);
                AppMethodBeat.o(102619);
                return a2;
            }

            private boolean a(tq tqVar) {
                AppMethodBeat.i(102618);
                synchronized (a.this) {
                    try {
                        Log.d("MicroMsg.CutShortSentence", "receive SceneVoiceRcdDataEvent.");
                        byte[] bArr = tqVar.ead.buf;
                        int i2 = tqVar.ead.len;
                        Log.i("MicroMsg.CutShortSentence", "rec data, len: %s time: %s.", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
                        if (this.jwD == null || this.jwD.length < i2 / 2) {
                            this.jwD = new short[(i2 / 2)];
                        }
                        for (int i3 = 0; i3 < i2 / 2; i3++) {
                            this.jwD[i3] = (short) ((bArr[i3 * 2] & 255) | (bArr[(i3 * 2) + 1] << 8));
                        }
                        if (a.this.jwB != null) {
                            a.this.jwB.e(this.jwD, i2 / 2);
                        } else {
                            a.error(4);
                            Log.e("MicroMsg.CutShortSentence", "mVoiceSilentDetectAPI is null");
                        }
                    } finally {
                        AppMethodBeat.o(102618);
                    }
                }
                return false;
            }
        };
        Log.i("MicroMsg.CutShortSentence", "init cut sentence, time %s.", Long.valueOf(System.currentTimeMillis()));
        try {
            o oVar = new o(jwd);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            o oVar2 = new o(jwd);
            if (!oVar2.exists()) {
                oVar2.createNewFile();
            }
            oVar2.delete();
            AppMethodBeat.o(185257);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CutShortSentence", e2, "delete file failed", new Object[0]);
            AppMethodBeat.o(185257);
        }
    }

    public static void error(int i2) {
        AppMethodBeat.i(102625);
        Log.i("MicroMsg.CutShortSentence", "error localCode = %s.", Integer.valueOf(i2));
        AppMethodBeat.o(102625);
    }

    public final void b(h hVar) {
        AppMethodBeat.i(185258);
        this.GtC = hVar;
        this.jwl = new com.tencent.mm.audio.e.c(16000, 23900);
        if (!this.jwl.hz(jwd)) {
            Log.e("MicroMsg.CutShortSentence", "init speex writer failed");
            this.jwl.abP();
            this.jwl = null;
            error(1);
        }
        try {
            this.jwB = new c(false, false);
            this.jwB.jxj = this.jwC;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.CutShortSentence", th, "init VoiceDetectAPI failed", new Object[0]);
            error(3);
        }
        EventCenter.instance.addListener(this.GtB);
        AppMethodBeat.o(185258);
    }

    public final void fAr() {
        AppMethodBeat.i(185259);
        synchronized (this) {
            try {
                EventCenter.instance.removeListener(this.GtB);
                if (this.jwl != null) {
                    this.jwl.abP();
                    this.jwl = null;
                }
                if (this.jwB != null) {
                    try {
                        this.jwB.release();
                        this.jwB = null;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.CutShortSentence", e2, "mVoiceSilentDetectAPI.release error", new Object[0]);
                    }
                }
                if (this.GtC != null) {
                    this.GtC.ul((int) s.boW(jwd));
                    this.GtC = null;
                }
            } finally {
                AppMethodBeat.o(185259);
            }
        }
    }
}
