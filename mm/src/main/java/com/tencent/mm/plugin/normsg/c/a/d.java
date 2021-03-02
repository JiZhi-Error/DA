package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.Arrays;

public final class d {
    public long timestamp;
    public float[] values;

    public d(SensorEvent sensorEvent) {
        AppMethodBeat.i(187600);
        this.values = new float[3];
        this.timestamp = 0;
        b(sensorEvent);
        AppMethodBeat.o(187600);
    }

    public d() {
        AppMethodBeat.i(187601);
        this.values = new float[3];
        this.timestamp = 0;
        reset();
        AppMethodBeat.o(187601);
    }

    public final void b(SensorEvent sensorEvent) {
        AppMethodBeat.i(187602);
        if (sensorEvent == null || sensorEvent.values == null) {
            reset();
            AppMethodBeat.o(187602);
            return;
        }
        if (sensorEvent.values.length > 0) {
            this.values[0] = sensorEvent.values[0];
        }
        if (sensorEvent.values.length > 1) {
            this.values[1] = sensorEvent.values[1];
        }
        if (sensorEvent.values.length > 2) {
            this.values[2] = sensorEvent.values[2];
        }
        this.timestamp = sensorEvent.timestamp / TimeUtil.SECOND_TO_US;
        AppMethodBeat.o(187602);
    }

    public final void reset() {
        AppMethodBeat.i(187603);
        Arrays.fill(this.values, Float.NaN);
        this.timestamp = 0;
        AppMethodBeat.o(187603);
    }
}
