package com.tencent.mm.plugin.facedetect.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelvoiceaddr.a.c;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private static final String sRP = (p.cTh() + "/fdv_v_");
    public static final String sRT = (g.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx");
    private c dyI;
    private c.a dzv = new c.a() {
        /* class com.tencent.mm.plugin.facedetect.d.a.AnonymousClass2 */
        short[] jwD;

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            AppMethodBeat.i(103804);
            Log.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", Integer.valueOf(i2));
            if (this.jwD == null || this.jwD.length < i2 / 2) {
                this.jwD = new short[(i2 / 2)];
            }
            for (int i3 = 0; i3 < i2 / 2; i3++) {
                this.jwD[i3] = (short) ((bArr[i3 * 2] & 255) | (bArr[(i3 * 2) + 1] << 8));
            }
            a.a(a.this, this.jwD, i2 / 2);
            if (a.this.jwB != null) {
                a.this.jwB.e(this.jwD, i2 / 2);
                if (-1 != (a.this.jwl != null ? a.this.jwl.a(new g.a(bArr, i2)) : -1) || a.this.sRQ == null) {
                    AppMethodBeat.o(103804);
                    return;
                }
                a.this.sRQ.onError(3);
                a.this.clearDiskCache();
                Log.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
                AppMethodBeat.o(103804);
                return;
            }
            if (a.this.sRQ != null) {
                a.this.sRQ.onError(1);
                a.this.clearDiskCache();
            }
            Log.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
            AppMethodBeat.o(103804);
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
            AppMethodBeat.i(103805);
            Log.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + i2 + " detailState = " + i3);
            a.this.clearDiskCache();
            if (a.this.sRQ != null) {
                a.this.sRQ.onError(2);
            }
            AppMethodBeat.o(103805);
        }
    };
    private final ArrayList<c.a> eN = new ArrayList<>(5);
    private com.tencent.mm.modelvoiceaddr.a.c jwB;
    private c.a jwC = new c.a() {
        /* class com.tencent.mm.plugin.facedetect.d.a.AnonymousClass3 */

        @Override // com.tencent.mm.modelvoiceaddr.a.c.a
        public final void b(short[] sArr, int i2) {
            AppMethodBeat.i(103806);
            Log.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", sArr, Integer.valueOf(i2));
            AppMethodBeat.o(103806);
        }

        @Override // com.tencent.mm.modelvoiceaddr.a.c.a
        public final void bix() {
            AppMethodBeat.i(103807);
            Log.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
            AppMethodBeat.o(103807);
        }

        @Override // com.tencent.mm.modelvoiceaddr.a.c.a
        public final void biy() {
            AppMethodBeat.i(103808);
            Log.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
            if (a.this.sRQ != null) {
                a.this.sRQ.cTp();
            }
            AppMethodBeat.o(103808);
        }

        @Override // com.tencent.mm.modelvoiceaddr.a.c.a
        public final void Yh() {
            AppMethodBeat.i(103809);
            Log.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
            if (a.this.sRQ != null) {
                a.this.sRQ.onError(11);
            }
            AppMethodBeat.o(103809);
        }
    };
    private int jwf = 0;
    private int jwg = 0;
    private com.tencent.mm.audio.e.a jwl;
    private boolean jxb = true;
    b sRQ = null;
    private boolean sRR = false;
    private String sRS = "";
    public c.a sRU = new c.a() {
        /* class com.tencent.mm.plugin.facedetect.d.a.AnonymousClass1 */

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            AppMethodBeat.i(103802);
            synchronized (a.this.eN) {
                try {
                    Iterator it = a.this.eN.iterator();
                    while (it.hasNext()) {
                        c.a aVar = (c.a) it.next();
                        if (aVar != null) {
                            aVar.w(bArr, i2);
                        }
                    }
                } finally {
                    AppMethodBeat.o(103802);
                }
            }
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
            AppMethodBeat.i(103803);
            synchronized (a.this.eN) {
                try {
                    Iterator it = a.this.eN.iterator();
                    while (it.hasNext()) {
                        c.a aVar = (c.a) it.next();
                        if (aVar != null) {
                            aVar.cj(i2, i3);
                        }
                    }
                } finally {
                    AppMethodBeat.o(103803);
                }
            }
        }
    };

    public interface b {
        void cTp();

        void onError(int i2);
    }

    public a() {
        AppMethodBeat.i(103811);
        AppMethodBeat.o(103811);
    }

    static {
        AppMethodBeat.i(103814);
        AppMethodBeat.o(103814);
    }

    public final void recycle() {
        AppMethodBeat.i(186370);
        Log.i("MicroMsg.FaceVoiceRecordLogic", "hy: recycling voice.");
        this.sRQ = null;
        AppMethodBeat.o(186370);
    }

    public final void ap(Runnable runnable) {
        AppMethodBeat.i(186371);
        Log.i("MicroMsg.FaceVoiceRecordLogic", "start record");
        ThreadPool.post(new RunnableC1035a(this, runnable, (byte) 0), "FaceVoice_record", 10);
        AppMethodBeat.o(186371);
    }

    public final void stopRecord() {
        AppMethodBeat.i(186372);
        this.sRR = true;
        Log.i("MicroMsg.FaceVoiceRecordLogic", "hy: face start reset");
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
                if (this.jwB != null) {
                    try {
                        this.jwB.release();
                        this.jwB = null;
                        this.jxb = true;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e2, "mVoiceSilentDetectAPI.release error", new Object[0]);
                    }
                }
                this.jwg = 0;
            } finally {
                AppMethodBeat.o(186372);
            }
        }
    }

    public final byte[] cTo() {
        AppMethodBeat.i(186373);
        byte[] aW = s.aW(this.sRS, -1, -1);
        AppMethodBeat.o(186373);
        return aW;
    }

    public final void clearDiskCache() {
        AppMethodBeat.i(103812);
        s.deleteFile(this.sRS);
        AppMethodBeat.o(103812);
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.a$a  reason: collision with other inner class name */
    class RunnableC1035a implements Runnable {
        private Runnable sRW;

        /* synthetic */ RunnableC1035a(a aVar, Runnable runnable, byte b2) {
            this(runnable);
        }

        private RunnableC1035a(Runnable runnable) {
            this.sRW = null;
            this.sRW = runnable;
        }

        public final void run() {
            AppMethodBeat.i(103810);
            synchronized (a.this) {
                try {
                    if (!a.this.sRR) {
                        Log.i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
                        a.this.sRS = a.sRP + Util.currentTicks() + ".spx";
                        Log.i("MicroMsg.FaceVoiceRecordLogic", "generateVoiceFilePath: %s", a.this.sRS);
                        try {
                            s.deleteFile(a.this.sRS);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e2, "hy: delete file failed", new Object[0]);
                        }
                        a.this.dyI = new com.tencent.mm.audio.b.c(16000, 1, 3);
                        a.this.dyI.dzk = -19;
                        a.this.dyI.dc(false);
                        a.this.jwl = new d();
                        if (!a.this.jwl.hz(a.this.sRS)) {
                            Log.e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
                            a.this.jwl.abP();
                            a.this.jwl = null;
                            if (a.this.sRQ != null) {
                                a.this.sRQ.onError(5);
                            }
                        } else {
                            if (ae.gKE.gGG > 0) {
                                a.this.dyI.x(ae.gKE.gGG, true);
                            } else {
                                a.this.dyI.x(5, false);
                            }
                            a.this.dyI.jk(50);
                            a.this.dyI.dd(false);
                            try {
                                a.this.jwB = new com.tencent.mm.modelvoiceaddr.a.c(5000, com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("sil_time", 200), com.tencent.mm.modelvoiceaddr.a.c.sp.getFloat("s_n_ration", 2.5f), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_window", 50), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_length", 35), com.tencent.mm.modelvoiceaddr.a.c.sp.getInt("s_delay_time", 20), false, false);
                                a.this.jwB.jxj = a.this.jwC;
                            } catch (Throwable th) {
                                Log.e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + th.getMessage());
                                if (a.this.sRQ != null) {
                                    a.this.sRQ.onError(6);
                                }
                            }
                            a.this.dyI.dzv = a.this.sRU;
                            a.this.b(a.this.dzv);
                            if (!a.this.dyI.aai()) {
                                Log.e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
                                if (a.this.sRQ != null) {
                                    a.this.sRQ.onError(7);
                                }
                            } else if (this.sRW != null) {
                                this.sRW.run();
                            }
                        }
                    } else {
                        Log.w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
                    }
                } finally {
                    AppMethodBeat.o(103810);
                }
            }
        }
    }

    public final void b(c.a aVar) {
        AppMethodBeat.i(103813);
        synchronized (this.eN) {
            try {
                this.eN.add(aVar);
            } finally {
                AppMethodBeat.o(103813);
            }
        }
    }

    public final void c(c.a aVar) {
        AppMethodBeat.i(186374);
        synchronized (this.eN) {
            try {
                this.eN.remove(aVar);
            } finally {
                AppMethodBeat.o(186374);
            }
        }
    }

    static /* synthetic */ void a(a aVar, short[] sArr, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            short s = sArr[i3];
            if (s > aVar.jwf) {
                aVar.jwf = s;
            }
        }
    }
}
