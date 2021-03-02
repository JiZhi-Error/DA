package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.o;

public final class XIPCInvoker {
    public static <T extends com.tencent.mm.ipcinvoker.b<InputType, ResultType>, InputType, ResultType> void a(String str, InputType inputtype, Class<T> cls, final d<ResultType> dVar) {
        AppMethodBeat.i(158810);
        h.a(str, new WrapperParcelable(cls.getName(), inputtype), a.class, new d<WrapperParcelable>() {
            /* class com.tencent.mm.ipcinvoker.extension.XIPCInvoker.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(WrapperParcelable wrapperParcelable) {
                AppMethodBeat.i(158801);
                WrapperParcelable wrapperParcelable2 = wrapperParcelable;
                if (dVar != null) {
                    if (wrapperParcelable2 == null) {
                        com.tencent.mm.ipcinvoker.h.b.w("IPC.XIPCInvoker", "async invoke callback error, wrapper parcelable data is null!", new Object[0]);
                        dVar.bn(null);
                        AppMethodBeat.o(158801);
                        return;
                    }
                    dVar.bn(wrapperParcelable2.hnx);
                }
                AppMethodBeat.o(158801);
            }
        });
        AppMethodBeat.o(158810);
    }

    public static <T extends k<InputType, ResultType>, InputType, ResultType> ResultType a(String str, InputType inputtype, Class<T> cls) {
        AppMethodBeat.i(158811);
        WrapperParcelable wrapperParcelable = (WrapperParcelable) h.a(str, new WrapperParcelable(cls.getName(), inputtype), c.class);
        if (wrapperParcelable == null) {
            com.tencent.mm.ipcinvoker.h.b.w("IPC.XIPCInvoker", "sync invoke error, wrapper parcelable data is null!", new Object[0]);
            AppMethodBeat.o(158811);
            return null;
        }
        ResultType resulttype = (ResultType) wrapperParcelable.hnx;
        AppMethodBeat.o(158811);
        return resulttype;
    }

    /* access modifiers changed from: package-private */
    public static class c implements k<WrapperParcelable, WrapperParcelable> {
        private c() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ WrapperParcelable invoke(WrapperParcelable wrapperParcelable) {
            AppMethodBeat.i(158806);
            WrapperParcelable wrapperParcelable2 = wrapperParcelable;
            Object obj = wrapperParcelable2.hnx;
            String str = wrapperParcelable2.hnA;
            if (str == null || str.length() == 0) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.XIPCInvoker", "proxy SyncInvoke failed, class is null or nil.", new Object[0]);
                WrapperParcelable wrapperParcelable3 = new WrapperParcelable(null, null);
                AppMethodBeat.o(158806);
                return wrapperParcelable3;
            }
            k kVar = (k) o.b(str, k.class);
            if (kVar == null) {
                com.tencent.mm.ipcinvoker.h.b.w("IPC.XIPCInvoker", "proxy SyncInvoke failed, newInstance(%s) return null.", str);
                WrapperParcelable wrapperParcelable4 = new WrapperParcelable(null, null);
                AppMethodBeat.o(158806);
                return wrapperParcelable4;
            }
            WrapperParcelable wrapperParcelable5 = new WrapperParcelable(null, kVar.invoke(obj));
            AppMethodBeat.o(158806);
            return wrapperParcelable5;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.mm.ipcinvoker.b<WrapperParcelable, WrapperParcelable> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(WrapperParcelable wrapperParcelable, d<WrapperParcelable> dVar) {
            AppMethodBeat.i(158802);
            WrapperParcelable wrapperParcelable2 = wrapperParcelable;
            Object obj = wrapperParcelable2.hnx;
            String str = wrapperParcelable2.hnA;
            if (str == null || str.length() == 0) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, class is null or nil.", new Object[0]);
                AppMethodBeat.o(158802);
                return;
            }
            com.tencent.mm.ipcinvoker.b bVar = (com.tencent.mm.ipcinvoker.b) o.b(str, com.tencent.mm.ipcinvoker.b.class);
            if (bVar == null) {
                com.tencent.mm.ipcinvoker.h.b.w("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, newInstance(%s) return null.", str);
                AppMethodBeat.o(158802);
                return;
            }
            bVar.invoke(obj, new b(dVar));
            AppMethodBeat.o(158802);
        }
    }

    static class b implements d, com.tencent.mm.ipcinvoker.e.a {
        d<WrapperParcelable> hny;
        com.tencent.mm.ipcinvoker.e.a hnz;

        b(d<WrapperParcelable> dVar) {
            AppMethodBeat.i(158803);
            this.hny = dVar;
            if (dVar instanceof com.tencent.mm.ipcinvoker.e.a) {
                this.hnz = (com.tencent.mm.ipcinvoker.e.a) dVar;
            }
            AppMethodBeat.o(158803);
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final void bn(Object obj) {
            AppMethodBeat.i(158804);
            if (this.hny != null) {
                this.hny.bn(new WrapperParcelable(null, obj));
            }
            AppMethodBeat.o(158804);
        }

        @Override // com.tencent.mm.ipcinvoker.e.a
        public final void a(com.tencent.mm.ipcinvoker.e.b bVar) {
            AppMethodBeat.i(158805);
            if (this.hnz == null) {
                AppMethodBeat.o(158805);
                return;
            }
            this.hnz.a(bVar);
            AppMethodBeat.o(158805);
        }
    }

    /* access modifiers changed from: package-private */
    public static class WrapperParcelable implements Parcelable {
        public static final Parcelable.Creator<WrapperParcelable> CREATOR = new Parcelable.Creator<WrapperParcelable>() {
            /* class com.tencent.mm.ipcinvoker.extension.XIPCInvoker.WrapperParcelable.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WrapperParcelable[] newArray(int i2) {
                return new WrapperParcelable[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WrapperParcelable createFromParcel(Parcel parcel) {
                AppMethodBeat.i(158807);
                WrapperParcelable wrapperParcelable = new WrapperParcelable((byte) 0);
                wrapperParcelable.hnA = parcel.readString();
                if (parcel.readInt() == 1) {
                    wrapperParcelable.hnx = c.a(parcel.readString(), parcel);
                }
                AppMethodBeat.o(158807);
                return wrapperParcelable;
            }
        };
        String hnA;
        Object hnx;

        /* synthetic */ WrapperParcelable(byte b2) {
            this();
        }

        private WrapperParcelable() {
        }

        public WrapperParcelable(String str, Object obj) {
            this.hnA = str;
            this.hnx = obj;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            a bq;
            AppMethodBeat.i(158808);
            parcel.writeString(this.hnA);
            if (this.hnx == null || (bq = c.bq(this.hnx)) == null) {
                parcel.writeInt(0);
                AppMethodBeat.o(158808);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(bq.getClass().getName());
            bq.a(this.hnx, parcel);
            AppMethodBeat.o(158808);
        }

        static {
            AppMethodBeat.i(158809);
            AppMethodBeat.o(158809);
        }
    }
}
