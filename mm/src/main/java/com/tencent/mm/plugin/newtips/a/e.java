package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.b.a;
import com.tencent.mm.plugin.newtips.b.b;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class e {
    public static boolean a(a aVar) {
        boolean z;
        AppMethodBeat.i(127212);
        if (aVar == null) {
            Log.e("MicroMsg.NewTipsManager", "check time, tipsInfo is null!!!");
            AppMethodBeat.o(127212);
            return false;
        }
        long nowSecond = Util.nowSecond();
        if (aVar.field_overdueTime == 0 && aVar.field_disappearTime == 0) {
            z = true;
        } else {
            Long valueOf = Long.valueOf(Math.min(aVar.field_beginShowTime + aVar.field_overdueTime, aVar.field_disappearTime));
            z = nowSecond >= aVar.field_beginShowTime && nowSecond <= valueOf.longValue();
            if (nowSecond > valueOf.longValue()) {
                MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", Util.nowMilliSecond()).commit();
            }
        }
        Log.i("MicroMsg.NewTipsManager", "timeEffective current: %s, overdueTime: %s, disappearTime: %s, show:%s", Long.valueOf(nowSecond), Long.valueOf(aVar.field_overdueTime), Long.valueOf(aVar.field_disappearTime), Boolean.valueOf(z));
        AppMethodBeat.o(127212);
        return z;
    }

    public static boolean b(a aVar) {
        AppMethodBeat.i(127213);
        if (aVar == null) {
            Log.e("MicroMsg.NewTipsManager", "check path, tipsInfo is null!!!");
            AppMethodBeat.o(127213);
            return false;
        }
        a TF = com.tencent.mm.plugin.newtips.a.exm().TF(aVar.field_tipId);
        if (!(TF == null || TF.field_tipsShowInfo == null || aVar.field_tipsShowInfo == null)) {
            String str = TF.field_tipsShowInfo.path;
            String str2 = aVar.field_tipsShowInfo.path;
            if (!(str == null && str2 == null) && (str == null || !str.equals(str2))) {
                Log.i("MicroMsg.NewTipsManager", "path illegal, localPath:%s, newPath:%s", str, str2);
            } else {
                AppMethodBeat.o(127213);
                return true;
            }
        }
        AppMethodBeat.o(127213);
        return false;
    }

    public static boolean c(a aVar) {
        AppMethodBeat.i(127214);
        if (aVar == null) {
            Log.e("MicroMsg.NewTipsManager", "check version, tipsInfo is null!!!");
            AppMethodBeat.o(127214);
            return false;
        }
        a TF = com.tencent.mm.plugin.newtips.a.exm().TF(aVar.field_tipId);
        if (TF == null || (aVar.field_tipVersion <= TF.field_tipVersion && (aVar.field_hadRead || aVar.field_tipVersion != TF.field_tipVersion))) {
            AppMethodBeat.o(127214);
            return false;
        }
        AppMethodBeat.o(127214);
        return true;
    }

    protected static boolean d(a aVar) {
        AppMethodBeat.i(127215);
        if (aVar == null) {
            Log.e("MicroMsg.NewTipsManager", "can not show new  tips！！ tipsInfo is null !!");
            AppMethodBeat.o(127215);
            return false;
        } else if (!aVar.field_isExit || aVar.field_hadRead || !a(aVar)) {
            Log.i("MicroMsg.NewTipsManager", "can not show tips, isExit:%s, hadRead:%s, timeEffective:%s", Boolean.valueOf(aVar.field_isExit), Boolean.valueOf(aVar.field_hadRead), Boolean.valueOf(a(aVar)));
            AppMethodBeat.o(127215);
            return false;
        } else {
            AppMethodBeat.o(127215);
            return true;
        }
    }

    public static boolean Ty(int i2) {
        AppMethodBeat.i(127216);
        a TF = com.tencent.mm.plugin.newtips.a.exm().TF(i2);
        if (TF == null) {
            Log.e("MicroMsg.NewTipsManager", "showDot, newTipsInfo is null !!");
            AppMethodBeat.o(127216);
            return false;
        } else if (!d(com.tencent.mm.plugin.newtips.a.exm().TF(i2)) || TF.field_tipsShowInfo == null || TF.field_tipsShowInfo.dDG != d.ADj) {
            if (TF == null) {
                Log.e("MicroMsg.NewTipsManager", "reportDismissNewTips, newTipsInfo is null !!");
            } else {
                String format = String.format("newtips_dismiss_%d-%d", Integer.valueOf(TF.field_tipId), Integer.valueOf(TF.field_tipVersion));
                if (!MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).getBoolean(format, false)) {
                    int i3 = TF.field_tipId;
                    int i4 = TF.field_tipVersion;
                    int i5 = TF.field_tipType;
                    long j2 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).getLong("newtips_gettipstime", 0);
                    long j3 = TF.field_beginShowTime;
                    long j4 = TF.field_overdueTime;
                    long j5 = TF.field_disappearTime;
                    long j6 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).getLong("newtips_realshow_time", 0);
                    long j7 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).getLong("newtips_makeread_time", 0);
                    long j8 = j7 - j6;
                    int i6 = 0;
                    long nowSecond = Util.nowSecond();
                    if (!b(TF) || !c(TF)) {
                        i6 = 1;
                    } else if (TF.field_hadRead) {
                        i6 = 4;
                    } else if (TF.field_disappearTime != 0 && nowSecond > TF.field_disappearTime) {
                        i6 = 3;
                    } else if (TF.field_overdueTime != 0 && TF.field_beginShowTime + TF.field_overdueTime <= TF.field_disappearTime && nowSecond > TF.field_beginShowTime + TF.field_overdueTime) {
                        i6 = 2;
                    }
                    h.INSTANCE.a(14995, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Integer.valueOf(i6), Integer.valueOf(TF.field_tipsShowInfo != null ? TF.field_tipsShowInfo.dDG : 0), TF.field_tipsShowInfo != null ? TF.field_tipsShowInfo.title : "", TF.field_tipsShowInfo != null ? TF.field_tipsShowInfo.qGB : "", TF.field_tipsShowInfo != null ? TF.field_tipsShowInfo.path : "", "", Integer.valueOf(d.ADq), Long.valueOf(TF.field_pagestaytime));
                    if (i5 == d.ADa) {
                        b exm = com.tencent.mm.plugin.newtips.a.exm();
                        String str = "delete from NewTipsInfo where tipId = " + TF.field_tipId;
                        Log.i("MicroMsg.NewTipsCompatInfoStorage", "delete sql: ".concat(String.valueOf(str)));
                        exm.db.execSQL("NewTipsInfo", str);
                        exm.doNotify(new StringBuilder().append(TF.field_tipId).toString(), 5, Integer.valueOf(TF.field_tipId));
                    }
                    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).edit().putBoolean(format, true).commit();
                }
            }
            AppMethodBeat.o(127216);
            return false;
        } else {
            if (TF == null) {
                Log.e("MicroMsg.NewTipsManager", "reportShowNewTips, newTipsInfo is null !!");
            } else {
                String format2 = String.format("newtips_show_%d-%d", Integer.valueOf(TF.field_tipId), Integer.valueOf(TF.field_tipVersion));
                if (!MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).getBoolean(format2, false)) {
                    int i7 = TF.field_tipId;
                    int i8 = TF.field_tipVersion;
                    int i9 = TF.field_tipType;
                    long j9 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).getLong("newtips_gettipstime", 0);
                    long nowMilliSecond = Util.nowMilliSecond();
                    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).edit().putLong("newtips_realshow_time", nowMilliSecond).commit();
                    h.INSTANCE.a(14995, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Long.valueOf(j9), "", "", "", Long.valueOf(nowMilliSecond), "", "", "", Integer.valueOf(TF.field_tipsShowInfo != null ? TF.field_tipsShowInfo.dDG : 0), TF.field_tipsShowInfo != null ? TF.field_tipsShowInfo.title : "", TF.field_tipsShowInfo != null ? TF.field_tipsShowInfo.qGB : "", TF.field_tipsShowInfo != null ? TF.field_tipsShowInfo.path : "", "", Integer.valueOf(d.ADp), "");
                    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).edit().putBoolean(format2, true).commit();
                }
            }
            AppMethodBeat.o(127216);
            return true;
        }
    }

    public static List<c> fG(List<c> list) {
        boolean exs;
        AppMethodBeat.i(127217);
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(127217);
            return arrayList;
        }
        for (c cVar : list) {
            if (cVar == null) {
                exs = false;
            } else {
                int i2 = cVar.field_tipId;
                f.exq();
                h Tz = f.Tz(i2);
                int i3 = cVar.field_path;
                f.exq();
                j jVar = f.ADu.get(Integer.valueOf(i3));
                if (jVar == null) {
                    jVar = null;
                    Log.e("MicroMsg.NewTips.NewTipsFilterPool", "Invalid pathId:%s", Integer.valueOf(i3));
                }
                if (Tz == null && jVar == null) {
                    exs = true;
                } else if (Tz == null || jVar == null) {
                    exs = Tz != null ? Tz.exs() : jVar.exs();
                } else {
                    exs = Tz.exs() && jVar.exs();
                }
            }
            if (exs) {
                arrayList.add(cVar);
            }
        }
        AppMethodBeat.o(127217);
        return arrayList;
    }
}
