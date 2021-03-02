package com.tencent.mm.plugin.appbrand.page.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/navigation/NavigateBackInterceptionInfo;", "", "dialogContent", "", "sceneInfo", "", "Lcom/tencent/mm/plugin/appbrand/page/navigation/SceneInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getDialogContent", "()Ljava/lang/String;", "getSceneInfo", "()Ljava/util/List;", "isEnable", "", "scene", "luggage-wxa-app_release"})
public final class g {
    final String nvR;
    private final List<h> nvS;

    public g() {
        this(null, null, 3);
    }

    public g(String str, List<h> list) {
        p.h(str, "dialogContent");
        p.h(list, "sceneInfo");
        AppMethodBeat.i(219744);
        this.nvR = str;
        this.nvS = list;
        AppMethodBeat.o(219744);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(String str, List list, int i2) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? new ArrayList() : list);
        AppMethodBeat.i(219745);
        AppMethodBeat.o(219745);
    }

    public final boolean adY(String str) {
        AppMethodBeat.i(219743);
        p.h(str, "scene");
        for (h hVar : this.nvS) {
            if (TextUtils.equals(hVar.nvT, str) && hVar.enable) {
                AppMethodBeat.o(219743);
                return true;
            }
        }
        AppMethodBeat.o(219743);
        return false;
    }
}
