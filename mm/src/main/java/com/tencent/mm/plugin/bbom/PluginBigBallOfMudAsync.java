package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.app.ak;
import com.tencent.mm.app.al;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.as;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.bbom.a.a;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView;
import com.tencent.mm.plugin.webview.ui.tools.widget.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.g;
import com.tencent.mm.plugin.webview.ui.tools.widget.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.x;
import java.util.ArrayList;
import java.util.List;

public class PluginBigBallOfMudAsync extends f implements a {
    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-big-ball-of-mud-async";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(22428);
        alias(a.class);
        AppMethodBeat.o(22428);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(22429);
        dependsOn(PluginBigBallOfMud.class);
        if (MMApplicationContext.isMainProcess()) {
            dependsOn(com.tencent.mm.plugin.notification.b.a.class);
        }
        AppMethodBeat.o(22429);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(22430);
        if (gVar.aBb() && ((h) gVar).mProfileCompat != null) {
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).setNotification(((WorkerProfile) ((h) gVar).mProfileCompat).getNotification());
        }
        ab.a.Kgn = new ab() {
            /* class com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.ab
            public final d a(t tVar, String str, String str2, String str3, boolean z, String str4, y.a aVar) {
                AppMethodBeat.i(22418);
                d a2 = o.a(tVar, str, str2, str3, z, str4, aVar);
                AppMethodBeat.o(22418);
                return a2;
            }
        };
        w.a.a(new w() {
            /* class com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.AnonymousClass2 */

            @Override // com.tencent.mm.ag.w
            public final Pair<Integer, Long> a(k.b bVar, String str, String str2, String str3, String str4, byte[] bArr) {
                AppMethodBeat.i(22419);
                Pair<Integer, Long> a2 = m.a(bVar, str, str2, str3, str4, bArr);
                AppMethodBeat.o(22419);
                return a2;
            }
        });
        e.a.KqE = new e() {
            /* class com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.AnonymousClass3 */

            @Override // com.tencent.mm.pluginsdk.ui.span.e
            public final void a(Context context, String str, DialogInterface.OnDismissListener onDismissListener, Bundle bundle) {
                AppMethodBeat.i(22421);
                n.a(context, str, onDismissListener, bundle);
                AppMethodBeat.o(22421);
            }

            @Override // com.tencent.mm.pluginsdk.ui.span.e
            public final void a(Context context, List<String> list, e.b bVar) {
                AppMethodBeat.i(22420);
                if (list.isEmpty() || context == null) {
                    AppMethodBeat.o(22420);
                    return;
                }
                new l(context).a(null, new View.OnCreateContextMenuListener(list) {
                    /* class com.tencent.mm.pluginsdk.ui.span.n.AnonymousClass3 */
                    final /* synthetic */ List Krl;

                    {
                        this.Krl = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(31923);
                        for (String str : this.Krl) {
                            contextMenu.add(0, 0, 0, str);
                        }
                        AppMethodBeat.o(31923);
                    }
                }, new o.g(context) {
                    /* class com.tencent.mm.pluginsdk.ui.span.n.AnonymousClass4 */
                    final /* synthetic */ Context val$context;

                    {
                        this.val$context = r1;
                    }

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(31924);
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(menuItem.getTitle().toString().replace(" ", "").replace("(", "").replace(")", "").replace("-", "")))));
                        intent.addFlags(268435456);
                        if (Util.isIntentAvailable(this.val$context, intent)) {
                            Context context = this.val$context;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                        AppMethodBeat.o(31924);
                    }
                }, bVar);
                AppMethodBeat.o(22420);
            }
        };
        f.a.Jys = new com.tencent.mm.plugin.webview.ui.tools.widget.f() {
            /* class com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.f
            public final MMWebView eK(Context context) {
                AppMethodBeat.i(22422);
                MMWebViewWithJsApi hZ = MMWebViewWithJsApi.a.hZ(context);
                AppMethodBeat.o(22422);
                return hZ;
            }
        };
        g.a.Jyt = new com.tencent.mm.plugin.webview.ui.tools.widget.g() {
            /* class com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.g
            public final MMWebView eK(Context context) {
                AppMethodBeat.i(22423);
                MailMMWebView.bQ(context);
                MailMMWebView mailMMWebView = new MailMMWebView(context);
                mailMMWebView.gKM = true;
                AppMethodBeat.o(22423);
                return mailMMWebView;
            }
        };
        c.a.Jyr = new c() {
            /* class com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.c
            public final ac a(MMWebView mMWebView, boolean z, com.tencent.mm.plugin.webview.ui.tools.widget.d dVar) {
                AppMethodBeat.i(22424);
                com.tencent.mm.plugin.webview.ui.tools.widget.l lVar = new com.tencent.mm.plugin.webview.ui.tools.widget.l(mMWebView, z, dVar);
                AppMethodBeat.o(22424);
                return lVar;
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.c
            public final ac a(MMWebView mMWebView, com.tencent.mm.plugin.webview.ui.tools.widget.d dVar, Bundle bundle) {
                AppMethodBeat.i(22425);
                com.tencent.mm.plugin.webview.ui.tools.widget.l lVar = new com.tencent.mm.plugin.webview.ui.tools.widget.l(mMWebView, false, dVar, bundle);
                AppMethodBeat.o(22425);
                return lVar;
            }
        };
        a.C2003a.Jyq = new com.tencent.mm.plugin.webview.ui.tools.widget.a() {
            /* class com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.a
            public final x a(MMWebView mMWebView, b bVar) {
                AppMethodBeat.i(22426);
                j jVar = new j(mMWebView, bVar);
                AppMethodBeat.o(22426);
                return jVar;
            }
        };
        com.tencent.mm.kernel.g.b(ad.class, new i());
        com.tencent.mm.kernel.g.b(v.class, new com.tencent.mm.pluginsdk.model.f());
        if (((h) gVar).mProfileCompat != null && gVar.aBb()) {
            WorkerProfile workerProfile = (WorkerProfile) ((h) gVar).mProfileCompat;
            al alVar = workerProfile.dnw;
            ak akVar = workerProfile.dnx;
            com.tencent.mm.br.b.KxT = alVar;
            com.tencent.mm.br.b.KxU = akVar;
            new com.tencent.mm.plugin.e.e(workerProfile).before(this).after(com.tencent.mm.kernel.g.ah(s.class));
        }
        if (gVar.aBb()) {
            ((s) com.tencent.mm.kernel.g.ah(s.class)).setIDataTransferFactoryDelegate(new at() {
                /* class com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync.AnonymousClass8 */

                @Override // com.tencent.mm.model.at
                public final List<as> getDataTransferList() {
                    AppMethodBeat.i(22427);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new com.tencent.mm.ao.d());
                    arrayList.add(new com.tencent.mm.ao.f());
                    arrayList.add(new com.tencent.mm.ao.e());
                    arrayList.add(new com.tencent.mm.ao.a());
                    arrayList.add(new com.tencent.mm.ao.c());
                    arrayList.add(new com.tencent.mm.ao.g());
                    arrayList.add(new com.tencent.mm.ao.b());
                    AppMethodBeat.o(22427);
                    return arrayList;
                }
            });
        }
        AppMethodBeat.o(22430);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(22431);
        if (((h) gVar).mProfileCompat != null && gVar.aBb()) {
            Log.i("MicroMsg.PluginBigBallOfMudAsync", "before WorkerProfile oncreate.");
            ((h) gVar).mProfileCompat.onCreate();
        }
        if (gVar.aBb()) {
            ((com.tencent.mm.plugin.welab.a.a.d) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs1de6f3", new com.tencent.mm.plugin.welab.c.b());
            ((com.tencent.mm.plugin.welab.a.a.d) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.d.class)).a(new com.tencent.mm.plugin.welab.e.a());
            ((com.tencent.mm.plugin.welab.a.a.d) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs_browse", new com.tencent.mm.plugin.welab.c.a());
        }
        AppMethodBeat.o(22431);
    }
}
