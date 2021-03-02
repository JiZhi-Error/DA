package com.tencent.mm.plugin.fingerprint.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e {
    public int errCode = -1;
    public String errMsg = "";
    public int retryCount = 0;
    public boolean wFM = false;
    public c wFV;

    public final boolean isSuccess() {
        return this.errCode == 0;
    }

    public final boolean canRetry() {
        return this.errCode == 1;
    }

    public static e b(c cVar) {
        AppMethodBeat.i(64402);
        e eVar = new e();
        eVar.wFV = cVar;
        switch (cVar.errCode) {
            case 0:
                eVar.errCode = 0;
                break;
            case 2002:
                eVar.errCode = 1;
                break;
            case 2004:
            case 2005:
            case 2007:
            case 2009:
            case 10308:
                eVar.errCode = 2;
                String string = MMApplicationContext.getContext().getString(R.string.hd4);
                if (cVar.errCode == 10308) {
                    string = MMApplicationContext.getContext().getString(R.string.hd5);
                } else if (cVar.errCode == 2007) {
                    p.IML.wFM = true;
                    eVar.wFM = true;
                } else if (cVar.errCode == 2005) {
                    string = MMApplicationContext.getContext().getString(R.string.hd6);
                }
                eVar.errMsg = string;
                break;
        }
        AppMethodBeat.o(64402);
        return eVar;
    }
}
