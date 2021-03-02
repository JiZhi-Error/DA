package com.tencent.luggage.sdk.g;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0007\u001a\u00020\u0004*\u00020\u0001H\u0007J\u0014\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/luggage/sdk/wxa_ktx/ActivityUtils;", "", "()V", "REQUEST_CODE_LOW_BITS_MAGIC_NUM", "", "TAG", "", "hashCodeAsRequestCode", "safeRequestWindowFeature", "", "Landroid/app/Activity;", "feature", "luggage-wxa-app_release"})
public final class a {
    public static final a cCG = new a();

    static {
        AppMethodBeat.i(176450);
        AppMethodBeat.o(176450);
    }

    private a() {
    }

    public static final int aK(Object obj) {
        AppMethodBeat.i(176449);
        p.h(obj, "$this$hashCodeAsRequestCode");
        int hashCode = obj.hashCode() & 65535;
        AppMethodBeat.o(176449);
        return hashCode;
    }

    public static final boolean b(Activity activity, int i2) {
        AppMethodBeat.i(177599);
        p.h(activity, "$this$safeRequestWindowFeature");
        boolean supportRequestWindowFeature = ((AppCompatActivity) activity).supportRequestWindowFeature(i2);
        AppMethodBeat.o(177599);
        return supportRequestWindowFeature;
    }
}
