package com.tencent.matrix.g;

import java.lang.reflect.Field;

public final class e<Type> {
    private Class<?> dfe;
    private String dff;
    private Field mField;
    private boolean mInit;

    public e(Class<?> cls, String str) {
        if (cls == null || str == null || str.length() == 0) {
            throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
        }
        this.dfe = cls;
        this.dff = str;
    }

    private synchronized void prepare() {
        if (!this.mInit) {
            for (Class<?> cls = this.dfe; cls != null; cls = cls.getSuperclass()) {
                try {
                    Field declaredField = cls.getDeclaredField(this.dff);
                    declaredField.setAccessible(true);
                    this.mField = declaredField;
                    break;
                } catch (Exception e2) {
                }
            }
            this.mInit = true;
        }
    }

    private synchronized Type aP(Object obj) {
        prepare();
        if (this.mField == null) {
            throw new NoSuchFieldException();
        }
        try {
        } catch (ClassCastException e2) {
            throw new IllegalArgumentException("unable to cast object");
        }
        return (Type) this.mField.get(obj);
    }

    public final synchronized Type get(Object obj) {
        return aP(obj);
    }
}
