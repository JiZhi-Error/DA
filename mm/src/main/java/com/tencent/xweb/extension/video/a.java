package com.tencent.xweb.extension.video;

import android.content.ContentResolver;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private int SAZ = 255;
    private ContentResolver bEK;

    public a(Context context) {
        AppMethodBeat.i(153551);
        this.bEK = context.getContentResolver();
        AppMethodBeat.o(153551);
    }
}
