package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.util.Size;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.api.recordView.g;
import com.tencent.mm.plugin.api.recordView.i;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.l;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tinker.a.c.b;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public final class f extends MMSightRecordView.e implements g.a, d.a, com.tencent.mm.plugin.mmsight.model.g {
    private int audioBitrate;
    private int audioSampleRate;
    private Context context;
    private int fps;
    float ilP;
    boolean kyA = false;
    int kyB = -1;
    Point kyC;
    private Point kyD;
    private boolean kyE = true;
    private boolean kyF = true;
    private boolean kyG = false;
    private g kyH;
    MMSightRecordView.d kyI;
    private MMSightRecordView.c kyJ;
    private boolean kyK = false;
    private float kyL = 1.0f;
    h kyM = null;
    private Point kyN = new Point(0, 0);
    private b kyO;
    private byte[] kyP = null;
    private d kyo;
    com.tencent.mm.plugin.mmsight.model.f kyp;
    int kyq;
    private int kyr;
    int kys = 0;
    private int kyt;
    private boolean kyu = true;
    private ObservableTextureView kyv;
    MMSightCameraGLSurfaceView kyw;
    boolean kyx = false;
    private MMSightRecordView.a kyy;
    boolean kyz = false;
    private int videoBitrate;
    private String videoPath;
    private WindowManager windowManager = null;

    public f() {
        AppMethodBeat.i(89226);
        AppMethodBeat.o(89226);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void b(Context context2, ViewGroup viewGroup) {
        AppMethodBeat.i(89227);
        this.context = context2;
        this.kyv = new ObservableTextureView(context2);
        this.kyw = new MMSightCameraGLSurfaceView(context2);
        this.kyw.setBackgroundColor(Color.argb(0, 0, 0, 0));
        int fromDPToPix = a.fromDPToPix(context2, 1);
        viewGroup.addView(this.kyv, new FrameLayout.LayoutParams(fromDPToPix, fromDPToPix));
        viewGroup.addView(this.kyw, new ViewGroup.MarginLayoutParams(-1, -1));
        this.kyH = new g();
        this.kyH.kyZ = this;
        this.kyw.setOnTouchListener(this.kyH);
        k.ejI();
        Log.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", context2);
        AppMethodBeat.o(89227);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void a(Context context2, ViewGroup viewGroup, SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setInitErrorCallback(MMSightRecordView.d dVar) {
        this.kyI = dVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setInitDoneCallback(MMSightRecordView.c cVar) {
        this.kyJ = cVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setDisplayRatio(float f2) {
        AppMethodBeat.i(89228);
        int screenRotation = getScreenRotation();
        Log.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s, screenRotation: %s", Float.valueOf(f2), Integer.valueOf(screenRotation));
        this.ilP = f2;
        if (screenRotation == 90 || screenRotation == 270) {
            this.ilP = 1.0f / this.ilP;
        }
        AppMethodBeat.o(89228);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setPreviewSizeLimit(int i2) {
        AppMethodBeat.i(89229);
        Log.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", Integer.valueOf(i2));
        this.kyq = i2;
        AppMethodBeat.o(89229);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setRGBSizeLimit(int i2) {
        AppMethodBeat.i(89230);
        Log.i("MicroMsg.MMSightRecordViewImpl", "setRGBSizeLimit: %s", Integer.valueOf(i2));
        this.kyr = i2;
        AppMethodBeat.o(89230);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setPreviewMode(int i2) {
        AppMethodBeat.i(89231);
        Log.i("MicroMsg.MMSightRecordViewImpl", "setPreviewMode: %s", Integer.valueOf(i2));
        this.kys = i2;
        AppMethodBeat.o(89231);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void startPreview() {
        AppMethodBeat.i(89232);
        Log.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", Float.valueOf(this.ilP), Integer.valueOf(this.kyq));
        this.kyG = false;
        if (this.ilP > 0.0f && this.kyq > 0) {
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.width = this.kyq;
            videoTransPara.height = (int) (((float) this.kyq) / this.ilP);
            Log.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", Integer.valueOf(videoTransPara.width), Integer.valueOf(videoTransPara.height));
            this.kyp = new com.tencent.mm.plugin.mmsight.model.f(videoTransPara, -1);
            this.kyp.a(this);
            if (!this.kyp.D(this.context, this.kyu)) {
                Log.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
                if (this.kyI != null) {
                    this.kyI.bFW();
                }
                AppMethodBeat.o(89232);
                return;
            }
            Log.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
            List<Integer> ejC = this.kyp.ejC();
            if (ejC != null && !ejC.isEmpty()) {
                int intValue = ejC.get(ejC.size() - 1).intValue();
                int i2 = 1;
                for (int i3 = intValue; i3 / 10 >= 10; i3 /= 10) {
                    i2 *= 10;
                }
                int i4 = intValue / i2;
                if ((intValue + 4) / i2 > i4) {
                    i4++;
                }
                this.kyO = new b(i4);
                for (int i5 = 10; i5 <= i4; i5++) {
                    if (ejC.indexOf(Integer.valueOf(i5 * i2)) < 0) {
                        int i6 = 1;
                        while (true) {
                            if (i6 > 4) {
                                break;
                            } else if (ejC.indexOf(Integer.valueOf((i5 * i2) - i6)) > 0) {
                                this.kyO.append(i5, (i5 * i2) - i6);
                                break;
                            } else if (ejC.indexOf(Integer.valueOf((i5 * i2) + i6)) > 0) {
                                this.kyO.append(i5, i6 + (i5 * i2));
                                break;
                            } else {
                                i6++;
                            }
                        }
                    } else {
                        this.kyO.append(i5, i5 * i2);
                    }
                }
            }
            if (this.kyv.isAvailable()) {
                if (this.kyp.a(this.kyv.getSurfaceTexture(), this.kyq, this.ilP, this.kyz) < 0) {
                    Log.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
                    if (this.kyI != null) {
                        this.kyI.bFW();
                    }
                }
                if (this.kyB != -1) {
                    bqM();
                }
                this.kyp.ejz();
                Log.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
                bqJ();
                bqS();
                if (this.kyM != null) {
                    this.kyM.b(this.kyw.getEglContext());
                }
                AppMethodBeat.o(89232);
                return;
            }
            this.kyv.setTextureChangeCallback(new com.tencent.mm.plugin.video.b() {
                /* class com.tencent.mm.plugin.api.recordView.f.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.video.b
                public final void f(SurfaceTexture surfaceTexture) {
                    AppMethodBeat.i(89220);
                    if (f.this.kyp.a(surfaceTexture, f.this.kyq, f.this.ilP, f.this.kyz) < 0) {
                        Log.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
                        if (f.this.kyI != null) {
                            f.this.kyI.bFW();
                        }
                    }
                    if (f.this.kyB != -1) {
                        f.this.bqM();
                    }
                    f.this.kyp.ejz();
                    f.this.bqJ();
                    f.this.bqS();
                    if (f.this.kyM != null) {
                        f.this.kyM.b(f.this.kyw.getEglContext());
                    }
                    Log.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
                    AppMethodBeat.o(89220);
                }
            });
        }
        AppMethodBeat.o(89232);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setVideoPara$2e715812(int i2) {
        AppMethodBeat.i(89233);
        this.kyt = i2;
        this.videoBitrate = 4800000;
        this.fps = 30;
        this.audioBitrate = 64000;
        this.audioSampleRate = 44100;
        Log.i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", Integer.valueOf(i2), 4800000, 30, 64000, 44100);
        AppMethodBeat.o(89233);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setVideoFilePath(String str) {
        AppMethodBeat.i(89234);
        Log.i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", str);
        this.videoPath = str;
        AppMethodBeat.o(89234);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final String getVideoFilePath() {
        AppMethodBeat.i(89235);
        if (this.kyo == null || !this.kyx) {
            String str = this.videoPath;
            AppMethodBeat.o(89235);
            return str;
        }
        String filePath = this.kyo.getFilePath();
        AppMethodBeat.o(89235);
        return filePath;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void bqI() {
        AppMethodBeat.i(89236);
        bqJ();
        AppMethodBeat.o(89236);
    }

    /* access modifiers changed from: package-private */
    public final void bqJ() {
        AppMethodBeat.i(89237);
        if (this.kyx) {
            Log.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
            AppMethodBeat.o(89237);
            return;
        }
        if (this.kyo != null) {
            Log.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
            this.kyo.cancel();
            if (this.kyp != null) {
                this.kyp.b(this.kyo.getFrameDataCallback());
            }
            this.kyo = null;
        }
        if (this.kyq > 0 && this.kyt > 0 && this.videoBitrate > 0 && this.fps > 0 && this.audioBitrate > 0 && this.audioSampleRate > 0 && this.kyp != null && this.kyp.getEncodeVideoBestSize() != null) {
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.width = this.kyq;
            videoTransPara.height = (int) (((float) this.kyq) / this.ilP);
            videoTransPara.duration = this.kyt;
            videoTransPara.videoBitrate = this.videoBitrate;
            videoTransPara.fps = this.fps;
            videoTransPara.audioBitrate = this.audioBitrate;
            videoTransPara.audioSampleRate = this.audioSampleRate;
            videoTransPara.iSU = 2;
            videoTransPara.iSV = 1;
            videoTransPara.iiH = 1;
            k.zuy.irT = videoTransPara;
            k.zuy.videoBitrate = this.videoBitrate;
            k.zuy.ilT = this.kyq;
            l.ekc();
            this.kyo = l.q(videoTransPara);
            if (this.kyo == null) {
                Log.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
                if (this.kyI != null) {
                    this.kyI.bFW();
                }
                AppMethodBeat.o(89237);
                return;
            }
            this.kyo.setFilePath(this.videoPath);
            if (this.kyz && this.kyp != null && this.kyp.dEO()) {
                bqK();
            }
            int i2 = this.kyp.getEncodeVideoBestSize().x;
            int i3 = this.kyp.getEncodeVideoBestSize().y;
            if (this.kyD != null && this.kyz) {
                i2 = this.kyD.x;
                i3 = this.kyD.y;
            }
            int QJ = com.tencent.mm.plugin.mmsight.d.QJ((int) (((float) i2) * this.kyL));
            int QJ2 = com.tencent.mm.plugin.mmsight.d.QJ((int) (((float) i3) * this.kyL));
            Log.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", Integer.valueOf(QJ), Integer.valueOf(QJ2), Float.valueOf(this.kyL));
            if (this.kyD == null || !this.kyz) {
                this.kyo.s(this.kyp.getPreviewWidth(), this.kyp.getPreviewHeight(), QJ, QJ2);
            } else {
                this.kyo.s(this.kyD.y, this.kyD.x, QJ, QJ2);
            }
            this.kyo.aQT();
            this.kyo.a(this);
            if (!this.kyo.rC(this.kyp.getOrientation())) {
                Log.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
                if (this.kyI != null) {
                    this.kyI.bFW();
                }
                AppMethodBeat.o(89237);
                return;
            }
            this.kyx = true;
        }
        AppMethodBeat.o(89237);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final boolean aai() {
        int i2;
        AppMethodBeat.i(89238);
        Log.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", this.kyo);
        bqJ();
        if (this.kyo == null) {
            Log.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
            AppMethodBeat.o(89238);
            return false;
        }
        int screenRotation = getScreenRotation();
        Log.i("MicroMsg.MMSightRecordViewImpl", "screen rotate: %s", Integer.valueOf(screenRotation));
        if (screenRotation == 90 || screenRotation == 270) {
            i2 = this.kyo.b(this.kyp.getOrientation(), true, 360 - screenRotation);
        } else {
            i2 = this.kyo.b(this.kyp.getOrientation(), false, screenRotation);
        }
        Log.i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", Integer.valueOf(i2));
        if (i2 >= 0) {
            AppMethodBeat.o(89238);
            return true;
        }
        AppMethodBeat.o(89238);
        return false;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void a(final MMSightRecordView.h hVar) {
        AppMethodBeat.i(89239);
        if (this.kyo != null) {
            Log.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", hVar);
            this.kyo.a(new d.a() {
                /* class com.tencent.mm.plugin.api.recordView.f.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.mmsight.model.a.d.a
                public final void bqP() {
                    AppMethodBeat.i(89221);
                    if (hVar != null) {
                        hVar.hs(true);
                    }
                    AppMethodBeat.o(89221);
                }
            });
            this.kyo.E(new Runnable() {
                /* class com.tencent.mm.plugin.api.recordView.f.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(89222);
                    f.this.kyx = false;
                    if (hVar != null) {
                        hVar.hs(false);
                    }
                    AppMethodBeat.o(89222);
                }
            });
            this.kyo = null;
        }
        AppMethodBeat.o(89239);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void a(final MMSightRecordView.g gVar, final boolean z) {
        AppMethodBeat.i(89240);
        if (!(gVar == null || this.kyp == null || !this.kyp.dEO())) {
            if (z) {
                this.kyp.ejE();
            }
            if (z) {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.api.recordView.f.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(89223);
                        f.this.b(gVar, z);
                        AppMethodBeat.o(89223);
                    }
                }, 100);
                AppMethodBeat.o(89240);
                return;
            }
            b(gVar, z);
        }
        AppMethodBeat.o(89240);
    }

    /* access modifiers changed from: package-private */
    public final void b(final MMSightRecordView.g gVar, final boolean z) {
        AppMethodBeat.i(89241);
        this.kyp.a((f.b) new f.b() {
            /* class com.tencent.mm.plugin.api.recordView.f.AnonymousClass5 */

            /* JADX WARNING: Removed duplicated region for block: B:25:0x00ab A[Catch:{ Exception -> 0x00e0 }] */
            @Override // com.tencent.mm.plugin.mmsight.model.f.b
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(byte[] r11, int r12, int r13, int r14, int r15) {
                /*
                // Method dump skipped, instructions count: 315
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.api.recordView.f.AnonymousClass5.a(byte[], int, int, int, int):void");
            }
        }, false, getScreenRotation());
        AppMethodBeat.o(89241);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setUseBackCamera(boolean z) {
        AppMethodBeat.i(89242);
        Log.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", Boolean.valueOf(z));
        this.kyu = z;
        AppMethodBeat.o(89242);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final Point getPictureSize() {
        AppMethodBeat.i(89243);
        if (this.kyp == null || !this.kyp.dEO()) {
            AppMethodBeat.o(89243);
            return null;
        } else if (!this.kyA) {
            Point point = new Point(this.kyp.getPreviewWidth(), this.kyp.getPreviewHeight());
            AppMethodBeat.o(89243);
            return point;
        } else {
            bqL();
            Point point2 = this.kyC;
            AppMethodBeat.o(89243);
            return point2;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final Point getVideoSize() {
        AppMethodBeat.i(89244);
        if (this.kyp == null || !this.kyp.dEO()) {
            AppMethodBeat.o(89244);
            return null;
        }
        int i2 = this.kyp.getEncodeVideoBestSize().x;
        int i3 = this.kyp.getEncodeVideoBestSize().y;
        if (this.kyD != null && this.kyz) {
            i2 = this.kyD.x;
            i3 = this.kyD.y;
        }
        Point point = new Point(com.tencent.mm.plugin.mmsight.d.QJ((int) (((float) i2) * this.kyL)), com.tencent.mm.plugin.mmsight.d.QJ((int) (((float) i3) * this.kyL)));
        AppMethodBeat.o(89244);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final Point getPreviewSize() {
        AppMethodBeat.i(89245);
        boolean z = this.kyp.getOrientation() == 0 || this.kyp.getOrientation() == 180;
        Point point = new Point(z ? this.kyp.getPreviewWidth() : this.kyp.getPreviewHeight(), z ? this.kyp.getPreviewHeight() : this.kyp.getPreviewWidth());
        AppMethodBeat.o(89245);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final Point getDrawSizePoint() {
        AppMethodBeat.i(89246);
        Log.i("MicroMsg.MMSightRecordViewImpl", "getDrawSizePoint : %s", this.kyN.toString());
        Point point = this.kyN;
        AppMethodBeat.o(89246);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setFrameDataCallback(MMSightRecordView.a aVar) {
        this.kyy = aVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final int getCameraRotation() {
        AppMethodBeat.i(89247);
        if (this.kyp != null) {
            int orientation = this.kyp.getOrientation();
            AppMethodBeat.o(89247);
            return orientation;
        }
        AppMethodBeat.o(89247);
        return 0;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void switchCamera() {
        AppMethodBeat.i(89248);
        if (this.kyp != null && this.kyp.dEO() && (this.kyo == null || this.kyo.aQN() != d.c.Start)) {
            this.kyp.a(this.context, this.kyv.getSurfaceTexture(), this.kyq, this.ilP, this.kyz);
            if (this.kyM != null) {
                bqS();
            }
        }
        AppMethodBeat.o(89248);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setClipVideoSize(boolean z) {
        AppMethodBeat.i(89249);
        this.kyz = z;
        if (this.kyz && this.kyp != null && this.kyp.dEO()) {
            bqK();
        }
        AppMethodBeat.o(89249);
    }

    private void bqK() {
        AppMethodBeat.i(89250);
        if (this.kyp != null && this.kyp.dEO()) {
            if (this.kyp.zub) {
                this.kyD = new Point(com.tencent.mm.plugin.mmsight.d.gZ((int) (((float) this.kyp.getPreviewWidth()) / this.ilP), this.kyp.getPreviewHeight()), this.kyp.getPreviewWidth());
            } else {
                this.kyD = new Point(this.kyp.getPreviewHeight(), com.tencent.mm.plugin.mmsight.d.gZ((int) (((float) this.kyp.getPreviewHeight()) * this.ilP), this.kyp.getPreviewWidth()));
            }
            Log.i("MicroMsg.MMSightRecordViewImpl", "initVideoSize: %s", this.kyD);
        }
        AppMethodBeat.o(89250);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setClipPictureSize(boolean z) {
        AppMethodBeat.i(89251);
        this.kyA = z;
        if (this.kyA && this.kyp != null && this.kyp.dEO()) {
            bqL();
        }
        AppMethodBeat.o(89251);
    }

    /* access modifiers changed from: package-private */
    public final void bqL() {
        AppMethodBeat.i(89252);
        if (this.kyp != null && this.kyp.dEO()) {
            if (this.kyp.zub) {
                this.kyC = new Point(this.kyp.getPreviewWidth(), (int) (((float) this.kyp.getPreviewWidth()) / this.ilP));
                AppMethodBeat.o(89252);
                return;
            }
            this.kyC = new Point((int) (((float) this.kyp.getPreviewHeight()) * this.ilP), this.kyp.getPreviewHeight());
        }
        AppMethodBeat.o(89252);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setFlashMode(int i2) {
        boolean z = true;
        AppMethodBeat.i(89253);
        this.kyB = i2;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = this.kyp;
        if (this.kyp == null || !this.kyp.dEO()) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.MMSightRecordViewImpl", "setFlashMode: %s, camera: %s, previewing: %s", objArr);
        if (this.kyp != null && this.kyp.dEO()) {
            bqM();
        }
        AppMethodBeat.o(89253);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void bqM() {
        AppMethodBeat.i(89254);
        Log.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", Integer.valueOf(this.kyB));
        switch (this.kyB) {
            case 1:
                this.kyp.ejE();
                AppMethodBeat.o(89254);
                return;
            case 2:
                this.kyp.ejF();
                AppMethodBeat.o(89254);
                return;
            case 3:
                this.kyp.ejG();
                break;
        }
        AppMethodBeat.o(89254);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final int getFlashMode() {
        return this.kyB;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setEnableDragZoom(boolean z) {
        this.kyE = z;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final float[] getSupportZoomMultiple() {
        if (this.kyO == null || this.kyO.mSize == 0) {
            return new float[0];
        }
        float[] fArr = new float[this.kyO.mSize];
        for (int i2 = 0; i2 < this.kyO.mSize; i2++) {
            fArr[i2] = (((float) this.kyO.Pi[i2]) * 1.0f) / 10.0f;
        }
        return fArr;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final boolean aD(float f2) {
        boolean z;
        AppMethodBeat.i(89255);
        List<Integer> ejC = this.kyp.ejC();
        if (!(this.kyO == null || this.kyO.mSize == 0)) {
            if (this.kyO.indexOfKey(Math.round(f2 * 10.0f)) >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int indexOf = ejC.indexOf(Integer.valueOf(this.kyO.ase(Math.round(f2 * 10.0f))));
                if (indexOf < 0) {
                    AppMethodBeat.o(89255);
                    return false;
                }
                this.kyp.QM(indexOf);
                AppMethodBeat.o(89255);
                return true;
            }
        }
        AppMethodBeat.o(89255);
        return false;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setEnableTouchFocus(boolean z) {
        this.kyF = z;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void bqN() {
        AppMethodBeat.i(89256);
        Log.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
        this.kyL = 0.5f;
        AppMethodBeat.o(89256);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void bqO() {
        AppMethodBeat.i(89257);
        Log.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
        this.kyL = 0.75f;
        AppMethodBeat.o(89257);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void setDisplayScreenSize(Size size) {
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final Bitmap getCurrentFramePicture() {
        byte[] bArr;
        byte[] bArr2;
        byte[] h2;
        byte[] bArr3;
        AppMethodBeat.i(89258);
        if (this.kyp != null && this.kyp.dEO()) {
            com.tencent.mm.plugin.mmsight.model.f fVar = this.kyp;
            if (fVar.ims != null) {
                fVar.imr = true;
                bArr = new byte[fVar.ims.length];
                System.arraycopy(fVar.ims, 0, bArr, 0, fVar.ims.length);
                fVar.imr = false;
            } else {
                bArr = null;
            }
            if (bArr != null) {
                int previewWidth = this.kyp.getPreviewWidth();
                int previewHeight = this.kyp.getPreviewHeight();
                if (this.kyp.zub) {
                    int previewWidth2 = (int) (((float) this.kyp.getPreviewWidth()) / this.ilP);
                    if (previewWidth2 < previewHeight) {
                        if (this.kyz || this.kyP != null) {
                            bArr3 = com.tencent.mm.plugin.mmsight.model.a.k.zwi.h(Integer.valueOf(((this.kyD.x * this.kyD.y) * 3) >> 1));
                        } else {
                            this.kyP = new byte[(((previewWidth * previewWidth2) * 3) >> 1)];
                            bArr3 = this.kyP;
                        }
                        if (this.kys == 1) {
                            SightVideoJNI.cropCameraDataLongEdgeCenterCrop(bArr, bArr3, previewHeight, this.kyD.x, previewWidth);
                        } else {
                            SightVideoJNI.cropCameraDataLongEdge(bArr, bArr3, previewHeight, this.kyD.x, previewWidth);
                        }
                        if (this.kyz) {
                            previewWidth2 = this.kyD.x;
                        }
                        this.kyK = true;
                        previewHeight = previewWidth2;
                    } else {
                        bArr3 = bArr;
                    }
                    bArr2 = bArr3;
                } else {
                    int i2 = (int) (((float) previewHeight) * this.ilP);
                    if (i2 < previewWidth) {
                        if (this.kyz || this.kyP != null) {
                            h2 = com.tencent.mm.plugin.mmsight.model.a.k.zwi.h(Integer.valueOf(((this.kyD.x * this.kyD.y) * 3) >> 1));
                        } else {
                            this.kyP = new byte[(((i2 * previewHeight) * 3) >> 1)];
                            h2 = this.kyP;
                        }
                        SightVideoJNI.cropCameraData(bArr, h2, previewHeight, previewWidth, this.kyD.y);
                        previewWidth = this.kyD.y;
                        this.kyK = true;
                        bArr2 = h2;
                    } else {
                        bArr2 = bArr;
                    }
                }
                YuvImage yuvImage = new YuvImage(bArr2, 17, previewHeight, previewWidth, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, previewHeight, previewWidth), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                Bitmap rotate = BitmapUtil.rotate(decodeByteArray, (float) this.kyp.getOrientation());
                Log.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", decodeByteArray);
                decodeByteArray.recycle();
                AppMethodBeat.o(89258);
                return rotate;
            }
        }
        AppMethodBeat.o(89258);
        return null;
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void release() {
        AppMethodBeat.i(89259);
        Log.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", this.kyp, this.kyo);
        if (this.kyp != null) {
            this.kyp.b(this);
            this.kyp.ejD();
        }
        if (this.kyo != null) {
            this.kyo.a(null);
            this.kyo.E(null);
            this.kyo = null;
        }
        if (this.kyM != null) {
            this.kyM.release();
        }
        if (this.kyO != null) {
            this.kyO.mSize = 0;
        }
        this.kyO = null;
        this.kyx = false;
        this.kyz = false;
        this.kyA = false;
        this.kyC = null;
        this.kyD = null;
        this.kyB = -1;
        this.kyE = true;
        this.kyF = true;
        this.kyG = false;
        com.tencent.mm.plugin.mmsight.model.a.k.zwi.aRR();
        AppMethodBeat.o(89259);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.g
    public final boolean ai(byte[] bArr) {
        byte[] bArr2;
        AppMethodBeat.i(89260);
        if (bArr == null) {
            AppMethodBeat.o(89260);
            return false;
        }
        if (this.kyJ != null && !this.kyG) {
            this.kyJ.bFX();
            this.kyG = true;
        }
        if (this.kyM != null) {
            this.kyM.E(bArr, getScreenRotation());
        }
        if (this.ilP <= 0.0f || this.kyq <= 0 || this.kyp == null) {
            bArr2 = bArr;
        } else {
            int previewWidth = this.kyp.getPreviewWidth();
            int previewHeight = this.kyp.getPreviewHeight();
            if (this.kyp.zub) {
                int previewWidth2 = (int) (((float) this.kyp.getPreviewWidth()) / this.ilP);
                if (previewWidth2 < previewHeight) {
                    if (this.kyz || this.kyP != null) {
                        bArr2 = com.tencent.mm.plugin.mmsight.model.a.k.zwi.h(Integer.valueOf(((this.kyD.x * this.kyD.y) * 3) >> 1));
                    } else {
                        this.kyP = new byte[(((previewWidth * previewWidth2) * 3) >> 1)];
                        bArr2 = this.kyP;
                    }
                    Util.currentTicks();
                    if (this.kys == 1) {
                        SightVideoJNI.cropCameraDataLongEdgeCenterCrop(bArr, bArr2, previewHeight, this.kyD.x, previewWidth);
                    } else {
                        SightVideoJNI.cropCameraDataLongEdge(bArr, bArr2, previewHeight, this.kyD.x, previewWidth);
                    }
                    if (this.kyz) {
                        previewWidth2 = this.kyD.x;
                    }
                    this.kyK = true;
                } else {
                    previewWidth2 = previewHeight;
                    bArr2 = bArr;
                }
                previewHeight = previewWidth2;
            } else {
                int i2 = (int) (((float) previewHeight) * this.ilP);
                if (i2 < previewWidth) {
                    if (this.kyz || this.kyP != null) {
                        bArr2 = com.tencent.mm.plugin.mmsight.model.a.k.zwi.h(Integer.valueOf(((this.kyD.x * this.kyD.y) * 3) >> 1));
                    } else {
                        this.kyP = new byte[(((i2 * previewHeight) * 3) >> 1)];
                        bArr2 = this.kyP;
                    }
                    Util.currentTicks();
                    SightVideoJNI.cropCameraData(bArr, bArr2, previewHeight, previewWidth, this.kyD.y);
                    int i3 = this.kyD.y;
                    this.kyK = true;
                    previewWidth = i3;
                } else {
                    bArr2 = bArr;
                }
            }
            if (this.kyw != null) {
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.kyw;
                int orientation = this.kyp.getOrientation();
                if (!(previewHeight == mMSightCameraGLSurfaceView.kxW && previewWidth == mMSightCameraGLSurfaceView.kxX && orientation == mMSightCameraGLSurfaceView.iqx)) {
                    Log.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", Integer.valueOf(previewHeight), Integer.valueOf(previewWidth), Integer.valueOf(orientation), mMSightCameraGLSurfaceView);
                    mMSightCameraGLSurfaceView.kxW = previewHeight;
                    mMSightCameraGLSurfaceView.kxX = previewWidth;
                    mMSightCameraGLSurfaceView.iqx = orientation;
                }
                int screenRotation = getScreenRotation();
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView2 = this.kyw;
                if (bArr2 == null || mMSightCameraGLSurfaceView2.kyg == null || mMSightCameraGLSurfaceView2.kyg.kxV) {
                    Log.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                } else {
                    a aVar = mMSightCameraGLSurfaceView2.kyg;
                    int i4 = mMSightCameraGLSurfaceView2.kxW;
                    int i5 = mMSightCameraGLSurfaceView2.kxX;
                    int i6 = mMSightCameraGLSurfaceView2.iqx;
                    boolean z = false;
                    try {
                        if (!(aVar.kxX == i5 && aVar.kxW == i4 && aVar.dYT == i6 && aVar.kyf == screenRotation)) {
                            z = true;
                        }
                        if (z) {
                            Log.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", bArr2, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(aVar.iqo), Boolean.TRUE, aVar);
                        }
                        aVar.frameData = bArr2;
                        aVar.kxW = i4;
                        aVar.kxX = i5;
                        aVar.dYT = i6;
                        aVar.kyf = screenRotation;
                        if (z) {
                            aVar.ikI = ByteBuffer.allocateDirect(i5 * i4);
                            aVar.ikP = ByteBuffer.allocateDirect((i4 * i5) / 2);
                            aVar.ikI.order(ByteOrder.nativeOrder());
                            aVar.ikP.order(ByteOrder.nativeOrder());
                            if (aVar.kyd != null) {
                                aVar.hDU.put(aVar.kyd);
                                aVar.hDU.position(0);
                            }
                        }
                        if (!(aVar.ikI == null || aVar.ikP == null)) {
                            aVar.ikI.put(bArr2, 0, i4 * i5);
                            aVar.ikI.position(0);
                            aVar.ikP.put(bArr2, i4 * i5, (i4 * i5) / 2);
                            aVar.ikP.position(0);
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", e2.getMessage());
                    }
                    mMSightCameraGLSurfaceView2.requestRender();
                }
            }
        }
        if (this.kyy != null) {
            Point previewSize = getPreviewSize();
            this.kyy.C(bArr, previewSize.x, previewSize.y);
        }
        boolean z2 = true;
        boolean z3 = false;
        if (!(this.kyo == null || this.kyo.getFrameDataCallback() == null)) {
            if (!this.kyz || !this.kyK) {
                z2 = this.kyo.getFrameDataCallback().ai(bArr);
            } else {
                z2 = this.kyo.getFrameDataCallback().ai(bArr2);
                z3 = true;
            }
        }
        if (z3 && (this.kyo == null || this.kyo.aQN() != d.c.Start)) {
            com.tencent.mm.plugin.mmsight.model.a.k.zwi.k(bArr2);
        }
        AppMethodBeat.o(89260);
        return z2;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.d.a
    public final void bqP() {
        AppMethodBeat.i(89261);
        Log.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", 1);
        this.kyo.reset();
        AppMethodBeat.o(89261);
    }

    @Override // com.tencent.mm.plugin.api.recordView.g.a
    public final void I(float f2, float f3) {
        AppMethodBeat.i(89262);
        if (this.kyp != null && this.kyp.dEO() && this.kyF) {
            this.kyp.ejB();
        }
        AppMethodBeat.o(89262);
    }

    @Override // com.tencent.mm.plugin.api.recordView.g.a
    public final void bqQ() {
        AppMethodBeat.i(89263);
        if (this.kyp != null && this.kyp.dEO() && this.kyE) {
            this.kyp.d(true, false, 1);
        }
        AppMethodBeat.o(89263);
    }

    @Override // com.tencent.mm.plugin.api.recordView.g.a
    public final void bqR() {
        AppMethodBeat.i(89264);
        if (this.kyp != null && this.kyp.dEO() && this.kyE) {
            this.kyp.d(false, false, 1);
        }
        AppMethodBeat.o(89264);
    }

    private int getScreenRotation() {
        AppMethodBeat.i(89265);
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) MMApplicationContext.getContext().getSystemService("window");
        }
        if (this.windowManager == null) {
            AppMethodBeat.o(89265);
            return 0;
        }
        switch (this.windowManager.getDefaultDisplay().getRotation()) {
            case 0:
                AppMethodBeat.o(89265);
                return 0;
            case 1:
                AppMethodBeat.o(89265);
                return 90;
            case 2:
                AppMethodBeat.o(89265);
                return TXLiveConstants.RENDER_ROTATION_180;
            case 3:
                AppMethodBeat.o(89265);
                return 270;
            default:
                AppMethodBeat.o(89265);
                return 0;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void a(final ByteBuffer byteBuffer, final MMSightRecordView.f fVar) {
        AppMethodBeat.i(89266);
        if (fVar == null && byteBuffer == null) {
            if (this.kyM != null) {
                this.kyM.release();
                this.kyM = null;
            }
            AppMethodBeat.o(89266);
            return;
        }
        if (this.kyM == null) {
            this.kyM = new h();
            bqS();
            this.kyM.kzb = new i.a() {
                /* class com.tencent.mm.plugin.api.recordView.f.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.api.recordView.i.a
                public final void bqT() {
                    AppMethodBeat.i(89225);
                    if (fVar != null) {
                        fVar.bGa();
                    }
                    AppMethodBeat.o(89225);
                }

                @Override // com.tencent.mm.plugin.api.recordView.i.a
                public final ByteBuffer getBuffer() {
                    return byteBuffer;
                }
            };
            this.kyM.b(this.kyw.getEglContext());
        }
        AppMethodBeat.o(89266);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
    public final void o(MotionEvent motionEvent) {
    }

    /* access modifiers changed from: package-private */
    public final void bqS() {
        AppMethodBeat.i(89267);
        Point previewSize = getPreviewSize();
        this.kyN.y = this.kyr;
        this.kyN.x = (previewSize.x * this.kyr) / previewSize.y;
        if (getScreenRotation() == 0 || getScreenRotation() == 180) {
            int i2 = this.kyN.y;
            this.kyN.y = this.kyN.x;
            this.kyN.x = i2;
        }
        if (this.kyM != null) {
            this.kyM.i(previewSize.x, previewSize.y, this.kyp.getOrientation(), this.kyN.x, this.kyN.y);
        }
        AppMethodBeat.o(89267);
    }
}
