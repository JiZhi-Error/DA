package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class ar extends MAutoStorage<aq> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(aq.kLR, "LaunchWxaAppPBTable")};

    static {
        AppMethodBeat.i(146072);
        AppMethodBeat.o(146072);
    }

    public ar(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, aq.kLR, "LaunchWxaAppPBTable", aq.INDEX_CREATE);
    }

    public final boolean b(String str, che che) {
        AppMethodBeat.i(146071);
        if (TextUtils.isEmpty(str) || che == null) {
            AppMethodBeat.o(146071);
            return false;
        }
        aq aqVar = new aq();
        aqVar.field_appId = str;
        aqVar.field_launchPB = che;
        boolean replace = super.replace(aqVar);
        AppMethodBeat.o(146071);
        return replace;
    }
}
