package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J \u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandLocalUsageStorageNewImpl;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "()V", "TAG", "", "add", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "getCount", "", SearchIntents.EXTRA_QUERY, "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "versionType", "remove", "removeUsage", "", ch.COL_USERNAME, "plugin-appbrand-integration_release"})
public final class p extends MStorage implements ah {
    private final String TAG = "MicroMsg.AppBrandLocalUsageStorageNewImpl";

    @Override // com.tencent.mm.plugin.appbrand.appusage.ah
    public final boolean bi(String str, int i2) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(50275);
        an.t(str, null, i2);
        if (!n.buJ().bp(str, i2)) {
            try {
                if (n.buJ().bq(str, i2)) {
                    z = false;
                    z2 = z;
                    AppMethodBeat.o(50275);
                    return z2;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "removeUsage", new Object[0]);
            }
        }
        z = true;
        z2 = z;
        AppMethodBeat.o(50275);
        return z2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ah
    public final List<? extends LocalUsageInfo> vW(int i2) {
        AppMethodBeat.i(50276);
        if (i2 <= 0) {
            List<? extends LocalUsageInfo> emptyList = Collections.emptyList();
            kotlin.g.b.p.g(emptyList, "Collections.emptyList<LocalUsageInfo>()");
            AppMethodBeat.o(50276);
            return emptyList;
        }
        ArrayList<AppBrandRecentTaskInfo> d2 = x.d(n.buJ().a(null, i2, 0));
        kotlin.g.b.p.g(d2, "obtainHistoryList(SubCor…istories(null, count, 0))");
        ArrayList<AppBrandRecentTaskInfo> arrayList = d2;
        AppMethodBeat.o(50276);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ah
    public final List<? extends LocalUsageInfo> dP(int i2, int i3) {
        AppMethodBeat.i(50277);
        if (i2 <= 0) {
            List<? extends LocalUsageInfo> emptyList = Collections.emptyList();
            kotlin.g.b.p.g(emptyList, "Collections.emptyList<LocalUsageInfo>()");
            AppMethodBeat.o(50277);
            return emptyList;
        }
        ArrayList<AppBrandRecentTaskInfo> d2 = x.d(n.buJ().a(null, i2, 0, i3));
        kotlin.g.b.p.g(d2, "obtainHistoryList(SubCor…, count, 0, versionType))");
        ArrayList<AppBrandRecentTaskInfo> arrayList = d2;
        AppMethodBeat.o(50277);
        return arrayList;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(50278);
        add(iOnStorageChange, Looper.getMainLooper());
        AppMethodBeat.o(50278);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void add(MStorage.IOnStorageChange iOnStorageChange, Looper looper) {
        AppMethodBeat.i(50279);
        n.buJ().add(iOnStorageChange, looper);
        n.buC().add(iOnStorageChange, looper);
        AppMethodBeat.o(50279);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void remove(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(50280);
        n.buJ().remove(iOnStorageChange);
        n.buC().remove(iOnStorageChange);
        AppMethodBeat.o(50280);
    }
}
