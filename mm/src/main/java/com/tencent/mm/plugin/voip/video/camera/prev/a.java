package com.tencent.mm.plugin.voip.video.camera.prev;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.video.camera.a.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class a implements com.tencent.mm.plugin.video.a, b {
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
    protected ObservableSurfaceView HjQ = null;
    protected ObservableTextureView HjR;
    protected int[] HjS = null;
    protected int HjT = 0;
    protected boolean imy = true;
    protected int mHeight = 240;
    protected int mWidth = 320;
    protected v sZb;
    protected boolean sZd = false;
    protected long zNW = 30000;
    protected Camera.Parameters zNY;
    protected int zOa;
    protected boolean zOb = false;
    protected boolean zOc = false;
    protected boolean zOd = false;
    protected com.tencent.mm.plugin.voip.video.camera.a.b zOe;
    protected boolean zOf = false;
    protected boolean zOg = false;
    protected byte[] zOh = null;
    protected List<byte[]> zOi;
    protected int zOj;
    protected int zOk = 0;
    protected int zOl = 0;
    protected boolean zOm = false;
    private byte[] zOn = null;
    Camera.PreviewCallback zOo = new Camera.PreviewCallback() {
        /* class com.tencent.mm.plugin.voip.video.camera.prev.a.AnonymousClass2 */

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            int i2;
            boolean z;
            AppMethodBeat.i(235845);
            if (bArr == null || bArr.length <= 0) {
                h.INSTANCE.idkeyStat(159, 0, 1, false);
                h.INSTANCE.idkeyStat(159, 3, 1, false);
                if (a.this.zOe != null) {
                    a.this.zOe.cza();
                }
                AppMethodBeat.o(235845);
            } else if (a.this.HjP == null) {
                Log.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
                AppMethodBeat.o(235845);
            } else {
                if (a.this.zOe != null) {
                    if (a.this.zOn == null || a.this.zOn.length != bArr.length) {
                        a.this.zOn = new byte[bArr.length];
                    }
                    System.arraycopy(bArr, 0, a.this.zOn, 0, bArr.length);
                    int i3 = 1;
                    if (a.this.HjI) {
                        i2 = c.Hjz;
                        if (ae.gKt.gFF && ae.gKt.gFE.dYT != 0) {
                            i3 = ae.gKt.gFE.gGp;
                            z = true;
                        }
                        z = false;
                    } else {
                        i2 = c.HjA;
                        if (ae.gKt.gFH && ae.gKt.gFG.dYT != 0) {
                            i3 = ae.gKt.gFG.gGp;
                            z = true;
                        }
                        z = false;
                    }
                    int i4 = i2 > 0 ? 32 : 0;
                    a.this.HjJ = !z && i2 > 0;
                    int i5 = a.this.HjP.width;
                    int i6 = a.this.HjP.height;
                    if (!z || a.this.cyZ()) {
                        a.this.zOe.a(a.this.zOn, (long) a.this.zOn.length, a.this.HjP.width, a.this.HjP.height, a.this.zOa, i4);
                    } else {
                        if (a.this.zOh == null) {
                            a.this.zOh = new byte[(((i5 * i6) * 3) / 2)];
                            a.this.zOh[0] = 90;
                        }
                        com.tencent.mm.plugin.voip.c.fFg().a(a.this.zOn, a.this.zOn.length, i5, i6, a.this.zOa, a.this.zOh, a.this.zOh.length, i5, i6, i3);
                        a.this.zOe.a(a.this.zOh, (long) a.this.zOh.length, i5, i6, a.this.zOa, i4);
                    }
                    if (m.getApiLevel() >= 8) {
                        if (a.this.sZb == null) {
                            Log.e("MicroMsg.Voip.CaptureRender", "the camera is null and has been release");
                            AppMethodBeat.o(235845);
                            return;
                        } else if (a.this.sZb != null) {
                            a.this.sZb.addCallbackBuffer(bArr);
                        }
                    }
                }
                AppMethodBeat.o(235845);
            }
        }
    };

    static {
        AppMethodBeat.i(235865);
        AppMethodBeat.o(235865);
    }

    public a(int i2, int i3) {
        AppMethodBeat.i(235846);
        this.mWidth = i2;
        this.mHeight = i3;
        c.hH(MMApplicationContext.getContext().getApplicationContext());
        Log.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight));
        AppMethodBeat.o(235846);
    }

    public final void a(ObservableSurfaceView observableSurfaceView) {
        AppMethodBeat.i(235847);
        Log.d("MicroMsg.Voip.CaptureRender", "bind ObservableSurfaceView");
        if (observableSurfaceView == null) {
            AppMethodBeat.o(235847);
            return;
        }
        this.HjQ = observableSurfaceView;
        this.HjQ.setSurfaceChangeCallback(this);
        this.zOd = true;
        AppMethodBeat.o(235847);
    }

    public final void a(ObservableTextureView observableTextureView) {
        AppMethodBeat.i(235848);
        Log.i("MicroMsg.Voip.CaptureRender", "bind ObservableTextureView");
        if (observableTextureView == null) {
            AppMethodBeat.o(235848);
            return;
        }
        this.HjR = observableTextureView;
        this.HjR.setTextureChangeCallback(this);
        this.zOd = false;
        AppMethodBeat.o(235848);
    }

    public final boolean dEO() {
        return this.sZd;
    }

    @Override // com.tencent.mm.plugin.video.a
    public final void a(SurfaceHolder surfaceHolder) {
        boolean z = false;
        AppMethodBeat.i(235849);
        Log.d("MicroMsg.Voip.CaptureRender", "surfaceChange");
        if (!this.zOb || surfaceHolder.getSurface() == null) {
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.zOb);
            if (surfaceHolder.getSurface() == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Integer.valueOf(Build.VERSION.SDK_INT);
            Log.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed, CameraOpen: %b, surface: %b, apiLevel: %s", objArr);
            AppMethodBeat.o(235849);
            return;
        }
        try {
            if (!this.sZb.gIJ) {
                this.sZb.setPreviewCallback(null);
            }
            this.sZb.stopPreview();
            this.sZb.setPreviewDisplay(surfaceHolder);
            eoa();
            this.sZb.startPreview();
            this.sZd = true;
        } catch (Exception e2) {
            h.INSTANCE.idkeyStat(159, 0, 1, false);
            h.INSTANCE.idkeyStat(159, 2, 1, false);
            Log.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + e2.getMessage());
            this.HjO = 1;
        }
        if (this.zOg) {
            fLb();
            this.zOg = false;
        }
        if (!cyZ()) {
            com.tencent.mm.plugin.voip.c.fFg().adn(this.HjO);
        }
        AppMethodBeat.o(235849);
    }

    @Override // com.tencent.mm.plugin.video.b
    public final void f(SurfaceTexture surfaceTexture) {
        boolean z = false;
        AppMethodBeat.i(235850);
        Log.d("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable");
        if (!this.zOb || surfaceTexture == null) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.zOb);
            if (surfaceTexture == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            Log.e("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable failed, CameraOpen: %b, surface: %b", objArr);
            AppMethodBeat.o(235850);
            return;
        }
        try {
            if (!this.sZb.gIJ) {
                this.sZb.setPreviewCallback(null);
            }
            this.sZb.stopPreview();
            this.sZb.setPreviewTexture(surfaceTexture);
            eoa();
            this.sZb.startPreview();
            this.sZd = true;
        } catch (Exception e2) {
            h.INSTANCE.idkeyStat(159, 0, 1, false);
            h.INSTANCE.idkeyStat(159, 2, 1, false);
            Log.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + e2.getMessage());
            this.HjO = 1;
        }
        if (this.zOg) {
            fLb();
            this.zOg = false;
        }
        if (!cyZ()) {
            com.tencent.mm.plugin.voip.c.fFg().adn(this.HjO);
        }
        AppMethodBeat.o(235850);
    }

    public final int a(com.tencent.mm.plugin.voip.video.camera.a.b bVar, boolean z) {
        int h2;
        AppMethodBeat.i(235851);
        if (c.Hjw.gFx <= 0) {
            this.HjO = 1;
            AppMethodBeat.o(235851);
            return -1;
        }
        if (z) {
            if (!c.Hjw.HjX) {
                z = false;
            }
        } else if (!c.Hjw.HjY) {
            z = true;
        }
        this.zOe = bVar;
        if (h(z, this.mWidth, this.mHeight) > 0 || (h2 = h(z, this.mWidth, this.mHeight)) > 0) {
            eoa();
            this.HjO = 0;
            AppMethodBeat.o(235851);
            return 1;
        }
        this.HjO = 1;
        AppMethodBeat.o(235851);
        return h2;
    }

    private void eoa() {
        AppMethodBeat.i(235852);
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
                    AppMethodBeat.o(235852);
                    return;
                }
            }
            AppMethodBeat.o(235852);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", e2, "setPreviewCallback error: %s", e2.getMessage());
            AppMethodBeat.o(235852);
        }
    }

    private static v rP(boolean z) {
        d.a.C0301a a2;
        v vVar = null;
        AppMethodBeat.i(235853);
        if (c.Hjw.gFx <= 0) {
            AppMethodBeat.o(235853);
        } else if (!c.fLk()) {
            AppMethodBeat.o(235853);
        } else {
            if (z) {
                try {
                    a2 = d.a(MMApplicationContext.getContext(), c.Hjx, null);
                    Log.i("Camera", "Use front");
                } catch (Exception e2) {
                    h.INSTANCE.idkeyStat(159, 0, 1, false);
                    h.INSTANCE.idkeyStat(159, 1, 1, false);
                    Log.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + e2.toString());
                }
            } else {
                a2 = d.a(MMApplicationContext.getContext(), c.Hjy, null);
                Log.i("Camera", "Use back");
            }
            if (a2 != null) {
                vVar = a2.gGr;
            }
            AppMethodBeat.o(235853);
        }
        return vVar;
    }

    private v rO(boolean z) {
        AppMethodBeat.i(235854);
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
                AppMethodBeat.o(235854);
                return null;
            }
        } else {
            this.HjI = z;
        }
        h(rP);
        f(rP);
        AppMethodBeat.o(235854);
        return rP;
    }

    private static boolean a(v vVar, int i2, int i3) {
        AppMethodBeat.i(235855);
        if (vVar == null) {
            AppMethodBeat.o(235855);
            return false;
        }
        try {
            Camera.Parameters parameters = vVar.getParameters();
            if (i2 > 0 && i3 > 0) {
                parameters.setPreviewSize(i2, i3);
            }
            vVar.setParameters(parameters);
            AppMethodBeat.o(235855);
            return true;
        } catch (Exception e2) {
            h.INSTANCE.idkeyStat(159, 0, 1, false);
            Log.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + e2.toString());
            AppMethodBeat.o(235855);
            return false;
        }
    }

    private boolean b(v vVar, boolean z) {
        AppMethodBeat.i(235856);
        if (vVar == null) {
            AppMethodBeat.o(235856);
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
            AppMethodBeat.o(235856);
            return true;
        } catch (Exception e2) {
            h.INSTANCE.idkeyStat(159, 0, 1, false);
            Log.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + e2.toString());
            AppMethodBeat.o(235856);
            return false;
        }
    }

    private static Point a(CharSequence charSequence, Point point) {
        int i2;
        int i3;
        AppMethodBeat.i(235857);
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
            AppMethodBeat.o(235857);
            return null;
        }
        Point point2 = new Point(i3, i2);
        AppMethodBeat.o(235857);
        return point2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0476  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0505 A[Catch:{ Exception -> 0x05c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0526  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x053a A[Catch:{ Exception -> 0x0609 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x055e A[Catch:{ Exception -> 0x0609 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x05ec  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x05f0  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x05f3  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x05f7  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x05fb  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x05ff  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x023a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int h(boolean r21, int r22, int r23) {
        /*
        // Method dump skipped, instructions count: 1596
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.video.camera.prev.a.h(boolean, int, int):int");
    }

    public final void fLd() {
        AppMethodBeat.i(235859);
        if (c.Hjw.gFx < 2) {
            Log.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + c.Hjw.gFx);
            AppMethodBeat.o(235859);
            return;
        }
        Log.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + c.Hjw.gFx);
        eoc();
        a(this.zOe, !this.HjI);
        fLb();
        if (!cyZ()) {
            com.tencent.mm.plugin.voip.c.fFg().adn(this.HjO);
        }
        this.imy = true;
        AppMethodBeat.o(235859);
    }

    public final int fLb() {
        AppMethodBeat.i(235860);
        if (!this.zOb) {
            Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
            this.HjO = 1;
            AppMethodBeat.o(235860);
            return -1;
        } else if (this.zOf) {
            Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
            AppMethodBeat.o(235860);
            return -1;
        } else if (this.HjQ == null || this.HjQ.fAP()) {
            Log.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", Boolean.valueOf(this.zOd));
            if (this.HjQ != null && this.zOd) {
                try {
                    this.sZb.setPreviewDisplay(this.HjQ.getSurfaceHolder());
                } catch (Exception e2) {
                    h.INSTANCE.idkeyStat(159, 0, 1, false);
                    h.INSTANCE.idkeyStat(159, 2, 1, false);
                    this.HjO = 1;
                    Log.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e2.toString());
                }
            } else if (this.HjR != null && !this.zOd) {
                try {
                    this.sZb.setPreviewTexture(this.HjR.getSurfaceTexture());
                } catch (Exception e3) {
                    h.INSTANCE.idkeyStat(159, 0, 1, false);
                    h.INSTANCE.idkeyStat(159, 2, 1, false);
                    this.HjO = 1;
                    Log.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e3.toString());
                }
            }
            try {
                this.sZb.startPreview();
                this.sZd = true;
            } catch (Exception e4) {
                h.INSTANCE.idkeyStat(159, 0, 1, false);
                h.INSTANCE.idkeyStat(159, 2, 1, false);
                this.HjO = 1;
                if (this.zOe != null) {
                    this.zOe.cza();
                }
                Log.e("MicroMsg.Voip.CaptureRender", "startPreview:error" + e4.toString());
            }
            this.zOf = true;
            AppMethodBeat.o(235860);
            return 1;
        } else {
            Log.d("MicroMsg.Voip.CaptureRender", "StartCapture:surface not ready, try later.... ");
            this.zOg = true;
            AppMethodBeat.o(235860);
            return 0;
        }
    }

    public final void eoc() {
        AppMethodBeat.i(235861);
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
                this.sZb.setPreviewCallback(null);
                this.sZb.release();
            }
            this.sZb = null;
            this.zOb = false;
        } else if (this.sZb != null) {
            if (!this.sZb.gIJ) {
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
        AppMethodBeat.o(235861);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x017b A[Catch:{ Exception -> 0x020c }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019d A[Catch:{ Exception -> 0x020c }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01c8 A[Catch:{ Exception -> 0x020c }] */
    @android.annotation.TargetApi(14)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void N(int[] r12) {
        /*
        // Method dump skipped, instructions count: 553
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.video.camera.prev.a.N(int[]):void");
    }

    private int f(v vVar) {
        Exception e2;
        int i2;
        int i3;
        AppMethodBeat.i(235863);
        if (vVar == null) {
            AppMethodBeat.o(235863);
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
                        AppMethodBeat.o(235863);
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
                AppMethodBeat.o(235863);
                return i2;
            }
        } catch (Exception e5) {
            e2 = e5;
            i2 = 0;
            Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", e2, "", new Object[0]);
            AppMethodBeat.o(235863);
            return i2;
        }
        AppMethodBeat.o(235863);
        return i2;
    }

    private static void h(v vVar) {
        List<Integer> list;
        AppMethodBeat.i(235864);
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
        AppMethodBeat.o(235864);
    }

    public final boolean fLp() {
        return this.HjI;
    }

    public final boolean fKZ() {
        return this.HjJ;
    }

    public final int fLa() {
        return this.HjO;
    }

    public boolean cyZ() {
        return false;
    }

    public final ac fLc() {
        return this.HjP;
    }

    public final int aPv() {
        return this.zOj;
    }
}
