package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    String jiO;
    double jiP;
    double latitude;
    double longitude;

    public final String toString() {
        AppMethodBeat.i(150911);
        String str = "gspType:" + this.jiO + " longitude: " + this.longitude + " latitude: " + this.latitude + " distance: " + this.jiP;
        AppMethodBeat.o(150911);
        return str;
    }
}
