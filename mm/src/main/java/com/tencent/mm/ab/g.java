package com.tencent.mm.ab;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;

public final class g extends JSONException {
    public g(String str) {
        super(str);
    }

    public g(Throwable th) {
        super(Log.getStackTraceString(th));
        AppMethodBeat.i(158564);
        AppMethodBeat.o(158564);
    }
}
