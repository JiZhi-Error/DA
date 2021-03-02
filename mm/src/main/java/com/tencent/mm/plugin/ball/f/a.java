package com.tencent.mm.plugin.ball.f;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Set;

public final class a {
    public static void a(Intent intent, Bundle bundle, Set<String> set) {
        AppMethodBeat.i(127555);
        Bundle bundle2 = new Bundle();
        for (String str : set) {
            if (bundle.containsKey(str)) {
                a(bundle2, str, bundle.get(str));
            }
        }
        intent.putExtras(bundle2);
        AppMethodBeat.o(127555);
    }

    public static void b(Intent intent, Bundle bundle, Set<String> set) {
        AppMethodBeat.i(127556);
        if (intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            for (String str : set) {
                if (extras.containsKey(str)) {
                    a(bundle, str, extras.get(str));
                }
            }
        }
        AppMethodBeat.o(127556);
    }

    private static void a(Bundle bundle, String str, Object obj) {
        AppMethodBeat.i(127557);
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            AppMethodBeat.o(127557);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            AppMethodBeat.o(127557);
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            AppMethodBeat.o(127557);
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            AppMethodBeat.o(127557);
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            AppMethodBeat.o(127557);
        } else if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
            AppMethodBeat.o(127557);
        } else {
            Log.w("MicroMsg.FloatBallIntentUtil", "put not support type, key:%s, value:%s", str, obj);
            AppMethodBeat.o(127557);
        }
    }
}
