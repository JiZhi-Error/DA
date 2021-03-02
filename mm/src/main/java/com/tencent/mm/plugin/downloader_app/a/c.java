package com.tencent.mm.plugin.downloader_app.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader_app.a.h;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.downloader_app.api.b;
import com.tencent.mm.plugin.downloader_app.b.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static void a(Context context, i iVar) {
        AppMethodBeat.i(8854);
        a(context, iVar, false);
        AppMethodBeat.o(8854);
    }

    public static void a(Context context, i iVar, boolean z) {
        AppMethodBeat.i(8855);
        if (!z) {
            a.a(10, a.Fq(iVar.type), iVar.position, 23, iVar.appId, "", "");
        }
        b(context, iVar, z);
        AppMethodBeat.o(8855);
    }

    private static void b(final Context context, i iVar, boolean z) {
        AppMethodBeat.i(8856);
        if (context == null || iVar == null) {
            AppMethodBeat.o(8856);
            return;
        }
        final a aVar = new a();
        aVar.downloadUrl = iVar.qLi.gqB;
        aVar.qKt = iVar.qLi.qGw;
        aVar.appId = iVar.appId;
        aVar.appName = iVar.appName;
        aVar.qKv = iVar.qLi.qGq;
        aVar.mYc = iVar.qLi.qGr;
        aVar.packageName = iVar.qLi.qGp;
        aVar.dNv = iVar.qLi.qGs;
        aVar.extInfo = cBV();
        aVar.scene = z ? 6003 : 6002;
        aVar.qJg = iVar.qLi.qGy;
        aVar.fileType = 1;
        aVar.dNv = 1;
        aVar.qKz = iVar.qLi.qGz;
        com.tencent.mm.plugin.downloader.f.a.a(9, new b(aVar.appId, aVar.scene, -1, ""));
        if (!NetStatusUtil.isConnected(context)) {
            h.a(context, context.getString(R.string.fbl), context.getString(R.string.fbm), context.getString(R.string.ebe), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass1 */
                final /* synthetic */ a.b qKE = null;

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(8840);
                    com.tencent.mm.plugin.downloader.g.a alb = d.alb(aVar.appId);
                    if (alb != null) {
                        alb.field_status = 4;
                        d.e(alb);
                    } else {
                        alb = new com.tencent.mm.plugin.downloader.g.a();
                        alb.field_downloadId = System.currentTimeMillis();
                        alb.field_appId = aVar.appId;
                        alb.field_downloadUrl = aVar.downloadUrl;
                        alb.field_status = 4;
                        d.d(alb);
                    }
                    d.CI(alb.field_downloadId);
                    if (this.qKE != null) {
                        this.qKE.a(a.EnumC0947a.FAIL, alb.field_downloadId);
                    }
                    AppMethodBeat.o(8840);
                }
            });
            AppMethodBeat.o(8856);
            return;
        }
        a(context, aVar, new a.b() {
            /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass12 */
            final /* synthetic */ a.b qKE = null;

            @Override // com.tencent.mm.plugin.downloader_app.api.a.b
            public final void a(a.EnumC0947a aVar, long j2) {
                AppMethodBeat.i(240204);
                if (aVar == a.EnumC0947a.OK) {
                    c.bQ(context);
                }
                if (this.qKE != null) {
                    this.qKE.a(aVar, j2);
                }
                AppMethodBeat.o(240204);
            }
        });
        AppMethodBeat.o(8856);
    }

    private static void a(Context context, final a aVar, final a.b bVar) {
        boolean z = false;
        AppMethodBeat.i(8857);
        if (context == null || !aVar.isValid()) {
            AppMethodBeat.o(8857);
        } else if (((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_download_game_ignore_network, false)) {
            if (NetStatusUtil.isWifi(context)) {
                z = true;
            }
            aVar.qJg = z;
            a(aVar, bVar);
            AppMethodBeat.o(8857);
        } else if (NetStatusUtil.isWifi(context)) {
            d.alt(aVar.appId);
            aVar.qJg = false;
            a(aVar, bVar);
            AppMethodBeat.o(8857);
        } else if (aVar.qJg) {
            ((com.tencent.mm.plugin.downloader_app.api.b) g.af(com.tencent.mm.plugin.downloader_app.api.b.class)).a(context, aVar.appId, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass15 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(8848);
                    aVar.qJg = false;
                    c.a(aVar, bVar);
                    AppMethodBeat.o(8848);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass16 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(8849);
                    c.a(aVar, bVar);
                    AppMethodBeat.o(8849);
                }
            }, (DialogInterface.OnCancelListener) null);
            AppMethodBeat.o(8857);
        } else {
            h.a(context, context.getString(R.string.iyr), context.getString(R.string.iys), context.getString(R.string.iym), context.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass17 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(8850);
                    d.alt(aVar.appId);
                    aVar.qJg = false;
                    c.a(aVar, bVar);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(8850);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass18 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(240206);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(240206);
                }
            }, (int) R.color.afp);
            AppMethodBeat.o(8857);
        }
    }

    public static long a(a aVar, a.b bVar) {
        long a2;
        a.EnumC0947a aVar2;
        AppMethodBeat.i(8858);
        if (!j.contains(aVar.appId)) {
            LinkedList<String> cCg = j.cCg();
            cCg.add(aVar.appId);
            h.a(cCg, new h.a() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass19 */

                @Override // com.tencent.mm.plugin.downloader_app.a.h.a
                public final void kW(boolean z) {
                }
            });
            j.alB(aVar.appId);
        }
        g.a aVar3 = new g.a();
        aVar3.alj(aVar.downloadUrl);
        aVar3.alk(aVar.qKt);
        aVar3.setFileSize(aVar.qKv);
        aVar3.all(aVar.appName);
        aVar3.setAppId(aVar.appId);
        aVar3.setFileMD5(aVar.mYc);
        aVar3.kS(aVar.qKw);
        aVar3.kT(false);
        aVar3.Fl(aVar.fileType == 0 ? 1 : aVar.fileType);
        aVar3.gm(aVar.packageName);
        aVar3.cBE();
        aVar3.setScene(aVar.scene);
        aVar3.Rv(aVar.extInfo);
        aVar3.kV(aVar.qJg);
        aVar3.Fp(aVar.eik);
        aVar3.Fm(aVar.qJJ);
        aVar3.Fo(aVar.qJI);
        aVar3.Fn(aVar.qJH);
        aVar3.kU(aVar.qKx);
        aVar3.V(aVar.qKz);
        aVar3.alm(aVar.qKu);
        if (aVar.dNv == 1) {
            a2 = f.cBv().b(aVar3.qIY);
        } else {
            a2 = f.cBv().a(aVar3.qIY);
        }
        Log.i("MicroMsg.DownloadPluginUtil", " add download task result:[%d], appid[%s]，downloaerType[%d]", Long.valueOf(a2), aVar.appId, Integer.valueOf(aVar.dNv));
        if (bVar != null) {
            if (!aVar.qJg || NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                aVar2 = a2 > 0 ? a.EnumC0947a.OK : a.EnumC0947a.FAIL;
            } else {
                aVar2 = a.EnumC0947a.WAIT_FOR_WIFI;
            }
            bVar.a(aVar2, a2);
        }
        if (aVar.qJg && !NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            d.alu(aVar.appId);
        }
        com.tencent.mm.modelstat.d.d(10, "DownloadPluginUtil_downloadTaskStraight", c.class.hashCode());
        AppMethodBeat.o(8858);
        return a2;
    }

    public static void a(Context context, i iVar, a.b bVar) {
        AppMethodBeat.i(8859);
        a(context, iVar, true, bVar);
        AppMethodBeat.o(8859);
    }

    public static void a(final Context context, i iVar, boolean z, final a.b bVar) {
        AppMethodBeat.i(8860);
        com.tencent.mm.plugin.downloader.g.a alb = d.alb(iVar.appId);
        if (alb != null) {
            alb.field_extInfo = als(alb.field_extInfo);
            alb.field_downloadType = 1;
            a(context, alb, iVar, new a.b() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass20 */

                @Override // com.tencent.mm.plugin.downloader_app.api.a.b
                public final void a(a.EnumC0947a aVar, long j2) {
                    AppMethodBeat.i(240207);
                    c.bQ(context);
                    if (bVar != null) {
                        bVar.a(aVar, j2);
                    }
                    AppMethodBeat.o(240207);
                }
            });
            com.tencent.mm.plugin.downloader.f.b bVar2 = new com.tencent.mm.plugin.downloader.f.b();
            bVar2.k(alb);
            com.tencent.mm.plugin.downloader.f.a.a(10, bVar2);
        }
        if (z) {
            com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(iVar.type), iVar.position, 6, iVar.appId, "", "");
        }
        AppMethodBeat.o(8860);
    }

    private static void a(Context context, final com.tencent.mm.plugin.downloader.g.a aVar, final i iVar, final a.b bVar) {
        AppMethodBeat.i(8861);
        if (!NetStatusUtil.isConnected(context)) {
            com.tencent.mm.ui.base.h.a(context, context.getString(R.string.fbl), context.getString(R.string.fbm), context.getString(R.string.ebe), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass21 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(8853);
                    aVar.field_status = 4;
                    d.e(aVar);
                    d.CI(aVar.field_downloadId);
                    if (bVar != null) {
                        bVar.a(a.EnumC0947a.FAIL, aVar.field_downloadId);
                    }
                    if (bVar != null) {
                        bVar.a(a.EnumC0947a.FAIL, aVar.field_downloadId);
                    }
                    AppMethodBeat.o(8853);
                }
            });
            AppMethodBeat.o(8861);
        } else if (((com.tencent.mm.game.report.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_download_game_ignore_network, false)) {
            d.alt(aVar.field_appId);
            a(aVar, NetStatusUtil.isWifi(context), bVar);
            AppMethodBeat.o(8861);
        } else if (NetStatusUtil.isWifi(context)) {
            d.alt(aVar.field_appId);
            a(aVar, false, bVar);
            AppMethodBeat.o(8861);
        } else if (iVar.qLi.qGy) {
            ((com.tencent.mm.plugin.downloader_app.api.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.b.class)).a(context, aVar.field_appId, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(8841);
                    d.alt(aVar.field_appId);
                    c.a(aVar, false, bVar);
                    AppMethodBeat.o(8841);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(8842);
                    if (!aVar.field_reserveInWifi || !aVar.field_downloadInWifi) {
                        com.tencent.mm.plugin.downloader.g.a aVar = aVar;
                        aVar.field_downloadInWifi = true;
                        aVar.field_reserveInWifi = true;
                        d.e(aVar);
                    }
                    bVar.a(a.EnumC0947a.WAIT_FOR_WIFI, aVar.field_downloadId);
                    AppMethodBeat.o(8842);
                }
            }, (DialogInterface.OnCancelListener) null);
            AppMethodBeat.o(8861);
        } else {
            if (aVar.field_reserveInWifi) {
                aVar.field_downloadInWifi = false;
                aVar.field_reserveInWifi = false;
                d.e(aVar);
            }
            com.tencent.mm.ui.base.h.a(context, context.getString(R.string.iyr), context.getString(R.string.iys), context.getString(R.string.iym), context.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(8843);
                    d.alt(aVar.field_appId);
                    c.a(aVar, false, bVar);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(8843);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(8844);
                    if (iVar != null) {
                        com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(iVar.type), iVar.position, 4, iVar.appId, "", "");
                    }
                    dialogInterface.dismiss();
                    AppMethodBeat.o(8844);
                }
            }, (int) R.color.afp);
            AppMethodBeat.o(8861);
        }
    }

    public static boolean a(com.tencent.mm.plugin.downloader.g.a aVar, boolean z, a.b bVar) {
        AppMethodBeat.i(8862);
        if (!j.contains(aVar.field_appId)) {
            LinkedList<String> cCg = j.cCg();
            cCg.add(aVar.field_appId);
            h.a(cCg, null);
            j.alB(aVar.field_appId);
        }
        aVar.field_showNotification = false;
        aVar.field_fromDownloadApp = true;
        aVar.field_downloadInWifi = z;
        aVar.field_reserveInWifi = z;
        d.e(aVar);
        boolean Cq = f.cBv().Cq(aVar.field_downloadId);
        if (bVar != null) {
            bVar.a(Cq ? a.EnumC0947a.OK : a.EnumC0947a.FAIL, aVar.field_downloadId);
        }
        com.tencent.mm.modelstat.d.d(10, "DownloadPluginUtil_resumeDownloadTaskStraight", c.class.hashCode());
        AppMethodBeat.o(8862);
        return Cq;
    }

    public static void b(Context context, final i iVar) {
        AppMethodBeat.i(240208);
        com.tencent.mm.plugin.downloader.g.a alb = d.alb(iVar.appId);
        if (alb != null) {
            f.cBv().Cp(alb.field_downloadId);
            com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(iVar.type), iVar.position, 5, alb.field_appId, "", "");
            if (((com.tencent.mm.game.report.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_download_game_ignore_network, false) && !NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                ((com.tencent.mm.plugin.downloader_app.api.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.b.class)).a(context, new b.a() {
                    /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass6 */

                    @Override // com.tencent.mm.plugin.downloader_app.api.b.a
                    public final void onClick() {
                        AppMethodBeat.i(240198);
                        com.tencent.mm.plugin.downloader.g.a alb = d.alb(iVar.appId);
                        if (alb == null) {
                            AppMethodBeat.o(240198);
                            return;
                        }
                        alb.field_downloadInWifi = false;
                        alb.field_reserveInWifi = false;
                        d.e(alb);
                        AppMethodBeat.o(240198);
                    }
                }, new b.a() {
                    /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass7 */

                    @Override // com.tencent.mm.plugin.downloader_app.api.b.a
                    public final void onClick() {
                        AppMethodBeat.i(240199);
                        com.tencent.mm.plugin.downloader.g.a alb = d.alb(iVar.appId);
                        if (alb == null) {
                            AppMethodBeat.o(240199);
                            return;
                        }
                        alb.field_downloadInWifi = true;
                        alb.field_reserveInWifi = true;
                        d.e(alb);
                        d.alu(alb.field_appId);
                        AppMethodBeat.o(240199);
                    }
                });
            }
        }
        AppMethodBeat.o(240208);
    }

    public static void a(i iVar) {
        AppMethodBeat.i(8864);
        com.tencent.mm.plugin.downloader.g.a alb = d.alb(iVar.appId);
        if (alb != null) {
            f.cBv().Cn(alb.field_downloadId);
        }
        com.tencent.mm.plugin.downloader_app.b.a.a(11, com.tencent.mm.plugin.downloader_app.b.a.Fq(iVar.type), iVar.position, 81, iVar.appId, "", "");
        AppMethodBeat.o(8864);
    }

    public static void a(final Context context, final long j2, final a.b bVar) {
        AppMethodBeat.i(8865);
        final com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null) {
            bVar.a(a.EnumC0947a.FAIL, -1);
            AppMethodBeat.o(8865);
            return;
        }
        ((com.tencent.mm.plugin.downloader_app.api.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.b.class)).a(context, Cw.field_appId, new b.a() {
            /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.downloader_app.api.b.a
            public final void onClick() {
                AppMethodBeat.i(240201);
                d.alt(Cw.field_appId);
                c.a(Cw, false, (a.b) new a.b() {
                    /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass8.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.downloader_app.api.a.b
                    public final void a(a.EnumC0947a aVar, long j2) {
                        AppMethodBeat.i(240200);
                        c.bQ(context);
                        if (bVar != null) {
                            bVar.a(aVar, j2);
                        }
                        AppMethodBeat.o(240200);
                    }
                });
                AppMethodBeat.o(240201);
            }
        }, new b.a() {
            /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.downloader_app.api.b.a
            public final void onClick() {
                AppMethodBeat.i(240202);
                com.tencent.mm.plugin.downloader.g.a aVar = Cw;
                Cw.field_downloadInWifi = false;
                aVar.field_reserveInWifi = false;
                d.e(Cw);
                if (Cw.field_status == 0) {
                    d.alv(Cw.field_appId);
                }
                if (bVar != null) {
                    bVar.a(a.EnumC0947a.CANCEL, j2);
                }
                AppMethodBeat.o(240202);
            }
        }, (b.a) null);
        AppMethodBeat.o(8865);
    }

    public static boolean c(final Context context, final i iVar) {
        AppMethodBeat.i(8866);
        com.tencent.mm.plugin.downloader.g.a alb = d.alb(iVar.appId);
        if (alb == null) {
            AppMethodBeat.o(8866);
            return false;
        } else if (s.YS(alb.field_filePath)) {
            com.tencent.mm.plugin.downloader.i.a.a(alb.field_downloadId, false, null);
            com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(iVar.type), iVar.position, 44, iVar.appId, "", "");
            AppMethodBeat.o(8866);
            return true;
        } else {
            com.tencent.mm.ui.base.h.a(context, context.getString(R.string.fji), context.getString(R.string.fjj), context.getString(R.string.g5b), context.getString(R.string.hl_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(240203);
                    c.a(context, iVar);
                    AppMethodBeat.o(240203);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(8866);
            return false;
        }
    }

    public static void d(final Context context, final i iVar) {
        AppMethodBeat.i(8867);
        if (q.s(context, iVar.qLi.qGp)) {
            com.tencent.mm.plugin.downloader.i.a.as(context, iVar.appId);
            com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(iVar.type), iVar.position, 22, iVar.appId, "", "");
            AppMethodBeat.o(8867);
            return;
        }
        com.tencent.mm.ui.base.h.a(context, context.getString(R.string.zg), context.getString(R.string.zh), context.getString(R.string.g5b), context.getString(R.string.hl_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass13 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(240205);
                c.a(context, iVar);
                AppMethodBeat.o(240205);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.a.c.AnonymousClass14 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(8867);
    }

    private static String cBV() {
        AppMethodBeat.i(8868);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("DownloadInWidget", 1);
            jSONObject.put("OpInWidget", 1);
        } catch (JSONException e2) {
        }
        String str = null;
        try {
            str = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e3) {
        }
        AppMethodBeat.o(8868);
        return str;
    }

    private static String als(String str) {
        JSONObject jSONObject;
        String str2;
        AppMethodBeat.i(8869);
        if (str == null || !str.contains("OpInWidget")) {
            if (!Util.isNullOrNil(str)) {
                try {
                    str2 = URLDecoder.decode(str, ProtocolPackage.ServerEncoding);
                } catch (UnsupportedEncodingException e2) {
                    str2 = str;
                }
                try {
                    jSONObject = new JSONObject(str2);
                } catch (Exception e3) {
                    jSONObject = null;
                }
            } else {
                jSONObject = null;
                str2 = str;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("OpInWidget", 1);
            } catch (JSONException e4) {
            }
            try {
                str2 = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e5) {
            }
            AppMethodBeat.o(8869);
            return str2;
        }
        AppMethodBeat.o(8869);
        return str;
    }

    static /* synthetic */ void bQ(Context context) {
        AppMethodBeat.i(240209);
        if (((com.tencent.mm.game.report.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_download_game_ignore_network, false) && NetStatusUtil.isNetworkConnected(context) && !NetStatusUtil.isWifi(context) && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            int color = context.getResources().getColor(R.color.Yellow);
            String string = context.getString(R.string.bnx);
            View inflate = View.inflate(activity, R.layout.c3d, null);
            inflate.findViewById(R.id.ipi);
            ((TextView) inflate.findViewById(R.id.ipl)).setText(string);
            WeImageView weImageView = (WeImageView) inflate.findViewById(R.id.ipj);
            weImageView.setImageResource(R.raw.bottomsheet_icon_complain);
            weImageView.setIconColor(color);
            p pVar = new p(inflate);
            pVar.setWidth(-1);
            pVar.setHeight(-2);
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i2 = rect.top;
            int eu = au.eu(activity);
            if (i2 == 0) {
                i2 = au.ay(activity);
            }
            pVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, i2 + eu);
            new Handler(pVar) {
                /* class com.tencent.mm.ui.widget.a.h.AnonymousClass1 */
                final /* synthetic */ p OTQ;

                {
                    this.OTQ = r1;
                }

                public final void handleMessage(Message message) {
                    AppMethodBeat.i(198281);
                    this.OTQ.dismiss();
                    super.handleMessage(message);
                    AppMethodBeat.o(198281);
                }
            }.sendEmptyMessageDelayed(0, 2000);
        }
        AppMethodBeat.o(240209);
    }
}
