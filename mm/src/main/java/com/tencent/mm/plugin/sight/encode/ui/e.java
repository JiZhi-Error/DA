package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class e implements SensorEventListener {
    private static int ztL = Integer.MAX_VALUE;
    com.tencent.mm.pluginsdk.l.a Dqi = com.tencent.mm.pluginsdk.l.a.goh();
    Camera.PreviewCallback Dqj = null;
    a Dqk = new a(Looper.getMainLooper());
    v gGr = null;
    private Context mContext = null;
    boolean ztI = false;
    boolean ztJ = false;
    private int ztK = 0;
    private float ztN = 0.0f;
    private float ztO = 0.0f;
    private float ztP = 0.0f;
    private boolean zuc = false;

    public e() {
        AppMethodBeat.i(28778);
        AppMethodBeat.o(28778);
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.i(28779);
        float f2 = sensorEvent.values[0];
        float f3 = sensorEvent.values[1];
        float f4 = sensorEvent.values[2];
        if (Math.abs(this.ztN - f2) > 3.0f || Math.abs(this.ztO - f3) > 3.0f || Math.abs(this.ztP - f4) > 3.0f) {
            Log.i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", Float.valueOf(3.0f));
            a.g(this.gGr);
            this.ztN = f2;
            this.ztO = f3;
            this.ztP = f4;
        }
        AppMethodBeat.o(28779);
    }

    static class a extends MMHandler {
        static Camera.AutoFocusCallback iml = new Camera.AutoFocusCallback() {
            /* class com.tencent.mm.plugin.sight.encode.ui.e.a.AnonymousClass1 */

            public final void onAutoFocus(boolean z, Camera camera) {
                AppMethodBeat.i(28771);
                Log.v("MicroMsg.SightCamera", "auto focus callback");
                a.zud = true;
                AppMethodBeat.o(28771);
            }
        };
        static boolean zud = true;
        float gZZ;
        float haa;
        int imO;
        int imP;
        boolean imv = false;
        boolean ztI = false;
        int zuk = 0;
        boolean zul = false;

        static {
            AppMethodBeat.i(28777);
            AppMethodBeat.o(28777);
        }

        private static Rect a(float f2, float f3, float f4, int i2, int i3) {
            AppMethodBeat.i(28772);
            int intValue = Float.valueOf(((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 72)) * f4).intValue();
            RectF rectF = new RectF();
            rectF.set((((f2 - ((float) (intValue / 2))) * 2000.0f) / ((float) i2)) - 1000.0f, (((f3 - ((float) (intValue / 2))) * 2000.0f) / ((float) i3)) - 1000.0f, (((((float) (intValue / 2)) + f2) * 2000.0f) / ((float) i2)) - 1000.0f, (((((float) (intValue / 2)) + f3) * 2000.0f) / ((float) i3)) - 1000.0f);
            Rect rect = new Rect(QN(Math.round(rectF.left)), QN(Math.round(rectF.top)), QN(Math.round(rectF.right)), QN(Math.round(rectF.bottom)));
            AppMethodBeat.o(28772);
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

        static void g(v vVar) {
            AppMethodBeat.i(28773);
            if (vVar == null) {
                Log.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
            }
            if (!zud) {
                Log.w("MicroMsg.SightCamera", "auto focus not back");
                AppMethodBeat.o(28773);
                return;
            }
            zud = false;
            try {
                vVar.autoFocus(iml);
                AppMethodBeat.o(28773);
            } catch (Exception e2) {
                Log.w("MicroMsg.SightCamera", "autofocus fail, exception %s", e2.getMessage());
                zud = true;
                AppMethodBeat.o(28773);
            }
        }

        public a(Looper looper) {
            super(looper);
        }

        private static int d(Camera.Parameters parameters) {
            int i2;
            AppMethodBeat.i(28774);
            if (parameters == null) {
                AppMethodBeat.o(28774);
                return 0;
            }
            try {
                i2 = parameters.getMaxZoom() / 2;
                if (i2 <= 0) {
                    i2 = parameters.getMaxZoom();
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SightCamera", "get target zoom value error: %s", e2.getMessage());
                i2 = 0;
            }
            AppMethodBeat.o(28774);
            return i2;
        }

        static int e(Camera.Parameters parameters) {
            AppMethodBeat.i(28775);
            int d2 = d(parameters) / 6;
            if (d2 <= 0) {
                d2 = 1;
            }
            AppMethodBeat.o(28775);
            return d2;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            int i2;
            long j2;
            boolean z = true;
            AppMethodBeat.i(28776);
            switch (message.what) {
                case 4354:
                    v vVar = (v) message.obj;
                    if (this.imO == 0 || this.imO == 0 || d.oE(14)) {
                        g(vVar);
                        AppMethodBeat.o(28776);
                        return;
                    }
                    float f2 = this.gZZ;
                    float f3 = this.haa;
                    int i3 = this.imO;
                    int i4 = this.imP;
                    if (vVar == null) {
                        Log.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
                    }
                    if (!zud) {
                        Log.w("MicroMsg.SightCamera", "auto focus not back");
                        AppMethodBeat.o(28776);
                        return;
                    }
                    zud = false;
                    try {
                        Log.i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i3), Integer.valueOf(i4));
                        Rect a2 = a(f2, f3, 1.0f, i3, i4);
                        Rect a3 = a(f2, f3, 1.5f, i3, i4);
                        Log.i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", a2, a3);
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
                        vVar.autoFocus(iml);
                        AppMethodBeat.o(28776);
                        return;
                    } catch (Exception e2) {
                        Log.w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", e2.getMessage());
                        zud = true;
                        AppMethodBeat.o(28776);
                        return;
                    }
                case 4353:
                    if (!this.imv) {
                        Camera camera = (Camera) message.obj;
                        Camera.Parameters parameters2 = camera.getParameters();
                        Log.i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", Boolean.valueOf(this.ztI), Integer.valueOf(this.zuk), Integer.valueOf(parameters2.getZoom()));
                        int zoom = parameters2.getZoom() + this.zuk;
                        if (this.ztI) {
                            i2 = d(parameters2);
                            if (zoom < i2) {
                                Message obtainMessage = obtainMessage(4353, message.obj);
                                if (this.zul) {
                                    j2 = 10;
                                } else {
                                    j2 = 20;
                                }
                                sendMessageDelayed(obtainMessage, j2);
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
                            Log.printErrStackTrace("MicroMsg.SightCamera", e3, "", new Object[0]);
                        }
                        if (z) {
                            this.imO = 0;
                            this.imP = 0;
                            sendMessageDelayed(obtainMessage(4354, message.obj), 20);
                            break;
                        }
                    } else {
                        AppMethodBeat.o(28776);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(28776);
        }
    }
}
