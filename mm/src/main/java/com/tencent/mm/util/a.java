package com.tencent.mm.util;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0018H\u0007JR\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0018H\u0007JJ\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0018H\u0007J@\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0018H\u0007JR\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0018H\u0007JF\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J<\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u0018H\u0002JD\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J:\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0018H\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, hxF = {"Lcom/tencent/mm/util/ActivityHelper;", "", "()V", "START_METHOD", "", "TAG", "USE_ACTIVITY", "", "USE_SERVICE", "delayTime", "", "getDelayTime", "()J", "checkAndStartActivity", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "remoteViews", "Landroid/widget/RemoteViews;", "description", d.QYE, "isImmediately", "", "channelId", "isNotifyStill", "plugin", "entry", "checkAndStartActivityWithoutOp", "startActivityOnNotification", "startActivityOnNotificationWithoutOp", "plugin-comm_release"})
public final class a {
    public static final int QYj = 0;
    public static final int QYk = 1;
    public static String QYl = "startMethod";
    public static final a QYm = new a();
    private static final String TAG = TAG;
    private static final long delayTime = delayTime;

    static {
        AppMethodBeat.i(149830);
        AppMethodBeat.o(149830);
    }

    private a() {
    }

    public static final void a(Context context, Intent intent, RemoteViews remoteViews, String str, String str2, String str3) {
        AppMethodBeat.i(149827);
        p.h(context, "context");
        p.h(intent, "intent");
        p.h(str, "description");
        p.h(str2, d.QYE);
        p.h(str3, "channelId");
        MMHandlerThread.postToMainThreadDelayed(new RunnableC2148a(d.oF(28) || p.j(Build.VERSION.CODENAME, "Q"), remoteViews, intent, context, str, str2, str3), 0);
        AppMethodBeat.o(149827);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.util.a$a  reason: collision with other inner class name */
    static final class RunnableC2148a implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        final /* synthetic */ String ILw;
        final /* synthetic */ boolean QYn;
        final /* synthetic */ RemoteViews QYo;
        final /* synthetic */ String QYp;
        final /* synthetic */ String QYq;
        final /* synthetic */ boolean QYr = true;

        RunnableC2148a(boolean z, RemoteViews remoteViews, Intent intent, Context context, String str, String str2, String str3) {
            this.QYn = z;
            this.QYo = remoteViews;
            this.$intent = intent;
            this.$context = context;
            this.ILw = str;
            this.QYp = str2;
            this.QYq = str3;
        }

        public final void run() {
            AppMethodBeat.i(149824);
            if (!this.QYn || AppForegroundDelegate.INSTANCE.Wc() || this.QYo == null) {
                a aVar = a.QYm;
                Log.i(a.TAG, "start permission notification in Q and use activity");
                this.$intent.putExtra("Voip_Call_From", 1);
                Context context = this.$context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.$intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(149824);
                return;
            }
            a aVar2 = a.QYm;
            Log.i(a.TAG, "start permission notification in Q and use service");
            this.$intent.putExtra("Voip_Call_From", 0);
            a aVar3 = a.QYm;
            a.a(this.$context, this.$intent, this.QYo, this.ILw, this.QYp, this.QYq, this.QYr);
            AppMethodBeat.o(149824);
        }
    }

    public static final void a(Context context, Intent intent, String str, String str2, String str3) {
        AppMethodBeat.i(149828);
        p.h(context, "context");
        p.h(intent, "intent");
        p.h(str, "description");
        p.h(str2, d.QYE);
        p.h(str3, "channelId");
        MMHandlerThread.postToMainThreadDelayed(new b(d.oF(28) || p.j(Build.VERSION.CODENAME, "Q"), context, intent, str, str2, str3), delayTime);
        AppMethodBeat.o(149828);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        final /* synthetic */ String ILw;
        final /* synthetic */ boolean QYn;
        final /* synthetic */ String QYp;
        final /* synthetic */ String QYq;
        final /* synthetic */ boolean QYr = false;

        b(boolean z, Context context, Intent intent, String str, String str2, String str3) {
            this.QYn = z;
            this.$context = context;
            this.$intent = intent;
            this.ILw = str;
            this.QYp = str2;
            this.QYq = str3;
        }

        public final void run() {
            AppMethodBeat.i(149825);
            if (!this.QYn || AppForegroundDelegate.INSTANCE.Wc()) {
                a aVar = a.QYm;
                Log.i(a.TAG, "start permission notification in Q and use activity");
                Context context = this.$context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.$intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(149825);
                return;
            }
            a aVar2 = a.QYm;
            Log.i(a.TAG, "start permission notification in Q and use service");
            a aVar3 = a.QYm;
            a.a(this.$context, this.$intent, this.ILw, this.QYp, this.QYq, this.QYr);
            AppMethodBeat.o(149825);
        }
    }

    public static final void a(Context context, String str, String str2, Intent intent, RemoteViews remoteViews, String str3, String str4) {
        AppMethodBeat.i(149829);
        p.h(context, "context");
        p.h(str, "plugin");
        p.h(str2, "entry");
        p.h(intent, "intent");
        p.h(str3, "description");
        p.h(str4, "channelId");
        MMHandlerThread.postToMainThreadDelayed(new c(d.oF(28) || p.j(Build.VERSION.CODENAME, "Q"), remoteViews, intent, str, str2, context, str3, str4), 0);
        AppMethodBeat.o(149829);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        final /* synthetic */ String ILw;
        final /* synthetic */ boolean QYn;
        final /* synthetic */ RemoteViews QYo;
        final /* synthetic */ String QYq;
        final /* synthetic */ boolean QYr = true;
        final /* synthetic */ String QYs;
        final /* synthetic */ String QYt;

        c(boolean z, RemoteViews remoteViews, Intent intent, String str, String str2, Context context, String str3, String str4) {
            this.QYn = z;
            this.QYo = remoteViews;
            this.$intent = intent;
            this.QYs = str;
            this.QYt = str2;
            this.$context = context;
            this.ILw = str3;
            this.QYq = str4;
        }

        public final void run() {
            AppMethodBeat.i(149826);
            if (!this.QYn || AppForegroundDelegate.INSTANCE.Wc() || this.QYo == null) {
                this.$intent.putExtra(a.QYl, a.QYk);
                a aVar = a.QYm;
                Log.i(a.TAG, "start permission notification in Q and use activity");
                com.tencent.mm.br.c.a(this.$context, this.QYs, this.QYt, this.$intent, (Bundle) null);
                AppMethodBeat.o(149826);
                return;
            }
            a aVar2 = a.QYm;
            Log.i(a.TAG, "start permission notification in Q and use service");
            this.$intent.putExtra(a.QYl, a.QYj);
            String str = n.J(this.QYt, ".", false) ? (MMApplicationContext.getSourcePackageName() + ".plugin." + this.QYs) + this.QYt : this.QYt;
            Class.forName(str, false, this.$context.getClassLoader());
            a aVar3 = a.QYm;
            a.a(this.$context, this.$intent, this.QYo, this.ILw, str, this.QYq, this.QYr);
            AppMethodBeat.o(149826);
        }
    }

    public static final /* synthetic */ void a(Context context, Intent intent, RemoteViews remoteViews, String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(149831);
        d dVar = d.QYH;
        d.b(context, intent, remoteViews, str, str2, str3, z);
        AppMethodBeat.o(149831);
    }

    public static final /* synthetic */ void a(Context context, Intent intent, String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(149832);
        d dVar = d.QYH;
        d.b(context, intent, str, str2, str3, z);
        AppMethodBeat.o(149832);
    }
}
