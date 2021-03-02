package com.tencent.mm.live.core.mini;

import android.annotation.TargetApi;
import android.app.Notification;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0003J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0016\u001a\u00020\bJ&\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/live/core/mini/LiveMiniNotificationHelper;", "", "()V", "TAG", "", "isBindForegroundService", "", "bindForegroundServiceIfNeed", "", "title", "content", "tickerContent", "activityName", "createNotification", "Landroid/app/Notification;", "intent", "Landroid/content/Intent;", "getAPI15NotificationFromBuilder", "builder", "Landroid/support/v4/app/NotificationCompat$Builder;", "getAPI16NotificationFromBuilder", "getNotificationFromBuilder", "hideNotification", "showNotification", "unBindForegroundServiceIfNeed", "plugin-core_release"})
public final class c {
    public static final c hCU = new c();

    static {
        AppMethodBeat.i(196592);
        AppMethodBeat.o(196592);
    }

    private c() {
    }

    @TargetApi(16)
    static Notification c(s.c cVar) {
        AppMethodBeat.i(196589);
        Notification build = cVar.build();
        p.g(build, "builder.build()");
        AppMethodBeat.o(196589);
        return build;
    }

    static Notification d(s.c cVar) {
        AppMethodBeat.i(196590);
        Notification build = cVar.build();
        p.g(build, "builder.build()");
        AppMethodBeat.o(196590);
        return build;
    }

    public static void aEk() {
        AppMethodBeat.i(196591);
        a ah = g.ah(com.tencent.mm.plugin.notification.b.a.class);
        p.g(ah, "MMKernel.plugin(IPluginNotification::class.java)");
        ((com.tencent.mm.plugin.notification.b.a) ah).getNotification().cancel(46);
        AppMethodBeat.o(196591);
    }
}
