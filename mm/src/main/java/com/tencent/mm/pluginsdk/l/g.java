package com.tencent.mm.pluginsdk.l;

import android.annotation.TargetApi;
import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.h;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;

public final class g implements SensorEventListener {
    private static int ztK = 0;
    private Camera.PreviewCallback Dqj = null;
    private SurfaceHolder FRI = null;
    private a KaN;
    public List<Integer> KaO = new ArrayList();
    private boolean KaP = true;
    private boolean KaQ = true;
    private Camera.AutoFocusCallback KaR = new Camera.AutoFocusCallback() {
        /* class com.tencent.mm.pluginsdk.l.g.AnonymousClass1 */

        public final void onAutoFocus(boolean z, Camera camera) {
            AppMethodBeat.i(31185);
            Log.d("MicroMsg.YuvReocrder", "auto focus callback");
            g.this.KaQ = true;
            AppMethodBeat.o(31185);
        }
    };
    public v gGr = null;
    d.a.C0301a imk;
    private SensorManager mSensorManager;
    private boolean ztJ = false;
    private Sensor ztM;
    private float ztN = 0.0f;
    private float ztO = 0.0f;
    private float ztP = 0.0f;

    public g() {
        AppMethodBeat.i(31186);
        AppMethodBeat.o(31186);
    }

    public static int getCameraId() {
        return ztK;
    }

    public final void ejx() {
        AppMethodBeat.i(31187);
        if (!(this.mSensorManager == null || this.ztM == null)) {
            this.mSensorManager.unregisterListener(this);
        }
        if (this.gGr != null) {
            Log.d("MicroMsg.YuvReocrder", "release camera");
            this.gGr.setPreviewCallback(null);
            this.gGr.stopPreview();
            this.gGr.release();
            this.gGr = null;
            this.ztJ = false;
        }
        AppMethodBeat.o(31187);
    }

    @TargetApi(9)
    private static void f(Camera.Parameters parameters) {
        int i2;
        int i3;
        AppMethodBeat.i(31188);
        if (ae.gKt.gFP > 0) {
            AppMethodBeat.o(31188);
        } else if (Build.VERSION.SDK_INT < 9) {
            AppMethodBeat.o(31188);
        } else {
            List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0) {
                AppMethodBeat.o(31188);
                return;
            }
            int size = supportedPreviewFpsRange.size();
            int i4 = 0;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            while (i4 < size) {
                int[] iArr = supportedPreviewFpsRange.get(i4);
                if (iArr != null && iArr.length > 1) {
                    i3 = iArr[0];
                    i2 = iArr[1];
                    Log.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2));
                    if (i3 >= 0 && i2 >= i3 && i2 >= i5) {
                        i4++;
                        i5 = i2;
                        i6 = i3;
                    }
                }
                i2 = i5;
                i3 = i6;
                i4++;
                i5 = i2;
                i6 = i3;
            }
            Log.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", Integer.valueOf(i6), Integer.valueOf(i5));
            if (i6 == Integer.MAX_VALUE || i5 == Integer.MAX_VALUE) {
                AppMethodBeat.o(31188);
                return;
            }
            try {
                parameters.setPreviewFpsRange(i6, i5);
                AppMethodBeat.o(31188);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.YuvReocrder", e2, "", new Object[0]);
                AppMethodBeat.o(31188);
            }
        }
    }

    public final int b(SurfaceHolder surfaceHolder) {
        List<Camera.Size> list;
        List<Camera.Size> list2;
        boolean z;
        AppMethodBeat.i(31189);
        if (this.ztJ) {
            AppMethodBeat.o(31189);
            return 0;
        } else if (surfaceHolder == null) {
            int line = 0 - f.getLine();
            AppMethodBeat.o(31189);
            return line;
        } else {
            try {
                this.FRI = surfaceHolder;
                Camera.Parameters parameters = this.gGr.getParameters();
                a aVar = this.KaN;
                Log.d("MicroMsg.YuvReocrder", "getFitRecordSize");
                int i2 = Integer.MAX_VALUE;
                if (Build.VERSION.SDK_INT >= 11) {
                    new h();
                    list = parameters.getSupportedVideoSizes();
                } else {
                    list = null;
                }
                if (list == null) {
                    Log.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
                    new com.tencent.mm.compatible.deviceinfo.g();
                    list2 = parameters.getSupportedPreviewSizes();
                } else {
                    list2 = list;
                }
                if (list2 != null) {
                    int i3 = 0;
                    boolean z2 = false;
                    while (i3 < list2.size()) {
                        int i4 = list2.get(i3).height;
                        int i5 = list2.get(i3).width;
                        Log.d("MicroMsg.YuvReocrder", "supp w:" + i5 + " h:" + i4);
                        int i6 = i4 * i5;
                        if ((((aVar.dYT == 0 || aVar.dYT == 180) && i4 >= aVar.ifO && i5 >= aVar.ifN) || ((aVar.dYT == 90 || aVar.dYT == 270) && i5 >= aVar.ifO && i4 >= aVar.ifN)) && i6 < i2) {
                            aVar.sUz = i5;
                            aVar.sUA = i4;
                            z = true;
                        } else {
                            z = z2;
                            i6 = i2;
                        }
                        i3++;
                        z2 = z;
                        i2 = i6;
                    }
                    if (!z2) {
                        Camera.Size previewSize = parameters.getPreviewSize();
                        aVar.sUA = previewSize.height;
                        aVar.sUz = previewSize.width;
                    }
                } else {
                    Camera.Size previewSize2 = parameters.getPreviewSize();
                    aVar.sUA = previewSize2.height;
                    aVar.sUz = previewSize2.width;
                }
                Log.d("MicroMsg.YuvReocrder", " rotate:" + aVar.dYT + " w:" + aVar.sUz + " h:" + aVar.sUA);
                parameters.setPreviewSize(this.KaN.sUz, this.KaN.sUA);
                f(parameters);
                List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
                this.KaO.clear();
                this.KaO.addAll(supportedPreviewFrameRates);
                parameters.setPreviewFormat(17);
                List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null) {
                    if (com.tencent.mm.compatible.util.d.oF(9) && true == supportedFocusModes.contains("continuous-video")) {
                        Log.i("MicroMsg.YuvReocrder", "support continous-video");
                        this.KaP = false;
                        parameters.setFocusMode("continuous-video");
                    } else if (!supportedFocusModes.contains("auto")) {
                        Log.i("MicroMsg.YuvReocrder", "don't support auto");
                        this.KaP = false;
                    }
                }
                this.gGr.setParameters(parameters);
                this.gGr.setPreviewDisplay(surfaceHolder);
                this.gGr.startPreview();
                if (!(this.mSensorManager == null || this.ztM == null || !this.KaP)) {
                    this.mSensorManager.registerListener(this, this.ztM, 2);
                }
                this.ztJ = true;
                AppMethodBeat.o(31189);
                return 0;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.YuvReocrder", e2, "", new Object[0]);
                Log.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + e2.getMessage());
                int line2 = 0 - f.getLine();
                AppMethodBeat.o(31189);
                return line2;
            }
        }
    }

    public final int a(Activity activity, a aVar, boolean z) {
        AppMethodBeat.i(31190);
        if (aVar == null) {
            int line = 0 - f.getLine();
            AppMethodBeat.o(31190);
            return line;
        }
        this.KaN = aVar;
        if (this.mSensorManager == null && this.ztM == null) {
            this.mSensorManager = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
            this.ztM = this.mSensorManager.getDefaultSensor(1);
        }
        if (z || this.gGr == null) {
            ejx();
            if (z) {
                ztK = (ztK ^ -1) & 1;
            }
            this.imk = d.a(activity, ztK, null);
            if (this.imk == null) {
                Log.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                int line2 = 0 - f.getLine();
                AppMethodBeat.o(31190);
                return line2;
            }
            this.gGr = this.imk.gGr;
            this.KaN.dYT = this.imk.dYT;
            if (this.gGr == null) {
                Log.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                int line3 = 0 - f.getLine();
                AppMethodBeat.o(31190);
                return line3;
            }
        }
        AppMethodBeat.o(31190);
        return 0;
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.i(31191);
        float f2 = sensorEvent.values[0];
        float f3 = sensorEvent.values[1];
        float f4 = sensorEvent.values[2];
        if ((Math.abs(this.ztN - f2) > 2.0f || Math.abs(this.ztO - f3) > 2.0f || Math.abs(this.ztP - f4) > 2.0f) && this.gGr != null && this.KaQ && true == this.KaP) {
            try {
                Log.d("MicroMsg.YuvReocrder", "auto focus");
                this.gGr.autoFocus(this.KaR);
                this.KaQ = false;
            } catch (Exception e2) {
                Log.d("MicroMsg.YuvReocrder", "auto focus failed");
            }
        }
        this.ztN = f2;
        this.ztO = f3;
        this.ztP = f4;
        AppMethodBeat.o(31191);
    }
}
