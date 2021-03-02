package kotlin.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class e<K, V> implements Serializable {
    public final K key;
    public final V value;

    public e(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(61439);
        if (!(obj instanceof e)) {
            AppMethodBeat.o(61439);
            return false;
        }
        e eVar = (e) obj;
        if (this.key != null ? this.key.equals(eVar.key) : eVar.key == null) {
            if (this.value != null ? this.value.equals(eVar.value) : eVar.value == null) {
                AppMethodBeat.o(61439);
                return true;
            }
        }
        AppMethodBeat.o(61439);
        return false;
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(61440);
        int hashCode = this.key == null ? 0 : this.key.hashCode();
        if (this.value != null) {
            i2 = this.value.hashCode();
        }
        int i3 = hashCode ^ i2;
        AppMethodBeat.o(61440);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(61441);
        String str = ((Object) this.key) + "=" + ((Object) this.value);
        AppMethodBeat.o(61441);
        return str;
    }
}
