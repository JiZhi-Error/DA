package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;

class LibraryLoader {
    static final String DELIMITER = System.getProperty("line.separator");
    static final String SEPARATOR = System.getProperty("file.separator");
    static final String SWT_LIB_DIR = ".j2v8";

    LibraryLoader() {
    }

    static {
        AppMethodBeat.i(61585);
        AppMethodBeat.o(61585);
    }

    private static String computeLibraryShortName() {
        AppMethodBeat.i(61570);
        String str = "j2v8" + "_" + getOS() + "_" + getArchSuffix();
        AppMethodBeat.o(61570);
        return str;
    }

    private static String computeLibraryFullName() {
        AppMethodBeat.i(61571);
        String str = ShareConstants.SO_PATH + computeLibraryShortName() + "." + getOSFileExtension();
        AppMethodBeat.o(61571);
        return str;
    }

    static void loadLibrary(String str) {
        AppMethodBeat.i(61572);
        if (isAndroid()) {
            System.loadLibrary("mmj2v8");
            AppMethodBeat.o(61572);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String computeLibraryShortName = computeLibraryShortName();
        String computeLibraryFullName = computeLibraryFullName();
        String str2 = System.getProperty("user.dir") + SEPARATOR + "jni" + SEPARATOR + computeLibraryFullName();
        if (load(computeLibraryFullName, stringBuffer)) {
            AppMethodBeat.o(61572);
        } else if (load(computeLibraryShortName, stringBuffer)) {
            AppMethodBeat.o(61572);
        } else if (!new File(str2).exists() || !load(str2, stringBuffer)) {
            if (str == null) {
                str = System.getProperty("java.io.tmpdir");
            }
            if (extract(str + SEPARATOR + computeLibraryFullName, computeLibraryFullName, stringBuffer)) {
                AppMethodBeat.o(61572);
                return;
            }
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Could not load J2V8 library. Reasons: " + stringBuffer.toString());
            AppMethodBeat.o(61572);
            throw unsatisfiedLinkError;
        } else {
            AppMethodBeat.o(61572);
        }
    }

    static boolean load(String str, StringBuffer stringBuffer) {
        AppMethodBeat.i(61573);
        try {
            if (str.indexOf(SEPARATOR) != -1) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            AppMethodBeat.o(61573);
            return true;
        } catch (UnsatisfiedLinkError e2) {
            if (stringBuffer.length() == 0) {
                stringBuffer.append(DELIMITER);
            }
            stringBuffer.append('\t');
            stringBuffer.append(e2.getMessage());
            stringBuffer.append(DELIMITER);
            AppMethodBeat.o(61573);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042 A[SYNTHETIC, Splitter:B:16:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047 A[SYNTHETIC, Splitter:B:19:0x0047] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean extract(java.lang.String r9, java.lang.String r10, java.lang.StringBuffer r11) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.LibraryLoader.extract(java.lang.String, java.lang.String, java.lang.StringBuffer):boolean");
    }

    static void chmod(String str, String str2) {
        AppMethodBeat.i(61575);
        if (isWindows()) {
            AppMethodBeat.o(61575);
            return;
        }
        try {
            Runtime.getRuntime().exec(new String[]{"chmod", str, str2}).waitFor();
            AppMethodBeat.o(61575);
        } catch (Throwable th) {
            AppMethodBeat.o(61575);
        }
    }

    static String getOsName() {
        AppMethodBeat.i(61576);
        String str = System.getProperty("os.name") + System.getProperty("java.specification.vendor");
        AppMethodBeat.o(61576);
        return str;
    }

    static boolean isWindows() {
        AppMethodBeat.i(61577);
        boolean startsWith = getOsName().startsWith("Windows");
        AppMethodBeat.o(61577);
        return startsWith;
    }

    static boolean isMac() {
        AppMethodBeat.i(61578);
        boolean startsWith = getOsName().startsWith("Mac");
        AppMethodBeat.o(61578);
        return startsWith;
    }

    static boolean isLinux() {
        AppMethodBeat.i(61579);
        boolean startsWith = getOsName().startsWith("Linux");
        AppMethodBeat.o(61579);
        return startsWith;
    }

    static boolean isNativeClient() {
        AppMethodBeat.i(61580);
        boolean startsWith = getOsName().startsWith(Platform.NATIVE_CLIENT);
        AppMethodBeat.o(61580);
        return startsWith;
    }

    static boolean isAndroid() {
        AppMethodBeat.i(61581);
        boolean contains = getOsName().contains("Android");
        AppMethodBeat.o(61581);
        return contains;
    }

    static String getArchSuffix() {
        AppMethodBeat.i(61582);
        String property = System.getProperty("os.arch");
        if (property.equals("i686")) {
            AppMethodBeat.o(61582);
            return "x86";
        } else if (property.equals("amd64")) {
            AppMethodBeat.o(61582);
            return "x86_64";
        } else if (property.equals(Platform.NATIVE_CLIENT)) {
            AppMethodBeat.o(61582);
            return "armv7l";
        } else if (property.equals("aarch64")) {
            AppMethodBeat.o(61582);
            return "armv7l";
        } else {
            AppMethodBeat.o(61582);
            return property;
        }
    }

    static String getOSFileExtension() {
        AppMethodBeat.i(61583);
        if (isWindows()) {
            AppMethodBeat.o(61583);
            return "dll";
        } else if (isMac()) {
            AppMethodBeat.o(61583);
            return "dylib";
        } else if (isLinux()) {
            AppMethodBeat.o(61583);
            return "so";
        } else if (isNativeClient()) {
            AppMethodBeat.o(61583);
            return "so";
        } else {
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform: " + getOsName());
            AppMethodBeat.o(61583);
            throw unsatisfiedLinkError;
        }
    }

    static String getOS() {
        AppMethodBeat.i(61584);
        if (isWindows()) {
            AppMethodBeat.o(61584);
            return "win32";
        } else if (isMac()) {
            AppMethodBeat.o(61584);
            return Platform.MACOSX;
        } else if (isLinux() && !isAndroid()) {
            AppMethodBeat.o(61584);
            return Platform.LINUX;
        } else if (isAndroid()) {
            AppMethodBeat.o(61584);
            return "android";
        } else {
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform: " + getOsName());
            AppMethodBeat.o(61584);
            throw unsatisfiedLinkError;
        }
    }
}
