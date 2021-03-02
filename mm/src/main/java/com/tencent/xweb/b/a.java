package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class a implements d {
    File mFile;

    public a(File file) {
        this.mFile = file;
    }

    @Override // com.tencent.xweb.b.d
    public final String getPath() {
        AppMethodBeat.i(183499);
        String path = this.mFile.getPath();
        AppMethodBeat.o(183499);
        return path;
    }

    @Override // com.tencent.xweb.b.d
    public final boolean isDirectory() {
        AppMethodBeat.i(183500);
        boolean isDirectory = this.mFile.isDirectory();
        AppMethodBeat.o(183500);
        return isDirectory;
    }

    @Override // com.tencent.xweb.b.d
    public final d[] htr() {
        AppMethodBeat.i(183501);
        File[] listFiles = this.mFile.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            d[] dVarArr = new d[0];
            AppMethodBeat.o(183501);
            return dVarArr;
        }
        d[] dVarArr2 = new d[listFiles.length];
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            dVarArr2[i2] = new a(listFiles[i2]);
        }
        AppMethodBeat.o(183501);
        return dVarArr2;
    }

    @Override // com.tencent.xweb.b.d
    public final boolean exists() {
        AppMethodBeat.i(183502);
        boolean exists = this.mFile.exists();
        AppMethodBeat.o(183502);
        return exists;
    }

    @Override // com.tencent.xweb.b.d
    public final boolean delete() {
        AppMethodBeat.i(183503);
        boolean delete = this.mFile.delete();
        AppMethodBeat.o(183503);
        return delete;
    }

    @Override // com.tencent.xweb.b.d
    public final String[] list() {
        AppMethodBeat.i(183504);
        String[] list = this.mFile.list();
        AppMethodBeat.o(183504);
        return list;
    }
}
