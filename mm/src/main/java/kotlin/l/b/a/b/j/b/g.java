package kotlin.l.b.a.b.j.b;

import kotlin.g.b.p;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;

public abstract class g<T> {
    private final T value;

    public abstract ab b(y yVar);

    public g(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        Object obj2 = null;
        if (this != obj) {
            T value2 = getValue();
            g gVar = (g) (!(obj instanceof g) ? null : obj);
            if (gVar != null) {
                obj2 = gVar.getValue();
            }
            return p.j(value2, obj2);
        }
    }

    public int hashCode() {
        T value2 = getValue();
        if (value2 != null) {
            return value2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
