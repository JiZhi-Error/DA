package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bv;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public final class c extends bv {
    public static IAutoDBItem.MAutoDBInfo info = bv.ajs();

    static {
        AppMethodBeat.i(103362);
        AppMethodBeat.o(103362);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final boolean cUr() {
        if (this.field_dataType == 4) {
            return true;
        }
        return false;
    }

    public final boolean isFinished() {
        return this.field_status == 3;
    }

    public final float getProgress() {
        AppMethodBeat.i(103361);
        float max = Math.max(0.0f, Math.min(99.0f, ((float) this.field_offset) / ((float) this.field_totalLen)) * 100.0f);
        AppMethodBeat.o(103361);
        return max;
    }
}
