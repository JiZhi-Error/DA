package com.tencent.mm.plugin.wallet_index.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class b implements i {
    public boolean IqH = false;
    public q IqI;
    public Dialog jUC = null;
    public Context mContext;

    public final void yz(boolean z) {
        AppMethodBeat.i(214266);
        if (!z && this.jUC == null) {
            this.jUC = h.a(this.mContext, 3, (int) R.style.lj, this.mContext.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.wallet_index.c.b.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(214263);
                    if (b.this.jUC != null && b.this.jUC.isShowing()) {
                        b.this.jUC.dismiss();
                    }
                    AppMethodBeat.o(214263);
                }
            });
        }
        g.aAi();
        this.IqI = new com.tencent.mm.plugin.wallet_index.c.a.b(((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue());
        g.azz().a(this.IqI, 0);
        this.IqH = z;
        AppMethodBeat.o(214266);
    }

    public static daj fUn() {
        AppMethodBeat.i(214267);
        Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 getConfig");
        daj daj = new daj();
        String str = (String) ((a) g.ah(a.class)).getWalletCacheStg().get(ar.a.USERINFO_WX_PAY_HK_WALLET_ADD_CONFIG_STRING_SYNC, (Object) null);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.HKOfflineLogic", "OfflineH5 get PayIBGQuickGetOverseaWalletConfig failed");
        } else {
            try {
                daj.parseFrom(str.getBytes(StandardCharsets.ISO_8859_1));
                Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 getConfig success");
            } catch (Exception e2) {
                Log.e("MicroMsg.HKOfflineLogic", "OfflineH5 parse PayIBGQuickGetOverseaWalletConfig fail, " + e2.getLocalizedMessage());
            }
        }
        AppMethodBeat.o(214267);
        return daj;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        IOException e2;
        String str2;
        AppMethodBeat.i(214268);
        Log.i("MicroMsg.HKOfflineLogic", "on Scene End：errType %s , errCode：%s，errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.jUC != null && this.jUC.isShowing()) {
            this.jUC.dismiss();
            this.jUC = null;
        }
        if ((qVar instanceof com.tencent.mm.plugin.wallet_index.c.a.b) && qVar.equals(this.IqI)) {
            if (i2 == 0 && i3 == 0) {
                daj fUq = ((com.tencent.mm.plugin.wallet_index.c.a.b) qVar).fUq();
                if (fUq.dOK == 0) {
                    Log.i("MicroMsg.HKOfflineLogic", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd ok，pay_wallet_wxapp_h5_url：%s, cache_time：%s", fUq.MFD, Integer.valueOf(fUq.MFE));
                    if (!this.IqH && fUo()) {
                        Log.d("MicroMsg.HKOfflineLogic", "on Scene End jump h5 ");
                        f.o(this.mContext, fUq.MFD, false);
                    }
                    fUq.MFF = System.currentTimeMillis();
                    Log.d("MicroMsg.HKOfflineLogic", "on Scene End currentTime ：%s ", Long.valueOf(fUq.MFF));
                    Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 setConfig");
                    String str3 = " ";
                    if (fUq != null) {
                        try {
                            str2 = new String(fUq.toByteArray(), StandardCharsets.ISO_8859_1);
                            try {
                                Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 setConfig success");
                                str3 = str2;
                            } catch (IOException e3) {
                                e2 = e3;
                                Log.e("MicroMsg.HKOfflineLogic", "save config exp, " + e2.getLocalizedMessage());
                                str3 = str2;
                                ((a) g.ah(a.class)).getWalletCacheStg().set(ar.a.USERINFO_WX_PAY_HK_WALLET_ADD_CONFIG_STRING_SYNC, str3);
                                g.azz().b(2540, this);
                                this.IqI = null;
                                AppMethodBeat.o(214268);
                            }
                        } catch (IOException e4) {
                            e2 = e4;
                            str2 = str3;
                            Log.e("MicroMsg.HKOfflineLogic", "save config exp, " + e2.getLocalizedMessage());
                            str3 = str2;
                            ((a) g.ah(a.class)).getWalletCacheStg().set(ar.a.USERINFO_WX_PAY_HK_WALLET_ADD_CONFIG_STRING_SYNC, str3);
                            g.azz().b(2540, this);
                            this.IqI = null;
                            AppMethodBeat.o(214268);
                        }
                    }
                    ((a) g.ah(a.class)).getWalletCacheStg().set(ar.a.USERINFO_WX_PAY_HK_WALLET_ADD_CONFIG_STRING_SYNC, str3);
                } else {
                    Log.i("MicroMsg.HKOfflineLogic", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd failed show dialog ");
                    if (!this.IqH && fUo()) {
                        h.a(this.mContext, fUq.dOL, "", this.mContext.getString(R.string.j34), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet_index.c.b.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(214264);
                                Log.d("MicroMsg.HKOfflineLogic", "onDialogClick() ");
                                AppMethodBeat.o(214264);
                            }
                        });
                    }
                }
            } else {
                Log.i("MicroMsg.HKOfflineLogic", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd faile show error dialog ");
                if (!this.IqH && fUo()) {
                    h.a(this.mContext, str, "", this.mContext.getString(R.string.j34), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_index.c.b.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(214265);
                            Log.d("MicroMsg.HKOfflineLogic", "onDialogClick() ");
                            AppMethodBeat.o(214265);
                        }
                    });
                }
            }
        }
        g.azz().b(2540, this);
        this.IqI = null;
        AppMethodBeat.o(214268);
    }

    private boolean fUo() {
        AppMethodBeat.i(214269);
        String topActivityName2 = Util.getTopActivityName2(this.mContext);
        if (Util.isNullOrNil(topActivityName2) || !topActivityName2.equals("LauncherUI")) {
            Log.d("MicroMsg.HKOfflineLogic", "LauncherUI is not on ActivityTask Top：%s", topActivityName2);
            AppMethodBeat.o(214269);
            return false;
        }
        Log.d("MicroMsg.HKOfflineLogic", "LauncherUI is on ActivityTask Top ");
        AppMethodBeat.o(214269);
        return true;
    }
}
