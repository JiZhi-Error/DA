package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

public final class b {
    public static int a(byte[] bArr, int i2, short s, short s2, int i3, byte[] bArr2) {
        AppMethodBeat.i(21809);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(o.iC(i2));
            byteArrayOutputStream.write(new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)});
            byteArrayOutputStream.write(new byte[]{(byte) ((s2 >> 8) & 255), (byte) (s2 & 255)});
            byteArrayOutputStream.write(o.iC(i3));
            byteArrayOutputStream.write(o.iC(0));
            byteArrayOutputStream.write(bArr2);
            CRC32 crc32 = new CRC32();
            crc32.update(byteArrayOutputStream.toByteArray());
            int value = (int) crc32.getValue();
            AppMethodBeat.o(21809);
            return value;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.BakOldPacker", e2, "", new Object[0]);
            AppMethodBeat.o(21809);
            return 0;
        }
    }

    public static String aT(byte[] bArr) {
        int i2;
        AppMethodBeat.i(21810);
        String str = "";
        if (bArr.length > 100) {
            i2 = bArr.length - 100;
        } else {
            i2 = 0;
        }
        while (i2 < bArr.length) {
            str = str + Integer.toHexString(bArr[i2] & 255) + " ";
            i2++;
        }
        Log.e("MicroMsg.BakOldPacker", "dump errBuf: %s", str);
        AppMethodBeat.o(21810);
        return str;
    }
}
