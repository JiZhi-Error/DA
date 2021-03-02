package com.c.a.a.b;

import java.util.AbstractCollection;
import java.util.Map;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
public abstract class l<K, V> extends AbstractCollection<Map.Entry<K, V>> {
    /* access modifiers changed from: package-private */
    public abstract k<K, V> JU();

    l() {
    }

    public int size() {
        return JU().size();
    }

    public boolean contains(@Nullable Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return JU().t(entry.getKey(), entry.getValue());
    }

    public boolean remove(@Nullable Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return JU().remove(entry.getKey(), entry.getValue());
    }

    public void clear() {
        JU().clear();
    }
}
