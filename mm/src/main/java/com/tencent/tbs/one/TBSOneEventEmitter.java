package com.tencent.tbs.one;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public interface TBSOneEventEmitter {

    public enum UnloadedBehavior {
        IGNORE,
        LOAD,
        INSTALL;

        static {
            AppMethodBeat.i(53732);
            AppMethodBeat.o(53732);
        }

        public static UnloadedBehavior valueOf(String str) {
            AppMethodBeat.i(53731);
            UnloadedBehavior unloadedBehavior = (UnloadedBehavior) Enum.valueOf(UnloadedBehavior.class, str);
            AppMethodBeat.o(53731);
            return unloadedBehavior;
        }
    }

    void emit(UnloadedBehavior unloadedBehavior, String str, String str2, String str3, Map<String, Object> map);

    void emit(String str, Map<String, Object> map);
}
