package com.google.android.gms.common;

import com.google.android.gms.common.GoogleCertificates;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
@CheckReturnValue
public class zzg {
    private static final zzg zzbk = new zzg(true, null, null);
    private final Throwable cause;
    final boolean zzbl;
    private final String zzbm;

    static {
        AppMethodBeat.i(5361);
        AppMethodBeat.o(5361);
    }

    zzg(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.zzbl = z;
        this.zzbm = str;
        this.cause = th;
    }

    static zzg zza(String str, GoogleCertificates.CertData certData, boolean z, boolean z2) {
        AppMethodBeat.i(5356);
        zzi zzi = new zzi(str, certData, z, z2);
        AppMethodBeat.o(5356);
        return zzi;
    }

    static zzg zza(String str, Throwable th) {
        AppMethodBeat.i(5358);
        zzg zzg = new zzg(false, str, th);
        AppMethodBeat.o(5358);
        return zzg;
    }

    static zzg zze(String str) {
        AppMethodBeat.i(5357);
        zzg zzg = new zzg(false, str, null);
        AppMethodBeat.o(5357);
        return zzg;
    }

    static zzg zzg() {
        return zzbk;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String getErrorMessage() {
        return this.zzbm;
    }

    /* access modifiers changed from: package-private */
    public final void zzh() {
        AppMethodBeat.i(5359);
        if (!this.zzbl) {
            String valueOf = String.valueOf("GoogleCertificatesRslt: ");
            String valueOf2 = String.valueOf(getErrorMessage());
            String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            if (this.cause != null) {
                SecurityException securityException = new SecurityException(concat, this.cause);
                AppMethodBeat.o(5359);
                throw securityException;
            }
            SecurityException securityException2 = new SecurityException(concat);
            AppMethodBeat.o(5359);
            throw securityException2;
        }
        AppMethodBeat.o(5359);
    }

    /* access modifiers changed from: package-private */
    public final void zzi() {
        AppMethodBeat.i(5360);
        if (!this.zzbl) {
            if (this.cause != null) {
                getErrorMessage();
                AppMethodBeat.o(5360);
                return;
            }
            getErrorMessage();
        }
        AppMethodBeat.o(5360);
    }
}
