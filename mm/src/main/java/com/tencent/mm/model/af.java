package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ay;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class af implements ay.b {
    private ay.b iCV;

    public interface b {
        ay.b aVi();

        boolean aj(String str, int i2);
    }

    public af(ay.b bVar) {
        this.iCV = bVar;
    }

    public final ay.b aVf() {
        return this.iCV;
    }

    public static class a {
        private static ConcurrentLinkedQueue<b> iCW = new ConcurrentLinkedQueue<>();

        static {
            AppMethodBeat.i(229788);
            AppMethodBeat.o(229788);
        }

        public static void a(b bVar) {
            AppMethodBeat.i(229786);
            iCW.add(bVar);
            AppMethodBeat.o(229786);
        }

        public static void b(b bVar) {
            AppMethodBeat.i(229787);
            iCW.remove(bVar);
            AppMethodBeat.o(229787);
        }
    }

    @Override // com.tencent.mm.model.ay.b
    public final void aL(String str, String str2) {
        AppMethodBeat.i(229789);
        Iterator it = a.iCW.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.aj(str, 0)) {
                bVar.aVi().aL(str, str2);
                Log.i("MicroMsg.GetContactServiceProxy", "[addContact] has consume. interceptor=%s", bVar);
                AppMethodBeat.o(229789);
                return;
            }
        }
        this.iCV.aL(str, str2);
        AppMethodBeat.o(229789);
    }

    @Override // com.tencent.mm.model.ay.b
    public final void j(String str, int i2, String str2) {
        AppMethodBeat.i(229790);
        Iterator it = a.iCW.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.aj(str, i2)) {
                bVar.aVi().j(str, i2, str2);
                Log.i("MicroMsg.GetContactServiceProxy", "[addContactExtra] has consume. interceptor=%s", bVar);
                AppMethodBeat.o(229790);
                return;
            }
        }
        this.iCV.j(str, i2, str2);
        AppMethodBeat.o(229790);
    }

    @Override // com.tencent.mm.model.ay.b
    public final void a(String str, String str2, ay.b.a aVar) {
        AppMethodBeat.i(229791);
        Iterator it = a.iCW.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.aj(str, 0)) {
                bVar.aVi().a(str, str2, aVar);
                Log.i("MicroMsg.GetContactServiceProxy", "[getNow] has consume. interceptor=%s", bVar);
                AppMethodBeat.o(229791);
                return;
            }
        }
        this.iCV.a(str, str2, aVar);
        AppMethodBeat.o(229791);
    }

    @Override // com.tencent.mm.model.ay.b
    public final void JZ(String str) {
        AppMethodBeat.i(229792);
        Iterator it = a.iCW.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.aj(str, 0)) {
                bVar.aVi().JZ(str);
                Log.i("MicroMsg.GetContactServiceProxy", "[removeCallBack] has consume. interceptor=%s", bVar);
                AppMethodBeat.o(229792);
                return;
            }
        }
        this.iCV.JZ(str);
        AppMethodBeat.o(229792);
    }

    @Override // com.tencent.mm.model.ay.b
    public final void Ka(String str) {
        AppMethodBeat.i(229793);
        Iterator it = a.iCW.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.aj(str, 0)) {
                bVar.aVi().Ka(str);
                Log.i("MicroMsg.GetContactServiceProxy", "[clearMapRecentDown] has consume. interceptor=%s", bVar);
                AppMethodBeat.o(229793);
                return;
            }
        }
        this.iCV.Ka(str);
        AppMethodBeat.o(229793);
    }

    @Override // com.tencent.mm.model.ay.b
    public final void aVg() {
        AppMethodBeat.i(229794);
        this.iCV.aVg();
        AppMethodBeat.o(229794);
    }
}
