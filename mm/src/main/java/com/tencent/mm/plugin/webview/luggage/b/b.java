package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.game.report.f;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.y;
import com.tencent.mm.plugin.webview.model.at;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONObject;

public final class b extends a {
    public b() {
        super(29);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(final Context context, final g gVar) {
        String str;
        AppMethodBeat.i(78681);
        Bundle bundle = new Bundle();
        y yVar = gVar.ITH;
        if (Util.isNullOrNil(yVar.iconUrl)) {
            String icon = gVar.ITw.getIcon();
            if (Util.isNullOrNil(icon)) {
                AppMethodBeat.o(78681);
                return;
            }
            int lastIndexOf = icon.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
            if (lastIndexOf != -1) {
                str = icon.substring(0, lastIndexOf) + "/0";
            } else {
                str = icon;
            }
            Log.i("MicroMsg.MenuDelegate_AddShortcut", "rawIconUrl : %s, newIconUrl : %s", icon, str);
            bundle.putString("icon_url", str);
        } else {
            bundle.putString("icon_url", yVar.iconUrl);
        }
        if (Util.isNullOrNil(yVar.jumpUrl)) {
            bundle.putString("page_url", aYz(gVar.coX()));
        } else {
            bundle.putString("page_url", yVar.iconUrl);
        }
        if (Util.isNullOrNil(yVar.title)) {
            bundle.putString("title", gVar.getTitle());
        } else {
            bundle.putString("title", yVar.title);
        }
        h.a(MainProcessIPCService.dkO, bundle, a.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.webview.luggage.b.b.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                AppMethodBeat.i(78677);
                final boolean z = bundle.getBoolean("success");
                gVar.ctS.a(new com.tencent.luggage.d.d() {
                    /* class com.tencent.mm.plugin.webview.luggage.b.b.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.luggage.d.d
                    public final String name() {
                        return "onAddShortcutStatus";
                    }

                    @Override // com.tencent.luggage.d.d
                    public final JSONObject Ld() {
                        AppMethodBeat.i(78674);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("success", z);
                        } catch (Exception e2) {
                        }
                        AppMethodBeat.o(78674);
                        return jSONObject;
                    }
                });
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.luggage.b.b.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(78676);
                        if (z) {
                            com.tencent.mm.ui.base.h.a(context, (int) R.string.j42, (int) R.string.zb, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.webview.luggage.b.b.AnonymousClass1.AnonymousClass2.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(78675);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(78675);
                                }
                            });
                            AppMethodBeat.o(78676);
                            return;
                        }
                        Toast.makeText(context, context.getString(R.string.j41), 0).show();
                        AppMethodBeat.o(78676);
                    }
                });
                AppMethodBeat.o(78677);
            }
        });
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(cd.CTRL_INDEX, 12);
        f.a(context, 34, 3401, 1, 2, 0, f.aq("url", gVar.coX()));
        AppMethodBeat.o(78681);
    }

    static class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, final d<Bundle> dVar) {
            AppMethodBeat.i(78679);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("icon_url");
            String string2 = bundle2.getString("page_url");
            String string3 = bundle2.getString("title");
            AnonymousClass1 r3 = new at.a() {
                /* class com.tencent.mm.plugin.webview.luggage.b.b.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.webview.model.at.a
                public final void zf(boolean z) {
                    AppMethodBeat.i(78678);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("success", z);
                    dVar.bn(bundle);
                    AppMethodBeat.o(78678);
                }
            };
            if (Util.isNullOrNil(string2) || Util.isNullOrNil(string3) || Util.isNullOrNil(string)) {
                Log.e("MicroMsg.WebViewShortcutManager", "url is null");
                at.a(r3, false);
                AppMethodBeat.o(78679);
                return;
            }
            com.tencent.mm.plugin.base.model.b.q(MMApplicationContext.getContext(), at.a(null, string2, string3, false));
            com.tencent.mm.av.a.a.bdb().a(string, (ImageView) null, new com.tencent.mm.av.a.c.h(string2, string3, r3) {
                /* class com.tencent.mm.plugin.webview.model.at.AnonymousClass1 */
                final /* synthetic */ a IZt;
                final /* synthetic */ String dqb;
                final /* synthetic */ String val$url;

                {
                    this.val$url = r1;
                    this.dqb = r2;
                    this.IZt = r3;
                }

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view) {
                }

                @Override // com.tencent.mm.av.a.c.h
                public final Bitmap a(String str, View view, b bVar) {
                    return null;
                }

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view, b bVar) {
                    AppMethodBeat.i(79041);
                    if (bVar.status != 0 || bVar.bitmap == null) {
                        at.a(this.IZt, false);
                        AppMethodBeat.o(79041);
                        return;
                    }
                    int density = (int) (com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext()) * 48.0f);
                    Bitmap bitmap = null;
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bVar.bitmap, density, density, false);
                    if (createScaledBitmap != null) {
                        bitmap = createScaledBitmap.copy(Bitmap.Config.ARGB_8888, true);
                        Log.i("MicroMsg.WebViewShortcutManager", "bitmap recycle %s", createScaledBitmap);
                        createScaledBitmap.recycle();
                    }
                    final Intent a2 = at.a(bitmap, this.val$url, this.dqb, true);
                    if (a2 == null) {
                        Log.e("MicroMsg.WebViewShortcutManager", "intent is null");
                        at.a(this.IZt, false);
                        AppMethodBeat.o(79041);
                        return;
                    }
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.model.at.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(79040);
                            com.tencent.mm.plugin.base.model.b.p(MMApplicationContext.getContext(), a2);
                            AppMethodBeat.o(79040);
                        }
                    }, 500);
                    at.a(this.IZt, true);
                    AppMethodBeat.o(79041);
                }
            });
            AppMethodBeat.o(78679);
        }
    }

    private static String aYz(String str) {
        String str2;
        String str3;
        AppMethodBeat.i(78682);
        Uri parse = Uri.parse(str);
        String query = parse.getQuery();
        if (Util.isNullOrNil(query)) {
            str2 = "ssid=25";
        } else if (query.contains("ssid=")) {
            str2 = query.replaceFirst("ssid=[0-9]*", "ssid=25");
        } else {
            str2 = query + "&ssid=25";
        }
        try {
            str3 = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str2, parse.getFragment()).toString();
        } catch (URISyntaxException e2) {
            Log.printErrStackTrace("MicroMsg.MenuDelegate_AddShortcut", e2, "", new Object[0]);
            str3 = str;
        }
        Log.d("MicroMsg.MenuDelegate_AddShortcut", "rawUrl : %s, newUrl : %s", str, str3);
        AppMethodBeat.o(78682);
        return str3;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar, m mVar) {
        AppMethodBeat.i(78680);
        boolean z = gVar.mParams.getBoolean("from_shortcut", false);
        y yVar = gVar.ITH;
        String title = Util.isNullOrNil(yVar.title) ? gVar.getTitle() : yVar.title;
        String icon = Util.isNullOrNil(yVar.iconUrl) ? gVar.ITw.getIcon() : yVar.iconUrl;
        if (!z && !Util.isNullOrNil(title) && !Util.isNullOrNil(icon) && gVar.Oc(255)) {
            mVar.b(29, context.getString(R.string.fti), R.raw.webview_add_shortcut);
            f.a(context, 34, 3401, 1, 1, 0, f.aq("url", gVar.coX()));
        }
        AppMethodBeat.o(78680);
    }
}
