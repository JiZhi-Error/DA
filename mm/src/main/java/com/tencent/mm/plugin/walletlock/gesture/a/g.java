package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class g {
    public long IvB = -1;
    public long IvC = 0;

    public final byte[] toByteArray() {
        AppMethodBeat.i(129789);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeLong(this.IvB);
            dataOutputStream.writeLong(this.IvC);
            dataOutputStream.close();
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.TimeInfo", e2, "", new Object[0]);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(129789);
        return byteArray;
    }

    public final g cu(byte[] bArr) {
        AppMethodBeat.i(129790);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            this.IvB = dataInputStream.readLong();
            this.IvC = dataInputStream.readLong();
            dataInputStream.close();
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.TimeInfo", e2, "", new Object[0]);
        }
        AppMethodBeat.o(129790);
        return this;
    }
}
