package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;

public final class r extends as {
    @Override // com.tencent.mm.model.as
    public final void transfer(int i2) {
        AppMethodBeat.i(226391);
        try {
            Cursor rawQuery = n.buL().kNJ.rawQuery(String.format("select distinct %s from %s where %s like '%%$%s' ", "appId", "AppBrandWxaPkgManifestRecord", "appId", ModulePkgInfo.PLUGIN_CODE), null, 2);
            ArrayList<String> arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            rawQuery.close();
            if (Util.isNullOrNil(arrayList) || arrayList.size() <= 0) {
                Log.i("AppBrandPluginCodeCodeCacheTransfer", "no need to transfer pluginAppIdList :%d", Integer.valueOf(arrayList.size()));
                g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_PLUGINCODE_CLEAR_CODECACHE_DONE_BOOLEAN, Boolean.TRUE);
                AppMethodBeat.o(226391);
                return;
            }
            o[] het = new o(ad.bDt()).het();
            for (o oVar : het) {
                if (oVar.isDirectory()) {
                    String name = oVar.getName();
                    Log.d("AppBrandPluginCodeCodeCacheTransfer", "fileName:%s", name);
                    if (!Util.isNullOrNil(name)) {
                        for (String str : arrayList) {
                            if (name.startsWith(str.substring(0, str.indexOf("$")))) {
                                boolean delete = oVar.delete();
                                if (oVar.isDirectory()) {
                                    delete = s.dy(aa.z(oVar.mUri), true);
                                } else if (oVar.isFile()) {
                                    delete = oVar.delete();
                                }
                                Log.d("AppBrandPluginCodeCodeCacheTransfer", "delete file:%s ret:%b", name, Boolean.valueOf(delete));
                            }
                        }
                    }
                }
            }
            g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_PLUGINCODE_CLEAR_CODECACHE_DONE_BOOLEAN, Boolean.TRUE);
            AppMethodBeat.o(226391);
        } catch (Exception e2) {
            Log.printErrStackTrace("AppBrandPluginCodeCodeCacheTransfer", e2, "transfer failed", new Object[0]);
            AppMethodBeat.o(226391);
        }
    }

    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        AppMethodBeat.i(226392);
        boolean z = g.aAh().azQ().getBoolean(ar.a.USERINFO_APP_BRAND_PLUGINCODE_CLEAR_CODECACHE_DONE_BOOLEAN, false);
        Log.d("AppBrandPluginCodeCodeCacheTransfer", "needTransfer doneIssue %b", Boolean.valueOf(z));
        if (!z) {
            AppMethodBeat.o(226392);
            return true;
        }
        AppMethodBeat.o(226392);
        return false;
    }

    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "AppBrandPluginCodeCodeCacheTransfer";
    }
}
