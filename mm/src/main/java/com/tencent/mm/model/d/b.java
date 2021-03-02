package com.tencent.mm.model.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.bb.v;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.d.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class b implements c.a {
    private static b iHR;
    public static final String iHS = (com.tencent.mm.loader.j.b.aKB() + "/trace/");
    public static List<String> iIc = Arrays.asList("FTS5IndexMicroMsg_encrypt.db");
    public static List<String> iId = Arrays.asList("rcontact");
    private static Boolean iIe = null;
    long[] dlF = {0, 0, 0};
    public long iHT;
    public long iHU;
    public long iHV;
    public long iHW;
    public long iHX;
    private long iHY;
    private long iHZ;
    private long iHy = 0;
    public volatile boolean iHz = false;
    private long iIa;
    private long iIb;
    private SharedPreferences sp = MMApplicationContext.getDefaultPreference();

    static /* synthetic */ String Lk(String str) {
        AppMethodBeat.i(20460);
        String Lh = Lh(str);
        AppMethodBeat.o(20460);
        return Lh;
    }

    static /* synthetic */ void a(b bVar, o oVar) {
        AppMethodBeat.i(169701);
        bVar.a(oVar, true);
        AppMethodBeat.o(169701);
    }

    static /* synthetic */ long i(b bVar) {
        long j2 = bVar.iHy;
        bVar.iHy = 1 + j2;
        return j2;
    }

    static {
        AppMethodBeat.i(20462);
        AppMethodBeat.o(20462);
    }

    public static b aXA() {
        AppMethodBeat.i(20440);
        if (iHR == null) {
            iHR = new b();
        }
        b bVar = iHR;
        AppMethodBeat.o(20440);
        return bVar;
    }

    public b() {
        AppMethodBeat.i(20441);
        aXB();
        AppMethodBeat.o(20441);
    }

    private void aXB() {
        AppMethodBeat.i(20442);
        this.iHT = this.sp.getLong("sql_trace_main_thread_select_interval_time", 300);
        this.iHU = this.sp.getLong("sql_trace_main_thread_update_interval_time", 500);
        this.iHV = this.sp.getLong("sql_trace_select_interval_frozen_time", 1000);
        this.iHW = this.sp.getLong("sql_trace_child_thread_interval_time", 1500);
        long cT = cT(MMApplicationContext.getContext());
        if (cT > 0) {
            this.iHT += cT;
            this.iHU += cT;
            this.iHW += cT;
            this.iHV += cT;
            Log.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", Long.valueOf(cT));
        }
        this.iHX = this.sp.getLong("sql_trace_child_transaction_interval_time", 5000);
        this.iIb = this.sp.getLong("sql_trace_file_full_size", 30720);
        this.iHY = this.sp.getLong("sql_trace_log_file_max_size", 35840);
        this.iHZ = this.sp.getLong("sql_trace_upload_file_min_size", 10240);
        this.iIa = this.sp.getLong("sql_upload_time_interval", 21600000);
        h(new o(iHS, "MMSQL.trace"));
        Log.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", Long.valueOf(this.iHT), Long.valueOf(this.iHU), Long.valueOf(this.iHW), Long.valueOf(this.iHX), Long.valueOf(this.iIb), Long.valueOf(this.iHY), Long.valueOf(this.iHZ), Long.valueOf(this.iIa));
        AppMethodBeat.o(20442);
    }

    public static void setup() {
        AppMethodBeat.i(20443);
        if (MMApplicationContext.sIsRevChange) {
            Log.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: ".concat(String.valueOf(s.deleteFile(iHS + "MMSQL.trace"))));
        }
        AppMethodBeat.o(20443);
    }

    private void h(o oVar) {
        boolean z = true;
        AppMethodBeat.i(169696);
        if (oVar.exists()) {
            this.iHz = oVar.length() > this.iIb;
            if (this.iHz) {
                long cS = cS(MMApplicationContext.getContext());
                Object[] objArr = new Object[1];
                if (cS == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                Log.i("MicroMsg.SQLTraceManager", "has mark lastFullTime %b", objArr);
                if (cS == 0) {
                    e(MMApplicationContext.getContext(), System.currentTimeMillis());
                }
                AppMethodBeat.o(169696);
                return;
            }
        } else {
            this.iHz = false;
        }
        AppMethodBeat.o(169696);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[SYNTHETIC, Splitter:B:14:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055 A[SYNTHETIC, Splitter:B:22:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String Lh(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 110
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.d.b.Lh(java.lang.String):java.lang.String");
    }

    private static long a(String str, h hVar) {
        AppMethodBeat.i(20446);
        Cursor rawQuery = hVar.rawQuery("select count(*) from ".concat(String.valueOf(str)), null, 2);
        long j2 = 0;
        if (rawQuery.moveToFirst()) {
            j2 = rawQuery.getLong(0);
        }
        rawQuery.close();
        AppMethodBeat.o(20446);
        return j2;
    }

    private String aXy() {
        String str;
        AppMethodBeat.i(20447);
        String aoG = q.aoG();
        String string = p.getString(aoG.hashCode());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.println("#client.version=" + d.KyO);
        printStream.println("#accinfo.revision=" + BuildInfo.REV);
        printStream.println("#accinfo.uin=" + bf.iDu.aA(WXUtil.LAST_LOGIN_UIN, string));
        printStream.println("#accinfo.dev=".concat(String.valueOf(aoG)));
        printStream.println("#accinfo.build=" + BuildInfo.TIME + ":" + BuildInfo.HOSTNAME + ":" + ChannelUtil.channelId);
        try {
            StatFs statFs = new StatFs(g.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.loader.j.b.aKD());
            str = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", Integer.valueOf(((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryClass()), g.getDataDirectory().getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), com.tencent.mm.loader.j.b.aKD(), Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks()));
        } catch (Exception e2) {
            Log.e("MicroMsg.SQLTraceManager", "check data size failed :%s", e2.getMessage());
            str = "";
        }
        printStream.println("#accinfo.data=".concat(String.valueOf(str)));
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        long cT = cT(MMApplicationContext.getContext());
        if (cT > 0) {
            printStream.println("#logfile.autoAdapteTime :".concat(String.valueOf(cT)));
        }
        if (cS(MMApplicationContext.getContext()) != 0) {
            long cS = cS(MMApplicationContext.getContext()) - cR(MMApplicationContext.getContext());
            printStream.println("#logfile.fulllast :".concat(String.valueOf(cS)));
            if (cS > 0 && cS < 28800000) {
                long j2 = cT + 100;
                PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", j2).commit();
                Log.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", Long.valueOf(j2));
                aXB();
            }
        } else {
            printStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - cR(MMApplicationContext.getContext())));
        }
        com.tencent.mm.bb.q[] tJ = v.bev().tJ(21);
        if (tJ == null || tJ.length == 0 || tJ[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + tJ[0].id + " version=" + tJ[0].version);
        }
        if (this.dlF[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.dlF[0] + " data size= " + this.dlF[1] + " code size =" + this.dlF[2]);
        }
        StringBuilder sb = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        bg.aVF();
        printStream.println(sb.append(new o(com.tencent.mm.model.c.azO()).length()).toString());
        StringBuilder sb2 = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        StringBuilder sb3 = new StringBuilder();
        bg.aVF();
        printStream.println(sb2.append(new o(sb3.append(com.tencent.mm.model.c.azM()).append("SnsMicroMsg.db").toString()).length()).toString());
        bg.aVF();
        a(com.tencent.mm.model.c.aSL(), printStream, Arrays.asList("message", "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo"));
        printStream.println("#sql.content:");
        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e3) {
        }
        AppMethodBeat.o(20447);
        return byteArrayOutputStream2;
    }

    private static void a(h hVar, PrintStream printStream, List<String> list) {
        AppMethodBeat.i(20448);
        if (hVar == null || !hVar.isOpen()) {
            Log.i("MicroMsg.SQLTraceManager", "db is not open!");
            AppMethodBeat.o(20448);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            Cursor rawQuery = hVar.rawQuery("select name from sqlite_master where type='table' ", null, 2);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                printStream.println("#table : " + string + " count=" + a(string, hVar));
            }
            rawQuery.close();
        } else {
            for (String str : list) {
                printStream.println("#table : " + str + " count=" + a(str, hVar));
            }
        }
        Log.i("MicroMsg.SQLTraceManager", "dump all table count last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(20448);
    }

    public static void a(String str, String str2, StringBuilder sb) {
        AppMethodBeat.i(20449);
        sb.append(str).append(":").append(str2).append(" ");
        AppMethodBeat.o(20449);
    }

    public final void Lj(String str) {
        AppMethodBeat.i(20450);
        if (str == null) {
            str = "";
        }
        Intent intent = new Intent();
        intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionPid", Process.myPid());
        intent.putExtra("userName", Wv());
        intent.putExtra("tag", "SqlTrace");
        intent.putExtra("exceptionMsg", Base64.encodeToString((aXy() + str).getBytes(), 2));
        MMApplicationContext.getContext().sendBroadcast(intent);
        AppMethodBeat.o(20450);
    }

    private static String Wv() {
        AppMethodBeat.i(20451);
        String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
        if (Util.isNullOrNil(aA)) {
            aA = bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "never_login_crash");
        }
        AppMethodBeat.o(20451);
        return aA;
    }

    public final void aV(String str, String str2) {
        AppMethodBeat.i(169697);
        if (!e.apn()) {
            Log.i("MicroMsg.SQLTraceManager", "sdcard is not  Available,appendToFile fail ");
            AppMethodBeat.o(169697);
            return;
        }
        try {
            o oVar = new o(iHS);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            a(new o(iHS, "MMSQL.trace"), false);
        } catch (Exception e2) {
            Log.e("MicroMsg.SQLTraceManager", "init dir fail");
        }
        o oVar2 = new o(str);
        if (oVar2.length() > this.iHY) {
            Log.e("MicroMsg.SQLTraceManager", "log file invaild foramt,recreate");
            a(oVar2, true);
        }
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = s.dB(str, true);
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(com.tencent.mm.ci.e.cL(str2.getBytes()));
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                }
            }
        } catch (IOException e4) {
            Log.printErrStackTrace("MicroMsg.SQLTraceManager", e4, "appendToFile fail with exception", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e5) {
                    Log.printErrStackTrace("MicroMsg.SQLTraceManager", e5, "appendToFile fail with exception", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e6) {
                    Log.printErrStackTrace("MicroMsg.SQLTraceManager", e6, "appendToFile fail with exception", new Object[0]);
                }
            }
            AppMethodBeat.o(169697);
            throw th;
        }
        h(new o(iHS + "MMSQL.trace"));
        AppMethodBeat.o(169697);
    }

    private void a(o oVar, boolean z) {
        AppMethodBeat.i(169698);
        Log.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", Boolean.valueOf(z));
        if (oVar.exists()) {
            if (z) {
                oVar.delete();
            }
            h(oVar);
            AppMethodBeat.o(169698);
        }
        i(oVar);
        h(oVar);
        AppMethodBeat.o(169698);
    }

    private static void i(o oVar) {
        AppMethodBeat.i(169699);
        try {
            oVar.createNewFile();
            d(MMApplicationContext.getContext(), System.currentTimeMillis());
            e(MMApplicationContext.getContext(), 0);
            AppMethodBeat.o(169699);
        } catch (IOException e2) {
            Log.e("MicroMsg.SQLTraceManager", "recreate log file fail");
            AppMethodBeat.o(169699);
        }
    }

    public static void c(Context context, long j2) {
        AppMethodBeat.i(20453);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_report_lastUploadTime", j2).commit();
        AppMethodBeat.o(20453);
    }

    public static long cQ(Context context) {
        AppMethodBeat.i(20454);
        long j2 = PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_report_lastUploadTime", 0);
        AppMethodBeat.o(20454);
        return j2;
    }

    private static void d(Context context, long j2) {
        AppMethodBeat.i(169700);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_create_time", j2).commit();
        AppMethodBeat.o(169700);
    }

    private static long cR(Context context) {
        AppMethodBeat.i(20455);
        long j2 = PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_create_time", 0);
        AppMethodBeat.o(20455);
        return j2;
    }

    private static void e(Context context, long j2) {
        AppMethodBeat.i(20456);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_full_time", j2).commit();
        AppMethodBeat.o(20456);
    }

    private static long cS(Context context) {
        AppMethodBeat.i(20457);
        long j2 = PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_full_time", 0);
        AppMethodBeat.o(20457);
        return j2;
    }

    private static long cT(Context context) {
        AppMethodBeat.i(20458);
        long j2 = PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_autoAdaptaTime", 0);
        AppMethodBeat.o(20458);
        return j2;
    }

    public static boolean aXC() {
        AppMethodBeat.i(231539);
        if (iIe == null) {
            try {
                iIe = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sql_frozen_mode_on, false));
                Log.i("MicroMsg.SQLTraceManager", "isSQLFrozenTraceOn!!");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SQLTraceManager", e2, "isSQLFrozenTraceOn", new Object[0]);
                iIe = Boolean.FALSE;
            }
        }
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            iIe = Boolean.TRUE;
        }
        boolean booleanValue = iIe.booleanValue();
        AppMethodBeat.o(231539);
        return booleanValue;
    }

    @Override // com.tencent.mm.model.d.c.a
    public final void aXz() {
        AppMethodBeat.i(20459);
        Log.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
        aXB();
        AppMethodBeat.o(20459);
    }
}
