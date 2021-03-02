package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;

public final class a implements b, f {
    private final HashSet<f.b> kYg = new HashSet<>();
    private final HashSet<f.a> kYh = new HashSet<>();

    public a() {
        AppMethodBeat.i(44765);
        AppMethodBeat.o(44765);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBc() {
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBd() {
        AppMethodBeat.i(44766);
        this.kYg.clear();
        this.kYh.clear();
        AppMethodBeat.o(44766);
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.f
    public final void a(AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel) {
        AppMethodBeat.i(44767);
        Log.i("MicroMsg.AppBrandBackgroundRunningManagerService", "sendOperation from appbrand process, operation:%s", appBrandBackgroundRunningOperationParcel);
        synchronized (this.kYg) {
            try {
                Iterator<f.b> it = this.kYg.iterator();
                while (it.hasNext()) {
                    it.next().b(appBrandBackgroundRunningOperationParcel);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(44767);
                throw th;
            }
        }
        if (appBrandBackgroundRunningOperationParcel.kYo) {
            AppMethodBeat.o(44767);
            return;
        }
        h.a(MainProcessIPCService.dkO, appBrandBackgroundRunningOperationParcel, C0559a.class, new d<IPCBoolean>() {
            /* class com.tencent.mm.plugin.appbrand.backgroundrunning.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCBoolean iPCBoolean) {
                AppMethodBeat.i(44763);
                IPCBoolean iPCBoolean2 = iPCBoolean;
                if (iPCBoolean2 != null) {
                    Log.i("MicroMsg.AppBrandBackgroundRunningManagerService", "sendOperation(appbrand process), result:%s", Boolean.valueOf(iPCBoolean2.value));
                }
                AppMethodBeat.o(44763);
            }
        });
        AppMethodBeat.o(44767);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.backgroundrunning.a$a  reason: collision with other inner class name */
    static class C0559a implements com.tencent.mm.ipcinvoker.b<AppBrandBackgroundRunningOperationParcel, IPCBoolean> {
        private C0559a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel, d<IPCBoolean> dVar) {
            AppMethodBeat.i(44764);
            AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel2 = appBrandBackgroundRunningOperationParcel;
            if (appBrandBackgroundRunningOperationParcel2 == null) {
                Log.w("MicroMsg.AppBrandBackgroundRunningManagerService", "sendOperation(MM process), data is null");
                dVar.bn(new IPCBoolean(false));
                AppMethodBeat.o(44764);
            } else if (g.af(g.class) != null) {
                ((g) g.af(g.class)).c(appBrandBackgroundRunningOperationParcel2);
                dVar.bn(new IPCBoolean(true));
                AppMethodBeat.o(44764);
            } else {
                dVar.bn(new IPCBoolean(false));
                AppMethodBeat.o(44764);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.f
    public final void a(MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel) {
        AppMethodBeat.i(44768);
        if (mMBackgroundRunningOperationParcel == null || Util.isNullOrNil(mMBackgroundRunningOperationParcel.appId)) {
            AppMethodBeat.o(44768);
            return;
        }
        Log.i("MicroMsg.AppBrandBackgroundRunningManagerService", "receiveOperation in appbrand process, operation:%s", mMBackgroundRunningOperationParcel);
        synchronized (this.kYh) {
            try {
                Iterator<f.a> it = this.kYh.iterator();
                while (it.hasNext()) {
                    it.next().b(mMBackgroundRunningOperationParcel);
                }
            } finally {
                AppMethodBeat.o(44768);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.f
    public final void a(f.b bVar) {
        AppMethodBeat.i(44769);
        if (bVar == null) {
            AppMethodBeat.o(44769);
            return;
        }
        synchronized (this.kYg) {
            try {
                this.kYg.add(bVar);
            } finally {
                AppMethodBeat.o(44769);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.f
    public final void b(f.b bVar) {
        AppMethodBeat.i(44770);
        if (bVar == null) {
            AppMethodBeat.o(44770);
            return;
        }
        synchronized (this.kYg) {
            try {
                this.kYg.remove(bVar);
            } finally {
                AppMethodBeat.o(44770);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.f
    public final void a(f.a aVar) {
        AppMethodBeat.i(44771);
        if (aVar == null) {
            AppMethodBeat.o(44771);
            return;
        }
        synchronized (this.kYh) {
            try {
                this.kYh.add(aVar);
            } finally {
                AppMethodBeat.o(44771);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.f
    public final void b(f.a aVar) {
        AppMethodBeat.i(44772);
        if (aVar == null) {
            AppMethodBeat.o(44772);
            return;
        }
        synchronized (this.kYh) {
            try {
                this.kYh.remove(aVar);
            } finally {
                AppMethodBeat.o(44772);
            }
        }
    }
}
