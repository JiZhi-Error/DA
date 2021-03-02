package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public final class m extends q<Object> {
    m(ArrayList<?> arrayList, ArrayList<?> arrayList2) {
        super(arrayList, arrayList2);
    }

    @Override // android.support.v7.h.c.a
    public final boolean i(int i2, int i3) {
        AppMethodBeat.i(49225);
        if (!this.oew.get(i2).getClass().equals(this.oex.get(i3).getClass())) {
            AppMethodBeat.o(49225);
            return false;
        } else if (this.oew.get(i2) instanceof AppBrandRecentTaskInfo) {
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.oew.get(i2);
            AppBrandRecentTaskInfo appBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo) this.oex.get(i3);
            if (appBrandRecentTaskInfo.eix != appBrandRecentTaskInfo2.eix || !appBrandRecentTaskInfo.dCl.equals(appBrandRecentTaskInfo2.dCl)) {
                AppMethodBeat.o(49225);
                return false;
            }
            AppMethodBeat.o(49225);
            return true;
        } else {
            AppMethodBeat.o(49225);
            return false;
        }
    }

    @Override // android.support.v7.h.c.a
    public final boolean j(int i2, int i3) {
        AppMethodBeat.i(49226);
        if (this.oew.get(i2) instanceof AppBrandRecentTaskInfo) {
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.oew.get(i2);
            AppBrandRecentTaskInfo appBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo) this.oex.get(i3);
            if (appBrandRecentTaskInfo.kVp != appBrandRecentTaskInfo2.kVp || !Util.nullAsNil(appBrandRecentTaskInfo.kVo).equals(appBrandRecentTaskInfo2.kVo) || !Util.nullAsNil(appBrandRecentTaskInfo.appName).equals(appBrandRecentTaskInfo2.appName)) {
                AppMethodBeat.o(49226);
                return false;
            }
            AppMethodBeat.o(49226);
            return true;
        }
        AppMethodBeat.o(49226);
        return true;
    }

    @Override // android.support.v7.h.c.a
    public final Object h(int i2, int i3) {
        AppMethodBeat.i(49227);
        if (i2 >= this.oew.size()) {
            AppMethodBeat.o(49227);
            return null;
        }
        Bundle bundle = new Bundle();
        if (this.oew.get(i2) instanceof AppBrandRecentTaskInfo) {
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.oew.get(i2);
            AppBrandRecentTaskInfo appBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo) this.oex.get(i3);
            if (appBrandRecentTaskInfo.kVp != appBrandRecentTaskInfo2.kVp) {
                bundle.putBoolean("star", appBrandRecentTaskInfo2.kVp);
            }
            if (!Util.nullAsNil(appBrandRecentTaskInfo.kVo).equals(Util.nullAsNil(appBrandRecentTaskInfo2.kVo))) {
                bundle.putString("icon", appBrandRecentTaskInfo2.kVo);
            }
            if (!Util.nullAsNil(appBrandRecentTaskInfo.appName).equals(Util.nullAsNil(appBrandRecentTaskInfo2.appName))) {
                bundle.putString("nick_name", appBrandRecentTaskInfo2.appName);
            }
            if (!Util.nullAsNil(appBrandRecentTaskInfo.kWd).equals(Util.nullAsNil(appBrandRecentTaskInfo2.kWd))) {
                bundle.putString("third_party_app_using_desc", appBrandRecentTaskInfo2.kWd);
            }
        }
        if (bundle.size() <= 0) {
            AppMethodBeat.o(49227);
            return null;
        }
        AppMethodBeat.o(49227);
        return bundle;
    }
}
