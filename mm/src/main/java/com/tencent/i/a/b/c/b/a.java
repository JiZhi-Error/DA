package com.tencent.i.a.b.c.b;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.SystemClock;
import com.tencent.h.c.h;
import com.tencent.i.a.c.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public boolean BTt = false;
    public int Sru;
    private long Srv = 0;
    public b Srw = null;
    public List<g> Srx = new ArrayList();
    public long Sry;
    private long Sx = this.Srv;
    public Sensor pKK;

    public a(Sensor sensor, int i2) {
        AppMethodBeat.i(214714);
        this.pKK = sensor;
        this.Sru = i2 > 0 ? 1000 / i2 : i2;
        h.i("sensor_EventController", "[method: SCMode ] mFrequencyInterval : " + this.Sru);
        AppMethodBeat.o(214714);
    }

    public final long OJ(long j2) {
        AppMethodBeat.i(214715);
        long j3 = j2 / TimeUtil.SECOND_TO_US;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j4 = (j3 - uptimeMillis) - this.Sx;
        if (this.Sx == this.Srv || j4 >= 1000) {
            this.Sx = j3 - uptimeMillis;
            h.i("sensor_EventController", "[method: calculateTimestamp ] timestamp : " + j2 + ", mDeltaTime : " + this.Sx + "curt : " + uptimeMillis + ", deltaInterval : " + j4);
        }
        long j5 = j3 - this.Sx;
        AppMethodBeat.o(214715);
        return j5;
    }

    public static b a(SensorEvent sensorEvent, b bVar) {
        if (sensorEvent == null || bVar == null) {
            return null;
        }
        if (sensorEvent.values != null && sensorEvent.values.length > 0) {
            bVar.values[0] = sensorEvent.values[0];
        }
        if (sensorEvent.values != null && sensorEvent.values.length > 1) {
            bVar.values[1] = sensorEvent.values[1];
        }
        if (sensorEvent.values != null && sensorEvent.values.length > 2) {
            bVar.values[2] = sensorEvent.values[2];
        }
        bVar.timestamp = sensorEvent.timestamp;
        return bVar;
    }

    public final b hqs() {
        AppMethodBeat.i(214716);
        if (this.Srw == null) {
            this.Srw = new b();
        }
        b bVar = this.Srw;
        AppMethodBeat.o(214716);
        return bVar;
    }

    public final List<g> hqt() {
        AppMethodBeat.i(214717);
        if (this.Srx == null || this.Srx.size() <= 0) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(214717);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(this.Srx);
        clearBuffer();
        AppMethodBeat.o(214717);
        return arrayList2;
    }

    public final int hqu() {
        AppMethodBeat.i(214718);
        int size = this.Srx.size();
        AppMethodBeat.o(214718);
        return size;
    }

    private void clearBuffer() {
        AppMethodBeat.i(214719);
        this.Srx.clear();
        AppMethodBeat.o(214719);
    }
}
