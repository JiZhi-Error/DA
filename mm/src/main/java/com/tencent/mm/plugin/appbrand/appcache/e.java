package com.tencent.mm.plugin.appbrand.appcache;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e {
    private static final SparseIntArray kKh;

    static {
        AppMethodBeat.i(44236);
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        kKh = sparseIntArray;
        sparseIntArray.put(0, R.string.ty);
        kKh.put(1, R.string.id);
        kKh.put(2, R.string.ic);
        AppMethodBeat.o(44236);
    }

    public static String UP(String str) {
        AppMethodBeat.i(44235);
        String Wf = LaunchParcel.Wf(str);
        AppMethodBeat.o(44235);
        return Wf;
    }

    public static String UQ(String str) {
        AppMethodBeat.i(226349);
        String Wf = LaunchParcel.Wf(str);
        if (Wf.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            Wf = Wf.substring(0, Wf.length() - 1);
        }
        AppMethodBeat.o(226349);
        return Wf;
    }

    public static String vO(int i2) {
        AppMethodBeat.i(44234);
        String string = MMApplicationContext.getResources().getString(kKh.get(i2, R.string.ty));
        AppMethodBeat.o(44234);
        return string;
    }
}
