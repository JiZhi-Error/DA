package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class o extends MStorage implements ah {
    private final Set<MStorage.IOnStorageChange> kUO = new HashSet();

    public o() {
        AppMethodBeat.i(44521);
        AppMethodBeat.o(44521);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ah
    public final boolean bi(String str, int i2) {
        AppMethodBeat.i(44522);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, new AppIdentity(str, i2), c.class);
        if (iPCBoolean == null) {
            AppMethodBeat.o(44522);
            return false;
        }
        boolean z = iPCBoolean.value;
        AppMethodBeat.o(44522);
        return z;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ah
    public final List<LocalUsageInfo> vW(int i2) {
        AppMethodBeat.i(44523);
        List<LocalUsageInfo> dP = dP(i2, Integer.MAX_VALUE);
        AppMethodBeat.o(44523);
        return dP;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ah
    public final List<LocalUsageInfo> dP(int i2, int i3) {
        AppMethodBeat.i(44524);
        Bundle bundle = new Bundle();
        bundle.putInt("count", i2);
        bundle.putInt("versionType", i3);
        Parcel parcel = (Parcel) XIPCInvoker.a(MainProcessIPCService.dkO, bundle, a.class);
        if (parcel == null) {
            AppMethodBeat.o(44524);
            return null;
        }
        ArrayList arrayList = new ArrayList(i2);
        parcel.readTypedList(arrayList, LocalUsageInfo.CREATOR);
        AppMethodBeat.o(44524);
        return arrayList;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(44525);
        add(iOnStorageChange, Looper.getMainLooper());
        AppMethodBeat.o(44525);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange, Looper looper) {
        boolean z = true;
        AppMethodBeat.i(44526);
        if (iOnStorageChange == null || looper == null) {
            AppMethodBeat.o(44526);
            return;
        }
        super.add(iOnStorageChange, looper);
        synchronized (this.kUO) {
            try {
                this.kUO.add(iOnStorageChange);
                if (this.kUO.size() != 1) {
                    z = false;
                }
            } finally {
                AppMethodBeat.o(44526);
            }
        }
        if (z) {
            XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, b.class, new d<Parcel>() {
                /* class com.tencent.mm.plugin.appbrand.appusage.o.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Parcel parcel) {
                    AppMethodBeat.i(44512);
                    Parcel parcel2 = parcel;
                    o.this.doNotify(parcel2.readString(), parcel2.readInt(), parcel2.readString());
                    AppMethodBeat.o(44512);
                }
            });
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void remove(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(44527);
        if (iOnStorageChange == null) {
            AppMethodBeat.o(44527);
            return;
        }
        super.remove(iOnStorageChange);
        synchronized (this.kUO) {
            try {
                this.kUO.remove(iOnStorageChange);
            } finally {
                AppMethodBeat.o(44527);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b implements com.tencent.mm.ipcinvoker.b<IPCVoid, Parcel> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, final d<Parcel> dVar) {
            AppMethodBeat.i(44518);
            final AnonymousClass1 r1 = new MStorage.IOnStorageChange() {
                /* class com.tencent.mm.plugin.appbrand.appusage.o.b.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
                public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                    AppMethodBeat.i(44515);
                    if (dVar != null) {
                        Parcel obtain = Parcel.obtain();
                        obtain.writeString(str);
                        obtain.writeInt(mStorageEventData.eventId);
                        obtain.writeString(mStorageEventData.obj == null ? null : mStorageEventData.obj.toString());
                        dVar.bn(obtain);
                    }
                    AppMethodBeat.o(44515);
                }
            };
            ((ah) g.af(ah.class)).add(r1);
            ((com.tencent.mm.ipcinvoker.e.a) dVar).a(new com.tencent.mm.ipcinvoker.e.b() {
                /* class com.tencent.mm.plugin.appbrand.appusage.o.b.AnonymousClass2 */

                @Override // com.tencent.mm.ipcinvoker.e.b
                public final void j(Exception exc) {
                    AppMethodBeat.i(44517);
                    if (exc instanceof DeadObjectException) {
                        new MMHandler(Looper.myLooper()).post(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.appusage.o.b.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(44516);
                                ((ah) g.af(ah.class)).remove(r1);
                                AppMethodBeat.o(44516);
                            }
                        });
                        AppMethodBeat.o(44517);
                        return;
                    }
                    Log.e("MicroMsg.AppBrandLocalUsageStorageIPCImpl", "onExceptionOccur(%s)", android.util.Log.getStackTraceString(exc));
                    AppMethodBeat.o(44517);
                }
            });
            AppMethodBeat.o(44518);
        }
    }

    static final class c implements k<AppIdentity, IPCBoolean> {
        private c() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(AppIdentity appIdentity) {
            AppMethodBeat.i(44520);
            IPCBoolean c2 = c(appIdentity);
            AppMethodBeat.o(44520);
            return c2;
        }

        private static IPCBoolean c(AppIdentity appIdentity) {
            AppMethodBeat.i(44519);
            try {
                IPCBoolean iPCBoolean = new IPCBoolean(((ah) g.af(ah.class)).bi(appIdentity.username, appIdentity.iOo));
                AppMethodBeat.o(44519);
                return iPCBoolean;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandLocalUsageStorageIPCImpl", e2, "ipc removeUsage", new Object[0]);
                IPCBoolean iPCBoolean2 = new IPCBoolean(false);
                AppMethodBeat.o(44519);
                return iPCBoolean2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a implements k<Bundle, Parcel> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Parcel invoke(Bundle bundle) {
            AppMethodBeat.i(44514);
            Parcel G = G(bundle);
            AppMethodBeat.o(44514);
            return G;
        }

        private static Parcel G(Bundle bundle) {
            AppMethodBeat.i(44513);
            int i2 = bundle.getInt("count");
            int i3 = bundle.getInt("versionType", Integer.MAX_VALUE);
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeTypedList(((ah) g.af(ah.class)).dP(i2, i3));
                AppMethodBeat.o(44513);
                return obtain;
            } catch (Exception e2) {
                obtain.setDataPosition(0);
                obtain.writeTypedList(null);
                AppMethodBeat.o(44513);
                return obtain;
            }
        }
    }
}
