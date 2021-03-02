package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.ebi;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.ebo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class m extends MAutoStorage<l> implements f {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(l.info, "snsExtInfo3")};
    private boolean Emo = false;
    private e Emp = null;
    public h iFy;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(l lVar) {
        AppMethodBeat.i(97495);
        boolean a2 = a(lVar);
        AppMethodBeat.o(97495);
        return a2;
    }

    static {
        AppMethodBeat.i(97496);
        AppMethodBeat.o(97496);
    }

    @Override // com.tencent.mm.plugin.sns.b.f
    public final void eZi() {
        AppMethodBeat.i(97472);
        Log.d("MicroMsg.SnsExtStorage", "attachCache");
        this.Emo = true;
        AppMethodBeat.o(97472);
    }

    @Override // com.tencent.mm.plugin.sns.b.f
    public final void eZj() {
        AppMethodBeat.i(97473);
        this.Emo = false;
        this.Emp.fbn();
        Log.d("MicroMsg.SnsExtStorage", "detchCache");
        AppMethodBeat.o(97473);
    }

    public m(h hVar, e eVar) {
        super(hVar, l.info, "snsExtInfo3", null);
        AppMethodBeat.i(203187);
        this.iFy = hVar;
        this.Emp = eVar;
        Log.i("MicroMsg.SnsExtStorage", "createExtStorage " + hVar + "  " + Thread.currentThread().getId());
        AppMethodBeat.o(203187);
    }

    public final boolean b(l lVar) {
        AppMethodBeat.i(97475);
        boolean replace = super.replace(lVar);
        AppMethodBeat.o(97475);
        return replace;
    }

    public final boolean a(l lVar) {
        AppMethodBeat.i(97476);
        if (!this.Emo || this.Emp == null) {
            boolean replace = super.replace(lVar);
            AppMethodBeat.o(97476);
            return replace;
        }
        boolean a2 = this.Emp.a(lVar);
        if (this.Emp != null) {
            this.Emp.fbm();
        }
        AppMethodBeat.o(97476);
        return a2;
    }

    public final void aQo(String str) {
        AppMethodBeat.i(97477);
        l aQr = aQr(str);
        aQr.field_userName = str;
        super.delete(aQr, getPrimaryKey());
        AppMethodBeat.o(97477);
    }

    public final int kJ(String str, String str2) {
        AppMethodBeat.i(203188);
        l aQr = aQr(str);
        aQr.field_md5 = str2;
        super.replace(aQr);
        AppMethodBeat.o(203188);
        return 0;
    }

    public final int o(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(97478);
        l aQr = aQr(str);
        aQr.field_md5 = str2;
        aQr.field_lastFirstPageRequestErrType = i2;
        aQr.field_lastFirstPageRequestErrCode = i3;
        super.replace(aQr);
        AppMethodBeat.o(97478);
        return 0;
    }

    public final int g(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(97479);
        l aQr = aQr(str);
        aQr.field_md5 = str2;
        aQr.field_adsession = bArr;
        super.replace(aQr);
        AppMethodBeat.o(97479);
        return 0;
    }

    public final int p(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(162060);
        l aQr = aQr(str);
        aQr.field_albumMd5 = str2;
        aQr.field_lastFirstPageRequestErrType = i2;
        aQr.field_lastFirstPageRequestErrCode = i3;
        super.replace(aQr);
        AppMethodBeat.o(162060);
        return 0;
    }

    public final boolean kK(String str, String str2) {
        AppMethodBeat.i(97480);
        l aQr = aQr(str);
        aQr.field_newerIds = str2;
        boolean replace = super.replace(aQr);
        AppMethodBeat.o(97480);
        return replace;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.protocal.protobuf.bft aQp(java.lang.String r5) {
        /*
            r4 = this;
            r3 = 97481(0x17cc9, float:1.366E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            com.tencent.mm.protocal.protobuf.bft r1 = new com.tencent.mm.protocal.protobuf.bft
            r1.<init>()
            com.tencent.mm.plugin.sns.storage.l r0 = new com.tencent.mm.plugin.sns.storage.l
            r0.<init>()
            com.tencent.mm.plugin.sns.storage.l r0 = r4.aQr(r5)
            byte[] r2 = r0.field_faultS     // Catch:{ Exception -> 0x0034 }
            boolean r2 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r2)     // Catch:{ Exception -> 0x0034 }
            if (r2 != 0) goto L_0x003e
            com.tencent.mm.protocal.protobuf.bft r2 = new com.tencent.mm.protocal.protobuf.bft     // Catch:{ Exception -> 0x0034 }
            r2.<init>()     // Catch:{ Exception -> 0x0034 }
            byte[] r0 = r0.field_faultS     // Catch:{ Exception -> 0x0034 }
            com.tencent.mm.bw.a r0 = r2.parseFrom(r0)     // Catch:{ Exception -> 0x0034 }
            com.tencent.mm.protocal.protobuf.bft r0 = (com.tencent.mm.protocal.protobuf.bft) r0     // Catch:{ Exception -> 0x0034 }
        L_0x0029:
            if (r0 != 0) goto L_0x0030
            com.tencent.mm.protocal.protobuf.bft r0 = new com.tencent.mm.protocal.protobuf.bft
            r0.<init>()
        L_0x0030:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r0
        L_0x0034:
            r0 = move-exception
            java.lang.String r0 = "MicroMsg.SnsExtStorage"
            java.lang.String r2 = "parser field_faultS error"
            com.tencent.mm.sdk.platformtools.Log.e(r0, r2)
        L_0x003e:
            r0 = r1
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.m.aQp(java.lang.String):com.tencent.mm.protocal.protobuf.bft");
    }

    public final void aQq(String str) {
        AppMethodBeat.i(97482);
        new l();
        l aQr = aQr(str);
        aQr.field_userName = str;
        aQr.field_local_flag &= -2;
        c(aQr);
        AppMethodBeat.o(97482);
    }

    public final l aQr(String str) {
        AppMethodBeat.i(97483);
        l lVar = new l();
        if (this.Emp != null && this.Emo) {
            lVar = this.Emp.aPj(str);
            if (lVar != null) {
                AppMethodBeat.o(97483);
                return lVar;
            }
            lVar = new l();
        }
        lVar.field_userName = str;
        super.get(lVar, getPrimaryKey());
        AppMethodBeat.o(97483);
        return lVar;
    }

    public final boolean c(l lVar) {
        AppMethodBeat.i(97484);
        if (lVar == null || lVar.field_userName == null || lVar.field_userName.equals("")) {
            AppMethodBeat.o(97484);
            return false;
        }
        boolean replace = super.replace(lVar);
        AppMethodBeat.o(97484);
        return replace;
    }

    @Override // com.tencent.mm.plugin.sns.b.f
    public final boolean a(String str, ebj ebj) {
        AppMethodBeat.i(97485);
        if (ebj == null) {
            AppMethodBeat.o(97485);
            return false;
        }
        l aQr = aQr(str);
        String Jb = r.Jb(ebj.kel);
        if (!Util.isNullOrNil(ebj.kek) && (aQr.field_bgUrl == null || !aQr.field_bgId.equals(Jb))) {
            aQr.field_older_bgId = aQr.field_bgId;
            aQr.field_local_flag |= 1;
            aQr.feI();
            Log.d("MicroMsg.SnsExtStorage", "bg change");
        }
        aQr.field_bgId = Jb;
        aQr.field_bgUrl = ebj.kek;
        aQr.field_iFlag = ebj.kej;
        aQr.field_snsBgId = ebj.kel;
        aQr.field_local_flag |= 4;
        if ((ebj.Nbc & 4096) == 0) {
            if ((ebj.Nbc & 512) > 0) {
                ebj.Nbc |= 4096;
                ebj.Nbd = 4320;
            } else if ((ebj.Nbc & 1024) > 0) {
                ebj.Nbc |= 4096;
                ebj.Nbd = 72;
            }
        }
        aQr.a(ebj);
        a(aQr);
        AppMethodBeat.o(97485);
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.b.f
    public final ebj b(String str, ebj ebj) {
        AppMethodBeat.i(97486);
        l aQr = aQr(str);
        if (aQr == null) {
            l a2 = a(str, aQr);
            if (a2 != null) {
                ebj.kej = ebj.kej == -1 ? a2.field_iFlag : ebj.kej;
            }
            AppMethodBeat.o(97486);
        } else {
            ebj.kek = Util.isNullOrNil(ebj.kek) ? aQr.field_bgUrl : ebj.kek;
            boolean z = ebj.kej == -1;
            ebj.kej = z ? aQr.field_iFlag : ebj.kej;
            l a3 = a(str, aQr);
            if (a3 != null) {
                ebj.kej = z ? a3.field_iFlag : ebj.kej;
            }
            AppMethodBeat.o(97486);
        }
        return ebj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.mm.plugin.sns.storage.l a(java.lang.String r10, com.tencent.mm.plugin.sns.storage.l r11) {
        /*
        // Method dump skipped, instructions count: 168
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.m.a(java.lang.String, com.tencent.mm.plugin.sns.storage.l):com.tencent.mm.plugin.sns.storage.l");
    }

    @Override // com.tencent.mm.plugin.sns.b.f
    public final ebj aNV(String str) {
        AppMethodBeat.i(97488);
        l aQr = aQr(str);
        if (aQr == null) {
            ebj ebj = new ebj();
            AppMethodBeat.o(97488);
            return ebj;
        }
        ebj feL = aQr.feL();
        AppMethodBeat.o(97488);
        return feL;
    }

    @Override // com.tencent.mm.plugin.sns.b.f
    public final boolean cf(String str, boolean z) {
        int i2;
        AppMethodBeat.i(97489);
        l aQr = aQr(str);
        int i3 = aQr.field_iFlag;
        if (z) {
            i2 = i3 | 1;
        } else {
            i2 = i3 & -2;
        }
        aQr.field_iFlag = i2;
        c(aQr);
        AppMethodBeat.o(97489);
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.b.f
    public final ebj cg(String str, boolean z) {
        int i2;
        AppMethodBeat.i(97490);
        ebj feL = aQr(str).feL();
        if (feL == null) {
            Log.e("MicroMsg.SnsExtStorage", "userinfo is null");
            AppMethodBeat.o(97490);
            return null;
        }
        int i3 = feL.Nbc;
        if (z) {
            i2 = i3 | 1;
        } else {
            i2 = i3 & -2;
        }
        feL.Nbc = i2;
        AppMethodBeat.o(97490);
        return feL;
    }

    @Override // com.tencent.mm.plugin.sns.b.f
    public final boolean a(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        int i2;
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(97491);
        l aQr = aQr(str);
        int i6 = aQr.field_iFlag;
        if (aQr.feL() != null) {
            i2 = aQr.feL().Nbc;
        } else {
            i2 = 0;
        }
        int i7 = -1;
        int i8 = i6 | 4096;
        int i9 = i2 | 4096;
        if (z) {
            i7 = 4320;
        }
        if (z2) {
            i7 = 72;
        }
        if (z4) {
            i3 = 720;
        } else {
            i3 = i7;
        }
        if (z3) {
            i4 = i8 | 2048;
            i5 = i9 | 2048;
        } else {
            i4 = i8 & -2049;
            i5 = i9 & -2049;
        }
        aQr.field_iFlag = i4;
        ebj feL = aQr.feL();
        if (feL != null) {
            feL.Nbc = i5;
            feL.Nbd = i3;
            aQr.a(feL);
        }
        c(aQr);
        AppMethodBeat.o(97491);
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.b.f
    public final ebj b(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        int i2;
        int i3;
        AppMethodBeat.i(97492);
        ebj feL = aQr(str).feL();
        if (feL == null) {
            Log.e("MicroMsg.SnsExtStorage", "userinfo is null");
            AppMethodBeat.o(97492);
            return null;
        }
        int i4 = -1;
        int i5 = feL.Nbc | 4096;
        if (z) {
            i4 = 4320;
        }
        if (z2) {
            i4 = 72;
        }
        if (z4) {
            i2 = 720;
        } else {
            i2 = i4;
        }
        if (z3) {
            i3 = i5 | 2048;
        } else {
            i3 = i5 & -2049;
        }
        feL.Nbc = i3;
        feL.Nbd = i2;
        AppMethodBeat.o(97492);
        return feL;
    }

    public final List<ebo> aQs(String str) {
        AppMethodBeat.i(97493);
        LinkedList<ebo> linkedList = aQr(str).feJ().Nbb;
        AppMethodBeat.o(97493);
        return linkedList;
    }

    public final void D(String str, List<ebo> list) {
        AppMethodBeat.i(97494);
        if (list == null) {
            Log.i("MicroMsg.SnsExtStorage", "updateSnsYearMonthInfo info is null");
            list = new ArrayList<>();
        }
        Log.i("MicroMsg.SnsExtStorage", "updateSnsYearMonthInfo size:%s", Integer.valueOf(list.size()));
        l aQr = aQr(str);
        ebi feJ = aQr.feJ();
        feJ.Nbb.clear();
        feJ.Nbb.addAll(list);
        aQr.a(feJ);
        c(aQr);
        AppMethodBeat.o(97494);
    }
}
