package org.extra.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.extra.a.c;

public final class a implements c.a {

    /* access modifiers changed from: package-private */
    /* renamed from: org.extra.a.a$a  reason: collision with other inner class name */
    public static class C2384a {
        public ZipEntry UhA;
        public ZipFile Uhz;

        public C2384a(ZipFile zipFile, ZipEntry zipEntry) {
            this.Uhz = zipFile;
            this.UhA = zipEntry;
        }
    }

    private static C2384a b(Context context, String[] strArr, String str) {
        String[] strArr2;
        ZipFile zipFile;
        AppMethodBeat.i(236772);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21 || applicationInfo.splitSourceDirs == null || applicationInfo.splitSourceDirs.length == 0) {
            strArr2 = new String[]{applicationInfo.sourceDir};
        } else {
            strArr2 = new String[(applicationInfo.splitSourceDirs.length + 1)];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(applicationInfo.splitSourceDirs, 0, strArr2, 1, applicationInfo.splitSourceDirs.length);
        }
        int length = strArr2.length;
        int i2 = 0;
        ZipFile zipFile2 = null;
        while (i2 < length) {
            String str2 = strArr2[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= 5) {
                    zipFile = zipFile2;
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException e2) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < 5) {
                        int length2 = strArr.length;
                        for (int i7 = 0; i7 < length2; i7++) {
                            String str3 = ShareConstants.SO_PATH + File.separatorChar + strArr[i7] + File.separatorChar + str;
                            d.t("Looking for %s in APK %s...", str3, str2);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                C2384a aVar = new C2384a(zipFile, entry);
                                AppMethodBeat.o(236772);
                                return aVar;
                            }
                        }
                        i5 = i6;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException e3) {
                        }
                    }
                }
            }
            i2++;
            zipFile2 = zipFile;
        }
        AppMethodBeat.o(236772);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d A[SYNTHETIC, Splitter:B:10:0x001d] */
    @Override // org.extra.a.c.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r11, java.lang.String[] r12, java.lang.String r13, java.io.File r14, org.extra.a.d r15) {
        /*
        // Method dump skipped, instructions count: 245
        */
        throw new UnsupportedOperationException("Method not decompiled: org.extra.a.a.a(android.content.Context, java.lang.String[], java.lang.String, java.io.File, org.extra.a.d):void");
    }

    private static long copy(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(236774);
        long j2 = 0;
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j2 += (long) read;
            } else {
                outputStream.flush();
                AppMethodBeat.o(236774);
                return j2;
            }
        }
    }

    private static void d(Closeable closeable) {
        AppMethodBeat.i(236775);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                AppMethodBeat.o(236775);
                return;
            }
        }
        AppMethodBeat.o(236775);
    }
}
