package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVPlayer;

public class a {
    private static final String sUD = (p.cTh() + '/' + "fdv_");
    public static final String sUE = (p.cTh() + '/' + "video_temp_test.mp4");
    private static final String sUF = (p.cTh() + '/' + "fdv_t_");
    private static volatile a sUp = null;
    public d gVN;
    private com.tencent.mm.plugin.mmsight.model.a.d kxS;
    private String mFilePath;
    private final Object mLock;
    private boolean nmu;
    private int sUA;
    private String sUB;
    public com.tencent.mm.plugin.mmsight.api.b sUC;
    private d.b sUG;
    private d.a sUH;
    public MMHandler sUq;
    private final int sUr;
    private final int sUs;
    private final int sUt;
    private EnumC1037a sUu;
    private int sUv;
    private int sUw;
    public boolean sUx;
    private b sUy;
    private int sUz;

    public interface b {
        void arD(String str);
    }

    static {
        AppMethodBeat.i(104090);
        AppMethodBeat.o(104090);
    }

    private a() {
        AppMethodBeat.i(104078);
        this.mLock = new Object();
        this.sUq = null;
        this.sUr = 960;
        this.sUs = TAVPlayer.VIDEO_PLAYER_WIDTH;
        this.sUt = 15;
        this.sUu = EnumC1037a.UNINITIALIZED;
        this.sUv = 0;
        this.nmu = false;
        this.sUw = 0;
        this.sUx = false;
        this.sUy = null;
        this.sUz = -1;
        this.sUA = -1;
        this.mFilePath = "";
        this.sUB = "";
        this.gVN = new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext());
        this.sUC = com.tencent.mm.plugin.mmsight.api.b.zsZ.bqG();
        this.sUG = new d.b() {
            /* class com.tencent.mm.plugin.facedetect.e.a.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.facedetect.model.d.b
            public final void bC(byte[] bArr) {
                AppMethodBeat.i(104073);
                a.this.bD(bArr);
                AppMethodBeat.o(104073);
            }

            @Override // com.tencent.mm.plugin.facedetect.model.d.b
            public final com.tencent.mm.memory.a<byte[]> cSS() {
                return k.zwi;
            }
        };
        this.sUH = new d.a() {
            /* class com.tencent.mm.plugin.facedetect.e.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.mmsight.model.a.d.a
            public final void bqP() {
                AppMethodBeat.i(104063);
                Log.e("MicroMsg.FaceVideoRecorder", "hy: video capture error: %d", 1);
                a.this.sUq.postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetect.e.a.AnonymousClass2.AnonymousClass1 */
                    final /* synthetic */ int ksf = 1;

                    public final void run() {
                        AppMethodBeat.i(104062);
                        try {
                            if (a.this.kxS != null) {
                                a.this.kxS.reset();
                            }
                            a.d(a.this);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.FaceVideoRecorder", "hy: onError, reset mediaRecorder error: %s", e2.getMessage());
                            a.d(a.this);
                        } catch (Throwable th) {
                            a.d(a.this);
                            AppMethodBeat.o(104062);
                            throw th;
                        }
                        synchronized (a.this.mLock) {
                            try {
                                a.this.sUu = EnumC1037a.INITIALIZED;
                            } finally {
                                AppMethodBeat.o(104062);
                            }
                        }
                        if (FaceContextData.cST() != null) {
                            FaceDetectReporter.h(FaceContextData.cST().sQI, 2, this.ksf);
                        }
                    }
                });
                AppMethodBeat.o(104063);
            }
        };
        this.sUq = new MMHandler("face_video_handler");
        AppMethodBeat.o(104078);
    }

    public static a cTF() {
        a aVar;
        AppMethodBeat.i(104079);
        if (sUp == null) {
            synchronized (a.class) {
                try {
                    if (sUp == null) {
                        sUp = new a();
                    }
                    aVar = sUp;
                } finally {
                    AppMethodBeat.o(104079);
                }
            }
            return aVar;
        }
        a aVar2 = sUp;
        AppMethodBeat.o(104079);
        return aVar2;
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$a  reason: collision with other inner class name */
    public enum EnumC1037a {
        UNINITIALIZED,
        INITIALIZED,
        STARTED,
        STOPPING,
        STOPPED,
        CANCELLED;

        public static EnumC1037a valueOf(String str) {
            AppMethodBeat.i(104076);
            EnumC1037a aVar = (EnumC1037a) Enum.valueOf(EnumC1037a.class, str);
            AppMethodBeat.o(104076);
            return aVar;
        }

        static {
            AppMethodBeat.i(104077);
            AppMethodBeat.o(104077);
        }
    }

    public final boolean a(final int i2, final int i3, final int i4, final int i5, final int i6, final boolean z) {
        AppMethodBeat.i(104080);
        Log.i("MicroMsg.FaceVideoRecorder", "hy: init record");
        Log.i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d, acceptVoiceFromOutside: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.FALSE, 0, Boolean.valueOf(z));
        this.sUC.a(this.gVN, bDA());
        this.sUq.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.facedetect.e.a.AnonymousClass1 */
            final /* synthetic */ boolean sUL = false;
            final /* synthetic */ int sUM = 0;

            public final void run() {
                AppMethodBeat.i(104061);
                if (i2 == 90 || i2 == 270) {
                    Log.i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
                    a.this.sUz = i4;
                    a.this.sUA = i3;
                } else {
                    a.this.sUz = i3;
                    a.this.sUA = i4;
                }
                synchronized (a.this.mLock) {
                    try {
                        a.this.sUv = i2;
                        a.this.nmu = this.sUL;
                        a.this.sUw = this.sUM;
                    } finally {
                        AppMethodBeat.o(104061);
                    }
                }
                a.b(a.this);
                a.c(a.this);
                a.d(a.this);
                if (MMApplicationContext.isMainProcess()) {
                    synchronized (a.this.mLock) {
                        try {
                            long currentTicks = Util.currentTicks();
                            a.this.kxS = a.this.sUC.bqF();
                            a.this.kxS.setFilePath(a.this.mFilePath);
                            a.this.kxS.HA(a.this.sUB);
                            a.this.kxS.fk(z);
                            a.this.kxS.s(a.this.sUz, a.this.sUA, i5, i6);
                            a.this.kxS.rC(a.this.sUv);
                            a.this.kxS.a(a.this.sUH);
                            a.this.sUu = EnumC1037a.INITIALIZED;
                            Log.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", Long.valueOf(Util.ticksToNow(currentTicks)));
                        } finally {
                            AppMethodBeat.o(104061);
                        }
                    }
                    return;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetect.e.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(104060);
                        final long currentTicks = Util.currentTicks();
                        a.this.gVN.connect(new Runnable() {
                            /* class com.tencent.mm.plugin.facedetect.e.a.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(104059);
                                synchronized (a.this.mLock) {
                                    try {
                                        Log.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", Long.valueOf(Util.ticksToNow(currentTicks)));
                                        long currentTicks = Util.currentTicks();
                                        a.this.kxS = a.this.sUC.bqF();
                                        a.this.kxS.setFilePath(a.this.mFilePath);
                                        a.this.kxS.HA(a.this.sUB);
                                        a.this.kxS.fk(z);
                                        a.this.kxS.s(a.this.sUz, a.this.sUA, i5, i6);
                                        a.this.kxS.rC(a.this.sUv);
                                        a.this.kxS.a(a.this.sUH);
                                        a.this.sUu = EnumC1037a.INITIALIZED;
                                        Log.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", Long.valueOf(Util.ticksToNow(currentTicks)));
                                    } finally {
                                        AppMethodBeat.o(104059);
                                    }
                                }
                            }
                        });
                        AppMethodBeat.o(104060);
                    }
                });
                AppMethodBeat.o(104061);
            }
        });
        AppMethodBeat.o(104080);
        return true;
    }

    public final boolean isStarted() {
        boolean z;
        synchronized (this.mLock) {
            z = this.sUu == EnumC1037a.STARTED;
        }
        return z;
    }

    public final c.a cTG() {
        AppMethodBeat.i(104081);
        if (this.kxS != null) {
            c.a aQS = this.kxS.aQS();
            AppMethodBeat.o(104081);
            return aQS;
        }
        Log.w("MicroMsg.FaceVideoRecorder", "hy: no media recorder");
        AppMethodBeat.o(104081);
        return null;
    }

    public final boolean aai() {
        AppMethodBeat.i(104082);
        Log.e("MicroMsg.FaceVideoRecorder", "carson: start Record Video");
        this.sUq.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.facedetect.e.a.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(104069);
                synchronized (a.this.mLock) {
                    try {
                        if (a.this.sUu == EnumC1037a.UNINITIALIZED) {
                            Log.e("MicroMsg.FaceVideoRecorder", "hy: not started. should not happen");
                            a.d(a.this);
                        } else if (a.this.sUu == EnumC1037a.STARTED) {
                            Log.w("MicroMsg.FaceVideoRecorder", "hy: already started or wait start");
                            AppMethodBeat.o(104069);
                        } else {
                            Log.i("MicroMsg.FaceVideoRecorder", "hy: startRecord record");
                            com.tencent.mm.plugin.facedetect.model.d.cSR().clear();
                            com.tencent.mm.plugin.facedetect.model.d.cSR().a(a.this.sUG);
                            a.this.kxS.b(a.this.sUv, a.this.nmu, a.this.sUw);
                            a.this.sUu = EnumC1037a.STARTED;
                            AppMethodBeat.o(104069);
                        }
                    } finally {
                        AppMethodBeat.o(104069);
                    }
                }
            }
        });
        AppMethodBeat.o(104082);
        return true;
    }

    public final void cTH() {
        AppMethodBeat.i(104083);
        Log.e("MicroMsg.FaceVideoRecorder", "carson: cancel Record Video");
        this.sUq.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.facedetect.e.a.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(104070);
                synchronized (a.this.mLock) {
                    try {
                        if (a.this.sUu == EnumC1037a.UNINITIALIZED) {
                            Log.e("MicroMsg.FaceVideoRecorder", "hy: not started when cancel. should not happen");
                            a.d(a.this);
                            return;
                        }
                        Log.i("MicroMsg.FaceVideoRecorder", "hy: cancel record");
                        a.this.kxS.cancel();
                        a.d(a.this);
                        com.tencent.mm.plugin.facedetect.model.d.cSR().b(a.this.sUG);
                        a.this.sUu = EnumC1037a.CANCELLED;
                        a.this.gVN.release();
                        AppMethodBeat.o(104070);
                    } finally {
                        AppMethodBeat.o(104070);
                    }
                }
            }
        });
        AppMethodBeat.o(104083);
    }

    public final void a(final b bVar) {
        AppMethodBeat.i(104084);
        Log.e("MicroMsg.FaceVideoRecorder", "carson: stop Record Video");
        this.sUq.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.facedetect.e.a.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(104072);
                synchronized (a.this.mLock) {
                    try {
                        a.this.sUy = bVar;
                        if (a.this.sUu == EnumC1037a.UNINITIALIZED) {
                            Log.e("MicroMsg.FaceVideoRecorder", "hy: not initialized. should not happen");
                            a.d(a.this);
                            if (a.this.sUy != null) {
                                a.this.sUy.arD(null);
                            }
                        } else if (a.this.sUu == EnumC1037a.CANCELLED || a.this.sUu == EnumC1037a.INITIALIZED) {
                            Log.w("MicroMsg.FaceVideoRecorder", "hy: cancelled or not started capturing.");
                            a.d(a.this);
                            if (a.this.sUy != null) {
                                a.this.sUy.arD(null);
                            }
                            AppMethodBeat.o(104072);
                        } else if (a.this.sUu == EnumC1037a.STOPPED) {
                            Log.i("MicroMsg.FaceVideoRecorder", "hy: already stopped");
                            if (a.this.sUy != null) {
                                a.this.sUy.arD(a.this.kxS.getFilePath());
                            }
                            AppMethodBeat.o(104072);
                        } else if (a.this.sUu == EnumC1037a.STOPPING) {
                            Log.i("MicroMsg.FaceVideoRecorder", "hy: stopping. wait");
                            AppMethodBeat.o(104072);
                        } else {
                            Log.i("MicroMsg.FaceVideoRecorder", "hy: stop record and release" + Thread.currentThread().getName());
                            com.tencent.mm.plugin.facedetect.model.d.cSR().b(a.this.sUG);
                            a.this.sUu = EnumC1037a.STOPPING;
                            a.this.kxS.E(new Runnable() {
                                /* class com.tencent.mm.plugin.facedetect.e.a.AnonymousClass8.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(104071);
                                    synchronized (a.this.mLock) {
                                        try {
                                            Log.i("MicroMsg.FaceVideoRecorder", "carson: begin to stop" + a.this.kxS.getFilePath());
                                            a.this.sUu = EnumC1037a.STOPPED;
                                            s.deleteFile(a.this.sUB);
                                            if (a.this.sUy != null) {
                                                a.this.sUy.arD(a.this.kxS.getFilePath());
                                            }
                                        } finally {
                                            AppMethodBeat.o(104071);
                                        }
                                    }
                                }
                            });
                            AppMethodBeat.o(104072);
                        }
                    } finally {
                        AppMethodBeat.o(104072);
                    }
                }
            }
        });
        AppMethodBeat.o(104084);
    }

    public final void bD(final byte[] bArr) {
        AppMethodBeat.i(104085);
        this.sUq.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.facedetect.e.a.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(104074);
                SightVideoJNI.mirrorCameraData(bArr, a.this.sUz, a.this.sUA, false);
                if (a.this.kxS.getFrameDataCallback() != null) {
                    a.this.kxS.getFrameDataCallback().ai(bArr);
                }
                AppMethodBeat.o(104074);
            }
        });
        AppMethodBeat.o(104085);
    }

    public final EnumC1037a cTI() {
        EnumC1037a aVar;
        synchronized (this.mLock) {
            aVar = this.sUu;
        }
        return aVar;
    }

    private VideoTransPara bDA() {
        AppMethodBeat.i(104086);
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.width = this.sUz;
        videoTransPara.height = this.sUA;
        videoTransPara.fps = 30;
        videoTransPara.videoBitrate = 1200000;
        videoTransPara.iiH = 10;
        videoTransPara.audioBitrate = 64000;
        videoTransPara.iSU = 2;
        videoTransPara.iSV = 1;
        videoTransPara.audioSampleRate = 16000;
        videoTransPara.duration = 15;
        AppMethodBeat.o(104086);
        return videoTransPara;
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(104087);
        aVar.mFilePath = sUD + Util.currentTicks() + ".mp4";
        AppMethodBeat.o(104087);
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(104088);
        aVar.sUB = sUF + Util.currentTicks() + ".thumb";
        AppMethodBeat.o(104088);
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(104089);
        s.deleteFile(aVar.mFilePath);
        s.deleteFile(aVar.sUB);
        AppMethodBeat.o(104089);
    }
}
