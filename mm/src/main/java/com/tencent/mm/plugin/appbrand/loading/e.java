package com.tencent.mm.plugin.appbrand.loading;

import android.content.Context;
import android.content.Intent;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "", "ctx", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "statObject", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "getCtx", "()Landroid/content/Context;", "setCtx", "(Landroid/content/Context;)V", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "getStatObject", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
public final class e {
    Context ctx;
    public final AppBrandStatObject cyA;
    public Intent intent;
    public final AppBrandInitConfigWC kEG;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (kotlin.g.b.p.j(r3.cyA, r4.cyA) != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 50844(0xc69c, float:7.1248E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0036
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.loading.e
            if (r0 == 0) goto L_0x003b
            com.tencent.mm.plugin.appbrand.loading.e r4 = (com.tencent.mm.plugin.appbrand.loading.e) r4
            android.content.Context r0 = r3.ctx
            android.content.Context r1 = r4.ctx
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
            android.content.Intent r0 = r3.intent
            android.content.Intent r1 = r4.intent
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
            com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC r0 = r3.kEG
            com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC r1 = r4.kEG
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
            com.tencent.mm.plugin.appbrand.report.AppBrandStatObject r0 = r3.cyA
            com.tencent.mm.plugin.appbrand.report.AppBrandStatObject r1 = r4.cyA
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
        L_0x0036:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x003a:
            return r0
        L_0x003b:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.loading.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(50843);
        Context context = this.ctx;
        int hashCode = (context != null ? context.hashCode() : 0) * 31;
        Intent intent2 = this.intent;
        int hashCode2 = ((intent2 != null ? intent2.hashCode() : 0) + hashCode) * 31;
        AppBrandInitConfigWC appBrandInitConfigWC = this.kEG;
        int hashCode3 = ((appBrandInitConfigWC != null ? appBrandInitConfigWC.hashCode() : 0) + hashCode2) * 31;
        AppBrandStatObject appBrandStatObject = this.cyA;
        if (appBrandStatObject != null) {
            i2 = appBrandStatObject.hashCode();
        }
        int i3 = hashCode3 + i2;
        AppMethodBeat.o(50843);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(50842);
        String str = "PendingIntentTask(ctx=" + this.ctx + ", intent=" + this.intent + ", initConfig=" + this.kEG + ", statObject=" + this.cyA + ")";
        AppMethodBeat.o(50842);
        return str;
    }

    public e(Context context, Intent intent2, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        p.h(context, "ctx");
        p.h(intent2, "intent");
        p.h(appBrandInitConfigWC, "initConfig");
        p.h(appBrandStatObject, "statObject");
        AppMethodBeat.i(50841);
        this.ctx = context;
        this.intent = intent2;
        this.kEG = appBrandInitConfigWC;
        this.cyA = appBrandStatObject;
        AppMethodBeat.o(50841);
    }
}
