package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.login.widget.ToolTipPopup;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.f.h;
import com.tencent.mars.Mars;
import com.tencent.mars.comm.Alarm;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.MMReceivers;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.kernel.j;
import com.tencent.mm.kernel.l;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.ad;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.af;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.ah;
import com.tencent.mm.network.al;
import com.tencent.mm.network.o;
import com.tencent.mm.network.r;
import com.tencent.mm.network.v;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.ProcessService;
import com.tencent.mm.service.c;
import java.util.ArrayList;

public class CoreService extends Service implements PlatformComm.IReportCrash, PlatformComm.IResetProcess, af.b, o {
    private static b gld = null;
    private final MAlarmHandler.IBumper bumper = new MAlarmHandler.IBumper() {
        /* class com.tencent.mm.booter.CoreService.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MAlarmHandler.IBumper
        public final void prepare() {
            AppMethodBeat.i(131837);
            MMReceivers.AlarmReceiver.ch(CoreService.this.getApplicationContext());
            AppMethodBeat.o(131837);
        }

        @Override // com.tencent.mm.sdk.platformtools.MAlarmHandler.IBumper
        public final void cancel() {
            AppMethodBeat.i(131838);
            MMReceivers.AlarmReceiver.ci(CoreService.this.getApplicationContext());
            AppMethodBeat.o(131838);
        }
    };
    private v glb;
    private f glc = new f();
    private boolean gle = true;
    private a glf = null;
    private int glg = -1;
    private int glh = -1;
    private long gli = 0;
    private long glj = 0;
    private long glk = 0;
    private WakerLock gll = null;
    private q glm = new q();
    private MTimerHandler gln = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.booter.CoreService.AnonymousClass5 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            boolean z;
            AppMethodBeat.i(196977);
            q qVar = CoreService.this.glm;
            if (Util.ticksToNow(qVar.jNd) < qVar.jNb) {
                Log.i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + qVar.jNd + ", cur=" + Util.currentTicks() + ", retries=" + qVar.jNe);
                if (qVar.jNe <= 0) {
                    z = false;
                } else {
                    qVar.jNe--;
                    qVar.jNd = Util.currentTicks();
                    z = true;
                }
            } else {
                qVar.jNe = qVar.jNc;
                qVar.jNd = Util.currentTicks();
                z = true;
            }
            if (!z) {
                Log.e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
            } else {
                boolean aZb = CoreService.this.glb.jEj.aZb();
                boolean bjN = af.bkl().bjN();
                Log.i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isLogin:%b", Boolean.valueOf(aZb), Boolean.valueOf(bjN));
                if (!aZb || bjN || !g.a(1, 0, null, CoreService.this.glb.jEj.qe(1), Util.nowMilliSecond())) {
                    CoreService.aks();
                } else {
                    Log.i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
                    AppMethodBeat.o(196977);
                    return true;
                }
            }
            Log.i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", Long.valueOf(CoreService.this.gli), Long.valueOf(CoreService.this.glk), Long.valueOf(Util.nowMilliSecond() - CoreService.this.glj));
            CoreService.this.gli = 0;
            CoreService.this.glk = 0;
            CoreService.this.glj = 0;
            new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.booter.CoreService.AnonymousClass5.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(196976);
                    CoreService.this.gll.unLock();
                    AppMethodBeat.o(196976);
                    return false;
                }
            }, false).startTimer(500);
            AppMethodBeat.o(196977);
            return true;
        }
    }, false);

    public interface a {
        void registerBroadcasts();

        void unRegisterBroadcasts();
    }

    public interface b {
        void bL(Context context);
    }

    public CoreService() {
        AppMethodBeat.i(131845);
        AppMethodBeat.o(131845);
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public void onCreate() {
        String string;
        String str;
        NetworkInfo networkInfo = null;
        AppMethodBeat.i(131846);
        Log.d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        try {
            this.glf = (a) Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance();
            Log.d("MicroMsg.CoreService", "broadcastRegisterHelper = %s", this.glf);
            this.glf.registerBroadcasts();
        } catch (Exception e2) {
            Log.e("MicroMsg.CoreService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", e2.getMessage());
        }
        if (d.oE(26) && Build.VERSION.SDK_INT < 24 && !g.isMIUI()) {
            if (Build.VERSION.SDK_INT < 18) {
                startForeground(-1213, new Notification());
            } else if (getSharedPreferences("system_config_prefs", g.aps()).getBoolean("set_service", false)) {
                startForeground(-1213, new Notification());
                startService(new Intent(this, InnerService.class));
                Log.i("MicroMsg.CoreService", "set service for push.");
            }
        }
        MMHandler mMHandler = new MMHandler(Looper.getMainLooper());
        Mars.init(MMApplicationContext.getContext(), mMHandler);
        StnLogic.setCallBack(new al());
        IPxxLogic.setCallBack(new r());
        com.tencent.mm.jni.a.a.ayA();
        EventCenter.instance.addListener(new IListener<sc>() {
            /* class com.tencent.mm.booter.CoreService.AnonymousClass2 */

            {
                AppMethodBeat.i(161207);
                this.__eventId = sc.class.getName().hashCode();
                AppMethodBeat.o(161207);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(sc scVar) {
                AppMethodBeat.i(131839);
                String str = scVar.dYF.dYG;
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(131839);
                    return false;
                }
                e.INSTANCE.a(12900, str, true, false);
                AppMethodBeat.o(131839);
                return true;
            }
        });
        af.bkf();
        MAlarmHandler.initAlarmBumper(this.bumper);
        if (PlatformComm.resetprocessimp == null) {
            PlatformComm.resetprocessimp = this;
        }
        if (PlatformComm.reportCrashImp == null) {
            PlatformComm.reportCrashImp = this;
        }
        af.a(mMHandler);
        af.setContext(getApplicationContext());
        af.a(new ag());
        af.a(new ah());
        af.a(this);
        af.a(new ab());
        this.glb = af.bkl();
        if (this.glb == null) {
            Log.i("MicroMsg.CoreService", "autoAuth is null and new one");
            this.glb = new v(af.bkj());
            af.g(this.glb);
        } else {
            Log.w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.glb.reset();
        }
        Mars.onCreate(true);
        if (af.bkm() == null) {
            Log.i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
            af.a(new ae());
        } else {
            Log.w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            af.bkm().reset();
        }
        if (af.bkn() == null) {
            Log.i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
            af.a(new ad());
            af.bkn().jFz = this;
        }
        d dVar = com.tencent.mm.kernel.g.aAe().azG().gmN;
        if (dVar == null) {
            com.tencent.mm.kernel.g.aAe().azG().gmN = d.cg(getApplicationContext());
            dVar = com.tencent.mm.kernel.g.aAe().azG().gmN;
            Log.i("MicroMsg.CoreService", "summerauths init debug here[%s]", dVar);
        }
        if (dVar != null) {
            this.glb.d(dVar.getString(".com.tencent.mm.debug.server.host.http"), dVar.getString(".com.tencent.mm.debug.server.ports.http"), dVar.getString(".com.tencent.mm.debug.server.host.socket"), dVar.getString(".com.tencent.mm.debug.server.ports.socket"));
            String string2 = dVar.getString(".com.tencent.mm.debug.server.wallet.host");
            String string3 = dVar.getString(".com.tencent.mm.debug.server.wallet.ip");
            v vVar = this.glb;
            if (!Util.isNullOrNil(string2) && !Util.isNullOrNil(new String[0])) {
                new SyncTask<Object>(string2, string3) {
                    /* class com.tencent.mm.network.v.AnonymousClass14 */
                    final /* synthetic */ String jEO;
                    final /* synthetic */ String val$ip;

                    {
                        this.jEO = r5;
                        this.val$ip = r6;
                    }

                    @Override // com.tencent.mm.sdk.platformtools.SyncTask
                    public final Object run() {
                        AppMethodBeat.i(132786);
                        StnLogic.setDebugIP(this.jEO, this.val$ip);
                        AppMethodBeat.o(132786);
                        return null;
                    }
                }.exec(vVar.handler);
            }
        }
        if (dVar == null) {
            string = null;
        } else {
            string = dVar.getString(".com.tencent.mm.debug.server.host.newdns");
        }
        if (string != null && string.contains("@")) {
            String[] split = string.split("@");
            string = split[0];
            str = split[1];
        } else if (string == null || !string.contains(":")) {
            str = null;
        } else {
            String[] split2 = string.split(":");
            string = split2[0];
            str = split2[1];
        }
        this.glb.setNewDnsDebugHost(string, str);
        MMReceivers.AlarmReceiver.ck(getApplicationContext());
        MMReceivers.AlarmReceiver.cj(getApplicationContext());
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.CoreService", e3, "", new Object[0]);
            Log.e("MicroMsg.CoreService", "getActiveNetworkInfo failed. %s", e3.getMessage());
        }
        if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
            Object[] objArr = new Object[1];
            objArr[0] = networkInfo == null ? BuildConfig.COMMAND : networkInfo.getState();
            Log.e("MicroMsg.CoreService", "networkInfo.state: %s", objArr);
            af.bkh().jFS = false;
            af.bki().uC(0);
        } else {
            af.bkh().jFS = true;
            af.bki().uC(6);
        }
        ((PluginZero) com.tencent.mm.kernel.g.ah(PluginZero.class)).Vij.a(this);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.booter.CoreService.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(131840);
                if (Build.VERSION.SDK_INT > 23) {
                    Log.i("MicroMsg.CoreService", "KeepAliveService.scheduleKeepAliveJob() flag:%s", Boolean.valueOf(KeepAliveService.akB()));
                }
                AppMethodBeat.o(131840);
            }
        }, 1000);
        Log.i("MicroMsg.CoreService", "CoreService OnCreate ");
        AppMethodBeat.o(131846);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(131847);
        int myPid = Process.myPid();
        Log.i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", Integer.valueOf(this.glg), Integer.valueOf(myPid), Integer.valueOf(i2), Integer.valueOf(i3));
        if (myPid != this.glg) {
            this.glg = myPid;
            e.INSTANCE.idkeyStat(99, 141, 1, false);
            if (intent != null && "auto".equals(intent.getStringExtra("START_TYPE"))) {
                e.INSTANCE.idkeyStat(99, 140, 1, false);
            }
        }
        AppMethodBeat.o(131847);
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.i(131848);
        Log.i("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
        try {
            ((PluginZero) com.tencent.mm.kernel.g.ah(PluginZero.class)).Vij.b(this);
        } catch (Exception e2) {
            Log.e("MicroMsg.CoreService", "onDestroy onDestroy() mCoreServiceLifecycleCallbacks Exception: %s", e2.getMessage());
        }
        com.tencent.mm.jni.a.a.ayB();
        super.onDestroy();
        akt();
        if (this.glf != null) {
            try {
                this.glf.unRegisterBroadcasts();
                AppMethodBeat.o(131848);
                return;
            } catch (Exception e3) {
                Log.e("MicroMsg.CoreService", "onDestroy unRegisterBroadcasts() Exception = %s ", e3.getMessage());
            }
        }
        AppMethodBeat.o(131848);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(131849);
        Log.d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
        af.bkh().jFR = null;
        af.bko().jFt = null;
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(131849);
        return onUnbind;
    }

    public IBinder onBind(Intent intent) {
        int i2;
        AppMethodBeat.i(131850);
        int myPid = Process.myPid();
        Log.d("MicroMsg.CoreService", "onBind~~~ lastpid:%d  pid:%d threadID:" + Thread.currentThread(), Integer.valueOf(this.glh), Integer.valueOf(myPid));
        if (myPid != this.glh) {
            this.glh = myPid;
            e.INSTANCE.idkeyStat(99, 147, 1, false);
            if (intent != null && "auto".equals(intent.getStringExtra("START_TYPE"))) {
                e.INSTANCE.idkeyStat(99, 146, 1, false);
            }
            int elapsedRealtime = (int) (SystemClock.elapsedRealtime() - j.aAn());
            ArrayList<IDKey> arrayList = new ArrayList<>();
            arrayList.add(cp(5, elapsedRealtime));
            if (((long) elapsedRealtime) <= 1000) {
                i2 = 10;
            } else if (((long) elapsedRealtime) <= 2000) {
                i2 = 11;
            } else if (((long) elapsedRealtime) <= 3000) {
                i2 = 12;
            } else if (((long) elapsedRealtime) <= 4000) {
                i2 = 13;
            } else if (((long) elapsedRealtime) <= 5000) {
                i2 = 14;
            } else if (((long) elapsedRealtime) <= 7000) {
                i2 = 15;
            } else if (((long) elapsedRealtime) <= 10000) {
                i2 = 16;
            } else if (((long) elapsedRealtime) <= 15000) {
                i2 = 17;
            } else if (((long) elapsedRealtime) <= 20000) {
                i2 = 18;
            } else if (((long) elapsedRealtime) <= 30000) {
                i2 = 19;
            } else if (((long) elapsedRealtime) <= 40000) {
                i2 = 20;
            } else if (((long) elapsedRealtime) <= 50000) {
                i2 = 21;
            } else if (((long) elapsedRealtime) <= Util.MILLSECONDS_OF_MINUTE) {
                i2 = 22;
            } else if (((long) elapsedRealtime) <= 120000) {
                i2 = 23;
            } else if (((long) elapsedRealtime) <= 180000) {
                i2 = 24;
            } else if (((long) elapsedRealtime) <= 300000) {
                i2 = 25;
            } else if (((long) elapsedRealtime) <= 420000) {
                i2 = 26;
            } else if (((long) elapsedRealtime) <= 600000) {
                i2 = 27;
            } else {
                i2 = 28;
            }
            arrayList.add(cp(i2, 1));
            arrayList.add(cp(0, 1));
            e.INSTANCE.b(arrayList, false);
            h.RTc.o(new Runnable() {
                /* class com.tencent.mm.booter.CoreService.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(196975);
                    CoreService.akw();
                    AppMethodBeat.o(196975);
                }
            }, 3000);
        }
        v vVar = this.glb;
        AppMethodBeat.o(131850);
        return vVar;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.i(131851);
        Log.d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
        AppMethodBeat.o(131851);
    }

    @Override // com.tencent.mm.network.o
    public final boolean f(int i2, byte[] bArr) {
        int i3;
        AppMethodBeat.i(131852);
        if (l.cK(this)) {
            Log.i("MicroMsg.CoreService", "fully exited, no need to notify worker");
            AppMethodBeat.o(131852);
            return false;
        }
        if (i2 == -255) {
            i3 = 138;
        } else {
            i3 = i2;
        }
        boolean z = af.bke().getBoolean("is_in_notify_mode", false);
        boolean aZb = this.glb.jEj.aZb();
        boolean bjN = af.bkl().bjN();
        if (!z || !aZb || bjN || !g.a(2, i3, bArr, this.glb.jEj.qe(1), Util.nowMilliSecond())) {
            Log.i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isLogin:%b, isMMProcessExist:%b, isInNotifyMode:%b", Boolean.valueOf(aZb), Boolean.valueOf(bjN), Boolean.valueOf(z));
            Intent intent = new Intent(this, NotifyReceiver.class);
            intent.putExtra("notify_option_type", 2);
            intent.putExtra("notify_uin", this.glb.jEj.getUin());
            intent.putExtra("notify_respType", i3);
            intent.putExtra("notify_respBuf", bArr);
            intent.putExtra("notify_skey", this.glb.jEj.qe(1));
            Log.i("MicroMsg.CoreService", "notify broadcast:" + intent.getAction() + ", type=" + i3);
            try {
                long aku = aku();
                intent.putExtra("notfiy_sync_num", aku);
                Log.i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d syncNum:%s", Long.valueOf(intent.getLongExtra("notfiy_recv_time", 0)), Integer.valueOf(intent.getIntExtra("notify_uin", 0)), Integer.valueOf(intent.getIntExtra("notify_respType", 0)), Integer.valueOf(Util.nullAs(intent.getByteArrayExtra("notify_respBuf"), new byte[0]).length), Long.valueOf(aku));
                intent.putExtra("notfiy_recv_time", Util.nowMilliSecond());
                sendBroadcast(intent);
                e.INSTANCE.idkeyStat(1042, 60, 1, false);
                com.tencent.mm.ap.a.A(i3, aku);
                if (Util.isEqual(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_android_receive_msg_use_mmservice_switch", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true), "1")) {
                    intent.setClass(this, NotifyReceiver.NotifyReceiverService.class);
                    intent.putExtra("notfiy_recv_time", Util.nowMilliSecond());
                    c.a(intent, "mm", true, new Intent(MMApplicationContext.getContext(), ProcessService.MMProcessService.class));
                    e.INSTANCE.idkeyStat(1042, 62, 1, false);
                }
            } catch (Throwable th) {
                Log.e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", Util.stackTraceToString(th));
            }
            AppMethodBeat.o(131852);
            return true;
        }
        Log.i("MicroMsg.CoreService", "deal with notify sync in push");
        AppMethodBeat.o(131852);
        return true;
    }

    @Override // com.tencent.mm.network.af.b
    public final void df(boolean z) {
        AppMethodBeat.i(131853);
        if (!z) {
            Log.w("MicroMsg.CoreService", "[NETWORK LOST]");
            af.bkh().jFS = false;
            af.bki().uC(0);
            if (this.gle) {
                af.bkl().bjx();
                f fVar = this.glc;
                fVar.glA = null;
                fVar.glC = "";
                fVar.glB = "";
                fVar.glD = -1;
            }
            this.gle = false;
            AppMethodBeat.o(131853);
            return;
        }
        Log.w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
        af.bkh().jFS = true;
        boolean akC = this.glc.akC();
        Log.i("MicroMsg.CoreService", "lastConnected %s, isNetWorkChange %s", Boolean.valueOf(this.gle), Boolean.valueOf(akC));
        if (!this.gle || akC) {
            if (akC) {
                af.bkl().bjx();
            }
            this.gle = true;
            af.bki().uC(6);
            if (this.gll == null) {
                this.gll = new WakerLock(getApplicationContext(), "MicroMsg.CoreService");
            }
            if (!this.gll.isLocking()) {
                this.gll.lock(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, "CoreService.setNetworkAvailable");
                this.gli++;
            }
            if (0 == this.glk) {
                this.glj = Util.nowMilliSecond();
            }
            this.glk++;
            Log.i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", Long.valueOf(this.gli), Long.valueOf(this.glk), Long.valueOf(Util.nowMilliSecond() - this.glj));
            this.gln.startTimer(3000);
            AppMethodBeat.o(131853);
            return;
        }
        Log.i("MicroMsg.CoreService", "network not change or can't get network info");
        AppMethodBeat.o(131853);
    }

    public static void aks() {
        AppMethodBeat.i(131854);
        Intent intent = new Intent(af.getContext(), NotifyReceiver.class);
        intent.putExtra("notify_option_type", 1);
        intent.putExtra("notify_uin", af.bkl().jEj.getUin());
        long aku = aku();
        intent.putExtra("notfiy_sync_num", aku);
        try {
            af.getContext().sendBroadcast(intent);
            Log.i("MicroMsg.CoreService", "sendBorastToNotifyReceiver syncNum:%s", Long.valueOf(aku));
            if (Util.isEqual(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_android_receive_msg_use_mmservice_switch", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true), "1")) {
                intent.setClass(af.getContext(), NotifyReceiver.NotifyReceiverService.class);
                intent.putExtra("notfiy_recv_time", Util.nowMilliSecond());
                c.a(intent, "mm", true, new Intent(MMApplicationContext.getContext(), ProcessService.MMProcessService.class));
                e.INSTANCE.idkeyStat(1042, 62, 1, false);
            }
            AppMethodBeat.o(131854);
        } catch (Exception e2) {
            Log.f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", e2.toString());
            AppMethodBeat.o(131854);
        }
    }

    private void akt() {
        AppMethodBeat.i(131855);
        Log.w("MicroMsg.CoreService", "[COMPLETE EXIT]");
        af.bkm().m(3, 10000, "");
        Mars.onDestroy();
        try {
            MMReceivers.AlarmReceiver.ck(getApplicationContext());
            MMReceivers.AlarmReceiver.ci(getApplicationContext());
            Alarm.resetAlarm(getApplicationContext());
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CoreService", e2, "", new Object[0]);
        }
        Log.appenderClose();
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object obj = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/booter/CoreService", "doExit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/booter/CoreService", "doExit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(131855);
    }

    @Override // com.tencent.mars.comm.PlatformComm.IResetProcess
    public void restartProcess() {
        AppMethodBeat.i(131856);
        Log.w("MicroMsg.CoreService", "restartProcess");
        akt();
        AppMethodBeat.o(131856);
    }

    @Override // com.tencent.mars.comm.PlatformComm.IReportCrash
    public void reportIdkey() {
        AppMethodBeat.i(131857);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("alarm_crash");
        if (cl.aWy() - mmkv.getLong("report_time", 0) > Util.MILLSECONDS_OF_DAY) {
            mmkv.edit().putLong("report_time", cl.aWy());
            e.INSTANCE.idkeyStat(1204, 0, 1, false);
        }
        AppMethodBeat.o(131857);
    }

    private static IDKey cp(int i2, int i3) {
        AppMethodBeat.i(196978);
        Log.i("MicroMsg.CoreService", "idkeyPushSetupTimeReport %s %s", Integer.valueOf(i2), Integer.valueOf(i3));
        IDKey iDKey = new IDKey();
        iDKey.SetID(1391);
        iDKey.SetKey(i2);
        iDKey.SetValue((long) i3);
        AppMethodBeat.o(196978);
        return iDKey;
    }

    public static void a(b bVar) {
        gld = bVar;
    }

    public static class InnerService extends Service {
        public void onCreate() {
            AppMethodBeat.i(131843);
            super.onCreate();
            try {
                startForeground(-1213, new Notification());
            } catch (NullPointerException e2) {
                Log.e("MicroMsg.CoreService", "set service for push exception:%s.", e2);
            }
            stopSelf();
            AppMethodBeat.o(131843);
        }

        public void onDestroy() {
            AppMethodBeat.i(131844);
            stopForeground(true);
            super.onDestroy();
            AppMethodBeat.o(131844);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    private static long aku() {
        AppMethodBeat.i(131858);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("msg_receive_number");
        long j2 = mmkv.getLong("send_num", 0) + 1;
        mmkv.edit().putLong("send_num", j2);
        AppMethodBeat.o(131858);
        return j2;
    }

    public static long yK(long j2) {
        AppMethodBeat.i(131859);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("msg_receive_number");
        long j3 = j2 - mmkv.getLong("recv_num", 0);
        if (j3 > 0) {
            mmkv.edit().putLong("recv_num", j2);
            AppMethodBeat.o(131859);
            return 1;
        }
        AppMethodBeat.o(131859);
        return j3;
    }

    public static void akv() {
        AppMethodBeat.i(196979);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("msg_receive_number");
        long j2 = mmkv.getLong("recv_num", 0);
        long j3 = mmkv.getLong("send_num", 0);
        long j4 = j2 - j3;
        if (j4 > 0) {
            mmkv.edit().putLong("send_num", 1 + j2);
            e.INSTANCE.a(19779, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
            Log.i("MicroMsg.CoreService", "checkSyncNum() why?????? diffValue:%s recvNum:%s sendNum:%s", Long.valueOf(j4), Long.valueOf(j2), Long.valueOf(j3));
            AppMethodBeat.o(196979);
            return;
        }
        Log.i("MicroMsg.CoreService", "checkSyncNum() no problem");
        AppMethodBeat.o(196979);
    }

    static /* synthetic */ void akw() {
        AppMethodBeat.i(196980);
        Log.i("MicroMsg.CoreService", "initOther");
        if (gld != null) {
            gld.bL(MMApplicationContext.getContext());
        }
        AppMethodBeat.o(196980);
    }
}
