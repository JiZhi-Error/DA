package com.tencent.mm.plugin.appbrand.dynamic.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a implements com.tencent.mm.aa.d.a {
    private static final int loy = (-Util.getInt(ac.jOx, 0));
    private String id;
    private byte[] loz;

    static {
        AppMethodBeat.i(121381);
        AppMethodBeat.o(121381);
    }

    public a(String str, byte[] bArr) {
        this.id = str;
        this.loz = bArr;
    }

    @Override // com.tencent.mm.aa.d.a
    public final boolean pP(int i2) {
        byte b2;
        AppMethodBeat.i(121380);
        int i3 = loy;
        if (i3 == -1) {
            Log.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm on", this.id, Integer.valueOf(i2));
            b2 = 1;
        } else if (i3 == -2) {
            Log.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm off", this.id, Integer.valueOf(i2));
            b2 = 0;
        } else if (i2 == -2) {
            b2 = 1;
        } else if (i2 == -1) {
            b2 = 0;
        } else {
            b2 = (this.loz == null || i2 < 0 || i2 >= this.loz.length) ? 0 : this.loz[i2];
        }
        if (b2 == 1) {
            AppMethodBeat.o(121380);
            return true;
        }
        AppMethodBeat.o(121380);
        return false;
    }
}
