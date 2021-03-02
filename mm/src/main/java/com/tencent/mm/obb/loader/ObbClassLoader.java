package com.tencent.mm.obb.loader;

import android.support.annotation.Keep;
import com.tencent.mm.app.Application;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;

@Keep
public class ObbClassLoader extends PathClassLoader {
    private static final String TAG = "MicroMsg.ObbClassLoader";
    private final ClassLoader mAppClassLoader;
    private final String mAppClassName;

    private ObbClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        super(str2, str3, classLoader.getParent());
        this.mAppClassName = str;
        this.mAppClassLoader = classLoader;
    }

    /* access modifiers changed from: protected */
    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) {
        Class<?> cls;
        if (str.startsWith(this.mAppClassName)) {
            return this.mAppClassLoader.loadClass(str);
        }
        if (str.startsWith("com.tencent.tinker.loader.")) {
            return this.mAppClassLoader.loadClass(str);
        }
        if (str.startsWith("com.tencent.mm.obb.loader.")) {
            return this.mAppClassLoader.loadClass(str);
        }
        try {
            cls = super.findClass(str);
        } catch (ClassNotFoundException e2) {
            cls = null;
        }
        if (cls == null) {
            return this.mAppClassLoader.loadClass(str);
        }
        return cls;
    }

    public URL getResource(String str) {
        URL resource = Object.class.getClassLoader().getResource(str);
        if (resource != null) {
            return resource;
        }
        URL findResource = findResource(str);
        return findResource == null ? this.mAppClassLoader.getResource(str) : findResource;
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String str) {
        return new CompoundEnumeration(new Enumeration[]{Object.class.getClassLoader().getResources(str), findResources(str), this.mAppClassLoader.getResources(str)});
    }

    @Keep
    class CompoundEnumeration<E> implements Enumeration<E> {
        private Enumeration<E>[] enums;
        private int index = 0;

        public CompoundEnumeration(Enumeration<E>[] enumerationArr) {
            this.enums = enumerationArr;
        }

        public boolean hasMoreElements() {
            while (this.index < this.enums.length) {
                if (this.enums[this.index] != null && this.enums[this.index].hasMoreElements()) {
                    return true;
                }
                this.index++;
            }
            return false;
        }

        @Override // java.util.Enumeration
        public E nextElement() {
            if (hasMoreElements()) {
                return this.enums[this.index].nextElement();
            }
            throw new NoSuchElementException();
        }
    }

    private static ObbClassLoader newInstance(Application application) {
        boolean z;
        ClassLoader classLoader = application.getClass().getClassLoader();
        Object obj = findField(BaseDexClassLoader.class, "pathList").get(classLoader);
        String str = FilePathGenerator.ANDROID_DIR_SEP + application.getApplicationInfo().packageName + FilePathGenerator.ANDROID_DIR_SEP;
        Object[] objArr = (Object[]) findField(obj.getClass(), "dexElements").get(obj);
        Field findField = findField(objArr.getClass().getComponentType(), "dexFile");
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        int i2 = 0;
        boolean z2 = true;
        while (i2 < length) {
            Object obj2 = objArr[i2];
            if (z2) {
                z = false;
            } else {
                sb.append(File.pathSeparator);
                z = z2;
            }
            DexFile dexFile = (DexFile) findField.get(obj2);
            if (dexFile.getName().contains(str)) {
                sb.append(dexFile.getName());
            }
            i2++;
            z2 = z;
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z3 = true;
        for (File file : (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj)) {
            if (z3) {
                z3 = false;
            } else {
                sb2.append(File.pathSeparator);
            }
            sb2.append(file.getAbsolutePath());
        }
        return new ObbClassLoader(application.getClass().getName(), sb.toString(), sb2.toString(), classLoader);
    }

    public static ClassLoader injectOnDemand(Application application) {
        return application.getClass().getClassLoader();
    }

    private static final Field findField(Class<?> cls, String str) {
        Class<?> cls2 = cls;
        do {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Throwable th) {
                if (cls2 == Object.class || (cls2 = cls2.getSuperclass()) != null) {
                    throw new NoSuchFieldException("Cannot find field '" + str + "' in class " + cls.getName() + " or its super classes.");
                }
                do {
                    Field declaredField2 = cls2.getDeclaredField(str);
                    declaredField2.setAccessible(true);
                    return declaredField2;
                } while ((cls2 = cls2.getSuperclass()) != null);
                throw new NoSuchFieldException("Cannot find field '" + str + "' in class " + cls.getName() + " or its super classes.");
            }
        } while ((cls2 = cls2.getSuperclass()) != null);
        throw new NoSuchFieldException("Cannot find field '" + str + "' in class " + cls.getName() + " or its super classes.");
    }
}
