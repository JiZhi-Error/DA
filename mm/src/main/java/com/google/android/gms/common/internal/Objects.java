package com.google.android.gms.common.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Objects {

    public static final class ToStringHelper {
        private final List<String> zzul;
        private final Object zzum;

        private ToStringHelper(Object obj) {
            AppMethodBeat.i(4705);
            this.zzum = Preconditions.checkNotNull(obj);
            this.zzul = new ArrayList();
            AppMethodBeat.o(4705);
        }

        public final ToStringHelper add(String str, Object obj) {
            AppMethodBeat.i(4706);
            List<String> list = this.zzul;
            String str2 = (String) Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            list.add(new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
            AppMethodBeat.o(4706);
            return this;
        }

        public final ToStringHelper addValue(Object obj) {
            AppMethodBeat.i(4707);
            this.zzul.add(String.valueOf(obj));
            AppMethodBeat.o(4707);
            return this;
        }

        public final String toString() {
            AppMethodBeat.i(4708);
            StringBuilder append = new StringBuilder(100).append(this.zzum.getClass().getSimpleName()).append('{');
            int size = this.zzul.size();
            for (int i2 = 0; i2 < size; i2++) {
                append.append(this.zzul.get(i2));
                if (i2 < size - 1) {
                    append.append(", ");
                }
            }
            String sb = append.append('}').toString();
            AppMethodBeat.o(4708);
            return sb;
        }
    }

    private Objects() {
        AppMethodBeat.i(4712);
        AssertionError assertionError = new AssertionError("Uninstantiable");
        AppMethodBeat.o(4712);
        throw assertionError;
    }

    public static boolean equal(Object obj, Object obj2) {
        AppMethodBeat.i(4709);
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            AppMethodBeat.o(4709);
            return true;
        }
        AppMethodBeat.o(4709);
        return false;
    }

    public static int hashCode(Object... objArr) {
        AppMethodBeat.i(4710);
        int hashCode = Arrays.hashCode(objArr);
        AppMethodBeat.o(4710);
        return hashCode;
    }

    public static ToStringHelper toStringHelper(Object obj) {
        AppMethodBeat.i(4711);
        ToStringHelper toStringHelper = new ToStringHelper(obj);
        AppMethodBeat.o(4711);
        return toStringHelper;
    }
}
