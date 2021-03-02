package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0006\u0010\u000b\u001a\u00020\n¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
public final class e extends as {
    @Deprecated
    public static final a kUk = new a((byte) 0);

    static {
        AppMethodBeat.i(50242);
        AppMethodBeat.o(50242);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionRecordTableUpgradeIssueDataTransfer$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer";
    }

    @Override // com.tencent.mm.model.as
    public final void transfer(int i2) {
        AppMethodBeat.i(50240);
        try {
            n.buz().buA().execSQL("AppBrandStarApp", "update AppBrandStarApp set orderSequence = updateTime");
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_APP_BRAND_COLLECTION_RECORD_TABLE_UPGRADE_ISSUE_DONE_BOOLEAN, Boolean.TRUE);
            AppMethodBeat.o(50240);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", th, "transfer failed", new Object[0]);
            AppMethodBeat.o(50240);
        }
    }

    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        AppMethodBeat.i(50241);
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        boolean z = aAh.azQ().getBoolean(ar.a.USERINFO_APP_BRAND_COLLECTION_RECORD_TABLE_UPGRADE_ISSUE_DONE_BOOLEAN, false);
        Log.d("MicroMsg.AppBrandCollectionRecordTableUpgradeIssueDataTransfer", "needTransfer doneIssue ".concat(String.valueOf(z)));
        if (!z) {
            AppMethodBeat.o(50241);
            return true;
        }
        AppMethodBeat.o(50241);
        return false;
    }
}
