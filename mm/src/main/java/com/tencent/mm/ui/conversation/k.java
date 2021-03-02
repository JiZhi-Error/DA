package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.PowerManager;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.d.i;
import com.tencent.mm.g.a.db;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.yf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.dbbackup.DBRecoveryUI;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.eht;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.z;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;

public final class k implements i, j {
    private static boolean Qft = false;
    private d Qfn = null;
    private d Qfo = null;
    private boolean Qfp = false;
    private f.a Qfq = new f.a();
    boolean Qfr = false;
    private com.tencent.mm.modelmulti.f Qfs = null;
    a Qfu;
    a Qfv;
    IListener Qfw = new IListener<qd>() {
        /* class com.tencent.mm.ui.conversation.k.AnonymousClass1 */

        {
            AppMethodBeat.i(161570);
            this.__eventId = qd.class.getName().hashCode();
            AppMethodBeat.o(161570);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qd qdVar) {
            AppMethodBeat.i(38590);
            qdVar.dWt.dWu = k.this.gVU();
            AppMethodBeat.o(38590);
            return false;
        }
    };
    IListener Qfx = new IListener<yf>() {
        /* class com.tencent.mm.ui.conversation.k.AnonymousClass6 */

        {
            AppMethodBeat.i(161571);
            this.__eventId = yf.class.getName().hashCode();
            AppMethodBeat.o(161571);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yf yfVar) {
            AppMethodBeat.i(38599);
            if (k.this.dKq == null) {
                Log.i("MicroMsg.InitHelper", "inithelper hasn't initialized");
                AppMethodBeat.o(38599);
            } else {
                k.this.Qfp = false;
                k.c(k.this);
                AppMethodBeat.o(38599);
            }
            return false;
        }
    };
    FLock Qfy;
    Activity dKq;
    ProgressDialog gtM = null;
    WeakReference<Activity> kRw;
    PowerManager.WakeLock wakeLock = null;

    public interface a {
        void atH();

        void gVV();
    }

    public k() {
        AppMethodBeat.i(38610);
        AppMethodBeat.o(38610);
    }

    static /* synthetic */ void c(k kVar) {
        AppMethodBeat.i(38617);
        kVar.gVS();
        AppMethodBeat.o(38617);
    }

    public final void gGx() {
        AppMethodBeat.i(234175);
        if (this.wakeLock != null && this.wakeLock.isHeld()) {
            Log.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
            this.wakeLock.release();
        }
        AppMethodBeat.o(234175);
    }

    /* access modifiers changed from: package-private */
    public final boolean gVR() {
        AppMethodBeat.i(38611);
        if (!l.bdN()) {
            AppMethodBeat.o(38611);
            return false;
        } else if (this.Qfo == null || !this.Qfo.isShowing()) {
            g.aAi();
            if (g.aAh().azK()) {
                this.Qfo = new d.a(this.dKq).aoO(R.string.bku).boo(this.dKq.getString(R.string.bkt)).Dk(false).aoV(R.string.bkv).c(new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.k.AnonymousClass9 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(38604);
                        k.this.Qfo.dismiss();
                        Intent intent = new Intent(k.this.dKq, DBRecoveryUI.class);
                        intent.putExtra("scene", 0);
                        Activity activity = k.this.dKq;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/conversation/InitHelper$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        activity.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/conversation/InitHelper$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(38604);
                    }
                }).aoW(R.string.bks).d(new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.k.AnonymousClass8 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(38603);
                        g.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.ui.conversation.k.AnonymousClass8.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(38601);
                                ao azQ = g.aAh().azQ();
                                azQ.set(89, (Object) 2);
                                azQ.gBI();
                                AppMethodBeat.o(38601);
                            }
                        });
                        k.this.Qfo.dismiss();
                        h.a((Context) k.this.dKq, (int) R.string.bke, (int) R.string.zb, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.conversation.k.AnonymousClass8.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(38602);
                                k.c(k.this);
                                AppMethodBeat.o(38602);
                            }
                        });
                        AppMethodBeat.o(38603);
                    }
                }).hbn();
                this.Qfo.show();
            } else {
                gVS();
            }
            AppMethodBeat.o(38611);
            return true;
        } else {
            AppMethodBeat.o(38611);
            return false;
        }
    }

    private void gVS() {
        AppMethodBeat.i(38612);
        if (this.Qfp) {
            Log.i("MicroMsg.InitHelper", "summerinit doPreCreate but hasTryDoInitButFailed true ret");
            AppMethodBeat.o(38612);
            return;
        }
        if (!this.wakeLock.isHeld()) {
            Log.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
            this.wakeLock.acquire();
        }
        this.Qfv.gVV();
        db dbVar = new db();
        dbVar.dGl.action = 1;
        EventCenter.instance.publish(dbVar);
        if (this.Qfs == null) {
            if (o.DCN != null) {
                o.DCN.eZi();
            }
            this.Qfs = new com.tencent.mm.modelmulti.f(this);
            Log.d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", Long.valueOf(this.Qfq.apr()), Integer.valueOf(this.Qfs.hashCode()));
            this.Qfq.gLm = SystemClock.elapsedRealtime();
            bg.azz().a(this.Qfs, 0);
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.conversation.k.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(38606);
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(k.this.Qfq.apr());
                objArr[1] = Integer.valueOf(k.this.Qfs == null ? -2 : k.this.Qfs.hashCode());
                Log.d("MicroMsg.InitHelper", "dkinit showProgressDlg t:%d initScene:%d", objArr);
                if (k.this.gtM != null && k.this.gtM.isShowing()) {
                    k.this.gtM.dismiss();
                }
                k kVar = k.this;
                Activity activity = k.this.dKq;
                k.this.dKq.getString(R.string.zb);
                kVar.gtM = h.a((Context) activity, k.this.dKq.getString(R.string.wd), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.ui.conversation.k.AnonymousClass10.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(38605);
                        bg.azz().a(k.this.Qfs);
                        if (o.DCN != null) {
                            o.DCN.eZj();
                        }
                        AppMethodBeat.o(38605);
                    }
                });
                bg.aAk().setHighPriority();
                AppMethodBeat.o(38606);
            }
        });
        AppMethodBeat.o(38612);
    }

    @Override // com.tencent.mm.ak.j
    public final void a(int i2, int i3, q qVar) {
        AppMethodBeat.i(38613);
        if (qVar == null || qVar.getType() != 139) {
            AppMethodBeat.o(38613);
            return;
        }
        final int i4 = (int) (i3 != 0 ? (((long) i2) * 100) / ((long) i3) : 0);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.conversation.k.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(38607);
                if (k.this.gtM != null) {
                    k.this.gtM.setMessage(k.this.dKq.getString(R.string.wd) + i4 + "%");
                }
                AppMethodBeat.o(38607);
            }
        });
        AppMethodBeat.o(38613);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int hashCode;
        boolean z;
        AppMethodBeat.i(38614);
        if (qVar.getType() == 138 || qVar.getType() == 139) {
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = str;
            objArr[3] = Integer.valueOf(qVar.getType());
            objArr[4] = Integer.valueOf(hashCode());
            if (this.Qfs == null) {
                hashCode = -2;
            } else {
                hashCode = this.Qfs.hashCode();
            }
            objArr[5] = Integer.valueOf(hashCode);
            Log.i("MicroMsg.InitHelper", "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ", objArr);
            if (this.Qfs != null && qVar.getType() == 139) {
                this.Qfs = null;
                Log.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", Long.valueOf(this.Qfq.apr()));
                ay.a.iDq.aVg();
                if (o.DCN != null) {
                    o.DCN.eZj();
                }
                this.Qfv.atH();
                db dbVar = new db();
                dbVar.dGl.action = 2;
                EventCenter.instance.publish(dbVar);
                if (this.wakeLock.isHeld()) {
                    Log.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
                    this.wakeLock.release();
                }
                bg.aAk().setLowPriority();
                if (this.gtM != null) {
                    this.gtM.dismiss();
                    this.gtM = null;
                }
                boolean z2 = false;
                final Activity activity = this.kRw.get();
                if (g.aAc() && g.aAf().hpY && activity != null && !this.dKq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).getBoolean("font_scale_tip_login", false)) {
                    if (1.0f == com.tencent.mm.cb.a.ez(this.dKq)) {
                        if (1.0f != this.dKq.getResources().getConfiguration().fontScale) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(15181, 1);
                            f.a aVar = new f.a(activity);
                            aVar.aC(activity.getResources().getString(R.string.dgr)).bow(activity.getResources().getString(R.string.dgo)).boA(activity.getResources().getString(R.string.dgq)).boB(activity.getResources().getString(R.string.dgp));
                            aVar.c(new f.c() {
                                /* class com.tencent.mm.ui.conversation.k.AnonymousClass12 */

                                @Override // com.tencent.mm.ui.widget.a.f.c
                                public final void e(boolean z, String str) {
                                    AppMethodBeat.i(38608);
                                    if (z) {
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15181, 3);
                                        Intent intent = new Intent();
                                        intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                                        Activity activity = activity;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/conversation/InitHelper$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        activity.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/conversation/InitHelper$8", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        AppMethodBeat.o(38608);
                                        return;
                                    }
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(15181, 2);
                                    AppMethodBeat.o(38608);
                                }
                            }).show();
                            this.dKq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 = z;
                    } else {
                        this.dKq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
                        z2 = true;
                    }
                }
                if (!z2) {
                    this.dKq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", false).apply();
                }
                if (i2 == 0 && i3 == 0) {
                    bg.aVF();
                    as Kn = c.aSN().Kn(z.aTY());
                    if (Kn != null && (!com.tencent.mm.contact.c.oR(Kn.field_type) || !Util.isNullOrNil(Kn.field_conRemark) || !Util.isNullOrNil(Kn.field_conRemarkPYFull) || !Util.isNullOrNil(Kn.field_conRemarkPYShort))) {
                        Kn.aqQ();
                        Kn.BD("");
                        Kn.BI("");
                        Kn.BJ("");
                        bg.aVF();
                        c.aSN().c(z.aTY(), Kn);
                    }
                }
            }
            if (com.tencent.mm.plugin.account.ui.a.a(this.dKq, i2, i3, new Intent().setClass(this.dKq, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                Log.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
                AppMethodBeat.o(38614);
            } else if (!bg.aAc()) {
                Log.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
                AppMethodBeat.o(38614);
            } else {
                if (!this.Qfr) {
                    this.Qfr = true;
                    bg.aVF();
                    String str2 = (String) c.azQ().get(5, (Object) null);
                    bg.aVF();
                    if ((((Integer) c.azQ().get(57, 0)).intValue() != 0) && str2 != null) {
                        h.c(this.dKq, this.dKq.getString(R.string.fys, new Object[]{str2}), this.dKq.getString(R.string.zb), this.dKq.getString(R.string.fyu), this.dKq.getString(R.string.fyt), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.conversation.k.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(38592);
                                Intent intent = new Intent();
                                intent.setClassName(k.this.dKq, "com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI");
                                Activity activity = k.this.dKq;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/conversation/InitHelper$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                activity.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/conversation/InitHelper$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(38592);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.conversation.k.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(38593);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(38593);
                            }
                        });
                    }
                }
                if (i2 == 4 && i3 == -17 && !Qft) {
                    p.bdS().tE(7);
                    Qft = true;
                }
                if (aT(i2, i3, qVar.getType())) {
                    Log.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
                    AppMethodBeat.o(38614);
                    return;
                }
                if (qVar.getType() == 139) {
                    la laVar = new la();
                    if (i2 == 3 && i3 == -1) {
                        this.Qfp = true;
                        laVar.dQf.dOz = false;
                        EventCenter.instance.publish(laVar);
                        this.Qfu.gVm();
                    } else {
                        laVar.dQf.dOz = true;
                        EventCenter.instance.publish(laVar);
                    }
                }
                if (z.a.a(this.dKq, i2, i3, str, 4)) {
                    AppMethodBeat.o(38614);
                    return;
                }
                if (qVar.getType() == 139) {
                    new MMHandler().post(new Runnable() {
                        /* class com.tencent.mm.ui.conversation.k.AnonymousClass13 */

                        public final void run() {
                            AppMethodBeat.i(38609);
                            p.bdS().tE(5);
                            AppMethodBeat.o(38609);
                        }
                    });
                    if ((com.tencent.mm.model.z.aUe() & 128) != 0) {
                        bg.aVF();
                        if (c.aST().bjY("masssendapp") == null) {
                            az azVar = new az();
                            azVar.setUsername("masssendapp");
                            azVar.setContent(MMApplicationContext.getContext().getResources().getString(R.string.bcm));
                            azVar.yA(Util.nowMilliSecond() + 2000);
                            azVar.nv(0);
                            azVar.nt(0);
                            bg.aVF();
                            c.aST().e(azVar);
                            bg.aVF();
                            c.azQ().set(40, Integer.valueOf(com.tencent.mm.model.z.aUe() & -129));
                        }
                    }
                }
                if (qVar.getType() == 138 || qVar.getType() == 139) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.conversation.k.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(38591);
                            in inVar = new in();
                            inVar.dNg.data = "MAIN_UI_EVENT_INIT_FINALLY";
                            EventCenter.instance.publish(inVar);
                            AppMethodBeat.o(38591);
                        }
                    });
                    this.Qfu.gVm();
                }
                AppMethodBeat.o(38614);
            }
        } else if (qVar.getType() == 113 || qVar.getType() == 0) {
            Log.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
            AppMethodBeat.o(38614);
        } else {
            aT(i2, i3, qVar.getType());
            AppMethodBeat.o(38614);
        }
    }

    private boolean aT(int i2, int i3, int i4) {
        AppMethodBeat.i(38615);
        if (!g.aAc()) {
            Log.w("MicroMsg.InitHelper", "account not ready");
            AppMethodBeat.o(38615);
            return false;
        }
        bg.aVF();
        long nullAs = Util.nullAs((Long) c.azQ().get(ar.a.USERINFO_UPDATE_UPDATE_FLAG_LONG, (Object) null), 0);
        bg.aVF();
        long nullAs2 = Util.nullAs((Long) c.azQ().get(ar.a.USERINFO_UPDATE_UPDATE_TIME_LONG, (Object) null), 0);
        bg.aVF();
        long nullAs3 = Util.nullAs((Long) c.azQ().get(ar.a.USERINFO_UPDATE_UPDATE_VERION_LONG, (Object) null), 0);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_UPDATE_UPDATE_FLAG_LONG, (Object) 0L);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_UPDATE_UPDATE_VERION_LONG, (Object) 0L);
        if (nullAs3 == ((long) com.tencent.mm.protocal.d.KyO) && Util.secondsToNow(nullAs2) < 3600) {
            if (nullAs == 1) {
                if (com.tencent.mm.ui.z.c(this.dKq, 4, -17)) {
                    AppMethodBeat.o(38615);
                    return true;
                }
            } else if (nullAs == 2 && com.tencent.mm.ui.z.c(this.dKq, 4, -16)) {
                AppMethodBeat.o(38615);
                return true;
            }
        }
        if (i2 == 4 && (i3 == -16 || i3 == -17)) {
            Log.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", Integer.valueOf(i3), Integer.valueOf(i4));
            if (ac.jOo) {
                MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", (Util.nowSecond() - 86400) - 1).commit();
            }
            if (com.tencent.mm.ui.z.c(this.dKq, i2, i3)) {
                AppMethodBeat.o(38615);
                return true;
            }
        }
        AppMethodBeat.o(38615);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int gVT() {
        AppMethodBeat.i(38616);
        if (this.Qfs == null) {
            AppMethodBeat.o(38616);
            return -2;
        }
        int hashCode = this.Qfs.hashCode();
        AppMethodBeat.o(38616);
        return hashCode;
    }

    public final boolean gVU() {
        return this.Qfs != null;
    }

    static /* synthetic */ void d(k kVar) {
        AppMethodBeat.i(234176);
        final eht gnx = com.tencent.mm.pluginsdk.i.g.gnx();
        if (com.tencent.mm.pluginsdk.i.g.gny() && gnx != null) {
            com.tencent.f.h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.ui.conversation.k.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(38598);
                    if (gnx != null && gnx.ynw.equalsIgnoreCase(com.tencent.mm.pluginsdk.i.g.iw(MMApplicationContext.getContext()))) {
                        if (s.YS(gnx.Nhj) && com.tencent.mm.d.a.fP(gnx.Nhj)) {
                            com.tencent.f.h.RTc.aV(new Runnable() {
                                /* class com.tencent.mm.ui.conversation.k.AnonymousClass5.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(38596);
                                    if (k.this.Qfn == null || !k.this.Qfn.isShowing()) {
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(614, 60, 1, false);
                                        k.this.Qfn = h.a((Context) k.this.dKq, gnx.msg, gnx.title, gnx.Nhk, gnx.xWM, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.ui.conversation.k.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(38594);
                                                r.b(k.this.dKq, gnx.Nhj, null, false);
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(614, 50, 1, false);
                                                dialogInterface.dismiss();
                                                AppMethodBeat.o(38594);
                                            }
                                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.ui.conversation.k.AnonymousClass5.AnonymousClass1.AnonymousClass2 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(38595);
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(614, 57, 1, false);
                                                dialogInterface.dismiss();
                                                if (((com.tencent.mm.plugin.updater.a.a) g.ah(com.tencent.mm.plugin.updater.a.a.class)).openUpdater()) {
                                                    ((com.tencent.mm.plugin.updater.a.a) g.ah(com.tencent.mm.plugin.updater.a.a.class)).setFullCheckUpdateRedDot(gnx.Nhl);
                                                }
                                                AppMethodBeat.o(38595);
                                            }
                                        });
                                        com.tencent.mm.pluginsdk.i.g.gnz();
                                        AppMethodBeat.o(38596);
                                        return;
                                    }
                                    Log.i("MicroMsg.InitHelper", "update dialog is showing.");
                                    AppMethodBeat.o(38596);
                                }
                            });
                            AppMethodBeat.o(38598);
                            return;
                        } else if (((com.tencent.mm.plugin.updater.a.a) g.ah(com.tencent.mm.plugin.updater.a.a.class)).openUpdater()) {
                            com.tencent.f.h.RTc.aV(new Runnable() {
                                /* class com.tencent.mm.ui.conversation.k.AnonymousClass5.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(38597);
                                    if (k.this.Qfn == null || !k.this.Qfn.isShowing()) {
                                        Log.i("MicroMsg.InitHelper", "show update dialog");
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1429, 27, 1, false);
                                        f.a aVar = new f.a(MMApplicationContext.getContext());
                                        aVar.bow(MMApplicationContext.getContext().getString(R.string.htc));
                                        aVar.apa(R.string.ht2);
                                        aVar.Dq(true);
                                        aVar.c(new f.c() {
                                            /* class com.tencent.mm.ui.conversation.k.AnonymousClass5.AnonymousClass2.AnonymousClass1 */

                                            @Override // com.tencent.mm.ui.widget.a.f.c
                                            public final void e(boolean z, String str) {
                                                AppMethodBeat.i(234172);
                                                Log.i("MicroMsg.InitHelper", "onDialogClick %s", Boolean.valueOf(z));
                                                if (z) {
                                                    k.anS(gnx.Nhl);
                                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1429, 28, 1, false);
                                                }
                                                AppMethodBeat.o(234172);
                                            }
                                        });
                                        aVar.b(new DialogInterface.OnDismissListener() {
                                            /* class com.tencent.mm.ui.conversation.k.AnonymousClass5.AnonymousClass2.AnonymousClass2 */

                                            public final void onDismiss(DialogInterface dialogInterface) {
                                                AppMethodBeat.i(234173);
                                                ((com.tencent.mm.plugin.updater.a.a) g.ah(com.tencent.mm.plugin.updater.a.a.class)).setFullCheckUpdateRedDot(gnx.Nhl);
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1429, 29, 1, false);
                                                AppMethodBeat.o(234173);
                                            }
                                        });
                                        aVar.show();
                                        k.this.Qfn = aVar.kdo;
                                        com.tencent.mm.pluginsdk.i.g.gnz();
                                        AppMethodBeat.o(38597);
                                        return;
                                    }
                                    Log.i("MicroMsg.InitHelper", "update dialog is showing.");
                                    AppMethodBeat.o(38597);
                                }
                            });
                            AppMethodBeat.o(38598);
                            return;
                        } else {
                            com.tencent.f.h.RTc.aV(new Runnable() {
                                /* class com.tencent.mm.ui.conversation.k.AnonymousClass5.AnonymousClass3 */

                                public final void run() {
                                    e eVar;
                                    AppMethodBeat.i(234174);
                                    Log.i("MicroMsg.InitHelper", "path:%s,apkMd5:%s", gnx.Nhj, gnx.ynv);
                                    try {
                                        eVar = bg.azz().iMw.aZh();
                                    } catch (Throwable th) {
                                        Log.printErrStackTrace("MicroMsg.InitHelper", th, "", new Object[0]);
                                        eVar = null;
                                    }
                                    if (eVar == null) {
                                        AppMethodBeat.o(234174);
                                        return;
                                    }
                                    String substring = gnx.pkK.substring(0, gnx.pkK.lastIndexOf(47) + 1);
                                    String substring2 = gnx.pkK.substring(gnx.pkK.lastIndexOf(47) + 1);
                                    com.tencent.mm.d.i iVar = new com.tencent.mm.d.i(substring, gnx.versionCode);
                                    iVar.a(new i.a(gnx.ynw, gnx.ynv, gnx.patchMd5, substring2, gnx.nJK));
                                    Intent intent = new Intent();
                                    intent.putExtra("intent_short_ips", com.tencent.mm.pluginsdk.i.g.getShortIps());
                                    intent.putExtra("intent_client_version", com.tencent.mm.protocal.d.KyO);
                                    intent.putExtra("intent_extra_session", eVar.qe(1));
                                    intent.putExtra("intent_extra_cookie", eVar.aZa());
                                    intent.putExtra("intent_extra_ecdhkey", eVar.aZc());
                                    intent.putExtra("intent_extra_uin", eVar.getUin());
                                    intent.putExtra("intent_update_type", 3);
                                    intent.putExtra("intent_extra_desc", gnx.msg);
                                    intent.putExtra("intent_extra_md5", gnx.patchMd5);
                                    intent.putExtra("intent_extra_size", gnx.nJK);
                                    intent.putExtra("intent_extra_download_url", new String[]{gnx.pkK});
                                    intent.putExtra("intent_extra_patchInfo", iVar.VO());
                                    intent.putExtra("intent_extra_updateMode", ChannelUtil.updateMode);
                                    intent.putExtra("intent_extra_marketUrl", ChannelUtil.marketURL);
                                    intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
                                    intent.putExtra("intent_extra_tinker_patch", true);
                                    intent.putExtra("intent_extra_download_mode", 1);
                                    com.tencent.mm.plugin.p.d.elq().al(k.this.dKq, intent);
                                    com.tencent.mm.pluginsdk.i.g.gnz();
                                    AppMethodBeat.o(234174);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(38598);
                }
            });
            Log.i("MicroMsg.InitHelper", "have tinker update.");
            AppMethodBeat.o(234176);
        } else if (com.tencent.mm.ui.z.jP(kVar.dKq)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(405, 41, 1, true);
            Log.d("MicroMsg.InitHelper", "we got a install");
            AppMethodBeat.o(234176);
        } else {
            com.tencent.mm.ui.z.bi(kVar.dKq);
            AppMethodBeat.o(234176);
        }
    }

    static /* synthetic */ void anS(int i2) {
        AppMethodBeat.i(234177);
        String string = MMApplicationContext.getContext().getString(R.string.htb, LocaleUtil.getApplicationLanguage(), Integer.valueOf(i2), 1);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(234177);
    }
}
