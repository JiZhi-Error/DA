package com.tencent.mm.plugin.game.luggage;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.xweb.t;

public final class b {
    public static <T extends com.tencent.mm.ipcinvoker.b<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean b(InputType inputtype, Class<T> cls, d<ResultType> dVar) {
        boolean z;
        String str;
        AppMethodBeat.i(82981);
        if (!t.bsh(WeChatHosts.domainString(R.string.e1h)) || ToolsProcessIPCService.ayt()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            str = ToolsMpProcessIPCService.dkO;
        } else {
            str = ToolsProcessIPCService.dkO;
        }
        boolean a2 = h.a(str, inputtype, cls, dVar);
        AppMethodBeat.o(82981);
        return a2;
    }
}
