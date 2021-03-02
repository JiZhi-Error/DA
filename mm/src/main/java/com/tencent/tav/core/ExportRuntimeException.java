package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExportRuntimeException extends RuntimeException {
    private final ExportErrorStatus errorStatus;

    public ExportRuntimeException(int i2, Throwable th) {
        this(new ExportErrorStatus(i2, th));
        AppMethodBeat.i(217907);
        AppMethodBeat.o(217907);
    }

    public ExportRuntimeException(ExportErrorStatus exportErrorStatus) {
        super(exportErrorStatus.throwable);
        this.errorStatus = exportErrorStatus;
    }

    public ExportErrorStatus getErrorStatus() {
        return this.errorStatus;
    }
}
