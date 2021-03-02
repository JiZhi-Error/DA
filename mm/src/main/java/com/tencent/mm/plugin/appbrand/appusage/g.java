package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.sdk.storage.MStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0016\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\u0017\u001a\u00020\f2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u0005H\u0016¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageIPC;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "()V", "addCollection", "", ch.COL_USERNAME, "", "versionType", "getCount", "getCountLimit", "isCollection", "", SearchIntents.EXTRA_QUERY, "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "", "refreshOnPullDownOpenAnimationEnd", "removeCollection", "reorder", "reorderList", "reason", "plugin-appbrand-integration_release"})
public final class g extends MStorage implements ag {
    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final void bxG() {
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final int bg(String str, int i2) {
        AppMethodBeat.i(50266);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(50266);
            return -1;
        }
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.a(MainProcessIPCService.dkO, new AppIdentity(str, i2), a.class);
        if (iPCInteger != null) {
            int i3 = iPCInteger.value;
            AppMethodBeat.o(50266);
            return i3;
        }
        AppMethodBeat.o(50266);
        return -1;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final boolean bh(String str, int i2) {
        boolean z;
        AppMethodBeat.i(50267);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(50267);
            return false;
        }
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, new AppIdentity(str, i2), am.class);
        if (iPCBoolean != null) {
            boolean z2 = iPCBoolean.value;
            AppMethodBeat.o(50267);
            return z2;
        }
        AppMethodBeat.o(50267);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final boolean bf(String str, int i2) {
        boolean z;
        AppMethodBeat.i(50268);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(50268);
            return false;
        }
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, new AppIdentity(str, i2), ai.class);
        if (iPCBoolean != null) {
            boolean z2 = iPCBoolean.value;
            AppMethodBeat.o(50268);
            return z2;
        }
        AppMethodBeat.o(50268);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final boolean g(List<LocalUsageInfo> list, int i2) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final List<LocalUsageInfo> a(int i2, ag.a aVar) {
        AppMethodBeat.i(50269);
        List<LocalUsageInfo> a2 = a(i2, aVar, Integer.MAX_VALUE);
        AppMethodBeat.o(50269);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final List<LocalUsageInfo> a(int i2, ag.a aVar, int i3) {
        AppMethodBeat.i(50270);
        Parcel parcel = (Parcel) XIPCInvoker.a(MainProcessIPCService.dkO, new QueryParams(i2, aVar, i3), al.class);
        if (parcel != null) {
            ArrayList arrayList = new ArrayList();
            parcel.readTypedList(arrayList, LocalUsageInfo.CREATOR);
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(50270);
            return arrayList2;
        }
        ArrayList arrayList3 = new ArrayList(0);
        AppMethodBeat.o(50270);
        return arrayList3;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final int getCount() {
        AppMethodBeat.i(50271);
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, ad.class);
        if (iPCInteger != null) {
            int i2 = iPCInteger.value;
            AppMethodBeat.o(50271);
            return i2;
        }
        AppMethodBeat.o(50271);
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ag
    public final int bxH() {
        AppMethodBeat.i(50272);
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, aj.class);
        if (iPCInteger != null) {
            int i2 = iPCInteger.value;
            AppMethodBeat.o(50272);
            return i2;
        }
        int byo = v.byo();
        AppMethodBeat.o(50272);
        return byo;
    }
}
