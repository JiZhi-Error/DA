package com.tencent.liteav;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.network.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class e {
    private static HashMap<String, a> C = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private static String f744a = "TXCDataReport";
    private int A = 0;
    private String B;
    private String D = "";
    private String E = "";

    /* renamed from: b  reason: collision with root package name */
    private HashMap f745b = new HashMap(100);

    /* renamed from: c  reason: collision with root package name */
    private String f746c;

    /* renamed from: d  reason: collision with root package name */
    private int f747d;

    /* renamed from: e  reason: collision with root package name */
    private int f748e;

    /* renamed from: f  reason: collision with root package name */
    private int f749f;

    /* renamed from: g  reason: collision with root package name */
    private int f750g;

    /* renamed from: h  reason: collision with root package name */
    private Context f751h;

    /* renamed from: i  reason: collision with root package name */
    private String f752i;

    /* renamed from: j  reason: collision with root package name */
    private long f753j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private long t;
    private boolean u = false;
    private long v = 0;
    private long w = 0;
    private long x = 0;
    private long y = 0;
    private long z = 0;

    static {
        AppMethodBeat.i(222371);
        AppMethodBeat.o(222371);
    }

    public e(Context context) {
        AppMethodBeat.i(16559);
        this.f751h = context.getApplicationContext();
        this.f752i = TXCCommonUtil.getAppVersion();
        this.r = 5000;
        this.z = 0;
        AppMethodBeat.o(16559);
    }

    public void a() {
        AppMethodBeat.i(16567);
        p();
        this.k = -1;
        this.o = -1;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.v = System.currentTimeMillis();
        AppMethodBeat.o(16567);
    }

    public void b() {
        AppMethodBeat.i(16568);
        if (this.p) {
            n();
            AppMethodBeat.o(16568);
            return;
        }
        TXCLog.e(f744a, "push " + this.f746c + " failed!");
        l();
        AppMethodBeat.o(16568);
    }

    public void c() {
        AppMethodBeat.i(222360);
        if (this.p) {
            if (this.u) {
                e(com.tencent.liteav.basic.datareport.a.Y);
            } else if (d() != a.NEGATIVE) {
                e(com.tencent.liteav.basic.datareport.a.V);
            }
            if (this.u) {
                d(com.tencent.liteav.basic.datareport.a.Z);
            } else {
                d(com.tencent.liteav.basic.datareport.a.W);
            }
        } else {
            TXCLog.e(f744a, "play " + this.f746c + " failed");
            if (this.u) {
                c(com.tencent.liteav.basic.datareport.a.X);
            } else {
                c(com.tencent.liteav.basic.datareport.a.U);
            }
        }
        if (this.u) {
            k();
        }
        TXCStatus.a(this.D, 7107, (Object) 0L);
        TXCStatus.a(this.D, 2033, (Object) 0L);
        TXCStatus.a(this.D, (int) TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE, (Object) 0L);
        TXCStatus.a(this.D, 7104, (Object) 0L);
        TXCStatus.a(this.D, 7108, (Object) 0L);
        AppMethodBeat.o(222360);
    }

    public void a(boolean z2) {
        this.u = z2;
    }

    public void a(String str) {
        AppMethodBeat.i(222361);
        this.f746c = str;
        b(str);
        AppMethodBeat.o(222361);
    }

    public void b(String str) {
        AppMethodBeat.i(16591);
        if (str == null) {
            AppMethodBeat.o(16591);
            return;
        }
        this.B = str;
        AppMethodBeat.o(16591);
    }

    /* access modifiers changed from: package-private */
    public enum a {
        PENDING,
        CONFIRM,
        NEGATIVE;

        public static a valueOf(String str) {
            AppMethodBeat.i(222386);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(222386);
            return aVar;
        }

        static {
            AppMethodBeat.i(222387);
            AppMethodBeat.o(222387);
        }
    }

    /* access modifiers changed from: protected */
    public a d() {
        AppMethodBeat.i(222362);
        try {
            Uri parse = Uri.parse(this.B);
            if (parse == null) {
                a aVar = a.PENDING;
                AppMethodBeat.o(222362);
                return aVar;
            }
            final String host = parse.getHost();
            if (TextUtils.isEmpty(host)) {
                a aVar2 = a.PENDING;
                AppMethodBeat.o(222362);
                return aVar2;
            }
            String scheme = parse.getScheme();
            if (scheme == null) {
                a aVar3 = a.PENDING;
                AppMethodBeat.o(222362);
                return aVar3;
            } else if (!scheme.equals("rtmp") && !scheme.equals("http") && !scheme.equals("https")) {
                a aVar4 = a.PENDING;
                AppMethodBeat.o(222362);
                return aVar4;
            } else if (c(host)) {
                a aVar5 = a.CONFIRM;
                AppMethodBeat.o(222362);
                return aVar5;
            } else {
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && (queryParameterNames.contains("bizid") || queryParameterNames.contains("txTime") || queryParameterNames.contains("txSecret"))) {
                    a aVar6 = a.CONFIRM;
                    AppMethodBeat.o(222362);
                    return aVar6;
                } else if (C.containsKey(host)) {
                    a aVar7 = C.get(host);
                    AppMethodBeat.o(222362);
                    return aVar7;
                } else {
                    C.put(host, a.PENDING);
                    new Thread(new Runnable() {
                        /* class com.tencent.liteav.e.AnonymousClass1 */

                        public void run() {
                            boolean z = false;
                            AppMethodBeat.i(222644);
                            try {
                                com.tencent.liteav.network.a.e[] a2 = com.tencent.liteav.network.a.a.a.c().a(new b(host, true), null);
                                int length = a2.length;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= length) {
                                        break;
                                    }
                                    com.tencent.liteav.network.a.e eVar = a2[i2];
                                    if (eVar.a() && e.c(eVar.f916a)) {
                                        z = true;
                                        break;
                                    }
                                    i2++;
                                }
                                e.C.put(host, z ? a.CONFIRM : a.NEGATIVE);
                                TXCLog.d(e.f744a, host + " isTencent " + z);
                                AppMethodBeat.o(222644);
                            } catch (Exception e2) {
                                TXCLog.e(e.f744a, "check dns failed.", e2);
                                AppMethodBeat.o(222644);
                            }
                        }
                    }).start();
                    a aVar8 = a.PENDING;
                    AppMethodBeat.o(222362);
                    return aVar8;
                }
            }
        } catch (Exception e2) {
            TXCLog.e(f744a, "check stream failed.", e2);
        }
    }

    protected static boolean c(String str) {
        AppMethodBeat.i(222363);
        if (str == null || !str.contains("myqcloud")) {
            boolean a2 = c.a().a(str);
            AppMethodBeat.o(222363);
            return a2;
        }
        AppMethodBeat.o(222363);
        return true;
    }

    public void d(String str) {
        this.D = str;
    }

    public void e(String str) {
        this.E = str;
    }

    public void a(int i2, int i3) {
        AppMethodBeat.i(16562);
        this.f747d = i2;
        this.f748e = i3;
        AppMethodBeat.o(16562);
    }

    public void a(int i2) {
        AppMethodBeat.i(16569);
        this.f749f = i2;
        AppMethodBeat.o(16569);
    }

    public void b(int i2) {
        AppMethodBeat.i(16570);
        this.f750g = i2;
        AppMethodBeat.o(16570);
    }

    public void e() {
        AppMethodBeat.i(222364);
        if (!this.p && !TextUtils.isEmpty(TXCStatus.b(this.D, 7012))) {
            m();
            this.p = true;
        }
        if (this.q <= 0) {
            this.q = TXCTimeUtil.getTimeTick();
        }
        if (this.p && TXCTimeUtil.getTimeTick() - this.q > 5000) {
            o();
            this.q = TXCTimeUtil.getTimeTick();
        }
        AppMethodBeat.o(222364);
    }

    private void i() {
        AppMethodBeat.i(16580);
        a(6002, 6017, 6018);
        TXCStatus.a(this.D, 9001, Integer.valueOf(f.a()[0]));
        a(9001, 9002, 9003);
        TXCStatus.a(this.D, 9004, Integer.valueOf(f.b()));
        a(9004, 9005, 9006);
        AppMethodBeat.o(16580);
    }

    public void a(int i2, int i3, int i4) {
        AppMethodBeat.i(222365);
        if (i2 == 6002) {
            double d2 = TXCStatus.d(this.D, i2);
            if (d2 < 0.001d) {
                AppMethodBeat.o(222365);
                return;
            }
            double d3 = TXCStatus.d(this.D, i3);
            int c2 = TXCStatus.c(this.D, i4) + 1;
            TXCStatus.a(this.D, i3, Double.valueOf(((d2 - d3) / ((double) c2)) + d3));
            TXCStatus.a(this.D, i4, Integer.valueOf(c2));
            AppMethodBeat.o(222365);
            return;
        }
        int c3 = TXCStatus.c(this.D, i2);
        if (((double) c3) < 0.001d) {
            AppMethodBeat.o(222365);
            return;
        }
        double d4 = TXCStatus.d(this.D, i3);
        int c4 = TXCStatus.c(this.D, i4) + 1;
        TXCStatus.a(this.D, i3, Double.valueOf(d4 + ((((double) c3) - d4) / ((double) c4))));
        TXCStatus.a(this.D, i4, Integer.valueOf(c4));
        AppMethodBeat.o(222365);
    }

    public void f() {
        AppMethodBeat.i(16592);
        i();
        if (!this.p) {
            long a2 = TXCStatus.a(this.D, TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE);
            long a3 = TXCStatus.a(this.D, 7104);
            long a4 = TXCStatus.a(this.D, 2033);
            long a5 = TXCStatus.a(this.D, 7108);
            if (a2 > 0 && a3 > 0 && a5 > 0 && a4 > 0) {
                c(this.u ? com.tencent.liteav.basic.datareport.a.X : com.tencent.liteav.basic.datareport.a.U);
                this.r = 5000;
                this.p = true;
            }
            String b2 = TXCStatus.b(this.D, 7119);
            if (b2 != null) {
                b(b2);
            }
        }
        if (this.A >= 3 && !this.p) {
            c(this.u ? com.tencent.liteav.basic.datareport.a.X : com.tencent.liteav.basic.datareport.a.U);
            this.r = 5000;
            this.p = true;
        }
        this.A++;
        if (this.q <= 0) {
            this.q = TXCTimeUtil.getTimeTick();
        }
        if (TXCTimeUtil.getTimeTick() > this.q + ((long) this.r)) {
            if (this.u) {
                e(com.tencent.liteav.basic.datareport.a.Y);
                this.r = 5000;
            } else if (d() == a.NEGATIVE) {
                AppMethodBeat.o(16592);
                return;
            } else {
                e(com.tencent.liteav.basic.datareport.a.V);
                this.r = TXCDRApi.getStatusReportInterval();
                if (this.r < 5000) {
                    this.r = 5000;
                }
                if (this.r > 300000) {
                    this.r = 300000;
                }
            }
            this.k = TXCStatus.a(this.D, 6004);
            this.o = (long) TXCStatus.c(this.D, 2002);
            this.q = TXCTimeUtil.getTimeTick();
        }
        AppMethodBeat.o(16592);
    }

    private void c(int i2) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        AppMethodBeat.i(16573);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f746c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.f745b.get("token");
        TXCDRApi.InitEvent(this.f751h, str, i2, com.tencent.liteav.basic.datareport.a.am, tXCDRExtInfo);
        a(i2, str);
        TXCDRApi.txSetEventIntValue(str, i2, "u64_timestamp", ((Long) this.f745b.get("u64_timestamp")).longValue());
        long a2 = TXCStatus.a(this.D, 7107);
        long a3 = TXCStatus.a(this.D, 7108);
        if (a3 != -1) {
            a3 -= a2;
        }
        TXCDRApi.txSetEventIntValue(str, i2, "u32_dns_time", a3 < 0 ? -1 : a3);
        long a4 = TXCStatus.a(this.D, 7109);
        if (a4 != -1) {
            a4 -= a2;
        }
        if (a4 < 0) {
            j2 = -1;
        } else {
            j2 = a4;
        }
        TXCDRApi.txSetEventIntValue(str, i2, "u32_connect_server_time", j2);
        int c2 = TXCStatus.c(this.D, 5004);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_video_decode_type", (long) c2);
        this.f753j = TXCStatus.a(this.D, TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE) - a2;
        TXCDRApi.txSetEventIntValue(str, i2, "u32_first_i_frame", this.f753j < 0 ? -1 : this.f753j);
        long a5 = TXCStatus.a(this.D, 7103) - a2;
        if (a5 < 0) {
            j3 = -1;
        } else {
            j3 = a5;
        }
        TXCDRApi.txSetEventIntValue(str, i2, "u32_first_frame_down", j3);
        long a6 = TXCStatus.a(this.D, 5005) - a2;
        if (a6 < 0) {
            j4 = -1;
        } else {
            j4 = a6;
        }
        TXCDRApi.txSetEventIntValue(str, i2, "u32_first_video_decode_time", j4);
        long a7 = TXCStatus.a(this.D, 7104) - a2;
        if (a7 < 0) {
            j5 = -1;
        } else {
            j5 = a7;
        }
        TXCDRApi.txSetEventIntValue(str, i2, "u32_first_audio_frame_down", j5);
        long a8 = TXCStatus.a(this.D, 2033) - a2;
        if (a8 < 0) {
            j6 = -1;
        } else {
            j6 = a8;
        }
        TXCDRApi.txSetEventIntValue(str, i2, "u32_first_audio_render_time", j6);
        int c3 = TXCStatus.c(this.D, 7105);
        TXCDRApi.txSetEventIntValue(str, i2, "u64_err_code", (long) c3);
        int c4 = TXCStatus.c(this.D, 7106);
        TXCDRApi.txSetEventIntValue(str, i2, "str_err_info", (long) c4);
        int c5 = TXCStatus.c(this.D, 7112);
        TXCDRApi.txSetEventValue(str, i2, "u32_link_type", String.valueOf(c5));
        int c6 = TXCStatus.c(this.D, 7111);
        TXCDRApi.txSetEventValue(str, i2, "u32_channel_type", String.valueOf(c6));
        TXCDRApi.txSetEventValue(str, i2, "str_app_version", this.f752i);
        TXCDRApi.nativeReportEvent(str, i2);
        TXCLog.d(f744a, "report evt " + i2 + ": token=" + str + "\nstr_user_id=" + this.f745b.get("str_user_id") + "\ndev_uuid=" + this.f745b.get("dev_uuid") + "\nstr_session_id=" + this.f745b.get("str_session_id") + "\nstr_device_type=" + this.f745b.get("str_device_type") + "\nstr_os_info=" + this.f745b.get("str_os_info") + "\nstr_package_name=" + this.f745b.get("str_package_name") + "\nu32_network_type=" + this.f745b.get("u32_network_type") + "\nu32_server_ip=" + this.f745b.get("u32_server_ip") + "\nstr_stream_url=" + this.f745b.get("str_stream_url") + "\nu64_timestamp=" + this.f745b.get("u64_timestamp") + "\nu32_dns_time=" + a3 + "\nu32_connect_server_time=" + a4 + "\nu32_video_decode_type=" + c2 + "\nu32_first_frame_down=" + a5 + "\nu32_first_video_decode_time=" + a6 + "\nu32_first_i_frame=" + this.f753j + "\nu32_first_audio_frame_down=" + a7 + "\nu32_first_audio_render_time=" + a8 + "\nu64_err_code=" + c3 + "\nstr_err_info=" + c4 + "\nu32_link_type=" + c5 + "\nu32_channel_type=" + c6 + "\nstr_app_version=" + this.f752i);
        AppMethodBeat.o(16573);
    }

    private void f(String str) {
        AppMethodBeat.i(222366);
        if (!TextUtils.isEmpty(str) && str.startsWith("room://")) {
            String[] split = str.split(FilePathGenerator.ANDROID_DIR_SEP);
            split[split.length - 1].split("_");
            TXCStatus.a(this.D, 7112, (Object) 3L);
        }
        AppMethodBeat.o(222366);
    }

    private int j() {
        AppMethodBeat.i(222367);
        int i2 = 0;
        long timeTick = TXCTimeUtil.getTimeTick();
        long c2 = (long) TXCStatus.c(this.D, 6019);
        if (!(c2 == 0 || timeTick == 0)) {
            i2 = (int) (((c2 - this.t) * 1000) / (timeTick - this.s));
        }
        this.s = timeTick;
        this.t = c2;
        AppMethodBeat.o(222367);
        return i2;
    }

    private void d(int i2) {
        long j2;
        long j3;
        AppMethodBeat.i(222368);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f746c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.f745b.get("token");
        TXCDRApi.InitEvent(this.f751h, str, i2, com.tencent.liteav.basic.datareport.a.am, tXCDRExtInfo);
        a(i2, str);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, i2, "u64_end_timestamp", utcTimeTick);
        TXCDRApi.txSetEventIntValue(str, i2, "u64_timestamp", utcTimeTick);
        double d2 = TXCStatus.d(this.D, 9002);
        TXCDRApi.txSetEventValue(str, i2, "u32_avg_cpu_usage", String.valueOf(d2));
        double d3 = TXCStatus.d(this.D, 9005);
        TXCDRApi.txSetEventValue(str, i2, "u32_avg_memory", String.valueOf(d3));
        String valueOf = String.valueOf(this.z);
        TXCDRApi.txSetEventValue(str, i2, "u64_begin_timestamp", valueOf);
        long timeTick = (TXCTimeUtil.getTimeTick() - TXCStatus.a(this.D, 7107)) / 1000;
        TXCDRApi.txSetEventIntValue(str, i2, "u64_playtime", timeTick < 0 ? -1 : timeTick);
        if (timeTick < 0) {
            j2 = -1;
        } else {
            j2 = timeTick;
        }
        TXCDRApi.txSetEventIntValue(str, i2, "u32_result", j2);
        int c2 = TXCStatus.c(this.D, 7105);
        TXCDRApi.txSetEventIntValue(str, i2, "u64_err_code", (long) c2);
        int c3 = TXCStatus.c(this.D, 2004);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_speed_cnt", (long) c3);
        int c4 = TXCStatus.c(this.D, 2008);
        TXCDRApi.txSetEventIntValue(str, i2, "u64_audio_cache_avg", (long) c4);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_avg_cache_time", (long) c4);
        long c5 = (long) TXCStatus.c(this.D, 2003);
        TXCDRApi.txSetEventValue(str, i2, "u32_max_load", String.valueOf(c5));
        long c6 = (long) TXCStatus.c(this.D, 2001);
        TXCDRApi.txSetEventValue(str, i2, "u32_avg_load", String.valueOf(c6));
        long c7 = (long) TXCStatus.c(this.D, 2002);
        TXCDRApi.txSetEventValue(str, i2, "u32_load_cnt", String.valueOf(c7));
        int c8 = TXCStatus.c(this.D, 2005);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_nodata_cnt", (long) c8);
        long j4 = c6 * c7;
        TXCDRApi.txSetEventIntValue(str, i2, "u32_audio_block_time", j4);
        if (this.f753j < 0) {
            j3 = -1;
        } else {
            j3 = this.f753j;
        }
        TXCDRApi.txSetEventIntValue(str, i2, "u32_first_i_frame", j3);
        int c9 = TXCStatus.c(this.D, 6015);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_video_width", (long) c9);
        int c10 = TXCStatus.c(this.D, 6016);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_video_height", (long) c10);
        double d4 = TXCStatus.d(this.D, 6017);
        TXCDRApi.txSetEventValue(str, i2, "u32_video_avg_fps", String.valueOf(d4));
        long a2 = TXCStatus.a(this.D, 6003);
        long a3 = TXCStatus.a(this.D, 6005);
        long a4 = TXCStatus.a(this.D, 6006);
        long j5 = 0;
        if (a2 > 0) {
            j5 = a4 / a2;
        }
        TXCDRApi.txSetEventIntValue(str, i2, "u64_block_duration_avg", j5);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_avg_block_time", j5);
        TXCDRApi.txSetEventIntValue(str, i2, "u64_block_count", a2);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_video_block_time", a4);
        TXCDRApi.txSetEventIntValue(str, i2, "u64_block_duration_max", a3);
        long a5 = TXCStatus.a(this.D, 6009);
        TXCDRApi.txSetEventIntValue(str, i2, "u64_jitter_cache_max", a5);
        long a6 = TXCStatus.a(this.D, 6008);
        TXCDRApi.txSetEventIntValue(str, i2, "u64_jitter_cache_avg", a6);
        TXCDRApi.txSetEventValue(str, i2, "u32_link_type", String.valueOf(TXCStatus.c(this.D, 7112)));
        int c11 = TXCStatus.c(this.D, 7111);
        TXCDRApi.txSetEventValue(str, i2, "u32_channel_type", String.valueOf(c11));
        int c12 = TXCStatus.c(this.D, 7113);
        TXCDRApi.txSetEventValue(str, i2, "u32_ip_count_quic", String.valueOf(c12));
        int c13 = TXCStatus.c(this.D, 7114);
        TXCDRApi.txSetEventValue(str, i2, "u32_connect_count_quic", String.valueOf(c13));
        int c14 = TXCStatus.c(this.D, 7115);
        TXCDRApi.txSetEventValue(str, i2, "u32_connect_count_tcp", String.valueOf(c14));
        TXCDRApi.txSetEventValue(str, i2, "str_app_version", this.f752i);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_is_real_time", (long) (this.u ? 1 : 0));
        TXCDRApi.txSetEventIntValue(str, i2, "u32_first_frame_black", TXCStatus.a(this.D, 9009));
        TXCDRApi.nativeReportEvent(str, i2);
        TXCLog.d(f744a, "report evt " + i2 + ": token=" + str + "\nstr_user_id=" + this.f745b.get("str_user_id") + "\ndev_uuid=" + this.f745b.get("dev_uuid") + "\nstr_session_id=" + this.f745b.get("str_session_id") + "\nstr_device_type=" + this.f745b.get("str_device_type") + "\nstr_os_info=" + this.f745b.get("str_os_info") + "\nstr_package_name=" + this.f745b.get("str_package_name") + "\nu32_network_type=" + this.f745b.get("u32_network_type") + "\nu32_server_ip=" + this.f745b.get("u32_server_ip") + "\nstr_stream_url=" + this.f745b.get("str_stream_url") + "\nu64_timestamp=" + this.f745b.get("u64_timestamp") + "\nu32_avg_cpu_usage=" + d2 + "\nu32_avg_memory=" + d3 + "\nu32_first_i_frame=" + this.f753j + "\nu32_video_width=" + c9 + "\nu32_video_height=" + c10 + "\nu32_video_avg_fps=" + d4 + "\nu32_speed_cnt=" + c3 + "\nu32_nodata_cnt=" + c8 + "\nu32_avg_cache_time=" + c4 + "\nu32_avg_block_time=" + j5 + "\nu32_avg_load=" + c6 + "\nu32_max_load=" + c5 + "\nu32_video_block_time=" + a4 + "\nu32_audio_block_time=" + j4 + "\nu32_load_cnt=" + c7 + "\nu32_result=" + timeTick + "\nu64_err_code=" + c2 + "\nu32_channel_type=" + c11 + "\nu32_ip_count_quic=" + c12 + "\nu32_connect_count_quic=" + c13 + "\nu32_connect_count_tcp=" + c14 + "\nu64_block_count=" + a2 + "\nu64_jitter_cache_max=" + a5 + "\nu64_jitter_cache_avg=" + a6 + "\nu64_begin_timestamp=" + valueOf + "\nu32_is_real_time=" + TXCStatus.a(this.D, 2009) + "\nstr_app_version=" + this.f752i);
        AppMethodBeat.o(222368);
    }

    private void a(int i2, String str) {
        AppMethodBeat.i(16597);
        String b2 = TXCStatus.b(this.D, 7121);
        if (TextUtils.isEmpty(b2)) {
            b2 = str;
        }
        this.f745b.put("str_session_id", b2);
        this.f745b.put("u32_server_ip", TXCStatus.b(this.D, 7110));
        if (this.u) {
            this.f745b.put("str_stream_url", TXCStatus.b(this.D, 7116));
            f((String) this.f745b.get("str_stream_url"));
        } else {
            this.f745b.put("str_stream_url", TXCStatus.b(this.D, 7119));
        }
        TXCDRApi.txSetEventValue(str, i2, "str_user_id", (String) this.f745b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, i2, "dev_uuid", (String) this.f745b.get("dev_uuid"));
        TXCDRApi.txSetEventValue(str, i2, "str_session_id", (String) this.f745b.get("str_session_id"));
        TXCDRApi.txSetEventValue(str, i2, "str_device_type", (String) this.f745b.get("str_device_type"));
        TXCDRApi.txSetEventValue(str, i2, "str_os_info", (String) this.f745b.get("str_os_info"));
        TXCDRApi.txSetEventValue(str, i2, "str_package_name", (String) this.f745b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, i2, "u32_network_type", (long) g("u32_network_type"));
        TXCDRApi.txSetEventValue(str, i2, "u32_server_ip", (String) this.f745b.get("u32_server_ip"));
        TXCDRApi.txSetEventValue(str, i2, "str_stream_url", (String) this.f745b.get("str_stream_url"));
        AppMethodBeat.o(16597);
    }

    private void e(int i2) {
        int i3 = 2;
        AppMethodBeat.i(222369);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f746c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        String str = (String) this.f745b.get("token");
        TXCDRApi.InitEvent(this.f751h, str, i2, com.tencent.liteav.basic.datareport.a.am, tXCDRExtInfo);
        a(i2, str);
        TXCDRApi.txSetEventIntValue(str, i2, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
        int[] a2 = f.a();
        TXCDRApi.txSetEventIntValue(str, i2, "u32_cpu_usage", (long) a2[1]);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_app_cpu_usage", (long) a2[0]);
        TXCDRApi.txSetEventValue(str, i2, "u32_avg_cpu_usage", String.valueOf(TXCStatus.d(this.D, 9002)));
        TXCDRApi.txSetEventValue(str, i2, "u32_avg_memory", String.valueOf(TXCStatus.d(this.D, 9005)));
        TXCDRApi.txSetEventIntValue(str, i2, "u32_recv_av_diff_time", TXCStatus.a(this.D, 6014, 2));
        TXCDRApi.txSetEventIntValue(str, i2, "u32_play_av_diff_time", TXCStatus.a(this.D, 6013, 2));
        TXCDRApi.txSetEventValue(str, i2, "u64_playtime", String.valueOf((TXCTimeUtil.getUtcTimeTick() - this.z) / 1000));
        if (TXCStatus.c(this.D, 2015) != 0) {
            i3 = 1;
        }
        TXCDRApi.txSetEventIntValue(str, i2, "u32_audio_decode_type", (long) i3);
        long a3 = TXCStatus.a(this.D, 2002);
        if (this.o == -1) {
            TXCDRApi.txSetEventIntValue(str, i2, "u32_audio_block_count", 0);
        } else if (a3 >= this.o) {
            TXCDRApi.txSetEventIntValue(str, i2, "u32_audio_block_count", a3 - this.o);
        } else {
            TXCDRApi.txSetEventIntValue(str, i2, "u32_audio_block_count", -1);
        }
        this.o = a3;
        TXCDRApi.txSetEventIntValue(str, i2, "u32_audio_cache_time", (long) TXCStatus.c(this.D, 2010));
        TXCDRApi.txSetEventIntValue(str, i2, "u32_audio_drop", (long) TXCStatus.c(this.D, 2014));
        TXCDRApi.txSetEventIntValue(str, i2, "u32_video_decode_type", (long) TXCStatus.c(this.D, 5004));
        TXCDRApi.txSetEventIntValue(str, i2, "u32_video_recv_fps", (long) j());
        TXCDRApi.txSetEventIntValue(str, i2, "u32_fps", (long) ((int) TXCStatus.d(this.D, 6002)));
        TXCDRApi.txSetEventIntValue(str, i2, "u32_video_cache_time", (long) TXCStatus.c(this.D, 6007));
        long a4 = TXCStatus.a(this.D, 6008);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_video_cache_count", a4);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_avg_cache_count", a4);
        long a5 = TXCStatus.a(this.D, 6004);
        if (this.k == -1 || a5 < this.k) {
            TXCDRApi.txSetEventIntValue(str, i2, "u32_video_block_count", 0);
        } else {
            TXCDRApi.txSetEventIntValue(str, i2, "u32_video_block_count", a5 - this.k);
        }
        this.k = a5;
        int c2 = TXCStatus.c(this.D, 7102);
        int c3 = TXCStatus.c(this.D, 7101);
        int i4 = c2 + c3;
        TXCDRApi.txSetEventIntValue(str, i2, "u32_net_speed", (long) i4);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_avg_net_speed", (long) i4);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_avg_audio_bitrate", (long) c2);
        TXCDRApi.txSetEventIntValue(str, i2, "u32_avg_video_bitrate", (long) c3);
        TXCDRApi.txSetEventValue(str, i2, "u32_link_type", String.valueOf(TXCStatus.c(this.D, 7112)));
        TXCDRApi.txSetEventValue(str, i2, "u32_channel_type", String.valueOf(TXCStatus.c(this.D, 7111)));
        TXCDRApi.txSetEventValue(str, i2, "str_app_version", this.f752i);
        long a6 = TXCStatus.a(this.D, 6021);
        if (a6 > this.l) {
            TXCDRApi.txSetEventIntValue(str, i2, "u32_video_light_block_count", a6 - this.l);
        } else {
            TXCDRApi.txSetEventIntValue(str, i2, "u32_video_light_block_count", 0);
        }
        this.l = a6;
        long a7 = TXCStatus.a(this.D, 6003);
        if (a7 > this.m) {
            TXCDRApi.txSetEventIntValue(str, i2, "u32_video_large_block_count", a7 - this.m);
        } else {
            TXCDRApi.txSetEventIntValue(str, i2, "u32_video_large_block_count", 0);
        }
        this.m = a7;
        int c4 = TXCStatus.c(this.D, 2034);
        if (((long) c4) > this.n) {
            TXCDRApi.txSetEventIntValue(str, i2, "u32_audio_jitter_60ms_count", ((long) c4) - this.n);
        } else {
            TXCDRApi.txSetEventIntValue(str, i2, "u32_audio_jitter_60ms_count", 0);
        }
        this.n = (long) c4;
        TXCDRApi.txSetEventIntValue(str, i2, "u32_video_decode_fail", (long) TXCStatus.c(this.D, 9007));
        TXCDRApi.txSetEventIntValue(str, i2, "u32_audio_decode_fail", (long) TXCStatus.c(this.D, 2035));
        TXCDRApi.nativeReportEvent(str, i2);
        if (this.u) {
            this.y++;
            this.x += a4;
            if (a4 > this.w) {
                this.w = a4;
            }
        }
        AppMethodBeat.o(222369);
    }

    private void k() {
        AppMethodBeat.i(182276);
        HashMap hashMap = new HashMap();
        String b2 = TXCStatus.b(this.D, 7116);
        String b3 = TXCStatus.b(this.D, 7117);
        String b4 = TXCStatus.b(this.D, 7118);
        int c2 = TXCStatus.c(this.D, 7105);
        String b5 = TXCStatus.b(this.D, 7106);
        int c3 = TXCStatus.c(this.D, 7111);
        hashMap.put("stream_url", b2);
        hashMap.put("stream_id", b3);
        hashMap.put("bizid", b4);
        hashMap.put("err_code", String.valueOf(c2));
        hashMap.put("err_info", b5);
        hashMap.put("channel_type", String.valueOf(c3));
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.v;
        hashMap.put("start_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(this.v)));
        hashMap.put("end_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(currentTimeMillis)));
        hashMap.put("total_time", String.valueOf(j2));
        long a2 = TXCStatus.a(this.D, 6003);
        long a3 = TXCStatus.a(this.D, 6006);
        long a4 = TXCStatus.a(this.D, 6005);
        long j3 = a2 != 0 ? a3 / a2 : 0;
        hashMap.put("block_count", String.valueOf(a2));
        hashMap.put("block_duration_max", String.valueOf(a4));
        hashMap.put("block_duration_avg", String.valueOf(j3));
        long j4 = this.y != 0 ? this.x / this.y : 0;
        hashMap.put("jitter_cache_max", String.valueOf(this.w));
        hashMap.put("jitter_cache_avg", String.valueOf(j4));
        String txCreateToken = TXCDRApi.txCreateToken();
        int i2 = com.tencent.liteav.basic.datareport.a.af;
        int i3 = com.tencent.liteav.basic.datareport.a.al;
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.command_id_comment = "LINKMIC";
        TXCDRApi.InitEvent(this.f751h, txCreateToken, i2, i3, tXCDRExtInfo);
        TXCLog.d(f744a, "report evt 40402: token=".concat(String.valueOf(txCreateToken)));
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            TXCLog.e(f744a, "RealTimePlayStatisticInfo: " + str + " = " + str2);
            if (!(str == null || str.length() <= 0 || str2 == null)) {
                TXCDRApi.txSetEventValue(txCreateToken, i2, str, str2);
            }
        }
        TXCDRApi.nativeReportEvent(txCreateToken, i2);
        this.u = false;
        this.v = 0;
        this.y = 0;
        this.x = 0;
        this.w = 0;
        AppMethodBeat.o(182276);
    }

    private void l() {
        AppMethodBeat.i(16584);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.f746c;
        long a2 = TXCStatus.a(this.D, 7013);
        String str = (String) this.f745b.get("token");
        TXCDRApi.InitEvent(this.f751h, str, com.tencent.liteav.basic.datareport.a.P, com.tencent.liteav.basic.datareport.a.al, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_device_type", (String) this.f745b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_network_type", (long) g("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_dns_time", -1);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_connect_server_time", -1);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_server_ip", "");
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_video_resolution", (long) ((this.f747d << 16) | this.f748e));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_audio_samplerate", (long) this.f750g);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_video_bitrate", (long) this.f749f);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_user_id", (String) this.f745b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_package_name", (String) this.f745b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_channel_type", a2);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_app_version", this.f752i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "dev_uuid", (String) this.f745b.get("dev_uuid"));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.P);
        TXCLog.d(f744a, "report evt 40001: token=" + str + " str_stream_url=" + this.f746c + " u64_timestamp=" + utcTimeTick + " str_device_type=" + this.f745b.get("str_device_type") + " u32_network_type=" + g("u32_network_type") + " u32_dns_time=-1 u32_connect_server_time=-1 u32_server_ip= u32_video_resolution" + "=" + ((this.f747d << 16) | this.f748e) + " u32_audio_samplerate=" + this.f750g + " u32_video_bitrate=" + this.f749f + " str_user_id=" + this.f745b.get("str_user_id") + " str_package_name=" + this.f745b.get("str_package_name") + " u32_channel_type=" + a2 + " str_app_version=" + this.f745b.get("dev_uuid") + " dev_uuid=" + g("u32_max_load"));
        AppMethodBeat.o(16584);
    }

    private void m() {
        long j2;
        long j3;
        AppMethodBeat.i(16585);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.f746c;
        String b2 = TXCStatus.b(this.D, 7012);
        long a2 = TXCStatus.a(this.D, 7009);
        long a3 = TXCStatus.a(this.D, 7010);
        if (a3 != -1) {
            j2 = a3 - a2;
        } else {
            j2 = a3;
        }
        long a4 = TXCStatus.a(this.D, 7011);
        if (a4 != -1) {
            j3 = a4 - a2;
        } else {
            j3 = a4;
        }
        long a5 = TXCStatus.a(this.D, 7013);
        String str = (String) this.f745b.get("token");
        TXCDRApi.InitEvent(this.f751h, str, com.tencent.liteav.basic.datareport.a.P, com.tencent.liteav.basic.datareport.a.al, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_device_type", (String) this.f745b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_network_type", (long) g("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_dns_time", j2);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_connect_server_time", j3);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_server_ip", b2);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_video_resolution", (long) ((this.f747d << 16) | this.f748e));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_audio_samplerate", (long) this.f750g);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_video_bitrate", (long) this.f749f);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_user_id", (String) this.f745b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_package_name", (String) this.f745b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_channel_type", a5);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_app_version", this.f752i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "dev_uuid", (String) this.f745b.get("dev_uuid"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_nearest_ip_list", TXCStatus.b(this.D, 7019));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.P);
        TXCLog.d(f744a, "report evt 40001: token=" + str + " str_stream_url=" + this.f746c + " u64_timestamp=" + utcTimeTick + " str_device_type=" + this.f745b.get("str_device_type") + " u32_network_type=" + g("u32_network_type") + " u32_dns_time=" + j2 + " u32_connect_server_time=" + j3 + " u32_server_ip=" + b2 + " u32_video_resolution=" + ((this.f747d << 16) | this.f748e) + " u32_audio_samplerate=" + this.f750g + " u32_video_bitrate=" + this.f749f + " str_user_id=" + this.f745b.get("str_user_id") + " str_package_name=" + this.f745b.get("str_package_name") + " u32_channel_type=" + a5 + " str_app_version=" + this.f745b.get("dev_uuid") + " dev_uuid=" + g("u32_max_load"));
        AppMethodBeat.o(16585);
    }

    private void n() {
        AppMethodBeat.i(16586);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.f746c;
        long a2 = TXCStatus.a(this.D, 7009);
        long a3 = TXCStatus.a(this.D, 7013);
        String str = (String) this.f745b.get("token");
        TXCDRApi.InitEvent(this.f751h, str, com.tencent.liteav.basic.datareport.a.R, com.tencent.liteav.basic.datareport.a.al, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.R, "u64_timestamp", utcTimeTick);
        long timeTick = (TXCTimeUtil.getTimeTick() - a2) / 1000;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_result", timeTick);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "str_user_id", (String) this.f745b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "str_package_name", (String) this.f745b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_channel_type", a3);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "str_app_version", this.f752i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "dev_uuid", (String) this.f745b.get("dev_uuid"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_ip_count_quic", String.valueOf(TXCStatus.c(this.D, 7016)));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_connect_count_quic", String.valueOf(TXCStatus.c(this.D, 7017)));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_connect_count_tcp", String.valueOf(TXCStatus.c(this.D, 7018)));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.R);
        TXCLog.d(f744a, "report evt 40002: token=" + str + " str_stream_url=" + this.f746c + " u64_timestamp=" + utcTimeTick + " u32_result=" + timeTick + " str_user_id=" + this.f745b.get("str_user_id") + " str_package_name=" + this.f745b.get("str_package_name") + " u32_channel_type=" + a3 + " str_app_version=" + this.f752i + " dev_uuid=" + this.f745b.get("dev_uuid"));
        AppMethodBeat.o(16586);
    }

    private void o() {
        AppMethodBeat.i(16588);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        tXCDRExtInfo.url = this.f746c;
        int[] a2 = f.a();
        int i2 = a2[0];
        int i3 = a2[1];
        int b2 = f.b();
        long a3 = TXCStatus.a(this.D, 7013);
        int c2 = TXCStatus.c(this.D, 7004);
        int c3 = TXCStatus.c(this.D, 7003);
        double d2 = TXCStatus.d(this.D, 4001);
        int c4 = TXCStatus.c(this.D, 7005);
        int c5 = TXCStatus.c(this.D, 7002);
        int c6 = TXCStatus.c(this.D, TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL);
        int c7 = TXCStatus.c(this.D, WearableStatusCodes.UNKNOWN_CAPABILITY);
        String b3 = TXCStatus.b(this.D, 7012);
        String b4 = TXCStatus.b(this.D, 7014);
        String b5 = TXCStatus.b(this.D, 7015);
        String b6 = TXCStatus.b(this.D, 3001);
        long a4 = TXCStatus.a(this.D, 3002);
        double d3 = TXCStatus.d(this.D, 3003);
        int c8 = TXCStatus.c(this.D, 7020);
        String str = (String) this.f745b.get("token");
        TXCDRApi.InitEvent(this.f751h, str, com.tencent.liteav.basic.datareport.a.Q, com.tencent.liteav.basic.datareport.a.al, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_audio_bitrate", (long) c5);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_video_bitrate", (long) c6);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_net_speed", (long) (c2 + c3));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_fps", (long) ((int) d2));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_cache_size", (long) c4);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_cpu_usage", (long) i3);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_app_cpu_usage", (long) i2);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_memory", (long) b2);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_channel_type", a3);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_app_version", this.f752i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_device_type", (String) this.f745b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_hw_enc", (long) c7);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_server_ip", b3);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_quic_connection_id", b4);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_quic_connection_stats", b5);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_beauty_stats", b6);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_send_strategy", (long) c8);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_preprocess_timecost", a4);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_preprocess_fps_out", (long) ((int) d3));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.Q);
        AppMethodBeat.o(16588);
    }

    private int g(String str) {
        AppMethodBeat.i(222370);
        Number number = (Number) this.f745b.get(str);
        if (number != null) {
            int intValue = number.intValue();
            AppMethodBeat.o(222370);
            return intValue;
        }
        AppMethodBeat.o(222370);
        return 0;
    }

    private void p() {
        AppMethodBeat.i(16589);
        this.p = false;
        this.q = 0;
        this.A = 0;
        String str = this.E;
        if (TextUtils.isEmpty(str)) {
            str = TXCCommonUtil.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = f.b(this.f751h);
        }
        this.f745b.put("str_user_id", str);
        this.f745b.put("str_device_type", f.c());
        this.f745b.put("str_device_type", f.c());
        this.f745b.put("u32_network_type", Integer.valueOf(f.e(this.f751h)));
        this.f745b.put("token", f.e());
        this.f745b.put("str_package_name", f.c(this.f751h));
        this.f745b.put("dev_uuid", f.f(this.f751h));
        this.f745b.put("str_os_info", f.d());
        this.z = TXCTimeUtil.getUtcTimeTick();
        this.f745b.put("u64_timestamp", Long.valueOf(this.z));
        AppMethodBeat.o(16589);
    }
}
