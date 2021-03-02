package com.tencent.mm.plugin.appbrand.permission;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public class l implements j {
    protected final AppBrandRuntime kEc;

    public l(AppBrandRuntime appBrandRuntime) {
        this.kEc = appBrandRuntime;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.j
    public void aep(String str) {
        AppMethodBeat.i(147661);
        Toast.makeText(AndroidContextUtil.castActivityOrNull(this.kEc.mContext), String.format("jsapi banned %s", str), 0).show();
        AppMethodBeat.o(147661);
    }
}
