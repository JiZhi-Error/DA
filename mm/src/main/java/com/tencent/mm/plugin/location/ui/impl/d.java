package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.k.a;
import com.tencent.mm.plugin.k.c;
import com.tencent.mm.plugin.location_soso.SoSoProxyUI;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.Log;

public final class d implements c {
    public static Intent ar(Activity activity) {
        AppMethodBeat.i(56077);
        Intent intent = new Intent(activity, SoSoProxyUI.class);
        AppMethodBeat.o(56077);
        return intent;
    }

    public static View gs(Context context) {
        AppMethodBeat.i(56078);
        SoSoMapView soSoMapView = new SoSoMapView(context);
        soSoMapView.setId(R.id.dch);
        AppMethodBeat.o(56078);
        return soSoMapView;
    }

    @Override // com.tencent.mm.plugin.k.c
    public final a h(Activity activity, int i2) {
        a hVar;
        AppMethodBeat.i(56079);
        switch (i2) {
            case 2:
                Log.i("MicroMsg.MapFactoryImp", "poi map");
                hVar = new c(activity);
                break;
            case 3:
            default:
                AppMethodBeat.o(56079);
                return null;
            case 4:
                Log.i("MicroMsg.MapFactoryImp", "track map");
                hVar = new j(activity);
                break;
            case 5:
                Log.i("MicroMsg.MapFactoryImp", "share map");
                hVar = new h(activity);
                break;
        }
        AppMethodBeat.o(56079);
        return hVar;
    }
}
