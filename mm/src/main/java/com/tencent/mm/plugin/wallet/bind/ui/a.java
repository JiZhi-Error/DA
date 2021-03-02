package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.view.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a extends BaseAdapter {
    private static final String HCA = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2_) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png");
    private static final String HCB = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2_) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png");
    private static final String HCC = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2_) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png");
    private static final String HCD = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2_) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png");
    private static final String HCE = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2_) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png");
    private static final String HCz = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2_) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png");
    private ArrayList<Bankcard> HCF;
    private int HCG;
    com.tencent.mm.plugin.wallet_core.utils.a HCH;
    List<String> HCI;
    private final Context mContext;
    private int mCount = 0;

    public /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(69075);
        Bankcard aeu = aeu(i2);
        AppMethodBeat.o(69075);
        return aeu;
    }

    static {
        AppMethodBeat.i(214049);
        AppMethodBeat.o(214049);
    }

    public a(Context context, ArrayList<Bankcard> arrayList) {
        AppMethodBeat.i(69069);
        this.mContext = context;
        this.HCF = arrayList;
        this.HCG = 0;
        this.HCH = new com.tencent.mm.plugin.wallet_core.utils.a();
        this.HCH.b(this.mContext, this.HCF);
        fNW();
        AppMethodBeat.o(69069);
    }

    public final void aV(ArrayList<Bankcard> arrayList) {
        AppMethodBeat.i(69070);
        this.HCF = arrayList;
        if (arrayList != null) {
            this.mCount = arrayList.size();
        } else {
            this.mCount = 0;
        }
        if (this.mCount > 0) {
            this.HCH.b(this.mContext, this.HCF);
        }
        fNW();
        AppMethodBeat.o(69070);
    }

    private void fNW() {
        AppMethodBeat.i(69071);
        g.aAi();
        this.HCI = Util.stringsToList(((String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, "")).split(","));
        AppMethodBeat.o(69071);
    }

    public int getCount() {
        return this.mCount;
    }

    private Bankcard aeu(int i2) {
        AppMethodBeat.i(69072);
        if (i2 < 0 || i2 >= this.mCount) {
            AppMethodBeat.o(69072);
            return null;
        }
        Bankcard bankcard = this.HCF.get(i2);
        AppMethodBeat.o(69072);
        return bankcard;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public int getItemViewType(int i2) {
        AppMethodBeat.i(69073);
        Bankcard aeu = aeu(i2);
        if (aeu == null) {
            AppMethodBeat.o(69073);
            return 4;
        } else if (aeu.field_bankcardState == 9) {
            if (aeu.field_wxcreditState == 0) {
                AppMethodBeat.o(69073);
                return 2;
            }
            AppMethodBeat.o(69073);
            return 3;
        } else if (aeu.fQa() && "CITIC_CREDIT".equals(aeu.field_bankcardType)) {
            AppMethodBeat.o(69073);
            return 5;
        } else if (aeu.fQf()) {
            AppMethodBeat.o(69073);
            return 6;
        } else if (!aeu.fQe() || z.aUo()) {
            AppMethodBeat.o(69073);
            return 1;
        } else {
            AppMethodBeat.o(69073);
            return 0;
        }
    }

    public int getViewTypeCount() {
        return 7;
    }

    public View getView(int i2, final View view, ViewGroup viewGroup) {
        boolean z;
        final C1903a aVar;
        C1903a aVar2;
        C1903a aVar3;
        AppMethodBeat.i(69074);
        Bankcard aeu = aeu(i2);
        if (aeu == null) {
            AppMethodBeat.o(69074);
            return view;
        }
        int itemViewType = getItemViewType(i2);
        if (this.HCI != null && !this.HCI.isEmpty() && aeu != null) {
            Iterator<String> it = this.HCI.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equals(aeu.field_bindSerial)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        } else {
            z = false;
        }
        Log.v("MicroMsg.BankcardListAdapter", "getView, pos: %d, bottom_wording: %s, showNew: %s", Integer.valueOf(i2), aeu.field_card_bottom_wording, Boolean.valueOf(z));
        switch (itemViewType) {
            case 0:
                View a2 = b.a(this.mContext, view, aeu, R.layout.c7w, this.HCH, z);
                AppMethodBeat.o(69074);
                return a2;
            case 1:
                View a3 = b.a(this.mContext, view, aeu, R.layout.c83, this.HCH, z);
                AppMethodBeat.o(69074);
                return a3;
            case 2:
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, R.layout.c87, null);
                    C1903a aVar4 = new C1903a();
                    aVar4.HCR = (ImageView) view.findViewById(R.id.a0k);
                    aVar4.HCN = (TextView) view.findViewById(R.id.a0t);
                    aVar4.HCU = (TextView) view.findViewById(R.id.fxa);
                    aVar4.HCV = (ImageView) view.findViewById(R.id.a1m);
                    aVar4.HCW = (ImageView) view.findViewById(R.id.a1n);
                    aVar4.HCX = (ImageView) view.findViewById(R.id.a1o);
                    view.setTag(aVar4);
                    aVar2 = aVar4;
                } else {
                    aVar2 = (C1903a) view.getTag();
                }
                aVar2.HCN.setText(this.mContext.getString(R.string.idz, aeu.field_bankName));
                if (b.c(aeu)) {
                    aVar2.HCU.setVisibility(0);
                } else {
                    aVar2.HCU.setVisibility(8);
                }
                AppMethodBeat.o(69074);
                return view;
            case 3:
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, R.layout.c8_, null);
                    C1903a aVar5 = new C1903a();
                    aVar5.HCR = (ImageView) view.findViewById(R.id.a0k);
                    aVar5.HCN = (TextView) view.findViewById(R.id.a0t);
                    aVar5.HCS = (TextView) view.findViewById(R.id.a1k);
                    aVar5.HCV = (ImageView) view.findViewById(R.id.a1m);
                    aVar5.HCW = (ImageView) view.findViewById(R.id.a1n);
                    aVar5.HCX = (ImageView) view.findViewById(R.id.a1o);
                    view.setTag(aVar5);
                    aVar3 = aVar5;
                } else {
                    aVar3 = (C1903a) view.getTag();
                }
                switch (aeu.field_wxcreditState) {
                    case 1:
                        aVar3.HCS.setBackgroundResource(R.drawable.cr5);
                        aVar3.HCS.setVisibility(0);
                        break;
                    case 2:
                    default:
                        aVar3.HCS.setVisibility(8);
                        break;
                    case 3:
                        aVar3.HCS.setBackgroundResource(R.drawable.cqu);
                        aVar3.HCS.setVisibility(0);
                        break;
                }
                aVar3.HCN.setText(aeu.field_bankName);
                this.HCH.a(this.mContext, aeu, aVar3.HCR);
                AppMethodBeat.o(69074);
                return view;
            case 4:
                View inflate = View.inflate(this.mContext, R.layout.c7x, null);
                AppMethodBeat.o(69074);
                return inflate;
            case 5:
                View a4 = b.a(this.mContext, view, aeu, R.layout.c88, this.HCH, z);
                AppMethodBeat.o(69074);
                return a4;
            case 6:
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, R.layout.c81, null);
                    aVar = new C1903a();
                    aVar.HCR = (ImageView) view.findViewById(R.id.a0k);
                    aVar.HCN = (TextView) view.findViewById(R.id.a0t);
                    aVar.HCO = (TextView) view.findViewById(R.id.a23);
                    aVar.HCS = (TextView) view.findViewById(R.id.a1k);
                    aVar.HCY = (WalletTextView) view.findViewById(R.id.je6);
                    aVar.HCQ = (ImageView) view.findViewById(R.id.a1u);
                    aVar.HCZ = (TextView) view.findViewById(R.id.je7);
                    aVar.HCP = (ViewGroup) view.findViewById(R.id.je9);
                    view.setTag(aVar);
                } else {
                    aVar = (C1903a) view.getTag();
                }
                aVar.HCR.setImageDrawable(com.tencent.mm.svg.a.a.h(this.mContext.getResources(), R.raw.honey_pay_bank_logo));
                if ((aVar.HCR instanceof CdnImageView) && !Util.isNullOrNil(aeu.HVU)) {
                    ((CdnImageView) aVar.HCR).setUseSdcardCache(true);
                    ((CdnImageView) aVar.HCR).setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.fSn());
                    ((CdnImageView) aVar.HCR).gI(aeu.HVU, R.raw.honey_pay_bank_logo);
                }
                aVar.HCN.setText(l.b(this.mContext, f.hs(f.getDisplayName(aeu.HVQ), 10), aVar.HCN.getTextSize()));
                aVar.HCO.setText(aeu.HVT);
                if (aeu.HVR == 0) {
                    String bigDecimal = f.b(new StringBuilder().append(aeu.HVP).toString(), "100", 2, RoundingMode.HALF_UP).toString();
                    aVar.HCY.setPrefix(ah.hhz());
                    aVar.HCY.setText(bigDecimal);
                    aVar.HCY.setVisibility(0);
                    aVar.HCZ.setVisibility(0);
                } else {
                    aVar.HCY.setVisibility(4);
                    aVar.HCZ.setVisibility(4);
                }
                if (ao.isDarkMode()) {
                    aVar.HCP.setBackgroundResource(R.drawable.cqz);
                    aVar.HCQ.setImageResource(R.raw.honey_pay_input_logo_dm);
                }
                view.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet.bind.ui.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(214048);
                        int[] iArr = new int[2];
                        aVar.HCN.getLocationInWindow(iArr);
                        int i2 = iArr[0];
                        aVar.HCY.getLocationInWindow(iArr);
                        aVar.HCN.setMaxWidth((iArr[0] - i2) - com.tencent.mm.cb.a.fromDPToPix(view.getContext(), 16));
                        AppMethodBeat.o(214048);
                    }
                }, 50);
                AppMethodBeat.o(69074);
                return view;
            default:
                AppMethodBeat.o(69074);
                return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.a$a  reason: collision with other inner class name */
    class C1903a {
        public TextView HCM = null;
        public TextView HCN = null;
        public TextView HCO = null;
        public ViewGroup HCP = null;
        public ImageView HCQ = null;
        public ImageView HCR = null;
        public TextView HCS = null;
        public TextView HCT = null;
        public TextView HCU = null;
        public ImageView HCV = null;
        public ImageView HCW = null;
        public ImageView HCX = null;
        public WalletTextView HCY = null;
        public TextView HCZ = null;

        C1903a() {
        }
    }
}
