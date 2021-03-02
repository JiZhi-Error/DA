package com.tencent.mm.plugin.voip.widget;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Process;
import android.support.v4.app.s;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.f.h;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.ui.b;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.b.a;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.video.d.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class d implements ServiceConnection, b {
    private int GUC = 0;
    private int GUD = 0;
    private int GUK = 0;
    private int GUL = 0;
    private as GUe;
    private boolean GUf;
    public boolean GUg;
    private int GUk = 1;
    private long GUl = -1;
    private boolean GZi = false;
    private int HdK;
    a HkR;
    private c HpU;
    BaseSmallView HpV;
    private MTimerHandler HpW;
    private boolean HpX = false;
    private long HpY = -1;
    private boolean HpZ = false;
    private boolean Hqa = false;
    private View.OnClickListener Hqc = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.widget.d.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(115796);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/widget/VoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (d.this.HpV != null) {
                d.this.HpV.setOnClickListener(null);
            }
            d dVar = d.this;
            if (dVar.HpV != null) {
                dVar.HpV.fJx();
            }
            Intent intent = new Intent(MMApplicationContext.getContext(), VideoActivity.class);
            intent.setFlags(268435456);
            com.tencent.mm.plugin.voip.b.d dVar2 = com.tencent.mm.plugin.voip.b.d.HgU;
            com.tencent.mm.plugin.voip.b.d.fJW();
            try {
                PendingIntent.getActivity(MMApplicationContext.getContext(), 0, intent, 0).send();
            } catch (PendingIntent.CanceledException e2) {
                Log.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", e2, "send pending intent error: %s", e2.getMessage());
            }
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.voip.widget.d.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(184103);
                    d.b(d.this);
                    AppMethodBeat.o(184103);
                }
            }, 200);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/widget/VoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(115796);
        }
    };
    private int Hqd = -1;
    boolean Hqe = false;
    com.tencent.mm.plugin.voip.video.d.b Hqw;
    private PowerManager.WakeLock hCN;
    private int mStatus = -1;
    private CaptureView qsJ;

    static /* synthetic */ void b(d dVar) {
        AppMethodBeat.i(115833);
        dVar.xB(false);
        AppMethodBeat.o(115833);
    }

    static /* synthetic */ void g(d dVar) {
        AppMethodBeat.i(184115);
        dVar.fMk();
        AppMethodBeat.o(184115);
    }

    public d(c cVar, int i2, as asVar, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(115802);
        Log.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", k.adM(i2), asVar.field_username, Boolean.valueOf(z));
        this.GUe = asVar;
        this.HpU = cVar;
        this.GUg = z;
        this.GUf = z2;
        this.GZi = z3;
        jD(0, i2);
        this.hCN = ((PowerManager) MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
        this.hCN.acquire();
        t tVar = t.GYO;
        t.fHJ();
        AppMethodBeat.o(115802);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setVoicePlayDevice(int i2) {
        AppMethodBeat.i(184108);
        if (this.HpU != null) {
            this.HpU.setVoicePlayDevice(i2);
        }
        if (!(this.Hqd == -1 || this.Hqd == i2)) {
            com.tencent.mm.plugin.voip.c.fFh().setVoicePlayDevice(i2);
        }
        this.Hqd = i2;
        AppMethodBeat.o(184108);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setMute(boolean z) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void jD(int i2, int i3) {
        AppMethodBeat.i(115803);
        Log.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", k.adM(i3));
        if (i3 == this.mStatus) {
            Log.i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
            AppMethodBeat.o(115803);
            return;
        }
        this.mStatus = i3;
        switch (i3) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 256:
            case CdnLogic.kAppTypeFestivalVideo:
            case 260:
                fMh();
                if (!this.HpZ) {
                    fJt();
                    AppMethodBeat.o(115803);
                    return;
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case CdnLogic.kAppTypeFestivalImage:
            case 259:
            case 261:
                fMh();
                if (!this.Hqa) {
                    aeg(i2);
                    break;
                }
                break;
            case 8:
            case 262:
                aef(i2);
                AppMethodBeat.o(115803);
                return;
        }
        AppMethodBeat.o(115803);
    }

    private void aef(int i2) {
        AppMethodBeat.i(115804);
        switch (i2) {
            case 4099:
                MMApplicationContext.getContext();
                break;
            case 4105:
                MMApplicationContext.getContext();
                break;
            case 4106:
                MMApplicationContext.getContext();
                break;
        }
        releaseSurfaceTexture();
        xB(true);
        AppMethodBeat.o(115804);
    }

    private void fJt() {
        AppMethodBeat.i(115806);
        Log.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
        this.HpZ = true;
        if (-1 == this.HpY) {
            this.HpY = System.currentTimeMillis();
        }
        if (this.HpU != null) {
            this.HpU.a(this, 2);
            this.HpU.fFC();
        }
        String string = MMApplicationContext.getContext().getString(R.string.i4q);
        aX(string, aa.getDisplayName(this.GUe.field_username), string);
        fMj();
        this.HpV = com.tencent.mm.plugin.voip.c.fFh().aJ(true, false);
        fMk();
        AppMethodBeat.o(115806);
    }

    private void aeg(int i2) {
        AppMethodBeat.i(115809);
        Log.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
        this.Hqa = true;
        if (-1 == this.HpY) {
            this.HpY = System.currentTimeMillis();
        }
        if (2 == this.GUk) {
            MMApplicationContext.getContext();
        }
        if (this.HpU != null) {
            this.HpU.a(this, 2);
        }
        String fMl = fMl();
        aX(fMl, aa.getDisplayName(this.GUe.field_username), fMl);
        fMj();
        this.HpV = com.tencent.mm.plugin.voip.c.fFh().aJ(false, this.HpZ);
        if (this.HpZ) {
            a.C1887a.GST.fFl();
        }
        if (4101 == i2) {
            MMApplicationContext.getContext();
        }
        AppMethodBeat.o(115809);
    }

    public final String fMi() {
        String format;
        AppMethodBeat.i(115810);
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.GUl);
        if (this.GUl == -1) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 3600) {
            format = String.format(Locale.US, "%d:%02d:%02d", Integer.valueOf(currentTimeMillis / LocalCache.TIME_HOUR), Integer.valueOf((currentTimeMillis % LocalCache.TIME_HOUR) / 60), Integer.valueOf(currentTimeMillis % 60));
        } else if (currentTimeMillis >= 600) {
            format = String.format(Locale.US, "%d:%02d", Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60));
        } else {
            format = String.format(Locale.US, "%02d:%02d", Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60));
        }
        if (Util.isNullOrNil(format)) {
            format = "00:00";
        }
        AppMethodBeat.o(115810);
        return format;
    }

    private void fMh() {
        AppMethodBeat.i(184109);
        if (this.mStatus == 261 || this.mStatus == 7 || this.mStatus == 260 || this.mStatus == 6) {
            this.Hqe = true;
            if (this.HpW != null) {
                this.HpW.stopTimer();
            }
            this.HpW = new MTimerHandler("timerCounter", (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.voip.widget.d.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(184105);
                    h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.widget.d.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(184104);
                            com.tencent.mm.plugin.voip.c.fFh().aGy(d.this.fMi());
                            AppMethodBeat.o(184104);
                        }
                    });
                    AppMethodBeat.o(184105);
                    return true;
                }
            }, true);
            this.HpW.startTimer(1000);
        }
        AppMethodBeat.o(184109);
    }

    private void fMj() {
        AppMethodBeat.i(115811);
        Log.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
        Intent intent = new Intent();
        intent.setClass(MMApplicationContext.getContext(), VideoActivity.class);
        intent.putExtra("Voip_Call_From", 3);
        intent.putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.fFg().fHV());
        intent.setFlags(268435456);
        intent.putExtra("Voip_User", this.GUe.field_username);
        intent.putExtra("Voip_Outcall", this.GUf);
        intent.putExtra("Voip_VideoCall", this.GUg);
        intent.putExtra("Voip_Is_Talking", this.Hqe);
        com.tencent.mm.plugin.voip.c.fFh().a(intent, this.GUg, new com.tencent.mm.plugin.voip.ui.a() {
            /* class com.tencent.mm.plugin.voip.widget.d.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.voip.ui.a
            public final boolean dZV() {
                AppMethodBeat.i(184106);
                if (d.this.GUg) {
                    String string = MMApplicationContext.getContext().getString(R.string.i4q);
                    d.this.aX(string, aa.getDisplayName(d.this.GUe.field_username), string);
                    if (k.adR(d.this.mStatus) || k.adP(d.this.mStatus)) {
                        d.this.HpX = true;
                        AppMethodBeat.o(184106);
                        return true;
                    }
                    ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
                    d.b(d.this);
                    AppMethodBeat.o(184106);
                    return false;
                } else if (k.adR(d.this.mStatus) || k.adP(d.this.mStatus)) {
                    AppMethodBeat.o(184106);
                    return true;
                } else {
                    AppMethodBeat.o(184106);
                    return false;
                }
            }

            @Override // com.tencent.mm.plugin.voip.ui.a
            public final void a(Intent intent, BaseSmallView baseSmallView) {
                AppMethodBeat.i(184107);
                if (intent.getBooleanExtra("Voip_Is_Talking", false)) {
                    com.tencent.mm.plugin.voip.c.fFh().aGy(d.this.fMi());
                } else {
                    com.tencent.mm.plugin.voip.c.fFh().aGx(MMApplicationContext.getContext().getString(R.string.i3e));
                }
                if (d.this.GUg && d.this.HpX) {
                    d.this.HpX = false;
                    d.this.HpV = baseSmallView;
                    d.g(d.this);
                }
                AppMethodBeat.o(184107);
            }
        });
        if (!com.tencent.mm.plugin.voip.c.fFg().GZe) {
            com.tencent.mm.plugin.voip.c.fFg().GZe = true;
            if (System.currentTimeMillis() - g.aAh().azQ().akg(327950) > Util.MILLSECONDS_OF_DAY) {
                Lj("have not permission to showing floating window\n");
            }
        }
        AppMethodBeat.o(115811);
    }

    private void fMk() {
        AppMethodBeat.i(184110);
        Log.i("MicroMsg.Voip.VoipSmallWindow", "setVideoTalkingView");
        if (this.HpV != null) {
            this.HpV.setStatus(this.mStatus);
            this.HpV.setConnectSec(this.GUl);
            this.HpV.setVoipUIListener(this.HpU);
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.plugin.voip.c.fFg();
            u.xg(true);
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
            this.HpV.fMf();
            this.HpV.setOnClickListener(this.Hqc);
            Log.i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
            fMn();
            Log.i("MicroMsg.Voip.VoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", Integer.valueOf(this.HdK), Integer.valueOf(this.GUC));
            setHWDecMode(this.HdK);
            setVoipBeauty(this.GUC);
            setSpatiotemporalDenosing(this.GUD);
            if (!(this.GUK == 0 || this.GUL == 0)) {
                jA(this.GUK, this.GUL);
            }
        }
        AppMethodBeat.o(184110);
    }

    private static String fMl() {
        AppMethodBeat.i(115812);
        String string = MMApplicationContext.getContext().getString(R.string.i4y);
        AppMethodBeat.o(115812);
        return string;
    }

    public final void aX(String str, String str2, String str3) {
        AppMethodBeat.i(184111);
        Log.i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + str + ",title:" + str2 + ",content:" + str3 + ",breathEffect:false");
        Log.printDebugStack("MicroMsg.Voip.VoipSmallWindow", "breathEffect false", new Object[0]);
        Intent intent = new Intent();
        intent.setClass(MMApplicationContext.getContext(), VideoActivity.class);
        intent.putExtra("Voip_Call_From", 3);
        intent.putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.fFg().fHV());
        intent.putExtra("Voip_User", this.GUe.field_username);
        intent.putExtra("Voip_Outcall", this.GUf);
        intent.putExtra("Voip_VideoCall", this.GUg);
        PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), 40, intent, 134217728);
        s.c g2 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(str).i(System.currentTimeMillis()).f(str2).g(str3);
        g2.Hv = activity;
        s.c as = g2.as(ezb());
        as.g(2, true);
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, m.e(as), false);
        AppMethodBeat.o(184111);
    }

    private static int ezb() {
        if (Build.VERSION.SDK_INT < 19) {
            return R.drawable.cj7;
        }
        return R.drawable.cj8;
    }

    private void fMn() {
        AppMethodBeat.i(184112);
        Log.i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
        if (k.adR(this.mStatus) || k.adP(this.mStatus) || k.adS(this.mStatus)) {
            ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
            if (this.qsJ != null) {
                if (this.qsJ.getParent() != null && (this.qsJ.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.qsJ.getParent()).removeView(this.qsJ);
                }
                this.HpV.setCaptureView(this.qsJ);
            }
            this.HpV.setTag(Integer.valueOf(this.mStatus));
            AppMethodBeat.o(184112);
            return;
        }
        Log.i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
        AppMethodBeat.o(184112);
    }

    private void xB(boolean z) {
        AppMethodBeat.i(115816);
        Log.i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView isFinish: %b", Boolean.valueOf(z));
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        if (this.HpW != null) {
            this.HpW.stopTimer();
        }
        if (z) {
            com.tencent.mm.plugin.voip.c.fFh().eoN();
        } else {
            com.tencent.mm.plugin.voip.c.fFh().rX(false);
        }
        if (this.HpV != null && !z) {
            this.HpV.uninit();
            if (this.HpV.getParent() != null) {
                ((ViewGroup) this.HpV.getParent()).removeAllViews();
            }
            this.HpV = null;
        }
        AppMethodBeat.o(115816);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void cF(int i2, String str) {
        char c2;
        AppMethodBeat.i(115817);
        if (i2 == 241) {
            MMApplicationContext.getContext();
        }
        Log.d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode ".concat(String.valueOf(i2)));
        if (i2 == 235) {
            c2 = 12284;
        } else if (i2 == 233) {
            com.tencent.mm.plugin.voip.c.fFg().fHY();
            c2 = 12283;
        } else if (i2 == 237) {
            if (!com.tencent.mm.aw.b.isOverseasUser() || this.GUg) {
                c2 = 12285;
            } else {
                c2 = 12287;
            }
        } else if (i2 == 236) {
            c2 = 12301;
        } else if (i2 == 211) {
            c2 = 12286;
        } else {
            c2 = 0;
        }
        if (c2 == 0) {
            MMApplicationContext.getContext();
            AppMethodBeat.o(115817);
            return;
        }
        MMApplicationContext.getContext();
        AppMethodBeat.o(115817);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void aUB(String str) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void f(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(115818);
        if (260 == this.mStatus || 6 == this.mStatus) {
            if (this.HpV != null) {
                this.HpV.f(i2, i3, bArr);
            }
            AppMethodBeat.o(115818);
            return;
        }
        AppMethodBeat.o(115818);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setVoipBeauty(int i2) {
        AppMethodBeat.i(115819);
        if (this.HpV != null) {
            this.HpV.setVoipBeauty(i2);
        }
        this.GUC = i2;
        AppMethodBeat.o(115819);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setSpatiotemporalDenosing(int i2) {
        AppMethodBeat.i(235978);
        if (this.HpV != null) {
            this.HpV.setSpatiotemporalDenosing(i2);
        }
        this.GUC = i2;
        AppMethodBeat.o(235978);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void jA(int i2, int i3) {
        AppMethodBeat.i(115820);
        this.GUK = i2;
        this.GUL = i3;
        if (this.HpV != null) {
            this.HpV.jA(i2, i3);
        }
        AppMethodBeat.o(115820);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setHWDecMode(int i2) {
        AppMethodBeat.i(115821);
        if (this.HpV != null) {
            this.HpV.setHWDecMode(i2);
        }
        this.HdK = i2;
        AppMethodBeat.o(115821);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void a(SurfaceTexture surfaceTexture, com.tencent.mm.media.g.d dVar) {
        AppMethodBeat.i(115822);
        if (this.HpV != null) {
            this.HpV.a(surfaceTexture, dVar);
        }
        AppMethodBeat.o(115822);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void requestRender() {
        AppMethodBeat.i(115823);
        if (this.HpV != null) {
            this.HpV.requestRender();
        }
        AppMethodBeat.o(115823);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void releaseSurfaceTexture() {
        AppMethodBeat.i(115824);
        if (this.HpV != null) {
            this.HpV.releaseSurfaceTexture();
        }
        AppMethodBeat.o(115824);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setScreenEnable(boolean z) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void fJm() {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void adx(int i2) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void ady(int i2) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void adz(int i2) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(235979);
        if (this.HpV != null) {
            this.HpV.a(bArr, j2, i2, i3, i4, i5, i6);
        }
        AppMethodBeat.o(235979);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final Context fJl() {
        return null;
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void uninit() {
        int i2 = 3;
        AppMethodBeat.i(115826);
        Log.i("MicroMsg.Voip.VoipSmallWindow", "uninit");
        if (-1 != this.HpY) {
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[3];
            if (this.HpZ) {
                i2 = 2;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Long.valueOf((System.currentTimeMillis() - this.HpY) / 1000);
            objArr[2] = Integer.valueOf(this.GZi ? 1 : 2);
            hVar.a(11620, objArr);
        }
        if (this.hCN != null && this.hCN.isHeld()) {
            Log.i("MicroMsg.Voip.VoipSmallWindow", "release waklock");
            this.hCN.release();
        }
        xB(false);
        if (this.HpW != null) {
            this.HpW.stopTimer();
        }
        Log.i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
        this.qsJ = null;
        t tVar = t.GYO;
        t.fHK();
        AppMethodBeat.o(115826);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setConnectSec(long j2) {
        AppMethodBeat.i(115827);
        this.GUl = j2;
        if (this.HpV != null) {
            this.HpV.setConnectSec(j2);
            AppMethodBeat.o(115827);
            return;
        }
        if (261 == this.mStatus || 7 == this.mStatus) {
            String fMl = fMl();
            aX(fMl, aa.getDisplayName(this.GUe.field_username), fMl);
        }
        AppMethodBeat.o(115827);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void xi(boolean z) {
        AppMethodBeat.i(115828);
        com.tencent.mm.plugin.voip.c.fFh().xm(true);
        AppMethodBeat.o(115828);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void fJn() {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void fFL() {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void enR() {
        AppMethodBeat.i(184113);
        com.tencent.mm.plugin.voip.c.fFh().enR();
        AppMethodBeat.o(184113);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void ebH() {
        AppMethodBeat.i(184114);
        com.tencent.mm.plugin.voip.c.fFh().xm(false);
        AppMethodBeat.o(184114);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setCaptureView(CaptureView captureView) {
        AppMethodBeat.i(235980);
        this.qsJ = captureView;
        if (!(this.HpV == null || this.qsJ == null)) {
            if (this.qsJ.getParent() != null && (this.qsJ.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.qsJ.getParent()).removeView(this.qsJ);
            }
            this.HpV.setCaptureView(captureView);
        }
        AppMethodBeat.o(235980);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void fJj() {
    }

    private static void Lj(String str) {
        AppMethodBeat.i(115830);
        g.aAh().azQ().setLong(327950, System.currentTimeMillis());
        Log.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + str.length());
        StringBuilder sb = new StringBuilder();
        sb.append("\n#client.version=").append(com.tencent.mm.protocal.d.KyO).append("\n");
        sb.append("#accinfo.revision=").append(BuildInfo.REV).append("\n");
        sb.append("#accinfo.build=").append(BuildInfo.TIME).append(":").append(BuildInfo.HOSTNAME).append(":").append(ChannelUtil.channelId).append("\n");
        Date date = new Date();
        sb.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append("\n");
        sb.append("#accinfo.content:\n");
        Intent intent = new Intent();
        intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionWriteSdcard", false);
        intent.putExtra("exceptionPid", Process.myPid());
        intent.putExtra("userName", Wv());
        intent.putExtra("tag", "float_window_permission");
        intent.putExtra("exceptionMsg", Base64.encodeToString((sb.toString() + str).getBytes(), 2));
        MMApplicationContext.getContext().sendBroadcast(intent);
        AppMethodBeat.o(115830);
    }

    private static String Wv() {
        AppMethodBeat.i(115831);
        String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
        if (Util.isNullOrNil(aA)) {
            aA = bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "never_login_crash");
        }
        AppMethodBeat.o(115831);
        return aA;
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final com.tencent.mm.plugin.voip.video.b.a adw(int i2) {
        AppMethodBeat.i(115832);
        if (!(this.HpV == null || this.HpV.getBeautyData() == null)) {
            this.HpV.getBeautyData().a(i2, new a.b() {
                /* class com.tencent.mm.plugin.voip.widget.d.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.voip.video.b.a.b
                public final void a(com.tencent.mm.plugin.voip.video.b.a aVar) {
                    if (aVar != null) {
                        d.this.HkR = aVar;
                    }
                }
            });
        }
        com.tencent.mm.plugin.voip.video.b.a aVar = this.HkR;
        AppMethodBeat.o(115832);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final com.tencent.mm.plugin.voip.video.d.b fJk() {
        AppMethodBeat.i(235981);
        if (!(this.HpV == null || this.HpV.getSpatioTemporalFilterData() == null)) {
            this.HpV.getSpatioTemporalFilterData().a(new b.AbstractC1893b() {
                /* class com.tencent.mm.plugin.voip.widget.d.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.voip.video.d.b.AbstractC1893b
                public final void a(com.tencent.mm.plugin.voip.video.d.b bVar) {
                    if (bVar != null) {
                        d.this.Hqw = bVar;
                    }
                }
            });
        }
        com.tencent.mm.plugin.voip.video.d.b bVar = this.Hqw;
        AppMethodBeat.o(235981);
        return bVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
