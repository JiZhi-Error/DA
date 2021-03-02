package com.tencent.tinker.loader;

import android.annotation.SuppressLint;
import com.tencent.tinker.anno.Keep;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.NoSuchElementException;

@SuppressLint({"NewApi"})
@Keep
public final class TinkerClassLoader extends PathClassLoader {
    private final ClassLoader mOriginAppClassLoader;

    TinkerClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        super("", str2, ClassLoader.getSystemClassLoader());
        this.mOriginAppClassLoader = classLoader;
        injectDexPath(this, str, file);
    }

    /* access modifiers changed from: protected */
    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final Class<?> findClass(String str) {
        Class<?> cls;
        try {
            cls = super.findClass(str);
        } catch (ClassNotFoundException e2) {
            cls = null;
        }
        return cls != null ? cls : this.mOriginAppClassLoader.loadClass(str);
    }

    public final URL getResource(String str) {
        URL resource = Object.class.getClassLoader().getResource(str);
        if (resource != null) {
            return resource;
        }
        URL findResource = findResource(str);
        return findResource == null ? this.mOriginAppClassLoader.getResource(str) : findResource;
    }

    @Override // java.lang.ClassLoader
    public final Enumeration<URL> getResources(String str) {
        return new CompoundEnumeration(new Enumeration[]{Object.class.getClassLoader().getResources(str), findResources(str), this.mOriginAppClassLoader.getResources(str)});
    }

    private static void injectDexPath(ClassLoader classLoader, String str, File file) {
        try {
            ArrayList arrayList = new ArrayList(16);
            String[] split = str.split(":");
            for (String str2 : split) {
                if (!str2.isEmpty()) {
                    arrayList.add(new File(str2));
                }
            }
            if (!arrayList.isEmpty()) {
                SystemClassLoaderAdder.injectDexesInternal(classLoader, arrayList, file);
            }
        } catch (Throwable th) {
            throw new TinkerRuntimeException("Fail to create TinkerClassLoader.", th);
        }
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
}
