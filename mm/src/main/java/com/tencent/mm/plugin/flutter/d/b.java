package com.tencent.mm.plugin.flutter.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.n;
import io.flutter.plugin.platform.d;

public final class b extends d {
    private c wJt;

    public b(c cVar) {
        super(n.SSp);
        this.wJt = cVar;
    }

    @Override // io.flutter.plugin.platform.d
    public final io.flutter.plugin.platform.c a(Context context, int i2, Object obj) {
        AppMethodBeat.i(240950);
        a aVar = new a(context, this.wJt, i2, obj);
        AppMethodBeat.o(240950);
        return aVar;
    }
}
