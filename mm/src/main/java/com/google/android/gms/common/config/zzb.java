package com.google.android.gms.common.config;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb extends GservicesValue<Long> {
    zzb(String str, Long l) {
        super(str, l);
    }

    private static Long zza(Context context, String str, Long l) {
        AppMethodBeat.i(4561);
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, null);
        if (string != null) {
            try {
                l = Long.valueOf(Long.parseLong(string));
                AppMethodBeat.o(4561);
            } catch (NumberFormatException e2) {
            }
            return l;
        }
        AppMethodBeat.o(4561);
        return l;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ Long retrieve(String str) {
        AppMethodBeat.i(4563);
        Long l = GservicesValue.zzch().getLong(this.mKey, (Long) this.mDefaultValue);
        AppMethodBeat.o(4563);
        return l;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ Long retrieveFromDirectBootCache(Context context, String str, Long l) {
        AppMethodBeat.i(4562);
        Long zza = zza(context, str, l);
        AppMethodBeat.o(4562);
        return zza;
    }
}
