package com.tencent.mm.ap;

import android.os.Process;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ap.c;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

public final class a {
    private static boolean active = false;
    private static Future dBz;
    private static final c iTt = new c();
    private static boolean iTu = true;
    private static long iTv = 0;
    private static long iTw = 0;

    static {
        AppMethodBeat.i(132522);
        AppMethodBeat.o(132522);
    }

    public static boolean isActive() {
        return active;
    }

    public static final void fE(boolean z) {
        AppMethodBeat.i(132512);
        Log.i("MicroMsg.ActiveDetector", "onActive() active:%s", Boolean.valueOf(z));
        boolean z2 = !MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", g.aps()).getBoolean("msg_delay_close_detect", false);
        iTu = z2;
        if (!z2) {
            AppMethodBeat.o(132512);
            return;
        }
        active = z;
        if (z) {
            Log.i("MicroMsg.ActiveDetector", "[oneliang]active, time%s, pid:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()));
            Log.i("MicroMsg.ActiveDetector", "active, interrupt end, time %s", Long.valueOf(System.currentTimeMillis()));
            if (dBz != null) {
                dBz.cancel(true);
            }
            dBz = null;
            c cVar = iTt;
            cVar.iTN = false;
            cVar.iTJ = 0;
            cVar.iTK = 0;
            Log.i("MicroMsg.ActiveDetector", "active, processDetector.clear end, time %s", Long.valueOf(System.currentTimeMillis()));
            iTv = cl.aWy();
            AppMethodBeat.o(132512);
            return;
        }
        Log.i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()));
        if (dBz == null) {
            dBz = h.RTc.ba(iTt);
            iTt.iTN = true;
        }
        iTw = cl.aWy();
        AppMethodBeat.o(132512);
    }

    public static boolean Au(long j2) {
        if (iTv <= 0 || iTw <= 0 || j2 <= 0) {
            return false;
        }
        return iTv >= iTw ? j2 >= iTv : j2 < iTw;
    }

    public static void A(int i2, long j2) {
        AppMethodBeat.i(132513);
        if (!iTu) {
            AppMethodBeat.o(132513);
        } else if (active) {
            AppMethodBeat.o(132513);
        } else {
            c cVar = iTt;
            cVar.iTH.iTP.add(new c.C0259c(cl.aWy(), System.currentTimeMillis(), i2, j2));
            AppMethodBeat.o(132513);
        }
    }

    public static void B(int i2, long j2) {
        AppMethodBeat.i(132514);
        if (!iTu) {
            AppMethodBeat.o(132514);
        } else if (active) {
            AppMethodBeat.o(132514);
        } else {
            c cVar = iTt;
            cVar.iTH.iTQ.add(new c.C0259c(cl.aWy(), System.currentTimeMillis(), i2, j2));
            AppMethodBeat.o(132514);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i2, long j2, long j3, long j4, long j5, long j6, String str, int i3) {
        AppMethodBeat.i(132515);
        if (!iTu) {
            AppMethodBeat.o(132515);
            return;
        }
        c cVar = iTt;
        c.b bVar = new c.b(Process.myPid(), j2, j3, j4, j5, j6, str, i3);
        Log.i("MicroMsg.ActiveDetector.ProcessDetector", "addDelayedMsgInBackground() delayed msg[%s]", bVar.toString());
        switch (i2) {
            case 0:
                AppMethodBeat.o(132515);
                return;
            case 1:
                cVar.iTH.iUb.add(bVar);
                AppMethodBeat.o(132515);
                return;
            case 2:
                cVar.iTH.iUc.add(bVar);
                AppMethodBeat.o(132515);
                return;
            case 3:
                cVar.iTH.iUd.add(bVar);
                AppMethodBeat.o(132515);
                return;
            case 4:
                cVar.iTH.iUe.add(bVar);
                AppMethodBeat.o(132515);
                return;
            case 5:
                cVar.iTH.iUf.add(bVar);
                AppMethodBeat.o(132515);
                return;
            case 6:
                cVar.iTH.iUg.add(bVar);
                AppMethodBeat.o(132515);
                return;
            case 7:
                cVar.iTH.iUh.add(bVar);
                AppMethodBeat.o(132515);
                return;
            case 8:
                cVar.iTH.iUi.add(bVar);
                AppMethodBeat.o(132515);
                return;
            case 9:
                cVar.iTH.iUj.add(bVar);
                AppMethodBeat.o(132515);
                return;
            case 10:
                cVar.iTH.iUk.add(bVar);
                break;
        }
        AppMethodBeat.o(132515);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(int i2, long j2, long j3, long j4, long j5, long j6, String str, int i3) {
        AppMethodBeat.i(132516);
        if (!iTu) {
            AppMethodBeat.o(132516);
            return;
        }
        c cVar = iTt;
        c.b bVar = new c.b(Process.myPid(), j2, j3, j4, j5, j6, str, i3);
        Log.i("MicroMsg.ActiveDetector.ProcessDetector", "addDelayedMsgInForeground() delayed msg[%s]", bVar.toString());
        switch (i2) {
            case 0:
                AppMethodBeat.o(132516);
                return;
            case 1:
                cVar.iTH.iTR.add(bVar);
                AppMethodBeat.o(132516);
                return;
            case 2:
                cVar.iTH.iTS.add(bVar);
                AppMethodBeat.o(132516);
                return;
            case 3:
                cVar.iTH.iTT.add(bVar);
                AppMethodBeat.o(132516);
                return;
            case 4:
                cVar.iTH.iTU.add(bVar);
                AppMethodBeat.o(132516);
                return;
            case 5:
                cVar.iTH.iTV.add(bVar);
                AppMethodBeat.o(132516);
                return;
            case 6:
                cVar.iTH.iTW.add(bVar);
                AppMethodBeat.o(132516);
                return;
            case 7:
                cVar.iTH.iTX.add(bVar);
                AppMethodBeat.o(132516);
                return;
            case 8:
                cVar.iTH.iTY.add(bVar);
                AppMethodBeat.o(132516);
                return;
            case 9:
                cVar.iTH.iTZ.add(bVar);
                AppMethodBeat.o(132516);
                return;
            case 10:
                cVar.iTH.iUa.add(bVar);
                break;
        }
        AppMethodBeat.o(132516);
    }

    public static void sY(int i2) {
        iTt.iTE = i2;
    }

    public static List<C0258a> bbr() {
        c.a aVar;
        c.a aVar2 = null;
        AppMethodBeat.i(132517);
        if (!MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(132517);
            return null;
        }
        String str = iTt.iTL;
        String str2 = str + "/mm";
        String str3 = str + "/push";
        try {
            aVar = (c.a) b.y(s.openRead(str2));
        } catch (Exception e2) {
            Log.e("MicroMsg.ActiveDetector", "%s,read exception:" + e2.getMessage(), str2);
            aVar = null;
        }
        try {
            aVar2 = (c.a) b.y(s.openRead(str3));
        } catch (Exception e3) {
            Log.e("MicroMsg.ActiveDetector", "%s,read exception:" + e3.getMessage(), str3);
        }
        ArrayList arrayList = new ArrayList();
        if (aVar != null) {
            for (c.d dVar : aVar.iTO) {
                C0258a a2 = a(dVar, 0);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            for (c.C0259c cVar : aVar.iTQ) {
                C0258a a3 = a(cVar, 3);
                if (a3 != null) {
                    arrayList.add(a3);
                }
            }
            a(arrayList, aVar.iTR, true);
            a(arrayList, aVar.iTS, true);
            a(arrayList, aVar.iTT, true);
            a(arrayList, aVar.iTU, true);
            a(arrayList, aVar.iTV, true);
            a(arrayList, aVar.iTW, true);
            a(arrayList, aVar.iTX, true);
            a(arrayList, aVar.iTY, true);
            a(arrayList, aVar.iTZ, true);
            a(arrayList, aVar.iUa, true);
            a(arrayList, aVar.iUb, false);
            a(arrayList, aVar.iUc, false);
            a(arrayList, aVar.iUd, false);
            a(arrayList, aVar.iUe, false);
            a(arrayList, aVar.iUf, false);
            a(arrayList, aVar.iUg, false);
            a(arrayList, aVar.iUh, false);
            a(arrayList, aVar.iUi, false);
            a(arrayList, aVar.iUj, false);
            a(arrayList, aVar.iUk, false);
        }
        if (aVar2 != null) {
            for (c.d dVar2 : aVar2.iTO) {
                C0258a a4 = a(dVar2, 1);
                if (a4 != null) {
                    arrayList.add(a4);
                }
            }
            for (c.C0259c cVar2 : aVar2.iTP) {
                C0258a a5 = a(cVar2, 2);
                if (a5 != null) {
                    arrayList.add(a5);
                }
            }
        }
        Collections.sort(arrayList);
        AppMethodBeat.o(132517);
        return arrayList;
    }

    private static void a(List<C0258a> list, List<c.b> list2, boolean z) {
        C0258a aVar;
        AppMethodBeat.i(132518);
        if (list2 == null) {
            AppMethodBeat.o(132518);
            return;
        }
        for (c.b bVar : list2) {
            if (bVar == null) {
                aVar = null;
            } else {
                C0258a aVar2 = new C0258a();
                aVar2.pid = bVar.pid;
                aVar2.iTx = bVar.iTx;
                aVar2.startTime = bVar.iUl;
                aVar2.endTime = bVar.iUl;
                aVar2.type = 4;
                aVar2.iTB = bVar.iTB;
                aVar2.iTC = bVar.iTC;
                aVar2.iTD = bVar.iTD;
                aVar2.cQp = z;
                aVar = aVar2;
            }
            if (aVar != null) {
                list.add(aVar);
            }
        }
        AppMethodBeat.o(132518);
    }

    static String Av(long j2) {
        AppMethodBeat.i(132519);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j2));
        AppMethodBeat.o(132519);
        return format;
    }

    private static C0258a a(c.d dVar, int i2) {
        AppMethodBeat.i(132520);
        if (dVar == null) {
            AppMethodBeat.o(132520);
            return null;
        }
        C0258a aVar = new C0258a();
        aVar.iTx = dVar.iUn;
        aVar.startTime = dVar.startTime;
        aVar.endTime = dVar.endTime;
        aVar.type = i2;
        aVar.pid = dVar.pid;
        aVar.iTy = dVar.iTy;
        if (i2 == 1) {
            aVar.networkStatus = dVar.networkStatus;
            aVar.iTz = dVar.iTz;
        }
        AppMethodBeat.o(132520);
        return aVar;
    }

    private static C0258a a(c.C0259c cVar, int i2) {
        AppMethodBeat.i(132521);
        if (cVar == null) {
            AppMethodBeat.o(132521);
            return null;
        }
        C0258a aVar = new C0258a();
        aVar.iTx = cVar.iTx;
        aVar.startTime = cVar.time;
        aVar.endTime = cVar.time;
        aVar.type = i2;
        aVar.iTA = cVar.type;
        AppMethodBeat.o(132521);
        return aVar;
    }

    /* renamed from: com.tencent.mm.ap.a$a  reason: collision with other inner class name */
    public static class C0258a implements Comparable<C0258a> {
        public boolean cQp = false;
        public long endTime = 0;
        public int iTA = 0;
        public long iTB = 0;
        public long iTC = 0;
        public long iTD = 0;
        public long iTx = 0;
        public boolean iTy = true;
        public boolean iTz = false;
        public int networkStatus = 0;
        public int pid = 0;
        public long startTime = 0;
        public int type = 0;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(C0258a aVar) {
            C0258a aVar2 = aVar;
            if (this.iTx == 0 || aVar2.iTx == 0) {
                return (int) (this.startTime - aVar2.startTime);
            }
            return (int) (this.iTx - aVar2.iTx);
        }

        public final String toString() {
            AppMethodBeat.i(132511);
            StringBuilder sb = new StringBuilder();
            switch (this.type) {
                case 0:
                    sb.append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", a.Av(this.iTx), a.Av(this.startTime), a.Av(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.iTy)));
                    break;
                case 1:
                    sb.append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", a.Av(this.iTx), a.Av(this.startTime), a.Av(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.networkStatus), Boolean.valueOf(this.iTy)));
                    break;
                case 2:
                    sb.append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", a.Av(this.iTx), a.Av(this.startTime), a.Av(this.endTime), Integer.valueOf(this.iTA)));
                    break;
                case 3:
                    sb.append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", a.Av(this.iTx), a.Av(this.startTime), a.Av(this.endTime), Integer.valueOf(this.iTA)));
                    break;
                case 4:
                    Object[] objArr = new Object[8];
                    objArr[0] = a.Av(this.iTx);
                    objArr[1] = a.Av(this.startTime);
                    objArr[2] = a.Av(this.endTime);
                    objArr[3] = Integer.valueOf(this.pid);
                    objArr[4] = a.Av(this.iTB);
                    objArr[5] = Long.valueOf(this.iTC);
                    objArr[6] = Long.valueOf(this.iTD);
                    objArr[7] = this.cQp ? "foreground" : "background";
                    sb.append(String.format("server time:%s,local start time:%s,local end time:%s,delayed msg pid:%s, msg server time:%s,interval time:%s, msg server id:%s, %s", objArr));
                    break;
            }
            sb.append("\n");
            String sb2 = sb.toString();
            AppMethodBeat.o(132511);
            return sb2;
        }
    }
}
