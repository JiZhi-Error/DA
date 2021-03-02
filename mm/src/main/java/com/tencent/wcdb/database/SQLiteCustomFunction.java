package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class SQLiteCustomFunction {
    public final SQLiteDatabase.CustomFunction callback;
    public final String name;
    public final int numArgs;

    public SQLiteCustomFunction(String str, int i2, SQLiteDatabase.CustomFunction customFunction) {
        AppMethodBeat.i(3104);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("name must not be null.");
            AppMethodBeat.o(3104);
            throw illegalArgumentException;
        }
        this.name = str;
        this.numArgs = i2;
        this.callback = customFunction;
        AppMethodBeat.o(3104);
    }

    private void dispatchCallback(String[] strArr) {
        AppMethodBeat.i(3105);
        this.callback.callback(strArr);
        AppMethodBeat.o(3105);
    }
}
