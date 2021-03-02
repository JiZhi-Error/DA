package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.b;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        AppMethodBeat.i(7637);
        this.uri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + str, bundle == null ? new Bundle() : bundle);
        AppMethodBeat.o(7637);
    }

    public void openCustomTab(Activity activity, String str) {
        AppMethodBeat.i(7638);
        b.a aVar = new b.a();
        if (aVar.gw != null) {
            aVar.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", aVar.gw);
        }
        if (aVar.gy != null) {
            aVar.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", aVar.gy);
        }
        aVar.mIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", aVar.gz);
        b bVar = new b(aVar.mIntent, aVar.gx, (byte) 0);
        bVar.intent.setPackage(str);
        bVar.intent.addFlags(1073741824);
        bVar.intent.setData(this.uri);
        android.support.v4.content.b.startActivity(activity, bVar.intent, bVar.gv);
        AppMethodBeat.o(7638);
    }
}
