package com.google.android.gms.common.images.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.images.internal.CrossFadingDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb extends Drawable.ConstantState {
    private zzb() {
    }

    public final int getChangingConfigurations() {
        return 0;
    }

    public final Drawable newDrawable() {
        AppMethodBeat.i(11789);
        CrossFadingDrawable.zza zza = CrossFadingDrawable.zza.zzqj;
        AppMethodBeat.o(11789);
        return zza;
    }
}
