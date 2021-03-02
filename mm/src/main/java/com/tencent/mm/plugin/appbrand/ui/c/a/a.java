package com.tencent.mm.plugin.appbrand.ui.c.a;

import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.m;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "Lcom/tencent/mm/autogen/table/BaseAppBrandFakeNativeSplashScreenshot;", "()V", "convertTo", "Landroid/content/ContentValues;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-appbrand-integration_release"})
public final class a extends m {
    public static final IAutoDBItem.MAutoDBInfo iBg = m.ajs();
    public static final com.tencent.mm.ipcinvoker.extension.a oga = new b();
    public static final C0805a ogb = new C0805a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo$Companion;", "", "()V", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "PARCELIZER", "Lcom/tencent/mm/ipcinvoker/extension/BaseTypeTransfer;", "PARCELIZER$annotations", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.c.a.a$a  reason: collision with other inner class name */
    public static final class C0805a {
        private C0805a() {
        }

        public /* synthetic */ C0805a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(229576);
        AppMethodBeat.o(229576);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo$Companion$PARCELIZER$1", "Lcom/tencent/mm/ipcinvoker/extension/BaseTypeTransfer;", "canTransfer", "", "o", "", "readFromParcel", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "p", "Landroid/os/Parcel;", "writeToParcel", "", "dest", "plugin-appbrand-integration_release"})
    public static final class b implements com.tencent.mm.ipcinvoker.extension.a {
        b() {
        }

        @Override // com.tencent.mm.ipcinvoker.extension.a
        public final boolean bp(Object obj) {
            return obj instanceof a;
        }

        @Override // com.tencent.mm.ipcinvoker.extension.a
        public final void a(Object obj, Parcel parcel) {
            AppMethodBeat.i(229573);
            p.h(obj, "o");
            a aVar = (a) obj;
            if (parcel == null) {
                AppMethodBeat.o(229573);
                return;
            }
            parcel.writeString(aVar.field_appId);
            parcel.writeInt(aVar.field_versionType);
            parcel.writeInt(aVar.field_appVersion);
            parcel.writeByte(aVar.field_isDarkMode ? (byte) 1 : 0);
            parcel.writeString(aVar.field_screenshotFilePath);
            AppMethodBeat.o(229573);
        }

        @Override // com.tencent.mm.ipcinvoker.extension.a
        public final /* synthetic */ Object d(Parcel parcel) {
            AppMethodBeat.i(229574);
            if (parcel == null) {
                AppMethodBeat.o(229574);
                return null;
            }
            a aVar = new a();
            aVar.field_appId = parcel.readString();
            aVar.field_versionType = parcel.readInt();
            aVar.field_appVersion = parcel.readInt();
            aVar.field_isDarkMode = parcel.readByte() > 0;
            aVar.field_screenshotFilePath = parcel.readString();
            AppMethodBeat.o(229574);
            return aVar;
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return iBg;
    }

    @Override // com.tencent.mm.g.c.m, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final ContentValues convertTo() {
        AppMethodBeat.i(229575);
        ContentValues convertTo = super.convertTo();
        if (convertTo.containsKey("isDarkMode")) {
            convertTo.put("isDarkMode", Integer.valueOf(this.field_isDarkMode ? 1 : 0));
        }
        p.g(convertTo, "super.convertTo().also {…)\n            }\n        }");
        AppMethodBeat.o(229575);
        return convertTo;
    }
}
