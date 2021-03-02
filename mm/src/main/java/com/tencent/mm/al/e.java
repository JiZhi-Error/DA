package com.tencent.mm.al;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.protocal.protobuf.ji;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;

public final class e extends MAutoStorage<d> implements i {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(d.info, "BizEnterprise")};
    public static ji iNR;
    private ISQLiteDatabase db;
    private final MStorageEvent<a, a.C0254a> iNS = new MStorageEvent<a, a.C0254a>() {
        /* class com.tencent.mm.al.e.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(a aVar, a.C0254a aVar2) {
            AppMethodBeat.i(123985);
            aVar.a(aVar2);
            AppMethodBeat.o(123985);
        }
    };

    static {
        AppMethodBeat.i(124005);
        AppMethodBeat.o(124005);
    }

    public e(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, d.info, "BizEnterprise", null);
        AppMethodBeat.i(123989);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
        g.aAg().hqi.a(1343, this);
        g.aAg().hqi.a(1228, this);
        AppMethodBeat.o(123989);
    }

    public interface a {

        /* renamed from: com.tencent.mm.al.e$a$a  reason: collision with other inner class name */
        public static class C0254a {
            public b iNU;
            public String iNV;
            public d iNW;
        }

        void a(C0254a aVar);

        public enum b {
            INSERT,
            DELETE,
            UPDATE;

            public static b valueOf(String str) {
                AppMethodBeat.i(123987);
                b bVar = (b) Enum.valueOf(b.class, str);
                AppMethodBeat.o(123987);
                return bVar;
            }

            static {
                AppMethodBeat.i(123988);
                AppMethodBeat.o(123988);
            }
        }
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(123990);
        this.iNS.add(aVar, looper);
        AppMethodBeat.o(123990);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(123991);
        if (this.iNS != null) {
            this.iNS.remove(aVar);
        }
        AppMethodBeat.o(123991);
    }

    public final d MO(String str) {
        AppMethodBeat.i(123992);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(123992);
            return null;
        }
        d dVar = new d();
        dVar.field_userName = str;
        if (super.get(dVar, new String[0])) {
            AppMethodBeat.o(123992);
            return dVar;
        }
        a(str, (i) null);
        AppMethodBeat.o(123992);
        return null;
    }

    public final d MP(String str) {
        AppMethodBeat.i(123993);
        d MO = MO(str);
        if (MO == null) {
            d dVar = new d();
            dVar.field_userName = str;
            dVar.field_qyUin = 0;
            dVar.field_userUin = 0;
            dVar.field_userFlag = 0;
            dVar.field_wwExposeTimes = 0;
            dVar.field_wwMaxExposeTimes = 0;
            dVar.field_wwUserVid = 0;
            dVar.field_wwCorpId = 0;
            dVar.field_chatOpen = false;
            dVar.field_wwUnreadCnt = 0;
            AppMethodBeat.o(123993);
            return dVar;
        }
        AppMethodBeat.o(123993);
        return MO;
    }

    public final int MQ(String str) {
        AppMethodBeat.i(123994);
        d MO = MO(str);
        if (MO == null) {
            AppMethodBeat.o(123994);
            return 0;
        }
        int i2 = MO.field_qyUin;
        AppMethodBeat.o(123994);
        return i2;
    }

    public final boolean gC(String str) {
        boolean z = false;
        AppMethodBeat.i(123995);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(123995);
        } else {
            d dVar = new d();
            dVar.field_userName = str;
            z = super.delete(dVar, "userName");
            if (z) {
                a.C0254a aVar = new a.C0254a();
                aVar.iNV = str;
                aVar.iNU = a.b.DELETE;
                aVar.iNW = dVar;
                this.iNS.event(aVar);
                this.iNS.doNotify();
            }
            AppMethodBeat.o(123995);
        }
        return z;
    }

    private boolean a(d dVar) {
        AppMethodBeat.i(123996);
        if (dVar == null) {
            AppMethodBeat.o(123996);
            return false;
        }
        boolean insert = super.insert(dVar);
        a.b bVar = a.b.INSERT;
        if (!insert) {
            insert = super.replace(dVar);
            bVar = a.b.UPDATE;
        }
        if (insert) {
            a.C0254a aVar = new a.C0254a();
            aVar.iNV = dVar.field_userName;
            aVar.iNU = bVar;
            aVar.iNW = dVar;
            this.iNS.event(aVar);
            this.iNS.doNotify();
        }
        AppMethodBeat.o(123996);
        return insert;
    }

    private boolean a(og ogVar) {
        AppMethodBeat.i(123997);
        d MP = MP(ogVar.KTt);
        MP.field_userName = ogVar.KTt;
        MP.field_qyUin = ogVar.KTO;
        MP.field_userUin = ogVar.KTP;
        MP.field_wwMaxExposeTimes = ogVar.KTR;
        MP.field_wwUserVid = ogVar.KTS;
        MP.field_wwCorpId = ogVar.KTT;
        MP.field_userType = ogVar.KTD;
        MP.field_chatOpen = ogVar.KTU;
        MP.field_wwUnreadCnt = ogVar.KTV;
        MP.field_show_confirm = ogVar.KTW;
        MP.field_use_preset_banner_tips = ogVar.KTY;
        if (ogVar.KTZ != null) {
            MP.field_hide_create_chat = ogVar.KTZ.Lil;
            MP.field_hide_mod_chat_member = ogVar.KTZ.Lim;
        }
        MP.field_hide_colleage_invite = ogVar.KUb;
        try {
            oh ohVar = new oh();
            ohVar.KUa = ogVar.KUa;
            ohVar.KUc = ogVar.KUc;
            ohVar.KUd = ogVar.KUd;
            ohVar.KUe = ogVar.KUe;
            MP.field_raw_attrs = ohVar.toByteArray();
        } catch (Throwable th) {
        }
        iNR = ogVar.KTX;
        if (ogVar.KTS == 0 && ogVar.KTT == 0 && ogVar.KTO != 0) {
            MP.field_wwUserVid = (long) ogVar.KTP;
            MP.field_wwCorpId = (long) ogVar.KTO;
        }
        ogVar.KTQ &= -9;
        MP.field_userFlag = ogVar.KTQ | (MP.field_userFlag & 8);
        boolean a2 = a(MP);
        AppMethodBeat.o(123997);
        return a2;
    }

    public static boolean a(String str, i iVar) {
        int i2;
        AppMethodBeat.i(123998);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(123998);
            return false;
        }
        if (g.Ng(str)) {
            i2 = 1;
        } else if (g.Nf(str)) {
            i2 = 2;
        } else {
            AppMethodBeat.o(123998);
            return false;
        }
        boolean a2 = g.aAg().hqi.a(new y(str, i2, iVar), 0);
        AppMethodBeat.o(123998);
        return a2;
    }

    public static af a(String str, boolean z, i iVar) {
        AppMethodBeat.i(123999);
        og ogVar = new og();
        ogVar.KTt = str;
        ogVar.KTQ = z ? 17 : 0;
        ogVar.KTO = 0;
        af afVar = new af(ogVar, iVar);
        if (g.aAg().hqi.a(afVar, 0)) {
            AppMethodBeat.o(123999);
            return afVar;
        }
        AppMethodBeat.o(123999);
        return null;
    }

    public final void MR(String str) {
        AppMethodBeat.i(124000);
        d MP = MP(str);
        if (MP.field_wwExposeTimes >= MP.field_wwMaxExposeTimes) {
            AppMethodBeat.o(124000);
            return;
        }
        MP.field_wwExposeTimes++;
        a(MP);
        AppMethodBeat.o(124000);
    }

    public static void a(af afVar) {
        AppMethodBeat.i(124001);
        g.aAg().hqi.a(afVar);
        afVar.data = null;
        AppMethodBeat.o(124001);
    }

    public final boolean MS(String str) {
        AppMethodBeat.i(124002);
        d MO = MO(str);
        if (MO == null || (MO.field_userFlag & 1) == 0 || (MO.field_userFlag & 16) == 0) {
            AppMethodBeat.o(124002);
            return false;
        }
        AppMethodBeat.o(124002);
        return true;
    }

    public static String sM(int i2) {
        AppMethodBeat.i(124003);
        String str = null;
        if (iNR == null) {
            iNR = new ji();
        }
        switch (i2) {
            case 0:
                str = iNR.KNR;
                break;
            case 1:
                str = iNR.KNS;
                break;
            case 2:
                str = iNR.KNT;
                break;
        }
        AppMethodBeat.o(124003);
        return str;
    }

    public static String aZA() {
        AppMethodBeat.i(179034);
        if (iNR == null) {
            iNR = new ji();
        }
        String str = iNR.pTL;
        AppMethodBeat.o(179034);
        return str;
    }

    public static String aZB() {
        AppMethodBeat.i(179035);
        if (iNR == null) {
            iNR = new ji();
        }
        String str = iNR.qGB;
        AppMethodBeat.o(179035);
        return str;
    }

    public static int aZC() {
        AppMethodBeat.i(179036);
        if (iNR == null) {
            iNR = new ji();
        }
        int i2 = 0;
        try {
            i2 = Integer.parseInt(iNR.KNV);
        } catch (Throwable th) {
        }
        AppMethodBeat.o(179036);
        return i2;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        dvx dvx;
        bjs bjs;
        int i4 = -1;
        AppMethodBeat.i(124004);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof y) {
                y yVar = (y) qVar;
                if (yVar.rr == null || yVar.rr.iLL.iLR == null) {
                    bjs = null;
                } else {
                    bjs = (bjs) yVar.rr.iLL.iLR;
                }
                if (bjs == null || bjs.KTz == null || bjs.KTz.ret != 0 || bjs.LTl == null) {
                    AppMethodBeat.o(124004);
                    return;
                }
                if (!a(bjs.LTl)) {
                    i3 = -1;
                }
                i iVar = (i) yVar.data;
                if (iVar != null) {
                    iVar.onSceneEnd(i2, i3, str, qVar);
                }
            }
            if (qVar instanceof af) {
                af afVar = (af) qVar;
                if (afVar.rr == null || afVar.rr.iLL.iLR == null) {
                    dvx = null;
                } else {
                    dvx = (dvx) afVar.rr.iLL.iLR;
                }
                if (dvx == null || dvx.KTz == null || dvx.KTz.ret != 0 || dvx.LTl == null) {
                    AppMethodBeat.o(124004);
                    return;
                }
                if (a(dvx.LTl)) {
                    i4 = i3;
                }
                i iVar2 = (i) afVar.data;
                if (iVar2 != null) {
                    iVar2.onSceneEnd(i2, i4, str, qVar);
                }
            }
            AppMethodBeat.o(124004);
            return;
        }
        AppMethodBeat.o(124004);
    }
}
