package com.tencent.liteav.beauty;

import android.content.Context;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;

    /* renamed from: a  reason: collision with root package name */
    private static a f486a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Context f487b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f488c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f489d = false;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f490e = false;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f491f = false;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f492g = false;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f493h = false;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f494i = false;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f495j = false;
    private static boolean k = false;
    private static boolean l = false;
    private static boolean m = false;
    private static boolean n = false;
    private static boolean o = false;
    private static boolean p = false;
    private static boolean q = false;
    private static boolean r = false;
    private static boolean s = false;
    private static boolean t = false;
    private static boolean u = false;
    private static boolean v = false;
    private static boolean w = false;
    private static boolean x = false;
    private static boolean y = false;
    private static boolean z = false;
    private String F = "ReportDuaManage";

    public static a a() {
        AppMethodBeat.i(15125);
        if (f486a == null) {
            f486a = new a();
        }
        a aVar = f486a;
        AppMethodBeat.o(15125);
        return aVar;
    }

    public void a(Context context) {
        AppMethodBeat.i(15126);
        h();
        f487b = context.getApplicationContext();
        if (!f488c) {
            TXCLog.i(this.F, "reportSDKInit");
            TXCDRApi.txReportDAU(f487b, TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY, 0, "reportSDKInit!");
        }
        f488c = true;
        AppMethodBeat.o(15126);
    }

    public void b() {
        AppMethodBeat.i(15127);
        if (!f489d) {
            TXCLog.i(this.F, "reportBeautyDua");
            TXCDRApi.txReportDAU(f487b, TXLiteAVCode.WARNING_SPEAKER_DEVICE_EMPTY, 0, "reportBeautyDua");
        }
        f489d = true;
        AppMethodBeat.o(15127);
    }

    public void c() {
        AppMethodBeat.i(15128);
        if (!f490e) {
            TXCLog.i(this.F, "reportWhiteDua");
            TXCDRApi.txReportDAU(f487b, TXLiteAVCode.WARNING_MICROPHONE_NOT_AUTHORIZED, 0, "reportWhiteDua");
        }
        f490e = true;
        AppMethodBeat.o(15128);
    }

    public void d() {
        AppMethodBeat.i(15129);
        if (!f491f) {
            TXCLog.i(this.F, "reportRuddyDua");
            TXCDRApi.txReportDAU(f487b, TXLiteAVCode.WARNING_MICROPHONE_DEVICE_ABNORMAL, 0, "reportRuddyDua");
        }
        f491f = true;
        AppMethodBeat.o(15129);
    }

    public void e() {
        AppMethodBeat.i(15130);
        if (!f495j) {
            TXCLog.i(this.F, "reportFilterImageDua");
            TXCDRApi.txReportDAU(f487b, 1208, 0, "reportFilterImageDua");
        }
        f495j = true;
        AppMethodBeat.o(15130);
    }

    public void f() {
        AppMethodBeat.i(15131);
        if (!l) {
            TXCLog.i(this.F, "reportSharpDua");
            TXCDRApi.txReportDAU(f487b, 1210, 0, "reportSharpDua");
        }
        l = true;
        AppMethodBeat.o(15131);
    }

    public void g() {
        AppMethodBeat.i(182271);
        if (!n) {
            TXCLog.i(this.F, "reportWarterMarkDua");
            TXCDRApi.txReportDAU(f487b, 1212, 0, "reportWarterMarkDua");
        }
        n = true;
        AppMethodBeat.o(182271);
    }

    private void h() {
        AppMethodBeat.i(182272);
        TXCLog.i(this.F, "resetReportState");
        f488c = false;
        f489d = false;
        f490e = false;
        f491f = false;
        f492g = false;
        f493h = false;
        f494i = false;
        f495j = false;
        k = false;
        l = false;
        m = false;
        n = false;
        C = false;
        o = false;
        p = false;
        q = false;
        r = false;
        s = false;
        t = false;
        u = false;
        v = false;
        w = false;
        x = false;
        y = false;
        z = false;
        A = false;
        B = false;
        D = false;
        E = false;
        AppMethodBeat.o(182272);
    }
}
