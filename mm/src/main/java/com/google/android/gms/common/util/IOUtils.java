package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import javax.annotation.Nullable;

public final class IOUtils {

    /* access modifiers changed from: package-private */
    public static final class zza extends ByteArrayOutputStream {
        private zza() {
        }

        /* access modifiers changed from: package-private */
        public final void zza(byte[] bArr, int i2) {
            AppMethodBeat.i(5240);
            System.arraycopy(this.buf, 0, bArr, i2, this.count);
            AppMethodBeat.o(5240);
        }
    }

    static final class zzb {
        private final File file;

        private zzb(File file2) {
            AppMethodBeat.i(5241);
            this.file = (File) Preconditions.checkNotNull(file2);
            AppMethodBeat.o(5241);
        }

        public final byte[] zzdd() {
            FileInputStream fileInputStream;
            Throwable th;
            AppMethodBeat.i(5242);
            try {
                fileInputStream = new FileInputStream(this.file);
                try {
                    byte[] zzb = IOUtils.zzb(fileInputStream, fileInputStream.getChannel().size());
                    IOUtils.closeQuietly(fileInputStream);
                    AppMethodBeat.o(5242);
                    return zzb;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly(fileInputStream);
                    AppMethodBeat.o(5242);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                IOUtils.closeQuietly(fileInputStream);
                AppMethodBeat.o(5242);
                throw th;
            }
        }
    }

    private IOUtils() {
    }

    public static void close(@Nullable Closeable closeable, String str, String str2) {
        AppMethodBeat.i(5247);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(5247);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(5247);
    }

    public static void closeQuietly(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(5244);
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
                AppMethodBeat.o(5244);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(5244);
    }

    public static void closeQuietly(@Nullable Closeable closeable) {
        AppMethodBeat.i(5243);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(5243);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(5243);
    }

    public static void closeQuietly(@Nullable ServerSocket serverSocket) {
        AppMethodBeat.i(5246);
        if (serverSocket != null) {
            try {
                serverSocket.close();
                AppMethodBeat.o(5246);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(5246);
    }

    public static void closeQuietly(@Nullable Socket socket) {
        AppMethodBeat.i(5245);
        if (socket != null) {
            try {
                socket.close();
                AppMethodBeat.o(5245);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(5245);
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(5248);
        long copyStream = copyStream(inputStream, outputStream, false);
        AppMethodBeat.o(5248);
        return copyStream;
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream, boolean z) {
        AppMethodBeat.i(5249);
        long copyStream = copyStream(inputStream, outputStream, z, 1024);
        AppMethodBeat.o(5249);
        return copyStream;
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream, boolean z, int i2) {
        AppMethodBeat.i(5250);
        byte[] bArr = new byte[i2];
        long j2 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i2);
                if (read == -1) {
                    break;
                }
                j2 += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    closeQuietly(inputStream);
                    closeQuietly(outputStream);
                }
                AppMethodBeat.o(5250);
            }
        }
        return j2;
    }

    public static boolean isGzipByteBuffer(byte[] bArr) {
        return bArr.length > 1 && ((bArr[0] & 255) | ((bArr[1] & 255) << 8)) == 35615;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void lockAndTruncateFile(java.io.File r7) {
        /*
            r2 = 0
            r6 = 5255(0x1487, float:7.364E-42)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            boolean r0 = r7.exists()
            if (r0 != 0) goto L_0x0015
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException
            r0.<init>()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            throw r0
        L_0x0015:
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ all -> 0x003c }
            java.lang.String r0 = "rw"
            r3.<init>(r7, r0)     // Catch:{ all -> 0x003c }
            java.nio.channels.FileChannel r0 = r3.getChannel()     // Catch:{ all -> 0x0057 }
            java.nio.channels.FileLock r1 = r0.lock()     // Catch:{ all -> 0x0057 }
            r4 = 0
            r0.truncate(r4)     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x0035
            boolean r0 = r1.isValid()
            if (r0 == 0) goto L_0x0035
            r1.release()     // Catch:{ IOException -> 0x0053 }
        L_0x0035:
            closeQuietly(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x003c:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L_0x003f:
            if (r1 == 0) goto L_0x004a
            boolean r2 = r1.isValid()
            if (r2 == 0) goto L_0x004a
            r1.release()     // Catch:{ IOException -> 0x0055 }
        L_0x004a:
            if (r3 == 0) goto L_0x004f
            closeQuietly(r3)
        L_0x004f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            throw r0
        L_0x0053:
            r0 = move-exception
            goto L_0x0035
        L_0x0055:
            r1 = move-exception
            goto L_0x004a
        L_0x0057:
            r0 = move-exception
            r1 = r2
            goto L_0x003f
        L_0x005a:
            r0 = move-exception
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.IOUtils.lockAndTruncateFile(java.io.File):void");
    }

    public static byte[] readInputStreamFully(InputStream inputStream) {
        AppMethodBeat.i(5251);
        byte[] readInputStreamFully = readInputStreamFully(inputStream, true);
        AppMethodBeat.o(5251);
        return readInputStreamFully;
    }

    public static byte[] readInputStreamFully(InputStream inputStream, boolean z) {
        AppMethodBeat.i(5252);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyStream(inputStream, byteArrayOutputStream, z);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(5252);
        return byteArray;
    }

    public static byte[] toByteArray(File file) {
        AppMethodBeat.i(5253);
        byte[] zzdd = new zzb(file).zzdd();
        AppMethodBeat.o(5253);
        return zzdd;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        AppMethodBeat.i(5254);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zza(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(5254);
        return byteArray;
    }

    private static long zza(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(5257);
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] bArr = new byte[4096];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j2 += (long) read;
            } else {
                AppMethodBeat.o(5257);
                return j2;
            }
        }
    }

    private static byte[] zza(InputStream inputStream, long j2) {
        AppMethodBeat.i(5256);
        if (j2 > 2147483647L) {
            OutOfMemoryError outOfMemoryError = new OutOfMemoryError(new StringBuilder(68).append("file is too large to fit in a byte array: ").append(j2).append(" bytes").toString());
            AppMethodBeat.o(5256);
            throw outOfMemoryError;
        } else if (j2 == 0) {
            byte[] byteArray = toByteArray(inputStream);
            AppMethodBeat.o(5256);
            return byteArray;
        } else {
            int i2 = (int) j2;
            byte[] bArr = new byte[i2];
            int i3 = i2;
            while (i3 > 0) {
                int i4 = i2 - i3;
                int read = inputStream.read(bArr, i4, i3);
                if (read == -1) {
                    byte[] copyOf = Arrays.copyOf(bArr, i4);
                    AppMethodBeat.o(5256);
                    return copyOf;
                }
                i3 -= read;
            }
            int read2 = inputStream.read();
            if (read2 == -1) {
                AppMethodBeat.o(5256);
                return bArr;
            }
            zza zza2 = new zza();
            zza2.write(read2);
            zza(inputStream, zza2);
            byte[] copyOf2 = Arrays.copyOf(bArr, zza2.size() + i2);
            zza2.zza(copyOf2, i2);
            AppMethodBeat.o(5256);
            return copyOf2;
        }
    }

    static /* synthetic */ byte[] zzb(InputStream inputStream, long j2) {
        AppMethodBeat.i(5258);
        byte[] zza2 = zza(inputStream, j2);
        AppMethodBeat.o(5258);
        return zza2;
    }
}
