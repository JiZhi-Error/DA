package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParseException extends Exception {
    public int curline = 0;

    public ParseException(String str, Exception exc, int i2) {
        super(str, exc);
        this.curline = i2;
    }

    public String getMessage() {
        AppMethodBeat.i(76604);
        String str = super.getMessage() + " line: " + this.curline;
        AppMethodBeat.o(76604);
        return str;
    }

    public String toString() {
        AppMethodBeat.i(76605);
        String str = "ParseException{message = " + getMessage() + "}";
        AppMethodBeat.o(76605);
        return str;
    }
}
