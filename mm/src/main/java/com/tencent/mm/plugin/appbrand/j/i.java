package com.tencent.mm.plugin.appbrand.j;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.x;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

enum i {
    ;
    
    private static final a lrg = new a();

    static {
        AppMethodBeat.i(45047);
        AppMethodBeat.o(45047);
    }

    public static i valueOf(String str) {
        AppMethodBeat.i(45040);
        i iVar = (i) Enum.valueOf(i.class, str);
        AppMethodBeat.o(45040);
        return iVar;
    }

    static void onCreate() {
        AppMethodBeat.i(45041);
        y.bAj().add(lrg);
        AppMethodBeat.o(45041);
    }

    static void onDestroy() {
        AppMethodBeat.i(45042);
        y.bAj().remove(lrg);
        AppMethodBeat.o(45042);
    }

    static List<AppBrandRecentTaskInfo> bCT() {
        AppMethodBeat.i(45043);
        LinkedList linkedList = new LinkedList();
        if (n.buJ() != null) {
            ArrayList<AppBrandRecentTaskInfo> vZ = n.buJ().vZ(10000);
            if (!Util.isNullOrNil(vZ)) {
                linkedList.addAll(vZ);
            }
        }
        AppMethodBeat.o(45043);
        return linkedList;
    }

    static AppBrandRecentTaskInfo YG(String str) {
        AppBrandRecentTaskInfo appBrandRecentTaskInfo;
        AppMethodBeat.i(45044);
        if (n.buJ() == null) {
            AppMethodBeat.o(45044);
            return null;
        }
        x buJ = n.buJ();
        if (Util.isNullOrNil(str)) {
            appBrandRecentTaskInfo = null;
        } else {
            Cursor query = buJ.kVs.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", "scene", "recordId"), new String[]{"2", str}, null, null, null);
            if (query == null) {
                appBrandRecentTaskInfo = null;
            } else {
                if (query.moveToFirst()) {
                    x.a aVar = new x.a();
                    aVar.convertFrom(query);
                    if (!Util.isNullOrNil(aVar.field_brandId)) {
                        appBrandRecentTaskInfo = y.a(String.valueOf(aVar.field_recordId), aVar.field_brandId, aVar.field_versionType, aVar.field_updateTime, aVar.field_usedInThirdPartyAppRecently, aVar.field_thirdPartyAppUsingDesc);
                        query.close();
                    }
                }
                appBrandRecentTaskInfo = null;
                query.close();
            }
        }
        if (appBrandRecentTaskInfo == null) {
            AppMethodBeat.o(45044);
            return null;
        }
        AppMethodBeat.o(45044);
        return appBrandRecentTaskInfo;
    }

    static void c(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(45045);
        if (n.buJ() != null) {
            n.buJ().add(iOnStorageChange);
        }
        AppMethodBeat.o(45045);
    }

    static void d(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(45046);
        if (n.buJ() != null) {
            n.buJ().remove(iOnStorageChange);
        }
        AppMethodBeat.o(45046);
    }
}
