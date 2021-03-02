package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.s;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public class NotificationItem implements Parcelable {
    public static final Parcelable.Creator<NotificationItem> CREATOR = new Parcelable.Creator<NotificationItem>() {
        /* class com.tencent.mm.booter.notification.NotificationItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ NotificationItem[] newArray(int i2) {
            return new NotificationItem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ NotificationItem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(19988);
            NotificationItem notificationItem = new NotificationItem(parcel, (byte) 0);
            AppMethodBeat.o(19988);
            return notificationItem;
        }
    };
    Notification HX;
    private final String TAG;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f1454b;
    private PendingIntent god;
    public String goe;
    public long gof;
    public int gog;
    public boolean goh;
    public int goi;
    public int goj;
    public int id;

    /* synthetic */ NotificationItem(Parcel parcel, byte b2) {
        this(parcel);
    }

    public NotificationItem(int i2, String str, Notification notification) {
        this(i2, str, notification, true);
    }

    public NotificationItem(int i2, Notification notification, boolean z) {
        this(i2, null, notification, z);
    }

    public NotificationItem(Notification notification, boolean z) {
        this(-1, notification, z);
    }

    @TargetApi(11)
    private NotificationItem(int i2, String str, Notification notification, boolean z) {
        AppMethodBeat.i(19989);
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.gof = 0;
        this.gog = 0;
        this.goh = true;
        this.goi = 0;
        this.goj = 0;
        this.id = i2;
        this.goe = str;
        if (Build.VERSION.SDK_INT >= 11) {
            this.f1454b = notification.largeIcon;
        }
        this.HX = notification;
        this.goh = z;
        this.goi = 0;
        AppMethodBeat.o(19989);
    }

    public final synchronized void clear() {
        AppMethodBeat.i(19990);
        if (this.f1454b != null && !this.f1454b.isRecycled()) {
            Log.i("MicroMsg.NotificationItem", "recycle bitmap:%s", this.f1454b.toString());
            this.f1454b.recycle();
        }
        this.HX = null;
        this.f1454b = null;
        this.god = null;
        AppMethodBeat.o(19990);
    }

    public final synchronized int a(g gVar) {
        NotificationItem notificationItem;
        int i2;
        boolean z;
        NotificationItem notificationItem2 = null;
        synchronized (this) {
            AppMethodBeat.i(19991);
            this.id = this.id == -1 ? b.alj().o(this.goe, this.goh) : this.id;
            Context context = MMApplicationContext.getContext();
            if (context == null) {
                Log.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
                AppMethodBeat.o(19991);
                i2 = -1;
            } else if (this.HX == null) {
                Log.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
                AppMethodBeat.o(19991);
                i2 = -1;
            } else {
                b alj = b.alj();
                String str = this.goe;
                if (!Util.isNullOrNil(str)) {
                    Iterator<NotificationItem> it = alj.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            notificationItem = null;
                            break;
                        }
                        notificationItem = it.next();
                        if (notificationItem != null && notificationItem.goe != null && notificationItem.goe.equals(str)) {
                            break;
                        }
                    }
                } else {
                    notificationItem = null;
                }
                if (notificationItem != null) {
                    b alj2 = b.alj();
                    int i3 = notificationItem.id;
                    Log.d("MicroMsg.Notification.Queue", "mark: %d", Integer.valueOf(i3));
                    alj2.mark = i3;
                }
                if (!(notificationItem == null || notificationItem.HX.tickerText == null || this.HX.tickerText == null || !notificationItem.HX.tickerText.equals(this.HX.tickerText))) {
                    this.HX.tickerText = ((Object) this.HX.tickerText) + " ";
                }
                b alj3 = b.alj();
                if (this.id == -1) {
                    Log.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
                } else {
                    if (alj3.mark > 0) {
                        if (alj3.mark == this.id) {
                            Log.d("MicroMsg.Notification.Queue", "remove mark: %d", Integer.valueOf(alj3.mark));
                            alj3.nX(alj3.mark);
                        }
                        alj3.mark = -1;
                    }
                    alj3.nX(this.id);
                    if (alj3.goq.size() >= 5) {
                        notificationItem2 = alj3.alk();
                    }
                    alj3.goq.e(this);
                    alj3.gor.c(this);
                    Log.i("MicroMsg.Notification.Queue", "put item: %s, queuesize: %d", toString(), Integer.valueOf(alj3.goq.size()));
                }
                if (notificationItem2 != null) {
                    b.alj().cancel(notificationItem2.id);
                }
                this.goj = e.a(this.HX, gVar);
                if (context != null) {
                    if (this.HX == null) {
                        Log.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
                    } else {
                        Context context2 = MMApplicationContext.getContext();
                        if (context2 == null) {
                            Log.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
                        } else if (this.HX == null) {
                            Log.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                        } else {
                            if (context2.getResources().getDrawable(this.HX.icon) == null) {
                                this.HX.icon = R.drawable.icon;
                            }
                        }
                        Log.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", Integer.valueOf(this.HX.defaults), this.HX.sound, g.a(this.HX.vibrate));
                        try {
                            if (e.alt() == 1 && this.HX.defaults != 2 && this.HX.vibrate == null) {
                                this.HX.defaults = 0;
                                this.HX.sound = null;
                                Log.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                            }
                            if (d.oD(26)) {
                                Log.i("MicroMsg.NotificationItem", "manual add led to notification");
                                this.HX.ledARGB = -16711936;
                                this.HX.ledOnMS = 300;
                                this.HX.ledOffMS = 1000;
                            }
                            v P = v.P(MMApplicationContext.getContext());
                            int i4 = this.id;
                            Notification notification = this.HX;
                            Bundle a2 = s.a(notification);
                            if (a2 == null || !a2.getBoolean("android.support.useSideChannel")) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                P.a(new v.b(P.mContext.getPackageName(), i4, notification));
                                P.Iw.cancel(null, i4);
                            } else {
                                P.Iw.notify(null, i4, notification);
                            }
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.NotificationItem", e2, "Notification Exception?", new Object[0]);
                        }
                        if (this.gof != 0) {
                            d.yO(this.gof);
                        }
                    }
                }
                i2 = this.id;
                AppMethodBeat.o(19991);
            }
        }
        return i2;
    }

    private NotificationItem(Parcel parcel) {
        boolean z;
        AppMethodBeat.i(19992);
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.gof = 0;
        this.gog = 0;
        this.goh = true;
        this.goi = 0;
        this.goj = 0;
        if (parcel == null) {
            AppMethodBeat.o(19992);
            return;
        }
        this.id = parcel.readInt();
        this.goe = parcel.readString();
        this.f1454b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.HX = (Notification) parcel.readParcelable(Notification.class.getClassLoader());
        this.god = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.goh = z;
        this.gof = parcel.readLong();
        this.gog = parcel.readInt();
        AppMethodBeat.o(19992);
    }

    static {
        AppMethodBeat.i(19995);
        AppMethodBeat.o(19995);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        AppMethodBeat.i(19994);
        String str = "id: " + this.id + ",msgId: " + this.gof + ",userName: " + this.goe + ",unreadCount: " + this.gog;
        AppMethodBeat.o(19994);
        return str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        String str;
        int i3;
        AppMethodBeat.i(19993);
        parcel.writeInt(this.id);
        if (this.goe == null) {
            str = "";
        } else {
            str = this.goe;
        }
        parcel.writeString(str);
        parcel.writeParcelable(this.f1454b, 0);
        parcel.writeParcelable(this.HX, 0);
        parcel.writeParcelable(this.god, 0);
        if (this.goh) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeLong(this.gof);
        parcel.writeInt(this.gog);
        AppMethodBeat.o(19993);
    }
}
