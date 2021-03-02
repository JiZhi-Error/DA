package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class TPLoadLibFromApk {
    private static Context mContext = null;
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap<>();

    static /* synthetic */ void access$100(Context context) {
        AppMethodBeat.i(189767);
        extractAllLibraries(context);
        AppMethodBeat.o(189767);
    }

    static {
        AppMethodBeat.i(189768);
        AppMethodBeat.o(189768);
    }

    private TPLoadLibFromApk() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0070, code lost:
        if (r8 != null) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, "context is null,load by System.loadLibrary,name= ".concat(java.lang.String.valueOf(r6)));
        reflectSystemLoadLibrary(r6, r7);
        r2 = com.tencent.thumbplayer.core.common.TPLoadLibFromApk.mLoadedLibs;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0086, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        com.tencent.thumbplayer.core.common.TPLoadLibFromApk.mLoadedLibs.put(r6, new java.lang.ref.WeakReference<>(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0092, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(189757);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0099, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(189757);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a1, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed loading library: ".concat(java.lang.String.valueOf(r6))).initCause(r0.getCause());
        com.tencent.matrix.trace.core.AppMethodBeat.o(189757);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00be, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bf, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c0, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed loading library: ".concat(java.lang.String.valueOf(r6))).initCause(r0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(189757);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d9, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00da, code lost:
        r2 = new java.io.File(r8.getDir("recover_lib", 0), com.tencent.tinker.loader.shareutil.ShareConstants.SO_PATH + r6 + ".so");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r0 = loadFromRecovery(r6, r7, r8, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0101, code lost:
        if (r0 != null) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0109, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010a, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(189757);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0117, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0118, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(189757);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return loadFromApk(r6, r7, r8, r2, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean load(java.lang.String r6, java.lang.ClassLoader r7, android.content.Context r8) {
        /*
        // Method dump skipped, instructions count: 287
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPLoadLibFromApk.load(java.lang.String, java.lang.ClassLoader, android.content.Context):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0078 A[SYNTHETIC, Splitter:B:19:0x0078] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.UnsatisfiedLinkError loadFromRecovery(java.lang.String r6, java.lang.ClassLoader r7, android.content.Context r8, java.io.File r9) {
        /*
        // Method dump skipped, instructions count: 308
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPLoadLibFromApk.loadFromRecovery(java.lang.String, java.lang.ClassLoader, android.content.Context, java.io.File):java.lang.UnsatisfiedLinkError");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c A[SYNTHETIC, Splitter:B:15:0x006c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean loadFromApk(java.lang.String r7, java.lang.ClassLoader r8, android.content.Context r9, java.io.File r10, java.lang.UnsatisfiedLinkError r11) {
        /*
        // Method dump skipped, instructions count: 250
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPLoadLibFromApk.loadFromApk(java.lang.String, java.lang.ClassLoader, android.content.Context, java.io.File, java.lang.UnsatisfiedLinkError):boolean");
    }

    public static String find(String str, Context context) {
        String str2;
        AppMethodBeat.i(189760);
        if (context == null) {
            AppMethodBeat.o(189760);
            return null;
        }
        try {
            ClassLoader classLoader = TPLoadLibFromApk.class.getClassLoader();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
            declaredMethod.setAccessible(true);
            str2 = (String) declaredMethod.invoke(classLoader, str);
        } catch (Exception e2) {
            str2 = null;
        }
        if (str2 == null) {
            File file = new File(context.getDir("recover_lib", 0), ShareConstants.SO_PATH + str + ".so");
            if (file.canRead()) {
                str2 = file.getAbsolutePath();
            }
        }
        AppMethodBeat.o(189760);
        return str2;
    }

    private static void reflectSystemLoad(String str, ClassLoader classLoader) {
        AppMethodBeat.i(189761);
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("load", String.class, ClassLoader.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, str, classLoader);
        AppMethodBeat.o(189761);
    }

    private static void reflectSystemLoadLibrary(String str, ClassLoader classLoader) {
        AppMethodBeat.i(189762);
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("loadLibrary", String.class, ClassLoader.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, str, classLoader);
        AppMethodBeat.o(189762);
    }

    private static List<String> generateAbiList() {
        AppMethodBeat.i(189763);
        ArrayList arrayList = new ArrayList(3);
        Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
        String str = (String) method.invoke(null, "ro.product.cpu.abi");
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        String str2 = (String) method.invoke(null, "ro.product.cpu.abi2");
        if (str2 != null && str2.length() > 0) {
            arrayList.add(str2);
        }
        arrayList.add("armeabi");
        AppMethodBeat.o(189763);
        return arrayList;
    }

    private static boolean extractLibrary(ZipFile zipFile, String str, List<String> list, File file) {
        AppMethodBeat.i(189764);
        if (file.isFile()) {
            AppMethodBeat.o(189764);
            return true;
        }
        Iterator<String> it = list.iterator();
        if (it.hasNext()) {
            ZipEntry entry = zipFile.getEntry("lib/" + it.next() + "/lib" + str + ".so");
            if (entry == null) {
                AppMethodBeat.o(189764);
                return false;
            }
            String name = entry.getName();
            if (TextUtils.isEmpty(name) || !name.contains("../")) {
                InputStream inputStream = zipFile.getInputStream(entry);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[2048];
                while (true) {
                    try {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            inputStream.close();
                            fileOutputStream.close();
                            try {
                                file.setReadOnly();
                                AppMethodBeat.o(189764);
                                return true;
                            } catch (Throwable th) {
                                AppMethodBeat.o(189764);
                                return false;
                            }
                        }
                    } catch (Throwable th2) {
                        inputStream.close();
                        fileOutputStream.close();
                        AppMethodBeat.o(189764);
                        throw th2;
                    }
                }
            } else {
                AppMethodBeat.o(189764);
                return false;
            }
        } else {
            AppMethodBeat.o(189764);
            return false;
        }
    }

    private static void extractAllLibraries(Context context) {
        AppMethodBeat.i(189765);
        if (context == null) {
            AppMethodBeat.o(189765);
            return;
        }
        List<String> generateAbiList = generateAbiList();
        File dir = context.getDir("recover_lib", 0);
        ZipFile zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
        try {
            HashSet hashSet = new HashSet();
            Pattern compile = Pattern.compile("lib/[A-Za-z0-9-_=]+/lib([A-Za-z0-9-_=]+)\\.so");
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                String name = zipEntry.getName();
                if (TextUtils.isEmpty(name) || !name.contains("../")) {
                    Matcher matcher = compile.matcher(zipEntry.getName());
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        if (!hashSet.contains(group)) {
                            extractLibrary(zipFile, group, generateAbiList, new File(dir, ShareConstants.SO_PATH + group + ".so"));
                            hashSet.add(group);
                        }
                    }
                } else {
                    Exception exc = new Exception("contain ../, throw err");
                    AppMethodBeat.o(189765);
                    throw exc;
                }
            }
        } finally {
            zipFile.close();
            AppMethodBeat.o(189765);
        }
    }

    static class LibraryBrokenHandler implements Thread.UncaughtExceptionHandler {
        private Thread.UncaughtExceptionHandler mParent;

        LibraryBrokenHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.mParent = uncaughtExceptionHandler;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            boolean z = true;
            AppMethodBeat.i(189756);
            if ((th instanceof UnsatisfiedLinkError) || ((th instanceof NoSuchMethodError) && th.getMessage().matches(".*sig(nature)?[=:].*"))) {
                try {
                    TPLoadLibFromApk.access$100(TPLoadLibFromApk.mContext);
                } catch (Exception e2) {
                    z = false;
                }
            } else {
                z = false;
            }
            if (z) {
                th = new UnsatisfiedLinkError("Invalid so detected and recovered.").initCause(th);
            }
            this.mParent.uncaughtException(thread, th);
            AppMethodBeat.o(189756);
        }
    }

    public static void setupBrokenLibraryHandler() {
        AppMethodBeat.i(189766);
        Thread.setDefaultUncaughtExceptionHandler(new LibraryBrokenHandler(Thread.getDefaultUncaughtExceptionHandler()));
        AppMethodBeat.o(189766);
    }
}
