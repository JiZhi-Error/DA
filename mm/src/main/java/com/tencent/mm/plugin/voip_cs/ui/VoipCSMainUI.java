package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.support.v4.app.s;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.pay.q;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip_cs.c.b;
import com.tencent.mm.plugin.voip_cs.c.b.a;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.c.d;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.protocal.protobuf.epd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.qqmusic.mediaplayer.PlayerException;

@a(3)
public class VoipCSMainUI extends MMActivity implements b, a.AbstractC1901a {
    private p FPE = new p.a() {
        /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass8 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(199034);
            Log.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from ".concat(String.valueOf(i2)));
            if (c.fMs().HrL == 2 && (i2 == 4 || i2 == 6)) {
                e fMs = c.fMs();
                com.tencent.mm.plugin.voip_cs.c.a aVar = c.fMr().Hsv;
                if (fMs.GWg == 0) {
                    fMs.GWg = aVar.Hau;
                }
                int netType = com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext());
                if (netType != fMs.GWg) {
                    Log.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + fMs.GWg + " to " + netType);
                    try {
                        byte[] bArr = new byte[4];
                        bArr[0] = (byte) netType;
                        int appCmd = aVar.setAppCmd(301, bArr, 4);
                        if (appCmd < 0) {
                            Log.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + aVar.ypO + ", roomkey=" + aVar.ypH + "]");
                        }
                        epd epd = new epd();
                        epd.NmY = 3;
                        epd.NmZ = new com.tencent.mm.bw.b(bArr, 0, 1);
                        aVar.SendRUDP(epd.toByteArray(), epd.toByteArray().length);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
                    }
                    fMs.GWg = netType;
                }
                e fMs2 = c.fMs();
                Log.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + c.fMr().Hsv.Haw + "roomkey:" + c.fMr().Hsv.ypH);
                g.azz().a(q.CTRL_INDEX, fMs2);
                com.tencent.mm.plugin.voip_cs.c.a aVar2 = c.fMr().Hsv;
                g.azz().a(new d(aVar2.Haw, aVar2.ypH), 0);
            }
            AppMethodBeat.o(199034);
        }
    };
    private BroadcastReceiver GUV = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(199030);
            String action = intent.getAction();
            PowerManager powerManager = (PowerManager) MMApplicationContext.getContext().getSystemService("power");
            if (!"android.intent.action.USER_PRESENT".equals(action) || !powerManager.isScreenOn()) {
                if ("android.intent.action.SCREEN_ON".equals(action)) {
                    Log.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
                    VoipCSMainUI.this.Hsy.dLD = false;
                    if (!VoipCSMainUI.this.HrS.czl() && c.fMs().HrL == 2) {
                        VoipCSMainUI.this.HrS.fMC();
                        AppMethodBeat.o(199030);
                        return;
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    Log.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
                    VoipCSMainUI.this.Hsy.dLD = true;
                    if (!VoipCSMainUI.this.HrS.czl()) {
                        VoipCSMainUI.this.HrS.stopRing();
                    }
                }
                AppMethodBeat.o(199030);
                return;
            }
            Log.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
            VoipCSMainUI.this.Hsy.dLD = false;
            AppMethodBeat.o(199030);
        }
    };
    public String HrM = "";
    private com.tencent.mm.plugin.voip_cs.c.a.a HrS;
    public String HsA = "";
    public String HsB = "";
    public String HsC = "";
    public boolean HsD = false;
    private MTimerHandler HsE = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass16 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(125457);
            PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), 44, new Intent(MMApplicationContext.getContext(), VoipCSMainUI.class), 134217728);
            s.c g2 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(VoipCSMainUI.this.tickerText).f(VoipCSMainUI.this.title).g(VoipCSMainUI.this.dQx);
            g2.Hv = activity;
            g2.g(2, true);
            Notification build = g2.build();
            build.icon = com.tencent.mm.bq.a.ezb();
            build.flags |= 32;
            ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, build, false);
            AppMethodBeat.o(125457);
            return true;
        }
    }, true);
    private com.tencent.mm.plugin.voip_cs.c.a.b Hsy;
    private com.tencent.mm.plugin.voip_cs.a.a Hsz;
    private String appId = "";
    public String dQx = MMApplicationContext.getContext().getString(R.string.i27);
    private com.tencent.mm.compatible.util.b dtz;
    private MMHandler hAk;
    public String kog = "";
    PhoneStateListener mtH = new PhoneStateListener() {
        /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass3 */

        public final void onCallStateChanged(int i2, String str) {
            AppMethodBeat.i(199031);
            Log.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
            if (i2 == 2) {
                Log.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
                c.fMt().Hrf = 4;
                VoipCSMainUI.this.aeh(7);
            }
            AppMethodBeat.o(199031);
        }
    };
    public String scene = "";
    public CharSequence tickerText = MMApplicationContext.getContext().getString(R.string.i27);
    public CharSequence title = MMApplicationContext.getContext().getString(R.string.i21);
    public String type = "";
    private TelephonyManager yoi;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VoipCSMainUI() {
        AppMethodBeat.i(125458);
        AppMethodBeat.o(125458);
    }

    static /* synthetic */ boolean a(VoipCSMainUI voipCSMainUI) {
        AppMethodBeat.i(125475);
        boolean fMP = voipCSMainUI.fMP();
        AppMethodBeat.o(125475);
        return fMP;
    }

    static /* synthetic */ void b(VoipCSMainUI voipCSMainUI) {
        AppMethodBeat.i(125476);
        voipCSMainUI.fMO();
        AppMethodBeat.o(125476);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(125459);
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
        super.onCreate(bundle);
        hideTitleView();
        this.HrM = getIntent().getStringExtra("voipCSBizId");
        this.appId = getIntent().getStringExtra("voipCSAppId");
        this.scene = Util.nullAsNil(getIntent().getStringExtra("voipCSScene"));
        this.type = Util.nullAsNil(getIntent().getStringExtra("voipCSType"));
        this.HsA = getIntent().getStringExtra("voipCSAllowBackCamera");
        this.HsB = getIntent().getStringExtra("voipCSShowOther");
        this.kog = getIntent().getStringExtra("voipCSAvatarUrl");
        this.HsC = getIntent().getStringExtra("voipCSContext");
        this.HsD = getIntent().getBooleanExtra("launch_from_appbrand", false);
        getWindow().addFlags(6946944);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        this.hAk = new MMHandler();
        com.tencent.mm.plugin.voip_cs.c.d fMt = c.fMt();
        Log.d("MicroMsg.VoipCSReportHelper", "reset");
        fMt.dataType = 0;
        fMt.HqP = 0;
        fMt.HqQ = 0;
        fMt.HqR = 0;
        fMt.videoFps = 0;
        fMt.HqS = 0;
        fMt.HqT = 0;
        fMt.HqU = 0;
        fMt.HqV = 0;
        fMt.HqW = 0;
        fMt.HqX = 0;
        fMt.networkType = 0;
        fMt.HqY = 0;
        fMt.HqZ = com.tencent.mm.plugin.voip_cs.c.d.HqM;
        fMt.hzL = 0;
        fMt.roomId = 0;
        fMt.ypH = 0;
        fMt.Hra = "";
        fMt.Hau = 0;
        fMt.Hrd = 0;
        fMt.Hre = 0;
        fMt.Hrf = 0;
        fMt.HaP = 0;
        fMt.HaO = 0;
        fMt.Hrg = 0;
        fMt.Hrh = 0;
        fMt.Hri = 0;
        fMt.Hrj = 0;
        fMt.Hrk = 0;
        fMt.Hrl = 0;
        fMt.Hrm = 0;
        fMt.Hrn = 0;
        fMt.Hro = 0;
        fMt.Hrp = 0;
        fMt.Hrq = 0;
        fMt.yqU = 0;
        fMt.Hrr = 0;
        fMt.Hrs = 0;
        fMt.channelStrategy = 1;
        fMt.Hcv = 0;
        fMt.HaQ = 0;
        fMt.Hrt = 0;
        fMt.Hru = 0;
        fMt.yre = "";
        fMt.yrd = "";
        fMt.Hry = 0;
        fMt.Hrz = 0;
        fMt.HrA = 0;
        fMt.HrB = 0;
        fMt.HrC = 0;
        this.yoi = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
        c.fMs().HrM = this.HrM;
        this.Hsy = new com.tencent.mm.plugin.voip_cs.c.a.b(this);
        this.Hsz = new com.tencent.mm.plugin.voip_cs.a.a();
        this.dtz = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
        this.HrS = com.tencent.mm.plugin.voip_cs.c.a.a.fMA();
        c.fMr().Hsw = this;
        c.fMs().HrE = this;
        if (c.fMs().HrL == 0 || c.fMs().HrL == 3) {
            c.fMs().HrL = 0;
        }
        com.tencent.mm.booter.a.akp().akr();
        this.dtz.requestFocus();
        this.Hsz.Yl();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        MMApplicationContext.getContext().registerReceiver(this.GUV, intentFilter);
        g.aAg().a(this.FPE);
        if (this.HsD) {
            if (this.scene.equals("1")) {
                if (this.type.equals("video")) {
                    this.title = MMApplicationContext.getContext().getString(R.string.i1z);
                    this.tickerText = MMApplicationContext.getContext().getString(R.string.i23);
                    this.dQx = MMApplicationContext.getContext().getString(R.string.i23);
                } else {
                    this.title = MMApplicationContext.getContext().getString(R.string.i20);
                    this.tickerText = MMApplicationContext.getContext().getString(R.string.i24);
                    this.dQx = MMApplicationContext.getContext().getString(R.string.i24);
                }
            } else if (this.type.equals("video")) {
                this.title = MMApplicationContext.getContext().getString(R.string.i21);
                this.tickerText = MMApplicationContext.getContext().getString(R.string.i25);
                this.dQx = MMApplicationContext.getContext().getString(R.string.i25);
            } else {
                this.title = MMApplicationContext.getContext().getString(R.string.i20);
                this.tickerText = MMApplicationContext.getContext().getString(R.string.i24);
                this.dQx = MMApplicationContext.getContext().getString(R.string.i24);
            }
        } else if (this.scene.equals("1")) {
            if (this.type.equals("video")) {
                this.title = MMApplicationContext.getContext().getString(R.string.i1z);
                this.tickerText = MMApplicationContext.getContext().getString(R.string.i23);
                this.dQx = MMApplicationContext.getContext().getString(R.string.i23);
            } else {
                this.title = MMApplicationContext.getContext().getString(R.string.i20);
                this.tickerText = MMApplicationContext.getContext().getString(R.string.i27);
                this.dQx = MMApplicationContext.getContext().getString(R.string.i27);
            }
        } else if (this.type.equals("video")) {
            this.title = MMApplicationContext.getContext().getString(R.string.i21);
            this.tickerText = MMApplicationContext.getContext().getString(R.string.i27);
            this.dQx = MMApplicationContext.getContext().getString(R.string.i27);
        } else {
            this.title = MMApplicationContext.getContext().getString(R.string.i20);
            this.tickerText = MMApplicationContext.getContext().getString(R.string.i26);
            this.dQx = MMApplicationContext.getContext().getString(R.string.i26);
        }
        int callState = this.yoi.getCallState();
        if (callState == 2 || callState == 1) {
            Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", Integer.valueOf(callState));
            h.a(this, (int) R.string.i2c, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(125440);
                    dialogInterface.dismiss();
                    VoipCSMainUI.this.aeh(0);
                    AppMethodBeat.o(125440);
                }
            });
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
            AppMethodBeat.o(125459);
            return;
        }
        TelephonyManager telephonyManager = this.yoi;
        com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(this.mtH);
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onCreate", "(Landroid/os/Bundle;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI", "onCreate", "(Landroid/os/Bundle;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        if (!NetStatusUtil.isNetworkConnected(this)) {
            Log.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
            h.a(this, (int) R.string.i29, (int) R.string.i3s, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(125454);
                    dialogInterface.dismiss();
                    VoipCSMainUI.this.aeh(9);
                    AppMethodBeat.o(125454);
                }
            });
            z2 = false;
        } else if (NetStatusUtil.isWifi(this) || com.tencent.mm.plugin.voip.model.s.fHs()) {
            z2 = true;
        } else {
            Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
            h.a(this, (int) R.string.i2_, (int) R.string.i3s, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass14 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(125455);
                    Log.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
                    com.tencent.mm.plugin.voip.model.s.fHr();
                    if (VoipCSMainUI.a(VoipCSMainUI.this)) {
                        VoipCSMainUI.b(VoipCSMainUI.this);
                    }
                    AppMethodBeat.o(125455);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass15 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(125456);
                    Log.i("MicroMsg.voipcs.VoipCSMainUI", "cannot start voip by user choose cancel call  in not wifi network!");
                    dialogInterface.dismiss();
                    VoipCSMainUI.this.aeh(8);
                    AppMethodBeat.o(125456);
                }
            });
            z2 = false;
        }
        if (!z2) {
            Log.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
            AppMethodBeat.o(125459);
            return;
        }
        if (m.isVoipStarted()) {
            Log.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
            h.a(this, (int) R.string.e3h, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(125450);
                    dialogInterface.dismiss();
                    VoipCSMainUI.this.aeh(0);
                    AppMethodBeat.o(125450);
                }
            });
            z3 = true;
        } else if (m.fKH()) {
            Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
            h.a(this, (int) R.string.e3i, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(125451);
                    dialogInterface.dismiss();
                    VoipCSMainUI.this.aeh(0);
                    AppMethodBeat.o(125451);
                }
            });
            z3 = true;
        } else if (com.tencent.mm.q.a.att()) {
            Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
            h.a(this, (int) R.string.e3c, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(125452);
                    dialogInterface.dismiss();
                    VoipCSMainUI.this.aeh(0);
                    AppMethodBeat.o(125452);
                }
            });
            z3 = true;
        } else if (com.tencent.mm.bh.e.bgH()) {
            Log.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
            h.a(this, (int) R.string.e3d, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass12 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(125453);
                    dialogInterface.dismiss();
                    VoipCSMainUI.this.aeh(0);
                    AppMethodBeat.o(125453);
                }
            });
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            Log.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
            AppMethodBeat.o(125459);
            return;
        }
        if (fMP()) {
            fMO();
        }
        AppMethodBeat.o(125459);
    }

    private void fMO() {
        AppMethodBeat.i(125460);
        if (c.fMs().HrL <= 0) {
            this.Hsy.fMD();
            this.Hsy.fME();
            c.fMr().init();
            c.fMs().aY(this.HrM, this.appId, this.HsC);
        }
        if (c.fMs().HrL < 2) {
            this.HrS.fMC();
        }
        this.Hsy.fMH();
        AppMethodBeat.o(125460);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(125461);
        if (keyEvent.getKeyCode() == 4) {
            AppMethodBeat.o(125461);
            return true;
        } else if (i2 == 25) {
            this.Hsz.AX(this.Hsz.xC(this.HrS.czl()));
            AppMethodBeat.o(125461);
            return true;
        } else if (i2 == 24) {
            this.Hsz.AW(this.Hsz.xC(this.HrS.czl()));
            AppMethodBeat.o(125461);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(125461);
            return onKeyDown;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(125463);
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
        super.onResume();
        if (this.Hsy != null) {
            this.Hsy.dLD = false;
            if (c.fMs().HrL > 1) {
                fMO();
                if (this.HsB != null && this.HsB.equals("1")) {
                    this.Hsy.fMK();
                }
            }
        }
        if (this.HsE != null) {
            this.HsE.stopTimer();
        }
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
        AppMethodBeat.o(125463);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(125464);
        super.onPause();
        if (!this.HrS.czl()) {
            this.HrS.stopRing();
        }
        if (c.fMs().HrL == 1 || c.fMs().HrL == 2) {
            Intent intent = new Intent(MMApplicationContext.getContext(), VoipCSMainUI.class);
            intent.putExtra("voipCSBizId", this.HrM);
            intent.putExtra("voipCSAppId", this.appId);
            intent.putExtra("voipCSScene", this.scene);
            intent.putExtra("voipCSType", this.type);
            intent.putExtra("voipCSAllowBackCamera", this.HsA);
            intent.putExtra("voipCSShowOther", this.HsB);
            intent.putExtra("voipCSAvatarUrl", this.kog);
            intent.putExtra("voipCSContext", this.HsC);
            intent.putExtra("launch_from_appbrand", this.HsD);
            PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), 44, intent, 134217728);
            s.c g2 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(this.tickerText).i(System.currentTimeMillis()).f(this.title).g(this.dQx);
            g2.Hv = activity;
            g2.g(2, true);
            Notification build = g2.build();
            build.icon = com.tencent.mm.bq.a.ezb();
            build.flags |= 32;
            ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, build, false);
            if (this.HsE != null && this.HsE.stopped()) {
                this.HsE.startTimer(5000);
            }
        } else {
            ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
            if (this.HsE != null) {
                this.HsE.stopTimer();
            }
        }
        this.Hsy.fMI();
        this.Hsy.dLD = true;
        AppMethodBeat.o(125464);
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        AppMethodBeat.i(125465);
        Log.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
        super.onRestart();
        if (fMP() && c.fMs().HrL <= 1) {
            fMO();
        }
        if (this.Hsy != null) {
            this.Hsy.dLD = false;
        }
        AppMethodBeat.o(125465);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(125466);
        super.onStop();
        AppMethodBeat.o(125466);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x02af  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
        // Method dump skipped, instructions count: 895
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.onDestroy():void");
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c70;
    }

    @Override // com.tencent.mm.plugin.voip_cs.c.b
    public final void aeh(int i2) {
        AppMethodBeat.i(125468);
        Log.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + i2 + ",CallingStatus:" + c.fMs().HrL);
        if (c.fMs().HrL == 0) {
            finish();
            AppMethodBeat.o(125468);
            return;
        }
        if (this.Hsy != null) {
            this.Hsy.aek(i2);
        }
        AppMethodBeat.o(125468);
    }

    @Override // com.tencent.mm.plugin.voip_cs.c.b
    public final void onError(int i2) {
        AppMethodBeat.i(125469);
        if (this.Hsy != null) {
            Log.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:".concat(String.valueOf(i2)));
            this.Hsy.aek(i2);
        }
        AppMethodBeat.o(125469);
    }

    @Override // com.tencent.mm.plugin.voip_cs.c.b
    public final void ln(String str, String str2) {
        AppMethodBeat.i(125470);
        com.tencent.mm.plugin.voip_cs.c.a.b bVar = this.Hsy;
        if (!bVar.Hsl.equals("") || !Util.isNullOrNil(str2)) {
            bVar.setNickName(str2);
        } else if (bVar.HrT.HsD) {
            bVar.gvw.setText(R.string.i1o);
        } else {
            bVar.gvw.setText(R.string.i1n);
        }
        if (!bVar.Hsk.equals("") || !Util.isNullOrNil(str) || (bVar.HrT.kog != null && !bVar.HrT.kog.equals(""))) {
            SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
            if (!Util.isNullOrNil(str) && !bVar.Hsk.equals(str)) {
                bVar.aUE(str);
                defaultPreference.edit().putString(bVar.fMF(), str).commit();
            }
            if (!Util.isNullOrNil(str2) && !bVar.Hsl.equals(str2)) {
                bVar.setNickName(str2);
                defaultPreference.edit().putString(bVar.fMG(), str2).commit();
            }
            AppMethodBeat.o(125470);
            return;
        }
        bVar.HrZ.setImageResource(R.drawable.bca);
        AppMethodBeat.o(125470);
    }

    private boolean fMP() {
        AppMethodBeat.i(125471);
        if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            Log.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
            AppMethodBeat.o(125471);
            return false;
        }
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
        Log.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this);
        if (!a2) {
            Log.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
            AppMethodBeat.o(125471);
            return false;
        }
        AppMethodBeat.o(125471);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(125472);
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            Log.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", Integer.valueOf(i2));
            AppMethodBeat.o(125472);
            return;
        }
        Log.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                if (iArr[0] == 0) {
                    Log.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
                    if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")) {
                        fMO();
                    }
                    AppMethodBeat.o(125472);
                    return;
                }
                h.a((Context) this, getString(R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(199032);
                        VoipCSMainUI voipCSMainUI = VoipCSMainUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        com.tencent.mm.hellhoundlib.a.a.a(voipCSMainUI, bl.axQ(), "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        voipCSMainUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(voipCSMainUI, "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(199032);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(199033);
                        dialogInterface.dismiss();
                        VoipCSMainUI.this.aeh(2);
                        AppMethodBeat.o(199033);
                    }
                });
                AppMethodBeat.o(125472);
                return;
            case 19:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString("android.permission.CAMERA".equals(strArr[0]) ? R.string.fl0 : R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(125445);
                            dialogInterface.dismiss();
                            VoipCSMainUI voipCSMainUI = VoipCSMainUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(voipCSMainUI, bl.axQ(), "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            voipCSMainUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(voipCSMainUI, "com/tencent/mm/plugin/voip_cs/ui/VoipCSMainUI$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(125445);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(125446);
                            dialogInterface.dismiss();
                            VoipCSMainUI.this.aeh(3);
                            AppMethodBeat.o(125446);
                        }
                    });
                    break;
                } else {
                    fMO();
                    AppMethodBeat.o(125472);
                    return;
                }
        }
        AppMethodBeat.o(125472);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a9  */
    @Override // com.tencent.mm.plugin.voip_cs.c.b.a.AbstractC1901a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dZP() {
        /*
        // Method dump skipped, instructions count: 218
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.dZP():void");
    }

    @Override // com.tencent.mm.plugin.voip_cs.c.b.a.AbstractC1901a
    public final void fMN() {
        AppMethodBeat.i(125474);
        Log.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
        this.Hsy.aek(5);
        AppMethodBeat.o(125474);
    }
}
