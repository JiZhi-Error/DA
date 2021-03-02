package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

public final class j {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a5 A[SYNTHETIC, Splitter:B:23:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b8 A[SYNTHETIC, Splitter:B:31:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(byte[] r7, int r8, short r9, com.tencent.mm.pointers.PByteArray r10, int r11) {
        /*
        // Method dump skipped, instructions count: 204
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.f.j.a(byte[], int, short, com.tencent.mm.pointers.PByteArray, int):void");
    }

    public static int a(byte[] bArr, int i2, short s, short s2, int i3, byte[] bArr2) {
        AppMethodBeat.i(21529);
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
            AppMethodBeat.o(21529);
            return value;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.BackupPacker", e2, "BackupPacker getCheckSum error.", new Object[0]);
            AppMethodBeat.o(21529);
            return 0;
        }
    }

    public static String aT(byte[] bArr) {
        int i2;
        AppMethodBeat.i(21530);
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
        Log.e("MicroMsg.BackupPacker", "dumpErr errBuf:%s", str);
        AppMethodBeat.o(21530);
        return str;
    }
}
