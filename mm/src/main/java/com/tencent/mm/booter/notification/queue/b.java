package com.tencent.mm.booter.notification.queue;

import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.booter.notification.queue.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class b implements Iterable<NotificationItem> {
    public NotificationQueue goq;
    public a gor;
    public int mark;

    /* synthetic */ b(byte b2) {
        this();
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        private static final b gos = new b((byte) 0);

        static {
            AppMethodBeat.i(20020);
            AppMethodBeat.o(20020);
        }
    }

    public static final b alj() {
        AppMethodBeat.i(20021);
        b bVar = a.gos;
        AppMethodBeat.o(20021);
        return bVar;
    }

    private b() {
        AppMethodBeat.i(20022);
        this.mark = -1;
        this.goq = new NotificationQueue();
        this.gor = new a();
        restore();
        AppMethodBeat.o(20022);
    }

    public final void restore() {
        AppMethodBeat.i(20023);
        this.goq.restore();
        this.gor.restore();
        AppMethodBeat.o(20023);
    }

    public final void nX(int i2) {
        AppMethodBeat.i(20024);
        this.gor.remove(i2);
        NotificationItem nW = this.goq.nW(i2);
        if (nW != null) {
            nW.clear();
        }
        AppMethodBeat.o(20024);
    }

    public final NotificationItem alk() {
        NotificationItem notificationItem;
        AppMethodBeat.i(20025);
        int i2 = 0;
        while (true) {
            if (i2 >= this.goq.size()) {
                notificationItem = null;
                break;
            }
            NotificationQueue notificationQueue = this.goq;
            if (notificationQueue.goo == null) {
                notificationQueue.restore();
            }
            notificationItem = (NotificationItem) notificationQueue.goo.get(i2);
            if (notificationItem.goh) {
                if (this.gor.remove(notificationItem.id)) {
                    Log.d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", notificationItem.toString());
                }
                this.goq.d(notificationItem);
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(20025);
        return notificationItem;
    }

    public final Queue<Integer> all() {
        AppMethodBeat.i(20026);
        LinkedList linkedList = new LinkedList();
        for (int i2 = 4097; i2 < 4102; i2++) {
            linkedList.add(Integer.valueOf(i2));
        }
        linkedList.addAll(alm());
        AppMethodBeat.o(20026);
        return linkedList;
    }

    private Queue<Integer> alm() {
        AppMethodBeat.i(20027);
        LinkedList linkedList = new LinkedList();
        LinkedList<NotificationItem> linkedList2 = new LinkedList();
        NotificationQueue notificationQueue = this.goq;
        if (notificationQueue.goo == null) {
            notificationQueue.restore();
        }
        linkedList2.addAll(notificationQueue.goo);
        for (NotificationItem notificationItem : linkedList2) {
            if (notificationItem.goh) {
                linkedList.add(Integer.valueOf(notificationItem.id));
                Log.d("MicroMsg.Notification.Queue", "remove allcustom: %d", Integer.valueOf(notificationItem.id));
            }
        }
        linkedList2.clear();
        LinkedList<a.C0282a> linkedList3 = new LinkedList();
        a aVar = this.gor;
        if (aVar.gom == null) {
            aVar.restore();
        }
        linkedList3.addAll(aVar.gom);
        for (a.C0282a aVar2 : linkedList3) {
            if (aVar2.goh) {
                linkedList.add(Integer.valueOf(aVar2.notificationId));
                Log.d("MicroMsg.Notification.Queue", "remove allcustom: %d", Integer.valueOf(aVar2.notificationId));
            }
        }
        linkedList3.clear();
        AppMethodBeat.o(20027);
        return linkedList;
    }

    public final int getId(String str) {
        AppMethodBeat.i(20028);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(20028);
            return -1;
        }
        Iterator<a.C0282a> it = this.gor.iterator();
        while (it.hasNext()) {
            a.C0282a next = it.next();
            if (next.userName.equals(str)) {
                int i2 = next.notificationId;
                AppMethodBeat.o(20028);
                return i2;
            }
        }
        AppMethodBeat.o(20028);
        return -1;
    }

    public final void a(v vVar, int i2) {
        AppMethodBeat.i(20030);
        if (vVar == null) {
            Log.e("MicroMsg.Notification.Queue", "manager is null???");
            AppMethodBeat.o(20030);
            return;
        }
        vVar.cancel(i2);
        nX(i2);
        AppMethodBeat.o(20030);
    }

    public final int Da(String str) {
        AppMethodBeat.i(20031);
        int id = getId(str);
        if (id > 0) {
            AppMethodBeat.o(20031);
            return id;
        }
        int o = o(str, true);
        AppMethodBeat.o(20031);
        return o;
    }

    public final int o(String str, boolean z) {
        int i2;
        AppMethodBeat.i(20032);
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "";
        Iterator<a.C0282a> it = this.gor.iterator();
        while (it.hasNext()) {
            str2 = str2 + it.next().notificationId + ",";
        }
        if (z) {
            i2 = 4097;
        } else {
            i2 = 4102;
        }
        while (str2.contains(String.valueOf(i2))) {
            i2++;
        }
        if (i2 >= 4102 && z) {
            i2 = 4097;
        }
        if (!Util.isNullOrNil(str) && z) {
            i2 = str.hashCode();
        }
        Log.d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i2), Boolean.valueOf(z));
        AppMethodBeat.o(20032);
        return i2;
    }

    @Override // java.lang.Iterable
    public final Iterator<NotificationItem> iterator() {
        AppMethodBeat.i(20033);
        NotificationQueue notificationQueue = this.goq;
        if (notificationQueue.goo == null) {
            notificationQueue.restore();
        }
        Iterator<NotificationItem> it = notificationQueue.goo.iterator();
        AppMethodBeat.o(20033);
        return it;
    }

    public final void cancel(int i2) {
        AppMethodBeat.i(20029);
        a(v.P(MMApplicationContext.getContext()), i2);
        AppMethodBeat.o(20029);
    }
}
