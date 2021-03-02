package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;

public final class b extends e {
    private com.tencent.f.i.b GsA = null;
    public final String TAG = "MicroMsg.FileTrafficStatsInspector";
    private boolean started;

    @Override // com.tencent.mm.plugin.trafficmonitor.e
    public final void fAh() {
        AppMethodBeat.i(123889);
        if (this.started) {
            AppMethodBeat.o(123889);
            return;
        }
        this.currentIndex = 0;
        a.init(this.id);
        a.reset(this.id);
        a.update(this.id);
        this.GsA = new com.tencent.f.i.b() {
            /* class com.tencent.mm.plugin.trafficmonitor.b.AnonymousClass1 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "FileTrafficStatsInspector";
            }

            public final void run() {
                long j2;
                long j3;
                long j4;
                AppMethodBeat.i(123888);
                a.update(b.this.id);
                long j5 = 0;
                long j6 = 0;
                int i2 = b.this.type;
                long currentTimeMillis = System.currentTimeMillis();
                MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("trafficmonitor");
                long decodeLong = singleMMKV.decodeLong("trafficmonitor_" + b.this.interval, 0);
                long j7 = currentTimeMillis - decodeLong;
                singleMMKV.encode("trafficmonitor_" + b.this.interval, currentTimeMillis);
                if (i2 == 0) {
                    j5 = a.acm(b.this.id);
                    long acl = a.acl(b.this.id);
                    long j8 = j5 + acl;
                    j2 = j8;
                    j3 = 0;
                    j4 = j8;
                    j6 = acl;
                } else if (i2 == 1) {
                    long ack = a.ack(b.this.id) + a.acj(b.this.id);
                    j2 = ack;
                    j3 = ack;
                    j4 = 0;
                } else if (i2 == 2) {
                    j5 = a.acm(b.this.id);
                    long acl2 = a.acl(b.this.id);
                    long j9 = j5 + acl2;
                    long ack2 = a.ack(b.this.id) + a.acj(b.this.id);
                    j2 = ack2 + j9;
                    j3 = ack2;
                    j4 = j9;
                    j6 = acl2;
                } else {
                    AppMethodBeat.o(123888);
                    return;
                }
                long aci = a.aci(b.this.id);
                long ach = a.ach(b.this.id);
                if (aci < j5 || ach < j6) {
                    AppMethodBeat.o(123888);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int a2 = TrafficClickFlowReceiver.a(b.this.currentIndex, currentTimeMillis - b.this.interval, arrayList);
                if (a2 == -1) {
                    AppMethodBeat.o(123888);
                    return;
                }
                b.this.currentIndex = a2;
                if (b.KL(decodeLong)) {
                    Log.i("MicroMsg.FileTrafficStatsInspector", "isDownloadAndNormal");
                    b.this.fAj();
                    AppMethodBeat.o(123888);
                    return;
                }
                Log.i("MicroMsg.FileTrafficStatsInspector", "wxTotalTraffic : %d , interval : %d", Long.valueOf(j2), Long.valueOf(b.this.interval));
                if (b.this.GsO.a(arrayList, j2, b.this.interval, j7)) {
                    Double valueOf = Double.valueOf(b.this.GsO.GsU);
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
                    Log.i("MicroMsg.FileTrafficStatsInspector", "Traffic Execced ExceedIndex : %s", valueOf2);
                    e.INSTANCE.idkeyStat(877, (long) i3, 1, true);
                    e.INSTANCE.a(15856, Long.valueOf(b.this.interval), arrayList.toString(), Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(b.this.GsO.GsT), valueOf2, Integer.valueOf(round));
                }
                b.this.fAj();
                AppMethodBeat.o(123888);
            }
        };
        try {
            h.RTc.p(this.GsA, this.interval);
        } catch (IllegalArgumentException e2) {
            Log.e("MicroMsg.FileTrafficStatsInspector", "timer.schedule got an IllegalArgumentException, %s", e2.getMessage());
        }
        this.started = true;
        AppMethodBeat.o(123889);
    }
}
