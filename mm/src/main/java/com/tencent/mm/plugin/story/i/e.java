package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.d;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class e extends MAutoStorage<d> {
    private static final String[] Fwb = {MAutoStorage.getCreateSQLs(d.info, "StoryEditorInfo")};
    public static final a Fwc = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119487);
        d.a aVar = d.Fwa;
        AppMethodBeat.o(119487);
    }
}
