package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import com.tencent.f.h;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.i;
import com.tencent.mm.b.o;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.network.af;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMService;
import com.tencent.mm.service.ProcessService;
import com.tencent.mm.service.c;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyReceiver extends BroadcastReceiver {
    private static WakerLock glE = null;
    private static Set<Long> glF = new HashSet();
    private static Lock glG = new ReentrantLock(false);
    private static byte[] glH = new byte[0];
    private static byte[] glI = new byte[0];
    private static a glJ;
    private static boolean glK = true;
    private static final long[] glL = {0, 1, 2, 4, 6, 8, 10, 20, 50, 100, 200, 500, 1000, 2000, 3000, 4000, 5000, 7000, 10000, 20000, 30000};
    private static final int[] glM = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    private static final int[] glN = {30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
    private static WakerLock gll = null;

    static /* synthetic */ void a(Context context, Intent intent, ArrayList arrayList) {
        AppMethodBeat.i(131926);
        a(context, intent, false, arrayList);
        AppMethodBeat.o(131926);
    }

    static {
        AppMethodBeat.i(131927);
        AppMethodBeat.o(131927);
    }

    public static void akD() {
        AppMethodBeat.i(131921);
        akE();
        AppMethodBeat.o(131921);
    }

    public static void akE() {
        AppMethodBeat.i(131922);
        Log.i("MicroMsg.NotifyReceiver", "quitLightPushMode");
        glK = false;
        af.bke().edit().putBoolean("is_in_notify_mode", false).commit();
        AppMethodBeat.o(131922);
    }

    public static void akF() {
        AppMethodBeat.i(131923);
        g.azz().b(138, glJ);
        g.azz().b(39, glJ);
        g.azz().b(268369922, glJ);
        if (glJ == null) {
            glJ = new a();
        }
        g.azz().a(138, glJ);
        g.azz().a(39, glJ);
        g.azz().a(268369922, glJ);
        AppMethodBeat.o(131923);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(131924);
        Log.i("MicroMsg.NotifyReceiver", "onReceive intent :%s", intent);
        final ArrayList arrayList = new ArrayList();
        a(context, intent, true, arrayList);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.booter.NotifyReceiver.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(196981);
                IDKey iDKey = new IDKey();
                iDKey.SetID(1042);
                iDKey.SetKey(61);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
                e.INSTANCE.b(arrayList, false);
                AppMethodBeat.o(196981);
            }
        }, "MicroMsg.NotifyReceiver");
        AppMethodBeat.o(131924);
    }

    public static class NotifyReceiverService extends MMService {
        @Override // com.tencent.mm.service.MMService
        public final void onCreate() {
            AppMethodBeat.i(131904);
            super.onCreate();
            Log.i("MicroMsg.NotifyReceiverService", "onCreate()");
            AppMethodBeat.o(131904);
        }

        @Override // com.tencent.mm.service.MMService
        public final int onStartCommand(Intent intent, int i2, int i3) {
            AppMethodBeat.i(131905);
            final ArrayList arrayList = new ArrayList();
            NotifyReceiver.a(MMApplicationContext.getContext(), intent, arrayList);
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.booter.NotifyReceiver.NotifyReceiverService.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(196982);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(1042);
                    iDKey.SetKey(63);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    e.INSTANCE.b(arrayList, false);
                    AppMethodBeat.o(196982);
                }
            }, "MicroMsg.NotifyReceiverService");
            Log.i("MicroMsg.NotifyReceiverService", "onStartCommand()");
            AppMethodBeat.o(131905);
            return 1;
        }

        @Override // com.tencent.mm.service.MMService
        public final void onDestroy() {
            AppMethodBeat.i(131906);
            super.onDestroy();
            AppMethodBeat.o(131906);
        }
    }

    private static void a(Context context, Intent intent, boolean z, ArrayList<IDKey> arrayList) {
        AppMethodBeat.i(131925);
        if (intent == null) {
            AppMethodBeat.o(131925);
        } else if (l.cK(context)) {
            Log.i("MicroMsg.NotifyReceiver", "fully exited, no need to start service");
            AppMethodBeat.o(131925);
        } else {
            long longExtra = intent.getLongExtra("notfiy_recv_time", -1);
            long longExtra2 = intent.getLongExtra("notfiy_sync_num", 0);
            long nowMilliSecond = Util.nowMilliSecond() - longExtra;
            long yK = CoreService.yK(longExtra2);
            if (yK >= 1) {
                MultiProcessMMKV.getMMKV("msg_receive_report").edit().putLong("use_time", nowMilliSecond);
                Intent intent2 = new Intent(context, NotifyService.class);
                if (intent.getBooleanExtra("intent_from_shoot_key", false)) {
                    intent2.putExtra("notify_option_type", 3);
                }
                intent2.putExtras(intent);
                c.a(intent2, "mm", true, new Intent(MMApplicationContext.getContext(), ProcessService.MMProcessService.class));
                com.tencent.mm.ap.a.B(intent.getIntExtra("notify_respType", -1), intent.getLongExtra("notfiy_sync_num", 0));
                Log.i("MicroMsg.NotifyReceiver", "syncNum:%s fromBroadcast:%s diff:%s", Long.valueOf(longExtra2), Boolean.valueOf(z), Long.valueOf(Util.nowMilliSecond() - longExtra));
                AppMethodBeat.o(131925);
            } else if (yK == 0) {
                long j2 = MultiProcessMMKV.getMMKV("msg_receive_report").getLong("use_time", 0);
                long j3 = nowMilliSecond - j2;
                Log.i("MicroMsg.NotifyReceiver", "handleIntent syncNum:%s has handled(result:%s fromBroadcast:%s diff:%s newUseTime:%s oldUseTime:%s)", Long.valueOf(longExtra2), Long.valueOf(yK), Boolean.valueOf(z), Long.valueOf(j3), Long.valueOf(nowMilliSecond), Long.valueOf(j2));
                for (int length = glL.length - 1; length >= 0; length--) {
                    if (j3 > glL[length]) {
                        IDKey iDKey = new IDKey();
                        iDKey.SetID(1042);
                        if (z) {
                            iDKey.SetKey(glN[length]);
                        } else {
                            iDKey.SetKey(glM[length]);
                        }
                        iDKey.SetValue(1);
                        arrayList.add(iDKey);
                        AppMethodBeat.o(131925);
                        return;
                    }
                }
                AppMethodBeat.o(131925);
            } else {
                Log.i("MicroMsg.NotifyReceiver", "handleIntent syncNum:%s has handled(result:%s fromBroadcast:%s useTime:%s)", Long.valueOf(longExtra2), Long.valueOf(yK), Boolean.valueOf(z), Long.valueOf(nowMilliSecond));
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(1042);
                if (z) {
                    iDKey2.SetKey(59);
                } else {
                    iDKey2.SetKey(29);
                }
                iDKey2.SetValue(1);
                arrayList.add(iDKey2);
                AppMethodBeat.o(131925);
            }
        }
    }

    public static class NotifyService extends MMService {
        Boolean glS = null;
        private com.tencent.mm.kernel.api.g glT;

        static /* synthetic */ void a(NotifyService notifyService, Intent intent) {
            AppMethodBeat.i(131920);
            notifyService.p(intent);
            AppMethodBeat.o(131920);
        }

        @Override // com.tencent.mm.service.MMService
        public final void onStart(Intent intent, int i2) {
            AppMethodBeat.i(131909);
            o(intent);
            AppMethodBeat.o(131909);
        }

        @Override // com.tencent.mm.service.MMService
        public final int onStartCommand(Intent intent, int i2, int i3) {
            AppMethodBeat.i(131910);
            Log.i("MicroMsg.NotifyReceiver", "NotifyService onStartCommand flags :" + i2 + "startId :" + i3 + " intent " + intent);
            o(intent);
            AppMethodBeat.o(131910);
            return 2;
        }

        @Override // com.tencent.mm.service.MMService
        public final IBinder akL() {
            return null;
        }

        @Override // com.tencent.mm.service.MMService
        public final String getTag() {
            return "MicroMsg.NotifyReceiver";
        }

        private void o(final Intent intent) {
            char c2;
            AppMethodBeat.i(131911);
            if (intent == null) {
                Log.e("MicroMsg.NotifyReceiver", "receiveImp receiveIntent == null");
                AppMethodBeat.o(131911);
                return;
            }
            if (!g.aAi().hrh.hrB) {
                Log.e("MicroMsg.NotifyReceiver", "summerboot WorkerProfile not has create, status %d", 0);
                if (this.glT != null) {
                    g.aAi().b(this.glT);
                }
                final long currentTimeMillis = System.currentTimeMillis();
                this.glT = new com.tencent.mm.kernel.api.g() {
                    /* class com.tencent.mm.booter.NotifyReceiver.NotifyService.AnonymousClass1 */

                    @Override // com.tencent.mm.kernel.api.g
                    public final void WY() {
                        AppMethodBeat.i(131908);
                        g.aAi().b(this);
                        NotifyService.this.glT = null;
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        Log.i("MicroMsg.NotifyReceiver", "summerboot startupDone[%b] take[%d]ms tid[%d] post last notify task", Boolean.valueOf(g.aAi().hrh.hrB), Long.valueOf(currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
                        e.INSTANCE.a(11098, Integer.valueOf((int) LocalCache.TIME_HOUR), Long.valueOf(currentTimeMillis));
                        e.INSTANCE.idkeyStat(99, 214, 1, false);
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.booter.NotifyReceiver.NotifyService.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(131907);
                                Log.i("MicroMsg.NotifyReceiver", "summerboot startupDone do delay notify task");
                                NotifyService.a(NotifyService.this, intent);
                                e.INSTANCE.idkeyStat(99, 215, 1, false);
                                AppMethodBeat.o(131907);
                            }
                        }, 500);
                        AppMethodBeat.o(131908);
                    }

                    @Override // com.tencent.mm.kernel.api.g
                    public final void cQ(boolean z) {
                    }
                };
                g.aAi().a(this.glT);
                e.INSTANCE.idkeyStat(99, 213, 1, false);
                c2 = 65535;
            } else {
                c2 = 0;
            }
            if (c2 < 0) {
                Log.e("MicroMsg.NotifyReceiver", "summerboot status %s", -1);
                AppMethodBeat.o(131911);
                return;
            }
            p(intent);
            AppMethodBeat.o(131911);
        }

        private void p(Intent intent) {
            NotifyService notifyService;
            boolean z;
            AppMethodBeat.i(131912);
            int intExtra = intent.getIntExtra("notify_option_type", 0);
            if (intExtra == 0) {
                Log.e("MicroMsg.NotifyReceiver", "receiveImp invalid opcode.");
                AppMethodBeat.o(131912);
            } else if (!g.aAc() || com.tencent.mm.kernel.a.azj()) {
                Log.e("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:%b  isHold:%b  opcode:%d", Boolean.valueOf(g.aAc()), Boolean.valueOf(com.tencent.mm.kernel.a.azj()), Integer.valueOf(intExtra));
                AppMethodBeat.o(131912);
            } else {
                if (g.azz().iMw == null) {
                    Log.w("MicroMsg.NotifyReceiver", "receiveImp  opcode:%d  getDispatcher == null", Integer.valueOf(intExtra));
                    g.azz().fx(true);
                }
                if (this.glS == null) {
                    if (CrashReportFactory.hasDebuger()) {
                        notifyService = this;
                    } else {
                        int i2 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("AndroidOldNotifyReceiver"), 0);
                        g.aAi();
                        g.aAf();
                        if (i2 > i.ch(com.tencent.mm.kernel.a.getUin(), 100)) {
                            z = true;
                            notifyService = this;
                            notifyService.glS = Boolean.valueOf(z);
                        } else {
                            notifyService = this;
                        }
                    }
                    z = false;
                    notifyService.glS = Boolean.valueOf(z);
                }
                Log.i("MicroMsg.NotifyReceiver", "handleCommand useOld:%s operationCode:%d", this.glS, Integer.valueOf(intExtra));
                switch (intExtra) {
                    case 1:
                        if (this.glS.booleanValue()) {
                            x(MMApplicationContext.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NETWORK_AVAILABLE");
                        }
                        cl(MMApplicationContext.getContext());
                        AppMethodBeat.o(131912);
                        return;
                    case 2:
                        if (this.glS.booleanValue()) {
                            x(MMApplicationContext.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NOTIFY");
                            r(intent);
                            AppMethodBeat.o(131912);
                            return;
                        }
                        q(intent);
                        AppMethodBeat.o(131912);
                        return;
                    default:
                        Log.e("MicroMsg.NotifyReceiver", "invald opCode:".concat(String.valueOf(intExtra)));
                        AppMethodBeat.o(131912);
                        return;
                }
            }
        }

        @Override // com.tencent.mm.service.MMService
        public final void onCreate() {
            AppMethodBeat.i(131913);
            super.onCreate();
            AppMethodBeat.o(131913);
        }

        public static void CP(String str) {
            AppMethodBeat.i(131914);
            synchronized (NotifyReceiver.glH) {
                try {
                    if (NotifyReceiver.gll == null) {
                        WakerLock unused = NotifyReceiver.gll = new WakerLock(MMApplicationContext.getContext(), "MicroMsg.NotifyReceiver");
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(131914);
                    throw th;
                }
            }
            NotifyReceiver.gll.lock(5000, str);
            AppMethodBeat.o(131914);
        }

        private static void x(Context context, String str) {
            AppMethodBeat.i(131915);
            synchronized (NotifyReceiver.glH) {
                try {
                    if (NotifyReceiver.gll == null) {
                        WakerLock unused = NotifyReceiver.gll = new WakerLock(context, "MicroMsg.NotifyReceiver");
                    }
                    NotifyReceiver.gll.lock(14000, str);
                } finally {
                    AppMethodBeat.o(131915);
                }
            }
        }

        private static void y(Context context, String str) {
            AppMethodBeat.i(131916);
            synchronized (NotifyReceiver.glI) {
                try {
                    if (NotifyReceiver.glE == null) {
                        WakerLock unused = NotifyReceiver.glE = new WakerLock(context, "MicroMsg.NotifyReceiver");
                    }
                    NotifyReceiver.glE.lock(Util.MILLSECONDS_OF_MINUTE, str);
                } finally {
                    AppMethodBeat.o(131916);
                }
            }
        }

        private void q(Intent intent) {
            int v;
            AppMethodBeat.i(131917);
            int intExtra = intent.getIntExtra("notify_respType", 0);
            byte[] byteArrayExtra = intent.getByteArrayExtra("notify_respBuf");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("notify_skey");
            long longExtra = intent.getLongExtra("notfiy_recv_time", -1);
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(intExtra);
            objArr[1] = Long.valueOf(longExtra);
            objArr[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
            objArr[3] = Integer.valueOf(byteArrayExtra2 == null ? -1 : byteArrayExtra2.length);
            Log.i("MicroMsg.NotifyReceiver", "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ", objArr);
            if (!Util.isNullOrNil(byteArrayExtra2) || intExtra == 3941) {
                switch (intExtra) {
                    case 39:
                        g.azz().a(new j(), 0);
                        AppMethodBeat.o(131917);
                        return;
                    case 138:
                        if (byteArrayExtra == null) {
                            v = 7;
                        } else {
                            v = o.v(byteArrayExtra, 0);
                        }
                        int i2 = byteArrayExtra == null ? 2 : 1;
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = Integer.valueOf(v);
                        objArr2[1] = Integer.valueOf(i2);
                        objArr2[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                        Log.i("MicroMsg.NotifyReceiver", "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ", objArr2);
                        ((b) g.af(b.class)).bdS().a((long) v, i2, "");
                        AppMethodBeat.o(131917);
                        return;
                    case 268369921:
                        if (Util.isNullOrNil(byteArrayExtra) || byteArrayExtra.length <= 8) {
                            Log.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
                            AppMethodBeat.o(131917);
                            return;
                        }
                        int v2 = o.v(byteArrayExtra, 0);
                        int v3 = o.v(byteArrayExtra, 4);
                        if (v3 != byteArrayExtra.length - 8) {
                            Log.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + byteArrayExtra.length);
                            AppMethodBeat.o(131917);
                            return;
                        }
                        byte[] bArr = new byte[v3];
                        System.arraycopy(byteArrayExtra, 8, bArr, 0, v3);
                        Log.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", Integer.valueOf(v2), Integer.valueOf(v3), Integer.valueOf(byteArrayExtra.length), Long.valueOf(longExtra));
                        com.tencent.mm.modelmulti.l.b(v2, bArr, byteArrayExtra2, longExtra);
                        AppMethodBeat.o(131917);
                        return;
                    case 1000000205:
                        Log.i("MicroMsg.NotifyReceiver", "oreh on newsynccheck2 notify, notify=" + (byteArrayExtra != null));
                        aa.b bVar = new aa.b();
                        ((b) g.af(b.class)).bdS().a(bVar.KAs, 1, bVar.gtP());
                        AppMethodBeat.o(131917);
                        return;
                    case 2147480001:
                        Log.i("MicroMsg.NotifyReceiver", "dkpush FCM Notify");
                        ((b) g.af(b.class)).bdS().a(7, 16, "");
                        AppMethodBeat.o(131917);
                        return;
                    default:
                        ((PluginZero) g.ah(PluginZero.class)).Vii.a(this, intExtra, byteArrayExtra, byteArrayExtra2, longExtra);
                        AppMethodBeat.o(131917);
                        return;
                }
            } else {
                Log.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session null and ret sessionKey:" + byteArrayExtra2 + " respType:" + intExtra);
                AppMethodBeat.o(131917);
            }
        }

        private void r(Intent intent) {
            int v;
            AppMethodBeat.i(131918);
            int intExtra = intent.getIntExtra("notify_respType", 0);
            byte[] byteArrayExtra = intent.getByteArrayExtra("notify_respBuf");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("notify_skey");
            long longExtra = intent.getLongExtra("notfiy_recv_time", -1);
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(intExtra);
            objArr[1] = Long.valueOf(longExtra);
            objArr[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
            objArr[3] = Util.secPrint(Util.encodeHexString(byteArrayExtra2));
            Log.i("MicroMsg.NotifyReceiver", "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ", objArr);
            switch (intExtra) {
                case 39:
                    g.azz().a(new j(), 0);
                    AppMethodBeat.o(131918);
                    return;
                case 138:
                    if (byteArrayExtra == null) {
                        v = 7;
                    } else {
                        v = o.v(byteArrayExtra, 0);
                    }
                    int i2 = byteArrayExtra == null ? 2 : 1;
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = Integer.valueOf(v);
                    objArr2[1] = Integer.valueOf(i2);
                    objArr2[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                    Log.d("MicroMsg.NotifyReceiver", "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ", objArr2);
                    try {
                        NotifyReceiver.glG.lock();
                        int a2 = ((b) g.af(b.class)).bdS().a((long) v, i2, "");
                        if (a2 > 0) {
                            Log.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", Integer.valueOf(a2));
                            NotifyReceiver.glF.add(Long.valueOf((long) a2));
                            y(MMApplicationContext.getContext(), "NotifyReceiver.dealWithNotify:MMFunc_NewSync");
                        }
                        try {
                            return;
                        } catch (Exception e2) {
                            AppMethodBeat.o(131918);
                            return;
                        }
                    } finally {
                        try {
                            NotifyReceiver.glG.unlock();
                        } catch (Exception e3) {
                        }
                        AppMethodBeat.o(131918);
                    }
                case 268369921:
                    if (Util.isNullOrNil(byteArrayExtra2)) {
                        Log.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session:".concat(String.valueOf(byteArrayExtra2)));
                        AppMethodBeat.o(131918);
                        return;
                    } else if (Util.isNullOrNil(byteArrayExtra) || byteArrayExtra.length <= 8) {
                        Log.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
                        AppMethodBeat.o(131918);
                        return;
                    } else {
                        int v2 = o.v(byteArrayExtra, 0);
                        int v3 = o.v(byteArrayExtra, 4);
                        if (v3 != byteArrayExtra.length - 8) {
                            Log.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + byteArrayExtra.length);
                            AppMethodBeat.o(131918);
                            return;
                        }
                        byte[] bArr = new byte[v3];
                        System.arraycopy(byteArrayExtra, 8, bArr, 0, v3);
                        Log.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", Integer.valueOf(v2), Integer.valueOf(v3), Integer.valueOf(byteArrayExtra.length), Long.valueOf(longExtra));
                        try {
                            NotifyReceiver.glG.lock();
                            com.tencent.mm.modelmulti.l.b(v2, bArr, byteArrayExtra2, longExtra);
                            NotifyReceiver.glF.add(Long.valueOf(longExtra));
                            y(MMApplicationContext.getContext(), "NotifyReceiver.NotifyData");
                            try {
                                return;
                            } catch (Exception e4) {
                                AppMethodBeat.o(131918);
                                return;
                            }
                        } finally {
                            try {
                                NotifyReceiver.glG.unlock();
                            } catch (Exception e5) {
                            }
                            AppMethodBeat.o(131918);
                        }
                    }
                case 1000000205:
                    Log.d("MicroMsg.NotifyReceiver", "oreh on newsynccheck2 notify, notify=" + (byteArrayExtra != null));
                    aa.b bVar = new aa.b();
                    try {
                        bVar.fromProtoBuf(byteArrayExtra);
                        NotifyReceiver.glG.lock();
                        int a3 = ((b) g.af(b.class)).bdS().a(bVar.KAs, 1, bVar.gtP());
                        if (a3 > 0) {
                            Log.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", Integer.valueOf(a3));
                            NotifyReceiver.glF.add(Long.valueOf((long) a3));
                            y(MMApplicationContext.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_NEW_SYNC_CHECK2_RESP");
                        }
                        try {
                            NotifyReceiver.glG.unlock();
                            AppMethodBeat.o(131918);
                            return;
                        } catch (Exception e6) {
                            AppMethodBeat.o(131918);
                            return;
                        }
                    } catch (Exception e7) {
                        Log.printErrStackTrace("MicroMsg.NotifyReceiver", e7, "", new Object[0]);
                        try {
                            NotifyReceiver.glG.unlock();
                            AppMethodBeat.o(131918);
                            return;
                        } catch (Exception e8) {
                            AppMethodBeat.o(131918);
                            return;
                        }
                    } catch (Throwable th) {
                        try {
                            NotifyReceiver.glG.unlock();
                        } catch (Exception e9) {
                        }
                        AppMethodBeat.o(131918);
                        throw th;
                    }
                case 2147480001:
                    Log.d("MicroMsg.NotifyReceiver", "dkpush FCM Notify");
                    int a4 = ((b) g.af(b.class)).bdS().a(7, 16, "");
                    try {
                        NotifyReceiver.glG.lock();
                        if (a4 > 0) {
                            Log.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", Integer.valueOf(a4));
                            NotifyReceiver.glF.add(Long.valueOf((long) a4));
                            y(MMApplicationContext.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_FCM_NOTIFY");
                        }
                        try {
                            return;
                        } catch (Exception e10) {
                            AppMethodBeat.o(131918);
                            return;
                        }
                    } finally {
                        try {
                            NotifyReceiver.glG.unlock();
                        } catch (Exception e11) {
                        }
                        AppMethodBeat.o(131918);
                    }
                default:
                    ((PluginZero) g.ah(PluginZero.class)).Vii.a(this, intExtra, byteArrayExtra, byteArrayExtra2, longExtra);
                    AppMethodBeat.o(131918);
                    return;
            }
        }

        private static void cl(Context context) {
            AppMethodBeat.i(131919);
            Log.i("MicroMsg.NotifyReceiver", "dealWithLooper");
            if (!g.aAc() || com.tencent.mm.kernel.a.azj()) {
                Log.w("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:" + g.aAc() + " isHold:" + com.tencent.mm.kernel.a.azj());
                AppMethodBeat.o(131919);
            } else if (g.azz().foreground || !ag.dl(context)) {
                ((b) g.af(b.class)).bdS().tE(2);
                AppMethodBeat.o(131919);
            } else {
                g.azz().a(new j(), 0);
                AppMethodBeat.o(131919);
            }
        }
    }

    public static class a implements com.tencent.mm.ak.i {
        private static long glP = 0;

        static /* synthetic */ void b(a aVar) {
            AppMethodBeat.i(131903);
            aVar.yL(3000);
            AppMethodBeat.o(131903);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            long j2;
            AppMethodBeat.i(131900);
            long hashCode = (long) qVar.hashCode();
            if (qVar.getType() == 268369922) {
                j2 = ((com.tencent.mm.modelmulti.g) qVar).jcg;
            } else {
                j2 = hashCode;
            }
            try {
                NotifyReceiver.glG.lock();
                synchronized (NotifyReceiver.glI) {
                    try {
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(qVar.getType());
                        objArr[1] = Long.valueOf(j2);
                        objArr[2] = Boolean.valueOf(NotifyReceiver.glF.contains(Long.valueOf(j2)));
                        objArr[3] = Boolean.valueOf(NotifyReceiver.glE != null ? NotifyReceiver.glE.isLocking() : false);
                        Log.i("MicroMsg.NotifyReceiver", "NotifyReceiver onSceneEnd type:%d syncHash: %d hashInMemo: %b isLocking: %b", objArr);
                    } finally {
                        AppMethodBeat.o(131900);
                    }
                }
                NotifyReceiver.glF.remove(Long.valueOf(j2));
                try {
                    NotifyReceiver.glG.unlock();
                } catch (Exception e2) {
                }
                try {
                    NotifyReceiver.glG.lock();
                    if (NotifyReceiver.glF.isEmpty()) {
                        synchronized (NotifyReceiver.glI) {
                            try {
                                if (NotifyReceiver.glE != null) {
                                    NotifyReceiver.glE.unLock();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        Log.i("MicroMsg.NotifyReceiver", "all scene done, unlock wakelock.");
                    } else {
                        Log.i("MicroMsg.NotifyReceiver", "rest %d scene undone, keep wakelock.", Integer.valueOf(NotifyReceiver.glF.size()));
                    }
                    try {
                        NotifyReceiver.glG.unlock();
                    } catch (Exception e3) {
                    }
                    switch (qVar.getType()) {
                        case 138:
                            if (g.aAf().azp()) {
                                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                                    /* class com.tencent.mm.booter.NotifyReceiver.a.AnonymousClass1 */

                                    public final boolean queueIdle() {
                                        AppMethodBeat.i(131896);
                                        a.a(a.this);
                                        AppMethodBeat.o(131896);
                                        return false;
                                    }
                                });
                                if (i2 == 0 && i3 == 0 && com.tencent.mm.model.a.aSG()) {
                                    try {
                                        g.aAi();
                                        com.tencent.mm.model.a aVar = g.aAf().hpN;
                                        if (aVar.iBm > -1) {
                                            aVar.iBm++;
                                        }
                                        Log.i("MicroMsg.AccInfoCacheInWorker", "countNormalCgi :%s ", Long.valueOf(aVar.iBm));
                                        if (aVar.iBm == 2 || aVar.iBm == 5) {
                                            e.INSTANCE.idkeyStat(226, aVar.iBm == 2 ? 37 : 38, 1, false);
                                            e.INSTANCE.a(11098, 2001, Long.valueOf(aVar.iBm));
                                            break;
                                        }
                                    } catch (Throwable th2) {
                                        Log.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", Util.stackTraceToString(th2));
                                        break;
                                    }
                                }
                            }
                            break;
                    }
                    yL(7000);
                    AppMethodBeat.o(131900);
                } catch (Throwable th3) {
                    throw th3;
                }
            } finally {
                try {
                    NotifyReceiver.glG.unlock();
                } catch (Exception e4) {
                }
                AppMethodBeat.o(131900);
            }
        }

        private void yL(long j2) {
            AppMethodBeat.i(131901);
            if (!af.bke().getBoolean("is_in_notify_mode", false)) {
                AppMethodBeat.o(131901);
                return;
            }
            new MMHandler(Looper.myLooper()).postDelayed(new Runnable() {
                /* class com.tencent.mm.booter.NotifyReceiver.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(131897);
                    Log.i("MicroMsg.NotifyReceiver", "checkKillProcess, canKillProcess :%b", Boolean.valueOf(NotifyReceiver.glK));
                    synchronized (NotifyReceiver.glH) {
                        try {
                            if (NotifyReceiver.gll != null) {
                                NotifyReceiver.gll.unLock();
                            }
                            WakerLock unused = NotifyReceiver.gll = null;
                        } finally {
                            AppMethodBeat.o(131897);
                        }
                    }
                    if (NotifyReceiver.glK) {
                        PluginZero pluginZero = (PluginZero) g.ah(PluginZero.class);
                        if (pluginZero.Vih != null) {
                            pluginZero.Vih.ckp();
                        }
                        Log.appenderFlushSync();
                        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                        Object obj = new Object();
                        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/booter/NotifyReceiver$NotifyIOnSceneEnd$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                        Process.killProcess(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/booter/NotifyReceiver$NotifyIOnSceneEnd$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    }
                }
            }, j2);
            AppMethodBeat.o(131901);
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(131902);
            g.aAi();
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.booter.NotifyReceiver.a.AnonymousClass3 */

                public final void run() {
                    boolean z;
                    AppMethodBeat.i(131898);
                    if (!g.aAf().azp()) {
                        AppMethodBeat.o(131898);
                        return;
                    }
                    if (Util.nullAsNil((Integer) g.aAh().azQ().get(15, (Object) null)) == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        Log.e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
                        AppMethodBeat.o(131898);
                        return;
                    }
                    long nowMilliSecond = Util.nowMilliSecond();
                    if (nowMilliSecond - a.glP <= 0 || nowMilliSecond - a.glP >= 10000) {
                        long unused = a.glP = nowMilliSecond;
                        Log.i("MicroMsg.NotifyReceiver", "begin post sync task");
                        long currentTicks = Util.currentTicks();
                        EventCenter.instance.publish(new ps());
                        Log.i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", Long.valueOf(Util.ticksToNow(currentTicks)));
                        a.b(a.this);
                        AppMethodBeat.o(131898);
                        return;
                    }
                    Log.d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", Long.valueOf(nowMilliSecond - a.glP));
                    AppMethodBeat.o(131898);
                }

                public final String toString() {
                    AppMethodBeat.i(131899);
                    String str = super.toString() + "|doPostSyncTask";
                    AppMethodBeat.o(131899);
                    return str;
                }
            });
            AppMethodBeat.o(131902);
        }
    }
}
