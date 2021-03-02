package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.b;
import java.util.ArrayList;
import java.util.List;

public final class c {
    d AES = new d();
    boolean AET = false;
    List<b> AEU = new ArrayList();
    long AEV = 0;
    Sensor pKK;

    public c(Sensor sensor) {
        AppMethodBeat.i(187597);
        this.pKK = sensor;
        AppMethodBeat.o(187597);
    }

    /* access modifiers changed from: package-private */
    public final void a(SensorEvent sensorEvent) {
        AppMethodBeat.i(187598);
        a(new d(sensorEvent));
        AppMethodBeat.o(187598);
    }

    /* access modifiers changed from: package-private */
    public final void a(d dVar) {
        AppMethodBeat.i(187599);
        b bVar = new b();
        bVar.fa = dVar.values[0];
        bVar.fb = dVar.values[1];
        bVar.fc = dVar.values[2];
        bVar.fd = dVar.timestamp;
        this.AEU.add(bVar);
        this.AEV = dVar.timestamp;
        this.AES.reset();
        AppMethodBeat.o(187599);
    }
}
