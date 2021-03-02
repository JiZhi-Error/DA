package com.tencent.mm.plugin.brandservice.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f implements i {
    public LinkedList<a> pno = new LinkedList<>();
    private boolean pnp = false;
    private List<qw> pnq = new LinkedList();
    private List<qw> pnr = new LinkedList();

    public interface a {
        void onChange();
    }

    public f() {
        AppMethodBeat.i(5570);
        g.azz().a(387, this);
        g.azz().a(new i(), 0);
        AppMethodBeat.o(5570);
    }

    public final void init() {
        AppMethodBeat.i(5571);
        long currentTimeMillis = System.currentTimeMillis();
        this.pnq.clear();
        this.pnr.clear();
        StringBuilder sb = new StringBuilder();
        sb.append("select bizinfo.brandIconURL");
        sb.append(", bizinfo.type");
        sb.append(", bizinfo.status");
        sb.append(", rcontact.username");
        sb.append(", rcontact.conRemark");
        sb.append(", rcontact.nickname");
        sb.append(", rcontact.alias");
        sb.append(", rcontact.conRemarkPYFull");
        sb.append(", rcontact.conRemarkPYShort");
        sb.append(", rcontact.showHead");
        sb.append(", rcontact.pyInitial");
        sb.append(", rcontact.quanPin");
        sb.append(" from rcontact, bizinfo");
        sb.append(" where rcontact.username = bizinfo.username");
        sb.append(" and (rcontact.verifyFlag & ").append(as.gBP()).append(") != 0 ");
        sb.append(" and (rcontact.type & 1) != 0 ");
        sb.append(" order by showHead asc, ");
        sb.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        sb.append(" else upper(quanPin) end asc, ");
        sb.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        sb.append(" else upper(quanPin) end asc, ");
        sb.append(" upper(quanPin) asc, ");
        sb.append(" upper(nickname) asc");
        String sb2 = sb.toString();
        Log.d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", sb2);
        g.aAi();
        Cursor rawQuery = g.aAh().hqK.rawQuery(sb2, null, 2);
        HashMap hashMap = new HashMap();
        if (rawQuery != null) {
            int i2 = 0;
            while (rawQuery.moveToNext()) {
                int i3 = i2 + 1;
                as asVar = new as();
                asVar.convertFrom(rawQuery);
                c cVar = new c();
                cVar.convertFrom(rawQuery);
                if (!asVar.field_username.equals("gh_43f2581f6fd6") && !asVar.field_username.equals("gh_3dfda90e39d6") && !asVar.field_username.equals("gh_f0a92aa7146c") && (1 != ((b) g.af(b.class)).a(b.a.clicfg_minishop_plugin_enabled, 0) || !asVar.field_username.equals("gh_579db1f2cf89"))) {
                    qw qwVar = new qw();
                    qwVar.userName = asVar.field_username;
                    qwVar.contact = asVar;
                    qwVar.Bdk = cVar;
                    if (!ab.Jf(qwVar.userName)) {
                        hashMap.put(qwVar.userName, qwVar);
                        if (qwVar.Bdk.field_type != 3) {
                            if (qwVar.Bdk.field_type == 2) {
                                this.pnq.add(qwVar);
                                i2 = i3;
                            } else {
                                if (qwVar.Bdk.field_type == 1 || qwVar.Bdk.field_type == 0) {
                                    this.pnr.add(qwVar);
                                }
                                i2 = i3;
                            }
                        }
                    }
                }
                i2 = i3;
            }
            Log.d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", Integer.valueOf(i2));
            rawQuery.close();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("select username");
        sb3.append(" from rcontact");
        sb3.append(" where (verifyFlag & ").append(as.gBP()).append(") != 0 ");
        sb3.append(" and (type & 1) != 0 ");
        String sb4 = sb3.toString();
        Log.d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", sb4);
        g.aAi();
        Cursor rawQuery2 = g.aAh().hqK.rawQuery(sb4, null);
        if (rawQuery2 != null) {
            ArrayList arrayList = new ArrayList();
            while (rawQuery2.moveToNext()) {
                String string = rawQuery2.getString(0);
                if (!hashMap.containsKey(string)) {
                    arrayList.add(string);
                }
            }
            rawQuery2.close();
            Log.i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", Integer.valueOf(arrayList.size()), arrayList);
            if (!arrayList.isEmpty()) {
                g.aAi();
                long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ay.a.iDq.aL((String) it.next(), "");
                }
                g.aAi();
                g.aAh().hqK.endTransaction(beginTransaction);
            }
        }
        Log.d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        Log.d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", Integer.valueOf(this.pnr.size()), Integer.valueOf(this.pnq.size()));
        Log.d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(5571);
    }

    public final void release() {
        AppMethodBeat.i(5572);
        g.azz().b(387, this);
        if (this.pnp) {
            ArrayList arrayList = new ArrayList(this.pnq.size() + this.pnr.size());
            for (qw qwVar : this.pnq) {
                arrayList.add(qwVar);
            }
            for (qw qwVar2 : this.pnr) {
                arrayList.add(qwVar2);
            }
            g.azz().a(new n(arrayList), 0);
        }
        AppMethodBeat.o(5572);
    }

    public final List<qw> CV(int i2) {
        switch (i2) {
            case 2:
                return this.pnq;
            default:
                return this.pnr;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3 A[EDGE_INSN: B:43:0x00a3->B:30:0x00a3 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c8 A[EDGE_INSN: B:47:0x00c8->B:40:0x00c8 ?: BREAK  , SYNTHETIC] */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r8, int r9, java.lang.String r10, com.tencent.mm.ak.q r11) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.b.f.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }
}
