package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import com.tencent.mm.plugin.wallet.balance.model.lqt.d;
import com.tencent.mm.plugin.wallet.balance.model.lqt.e;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.protocal.protobuf.ddf;
import com.tencent.mm.protocal.protobuf.dhl;
import com.tencent.mm.protocal.protobuf.ehn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.h;
import java.text.DecimalFormat;

public class WalletLqtBalanceAutoTransferUI extends WalletBaseUI {
    private MMSwitchBtn HwU;
    private TextView HwV;
    private TextView HwW;
    private FrameLayout HwX;
    private LinearLayout HwY;
    private View HwZ;
    private int Hxa;
    private ehn Hxb;
    private ehn Hxc;
    private ddf Hxd;
    private String Hxe;
    private View Hxf;
    private TextView jVn;
    private TextView mPa;
    private TextView yQj;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void g(WalletLqtBalanceAutoTransferUI walletLqtBalanceAutoTransferUI) {
        AppMethodBeat.i(68775);
        walletLqtBalanceAutoTransferUI.fNA();
        AppMethodBeat.o(68775);
    }

    static /* synthetic */ void h(WalletLqtBalanceAutoTransferUI walletLqtBalanceAutoTransferUI) {
        AppMethodBeat.i(68776);
        walletLqtBalanceAutoTransferUI.fNB();
        AppMethodBeat.o(68776);
    }

    static /* synthetic */ void j(WalletLqtBalanceAutoTransferUI walletLqtBalanceAutoTransferUI) {
        AppMethodBeat.i(68777);
        walletLqtBalanceAutoTransferUI.fNC();
        AppMethodBeat.o(68777);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68761);
        super.onCreate(bundle);
        setMMTitle("");
        initView();
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        if (getIntent().getIntExtra("show_open_toast", 0) == 1) {
            Toast.makeText(this, (int) R.string.ift, 0).show();
        }
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do qry setting");
        new e().aYI().b(new a<Object, c.a<dhl>>() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<dhl> aVar) {
                AppMethodBeat.i(68757);
                c.a<dhl> aVar2 = aVar;
                Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "qry back: %s, %s, %s", Integer.valueOf(aVar2.errCode), Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errType));
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    ag.aUH(((dhl) aVar2.iLC).HuS);
                    if (((dhl) aVar2.iLC).pTZ == 0) {
                        WalletLqtBalanceAutoTransferUI.this.Hxd = ((dhl) aVar2.iLC).MLN;
                        WalletLqtBalanceAutoTransferUI.this.Hxe = ((dhl) aVar2.iLC).MLO;
                        WalletLqtBalanceAutoTransferUI.a(WalletLqtBalanceAutoTransferUI.this, (dhl) aVar2.iLC);
                    } else {
                        f.cP(WalletLqtBalanceAutoTransferUI.this.getContext(), ((dhl) aVar2.iLC).pUa);
                    }
                } else {
                    f.ar(WalletLqtBalanceAutoTransferUI.this.getContext(), aVar2.errMsg);
                }
                AppMethodBeat.o(68757);
                return null;
            }
        });
        AppMethodBeat.o(68761);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68762);
        this.HwU = (MMSwitchBtn) findViewById(R.id.e_d);
        this.mPa = (TextView) findViewById(R.id.e_m);
        this.jVn = (TextView) findViewById(R.id.e_h);
        this.yQj = (TextView) findViewById(R.id.e_j);
        this.HwY = (LinearLayout) findViewById(R.id.e_k);
        this.HwZ = findViewById(R.id.e_g);
        this.HwV = (TextView) findViewById(R.id.e_f);
        this.HwW = (TextView) findViewById(R.id.e_l);
        this.HwX = (FrameLayout) findViewById(R.id.e_e);
        this.Hxf = findViewById(R.id.e_i);
        this.HwU.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI.AnonymousClass1 */
            long Hxg = 0;

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                boolean z2 = true;
                AppMethodBeat.i(68752);
                Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "click switch: %s", Boolean.valueOf(z));
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - this.Hxg < 1000) {
                    Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "skip");
                    MMSwitchBtn mMSwitchBtn = WalletLqtBalanceAutoTransferUI.this.HwU;
                    if (z) {
                        z2 = false;
                    }
                    mMSwitchBtn.setCheck(z2);
                    this.Hxg = elapsedRealtime;
                    AppMethodBeat.o(68752);
                    return;
                }
                this.Hxg = elapsedRealtime;
                if (z) {
                    WalletLqtBalanceAutoTransferUI.a(WalletLqtBalanceAutoTransferUI.this, 16);
                    AppMethodBeat.o(68752);
                    return;
                }
                WalletLqtBalanceAutoTransferUI.b(WalletLqtBalanceAutoTransferUI.this);
                AppMethodBeat.o(68752);
            }
        });
        this.HwY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(68753);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtBalanceAutoTransferUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.WalletLqtBalanceAutoTransferUI", "click time layout");
                WalletLqtBalanceAutoTransferUI.c(WalletLqtBalanceAutoTransferUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtBalanceAutoTransferUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68753);
            }
        });
        AppMethodBeat.o(68762);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b2s;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(68763);
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "on activity result: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        String str = "";
        if (intent != null) {
            str = intent.getStringExtra("encrypt_pwd");
        }
        if (i2 == 16) {
            if (i3 == -1) {
                Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do open");
                final Dialog c2 = h.c(getContext(), false, null);
                new d(str).aYI().b(new a<Object, c.a<cwy>>() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI.AnonymousClass7 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Object call(c.a<cwy> aVar) {
                        AppMethodBeat.i(68758);
                        c.a<cwy> aVar2 = aVar;
                        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "open back: %s, %s, %s", Integer.valueOf(aVar2.errCode), Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errType));
                        if (c2 != null) {
                            c2.dismiss();
                        }
                        if (aVar2.errType != 0 || aVar2.errCode != 0) {
                            WalletLqtBalanceAutoTransferUI.this.HwU.setCheck(false);
                            f.ar(WalletLqtBalanceAutoTransferUI.this.getContext(), aVar2.errMsg);
                        } else if (((cwy) aVar2.iLC).pTZ == 0) {
                            WalletLqtBalanceAutoTransferUI.this.HwU.setCheck(true);
                            WalletLqtBalanceAutoTransferUI.g(WalletLqtBalanceAutoTransferUI.this);
                        } else {
                            WalletLqtBalanceAutoTransferUI.this.HwU.setCheck(false);
                            f.cP(WalletLqtBalanceAutoTransferUI.this.getContext(), ((cwy) aVar2.iLC).pUa);
                        }
                        AppMethodBeat.o(68758);
                        return null;
                    }
                });
                AppMethodBeat.o(68763);
                return;
            }
            fNz();
            AppMethodBeat.o(68763);
        } else if (i2 != 32) {
            super.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(68763);
        } else if (i3 == -1) {
            Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do close");
            final Dialog c3 = h.c(getContext(), false, null);
            new com.tencent.mm.plugin.wallet.balance.model.lqt.b(str).aYI().b(new a<Object, c.a<abi>>() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI.AnonymousClass8 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(c.a<abi> aVar) {
                    AppMethodBeat.i(68759);
                    c.a<abi> aVar2 = aVar;
                    Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "close back: %s, %s, %s", Integer.valueOf(aVar2.errCode), Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errType));
                    if (c3 != null) {
                        c3.dismiss();
                    }
                    if (aVar2.errType != 0 || aVar2.errCode != 0) {
                        WalletLqtBalanceAutoTransferUI.this.HwU.setCheck(true);
                        f.ar(WalletLqtBalanceAutoTransferUI.this.getContext(), aVar2.errMsg);
                    } else if (((abi) aVar2.iLC).pTZ == 0) {
                        WalletLqtBalanceAutoTransferUI.this.HwU.setCheck(false);
                        WalletLqtBalanceAutoTransferUI.h(WalletLqtBalanceAutoTransferUI.this);
                    } else {
                        WalletLqtBalanceAutoTransferUI.this.HwU.setCheck(true);
                        f.cP(WalletLqtBalanceAutoTransferUI.this.getContext(), ((abi) aVar2.iLC).pUa);
                    }
                    AppMethodBeat.o(68759);
                    return null;
                }
            });
            AppMethodBeat.o(68763);
        } else {
            fNy();
            AppMethodBeat.o(68763);
        }
    }

    private void fNy() {
        AppMethodBeat.i(68764);
        this.HwU.setCheck(true);
        this.Hxf.setVisibility(8);
        fNA();
        AppMethodBeat.o(68764);
    }

    private void fNz() {
        AppMethodBeat.i(68765);
        this.HwU.setCheck(false);
        this.Hxf.setVisibility(8);
        fNB();
        AppMethodBeat.o(68765);
    }

    private void fNA() {
        AppMethodBeat.i(68766);
        this.HwY.setVisibility(0);
        this.HwZ.setVisibility(0);
        AppMethodBeat.o(68766);
    }

    private void fNB() {
        AppMethodBeat.i(68767);
        this.HwY.setVisibility(8);
        this.HwZ.setVisibility(8);
        AppMethodBeat.o(68767);
    }

    private String a(ehn ehn) {
        AppMethodBeat.i(68768);
        DecimalFormat decimalFormat = new DecimalFormat("00");
        String string = getString(R.string.ifu, new Object[]{decimalFormat.format((long) (ehn.Nhb / 60)), decimalFormat.format((long) (ehn.pSb / 60))});
        AppMethodBeat.o(68768);
        return string;
    }

    private void fNC() {
        AppMethodBeat.i(68769);
        if (this.Hxb != null) {
            this.yQj.setText(a(this.Hxb));
            AppMethodBeat.o(68769);
            return;
        }
        this.yQj.setText("");
        AppMethodBeat.o(68769);
    }

    static /* synthetic */ void a(WalletLqtBalanceAutoTransferUI walletLqtBalanceAutoTransferUI, int i2) {
        AppMethodBeat.i(68770);
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "go to pwd");
        Intent intent = new Intent(walletLqtBalanceAutoTransferUI, WalletCheckPwdNewUI.class);
        intent.putExtra("scene", 3);
        walletLqtBalanceAutoTransferUI.startActivityForResult(intent, i2);
        AppMethodBeat.o(68770);
    }

    static /* synthetic */ void b(WalletLqtBalanceAutoTransferUI walletLqtBalanceAutoTransferUI) {
        AppMethodBeat.i(68771);
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "show close alert");
        if (Util.isNullOrNil(walletLqtBalanceAutoTransferUI.Hxe)) {
            walletLqtBalanceAutoTransferUI.Hxe = walletLqtBalanceAutoTransferUI.getString(R.string.ifr);
        }
        d.a aVar = new d.a(walletLqtBalanceAutoTransferUI.getContext());
        aVar.Dk(false);
        aVar.bon("");
        aVar.boo(walletLqtBalanceAutoTransferUI.Hxe);
        aVar.aoV(R.string.ifs);
        aVar.aoW(R.string.sz);
        aVar.aoX(walletLqtBalanceAutoTransferUI.getResources().getColor(R.color.Red_100));
        aVar.a(true, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(68754);
                WalletLqtBalanceAutoTransferUI.a(WalletLqtBalanceAutoTransferUI.this, 32);
                AppMethodBeat.o(68754);
            }
        });
        aVar.d(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(68755);
                Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "cancel close");
                WalletLqtBalanceAutoTransferUI.this.HwU.setCheck(true);
                AppMethodBeat.o(68755);
            }
        });
        com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
        hbn.show();
        walletLqtBalanceAutoTransferUI.addDialog(hbn);
        AppMethodBeat.o(68771);
    }

    static /* synthetic */ void c(WalletLqtBalanceAutoTransferUI walletLqtBalanceAutoTransferUI) {
        AppMethodBeat.i(68772);
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "show time panel");
        if (walletLqtBalanceAutoTransferUI.Hxd != null) {
            String[] strArr = new String[walletLqtBalanceAutoTransferUI.Hxd.MIo.size()];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                strArr[i2] = walletLqtBalanceAutoTransferUI.a(walletLqtBalanceAutoTransferUI.Hxd.MIo.get(i2));
            }
            final com.tencent.mm.ui.widget.picker.c cVar = new com.tencent.mm.ui.widget.picker.c(walletLqtBalanceAutoTransferUI.getContext(), strArr);
            cVar.app(walletLqtBalanceAutoTransferUI.Hxa);
            cVar.QTc = new c.b() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI.AnonymousClass5 */

                @Override // com.tencent.mm.ui.widget.picker.c.b
                public final void onResult(boolean z, Object obj, Object obj2) {
                    AppMethodBeat.i(68756);
                    cVar.hide();
                    if (z && cVar.hci() >= 0 && cVar.hci() < WalletLqtBalanceAutoTransferUI.this.Hxd.MIo.size()) {
                        WalletLqtBalanceAutoTransferUI.this.Hxa = cVar.hci();
                        WalletLqtBalanceAutoTransferUI.this.Hxc = WalletLqtBalanceAutoTransferUI.this.Hxd.MIo.get(WalletLqtBalanceAutoTransferUI.this.Hxa);
                        WalletLqtBalanceAutoTransferUI.f(WalletLqtBalanceAutoTransferUI.this);
                    }
                    AppMethodBeat.o(68756);
                }
            };
            cVar.show();
        }
        AppMethodBeat.o(68772);
    }

    static /* synthetic */ void f(WalletLqtBalanceAutoTransferUI walletLqtBalanceAutoTransferUI) {
        AppMethodBeat.i(68773);
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do modify time");
        final Dialog c2 = h.c(walletLqtBalanceAutoTransferUI.getContext(), false, null);
        new com.tencent.mm.plugin.wallet.balance.model.lqt.c(walletLqtBalanceAutoTransferUI.Hxc).aYI().b(new a<Object, c.a<cra>>() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI.AnonymousClass9 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<cra> aVar) {
                AppMethodBeat.i(68760);
                c.a<cra> aVar2 = aVar;
                Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "modify back: %s, %s, %s", Integer.valueOf(aVar2.errCode), Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errType));
                if (c2 != null) {
                    c2.dismiss();
                }
                if (aVar2.errType != 0 || aVar2.errCode != 0) {
                    f.ar(WalletLqtBalanceAutoTransferUI.this.getContext(), aVar2.errMsg);
                } else if (((cra) aVar2.iLC).pTZ == 0) {
                    WalletLqtBalanceAutoTransferUI.this.Hxb = WalletLqtBalanceAutoTransferUI.this.Hxc;
                    WalletLqtBalanceAutoTransferUI.j(WalletLqtBalanceAutoTransferUI.this);
                } else {
                    f.cP(WalletLqtBalanceAutoTransferUI.this.getContext(), ((cra) aVar2.iLC).pUa);
                }
                AppMethodBeat.o(68760);
                return null;
            }
        });
        AppMethodBeat.o(68773);
    }

    static /* synthetic */ void a(WalletLqtBalanceAutoTransferUI walletLqtBalanceAutoTransferUI, dhl dhl) {
        AppMethodBeat.i(68774);
        walletLqtBalanceAutoTransferUI.mPa.setText(dhl.MIm);
        walletLqtBalanceAutoTransferUI.jVn.setText(dhl.MIn);
        if (dhl.MLL != null) {
            walletLqtBalanceAutoTransferUI.HwV.setText(dhl.MLL.title);
            if (dhl.MLL.KDU == 0) {
                walletLqtBalanceAutoTransferUI.fNz();
            } else if (dhl.MLL.KDU == 1) {
                walletLqtBalanceAutoTransferUI.fNy();
            } else if (dhl.MLL.KDU == 2) {
                walletLqtBalanceAutoTransferUI.HwU.setCheck(false);
                walletLqtBalanceAutoTransferUI.HwU.setEnabled(false);
                walletLqtBalanceAutoTransferUI.Hxf.setVisibility(0);
                walletLqtBalanceAutoTransferUI.fNB();
            }
        }
        if (dhl.MLM != null) {
            walletLqtBalanceAutoTransferUI.HwW.setText(dhl.MLM.title);
            if (dhl.MLM.Mwt != null) {
                walletLqtBalanceAutoTransferUI.Hxb = dhl.MLM.Mwt;
                walletLqtBalanceAutoTransferUI.Hxa = dhl.MLM.Mwt.Nhb / 60;
                walletLqtBalanceAutoTransferUI.fNC();
            }
        }
        AppMethodBeat.o(68774);
    }
}
