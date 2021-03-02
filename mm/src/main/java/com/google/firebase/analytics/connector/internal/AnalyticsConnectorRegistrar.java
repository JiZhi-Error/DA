package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.a;
import com.google.firebase.components.e;
import com.google.firebase.components.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

@Keep
@KeepForSdk
public class AnalyticsConnectorRegistrar implements e {
    @Override // com.google.firebase.components.e
    @Keep
    @SuppressLint({"MissingPermission"})
    @KeepForSdk
    public List<a<?>> getComponents() {
        AppMethodBeat.i(116770);
        List<a<?>> singletonList = Collections.singletonList(a.z(com.google.firebase.analytics.connector.a.class).a(f.B(com.google.firebase.a.class)).a(f.B(Context.class)).a(a.bKD).xZ());
        AppMethodBeat.o(116770);
        return singletonList;
    }
}
