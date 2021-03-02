package com.tencent.mm.plugin.flutter.model;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements a, k.c {
    private Context context;
    private k wJr;

    @Override // io.flutter.plugin.a.k.c
    public final void a(j jVar, k.d dVar) {
        AppMethodBeat.i(148873);
        if (jVar.method.equals("getDisplayParams")) {
            JSONObject jSONObject = new JSONObject();
            try {
                DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
                Point az = ao.az(this.context);
                jSONObject.put("screenWidth", az.x);
                jSONObject.put("screenHeight", az.y);
                jSONObject.put("densityDpi", displayMetrics.densityDpi);
                jSONObject.put(Constants.PARAM_DENSITY, (double) displayMetrics.density);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.Flutter.FlutterLvCppHandler", e2, "", new Object[0]);
            }
            dVar.ba(jSONObject.toString());
            AppMethodBeat.o(148873);
            return;
        }
        dVar.dLv();
        AppMethodBeat.o(148873);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(240946);
        Log.i("MicroMsg.Flutter.FlutterLvCppHandler", "onAttachedToEngine FlutterLvCppHandler CHANNEL%s", "com.tencent.mm.mmflutter.lvcppmethod");
        this.wJr = new k(bVar.SOH, "com.tencent.mm.mmflutter.lvcppmethod");
        this.wJr.a(this);
        this.context = bVar.applicationContext;
        AppMethodBeat.o(240946);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(240947);
        this.wJr.a(null);
        AppMethodBeat.o(240947);
    }
}
