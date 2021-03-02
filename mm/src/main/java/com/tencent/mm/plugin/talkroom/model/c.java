package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bh.d;
import com.tencent.mm.bq.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class c implements d {
    public boolean FPH = false;
    private String FPI;
    private Notification kYy;
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    public String yIY = "";
    public boolean yJA = false;

    private static boolean ftR() {
        AppMethodBeat.i(29448);
        if (Util.isNullOrNil(b.ftN().FQv)) {
            Log.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
            Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
            ftU();
            AppMethodBeat.o(29448);
            return false;
        }
        AppMethodBeat.o(29448);
        return true;
    }

    @Override // com.tencent.mm.bh.d
    public final void bgz() {
        this.yJA = false;
    }

    @Override // com.tencent.mm.bh.d
    public final void s(String str, int i2, int i3) {
        this.yJA = false;
    }

    @Override // com.tencent.mm.bh.d
    public final void bgA() {
    }

    @Override // com.tencent.mm.bh.d
    public final void ua(int i2) {
    }

    @Override // com.tencent.mm.bh.d
    public final void PX(String str) {
        this.yIY = str;
    }

    @Override // com.tencent.mm.bh.d
    public final void bA(String str, String str2) {
        AppMethodBeat.i(29449);
        if (this.FPH) {
            AppMethodBeat.o(29449);
            return;
        }
        ftT();
        AppMethodBeat.o(29449);
    }

    @Override // com.tencent.mm.bh.d
    public final void j(int i2, int i3, String str) {
    }

    @Override // com.tencent.mm.bh.d
    public final void bgC() {
    }

    @Override // com.tencent.mm.bh.d
    public final void bgD() {
    }

    @Override // com.tencent.mm.bh.d
    public final void bgE() {
    }

    public final void ftS() {
        AppMethodBeat.i(29451);
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.talkroom.model.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(29447);
                b.ftM();
                Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
                b.ftM();
                c.ftU();
                AppMethodBeat.o(29447);
            }
        });
        AppMethodBeat.o(29451);
    }

    public c() {
        AppMethodBeat.i(29452);
        AppMethodBeat.o(29452);
    }

    public final void aST(String str) {
        AppMethodBeat.i(29453);
        if (!ftR()) {
            AppMethodBeat.o(29453);
            return;
        }
        Log.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: ".concat(String.valueOf(str)));
        this.FPI = str;
        this.kYy = a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(str).i(0).build();
        this.kYy.icon = R.drawable.bow;
        this.kYy.flags = 32;
        ftT();
        AppMethodBeat.o(29453);
    }

    private void ftT() {
        String string;
        AppMethodBeat.i(29454);
        if (!ftR()) {
            AppMethodBeat.o(29454);
        } else if (this.kYy == null) {
            Log.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
            AppMethodBeat.o(29454);
        } else {
            String bC = h.bC(MMApplicationContext.getContext(), b.ftN().FQv);
            if (b.ftN().FQJ) {
                string = MMApplicationContext.getContext().getString(R.string.hko);
            } else {
                string = MMApplicationContext.getContext().getString(R.string.hkl, Integer.valueOf(b.ftN().ecY().size()));
            }
            Intent Xd = com.tencent.mm.plugin.talkroom.a.jRu.Xd();
            Xd.putExtra("enter_chat_usrname", b.ftN().FQv);
            PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), 100, Xd, 268435456);
            s.c g2 = a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(this.FPI).i(0).f(bC).g(string);
            g2.Hv = activity;
            this.kYy = g2.build();
            this.kYy.icon = R.drawable.bow;
            this.kYy.flags = 32;
            bg.getNotification().a(100, this.kYy, false);
            AppMethodBeat.o(29454);
        }
    }

    public static void ftU() {
        AppMethodBeat.i(29455);
        Log.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
        bg.getNotification().cancel(100);
        AppMethodBeat.o(29455);
    }

    @Override // com.tencent.mm.bh.d
    public final void bgB() {
        AppMethodBeat.i(29450);
        Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        ftU();
        AppMethodBeat.o(29450);
    }
}
