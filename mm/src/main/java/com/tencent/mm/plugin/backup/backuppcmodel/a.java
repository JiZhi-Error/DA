package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b.a {
    private Object lock = new Object();
    public long oLe;
    private LinkedList<f.b> oLf = null;
    private LinkedList<f.b> oLg = null;
    private LinkedList<f.b> oLh = null;
    public boolean oLi = false;
    b oMd;
    public boolean oOb = false;
    public b.a oOc;

    public a() {
        AppMethodBeat.i(21537);
        AppMethodBeat.o(21537);
    }

    private static long F(LinkedList<f.b> linkedList) {
        AppMethodBeat.i(21538);
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
        AppMethodBeat.o(21538);
        return j2;
    }

    public final LinkedList<f.b> cfq() {
        AppMethodBeat.i(21539);
        if (this.oLf == null) {
            this.oLf = new LinkedList<>();
        }
        LinkedList<f.b> linkedList = this.oLf;
        AppMethodBeat.o(21539);
        return linkedList;
    }

    public final LinkedList<f.b> cfr() {
        AppMethodBeat.i(21540);
        if (this.oLg == null) {
            this.oLg = new LinkedList<>();
        }
        LinkedList<f.b> linkedList = this.oLg;
        AppMethodBeat.o(21540);
        return linkedList;
    }

    public final void a(int i2, long j2, long j3, LinkedList<f.b> linkedList) {
        AppMethodBeat.i(21541);
        if (i2 == 0) {
            this.oLg = new LinkedList<>(linkedList);
            AppMethodBeat.o(21541);
            return;
        }
        if (this.oLg == null) {
            this.oLg = new LinkedList<>();
        } else {
            this.oLg.clear();
        }
        Iterator<f.b> it = linkedList.iterator();
        while (it.hasNext()) {
            f.b next = it.next();
            if (d.cgP().cgQ().aSQ().H(next.oJq, j2, j3) > 0) {
                this.oLg.add(next);
            }
        }
        AppMethodBeat.o(21541);
    }

    public final void H(LinkedList<f.b> linkedList) {
        AppMethodBeat.i(21542);
        if (linkedList == null || linkedList.size() == 0) {
            this.oLh = new LinkedList<>();
            AppMethodBeat.o(21542);
            return;
        }
        this.oLh = new LinkedList<>(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
        this.oLh.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
        AppMethodBeat.o(21542);
    }

    private LinkedList<f.b> cfs() {
        AppMethodBeat.i(21543);
        if (this.oLh == null) {
            this.oLh = new LinkedList<>();
        }
        LinkedList<f.b> linkedList = this.oLh;
        AppMethodBeat.o(21543);
        return linkedList;
    }

    public final void jD(boolean z) {
        AppMethodBeat.i(21544);
        Log.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", Boolean.valueOf(z));
        this.oOb = z;
        d.cgP().cgS();
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.backuppcmodel.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(21536);
                if (a.this.oMd != null) {
                    a.this.oMd.cancel();
                }
                a.this.oMd = new b();
                a.this.oMd.a(a.this);
                AppMethodBeat.o(21536);
            }
        }, "BackupPcChooseServer.calculateToChoose");
        AppMethodBeat.o(21544);
    }

    @Override // com.tencent.mm.plugin.backup.c.b.a
    public final void C(LinkedList<f.b> linkedList) {
        AppMethodBeat.i(21545);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        Log.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, conv size[%d]", objArr);
        this.oLi = true;
        if (linkedList == null || linkedList.size() == 0) {
            if (this.oOc != null) {
                this.oOc.C(linkedList);
            }
            if (this.oOb) {
                e cgc = b.cga().cgc();
                e.oOE = true;
                cgc.oMe.cff();
                b.cga().cfw().stop();
                b.cga().ceM().oJc = -23;
                b.cga().cgc().xI(-23);
            }
            AppMethodBeat.o(21545);
            return;
        }
        this.oLf = new LinkedList<>(linkedList);
        this.oLe = F(this.oLf);
        b.cga();
        SharedPreferences ceR = b.ceR();
        a(ceR.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), ceR.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0), ceR.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0), cfq());
        Log.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", Integer.valueOf(linkedList.size()), Integer.valueOf(cfr().size()));
        if (this.oOb) {
            H(cfr());
            b.cga().cgc().G(g.B(cfs()));
            b.cga().cgc().Bv((long) cfs().size());
        }
        if (this.oOc != null) {
            this.oOc.C(cfr());
        }
        AppMethodBeat.o(21545);
    }

    public final void cfZ() {
        this.oLf = null;
        this.oLh = null;
        this.oLg = null;
        this.oLi = false;
    }

    public final void cancel() {
        AppMethodBeat.i(21546);
        Log.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", Util.getStack());
        synchronized (this.lock) {
            try {
                if (this.oMd != null) {
                    this.oMd.cancel();
                    this.oMd = null;
                }
                this.oLi = false;
            } finally {
                AppMethodBeat.o(21546);
            }
        }
    }
}
