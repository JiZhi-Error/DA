package com.tencent.mm.plugin.voip.model;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.aaq;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.plugin.voip.b.i;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.b.l;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.e;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.plugin.voip.widget.d;
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
import java.nio.ByteBuffer;

public final class VoipMgr extends com.tencent.mm.plugin.voip.a {
    static int[] GUR = new int[2];
    static int mHZ = 0;
    private b GTV = new b();
    private l GTW;
    volatile com.tencent.mm.plugin.voip.ui.b GTY;
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
    PhoneStateListener GUP;
    MMHandler GUQ = new MMHandler("getSignalStrength");
    private long GUS = 0;
    private boolean GUT = false;
    private BroadcastReceiver GUV = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(114963);
            String action = intent.getAction();
            PowerManager powerManager = (PowerManager) MMApplicationContext.getContext().getSystemService("power");
            if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
                VoipMgr.this.GYb = false;
                AppMethodBeat.o(114963);
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                VoipMgr.this.GYb = false;
                VoipMgr.this.GTV.onSensorEvent(true);
                AppMethodBeat.o(114963);
            } else {
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    VoipMgr.this.GYb = true;
                    if (!VoipMgr.this.GUa) {
                        VoipMgr.this.GTV.onSensorEvent(true);
                    }
                    if (!k.adP(VoipMgr.this.GTW.mState) && !VoipMgr.this.GUf) {
                        VoipMgr.this.GTV.fFK();
                    }
                }
                AppMethodBeat.o(114963);
            }
        }
    };
    int GUW = 0;
    private IListener GUX = new IListener<aaq>() {
        /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass15 */

        {
            AppMethodBeat.i(235626);
            this.__eventId = aaq.class.getName().hashCode();
            AppMethodBeat.o(235626);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaq aaq) {
            AppMethodBeat.i(235627);
            final aaq aaq2 = aaq;
            if (aaq2 instanceof aaq) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass15.AnonymousClass1 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    public final void run() {
                        AppMethodBeat.i(235625);
                        switch (aaq2.ehD.dDe) {
                            case 1:
                                if (k.adQ(VoipMgr.this.GTW.mState)) {
                                    VoipMgr.this.fFw();
                                    AppMethodBeat.o(235625);
                                    return;
                                }
                                VoipMgr.this.fFz();
                                AppMethodBeat.o(235625);
                                return;
                            case 2:
                                if (k.adQ(VoipMgr.this.GTW.mState)) {
                                    VoipMgr.this.fFv();
                                    AppMethodBeat.o(235625);
                                    return;
                                }
                                VoipMgr.this.fFy();
                                AppMethodBeat.o(235625);
                                return;
                            case 3:
                                VoipMgr.this.fFt();
                                break;
                        }
                        AppMethodBeat.o(235625);
                    }
                });
            }
            AppMethodBeat.o(235627);
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
    private boolean GUu = false;
    private boolean GUw = false;
    private boolean GUx = false;
    private String GUy = null;
    private com.tencent.mm.plugin.voip.video.camera.prev.a GXZ;
    private a GYa = null;
    private boolean GYb = false;
    private d GYc;
    private byte[] GYd = null;
    private ByteBuffer GYe = null;
    private int GYf = 0;
    private boolean GYg = true;
    NetChangedBroadcastReceiver GYh;
    private int GYi = 0;
    private int GYj = 0;
    private i GYk;
    private com.tencent.mm.plugin.voip.b.a GYl;
    MMHandler GYm = new MMHandler("encodeVoipHandler");
    boolean GYn = false;
    private String goe;
    private MMHandler kAn;
    private int mUIType;
    PhoneStateListener mtH = new PhoneStateListener() {
        /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass6 */

        public final void onCallStateChanged(int i2, String str) {
            String string;
            int i3 = 1;
            AppMethodBeat.i(235616);
            super.onCallStateChanged(i2, str);
            Log.i("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", Integer.valueOf(i2), Boolean.valueOf(VoipMgr.this.GUu), Integer.valueOf(VoipMgr.this.GUJ));
            if (!VoipMgr.this.GUu) {
                AppMethodBeat.o(235616);
                return;
            }
            if ((VoipMgr.this.GUJ == 0 && i2 == 1) || (VoipMgr.this.GUJ == 0 && i2 == 2)) {
                VoipMgr.y(VoipMgr.this);
            }
            if (i2 == 1) {
                VoipMgr.this.GUw = true;
                if (VoipMgr.this.GUJ == 0) {
                    VoipMgr.this.GUE = System.currentTimeMillis();
                }
                VoipMgr.this.GUJ = 1;
                c.fFg().adh(1);
                VoipMgr.this.GUT = true;
            } else if (i2 == 2) {
                VoipMgr.this.GUw = false;
                if (VoipMgr.this.GUJ == 1) {
                    VoipMgr.this.GUF = System.currentTimeMillis();
                }
                VoipMgr.this.GUJ = 2;
                Log.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
                if (VoipMgr.this.GUf && !k.adP(VoipMgr.this.GTW.mState)) {
                    c.fFg().GYS.fIv();
                }
                if (k.adP(VoipMgr.this.GTW.mState)) {
                    string = MMApplicationContext.getContext().getString(R.string.i1_, VoipMgr.Lh(Util.secondsToNow(VoipMgr.this.GUl)));
                } else {
                    string = MMApplicationContext.getContext().getString(R.string.i16);
                }
                c.fFg().fHS();
                String str2 = VoipMgr.this.GUe.field_username;
                String str3 = VoipMgr.this.GUg ? ca.OqC : ca.OqB;
                if (!VoipMgr.this.GUf) {
                    i3 = 0;
                }
                s.c(str2, str3, i3, 6, string);
                VoipMgr.d(VoipMgr.this, 4107);
                VoipMgr.B(VoipMgr.this);
                ca caVar = new ca();
                caVar.setType(10000);
                caVar.setCreateTime(System.currentTimeMillis());
                caVar.setStatus(6);
                caVar.setContent(MMApplicationContext.getContext().getString(R.string.i18) + ", <a href=\"weixin://voip/callagain/?username=" + VoipMgr.this.goe + "&isvideocall=" + VoipMgr.this.GUg + "\">" + MMApplicationContext.getContext().getString(R.string.i13) + "</a>");
                if (VoipMgr.this.goe != null && !VoipMgr.this.goe.equals("")) {
                    caVar.Cy(VoipMgr.this.goe);
                    ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar);
                }
                c.fFg().adh(2);
                VoipMgr.this.GUT = false;
            } else if (i2 == 0) {
                if (VoipMgr.this.GUJ == 1 || VoipMgr.this.GUJ == 2) {
                    VoipMgr.this.GUF = System.currentTimeMillis();
                }
                VoipMgr.this.GUJ = 0;
                c.fFg().adh(2);
                if (1 == VoipMgr.this.GUk && k.adP(VoipMgr.this.GTW.mState) && VoipMgr.this.GUw) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(235612);
                            VoipMgr.this.GTV.cV(true);
                            AppMethodBeat.o(235612);
                        }
                    });
                }
                if (4 == VoipMgr.this.GUk && VoipMgr.this.GUw) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass6.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(235613);
                            VoipMgr.this.GTV.aM(VoipMgr.this.GUx, VoipMgr.this.GUg);
                            AppMethodBeat.o(235613);
                        }
                    });
                }
                VoipMgr.this.GUw = false;
                if (com.tencent.mm.plugin.audio.c.a.cea().isBluetoothScoOn()) {
                    Log.i("MicroMsg.Voip.VoipMgr", "is bluetooth can use and start bluetooth");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass6.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(235614);
                            VoipMgr.this.GTV.aM(VoipMgr.this.GUx, VoipMgr.this.GUg);
                            AppMethodBeat.o(235614);
                        }
                    });
                } else if (com.tencent.mm.plugin.audio.c.a.cea().cdW()) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass6.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(235615);
                            VoipMgr.this.GTV.aM(VoipMgr.this.GUx, VoipMgr.this.GUg);
                            AppMethodBeat.o(235615);
                        }
                    });
                }
                VoipMgr.this.GUT = false;
            }
            VoipMgr.this.GTV.GUT = VoipMgr.this.GUT;
            AppMethodBeat.o(235616);
        }
    };
    private CaptureView qsJ;
    TelephonyManager qtS = null;
    private long wNg = 0;
    private TelephonyManager yoi;
    private IListener yok = new IListener<zi>() {
        /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass12 */

        {
            AppMethodBeat.i(235621);
            this.__eventId = zi.class.getName().hashCode();
            AppMethodBeat.o(235621);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zi ziVar) {
            AppMethodBeat.i(235622);
            zi ziVar2 = ziVar;
            if (!(ziVar2 instanceof zi)) {
                AppMethodBeat.o(235622);
            } else {
                ziVar2.efv.efw = k.adQ(VoipMgr.this.GTW.mState);
                ziVar2.efv.dCH = VoipMgr.this.GXZ != null;
                ziVar2.efv.dCI = true;
                ziVar2.efv.talker = VoipMgr.this.goe;
                AppMethodBeat.o(235622);
            }
            return false;
        }
    };
    private long yqt = 0;
    private boolean zuc = false;

    static /* synthetic */ void B(VoipMgr voipMgr) {
        AppMethodBeat.i(235656);
        voipMgr.fFP();
        AppMethodBeat.o(235656);
    }

    static /* synthetic */ Context G(VoipMgr voipMgr) {
        AppMethodBeat.i(235657);
        Context context = voipMgr.getContext();
        AppMethodBeat.o(235657);
        return context;
    }

    static /* synthetic */ void K(VoipMgr voipMgr) {
        AppMethodBeat.i(235660);
        voipMgr.hb(true);
        AppMethodBeat.o(235660);
    }

    static /* synthetic */ String Lh(long j2) {
        AppMethodBeat.i(235654);
        String AF = AF(j2);
        AppMethodBeat.o(235654);
        return AF;
    }

    static /* synthetic */ void a(VoipMgr voipMgr, int i2) {
        AppMethodBeat.i(235650);
        voipMgr.acM(i2);
        AppMethodBeat.o(235650);
    }

    static /* synthetic */ void a(VoipMgr voipMgr, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(235658);
        voipMgr.d(sharedPreferences);
        AppMethodBeat.o(235658);
    }

    static /* synthetic */ void d(VoipMgr voipMgr, int i2) {
        AppMethodBeat.i(235655);
        voipMgr.xN(i2);
        AppMethodBeat.o(235655);
    }

    static /* synthetic */ void t(VoipMgr voipMgr) {
        AppMethodBeat.i(235652);
        voipMgr.fHk();
        AppMethodBeat.o(235652);
    }

    static /* synthetic */ void u(VoipMgr voipMgr) {
        AppMethodBeat.i(235653);
        voipMgr.fFV();
        AppMethodBeat.o(235653);
    }

    static /* synthetic */ int y(VoipMgr voipMgr) {
        int i2 = voipMgr.GUG;
        voipMgr.GUG = i2 + 1;
        return i2;
    }

    public VoipMgr() {
        AppMethodBeat.i(114994);
        AppMethodBeat.o(114994);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x015c  */
    @Override // com.tencent.mm.plugin.voip.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final android.content.Context r10, java.lang.String r11, boolean r12, boolean r13, long r14) {
        /*
        // Method dump skipped, instructions count: 795
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.model.VoipMgr.a(android.content.Context, java.lang.String, boolean, boolean, long):void");
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
        AppMethodBeat.i(235635);
        if (!(this.GTW != null && this.GTW.mState >= 0 && this.GTW.mState <= 8)) {
            Log.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] same state, no need to reset, return!");
            AppMethodBeat.o(235635);
            return;
        }
        int aQ = k.aQ(false, z);
        if (this.GUh) {
            if (aQ == 0) {
                aQ = 1;
            } else if (256 == aQ) {
                aQ = CdnLogic.kAppTypeFestivalImage;
            }
        }
        this.GTW = k.adN(aQ);
        Log.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", Integer.valueOf(aQ), Boolean.FALSE, Boolean.valueOf(z));
        this.GUf = false;
        AppMethodBeat.o(235635);
    }

    @Override // com.tencent.mm.plugin.voip.a
    public final String getUserName() {
        return this.goe;
    }

    @Override // com.tencent.mm.plugin.voip.a
    public final int getState() {
        return this.GTW.mState;
    }

    private void hXE() {
        AppMethodBeat.i(260039);
        this.GTV.ad(new kotlin.g.a.b<Boolean, Long>() {
            /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass17 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Long invoke(Boolean bool) {
                AppMethodBeat.i(235629);
                Boolean bool2 = bool;
                if (VoipMgr.this.GTY == null) {
                    Log.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, voipUI is null, ignore");
                } else if ((VoipMgr.this.GUf || k.adP(VoipMgr.this.GTW.mState)) && !k.adQ(VoipMgr.this.GTW.mState) && VoipMgr.this.mUIType != 2) {
                    Log.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, isOn: %s", bool2);
                    VoipMgr.this.GTY.setScreenEnable(bool2.booleanValue());
                    VoipMgr.this.GUa = bool2.booleanValue();
                    Long valueOf = Long.valueOf(Util.currentTicks());
                    AppMethodBeat.o(235629);
                    return valueOf;
                }
                AppMethodBeat.o(235629);
                return -1L;
            }
        });
        AppMethodBeat.o(260039);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void wU(boolean z) {
        AppMethodBeat.i(115001);
        Log.i("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", Boolean.valueOf(z));
        this.GTV.cV(z);
        this.GTV.HgE = true;
        AppMethodBeat.o(115001);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void rv(boolean z) {
        AppMethodBeat.i(115002);
        this.GTV.xp(z);
        AppMethodBeat.o(115002);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFt() {
        AppMethodBeat.i(115003);
        if (!this.GTW.adT(4103)) {
            AppMethodBeat.o(115003);
            return false;
        }
        acN(4103);
        c.fFg().fIl();
        AppMethodBeat.o(115003);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFu() {
        AppMethodBeat.i(115004);
        if (!this.GTW.adT(4101)) {
            AppMethodBeat.o(115004);
            return false;
        }
        fFK();
        c.fFg().adf(1);
        c.fFg().aH(true, this.GUg);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[5];
        objArr[0] = 1;
        objArr[1] = Long.valueOf(c.fFg().GYS.GSZ.GVV.ypH);
        objArr[2] = Integer.valueOf(c.fFg().GYS.GSZ.GVV.roomId);
        objArr[3] = 0;
        objArr[4] = Integer.valueOf(this.GUf ? 1 : 0);
        hVar.a(11046, objArr);
        h.INSTANCE.a(11080, 2, 0, 0);
        xN(4111);
        xN(4101);
        xN(4100);
        AppMethodBeat.o(115004);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFv() {
        int i2 = 0;
        AppMethodBeat.i(115005);
        if (!this.GTW.adT(4099)) {
            AppMethodBeat.o(115005);
            return false;
        }
        String str = this.GUe.field_username;
        String str2 = this.GUg ? ca.OqC : ca.OqB;
        if (this.GUf) {
            i2 = 1;
        }
        s.c(str, str2, i2, 6, MMApplicationContext.getContext().getString(R.string.i1c));
        fFK();
        c.fFg().GYS.fIw();
        xN(4099);
        fFP();
        AppMethodBeat.o(115005);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFw() {
        AppMethodBeat.i(115006);
        if (!this.GTW.adT(4100)) {
            AppMethodBeat.o(115006);
            return false;
        }
        if (ae.gKt.gFB == 1 && this.GUg) {
            xc(true);
        }
        if ((!this.GYg || ae.gKt.gFB == 1 || ae.gKt.gFC == 1) && this.GUg) {
            xc(this.GXZ == null || this.GXZ.fLp());
            this.GYg = true;
        }
        Log.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
        fFK();
        c.fFg().aH(false, this.GUg);
        xN(4100);
        AppMethodBeat.o(115006);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFx() {
        this.GYg = false;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFy() {
        int i2 = 0;
        AppMethodBeat.i(115007);
        if (!this.GTW.adT(4099)) {
            AppMethodBeat.o(115007);
            return false;
        }
        Log.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
        String str = this.GUe.field_username;
        String str2 = this.GUg ? ca.OqC : ca.OqB;
        if (this.GUf) {
            i2 = 1;
        }
        s.c(str, str2, i2, 6, MMApplicationContext.getContext().getString(R.string.i1c));
        fFK();
        c.fFg().GYS.fIw();
        xN(4099);
        fFP();
        AppMethodBeat.o(115007);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFz() {
        AppMethodBeat.i(115008);
        if (!this.GTW.adT(4100)) {
            AppMethodBeat.o(115008);
            return false;
        }
        Log.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
        fFK();
        c.fFg().aH(true, this.GUg);
        xN(4111);
        xN(4100);
        AppMethodBeat.o(115008);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFA() {
        AppMethodBeat.i(115009);
        if (!this.GTW.adT(4098)) {
            AppMethodBeat.o(115009);
            return false;
        }
        Log.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
        acN(4098);
        c.fFg().fIl();
        AppMethodBeat.o(115009);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFB() {
        AppMethodBeat.i(115010);
        if (!this.GTW.adT(4098)) {
            AppMethodBeat.o(115010);
            return false;
        }
        Log.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
        acN(4098);
        c.fFg().fIl();
        AppMethodBeat.o(115010);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void a(com.tencent.mm.plugin.voip.ui.b bVar, int i2) {
        AppMethodBeat.i(115011);
        Log.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated, uiType: %s, captureRender: %s, mVoicePlayDevice: %s", Integer.valueOf(i2), this.GXZ, Integer.valueOf(this.GUk));
        if (1 == i2 && this.GTY != null) {
            this.GTY.uninit();
        }
        this.GTY = bVar;
        this.mUIType = i2;
        this.GTV.b(this.GTY);
        if (this.GXZ == null && k.adQ(this.GTW.mState)) {
            this.qsJ = new CaptureView(MMApplicationContext.getContext());
        }
        this.GTY.jD(-1, this.GTW.mState);
        this.GTY.setConnectSec(this.GUl);
        Log.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr decMode:%d, beautyCmd:%d", Integer.valueOf(this.GUB), Integer.valueOf(this.GUC));
        if (this.GUB != -1) {
            this.GTY.setHWDecMode(this.GUB);
            Log.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr setHWDecMode,decMode:%d", Integer.valueOf(this.GUB));
        }
        this.GTY.setVoipBeauty(this.GUC);
        this.GTY.setSpatiotemporalDenosing(this.GUD);
        e.fLK().HlY = new e.a() {
            /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass18 */

            @Override // com.tencent.mm.plugin.voip.video.b.e.a
            public final void MC() {
                AppMethodBeat.i(235630);
                VoipMgr voipMgr = VoipMgr.this;
                SurfaceTexture surfaceTexture = v2protocal.mSurfaceTexture;
                com.tencent.mm.media.g.d dVar = v2protocal.HcD;
                if (!(voipMgr.GTY == null || surfaceTexture == null)) {
                    surfaceTexture.setOnFrameAvailableListener(voipMgr);
                    voipMgr.GTY.a(surfaceTexture, dVar);
                }
                AppMethodBeat.o(235630);
            }
        };
        if (!(this.GUK == 0 || this.GUL == 0)) {
            jA(this.GUK, this.GUL);
        }
        AppMethodBeat.o(115011);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFC() {
        AppMethodBeat.i(115012);
        if (this.GUg && this.GTY != null) {
            this.GTY.setCaptureView(this.qsJ);
            if (ae.gKt.gFB == 0 || this.GUf) {
                xc(this.GXZ == null || this.GXZ.fLp());
            }
        }
        if (this.GUf && k.adR(this.GTW.mState) && c.fFg().GYS.czl()) {
            this.GTV.aN(this.GUg, this.GUf);
            this.GTV.b("voip", Integer.valueOf(this.GUk));
        }
        AppMethodBeat.o(115012);
    }

    /* access modifiers changed from: package-private */
    public final void acM(int i2) {
        WifiManager wifiManager;
        AppMethodBeat.i(115013);
        if (i2 == 5) {
            mHZ += GUR[0];
            this.GUW++;
            Log.i("MicroMsg.Voip.VoipMgr", "mSignalStrength 4G" + GUR[0] + " and index is " + this.GUW);
            AppMethodBeat.o(115013);
            return;
        }
        if (!(i2 != 4 || (wifiManager = (WifiManager) MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi")) == null || wifiManager.getConnectionInfo() == null)) {
            try {
                GUR[1] = wifiManager.getConnectionInfo() == null ? 0 : wifiManager.getConnectionInfo().getRssi();
            } catch (Exception e2) {
                GUR[1] = 0;
                Log.i("MicroMsg.Voip.VoipMgr", "error happened in get wifi info");
            }
            mHZ += GUR[1];
            this.GUW++;
            Log.i("MicroMsg.Voip.VoipMgr", "mSignalStrength WIFI " + GUR[1] + " and index is " + this.GUW);
        }
        AppMethodBeat.o(115013);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFD() {
        AppMethodBeat.i(115014);
        Log.i("MicroMsg.Voip.VoipMgr", "it is init voip report");
        this.GYh = new NetChangedBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        MMApplicationContext.getContext().registerReceiver(this.GYh, intentFilter);
        this.qtS = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
        this.GUM = com.tencent.mm.plugin.voip.b.e.getNetType(getContext());
        this.GUP = new PhoneStateListener() {
            /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass19 */

            public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                AppMethodBeat.i(235631);
                super.onSignalStrengthsChanged(signalStrength);
                super.onSignalStrengthsChanged(signalStrength);
                String[] split = signalStrength.toString().split(" ");
                try {
                    if (VoipMgr.this.qtS.getNetworkType() == 13 && split.length > 9) {
                        VoipMgr.GUR[0] = Util.safeParseInt(split[9]);
                    }
                    AppMethodBeat.o(235631);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Voip.VoipMgr", e2, "", new Object[0]);
                    AppMethodBeat.o(235631);
                }
            }
        };
        TelephonyManager telephonyManager = this.qtS;
        com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(this.GUP);
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/voip/model/VoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/voip/model/VoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        AppMethodBeat.o(115014);
    }

    public class NetChangedBroadcastReceiver extends BroadcastReceiver {
        public NetChangedBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            int i2 = 0;
            AppMethodBeat.i(114993);
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                switch (com.tencent.mm.plugin.voip.b.e.getNetType(context)) {
                    case 4:
                        if (VoipMgr.this.GUM != 4) {
                            int i3 = VoipMgr.GUR[0];
                            if (VoipMgr.this.GUW == 0) {
                                VoipMgr.a(VoipMgr.this, 5);
                            }
                            if (VoipMgr.this.GUW != 0) {
                                int i4 = VoipMgr.mHZ / VoipMgr.this.GUW;
                                VoipMgr.a(VoipMgr.this, 4);
                                int i5 = VoipMgr.GUR[1];
                                Log.i("MicroMsg.Voip.VoipMgr", "befor change to wifi and cost " + VoipMgr.this.wNg);
                                if (!VoipMgr.this.GUf) {
                                    i2 = 1;
                                }
                                com.tencent.mm.plugin.voip.b.e.a(i2, System.currentTimeMillis(), VoipMgr.this.GUM, 4, i3, i5, i4);
                                VoipMgr.this.GUN = true;
                                VoipMgr.this.GUM = 4;
                                int unused = VoipMgr.mHZ = 0;
                                VoipMgr.this.GUW = 0;
                                break;
                            }
                        }
                        break;
                    case 5:
                        if (VoipMgr.this.GUM != 5) {
                            int i6 = VoipMgr.GUR[1];
                            if (VoipMgr.this.GUW == 0) {
                                VoipMgr.a(VoipMgr.this, 4);
                            }
                            if (VoipMgr.this.GUW != 0) {
                                int i7 = VoipMgr.mHZ / VoipMgr.this.GUW;
                                VoipMgr.a(VoipMgr.this, 5);
                                int i8 = VoipMgr.GUR[0];
                                Log.i("MicroMsg.Voip.VoipMgr", "befor change to 4G and cost " + VoipMgr.this.wNg);
                                if (!VoipMgr.this.GUf) {
                                    i2 = 1;
                                }
                                com.tencent.mm.plugin.voip.b.e.a(i2, System.currentTimeMillis(), VoipMgr.this.GUM, 5, i6, i8, i7);
                                VoipMgr.this.GUN = true;
                                VoipMgr.this.GUM = 5;
                                int unused2 = VoipMgr.mHZ = 0;
                                VoipMgr.this.GUW = 0;
                                AppMethodBeat.o(114993);
                                return;
                            }
                        }
                        break;
                }
                AppMethodBeat.o(114993);
            } else if (!intent.getAction().equals("android.net.wifi.STATE_CHANGE") || VoipMgr.this.GUS != 0) {
                if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED") && VoipMgr.this.GUS != 0) {
                    VoipMgr.this.wNg = System.currentTimeMillis() - VoipMgr.this.GUS;
                    VoipMgr.this.GUS = 0;
                }
                AppMethodBeat.o(114993);
            } else {
                VoipMgr.this.GUS = System.currentTimeMillis();
                AppMethodBeat.o(114993);
            }
        }
    }

    private void xc(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(115015);
        if (this.GUg) {
            Log.i("MicroMsg.Voip.VoipMgr", "setCameraCaptureBind,  isFace: %s", Boolean.valueOf(z));
            Log.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
            if (this.GXZ == null) {
                this.GXZ = new com.tencent.mm.plugin.voip.video.camera.prev.a(640, 480);
            }
            if (this.GXZ.a(this, z) != 1) {
                z2 = false;
            }
            this.GYg = z2;
            if (this.GYg && this.qsJ != null) {
                this.GXZ.a(this.qsJ);
                c.fFg().adn(this.GXZ.fLa());
                if (this.kAn != null) {
                    this.kAn.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass20 */

                        public final void run() {
                            AppMethodBeat.i(235632);
                            Log.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + VoipMgr.this.GXZ);
                            if (VoipMgr.this.GXZ != null) {
                                VoipMgr.this.GXZ.fLb();
                                VoipMgr.this.GYi = 0;
                            }
                            AppMethodBeat.o(235632);
                        }
                    }, 50);
                }
            }
        }
        AppMethodBeat.o(115015);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void a(com.tencent.mm.plugin.voip.ui.b bVar) {
        AppMethodBeat.i(115016);
        Log.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
        if (this.GTY == bVar) {
            Log.d("MicroMsg.Voip.VoipMgr", "same mVoIPUi, clear it");
            this.GTY = null;
            this.GTV.b((com.tencent.mm.plugin.voip.ui.b) null);
        }
        if (this.kAn != null) {
            this.kAn = null;
        }
        AppMethodBeat.o(115016);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFF() {
        AppMethodBeat.i(115017);
        Log.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
        if (this.GXZ != null) {
            this.GXZ.fLd();
        }
        h.INSTANCE.a(11079, 1);
        AppMethodBeat.o(115017);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFG() {
        AppMethodBeat.i(115018);
        if (true != this.GXZ.fLp()) {
            fFF();
        }
        AppMethodBeat.o(115018);
    }

    private void acN(int i2) {
        String string;
        int i3 = 0;
        AppMethodBeat.i(115019);
        Log.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
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
                /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass21 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "VoipMgr_play_end_sound";
                }

                public final void run() {
                    AppMethodBeat.i(235633);
                    VoipMgr.this.GTV.xq(VoipMgr.this.GUg);
                    AppMethodBeat.o(235633);
                }
            });
            this.GUb = true;
            this.GUc = true;
            c.fFg().GYS.fIx();
            if (4096 == this.GUi) {
                xN(i2);
                fFP();
            }
        } else {
            fFK();
            if (this.GUf && !k.adP(this.GTW.mState)) {
                Log.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
                c.fFg().GYS.fIu();
            }
            Log.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
            c.fFg().GYS.fIx();
            if (4096 == this.GUi) {
                xN(i2);
                fFP();
                AppMethodBeat.o(115019);
                return;
            }
        }
        AppMethodBeat.o(115019);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void setVoicePlayDevice(int i2) {
        AppMethodBeat.i(235637);
        if (this.GUk == 2 && i2 != 2) {
            this.GTV.fJP();
        } else if (i2 == 2 && this.GUk != 2 && k.adQ(this.GTW.mState)) {
            getContext();
            hXE();
        }
        this.GUk = i2;
        AppMethodBeat.o(235637);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFK() {
        AppMethodBeat.i(235638);
        if (this.GTV != null) {
            Log.i("MicroMsg.Voip.VoipMgr", "use audioManager to stop voip ring");
            this.GTV.fFK();
            AppMethodBeat.o(235638);
            return;
        }
        Log.i("MicroMsg.Voip.VoipMgr", "use Subcore to stop voip ring");
        c.fFg().GYS.stopRing();
        AppMethodBeat.o(235638);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFL() {
        AppMethodBeat.i(235639);
        if (this.GTY != null) {
            this.GTY.fFL();
        }
        AppMethodBeat.o(235639);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void a(VoIPRenderTextureView voIPRenderTextureView, int i2) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void a(VoIPRenderSurfaceView voIPRenderSurfaceView, int i2) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void a(VoIPRenderTextureView voIPRenderTextureView) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void a(VoIPRenderSurfaceView voIPRenderSurfaceView) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFH() {
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void wV(boolean z) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFI() {
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void jz(int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void aE(boolean z, boolean z2) {
        AppMethodBeat.i(235640);
        if (this.GYk != null) {
            i iVar = this.GYk;
            long currentTicks = Util.currentTicks();
            if (z) {
                if (z2) {
                    iVar.Hhm = currentTicks;
                    AppMethodBeat.o(235640);
                    return;
                }
                iVar.Hhe = currentTicks;
                AppMethodBeat.o(235640);
                return;
            } else if (z2) {
                iVar.Hhn = currentTicks;
                AppMethodBeat.o(235640);
                return;
            } else {
                iVar.Hhf = currentTicks;
            }
        }
        AppMethodBeat.o(235640);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void ah(long j2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        AppMethodBeat.i(235641);
        if (this.GYk != null) {
            switch (i2) {
                case 3:
                    if (1 != this.mUIType) {
                        if (c.fFg().GZf) {
                            i iVar = this.GYk;
                            if (260 == this.GTW.mState || 6 == this.GTW.mState) {
                                z = false;
                            } else {
                                z = true;
                            }
                            iVar.aP(false, z);
                            break;
                        } else {
                            i iVar2 = this.GYk;
                            if (260 == this.GTW.mState || 6 == this.GTW.mState) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            iVar2.aO(false, z2);
                            c.fFg().GZf = true;
                            break;
                        }
                    } else if (c.fFg().GZg) {
                        i iVar3 = this.GYk;
                        if (260 == this.GTW.mState || 6 == this.GTW.mState) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        iVar3.aP(true, z3);
                        break;
                    } else {
                        i iVar4 = this.GYk;
                        if (260 == this.GTW.mState || 6 == this.GTW.mState) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        iVar4.aO(true, z4);
                        c.fFg().GZg = true;
                        break;
                    }
                    break;
            }
            i iVar5 = this.GYk;
            if (1 != this.mUIType) {
                z5 = false;
            }
            boolean z6 = this.GYn;
            switch (i2) {
                case 0:
                    iVar5.Hhi++;
                    if (iVar5.Hhi == 0) {
                        if (!z5) {
                            if (j2 != -1) {
                                com.tencent.mm.plugin.voip.b.f fVar = com.tencent.mm.plugin.voip.b.f.HgY;
                                com.tencent.mm.plugin.voip.b.f.Lt(j2);
                            }
                            AppMethodBeat.o(235641);
                            return;
                        } else if (j2 != -1) {
                            com.tencent.mm.plugin.voip.b.f fVar2 = com.tencent.mm.plugin.voip.b.f.HgY;
                            com.tencent.mm.plugin.voip.b.f.Ls(j2);
                            AppMethodBeat.o(235641);
                            return;
                        }
                    } else if (iVar5.Hhi == 60) {
                        iVar5.Hhi = -1;
                    }
                    AppMethodBeat.o(235641);
                    return;
                case 1:
                    iVar5.Hhj++;
                    if (iVar5.Hhj == 0) {
                        if (!z5) {
                            if (j2 > 0) {
                                if (z6) {
                                    com.tencent.mm.plugin.voip.b.f fVar3 = com.tencent.mm.plugin.voip.b.f.HgY;
                                    com.tencent.mm.plugin.voip.b.f.Ly(j2);
                                    AppMethodBeat.o(235641);
                                    return;
                                }
                                com.tencent.mm.plugin.voip.b.f fVar4 = com.tencent.mm.plugin.voip.b.f.HgY;
                                com.tencent.mm.plugin.voip.b.f.Lx(j2);
                            }
                            AppMethodBeat.o(235641);
                            return;
                        } else if (j2 > 0) {
                            if (z6) {
                                com.tencent.mm.plugin.voip.b.f fVar5 = com.tencent.mm.plugin.voip.b.f.HgY;
                                com.tencent.mm.plugin.voip.b.f.Lz(j2);
                                AppMethodBeat.o(235641);
                                return;
                            }
                            com.tencent.mm.plugin.voip.b.f fVar6 = com.tencent.mm.plugin.voip.b.f.HgY;
                            com.tencent.mm.plugin.voip.b.f.Lw(j2);
                            AppMethodBeat.o(235641);
                            return;
                        }
                    } else if (iVar5.Hhj == 30) {
                        iVar5.Hhj = -1;
                    }
                    AppMethodBeat.o(235641);
                    return;
                case 2:
                    iVar5.Hhk++;
                    if (iVar5.Hhk != 0) {
                        if (iVar5.Hhk == 60) {
                            iVar5.Hhk = -1;
                            break;
                        }
                    } else if (z5) {
                        com.tencent.mm.plugin.voip.b.f fVar7 = com.tencent.mm.plugin.voip.b.f.HgY;
                        com.tencent.mm.plugin.voip.b.f.Lu(j2);
                        AppMethodBeat.o(235641);
                        return;
                    } else {
                        com.tencent.mm.plugin.voip.b.f fVar8 = com.tencent.mm.plugin.voip.b.f.HgY;
                        com.tencent.mm.plugin.voip.b.f.Lv(j2);
                        AppMethodBeat.o(235641);
                        return;
                    }
                    break;
            }
        }
        AppMethodBeat.o(235641);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFJ() {
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean fFM() {
        AppMethodBeat.i(115020);
        if (c.fFg().GYS.GSZ.GVV.roomId == 0) {
            this.GUj = true;
            AppMethodBeat.o(115020);
            return true;
        }
        boolean fFN = fFN();
        AppMethodBeat.o(115020);
        return fFN;
    }

    private boolean fFN() {
        h hVar;
        int i2;
        Object[] objArr;
        Object[] objArr2;
        char c2;
        int i3 = 0;
        AppMethodBeat.i(115021);
        if (!this.GTW.adT(4101)) {
            AppMethodBeat.o(115021);
            return false;
        }
        this.GUg = false;
        if (this.GYc != null) {
            this.GYc.GUg = false;
        }
        xN(4101);
        if (261 == this.GTW.mState || 7 == this.GTW.mState) {
            c.fFg().adf(1);
            h hVar2 = h.INSTANCE;
            Object[] objArr3 = new Object[5];
            objArr3[0] = 2;
            objArr3[1] = Long.valueOf(c.fFg().GYS.GSZ.GVV.ypH);
            objArr3[2] = Integer.valueOf(c.fFg().GYS.GSZ.GVV.roomId);
            objArr3[3] = 0;
            objArr3[4] = Integer.valueOf(this.GUf ? 1 : 0);
            hVar2.a(11046, objArr3);
            hVar = h.INSTANCE;
            i2 = 11080;
            Object[] objArr4 = new Object[3];
            objArr4[0] = 2;
            objArr4[1] = 0;
            c2 = 2;
            objArr2 = objArr4;
            objArr = objArr4;
        } else {
            if (1 == this.GTW.mState || 3 == this.GTW.mState) {
                c.fFg().adf(1);
                hVar = h.INSTANCE;
                i2 = 11046;
                Object[] objArr5 = new Object[5];
                objArr5[0] = 1;
                objArr5[1] = Long.valueOf(c.fFg().GYS.GSZ.GVV.ypH);
                objArr5[2] = Integer.valueOf(c.fFg().GYS.GSZ.GVV.roomId);
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
            c.fFg().GYS.GSZ.fGz();
            c.fFg().GYS.GSZ.fGA();
            AppMethodBeat.o(115021);
            return true;
        }
        objArr2[c2] = Integer.valueOf(i3);
        hVar.a(i2, objArr);
        c.fFg().GYS.GSZ.fGz();
        c.fFg().GYS.GSZ.fGA();
        AppMethodBeat.o(115021);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void fFO() {
        AppMethodBeat.i(115022);
        Log.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
        if (this.GUj && c.fFg().GYS.GSZ.GVV.roomId != 0) {
            this.GUj = false;
            fFN();
        }
        if (this.GUf) {
            xN(4097);
        }
        AppMethodBeat.o(115022);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void enR() {
        AppMethodBeat.i(184052);
        if (this.GTY != null) {
            this.GTY.enR();
        }
        AppMethodBeat.o(184052);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void xN(final int i2) {
        AppMethodBeat.i(115023);
        Log.printDebugStack("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", k.adM(i2), k.adM(this.GTW.mState));
        if (4101 == i2 && k.adQ(this.GTW.mState)) {
            fHl();
            this.GUg = false;
            if (this.GYc != null) {
                this.GYc.GUg = false;
            }
        }
        if (acO(i2)) {
            this.GTV.Hgx = false;
        }
        if (acO(i2) && 1 == this.mUIType && 1 == this.GUk) {
            this.GTV.cV(false);
            fGc();
            if (!c.fFg().GYS.czl()) {
                this.GTV.fFK();
                this.GTV.aN(false, this.GUf);
            }
        }
        this.GTW.adU(i2);
        if (this.kAn != null) {
            this.kAn.post(new Runnable() {
                /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass22 */

                public final void run() {
                    AppMethodBeat.i(114991);
                    if (VoipMgr.this.GTY != null) {
                        VoipMgr.this.GTY.jD(i2, VoipMgr.this.GTW.mState);
                    }
                    AppMethodBeat.o(114991);
                }
            });
        }
        switch (this.GTW.mState) {
            case CdnLogic.kAppTypeFestivalVideo:
            case 259:
                acP(5);
                AppMethodBeat.o(115023);
                return;
            case 262:
                acP(6);
                break;
        }
        AppMethodBeat.o(115023);
    }

    private boolean acO(int i2) {
        AppMethodBeat.i(115024);
        if (4111 == i2) {
            AppMethodBeat.o(115024);
            return true;
        } else if (4101 != i2 || (!k.adP(this.GTW.mState) && !this.GUf)) {
            AppMethodBeat.o(115024);
            return false;
        } else {
            AppMethodBeat.o(115024);
            return true;
        }
    }

    private static void acP(int i2) {
        AppMethodBeat.i(115025);
        aaq aaq = new aaq();
        aaq.ehD.dDe = i2;
        EventCenter.instance.publish(aaq);
        AppMethodBeat.o(115025);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void aUw(String str) {
        AppMethodBeat.i(235642);
        if (this.GTY != null) {
            this.GUy = str;
            this.GTY.aUB(str);
        }
        AppMethodBeat.o(235642);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void onError(int i2, String str) {
        String string;
        String str2;
        int i3;
        String str3;
        int i4;
        AppMethodBeat.i(115026);
        this.GTV.xq(this.GUg);
        if (i2 == 241 && Util.isNullOrNil(str)) {
            str = getContext().getString(R.string.i3y);
        }
        if (this.GTY != null) {
            this.GTY.cF(i2, str);
        }
        xN(4109);
        Log.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", Integer.valueOf(i2), Integer.valueOf(c.fFg().GYS.GSZ.GVV.roomId));
        Context context = MMApplicationContext.getContext();
        Log.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(i2)));
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
        if (c.fFg().GYS.GSZ.GVV.roomId != 0 && c.fFg().GYY.get(Integer.valueOf(c.fFg().GYS.GSZ.GVV.roomId)) == null) {
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
            c.fFg().GYY.put(Integer.valueOf(c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(s.a(str4, str3, i4, 6, string, true)));
        } else if (c.fFg().GYS.GSZ.GVV.roomId == 0) {
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
        c.fFg().fIl();
        fFP();
        AppMethodBeat.o(115026);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void dZK() {
        AppMethodBeat.i(115027);
        Log.i("MicroMsg.Voip.VoipMgr", "on accept");
        fFK();
        xN(4100);
        AppMethodBeat.o(115027);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void onReject() {
        AppMethodBeat.i(115028);
        Log.i("MicroMsg.Voip.VoipMgr", "onReject");
        xN(4099);
        s.c(this.GUe.field_username, this.GUg ? ca.OqC : ca.OqB, this.GUf ? 1 : 0, 6, MMApplicationContext.getContext().getString(R.string.i1g));
        fFP();
        AppMethodBeat.o(115028);
    }

    private void fFP() {
        AppMethodBeat.i(115029);
        Log.d("MicroMsg.Voip.VoipMgr", "delayFinish");
        this.GUy = null;
        if (this.kAn != null) {
            this.kAn.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(114964);
                    VoipMgr voipMgr = VoipMgr.this;
                    Log.i("MicroMsg.Voip.VoipMgr", "it is uninit voip report");
                    if (voipMgr.GUQ != null) {
                        voipMgr.GUQ.quit();
                        voipMgr.GUQ = null;
                    }
                    if (!voipMgr.GUN) {
                        if (voipMgr.GUW == 0) {
                            voipMgr.acM(voipMgr.GUM);
                        }
                        if (voipMgr.GUW != 0) {
                            voipMgr.GUN = true;
                            com.tencent.mm.plugin.voip.b.e.a(voipMgr.GUf ? 0 : 1, System.currentTimeMillis(), voipMgr.GUM, voipMgr.GUM, 0, 0, VoipMgr.mHZ / voipMgr.GUW);
                        }
                    }
                    VoipMgr.mHZ = 0;
                    VoipMgr.GUR[0] = 0;
                    VoipMgr.GUR[1] = 0;
                    voipMgr.GUW = 0;
                    if (voipMgr.qtS != null) {
                        TelephonyManager telephonyManager = voipMgr.qtS;
                        com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(voipMgr.GUP);
                        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/voip/model/VoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                        telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/voip/model/VoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                    }
                    if (voipMgr.GYh != null) {
                        MMApplicationContext.getContext().unregisterReceiver(voipMgr.GYh);
                        voipMgr.GYh = null;
                    }
                    VoipMgr.r(VoipMgr.this);
                    AppMethodBeat.o(114964);
                }
            }, 500);
        }
        AppMethodBeat.o(115029);
    }

    private void hb(boolean z) {
        AppMethodBeat.i(115030);
        Log.i("MicroMsg.Voip.VoipMgr", "finish");
        this.GUu = false;
        this.GUw = false;
        if (this.GYk != null) {
            if (this.GYl != null) {
                this.GYl.Z(false, (this.GUB & 1) != 0 ? 1 : 0);
                this.GYl.fJL();
            }
            this.GYk.fKp();
        }
        if (this.GYm != null) {
            this.GYm.removeCallbacksAndMessages(null);
            this.GYm = null;
        }
        if (this.GUm != -1) {
            h.INSTANCE.a(11700, Integer.valueOf(this.GUm), Long.valueOf(Util.secondsToNow(this.GUl)));
            this.GUm = -1;
        }
        try {
            MMApplicationContext.getContext().unregisterReceiver(this.GUV);
        } catch (Exception e2) {
        }
        this.GTV.fJP();
        EventCenter.instance.removeListener(this.yok);
        EventCenter.instance.removeListener(this.GUX);
        fHm();
        if (this.GTY != null) {
            this.GTY.uninit();
            this.GTY = null;
            this.GTV.b(this.GTY);
        }
        this.qsJ = null;
        if (c.fFg() != null) {
            if (z) {
                c.fFg().fHT();
            } else {
                c.fFg().GYS.fIx();
            }
            if (this.GUg) {
                c.fFg().d(false, true, this.goe);
            } else {
                c.fFg().d(false, false, this.goe);
            }
            c.fFg().b(MMApplicationContext.getContext(), this);
        }
        this.GTV.elB();
        c.fFg().fIi();
        c.fFg().adp(this.GUC);
        if (this.GUb) {
            this.GYa = new a();
            com.tencent.f.h.RTc.aX(this.GYa);
        } else {
            fFV();
        }
        if (!(this.yoi == null || this.mtH == null)) {
            TelephonyManager telephonyManager = this.yoi;
            com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(this.mtH);
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            this.mtH = null;
        }
        this.yoi = null;
        com.tencent.mm.booter.a.akp().akq();
        r.fHo().fHq();
        r.fHo().a(null);
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        c.fFg().fIl();
        Log.i("MicroMsg.Voip.VoipMgr", "finish, isFinishFromShutdown: %s", Boolean.valueOf(this.GUc));
        if (this.GUc && c.fFg().fIm()) {
            c.fFg();
            VoipScoreState.fHQ();
            Intent intent = new Intent(getContext(), VoipScoreDialog.class);
            intent.putExtra("key_score_state", c.fFg().fIo());
            if (!(getContext() instanceof Activity)) {
                intent.addFlags(268435456);
            }
            Context context = getContext();
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        c.fFg().fIn();
        fFQ();
        if (!this.GUI) {
            com.tencent.mm.plugin.voip.b.e.c(c.fFg().GYS.GSZ.GVV.roomId, c.fFg().GYS.GSZ.GVV.ypH, this.GUf ? 0 : 1, 4);
            this.GUI = true;
        }
        this.GYd = null;
        this.GYf = 0;
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        com.tencent.mm.media.g.c.igu.aMA();
        AppMethodBeat.o(115030);
    }

    private static void fFQ() {
        AppMethodBeat.i(235643);
        zj zjVar = new zj();
        zjVar.efx.dKy = 11;
        EventCenter.instance.publish(zjVar);
        AppMethodBeat.o(235643);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void fFR() {
        AppMethodBeat.i(115031);
        Log.i("MicroMsg.Voip.VoipMgr", "onNoResp");
        xN(4105);
        s.c(this.GUe.field_username, this.GUg ? ca.OqC : ca.OqB, this.GUf ? 1 : 0, 4, MMApplicationContext.getContext().getString(R.string.i1f));
        h.INSTANCE.a(11518, true, true, Integer.valueOf(c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(c.fFg().GYS.GSZ.fGu()), 6, Integer.valueOf(NetStatusUtil.getNetWorkType(getContext())));
        fFP();
        AppMethodBeat.o(115031);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void onConnected() {
        AppMethodBeat.i(115032);
        xN(4102);
        this.GUl = Util.nowSecond();
        if (this.GTY != null) {
            this.GTY.setConnectSec(this.GUl);
        }
        boolean fGw = c.fFg().GYS.GSZ.fGw();
        boolean fGv = c.fFg().GYS.GSZ.fGv();
        if (this.GUg && this.GUf && !fGv && !fGw) {
            c.fFg().adf(1);
        }
        if (!k.adQ(this.GTW.mState)) {
            h.INSTANCE.a(11080, 1, 0, 0);
        }
        Util.shake(MMApplicationContext.getContext(), true);
        c.fFg().adq(c.fFg().fIk());
        r.fHo().fHp();
        r.fHo().a(this);
        k kVar = k.GVq;
        k.setRoomId(c.fFg().GYS.GSZ.GVV.roomId);
        AppMethodBeat.o(115032);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void fFS() {
        int i2 = 0;
        AppMethodBeat.i(115033);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(c.fFg().GYS.GSZ.GVV.roomId);
        objArr[1] = Long.valueOf(c.fFg().GYS.GSZ.GVV.ypH);
        objArr[2] = Long.valueOf(c.fFg().GYS.GSZ.fGu());
        objArr[3] = Integer.valueOf(this.GUf ? 0 : 1);
        objArr[4] = 1;
        hVar.a(11522, true, true, objArr);
        int i3 = c.fFg().GYS.GSZ.GVV.roomId;
        long j2 = c.fFg().GYS.GSZ.GVV.ypH;
        if (!this.GUf) {
            i2 = 1;
        }
        com.tencent.mm.plugin.voip.b.e.c(i3, j2, i2, 3);
        if (this.GUQ != null) {
            this.GUQ.post(new Runnable() {
                /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(114965);
                    VoipMgr.a(VoipMgr.this, VoipMgr.this.GUM);
                    if (VoipMgr.this.GUQ != null) {
                        VoipMgr.this.GUQ.postDelayed(this, 5000);
                    }
                    AppMethodBeat.o(114965);
                }
            });
        }
        AppMethodBeat.o(115033);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void wW(boolean z) {
        String string;
        int i2 = 0;
        AppMethodBeat.i(235644);
        Log.i("MicroMsg.Voip.VoipMgr", "onShutDown");
        if (k.adP(this.GTW.mState)) {
            string = MMApplicationContext.getContext().getString(R.string.i1_, AF(Util.secondsToNow(this.GUl)));
        } else {
            string = MMApplicationContext.getContext().getString(R.string.i16);
        }
        if (this.GUf || k.adP(this.GTW.mState)) {
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
        c.fFg().fIl();
        if (!this.GUI) {
            int i3 = c.fFg().GYS.GSZ.GVV.roomId;
            long j2 = c.fFg().GYS.GSZ.GVV.ypH;
            if (!this.GUf) {
                i2 = 1;
            }
            com.tencent.mm.plugin.voip.b.e.c(i3, j2, i2, 4);
            this.GUI = true;
        }
        AppMethodBeat.o(235644);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void acQ(int i2) {
        AppMethodBeat.i(115035);
        Log.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", Integer.valueOf(i2));
        if ((1 == i2 || 3 == i2 || 5 == i2 || 6 == i2 || 7 == i2) && this.GUg) {
            xN(4101);
            c.fFg().GYS.GSZ.fGz();
            c.fFg().GYS.GSZ.fGA();
        }
        AppMethodBeat.o(115035);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void e(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(115036);
        if (this.GTY != null) {
            this.GTY.f(i2, i3, bArr);
        }
        AppMethodBeat.o(115036);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void setVoipBeauty(int i2) {
        AppMethodBeat.i(115037);
        Log.i("MicroMsg.Voip.VoipMgr", "setVoipBeauty, isON: " + i2 + "，mVoipUI: " + this.GTY);
        if (this.GTY != null) {
            this.GTY.setVoipBeauty(i2);
        }
        if (!(i2 == 0 || this.GUC == i2)) {
            h.INSTANCE.n(914, 20, 1);
        }
        this.GYj = 2;
        this.GUC = i2;
        AppMethodBeat.o(115037);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void setSpatiotemporalDenosing(int i2) {
        AppMethodBeat.i(235645);
        Log.i("MicroMsg.Voip.VoipMgr", "setSpatiotemporalDenosing, isON: " + i2 + "，mVoipUI: " + this.GTY);
        if (this.GTY != null) {
            this.GTY.setSpatiotemporalDenosing(i2);
        }
        if (!(i2 == 0 || this.GUD == i2)) {
            h.INSTANCE.n(914, 20, 1);
        }
        this.GYj = 2;
        this.GUD = i2;
        AppMethodBeat.o(235645);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void setHWDecMode(int i2) {
        AppMethodBeat.i(115038);
        this.GUB = i2;
        if (this.GTY != null) {
            this.GTY.setHWDecMode(i2);
        }
        if (this.GYk != null) {
            if (this.GYl != null) {
                this.GYl.Z(false, (i2 & 1) != 0 ? 1 : 0);
                this.GYl.fJK();
            }
            i iVar = this.GYk;
            if ((i2 & 1) != 0) {
                iVar.Hha++;
                AppMethodBeat.o(115038);
                return;
            }
            iVar.Hhb++;
        }
        AppMethodBeat.o(115038);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void jA(int i2, int i3) {
        AppMethodBeat.i(115039);
        Log.i("MicroMsg.Voip.VoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.GUK = i2;
        this.GUL = i3;
        if (this.GTY != null) {
            this.GTY.jA(i2, i3);
        }
        AppMethodBeat.o(115039);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void acR(int i2) {
        boolean z = false;
        AppMethodBeat.i(115040);
        Log.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(i2)));
        if (!this.GTW.adT(4110)) {
            AppMethodBeat.o(115040);
            return;
        }
        u fFg = c.fFg();
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
        AppMethodBeat.o(115040);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void acS(int i2) {
        boolean z = false;
        AppMethodBeat.i(115041);
        Log.i("MicroMsg.Voip.VoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(i2)));
        if (!this.GTW.adT(4100)) {
            AppMethodBeat.o(115041);
            return;
        }
        u fFg = c.fFg();
        boolean z2 = i2 == 1;
        if (i2 == 1) {
            z = true;
        }
        fFg.aH(z2, z);
        c.fFg().GYS.stopRing();
        if (i2 == 1 && k.adQ(this.GTW.mState)) {
            xN(4101);
        }
        xN(4100);
        AppMethodBeat.o(115041);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final void fFT() {
        AppMethodBeat.i(115042);
        Log.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
        this.GTV.aM(this.GUx, this.GUg);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(114966);
                    VoipMgr.t(VoipMgr.this);
                    AppMethodBeat.o(114966);
                }
            });
            AppMethodBeat.o(115042);
            return;
        }
        fHk();
        AppMethodBeat.o(115042);
    }

    private void fHk() {
        AppMethodBeat.i(115043);
        if (com.tencent.mm.compatible.util.d.oD(28) && this.GUg && this.GXZ != null && !this.GXZ.dEO() && this.GTY != null) {
            Log.i("MicroMsg.Voip.VoipMgr", "video call accept, not previewing, api level: %s", Integer.valueOf(Build.VERSION.SDK_INT));
            this.GXZ.eoc();
            this.GTY.fJj();
            int i2 = 320;
            int i3 = 240;
            if (this.GXZ == null && k.adQ(this.GTW.mState)) {
                this.qsJ = new CaptureView(MMApplicationContext.getContext());
                Log.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
                i2 = 640;
                i3 = 480;
            }
            this.GXZ = new com.tencent.mm.plugin.voip.video.camera.prev.a(i2, i3);
            this.GXZ.a((com.tencent.mm.plugin.voip.video.camera.a.b) this, true);
            this.GXZ.a(this.qsJ);
            this.GXZ.fLb();
            this.GYi = 0;
        }
        AppMethodBeat.o(115043);
    }

    @Override // com.tencent.mm.plugin.voip.model.x
    public final long fFU() {
        AppMethodBeat.i(115044);
        long j2 = this.GTV.Hgu;
        Log.printInfoStack("MicroMsg.Voip.VoipMgr", "totalDeviceNearTime: %s", Long.valueOf(j2));
        long j3 = j2 / 1000;
        AppMethodBeat.o(115044);
        return j3;
    }

    private static String AF(long j2) {
        AppMethodBeat.i(115045);
        String format = String.format("%02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60));
        AppMethodBeat.o(115045);
        return format;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5) {
        int i6;
        boolean z;
        boolean z2;
        final int i7;
        long j3;
        final int i8;
        final int i9;
        final ByteBuffer byteBuffer;
        final byte[] bArr2;
        int i10;
        ByteBuffer byteBuffer2;
        AppMethodBeat.i(115046);
        if (this.GYb) {
            AppMethodBeat.o(115046);
        } else if (this.GXZ == null) {
            Log.e("MicroMsg.Voip.VoipMgr", "onFrameDataReady, captureRender is null!");
            AppMethodBeat.o(115046);
        } else {
            int i11 = this.GXZ.fLp() ? OpenGlRender.FLAG_Mirror : 0;
            int i12 = this.GXZ.fKZ() ? OpenGlRender.FLAG_Angle270 : OpenGlRender.FLAG_Angle90;
            if (this.GTY != null) {
                boolean z3 = OpenGlRender.getGLVersion() == 2 && this.GUC != 0;
                boolean z4 = (this.GUC & 8) != 0;
                boolean z5 = OpenGlRender.getGLVersion() == 2 && (this.GUD & 1) != 0;
                if (!z3 && !z5) {
                    z2 = z5;
                    z = z3;
                    i6 = 0;
                } else if (!z4 && this.GTY.adw(2) != null) {
                    this.GYf = 0;
                    z2 = z5;
                    z = z3;
                    i6 = 1;
                } else if (z4 && this.GTY.adw(1) != null && this.GTY.adw(1).iEK != null) {
                    this.GYf = 0;
                    z2 = z5;
                    z = z3;
                    i6 = 2;
                } else if (z5 && this.GTY.fJk() != null) {
                    this.GYf = 0;
                    z2 = z5;
                    z = z3;
                    i6 = 0;
                } else if (this.GYd == null || this.GYf > 10) {
                    z2 = false;
                    z = false;
                    i6 = 0;
                } else {
                    this.GYf++;
                    z2 = z5;
                    z = z3;
                    i6 = 3;
                }
                if (!this.GXZ.fLp() || (!z && !z2)) {
                    i7 = i4 + i5;
                    this.GYn = false;
                    j3 = j2;
                    i8 = i3;
                    i9 = i2;
                    byteBuffer = null;
                    bArr2 = bArr;
                } else {
                    if (z2 && i6 == 0) {
                        ByteBuffer byteBuffer3 = this.GTY.fJk().HpD;
                        if (byteBuffer3 != null) {
                            j3 = (long) byteBuffer3.capacity();
                        } else {
                            j3 = j2;
                        }
                        this.GYe = byteBuffer3;
                        i10 = 4;
                        i8 = i3;
                        i9 = i2;
                        byteBuffer2 = byteBuffer3;
                    } else if (i6 == 1) {
                        ByteBuffer byteBuffer4 = this.GTY.adw(2).iEK;
                        if (byteBuffer4 != null) {
                            j3 = (long) byteBuffer4.capacity();
                        } else {
                            j3 = j2;
                        }
                        this.GYe = byteBuffer4;
                        i10 = 4;
                        i8 = i3;
                        i9 = i2;
                        byteBuffer2 = byteBuffer4;
                    } else if (i6 == 2) {
                        com.tencent.mm.plugin.voip.video.b.a adw = this.GTY.adw(1);
                        ByteBuffer byteBuffer5 = adw.iEK;
                        if (byteBuffer5 != null) {
                            j3 = (long) byteBuffer5.capacity();
                        } else {
                            j3 = j2;
                        }
                        i9 = adw.width;
                        int i13 = adw.height;
                        this.GYe = byteBuffer5;
                        i10 = 4;
                        i8 = i13;
                        byteBuffer2 = byteBuffer5;
                    } else {
                        ByteBuffer byteBuffer6 = this.GYe;
                        if (byteBuffer6 != null) {
                            j3 = (long) byteBuffer6.capacity();
                        } else {
                            j3 = j2;
                        }
                        this.GYe = byteBuffer6;
                        i10 = 4;
                        i8 = i3;
                        i9 = i2;
                        byteBuffer2 = byteBuffer6;
                    }
                    this.GYn = true;
                    i7 = i10;
                    byteBuffer = byteBuffer2;
                    bArr2 = null;
                }
                Log.d("MicroMsg.Voip.VoipMgr", "jcchen capture data: w=" + i2 + "h=" + i3 + ", vw=" + i9 + "vh=" + i8 + ", bm=" + i6 + ", skip:" + this.GYj);
                final int i14 = (int) j3;
                if (this.GYm != null) {
                    this.GYm.post(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass5 */

                        public final void run() {
                            AppMethodBeat.i(114967);
                            if (byteBuffer != null) {
                                c.fFg().c(byteBuffer, i14, i7, i9, i8, 0);
                                AppMethodBeat.o(114967);
                                return;
                            }
                            if (bArr2 != null) {
                                u fFg = c.fFg();
                                byte[] bArr = bArr2;
                                int i2 = i14;
                                int i3 = i7;
                                int i4 = i9;
                                int i5 = i8;
                                new Point(0, 0);
                                fFg.c(bArr, i2, i3, i4, i5);
                            }
                            AppMethodBeat.o(114967);
                        }
                    });
                }
                this.GTY.a(bArr, j2, i2, i3, i4 + i5, i11, i12);
                P(bArr2, i2, i3);
                this.GYi++;
            }
            this.GUq = i11 == OpenGlRender.FLAG_Mirror;
            this.GUr = i12 == OpenGlRender.FLAG_Angle270 ? 270 : 90;
            this.GUn.setPreviewSize(i2, i3);
            AppMethodBeat.o(115046);
        }
    }

    private void P(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(115047);
        if (this.GYi % 100 == 0) {
            if (bArr != null) {
                try {
                    if (bArr.length > 0) {
                        byte[] bArr2 = new byte[5];
                        int i4 = (i2 * 33) + 33;
                        int i5 = (i2 * 34) - 34;
                        int i6 = ((i2 * i3) / 2) + (i2 / 2);
                        int i7 = ((i3 - 34) * i2) + 33;
                        int i8 = (((i3 - 34) * i2) + i2) - 34;
                        if (i8 < bArr.length) {
                            bArr2[0] = bArr[i4];
                            bArr2[1] = bArr[i5];
                            bArr2[2] = bArr[i6];
                            bArr2[3] = bArr[i7];
                            bArr2[4] = bArr[i8];
                            Log.i("MicroMsg.Voip.VoipMgr", "onFrameDataReady, sample sendData:[%s, %s, %s, %s, %s], captureFrameCount:%s", Byte.valueOf(bArr2[0]), Byte.valueOf(bArr2[1]), Byte.valueOf(bArr2[2]), Byte.valueOf(bArr2[3]), Byte.valueOf(bArr2[4]), Integer.valueOf(this.GYi));
                            int i9 = 0;
                            for (int i10 = 0; i10 < 5; i10++) {
                                if (bArr2[i10] == 0) {
                                    i9++;
                                }
                            }
                            if (i9 >= 5) {
                                t tVar = t.GYO;
                                t.fHO();
                            }
                            AppMethodBeat.o(115047);
                            return;
                        }
                        Log.i("MicroMsg.Voip.VoipMgr", "sample check sendData error! %s", Integer.valueOf(bArr.length));
                        AppMethodBeat.o(115047);
                        return;
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Voip.VoipMgr", e2, "sampleCheckSendData error", new Object[0]);
                }
            }
            Log.i("MicroMsg.Voip.VoipMgr", "sample check sendData error is null or empty");
            AppMethodBeat.o(115047);
            return;
        }
        AppMethodBeat.o(115047);
    }

    private void fFV() {
        AppMethodBeat.i(115048);
        synchronized (this.GUd) {
            try {
                fHl();
                this.GTV.unInit();
                this.GTV.fFV();
            } finally {
                AppMethodBeat.o(115048);
            }
        }
    }

    private void fHl() {
        AppMethodBeat.i(115049);
        Log.printDebugStack("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
        if (this.GXZ != null) {
            fGb();
            try {
                this.GXZ.eoc();
            } catch (Exception e2) {
                Log.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + e2.toString());
            }
            this.GXZ = null;
        }
        AppMethodBeat.o(115049);
    }

    @Override // com.tencent.mm.plugin.voip.model.r.a
    public final void ql(boolean z) {
        int i2 = 2;
        AppMethodBeat.i(115050);
        Log.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
        if (this.GTY != null) {
            this.GTY.xi(z);
        }
        if (!k.adQ(this.GTW.mState) && !this.GTV.isSpeakerphoneOn()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.yqt > 30000) {
                this.yqt = currentTimeMillis;
                c.fFg().GYS.fIA();
            }
        }
        Log.i("MicroMsg.Voip.VoipMgr", "report the bad net toast room key is " + c.fFg().GYS.GSZ.GVV.ypH + "and in the side" + (z ? 1 : 2));
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(c.fFg().GYS.GSZ.GVV.ypH);
        if (z) {
            i2 = 1;
        }
        objArr[1] = Integer.valueOf(i2);
        hVar.a(17151, true, true, objArr);
        AppMethodBeat.o(115050);
    }

    @Override // com.tencent.mm.plugin.voip.model.r.a
    public final void dZQ() {
        AppMethodBeat.i(235646);
        Log.i("MicroMsg.Voip.VoipMgr", "onNetWorkChangeMobileNet");
        if (this.GTY != null) {
            this.GTY.fJn();
        }
        AppMethodBeat.o(235646);
    }

    @Override // com.tencent.mm.plugin.voip.model.r.a
    public final void dZR() {
        AppMethodBeat.i(115051);
        Log.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
        if (this.GTY != null) {
            this.GTY.ebH();
        }
        AppMethodBeat.o(115051);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(114992);
            VoipMgr.u(VoipMgr.this);
            VoipMgr.this.GYa = null;
            AppMethodBeat.o(114992);
        }
    }

    private boolean fFW() {
        AppMethodBeat.i(115052);
        if (k.adP(this.GTW.mState)) {
            SharedPreferences sharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
            if (!sharedPreferences.getBoolean("voip_shortcut_has_added", false)) {
                boolean c2 = c(sharedPreferences);
                AppMethodBeat.o(115052);
                return c2;
            }
        }
        AppMethodBeat.o(115052);
        return false;
    }

    private boolean c(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(115053);
        String value = com.tencent.mm.n.h.aqJ().getValue("VOIPShortcutAutoadd");
        Log.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", value);
        if (value != null && value.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && Util.secondsToNow(this.GUl) > 30) {
            int i2 = sharedPreferences.getInt("voip_shortcut_prompt_times", 0);
            boolean z = sharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
            if (i2 < 3 && !z) {
                fFX();
                sharedPreferences.edit().putInt("voip_shortcut_prompt_times", i2 + 1).commit();
                AppMethodBeat.o(115053);
                return true;
            }
        } else if (value != null && value.equals("1") && Util.secondsToNow(this.GUl) > 15) {
            d(sharedPreferences);
            AppMethodBeat.o(115053);
            return false;
        }
        AppMethodBeat.o(115053);
        return false;
    }

    private void d(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(115054);
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
        AppMethodBeat.o(115054);
    }

    private Context getContext() {
        AppMethodBeat.i(115055);
        Context context = null;
        if (this.GTY != null) {
            context = this.GTY.fJl();
        }
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        AppMethodBeat.o(115055);
        return context;
    }

    private void fFX() {
        AppMethodBeat.i(115056);
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
            /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(235617);
                VoipMgr.a(VoipMgr.this, VoipMgr.G(VoipMgr.this).getSharedPreferences("voip_plugin_prefs", 0));
                if (4096 != VoipMgr.this.GUi) {
                    VoipMgr.d(VoipMgr.this, VoipMgr.this.GUi);
                    VoipMgr.this.GUi = 4096;
                }
                if (VoipMgr.this.kAn != null) {
                    VoipMgr.this.kAn.post(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(114969);
                            VoipMgr.r(VoipMgr.this);
                            AppMethodBeat.o(114969);
                        }
                    });
                }
                AppMethodBeat.o(235617);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(114974);
                if (checkBox != null) {
                    VoipMgr.G(VoipMgr.this).getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", checkBox.isChecked()).commit();
                }
                if (4096 != VoipMgr.this.GUi) {
                    VoipMgr.d(VoipMgr.this, VoipMgr.this.GUi);
                    VoipMgr.this.GUi = 4096;
                }
                if (VoipMgr.this.kAn != null) {
                    VoipMgr.this.kAn.post(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(114973);
                            VoipMgr.r(VoipMgr.this);
                            AppMethodBeat.o(114973);
                        }
                    });
                }
                AppMethodBeat.o(114974);
            }
        });
        AppMethodBeat.o(115056);
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final boolean wX(final boolean z) {
        AppMethodBeat.i(115057);
        if (c.fFg().GZh) {
            Log.i("MicroMsg.Voip.VoipMgr", "current state is mini, cannot mini!");
            AppMethodBeat.o(115057);
            return false;
        } else if (!this.GUw || z) {
            Log.printDebugStack("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", Boolean.valueOf(z));
            Log.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
            if (this.GTY != null) {
                this.GTY.uninit();
                this.GTY = null;
                this.GTV.b(this.GTY);
            }
            if (this.GYc != null) {
                this.GYc.uninit();
            }
            if (this.kAn != null) {
                this.kAn.post(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass9 */

                    public final void run() {
                        AppMethodBeat.i(235618);
                        VoipMgr.e(VoipMgr.this, z);
                        AppMethodBeat.o(235618);
                    }
                });
            }
            AppMethodBeat.o(115057);
            return true;
        } else {
            Log.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
            AppMethodBeat.o(115057);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFY() {
        AppMethodBeat.i(115058);
        if (256 != this.GTW.mState && 257 != this.GTW.mState) {
            AppMethodBeat.o(115058);
        } else if (g.aAh().azQ().getInt(327945, 0) != 0 || this.GTY.fJl() == null) {
            m.hG(MMApplicationContext.getContext());
            fGa();
            AppMethodBeat.o(115058);
        } else {
            g.aAh().azQ().setInt(327945, 1);
            com.tencent.mm.ui.widget.a.d a2 = com.tencent.mm.ui.base.h.a(this.GTY.fJl(), (int) R.string.i2y, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(235619);
                    VoipMgr.this.fGa();
                    AppMethodBeat.o(235619);
                }
            });
            a2.setCancelable(false);
            a2.setCanceledOnTouchOutside(false);
            a2.show();
            AppMethodBeat.o(115058);
        }
    }

    @Override // com.tencent.mm.plugin.voip.ui.c
    public final void fFZ() {
        AppMethodBeat.i(115059);
        this.GUp = !this.GUp;
        if (this.GUp) {
            this.GUo.stopTimer();
            AppMethodBeat.o(115059);
            return;
        }
        if (this.GUo == null) {
            this.GUo = new MTimerHandler(com.tencent.mm.plugin.appbrand.jsapi.e.b.NAME, (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass13 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(235623);
                    VoipMgr.L(VoipMgr.this);
                    AppMethodBeat.o(235623);
                    return true;
                }
            }, true);
        }
        this.GUo.startTimer(2000);
        this.GUp = false;
        AppMethodBeat.o(115059);
    }

    public final void fGa() {
        AppMethodBeat.i(115060);
        c.fFg().GYZ = c.fFg().GYS.GSZ.GVV.roomId;
        s.c(this.GUe.field_username, this.GUg ? ca.OqC : ca.OqB, this.GUf ? 1 : 0, 6, MMApplicationContext.getContext().getString(R.string.i1b));
        fFK();
        xN(4108);
        if (this.kAn != null) {
            this.kAn.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass11 */

                public final void run() {
                    AppMethodBeat.i(235620);
                    VoipMgr.K(VoipMgr.this);
                    AppMethodBeat.o(235620);
                }
            }, 2000);
        }
        AppMethodBeat.o(115060);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void cza() {
        AppMethodBeat.i(115061);
        if (true == this.zuc || this.GTY == null || this.GTY.fJl() == null) {
            Log.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
            AppMethodBeat.o(115061);
        } else if (this.GXZ.dEO()) {
            AppMethodBeat.o(115061);
        } else if (Build.MANUFACTURER.equalsIgnoreCase("meizu") && !com.tencent.mm.compatible.e.b.apj() && com.tencent.mm.compatible.util.d.oE(29)) {
            Log.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
            AppMethodBeat.o(115061);
        } else if (!com.tencent.mm.compatible.util.d.oD(28) || !((KeyguardManager) MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            Log.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.GUg ? 0 : 1);
            objArr[1] = 0;
            hVar.a(11306, objArr);
            com.tencent.mm.ui.widget.a.d n = com.tencent.mm.ui.base.h.n(this.GTY.fJl(), R.string.i3p, R.string.zb);
            if (n == null) {
                Log.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
                AppMethodBeat.o(115061);
                return;
            }
            n.setCancelable(false);
            n.setCanceledOnTouchOutside(false);
            n.show();
            this.zuc = true;
            com.tencent.mm.plugin.voip.b.h.fKq();
            AppMethodBeat.o(115061);
        } else {
            Log.i("MicroMsg.Voip.VoipMgr", "api level: %s, in keyguard, ignore", Integer.valueOf(Build.VERSION.SDK_INT));
            AppMethodBeat.o(115061);
        }
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void fs(int i2, int i3) {
        AppMethodBeat.i(235647);
        Log.i("MicroMsg.Voip.VoipMgr", "camera preview size applye is $width and $height");
        AppMethodBeat.o(235647);
    }

    private void fGb() {
        AppMethodBeat.i(115062);
        if (this.GUn != null) {
            this.GUn.b(this);
        }
        if (this.GUo != null) {
            Log.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
            this.GUo.stopTimer();
        }
        AppMethodBeat.o(115062);
    }

    @Override // com.tencent.mm.plugin.voip.video.f.a
    public final void a(final int[] iArr, final boolean z, final int i2) {
        AppMethodBeat.i(115063);
        if (!this.GYg && this.GUg) {
            xc(true);
            this.GYg = true;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.voip.model.VoipMgr.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(235624);
                if (VoipMgr.this.GXZ != null) {
                    VoipMgr.this.GXZ.N(iArr);
                }
                if (VoipMgr.this.GTY != null) {
                    com.tencent.mm.plugin.voip.ui.b unused = VoipMgr.this.GTY;
                }
                AppMethodBeat.o(235624);
            }
        });
        AppMethodBeat.o(115063);
    }

    private void fGc() {
        AppMethodBeat.i(235648);
        this.GUx = true;
        if (this.GUx && this.GUk == 2) {
            getContext();
            hXE();
        }
        AppMethodBeat.o(235648);
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

    private void fHm() {
        AppMethodBeat.i(235649);
        Log.i("MicroMsg.Voip.VoipMgr", "uninitSurfaceTexture!");
        if (this.GTY != null) {
            this.GTY.releaseSurfaceTexture();
        }
        AppMethodBeat.o(235649);
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(115064);
        if (this.GTY != null) {
            this.GTY.requestRender();
        }
        AppMethodBeat.o(115064);
    }

    static /* synthetic */ void r(VoipMgr voipMgr) {
        AppMethodBeat.i(235651);
        voipMgr.hb(false);
        AppMethodBeat.o(235651);
    }

    static /* synthetic */ void e(VoipMgr voipMgr, boolean z) {
        AppMethodBeat.i(235659);
        Log.printInfoStack("MicroMsg.Voip.VoipMgr", "do minimizeVoip", new Object[0]);
        if (2 == voipMgr.mUIType && Build.VERSION.SDK_INT < 24) {
            Log.e("MicroMsg.Voip.VoipMgr", "already is widget");
            AppMethodBeat.o(235659);
        } else if (262 == voipMgr.GTW.mState || 8 == voipMgr.GTW.mState) {
            Log.e("MicroMsg.Voip.VoipMgr", "voip call has finished!，state is %s", Integer.valueOf(voipMgr.GTW.mState));
            AppMethodBeat.o(235659);
        } else {
            voipMgr.mUIType = 2;
            voipMgr.GUm++;
            voipMgr.GYc = new d(voipMgr, voipMgr.GTW.mState, voipMgr.GUe, voipMgr.GUg, voipMgr.GUf, z);
            if ((260 == voipMgr.GTW.mState || 6 == voipMgr.GTW.mState) && 1 != g.aAh().azQ().getInt(327948, 0)) {
                g.aAh().azQ().setInt(327948, 1);
            }
            voipMgr.fFK();
            c.fFg().aG(true, z);
            AppMethodBeat.o(235659);
        }
    }

    static /* synthetic */ void L(VoipMgr voipMgr) {
        AppMethodBeat.i(235661);
        if (k.adP(voipMgr.GTW.mState)) {
            voipMgr.GUn.Hjo = voipMgr.GUq;
            voipMgr.GUn.HhG = voipMgr.GUr;
            voipMgr.GUn.xx(voipMgr.GUs);
        }
        AppMethodBeat.o(235661);
    }
}
