package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.charset.Charset;

public enum a implements b {
    INSTANCE;

    public static a valueOf(String str) {
        AppMethodBeat.i(89140);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(89140);
        return aVar;
    }

    static {
        AppMethodBeat.i(89142);
        AppMethodBeat.o(89142);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.b
    public final void a(int i2, String str, int i3, byte[] bArr) {
        AppMethodBeat.i(89141);
        if (str == null) {
            Log.w("MicroMsg.ClipBordReportImpl", "operationInfo isNullOrNil");
            AppMethodBeat.o(89141);
        } else if (!g.aAc()) {
            AppMethodBeat.o(89141);
        } else {
            aax aax = new aax();
            aax.Lmf = i2;
            aax.Lmh = i3;
            aax.Lmg = new SKBuiltinBuffer_t().setBuffer(str.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
            if (!Util.isNullOrNil(bArr)) {
                aax.Lmi = new SKBuiltinBuffer_t().setBuffer(bArr);
            }
            aay aay = new aay();
            aay.Lmk.add(aax);
            aay.Lmj = aay.Lmk.size();
            ((l) g.af(l.class)).aSM().d(new k.a(211, aay));
            AppMethodBeat.o(89141);
        }
    }
}
