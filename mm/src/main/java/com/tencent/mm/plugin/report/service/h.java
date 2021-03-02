package com.tencent.mm.plugin.report.service;

import android.content.SharedPreferences;
import android.util.Pair;
import com.tencent.mars.Mars;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.s;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.ai;
import com.tencent.mm.protocal.protobuf.ak;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public enum h implements d {
    INSTANCE;
    
    private long CyG = 0;
    private int CyH;
    public List<Pair<Long, Long>> CyI = new LinkedList();
    private HashMap<String, Long> CyJ;
    private int CyK;
    private int CyL;
    private long CyM;
    private volatile boolean CyN;
    private int uin;

    public static h valueOf(String str) {
        AppMethodBeat.i(143874);
        h hVar = (h) Enum.valueOf(h.class, str);
        AppMethodBeat.o(143874);
        return hVar;
    }

    static {
        AppMethodBeat.i(143908);
        AppMethodBeat.o(143908);
    }

    private h(String str) {
        AppMethodBeat.i(143875);
        if (MMApplicationContext.isMMProcess()) {
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.report.service.h.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(143864);
                    h.a(h.this);
                    AppMethodBeat.o(143864);
                }
            });
            final AnonymousClass2 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.report.service.h.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(143865);
                    h.b(h.this);
                    AppMethodBeat.o(143865);
                }
            };
            EventCenter.instance.add(new IListener<ps>() {
                /* class com.tencent.mm.plugin.report.service.h.AnonymousClass3 */

                {
                    AppMethodBeat.i(160987);
                    this.__eventId = ps.class.getName().hashCode();
                    AppMethodBeat.o(160987);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(ps psVar) {
                    Object obj;
                    AppMethodBeat.i(143866);
                    if (h.this.CyM <= 0 && (obj = g.aAh().azQ().get(ar.a.USERINFO_CLOG_SAMPLING_REFRESH_TIME_LONG, (Object) null)) != null && (obj instanceof Long)) {
                        h.this.CyM = ((Long) obj).longValue();
                    }
                    if (h.this.CyN || System.currentTimeMillis() - h.this.CyM > Util.MILLSECONDS_OF_DAY) {
                        g.aAk().postToWorkerDelayed(r0, 100);
                    }
                    AppMethodBeat.o(143866);
                    return true;
                }
            });
            g.azz().a(701, new i() {
                /* class com.tencent.mm.plugin.report.service.h.AnonymousClass4 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(143867);
                    if (i2 != 0) {
                        AppMethodBeat.o(143867);
                        return;
                    }
                    g.aAk().postToWorkerDelayed(r0, 5000);
                    AppMethodBeat.o(143867);
                }
            });
        }
        AppMethodBeat.o(143875);
    }

    public static Object a(int i2, int[] iArr, int i3, int i4) {
        AppMethodBeat.i(143876);
        Object a2 = e.a(i2, iArr, i3, i4);
        AppMethodBeat.o(143876);
        return a2;
    }

    public static String u(Object... objArr) {
        String str;
        AppMethodBeat.i(143877);
        if (objArr == null || objArr.length <= 0) {
            Log.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
            str = "";
        } else if (objArr.length == 1) {
            str = String.valueOf(objArr[0]);
        } else {
            StringBuilder sb = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.valueOf(objArr[i2]).replace(',', ' ')).append(',');
            }
            sb.append(String.valueOf(objArr[length]));
            str = sb.toString();
        }
        AppMethodBeat.o(143877);
        return str;
    }

    private static String gv(List<String> list) {
        String str;
        AppMethodBeat.i(143878);
        if (list == null || list.isEmpty()) {
            Log.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder sb = new StringBuilder();
            int size = list.size() - 1;
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(list.get(i2)).append(',');
            }
            sb.append(list.get(size));
            str = sb.toString();
        }
        AppMethodBeat.o(143878);
        return str;
    }

    static void b(int i2, int i3, String str, boolean z, boolean z2) {
        AppMethodBeat.i(143879);
        KVReportDataInfo kVReportDataInfo = new KVReportDataInfo();
        kVReportDataInfo.dQR = (long) i2;
        kVReportDataInfo.value = str;
        kVReportDataInfo.dDw = (long) i3;
        kVReportDataInfo.CxY = false;
        kVReportDataInfo.Cyr = z;
        kVReportDataInfo.Cys = z2;
        KVCommCrossProcessReceiver.a(kVReportDataInfo);
        AppMethodBeat.o(143879);
    }

    private static void b(int i2, String str, boolean z, boolean z2) {
        AppMethodBeat.i(143880);
        KVReportDataInfo kVReportDataInfo = new KVReportDataInfo();
        kVReportDataInfo.dQR = (long) i2;
        kVReportDataInfo.value = str;
        kVReportDataInfo.dDw = 0;
        kVReportDataInfo.CxY = false;
        kVReportDataInfo.Cyr = z;
        kVReportDataInfo.Cys = z2;
        KVCommCrossProcessReceiver.a(kVReportDataInfo);
        AppMethodBeat.o(143880);
    }

    private static void m(long j2, long j3, long j4) {
        AppMethodBeat.i(143881);
        StIDKeyDataInfo stIDKeyDataInfo = new StIDKeyDataInfo();
        stIDKeyDataInfo.oIi = j2;
        stIDKeyDataInfo.key = j3;
        stIDKeyDataInfo.value = j4;
        stIDKeyDataInfo.CxY = false;
        KVCommCrossProcessReceiver.a(stIDKeyDataInfo);
        AppMethodBeat.o(143881);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void kvStat(int i2, String str) {
        AppMethodBeat.i(143882);
        if (c.CxC) {
            boolean z = c.CxD;
            a(i2, str, z, z);
            AppMethodBeat.o(143882);
            return;
        }
        a(i2, str, false, false);
        AppMethodBeat.o(143882);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void a(int i2, String str, boolean z, boolean z2) {
        AppMethodBeat.i(143883);
        if (!MMApplicationContext.isMMProcess()) {
            b(i2, str, z, false);
            AppMethodBeat.o(143883);
        } else if (c.CxC) {
            boolean z3 = c.CxD;
            e.a((long) i2, str, z3, z3, false);
            AppMethodBeat.o(143883);
        } else {
            e.a((long) i2, str, z, false, false);
            AppMethodBeat.o(143883);
        }
    }

    public static void c(int i2, String str, boolean z, boolean z2) {
        AppMethodBeat.i(143884);
        if (!MMApplicationContext.isMMProcess()) {
            b(i2, str, z, z2);
            AppMethodBeat.o(143884);
        } else if (c.CxC) {
            boolean z3 = c.CxD;
            e.a((long) i2, str, z3, z3, z2);
            AppMethodBeat.o(143884);
        } else {
            e.a((long) i2, str, z, false, z2);
            AppMethodBeat.o(143884);
        }
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void a(int i2, boolean z, boolean z2, boolean z3, Object... objArr) {
        AppMethodBeat.i(224157);
        c(i2, u(objArr), z, z3);
        AppMethodBeat.o(224157);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void a(int i2, int i3, String str, boolean z, boolean z2) {
        AppMethodBeat.i(224158);
        if (!MMApplicationContext.isMMProcess()) {
            b(i2, i3, str, z, false);
            AppMethodBeat.o(224158);
        } else if (c.CxC) {
            boolean z3 = c.CxD;
            e.a((long) i2, (long) i3, str, z3, z3, false);
            AppMethodBeat.o(224158);
        } else {
            e.a((long) i2, (long) i3, str, z, false, false);
            AppMethodBeat.o(224158);
        }
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void a(int i2, Object... objArr) {
        AppMethodBeat.i(143886);
        if (c.CxC) {
            boolean z = c.CxD;
            a(i2, z, z, objArr);
            AppMethodBeat.o(143886);
            return;
        }
        a(i2, false, false, objArr);
        AppMethodBeat.o(143886);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void a(int i2, boolean z, boolean z2, Object... objArr) {
        AppMethodBeat.i(143887);
        String u = u(objArr);
        if (CrashReportFactory.hasDebuger()) {
            Log.v("MicroMsg.ReportManagerKvCheck", "kvTypedStat id:%d [%b,%b] val:%s", Integer.valueOf(i2), Boolean.valueOf(z), Boolean.FALSE, u);
        }
        if (MMApplicationContext.isMMProcess()) {
            e.a((long) i2, u, z, false, false);
            AppMethodBeat.o(143887);
            return;
        }
        b(i2, u, z, false);
        AppMethodBeat.o(143887);
    }

    public final boolean c(int i2, a aVar) {
        AppMethodBeat.i(143888);
        try {
            aVar.getClass().getField("import_ds_").setInt(aVar, Integer.MAX_VALUE);
            long nowMilliSecond = Util.nowMilliSecond();
            if (nowMilliSecond / 86400 != this.CyG) {
                try {
                    this.CyH = Util.getInt(new SimpleDateFormat("yyyyMMdd").format(new Date()), 0);
                } catch (Exception e2) {
                }
            }
            aVar.getClass().getField("ds_").setInt(aVar, this.CyH);
            aVar.getClass().getField("uin_").setLong(aVar, ((long) this.uin) & Util.MAX_32BIT_VALUE);
            aVar.getClass().getField("device_").setInt(aVar, 2);
            aVar.getClass().getField("clientVersion_").setInt(aVar, com.tencent.mm.protocal.d.KyO);
            aVar.getClass().getField("time_stamp_").setLong(aVar, nowMilliSecond);
            try {
                byte[] byteArray = aVar.toByteArray();
                if (!MMApplicationContext.isMMProcess()) {
                    Log.f("MicroMsg.ReportManagerKvCheck", "not in MM Process");
                } else if (c.CxC) {
                    boolean z = c.CxD;
                    e.a((long) i2, byteArray, z, z);
                } else {
                    e.a((long) i2, byteArray, false, false);
                }
                AppMethodBeat.o(143888);
                return true;
            } catch (IOException e3) {
                Log.e("MicroMsg.ReportManagerKvCheck", "pbKVStat LocalReportPb error, %d, %s", Integer.valueOf(i2), e3.toString());
                AppMethodBeat.o(143888);
                return false;
            }
        } catch (Exception e4) {
            Log.e("MicroMsg.ReportManagerKvCheck", "pbKVStat  set values error, %d, %s", Integer.valueOf(i2), e4.toString());
            AppMethodBeat.o(143888);
            return false;
        }
    }

    public static void r(int i2, List<String> list) {
        AppMethodBeat.i(143889);
        if (c.CxC) {
            b(i2, list, c.CxD);
            AppMethodBeat.o(143889);
            return;
        }
        b(i2, list, false);
        AppMethodBeat.o(143889);
    }

    private static void b(int i2, List<String> list, boolean z) {
        AppMethodBeat.i(143890);
        String gv = gv(list);
        if (MMApplicationContext.isMMProcess()) {
            e.a((long) i2, gv, z, false, false);
            AppMethodBeat.o(143890);
            return;
        }
        b(i2, gv, z, false);
        AppMethodBeat.o(143890);
    }

    public final void Ip(long j2) {
        AppMethodBeat.i(224159);
        synchronized (this.CyI) {
            try {
                this.CyI.add(new Pair<>(1570L, Long.valueOf(j2)));
            } finally {
                AppMethodBeat.o(224159);
            }
        }
    }

    public final void F(long j2, long j3) {
        AppMethodBeat.i(261904);
        n(j2, j3, 1);
        AppMethodBeat.o(261904);
    }

    public final void n(long j2, long j3, long j4) {
        AppMethodBeat.i(143892);
        idkeyStat(j2, j3, j4, false);
        AppMethodBeat.o(143892);
    }

    public final void dN(int i2, int i3) {
        AppMethodBeat.i(143893);
        n((long) i2, (long) i3, 1);
        AppMethodBeat.o(143893);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void idkeyStat(long j2, long j3, long j4, boolean z) {
        AppMethodBeat.i(143894);
        if (j2 < 0 || j3 < 0 || j4 <= 0) {
            Log.e("MicroMsg.ReportManagerKvCheck", "ID %d, key %d, value %d <0", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
            AppMethodBeat.o(143894);
        } else if (MMApplicationContext.isMMProcess()) {
            e.b(j2, j3, j4, false);
            AppMethodBeat.o(143894);
        } else {
            m(j2, j3, j4);
            AppMethodBeat.o(143894);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0022  */
    @Override // com.tencent.mm.plugin.report.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.util.ArrayList<com.tencent.mars.smc.IDKey> r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 147
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.report.service.h.b(java.util.ArrayList, boolean):void");
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void a(int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        AppMethodBeat.i(143896);
        IDKey iDKey = new IDKey();
        iDKey.SetID(i2);
        iDKey.SetKey(i4);
        iDKey.SetValue((long) i6);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i3);
        iDKey2.SetKey(i5);
        iDKey2.SetValue((long) i7);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        b(arrayList, z);
        AppMethodBeat.o(143896);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void b(int i2, int i3, int i4, int i5, boolean z) {
        AppMethodBeat.i(143897);
        IDKey iDKey = new IDKey();
        iDKey.SetID(i2);
        iDKey.SetKey(i3);
        iDKey.SetValue((long) i5);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i2);
        iDKey2.SetKey(i4);
        iDKey2.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        b(arrayList, false);
        AppMethodBeat.o(143897);
    }

    public final void aw(int i2, int i3, int i4) {
        AppMethodBeat.i(143898);
        IDKey iDKey = new IDKey();
        iDKey.SetID(i2);
        iDKey.SetKey(i3);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i2);
        iDKey2.SetKey(i4);
        iDKey2.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        b(arrayList, false);
        AppMethodBeat.o(143898);
    }

    public static void eOI() {
        AppMethodBeat.i(143899);
        if (MMApplicationContext.isMMProcess()) {
            Mars.onSingalCrash(0);
        }
        AppMethodBeat.o(143899);
    }

    public final void jO(String str, String str2) {
        AppMethodBeat.i(261905);
        e(str, str2, null);
        AppMethodBeat.o(261905);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void e(String str, final String str2, final Map<String, Object> map) {
        AppMethodBeat.i(143901);
        a(str, new Callable<JSONArray>() {
            /* class com.tencent.mm.plugin.report.service.h.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ JSONArray call() {
                AppMethodBeat.i(143868);
                JSONArray put = new JSONArray().put((map == null ? new JSONObject() : new JSONObject(map)).put("info", str2));
                AppMethodBeat.o(143868);
                return put;
            }
        });
        AppMethodBeat.o(143901);
    }

    public final void B(String str, final List<String> list) {
        AppMethodBeat.i(143902);
        a(str, new Callable<JSONArray>() {
            /* class com.tencent.mm.plugin.report.service.h.AnonymousClass6 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ JSONArray call() {
                AppMethodBeat.i(143869);
                JSONArray jSONArray = new JSONArray();
                for (String str : list) {
                    jSONArray.put(new JSONObject().put("info", str));
                }
                AppMethodBeat.o(143869);
                return jSONArray;
            }
        });
        AppMethodBeat.o(143902);
    }

    private void a(final String str, final Callable<JSONArray> callable) {
        AppMethodBeat.i(143903);
        final long currentTimeMillis = System.currentTimeMillis();
        if (!bl(str, currentTimeMillis)) {
            AppMethodBeat.o(143903);
            return;
        }
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.report.service.h.AnonymousClass7 */

            public final void run() {
                String str;
                int i2;
                InputStream inputStream = null;
                AppMethodBeat.i(143870);
                if (!MMApplicationContext.isMMProcess() || !g.aAc()) {
                    str = null;
                    i2 = 0;
                } else {
                    g.aAf();
                    i2 = com.tencent.mm.kernel.a.getUin();
                    str = g.aAh().azQ() == null ? null : z.aTY();
                }
                try {
                    SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
                    String str2 = com.tencent.mm.network.c.icB;
                    String string = sharedPreferences.getString(str2, str2);
                    JSONArray jSONArray = (JSONArray) callable.call();
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        jSONObject.put("tag", str);
                        jSONObject.put(OpenSDKTool4Assistant.EXTRA_UIN, i2);
                    }
                    byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", com.tencent.mm.protocal.d.DEVICE_NAME).put("os_ver", com.tencent.mm.protocal.d.ics).put("report_time", currentTimeMillis).put("revision", Util.nullAsNil(BuildInfo.REV))).put("items", jSONArray).toString().getBytes();
                    int length2 = bytes.length;
                    String lowerCase = com.tencent.mm.b.g.getMessageDigest(String.format("weixin#$()%d%d", Integer.valueOf(com.tencent.mm.protocal.d.KyO), Integer.valueOf(length2)).getBytes()).toLowerCase();
                    byte[] compress = s.compress(bytes);
                    PByteArray pByteArray = new PByteArray();
                    com.tencent.mm.b.c.a(pByteArray, compress, lowerCase.getBytes());
                    StringBuilder append = new StringBuilder(256).append(HttpWrapperBase.PROTOCAL_HTTPS).append(string).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(com.tencent.mm.protocal.d.KyO)).append("&devicetype=").append(com.tencent.mm.protocal.d.ics).append("&filelength=").append(length2).append("&sum=").append(lowerCase).append("&reporttype=1&NewReportType=110");
                    if (!(str == null || str.length() == 0)) {
                        append.append("&username=").append(str);
                    }
                    if (i2 != 0) {
                        append.append("&uin=").append(i2);
                    }
                    String sb = append.toString();
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(sb);
                    ByteArrayEntity byteArrayEntity = new ByteArrayEntity(pByteArray.value);
                    byteArrayEntity.setContentType("binary/octet-stream");
                    httpPost.setEntity(byteArrayEntity);
                    InputStream content = defaultHttpClient.execute(httpPost).getEntity().getContent();
                    Log.i("MicroMsg.cLog", "POST returned: ".concat(String.valueOf(Util.convertStreamToString(content))));
                    if (content != null) {
                        try {
                            content.close();
                            AppMethodBeat.o(143870);
                            return;
                        } catch (IOException e2) {
                            AppMethodBeat.o(143870);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e3, "Failed to upload cLog.", new Object[0]);
                    if (0 != 0) {
                        try {
                            inputStream.close();
                            AppMethodBeat.o(143870);
                            return;
                        } catch (IOException e4) {
                            AppMethodBeat.o(143870);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    AppMethodBeat.o(143870);
                    throw th;
                }
                AppMethodBeat.o(143870);
            }
        }, "ReportManager_cLog");
        AppMethodBeat.o(143903);
    }

    @Override // com.tencent.mm.plugin.report.d
    public final void setUin(int i2) {
        AppMethodBeat.i(143904);
        this.uin = i2;
        SmcLogic.setUin((long) i2);
        AppMethodBeat.o(143904);
    }

    private boolean bl(String str, long j2) {
        byte[] Q;
        AppMethodBeat.i(143905);
        if (WeChatEnvironment.hasDebugger()) {
            Log.d("MicroMsg.cLog", "[%s] Sampling hit: (debug)", str);
            AppMethodBeat.o(143905);
            return true;
        }
        Long l = this.CyJ != null ? this.CyJ.get(str) : null;
        if (l == null || (Q = com.tencent.mm.b.g.Q((str + this.uin + j2).getBytes())) == null || Q.length != 16) {
            Log.d("MicroMsg.cLog", "[%s] Sampling hit: (default)", str);
            AppMethodBeat.o(143905);
            return true;
        }
        long j3 = (((long) (Q[0] + Q[4] + Q[8] + Q[12])) & 255) | ((((long) (((Q[1] + Q[5]) + Q[9]) + Q[13])) & 255) << 8) | ((((long) (((Q[2] + Q[6]) + Q[10]) + Q[14])) & 255) << 16) | ((((long) (Q[15] + ((Q[3] + Q[7]) + Q[11]))) & 255) << 24);
        boolean z = j3 < l.longValue();
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = z ? "hit" : "miss";
        objArr[2] = Long.valueOf(j3);
        objArr[3] = l;
        Log.d("MicroMsg.cLog", "[%s] Sampling %s: 0x%08x / 0x%08x", objArr);
        AppMethodBeat.o(143905);
        return z;
    }

    static /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(143906);
        try {
            byte[] aW = com.tencent.mm.vfs.s.aW(aa.z(o.X(MMApplicationContext.getContext().getFileStreamPath("clog-settings")).mUri), 0, -1);
            if (aW != null) {
                Log.i("MicroMsg.cLog", "Load settings from local file.");
                hVar.CyN = false;
                ak akVar = new ak();
                akVar.parseFrom(aW);
                HashMap<String, Long> hashMap = new HashMap<>();
                Iterator<ai> it = akVar.KDc.iterator();
                while (it.hasNext()) {
                    ai next = it.next();
                    if (next.KCV != 0) {
                        long j2 = (((long) next.KCX) * Util.MAX_32BIT_VALUE) / TimeUtil.SECOND_TO_US;
                        hashMap.put(next.KCU, Long.valueOf(j2));
                        Log.i("MicroMsg.cLog", "Update cLog ratio: %s => %d [0x%08x]", next.KCU, Integer.valueOf(next.KCX), Long.valueOf(j2));
                    }
                }
                hVar.CyJ = hashMap;
                hVar.CyK = akVar.KCZ;
                hVar.CyL = akVar.KDa;
                Log.i("MicroMsg.cLog", "Update cLog version: %d / %d", Integer.valueOf(hVar.CyK), Integer.valueOf(hVar.CyL));
                AppMethodBeat.o(143906);
                return;
            }
            Log.i("MicroMsg.cLog", "Settings local file missing.");
            hVar.CyN = true;
            AppMethodBeat.o(143906);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.cLog", e2, "Failed to update cLog ratio.", new Object[0]);
            AppMethodBeat.o(143906);
        }
    }

    static /* synthetic */ void b(h hVar) {
        AppMethodBeat.i(143907);
        Log.i("MicroMsg.cLog", "Update CLog ratio from server.");
        com.tencent.mm.network.g gVar = g.azz().iMw;
        if (gVar == null) {
            Log.i("MicroMsg.ReportManagerKvCheck", "dispatcher is null, just return.");
            AppMethodBeat.o(143907);
            return;
        }
        new com.tencent.mm.plugin.report.b.g(hVar.CyK, hVar.CyL).doScene(gVar, new i() {
            /* class com.tencent.mm.plugin.report.service.h.AnonymousClass8 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(143872);
                qVar.setHasCallbackToQueue(true);
                if (i2 != 0) {
                    Log.e("MicroMsg.cLog", "NetScene failed, code=" + i3 + ", msg=" + str);
                    AppMethodBeat.o(143872);
                    return;
                }
                final ak akVar = ((com.tencent.mm.plugin.report.b.g) qVar).CxS;
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.report.service.h.AnonymousClass8.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(143871);
                        try {
                            h.this.CyM = System.currentTimeMillis();
                            ao azQ = g.aAh().azQ();
                            azQ.set(ar.a.USERINFO_CLOG_SAMPLING_REFRESH_TIME_LONG, Long.valueOf(h.this.CyM));
                            azQ.gBI();
                            if (h.this.CyK == akVar.KCZ && h.this.CyL == akVar.KDa) {
                                Log.i("MicroMsg.cLog", "Version not changed, use previous settings (%d / %d)", Integer.valueOf(akVar.KCZ), Integer.valueOf(akVar.KDa));
                                AppMethodBeat.o(143871);
                                return;
                            }
                            byte[] byteArray = akVar.toByteArray();
                            com.tencent.mm.vfs.s.f(aa.z(o.X(MMApplicationContext.getContext().getFileStreamPath("clog-settings")).mUri), byteArray, byteArray.length);
                            h.a(h.this);
                            AppMethodBeat.o(143871);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.cLog", e2, "Failed to parse response.", new Object[0]);
                            AppMethodBeat.o(143871);
                        }
                    }
                });
                AppMethodBeat.o(143872);
            }
        });
        AppMethodBeat.o(143907);
    }
}
