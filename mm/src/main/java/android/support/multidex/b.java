package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* access modifiers changed from: package-private */
public final class b {
    private static Method zG;

    static List<File> a(Context context, ApplicationInfo applicationInfo, File file, boolean z) {
        List<File> d2;
        boolean z2 = false;
        new StringBuilder("MultiDexExtractor.load(").append(applicationInfo.sourceDir).append(", ").append(z).append(")");
        File file2 = new File(applicationInfo.sourceDir);
        long m = c.m(file2);
        if (m == -1) {
            m--;
        }
        if (!z) {
            SharedPreferences N = N(context);
            if (!(N.getLong(AppMeasurement.Param.TIMESTAMP, -1) == k(file2) && N.getLong("crc", -1) == m)) {
                z2 = true;
            }
            if (!z2) {
                try {
                    d2 = a(context, file2, file);
                } catch (IOException e2) {
                }
                new StringBuilder("load found ").append(d2.size()).append(" secondary dex files");
                return d2;
            }
        }
        d2 = d(file2, file);
        long k = k(file2);
        SharedPreferences.Editor edit = N(context).edit();
        edit.putLong(AppMeasurement.Param.TIMESTAMP, k);
        edit.putLong("crc", m);
        edit.putInt("dex.number", d2.size() + 1);
        if (zG != null) {
            try {
                zG.invoke(edit, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException e3) {
            }
            new StringBuilder("load found ").append(d2.size()).append(" secondary dex files");
            return d2;
        }
        edit.commit();
        new StringBuilder("load found ").append(d2.size()).append(" secondary dex files");
        return d2;
    }

    private static List<File> a(Context context, File file, File file2) {
        String str = file.getName() + ".classes";
        int i2 = N(context).getInt("dex.number", 1);
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 2; i3 <= i2; i3++) {
            File file3 = new File(file2, str + i3 + ".zip");
            if (file3.isFile()) {
                arrayList.add(file3);
                if (!l(file3)) {
                    new StringBuilder("Invalid zip file: ").append(file3);
                    throw new IOException("Invalid ZIP file.");
                }
            } else {
                throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
            }
        }
        return arrayList;
    }

    private static long k(File file) {
        long lastModified = file.lastModified();
        if (lastModified == -1) {
            return lastModified - 1;
        }
        return lastModified;
    }

    private static List<File> d(File file, File file2) {
        String str = file.getName() + ".classes";
        f(file2, str);
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipEntry entry = zipFile.getEntry(new StringBuilder("classes2.dex").toString());
            int i2 = 2;
            while (entry != null) {
                File file3 = new File(file2, str + i2 + ".zip");
                arrayList.add(file3);
                new StringBuilder("Extraction is needed for file ").append(file3);
                boolean z = false;
                int i3 = 0;
                while (i3 < 3 && !z) {
                    i3++;
                    a(zipFile, entry, file3, str);
                    boolean l = l(file3);
                    new StringBuilder("Extraction ").append(l ? "success" : StateEvent.ProcessResult.FAILED).append(" - length ").append(file3.getAbsolutePath()).append(": ").append(file3.length());
                    if (!l) {
                        file3.delete();
                        if (file3.exists()) {
                            new StringBuilder("Failed to delete corrupted secondary dex '").append(file3.getPath()).append("'");
                            z = l;
                        }
                    }
                    z = l;
                }
                if (!z) {
                    throw new IOException("Could not create zip file " + file3.getAbsolutePath() + " for secondary dex (" + i2 + ")");
                }
                int i4 = i2 + 1;
                entry = zipFile.getEntry("classes" + i4 + ShareConstants.DEX_SUFFIX);
                i2 = i4;
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException e2) {
            }
        }
    }

    private static SharedPreferences N(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static void f(File file, final String str) {
        file.mkdirs();
        if (!file.isDirectory()) {
            throw new IOException("Failed to create dex directory " + file.getPath());
        }
        File[] listFiles = file.listFiles(new FileFilter() {
            /* class android.support.multidex.b.AnonymousClass1 */

            public final boolean accept(File file) {
                return !file.getName().startsWith(str);
            }
        });
        if (listFiles == null) {
            new StringBuilder("Failed to list secondary dex dir content (").append(file.getPath()).append(").");
            return;
        }
        for (File file2 : listFiles) {
            new StringBuilder("Trying to delete old file ").append(file2.getPath()).append(" of size ").append(file2.length());
            if (!file2.delete()) {
                new StringBuilder("Failed to delete old file ").append(file2.getPath());
            } else {
                new StringBuilder("Deleted old file ").append(file2.getPath());
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(str, ".zip", file.getParentFile());
        new StringBuilder("Extracting ").append(createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                new StringBuilder("Renaming to ").append(file.getPath());
                if (!createTempFile.renameTo(file)) {
                    throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
                }
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            closeQuietly(inputStream);
            createTempFile.delete();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
        new java.lang.StringBuilder("Failed to close zip file: ").append(r2.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        new java.lang.StringBuilder("File ").append(r2.getAbsolutePath()).append(" is not a valid zip file.");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001c A[ExcHandler: ZipException (e java.util.zip.ZipException), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean l(java.io.File r2) {
        /*
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ ZipException -> 0x001c, IOException -> 0x0034 }
            r0.<init>(r2)     // Catch:{ ZipException -> 0x001c, IOException -> 0x0034 }
            r0.close()     // Catch:{ IOException -> 0x000a, ZipException -> 0x001c }
            r0 = 1
        L_0x0009:
            return r0
        L_0x000a:
            r0 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to close zip file: "
            r0.<init>(r1)
            java.lang.String r1 = r2.getAbsolutePath()
            r0.append(r1)
        L_0x001a:
            r0 = 0
            goto L_0x0009
        L_0x001c:
            r0 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "File "
            r0.<init>(r1)
            java.lang.String r1 = r2.getAbsolutePath()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = " is not a valid zip file."
            r0.append(r1)
            goto L_0x001a
        L_0x0034:
            r0 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Got an IOException trying to open zip file: "
            r0.<init>(r1)
            java.lang.String r1 = r2.getAbsolutePath()
            r0.append(r1)
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.b.l(java.io.File):boolean");
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
        }
    }

    static {
        try {
            zG = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
        } catch (NoSuchMethodException e2) {
            zG = null;
        }
    }
}
