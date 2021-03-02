package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class g {
    private static int Iyf = 0;
    private HashMap<String, f> tyt = new HashMap<>();

    public g() {
        AppMethodBeat.i(30014);
        AppMethodBeat.o(30014);
    }

    public final synchronized f aWj(String str) {
        f fVar;
        AppMethodBeat.i(30015);
        if (this.tyt.containsKey(str)) {
            fVar = (f) this.tyt.get(str).clone();
            AppMethodBeat.o(30015);
        } else {
            Iyf++;
            f fVar2 = new f();
            fVar2.talker = str;
            fVar2.id = Iyf;
            fVar2.IxZ = f.a.INIT;
            this.tyt.put(str, fVar2);
            fVar = (f) fVar2.clone();
            AppMethodBeat.o(30015);
        }
        return fVar;
    }

    public final synchronized void aWk(String str) {
        AppMethodBeat.i(30016);
        Log.i("MicroMsg.Wear.WearNotificationMap", "reset notification talker=%s", str);
        if (this.tyt.containsKey(str)) {
            this.tyt.get(str).IxZ = f.a.INIT;
            this.tyt.get(str).IxY = 0;
        }
        AppMethodBeat.o(30016);
    }

    public final synchronized void a(f fVar) {
        AppMethodBeat.i(30017);
        Log.i("MicroMsg.Wear.WearNotificationMap", "update notification=%s", fVar);
        this.tyt.put(fVar.talker, fVar);
        AppMethodBeat.o(30017);
    }

    public final synchronized void aWl(String str) {
        AppMethodBeat.i(30018);
        if (this.tyt.containsKey(str)) {
            f fVar = this.tyt.get(str);
            fVar.IxZ = f.a.REPLY;
            fVar.IxY = 0;
            Log.i("MicroMsg.Wear.WearNotificationMap", "Update reply success, notification=%s", fVar);
        }
        AppMethodBeat.o(30018);
    }

    public final synchronized void gc(String str, int i2) {
        AppMethodBeat.i(30019);
        if (this.tyt.containsKey(str)) {
            f fVar = this.tyt.get(str);
            fVar.IxZ = f.a.IGNORE;
            fVar.IxY = i2;
            Log.i("MicroMsg.Wear.WearNotificationMap", "Update ignore success, notification=%s", fVar);
        }
        AppMethodBeat.o(30019);
    }

    public final synchronized void aWm(String str) {
        AppMethodBeat.i(30020);
        if (this.tyt.containsKey(str)) {
            f fVar = this.tyt.get(str);
            fVar.IxZ = f.a.SHOWING;
            Log.i("MicroMsg.Wear.WearNotificationMap", "Update showing success, notification=%s", fVar);
        }
        AppMethodBeat.o(30020);
    }
}
