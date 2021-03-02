package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class g extends a {
    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void prepare() {
        AppMethodBeat.i(64404);
        if (((a) com.tencent.mm.kernel.g.af(a.class)) == null) {
            c cVar = new c();
            cVar.a(this);
            com.tencent.mm.kernel.g.b(a.class, cVar);
        }
        if (ae.gKz.edB && b.flW()) {
            Log.i("MicroMsg.DummyBiometricPayManager", "maybe soter init fail, reinit");
            h.INSTANCE.dN(1104, 42);
            b.a(true, new com.tencent.mm.plugin.soter.d.g() {
                /* class com.tencent.mm.plugin.fingerprint.b.a.g.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.soter.d.g
                public final void bg(int i2, String str) {
                    AppMethodBeat.i(64403);
                    if (com.tencent.soter.a.a.hlC()) {
                        Log.i("MicroMsg.DummyBiometricPayManager", "init success: %s", Integer.valueOf(i2));
                        j jVar = new j();
                        jVar.prepare();
                        com.tencent.mm.kernel.g.b(i.class, jVar);
                        AppMethodBeat.o(64403);
                        return;
                    }
                    Log.i("MicroMsg.DummyBiometricPayManager", "init failed: %s, %s", Integer.valueOf(i2), str);
                    h.INSTANCE.dN(1104, 43);
                    AppMethodBeat.o(64403);
                }
            });
        }
        AppMethodBeat.o(64404);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final Map<String, String> dJY() {
        return null;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKp() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKq() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean fN(Context context) {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean fO(Context context) {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKr() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKs() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKt() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dJQ() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final int dKu() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void a(Context context, f fVar, b bVar) {
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void b(Context context, f fVar, b bVar) {
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void a(boolean z, boolean z2, boolean z3, Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void cancel() {
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final d dKv() {
        return null;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void a(Context context, f fVar, d dVar) {
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKw() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void q(Object... objArr) {
    }
}
