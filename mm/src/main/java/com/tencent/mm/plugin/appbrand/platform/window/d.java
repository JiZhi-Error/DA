package com.tencent.mm.plugin.appbrand.platform.window;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveConstants;

public interface d {

    public interface b {
        ViewGroup cB(View view);
    }

    @Deprecated
    public interface c {
        void a(e.b bVar);
    }

    void N(View view, int i2);

    void a(WebChromeClient.CustomViewCallback customViewCallback);

    void a(b bVar);

    void b(b bVar);

    boolean bTK();

    boolean btC();

    void release();

    void vH(int i2);

    public static class a {

        /* renamed from: com.tencent.mm.plugin.appbrand.platform.window.d$a$a  reason: collision with other inner class name */
        class C0790a {
            C0790a() {
            }

            static int yY(int i2) {
                switch (i2) {
                    case 0:
                        return 90;
                    case 8:
                        return -90;
                    case 9:
                        return TXLiveConstants.RENDER_ROTATION_180;
                    default:
                        return 0;
                }
            }
        }

        public static int yX(int i2) {
            AppMethodBeat.i(219572);
            new C0790a();
            int yY = C0790a.yY(i2);
            Log.i("Luggage.WXA.WindowFullscreenHandler.Factory", "convertActivityOrientation2Direction [%d]->[%d]", Integer.valueOf(i2), Integer.valueOf(yY));
            AppMethodBeat.o(219572);
            return yY;
        }
    }
}
