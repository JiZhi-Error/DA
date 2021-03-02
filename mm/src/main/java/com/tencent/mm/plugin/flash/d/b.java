package com.tencent.mm.plugin.flash.d;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b {
    private boolean mHasStarted;
    private SensorManager mSensorManager;
    public a wIL;

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
        this.mHasStarted = false;
    }

    /* renamed from: com.tencent.mm.plugin.flash.d.b$b */
    public static class C1358b {
        private static b wIN = new b((byte) 0);

        static {
            AppMethodBeat.i(186699);
            AppMethodBeat.o(186699);
        }
    }

    public final void dLl() {
        AppMethodBeat.i(186700);
        if (this.mHasStarted) {
            AppMethodBeat.o(186700);
            return;
        }
        this.mHasStarted = true;
        new StringBuilder("lightSensor has started:").append(this.mHasStarted);
        this.mSensorManager = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
        Sensor defaultSensor = this.mSensorManager.getDefaultSensor(5);
        if (defaultSensor != null) {
            this.wIL = new a(this, (byte) 0);
            this.mSensorManager.registerListener(this.wIL, defaultSensor, 3);
        }
        AppMethodBeat.o(186700);
    }

    public final void stop() {
        AppMethodBeat.i(186701);
        if (!this.mHasStarted || this.mSensorManager == null) {
            AppMethodBeat.o(186701);
            return;
        }
        this.mHasStarted = false;
        this.mSensorManager.unregisterListener(this.wIL);
        AppMethodBeat.o(186701);
    }

    public class a implements SensorEventListener {
        private float lux;

        private a() {
            b.this = r1;
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.i(186698);
            if (sensorEvent.sensor.getType() == 5) {
                this.lux = sensorEvent.values[0];
            }
            AppMethodBeat.o(186698);
        }

        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }
    }
}
