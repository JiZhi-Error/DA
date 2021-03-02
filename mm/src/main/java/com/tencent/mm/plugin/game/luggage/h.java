package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class h {
    private static HashMap<String, a> hdu = new HashMap<>();
    private static HashMap<String, p> xws = new HashMap<>();
    private static LinkedList<String> xwt = new LinkedList<>();

    public interface a {
        void callback();
    }

    static {
        AppMethodBeat.i(83024);
        AppMethodBeat.o(83024);
    }

    public static void a(final Class<? extends com.tencent.luggage.webview.a> cls, final String str, final a aVar) {
        AppMethodBeat.i(83020);
        if (!MMApplicationContext.isToolsProcess() && !MMApplicationContext.isToolsMpProcess()) {
            Bundle bundle = new Bundle();
            bundle.putInt("action_id", 1);
            bundle.putString("preload_url", str);
            bundle.putSerializable("webcore_impl_class", cls);
            b.b(bundle, b.class, new d<Bundle>() {
                /* class com.tencent.mm.plugin.game.luggage.h.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(83016);
                    if (aVar != null) {
                        aVar.callback();
                    }
                    AppMethodBeat.o(83016);
                }
            });
            AppMethodBeat.o(83020);
        } else if (xws.containsKey(str)) {
            Log.i("MicroMsg.PreloadGameWebCoreHelp", "preload page[%s] exists, return", str);
            aVar.callback();
            AppMethodBeat.o(83020);
        } else if (xwt.contains(str)) {
            Log.i("MicroMsg.PreloadGameWebCoreHelp", "preload ing, return");
            aVar.callback();
            AppMethodBeat.o(83020);
        } else {
            xwt.add(str);
            com.tencent.mm.ipcinvoker.p.y(new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.h.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(83017);
                    p pVar = new p(MMApplicationContext.getContext(), cls);
                    h.xws.put(str, pVar);
                    h.xwt.remove(str);
                    if (!TextUtils.isEmpty(str)) {
                        Log.i("MicroMsg.PreloadGameWebCoreHelp", "loadUrl: %s", str);
                        pVar.loadUrl(str);
                    }
                    if (aVar != null) {
                        aVar.callback();
                    }
                    AppMethodBeat.o(83017);
                }
            });
            AppMethodBeat.o(83020);
        }
    }

    public static p aI(Context context, String str) {
        AppMethodBeat.i(83021);
        p remove = xws.remove(str);
        if (remove != null) {
            remove.setContext(context);
            remove.LF();
        }
        AppMethodBeat.o(83021);
        return remove;
    }

    public static p azD(String str) {
        AppMethodBeat.i(83022);
        p pVar = xws.get(str);
        AppMethodBeat.o(83022);
        return pVar;
    }

    public static void remove(String str) {
        AppMethodBeat.i(186845);
        if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            p remove = xws.remove(str);
            if (remove != null) {
                remove.LF();
                remove.LH();
            }
            AppMethodBeat.o(186845);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action_id", 2);
        bundle.putString("preload_url", str);
        b.b(bundle, b.class, null);
        AppMethodBeat.o(186845);
    }

    public static void destroy() {
        AppMethodBeat.i(83023);
        if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            for (p pVar : xws.values()) {
                pVar.LF();
                pVar.LH();
            }
            xws.clear();
            AppMethodBeat.o(83023);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action_id", 2);
        b.b(bundle, b.class, null);
        AppMethodBeat.o(83023);
    }

    /* access modifiers changed from: package-private */
    public static class b implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, final d<Bundle> dVar) {
            AppMethodBeat.i(83019);
            Bundle bundle2 = bundle;
            int i2 = bundle2.getInt("action_id");
            String string = bundle2.getString("preload_url");
            switch (i2) {
                case 1:
                    Class cls = (Class) bundle2.getSerializable("webcore_impl_class");
                    if (!TextUtils.isEmpty(string) && cls != null) {
                        h.a(cls, string, new a() {
                            /* class com.tencent.mm.plugin.game.luggage.h.b.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.game.luggage.h.a
                            public final void callback() {
                                AppMethodBeat.i(83018);
                                dVar.bn(new Bundle());
                                AppMethodBeat.o(83018);
                            }
                        });
                        AppMethodBeat.o(83019);
                        return;
                    }
                case 2:
                    if (!Util.isNullOrNil(string)) {
                        h.remove(string);
                        break;
                    } else {
                        h.destroy();
                        AppMethodBeat.o(83019);
                        return;
                    }
            }
            AppMethodBeat.o(83019);
        }
    }
}
