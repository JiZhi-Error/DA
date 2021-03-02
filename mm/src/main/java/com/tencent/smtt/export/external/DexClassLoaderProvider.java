package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

public class DexClassLoaderProvider extends DexClassLoader {
    private static final String IS_FIRST_LOAD_DEX_FLAG_FILE = "is_first_load_dex_flag_file";
    static final String LAST_DEX_NAME = "tbs_shell_dex.jar";
    private static final String LOGTAG = "dexloader";
    protected static DexClassLoader mClassLoaderOriginal = null;
    private static Context mContext = null;
    private static boolean mForceLoadDexFlag = false;
    private static DexClassLoaderProvider mInstance = null;
    private static String mRealDexPath = null;
    protected static Service mService = null;
    private SpeedyDexClassLoader mClassLoader = null;

    static /* synthetic */ void access$000(String str, String str2) {
        AppMethodBeat.i(53131);
        set_first_load_tbs_dex(str, str2);
        AppMethodBeat.o(53131);
    }

    /* access modifiers changed from: package-private */
    public static class SpeedyDexClassLoader extends BaseDexClassLoader {
        public SpeedyDexClassLoader(String str, File file, String str2, ClassLoader classLoader) {
            super(str, null, str2, classLoader);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public Class<?> findClass(String str) {
            AppMethodBeat.i(53102);
            Class<?> findClass = super.findClass(str);
            AppMethodBeat.o(53102);
            return findClass;
        }

        public URL findResource(String str) {
            AppMethodBeat.i(53103);
            URL findResource = super.findResource(str);
            AppMethodBeat.o(53103);
            return findResource;
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public Enumeration<URL> findResources(String str) {
            AppMethodBeat.i(53104);
            Enumeration<URL> findResources = super.findResources(str);
            AppMethodBeat.o(53104);
            return findResources;
        }

        public synchronized Package getPackage(String str) {
            Package r0;
            AppMethodBeat.i(53105);
            r0 = super.getPackage(str);
            AppMethodBeat.o(53105);
            return r0;
        }

        @Override // java.lang.ClassLoader
        public Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) {
            AppMethodBeat.i(53106);
            Package definePackage = super.definePackage(str, str2, str3, str4, str5, str6, str7, url);
            AppMethodBeat.o(53106);
            return definePackage;
        }

        public Package[] getPackages() {
            AppMethodBeat.i(53107);
            Package[] packages = super.getPackages();
            AppMethodBeat.o(53107);
            return packages;
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str, boolean z) {
            AppMethodBeat.i(53108);
            Class<?> loadClass = super.loadClass(str, z);
            AppMethodBeat.o(53108);
            return loadClass;
        }
    }

    private DexClassLoaderProvider(String str, String str2, String str3, ClassLoader classLoader, boolean z) {
        super(str, str2, str3, classLoader);
        AppMethodBeat.i(53109);
        if (z) {
            new StringBuilder("SpeedyDexClassLoader: ").append(mRealDexPath);
            this.mClassLoader = new SpeedyDexClassLoader(mRealDexPath, null, str3, classLoader);
            AppMethodBeat.o(53109);
            return;
        }
        new StringBuilder("DexClassLoader: ").append(mRealDexPath);
        this.mClassLoader = null;
        AppMethodBeat.o(53109);
    }

    public static DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        AppMethodBeat.i(53110);
        new StringBuilder("new DexClassLoaderDelegate: ").append(str).append(", context: ").append(context);
        mContext = context.getApplicationContext();
        mRealDexPath = str;
        int lastIndexOf = str.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
        String str4 = str.substring(0, lastIndexOf + 1) + "fake_dex.jar";
        String substring = str.substring(lastIndexOf + 1);
        if (is_first_load_tbs_dex(str2, substring)) {
            mInstance = new DexClassLoaderProvider(str4, str2, str3, classLoader, true);
            doAsyncDexLoad(substring, str, str2, str3, classLoader);
        } else {
            mInstance = new DexClassLoaderProvider(str, str2, str3, classLoader, false);
        }
        DexClassLoaderProvider dexClassLoaderProvider = mInstance;
        AppMethodBeat.o(53110);
        return dexClassLoaderProvider;
    }

    private static boolean shouldSkipAsyncDexLoad() {
        if (!mForceLoadDexFlag && Build.VERSION.SDK_INT == 21) {
            return true;
        }
        return false;
    }

    private static void doAsyncDexLoad(final String str, final String str2, final String str3, final String str4, final ClassLoader classLoader) {
        AppMethodBeat.i(53111);
        if (shouldSkipAsyncDexLoad()) {
            ArrayList<String> arrayList = new ArrayList<>(4);
            arrayList.add(0, str);
            arrayList.add(1, str2);
            arrayList.add(2, str3);
            arrayList.add(3, str4);
            Intent intent = new Intent(mContext, DexClassLoaderProviderService.class);
            intent.putStringArrayListExtra("dex2oat", arrayList);
            mContext.startService(intent);
            new StringBuilder("shouldSkipAsyncDexLoad(").append(str).append(", ").append(intent).append(")");
            AppMethodBeat.o(53111);
            return;
        }
        new StringBuilder("Background real dex loading(").append(str).append(")");
        new Timer().schedule(new TimerTask() {
            /* class com.tencent.smtt.export.external.DexClassLoaderProvider.AnonymousClass1 */

            public final void run() {
                boolean z;
                AppMethodBeat.i(53101);
                File file = new File(str2.replace(ShareConstants.JAR_SUFFIX, ShareConstants.DEX_SUFFIX));
                if (!file.exists() || file.length() == 0) {
                    new StringBuilder().append(file).append(" does not existed!");
                    z = false;
                } else {
                    new StringBuilder().append(file).append(" existed!");
                    z = true;
                }
                long currentTimeMillis = System.currentTimeMillis();
                new DexClassLoader(str2, str3, str4, classLoader);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                DexClassLoaderProvider.access$000(str3, str);
                new StringBuilder().append(String.format("load_dex completed -- cl_cost: %d, existed: %b", Long.valueOf(currentTimeMillis2), Boolean.valueOf(z)));
                if (DexClassLoaderProvider.mForceLoadDexFlag && DexClassLoaderProvider.LAST_DEX_NAME.equals(str) && DexClassLoaderProvider.mService != null) {
                    DexClassLoaderProvider.mService.stopSelf();
                }
                AppMethodBeat.o(53101);
            }
        }, 2000);
        AppMethodBeat.o(53111);
    }

    private static boolean is_first_load_tbs_dex(String str, String str2) {
        AppMethodBeat.i(53112);
        if (mForceLoadDexFlag) {
            AppMethodBeat.o(53112);
            return true;
        } else if (!new File(str, str2 + "_is_first_load_dex_flag_file").exists()) {
            AppMethodBeat.o(53112);
            return true;
        } else {
            AppMethodBeat.o(53112);
            return false;
        }
    }

    private static void set_first_load_tbs_dex(String str, String str2) {
        AppMethodBeat.i(53113);
        File file = new File(str, str2 + "_is_first_load_dex_flag_file");
        if (!file.exists()) {
            try {
                file.createNewFile();
                AppMethodBeat.o(53113);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(53113);
    }

    /* access modifiers changed from: protected */
    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) {
        AppMethodBeat.i(53114);
        if (useSelfClassloader()) {
            Class<?> findClass = super.findClass(str);
            AppMethodBeat.o(53114);
            return findClass;
        }
        Class<?> findClass2 = this.mClassLoader.findClass(str);
        AppMethodBeat.o(53114);
        return findClass2;
    }

    public String findLibrary(String str) {
        AppMethodBeat.i(53115);
        if (useSelfClassloader()) {
            String findLibrary = super.findLibrary(str);
            AppMethodBeat.o(53115);
            return findLibrary;
        }
        String findLibrary2 = this.mClassLoader.findLibrary(str);
        AppMethodBeat.o(53115);
        return findLibrary2;
    }

    /* access modifiers changed from: protected */
    public URL findResource(String str) {
        AppMethodBeat.i(53116);
        if (useSelfClassloader()) {
            URL findResource = super.findResource(str);
            AppMethodBeat.o(53116);
            return findResource;
        }
        URL findResource2 = this.mClassLoader.findResource(str);
        AppMethodBeat.o(53116);
        return findResource2;
    }

    /* access modifiers changed from: protected */
    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Enumeration<URL> findResources(String str) {
        AppMethodBeat.i(53117);
        if (useSelfClassloader()) {
            Enumeration<URL> findResources = super.findResources(str);
            AppMethodBeat.o(53117);
            return findResources;
        }
        Enumeration<URL> findResources2 = this.mClassLoader.findResources(str);
        AppMethodBeat.o(53117);
        return findResources2;
    }

    /* access modifiers changed from: protected */
    public synchronized Package getPackage(String str) {
        Package r0;
        AppMethodBeat.i(53118);
        if (useSelfClassloader()) {
            r0 = super.getPackage(str);
            AppMethodBeat.o(53118);
        } else {
            r0 = this.mClassLoader.getPackage(str);
            AppMethodBeat.o(53118);
        }
        return r0;
    }

    public String toString() {
        AppMethodBeat.i(53119);
        if (useSelfClassloader()) {
            String dexClassLoader = super.toString();
            AppMethodBeat.o(53119);
            return dexClassLoader;
        }
        String speedyDexClassLoader = this.mClassLoader.toString();
        AppMethodBeat.o(53119);
        return speedyDexClassLoader;
    }

    public void clearAssertionStatus() {
        AppMethodBeat.i(53120);
        if (useSelfClassloader()) {
            super.clearAssertionStatus();
            AppMethodBeat.o(53120);
            return;
        }
        this.mClassLoader.clearAssertionStatus();
        AppMethodBeat.o(53120);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) {
        AppMethodBeat.i(53121);
        if (useSelfClassloader()) {
            Package definePackage = super.definePackage(str, str2, str3, str4, str5, str6, str7, url);
            AppMethodBeat.o(53121);
            return definePackage;
        }
        Package definePackage2 = this.mClassLoader.definePackage(str, str2, str3, str4, str5, str6, str7, url);
        AppMethodBeat.o(53121);
        return definePackage2;
    }

    /* access modifiers changed from: protected */
    public Package[] getPackages() {
        AppMethodBeat.i(53122);
        if (useSelfClassloader()) {
            Package[] packages = super.getPackages();
            AppMethodBeat.o(53122);
            return packages;
        }
        Package[] packages2 = this.mClassLoader.getPackages();
        AppMethodBeat.o(53122);
        return packages2;
    }

    public URL getResource(String str) {
        AppMethodBeat.i(53123);
        if (useSelfClassloader()) {
            URL resource = super.getResource(str);
            AppMethodBeat.o(53123);
            return resource;
        }
        URL resource2 = this.mClassLoader.getResource(str);
        AppMethodBeat.o(53123);
        return resource2;
    }

    public InputStream getResourceAsStream(String str) {
        AppMethodBeat.i(53124);
        if (useSelfClassloader()) {
            InputStream resourceAsStream = getResourceAsStream(str);
            AppMethodBeat.o(53124);
            return resourceAsStream;
        }
        InputStream resourceAsStream2 = this.mClassLoader.getResourceAsStream(str);
        AppMethodBeat.o(53124);
        return resourceAsStream2;
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String str) {
        AppMethodBeat.i(53125);
        if (useSelfClassloader()) {
            Enumeration<URL> resources = super.getResources(str);
            AppMethodBeat.o(53125);
            return resources;
        }
        Enumeration<URL> resources2 = this.mClassLoader.getResources(str);
        AppMethodBeat.o(53125);
        return resources2;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) {
        AppMethodBeat.i(53126);
        if (useSelfClassloader()) {
            Class<?> loadClass = super.loadClass(str, z);
            AppMethodBeat.o(53126);
            return loadClass;
        }
        Class<?> loadClass2 = this.mClassLoader.loadClass(str, z);
        AppMethodBeat.o(53126);
        return loadClass2;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) {
        AppMethodBeat.i(53127);
        if (useSelfClassloader()) {
            Class<?> loadClass = super.loadClass(str);
            AppMethodBeat.o(53127);
            return loadClass;
        }
        Class<?> loadClass2 = this.mClassLoader.loadClass(str);
        AppMethodBeat.o(53127);
        return loadClass2;
    }

    private boolean useSelfClassloader() {
        return this.mClassLoader == null;
    }

    public void setClassAssertionStatus(String str, boolean z) {
        AppMethodBeat.i(53128);
        if (useSelfClassloader()) {
            super.setClassAssertionStatus(str, z);
            AppMethodBeat.o(53128);
            return;
        }
        this.mClassLoader.setClassAssertionStatus(str, z);
        AppMethodBeat.o(53128);
    }

    public void setDefaultAssertionStatus(boolean z) {
        AppMethodBeat.i(53129);
        if (useSelfClassloader()) {
            super.setDefaultAssertionStatus(z);
            AppMethodBeat.o(53129);
            return;
        }
        this.mClassLoader.setDefaultAssertionStatus(z);
        AppMethodBeat.o(53129);
    }

    public void setPackageAssertionStatus(String str, boolean z) {
        AppMethodBeat.i(53130);
        if (useSelfClassloader()) {
            super.setPackageAssertionStatus(str, z);
            AppMethodBeat.o(53130);
            return;
        }
        this.mClassLoader.setPackageAssertionStatus(str, z);
        AppMethodBeat.o(53130);
    }

    public static void setForceLoadDexFlag(boolean z, Service service) {
        mForceLoadDexFlag = z;
        mService = service;
    }

    /* access modifiers changed from: package-private */
    public SpeedyDexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    /* access modifiers changed from: package-private */
    public void setClassLoader(SpeedyDexClassLoader speedyDexClassLoader) {
        this.mClassLoader = speedyDexClassLoader;
    }
}
