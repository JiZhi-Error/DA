package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.d.c;
import com.tencent.mm.plugin.fav.ui.d.d;
import com.tencent.mm.plugin.fav.ui.d.e;
import com.tencent.mm.plugin.fav.ui.d.f;
import com.tencent.mm.plugin.fav.ui.d.h;
import com.tencent.mm.plugin.fav.ui.d.i;
import com.tencent.mm.plugin.fav.ui.d.j;
import com.tencent.mm.plugin.fav.ui.d.k;
import com.tencent.mm.plugin.fav.ui.d.l;
import com.tencent.mm.plugin.fav.ui.d.m;
import com.tencent.mm.plugin.fav.ui.d.n;
import com.tencent.mm.plugin.fav.ui.d.p;
import com.tencent.mm.plugin.fav.ui.d.q;
import com.tencent.mm.plugin.fav.ui.d.r;
import com.tencent.mm.plugin.fav.ui.d.s;
import com.tencent.mm.plugin.fav.ui.d.t;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class b extends a {
    private IListener lEl = new IListener<mx>() {
        /* class com.tencent.mm.plugin.fav.ui.a.b.AnonymousClass1 */

        {
            AppMethodBeat.i(160919);
            this.__eventId = mx.class.getName().hashCode();
            AppMethodBeat.o(160919);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(107085);
            mx mxVar2 = mxVar;
            if (mxVar2 instanceof mx) {
                switch (mxVar2.dSE.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        b.this.notifyDataSetChanged();
                        break;
                }
            }
            AppMethodBeat.o(107085);
            return false;
        }
    };
    public int pHw;
    public String query = "";
    public int scene;
    private boolean thg = false;
    public List<g> thh = new ArrayList();
    private List<g> thi = new ArrayList();
    private List<g> thj = new LinkedList();
    public List<Long> thk = new ArrayList();
    public boolean thl = false;
    private Map<String, g> thm = new TreeMap();
    private List<Integer> thn = new ArrayList();
    private List<String> tho = new LinkedList();
    private List<String> thp = new LinkedList();
    private SparseArray<com.tencent.mm.plugin.fav.ui.d.b> thq = new SparseArray<>();
    private boolean thr = false;
    public b.c ths;
    public boolean tht = false;
    public boolean thu = false;
    public ListView thv;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(107109);
        g Id = Id(i2);
        AppMethodBeat.o(107109);
        return Id;
    }

    public b(o oVar, boolean z) {
        AppMethodBeat.i(107086);
        this.type = -1;
        this.thq.put(1, new p(oVar));
        this.thq.put(2, new f(oVar));
        this.thq.put(3, new t(oVar));
        this.thq.put(4, new s(oVar));
        this.thq.put(5, new r(oVar));
        this.thq.put(6, new com.tencent.mm.plugin.fav.ui.d.g(oVar));
        this.thq.put(7, new i(oVar));
        this.thq.put(21, new j(oVar));
        this.thq.put(8, new d(oVar));
        this.thq.put(10, new l(oVar));
        this.thq.put(12, new com.tencent.mm.plugin.fav.ui.d.o(oVar));
        this.thq.put(15, new com.tencent.mm.plugin.fav.ui.d.o(oVar));
        this.thq.put(11, new h(oVar));
        this.thq.put(14, new m(oVar));
        this.thq.put(16, new n(oVar));
        this.thq.put(17, new c(oVar));
        this.thq.put(18, new k(oVar));
        this.thq.put(20, new e(oVar));
        this.thq.put(19, new a(oVar));
        this.thq.put(-2, new q(oVar));
        if (z != this.tht) {
            this.tht = z;
            if (z) {
                this.thm.clear();
            }
        }
        if (!this.tht) {
            boE();
        }
        cWm();
        notifyDataSetChanged();
        EventCenter.instance.removeListener(this.lEl);
        EventCenter.instance.addListener(this.lEl);
        AppMethodBeat.o(107086);
    }

    public final void finish() {
        AppMethodBeat.i(107087);
        EventCenter.instance.removeListener(this.lEl);
        AppMethodBeat.o(107087);
    }

    private void setSubScene(int i2) {
        int i3 = this.pHw;
        if (i2 == 0) {
            this.pHw = 0;
        } else if (i3 == 0) {
            this.pHw = i2;
        } else if (i3 != i2) {
            this.pHw = 4;
        }
    }

    @Override // com.tencent.mm.plugin.fav.ui.a.a
    public final void boE() {
        AppMethodBeat.i(107088);
        if (cWo()) {
            Log.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
            AppMethodBeat.o(107088);
        } else if (com.tencent.mm.plugin.fav.a.b.cUo()) {
            Log.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
            AppMethodBeat.o(107088);
        } else if (!this.tht) {
            try {
                this.lastUpdateTime = com.tencent.mm.plugin.fav.a.b.v(this.lastUpdateTime, this.type);
                AppMethodBeat.o(107088);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FavoriteAdapter", e2, "", new Object[0]);
                AppMethodBeat.o(107088);
            }
        } else {
            this.thi = l(this.thh, this.thk);
            this.thg = true;
            AppMethodBeat.o(107088);
        }
    }

    private static List<g> l(List<g> list, List<Long> list2) {
        int i2 = 0;
        AppMethodBeat.i(107089);
        ArrayList arrayList = new ArrayList();
        if (list2 == null) {
            AppMethodBeat.o(107089);
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
            Long valueOf = Long.valueOf(list.get(list.size() - 1).field_localId);
            int i3 = 0;
            while (true) {
                if (i3 >= list2.size()) {
                    break;
                } else if (valueOf.equals(list2.get(i3))) {
                    i2 = i3 + 1;
                    break;
                } else {
                    i3++;
                }
            }
        }
        int i4 = i2;
        while (i4 < i2 + 20 && i4 < list2.size()) {
            g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(list2.get(i4).longValue());
            if (DY != null) {
                arrayList.add(DY);
            }
            i4++;
        }
        AppMethodBeat.o(107089);
        return arrayList;
    }

    private void cWn() {
        AppMethodBeat.i(107090);
        setSubScene(0);
        this.thk = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUX();
        AppMethodBeat.o(107090);
    }

    private void dJ(List<g> list) {
        AppMethodBeat.i(107091);
        if (list == null) {
            AppMethodBeat.o(107091);
            return;
        }
        Log.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", Integer.valueOf(list.size()));
        Log.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", Integer.valueOf(this.thj.size()));
        list.clear();
        AppMethodBeat.o(107091);
    }

    private boolean cWo() {
        AppMethodBeat.i(107092);
        if (!this.tho.isEmpty() || !this.thp.isEmpty() || !this.thn.isEmpty()) {
            AppMethodBeat.o(107092);
            return true;
        }
        AppMethodBeat.o(107092);
        return false;
    }

    public final void a(boolean z, g gVar) {
        g DY;
        AppMethodBeat.i(107093);
        if (z == this.thl) {
            AppMethodBeat.o(107093);
            return;
        }
        this.thl = z;
        if (z) {
            this.thm.clear();
            if (!(gVar == null || (DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(gVar.field_localId)) == null)) {
                if (gVar.tad) {
                    this.thm.put(gVar.dLb, gVar);
                } else {
                    this.thm.put(Util.notNullToString(Long.valueOf(DY.field_localId)), DY);
                }
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.o(107093);
    }

    public final List<g> mE(boolean z) {
        AppMethodBeat.i(107094);
        LinkedList linkedList = new LinkedList();
        for (g gVar : this.thm.values()) {
            if (gVar != null) {
                linkedList.add(gVar);
            }
        }
        if (z) {
            this.thm.clear();
        }
        AppMethodBeat.o(107094);
        return linkedList;
    }

    public final int cWp() {
        AppMethodBeat.i(107095);
        int size = this.thm.size();
        AppMethodBeat.o(107095);
        return size;
    }

    public final long cWq() {
        AppMethodBeat.i(107096);
        long j2 = 0;
        for (g gVar : this.thm.values()) {
            if (gVar != null) {
                j2 = gVar.field_datatotalsize + j2;
            } else {
                j2 = j2;
            }
        }
        AppMethodBeat.o(107096);
        return j2;
    }

    public final void c(List<Integer> list, List<String> list2, List<String> list3) {
        AppMethodBeat.i(107097);
        setSubScene(0);
        this.thn.clear();
        if (list != null) {
            this.thn.addAll(list);
            if (!list.isEmpty()) {
                setSubScene(2);
            }
        }
        this.tho.clear();
        if (list2 != null) {
            this.tho.addAll(list2);
            if (!list2.isEmpty()) {
                setSubScene(3);
            }
        }
        this.thp.clear();
        if (list3 != null) {
            this.thp.addAll(list3);
            if (!list3.isEmpty()) {
                setSubScene(1);
            }
        }
        this.thr = true;
        cWm();
        this.thr = false;
        AppMethodBeat.o(107097);
    }

    @Override // com.tencent.mm.plugin.fav.ui.a.a
    public final void cWm() {
        Integer num;
        AppMethodBeat.i(107098);
        Log.v("MicroMsg.FavoriteAdapter", "reset data list beg");
        this.thg = false;
        dJ(this.thi);
        if (!cWo()) {
            Log.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type));
            if (!this.tht) {
                this.thi = com.tencent.mm.plugin.fav.a.b.a(this.lastUpdateTime, this.type, this.thd, this.the);
                if (this.thi != null && this.lastUpdateTime == 0 && this.thi.size() > 0) {
                    this.lastUpdateTime = this.thi.get(this.thi.size() - 1).field_updateTime;
                }
            } else {
                cWn();
                this.thi = l(null, this.thk);
            }
        } else {
            Log.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", this.tho, this.thp, this.thn);
            if (this.thn == null || this.thn.size() == 1) {
                if (this.thn != null) {
                    num = this.thn.get(0);
                } else {
                    num = null;
                }
                this.thi = com.tencent.mm.plugin.fav.a.b.a(this.tho, this.thp, num.intValue(), this.thj, this.thd, this.the);
            } else {
                this.thi = com.tencent.mm.plugin.fav.a.b.a(this.tho, this.thp, this.thn, this.thj, this.thd, this.the);
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10649, Integer.valueOf(this.thi == null ? 0 : this.thi.size()));
        }
        if (this.thi == null) {
            Log.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
            this.thi = new ArrayList();
        }
        if (!this.tht && !cWo() && this.thi.size() < 20 && !((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().z(this.lastUpdateTime, this.type)) {
            Log.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
            boE();
        }
        this.thg = true;
        Log.v("MicroMsg.FavoriteAdapter", "reset data list end");
        AppMethodBeat.o(107098);
    }

    @Override // com.tencent.mm.plugin.fav.ui.a.a
    public final boolean isEmpty() {
        AppMethodBeat.i(107099);
        boolean isEmpty = this.thh.isEmpty();
        AppMethodBeat.o(107099);
        return isEmpty;
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(107100);
        Log.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", Boolean.valueOf(this.thg));
        if (this.thg) {
            if (this.tht && this.thi != null && this.thh != null && this.thi.size() == this.thh.size()) {
                this.thu = true;
            }
            List<g> list = this.thh;
            this.thh = this.thi;
            this.thi = list;
            this.thg = false;
        }
        Log.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
        super.notifyDataSetChanged();
        AppMethodBeat.o(107100);
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(107101);
        if (i2 == 0) {
            AppMethodBeat.o(107101);
            return 0;
        }
        g Id = Id(i2 - 1);
        switch (Id.field_type) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                int i3 = Id.field_type;
                AppMethodBeat.o(107101);
                return i3;
            case 9:
            case 13:
            default:
                Log.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", Integer.valueOf(Id.field_type));
                AppMethodBeat.o(107101);
                return -2;
        }
    }

    public final int getViewTypeCount() {
        AppMethodBeat.i(107102);
        int size = this.thq.size() + 4;
        AppMethodBeat.o(107102);
        return size;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(107103);
        if (i2 == 0) {
            View view2 = new View(viewGroup.getContext());
            view2.setLayoutParams(new AbsListView.LayoutParams(0, 0));
            view2.setBackgroundResource(R.color.oy);
            view2.setPadding(0, 0, 0, 0);
            view2.setEnabled(false);
            AppMethodBeat.o(107103);
            return view2;
        }
        g Id = Id(i2 - 1);
        if (7 == Id.field_type) {
            String str = "";
            if (!(Id == null || Id.field_favProto == null || Id.field_favProto.Lya == null)) {
                str = Id.field_favProto.Lya.appId;
            }
            com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
            if (com.tencent.mm.plugin.comm.a.akQ(str)) {
                Id.field_type = 21;
            } else {
                com.tencent.mm.plugin.comm.a aVar2 = com.tencent.mm.plugin.comm.a.qCo;
                if (!com.tencent.mm.plugin.comm.a.cAI()) {
                    Id.field_type = 7;
                } else {
                    Id.field_type = 5;
                }
            }
        }
        com.tencent.mm.plugin.fav.ui.d.b bVar = this.thq.get(Id.field_type);
        if (bVar == null) {
            Log.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", Integer.valueOf(Id.field_type));
            cWl();
            View a2 = this.thq.get(-2).a(view, viewGroup, Id);
            AppMethodBeat.o(107103);
            return a2;
        }
        bVar.tle.poG = cWo();
        bVar.tle.lastUpdateTime = this.lastUpdateTime;
        bVar.tle.thl = this.thl;
        bVar.tle.thm = this.thm;
        bVar.tle.tlg = this.ths;
        bVar.tle.tht = this.tht;
        View a3 = bVar.a(view, viewGroup, Id);
        AppMethodBeat.o(107103);
        return a3;
    }

    public final g Id(int i2) {
        AppMethodBeat.i(107104);
        if (i2 < 0 || i2 >= this.thh.size()) {
            Log.e("MicroMsg.FavoriteAdapter", "get item, but position error");
            g gVar = new g();
            AppMethodBeat.o(107104);
            return gVar;
        }
        g gVar2 = this.thh.get(i2);
        AppMethodBeat.o(107104);
        return gVar2;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getCount() {
        AppMethodBeat.i(107105);
        int size = this.thh.size() + 1;
        AppMethodBeat.o(107105);
        return size;
    }

    public final int p(long j2, String str) {
        g gVar;
        boolean z = true;
        int i2 = 0;
        AppMethodBeat.i(107106);
        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2);
        if (DY == null) {
            AppMethodBeat.o(107106);
            return -1;
        } else if (this.thm.size() >= 30) {
            Log.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", 30);
            com.tencent.mm.ui.base.h.cD(MMApplicationContext.getContext(), MMApplicationContext.getContext().getResources().getString(R.string.ca7, 30));
            AppMethodBeat.o(107106);
            return -1;
        } else {
            if (!Util.isNullOrNil(str)) {
                Iterator<g> it = this.thh.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    gVar = it.next();
                    if (Util.isEqual(gVar.dLb, str)) {
                        gVar.tae = DY;
                        break;
                    }
                }
            }
            z = false;
            gVar = DY;
            if (z) {
                this.thm.put(str, gVar);
            } else {
                this.thm.put(Util.notNullToString(Long.valueOf(j2)), gVar);
            }
            if (gVar.field_updateTime < this.lastUpdateTime) {
                this.lastUpdateTime = gVar.field_updateTime;
                cWm();
                for (g gVar2 : this.thi) {
                    if (Util.isNullOrNil(str)) {
                        if (gVar2.field_localId == j2) {
                            notifyDataSetChanged();
                            AppMethodBeat.o(107106);
                            return i2;
                        }
                    } else if (gVar2.field_localId == j2 && Util.isEqual(str, gVar2.dLb)) {
                        notifyDataSetChanged();
                        AppMethodBeat.o(107106);
                        return i2;
                    }
                    i2++;
                }
                notifyDataSetChanged();
            } else {
                for (g gVar3 : this.thh) {
                    if (Util.isNullOrNil(str)) {
                        if (gVar3.field_localId == j2) {
                            notifyDataSetChanged();
                            AppMethodBeat.o(107106);
                            return i2;
                        }
                    } else if (gVar3.field_localId == j2 && Util.isEqual(str, gVar3.dLb)) {
                        notifyDataSetChanged();
                        AppMethodBeat.o(107106);
                        return i2;
                    }
                    i2++;
                }
            }
            AppMethodBeat.o(107106);
            return -1;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(107107);
        b.C1049b bVar = (b.C1049b) view.getTag();
        if (bVar == null) {
            Log.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
            AppMethodBeat.o(107107);
        } else if (bVar.tbr == null) {
            Log.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
            AppMethodBeat.o(107107);
        } else if (!this.thl && !this.tht) {
            com.tencent.mm.plugin.fav.ui.d.b bVar2 = this.thq.get(bVar.tbr.field_type);
            if (bVar2 != null) {
                StringBuilder sb = new StringBuilder();
                g gVar = bVar.tbr;
                String str = gVar.field_id + "_" + (System.currentTimeMillis() / 1000);
                LinkedList<String> linkedList = gVar.field_tagProto.Lyo;
                if (!Util.isNullOrNil(linkedList)) {
                    for (String str2 : linkedList) {
                        sb.append(str2).append(";");
                    }
                }
                and and = new and();
                and.scene = this.scene;
                and.pHw = this.pHw;
                if (this.thv != null) {
                    and.index = i2 - this.thv.getHeaderViewsCount();
                } else {
                    and.index = i2;
                }
                and.query = this.query;
                and.sessionId = str;
                and.tay = sb.toString();
                bVar2.a(view, and);
                Log.d("MicroMsg.FavoriteAdapter", "item click type %s", Integer.valueOf(bVar.tbr.field_type));
            }
            AppMethodBeat.o(107107);
        } else if (bVar.jVQ.isChecked() || this.thm.size() < 30) {
            bVar.jVQ.setChecked(!bVar.jVQ.isChecked());
            AppMethodBeat.o(107107);
        } else {
            Log.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", 30);
            com.tencent.mm.ui.base.h.cD(MMApplicationContext.getContext(), MMApplicationContext.getContext().getResources().getString(R.string.ca7, 30));
            AppMethodBeat.o(107107);
        }
    }

    public final void a(View view, g gVar) {
        Context context;
        AppMethodBeat.i(107108);
        if (gVar == null) {
            Log.w("MicroMsg.FavoriteAdapter", "goFavDetail() favItemInfo is null");
            AppMethodBeat.o(107108);
        } else if (!gVar.tad || gVar.tae == null) {
            Log.w("MicroMsg.FavoriteAdapter", "goFavDetail() originInfo not exist");
            AppMethodBeat.o(107108);
        } else {
            StringBuilder sb = new StringBuilder();
            g gVar2 = gVar.tae;
            String str = gVar2.field_id + "_" + (System.currentTimeMillis() / 1000);
            LinkedList<String> linkedList = gVar2.field_tagProto.Lyo;
            if (!Util.isNullOrNil(linkedList)) {
                for (String str2 : linkedList) {
                    sb.append(str2).append(";");
                }
            }
            and and = new and();
            and.scene = this.scene;
            and.pHw = this.pHw;
            and.query = this.query;
            and.sessionId = str;
            and.tay = sb.toString();
            if (view != null) {
                context = view.getContext();
            } else {
                context = MMApplicationContext.getContext();
            }
            gVar.tae.taf = gVar.taf;
            ((y) com.tencent.mm.kernel.g.af(y.class)).a(context, gVar.tae, and);
            Log.d("MicroMsg.FavoriteAdapter", "goFavDetail type %s %s", Integer.valueOf(gVar.tae.field_type), gVar.taf, Integer.valueOf(gVar.field_type));
            AppMethodBeat.o(107108);
        }
    }
}
