package com.tencent.tinker.loader;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import dalvik.system.DelegateLastClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/* access modifiers changed from: package-private */
public final class NewClassLoaderInjector {
    public static ClassLoader inject(Application application, ClassLoader classLoader, File file, boolean z, List<File> list) {
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = list.get(i2).getAbsolutePath();
        }
        ClassLoader createNewClassLoader = createNewClassLoader(classLoader, file, z, strArr);
        doInject(application, createNewClassLoader);
        return createNewClassLoader;
    }

    public static void triggerDex2Oat(Context context, File file, boolean z, String... strArr) {
        createNewClassLoader(context.getClassLoader(), file, z, strArr);
    }

    private static ClassLoader createNewClassLoader(ClassLoader classLoader, File file, boolean z, String... strArr) {
        List<File> list;
        ClassLoader tinkerClassLoader;
        Object obj = findField(Class.forName("dalvik.system.BaseDexClassLoader", false, classLoader), "pathList").get(classLoader);
        StringBuilder sb = new StringBuilder();
        if (strArr != null && strArr.length > 0) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (i2 > 0) {
                    sb.append(File.pathSeparator);
                }
                sb.append(strArr[i2]);
            }
        }
        String sb2 = sb.toString();
        Field findField = findField(obj.getClass(), "nativeLibraryDirectories");
        if (findField.getType().isArray()) {
            list = Arrays.asList((File[]) findField.get(obj));
        } else {
            list = (List) findField.get(obj);
        }
        StringBuilder sb3 = new StringBuilder();
        boolean z2 = true;
        for (File file2 : list) {
            if (file2 != null) {
                if (z2) {
                    z2 = false;
                } else {
                    sb3.append(File.pathSeparator);
                }
                sb3.append(file2.getAbsolutePath());
            }
        }
        String sb4 = sb3.toString();
        if (!z || Build.VERSION.SDK_INT < 27) {
            tinkerClassLoader = new TinkerClassLoader(sb2, file, sb4, classLoader);
        } else {
            tinkerClassLoader = new DelegateLastClassLoader(sb2, sb4, ClassLoader.getSystemClassLoader());
            Field declaredField = ClassLoader.class.getDeclaredField("parent");
            declaredField.setAccessible(true);
            declaredField.set(tinkerClassLoader, classLoader);
        }
        if (Build.VERSION.SDK_INT < 26) {
            findField(obj.getClass(), "definingContext").set(obj, tinkerClassLoader);
        }
        return tinkerClassLoader;
    }

    private static void doInject(Application application, ClassLoader classLoader) {
        Thread.currentThread().setContextClassLoader(classLoader);
        Context context = (Context) findField(application.getClass(), "mBase").get(application);
        try {
            findField(context.getClass(), "mClassLoader").set(context, classLoader);
        } catch (Throwable th) {
        }
        Object obj = findField(context.getClass(), "mPackageInfo").get(context);
        findField(obj.getClass(), "mClassLoader").set(obj, classLoader);
        if (Build.VERSION.SDK_INT < 27) {
            Resources resources = application.getResources();
            try {
                findField(resources.getClass(), "mClassLoader").set(resources, classLoader);
                Object obj2 = findField(resources.getClass(), "mDrawableInflater").get(resources);
                if (obj2 != null) {
                    findField(obj2.getClass(), "mClassLoader").set(obj2, classLoader);
                }
            } catch (Throwable th2) {
            }
        }
    }

    private static Field findField(Class<?> cls, String str) {
        Class<?> cls2 = cls;
        while (true) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Throwable th) {
                if (cls2 == Object.class) {
                    throw new NoSuchFieldException("Cannot find field " + str + " in class " + cls.getName() + " and its super classes.");
                }
                cls2 = cls2.getSuperclass();
            }
        }
    }

    private NewClassLoaderInjector() {
        throw new UnsupportedOperationException();
    }
}
