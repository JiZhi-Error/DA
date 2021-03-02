package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b.AbstractC0842b {
    private Object lock = new Object();
    public b oLc;
    public b.AbstractC0842b oLd;
    public long oLe;
    public LinkedList<f.b> oLf = null;
    public LinkedList<f.b> oLg = null;
    public LinkedList<f.b> oLh = null;
    public boolean oLi = false;
    public boolean oLj = false;

    public a() {
        AppMethodBeat.i(21277);
        AppMethodBeat.o(21277);
    }

    public final LinkedList<f.b> cfq() {
        AppMethodBeat.i(21278);
        if (this.oLf == null) {
            LinkedList<f.b> linkedList = new LinkedList<>();
            AppMethodBeat.o(21278);
            return linkedList;
        }
        LinkedList<f.b> linkedList2 = this.oLf;
        AppMethodBeat.o(21278);
        return linkedList2;
    }

    private static long F(LinkedList<f.b> linkedList) {
        AppMethodBeat.i(21279);
        long j2 = 0;
        if (linkedList != null && linkedList.size() > 0) {
            long j3 = linkedList.get(0).oJr;
            Iterator<f.b> it = linkedList.iterator();
            while (true) {
                j2 = j3;
                if (!it.hasNext()) {
                    break;
                }
                f.b next = it.next();
                if (j2 > next.oJr) {
                    j3 = next.oJr;
                } else {
                    j3 = j2;
                }
            }
        }
        AppMethodBeat.o(21279);
        return j2;
    }

    public final LinkedList<f.b> cfr() {
        AppMethodBeat.i(21280);
        if (this.oLg == null) {
            LinkedList<f.b> linkedList = new LinkedList<>();
            AppMethodBeat.o(21280);
            return linkedList;
        }
        LinkedList<f.b> linkedList2 = this.oLg;
        AppMethodBeat.o(21280);
        return linkedList2;
    }

    public final void a(int i2, long j2, long j3, LinkedList<f.b> linkedList) {
        AppMethodBeat.i(21281);
        if (i2 == 0) {
            this.oLg = new LinkedList<>(linkedList);
            AppMethodBeat.o(21281);
            return;
        }
        this.oLg = new LinkedList<>();
        Iterator<f.b> it = linkedList.iterator();
        while (it.hasNext()) {
            f.b next = it.next();
            if (d.cgP().cgQ().aSQ().H(next.oJq, j2, j3) > 0) {
                this.oLg.add(next);
            }
        }
        AppMethodBeat.o(21281);
    }

    public final LinkedList<f.b> cfs() {
        AppMethodBeat.i(21282);
        if (this.oLh == null) {
            this.oLh = new LinkedList<>();
        }
        LinkedList<f.b> linkedList = this.oLh;
        AppMethodBeat.o(21282);
        return linkedList;
    }

    public final void cancel() {
        AppMethodBeat.i(21283);
        synchronized (this.lock) {
            try {
                if (this.oLc != null) {
                    this.oLc.cancel();
                    this.oLc = null;
                }
            } finally {
                AppMethodBeat.o(21283);
            }
        }
    }

    public final void cft() {
        AppMethodBeat.i(21284);
        b.cfv();
        SharedPreferences ceR = b.ceR();
        a(ceR.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), ceR.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0), ceR.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0), cfq());
        AppMethodBeat.o(21284);
    }

    @Override // com.tencent.mm.plugin.backup.c.b.a
    public final void C(LinkedList<f.b> linkedList) {
        AppMethodBeat.i(21285);
        Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
        this.oLi = true;
        this.oLf = new LinkedList<>(linkedList);
        this.oLe = F(this.oLf);
        cft();
        Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", Integer.valueOf(cfq().size()), Integer.valueOf(cfr().size()));
        if (this.oLd != null) {
            this.oLd.C(cfr());
        }
        AppMethodBeat.o(21285);
    }

    @Override // com.tencent.mm.plugin.backup.c.b.AbstractC0842b
    public final void a(LinkedList<f.b> linkedList, f.b bVar, int i2) {
        AppMethodBeat.i(21286);
        Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
        this.oLf = linkedList;
        if (this.oLg != null) {
            Iterator<f.b> it = this.oLg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f.b next = it.next();
                if (next.oJq.equals(bVar.oJq)) {
                    next.oJt = bVar.oJt;
                    next.oJu = bVar.oJu;
                    break;
                }
            }
        }
        if (b.cfv().cfx().oMh) {
            Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            b.cfv().ceM().S(13, i2, linkedList.size());
            b.cfv().cfx().xI(13);
        }
        if (this.oLd != null) {
            this.oLd.a(cfr(), bVar, i2);
        }
        AppMethodBeat.o(21286);
    }

    @Override // com.tencent.mm.plugin.backup.c.b.AbstractC0842b
    public final void D(LinkedList<f.b> linkedList) {
        AppMethodBeat.i(21287);
        Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
        this.oLj = true;
        this.oLf = (LinkedList) linkedList.clone();
        cft();
        if (b.cfv().cfx().oMh) {
            Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            b.cfv().cfx().cfM();
            AppMethodBeat.o(21287);
            return;
        }
        if (this.oLd != null) {
            this.oLd.D(linkedList);
        }
        AppMethodBeat.o(21287);
    }

    public final long cfu() {
        long j2 = 0;
        AppMethodBeat.i(21288);
        if (cfs() == null) {
            AppMethodBeat.o(21288);
            return 0;
        }
        Iterator<f.b> it = cfs().iterator();
        while (it.hasNext()) {
            j2 = it.next().oJt + j2;
        }
        AppMethodBeat.o(21288);
        return j2;
    }
}
