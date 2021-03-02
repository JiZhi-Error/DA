package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.e;

public final class j {

    enum a implements e<Object, Boolean> {
        INSTANCE;

        public static a valueOf(String str) {
            AppMethodBeat.i(90229);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(90229);
            return aVar;
        }

        static {
            AppMethodBeat.i(90230);
            AppMethodBeat.o(90230);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // rx.b.e
        public final /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
