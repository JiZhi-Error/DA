package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Locale;

public interface ILaunchWxaAppInfoNotify {
    public static final ILaunchWxaAppInfoNotify mUz = new ILaunchWxaAppInfoNotify() {
        /* class com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.AnonymousClass1 */
        private final String TAG = "MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]";

        @Override // com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify
        public final void a(String str, int i2, String str2, ap apVar) {
            AppMethodBeat.i(47170);
            k abY = k.abY(str2);
            if (abY != null) {
                Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], %s", str, Integer.valueOf(i2), str2, a(apVar));
                abY.a(str, i2, str2, apVar);
            }
            try {
                Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", str, Integer.valueOf(i2), str2, a(apVar));
                LaunchInfoIpcWrapper launchInfoIpcWrapper = new LaunchInfoIpcWrapper();
                launchInfoIpcWrapper.appId = str;
                launchInfoIpcWrapper.iOo = i2;
                launchInfoIpcWrapper.cyG = new AppRuntimeApiPermissionBundle(apVar.field_jsapiInfo);
                AppBrandLaunchErrorAction.a aVar = AppBrandLaunchErrorAction.CREATOR;
                launchInfoIpcWrapper.mUB = AppBrandLaunchErrorAction.a.a(str, i2, apVar);
                e.b(str, launchInfoIpcWrapper);
                AppMethodBeat.o(47170);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", th, "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", str, Integer.valueOf(i2), str2, a(apVar));
                AppMethodBeat.o(47170);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify
        public final void a(String str, int i2, String str2, HashMap<String, AppRuntimeApiPermissionBundle> hashMap) {
            int i3 = 0;
            AppMethodBeat.i(227082);
            k abY = k.abY(str2);
            if (abY != null) {
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = str2;
                objArr[3] = Integer.valueOf(hashMap == null ? 0 : hashMap.size());
                Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyPluginPermissionInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", objArr);
                abY.a(str, i2, str2, hashMap);
            }
            try {
                Object[] objArr2 = new Object[4];
                objArr2[0] = str;
                objArr2[1] = Integer.valueOf(i2);
                objArr2[2] = str2;
                objArr2[3] = Integer.valueOf(hashMap == null ? 0 : hashMap.size());
                Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyPluginPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", objArr2);
                PluginIpcWrapper pluginIpcWrapper = new PluginIpcWrapper();
                pluginIpcWrapper.appId = str;
                pluginIpcWrapper.iOo = i2;
                pluginIpcWrapper.mUC = hashMap;
                e.b(str, pluginIpcWrapper);
                AppMethodBeat.o(227082);
            } catch (Throwable th) {
                Object[] objArr3 = new Object[4];
                objArr3[0] = str;
                objArr3[1] = Integer.valueOf(i2);
                objArr3[2] = str2;
                if (hashMap != null) {
                    i3 = hashMap.size();
                }
                objArr3[3] = Integer.valueOf(i3);
                Log.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", th, "notifyPluginPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", objArr3);
                AppMethodBeat.o(227082);
            }
        }

        private static String a(ap apVar) {
            AppMethodBeat.i(47171);
            if (apVar == null) {
                AppMethodBeat.o(47171);
                return "NULL";
            }
            try {
                String format = String.format(Locale.US, "bytes[%d]", Integer.valueOf(apVar.field_jsapiInfo.LjS.zy.length));
                AppMethodBeat.o(47171);
                return format;
            } catch (Exception e2) {
                String format2 = String.format(Locale.US, "Exception[%s]", e2);
                AppMethodBeat.o(47171);
                return format2;
            }
        }
    };

    public static class a {
    }

    void a(String str, int i2, String str2, ap apVar);

    void a(String str, int i2, String str2, HashMap<String, AppRuntimeApiPermissionBundle> hashMap);

    public static class LaunchInfoIpcWrapper implements Parcelable {
        public static final Parcelable.Creator<LaunchInfoIpcWrapper> CREATOR = new Parcelable.Creator<LaunchInfoIpcWrapper>() {
            /* class com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ LaunchInfoIpcWrapper[] newArray(int i2) {
                return new LaunchInfoIpcWrapper[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ LaunchInfoIpcWrapper createFromParcel(Parcel parcel) {
                AppMethodBeat.i(47172);
                LaunchInfoIpcWrapper launchInfoIpcWrapper = new LaunchInfoIpcWrapper(parcel);
                AppMethodBeat.o(47172);
                return launchInfoIpcWrapper;
            }
        };
        public String appId;
        public AppRuntimeApiPermissionBundle cyG;
        public int iOo;
        public AppBrandLaunchErrorAction mUB;

        LaunchInfoIpcWrapper() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(47173);
            parcel.writeString(this.appId);
            parcel.writeInt(this.iOo);
            parcel.writeParcelable(this.cyG, i2);
            parcel.writeParcelable(this.mUB, i2);
            AppMethodBeat.o(47173);
        }

        LaunchInfoIpcWrapper(Parcel parcel) {
            AppMethodBeat.i(47174);
            this.appId = parcel.readString();
            this.iOo = parcel.readInt();
            this.cyG = (AppRuntimeApiPermissionBundle) parcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader());
            this.mUB = (AppBrandLaunchErrorAction) parcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader());
            AppMethodBeat.o(47174);
        }

        static {
            AppMethodBeat.i(47175);
            AppMethodBeat.o(47175);
        }
    }

    public static class PluginIpcWrapper implements Parcelable {
        public static final Parcelable.Creator<PluginIpcWrapper> CREATOR = new Parcelable.Creator<PluginIpcWrapper>() {
            /* class com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.PluginIpcWrapper.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PluginIpcWrapper[] newArray(int i2) {
                return new PluginIpcWrapper[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PluginIpcWrapper createFromParcel(Parcel parcel) {
                AppMethodBeat.i(227083);
                PluginIpcWrapper pluginIpcWrapper = new PluginIpcWrapper(parcel);
                AppMethodBeat.o(227083);
                return pluginIpcWrapper;
            }
        };
        public String appId;
        public int iOo;
        public HashMap<String, AppRuntimeApiPermissionBundle> mUC;

        PluginIpcWrapper() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(227084);
            parcel.writeString(this.appId);
            parcel.writeInt(this.iOo);
            parcel.writeMap(this.mUC);
            AppMethodBeat.o(227084);
        }

        PluginIpcWrapper(Parcel parcel) {
            AppMethodBeat.i(227085);
            this.appId = parcel.readString();
            this.iOo = parcel.readInt();
            this.mUC = parcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
            AppMethodBeat.o(227085);
        }

        static {
            AppMethodBeat.i(227086);
            AppMethodBeat.o(227086);
        }
    }
}
