package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public byte cFps;
    public byte cIPeriod;
    public byte cIReqFlag;
    public byte cResolution;
    public byte cRsvd1;
    public byte cSkipFlag;
    public short iKbps;
    public byte qrE;
    public byte qrF;
    public byte[] s2p = new byte[10];

    public a() {
        AppMethodBeat.i(90788);
        AppMethodBeat.o(90788);
    }
}
