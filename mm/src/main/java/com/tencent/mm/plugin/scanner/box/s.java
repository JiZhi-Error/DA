package com.tencent.mm.plugin.scanner.box;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\"\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanShareReporter;", "", "()V", "TAG", "", "reportScanShareCancel", "", "data", "Landroid/os/Bundle;", "reportScanShareResult", "success", "", "isChatRoom", "ShareResult", "plugin-scan_release"})
public final class s {
    public static final s CDz = new s();

    static {
        AppMethodBeat.i(240340);
        AppMethodBeat.o(240340);
    }

    private s() {
    }

    public static final void b(boolean z, boolean z2, Bundle bundle) {
        String str;
        String str2;
        String str3;
        int i2;
        AppMethodBeat.i(240338);
        if (z) {
            if (bundle == null || (str = bundle.getString("enter_session")) == null) {
                str = "";
            }
            p.g(str, "data?.getString(ScanBoxM….KEY_ENTER_SESSION) ?: \"\"");
            if (bundle == null || (str2 = bundle.getString("tab_session")) == null) {
                str2 = "";
            }
            p.g(str2, "data?.getString(ScanBoxM…er.KEY_TAB_SESSION) ?: \"\"");
            if (bundle == null || (str3 = bundle.getString("scan_session")) == null) {
                str3 = "";
            }
            p.g(str3, "data?.getString(ScanBoxM…r.KEY_SCAN_SESSION) ?: \"\"");
            if (z2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            h.INSTANCE.a(21537, str2, str3, Integer.valueOf(i2), str);
        }
        AppMethodBeat.o(240338);
    }

    public static final void aw(Bundle bundle) {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(240339);
        if (bundle == null || (str = bundle.getString("enter_session")) == null) {
            str = "";
        }
        p.g(str, "data?.getString(ScanBoxM….KEY_ENTER_SESSION) ?: \"\"");
        if (bundle == null || (str2 = bundle.getString("tab_session")) == null) {
            str2 = "";
        }
        p.g(str2, "data?.getString(ScanBoxM…er.KEY_TAB_SESSION) ?: \"\"");
        if (bundle == null || (str3 = bundle.getString("scan_session")) == null) {
            str3 = "";
        }
        p.g(str3, "data?.getString(ScanBoxM…r.KEY_SCAN_SESSION) ?: \"\"");
        h.INSTANCE.a(21537, str2, str3, 3, str);
        AppMethodBeat.o(240339);
    }
}
