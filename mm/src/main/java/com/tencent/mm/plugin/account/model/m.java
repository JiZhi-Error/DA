package com.tencent.mm.plugin.account.model;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.j.a.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import java.util.Map;

public class m implements bd {
    private static MTimerHandler cve = null;
    private static int hjI = 0;
    public static a kiy = a.NONE;
    private IListener kiA = new IListener<bp>() {
        /* class com.tencent.mm.plugin.account.model.m.AnonymousClass4 */

        {
            AppMethodBeat.i(196855);
            this.__eventId = bp.class.getName().hashCode();
            AppMethodBeat.o(196855);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(196856);
            bp bpVar2 = bpVar;
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
            int i2 = sharedPreferences.getInt("new_launch_image_sub_type", 0);
            if (bpVar2.dEN.dEO == 43 && i2 > 0 && i2 == bpVar2.dEN.subType) {
                String str = bpVar2.dEN.filePath;
                h.INSTANCE.idkeyStat(723, 6, 1, false);
                sharedPreferences.edit().putInt("new_launch_image_res_version", bpVar2.dEN.dEP).commit();
                Log.i("MicroMsg.SubCoreAccountSync", "filePath: %s", str);
                m.To(str);
            }
            AppMethodBeat.o(196856);
            return false;
        }
    };
    private a kix;
    private q kiz = new q() {
        /* class com.tencent.mm.plugin.account.model.m.AnonymousClass3 */

        {
            AppMethodBeat.i(161698);
            AppMethodBeat.o(161698);
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(196854);
            if (Util.nullAsNil(str).equals("ChangeLaunchImage") && map != null) {
                String str2 = map.get(".sysmsg.ChangeLaunchImage.BeginTime");
                String str3 = map.get(".sysmsg.ChangeLaunchImage.EndTime");
                String str4 = map.get(".sysmsg.ChangeLaunchImage.ResId.SubType");
                Log.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", str2, str3, str4);
                if (!Util.isNullOrNil(str2, str3, str4)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(723, 5, 1, false);
                    int safeParseInt = Util.safeParseInt(str4);
                    if (safeParseInt > 0) {
                        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
                        sharedPreferences.edit().putLong("new_launch_image_begin_time", Util.safeParseLong(str2)).apply();
                        sharedPreferences.edit().putInt("new_launch_image_sub_type", safeParseInt).apply();
                        sharedPreferences.edit().putLong("new_launch_image_end_time", Util.safeParseLong(str3)).commit();
                        b.gnC();
                        m.To(b.kC(43, safeParseInt));
                    }
                }
            }
            AppMethodBeat.o(196854);
        }
    };

    public m() {
        AppMethodBeat.i(127858);
        AppMethodBeat.o(127858);
    }

    static /* synthetic */ int access$008() {
        int i2 = hjI;
        hjI = i2 + 1;
        return i2;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(127859);
        EventCenter.instance.removeListener(this.kix.kih);
        this.kix = null;
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.kiz);
        this.kiA.dead();
        ((l) g.af(l.class)).aSN().remove(com.tencent.mm.pluginsdk.i.a.JYc);
        AppMethodBeat.o(127859);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(127860);
        this.kix = new a();
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.kiz);
        this.kiA.alive();
        b.gnC();
        b.ahP(43);
        ((l) g.af(l.class)).aSN().add(com.tencent.mm.pluginsdk.i.a.JYc);
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.account.model.m.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(196852);
                com.tencent.mm.pluginsdk.i.a.gnp();
                com.tencent.mm.pluginsdk.i.a.gnq();
                AppMethodBeat.o(196852);
            }
        });
        AppMethodBeat.o(127860);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    public static void a(a aVar) {
        AppMethodBeat.i(127861);
        kiy = aVar;
        switch (aVar) {
            case SENT:
                hjI = 0;
                if (cve == null) {
                    cve = new MTimerHandler(new MTimerHandler.CallBack() {
                        /* class com.tencent.mm.plugin.account.model.m.AnonymousClass2 */

                        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                        public final boolean onTimerExpired() {
                            AppMethodBeat.i(196853);
                            m.access$008();
                            if (m.hjI == 1 || m.hjI == 16 || m.hjI % 96 == 0) {
                                Context context = MMApplicationContext.getContext();
                                ComponentName componentName = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(1).get(0).topActivity;
                                Log.d("MicroMsg.SubCoreAccountSync", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", componentName.getClassName());
                                if (!MobileVerifyUI.class.getName().equals(componentName.getClassName())) {
                                    Intent intent = new Intent(context, MobileVerifyUI.class);
                                    intent.addFlags(2);
                                    intent.addFlags(536870912);
                                    intent.addFlags(67108864);
                                    PendingIntent activity = PendingIntent.getActivity(context, 36, intent, 1073741824);
                                    s.c cd = com.tencent.mm.bq.a.cd(context, "reminder_channel_id");
                                    cd.f(context.getString(R.string.y7));
                                    cd.as(com.tencent.mm.bq.a.ezb());
                                    cd.i(System.currentTimeMillis());
                                    cd.Hv = activity;
                                    Notification build = new s.b(cd).e(context.getString(R.string.f0b)).build();
                                    build.defaults |= 1;
                                    build.flags |= 16;
                                    ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(36, build, false);
                                }
                            }
                            AppMethodBeat.o(196853);
                            return true;
                        }
                    }, true);
                }
                Log.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
                cve.startTimer(900000);
                AppMethodBeat.o(127861);
                return;
            case NONE:
            case VERIFIED:
                if (cve != null) {
                    cve.stopTimer();
                }
                Log.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
                kiy = a.NONE;
                ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(36);
                hjI = 0;
                cve = null;
                break;
        }
        AppMethodBeat.o(127861);
    }

    public enum a {
        NONE,
        SENT,
        VERIFIED;

        public static a valueOf(String str) {
            AppMethodBeat.i(127856);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(127856);
            return aVar;
        }

        static {
            AppMethodBeat.i(127857);
            AppMethodBeat.o(127857);
        }
    }

    static /* synthetic */ void To(String str) {
        AppMethodBeat.i(127862);
        Log.i("MicroMsg.SubCoreAccountSync", "filePath: %s", str);
        if (!Util.isNullOrNil(str) && com.tencent.mm.vfs.s.YS(str)) {
            String str2 = com.tencent.mm.loader.j.b.aKB() + "splashWelcomeImg";
            if (com.tencent.mm.vfs.s.deleteFile(str2)) {
                com.tencent.mm.vfs.s.nw(str, str2);
            }
        }
        AppMethodBeat.o(127862);
    }
}
