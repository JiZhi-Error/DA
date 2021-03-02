package com.tencent.mm.plugin.mmsight.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.a.l;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class f implements SensorEventListener {
    protected static int ztL = Integer.MAX_VALUE;
    static boolean zud = true;
    protected boolean aYc = false;
    protected v gGr = null;
    protected boolean ilM = true;
    protected q ilR = q.ejT();
    protected Size ilU = null;
    protected Point ilV = null;
    protected int ilW = -1;
    protected int ilX = -1;
    protected List<g> imj = new ArrayList();
    protected d.a.C0301a imk;
    Camera.AutoFocusCallback iml = new Camera.AutoFocusCallback() {
        /* class com.tencent.mm.plugin.mmsight.model.f.AnonymousClass2 */

        public final void onAutoFocus(boolean z, Camera camera) {
            AppMethodBeat.i(89362);
            Log.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", Boolean.valueOf(z), f.this.ztY);
            f.zud = true;
            AppMethodBeat.o(89362);
        }
    };
    private c imm = new c("prevcameraCallback");
    private c imn = new c("cameraCallback");
    private c imo = new c("cameraPreviewCallback");
    private c imp = new c("cameraCropCallback");
    private c imq = new c("finishCallbackTimeCallback");
    public volatile boolean imr = false;
    public volatile byte[] ims = null;
    protected Context mContext = null;
    protected SensorManager mSensorManager;
    private int scene = 0;
    protected boolean ztI = false;
    protected boolean ztJ = false;
    protected int ztK = 0;
    protected Sensor ztM;
    protected float ztN = 0.0f;
    protected float ztO = 0.0f;
    protected float ztP = 0.0f;
    protected Point ztQ = null;
    protected Point ztR = null;
    protected int ztS = 0;
    protected byte[] ztT;
    protected boolean ztU = false;
    protected com.tencent.mm.plugin.base.model.a ztV = new com.tencent.mm.plugin.base.model.a();
    protected boolean ztW = false;
    protected boolean ztX = false;
    private a ztY = a.Preview;
    private c ztZ = new c("mirrorCameraCallback");
    protected VideoTransPara zua;
    public boolean zub = false;
    private boolean zuc = false;
    public c zue = new c(Looper.getMainLooper());

    public interface b {
        void a(byte[] bArr, int i2, int i3, int i4, int i5);
    }

    public enum a {
        Preview,
        Recording,
        Stoping;

        public static a valueOf(String str) {
            AppMethodBeat.i(89365);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(89365);
            return aVar;
        }

        static {
            AppMethodBeat.i(89366);
            AppMethodBeat.o(89366);
        }
    }

    public f(VideoTransPara videoTransPara, int i2) {
        AppMethodBeat.i(89371);
        this.zua = videoTransPara;
        this.scene = i2;
        AppMethodBeat.o(89371);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(89372);
        if (gVar != null) {
            this.imj.add(gVar);
        }
        AppMethodBeat.o(89372);
    }

    public final void b(g gVar) {
        AppMethodBeat.i(89373);
        if (gVar != null) {
            this.imj.remove(gVar);
        }
        AppMethodBeat.o(89373);
    }

    public final void a(a aVar) {
        int i2;
        AppMethodBeat.i(89374);
        this.ztY = aVar;
        if (aVar == a.Stoping) {
            b ejt = b.ejt();
            String ejv = this.imn.ejv();
            String ejv2 = this.imm.ejv();
            com.tencent.mm.plugin.base.model.a aVar2 = this.ztV;
            if (aVar2.pde == 0) {
                i2 = 0;
            } else {
                i2 = aVar2.pdd / aVar2.pde;
            }
            ejt.ztr = (int) (Util.safeParseDouble(ejv) * 10.0d);
            ejt.zts = (int) (Util.safeParseDouble(ejv2) * 10.0d);
            ejt.ztx = i2;
        }
        AppMethodBeat.o(89374);
    }

    private void ejx() {
        AppMethodBeat.i(89375);
        try {
            if (!(this.mSensorManager == null || this.ztM == null)) {
                this.mSensorManager.unregisterListener(this);
            }
            Log.i("MicroMsg.MMSightCamera", this.imm.getValue());
            Log.i("MicroMsg.MMSightCamera", this.imn.getValue());
            Log.i("MicroMsg.MMSightCamera", this.imo.getValue());
            Log.i("MicroMsg.MMSightCamera", this.imp.getValue());
            Log.i("MicroMsg.MMSightCamera", this.ztZ.getValue());
            Log.i("MicroMsg.MMSightCamera", this.imq.getValue());
            if (this.gGr != null) {
                long currentTicks = Util.currentTicks();
                Log.i("MicroMsg.MMSightCamera", "release camera beg, %s", Looper.myLooper());
                this.zue.removeCallbacksAndMessages(null);
                this.zue.imv = true;
                this.gGr.setPreviewCallback(null);
                this.gGr.stopPreview();
                this.gGr.release();
                this.gGr = null;
                this.ztJ = false;
                Log.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", Long.valueOf(Util.ticksToNow(currentTicks)), Looper.myLooper());
            }
            this.ztI = false;
            this.ztN = 0.0f;
            this.ztO = 0.0f;
            this.ztP = 0.0f;
            zud = true;
            this.mContext = null;
            this.zuc = false;
            this.ztR = null;
            this.ilV = null;
            this.ims = null;
            this.ztX = false;
            AppMethodBeat.o(89375);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMSightCamera", e2, "cameraRelease error", new Object[0]);
            AppMethodBeat.o(89375);
        }
    }

    private boolean a(v vVar, boolean z, int i2) {
        boolean z2;
        boolean z3;
        int i3;
        AppMethodBeat.i(241181);
        if (vVar == null) {
            AppMethodBeat.o(241181);
            return false;
        }
        try {
            Camera.Parameters parameters = vVar.getParameters();
            Point gx = this.ilU == null ? com.tencent.mm.plugin.mmsight.d.gx(this.mContext) : new Point(this.ilU.getWidth(), this.ilU.getHeight());
            if (this.ilM) {
                b ejt = b.ejt();
                List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
                int i4 = this.imk.dYT;
                if (Util.isNullOrNil(ejt.zth)) {
                    ejt.zth = com.tencent.mm.plugin.mmsight.d.fx(supportedPreviewSizes);
                }
                if (Util.isNullOrNil(ejt.zti)) {
                    ejt.zti = com.tencent.mm.plugin.mmsight.d.fx(supportedPictureSizes);
                }
                ejt.dYT = i4;
                ejt.ztC = 1;
            } else {
                b ejt2 = b.ejt();
                List<Camera.Size> supportedPreviewSizes2 = parameters.getSupportedPreviewSizes();
                List<Camera.Size> supportedPictureSizes2 = parameters.getSupportedPictureSizes();
                int i5 = this.imk.dYT;
                if (Util.isNullOrNil(ejt2.ztj)) {
                    ejt2.ztj = com.tencent.mm.plugin.mmsight.d.fx(supportedPreviewSizes2);
                }
                if (Util.isNullOrNil(ejt2.ztk)) {
                    ejt2.ztk = com.tencent.mm.plugin.mmsight.d.fx(supportedPictureSizes2);
                }
                ejt2.dYT = i5;
                ejt2.ztC = 2;
            }
            if (z) {
                k.a(parameters, this.imk.dYT == 90 || this.imk.dYT == 270);
            }
            l.ekc();
            int ekf = l.ekf();
            if (this.imk.dYT == 90 || this.imk.dYT == 270) {
                z2 = true;
            } else {
                z2 = false;
            }
            h.c a2 = h.a(parameters, gx, ekf, z2);
            if (a2 == null || a2.zum == null) {
                Log.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
                a2 = h.d(parameters, new Point(Math.min(gx.x, gx.y), Math.max(gx.x, gx.y)), 2100, this.imk.dYT == 90 || this.imk.dYT == 270);
                this.zub = false;
            }
            k.a(a2);
            Point point = a2.zum;
            if (point == null) {
                l.ejN();
                AppMethodBeat.o(241181);
                return false;
            }
            this.ilR.sUz = point.x;
            this.ilR.sUA = point.y;
            this.ztR = point;
            boolean a3 = com.tencent.mm.plugin.mmsight.d.a(this.mContext, point, this.imk.dYT == 90 || this.imk.dYT == 270);
            boolean z4 = true;
            if (this.imk.dYT == 90 || this.imk.dYT == 270) {
                if (point.y < this.zua.width || point.x < this.zua.height) {
                    z4 = false;
                    Log.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", point);
                }
            } else if (point.x < this.zua.width || point.y < this.zua.height) {
                z4 = false;
                Log.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", point);
            }
            Log.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", Boolean.valueOf(a3));
            if (a3) {
                if (k.zuy.gIP == 2) {
                    this.ilV = a2.zuo;
                    if (this.ilV.x < point.x || this.ilV.y < point.y) {
                        if (this.imk.dYT == 90 || this.imk.dYT == 270) {
                            this.ilV.y = com.tencent.mm.plugin.mmsight.d.QK(this.ilV.y);
                        } else {
                            this.ilV.x = com.tencent.mm.plugin.mmsight.d.QK(this.ilV.x);
                        }
                    }
                } else {
                    this.ilV = a2.zun;
                }
                this.ztR = new Point(this.ilV.x, this.ilV.y);
                this.ztS = ((this.ilV.x * this.ilV.y) * 3) / 2;
                Log.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", this.ilV);
                z3 = a3;
            } else {
                if (k.zuy.zuL && k.zuy.ilT == 1080 && z4) {
                    if (this.imk.dYT == 90 || this.imk.dYT == 270) {
                        int i6 = point.y / 2;
                        int QJ = com.tencent.mm.plugin.mmsight.d.QJ(i6);
                        int i7 = point.x / 2;
                        int QJ2 = com.tencent.mm.plugin.mmsight.d.QJ(i7);
                        if (Math.abs(QJ - i6) >= 8 || Math.abs(QJ2 - i7) >= 8) {
                            this.ilV = new Point(point.x, point.y);
                            this.ilV.y = com.tencent.mm.plugin.mmsight.d.QK(point.y);
                            this.ilV.x = com.tencent.mm.plugin.mmsight.d.QK(point.x);
                            this.ztR = new Point(this.ilV.x, this.ilV.y);
                            this.ztS = ((this.ilV.x * this.ilV.y) * 3) / 2;
                            a3 = true;
                        }
                        z3 = a3;
                    } else {
                        int i8 = point.x / 2;
                        int QJ3 = com.tencent.mm.plugin.mmsight.d.QJ(i8);
                        int i9 = point.y / 2;
                        int QJ4 = com.tencent.mm.plugin.mmsight.d.QJ(i9);
                        if (Math.abs(QJ3 - i8) >= 8 || Math.abs(QJ4 - i9) >= 8) {
                            this.ilV = new Point(point.x, point.y);
                            this.ilV.y = com.tencent.mm.plugin.mmsight.d.QK(point.x);
                            this.ilV.x = com.tencent.mm.plugin.mmsight.d.QK(point.y);
                            this.ztR = new Point(this.ilV.x, this.ilV.y);
                            this.ztS = ((this.ilV.x * this.ilV.y) * 3) / 2;
                            z3 = true;
                        }
                    }
                }
                z3 = a3;
            }
            if (k.zuy.zuL) {
                if (this.imk.dYT == 90 || this.imk.dYT == 270) {
                    if (z4) {
                        if (k.zuy.ilT == 1080) {
                            this.ztR = new Point(com.tencent.mm.plugin.mmsight.d.gZ(this.ilV == null ? point.x / 2 : this.ilV.x / 2, this.ilV == null ? point.x : this.ilV.x), com.tencent.mm.plugin.mmsight.d.gZ(this.ilV == null ? point.y / 2 : this.ilV.y / 2, this.ilV == null ? point.y : this.ilV.y));
                        } else if (k.zuy.ilT == 720) {
                            this.ztR = new Point(com.tencent.mm.plugin.mmsight.d.gZ((int) (this.ilV == null ? ((float) point.x) * 0.75f : ((float) this.ilV.x) * 0.75f), this.ilV == null ? point.x : this.ilV.x), com.tencent.mm.plugin.mmsight.d.gZ((int) (this.ilV == null ? ((float) point.y) * 0.75f : ((float) this.ilV.y) * 0.75f), this.ilV == null ? point.y : this.ilV.y));
                        }
                    }
                } else if (z4) {
                    if (k.zuy.ilT == 1080) {
                        this.ztR = new Point(com.tencent.mm.plugin.mmsight.d.gZ(this.ilV == null ? point.y / 2 : this.ilV.y / 2, this.ilV == null ? point.y : this.ilV.y), com.tencent.mm.plugin.mmsight.d.gZ(this.ilV == null ? point.x / 2 : this.ilV.x / 2, this.ilV == null ? point.x : this.ilV.x));
                    } else if (k.zuy.ilT == 720) {
                        int i10 = (int) (this.ilV == null ? ((float) point.y) * 0.75f : ((float) this.ilV.y) * 0.75f);
                        int i11 = (int) (this.ilV == null ? ((float) point.x) * 0.75f : ((float) this.ilV.x) * 0.75f);
                        int gZ = com.tencent.mm.plugin.mmsight.d.gZ(i10, this.ilV == null ? point.y : this.ilV.y);
                        if (this.ilV == null) {
                            i3 = point.x;
                        } else {
                            i3 = this.ilV.x;
                        }
                        this.ztR = new Point(gZ, com.tencent.mm.plugin.mmsight.d.gZ(i11, i3));
                    }
                }
            }
            b ejt3 = b.ejt();
            Point point2 = this.ilV;
            Point point3 = this.ztR;
            ejt3.ztq = -1;
            ejt3.ztp = -1;
            ejt3.ztm = -1;
            ejt3.ztl = -1;
            ejt3.zto = -1;
            ejt3.ztn = -1;
            if (point != null) {
                ejt3.ztn = point.x;
                ejt3.zto = point.y;
            }
            if (point2 != null) {
                ejt3.ztl = point2.x;
                ejt3.ztm = point2.y;
            }
            if (point3 != null) {
                ejt3.ztp = point3.x;
                ejt3.ztq = point3.y;
            }
            if (z) {
                if (z3 || k.zuy.gIP != 2 || com.tencent.mm.plugin.mmsight.d.QI(this.ztR.y)) {
                    k.i(this.ztR);
                } else {
                    int QJ5 = com.tencent.mm.plugin.mmsight.d.QJ(this.ztR.y);
                    if (Math.abs(QJ5 - this.ztR.y) <= 16) {
                        Log.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", this.ztR, Integer.valueOf(QJ5));
                        this.ztQ = new Point(this.ztR.x, this.ztR.y);
                        this.ztR.y = QJ5;
                        this.ztU = true;
                        this.ztT = new byte[(((this.ztR.x * this.ztR.y) * 3) / 2)];
                    } else {
                        k.i(this.ztR);
                    }
                }
            } else if (!z3 && k.zuy.gIP == 2 && !com.tencent.mm.plugin.mmsight.d.QI(this.ztR.y) && this.ztU && this.ztT != null && this.ztQ.y == this.ztR.y) {
                int QJ6 = com.tencent.mm.plugin.mmsight.d.QJ(this.ztR.y);
                if (this.ztT.length == ((this.ztR.x * QJ6) * 3) / 2) {
                    this.ztR.y = QJ6;
                }
            }
            Log.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", point, this.ztR, this.ilV);
            parameters.setPreviewSize(this.ilR.sUz, this.ilR.sUA);
            vVar.setParameters(parameters);
            AppMethodBeat.o(241181);
            return true;
        } catch (Exception e2) {
            Log.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(241181);
            return false;
        }
    }

    private boolean a(v vVar, int i2, float f2, boolean z) {
        Point point;
        int round;
        AppMethodBeat.i(89377);
        if (vVar == null || i2 <= 0) {
            AppMethodBeat.o(89377);
            return false;
        }
        try {
            Camera.Parameters parameters = vVar.getParameters();
            new Point(i2, (int) (((float) i2) / f2));
            if (this.ilU == null) {
                point = ao.az(MMApplicationContext.getContext());
            } else {
                point = new Point(this.ilU.getWidth(), this.ilU.getHeight());
            }
            Point point2 = new Point(Math.min(point.x, point.y), Math.max(point.x, point.y));
            Log.i("MicroMsg.MMSightCamera", "screenSize: %s, currentScreenSize: %s", point2, point);
            float min = ((float) Math.min(point2.x, point2.y)) / ((float) Math.max(point2.x, point2.y));
            float f3 = 1.0f / f2;
            if (f2 < 1.0f) {
                round = i2;
            } else {
                round = Math.round(((float) i2) / f3);
            }
            Log.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", Integer.valueOf(round), Float.valueOf(f2), Float.valueOf(min));
            h.c a2 = h.a(parameters, point2, round, this.imk.dYT == 90 || this.imk.dYT == 270);
            if (a2 == null || a2.zum == null) {
                Log.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
                a2 = h.d(parameters, point2, i2, this.imk.dYT == 90 || this.imk.dYT == 270);
                this.zub = false;
            }
            if (!(a2 == null || a2.zum == null)) {
                int i3 = (int) (((float) a2.zum.x) * f2);
                Log.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", a2.zum, Integer.valueOf(i3));
                if (i3 <= a2.zum.y) {
                    this.zub = false;
                } else {
                    this.zub = true;
                }
            }
            if (!(a2 == null || a2.zum == null)) {
                Point point3 = a2.zum;
                this.ilR.sUz = point3.x;
                this.ilR.sUA = point3.y;
                this.ztR = point3;
                this.ilV = null;
                if (!z) {
                    if (k.zuy.gIP != 2 || com.tencent.mm.plugin.mmsight.d.QI(this.ztR.y)) {
                        k.i(this.ztR);
                    } else {
                        int QJ = com.tencent.mm.plugin.mmsight.d.QJ(this.ztR.y);
                        if (Math.abs(QJ - this.ztR.y) <= 16) {
                            Log.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", this.ztR, Integer.valueOf(QJ));
                            this.ztQ = new Point(this.ztR.x, this.ztR.y);
                            this.ztR.y = QJ;
                            this.ztU = true;
                            this.ztT = new byte[(((this.ztR.x * this.ztR.y) * 3) / 2)];
                        } else {
                            k.i(this.ztR);
                        }
                    }
                }
                Log.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", point3, this.ztR, this.ilV, Boolean.valueOf(this.zub));
                parameters.setPreviewSize(this.ilR.sUz, this.ilR.sUA);
                vVar.setParameters(parameters);
                AppMethodBeat.o(89377);
                return true;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimit error: %s", e2.getMessage());
        }
        AppMethodBeat.o(89377);
        return false;
    }

    public final Point getEncodeVideoBestSize() {
        return this.ztR;
    }

    @TargetApi(14)
    private static boolean c(v vVar) {
        AppMethodBeat.i(89378);
        if (vVar == null) {
            AppMethodBeat.o(89378);
            return false;
        }
        try {
            Log.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
            Camera.Parameters parameters = vVar.getParameters();
            if (parameters.getMaxNumMeteringAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(new Rect(-1000, -1000, 1000, 1000), 600));
                parameters.setMeteringAreas(arrayList);
            }
            vVar.setParameters(parameters);
            AppMethodBeat.o(89378);
            return true;
        } catch (Exception e2) {
            Log.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(89378);
            return false;
        }
    }

    private static boolean a(v vVar, boolean z) {
        boolean z2;
        AppMethodBeat.i(89379);
        if (vVar == null) {
            AppMethodBeat.o(89379);
            return false;
        }
        try {
            Camera.Parameters parameters = vVar.getParameters();
            if (z) {
                if (ae.gKt.gFP > 0) {
                    Log.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
                } else if (parameters == null) {
                    Log.e("MicroMsg.MMSightCamera", "trySetPreviewFrameRateParameters error, p is null!");
                } else {
                    try {
                        List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
                        if (supportedPreviewFrameRates != null && supportedPreviewFrameRates.size() > 0) {
                            int min = Math.min(30, ((Integer) Collections.max(supportedPreviewFrameRates)).intValue());
                            parameters.setPreviewFrameRate(min);
                            Log.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", Integer.valueOf(min));
                        }
                    } catch (Exception e2) {
                        Log.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
                    }
                }
            } else if (ae.gKt.gFP > 0) {
                Log.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
            } else {
                List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                if (!(supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0)) {
                    int i2 = Integer.MIN_VALUE;
                    int i3 = Integer.MIN_VALUE;
                    boolean z3 = false;
                    int size = supportedPreviewFpsRange.size();
                    int i4 = 0;
                    while (i4 < size) {
                        int[] iArr = supportedPreviewFpsRange.get(i4);
                        if (iArr != null && iArr.length > 1) {
                            int i5 = iArr[0];
                            int i6 = iArr[1];
                            Log.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
                            if (i5 >= 0 && i6 >= i5) {
                                if (i6 >= i3 && !z3) {
                                    i3 = i6;
                                    i2 = i5;
                                }
                                if (i6 >= 30000) {
                                    z2 = true;
                                    i4++;
                                    z3 = z2;
                                }
                            }
                        }
                        z2 = z3;
                        i4++;
                        z3 = z2;
                    }
                    Log.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i2), Integer.valueOf(i3), 30);
                    if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
                        try {
                            parameters.setPreviewFpsRange(i2, i3);
                            Log.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        } catch (Exception e3) {
                            Log.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e3.getMessage());
                        }
                    }
                }
            }
            Log.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", Boolean.valueOf(z), parameters.getSupportedPreviewFrameRates());
            vVar.setParameters(parameters);
            AppMethodBeat.o(89379);
            return true;
        } catch (Exception e4) {
            Log.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", Looper.myLooper(), e4.getMessage());
            AppMethodBeat.o(89379);
            return false;
        }
    }

    private static boolean b(v vVar) {
        AppMethodBeat.i(89380);
        if (vVar == null) {
            AppMethodBeat.o(89380);
            return false;
        }
        try {
            Log.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
            Camera.Parameters parameters = vVar.getParameters();
            List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(17)) {
                Log.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
            }
            parameters.setPreviewFormat(17);
            vVar.setParameters(parameters);
            AppMethodBeat.o(89380);
            return true;
        } catch (Exception e2) {
            Log.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(89380);
            return false;
        }
    }

    private static boolean a(v vVar) {
        AppMethodBeat.i(89381);
        if (vVar == null) {
            AppMethodBeat.o(89381);
            return false;
        }
        try {
            Camera.Parameters parameters = vVar.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                Log.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                parameters.setFocusMode("continuous-picture");
            } else if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                Log.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                parameters.setFocusMode("continuous-video");
            } else if (supportedFocusModes == null || !supportedFocusModes.contains("auto")) {
                Log.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
            } else {
                Log.i("MicroMsg.MMSightCameraSetting", "support auto focus");
                parameters.setFocusMode("auto");
            }
            vVar.setParameters(parameters);
            AppMethodBeat.o(89381);
            return true;
        } catch (Exception e2) {
            Log.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(89381);
            return false;
        }
    }

    public final void ejy() {
        AppMethodBeat.i(89382);
        Log.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
        if (this.gGr != null && this.ztJ) {
            try {
                Camera.Parameters parameters = this.gGr.getParameters();
                List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                    Log.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                    parameters.setFocusMode("continuous-video");
                }
                this.gGr.setParameters(parameters);
                AppMethodBeat.o(89382);
                return;
            } catch (Exception e2) {
                Log.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(89382);
    }

    public final void ejz() {
        AppMethodBeat.i(89383);
        Log.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
        if (this.gGr != null && this.ztJ) {
            try {
                Camera.Parameters parameters = this.gGr.getParameters();
                List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                    Log.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                    parameters.setFocusMode("continuous-picture");
                }
                this.gGr.setParameters(parameters);
                AppMethodBeat.o(89383);
                return;
            } catch (Exception e2) {
                Log.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(89383);
    }

    private void aPs() {
        AppMethodBeat.i(89384);
        if (this.gGr != null) {
            try {
                Camera.Parameters parameters = this.gGr.getParameters();
                Log.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
                int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (this.ilR.sUz * this.ilR.sUA)) / 8;
                for (int i2 = 0; i2 < 5; i2++) {
                    this.gGr.addCallbackBuffer(k.zwi.h(Integer.valueOf(bitsPerPixel)));
                }
                this.imm.reset();
                this.imn.reset();
                this.imo.reset();
                this.imp.reset();
                this.ztZ.reset();
                this.imq.reset();
                this.ztV = new com.tencent.mm.plugin.base.model.a();
                this.gGr.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() {
                    /* class com.tencent.mm.plugin.mmsight.model.f.AnonymousClass1 */

                    public final void onPreviewFrame(byte[] bArr, Camera camera) {
                        int i2;
                        byte[] bArr2;
                        byte[] bArr3;
                        byte[] bArr4;
                        AppMethodBeat.i(89361);
                        if (!f.this.ztX) {
                            Log.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", bArr, f.this.gGr);
                            f.this.ztX = true;
                        }
                        if (bArr == null || bArr.length <= 0) {
                            Log.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
                            AppMethodBeat.o(89361);
                            return;
                        }
                        com.tencent.mm.plugin.base.model.a aVar = f.this.ztV;
                        if (aVar.pdf == 0) {
                            aVar.pde++;
                            aVar.pdd = Util.safeParseInt(m.aop());
                        }
                        aVar.pdf++;
                        if (aVar.pdf >= 90) {
                            i2 = 0;
                        } else {
                            i2 = aVar.pdf;
                        }
                        aVar.pdf = i2;
                        if (f.this.imr || f.this.imj == null || f.this.imj.size() <= 0) {
                            bArr2 = bArr;
                            bArr3 = bArr;
                        } else if (f.this.ilV != null) {
                            byte[] h2 = k.zwi.h(Integer.valueOf(((f.this.ilR.sUz * f.this.ilV.y) * 3) / 2));
                            f.this.imo.Hi(1);
                            long currentTicks = Util.currentTicks();
                            SightVideoJNI.cropCameraData(bArr, h2, f.this.ilR.sUz, f.this.ilR.sUA, f.this.ilV.y);
                            if (f.this.ilV.x < f.this.ilR.sUz) {
                                bArr3 = k.zwi.h(Integer.valueOf(((f.this.ilV.x * f.this.ilV.y) * 3) / 2));
                                SightVideoJNI.cropCameraDataLongEdge(h2, bArr3, f.this.ilR.sUz, f.this.ilV.x, f.this.ilV.y);
                                k.zwi.k(h2);
                            } else {
                                bArr3 = h2;
                            }
                            f.this.imp.Hi(Util.ticksToNow(currentTicks));
                            if (!f.this.ilM) {
                                currentTicks = Util.currentTicks();
                                SightVideoJNI.mirrorCameraData(bArr3, f.this.ilV.x, f.this.ilV.y, f.this.imk.dYT == 270 || f.this.imk.dYT == 90);
                                f.this.ztZ.Hi(Util.ticksToNow(currentTicks));
                            }
                            boolean a2 = f.a(f.this, bArr3);
                            long ticksToNow = Util.ticksToNow(currentTicks);
                            if (a2) {
                                f.this.imq.Hi(ticksToNow);
                            }
                            bArr2 = bArr;
                        } else {
                            long currentTicks2 = Util.currentTicks();
                            if (!f.this.ilM) {
                                SightVideoJNI.mirrorCameraData(bArr, f.this.ilR.sUz, f.this.ilR.sUA, f.this.imk.dYT == 270 || f.this.imk.dYT == 90);
                                f.this.ztZ.Hi(Util.ticksToNow(currentTicks2));
                            }
                            if (!f.this.ztU || f.this.ztT == null) {
                                bArr3 = bArr;
                            } else {
                                SightVideoJNI.paddingYuvData16(bArr, f.this.ztT, f.this.ztR.x, f.this.ztQ.y, f.this.ztR.y);
                                bArr3 = f.this.ztT;
                            }
                            boolean a3 = f.a(f.this, bArr3);
                            long ticksToNow2 = Util.ticksToNow(currentTicks2);
                            if (a3) {
                                f.this.imq.Hi(ticksToNow2);
                            }
                            if ((!f.this.ztU || f.this.ztT == null) && a3) {
                                bArr = k.zwi.h(Integer.valueOf(bArr.length));
                            }
                            if (f.this.ztU && f.this.ztT != null) {
                                f fVar = f.this;
                                if (a3) {
                                    bArr4 = k.zwi.h(Integer.valueOf(f.this.ztT.length));
                                } else {
                                    bArr4 = f.this.ztT;
                                }
                                fVar.ztT = bArr4;
                            }
                            bArr2 = bArr;
                        }
                        f.this.ims = bArr3;
                        if (f.this.ztY == a.Preview) {
                            f.this.imn.Hi(1);
                        } else if (f.this.ztY == a.Recording) {
                            f.this.imm.Hi(1);
                        }
                        f.this.gGr.addCallbackBuffer(bArr2);
                        AppMethodBeat.o(89361);
                    }
                });
                AppMethodBeat.o(89384);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(89384);
    }

    @TargetApi(11)
    public final int a(SurfaceTexture surfaceTexture, boolean z) {
        Integer num;
        boolean z2;
        boolean z3;
        boolean z4;
        AppMethodBeat.i(89385);
        long currentTicks = Util.currentTicks();
        this.ztX = false;
        Log.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", Boolean.valueOf(this.ztJ), Looper.myLooper(), surfaceTexture, Boolean.valueOf(z));
        if (this.ztJ) {
            AppMethodBeat.o(89385);
            return 0;
        } else if (surfaceTexture == null) {
            int line = 0 - com.tencent.mm.compatible.util.f.getLine();
            AppMethodBeat.o(89385);
            return line;
        } else {
            Log.i("MicroMsg.MMSightCamera", "this texture %s", surfaceTexture);
            try {
                a(this.gGr, z, 0);
                if (l.ekc().zwk != null) {
                    num = Integer.valueOf(l.ekc().zwk.zsR);
                } else {
                    num = 0;
                }
                Object[] objArr = new Object[6];
                objArr[0] = num;
                objArr[1] = ae.gKt.gFU == 1 ? "Range" : ae.gKt.gFT == 1 ? "Fix" : "Error";
                objArr[2] = Boolean.valueOf(ae.gKt.gFV == 1);
                if (ae.gKt.gFW == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[3] = Boolean.valueOf(z2);
                if (ae.gKt.gFX == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                objArr[4] = Boolean.valueOf(z3);
                if (ae.gKt.gFY == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                objArr[5] = Boolean.valueOf(z4);
                Log.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", objArr);
                if (ae.gKt.gFU == 1 && (num.intValue() == 0 || num.intValue() == 1)) {
                    a(this.gGr, false);
                } else if (ae.gKt.gFT == 1 && (num.intValue() == 0 || num.intValue() == 5)) {
                    a(this.gGr, true);
                }
                if (ae.gKt.gFV == 1 && (num.intValue() == 0 || num.intValue() == 2)) {
                    b(this.gGr);
                }
                if (ae.gKA.gIX != -1 && ae.gKA.gIX == 1 && com.tencent.mm.compatible.util.d.oF(14)) {
                    c(this.gGr);
                }
                if (ae.gKt.gFX == 1 && (num.intValue() == 0 || num.intValue() == 4)) {
                    a(this.gGr);
                }
                if (ae.gKt.gFY == 1 && num.intValue() != 0) {
                    num.intValue();
                }
                d(this.gGr);
                aPs();
                this.gGr.setPreviewTexture(surfaceTexture);
                this.gGr.startPreview();
                if (!k.zuy.zuM) {
                    this.mSensorManager.registerListener(this, this.ztM, 2);
                } else if (!(ae.gKt.gFX != 0 || this.mSensorManager == null || this.ztM == null)) {
                    this.mSensorManager.registerListener(this, this.ztM, 2);
                }
                this.ztJ = true;
                Log.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", Long.valueOf(Util.ticksToNow(currentTicks)), Looper.myLooper());
                AppMethodBeat.o(89385);
                return 0;
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", Looper.myLooper(), e2.getMessage());
                int line2 = 0 - com.tencent.mm.compatible.util.f.getLine();
                AppMethodBeat.o(89385);
                return line2;
            }
        }
    }

    public final int a(SurfaceTexture surfaceTexture, int i2, float f2, boolean z) {
        Integer num;
        AppMethodBeat.i(89386);
        long currentTicks = Util.currentTicks();
        this.ztX = false;
        Log.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", Boolean.valueOf(this.ztJ), Looper.myLooper(), surfaceTexture);
        if (this.ztJ) {
            AppMethodBeat.o(89386);
            return 0;
        } else if (surfaceTexture == null) {
            int line = 0 - com.tencent.mm.compatible.util.f.getLine();
            AppMethodBeat.o(89386);
            return line;
        } else {
            Log.i("MicroMsg.MMSightCamera", "this texture %s", surfaceTexture);
            try {
                a(this.gGr, i2, f2, z);
                if (l.ekc().zwk != null) {
                    num = Integer.valueOf(l.ekc().zwk.zsR);
                } else {
                    num = 0;
                }
                Object[] objArr = new Object[6];
                objArr[0] = num;
                objArr[1] = ae.gKt.gFU == 1 ? "Range" : ae.gKt.gFT == 1 ? "Fix" : "Error";
                objArr[2] = Boolean.valueOf(ae.gKt.gFV == 1);
                objArr[3] = Boolean.valueOf(ae.gKt.gFW == 1);
                objArr[4] = Boolean.valueOf(ae.gKt.gFX == 1);
                objArr[5] = Boolean.valueOf(ae.gKt.gFY == 1);
                Log.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", objArr);
                if (ae.gKt.gFU == 1 && (num.intValue() == 0 || num.intValue() == 1)) {
                    a(this.gGr, false);
                } else if (ae.gKt.gFT == 1 && (num.intValue() == 0 || num.intValue() == 5)) {
                    a(this.gGr, true);
                }
                if (ae.gKt.gFV == 1 && (num.intValue() == 0 || num.intValue() == 2)) {
                    b(this.gGr);
                }
                if (ae.gKA.gIX != -1 && ae.gKA.gIX == 1 && com.tencent.mm.compatible.util.d.oF(14)) {
                    c(this.gGr);
                }
                if (ae.gKt.gFX == 1 && (num.intValue() == 0 || num.intValue() == 4)) {
                    a(this.gGr);
                }
                if (ae.gKt.gFY == 1 && num.intValue() != 0) {
                    num.intValue();
                }
                d(this.gGr);
                aPs();
                this.gGr.setPreviewTexture(surfaceTexture);
                this.gGr.startPreview();
                if (!k.zuy.zuM) {
                    this.mSensorManager.registerListener(this, this.ztM, 2);
                } else if (!(ae.gKt.gFX != 0 || this.mSensorManager == null || this.ztM == null)) {
                    this.mSensorManager.registerListener(this, this.ztM, 2);
                }
                this.ztJ = true;
                Log.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", Long.valueOf(Util.ticksToNow(currentTicks)), Looper.myLooper());
                AppMethodBeat.o(89386);
                return 0;
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", Looper.myLooper(), e2.getMessage());
                int line2 = 0 - com.tencent.mm.compatible.util.f.getLine();
                AppMethodBeat.o(89386);
                return line2;
            }
        }
    }

    private static void d(v vVar) {
        AppMethodBeat.i(89387);
        try {
            Camera.Parameters parameters = vVar.getParameters();
            if (parameters.isZoomSupported()) {
                parameters.setZoom(0);
            }
            vVar.setParameters(parameters);
            AppMethodBeat.o(89387);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", e2.getMessage());
            AppMethodBeat.o(89387);
        }
    }

    private void aPa() {
        AppMethodBeat.i(89388);
        if (true == this.zuc) {
            AppMethodBeat.o(89388);
        } else if (this.mContext == null) {
            AppMethodBeat.o(89388);
        } else if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.e.b.apj()) {
            pl plVar = new pl();
            plVar.dVC.type = 2;
            EventCenter.instance.publish(plVar);
            if (plVar.dVD.dVB) {
                this.zuc = true;
                AppMethodBeat.o(89388);
                return;
            }
            com.tencent.mm.ui.widget.a.d n = com.tencent.mm.ui.base.h.n(this.mContext, R.string.h16, R.string.zb);
            if (n != null) {
                n.setCancelable(false);
                n.setCanceledOnTouchOutside(false);
                n.show();
                this.zuc = true;
            }
            AppMethodBeat.o(89388);
        } else {
            AppMethodBeat.o(89388);
        }
    }

    public final String ejA() {
        AppMethodBeat.i(89389);
        if (this.gGr == null) {
            AppMethodBeat.o(89389);
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList<Camera.Size> c2 = com.tencent.mm.plugin.mmsight.d.c(this.gGr.getParameters());
            Point gx = this.ilU == null ? com.tencent.mm.plugin.mmsight.d.gx(this.mContext) : new Point(this.ilU.getWidth(), this.ilU.getHeight());
            stringBuffer.append(String.format("Screen size %d %d r:%.4f\n", Integer.valueOf(gx.x), Integer.valueOf(gx.y), Double.valueOf((((double) gx.x) * 1.0d) / ((double) gx.y))));
            Iterator<Camera.Size> it = c2.iterator();
            while (it.hasNext()) {
                Camera.Size next = it.next();
                if ((getPreviewWidth() == next.width && getPreviewHeight() == next.height) || (getPreviewWidth() == next.height && getPreviewHeight() == next.width)) {
                    stringBuffer.append(String.format("%s*%s √ r:%.4f\n", Integer.valueOf(next.width), Integer.valueOf(next.height), Double.valueOf((((double) next.height) * 1.0d) / ((double) next.width))));
                } else {
                    stringBuffer.append(String.format("%s*%s X r:%.4f\n", Integer.valueOf(next.width), Integer.valueOf(next.height), Double.valueOf((((double) next.height) * 1.0d) / ((double) next.width))));
                }
            }
            if (this.ilV != null) {
                stringBuffer.append("\nSIGHTCROPMODE:  " + this.ilV.x + " " + this.ilV.y + " from " + this.ilR.sUz + " " + this.ilR.sUA);
            } else {
                stringBuffer.append("\nFinalPreviewSize: " + getPreviewWidth() + " " + getPreviewHeight());
            }
            stringBuffer.append("\ngetOrientation:" + getOrientation());
            stringBuffer.append("\nrecorderOption: " + ae.gKA.gIW);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(89389);
            return stringBuffer2;
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightCamera", "getDebugInfo error: %s", e2.getMessage());
            AppMethodBeat.o(89389);
            return null;
        }
    }

    public final void a(b bVar, boolean z, int i2) {
        AppMethodBeat.i(89390);
        Log.i("MicroMsg.MMSightCamera", "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s", bVar, this.ims, Boolean.valueOf(z), Integer.valueOf(i2));
        if (this.ims != null) {
            try {
                this.imr = true;
                Point point = new Point();
                if (this.ilV != null) {
                    point.x = this.ilV.x;
                    point.y = this.ilV.y;
                } else if (this.ztT == null || !this.ztU) {
                    point.x = this.ilR.sUz;
                    point.y = this.ilR.sUA;
                } else {
                    point.x = this.ztR.x;
                    point.y = this.ztR.y;
                }
                byte[] h2 = k.zwi.h(Integer.valueOf(this.ims.length));
                System.arraycopy(this.ims, 0, h2, 0, this.ims.length);
                bVar.a(h2, point.x, point.y, this.imk.dYT, i2);
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightCamera", "takePicture error: %s", e2.getMessage());
                this.imr = false;
                bVar.a(null, 0, 0, -1, 0);
            } finally {
                this.imr = false;
                AppMethodBeat.o(89390);
            }
        } else {
            bVar.a(null, 0, 0, -1, 0);
            AppMethodBeat.o(89390);
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.i(89391);
        float f2 = sensorEvent.values[0];
        float f3 = sensorEvent.values[1];
        float f4 = sensorEvent.values[2];
        if (Math.abs(this.ztN - f2) > 5.0f || Math.abs(this.ztO - f3) > 5.0f || Math.abs(this.ztP - f4) > 5.0f) {
            Log.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", Float.valueOf(5.0f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
            this.zue.e(this.gGr);
            this.ztN = f2;
            this.ztO = f3;
            this.ztP = f4;
        }
        AppMethodBeat.o(89391);
    }

    public class c extends MMHandler {
        float gZZ;
        float haa;
        int imO;
        int imP;
        boolean imv = false;
        boolean ztI = false;
        int zuk = 0;
        boolean zul = false;

        private static Rect a(float f2, float f3, float f4, int i2, int i3) {
            AppMethodBeat.i(89367);
            float f5 = 80.0f * f4;
            float f6 = (((f2 / ((float) i2)) * 2000.0f) - 1000.0f) - (f5 / 2.0f);
            float f7 = (((f3 / ((float) i3)) * 2000.0f) - 1000.0f) - (f5 / 2.0f);
            RectF rectF = new RectF();
            rectF.set(f6, f7, f6 + f5, f5 + f7);
            Rect rect = new Rect(QN(Math.round(rectF.left)), QN(Math.round(rectF.top)), QN(Math.round(rectF.right)), QN(Math.round(rectF.bottom)));
            AppMethodBeat.o(89367);
            return rect;
        }

        private static int QN(int i2) {
            if (i2 > 1000) {
                return 1000;
            }
            if (i2 < -1000) {
                return -1000;
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public final void e(v vVar) {
            AppMethodBeat.i(89368);
            if (vVar == null) {
                Log.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
                AppMethodBeat.o(89368);
            } else if (!f.zud) {
                Log.w("MicroMsg.MMSightCamera", "auto focus not back");
                AppMethodBeat.o(89368);
            } else {
                f.zud = false;
                try {
                    Log.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
                    vVar.cancelAutoFocus();
                    vVar.autoFocus(f.this.iml);
                    AppMethodBeat.o(89368);
                } catch (Exception e2) {
                    Log.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", e2.getMessage());
                    f.zud = true;
                    AppMethodBeat.o(89368);
                }
            }
        }

        public c(Looper looper) {
            super(looper);
        }

        private static int d(Camera.Parameters parameters) {
            int i2;
            AppMethodBeat.i(89369);
            if (parameters == null) {
                AppMethodBeat.o(89369);
                return 0;
            }
            try {
                i2 = parameters.getMaxZoom() / 2;
                if (i2 <= 0) {
                    i2 = parameters.getMaxZoom();
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", e2.getMessage());
                i2 = 0;
            }
            AppMethodBeat.o(89369);
            return i2;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            int i2;
            boolean z = true;
            AppMethodBeat.i(89370);
            switch (message.what) {
                case 4354:
                    v vVar = (v) message.obj;
                    if (this.imO == 0 || this.imP == 0 || com.tencent.mm.compatible.util.d.oE(14)) {
                        e(vVar);
                        AppMethodBeat.o(89370);
                        return;
                    }
                    float f2 = this.gZZ;
                    float f3 = this.haa;
                    int i3 = this.imO;
                    int i4 = this.imP;
                    if (vVar == null) {
                        Log.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
                        AppMethodBeat.o(89370);
                        return;
                    } else if (!f.zud) {
                        Log.w("MicroMsg.MMSightCamera", "auto focus not back");
                        AppMethodBeat.o(89370);
                        return;
                    } else {
                        f.zud = false;
                        try {
                            vVar.cancelAutoFocus();
                            Log.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i3), Integer.valueOf(i4));
                            Rect a2 = a(f2, f3, 1.0f, i3, i4);
                            Rect a3 = a(f2, f3, 1.5f, i3, i4);
                            Log.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", a2, a3);
                            Camera.Parameters parameters = vVar.getParameters();
                            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                                parameters.setFocusMode("auto");
                            }
                            if (parameters.getMaxNumFocusAreas() > 0) {
                                ArrayList arrayList = new ArrayList(1);
                                arrayList.add(new Camera.Area(a2, 1000));
                                parameters.setFocusAreas(arrayList);
                            }
                            if (parameters.getMaxNumMeteringAreas() > 0) {
                                ArrayList arrayList2 = new ArrayList(1);
                                arrayList2.add(new Camera.Area(a3, 1000));
                                parameters.setMeteringAreas(arrayList2);
                            }
                            vVar.setParameters(parameters);
                            vVar.autoFocus(f.this.iml);
                            AppMethodBeat.o(89370);
                            return;
                        } catch (Exception e2) {
                            Log.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", e2.getMessage());
                            f.zud = true;
                            AppMethodBeat.o(89370);
                            return;
                        }
                    }
                case 4353:
                    if (!this.imv) {
                        Camera camera = (Camera) message.obj;
                        Camera.Parameters parameters2 = camera.getParameters();
                        Log.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", Boolean.valueOf(this.ztI), Integer.valueOf(this.zuk), Integer.valueOf(parameters2.getZoom()));
                        int zoom = parameters2.getZoom() + this.zuk;
                        if (this.ztI) {
                            i2 = d(parameters2);
                            if (zoom < i2) {
                                sendMessageDelayed(obtainMessage(4353, message.obj), this.zul ? 10 : 20);
                                i2 = zoom;
                                z = false;
                            }
                        } else if (zoom <= 0) {
                            i2 = 0;
                        } else {
                            sendMessageDelayed(obtainMessage(4353, message.obj), this.zul ? 10 : 20);
                            i2 = zoom;
                            z = false;
                        }
                        parameters2.setZoom(i2);
                        try {
                            camera.setParameters(parameters2);
                        } catch (Exception e3) {
                        }
                        if (z) {
                            this.imO = 0;
                            this.imP = 0;
                            break;
                        }
                    } else {
                        AppMethodBeat.o(89370);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(89370);
        }
    }

    public final void b(float f2, float f3, int i2, int i3) {
        AppMethodBeat.i(89392);
        if (com.tencent.mm.compatible.util.d.oE(14)) {
            AppMethodBeat.o(89392);
            return;
        }
        this.zue.removeMessages(4354);
        this.zue.gZZ = f2;
        this.zue.haa = f3;
        this.zue.imO = i2;
        this.zue.imP = i3;
        this.zue.sendMessageDelayed(this.zue.obtainMessage(4354, this.gGr), 400);
        AppMethodBeat.o(89392);
    }

    public final void ejB() {
        AppMethodBeat.i(89393);
        if (this.gGr != null && this.ztJ) {
            try {
                Camera.Parameters parameters = this.gGr.getParameters();
                List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                    Log.i("MicroMsg.MMSightCameraSetting", "support auto focus");
                    parameters.setFocusMode("auto");
                    this.gGr.setParameters(parameters);
                }
                this.gGr.cancelAutoFocus();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMSightCamera", e2, "simple auto focus error", new Object[0]);
            }
            try {
                this.gGr.autoFocus(new Camera.AutoFocusCallback() {
                    /* class com.tencent.mm.plugin.mmsight.model.f.AnonymousClass3 */

                    public final void onAutoFocus(boolean z, Camera camera) {
                        AppMethodBeat.i(89363);
                        if (camera != null && f.this.dEO()) {
                            try {
                                Camera.Parameters parameters = camera.getParameters();
                                List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                                if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                                    Log.i("MicroMsg.MMSightCameraSetting", "support continues picture focus");
                                    parameters.setFocusMode("continuous-picture");
                                    camera.setParameters(parameters);
                                }
                                AppMethodBeat.o(89363);
                                return;
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.MMSightCamera", e2, "simple auto focus resetToPictureFocus error", new Object[0]);
                            }
                        }
                        AppMethodBeat.o(89363);
                    }
                });
                AppMethodBeat.o(89393);
                return;
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.MMSightCamera", e3, "autoFocus error", new Object[0]);
            }
        }
        AppMethodBeat.o(89393);
    }

    public final List<Integer> ejC() {
        AppMethodBeat.i(89394);
        if (this.gGr != null) {
            try {
                Camera.Parameters parameters = this.gGr.getParameters();
                if (!parameters.isZoomSupported()) {
                    AppMethodBeat.o(89394);
                    return null;
                }
                List<Integer> zoomRatios = parameters.getZoomRatios();
                AppMethodBeat.o(89394);
                return zoomRatios;
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightCamera", "getZoom error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(89394);
        return null;
    }

    public final void QM(int i2) {
        AppMethodBeat.i(89395);
        if (this.gGr != null) {
            try {
                Camera.Parameters parameters = this.gGr.getParameters();
                if (parameters.isZoomSupported()) {
                    if (i2 < 0 || i2 > parameters.getMaxZoom()) {
                        this.aYc = false;
                        AppMethodBeat.o(89395);
                    } else if (this.aYc) {
                        Log.d("MicroMsg.MMSightCamera", "setForceZoomTargetRatio, zooming, ignore");
                        this.aYc = false;
                        AppMethodBeat.o(89395);
                    } else {
                        this.aYc = true;
                        parameters.setZoom(i2);
                        this.gGr.setParameters(parameters);
                        this.aYc = false;
                        AppMethodBeat.o(89395);
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightCamera", "getZoom error: %s", e2.getMessage());
            } finally {
                this.aYc = false;
                AppMethodBeat.o(89395);
            }
        } else {
            AppMethodBeat.o(89395);
        }
    }

    public final void d(boolean z, boolean z2, int i2) {
        int i3;
        AppMethodBeat.i(89396);
        if (this.gGr == null || !this.ztJ) {
            AppMethodBeat.o(89396);
            return;
        }
        try {
            Log.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", Boolean.valueOf(z));
            if (this.aYc) {
                Log.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
                return;
            }
            Camera.Parameters parameters = this.gGr.getParameters();
            if (parameters.isZoomSupported()) {
                this.aYc = true;
                int zoom = parameters.getZoom();
                int maxZoom = parameters.getMaxZoom();
                if (!z2) {
                    if (this.ilX <= 0) {
                        this.ilX = Math.round(((float) maxZoom) / 15.0f);
                        if (this.ilX > 5) {
                            this.ilX = 5;
                        }
                    }
                    i3 = this.ilX;
                } else if (this.ilW <= 0) {
                    Log.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", Integer.valueOf(this.ilW));
                    this.aYc = false;
                    AppMethodBeat.o(89396);
                    return;
                } else {
                    i3 = this.ilW;
                }
                Log.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", Integer.valueOf(zoom), Integer.valueOf(maxZoom), Integer.valueOf(this.ilX), Integer.valueOf(this.ilW), Integer.valueOf(i2));
                if (i2 > 0) {
                    i3 *= i2;
                }
                if (z) {
                    if (zoom >= maxZoom) {
                        this.aYc = false;
                        AppMethodBeat.o(89396);
                        return;
                    }
                    int i4 = i3 + zoom;
                    if (i4 < maxZoom) {
                        maxZoom = i4;
                    }
                } else if (zoom == 0) {
                    this.aYc = false;
                    AppMethodBeat.o(89396);
                    return;
                } else {
                    maxZoom = zoom - i3;
                    if (maxZoom <= 0) {
                        maxZoom = 0;
                    }
                }
                Log.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", Integer.valueOf(maxZoom));
                parameters.setZoom(maxZoom);
                this.gGr.setParameters(parameters);
            }
            this.aYc = false;
            AppMethodBeat.o(89396);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", e2.getMessage());
        } finally {
            this.aYc = false;
            AppMethodBeat.o(89396);
        }
    }

    public final void rw(int i2) {
        AppMethodBeat.i(89397);
        if (this.ilW > 0) {
            AppMethodBeat.o(89397);
            return;
        }
        Point az = this.ilU == null ? ao.az(MMApplicationContext.getContext()) : new Point(this.ilU.getWidth(), this.ilU.getHeight());
        int i3 = az.y;
        Log.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", Integer.valueOf(i2), az);
        if (i3 / 2 >= i2) {
            AppMethodBeat.o(89397);
            return;
        }
        try {
            if (this.gGr != null) {
                int maxZoom = this.gGr.getParameters().getMaxZoom();
                this.ilW = ((int) (((double) maxZoom) / ((((double) i2) / 3.0d) / 10.0d))) + 1;
                Log.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", Integer.valueOf(this.ilW), Integer.valueOf(maxZoom));
            }
            AppMethodBeat.o(89397);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", e2.getMessage());
            AppMethodBeat.o(89397);
        }
    }

    public final boolean D(Context context, boolean z) {
        AppMethodBeat.i(89398);
        if (!k.zuy.zuM || (ae.gKt.gFX == 0 && this.mSensorManager == null && this.ztM == null)) {
            this.mSensorManager = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
            this.ztM = this.mSensorManager.getDefaultSensor(1);
        }
        if (this.gGr == null) {
            ejx();
            this.ilM = z;
            if (z) {
                try {
                    this.ztK = d.aog();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.MMSightCamera", e2, "try to get cameraid error %s, useBackCamera: %s", e2.getMessage(), Boolean.valueOf(this.ilM));
                    this.ztK = 0;
                }
            } else {
                this.ztK = d.aoh();
            }
            Log.i("MicroMsg.MMSightCamera", "use camera id %d, SrvDeviceInfo id %d", Integer.valueOf(this.ztK), Integer.valueOf(ae.gKt.gGa));
            this.zuc = false;
            this.mContext = context;
            this.imk = new o().B(context, this.ztK);
            Log.i("MicroMsg.MMSightCamera", "open camera end, %s", Looper.myLooper());
            if (this.imk == null) {
                Log.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", Looper.myLooper());
                aPa();
                AppMethodBeat.o(89398);
                return false;
            }
            this.gGr = this.imk.gGr;
            this.zue.imv = false;
            this.ilR.dYT = this.imk.dYT;
            if (this.gGr == null) {
                Log.e("MicroMsg.MMSightCamera", "start camera FAILED!");
                aPa();
                AppMethodBeat.o(89398);
                return false;
            }
        }
        AppMethodBeat.o(89398);
        return true;
    }

    public final boolean a(Context context, SurfaceTexture surfaceTexture, boolean z) {
        AppMethodBeat.i(89399);
        Log.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", Boolean.valueOf(this.ilM));
        try {
            ejD();
            D(context, !this.ilM);
            a(surfaceTexture, z);
            AppMethodBeat.o(89399);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightCamera", "switchCamera error: %s", e2);
            AppMethodBeat.o(89399);
            return false;
        }
    }

    public final boolean a(Context context, SurfaceTexture surfaceTexture, int i2, float f2, boolean z) {
        AppMethodBeat.i(89400);
        Log.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", Boolean.valueOf(this.ilM));
        try {
            ejD();
            D(context, !this.ilM);
            a(surfaceTexture, i2, f2, z);
            AppMethodBeat.o(89400);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightCamera", "switchCamera error: %s", e2);
            AppMethodBeat.o(89400);
            return false;
        }
    }

    public final int ejD() {
        AppMethodBeat.i(89401);
        ejx();
        AppMethodBeat.o(89401);
        return 0;
    }

    public final void ejE() {
        AppMethodBeat.i(89402);
        Log.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", this.gGr, Boolean.valueOf(this.ztJ));
        if (this.gGr != null && this.ztJ) {
            try {
                this.ztW = true;
                Camera.Parameters parameters = this.gGr.getParameters();
                if (Util.isNullOrNil(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("torch")) {
                    Log.i("MicroMsg.MMSightCamera", "camera not support flash!!");
                    AppMethodBeat.o(89402);
                    return;
                }
                parameters.setFlashMode("torch");
                this.gGr.setParameters(parameters);
                Log.i("MicroMsg.MMSightCamera", "open flash");
                AppMethodBeat.o(89402);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMSightCamera", e2, "openFlash error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(89402);
    }

    public final void ejF() {
        AppMethodBeat.i(89403);
        Log.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", this.gGr, Boolean.valueOf(this.ztJ));
        if (this.gGr != null && this.ztJ) {
            try {
                this.ztW = false;
                Camera.Parameters parameters = this.gGr.getParameters();
                if (Util.isNullOrNil(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("off")) {
                    Log.i("MicroMsg.MMSightCamera", "camera not support close flash!!");
                    AppMethodBeat.o(89403);
                    return;
                }
                parameters.setFlashMode("off");
                this.gGr.setParameters(parameters);
                Log.i("MicroMsg.MMSightCamera", "close flash");
                AppMethodBeat.o(89403);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMSightCamera", e2, "closeFlash error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(89403);
    }

    public final void ejG() {
        AppMethodBeat.i(89404);
        Log.i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", this.gGr, Boolean.valueOf(this.ztJ));
        if (this.gGr != null && this.ztJ) {
            try {
                this.ztW = true;
                Camera.Parameters parameters = this.gGr.getParameters();
                if (Util.isNullOrNil(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("auto")) {
                    Log.i("MicroMsg.MMSightCamera", "camera not support auto flash!!");
                    AppMethodBeat.o(89404);
                    return;
                }
                parameters.setFlashMode("auto");
                this.gGr.setParameters(parameters);
                Log.i("MicroMsg.MMSightCamera", "auto flash");
                AppMethodBeat.o(89404);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMSightCamera", e2, "autoFlash error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(89404);
    }

    public final int getPreviewWidth() {
        int i2 = 0;
        AppMethodBeat.i(89405);
        if (this.gGr == null) {
            AppMethodBeat.o(89405);
        } else {
            if (this.imk != null) {
                try {
                    if (!this.ztU || this.ztT == null) {
                        i2 = this.ilV == null ? (this.imk.dYT == 0 || this.imk.dYT == 180) ? this.ilR.sUz : this.ilR.sUA : (this.imk.dYT == 0 || this.imk.dYT == 180) ? this.ilV.x : this.ilV.y;
                    } else {
                        i2 = (this.imk.dYT == 0 || this.imk.dYT == 180) ? this.ztR.x : this.ztR.y;
                    }
                    AppMethodBeat.o(89405);
                } catch (Exception e2) {
                    Log.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", e2.getMessage());
                }
            }
            AppMethodBeat.o(89405);
        }
        return i2;
    }

    public final int getPreviewHeight() {
        int i2 = 0;
        AppMethodBeat.i(89406);
        if (this.gGr == null) {
            AppMethodBeat.o(89406);
        } else {
            if (this.imk != null) {
                try {
                    if (!this.ztU || this.ztT == null) {
                        i2 = this.ilV == null ? (this.imk.dYT == 0 || this.imk.dYT == 180) ? this.ilR.sUA : this.ilR.sUz : (this.imk.dYT == 0 || this.imk.dYT == 180) ? this.ilV.y : this.ilV.x;
                    } else {
                        i2 = (this.imk.dYT == 0 || this.imk.dYT == 180) ? this.ztR.y : this.ztR.x;
                    }
                    AppMethodBeat.o(89406);
                } catch (Exception e2) {
                    Log.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", e2.getMessage());
                }
            }
            AppMethodBeat.o(89406);
        }
        return i2;
    }

    public final boolean dEO() {
        return this.ztJ;
    }

    public final boolean aPB() {
        return this.ilM;
    }

    public final int getOrientation() {
        if (this.imk == null || !this.ztJ) {
            return -1;
        }
        return this.imk.dYT;
    }

    static /* synthetic */ boolean a(f fVar, byte[] bArr) {
        boolean z = false;
        AppMethodBeat.i(89407);
        Util.currentTicks();
        if (fVar.imj == null || fVar.imj.size() == 0) {
            AppMethodBeat.o(89407);
            return false;
        }
        for (g gVar : fVar.imj) {
            z = gVar.ai(bArr) | z;
        }
        AppMethodBeat.o(89407);
        return z;
    }
}
