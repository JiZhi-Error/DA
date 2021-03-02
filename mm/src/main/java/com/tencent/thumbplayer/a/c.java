package com.tencent.thumbplayer.a;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.e;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.utils.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c {
    public boolean RVA;
    public float RVB;
    String RVC;
    public float RVD;
    public Map<Integer, TPTrackInfo> RVE = new HashMap(0);
    ArrayList<TPTrackInfo> RVF = new ArrayList<>();
    TPProgramInfo RVG;
    public Object RVt;
    Map<String, d> RVu = new HashMap(0);
    Map<String, a> RVv = new HashMap(0);
    ArrayList<C2203c> RVw = new ArrayList<>();
    private Map<Integer, TPOptionalParam> RVx = new HashMap(0);
    public f RVy = new f();
    public b RVz;
    int trackId = -1;

    public static class a {
        public List<TPOptionalParam> RVH;
        public String name;
        public String url;
    }

    public static class b {
        public boolean RVI;
        public long RVJ;
        public long startPositionMs;
    }

    /* renamed from: com.tencent.thumbplayer.a.c$c  reason: collision with other inner class name */
    public static class C2203c {
        public long RVK;
        public TPTrackInfo RVL;
        public int trackIndex;
    }

    public static class d {
        public String mimeType;
        public String name;
        public String url;
    }

    public c() {
        AppMethodBeat.i(188603);
        AppMethodBeat.o(188603);
    }

    public final void reset() {
        AppMethodBeat.i(188604);
        this.RVu.clear();
        this.RVv.clear();
        this.RVA = false;
        this.RVB = 1.0f;
        this.RVC = "";
        this.RVD = 1.0f;
        this.RVE.clear();
        this.RVt = null;
        this.RVx.clear();
        this.RVy = new f();
        this.RVz = null;
        this.RVG = null;
        this.trackId = -1;
        this.RVF.clear();
        this.RVw.clear();
        AppMethodBeat.o(188604);
    }

    public final void a(TPOptionalParam tPOptionalParam) {
        AppMethodBeat.i(188605);
        if (tPOptionalParam != null) {
            this.RVx.put(Integer.valueOf(tPOptionalParam.getKey()), tPOptionalParam);
        }
        AppMethodBeat.o(188605);
    }

    public final void setLoopback(boolean z) {
        AppMethodBeat.i(188606);
        if (this.RVz == null) {
            this.RVz = new b();
        }
        this.RVz.RVI = z;
        this.RVz.startPositionMs = 0;
        this.RVz.RVJ = -1;
        AppMethodBeat.o(188606);
    }

    public final void setLoopback(boolean z, long j2, long j3) {
        AppMethodBeat.i(188607);
        if (this.RVz == null) {
            this.RVz = new b();
        }
        this.RVz.RVI = z;
        this.RVz.startPositionMs = j2;
        this.RVz.RVJ = j3;
        AppMethodBeat.o(188607);
    }

    public final void setDataSource(String str) {
        AppMethodBeat.i(188608);
        this.RVy.setUrl(str);
        AppMethodBeat.o(188608);
    }

    public final void setDataSource(String str, Map<String, String> map) {
        AppMethodBeat.i(188609);
        this.RVy.setUrl(str);
        this.RVy.cn(map);
        AppMethodBeat.o(188609);
    }

    public final void a(e eVar, Map<String, String> map) {
        AppMethodBeat.i(188610);
        f fVar = this.RVy;
        fVar.mUrl = null;
        fVar.mType = 3;
        fVar.RWn = null;
        fVar.RWq = eVar;
        this.RVy.cn(map);
        AppMethodBeat.o(188610);
    }

    public final void setDataSource(ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(188611);
        f fVar = this.RVy;
        fVar.mUrl = null;
        fVar.mType = 1;
        fVar.RWo.clear();
        fVar.RWn = parcelFileDescriptor;
        AppMethodBeat.o(188611);
    }

    public final void setDataSource(ITPMediaAsset iTPMediaAsset) {
        AppMethodBeat.i(188612);
        f fVar = this.RVy;
        fVar.mUrl = null;
        fVar.mType = 2;
        fVar.RWo.clear();
        fVar.RWn = null;
        fVar.RWp = iTPMediaAsset;
        AppMethodBeat.o(188612);
    }

    public final void a(int i2, long j2, TPTrackInfo tPTrackInfo) {
        AppMethodBeat.i(188613);
        this.RVE.put(Integer.valueOf(tPTrackInfo.getTrackType()), tPTrackInfo);
        if (i2 < 0 || i2 >= this.RVF.size()) {
            g.w("TPPlaybackParams", "track Index:" + i2 + " is invalid, trackInfoList size:" + this.RVF.size());
            AppMethodBeat.o(188613);
            return;
        }
        C2203c cVar = new C2203c();
        cVar.trackIndex = i2;
        cVar.RVK = j2;
        Iterator<TPTrackInfo> it = this.RVF.iterator();
        while (it.hasNext()) {
            TPTrackInfo next = it.next();
            if (next.trackType == tPTrackInfo.trackType) {
                if ((!TextUtils.isEmpty(next.name) || !TextUtils.isEmpty(tPTrackInfo.name)) && !next.name.equals(tPTrackInfo.name)) {
                    next.isSelected = false;
                } else {
                    next.isSelected = true;
                    cVar.RVL = next;
                }
            }
        }
        this.RVw.add(cVar);
        AppMethodBeat.o(188613);
    }

    public final void a(int i2, TPTrackInfo tPTrackInfo) {
        TPTrackInfo next;
        AppMethodBeat.i(188614);
        this.RVE.remove(Integer.valueOf(tPTrackInfo.getTrackType()));
        if (i2 < 0 || i2 >= this.RVF.size()) {
            g.w("TPPlaybackParams", "track Index:" + i2 + " is invalid, trackInfoList size:" + this.RVF.size());
            AppMethodBeat.o(188614);
            return;
        }
        Iterator<TPTrackInfo> it = this.RVF.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            next = it.next();
            if (next.trackType != tPTrackInfo.trackType || ((!TextUtils.isEmpty(next.name) || !TextUtils.isEmpty(tPTrackInfo.name)) && !next.name.equals(tPTrackInfo.name))) {
            }
        }
        next.isSelected = false;
        Iterator<C2203c> it2 = this.RVw.iterator();
        while (it2.hasNext()) {
            C2203c next2 = it2.next();
            if (next2.RVL != null && next2.RVL.equals(tPTrackInfo)) {
                this.RVw.remove(next2);
                AppMethodBeat.o(188614);
                return;
            }
        }
        AppMethodBeat.o(188614);
    }

    public final boolean hmL() {
        boolean z;
        AppMethodBeat.i(188615);
        if (this.RVy != null) {
            f fVar = this.RVy;
            if (TextUtils.isEmpty(fVar.mUrl) && fVar.RWn == null && fVar.RWp == null && fVar.RWq == null) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                AppMethodBeat.o(188615);
                return true;
            }
        }
        AppMethodBeat.o(188615);
        return false;
    }

    public final List<d> hmM() {
        AppMethodBeat.i(188616);
        ArrayList arrayList = new ArrayList(this.RVu.size());
        for (Map.Entry<String, d> entry : this.RVu.entrySet()) {
            arrayList.add(entry.getValue());
        }
        AppMethodBeat.o(188616);
        return arrayList;
    }

    public final List<a> hmN() {
        AppMethodBeat.i(188617);
        ArrayList arrayList = new ArrayList(this.RVv.size());
        for (Map.Entry<String, a> entry : this.RVv.entrySet()) {
            arrayList.add(entry.getValue());
        }
        AppMethodBeat.o(188617);
        return arrayList;
    }

    public final List<TPOptionalParam> hmO() {
        AppMethodBeat.i(188618);
        ArrayList arrayList = new ArrayList(this.RVx.size());
        for (Map.Entry<Integer, TPOptionalParam> entry : this.RVx.entrySet()) {
            arrayList.add(entry.getValue());
        }
        AppMethodBeat.o(188618);
        return arrayList;
    }

    public final TPOptionalParam aqR(int i2) {
        AppMethodBeat.i(188619);
        TPOptionalParam tPOptionalParam = this.RVx.get(Integer.valueOf(i2));
        AppMethodBeat.o(188619);
        return tPOptionalParam;
    }
}
