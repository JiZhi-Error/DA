package com.tencent.mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bh;
import java.util.ArrayList;

public final class j {
    private final String TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    private Context mAppContext = MMApplicationContext.getContext();
    public Context owO;
    private EmotionSummary qYl;
    public com.tencent.mm.plugin.emoji.a.a.a rbD;
    public boolean rbE = false;
    public Fragment rbF;
    public int rbG;
    public long rbH = 0;
    public String rbI = "";
    public b rbJ;
    private String rbK;
    private c rbL = new c(2003);
    public String rbM;
    public as rbN;
    public boolean rbO = false;

    public interface a {
        void a(com.tencent.mm.plugin.emoji.a.a aVar);
    }

    public interface b {
        void cGa();

        void d(String str, String str2, String str3, String str4, String str5);
    }

    public j() {
        AppMethodBeat.i(108633);
        AppMethodBeat.o(108633);
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        Integer valueOf;
        String string;
        int i2;
        int i3;
        boolean z;
        AppMethodBeat.i(108634);
        if (aVar == null || aVar.qWK == null || this.rbD == null || this.rbD.qXZ == null) {
            AppMethodBeat.o(108634);
            return;
        }
        EmotionSummary emotionSummary = aVar.qWK.qYl;
        this.qYl = emotionSummary;
        if (emotionSummary == null) {
            AppMethodBeat.o(108634);
            return;
        }
        String str = emotionSummary.ProductID;
        String str2 = emotionSummary.PackName;
        String str3 = emotionSummary.PriceNum;
        String str4 = emotionSummary.PriceType;
        int cFc = aVar.cFc();
        if (aVar.qWK == null) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(aVar.qWK.qYn);
        }
        valueOf.intValue();
        com.tencent.mm.plugin.emoji.a.a.c cVar = this.rbD.qXZ;
        boolean z2 = cVar.qYi;
        boolean z3 = aVar.qWK.qYp;
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = TextUtils.isEmpty(str3) ? "" : str3;
        objArr[2] = Integer.valueOf(cFc);
        Log.i("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", objArr);
        this.rbK = str;
        switch (cFc) {
            case -1:
                if (e.a(emotionSummary)) {
                    i2 = 3;
                } else if (e.b(emotionSummary) || (!z2 && TextUtils.isEmpty(emotionSummary.PackPrice))) {
                    i2 = 3;
                } else if (z2) {
                    bh ame = cVar.ame(str);
                    if (TextUtils.isEmpty(ame.OpB)) {
                        i2 = ame.Opx;
                    } else {
                        i2 = 4;
                    }
                } else {
                    i2 = 4;
                }
                this.rbD.dc(str, i2);
                AppMethodBeat.o(108634);
                return;
            case 0:
                if (this.rbD != null) {
                    this.rbD.dc(str, 3);
                }
                AppMethodBeat.o(108634);
                return;
            case 1:
            case 2:
            case 6:
            case 8:
            default:
                Log.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
                break;
            case 3:
            case 5:
                if (com.tencent.mm.plugin.emoji.h.a.g(emotionSummary)) {
                    com.tencent.mm.plugin.emoji.f.a.cGm();
                    com.tencent.mm.plugin.emoji.f.a.cGn();
                    AppMethodBeat.o(108634);
                    return;
                }
                d(str, null, str2, emotionSummary.IconUrl, emotionSummary.PanelUrl);
                if (this.rbD != null) {
                    this.rbD.dd(str, 0);
                }
                Log.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", str);
                h.INSTANCE.a(12066, 0, Integer.valueOf(this.rbG), "", str, Long.valueOf(this.rbH), this.rbI);
                if (this.rbN != null) {
                    this.rbN.eqm = 2;
                    this.rbN.ix(emotionSummary.ProductID);
                    this.rbN.iy(this.rbO ? emotionSummary.ExptDesc : emotionSummary.Introduce);
                    this.rbN.iz(String.valueOf(aVar.mPosition + 1));
                    this.rbN.bfK();
                    AppMethodBeat.o(108634);
                    return;
                }
                break;
            case 4:
            case 12:
                if (!this.rbE) {
                    Intent intent = new Intent();
                    intent.putExtra("key_product_id", str);
                    Log.i("MicroMsg.emoji.PayOrDownloadComponent", "onProductClick: price %s, currency %s", str3, str4);
                    if (z2) {
                        intent.putExtra("key_currency_type", str4);
                        intent.putExtra("key_price", str4 + str3);
                    } else {
                        intent.putExtra("key_currency_type", str4);
                        intent.putExtra("key_price", str3);
                    }
                    com.tencent.mm.br.c.b(this.owO, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                    this.rbE = true;
                    h.INSTANCE.a(12066, 2, Integer.valueOf(this.rbG), "", str, Long.valueOf(this.rbH), this.rbI);
                    AppMethodBeat.o(108634);
                    return;
                }
                break;
            case 7:
                if (z3) {
                    if (this.rbF != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        c cVar2 = this.rbL;
                        Fragment fragment = this.rbF;
                        Log.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                        Intent intent2 = new Intent();
                        intent2.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
                        intent2.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
                        com.tencent.mm.br.c.a(fragment, ".ui.transmit.SelectConversationUI", intent2, cVar2.nTL);
                        fragment.getActivity().overridePendingTransition(R.anim.dq, R.anim.bs);
                    } else {
                        this.rbL.N((Activity) this.owO);
                    }
                    this.rbL.rnF = str;
                    h.INSTANCE.a(12069, 1, str);
                    AppMethodBeat.o(108634);
                    return;
                } else if (aVar.qWK.qYr) {
                    String str5 = aVar.qWK.qYl.ProductID;
                    String str6 = aVar.qWK.qYl.PackName;
                    String str7 = this.rbM;
                    if (this.owO != null) {
                        if (this.rbG == 9) {
                            i3 = 3;
                        } else {
                            i3 = 4;
                        }
                        Intent intent3 = new Intent();
                        intent3.setClass(this.owO, EmojiStoreV2RewardUI.class);
                        intent3.putExtra("extra_id", str5);
                        intent3.putExtra("extra_name", str6);
                        intent3.putExtra("name", str7);
                        intent3.putExtra("scene", this.rbG);
                        intent3.putExtra("pageType", i3);
                        intent3.putExtra("searchID", this.rbH);
                        Context context = this.owO;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        h.INSTANCE.a(12738, str5, Integer.valueOf(i3), Integer.valueOf(this.rbG), 0);
                        AppMethodBeat.o(108634);
                        return;
                    }
                    Log.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
                    AppMethodBeat.o(108634);
                    return;
                }
                break;
            case 9:
                g.aAg().hqi.a(new r(str, 2), 0);
                AppMethodBeat.o(108634);
                return;
            case 10:
                bh ame2 = cVar.ame(str);
                if (ame2 != null) {
                    switch (ame2.Opy) {
                        case 10233:
                            string = getString(R.string.bsp);
                            break;
                        case 10234:
                            string = getString(R.string.bsg);
                            break;
                        case 10235:
                            string = getString(R.string.bwk);
                            break;
                        default:
                            string = getString(R.string.bwp);
                            break;
                    }
                    com.tencent.mm.ui.base.h.c(this.owO, string, null, true);
                }
                AppMethodBeat.o(108634);
                return;
            case 11:
                Log.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
                AppMethodBeat.o(108634);
                return;
        }
        AppMethodBeat.o(108634);
    }

    private void d(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(240148);
        if (this.rbJ != null) {
            this.rbJ.d(str, str2, str3, str4, str5);
        }
        AppMethodBeat.o(240148);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(108636);
        Log.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + i2 + "  resultCode:" + i3);
        String str = "";
        int i4 = 0;
        if (intent != null) {
            i4 = intent.getIntExtra("key_err_code", 0);
            Log.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:".concat(String.valueOf(i4)));
            str = intent.getStringExtra("key_err_msg");
            Log.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:".concat(String.valueOf(str)));
        }
        this.rbE = false;
        if (i3 != -1) {
            if (i2 == 2001) {
                if (z.aUn()) {
                    h.INSTANCE.idkeyStat(166, 6, 1, false);
                    AppMethodBeat.o(108636);
                    return;
                }
                h.INSTANCE.idkeyStat(166, 2, 1, false);
            }
            AppMethodBeat.o(108636);
            return;
        }
        switch (i2) {
            case 2001:
                if (this.rbD == null || this.rbD.qXZ == null) {
                    AppMethodBeat.o(108636);
                    return;
                } else if (intent != null && i4 == 0) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                    ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                    boolean z = false;
                    int size = stringArrayListExtra.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        String str2 = stringArrayListExtra.get(i5);
                        String str3 = stringArrayListExtra2.get(i5);
                        bh ame = this.rbD.qXZ.ame(str2);
                        if (this.rbK.equals(str2)) {
                            String str4 = null;
                            if (this.qYl != null) {
                                str4 = this.qYl.PanelUrl;
                            }
                            d(str2, str3, ame.rjt, null, str4);
                            this.rbD.dd(this.rbK, 0);
                            com.tencent.mm.ui.base.h.cD(this.owO, str);
                            Log.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", str2);
                            if (stringArrayListExtra.size() > 1) {
                                Log.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
                                if (this.rbJ != null) {
                                    this.rbJ.cGa();
                                }
                            }
                            z = true;
                        } else {
                            this.rbD.dc(this.rbK, 5);
                        }
                    }
                    if (!z) {
                        amQ(str);
                    }
                    if (z.aUn()) {
                        h.INSTANCE.idkeyStat(166, 4, 1, false);
                        AppMethodBeat.o(108636);
                        return;
                    }
                    h.INSTANCE.idkeyStat(166, 0, 1, false);
                    AppMethodBeat.o(108636);
                    return;
                } else if (intent != null && i4 == 100000002) {
                    bh ame2 = this.rbD.qXZ.ame(this.rbK);
                    String str5 = null;
                    if (this.qYl != null) {
                        str5 = this.qYl.PanelUrl;
                    }
                    d(this.rbK, null, ame2.rjt, null, str5);
                    this.rbD.dd(this.rbK, 0);
                    Log.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", this.rbK);
                    amQ(str);
                    if (z.aUn()) {
                        h.INSTANCE.idkeyStat(166, 7, 1, false);
                        AppMethodBeat.o(108636);
                        return;
                    }
                    h.INSTANCE.idkeyStat(166, 3, 1, false);
                    AppMethodBeat.o(108636);
                    return;
                } else if (intent == null || i4 != 1) {
                    if (!(this.rbK == null || this.rbD == null || this.rbD.qXZ == null)) {
                        this.rbD.qXZ.amc(this.rbK);
                        com.tencent.mm.plugin.emoji.a.a ama = this.rbD.ama(this.rbK);
                        if (ama != null) {
                            ama.cFh();
                        }
                    }
                    amQ(str);
                    if (z.aUn()) {
                        h.INSTANCE.idkeyStat(166, 5, 1, false);
                    } else {
                        h.INSTANCE.idkeyStat(166, 1, 1, false);
                    }
                    Log.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", str);
                    AppMethodBeat.o(108636);
                    return;
                } else {
                    if (z.aUn()) {
                        h.INSTANCE.idkeyStat(166, 6, 1, false);
                    } else {
                        h.INSTANCE.idkeyStat(166, 2, 1, false);
                    }
                    Log.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
                    AppMethodBeat.o(108636);
                    return;
                }
            case 2002:
            default:
                Log.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
                AppMethodBeat.o(108636);
                return;
            case 2003:
                String str6 = this.rbL.rnF;
                if (Util.isNullOrNil(str6)) {
                    AppMethodBeat.o(108636);
                    return;
                }
                c.a(intent, str6, (Activity) this.owO);
                h.INSTANCE.a(12069, 3, str6);
                AppMethodBeat.o(108636);
                return;
        }
    }

    private void amQ(String str) {
        AppMethodBeat.i(108637);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.bt6);
        }
        com.tencent.mm.ui.base.h.d(this.owO, str, "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.model.j.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(108637);
    }

    private String getString(int i2) {
        AppMethodBeat.i(108638);
        String string = this.mAppContext.getString(i2);
        AppMethodBeat.o(108638);
        return string;
    }
}
