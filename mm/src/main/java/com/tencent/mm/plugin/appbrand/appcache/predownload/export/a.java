package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.content.ContentValues;
import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.protocal.protobuf.efw;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/PrefetchForNonStandardAppUtils;", "", "()V", "collectBatchSyncVersionReqList", "", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "convertFrom", "", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "values", "Landroid/content/ContentValues;", "plugin-appbrand-integration_release"})
public final class a {
    public static final a kPZ = new a();

    static {
        AppMethodBeat.i(228043);
        AppMethodBeat.o(228043);
    }

    private a() {
    }

    public static final List<efw> bwS() {
        boolean z;
        AppMethodBeat.i(228041);
        bh buL = n.buL();
        if (buL == null) {
            v vVar = v.SXr;
            AppMethodBeat.o(228041);
            return vVar;
        }
        LinkedList linkedList = new LinkedList();
        t tVar = t.lfL;
        Iterator<String> it = t.bAf().iterator();
        while (it.hasNext()) {
            String next = it.next();
            String adVar = new ad(next, "", 0).toString();
            p.g(adVar, "PkgQueryKey(appId, \"\", 0).toString()");
            bd a2 = buL.a(adVar, 0, "pkgPath", "version", "versionMd5", "NewMd5");
            if (a2 != null) {
                String str = a2.field_pkgPath;
                if (str == null || str.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && s.YS(a2.field_pkgPath)) {
                    if (bj.a(new o(a2.field_pkgPath), new String[]{a2.field_versionMd5, a2.field_NewMd5}, next, "collectBatchSyncVersionReqList")) {
                        efw efw = new efw();
                        t tVar2 = t.lfL;
                        efw.Mmv = t.bAg().get(next);
                        efw.NfQ = a2.field_version;
                        efw.NfR = a2.field_version;
                        efw.xut = null;
                        efw.jfi = next;
                        linkedList.add(efw);
                    }
                }
            }
        }
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(228041);
        return linkedList2;
    }

    public static void a(IAutoDBItem iAutoDBItem, ContentValues contentValues) {
        AppMethodBeat.i(228042);
        p.h(iAutoDBItem, "$this$convertFrom");
        p.h(contentValues, "values");
        Set<String> keySet = contentValues.keySet();
        p.g(keySet, "values.keySet()");
        Object[] array = keySet.toArray(new String[0]);
        if (array == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(228042);
            throw tVar;
        }
        String[] strArr = (String[]) array;
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        Object[] objArr = new Object[strArr.length];
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            objArr[i3] = contentValues.get(strArr[i2]);
            i2++;
            i3++;
        }
        matrixCursor.addRow(objArr);
        iAutoDBItem.convertFrom(matrixCursor);
        AppMethodBeat.o(228042);
    }
}
