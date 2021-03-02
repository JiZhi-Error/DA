package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.qqpinyin.voicerecoapi.c;
import com.tencent.ugc.TXRecordCommon;

public final class f implements i {
    public static int dAR = 100;
    private static final String jwd = (ar.NSe + "tmp_voiceaddr.spx");
    private static final String jwe = (ar.NSe + "tmp_voiceaddr.amr");
    c dyI;
    private c.a dzv = new c.a() {
        /* class com.tencent.mm.modelvoiceaddr.f.AnonymousClass1 */

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            AppMethodBeat.i(148535);
            Log.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", Integer.valueOf(i2));
            c.a aVar = new c.a();
            short[] sArr = new short[(i2 / 2)];
            for (int i3 = 0; i3 < i2 / 2; i3++) {
                sArr[i3] = (short) ((bArr[i3 * 2] & 255) | (bArr[(i3 * 2) + 1] << 8));
            }
            if (f.this.jwm != null) {
                f.this.jwm.a(sArr, i2 / 2, aVar);
            }
            f.a(f.this, sArr, i2 / 2);
            int a2 = f.this.jwl != null ? f.this.jwl.a(new g.a(bArr, i2)) : -1;
            if (-1 == a2) {
                f.a(f.this);
                Log.e("MicroMsg.SceneVoiceAddr", "write to file failed");
                AppMethodBeat.o(148535);
                return;
            }
            f fVar = f.this;
            fVar.jwg = a2 + fVar.jwg;
            if (f.this.jwg > 3300 && !f.this.jwh) {
                Log.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
                f.this.handler.sendEmptyMessage(0);
                f.this.jwh = true;
            }
            if (aVar.RKK == 2 || aVar.RKK == 3) {
                Log.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + aVar.RKK);
                f.a(f.this);
            }
            AppMethodBeat.o(148535);
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
        }
    };
    MMHandler handler = new MMHandler() {
        /* class com.tencent.mm.modelvoiceaddr.f.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(148536);
            if (message.what == 2) {
                if (f.this.jwk != null) {
                    f.this.jwk.biv();
                    AppMethodBeat.o(148536);
                    return;
                }
            } else if (message.what == 0) {
                if (f.this.jvZ == 0) {
                    Log.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
                    com.tencent.mm.kernel.g.azz().a(349, f.this);
                } else {
                    com.tencent.mm.kernel.g.azz().a(206, f.this);
                }
                if (f.this.jvZ != 0) {
                    f.this.jwn = new d(f.d(f.this), f.this.jvZ);
                } else if (!f.this.jwj) {
                    f.this.jwn = new e(f.d(f.this), 0);
                } else {
                    f.this.jwn = new e(f.d(f.this), 1);
                }
                com.tencent.mm.kernel.g.azz().a(f.this.jwn, 0);
                AppMethodBeat.o(148536);
                return;
            } else if (message.what == 3 && f.this.jwk != null) {
                f.this.jwk.a(new String[0], -1);
            }
            AppMethodBeat.o(148536);
        }
    };
    public int jvZ = 1;
    public int jwf = 0;
    int jwg = 0;
    boolean jwh = false;
    private int jwi = 500000;
    public boolean jwj = false;
    b jwk = null;
    com.tencent.mm.audio.e.a jwl;
    com.tencent.qqpinyin.voicerecoapi.c jwm = null;
    private a jwn = null;

    public interface b {
        void a(String[] strArr, long j2);

        void biu();

        void biv();
    }

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(148543);
        fVar.finish();
        AppMethodBeat.o(148543);
    }

    static /* synthetic */ void g(f fVar) {
        AppMethodBeat.i(148544);
        fVar.reset();
        AppMethodBeat.o(148544);
    }

    static {
        AppMethodBeat.i(148545);
        AppMethodBeat.o(148545);
    }

    public f(b bVar, int i2) {
        int i3 = 500000;
        AppMethodBeat.i(148538);
        this.jwk = bVar;
        this.jvZ = i2;
        this.jwi = this.jvZ != 1 ? 1500000 : i3;
        AppMethodBeat.o(148538);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(148539);
        if (this.jvZ == 0) {
            Log.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
            com.tencent.mm.kernel.g.azz().b(349, this);
        } else {
            com.tencent.mm.kernel.g.azz().b(206, this);
        }
        String[] bin = ((a) qVar).bin();
        long bio = ((a) qVar).bio();
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Integer.valueOf(bin == null ? -1 : bin.length);
        Log.i("MicroMsg.SceneVoiceAddr", "onSceneEnd errType:%d errCode:%d list:%d", objArr);
        if (this.jwk != null) {
            if (i3 == 0 && i2 == 0) {
                this.jwk.a(bin, bio);
            } else {
                this.jwk.biu();
                cancel();
                AppMethodBeat.o(148539);
                return;
            }
        }
        AppMethodBeat.o(148539);
    }

    private void finish() {
        AppMethodBeat.i(148540);
        Log.i("MicroMsg.SceneVoiceAddr", "finish");
        Log.printInfoStack("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
        if (this.jwn != null) {
            this.jwn.bim();
        }
        this.handler.sendEmptyMessage(2);
        if (!this.jwh) {
            this.handler.sendEmptyMessage(3);
        }
        reset();
        AppMethodBeat.o(148540);
    }

    public final void cancel() {
        AppMethodBeat.i(148541);
        this.jwk = null;
        finish();
        AppMethodBeat.o(148541);
    }

    private void reset() {
        AppMethodBeat.i(148542);
        Log.i("MicroMsg.SceneVoiceAddr", "reset");
        synchronized (this) {
            try {
                if (this.dyI != null) {
                    this.dyI.ZZ();
                    this.dyI = null;
                }
                if (this.jwl != null) {
                    this.jwl.abP();
                    this.jwl = null;
                }
                if (this.jwm != null) {
                    this.jwm.stop();
                }
                this.jwm = null;
                if (this.jwn != null) {
                    this.jwn.bim();
                    this.jwn = null;
                }
                this.jwg = 0;
                this.jwh = false;
            } finally {
                AppMethodBeat.o(148542);
            }
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            AppMethodBeat.i(148537);
            synchronized (f.this) {
                try {
                    Log.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
                    try {
                        new o(f.d(f.this)).delete();
                    } catch (Exception e2) {
                        Log.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + f.d(f.this), e2);
                    }
                    f.this.dyI = new com.tencent.mm.audio.b.c(f.this.jwj ? TXRecordCommon.AUDIO_SAMPLERATE_8000 : 16000, 1, 3);
                    f.this.dyI.dzk = -19;
                    f.this.dyI.dc(false);
                    if (!f.this.jwj) {
                        f.this.jwl = new d();
                        if (!f.this.jwl.hz(f.d(f.this))) {
                            Log.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                            f.this.jwl.abP();
                            f.this.jwl = null;
                        }
                    }
                    if (f.this.jwj || ae.gKE.gGG <= 0) {
                        f.this.dyI.x(5, false);
                    } else {
                        f.this.dyI.x(ae.gKE.gGG, true);
                    }
                    f.this.dyI.dd(false);
                    f.this.jwm = new com.tencent.qqpinyin.voicerecoapi.c(f.this.jwi);
                    int hkt = f.this.jwm.hkt();
                    if (hkt != 0) {
                        Log.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :".concat(String.valueOf(hkt)));
                        f.g(f.this);
                    } else {
                        f.this.dyI.dzv = f.this.dzv;
                        if (!f.this.dyI.aai()) {
                            Log.e("MicroMsg.SceneVoiceAddr", "start record failed");
                            f.g(f.this);
                        }
                    }
                } finally {
                    AppMethodBeat.o(148537);
                }
            }
        }
    }

    static /* synthetic */ void a(f fVar, short[] sArr, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            short s = sArr[i3];
            if (s > fVar.jwf) {
                fVar.jwf = s;
            }
        }
    }

    static /* synthetic */ String d(f fVar) {
        if (!fVar.jwj) {
            return jwd;
        }
        return jwe;
    }
}
