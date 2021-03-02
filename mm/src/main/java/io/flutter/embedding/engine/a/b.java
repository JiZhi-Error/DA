package io.flutter.embedding.engine.a;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public final class b {
    private static final String[] SUPPORTED_ABIS;

    static {
        String[] strArr;
        AppMethodBeat.i(215011);
        if (Build.VERSION.SDK_INT >= 21) {
            strArr = Build.SUPPORTED_ABIS;
        } else {
            ArrayList arrayList = new ArrayList(Arrays.asList(Build.CPU_ABI, Build.CPU_ABI2));
            arrayList.removeAll(Arrays.asList(null, ""));
            strArr = (String[]) arrayList.toArray(new String[0]);
        }
        SUPPORTED_ABIS = strArr;
        AppMethodBeat.o(215011);
    }
}
