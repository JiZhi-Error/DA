package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0007H&¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "Lcom/tencent/luggage/base/ICustomize;", "doReport", "", "isConnectSuccess", "", "deviceName", "", "manufactureName", "caseId", "", "deviceCount", "getFullscreenStatusListener", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "setAppId", "appId", "setPagePath", "pagePath", "setVideoPath", "path", "luggage-xweb-ext_release"})
public interface c extends b {
    void a(boolean z, String str, String str2, int i2);

    void abO(String str);

    com.tencent.mm.plugin.appbrand.platform.window.b bMn();

    void er(int i2, int i3);

    void setAppId(String str);

    void setVideoPath(String str);

    void xV(int i2);

    @l(hxD = {1, 1, 16})
    public static final class a {
        public static /* synthetic */ void a(c cVar, boolean z, int i2) {
            AppMethodBeat.i(139682);
            cVar.a(z, "", "", i2);
            AppMethodBeat.o(139682);
        }
    }
}
