package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.GreenManUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    public static String gnL = "com.tencent.preference.notification.key.unread.msg";
    public static String gnM = "com.tencent.preference.notification.key.unread.talker";
    public static String gnN = "com.tencent.preference.notification.key.all.notified.msgid";
    public g dnt = new g(this.mContext);
    Context mContext = MMApplicationContext.getContext();

    public d() {
        AppMethodBeat.i(19958);
        AppMethodBeat.o(19958);
    }

    public static Notification ald() {
        AppMethodBeat.i(19959);
        Notification notification = new Notification();
        notification.icon = R.drawable.icon;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 300;
        notification.ledOffMS = 1000;
        AppMethodBeat.o(19959);
        return notification;
    }

    public static boolean a(String str, ca caVar, int i2, boolean z) {
        AppMethodBeat.i(19960);
        Log.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i2));
        if (!bg.aAc()) {
            Log.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i2));
            AppMethodBeat.o(19960);
            return false;
        } else if (caVar != null && yP(caVar.field_msgSvrId) && !z) {
            Log.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", Long.valueOf(caVar.field_msgSvrId));
            AppMethodBeat.o(19960);
            return false;
        } else if ((i2 & 1) == 0) {
            Log.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i2));
            AppMethodBeat.o(19960);
            return false;
        } else {
            bg.aVF();
            if (c.azn() && !z.aqE()) {
                bg.aVF();
                Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", str, Integer.valueOf(i2), Boolean.valueOf(c.azn()), Boolean.valueOf(z.aqE()));
                AppMethodBeat.o(19960);
                return false;
            } else if (ab.II(str)) {
                lu luVar = new lu();
                luVar.dRh.dJY = 3;
                EventCenter.instance.publish(luVar);
                if (!luVar.dRi.dFE) {
                    lu luVar2 = new lu();
                    luVar2.dRh.dJY = 1;
                    luVar2.dRh.dRj = str;
                    luVar2.dRh.dRk = 3;
                    EventCenter.instance.publish(luVar2);
                }
                Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i2));
                AppMethodBeat.o(19960);
                return false;
            } else if (ab.JJ(str) || (ab.Iw(str) && !ab.JI(str) && caVar != null && !caVar.bkz(z.aTY()) && caVar.getType() != 64 && caVar != null && !caVar.gDV())) {
                Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", str, Integer.valueOf(i2));
                AppMethodBeat.o(19960);
                return false;
            } else {
                AppMethodBeat.o(19960);
                return true;
            }
        }
    }

    static boolean CZ(String str) {
        AppMethodBeat.i(231501);
        try {
            com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(str);
            if (fJ == null) {
                AppMethodBeat.o(231501);
                return false;
            } else if (!fJ.UH()) {
                AppMethodBeat.o(231501);
                return false;
            } else {
                bg.aVF();
                as Kn = c.aSN().Kn(fJ.UN());
                if (Kn == null) {
                    AppMethodBeat.o(231501);
                    return false;
                }
                boolean Zx = Kn.Zx();
                AppMethodBeat.o(231501);
                return Zx;
            }
        } catch (Throwable th) {
            AppMethodBeat.o(231501);
            return false;
        }
    }

    @TargetApi(11)
    public final Notification a(Notification notification, int i2, int i3, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.i(19962);
        Notification a2 = a(notification, i2, i3, pendingIntent, str, str2, str3, bitmap, 0, null, null, 0, null, null, str4);
        AppMethodBeat.o(19962);
        return a2;
    }

    @TargetApi(21)
    public final Notification a(Notification notification, int i2, int i3, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i4, String str4, PendingIntent pendingIntent2, int i5, String str5, PendingIntent pendingIntent3, String str6) {
        int i6;
        AppMethodBeat.i(19963);
        s.c cd = com.tencent.mm.bq.a.cd(this.mContext, com.tencent.mm.bq.a.glE());
        if (i2 == -1) {
            i2 = com.tencent.mm.bq.a.ezb();
        }
        cd.HX.ledARGB = -16711936;
        cd.HX.ledOnMS = 300;
        cd.HX.ledOffMS = 1000;
        boolean z = (cd.HX.ledOnMS == 0 || cd.HX.ledOffMS == 0) ? false : true;
        Notification notification2 = cd.HX;
        int i7 = cd.HX.flags & -2;
        if (z) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        notification2.flags = i6 | i7;
        cd.as(i2).i(str3).Hv = pendingIntent;
        cd.HM = true;
        if (str != null) {
            cd.f(str);
        }
        if (str2 != null) {
            cd.g(str2);
        }
        cd.HX.defaults = i3;
        if ((i3 & 4) != 0) {
            cd.HX.flags |= 1;
        }
        if (bitmap != null) {
            cd.b(bitmap);
        }
        if (notification != null) {
            if (notification.sound != null) {
                cd.b(notification.sound);
            }
            if (notification.vibrate != null) {
                cd.HX.vibrate = notification.vibrate;
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (str4 != null) {
                s.a.C0017a aVar = new s.a.C0017a(i4, str4, pendingIntent2);
                if (Build.VERSION.SDK_INT >= 29) {
                    aVar.Hj = false;
                }
                cd.a(aVar.es());
            }
            if (str5 != null) {
                s.a.C0017a aVar2 = new s.a.C0017a(i5, str5, pendingIntent3);
                if (Build.VERSION.SDK_INT >= 29) {
                    aVar2.Hj = false;
                }
                cd.a(aVar2.es());
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            cd.HP = "msg";
            aa aaVar = new aa();
            aaVar.dCY.username = str6;
            aaVar.dCY.title = str;
            EventCenter.instance.publish(aaVar);
            if (aaVar.dCY.dCZ != null) {
                aaVar.dCY.dCZ.a(cd);
            }
        }
        cd.E(true);
        Notification build = cd.build();
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                Field findField = b.findField(Notification.class, "mAllowSystemGeneratedContextualActions");
                findField.setAccessible(true);
                findField.set(build, Boolean.FALSE);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", th, "[-] Failure.", new Object[0]);
            }
        }
        AppMethodBeat.o(19963);
        return build;
    }

    public static a c(List<a> list, String str) {
        AppMethodBeat.i(19964);
        if (list == null || str == null) {
            AppMethodBeat.o(19964);
            return null;
        }
        for (a aVar : list) {
            if (aVar.userName.equals(str)) {
                AppMethodBeat.o(19964);
                return aVar;
            }
        }
        AppMethodBeat.o(19964);
        return null;
    }

    public static int ale() {
        AppMethodBeat.i(19965);
        int i2 = com.tencent.mm.n.g.apL().getInt(gnL, 0);
        AppMethodBeat.o(19965);
        return i2;
    }

    public static ArrayList<a> alf() {
        AppMethodBeat.i(19966);
        try {
            ArrayList<a> arrayList = (ArrayList) com.tencent.mm.booter.notification.queue.c.Db(com.tencent.mm.n.g.apL().getString(gnM, ""));
            if (arrayList == null) {
                ArrayList<a> arrayList2 = new ArrayList<>();
                AppMethodBeat.o(19966);
                return arrayList2;
            }
            AppMethodBeat.o(19966);
            return arrayList;
        } catch (ClassNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e2, "", new Object[0]);
            ArrayList<a> arrayList3 = new ArrayList<>();
            AppMethodBeat.o(19966);
            return arrayList3;
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e3, "", new Object[0]);
            ArrayList<a> arrayList4 = new ArrayList<>();
            AppMethodBeat.o(19966);
            return arrayList4;
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e4, "Justin_Exception:%s", e4.getMessage());
            ArrayList<a> arrayList5 = new ArrayList<>();
            AppMethodBeat.o(19966);
            return arrayList5;
        }
    }

    public static void h(ArrayList<a> arrayList) {
        AppMethodBeat.i(19967);
        if (arrayList == null) {
            com.tencent.mm.n.g.apL().edit().putString(gnM, "").apply();
        } else {
            try {
                com.tencent.mm.n.g.apL().edit().putString(gnM, com.tencent.mm.booter.notification.queue.c.a(new ArrayList(arrayList))).apply();
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", e2, "", new Object[0]);
                com.tencent.mm.n.g.apL().edit().putString(gnM, "").apply();
            }
        }
        Object[] objArr = new Object[1];
        objArr[0] = arrayList == null ? BuildConfig.COMMAND : arrayList.toString();
        Log.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadTalker %s", objArr);
        AppMethodBeat.o(19967);
    }

    public static void nT(int i2) {
        AppMethodBeat.i(19968);
        int max = Math.max(0, i2);
        com.tencent.mm.n.g.apL().edit().putInt(gnL, max).apply();
        Log.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", Integer.valueOf(max));
        AppMethodBeat.o(19968);
    }

    public static void yO(long j2) {
        AppMethodBeat.i(19969);
        if (j2 == 0) {
            AppMethodBeat.o(19969);
            return;
        }
        String alg = alg();
        if (alg.length() > 3000) {
            alg = alg.substring(alg.length() / 2, alg.length());
        }
        if (yP(j2)) {
            AppMethodBeat.o(19969);
            return;
        }
        String str = alg + j2 + "%";
        com.tencent.mm.n.g.apL().edit().putString(gnN, str).apply();
        Log.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", str);
        AppMethodBeat.o(19969);
    }

    public static boolean yP(long j2) {
        AppMethodBeat.i(19970);
        if (j2 == 0) {
            AppMethodBeat.o(19970);
            return false;
        }
        String alg = alg();
        Log.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", alg, Long.valueOf(j2));
        if (alg.contains(j2 + "%")) {
            AppMethodBeat.o(19970);
            return true;
        }
        AppMethodBeat.o(19970);
        return false;
    }

    private static String alg() {
        AppMethodBeat.i(19971);
        String string = com.tencent.mm.n.g.apL().getString(gnN, "");
        AppMethodBeat.o(19971);
        return string;
    }

    public static class a implements Serializable {
        public int dOS;
        public String userName;

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(19957);
            String str = "[" + this.userName + "(" + this.dOS + ")]";
            AppMethodBeat.o(19957);
            return str;
        }
    }

    public static void alc() {
        AppMethodBeat.i(19972);
        com.tencent.mm.n.g.apL().edit().putString(gnN, "").apply();
        AppMethodBeat.o(19972);
    }

    @Override // com.tencent.mm.booter.notification.a
    public final int a(NotificationItem notificationItem, g gVar) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        AppMethodBeat.i(19961);
        if (GreenManUtil.isAppVisibleForeground(this.mContext)) {
            Log.i("MicroMsg.Notification.AppMsg.Handle", "GreenManUtil.isAppVisibleForeground");
            if ((BuildInfo.DEBUG || BuildInfo.PRE_RELEASE) && (runningAppProcesses = ((ActivityManager) this.mContext.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.startsWith(MMApplicationContext.getApplicationId()) && GreenManUtil.reflectProcessState(runningAppProcessInfo) == 3) {
                        GreenManUtil.dumpRunningServices(this.mContext);
                    }
                }
            }
        } else if (!(Build.VERSION.SDK_INT < 16 || notificationItem == null || notificationItem.HX == null)) {
            notificationItem.HX.priority = 1;
            if (!com.tencent.mm.n.g.apM()) {
                notificationItem.HX.vibrate = new long[0];
                if (!gVar.goW && !gVar.goV) {
                    notificationItem.HX.priority = 0;
                }
            }
        }
        int a2 = super.a(notificationItem, gVar);
        AppMethodBeat.o(19961);
        return a2;
    }
}
