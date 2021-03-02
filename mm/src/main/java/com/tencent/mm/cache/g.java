package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public interface g {
    void f(Object obj, Object obj2);

    Object get(Object obj);

    Object remove(Object obj);

    public static class a {
        private static Map<String, g> gpF = new HashMap();

        static {
            AppMethodBeat.i(131947);
            AppMethodBeat.o(131947);
        }

        public static void a(String str, g gVar) {
            AppMethodBeat.i(131940);
            gpF.put(str, gVar);
            AppMethodBeat.o(131940);
        }

        private static g Dr(String str) {
            AppMethodBeat.i(131941);
            g gVar = gpF.get(str);
            AppMethodBeat.o(131941);
            return gVar;
        }

        public static <T> T X(String str, String str2) {
            AppMethodBeat.i(131942);
            T t = (T) a(Dr(str), str2);
            AppMethodBeat.o(131942);
            return t;
        }

        public static <T> void a(String str, String str2, T t) {
            AppMethodBeat.i(131943);
            g Dr = Dr(str);
            if (Dr == null) {
                Log.e("MicroMsg.ICacheService.Factory", "null service");
                AppMethodBeat.o(131943);
                return;
            }
            Dr.f(str2, t);
            AppMethodBeat.o(131943);
        }

        public static <T> void Y(String str, String str2) {
            AppMethodBeat.i(131944);
            b(Dr(str), str2);
            AppMethodBeat.o(131944);
        }

        private static <T> T a(g gVar, String str) {
            T t = null;
            AppMethodBeat.i(131945);
            if (gVar == null) {
                Log.e("MicroMsg.ICacheService.Factory", "null service");
                AppMethodBeat.o(131945);
            } else {
                try {
                    t = (T) gVar.get(str);
                    AppMethodBeat.o(131945);
                } catch (Exception e2) {
                    Log.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                    Log.e("MicroMsg.ICacheService.Factory", "exception:%s", Util.stackTraceToString(e2));
                    AppMethodBeat.o(131945);
                }
            }
            return t;
        }

        private static <T> T b(g gVar, String str) {
            T t = null;
            AppMethodBeat.i(131946);
            if (gVar == null) {
                Log.e("MicroMsg.ICacheService.Factory", "null service");
                AppMethodBeat.o(131946);
            } else {
                try {
                    t = (T) gVar.remove(str);
                    AppMethodBeat.o(131946);
                } catch (Exception e2) {
                    Log.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                    Log.e("MicroMsg.ICacheService.Factory", "exception:%s", Util.stackTraceToString(e2));
                    AppMethodBeat.o(131946);
                }
            }
            return t;
        }
    }
}
