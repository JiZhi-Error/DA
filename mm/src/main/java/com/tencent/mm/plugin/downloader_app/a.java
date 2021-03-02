package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.g;

public final class a implements b {
    @Override // com.tencent.mm.plugin.downloader_app.api.b
    public final void a(Context context, final String str, final DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2, final DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(8767);
        final PBool pBool = new PBool();
        d.a aVar = new d.a(context);
        aVar.aoO(R.string.ete);
        aVar.aoS(R.string.etc);
        aVar.aoV(R.string.etf);
        aVar.c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.a.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(8761);
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i2);
                }
                pBool.value = true;
                com.tencent.mm.plugin.downloader_app.b.a.a(15, 1501, 1, 23, str, "", "");
                AppMethodBeat.o(8761);
            }
        });
        aVar.aoW(R.string.etb);
        aVar.d(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.a.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(8762);
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, i2);
                }
                pBool.value = true;
                com.tencent.mm.plugin.downloader_app.b.a.a(15, 1501, 1, 3, str, "", "");
                if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
                    RequestFloatWindowPermissionDialog.a(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.dd5), new RequestFloatWindowPermissionDialog.a() {
                        /* class com.tencent.mm.plugin.downloader_app.a.AnonymousClass4.AnonymousClass1 */

                        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                        public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                            AppMethodBeat.i(240186);
                            requestFloatWindowPermissionDialog.finish();
                            AppMethodBeat.o(240186);
                        }

                        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                        public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                            AppMethodBeat.i(240187);
                            requestFloatWindowPermissionDialog.finish();
                            AppMethodBeat.o(240187);
                        }

                        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                        public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                            AppMethodBeat.i(240188);
                            requestFloatWindowPermissionDialog.finish();
                            AppMethodBeat.o(240188);
                        }
                    }, true, com.tencent.mm.bq.a.apJ());
                }
                AppMethodBeat.o(8762);
            }
        });
        aVar.Dk(true);
        aVar.f(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.downloader_app.a.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(8763);
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
                if (!pBool.value) {
                    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1501, 1, 2, str, "", "");
                }
                AppMethodBeat.o(8763);
            }
        });
        aVar.hbn().show();
        com.tencent.mm.plugin.downloader_app.b.a.a(15, 1501, 1, 1, str, "", "");
        AppMethodBeat.o(8767);
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.b
    public final void a(Context context, final String str, final b.a aVar, final b.a aVar2, final b.a aVar3) {
        AppMethodBeat.i(240195);
        if (((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_download_game_ignore_network, false)) {
            final e eVar = new e(context, R.style.ht);
            eVar.gR();
            eVar.setCancelable(false);
            View inflate = LayoutInflater.from(context).inflate(R.layout.bn6, (ViewGroup) null);
            eVar.setContentView(inflate);
            inflate.findViewById(R.id.btj).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(240189);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    eVar.dismiss();
                    if (aVar3 != null) {
                        aVar3.onClick();
                    }
                    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 2, str, "", "");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(240189);
                }
            });
            inflate.findViewById(R.id.btm).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(240190);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    eVar.dismiss();
                    if (aVar != null) {
                        aVar.onClick();
                    }
                    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 23, str, "", "");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(240190);
                }
            });
            inflate.findViewById(R.id.bti).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(240191);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    eVar.dismiss();
                    if (aVar2 != null) {
                        aVar2.onClick();
                    }
                    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 3, str, "", "");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(240191);
                }
            });
            eVar.show();
        } else {
            final PBool pBool = new PBool();
            d.a aVar4 = new d.a(context);
            aVar4.aoO(R.string.etg);
            aVar4.aoS(R.string.eth);
            aVar4.aoV(R.string.etf);
            aVar4.c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(240192);
                    pBool.value = true;
                    if (aVar != null) {
                        aVar.onClick();
                    }
                    pBool.value = true;
                    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 23, str, "", "");
                    AppMethodBeat.o(240192);
                }
            });
            aVar4.aoW(R.string.etd);
            aVar4.d(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(240193);
                    if (aVar2 != null) {
                        aVar2.onClick();
                    }
                    pBool.value = true;
                    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 3, str, "", "");
                    AppMethodBeat.o(240193);
                }
            });
            aVar4.Dk(true);
            aVar4.f(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.downloader_app.a.AnonymousClass11 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(240194);
                    if (aVar3 != null) {
                        aVar3.onClick();
                    }
                    if (!pBool.value) {
                        com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 2, str, "", "");
                    }
                    AppMethodBeat.o(240194);
                }
            });
            aVar4.hbn().show();
        }
        com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 1, str, "", "");
        AppMethodBeat.o(240195);
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.b
    public final void a(Context context, final b.a aVar, final b.a aVar2) {
        AppMethodBeat.i(240196);
        final com.tencent.mm.ui.widget.a.g gVar = new com.tencent.mm.ui.widget.a.g(context, 1, 0, false);
        gVar.b(context.getString(R.string.bnn), context.getString(R.string.bno));
        gVar.a(new g.a() {
            /* class com.tencent.mm.plugin.downloader_app.a.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.a.g.a
            public final void onClick() {
                AppMethodBeat.i(240184);
                gVar.bMo();
                if (aVar != null) {
                    aVar.onClick();
                }
                AppMethodBeat.o(240184);
            }
        }, new g.a() {
            /* class com.tencent.mm.plugin.downloader_app.a.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.a.g.a
            public final void onClick() {
                AppMethodBeat.i(240185);
                gVar.bMo();
                if (aVar2 != null) {
                    aVar2.onClick();
                }
                AppMethodBeat.o(240185);
            }
        });
        View inflate = LayoutInflater.from(context).inflate(R.layout.bsk, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bub);
        if (ao.isDarkMode()) {
            imageView.setImageResource(R.raw.ic_download_pause_alert_dark);
        } else {
            imageView.setImageResource(R.raw.ic_download_pause_alert);
        }
        gVar.setCustomView(inflate);
        gVar.dGm();
        AppMethodBeat.o(240196);
    }
}
