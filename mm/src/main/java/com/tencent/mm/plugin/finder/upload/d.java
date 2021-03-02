package com.tencent.mm.plugin.finder.upload;

import android.content.Context;
import android.database.Cursor;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.voip.f;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0006J\u001e\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u0016\u0010\u001a\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker;", "", "()V", "CHECK_TIME_INTV", "", "REPORT_VERSION", "", "TAG", "", "checkList", "", "Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker$CheckInfo;", "queuedTask", "", "cameraCheck", "context", "Landroid/content/Context;", "check", "", ch.COL_LOCALID, "progress", "checkAndReport", "waitingList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "checkInfo", "printRemoveList", "removeList", "start", "CheckInfo", "plugin-finder_release"})
public final class d {
    static final String TAG = TAG;
    static boolean vSp = false;
    static final List<a> vSq = new ArrayList();
    static final long vSr = 60000;
    private static final int vSs = 1;
    public static final d vSt = new d();

    static {
        AppMethodBeat.i(253067);
        AppMethodBeat.o(253067);
    }

    private d() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderPostChecker$CheckInfo;", "", ch.COL_LOCALID, "", "progress", "", "startCheckTime", "(JIJ)V", "getLocalId", "()J", "getProgress", "()I", "setProgress", "(I)V", "getStartCheckTime", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
    public static final class a {
        final long localId;
        int progress;
        final long vSu;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.localId == aVar.localId && this.progress == aVar.progress && this.vSu == aVar.vSu)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.localId;
            long j3 = this.vSu;
            return (((((int) (j2 ^ (j2 >>> 32))) * 31) + this.progress) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }

        public final String toString() {
            AppMethodBeat.i(253064);
            String str = "CheckInfo(localId=" + this.localId + ", progress=" + this.progress + ", startCheckTime=" + this.vSu + ")";
            AppMethodBeat.o(253064);
            return str;
        }

        public a(long j2, int i2, long j3) {
            this.localId = j2;
            this.progress = i2;
            this.vSu = j3;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/upload/FinderPostChecker$start$task$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
    public static final class b implements Runnable {
        b() {
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(253065);
            synchronized (d.vSt) {
                try {
                    com.tencent.mm.plugin.finder.storage.l feedStorage = ((PluginFinder) g.ah(PluginFinder.class)).getFeedStorage();
                    ArrayList arrayList = new ArrayList();
                    Cursor rawQuery = feedStorage.db.rawQuery("SELECT * FROM FinderFeedItem  WHERE " + feedStorage.vDJ + " ORDER BY " + feedStorage.TABLE + ".localId ASC", null, 2);
                    while (rawQuery.moveToNext()) {
                        FinderItem finderItem = new FinderItem();
                        p.g(rawQuery, "cr");
                        finderItem.convertFrom(rawQuery);
                        arrayList.add(finderItem);
                    }
                    rawQuery.close();
                    ArrayList arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList();
                    d dVar = d.vSt;
                    for (a aVar : d.vSq) {
                        long j2 = aVar.localId;
                        Iterator it = arrayList2.iterator();
                        int i3 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                                break;
                            }
                            if (((FinderItem) it.next()).getLocalId() == j2) {
                                i2 = i3;
                                break;
                            }
                            i3++;
                        }
                        if (i2 < 0) {
                            arrayList3.add(aVar);
                        } else {
                            d dVar2 = d.vSt;
                            d.a(arrayList2, aVar);
                        }
                    }
                    d dVar3 = d.vSt;
                    d.ey(arrayList3);
                    d dVar4 = d.vSt;
                    d.vSq.removeAll(arrayList3);
                    d dVar5 = d.vSt;
                    if (d.vSq.isEmpty()) {
                        d dVar6 = d.vSt;
                        d.vSp = false;
                    }
                    d dVar7 = d.vSt;
                    if (d.vSp) {
                        d dVar8 = d.vSt;
                        h.RTc.o(this, d.vSr);
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(253065);
                }
            }
        }
    }

    public static boolean cameraCheck(Context context) {
        AppMethodBeat.i(253066);
        p.h(context, "context");
        if (f.hy(context) || f.cC(context) || e.cA(context) || com.tencent.mm.q.a.cD(context)) {
            Log.i(TAG, "camera check false");
            AppMethodBeat.o(253066);
            return false;
        }
        AppMethodBeat.o(253066);
        return true;
    }

    public static final /* synthetic */ void a(List list, a aVar) {
        Object obj;
        JSONObject jSONObject;
        boolean z;
        AppMethodBeat.i(253068);
        long j2 = aVar.localId;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            Object next = it.next();
            if (((FinderItem) next).getLocalId() == j2) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        FinderItem finderItem = (FinderItem) obj;
        if (finderItem != null) {
            int i2 = finderItem.getPostInfo().Mpc;
            if (aVar.progress == i2 && cl.aWy() - aVar.vSu >= vSr / 2) {
                FinderFeedReportObject finderFeedReportObject = finderItem.field_reportObject;
                ArrayList<FinderMediaReportObject> arrayList = new ArrayList();
                JSONObject jSONObject2 = new JSONObject();
                if (finderFeedReportObject != null) {
                    arrayList.addAll(finderFeedReportObject.mediaList);
                    Iterator<T> it2 = finderItem.getMediaList().iterator();
                    while (it2.hasNext()) {
                        FinderMediaReportObject finderMediaReportObject = it2.next().MoZ;
                        if (finderMediaReportObject != null) {
                            arrayList.add(finderMediaReportObject);
                        }
                    }
                    jSONObject = jSONObject2;
                    for (FinderMediaReportObject finderMediaReportObject2 : arrayList) {
                        JSONObject jSONObject3 = new JSONObject();
                        com.tencent.mm.ac.g.a(finderMediaReportObject2, jSONObject3);
                        jSONObject = jSONObject3;
                    }
                } else {
                    jSONObject = jSONObject2;
                }
                int mediaType = finderItem.getMediaType();
                int i3 = finderFeedReportObject != null ? finderFeedReportObject.postStage : -1;
                int createTime = finderItem.getCreateTime();
                long aWy = cl.aWy() - aVar.vSu;
                String jSONObject4 = jSONObject.toString();
                p.g(jSONObject4, "mediaInfoJson.toString()");
                String j3 = n.j(jSONObject4, ",", ";", false);
                i iVar = i.vSX;
                String v = i.v(finderItem);
                boolean z2 = cl.aWB() - createTime < 86400;
                int size = vSq.size();
                Log.i(TAG, "localId:" + j2 + ", mediaType:" + mediaType + ", stage:" + i3 + ", curProgress:" + i2 + ", costTime:" + aWy + ", uniqId:" + v + ", in24h:" + z2 + ", curCheckCount:" + size + ", mediaInfoJsonStr:" + j3);
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(20782, j2 + ',' + mediaType + ',' + i3 + ',' + i2 + ',' + aWy + ',' + j3 + ',' + v + ',' + createTime + ',' + (z2 ? 1 : 0) + ',' + size + ',' + vSs);
            }
            Log.i(TAG, "localId:" + j2 + ", curProgress:" + i2 + ", costTime:" + (cl.aWy() - aVar.vSu));
            aVar.progress = i2;
            AppMethodBeat.o(253068);
            return;
        }
        AppMethodBeat.o(253068);
    }

    public static final /* synthetic */ void ey(List list) {
        AppMethodBeat.i(253069);
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder("remove: ");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                sb.append("{localId:" + aVar.localId + ", startCheckTime:" + aVar.vSu + "} ");
            }
            Log.i(TAG, sb.toString());
        }
        AppMethodBeat.o(253069);
    }
}
