package com.tencent.xweb.xwalk.updater;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.xweb.internal.i;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.updater.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public abstract class Scheduler {
    public static boolean SIT = false;
    static boolean SIU = false;
    c SIV;
    protected String TAG = (hvc() + "Scheduler");

    /* access modifiers changed from: protected */
    public abstract String Eu(boolean z);

    public abstract String hvc();

    public static synchronized XWebCoreScheduler Ev(boolean z) {
        XWebCoreScheduler hvW;
        synchronized (Scheduler.class) {
            if (z) {
                hvW = i.hvV();
            } else {
                hvW = XWebCoreScheduler.hvW();
            }
        }
        return hvW;
    }

    public void hvw() {
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "abandon Current Scheduler");
        e(null);
    }

    public void ati(int i2) {
    }

    public void atj(int i2) {
        if (i2 == -10) {
            SharedPreferences hvF = hvF();
            int i3 = hvF.getInt("nTryUseSharedCoreCount", 0);
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "onUpdateFailed shared mode, current nTryUseSharedCoreCount: ".concat(String.valueOf(i3)));
            int i4 = i3 + 1;
            hvJ().SJi = i4;
            SharedPreferences.Editor edit = hvF.edit();
            edit.putInt("nTryUseSharedCoreCount", i4);
            a(edit, i4);
            edit.commit();
        } else if (NetworkUtil.isNetworkAvailable()) {
            SharedPreferences hvF2 = hvF();
            int i5 = hvF2.getInt("nTryCnt", 0) + 1;
            if (i2 == -3 || i2 == -4) {
                hvJ().SJc = false;
                hvJ().SIw = hvJ().SJe;
                hvJ().SIE = false;
                e(hvJ());
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "switch to full package update");
            } else if (i2 <= -2 && i2 >= -5) {
                i5 = (int) (((long) i5) + 3);
            }
            if (((long) i5) > 3) {
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "FailedTooManytimes at this version");
                hvw();
                return;
            }
            hvJ().SJh = i5;
            SharedPreferences.Editor edit2 = hvF2.edit();
            edit2.putInt("nTryCnt", i5);
            a(edit2, i5);
            edit2.commit();
        }
    }

    private synchronized void a(SharedPreferences.Editor editor, int i2) {
        long currentTimeMillis = System.currentTimeMillis() + (((long) i2) * 7200000);
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduler update time after " + ((((long) i2) * 7200000) / Util.MILLSECONDS_OF_MINUTE) + " minute");
        editor.putLong("nTimeToUpdate", currentTimeMillis);
    }

    protected static boolean ok(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        if (str != null) {
            return str.equals(str2);
        }
        if (str != str2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(c cVar, c cVar2) {
        if (cVar.version != cVar2.version || cVar.SIE != cVar2.SIE || cVar.bUseCdn != cVar2.bUseCdn || cVar.SJc != cVar2.SJc || !ok(cVar.SID, cVar2.SID) || !ok(cVar.SJe, cVar2.SJe) || !ok(cVar.strAbi, cVar2.strAbi) || cVar.SIv != cVar2.SIv) {
            return false;
        }
        if (!cVar.SJc || ok(cVar.patchMd5, cVar2.patchMd5)) {
            return true;
        }
        return false;
    }

    public String hvx() {
        if (!hvy()) {
            return this.TAG + ":has no scheduler";
        }
        return this.TAG + ":has scheduler for ver = " + hvJ().version + " version id = " + hvJ().SIv + " update time in " + new Date(hvJ().SJf).toString() + (!TextUtils.isEmpty(hvJ().SIG) ? " update speed config:" + hvJ().SIG : "") + (!TextUtils.isEmpty(hvJ().SIH) ? " update forward speed config:" + hvJ().SIH : "") + (!TextUtils.isEmpty(hvJ().SII) ? " update time range config:" + hvJ().SII : "");
    }

    public c d(c cVar) {
        boolean z = true;
        c hvJ = hvJ();
        if (cVar == null) {
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "got no schedule need download");
            if (hvz()) {
                if (hvJ != null) {
                    XWalkInitializer.addXWalkInitializeLog(this.TAG, "clear current scheduler version = " + hvJ.version);
                }
                e(cVar);
            }
            return null;
        } else if (a(cVar, hvJ)) {
            boolean z2 = false;
            if (!ok(cVar.SIG, hvJ.SIG)) {
                hvJ.SIG = cVar.SIG;
                z2 = true;
            }
            if (!ok(cVar.SIH, hvJ.SIH)) {
                hvJ.SIH = cVar.SIH;
                z2 = true;
            }
            if (!ok(cVar.SII, hvJ.SII)) {
                hvJ.SII = cVar.SII;
            } else {
                z = z2;
            }
            if (z) {
                e(hvJ);
            }
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "got same version to scheduler, use last version ");
            return hvJ;
        } else {
            if (hvz()) {
                h.s(903, 149, 1);
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "got new scheduler replace current , version is " + cVar.version);
            }
            e(cVar);
            return cVar;
        }
    }

    public boolean hvy() {
        if (!hvz()) {
            return false;
        }
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "has scheduler for update");
        return true;
    }

    public synchronized boolean hvz() {
        boolean z;
        if (hvJ() == null || hvJ().version <= 0 || hvJ().SIw == null || hvJ().SIw.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public int hvd() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean hvA() {
        return false;
    }

    private boolean a(long j2, double d2) {
        double htS = e.htS();
        double OP = e.OP(j2);
        SIU = false;
        List<a> hvL = hvL();
        if (SIU) {
            XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse range schedule config failed");
            h.s(903, (long) (hvd() + TbsListener.ErrorCode.STARTDOWNLOAD_4), 1);
        }
        for (a aVar : hvL) {
            if (aVar.b(htS, OP, d2)) {
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "matched timerange zone cur time is " + htS + " scheduleHour is " + OP + "time range is " + aVar.v(htS, OP));
                return true;
            }
        }
        return false;
    }

    public synchronized boolean Ew(boolean z) {
        return ah(z, 0);
    }

    public synchronized boolean ah(boolean z, int i2) {
        boolean z2;
        long j2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (i2 > 2) {
            XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate abort cause depth > 2");
            z2 = false;
        } else if (!hvz()) {
            z2 = false;
        } else if (hvA() || SIT) {
            h.s(903, (long) (hvd() + 157), 1);
            z2 = true;
        } else {
            String nS = com.tencent.xweb.a.nS("DELAY_UPDATE_TIME", "tools");
            if (!TextUtils.isEmpty(nS)) {
                e.a bsC = e.bsC(nS);
                if (bsC.SEF && bsC.doubleValue() >= 0.0d && bsC.doubleValue() <= 24.0d) {
                    bsC.doubleValue();
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            double hvM = hvM();
            if (SIU) {
                XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse update speed failed");
                h.s(903, (long) (hvd() + TbsListener.ErrorCode.STARTDOWNLOAD_4), 1);
            }
            double hvN = hvN();
            if (SIU) {
                XWalkEnvironment.addXWalkInitializeLog(this.TAG, "parse update forward speed failed");
                h.s(903, (long) (hvd() + TbsListener.ErrorCode.STARTDOWNLOAD_4), 1);
            }
            long j3 = hvJ().SJf;
            boolean z6 = false;
            if (j3 > 1000) {
                j2 = j3;
                z6 = true;
            } else if (!z) {
                z2 = true;
            } else {
                long random = currentTimeMillis - ((long) (3600000.0d * Math.random()));
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "not have schedule time ,just random a time in one hour");
                h.s(903, (long) (hvd() + 155), 1);
                j2 = random;
            }
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "scheduled time is after " + ((j2 - currentTimeMillis) / Util.MILLSECONDS_OF_MINUTE) + " minutes later");
            long j4 = currentTimeMillis - j2;
            long htR = e.htR();
            long j5 = htR + currentTimeMillis;
            boolean z7 = j2 - 180000 < j5 - Util.MILLSECONDS_OF_DAY;
            boolean z8 = 180000 + j2 > j5;
            boolean z9 = htR < 180000 || htR + 180000 > Util.MILLSECONDS_OF_DAY;
            if (!z6) {
                Log.i(this.TAG, "has no scheduler , ignore dangers time ");
            } else if (z7) {
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "isPastDaySchedule need reschedule to next day ");
                hvO();
                h.s(903, 146, 1);
                z2 = ah(false, i2 + 1);
            } else if (z8) {
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "isFutureDaySchedule no need download now ");
                h.s(903, 147, 1);
                z2 = false;
            } else if (z9) {
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "dangerous time do not update");
                h.s(903, 148, 1);
                z2 = false;
            }
            if (j4 < 0 || j4 > Util.MILLSECONDS_OF_HOUR) {
                z3 = false;
            } else {
                z3 = true;
                h.s(903, (long) (hvd() + 154), 1);
            }
            if (j4 < 0 || ((double) j4) >= hvM) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (j4 >= 0 || ((double) (-j4)) >= hvN) {
                z5 = z4;
            } else {
                z5 = true;
                h.s(903, (long) (hvd() + 161), 1);
            }
            if (z3 && !z5) {
                h.s(903, (long) (hvd() + 150), 1);
            }
            if (!z3 && z5) {
                h.s(903, (long) (hvd() + 151), 1);
            }
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "shouldUpdateDefault = " + z3 + "shouldUpdateFromConfig = " + z5);
            if (z5) {
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "time to update");
                h.s(903, (long) (hvd() + 152), 1);
                z2 = true;
            } else if (hvC()) {
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "time to update because of in free update time zone");
                h.s(903, (long) (hvd() + 153), 1);
                z2 = true;
            } else if (a(j2, hvM / 1.8E7d)) {
                h.s(903, (long) (hvd() + TbsListener.ErrorCode.STARTDOWNLOAD_3), 1);
                z2 = true;
            } else {
                if (!z6 || (currentTimeMillis - hvJ().SJf <= 0 && Math.abs(currentTimeMillis - hvJ().SJf) <= 7776000000L)) {
                    XWalkInitializer.addXWalkInitializeLog(this.TAG, "has scheduler waiting for update, but time is not up");
                } else {
                    hvO();
                    h.s(903, (long) (hvd() + 156), 1);
                }
                z2 = false;
            }
        }
        return z2;
    }

    public static boolean r(double d2, double d3) {
        if (d2 < 0.0d || d2 > 24.0d || d3 < 0.0d || d3 > 24.0d || d3 < d2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public String hvf() {
        return com.tencent.xweb.a.nS("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
    }

    public boolean hvB() {
        i bsy;
        String[] bsV = bsV(hvf());
        if (bsV == null || bsV.length == 0) {
            return false;
        }
        double htS = e.htS();
        for (String str : bsV) {
            if (!TextUtils.isEmpty(str) && (bsy = i.bsy(str)) != null && htS >= bsy.SDM && htS <= bsy.SDN) {
                if (((double) XWalkEnvironment.getTodayGrayValue()) < 10000.0d * bsy.JIb) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean hvC() {
        String[] split;
        String nS = com.tencent.xweb.a.nS("free_update_time_zone", "tools");
        if (TextUtils.isEmpty(nS) || !nS.contains("-") || (split = nS.split("-")) == null || split.length != 2) {
            return false;
        }
        e.a bsC = e.bsC(split[0]);
        if (!bsC.SEF) {
            return false;
        }
        e.a bsC2 = e.bsC(split[1]);
        if (!bsC2.SEF || !r(bsC.doubleValue(), bsC2.doubleValue())) {
            return false;
        }
        double htS = e.htS();
        return htS >= bsC.doubleValue() && htS <= bsC2.doubleValue();
    }

    public static synchronized void hvD() {
        synchronized (Scheduler.class) {
            XWebCoreScheduler Ev = Ev(false);
            SharedPreferences.Editor edit = Ev.hvF().edit();
            edit.putLong("nLastFetchConfigTime", 0);
            edit.commit();
            Ev.hvJ().SJa = 0;
        }
    }

    public static synchronized void hvE() {
        synchronized (Scheduler.class) {
            XWebCoreScheduler Ev = Ev(false);
            SharedPreferences.Editor edit = Ev.hvF().edit();
            edit.putLong("nLastFetchConfigTime", 0);
            edit.commit();
            Ev.hvJ().SJa = 0;
            Ev.hvJ().SJf = 0;
        }
    }

    private SharedPreferences hvF() {
        return XWalkEnvironment.getMMKVSharedPreferences("xweb_scheduler_" + hvc());
    }

    public synchronized void e(c cVar) {
        this.SIV = cVar;
        if (cVar == null) {
            this.SIV = new c();
        }
        this.SIV.SIZ = hvc();
        SharedPreferences.Editor edit = hvF().edit();
        edit.putString("strMd5", this.SIV.SID);
        edit.putString("strUrl", this.SIV.SIw);
        edit.putString("strFullPackageUrl", this.SIV.SJe);
        edit.putString("strConfigVer", this.SIV.SIJ);
        edit.putBoolean("bIsPatchUpdate", this.SIV.SJc);
        edit.putBoolean("bCanUseCellular", this.SIV.SIE);
        edit.putBoolean("bUseCdn", this.SIV.bUseCdn);
        edit.putLong("nTimeToUpdate", this.SIV.SJf);
        edit.putInt("version", this.SIV.version);
        edit.putInt("nTryCnt", this.SIV.SJh);
        edit.putInt("nPatchTargetVersion", this.SIV.nPatchTargetVersion);
        edit.putInt("nTryUseSharedCoreCount", this.SIV.SJi);
        edit.putString("patchMd5", this.SIV.patchMd5);
        edit.putString("strVersionDetail", this.SIV.SJg);
        edit.putBoolean("bTryUseSharedCore", this.SIV.bTryUseSharedCore);
        edit.putBoolean("skipSubFileMD5Check", this.SIV.SJl);
        edit.putString("strAbi", this.SIV.strAbi);
        edit.putString("path", this.SIV.path);
        edit.putInt("versionId", this.SIV.SIv);
        edit.putFloat("timeHourStart", this.SIV.SJj);
        edit.putFloat("timeHourEnd", this.SIV.SJk);
        edit.putString("UPDATE_SPEED_CONFIG", this.SIV.SIG);
        edit.putString("UPDATE_FORWARD_SPEED_CONFIG", this.SIV.SIH);
        edit.putString("UPDATE_SCHEDULE_TIME_RANGE_BIND", this.SIV.SII);
        edit.commit();
    }

    public void hvG() {
        hvJ().SJa = System.currentTimeMillis();
        hvJ().SJb = XWalkEnvironment.getRuntimeAbi();
        SharedPreferences.Editor edit = hvF().edit();
        edit.putLong("nLastFetchConfigTime", hvJ().SJa);
        edit.putString("strLastFetchAbi", hvJ().SJb);
        edit.commit();
    }

    private static boolean OZ(long j2) {
        if (j2 < 1800000 || j2 >= 259200000) {
            return false;
        }
        return true;
    }

    public static long hvH() {
        long av = ((long) com.tencent.xweb.a.hsb().av("force_cmd_period", "tools", 0)) * Util.MILLSECONDS_OF_MINUTE;
        if (OZ(av)) {
            return av;
        }
        long configFetchPeriod = XWalkEnvironment.getConfigFetchPeriod();
        if (OZ(configFetchPeriod)) {
            return configFetchPeriod;
        }
        long hsg = (long) com.tencent.xweb.a.hsg();
        return !OZ(hsg) ? Util.MILLSECONDS_OF_DAY : hsg;
    }

    private boolean aK(long j2, long j3) {
        long hvH = hvH();
        if (j2 > j3 + hvH || hvH + j2 < j3) {
            return true;
        }
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "the most recent time to fetch config is too close");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        if (com.facebook.internal.ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(com.tencent.xweb.b.nS("disable_abi_switch_reset_config_time", "tools")) == false) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean hvI() {
        /*
        // Method dump skipped, instructions count: 147
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.updater.Scheduler.hvI():boolean");
    }

    public synchronized c hvJ() {
        c cVar;
        if (this.SIV != null) {
            cVar = this.SIV;
        } else {
            this.SIV = new c();
            this.SIV.SIZ = hvc();
            SharedPreferences hvF = hvF();
            this.SIV.SJa = hvF.getLong("nLastFetchConfigTime", 0);
            this.SIV.SJb = hvF.getString("strLastFetchAbi", "");
            if (!hvF.contains("strUrl")) {
                cVar = this.SIV;
            } else {
                this.SIV.SID = hvF.getString("strMd5", "");
                this.SIV.SIv = hvF.getInt("versionId", 0);
                this.SIV.SJj = hvF.getFloat("timeHourStart", -1.0f);
                this.SIV.SJk = hvF.getFloat("timeHourEnd", -1.0f);
                this.SIV.SIw = hvF.getString("strUrl", "");
                this.SIV.SJe = hvF.getString("strFullPackageUrl", "");
                this.SIV.SIJ = hvF.getString("strConfigVer", "");
                this.SIV.SJc = hvF.getBoolean("bIsPatchUpdate", false);
                this.SIV.SJf = hvF.getLong("nTimeToUpdate", 0);
                this.SIV.version = hvF.getInt("version", 0);
                this.SIV.SJh = hvF.getInt("nTryCnt", 0);
                this.SIV.nPatchTargetVersion = hvF.getInt("nPatchTargetVersion", 0);
                this.SIV.SJi = hvF.getInt("nTryUseSharedCoreCount", 0);
                this.SIV.patchMd5 = hvF.getString("patchMd5", "");
                this.SIV.SJg = hvF.getString("strVersionDetail", "");
                this.SIV.SIE = hvF.getBoolean("bCanUseCellular", false);
                this.SIV.bUseCdn = hvF.getBoolean("bUseCdn", false);
                this.SIV.bTryUseSharedCore = hvF.getBoolean("bTryUseSharedCore", true);
                this.SIV.SJl = hvF.getBoolean("skipSubFileMD5Check", true);
                this.SIV.strAbi = hvF.getString("strAbi", "");
                this.SIV.path = hvF.getString("path", "");
                this.SIV.SIG = hvF.getString("UPDATE_SPEED_CONFIG", "");
                this.SIV.SIH = hvF.getString("UPDATE_FORWARD_SPEED_CONFIG", "");
                this.SIV.SII = hvF.getString("UPDATE_SCHEDULE_TIME_RANGE_BIND", "");
                cVar = this.SIV;
            }
        }
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public i SIX = new i();
        public i SIY = new i();

        a() {
            AppMethodBeat.i(207349);
            AppMethodBeat.o(207349);
        }

        public final boolean b(double d2, double d3, double d4) {
            AppMethodBeat.i(207350);
            if (d3 > this.SIX.SDN || d3 < this.SIX.SDM) {
                AppMethodBeat.o(207350);
                return false;
            } else if (d2 > this.SIY.SDN || d2 < this.SIY.SDM) {
                AppMethodBeat.o(207350);
                return false;
            } else if (((double) XWalkEnvironment.getTodayGrayValueByKey("DOWNLOAD_SCHEDULE")) <= u(d2, d3) * 10000.0d * d4) {
                AppMethodBeat.o(207350);
                return true;
            } else {
                AppMethodBeat.o(207350);
                return false;
            }
        }

        public final double u(double d2, double d3) {
            AppMethodBeat.i(207351);
            double H = this.SIX.H(d3) * this.SIY.H(d2);
            AppMethodBeat.o(207351);
            return H;
        }

        public final String v(double d2, double d3) {
            AppMethodBeat.i(207352);
            String str = "[ " + this.SIX.SDM + "," + this.SIX.SDN + "] => [" + this.SIY.SDM + "," + this.SIY.SDN + "],scale=" + u(d2, d3);
            AppMethodBeat.o(207352);
            return str;
        }
    }

    /* access modifiers changed from: protected */
    public String hve() {
        return com.tencent.xweb.a.nS("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
    }

    private String hvK() {
        if (!TextUtils.isEmpty(hvJ().SII)) {
            return hvJ().SII;
        }
        return hve();
    }

    private List<a> hvL() {
        ArrayList arrayList = new ArrayList();
        String hvK = hvK();
        if (!TextUtils.isEmpty(hvK)) {
            String[] split = hvK.split(";");
            if (split == null || split.length == 0) {
                SIU = true;
            } else {
                e.htS();
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        a bsU = bsU(str);
                        if (bsU == null) {
                            SIU = true;
                        } else {
                            arrayList.add(bsU);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public double hvM() {
        SIU = false;
        return bsT(Ex(false)) * 3600000.0d;
    }

    public final String Ex(boolean z) {
        if (z && !TextUtils.isEmpty(hvJ().SIH)) {
            return hvJ().SIH;
        }
        if (z || TextUtils.isEmpty(hvJ().SIG)) {
            return Eu(z);
        }
        return hvJ().SIG;
    }

    public double hvN() {
        SIU = false;
        return bsT(Ex(true)) * 3600000.0d;
    }

    public static double bsT(String str) {
        return e(str, e.htS());
    }

    public static double e(String str, double d2) {
        i bsy;
        if (TextUtils.isEmpty(str)) {
            return 1.0d;
        }
        String[] bsV = bsV(str);
        if (bsV == null || bsV.length == 0) {
            SIU = true;
            return 1.0d;
        }
        for (String str2 : bsV) {
            if (!TextUtils.isEmpty(str2) && (bsy = i.bsy(str2)) != null && d2 >= bsy.SDM && d2 <= bsy.SDN) {
                return bsy.H(d2);
            }
        }
        return 1.0d;
    }

    private static a bsU(String str) {
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.trim().replace("=>", "_").split("_");
        if (split == null || split.length != 2) {
            Log.e("getTimeRangePairItem", "strRanges error");
            return null;
        }
        aVar.SIX = i.bsy(split[0]);
        if (aVar.SIX == null) {
            Log.e("getTimeRangePairItem", "parse rangefrom failed");
            return null;
        }
        aVar.SIY = i.bsy(split[1]);
        if (aVar.SIY != null) {
            return aVar;
        }
        Log.e("getTimeRangePairItem", "parse rangeTo failed");
        return null;
    }

    private static String[] bsV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(";");
    }

    public static double a(double d2, double d3, double d4) {
        if (d2 > d4 || d4 < d3) {
            Log.e("Scheduler", "srandTime cur hour is bigger than endhour ");
            return 0.0d;
        }
        if (d3 >= d2) {
            d2 = d3;
        }
        return (Math.random() * (d4 - d2)) + d2;
    }

    public static double J(double d2) {
        if (d2 < 0.0d || d2 > 24.0d) {
            return 0.0d;
        }
        return d2;
    }

    public static double s(double d2, double d3) {
        if (d3 < d2) {
            return 24.0d;
        }
        if (d3 < 0.0d || d3 > 32.0d) {
            return 24.0d;
        }
        return d3;
    }

    public void hvO() {
        long j2;
        double htS = e.htS();
        if (htS < ((double) hvJ().SJj) || htS < 6.0d) {
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay: cur hour is " + htS + ", so still schedule in today");
            j2 = -((long) (htS * 3600000.0d));
        } else {
            j2 = e.htR();
        }
        long a2 = (long) ((a(0.0d, J((double) hvJ().SJj), s((double) hvJ().SJj, (double) hvJ().SJk)) * 3600000.0d) + ((double) j2));
        hvJ().SJf = System.currentTimeMillis() + a2;
        e(hvJ());
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay: " + (a2 / Util.MILLSECONDS_OF_MINUTE) + " minutes later");
    }

    public static long a(a.C2237a aVar, String str) {
        int i2;
        long j2 = 0;
        if (!TextUtils.isEmpty(aVar.SIz)) {
            long b2 = b(aVar, str);
            XWalkInitializer.addXWalkInitializeLog(str + " schedul after " + ((b2 / 60) / 1000) + " minute to update");
            return b2 + System.currentTimeMillis();
        } else if (aVar.SIC > 0) {
            long j3 = (long) (aVar.SIC * 60 * 1000);
            if (0 != j3) {
                int i3 = (aVar.SCE.SCU <= 0 || aVar.SCE.SCU > 10000) ? 0 : aVar.SCE.SCU;
                if (aVar.SCE.SCV <= 0 || aVar.SCE.SCV > 10000) {
                    i2 = 10000;
                } else {
                    i2 = aVar.SCE.SCV;
                }
                int i4 = (i2 - i3) + 1;
                if (i4 <= 0) {
                    i4 = 1;
                }
                double grayValue = ((double) (((long) (XWalkEnvironment.getGrayValue() - i3)) * j3)) / ((double) i4);
                j2 = (long) ((((((double) (j3 * ((long) ((XWalkEnvironment.getGrayValue() + 1) - i3)))) / ((double) i4)) - grayValue) * Math.random()) + grayValue);
            }
            XWalkInitializer.addXWalkInitializeLog(str + " schedul after " + ((j2 / 60) / 1000) + " minute to update");
            return j2 + System.currentTimeMillis();
        } else {
            XWalkInitializer.addXWalkInitializeLog(str + " no schedule time");
            return 100;
        }
    }

    private static boolean t(double d2, double d3) {
        if (Math.abs(d2 - d3) < 1.0E-5d) {
            return true;
        }
        return false;
    }

    public boolean a(Calendar calendar, Calendar calendar2, boolean z, boolean z2, boolean z3) {
        long timeInMillis = calendar.getTimeInMillis();
        long timeInMillis2 = calendar2.getTimeInMillis();
        long c2 = e.c(calendar);
        long j2 = c2 + timeInMillis;
        boolean z4 = timeInMillis2 - 180000 < j2 - Util.MILLSECONDS_OF_DAY;
        boolean z5 = 180000 + timeInMillis2 > j2;
        boolean z6 = c2 < 180000 || 180000 + c2 > Util.MILLSECONDS_OF_DAY;
        if (z4 == z && z5 == z2 && z6 == z3) {
            return true;
        }
        return false;
    }

    public boolean hvP() {
        Calendar instance = Calendar.getInstance();
        instance.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 13, 17, 30);
        if (!t(e.OP(instance.getTimeInMillis()), 17.5d)) {
            Log.e(this.TAG, "unitTestRangeSchedule error 0");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(currentTimeMillis);
        instance2.set(13, 0);
        if (e.htR() != e.c(instance2)) {
            Log.e(this.TAG, "unitest Time to next day error 0");
            return false;
        }
        Calendar instance3 = Calendar.getInstance();
        instance3.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 13, 23, 59, 1);
        Calendar instance4 = Calendar.getInstance();
        instance4.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 13, 0, 1);
        if (!a(instance3, instance4, true, false, true)) {
            Log.e(this.TAG, "unitTestDangerousTime error 0");
            return false;
        }
        instance3.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 0, 2, 59);
        if (!a(instance3, instance4, true, false, true)) {
            Log.e(this.TAG, "unitTestDangerousTime error 1");
            return false;
        }
        instance3.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 0, 2, 59);
        instance4.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 0, 1);
        if (!a(instance3, instance4, true, false, true)) {
            Log.e(this.TAG, "unitTestDangerousTime error 2");
            return false;
        }
        instance3.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 0, 3, 1);
        instance4.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 23, 59);
        if (!a(instance3, instance4, false, true, false)) {
            Log.e(this.TAG, "unitTestDangerousTime error 3");
            return false;
        }
        instance3.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 23, 57, 1);
        instance4.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 23, 59);
        if (!a(instance3, instance4, false, true, true)) {
            Log.e(this.TAG, "unitTestDangerousTime error 4");
            return false;
        }
        instance3.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 23, 56, 59);
        instance4.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 23, 59);
        if (!a(instance3, instance4, false, true, false)) {
            Log.e(this.TAG, "unitTestDangerousTime error 5");
            return false;
        }
        instance3.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 23, 56, 59);
        instance4.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 22, 59);
        if (!a(instance3, instance4, false, false, false)) {
            Log.e(this.TAG, "unitTestDangerousTime error 6");
            return false;
        }
        List<a> hvL = new Scheduler() {
            /* class com.tencent.xweb.xwalk.updater.Scheduler.AnonymousClass1 */

            @Override // com.tencent.xweb.xwalk.updater.Scheduler
            public final String hvc() {
                return "UNITEST";
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.xweb.xwalk.updater.Scheduler
            public final String Eu(boolean z) {
                return "18:00-20:00=>0:00-3:00=0.5-0.6-0.7-0.8;20:00-21:00=>3-5=0.5-0.6-0.7-0.8;15.5-17.5=>3.5-5.5=0.5";
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.xweb.xwalk.updater.Scheduler
            public final String hve() {
                return "18:00-20:00(0.5-0.6-0.7-1)=>0:00-3:00(0-1); 20:00 - 21:00(0.5-0.6-0.7) => 3-5(0-0.5); 15.5-17.5(0.5)=>3.5-5.5";
            }
        }.hvL();
        if (hvL.size() != 3) {
            Log.e(this.TAG, "unitTestRangeSchedule error 1");
            return false;
        }
        hvL.get(0).v(1.5d, 19.0d);
        if (!t(hvL.get(0).u(1.5d, 19.0d), 0.325d)) {
            Log.e(this.TAG, "unitTestRangeSchedule error 2");
            return false;
        }
        XWalkEnvironment.sNDeviceRd = 3249;
        if (!hvL.get(0).b(1.5d, 19.0d, 1.0d)) {
            Log.e(this.TAG, "unitTestRangeSchedule error 3");
            return false;
        }
        XWalkEnvironment.sNDeviceRd = 3250;
        if (hvL.get(0).b(1.5d, 19.0d, 1.0d)) {
            Log.e(this.TAG, "unitTestRangeSchedule error 4");
            return false;
        }
        XWalkEnvironment.sNDeviceRd = 9899;
        if (!t(hvL.get(0).u(3.0d, 20.0d), 1.0d)) {
            Log.e(this.TAG, "unitTestRangeSchedule error 5 ");
            return false;
        }
        XWalkEnvironment.sNDeviceRd = 5000;
        if (hvL.get(2).b(3.9d, 17.0d, 1.0d)) {
            Log.e(this.TAG, "unitTestRangeSchedule error 6");
            return false;
        }
        XWalkEnvironment.sNDeviceRd = 4998;
        if (!hvL.get(2).b(3.9d, 17.0d, 1.0d)) {
            Log.e(this.TAG, "unitTestRangeSchedule error 7");
            return false;
        }
        XWalkEnvironment.sNDeviceRd = 1499;
        if (!hvL.get(1).b(4.0d, 20.5d, 1.0d)) {
            Log.e(this.TAG, "unitTestRangeSchedule error 8");
            return false;
        }
        XWalkEnvironment.sNDeviceRd = 1500;
        if (hvL.get(1).b(4.0d, 20.5d, 1.0d)) {
            Log.e(this.TAG, "unitTestRangeSchedule error 9");
            return false;
        }
        XWalkEnvironment.sNDeviceRd = 1499;
        if (a(4, 20.5d)) {
            Log.e(this.TAG, "unitTestRangeSchedule error 10");
            return false;
        }
        XWalkEnvironment.sNDeviceRd = 1500;
        if (a(4, 20.5d)) {
            Log.e(this.TAG, "unitTestRangeSchedule error 11");
            return false;
        }
        Log.e(this.TAG, "unitTestRangeSchedule pass");
        return true;
    }

    public static double a(double d2, double d3, double d4, List<a> list) {
        double d5 = 0.0d;
        for (a aVar : list) {
            d5 = aVar.u(d2, d3) * d4;
            if (d5 <= d5) {
                d5 = d5;
            }
        }
        return d5;
    }

    public static boolean hvQ() {
        AnonymousClass2 r20 = new Scheduler() {
            /* class com.tencent.xweb.xwalk.updater.Scheduler.AnonymousClass2 */

            @Override // com.tencent.xweb.xwalk.updater.Scheduler
            public final String hvc() {
                return "UNITEST";
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.xweb.xwalk.updater.Scheduler
            public final String Eu(boolean z) {
                return "0:59-1:01-0.9;2:59-3:01-0.9;3:59-4:01-0.9;4:59-5:01-0.9;5:29-5:31-0.9;5:59-6:01-0.9;6:29-6:31-0.9;6:59-7:01-0.9;7:29-7:31-0.9;7:59-8:01-0.9;0:00-6:00(1.636806683-2.276643146-2.927125626-4.16300461-4.55588817-5.203755763-5.20765858-5.528990498-5.854745609-6.309553862-6.180110438-5.203755763-4.228129614);6:00-8:00(1.037712038-1.297503247-1.297140048-0.004150848);0-24-5";
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.xweb.xwalk.updater.Scheduler
            public final String hve() {
                return "6:00-24:00(0.53871206-0.533307-0.53308-0.533309-0.53334-0.533011-0.533012-0.533013-0.533014-0.533015-0.533016-0.70017-0.723018-0.750019-0.7502-0.75021-0.753022-0.533023-0.533024) => 0:00-8:00(1)";
            }
        };
        Calendar instance = Calendar.getInstance();
        instance.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 0, 0, 0);
        List<a> hvL = r20.hvL();
        Calendar instance2 = Calendar.getInstance();
        instance2.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 0, 58, 5);
        double d2 = e.d(instance2);
        a(d2, 21.0d, e(r20.Ex(false), d2) / 5.0d, hvL);
        SIU = false;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS);
        double d3 = 0.0d;
        while (((double) instance.get(10)) <= 8.0d) {
            double d4 = e.d(instance);
            double e2 = e(r20.Ex(false), d4) / 5.0d;
            double d5 = 0.0d;
            Calendar instance3 = Calendar.getInstance();
            instance3.set(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES, 6, 15, 6, 30, 0);
            while (true) {
                d3 = d5;
                if (instance3.get(5) >= 16) {
                    break;
                }
                d5 = (a(d4, e.d(instance3), e2, hvL) * 10000.0d) + d3;
                instance3.add(12, 30);
            }
            String format = simpleDateFormat.format(instance.getTime());
            if (d3 != 0.0d) {
                Math.abs((d3 - d3) / d3);
            }
            Log.e("andrewu", "rate\t" + d3 + "\ttime\t" + format);
            instance.add(13, 1);
        }
        Log.e("andrewu", "sParseScheduleConfigFailed = " + SIU);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long b(com.tencent.xweb.xwalk.updater.a.C2237a r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 501
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.updater.Scheduler.b(com.tencent.xweb.xwalk.updater.a$a, java.lang.String):long");
    }
}
