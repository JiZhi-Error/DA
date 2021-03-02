package com.tencent.wxmm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class v2stqos {
    private static final String TAG = "WXMM.Voip[stqos]";
    public byte cFps;
    public byte cHPPMaxLyr;
    public byte cIPeriod;
    public byte cIReqFlag;
    public byte cQPmax;
    public byte cQPmin;
    public byte cRSLevel;
    public byte cResolution;
    public byte cRsvd1;
    public byte cRsvd2;
    public byte cSkipFlag;
    public byte cSwitch;
    public short iKbps;
    public byte[] s2p = new byte[14];

    public v2stqos() {
        AppMethodBeat.i(40807);
        AppMethodBeat.o(40807);
    }

    public void parseS2PData() {
        AppMethodBeat.i(40808);
        ByteBuffer wrap = ByteBuffer.wrap(this.s2p);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.iKbps = wrap.getShort();
        this.cFps = wrap.get();
        this.cIPeriod = wrap.get();
        this.cRSLevel = wrap.get();
        this.cQPmin = wrap.get();
        this.cQPmax = wrap.get();
        this.cHPPMaxLyr = wrap.get();
        this.cSwitch = wrap.get();
        this.cResolution = wrap.get();
        this.cRsvd1 = wrap.get();
        this.cRsvd2 = wrap.get();
        this.cSkipFlag = wrap.get();
        this.cIReqFlag = wrap.get();
        AppMethodBeat.o(40808);
    }

    public void printS2P() {
        AppMethodBeat.i(40809);
        new StringBuilder("raw S2P:").append(this.s2p);
        new StringBuilder("-S2P- iKbps:").append((int) this.iKbps).append(", fps:").append((int) this.cFps).append(", IP:").append((int) this.cIPeriod).append(", RS:").append((int) this.cRSLevel).append(", QPMin:").append((int) this.cQPmin).append(", QPMax:").append((int) this.cQPmax).append(", HPP:").append((int) this.cHPPMaxLyr).append(", SWitch:").append((int) this.cSwitch).append(", Reso:").append((int) this.cResolution).append(", Rsvd1:").append((int) this.cRsvd1).append(", Rsvd2:").append((int) this.cRsvd2).append(", Skip:").append((int) this.cSkipFlag).append(", IReq:").append((int) this.cIReqFlag);
        AppMethodBeat.o(40809);
    }
}
