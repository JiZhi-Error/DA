package com.tencent.mm.plugin.notification.d;

import android.content.Intent;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;

public final class d extends a<ca> {
    private IListener AHi = new IListener<tx>() {
        /* class com.tencent.mm.plugin.notification.d.d.AnonymousClass1 */

        {
            AppMethodBeat.i(161397);
            this.__eventId = tx.class.getName().hashCode();
            AppMethodBeat.o(161397);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tx txVar) {
            AppMethodBeat.i(26755);
            final tx txVar2 = txVar;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.notification.d.d.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(26754);
                    ca caVar = txVar2.ear.dCM;
                    if (d.aJa(caVar.field_talker)) {
                        d.this.dI(caVar);
                    }
                    AppMethodBeat.o(26754);
                }
            });
            AppMethodBeat.o(26755);
            return false;
        }
    };
    private IListener AHj = new IListener<tz>() {
        /* class com.tencent.mm.plugin.notification.d.d.AnonymousClass2 */

        {
            AppMethodBeat.i(161398);
            this.__eventId = tz.class.getName().hashCode();
            AppMethodBeat.o(161398);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tz tzVar) {
            AppMethodBeat.i(26757);
            final tz tzVar2 = tzVar;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.notification.d.d.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(26756);
                    ca caVar = tzVar2.eat.dCM;
                    if (d.aJa(caVar.field_talker)) {
                        d.this.dJ(caVar);
                    }
                    AppMethodBeat.o(26756);
                }
            });
            AppMethodBeat.o(26757);
            return false;
        }
    };

    public d() {
        AppMethodBeat.i(26759);
        AppMethodBeat.o(26759);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.notification.c.a
    public final /* bridge */ /* synthetic */ long dK(ca caVar) {
        return caVar.field_msgId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.notification.c.a
    public final /* synthetic */ ArrayList dL(ca caVar) {
        AppMethodBeat.i(26772);
        ArrayList<Long> aJ = f.aJ(caVar);
        AppMethodBeat.o(26772);
        return aJ;
    }

    @Override // com.tencent.mm.plugin.notification.c.c
    public final void eyP() {
        AppMethodBeat.i(26760);
        EventCenter.instance.addListener(this.AHi);
        AppMethodBeat.o(26760);
    }

    @Override // com.tencent.mm.plugin.notification.c.c
    public final void eyQ() {
        AppMethodBeat.i(26761);
        EventCenter.instance.addListener(this.AHj);
        AppMethodBeat.o(26761);
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final void HA(final long j2) {
        AppMethodBeat.i(26762);
        bg.aVF();
        final ca Hb = c.aSQ().Hb(j2);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.notification.d.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(26758);
                Log.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", Long.valueOf(j2));
                sl slVar = new sl();
                slVar.dYZ.dCM = Hb;
                EventCenter.instance.publish(slVar);
                AppMethodBeat.o(26758);
            }
        });
        AppMethodBeat.o(26762);
    }

    @Override // com.tencent.mm.plugin.notification.c.c
    public final void eyR() {
        AppMethodBeat.i(26763);
        EventCenter.instance.removeListener(this.AHi);
        AppMethodBeat.o(26763);
    }

    @Override // com.tencent.mm.plugin.notification.c.c
    public final void eyS() {
        AppMethodBeat.i(26764);
        EventCenter.instance.removeListener(this.AHj);
        AppMethodBeat.o(26764);
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final void eyK() {
        AppMethodBeat.i(26765);
        Log.i("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", Integer.valueOf(this.AGQ.AHb.size()));
        if (!g.aAf().azp()) {
            Log.w("MicroMsg.SendNormalMsgFailNotificaiton", "account not ready.");
            AppMethodBeat.o(26765);
        } else if (this.AGQ.AHb.size() > 1) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            if (Build.VERSION.SDK_INT < 16) {
                intent.putExtra("resend_fail_messages", true);
            }
            intent.putExtra("From_fail_notify", true);
            Log.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
            com.tencent.mm.br.c.f(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
            AppMethodBeat.o(26765);
        } else {
            if (this.AGQ.AHb.size() == 1) {
                long j2 = this.AGQ.get(0);
                bg.aVF();
                String str = c.aSQ().Hb(j2).field_talker;
                Intent intent2 = new Intent();
                intent2.putExtra("Main_User", str);
                intent2.putExtra("From_fail_notify", true);
                intent2.addFlags(67108864);
                intent2.addFlags(536870912);
                if (Build.VERSION.SDK_INT < 16) {
                    intent2.putExtra("resend_fail_messages", true);
                }
                com.tencent.mm.br.c.f(this.mContext, "com.tencent.mm.ui.LauncherUI", intent2);
            }
            AppMethodBeat.o(26765);
        }
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final int getType() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final void aH(ArrayList<Long> arrayList) {
        AppMethodBeat.i(26766);
        g.aAi();
        if (g.aAf().azp()) {
            bg.aVF();
            c.aSQ().ay(arrayList);
            AppMethodBeat.o(26766);
            return;
        }
        Log.e("MicroMsg.SendNormalMsgFailNotificaiton", "omitAllFailMsgImpl account no initialized");
        AppMethodBeat.o(26766);
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final String TR(int i2) {
        AppMethodBeat.i(26767);
        String string = getContext().getString(R.string.fep, Integer.valueOf(i2));
        AppMethodBeat.o(26767);
        return string;
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final String hB(int i2, int i3) {
        AppMethodBeat.i(26768);
        String string = getContext().getString(R.string.fg8, Integer.valueOf(i3), Integer.valueOf(i2));
        AppMethodBeat.o(26768);
        return string;
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final String av(int i2, int i3, int i4) {
        AppMethodBeat.i(26769);
        String string = getContext().getString(R.string.fg9, Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4));
        AppMethodBeat.o(26769);
        return string;
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final String hC(int i2, int i3) {
        AppMethodBeat.i(26770);
        if (i3 <= 0) {
            String string = getContext().getString(R.string.fg6, Integer.valueOf(i2));
            AppMethodBeat.o(26770);
            return string;
        }
        String string2 = getContext().getString(R.string.fg5, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(26770);
        return string2;
    }

    @Override // com.tencent.mm.plugin.notification.c.a
    public final boolean HB(long j2) {
        AppMethodBeat.i(26771);
        bg.aVF();
        ca Hb = c.aSQ().Hb(j2);
        Log.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", Long.valueOf(j2), Long.valueOf(Hb.field_msgId));
        if (Hb.field_msgId != 0) {
            AppMethodBeat.o(26771);
            return true;
        }
        AppMethodBeat.o(26771);
        return false;
    }

    static /* synthetic */ boolean aJa(String str) {
        AppMethodBeat.i(26773);
        if ((as.bjm(str) || as.bjo(str)) && !as.IG(str)) {
            AppMethodBeat.o(26773);
            return false;
        }
        AppMethodBeat.o(26773);
        return true;
    }
}
