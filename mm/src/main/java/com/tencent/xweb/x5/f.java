package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.xweb.internal.IJsRuntime;
import org.xwalk.core.Log;

public final class f implements IJsRuntime {
    private X5JsCore SFa;
    private Context mContext;

    public f(Context context) {
        AppMethodBeat.i(153843);
        this.mContext = context;
        Log.i("MicroMsg.X5JsRuntime", "create X5V8JsRuntime");
        AppMethodBeat.o(153843);
    }

    @Override // com.tencent.xweb.internal.IJsRuntime
    public final void init(int i2) {
        AppMethodBeat.i(153844);
        this.SFa = new X5JsCore(this.mContext);
        AppMethodBeat.o(153844);
    }
}
