package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.c;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONObject;

public final class e extends c {
    public e() {
        super("onTap");
    }

    public e(byte b2) {
        super("onTap", TbsListener.ErrorCode.THROWABLE_INITX5CORE);
    }

    @Override // com.tencent.mm.aa.b.c
    public final JSONObject toJSONObject() {
        AppMethodBeat.i(121395);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("todo implementation");
        AppMethodBeat.o(121395);
        throw unsupportedOperationException;
    }
}
