package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Arrays;

public final class h extends j {
    private static final byte[] pgp = {76, 0, 2, 21};
    private byte[] pgq = null;
    public byte[] pgr = null;
    public short pgs = -1;
    public short pgt = -1;
    public int pgu = 0;

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.d.a.a.j
    public final boolean aW(byte[] bArr) {
        AppMethodBeat.i(22468);
        if (Util.isNullOrNil(bArr)) {
            Log.e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
            AppMethodBeat.o(22468);
            return false;
        } else if (26 != this.mLength) {
            Log.d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", Integer.valueOf(this.mLength));
            AppMethodBeat.o(22468);
            return false;
        } else {
            a aVar = new a(bArr.length);
            aVar.U(bArr, bArr.length);
            byte[] bArr2 = new byte[4];
            aVar.T(bArr2, 4);
            if (!Arrays.equals(bArr2, pgp)) {
                Log.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
                AppMethodBeat.o(22468);
                return false;
            }
            this.pgq = bArr2;
            this.pgr = new byte[16];
            aVar.T(this.pgr, 16);
            try {
                this.pgs = aVar.readShort();
                this.pgt = aVar.readShort();
                byte[] bArr3 = new byte[1];
                aVar.T(bArr3, 1);
                this.pgu = bArr3[0];
                AppMethodBeat.o(22468);
                return true;
            } catch (IOException e2) {
                Log.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
                Log.printErrStackTrace("MicroMsg.exdevice.IBeaconTLVSectionB", e2, "", new Object[0]);
                AppMethodBeat.o(22468);
                return false;
            }
        }
    }
}
