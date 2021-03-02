package com.tencent.mm.compatible.util;

import android.content.Context;
import android.net.LocalServerSocket;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class j {
    private static final Set<String> gLq = new TreeSet();
    private static final List<b> gLr = new ArrayList();
    private static final Map<String, ClassLoader> gLs = new ConcurrentHashMap(64);
    private static final a gLt = new a("load-lib-spin");
    private static final Pattern gLu = Pattern.compile("lib([^\\s/]+?)\\.so");
    private static final Method[] gLv = {null};
    private static final Boolean[] gLw = {null};
    private static final String[] gLx = {null};
    private static final ThreadLocal<Boolean> gLy = new ThreadLocal<>();
    private static final ThreadLocal<Boolean> gLz = new ThreadLocal<>();

    public interface b {
        boolean Wt();
    }

    static /* synthetic */ void aV(Object obj) {
        AppMethodBeat.i(125078);
        closeQuietly(obj);
        AppMethodBeat.o(125078);
    }

    static {
        AppMethodBeat.i(125079);
        AppMethodBeat.o(125079);
    }

    public static void Ec(String str) {
        AppMethodBeat.i(125057);
        synchronized (gLq) {
            try {
                gLq.add(str);
                a(2, "MicroMsg.LoadLibrary", "[+] Prior library search path '%s' added.", str);
            } finally {
                AppMethodBeat.o(125057);
            }
        }
    }

    public static void a(b bVar) {
        AppMethodBeat.i(200821);
        synchronized (gLr) {
            try {
                if (!gLr.contains(bVar)) {
                    gLr.add(bVar);
                }
            } finally {
                AppMethodBeat.o(200821);
            }
        }
    }

    private static void apv() {
        AppMethodBeat.i(125058);
        synchronized (gLr) {
            try {
                Iterator<b> it = gLr.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } finally {
                AppMethodBeat.o(125058);
            }
        }
    }

    private static void a(UnsatisfiedLinkError unsatisfiedLinkError) {
        boolean z;
        AppMethodBeat.i(125059);
        synchronized (gLr) {
            boolean z2 = false;
            try {
                for (b bVar : gLr) {
                    if (!bVar.Wt() || z2) {
                        z = z2;
                    } else {
                        z = true;
                    }
                    z2 = z;
                }
                if (!z2) {
                    AppMethodBeat.o(125059);
                    throw unsatisfiedLinkError;
                }
            } finally {
                AppMethodBeat.o(125059);
            }
        }
    }

    public static String dZ(String str) {
        AppMethodBeat.i(125060);
        String Eg = Eg(str);
        if (Eg != null) {
            a(2, "MicroMsg.LoadLibrary", "[+] Found library [%s] at %s.", str, Eg);
            AppMethodBeat.o(125060);
        } else {
            Eg = c(str, j.class.getClassLoader());
            if (Eg != null) {
                a(2, "MicroMsg.LoadLibrary", "[+] Found library [%s] at %s.", str, Eg);
                AppMethodBeat.o(125060);
            } else {
                Eg = z(MMApplicationContext.getContext(), str);
                if (Eg != null) {
                    a(2, "MicroMsg.LoadLibrary", "[+] Found library [%s] at %s.", str, Eg);
                } else {
                    a(4, "MicroMsg.LoadLibrary", "[-] Fail to find library [%s].", Eg);
                }
                AppMethodBeat.o(125060);
            }
        }
        return Eg;
    }

    public static boolean Ee(String str) {
        AppMethodBeat.i(125062);
        boolean containsKey = gLs.containsKey(str);
        AppMethodBeat.o(125062);
        return containsKey;
    }

    private static String Ef(String str) {
        AppMethodBeat.i(125063);
        String str2 = ShareConstants.SO_PATH + str + ".so";
        AppMethodBeat.o(125063);
        return str2;
    }

    private static void a(String str, ClassLoader classLoader) {
        String c2;
        AppMethodBeat.i(200823);
        String Eg = Eg(str);
        if (Eg != null) {
            try {
                Runtime.getRuntime().load(Eg);
                a(2, "MicroMsg.LoadLibrary", "[+] Library [%s] was loaded, path: %s", str, Eg);
                apv();
                AppMethodBeat.o(200823);
                return;
            } catch (UnsatisfiedLinkError e2) {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        } else {
            a(2, "MicroMsg.LoadLibrary", "[+] Try to load library [%s] with cl: %s", str, classLoader);
            c2 = c(str, classLoader);
            if (c2 != null) {
                try {
                    Runtime.getRuntime().load(c2);
                    a(2, "MicroMsg.LoadLibrary", "[+] Library [%s] was loaded, path: %s", str, c2);
                    apv();
                    AppMethodBeat.o(200823);
                    return;
                } catch (UnsatisfiedLinkError e3) {
                    Thread.sleep(5);
                } catch (Throwable th2) {
                }
            }
            b(str, classLoader);
            AppMethodBeat.o(200823);
            return;
        }
        Runtime.getRuntime().load(Eg);
        a(2, "MicroMsg.LoadLibrary", "[+] [RE] Library [%s] was loaded, path: %s", str, Eg);
        apv();
        AppMethodBeat.o(200823);
        return;
        try {
            Runtime.getRuntime().load(c2);
            a(2, "MicroMsg.LoadLibrary", "[+] [RE] Library [%s] was loaded, path: %s", str, c2);
            apv();
            AppMethodBeat.o(200823);
        } catch (UnsatisfiedLinkError e4) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ac, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b0, code lost:
        com.tencent.mm.compatible.util.j.gLt.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c4, code lost:
        r2 = new java.lang.UnsatisfiedLinkError("original crash: " + r0.getClass().getName() + ":" + r0.getMessage());
        r2.setStackTrace(r0.getStackTrace());
        a(r2);
        com.tencent.mm.compatible.util.j.gLt.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0124, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0125, code lost:
        com.tencent.mm.compatible.util.j.gLt.unlock();
        com.tencent.matrix.trace.core.AppMethodBeat.o(125064);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0130, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c3 A[ExcHandler: Throwable (r0v0 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:2:0x0009] */
    @android.annotation.SuppressLint({"UnsafeDynamicallyLoadedCode"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(java.lang.String r8, java.lang.ClassLoader r9) {
        /*
        // Method dump skipped, instructions count: 308
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.util.j.b(java.lang.String, java.lang.ClassLoader):void");
    }

    private static String b(UnsatisfiedLinkError unsatisfiedLinkError) {
        AppMethodBeat.i(125065);
        String message = unsatisfiedLinkError.getMessage();
        if (TextUtils.isEmpty(message)) {
            AppMethodBeat.o(125065);
            return null;
        }
        Matcher matcher = gLu.matcher(message);
        if (matcher.find()) {
            String group = matcher.group(1);
            if (TextUtils.isEmpty(group)) {
                AppMethodBeat.o(125065);
                return null;
            }
            AppMethodBeat.o(125065);
            return group;
        }
        AppMethodBeat.o(125065);
        return null;
    }

    private static String Eg(String str) {
        AppMethodBeat.i(125066);
        String Ef = Ef(str);
        synchronized (gLq) {
            try {
                for (String str2 : gLq) {
                    File file = new File(str2, Ef);
                    if (!file.isDirectory() && file.canRead()) {
                        return file.getAbsolutePath();
                    }
                }
                AppMethodBeat.o(125066);
                return null;
            } finally {
                AppMethodBeat.o(125066);
            }
        }
    }

    private static String c(String str, ClassLoader classLoader) {
        String str2;
        AppMethodBeat.i(125067);
        synchronized (gLv) {
            try {
                Method method = gLv[0];
                if (method == null) {
                    method = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
                    method.setAccessible(true);
                    gLv[0] = method;
                }
                str2 = (String) method.invoke(classLoader, str);
                try {
                } catch (Throwable th) {
                    AppMethodBeat.o(125067);
                    throw th;
                }
            } catch (Throwable th2) {
                b("MicroMsg.LoadLibrary", th2, "[-] Fail to find library in classloader: ".concat(String.valueOf(classLoader)), new Object[0]);
                str2 = null;
                AppMethodBeat.o(125067);
            }
        }
        AppMethodBeat.o(125067);
        return str2;
    }

    private static String z(Context context, String str) {
        AppMethodBeat.i(125068);
        synchronized (gLt) {
            try {
                gLt.lock();
                File file = new File(cz(context), Ef(str));
                if (file.isDirectory() || !file.canRead()) {
                    gLt.unlock();
                    AppMethodBeat.o(125068);
                    return null;
                }
                String absolutePath = file.getAbsolutePath();
                try {
                    gLt.unlock();
                    return absolutePath;
                } finally {
                    AppMethodBeat.o(125068);
                }
            } catch (Throwable th) {
                gLt.unlock();
                AppMethodBeat.o(125068);
                throw th;
            }
        }
    }

    private static File cz(Context context) {
        AppMethodBeat.i(125069);
        File dir = context.getDir("recovery_lib", 0);
        AppMethodBeat.o(125069);
        return dir;
    }

    private static boolean is64BitRuntime() {
        boolean booleanValue;
        AppMethodBeat.i(125070);
        synchronized (gLw) {
            try {
                Boolean bool = gLw[0];
                if (bool == null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        bool = Boolean.valueOf(Process.is64Bit());
                    } else if (Build.VERSION.SDK_INT > 19) {
                        bool = Boolean.valueOf(Build.CPU_ABI.contains("64"));
                    } else {
                        bool = Boolean.FALSE;
                    }
                    gLw[0] = bool;
                }
                booleanValue = bool.booleanValue();
            } finally {
                AppMethodBeat.o(125070);
            }
        }
        return booleanValue;
    }

    private static String A(Context context, String str) {
        String str2;
        String[] strArr;
        ZipFile zipFile;
        IOException e2;
        String str3;
        AppMethodBeat.i(125071);
        synchronized (gLx) {
            try {
                String str4 = gLx[0];
                if (str4 == null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        strArr = is64BitRuntime() ? Build.SUPPORTED_64_BIT_ABIS : Build.SUPPORTED_32_BIT_ABIS;
                    } else {
                        strArr = !TextUtils.isEmpty(Build.CPU_ABI2) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : new String[]{Build.CPU_ABI};
                    }
                    try {
                        zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
                        try {
                            int length = strArr.length;
                            int i2 = 0;
                            String str5 = null;
                            while (true) {
                                if (i2 >= length) {
                                    str2 = str5;
                                    str3 = str4;
                                    break;
                                }
                                str3 = strArr[i2];
                                str5 = "lib/" + str3 + FilePathGenerator.ANDROID_DIR_SEP + str;
                                if (zipFile.getEntry(str5) != null) {
                                    str2 = str5;
                                    break;
                                }
                                i2++;
                            }
                            if (str3 == null) {
                                a(4, "MicroMsg.LoadLibrary", "[-] ", new Object[0]);
                                str2 = null;
                            }
                            closeQuietly(zipFile);
                            gLx[0] = str3;
                        } catch (IOException e3) {
                            e2 = e3;
                            try {
                                IllegalStateException illegalStateException = new IllegalStateException(e2);
                                AppMethodBeat.o(125071);
                                throw illegalStateException;
                            } catch (Throwable th) {
                                th = th;
                                closeQuietly(zipFile);
                                AppMethodBeat.o(125071);
                                throw th;
                            }
                        }
                    } catch (IOException e4) {
                        e2 = e4;
                        zipFile = null;
                        IllegalStateException illegalStateException2 = new IllegalStateException(e2);
                        AppMethodBeat.o(125071);
                        throw illegalStateException2;
                    } catch (Throwable th2) {
                        th = th2;
                        zipFile = null;
                        closeQuietly(zipFile);
                        AppMethodBeat.o(125071);
                        throw th;
                    }
                } else {
                    str2 = "lib/" + str4 + FilePathGenerator.ANDROID_DIR_SEP + str;
                }
            } finally {
                AppMethodBeat.o(125071);
            }
        }
        return str2;
    }

    private static void a(Context context, String str, File file) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        ZipFile zipFile = null;
        AppMethodBeat.i(125072);
        try {
            ZipFile zipFile2 = new ZipFile(context.getApplicationInfo().sourceDir);
            try {
                String A = A(context, str);
                if (A == null) {
                    FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot find " + str + " in apk with best ABI.");
                    AppMethodBeat.o(125072);
                    throw fileNotFoundException;
                }
                ZipEntry entry = zipFile2.getEntry(A);
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    a(3, "MicroMsg.LoadLibrary", "[!] Path %s is a directory, remove it first.", file2.getAbsolutePath());
                    file2.delete();
                } else if (file2.canRead()) {
                    if (E(file2) == entry.getCrc()) {
                        a(3, "MicroMsg.LoadLibrary", "[!] CRC check of [%s] in recovery dir was passed, skip extracting.", str);
                        closeQuietly(zipFile2);
                        AppMethodBeat.o(125072);
                        return;
                    }
                }
                File file3 = new File(file2.getAbsolutePath() + ".tmp");
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                    try {
                        bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(entry));
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                            closeQuietly(bufferedOutputStream);
                            closeQuietly(bufferedInputStream);
                            if (!file3.renameTo(file2)) {
                                IOException iOException = new IOException("Cannot rename " + file3.getAbsolutePath() + " to " + file2.getAbsolutePath());
                                AppMethodBeat.o(125072);
                                throw iOException;
                            }
                            closeQuietly(zipFile2);
                            AppMethodBeat.o(125072);
                        } catch (Throwable th) {
                            th = th;
                            try {
                                file3.delete();
                                AppMethodBeat.o(125072);
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                                closeQuietly(bufferedOutputStream);
                                closeQuietly(bufferedInputStream);
                                AppMethodBeat.o(125072);
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = null;
                        closeQuietly(bufferedOutputStream);
                        closeQuietly(bufferedInputStream);
                        AppMethodBeat.o(125072);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedOutputStream = null;
                    bufferedInputStream = null;
                    closeQuietly(bufferedOutputStream);
                    closeQuietly(bufferedInputStream);
                    AppMethodBeat.o(125072);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                zipFile = zipFile2;
                closeQuietly(zipFile);
                AppMethodBeat.o(125072);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            closeQuietly(zipFile);
            AppMethodBeat.o(125072);
            throw th;
        }
    }

    private static long E(File file) {
        BufferedInputStream bufferedInputStream;
        AppMethodBeat.i(125073);
        CRC32 crc32 = new CRC32();
        byte[] bArr = new byte[4096];
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        crc32.update(bArr, 0, read);
                    } else {
                        long value = crc32.getValue();
                        closeQuietly(bufferedInputStream);
                        AppMethodBeat.o(125073);
                        return value;
                    }
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(bufferedInputStream);
                    AppMethodBeat.o(125073);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            closeQuietly(bufferedInputStream);
            AppMethodBeat.o(125073);
            throw th;
        }
    }

    private static void closeQuietly(Object obj) {
        AppMethodBeat.i(125074);
        if (obj == null) {
            AppMethodBeat.o(125074);
            return;
        }
        try {
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
                AppMethodBeat.o(125074);
            } else if (obj instanceof AutoCloseable) {
                ((AutoCloseable) obj).close();
                AppMethodBeat.o(125074);
            } else if (obj instanceof ZipFile) {
                ((ZipFile) obj).close();
                AppMethodBeat.o(125074);
            } else if (obj instanceof LocalServerSocket) {
                ((LocalServerSocket) obj).close();
                AppMethodBeat.o(125074);
            } else {
                IllegalStateException illegalStateException = new IllegalStateException(obj.getClass().getName() + " is not closeable.");
                AppMethodBeat.o(125074);
                throw illegalStateException;
            }
        } catch (IllegalStateException e2) {
            AppMethodBeat.o(125074);
            throw e2;
        } catch (Throwable th) {
            AppMethodBeat.o(125074);
        }
    }

    private static void a(int i2, String str, String str2, Object... objArr) {
        AppMethodBeat.i(125075);
        Boolean bool = gLy.get();
        if (bool == null || !bool.booleanValue()) {
            gLy.set(Boolean.TRUE);
            switch (i2) {
                case 0:
                    Log.v(str, str2, objArr);
                    break;
                case 1:
                    Log.d(str, str2, objArr);
                    break;
                case 2:
                    Log.i(str, str2, objArr);
                    break;
                case 3:
                    Log.w(str, str2, objArr);
                    break;
                case 4:
                    Log.e(str, str2, objArr);
                    break;
            }
            gLy.set(Boolean.FALSE);
            AppMethodBeat.o(125075);
        } else if (objArr.length == 0) {
            android.util.Log.println(i2, str, str2);
            AppMethodBeat.o(125075);
        } else {
            android.util.Log.println(i2, str, String.format(str2, objArr));
            AppMethodBeat.o(125075);
        }
    }

    private static void b(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(125076);
        Boolean bool = gLz.get();
        if (bool == null || !bool.booleanValue()) {
            gLz.set(Boolean.TRUE);
            Log.printErrStackTrace(str, th, str2, objArr);
            gLz.set(Boolean.FALSE);
        }
        AppMethodBeat.o(125076);
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        private volatile int gLA = 0;
        private LocalServerSocket gLB = null;
        private final String mName;

        a(String str) {
            this.mName = str;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void lock() {
            AppMethodBeat.i(125054);
            if (this.gLB != null) {
                this.gLA++;
                AppMethodBeat.o(125054);
            } else {
                while (true) {
                    try {
                        this.gLB = new LocalServerSocket(this.mName + Process.myUid());
                        this.gLA++;
                        AppMethodBeat.o(125054);
                        break;
                    } catch (Throwable th) {
                    }
                }
            }
            if (this.gLB == null) {
                AppMethodBeat.o(125054);
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized void unlock() {
            AppMethodBeat.i(125055);
            if (this.gLA == 0) {
                AppMethodBeat.o(125055);
            } else {
                this.gLA--;
                if (this.gLA == 0 && this.gLB != null) {
                    j.aV(this.gLB);
                    this.gLB = null;
                }
                AppMethodBeat.o(125055);
            }
        }

        /* access modifiers changed from: protected */
        public final synchronized void finalize() {
            AppMethodBeat.i(125056);
            if (this.gLB != null) {
                j.aV(this.gLB);
                this.gLB = null;
            }
            super.finalize();
            AppMethodBeat.o(125056);
        }
    }

    private j() {
        AppMethodBeat.i(125077);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(125077);
        throw unsupportedOperationException;
    }

    public static void load(String str) {
        AppMethodBeat.i(200822);
        j.class.getClassLoader();
        Ed(str);
        AppMethodBeat.o(200822);
    }

    public static void Ed(String str) {
        AppMethodBeat.i(125061);
        ClassLoader classLoader = j.class.getClassLoader();
        ClassLoader classLoader2 = gLs.get(str);
        if (classLoader2 != null) {
            if (classLoader2 != classLoader) {
                a(new UnsatisfiedLinkError("Library " + str + "to be loaded by classloader: " + classLoader + " has already loaded by classloader: " + classLoader2));
            }
            AppMethodBeat.o(125061);
            return;
        }
        a(str, classLoader);
        gLs.put(str, classLoader);
        AppMethodBeat.o(125061);
    }
}
