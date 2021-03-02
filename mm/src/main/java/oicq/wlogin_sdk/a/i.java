package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import oicq.wlogin_sdk.tools.util;

public final class i extends a {
    int Udy = 6;

    public i() {
        this.Ucx = 263;
    }

    public final byte[] hPD() {
        AppMethodBeat.i(88131);
        byte[] bArr = new byte[this.Udy];
        util.ah(bArr, 0, 0);
        util.ag(bArr, 2, 1);
        util.ah(bArr, 3, ShareConstants.MD5_FILE_BUF_LENGTH);
        util.ag(bArr, 5, 1);
        super.awj(this.Ucx);
        super.ak(bArr, this.Udy);
        super.hPB();
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88131);
        return hPx;
    }
}
