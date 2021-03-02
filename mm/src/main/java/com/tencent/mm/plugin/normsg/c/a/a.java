package com.tencent.mm.plugin.normsg.c.a;

import android.hardware.Sensor;
import android.os.Message;
import com.tencent.e.f.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.normsg.c;
import com.tencent.mm.plugin.normsg.c.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.List;

public final class a implements b.a {
    private static final j<a> AEL = new j<a>() {
        /* class com.tencent.mm.plugin.normsg.c.a.a.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.e.f.j
        public final /* synthetic */ a oR() {
            AppMethodBeat.i(187582);
            a aVar = new a();
            AppMethodBeat.o(187582);
            return aVar;
        }
    };
    final b AEM = new b(this);
    e AEN = new e();
    final MMHandler luO = new MMHandler("NormsgSensorEngineWorker") {
        /* class com.tencent.mm.plugin.normsg.c.a.a.AnonymousClass2 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(187583);
            try {
                a aVar = a.this;
                switch (message.what) {
                    case 1:
                        Log.d("MicroMsg.NormsgSensorEngine", "Start record sensor");
                        int i2 = message.arg1;
                        aVar.luO.removeMessages(6);
                        e eVar = aVar.AEN;
                        c.p.fa((String) message.obj, i2, 200);
                        if (eVar.AEW) {
                            c.p.fd();
                        }
                        for (Integer num : eVar.AEX) {
                            c.p.fe(num.intValue());
                        }
                        for (Integer num2 : eVar.AEY) {
                            c.p.ff(num2.intValue());
                        }
                        if (aVar.AEM.AEP.get()) {
                            Log.i("MicroMsg.NormsgSensorEngine", "SensorListener is already started");
                            AppMethodBeat.o(187583);
                            return;
                        }
                        b bVar = aVar.AEM;
                        bVar.AER.clear();
                        int[] iArr = com.tencent.mm.plugin.normsg.c.a.a.b.AEZ;
                        for (int i3 : iArr) {
                            if (com.tencent.mm.plugin.normsg.c.a.a.a.TO(i3) == 0) {
                                Log.e("MicroMsg.NormsgSensorListener", "Unknown sensor type ".concat(String.valueOf(i3)));
                            } else {
                                Sensor defaultSensor = bVar.mSensorManager.getDefaultSensor(i3);
                                int TO = com.tencent.mm.plugin.normsg.c.a.a.a.TO(i3);
                                if (defaultSensor == null) {
                                    Log.i("MicroMsg.NormsgSensorListener", "Device has no sensor ".concat(String.valueOf(TO)));
                                    bVar.AEQ.hA(1, TO);
                                } else {
                                    bVar.AER.put(Integer.valueOf(TO), new c(defaultSensor));
                                    if (!bVar.mSensorManager.registerListener(bVar, defaultSensor, 0)) {
                                        bVar.AEQ.hA(2, TO);
                                    }
                                }
                            }
                        }
                        if (bVar.AER.isEmpty()) {
                            bVar.AEQ.hA(3, 0);
                            bVar.AEP.set(false);
                            AppMethodBeat.o(187583);
                            return;
                        }
                        bVar.AEP.set(true);
                        AppMethodBeat.o(187583);
                        return;
                    case 2:
                        int i4 = message.arg1;
                        List list = (List) message.obj;
                        if (list == null || list.isEmpty()) {
                            Log.e("MicroMsg.NormsgSensorEngine", "Sensor buffer is empty");
                            AppMethodBeat.o(187583);
                            return;
                        } else if (list == null || list.isEmpty()) {
                            AppMethodBeat.o(187583);
                            return;
                        } else {
                            c.p.fb(i4, list);
                            AppMethodBeat.o(187583);
                            return;
                        }
                    case 3:
                        Log.d("MicroMsg.NormsgSensorEngine", "Try stop record sensor");
                        String str = (String) message.obj;
                        if (c.p.fg(str)) {
                            aVar.aIV(str);
                            AppMethodBeat.o(187583);
                            return;
                        }
                        int fl = c.p.fl(str);
                        if (fl >= 0) {
                            c.p.fh(str);
                            aVar.a(4, str, (long) com.tencent.mm.plugin.normsg.c.a.a.b.TP(fl));
                        }
                        AppMethodBeat.o(187583);
                        return;
                    case 4:
                        Log.d("MicroMsg.NormsgSensorEngine", "Stop record sensor immediate");
                        aVar.aIV((String) message.obj);
                        AppMethodBeat.o(187583);
                        return;
                    case 5:
                        Log.d("MicroMsg.NormsgSensorEngine", "Cancel record sensor");
                        aVar.aIW((String) message.obj);
                        AppMethodBeat.o(187583);
                        return;
                    case 6:
                        Log.d("MicroMsg.NormsgSensorEngine", "Stop sensor listener");
                        if (aVar.AEM.AEP.get()) {
                            b bVar2 = aVar.AEM;
                            for (c cVar : bVar2.AER.values()) {
                                bVar2.mSensorManager.unregisterListener(bVar2, cVar.pKK);
                            }
                            bVar2.AEP.set(false);
                            bVar2.AER.clear();
                        }
                        e eVar2 = aVar.AEN;
                        eVar2.AEW = false;
                        eVar2.AEX.clear();
                        eVar2.AEY.clear();
                        c.p.fk();
                        break;
                }
                AppMethodBeat.o(187583);
            } catch (Throwable th) {
                Log.e("MicroMsg.NormsgSensorEngine", "NormsgSensorEngineWorker handle msg error:" + th.getMessage());
                AppMethodBeat.o(187583);
            }
        }
    };

    public a() {
        AppMethodBeat.i(187584);
        AppMethodBeat.o(187584);
    }

    static {
        AppMethodBeat.i(187594);
        AppMethodBeat.o(187594);
    }

    public static a exU() {
        AppMethodBeat.i(187585);
        a aVar = AEL.get();
        AppMethodBeat.o(187585);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.normsg.c.a.b.a
    public final void hA(int i2, int i3) {
        AppMethodBeat.i(187586);
        if (i2 == 1) {
            this.AEN.AEY.add(Integer.valueOf(i3));
            c.p.ff(i3);
            AppMethodBeat.o(187586);
        } else if (i2 == 2) {
            this.AEN.AEX.add(Integer.valueOf(i3));
            c.p.fe(i3);
            AppMethodBeat.o(187586);
        } else {
            if (i2 == 3) {
                this.AEN.AEW = true;
                c.p.fd();
            }
            AppMethodBeat.o(187586);
        }
    }

    @Override // com.tencent.mm.plugin.normsg.c.a.b.a
    public final void p(int i2, List<com.tencent.mm.normsg.b> list) {
        AppMethodBeat.i(187587);
        g(2, i2, list);
        AppMethodBeat.o(187587);
    }

    private void exV() {
        AppMethodBeat.i(187590);
        a(6, 0, null, 0);
        AppMethodBeat.o(187590);
    }

    public final void g(int i2, int i3, Object obj) {
        AppMethodBeat.i(187591);
        a(i2, i3, obj, 0);
        AppMethodBeat.o(187591);
    }

    public final void a(int i2, Object obj, long j2) {
        AppMethodBeat.i(187592);
        a(i2, 0, obj, j2);
        AppMethodBeat.o(187592);
    }

    private void a(int i2, int i3, Object obj, long j2) {
        AppMethodBeat.i(187593);
        try {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = i3;
            obtain.obj = obj;
            this.luO.sendMessageDelayed(obtain, j2);
            AppMethodBeat.o(187593);
        } catch (Throwable th) {
            Log.e("MicroMsg.NormsgSensorEngine", "Send msg error: %s" + th.getMessage());
            AppMethodBeat.o(187593);
        }
    }

    /* access modifiers changed from: package-private */
    public final void aIV(String str) {
        AppMethodBeat.i(187588);
        byte[] fi = c.p.fi(str);
        if (fi != null) {
            rz rzVar = new rz();
            rzVar.dYA.buffer = fi;
            rzVar.dYA.dYB = str;
            EventCenter.instance.publish(rzVar);
        } else {
            Log.w("MicroMsg.NormsgSensorEngine", "Can't get encrypted sensor data: ".concat(String.valueOf(str)));
        }
        aIW(str);
        AppMethodBeat.o(187588);
    }

    /* access modifiers changed from: package-private */
    public final void aIW(String str) {
        AppMethodBeat.i(187589);
        c.p.fj(str);
        if (c.p.fc()) {
            AppMethodBeat.o(187589);
            return;
        }
        exV();
        AppMethodBeat.o(187589);
    }
}
