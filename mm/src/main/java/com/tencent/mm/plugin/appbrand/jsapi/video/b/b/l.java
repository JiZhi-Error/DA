package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.i;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface l extends t {
    i<String> bJR();

    Map<String, List<String>> getResponseHeaders();

    public static class a extends IOException {
        public final g mxt;

        public a(String str, g gVar) {
            super(str);
            this.mxt = gVar;
        }

        public a(IOException iOException, g gVar) {
            super(iOException);
            this.mxt = gVar;
        }

        public a(String str, IOException iOException, g gVar) {
            super(str, iOException);
            this.mxt = gVar;
        }
    }

    public static final class e extends a {
        public final Map<String, List<String>> bFD;
        public final String contentType;

        public e(String str, Map<String, List<String>> map, g gVar) {
            super("Invalid content type: ".concat(String.valueOf(str)), gVar);
            AppMethodBeat.i(234757);
            this.contentType = str;
            this.bFD = map;
            AppMethodBeat.o(234757);
        }
    }

    public static final class c extends a {
        public c(String str, g gVar) {
            super(str, gVar);
        }
    }

    public static final class b extends a {
        public b(String str, IOException iOException, g gVar) {
            super(str, iOException, gVar);
        }

        public b(String str, g gVar) {
            super(str, gVar);
        }
    }

    public static final class h extends a {
        public h(String str, IOException iOException, g gVar) {
            super(str, iOException, gVar);
        }
    }

    public static final class g extends a {
        public g(String str, g gVar) {
            super(str, gVar);
        }
    }

    public static final class d extends a {
        public d(String str, g gVar) {
            super(str, gVar);
        }
    }

    public static final class f extends a {
        public final Map<String, List<String>> bFD;
        public final int responseCode;

        public f(int i2, Map<String, List<String>> map, g gVar) {
            super("Response code: ".concat(String.valueOf(i2)), gVar);
            AppMethodBeat.i(234758);
            this.responseCode = i2;
            this.bFD = map;
            AppMethodBeat.o(234758);
        }
    }
}
