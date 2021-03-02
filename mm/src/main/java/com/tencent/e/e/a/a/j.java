package com.tencent.e.e.a.a;

import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j {
    public final int RNh;
    public final long timestamp;
    public final float[] values;

    public j(SensorEvent sensorEvent, long j2) {
        AppMethodBeat.i(138414);
        this.RNh = sensorEvent.sensor.getType();
        this.timestamp = j2;
        this.values = Arrays.copyOf(sensorEvent.values, sensorEvent.values.length);
        AppMethodBeat.o(138414);
    }
}
