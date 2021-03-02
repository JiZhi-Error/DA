package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class yq extends IEvent {
    public a eeU;

    public static final class a {
        public List<cyb> eeV;
        public int packageType = -1;
    }

    public yq() {
        this((byte) 0);
    }

    private yq(byte b2) {
        AppMethodBeat.i(149893);
        this.eeU = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149893);
    }
}
