package com.eclipsesource.a;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

public abstract class h implements Serializable {
    @Deprecated
    public static final h aZC = a.aZC;
    @Deprecated
    public static final h aZD = a.aZD;
    @Deprecated
    public static final h aZE = a.aZE;

    /* access modifiers changed from: package-private */
    public abstract void a(i iVar);

    h() {
    }

    public boolean isObject() {
        return false;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public e si() {
        throw new UnsupportedOperationException("Not an object: " + toString());
    }

    public b sd() {
        throw new UnsupportedOperationException("Not an array: " + toString());
    }

    public int sf() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public long sg() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public double sh() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public String sG() {
        throw new UnsupportedOperationException("Not a string: " + toString());
    }

    public boolean se() {
        throw new UnsupportedOperationException("Not a boolean: " + toString());
    }

    public String toString() {
        return a(l.baj);
    }

    public final String a(l lVar) {
        StringWriter stringWriter = new StringWriter();
        if (lVar == null) {
            try {
                throw new NullPointerException("config is null");
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            m mVar = new m(stringWriter);
            a(lVar.a(mVar));
            mVar.flush();
            return stringWriter.toString();
        }
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
