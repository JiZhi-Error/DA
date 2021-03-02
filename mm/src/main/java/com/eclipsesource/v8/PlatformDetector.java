package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class PlatformDetector {
    static /* synthetic */ String access$000(String str) {
        AppMethodBeat.i(61646);
        String normalizeArch = normalizeArch(str);
        AppMethodBeat.o(61646);
        return normalizeArch;
    }

    static /* synthetic */ String access$100(String str) {
        AppMethodBeat.i(61647);
        String normalizeOs = normalizeOs(str);
        AppMethodBeat.o(61647);
        return normalizeOs;
    }

    static /* synthetic */ String access$200(String str) {
        AppMethodBeat.i(61648);
        String normalize = normalize(str);
        AppMethodBeat.o(61648);
        return normalize;
    }

    static /* synthetic */ String access$300(String str) {
        AppMethodBeat.i(61649);
        String normalizeOsReleaseValue = normalizeOsReleaseValue(str);
        AppMethodBeat.o(61649);
        return normalizeOsReleaseValue;
    }

    public static class Arch {
        public static String getName() {
            AppMethodBeat.i(61629);
            String property = System.getProperty("os.arch");
            String access$000 = PlatformDetector.access$000(property);
            if (access$000.equals("unknown")) {
                UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported arch: ".concat(String.valueOf(property)));
                AppMethodBeat.o(61629);
                throw unsatisfiedLinkError;
            }
            AppMethodBeat.o(61629);
            return access$000;
        }
    }

    public static class OS {
        public static String getName() {
            AppMethodBeat.i(61630);
            String property = System.getProperty("os.name");
            String access$100 = PlatformDetector.access$100(property);
            String property2 = System.getProperty("java.specification.vendor");
            if (PlatformDetector.access$200(property2).contains("android") || access$100.contains("android")) {
                AppMethodBeat.o(61630);
                return "android";
            } else if (access$100.equals("unknown")) {
                UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform/vendor: " + property + " / " + property2);
                AppMethodBeat.o(61630);
                throw unsatisfiedLinkError;
            } else {
                AppMethodBeat.o(61630);
                return access$100;
            }
        }

        public static boolean isWindows() {
            AppMethodBeat.i(61631);
            boolean equals = getName().equals(Platform.WINDOWS);
            AppMethodBeat.o(61631);
            return equals;
        }

        public static boolean isMac() {
            AppMethodBeat.i(61632);
            boolean equals = getName().equals(Platform.MACOSX);
            AppMethodBeat.o(61632);
            return equals;
        }

        public static boolean isLinux() {
            AppMethodBeat.i(61633);
            boolean equals = getName().equals(Platform.LINUX);
            AppMethodBeat.o(61633);
            return equals;
        }

        public static boolean isNativeClient() {
            AppMethodBeat.i(61634);
            boolean equals = getName().equals(Platform.NATIVE_CLIENT);
            AppMethodBeat.o(61634);
            return equals;
        }

        public static boolean isAndroid() {
            AppMethodBeat.i(61635);
            boolean equals = getName().equals("android");
            AppMethodBeat.o(61635);
            return equals;
        }

        public static String getLibFileExtension() {
            AppMethodBeat.i(61636);
            if (isWindows()) {
                AppMethodBeat.o(61636);
                return "dll";
            } else if (isMac()) {
                AppMethodBeat.o(61636);
                return "dylib";
            } else if (isLinux() || isAndroid() || isNativeClient()) {
                AppMethodBeat.o(61636);
                return "so";
            } else {
                UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform library-extension for: " + getName());
                AppMethodBeat.o(61636);
                throw unsatisfiedLinkError;
            }
        }
    }

    public static class Vendor {
        private static final String LINUX_ID_PREFIX = "ID=";
        private static final String[] LINUX_OS_RELEASE_FILES = {"/etc/os-release", "/usr/lib/os-release"};
        private static final String REDHAT_RELEASE_FILE = "/etc/redhat-release";

        public static String getName() {
            AppMethodBeat.i(61637);
            if (OS.isWindows()) {
                AppMethodBeat.o(61637);
                return "microsoft";
            } else if (OS.isMac()) {
                AppMethodBeat.o(61637);
                return "apple";
            } else if (OS.isLinux()) {
                String linuxOsReleaseId = getLinuxOsReleaseId();
                AppMethodBeat.o(61637);
                return linuxOsReleaseId;
            } else if (OS.isAndroid()) {
                AppMethodBeat.o(61637);
                return "google";
            } else {
                UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported vendor: " + getName());
                AppMethodBeat.o(61637);
                throw unsatisfiedLinkError;
            }
        }

        private static String getLinuxOsReleaseId() {
            AppMethodBeat.i(61638);
            for (String str : LINUX_OS_RELEASE_FILES) {
                File file = new File(str);
                if (file.exists()) {
                    String parseLinuxOsReleaseFile = parseLinuxOsReleaseFile(file);
                    AppMethodBeat.o(61638);
                    return parseLinuxOsReleaseFile;
                }
            }
            File file2 = new File(REDHAT_RELEASE_FILE);
            if (file2.exists()) {
                String parseLinuxRedhatReleaseFile = parseLinuxRedhatReleaseFile(file2);
                AppMethodBeat.o(61638);
                return parseLinuxRedhatReleaseFile;
            }
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported linux vendor: " + getName());
            AppMethodBeat.o(61638);
            throw unsatisfiedLinkError;
        }

        private static String parseLinuxOsReleaseFile(File file) {
            BufferedReader bufferedReader;
            Throwable th;
            BufferedReader bufferedReader2;
            String str = null;
            AppMethodBeat.i(61639);
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), ProtocolPackage.ServerEncoding));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (readLine.startsWith(LINUX_ID_PREFIX)) {
                                str = PlatformDetector.access$300(readLine.substring(3));
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (IOException e2) {
                        closeQuietly(bufferedReader2);
                        AppMethodBeat.o(61639);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        closeQuietly(bufferedReader);
                        AppMethodBeat.o(61639);
                        throw th;
                    }
                }
                closeQuietly(bufferedReader2);
                AppMethodBeat.o(61639);
            } catch (IOException e3) {
                bufferedReader2 = null;
                closeQuietly(bufferedReader2);
                AppMethodBeat.o(61639);
                return str;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                closeQuietly(bufferedReader);
                AppMethodBeat.o(61639);
                throw th;
            }
            return str;
        }

        private static String parseLinuxRedhatReleaseFile(File file) {
            BufferedReader bufferedReader;
            Throwable th;
            BufferedReader bufferedReader2;
            String str = null;
            AppMethodBeat.i(61640);
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), ProtocolPackage.ServerEncoding));
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        String lowerCase = readLine.toLowerCase(Locale.US);
                        if (lowerCase.contains("centos")) {
                            str = "centos";
                        } else if (lowerCase.contains("fedora")) {
                            str = "fedora";
                        } else if (lowerCase.contains("red hat enterprise linux")) {
                            str = "rhel";
                        } else {
                            closeQuietly(bufferedReader2);
                            AppMethodBeat.o(61640);
                            return str;
                        }
                        closeQuietly(bufferedReader2);
                        AppMethodBeat.o(61640);
                        return str;
                    }
                    closeQuietly(bufferedReader2);
                    AppMethodBeat.o(61640);
                    return str;
                } catch (IOException e2) {
                    closeQuietly(bufferedReader2);
                    AppMethodBeat.o(61640);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    closeQuietly(bufferedReader);
                    AppMethodBeat.o(61640);
                    throw th;
                }
            } catch (IOException e3) {
                bufferedReader2 = null;
                closeQuietly(bufferedReader2);
                AppMethodBeat.o(61640);
                return str;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                closeQuietly(bufferedReader);
                AppMethodBeat.o(61640);
                throw th;
            }
        }

        private static void closeQuietly(Closeable closeable) {
            AppMethodBeat.i(61641);
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e2) {
                    AppMethodBeat.o(61641);
                    return;
                }
            }
            AppMethodBeat.o(61641);
        }
    }

    private static String normalizeOsReleaseValue(String str) {
        AppMethodBeat.i(61642);
        String replace = str.trim().replace("\"", "");
        AppMethodBeat.o(61642);
        return replace;
    }

    private static String normalizeOs(String str) {
        AppMethodBeat.i(61643);
        String normalize = normalize(str);
        if (normalize.startsWith("aix")) {
            AppMethodBeat.o(61643);
            return "aix";
        } else if (normalize.startsWith("hpux")) {
            AppMethodBeat.o(61643);
            return "hpux";
        } else if (normalize.startsWith("os400") && (normalize.length() <= 5 || !Character.isDigit(normalize.charAt(5)))) {
            AppMethodBeat.o(61643);
            return "os400";
        } else if (normalize.startsWith("android")) {
            AppMethodBeat.o(61643);
            return "android";
        } else if (normalize.startsWith(Platform.LINUX)) {
            AppMethodBeat.o(61643);
            return Platform.LINUX;
        } else if (normalize.startsWith(Platform.NATIVE_CLIENT)) {
            AppMethodBeat.o(61643);
            return Platform.NATIVE_CLIENT;
        } else if (normalize.startsWith(Platform.MACOSX) || normalize.startsWith("osx")) {
            AppMethodBeat.o(61643);
            return Platform.MACOSX;
        } else if (normalize.startsWith("freebsd")) {
            AppMethodBeat.o(61643);
            return "freebsd";
        } else if (normalize.startsWith("openbsd")) {
            AppMethodBeat.o(61643);
            return "openbsd";
        } else if (normalize.startsWith("netbsd")) {
            AppMethodBeat.o(61643);
            return "netbsd";
        } else if (normalize.startsWith("solaris") || normalize.startsWith("sunos")) {
            AppMethodBeat.o(61643);
            return "sunos";
        } else if (normalize.startsWith(Platform.WINDOWS)) {
            AppMethodBeat.o(61643);
            return Platform.WINDOWS;
        } else {
            AppMethodBeat.o(61643);
            return "unknown";
        }
    }

    private static String normalizeArch(String str) {
        AppMethodBeat.i(61644);
        String normalize = normalize(str);
        if (normalize.matches("^(x8664|amd64|ia32e|em64t|x64)$")) {
            AppMethodBeat.o(61644);
            return "x86_64";
        } else if (normalize.matches("^(x8632|x86|i[3-6]86|ia32|x32)$")) {
            AppMethodBeat.o(61644);
            return "x86_32";
        } else if (normalize.matches("^(ia64|itanium64)$")) {
            AppMethodBeat.o(61644);
            return "itanium_64";
        } else if (normalize.matches("^(sparc|sparc32)$")) {
            AppMethodBeat.o(61644);
            return "sparc_32";
        } else if (normalize.matches("^(sparcv9|sparc64)$")) {
            AppMethodBeat.o(61644);
            return "sparc_64";
        } else if (normalize.matches("^(arm|arm32)$")) {
            AppMethodBeat.o(61644);
            return "arm_32";
        } else if ("aarch64".equals(normalize)) {
            AppMethodBeat.o(61644);
            return "aarch_64";
        } else if (normalize.matches("^(ppc|ppc32)$")) {
            AppMethodBeat.o(61644);
            return "ppc_32";
        } else if ("ppc64".equals(normalize)) {
            AppMethodBeat.o(61644);
            return "ppc_64";
        } else if ("ppc64le".equals(normalize)) {
            AppMethodBeat.o(61644);
            return "ppcle_64";
        } else if ("s390".equals(normalize)) {
            AppMethodBeat.o(61644);
            return "s390_32";
        } else if ("s390x".equals(normalize)) {
            AppMethodBeat.o(61644);
            return "s390_64";
        } else {
            AppMethodBeat.o(61644);
            return "unknown";
        }
    }

    private static String normalize(String str) {
        AppMethodBeat.i(61645);
        if (str == null) {
            AppMethodBeat.o(61645);
            return "";
        }
        String replaceAll = str.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
        AppMethodBeat.o(61645);
        return replaceAll;
    }
}
