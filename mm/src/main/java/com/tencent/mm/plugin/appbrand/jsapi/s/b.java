package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface b {
    a Px();

    Boolean Py();

    public enum a {
        NONE,
        PUSH,
        POP,
        PUSH_AND_POP;

        public static a valueOf(String str) {
            AppMethodBeat.i(176551);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(176551);
            return aVar;
        }

        static {
            AppMethodBeat.i(176553);
            AppMethodBeat.o(176553);
        }

        public static a aaE(String str) {
            AppMethodBeat.i(176552);
            String trim = str.trim();
            char c2 = 65535;
            switch (trim.hashCode()) {
                case 0:
                    if (trim.equals("")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 111185:
                    if (trim.equals("pop")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3452698:
                    if (trim.equals("push")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1077886132:
                    if (trim.equals("pushAndPop")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a aVar = NONE;
                    AppMethodBeat.o(176552);
                    return aVar;
                case 1:
                    a aVar2 = PUSH;
                    AppMethodBeat.o(176552);
                    return aVar2;
                case 2:
                    a aVar3 = POP;
                    AppMethodBeat.o(176552);
                    return aVar3;
                case 3:
                    a aVar4 = PUSH_AND_POP;
                    AppMethodBeat.o(176552);
                    return aVar4;
                default:
                    AppMethodBeat.o(176552);
                    return null;
            }
        }
    }
}
