package com.tencent.mm.at;

import android.database.Cursor;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.v;
import com.tencent.mm.openim.b.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.protocal.protobuf.blt;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dtv;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

final class c implements ay.b {
    boolean iKb = false;
    private long iKm = 0;
    f<String, Integer> iWk = new com.tencent.mm.memory.a.c(200);
    Map<String, LinkedList<ay.b.a>> iWl = new HashMap();
    Queue<blt> iWm = new LinkedList();
    Queue<a> iWn = new LinkedList();
    long iWo = 0;
    final int iWp = 500;
    final int iWq = 10000;
    MTimerHandler iWr = new MTimerHandler(bg.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.at.c.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(20517);
            Log.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
            c.this.bck();
            AppMethodBeat.o(20517);
            return false;
        }
    }, false);
    final MTimerHandler iWs = new MTimerHandler(bg.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.at.c.AnonymousClass7 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            boolean z;
            final boolean z2;
            String str;
            Object valueOf;
            AppMethodBeat.i(20523);
            if (c.this.iWn.isEmpty()) {
                Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
                AppMethodBeat.o(20523);
                return false;
            }
            long nowMilliSecond = Util.nowMilliSecond();
            int i2 = c.this.iKb ? 5 : 15;
            ArrayList arrayList = new ArrayList(i2 * 2);
            int i3 = 0;
            while (true) {
                if (i3 < i2) {
                    a peek = c.this.iWn.peek();
                    if (peek == null) {
                        Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
                        z = false;
                    } else {
                        LinkedList<cpl> linkedList = peek.iWB.LUC;
                        LinkedList<Integer> linkedList2 = peek.iWB.LRr;
                        LinkedList<dtv> linkedList3 = peek.iWB.LUE;
                        if (linkedList3 != null && linkedList3.size() > 0) {
                            Iterator<dtv> it = linkedList3.iterator();
                            while (it.hasNext()) {
                                dtv next = it.next();
                                if (next != null) {
                                    ((l) g.af(l.class)).aSN().mS(next.UserName, next.Bri);
                                }
                            }
                        }
                        int i4 = peek.iWC;
                        if (linkedList2.size() != linkedList.size()) {
                            Log.w("MicroMsg.GetContactService", "find warn %s %s", Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList.size()));
                        }
                        int min = Math.min(linkedList2.size(), linkedList.size());
                        if (min <= i4) {
                            c.this.iWn.poll();
                            if (c.this.iWn.isEmpty()) {
                                Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", Integer.valueOf(i4), Integer.valueOf(min));
                                c.this.iWo = 0;
                                c.this.iWr.startTimer(0);
                                z = false;
                            } else {
                                Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", Integer.valueOf(i4), Integer.valueOf(min));
                            }
                        } else {
                            cpl cpl = linkedList.get(i4);
                            int intValue = linkedList2.get(i4).intValue();
                            final String nullAs = Util.nullAs(z.a(cpl.Lqk), "");
                            final String nullAs2 = Util.nullAs(cpl.ked, "");
                            String nullAs3 = Util.nullAs(cpl.Mvn, "");
                            arrayList.add(nullAs);
                            arrayList.add(nullAs2);
                            arrayList.add(nullAs3);
                            switch (intValue) {
                                case -477:
                                    Log.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", Integer.valueOf(intValue), nullAs, nullAs2, Boolean.valueOf(d.bcm().On(nullAs)), Boolean.valueOf(d.bcm().On(nullAs2)), Boolean.valueOf(v.HY(nullAs)));
                                    e.INSTANCE.idkeyStat(832, 1, 1, false);
                                    z2 = false;
                                    break;
                                case 0:
                                    if (peek.iWB.LUD == null || peek.iWB.LUD.size() <= i4 || !nullAs.equals(peek.iWB.LUD.get(i4).username)) {
                                        Object[] objArr = new Object[3];
                                        if (peek.iWB.LUD == null) {
                                            valueOf = BuildConfig.COMMAND;
                                        } else {
                                            valueOf = Integer.valueOf(peek.iWB.LUD.size());
                                        }
                                        objArr[0] = valueOf;
                                        objArr[1] = Integer.valueOf(i4);
                                        objArr[2] = nullAs;
                                        Log.w("MicroMsg.GetContactService", "get antispamticket from resp failed: list:%s idx:%d  user:%s", objArr);
                                        str = "";
                                    } else {
                                        str = Util.nullAs(peek.iWB.LUD.get(i4).NnM, "");
                                    }
                                    Log.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s %s", nullAs, nullAs2, str, Integer.valueOf(peek.iWD));
                                    b.jRu.a(cpl, str, peek.iWD);
                                    e.INSTANCE.idkeyStat(832, 0, 1, false);
                                    z2 = true;
                                    break;
                                default:
                                    Log.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", Integer.valueOf(intValue), nullAs, nullAs2, Boolean.valueOf(v.HY(nullAs)));
                                    e.INSTANCE.idkeyStat(832, 2, 1, false);
                                    z2 = false;
                                    break;
                            }
                            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                                /* class com.tencent.mm.at.c.AnonymousClass7.AnonymousClass1 */

                                public final void run() {
                                    LinkedList<ay.b.a> remove;
                                    LinkedList<ay.b.a> remove2;
                                    AppMethodBeat.i(20522);
                                    Log.i("MicroMsg.GetContactService", "callback user:%s alias:%s", Util.nullAs(nullAs, ""), Util.nullAs(nullAs2, ""));
                                    synchronized (this) {
                                        try {
                                            remove = c.this.iWl.remove(nullAs);
                                            remove2 = Util.isNullOrNil(nullAs2) ? null : c.this.iWl.remove(nullAs2);
                                        } finally {
                                            AppMethodBeat.o(20522);
                                        }
                                    }
                                    if (remove != null) {
                                        Log.i("MicroMsg.GetContactService", "callback userCallbackContainer user:%s size:%s", Util.nullAs(nullAs, ""), Integer.valueOf(remove.size()));
                                        Iterator<ay.b.a> it = remove.iterator();
                                        while (it.hasNext()) {
                                            it.next().p(nullAs, z2);
                                        }
                                    }
                                    if (remove2 != null) {
                                        Log.i("MicroMsg.GetContactService", "callback aliasCallbackContainer user:%s size:%s", Util.nullAs(nullAs, ""), Integer.valueOf(remove2.size()));
                                        Iterator<ay.b.a> it2 = remove2.iterator();
                                        while (it2.hasNext()) {
                                            it2.next().p(nullAs, z2);
                                        }
                                    }
                                }
                            });
                            peek.iWC++;
                        }
                        i3++;
                    }
                } else {
                    z = true;
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                bg.aVF();
                long beginTransaction = com.tencent.mm.model.c.getDataDB().beginTransaction(Thread.currentThread().getId());
                b bcm = d.bcm();
                for (int i5 = 0; i5 < size; i5++) {
                    bcm.On((String) arrayList.get(i5));
                }
                bg.aVF();
                com.tencent.mm.model.c.getDataDB().endTransaction(beginTransaction);
            }
            Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + c.this.iKb + " ret: " + z + " maxCnt: " + i2 + " deleteCount: " + size + " take: " + (Util.nowMilliSecond() - nowMilliSecond) + LocaleUtil.MALAY);
            AppMethodBeat.o(20523);
            return z;
        }
    }, true);

    c() {
        AppMethodBeat.i(20524);
        AppMethodBeat.o(20524);
    }

    @Override // com.tencent.mm.model.ay.b
    public final void JZ(String str) {
        AppMethodBeat.i(20525);
        synchronized (this) {
            try {
                this.iWl.remove(str);
            } finally {
                AppMethodBeat.o(20525);
            }
        }
    }

    @Override // com.tencent.mm.model.ay.b
    public final void aL(String str, String str2) {
        AppMethodBeat.i(20526);
        Log.i("MicroMsg.GetContactService", "dkverify add Contact :" + str + " chatroom: " + str2 + " stack:" + Util.getStack());
        if (bp(str, str2)) {
            this.iWr.startTimer(500);
        }
        AppMethodBeat.o(20526);
    }

    @Override // com.tencent.mm.model.ay.b
    public final void a(String str, String str2, ay.b.a aVar) {
        AppMethodBeat.i(20528);
        Log.i("MicroMsg.GetContactService", "dkverify getNow :" + str + " chatroom: " + str2 + " stack:" + Util.getStack());
        if (bp(str, str2)) {
            if (aVar == null) {
                Log.i("MicroMsg.GetContactService", "addGetContactCallBack %s, addGetContactCallBack is null", Util.nullAs(str, ""));
            } else {
                synchronized (this) {
                    try {
                        LinkedList<ay.b.a> linkedList = this.iWl.get(str);
                        if (linkedList == null) {
                            Map<String, LinkedList<ay.b.a>> map = this.iWl;
                            linkedList = new LinkedList<>();
                            map.put(str, linkedList);
                        }
                        if (!linkedList.contains(aVar)) {
                            linkedList.add(aVar);
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(20528);
                        throw th;
                    }
                }
            }
            this.iWr.startTimer(0);
        }
        AppMethodBeat.o(20528);
    }

    @Override // com.tencent.mm.model.ay.b
    public final void Ka(final String str) {
        AppMethodBeat.i(20529);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.at.c.AnonymousClass1 */

            public final void run() {
                Object[] array;
                AppMethodBeat.i(20516);
                for (Object obj : c.this.iWk.keySet().toArray()) {
                    String str = (String) obj;
                    if (str.startsWith(str)) {
                        Log.d("MicroMsg.GetContactService", "clearMapRecentDown(): key = %s", str);
                        c.this.iWk.remove(str);
                    }
                }
                AppMethodBeat.o(20516);
            }
        });
        AppMethodBeat.o(20529);
    }

    @Override // com.tencent.mm.model.ay.b
    public final void aVg() {
        AppMethodBeat.i(231546);
        Log.i("MicroMsg.GetContactService", "[checkPendingGetContact] %s", Boolean.valueOf(b.jRu.Xf()));
        this.iWr.startTimer(500);
        AppMethodBeat.o(231546);
    }

    private static boolean bp(String str, String str2) {
        AppMethodBeat.i(20530);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(20530);
            return false;
        }
        String aTY = com.tencent.mm.model.z.aTY();
        String aTZ = com.tencent.mm.model.z.aTZ();
        if (str.equals(aTY) || str.equals(aTZ)) {
            Log.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + aTY + " alias: " + aTZ + " ret");
            AppMethodBeat.o(20530);
            return false;
        }
        a aVar = new a();
        aVar.username = str;
        aVar.iFt = Util.nullAsNil(str2);
        aVar.iWh = Util.nowMilliSecond();
        boolean a2 = d.bcm().a(aVar);
        AppMethodBeat.o(20530);
        return a2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: java.util.LinkedList<com.tencent.mm.protocal.protobuf.dqi> */
    /* JADX WARN: Multi-variable type inference failed */
    private void bcj() {
        LinkedList<dqi> linkedList;
        List<String> list;
        AppMethodBeat.i(20531);
        Cursor rawQuery = d.bcm().iFy.rawQuery("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", new String[]{String.valueOf(this.iWo), "80"});
        if (rawQuery == null) {
            AppMethodBeat.o(20531);
            return;
        }
        int count = rawQuery.getCount();
        Log.i("MicroMsg.GetContactService", "getFromDb count:%d", Integer.valueOf(count));
        if (count <= 0) {
            rawQuery.close();
            AppMethodBeat.o(20531);
            return;
        }
        LinkedList<dqi> linkedList2 = new LinkedList<>();
        LinkedList<dqi> linkedList3 = new LinkedList<>();
        LinkedList linkedList4 = new LinkedList();
        SparseArray<List<String>> sparseArray = new SparseArray<>();
        LinkedList linkedList5 = new LinkedList();
        while (rawQuery.moveToNext()) {
            a aVar = new a();
            aVar.username = rawQuery.getString(0);
            aVar.iWh = rawQuery.getLong(1);
            aVar.type = rawQuery.getInt(2);
            aVar.iWi = rawQuery.getInt(3);
            aVar.iFr = rawQuery.getInt(4);
            aVar.iWj = rawQuery.getInt(5);
            aVar.iFt = rawQuery.getString(6);
            aVar.iFu = rawQuery.getString(7);
            String username = aVar.getUsername();
            String nullAsNil = Util.nullAsNil(aVar.bci());
            int nullAsNil2 = Util.nullAsNil(Integer.valueOf(aVar.iWj));
            String nullAsNil3 = Util.nullAsNil(aVar.aWe());
            this.iWo = aVar.iWh;
            String str = username + "#" + nullAsNil;
            int nullAs = Util.nullAs(this.iWk.aT(str), 0);
            if (nullAs < 3) {
                this.iWk.x(str, Integer.valueOf(nullAs + 1));
                if (ab.Iy(username)) {
                    blt blt = new blt();
                    linkedList2.add(new dqi().bhy(username));
                    linkedList3.add(new dqi().bhy(nullAsNil));
                    blt.KGP = linkedList2;
                    blt.LUy = linkedList3;
                    this.iWm.add(blt);
                    LinkedList<dqi> linkedList6 = new LinkedList<>();
                    linkedList = new LinkedList<>();
                    Log.i("MicroMsg.GetContactService", "getFromDb this is openRoom now reqlist size:%d , this req usr count:%d usr %s", Integer.valueOf(this.iWm.size()), Integer.valueOf(blt.KGP.size()), username);
                    linkedList2 = linkedList6;
                } else if (as.bjp(username)) {
                    blt blt2 = new blt();
                    linkedList2.add(new dqi().bhy(username));
                    linkedList3.add(new dqi().bhy(nullAsNil));
                    blt2.KGP = linkedList2;
                    blt2.LUy = linkedList3;
                    this.iWm.add(blt2);
                    LinkedList<dqi> linkedList7 = new LinkedList<>();
                    linkedList = new LinkedList<>();
                    Log.i("MicroMsg.GetContactService", "getFromDb this is isOpenIM now reqlist size:%d , this req usr count:%d usr %s", Integer.valueOf(this.iWm.size()), Integer.valueOf(blt2.KGP.size()), username);
                    linkedList2 = linkedList7;
                } else if (nullAsNil2 == 1) {
                    linkedList4.add(new Pair(new dqi().bhy(username), new dqi().bhy(nullAsNil3)));
                    Log.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", username, Integer.valueOf(nullAsNil2), nullAsNil3);
                    linkedList = linkedList3;
                } else if (nullAsNil2 != 0) {
                    if (sparseArray.indexOfKey(nullAsNil2) < 0) {
                        list = new LinkedList<>();
                        sparseArray.put(nullAsNil2, list);
                    } else {
                        list = sparseArray.get(nullAsNil2);
                    }
                    list.add(username);
                    linkedList = linkedList3;
                } else {
                    linkedList2.add(new dqi().bhy(username));
                    linkedList3.add(new dqi().bhy(nullAsNil));
                    Log.i("MicroMsg.GetContactService", "getFromDb add user:%s getScene:%s room:%s", username, Integer.valueOf(nullAsNil2), nullAsNil);
                    linkedList = linkedList3;
                }
            } else {
                linkedList5.add(username);
                Q(username, false);
                linkedList = linkedList3;
            }
            if (linkedList2.size() >= 20 || rawQuery.isLast()) {
                blt blt3 = new blt();
                blt3.KGP = linkedList2;
                blt3.LUu = linkedList2.size();
                blt3.LUy = linkedList;
                blt3.LUx = linkedList.size();
                this.iWm.add(blt3);
                linkedList2 = new LinkedList<>();
                linkedList = new LinkedList<>();
                Log.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d getScene=%s", Integer.valueOf(this.iWm.size()), Integer.valueOf(blt3.KGP.size()), Integer.valueOf(nullAsNil2));
            }
            linkedList3 = linkedList;
        }
        rawQuery.close();
        c(sparseArray);
        Iterator it = linkedList4.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            blt blt4 = new blt();
            LinkedList<dqi> linkedList8 = new LinkedList<>();
            linkedList8.add(pair.first);
            blt4.KGP = linkedList8;
            blt4.LUu = linkedList8.size();
            blt4.LUz = 1;
            blt4.LUA = (dqi) pair.second;
            this.iWm.add(blt4);
        }
        linkedList4.clear();
        for (int i2 = 0; i2 < linkedList5.size(); i2++) {
            String str2 = (String) linkedList5.get(i2);
            boolean Eq = ab.Eq(str2);
            Log.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", str2, Boolean.valueOf(Eq));
            if (Eq) {
                d.bcm().On(str2);
            }
            boolean IF = ab.IF(str2);
            Log.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", str2, Boolean.valueOf(Eq));
            if (IF) {
                d.bcm().On(str2);
                e.INSTANCE.idkeyStat(832, 3, 1, false);
            }
        }
        AppMethodBeat.o(20531);
    }

    private void c(SparseArray<List<String>> sparseArray) {
        AppMethodBeat.i(231547);
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            blt blt = new blt();
            int keyAt = sparseArray.keyAt(i2);
            LinkedList linkedList = new LinkedList();
            for (String str : sparseArray.valueAt(i2)) {
                linkedList.add(new dqi().bhy(str));
            }
            blt.KGP.addAll(linkedList);
            blt.LUu = blt.KGP.size();
            blt.LUz = keyAt;
            this.iWm.add(blt);
            Log.i("MicroMsg.GetContactService", "[buildSceneReqList] scene=%s count=%s req size=%s", Integer.valueOf(blt.LUz), Integer.valueOf(blt.LUu), Integer.valueOf(this.iWm.size()));
        }
        sparseArray.clear();
        AppMethodBeat.o(231547);
    }

    /* access modifiers changed from: package-private */
    public final void Q(final String str, final boolean z) {
        AppMethodBeat.i(20532);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.at.c.AnonymousClass3 */

            public final void run() {
                LinkedList<ay.b.a> linkedList;
                AppMethodBeat.i(20518);
                if (c.this.iWl.containsKey(str)) {
                    synchronized (this) {
                        try {
                            linkedList = c.this.iWl.get(str);
                            c.this.iWl.remove(str);
                        } finally {
                            AppMethodBeat.o(20518);
                        }
                    }
                    if (linkedList != null) {
                        Iterator<ay.b.a> it = linkedList.iterator();
                        while (it.hasNext()) {
                            it.next().p(str, z);
                        }
                    }
                }
            }
        });
        AppMethodBeat.o(20532);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void bck() {
        boolean z;
        AppMethodBeat.i(20533);
        if (b.jRu.Xf()) {
            Log.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
            AppMethodBeat.o(20533);
        } else {
            long nowMilliSecond = Util.nowMilliSecond();
            if (this.iKb && nowMilliSecond - this.iKm > 600000) {
                Log.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", Long.valueOf(nowMilliSecond - this.iKm));
                this.iKb = false;
            }
            if (this.iKb) {
                Log.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.iKb + " ret");
                AppMethodBeat.o(20533);
            } else {
                blt poll = this.iWm.poll();
                if (poll == null) {
                    bcj();
                    poll = this.iWm.poll();
                    while (true) {
                        if ((poll == null || poll.KGP == null || poll.KGP.size() == 0) && this.iWm.size() > 0) {
                            poll = this.iWm.poll();
                        }
                    }
                    if (poll == null || poll.KGP == null || poll.KGP.size() == 0) {
                        Object[] objArr = new Object[1];
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        Log.e("MicroMsg.GetContactService", "tryStartNetscene Not any more contact. req is null? %s", objArr);
                        AppMethodBeat.o(20533);
                    }
                }
                this.iKm = nowMilliSecond;
                this.iKb = true;
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                Iterator<dqi> it = poll.KGP.iterator();
                while (it.hasNext()) {
                    String a2 = z.a(it.next());
                    if (ab.Iy(a2)) {
                        linkedList.add(a2);
                    }
                    if (as.bjp(a2)) {
                        linkedList2.add(a2);
                    }
                }
                if (linkedList.size() > 0) {
                    final String str = (String) linkedList.get(0);
                    if (ab.Iy(str)) {
                        com.tencent.mm.roomsdk.a.b.bhF(str).Dt(str).d(new com.tencent.mm.roomsdk.a.b.b() {
                            /* class com.tencent.mm.at.c.AnonymousClass4 */

                            @Override // com.tencent.mm.roomsdk.a.b.a
                            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                                AppMethodBeat.i(20519);
                                c.this.iKb = false;
                                if (i2 == 0 && i3 == 0) {
                                    if (!c.this.iWm.isEmpty() && c.this.iWr.stopped()) {
                                        c.this.iWr.startTimer(500);
                                    }
                                    Log.i("MicroMsg.ActionCallbackFunc", "getChatRoomInfoDetail onResult %s %s", Boolean.valueOf(d.bcm().On(str)), str);
                                    c.this.Q(str, true);
                                    AppMethodBeat.o(20519);
                                    return;
                                }
                                Log.e("MicroMsg.ActionCallbackFunc", "tryStartNetscene onSceneEnd openRoom errType:" + i2 + " errCode:" + i3 + " will retry");
                                c.this.iWr.startTimer(10000);
                                c.this.Q(str, false);
                                AppMethodBeat.o(20519);
                            }
                        }).aJu();
                    }
                    AppMethodBeat.o(20533);
                } else if (linkedList2.size() > 0) {
                    final String str2 = (String) linkedList2.get(0);
                    bro bro = new bro();
                    bro.jGZ = str2;
                    String str3 = "";
                    if (poll.LUy != null && poll.LUy.size() > 0) {
                        str3 = z.a(poll.LUy.get(0));
                    }
                    bro.dOe = str3;
                    d.a aVar = new d.a();
                    aVar.iLN = bro;
                    aVar.iLO = new brp();
                    aVar.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
                    aVar.funcId = 881;
                    Log.i("MicroMsg.GetContactService", "request roomName %s userOpenImname %s", str3, str2);
                    aa.a(aVar.aXF(), new aa.a() {
                        /* class com.tencent.mm.at.c.AnonymousClass5 */

                        @Override // com.tencent.mm.ak.aa.a
                        public final int a(int i2, int i3, String str, d dVar, q qVar) {
                            AppMethodBeat.i(20520);
                            if (qVar.getType() != 881) {
                                AppMethodBeat.o(20520);
                            } else {
                                c.this.iKb = false;
                                if (i2 == 0 && i3 == 0) {
                                    if (!c.this.iWm.isEmpty() && c.this.iWr.stopped()) {
                                        c.this.iWr.startTimer(500);
                                    }
                                    s.a((brp) dVar.iLL.iLR);
                                    Log.i("MicroMsg.GetContactService", "getopenimcontact onResult %s %s", Boolean.valueOf(d.bcm().On(str2)), str2);
                                    c.this.Q(str2, true);
                                    AppMethodBeat.o(20520);
                                } else {
                                    Log.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd openImUser errType: %s  errCode: %s username %s will retry/del ", Integer.valueOf(i2), Integer.valueOf(i3), str2);
                                    if (i2 == 4) {
                                        d.bcm().On(str2);
                                    }
                                    c.this.iWr.startTimer(10000);
                                    c.this.Q(str2, false);
                                    AppMethodBeat.o(20520);
                                }
                            }
                            return 0;
                        }
                    }, true);
                    AppMethodBeat.o(20533);
                } else {
                    d.a aVar2 = new d.a();
                    aVar2.iLN = poll;
                    aVar2.iLO = new blu();
                    aVar2.uri = "/cgi-bin/micromsg-bin/getcontact";
                    aVar2.funcId = 182;
                    final int i2 = poll.LUz;
                    aa.a(aVar2.aXF(), new aa.a() {
                        /* class com.tencent.mm.at.c.AnonymousClass6 */

                        @Override // com.tencent.mm.ak.aa.a
                        public final int a(int i2, int i3, String str, d dVar, q qVar) {
                            AppMethodBeat.i(20521);
                            if (qVar.getType() != 182) {
                                AppMethodBeat.o(20521);
                            } else {
                                c.this.iKb = false;
                                if (i2 == 0 && i3 == 0) {
                                    if (!c.this.iWm.isEmpty() && c.this.iWr.stopped()) {
                                        c.this.iWr.startTimer(500);
                                    }
                                    if (dVar != null) {
                                        a aVar = new a();
                                        aVar.iWD = i2;
                                        aVar.errType = i2;
                                        aVar.errCode = i3;
                                        aVar.errMsg = str;
                                        aVar.iWB = (blu) dVar.iLL.iLR;
                                        c.this.iWn.add(aVar);
                                    }
                                    if (!c.this.iWn.isEmpty() && c.this.iWs.stopped()) {
                                        c.this.iWs.startTimer(50);
                                    }
                                    AppMethodBeat.o(20521);
                                } else {
                                    Log.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + i2 + " errCode:" + i3 + " getScene:" + i2 + " will retry");
                                    c.this.iWr.startTimer(10000);
                                    AppMethodBeat.o(20521);
                                }
                            }
                            return 0;
                        }
                    }, true);
                    AppMethodBeat.o(20533);
                }
            }
        }
    }

    class a {
        int errCode;
        String errMsg;
        int errType;
        blu iWB;
        int iWC = 0;
        int iWD;

        a() {
        }
    }

    @Override // com.tencent.mm.model.ay.b
    public final void j(String str, int i2, String str2) {
        boolean z = false;
        AppMethodBeat.i(231545);
        if (!Util.isNullOrNil(str)) {
            String aTY = com.tencent.mm.model.z.aTY();
            String aTZ = com.tencent.mm.model.z.aTZ();
            if (str.equals(aTY) || str.equals(aTZ)) {
                Log.i("MicroMsg.GetContactService", "addToStg username: " + str + " equal to user: " + aTY + " alias: " + aTZ + " ret");
            } else {
                a aVar = new a();
                aVar.username = str;
                aVar.iFu = Util.nullAsNil(str2);
                aVar.iWj = Util.nullAsNil(Integer.valueOf(i2));
                aVar.iWh = Util.nowMilliSecond();
                z = d.bcm().a(aVar);
            }
        }
        if (z) {
            this.iWr.startTimer(500);
        }
        AppMethodBeat.o(231545);
    }
}
