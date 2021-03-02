package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.o;

public final class d {
    private static HashMap<Integer, g> uCv = new HashMap<>();
    public static final a uCw = new a((byte) 0);
    private final String TAG = ("FinderLiveDataModel@" + hashCode());
    private int uCt;
    public ArrayList<c> uCu = new ArrayList<>();
    public f ufx;

    public d() {
        AppMethodBeat.i(247884);
        AppMethodBeat.o(247884);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(247885);
        AppMethodBeat.o(247885);
    }

    public final void Jq(int i2) {
        AppMethodBeat.i(247879);
        this.uCt = i2;
        Log.i(this.TAG, "set initPos :" + this.uCt);
        AppMethodBeat.o(247879);
    }

    public final int getInitPos() {
        AppMethodBeat.i(247878);
        Log.i(this.TAG, "get initPos:" + this.uCt);
        int i2 = this.uCt;
        AppMethodBeat.o(247878);
        return i2;
    }

    public final void ad(ArrayList<c> arrayList) {
        AppMethodBeat.i(247880);
        p.h(arrayList, "<set-?>");
        this.uCu = arrayList;
        AppMethodBeat.o(247880);
    }

    public final boolean diM() {
        f fVar = this.ufx;
        if (fVar != null && fVar.dLS == 3) {
            return true;
        }
        f fVar2 = this.ufx;
        if (fVar2 != null && fVar2.dLS == 1) {
            return true;
        }
        f fVar3 = this.ufx;
        if (fVar3 != null && fVar3.dLS == 2) {
            return true;
        }
        f fVar4 = this.ufx;
        return fVar4 != null && fVar4.dLS == 1010;
    }

    public final int ee(List<c> list) {
        AppMethodBeat.i(247882);
        ArrayList<c> arrayList = this.uCu;
        LinkedList linkedList = new LinkedList();
        c cVar = c.vCb;
        boolean duP = c.duP();
        if (list != null) {
            for (T t : list) {
                Iterator<c> it = arrayList.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (it.next().a(t) == 0) {
                        break;
                    }
                    i2++;
                }
                Iterator it2 = linkedList.iterator();
                int i3 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    if (((c) it2.next()).a(t) == 0) {
                        break;
                    }
                    i3++;
                }
                if (duP || (i2 == -1 && i3 == -1)) {
                    linkedList.add(t);
                } else if (i2 != -1) {
                    Log.i(this.TAG, "[mergeLiveData] localList same feed:[" + this.uCu.get(i2) + "], just ignore this feed=" + ((Object) t) + " existIndex=" + i2 + " existIndexInIncrementList=" + i3);
                } else {
                    Log.i(this.TAG, "[mergeLiveData] newList same feed:[" + ((c) linkedList.get(i3)) + "], just ignore this feed=" + ((Object) t) + " existIndex=" + i2 + " existIndexInIncrementList=" + i3);
                }
            }
        }
        Log.i(this.TAG, "remote size:" + (list != null ? Integer.valueOf(list.size()) : null) + ",locate size:" + this.uCu.size() + ",incrementList size:" + linkedList.size() + " enable repeat(for test):" + duP);
        arrayList.addAll(linkedList);
        int size = linkedList.size();
        AppMethodBeat.o(247882);
        return size;
    }

    public final void a(FinderLiveConfig finderLiveConfig) {
        AppMethodBeat.i(247881);
        p.h(finderLiveConfig, "finderLiveConfig");
        Jq(finderLiveConfig.uis);
        int i2 = finderLiveConfig.dLS;
        int i3 = finderLiveConfig.tCE;
        int i4 = finderLiveConfig.uiy;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
        f fVar = new f();
        fVar.uDl = dHP.first.floatValue();
        fVar.iUY = dHP.second.floatValue();
        fVar.scene = 7;
        fVar.tCE = i3;
        fVar.dLS = i2;
        fVar.uiy = i4;
        this.ufx = fVar;
        ArrayList<LiveConfig> arrayList = finderLiveConfig.uiu;
        ArrayList arrayList2 = new ArrayList(j.a(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new c(it.next()));
        }
        this.uCu = new ArrayList<>(arrayList2);
        AppMethodBeat.o(247881);
    }

    public final String toString() {
        b bVar = null;
        AppMethodBeat.i(247883);
        StringBuilder append = new StringBuilder("FinderLiveDataModel(" + hashCode() + "):").append("init pos:" + getInitPos() + ';');
        StringBuilder sb = new StringBuilder("loaderParams:tab:");
        f fVar = this.ufx;
        StringBuilder append2 = sb.append(fVar != null ? Integer.valueOf(fVar.dLS) : null).append(",objectId:");
        f fVar2 = this.ufx;
        StringBuilder append3 = append2.append(fVar2 != null ? Long.valueOf(fVar2.hFK) : null).append(",lastBuf is null:");
        f fVar3 = this.ufx;
        if (fVar3 != null) {
            bVar = fVar3.tsO;
        }
        StringBuilder append4 = append.append(append3.append(bVar == null).append(';').toString());
        p.g(append4, "StringBuilder(\"FinderLiv…rams?.lastBuf == null};\")");
        int size = this.uCu.size();
        if (size <= 0) {
            append4.append("live data is empty");
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                append4.append("live_" + i2 + ':' + this.uCu.get(i2));
            }
        }
        String sb2 = append4.toString();
        p.g(sb2, "msg.toString()");
        AppMethodBeat.o(247883);
        return sb2;
    }
}
