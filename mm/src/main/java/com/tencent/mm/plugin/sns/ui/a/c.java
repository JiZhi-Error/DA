package com.tencent.mm.plugin.sns.ui.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.a.b.b;
import com.tencent.mm.plugin.sns.ui.aa;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c extends BaseAdapter implements aa {
    private static HashMap<Long, a> ESs = new HashMap<>();
    private static boolean ESt = false;
    private static int pmM = 2;
    private Vending.d ELF = new Vending.d() {
        /* class com.tencent.mm.plugin.sns.ui.a.c.AnonymousClass1 */

        @Override // com.tencent.mm.vending.base.Vending.d
        public final void fjn() {
            AppMethodBeat.i(99813);
            if (!c.this.ESr) {
                c.this.notifyDataSetChanged();
                EventCenter.instance.publish(new bs());
            }
            AppMethodBeat.o(99813);
        }
    };
    public bk ESp;
    public b ESq;
    public boolean ESr;
    private boolean mLoaded = false;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(99830);
        SnsInfo Zv = Zv(i2);
        AppMethodBeat.o(99830);
        return Zv;
    }

    public c(MMActivity mMActivity, ListView listView, com.tencent.mm.plugin.sns.ui.d.c cVar, i iVar, String str, b bVar, Vending.d dVar) {
        AppMethodBeat.i(179319);
        this.ESp = new bk(mMActivity, listView, cVar, iVar, this);
        this.ESp.EAv = true;
        this.ESq = bVar == null ? new com.tencent.mm.plugin.sns.ui.a.b.c() : bVar;
        this.ESq.a(mMActivity, this.ESp, str);
        b bVar2 = this.ESq;
        com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", 10);
        bVar2.QZi = 10;
        this.ESq.addVendingDataChangedCallback(dVar);
        AppMethodBeat.o(179319);
    }

    public final void vC() {
        AppMethodBeat.i(99819);
        if (this.mLoaded) {
            AppMethodBeat.o(99819);
            return;
        }
        this.mLoaded = true;
        this.ESq.notifyVendingDataChangeSynchronize();
        AppMethodBeat.o(99819);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(99820);
        View o = this.ESp.o(i2, view);
        AppMethodBeat.o(99820);
        return o;
    }

    public final int getViewTypeCount() {
        return 26;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(99821);
        int itemViewType = this.ESp.getItemViewType(i2);
        AppMethodBeat.o(99821);
        return itemViewType;
    }

    @Override // com.tencent.mm.plugin.sns.ui.aa
    public final void ffM() {
        AppMethodBeat.i(259463);
        this.ESq.notifyVendingDataChange();
        AppMethodBeat.o(259463);
    }

    @Override // com.tencent.mm.plugin.sns.ui.aa
    public final SnsInfo Zv(int i2) {
        AppMethodBeat.i(99823);
        bl blVar = (bl) this.ESq.get(i2);
        if (blVar == null) {
            AppMethodBeat.o(99823);
            return null;
        }
        SnsInfo snsInfo = blVar.DqO;
        AppMethodBeat.o(99823);
        return snsInfo;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    @Override // com.tencent.mm.plugin.sns.ui.aa
    public final int getCount() {
        return ((com.tencent.mm.vending.base.b) this.ESq).mCount;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        HashSet<Integer> ESA;
        int ESB;
        long ESC;
        int ESD;
        int ESE;
        int ESF;
        HashSet<Integer> ESx;
        HashSet<Integer> ESy;
        HashSet<Integer> ESz;
        int iAC;
        String id;
        int networkType;
        int wZj;

        a() {
        }
    }

    static {
        AppMethodBeat.i(99831);
        AppMethodBeat.o(99831);
    }

    public static void Z(final SnsInfo snsInfo) {
        AppMethodBeat.i(99824);
        aj.eJP().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.a.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(99814);
                if (snsInfo != null) {
                    long j2 = snsInfo.field_snsId;
                    if (!c.ESs.containsKey(Long.valueOf(j2))) {
                        a aVar = new a();
                        if (!(snsInfo.getTimeLine() == null || snsInfo.getTimeLine().ContentObj == null || snsInfo.getTimeLine().ContentObj.LoU != 1 || snsInfo.getTimeLine().ContentObj.LoV == null || snsInfo.getTimeLine().ContentObj.LoV.size() <= 0)) {
                            aVar.iAC = snsInfo.getTimeLine().ContentObj.LoV.size();
                            aVar.ESx = new HashSet<>();
                            aVar.ESy = new HashSet<>();
                            aVar.ESz = new HashSet<>();
                            aVar.ESA = new HashSet<>();
                            aVar.id = snsInfo.getTimeLine().Id;
                            aVar.ESF = snsInfo.getTimeLine().showFlag;
                            try {
                                SnsObject C = an.C(snsInfo);
                                aVar.ESD = C.LikeCount;
                                aVar.ESE = C.CommentCount;
                            } catch (Exception e2) {
                                aVar.ESD = 0;
                                aVar.ESE = 0;
                            }
                            try {
                                g.aAi();
                                aVar.wZj = ((l) g.af(l.class)).eiy().aEM(snsInfo.getUserName());
                                long currentTimeMillis = System.currentTimeMillis();
                                g.aAi();
                                aVar.ESC = (currentTimeMillis - ((l) g.af(l.class)).eiy().aEQ(snsInfo.getUserName())) / 1000;
                            } catch (Exception e3) {
                                aVar.wZj = 0;
                                aVar.ESC = 0;
                            }
                            c.ESs.put(Long.valueOf(j2), aVar);
                        }
                    }
                }
                AppMethodBeat.o(99814);
            }
        });
        AppMethodBeat.o(99824);
    }

    public static void g(final SnsInfo snsInfo, final int i2) {
        AppMethodBeat.i(99825);
        aj.eJP().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.a.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(99815);
                if (snsInfo != null) {
                    long j2 = snsInfo.field_snsId;
                    if (c.ESs.containsKey(Long.valueOf(j2))) {
                        a aVar = (a) c.ESs.get(Long.valueOf(j2));
                        if (aVar.ESB == 0) {
                            aVar.ESB = i2 + 1;
                        }
                        if (aVar.ESx == null) {
                            aVar.ESx = new HashSet<>();
                        }
                        aVar.ESx.add(Integer.valueOf(i2 + 1));
                    }
                }
                AppMethodBeat.o(99815);
            }
        });
        AppMethodBeat.o(99825);
    }

    public static void h(final SnsInfo snsInfo, final int i2) {
        AppMethodBeat.i(99826);
        aj.eJP().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.a.c.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(99816);
                if (snsInfo != null) {
                    long j2 = snsInfo.field_snsId;
                    if (c.ESs.containsKey(Long.valueOf(j2))) {
                        a aVar = (a) c.ESs.get(Long.valueOf(j2));
                        if (aVar.ESy == null) {
                            aVar.ESy = new HashSet<>();
                        }
                        if (!aVar.ESy.contains(Integer.valueOf(i2 + 1))) {
                            aVar.ESy.add(Integer.valueOf(i2 + 1));
                        }
                    }
                }
                AppMethodBeat.o(99816);
            }
        });
        AppMethodBeat.o(99826);
    }

    public static void fkb() {
        AppMethodBeat.i(99827);
        aj.eJP().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.a.c.AnonymousClass5 */

            public final void run() {
                String str;
                String str2;
                String str3;
                AppMethodBeat.i(99817);
                for (Map.Entry entry : c.ESs.entrySet()) {
                    a aVar = (a) entry.getValue();
                    aVar.networkType = r.eZw();
                    Log.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", Integer.valueOf(aVar.iAC), Integer.valueOf(aVar.ESx.size()), Integer.valueOf(aVar.ESB), Integer.valueOf(aVar.networkType), aVar.id);
                    String str4 = "";
                    Iterator<Integer> it = aVar.ESy.iterator();
                    while (true) {
                        str = str4;
                        if (!it.hasNext()) {
                            break;
                        }
                        str4 = str + it.next() + "|";
                    }
                    if (str.length() >= 2) {
                        str = str.substring(0, str.length() - 1);
                    }
                    String str5 = "";
                    Iterator<Integer> it2 = aVar.ESz.iterator();
                    while (true) {
                        str2 = str5;
                        if (!it2.hasNext()) {
                            break;
                        }
                        str5 = str2 + it2.next() + "|";
                    }
                    if (str2.length() >= 2) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                    String str6 = "";
                    Iterator<Integer> it3 = aVar.ESA.iterator();
                    while (true) {
                        str3 = str6;
                        if (!it3.hasNext()) {
                            break;
                        }
                        str6 = str3 + it3.next() + "|";
                    }
                    if (str3.length() >= 2) {
                        str3 = str3.substring(0, str3.length() - 1);
                    }
                    h.INSTANCE.a(11599, Integer.valueOf(aVar.iAC), Integer.valueOf(aVar.ESx.size()), Integer.valueOf(aVar.ESB), Integer.valueOf(aVar.networkType), 0, aVar.id, Long.valueOf(aVar.ESC), Integer.valueOf(aVar.wZj), 0, 0, Integer.valueOf(aVar.ESD), Integer.valueOf(aVar.ESE), 0, str, str2, str3, 0, "", Integer.valueOf(aVar.ESF));
                }
                c.ESs.clear();
                AppMethodBeat.o(99817);
            }
        });
        AppMethodBeat.o(99827);
    }

    public static void f(TimeLineObject timeLineObject) {
        AppMethodBeat.i(99828);
        if (timeLineObject.ContentObj == null || TextUtils.isEmpty(timeLineObject.ContentObj.Url)) {
            AppMethodBeat.o(99828);
            return;
        }
        ((e) g.af(e.class)).a(timeLineObject.ContentObj.Url, pmM, timeLineObject.AppInfo != null ? timeLineObject.AppInfo.Id : "", timeLineObject.ContentObj.Title, timeLineObject.ContentObj.Desc, "timeline", 1);
        AppMethodBeat.o(99828);
    }

    public static void g(TimeLineObject timeLineObject) {
        int i2;
        AppMethodBeat.i(99829);
        if (TextUtils.isEmpty(timeLineObject.ContentObj.Url) || !timeLineObject.ContentObj.Url.contains(WeChatHosts.domainString(R.string.e20))) {
            AppMethodBeat.o(99829);
            return;
        }
        if (timeLineObject.ContentObj.LoY != null) {
            i2 = timeLineObject.ContentObj.LoY.iAb;
        } else {
            i2 = -1;
        }
        ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(timeLineObject.ContentObj.Url, i2, pmM, timeLineObject.Id, null, null, timeLineObject.UserName, Integer.valueOf(timeLineObject.CreateTime), Long.valueOf(((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahy("__sns_timeline__")));
        if (!ESt && i2 != -1 && ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(24)) {
            ESt = true;
            ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CS(pmM);
        }
        if (i2 == 5 && ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld() && timeLineObject.ContentObj.LoY != null && !Util.isNullOrNil(timeLineObject.ContentObj.LoY.coverUrl)) {
            String u = com.tencent.mm.api.b.u(timeLineObject.ContentObj.LoY.coverUrl, 4);
            String bdu = s.bdu(u);
            if (!com.tencent.mm.vfs.s.YS(bdu)) {
                c.a aVar = new c.a();
                aVar.jbf = true;
                aVar.fullPath = bdu;
                q.bcV().a(u, aVar.bdv(), (d) null);
            }
        }
        AppMethodBeat.o(99829);
    }

    public final void iS(int i2, int i3) {
        TimeLineObject timeLine;
        AppMethodBeat.i(160747);
        if (i3 < i2) {
            AppMethodBeat.o(160747);
            return;
        }
        LinkedList linkedList = new LinkedList();
        while (i2 <= i3) {
            SnsInfo Zv = Zv(i2 - 1);
            if (!(Zv == null || (timeLine = Zv.getTimeLine()) == null || timeLine.ContentObj == null || TextUtils.isEmpty(timeLine.ContentObj.Url))) {
                e.a aVar = new e.a();
                aVar.url = timeLine.ContentObj.Url;
                aVar.pmM = pmM;
                aVar.appId = timeLine.AppInfo != null ? timeLine.AppInfo.Id : "";
                aVar.title = timeLine.ContentObj.Title;
                aVar.desc = timeLine.ContentObj.Desc;
                aVar.from = "timeline";
                linkedList.add(aVar);
            }
            i2++;
        }
        e eVar = (e) g.af(e.class);
        if (eVar != null && linkedList.size() > 0) {
            Log.v("MicroMsg.SnsTimeLineVendingAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", Integer.valueOf(linkedList.size()));
            eVar.m(linkedList, 1);
        }
        AppMethodBeat.o(160747);
    }

    public final long fkc() {
        long j2;
        AppMethodBeat.i(203863);
        int i2 = 0;
        int count = getCount() - 1;
        while (true) {
            SnsInfo Zv = Zv(count);
            if (Zv == null && !Zv.isSourceExist(32) && Zv.field_snsId != 0) {
                j2 = Zv.field_snsId;
                break;
            }
            i2++;
            count--;
            if (count < 0 || i2 > 500) {
                j2 = 0;
            }
            SnsInfo Zv2 = Zv(count);
            if (Zv2 == null) {
            }
            i2++;
            count--;
            break;
        }
        j2 = 0;
        AppMethodBeat.o(203863);
        return j2;
    }

    public final long vC(boolean z) {
        long j2;
        int i2 = 0;
        AppMethodBeat.i(179321);
        int i3 = 0;
        while (true) {
            SnsInfo Zv = Zv(i3);
            if (!z) {
                if (!(Zv == null || Zv.isSourceExist(32) || Zv.field_snsId == 0)) {
                    j2 = Zv.field_snsId;
                    break;
                }
                i2++;
                i3++;
                if (i3 >= getCount()) {
                    break;
                }
                break;
            }
            if (!(Zv == null || Zv.field_snsId == 0)) {
                j2 = Zv.field_snsId;
                break;
            }
            i2++;
            i3++;
            if (i3 >= getCount() || i2 > 500) {
                j2 = 0;
            }
        }
        j2 = 0;
        AppMethodBeat.o(179321);
        return j2;
    }

    @Override // com.tencent.mm.plugin.sns.ui.aa
    public final bl Zw(int i2) {
        AppMethodBeat.i(203862);
        bl blVar = (bl) this.ESq.get(i2);
        AppMethodBeat.o(203862);
        return blVar;
    }

    @Override // com.tencent.mm.plugin.sns.ui.aa
    public final /* bridge */ /* synthetic */ Vending ffN() {
        return this.ESq;
    }
}
