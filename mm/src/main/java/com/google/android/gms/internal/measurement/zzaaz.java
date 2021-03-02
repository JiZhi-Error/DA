package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzaaz extends zzaay<FieldDescriptorType, Object> {
    zzaaz(int i2) {
        super(i2, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzaay
    public final void zzrg() {
        AppMethodBeat.i(40178);
        if (!isImmutable()) {
            for (int i2 = 0; i2 < zzuj(); i2++) {
                Map.Entry zzah = zzah(i2);
                if (((zzzo) zzah.getKey()).zztk()) {
                    zzah.setValue(Collections.unmodifiableList((List) zzah.getValue()));
                }
            }
            for (Map.Entry entry : zzuk()) {
                if (((zzzo) entry.getKey()).zztk()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzrg();
        AppMethodBeat.o(40178);
    }
}
