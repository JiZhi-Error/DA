package com.tencent.mm.booter.notification.queue;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements Serializable, Iterable<C0282a> {
    LinkedList<C0282a> gom;

    public final String toString() {
        AppMethodBeat.i(20003);
        StringBuilder sb = new StringBuilder("");
        Iterator<C0282a> it = this.gom.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString()).append(";  ");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(20003);
        return sb2;
    }

    public final synchronized void restore() {
        AppMethodBeat.i(20004);
        try {
            this.gom = (LinkedList) c.Db(g.apL().getString("com.tencent.preference.notification.key.queue", ""));
            if (this.gom == null) {
                this.gom = new LinkedList<>();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e2, "", new Object[0]);
            if (this.gom == null) {
                this.gom = new LinkedList<>();
            }
        } catch (Throwable th) {
            if (this.gom == null) {
                this.gom = new LinkedList<>();
            }
            AppMethodBeat.o(20004);
            throw th;
        }
        Log.i("MicroMsg.NotificationAppMsgQueue", "restore size:%d, %s", Integer.valueOf(this.gom.size()), toString());
        AppMethodBeat.o(20004);
    }

    private synchronized void save() {
        AppMethodBeat.i(20005);
        if (this.gom == null) {
            AppMethodBeat.o(20005);
        } else {
            Log.d("MicroMsg.NotificationAppMsgQueue", "save: size: %d", Integer.valueOf(this.gom.size()));
            if (this.gom.isEmpty()) {
                g.apL().edit().putString("com.tencent.preference.notification.key.queue", "").apply();
                Log.i("MicroMsg.NotificationAppMsgQueue", "reset size:%d, %s", Integer.valueOf(this.gom.size()), toString());
                AppMethodBeat.o(20005);
            } else {
                try {
                    g.apL().edit().putString("com.tencent.preference.notification.key.queue", c.a(new LinkedList(this.gom))).apply();
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e2, "", new Object[0]);
                }
                Log.i("MicroMsg.NotificationAppMsgQueue", "save size:%d, %s", Integer.valueOf(this.gom.size()), toString());
                AppMethodBeat.o(20005);
            }
        }
    }

    public final synchronized void c(NotificationItem notificationItem) {
        boolean z;
        boolean z2 = true;
        synchronized (this) {
            AppMethodBeat.i(20006);
            if (this.gom == null) {
                restore();
            }
            remove(notificationItem.id);
            if (!notificationItem.goh || Util.isNullOrNil(notificationItem.goe)) {
                this.gom.add(new C0282a(notificationItem.id, notificationItem.goh));
                Log.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", notificationItem.toString());
            } else {
                Iterator<C0282a> it = this.gom.iterator();
                while (it.hasNext()) {
                    C0282a next = it.next();
                    if (next.userName.equals(notificationItem.goe)) {
                        next.a(notificationItem.id, notificationItem.gof, notificationItem.goe, notificationItem.gog, notificationItem.goh, notificationItem.goi);
                        z = false;
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
                if (z2) {
                    this.gom.add(new C0282a(notificationItem.id, notificationItem.gof, notificationItem.goe, notificationItem.gog, notificationItem.goh, notificationItem.goi));
                    Log.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", notificationItem.toString());
                }
            }
            save();
            AppMethodBeat.o(20006);
        }
    }

    public final synchronized List<Integer> nV(int i2) {
        ArrayList arrayList;
        AppMethodBeat.i(20007);
        if (this.gom == null) {
            restore();
        }
        arrayList = new ArrayList();
        Iterator<C0282a> it = iterator();
        while (it.hasNext()) {
            C0282a next = it.next();
            if ((next.gon & i2) != 0 && !arrayList.contains(Integer.valueOf(next.notificationId))) {
                arrayList.add(Integer.valueOf(next.notificationId));
            }
        }
        AppMethodBeat.o(20007);
        return arrayList;
    }

    public final synchronized boolean remove(int i2) {
        boolean z;
        AppMethodBeat.i(20008);
        if (i2 == -1) {
            AppMethodBeat.o(20008);
            z = false;
        } else {
            if (this.gom == null) {
                restore();
            }
            LinkedList<C0282a> linkedList = new LinkedList<>();
            Iterator<C0282a> it = this.gom.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                C0282a next = it.next();
                if (next.notificationId != i2) {
                    linkedList.add(next);
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                this.gom = linkedList;
                save();
                AppMethodBeat.o(20008);
                z = true;
            } else {
                AppMethodBeat.o(20008);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean remove(String str) {
        boolean z;
        AppMethodBeat.i(20009);
        Log.i("MicroMsg.NotificationAppMsgQueue", "remove username: %s", str);
        if (!Util.isNullOrNil(str)) {
            if (this.gom == null) {
                restore();
            }
            Iterator<C0282a> it = this.gom.iterator();
            while (true) {
                if (!it.hasNext()) {
                    AppMethodBeat.o(20009);
                    z = false;
                    break;
                }
                C0282a next = it.next();
                if (str.equals(next.userName)) {
                    this.gom.remove(next);
                    save();
                    AppMethodBeat.o(20009);
                    z = true;
                    break;
                }
            }
        } else {
            AppMethodBeat.o(20009);
            z = false;
        }
        return z;
    }

    /* renamed from: com.tencent.mm.booter.notification.queue.a$a  reason: collision with other inner class name */
    public static class C0282a implements Serializable {
        public int dOS;
        public boolean goh = false;
        public int gon = 0;
        public long msgId = -1;
        public int notificationId;
        public String userName = "";

        public C0282a(int i2, long j2, String str, int i3, boolean z, int i4) {
            AppMethodBeat.i(20001);
            a(i2, j2, str, i3, z, i4);
            AppMethodBeat.o(20001);
        }

        public C0282a(int i2, boolean z) {
            this.notificationId = i2;
            this.goh = z;
        }

        public final String toString() {
            AppMethodBeat.i(20002);
            String str = this.userName + " id:" + this.msgId + " unReadCount:" + this.dOS + "　notificationId:" + this.notificationId;
            AppMethodBeat.o(20002);
            return str;
        }

        public final void a(int i2, long j2, String str, int i3, boolean z, int i4) {
            this.notificationId = i2;
            this.msgId = j2;
            this.userName = str;
            this.dOS = i3;
            this.goh = z;
            this.gon = i4;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<C0282a> iterator() {
        AppMethodBeat.i(20010);
        if (this.gom == null) {
            restore();
        }
        Iterator<C0282a> it = this.gom.iterator();
        AppMethodBeat.o(20010);
        return it;
    }
}
