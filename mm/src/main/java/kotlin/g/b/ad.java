package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;

public final class ad {
    public final ArrayList<Object> dtS;

    public ad(int i2) {
        AppMethodBeat.i(128982);
        this.dtS = new ArrayList<>(i2);
        AppMethodBeat.o(128982);
    }

    public final void eS(Object obj) {
        AppMethodBeat.i(128983);
        if (obj == null) {
            AppMethodBeat.o(128983);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                this.dtS.ensureCapacity(this.dtS.size() + objArr.length);
                Collections.addAll(this.dtS, objArr);
            }
            AppMethodBeat.o(128983);
        } else {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
            AppMethodBeat.o(128983);
            throw unsupportedOperationException;
        }
    }

    public final void add(Object obj) {
        AppMethodBeat.i(128984);
        this.dtS.add(obj);
        AppMethodBeat.o(128984);
    }

    public final Object[] toArray(Object[] objArr) {
        AppMethodBeat.i(128985);
        Object[] array = this.dtS.toArray(objArr);
        AppMethodBeat.o(128985);
        return array;
    }
}
