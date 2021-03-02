package org.extra.a;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import org.extra.a.c;

/* access modifiers changed from: package-private */
public final class e implements c.b {
    e() {
    }

    @Override // org.extra.a.c.b
    public final void loadLibrary(String str) {
        AppMethodBeat.i(236784);
        System.loadLibrary(str);
        AppMethodBeat.o(236784);
    }

    @Override // org.extra.a.c.b
    public final void bvp(String str) {
        AppMethodBeat.i(236785);
        System.load(str);
        AppMethodBeat.o(236785);
    }

    @Override // org.extra.a.c.b
    public final String mapLibraryName(String str) {
        AppMethodBeat.i(236786);
        if (!str.startsWith(ShareConstants.SO_PATH) || !str.endsWith(".so")) {
            String mapLibraryName = System.mapLibraryName(str);
            AppMethodBeat.o(236786);
            return mapLibraryName;
        }
        AppMethodBeat.o(236786);
        return str;
    }

    @Override // org.extra.a.c.b
    public final String bvq(String str) {
        AppMethodBeat.i(236787);
        String substring = str.substring(3, str.length() - 3);
        AppMethodBeat.o(236787);
        return substring;
    }

    @Override // org.extra.a.c.b
    public final String[] hPR() {
        AppMethodBeat.i(236788);
        if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
            String[] strArr = Build.SUPPORTED_ABIS;
            AppMethodBeat.o(236788);
            return strArr;
        } else if (!f.isEmpty(Build.CPU_ABI2)) {
            String[] strArr2 = {Build.CPU_ABI, Build.CPU_ABI2};
            AppMethodBeat.o(236788);
            return strArr2;
        } else {
            String[] strArr3 = {Build.CPU_ABI};
            AppMethodBeat.o(236788);
            return strArr3;
        }
    }
}
