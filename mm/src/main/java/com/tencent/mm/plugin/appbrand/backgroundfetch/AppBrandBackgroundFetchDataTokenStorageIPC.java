package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class AppBrandBackgroundFetchDataTokenStorageIPC implements l {
    @Override // com.tencent.mm.plugin.appbrand.backgroundfetch.l
    public final AppBrandBackgroundFetchDataTokenParcel Wy(String str) {
        AppMethodBeat.i(44752);
        AppBrandBackgroundFetchDataTokenParcel appBrandBackgroundFetchDataTokenParcel = (AppBrandBackgroundFetchDataTokenParcel) XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(str), a.class);
        AppMethodBeat.o(44752);
        return appBrandBackgroundFetchDataTokenParcel;
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundfetch.l
    public final boolean cN(String str, String str2) {
        AppMethodBeat.i(44753);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, new WxappParams(str, str2), b.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.o(44753);
            return false;
        }
        AppMethodBeat.o(44753);
        return true;
    }

    static class a implements k<IPCString, AppBrandBackgroundFetchDataTokenParcel> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ AppBrandBackgroundFetchDataTokenParcel invoke(IPCString iPCString) {
            AppMethodBeat.i(44745);
            AppBrandBackgroundFetchDataTokenParcel a2 = a(iPCString);
            AppMethodBeat.o(44745);
            return a2;
        }

        private static AppBrandBackgroundFetchDataTokenParcel a(IPCString iPCString) {
            AppMethodBeat.i(44744);
            if (iPCString == null || Util.isNullOrNil(iPCString.value)) {
                Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageIPC", "GetCall:data or username is null");
                AppMethodBeat.o(44744);
                return null;
            }
            try {
                AppBrandBackgroundFetchDataTokenParcel Wy = ((l) g.af(l.class)).Wy(iPCString.value);
                AppMethodBeat.o(44744);
                return Wy;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageIPC", "GetCall fail", e2);
                AppMethodBeat.o(44744);
                return null;
            }
        }
    }

    static class b implements k<WxappParams, IPCBoolean> {
        private b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(WxappParams wxappParams) {
            AppMethodBeat.i(44747);
            IPCBoolean a2 = a(wxappParams);
            AppMethodBeat.o(44747);
            return a2;
        }

        private static IPCBoolean a(WxappParams wxappParams) {
            AppMethodBeat.i(44746);
            if (wxappParams == null || Util.isNullOrNil(wxappParams.username)) {
                Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageIPC", "SetCall:data or username is null");
                IPCBoolean iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.o(44746);
                return iPCBoolean;
            }
            try {
                IPCBoolean iPCBoolean2 = new IPCBoolean(((l) g.af(l.class)).cN(wxappParams.username, wxappParams.token));
                AppMethodBeat.o(44746);
                return iPCBoolean2;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageIPC", "SetCall fail", e2);
                IPCBoolean iPCBoolean3 = new IPCBoolean(false);
                AppMethodBeat.o(44746);
                return iPCBoolean3;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class WxappParams implements Parcelable {
        public static final Parcelable.Creator<WxappParams> CREATOR = new Parcelable.Creator<WxappParams>() {
            /* class com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC.WxappParams.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WxappParams[] newArray(int i2) {
                return new WxappParams[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WxappParams createFromParcel(Parcel parcel) {
                AppMethodBeat.i(44748);
                WxappParams wxappParams = new WxappParams(parcel);
                AppMethodBeat.o(44748);
                return wxappParams;
            }
        };
        public String token;
        public String username;

        public WxappParams() {
        }

        public WxappParams(String str, String str2) {
            this.username = str;
            this.token = str2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(44749);
            parcel.writeString(this.username);
            parcel.writeString(this.token);
            AppMethodBeat.o(44749);
        }

        protected WxappParams(Parcel parcel) {
            AppMethodBeat.i(44750);
            this.username = parcel.readString();
            this.token = parcel.readString();
            AppMethodBeat.o(44750);
        }

        static {
            AppMethodBeat.i(44751);
            AppMethodBeat.o(44751);
        }
    }
}
