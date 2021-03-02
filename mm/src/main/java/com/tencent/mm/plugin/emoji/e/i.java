package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.p;
import java.util.HashMap;

public final class i {
    public int cSs = 79;
    public int raA = 19;
    public p raB;
    public HashMap<String, p> raC = new HashMap<>();
    public boolean ray = true;
    public long raz = 863913600000L;

    public i() {
        AppMethodBeat.i(108522);
        AppMethodBeat.o(108522);
    }

    public final void cFU() {
        AppMethodBeat.i(108523);
        if (this.raB != null) {
            this.raB.field_continuCount = 0;
            this.raC.put(this.raB.field_prodcutID, this.raB);
            k.getEmojiStorageMgr().OpU.a(this.raB);
            this.raB = null;
        }
        AppMethodBeat.o(108523);
    }

    public final boolean amF(String str) {
        p pVar;
        AppMethodBeat.i(108524);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
            AppMethodBeat.o(108524);
            return false;
        } else if (this.ray || z.aUj()) {
            if (this.raC == null || !this.raC.containsKey(str)) {
                pVar = new p();
                pVar.field_prodcutID = str;
            } else {
                pVar = this.raC.get(str);
            }
            if (System.currentTimeMillis() - pVar.field_showTipsTime < this.raz) {
                Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
                cFU();
                AppMethodBeat.o(108524);
                return false;
            }
            if (pVar == null || System.currentTimeMillis() - pVar.field_setFlagTime <= Util.MILLSECONDS_OF_DAY) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(this.raB == null ? 0 : this.raB.field_continuCount);
                objArr[1] = Integer.valueOf(this.raB == null ? 0 : this.raB.field_totalCount);
                Log.d("MicroMsg.emoji.EmojiRewardTipMgr", "no need to get reward today. continue count:%d total count:%d", objArr);
            } else if (this.raB != null && str.equalsIgnoreCase(this.raB.field_prodcutID) && this.raB.field_continuCount >= this.raA - 1 && this.raB.field_continuCount <= (this.raA + 5) - 1) {
                g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.p(str, com.tencent.mm.plugin.emoji.f.p.rdf), 0);
            } else if (pVar.field_totalCount >= this.cSs - 1 && pVar.field_totalCount <= (this.cSs + 5) - 1) {
                g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.p(str, com.tencent.mm.plugin.emoji.f.p.rdf), 0);
            }
            if (this.raB == null || !str.equalsIgnoreCase(this.raB.field_prodcutID) || this.raB.field_continuCount < this.raA) {
                if (pVar == null || pVar.field_totalCount < this.cSs) {
                    a(pVar, false);
                    AppMethodBeat.o(108524);
                    return false;
                } else if ((pVar.field_flag & com.tencent.mm.plugin.emoji.f.p.rdg) != com.tencent.mm.plugin.emoji.f.p.rdg || (pVar.field_flag & com.tencent.mm.plugin.emoji.f.p.rdh) == com.tencent.mm.plugin.emoji.f.p.rdh) {
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = Boolean.FALSE;
                    objArr2[1] = str;
                    objArr2[2] = Integer.valueOf(this.raB == null ? 0 : this.raB.field_totalCount);
                    objArr2[3] = Integer.valueOf(this.raB == null ? 0 : this.raB.field_flag);
                    Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d flag:%d", objArr2);
                    a(pVar, false);
                    AppMethodBeat.o(108524);
                    return false;
                } else {
                    Object[] objArr3 = new Object[3];
                    objArr3[0] = Boolean.TRUE;
                    objArr3[1] = str;
                    objArr3[2] = Integer.valueOf(this.raB == null ? 0 : this.raB.field_totalCount);
                    Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  total count :%d", objArr3);
                    a(pVar, true);
                    h hVar = h.INSTANCE;
                    Object[] objArr4 = new Object[2];
                    objArr4[0] = 0;
                    objArr4[1] = this.raB == null ? "" : this.raB.field_prodcutID;
                    hVar.a(12953, objArr4);
                    AppMethodBeat.o(108524);
                    return true;
                }
            } else if ((this.raB.field_flag & com.tencent.mm.plugin.emoji.f.p.rdg) != com.tencent.mm.plugin.emoji.f.p.rdg || (this.raB.field_flag & com.tencent.mm.plugin.emoji.f.p.rdh) == com.tencent.mm.plugin.emoji.f.p.rdh) {
                Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d flag:%d", Boolean.FALSE, str, Integer.valueOf(this.raB.field_continuCount), Integer.valueOf(this.raB.field_flag));
                a(pVar, false);
                AppMethodBeat.o(108524);
                return false;
            } else {
                Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", Boolean.TRUE, str, Integer.valueOf(this.raB.field_continuCount));
                a(pVar, true);
                h.INSTANCE.a(12953, 0, this.raB.field_prodcutID);
                AppMethodBeat.o(108524);
                return true;
            }
        } else {
            Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", Boolean.valueOf(this.ray), Boolean.valueOf(z.aUj()));
            AppMethodBeat.o(108524);
            return false;
        }
    }

    private void a(p pVar, boolean z) {
        AppMethodBeat.i(108525);
        if (pVar == null) {
            Log.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
            AppMethodBeat.o(108525);
            return;
        }
        boolean z2 = this.raB == null || this.raB.field_prodcutID.equalsIgnoreCase(pVar.field_prodcutID);
        if (!z2) {
            this.raB.field_continuCount = 0;
            this.raC.put(this.raB.field_prodcutID, this.raB);
            k.getEmojiStorageMgr().OpU.a(this.raB);
        }
        this.raB = pVar;
        if (z) {
            this.raB.field_modifyTime = 0;
            this.raB.field_showTipsTime = System.currentTimeMillis();
            this.raB.field_totalCount = 0;
            this.raB.field_continuCount = 0;
        } else {
            if (z2) {
                this.raB.field_continuCount++;
            } else {
                this.raB.field_continuCount = 1;
            }
            this.raB.field_totalCount++;
            this.raB.field_modifyTime = System.currentTimeMillis();
        }
        this.raC.put(this.raB.field_prodcutID, this.raB);
        k.getEmojiStorageMgr().OpU.a(this.raB);
        AppMethodBeat.o(108525);
    }

    public final void dg(String str, int i2) {
        AppMethodBeat.i(108526);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
            AppMethodBeat.o(108526);
        } else if (this.raC == null || !this.raC.containsKey(str)) {
            Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", str);
            AppMethodBeat.o(108526);
        } else {
            this.raC.get(str).field_flag = i2;
            this.raC.get(str).field_setFlagTime = System.currentTimeMillis();
            AppMethodBeat.o(108526);
        }
    }
}
