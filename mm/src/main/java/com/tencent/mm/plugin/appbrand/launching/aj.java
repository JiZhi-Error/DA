package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPreconditionTaskGetBackupWxaAttrs;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchPreconditionTaskGetWxaAttrs;", ch.COL_USERNAME, "", "appId", "(Ljava/lang/String;Ljava/lang/String;)V", "_executeCostMs", "", "_executeEndMs", "_executeStartMs", "callSync", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "executeCostMs", "executeEndMs", "executeStartMs", "name", "plugin-appbrand-integration_release"})
public final class aj implements ak {
    private final String appId;
    private long mVC;
    private long mVD;
    private long mVE;
    private final String username;

    public aj(String str, String str2) {
        this.username = str;
        this.appId = str2;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ak
    public final long bNF() {
        return this.mVC;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ak
    public final long bNG() {
        return this.mVD;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ak
    public final long bNH() {
        return this.mVE;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ak
    public final String name() {
        return "LaunchPreconditionTaskGetBackupWxaAttrs";
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ak
    public final Pair<WxaAttributes, Boolean> bNI() {
        WxaAttributes d2;
        AppMethodBeat.i(228694);
        this.mVC = Util.nowMilliSecond();
        String str = this.appId;
        if (!(str == null || str.length() == 0)) {
            d2 = ((v) n.W(v.class)).e(this.appId, new String[0]);
        } else {
            v vVar = (v) n.W(v.class);
            String str2 = this.username;
            if (str2 == null) {
                p.hyc();
            }
            d2 = vVar.d(str2, new String[0]);
        }
        Pair<WxaAttributes, Boolean> create = Pair.create(d2, Boolean.FALSE);
        p.g(create, "Pair.create(attrs, false)");
        this.mVD = Util.nowMilliSecond();
        this.mVE = this.mVD - this.mVC;
        AppMethodBeat.o(228694);
        return create;
    }
}
