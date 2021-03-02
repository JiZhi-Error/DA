package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookException extends RuntimeException {
    static final long serialVersionUID = 1;

    public FacebookException() {
    }

    public FacebookException(String str) {
        super(str);
    }

    public FacebookException(String str, Object... objArr) {
        this(String.format(str, objArr));
        AppMethodBeat.i(17015);
        AppMethodBeat.o(17015);
    }

    public FacebookException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookException(Throwable th) {
        super(th);
    }

    public String toString() {
        AppMethodBeat.i(17016);
        String message = getMessage();
        AppMethodBeat.o(17016);
        return message;
    }
}
