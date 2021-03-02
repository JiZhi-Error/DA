package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g extends j {
    private byte pgo = 0;

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.d.a.a.j
    public final boolean aW(byte[] bArr) {
        AppMethodBeat.i(22467);
        if (Util.isNullOrNil(bArr)) {
            Log.e("MicroMsg.exdevice.IBeaconTLVSectionA", "valueByte is null or nil");
            AppMethodBeat.o(22467);
            return false;
        } else if (2 != this.mLength) {
            Log.d("MicroMsg.exdevice.IBeaconTLVSectionA", "IBEACON_TLV_SECTION_A_LENGTH != mLength(%d)", Integer.valueOf(this.mLength));
            AppMethodBeat.o(22467);
            return false;
        } else {
            this.pgo = bArr[0];
            AppMethodBeat.o(22467);
            return true;
        }
    }
}
