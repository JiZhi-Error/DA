package com.tencent.mm.booter.notification.queue;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class NotificationQueue {
    public ParcelNotificationQueue goo;

    private void save() {
        AppMethodBeat.i(20014);
        if (this.goo == null) {
            AppMethodBeat.o(20014);
            return;
        }
        Log.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", Integer.valueOf(this.goo.size()));
        if (this.goo.isEmpty()) {
            g.apL().edit().putString("com.tencent.preference.notification.queue", "").apply();
            if (this.goo == null) {
                restore();
            }
            Log.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", Integer.valueOf(this.goo.size()));
            AppMethodBeat.o(20014);
            return;
        }
        AppMethodBeat.o(20014);
    }

    public final synchronized void restore() {
        AppMethodBeat.i(20015);
        Log.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
        if (this.goo == null) {
            this.goo = new ParcelNotificationQueue();
        }
        Log.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", Integer.valueOf(this.goo.size()));
        AppMethodBeat.o(20015);
    }

    public final synchronized boolean d(NotificationItem notificationItem) {
        boolean remove;
        AppMethodBeat.i(20016);
        if (this.goo == null) {
            restore();
        }
        remove = this.goo.remove(notificationItem);
        if (remove) {
            save();
        }
        AppMethodBeat.o(20016);
        return remove;
    }

    public final synchronized NotificationItem nW(int i2) {
        NotificationItem notificationItem;
        AppMethodBeat.i(20017);
        if (this.goo == null) {
            restore();
        }
        Iterator it = this.goo.iterator();
        while (true) {
            if (!it.hasNext()) {
                notificationItem = null;
                break;
            }
            notificationItem = (NotificationItem) it.next();
            if (notificationItem.id == i2) {
                break;
            }
        }
        if (notificationItem != null && this.goo.remove(notificationItem)) {
            save();
        }
        AppMethodBeat.o(20017);
        return notificationItem;
    }

    public final synchronized boolean e(NotificationItem notificationItem) {
        boolean add;
        AppMethodBeat.i(20018);
        if (this.goo == null) {
            restore();
        }
        add = this.goo.add(notificationItem);
        if (add) {
            save();
        }
        AppMethodBeat.o(20018);
        return add;
    }

    public final int size() {
        AppMethodBeat.i(20019);
        if (this.goo == null) {
            restore();
        }
        int size = this.goo.size();
        AppMethodBeat.o(20019);
        return size;
    }

    public static class ParcelNotificationQueue extends LinkedList<NotificationItem> implements Parcelable {
        public static final Parcelable.Creator<ParcelNotificationQueue> CREATOR = new Parcelable.Creator<ParcelNotificationQueue>() {
            /* class com.tencent.mm.booter.notification.queue.NotificationQueue.ParcelNotificationQueue.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ParcelNotificationQueue[] newArray(int i2) {
                return new ParcelNotificationQueue[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ParcelNotificationQueue createFromParcel(Parcel parcel) {
                AppMethodBeat.i(20011);
                ParcelNotificationQueue parcelNotificationQueue = new ParcelNotificationQueue();
                int readInt = parcel.readInt();
                for (int i2 = 0; i2 < readInt; i2++) {
                    parcelNotificationQueue.add((NotificationItem) parcel.readParcelable(NotificationItem.class.getClassLoader()));
                }
                AppMethodBeat.o(20011);
                return parcelNotificationQueue;
            }
        };

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(20012);
            parcel.writeInt(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                parcel.writeParcelable((NotificationItem) it.next(), 0);
            }
            AppMethodBeat.o(20012);
        }

        static {
            AppMethodBeat.i(20013);
            AppMethodBeat.o(20013);
        }
    }
}
