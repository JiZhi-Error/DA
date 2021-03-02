package android.arch.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lifecycling {
    private static Map<Class, Integer> cK = new HashMap();
    private static Map<Class, List<Constructor<? extends GeneratedAdapter>>> cL = new HashMap();

    static GenericLifecycleObserver e(Object obj) {
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (e(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends GeneratedAdapter>> list = cL.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a(list.get(0), obj));
        }
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            generatedAdapterArr[i2] = a(list.get(i2), obj);
        }
        return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
    }

    private static GeneratedAdapter a(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return (GeneratedAdapter) constructor.newInstance(obj);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    private static Constructor<? extends GeneratedAdapter> d(Class<?> cls) {
        try {
            Package r1 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r1 != null ? r1.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String adapterName = getAdapterName(canonicalName);
            if (!name.isEmpty()) {
                adapterName = name + "." + adapterName;
            }
            Constructor declaredConstructor = Class.forName(adapterName).getDeclaredConstructor(cls);
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException e2) {
            return null;
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static int e(Class<?> cls) {
        if (cK.containsKey(cls)) {
            return cK.get(cls).intValue();
        }
        int f2 = f(cls);
        cK.put(cls, Integer.valueOf(f2));
        return f2;
    }

    private static int f(Class<?> cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> d2 = d(cls);
        if (d2 != null) {
            cL.put(cls, Collections.singletonList(d2));
            return 2;
        } else if (ClassesInfoCache.cb.a(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList2 = null;
            if (g(superclass)) {
                if (e((Class<?>) superclass) == 1) {
                    return 1;
                }
                arrayList2 = new ArrayList(cL.get(superclass));
            }
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            int i2 = 0;
            while (i2 < length) {
                Class<?> cls2 = interfaces[i2];
                if (!g(cls2)) {
                    arrayList = arrayList2;
                } else if (e(cls2) == 1) {
                    return 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList = new ArrayList();
                    } else {
                        arrayList = arrayList2;
                    }
                    arrayList.addAll(cL.get(cls2));
                }
                i2++;
                arrayList2 = arrayList;
            }
            if (arrayList2 == null) {
                return 1;
            }
            cL.put(cls, arrayList2);
            return 2;
        }
    }

    private static boolean g(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    public static String getAdapterName(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
