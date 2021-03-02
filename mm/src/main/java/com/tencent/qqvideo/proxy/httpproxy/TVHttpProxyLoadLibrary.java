package com.tencent.qqvideo.proxy.httpproxy;

import android.content.Context;
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

public final class TVHttpProxyLoadLibrary {
    public static final String ASSETS_LIBRARY_SRC_DIR = "libs/";
    private static Context mContext = null;
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap<>();

    static {
        AppMethodBeat.i(89666);
        AppMethodBeat.o(89666);
    }

    private TVHttpProxyLoadLibrary() {
    }

    public static String find(String str, Context context) {
        String str2;
        AppMethodBeat.i(89667);
        if (context == null) {
            AppMethodBeat.o(89667);
            return null;
        }
        try {
            ClassLoader classLoader = TVHttpProxyLoadLibrary.class.getClassLoader();
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
        AppMethodBeat.o(89667);
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01dd, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed recovering native library: ".concat(java.lang.String.valueOf(r7))).initCause(r0.getCause());
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01fa, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01fb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01fc, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed recovering native library: ".concat(java.lang.String.valueOf(r7))).initCause(r0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0215, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        reflectSystemLoad(r3.getAbsolutePath(), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0222, code lost:
        monitor-enter(com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.mLoadedLibs);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.mLoadedLibs.put(r7, new java.lang.ref.WeakReference<>(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0236, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0237, code lost:
        if (r0 == null) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0239, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed recovering native library: ".concat(java.lang.String.valueOf(r7))).initCause(r1.getCause());
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0256, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0257, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0259, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x025f, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0260, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0261, code lost:
        if (r0 == null) goto L_0x0263;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0263, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed recovering native library.").initCause(r1);
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0274, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0275, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0278, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0279, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x027c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0282, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0283, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0286, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0287, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x028a, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x028d, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        if (r9 != null) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        reflectSystemLoadlibrary(r7, r8);
        r1 = com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.mLoadedLibs;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.mLoadedLibs.put(r7, new java.lang.ref.WeakReference<>(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006f, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0078, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed loading library: ".concat(java.lang.String.valueOf(r7))).initCause(r0.getCause());
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0095, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0096, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0098, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a0, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed loading library: ".concat(java.lang.String.valueOf(r7))).initCause(r0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b9, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ba, code lost:
        r3 = new java.io.File(r9.getDir("recover_lib", 0), com.tencent.tinker.loader.shareutil.ShareConstants.SO_PATH + r7 + ".so");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e2, code lost:
        if (r3.isFile() == false) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        reflectSystemLoad(r3.getAbsolutePath(), r8);
        r1 = com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.mLoadedLibs;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ed, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.mLoadedLibs.put(r7, new java.lang.ref.WeakReference<>(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f8, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0101, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0102, code lost:
        r3.delete();
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        reflectSystemLoadlibrary(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010b, code lost:
        monitor-enter(com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.mLoadedLibs);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.mLoadedLibs.put(r7, new java.lang.ref.WeakReference<>(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0120, code lost:
        if (r1 != null) goto L_0x028a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r1 = new java.util.zip.ZipFile(r9.getApplicationInfo().sourceDir);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0135, code lost:
        if (extractLibrary(r1, r7, generateAbiList(), r3) != false) goto L_0x0216;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0137, code lost:
        r0 = new java.lang.RuntimeException("Can't find recover library: ".concat(java.lang.String.valueOf(r7)));
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed recovering native library.").initCause(r0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0163, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0164, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0165, code lost:
        if (r1 != null) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x016a, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x016d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x016e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0170, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0176, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0177, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x017e, code lost:
        if ((r0.getCause() instanceof java.lang.UnsatisfiedLinkError) != false) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0180, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) r0.getCause();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0188, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed recovering native library: ".concat(java.lang.String.valueOf(r7))).initCause(r0.getCause());
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01a5, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a7, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed recovering native library: ".concat(java.lang.String.valueOf(r7))).initCause(r0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c0, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01c1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01c3, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(89668);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01c9, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01d1, code lost:
        if ((r0.getCause() instanceof java.lang.UnsatisfiedLinkError) != false) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01d3, code lost:
        if (r1 == null) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01d5, code lost:
        r0 = (java.lang.UnsatisfiedLinkError) r0.getCause();
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0216 A[SYNTHETIC, Splitter:B:105:0x0216] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010c A[SYNTHETIC, Splitter:B:55:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0137 A[Catch:{ Exception -> 0x014e }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0167 A[SYNTHETIC, Splitter:B:74:0x0167] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void load(java.lang.String r7, java.lang.ClassLoader r8, android.content.Context r9) {
        /*
        // Method dump skipped, instructions count: 659
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.load(java.lang.String, java.lang.ClassLoader, android.content.Context):void");
    }

    private static void reflectSystemLoad(String str, ClassLoader classLoader) {
        AppMethodBeat.i(89669);
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("load", String.class, ClassLoader.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, str, classLoader);
        AppMethodBeat.o(89669);
    }

    private static void reflectSystemLoadlibrary(String str, ClassLoader classLoader) {
        AppMethodBeat.i(89670);
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("loadLibrary", String.class, ClassLoader.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, str, classLoader);
        AppMethodBeat.o(89670);
    }

    private static List<String> generateAbiList() {
        AppMethodBeat.i(89671);
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
        AppMethodBeat.o(89671);
        return arrayList;
    }

    private static boolean extractLibrary(ZipFile zipFile, String str, List<String> list, File file) {
        AppMethodBeat.i(89672);
        if (file.isFile()) {
            AppMethodBeat.o(89672);
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            ZipEntry entry = zipFile.getEntry("lib/" + it.next() + "/lib" + str + ".so");
            if (entry != null) {
                InputStream inputStream = zipFile.getInputStream(entry);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[2048];
                while (true) {
                    try {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read == -1) {
                            inputStream.close();
                            fileOutputStream.close();
                            file.setReadOnly();
                            AppMethodBeat.o(89672);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        inputStream.close();
                        fileOutputStream.close();
                        AppMethodBeat.o(89672);
                        throw th;
                    }
                }
            }
        }
        AppMethodBeat.o(89672);
        return false;
    }

    static /* synthetic */ void access$1(Context context) {
        AppMethodBeat.i(89675);
        extractAllLibraries(context);
        AppMethodBeat.o(89675);
    }

    private static void extractAllLibraries(Context context) {
        AppMethodBeat.i(89673);
        if (context == null) {
            AppMethodBeat.o(89673);
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
                Matcher matcher = compile.matcher(((ZipEntry) entries.nextElement()).getName());
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    if (!hashSet.contains(group)) {
                        extractLibrary(zipFile, group, generateAbiList, new File(dir, ShareConstants.SO_PATH + group + ".so"));
                        hashSet.add(group);
                    }
                }
            }
        } finally {
            zipFile.close();
            AppMethodBeat.o(89673);
        }
    }

    /* access modifiers changed from: package-private */
    public static class LibraryBrokenHandler implements Thread.UncaughtExceptionHandler {
        private Thread.UncaughtExceptionHandler mParent;

        public LibraryBrokenHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.mParent = uncaughtExceptionHandler;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void uncaughtException(java.lang.Thread r6, java.lang.Throwable r7) {
            /*
                r5 = this;
                r4 = 89665(0x15e41, float:1.25647E-40)
                r0 = 1
                r1 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                boolean r2 = r7 instanceof java.lang.UnsatisfiedLinkError
                if (r2 != 0) goto L_0x003e
                boolean r2 = r7 instanceof java.lang.NoSuchMethodError
                if (r2 == 0) goto L_0x001d
                java.lang.String r2 = r7.getMessage()
                java.lang.String r3 = ".*sig(nature)?[=:].*"
                boolean r2 = r2.matches(r3)
                if (r2 != 0) goto L_0x003e
            L_0x001d:
                r2 = r1
            L_0x001e:
                if (r2 == 0) goto L_0x0041
                android.content.Context r2 = com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.access$0()     // Catch:{ Exception -> 0x0040 }
                com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.access$1(r2)     // Catch:{ Exception -> 0x0040 }
            L_0x0027:
                if (r0 == 0) goto L_0x0035
                java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError
                java.lang.String r1 = "Invalid JNI libraries detected and recovered."
                r0.<init>(r1)
                java.lang.Throwable r7 = r0.initCause(r7)
            L_0x0035:
                java.lang.Thread$UncaughtExceptionHandler r0 = r5.mParent
                r0.uncaughtException(r6, r7)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                return
            L_0x003e:
                r2 = r0
                goto L_0x001e
            L_0x0040:
                r0 = move-exception
            L_0x0041:
                r0 = r1
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary.LibraryBrokenHandler.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
        }
    }

    public static void setupBrokenLibraryHandler() {
        AppMethodBeat.i(89674);
        Thread.setDefaultUncaughtExceptionHandler(new LibraryBrokenHandler(Thread.getDefaultUncaughtExceptionHandler()));
        AppMethodBeat.o(89674);
    }
}
