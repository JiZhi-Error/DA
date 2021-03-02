package com.tencent.mm.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.s;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\rH\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0007JB\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0018J8\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0018J@\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018J6\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\rR\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, hxF = {"Lcom/tencent/mm/util/FullscreenIntentActivityUtil;", "", "()V", "CONTENTTEXT", "", "DESTCLASS", "NOTIFICATION_CHANNEL_ID", "NOTIFY_STILL", "REMOTEVIEW", "TAG", "getTAG", "()Ljava/lang/String;", "callNormalNotification", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "remoteViews", "Landroid/widget/RemoteViews;", "description", d.QYE, "channelId", "isNotifyStill", "", "cancelNotification", "getNotificationIconRs", "", "startActivity", "remoteView", "startActivityWithOp", "stopFullScreenService", "plugin-comm_release"})
public final class d {
    public static final String QYC = QYC;
    public static final String QYD = QYD;
    public static final String QYE = QYE;
    public static final String QYF = "channelId";
    public static final String QYG = QYG;
    public static final d QYH = new d();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(149845);
        AppMethodBeat.o(149845);
    }

    private d() {
    }

    public static void b(Context context, Intent intent, RemoteViews remoteViews, String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(149841);
        p.h(context, "context");
        p.h(intent, "intent");
        p.h(str, "description");
        p.h(str2, QYE);
        p.h(str3, "channelId");
        c(context, intent, remoteViews, str, str2, str3, z);
        AppMethodBeat.o(149841);
    }

    public static void b(Context context, Intent intent, String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(149842);
        p.h(context, "context");
        p.h(intent, "intent");
        p.h(str, "description");
        p.h(str2, QYE);
        p.h(str3, "channelId");
        c(context, intent, null, str, str2, str3, z);
        AppMethodBeat.o(149842);
    }

    private static void c(Context context, Intent intent, RemoteViews remoteViews, String str, String str2, String str3, boolean z) {
        s.c E;
        AppMethodBeat.i(149843);
        p.h(context, "context");
        p.h(intent, "intent");
        p.h(str, "description");
        p.h(str2, QYE);
        p.h(str3, "channelId");
        intent.setFlags(268435456);
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        intent.setClassName(context2.getPackageName(), str2);
        PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, intent, 134217728);
        if (remoteViews != null) {
            E = new s.c(context, str3).eu().u("call").i(System.currentTimeMillis()).a(activity).c(activity).as(ezb()).b(remoteViews).f(MMApplicationContext.getContext().getString(R.string.y7)).c(remoteViews).g(str).et().E(true);
            p.g(E, "NotificationCompat.Build…\t\t\t\t\t.setAutoCancel(true)");
        } else {
            E = new s.c(context, str3).eu().u("reminder").i(System.currentTimeMillis()).a(activity).c(activity).as(ezb()).f(MMApplicationContext.getContext().getString(R.string.y7)).g(str).et().E(true);
            p.g(E, "NotificationCompat.Build…\t\t\t\t\t.setAutoCancel(true)");
        }
        Notification build = E.build();
        if (z) {
            build.flags |= 4;
        }
        com.tencent.mm.plugin.notification.d.eys().notify(41, build);
        AppMethodBeat.o(149843);
    }

    private static int ezb() {
        if (Build.VERSION.SDK_INT < 19) {
            return R.drawable.cj7;
        }
        return R.drawable.cj8;
    }

    public static final void fAL() {
        AppMethodBeat.i(149844);
        com.tencent.mm.plugin.notification.d.eys().cancel(41);
        AppMethodBeat.o(149844);
    }
}
