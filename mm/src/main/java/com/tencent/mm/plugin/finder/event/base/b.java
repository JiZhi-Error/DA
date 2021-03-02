package com.tencent.mm.plugin.finder.event.base;

import android.os.SystemClock;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/Event;", "", "()V", AppMeasurement.Param.TIMESTAMP, "", "getTimestamp", "()J", "timestampMs", "getTimestampMs", "plugin-finder_release"})
public class b {
    public final long tHW = cl.aWA();
    private final long timestamp = SystemClock.uptimeMillis();

    public b() {
        AppMethodBeat.i(165551);
        AppMethodBeat.o(165551);
    }

    public final long dao() {
        return this.tHW;
    }
}
