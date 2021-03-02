package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class f extends c {
    protected o mFile;
    private OutputStream zw;

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public boolean i(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(146349);
        acM(str);
        AppMethodBeat.o(146349);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public final boolean a(boolean z, byte[] bArr, int i2) {
        AppMethodBeat.i(146350);
        d(bArr, i2, z);
        try {
            if (this.zw != null) {
                this.zw.write(bArr);
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(146350);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public final void flush() {
        AppMethodBeat.i(146351);
        d(new byte[0], 0, true);
        AppMethodBeat.o(146351);
    }

    private boolean acM(String str) {
        AppMethodBeat.i(146353);
        try {
            this.mFile = new o(str);
            if (this.mFile.exists()) {
                this.mFile.delete();
            }
            this.mFile.createNewFile();
            this.zw = new DataOutputStream(s.dw(str, false));
            AppMethodBeat.o(146353);
            return true;
        } catch (Exception e2) {
            Log.printInfoStack("Luggage.PCMAudioEncoder", "", e2);
            AppMethodBeat.o(146353);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public void close() {
        AppMethodBeat.i(146352);
        if (this.zw != null) {
            try {
                this.zw.flush();
                this.zw.close();
            } catch (IOException e2) {
            }
            this.zw = null;
        }
        AppMethodBeat.o(146352);
    }
}
