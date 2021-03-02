package com.tencent.liteav.network;

import android.content.Context;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private Context f1001a;

    /* renamed from: b  reason: collision with root package name */
    private String f1002b;

    /* renamed from: c  reason: collision with root package name */
    private String f1003c;

    /* renamed from: d  reason: collision with root package name */
    private String f1004d;

    /* renamed from: e  reason: collision with root package name */
    private String f1005e;

    /* renamed from: f  reason: collision with root package name */
    private long f1006f;

    /* renamed from: g  reason: collision with root package name */
    private long f1007g;

    /* renamed from: h  reason: collision with root package name */
    private String f1008h;

    /* renamed from: i  reason: collision with root package name */
    private long f1009i;

    /* renamed from: j  reason: collision with root package name */
    private long f1010j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private long u;
    private long v;
    private boolean w = true;

    public j(Context context) {
        AppMethodBeat.i(15423);
        this.f1001a = context.getApplicationContext();
        this.f1002b = f.b(this.f1001a);
        this.f1004d = "Android";
        i.a().a(this.f1001a);
        a();
        AppMethodBeat.o(15423);
    }

    public void a() {
        this.f1003c = "";
        this.f1006f = 0;
        this.f1007g = -1;
        this.f1008h = "";
        this.f1009i = -1;
        this.f1010j = -1;
        this.k = -1;
        this.l = -1;
        this.f1005e = "";
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = true;
    }

    private void e() {
        AppMethodBeat.i(15424);
        long j2 = this.p;
        long j3 = this.q;
        a();
        this.n = j2;
        this.o = j3;
        AppMethodBeat.o(15424);
    }

    public void b() {
        AppMethodBeat.i(15425);
        this.f1006f = System.currentTimeMillis();
        this.f1003c = i.a().b();
        AppMethodBeat.o(15425);
    }

    public void c() {
        AppMethodBeat.i(15426);
        f();
        e();
        AppMethodBeat.o(15426);
    }

    public void a(boolean z) {
        this.l = z ? 2 : 1;
        if (z) {
            this.w = false;
        }
    }

    public void a(String str) {
        this.f1005e = str;
    }

    public void a(boolean z, String str) {
        AppMethodBeat.i(15427);
        this.f1008h = str;
        if (z) {
            this.f1007g = 1;
            AppMethodBeat.o(15427);
            return;
        }
        if (str != null) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            if (str != null) {
                for (String str2 : str.split("[.]")) {
                    if (!c(str2)) {
                        this.f1007g = 3;
                        AppMethodBeat.o(15427);
                        return;
                    }
                }
                this.f1007g = 2;
            }
        }
        AppMethodBeat.o(15427);
    }

    public void a(long j2, long j3, long j4) {
        this.f1009i = j2;
        this.f1010j = j3;
        this.k = j4;
    }

    public void d() {
        this.m++;
    }

    public void a(long j2, long j3) {
        this.p = j2;
        this.q = j3;
    }

    public void b(long j2, long j3) {
        this.v++;
        this.r += j2;
        this.s += j3;
        if (j2 > this.t) {
            this.t = j2;
        }
        if (j3 > this.u) {
            this.u = j3;
        }
    }

    private void f() {
        float f2;
        float f3;
        AppMethodBeat.i(15428);
        if (this.f1006f == 0 || b(this.f1002b) || b(this.f1005e)) {
            AppMethodBeat.o(15428);
            return;
        }
        String streamIDByStreamUrl = TXCCommonUtil.getStreamIDByStreamUrl(this.f1005e);
        long currentTimeMillis = System.currentTimeMillis() - this.f1006f;
        long j2 = 0;
        long j3 = 0;
        if (this.p > this.n) {
            j2 = this.p - this.n;
        }
        if (this.q > this.o) {
            j3 = this.q - this.o;
        }
        long j4 = 0;
        long j5 = 0;
        if (this.v > 0) {
            j4 = this.r / this.v;
            j5 = this.s / this.v;
        }
        String txCreateToken = TXCDRApi.txCreateToken();
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.f1005e;
        TXCDRApi.InitEvent(this.f1001a, txCreateToken, a.T, a.al, tXCDRExtInfo);
        TXCDRApi.txSetEventValue(txCreateToken, a.T, "str_user_id", this.f1002b);
        TXCDRApi.txSetEventValue(txCreateToken, a.T, "str_stream_id", streamIDByStreamUrl);
        TXCDRApi.txSetEventValue(txCreateToken, a.T, "str_access_id", this.f1003c);
        TXCDRApi.txSetEventValue(txCreateToken, a.T, "str_platform", this.f1004d);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_server_type", this.f1007g);
        TXCDRApi.txSetEventValue(txCreateToken, a.T, "str_server_addr", this.f1008h);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_dns_timecost", this.f1009i);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_connect_timecost", this.f1010j);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_handshake_timecost", this.k);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_push_type", this.l);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_totaltime", currentTimeMillis);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_block_count", this.m);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_video_drop", j2);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_audio_drop", j3);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_video_que_avg", j4);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_audio_que_avg", j5);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_video_que_max", this.t);
        TXCDRApi.txSetEventIntValue(txCreateToken, a.T, "u32_audio_que_max", this.u);
        TXCDRApi.nativeReportEvent(txCreateToken, a.T);
        float f4 = 0.0f;
        float f5 = 0.0f;
        if (currentTimeMillis > 0) {
            if (this.m == 0) {
                f4 = 0.0f;
            } else {
                f4 = (((float) this.m) * 60000.0f) / ((float) currentTimeMillis);
            }
        }
        if (this.v > 0) {
            if (this.r == 0) {
                f3 = 0.0f;
            } else {
                f3 = ((float) this.r) / ((float) this.v);
            }
            if (this.s == 0) {
                f5 = 0.0f;
                f2 = f3;
            } else {
                f5 = ((float) this.s) / ((float) this.v);
                f2 = f3;
            }
        } else {
            f2 = 0.0f;
        }
        if (this.w && !b(this.f1003c) && this.k != -1) {
            i.a().a(this.f1003c, this.f1007g, currentTimeMillis, this.k, f4, f2, f5);
        }
        AppMethodBeat.o(15428);
    }

    private boolean b(String str) {
        AppMethodBeat.i(15429);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(15429);
            return true;
        }
        AppMethodBeat.o(15429);
        return false;
    }

    private boolean c(String str) {
        AppMethodBeat.i(15430);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.o(15430);
        return matches;
    }
}
