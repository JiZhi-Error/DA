package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Locale;

final class AppBrandLaunchErrorActionStartActivity extends AppBrandLaunchErrorAction {
    final String mQk;
    final String mQl;
    final Intent mQm;

    AppBrandLaunchErrorActionStartActivity(String str, int i2, String str2, String str3, Intent intent) {
        super(str, i2);
        this.mQk = str2;
        this.mQl = str3;
        this.mQm = intent;
    }

    @Keep
    AppBrandLaunchErrorActionStartActivity(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(47047);
        this.mQk = parcel.readString();
        this.mQl = parcel.readString();
        this.mQm = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        AppMethodBeat.o(47047);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(47048);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.mQk);
        parcel.writeString(this.mQl);
        parcel.writeParcelable(this.mQm, 0);
        AppMethodBeat.o(47048);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction
    public final void ae(Context context, String str) {
        AppMethodBeat.i(227050);
        Log.i("MicroMsg.AppBrandLaunchErrorAction", "showError(%s) startActivity %s -> %s", str, context.getClass().getName(), this.mQl);
        Intent intent = this.mQm;
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        } else {
            intent.setFlags(intent.getFlags() & -268435457);
        }
        c.b(context, this.mQk, this.mQl, intent);
        AppMethodBeat.o(227050);
    }

    public final String toString() {
        AppMethodBeat.i(174927);
        String format = String.format(Locale.ENGLISH, "AppBrandLaunchErrorActionStartActivity[%s.%s|%s]", this.mQk, this.mQl, this.mQm);
        AppMethodBeat.o(174927);
        return format;
    }
}
