package com.tencent.mm.booter.notification.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public Intent mIntent;

    public static PendingIntent c(Context context, int i2, Intent intent) {
        AppMethodBeat.i(20043);
        PendingIntent activity = PendingIntent.getActivity(context, i2, intent, 134217728);
        AppMethodBeat.o(20043);
        return activity;
    }
}
