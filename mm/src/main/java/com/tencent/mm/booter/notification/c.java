package com.tencent.mm.booter.notification;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.s;
import android.support.v4.app.v;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.g;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.base.stub.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.h;
import com.tencent.mm.ui.e;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.List;
import java.util.Map;

public final class c implements ax, ba {
    Context context = null;
    ca dTX;
    Intent gnA;
    private boolean gnB;
    private boolean gnC;
    private long gnD;
    g gnE = g.a.ali();
    private e gnF;
    @SuppressLint({"HandlerLeak"})
    MMHandler gnG = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.booter.notification.c.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(19926);
            super.handleMessage(message);
            String string = message.getData().getString("notification.show.talker");
            String string2 = message.getData().getString("notification.show.message.content");
            int i2 = message.getData().getInt("notification.show.message.type");
            int i3 = message.getData().getInt("notification.show.tipsflag");
            Log.i("MicroMsg.MMNotification", "notify need to deal: %s", string);
            try {
                if (message.what == 1) {
                    c.a(c.this, string, string2, i2, i3, true);
                    AppMethodBeat.o(19926);
                    return;
                }
                c.a(c.this, string, string2, i2, i3, false);
                AppMethodBeat.o(19926);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMNotification", e2, "showNotifiHandler", new Object[0]);
                AppMethodBeat.o(19926);
            }
        }
    };
    private final IListener gnH = new IListener<sw>() {
        /* class com.tencent.mm.booter.notification.c.AnonymousClass2 */

        {
            AppMethodBeat.i(161272);
            this.__eventId = sw.class.getName().hashCode();
            AppMethodBeat.o(161272);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sw swVar) {
            ca caVar;
            AppMethodBeat.i(19927);
            sw swVar2 = swVar;
            if (!(swVar2 == null || !(swVar2 instanceof sw) || (caVar = swVar2.dZp.dTX) == null)) {
                c cVar = c.this;
                if (caVar.field_isSend == 1) {
                    Log.w("MicroMsg.MMNotification", "notifyRevorkMessage is sender , msgid:%d ", Long.valueOf(caVar.field_msgSvrId));
                } else {
                    int b2 = c.b(caVar);
                    String str = caVar.field_content;
                    int type = caVar.getType();
                    if (!g.a(caVar.field_talker, caVar, b2, true)) {
                        Log.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                    } else {
                        cVar.dTX = caVar;
                        cVar.talker = caVar.field_talker;
                        cVar.gnz = "";
                        cVar.gnA = null;
                        Log.i("MicroMsg.MMNotification", "notifyRevorkMessage talker:%s msgid:%d type:%d tipsFlag:%d content:%s", cVar.talker, Long.valueOf(caVar.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(b2), Util.secPrint(str));
                        cVar.gnG.sendMessageDelayed(c.a(cVar.talker, str, type, b2, 1), 200);
                    }
                }
            }
            AppMethodBeat.o(19927);
            return false;
        }
    };
    private final IListener gnI = new IListener<ty>() {
        /* class com.tencent.mm.booter.notification.c.AnonymousClass3 */

        {
            AppMethodBeat.i(161273);
            this.__eventId = ty.class.getName().hashCode();
            AppMethodBeat.o(161273);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ty tyVar) {
            AppMethodBeat.i(19929);
            boolean a2 = a(tyVar);
            AppMethodBeat.o(19929);
            return a2;
        }

        private boolean a(ty tyVar) {
            AppMethodBeat.i(19928);
            if (tyVar != null && (tyVar instanceof ty)) {
                String str = tyVar.eas.dYs;
                int i2 = tyVar.eas.msgType;
                c cVar = c.this;
                try {
                    Log.w("showSendMsgFailNotification fromUserName:%s msgType:%d", str, Integer.valueOf(i2));
                    if (!ChattingUI.class.getName().equals(((ActivityManager) cVar.context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(1).get(0).topActivity.getClassName())) {
                        Intent intent = new Intent(cVar.context, ChattingUI.class);
                        intent.putExtra("nofification_type", "pushcontent_notification");
                        intent.putExtra("Intro_Is_Muti_Talker", true);
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("MainUI_User_Last_Msg_Type", i2);
                        intent.addFlags(536870912);
                        intent.addFlags(67108864);
                        PendingIntent activity = PendingIntent.getActivity(cVar.context, 35, intent, 1073741824);
                        s.c g2 = a.cd(cVar.context, a.glE()).i((CharSequence) null).i(System.currentTimeMillis()).f(cVar.context.getString(R.string.y7)).g(cVar.context.getString(R.string.f0c));
                        g2.Hv = activity;
                        Notification build = g2.build();
                        build.icon = a.ezb();
                        build.defaults |= 1;
                        build.flags |= 16;
                        cVar.a(35, build, true);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.MMNotification", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(19928);
            return false;
        }
    };
    private boolean gnJ = false;
    private String gnx;
    private String gny;
    String gnz;
    String talker;

    public c(Context context2) {
        AppMethodBeat.i(19930);
        this.context = context2;
        this.talker = "";
        this.gnz = "";
        this.gnx = "";
        this.gnD = 0;
        this.gnC = false;
        this.gnA = null;
        this.gnF = new e();
        com.tencent.mm.plugin.notification.e.a(this);
        com.tencent.mm.modelvoice.e.a(this);
        b.a(this);
        EventCenter.instance.addListener(this.gnI);
        EventCenter.instance.addListener(this.gnH);
        AppMethodBeat.o(19930);
    }

    @Override // com.tencent.mm.model.ax
    public final void CY(String str) {
        this.gnx = str;
    }

    @Override // com.tencent.mm.model.ax
    public final String ala() {
        return this.gnx;
    }

    @Override // com.tencent.mm.model.ax
    public final void dh(boolean z) {
        AppMethodBeat.i(19931);
        this.gnB = z;
        Log.i("MicroMsg.MMNotification", "set hideNotification: %s, stack[%s]", Boolean.valueOf(this.gnB), Util.getStack());
        AppMethodBeat.o(19931);
    }

    @Override // com.tencent.mm.model.ax
    public final void di(boolean z) {
        this.gnJ = z;
    }

    @Override // com.tencent.mm.model.ax
    public final void cancelNotification(String str) {
        AppMethodBeat.i(19932);
        Log.v("MicroMsg.MMNotification", "cancel notification talker:" + str + " last talker:" + this.gny + "  curChattingTalker:" + this.gnx);
        if (!this.gnC) {
            AppMethodBeat.o(19932);
            return;
        }
        bg.aVF();
        az bjY = com.tencent.mm.model.c.aST().bjY(str);
        if (bjY != null && bjY.field_unReadCount != 0) {
            cancel();
            AppMethodBeat.o(19932);
        } else if (h.gVB() == 0) {
            cancel();
            AppMethodBeat.o(19932);
        } else {
            AppMethodBeat.o(19932);
        }
    }

    @Override // com.tencent.mm.model.ax
    public final void alb() {
        AppMethodBeat.i(19933);
        try {
            String string = MMApplicationContext.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
            if (string != null) {
                String[] split = string.split(",");
                for (String str : split) {
                    int safeParseInt = Util.safeParseInt(str);
                    if (safeParseInt > 0) {
                        bg.getNotification().cancel(safeParseInt);
                    }
                }
            }
            AppMethodBeat.o(19933);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMNotification", e2, "try cancel notification fail: %s", e2.getMessage());
            AppMethodBeat.o(19933);
        }
    }

    @Override // com.tencent.mm.model.ax
    public final void Xc() {
        AppMethodBeat.i(19934);
        Log.d("MicroMsg.MMNotification", "force cancelNotification");
        cancel();
        AppMethodBeat.o(19934);
    }

    private void cancel() {
        AppMethodBeat.i(19935);
        this.gnC = false;
        f.cancel();
        AppMethodBeat.o(19935);
    }

    @Override // com.tencent.mm.model.ba
    public final void a(ca caVar) {
        AppMethodBeat.i(19936);
        if (caVar == null) {
            AppMethodBeat.o(19936);
        } else if (caVar.field_isSend == 1) {
            Log.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", Long.valueOf(caVar.field_msgSvrId));
            AppMethodBeat.o(19936);
        } else {
            bp.b Ky = bp.Ky(caVar.fqK);
            if (Ky == null || Ky.scene != 1) {
                int b2 = b(caVar);
                this.dTX = caVar;
                this.talker = caVar.field_talker;
                String str = caVar.field_content;
                int type = caVar.getType();
                this.gnz = "";
                this.gnA = null;
                Log.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", this.talker, Long.valueOf(caVar.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(b2), Util.secPrint(str));
                if (!g.a(this.talker, this.dTX, b2, false)) {
                    Log.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                    AppMethodBeat.o(19936);
                    return;
                }
                this.gnG.sendMessageDelayed(a(this.talker, str, type, b2, 0), 200);
                AppMethodBeat.o(19936);
                return;
            }
            AppMethodBeat.o(19936);
        }
    }

    static Message a(String str, String str2, int i2, int i3, int i4) {
        AppMethodBeat.i(19937);
        Log.d("MicroMsg.MMNotification", "[wrapMessage] talker:%s msgType:%s stack:%s", str, Integer.valueOf(i2), Util.getStack().toString());
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("notification.show.talker", str);
        bundle.putString("notification.show.message.content", str2);
        bundle.putInt("notification.show.message.type", i2);
        bundle.putInt("notification.show.tipsflag", i3);
        obtain.setData(bundle);
        obtain.what = i4;
        AppMethodBeat.o(19937);
        return obtain;
    }

    @Override // com.tencent.mm.model.ba
    public final Looper getLooper() {
        AppMethodBeat.i(19938);
        Looper mainLooper = Looper.getMainLooper();
        AppMethodBeat.o(19938);
        return mainLooper;
    }

    @Override // com.tencent.mm.model.ba
    public final void S(List<ca> list) {
        int i2;
        ca caVar = null;
        AppMethodBeat.i(19939);
        if (list == null || list.size() <= 0) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(list == null ? -1 : list.size());
            objArr[1] = Util.getStack();
            Log.w("MicroMsg.MMNotification", "notifyOther newMsgList:%d :%s", objArr);
            AppMethodBeat.o(19939);
            return;
        }
        int size = list.size() - 1;
        int i3 = 0;
        while (true) {
            if (size < 0) {
                i2 = i3;
                break;
            }
            ca caVar2 = list.get(size);
            i2 = b(caVar2);
            if (g.a(caVar2.field_talker, caVar2, i2, false)) {
                caVar = caVar2;
                break;
            } else {
                size--;
                i3 = i2;
            }
        }
        if (caVar == null) {
            Log.w("MicroMsg.MMNotification", "notifyOther msg == null");
            AppMethodBeat.o(19939);
            return;
        }
        this.gnz = "";
        this.talker = caVar.field_talker;
        String str = caVar.field_content;
        int type = caVar.getType();
        this.dTX = caVar;
        Log.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", this.talker, Long.valueOf(caVar.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(i2), Util.secPrint(str));
        this.gnG.sendMessageDelayed(a(this.talker, str, type, i2, 0), 200);
        AppMethodBeat.o(19939);
    }

    @Override // com.tencent.mm.model.ax
    public final void nR(int i2) {
        AppMethodBeat.i(19944);
        e.nU(i2);
        AppMethodBeat.o(19944);
    }

    @Override // com.tencent.mm.model.ax
    public final void C(String str, int i2) {
        AppMethodBeat.i(19945);
        e.D(str, i2);
        AppMethodBeat.o(19945);
    }

    @Override // com.tencent.mm.model.ax
    public final void dj(boolean z) {
        AppMethodBeat.i(19946);
        e.dk(z);
        AppMethodBeat.o(19946);
    }

    @Override // com.tencent.mm.model.az, com.tencent.mm.model.ax
    public final void notify(int i2, Notification notification) {
        AppMethodBeat.i(19948);
        a(i2, notification, true);
        AppMethodBeat.o(19948);
    }

    @Override // com.tencent.mm.model.ax
    public final int c(Notification notification) {
        AppMethodBeat.i(19951);
        int a2 = a(notification, true);
        AppMethodBeat.o(19951);
        return a2;
    }

    @Override // com.tencent.mm.model.ax
    public final Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.i(19953);
        Notification a2 = a(null, -1, 0, pendingIntent, str, str2, str3, bitmap, str4);
        AppMethodBeat.o(19953);
        return a2;
    }

    @Override // com.tencent.mm.model.ba
    public final void a(int i2, String str, String str2, String str3, String str4, Bundle bundle) {
        AppMethodBeat.i(19940);
        w.AnonymousClass1 r0 = new com.tencent.mm.br.a(str3, str4, bundle, str, str2, i2) {
            /* class com.tencent.mm.platformtools.w.AnonymousClass1 */
            final /* synthetic */ Bundle doj;
            final /* synthetic */ String dqb;
            final /* synthetic */ int jNA;
            final /* synthetic */ String jNz;
            final /* synthetic */ String val$content;
            final /* synthetic */ String val$jumpUrl;

            {
                this.val$jumpUrl = r1;
                this.jNz = r2;
                this.doj = r3;
                this.dqb = r4;
                this.val$content = r5;
                this.jNA = r6;
            }

            @Override // com.tencent.mm.br.a
            public final void onDone() {
                Uri parse;
                AppMethodBeat.i(20713);
                Time time = new Time();
                time.setToNow();
                int i2 = time.hour;
                int i3 = time.minute;
                MMApplicationContext.getContext();
                if (!com.tencent.mm.n.b.ct(i2, i3)) {
                    Log.i("MiroMsg.NotificationUtil", "no shake & sound notification during background deactive time");
                } else {
                    try {
                        Context context = MMApplicationContext.getContext();
                        boolean apV = com.tencent.mm.n.g.apV();
                        boolean apR = com.tencent.mm.n.g.apR();
                        Log.d("MiroMsg.NotificationUtil", "shake " + apV + "sound " + apR);
                        if (apV) {
                            Log.i("MiroMsg.NotificationUtil", "notification.shake:  notifyEngageRemind isShake~: true");
                            Util.shake(context, true);
                        }
                        if (apR) {
                            String apX = com.tencent.mm.n.g.apX();
                            if (apX == e.l.gLX) {
                                parse = RingtoneManager.getDefaultUri(2);
                            } else {
                                parse = Uri.parse(apX);
                            }
                            k kVar = new k();
                            try {
                                kVar.setDataSource(context, parse);
                                kVar.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    /* class com.tencent.mm.platformtools.w.AnonymousClass3 */

                                    public final void onCompletion(MediaPlayer mediaPlayer) {
                                        AppMethodBeat.i(20715);
                                        try {
                                            mediaPlayer.release();
                                            AppMethodBeat.o(20715);
                                        } catch (Exception e2) {
                                            Log.printErrStackTrace("MiroMsg.NotificationUtil", e2, "", new Object[0]);
                                            AppMethodBeat.o(20715);
                                        }
                                    }
                                });
                                if (com.tencent.mm.plugin.audio.c.a.getStreamVolume(5) != 0) {
                                    if (com.tencent.mm.plugin.audio.c.a.cdW()) {
                                        int streamVolume = com.tencent.mm.plugin.audio.c.a.getStreamVolume(8);
                                        int streamMaxVolume = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(8);
                                        int streamVolume2 = com.tencent.mm.plugin.audio.c.a.getStreamVolume(5);
                                        if (streamVolume2 <= streamMaxVolume) {
                                            streamMaxVolume = streamVolume2;
                                        }
                                        com.tencent.mm.plugin.audio.c.a.eQ(8, streamMaxVolume);
                                        kVar.setAudioStreamType(8);
                                        kVar.setLooping(true);
                                        kVar.prepare();
                                        kVar.setLooping(false);
                                        kVar.start();
                                        com.tencent.mm.plugin.audio.c.a.eQ(8, streamVolume);
                                        Log.d("MiroMsg.NotificationUtil", "oldVolume is %d, toneVolume is %d", Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
                                    } else {
                                        kVar.setAudioStreamType(5);
                                        kVar.setLooping(true);
                                        kVar.prepare();
                                        kVar.setLooping(false);
                                        kVar.start();
                                    }
                                }
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MiroMsg.NotificationUtil", e2, "", new Object[0]);
                            }
                        }
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MiroMsg.NotificationUtil", e3, "", new Object[0]);
                    }
                }
                Intent intent = new Intent();
                intent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
                intent.putExtra("rawUrl", this.val$jumpUrl);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                intent.setFlags(872415232);
                Log.d("MiroMsg.NotificationUtil", "bizFrom: %s, data: %s", this.jNz, this.doj);
                if (!(this.jNz == null || this.doj == null)) {
                    intent.putExtra("bizofstartfrom", this.jNz);
                    intent.putExtra("startwebviewparams", this.doj);
                }
                PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, intent, 134217728);
                s.c g2 = a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i((CharSequence) null).i(System.currentTimeMillis()).f(this.dqb).g(this.val$content);
                g2.Hv = activity;
                Notification build = g2.build();
                build.icon = a.ezb();
                build.flags |= 16;
                ((NotificationManager) MMApplicationContext.getContext().getSystemService("notification")).notify(this.jNA, build);
                AppMethodBeat.o(20713);
            }
        };
        new Object() {
            /* class com.tencent.mm.platformtools.w.AnonymousClass2 */
        };
        com.tencent.mm.br.c.a("webview", r0);
        AppMethodBeat.o(19940);
    }

    @Override // com.tencent.mm.model.ax
    public final Notification a(Notification notification, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4, PendingIntent pendingIntent2, String str5, PendingIntent pendingIntent3, String str6) {
        AppMethodBeat.i(19941);
        Notification a2 = g.a.ali().gok.goc.a(notification, i2, 1, pendingIntent, str, str2, str3, bitmap, R.drawable.cj_, str4, pendingIntent2, R.drawable.cj9, str5, pendingIntent3, str6);
        AppMethodBeat.o(19941);
        return a2;
    }

    @Override // com.tencent.mm.model.ax
    public final void r(int i2, String str) {
        AppMethodBeat.i(19942);
        g.a.ali();
        f.r(i2, str);
        AppMethodBeat.o(19942);
    }

    @Override // com.tencent.mm.model.ax
    public final void alc() {
        AppMethodBeat.i(19943);
        g.a.ali();
        d.alc();
        AppMethodBeat.o(19943);
    }

    @Override // com.tencent.mm.model.ax
    public final void nS(int i2) {
        AppMethodBeat.i(19947);
        g.a.ali();
        if (i2 != 0) {
            List<Integer> nV = com.tencent.mm.booter.notification.queue.b.alj().gor.nV(i2);
            if (nV.isEmpty()) {
                AppMethodBeat.o(19947);
                return;
            }
            v P = v.P(MMApplicationContext.getContext());
            for (Integer num : nV) {
                com.tencent.mm.booter.notification.queue.b.alj().a(P, num.intValue());
            }
        }
        AppMethodBeat.o(19947);
    }

    @Override // com.tencent.mm.model.ax
    public final void a(int i2, Notification notification, boolean z) {
        AppMethodBeat.i(19949);
        g.a.ali().b(new NotificationItem(i2, notification, z));
        AppMethodBeat.o(19949);
    }

    @Override // com.tencent.mm.model.ax
    public final int a(Notification notification, boolean z) {
        AppMethodBeat.i(19950);
        int b2 = g.a.ali().b(new NotificationItem(notification, z));
        AppMethodBeat.o(19950);
        return b2;
    }

    @Override // com.tencent.mm.model.az, com.tencent.mm.model.ax
    public final void cancel(int i2) {
        AppMethodBeat.i(19952);
        g.a.ali();
        com.tencent.mm.booter.notification.queue.b.alj().cancel(i2);
        AppMethodBeat.o(19952);
    }

    @Override // com.tencent.mm.model.ax
    public final Notification a(Notification notification, int i2, int i3, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.i(19954);
        Notification a2 = g.a.ali().a(notification, i2, i3, pendingIntent, str, str2, str3, bitmap, str4);
        AppMethodBeat.o(19954);
        return a2;
    }

    static int b(ca caVar) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(19955);
        if (ab.IT(caVar.field_talker)) {
            i2 = 0;
        } else {
            i2 = 3;
        }
        if (caVar.field_bizChatId != -1 && com.tencent.mm.al.g.DQ(caVar.field_talker)) {
            com.tencent.mm.al.a.c bs = ag.baj().bs(caVar.field_bizChatId);
            if (!bs.isGroup() && bs.iE(1)) {
                AppMethodBeat.o(19955);
                return i2;
            }
        }
        String str = caVar.fqK;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(19955);
            return i2;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "msgsource", null);
        if (parseXml == null || parseXml.isEmpty()) {
            AppMethodBeat.o(19955);
            return i2;
        }
        try {
            int i4 = Util.getInt(parseXml.get(".msgsource.tips"), i2);
            if ((i4 & 1) != 0 || (i4 & 2) == 0) {
                i3 = i4;
            }
            AppMethodBeat.o(19955);
            return i3;
        } catch (Exception e2) {
            AppMethodBeat.o(19955);
            return i2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:222:0x06b8  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x06bd  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x06c6  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0877  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0973  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0976  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.booter.notification.c r27, java.lang.String r28, java.lang.String r29, int r30, int r31, boolean r32) {
        /*
        // Method dump skipped, instructions count: 2609
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.notification.c.a(com.tencent.mm.booter.notification.c, java.lang.String, java.lang.String, int, int, boolean):void");
    }
}
