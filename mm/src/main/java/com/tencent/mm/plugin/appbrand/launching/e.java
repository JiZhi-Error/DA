package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import android.widget.Toast;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.plugin.appbrand.config.ac;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class e implements Runnable {
    protected volatile String appId;
    final AppBrandLaunchReferrer cys;
    protected final int iOo;
    protected AppBrandStatObject kEH;
    protected final String kHw;
    private final a mQB;
    protected final ActivityStarterIpcDelegate mQC;
    protected final int pkgVersion;
    protected volatile String username;

    public interface a<T extends AppBrandInitConfigLU> {
        void a(T t, AppBrandStatObject appBrandStatObject, int i2);
    }

    public e(LaunchParcel launchParcel, a aVar) {
        this.mQB = aVar;
        this.iOo = launchParcel.iOo;
        this.appId = launchParcel.appId;
        this.username = launchParcel.username;
        this.pkgVersion = launchParcel.version;
        this.kEH = launchParcel.mYK;
        this.kHw = launchParcel.kHw;
        this.mQC = launchParcel.mQC;
        this.cys = launchParcel.cys;
    }

    public void run() {
        AppMethodBeat.i(147308);
        WxaAttributes wxaAttributes = (WxaAttributes) bNg().first;
        if (wxaAttributes == null) {
            Log.i("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
            onError();
            AppMethodBeat.o(147308);
        } else if (g(wxaAttributes)) {
            onError();
            AppMethodBeat.o(147308);
        } else {
            AppBrandInitConfigLU a2 = b.Nw().a(wxaAttributes);
            if (a2 == null) {
                Log.e("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr, assembled NULL config with username(%s) appId(%s)", wxaAttributes.field_username, wxaAttributes.field_appId);
                onError();
                AppMethodBeat.o(147308);
                return;
            }
            a2.eix = this.iOo;
            this.appId = a2.appId;
            this.username = a2.username;
            if (this.iOo == 0) {
                a2.cBG = wxaAttributes.bAp().lgT;
            } else {
                s.bNx();
                a2.extInfo = s.bU(this.appId, this.iOo);
                try {
                    JSONObject FE = h.FE(a2.extInfo);
                    a2.cBG = FE.optString("device_orientation");
                    a2.cyp = FE.optBoolean("open_remote", false);
                    a2.cyv = ac.XM(a2.extInfo);
                } catch (Exception e2) {
                }
            }
            if (this.kEH == null) {
                this.kEH = new AppBrandStatObject();
            }
            a(a2, this.kEH);
            AppMethodBeat.o(147308);
        }
    }

    /* access modifiers changed from: protected */
    public Pair<WxaAttributes, Boolean> bNg() {
        AppMethodBeat.i(147309);
        ab.bAu();
        Pair<WxaAttributes, Boolean> pair = new Pair<>(ab.e(this.appId, new String[0]), Boolean.FALSE);
        AppMethodBeat.o(147309);
        return pair;
    }

    /* access modifiers changed from: protected */
    public boolean g(WxaAttributes wxaAttributes) {
        AppMethodBeat.i(147311);
        if (!j.a.vP(this.iOo) || 1 != wxaAttributes.bAp().cyu) {
            AppMethodBeat.o(147311);
            return false;
        }
        Toast.makeText(MMApplicationContext.getContext(), (int) R.string.ne, 1).show();
        AppMethodBeat.o(147311);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onError() {
        AppMethodBeat.i(147312);
        if (this.mQB != null) {
            this.mQB.a(null, null, 2);
        }
        AppMethodBeat.o(147312);
    }

    /* access modifiers changed from: protected */
    public final void a(AppBrandInitConfigLU appBrandInitConfigLU, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(147313);
        if (this.mQB != null) {
            this.mQB.a(appBrandInitConfigLU, appBrandStatObject, 1);
        }
        AppMethodBeat.o(147313);
    }
}
