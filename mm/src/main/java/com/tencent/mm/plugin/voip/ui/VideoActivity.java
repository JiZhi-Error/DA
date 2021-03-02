package com.tencent.mm.plugin.voip.ui;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.NewVoipMgr;
import com.tencent.mm.plugin.voip.model.VoipMgr;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VoipBaseFragment;
import com.tencent.mm.plugin.voip.video.b.a;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.video.d.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.lang.ref.WeakReference;

@i
@a(3)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity extends MMActivity implements ServiceConnection, d.a, VoipBaseFragment.d, b {
    private as GUe;
    private boolean GUf;
    private boolean GUg;
    private int GUk = -1;
    private VoipBaseFragment Hem;
    private WeakReference<c> Hen;
    private long Heo = -1;
    private long Hep = 0;
    private boolean Heq = false;
    private int Her = 1;
    private boolean Hes = false;
    private boolean Het = false;
    private boolean Heu = false;
    private long Hev;
    @Deprecated
    com.tencent.mm.plugin.voip.video.b.a Hew;
    @Deprecated
    b Hex;
    private String goe;
    private IListener hvF = new IListener<ma>() {
        /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass1 */

        {
            AppMethodBeat.i(161658);
            this.__eventId = ma.class.getName().hashCode();
            AppMethodBeat.o(161658);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ma maVar) {
            AppMethodBeat.i(115310);
            if (maVar instanceof ma) {
                Log.i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent thread name[%s]", Thread.currentThread().getName());
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(115309);
                        if (!(VideoActivity.this.Hen == null || VideoActivity.this.Hen.get() == null)) {
                            Log.i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent ret[%b, %b, %b]", Boolean.valueOf(((c) VideoActivity.this.Hen.get()).fFB()), Boolean.valueOf(((c) VideoActivity.this.Hen.get()).fFA()), Boolean.valueOf(((c) VideoActivity.this.Hen.get()).fFt()));
                        }
                        AppMethodBeat.o(115309);
                    }
                });
            }
            AppMethodBeat.o(115310);
            return false;
        }
    };
    private Point imX;
    private MMHandler kAn;
    private boolean mIsMute = false;
    private int mStatus;
    d orientationEventListener;
    private CaptureView qsJ;
    private boolean sVW = false;
    private com.tencent.mm.plugin.voip.a.b yyX;
    private boolean yzR = false;
    private boolean yzS = false;
    private IListener zDy = new IListener<ko>() {
        /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass10 */

        {
            AppMethodBeat.i(161659);
            this.__eventId = ko.class.getName().hashCode();
            AppMethodBeat.o(161659);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ko koVar) {
            AppMethodBeat.i(115318);
            ko koVar2 = koVar;
            if (!(koVar2 == null || koVar2.dPG == null)) {
                Log.i("MicroMsg.Voip.VideoActivity", "summerhardcoder system event [%s]", Integer.valueOf(koVar2.dPG.keycode));
                if (koVar2.dPG.keycode == 1) {
                    VideoActivity.f(VideoActivity.this);
                }
            }
            AppMethodBeat.o(115318);
            return false;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VideoActivity() {
        AppMethodBeat.i(115323);
        AppMethodBeat.o(115323);
    }

    static /* synthetic */ void e(VideoActivity videoActivity) {
        AppMethodBeat.i(115363);
        videoActivity.fFP();
        AppMethodBeat.o(115363);
    }

    static /* synthetic */ void f(VideoActivity videoActivity) {
        AppMethodBeat.i(115364);
        videoActivity.fJw();
        AppMethodBeat.o(115364);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        com.tencent.mm.plugin.voip.a aVar;
        boolean booleanValue;
        AppMethodBeat.i(115324);
        super.onCreate(bundle);
        try {
            t tVar = t.GYO;
            t.fHu();
            com.tencent.mm.util.d.fAL();
            setActionbarColor(getResources().getColor(R.color.ac_));
            setRequestedOrientation(7);
            if (!m.hC(getContext())) {
                m.hD(getContext());
            }
            Log.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
            getSupportActionBar().hide();
            getWindow().setSoftInputMode(3);
            this.orientationEventListener = new d(this);
            this.orientationEventListener.enable();
            this.orientationEventListener.ztH = this;
            getWindow().addFlags(6815872);
            if (g.aAc()) {
                c.fFg().aG(false, false);
            }
            this.kAn = new MMHandler();
            PBool pBool = new PBool();
            PBool pBool2 = new PBool();
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            pString.value = getIntent().getStringExtra("Voip_User");
            pBool.value = getIntent().getBooleanExtra("Voip_Outcall", true);
            pBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
            this.Hev = getIntent().getLongExtra("Voip_LastPage_Hash", 0);
            pInt.value = k.aQ(pBool.value, pBool2.value);
            PLong pLong = new PLong();
            pLong.value = getIntent().getLongExtra("Voip_CallRoomKey", 0);
            pInt2.value = getIntent().getIntExtra("Voip_Call_From", -1);
            if (pBool.value) {
                try {
                    if (enQ() && !isFinishing()) {
                        Toast.makeText(this, (int) R.string.i2z, 0).show();
                        Log.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
                        c.fFg().unRegister();
                        super.finish();
                        AppMethodBeat.o(115324);
                        return;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.Voip.VideoActivity", "not ready now!");
                }
            }
            if (com.tencent.mm.plugin.voip.b.d.fJQ()) {
                com.tencent.mm.plugin.voip.b.d dVar = com.tencent.mm.plugin.voip.b.d.HgU;
                com.tencent.mm.plugin.voip.b.d.fJZ();
            }
            if (pLong.value != c.fFg().fHV()) {
                if (c.fFg().fHV() != 0) {
                    com.tencent.mm.plugin.voip.b.d dVar2 = com.tencent.mm.plugin.voip.b.d.HgU;
                    com.tencent.mm.plugin.voip.b.d.fJS();
                    boolean z = pBool.value || c.fFg().GYS.fGt();
                    com.tencent.mm.plugin.voip.b.d dVar3 = com.tencent.mm.plugin.voip.b.d.HgU;
                    com.tencent.mm.plugin.voip.b.d.a(pInt2.value, true, pLong.value, c.fFg().fHV(), z);
                }
                if (com.tencent.mm.plugin.voip.b.d.fJQ() && c.fFg().fHV() != 0) {
                    Log.e("MicroMsg.Voip.VideoActivity", "fake calling comming and forbid itself cause key is no similar");
                    c.fFg().unRegister();
                    super.finish();
                    AppMethodBeat.o(115324);
                    return;
                }
            } else {
                com.tencent.mm.plugin.voip.b.d dVar4 = com.tencent.mm.plugin.voip.b.d.HgU;
                com.tencent.mm.plugin.voip.b.d.fJT();
                boolean z2 = pBool.value || c.fFg().GYS.fGt();
                com.tencent.mm.plugin.voip.b.d dVar5 = com.tencent.mm.plugin.voip.b.d.HgU;
                com.tencent.mm.plugin.voip.b.d.a(pInt2.value, false, pLong.value, c.fFg().fHV(), z2);
            }
            if (pBool.value || c.fFg().GYS.fGt() || !com.tencent.mm.plugin.voip.b.d.fJR()) {
                u fFg = c.fFg();
                if (fFg.GYT != null) {
                    Log.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
                    pString.value = fFg.GYT.getUserName();
                    pBool.value = fFg.GYT.fFa();
                    pBool2.value = fFg.GYT.fEZ();
                    pInt.value = fFg.GYT.getState();
                    aVar = fFg.GYT;
                } else {
                    Log.i("MicroMsg.Voip.VoipService", "pToUser before is %s and after is %s", pString.value, fFg.GYS.toUser);
                    if (!pString.value.equals(fFg.GYS.toUser)) {
                        com.tencent.mm.plugin.voip.b.d dVar6 = com.tencent.mm.plugin.voip.b.d.HgU;
                        com.tencent.mm.plugin.voip.b.d.fJY();
                    }
                    if (com.tencent.mm.plugin.voip.b.d.fJR()) {
                        pString.value = fFg.GYS.toUser;
                    }
                    pString.value = fFg.GYS.toUser;
                    pBool2.value = fFg.GYS.GZt;
                    if (pString.value == null) {
                        Log.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
                        aVar = null;
                    } else if (pBool.value || fFg.GYS.fGt()) {
                        if (com.tencent.mm.plugin.voip.b.g.fKe()) {
                            fFg.GYT = new NewVoipMgr();
                        } else {
                            fFg.GYT = new VoipMgr();
                        }
                        fFg.GYT.a(this, pString.value, pBool.value, pBool2.value, pLong.value);
                        aVar = fFg.GYT;
                    } else {
                        Log.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
                        s.c(pString.value, pBool2.value ? ca.OqC : ca.OqB, pBool.value ? 1 : 0, 4, MMApplicationContext.getContext().getString(R.string.i14));
                        aVar = null;
                    }
                }
                if (aVar == null) {
                    Log.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
                    c.fFg().unRegister();
                    super.finish();
                    AppMethodBeat.o(115324);
                    return;
                }
                this.Hen = new WeakReference<>(aVar);
                this.goe = pString.value;
                this.GUg = pBool2.value;
                this.GUf = pBool.value;
                this.mStatus = pInt.value;
                this.GUe = ((l) g.af(l.class)).aSN().Kn(this.goe);
                Bundle bundle2 = new Bundle();
                bundle2.putString("key_username", this.GUe.field_username);
                bundle2.putBoolean("key_isoutcall", this.GUf);
                bundle2.putInt("key_status", k.aQ(this.GUf, this.GUg));
                if (!k.adQ(this.mStatus)) {
                    this.Hem = new VoipVoiceFragment();
                } else if (com.tencent.mm.plugin.voip.b.g.fKe()) {
                    this.Hem = new NewVoipVideoFragment();
                } else {
                    this.Hem = new VoipVideoFragment();
                }
                this.Hem.setArguments(bundle2);
                getSupportFragmentManager().beginTransaction().b(R.id.jar, this.Hem).commit();
                setTitleVisibility(8);
                if (k.adR(this.mStatus) && this.GUf) {
                    this.kAn.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass7 */

                        public final void run() {
                            AppMethodBeat.i(115315);
                            if (k.adR(VideoActivity.this.mStatus) && !VideoActivity.this.sVW && VideoActivity.this.Hem != null) {
                                VideoActivity.this.Hem.jE(R.string.i1h, 10000);
                            }
                            AppMethodBeat.o(115315);
                        }
                    }, 20000);
                }
                if (c.fFg().GYT.fFb() != null) {
                    aUB(c.fFg().GYT.fFb());
                }
                if (this.GUg) {
                    s.hA(this);
                }
                this.yyX = new com.tencent.mm.plugin.voip.a.b(new e(this));
                this.yyX.G(9, "VOIPFloatBall");
                if (!(this.Hen == null || this.Hen.get() == null)) {
                    this.Hen.get().a(this, 1);
                }
                this.Hem.setVoipUIListener(this.Hen.get());
                this.Hem.a(this);
                this.Hem.setMute(this.mIsMute);
                Log.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", Boolean.valueOf(this.GUf), Boolean.valueOf(this.GUg), this.goe, Integer.valueOf(this.mStatus));
                if (k.adQ(this.mStatus)) {
                    boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
                    Log.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), this);
                    if (!a2) {
                        this.Hen.get().fFx();
                    }
                    Log.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), Util.getStack(), this);
                } else {
                    Log.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), Util.getStack(), this);
                }
                EventCenter.instance.addListener(this.hvF);
                EventCenter.instance.addListener(this.zDy);
                if (com.tencent.mm.compatible.util.d.oD(17)) {
                    this.imX = new Point();
                    if (getWindow().getDecorView().getDisplay() != null) {
                        getWindow().getDecorView().getDisplay().getRealSize(this.imX);
                    }
                }
                AppMethodBeat.o(115324);
                return;
            }
            Log.e("MicroMsg.Voip.VideoActivity", "fake calling comming and forbid itself cause engine is close");
            c.fFg().unRegister();
            com.tencent.mm.plugin.voip.b.d dVar7 = com.tencent.mm.plugin.voip.b.d.HgU;
            com.tencent.mm.plugin.voip.b.d.fJX();
            com.tencent.mm.plugin.voip.b.d dVar8 = com.tencent.mm.plugin.voip.b.d.HgU;
            com.tencent.mm.plugin.voip.b.d.a(pInt2.value, true, pLong.value, c.fFg().fHV(), true);
            com.tencent.mm.plugin.voip.b.d dVar9 = com.tencent.mm.plugin.voip.b.d.HgU;
            Boolean bool = c.fFg().GZp.get(Long.valueOf(pLong.value));
            if (bool == null) {
                booleanValue = false;
            } else {
                booleanValue = bool.booleanValue();
            }
            if (booleanValue) {
                com.tencent.mm.plugin.voip.b.d.fKa();
            } else {
                com.tencent.mm.plugin.voip.b.d.fKb();
            }
            super.finish();
            AppMethodBeat.o(115324);
        } catch (Exception e3) {
            com.tencent.mm.plugin.voip.b.e.adG(2);
            Log.printErrStackTrace("MicroMsg.Voip.VideoActivity", e3, "", new Object[0]);
            AppMethodBeat.o(115324);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(115325);
        super.onConfigurationChanged(configuration);
        if (this.imX != null && com.tencent.mm.compatible.util.d.oD(17)) {
            Point point = new Point();
            getWindowManager().getDefaultDisplay().getRealSize(point);
            if (!point.equals(this.imX) && this.Hem != null) {
                this.imX = point;
                this.Hem.m(this.imX);
            }
        }
        AppMethodBeat.o(115325);
    }

    private static boolean enQ() {
        Exception e2;
        boolean z;
        AppMethodBeat.i(115326);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
            if (telephonyManager != null) {
                int callState = telephonyManager.getCallState();
                switch (callState) {
                    case 0:
                    case 1:
                        z = false;
                        break;
                    case 2:
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                try {
                    Log.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", Integer.valueOf(callState));
                } catch (Exception e3) {
                    e2 = e3;
                    Log.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", e2.getLocalizedMessage());
                    AppMethodBeat.o(115326);
                    return z;
                }
            } else {
                z = false;
            }
        } catch (Exception e4) {
            e2 = e4;
            z = false;
            Log.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", e2.getLocalizedMessage());
            AppMethodBeat.o(115326);
            return z;
        }
        AppMethodBeat.o(115326);
        return z;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    private void fFP() {
        AppMethodBeat.i(115327);
        this.kAn.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(115316);
                VideoActivity.this.finish();
                AppMethodBeat.o(115316);
            }
        }, 2000);
        AppMethodBeat.o(115327);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void jD(int i2, int i3) {
        AppMethodBeat.i(115328);
        this.mStatus = i3;
        if (1 != this.Her && i3 != 8 && i3 != 262) {
            Log.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
            AppMethodBeat.o(115328);
        } else if (this.Hem == null) {
            Log.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
            AppMethodBeat.o(115328);
        } else {
            this.Hem.jD(i2, i3);
            switch (i3) {
                case 1:
                case 3:
                case 7:
                case CdnLogic.kAppTypeFestivalImage:
                case 261:
                    this.GUg = false;
                    if (this.Hem == null || !(this.Hem instanceof VoipVoiceFragment)) {
                        if (this.Hem != null) {
                            this.Hem.uninit();
                            getSupportFragmentManager().beginTransaction().a(this.Hem).commit();
                            this.Hem = null;
                        }
                        Log.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
                        Bundle bundle = new Bundle();
                        bundle.putString("key_username", this.GUe.field_username);
                        bundle.putBoolean("key_isoutcall", this.GUf);
                        bundle.putInt("key_status", this.mStatus);
                        this.Hem = new VoipVoiceFragment();
                        this.Hem.setArguments(bundle);
                        this.Hem.setVoipUIListener(this.Hen.get());
                        this.Hem.Li(this.Heo);
                        this.Hem.a(this);
                        this.Hem.setVoicePlayDevice(this.GUk);
                        this.Hem.setMute(this.mIsMute);
                        getSupportFragmentManager().beginTransaction().b(R.id.jar, this.Hem).commit();
                    }
                    AppMethodBeat.o(115328);
                    return;
                case 8:
                case 262:
                    switch (i2) {
                        case 4098:
                            this.kAn.postDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass9 */

                                public final void run() {
                                    AppMethodBeat.i(115317);
                                    VideoActivity.e(VideoActivity.this);
                                    AppMethodBeat.o(115317);
                                }
                            }, 50);
                            break;
                        case 4099:
                            if (this.GUf) {
                                this.Hem.jE(this.GUg ? R.string.i4p : R.string.i0v, -1);
                            }
                            fFP();
                            break;
                        case 4103:
                        case 4104:
                            fFP();
                            break;
                        case 4106:
                            this.kAn.post(new Runnable() {
                                /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(115311);
                                    if (VideoActivity.this.Hem != null) {
                                        VideoActivity.this.Hem.jE(R.string.i4c, -1);
                                    }
                                    VideoActivity.e(VideoActivity.this);
                                    AppMethodBeat.o(115311);
                                }
                            });
                            break;
                        case 4107:
                            finish();
                            break;
                        case 4109:
                            this.kAn.post(new Runnable() {
                                /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(235763);
                                    VideoActivity.e(VideoActivity.this);
                                    AppMethodBeat.o(235763);
                                }
                            });
                            break;
                    }
                    fFP();
                    Log.d("MicroMsg.Voip.VideoActivity", "finishSmallWindow mStatus: %s", k.adM(this.mStatus));
                    if (this.mStatus == 262 || this.mStatus == 8) {
                        c.fFh().rX(true);
                        break;
                    }
            }
            AppMethodBeat.o(115328);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(115329);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.pH(i2);
        bVar.bm(keyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", this, bVar.axR());
        if (keyEvent.getKeyCode() == 4) {
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(115329);
            return true;
        } else if (i2 == 25) {
            if (c.fFg().GYS.czl() || this.GUf) {
                com.tencent.mm.plugin.audio.c.a.AX(com.tencent.mm.plugin.audio.c.a.cea().isBluetoothScoOn() ? com.tencent.mm.plugin.audio.c.a.cdX() : eaL());
            } else if (!(this.Hen == null || this.Hen.get() == null)) {
                this.Hen.get().fFK();
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(115329);
            return true;
        } else if (i2 == 24) {
            if (c.fFg().GYS.czl() || this.GUf) {
                com.tencent.mm.plugin.audio.c.a.AW(com.tencent.mm.plugin.audio.c.a.cea().isBluetoothScoOn() ? com.tencent.mm.plugin.audio.c.a.cdX() : eaL());
            } else {
                this.Hen.get().fFK();
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(115329);
            return true;
        } else if (ae.gKt.gFC == 1 && i2 == 700) {
            fJw();
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(115329);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onKeyDown, this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "onKeyDown", "(ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(115329);
            return onKeyDown;
        }
    }

    private void fJw() {
        AppMethodBeat.i(115330);
        if (!(this.Hen == null || this.Hen.get() == null || this.GUf)) {
            if (this.GUg) {
                this.Hen.get().fFw();
            } else {
                this.Hen.get().fFz();
            }
            if (c.fFg().dya && this.GUg) {
                this.Hen.get().fFG();
            }
        }
        AppMethodBeat.o(115330);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(115331);
        this.Her = 4;
        Log.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", k.adM(this.mStatus));
        t tVar = t.GYO;
        t.fHv();
        if (!this.yzR) {
            finish();
        }
        if (!(this.Hen == null || this.Hen.get() == null)) {
            this.Hen.get().a(this);
        }
        if (this.yyX != null) {
            this.yyX.onDestroy();
        }
        EventCenter.instance.removeListener(this.hvF);
        EventCenter.instance.removeListener(this.zDy);
        setScreenEnable(true);
        super.onDestroy();
        if (!this.Heq) {
            com.tencent.mm.media.g.c.igu.aMA();
        }
        AppMethodBeat.o(115331);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(115332);
        this.Her = 2;
        Log.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", k.adM(this.mStatus));
        if (262 != this.mStatus && 8 != this.mStatus && this.yzS && !this.Hes && !this.yzR && this.Hen != null && this.Hen.get() != null && this.Hen.get().wX(false)) {
            if (this.Hem != null) {
                this.Hem.fJx();
            }
            aI(false, true);
            if (k.adP(this.mStatus)) {
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(k.adQ(this.mStatus) ? 2 : 3);
                objArr[1] = 2;
                hVar.a(11618, objArr);
            }
        }
        if (this.yyX != null && !this.Hes) {
            this.yyX.aGj();
            f.e(false, true, true);
        }
        super.onStop();
        AppMethodBeat.o(115332);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(115333);
        super.onStart();
        if (!this.yzR) {
            Log.i("MicroMsg.Voip.VideoActivity", "onStart");
            this.Her = 1;
            jD(4096, this.mStatus);
        }
        AppMethodBeat.o(115333);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        boolean z;
        AppMethodBeat.i(115334);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V", this);
        this.Her = 3;
        Log.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", Boolean.valueOf(this.Heq), k.adM(this.mStatus));
        if (!this.Heq && k.adP(this.mStatus) && 4 != this.Her) {
            Log.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", this.goe);
            com.tencent.mm.plugin.voip.d.jRt.d(intent, this);
        }
        if (this.Heu) {
            this.Heu = false;
            com.tencent.mm.plugin.voip.b.e.c(c.fFg().fHU(), c.fFg().fHV(), this.GUf ? 0 : 1, 5);
            com.tencent.mm.plugin.voip.b.e.adG(1);
        }
        if (this.orientationEventListener != null) {
            this.orientationEventListener.disable();
            this.orientationEventListener.ztH = null;
            this.orientationEventListener = null;
        }
        if (this.Hem != null) {
            if (this.Hem.HeE == 4105) {
                z = true;
            } else {
                z = false;
            }
            this.Hem.uninit();
            this.Hem = null;
        } else {
            z = false;
        }
        this.Hen = null;
        this.qsJ = null;
        this.yzR = true;
        super.finish();
        if (z) {
            kv kvVar = new kv();
            kvVar.dPV.dPY = true;
            kvVar.dPV.dPX = this.Hev;
            EventCenter.instance.publish(kvVar);
        } else {
            kv kvVar2 = new kv();
            kvVar2.dPV.dPY = false;
            kvVar2.dPV.dPX = 0;
            EventCenter.instance.publish(kvVar2);
        }
        VoipBaseFragment.HeF = -1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "finish", "()V");
        AppMethodBeat.o(115334);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.voip.ui.b
    public void setScreenEnable(boolean z) {
        AppMethodBeat.i(115335);
        super.setScreenEnable(z);
        if (this.Hen != null) {
            this.Hen.get();
        }
        AppMethodBeat.o(115335);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(115336);
        Log.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.o(115336);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        boolean z;
        AppMethodBeat.i(115337);
        super.onPause();
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        boolean hasWindowFocus = hasWindowFocus();
        boolean isScreenOn = ((PowerManager) MMApplicationContext.getContext().getSystemService("power")).isScreenOn();
        if ((hasWindowFocus || !inKeyguardRestrictedInputMode) && isScreenOn) {
            z = true;
        } else {
            z = false;
        }
        this.yzS = z;
        Log.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", k.adM(this.mStatus), Boolean.valueOf(this.yzS), Boolean.valueOf(hasWindowFocus), Boolean.valueOf(inKeyguardRestrictedInputMode), Boolean.valueOf(isScreenOn));
        AppMethodBeat.o(115337);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(115338);
        Log.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", k.adM(this.mStatus));
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        com.tencent.mm.plugin.voip.model.l lVar = c.fFg().GYS.GSZ;
        if (lVar.GVH) {
            lVar.GVH = false;
        }
        super.onResume();
        if (!(this.Hen == null || this.Hen.get() == null)) {
            this.Hen.get().fFC();
        }
        onOrientationChange(0);
        setScreenEnable(true);
        this.Hep = Util.currentTicks();
        this.Heu = true;
        if (!(this.Hen == null || this.Hen.get() == null)) {
            this.Hen.get().fFD();
        }
        if (this.yyX != null && !this.Hes) {
            this.yyX.aGf();
            f.e(true, false, true);
        }
        AppMethodBeat.o(115338);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void cF(final int i2, String str) {
        AppMethodBeat.i(115341);
        Log.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", Integer.valueOf(i2), Boolean.valueOf(this.GUg));
        this.sVW = true;
        if (i2 == 241) {
            com.tencent.mm.ui.base.h.c(this, str, null, true);
            AppMethodBeat.o(115341);
            return;
        }
        this.kAn.post(new Runnable() {
            /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(235765);
                VideoActivity.a(VideoActivity.this, i2);
                AppMethodBeat.o(235765);
            }
        });
        AppMethodBeat.o(115341);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final void setCaptureView(CaptureView captureView) {
        AppMethodBeat.i(235766);
        this.qsJ = captureView;
        if (this.Hem != null) {
            this.Hem.a(captureView);
        }
        AppMethodBeat.o(235766);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final void fJj() {
        AppMethodBeat.i(115361);
        if (this.Hem instanceof VoipVideoFragment) {
            ((VoipVideoFragment) this.Hem).fJj();
        }
        AppMethodBeat.o(115361);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final void setVoipBeauty(int i2) {
        AppMethodBeat.i(115348);
        if (this.Hem != null) {
            this.Hem.setVoipBeauty(i2);
        }
        AppMethodBeat.o(115348);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final void setSpatiotemporalDenosing(int i2) {
        AppMethodBeat.i(235767);
        if (this.Hem != null) {
            this.Hem.setSpatiotemporalDenosing(i2);
        }
        AppMethodBeat.o(235767);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final void setHWDecMode(int i2) {
        AppMethodBeat.i(115349);
        if (this.Hem != null) {
            this.Hem.setHWDecMode(i2);
        }
        AppMethodBeat.o(115349);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final void requestRender() {
        AppMethodBeat.i(115352);
        if (this.Hem != null) {
            this.Hem.requestRender();
        }
        AppMethodBeat.o(115352);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final void releaseSurfaceTexture() {
        AppMethodBeat.i(115353);
        if (this.Hem != null) {
            this.Hem.releaseSurfaceTexture();
        }
        AppMethodBeat.o(115353);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final com.tencent.mm.plugin.voip.video.b.a adw(int i2) {
        AppMethodBeat.i(115340);
        if ((this.Hem instanceof VoipVideoFragment) && this.Hem.fJy() != null) {
            this.Hem.fJy().a(i2, new a.b() {
                /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass12 */

                @Override // com.tencent.mm.plugin.voip.video.b.a.b
                public final void a(com.tencent.mm.plugin.voip.video.b.a aVar) {
                    if (aVar != null) {
                        VideoActivity.this.Hew = aVar;
                    }
                }
            });
        }
        com.tencent.mm.plugin.voip.video.b.a aVar = this.Hew;
        AppMethodBeat.o(115340);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final b fJk() {
        AppMethodBeat.i(235768);
        if (!(this.Hem == null || this.Hem.fJy() == null)) {
            this.Hem.getSpatioTemporalFilterData().a(new b.AbstractC1893b() {
                /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass13 */

                @Override // com.tencent.mm.plugin.voip.video.d.b.AbstractC1893b
                public final void a(b bVar) {
                    if (bVar != null) {
                        VideoActivity.this.Hex = bVar;
                    }
                }
            });
        }
        b bVar = this.Hex;
        AppMethodBeat.o(235768);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final void jA(int i2, int i3) {
        AppMethodBeat.i(115350);
        if (this.Hem != null) {
            this.Hem.jA(i2, i3);
        }
        AppMethodBeat.o(115350);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final void a(SurfaceTexture surfaceTexture, com.tencent.mm.media.g.d dVar) {
        AppMethodBeat.i(115351);
        if (this.Hem != null) {
            this.Hem.a(surfaceTexture, dVar);
        }
        AppMethodBeat.o(115351);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final void f(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(115347);
        if (this.Hem != null) {
            this.Hem.f(i2, i3, bArr);
        }
        AppMethodBeat.o(115347);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    @Deprecated
    public final void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(235769);
        if (this.Hem != null) {
            this.Hem.b(bArr, j2, i2, i3, i4, i5, i6);
        }
        AppMethodBeat.o(235769);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void aUB(final String str) {
        AppMethodBeat.i(115342);
        if (this.Hem != null) {
            this.kAn.post(new Runnable() {
                /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass14 */

                public final void run() {
                    AppMethodBeat.i(115321);
                    if (VideoActivity.this.Hem != null) {
                        VideoActivity.this.Hem.aUB(str);
                    }
                    AppMethodBeat.o(115321);
                }
            });
        }
        AppMethodBeat.o(115342);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c71;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void dealContentView(View view) {
        AppMethodBeat.i(115343);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V", this, bVar.axR());
        ao.p(ao.a(getWindow(), (View) null), getBodyView());
        ((ViewGroup) getWindow().getDecorView()).addView(view, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VideoActivity", "com/tencent/mm/plugin/voip/ui/VideoActivity", "dealContentView", "(Landroid/view/View;)V");
        AppMethodBeat.o(115343);
    }

    private int eaL() {
        int bhV;
        AppMethodBeat.i(115344);
        if (com.tencent.mm.plugin.audio.c.a.cea().isBluetoothScoOn()) {
            int cdX = com.tencent.mm.plugin.audio.c.a.cdX();
            AppMethodBeat.o(115344);
            return cdX;
        }
        if (!k.adP(this.mStatus)) {
            bhV = 2;
            if (this.GUf) {
                if (!this.GUg) {
                    if (ae.gKu.gEk >= 0) {
                        bhV = ae.gKu.gEk;
                    }
                    bhV = 0;
                } else {
                    bhV = 3;
                    if (com.tencent.mm.plugin.audio.c.a.cdW()) {
                        if (ae.gKu.gEk >= 0) {
                            bhV = ae.gKu.gEk;
                        }
                        bhV = 0;
                    } else if (ae.gKu.gEh >= 0) {
                        bhV = ae.gKu.gEh;
                    }
                }
            } else if (com.tencent.mm.plugin.audio.c.a.cdW()) {
                if (ae.gKu.gEk >= 0) {
                    bhV = ae.gKu.gEk;
                }
                bhV = 0;
            }
            if (!com.tencent.mm.plugin.audio.c.a.ceb() && ae.gKu.gEm >= 0) {
                bhV = ae.gKu.gEm;
            }
        } else {
            bhV = c.fFg().bhV();
        }
        Log.i("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", Integer.valueOf(bhV));
        AppMethodBeat.o(115344);
        return bhV;
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setVoicePlayDevice(int i2) {
        AppMethodBeat.i(115345);
        if (this.GUk != -1) {
            switch (i2) {
                case 1:
                    Toast.makeText(getContext(), getContext().getString(R.string.i4v), 0).show();
                    if (!this.GUg) {
                        setScreenEnable(true);
                        break;
                    }
                    break;
                case 2:
                    Toast.makeText(getContext(), getContext().getString(R.string.i4u), 0).show();
                    break;
                default:
                    if (!this.GUg) {
                        setScreenEnable(true);
                        break;
                    }
                    break;
            }
        }
        this.GUk = i2;
        if (!(this.Hen == null || this.Hen.get() == null)) {
            this.Hen.get().setVoicePlayDevice(i2);
        }
        if (this.Hem != null) {
            this.Hem.setVoicePlayDevice(i2);
        }
        AppMethodBeat.o(115345);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setMute(boolean z) {
        AppMethodBeat.i(115346);
        this.mIsMute = z;
        if (this.Hem != null) {
            this.Hem.setMute(z);
        }
        AppMethodBeat.o(115346);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void enR() {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void fJn() {
        AppMethodBeat.i(235770);
        if (this.Hem != null) {
            this.Hem.adB(10);
        }
        AppMethodBeat.o(235770);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void fFL() {
        AppMethodBeat.i(235771);
        Intent intent = new Intent(this, SettingsAboutCamera.class);
        intent.putExtra("activity_caller_params", 1);
        startActivityForResult(intent, 1);
        this.Hes = true;
        AppMethodBeat.o(235771);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(235772);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            this.Hes = false;
            if (this.Hem != null) {
                this.Hem.adB(5);
            }
        }
        AppMethodBeat.o(235772);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final Context fJl() {
        AppMethodBeat.i(115354);
        AppCompatActivity context = getContext();
        AppMethodBeat.o(115354);
        return context;
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void uninit() {
        AppMethodBeat.i(115355);
        if (this.Hem != null) {
            this.Hem.uninit();
        }
        AppMethodBeat.o(115355);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setConnectSec(long j2) {
        AppMethodBeat.i(115356);
        this.Heo = j2;
        if (this.Hem != null) {
            this.Hem.Li(this.Heo);
        }
        AppMethodBeat.o(115356);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void xi(boolean z) {
        AppMethodBeat.i(115357);
        Log.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning isSelfNetBad".concat(String.valueOf(z)));
        if (this.Hem != null) {
            this.Hem.xk(z);
        }
        AppMethodBeat.o(115357);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void ebH() {
        AppMethodBeat.i(115358);
        Log.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
        if (this.Hem != null) {
            this.Hem.fJq();
        }
        AppMethodBeat.o(115358);
    }

    @Override // com.tencent.mm.plugin.voip.ui.VoipBaseFragment.d
    public final void aI(boolean z, boolean z2) {
        AppMethodBeat.i(115359);
        this.Heq = z2;
        if (z) {
            fFP();
            AppMethodBeat.o(115359);
            return;
        }
        finish();
        AppMethodBeat.o(115359);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(115362);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(115362);
            return;
        }
        Log.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 19:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString("android.permission.CAMERA".equals(strArr[0]) ? R.string.fl0 : R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(115313);
                            dialogInterface.dismiss();
                            VideoActivity videoActivity = VideoActivity.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(videoActivity, bl.axQ(), "com/tencent/mm/plugin/voip/ui/VideoActivity$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            videoActivity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(videoActivity, "com/tencent/mm/plugin/voip/ui/VideoActivity$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(115313);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(115314);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(115314);
                        }
                    });
                    AppMethodBeat.o(115362);
                    return;
                }
                break;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voip.ui.VideoActivity.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(235764);
                            VideoActivity videoActivity = VideoActivity.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(videoActivity, bl.axQ(), "com/tencent/mm/plugin/voip/ui/VideoActivity$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            videoActivity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(videoActivity, "com/tencent/mm/plugin/voip/ui/VideoActivity$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(235764);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                }
                break;
        }
        AppMethodBeat.o(115362);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void fJm() {
        AppMethodBeat.i(235773);
        if (this.Hem != null) {
            this.Hem.fJm();
        }
        AppMethodBeat.o(235773);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void adx(int i2) {
        AppMethodBeat.i(235774);
        if (this.Hem != null) {
            this.Hem.adx(i2);
        }
        AppMethodBeat.o(235774);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void ady(int i2) {
        AppMethodBeat.i(235775);
        if (this.Hem != null) {
            this.Hem.ady(i2);
        }
        AppMethodBeat.o(235775);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void adz(int i2) {
        AppMethodBeat.i(235776);
        if (this.Hem != null) {
            this.Hem.adz(i2);
        }
        AppMethodBeat.o(235776);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.d.a
    public void onOrientationChange(int i2) {
        int i3 = 0;
        AppMethodBeat.i(235777);
        int rotation = ((WindowManager) getSystemService("window")).getDefaultDisplay().getRotation();
        switch (rotation) {
            case 1:
                i3 = 90;
                break;
            case 2:
                i3 = 180;
                break;
            case 3:
                i3 = 270;
                break;
        }
        if (!(this.Hen == null || this.Hen.get() == null || this.Hem == null)) {
            this.Hen.get().jz(rotation, i3);
        }
        if (this.Hem != null) {
            this.Hem.setDeviceOrientation(i3);
        }
        AppMethodBeat.o(235777);
    }

    static /* synthetic */ void a(VideoActivity videoActivity, int i2) {
        int i3;
        int i4 = R.string.i2k;
        AppMethodBeat.i(115365);
        Log.d("MicroMsg.Voip.VideoActivity", "getHintByErrorCode ".concat(String.valueOf(i2)));
        if (i2 == 235) {
            i3 = R.string.i2m;
        } else if (i2 == 233) {
            c.fFg().fHY();
            i3 = R.string.i2l;
        } else if (i2 == 237) {
            if (!com.tencent.mm.aw.b.isOverseasUser() || videoActivity.GUg) {
                i3 = R.string.i2n;
            } else {
                i3 = R.string.i2p;
            }
        } else if (i2 == 236) {
            i3 = R.string.i30;
        } else if (i2 == 211) {
            i3 = R.string.i2o;
        } else {
            i3 = 0;
        }
        if (i3 != 0 || videoActivity.Hem == null) {
            if (i3 != 0) {
                i4 = i3;
            }
            MMSuperAlert.at(MMApplicationContext.getContext(), i4);
            AppMethodBeat.o(115365);
            return;
        }
        videoActivity.Hem.jE(R.string.i2k, -1);
        AppMethodBeat.o(115365);
    }
}
