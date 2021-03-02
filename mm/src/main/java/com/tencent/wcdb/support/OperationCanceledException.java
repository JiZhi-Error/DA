package com.tencent.wcdb.support;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OperationCanceledException(String str) {
        super(str == null ? "The operation has been canceled." : str);
        AppMethodBeat.i(3421);
        AppMethodBeat.o(3421);
    }
}
