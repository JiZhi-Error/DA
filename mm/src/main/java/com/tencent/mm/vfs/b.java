package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.g;

/* access modifiers changed from: package-private */
public final class b {
    private static final String[] Rbc = {"${sdFrom}/MicroMsg/xlog", "${sdTo}/MicroMsg/${accountSalt}/bizmsg", "${sdFrom}/MicroMsg/${accountSalt}/bizmsg", "${sdFrom}/MicroMsg/${accountSalt}/sfs", "${sdTo}/MicroMsg/${accountSalt}/sfs", "${sdFrom}/MicroMsg/wxavideocache", "${sdTo}/MicroMsg/wxavideocache", "${sdFrom}/MicroMsg/wxvideocache", "${sdTo}/MicroMsg/wxvideocache", "${sdTo}/MicroMsg/${accountSalt}/backup", "${sdFrom}/MicroMsg/${accountSalt}/backup"};

    static void a(g.a aVar) {
        AppMethodBeat.i(197204);
        FileSystem[] fileSystemArr = new FileSystem[Rbc.length];
        for (int i2 = 0; i2 < fileSystemArr.length; i2++) {
            fileSystemArr[i2] = new DeleteAllFileSystem(new NativeFileSystem(Rbc[i2]));
        }
        aVar.b("@CleanRubbish", new MaintenanceGroup(fileSystemArr));
        AppMethodBeat.o(197204);
    }
}
