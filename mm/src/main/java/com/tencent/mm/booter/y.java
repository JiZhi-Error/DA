package com.tencent.mm.booter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class y {
    static final String gmO = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/reportdevice");
    Context context;

    static {
        AppMethodBeat.i(231498);
        AppMethodBeat.o(231498);
    }

    public y(Context context2) {
        this.context = context2;
    }
}
