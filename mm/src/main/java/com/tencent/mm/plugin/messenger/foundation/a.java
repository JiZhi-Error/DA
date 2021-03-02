package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.vending.b.b;

public final class a implements x {
    private static final C1474a zpp = new C1474a((byte) 0);

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.messenger.foundation.a$a  reason: collision with other inner class name */
    public static final class C1474a extends com.tencent.mm.co.a<d> implements d {
        private C1474a() {
        }

        /* synthetic */ C1474a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.d
        public final void a(final as asVar, final as asVar2, final cpl cpl, final byte[] bArr, final boolean z) {
            AppMethodBeat.i(116869);
            a(new a.AbstractC0297a<d>() {
                /* class com.tencent.mm.plugin.messenger.foundation.a.C1474a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(d dVar) {
                    AppMethodBeat.i(116867);
                    dVar.a(asVar, asVar2, cpl, bArr, z);
                    AppMethodBeat.o(116867);
                }
            });
            AppMethodBeat.o(116869);
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.d
        public final void b(final as asVar, final as asVar2, final cpl cpl, final byte[] bArr, final boolean z) {
            AppMethodBeat.i(116870);
            a(new a.AbstractC0297a<d>() {
                /* class com.tencent.mm.plugin.messenger.foundation.a.C1474a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(d dVar) {
                    AppMethodBeat.i(116868);
                    dVar.b(asVar, asVar2, cpl, bArr, z);
                    AppMethodBeat.o(116868);
                }
            });
            AppMethodBeat.o(116870);
        }
    }

    static {
        AppMethodBeat.i(116874);
        AppMethodBeat.o(116874);
    }

    public static b addContactAssembler(d dVar) {
        AppMethodBeat.i(116871);
        b add = zpp.add(dVar);
        AppMethodBeat.o(116871);
        return add;
    }

    public static void removeContactAssembler(d dVar) {
        AppMethodBeat.i(169106);
        zpp.remove(dVar);
        AppMethodBeat.o(169106);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.x
    public final void a(abn abn, byte[] bArr, boolean z, aa aaVar) {
        AppMethodBeat.i(116872);
        switch (abn.Lms) {
            case 2:
            case 17:
                processModContact((cpl) new cpl().parseFrom(bArr), "", z ? bArr : null, false, z, 0);
                AppMethodBeat.o(116872);
                return;
            case 4:
                afh afh = (afh) new afh().parseFrom(bArr);
                String a2 = z.a(afh.Lqk);
                Log.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", a2);
                ((l) g.af(l.class)).aST().bjW(a2);
                ab.IV(a2);
                com.tencent.mm.plugin.messenger.foundation.a.ab.b(4, afh);
                break;
        }
        AppMethodBeat.o(116872);
    }

    public static void processModContact(cpl cpl, String str, byte[] bArr, boolean z, boolean z2, int i2) {
        as asVar;
        int length;
        String secPrint;
        AppMethodBeat.i(187478);
        if (cpl == null) {
            Log.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
            AppMethodBeat.o(187478);
            return;
        }
        String a2 = !Util.isNullOrNil(cpl.LRy) ? cpl.LRy : z.a(cpl.Lqk);
        String nullAsNil = Util.nullAsNil(cpl.Mvn);
        if (!Util.isNullOrNil(a2) || !Util.isNullOrNil(nullAsNil)) {
            Log.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s modContactScene %s ", cpl.Lqk, cpl.Mvq, cpl.Mvr, Integer.valueOf(i2));
            as bjL = ((l) g.af(l.class)).aSN().bjL(a2);
            if (ab.Iw(a2) || bjL == null || !a2.equals(bjL.field_encryptUsername)) {
                as asVar2 = null;
                if (bjL == null || (asVar = bjL.gBT()) == null) {
                    asVar = bjL;
                } else {
                    asVar2 = bjL;
                }
                if (asVar2 == null) {
                    asVar2 = new as(a2);
                }
                asVar2.setUsername(a2);
                asVar2.BC(cpl.ked);
                asVar2.setType(cpl.LoG & cpl.LoH);
                if (z && asVar != null && ((int) asVar.gMZ) > 0) {
                    Log.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", a2, Integer.valueOf(asVar.field_type), Integer.valueOf(asVar2.field_type));
                    asVar2.setType(asVar2.field_type | asVar.field_type);
                }
                if (!Util.isNullOrNil(nullAsNil)) {
                    asVar2.BK(nullAsNil);
                } else if (asVar != null && ((int) asVar.gMZ) > 0) {
                    asVar2.BK(asVar.field_encryptUsername);
                }
                asVar2.gMZ = asVar == null ? 0 : (long) ((int) asVar.gMZ);
                asVar2.setNickname(z.a(cpl.Mjj));
                asVar2.BF(z.a(cpl.LpA));
                asVar2.BG(z.a(cpl.LpB));
                asVar2.nj(cpl.kdY);
                asVar2.nl(cpl.LoM);
                asVar2.BE(z.a(cpl.Mvh));
                asVar2.nm(cpl.LoQ);
                asVar2.nn(cpl.kec);
                asVar2.Cb(RegionCodeDecoder.bq(cpl.keh, cpl.kdZ, cpl.kea));
                asVar2.BV(cpl.keb);
                asVar2.nf(cpl.MmK);
                asVar2.Ca(cpl.MmL);
                if (cpl.xub == 9 && !Util.isNullOrNil(cpl.MvA)) {
                    Log.i("MicroMsg.ContactSyncExtension", "fix addContactScene!");
                    cpl.xub = 14;
                }
                asVar2.setSource(cpl.xub);
                asVar2.ne(cpl.MmO);
                asVar2.BH(cpl.MmN);
                asVar2.BO(cpl.MvA);
                asVar2.yy(cpl.fvd);
                Log.i("MicroMsg.ContactSyncExtension", "username:%s nickname:%s SourceExtInfo:%s source:%s ChatroomBusinessType:%s", asVar2.field_username, Util.secPrint(asVar2.field_nickname), asVar2.field_sourceExtInfo, Integer.valueOf(cpl.xub), Long.valueOf(cpl.fvd));
                if (ab.JK(cpl.MmM)) {
                    asVar2.BZ(cpl.MmM);
                }
                if (asVar2.gBQ()) {
                    asVar2.no((int) Util.nowSecond());
                }
                if (!TextUtils.isEmpty(str)) {
                    asVar2.Cj(str);
                }
                Log.i("MicroMsg.ContactSyncExtension", "remark (%s -> %s), remarkpyshort:%s, nickname:%s, pyinitial:%s, quanpin:%s", asVar2.field_conRemark, z.a(cpl.MuI), z.a(cpl.MuJ), z.a(cpl.Mjj), z.a(cpl.LpA), z.a(cpl.LpB));
                asVar2.BD(z.a(cpl.MuI));
                asVar2.BI(z.a(cpl.MuK));
                asVar2.BJ(z.a(cpl.MuJ));
                asVar2.BL(cpl.Lqm);
                asVar2.Cc(cpl.KHk);
                asVar2.Cd(cpl.Mvw);
                if (!Util.isNullOrNil(bArr)) {
                    ((l) g.af(l.class)).aSN().B(a2, bArr);
                } else {
                    ((l) g.af(l.class)).aSN().bjQ(a2);
                    Log.e("MicroMsg.ContactSyncExtension", "[processModContact] cmdBuf is null! user:%s", a2);
                }
                asVar2.nh(cpl.DeleteFlag);
                if (!(cpl.Mvs == null || cpl.Mvs.KHD == null)) {
                    asVar2.Ce(cpl.Mvs.KHD.KPG);
                    asVar2.Cf(cpl.Mvs.KHD.KPH);
                    asVar2.Cg(cpl.Mvs.KHD.KPI);
                }
                if (ab.JE(a2)) {
                    asVar2.aqZ();
                }
                if (asVar2.gBM()) {
                    asVar2.arc();
                }
                asVar2.Ch(cpl.fuW);
                asVar2.nq(cpl.ExtFlag);
                asVar2.setFromType(i2);
                Object[] objArr = new Object[21];
                objArr[0] = a2;
                objArr[1] = nullAsNil;
                objArr[2] = Integer.valueOf((int) asVar2.gMZ);
                objArr[3] = asVar2.field_nickname;
                objArr[4] = asVar2.ajA();
                objArr[5] = Integer.valueOf(asVar2.field_deleteFlag);
                objArr[6] = Integer.valueOf(asVar2.field_type);
                objArr[7] = Integer.valueOf(cpl.LoG);
                objArr[8] = Integer.valueOf(cpl.LoH);
                objArr[9] = Integer.valueOf(asVar2.fuE);
                objArr[10] = Integer.valueOf(asVar2.fuH);
                objArr[11] = cpl.keh;
                objArr[12] = cpl.kdZ;
                objArr[13] = cpl.kea;
                objArr[14] = Integer.valueOf(asVar2.getSource());
                objArr[15] = asVar2.field_contactLabelIds;
                objArr[16] = Boolean.valueOf(z);
                objArr[17] = Boolean.valueOf(cpl.KHk == null);
                if (cpl.KHk == null) {
                    length = 0;
                } else {
                    length = cpl.KHk.length();
                }
                objArr[18] = Integer.valueOf(length);
                if (cpl.KHk == null) {
                    secPrint = "";
                } else {
                    secPrint = Util.secPrint(cpl.KHk);
                }
                objArr[19] = secPrint;
                objArr[20] = Integer.valueOf(cpl.MmK);
                Log.i("MicroMsg.ContactSyncExtension", "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s) verifyFlag:%d", objArr);
                zpp.a(asVar2, asVar, cpl, bArr, z2);
                com.tencent.mm.contact.a.g(asVar2);
                if (!Util.isNullOrNil(nullAsNil)) {
                    ((l) g.af(l.class)).aSN().d(nullAsNil, asVar2);
                } else {
                    ((l) g.af(l.class)).aSN().ao(asVar2);
                }
                zpp.b(asVar2, asVar, cpl, bArr, z2);
                if ((asVar2.field_type & 2048) != 0) {
                    if (asVar == null || (asVar.field_type & 2048) != (asVar2.field_type & 2048)) {
                        ((l) g.af(l.class)).aST().bke(asVar2.field_username);
                    }
                } else if (asVar == null || (asVar.field_type & 2048) != (asVar2.field_type & 2048)) {
                    ((l) g.af(l.class)).aST().bkf(asVar2.field_username);
                }
                Log.i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", a2, Boolean.valueOf(asVar2.arB()));
                AppMethodBeat.o(187478);
                return;
            }
            Log.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", a2);
            AppMethodBeat.o(187478);
            return;
        }
        Log.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", a2, nullAsNil);
        AppMethodBeat.o(187478);
    }
}
