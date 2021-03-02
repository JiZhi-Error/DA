package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {
    public int IqK = 0;
    public String mMessage;
    public int mResponse;

    private c(int i2, String str) {
        this.mResponse = i2;
        this.mMessage = str;
    }

    public static c cJ(int i2, String str) {
        int i3 = 6;
        int i4 = R.string.j6w;
        AppMethodBeat.i(71810);
        if (i2 > -15001) {
            switch (i2) {
                case 0:
                    i4 = R.string.j6v;
                    i3 = i2;
                    break;
                case 1:
                case 7:
                    i4 = R.string.j6x;
                    i3 = i2;
                    break;
                case 3:
                case 105:
                    i3 = 3;
                    str = "Google Play not install";
                    break;
                case 6:
                    c cVar = new c(6, str);
                    AppMethodBeat.o(71810);
                    return cVar;
                case 8:
                    i4 = R.string.j6u;
                    i3 = i2;
                    break;
                case 103:
                case 104:
                case 100000002:
                    i3 = 100000002;
                    i4 = R.string.j6t;
                    break;
                case 109:
                    i4 = R.string.j6y;
                    i3 = i2;
                    break;
                case 110:
                    i4 = R.string.j70;
                    i3 = i2;
                    break;
                case 111:
                    i4 = R.string.j71;
                    i3 = i2;
                    break;
                case 112:
                    i4 = R.string.j6z;
                    i3 = i2;
                    break;
                case 113:
                    i3 = i2;
                    break;
            }
        } else {
            i3 = i2;
        }
        Log.i("MicroMsg.IapResult", "code : " + i2 + ", errMsg : " + str + ", convert to errCode : " + i3);
        if (Util.isNullOrNil(str)) {
            c cVar2 = new c(i3, MMApplicationContext.getContext().getString(i4));
            AppMethodBeat.o(71810);
            return cVar2;
        }
        c cVar3 = new c(i3, str);
        AppMethodBeat.o(71810);
        return cVar3;
    }

    public final boolean fUp() {
        return this.mResponse == 104 || this.mResponse == 100000002;
    }

    public final String toString() {
        AppMethodBeat.i(71812);
        String str = "IapResult: " + this.mMessage;
        AppMethodBeat.o(71812);
        return str;
    }

    public final boolean isFailure() {
        boolean z;
        AppMethodBeat.i(71811);
        if (this.mResponse == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z || fUp()) {
            AppMethodBeat.o(71811);
            return false;
        }
        AppMethodBeat.o(71811);
        return true;
    }
}
