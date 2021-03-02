package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface bw {
    <WIDGET extends View> WIDGET d(Context context, Class<WIDGET> cls);

    public static class a implements bw {
        @Override // com.tencent.mm.plugin.appbrand.page.bw
        public <WIDGET extends View> WIDGET d(Context context, Class<WIDGET> cls) {
            AppMethodBeat.i(135280);
            WIDGET cast = cls.cast(org.a.a.bF(cls).ak(context).object);
            AppMethodBeat.o(135280);
            return cast;
        }
    }
}
