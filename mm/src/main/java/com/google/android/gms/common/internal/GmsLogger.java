package com.google.android.gms.common.internal;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GmsLogger {
    public static final int MAX_PII_TAG_LENGTH = 15;
    public static final int MAX_TAG_LENGTH = 23;
    private static final String zzub = null;
    private final String zzuc;
    private final String zzud;

    public GmsLogger(String str) {
        this(str, null);
    }

    public GmsLogger(String str, String str2) {
        AppMethodBeat.i(4664);
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zzuc = str;
        if (str2 == null || str2.length() <= 0) {
            this.zzud = null;
            AppMethodBeat.o(4664);
            return;
        }
        this.zzud = str2;
        AppMethodBeat.o(4664);
    }

    public static boolean isBuildPiiEnabled() {
        return false;
    }

    private final String zza(String str, Object... objArr) {
        AppMethodBeat.i(4687);
        String format = String.format(str, objArr);
        if (this.zzud == null) {
            AppMethodBeat.o(4687);
            return format;
        }
        String concat = this.zzud.concat(format);
        AppMethodBeat.o(4687);
        return concat;
    }

    private final String zzl(String str) {
        AppMethodBeat.i(4686);
        if (this.zzud == null) {
            AppMethodBeat.o(4686);
            return str;
        }
        String concat = this.zzud.concat(str);
        AppMethodBeat.o(4686);
        return concat;
    }

    public final boolean canLog(int i2) {
        AppMethodBeat.i(4666);
        boolean isLoggable = Log.isLoggable(this.zzuc, i2);
        AppMethodBeat.o(4666);
        return isLoggable;
    }

    public final boolean canLogPii() {
        return false;
    }

    public final void d(String str, String str2) {
        AppMethodBeat.i(4667);
        if (canLog(3)) {
            zzl(str2);
        }
        AppMethodBeat.o(4667);
    }

    public final void d(String str, String str2, Throwable th) {
        AppMethodBeat.i(4668);
        if (canLog(3)) {
            zzl(str2);
        }
        AppMethodBeat.o(4668);
    }

    public final void dfmt(String str, String str2, Object... objArr) {
        AppMethodBeat.i(4669);
        if (canLog(3)) {
            zza(str2, objArr);
        }
        AppMethodBeat.o(4669);
    }

    public final void e(String str, String str2) {
        AppMethodBeat.i(4679);
        if (canLog(6)) {
            zzl(str2);
        }
        AppMethodBeat.o(4679);
    }

    public final void e(String str, String str2, Throwable th) {
        AppMethodBeat.i(4680);
        if (canLog(6)) {
            zzl(str2);
        }
        AppMethodBeat.o(4680);
    }

    public final void efmt(String str, String str2, Object... objArr) {
        AppMethodBeat.i(4681);
        if (canLog(6)) {
            zza(str2, objArr);
        }
        AppMethodBeat.o(4681);
    }

    public final String getTag() {
        return this.zzuc;
    }

    public final void i(String str, String str2) {
        AppMethodBeat.i(4673);
        if (canLog(4)) {
            zzl(str2);
        }
        AppMethodBeat.o(4673);
    }

    public final void i(String str, String str2, Throwable th) {
        AppMethodBeat.i(4674);
        if (canLog(4)) {
            zzl(str2);
        }
        AppMethodBeat.o(4674);
    }

    public final void ifmt(String str, String str2, Object... objArr) {
        AppMethodBeat.i(4675);
        if (canLog(4)) {
            zza(str2, objArr);
        }
        AppMethodBeat.o(4675);
    }

    public final void pii(String str, String str2) {
        AppMethodBeat.i(4683);
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(" PII_LOG");
            if (valueOf2.length() != 0) {
                valueOf.concat(valueOf2);
            } else {
                new String(valueOf);
            }
            zzl(str2);
        }
        AppMethodBeat.o(4683);
    }

    public final void pii(String str, String str2, Throwable th) {
        AppMethodBeat.i(4684);
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(" PII_LOG");
            if (valueOf2.length() != 0) {
                valueOf.concat(valueOf2);
            } else {
                new String(valueOf);
            }
            zzl(str2);
        }
        AppMethodBeat.o(4684);
    }

    public final void piifmt(String str, String str2, Object... objArr) {
        AppMethodBeat.i(4685);
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(" PII_LOG");
            if (valueOf2.length() != 0) {
                valueOf.concat(valueOf2);
            } else {
                new String(valueOf);
            }
            zza(str2, objArr);
        }
        AppMethodBeat.o(4685);
    }

    public final void v(String str, String str2) {
        AppMethodBeat.i(4670);
        if (canLog(2)) {
            zzl(str2);
        }
        AppMethodBeat.o(4670);
    }

    public final void v(String str, String str2, Throwable th) {
        AppMethodBeat.i(4671);
        if (canLog(2)) {
            zzl(str2);
        }
        AppMethodBeat.o(4671);
    }

    public final void vfmt(String str, String str2, Object... objArr) {
        AppMethodBeat.i(4672);
        if (canLog(2)) {
            zza(str2, objArr);
        }
        AppMethodBeat.o(4672);
    }

    public final void w(String str, String str2) {
        AppMethodBeat.i(4676);
        if (canLog(5)) {
            zzl(str2);
        }
        AppMethodBeat.o(4676);
    }

    public final void w(String str, String str2, Throwable th) {
        AppMethodBeat.i(4677);
        if (canLog(5)) {
            zzl(str2);
        }
        AppMethodBeat.o(4677);
    }

    public final void wfmt(String str, String str2, Object... objArr) {
        AppMethodBeat.i(4678);
        if (canLog(5)) {
            zza(str2, objArr);
        }
        AppMethodBeat.o(4678);
    }

    public final GmsLogger withMessagePrefix(String str) {
        AppMethodBeat.i(4665);
        GmsLogger gmsLogger = new GmsLogger(this.zzuc, str);
        AppMethodBeat.o(4665);
        return gmsLogger;
    }

    public final void wtf(String str, String str2, Throwable th) {
        AppMethodBeat.i(4682);
        if (canLog(7)) {
            zzl(str2);
            Log.wtf(str, zzl(str2), th);
        }
        AppMethodBeat.o(4682);
    }
}
