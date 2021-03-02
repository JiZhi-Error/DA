package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.aw.b;
import com.tencent.mm.bh.e;
import com.tencent.mm.g.a.bo;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.b.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.z;

public final class i {
    private View DaW;
    private TextView DaX;
    EditText DaY;
    boolean DaZ;
    LauncherUI.b OBZ;
    kk.a OCa = null;
    com.tencent.mm.ak.i OCb;
    boolean OCc = false;
    boolean OCd = false;
    IListener OCe = new IListener<kk>() {
        /* class com.tencent.mm.ui.i.AnonymousClass1 */

        {
            AppMethodBeat.i(161496);
            this.__eventId = kk.class.getName().hashCode();
            AppMethodBeat.o(161496);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kk kkVar) {
            AppMethodBeat.i(33141);
            kk kkVar2 = kkVar;
            if (kkVar2 == null || kkVar2.dPw == null || kkVar2.dPw.dPx == null) {
                Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert event is illegal event[%s]", kkVar2);
            } else {
                Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert event launcherUI isResumeStatus[%b], tid[%d]", Boolean.valueOf(i.this.OBZ.gHZ()), Long.valueOf(Thread.currentThread().getId()));
                if (!i.this.OBZ.gHZ()) {
                    i.this.OCa = kkVar2.dPw;
                } else {
                    i.this.OCa = null;
                    i.this.a(kkVar2.dPw);
                }
            }
            AppMethodBeat.o(33141);
            return false;
        }
    };
    IListener<bo> OCf = new IListener<bo>() {
        /* class com.tencent.mm.ui.i.AnonymousClass3 */

        {
            AppMethodBeat.i(232549);
            this.__eventId = bo.class.getName().hashCode();
            AppMethodBeat.o(232549);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(bo boVar) {
            i.this.dEM = boVar.dEL.dEM;
            return false;
        }
    };
    int dEM = 0;
    ProgressDialog gtM;
    d kdA;
    MMFragmentActivity uLr;

    public i(MMFragmentActivity mMFragmentActivity, LauncherUI.b bVar) {
        AppMethodBeat.i(33160);
        this.uLr = mMFragmentActivity;
        this.OBZ = bVar;
        AppMethodBeat.o(33160);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(kk.a aVar) {
        AppMethodBeat.i(33161);
        if (aVar == null || aVar.dPx == null || aVar.dPx.KBq == null || aVar.dPx.KBq.size() == 0) {
            AppMethodBeat.o(33161);
            return false;
        }
        final int i2 = aVar.dPx.id;
        String str = aVar.dPx.title;
        String str2 = aVar.dPx.msg;
        int i3 = aVar.type;
        int size = aVar.dPx.KBq.size();
        if (i3 == 0) {
            if (size == 1) {
                final a aVar2 = aVar.dPx.KBq.get(0);
                Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", Integer.valueOf(i2), str, str2, Integer.valueOf(aVar2.id), Integer.valueOf(aVar2.actionType), aVar2.KBo, aVar2.KBp);
                h.a((Context) this.uLr, str2, str, aVar2.KBo, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.i.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(33151);
                        i.a(i.this, i2, aVar2.actionType, aVar2.id, aVar2.KBp);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(33151);
                    }
                });
            } else {
                final a aVar3 = aVar.dPx.KBq.get(1);
                final a aVar4 = aVar.dPx.KBq.get(0);
                Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", str, str2, Integer.valueOf(aVar3.id), Integer.valueOf(aVar3.actionType), aVar3.KBo, aVar3.KBp, Integer.valueOf(aVar4.id), Integer.valueOf(aVar4.actionType), aVar4.KBo, aVar4.KBp);
                h.a((Context) this.uLr, str2, str, aVar3.KBo, aVar4.KBo, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.i.AnonymousClass8 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(33152);
                        i.a(i.this, i2, aVar3.actionType, aVar3.id, aVar3.KBp);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(33152);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.i.AnonymousClass9 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(33153);
                        i.a(i.this, i2, aVar4.actionType, aVar4.id, aVar4.KBp);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(33153);
                    }
                });
            }
        } else if (i3 == 1) {
            h.a((Context) this.uLr, str2, str, aVar.dPx.KBq.get(0).KBo, aVar.dPx.KBq.get(1).KBo, false, aVar.dPy, aVar.dPz);
        }
        AppMethodBeat.o(33161);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final com.tencent.mm.ak.i gHN() {
        AppMethodBeat.i(33162);
        if (this.OCb == null) {
            this.OCb = new com.tencent.mm.ak.i() {
                /* class com.tencent.mm.ui.i.AnonymousClass11 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(33156);
                    Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + i2 + " errCode " + i3 + " errMsg " + str + "  " + qVar.getType());
                    if (i.this.gtM != null) {
                        i.this.gtM.dismiss();
                        i.this.gtM = null;
                    }
                    if (qVar.getType() == 255) {
                        bg.azz().b(255, i.this.OCb);
                        if (i2 == 0 && i3 == 0) {
                            i.this.AZ(true);
                            AppMethodBeat.o(33156);
                        } else if (z.a.a(i.this.uLr, i2, i3, str, 4)) {
                            AppMethodBeat.o(33156);
                        } else {
                            i.this.AZ(false);
                            AppMethodBeat.o(33156);
                        }
                    } else {
                        if (qVar.getType() == 384) {
                            if (i2 == 0 && i3 == 0) {
                                bg.aVF();
                                c.azQ().set(77830, ((ad) qVar).bbG());
                                Intent intent = new Intent(i.this.uLr, RegByMobileSetPwdUI.class);
                                intent.putExtra("kintent_hint", i.this.getString(R.string.gr1));
                                MMFragmentActivity mMFragmentActivity = i.this.uLr;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, bl.axQ(), "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                mMFragmentActivity.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(33156);
                                return;
                            }
                            i.this.DaZ = true;
                            h.a(i.this.uLr, (int) R.string.gs8, (int) R.string.zb, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.i.AnonymousClass11.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(33155);
                                    i.this.gHO();
                                    AppMethodBeat.o(33155);
                                }
                            });
                        }
                        AppMethodBeat.o(33156);
                    }
                }
            };
        }
        com.tencent.mm.ak.i iVar = this.OCb;
        AppMethodBeat.o(33162);
        return iVar;
    }

    /* access modifiers changed from: package-private */
    public final void AZ(boolean z) {
        AppMethodBeat.i(33163);
        Log.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword ".concat(String.valueOf(z)));
        if (z) {
            gHO();
            AppMethodBeat.o(33163);
            return;
        }
        Intent intent = new Intent(this.uLr, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", getString(R.string.gr1));
        MMFragmentActivity mMFragmentActivity = this.uLr;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, bl.axQ(), "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        mMFragmentActivity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(33163);
    }

    /* access modifiers changed from: package-private */
    public final void gHO() {
        AppMethodBeat.i(33164);
        if (this.kdA != null) {
            this.kdA.show();
            AppMethodBeat.o(33164);
            return;
        }
        if (this.DaW == null) {
            this.DaW = View.inflate(this.uLr, R.layout.bqa, null);
            this.DaX = (TextView) this.DaW.findViewById(R.id.hku);
            this.DaX.setText(getString(R.string.gpb));
            this.DaY = (EditText) this.DaW.findViewById(R.id.hkt);
            this.DaY.setInputType(129);
        }
        this.kdA = h.a(this.uLr, (String) null, this.DaW, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.i.AnonymousClass12 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(33158);
                String obj = i.this.DaY.getText().toString();
                i.this.DaY.setText("");
                i.this.DaY.clearFocus();
                af.a(i.this.uLr, i.this.DaY);
                if (obj == null || obj.equals("")) {
                    h.a(i.this.uLr, (int) R.string.hvk, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.i.AnonymousClass12.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(33158);
                    return;
                }
                i.this.gHN();
                bg.azz().a(384, i.this.OCb);
                final ad adVar = new ad(obj, "", "", "");
                bg.azz().a(adVar, 0);
                i iVar = i.this;
                MMFragmentActivity mMFragmentActivity = i.this.uLr;
                i.this.getString(R.string.zb);
                iVar.gtM = h.a((Context) mMFragmentActivity, i.this.getString(R.string.gps), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.ui.i.AnonymousClass12.AnonymousClass2 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(33157);
                        bg.azz().b(384, i.this.OCb);
                        i.this.OCb = null;
                        bg.azz().a(adVar);
                        AppMethodBeat.o(33157);
                    }
                });
                AppMethodBeat.o(33158);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.i.AnonymousClass13 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(33159);
                i.this.DaY.setText("");
                i.this.kdA.dismiss();
                AppMethodBeat.o(33159);
            }
        });
        AppMethodBeat.o(33164);
    }

    /* access modifiers changed from: package-private */
    public final String getString(int i2) {
        AppMethodBeat.i(33165);
        String string = this.uLr.getString(i2);
        AppMethodBeat.o(33165);
        return string;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(i iVar, int i2, int i3, int i4, String str) {
        b.a bs;
        AppMethodBeat.i(33166);
        Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert jumpByActionType  alertId[%d], actionType[%d], btnId[%d], url[%s]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13191, Integer.valueOf(i2), Integer.valueOf(i4), Boolean.FALSE);
        switch (i3) {
            case 1:
                AppMethodBeat.o(33166);
                return;
            case 2:
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                com.tencent.mm.br.c.b(iVar.uLr, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(33166);
                return;
            case 3:
                if (iVar.DaZ) {
                    iVar.AZ(true);
                    AppMethodBeat.o(33166);
                    return;
                }
                iVar.gHN();
                bg.azz().a(255, iVar.OCb);
                final u uVar = new u(1);
                bg.azz().a(uVar, 0);
                MMFragmentActivity mMFragmentActivity = iVar.uLr;
                iVar.getString(R.string.zb);
                iVar.gtM = h.a((Context) mMFragmentActivity, iVar.getString(R.string.gps), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.ui.i.AnonymousClass10 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(33154);
                        bg.azz().a(uVar);
                        AppMethodBeat.o(33154);
                    }
                });
                AppMethodBeat.o(33166);
                return;
            case 4:
                Intent intent2 = new Intent();
                intent2.setClass(iVar.uLr, BindMContactUI.class);
                intent2.putExtra("bind_scene", 3);
                String simCountryIso = ((TelephonyManager) iVar.uLr.getSystemService("phone")).getSimCountryIso();
                if (!Util.isNullOrNil(simCountryIso) && (bs = b.bs(simCountryIso, iVar.getString(R.string.bj8))) != null) {
                    intent2.putExtra("country_name", bs.jbZ);
                    intent2.putExtra("couttry_code", bs.jbY);
                }
                MMWizardActivity.ay(iVar.uLr, intent2);
                AppMethodBeat.o(33166);
                return;
            case 5:
                Intent intent3 = new Intent();
                intent3.putExtra("BaseScanUI_select_scan_mode", 1);
                intent3.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent3.setFlags(65536);
                if (!com.tencent.mm.q.a.o(iVar.uLr, true) && !e.bgF() && !com.tencent.mm.q.a.r(iVar.uLr, true)) {
                    com.tencent.mm.br.c.b(iVar.uLr, "scanner", ".ui.BaseScanUI", intent3);
                    break;
                }
        }
        AppMethodBeat.o(33166);
    }
}
