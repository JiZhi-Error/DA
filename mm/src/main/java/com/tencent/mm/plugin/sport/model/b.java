package com.tencent.mm.plugin.sport.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ck;
import java.util.Calendar;
import org.json.JSONObject;

public final class b {
    public IListener<wp> FiY = new IListener<wp>() {
        /* class com.tencent.mm.plugin.sport.model.b.AnonymousClass2 */

        {
            AppMethodBeat.i(161591);
            this.__eventId = wp.class.getName().hashCode();
            AppMethodBeat.o(161591);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wp wpVar) {
            boolean z;
            AppMethodBeat.i(149285);
            wp wpVar2 = wpVar;
            switch (wpVar2.ecH.action) {
                case 1:
                case 2:
                case 3:
                    if (k.fmK()) {
                        long fmH = k.fmH();
                        long aJ = j.aJ(513, 0);
                        long aJ2 = j.aJ(512, 0);
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(aJ);
                        instance.set(11, 0);
                        instance.set(12, 0);
                        instance.set(13, 0);
                        instance.set(14, 0);
                        if (fmH != instance.getTimeInMillis()) {
                            aJ2 = 0;
                        }
                        if (wpVar2.ecH.action == 1) {
                            z = b.this.Kd(aJ2);
                            ge geVar = new ge();
                            geVar.dJP.action = 1;
                            EventCenter.instance.asyncPublish(geVar, Looper.getMainLooper());
                        } else if (k.as(b.this.fmo(), aJ2)) {
                            z = b.this.Kd(aJ2);
                        } else {
                            z = false;
                        }
                        Log.i("MicroMsg.Sport.ExtApiStepManager", "upload step %d %d %b", Integer.valueOf(wpVar2.ecH.action), Long.valueOf(aJ2), Boolean.valueOf(z));
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(149285);
            return false;
        }
    };
    public e FiZ;
    public IListener Fjg = new IListener<ge>() {
        /* class com.tencent.mm.plugin.sport.model.b.AnonymousClass1 */

        {
            AppMethodBeat.i(161590);
            this.__eventId = ge.class.getName().hashCode();
            AppMethodBeat.o(161590);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ge geVar) {
            AppMethodBeat.i(149284);
            boolean i2 = b.this.i(geVar);
            AppMethodBeat.o(149284);
            return i2;
        }
    };
    private long Fjh;
    private long Fji;

    public b() {
        AppMethodBeat.i(149286);
        this.Fjg.alive();
        this.FiY.alive();
        AppMethodBeat.o(149286);
    }

    /* access modifiers changed from: package-private */
    public final boolean i(IEvent iEvent) {
        int i2;
        AppMethodBeat.i(149287);
        ge geVar = (ge) iEvent;
        switch (geVar.dJP.action) {
            case 2:
                long j2 = geVar.dJP.dJS;
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = geVar.dJP.bqc;
                ge.b bVar = geVar.dJQ;
                if (!k.fmg()) {
                    i2 = 3906;
                } else if (!k.fmK()) {
                    i2 = 3902;
                } else {
                    long aJ = j.aJ(513, 0);
                    long aJ2 = j.aJ(512, 0);
                    Log.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", Long.valueOf(aJ), Long.valueOf(aJ2), Long.valueOf(currentTimeMillis), Long.valueOf(j2));
                    if (currentTimeMillis - aJ < 300000) {
                        Log.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
                        i2 = 3903;
                    } else {
                        JSONObject fmy = g.fmy();
                        if (!Util.isSameDay(currentTimeMillis, aJ)) {
                            aJ = Util.getBeginTimeOfToday();
                            aJ2 = 0;
                        }
                        long j4 = currentTimeMillis - aJ;
                        long j5 = (j4 / 300000) + ((long) (j4 % 300000 > 0 ? 1 : 0));
                        long optInt = ((long) fmy.optInt("stepCounterMaxStep5m")) * j5;
                        Log.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(currentTimeMillis), Long.valueOf(aJ), Long.valueOf(optInt));
                        long j6 = j2 - aJ2;
                        if (j6 < 0 || j6 > optInt) {
                            Log.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", Long.valueOf(j6), Long.valueOf(optInt));
                            i2 = 3904;
                        } else {
                            Log.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", k.AF(currentTimeMillis), Long.valueOf(j2));
                            j.aK(513, currentTimeMillis);
                            j.aK(512, j2);
                            j.aK(514, j3);
                            i2 = 1;
                        }
                    }
                }
                bVar.dJU = i2;
                if (geVar.dJQ.dJU == 1) {
                    if (this.Fjh == 0) {
                        this.Fjh = j.aJ(515, 0);
                    }
                    boolean ar = k.ar(this.Fjh, System.currentTimeMillis());
                    boolean as = k.as(fmo(), j2);
                    if (ar && as) {
                        Kd(j2);
                    }
                }
                geVar.dJQ.dJT = true;
                break;
            case 3:
                try {
                    JSONObject optJSONObject = g.fmy().optJSONObject("extStepApiConfig");
                    if (optJSONObject != null) {
                        geVar.dJQ.config = optJSONObject.toString();
                    }
                    if (Util.isNullOrNil(geVar.dJQ.config)) {
                        geVar.dJQ.dJU = 3905;
                    } else {
                        geVar.dJQ.dJU = 1;
                    }
                } catch (Exception e2) {
                    geVar.dJQ.dJU = 3905;
                }
                geVar.dJQ.dJT = true;
                break;
        }
        AppMethodBeat.o(149287);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean Kd(long j2) {
        AppMethodBeat.i(149288);
        if (this.FiZ != null) {
            g.azz().a(this.FiZ);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        Log.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", k.AF(currentTimeMillis), Long.valueOf(j2));
        this.FiZ = new e("", "gh_43f2581f6fd6", (int) (instance.getTimeInMillis() / 1000), (int) (currentTimeMillis / 1000), (int) j2, ck.getFingerprint(), 2);
        g.azz().a(this.FiZ, 0);
        Ke(currentTimeMillis);
        Kf(j2);
        AppMethodBeat.o(149288);
        return true;
    }

    private void Ke(long j2) {
        AppMethodBeat.i(149289);
        this.Fjh = j2;
        j.aK(515, j2);
        AppMethodBeat.o(149289);
    }

    public final long fmo() {
        AppMethodBeat.i(149290);
        if (this.Fji == 0) {
            this.Fji = j.aJ(c.CTRL_INDEX, 0);
        }
        long j2 = this.Fji;
        AppMethodBeat.o(149290);
        return j2;
    }

    private void Kf(long j2) {
        AppMethodBeat.i(149291);
        this.Fji = j2;
        j.aJ(c.CTRL_INDEX, this.Fji);
        AppMethodBeat.o(149291);
    }
}
