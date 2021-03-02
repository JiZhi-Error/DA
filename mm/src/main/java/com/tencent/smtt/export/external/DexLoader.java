package com.tencent.smtt.export.external;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class DexLoader {
    private static final String JAVACORE_PACKAGE_PREFIX = "org.chromium";
    private static final String TAF_PACKAGE_PREFIX = "com.taf";
    private static final String TAG = "DexLoader";
    private static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
    private static final String TBS_WEBVIEW_DEX = "webview_dex";
    private static final String TENCENT_PACKAGE_PREFIX = "com.tencent";
    static boolean mCanUseDexLoaderProviderService = true;
    private static boolean mMttClassUseCorePrivate = false;
    private static boolean mUseSpeedyClassLoader = false;
    private static boolean mUseTbsCorePrivateClassLoader = false;
    private DexClassLoader mClassLoader;

    /* access modifiers changed from: package-private */
    public static class TbsCorePrivateClassLoader extends DexClassLoader {
        public TbsCorePrivateClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str, boolean z) {
            ClassLoader parent;
            AppMethodBeat.i(53135);
            if (str != null) {
                boolean startsWith = str.startsWith(DexLoader.JAVACORE_PACKAGE_PREFIX);
                if (DexLoader.mMttClassUseCorePrivate) {
                    startsWith = startsWith || str.startsWith(DexLoader.TENCENT_PACKAGE_PREFIX) || str.startsWith(DexLoader.TAF_PACKAGE_PREFIX);
                }
                if (!startsWith) {
                    Class<?> loadClass = super.loadClass(str, z);
                    AppMethodBeat.o(53135);
                    return loadClass;
                }
                Class<?> findLoadedClass = findLoadedClass(str);
                if (findLoadedClass == null) {
                    try {
                        new StringBuilder("WebCoreClassLoader - loadClass(").append(str).append(",").append(z).append(")...");
                        findLoadedClass = findClass(str);
                    } catch (ClassNotFoundException e2) {
                    }
                    if (findLoadedClass == null && (parent = getParent()) != null) {
                        findLoadedClass = parent.loadClass(str);
                    }
                }
                AppMethodBeat.o(53135);
                return findLoadedClass;
            }
            Class<?> loadClass2 = super.loadClass(str, z);
            AppMethodBeat.o(53135);
            return loadClass2;
        }
    }

    public static void initTbsSettings(Map<String, Object> map) {
        AppMethodBeat.i(53136);
        new StringBuilder("initTbsSettings - ").append(map);
        if (map != null) {
            try {
                Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER);
                if (obj instanceof Boolean) {
                    mUseTbsCorePrivateClassLoader = ((Boolean) obj).booleanValue();
                }
                Object obj2 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER);
                if (obj2 instanceof Boolean) {
                    mUseSpeedyClassLoader = ((Boolean) obj2).booleanValue();
                }
                Object obj3 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE);
                if (obj3 instanceof Boolean) {
                    mCanUseDexLoaderProviderService = ((Boolean) obj3).booleanValue();
                }
                Object obj4 = map.get(TbsCoreSettings.TBS_SETTINGS_PRAVITE_MTT_CLASSES);
                if (obj4 instanceof Boolean) {
                    mMttClassUseCorePrivate = ((Boolean) obj4).booleanValue();
                }
                AppMethodBeat.o(53136);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(53136);
    }

    private boolean shouldUseTbsCorePrivateClassLoader(String str) {
        AppMethodBeat.i(53137);
        if (!mUseTbsCorePrivateClassLoader) {
            AppMethodBeat.o(53137);
            return false;
        } else if (str.contains(TBS_FUSION_DEX) || str.contains(TBS_WEBVIEW_DEX)) {
            AppMethodBeat.o(53137);
            return true;
        } else {
            AppMethodBeat.o(53137);
            return false;
        }
    }

    public DexLoader(String str, Context context, String[] strArr, String str2) {
        this(str, context, strArr, str2, null);
    }

    public DexLoader(String str, Context context, String[] strArr, String str2, Map<String, Object> map) {
        AppMethodBeat.i(53138);
        initTbsSettings(map);
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        callingClassLoader = callingClassLoader == null ? context.getClassLoader() : callingClassLoader;
        new StringBuilder("Set base classLoader for DexClassLoader: ").append(callingClassLoader);
        str = TextUtils.isEmpty(str) ? context.getApplicationInfo().nativeLibraryDir : str;
        String str3 = !TextUtils.isEmpty("") ? str + File.pathSeparator + "" : str;
        DexClassLoader dexClassLoader = callingClassLoader;
        for (String str4 : strArr) {
            dexClassLoader = createDexClassLoader(str4, str2, str3, dexClassLoader, context);
            this.mClassLoader = dexClassLoader;
        }
        AppMethodBeat.o(53138);
    }

    public DexLoader(Context context, String[] strArr, String str) {
        this((String) null, context, strArr, str);
    }

    public DexLoader(Context context, String[] strArr, String str, String str2) {
        AppMethodBeat.i(53139);
        ClassLoader classLoader = context.getClassLoader();
        String str3 = context.getApplicationInfo().nativeLibraryDir;
        str3 = !TextUtils.isEmpty(str2) ? str3 + File.pathSeparator + str2 : str3;
        int i2 = 0;
        ClassLoader classLoader2 = classLoader;
        while (i2 < strArr.length) {
            DexClassLoader createDexClassLoader = createDexClassLoader(strArr[i2], str, str3, classLoader2, context);
            this.mClassLoader = createDexClassLoader;
            i2++;
            classLoader2 = createDexClassLoader;
        }
        AppMethodBeat.o(53139);
    }

    public DexLoader(Context context, String[] strArr, String str, DexLoader dexLoader) {
        AppMethodBeat.i(53140);
        DexClassLoader classLoader = dexLoader.getClassLoader();
        for (String str2 : strArr) {
            classLoader = createDexClassLoader(str2, str, context.getApplicationInfo().nativeLibraryDir, classLoader, context);
            this.mClassLoader = classLoader;
        }
        AppMethodBeat.o(53140);
    }

    public DexLoader(Context context, String str, String str2) {
        this(context, new String[]{str}, str2);
        AppMethodBeat.i(53141);
        AppMethodBeat.o(53141);
    }

    private DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        DexClassLoader dexClassLoader;
        AppMethodBeat.i(53142);
        if (shouldUseTbsCorePrivateClassLoader(str)) {
            dexClassLoader = new TbsCorePrivateClassLoader(str, str2, str3, classLoader);
        } else if (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT > 25 || !mUseSpeedyClassLoader) {
            dexClassLoader = new DexClassLoader(str, str2, str3, classLoader);
        } else {
            try {
                dexClassLoader = DexClassLoaderProvider.createDexClassLoader(str, str2, str3, classLoader, context);
            } catch (Throwable th) {
                new StringBuilder("createDexClassLoader exception: ").append(th);
                dexClassLoader = new DexClassLoader(str, str2, str3, classLoader);
            }
        }
        new StringBuilder("createDexClassLoader result: ").append(dexClassLoader);
        AppMethodBeat.o(53142);
        return dexClassLoader;
    }

    public DexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public Object newInstance(String str) {
        AppMethodBeat.i(53143);
        try {
            Object newInstance = this.mClassLoader.loadClass(str).newInstance();
            AppMethodBeat.o(53143);
            return newInstance;
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("create ").append(str).append(" instance failed");
            AppMethodBeat.o(53143);
            return null;
        }
    }

    public Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(53144);
        try {
            Object newInstance = this.mClassLoader.loadClass(str).getConstructor(clsArr).newInstance(objArr);
            AppMethodBeat.o(53144);
            return newInstance;
        } catch (Throwable th) {
            if ("com.tencent.tbs.core.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(str)) {
                getClass().getSimpleName();
                new StringBuilder("'newInstance ").append(str).append(" failed");
                AppMethodBeat.o(53144);
                return th;
            }
            getClass().getSimpleName();
            new StringBuilder("create '").append(str).append("' instance failed");
            AppMethodBeat.o(53144);
            return null;
        }
    }

    public Class<?> loadClass(String str) {
        AppMethodBeat.i(53145);
        try {
            Class<?> loadClass = this.mClassLoader.loadClass(str);
            AppMethodBeat.o(53145);
            return loadClass;
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("loadClass '").append(str).append("' failed");
            AppMethodBeat.o(53145);
            return null;
        }
    }

    public Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(53146);
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            Object invoke = method.invoke(null, objArr);
            AppMethodBeat.o(53146);
            return invoke;
        } catch (Throwable th) {
            if (str2 == null || !str2.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                getClass().getSimpleName();
                new StringBuilder("'").append(str).append("' invoke static method '").append(str2).append("' failed");
                AppMethodBeat.o(53146);
                return null;
            }
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' invoke static method '").append(str2).append("' failed");
            AppMethodBeat.o(53146);
            return th;
        }
    }

    public Object invokeMethod(Object obj, String str, String str2, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(53147);
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            Object invoke = method.invoke(obj, objArr);
            AppMethodBeat.o(53147);
            return invoke;
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' invoke method '").append(str2).append("' failed");
            AppMethodBeat.o(53147);
            return null;
        }
    }

    public Object getStaticField(String str, String str2) {
        Object obj = null;
        AppMethodBeat.i(53148);
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            obj = field.get(null);
            AppMethodBeat.o(53148);
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' get field '").append(str2).append("' failed");
            AppMethodBeat.o(53148);
        }
        return obj;
    }

    public void setStaticField(String str, String str2, Object obj) {
        AppMethodBeat.i(53149);
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            field.set(null, obj);
            AppMethodBeat.o(53149);
        } catch (Throwable th) {
            getClass().getSimpleName();
            new StringBuilder("'").append(str).append("' set field '").append(str2).append("' failed");
            AppMethodBeat.o(53149);
        }
    }
}
