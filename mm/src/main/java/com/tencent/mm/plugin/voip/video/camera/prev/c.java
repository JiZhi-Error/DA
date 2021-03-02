package com.tencent.mm.plugin.voip.video.camera.prev;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.a.a;
import com.tencent.mm.plugin.voip.video.camera.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class c extends a {
    private static int irq = 20;
    private static int irs = 70;
    private static final Pattern zOp = Pattern.compile(",");
    protected boolean HjI = false;
    protected boolean HjJ = false;
    protected boolean HjK = false;
    protected boolean HjL = false;
    protected boolean HjM = false;
    protected long HjN = 0;
    protected int HjO = 0;
    protected ac HjP;
    protected int[] HjS = null;
    protected int HjT = 0;
    private int Hkd = 0;
    protected boolean imy = true;
    protected int mHeight = 240;
    SurfaceTexture mSurfaceTexture;
    protected int mWidth = 320;
    protected volatile v sZb;
    protected boolean sZd = false;
    protected long zNW = 30000;
    protected Camera.Parameters zNY;
    protected int zOa;
    protected boolean zOb = false;
    protected boolean zOc = false;
    protected boolean zOd = false;
    protected b zOe;
    public boolean zOf = false;
    protected boolean zOg = false;
    protected byte[] zOh = null;
    protected List<byte[]> zOi;
    private int zOj = 0;
    protected int zOk = 0;
    protected int zOl = 0;
    protected boolean zOm = false;
    private byte[] zOn = null;
    Camera.PreviewCallback zOo = new Camera.PreviewCallback() {
        /* class com.tencent.mm.plugin.voip.video.camera.prev.c.AnonymousClass1 */

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            int i2;
            boolean z;
            AppMethodBeat.i(235870);
            if (bArr == null || bArr.length <= 0) {
                h.INSTANCE.idkeyStat(159, 0, 1, false);
                h.INSTANCE.idkeyStat(159, 3, 1, false);
                if (c.this.zOe != null) {
                    c.this.zOe.cza();
                }
                AppMethodBeat.o(235870);
            } else if (c.this.HjP == null) {
                Log.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
                AppMethodBeat.o(235870);
            } else {
                if (c.this.zOe != null) {
                    if (c.this.zOn == null || c.this.zOn.length != bArr.length) {
                        c.this.zOn = new byte[bArr.length];
                    }
                    System.arraycopy(bArr, 0, c.this.zOn, 0, bArr.length);
                    int i3 = 1;
                    if (c.this.HjI) {
                        i2 = com.tencent.mm.plugin.voip.video.camera.a.c.Hjz;
                        if (ae.gKt.gFF && ae.gKt.gFE.dYT != 0) {
                            i3 = ae.gKt.gFE.gGp;
                            z = true;
                        }
                        z = false;
                    } else {
                        i2 = com.tencent.mm.plugin.voip.video.camera.a.c.HjA;
                        if (ae.gKt.gFH && ae.gKt.gFG.dYT != 0) {
                            i3 = ae.gKt.gFG.gGp;
                            z = true;
                        }
                        z = false;
                    }
                    int i4 = i2 > 0 ? 32 : 0;
                    c.this.HjJ = !z && i2 > 0;
                    if (c.this.zOj != 90) {
                        c.this.HjJ = false;
                    }
                    int i5 = c.this.HjP.width;
                    int i6 = c.this.HjP.height;
                    if (z) {
                        if (c.this.zOh == null) {
                            c.this.zOh = new byte[(((i5 * i6) * 3) / 2)];
                            c.this.zOh[0] = 90;
                        }
                        com.tencent.mm.plugin.voip.c.fFg().a(c.this.zOn, c.this.zOn.length, i5, i6, c.this.zOa, c.this.zOh, c.this.zOh.length, i5, i6, i3);
                        c.this.zOe.a(c.this.zOh, (long) c.this.zOh.length, i5, i6, c.this.zOa, i4);
                    } else {
                        c.this.zOe.a(c.this.zOn, (long) c.this.zOn.length, c.this.HjP.width, c.this.HjP.height, c.this.zOa, i4);
                    }
                    if (m.getApiLevel() >= 8) {
                        if (c.this.sZb == null) {
                            Log.e("MicroMsg.Voip.CaptureRender", "the camera is null and has been release");
                            AppMethodBeat.o(235870);
                            return;
                        } else if (c.this.sZb != null) {
                            c.this.sZb.addCallbackBuffer(bArr);
                        }
                    }
                }
                AppMethodBeat.o(235870);
            }
        }
    };

    static {
        AppMethodBeat.i(235887);
        AppMethodBeat.o(235887);
    }

    public c(int i2, int i3) {
        AppMethodBeat.i(235871);
        this.mWidth = i2;
        this.mHeight = i3;
        com.tencent.mm.plugin.voip.video.camera.a.c.hH(MMApplicationContext.getContext().getApplicationContext());
        Log.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight));
        AppMethodBeat.o(235871);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final void q(SurfaceTexture surfaceTexture) {
        this.mSurfaceTexture = surfaceTexture;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final boolean dEO() {
        return this.sZd;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final boolean fKY() {
        return this.HjI;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final int a(b bVar, boolean z) {
        int h2;
        AppMethodBeat.i(235872);
        if (com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx <= 0) {
            this.HjO = 1;
            AppMethodBeat.o(235872);
            return -1;
        }
        if (z) {
            if (!com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.HjX) {
                z = false;
            }
        } else if (!com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.HjY) {
            z = true;
        }
        this.zOe = bVar;
        if (h(z, this.mWidth, this.mHeight) > 0 || (h2 = h(z, this.mWidth, this.mHeight)) > 0) {
            this.HjI = z;
            if (!g.fKg()) {
                try {
                    if (this.sZb != null && this.zOb) {
                        if (this.HjP == null || this.HjP.height <= 0 || this.HjP.width <= 0) {
                            this.sZb.setPreviewCallback(this.zOo);
                        } else {
                            int i2 = ((this.HjP.height * this.HjP.width) * 3) / 2;
                            if (this.zOi == null) {
                                this.zOi = new ArrayList(3);
                                for (int i3 = 0; i3 < 3; i3++) {
                                    this.zOi.add(new byte[i2]);
                                }
                            }
                            for (int i4 = 0; i4 < this.zOi.size(); i4++) {
                                if (this.sZb != null) {
                                    this.sZb.addCallbackBuffer(this.zOi.get(i4));
                                }
                            }
                            this.sZb.setPreviewCallbackWithBuffer(this.zOo);
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", e2, "setPreviewCallback error: %s", e2.getMessage());
                }
            } else {
                j.fKE();
            }
            this.HjO = 0;
            AppMethodBeat.o(235872);
            return 1;
        }
        this.HjO = 1;
        AppMethodBeat.o(235872);
        return h2;
    }

    private static v rP(boolean z) {
        d.a.C0301a a2;
        v vVar = null;
        AppMethodBeat.i(235873);
        if (com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx <= 0) {
            AppMethodBeat.o(235873);
        } else if (!com.tencent.mm.plugin.voip.video.camera.a.c.fLk()) {
            AppMethodBeat.o(235873);
        } else {
            if (z) {
                try {
                    a2 = d.a(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.c.Hjx, null);
                    Log.i("Camera", "Use front");
                } catch (Exception e2) {
                    h.INSTANCE.idkeyStat(159, 0, 1, false);
                    h.INSTANCE.idkeyStat(159, 1, 1, false);
                    Log.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + e2.toString());
                }
            } else {
                a2 = d.a(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.c.Hjy, null);
                Log.i("Camera", "Use back");
            }
            if (a2 != null) {
                vVar = a2.gGr;
            }
            AppMethodBeat.o(235873);
        }
        return vVar;
    }

    private v rO(boolean z) {
        AppMethodBeat.i(235874);
        v rP = rP(z);
        if (rP == null) {
            try {
                rP = new v(Camera.open());
                this.HjI = false;
                h.INSTANCE.idkeyStat(159, 0, 1, false);
            } catch (Exception e2) {
                Log.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:" + e2.toString());
                h.INSTANCE.idkeyStat(159, 0, 1, false);
                h.INSTANCE.idkeyStat(159, 1, 1, false);
                if (this.zOe != null) {
                    this.zOe.cza();
                }
                AppMethodBeat.o(235874);
                return null;
            }
        } else {
            this.HjI = z;
        }
        h(rP);
        f(rP);
        AppMethodBeat.o(235874);
        return rP;
    }

    private boolean a(v vVar, int i2, int i3) {
        AppMethodBeat.i(235875);
        if (vVar == null) {
            AppMethodBeat.o(235875);
            return false;
        }
        try {
            Camera.Parameters parameters = vVar.getParameters();
            if (i2 > 0 && i3 > 0) {
                parameters.setPreviewSize(i2, i3);
            }
            vVar.setParameters(parameters);
            this.zOe.fs(i2, i3);
            AppMethodBeat.o(235875);
            return true;
        } catch (Exception e2) {
            h.INSTANCE.idkeyStat(159, 0, 1, false);
            Log.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + e2.toString());
            AppMethodBeat.o(235875);
            return false;
        }
    }

    private boolean b(v vVar, boolean z) {
        AppMethodBeat.i(235876);
        if (vVar == null) {
            AppMethodBeat.o(235876);
            return false;
        }
        try {
            Log.i("MicroMsg.Voip.CaptureRender", "trySetAutoFocus, isFrontCamera:%s", Boolean.valueOf(z));
            Camera.Parameters parameters = vVar.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                Log.i("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + supportedFocusModes.size());
                for (String str : supportedFocusModes) {
                    Log.i("MicroMsg.Voip.CaptureRender", "supported focus modes : ".concat(String.valueOf(str)));
                }
                if (ae.gKt.gGg != 0 || !z) {
                    if (ae.gKt.gGg == 1 || !z) {
                        if (supportedFocusModes.contains("continuous-video")) {
                            Log.i("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                            parameters.setFocusMode("continuous-video");
                            this.zOc = true;
                        } else if (supportedFocusModes.contains("auto")) {
                            Log.i("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                            parameters.setFocusMode("auto");
                            this.zOc = false;
                        }
                    }
                } else if (supportedFocusModes.contains("auto")) {
                    Log.i("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                    parameters.setFocusMode("auto");
                    this.zOc = false;
                } else if (supportedFocusModes.contains("continuous-video")) {
                    Log.i("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                    parameters.setFocusMode("continuous-video");
                    this.zOc = true;
                }
                vVar.setParameters(parameters);
            }
            AppMethodBeat.o(235876);
            return true;
        } catch (Exception e2) {
            h.INSTANCE.idkeyStat(159, 0, 1, false);
            Log.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + e2.toString());
            AppMethodBeat.o(235876);
            return false;
        }
    }

    private static Point a(CharSequence charSequence, Point point) {
        int i2;
        int i3;
        AppMethodBeat.i(235877);
        int i4 = Integer.MAX_VALUE;
        String[] split = zOp.split(charSequence);
        int length = split.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i5 >= length) {
                i2 = i6;
                i3 = i7;
                break;
            }
            String trim = split[i5].trim();
            int indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                Log.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: ".concat(String.valueOf(trim)));
            } else {
                try {
                    i3 = Util.getInt(trim.substring(0, indexOf), 0);
                    i2 = Util.getInt(trim.substring(indexOf + 1), 0);
                    int abs = Math.abs(i3 - point.x) + Math.abs(i2 - point.y);
                    if (abs == 0) {
                        break;
                    } else if (abs < i4 && i3 != i2) {
                        i4 = abs;
                        i6 = i2;
                        i7 = i3;
                    }
                } catch (NumberFormatException e2) {
                    Log.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: ".concat(String.valueOf(trim)));
                }
            }
            i5++;
        }
        if (i3 <= 0 || i2 <= 0) {
            AppMethodBeat.o(235877);
            return null;
        }
        Point point2 = new Point(i3, i2);
        AppMethodBeat.o(235877);
        return point2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x047a  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x050b A[Catch:{ Exception -> 0x0590 }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x052d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x023a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int h(boolean r21, int r22, int r23) {
        /*
        // Method dump skipped, instructions count: 1525
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.video.camera.prev.c.h(boolean, int, int):int");
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final void fLg() {
        AppMethodBeat.i(235879);
        try {
            if (this.sZb != null) {
                i(this.sZb);
            }
            AppMethodBeat.o(235879);
        } catch (Exception e2) {
            Log.e("MicroMsg.Voip.CaptureRender", "setDisplayOrientation failed: %s", e2.getMessage());
            AppMethodBeat.o(235879);
        }
    }

    private void i(v vVar) {
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        AppMethodBeat.i(235880);
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.HjI ? com.tencent.mm.plugin.voip.video.camera.a.c.Hjx : com.tencent.mm.plugin.voip.video.camera.a.c.Hjy, cameraInfo);
        switch (this.Hkd) {
            case 0:
                i2 = 0;
                break;
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = TXLiveConstants.RENDER_ROTATION_180;
                break;
            case 3:
                i2 = 270;
                break;
            default:
                i2 = 0;
                break;
        }
        if (this.HjI) {
            i3 = (360 - ((i2 + cameraInfo.orientation) % v2helper.VOIP_ENC_HEIGHT_LV1)) % v2helper.VOIP_ENC_HEIGHT_LV1;
        } else {
            i3 = ((cameraInfo.orientation - i2) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        }
        vVar.setDisplayOrientation(i3);
        this.zOj = i3;
        Log.i("MicroMsg.Voip.CaptureRender", "mIsCurrentFaceCamera is %s, %s,%s,%s,%s", Integer.valueOf(this.Hkd), Integer.valueOf(cameraInfo.orientation), Integer.valueOf(i3), Boolean.valueOf(this.HjI), Integer.valueOf(this.zOj));
        if (this.HjI) {
            i4 = com.tencent.mm.plugin.voip.video.camera.a.c.Hjz;
            if (ae.gKt.gFF && ae.gKt.gFE.dYT != 0) {
                z = true;
            }
            z = false;
        } else {
            i4 = com.tencent.mm.plugin.voip.video.camera.a.c.HjA;
            if (ae.gKt.gFH && ae.gKt.gFG.dYT != 0) {
                z = true;
            }
            z = false;
        }
        if (z || i4 <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.HjJ = z2;
        if (this.zOj != 90 && z) {
            this.HjJ = false;
        }
        AppMethodBeat.o(235880);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final void fLd() {
        AppMethodBeat.i(235881);
        if (com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx < 2) {
            Log.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx);
            AppMethodBeat.o(235881);
            return;
        }
        Log.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx);
        eoc();
        a(this.zOe, !this.HjI);
        fLb();
        com.tencent.mm.plugin.voip.c.fFg().adn(this.HjO);
        this.imy = true;
        AppMethodBeat.o(235881);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final int fLb() {
        AppMethodBeat.i(235882);
        if (!this.zOb) {
            Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
            this.HjO = 1;
            AppMethodBeat.o(235882);
            return -1;
        } else if (this.zOf) {
            Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
            AppMethodBeat.o(235882);
            return -1;
        } else {
            Log.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", Boolean.valueOf(this.zOd));
            if (this.mSurfaceTexture != null) {
                try {
                    this.sZb.setPreviewTexture(this.mSurfaceTexture);
                } catch (Exception e2) {
                    h.INSTANCE.idkeyStat(159, 0, 1, false);
                    h.INSTANCE.idkeyStat(159, 2, 1, false);
                    this.HjO = 1;
                    Log.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e2.toString());
                }
            }
            try {
                this.sZb.startPreview();
                this.sZd = true;
            } catch (Exception e3) {
                h.INSTANCE.idkeyStat(159, 0, 1, false);
                h.INSTANCE.idkeyStat(159, 2, 1, false);
                this.HjO = 1;
                if (this.zOe != null) {
                    this.zOe.cza();
                }
                Log.e("MicroMsg.Voip.CaptureRender", "startPreview:error" + e3.toString());
            }
            if (!g.fKg() && this.sZb != null) {
                this.sZb.setPreviewCallback(this.zOo);
            }
            this.zOf = true;
            AppMethodBeat.o(235882);
            return 1;
        }
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final ac fLc() {
        return this.HjP;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final int fLe() {
        int i2;
        boolean z;
        boolean z2 = true;
        if (this.HjI) {
            i2 = com.tencent.mm.plugin.voip.video.camera.a.c.Hjz;
            if (ae.gKt.gFF && ae.gKt.gFE.dYT != 0) {
                z = true;
            }
            z = false;
        } else {
            i2 = com.tencent.mm.plugin.voip.video.camera.a.c.HjA;
            if (ae.gKt.gFH && ae.gKt.gFG.dYT != 0) {
                z = true;
            }
            z = false;
        }
        if (z || i2 <= 0) {
            z2 = false;
        }
        this.HjJ = z2;
        if ((this.HjJ ? OpenGlRender.FLAG_Angle270 : OpenGlRender.FLAG_Angle90) == OpenGlRender.FLAG_Angle270) {
            return 90;
        }
        return 270;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final boolean fLf() {
        int i2;
        if (this.HjI) {
            i2 = OpenGlRender.FLAG_Mirror;
        } else {
            i2 = 0;
        }
        if (i2 == OpenGlRender.FLAG_Mirror) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final void eoc() {
        AppMethodBeat.i(235883);
        Log.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.zOf);
        if (this.zOf && this.sZb != null) {
            this.zOg = false;
            if (!this.sZb.gIJ) {
                this.sZb.setPreviewCallback(null);
            }
            try {
                this.sZb.stopPreview();
                this.sZd = false;
            } catch (Exception e2) {
                Log.e("MicroMsg.Voip.CaptureRender", "stopPreview:error" + e2.toString());
            }
            this.zOf = false;
        }
        if (1 == this.HjO) {
            pl plVar = new pl();
            plVar.dVC.type = 2;
            EventCenter.instance.publish(plVar);
        }
        Log.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.zOb);
        if (this.zOb) {
            this.HjO = 0;
            this.zOg = false;
            if (this.sZb != null && !this.sZb.gIJ) {
                if (!g.fKg() && !this.sZb.gIJ) {
                    this.sZb.setPreviewCallback(null);
                }
                this.sZb.release();
            }
            this.sZb = null;
            this.zOb = false;
        } else if (this.sZb != null) {
            if (!g.fKg() && !this.sZb.gIJ) {
                this.sZb.setPreviewCallback(null);
            }
            this.sZb.release();
            this.sZb = null;
            this.zOb = false;
        }
        this.zOh = null;
        if (this.zOi != null) {
            this.zOi.clear();
        }
        this.zOi = null;
        this.zOc = false;
        AppMethodBeat.o(235883);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    @TargetApi(14)
    public final void fLi() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(235884);
        if (ae.gKt.gGg != 1 || !this.zOc) {
            if (ae.gKt.gGf > 2000) {
                this.zNW = (long) ae.gKt.gGf;
            }
            Log.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
            boolean z3 = System.currentTimeMillis() - this.HjN > this.zNW;
            StringBuilder sb = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
            if (!this.HjK) {
                z = true;
            } else {
                z = false;
            }
            StringBuilder append = sb.append(z).append(",isAutoFocusTimeout: ").append(z3).append(",mAutoFocusTimeOut:").append(this.zNW).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
            if (this.HjL == this.HjI) {
                z2 = false;
            }
            Log.i("MicroMsg.Voip.CaptureRender", append.append(z2).append(",isClickScreen :true").toString());
            try {
                if (!(this.sZb == null || this.sZb.getParameters() == null || this.sZb.getParameters().getFocusMode() == null || !this.sZb.getParameters().getFocusMode().equals("auto"))) {
                    this.sZb.autoFocus(null);
                    this.HjS = null;
                    this.HjN = System.currentTimeMillis();
                    this.HjK = true;
                    this.HjL = this.HjI;
                }
                AppMethodBeat.o(235884);
            } catch (Exception e2) {
                Log.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + e2.toString());
                AppMethodBeat.o(235884);
            }
        } else {
            AppMethodBeat.o(235884);
        }
    }

    private int f(v vVar) {
        Exception e2;
        int i2;
        int i3;
        AppMethodBeat.i(235885);
        if (vVar == null) {
            AppMethodBeat.o(235885);
            return 0;
        }
        try {
            List<Camera.Size> supportedPreviewSizes = vVar.getParameters().getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                i3 = 0;
            } else {
                int i4 = 0;
                for (Camera.Size size : supportedPreviewSizes) {
                    try {
                        Log.d("MicroMsg.Voip.CaptureRender", "support Size:" + size.width + "," + size.height);
                        if (i4 == 0) {
                            this.zOk = size.width;
                            this.zOl = size.height;
                        }
                        i4++;
                    } catch (Exception e3) {
                        e2 = e3;
                        i2 = i4;
                        Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", e2, "", new Object[0]);
                        AppMethodBeat.o(235885);
                        return i2;
                    }
                }
                i3 = i4;
            }
            try {
                List<Integer> supportedPreviewFormats = vVar.getParameters().getSupportedPreviewFormats();
                if (!(supportedPreviewFormats == null || supportedPreviewFormats.size() == 0)) {
                    for (Integer num : supportedPreviewFormats) {
                        Log.i("MicroMsg.Voip.CaptureRender", "support Format:".concat(String.valueOf(num.intValue())));
                    }
                }
                i2 = i3;
            } catch (Exception e4) {
                e2 = e4;
                i2 = i3;
                Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", e2, "", new Object[0]);
                AppMethodBeat.o(235885);
                return i2;
            }
        } catch (Exception e5) {
            e2 = e5;
            i2 = 0;
            Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", e2, "", new Object[0]);
            AppMethodBeat.o(235885);
            return i2;
        }
        AppMethodBeat.o(235885);
        return i2;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final void onOrientationChange(int i2) {
        this.Hkd = i2;
    }

    private static void h(v vVar) {
        List<Integer> list;
        AppMethodBeat.i(235886);
        try {
            list = vVar.getParameters().getSupportedPreviewFrameRates();
        } catch (Exception e2) {
            Log.d("MicroMsg.Voip.CaptureRender", "getSupportedPreviewFrameRates:error:" + e2.toString());
            list = null;
        }
        String str = "supportFps:";
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                str = str + list.get(i2).intValue() + ",";
            }
        }
        Log.i("MicroMsg.Voip.CaptureRender", str);
        AppMethodBeat.o(235886);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final boolean fKZ() {
        return this.HjJ;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final int fLa() {
        return this.HjO;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.a
    public final int fLh() {
        return this.zOj;
    }
}
