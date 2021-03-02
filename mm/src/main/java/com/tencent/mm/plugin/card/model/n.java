package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n {
    public static int pTP = 1;

    public enum a {
        NORMAL_TYPE,
        INVALID_TYPE,
        CAN_GIFT_TYPE,
        GENERAL_TYPE,
        MEMBER_CARD_TYPE,
        HOME_MEMBER_CARD_TYPE,
        GENERAL_WITHOUT_INVOICE_TYPE;

        public static a valueOf(String str) {
            AppMethodBeat.i(112797);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(112797);
            return aVar;
        }

        static {
            AppMethodBeat.i(112798);
            AppMethodBeat.o(112798);
        }
    }
}
