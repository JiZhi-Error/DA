package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class n {
    static final n Rdw = new n(null, null, null);
    final FileSystem Rdu;
    final a Rdv;
    final String gIx;

    public interface a {
        void a(String str, FileSystem fileSystem, int i2, Map<String, Object> map);
    }

    public n(FileSystem fileSystem, String str, a aVar) {
        this.Rdu = fileSystem;
        this.gIx = str;
        this.Rdv = aVar;
    }

    static {
        AppMethodBeat.i(187740);
        AppMethodBeat.o(187740);
    }
}
