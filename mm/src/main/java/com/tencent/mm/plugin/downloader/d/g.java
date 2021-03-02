package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.k;
import com.tencent.mm.d.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.RandomAccessFile;

public final class g {
    private static final k djp = new k(101010256);

    static {
        AppMethodBeat.i(88881);
        AppMethodBeat.o(88881);
    }

    public static byte[] ala(String str) {
        byte[] bArr;
        AppMethodBeat.i(88880);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(88880);
            return null;
        }
        RandomAccessFile dB = s.dB(str, false);
        if (dB.length() == 0) {
            dB.close();
            Log.i("MicroMsg.Channel.ZipEocdCommentTool", "apk file length is zero");
            AppMethodBeat.o(88880);
            return null;
        }
        try {
            o oVar = new o(str);
            RandomAccessFile dB2 = s.dB(aa.z(oVar.mUri), false);
            dB2.seek((((Long) e.L(oVar).second).longValue() + 22) - 2);
            byte[] bArr2 = new byte[2];
            dB2.readFully(bArr2);
            int i2 = new l(bArr2).value;
            if (i2 == 0) {
                dB2.close();
                bArr = null;
            } else {
                bArr = new byte[i2];
                dB2.read(bArr);
                dB2.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.Channel.ZipEocdCommentTool", "readComment, error: %s", e2.getMessage());
            bArr = null;
        }
        dB.close();
        AppMethodBeat.o(88880);
        return bArr;
    }
}
