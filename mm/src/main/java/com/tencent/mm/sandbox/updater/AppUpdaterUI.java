package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sandbox.updater.k;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.d;

public class AppUpdaterUI extends MMBaseActivity {
    private static AppUpdaterUI NEz = null;
    private k NEA;
    private h NEB = new h() {
        /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass1 */

        @Override // com.tencent.mm.sandbox.updater.h
        public final void fn(int i2, int i3) {
            AppMethodBeat.i(32623);
            int i4 = (int) (i2 <= 0 ? 0 : (((long) i3) * 100) / ((long) i2));
            if (i4 == 100) {
                AppUpdaterUI.this.NEy.setText(AppUpdaterUI.this.getString(R.string.hsr));
                AppMethodBeat.o(32623);
                return;
            }
            AppUpdaterUI.this.NEy.setText(AppUpdaterUI.this.getString(R.string.hsp) + i4 + "%");
            AppMethodBeat.o(32623);
        }

        @Override // com.tencent.mm.sandbox.updater.h
        public final void gwe() {
            AppMethodBeat.i(32624);
            Log.e("MicroMsg.AppUpdaterUI", "no sdcard.");
            if (AppUpdaterUI.this.kdo != null) {
                AppUpdaterUI.this.kdo.dismiss();
            }
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.o(32624);
                return;
            }
            AppUpdaterUI.c(AppUpdaterUI.this);
            AppMethodBeat.o(32624);
        }

        @Override // com.tencent.mm.sandbox.updater.h
        public final void gwf() {
            AppMethodBeat.i(32625);
            if (AppUpdaterUI.this.kdo != null) {
                AppUpdaterUI.this.kdo.dismiss();
            }
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.o(32625);
                return;
            }
            AppUpdaterUI.d(AppUpdaterUI.this);
            AppMethodBeat.o(32625);
        }

        @Override // com.tencent.mm.sandbox.updater.h
        public final void eWN() {
            AppMethodBeat.i(32626);
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.o(32626);
                return;
            }
            AppUpdaterUI.this.NEy.setText(R.string.hsp);
            AppUpdaterUI.this.NEy.setEnabled(false);
            AppMethodBeat.o(32626);
        }

        @Override // com.tencent.mm.sandbox.updater.h
        public final void aNH(String str) {
            AppMethodBeat.i(32627);
            if (AppUpdaterUI.this.kdo != null) {
                AppUpdaterUI.this.kdo.dismiss();
            }
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.o(32627);
                return;
            }
            Log.d("MicroMsg.AppUpdaterUI", str);
            if (str != null) {
                AppUpdaterUI.a(AppUpdaterUI.this, str);
                AppUpdaterUI.this.NEy.setEnabled(false);
            }
            AppMethodBeat.o(32627);
        }

        @Override // com.tencent.mm.sandbox.updater.h
        public final void a(c cVar) {
            AppMethodBeat.i(32628);
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.o(32628);
            } else if (cVar instanceof c) {
                h.INSTANCE.idkeyStat(405, 67, 1, true);
                Log.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
                if (AppUpdaterUI.this.kdo != null) {
                    AppUpdaterUI.this.kdo.setMessage(AppUpdaterUI.this.getString(R.string.dgf, new Object[]{AppUpdaterUI.this.NEA.desc, AppUpdaterUI.this.getString(R.string.hsm), Util.getSizeKB((long) AppUpdaterUI.this.NEA.size)}));
                }
                if (AppUpdaterUI.this.NEA.NFN) {
                    h.INSTANCE.idkeyStat(405, 68, 1, true);
                    AppUpdaterUI.a(AppUpdaterUI.this, cVar);
                }
                AppMethodBeat.o(32628);
            } else {
                h.INSTANCE.idkeyStat(405, 69, 1, true);
                com.tencent.mm.ui.base.h.a(AppUpdaterUI.this, (int) R.string.hsn, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass1.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(32622);
                        Log.d("MicroMsg.AppUpdaterUI", "go to WebView");
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + FilePathGenerator.ANDROID_DIR_SEP));
                        intent.addFlags(268435456);
                        AppUpdaterUI appUpdaterUI = AppUpdaterUI.this;
                        a bl = new a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(appUpdaterUI, bl.axQ(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        appUpdaterUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(appUpdaterUI, "com/tencent/mm/sandbox/updater/AppUpdaterUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(32622);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass1.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(32628);
            }
        }
    };
    private DialogInterface.OnClickListener NEC = new DialogInterface.OnClickListener() {
        /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass9 */

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(32638);
            AppUpdaterUI.g(AppUpdaterUI.this);
            AppMethodBeat.o(32638);
        }
    };
    private DialogInterface.OnClickListener NEv = new DialogInterface.OnClickListener() {
        /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass10 */

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(32639);
            Log.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
            if (AppUpdaterUI.this.NEA.EtH == 1) {
                j.aL(AppUpdaterUI.this, 6);
            }
            if (!g.getExternalStorageState().equals("mounted")) {
                Log.e("MicroMsg.AppUpdaterUI", "no sdcard.");
                AppUpdaterUI.this.kdo.dismiss();
                AppUpdaterUI.c(AppUpdaterUI.this);
                AppMethodBeat.o(32639);
            } else if ((AppUpdaterUI.this.NEA.updateMode & 1) != 0) {
                Log.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
                Uri parse = Uri.parse(AppUpdaterUI.this.NEA.djj);
                Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(268435456);
                if (parse == null || addFlags == null || !Util.isIntentAvailable(AppUpdaterUI.this, addFlags)) {
                    Log.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
                    Intent addFlags2 = new Intent("android.intent.action.VIEW", Uri.parse(e.OyP)).addFlags(268435456);
                    AppUpdaterUI appUpdaterUI = AppUpdaterUI.this;
                    a bl = new a().bl(addFlags2);
                    com.tencent.mm.hellhoundlib.a.a.a(appUpdaterUI, bl.axQ(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    appUpdaterUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(appUpdaterUI, "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else {
                    Log.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
                    AppUpdaterUI appUpdaterUI2 = AppUpdaterUI.this;
                    a bl2 = new a().bl(addFlags);
                    com.tencent.mm.hellhoundlib.a.a.a(appUpdaterUI2, bl2.axQ(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    appUpdaterUI2.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(appUpdaterUI2, "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                AppUpdaterUI.f(AppUpdaterUI.this);
                AppMethodBeat.o(32639);
            } else {
                String df = c.df(AppUpdaterUI.this.NEA.md5, AppUpdaterUI.this.NEA.NFR);
                if (Util.isNullOrNil(df) && AppUpdaterUI.this.NEA.NFM != null) {
                    df = c.bhH(AppUpdaterUI.this.NEA.NFM.djw);
                }
                Log.d("MicroMsg.AppUpdaterUI", df);
                if (df != null) {
                    Log.i("MicroMsg.AppUpdaterUI", "update package already exist.");
                    AppUpdaterUI.a(AppUpdaterUI.this, 8);
                    if (AppUpdaterUI.this.NEA.NFN) {
                        AppUpdaterUI.a(AppUpdaterUI.this, 0);
                    } else {
                        AppUpdaterUI.a(AppUpdaterUI.this, 9);
                    }
                    AppUpdaterUI.this.NEA.bC(1, true);
                    AppUpdaterUI.this.NEB.aNH(df);
                    AppMethodBeat.o(32639);
                    return;
                }
                Log.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", Integer.valueOf(AppUpdaterUI.this.NEA.EtH));
                Log.d("MicroMsg.AppUpdaterUI", "current updateType : %s", Integer.valueOf(AppUpdaterUI.this.NEA.NEo));
                if (AppUpdaterUI.this.NEA.EtH == 0) {
                    AppUpdaterUI.this.NEA.cID();
                    AppMethodBeat.o(32639);
                } else if (AppUpdaterUI.this.NEA.EtH == 1) {
                    Log.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
                    AppUpdaterUI.f(AppUpdaterUI.this);
                    Intent intent = new Intent(AppUpdaterUI.this.getIntent());
                    intent.setClass(AppUpdaterUI.this, UpdaterService.class);
                    intent.putExtra("intent_extra_run_in_foreground", true);
                    com.tencent.mm.br.c.m(intent, "sandbox");
                    if (AppUpdaterUI.this.NEA.NFR) {
                        h.INSTANCE.idkeyStat(614, 56, 1, false);
                        Log.d("MicroMsg.AppUpdaterUI", "boots download start.");
                    }
                    AppMethodBeat.o(32639);
                } else {
                    Log.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
                    AppMethodBeat.o(32639);
                }
            }
        }
    };
    private Button NEy;
    private Button hSq;
    private d kdo = null;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppUpdaterUI() {
        AppMethodBeat.i(32644);
        AppMethodBeat.o(32644);
    }

    static /* synthetic */ void f(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.i(32653);
        appUpdaterUI.gwd();
        AppMethodBeat.o(32653);
    }

    public static AppUpdaterUI gwb() {
        return NEz;
    }

    public static void gwc() {
        AppMethodBeat.i(32645);
        if (NEz != null) {
            NEz.gwd();
        }
        AppMethodBeat.o(32645);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        String string;
        int i2;
        AppMethodBeat.i(32646);
        super.onCreate(bundle);
        Log.d("MicroMsg.AppUpdaterUI", "onCreate");
        com.tencent.mm.sandbox.c.q(hashCode(), this);
        MMActivity.initLanguage(this);
        if (AppInstallerUI.gwa() != null && !AppInstallerUI.gwa().isFinishing()) {
            Log.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
            finish();
            AppMethodBeat.o(32646);
        } else if (NEz == null || NEz.isFinishing() || NEz == this) {
            NEz = this;
            setContentView(R.layout.a3o);
            this.NEA = k.a.NFZ;
            if (!this.NEA.bv(getIntent())) {
                Log.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
                gwd();
                AppMethodBeat.o(32646);
            } else if (this.NEA.NEo != 999 || this.NEA.NEQ == null || this.NEA.NEQ.length <= 0) {
                Log.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.NEA.NEQ);
                d.a aVar = new d.a(this);
                aVar.aoO(R.string.dgd);
                aVar.Dk(true);
                aVar.f(new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass8 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(32637);
                        AppUpdaterUI.g(AppUpdaterUI.this);
                        AppMethodBeat.o(32637);
                    }
                });
                if (!this.NEA.NFN || this.NEA.NFM == null) {
                    Log.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
                    string = getString(R.string.dgf, new Object[]{this.NEA.desc, getString(R.string.hsm), Util.getSizeKB((long) this.NEA.size)});
                } else {
                    string = getString(R.string.dgf, new Object[]{this.NEA.desc, getString(R.string.hsq), Util.getSizeKB((long) this.NEA.NFM.size)});
                }
                if (this.NEA.NEo != 1) {
                    i2 = R.string.hsi;
                } else {
                    i2 = R.string.hsl;
                }
                aVar.boo(string);
                aVar.aoV(R.string.hsu).a(false, this.NEv);
                aVar.aoW(i2);
                this.kdo = aVar.hbn();
                this.kdo.setCanceledOnTouchOutside(false);
                this.NEy = this.kdo.getButton(-1);
                this.hSq = this.kdo.getButton(-2);
                this.kdo.show();
                if (this.NEA.EtH == 1) {
                    j.aL(this, 5);
                }
                if (this.NEA.NFR) {
                    h.INSTANCE.idkeyStat(614, 60, 1, false);
                }
                k kVar = this.NEA;
                h hVar = this.NEB;
                if (hVar != null && !kVar.NFI.contains(hVar)) {
                    kVar.NFI.add(hVar);
                }
                AppMethodBeat.o(32646);
            } else {
                Log.d("MicroMsg.AppUpdaterUI", "into emergency status");
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(32636);
                        com.tencent.mm.ui.base.h.d(AppUpdaterUI.this, AppUpdaterUI.this.NEA.desc, AppUpdaterUI.this.getString(R.string.zb), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass7.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(32634);
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(AppUpdaterUI.this.NEA.NEQ[0]));
                                intent.addFlags(268435456);
                                Context context = MMApplicationContext.getContext();
                                a bl = new a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$2$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/sandbox/updater/AppUpdaterUI$2$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppUpdaterUI.f(AppUpdaterUI.this);
                                AppMethodBeat.o(32634);
                            }
                        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass7.AnonymousClass2 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(32635);
                                AppUpdaterUI.f(AppUpdaterUI.this);
                                AppMethodBeat.o(32635);
                            }
                        });
                        AppMethodBeat.o(32636);
                    }
                }, 100);
                AppMethodBeat.o(32646);
            }
        } else {
            Log.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
            Log.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
            finish();
            AppMethodBeat.o(32646);
        }
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(32647);
        Log.d("MicroMsg.AppUpdaterUI", "onDestroy");
        com.tencent.mm.sandbox.c.r(hashCode(), this);
        if (this.NEA != null) {
            k kVar = this.NEA;
            kVar.NFI.remove(this.NEB);
        }
        if (NEz == this) {
            NEz = null;
        }
        super.onDestroy();
        AppMethodBeat.o(32647);
    }

    private void gwd() {
        AppMethodBeat.i(32648);
        if (this.kdo != null && this.kdo.isShowing()) {
            this.kdo.dismiss();
        }
        finish();
        AppMethodBeat.o(32648);
    }

    static /* synthetic */ void c(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.i(32649);
        Log.d("MicroMsg.AppUpdaterUI", "showNoSDCardAlert");
        h.INSTANCE.idkeyStat(405, 65, 1, true);
        com.tencent.mm.ui.base.h.d(appUpdaterUI, appUpdaterUI.getString(R.string.hss), appUpdaterUI.getString(R.string.zb), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(32630);
                AppUpdaterUI.i(AppUpdaterUI.this);
                AppMethodBeat.o(32630);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(32631);
                AppUpdaterUI.i(AppUpdaterUI.this);
                AppMethodBeat.o(32631);
            }
        });
        AppMethodBeat.o(32649);
    }

    static /* synthetic */ void d(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.i(32650);
        Log.d("MicroMsg.AppUpdaterUI", "showSDCardFullAlert");
        h.INSTANCE.idkeyStat(405, 66, 1, true);
        com.tencent.mm.ui.base.h.d(appUpdaterUI, appUpdaterUI.getString(R.string.hsv), appUpdaterUI.getString(R.string.zb), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass14 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(32643);
                AppUpdaterUI.i(AppUpdaterUI.this);
                AppMethodBeat.o(32643);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(32629);
                AppUpdaterUI.i(AppUpdaterUI.this);
                AppMethodBeat.o(32629);
            }
        });
        AppMethodBeat.o(32650);
    }

    static /* synthetic */ void a(AppUpdaterUI appUpdaterUI, final String str) {
        AppMethodBeat.i(32651);
        h.INSTANCE.idkeyStat(405, 70, 1, true);
        if (appUpdaterUI.NEA.NFR) {
            h.INSTANCE.idkeyStat(614, 50, 1, false);
        }
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(32640);
                com.tencent.mm.pluginsdk.i.g.aZ(AppUpdaterUI.this, str);
                AppUpdaterUI.f(AppUpdaterUI.this);
                AppMethodBeat.o(32640);
            }
        }, 300);
        AppMethodBeat.o(32651);
    }

    static /* synthetic */ void a(AppUpdaterUI appUpdaterUI, final c cVar) {
        AppMethodBeat.i(32652);
        Log.d("MicroMsg.AppUpdaterUI", "showDownloadFullPackAlert()");
        d d2 = com.tencent.mm.ui.base.h.d(appUpdaterUI, appUpdaterUI.getString(R.string.dge, new Object[]{Util.getSizeKB((long) appUpdaterUI.NEA.size)}), appUpdaterUI.getString(R.string.zb), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass12 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(32641);
                Log.d("MicroMsg.AppUpdaterUI", "click download button");
                AppUpdaterUI.a(AppUpdaterUI.this, 11);
                if (cVar != null) {
                    cVar.deleteTempFile();
                }
                k kVar = AppUpdaterUI.this.NEA;
                kVar.NFP = true;
                kVar.cID();
                AppMethodBeat.o(32641);
            }
        });
        d2.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass13 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(32642);
                Log.d("MicroMsg.AppUpdaterUI", "click cancel button");
                AppUpdaterUI.a(AppUpdaterUI.this, 12);
                AppUpdaterUI.i(AppUpdaterUI.this);
                AppMethodBeat.o(32642);
            }
        });
        d2.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(32652);
    }

    static /* synthetic */ void g(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.i(32654);
        Log.d("MicroMsg.AppUpdaterUI", "showDownloadCancelAlert");
        if (appUpdaterUI.NEA.NFS) {
            com.tencent.mm.ui.base.h.b(appUpdaterUI, (int) R.string.amp, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(32632);
                    Log.d("MicroMsg.AppUpdaterUI", "update dialog had been canceled");
                    if (AppUpdaterUI.this.kdo != null && AppUpdaterUI.this.kdo.isShowing()) {
                        AppUpdaterUI.this.kdo.dismiss();
                    }
                    AppUpdaterUI.a(AppUpdaterUI.this, 6);
                    if (AppUpdaterUI.this.NEA.NFR) {
                        h.INSTANCE.idkeyStat(614, 59, 1, true);
                        Log.d("MicroMsg.AppUpdaterUI", "boots download cancel when downloading.");
                    }
                    AppUpdaterUI.this.NEA.cancel();
                    AppUpdaterUI.this.NEA.bC(2, true);
                    AppUpdaterUI.f(AppUpdaterUI.this);
                    AppMethodBeat.o(32632);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.sandbox.updater.AppUpdaterUI.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(32633);
                    if (AppUpdaterUI.this.kdo != null && !AppUpdaterUI.this.kdo.isShowing()) {
                        AppUpdaterUI.this.kdo.show();
                    }
                    AppMethodBeat.o(32633);
                }
            });
            AppMethodBeat.o(32654);
            return;
        }
        if (appUpdaterUI.NEA.EtH == 1) {
            j.aL(appUpdaterUI, 7);
            if (appUpdaterUI.NEA.NFR) {
                h.INSTANCE.idkeyStat(614, 57, 1, true);
                Log.d("MicroMsg.AppUpdaterUI", "boots download cancel.");
            }
        }
        j.aK(appUpdaterUI, 6);
        appUpdaterUI.NEA.bC(2, true);
        appUpdaterUI.gwd();
        AppMethodBeat.o(32654);
    }

    static /* synthetic */ void a(AppUpdaterUI appUpdaterUI, int i2) {
        AppMethodBeat.i(32655);
        j.aK(appUpdaterUI, i2);
        AppMethodBeat.o(32655);
    }

    static /* synthetic */ void i(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.i(32656);
        appUpdaterUI.NEA.cancel();
        appUpdaterUI.NEA.bC(2, true);
        appUpdaterUI.gwd();
        AppMethodBeat.o(32656);
    }
}
