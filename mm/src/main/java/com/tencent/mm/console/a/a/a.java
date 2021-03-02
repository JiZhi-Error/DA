package com.tencent.mm.console.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(20197);
        if (strArr.length <= 1) {
            AppMethodBeat.o(20197);
            return false;
        }
        if (Util.getInt(strArr[1], 0) > 0) {
            com.tencent.mm.plugin.hardcoder.a.yjb = true;
        } else {
            com.tencent.mm.plugin.hardcoder.a.yjb = false;
        }
        AppMethodBeat.o(20197);
        return true;
    }
}
