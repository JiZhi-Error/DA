package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.message.h;
import java.util.List;

public final class WxaMenuHelper {
    private final SparseArray<com.tencent.mm.plugin.appbrand.menu.a.a> nfD;

    /* synthetic */ WxaMenuHelper(byte b2) {
        this();
    }

    /* access modifiers changed from: package-private */
    public static class a {
        static WxaMenuHelper nfF = new WxaMenuHelper((byte) 0);

        static {
            AppMethodBeat.i(47671);
            AppMethodBeat.o(47671);
        }
    }

    private WxaMenuHelper() {
        AppMethodBeat.i(47672);
        this.nfD = new SparseArray<>();
        a(new s());
        a(new j());
        a(new m());
        a(new o());
        a(new r());
        a(new p());
        a(new i());
        a(new n());
        a(new c());
        a(new k());
        a(new e());
        a(new d());
        a(new h());
        a(new f());
        a(new g());
        a(new a());
        a(new q());
        a(new l());
        AppMethodBeat.o(47672);
    }

    public static void a(List<t> list, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(47673);
        t tVar = new t(i2, z, a.nfF.nfD.get(i2));
        tVar.neT = z2;
        list.add(tVar);
        AppMethodBeat.o(47673);
    }

    private void a(com.tencent.mm.plugin.appbrand.menu.a.a aVar) {
        AppMethodBeat.i(47674);
        this.nfD.put(aVar.nfG, aVar);
        AppMethodBeat.o(47674);
    }

    public static class GetCopyPathMenuExpireTimeTask extends MainProcessTask {
        public static final Parcelable.Creator<GetCopyPathMenuExpireTimeTask> CREATOR = new Parcelable.Creator<GetCopyPathMenuExpireTimeTask>() {
            /* class com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetCopyPathMenuExpireTimeTask[] newArray(int i2) {
                return new GetCopyPathMenuExpireTimeTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetCopyPathMenuExpireTimeTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(47665);
                GetCopyPathMenuExpireTimeTask getCopyPathMenuExpireTimeTask = new GetCopyPathMenuExpireTimeTask(parcel);
                AppMethodBeat.o(47665);
                return getCopyPathMenuExpireTimeTask;
            }
        };
        private String mAppId;
        private long nfE = 0;

        public GetCopyPathMenuExpireTimeTask(String str) {
            this.mAppId = str;
        }

        public GetCopyPathMenuExpireTimeTask(Parcel parcel) {
            AppMethodBeat.i(47666);
            f(parcel);
            AppMethodBeat.o(47666);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(47667);
            h hVar = h.INSTANCE;
            Long ev = h.ev(this.mAppId, "copypath");
            if (ev == null) {
                this.nfE = 0;
                AppMethodBeat.o(47667);
                return;
            }
            this.nfE = ev.longValue();
            AppMethodBeat.o(47667);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(47668);
            this.nfE = parcel.readLong();
            this.mAppId = parcel.readString();
            AppMethodBeat.o(47668);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(47669);
            parcel.writeLong(this.nfE);
            parcel.writeString(this.mAppId);
            AppMethodBeat.o(47669);
        }

        static {
            AppMethodBeat.i(47670);
            AppMethodBeat.o(47670);
        }
    }
}
