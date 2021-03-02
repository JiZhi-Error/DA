package com.google.android.gms.common.config;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzc extends GservicesValue<Integer> {
    zzc(String str, Integer num) {
        super(str, num);
    }

    private static Integer zza(Context context, String str, Integer num) {
        AppMethodBeat.i(4564);
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, null);
        if (string != null) {
            try {
                num = Integer.valueOf(Integer.parseInt(string));
                AppMethodBeat.o(4564);
            } catch (NumberFormatException e2) {
            }
            return num;
        }
        AppMethodBeat.o(4564);
        return num;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ Integer retrieve(String str) {
        AppMethodBeat.i(4566);
        Integer zza = GservicesValue.zzch().zza(this.mKey, (Integer) this.mDefaultValue);
        AppMethodBeat.o(4566);
        return zza;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ Integer retrieveFromDirectBootCache(Context context, String str, Integer num) {
        AppMethodBeat.i(4565);
        Integer zza = zza(context, str, num);
        AppMethodBeat.o(4565);
        return zza;
    }
}
