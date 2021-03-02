package com.tencent.mm.plugin.multitalk.ui;

import android.app.KeyguardManager;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.multitalk.b.m;
import com.tencent.mm.plugin.multitalk.model.MultiTalkingForegroundService;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.e;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.t;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.model.w;
import com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView;
import com.tencent.mm.plugin.multitalk.ui.widget.g;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.plugin.multitalk.ui.widget.o;
import com.tencent.mm.plugin.multitalk.ui.widget.p;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.i;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.j;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.a.b;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@a(3)
public class MultiTalkMainUI extends MMActivity implements ServiceConnection, d.a, e {
    protected MMHandler czp;
    private boolean iGD = false;
    private Notification kYy;
    d orientationEventListener;
    private b yyX;
    private boolean zPH;
    public g zPI;
    public p zPJ;
    public k zPK;
    private boolean zPL = true;
    private boolean zPM = false;
    boolean zPN = false;
    private ScreenActionReceiver zPO;
    private boolean zPP = true;
    private ViewTreeObserver.OnGlobalLayoutListener zPQ = new ViewTreeObserver.OnGlobalLayoutListener() {
        /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.AnonymousClass1 */

        public final void onGlobalLayout() {
            boolean z;
            int i2;
            AppMethodBeat.i(239433);
            if (au.aA(MultiTalkMainUI.this.getContext())) {
                i2 = au.aD(MultiTalkMainUI.this.getContext());
                z = true;
            } else {
                z = false;
                i2 = 0;
            }
            if (MultiTalkMainUI.this.zPP != z) {
                MultiTalkMainUI.this.zPP = z;
                p pVar = MultiTalkMainUI.this.zPJ;
                if (!(pVar.zUA == null || pVar.zUA.findViewById(R.id.h8x) == null)) {
                    Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "applyBottomMarin %s", Integer.valueOf(i2));
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.zUA.findViewById(R.id.h8x).getLayoutParams();
                    layoutParams.bottomMargin = i2;
                    pVar.zUA.findViewById(R.id.h8x).setLayoutParams(layoutParams);
                }
            }
            AppMethodBeat.o(239433);
        }
    };
    private Runnable zPR = new Runnable() {
        /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.AnonymousClass5 */

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
            if (r0 == false) goto L_0x0047;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r5 = this;
                r4 = 239437(0x3a74d, float:3.35523E-40)
                r1 = 1
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                com.tencent.mm.plugin.multitalk.model.q r2 = com.tencent.mm.plugin.multitalk.model.ac.eom()
                boolean r3 = r2.zNf
                if (r3 == 0) goto L_0x0059
                r2 = r0
            L_0x0011:
                if (r2 == 0) goto L_0x002e
                com.tencent.mm.plugin.multitalk.model.q r2 = com.tencent.mm.plugin.multitalk.model.ac.eom()
                boolean r2 = r2.zMz
                if (r2 != 0) goto L_0x002e
                com.tencent.mm.plugin.multitalk.model.m r2 = com.tencent.mm.plugin.multitalk.model.ac.eoo()
                boolean r2 = r2.emo()
                if (r2 != 0) goto L_0x002e
                com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI r2 = com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.this
                com.tencent.mm.plugin.multitalk.ui.widget.p r2 = com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.b(r2)
                r2.rZ(r1)
            L_0x002e:
                com.tencent.mm.plugin.multitalk.model.q r2 = com.tencent.mm.plugin.multitalk.model.ac.eom()
                com.tencent.mm.plugin.multitalk.model.z r2 = r2.zMF
                if (r2 == 0) goto L_0x0047
                com.tencent.mm.plugin.multitalk.model.q r2 = com.tencent.mm.plugin.multitalk.model.ac.eom()
                com.tencent.mm.plugin.multitalk.model.z r2 = r2.zMF
                boolean r3 = r2.zOt
                if (r3 != 0) goto L_0x0044
                boolean r2 = r2.zOu
                if (r2 == 0) goto L_0x0045
            L_0x0044:
                r0 = r1
            L_0x0045:
                if (r0 != 0) goto L_0x0055
            L_0x0047:
                com.tencent.mm.plugin.multitalk.model.q r0 = com.tencent.mm.plugin.multitalk.model.ac.eom()
                r0.enM()
                com.tencent.mm.plugin.multitalk.model.q r0 = com.tencent.mm.plugin.multitalk.model.ac.eom()
                r0.enL()
            L_0x0055:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                return
            L_0x0059:
                int r2 = r2.zMx
                boolean r2 = com.tencent.mm.plugin.multitalk.model.v.Rl(r2)
                goto L_0x0011
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.AnonymousClass5.run():void");
        }
    };
    private boolean zPS = false;
    public boolean zPT = false;
    private BroadcastReceiver zPU = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.AnonymousClass9 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(239441);
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && ac.eom().zMD == o.Inviting) {
                ac.eom().stopRing();
                MultiTalkMainUI.this.zPL = false;
            }
            AppMethodBeat.o(239441);
        }
    };
    MMHandler zPV = new MMHandler() {
        /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(239435);
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    if (!MultiTalkMainUI.this.zPN) {
                        MultiTalkMainUI multiTalkMainUI = MultiTalkMainUI.this;
                        Log.i("MicroMsg.MT.MultiTalkMainUI", "bindVoiceServiceIfNeed");
                        try {
                            if (com.tencent.mm.compatible.util.d.oD(26)) {
                                multiTalkMainUI.zPN = true;
                                Intent intent = new Intent();
                                intent.setClass(MMApplicationContext.getContext(), MultiTalkingForegroundService.class);
                                MMApplicationContext.getContext().bindService(intent, multiTalkMainUI, 1);
                            }
                            AppMethodBeat.o(239435);
                            return;
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", e2, "bindVoiceServiceIfNeed error: %s", e2.getMessage());
                            AppMethodBeat.o(239435);
                            return;
                        }
                    }
                    break;
                case 1:
                    ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(43);
                    break;
            }
            AppMethodBeat.o(239435);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MultiTalkMainUI() {
        AppMethodBeat.i(114663);
        AppMethodBeat.o(114663);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(114664);
        super.onCreate(bundle);
        m.czc();
        ac.eom().enJ();
        com.tencent.mm.util.d.fAL();
        ac.eom().enB();
        getWindow().getDecorView().setSystemUiVisibility(1792);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        this.zPP = au.aA(getContext());
        int intExtra = getIntent().getIntExtra("enterMainUiSource", 0);
        if (intExtra == 1 || intExtra == 2) {
            overridePendingTransition(R.anim.dd, R.anim.s);
        } else {
            overridePendingTransition(R.anim.es, R.anim.et);
        }
        hideTitleView();
        getWindow().addFlags(6815872);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        ac.eom().qm(false);
        if (!ac.eom().ems()) {
            finish();
            if (intExtra == 2) {
                getIntent().getStringExtra("enterMainUiWxGroupId");
            }
            AppMethodBeat.o(114664);
            return;
        }
        this.zPI = new g(this);
        this.zPJ = new p(this);
        this.zPK = new k(this);
        ac.eom().rJ(ac.eom().mkd);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.zPU, intentFilter);
        this.zPM = true;
        this.czp = new MMHandler();
        if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            Log.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
        }
        if (com.tencent.mm.compatible.util.d.oD(26)) {
            Log.i("MicroMsg.MT.MultiTalkMainUI", "initScreenObserver");
            this.zPO = new ScreenActionReceiver();
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.SCREEN_OFF");
            intentFilter2.addAction("android.intent.action.SCREEN_ON");
            MMApplicationContext.getContext().registerReceiver(this.zPO, intentFilter2);
        }
        this.kYy = (Notification) getIntent().getParcelableExtra("notification");
        this.yyX = new b(new com.tencent.mm.plugin.ball.a.e(this));
        this.yyX.G(9, "VOIPFloatBall");
        this.orientationEventListener = new d(this);
        this.orientationEventListener.enable();
        this.orientationEventListener.ztH = this;
        AppMethodBeat.o(114664);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bcq;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(114665);
        Log.i("MicroMsg.MT.MultiTalkMainUI", "onResume");
        super.onResume();
        this.iGD = false;
        ac.eom().zLR = this;
        ac.eoo().zLR = this;
        chG().getViewTreeObserver().addOnGlobalLayoutListener(this.zPQ);
        t enw = ac.eom().enw();
        ArrayList<String> arrayList = enw.zNE;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                enw.aGk(it.next());
            }
        }
        if (this.yyX != null) {
            this.yyX.aGf();
            f.e(true, false, true);
        }
        com.tencent.mm.plugin.appbrand.backgroundrunning.g gVar = (com.tencent.mm.plugin.appbrand.backgroundrunning.g) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class);
        if (gVar != null) {
            gVar.bza();
            gVar.bzb();
        }
        com.tencent.mm.plugin.ball.c.b bVar = (com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class);
        if (bVar != null) {
            bVar.l(new BallInfo(6, "MusicFloatBall"));
        }
        if (ac.eom().ent()) {
            this.czp.postDelayed(this.zPR, 2000);
        }
        if (eov()) {
            ac.eom();
            q.Rj(101);
            ac.eom().zMz = true;
            ac.eom().zMA = false;
        } else {
            boolean booleanExtra = getIntent().getBooleanExtra("enterMainUIScreenProjectOnline", false);
            Bundle bundleExtra = getIntent().getBundleExtra("enterMainUIScreenProjectParams");
            if (booleanExtra && bundleExtra != null) {
                this.zPK.Rs(2);
                this.zPK.aq(bundleExtra);
                if (this.zPK.isShown()) {
                    this.zPI.eoG();
                    this.zPJ.eoS();
                    this.zPJ.emh();
                    this.zPJ.eoV();
                    this.zPJ.eoU();
                    this.zPT = false;
                    setRequestedOrientation(4);
                    AppMethodBeat.o(114665);
                    return;
                }
                this.zPI.eoG();
                this.zPJ.n(ac.eom().zME);
                AppMethodBeat.o(114665);
                return;
            }
        }
        switch (ac.eom().zMD) {
            case Inviting:
                this.zPJ.eoV();
                this.zPI.m(ac.eom().zME);
                if (NetStatusUtil.is4G(this)) {
                    ac.eok().at(this);
                } else if (NetStatusUtil.is2G(this) || NetStatusUtil.is3G(this)) {
                    ac.eok().as(this);
                }
                if (this.zPL) {
                    ac.eom().rM(false);
                    AppMethodBeat.o(114665);
                    return;
                }
                break;
            case Starting:
            case Creating:
                this.zPI.eoG();
                this.zPJ.n(ac.eom().zME);
                if (NetStatusUtil.is4G(this)) {
                    ac.eok().at(this);
                } else if (NetStatusUtil.is2G(this) || NetStatusUtil.is3G(this)) {
                    ac.eok().as(this);
                }
                ac.eom().rM(true);
                AppMethodBeat.o(114665);
                return;
            case Talking:
                if (!this.zPK.isShown()) {
                    this.zPI.eoG();
                    this.zPJ.n(ac.eom().zME);
                    break;
                } else {
                    this.zPI.eoG();
                    this.zPJ.emh();
                    this.zPJ.eoV();
                    AppMethodBeat.o(114665);
                    return;
                }
        }
        AppMethodBeat.o(114665);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(114666);
        super.onPause();
        this.zPH = (hasWindowFocus() || !((KeyguardManager) MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) && ((PowerManager) MMApplicationContext.getContext().getSystemService("power")).isScreenOn();
        Log.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", Boolean.valueOf(this.zPH));
        if (ac.eom().ent()) {
            this.zPJ.sa(true);
        }
        if (this.zPT || this.zPS || eov()) {
            if (eov() && this.yyX != null) {
                this.yyX.fFm();
            }
            f.e(true, true, true);
        } else if (this.yyX != null) {
            this.yyX.aGj();
            f.e(false, true, true);
        }
        if (eov()) {
            a.C1887a.GST.wR(true);
            AppMethodBeat.o(114666);
            return;
        }
        a.C1887a.GST.wR(false);
        AppMethodBeat.o(114666);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(114667);
        if (this.zPS || this.zPT) {
            ac.eom().rI(false);
        }
        if (this.zPM) {
            unregisterReceiver(this.zPU);
        }
        if (this.zPK != null) {
            k kVar = this.zPK;
            boolean z = ac.eom().yon;
            com.tencent.mm.plugin.multitalk.ui.widget.projector.f fVar = kVar.zTw;
            if (fVar != null) {
                fVar.sh(z);
            }
            com.tencent.mm.plugin.multitalk.ui.widget.projector.d dVar = kVar.zTx;
            if (dVar != null) {
                dVar.sh(z);
            }
        }
        this.zPV.removeCallbacksAndMessages(null);
        this.zPV.sendEmptyMessage(1);
        Log.i("MicroMsg.MT.MultiTalkMainUI", "unbindVoiceServiceIfNeed");
        try {
            if (com.tencent.mm.compatible.util.d.oD(26) && this.zPN) {
                MMApplicationContext.getContext().unbindService(this);
                this.zPN = false;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", e2, "unbindVoiceServiceIfNeed error: %s", e2.getMessage());
        }
        if (com.tencent.mm.compatible.util.d.oD(26)) {
            Log.i("MicroMsg.MT.MultiTalkMainUI", "unInitScreenObserver");
            if (this.zPO != null) {
                try {
                    MMApplicationContext.getContext().unregisterReceiver(this.zPO);
                } catch (Exception e3) {
                    Log.i("MicroMsg.MT.MultiTalkMainUI", "unregisterBatteryChange err:%s", e3.getMessage());
                }
                this.zPO = null;
            }
        }
        chG().getViewTreeObserver().removeOnGlobalLayoutListener(this.zPQ);
        super.onDestroy();
        if (this.yyX != null) {
            this.yyX.onDestroy();
        }
        AppMethodBeat.o(114667);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(114668);
        if (eov() && this.zPH) {
            ac.eom();
            q.Rj(102);
            ac.eom().zMz = false;
            ac.eom().zMA = true;
            ac.eom().aF(1, true);
        }
        if (!this.zPS && !this.zPT && this.zPH && !this.iGD) {
            ac.eom().rI(false);
        }
        super.onStop();
        AppMethodBeat.o(114668);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(114669);
        if (keyEvent.getKeyCode() == 4) {
            if (eov()) {
                k kVar = this.zPK;
                com.tencent.mm.plugin.multitalk.ui.widget.projector.f fVar = kVar.zTw;
                if (fVar != null) {
                    fVar.onBack();
                }
                com.tencent.mm.plugin.multitalk.ui.widget.projector.d dVar = kVar.zTx;
                if (dVar != null) {
                    dVar.onBack();
                }
            } else {
                h.a(this, (int) R.string.f64, (int) R.string.f5g, (int) R.string.ha, (int) R.string.sz, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(239438);
                        ac.eom().j(false, false, false);
                        AppMethodBeat.o(239438);
                    }
                }, (DialogInterface.OnClickListener) null);
            }
            AppMethodBeat.o(114669);
            return true;
        }
        if (ac.eom().zMD == o.Inviting) {
            if (i2 == 25 || i2 == 24) {
                ac.eom().stopRing();
                this.zPL = false;
                AppMethodBeat.o(114669);
                return true;
            }
        } else if (i2 == 25) {
            q eom = ac.eom();
            if (eom.zMV != null) {
                eom.zMV.AX(com.tencent.mm.plugin.multitalk.a.a.eaL());
            }
            AppMethodBeat.o(114669);
            return true;
        } else if (i2 == 24) {
            q eom2 = ac.eom();
            if (eom2.zMV != null) {
                eom2.zMV.AW(com.tencent.mm.plugin.multitalk.a.a.eaL());
            }
            AppMethodBeat.o(114669);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(114669);
        return onKeyDown;
    }

    public final void eou() {
        AppMethodBeat.i(114671);
        if (!this.zPS) {
            this.zPS = true;
            Intent intent = new Intent(this, MultiTalkAddMembersUI.class);
            ArrayList arrayList = new ArrayList();
            if (ac.eom().zME != null) {
                for (MultiTalkGroupMember multiTalkGroupMember : ac.eom().zME.RHa) {
                    if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                        arrayList.add(multiTalkGroupMember.RHb);
                    }
                }
                intent.putExtra("titile", getString(R.string.f5h));
                intent.putExtra("chatroomName", ac.eom().zME.zHE);
                intent.putExtra("always_select_contact", Util.listToString(arrayList, ","));
                intent.putExtra("key_need_gallery", false);
                startActivityForResult(intent, 1);
            }
        }
        AppMethodBeat.o(114671);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(114672);
        Log.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + i2 + " resultCode " + i3);
        super.onActivityResult(i2, i3, intent);
        this.zPS = false;
        this.zPT = false;
        if (i3 == -1 && i2 == 1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            Log.i("MicroMsg.MT.MultiTalkMainUI", "add member ".concat(String.valueOf(stringExtra)));
            ArrayList<String> stringsToList = Util.stringsToList(stringExtra.split(","));
            if (stringsToList == null) {
                AppMethodBeat.o(114672);
                return;
            }
            ac.eom().fA(stringsToList);
        }
        AppMethodBeat.o(114672);
    }

    public final boolean eov() {
        AppMethodBeat.i(239443);
        if (this.zPK != null) {
            boolean isShown = this.zPK.isShown();
            AppMethodBeat.o(239443);
            return isShown;
        }
        AppMethodBeat.o(239443);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(239444);
        super.onNewIntent(intent);
        if (ac.eom().ent() && this.czp != null) {
            this.czp.removeCallbacksAndMessages(null);
            this.czp.postDelayed(this.zPR, 2000);
        }
        String stringExtra = intent.getStringExtra("filePath");
        if (stringExtra != null) {
            Bundle bundle = new Bundle();
            int lastIndexOf = stringExtra.lastIndexOf(".") + 1;
            if (lastIndexOf >= stringExtra.length()) {
                Log.i("MicroMsg.MT.MultiTalkMainUI", "open file error : file path error");
                AppMethodBeat.o(239444);
                return;
            }
            String substring = stringExtra.substring(lastIndexOf);
            bundle.putString("file_path", stringExtra);
            bundle.putString("file_ext", substring);
            this.zPK.Rs(2);
            this.zPK.aq(bundle);
            com.tencent.mm.plugin.multitalk.model.p.n(ac.eom().zME.zHD, 1, 2, 1);
            if (this.zPK.isShown()) {
                this.zPI.eoG();
                this.zPJ.eoS();
                this.zPJ.emh();
                this.zPJ.zUi.setVisibility(8);
                this.zPJ.eoV();
                this.zPJ.eoU();
                this.zPT = false;
                setRequestedOrientation(4);
                AppMethodBeat.o(239444);
                return;
            }
            this.zPI.eoG();
            this.zPJ.n(ac.eom().zME);
        }
        AppMethodBeat.o(239444);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void emu() {
        AppMethodBeat.i(114673);
        switch (ac.eom().zMD) {
            case Starting:
            case Creating:
            case Talking:
                this.zPJ.n(ac.eom().zME);
                AppMethodBeat.o(114673);
                return;
            case Inviting:
                this.zPI.m(ac.eom().zME);
                break;
        }
        AppMethodBeat.o(114673);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void eie() {
        AppMethodBeat.i(114674);
        this.zPI.eoG();
        this.zPJ.n(ac.eom().zME);
        AppMethodBeat.o(114674);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void dZZ() {
        AppMethodBeat.i(114675);
        if (!eov()) {
            mu muVar = new mu();
            muVar.dSs.action = 0;
            EventCenter.instance.publish(muVar);
            this.zPJ.sb(true);
            ac.eom().stopRing();
            finish();
        }
        ac.eom().zLR = null;
        ac.eoo().zLR = null;
        AppMethodBeat.o(114675);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void emt() {
        AppMethodBeat.i(114676);
        this.iGD = true;
        q eom = ac.eom();
        if (eom.zMV != null) {
            eom.zMV.P(false, 1);
        }
        mu muVar = new mu();
        muVar.dSs.action = 0;
        EventCenter.instance.publish(muVar);
        this.czp.post(new Runnable() {
            /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(239439);
                MultiTalkMainUI.this.zPJ.sb(false);
                AppMethodBeat.o(239439);
            }
        });
        if (this.zPK != null) {
            com.tencent.mm.plugin.multitalk.d.f fVar = com.tencent.mm.plugin.multitalk.d.f.zZd;
            com.tencent.mm.plugin.multitalk.d.f.eqn();
            this.zPK.emx();
        }
        ac.eom().zLR = null;
        ac.eoo().zLR = null;
        ac.eom().stopRing();
        q eom2 = ac.eom();
        if (eom2.zMV != null) {
            eom2.zMV.elB();
        }
        if (ac.eom().zMV != null) {
            com.tencent.mm.plugin.multitalk.a.a.unInit();
        }
        ac.eoo().release();
        finish();
        AppMethodBeat.o(114676);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void onError(int i2) {
        AppMethodBeat.i(114677);
        if (i2 == -1700) {
            p pVar = this.zPJ;
            Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
            pVar.sa(false);
            ac.eom().aF(1, ac.eom().zMz);
            pVar.zUr.setChecked(false);
        }
        AppMethodBeat.o(114677);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void emv() {
        AppMethodBeat.i(114678);
        Log.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + ac.eom().zMC.size());
        if (ac.eom().ent()) {
            HashSet<String> hashSet = ac.eom().zMC;
            if (hashSet.size() <= 0) {
                q eom = ac.eom();
                Log.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkDataSource");
                if (eom.zMF != null) {
                    eom.zMF.stopVideo();
                }
            } else if (hashSet.size() != 1 || !hashSet.contains(z.aTY())) {
                ac.eom().enL();
            } else {
                ac.eom().enM();
            }
            p pVar = this.zPJ;
            HashSet<String> hashSet2 = new HashSet<>(ac.eom().zMC);
            if (v.Rm(ac.eom().zMx)) {
                pVar.d(hashSet2);
            }
            com.tencent.mm.plugin.multitalk.model.p.Rg(hashSet2.size());
        }
        AppMethodBeat.o(114678);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void rv(boolean z) {
        AppMethodBeat.i(114679);
        if (ac.eom().ent()) {
            com.tencent.f.h.RTc.aV(new Runnable(z) {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass11 */
                final /* synthetic */ boolean quk;

                {
                    this.quk = r2;
                }

                public final void run() {
                    boolean z;
                    int i2 = 0;
                    AppMethodBeat.i(239466);
                    p.this.zUs.setChecked(this.quk);
                    com.tencent.mm.plugin.multitalk.model.a aVar = p.this.zMZ;
                    boolean z2 = this.quk;
                    String aTY = z.aTY();
                    kotlin.g.b.p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
                    b aFA = aVar.aFA(aTY);
                    if (aFA != null) {
                        if (aFA.zQT != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            aFA = null;
                        }
                        if (aFA != null) {
                            if (!z2) {
                                i2 = 8;
                            }
                            aFA.Rp(i2);
                            AppMethodBeat.o(239466);
                            return;
                        }
                    }
                    AppMethodBeat.o(239466);
                }
            });
        }
        AppMethodBeat.o(114679);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void rw(boolean z) {
        AppMethodBeat.i(114680);
        if (ac.eom().ent()) {
            p pVar = this.zPJ;
            Log.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSpeakerStateChange: %s", Boolean.valueOf(z));
            com.tencent.f.h.RTc.aV(new Runnable(z) {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.p.AnonymousClass2 */
                final /* synthetic */ boolean zUO;

                {
                    this.zUO = r2;
                }

                public final void run() {
                    AppMethodBeat.i(239460);
                    p.this.zUt.setChecked(this.zUO);
                    p.e(p.this);
                    AppMethodBeat.o(239460);
                }
            });
        }
        AppMethodBeat.o(114680);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void hh(int i2, int i3) {
        AppMethodBeat.i(114681);
        if (ac.eom().ent()) {
            p pVar = this.zPJ;
            if (!v.Rl(i3)) {
                if (v.Rl(i2)) {
                    pVar.zUr.setChecked(false);
                    pVar.zMZ.eL(z.aTY(), 0);
                    pVar.zUq.setVisibility(8);
                }
                pVar.sa(false);
            } else if (v.Rl(i3) && !v.Rl(i2)) {
                pVar.zUr.setChecked(true);
                pVar.zMZ.eL(z.aTY(), 1);
                pVar.zUq.setVisibility(0);
            }
            HashSet<String> hashSet = new HashSet<>(ac.eom().zMC);
            if (!v.Rm(i3)) {
                if (v.Rm(i2)) {
                    pVar.zMZ.r(hashSet);
                    AppMethodBeat.o(114681);
                    return;
                }
            } else if (v.Rm(i3) && !v.Rm(i2)) {
                pVar.d(hashSet);
            }
        }
        AppMethodBeat.o(114681);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void rx(boolean z) {
        AppMethodBeat.i(114682);
        if (ac.eom().ent()) {
            p pVar = this.zPJ;
            if (pVar.zUt != null) {
                pVar.zUt.setEnabled(z);
            }
        }
        AppMethodBeat.o(114682);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void a(o oVar) {
        AppMethodBeat.i(114686);
        if (oVar == o.Talking) {
            p pVar = this.zPJ;
            if (pVar.zUL > 0) {
                pVar.zUL = System.currentTimeMillis();
            }
        }
        AppMethodBeat.o(114686);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void a(v.a aVar) {
        AppMethodBeat.i(114687);
        if (aVar == v.a._4G) {
            ac.eok().at(this);
            AppMethodBeat.o(114687);
        } else if (aVar == v.a._3GOr_2G) {
            ac.eok().as(this);
            AppMethodBeat.o(114687);
        } else {
            if (aVar == v.a.None) {
                com.tencent.mm.bh.e.a(this, R.string.i3o, null);
            }
            AppMethodBeat.o(114687);
        }
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void eaa() {
        List<String> aGl;
        j jVar;
        i iVar;
        CopyOnWriteArrayList<com.tencent.mm.plugin.multitalk.data.a> copyOnWriteArrayList;
        ImageView imageView;
        ImageView imageView2;
        CopyOnWriteArrayList<com.tencent.mm.plugin.multitalk.data.a> copyOnWriteArrayList2;
        String str;
        com.tencent.mm.plugin.multitalk.model.b bVar;
        AppMethodBeat.i(114688);
        p pVar = this.zPJ;
        TextView textView = pVar.timeTV;
        long j2 = (long) ac.eom().zMJ;
        textView.setText(String.format("%02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        com.tencent.mm.plugin.multitalk.model.a aVar = pVar.zMZ;
        q eom = ac.eom();
        kotlin.g.b.p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        HashSet<String> hashSet = eom.zMC;
        q eom2 = ac.eom();
        kotlin.g.b.p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
        List<String> elR = eom2.elR();
        com.tencent.mm.plugin.multitalk.ui.widget.a aVar2 = aVar.zKS;
        if (!(aVar2 == null || (copyOnWriteArrayList2 = aVar2.zQI) == null)) {
            Iterator<T> it = copyOnWriteArrayList2.iterator();
            while (it.hasNext()) {
                String str2 = it.next().zHg.RHb;
                kotlin.g.b.p.g(str2, "it.member.usrName");
                com.tencent.mm.plugin.multitalk.ui.widget.b aFA = aVar.aFA(str2);
                if (aFA != null) {
                    com.tencent.mm.plugin.multitalk.ui.widget.b bVar2 = aFA.zQT != null ? aFA : null;
                    if (bVar2 != null) {
                        MultitalkFrameView multitalkFrameView = bVar2.zQT;
                        if (multitalkFrameView == null || (str = multitalkFrameView.getUsername()) == null) {
                            str = "";
                        }
                        if (kotlin.g.b.p.j(z.aTY(), str) && (bVar = aVar.zKQ) != null && bVar.emo()) {
                            ImageView imageView3 = bVar2.zQU;
                            if (imageView3 != null) {
                                imageView3.setVisibility(8);
                            }
                        } else if (elR == null || !elR.contains(str) || hashSet == null || hashSet.contains(str)) {
                            ImageView imageView4 = bVar2.zQU;
                            if (imageView4 != null) {
                                imageView4.setVisibility(8);
                            }
                        } else {
                            ImageView imageView5 = bVar2.zQU;
                            if (imageView5 != null) {
                                imageView5.setVisibility(0);
                            }
                        }
                        MultitalkFrameView multitalkFrameView2 = bVar2.zQT;
                        if (multitalkFrameView2 != null && multitalkFrameView2.qvn) {
                            com.tencent.f.h.RTc.aV(new MultitalkFrameView.e(multitalkFrameView2));
                        }
                    }
                }
            }
        }
        if (elR != null) {
            com.tencent.mm.plugin.multitalk.model.p.Rf(elR.size());
        }
        com.tencent.mm.plugin.multitalk.model.a aVar3 = pVar.zMZ;
        q eom3 = ac.eom();
        kotlin.g.b.p.g(eom3, "SubCoreMultiTalk.getMultiTalkManager()");
        String str3 = eom3.zME.zHD;
        if (Util.isNullOrNil(str3)) {
            str3 = eom3.zME.RGY;
        }
        boolean aFW = eom3.aFW(eom3.zME.zHE);
        Log.d("MicroMsg.MT.MultiTalkManager", "getWeakNetworkMember: %s, groupid:%s, isILink:%b", v.g(eom3.zME), eom3.zME.zHE, Boolean.valueOf(aFW));
        new ArrayList();
        if (aFW) {
            aGl = com.tencent.mm.plugin.multitalk.b.p.INSTANCE.elT();
        } else {
            if (w.zNS == null) {
                w.zNS = new w();
            }
            aGl = w.zNS.aGl(str3);
        }
        com.tencent.mm.plugin.multitalk.ui.widget.a aVar4 = aVar3.zKS;
        if (!(aVar4 == null || (copyOnWriteArrayList = aVar4.zQI) == null)) {
            for (T t : copyOnWriteArrayList) {
                if (aGl.contains(t.zHg.RHb)) {
                    String str4 = t.zHg.RHb;
                    kotlin.g.b.p.g(str4, "it.member.usrName");
                    com.tencent.mm.plugin.multitalk.ui.widget.b aFA2 = aVar3.aFA(str4);
                    if (!(aFA2 == null || (imageView2 = aFA2.zQV) == null)) {
                        imageView2.setVisibility(0);
                    }
                    boolean j3 = kotlin.g.b.p.j(z.aTY(), t.zHg.RHb);
                    com.tencent.mm.plugin.multitalk.model.p.rC(j3);
                    if (j3) {
                        n eon = ac.eon();
                        if (eon.zTM != null && !eon.zTO) {
                            com.tencent.f.h.RTc.bqo("showIcon");
                            com.tencent.f.h.RTc.b(new n.d(eon), "showIcon");
                        }
                    }
                } else {
                    String str5 = t.zHg.RHb;
                    kotlin.g.b.p.g(str5, "it.member.usrName");
                    com.tencent.mm.plugin.multitalk.ui.widget.b aFA3 = aVar3.aFA(str5);
                    if (!(aFA3 == null || (imageView = aFA3.zQV) == null)) {
                        imageView.setVisibility(8);
                    }
                }
            }
        }
        if (!(pVar.zUI == null || (jVar = pVar.zUI.zYA) == null || (iVar = jVar.zWE) == null)) {
            iVar.eaa();
        }
        k kVar = this.zPK;
        com.tencent.mm.plugin.multitalk.ui.widget.projector.f fVar = kVar.zTw;
        if (fVar != null) {
            fVar.eaa();
        }
        com.tencent.mm.plugin.multitalk.ui.widget.projector.d dVar = kVar.zTx;
        if (dVar != null) {
            dVar.eaa();
        }
        ac.eoo().emE();
        AppMethodBeat.o(114688);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final boolean emo() {
        AppMethodBeat.i(114689);
        if (this.zPJ != null) {
            boolean emo = ac.eoo().emo();
            AppMethodBeat.o(114689);
            return emo;
        }
        AppMethodBeat.o(114689);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void emw() {
        AppMethodBeat.i(239445);
        this.zPJ.rY(true);
        AppMethodBeat.o(239445);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(239446);
        super.onConfigurationChanged(configuration);
        if (eov()) {
            this.zPK.refreshView();
            AppMethodBeat.o(239446);
            return;
        }
        k.a aVar = k.zTz;
        k.a.c(this, true);
        p pVar = this.zPJ;
        if (ac.eom().emr()) {
            pVar.zKN.requestLayout();
            if (pVar.zKN.getAdapter() != null) {
                pVar.zKN.getAdapter().atj.notifyChanged();
            }
            pVar.zUk.requestLayout();
        }
        AppMethodBeat.o(239446);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void emx() {
        AppMethodBeat.i(239447);
        setRequestedOrientation(1);
        com.tencent.mm.plugin.multitalk.d.f fVar = com.tencent.mm.plugin.multitalk.d.f.zZd;
        com.tencent.mm.plugin.multitalk.d.f.eqo();
        ac.eom().zMz = false;
        ac.eom().zMA = false;
        getIntent().removeExtra("enterMainUIScreenProjectOnline");
        getIntent().removeExtra("enterMainUIScreenProjectParams");
        this.zPK.emx();
        ac.eom().aF(1, false);
        this.zPJ.emg();
        p pVar = this.zPJ;
        if (pVar.zUD) {
            pVar.zUA.setVisibility(0);
        }
        this.zPJ.zUi.setVisibility(0);
        p.eoQ();
        this.zPJ.n(ac.eom().zME);
        p pVar2 = this.zPJ;
        pVar2.zUm.setVisibility(0);
        pVar2.zUl.setVisibility(0);
        if (ac.eom().ent() && this.czp != null) {
            p pVar3 = this.zPJ;
            pVar3.zMZ.a(pVar3.zKN, pVar3.zKO, pVar3.zSH, pVar3);
            ac.eom().enN();
        }
        AppMethodBeat.o(239447);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void emy() {
        AppMethodBeat.i(239448);
        Log.e("MicroMsg.MT.MultiTalkMainUI", "onCameraError");
        com.tencent.mm.ui.widget.a.d a2 = com.tencent.mm.bh.e.a(this, R.string.i3p, new Runnable() {
            /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(239440);
                ac.eoo().release();
                AppMethodBeat.o(239440);
            }
        });
        if (!a2.isShowing()) {
            a2.show();
        }
        ac.eom().aF(1, ac.eom().zMz);
        AppMethodBeat.o(239448);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        AppMethodBeat.i(239449);
        if (!this.zPK.isShown()) {
            AppMethodBeat.o(239449);
            return 1;
        }
        AppMethodBeat.o(239449);
        return 4;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void aFS(String str) {
        AppMethodBeat.i(239450);
        if (this.zPK != null) {
            k kVar = this.zPK;
            kotlin.g.b.p.h(str, "path");
            cz czVar = new cz();
            if (Util.isNullOrNil(str)) {
                Log.w("MicroMsg.MultiTalkScreenProjectUILogic", "fill favorite event fail, event is null or image path is empty");
                czVar.dFZ.dGe = R.string.c_2;
            } else {
                Log.i("MicroMsg.MultiTalkScreenProjectUILogic", "do fill event info(fav simple image), path %s sourceType %d", str, 2);
                anb anb = new anb();
                anh anh = new anh();
                aml aml = new aml();
                aml.ajd(2);
                aml.bgt(str);
                String str2 = aml.toString() + 2 + System.currentTimeMillis();
                Charset charset = kotlin.n.d.UTF_8;
                if (str2 == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(239450);
                    throw tVar;
                }
                byte[] bytes = str2.getBytes(charset);
                kotlin.g.b.p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                aml.bgs(com.tencent.mm.b.g.getMessageDigest(bytes));
                hb hbVar = new hb();
                hbVar.dLm.type = 27;
                hbVar.dLm.dLo = aml;
                EventCenter.instance.publish(hbVar);
                String str3 = hbVar.dLn.thumbPath;
                BitmapUtil.createThumbNail(str, 150, 150, Bitmap.CompressFormat.JPEG, 90, str3, true);
                aml.bgu(str3);
                anh.bhf(z.aTY());
                anh.bhg(z.aTY());
                anh.ajm(2);
                anh.MA(Util.nowMilliSecond());
                anb.a(anh);
                anb.ppH.add(aml);
                czVar.dFZ.title = aml.title;
                czVar.dFZ.dGb = anb;
                czVar.dFZ.type = 2;
            }
            czVar.dFZ.activity = kVar.zSH;
            czVar.dFZ.dGf = 6;
            EventCenter.instance.publish(czVar);
        }
        AppMethodBeat.o(239450);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.e
    public final void aFT(String str) {
        AppMethodBeat.i(239451);
        if (this.zPK != null) {
            k kVar = this.zPK;
            kotlin.g.b.p.h(str, "imgPath");
            Intent intent = new Intent();
            intent.setClassName(kVar.zSH, "com.tencent.mm.ui.transmit.MsgRetransmitUI");
            intent.putExtra("Retr_File_Name", str);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.putExtra("Retr_Compress_Type", 1);
            MultiTalkMainUI multiTalkMainUI = kVar.zSH;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(multiTalkMainUI, bl.axQ(), "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic", "doSendTOFriend", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            multiTalkMainUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(multiTalkMainUI, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic", "doSendTOFriend", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(239451);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(114690);
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            Log.e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", Integer.valueOf(i2));
            AppMethodBeat.o(114690);
            return;
        }
        Log.d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                if (iArr[0] == 0) {
                    Log.d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
                    AppMethodBeat.o(114690);
                    return;
                }
                h.a((Context) this, getString(R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.AnonymousClass10 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(114659);
                        MultiTalkMainUI multiTalkMainUI = MultiTalkMainUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        com.tencent.mm.hellhoundlib.a.a.a(multiTalkMainUI, bl.axQ(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI$7", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        multiTalkMainUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(multiTalkMainUI, "com/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI$7", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(114659);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.AnonymousClass11 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(114660);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(114660);
                    }
                });
                AppMethodBeat.o(114690);
                return;
            case 22:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl0), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.AnonymousClass12 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(239442);
                            MultiTalkMainUI multiTalkMainUI = MultiTalkMainUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(multiTalkMainUI, bl.axQ(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            multiTalkMainUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(multiTalkMainUI, "com/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(239442);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(239434);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(239434);
                        }
                    });
                    break;
                } else {
                    Log.d("MicroMsg.MT.MultiTalkMainUI", "granted record camera!");
                    AppMethodBeat.o(114690);
                    return;
                }
        }
        AppMethodBeat.o(114690);
    }

    public final ViewGroup chG() {
        AppMethodBeat.i(114691);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.h9c);
        AppMethodBeat.o(114691);
        return viewGroup;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(239452);
        super.finish();
        if (this.zPJ != null) {
            this.zPJ.huQ = false;
        }
        if (this.orientationEventListener != null) {
            this.orientationEventListener.disable();
            this.orientationEventListener.ztH = null;
            this.orientationEventListener = null;
        }
        AppMethodBeat.o(239452);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.d.a
    public void onOrientationChange(int i2) {
        AppMethodBeat.i(239453);
        if (eov()) {
            k kVar = this.zPK;
            kotlin.g.b.p.h(this, "context");
            if (k.a.gE(this) != kVar.zTy) {
                kVar.refreshView();
                if (k.a.gE(this) == 90 || k.a.gE(this) == 270) {
                    com.tencent.mm.plugin.multitalk.model.p.zMt++;
                }
            }
            AppMethodBeat.o(239453);
            return;
        }
        this.zPJ.Rv(i2);
        AppMethodBeat.o(239453);
    }

    public class ScreenActionReceiver extends BroadcastReceiver {
        public ScreenActionReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(114662);
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.SCREEN_OFF")) {
                Log.i("MicroMsg.MT.MultiTalkMainUI", "receive action screen off");
                MultiTalkMainUI multiTalkMainUI = MultiTalkMainUI.this;
                multiTalkMainUI.zPV.removeCallbacksAndMessages(null);
                multiTalkMainUI.zPV.sendEmptyMessage(0);
            }
            AppMethodBeat.o(114662);
        }
    }
}
