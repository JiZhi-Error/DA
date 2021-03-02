package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzabh implements zzabi {
    private final /* synthetic */ zzyw zzbui;

    zzabh(zzyw zzyw) {
        this.zzbui = zzyw;
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final int size() {
        AppMethodBeat.i(40201);
        int size = this.zzbui.size();
        AppMethodBeat.o(40201);
        return size;
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final byte zzae(int i2) {
        AppMethodBeat.i(40202);
        byte zzae = this.zzbui.zzae(i2);
        AppMethodBeat.o(40202);
        return zzae;
    }
}
