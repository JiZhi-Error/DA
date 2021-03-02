package com.tencent.mm.opensdk.diffdev;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        AppMethodBeat.i(3743);
        IDiffDevOAuth diffDevOAuth = getDiffDevOAuth(1);
        AppMethodBeat.o(3743);
        return diffDevOAuth;
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i2) {
        AppMethodBeat.i(3744);
        Log.v(TAG, "getDiffDevOAuth, version = ".concat(String.valueOf(i2)));
        if (i2 > 1) {
            Log.e(TAG, "getDiffDevOAuth fail, unsupported version = ".concat(String.valueOf(i2)));
            AppMethodBeat.o(3744);
            return null;
        } else if (i2 != 1) {
            AppMethodBeat.o(3744);
            return null;
        } else {
            if (v1Instance == null) {
                v1Instance = new a();
            }
            IDiffDevOAuth iDiffDevOAuth = v1Instance;
            AppMethodBeat.o(3744);
            return iDiffDevOAuth;
        }
    }
}
