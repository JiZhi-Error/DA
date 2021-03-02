package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.a.c;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/OpenMaterialMimeTypeWhiteList;", "", "()V", "mimeTypeStrWhiteList", "", "", "[Ljava/lang/String;", "mimeTypeWhiteList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/MimeType;", "Lkotlin/collections/ArrayList;", "contains", "", "mimeTypeStr", "plugin-appbrand-integration_release"})
public final class d {
    private static final String[] nlw = {"text/html", "image/*", "audio/*", "video/*", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.ms-word.document.macroEnabled.12", "application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.ms-excel.sheet.macroEnabled.12", "application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/wps-office.wps", "application/wps-office.et", "text/plain", "text/csv", "application/pdf", "application/zip", "application/vnd.rar", "application/x-7z-compressed", "application/x-photoshop", "application/acad", "application/x-cdr", "application/dxf", "application/step", "application/rtf", "application/postscript"};
    private static final ArrayList<c> nlx = new ArrayList<>();
    public static final d nly = new d();

    static {
        AppMethodBeat.i(229153);
        String[] strArr = nlw;
        for (String str : strArr) {
            c.a aVar = c.nlu;
            c adm = c.a.adm(str);
            if (adm != null) {
                nlx.add(adm);
            }
        }
        AppMethodBeat.o(229153);
    }

    private d() {
    }

    public static boolean contains(String str) {
        boolean z;
        AppMethodBeat.i(229152);
        p.h(str, "mimeTypeStr");
        c.a aVar = c.nlu;
        c adm = c.a.adm(str);
        if (adm == null) {
            AppMethodBeat.o(229152);
            return false;
        }
        ArrayList<c> arrayList = nlx;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            for (T t : arrayList) {
                p.h(adm, "mimeType");
                if (!p.j(t.type, adm.type) || (!p.j(t.nls, adm.nls) && !t.bQf())) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    AppMethodBeat.o(229152);
                    return true;
                }
            }
        }
        AppMethodBeat.o(229152);
        return false;
    }
}
