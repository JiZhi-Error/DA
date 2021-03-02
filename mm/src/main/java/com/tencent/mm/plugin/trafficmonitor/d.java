package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public final class d extends e {
    public final String TAG = "MicroMsg.NsmTrafficStatsInspector";
    private Timer dfh = null;
    private TimerTask dfi = null;
    private boolean started;

    @Override // com.tencent.mm.plugin.trafficmonitor.e
    public final void fAh() {
        AppMethodBeat.i(123899);
        if (this.started) {
            AppMethodBeat.o(123899);
            return;
        }
        this.currentIndex = 0;
        c.init(this.id);
        c.reset(this.id);
        c.update(this.id);
        this.dfi = new TimerTask() {
            /* class com.tencent.mm.plugin.trafficmonitor.d.AnonymousClass1 */

            public final void run() {
                long j2;
                long j3;
                long j4;
                AppMethodBeat.i(123898);
                c.update(d.this.id);
                int i2 = d.this.type;
                long currentTimeMillis = System.currentTimeMillis();
                MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("trafficmonitor");
                long decodeLong = singleMMKV.decodeLong("trafficmonitor_" + d.this.interval, 0);
                long j5 = currentTimeMillis - decodeLong;
                singleMMKV.encode("trafficmonitor_" + d.this.interval, currentTimeMillis);
                if (i2 == 0) {
                    long acm = c.acm(d.this.id) + c.acl(d.this.id);
                    j2 = acm;
                    j3 = 0;
                    j4 = acm;
                } else if (i2 == 1) {
                    long ack = c.ack(d.this.id) + c.acj(d.this.id);
                    j2 = ack;
                    j3 = ack;
                    j4 = 0;
                } else if (i2 == 2) {
                    long acm2 = c.acm(d.this.id) + c.acl(d.this.id);
                    long ack2 = c.ack(d.this.id) + c.acj(d.this.id);
                    j2 = ack2 + acm2;
                    j3 = ack2;
                    j4 = acm2;
                } else {
                    AppMethodBeat.o(123898);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int a2 = TrafficClickFlowReceiver.a(d.this.currentIndex, currentTimeMillis - d.this.interval, arrayList);
                if (a2 == -1) {
                    AppMethodBeat.o(123898);
                    return;
                }
                d.this.currentIndex = a2;
                if (d.KL(decodeLong)) {
                    Log.i("MicroMsg.NsmTrafficStatsInspector", "isDownloadAndNormal");
                    d.this.fAj();
                    AppMethodBeat.o(123898);
                    return;
                }
                Log.i("MicroMsg.NsmTrafficStatsInspector", "wxTotalTraffic : %d , interval : %d", Long.valueOf(j2), Long.valueOf(d.this.interval));
                if (d.this.GsO.a(arrayList, j2, d.this.interval, j5)) {
                    Double valueOf = Double.valueOf(d.this.GsO.GsU);
                    String valueOf2 = String.valueOf(valueOf);
                    int round = (int) Math.round(valueOf.doubleValue());
                    int i3 = 0;
                    if (round > 3 && round <= 4) {
                        i3 = 60;
                    } else if (round > 4 && round <= 5) {
                        i3 = 61;
                    } else if (round > 5 && round <= 6) {
                        i3 = 62;
                    } else if (round > 6 && round <= 7) {
                        i3 = 63;
                    } else if (round > 7) {
                        i3 = 64;
                    }
                    Log.i("MicroMsg.NsmTrafficStatsInspector", "Traffic Execced ExceedIndex : %s", valueOf2);
                    e.INSTANCE.idkeyStat(877, (long) i3, 1, true);
                    e.INSTANCE.a(15856, Long.valueOf(d.this.interval), arrayList.toString(), Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(d.this.GsO.GsT), valueOf2, Integer.valueOf(round));
                }
                d.this.fAj();
                AppMethodBeat.o(123898);
            }
        };
        this.dfh = new Timer();
        try {
            this.dfh.schedule(this.dfi, 0, this.interval);
        } catch (IllegalArgumentException e2) {
            Log.e("MicroMsg.NsmTrafficStatsInspector", "timer.schedule got an IllegalArgumentException, %s", e2.getMessage());
        }
        this.started = true;
        AppMethodBeat.o(123899);
    }
}
