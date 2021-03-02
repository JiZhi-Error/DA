package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class b {
    private static final String HCA = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2_) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png");
    private static final String HCB = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2_) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png");
    private static final String HCC = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2_) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png");
    private static final String HCD = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2_) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png");
    private static final String HCE = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2_) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png");
    private static final String HCz = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2_) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png");

    static {
        AppMethodBeat.i(214249);
        AppMethodBeat.o(214249);
    }

    public static View a(Context context, View view, Bankcard bankcard, int i2, com.tencent.mm.plugin.wallet_core.utils.a aVar, boolean z) {
        a aVar2;
        AppMethodBeat.i(71478);
        if (view == null || view.getTag() == null) {
            view = View.inflate(context, i2, null);
            a aVar3 = new a();
            aVar3.HCR = (ImageView) view.findViewById(R.id.a0k);
            aVar3.HCN = (TextView) view.findViewById(R.id.a0t);
            aVar3.HCO = (TextView) view.findViewById(R.id.a23);
            aVar3.HCM = (TextView) view.findViewById(R.id.a1l);
            aVar3.HCM.setTextSize(1, 32.0f);
            aVar3.HCS = (TextView) view.findViewById(R.id.a1k);
            aVar3.HCP = (ViewGroup) view.findViewById(R.id.je9);
            aVar3.HCQ = (ImageView) view.findViewById(R.id.a1u);
            aVar3.HCT = (TextView) view.findViewById(R.id.a1f);
            aVar3.ImN = (ViewGroup) view.findViewById(R.id.a1h);
            aVar3.ImO = (TextView) view.findViewById(R.id.a13);
            aVar3.ImP = (ImageView) view.findViewById(R.id.a1v);
            aVar3.ImQ = (TextView) view.findViewById(R.id.a1z);
            view.setTag(aVar3);
            aVar2 = aVar3;
        } else {
            aVar2 = (a) view.getTag();
        }
        if (bankcard.field_bankcardState == 1) {
            aVar2.HCS.setVisibility(0);
        } else {
            aVar2.HCS.setVisibility(8);
        }
        if (z) {
            aVar2.ImQ.setText(context.getString(R.string.i8a));
            aVar2.ImQ.setVisibility(0);
        } else if (!Util.isNullOrNil(bankcard.field_card_state_name)) {
            aVar2.ImQ.setText(bankcard.field_card_state_name);
            aVar2.ImQ.setVisibility(0);
        } else {
            aVar2.ImQ.setVisibility(8);
        }
        aVar2.HCN.setVisibility(0);
        aVar2.HCN.setText(bankcard.field_bankName);
        if (z.aUo()) {
            aVar2.HCO.setVisibility(8);
        } else if (!Util.isNullOrNil(bankcard.field_bankcardTypeName)) {
            aVar2.HCO.setText(bankcard.field_bankcardTypeName);
        } else if (bankcard.fQa()) {
            aVar2.HCO.setText(R.string.iw1);
        } else if (bankcard.fQd()) {
            aVar2.HCO.setText(R.string.ibk);
        } else {
            aVar2.HCO.setText(R.string.ic4);
        }
        if (aVar2.HCM != null) {
            aVar2.HCM.setText(bankcard.field_bankcardTail);
        }
        if (Util.isNullOrNil(bankcard.field_card_bottom_wording) || aVar2.ImO == null) {
            aVar2.ImN.setVisibility(8);
        } else {
            aVar2.ImO.setText(bankcard.field_card_bottom_wording);
            aVar2.ImN.setVisibility(0);
        }
        aVar.a(context, bankcard, aVar2.HCR, aVar2.HCP, aVar2.HCQ, aVar2.ImQ);
        if (aVar2.HCT != null) {
            t.fQI();
            aVar2.HCT.setVisibility(8);
        }
        AppMethodBeat.o(71478);
        return view;
    }

    public static Drawable b(Context context, Bitmap bitmap) {
        AppMethodBeat.i(71480);
        if (bitmap == null) {
            AppMethodBeat.o(71480);
            return null;
        }
        try {
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(context.getResources(), bitmap, ninePatchChunk, new Rect(), null);
                ninePatchDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                AppMethodBeat.o(71480);
                return ninePatchDrawable;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            AppMethodBeat.o(71480);
            return bitmapDrawable;
        } catch (Exception e2) {
            Log.f("MicroMsg.BankcardListAdapter", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.BankcardListAdapter", e2, "", new Object[0]);
            AppMethodBeat.o(71480);
            return null;
        }
    }

    public static int aVW(String str) {
        AppMethodBeat.i(214248);
        if (HCz.equals(str)) {
            AppMethodBeat.o(214248);
            return R.drawable.cqs;
        } else if (HCD.equals(str)) {
            AppMethodBeat.o(214248);
            return R.drawable.cqv;
        } else if (HCC.equals(str)) {
            AppMethodBeat.o(214248);
            return R.drawable.cqx;
        } else if (HCE.equals(str)) {
            AppMethodBeat.o(214248);
            return R.drawable.cr3;
        } else if (HCA.equals(str)) {
            AppMethodBeat.o(214248);
            return R.drawable.cr4;
        } else if (HCB.equals(str)) {
            AppMethodBeat.o(214248);
            return R.drawable.cr9;
        } else {
            AppMethodBeat.o(214248);
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements u.a {
        public TextView HCM = null;
        public TextView HCN = null;
        public TextView HCO = null;
        public ViewGroup HCP = null;
        public ImageView HCQ = null;
        public ImageView HCR = null;
        public TextView HCS = null;
        public TextView HCT = null;
        public TextView HCU = null;
        public e ImM;
        public ViewGroup ImN = null;
        public TextView ImO = null;
        public ImageView ImP = null;
        public TextView ImQ = null;

        a() {
        }

        @Override // com.tencent.mm.platformtools.u.a
        public final void k(String str, final Bitmap bitmap) {
            AppMethodBeat.i(71477);
            Log.d("MicroMsg.BankcardListAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.ImM == null) {
                AppMethodBeat.o(71477);
                return;
            }
            if (str.equals(this.ImM.AAU)) {
                this.HCR.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.view.b.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(71475);
                        a.this.HCR.setImageBitmap(bitmap);
                        a.this.HCP.invalidate();
                        AppMethodBeat.o(71475);
                    }
                });
            }
            if (str.equals(this.ImM.HWd) && this.HCQ != null) {
                this.HCQ.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.view.b.a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(71476);
                        a.this.HCQ.setImageBitmap(bitmap);
                        AppMethodBeat.o(71476);
                    }
                });
            }
            AppMethodBeat.o(71477);
        }
    }
}
