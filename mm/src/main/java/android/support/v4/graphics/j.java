package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.os.StrictMode;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class j {
    public static File X(Context context) {
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i2 = 0; i2 < 100; i2++) {
            File file = new File(context.getCacheDir(), str + i2);
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (IOException e2) {
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        r1 = r0;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r1 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.nio.ByteBuffer p(java.io.File r8) {
        /*
            r6 = 0
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0024 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0024 }
            java.nio.channels.FileChannel r0 = r7.getChannel()     // Catch:{ Throwable -> 0x001a, all -> 0x0030 }
            long r4 = r0.size()     // Catch:{ Throwable -> 0x001a, all -> 0x0030 }
            java.nio.channels.FileChannel$MapMode r1 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ Throwable -> 0x001a, all -> 0x0030 }
            r2 = 0
            java.nio.MappedByteBuffer r0 = r0.map(r1, r2, r4)     // Catch:{ Throwable -> 0x001a, all -> 0x0030 }
            r7.close()
        L_0x0019:
            return r0
        L_0x001a:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x001c }
        L_0x001c:
            r1 = move-exception
            r2 = r0
        L_0x001e:
            if (r2 == 0) goto L_0x002c
            r7.close()     // Catch:{ Throwable -> 0x0027 }
        L_0x0023:
            throw r1
        L_0x0024:
            r0 = move-exception
            r0 = r6
            goto L_0x0019
        L_0x0027:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L_0x0023
        L_0x002c:
            r7.close()
            goto L_0x0023
        L_0x0030:
            r0 = move-exception
            r1 = r0
            r2 = r6
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.j.p(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0055, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0056, code lost:
        r1 = r0;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0066, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0067, code lost:
        r1 = r0;
        r2 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0055 A[ExcHandler: all (r0v3 'th' java.lang.Throwable A[CUSTOM_DECLARE])] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.ByteBuffer a(android.content.Context r9, android.os.CancellationSignal r10, android.net.Uri r11) {
        /*
        // Method dump skipped, instructions count: 106
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.j.a(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    public static ByteBuffer a(Context context, Resources resources, int i2) {
        File X = X(context);
        if (X == null) {
            return null;
        }
        try {
            if (!a(X, resources, i2)) {
                return null;
            }
            ByteBuffer p = p(X);
            X.delete();
            return p;
        } finally {
            X.delete();
        }
    }

    public static boolean a(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        Throwable th;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            fileOutputStream = new FileOutputStream(file, false);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        closeQuietly(fileOutputStream);
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                        return true;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    new StringBuilder("Error copying resource contents to temp file: ").append(e.getMessage());
                    closeQuietly(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            new StringBuilder("Error copying resource contents to temp file: ").append(e.getMessage());
            closeQuietly(fileOutputStream);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            closeQuietly(fileOutputStream);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static boolean a(File file, Resources resources, int i2) {
        InputStream inputStream = null;
        try {
            inputStream = resources.openRawResource(i2);
            return a(file, inputStream);
        } finally {
            closeQuietly(inputStream);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
            }
        }
    }
}
