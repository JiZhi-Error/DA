package com.tencent.mm.plugin.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.ad;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.m;
import com.tencent.mm.al.q;
import com.tencent.mm.api.k;
import com.tencent.mm.api.l;
import com.tencent.mm.api.n;
import com.tencent.mm.api.o;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.i;
import com.tencent.mm.model.r;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI;
import com.tencent.mm.plugin.biz.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.pluginsdk.ui.applet.x;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.t;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.util.HashMap;

public class PluginBiz extends f implements a, c, b {
    public static long startTime = 0;

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(124338);
        alias(b.class);
        AppMethodBeat.o(124338);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(124339);
        dependsOn(s.class);
        dependsOn(com.tencent.mm.plugin.teenmode.a.a.class);
        AppMethodBeat.o(124339);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(124340);
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.a(q.class, new e(new m()));
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.biz.a.a.class, new a());
            com.tencent.mm.msgsubscription.api.b bVar = com.tencent.mm.msgsubscription.api.b.jza;
            com.tencent.mm.msgsubscription.api.b.a("name_biz", new com.tencent.mm.msgsubscription.b.a(com.tencent.mm.msgsubscription.d.c.jAF) {
                /* class com.tencent.mm.plugin.biz.PluginBiz.AnonymousClass1 */

                @Override // com.tencent.mm.msgsubscription.b.a
                public final void a(Context context, int i2, String str, String str2) {
                    AppMethodBeat.i(212210);
                    Intent intent = new Intent(context, BizSubscribeMsgManagerUI.class);
                    intent.putExtra("key_biz_username", str);
                    intent.putExtra("key_biz_nickname", str2);
                    intent.putExtra("key_biz_presenter_class", com.tencent.mm.al.b.a.class.getName());
                    intent.putExtra("key_need_update", true);
                    intent.putExtra("key_need_load_from_remote", true);
                    intent.putExtra("key_enter_scene", i2);
                    com.tencent.mm.br.c.f(context, "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", intent);
                    AppMethodBeat.o(212210);
                }
            });
            y.a("bizimg/", "bizimg/", TPAudioFrame.TP_CH_STEREO_LEFT, 7776000000L, 75);
            Log.i("VFS.Debug", "bizimg FS registered");
            y.b("brandicon/", "brandicon/", 7776000000L, 3);
            y.b("bizcache/", "bizcache/", 2592000000L, 67);
            y.b("webcanvascache/", "webcanvascache/", 2592000000L, 67);
            y.at("openapi/", "openapi/", 3);
            y.b("openapi_cache/", "openapi_cache/", 7776000000L, 67);
            EventCenter.instance.add(new ad());
        }
        x.a.Kge = new d();
        AppMethodBeat.o(124340);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(124341);
        if (gVar.aBb()) {
            pin(new com.tencent.mm.model.y(ag.class));
            com.tencent.mm.kernel.g.b(k.class, new com.tencent.mm.model.g());
            com.tencent.mm.kernel.g.b(l.class, new i());
            com.tencent.mm.kernel.g.b(n.class, new com.tencent.mm.model.k());
            com.tencent.mm.kernel.g.a(o.class, new e(new com.tencent.mm.model.l()));
            com.tencent.mm.kernel.g.b(com.tencent.mm.api.q.class, com.tencent.mm.model.q.iCq);
        }
        if (gVar.FY(":tools") || gVar.FY(":toolsmp") || gVar.FZ(":appbrand")) {
            com.tencent.mm.kernel.g.b(com.tencent.mm.api.q.class, new r());
        }
        if (gVar.FY(":tools") || gVar.FY(":toolsmp")) {
            com.tencent.mm.kernel.g.b(ISubscribeMsgService.class, new com.tencent.mm.msgsubscription.b.a.b());
        }
        startTime = System.currentTimeMillis();
        AppMethodBeat.o(124341);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(124342);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("BIZ_MESSAGE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.biz.PluginBiz.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return t.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("BIZ_TIME_LINE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.biz.PluginBiz.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return aa.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("BIZ_TIME_LINE_SINGLE_MSG_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.biz.PluginBiz.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return ae.SQL_CREATE;
            }
        });
        AppMethodBeat.o(124342);
        return hashMap;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(212211);
        com.tencent.mm.model.q qVar = com.tencent.mm.model.q.iCq;
        com.tencent.mm.model.q.init();
        AppMethodBeat.o(212211);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(212212);
        com.tencent.mm.model.q qVar = com.tencent.mm.model.q.iCq;
        com.tencent.mm.model.q.release();
        AppMethodBeat.o(212212);
    }
}
