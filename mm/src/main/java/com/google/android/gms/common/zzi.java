package com.google.android.gms.common;

import com.google.android.gms.common.GoogleCertificates;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzi extends zzg {
    private final String packageName;
    private final GoogleCertificates.CertData zzbn;
    private final boolean zzbo;
    private final boolean zzbp;

    private zzi(String str, GoogleCertificates.CertData certData, boolean z, boolean z2) {
        super(false, null, null);
        this.packageName = str;
        this.zzbn = certData;
        this.zzbo = z;
        this.zzbp = z2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.zzg
    public final String getErrorMessage() {
        AppMethodBeat.i(5362);
        String str = this.zzbp ? "debug cert rejected" : "not whitelisted";
        String str2 = this.packageName;
        String bytesToStringLowercase = Hex.bytesToStringLowercase(AndroidUtilsLight.getMessageDigest("SHA-1").digest(this.zzbn.getBytes()));
        String sb = new StringBuilder(String.valueOf(str).length() + 44 + String.valueOf(str2).length() + String.valueOf(bytesToStringLowercase).length()).append(str).append(": pkg=").append(str2).append(", sha1=").append(bytesToStringLowercase).append(", atk=").append(this.zzbo).append(", ver=12451009.false").toString();
        AppMethodBeat.o(5362);
        return sb;
    }
}
