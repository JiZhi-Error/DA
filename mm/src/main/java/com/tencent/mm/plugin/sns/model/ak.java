package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.k.b;

public final class ak implements ai {
    private b DMa;
    private int scene;

    public ak() {
        this.scene = 0;
        this.scene = 2;
    }

    @Override // com.tencent.mm.plugin.sns.model.ai
    public final int getScene() {
        return this.scene;
    }

    @Override // com.tencent.mm.plugin.sns.model.ai
    public final b fat() {
        AppMethodBeat.i(95844);
        if (this.DMa == null) {
            this.DMa = new b();
        }
        b bVar = this.DMa;
        AppMethodBeat.o(95844);
        return bVar;
    }
}
