package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.Map;

public interface i {

    public static final class a extends p.a {
        @Override // com.tencent.mm.plugin.appbrand.jsapi.p.a
        public final /* synthetic */ p.a I(Map map) {
            AppMethodBeat.i(140674);
            a N = N(map);
            AppMethodBeat.o(140674);
            return N;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.p.a
        public final /* synthetic */ p.a o(String str, Object obj) {
            AppMethodBeat.i(140675);
            a q = q(str, obj);
            AppMethodBeat.o(140675);
            return q;
        }

        public a(String str, Object... objArr) {
            super(str, objArr);
        }

        public final a q(String str, Object obj) {
            AppMethodBeat.i(140672);
            a aVar = (a) super.o(str, obj);
            AppMethodBeat.o(140672);
            return aVar;
        }

        public final a N(Map<String, Object> map) {
            AppMethodBeat.i(140673);
            a aVar = (a) super.I(map);
            AppMethodBeat.o(140673);
            return aVar;
        }
    }
}
