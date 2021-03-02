package com.tencent.mm.compatible.i;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static boolean w(Activity activity) {
        AppMethodBeat.i(155922);
        final Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("android.intent.extra.videoQuality", 0);
        a.a(8, new a.AbstractC0298a() {
            /* class com.tencent.mm.compatible.i.b.AnonymousClass1 */

            @Override // com.tencent.mm.compatible.a.a.AbstractC0298a
            public final void run() {
                AppMethodBeat.i(155921);
                intent.putExtra("android.intent.extra.durationLimit", 30);
                intent.putExtra("android.intent.extra.sizeLimit", 10485760);
                AppMethodBeat.o(155921);
            }
        });
        try {
            activity.startActivityForResult(intent, 4372);
            AppMethodBeat.o(155922);
            return true;
        } catch (ActivityNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.TakeVideoUtil", e2, "", new Object[0]);
            AppMethodBeat.o(155922);
            return false;
        }
    }
}
