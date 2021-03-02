package com.tencent.mm.pluginsdk.d.a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public static final String[] JTp = {"retCode", "url"};

    public static MatrixCursor ahx(int i2) {
        AppMethodBeat.i(30931);
        Log.i("MicroMsg.ExtCommonUtils", "returnMatrix = ".concat(String.valueOf(i2)));
        MatrixCursor matrixCursor = new MatrixCursor(com.tencent.mm.plugin.ext.b.a.sMy);
        matrixCursor.addRow(new Object[]{Integer.valueOf(i2)});
        AppMethodBeat.o(30931);
        return matrixCursor;
    }

    public static MatrixCursor bdj(String str) {
        AppMethodBeat.i(30932);
        Log.i("MicroMsg.ExtCommonUtils", "returnMatrix = 4207");
        MatrixCursor matrixCursor = new MatrixCursor(JTp);
        matrixCursor.addRow(new Object[]{4207, str});
        AppMethodBeat.o(30932);
        return matrixCursor;
    }
}
