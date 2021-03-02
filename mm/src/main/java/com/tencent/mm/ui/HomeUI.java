package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.app.w;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.g.b.a.ie;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.multitask.d;
import com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class HomeUI implements com.tencent.mm.plugin.taskbar.api.a, LauncherUI.b, LauncherUI.c, LauncherUI.d {
    public static Boolean OCE = Boolean.FALSE;
    public static Boolean OCF = Boolean.FALSE;
    private static boolean OCU = true;
    static final int OCW = R.id.fdi;
    static final int OCX = R.id.fcu;
    private View ARQ;
    View BdQ;
    IListener CWJ = new IListener<df>() {
        /* class com.tencent.mm.ui.HomeUI.AnonymousClass15 */

        {
            AppMethodBeat.i(232563);
            this.__eventId = df.class.getName().hashCode();
            AppMethodBeat.o(232563);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(df dfVar) {
            AppMethodBeat.i(232564);
            if (HomeUI.this.OCZ != null) {
                HomeUI.this.OCZ.post(new Runnable() {
                    /* class com.tencent.mm.ui.HomeUI.AnonymousClass15.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(232561);
                        HomeUI.z(HomeUI.this);
                        AppMethodBeat.o(232561);
                    }

                    public final String toString() {
                        AppMethodBeat.i(232562);
                        String str = super.toString() + "|updatePlusMenuNewTips";
                        AppMethodBeat.o(232562);
                        return str;
                    }
                });
            }
            HomeUI.this.OCP.gJd();
            AppMethodBeat.o(232564);
            return false;
        }
    };
    private final long EKO = 300;
    private long EKP = SystemClock.elapsedRealtime();
    private boolean FUb = LocaleUtil.isChineseAppLang();
    private String OCA;
    private String OCB;
    private String OCC;
    af OCD;
    private final long OCG = 432000000;
    private final long OCH = 604800000;
    private boolean OCI = true;
    private int OCJ = 0;
    private int OCK = 0;
    private int OCL = 0;
    a OCM = a.ACTIVITY_CREATE;
    LauncherUI.a OCN;
    i OCO;
    MainTabUI OCP = new MainTabUI();
    int OCQ = 0;
    int OCR = 0;
    private boolean OCS = false;
    boolean OCT = true;
    View.OnLayoutChangeListener OCV = new View.OnLayoutChangeListener() {
        /* class com.tencent.mm.ui.HomeUI.AnonymousClass39 */

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        }
    };
    b OCY;
    View OCZ;
    private final long OCt = 604800000;
    private final long OCu = Util.MILLSECONDS_OF_DAY;
    public boolean OCv = false;
    boolean OCw;
    public boolean OCx = false;
    private WeImageView OCy;
    private boolean OCz = false;
    ImageView ODa;
    private View ODb;
    ImageView ODc;
    View ODd;
    MenuItem ODe;
    MenuItem ODf;
    private MenuItem ODg;
    MenuItem ODh;
    Menu ODi;
    private boolean ODj = true;
    IListener ODk = new IListener<nw>() {
        /* class com.tencent.mm.ui.HomeUI.AnonymousClass16 */

        {
            AppMethodBeat.i(232567);
            this.__eventId = nw.class.getName().hashCode();
            AppMethodBeat.o(232567);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(nw nwVar) {
            AppMethodBeat.i(232568);
            final nw nwVar2 = nwVar;
            if (HomeUI.this.xXX != null) {
                HomeUI.this.xXX.post(new Runnable() {
                    /* class com.tencent.mm.ui.HomeUI.AnonymousClass16.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(232565);
                        HomeUI.a(HomeUI.this, nwVar2.dTY.isVisible);
                        AppMethodBeat.o(232565);
                    }

                    public final String toString() {
                        AppMethodBeat.i(232566);
                        String str = super.toString() + "|updateMultiTaskIcon";
                        AppMethodBeat.o(232566);
                        return str;
                    }
                });
            }
            AppMethodBeat.o(232568);
            return false;
        }
    };
    Runnable ODl = new Runnable() {
        /* class com.tencent.mm.ui.HomeUI.AnonymousClass19 */

        public final void run() {
            AppMethodBeat.i(232572);
            if ((!com.tencent.mm.q.a.o(HomeUI.this.uLr, true) || com.tencent.mm.q.a.cA(HomeUI.this.uLr)) && !com.tencent.mm.q.a.r(HomeUI.this.uLr, true)) {
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent.putExtra("key_enable_multi_code", true);
                intent.putExtra("key_scan_goods_enable_dynamic_wording", true);
                intent.putExtra("key_scan_entry_scene", 5);
                intent.setFlags(65536);
                h.INSTANCE.a(11409, new Object[0]);
                c.b(HomeUI.this.uLr, "scanner", ".ui.BaseScanUI", intent);
                AppMethodBeat.o(232572);
                return;
            }
            AppMethodBeat.o(232572);
        }
    };
    private int ODm = 0;
    private LinkedList<Runnable> ODn = new LinkedList<>();
    q ODo = new q() {
        /* class com.tencent.mm.ui.HomeUI.AnonymousClass36 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(232581);
            if (Util.nullAsNil(str).equals("showprivacypolicy") && map != null) {
                String str2 = map.get(".sysmsg.showprivacypolicy.device_id");
                HomeUI.this.OCA = map.get(".sysmsg.showprivacypolicy.doublecheck_content");
                HomeUI.this.OCB = map.get(".sysmsg.showprivacypolicy.doublecheck_ok");
                HomeUI.this.OCC = map.get(".sysmsg.showprivacypolicy.doublecheck_cancel");
                boolean equals = "yes".equals(map.get(".sysmsg.showprivacypolicy.needbirthday"));
                boolean equals2 = "yes".equals(map.get(".sysmsg.showprivacypolicy.needopenplatform"));
                boolean equals3 = "yes".equals(map.get(".sysmsg.showprivacypolicy.needconfirm"));
                g.aAh().azQ().set(ar.a.USERINFO_NEED_BIRTHDAY_BOOLEAN_SYNC, Boolean.valueOf(equals));
                g.aAh().azQ().set(ar.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.valueOf(equals2));
                g.aAh().azQ().set(ar.a.USERINFO_NEED_CONFIRM_BOOLEAN_SYNC, Boolean.valueOf(equals3));
                com.tencent.mm.bw.b cD = com.tencent.mm.bw.b.cD(com.tencent.mm.compatible.deviceinfo.q.aoG().getBytes());
                cD.aiU(16);
                String encodeToString = Base64.encodeToString(cD.toByteArray(), 2);
                Log.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", str2, encodeToString, HomeUI.this.OCA, HomeUI.this.OCB, HomeUI.this.OCC, Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(equals3));
                if (Util.isNullOrNil(str2) || str2.equals(encodeToString)) {
                    String obj = g.aAh().azQ().get(274436, "").toString();
                    MMFragmentActivity mMFragmentActivity = HomeUI.this.uLr;
                    Object[] objArr = new Object[5];
                    objArr[0] = LocaleUtil.getApplicationLanguage();
                    objArr[1] = obj;
                    objArr[2] = "login";
                    objArr[3] = 1;
                    objArr[4] = Integer.valueOf(equals2 ? 1 : 0);
                    String string = mMFragmentActivity.getString(R.string.ee8, objArr);
                    if (com.tencent.mm.aw.b.Pi(obj)) {
                        Log.i("MicroMsg.LauncherUI.HomeUI", "eu true, needconfirm: %s", Boolean.valueOf(equals3));
                        if (!equals3) {
                            Bundle bundle = new Bundle();
                            bundle.putString("close_dialog_msg", HomeUI.this.OCA);
                            bundle.putString("close_dialog_cancel", HomeUI.this.OCC);
                            bundle.putString("close_dialog_ok", HomeUI.this.OCB);
                            bundle.putBoolean("close_dialog_ok_close", false);
                            HomeUI.a(HomeUI.this, string, 22722, bundle);
                        } else {
                            HomeUI.a(HomeUI.this, string, 22722, HomeUI.this.uLr.getString(R.string.dua, new Object[]{LocaleUtil.getApplicationLanguage()}));
                        }
                    } else {
                        Log.i("MicroMsg.LauncherUI.HomeUI", "eu false");
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("close_dialog_msg", HomeUI.this.uLr.getString(R.string.ee4));
                        bundle2.putString("close_dialog_cancel", HomeUI.this.uLr.getString(R.string.en_));
                        bundle2.putString("close_dialog_ok", HomeUI.this.uLr.getString(R.string.ee7));
                        bundle2.putBoolean("close_dialog_ok_close", false);
                        HomeUI.a(HomeUI.this, string, 22722, bundle2);
                    }
                    com.tencent.mm.ui.base.b.ke(HomeUI.this.uLr);
                    AppMethodBeat.o(232581);
                    return;
                }
                Log.i("MicroMsg.LauncherUI.HomeUI", "device id not match");
            }
            AppMethodBeat.o(232581);
        }
    };
    private float ODp = 0.0f;
    private boolean ODq = false;
    private TextView OxL;
    boolean OxS = false;
    View Oyi;
    private int clickCount = 0;
    View contentView;
    private String dVu = null;
    LayoutInflater kgB;
    private boolean kgv = true;
    ActionBar mActionBar;
    MessageQueue.IdleHandler pzA = new MessageQueue.IdleHandler() {
        /* class com.tencent.mm.ui.HomeUI.AnonymousClass18 */

        public final boolean queueIdle() {
            AppMethodBeat.i(232571);
            bg.aVF();
            if (Util.nullAsNil((Integer) com.tencent.mm.model.c.azQ().get(15, null)) == 0) {
                Log.e("MicroMsg.LauncherUI.HomeUI", "not init finish , do not post sync task");
                AppMethodBeat.o(232571);
            } else {
                String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "");
                if (bg.aVG() || !aA.equals("")) {
                    bg.azz().a(new bu(new bu.a() {
                        /* class com.tencent.mm.ui.HomeUI.AnonymousClass18.AnonymousClass1 */

                        @Override // com.tencent.mm.model.bu.a
                        public final void a(com.tencent.mm.network.g gVar) {
                        }
                    }, "launch normal"), 0);
                }
                ThreadPool.post(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0071: INVOKE  
                      (wrap: com.tencent.mm.booter.y$1 : 0x006b: CONSTRUCTOR  (r2v5 com.tencent.mm.booter.y$1) = 
                      (wrap: com.tencent.mm.booter.y : 0x0066: CONSTRUCTOR  (r0v8 com.tencent.mm.booter.y) = 
                      (wrap: com.tencent.mm.ui.MMFragmentActivity : 0x0062: IGET  (r2v4 com.tencent.mm.ui.MMFragmentActivity) = 
                      (wrap: com.tencent.mm.ui.HomeUI : 0x0060: IGET  (r2v3 com.tencent.mm.ui.HomeUI) = (r6v0 'this' com.tencent.mm.ui.HomeUI$18 A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.ui.HomeUI.18.ODr com.tencent.mm.ui.HomeUI)
                     com.tencent.mm.ui.HomeUI.uLr com.tencent.mm.ui.MMFragmentActivity)
                     call: com.tencent.mm.booter.y.<init>(android.content.Context):void type: CONSTRUCTOR)
                     call: com.tencent.mm.booter.y.1.<init>(com.tencent.mm.booter.y):void type: CONSTRUCTOR)
                      ("StartupReport_report")
                     type: STATIC call: com.tencent.mm.sdk.thread.ThreadPool.post(java.lang.Runnable, java.lang.String):void in method: com.tencent.mm.ui.HomeUI.18.queueIdle():boolean, file: classes4.dex
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
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006b: CONSTRUCTOR  (r2v5 com.tencent.mm.booter.y$1) = 
                      (wrap: com.tencent.mm.booter.y : 0x0066: CONSTRUCTOR  (r0v8 com.tencent.mm.booter.y) = 
                      (wrap: com.tencent.mm.ui.MMFragmentActivity : 0x0062: IGET  (r2v4 com.tencent.mm.ui.MMFragmentActivity) = 
                      (wrap: com.tencent.mm.ui.HomeUI : 0x0060: IGET  (r2v3 com.tencent.mm.ui.HomeUI) = (r6v0 'this' com.tencent.mm.ui.HomeUI$18 A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.ui.HomeUI.18.ODr com.tencent.mm.ui.HomeUI)
                     com.tencent.mm.ui.HomeUI.uLr com.tencent.mm.ui.MMFragmentActivity)
                     call: com.tencent.mm.booter.y.<init>(android.content.Context):void type: CONSTRUCTOR)
                     call: com.tencent.mm.booter.y.1.<init>(com.tencent.mm.booter.y):void type: CONSTRUCTOR in method: com.tencent.mm.ui.HomeUI.18.queueIdle():boolean, file: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.booter.y, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 25 more
                    */
                /*
                // Method dump skipped, instructions count: 165
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.HomeUI.AnonymousClass18.queueIdle():boolean");
            }
        };
        MMFragmentActivity uLr;
        private final HashMap<String, Object> values = new HashMap<>();
        private TextView xXX;
        private long xsI = 0;

        public HomeUI() {
            AppMethodBeat.i(33232);
            AppMethodBeat.o(33232);
        }

        static /* synthetic */ void D(HomeUI homeUI) {
            AppMethodBeat.i(258897);
            homeUI.gGB();
            AppMethodBeat.o(258897);
        }

        static /* synthetic */ void a(HomeUI homeUI) {
            AppMethodBeat.i(33266);
            homeUI.updateTitle();
            AppMethodBeat.o(33266);
        }

        static /* synthetic */ void a(HomeUI homeUI, Boolean bool, Boolean bool2) {
            AppMethodBeat.i(258891);
            homeUI.c(bool, bool2);
            AppMethodBeat.o(258891);
        }

        static /* synthetic */ void a(HomeUI homeUI, boolean z) {
            AppMethodBeat.i(258895);
            homeUI.Bc(z);
            AppMethodBeat.o(258895);
        }

        static /* synthetic */ void d(HomeUI homeUI, int i2) {
            AppMethodBeat.i(258888);
            homeUI.akO(i2);
            AppMethodBeat.o(258888);
        }

        static /* synthetic */ void p(HomeUI homeUI) {
            AppMethodBeat.i(33276);
            homeUI.gHW();
            AppMethodBeat.o(33276);
        }

        static /* synthetic */ void q(HomeUI homeUI) {
            AppMethodBeat.i(163269);
            homeUI.gHV();
            AppMethodBeat.o(163269);
        }

        static /* synthetic */ void t(HomeUI homeUI) {
            AppMethodBeat.i(258893);
            homeUI.gHT();
            AppMethodBeat.o(258893);
        }

        static /* synthetic */ int w(HomeUI homeUI) {
            int i2 = homeUI.clickCount;
            homeUI.clickCount = i2 + 1;
            return i2;
        }

        static /* synthetic */ void z(HomeUI homeUI) {
            AppMethodBeat.i(258894);
            homeUI.Bb(true);
            AppMethodBeat.o(258894);
        }

        /* access modifiers changed from: package-private */
        public enum a {
            ACTIVITY_CREATE,
            ACTIVITY_RESUME,
            ACTIVITY_PAUSE;

            public static a valueOf(String str) {
                AppMethodBeat.i(33217);
                a aVar = (a) Enum.valueOf(a.class, str);
                AppMethodBeat.o(33217);
                return aVar;
            }

            static {
                AppMethodBeat.i(33218);
                AppMethodBeat.o(33218);
            }
        }

        public MainTabUI getMainTabUI() {
            return this.OCP;
        }

        public final void gHP() {
            AppMethodBeat.i(232584);
            MainTabUI mainTabUI = this.OCP;
            boolean z = this.OCv;
            Log.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", Integer.valueOf(mainTabUI.acm), Boolean.valueOf(z));
            if (z) {
                mainTabUI.gIZ();
            }
            ab abVar = mainTabUI.OHZ;
            if (bg.aAc()) {
                bg.aVF();
                com.tencent.mm.model.c.azQ().remove(abVar.OIt);
                bg.aVF();
                com.tencent.mm.model.c.aST().remove(abVar);
                com.tencent.mm.y.c.axV().b(abVar.OIs);
                EventCenter.instance.removeListener(abVar.OIu);
                EventCenter.instance.removeListener(abVar.OAR);
                EventCenter.instance.removeListener(abVar.OAQ);
            }
            if (abVar.OIr != null) {
                abVar.OIr.OIo = null;
                abVar.OIr = null;
            }
            i iVar = this.OCO;
            if (iVar.OCb != null) {
                bg.azz().b(255, iVar.OCb);
                bg.azz().b(384, iVar.OCb);
                iVar.OCb = null;
            }
            CrashReportFactory.setForeground(false);
            this.OCM = a.ACTIVITY_PAUSE;
            if (!bg.aVy()) {
                bg.getNotification().dh(false);
            }
            boolean gIx = this.OCN.gIx();
            Log.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show ".concat(String.valueOf(gIx)));
            if (!gIx) {
                k.a(this.uLr, 4, this.OCP.acm, "directReport_onPause");
            }
            if (!this.uLr.isFinishing()) {
                com.tencent.mm.ui.widget.h.a(this.uLr);
            }
            if (this.OCv) {
                Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
                com.tencent.mm.blink.b.ake().akg();
                if (bg.aAc()) {
                    EventCenter.instance.removeListener(this.CWJ);
                }
            }
            if (this.OCD != null && this.OCD.isShowing()) {
                this.OCD.dismiss();
            }
            AppMethodBeat.o(232584);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00f5  */
        @android.annotation.SuppressLint({"RestrictedApi"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void updateTitle() {
            /*
            // Method dump skipped, instructions count: 789
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.HomeUI.updateTitle():void");
        }

        private boolean gHQ() {
            return this.OCJ == 3 && this.OCK == 3;
        }

        private boolean gHR() {
            return this.OCJ == 2 && this.OCK == 2;
        }

        /* access modifiers changed from: package-private */
        public final void gHS() {
            AppMethodBeat.i(33234);
            if (!bg.aAc()) {
                Log.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
                AppMethodBeat.o(33234);
                return;
            }
            bg.aVF();
            Boolean valueOf = Boolean.valueOf(Util.nullAsFalse((Boolean) com.tencent.mm.model.c.azQ().get(340227, (Object) null)));
            if (!valueOf.booleanValue() && !l.PVD.booleanValue()) {
                OCE = Boolean.TRUE;
                Ba(true);
            }
            long currentTimeMillis = System.currentTimeMillis();
            bg.aVF();
            long nullAs = currentTimeMillis - Util.nullAs((Long) com.tencent.mm.model.c.azQ().get(340240, (Object) null), 0);
            bg.aVF();
            Boolean valueOf2 = Boolean.valueOf(Util.nullAsFalse((Boolean) com.tencent.mm.model.c.azQ().get(340230, (Object) null)));
            bg.aVF();
            Boolean valueOf3 = Boolean.valueOf(Util.nullAsFalse((Boolean) com.tencent.mm.model.c.azQ().get(340228, (Object) null)));
            bg.aVF();
            Boolean valueOf4 = Boolean.valueOf(Util.nullAsFalse((Boolean) com.tencent.mm.model.c.azQ().get(340229, (Object) null)));
            if (valueOf.booleanValue() && valueOf3.booleanValue() && valueOf4.booleanValue() && !valueOf2.booleanValue() && nullAs >= 432000000) {
                OCF = Boolean.TRUE;
                Ba(false);
            }
            AppMethodBeat.o(33234);
        }

        private void Ba(final boolean z) {
            AppMethodBeat.i(33235);
            if (this.ARQ != null) {
                Log.e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
                AppMethodBeat.o(33235);
                return;
            }
            this.ARQ = View.inflate(MMApplicationContext.getContext(), R.layout.bg0, null);
            TextView textView = (TextView) this.ARQ.findViewById(R.id.fxn);
            if (z) {
                textView.setText(MMApplicationContext.getContext().getString(R.string.d4));
            } else {
                textView.setText(MMApplicationContext.getContext().getString(R.string.d1));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
            this.ARQ.setBackgroundResource(R.drawable.cje);
            if (this.contentView != null) {
                ((ViewGroup) this.contentView).addView(this.ARQ, layoutParams);
                this.ARQ.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.ed));
                this.ARQ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.HomeUI.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(33179);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        HomeUI.this.OCD.iv();
                        if (z) {
                            HomeUI homeUI = HomeUI.this;
                            Boolean bool = Boolean.TRUE;
                            HomeUI.a(homeUI, bool, bool);
                        } else {
                            HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(33179);
                    }
                });
            }
            AppMethodBeat.o(33235);
        }

        private void c(Boolean bool, Boolean bool2) {
            AppMethodBeat.i(33236);
            if (this.ARQ != null) {
                this.ARQ.clearAnimation();
                this.ARQ.setVisibility(8);
                if (bool.booleanValue()) {
                    if (bool2.booleanValue()) {
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(340227, Boolean.TRUE);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(232, 0, 1, false);
                        OCE = Boolean.FALSE;
                    } else {
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(340230, Boolean.TRUE);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(232, 5, 1, false);
                        OCF = Boolean.FALSE;
                    }
                }
                this.ARQ = null;
            }
            AppMethodBeat.o(33236);
        }

        /* access modifiers changed from: package-private */
        public final void gHT() {
            AppMethodBeat.i(33237);
            if (this.OCD == null || !bg.aAc()) {
                AppMethodBeat.o(33237);
            } else if (this.OCD.isShowing()) {
                this.OCD.dismiss();
                AppMethodBeat.o(33237);
            } else {
                this.OCD.iv();
                AppMethodBeat.o(33237);
            }
        }

        /* access modifiers changed from: package-private */
        public final void Bb(boolean z) {
            AppMethodBeat.i(33238);
            if (this.OCD == null || this.OCZ == null || this.OCY == null) {
                AppMethodBeat.o(33238);
            } else if (!bg.aAc()) {
                Log.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
                AppMethodBeat.o(33238);
            } else {
                this.OCD.OKi.Bs(z);
                b bVar = this.OCY;
                if (!com.tencent.mm.plugin.newtips.a.g.a(HomeUI.this.OCD.OKi.gCH(), bVar)) {
                    if (HomeUI.this.OCD.OKi.gCH()) {
                        HomeUI.this.ODb.setVisibility(0);
                    } else {
                        HomeUI.this.ODb.setVisibility(8);
                    }
                    com.tencent.mm.plugin.newtips.a.g.a(bVar, k.MMNEWTIPS_SHOWTYPE_REDPOINT, HomeUI.this.OCD.OKi.gCH());
                }
                yp ypVar = new yp();
                ypVar.eeQ.eeR = 2;
                ypVar.eeQ.eeS = this.OCD.OKi.gCH();
                ypVar.eeQ.eeT = false;
                EventCenter.instance.publish(ypVar);
                AppMethodBeat.o(33238);
            }
        }

        /* access modifiers changed from: package-private */
        public class b implements com.tencent.mm.plugin.newtips.a.a {
            public b(int i2, int i3) {
                AppMethodBeat.i(33227);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(i2, i3);
                HomeUI homeUI = HomeUI.this;
                com.tencent.mm.kiss.a.b.aBh();
                homeUI.OCZ = com.tencent.mm.kiss.a.b.c(HomeUI.this.uLr, R.layout.bm);
                HomeUI.this.ODa = (ImageView) HomeUI.this.OCZ.findViewById(R.id.dt5);
                HomeUI.this.ODb = HomeUI.this.OCZ.findViewById(R.id.iov);
                HomeUI.this.OCZ.setLayoutParams(layoutParams);
                HomeUI.this.OCZ.setMinimumHeight(i3);
                HomeUI.this.OCZ.setMinimumWidth(i2);
                HomeUI.this.ODa.setImageResource(R.raw.icons_outlined_add2);
                HomeUI.this.OCZ.setContentDescription(HomeUI.this.getString(R.string.hp_));
                HomeUI.this.OCZ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.HomeUI.b.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(33224);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$PlusActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.plugin.newtips.a.exl().TC(3);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10919, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        HomeUI.t(HomeUI.this);
                        if (HomeUI.OCE.booleanValue()) {
                            HomeUI homeUI = HomeUI.this;
                            Boolean bool = Boolean.TRUE;
                            HomeUI.a(homeUI, bool, bool);
                        }
                        if (HomeUI.OCF.booleanValue()) {
                            HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
                        }
                        if (!WeChatEnvironment.isMonkeyEnv()) {
                            long nowMilliSecond = Util.nowMilliSecond();
                            if (nowMilliSecond - HomeUI.this.xsI > 10000) {
                                HomeUI.this.xsI = nowMilliSecond;
                                HomeUI.this.clickCount = 1;
                            } else {
                                HomeUI.w(HomeUI.this);
                                if (HomeUI.this.clickCount >= 5) {
                                    Log.w("MicroMsg.LauncherUI.HomeUI", "Switch to MonkeyEnv now.");
                                    WeChatEnvironment.setMonkeyEnv(true);
                                }
                            }
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$PlusActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(33224);
                    }
                });
                HomeUI.this.OCZ.post(new Runnable() {
                    /* class com.tencent.mm.ui.HomeUI.b.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(33225);
                        HomeUI.this.uLr.supportInvalidateOptionsMenu();
                        AppMethodBeat.o(33225);
                    }

                    public final String toString() {
                        AppMethodBeat.i(33226);
                        String str = super.toString() + "|supportInvalidateOptionsMenu";
                        AppMethodBeat.o(33226);
                        return str;
                    }
                });
                AppMethodBeat.o(33227);
            }

            @Override // com.tencent.mm.plugin.newtips.a.a
            public final String getPath() {
                return "plus";
            }

            @Override // com.tencent.mm.plugin.newtips.a.a
            public final boolean ehp() {
                return false;
            }

            @Override // com.tencent.mm.plugin.newtips.a.a
            public final View getRoot() {
                AppMethodBeat.i(33228);
                View view = HomeUI.this.OCZ;
                AppMethodBeat.o(33228);
                return view;
            }

            @Override // com.tencent.mm.plugin.newtips.a.a
            public final void a(k kVar, boolean z) {
                AppMethodBeat.i(258885);
                com.tencent.mm.plugin.newtips.a.g.a(this, kVar, z);
                AppMethodBeat.o(258885);
            }

            @Override // com.tencent.mm.plugin.newtips.a.a
            public final boolean qV(boolean z) {
                AppMethodBeat.i(258886);
                boolean a2 = com.tencent.mm.plugin.newtips.a.g.a(z, this);
                AppMethodBeat.o(258886);
                return a2;
            }

            @Override // com.tencent.mm.plugin.newtips.a.a
            public final boolean qW(boolean z) {
                AppMethodBeat.i(33231);
                if (z) {
                    HomeUI.this.ODb.setVisibility(0);
                } else {
                    HomeUI.this.ODb.setVisibility(8);
                }
                AppMethodBeat.o(33231);
                return true;
            }

            @Override // com.tencent.mm.plugin.newtips.a.a
            public final boolean qX(boolean z) {
                return false;
            }

            @Override // com.tencent.mm.plugin.newtips.a.a
            public final boolean a(boolean z, ehv ehv) {
                return false;
            }

            @Override // com.tencent.mm.plugin.newtips.a.a
            public final boolean b(boolean z, ehv ehv) {
                return false;
            }

            @Override // com.tencent.mm.plugin.newtips.a.a
            public final boolean c(boolean z, ehv ehv) {
                return false;
            }

            @Override // com.tencent.mm.plugin.newtips.a.a
            public final boolean d(boolean z, ehv ehv) {
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void gHU() {
            /*
            // Method dump skipped, instructions count: 218
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.HomeUI.gHU():void");
        }

        private void Bc(boolean z) {
            boolean z2;
            AppMethodBeat.i(232585);
            if (!((this.OCP.gIX() instanceof MainUI) && ((d) g.ah(d.class)).isMultiTaskMode()) || ((d) g.ah(d.class)).isDataEmpty()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2 || !z) {
                ((ImageView) this.mActionBar.getCustomView().findViewById(R.id.ei)).setVisibility(4);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(this.uLr).get(MultiTaskUIC.class)).hx(false);
                AppMethodBeat.o(232585);
                return;
            }
            ImageView imageView = (ImageView) this.mActionBar.getCustomView().findViewById(R.id.ei);
            imageView.setVisibility(0);
            imageView.setAlpha(1.0f);
            this.mActionBar.getCustomView().setVisibility(0);
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(this.uLr).get(MultiTaskUIC.class)).hx(true);
            AppMethodBeat.o(232585);
        }

        /* access modifiers changed from: package-private */
        public final void gHV() {
            AppMethodBeat.i(33240);
            int i2 = this.OCP.acm;
            if (i2 == 0) {
                getMainTabUI().gIX();
            }
            Intent putExtra = new Intent().putExtra("from_tab_index", i2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
            Bundle bundle = null;
            if (Build.VERSION.SDK_INT >= 21 && !ao.isDarkMode() && com.tencent.mm.compatible.util.d.oE(30)) {
                bundle = ActivityOptions.makeSceneTransitionAnimation(this.uLr, new Pair[0]).toBundle();
            }
            com.tencent.mm.plugin.fts.a.d.b(this.uLr, ".ui.FTSMainUI", putExtra, bundle);
            AppMethodBeat.o(33240);
        }

        /* access modifiers changed from: package-private */
        public final void gHW() {
            AppMethodBeat.i(33242);
            if (gIf() && gIg()) {
                this.OCT = false;
            }
            if (gIf()) {
                g.aAh().azQ().set(ar.a.USERINFO_STORY_NEW_FEATURE_TIP_BOOLEAN_SYNC, Boolean.FALSE);
            }
            if (this.ODd != null) {
                this.ODd.findViewById(R.id.iov).setVisibility(8);
                com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.Kt(0);
            }
            if (!((e) g.ah(e.class)).canPostStory()) {
                g.aAi();
                int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, (Object) 0)).intValue();
                com.tencent.mm.ui.base.h.c(this.uLr, "", this.uLr.getResources().getString(R.string.his, Integer.valueOf(intValue)), true);
                AppMethodBeat.o(33242);
                return;
            }
            MMFragmentActivity mMFragmentActivity = this.uLr;
            com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
            ((e) g.ah(e.class)).startStoryCaptureForResult(mMFragmentActivity, 0, com.tencent.mm.plugin.story.h.h.fqA(), 10);
            AppMethodBeat.o(33242);
        }

        public final void gHX() {
            AppMethodBeat.i(33243);
            if (z.aUQ().booleanValue() && (OCE.booleanValue() || OCF.booleanValue())) {
                Boolean bool = Boolean.FALSE;
                c(bool, bool);
            }
            if (!ao.gJK()) {
                this.OCP.gHX();
            }
            AppMethodBeat.o(33243);
        }

        public final void gHY() {
            AppMethodBeat.i(33244);
            bg.aAk().setLowestPriority();
            this.OCP.gJb();
            MMHandlerThread.postToMainThread(this.ODl);
            AppMethodBeat.o(33244);
        }

        @Override // com.tencent.mm.ui.LauncherUI.b
        public final boolean gHZ() {
            return this.OCM == a.ACTIVITY_RESUME;
        }

        public final void Bd(boolean z) {
            AppMethodBeat.i(33246);
            if (!z) {
                initActionBar();
            }
            this.uLr.supportInvalidateOptionsMenu();
            if (z.aUQ().booleanValue()) {
                gHS();
            }
            this.OCP.gJa();
            AppMethodBeat.o(33246);
        }

        /* access modifiers changed from: package-private */
        public final void initActionBar() {
            AppMethodBeat.i(33247);
            if (this.OCN.gIx()) {
                Log.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
                AppMethodBeat.o(33247);
                return;
            }
            this.OxS = ao.isDarkMode();
            this.mActionBar.setLogo(new ColorDrawable(this.uLr.getResources().getColor(17170445)));
            this.mActionBar.gt();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.gs();
            this.mActionBar.gu();
            this.mActionBar.setCustomView(aa.jQ(this.uLr).inflate(R.layout.bk, (ViewGroup) new LinearLayout(this.uLr), false));
            ImageView imageView = (ImageView) this.mActionBar.getCustomView().findViewById(R.id.ei);
            if (imageView != null) {
                imageView.getDrawable().setColorFilter(this.uLr.getResources().getColor(R.color.FG_0), PorterDuff.Mode.SRC_ATOP);
            }
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.HomeUI.AnonymousClass20 */

                public final void onClick(View view) {
                    AppMethodBeat.i(232573);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    MultiTaskUIC multiTaskUIC = (MultiTaskUIC) com.tencent.mm.ui.component.a.b(HomeUI.this.uLr).get(MultiTaskUIC.class);
                    Log.i(MultiTaskUIC.TAG, "showPanel, smoothScrool:true");
                    multiTaskUIC.AfG = 2;
                    multiTaskUIC.erT();
                    MultiTaskContainerView multiTaskContainerView = multiTaskUIC.AfM;
                    if (multiTaskContainerView != null) {
                        multiTaskContainerView.RT(0);
                    }
                    com.tencent.mm.plugin.multitask.ui.base.b bVar2 = multiTaskUIC.AfC;
                    if (bVar2 != null) {
                        bVar2.setCurrentItem(0, true);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(232573);
                }
            });
            this.mActionBar.setBackgroundDrawable(ar.m(this.uLr, R.color.ko, this.uLr.getResources().getColor(R.color.BW_0_Alpha_0_9)));
            updateTitle();
            this.mActionBar.getCustomView().findViewById(R.id.ef).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.HomeUI.AnonymousClass21 */

                public final void onClick(View view) {
                    AppMethodBeat.i(232574);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (SystemClock.elapsedRealtime() - HomeUI.this.EKP < 300) {
                        Iterator it = HomeUI.this.ODn.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                    }
                    HomeUI.this.EKP = SystemClock.elapsedRealtime();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(232574);
                }
            });
            AppMethodBeat.o(33247);
        }

        private void akO(int i2) {
            AppMethodBeat.i(33248);
            if (Build.VERSION.SDK_INT < 21) {
                AppMethodBeat.o(33248);
                return;
            }
            if ((Build.VERSION.SDK_INT < 23 || com.tencent.mm.compatible.util.g.isMIUIV8()) && Build.VERSION.SDK_INT >= 21) {
                i2 = ar.v(this.uLr.getResources().getColor(R.color.a_7), i2);
            }
            if (Math.abs(this.ODm - i2) >= 50000) {
                try {
                    this.uLr.getWindow().setStatusBarColor(i2);
                } catch (NullPointerException e2) {
                    Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e2, "updateStatusBar %s", Integer.valueOf(i2));
                }
            }
            this.ODm = i2;
            AppMethodBeat.o(33248);
        }

        private void Be(boolean z) {
            int i2;
            AppMethodBeat.i(33249);
            if (Build.VERSION.SDK_INT >= 23) {
                View decorView = this.uLr.getWindow().getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (z) {
                    i2 = systemUiVisibility & -8193;
                } else {
                    i2 = systemUiVisibility | 8192;
                }
                if (systemUiVisibility != i2) {
                    decorView.setSystemUiVisibility(i2);
                }
            }
            AppMethodBeat.o(33249);
        }

        public final void setTitleBarDoubleClickListener(Runnable runnable) {
            AppMethodBeat.i(33250);
            if (!this.ODn.contains(runnable)) {
                this.ODn.add(runnable);
            }
            AppMethodBeat.o(33250);
        }

        public final void aI(Runnable runnable) {
            AppMethodBeat.i(33251);
            this.ODn.remove(runnable);
            AppMethodBeat.o(33251);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            boolean z;
            AppMethodBeat.i(33252);
            Log.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
            com.tencent.mm.compatible.b.g.anG();
            com.tencent.mm.compatible.b.g.anG();
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && this.OCD != null && this.OCD.isShowing()) {
                this.OCD.dismiss();
                AppMethodBeat.o(33252);
                return true;
            } else if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1) {
                gHT();
                AppMethodBeat.o(33252);
                return true;
            } else {
                MMFragment gIX = this.OCP.gIX();
                if (gIX == null || !gIX.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
                    if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
                        if (bg.aAc() && g.aAf().hpY && NetStatusUtil.isWap(this.uLr)) {
                            MMFragmentActivity mMFragmentActivity = this.uLr;
                            AnonymousClass22 r4 = new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.HomeUI.AnonymousClass22 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(33199);
                                    HomeUI.D(HomeUI.this);
                                    AppMethodBeat.o(33199);
                                }
                            };
                            if (!bg.aAc()) {
                                z = false;
                            } else {
                                bg.aVF();
                                int intValue = ((Integer) com.tencent.mm.model.c.azQ().get(65, (Object) 0)).intValue();
                                if (intValue >= 5) {
                                    z = false;
                                } else if (!MMEntryLock.lock("show_wap_adviser")) {
                                    z = false;
                                } else {
                                    View inflate = View.inflate(mMFragmentActivity, R.layout.bfs, null);
                                    ((TextView) inflate.findViewById(R.id.fuy)).setText(R.string.fbt);
                                    d.a aVar = new d.a(mMFragmentActivity);
                                    aVar.aoO(R.string.zb);
                                    aVar.hs(inflate);
                                    aVar.aoV(R.string.x_).c(new DialogInterface.OnClickListener(intValue) {
                                        /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass1 */
                                        final /* synthetic */ int jeE;

                                        {
                                            this.jeE = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(33403);
                                            bg.aVF();
                                            com.tencent.mm.model.c.azQ().set(65, Integer.valueOf(this.jeE + 1));
                                            AppMethodBeat.o(33403);
                                        }
                                    });
                                    aVar.Dk(false);
                                    aVar.aoW(R.string.fbn).d(new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass7 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(33409);
                                            bg.aVF();
                                            com.tencent.mm.model.c.azQ().set(65, (Object) 5);
                                            AppMethodBeat.o(33409);
                                        }
                                    });
                                    aVar.a(new DialogInterface.OnDismissListener(r4) {
                                        /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass8 */
                                        final /* synthetic */ DialogInterface.OnClickListener JdC;

                                        {
                                            this.JdC = r1;
                                        }

                                        public final void onDismiss(DialogInterface dialogInterface) {
                                            AppMethodBeat.i(33410);
                                            MMEntryLock.unlock("show_wap_adviser");
                                            if (this.JdC != null) {
                                                this.JdC.onClick(dialogInterface, 0);
                                            }
                                            AppMethodBeat.o(33410);
                                        }
                                    });
                                    aVar.hbn().show();
                                    z = true;
                                }
                            }
                            if (z) {
                                AppMethodBeat.o(33252);
                                return true;
                            }
                        }
                        final int backgroundLimitType = NetStatusUtil.getBackgroundLimitType(this.uLr);
                        if (bg.aAc() && g.aAf().hpY && NetStatusUtil.isLimited(backgroundLimitType)) {
                            bg.aVF();
                            if (Util.nullAsTrue((Boolean) com.tencent.mm.model.c.azQ().get(16385, (Object) null)) && MMAppMgr.a(this.uLr, backgroundLimitType, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.HomeUI.AnonymousClass24 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(33202);
                                    try {
                                        NetStatusUtil.startSettingItent(HomeUI.this.uLr, backgroundLimitType);
                                        AppMethodBeat.o(33202);
                                    } catch (Exception e2) {
                                        Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e2, "", new Object[0]);
                                        AppMethodBeat.o(33202);
                                    }
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.HomeUI.AnonymousClass25 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(33203);
                                    HomeUI.D(HomeUI.this);
                                    AppMethodBeat.o(33203);
                                }
                            })) {
                                AppMethodBeat.o(33252);
                                return true;
                            }
                        }
                        gGB();
                    }
                    AppMethodBeat.o(33252);
                    return false;
                }
                AppMethodBeat.o(33252);
                return true;
            }
        }

        public static class FitSystemWindowLayoutView extends FrameLayout {
            private int ODC;
            private ViewGroup ODD = null;
            private Rect mRect = new Rect();

            public FitSystemWindowLayoutView(Context context, AttributeSet attributeSet) {
                super(context, attributeSet);
                AppMethodBeat.i(33219);
                AppMethodBeat.o(33219);
            }

            public FitSystemWindowLayoutView(Context context) {
                super(context);
                AppMethodBeat.i(33220);
                AppMethodBeat.o(33220);
            }

            public int getCacheInsetsTop() {
                return this.ODC;
            }

            public void setActionBarContainer(ViewGroup viewGroup) {
                this.ODD = viewGroup;
            }

            @TargetApi(14)
            public boolean fitSystemWindows(Rect rect) {
                boolean z;
                AppMethodBeat.i(33221);
                Object[] objArr = new Object[4];
                objArr[0] = rect.toString();
                objArr[1] = Integer.valueOf(this.ODC);
                objArr[2] = Integer.valueOf(hashCode());
                objArr[3] = rect.height() == 0 ? Util.getStack() : StateEvent.ActionValue.STAGE_PASS;
                Log.i("MicroMsg.LauncherUI", "fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d stack:%s", objArr);
                if (rect.top > 0) {
                    this.ODC = rect.top;
                }
                if (this.ODD != null && (this.ODD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ODD.getLayoutParams();
                    int i2 = marginLayoutParams.bottomMargin;
                    int i3 = marginLayoutParams.rightMargin;
                    Log.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    int i4 = 0;
                    while (true) {
                        if (i4 >= getChildCount()) {
                            break;
                        }
                        View childAt = getChildAt(i4);
                        if (childAt instanceof TestTimeForChatting) {
                            TestTimeForChatting testTimeForChatting = (TestTimeForChatting) childAt;
                            if (Float.compare((float) i2, ((float) com.tencent.mm.cb.a.fromDPToPix(testTimeForChatting.getContext(), 48)) * 2.0f) > 0 || i2 < 0) {
                                Log.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", Integer.valueOf(i2));
                                testTimeForChatting.Qxf = 0;
                            } else {
                                testTimeForChatting.Qxf = i2;
                            }
                            if (Float.compare((float) i3, ((float) com.tencent.mm.cb.a.fromDPToPix(testTimeForChatting.getContext(), 48)) * 2.0f) > 0 || i3 < 0) {
                                Log.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", Integer.valueOf(i2));
                                testTimeForChatting.Qxg = 0;
                            } else {
                                testTimeForChatting.Qxg = i3;
                            }
                            Log.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", Integer.valueOf(i2), Integer.valueOf(i3));
                        } else {
                            i4++;
                        }
                    }
                    ao.P(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                }
                this.mRect.set(rect);
                if (com.tencent.mm.compatible.util.d.oD(14)) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= getChildCount()) {
                            break;
                        }
                        View childAt2 = getChildAt(i5);
                        if (childAt2 instanceof TestTimeForChatting) {
                            childAt2.setFitsSystemWindows(true);
                            z = ((TestTimeForChatting) childAt2).fitSystemWindows(rect);
                            childAt2.setFitsSystemWindows(false);
                            break;
                        }
                        i5++;
                    }
                }
                z = false;
                Log.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", Boolean.valueOf(z), Integer.valueOf(Build.VERSION.SDK_INT));
                boolean fitSystemWindows = super.fitSystemWindows(this.mRect);
                Log.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", Boolean.valueOf(fitSystemWindows));
                AppMethodBeat.o(33221);
                return fitSystemWindows;
            }

            /* access modifiers changed from: protected */
            public void onMeasure(int i2, int i3) {
                AppMethodBeat.i(33222);
                try {
                    super.onMeasure(i2, i3);
                    AppMethodBeat.o(33222);
                } catch (ClassCastException e2) {
                    Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e2, "", new Object[0]);
                    Log.e("MicroMsg.LauncherUI.HomeUI", "my layout params %s %s", getLayoutParams(), getLayoutParams().getClass());
                    int childCount = getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = getChildAt(i4);
                        Log.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", Integer.valueOf(i4), childAt, childAt.getLayoutParams(), childAt.getLayoutParams().getClass());
                    }
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt2 = getChildAt(i5);
                        if ((childAt2 instanceof ImageView) && childAt2.getId() == R.id.gga && childAt2.getLayoutParams() != null && (childAt2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && !(childAt2.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                            childAt2.setLayoutParams(new FrameLayout.LayoutParams(childAt2.getLayoutParams()));
                        }
                        Log.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", Integer.valueOf(i5), childAt2, childAt2.getLayoutParams(), childAt2.getLayoutParams().getClass());
                    }
                    super.onMeasure(i2, i3);
                    AppMethodBeat.o(33222);
                }
            }
        }

        @Override // com.tencent.mm.ui.LauncherUI.c
        public final void gIa() {
            AppMethodBeat.i(33254);
            updateTitle();
            AppMethodBeat.o(33254);
        }

        @Override // com.tencent.mm.ui.LauncherUI.b
        public final void gIb() {
            AppMethodBeat.i(33255);
            this.OCP.gIb();
            AppMethodBeat.o(33255);
        }

        private void setActionBarColor(int i2) {
            AppMethodBeat.i(33256);
            if (this.mActionBar != null) {
                this.mActionBar.setBackgroundDrawable(new ColorDrawable(i2));
            }
            if (this.BdQ != null) {
                this.BdQ.setBackgroundColor(i2);
            }
            AppMethodBeat.o(33256);
        }

        @Override // com.tencent.mm.plugin.taskbar.api.a
        public final void f(float f2, int i2, int i3) {
            AppMethodBeat.i(33257);
            MMFragment gIX = getMainTabUI().gIX();
            if (gIX != null) {
                if (gIX instanceof MoreTabUI) {
                    setActionBarColor(this.uLr.getResources().getColor(R.color.ac_));
                    AppMethodBeat.o(33257);
                    return;
                }
                if (!(gIX instanceof MainUI)) {
                    setActionBarColor(this.uLr.getResources().getColor(R.color.a2r));
                } else {
                    setActionBarColor(i2);
                }
                if (i3 > 10) {
                    y(this.Oyi, false);
                    y(this.OCZ, false);
                    AppMethodBeat.o(33257);
                    return;
                }
                y(this.Oyi, true);
                y(this.OCZ, true);
            }
            AppMethodBeat.o(33257);
        }

        @Override // com.tencent.mm.plugin.taskbar.api.a
        public final void g(float f2, int i2, int i3) {
            AppMethodBeat.i(33258);
            if (!(i2 == 0 || this.xXX == null)) {
                this.xXX.setTextColor(i2);
            }
            if (this.ODc != null) {
                if (this.ODq) {
                    this.ODc.setAlpha(f2);
                }
                this.ODc.setImageDrawable(ar.m(this.uLr, R.raw.actionbar_icon_dark_search, i3));
            }
            if (this.ODa != null) {
                if (this.ODq) {
                    this.ODa.setAlpha(f2);
                }
                this.ODa.setImageDrawable(ar.m(this.uLr, R.raw.icons_outlined_add2, i3));
            }
            AppMethodBeat.o(33258);
        }

        @Override // com.tencent.mm.plugin.taskbar.api.a
        public final void FF(boolean z) {
            int i2;
            AppMethodBeat.i(258887);
            Log.i("MicroMsg.LauncherUI.HomeUI", "alvinluo updateStatusBar show: %b", Boolean.valueOf(z));
            Resources resources = this.uLr.getResources();
            if (z) {
                i2 = R.color.a2r;
            } else {
                i2 = R.color.ac_;
            }
            akO(resources.getColor(i2));
            AppMethodBeat.o(258887);
        }

        @Override // com.tencent.mm.ui.LauncherUI.b
        public final void gIc() {
            AppMethodBeat.i(33259);
            this.OCP.alb(TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE);
            AppMethodBeat.o(33259);
        }

        private static boolean gId() {
            AppMethodBeat.i(33260);
            if (!o.isShowStoryCheck()) {
                AppMethodBeat.o(33260);
                return false;
            } else if (((e) g.ah(e.class)).isStoryExist(z.aTY())) {
                AppMethodBeat.o(33260);
                return true;
            } else {
                AppMethodBeat.o(33260);
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public final void gIe() {
            boolean z;
            AppMethodBeat.i(33261);
            if (!(this.ODh == null || this.ODh.getActionView() == null)) {
                ImageView imageView = (ImageView) this.ODh.getActionView().findViewById(R.id.dt5);
                imageView.setImageDrawable(this.uLr.getResources().getDrawable(R.raw.icons_filled_camera));
                if (gId()) {
                    imageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
                } else {
                    imageView.setColorFilter(new PorterDuffColorFilter(this.uLr.getResources().getColor(R.color.BW_0_Alpha_0_9), PorterDuff.Mode.SRC_ATOP));
                }
                if (this.OCT) {
                    if (!gIf() || !gIg()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.OCT = z;
                    this.ODh.getActionView().findViewById(R.id.iov).setVisibility(0);
                    AppMethodBeat.o(33261);
                    return;
                }
                this.ODh.getActionView().findViewById(R.id.iov).setVisibility(8);
            }
            AppMethodBeat.o(33261);
        }

        public final void Bf(boolean z) {
            AppMethodBeat.i(33262);
            if (!(this.ODh == null || this.ODh.getActionView() == null || this.uLr == null)) {
                if (this.uLr.getResources().getConfiguration().orientation == 2) {
                    this.ODh.setVisible(false);
                    this.ODh.setEnabled(false);
                    AppMethodBeat.o(33262);
                    return;
                }
                this.ODh.setVisible(true);
                this.ODh.setEnabled(true);
                ImageView imageView = (ImageView) this.ODh.getActionView().findViewById(R.id.dt5);
                imageView.setImageDrawable(this.uLr.getResources().getDrawable(R.raw.icons_filled_camera));
                if (z || ao.isDarkMode()) {
                    imageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
                } else {
                    imageView.setColorFilter(new PorterDuffColorFilter(WebView.NIGHT_MODE_COLOR, PorterDuff.Mode.SRC_ATOP));
                }
                if (this.OCT) {
                    this.ODh.getActionView().findViewById(R.id.iov).setVisibility(0);
                    AppMethodBeat.o(33262);
                    return;
                }
                this.ODh.getActionView().findViewById(R.id.iov).setVisibility(8);
            }
            AppMethodBeat.o(33262);
        }

        private static void y(View view, boolean z) {
            AppMethodBeat.i(33263);
            if (view != null) {
                if (z) {
                    view.setClickable(true);
                    AppMethodBeat.o(33263);
                    return;
                }
                view.setClickable(false);
                view.setBackgroundResource(R.color.ac_);
            }
            AppMethodBeat.o(33263);
        }

        static boolean gIf() {
            AppMethodBeat.i(33264);
            boolean fng = ((e) g.ah(e.class)).getStoryNewFeatureConfig().fng();
            AppMethodBeat.o(33264);
            return fng;
        }

        static boolean gIg() {
            AppMethodBeat.i(33265);
            boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_STORY_NEW_FEATURE_TIP_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
            AppMethodBeat.o(33265);
            return booleanValue;
        }

        public final String getString(int i2) {
            AppMethodBeat.i(33241);
            String string = this.uLr.getString(i2);
            AppMethodBeat.o(33241);
            return string;
        }

        @Override // com.tencent.mm.ui.LauncherUI.b
        public final void a(FitSystemWindowLayoutView fitSystemWindowLayoutView, Rect rect, ViewGroup viewGroup) {
            AppMethodBeat.i(33245);
            this.uLr.getWindow().getDecorView().getBottom();
            this.uLr.getSupportActionBar().getCustomView().getBottom();
            fitSystemWindowLayoutView.setActionBarContainer(viewGroup);
            fitSystemWindowLayoutView.fitSystemWindows(rect);
            AppMethodBeat.o(33245);
        }

        private void gGB() {
            AppMethodBeat.i(33253);
            if (this.uLr != null) {
                try {
                    this.uLr.moveTaskToBack(true);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e2, "", new Object[0]);
                }
            }
            if (bg.aAc()) {
                bg.aAk().postToWorkerDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.HomeUI.AnonymousClass26 */

                    public final void run() {
                        AppMethodBeat.i(232575);
                        if (bg.aAc()) {
                            bg.aVF();
                            ao azQ = com.tencent.mm.model.c.azQ();
                            if (azQ != null) {
                                azQ.gBI();
                            }
                        }
                        AppMethodBeat.o(232575);
                    }
                }, 500);
            }
            w.WE().start();
            AppMethodBeat.o(33253);
        }

        static /* synthetic */ void a(HomeUI homeUI, int i2, int i3, int i4) {
            AppMethodBeat.i(33267);
            homeUI.f(1.0f, i2, 0);
            homeUI.g(1.0f, i3, i4);
            AppMethodBeat.o(33267);
        }

        static /* synthetic */ void a(HomeUI homeUI, int i2, float f2) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5 = false;
            AppMethodBeat.i(33268);
            boolean z6 = homeUI.mActionBar != null;
            if (!homeUI.mActionBar.isShowing()) {
                z = true;
            } else {
                z = false;
            }
            if (z6 && z) {
                homeUI.mActionBar.show();
            }
            homeUI.OCI = false;
            int i3 = homeUI.OCP.acm;
            Log.d("MicroMsg.LauncherUI.HomeUI", "position=%s positionOffset=%s mCurIndex=%s mTabChangingState=%s", Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(homeUI.OCL));
            if (i3 == 3 && i2 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                if (i3 == 2 && i2 == 2 && f2 > 0.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    ColorDrawable colorDrawable = new ColorDrawable(homeUI.uLr.getResources().getColor(R.color.ac_));
                    if (homeUI.mActionBar != null) {
                        homeUI.mActionBar.setBackgroundDrawable(colorDrawable);
                    }
                    if (homeUI.BdQ != null) {
                        homeUI.BdQ.setBackgroundColor(homeUI.uLr.getResources().getColor(R.color.ac_));
                    }
                    homeUI.mActionBar.getCustomView().setVisibility(8);
                    if (homeUI.ODe != null) {
                        homeUI.ODe.setVisible(false);
                    }
                    if (homeUI.ODf != null) {
                        homeUI.ODf.setVisible(false);
                    }
                    if (homeUI.xXX != null) {
                        homeUI.xXX.setVisibility(8);
                    }
                    AppMethodBeat.o(33268);
                    return;
                }
                if (i3 == 3 && i2 == 3 && f2 == 0.0f) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    homeUI.OCI = true;
                    homeUI.updateTitle();
                    AppMethodBeat.o(33268);
                    return;
                }
                if (i3 == 2 && i2 == 2 && f2 == 0.0f) {
                    z5 = true;
                }
                if (z5) {
                    homeUI.OCI = true;
                    homeUI.updateTitle();
                    AppMethodBeat.o(33268);
                    return;
                }
                homeUI.OCI = true;
            } else if (homeUI.ODh != null) {
                homeUI.ODh.setVisible(false);
                AppMethodBeat.o(33268);
                return;
            }
            AppMethodBeat.o(33268);
        }

        static /* synthetic */ void hYB() {
            int i2;
            int i3;
            int i4;
            int i5 = 1;
            AppMethodBeat.i(258889);
            ie ieVar = new ie();
            ieVar.eNt = 1;
            if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            ieVar.eNu = i2;
            if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ieVar.eNv = i3;
            if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                i4 = 1;
            } else {
                i4 = 2;
            }
            ieVar.eNw = i4;
            if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_SNSAUTOPLAY_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                i5 = 2;
            }
            ieVar.eNx = i5;
            ieVar.bfK();
            AppMethodBeat.o(258889);
        }

        static /* synthetic */ void k(HomeUI homeUI) {
            AppMethodBeat.i(169838);
            com.tencent.f.h.RTc.aY(new Runnable() {
                /* class com.tencent.mm.ui.HomeUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(232552);
                    int jg = com.tencent.mm.cb.a.jg(MMApplicationContext.getContext());
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - MultiProcessMMKV.getDefault().decodeLong("font_size_report_time", 0) > 604800000) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14239, Integer.valueOf(jg));
                        MultiProcessMMKV.getDefault().encode("font_size_report_time", currentTimeMillis);
                        Log.i("MicroMsg.LauncherUI.HomeUI", "using font size kvReport logID:%d , usingFontSize: %d", 14239, Integer.valueOf(jg));
                    }
                    AppMethodBeat.o(232552);
                }
            });
            AppMethodBeat.o(169838);
        }

        static /* synthetic */ void l(HomeUI homeUI) {
            int i2;
            int i3;
            int i4;
            int i5;
            boolean z;
            int i6;
            int i7 = 2;
            int i8 = 1;
            AppMethodBeat.i(163267);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getLong("dark_mode_status", 0) > Util.MILLSECONDS_OF_DAY) {
                if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG || ao.awN()) {
                    i4 = ao.awS() ? 1 : 2;
                } else {
                    i4 = 0;
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[5];
                objArr[0] = 1;
                if (ao.isDarkMode()) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                objArr[1] = Integer.valueOf(i5);
                objArr[2] = 2;
                objArr[3] = Integer.valueOf(i4);
                objArr[4] = Integer.valueOf(ao.awN() ? 1 : 0);
                hVar.a(18893, objArr);
                MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putLong("dark_mode_status", currentTimeMillis);
                Log.i("MicroMsg.LauncherUI.HomeUI", "dark mode kvReport logID:%s , action: %s, isDark:%s", 18893, 1, Boolean.valueOf(ao.isDarkMode()));
                if (homeUI.uLr != null) {
                    z = ao.j(homeUI.uLr.getBaseContext().getResources());
                } else {
                    z = false;
                }
                com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr2 = new Object[5];
                objArr2[0] = 3;
                if (z) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                objArr2[1] = Integer.valueOf(i6);
                objArr2[2] = 2;
                objArr2[3] = Integer.valueOf(i4);
                objArr2[4] = Integer.valueOf(ao.awN() ? 1 : 0);
                hVar2.a(18893, objArr2);
                Log.i("MicroMsg.LauncherUI.HomeUI", "dark mode kvReport logID:%s , action: %s, isDark:%s", 18893, 1, Boolean.valueOf(ao.isDarkMode()));
            }
            if (MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_follow_system_need_report", false)) {
                Object[] objArr3 = new Object[4];
                objArr3[0] = 18893;
                objArr3[1] = 4;
                if (ao.isDarkMode()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                objArr3[2] = Integer.valueOf(i2);
                objArr3[3] = Integer.valueOf(ao.awS() ? 1 : 2);
                Log.i("MicroMsg.LauncherUI.HomeUI", "dark mode kvReport logID:%s, action:%s, dark:%s, mode:%s", objArr3);
                com.tencent.mm.plugin.report.service.h hVar3 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr4 = new Object[5];
                objArr4[0] = 4;
                if (ao.isDarkMode()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                objArr4[1] = Integer.valueOf(i3);
                objArr4[2] = 2;
                if (ao.awS()) {
                    i7 = 1;
                }
                objArr4[3] = Integer.valueOf(i7);
                if (!ao.awN()) {
                    i8 = 0;
                }
                objArr4[4] = Integer.valueOf(i8);
                hVar3.a(18893, objArr4);
                MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system_need_report", false);
            }
            AppMethodBeat.o(163267);
        }

        static /* synthetic */ void j(HomeUI homeUI) {
            AppMethodBeat.i(258890);
            if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_notice_dialog", false)) {
                f.a bow = new f.a(homeUI.uLr).bow(homeUI.uLr.getResources().getString(R.string.bk8));
                bow.JnN = true;
                bow.apa(R.string.w0).b(new f.c() {
                    /* class com.tencent.mm.ui.HomeUI.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                    }
                }).show();
                MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_notice_dialog", true);
            }
            AppMethodBeat.o(258890);
        }

        static /* synthetic */ void o(HomeUI homeUI) {
            AppMethodBeat.i(33275);
            MMFragmentActivity mMFragmentActivity = homeUI.uLr;
            try {
                Intent intent = new Intent(mMFragmentActivity, Class.forName("com.tencent.mm.plugin.test.ExMainSettings"));
                if (mMFragmentActivity instanceof Activity) {
                    mMFragmentActivity.startActivityForResult(intent, 10);
                    AppMethodBeat.o(33275);
                    return;
                }
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, bl.axQ(), "com/tencent/mm/plugin/story/api/LaunchStory", "startStorySetting", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                mMFragmentActivity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, "com/tencent/mm/plugin/story/api/LaunchStory", "startStorySetting", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(33275);
            } catch (ClassNotFoundException e2) {
                Log.printErrStackTrace("LaunchStory", e2, "startStorySetting failed", new Object[0]);
                AppMethodBeat.o(33275);
            }
        }

        static /* synthetic */ void n(HomeUI homeUI) {
            AppMethodBeat.i(258892);
            homeUI.Bb(false);
            AppMethodBeat.o(258892);
        }

        static /* synthetic */ void hYC() {
            AppMethodBeat.i(258896);
            if (Build.VERSION.SDK_INT < 18) {
                MMApplicationContext.getContext().startService(new Intent(MMApplicationContext.getContext(), NotifyReceiver.NotifyService.class));
            }
            AppMethodBeat.o(258896);
        }

        static /* synthetic */ void a(HomeUI homeUI, String str, int i2, Bundle bundle) {
            AppMethodBeat.i(258898);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            intent.putExtra("needRedirect", false);
            intent.putExtra("key_close_action", 1);
            intent.putExtra("key_close_data", bundle);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
            if (i2 > 0) {
                c.b(homeUI.uLr, "webview", ".ui.tools.WebViewUI", intent, i2);
                AppMethodBeat.o(258898);
                return;
            }
            c.b(homeUI.uLr, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(258898);
        }

        static /* synthetic */ void a(HomeUI homeUI, String str, int i2, String str2) {
            AppMethodBeat.i(258899);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            intent.putExtra("needRedirect", false);
            if (!Util.isNullOrNil(str2)) {
                intent.putExtra("key_close_action", 2);
                Bundle bundle = new Bundle();
                bundle.putString("close_jump_url", str2);
                bundle.putInt("close_jump_url_request_code", com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.e.CTRL_INDEX);
                intent.putExtra("key_close_data", bundle);
            }
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
            if (i2 > 0) {
                c.b(homeUI.uLr, "webview", ".ui.tools.WebViewUI", intent, i2);
                AppMethodBeat.o(258899);
                return;
            }
            c.b(homeUI.uLr, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(258899);
        }
    }
