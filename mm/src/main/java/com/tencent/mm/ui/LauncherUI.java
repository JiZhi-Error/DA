package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.g.a.abl;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.b.a.ks;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.ui.WelcomeActivity;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.pluginsdk.i.c;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.tools.x;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.recovery.wx.util.WXUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class LauncherUI extends MMSecDataFragmentActivity {
    private static ArrayList<LauncherUI> ODL = new ArrayList<>();
    private static ArrayList<WeakReference<LauncherUI>> ODM = new ArrayList<>();
    private static boolean ODN = true;
    public static long ODO;
    private static boolean ODP = false;
    private static boolean ODY = false;
    private IListener<qm> ODQ = new IListener<qm>() {
        /* class com.tencent.mm.ui.LauncherUI.AnonymousClass1 */

        {
            AppMethodBeat.i(232592);
            this.__eventId = qm.class.getName().hashCode();
            AppMethodBeat.o(232592);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qm qmVar) {
            AppMethodBeat.i(232593);
            Log.i("MicroMsg.LauncherUI", "reStartLauncherUIEventIListener execute");
            if (ao.gJK() && LauncherUI.gIv() && LauncherUI.getInstance() != null) {
                LauncherUI.getInstance().onResume();
            }
            AppMethodBeat.o(232593);
            return true;
        }
    };
    public HomeUI ODR = new HomeUI();
    private o ODS = new o();
    public boolean ODT = false;
    boolean ODU = false;
    private boolean ODV = false;
    private com.tencent.mm.plugin.wallet_index.c.b ODW;
    private t ODX = new t("MicroMsg.LauncherUI");
    private boolean ODZ = false;
    private MMHandler OEa = new MMHandler();
    private Runnable OEb = new Runnable() {
        /* class com.tencent.mm.ui.LauncherUI.AnonymousClass6 */
        long gY = 2000;

        @TargetApi(17)
        public final void run() {
            AppMethodBeat.i(33294);
            Log.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", Long.valueOf(Thread.currentThread().getId()));
            MMHandlerThread.removeRunnable(this);
            if (bg.aVG()) {
                g.aAf();
                Log.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", Integer.valueOf(com.tencent.mm.kernel.a.getUin()));
                AppMethodBeat.o(33294);
            } else if (com.tencent.mm.modelstat.d.bgc() || CrashReportFactory.foreground) {
                this.gY += 2000;
                if (this.gY > 10000) {
                    this.gY = 2000;
                }
                Log.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", Boolean.valueOf(com.tencent.mm.modelstat.d.bgc()), Boolean.valueOf(CrashReportFactory.foreground), Long.valueOf(this.gY));
                MMHandlerThread.postToMainThreadDelayed(this, this.gY);
                AppMethodBeat.o(33294);
            } else {
                Log.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
                if (WXHardCoderJNI.isCheckEnv()) {
                    ThreadPool.post(new Runnable() {
                        /* class com.tencent.mm.ui.LauncherUI.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(258905);
                            WXHardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
                            Log.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp done");
                            AppMethodBeat.o(258905);
                        }
                    }, "terminateApp");
                }
                Log.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
                AppMethodBeat.o(33294);
            }
        }
    };
    private boolean OEc = false;
    int OEd = 0;
    private IListener<abl> Vlq = new IListener<abl>() {
        /* class com.tencent.mm.ui.LauncherUI.AnonymousClass2 */

        {
            AppMethodBeat.i(258900);
            this.__eventId = abl.class.getName().hashCode();
            AppMethodBeat.o(258900);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(abl abl) {
            AppMethodBeat.i(258901);
            Log.i("MicroMsg.LauncherUI", "enterChattingUIEventIListener execute");
            Intent intent = new Intent(LauncherUI.this, LauncherUI.class);
            intent.putExtra("nofification_type", "new_msg_nofification");
            intent.putExtra("Main_User", abl.opW.username);
            intent.putExtra("talkerCount", 1);
            intent.addFlags(536870912);
            intent.addFlags(67108864);
            LauncherUI launcherUI = LauncherUI.this;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(launcherUI, bl.axQ(), "com/tencent/mm/ui/LauncherUI$2", "callback", "(Lcom/tencent/mm/autogen/events/NotifyEnterChattingEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            launcherUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(launcherUI, "com/tencent/mm/ui/LauncherUI$2", "callback", "(Lcom/tencent/mm/autogen/events/NotifyEnterChattingEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(258901);
            return false;
        }
    };
    private NewChattingTabUI chattingTabUI = new NewChattingTabUI(this.ODR);
    private Intent dRc = null;

    /* access modifiers changed from: package-private */
    public interface a {
        boolean gIx();
    }

    /* access modifiers changed from: package-private */
    public interface b {
        void a(HomeUI.FitSystemWindowLayoutView fitSystemWindowLayoutView, Rect rect, ViewGroup viewGroup);

        boolean gHZ();

        void gIb();

        void gIc();
    }

    interface c {
        void gIa();
    }

    interface d {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LauncherUI() {
        AppMethodBeat.i(33295);
        AppMethodBeat.o(33295);
    }

    static /* synthetic */ void a(LauncherUI launcherUI) {
        AppMethodBeat.i(33332);
        launcherUI.Bg(true);
        AppMethodBeat.o(33332);
    }

    static /* synthetic */ void b(LauncherUI launcherUI) {
        AppMethodBeat.i(161501);
        launcherUI.gIu();
        AppMethodBeat.o(161501);
    }

    static {
        AppMethodBeat.i(33334);
        g.b(com.tencent.mm.ui.j.a.class, new com.tencent.mm.ui.j.a() {
            /* class com.tencent.mm.ui.LauncherUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.j.a
            public final Activity gIw() {
                AppMethodBeat.i(258902);
                LauncherUI instance = LauncherUI.getInstance();
                AppMethodBeat.o(258902);
                return instance;
            }
        });
        AppMethodBeat.o(33334);
    }

    public static LauncherUI getInstance() {
        AppMethodBeat.i(33296);
        if (ODL.isEmpty()) {
            Log.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", Util.getStack());
            AppMethodBeat.o(33296);
            return null;
        }
        LauncherUI launcherUI = ODL.get(0);
        AppMethodBeat.o(33296);
        return launcherUI;
    }

    public static int getCurrentTabIndex() {
        AppMethodBeat.i(33297);
        if (getInstance() == null || getInstance().getHomeUI() == null || getInstance().getHomeUI().getMainTabUI() == null) {
            AppMethodBeat.o(33297);
            return -1;
        }
        int i2 = getInstance().getHomeUI().getMainTabUI().acm;
        AppMethodBeat.o(33297);
        return i2;
    }

    private void gIp() {
        AppMethodBeat.i(33298);
        int indexOf = ODL.indexOf(this);
        if (indexOf >= 0) {
            ODL.remove(indexOf);
        }
        Log.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", Integer.valueOf(indexOf), Integer.valueOf(ODL.size()), Integer.valueOf(hashCode()));
        AppMethodBeat.o(33298);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0315  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r16) {
        /*
        // Method dump skipped, instructions count: 1322
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.LauncherUI.onCreate(android.os.Bundle):void");
    }

    private void gIq() {
        boolean z = true;
        AppMethodBeat.i(33300);
        Log.d("MicroMsg.LauncherUI", "[whatsnew] checkIfStartWhatsNew.");
        if (ODY) {
            Log.i("MicroMsg.LauncherUI", "[whatsnew] has been played.");
            AppMethodBeat.o(33300);
        } else if (!g.aAf().azp()) {
            g.aAf();
            if (!com.tencent.mm.kernel.a.azo()) {
                Log.i("MicroMsg.LauncherUI", "[whatsnew] not login yet, skip.");
                AppMethodBeat.o(33300);
                return;
            }
            Log.i("MicroMsg.LauncherUI", "[whatsnew] account not initiate, skip whatsnew.");
            AppMethodBeat.o(33300);
        } else if (!gIr()) {
            Log.i("MicroMsg.LauncherUI", "[whatsnew] notSwitchOrHold is false, skip whatsnew.");
            AppMethodBeat.o(33300);
        } else {
            boolean booleanExtra = IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.enter_from_reg", false);
            boolean gKc = a.C2075a.OLX.gKc();
            if (booleanExtra || com.tencent.mm.pluginsdk.i.c.JYn == null || !com.tencent.mm.pluginsdk.i.c.JYn.Xl() || !bg.aAc() || gKc) {
                c.a aVar = com.tencent.mm.pluginsdk.i.c.JYn;
                Object[] objArr = new Object[5];
                objArr[0] = Boolean.valueOf(booleanExtra);
                objArr[1] = Boolean.valueOf(bg.aAc());
                objArr[2] = Boolean.valueOf(aVar == null);
                if (aVar == null || !aVar.Xl()) {
                    z = false;
                }
                objArr[3] = Boolean.valueOf(z);
                objArr[4] = Boolean.valueOf(gKc);
                Log.i("MicroMsg.LauncherUI", "[whatsnew] do not show whatsnew. enter_from_reg=%s accHasReady=%s MMAppMgr is null %s isWhatsNewAvailable=%s, isAccessibilityEnabled=%s", objArr);
            } else if (MMEntryLock.lock("show_whatsnew")) {
                ODY = true;
                Log.i("MicroMsg.LauncherUI", "[whatsnew] show whatsnew.");
                MMAppMgr.bh(this);
                com.tencent.mm.blink.a.ajZ();
                AppMethodBeat.o(33300);
                return;
            }
            AppMethodBeat.o(33300);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(33301);
        Log.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", Integer.valueOf(hashCode()), Util.getActivityTaskInfo(this));
        this.dRc = intent;
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.dRc == null || !IntentUtil.getBooleanExtra(this.dRc, "LauncherUI.jump_from_uimode_check", false)) {
            q.n(this, "");
            if (gIs()) {
                Log.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
                AppMethodBeat.o(33301);
            } else if (this.dRc == null || !IntentUtil.getBooleanExtra(this.dRc, "Intro_Need_Clear_Top ", false)) {
                if ((intent.getFlags() & 67108864) == 67108864) {
                    closeChatting(false);
                }
                MainTabUI mainTabUI = this.ODR.OCP;
                if ((intent.getFlags() & 67108864) == 67108864) {
                    mainTabUI.OIb = true;
                }
                if (this.ODT) {
                    Log.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
                    bz(intent);
                }
                com.tencent.mm.plugin.t.a.c.eBv().eBu();
                AppMethodBeat.o(33301);
            } else {
                Log.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
                finish();
                jI(this);
                AppMethodBeat.o(33301);
            }
        } else {
            Log.i("MicroMsg.LauncherUI", "dancy onNewIntent uimode check from background, finish LauncherUI");
            finish();
            AppMethodBeat.o(33301);
        }
    }

    private void Bg(boolean z) {
        boolean z2;
        AppMethodBeat.i(33302);
        if (z) {
            new Runnable() {
                /* class com.tencent.mm.ui.LauncherUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(258904);
                    LauncherUI.a(LauncherUI.this);
                    AppMethodBeat.o(258904);
                }
            };
            o.gIz();
        } else {
            if (!this.ODZ) {
                if (!this.ODS.bc(this)) {
                    z2 = true;
                    this.ODZ = z2;
                }
            }
            AppMethodBeat.o(33302);
        }
        z2 = false;
        this.ODZ = z2;
        AppMethodBeat.o(33302);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        String action;
        MainUI mainUI;
        AppMethodBeat.i(33303);
        Log.i("MicroMsg.LauncherUI", "onResume %s", Integer.valueOf(hashCode()));
        super.onResume();
        if (this.ODX.fP("onResume")) {
            Log.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
            AppMethodBeat.o(33303);
            return;
        }
        Log.i("MicroMsg.LauncherUI", "not skip this onResume");
        ODN = false;
        if (gIr()) {
            Log.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", Boolean.valueOf(this.ODT));
            if (!bg.aAc()) {
                Log.w("MicroMsg.LauncherUI", "accHasNotReady, kill self");
                finish();
                Log.i("MicroMsg.LauncherUI", "try to kill mm pid %d", Integer.valueOf(Process.myPid()));
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/ui/LauncherUI", "onResume", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                Process.killProcess(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/ui/LauncherUI", "onResume", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                AppMethodBeat.o(33303);
                return;
            }
            if (!this.ODT) {
                this.ODT = true;
                HomeUI homeUI = this.ODR;
                Log.i("MicroMsg.LauncherUI.HomeUI", "doOnCreate");
                homeUI.OCT = HomeUI.gIf() && HomeUI.gIg();
                i iVar = homeUI.OCO;
                EventCenter.instance.addListener(iVar.OCe);
                EventCenter.instance.addListener(iVar.OCf);
                if (!com.tencent.mm.ui.conversation.b.gVn()) {
                    getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
                }
                SharedPreferences sharedPreferences = homeUI.uLr.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aps());
                if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                    sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                    XLogSetup.realSetupXlog();
                }
                homeUI.OCD = new af(this);
                homeUI.OCv = true;
                NotifyReceiver.akF();
                bg.getNotification().nS(1);
                if (!bg.aAc()) {
                    Log.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
                    homeUI.uLr.finish();
                } else {
                    Log.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
                    long currentTimeMillis = System.currentTimeMillis();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    MMActivity.initLanguage(homeUI.uLr);
                    try {
                        HashSet hashSet = new HashSet();
                        String[] split = homeUI.getString(R.string.bja).split(";");
                        hashSet.add(split[0]);
                        hashSet.add(split[1]);
                        aa.f(hashSet);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e2, "", new Object[0]);
                    }
                    g.aAi();
                    g.aAk().postToWorker(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x08f9: INVOKE  
                          (wrap: com.tencent.mm.sdk.platformtools.MMHandlerThread : 0x08f0: INVOKE  (r0v277 com.tencent.mm.sdk.platformtools.MMHandlerThread) =  type: STATIC call: com.tencent.mm.kernel.g.aAk():com.tencent.mm.sdk.platformtools.MMHandlerThread)
                          (wrap: com.tencent.mm.ui.HomeUI$17 : 0x08f6: CONSTRUCTOR  (r1v222 com.tencent.mm.ui.HomeUI$17) = (r2v76 'homeUI' com.tencent.mm.ui.HomeUI) call: com.tencent.mm.ui.HomeUI.17.<init>(com.tencent.mm.ui.HomeUI):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToWorker(java.lang.Runnable):int in method: com.tencent.mm.ui.LauncherUI.onResume():void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x08f6: CONSTRUCTOR  (r1v222 com.tencent.mm.ui.HomeUI$17) = (r2v76 'homeUI' com.tencent.mm.ui.HomeUI) call: com.tencent.mm.ui.HomeUI.17.<init>(com.tencent.mm.ui.HomeUI):void type: CONSTRUCTOR in method: com.tencent.mm.ui.LauncherUI.onResume():void, file: classes5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 37 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.HomeUI, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 43 more
                        */
                    /*
                    // Method dump skipped, instructions count: 3946
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.LauncherUI.onResume():void");
                }

                private boolean gIr() {
                    AppMethodBeat.i(33304);
                    if (this.dRc == null || IntentUtil.getBooleanExtra(this.dRc, "Intro_Switch", false) || !bg.aVG() || bg.azj()) {
                        AppMethodBeat.o(33304);
                        return false;
                    }
                    AppMethodBeat.o(33304);
                    return true;
                }

                private boolean gIs() {
                    AppMethodBeat.i(33305);
                    if (this.dRc != null) {
                        if (IntentUtil.getBooleanExtra(this.dRc, "absolutely_exit", false) || IntentUtil.getIntExtra(this.dRc, "absolutely_exit_pid", 0) == Process.myPid()) {
                            Log.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", Integer.valueOf(hashCode()));
                            finish();
                            com.tencent.mm.plugin.report.service.g.Wn(8);
                            MMAppMgr.Bj(IntentUtil.getBooleanExtra(this.dRc, "kill_service", true));
                            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                            Object obj = new Object();
                            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "java/lang/System_EXEC_", "exit", "(I)V");
                            System.exit(((Integer) a2.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "java/lang/System_EXEC_", "exit", "(I)V");
                            AppMethodBeat.o(33305);
                            return true;
                        } else if (IntentUtil.getBooleanExtra(this.dRc, "can_finish", false)) {
                            Log.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
                            bg.azz().fx(true);
                            if (l.cK(getApplicationContext())) {
                                com.tencent.mm.booter.b.ce(getApplicationContext());
                            }
                            com.tencent.mm.plugin.report.service.g.Wn(8);
                            sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), WeChatPermissions.PERMISSION_MM_MESSAGE());
                            finish();
                            com.tencent.mm.ui.base.b.kd(this);
                            AppMethodBeat.o(33305);
                            return true;
                        } else if (IntentUtil.getBooleanExtra(this.dRc, "exit_and_restart", false)) {
                            Mars.onSingalCrash(0);
                            Log.i("MicroMsg.LauncherUI", "exit and restart myself.");
                            Log.appenderFlush();
                            finish();
                            Intent intent = new Intent(this, LauncherUI.class);
                            intent.addFlags(67108864);
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            Log.i("MicroMsg.LauncherUI", "restart, try to kill mm pid %d", Integer.valueOf(Process.myPid()));
                            MMAppMgr.gIU();
                            com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                            Object obj2 = new Object();
                            com.tencent.mm.hellhoundlib.a.a.a(obj2, a3.axQ(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                            Process.killProcess(((Integer) a3.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(obj2, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                            AppMethodBeat.o(33305);
                            return true;
                        }
                    }
                    AppMethodBeat.o(33305);
                    return false;
                }

                private void gIt() {
                    AppMethodBeat.i(33306);
                    Log.i("MicroMsg.LauncherUI", "switch to wxid %s", MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", ""));
                    Intent intent = new Intent();
                    intent.setClass(this, SettingsSwitchAccountUI.class);
                    intent.addFlags(536870912);
                    intent.putExtra("key_scene", 1);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.ui.base.b.ke(this);
                    AppMethodBeat.o(33306);
                }

                private void bz(Intent intent) {
                    int i2;
                    int i3;
                    int intExtra;
                    Intent className;
                    AppMethodBeat.i(33307);
                    Log.i("MicroMsg.LauncherUI", "handleJump");
                    if (!bg.aAc()) {
                        Log.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864));
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        finish();
                        AppMethodBeat.o(33307);
                        return;
                    }
                    lr lrVar = new lr();
                    lrVar.dRb.dRc = this.dRc;
                    EventCenter.instance.publish(lrVar);
                    if ("talkroom_notification".equals(IntentUtil.getStringExtra(intent, "nofification_type"))) {
                        String stringExtra = IntentUtil.getStringExtra(intent, "enter_chat_usrname");
                        if (!Util.isNullOrNil(stringExtra)) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("enter_room_username", stringExtra);
                            intent2.setFlags(268435456);
                            com.tencent.mm.br.c.b(this, "talkroom", ".ui.TalkRoomUI", intent2);
                        }
                        AppMethodBeat.o(33307);
                    } else if ("back_to_pcmgr_notification".equals(intent.getStringExtra("nofification_type"))) {
                        if (!intent.getBooleanExtra("newPCBackup", true)) {
                            Log.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BakToPcUI");
                            className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");
                        } else {
                            Log.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
                            className = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
                        }
                        className.setFlags(268435456);
                        MMWizardActivity.ay(this, className);
                        AppMethodBeat.o(33307);
                    } else if ("back_to_pcmgr_error_notification".equals(intent.getStringExtra("nofification_type"))) {
                        Intent className2 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
                        className2.setFlags(268435456);
                        MMWizardActivity.ay(this, className2);
                        AppMethodBeat.o(33307);
                    } else if ("clear_msg_not_finish_notification".equals(intent.getStringExtra("nofification_type"))) {
                        h.n(this, R.string.b5j, R.string.zb);
                        AppMethodBeat.o(33307);
                    } else if ("backup_move_notification".equals(intent.getStringExtra("nofification_type"))) {
                        Intent className3 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
                        className3.setFlags(268435456);
                        MMWizardActivity.ay(this, className3);
                        AppMethodBeat.o(33307);
                    } else {
                        if (IntentUtil.getBooleanExtra(intent, "show_update_dialog", false)) {
                            bA(intent);
                        }
                        String stringExtra2 = IntentUtil.getStringExtra(intent, "Main_User");
                        String stringExtra3 = IntentUtil.getStringExtra(intent, "nofification_type");
                        Log.i("MicroMsg.LauncherUI", "[handleJump] user:%s", stringExtra2);
                        if (stringExtra2 == null || stringExtra2.equals("")) {
                            i2 = 0;
                        } else {
                            bg.aVF();
                            az bjY = com.tencent.mm.model.c.aST().bjY(stringExtra2);
                            if (bjY != null) {
                                i2 = bjY.field_unReadCount;
                            } else {
                                i2 = 0;
                            }
                            Log.i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", stringExtra2, bjY, Integer.valueOf(i2));
                        }
                        if (i2 == 0) {
                            i2 = IntentUtil.getIntExtra(intent, "pushcontent_unread_count", 0);
                        }
                        MMAppMgr.Xc();
                        EventCenter.instance.publish(new ah());
                        boolean booleanExtra = IntentUtil.getBooleanExtra(intent, "Intro_Is_Muti_Talker", true);
                        Log.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", Boolean.valueOf(booleanExtra), Integer.valueOf(i2));
                        if (!booleanExtra && i2 > 0 && (intExtra = IntentUtil.getIntExtra(intent, "Intro_Bottle_unread_count", 0)) > 0) {
                            Log.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", Integer.valueOf(intExtra));
                            com.tencent.mm.br.c.V(this, "bottle", ".ui.BottleConversationUI");
                        }
                        if (!booleanExtra) {
                            if (ab.Jj(stringExtra2)) {
                                Log.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
                                Intent intent3 = new Intent();
                                intent3.addFlags(67108864);
                                intent3.putExtra("type", 20);
                                com.tencent.mm.br.c.b(this, "readerapp", ".ui.ReaderAppUI", intent3);
                            } else if (ab.Jr(stringExtra2)) {
                                Log.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
                                Intent intent4 = new Intent();
                                intent4.addFlags(67108864);
                                intent4.putExtra("type", 11);
                                com.tencent.mm.br.c.b(this, "readerapp", ".ui.ReaderAppUI", intent4);
                            } else {
                                if (intent.getIntExtra("MainUI_User_Last_Msg_Type", 34) == 34) {
                                    i3 = 2;
                                } else {
                                    i3 = 1;
                                }
                                Bundle bundle = new Bundle();
                                bundle.putInt("Chat_Mode", i3);
                                if ("new_msg_nofification".equals(IntentUtil.getStringExtra(intent, "nofification_type"))) {
                                    bundle.putInt("chat_from_scene", 1);
                                    bundle.putBoolean("key_can_show_message_float_ball", true);
                                }
                                LauncherUI instance = getInstance();
                                if (instance != null) {
                                    if (com.tencent.mm.al.g.DQ(stringExtra2)) {
                                        intent.putExtra("Contact_User", stringExtra2);
                                        intent.addFlags(67108864);
                                        intent.putExtra("biz_chat_from_scene", 4);
                                        com.tencent.mm.br.c.f(this, ".ui.bizchat.BizChatConversationUI", intent);
                                    } else if (com.tencent.mm.al.g.Nh(stringExtra2)) {
                                        com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(stringExtra2);
                                        String UJ = fJ == null ? null : fJ.UJ();
                                        if (UJ == null) {
                                            UJ = "";
                                        }
                                        intent.putExtra("rawUrl", UJ);
                                        intent.putExtra("useJs", true);
                                        intent.putExtra("srcUsername", stringExtra2);
                                        intent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                                        intent.addFlags(67108864);
                                        com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", intent);
                                    } else if (as.HF(stringExtra2)) {
                                        intent.putExtra("Contact_User", stringExtra2);
                                        intent.addFlags(67108864);
                                        intent.putExtra("app_brand_conversation_from_scene", 3);
                                        intent.putExtra("finish_direct", true);
                                        intent.putExtra("key_need_send_video", false);
                                        com.tencent.mm.br.c.f(this, ".ui.conversation.AppBrandServiceConversationUI", intent);
                                    } else {
                                        instance.startChatting(stringExtra2, bundle, false);
                                    }
                                }
                            }
                        } else if (IntentUtil.getBooleanExtra(intent, "From_fail_notify", false)) {
                            if (!Util.isNullOrNil(stringExtra2)) {
                                LauncherUI instance2 = getInstance();
                                if (instance2 != null) {
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putBoolean("Chat_Mode", IntentUtil.getBooleanExtra(intent, "resend_fail_messages", false));
                                    if (com.tencent.mm.al.g.DQ(stringExtra2)) {
                                        intent.putExtra("Contact_User", stringExtra2);
                                        intent.addFlags(67108864);
                                        intent.putExtra("biz_chat_from_scene", 4);
                                        com.tencent.mm.br.c.f(this, ".ui.bizchat.BizChatConversationUI", intent);
                                    } else {
                                        instance2.startChatting(stringExtra2, bundle2, false);
                                    }
                                }
                            } else if (IntentUtil.getBooleanExtra(intent, "jump_sns_from_notify", false)) {
                                Intent intent5 = new Intent();
                                intent5.addFlags(67108864);
                                intent5.putExtra("is_need_resend_sns", intent.getBooleanExtra("is_need_resend_sns", false));
                                intent5.putExtra("sns_resume_state", intent.getBooleanExtra("sns_resume_state", false));
                                intent5.putExtra("sns_timeline_NeedFirstLoadint", intent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
                                com.tencent.mm.br.c.b(this, "sns", ".ui.SnsTimeLineUI", intent5);
                            }
                        } else if (IntentUtil.getBooleanExtra(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                            if (getInstance() != null && com.tencent.mm.al.g.DQ(stringExtra2)) {
                                intent.putExtra("Contact_User", stringExtra2);
                                intent.addFlags(67108864);
                                com.tencent.mm.br.c.f(this, ".ui.bizchat.BizChatConversationUI", intent);
                            }
                        } else if (!Util.isNullOrNil(stringExtra2) && "new_msg_nofification".equals(stringExtra3)) {
                            Object[] objArr = new Object[1];
                            objArr[0] = intent == null ? BuildConfig.COMMAND : intent;
                            Log.w("MicroMsg.LauncherUI", "[handleJump] intent:%s", objArr);
                            LauncherUI instance3 = getInstance();
                            Bundle bundle3 = new Bundle();
                            bundle3.putInt("chat_from_scene", 1);
                            bundle3.putBoolean("key_can_show_message_float_ball", true);
                            if (instance3 != null) {
                                instance3.startChatting(stringExtra2, bundle3, false);
                            } else {
                                Log.w("MicroMsg.LauncherUI", "LauncherUI.getInstance is null! ");
                            }
                        }
                        if (IntentUtil.getIntExtra(intent, "kstyle_show_bind_mobile_afterauth", 0) > 0) {
                            Intent intent6 = new Intent();
                            intent6.setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMobileUI");
                            intent6.putExtra("kstyle_bind_recommend_show", intent.getIntExtra("kstyle_bind_recommend_show", 0));
                            intent6.putExtra("kstyle_bind_wording", intent.getParcelableExtra("kstyle_bind_wording"));
                            MMWizardActivity.ay(this, intent6);
                        }
                        AppMethodBeat.o(33307);
                    }
                }

                private void gIu() {
                    AppMethodBeat.i(33308);
                    Log.i("MicroMsg.LauncherUI", "resumeLogoutJump");
                    if (this.dRc == null || !IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)) {
                        String stringExtra = IntentUtil.getStringExtra(getIntent(), "LauncherUI.Shortcut.LaunchType");
                        if (stringExtra != null) {
                            if (stringExtra.equals("launch_type_scan_qrcode")) {
                                ks ksVar = new ks();
                                ksVar.elF = 2;
                                ksVar.eXj = 2;
                                ksVar.bfK();
                                com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
                                com.tencent.mm.util.b.a(ksVar);
                            } else if (stringExtra.equals("launch_type_offline_wallet")) {
                                ks ksVar2 = new ks();
                                ksVar2.elF = 1;
                                ksVar2.eXj = 2;
                                ksVar2.bfK();
                                com.tencent.mm.util.b bVar2 = com.tencent.mm.util.b.QYu;
                                com.tencent.mm.util.b.a(ksVar2);
                            } else if (stringExtra.equals("launch_type_my_qrcode")) {
                                ks ksVar3 = new ks();
                                ksVar3.elF = 3;
                                ksVar3.eXj = 2;
                                ksVar3.bfK();
                                com.tencent.mm.util.b bVar3 = com.tencent.mm.util.b.QYu;
                                com.tencent.mm.util.b.a(ksVar3);
                            }
                        }
                        MMFragmentActivity.a.gIV();
                        MMFragmentActivity.a.gIV();
                        aw.kA(MMApplicationContext.getContext());
                        aw.aoh(2);
                        String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "");
                        if (bg.aVG() || !aA.equals("")) {
                            Log.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", Boolean.valueOf(this.ODT), Boolean.valueOf((this.dRc.getFlags() & 67108864) == 67108864), Boolean.valueOf(IntentUtil.getBooleanExtra(this.dRc, "Intro_Notify", false)), Boolean.valueOf(bg.azj()));
                            Log.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", Boolean.valueOf(bg.aVG()));
                            bg.hold();
                            if (IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
                                this.ODV = true;
                            }
                            jH(this);
                            bg.unhold();
                            AppMethodBeat.o(33308);
                            return;
                        }
                        Intent intent = new Intent(this, WelcomeActivity.class);
                        intent.addFlags(536870912);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        com.tencent.mm.ui.base.b.ke(this);
                        Log.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
                        MMHandlerThread.removeRunnable(this.OEb);
                        MMHandlerThread.postToMainThreadDelayed(this.OEb, 2000);
                        AppMethodBeat.o(33308);
                        return;
                    }
                    Log.i("MicroMsg.LauncherUI", "dancy uimode check from background, not jumpToLogin or welcome!");
                    AppMethodBeat.o(33308);
                }

                private void jH(Context context) {
                    AppMethodBeat.i(33309);
                    if (IntentUtil.getBooleanExtra(this.dRc, "LauncherUI.jump_switch_account", false)) {
                        Log.i("MicroMsg.LauncherUI", "launcher to switch account");
                        gIt();
                        AppMethodBeat.o(33309);
                    } else if (IntentUtil.getBooleanExtra(this.dRc, "Intro_Switch", false) || this.ODT || com.tencent.mm.kernel.a.ayY()) {
                        this.ODR.getMainTabUI().cpB();
                        g.aAi().FS("[normal logout]");
                        Mars.onSingalCrash(0);
                        Log.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
                        Log.appenderFlush();
                        finish();
                        Intent intent = new Intent(context, LauncherUI.class);
                        intent.putExtra("key_errType", IntentUtil.getIntExtra(this.dRc, "key_errType", 0));
                        intent.putExtra("key_errCode", IntentUtil.getIntExtra(this.dRc, "key_errCode", 0));
                        intent.putExtra("key_errMsg", IntentUtil.getStringExtra(this.dRc, "key_errMsg"));
                        intent.addFlags(67108864);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        Log.i("MicroMsg.LauncherUI", "try to kill mm pid %d", Integer.valueOf(Process.myPid()));
                        MMAppMgr.gIU();
                        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                        Object obj = new Object();
                        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                        Process.killProcess(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                        AppMethodBeat.o(33309);
                    } else {
                        if (!IntentUtil.getBooleanExtra(this.dRc, "LauncherUI.jump_switch_account", false)) {
                            String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "");
                            Log.i("MicroMsg.LauncherUI", "%s jumpToLogin", aA);
                            if (Util.isNullOrNil(aA)) {
                                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, WelcomeActivity.class));
                                com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                startActivity((Intent) bl2.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                com.tencent.mm.ui.base.b.ke(this);
                            } else {
                                boolean z = MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false);
                                Log.i("MicroMsg.LauncherUI", "switchAccount %s", Boolean.valueOf(z));
                                if (z) {
                                    Intent intent2 = new Intent(this, SettingsSwitchAccountUI.class);
                                    intent2.addFlags(536870912);
                                    intent2.putExtra("key_scene", 2);
                                    com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    startActivity((Intent) bl3.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    com.tencent.mm.ui.base.b.kb(this);
                                } else {
                                    int safeParseInt = Util.safeParseInt(bf.iDu.aA("last_login_use_voice", ""));
                                    Log.i("MicroMsg.LauncherUI", "pluginSwitch  ".concat(String.valueOf(safeParseInt)));
                                    Intent intent3 = new Intent();
                                    intent3.putExtra("key_errType", IntentUtil.getIntExtra(this.dRc, "key_errType", 0));
                                    intent3.putExtra("key_errCode", IntentUtil.getIntExtra(this.dRc, "key_errCode", 0));
                                    intent3.putExtra("key_errMsg", IntentUtil.getStringExtra(this.dRc, "key_errMsg"));
                                    if (WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned() || (safeParseInt & 131072) == 0) {
                                        intent3.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI");
                                    } else {
                                        intent3.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI");
                                    }
                                    intent3.addFlags(536870912);
                                    com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, bl4.axQ(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    startActivity((Intent) bl4.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    com.tencent.mm.ui.base.b.kb(this);
                                }
                            }
                            com.tencent.mm.plugin.report.service.g.Wn(8);
                            MMHandlerThread.removeRunnable(this.OEb);
                            MMHandlerThread.postToMainThreadDelayed(this.OEb, 2000);
                        }
                        AppMethodBeat.o(33309);
                    }
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onActivityResult(int i2, int i3, Intent intent) {
                    boolean z;
                    Bundle bundleExtra;
                    Bundle bundle = null;
                    AppMethodBeat.i(33310);
                    super.onActivityResult(i2, i3, intent);
                    Log.v("MicroMsg.LauncherUI", "edw on activity result");
                    NewChattingTabUI newChattingTabUI = this.chattingTabUI;
                    if ((i2 == 2001 || i2 == 30763 || i2 == 226 || i2 == 3001 || i2 == 30762 || i2 == 1111) && newChattingTabUI.OJN != null) {
                        newChattingTabUI.OJN.onActivityResult(i2, i3, intent);
                    }
                    if (!NewChattingTabUI.acceptRequestCode(i2) || newChattingTabUI.OJN != null) {
                        z = false;
                    } else {
                        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
                        MMHandlerThread.removeRunnable(newChattingTabUI.OJP);
                        newChattingTabUI.OJP.OJY = 0;
                        newChattingTabUI.OJP.requestCode = i2;
                        newChattingTabUI.OJP.resultCode = i3;
                        newChattingTabUI.OJP.dQs = intent;
                        MMHandlerThread.postToMainThread(newChattingTabUI.OJP);
                        z = true;
                    }
                    if (z) {
                        AppMethodBeat.o(33310);
                        return;
                    }
                    HomeUI homeUI = this.ODR;
                    if (homeUI.OCv) {
                        if (i2 == 1) {
                            bg.aVF();
                            if (!Util.nullAsFalse((Boolean) com.tencent.mm.model.c.azQ().get(12323, (Object) null))) {
                                y.showAddrBookUploadConfirm(homeUI.uLr, null, false, 3);
                            }
                            AppMethodBeat.o(33310);
                            return;
                        }
                        if (i2 == 22722) {
                            String str = (String) g.aAh().azQ().get(274436, (Object) null);
                            Log.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                            if (intent != null) {
                                bundle = intent.getBundleExtra("result_data");
                            }
                            if (bundle == null || !bundle.getString("go_next", "").equals("agree_privacy")) {
                                Log.i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
                                g.azz().a(new com.tencent.mm.plugin.account.model.h(2, str), 0);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(712, 5, 1, false);
                            } else {
                                Log.i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(712, 4, 1, false);
                                g.azz().a(new com.tencent.mm.plugin.account.model.h(1, str), 0);
                                if (com.tencent.mm.aw.b.Pi(str) && g.aAh().azQ().getBoolean(ar.a.USERINFO_NEED_BIRTHDAY_BOOLEAN_SYNC, false)) {
                                    Log.i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
                                    MMHandlerThread.postToMainThreadDelayed(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0129: INVOKE  
                                          (wrap: com.tencent.mm.ui.HomeUI$27 : 0x0124: CONSTRUCTOR  (r0v39 com.tencent.mm.ui.HomeUI$27) = (r10v0 'homeUI' com.tencent.mm.ui.HomeUI) call: com.tencent.mm.ui.HomeUI.27.<init>(com.tencent.mm.ui.HomeUI):void type: CONSTRUCTOR)
                                          (100 long)
                                         type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThreadDelayed(java.lang.Runnable, long):void in method: com.tencent.mm.ui.LauncherUI.onActivityResult(int, int, android.content.Intent):void, file: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0124: CONSTRUCTOR  (r0v39 com.tencent.mm.ui.HomeUI$27) = (r10v0 'homeUI' com.tencent.mm.ui.HomeUI) call: com.tencent.mm.ui.HomeUI.27.<init>(com.tencent.mm.ui.HomeUI):void type: CONSTRUCTOR in method: com.tencent.mm.ui.LauncherUI.onActivityResult(int, int, android.content.Intent):void, file: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 42 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.HomeUI, state: GENERATED_AND_UNLOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 48 more
                                        */
                                    /*
                                    // Method dump skipped, instructions count: 564
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.LauncherUI.onActivityResult(int, int, android.content.Intent):void");
                                }

                                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                                public void onPause() {
                                    AppMethodBeat.i(33311);
                                    Log.d("MicroMsg.LauncherUI", "onPause %s, chatting is show ", Integer.valueOf(hashCode()));
                                    super.onPause();
                                    t tVar = this.ODX;
                                    boolean fP = tVar.fP("onPause");
                                    if (fP) {
                                        tVar.JTe = false;
                                    }
                                    if (fP) {
                                        Log.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
                                        AppMethodBeat.o(33311);
                                        return;
                                    }
                                    com.tencent.mm.blink.a.ajZ();
                                    Log.i("MicroMsg.LauncherUI", "not skip this onPause");
                                    MMFragment currentFragmet = getCurrentFragmet();
                                    this.OEa.removeCallbacksAndMessages(null);
                                    if (!ao.gJK()) {
                                        this.ODR.gHP();
                                        this.chattingTabUI.gHP();
                                    }
                                    if (currentFragmet != null) {
                                        AppMethodBeat.o(33311);
                                        return;
                                    }
                                    this.ODU = false;
                                    r rVar = r.NPl;
                                    r.gzU();
                                    AppMethodBeat.o(33311);
                                }

                                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                                public void onStop() {
                                    AppMethodBeat.i(33312);
                                    Log.i("MicroMsg.LauncherUI", "onStop %s", Integer.valueOf(hashCode()));
                                    com.tencent.mm.blink.a.ajZ();
                                    if (ao.gJK()) {
                                        this.ODR.gHP();
                                        this.chattingTabUI.gHP();
                                    }
                                    ((s) g.ah(s.class)).getSysCmdMsgExtension().b("showprivacypolicy", this.ODR.ODo);
                                    super.onStop();
                                    AppMethodBeat.o(33312);
                                }

                                @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
                                public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                                    AppMethodBeat.i(33313);
                                    this.ODZ = false;
                                    if (!this.ODS.a(this, i2, strArr, iArr)) {
                                        HomeUI homeUI = this.ODR;
                                        switch (i2) {
                                            case 16:
                                            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                                                int i3 = i2 == 80 ? R.string.flb : R.string.fl0;
                                                if (iArr[0] != 0) {
                                                    h.a((Context) homeUI.uLr, homeUI.getString(i3), homeUI.getString(R.string.flp), homeUI.getString(R.string.e_k), homeUI.getString(R.string.amn), false, (DialogInterface.OnClickListener) 
                                                    /*  JADX ERROR: Method code generation error
                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005c: INVOKE  
                                                          (wrap: android.content.Context : ?: CAST (android.content.Context) (wrap: com.tencent.mm.ui.MMFragmentActivity : 0x0040: IGET  (r0v22 com.tencent.mm.ui.MMFragmentActivity) = (r8v0 'homeUI' com.tencent.mm.ui.HomeUI) com.tencent.mm.ui.HomeUI.uLr com.tencent.mm.ui.MMFragmentActivity))
                                                          (wrap: java.lang.String : 0x0042: INVOKE  (r1v12 java.lang.String) = (r8v0 'homeUI' com.tencent.mm.ui.HomeUI), (r1v11 'i3' int) type: VIRTUAL call: com.tencent.mm.ui.HomeUI.getString(int):java.lang.String)
                                                          (wrap: java.lang.String : 0x0046: INVOKE  (r2v5 java.lang.String) = (r8v0 'homeUI' com.tencent.mm.ui.HomeUI), (wrap: int : ?: SGET   com.tencent.mm.R.string.flp int) type: VIRTUAL call: com.tencent.mm.ui.HomeUI.getString(int):java.lang.String)
                                                          (wrap: java.lang.String : 0x004a: INVOKE  (r3v5 java.lang.String) = (r8v0 'homeUI' com.tencent.mm.ui.HomeUI), (wrap: int : ?: SGET   com.tencent.mm.R.string.e_k int) type: VIRTUAL call: com.tencent.mm.ui.HomeUI.getString(int):java.lang.String)
                                                          (wrap: java.lang.String : 0x004e: INVOKE  (r4v6 java.lang.String) = (r8v0 'homeUI' com.tencent.mm.ui.HomeUI), (wrap: int : ?: SGET   com.tencent.mm.R.string.amn int) type: VIRTUAL call: com.tencent.mm.ui.HomeUI.getString(int):java.lang.String)
                                                          false
                                                          (wrap: android.content.DialogInterface$OnClickListener : ?: CAST (android.content.DialogInterface$OnClickListener) (wrap: com.tencent.mm.ui.HomeUI$28 : 0x0054: CONSTRUCTOR  (r6v4 com.tencent.mm.ui.HomeUI$28) = (r8v0 'homeUI' com.tencent.mm.ui.HomeUI) call: com.tencent.mm.ui.HomeUI.28.<init>(com.tencent.mm.ui.HomeUI):void type: CONSTRUCTOR))
                                                          (wrap: android.content.DialogInterface$OnClickListener : ?: CAST (android.content.DialogInterface$OnClickListener) (wrap: com.tencent.mm.ui.HomeUI$29 : 0x0059: CONSTRUCTOR  (r7v4 com.tencent.mm.ui.HomeUI$29) = (r8v0 'homeUI' com.tencent.mm.ui.HomeUI) call: com.tencent.mm.ui.HomeUI.29.<init>(com.tencent.mm.ui.HomeUI):void type: CONSTRUCTOR))
                                                         type: STATIC call: com.tencent.mm.ui.base.h.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, android.content.DialogInterface$OnClickListener, android.content.DialogInterface$OnClickListener):com.tencent.mm.ui.widget.a.d in method: com.tencent.mm.ui.LauncherUI.onRequestPermissionsResult(int, java.lang.String[], int[]):void, file: classes5.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: CAST (android.content.DialogInterface$OnClickListener) (wrap: com.tencent.mm.ui.HomeUI$28 : 0x0054: CONSTRUCTOR  (r6v4 com.tencent.mm.ui.HomeUI$28) = (r8v0 'homeUI' com.tencent.mm.ui.HomeUI) call: com.tencent.mm.ui.HomeUI.28.<init>(com.tencent.mm.ui.HomeUI):void type: CONSTRUCTOR) in method: com.tencent.mm.ui.LauncherUI.onRequestPermissionsResult(int, java.lang.String[], int[]):void, file: classes5.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                        	... 29 more
                                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0054: CONSTRUCTOR  (r6v4 com.tencent.mm.ui.HomeUI$28) = (r8v0 'homeUI' com.tencent.mm.ui.HomeUI) call: com.tencent.mm.ui.HomeUI.28.<init>(com.tencent.mm.ui.HomeUI):void type: CONSTRUCTOR in method: com.tencent.mm.ui.LauncherUI.onRequestPermissionsResult(int, java.lang.String[], int[]):void, file: classes5.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:290)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	... 35 more
                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.HomeUI, state: GENERATED_AND_UNLOADED
                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                        	... 39 more
                                                        */
                                                    /*
                                                    // Method dump skipped, instructions count: 316
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.LauncherUI.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
                                                }

                                                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                                                public void onDestroy() {
                                                    AppMethodBeat.i(33314);
                                                    com.tencent.mm.blink.a.ajZ();
                                                    super.onDestroy();
                                                    HomeUI homeUI = this.ODR;
                                                    homeUI.OCP.cpB();
                                                    if (homeUI.OCO != null) {
                                                        i iVar = homeUI.OCO;
                                                        EventCenter.instance.removeListener(iVar.OCe);
                                                        EventCenter.instance.removeListener(iVar.OCf);
                                                    }
                                                    if (homeUI.OCv) {
                                                        Looper.myQueue().removeIdleHandler(homeUI.pzA);
                                                    }
                                                    EventCenter.instance.removeListener(homeUI.ODk);
                                                    NewChattingTabUI newChattingTabUI = this.chattingTabUI;
                                                    if (newChattingTabUI.mPrepareBitmap != null && !newChattingTabUI.mPrepareBitmap.isRecycled()) {
                                                        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", newChattingTabUI.mPrepareBitmap.toString());
                                                        newChattingTabUI.mPrepareBitmap.recycle();
                                                    }
                                                    MMHandlerThread.removeRunnable(newChattingTabUI.mStartChattingRunnable);
                                                    Looper.myQueue().removeIdleHandler(newChattingTabUI.OJI);
                                                    if (this.ODW != null) {
                                                        com.tencent.mm.plugin.wallet_index.c.b bVar = this.ODW;
                                                        Log.i("MicroMsg.HKOfflineLogic", "doOnDestroy");
                                                        bVar.mContext = null;
                                                        bVar.jUC = null;
                                                        bVar.IqH = false;
                                                        bVar.IqI = null;
                                                        g.azz().b(2540, bVar);
                                                        this.ODW = null;
                                                    }
                                                    this.ODQ.dead();
                                                    this.Vlq.dead();
                                                    gIp();
                                                    Log.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), Util.getActivityTaskInfo(this), Integer.valueOf(ODL.size()));
                                                    AppMethodBeat.o(33314);
                                                }

                                                private void bA(Intent intent) {
                                                    AppMethodBeat.i(33315);
                                                    int intExtra = IntentUtil.getIntExtra(intent, "update_type", -1);
                                                    if (intExtra == -1) {
                                                        Log.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
                                                        AppMethodBeat.o(33315);
                                                        return;
                                                    }
                                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(405, 28, 1, true);
                                                    if (com.tencent.mm.plugin.p.d.elq() != null) {
                                                        com.tencent.mm.plugin.p.a c2 = com.tencent.mm.plugin.p.d.elq().c(this, null);
                                                        if (c2 == null) {
                                                            AppMethodBeat.o(33315);
                                                            return;
                                                        } else {
                                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(405, intExtra == 2 ? 29 : 30, 1, true);
                                                            c2.update(intExtra);
                                                        }
                                                    }
                                                    AppMethodBeat.o(33315);
                                                }

                                                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
                                                public void finish() {
                                                    AppMethodBeat.i(33316);
                                                    super.finish();
                                                    gIp();
                                                    Log.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", Integer.valueOf(hashCode()), Integer.valueOf(ODL.size()), Util.getStack());
                                                    AppMethodBeat.o(33316);
                                                }

                                                @Override // com.tencent.mm.ui.widget.h.a, com.tencent.mm.ui.MMFragmentActivity
                                                public void onSwipe(float f2) {
                                                    boolean z = true;
                                                    AppMethodBeat.i(33317);
                                                    if (this.ODT) {
                                                        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
                                                        Object[] objArr = new Object[3];
                                                        objArr[0] = Float.valueOf(f2);
                                                        objArr[1] = 260L;
                                                        objArr[2] = Boolean.valueOf(newChattingTabUI.OJE != null && newChattingTabUI.OJE.gHZ());
                                                        Log.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", objArr);
                                                        if (newChattingTabUI.gJv()) {
                                                            if (f2 == 0.0f && !newChattingTabUI.mChattingClosed) {
                                                                newChattingTabUI.alj(0);
                                                                ImageView imageView = (ImageView) newChattingTabUI.Dpx.getWindow().getDecorView().findViewById(R.id.gga);
                                                                if (imageView != null) {
                                                                    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE no cache!");
                                                                    imageView.setVisibility(8);
                                                                    imageView.setImageDrawable(null);
                                                                }
                                                                if (newChattingTabUI.mChattingInAnim != null) {
                                                                    newChattingTabUI.mChattingInAnim.cancel();
                                                                }
                                                            } else if (f2 == 1.0f && !newChattingTabUI.mChattingClosed && !newChattingTabUI.OJN.gNe()) {
                                                                newChattingTabUI.Dpx.getWindow().setBackgroundDrawableResource(R.color.a5p);
                                                                ImageView imageView2 = (ImageView) newChattingTabUI.Dpx.getWindow().getDecorView().findViewById(R.id.gga);
                                                                if (!(imageView2 == null || imageView2.getVisibility() != 0 || imageView2.getTag() == null)) {
                                                                    ((View) imageView2.getTag()).setVisibility(0);
                                                                    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
                                                                    imageView2.setVisibility(8);
                                                                    imageView2.setVisibility(8);
                                                                }
                                                                if (newChattingTabUI.OJN.getContentView() == null || newChattingTabUI.OJN.getContentView().getX() > 0.0f) {
                                                                    newChattingTabUI.alj(0);
                                                                } else {
                                                                    newChattingTabUI.alj(8);
                                                                }
                                                            }
                                                            if (!newChattingTabUI.OJE.gHZ()) {
                                                                if (Float.compare(1.0f, f2) > 0) {
                                                                    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", Boolean.FALSE);
                                                                    z = false;
                                                                } else {
                                                                    z = false;
                                                                }
                                                            }
                                                            if (newChattingTabUI.Dpx != null) {
                                                                View findViewById = newChattingTabUI.Dpx.findViewById(R.id.e8x);
                                                                ImageView imageView3 = (ImageView) newChattingTabUI.Dpx.findViewById(R.id.gga);
                                                                if (!(imageView3 == null || imageView3.getVisibility() != 8 || imageView3.getDrawable() == null || newChattingTabUI.mChattingClosed || f2 == 1.0f || f2 == 0.0f)) {
                                                                    imageView3.setVisibility(0);
                                                                    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
                                                                    newChattingTabUI.alj(8);
                                                                }
                                                                NewChattingTabUI.resetViewTranX(findViewById, imageView3, f2);
                                                            }
                                                        }
                                                        if (!z) {
                                                            super.onSwipe(f2);
                                                        }
                                                    }
                                                    AppMethodBeat.o(33317);
                                                }

                                                @Override // com.tencent.mm.ui.widget.h.a, com.tencent.mm.ui.MMFragmentActivity
                                                public void onSettle(boolean z, int i2) {
                                                    AppMethodBeat.i(33318);
                                                    if (this.ODT && !this.chattingTabUI.ac(z, i2)) {
                                                        super.onSettle(z, i2);
                                                    }
                                                    AppMethodBeat.o(33318);
                                                }

                                                @Override // com.tencent.mm.ui.widget.h.a, com.tencent.mm.ui.MMFragmentActivity
                                                public boolean forceRemoveNoMatchOnPath() {
                                                    return true;
                                                }

                                                /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
                                                @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
                                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                                public boolean dispatchKeyEvent(android.view.KeyEvent r8) {
                                                    /*
                                                    // Method dump skipped, instructions count: 179
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.LauncherUI.dispatchKeyEvent(android.view.KeyEvent):boolean");
                                                }

                                                @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
                                                public void onBackPressed() {
                                                    AppMethodBeat.i(33320);
                                                    Log.i("MicroMsg.LauncherUI", "onBackPressed");
                                                    Intent intent = new Intent("android.intent.action.MAIN");
                                                    intent.addCategory("android.intent.category.HOME");
                                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/LauncherUI", "onBackPressed", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                                    startActivity((Intent) bl.pG(0));
                                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "onBackPressed", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                                    AppMethodBeat.o(33320);
                                                }

                                                @Override // com.tencent.mm.ui.component.UIComponentActivity
                                                public void onRestoreInstanceState(Bundle bundle) {
                                                    AppMethodBeat.i(33321);
                                                    super.onRestoreInstanceState(bundle);
                                                    NewChattingTabUI newChattingTabUI = this.chattingTabUI;
                                                    newChattingTabUI.OJK = bundle.getString("last_restore_talker");
                                                    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", newChattingTabUI.OJK);
                                                    this.OEc = bundle.getBoolean("last_stay_chatting");
                                                    this.OEd = bundle.getInt("last_stay_tab");
                                                    if (this.OEc) {
                                                        this.chattingTabUI.startChatting(this.chattingTabUI.OJK, null, false);
                                                    }
                                                    AppMethodBeat.o(33321);
                                                }

                                                @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                                                public void onSaveInstanceState(Bundle bundle) {
                                                    boolean z = true;
                                                    AppMethodBeat.i(33322);
                                                    super.onSaveInstanceState(bundle);
                                                    NewChattingTabUI newChattingTabUI = this.chattingTabUI;
                                                    if (newChattingTabUI.OJN != null) {
                                                        String talkerUserName = newChattingTabUI.OJN.dom.getTalkerUserName();
                                                        if (!Util.isNullOrNil(talkerUserName)) {
                                                            Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "onSaveInstanceState:%s", talkerUserName);
                                                            bundle.putString("last_restore_talker", talkerUserName);
                                                        }
                                                    }
                                                    if (getCurrentFragmet() == null) {
                                                        z = false;
                                                    }
                                                    bundle.putBoolean("last_stay_chatting", z);
                                                    bundle.putInt("last_stay_tab", getCurrentTabIndex());
                                                    AppMethodBeat.o(33322);
                                                }

                                                public boolean onOptionsItemSelected(MenuItem menuItem) {
                                                    boolean z = false;
                                                    AppMethodBeat.i(33323);
                                                    HomeUI homeUI = this.ODR;
                                                    MMFragment currentFragmet = homeUI.uLr.getCurrentFragmet();
                                                    if ((currentFragmet == null || !currentFragmet.isShowing()) && !homeUI.OCN.gIx()) {
                                                        if (menuItem.getItemId() == HomeUI.OCX) {
                                                            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10919, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                                            homeUI.gHT();
                                                        } else if (menuItem.getItemId() == HomeUI.OCW) {
                                                            homeUI.gHV();
                                                        } else if (menuItem.getItemId() == 5) {
                                                            if (CrashReportFactory.hasDebuger() || ac.jPA) {
                                                                com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(homeUI.uLr);
                                                                lVar.HLX = 
                                                                /*  JADX ERROR: Method code generation error
                                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0066: IPUT  
                                                                      (wrap: com.tencent.mm.ui.HomeUI$13 : 0x0063: CONSTRUCTOR  (r3v8 com.tencent.mm.ui.HomeUI$13) = (r2v0 'homeUI' com.tencent.mm.ui.HomeUI) call: com.tencent.mm.ui.HomeUI.13.<init>(com.tencent.mm.ui.HomeUI):void type: CONSTRUCTOR)
                                                                      (r1v2 'lVar' com.tencent.mm.ui.tools.l)
                                                                     com.tencent.mm.ui.tools.l.HLX com.tencent.mm.ui.base.o$f in method: com.tencent.mm.ui.LauncherUI.onOptionsItemSelected(android.view.MenuItem):boolean, file: classes5.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0063: CONSTRUCTOR  (r3v8 com.tencent.mm.ui.HomeUI$13) = (r2v0 'homeUI' com.tencent.mm.ui.HomeUI) call: com.tencent.mm.ui.HomeUI.13.<init>(com.tencent.mm.ui.HomeUI):void type: CONSTRUCTOR in method: com.tencent.mm.ui.LauncherUI.onOptionsItemSelected(android.view.MenuItem):boolean, file: classes5.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                    	... 33 more
                                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.HomeUI, state: GENERATED_AND_UNLOADED
                                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                    	... 37 more
                                                                    */
                                                                /*
                                                                // Method dump skipped, instructions count: 127
                                                                */
                                                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.LauncherUI.onOptionsItemSelected(android.view.MenuItem):boolean");
                                                            }

                                                            public boolean onCreateOptionsMenu(Menu menu) {
                                                                int i2;
                                                                AppMethodBeat.i(33324);
                                                                if (this.chattingTabUI.gIx()) {
                                                                    AppMethodBeat.o(33324);
                                                                    return false;
                                                                }
                                                                HomeUI homeUI = this.ODR;
                                                                if (homeUI.OCN == null || homeUI.OCN.gIx()) {
                                                                    AppMethodBeat.o(33324);
                                                                    return false;
                                                                }
                                                                homeUI.ODi = menu;
                                                                int height = homeUI.uLr.getSupportActionBar().getHeight();
                                                                int aH = com.tencent.mm.cb.a.aH(homeUI.uLr, R.dimen.cl);
                                                                if (homeUI.OCP.acm != 3 || !o.isShowStoryCheck() || p.fvC() || (ao.gJK() && ao.gJM())) {
                                                                    if (height == 0) {
                                                                        DisplayMetrics displayMetrics = homeUI.uLr.getResources().getDisplayMetrics();
                                                                        i2 = displayMetrics.widthPixels > displayMetrics.heightPixels ? homeUI.uLr.getResources().getDimensionPixelSize(R.dimen.b8) : homeUI.uLr.getResources().getDimensionPixelSize(R.dimen.b9);
                                                                    } else {
                                                                        i2 = height;
                                                                    }
                                                                    homeUI.ODe = menu.add(0, HomeUI.OCW, 0, R.string.hpa);
                                                                    homeUI.ODe.setIcon(R.raw.actionbar_icon_dark_search);
                                                                    if (homeUI.OxS) {
                                                                        homeUI.ODe.setIcon(R.raw.actionbar_icon_light_search);
                                                                    }
                                                                    if (homeUI.Oyi == null) {
                                                                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(aH, i2);
                                                                        com.tencent.mm.kiss.a.b.aBh();
                                                                        homeUI.Oyi = com.tencent.mm.kiss.a.b.c(homeUI.uLr, R.layout.bm);
                                                                        homeUI.ODc = (ImageView) homeUI.Oyi.findViewById(R.id.dt5);
                                                                        homeUI.Oyi.setLayoutParams(layoutParams);
                                                                        homeUI.Oyi.setMinimumHeight(i2);
                                                                        homeUI.Oyi.setMinimumWidth(aH);
                                                                        homeUI.ODc.setImageResource(R.raw.actionbar_icon_dark_search);
                                                                        homeUI.ODc.setImageDrawable(ar.e(homeUI.uLr.getResources().getDrawable(R.raw.actionbar_icon_dark_search), homeUI.uLr.getResources().getColor(R.color.FG_0)));
                                                                        homeUI.Oyi.setContentDescription(homeUI.getString(R.string.hpa));
                                                                        homeUI.Oyi.setOnLongClickListener(
                                                                        /*  JADX ERROR: Method code generation error
                                                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0198: INVOKE  
                                                                              (wrap: android.view.View : 0x0191: IGET  (r0v43 android.view.View) = (r3v0 'homeUI' com.tencent.mm.ui.HomeUI) com.tencent.mm.ui.HomeUI.Oyi android.view.View)
                                                                              (wrap: com.tencent.mm.ui.HomeUI$8 : 0x0195: CONSTRUCTOR  (r5v12 com.tencent.mm.ui.HomeUI$8) = (r3v0 'homeUI' com.tencent.mm.ui.HomeUI) call: com.tencent.mm.ui.HomeUI.8.<init>(com.tencent.mm.ui.HomeUI):void type: CONSTRUCTOR)
                                                                             type: VIRTUAL call: android.view.View.setOnLongClickListener(android.view.View$OnLongClickListener):void in method: com.tencent.mm.ui.LauncherUI.onCreateOptionsMenu(android.view.Menu):boolean, file: classes5.dex
                                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                                                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0195: CONSTRUCTOR  (r5v12 com.tencent.mm.ui.HomeUI$8) = (r3v0 'homeUI' com.tencent.mm.ui.HomeUI) call: com.tencent.mm.ui.HomeUI.8.<init>(com.tencent.mm.ui.HomeUI):void type: CONSTRUCTOR in method: com.tencent.mm.ui.LauncherUI.onCreateOptionsMenu(android.view.Menu):boolean, file: classes5.dex
                                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                            	... 32 more
                                                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.HomeUI, state: GENERATED_AND_UNLOADED
                                                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                            	... 38 more
                                                                            */
                                                                        /*
                                                                        // Method dump skipped, instructions count: 558
                                                                        */
                                                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.LauncherUI.onCreateOptionsMenu(android.view.Menu):boolean");
                                                                    }

                                                                    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                                                                    public void onConfigurationChanged(Configuration configuration) {
                                                                        AppMethodBeat.i(33325);
                                                                        super.onConfigurationChanged(configuration);
                                                                        HomeUI homeUI = this.ODR;
                                                                        com.tencent.mm.pluginsdk.h.a((AppCompatActivity) homeUI.uLr, homeUI.contentView);
                                                                        AppMethodBeat.o(33325);
                                                                    }

                                                                    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
                                                                        ActionMode startActionMode;
                                                                        ActionMode actionMode = null;
                                                                        AppMethodBeat.i(33326);
                                                                        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
                                                                        if (!(newChattingTabUI.OJN == null || newChattingTabUI.OJN.gNg() == null || !newChattingTabUI.OJN.isSupportCustomActionBar() || com.tencent.mm.compatible.util.d.oF(22) || (startActionMode = newChattingTabUI.OJN.gNg().startActionMode(callback)) == null)) {
                                                                            actionMode = startActionMode;
                                                                        }
                                                                        if (actionMode == null) {
                                                                            actionMode = super.onWindowStartingActionMode(callback);
                                                                        }
                                                                        AppMethodBeat.o(33326);
                                                                        return actionMode;
                                                                    }

                                                                    @Override // com.tencent.mm.ui.MMFragmentActivity
                                                                    public MMFragment getCurrentFragmet() {
                                                                        MMFragment mMFragment;
                                                                        AppMethodBeat.i(33327);
                                                                        NewChattingTabUI newChattingTabUI = this.chattingTabUI;
                                                                        if (!newChattingTabUI.mChattingClosed) {
                                                                            mMFragment = newChattingTabUI.OJN;
                                                                        } else {
                                                                            mMFragment = null;
                                                                        }
                                                                        if (mMFragment == null) {
                                                                            mMFragment = super.getCurrentFragmet();
                                                                        }
                                                                        AppMethodBeat.o(33327);
                                                                        return mMFragment;
                                                                    }

                                                                    public HomeUI getHomeUI() {
                                                                        return this.ODR;
                                                                    }

                                                                    public static void jI(Context context) {
                                                                        AppMethodBeat.i(33328);
                                                                        Intent intent = new Intent(context, LauncherUI.class);
                                                                        intent.addFlags(67108864);
                                                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                                                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                                                        context.startActivity((Intent) bl.pG(0));
                                                                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                                                        AppMethodBeat.o(33328);
                                                                    }

                                                                    public final void startChatting(String str, Bundle bundle, boolean z) {
                                                                        AppMethodBeat.i(33329);
                                                                        this.ODR.gHX();
                                                                        this.chattingTabUI.startChatting(str, bundle, z);
                                                                        AppMethodBeat.o(33329);
                                                                    }

                                                                    public final void closeChatting(boolean z) {
                                                                        AppMethodBeat.i(33330);
                                                                        new Runnable() {
                                                                            /* class com.tencent.mm.ui.LauncherUI.AnonymousClass7 */

                                                                            public final void run() {
                                                                                AppMethodBeat.i(33293);
                                                                                LauncherUI.this.ODR.getMainTabUI().gJc();
                                                                                AppMethodBeat.o(33293);
                                                                            }
                                                                        };
                                                                        if (this.chattingTabUI.Bq(z)) {
                                                                            this.ODR.Bd(this.chattingTabUI.OJN.isSupportCustomActionBar());
                                                                            this.ODR.getMainTabUI().gJf();
                                                                        }
                                                                        AppMethodBeat.o(33330);
                                                                    }

                                                                    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                                                                    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
                                                                        AppMethodBeat.i(232597);
                                                                        if (!(intent == null || intent.getComponent() == null)) {
                                                                            x xVar = x.Qxl;
                                                                            x.bnV(intent.getComponent().getClassName());
                                                                        }
                                                                        super.startActivityForResult(intent, i2, bundle);
                                                                        AppMethodBeat.o(232597);
                                                                    }

                                                                    @Override // android.support.v4.app.FragmentActivity
                                                                    public void onMultiWindowModeChanged(boolean z) {
                                                                        AppMethodBeat.i(33331);
                                                                        super.onMultiWindowModeChanged(z);
                                                                        Log.i("MicroMsg.LauncherUI", "alvinluo onMultiWindowModeChanged2 isInMultiWindowMode: %b", Boolean.valueOf(z));
                                                                        mv mvVar = new mv();
                                                                        mvVar.dSu.dSv = z;
                                                                        EventCenter.instance.publish(mvVar);
                                                                        AppMethodBeat.o(33331);
                                                                    }

                                                                    public static boolean gIv() {
                                                                        AppMethodBeat.i(232598);
                                                                        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_hwmagic_launcherui_onresume_switch, 1);
                                                                        Log.d("MicroMsg.LauncherUI", "isHWMagicLauncherUIOnresumeSwt() swt:%s", Integer.valueOf(a2));
                                                                        if (a2 == 1) {
                                                                            AppMethodBeat.o(232598);
                                                                            return true;
                                                                        }
                                                                        AppMethodBeat.o(232598);
                                                                        return false;
                                                                    }

                                                                    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity, com.tencent.mm.ui.MMFragmentActivity
                                                                    public Set<Class<? extends UIComponent>> importUIComponents() {
                                                                        AppMethodBeat.i(232599);
                                                                        HashSet hashSet = new HashSet();
                                                                        hashSet.addAll(super.importUIComponents());
                                                                        hashSet.add(MultiTaskUIC.class);
                                                                        AppMethodBeat.o(232599);
                                                                        return hashSet;
                                                                    }
                                                                }
