package com.tencent.mm.model.d;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.bb.v;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.d.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class a implements c.a {
    private static String dlA = "";
    private static final long iHA = Looper.getMainLooper().getThread().getId();
    private static a iHv;
    private static final String iHw = (b.aKB() + "/trace/");
    private static final String iHx = (iHw + "Handler.trace");
    private static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    long[] dlF;
    private long iHB;
    private long iHC;
    private long iHD;
    private long iHE;
    private long iHF;
    private long iHG;
    private long iHH;
    private int iHI;
    private int iHJ;
    private int iHK;
    private Long[] iHL;
    private long iHM;
    private long iHN;
    private String iHO;
    private LinkedList<Object> iHP;
    private long iHy;
    private volatile boolean iHz;
    private SharedPreferences sp;

    static /* synthetic */ String Li(String str) {
        AppMethodBeat.i(179574);
        String Lh = Lh(str);
        AppMethodBeat.o(179574);
        return Lh;
    }

    static /* synthetic */ long i(a aVar) {
        long j2 = aVar.iHy;
        aVar.iHy = 1 + j2;
        return j2;
    }

    static {
        AppMethodBeat.i(20436);
        AppMethodBeat.o(20436);
    }

    private a() {
        AppMethodBeat.i(20425);
        this.dlF = new long[]{0, 0, 0};
        this.iHy = 0;
        this.iHz = false;
        this.iHB = 8000;
        this.iHC = 800;
        this.iHD = 25600;
        this.iHE = 35840;
        this.iHF = Util.MILLSECONDS_OF_DAY;
        this.iHG = 180000;
        this.iHH = 5000;
        this.iHI = 120;
        this.iHJ = 50;
        this.iHK = 1800000;
        this.sp = MMApplicationContext.getDefaultPreference();
        this.iHL = new Long[18];
        this.iHM = 0;
        this.iHN = 0;
        this.iHO = "";
        this.iHP = new LinkedList<>();
        this.iHB = this.sp.getLong("handler_debug_log_time", 8000);
        this.iHC = this.sp.getLong("handler_debug_log_time_main", 800);
        this.iHD = this.sp.getLong("handler_trace_file_full_size", 25600);
        this.iHE = this.sp.getLong("handler_log_file_max_size", 35840);
        this.iHF = this.sp.getLong("handler_upload_time_interval", Util.MILLSECONDS_OF_DAY);
        this.iHN = bg.aAk().getLooper().getThread().getId();
        Arrays.fill((Object[]) this.iHL, (Object) 0L);
        AppMethodBeat.o(20425);
    }

    public static a aXx() {
        AppMethodBeat.i(20426);
        if (iHv == null) {
            synchronized (a.class) {
                try {
                    if (iHv == null) {
                        iHv = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(20426);
                    throw th;
                }
            }
        }
        a aVar = iHv;
        AppMethodBeat.o(20426);
        return aVar;
    }

    private void h(o oVar) {
        boolean z = true;
        AppMethodBeat.i(169693);
        if (oVar.exists()) {
            this.iHz = oVar.length() > this.iHD;
            if (this.iHz) {
                long j2 = this.sp.getLong("handler_trace_log_file_full_time", 0);
                Object[] objArr = new Object[1];
                if (j2 == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                Log.i("MicroMsg.HandlerTraceManager", "has mark lastFullTime %b", objArr);
                if (j2 == 0) {
                    this.sp.edit().putLong("handler_trace_log_file_full_time", System.currentTimeMillis()).commit();
                }
                AppMethodBeat.o(169693);
                return;
            }
        } else {
            this.iHz = false;
        }
        AppMethodBeat.o(169693);
    }

    /* access modifiers changed from: package-private */
    public final String aXy() {
        String str;
        AppMethodBeat.i(20428);
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
            StatFs statFs2 = new StatFs(b.aKD());
            str = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", Integer.valueOf(((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryClass()), g.getDataDirectory().getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), b.aKD(), Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks()));
        } catch (Exception e2) {
            Log.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", e2.getMessage());
            str = "";
        }
        printStream.println("#accinfo.data=".concat(String.valueOf(str)));
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        printStream.println("#logfile.fulllast :".concat(String.valueOf(this.sp.getLong("handler_trace_log_file_full_time", 0) - this.sp.getLong("handler_trace_log_file_create_time", 0))));
        if (this.dlF[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.dlF[0] + " data size=" + this.dlF[1] + " code size=" + this.dlF[2]);
        }
        com.tencent.mm.bb.q[] tJ = v.bev().tJ(21);
        if (tJ == null || tJ.length == 0 || tJ[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + tJ[0].id + " version=" + tJ[0].version);
        }
        printStream.println("#handler.content:");
        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e3) {
        }
        AppMethodBeat.o(20428);
        return byteArrayOutputStream2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e A[SYNTHETIC, Splitter:B:12:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a A[SYNTHETIC, Splitter:B:18:0x003a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String Lh(java.lang.String r5) {
        /*
            r1 = 0
            r4 = 20429(0x4fcd, float:2.8627E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.mm.vfs.o r0 = new com.tencent.mm.vfs.o
            r0.<init>(r5)
            java.io.InputStream r2 = com.tencent.mm.vfs.s.ao(r0)     // Catch:{ IOException -> 0x002a, all -> 0x0036 }
            int r0 = r2.available()     // Catch:{ IOException -> 0x0049, all -> 0x0047 }
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0049, all -> 0x0047 }
            r2.read(r0)     // Catch:{ IOException -> 0x0049, all -> 0x0047 }
            byte[] r3 = com.tencent.mm.ci.e.cL(r0)     // Catch:{ IOException -> 0x0049, all -> 0x0047 }
            java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x0049, all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0049, all -> 0x0047 }
            if (r2 == 0) goto L_0x0026
            r2.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0026:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0029:
            return r0
        L_0x002a:
            r0 = move-exception
            r0 = r1
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ Exception -> 0x0043 }
        L_0x0031:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            r0 = r1
            goto L_0x0029
        L_0x0036:
            r0 = move-exception
            r2 = r1
        L_0x0038:
            if (r2 == 0) goto L_0x003d
            r2.close()     // Catch:{ Exception -> 0x0045 }
        L_0x003d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x0041:
            r1 = move-exception
            goto L_0x0026
        L_0x0043:
            r0 = move-exception
            goto L_0x0031
        L_0x0045:
            r1 = move-exception
            goto L_0x003d
        L_0x0047:
            r0 = move-exception
            goto L_0x0038
        L_0x0049:
            r0 = move-exception
            r0 = r2
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.d.a.Lh(java.lang.String):java.lang.String");
    }

    @Override // com.tencent.mm.model.d.c.a
    public final void aXz() {
        AppMethodBeat.i(20431);
        Log.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
        this.iHB = this.sp.getLong("handler_debug_log_time", 8000);
        this.iHC = this.sp.getLong("handler_debug_log_time_main", 800);
        this.iHD = this.sp.getLong("handler_trace_file_full_size", 25600);
        this.iHE = this.sp.getLong("handler_log_file_max_size", 35840);
        this.iHF = this.sp.getLong("handler_upload_time_interval", Util.MILLSECONDS_OF_DAY);
        this.iHG = this.sp.getLong("handler_worker_assert_time", 180000);
        this.iHH = this.sp.getLong("handler_worker_warn_time", 5000);
        this.iHI = (int) this.sp.getLong("handler_worker_warn_task_max_size", 120);
        this.iHJ = (int) this.sp.getLong("handler_worker_warn_task_keep_size", 50);
        this.iHK = (int) this.sp.getLong("handler_worker_warn_task_keep_size", 1800000);
        h(new o(iHx));
        AppMethodBeat.o(20431);
    }

    static /* synthetic */ void a(a aVar, o oVar) {
        AppMethodBeat.i(179575);
        Log.i("MicroMsg.HandlerTraceManager", "build log file ,needRecreate %b", Boolean.TRUE);
        if (oVar.exists()) {
            oVar.delete();
        }
        try {
            oVar.createNewFile();
        } catch (IOException e2) {
            Log.e("MicroMsg.HandlerTraceManager", "recreate log file fail");
        }
        SharedPreferences.Editor edit = aVar.sp.edit();
        edit.putLong("handler_trace_log_file_create_time", System.currentTimeMillis());
        edit.putLong("handler_trace_log_file_full_time", 0).commit();
        aVar.h(oVar);
        AppMethodBeat.o(179575);
    }
}
