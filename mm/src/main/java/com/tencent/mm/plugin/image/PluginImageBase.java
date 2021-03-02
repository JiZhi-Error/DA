package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.ImageGCFileSystem;
import com.tencent.mm.vfs.MigrationFileSystem;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mm.vfs.StatisticsFileSystem;
import com.tencent.mm.vfs.d;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.y;

public class PluginImageBase extends f implements a {
    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(177298);
        if (gVar.aBb()) {
            y.at("image", "image", 19);
            y.at("image2", "image2", 1424);
            g.a hYS = com.tencent.mm.vfs.g.hYQ().hYS();
            ImageGCFileSystem imageGCFileSystem = new ImageGCFileSystem(com.tencent.mm.vfs.g.hYQ().hec().get("image2"));
            imageGCFileSystem.a("image2", new ImageGCFileSystem.a());
            hYS.a("image2", imageGCFileSystem);
            StatisticsFileSystem statisticsFileSystem = new StatisticsFileSystem(new MigrationFileSystem(true, true, (FileSystem) new NativeFileSystem("${sdTo}/MicroMsg/${accountSd}/image2"), new NativeFileSystem("${sdFrom}/MicroMsg/${accountSalt}/image2"), new NativeFileSystem("${sdFrom}/MicroMsg/${account}/image2")));
            statisticsFileSystem.a("OldImage2", new d("${sdTo}/MicroMsg/${accountSd}/image2", 0, 3, 0, 0));
            hYS.b("OldImage2", statisticsFileSystem).commit();
        }
        AppMethodBeat.o(177298);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(177299);
        if (gVar.aBb()) {
            pin(d.dZE());
        }
        AppMethodBeat.o(177299);
    }
}
