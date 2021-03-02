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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
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

public final class b implements ServiceConnection, com.tencent.mm.plugin.voip.ui.b {
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
    private c HpU;
    private BaseSmallView HpV;
    private MTimerHandler HpW;
    private boolean HpX = false;
    private long HpY = -1;
    private boolean HpZ = false;
    private boolean Hqa = false;
    private boolean Hqb = false;
    private View.OnClickListener Hqc = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.widget.b.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(235934);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b.this.HpU.fFJ();
            if (b.this.HpV != null) {
                b.this.HpV.setOnClickListener(null);
            }
            Intent intent = new Intent(MMApplicationContext.getContext(), VideoActivity.class);
            intent.putExtra("Voip_Call_From", 3);
            d dVar = d.HgU;
            d.fJW();
            intent.setFlags(268435456);
            try {
                PendingIntent.getActivity(MMApplicationContext.getContext(), 0, intent, 0).send();
            } catch (PendingIntent.CanceledException e2) {
                Log.printErrStackTrace("MicroMsg.Voip.NewVoipSmallWindow", e2, "send pending intent error: %s", e2.getMessage());
            }
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.voip.widget.b.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(235933);
                    b.c(b.this);
                    AppMethodBeat.o(235933);
                }
            }, 200);
            a.a(this, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235934);
        }
    };
    private int Hqd = -1;
    boolean Hqe = false;
    private PowerManager.WakeLock hCN;
    private int mStatus = -1;
    private boolean zMU = false;

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(235961);
        bVar.xB(false);
        AppMethodBeat.o(235961);
    }

    static /* synthetic */ void h(b bVar) {
        AppMethodBeat.i(235962);
        bVar.fMk();
        AppMethodBeat.o(235962);
    }

    public b(c cVar, int i2, as asVar, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(235939);
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", k.adM(i2), asVar.field_username, Boolean.valueOf(z));
        this.GUe = asVar;
        this.HpU = cVar;
        this.GUg = z;
        this.GUf = z2;
        this.GZi = z3;
        jD(0, i2);
        this.hCN = ((PowerManager) MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.NewVoipSmallWindow");
        this.hCN.acquire();
        t tVar = t.GYO;
        t.fHJ();
        AppMethodBeat.o(235939);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setVoicePlayDevice(int i2) {
        AppMethodBeat.i(235940);
        if (!(this.Hqd == -1 || this.Hqd == i2)) {
            com.tencent.mm.plugin.voip.c.fFh().setVoicePlayDevice(i2);
        }
        this.Hqd = i2;
        AppMethodBeat.o(235940);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setMute(boolean z) {
    }

    private void fMh() {
        AppMethodBeat.i(235941);
        if (this.mStatus == 261 || this.mStatus == 7 || this.mStatus == 260 || this.mStatus == 6) {
            this.Hqe = true;
            if (this.HpW != null) {
                this.HpW.stopTimer();
            }
            this.HpW = new MTimerHandler("timerCounter", (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.voip.widget.b.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(235936);
                    h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.widget.b.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(235935);
                            com.tencent.mm.plugin.voip.c.fFh().aGy(b.this.fMi());
                            AppMethodBeat.o(235935);
                        }
                    });
                    AppMethodBeat.o(235936);
                    return true;
                }
            }, true);
            this.HpW.startTimer(1000);
        }
        AppMethodBeat.o(235941);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void jD(int i2, int i3) {
        AppMethodBeat.i(235942);
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "newState: %s ", k.adM(i3));
        if (i3 == this.mStatus) {
            Log.i("MicroMsg.Voip.NewVoipSmallWindow", "state unchange");
            AppMethodBeat.o(235942);
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
                    AppMethodBeat.o(235942);
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
                AppMethodBeat.o(235942);
                return;
        }
        AppMethodBeat.o(235942);
    }

    private void aef(int i2) {
        AppMethodBeat.i(235943);
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
        xB(true);
        AppMethodBeat.o(235943);
    }

    private void fJt() {
        AppMethodBeat.i(235944);
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showVideoTalking");
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
        AppMethodBeat.o(235944);
    }

    private void aeg(int i2) {
        AppMethodBeat.i(235945);
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showVoiceTalking");
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
        AppMethodBeat.o(235945);
    }

    public final String fMi() {
        String format;
        AppMethodBeat.i(235946);
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
        AppMethodBeat.o(235946);
        return format;
    }

    private void fMj() {
        AppMethodBeat.i(235947);
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showMini");
        Intent intent = new Intent();
        intent.setClass(MMApplicationContext.getContext(), VideoActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("Voip_User", this.GUe.field_username);
        intent.putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.fFg().fHV());
        intent.putExtra("Voip_Outcall", this.GUf);
        intent.putExtra("Voip_VideoCall", this.GUg);
        intent.putExtra("Voip_Is_Talking", this.Hqe);
        com.tencent.mm.plugin.voip.c.fFh().a(intent, this.GUg, new com.tencent.mm.plugin.voip.ui.a() {
            /* class com.tencent.mm.plugin.voip.widget.b.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.voip.ui.a
            public final boolean dZV() {
                AppMethodBeat.i(235937);
                if (b.this.GUg) {
                    String string = MMApplicationContext.getContext().getString(R.string.i4q);
                    b.this.aX(string, aa.getDisplayName(b.this.GUe.field_username), string);
                    if (k.adR(b.this.mStatus) || k.adP(b.this.mStatus)) {
                        b.this.HpX = true;
                        AppMethodBeat.o(235937);
                        return true;
                    }
                    ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
                    b.c(b.this);
                    AppMethodBeat.o(235937);
                    return false;
                } else if (k.adR(b.this.mStatus) || k.adP(b.this.mStatus)) {
                    AppMethodBeat.o(235937);
                    return true;
                } else {
                    AppMethodBeat.o(235937);
                    return false;
                }
            }

            @Override // com.tencent.mm.plugin.voip.ui.a
            public final void a(Intent intent, BaseSmallView baseSmallView) {
                AppMethodBeat.i(235938);
                if (intent.getBooleanExtra("Voip_Is_Talking", false)) {
                    com.tencent.mm.plugin.voip.c.fFh().aGy(b.this.fMi());
                } else {
                    com.tencent.mm.plugin.voip.c.fFh().aGx(MMApplicationContext.getContext().getString(R.string.i3e));
                }
                if (b.this.GUg && b.this.HpX) {
                    b.this.HpX = false;
                    b.this.HpV = baseSmallView;
                    b.h(b.this);
                }
                AppMethodBeat.o(235938);
            }
        });
        if (!com.tencent.mm.plugin.voip.c.fFg().GZe) {
            com.tencent.mm.plugin.voip.c.fFg().GZe = true;
            if (System.currentTimeMillis() - g.aAh().azQ().akg(327950) > Util.MILLSECONDS_OF_DAY) {
                Lj("have not permission to showing floating window\n");
            }
        }
        AppMethodBeat.o(235947);
    }

    private void fMk() {
        AppMethodBeat.i(235948);
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "setVideoTalkingView");
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
            Log.i("MicroMsg.Voip.NewVoipSmallWindow", "now add to view..");
            Log.i("MicroMsg.Voip.NewVoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", Integer.valueOf(this.HdK), Integer.valueOf(this.GUC));
        }
        AppMethodBeat.o(235948);
    }

    private static String fMl() {
        AppMethodBeat.i(235949);
        String string = MMApplicationContext.getContext().getString(R.string.i4y);
        AppMethodBeat.o(235949);
        return string;
    }

    public final void aX(String str, String str2, String str3) {
        AppMethodBeat.i(235950);
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showNotification..show notification..tickContent:" + str + ",title:" + str2 + ",content:" + str3 + ",breathEffect:false");
        Log.printDebugStack("MicroMsg.Voip.NewVoipSmallWindow", "breathEffect false", new Object[0]);
        Intent intent = new Intent();
        intent.setClass(MMApplicationContext.getContext(), VideoActivity.class);
        intent.putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.fFg().fHV());
        intent.putExtra("Voip_Call_From", 3);
        intent.putExtra("Voip_User", this.GUe.field_username);
        intent.putExtra("Voip_Outcall", this.GUf);
        intent.putExtra("Voip_VideoCall", this.GUg);
        PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), 40, intent, 134217728);
        s.c g2 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(str).i(System.currentTimeMillis()).f(str2).g(str3);
        g2.Hv = activity;
        s.c as = g2.as(ezb());
        as.g(2, true);
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, m.e(as), false);
        AppMethodBeat.o(235950);
    }

    public static int ezb() {
        if (Build.VERSION.SDK_INT < 19) {
            return R.drawable.cj7;
        }
        return R.drawable.cj8;
    }

    private void xB(boolean z) {
        AppMethodBeat.i(235951);
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "removeSmallView isFinish: %b", Boolean.valueOf(z));
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
        AppMethodBeat.o(235951);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void cF(int i2, String str) {
        char c2;
        AppMethodBeat.i(235952);
        if (i2 == 241) {
            MMApplicationContext.getContext();
        }
        Log.d("MicroMsg.Voip.NewVoipSmallWindow", "getHintByErrorCode ".concat(String.valueOf(i2)));
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
            AppMethodBeat.o(235952);
            return;
        }
        MMApplicationContext.getContext();
        AppMethodBeat.o(235952);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setCaptureView(CaptureView captureView) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void fJj() {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setVoipBeauty(int i2) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setSpatiotemporalDenosing(int i2) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setHWDecMode(int i2) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void requestRender() {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void releaseSurfaceTexture() {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final com.tencent.mm.plugin.voip.video.b.a adw(int i2) {
        return null;
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final com.tencent.mm.plugin.voip.video.d.b fJk() {
        return null;
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void jA(int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void a(SurfaceTexture surfaceTexture, com.tencent.mm.media.g.d dVar) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void f(int i2, int i3, byte[] bArr) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5, int i6) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void aUB(String str) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void fJm() {
        AppMethodBeat.i(235953);
        if (this.HpV != null) {
            this.HpV.fJm();
        }
        AppMethodBeat.o(235953);
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
    public final void setScreenEnable(boolean z) {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void enR() {
        AppMethodBeat.i(235954);
        com.tencent.mm.plugin.voip.c.fFh().enR();
        AppMethodBeat.o(235954);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void fJn() {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void fFL() {
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final Context fJl() {
        return null;
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void uninit() {
        int i2 = 3;
        AppMethodBeat.i(235955);
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "uninit");
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
            Log.i("MicroMsg.Voip.NewVoipSmallWindow", "release waklock");
            this.hCN.release();
        }
        xB(false);
        this.Hqb = true;
        if (this.HpW != null) {
            this.HpW.stopTimer();
        }
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "uninit..cancel notification..");
        t tVar = t.GYO;
        t.fHK();
        AppMethodBeat.o(235955);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void setConnectSec(long j2) {
        AppMethodBeat.i(235956);
        this.GUl = j2;
        if (this.HpV != null) {
            this.HpV.setConnectSec(j2);
            AppMethodBeat.o(235956);
            return;
        }
        if (261 == this.mStatus || 7 == this.mStatus) {
            String fMl = fMl();
            aX(fMl, aa.getDisplayName(this.GUe.field_username), fMl);
        }
        AppMethodBeat.o(235956);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void xi(boolean z) {
        AppMethodBeat.i(235957);
        com.tencent.mm.plugin.voip.c.fFh().xm(true);
        AppMethodBeat.o(235957);
    }

    @Override // com.tencent.mm.plugin.voip.ui.b
    public final void ebH() {
        AppMethodBeat.i(235958);
        com.tencent.mm.plugin.voip.c.fFh().xm(false);
        AppMethodBeat.o(235958);
    }

    private static void Lj(String str) {
        AppMethodBeat.i(235959);
        g.aAh().azQ().setLong(327950, System.currentTimeMillis());
        Log.d("MicroMsg.Voip.NewVoipSmallWindow", "reportRawMessage, len: " + str.length());
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
        AppMethodBeat.o(235959);
    }

    private static String Wv() {
        AppMethodBeat.i(235960);
        String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
        if (Util.isNullOrNil(aA)) {
            aA = bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "never_login_crash");
        }
        AppMethodBeat.o(235960);
        return aA;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
