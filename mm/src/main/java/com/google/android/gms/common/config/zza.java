package com.google.android.gms.common.config;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza extends GservicesValue<Boolean> {
    zza(String str, Boolean bool) {
        super(str, bool);
    }

    private static Boolean zza(Context context, String str, Boolean bool) {
        AppMethodBeat.i(4558);
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, null);
        if (string != null) {
            try {
                bool = Boolean.valueOf(Boolean.parseBoolean(string));
                AppMethodBeat.o(4558);
            } catch (NumberFormatException e2) {
            }
            return bool;
        }
        AppMethodBeat.o(4558);
        return bool;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ Boolean retrieve(String str) {
        AppMethodBeat.i(4560);
        Boolean zza = GservicesValue.zzch().zza(this.mKey, (Boolean) this.mDefaultValue);
        AppMethodBeat.o(4560);
        return zza;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ Boolean retrieveFromDirectBootCache(Context context, String str, Boolean bool) {
        AppMethodBeat.i(4559);
        Boolean zza = zza(context, str, bool);
        AppMethodBeat.o(4559);
        return zza;
    }
}
