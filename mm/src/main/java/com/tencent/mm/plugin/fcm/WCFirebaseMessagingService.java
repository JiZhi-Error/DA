package com.tencent.mm.plugin.fcm;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WCFirebaseMessagingService extends FirebaseMessagingService {
    static List<Pair<Long, Long>> tnI = new LinkedList();
    private WakerLock wakerlock;

    static {
        AppMethodBeat.i(127596);
        AppMethodBeat.o(127596);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void onDeletedMessages() {
        AppMethodBeat.i(127592);
        super.onDeletedMessages();
        Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "Deleted messages on server.");
        h.INSTANCE.kvStat(11250, "1,1");
        e.INSTANCE.idkeyStat(901, 31, 1, false);
        AppMethodBeat.o(127592);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void a(String str, Exception exc) {
        AppMethodBeat.i(127593);
        super.a(str, exc);
        h.INSTANCE.kvStat(11250, "1,1");
        e.INSTANCE.idkeyStat(901, 30, 1, false);
        AppMethodBeat.o(127593);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void a(RemoteMessage remoteMessage) {
        boolean z;
        AppMethodBeat.i(127594);
        Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "on message received");
        b cXf = b.cXf();
        if (cXf == null) {
            Log.w("MicroMsg.FCM.WCFirebaseMessagingService", "fcmRegister is null");
            e.INSTANCE.idkeyStat(901, 26, 1, false);
            AppMethodBeat.o(127594);
        } else if (!cXf.cXj()) {
            Log.w("MicroMsg.FCM.WCFirebaseMessagingService", "fcm push not reg to server.");
            e.INSTANCE.idkeyStat(901, 25, 1, false);
            AppMethodBeat.o(127594);
        } else {
            try {
                Context context = MMApplicationContext.getContext();
                if (l.cK(context)) {
                    Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "Logout or exit MM. no need show Notification.");
                    h.INSTANCE.kvStat(11250, "1,2");
                    e.INSTANCE.idkeyStat(901, 28, 1, false);
                    AppMethodBeat.o(127594);
                    return;
                }
                Map<String, String> yA = remoteMessage.yA();
                if (yA.isEmpty()) {
                    Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "msg data is empty: ");
                    h.INSTANCE.kvStat(11250, "1,0");
                    e.INSTANCE.idkeyStat(901, 29, 1, false);
                    AppMethodBeat.o(127594);
                    return;
                }
                String str = yA.get("seq");
                String str2 = yA.get(OpenSDKTool4Assistant.EXTRA_UIN);
                String str3 = yA.get("cmd");
                String str4 = yA.get(ch.COL_USERNAME);
                String str5 = yA.get("time");
                String str6 = yA.get("collapse_key");
                String str7 = yA.get("sound");
                String str8 = yA.get("alert");
                String str9 = yA.get("msgType");
                String str10 = yA.get("badge");
                String str11 = yA.get("from");
                e.INSTANCE.idkeyStat(901, 32, 1, false);
                Object[] objArr = new Object[11];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = str3;
                objArr[3] = Util.secPrint(str4);
                objArr[4] = str5;
                objArr[5] = str6;
                objArr[6] = str7;
                objArr[7] = Integer.valueOf(str8 == null ? -1 : str8.length());
                objArr[8] = str9;
                objArr[9] = str10;
                objArr[10] = str11;
                Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "Received gcm msg. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]", objArr);
                long j2 = Util.isNullOrNil(str2) ? 0 : Util.getLong(str2, 0);
                long j3 = Util.isNullOrNil(str) ? 0 : Util.getLong(str, 0);
                long j4 = Util.isNullOrNil(str3) ? 0 : Util.getLong(str3, 0);
                int azs = a.azs();
                if (j2 == 0 || !Integer.toHexString(azs).equals(Long.toHexString(j2))) {
                    Log.e("MicroMsg.FCM.WCFirebaseMessagingService", "Logined user changed. no need show Notification.uin:" + j2 + ", oldUin:" + azs);
                    h.INSTANCE.kvStat(11250, "1,3");
                    e.INSTANCE.idkeyStat(901, j2 == 0 ? 33 : 34, 1, false);
                    AppMethodBeat.o(127594);
                    return;
                }
                Iterator<Pair<Long, Long>> it = tnI.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Pair<Long, Long> next = it.next();
                    if (((Long) next.first).longValue() == j4 && ((Long) next.second).longValue() == j3) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    Log.w("MicroMsg.FCM.WCFirebaseMessagingService", "already has this seq:".concat(String.valueOf(j3)));
                    e.INSTANCE.idkeyStat(901, 35, 1, false);
                    AppMethodBeat.o(127594);
                    return;
                }
                tnI.add(Pair.create(Long.valueOf(j4), Long.valueOf(j3)));
                if (tnI.size() > 60) {
                    tnI.remove(0);
                }
                if (this.wakerlock == null) {
                    this.wakerlock = new WakerLock(context, "MicroMsg.FCM.WCFirebaseMessagingService");
                    Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "start new wakerlock");
                }
                this.wakerlock.lock(200, "FcmBroadcastReceiver.onReceive");
                Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "summerauths tryDoSync");
                Intent intent = new Intent(MMApplicationContext.getContext(), NotifyReceiver.NotifyService.class);
                intent.putExtra("notify_option_type", 2);
                intent.putExtra("notify_uin", a.azs());
                intent.putExtra("notify_respType", 2147480001);
                intent.putExtra("notify_respBuf", new byte[0]);
                intent.putExtra("notfiy_recv_time", Util.nowMilliSecond());
                g.aAi();
                intent.putExtra("notify_skey", g.aAg().qe(1));
                c.startService(intent);
                Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "summerauths tryDoSync end!");
                AppMethodBeat.o(127594);
            } catch (Exception e2) {
                Log.e("MicroMsg.FCM.WCFirebaseMessagingService", "onMessageReceived error :".concat(String.valueOf(e2.toString())));
                Log.printErrStackTrace("MicroMsg.FCM.WCFirebaseMessagingService", e2, "", new Object[0]);
                e.INSTANCE.idkeyStat(901, 36, 1, false);
                AppMethodBeat.o(127594);
            }
        }
    }

    public static void cXl() {
        AppMethodBeat.i(127595);
        tnI.clear();
        AppMethodBeat.o(127595);
    }
}
