package com.c.a.a.b;

import com.c.a.a.a.a;
import com.tencent.mm.loader.BuildConfig;
import java.util.Collection;
import javax.annotation.Nullable;

public final class f {
    static final a con = new a(", ").cH(BuildConfig.COMMAND);

    static boolean a(Collection<?> collection, @Nullable Object obj) {
        a.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException e2) {
            return false;
        }
    }
}
