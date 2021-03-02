package com.c.a.a.a;

import com.c.a.a.b.h;
import com.c.a.a.b.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckReturnValue;

public class a {
    final String separator;

    public a(String str) {
        this.separator = (String) checkNotNull(str);
    }

    private a(a aVar) {
        this.separator = aVar.separator;
    }

    @CheckReturnValue
    public a cH(String str) {
        checkNotNull(str);
        return new c(this, this, str);
    }

    /* synthetic */ a(a aVar, byte b2) {
        this(aVar);
    }

    @CheckReturnValue
    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void bN(boolean z) {
        if (!z) {
            throw new IllegalStateException(String.valueOf("no calls to next() since the last call to remove()"));
        }
    }

    public static boolean b(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (NullPointerException e2) {
            return false;
        } catch (ClassCastException e3) {
            return false;
        }
    }

    public static boolean a(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    public static boolean a(Set<?> set, Collection<?> collection) {
        checkNotNull(collection);
        if (collection instanceof m) {
            collection = ((m) collection).JY();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return a(set, collection.iterator());
        }
        return h.a(set.iterator(), collection);
    }

    public static int ax(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
