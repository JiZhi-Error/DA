package com.google.android.gms.common.config;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zze extends GservicesValue<Float> {
    zze(String str, Float f2) {
        super(str, f2);
    }

    private static Float zza(Context context, String str, Float f2) {
        AppMethodBeat.i(4570);
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, null);
        if (string != null) {
            try {
                f2 = Float.valueOf(Float.parseFloat(string));
                AppMethodBeat.o(4570);
            } catch (NumberFormatException e2) {
            }
            return f2;
        }
        AppMethodBeat.o(4570);
        return f2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ Float retrieve(String str) {
        AppMethodBeat.i(4572);
        Float zza = GservicesValue.zzch().zza(this.mKey, (Float) this.mDefaultValue);
        AppMethodBeat.o(4572);
        return zza;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ Float retrieveFromDirectBootCache(Context context, String str, Float f2) {
        AppMethodBeat.i(4571);
        Float zza = zza(context, str, f2);
        AppMethodBeat.o(4571);
        return zza;
    }
}
