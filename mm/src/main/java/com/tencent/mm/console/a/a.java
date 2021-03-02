package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(20169);
        k.getEmojiStorageMgr().OpY.byC();
        AppMethodBeat.o(20169);
        return true;
    }
}
