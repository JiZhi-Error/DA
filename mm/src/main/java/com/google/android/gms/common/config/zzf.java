package com.google.android.gms.common.config;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzf extends GservicesValue<String> {
    zzf(String str, String str2) {
        super(str, str2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ String retrieve(String str) {
        AppMethodBeat.i(4574);
        String string = GservicesValue.zzch().getString(this.mKey, (String) this.mDefaultValue);
        AppMethodBeat.o(4574);
        return string;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ String retrieveFromDirectBootCache(Context context, String str, String str2) {
        AppMethodBeat.i(4573);
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, str2);
        AppMethodBeat.o(4573);
        return string;
    }
}
