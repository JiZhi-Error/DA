package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class AppBrandBackgroundFetchDataStorageIPC implements k {
    @Override // com.tencent.mm.plugin.appbrand.backgroundfetch.k
    public final boolean a(String str, int i2, String str2, String str3, String str4, int i3, long j2) {
        AppMethodBeat.i(44728);
        Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "AppBrandBackgroundFetchDataStorageIPC set");
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, new WxappParams(str, i2, str2, str3, str4, i3, j2), c.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.o(44728);
            return false;
        }
        AppMethodBeat.o(44728);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundfetch.k
    public final long bu(String str, int i2) {
        AppMethodBeat.i(44729);
        Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "AppBrandBackgroundFetchDataStorageIPC getUpdateTime");
        IPCLong iPCLong = (IPCLong) XIPCInvoker.a(MainProcessIPCService.dkO, new WxappIdentity(str, i2), b.class);
        if (iPCLong != null) {
            long j2 = iPCLong.value;
            AppMethodBeat.o(44729);
            return j2;
        }
        AppMethodBeat.o(44729);
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundfetch.k
    public final AppBrandBackgroundFetchDataParcel bv(String str, int i2) {
        AppMethodBeat.i(44730);
        Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "AppBrandBackgroundFetchDataStorageIPC getByAppId");
        AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = (AppBrandBackgroundFetchDataParcel) XIPCInvoker.a(MainProcessIPCService.dkO, new WxappIdentityWithAppId(str, i2), a.class);
        AppMethodBeat.o(44730);
        return appBrandBackgroundFetchDataParcel;
    }

    static class c implements k<WxappParams, IPCBoolean> {
        private c() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(WxappParams wxappParams) {
            AppMethodBeat.i(44715);
            IPCBoolean a2 = a(wxappParams);
            AppMethodBeat.o(44715);
            return a2;
        }

        private static IPCBoolean a(WxappParams wxappParams) {
            AppMethodBeat.i(44714);
            if (wxappParams == null || Util.isNullOrNil(wxappParams.username)) {
                Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "SetCall:data or username is null");
                IPCBoolean iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.o(44714);
                return iPCBoolean;
            }
            try {
                IPCBoolean iPCBoolean2 = new IPCBoolean(((k) g.af(k.class)).a(wxappParams.username, wxappParams.kXP, wxappParams.data, wxappParams.path, wxappParams.query, wxappParams.scene, wxappParams.time));
                AppMethodBeat.o(44714);
                return iPCBoolean2;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "SetCall fail", e2);
                IPCBoolean iPCBoolean3 = new IPCBoolean(false);
                AppMethodBeat.o(44714);
                return iPCBoolean3;
            }
        }
    }

    static class b implements k<WxappIdentity, IPCLong> {
        private b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCLong invoke(WxappIdentity wxappIdentity) {
            AppMethodBeat.i(44713);
            IPCLong a2 = a(wxappIdentity);
            AppMethodBeat.o(44713);
            return a2;
        }

        private static IPCLong a(WxappIdentity wxappIdentity) {
            AppMethodBeat.i(44712);
            if (wxappIdentity == null || Util.isNullOrNil(wxappIdentity.username)) {
                Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "GetUpdateTimeCall:data or username is null");
                IPCLong iPCLong = new IPCLong(0);
                AppMethodBeat.o(44712);
                return iPCLong;
            }
            try {
                IPCLong iPCLong2 = new IPCLong(((k) g.af(k.class)).bu(wxappIdentity.username, wxappIdentity.kXP));
                AppMethodBeat.o(44712);
                return iPCLong2;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "GetUpdateTimeCall fail", e2);
                IPCLong iPCLong3 = new IPCLong(0);
                AppMethodBeat.o(44712);
                return iPCLong3;
            }
        }
    }

    static class a implements k<WxappIdentityWithAppId, AppBrandBackgroundFetchDataParcel> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ AppBrandBackgroundFetchDataParcel invoke(WxappIdentityWithAppId wxappIdentityWithAppId) {
            AppMethodBeat.i(44711);
            AppBrandBackgroundFetchDataParcel a2 = a(wxappIdentityWithAppId);
            AppMethodBeat.o(44711);
            return a2;
        }

        private static AppBrandBackgroundFetchDataParcel a(WxappIdentityWithAppId wxappIdentityWithAppId) {
            AppMethodBeat.i(44710);
            if (wxappIdentityWithAppId == null || Util.isNullOrNil(wxappIdentityWithAppId.dNI)) {
                Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "GetByAppIdCall:data or appid is null");
                AppMethodBeat.o(44710);
                return null;
            }
            try {
                AppBrandBackgroundFetchDataParcel bv = ((k) g.af(k.class)).bv(wxappIdentityWithAppId.dNI, wxappIdentityWithAppId.kXP);
                AppMethodBeat.o(44710);
                return bv;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "GetByAppIdCall fail", e2);
                AppMethodBeat.o(44710);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class WxappParams implements Parcelable {
        public static final Parcelable.Creator<WxappParams> CREATOR = new Parcelable.Creator<WxappParams>() {
            /* class com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.WxappParams.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WxappParams[] newArray(int i2) {
                return new WxappParams[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WxappParams createFromParcel(Parcel parcel) {
                AppMethodBeat.i(44724);
                WxappParams wxappParams = new WxappParams(parcel);
                AppMethodBeat.o(44724);
                return wxappParams;
            }
        };
        public String data;
        public int kXP;
        public String path;
        public String query;
        public int scene;
        public long time;
        public String username;

        public WxappParams() {
        }

        public WxappParams(String str, int i2, String str2, String str3, String str4, int i3, long j2) {
            this.username = str;
            this.kXP = i2;
            this.data = str2;
            this.path = str3;
            this.query = str4;
            this.scene = i3;
            this.time = j2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(44725);
            parcel.writeString(this.username);
            parcel.writeInt(this.kXP);
            parcel.writeString(this.data);
            parcel.writeString(this.path);
            parcel.writeString(this.query);
            parcel.writeInt(this.scene);
            parcel.writeLong(this.time);
            AppMethodBeat.o(44725);
        }

        protected WxappParams(Parcel parcel) {
            AppMethodBeat.i(44726);
            this.username = parcel.readString();
            this.kXP = parcel.readInt();
            this.data = parcel.readString();
            this.path = parcel.readString();
            this.query = parcel.readString();
            this.scene = parcel.readInt();
            this.time = parcel.readLong();
            AppMethodBeat.o(44726);
        }

        static {
            AppMethodBeat.i(44727);
            AppMethodBeat.o(44727);
        }
    }

    /* access modifiers changed from: package-private */
    public static class WxappIdentityWithAppId implements Parcelable {
        public static final Parcelable.Creator<WxappIdentityWithAppId> CREATOR = new Parcelable.Creator<WxappIdentityWithAppId>() {
            /* class com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.WxappIdentityWithAppId.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WxappIdentityWithAppId[] newArray(int i2) {
                return new WxappIdentityWithAppId[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WxappIdentityWithAppId createFromParcel(Parcel parcel) {
                AppMethodBeat.i(44720);
                WxappIdentityWithAppId wxappIdentityWithAppId = new WxappIdentityWithAppId(parcel);
                AppMethodBeat.o(44720);
                return wxappIdentityWithAppId;
            }
        };
        public String dNI;
        public int kXP;

        public WxappIdentityWithAppId() {
        }

        public WxappIdentityWithAppId(String str, int i2) {
            this.dNI = str;
            this.kXP = i2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(44721);
            parcel.writeString(this.dNI);
            parcel.writeInt(this.kXP);
            AppMethodBeat.o(44721);
        }

        protected WxappIdentityWithAppId(Parcel parcel) {
            AppMethodBeat.i(44722);
            this.dNI = parcel.readString();
            this.kXP = parcel.readInt();
            AppMethodBeat.o(44722);
        }

        static {
            AppMethodBeat.i(44723);
            AppMethodBeat.o(44723);
        }
    }

    /* access modifiers changed from: package-private */
    public static class WxappIdentity implements Parcelable {
        public static final Parcelable.Creator<WxappIdentity> CREATOR = new Parcelable.Creator<WxappIdentity>() {
            /* class com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.WxappIdentity.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WxappIdentity[] newArray(int i2) {
                return new WxappIdentity[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WxappIdentity createFromParcel(Parcel parcel) {
                AppMethodBeat.i(44716);
                WxappIdentity wxappIdentity = new WxappIdentity(parcel);
                AppMethodBeat.o(44716);
                return wxappIdentity;
            }
        };
        public int kXP;
        public String username;

        public WxappIdentity() {
        }

        public WxappIdentity(String str, int i2) {
            this.username = str;
            this.kXP = i2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(44717);
            parcel.writeString(this.username);
            parcel.writeInt(this.kXP);
            AppMethodBeat.o(44717);
        }

        protected WxappIdentity(Parcel parcel) {
            AppMethodBeat.i(44718);
            this.username = parcel.readString();
            this.kXP = parcel.readInt();
            AppMethodBeat.o(44718);
        }

        static {
            AppMethodBeat.i(44719);
            AppMethodBeat.o(44719);
        }
    }
}
