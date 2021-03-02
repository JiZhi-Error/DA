package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import com.tencent.f.h;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qqpinyin.voicerecoapi.a;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public final class l implements d {
    AudioTrack bfn;
    private int channel;
    b dAO;
    private d dwt;
    String fileName;
    String juF;
    String juG;
    boolean juP;
    MediaPlayer.OnCompletionListener juS;
    MediaPlayer.OnErrorListener juT;
    d.a juW;
    d.b juX;
    private int juY;
    private int juZ;
    a jva;
    private int jvb;
    int jvc;
    boolean jvd;
    byte[] jve;
    int jvf;
    InputStream jvg;
    int jvh;
    private int nSamplerate;
    volatile int status;

    @Override // com.tencent.mm.modelvoice.d
    public final int getStatus() {
        return this.status;
    }

    public l() {
        int i2 = 0;
        AppMethodBeat.i(130073);
        this.fileName = "";
        this.juW = null;
        this.juX = null;
        this.status = 0;
        this.juY = 2;
        this.nSamplerate = 16000;
        this.channel = 1;
        this.juZ = 20;
        this.jva = null;
        this.jvc = 0;
        this.jvd = false;
        this.juF = "";
        this.juG = "";
        this.juP = true;
        this.jve = new byte[a.MAX_FRAME_SIZE];
        this.jvf = 0;
        this.jvg = null;
        this.jvh = 314;
        this.juS = new MediaPlayer.OnCompletionListener() {
            /* class com.tencent.mm.modelvoice.l.AnonymousClass1 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(130070);
                if (l.this.dAO != null && l.this.juP) {
                    l.this.dAO.apm();
                }
                try {
                    l.this.status = 0;
                    l.this.bhY();
                    try {
                        l.a(l.this);
                        AppMethodBeat.o(130070);
                    } catch (InterruptedException e2) {
                        Log.e("MicroMsg.SpeexPlayer", "exception:%s", Util.stackTraceToString(e2));
                        AppMethodBeat.o(130070);
                    }
                } catch (Exception e3) {
                    Log.e("MicroMsg.SpeexPlayer", "exception:%s", Util.stackTraceToString(e3));
                    Log.e("MicroMsg.SpeexPlayer", "setCompletion File[" + l.this.fileName + "] ErrMsg[" + e3.getStackTrace() + "]");
                    AppMethodBeat.o(130070);
                }
            }
        };
        this.juT = new MediaPlayer.OnErrorListener() {
            /* class com.tencent.mm.modelvoice.l.AnonymousClass2 */

            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(130071);
                Log.d("MicroMsg.SpeexPlayer", "onError");
                if (l.this.dAO != null && l.this.juP) {
                    l.this.dAO.apm();
                }
                if (l.this.juX != null) {
                    l.this.juX.onError();
                }
                try {
                    l.this.status = -1;
                    l.this.bhY();
                    try {
                        l.a(l.this);
                    } catch (InterruptedException e2) {
                        Log.e("MicroMsg.SpeexPlayer", "exception:%s", Util.stackTraceToString(e2));
                    }
                } catch (Exception e3) {
                    Log.e("MicroMsg.SpeexPlayer", "setErrorListener File[" + l.this.fileName + "] ErrMsg[" + e3.getStackTrace() + "]");
                }
                AppMethodBeat.o(130071);
                return false;
            }
        };
        this.jva = new a();
        a aVar = this.jva;
        if (aVar.RKH != 0) {
            i2 = -103;
        } else {
            long nativeTRSpeexDecodeInit = aVar.RKI.nativeTRSpeexDecodeInit();
            if (nativeTRSpeexDecodeInit == -1) {
                i2 = (int) nativeTRSpeexDecodeInit;
            } else {
                aVar.RKH = nativeTRSpeexDecodeInit;
                aVar.RKF = new byte[(a.MAX_FRAME_SIZE * 15)];
            }
        }
        if (i2 != 0) {
            Log.e("speex", "res: ".concat(String.valueOf(i2)));
        }
        AppMethodBeat.o(130073);
    }

    public l(Context context) {
        this();
        AppMethodBeat.i(130074);
        this.dAO = new b(context);
        AppMethodBeat.o(130074);
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void a(d.a aVar) {
        this.juW = aVar;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void a(d.b bVar) {
        this.juX = bVar;
    }

    /* access modifiers changed from: package-private */
    public final void bhY() {
        AppMethodBeat.i(130075);
        if (this.bfn != null) {
            this.bfn.stop();
            this.bfn.release();
            this.bfn = null;
        }
        AppMethodBeat.o(130075);
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void cU(boolean z) {
        int i2;
        AppMethodBeat.i(130076);
        this.jvd = true;
        if (this.channel == 2) {
            this.juY = 3;
        } else {
            this.juY = 2;
        }
        this.jvb = AudioTrack.getMinBufferSize(this.nSamplerate, this.juY, 2);
        if (this.bfn != null) {
            try {
                this.bfn.stop();
                this.bfn.release();
                this.bfn = null;
            } catch (Exception e2) {
                Log.e("MicroMsg.SpeexPlayer", e2.getMessage());
                this.bfn = null;
            } catch (Throwable th) {
                this.bfn = null;
                AppMethodBeat.o(130076);
                throw th;
            }
        }
        if (z) {
            i2 = 3;
        } else {
            i2 = 0;
        }
        if (ae.gKu.gDA) {
            ae.gKu.dump();
            if (ae.gKu.gDH == 1) {
                i2 = 3;
            }
        }
        this.bfn = new e(i2, this.nSamplerate, this.juY, this.jvb * 8);
        try {
            this.bfn.play();
        } catch (Exception e3) {
            Log.e("MicroMsg.SpeexPlayer", "audioTrack error:%s", e3.getMessage());
        }
        this.jvd = false;
        AppMethodBeat.o(130076);
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean c(String str, boolean z, int i2) {
        AppMethodBeat.i(130078);
        boolean X = X(str, z);
        AppMethodBeat.o(130078);
        return X;
    }

    private boolean X(String str, boolean z) {
        AppMethodBeat.i(130079);
        if (this.status != 0) {
            Log.e("MicroMsg.SpeexPlayer", "startPlay error status:" + this.status);
            AppMethodBeat.o(130079);
            return false;
        }
        Log.i("MicroMsg.SpeexPlayer", "startPlay");
        this.status = 1;
        this.fileName = str;
        try {
            fV(z);
        } catch (Exception e2) {
            try {
                fV(true);
            } catch (Exception e3) {
                Log.e("MicroMsg.SpeexPlayer", "startPlay File[" + this.fileName + "] failed");
                Log.e("MicroMsg.SpeexPlayer", "exception:%s", Util.stackTraceToString(e2));
                this.status = -1;
                AppMethodBeat.o(130079);
                return false;
            }
        }
        AppMethodBeat.o(130079);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (com.tencent.mm.compatible.deviceinfo.ae.gKu.gDH == 1) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fV(boolean r9) {
        /*
        // Method dump skipped, instructions count: 191
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.l.fV(boolean):void");
    }

    private void bhZ() {
        AppMethodBeat.i(130081);
        if (this.bfn != null) {
            try {
                this.bfn.play();
                this.dwt = h.RTc.aX(new com.tencent.f.i.h() {
                    /* class com.tencent.mm.modelvoice.l.AnonymousClass3 */

                    @Override // com.tencent.f.i.h, com.tencent.f.i.g
                    public final String getKey() {
                        return "SpeexPlayer_play";
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:120:0x0255  */
                    /* JADX WARNING: Removed duplicated region for block: B:121:0x0266 A[SYNTHETIC, Splitter:B:121:0x0266] */
                    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5  */
                    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae  */
                    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cb  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                        // Method dump skipped, instructions count: 624
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.l.AnonymousClass3.run():void");
                    }
                });
            } catch (Exception e2) {
                Log.e("MicroMsg.SpeexPlayer", "audioTrack error:%s", e2.getMessage());
                AppMethodBeat.o(130081);
                return;
            }
        }
        AppMethodBeat.o(130081);
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean da(boolean z) {
        AppMethodBeat.i(130082);
        if (this.status != 1) {
            AppMethodBeat.o(130082);
            return false;
        }
        this.status = 2;
        synchronized (this.juG) {
            try {
                Log.v("MicroMsg.SpeexPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.juG.wait();
                Log.v("MicroMsg.SpeexPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
                try {
                    if (this.dAO != null && z && this.juP) {
                        this.dAO.apm();
                    }
                } finally {
                    AppMethodBeat.o(130082);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SpeexPlayer", "exception:%s", Util.stackTraceToString(e2));
                if (this.dAO != null && z && this.juP) {
                    this.dAO.apm();
                }
                AppMethodBeat.o(130082);
                return false;
            } catch (Throwable th) {
                if (this.dAO != null && z && this.juP) {
                    this.dAO.apm();
                }
                AppMethodBeat.o(130082);
                throw th;
            }
        }
        return true;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean resume() {
        AppMethodBeat.i(130083);
        if (this.status != 2) {
            AppMethodBeat.o(130083);
            return false;
        }
        this.status = 1;
        synchronized (this.juF) {
            try {
                Log.v("MicroMsg.SpeexPlayer", "before mpause.notify");
                this.juF.notify();
                Log.v("MicroMsg.SpeexPlayer", "after mpause.notify");
                try {
                    if (this.dAO != null && this.juP) {
                        this.dAO.requestFocus();
                    }
                } finally {
                    AppMethodBeat.o(130083);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SpeexPlayer", "exception:%s", Util.stackTraceToString(e2));
                if (this.dAO != null && this.juP) {
                    this.dAO.requestFocus();
                }
                AppMethodBeat.o(130083);
                return false;
            } catch (Throwable th) {
                if (this.dAO != null && this.juP) {
                    this.dAO.requestFocus();
                }
                AppMethodBeat.o(130083);
                throw th;
            }
        }
        return true;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean isPlaying() {
        return this.status == 1;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final boolean Qt() {
        AppMethodBeat.i(130084);
        Log.e("MicroMsg.SpeexPlayer", "stop  status:" + this.status);
        if (this.status == 1 || this.status == 2) {
            this.status = 3;
            synchronized (this.juF) {
                try {
                    this.juF.notify();
                    try {
                        if (this.dAO != null && this.juP) {
                            this.dAO.apm();
                        }
                    } finally {
                        AppMethodBeat.o(130084);
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.SpeexPlayer", "exception:%s", Util.stackTraceToString(e2));
                    bhY();
                    if (this.dAO != null && this.juP) {
                        this.dAO.apm();
                    }
                    AppMethodBeat.o(130084);
                    return false;
                } catch (Throwable th) {
                    if (this.dAO != null && this.juP) {
                        this.dAO.apm();
                    }
                    AppMethodBeat.o(130084);
                    throw th;
                }
            }
            return true;
        }
        Log.e("MicroMsg.SpeexPlayer", "stop  error status:" + this.status);
        try {
            synchronized (this.juF) {
                try {
                    this.juF.notify();
                } finally {
                    AppMethodBeat.o(130084);
                }
            }
            synchronized (this.juG) {
                try {
                    this.juG.notify();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Exception e3) {
        }
        this.status = 3;
        AppMethodBeat.o(130084);
        return false;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final double ZY() {
        return 0.0d;
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void c(b.a aVar) {
        AppMethodBeat.i(130085);
        if (!(aVar == null || this.dAO == null)) {
            this.dAO.a(aVar);
        }
        AppMethodBeat.o(130085);
    }

    @Override // com.tencent.mm.modelvoice.d
    public final void bhQ() {
        this.juP = false;
    }

    static /* synthetic */ void a(l lVar) {
        AppMethodBeat.i(130086);
        if (!(lVar.dwt == null || lVar.dwt.getThread() == Thread.currentThread())) {
            try {
                lVar.dwt.get();
            } catch (ExecutionException e2) {
                Log.e("MicroMsg.SpeexPlayer", "ExecutionException:%s", e2.toString());
            }
            lVar.dwt = null;
        }
        AppMethodBeat.o(130086);
    }
}
