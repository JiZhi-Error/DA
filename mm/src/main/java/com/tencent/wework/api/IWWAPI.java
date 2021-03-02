package com.tencent.wework.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.BaseMessage;

public interface IWWAPI {
    boolean a(WWAppType wWAppType);

    boolean a(BaseMessage baseMessage, WWAppType wWAppType);

    String b(WWAppType wWAppType);

    boolean hrE();

    public enum WWAppType {
        WwAppTypeDefault,
        WwAppTypeWxwork,
        WwAppTypeLocal;

        public static WWAppType valueOf(String str) {
            AppMethodBeat.i(198980);
            WWAppType wWAppType = (WWAppType) Enum.valueOf(WWAppType.class, str);
            AppMethodBeat.o(198980);
            return wWAppType;
        }

        static {
            AppMethodBeat.i(198981);
            AppMethodBeat.o(198981);
        }
    }
}
