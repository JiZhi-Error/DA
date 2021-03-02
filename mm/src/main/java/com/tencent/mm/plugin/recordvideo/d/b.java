package com.tencent.mm.plugin.recordvideo.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gd;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011JJ\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00112:\u0010\u0014\u001a6\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00170\u0015j\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017`\u001aR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/report/MultiMediaEditReport;", "", "()V", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;", "setStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;)V", "report", "", "reset", "setEditItemList", "editList", "", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "isAllImage", "", "setVideoLabel", "enable", "labelMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "", "Lkotlin/collections/HashMap;", "Companion", "plugin-recordvideo_release"})
public final class b {
    public static final a BXy = new a((byte) 0);
    public gd BXx = new gd();

    static {
        AppMethodBeat.i(237439);
        AppMethodBeat.o(237439);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/report/MultiMediaEditReport$Companion;", "", "()V", "ExitBack", "", "ExitNextStep", "TAG", "", "TypeImage", "", "TypeVideo", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b() {
        AppMethodBeat.i(237438);
        reset();
        AppMethodBeat.o(237438);
    }

    public final void l(List<? extends MediaEditReportInfo.EditItem> list, boolean z) {
        int i2;
        AppMethodBeat.i(237434);
        p.h(list, "editList");
        List<? extends MediaEditReportInfo.EditItem> list2 = list;
        ArrayList arrayList = new ArrayList(j.a(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().isBeauty ? 1 : 0));
        }
        String a2 = j.a(arrayList, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        List<? extends MediaEditReportInfo.EditItem> list3 = list;
        ArrayList arrayList2 = new ArrayList(j.a(list3, 10));
        Iterator<T> it2 = list3.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(z ? 0 : Util.videoMsToSec(it2.next().targetDuration)));
        }
        String a3 = j.a(arrayList2, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        List<? extends MediaEditReportInfo.EditItem> list4 = list;
        ArrayList arrayList3 = new ArrayList(j.a(list4, 10));
        Iterator<T> it3 = list4.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Integer.valueOf(z ? 0 : Util.videoMsToSec(it3.next().originDuration)));
        }
        String a4 = j.a(arrayList3, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        List<? extends MediaEditReportInfo.EditItem> list5 = list;
        ArrayList arrayList4 = new ArrayList(j.a(list5, 10));
        Iterator<T> it4 = list5.iterator();
        while (it4.hasNext()) {
            arrayList4.add(Integer.valueOf(it4.next().dragCount));
        }
        String a5 = j.a(arrayList4, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        List<? extends MediaEditReportInfo.EditItem> list6 = list;
        ArrayList arrayList5 = new ArrayList(j.a(list6, 10));
        Iterator<T> it5 = list6.iterator();
        while (it5.hasNext()) {
            arrayList5.add(Integer.valueOf(it5.next().scaleCount));
        }
        String a6 = j.a(arrayList5, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        List<? extends MediaEditReportInfo.EditItem> list7 = list;
        ArrayList arrayList6 = new ArrayList(j.a(list7, 10));
        Iterator<T> it6 = list7.iterator();
        while (it6.hasNext()) {
            arrayList6.add(Integer.valueOf(it6.next().clickEditCount));
        }
        String a7 = j.a(arrayList6, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        List<? extends MediaEditReportInfo.EditItem> list8 = list;
        ArrayList arrayList7 = new ArrayList(j.a(list8, 10));
        Iterator<T> it7 = list8.iterator();
        while (it7.hasNext()) {
            arrayList7.add(Integer.valueOf(it7.next().durationCutCount));
        }
        String a8 = j.a(arrayList7, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        List<? extends MediaEditReportInfo.EditItem> list9 = list;
        ArrayList arrayList8 = new ArrayList(j.a(list9, 10));
        Iterator<T> it8 = list9.iterator();
        while (it8.hasNext()) {
            arrayList8.add(Integer.valueOf(it8.next().durationScrollCount));
        }
        String a9 = j.a(arrayList8, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        List<? extends MediaEditReportInfo.EditItem> list10 = list;
        ArrayList arrayList9 = new ArrayList(j.a(list10, 10));
        for (T t : list10) {
            if (t.targetDuration < t.originDuration) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            arrayList9.add(Integer.valueOf(i2));
        }
        String a10 = j.a(arrayList9, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        List<? extends MediaEditReportInfo.EditItem> list11 = list;
        ArrayList arrayList10 = new ArrayList(j.a(list11, 10));
        Iterator<T> it9 = list11.iterator();
        while (it9.hasNext()) {
            arrayList10.add(Integer.valueOf(it9.next().type));
        }
        String a11 = j.a(arrayList10, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        this.BXx.tq(a2);
        this.BXx.tr(a3);
        this.BXx.ts(a4);
        this.BXx.tu(a5);
        this.BXx.tv(a6);
        this.BXx.tw(a7);
        this.BXx.tx(a8);
        this.BXx.ty(a9);
        this.BXx.tz(a10);
        this.BXx.tA(a11);
        AppMethodBeat.o(237434);
    }

    public final void a(boolean z, HashMap<String, Pair<Integer, Long>> hashMap) {
        int i2;
        AppMethodBeat.i(237435);
        p.h(hashMap, "labelMap");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("count", hashMap.size());
        StringBuffer stringBuffer = new StringBuffer();
        Collection<Pair<Integer, Long>> values = hashMap.values();
        p.g(values, "labelMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            stringBuffer.append(new StringBuilder().append((Integer) ((Pair) it.next()).first).append('#').toString());
        }
        jSONObject.put("labelList", stringBuffer);
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        jSONObject.put("enable", i2);
        gd gdVar = this.BXx;
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "json.toString()");
        gdVar.tG(n.j(jSONObject2, ",", ";", false));
        Log.i("MicroMsg.MultiMediaEditReport", "filterInfo:" + this.BXx.agL());
        AppMethodBeat.o(237435);
    }

    public final void report() {
        AppMethodBeat.i(237436);
        this.BXx.bfK();
        AppMethodBeat.o(237436);
    }

    public final void reset() {
        AppMethodBeat.i(237437);
        this.BXx = new gd();
        this.BXx.tt("");
        this.BXx.tp("");
        AppMethodBeat.o(237437);
    }
}
