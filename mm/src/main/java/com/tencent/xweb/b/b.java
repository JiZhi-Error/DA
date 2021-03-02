package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.d;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class b implements e {
    @Override // com.tencent.xweb.b.e
    public final String bhK(String str) {
        AppMethodBeat.i(183505);
        String md5 = d.getMD5(str);
        AppMethodBeat.o(183505);
        return md5;
    }

    @Override // com.tencent.xweb.b.e
    public final boolean copyFile(String str, String str2) {
        AppMethodBeat.i(183506);
        boolean copyFile = c.copyFile(str, str2);
        AppMethodBeat.o(183506);
        return copyFile;
    }

    @Override // com.tencent.xweb.b.e
    public final InputStream openRead(String str) {
        AppMethodBeat.i(183507);
        FileInputStream fileInputStream = new FileInputStream(str);
        AppMethodBeat.o(183507);
        return fileInputStream;
    }

    @Override // com.tencent.xweb.b.e
    public final OutputStream LM(String str) {
        AppMethodBeat.i(183508);
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        AppMethodBeat.o(183508);
        return fileOutputStream;
    }
}
