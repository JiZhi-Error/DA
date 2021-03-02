package com.tencent.mm.chatroom.c;

import android.os.Message;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Future;

public final class b {
    private String ehT = "";
    Future grQ = null;
    public ConcurrentLinkedDeque<String> grR = new ConcurrentLinkedDeque<>();
    public ConcurrentHashMap<String, String> grS = new ConcurrentHashMap<>();
    Runnable grT = new Runnable() {
        /* class com.tencent.mm.chatroom.c.b.AnonymousClass2 */

        public final void run() {
            Exception e2;
            String str;
            Throwable th;
            boolean z;
            long a2;
            AppMethodBeat.i(194013);
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            String str2 = "";
            try {
                String str3 = (String) g.aAh().azQ().get(ar.a.USERINFO_OPEN_IM_MIGRATE_TO_CHAT_ROOM_STRING_SYNC, "");
                if (Util.isNullOrNil(str3)) {
                    String removeFirst = b.this.grR.removeFirst();
                    try {
                        String remove = b.this.grS.remove(removeFirst);
                        try {
                            g.aAh().azQ().set(ar.a.USERINFO_OPEN_IM_MIGRATE_TO_CHAT_ROOM_STRING_SYNC, removeFirst);
                            g.aAh().azQ().set(ar.a.USERINFO_OPEN_IM_MIGRATING_CHAT_ROOM_STRING_SYNC, remove);
                            str2 = remove;
                            str = removeFirst;
                        } catch (Exception e3) {
                            e2 = e3;
                            str2 = remove;
                            str = removeFirst;
                            try {
                                Log.e("MicroMsg.openIm.OpenImMigrateService", "migrateTask Exception: %s %s", e2.getClass().getSimpleName(), e2.getMessage());
                                Log.i("MicroMsg.openIm.OpenImMigrateService", "migrate %s to %s, msgNum %s, time %s, finish %s", Util.nullAs(str2, ""), Util.nullAs(str, ""), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.FALSE);
                                AppMethodBeat.o(194013);
                            } catch (Throwable th2) {
                                th = th2;
                                Log.i("MicroMsg.openIm.OpenImMigrateService", "migrate %s to %s, msgNum %s, time %s, finish %s", Util.nullAs(str2, ""), Util.nullAs(str, ""), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.FALSE);
                                AppMethodBeat.o(194013);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            str2 = remove;
                            str = removeFirst;
                            Log.i("MicroMsg.openIm.OpenImMigrateService", "migrate %s to %s, msgNum %s, time %s, finish %s", Util.nullAs(str2, ""), Util.nullAs(str, ""), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.FALSE);
                            AppMethodBeat.o(194013);
                            throw th;
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        str = removeFirst;
                        Log.e("MicroMsg.openIm.OpenImMigrateService", "migrateTask Exception: %s %s", e2.getClass().getSimpleName(), e2.getMessage());
                        Log.i("MicroMsg.openIm.OpenImMigrateService", "migrate %s to %s, msgNum %s, time %s, finish %s", Util.nullAs(str2, ""), Util.nullAs(str, ""), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.FALSE);
                        AppMethodBeat.o(194013);
                    } catch (Throwable th4) {
                        th = th4;
                        str = removeFirst;
                        Log.i("MicroMsg.openIm.OpenImMigrateService", "migrate %s to %s, msgNum %s, time %s, finish %s", Util.nullAs(str2, ""), Util.nullAs(str, ""), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.FALSE);
                        AppMethodBeat.o(194013);
                        throw th;
                    }
                } else {
                    str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_OPEN_IM_MIGRATING_CHAT_ROOM_STRING_SYNC, "");
                    str = str3;
                }
                try {
                    if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                        Log.w("MicroMsg.openIm.OpenImMigrateService", "chatName:% migrateRoomName:%s", Util.nullAs(str, ""), Util.nullAs(str2, ""));
                        Log.i("MicroMsg.openIm.OpenImMigrateService", "migrate %s to %s, msgNum %s, time %s, finish %s", Util.nullAs(str2, ""), Util.nullAs(str, ""), 0, Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.FALSE);
                        AppMethodBeat.o(194013);
                        return;
                    }
                    ((l) g.af(l.class)).aST().bjW(str2);
                    List<ca> ey = ((l) g.af(l.class)).eiy().ey(str2, 50);
                    int size = ey.size() + 0;
                    Log.d("MicroMsg.openIm.OpenImMigrateService", "migrate length:%s", Integer.valueOf(ey.size()));
                    for (ca caVar : ey) {
                        caVar.Cy(str);
                        Log.d("MicroMsg.openIm.OpenImMigrateService", "migrate1 id:%s", Long.valueOf(caVar.field_msgId));
                        ((l) g.af(l.class)).eiy().a(caVar.field_msgId, caVar);
                    }
                    if (ey.size() == 50) {
                        boolean z2 = false;
                        while (!z2) {
                            List<ca> ey2 = ((l) g.af(l.class)).eiy().ey(str2, 500);
                            if (ey2.size() == 0) {
                                z2 = true;
                            } else {
                                Log.d("MicroMsg.openIm.OpenImMigrateService", "migrate length:%s", Integer.valueOf(ey.size()));
                                for (ca caVar2 : ey2) {
                                    caVar2.Cy(str);
                                    Log.d("MicroMsg.openIm.OpenImMigrateService", "migrate2 id:%s", Long.valueOf(caVar2.field_msgId));
                                    ((l) g.af(l.class)).eiy().a(caVar2.field_msgId, caVar2);
                                }
                                size += ey2.size();
                            }
                        }
                    }
                    try {
                        az bjY = ((l) g.af(l.class)).aST().bjY(str);
                        if (bjY == null) {
                            z = true;
                            bjY = new az(str);
                            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
                            if (Kn != null && !Util.isNullOrNil(Kn.field_username) && Kn.arE()) {
                                bjY.yB(a.a(bjY, 2, 0));
                            }
                        } else {
                            z = false;
                        }
                        bjY.ns(bp.Ku(bjY.field_username));
                        if (z) {
                            a2 = ((l) g.af(l.class)).aST().e(bjY);
                        } else {
                            a2 = (long) ((l) g.af(l.class)).aST().a(bjY, str);
                        }
                        Log.i("MicroMsg.openIm.OpenImMigrateService", "migrateTask conversationStg chatName：%s newConv:%s ret:%s msgCount:%s", str, Boolean.valueOf(z), Long.valueOf(a2), Integer.valueOf(bjY.field_msgCount));
                        b.Dx(str);
                        b.Dx(str2);
                        b.f(str, str2, 1);
                        g.aAh().azQ().set(ar.a.USERINFO_OPEN_IM_MIGRATE_TO_CHAT_ROOM_STRING_SYNC, "");
                        g.aAh().azQ().set(ar.a.USERINFO_OPEN_IM_MIGRATING_CHAT_ROOM_STRING_SYNC, "");
                        Log.i("MicroMsg.openIm.OpenImMigrateService", "migrate %s to %s, msgNum %s, time %s, finish %s", Util.nullAs(str2, ""), Util.nullAs(str, ""), Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.TRUE);
                        b.this.mHandler.sendEmptyMessage(0);
                        AppMethodBeat.o(194013);
                    } catch (Exception e5) {
                        e2 = e5;
                        i2 = size;
                        Log.e("MicroMsg.openIm.OpenImMigrateService", "migrateTask Exception: %s %s", e2.getClass().getSimpleName(), e2.getMessage());
                        Log.i("MicroMsg.openIm.OpenImMigrateService", "migrate %s to %s, msgNum %s, time %s, finish %s", Util.nullAs(str2, ""), Util.nullAs(str, ""), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.FALSE);
                        AppMethodBeat.o(194013);
                    } catch (Throwable th5) {
                        th = th5;
                        i2 = size;
                        Log.i("MicroMsg.openIm.OpenImMigrateService", "migrate %s to %s, msgNum %s, time %s, finish %s", Util.nullAs(str2, ""), Util.nullAs(str, ""), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.FALSE);
                        AppMethodBeat.o(194013);
                        throw th;
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    Log.e("MicroMsg.openIm.OpenImMigrateService", "migrateTask Exception: %s %s", e2.getClass().getSimpleName(), e2.getMessage());
                    Log.i("MicroMsg.openIm.OpenImMigrateService", "migrate %s to %s, msgNum %s, time %s, finish %s", Util.nullAs(str2, ""), Util.nullAs(str, ""), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.FALSE);
                    AppMethodBeat.o(194013);
                }
            } catch (Exception e7) {
                e2 = e7;
                str = "";
                Log.e("MicroMsg.openIm.OpenImMigrateService", "migrateTask Exception: %s %s", e2.getClass().getSimpleName(), e2.getMessage());
                Log.i("MicroMsg.openIm.OpenImMigrateService", "migrate %s to %s, msgNum %s, time %s, finish %s", Util.nullAs(str2, ""), Util.nullAs(str, ""), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.FALSE);
                AppMethodBeat.o(194013);
            } catch (Throwable th6) {
                th = th6;
                str = "";
                Log.i("MicroMsg.openIm.OpenImMigrateService", "migrate %s to %s, msgNum %s, time %s, finish %s", Util.nullAs(str2, ""), Util.nullAs(str, ""), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.FALSE);
                AppMethodBeat.o(194013);
                throw th;
            }
        }
    };
    MMHandler mHandler = new MMHandler("OpenImMigrateService") {
        /* class com.tencent.mm.chatroom.c.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(194012);
            Log.i("MicroMsg.openIm.OpenImMigrateService", "handleMessage running, %s", Integer.valueOf(b.this.grR.size()));
            if (!b.this.grR.isEmpty()) {
                b.this.grQ = h.RTc.b(b.this.grT, "migrate_tag");
            }
            AppMethodBeat.o(194012);
        }
    };

    public b() {
        AppMethodBeat.i(194014);
        AppMethodBeat.o(194014);
    }

    public final void Dw(String str) {
        AppMethodBeat.i(194015);
        Log.i("MicroMsg.openIm.OpenImMigrateService", "setCurChatName:%s", Util.nullAs(str, ""));
        this.ehT = str;
        AppMethodBeat.o(194015);
    }

    public final void ae(String str, String str2) {
        AppMethodBeat.i(194016);
        Log.i("MicroMsg.openIm.OpenImMigrateService", "addMigrateTask %s %s", Util.nullAs(str, ""), Util.nullAs(str2, ""));
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(194016);
        } else if (Util.isEqual(str2, this.ehT)) {
            Log.w("MicroMsg.openIm.OpenImMigrateService", "addMigrateTask in curChatName");
            AppMethodBeat.o(194016);
        } else if (this.grR.contains(str)) {
            Log.i("MicroMsg.openIm.OpenImMigrateService", "addMigrateTask %s exist", Util.nullAs(str, ""));
            AppMethodBeat.o(194016);
        } else {
            this.grS.put(str, str2);
            this.grR.add(str);
            run();
            AppMethodBeat.o(194016);
        }
    }

    public final void af(String str, String str2) {
        AppMethodBeat.i(194017);
        Log.i("MicroMsg.openIm.OpenImMigrateService", "addFirstMigrateTask %s %s", Util.nullAs(str, ""), Util.nullAs(str2, ""));
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(194017);
        } else if (Util.isEqual(str2, this.ehT)) {
            Log.w("MicroMsg.openIm.OpenImMigrateService", "addFirstMigrateTask in curChatName");
            AppMethodBeat.o(194017);
        } else {
            if (this.grR.contains(str)) {
                Log.i("MicroMsg.openIm.OpenImMigrateService", "addFirstMigrateTask %s exist", Util.nullAs(str, ""));
                this.grR.remove(str);
            } else {
                this.grS.put(str, str2);
            }
            this.grR.addFirst(str);
            run();
            AppMethodBeat.o(194017);
        }
    }

    private void run() {
        AppMethodBeat.i(194018);
        if (this.grQ == null || this.grQ.isDone()) {
            this.grQ = h.RTc.b(this.grT, "migrate_tag");
            Log.w("MicroMsg.openIm.OpenImMigrateService", "run stack:%s", Util.getStack());
            AppMethodBeat.o(194018);
            return;
        }
        Log.w("MicroMsg.openIm.OpenImMigrateService", "running stack:%s", Util.getStack());
        AppMethodBeat.o(194018);
    }

    public static void f(String str, String str2, int i2) {
        AppMethodBeat.i(194019);
        gt gtVar = new gt();
        gtVar.uw(str);
        gtVar.ux(str2);
        gtVar.ejW = (long) i2;
        gtVar.bfK();
        AppMethodBeat.o(194019);
    }

    static /* synthetic */ void Dx(String str) {
        AppMethodBeat.i(194020);
        ah Kd = ((c) g.af(c.class)).aSX().Kd(str);
        if (Kd != null) {
            Kd.field_openIMRoomMigrateStatus = 3;
            ((c) g.af(c.class)).aSX().replace(Kd);
        }
        AppMethodBeat.o(194020);
    }
}
