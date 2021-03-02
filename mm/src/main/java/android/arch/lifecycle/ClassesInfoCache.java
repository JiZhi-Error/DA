package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ClassesInfoCache {
    static ClassesInfoCache cb = new ClassesInfoCache();
    private final Map<Class, CallbackInfo> cc = new HashMap();
    private final Map<Class, Boolean> cd = new HashMap();

    ClassesInfoCache() {
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Class cls) {
        if (this.cd.containsKey(cls)) {
            return this.cd.get(cls).booleanValue();
        }
        Method[] b2 = b(cls);
        for (Method method : b2) {
            if (((OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class)) != null) {
                a(cls, b2);
                return true;
            }
        }
        this.cd.put(cls, Boolean.FALSE);
        return false;
    }

    private static Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final CallbackInfo c(Class cls) {
        CallbackInfo callbackInfo = this.cc.get(cls);
        if (callbackInfo != null) {
            return callbackInfo;
        }
        return a(cls, null);
    }

    private static void a(Map<MethodReference, Lifecycle.Event> map, MethodReference methodReference, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = map.get(methodReference);
        if (event2 != null && event != event2) {
            throw new IllegalArgumentException("Method " + methodReference.mMethod.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(methodReference, event);
        }
    }

    private CallbackInfo a(Class cls, Method[] methodArr) {
        boolean z;
        int i2;
        CallbackInfo c2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (c2 = c(superclass)) == null)) {
            hashMap.putAll(c2.cf);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : c(cls2).cf.entrySet()) {
                a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        int length = methodArr.length;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < length) {
            Method method = methodArr[i3];
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else if (!parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i2 = 1;
                }
                Lifecycle.Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    } else {
                        i2 = 2;
                    }
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(hashMap, new MethodReference(i2, method), value, cls);
                z = true;
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        CallbackInfo callbackInfo = new CallbackInfo(hashMap);
        this.cc.put(cls, callbackInfo);
        this.cd.put(cls, Boolean.valueOf(z2));
        return callbackInfo;
    }

    /* access modifiers changed from: package-private */
    public static class CallbackInfo {
        final Map<Lifecycle.Event, List<MethodReference>> ce = new HashMap();
        final Map<MethodReference, Lifecycle.Event> cf;

        CallbackInfo(Map<MethodReference, Lifecycle.Event> map) {
            this.cf = map;
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<MethodReference> list = this.ce.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.ce.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        static void a(List<MethodReference> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    MethodReference methodReference = list.get(size);
                    try {
                        switch (methodReference.cg) {
                            case 0:
                                methodReference.mMethod.invoke(obj, new Object[0]);
                                break;
                            case 1:
                                methodReference.mMethod.invoke(obj, lifecycleOwner);
                                break;
                            case 2:
                                methodReference.mMethod.invoke(obj, lifecycleOwner, event);
                                break;
                        }
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to call observer method", e2.getCause());
                    } catch (IllegalAccessException e3) {
                        throw new RuntimeException(e3);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class MethodReference {
        final int cg;
        final Method mMethod;

        MethodReference(int i2, Method method) {
            this.cg = i2;
            this.mMethod = method;
            this.mMethod.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            return this.cg == methodReference.cg && this.mMethod.getName().equals(methodReference.mMethod.getName());
        }

        public int hashCode() {
            return (this.cg * 31) + this.mMethod.getName().hashCode();
        }
    }
}
