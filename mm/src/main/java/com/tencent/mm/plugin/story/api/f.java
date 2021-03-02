package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface f {
    boolean a(a aVar);

    boolean fnd();

    public enum a {
        TimeLine_Des,
        TimeLine_Comment,
        TimeLine_Like;

        public static a valueOf(String str) {
            AppMethodBeat.i(118415);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(118415);
            return aVar;
        }

        static {
            AppMethodBeat.i(118416);
            AppMethodBeat.o(118416);
        }
    }
}
