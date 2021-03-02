package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class h implements d {
    public d SCC;

    @Override // com.tencent.xweb.b.d
    public final /* synthetic */ d[] htr() {
        AppMethodBeat.i(183523);
        h[] htu = htu();
        AppMethodBeat.o(183523);
        return htu;
    }

    public h(String str) {
        AppMethodBeat.i(183513);
        this.SCC = g.htt().bst(str);
        AppMethodBeat.o(183513);
    }

    private h(d dVar) {
        this.SCC = dVar;
    }

    public h(File file) {
        AppMethodBeat.i(183514);
        this.SCC = g.htt().aj(file);
        AppMethodBeat.o(183514);
    }

    @Override // com.tencent.xweb.b.d
    public final String getPath() {
        AppMethodBeat.i(183515);
        String path = this.SCC.getPath();
        AppMethodBeat.o(183515);
        return path;
    }

    @Override // com.tencent.xweb.b.d
    public final boolean isDirectory() {
        AppMethodBeat.i(183516);
        boolean isDirectory = this.SCC.isDirectory();
        AppMethodBeat.o(183516);
        return isDirectory;
    }

    public final h[] htu() {
        AppMethodBeat.i(183517);
        d[] htr = this.SCC.htr();
        if (htr == null || htr.length == 0) {
            h[] hVarArr = new h[0];
            AppMethodBeat.o(183517);
            return hVarArr;
        }
        h[] hVarArr2 = new h[htr.length];
        for (int i2 = 0; i2 < htr.length; i2++) {
            hVarArr2[i2] = new h(htr[i2]);
        }
        AppMethodBeat.o(183517);
        return hVarArr2;
    }

    public final String getName() {
        AppMethodBeat.i(183518);
        String path = this.SCC.getPath();
        AppMethodBeat.o(183518);
        return path;
    }

    public final String getAbsolutePath() {
        AppMethodBeat.i(183519);
        String path = this.SCC.getPath();
        AppMethodBeat.o(183519);
        return path;
    }

    @Override // com.tencent.xweb.b.d
    public final boolean exists() {
        AppMethodBeat.i(183520);
        boolean exists = this.SCC.exists();
        AppMethodBeat.o(183520);
        return exists;
    }

    @Override // com.tencent.xweb.b.d
    public final boolean delete() {
        AppMethodBeat.i(183521);
        boolean delete = this.SCC.delete();
        AppMethodBeat.o(183521);
        return delete;
    }

    @Override // com.tencent.xweb.b.d
    public final String[] list() {
        AppMethodBeat.i(183522);
        String[] list = this.SCC.list();
        AppMethodBeat.o(183522);
        return list;
    }
}
