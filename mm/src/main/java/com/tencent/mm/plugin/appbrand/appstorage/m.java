package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m {
    OK,
    ERR_OP_FAIL,
    ERR_FS_NOT_MOUNTED,
    ERR_PARENT_DIR_NOT_EXISTS,
    ERR_PERMISSION_DENIED,
    RET_ALREADY_EXISTS,
    RET_NOT_EXISTS,
    ERR_DIR_NOT_EMPTY,
    ERR_IS_FILE,
    ERR_IS_DIRECTORY,
    ERR_SYMLINK,
    ERR_ILLEGAL_READ_POSITION,
    ERR_ILLEGAL_READ_LENGTH,
    ERR_BAD_ZIP_FILE,
    ERR_WRITE_ZIP_ENTRY,
    ERR_EXCEED_DIRECTORY_MAX_SIZE,
    ERR_NOT_SUPPORTED;

    public static m valueOf(String str) {
        AppMethodBeat.i(140589);
        m mVar = (m) Enum.valueOf(m.class, str);
        AppMethodBeat.o(140589);
        return mVar;
    }

    static {
        AppMethodBeat.i(140590);
        AppMethodBeat.o(140590);
    }
}
