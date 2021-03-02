package com.tencent.tinker.loader;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.SystemClock;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class TinkerDexOptimizer {
    private static final String INTERPRET_LOCK_FILE_NAME = "interpret.lock";
    private static final String TAG = "Tinker.ParallelDex";

    public interface ResultCallback {
        void onFailed(File file, File file2, Throwable th);

        void onStart(File file, File file2);

        void onSuccess(File file, File file2, File file3);
    }

    public static boolean optimizeAll(Context context, Collection<File> collection, File file, boolean z, ResultCallback resultCallback) {
        return optimizeAll(context, collection, file, false, z, null, resultCallback);
    }

    public static boolean optimizeAll(Context context, Collection<File> collection, File file, boolean z, boolean z2, String str, ResultCallback resultCallback) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, new Comparator<File>() {
            /* class com.tencent.tinker.loader.TinkerDexOptimizer.AnonymousClass1 */

            public final int compare(File file, File file2) {
                long length = file.length();
                long length2 = file2.length();
                if (length < length2) {
                    return 1;
                }
                if (length == length2) {
                    return 0;
                }
                return -1;
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!new OptimizeWorker(context, (File) it.next(), file, z, z2, str, resultCallback).run()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public static class OptimizeWorker {
        private static final PackageManager[] CACHED_SYNC_PM = {null};
        private static final String PM_INTERFACE_DESCRIPTOR = "android.content.pm.IPackageManager";
        private static String targetISA = null;
        private final ResultCallback callback;
        private final Context context;
        private final File dexFile;
        private final File optimizedDir;
        private final boolean useDLC;
        private final boolean useInterpretMode;

        OptimizeWorker(Context context2, File file, File file2, boolean z, boolean z2, String str, ResultCallback resultCallback) {
            this.context = context2;
            this.dexFile = file;
            this.optimizedDir = file2;
            this.useInterpretMode = z;
            this.useDLC = z2;
            this.callback = resultCallback;
            targetISA = str;
        }

        /* access modifiers changed from: package-private */
        public boolean run() {
            try {
                if (SharePatchFileUtil.isLegalFile(this.dexFile) || this.callback == null) {
                    if (this.callback != null) {
                        this.callback.onStart(this.dexFile, this.optimizedDir);
                    }
                    String optimizedPathFor = SharePatchFileUtil.optimizedPathFor(this.dexFile, this.optimizedDir);
                    if (!ShareTinkerInternals.isArkHotRuning()) {
                        if (this.useInterpretMode) {
                            interpretDex2Oat(this.dexFile.getAbsolutePath(), optimizedPathFor);
                        } else if (Build.VERSION.SDK_INT >= 26 || (Build.VERSION.SDK_INT >= 25 && Build.VERSION.PREVIEW_SDK_INT != 0)) {
                            NewClassLoaderInjector.triggerDex2Oat(this.context, this.optimizedDir, this.useDLC, this.dexFile.getAbsolutePath());
                            triggerPMDexOptOnDemand(this.context, this.dexFile.getAbsolutePath(), optimizedPathFor);
                        } else {
                            DexFile.loadDex(this.dexFile.getAbsolutePath(), optimizedPathFor, 0);
                        }
                    }
                    if (this.callback != null) {
                        this.callback.onSuccess(this.dexFile, this.optimizedDir, new File(optimizedPathFor));
                    }
                    return true;
                }
                this.callback.onFailed(this.dexFile, this.optimizedDir, new IOException("dex file " + this.dexFile.getAbsolutePath() + " is not exist!"));
                return false;
            } catch (Throwable th) {
                ShareTinkerLog.e(TinkerDexOptimizer.TAG, "Failed to optimize dex: " + this.dexFile.getAbsolutePath(), th);
                if (this.callback != null) {
                    this.callback.onFailed(this.dexFile, this.optimizedDir, th);
                    return false;
                }
            }
        }

        private static void triggerPMDexOptOnDemand(Context context2, String str, String str2) {
            if (Build.VERSION.SDK_INT != 29) {
                ShareTinkerLog.w(TinkerDexOptimizer.TAG, "[+] Not API 29 device, skip fixing.", new Object[0]);
                return;
            }
            ShareTinkerLog.i(TinkerDexOptimizer.TAG, "[+] Hit target device, do fix logic now.", new Object[0]);
            try {
                File file = new File(str2);
                if (file.exists()) {
                    ShareTinkerLog.i(TinkerDexOptimizer.TAG, "[+] Odex file exists, skip bg-dexopt triggering.", new Object[0]);
                    return;
                }
                boolean z = true;
                try {
                    performDexOptSecondary(context2, str2);
                } catch (Throwable th) {
                    ShareTinkerLog.printErrStackTrace(TinkerDexOptimizer.TAG, th, "[-] Fail to call performDexOptSecondary.", new Object[0]);
                    z = false;
                }
                SystemClock.sleep(1000);
                if ((!z || !file.exists()) && ("huawei".equalsIgnoreCase(Build.MANUFACTURER) || "honor".equalsIgnoreCase(Build.MANUFACTURER))) {
                    registerDexModule(context2, str, str2);
                }
                if (file.exists()) {
                    ShareTinkerLog.i(TinkerDexOptimizer.TAG, "[+] Bg-dexopt was triggered successfully.", new Object[0]);
                    return;
                }
                throw new IllegalStateException("Bg-dexopt was triggered, but no odex file was generated.");
            } catch (Throwable th2) {
                ShareTinkerLog.printErrStackTrace(TinkerDexOptimizer.TAG, th2, "[-] Fail to call triggerPMDexOptAsyncOnDemand.", new Object[0]);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00af, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x004c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x004d, code lost:
            throw r0;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x004c A[ExcHandler: IllegalStateException (r0v2 'e' java.lang.IllegalStateException A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void performDexOptSecondary(android.content.Context r10, java.lang.String r11) {
            /*
            // Method dump skipped, instructions count: 177
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.TinkerDexOptimizer.OptimizeWorker.performDexOptSecondary(android.content.Context, java.lang.String):void");
        }

        private static int queryPerformDexOptSecondaryTransactionCode() {
            try {
                Method findMethod = ShareReflectUtil.findMethod((Class<?>) Class.class, "getDeclaredField", (Class<?>[]) new Class[]{String.class});
                findMethod.setAccessible(true);
                Field field = (Field) findMethod.invoke(Class.forName("android.content.pm.IPackageManager$Stub"), "TRANSACTION_performDexOptSecondary");
                field.setAccessible(true);
                return ((Integer) field.get(null)).intValue();
            } catch (Throwable th) {
                throw new UnsupportedOperationException("Cannot query transaction code of performDexOptSecondary.", th);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0043  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void performDexOptSecondaryImpl(android.os.IBinder r8, int r9, java.lang.String r10, java.lang.String r11, boolean r12) {
            /*
            // Method dump skipped, instructions count: 126
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.TinkerDexOptimizer.OptimizeWorker.performDexOptSecondaryImpl(android.os.IBinder, int, java.lang.String, java.lang.String, boolean):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
            throw new java.lang.IllegalStateException("Fail to call registerDexModule.", r0);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A[ExcHandler: IllegalStateException (r0v2 'e' java.lang.IllegalStateException A[CUSTOM_DECLARE]), Splitter:B:1:0x0003] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void registerDexModule(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
            /*
            // Method dump skipped, instructions count: 131
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.TinkerDexOptimizer.OptimizeWorker.registerDexModule(android.content.Context, java.lang.String, java.lang.String):void");
        }

        private static PackageManager getSynchronizedPackageManager(Context context2) {
            PackageManager packageManager;
            synchronized (CACHED_SYNC_PM) {
                if (CACHED_SYNC_PM[0] != null) {
                    packageManager = CACHED_SYNC_PM[0];
                } else {
                    final IBinder iBinder = (IBinder) ShareReflectUtil.findMethod(Class.forName("android.os.ServiceManager"), "getService", (Class<?>[]) new Class[]{String.class}).invoke(null, "package");
                    IInterface iInterface = (IInterface) ShareReflectUtil.findMethod(Class.forName("android.content.pm.IPackageManager$Stub"), "asInterface", (Class<?>[]) new Class[]{IBinder.class}).invoke(null, (IBinder) Proxy.newProxyInstance(context2.getClassLoader(), iBinder.getClass().getInterfaces(), new InvocationHandler() {
                        /* class com.tencent.tinker.loader.TinkerDexOptimizer.OptimizeWorker.AnonymousClass2 */

                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object obj, Method method, Object[] objArr) {
                            if ("transact".equals(method.getName())) {
                                objArr[3] = 0;
                            }
                            return method.invoke(iBinder, objArr);
                        }
                    }));
                    if (context2 instanceof ContextWrapper) {
                        context2 = ((ContextWrapper) context2).getBaseContext();
                    }
                    packageManager = (PackageManager) Class.forName("android.app.ApplicationPackageManager").getDeclaredConstructor(context2.getClass(), iInterface.getClass().getInterfaces()[0]).newInstance(context2, iInterface);
                    CACHED_SYNC_PM[0] = packageManager;
                }
            }
            return packageManager;
        }

        private void interpretDex2Oat(String str, String str2) {
            File file = new File(str2);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            ShareFileLockHelper shareFileLockHelper = null;
            try {
                shareFileLockHelper = ShareFileLockHelper.getFileLock(new File(file.getParentFile(), TinkerDexOptimizer.INTERPRET_LOCK_FILE_NAME));
                ArrayList arrayList = new ArrayList();
                arrayList.add("dex2oat");
                if (Build.VERSION.SDK_INT >= 24) {
                    arrayList.add("--runtime-arg");
                    arrayList.add("-classpath");
                    arrayList.add("--runtime-arg");
                    arrayList.add("&");
                }
                arrayList.add("--dex-file=".concat(String.valueOf(str)));
                arrayList.add("--oat-file=".concat(String.valueOf(str2)));
                arrayList.add("--instruction-set=" + targetISA);
                if (Build.VERSION.SDK_INT > 25) {
                    arrayList.add("--compiler-filter=quicken");
                } else {
                    arrayList.add("--compiler-filter=interpret-only");
                }
                ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
                processBuilder.redirectErrorStream(true);
                Process start = processBuilder.start();
                StreamConsumer.consumeInputStream(start.getInputStream());
                StreamConsumer.consumeInputStream(start.getErrorStream());
                try {
                    int waitFor = start.waitFor();
                    if (waitFor != 0) {
                        throw new IOException("dex2oat works unsuccessfully, exit code: ".concat(String.valueOf(waitFor)));
                    } else if (shareFileLockHelper != null) {
                        try {
                        } catch (IOException e2) {
                            ShareTinkerLog.w(TinkerDexOptimizer.TAG, "release interpret Lock error", e2);
                        }
                    }
                } catch (InterruptedException e3) {
                    throw new IOException("dex2oat is interrupted, msg: " + e3.getMessage(), e3);
                }
            } finally {
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (IOException e4) {
                        ShareTinkerLog.w(TinkerDexOptimizer.TAG, "release interpret Lock error", e4);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class StreamConsumer {
        static final Executor STREAM_CONSUMER = Executors.newSingleThreadExecutor();

        private StreamConsumer() {
        }

        static void consumeInputStream(final InputStream inputStream) {
            STREAM_CONSUMER.execute(new Runnable() {
                /* class com.tencent.tinker.loader.TinkerDexOptimizer.StreamConsumer.AnonymousClass1 */

                public final void run() {
                    if (inputStream != null) {
                        do {
                            try {
                            } catch (IOException e2) {
                                try {
                                    inputStream.close();
                                    return;
                                } catch (Exception e3) {
                                    return;
                                }
                            } catch (Throwable th) {
                                try {
                                    inputStream.close();
                                } catch (Exception e4) {
                                }
                                throw th;
                            }
                        } while (inputStream.read(new byte[256]) > 0);
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                }
            });
        }
    }
}
