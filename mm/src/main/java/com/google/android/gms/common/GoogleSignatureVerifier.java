package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleCertificates;
import com.google.android.gms.common.internal.ICertData;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zzbv;
    private final Context mContext;

    private GoogleSignatureVerifier(Context context) {
        AppMethodBeat.i(4441);
        this.mContext = context.getApplicationContext();
        AppMethodBeat.o(4441);
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        AppMethodBeat.i(4442);
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (zzbv == null) {
                    GoogleCertificates.init(context);
                    zzbv = new GoogleSignatureVerifier(context);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(4442);
                throw th;
            }
        }
        GoogleSignatureVerifier googleSignatureVerifier = zzbv;
        AppMethodBeat.o(4442);
        return googleSignatureVerifier;
    }

    @VisibleForTesting
    public static synchronized void resetForTests() {
        synchronized (GoogleSignatureVerifier.class) {
            zzbv = null;
        }
    }

    private static GoogleCertificates.CertData zza(PackageInfo packageInfo, GoogleCertificates.CertData... certDataArr) {
        AppMethodBeat.i(4461);
        if (packageInfo.signatures == null) {
            AppMethodBeat.o(4461);
            return null;
        } else if (packageInfo.signatures.length != 1) {
            AppMethodBeat.o(4461);
            return null;
        } else {
            zzb zzb = new zzb(packageInfo.signatures[0].toByteArray());
            for (int i2 = 0; i2 < certDataArr.length; i2++) {
                if (certDataArr[i2].equals(zzb)) {
                    GoogleCertificates.CertData certData = certDataArr[i2];
                    AppMethodBeat.o(4461);
                    return certData;
                }
            }
            AppMethodBeat.o(4461);
            return null;
        }
    }

    private final zzg zza(PackageInfo packageInfo) {
        AppMethodBeat.i(4460);
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
        if (packageInfo == null) {
            zzg zze = zzg.zze("null pkg");
            AppMethodBeat.o(4460);
            return zze;
        } else if (packageInfo.signatures.length != 1) {
            zzg zze2 = zzg.zze("single cert required");
            AppMethodBeat.o(4460);
            return zze2;
        } else {
            zzb zzb = new zzb(packageInfo.signatures[0].toByteArray());
            String str = packageInfo.packageName;
            zzg zza = GoogleCertificates.zza(str, zzb, honorsDebugCertificates);
            if (!zza.zzbl || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || (honorsDebugCertificates && !GoogleCertificates.zza(str, zzb, false).zzbl)) {
                AppMethodBeat.o(4460);
                return zza;
            }
            zzg zze3 = zzg.zze("debuggable release cert app rejected");
            AppMethodBeat.o(4460);
            return zze3;
        }
    }

    private final zzg zzb(int i2) {
        AppMethodBeat.i(4458);
        String[] packagesForUid = Wrappers.packageManager(this.mContext).getPackagesForUid(i2);
        if (packagesForUid == null || packagesForUid.length == 0) {
            zzg zze = zzg.zze("no pkgs");
            AppMethodBeat.o(4458);
            return zze;
        }
        zzg zzg = null;
        for (String str : packagesForUid) {
            zzg = zzf(str);
            if (zzg.zzbl) {
                AppMethodBeat.o(4458);
                return zzg;
            }
        }
        AppMethodBeat.o(4458);
        return zzg;
    }

    private final zzg zzf(String str) {
        AppMethodBeat.i(4459);
        try {
            zzg zza = zza(Wrappers.packageManager(this.mContext).getPackageInfo(str, 64));
            AppMethodBeat.o(4459);
            return zza;
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(str);
            zzg zze = zzg.zze(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
            AppMethodBeat.o(4459);
            return zze;
        }
    }

    @Deprecated
    public Set<byte[]> getAllGoogleSignatures(boolean z) {
        AppMethodBeat.i(4453);
        Set<ICertData> zzd = z ? GoogleCertificates.zzd() : GoogleCertificates.zze();
        HashSet hashSet = new HashSet(zzd.size());
        try {
            for (ICertData iCertData : zzd) {
                hashSet.add((byte[]) ObjectWrapper.unwrap(iCertData.getBytesWrapped()));
            }
        } catch (RemoteException e2) {
        }
        AppMethodBeat.o(4453);
        return hashSet;
    }

    public boolean isChimeraSigned(PackageManager packageManager, PackageInfo packageInfo) {
        AppMethodBeat.i(4457);
        String str = packageInfo.packageName;
        packageInfo.packageName = ProviderConstants.API_PROVIDER_NAME;
        boolean isPackageGoogleSigned = isPackageGoogleSigned(packageInfo);
        packageInfo.packageName = str;
        AppMethodBeat.o(4457);
        return isPackageGoogleSigned;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        AppMethodBeat.i(4456);
        if (packageInfo == null) {
            AppMethodBeat.o(4456);
            return false;
        } else if (isGooglePublicSignedPackage(packageInfo, false)) {
            AppMethodBeat.o(4456);
            return true;
        } else if (!isGooglePublicSignedPackage(packageInfo, true) || !GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext)) {
            AppMethodBeat.o(4456);
            return false;
        } else {
            AppMethodBeat.o(4456);
            return true;
        }
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo, boolean z) {
        GoogleCertificates.CertData zza;
        AppMethodBeat.i(4454);
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zza = zza(packageInfo, zzd.zzbg);
            } else {
                zza = zza(packageInfo, zzd.zzbg[0]);
            }
            if (zza != null) {
                AppMethodBeat.o(4454);
                return true;
            }
        }
        AppMethodBeat.o(4454);
        return false;
    }

    @Deprecated
    public boolean isGooglePublicSignedPackage(PackageManager packageManager, PackageInfo packageInfo) {
        AppMethodBeat.i(4455);
        boolean isGooglePublicSignedPackage = isGooglePublicSignedPackage(packageInfo);
        AppMethodBeat.o(4455);
        return isGooglePublicSignedPackage;
    }

    public boolean isPackageGoogleSigned(PackageInfo packageInfo) {
        AppMethodBeat.i(4452);
        zzg zza = zza(packageInfo);
        zza.zzi();
        boolean z = zza.zzbl;
        AppMethodBeat.o(4452);
        return z;
    }

    @Deprecated
    public boolean isPackageGoogleSigned(PackageManager packageManager, PackageInfo packageInfo) {
        AppMethodBeat.i(4451);
        boolean isPackageGoogleSigned = isPackageGoogleSigned(packageInfo);
        AppMethodBeat.o(4451);
        return isPackageGoogleSigned;
    }

    @Deprecated
    public boolean isPackageGoogleSigned(PackageManager packageManager, String str) {
        AppMethodBeat.i(4449);
        boolean isPackageGoogleSigned = isPackageGoogleSigned(str);
        AppMethodBeat.o(4449);
        return isPackageGoogleSigned;
    }

    public boolean isPackageGoogleSigned(String str) {
        AppMethodBeat.i(4450);
        zzg zzf = zzf(str);
        zzf.zzi();
        boolean z = zzf.zzbl;
        AppMethodBeat.o(4450);
        return z;
    }

    public boolean isUidGoogleSigned(int i2) {
        AppMethodBeat.i(4446);
        zzg zzb = zzb(i2);
        zzb.zzi();
        boolean z = zzb.zzbl;
        AppMethodBeat.o(4446);
        return z;
    }

    @Deprecated
    public boolean isUidGoogleSigned(PackageManager packageManager, int i2) {
        AppMethodBeat.i(4445);
        boolean isUidGoogleSigned = isUidGoogleSigned(i2);
        AppMethodBeat.o(4445);
        return isUidGoogleSigned;
    }

    @Deprecated
    public void verifyPackageIsGoogleSigned(PackageManager packageManager, String str) {
        AppMethodBeat.i(4447);
        verifyPackageIsGoogleSigned(str);
        AppMethodBeat.o(4447);
    }

    public void verifyPackageIsGoogleSigned(String str) {
        AppMethodBeat.i(4448);
        zzf(str).zzh();
        AppMethodBeat.o(4448);
    }

    public void verifyUidIsGoogleSigned(int i2) {
        AppMethodBeat.i(4444);
        zzb(i2).zzh();
        AppMethodBeat.o(4444);
    }

    @Deprecated
    public void verifyUidIsGoogleSigned(PackageManager packageManager, int i2) {
        AppMethodBeat.i(4443);
        verifyUidIsGoogleSigned(i2);
        AppMethodBeat.o(4443);
    }
}
