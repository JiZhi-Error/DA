package com.tencent.map.tools.orientation;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class OrientationManager extends OrientationEventListener implements SensorEventListener {
    private Context contextObj = null;
    private float mLastAngle;
    private List<OrientationListener> mListeners = new ArrayList();
    private int mOrientation;

    public OrientationManager(Context context) {
        super(context, 3);
        AppMethodBeat.i(180942);
        this.contextObj = context;
        AppMethodBeat.o(180942);
    }

    public void destroy() {
        AppMethodBeat.i(180943);
        this.mListeners.clear();
        try {
            disable();
            SensorManager sensorManager = (SensorManager) this.contextObj.getSystemService("sensor");
            if (!sensorManager.getSensorList(3).isEmpty()) {
                sensorManager.unregisterListener(this);
            }
        } catch (Exception e2) {
        }
        this.contextObj = null;
        AppMethodBeat.o(180943);
    }

    public void addOrientationListener(OrientationListener orientationListener) {
        AppMethodBeat.i(180944);
        if (!this.mListeners.contains(orientationListener)) {
            this.mListeners.add(orientationListener);
            if (this.mListeners.size() == 1) {
                try {
                    enable();
                    SensorManager sensorManager = (SensorManager) this.contextObj.getSystemService("sensor");
                    List<Sensor> sensorList = sensorManager.getSensorList(3);
                    if (!sensorList.isEmpty()) {
                        sensorManager.registerListener(this, sensorList.get(0), 2);
                    }
                    AppMethodBeat.o(180944);
                    return;
                } catch (Exception e2) {
                }
            }
        }
        AppMethodBeat.o(180944);
    }

    public void removeOrientationListener(OrientationListener orientationListener) {
        AppMethodBeat.i(180945);
        if (this.mListeners.contains(orientationListener)) {
            this.mListeners.remove(orientationListener);
            if (this.mListeners.isEmpty()) {
                try {
                    disable();
                    SensorManager sensorManager = (SensorManager) this.contextObj.getSystemService("sensor");
                    if (!sensorManager.getSensorList(3).isEmpty()) {
                        sensorManager.unregisterListener(this);
                    }
                    AppMethodBeat.o(180945);
                    return;
                } catch (Exception e2) {
                }
            }
        }
        AppMethodBeat.o(180945);
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078 A[Catch:{ OutOfMemoryError -> 0x0084, ArrayIndexOutOfBoundsException -> 0x00a9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSensorChanged(android.hardware.SensorEvent r11) {
        /*
        // Method dump skipped, instructions count: 179
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.tools.orientation.OrientationManager.onSensorChanged(android.hardware.SensorEvent):void");
    }

    public void onOrientationChanged(int i2) {
        if (i2 >= 0) {
            this.mOrientation = i2;
        }
    }
}
