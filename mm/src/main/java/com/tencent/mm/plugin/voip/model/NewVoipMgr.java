package com.tencent.mm.plugin.voip.model;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.SurfaceTexture;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.aaq;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.h;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.b.l;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.plugin.voip.video.render.c;
import com.tencent.mm.plugin.voip.video.render.j;
import com.tencent.mm.plugin.voip.video.render.m;
import com.tencent.mm.plugin.voip.video.render.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.rtmp.TXLiveConstants;
import kotlin.g.b.p;

public final class NewVoipMgr extends com.tencent.mm.plugin.voip.a implements c {
    static int[] GUR = new int[2];
    static int mHZ = 0;
    private b GTV = new b();
    private l GTW;
    private j GTX;
    private volatile com.tencent.mm.plugin.voip.ui.b GTY;
    private a GTZ = null;
    private boolean GUA = false;
    public int GUB = -1;
    public int GUC = 0;
    public int GUD = 0;
    private long GUE = 0;
    private long GUF = 0;
    private int GUG = 0;
    boolean GUH = false;
    boolean GUI = false;
    private int GUJ = 0;
    public int GUK = 0;
    public int GUL = 0;
    int GUM = 0;
    boolean GUN = false;
    NetChangedBroadcastReceiver GUO;
    PhoneStateListener GUP;
    MMHandler GUQ = new MMHandler("getSignalStrength");
    private long GUS = 0;
    private boolean GUT = false;
    private h GUU;
    private BroadcastReceiver GUV = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(235485);
            String action = intent.getAction();
            PowerManager powerManager = (PowerManager) MMApplicationContext.getContext().getSystemService("power");
            if (!"android.intent.action.USER_PRESENT".equals(action) || !powerManager.isScreenOn()) {
                if ("android.intent.action.SCREEN_ON".equals(action)) {
                    if (NewVoipMgr.this.GTX != null) {
                        NewVoipMgr.this.GTX.GYb = false;
                    }
                    NewVoipMgr.this.GTV.onSensorEvent(true);
                    AppMethodBeat.o(235485);
                    return;
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    if (NewVoipMgr.this.GTX != null) {
                        NewVoipMgr.this.GTX.GYb = true;
                    }
                    if (!NewVoipMgr.this.GUa) {
                        NewVoipMgr.this.GTV.onSensorEvent(true);
                    }
                    if (!k.adP(NewVoipMgr.this.GTW.mState) && !NewVoipMgr.this.GUf) {
                        com.tencent.mm.plugin.voip.c.fFg().GYS.stopRing();
                    }
                }
            } else if (NewVoipMgr.this.GTX != null) {
                NewVoipMgr.this.GTX.GYb = false;
                AppMethodBeat.o(235485);
                return;
            }
            AppMethodBeat.o(235485);
        }
    };
    int GUW = 0;
    private IListener GUX = new IListener<aaq>() {
        /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass9 */

        {
            AppMethodBeat.i(235496);
            this.__eventId = aaq.class.getName().hashCode();
            AppMethodBeat.o(235496);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaq aaq) {
            AppMethodBeat.i(235497);
            final aaq aaq2 = aaq;
            if (aaq2 instanceof aaq) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass9.AnonymousClass1 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    public final void run() {
                        AppMethodBeat.i(235495);
                        switch (aaq2.ehD.dDe) {
                            case 1:
                                if (k.adQ(NewVoipMgr.this.GTW.mState)) {
                                    NewVoipMgr.this.fFw();
                                    AppMethodBeat.o(235495);
                                    return;
                                }
                                NewVoipMgr.this.fFz();
                                AppMethodBeat.o(235495);
                                return;
                            case 2:
                                if (k.adQ(NewVoipMgr.this.GTW.mState)) {
                                    NewVoipMgr.this.fFv();
                                    AppMethodBeat.o(235495);
                                    return;
                                }
                                NewVoipMgr.this.fFy();
                                AppMethodBeat.o(235495);
                                return;
                            case 3:
                                NewVoipMgr.this.fFt();
                                break;
                        }
                        AppMethodBeat.o(235495);
                    }
                });
            }
            AppMethodBeat.o(235497);
            return false;
        }
    };
    private boolean GUa = true;
    private boolean GUb = false;
    private boolean GUc = false;
    private Object GUd = new Object();
    private as GUe;
    boolean GUf;
    private boolean GUg;
    private boolean GUh = false;
    private int GUi = 4096;
    private boolean GUj = false;
    private int GUk = -1;
    private long GUl = -1;
    private int GUm = 0;
    private f GUn = new f();
    private MTimerHandler GUo = null;
    private boolean GUp = false;
    private boolean GUq = false;
    private int GUr = 0;
    private boolean GUs = false;
    private int GUt = -1;
    private boolean GUu = false;
    private com.tencent.mm.plugin.voip.widget.b GUv;
    private boolean GUw = false;
    private boolean GUx = false;
    private String GUy = null;
    private boolean GUz = true;
    private long enterTime = -1;
    private String goe;
    private long iGC = -1;
    private MMHandler kAn;
    private int mUIType;
    PhoneStateListener mtH = new PhoneStateListener() {
        /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass18 */

        public final void onCallStateChanged(int i2, String str) {
            String string;
            int i3 = 1;
            AppMethodBeat.i(235511);
            super.onCallStateChanged(i2, str);
            Log.i("MicroMsg.Voip.NewVoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", Integer.valueOf(i2), Boolean.valueOf(NewVoipMgr.this.GUu), Integer.valueOf(NewVoipMgr.this.GUJ));
            if (!NewVoipMgr.this.GUu) {
                AppMethodBeat.o(235511);
                return;
            }
            if ((NewVoipMgr.this.GUJ == 0 && i2 == 1) || (NewVoipMgr.this.GUJ == 0 && i2 == 2)) {
                NewVoipMgr.v(NewVoipMgr.this);
            }
            if (i2 == 1) {
                NewVoipMgr.this.GUw = true;
                if (NewVoipMgr.this.GUJ == 0) {
                    NewVoipMgr.this.GUE = System.currentTimeMillis();
                }
                NewVoipMgr.this.GUJ = 1;
                com.tencent.mm.plugin.voip.c.fFg().adh(1);
                NewVoipMgr.this.GUT = true;
            } else if (i2 == 2) {
                NewVoipMgr.this.GUw = false;
                if (NewVoipMgr.this.GUJ == 1) {
                    NewVoipMgr.this.GUF = System.currentTimeMillis();
                }
                NewVoipMgr.this.GUJ = 2;
                Log.i("MicroMsg.Voip.NewVoipMgr", "phone call coming now!");
                if (NewVoipMgr.this.GUf && !k.adP(NewVoipMgr.this.GTW.mState)) {
                    com.tencent.mm.plugin.voip.c.fFg().GYS.fIv();
                }
                if (k.adP(NewVoipMgr.this.GTW.mState)) {
                    string = MMApplicationContext.getContext().getString(R.string.i1_, NewVoipMgr.Lg(Util.secondsToNow(NewVoipMgr.this.GUl)));
                } else {
                    string = MMApplicationContext.getContext().getString(R.string.i16);
                }
                com.tencent.mm.plugin.voip.c.fFg().fHS();
                String str2 = NewVoipMgr.this.GUe.field_username;
                String str3 = NewVoipMgr.this.GUg ? ca.OqC : ca.OqB;
                if (!NewVoipMgr.this.GUf) {
                    i3 = 0;
                }
                s.c(str2, str3, i3, 6, string);
                NewVoipMgr.d(NewVoipMgr.this, 4107);
                NewVoipMgr.y(NewVoipMgr.this);
                ca caVar = new ca();
                caVar.setType(10000);
                caVar.setCreateTime(System.currentTimeMillis());
                caVar.setStatus(6);
                caVar.setContent(MMApplicationContext.getContext().getString(R.string.i18) + ", <a href=\"weixin://voip/callagain/?username=" + NewVoipMgr.this.goe + "&isvideocall=" + NewVoipMgr.this.GUg + "\">" + MMApplicationContext.getContext().getString(R.string.i13) + "</a>");
                if (NewVoipMgr.this.goe != null && !NewVoipMgr.this.goe.equals("")) {
                    caVar.Cy(NewVoipMgr.this.goe);
                    ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar);
                }
                com.tencent.mm.plugin.voip.c.fFg().adh(2);
                NewVoipMgr.this.GUT = false;
            } else if (i2 == 0) {
                if (NewVoipMgr.this.GUJ == 1 || NewVoipMgr.this.GUJ == 2) {
                    NewVoipMgr.this.GUF = System.currentTimeMillis();
                }
                NewVoipMgr.this.GUJ = 0;
                com.tencent.mm.plugin.voip.c.fFg().adh(2);
                if (1 == NewVoipMgr.this.GUk && k.adP(NewVoipMgr.this.GTW.mState) && NewVoipMgr.this.GUw) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass18.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(235507);
                            NewVoipMgr.this.GTV.cV(true);
                            AppMethodBeat.o(235507);
                        }
                    });
                }
                if (4 == NewVoipMgr.this.GUk && NewVoipMgr.this.GUw) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass18.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(235508);
                            NewVoipMgr.this.GTV.aM(NewVoipMgr.this.GUx, NewVoipMgr.this.GUg);
                            AppMethodBeat.o(235508);
                        }
                    });
                }
                NewVoipMgr.this.GUw = false;
                if (com.tencent.mm.compatible.b.g.anF() != null && com.tencent.mm.plugin.audio.c.a.cea().isBluetoothScoOn()) {
                    Log.i("MicroMsg.Voip.NewVoipMgr", "is bluetooth can use and start bluetooth");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass18.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(235509);
                            NewVoipMgr.this.GTV.aM(NewVoipMgr.this.GUx, NewVoipMgr.this.GUg);
                            AppMethodBeat.o(235509);
                        }
                    });
                } else if (com.tencent.mm.plugin.audio.c.a.cea().cdW()) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass18.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(235510);
                            NewVoipMgr.this.GTV.aM(NewVoipMgr.this.GUx, NewVoipMgr.this.GUg);
                            AppMethodBeat.o(235510);
                        }
                    });
                }
                NewVoipMgr.this.GUT = false;
            }
            NewVoipMgr.this.GTV.GUT = NewVoipMgr.this.GUT;
            AppMethodBeat.o(235511);
        }
    };
    TelephonyManager qtS = null;
    private long wNg = 0;
    private TelephonyManager yoi;
    private IListener yok = new IListener<zi>() {
        /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass11 */

        {
            AppMethodBeat.i(235499);
            this.__eventId = zi.class.getName().hashCode();
            AppMethodBeat.o(235499);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zi ziVar) {
            AppMethodBeat.i(235500);
            zi ziVar2 = ziVar;
            if (!(ziVar2 instanceof zi)) {
                AppMethodBeat.o(235500);
            } else {
                ziVar2.efv.efw = k.adQ(NewVoipMgr.this.GTW.mState);
                ziVar2.efv.dCH = (NewVoipMgr.this.GTX == null || NewVoipMgr.this.GTX.HnU == null) ? false : true;
                ziVar2.efv.dCI = true;
                ziVar2.efv.talker = NewVoipMgr.this.goe;
                AppMethodBeat.o(235500);
            }
            return false;
        }
    };
    private long yqt = 0;
    private boolean zuc = false;

    static /* synthetic */ void G(NewVoipMgr newVoipMgr) {
        AppMethodBeat.i(235605);
        newVoipMgr.hb(true);
        AppMethodBeat.o(235605);
    }

    static /* synthetic */ String Lg(long j2) {
        AppMethodBeat.i(235600);
        String AF = AF(j2);
        AppMethodBeat.o(235600);
        return AF;
    }

    static /* synthetic */ void a(NewVoipMgr newVoipMgr, int i2) {
        AppMethodBeat.i(235597);
        newVoipMgr.acM(i2);
        AppMethodBeat.o(235597);
    }

    static /* synthetic */ void a(NewVoipMgr newVoipMgr, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(235603);
        newVoipMgr.d(sharedPreferences);
        AppMethodBeat.o(235603);
    }

    static /* synthetic */ void d(NewVoipMgr newVoipMgr, int i2) {
        AppMethodBeat.i(235601);
        newVoipMgr.xN(i2);
        AppMethodBeat.o(235601);
    }

    static /* synthetic */ void r(NewVoipMgr newVoipMgr) {
        AppMethodBeat.i(235599);
        newVoipMgr.fFV();
        AppMethodBeat.o(235599);
    }

    static /* synthetic */ int v(NewVoipMgr newVoipMgr) {
        int i2 = newVoipMgr.GUG;
        newVoipMgr.GUG = i2 + 1;
        return i2;
    }

    static /* synthetic */ void y(NewVoipMgr newVoipMgr) {
        AppMethodBeat.i(235602);
        newVoipMgr.fFP();
        AppMethodBeat.o(235602);
    }

    public NewVoipMgr() {
        AppMethodBeat.i(235514);
        AppMethodBeat.o(235514);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x015c  */
    @Override // com.tencent.mm.plugin.voip.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final android.content.Context r10, java.lang.String r11, boolean r12, boolean r13, long r14) {
        /*
        // Method dump skipped, instructions count: 777
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.model.NewVoipMgr.a(android.content.Context, java.lang.String, boolean, boolean, long):void");
    }

    @Override // com.tencent.mm.plugin.voip.a
    public final boolean fFa() {
        return this.GUf;
    }

    @Override // com.tencent.mm.plugin.voip.a
    public final boolean fEZ() {
        return this.GUg;
    }

    @Override // com.tencent.mm.plugin.voip.a
    public final void wQ(boolean z) {
        AppMethodBeat.i(235516);
        int aQ = k.aQ(false, z);
        if (this.GUh) {
            if (aQ == 0) {
                aQ = 1;
            } else if (256 == aQ) {
                aQ = CdnLogic.kAppTypeFestivalImage;
            }
        }
        this.GTW = k.adN(aQ);
        Log.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", Integer.valueOf(aQ), Boolean.FALSE, Boolean.valueOf(z));
        this.GUf = false;
        AppMethodBeat.o(235516);
    }

    @Override // com.tencent.mm.plugin.voip.a
    public final String getUserName() {
        return this.goe;
    }

    @Override // com.tencent.mm.plugin.voip.a
    public final int getState() {
        return this.GTW.mState;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void wU(boolean z) {
        AppMethodBeat.i(235517);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", Boolean.valueOf(z));
        this.GTV.cV(z);
        this.GTV.HgE = true;
        AppMethodBeat.o(235517);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void rv(boolean z) {
        AppMethodBeat.i(235518);
        this.GTV.xp(z);
        AppMethodBeat.o(235518);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFt() {
        AppMethodBeat.i(235519);
        if (!this.GTW.adT(4103)) {
            AppMethodBeat.o(235519);
            return false;
        }
        acN(4103);
        com.tencent.mm.plugin.voip.c.fFg().fIl();
        AppMethodBeat.o(235519);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFu() {
        AppMethodBeat.i(235520);
        if (!this.GTW.adT(4101)) {
            AppMethodBeat.o(235520);
            return false;
        }
        fFK();
        com.tencent.mm.plugin.voip.c.fFg().adf(1);
        com.tencent.mm.plugin.voip.c.fFg().aH(true, this.GUg);
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[5];
        objArr[0] = 1;
        objArr[1] = Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH);
        objArr[2] = Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId);
        objArr[3] = 0;
        objArr[4] = Integer.valueOf(this.GUf ? 1 : 0);
        hVar.a(11046, objArr);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11080, 2, 0, 0);
        xN(4111);
        xN(4101);
        xN(4100);
        AppMethodBeat.o(235520);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFv() {
        int i2 = 0;
        AppMethodBeat.i(235521);
        if (!this.GTW.adT(4099)) {
            AppMethodBeat.o(235521);
            return false;
        }
        String str = this.GUe.field_username;
        String str2 = this.GUg ? ca.OqC : ca.OqB;
        if (this.GUf) {
            i2 = 1;
        }
        s.c(str, str2, i2, 6, MMApplicationContext.getContext().getString(R.string.i1c));
        fFK();
        com.tencent.mm.plugin.voip.c.fFg().GYS.fIw();
        xN(4099);
        fFP();
        AppMethodBeat.o(235521);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFw() {
        AppMethodBeat.i(235522);
        if (!this.GTW.adT(4100)) {
            AppMethodBeat.o(235522);
            return false;
        }
        if (this.GTX != null) {
            this.GTX.fLW();
        }
        Log.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVideoInvite");
        fFK();
        com.tencent.mm.plugin.voip.c.fFg().aH(false, this.GUg);
        xN(4100);
        AppMethodBeat.o(235522);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFx() {
        if (this.GTX != null) {
            this.GTX.GYg = false;
        }
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFy() {
        int i2 = 0;
        AppMethodBeat.i(235523);
        if (!this.GTW.adT(4099)) {
            AppMethodBeat.o(235523);
            return false;
        }
        Log.i("MicroMsg.Voip.NewVoipMgr", "onRejectVoiceInvite");
        String str = this.GUe.field_username;
        String str2 = this.GUg ? ca.OqC : ca.OqB;
        if (this.GUf) {
            i2 = 1;
        }
        s.c(str, str2, i2, 6, MMApplicationContext.getContext().getString(R.string.i1c));
        fFK();
        com.tencent.mm.plugin.voip.c.fFg().GYS.fIw();
        xN(4099);
        fFP();
        AppMethodBeat.o(235523);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFz() {
        AppMethodBeat.i(235524);
        if (!this.GTW.adT(4100)) {
            AppMethodBeat.o(235524);
            return false;
        }
        Log.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVoiceInvite");
        fFK();
        com.tencent.mm.plugin.voip.c.fFg().aH(true, this.GUg);
        xN(4111);
        xN(4100);
        AppMethodBeat.o(235524);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFA() {
        AppMethodBeat.i(235525);
        if (!this.GTW.adT(4098)) {
            AppMethodBeat.o(235525);
            return false;
        }
        Log.i("MicroMsg.Voip.NewVoipMgr", "onCancelVideoInvite");
        acN(4098);
        com.tencent.mm.plugin.voip.c.fFg().fIl();
        AppMethodBeat.o(235525);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFB() {
        AppMethodBeat.i(235526);
        if (!this.GTW.adT(4098)) {
            AppMethodBeat.o(235526);
            return false;
        }
        Log.i("MicroMsg.Voip.NewVoipMgr", "onCancelVoiceInvite");
        acN(4098);
        com.tencent.mm.plugin.voip.c.fFg().fIl();
        AppMethodBeat.o(235526);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void a(com.tencent.mm.plugin.voip.ui.b bVar, int i2) {
        int i3;
        AppMethodBeat.i(235527);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onVoipUICreated, uiType: %s,  mVoicePlayDevice: %s", Integer.valueOf(i2), Integer.valueOf(this.GUk));
        if (1 == i2 && this.GTY != null) {
            this.GTY.uninit();
        }
        this.GTY = bVar;
        this.mUIType = i2;
        this.GTV.b(this.GTY);
        this.GTY.jD(-1, this.GTW.mState);
        this.GTY.setConnectSec(this.GUl);
        this.GTY.adz(this.GUC);
        this.GTY.adz(this.GUD);
        if (this.GTY instanceof Activity) {
            int rotation = ((WindowManager) ((Activity) this.GTY).getSystemService("window")).getDefaultDisplay().getRotation();
            switch (rotation) {
                case 0:
                    i3 = 0;
                    break;
                case 1:
                    i3 = 90;
                    break;
                case 2:
                    i3 = TXLiveConstants.RENDER_ROTATION_180;
                    break;
                case 3:
                    i3 = 270;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (this.GTX != null) {
                this.GTX.kyf = rotation;
                this.GTX.Hir = i3;
            }
        }
        AppMethodBeat.o(235527);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFC() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(235528);
        if (this.GUg && this.GTX != null) {
            j jVar = this.GTX;
            if (!(jVar.HnU == null || jVar.HnX == null)) {
                m mVar = jVar.HnX;
                if (mVar == null) {
                    p.hyc();
                }
                if (mVar.Hpj != null) {
                    m mVar2 = jVar.HnX;
                    if (mVar2 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.voip.video.render.g gVar = mVar2.Hpj;
                    if (gVar == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.voip.video.camera.a.a aVar = jVar.HnU;
                    if (aVar != null) {
                        z = aVar.fKY();
                    } else {
                        z = true;
                    }
                    jVar.d(gVar, z);
                }
            }
        }
        if (this.GUf && k.adR(this.GTW.mState) && com.tencent.mm.plugin.voip.c.fFg().GYS.czl()) {
            this.GTV.aN(this.GUg, this.GUf);
            if (this.GUk != 1) {
                z2 = false;
            }
            wU(z2);
        }
        AppMethodBeat.o(235528);
    }

    /* access modifiers changed from: package-private */
    public final void acM(int i2) {
        WifiManager wifiManager;
        AppMethodBeat.i(235529);
        if (i2 == 5) {
            mHZ += GUR[0];
            this.GUW++;
            Log.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength 4G" + GUR[0] + " and index is " + this.GUW);
            AppMethodBeat.o(235529);
            return;
        }
        if (!(i2 != 4 || (wifiManager = (WifiManager) MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi")) == null || wifiManager.getConnectionInfo() == null)) {
            try {
                GUR[1] = wifiManager.getConnectionInfo() == null ? 0 : wifiManager.getConnectionInfo().getRssi();
            } catch (Exception e2) {
                GUR[1] = 0;
                Log.i("MicroMsg.Voip.NewVoipMgr", "error happened in get wifi info");
            }
            mHZ += GUR[1];
            this.GUW++;
            Log.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength WIFI " + GUR[1] + " and index is " + this.GUW);
        }
        AppMethodBeat.o(235529);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFD() {
        AppMethodBeat.i(235530);
        Log.i("MicroMsg.Voip.NewVoipMgr", "it is init voip report");
        this.GUO = new NetChangedBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        MMApplicationContext.getContext().registerReceiver(this.GUO, intentFilter);
        this.qtS = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
        this.GUM = e.getNetType(getContext());
        this.GUP = new PhoneStateListener() {
            /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass13 */

            public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                AppMethodBeat.i(235502);
                super.onSignalStrengthsChanged(signalStrength);
                super.onSignalStrengthsChanged(signalStrength);
                String[] split = signalStrength.toString().split(" ");
                try {
                    if (NewVoipMgr.this.qtS.getNetworkType() == 13 && split.length > 9) {
                        NewVoipMgr.GUR[0] = Util.safeParseInt(split[9]);
                    }
                    AppMethodBeat.o(235502);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Voip.NewVoipMgr", e2, "", new Object[0]);
                    AppMethodBeat.o(235502);
                }
            }
        };
        TelephonyManager telephonyManager = this.qtS;
        com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(this.GUP);
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        AppMethodBeat.o(235530);
    }

    @Override // com.tencent.mm.plugin.voip.video.render.c
    public final void aB(int i2, int i3, int i4) {
        AppMethodBeat.i(235531);
        if (this.GTY != null) {
            this.GTY.adx(i2);
        }
        if (this.GUn != null) {
            this.GUn.setPreviewSize(i3, i4);
        }
        AppMethodBeat.o(235531);
    }

    @Override // com.tencent.mm.plugin.voip.video.render.c
    public final void fFE() {
        AppMethodBeat.i(235532);
        if (this.zuc || this.GTY == null || this.GTY.fJl() == null || this.GTX == null || this.GTX.HnU == null) {
            Log.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, already show");
            AppMethodBeat.o(235532);
        } else if (this.GTX.HnU.dEO()) {
            AppMethodBeat.o(235532);
        } else if (Build.MANUFACTURER.equalsIgnoreCase("meizu") && !com.tencent.mm.compatible.e.b.apj() && d.oE(29)) {
            Log.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, meizu machine");
            AppMethodBeat.o(235532);
        } else if (!d.oD(28) || !((KeyguardManager) MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            Log.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, show dialog");
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11306, 0, 0);
            com.tencent.mm.ui.widget.a.d n = com.tencent.mm.ui.base.h.n(this.GTY.fJl(), R.string.i3p, R.string.zb);
            if (n == null) {
                Log.e("MicroMsg.Voip.NewVoipMgr", "new dialog failed");
                AppMethodBeat.o(235532);
                return;
            }
            n.setCancelable(false);
            n.setCanceledOnTouchOutside(false);
            n.show();
            this.zuc = true;
            h.fKq();
            AppMethodBeat.o(235532);
        } else {
            Log.i("MicroMsg.Voip.NewVoipMgr", "api level: %s, in keyguard, ignore", Integer.valueOf(Build.VERSION.SDK_INT));
            AppMethodBeat.o(235532);
        }
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5) {
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void fs(int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void cza() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.voip.video.render.c
    public final void ag(long j2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = true;
        AppMethodBeat.i(235533);
        if (this.GUU != null) {
            switch (i2) {
                case 3:
                    if (1 != this.mUIType) {
                        if (com.tencent.mm.plugin.voip.c.fFg().GZf) {
                            h hVar = this.GUU;
                            if (260 == this.GTW.mState || 6 == this.GTW.mState) {
                                z = false;
                            } else {
                                z = true;
                            }
                            hVar.aP(false, z);
                            break;
                        } else {
                            h hVar2 = this.GUU;
                            if (260 == this.GTW.mState || 6 == this.GTW.mState) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            hVar2.aO(false, z2);
                            com.tencent.mm.plugin.voip.c.fFg().GZf = true;
                            break;
                        }
                    } else if (com.tencent.mm.plugin.voip.c.fFg().GZg) {
                        h hVar3 = this.GUU;
                        if (260 == this.GTW.mState || 6 == this.GTW.mState) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        hVar3.aP(true, z3);
                        break;
                    } else {
                        h hVar4 = this.GUU;
                        if (260 == this.GTW.mState || 6 == this.GTW.mState) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        hVar4.aO(true, z4);
                        com.tencent.mm.plugin.voip.c.fFg().GZg = true;
                        break;
                    }
                    break;
            }
            if (this.GTX != null) {
                h hVar5 = this.GUU;
                if (1 == this.mUIType) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                m mVar = this.GTX.HnX;
                if (mVar != null && mVar.fMd() == 0) {
                    z6 = false;
                }
                switch (i2) {
                    case 0:
                        hVar5.Hhi++;
                        if (hVar5.Hhi == 0) {
                            if (!z5) {
                                if (j2 > 0) {
                                    com.tencent.mm.plugin.voip.b.j jVar = com.tencent.mm.plugin.voip.b.j.Hhp;
                                    com.tencent.mm.plugin.voip.b.j.Lt(j2);
                                }
                                AppMethodBeat.o(235533);
                                return;
                            } else if (j2 > 0) {
                                com.tencent.mm.plugin.voip.b.j jVar2 = com.tencent.mm.plugin.voip.b.j.Hhp;
                                com.tencent.mm.plugin.voip.b.j.Ls(j2);
                                AppMethodBeat.o(235533);
                                return;
                            }
                        } else if (hVar5.Hhi == 60) {
                            hVar5.Hhi = -1;
                        }
                        AppMethodBeat.o(235533);
                        return;
                    case 1:
                        hVar5.Hhj++;
                        if (hVar5.Hhj != 0) {
                            if (hVar5.Hhj == 60) {
                                hVar5.Hhj = -1;
                            }
                            AppMethodBeat.o(235533);
                            return;
                        } else if (z5) {
                            if (z6) {
                                com.tencent.mm.plugin.voip.b.j jVar3 = com.tencent.mm.plugin.voip.b.j.Hhp;
                                com.tencent.mm.plugin.voip.b.j.LK(j2);
                                AppMethodBeat.o(235533);
                                return;
                            }
                            com.tencent.mm.plugin.voip.b.j jVar4 = com.tencent.mm.plugin.voip.b.j.Hhp;
                            com.tencent.mm.plugin.voip.b.j.LI(j2);
                            AppMethodBeat.o(235533);
                            return;
                        } else if (z6) {
                            com.tencent.mm.plugin.voip.b.j jVar5 = com.tencent.mm.plugin.voip.b.j.Hhp;
                            com.tencent.mm.plugin.voip.b.j.LL(j2);
                            AppMethodBeat.o(235533);
                            return;
                        } else {
                            com.tencent.mm.plugin.voip.b.j jVar6 = com.tencent.mm.plugin.voip.b.j.Hhp;
                            com.tencent.mm.plugin.voip.b.j.LJ(j2);
                            AppMethodBeat.o(235533);
                            return;
                        }
                    case 2:
                        hVar5.Hhk++;
                        if (hVar5.Hhk != 0) {
                            if (hVar5.Hhk == 60) {
                                hVar5.Hhk = -1;
                                break;
                            }
                        } else {
                            if (z5) {
                                com.tencent.mm.plugin.voip.b.j jVar7 = com.tencent.mm.plugin.voip.b.j.Hhp;
                                com.tencent.mm.plugin.voip.b.j.Lu(j2);
                            } else {
                                com.tencent.mm.plugin.voip.b.j jVar8 = com.tencent.mm.plugin.voip.b.j.Hhp;
                                com.tencent.mm.plugin.voip.b.j.Lv(j2);
                            }
                            hVar5.Hhi = 0;
                            AppMethodBeat.o(235533);
                            return;
                        }
                        break;
                }
            }
        }
        AppMethodBeat.o(235533);
    }

    public class NetChangedBroadcastReceiver extends BroadcastReceiver {
        public NetChangedBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            int i2 = 0;
            AppMethodBeat.i(235513);
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                switch (e.getNetType(context)) {
                    case 4:
                        if (NewVoipMgr.this.GUM != 4) {
                            int i3 = NewVoipMgr.GUR[0];
                            if (NewVoipMgr.this.GUW == 0) {
                                NewVoipMgr.a(NewVoipMgr.this, 5);
                            }
                            if (NewVoipMgr.this.GUW != 0) {
                                int i4 = NewVoipMgr.mHZ / NewVoipMgr.this.GUW;
                                NewVoipMgr.a(NewVoipMgr.this, 4);
                                int i5 = NewVoipMgr.GUR[1];
                                Log.i("MicroMsg.Voip.NewVoipMgr", "befor change to wifi and cost " + NewVoipMgr.this.wNg);
                                if (!NewVoipMgr.this.GUf) {
                                    i2 = 1;
                                }
                                e.a(i2, System.currentTimeMillis(), NewVoipMgr.this.GUM, 4, i3, i5, i4);
                                NewVoipMgr.this.GUN = true;
                                NewVoipMgr.this.GUM = 4;
                                int unused = NewVoipMgr.mHZ = 0;
                                NewVoipMgr.this.GUW = 0;
                                break;
                            }
                        }
                        break;
                    case 5:
                        if (NewVoipMgr.this.GUM != 5) {
                            int i6 = NewVoipMgr.GUR[1];
                            if (NewVoipMgr.this.GUW == 0) {
                                NewVoipMgr.a(NewVoipMgr.this, 4);
                            }
                            if (NewVoipMgr.this.GUW != 0) {
                                int i7 = NewVoipMgr.mHZ / NewVoipMgr.this.GUW;
                                NewVoipMgr.a(NewVoipMgr.this, 5);
                                int i8 = NewVoipMgr.GUR[0];
                                Log.i("MicroMsg.Voip.NewVoipMgr", "befor change to 4G and cost " + NewVoipMgr.this.wNg);
                                if (!NewVoipMgr.this.GUf) {
                                    i2 = 1;
                                }
                                e.a(i2, System.currentTimeMillis(), NewVoipMgr.this.GUM, 5, i6, i8, i7);
                                NewVoipMgr.this.GUN = true;
                                NewVoipMgr.this.GUM = 5;
                                int unused2 = NewVoipMgr.mHZ = 0;
                                NewVoipMgr.this.GUW = 0;
                                AppMethodBeat.o(235513);
                                return;
                            }
                        }
                        break;
                }
                AppMethodBeat.o(235513);
            } else if (!intent.getAction().equals("android.net.wifi.STATE_CHANGE") || NewVoipMgr.this.GUS != 0) {
                if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED") && NewVoipMgr.this.GUS != 0) {
                    NewVoipMgr.this.wNg = System.currentTimeMillis() - NewVoipMgr.this.GUS;
                    NewVoipMgr.this.GUS = 0;
                }
                AppMethodBeat.o(235513);
            } else {
                NewVoipMgr.this.GUS = System.currentTimeMillis();
                AppMethodBeat.o(235513);
            }
        }
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void a(com.tencent.mm.plugin.voip.ui.b bVar) {
        AppMethodBeat.i(235534);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onVoipUIDestroy");
        if (this.GTY == bVar) {
            Log.d("MicroMsg.Voip.NewVoipMgr", "same VoipUI, clear it");
            this.GTY = null;
            this.GTV.b((com.tencent.mm.plugin.voip.ui.b) null);
        }
        if (this.kAn != null) {
            this.kAn = null;
        }
        AppMethodBeat.o(235534);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFF() {
        AppMethodBeat.i(235535);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onSwitchCamera");
        if (this.GTX != null) {
            j jVar = this.GTX;
            Log.i("MicroMsg.VoIPRenderMgr", "onSwitchCamera");
            if (jVar.HnU != null) {
                com.tencent.mm.plugin.voip.video.camera.a.a aVar = jVar.HnU;
                if (aVar == null) {
                    p.hyc();
                }
                if (aVar.fLc() != null) {
                    jVar.onOrientationChange(jVar.kyf);
                    com.tencent.mm.plugin.voip.video.camera.a.a aVar2 = jVar.HnU;
                    if (aVar2 != null) {
                        aVar2.fLd();
                    }
                    com.tencent.mm.plugin.voip.video.camera.a.a aVar3 = jVar.HnU;
                    if (aVar3 == null) {
                        p.hyc();
                    }
                    ac fLc = aVar3.fLc();
                    if (fLc == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.voip.video.camera.a.a aVar4 = jVar.HnU;
                    if (aVar4 == null) {
                        p.hyc();
                    }
                    int fLe = aVar4.fLe();
                    com.tencent.mm.plugin.voip.video.camera.a.a aVar5 = jVar.HnU;
                    if (aVar5 == null) {
                        p.hyc();
                    }
                    jVar.a(fLc, fLe, !aVar5.fLf());
                    jVar.aeb(jVar.Hir);
                    jVar.Hod = true;
                }
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11079, 1);
        }
        AppMethodBeat.o(235535);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFG() {
        AppMethodBeat.i(235536);
        if (!(this.GTX == null || this.GTX.HnU == null || true == this.GTX.HnU.fKY())) {
            fFF();
        }
        AppMethodBeat.o(235536);
    }

    private void acN(int i2) {
        String string;
        int i3 = 0;
        AppMethodBeat.i(235537);
        Log.i("MicroMsg.Voip.NewVoipMgr", "hangupTalkingOrCancelInvite");
        if (true == fFW()) {
            this.GUi = i2;
        }
        Context context = MMApplicationContext.getContext();
        if (k.adP(this.GTW.mState)) {
            string = context.getString(R.string.i1_, AF(Util.secondsToNow(this.GUl)));
        } else if (this.GUf) {
            string = context.getString(R.string.i15);
        } else {
            string = context.getString(R.string.i14);
        }
        String str = this.GUe.field_username;
        String str2 = this.GUg ? ca.OqC : ca.OqB;
        if (this.GUf) {
            i3 = 1;
        }
        s.c(str, str2, i3, 6, string);
        if (!this.GUf || k.adP(this.GTW.mState)) {
            com.tencent.f.h.RTc.aX(new com.tencent.f.i.h() {
                /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass14 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "VoipMgr_play_end_sound";
                }

                public final void run() {
                    AppMethodBeat.i(235503);
                    NewVoipMgr.this.GTV.xq(NewVoipMgr.this.GUg);
                    AppMethodBeat.o(235503);
                }
            });
            this.GUb = true;
            this.GUc = true;
            com.tencent.mm.plugin.voip.c.fFg().GYS.fIx();
            if (4096 == this.GUi) {
                xN(i2);
                fFP();
            }
        } else {
            fFK();
            if (this.GUf && !k.adP(this.GTW.mState)) {
                Log.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call cancelCall");
                com.tencent.mm.plugin.voip.c.fFg().GYS.fIu();
            }
            Log.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call hangUp");
            com.tencent.mm.plugin.voip.c.fFg().GYS.fIx();
            if (4096 == this.GUi) {
                xN(i2);
                fFP();
                AppMethodBeat.o(235537);
                return;
            }
        }
        AppMethodBeat.o(235537);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void a(VoIPRenderTextureView voIPRenderTextureView, int i2) {
        AppMethodBeat.i(235538);
        if (this.GTX != null) {
            h.adJ(1);
            j jVar = this.GTX;
            p.h(voIPRenderTextureView, "view");
            if (!jVar.Hoh) {
                jVar.Hoh = true;
                m mVar = jVar.HnX;
                if (mVar != null) {
                    mVar.ad(new j.c(jVar));
                }
            }
            j.d dVar = new j.d(jVar);
            p.h(dVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            voIPRenderTextureView.HoG = dVar;
            voIPRenderTextureView.HoH = i2;
            voIPRenderTextureView.setSurfaceTextureListener(new VoIPRenderTextureView.b(voIPRenderTextureView));
        }
        AppMethodBeat.o(235538);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void aE(boolean z, boolean z2) {
        AppMethodBeat.i(235539);
        if (this.GUU != null) {
            h hVar = this.GUU;
            long currentTicks = Util.currentTicks();
            if (z) {
                if (z2) {
                    hVar.Hhg = currentTicks;
                    AppMethodBeat.o(235539);
                    return;
                }
                hVar.Hhe = currentTicks;
                AppMethodBeat.o(235539);
                return;
            } else if (z2) {
                hVar.Hhh = currentTicks;
                AppMethodBeat.o(235539);
                return;
            } else {
                hVar.Hhf = currentTicks;
            }
        }
        AppMethodBeat.o(235539);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void ah(long j2, int i2) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void a(VoIPRenderSurfaceView voIPRenderSurfaceView, int i2) {
        AppMethodBeat.i(235540);
        if (this.GTX != null) {
            h.adJ(0);
            j jVar = this.GTX;
            p.h(voIPRenderSurfaceView, "view");
            if (!jVar.Hoh) {
                jVar.Hoh = true;
                m mVar = jVar.HnX;
                if (mVar != null) {
                    mVar.ad(new j.e(jVar));
                }
            }
            j.f fVar = new j.f(jVar);
            p.h(fVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            voIPRenderSurfaceView.HoG = fVar;
            voIPRenderSurfaceView.HoH = i2;
            voIPRenderSurfaceView.getHolder().addCallback(voIPRenderSurfaceView.HoF);
        }
        AppMethodBeat.o(235540);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void a(VoIPRenderSurfaceView voIPRenderSurfaceView) {
        AppMethodBeat.i(235541);
        if (this.GTX != null) {
            j jVar = this.GTX;
            if (voIPRenderSurfaceView != null) {
                voIPRenderSurfaceView.fLZ();
            }
            jVar.Hoh = false;
            jVar.HnW = false;
        }
        AppMethodBeat.o(235541);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void a(VoIPRenderTextureView voIPRenderTextureView) {
        AppMethodBeat.i(235542);
        if (this.GTX != null) {
            j jVar = this.GTX;
            if (voIPRenderTextureView != null) {
                voIPRenderTextureView.setSurfaceTextureListener(null);
                j.b bVar = voIPRenderTextureView.HoG;
                if (bVar != null) {
                    bVar.aed(voIPRenderTextureView.HoH);
                }
                voIPRenderTextureView.HoG = null;
            }
            jVar.Hoh = false;
            jVar.HnW = false;
        }
        AppMethodBeat.o(235542);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFH() {
        boolean z;
        AppMethodBeat.i(235543);
        if (this.GTX != null) {
            j jVar = this.GTX;
            Log.printInfoStack("MicroMsg.VoIPRenderMgr", "onRender Mode changed", new Object[0]);
            if (!jVar.HdG) {
                z = true;
            } else {
                z = false;
            }
            jVar.HdG = z;
            m mVar = jVar.HnX;
            if (mVar != null) {
                m.a(mVar);
            }
            m mVar2 = jVar.HnX;
            if (mVar2 != null) {
                Log.printInfoStack("MicroMsg.LocalWindowsSurfaceRenderer", "switchRenderSurface", new Object[0]);
                n nVar = mVar2.Hpk;
                if (nVar != null) {
                    nVar.fLQ();
                }
                com.tencent.mm.plugin.voip.video.render.g gVar = mVar2.Hpj;
                if (gVar != null) {
                    gVar.fLQ();
                }
                n nVar2 = mVar2.Hpl;
                if (nVar2 != null) {
                    nVar2.fLQ();
                }
            }
            m mVar3 = jVar.HnX;
            if (mVar3 != null) {
                mVar3.fLR();
                AppMethodBeat.o(235543);
                return;
            }
        }
        AppMethodBeat.o(235543);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void wV(boolean z) {
        AppMethodBeat.i(235544);
        if (this.GTX != null) {
            j jVar = this.GTX;
            jVar.HdG = z;
            jVar.setHWDecMode(jVar.HdK);
        }
        AppMethodBeat.o(235544);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFI() {
        AppMethodBeat.i(235545);
        if (this.GTX != null) {
            this.GTX.jA(this.GUK, this.GUL);
        }
        AppMethodBeat.o(235545);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void jz(int i2, int i3) {
        AppMethodBeat.i(235546);
        if (this.GTX != null) {
            this.GTX.onOrientationChange(i2);
            if (this.GUt != i3) {
                this.GUt = i3;
                this.GTX.aeb(i3);
            }
        }
        AppMethodBeat.o(235546);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFJ() {
        AppMethodBeat.i(235547);
        this.GUU.adI(1);
        AppMethodBeat.o(235547);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void setVoicePlayDevice(int i2) {
        AppMethodBeat.i(235548);
        if (i2 != 2) {
            this.GTV.fJP();
        } else if (this.GUk != 2 && !k.adQ(this.GTW.mState)) {
            getContext();
            hXE();
        }
        this.GUk = i2;
        AppMethodBeat.o(235548);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFK() {
        AppMethodBeat.i(235549);
        if (this.GTV != null) {
            Log.i("MicroMsg.Voip.NewVoipMgr", "use audioManager to stop voip ring");
            this.GTV.fFK();
            AppMethodBeat.o(235549);
            return;
        }
        Log.i("MicroMsg.Voip.NewVoipMgr", "use Subcore to stop voip ring");
        com.tencent.mm.plugin.voip.c.fFg().GYS.stopRing();
        AppMethodBeat.o(235549);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFL() {
        AppMethodBeat.i(235550);
        if (this.GTY != null) {
            this.GTY.fFL();
        }
        AppMethodBeat.o(235550);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFM() {
        AppMethodBeat.i(235551);
        if (com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId == 0) {
            this.GUj = true;
            AppMethodBeat.o(235551);
            return true;
        }
        boolean fFN = fFN();
        AppMethodBeat.o(235551);
        return fFN;
    }

    private boolean fFN() {
        com.tencent.mm.plugin.report.service.h hVar;
        int i2;
        Object[] objArr;
        Object[] objArr2;
        char c2;
        int i3 = 0;
        AppMethodBeat.i(235552);
        if (!this.GTW.adT(4101)) {
            AppMethodBeat.o(235552);
            return false;
        }
        this.GUg = false;
        if (this.GUv != null) {
            this.GUv.GUg = false;
        }
        xN(4101);
        if (261 == this.GTW.mState || 7 == this.GTW.mState) {
            com.tencent.mm.plugin.voip.c.fFg().adf(1);
            com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr3 = new Object[5];
            objArr3[0] = 2;
            objArr3[1] = Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH);
            objArr3[2] = Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId);
            objArr3[3] = 0;
            objArr3[4] = Integer.valueOf(this.GUf ? 1 : 0);
            hVar2.a(11046, objArr3);
            hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            i2 = 11080;
            Object[] objArr4 = new Object[3];
            objArr4[0] = 2;
            objArr4[1] = 0;
            c2 = 2;
            objArr2 = objArr4;
            objArr = objArr4;
        } else {
            if (1 == this.GTW.mState || 3 == this.GTW.mState) {
                com.tencent.mm.plugin.voip.c.fFg().adf(1);
                hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                i2 = 11046;
                Object[] objArr5 = new Object[5];
                objArr5[0] = 1;
                objArr5[1] = Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH);
                objArr5[2] = Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId);
                objArr5[3] = 0;
                c2 = 4;
                if (this.GUf) {
                    i3 = 1;
                    objArr2 = objArr5;
                    objArr = objArr5;
                } else {
                    objArr2 = objArr5;
                    objArr = objArr5;
                }
            }
            com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGz();
            com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGA();
            AppMethodBeat.o(235552);
            return true;
        }
        objArr2[c2] = Integer.valueOf(i3);
        hVar.a(i2, objArr);
        com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGz();
        com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGA();
        AppMethodBeat.o(235552);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void enR() {
        AppMethodBeat.i(235553);
        if (this.GTY != null) {
            this.GTY.enR();
        }
        AppMethodBeat.o(235553);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void fFO() {
        AppMethodBeat.i(235554);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onRoomReady");
        if (this.GUj && com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId != 0) {
            this.GUj = false;
            fFN();
        }
        if (this.GUf) {
            xN(4097);
        }
        AppMethodBeat.o(235554);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void xN(final int i2) {
        AppMethodBeat.i(235555);
        Log.printDebugStack("MicroMsg.Voip.NewVoipMgr", "swtchState, action: %s, currentState: %s", k.adM(i2), k.adM(this.GTW.mState));
        if (4101 == i2 && k.adQ(this.GTW.mState)) {
            fGb();
            if (this.GTX != null) {
                this.GTX.release();
            }
            this.GUg = false;
            if (this.GUv != null) {
                this.GUv.GUg = false;
            }
        }
        if (acO(i2)) {
            this.GTV.Hgx = false;
        }
        if (acO(i2) && 1 == this.mUIType && 1 == this.GUk) {
            this.GTV.cV(false);
            fGc();
            if (!com.tencent.mm.plugin.voip.c.fFg().GYS.czl()) {
                this.GTV.fFK();
                this.GTV.aN(false, this.GUf);
            }
        } else if (4100 == i2 && !com.tencent.mm.plugin.voip.c.fFg().GYS.czl()) {
            this.GTV.fFK();
        }
        this.GTW.adU(i2);
        if (this.kAn != null) {
            this.kAn.post(new Runnable() {
                /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(235504);
                    if (NewVoipMgr.this.GTY != null) {
                        NewVoipMgr.this.GTY.jD(i2, NewVoipMgr.this.GTW.mState);
                    }
                    AppMethodBeat.o(235504);
                }
            });
        }
        switch (this.GTW.mState) {
            case CdnLogic.kAppTypeFestivalVideo:
            case 259:
                acP(5);
                AppMethodBeat.o(235555);
                return;
            case 262:
                acP(6);
                break;
        }
        AppMethodBeat.o(235555);
    }

    private boolean acO(int i2) {
        AppMethodBeat.i(235556);
        if (4111 == i2) {
            AppMethodBeat.o(235556);
            return true;
        } else if (4101 != i2 || (!k.adP(this.GTW.mState) && !this.GUf)) {
            AppMethodBeat.o(235556);
            return false;
        } else {
            AppMethodBeat.o(235556);
            return true;
        }
    }

    private static void acP(int i2) {
        AppMethodBeat.i(235557);
        aaq aaq = new aaq();
        aaq.ehD.dDe = i2;
        EventCenter.instance.publish(aaq);
        AppMethodBeat.o(235557);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void aUw(String str) {
        AppMethodBeat.i(235558);
        if (this.GTY != null) {
            this.GUy = str;
            this.GTY.aUB(str);
        }
        AppMethodBeat.o(235558);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void onError(int i2, String str) {
        String string;
        String str2;
        int i3;
        String str3;
        int i4;
        AppMethodBeat.i(235559);
        this.GTV.xq(this.GUg);
        if (i2 == 241 && Util.isNullOrNil(str)) {
            str = getContext().getString(R.string.i3y);
        }
        if (this.GTY != null) {
            this.GTY.cF(i2, str);
        }
        Log.i("MicroMsg.Voip.NewVoipMgr", "onError, errCode: %s, roomId: %s", Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId));
        if (k.adP(this.GTW.mState)) {
            string = MMApplicationContext.getContext().getString(R.string.i3u, AF(Util.secondsToNow(this.GUl)));
        } else {
            Context context = MMApplicationContext.getContext();
            Log.d("MicroMsg.Voip.NewVoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(i2)));
            if (i2 == 235) {
                string = context.getString(R.string.i1e);
            } else if (i2 == 233) {
                string = context.getString(R.string.i17);
            } else if (i2 == 237) {
                string = context.getString(R.string.i1e);
            } else if (i2 == 236) {
                string = context.getString(R.string.i17);
            } else if (i2 == 211) {
                string = context.getString(R.string.i1d);
            } else {
                string = context.getString(R.string.i16);
            }
        }
        xN(4109);
        if (com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId != 0 && com.tencent.mm.plugin.voip.c.fFg().GYY.get(Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId)) == null) {
            String str4 = this.GUe.field_username;
            if (this.GUg) {
                str3 = ca.OqC;
            } else {
                str3 = ca.OqB;
            }
            if (this.GUf) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            if (k.adP(this.GTW.mState)) {
                string = MMApplicationContext.getContext().getString(R.string.i1a, AF(Util.secondsToNow(this.GUl)));
            }
            com.tencent.mm.plugin.voip.c.fFg().GYY.put(Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(s.a(str4, str3, i4, 6, string, true)));
        } else if (com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId == 0) {
            String str5 = this.GUe.field_username;
            if (this.GUg) {
                str2 = ca.OqC;
            } else {
                str2 = ca.OqB;
            }
            if (this.GUf) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (k.adP(this.GTW.mState)) {
                string = MMApplicationContext.getContext().getString(R.string.i1a, AF(Util.secondsToNow(this.GUl)));
            }
            s.a(str5, str2, i3, 6, string, true);
        }
        com.tencent.mm.plugin.voip.c.fFg().fIl();
        fFP();
        AppMethodBeat.o(235559);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void dZK() {
        AppMethodBeat.i(235560);
        Log.i("MicroMsg.Voip.NewVoipMgr", "on accept");
        fFK();
        xN(4100);
        AppMethodBeat.o(235560);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void onReject() {
        AppMethodBeat.i(235561);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onReject");
        xN(4099);
        s.c(this.GUe.field_username, this.GUg ? ca.OqC : ca.OqB, this.GUf ? 1 : 0, 6, MMApplicationContext.getContext().getString(R.string.i1g));
        fFP();
        AppMethodBeat.o(235561);
    }

    private void fFP() {
        AppMethodBeat.i(235562);
        Log.d("MicroMsg.Voip.NewVoipMgr", "delayFinish");
        this.GUy = null;
        if (this.kAn != null) {
            this.kAn.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass16 */

                public final void run() {
                    AppMethodBeat.i(235505);
                    NewVoipMgr newVoipMgr = NewVoipMgr.this;
                    Log.i("MicroMsg.Voip.NewVoipMgr", "it is uninit voip report");
                    if (newVoipMgr.GUQ != null) {
                        newVoipMgr.GUQ.removeCallbacksAndMessages(null);
                        newVoipMgr.GUQ.quit();
                    }
                    if (!newVoipMgr.GUN) {
                        if (newVoipMgr.GUW == 0) {
                            newVoipMgr.acM(newVoipMgr.GUM);
                        }
                        if (newVoipMgr.GUW != 0) {
                            newVoipMgr.GUN = true;
                            e.a(newVoipMgr.GUf ? 0 : 1, System.currentTimeMillis(), newVoipMgr.GUM, newVoipMgr.GUM, 0, 0, NewVoipMgr.mHZ / newVoipMgr.GUW);
                        }
                    }
                    NewVoipMgr.mHZ = 0;
                    NewVoipMgr.GUR[0] = 0;
                    NewVoipMgr.GUR[1] = 0;
                    newVoipMgr.GUW = 0;
                    if (newVoipMgr.qtS != null) {
                        TelephonyManager telephonyManager = newVoipMgr.qtS;
                        com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(newVoipMgr.GUP);
                        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                        telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                    }
                    if (newVoipMgr.GUO != null) {
                        MMApplicationContext.getContext().unregisterReceiver(newVoipMgr.GUO);
                        newVoipMgr.GUO = null;
                    }
                    NewVoipMgr.p(NewVoipMgr.this);
                    AppMethodBeat.o(235505);
                }
            }, 500);
        }
        AppMethodBeat.o(235562);
    }

    private void hb(boolean z) {
        AppMethodBeat.i(235563);
        Log.i("MicroMsg.Voip.NewVoipMgr", "finish");
        if (this.GUU != null) {
            this.GUU.fKp();
        }
        this.GUu = false;
        this.GUw = false;
        if (this.GUm != -1) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11700, Integer.valueOf(this.GUm), Long.valueOf(Util.secondsToNow(this.GUl)));
            this.GUm = -1;
        }
        try {
            MMApplicationContext.getContext().unregisterReceiver(this.GUV);
        } catch (Exception e2) {
        }
        this.GTV.fJP();
        EventCenter.instance.removeListener(this.yok);
        EventCenter.instance.removeListener(this.GUX);
        fGb();
        if (this.GTX != null) {
            this.GTX.release();
            this.GTX = null;
        }
        if (this.GTY != null) {
            this.GTY.uninit();
            this.GTY = null;
            this.GTV.b(this.GTY);
        }
        if (com.tencent.mm.plugin.voip.c.fFg() != null) {
            com.tencent.mm.plugin.voip.c.fFg().GYS.stopRing();
            if (z) {
                com.tencent.mm.plugin.voip.c.fFg().fHT();
            } else {
                com.tencent.mm.plugin.voip.c.fFg().GYS.fIx();
            }
            if (this.GUg) {
                com.tencent.mm.plugin.voip.c.fFg().d(false, true, this.goe);
            } else {
                com.tencent.mm.plugin.voip.c.fFg().d(false, false, this.goe);
            }
            com.tencent.mm.plugin.voip.c.fFg().b(MMApplicationContext.getContext(), this);
        }
        this.GTV.elB();
        com.tencent.mm.plugin.voip.c.fFg().fIi();
        com.tencent.mm.plugin.voip.c.fFg().adp(this.GUC);
        if (this.GUb) {
            this.GTZ = new a();
            com.tencent.f.h.RTc.aX(this.GTZ);
        } else {
            fFV();
        }
        if (!(this.yoi == null || this.mtH == null)) {
            TelephonyManager telephonyManager = this.yoi;
            com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(this.mtH);
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            this.mtH = null;
        }
        this.yoi = null;
        com.tencent.mm.booter.a.akp().akq();
        r.fHo().fHq();
        r.fHo().a(null);
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        com.tencent.mm.plugin.voip.c.fFg().fIl();
        Log.i("MicroMsg.Voip.NewVoipMgr", "finish, isFinishFromShutdown: %s", Boolean.valueOf(this.GUc));
        if (this.GUc && com.tencent.mm.plugin.voip.c.fFg().fIm()) {
            com.tencent.mm.plugin.voip.c.fFg();
            VoipScoreState.fHQ();
            Intent intent = new Intent(getContext(), VoipScoreDialog.class);
            intent.putExtra("key_score_state", com.tencent.mm.plugin.voip.c.fFg().fIo());
            if (!(getContext() instanceof Activity)) {
                intent.addFlags(268435456);
            }
            Context context = getContext();
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.plugin.voip.c.fFg().fIn();
        fFQ();
        if (!this.GUI) {
            e.c(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId, com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH, this.GUf ? 0 : 1, 4);
            this.GUI = true;
        }
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        com.tencent.mm.media.g.c.igu.aMA();
        AppMethodBeat.o(235563);
    }

    private static void fFQ() {
        AppMethodBeat.i(235564);
        zj zjVar = new zj();
        zjVar.efx.dKy = 11;
        EventCenter.instance.publish(zjVar);
        AppMethodBeat.o(235564);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void fFR() {
        AppMethodBeat.i(235565);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onNoResp");
        xN(4105);
        s.c(this.GUe.field_username, this.GUg ? ca.OqC : ca.OqB, this.GUf ? 1 : 0, 4, MMApplicationContext.getContext().getString(R.string.i1f));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11518, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu()), 6, Integer.valueOf(NetStatusUtil.getNetWorkType(getContext())));
        fFP();
        AppMethodBeat.o(235565);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void onConnected() {
        AppMethodBeat.i(235566);
        xN(4102);
        this.GUl = Util.nowSecond();
        com.tencent.mm.plugin.voip.c.a(this.GUg, this.GUf, this.GUl, this.goe);
        if (this.GTY != null) {
            this.GTY.setConnectSec(this.GUl);
        }
        boolean fGw = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGw();
        boolean fGv = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGv();
        if (this.GUg && this.GUf && !fGv && !fGw) {
            com.tencent.mm.plugin.voip.c.fFg().adf(1);
        }
        if (!k.adQ(this.GTW.mState)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11080, 1, 0, 0);
        }
        Util.shake(MMApplicationContext.getContext(), true);
        com.tencent.mm.plugin.voip.c.fFg().adq(com.tencent.mm.plugin.voip.c.fFg().fIk());
        r.fHo().fHp();
        r.fHo().a(this);
        k kVar = k.GVq;
        k.setRoomId(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId);
        AppMethodBeat.o(235566);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void fFS() {
        int i2 = 0;
        AppMethodBeat.i(235567);
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId);
        objArr[1] = Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH);
        objArr[2] = Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu());
        objArr[3] = Integer.valueOf(this.GUf ? 0 : 1);
        objArr[4] = 1;
        hVar.a(11522, true, true, objArr);
        int i3 = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId;
        long j2 = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH;
        if (!this.GUf) {
            i2 = 1;
        }
        e.c(i3, j2, i2, 3);
        this.GUQ.post(new Runnable() {
            /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass17 */

            public final void run() {
                AppMethodBeat.i(235506);
                NewVoipMgr.a(NewVoipMgr.this, NewVoipMgr.this.GUM);
                NewVoipMgr.this.GUQ.postDelayed(this, 5000);
                AppMethodBeat.o(235506);
            }
        });
        AppMethodBeat.o(235567);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void wW(boolean z) {
        String string;
        int i2 = 0;
        AppMethodBeat.i(235568);
        Log.printInfoStack("MicroMsg.Voip.NewVoipMgr", "onShutDown", new Object[0]);
        if (k.adP(this.GTW.mState)) {
            string = MMApplicationContext.getContext().getString(R.string.i1_, AF(Util.secondsToNow(this.GUl)));
        } else if (this.GUf) {
            string = MMApplicationContext.getContext().getString(R.string.i16);
        } else {
            string = MMApplicationContext.getContext().getString(R.string.i14);
        }
        if (this.GUf || k.adP(this.GTW.mState)) {
            s.c(this.GUe.field_username, this.GUg ? ca.OqC : ca.OqB, this.GUf ? 1 : 0, 6, string);
        } else if (!this.GUf && z) {
            s.c(this.GUe.field_username, this.GUg ? ca.OqC : ca.OqB, this.GUf ? 1 : 0, 6, string);
        }
        this.GTV.xq(this.GUg);
        this.GUc = k.adP(this.GTW.mState);
        if (fFW()) {
            this.GUi = 4106;
        } else {
            xN(4106);
            fFP();
        }
        com.tencent.mm.plugin.voip.c.fFg().fIl();
        if (!this.GUI) {
            int i3 = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId;
            long j2 = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH;
            if (!this.GUf) {
                i2 = 1;
            }
            e.c(i3, j2, i2, 4);
            this.GUI = true;
        }
        AppMethodBeat.o(235568);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void acQ(int i2) {
        AppMethodBeat.i(235569);
        Log.i("MicroMsg.Voip.NewVoipMgr", "remote voip mode changed, cmd:%d", Integer.valueOf(i2));
        if ((1 == i2 || 3 == i2 || 5 == i2 || 6 == i2 || 7 == i2) && this.GUg) {
            xN(4101);
            com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGz();
            com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGA();
        }
        AppMethodBeat.o(235569);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void e(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(235570);
        if (this.GTX != null) {
            j jVar = this.GTX;
            p.h(bArr, "outData");
            m mVar = jVar.HnX;
            if (mVar != null) {
                int i4 = OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90;
                p.h(bArr, "pBuff");
                n nVar = mVar.Hpl;
                if (nVar != null) {
                    p.h(bArr, "pBuff");
                    if (nVar.Hko != null) {
                        com.tencent.mm.plugin.voip.video.render.l lVar = nVar.Hnj;
                        if (lVar != null) {
                            p.h(bArr, "pBuff");
                            com.tencent.mm.plugin.voip.video.c.d dVar = lVar.Hpi;
                            p.h(bArr, "pBuff");
                            com.tencent.mm.plugin.voip.video.c.h hVar = dVar.Hmy;
                            if (hVar != null) {
                                p.h(bArr, "pBuff");
                                if (hVar.Him == null) {
                                    hVar.mWidth = i2;
                                    hVar.mHeight = i3;
                                    hVar.AOS = i4;
                                    hVar.Him = bArr;
                                }
                            }
                        }
                        com.tencent.mm.media.g.d dVar2 = nVar.Hko;
                        if (dVar2 == null) {
                            p.hyc();
                        }
                        nVar.b(dVar2);
                    }
                }
            }
            if (this.GTY != null) {
                this.GTY.fJm();
            }
        }
        AppMethodBeat.o(235570);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void setVoipBeauty(int i2) {
        AppMethodBeat.i(235571);
        Log.i("MicroMsg.Voip.NewVoipMgr", "setVoIPBeauty, isON: " + i2 + "，mVoipUI: " + this.GTY);
        if (this.GTX != null) {
            j jVar = this.GTX;
            Log.i("MicroMsg.VoIPRenderMgr", "setVoIPBeauty, mIsStarted:%b, isON:%d", Boolean.valueOf(jVar.mIsStarted), Integer.valueOf(i2));
            jVar.GUC = i2;
            m mVar = jVar.HnX;
            if (mVar != null) {
                int i3 = jVar.GUC;
                com.tencent.mm.plugin.voip.video.render.g gVar = mVar.Hpj;
                if (gVar != null) {
                    gVar.adZ(i3);
                }
            }
            jVar.onOrientationChange(jVar.kyf);
            jVar.aeb(jVar.Hir);
        }
        if (this.GTY != null) {
            this.GTY.adz(i2);
        }
        if (!(i2 == 0 || this.GUC == i2)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(914, 20, 1);
        }
        this.GUC = i2;
        AppMethodBeat.o(235571);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0086, code lost:
        if ((r0 != null ? r0.height : 0) >= 1280) goto L_0x0088;
     */
    @Override // com.tencent.mm.plugin.voip.model.x
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setSpatiotemporalDenosing(int r10) {
        /*
        // Method dump skipped, instructions count: 186
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.model.NewVoipMgr.setSpatiotemporalDenosing(int):void");
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void setHWDecMode(int i2) {
        AppMethodBeat.i(235573);
        this.GUB = i2;
        if (this.GTX != null) {
            this.GTX.setHWDecMode(i2);
            if (this.GTY != null) {
                this.GTY.ady(i2);
            }
            if (this.GUU != null) {
                h hVar = this.GUU;
                if ((i2 & 1) != 0) {
                    hVar.Hha++;
                    AppMethodBeat.o(235573);
                    return;
                }
                hVar.Hhb++;
            }
        }
        AppMethodBeat.o(235573);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void jA(int i2, int i3) {
        AppMethodBeat.i(235574);
        Log.i("MicroMsg.Voip.NewVoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.GUK = i2;
        this.GUL = i3;
        if (this.GTX != null) {
            this.GTX.jA(i2, i3);
        }
        AppMethodBeat.o(235574);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void acR(int i2) {
        boolean z = false;
        AppMethodBeat.i(235575);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(i2)));
        if (!this.GTW.adT(4110)) {
            AppMethodBeat.o(235575);
            return;
        }
        u fFg = com.tencent.mm.plugin.voip.c.fFg();
        boolean z2 = i2 == 1;
        if (i2 == 1) {
            z = true;
        }
        fFg.aH(z2, z);
        fFK();
        if (i2 == 1 && k.adQ(this.GTW.mState)) {
            xN(4101);
        }
        xN(4110);
        AppMethodBeat.o(235575);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void acS(int i2) {
        boolean z = false;
        AppMethodBeat.i(235576);
        Log.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(i2)));
        if (!this.GTW.adT(4100)) {
            AppMethodBeat.o(235576);
            return;
        }
        u fFg = com.tencent.mm.plugin.voip.c.fFg();
        boolean z2 = i2 == 1;
        if (i2 == 1) {
            z = true;
        }
        fFg.aH(z2, z);
        com.tencent.mm.plugin.voip.c.fFg().GYS.stopRing();
        if (i2 == 1 && k.adQ(this.GTW.mState)) {
            xN(4101);
        }
        xN(4100);
        AppMethodBeat.o(235576);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void fFT() {
        AppMethodBeat.i(235577);
        Log.d("MicroMsg.Voip.NewVoipMgr", "onPretreatmentForStartDev");
        this.GTV.aM(this.GUx, this.GUg);
        AppMethodBeat.o(235577);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final long fFU() {
        AppMethodBeat.i(235578);
        long j2 = this.GTV.Hgu;
        Log.printInfoStack("MicroMsg.Voip.NewVoipMgr", "totalDeviceNearTime: %s", Long.valueOf(j2));
        long j3 = j2 / 1000;
        AppMethodBeat.o(235578);
        return j3;
    }

    private static String AF(long j2) {
        AppMethodBeat.i(235579);
        String format = String.format("%02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60));
        AppMethodBeat.o(235579);
        return format;
    }

    private void fFV() {
        AppMethodBeat.i(235580);
        synchronized (this.GUd) {
            try {
                fGb();
                if (this.GTX != null) {
                    this.GTX.release();
                }
                this.GTV.unInit();
                this.GTV.fFV();
            } finally {
                AppMethodBeat.o(235580);
            }
        }
    }

    @Override // com.tencent.mm.plugin.voip.model.r.a
    public final void ql(boolean z) {
        int i2 = 2;
        AppMethodBeat.i(235581);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onBadNetStatus");
        if (this.GTY != null) {
            this.GTY.xi(z);
        }
        if (!k.adQ(this.GTW.mState) && !this.GTV.isSpeakerphoneOn()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.yqt > 30000) {
                this.yqt = currentTimeMillis;
                com.tencent.mm.plugin.voip.c.fFg().GYS.fIA();
            }
        }
        Log.i("MicroMsg.Voip.NewVoipMgr", "report the bad net toast room key is " + com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH + "and in the side" + (z ? 1 : 2));
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH);
        if (z) {
            i2 = 1;
        }
        objArr[1] = Integer.valueOf(i2);
        hVar.a(17151, true, true, objArr);
        AppMethodBeat.o(235581);
    }

    @Override // com.tencent.mm.plugin.voip.model.r.a
    public final void dZQ() {
        AppMethodBeat.i(235582);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onNetWorkChangeMobileNet");
        if (this.GTY != null) {
            this.GTY.fJn();
        }
        AppMethodBeat.o(235582);
    }

    @Override // com.tencent.mm.plugin.voip.model.r.a
    public final void dZR() {
        AppMethodBeat.i(235583);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onResumeGoodNetStatus");
        if (this.GTY != null) {
            this.GTY.ebH();
        }
        AppMethodBeat.o(235583);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(235512);
            NewVoipMgr.r(NewVoipMgr.this);
            NewVoipMgr.this.GTZ = null;
            AppMethodBeat.o(235512);
        }
    }

    private boolean fFW() {
        AppMethodBeat.i(235584);
        if (k.adP(this.GTW.mState)) {
            SharedPreferences sharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
            if (!sharedPreferences.getBoolean("voip_shortcut_has_added", false)) {
                boolean c2 = c(sharedPreferences);
                AppMethodBeat.o(235584);
                return c2;
            }
        }
        AppMethodBeat.o(235584);
        return false;
    }

    private boolean c(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(235585);
        String value = com.tencent.mm.n.h.aqJ().getValue("VOIPShortcutAutoadd");
        Log.i("MicroMsg.Voip.NewVoipMgr", "voip shortcut autoAdd is %s", value);
        if (value != null && value.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && Util.secondsToNow(this.GUl) > 30) {
            int i2 = sharedPreferences.getInt("voip_shortcut_prompt_times", 0);
            boolean z = sharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
            if (i2 < 3 && !z) {
                fFX();
                sharedPreferences.edit().putInt("voip_shortcut_prompt_times", i2 + 1).commit();
                AppMethodBeat.o(235585);
                return true;
            }
        } else if (value != null && value.equals("1") && Util.secondsToNow(this.GUl) > 15) {
            d(sharedPreferences);
            AppMethodBeat.o(235585);
            return false;
        }
        AppMethodBeat.o(235585);
        return false;
    }

    private void d(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(235586);
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent2.addFlags(67108864);
        if (1 == Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VOIPCallType"), 0)) {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(R.string.v4));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), R.drawable.b_a));
            intent.putExtra("shortcut_icon_resource_id", R.drawable.b_a);
        } else {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(R.string.v6));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), R.drawable.b_b));
            intent.putExtra("shortcut_icon_resource_id", R.drawable.b_b);
        }
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        com.tencent.mm.plugin.base.model.b.p(getContext(), intent);
        sharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
        AppMethodBeat.o(235586);
    }

    @Override // com.tencent.mm.plugin.voip.video.render.c
    public final Context getContext() {
        AppMethodBeat.i(235587);
        Context context = null;
        if (this.GTY != null) {
            context = this.GTY.fJl();
        }
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        AppMethodBeat.o(235587);
        return context;
    }

    private void fFX() {
        AppMethodBeat.i(235588);
        Context context = getContext();
        View inflate = View.inflate(context, R.layout.b7f, null);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ffe);
        checkBox.setChecked(false);
        TextView textView = (TextView) inflate.findViewById(R.id.ffg);
        if (1 == Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VOIPCallType"), 0)) {
            textView.setText(R.string.i0s);
        } else {
            textView.setText(R.string.i0t);
        }
        com.tencent.mm.ui.base.h.a(context, false, context.getString(R.string.zb), inflate, context.getString(R.string.a0_), context.getString(R.string.x6), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(235487);
                NewVoipMgr.a(NewVoipMgr.this, NewVoipMgr.this.getContext().getSharedPreferences("voip_plugin_prefs", 0));
                if (4096 != NewVoipMgr.this.GUi) {
                    NewVoipMgr.d(NewVoipMgr.this, NewVoipMgr.this.GUi);
                    NewVoipMgr.this.GUi = 4096;
                }
                if (NewVoipMgr.this.kAn != null) {
                    NewVoipMgr.this.kAn.post(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(235486);
                            NewVoipMgr.p(NewVoipMgr.this);
                            AppMethodBeat.o(235486);
                        }
                    });
                }
                AppMethodBeat.o(235487);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(235489);
                if (checkBox != null) {
                    NewVoipMgr.this.getContext().getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", checkBox.isChecked()).commit();
                }
                if (4096 != NewVoipMgr.this.GUi) {
                    NewVoipMgr.d(NewVoipMgr.this, NewVoipMgr.this.GUi);
                    NewVoipMgr.this.GUi = 4096;
                }
                if (NewVoipMgr.this.kAn != null) {
                    NewVoipMgr.this.kAn.post(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(235488);
                            NewVoipMgr.p(NewVoipMgr.this);
                            AppMethodBeat.o(235488);
                        }
                    });
                }
                AppMethodBeat.o(235489);
            }
        });
        AppMethodBeat.o(235588);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean wX(final boolean z) {
        AppMethodBeat.i(235589);
        if (com.tencent.mm.plugin.voip.c.fFg().GZh) {
            Log.i("MicroMsg.Voip.NewVoipMgr", "current state is mini, cannot mini!");
            AppMethodBeat.o(235589);
            return false;
        } else if (!this.GUw || z) {
            Log.printDebugStack("MicroMsg.Voip.NewVoipMgr", "miniOnlyHidenVoip: %b", Boolean.valueOf(z));
            Log.i("MicroMsg.Voip.NewVoipMgr", "onMinimizeVoip, async to minimize");
            if (this.GTY != null) {
                this.GTY.uninit();
                this.GTY = null;
                this.GTV.b(this.GTY);
            }
            this.iGC = Util.currentTicks();
            if (this.GUv != null) {
                this.GUv.uninit();
            }
            if (this.kAn != null) {
                this.kAn.post(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(235490);
                        NewVoipMgr.c(NewVoipMgr.this, z);
                        AppMethodBeat.o(235490);
                    }
                });
            }
            AppMethodBeat.o(235589);
            return true;
        } else {
            Log.i("MicroMsg.Voip.NewVoipMgr", "has phone call  cannot mini!");
            AppMethodBeat.o(235589);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFY() {
        AppMethodBeat.i(235590);
        if (256 != this.GTW.mState && 257 != this.GTW.mState) {
            AppMethodBeat.o(235590);
        } else if (g.aAh().azQ().getInt(327945, 0) != 0 || this.GTY.fJl() == null) {
            com.tencent.mm.plugin.voip.b.m.hG(MMApplicationContext.getContext());
            fGa();
            AppMethodBeat.o(235590);
        } else {
            g.aAh().azQ().setInt(327945, 1);
            com.tencent.mm.ui.widget.a.d a2 = com.tencent.mm.ui.base.h.a(this.GTY.fJl(), (int) R.string.i2y, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(235491);
                    NewVoipMgr.this.fGa();
                    AppMethodBeat.o(235491);
                }
            });
            a2.setCancelable(false);
            a2.setCanceledOnTouchOutside(false);
            a2.show();
            AppMethodBeat.o(235590);
        }
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFZ() {
        AppMethodBeat.i(235591);
        this.GUp = !this.GUp;
        if (this.GUp) {
            this.GUo.stopTimer();
            AppMethodBeat.o(235591);
            return;
        }
        if (this.GUo == null) {
            this.GUo = new MTimerHandler(com.tencent.mm.plugin.appbrand.jsapi.e.b.NAME, (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass7 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(235493);
                    NewVoipMgr.H(NewVoipMgr.this);
                    AppMethodBeat.o(235493);
                    return true;
                }
            }, true);
        }
        this.GUo.startTimer(2000);
        this.GUp = false;
        AppMethodBeat.o(235591);
    }

    public final void fGa() {
        AppMethodBeat.i(235592);
        com.tencent.mm.plugin.voip.c.fFg().GYZ = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId;
        s.c(this.GUe.field_username, this.GUg ? ca.OqC : ca.OqB, this.GUf ? 1 : 0, 6, MMApplicationContext.getContext().getString(R.string.i1b));
        fFK();
        xN(4108);
        if (this.kAn != null) {
            this.kAn.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(235492);
                    NewVoipMgr.G(NewVoipMgr.this);
                    AppMethodBeat.o(235492);
                }
            }, 2000);
        }
        AppMethodBeat.o(235592);
    }

    private void fGb() {
        AppMethodBeat.i(235593);
        if (this.GUn != null) {
            this.GUn.b(this);
        }
        if (this.GUo != null) {
            Log.d("MicroMsg.Voip.NewVoipMgr", "stop face detect timer");
            this.GUo.stopTimer();
        }
        AppMethodBeat.o(235593);
    }

    @Override // com.tencent.mm.plugin.voip.video.f.a
    public final void a(final int[] iArr, final boolean z, final int i2) {
        AppMethodBeat.i(235594);
        if (this.GTX != null && !this.GTX.GYg) {
            this.GTX.fLW();
            this.GTX.GYg = true;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass8 */

            public final void run() {
                com.tencent.mm.plugin.voip.video.camera.a.a aVar;
                AppMethodBeat.i(235494);
                if (!(NewVoipMgr.this.GTX == null || (aVar = NewVoipMgr.this.GTX.HnU) == null)) {
                    aVar.fLi();
                }
                if (NewVoipMgr.this.GTY != null) {
                    com.tencent.mm.plugin.voip.ui.b unused = NewVoipMgr.this.GTY;
                }
                AppMethodBeat.o(235494);
            }
        });
        AppMethodBeat.o(235594);
    }

    private void fGc() {
        AppMethodBeat.i(235595);
        this.GUx = true;
        if (this.GUx && this.GUk == 2) {
            getContext();
            hXE();
        }
        AppMethodBeat.o(235595);
    }

    private void hXE() {
        AppMethodBeat.i(260038);
        this.GTV.ad(new kotlin.g.a.b<Boolean, Long>() {
            /* class com.tencent.mm.plugin.voip.model.NewVoipMgr.AnonymousClass10 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Long invoke(Boolean bool) {
                AppMethodBeat.i(235498);
                Boolean bool2 = bool;
                if (NewVoipMgr.this.GTY == null) {
                    Log.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, voipUI is null, ignore");
                } else if ((NewVoipMgr.this.GUf || k.adP(NewVoipMgr.this.GTW.mState)) && !k.adQ(NewVoipMgr.this.GTW.mState) && NewVoipMgr.this.mUIType != 2) {
                    Log.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, isOn: %s", bool2);
                    NewVoipMgr.this.GTY.setScreenEnable(bool2.booleanValue());
                    NewVoipMgr.this.GUa = bool2.booleanValue();
                    Long valueOf = Long.valueOf(Util.currentTicks());
                    AppMethodBeat.o(235498);
                    return valueOf;
                }
                AppMethodBeat.o(235498);
                return -1L;
            }
        });
        AppMethodBeat.o(260038);
    }

    @Override // com.tencent.mm.plugin.voip.a
    public final String fFb() {
        return this.GUy;
    }

    @Override // com.tencent.mm.plugin.voip.a
    public final long fFc() {
        return this.GUE;
    }

    @Override // com.tencent.mm.plugin.voip.a
    public final long fFd() {
        return this.GUF;
    }

    @Override // com.tencent.mm.plugin.voip.a
    public final int fFe() {
        return this.GUG;
    }

    static /* synthetic */ void p(NewVoipMgr newVoipMgr) {
        AppMethodBeat.i(235598);
        newVoipMgr.hb(false);
        AppMethodBeat.o(235598);
    }

    static /* synthetic */ void c(NewVoipMgr newVoipMgr, boolean z) {
        AppMethodBeat.i(235604);
        Log.i("MicroMsg.Voip.NewVoipMgr", "do minimizeVoip");
        if (2 == newVoipMgr.mUIType && Build.VERSION.SDK_INT < 24) {
            Log.e("MicroMsg.Voip.NewVoipMgr", "already is widget");
            AppMethodBeat.o(235604);
        } else if (262 == newVoipMgr.GTW.mState || 8 == newVoipMgr.GTW.mState) {
            Log.e("MicroMsg.Voip.NewVoipMgr", "voip call has finished!，state is %s", Integer.valueOf(newVoipMgr.GTW.mState));
            AppMethodBeat.o(235604);
        } else {
            newVoipMgr.mUIType = 2;
            newVoipMgr.GUm++;
            newVoipMgr.GUv = new com.tencent.mm.plugin.voip.widget.b(newVoipMgr, newVoipMgr.GTW.mState, newVoipMgr.GUe, newVoipMgr.GUg, newVoipMgr.GUf, z);
            if ((260 == newVoipMgr.GTW.mState || 6 == newVoipMgr.GTW.mState) && 1 != g.aAh().azQ().getInt(327948, 0)) {
                g.aAh().azQ().setInt(327948, 1);
            }
            if (newVoipMgr.GUg && newVoipMgr.GUU != null) {
                newVoipMgr.GUU.adI(0);
            }
            newVoipMgr.fFK();
            com.tencent.mm.plugin.voip.c.fFg().aG(true, z);
            AppMethodBeat.o(235604);
        }
    }

    static /* synthetic */ void H(NewVoipMgr newVoipMgr) {
        AppMethodBeat.i(235606);
        if (k.adP(newVoipMgr.GTW.mState) && newVoipMgr.GTX != null) {
            newVoipMgr.GUn.Hjo = newVoipMgr.GTX.GUq;
            newVoipMgr.GUn.HhG = newVoipMgr.GTX.GUr;
            newVoipMgr.GUn.xx(newVoipMgr.GUs);
        }
        AppMethodBeat.o(235606);
    }
}
