package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;

public abstract class AppBrandLaunchErrorAction implements Parcelable {
    public static final a CREATOR = new a();
    final String appId;
    final int iOo;

    public abstract void ae(Context context, String str);

    AppBrandLaunchErrorAction(Parcel parcel) {
        this.appId = parcel.readString();
        this.iOo = parcel.readInt();
    }

    AppBrandLaunchErrorAction(String str, int i2) {
        this.appId = str;
        this.iOo = i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(getClass().getName());
        parcel.writeString(this.appId);
        parcel.writeInt(this.iOo);
    }

    public final int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public static final class a implements Parcelable.Creator<AppBrandLaunchErrorAction> {
        a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandLaunchErrorAction createFromParcel(Parcel parcel) {
            AppMethodBeat.i(47043);
            AppBrandLaunchErrorAction l = l(parcel);
            AppMethodBeat.o(47043);
            return l;
        }

        private static AppBrandLaunchErrorAction l(Parcel parcel) {
            AppMethodBeat.i(47041);
            String readString = parcel.readString();
            if (readString == null) {
                AppMethodBeat.o(47041);
                return null;
            }
            try {
                AppBrandLaunchErrorAction appBrandLaunchErrorAction = (AppBrandLaunchErrorAction) Class.forName(readString).getDeclaredConstructor(Parcel.class).newInstance(parcel);
                AppMethodBeat.o(47041);
                return appBrandLaunchErrorAction;
            } catch (Exception e2) {
                AppMethodBeat.o(47041);
                return null;
            }
        }

        static AppBrandLaunchErrorAction a(String str, int i2, ap apVar) {
            AppBrandLaunchErrorAction appBrandLaunchErrorAction = null;
            AppMethodBeat.i(47042);
            if (apVar == null || apVar.field_launchAction == null) {
                AppMethodBeat.o(47042);
            } else {
                switch (apVar.field_launchAction.KCD) {
                    case 2:
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", apVar.field_launchAction.Mmf);
                        intent.putExtra("forceHideShare", true);
                        appBrandLaunchErrorAction = new AppBrandLaunchErrorActionStartActivity(str, i2, "webview", ".ui.tools.WebViewUI", intent);
                        break;
                    case 3:
                        appBrandLaunchErrorAction = new AppBrandLaunchErrorActionAlert(str, i2, apVar.field_launchAction.Mdz, apVar.field_launchAction.Mmh);
                        break;
                }
                if (appBrandLaunchErrorAction != null) {
                    AppBrandStickyBannerLogic.b.cr(str, i2);
                }
                AppMethodBeat.o(47042);
            }
            return appBrandLaunchErrorAction;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandLaunchErrorAction[] newArray(int i2) {
            return new AppBrandLaunchErrorAction[i2];
        }
    }
}
