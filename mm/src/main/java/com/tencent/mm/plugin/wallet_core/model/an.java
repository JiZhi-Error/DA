package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class an {
    private ArrayList<Bankcard> HDi = new ArrayList<>();
    private ArrayList<Bankcard> HDj = new ArrayList<>();
    int Hvt = 0;
    int Hvu = 0;
    public Bankcard Hwc = null;
    private ArrayList<Bankcard> IbH = new ArrayList<>();
    private ArrayList<Bankcard> IbI = new ArrayList<>();
    private ArrayList<Bankcard> IbJ = new ArrayList<>();
    public am IbK = null;
    public Bankcard IbL = null;
    public al IbM = null;
    public n IbN = null;
    public b IbO = null;
    private List<c> IbP = new LinkedList();
    public Bankcard IbQ = null;
    public cul IbR;
    public long IbS = Util.nowSecond();
    long IbT = 0;
    public long IbU = -1;
    private String IbV = "";
    public int IbW = 10000;
    public String IbX = "";
    public String IbY = "";
    public int mRetryCount = 0;

    public an() {
        AppMethodBeat.i(70494);
        fRy();
        AppMethodBeat.o(70494);
    }

    public final boolean fRp() {
        AppMethodBeat.i(70495);
        if (this.IbK == null || (this.IbK != null && this.IbK.fRn())) {
            AppMethodBeat.o(70495);
            return true;
        }
        AppMethodBeat.o(70495);
        return false;
    }

    public final boolean fRk() {
        AppMethodBeat.i(70496);
        if (this.IbK == null || !this.IbK.fRk()) {
            AppMethodBeat.o(70496);
            return false;
        }
        AppMethodBeat.o(70496);
        return true;
    }

    public final boolean fRm() {
        AppMethodBeat.i(70497);
        if (this.IbK == null || !this.IbK.fRm()) {
            AppMethodBeat.o(70497);
            return false;
        }
        AppMethodBeat.o(70497);
        return true;
    }

    public final boolean fRl() {
        AppMethodBeat.i(70498);
        if (this.IbK == null || !this.IbK.fRl()) {
            AppMethodBeat.o(70498);
            return false;
        }
        AppMethodBeat.o(70498);
        return true;
    }

    public final boolean fRo() {
        AppMethodBeat.i(70499);
        if (this.IbK == null || !this.IbK.fRo()) {
            AppMethodBeat.o(70499);
            return false;
        }
        AppMethodBeat.o(70499);
        return true;
    }

    public final int fRq() {
        if (this.IbK != null) {
            return this.IbK.field_soter_pay_open_type;
        }
        return 0;
    }

    public final Bankcard aVm(String str) {
        AppMethodBeat.i(214199);
        if (this.HDi != null && !this.HDi.isEmpty()) {
            Iterator<Bankcard> it = this.HDi.iterator();
            while (it.hasNext()) {
                Bankcard next = it.next();
                if (next.field_bindSerial.equals(str)) {
                    AppMethodBeat.o(214199);
                    return next;
                }
            }
        }
        AppMethodBeat.o(214199);
        return null;
    }

    public final Bankcard l(String str, boolean z, boolean z2) {
        AppMethodBeat.i(214200);
        if (z && this.Hwc != null && this.Hwc.field_bindSerial.equals(str)) {
            Bankcard bankcard = this.Hwc;
            AppMethodBeat.o(214200);
            return bankcard;
        } else if (!z2 || this.IbQ == null || !this.IbQ.field_bindSerial.equals(str)) {
            Log.i("MicroMsg.WalletUserInfoManger", "need get bankcard is ：%s ", str);
            if (this.IbH != null && !this.IbH.isEmpty()) {
                Iterator<Bankcard> it = this.IbH.iterator();
                while (it.hasNext()) {
                    Bankcard next = it.next();
                    Log.i("MicroMsg.WalletUserInfoManger", "compared offline offlinebankcards:%s", next.field_bindSerial);
                    if (next.field_bindSerial.equals(str)) {
                        AppMethodBeat.o(214200);
                        return next;
                    }
                }
            }
            if (this.HDi != null && !this.HDi.isEmpty()) {
                Iterator<Bankcard> it2 = this.HDi.iterator();
                while (it2.hasNext()) {
                    Bankcard next2 = it2.next();
                    Log.i("MicroMsg.WalletUserInfoManger", "compared bankcards:%s", next2.field_bindSerial);
                    if (next2.field_bindSerial.equals(str)) {
                        AppMethodBeat.o(214200);
                        return next2;
                    }
                }
            }
            AppMethodBeat.o(214200);
            return null;
        } else {
            Bankcard bankcard2 = this.IbQ;
            AppMethodBeat.o(214200);
            return bankcard2;
        }
    }

    public final String fRr() {
        if (this.IbK != null) {
            return this.IbK.field_ftf_pay_url;
        }
        return null;
    }

    public final al fRs() {
        AppMethodBeat.i(70501);
        if (this.IbM == null) {
            al alVar = new al();
            AppMethodBeat.o(70501);
            return alVar;
        }
        al alVar2 = this.IbM;
        AppMethodBeat.o(70501);
        return alVar2;
    }

    public final boolean fRt() {
        return this.IbK != null && this.IbK.field_isDomesticUser;
    }

    public final String getTrueName() {
        if (this.IbK != null) {
            return this.IbK.field_true_name;
        }
        return null;
    }

    public final int fRu() {
        if (this.IbK != null) {
            return this.IbK.field_cre_type;
        }
        return 1;
    }

    public final String fRv() {
        AppMethodBeat.i(70502);
        g.aAi();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_LQT_ENTRY_WORDING_STRING_SYNC, (Object) null);
        if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(70502);
            return str;
        } else if (this.IbK != null) {
            String str2 = this.IbK.field_lct_wording;
            AppMethodBeat.o(70502);
            return str2;
        } else {
            AppMethodBeat.o(70502);
            return null;
        }
    }

    public final String fRw() {
        if (this.IbK != null) {
            return this.IbK.field_lct_url;
        }
        return null;
    }

    public final String fRx() {
        if (this.IbK != null) {
            return this.IbK.field_forget_passwd_url;
        }
        return "";
    }

    public final void fRy() {
        AppMethodBeat.i(70503);
        if (!g.aAf().azp()) {
            Log.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
            AppMethodBeat.o(70503);
            return;
        }
        this.IbK = t.fQD().fRN();
        if (this.IbK != null) {
            this.IbM = new al(this.IbK.field_switchConfig, this.IbK.field_wallet_entrance_balance_switch_state);
        } else {
            this.IbM = new al();
        }
        if (!Util.isNullOrNil(this.IbK.field_bank_priority)) {
            try {
                this.IbP = ai.bQ(new JSONObject(this.IbK.field_bank_priority));
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WalletUserInfoManger", e2, "", new Object[0]);
            }
        }
        this.Hwc = t.fQF().fSo();
        this.IbQ = t.fQF().fSp();
        f.a("wallet_balance", new f.b() {
            /* class com.tencent.mm.plugin.wallet_core.model.an.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.ui.f.b
            public final void dy(Object obj) {
                AppMethodBeat.i(70493);
                if (obj == null || !(obj instanceof Double)) {
                    Log.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
                    if (an.this.Hwc != null) {
                        an.this.Hwc.HVC = -1.0d;
                    }
                } else {
                    if (((Double) obj).doubleValue() < 0.0d) {
                        Log.v("MicroMsg.WalletUserInfoManger", "val is zero %s", Util.getStack().toString());
                    }
                    if (an.this.Hwc != null) {
                        an.this.Hwc.HVC = ((Double) obj).doubleValue();
                        AppMethodBeat.o(70493);
                        return;
                    }
                }
                AppMethodBeat.o(70493);
            }
        });
        this.HDi = t.fQF().fRE();
        this.IbH = d.aeY(8);
        this.IbJ = d.aeY(12);
        this.HDj = t.fQF().fSq();
        this.IbL = t.fQF().fSr();
        this.IbN = t.fQK().fSm();
        Log.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
        fRW();
        this.IbR = ai.fQV();
        AppMethodBeat.o(70503);
    }

    public final boolean fRz() {
        AppMethodBeat.i(70504);
        if (ac.jPD) {
            AppMethodBeat.o(70504);
            return true;
        }
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_LQT_OPEN_FLAG_INT_SYNC, (Object) -1)).intValue();
        if (intValue != -1) {
            if (intValue == 1) {
                AppMethodBeat.o(70504);
                return true;
            }
            AppMethodBeat.o(70504);
            return false;
        } else if (this.IbK == null) {
            AppMethodBeat.o(70504);
            return false;
        } else if (this.IbK.field_lqt_state == 1) {
            AppMethodBeat.o(70504);
            return true;
        } else {
            AppMethodBeat.o(70504);
            return false;
        }
    }

    public final int fRA() {
        if (this.IbK != null) {
            return this.IbK.field_is_show_lqb;
        }
        return 0;
    }

    public final boolean fRB() {
        if (this.IbK != null) {
            return this.IbK.field_is_open_lqb == 1;
        }
        return false;
    }

    public final String fRC() {
        if (this.IbK != null) {
            return this.IbK.field_lqb_open_url;
        }
        return null;
    }

    public final boolean fRD() {
        if (this.IbK != null) {
            return this.IbK.field_paymenu_use_new == 1;
        }
        return false;
    }

    public final void and() {
        AppMethodBeat.i(70505);
        if (this.IbK != null) {
            this.IbK.field_is_reg = -1;
            this.IbK = null;
        }
        if (this.IbM != null) {
            this.IbM = null;
        }
        if (this.Hwc != null) {
            this.Hwc = null;
        }
        if (this.HDi != null) {
            this.HDi.clear();
            this.HDi = null;
        }
        if (this.HDj != null) {
            this.HDj.clear();
            this.HDj = null;
        }
        if (this.IbR != null) {
            this.IbR = null;
        }
        this.IbT = 0;
        f.a(new f.c("wallet_balance_version", -1), new f.c("wallet_balance_last_update_time", -1), new f.c("wallet_balance", -1));
        this.IbS = Util.nowSecond();
        AppMethodBeat.o(70505);
    }

    public final ArrayList<Bankcard> fRE() {
        AppMethodBeat.i(70506);
        if (this.HDi == null || this.HDi.size() <= 0) {
            this.HDi = t.fQF().fRE();
        }
        if (this.HDi == null || this.HDi.size() <= 0) {
            AppMethodBeat.o(70506);
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList<>();
        Iterator<Bankcard> it = this.HDi.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        AppMethodBeat.o(70506);
        return arrayList;
    }

    public final List<c> fRF() {
        AppMethodBeat.i(70507);
        if (this.IbP == null || this.IbP.size() <= 0) {
            AppMethodBeat.o(70507);
            return null;
        }
        List<c> list = this.IbP;
        AppMethodBeat.o(70507);
        return list;
    }

    public final ArrayList<Bankcard> fRG() {
        AppMethodBeat.i(70508);
        if (this.HDi == null || this.HDi.size() <= 0) {
            AppMethodBeat.o(70508);
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList<>();
        Iterator<Bankcard> it = this.HDi.iterator();
        while (it.hasNext()) {
            Bankcard next = it.next();
            if (!next.fQd() && !next.fQf()) {
                arrayList.add(next);
            }
        }
        AppMethodBeat.o(70508);
        return arrayList;
    }

    public final ArrayList<Bankcard> yj(boolean z) {
        AppMethodBeat.i(70509);
        ArrayList<Bankcard> arrayList = new ArrayList<>();
        if (z) {
            if (this.Hwc != null && !fRm()) {
                arrayList.add(this.Hwc);
            }
            if (this.IbQ != null && !fRm()) {
                arrayList.add(this.IbQ);
            }
        }
        if (this.HDi != null && this.HDi.size() > 0) {
            Iterator<Bankcard> it = this.HDi.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        AppMethodBeat.o(70509);
        return arrayList;
    }

    public final ArrayList<Bankcard> fRH() {
        AppMethodBeat.i(214201);
        if (this.IbH == null) {
            AppMethodBeat.o(214201);
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList<>();
        if (this.Hwc != null && !fRm()) {
            arrayList.add(this.Hwc);
        }
        if (this.IbQ != null && !fRm()) {
            arrayList.add(this.IbQ);
        }
        if (this.IbH.size() > 0) {
            Iterator<Bankcard> it = this.IbH.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        AppMethodBeat.o(214201);
        return arrayList;
    }

    @Deprecated
    public final ArrayList<Bankcard> yk(boolean z) {
        AppMethodBeat.i(258740);
        ArrayList<Bankcard> yj = yj(z);
        AppMethodBeat.o(258740);
        return yj;
    }

    public final ArrayList<Bankcard> fRI() {
        AppMethodBeat.i(70511);
        ArrayList<Bankcard> arrayList = new ArrayList<>();
        if (this.Hwc != null && !fRm()) {
            arrayList.add(this.Hwc);
        }
        if (this.IbQ != null && !fRm()) {
            arrayList.add(this.IbQ);
        }
        if (this.IbH != null && this.IbH.size() > 0) {
            Iterator<Bankcard> it = this.IbH.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        } else if (this.HDi != null && this.HDi.size() > 0) {
            Iterator<Bankcard> it2 = this.HDi.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
        }
        AppMethodBeat.o(70511);
        return arrayList;
    }

    public final ArrayList<Bankcard> fRJ() {
        AppMethodBeat.i(70512);
        ArrayList<Bankcard> arrayList = new ArrayList<>();
        if (this.Hwc != null && !fRm()) {
            arrayList.add(this.Hwc);
        }
        if (!(this.IbI == null || this.HDi == null || this.IbI.size() <= 0)) {
            Iterator<Bankcard> it = this.IbI.iterator();
            while (it.hasNext()) {
                Bankcard next = it.next();
                if (!next.fQf()) {
                    arrayList.add(next);
                }
            }
        }
        AppMethodBeat.o(70512);
        return arrayList;
    }

    public final void g(ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2) {
        AppMethodBeat.i(70513);
        if (arrayList == null || arrayList2 == null) {
            Log.e("MicroMsg.WalletUserInfoManger", "error list,bankcardsClone == null || virtualBankcardsClone == null");
            AppMethodBeat.o(70513);
            return;
        }
        if (this.IbJ == null && this.HDi != null) {
            Log.e("MicroMsg.WalletUserInfoManger", "listManageUIbankcards == null && bankcards != null");
            this.IbJ = this.HDi;
        }
        if (this.IbJ == null) {
            Log.e("MicroMsg.WalletUserInfoManger", "error list, listManageUIbankcards == null");
            AppMethodBeat.o(70513);
            return;
        }
        arrayList.clear();
        arrayList2.clear();
        if (this.IbJ != null) {
            Iterator<Bankcard> it = this.IbJ.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        if (this.HDj != null) {
            Iterator<Bankcard> it2 = this.HDj.iterator();
            while (it2.hasNext()) {
                Bankcard next = it2.next();
                if (next.field_wxcreditState == 0) {
                    arrayList2.add(next);
                } else {
                    arrayList.add(next);
                }
            }
        }
        AppMethodBeat.o(70513);
    }

    public final boolean fRK() {
        AppMethodBeat.i(70514);
        if (fRL()) {
            AppMethodBeat.o(70514);
            return false;
        } else if (this.HDi == null || this.HDi.size() <= 0) {
            AppMethodBeat.o(70514);
            return true;
        } else {
            AppMethodBeat.o(70514);
            return false;
        }
    }

    private boolean fRL() {
        AppMethodBeat.i(70515);
        if ((this.IbM == null || !this.IbM.fQY()) && (this.HDj == null || this.HDj.size() <= 0)) {
            AppMethodBeat.o(70515);
            return false;
        }
        AppMethodBeat.o(70515);
        return true;
    }

    public final boolean fRM() {
        AppMethodBeat.i(70516);
        ArrayList<Bankcard> arrayList = new ArrayList<>();
        ArrayList<Bankcard> arrayList2 = new ArrayList<>();
        g(arrayList, arrayList2);
        if (hY(arrayList2)) {
            AppMethodBeat.o(70516);
            return true;
        }
        AppMethodBeat.o(70516);
        return false;
    }

    private static boolean hY(List<Bankcard> list) {
        AppMethodBeat.i(70517);
        if (list.size() == 0) {
            AppMethodBeat.o(70517);
            return false;
        }
        g.aAi();
        String str = (String) g.aAh().azQ().get(196659, (Object) null);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(70517);
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            AppMethodBeat.o(70517);
            return true;
        }
        int i2 = 0;
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2)) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    }
                    Bankcard bankcard = list.get(i3);
                    if (bankcard != null && str2.equals(bankcard.field_bankcardType)) {
                        i2++;
                        break;
                    }
                    i3++;
                }
            }
        }
        if (i2 < list.size()) {
            AppMethodBeat.o(70517);
            return true;
        }
        AppMethodBeat.o(70517);
        return false;
    }

    public final boolean aVn(String str) {
        AppMethodBeat.i(70518);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(70518);
            return false;
        }
        if (this.HDi != null) {
            Iterator<Bankcard> it = this.HDi.iterator();
            while (it.hasNext()) {
                Bankcard next = it.next();
                if (str.equals(next.field_bankcardType) && next.fQa()) {
                    AppMethodBeat.o(70518);
                    return false;
                }
            }
        }
        if (this.HDj != null) {
            Iterator<Bankcard> it2 = this.HDj.iterator();
            while (it2.hasNext()) {
                Bankcard next2 = it2.next();
                if (str.equals(next2.field_bankcardType) && next2.field_bankcardState == 0) {
                    AppMethodBeat.o(70518);
                    return false;
                }
            }
        }
        AppMethodBeat.o(70518);
        return true;
    }

    public final void c(cul cul) {
        AppMethodBeat.i(70519);
        this.IbR = cul;
        ai.a(cul);
        AppMethodBeat.o(70519);
    }

    public final void a(am amVar, ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2, Bankcard bankcard, Bankcard bankcard2, n nVar, b bVar, Bankcard bankcard3, int i2, int i3, List<c> list) {
        AppMethodBeat.i(70520);
        Log.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", Integer.valueOf(i3));
        if (i3 == 8) {
            this.IbH = arrayList;
            this.IbP = list;
        }
        if (i3 == 24 || i3 == 25) {
            this.IbI = arrayList;
        }
        if (i3 == 12) {
            this.IbJ = arrayList;
        }
        this.HDi = arrayList;
        this.HDj = arrayList2;
        this.Hwc = bankcard;
        this.IbM = new al(amVar.field_switchConfig, amVar.field_wallet_entrance_balance_switch_state);
        this.IbL = bankcard2;
        this.IbN = nVar;
        this.IbO = bVar;
        this.IbQ = bankcard3;
        Log.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + amVar.field_switchConfig);
        fRW();
        if (i2 < 0) {
            i2 = 600;
        }
        this.IbS = Util.nowSecond() + ((long) i2);
        this.IbT = Util.nowSecond() + 600;
        Log.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", Integer.valueOf(i2), Long.valueOf(this.IbS), Long.valueOf(this.IbT));
        d.aeX(i3);
        if (!(i3 == 24 || i3 == 25 || arrayList == null)) {
            d.E(arrayList, i3);
        }
        if (arrayList2 != null) {
            d.E(arrayList2, i3);
        }
        if (bankcard != null) {
            d.a(bankcard, i3);
        }
        if (bankcard2 != null) {
            d.a(bankcard2, i3);
        }
        if (bankcard3 != null) {
            d.a(bankcard3, i3);
        }
        a(amVar);
        t.fQK().bnU();
        if (nVar != null) {
            t.fQK().insert(nVar);
        }
        AppMethodBeat.o(70520);
    }

    public final void a(am amVar) {
        AppMethodBeat.i(70521);
        this.IbK = amVar;
        t.fQD().bnU();
        t.fQD().b(amVar);
        AppMethodBeat.o(70521);
    }

    public final int fRO() {
        if (this.IbW > 0) {
            return this.IbW;
        }
        return 10000;
    }

    private static String fRP() {
        AppMethodBeat.i(70522);
        g.aAi();
        String str = (String) g.aAh().azQ().get(196612, (Object) null);
        AppMethodBeat.o(70522);
        return str;
    }

    public static void aVo(String str) {
        AppMethodBeat.i(70523);
        if (!Util.isNullOrNil(str)) {
            g.aAi();
            g.aAh().azQ().set(196612, str);
        }
        AppMethodBeat.o(70523);
    }

    @Deprecated
    public final Bankcard a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2) {
        AppMethodBeat.i(70524);
        Bankcard a2 = a(arrayList, str, z, z2, false);
        AppMethodBeat.o(70524);
        return a2;
    }

    public final Bankcard a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(70525);
        Bankcard b2 = b(arrayList, str, z, z2, z3);
        AppMethodBeat.o(70525);
        return b2;
    }

    @Deprecated
    private Bankcard b(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(70526);
        if (arrayList == null) {
            arrayList = this.HDi;
        }
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.WalletUserInfoManger", "bindSerial is null ");
            str = fRP();
        }
        Log.i("MicroMsg.WalletUserInfoManger", "getDefaultRecommendBankcard bindSerial:%s", str);
        if (z && this.Hwc != null) {
            if (fRl()) {
                Bankcard bankcard = this.Hwc;
                AppMethodBeat.o(70526);
                return bankcard;
            } else if (str != null && str.equals(this.Hwc.field_bindSerial)) {
                Bankcard bankcard2 = this.Hwc;
                AppMethodBeat.o(70526);
                return bankcard2;
            } else if (this.IbQ != null && this.IbK != null && this.IbK.field_lqt_state == 1 && str != null && str.equals(this.IbQ.field_bindSerial)) {
                Bankcard bankcard3 = this.IbQ;
                AppMethodBeat.o(70526);
                return bankcard3;
            } else if (!fRm() && (arrayList == null || arrayList.size() == 0)) {
                Bankcard bankcard4 = this.Hwc;
                AppMethodBeat.o(70526);
                return bankcard4;
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            Log.e("MicroMsg.WalletUserInfoManger", "return not found bankcard!");
            AppMethodBeat.o(70526);
            return null;
        } else if (arrayList.size() != 1 || !z2) {
            Log.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
            if (!Util.isNullOrNil(str)) {
                Iterator<Bankcard> it = arrayList.iterator();
                while (it.hasNext()) {
                    Bankcard next = it.next();
                    Log.i("MicroMsg.WalletUserInfoManger", "bankcard serial ：%s，title :%s", next.field_bindSerial, next.field_forbid_title);
                    if (next != null && str.equals(next.field_bindSerial)) {
                        if (!z3 || !next.fQf()) {
                            Log.i("MicroMsg.WalletUserInfoManger", "return bankcard:%s", next.field_bindSerial);
                            AppMethodBeat.o(70526);
                            return next;
                        }
                        Log.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
                        if (!z || this.Hwc == null) {
                            Iterator<Bankcard> it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                Bankcard next2 = it2.next();
                                if (!next2.fQf()) {
                                    Log.i("MicroMsg.WalletUserInfoManger", "return bankcard1:%s", next2.field_bindSerial);
                                    AppMethodBeat.o(70526);
                                    return next2;
                                }
                            }
                            continue;
                        } else {
                            Log.i("MicroMsg.WalletUserInfoManger", "return balance");
                            Bankcard bankcard5 = this.Hwc;
                            AppMethodBeat.o(70526);
                            return bankcard5;
                        }
                    }
                }
            }
            if (z2) {
                Log.i("MicroMsg.WalletUserInfoManger", "return bankcardList.get(0):%s", arrayList.get(0).field_bindSerial);
                Bankcard bankcard6 = arrayList.get(0);
                AppMethodBeat.o(70526);
                return bankcard6;
            }
            AppMethodBeat.o(70526);
            return null;
        } else {
            Log.e("MicroMsg.WalletUserInfoManger", "return only one bankcard：%s", arrayList.get(0).field_bindSerial);
            Bankcard bankcard7 = arrayList.get(0);
            AppMethodBeat.o(70526);
            return bankcard7;
        }
    }

    public final String fRQ() {
        AppMethodBeat.i(70527);
        if (this.HDi == null || this.HDi.size() <= 0) {
            Log.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            AppMethodBeat.o(70527);
            return null;
        }
        Iterator<Bankcard> it = this.HDi.iterator();
        if (it.hasNext()) {
            String str = it.next().field_bindSerial;
            AppMethodBeat.o(70527);
            return str;
        }
        AppMethodBeat.o(70527);
        return null;
    }

    private static void aVp(String str) {
        AppMethodBeat.i(70528);
        if (str != null) {
            g.aAi();
            g.aAh().azQ().set(196633, str);
        }
        AppMethodBeat.o(70528);
    }

    public static String fRR() {
        AppMethodBeat.i(70529);
        g.aAi();
        String str = (String) g.aAh().azQ().get(196633, (Object) null);
        AppMethodBeat.o(70529);
        return str;
    }

    public final boolean fRS() {
        AppMethodBeat.i(70530);
        long secondsToNow = Util.secondsToNow(this.IbU);
        Log.d("MicroMsg.WalletUserInfoManger", "pass time ".concat(String.valueOf(secondsToNow)));
        if (secondsToNow > 300) {
            AppMethodBeat.o(70530);
            return true;
        }
        AppMethodBeat.o(70530);
        return false;
    }

    public final int fRT() {
        if (this.IbK != null) {
            return this.IbK.field_lqt_cell_is_show;
        }
        return 0;
    }

    public final String fRU() {
        if (this.IbK != null) {
            return this.IbK.field_lqt_cell_lqt_title;
        }
        return null;
    }

    public final String fRV() {
        if (this.IbK != null) {
            return this.IbK.field_lqt_cell_lqt_wording;
        }
        return null;
    }

    private void fRW() {
        AppMethodBeat.i(70531);
        Log.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
        if (this.IbK == null) {
            Log.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
        }
        if (this.HDi == null) {
            Log.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
        } else if (this.HDi.size() == 0) {
            Log.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        } else {
            Log.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.HDi.size());
        }
        if (this.HDj == null) {
            Log.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
        } else if (this.HDj.size() == 0) {
            Log.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        } else {
            Log.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.HDj.size());
        }
        if (this.Hwc == null) {
            Log.i("MicroMsg.WalletUserInfoManger", "balance == null");
        } else {
            Log.i("MicroMsg.WalletUserInfoManger", "balance != null");
        }
        if (this.IbL == null) {
            Log.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
        } else {
            Log.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
        }
        if (this.IbN == null) {
            Log.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
            AppMethodBeat.o(70531);
            return;
        }
        Log.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
        AppMethodBeat.o(70531);
    }

    public static void aVq(String str) {
        AppMethodBeat.i(70532);
        Log.i("MicroMsg.WalletUserInfoManger", "setSelectBindSerial %s %s", str, Util.getStack().toString());
        aVp(str);
        AppMethodBeat.o(70532);
    }

    public static Bankcard fRX() {
        AppMethodBeat.i(70533);
        Bankcard a2 = t.fQI().a(null, null, true, true);
        if (a2 == null) {
            Log.e("MicroMsg.WalletUserInfoManger", "defaultBankcards == null");
        }
        AppMethodBeat.o(70533);
        return a2;
    }
}
