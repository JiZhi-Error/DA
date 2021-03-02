package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.library_loader.Linker;
import com.tencent.smtt.sandbox.ChildProcessService;
import com.tencent.smtt.sandbox.SandboxListener;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static Linker f2060a = null;

    /* renamed from: b  reason: collision with root package name */
    private static ChildProcessService f2061b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f2062c = TbsCoreSettings.TBS_SANDBOX_CRASH_RECORD_FILE0;

    /* renamed from: d  reason: collision with root package name */
    private static String f2063d = TbsCoreSettings.TBS_SANDBOX_CRASH_RECORD_FILE1;

    /* renamed from: e  reason: collision with root package name */
    private static SandboxListener f2064e = null;

    /* renamed from: f  reason: collision with root package name */
    private static Map<String, String> f2065f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private static String f2066g = "/data/data/com.tencent.mm/app_tbs/core_share/";

    /* renamed from: h  reason: collision with root package name */
    private static String f2067h = "/data/data/com.tbs.default/app_tbs/core_share/";

    static {
        AppMethodBeat.i(188267);
        AppMethodBeat.o(188267);
    }

    public static void a(ChildProcessService childProcessService) {
        f2061b = childProcessService;
    }

    public static ParcelFileDescriptor a() {
        AppMethodBeat.i(188257);
        if (f2061b != null) {
            ParcelFileDescriptor fdByFileName = f2061b.getFdByFileName(f2062c);
            AppMethodBeat.o(188257);
            return fdByFileName;
        }
        AppMethodBeat.o(188257);
        return null;
    }

    public static ParcelFileDescriptor b() {
        AppMethodBeat.i(188258);
        if (f2061b != null) {
            ParcelFileDescriptor fdByFileName = f2061b.getFdByFileName(f2063d);
            AppMethodBeat.o(188258);
            return fdByFileName;
        }
        AppMethodBeat.o(188258);
        return null;
    }

    public static void a(SandboxListener sandboxListener) {
        f2064e = sandboxListener;
    }

    public static void c() {
        AppMethodBeat.i(188259);
        ParcelFileDescriptor a2 = a();
        ParcelFileDescriptor b2 = b();
        if (f2064e != null) {
            f2064e.setCrashRecordFileDescriptor(a2, b2);
        }
        AppMethodBeat.o(188259);
    }

    public static synchronized void d() {
        synchronized (i.class) {
            AppMethodBeat.i(188260);
            new StringBuilder("[").append(Thread.currentThread().getStackTrace()[2].getMethodName()).append("]");
            Linker instance = Linker.getInstance();
            instance.disableSharedRelros();
            instance.prepareLibraryLoad();
            f2060a = instance;
            AppMethodBeat.o(188260);
        }
    }

    public static String a(String str, ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(188261);
        new StringBuilder(" [").append(Thread.currentThread().getStackTrace()[2].getMethodName()).append("] libraryName: ").append(str).append(", parcelFileDescriptor: ").append(parcelFileDescriptor);
        int fd = parcelFileDescriptor.getFd();
        if (fd == -1) {
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            try {
                Method declaredMethod = FileDescriptor.class.getDeclaredMethod("getInt$", new Class[0]);
                Object invoke = declaredMethod.invoke(fileDescriptor, new Object[0]);
                if (invoke instanceof Integer) {
                    fd = ((Integer) invoke).intValue();
                }
                new StringBuilder("loadLibraryByPrivateLinker -- method:").append(declaredMethod).append(", fd_internal: ").append(invoke);
            } catch (Throwable th) {
            }
        }
        long statSize = parcelFileDescriptor.getStatSize();
        new StringBuilder("loadLibraryByPrivateLinker -- loadLibraryByFd: ").append(parcelFileDescriptor).append(", size: ").append(statSize).append(", name: ").append(str).append(", nativeFd: ").append(fd);
        String loadLibraryByFd = f2060a.loadLibraryByFd(parcelFileDescriptor, statSize, str, fd);
        f2065f.put(str, loadLibraryByFd.substring(2));
        AppMethodBeat.o(188261);
        return loadLibraryByFd;
    }

    public static void e() {
        AppMethodBeat.i(188262);
        for (String str : f2065f.keySet()) {
            new StringBuilder("@TbsLinker -- loaded library : ").append(str).append(", start_address: ").append(f2065f.get(str));
        }
        AppMethodBeat.o(188262);
    }

    public static String a(String str) {
        AppMethodBeat.i(188263);
        if (str == null) {
            AppMethodBeat.o(188263);
            return str;
        }
        for (String str2 : f2065f.keySet()) {
            str = str.replace(String.format("[anon:libc_malloc:%s]", f2065f.get(str2)), f2066g + str2);
        }
        String replace = str.replace("[anon:libc_malloc]", f2067h + "libmttwebview.so");
        AppMethodBeat.o(188263);
        return replace;
    }

    public static boolean a(Context context, ParcelFileDescriptor[] parcelFileDescriptorArr) {
        AppMethodBeat.i(188264);
        new StringBuilder("[").append(Thread.currentThread().getStackTrace()[2].getMethodName()).append("] hostContext: ").append(context);
        try {
            a("libwebp_base.so", parcelFileDescriptorArr[0]);
            a("libmttwebview.so", parcelFileDescriptorArr[1]);
            AppMethodBeat.o(188264);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.o(188264);
            return false;
        }
    }

    private static String b(Context context) {
        AppMethodBeat.i(188265);
        String absolutePath = q.a().r(context).getAbsolutePath();
        AppMethodBeat.o(188265);
        return absolutePath;
    }

    public static boolean a(Context context) {
        AppMethodBeat.i(188266);
        String b2 = b(context);
        new StringBuilder("[").append(Thread.currentThread().getStackTrace()[2].getMethodName()).append("] hostContext: ").append(context).append(" libraryPath: ").append(b2);
        try {
            libwebp.loadWepLibraryIfNeed(context, b2);
            String str = b2 + File.separator + "libmttwebview.so";
            new StringBuilder("[").append(Thread.currentThread().getStackTrace()[2].getMethodName()).append("] loading library: ").append(str);
            System.load(str);
            AppMethodBeat.o(188266);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.o(188266);
            return false;
        }
    }
}
