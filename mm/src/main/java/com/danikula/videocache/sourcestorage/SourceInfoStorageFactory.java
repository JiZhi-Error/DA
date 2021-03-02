package com.danikula.videocache.sourcestorage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SourceInfoStorageFactory {
    public static SourceInfoStorage newSourceInfoStorage(Context context) {
        AppMethodBeat.i(223219);
        DatabaseSourceInfoStorage databaseSourceInfoStorage = new DatabaseSourceInfoStorage(context);
        AppMethodBeat.o(223219);
        return databaseSourceInfoStorage;
    }

    public static SourceInfoStorage newEmptySourceInfoStorage() {
        AppMethodBeat.i(223220);
        NoSourceInfoStorage noSourceInfoStorage = new NoSourceInfoStorage();
        AppMethodBeat.o(223220);
        return noSourceInfoStorage;
    }
}
