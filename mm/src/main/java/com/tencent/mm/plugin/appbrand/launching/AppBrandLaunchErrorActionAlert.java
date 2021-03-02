package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import java.util.Locale;

final class AppBrandLaunchErrorActionAlert extends AppBrandLaunchErrorAction {
    final String jxR;
    final String kbW;

    AppBrandLaunchErrorActionAlert(String str, int i2, String str2, String str3) {
        super(str, i2);
        this.jxR = str2;
        this.kbW = str3;
    }

    @Keep
    AppBrandLaunchErrorActionAlert(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(47044);
        this.jxR = parcel.readString();
        this.kbW = parcel.readString();
        AppMethodBeat.o(47044);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(47045);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.jxR);
        parcel.writeString(this.kbW);
        AppMethodBeat.o(47045);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction
    public final void ae(Context context, String str) {
        AppMethodBeat.i(227049);
        String str2 = this.kbW;
        String str3 = this.jxR;
        Log.i("MicroMsg.AppBrandLaunchErrorAction", "showError(%s) alert title:%s, message:%s", str, str3, str2);
        if (!(context instanceof Activity)) {
            a.a(null, str2, str3, MMApplicationContext.getResources().getString(R.string.x_), "", null, null, null);
            AppMethodBeat.o(227049);
            return;
        }
        h.a(context, str2, str3, false, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(227049);
    }

    public final String toString() {
        AppMethodBeat.i(174926);
        String format = String.format(Locale.ENGLISH, "AppBrandLaunchErrorActionAlert[%s %s]", this.jxR, this.kbW);
        AppMethodBeat.o(174926);
        return format;
    }
}
