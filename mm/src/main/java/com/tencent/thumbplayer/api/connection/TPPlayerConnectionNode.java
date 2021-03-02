package com.tencent.thumbplayer.api.connection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b.b.b;
import com.tencent.thumbplayer.api.connection.TPPlayerConnectionConstant;
import com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionNode;

public class TPPlayerConnectionNode {
    private TPNativePlayerConnectionNode nativeNode = new TPNativePlayerConnectionNode();

    public TPPlayerConnectionNode() {
        AppMethodBeat.i(189081);
        AppMethodBeat.o(189081);
    }

    public boolean addAction(@TPPlayerConnectionConstant.Action int i2) {
        AppMethodBeat.i(189082);
        boolean addAction = this.nativeNode.addAction(b.arj(i2));
        AppMethodBeat.o(189082);
        return addAction;
    }

    public void removeAction(@TPPlayerConnectionConstant.Action int i2) {
        AppMethodBeat.i(189083);
        this.nativeNode.removeAction(b.arj(i2));
        AppMethodBeat.o(189083);
    }

    public boolean setLongActionConfig(@TPPlayerConnectionConstant.Action int i2, int i3, long j2) {
        AppMethodBeat.i(189084);
        boolean longActionConfig = this.nativeNode.setLongActionConfig(b.arj(i2), b.ark(i3), j2);
        AppMethodBeat.o(189084);
        return longActionConfig;
    }

    public TPNativePlayerConnectionNode getNativeNode() {
        return this.nativeNode;
    }
}
