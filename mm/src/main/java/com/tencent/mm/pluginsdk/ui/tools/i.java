package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class i implements y.a {
    public static i Kvp = null;
    private SensorEventListener Jtm;
    private float[] Kvl = new float[3];
    int Kvm = -10000;
    int Kvn = -10000;
    private SensorManager Kvo;
    public boolean hasInit = false;

    public i() {
        AppMethodBeat.i(152387);
        AppMethodBeat.o(152387);
    }

    public final int gsw() {
        AppMethodBeat.i(152388);
        Log.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.Kvm);
        int i2 = this.Kvm;
        AppMethodBeat.o(152388);
        return i2;
    }

    public final int getPitch() {
        AppMethodBeat.i(152389);
        Log.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.Kvn);
        int i2 = this.Kvn;
        AppMethodBeat.o(152389);
        return i2;
    }

    public final void iB(Context context) {
        AppMethodBeat.i(152390);
        Log.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
        if (context == null) {
            Log.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
            AppMethodBeat.o(152390);
            return;
        }
        if (this.Kvo == null) {
            this.Kvo = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
        }
        if (this.Jtm == null) {
            this.Jtm = new SensorEventListener() {
                /* class com.tencent.mm.pluginsdk.ui.tools.i.AnonymousClass1 */

                public final void onSensorChanged(SensorEvent sensorEvent) {
                    AppMethodBeat.i(152385);
                    if (sensorEvent.sensor.getType() == 3) {
                        i.this.Kvl[0] = sensorEvent.values[0];
                        i.this.Kvl[1] = sensorEvent.values[1];
                        i.this.Kvl[2] = sensorEvent.values[2];
                        if (i.this.Kvm == -10000) {
                            i.this.Kvm = (int) i.this.Kvl[0];
                        } else if (i.this.Kvl[0] - ((float) i.this.Kvm) > 300.0f || i.this.Kvl[0] - ((float) i.this.Kvm) < -300.0f) {
                            i.this.Kvm = (int) i.this.Kvl[0];
                        } else {
                            i.this.Kvm = (int) ((((double) i.this.Kvm) * 0.6d) + (((double) i.this.Kvl[0]) * 0.4d));
                        }
                        if (i.this.Kvm == 0) {
                            i.this.Kvm = 1;
                        }
                        if (i.this.Kvm == 365) {
                            i.this.Kvm = 364;
                        }
                        if (i.this.Kvn == -10000) {
                            i.this.Kvn = (int) i.this.Kvl[1];
                            AppMethodBeat.o(152385);
                            return;
                        } else if (i.this.Kvl[1] < -68.0f) {
                            int i2 = (int) (-68.0d + (((double) (i.this.Kvl[1] + 68.0f)) / 1.5d));
                            if (i2 < -89) {
                                i2 = -89;
                            }
                            i.this.Kvn = i2;
                            AppMethodBeat.o(152385);
                            return;
                        } else if (i.this.Kvl[1] > 89.0f) {
                            i.this.Kvn = 89;
                            AppMethodBeat.o(152385);
                            return;
                        } else {
                            i.this.Kvn = (int) ((((double) i.this.Kvn) * 0.6d) + (((double) i.this.Kvl[1]) * 0.4d));
                        }
                    }
                    AppMethodBeat.o(152385);
                }

                public final void onAccuracyChanged(Sensor sensor, int i2) {
                    AppMethodBeat.i(152386);
                    Log.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
                    AppMethodBeat.o(152386);
                }
            };
        }
        boolean registerListener = this.Kvo.registerListener(this.Jtm, this.Kvo.getDefaultSensor(3), 3);
        this.hasInit = true;
        Log.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", Boolean.valueOf(registerListener));
        AppMethodBeat.o(152390);
    }

    private void gsx() {
        AppMethodBeat.i(152391);
        Log.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
        if (!(this.Kvo == null || this.Jtm == null)) {
            Log.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
            this.Kvo.unregisterListener(this.Jtm);
            this.Kvo = null;
            this.Jtm = null;
        }
        this.hasInit = false;
        AppMethodBeat.o(152391);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.y.a
    public final String getName() {
        return "HeadingPitchSensorMgr";
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.y.a
    public final void gbt() {
        AppMethodBeat.i(152392);
        Kvp = null;
        gsx();
        AppMethodBeat.o(152392);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.y.a
    public final void hU(Context context) {
        AppMethodBeat.i(152393);
        iB(context);
        AppMethodBeat.o(152393);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.y.a
    public final void gbu() {
        AppMethodBeat.i(152394);
        gsx();
        AppMethodBeat.o(152394);
    }
}
