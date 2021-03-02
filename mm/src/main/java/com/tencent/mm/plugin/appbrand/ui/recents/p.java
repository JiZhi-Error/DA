package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wu;
import com.tencent.mm.g.b.a.ko;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import org.apache.commons.b.a;
import org.apache.commons.b.g;

/* access modifiers changed from: package-private */
public final class p {
    boolean oep = false;
    private Intent oeq = null;
    long oer;
    ko oes = null;
    LinkedHashSet<AppBrandRecentTaskInfo> oet = null;
    IListener<wu> oeu;

    p() {
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, Activity activity) {
        AppMethodBeat.i(49281);
        Log.d("MicroMsg.AppBrand.RecentsReporter", "reportExitAction reason[%s]", str);
        if (this.oes != null) {
            long longExtra = activity.getIntent().getLongExtra("extra_start_activity_click_timestamp_ms", this.oer);
            ko koVar = this.oes;
            koVar.eWq = longExtra;
            koVar.eWr = Util.nowMilliSecond();
            if (koVar.eWs <= 0) {
                if ("onDestroy".equals(str)) {
                    koVar.eWs = 1;
                } else {
                    koVar.eWs = (long) T(this.oeq);
                }
            }
            String[] strArr = new String[4];
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList(this.oet);
            for (int i2 = 0; i2 < 4; i2++) {
                linkedList.clear();
                for (int i3 = i2 * 5; i3 < Math.min(arrayList.size(), (i2 + 1) * 5); i3++) {
                    linkedList.addLast(((AppBrandRecentTaskInfo) arrayList.get(i3)).appId);
                }
                strArr[i2] = g.a(linkedList, "|");
            }
            this.oes.xW(strArr[0]);
            this.oes.xX(strArr[1]);
            this.oes.xY(strArr[2]);
            this.oes.xZ(strArr[3]);
            koVar.bfK();
            this.oes = null;
        }
        if (this.oeu != null) {
            this.oeu.dead();
            this.oeu = null;
        }
        AppMethodBeat.o(49281);
    }

    private static int T(Intent intent) {
        AppMethodBeat.i(49282);
        if (intent != null) {
            try {
                if (intent.getComponent() != null) {
                    String shortClassName = intent.getComponent().getShortClassName();
                    if (Util.isNullOrNil(shortClassName)) {
                        AppMethodBeat.o(49282);
                        return 0;
                    }
                    String substring = shortClassName.substring(shortClassName.lastIndexOf(46) + 1);
                    if (a.contains(new String[]{"AppBrandNearbyEmptyUI", "AppBrandNearbyWebViewUI"}, substring)) {
                        AppMethodBeat.o(49282);
                        return 3;
                    }
                    if (a.contains(new String[]{"AppBrandSearchUI"}, substring)) {
                        AppMethodBeat.o(49282);
                        return 5;
                    } else if ("AppBrandLauncherFolderUI".equals(substring)) {
                        switch (intent.getIntExtra("KEY_MODE", 0)) {
                            case 2:
                                AppMethodBeat.o(49282);
                                return 4;
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.RecentsReporter", "makeFromMainFrameExitReportLeaveType e=%s", e2);
                AppMethodBeat.o(49282);
                return 0;
            }
        }
        AppMethodBeat.o(49282);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void U(Intent intent) {
        this.oeq = intent;
        this.oep = true;
    }
}
