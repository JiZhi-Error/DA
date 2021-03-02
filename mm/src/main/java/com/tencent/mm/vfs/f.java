package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;

/* access modifiers changed from: package-private */
public final class f {
    FileSystem.b RbK;
    final FileSystem RbM;

    f(FileSystem fileSystem) {
        this.RbM = fileSystem;
    }

    public final String toString() {
        AppMethodBeat.i(187652);
        if (this.RbM == null) {
            AppMethodBeat.o(187652);
            return "[NULL]";
        }
        String obj = this.RbM.toString();
        AppMethodBeat.o(187652);
        return obj;
    }
}
