package com.tencent.mm.plugin.notification.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.List;

public final class e extends a<c> {
    private IListener AHp = new IListener<wa>() {
        /* class com.tencent.mm.plugin.notification.d.e.AnonymousClass1 */

        {
            AppMethodBeat.i(161399);
            this.__eventId = wa.class.getName().hashCode();
            AppMethodBeat.o(161399);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wa waVar) {
            AppMethodBeat.i(26775);
            final wa waVar2 = waVar;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.notification.d.e.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(26774);
                    wa waVar = waVar2;
                    c cVar = new c();
                    cVar.id = waVar.ech.ecc;
                    e.this.dJ(cVar);
                    AppMethodBeat.o(26774);
                }
            });
            AppMethodBeat.o(26775);
            return false;
        }
    };
    private IListener AHq = new IListener<vy>() {
        /* class com.tencent.mm.plugin.notification.d.e.AnonymousClass2 */

        {
            AppMethodBeat.i(161400);
            this.__eventId = vy.class.getName().hashCode();
            AppMethodBeat.o(161400);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vy vyVar) {
            AppMethodBeat.i(26777);
            final vy vyVar2 = vyVar;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.notification.d.e.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(26776);
                    bg.aVF();
                    c.azQ().set(589825, Boolean.TRUE);
                    vy vyVar = vyVar2;
                    c cVar = new c();
                    cVar.id = vyVar.ecb.ecc;
                    e.this.dI(cVar);
                    AppMethodBeat.o(26776);
                }
            });
            AppMethodBeat.o(26777);
            return false;
        }
    };

    public e() {
        AppMethodBeat.i(26779);
        AppMethodBeat.o(26779);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.notification.c.a
    public final /* bridge */ /* synthetic */ long dK(c cVar) {
        return cVar.id;
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final void eyK() {
        ComponentName componentName;
        AppMethodBeat.i(26780);
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.mContext.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.size() <= 0 || (componentName = runningTasks.get(0).topActivity) == null)) {
            String className = componentName.getClassName();
            Log.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", className);
            if (className.contains("SnsTimeLineUI")) {
                Log.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
                AppMethodBeat.o(26780);
                return;
            }
        }
        Intent intent = new Intent();
        intent.putExtra("sns_resume_state", false);
        intent.putExtra("sns_timeline_NeedFirstLoadint", true);
        intent.putExtra("preferred_tab", 2);
        if (Build.VERSION.SDK_INT < 16) {
            intent.putExtra("is_need_resend_sns", true);
        }
        intent.putExtra("From_fail_notify", true);
        intent.putExtra("jump_sns_from_notify", true);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        com.tencent.mm.br.c.f(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
        AppMethodBeat.o(26780);
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final int getType() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final void aH(ArrayList<Long> arrayList) {
        AppMethodBeat.i(26781);
        oj ojVar = new oj();
        ojVar.dUw.dNX = arrayList;
        EventCenter.instance.publish(ojVar);
        AppMethodBeat.o(26781);
    }

    @Override // com.tencent.mm.plugin.notification.c.c
    public final void eyP() {
        AppMethodBeat.i(26782);
        EventCenter.instance.addListener(this.AHq);
        AppMethodBeat.o(26782);
    }

    @Override // com.tencent.mm.plugin.notification.c.c
    public final void eyQ() {
        AppMethodBeat.i(26783);
        EventCenter.instance.addListener(this.AHp);
        AppMethodBeat.o(26783);
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final void HA(final long j2) {
        AppMethodBeat.i(26784);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.notification.d.e.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(26778);
                Log.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", Long.valueOf(j2));
                sn snVar = new sn();
                snVar.dZd.dZe = (int) j2;
                EventCenter.instance.publish(snVar);
                AppMethodBeat.o(26778);
            }
        });
        AppMethodBeat.o(26784);
    }

    @Override // com.tencent.mm.plugin.notification.c.c
    public final void eyR() {
        AppMethodBeat.i(26785);
        EventCenter.instance.removeListener(this.AHq);
        AppMethodBeat.o(26785);
    }

    @Override // com.tencent.mm.plugin.notification.c.c
    public final void eyS() {
        AppMethodBeat.i(26786);
        EventCenter.instance.removeListener(this.AHp);
        AppMethodBeat.o(26786);
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final String TR(int i2) {
        AppMethodBeat.i(26787);
        String string = getContext().getString(R.string.feq, Integer.valueOf(i2));
        AppMethodBeat.o(26787);
        return string;
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final String hB(int i2, int i3) {
        AppMethodBeat.i(26788);
        String string = getContext().getString(R.string.fg_, Integer.valueOf(i3), Integer.valueOf(i2));
        AppMethodBeat.o(26788);
        return string;
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final String av(int i2, int i3, int i4) {
        AppMethodBeat.i(26789);
        String string = getContext().getString(R.string.fga, Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4));
        AppMethodBeat.o(26789);
        return string;
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final String hC(int i2, int i3) {
        AppMethodBeat.i(26790);
        if (i3 <= 0) {
            String string = getContext().getString(R.string.fg7, Integer.valueOf(i2));
            AppMethodBeat.o(26790);
            return string;
        }
        String string2 = getContext().getString(R.string.fer, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(26790);
        return string2;
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final void eyy() {
        AppMethodBeat.i(26792);
        if (bg.aAc()) {
            bg.aVF();
            c.azQ().set(589825, Boolean.FALSE);
        }
        AppMethodBeat.o(26792);
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final boolean HB(long j2) {
        AppMethodBeat.i(26791);
        if (o.DCS != null) {
            boolean Yh = o.DCS.Yh((int) j2);
            Log.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", Long.valueOf(j2), Boolean.valueOf(Yh));
            AppMethodBeat.o(26791);
            return Yh;
        }
        AppMethodBeat.o(26791);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.notification.c.a
    public final /* synthetic */ ArrayList dL(c cVar) {
        AppMethodBeat.i(26793);
        ArrayList<Long> eZl = o.DCS.eZl();
        if (eZl.size() == 0) {
            Log.e("MicroMsg.SendSnsFailNotification", "getAllFailMsgFromDb, resendList is empty");
        }
        AppMethodBeat.o(26793);
        return eZl;
    }
}
