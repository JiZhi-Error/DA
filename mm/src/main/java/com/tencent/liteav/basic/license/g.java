package com.tencent.liteav.basic.license;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class g implements e {

    /* renamed from: a  reason: collision with root package name */
    private Context f409a;

    public g(Context context) {
        this.f409a = context;
    }

    @Override // com.tencent.liteav.basic.license.e
    public boolean a() {
        AppMethodBeat.i(222179);
        if (this.f409a != null) {
            LicenceCheck.a().a((f) null, this.f409a);
        }
        if (LicenceCheck.a().b() >= 2) {
            AppMethodBeat.o(222179);
            return true;
        }
        AppMethodBeat.o(222179);
        return false;
    }
}
