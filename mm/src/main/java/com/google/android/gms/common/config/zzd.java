package com.google.android.gms.common.config;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd extends GservicesValue<Double> {
    zzd(String str, Double d2) {
        super(str, d2);
    }

    private static Double zza(Context context, String str, Double d2) {
        AppMethodBeat.i(4567);
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, null);
        if (string != null) {
            try {
                d2 = Double.valueOf(Double.parseDouble(string));
                AppMethodBeat.o(4567);
            } catch (NumberFormatException e2) {
            }
            return d2;
        }
        AppMethodBeat.o(4567);
        return d2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ Double retrieve(String str) {
        AppMethodBeat.i(4569);
        Double zza = GservicesValue.zzch().zza(this.mKey, (Double) this.mDefaultValue);
        AppMethodBeat.o(4569);
        return zza;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ Double retrieveFromDirectBootCache(Context context, String str, Double d2) {
        AppMethodBeat.i(4568);
        Double zza = zza(context, str, d2);
        AppMethodBeat.o(4568);
        return zza;
    }
}
