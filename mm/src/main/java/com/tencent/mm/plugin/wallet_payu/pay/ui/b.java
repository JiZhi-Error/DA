package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.d;
import com.tencent.mm.plugin.wallet_core.ui.e;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

public class b extends s {
    private AbstractC1927b Iud;
    private int Iue = 0;
    private boolean Iuf = false;
    private a Iug;

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.b$b  reason: collision with other inner class name */
    public interface AbstractC1927b {
        void a(String str, String str2, FavorPayInfo favorPayInfo);
    }

    public b(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.s
    public final void bh(Context context) {
        AppMethodBeat.i(258007);
        hO(context);
        super.hP(context);
        if (this.Ijp != null) {
            this.Ijp.setVisibility(8);
        }
        AppMethodBeat.o(258007);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.s
    public final void hP(Context context) {
        AppMethodBeat.i(258759);
        super.hP(context);
        AppMethodBeat.o(258759);
    }

    public static b a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, AbstractC1927b bVar, View.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener, boolean z) {
        List<t> list;
        String str;
        boolean z2;
        String str2;
        AppMethodBeat.i(72140);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.o(72140);
            return null;
        }
        d a2 = e.INSTANCE.a(orders);
        if (a2 != null) {
            if (favorPayInfo != null) {
                if (bankcard != null && !bankcard.field_bankcardType.equals(favorPayInfo.HXK)) {
                    String cG = a2.cG(favorPayInfo.HXI, false);
                    d.a aVar = a2.cF(cG, true).get(bankcard.field_bankcardType);
                    if (aVar == null || aVar.IcR == null || Util.isNullOrNil(aVar.IcR.HEJ)) {
                        favorPayInfo.HXI = cG;
                    } else {
                        favorPayInfo.HXI = aVar.IcR.HEJ;
                    }
                }
            } else if (orders.HZe != null) {
                favorPayInfo = a2.aVM(a2.aVN(orders.HZe.HEt));
            }
            list = a2.fSz();
        } else {
            Log.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
            list = null;
        }
        Orders.Commodity commodity = orders.HZd.get(0);
        StringBuilder sb = new StringBuilder();
        if (Util.isNullOrNil(commodity.AOa)) {
            str = "";
        } else {
            str = commodity.AOa + "\n";
        }
        String sb2 = sb.append(str).append(orders.HZd.get(0).desc).toString();
        String str3 = null;
        String str4 = null;
        String str5 = null;
        double d2 = orders.dDO;
        if (a2 == null || favorPayInfo == null) {
            z2 = false;
        } else {
            j aVJ = a2.aVJ(favorPayInfo.HXI);
            if (aVJ != null && aVJ.HEK > 0.0d) {
                d2 = aVJ.HEs;
                str4 = f.d(orders.dDO, orders.AOl);
                str3 = f.d(aVJ.HEs, orders.AOl);
                Object[] objArr = {f.formatMoney2f(aVJ.HEK)};
                z2 = true;
                str5 = context.getString(R.string.inn, objArr);
            } else if (list == null || list.size() <= 0) {
                z2 = false;
                str3 = f.d(orders.dDO, orders.AOl);
            } else {
                z2 = true;
                str5 = context.getString(R.string.ip6);
            }
        }
        if (bankcard == null) {
            str2 = "";
        } else {
            str2 = bankcard.field_desc;
        }
        b bVar2 = new b(context);
        bVar2.Ijo = bankcard;
        bVar2.a(context, orders, favorPayInfo, bankcard);
        bVar2.c(onCancelListener);
        bVar2.setOnCancelListener(onCancelListener);
        bVar2.setCancelable(true);
        bVar2.aVR(sb2);
        bVar2.d(str3, d2);
        bVar2.aVT(str4);
        bVar2.a(str2, onClickListener, z2);
        if (!TextUtils.isEmpty(str5)) {
            bVar2.IiZ.setVisibility(0);
            bVar2.IiZ.setText(str5);
        } else {
            bVar2.IiZ.setVisibility(8);
        }
        bVar2.Iuf = z;
        bVar2.Ija.setEncrType(-10);
        bVar2.Iud = bVar;
        bVar2.show();
        h.a(context, bVar2);
        AppMethodBeat.o(72140);
        return bVar2;
    }

    class a {
        public s.a IjH;
        public String Iui;
        public Bankcard Iuj;
        public FavorPayInfo Iuk;
        public boolean Iul;
        public AbstractC1927b Ium;
        public DialogInterface.OnCancelListener Iun;

        public a(String str, Bankcard bankcard, FavorPayInfo favorPayInfo, boolean z, DialogInterface.OnCancelListener onCancelListener, s.a aVar, AbstractC1927b bVar) {
            this.Iui = str;
            this.Iuj = bankcard;
            this.Iuk = favorPayInfo;
            this.Iul = z;
            this.Iun = onCancelListener;
            this.IjH = aVar;
            this.Ium = bVar;
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.s
    public final void fTe() {
        String str;
        AppMethodBeat.i(72141);
        if (this.Ijl != null) {
            this.Ijl.onClick(this, 0);
        }
        dismiss();
        if (this.Iud != null) {
            if (!this.Iuf) {
                this.Iud.a(this.Ija.getText(), "", this.HGf);
            } else if (this.Iue == 0) {
                Context context = getContext();
                final a aVar = new a(this.Ija.getText(), this.Ijo, this.HGf, this.Ijm, this.XY, this.IjH, this.Iud);
                if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                    AnonymousClass1 r1 = new b(context) {
                        /* class com.tencent.mm.plugin.wallet_payu.pay.ui.b.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.wallet_core.ui.s
                        public final int fTi() {
                            AppMethodBeat.i(72137);
                            int i2 = 3;
                            if (aVar.Iuj != null && aVar.Iuj.field_bankcardClientType == 1) {
                                Log.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                                i2 = new com.tencent.mm.plugin.wallet_core.model.a.b(aVar.Iuj).IcC;
                            }
                            if (i2 == 4) {
                                Log.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
                                AppMethodBeat.o(72137);
                                return R.layout.bhg;
                            }
                            AppMethodBeat.o(72137);
                            return R.layout.bhh;
                        }
                    };
                    r1.Iue = 1;
                    r1.Iuf = true;
                    r1.Iug = aVar;
                    if (r1.Iug != null) {
                        r1.c(r1.Iug.Iun);
                        r1.setOnCancelListener(r1.Iug.Iun);
                        r1.setCancelable(true);
                        if (r1.Iug.Iuj == null) {
                            str = "";
                        } else {
                            str = r1.Iug.Iuj.field_desc;
                        }
                        r1.d(str, 0.0d);
                        r1.ys(false);
                        r1.a(r1.Iug.IjH);
                        r1.Iud = r1.Iug.Ium;
                        r1.Ija.setEncrType(30);
                        r1.show();
                        h.a(context, r1);
                    }
                    AppMethodBeat.o(72141);
                    return;
                }
                AppMethodBeat.o(72141);
                return;
            } else if (this.Iue == 1) {
                this.Iud.a(this.Iug.Iui, this.Ija.getText(), this.Iug.Iuk);
                AppMethodBeat.o(72141);
                return;
            } else {
                Log.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
                AppMethodBeat.o(72141);
                return;
            }
        }
        AppMethodBeat.o(72141);
    }
}
