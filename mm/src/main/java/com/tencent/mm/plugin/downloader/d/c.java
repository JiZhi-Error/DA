package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Properties;

public final class c {
    private static final l qHz = new l(38650);
    Properties qHA = new Properties();
    byte[] qHB;

    public c() {
        AppMethodBeat.i(88863);
        AppMethodBeat.o(88863);
    }

    static {
        AppMethodBeat.i(88868);
        AppMethodBeat.o(88868);
    }

    public final void W(byte[] bArr) {
        AppMethodBeat.i(88865);
        if (bArr == null) {
            Log.w("MicroMsg.Channel.GameComment", "decode, data is null");
            AppMethodBeat.o(88865);
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte[] bArr2 = new byte[2];
        wrap.get(bArr2);
        if (!qHz.equals(new l(bArr2))) {
            Log.e("MicroMsg.Channel.GameComment", "decode, unknow protocol");
        }
        if (bArr.length - 2 <= 2) {
            Log.e("MicroMsg.Channel.GameComment", "decode, data.length - headLength <= 2");
            AppMethodBeat.o(88865);
            return;
        }
        byte[] bArr3 = new byte[2];
        wrap.get(bArr3);
        int i2 = new l(bArr3).value;
        if ((bArr.length - 2) - 2 < i2) {
            Log.e("MicroMsg.Channel.GameComment", "decode, cooment content is empty");
            AppMethodBeat.o(88865);
            return;
        }
        byte[] bArr4 = new byte[i2];
        wrap.get(bArr4);
        try {
            this.qHA.load(new InputStreamReader(new ByteArrayInputStream(bArr4), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        } catch (IOException e2) {
        }
        int length = ((bArr.length - 2) - i2) - 2;
        if (length > 0) {
            this.qHB = new byte[length];
            wrap.get(this.qHB);
        }
        AppMethodBeat.o(88865);
    }

    public final String toString() {
        AppMethodBeat.i(88867);
        String str = "GameComment [p=" + this.qHA + ", otherData=" + (this.qHB == null ? "" : new String(this.qHB)) + "]";
        AppMethodBeat.o(88867);
        return str;
    }
}
