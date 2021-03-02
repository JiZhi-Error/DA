package com.google.android.gms.common.logging;

import android.annotation.SuppressLint;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class Logger {
    private final String mTag;
    private final String zzud;
    private final GmsLogger zzvd;
    private final int zzve;

    private Logger(String str, String str2) {
        AppMethodBeat.i(4902);
        this.zzud = str2;
        this.mTag = str;
        this.zzvd = new GmsLogger(str);
        int i2 = 2;
        while (7 >= i2 && !Log.isLoggable(this.mTag, i2)) {
            i2++;
        }
        this.zzve = i2;
        AppMethodBeat.o(4902);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Logger(java.lang.String r8, java.lang.String... r9) {
        /*
            r7 = this;
            r6 = 4901(0x1325, float:6.868E-42)
            int r0 = r9.length
            if (r0 != 0) goto L_0x0012
            java.lang.String r0 = ""
        L_0x0008:
            r7.<init>(r8, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x0012:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r0 = 91
            r1.append(r0)
            int r2 = r9.length
            r0 = 0
        L_0x001e:
            if (r0 >= r2) goto L_0x0035
            r3 = r9[r0]
            int r4 = r1.length()
            r5 = 1
            if (r4 <= r5) goto L_0x002f
            java.lang.String r4 = ","
            r1.append(r4)
        L_0x002f:
            r1.append(r3)
            int r0 = r0 + 1
            goto L_0x001e
        L_0x0035:
            r0 = 93
            java.lang.StringBuilder r0 = r1.append(r0)
            r2 = 32
            r0.append(r2)
            java.lang.String r0 = r1.toString()
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.logging.Logger.<init>(java.lang.String, java.lang.String[]):void");
    }

    public void d(String str, Throwable th, Object... objArr) {
        AppMethodBeat.i(4908);
        if (isLoggable(3)) {
            format(str, objArr);
        }
        AppMethodBeat.o(4908);
    }

    public void d(String str, Object... objArr) {
        AppMethodBeat.i(4907);
        if (isLoggable(3)) {
            format(str, objArr);
        }
        AppMethodBeat.o(4907);
    }

    public void e(String str, Throwable th, Object... objArr) {
        AppMethodBeat.i(4914);
        format(str, objArr);
        AppMethodBeat.o(4914);
    }

    public void e(String str, Object... objArr) {
        AppMethodBeat.i(4913);
        format(str, objArr);
        AppMethodBeat.o(4913);
    }

    public String elidePii(Object obj) {
        AppMethodBeat.i(4904);
        boolean canLogPii = this.zzvd.canLogPii();
        if (obj == null) {
            AppMethodBeat.o(4904);
            return "<NULL>";
        }
        String trim = obj.toString().trim();
        if (trim.isEmpty()) {
            AppMethodBeat.o(4904);
            return "<EMPTY>";
        } else if (canLogPii) {
            AppMethodBeat.o(4904);
            return trim;
        } else {
            String format = String.format("<ELLIDED:%s>", Integer.valueOf(trim.hashCode()));
            AppMethodBeat.o(4904);
            return format;
        }
    }

    /* access modifiers changed from: protected */
    public String format(String str, Object... objArr) {
        AppMethodBeat.i(4918);
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        String concat = this.zzud.concat(str);
        AppMethodBeat.o(4918);
        return concat;
    }

    public String getTag() {
        return this.mTag;
    }

    public void i(String str, Throwable th, Object... objArr) {
        AppMethodBeat.i(4910);
        format(str, objArr);
        AppMethodBeat.o(4910);
    }

    public void i(String str, Object... objArr) {
        AppMethodBeat.i(4909);
        format(str, objArr);
        AppMethodBeat.o(4909);
    }

    public boolean isLoggable(int i2) {
        return this.zzve <= i2;
    }

    public boolean isPiiLoggable() {
        AppMethodBeat.i(4903);
        boolean canLogPii = this.zzvd.canLogPii();
        AppMethodBeat.o(4903);
        return canLogPii;
    }

    public void v(String str, Throwable th, Object... objArr) {
        AppMethodBeat.i(4906);
        if (isLoggable(2)) {
            format(str, objArr);
        }
        AppMethodBeat.o(4906);
    }

    public void v(String str, Object... objArr) {
        AppMethodBeat.i(4905);
        if (isLoggable(2)) {
            format(str, objArr);
        }
        AppMethodBeat.o(4905);
    }

    public void w(String str, Throwable th, Object... objArr) {
        AppMethodBeat.i(4912);
        format(str, objArr);
        AppMethodBeat.o(4912);
    }

    public void w(String str, Object... objArr) {
        AppMethodBeat.i(4911);
        format(str, objArr);
        AppMethodBeat.o(4911);
    }

    public void w(Throwable th) {
    }

    public void wtf(String str, Throwable th, Object... objArr) {
        AppMethodBeat.i(4916);
        Log.wtf(this.mTag, format(str, objArr), th);
        AppMethodBeat.o(4916);
    }

    @SuppressLint({"WtfWithoutException"})
    public void wtf(String str, Object... objArr) {
        AppMethodBeat.i(4915);
        Log.wtf(this.mTag, format(str, objArr));
        AppMethodBeat.o(4915);
    }

    public void wtf(Throwable th) {
        AppMethodBeat.i(4917);
        Log.wtf(this.mTag, th);
        AppMethodBeat.o(4917);
    }
}
