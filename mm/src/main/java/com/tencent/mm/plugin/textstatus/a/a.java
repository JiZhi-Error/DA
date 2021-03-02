package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {

    public enum c {
        FILLED,
        OUTLINED;

        public static c valueOf(String str) {
            AppMethodBeat.i(222799);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(222799);
            return cVar;
        }

        static {
            AppMethodBeat.i(222800);
            AppMethodBeat.o(222800);
        }
    }

    /* renamed from: com.tencent.mm.plugin.textstatus.a.a$a  reason: collision with other inner class name */
    public enum EnumC1808a {
        DEFAULT,
        WHITE,
        FXe,
        GREY;

        public static EnumC1808a valueOf(String str) {
            AppMethodBeat.i(222793);
            EnumC1808a aVar = (EnumC1808a) Enum.valueOf(EnumC1808a.class, str);
            AppMethodBeat.o(222793);
            return aVar;
        }

        static {
            AppMethodBeat.i(222794);
            AppMethodBeat.o(222794);
        }
    }

    public enum b {
        CONVERSATION_LIST,
        CONTACT_LIST,
        GROUP_CHAT,
        SNS_FEED,
        SNS_COMMENT,
        SNS_NOTIFICATION,
        PLANET;

        public static b valueOf(String str) {
            AppMethodBeat.i(222796);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(222796);
            return bVar;
        }

        static {
            AppMethodBeat.i(222797);
            AppMethodBeat.o(222797);
        }
    }
}
