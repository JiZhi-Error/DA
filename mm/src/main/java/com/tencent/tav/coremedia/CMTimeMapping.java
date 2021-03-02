package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CMTimeMapping {
    private CMTimeRange source;
    private CMTimeRange target;

    public CMTimeMapping(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        AppMethodBeat.i(199437);
        this.source = cMTimeRange.clone();
        this.target = cMTimeRange2.clone();
        AppMethodBeat.o(199437);
    }

    public CMTimeRange getSource() {
        return this.source;
    }

    public void setSource(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(199438);
        this.source = cMTimeRange.clone();
        AppMethodBeat.o(199438);
    }

    public CMTimeRange getTarget() {
        return this.target;
    }

    public void setTarget(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(199439);
        this.target = cMTimeRange.clone();
        AppMethodBeat.o(199439);
    }

    public String toString() {
        AppMethodBeat.i(199440);
        String str = "CMTimeMapping{source=" + this.source.toSimpleString() + ", target=" + this.target.toSimpleString() + '}';
        AppMethodBeat.o(199440);
        return str;
    }
}
