package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.downloader_app.api.b;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class o {

    public interface a {
        void i(String str, JSONObject jSONObject);
    }

    public static void a(final Context context, final com.tencent.mm.plugin.downloader_app.a.a aVar, final a aVar2) {
        boolean z;
        FileDownloadTaskInfo Co;
        boolean z2 = true;
        AppMethodBeat.i(89064);
        if (aVar == null || !aVar.isValid()) {
            aVar2.i("fail", null);
            AppMethodBeat.o(89064);
        } else if (!NetStatusUtil.isNetworkConnected(context)) {
            aVar2.i("network_not_connected", null);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(89046);
                    Toast.makeText(context, context.getString(R.string.dom), 0).show();
                    AppMethodBeat.o(89046);
                }
            });
            Log.i("MicroMsg.JsApiGameDownloadManager", " fail, network not ready");
            AppMethodBeat.o(89064);
        } else if (!e.apn()) {
            aVar2.i("sdcard_not_ready", null);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass12 */

                public final void run() {
                    AppMethodBeat.i(89056);
                    Toast.makeText(context, context.getString(R.string.doq), 0).show();
                    AppMethodBeat.o(89056);
                }
            });
            Log.i("MicroMsg.JsApiGameDownloadManager", " fail, sdcard not ready");
            AppMethodBeat.o(89064);
        } else if (aVar.qKv <= 0 || h.CF(aVar.qKv) || h.CE(aVar.qKv)) {
            if (!aVar.qKA || !((b) g.af(b.class)).a(b.a.clicfg_download_game_ignore_network, false)) {
                z = false;
            } else {
                z = true;
            }
            com.tencent.mm.plugin.downloader.g.a ale = d.ale(aVar.downloadUrl);
            JSONObject jSONObject = new JSONObject();
            if (!(ale == null || (Co = f.cBv().Co(ale.field_downloadId)) == null)) {
                if (Co.status == 1) {
                    try {
                        jSONObject.put("download_id", Co.id);
                    } catch (JSONException e2) {
                    }
                    aVar2.i(null, jSONObject);
                    AppMethodBeat.o(89064);
                    return;
                } else if (Co.status == 3) {
                    com.tencent.mm.plugin.downloader.i.a.a(Co.id, false, null);
                    try {
                        jSONObject.put("download_id", Co.id);
                    } catch (JSONException e3) {
                    }
                    aVar2.i(null, jSONObject);
                    AppMethodBeat.o(89064);
                    return;
                } else if (z) {
                    a(ale, NetStatusUtil.isWifi(context), aVar.qKA, aVar2);
                } else if (aVar.qJg && ale.field_reserveInWifi && !NetStatusUtil.isWifi(context)) {
                    a(context, ale.field_downloadId, aVar.qKA, aVar2);
                    AppMethodBeat.o(89064);
                    return;
                }
            }
            if (z) {
                if (!NetStatusUtil.isWifi(context)) {
                    z2 = false;
                }
                a(aVar, aVar2, z2);
                AppMethodBeat.o(89064);
            } else if (NetStatusUtil.isWifi(context)) {
                a(aVar, aVar2, false);
                AppMethodBeat.o(89064);
            } else if (aVar.qJg) {
                final PBool pBool = new PBool();
                ((com.tencent.mm.plugin.downloader_app.api.b) g.af(com.tencent.mm.plugin.downloader_app.api.b.class)).a(context, aVar.appId, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass15 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(89058);
                        pBool.value = true;
                        o.a(aVar, aVar2, false);
                        AppMethodBeat.o(89058);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass16 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(89059);
                        pBool.value = true;
                        o.a(aVar, aVar2, true);
                        AppMethodBeat.o(89059);
                    }
                }, new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass17 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(89060);
                        if (pBool.value) {
                            AppMethodBeat.o(89060);
                            return;
                        }
                        aVar2.i("cancel", null);
                        AppMethodBeat.o(89060);
                    }
                });
                AppMethodBeat.o(89064);
            } else {
                h.a(context, context.getString(R.string.iyr), context.getString(R.string.iys), context.getString(R.string.iym), context.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass18 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(89061);
                        o.a(aVar, aVar2, false);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(89061);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass19 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(89062);
                        dialogInterface.dismiss();
                        aVar2.i("network_not_wifi", null);
                        AppMethodBeat.o(89062);
                    }
                }, (int) R.color.afp);
                AppMethodBeat.o(89064);
            }
        } else {
            aVar2.i("has_not_enough_space", null);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass14 */

                public final void run() {
                    AppMethodBeat.i(89057);
                    Toast.makeText(context, context.getString(R.string.don), 0).show();
                    AppMethodBeat.o(89057);
                }
            });
            Log.i("MicroMsg.JsApiGameDownloadManager", "fail, not enough space, require size = " + aVar.qKv);
            AppMethodBeat.o(89064);
        }
    }

    static void a(final com.tencent.mm.plugin.downloader_app.a.a aVar, final a aVar2, boolean z) {
        AppMethodBeat.i(89065);
        aVar.qJg = z;
        ((c) g.af(c.class)).a(aVar, new a.b() {
            /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass20 */

            @Override // com.tencent.mm.plugin.downloader_app.api.a.b
            public final void a(a.EnumC0947a aVar, long j2) {
                AppMethodBeat.i(89063);
                JSONObject jSONObject = new JSONObject();
                if (aVar == a.EnumC0947a.OK) {
                    d.d(10, "LuggageGameWebViewUI_addGameDownloadTask", "JsApiGameDownloadManager".hashCode());
                    try {
                        jSONObject.put("download_id", j2);
                        o.j(aVar.qKA, jSONObject);
                        aVar2.i(null, jSONObject);
                        AppMethodBeat.o(89063);
                    } catch (JSONException e2) {
                        aVar2.i(null, null);
                        AppMethodBeat.o(89063);
                    }
                } else if (aVar == a.EnumC0947a.WAIT_FOR_WIFI) {
                    try {
                        jSONObject.put("download_id", j2);
                        jSONObject.put("reserve_for_wifi", 1);
                        aVar2.i(null, jSONObject);
                        AppMethodBeat.o(89063);
                    } catch (JSONException e3) {
                        aVar2.i(null, null);
                        AppMethodBeat.o(89063);
                    }
                } else if (aVar == a.EnumC0947a.CANCEL) {
                    aVar2.i("cancel", null);
                    AppMethodBeat.o(89063);
                } else {
                    if (aVar == a.EnumC0947a.FAIL) {
                        aVar2.i("fail", null);
                    }
                    AppMethodBeat.o(89063);
                }
            }
        });
        AppMethodBeat.o(89065);
    }

    public static void a(Context context, long j2, boolean z, final boolean z2, final a aVar) {
        boolean z3;
        AppMethodBeat.i(192267);
        if (j2 <= 0) {
            Log.e("MicroMsg.JsApiGameDownloadManager", "fail, invalid downloadId = ".concat(String.valueOf(j2)));
            aVar.i("invalid_downloadid", null);
            AppMethodBeat.o(192267);
            return;
        }
        final com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null) {
            aVar.i("fail", null);
            AppMethodBeat.o(192267);
            return;
        }
        FileDownloadTaskInfo Co = f.cBv().Co(Cw.field_downloadId);
        if (Co != null) {
            if (Co.status == 1) {
                aVar.i(null, null);
                AppMethodBeat.o(192267);
                return;
            } else if (Co.status == 3) {
                com.tencent.mm.plugin.downloader.i.a.a(Co.id, false, null);
                aVar.i(null, null);
                AppMethodBeat.o(192267);
                return;
            }
        }
        if (!z2 || !((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_download_game_ignore_network, false)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (NetStatusUtil.isWifi(context)) {
            a(Cw, false, z2, aVar);
            AppMethodBeat.o(192267);
        } else if (!z) {
            if (Cw.field_reserveInWifi) {
                Cw.field_downloadInWifi = false;
                Cw.field_reserveInWifi = false;
                d.e(Cw);
            }
            h.a(context, context.getString(R.string.iyr), context.getString(R.string.iys), context.getString(R.string.iym), context.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(89050);
                    o.a(Cw, false, z2, aVar);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(89050);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(89051);
                    dialogInterface.dismiss();
                    aVar.i("fail_network_not_wifi", null);
                    AppMethodBeat.o(89051);
                }
            }, (int) R.color.afp);
            AppMethodBeat.o(192267);
        } else if (Cw.field_reserveInWifi) {
            a(context, Cw.field_downloadId, z2, aVar);
            AppMethodBeat.o(192267);
        } else if (z3) {
            a(Cw, false, z2, aVar);
            AppMethodBeat.o(192267);
        } else {
            final PBool pBool = new PBool();
            ((com.tencent.mm.plugin.downloader_app.api.b) g.af(com.tencent.mm.plugin.downloader_app.api.b.class)).a(context, Cw.field_appId, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(89047);
                    pBool.value = true;
                    o.a(Cw, false, z2, aVar);
                    AppMethodBeat.o(89047);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(89048);
                    pBool.value = true;
                    o.a(Cw, true, z2, aVar);
                    AppMethodBeat.o(89048);
                }
            }, new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(89049);
                    if (pBool.value) {
                        AppMethodBeat.o(89049);
                        return;
                    }
                    aVar.i("cancel", null);
                    AppMethodBeat.o(89049);
                }
            });
            AppMethodBeat.o(192267);
        }
    }

    static void a(com.tencent.mm.plugin.downloader.g.a aVar, final boolean z, final boolean z2, final a aVar2) {
        AppMethodBeat.i(192268);
        d.d(10, "LuggageGameWebViewUI_resumeGameDownloadTask", "JsApiGameDownloadManager".hashCode());
        ((c) g.af(c.class)).a(aVar.field_downloadId, z, new a.b() {
            /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.downloader_app.api.a.b
            public final void a(a.EnumC0947a aVar, long j2) {
                AppMethodBeat.i(192263);
                if (aVar == a.EnumC0947a.OK) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("download_id", j2);
                        o.j(z2, jSONObject);
                        if (z && !NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                            jSONObject.put("reserve_for_wifi", 1);
                        }
                    } catch (JSONException e2) {
                    }
                    aVar2.i(null, jSONObject);
                    AppMethodBeat.o(192263);
                } else if (aVar == a.EnumC0947a.CANCEL) {
                    aVar2.i("cancel", null);
                    AppMethodBeat.o(192263);
                } else {
                    aVar2.i("fail", null);
                    AppMethodBeat.o(192263);
                }
            }
        });
        AppMethodBeat.o(192268);
    }

    private static void a(Context context, final long j2, final boolean z, final a aVar) {
        AppMethodBeat.i(192269);
        final com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null) {
            aVar.i("fail", null);
            AppMethodBeat.o(192269);
            return;
        }
        final PBool pBool = new PBool();
        final JSONObject jSONObject = new JSONObject();
        ((com.tencent.mm.plugin.downloader_app.api.b) g.af(com.tencent.mm.plugin.downloader_app.api.b.class)).a(context, Cw.field_appId, new b.a() {
            /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass10 */

            @Override // com.tencent.mm.plugin.downloader_app.api.b.a
            public final void onClick() {
                AppMethodBeat.i(192264);
                pBool.value = true;
                o.a(Cw, false, z, aVar);
                AppMethodBeat.o(192264);
            }
        }, new b.a() {
            /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.downloader_app.api.b.a
            public final void onClick() {
                AppMethodBeat.i(192265);
                pBool.value = true;
                try {
                    jSONObject.put("reserve_for_wifi", 0);
                    jSONObject.put("download_id", j2);
                } catch (JSONException e2) {
                }
                com.tencent.mm.plugin.downloader.g.a aVar = Cw;
                Cw.field_downloadInWifi = false;
                aVar.field_reserveInWifi = false;
                d.e(Cw);
                if (Cw.field_status == 0) {
                    ((c) g.af(c.class)).EN(Cw.field_appId);
                }
                aVar.i(null, jSONObject);
                AppMethodBeat.o(192265);
            }
        }, new b.a() {
            /* class com.tencent.mm.plugin.downloader.model.o.AnonymousClass13 */

            @Override // com.tencent.mm.plugin.downloader_app.api.b.a
            public final void onClick() {
                AppMethodBeat.i(192266);
                if (pBool.value) {
                    AppMethodBeat.o(192266);
                    return;
                }
                aVar.i("cancel", null);
                AppMethodBeat.o(192266);
            }
        });
        AppMethodBeat.o(192269);
    }

    static /* synthetic */ void j(boolean z, JSONObject jSONObject) {
        boolean z2;
        AppMethodBeat.i(192270);
        if (!z || !((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_download_game_ignore_network, false)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2 && NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext()) && !NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            try {
                jSONObject.put("network_tips", 1);
                AppMethodBeat.o(192270);
                return;
            } catch (JSONException e2) {
            }
        }
        AppMethodBeat.o(192270);
    }
}
