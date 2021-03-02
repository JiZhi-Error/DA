package com.tencent.e.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public static List<com.tencent.e.a.a> md(Context context) {
        AppMethodBeat.i(138451);
        ArrayList arrayList = new ArrayList();
        try {
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(0)) {
                if (applicationInfo.packageName != null && !applicationInfo.packageName.equals(packageName)) {
                    boolean z = (applicationInfo.flags & 1) != 0;
                    com.tencent.e.a.a cT = cT(context, applicationInfo.packageName);
                    cT.RKP = packageManager.getApplicationLabel(applicationInfo).toString();
                    if (cT.RKP == null) {
                        cT.RKP = "";
                    }
                    cT.appType = z ? 1 : 0;
                    cT.fileSize = new File(applicationInfo.sourceDir).length();
                    cT.RKR = applicationInfo.sourceDir;
                    arrayList.add(cT);
                    new StringBuilder("add app: ").append(applicationInfo.packageName);
                    h.hkS();
                }
            }
        } catch (Throwable th) {
            h.ez("getAllAppInfos(), exception: ".concat(String.valueOf(th)));
        }
        AppMethodBeat.o(138451);
        return arrayList;
    }

    public static List<byte[]> cS(Context context, String str) {
        AppMethodBeat.i(138452);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                Signature[] signatureArr = packageInfo.signatures;
                int i2 = 0;
                while (i2 < signatureArr.length && i2 < 5) {
                    X509Certificate x509Certificate = (X509Certificate) a(CertificateFactory.getInstance("X.509"), signatureArr[i2]);
                    if (x509Certificate != null) {
                        try {
                            arrayList.add(e.cX(x509Certificate.getEncoded()));
                        } catch (CertificateEncodingException e2) {
                            h.eA("extractPkgCertMd5s(), CertificateEncodingException: ".concat(String.valueOf(e2)));
                        }
                    }
                    i2++;
                }
            }
        } catch (Throwable th) {
            h.eA("extractPkgCertMd5s(), Exception: ".concat(String.valueOf(th)));
        }
        AppMethodBeat.o(138452);
        return arrayList;
    }

    public static com.tencent.e.a.a cT(Context context, String str) {
        AppMethodBeat.i(138453);
        com.tencent.e.a.a aVar = new com.tencent.e.a.a();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            aVar.pkgName = str;
            aVar.versionName = packageInfo.versionName;
            aVar.versionCode = packageInfo.versionCode;
            X509Certificate x509Certificate = (X509Certificate) a(CertificateFactory.getInstance("X.509"), packageInfo.signatures[0]);
            if (x509Certificate != null) {
                aVar.RKQ = e.bytesToHexString(e.cX(x509Certificate.getEncoded()));
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(138453);
        return aVar;
    }

    private static Certificate a(CertificateFactory certificateFactory, Signature signature) {
        X509Certificate x509Certificate;
        AppMethodBeat.i(138454);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        try {
            x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
            } catch (IOException e2) {
            }
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (IOException e3) {
            }
            AppMethodBeat.o(138454);
            throw th;
        }
        AppMethodBeat.o(138454);
        return x509Certificate;
    }
}
