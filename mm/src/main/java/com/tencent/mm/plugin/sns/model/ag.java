package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.j.d;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.j.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class ag {
    private d DJX;
    private List<Integer> DJY = new Vector();
    private Map<String, Integer> DJZ = new HashMap();
    private List<Integer> DKa = new Vector();
    private Map<Integer, Integer> DKb = new HashMap();
    String gna = "";
    private String path;

    public static boolean aPg(String str) {
        AppMethodBeat.i(95721);
        if (str == null) {
            AppMethodBeat.o(95721);
            return false;
        } else if (str.startsWith("_AD_TAG_")) {
            AppMethodBeat.o(95721);
            return true;
        } else {
            AppMethodBeat.o(95721);
            return false;
        }
    }

    public ag(String str) {
        AppMethodBeat.i(95722);
        this.path = str;
        if (!fap()) {
            this.DJX = new d();
        }
        this.DJY.clear();
        this.DJZ.clear();
        AppMethodBeat.o(95722);
    }

    public final synchronized void fan() {
        AppMethodBeat.i(95723);
        if (!bp(this.DJX.DRL)) {
            if (!bp(this.DJX.DRM)) {
                if (!bp(this.DJX.DRN)) {
                    if (!bp(this.DJX.DRO)) {
                        while (true) {
                            if (this.DJX.DRP.isEmpty()) {
                                while (true) {
                                    if (this.DJX.DRQ.isEmpty()) {
                                        AppMethodBeat.o(95723);
                                        break;
                                    }
                                    f first = this.DJX.DRQ.getFirst();
                                    if (Util.secondsToNow((long) first.DRS) <= 21600) {
                                        long j2 = first.DRU;
                                        g.aAi();
                                        g.aAg().hqi.a(new s(j2, 5), 0);
                                        AppMethodBeat.o(95723);
                                        break;
                                    }
                                    this.DJX.DRQ.removeFirst();
                                }
                            } else {
                                f first2 = this.DJX.DRP.getFirst();
                                if (Util.secondsToNow((long) first2.DRS) <= 21600) {
                                    long j3 = first2.DRU;
                                    g.aAi();
                                    g.aAg().hqi.a(new s(j3, 1), 0);
                                    AppMethodBeat.o(95723);
                                    break;
                                }
                                this.DJX.DRP.removeFirst();
                            }
                        }
                    } else {
                        AppMethodBeat.o(95723);
                    }
                } else {
                    AppMethodBeat.o(95723);
                }
            } else {
                AppMethodBeat.o(95723);
            }
        } else {
            AppMethodBeat.o(95723);
        }
    }

    private static boolean bp(LinkedList<e> linkedList) {
        AppMethodBeat.i(95724);
        while (!linkedList.isEmpty()) {
            e first = linkedList.getFirst();
            if (Util.secondsToNow((long) first.DRS) > 21600) {
                linkedList.removeFirst();
            } else {
                if (aPg(first.DRR)) {
                    g.aAi();
                    g.aAg().hqi.a(new k(first.DIb, first.DRR, first.DRT, 0), 0);
                } else {
                    g.aAi();
                    g.aAg().hqi.a(new p(first.DIb, first.DRR), 0);
                }
                AppMethodBeat.o(95724);
                return true;
            }
        }
        AppMethodBeat.o(95724);
        return false;
    }

    public final synchronized boolean Jq(long j2) {
        boolean z;
        AppMethodBeat.i(95725);
        Iterator<f> it = this.DJX.DRP.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().DRU == j2) {
                    z = false;
                    AppMethodBeat.o(95725);
                    break;
                }
            } else {
                z = true;
                AppMethodBeat.o(95725);
                break;
            }
        }
        return z;
    }

    public final synchronized void Jr(long j2) {
        AppMethodBeat.i(95726);
        f fVar = new f();
        fVar.DRU = j2;
        fVar.DRS = (int) Util.nowSecond();
        this.DJX.DRP.add(fVar);
        fao();
        AppMethodBeat.o(95726);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void Js(long j2) {
        f fVar;
        AppMethodBeat.i(95727);
        Iterator<f> it = this.DJX.DRP.iterator();
        while (true) {
            if (!it.hasNext()) {
                fVar = null;
                break;
            }
            fVar = it.next();
            if (fVar.DRU == j2) {
                break;
            }
        }
        if (fVar != null) {
            this.DJX.DRP.remove(fVar);
        }
        fao();
        AppMethodBeat.o(95727);
    }

    private static boolean a(LinkedList<dzo> linkedList, String str, int i2) {
        AppMethodBeat.i(95728);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(95728);
            return true;
        }
        Iterator<dzo> it = linkedList.iterator();
        while (it.hasNext()) {
            dzo next = it.next();
            if (str.equals(next.iAc) && i2 == next.CreateTime) {
                AppMethodBeat.o(95728);
                return true;
            }
        }
        AppMethodBeat.o(95728);
        return false;
    }

    public final synchronized SnsObject d(SnsObject snsObject) {
        boolean z;
        AppMethodBeat.i(95729);
        if (Util.isNullOrNil(this.gna)) {
            this.gna = z.aTY();
        }
        if (this.DJX.DRL.size() == 0 && this.DJX.DRM.size() == 0) {
            AppMethodBeat.o(95729);
        } else {
            long j2 = snsObject.Id;
            Iterator<e> it = this.DJX.DRL.iterator();
            while (it.hasNext()) {
                e next = it.next();
                dzo b2 = b(next.DIb);
                if (next.DIb.Id == j2 && !a(snsObject.LikeUserList, b2.iAc, b2.CreateTime)) {
                    snsObject.LikeUserList.add(b2);
                    snsObject.LikeCount++;
                }
            }
            Iterator<dzo> it2 = snsObject.LikeUserList.iterator();
            while (it2.hasNext()) {
                dzo next2 = it2.next();
                if (next2.Username.equals(this.gna)) {
                    boolean z2 = false;
                    Iterator<f> it3 = this.DJX.DRQ.iterator();
                    while (it3.hasNext()) {
                        if (it3.next().DRU == j2) {
                            snsObject.LikeUserList.remove(next2);
                            snsObject.LikeCount--;
                            z = true;
                        } else {
                            z = z2;
                        }
                        z2 = z;
                    }
                    if (z2) {
                        break;
                    }
                }
            }
            Iterator<e> it4 = this.DJX.DRM.iterator();
            while (it4.hasNext()) {
                e next3 = it4.next();
                if (next3.DIb.Id == j2) {
                    dzo b3 = b(next3.DIb);
                    if (!a(snsObject.CommentUserList, b3.iAc, b3.CreateTime)) {
                        snsObject.CommentUserList.add(b3);
                        snsObject.CommentCount++;
                    }
                }
            }
            AppMethodBeat.o(95729);
        }
        return snsObject;
    }

    public static dzo b(dzj dzj) {
        AppMethodBeat.i(95730);
        dzi dzi = dzj.MZb;
        dzi dzi2 = dzj.MZc;
        dzo dzo = new dzo();
        dzo.iAc = dzi.iAc;
        dzo.CreateTime = dzi.CreateTime;
        dzo.Nickname = dzi.MYQ;
        dzo.xub = dzi.xub;
        dzo.oUv = dzi.oUv;
        dzo.Username = dzi.MKC;
        dzo.MYT = dzi.MYT;
        dzo.MYV = dzi.MYV;
        dzo.MYX = dzi.MYX;
        dzo.MZm = dzi2.MKC;
        dzo.MYU = dzi2.MYU;
        dzo.MYS = dzi2.MYS;
        dzo.MYY = dzi.MYY;
        dzo.MYZ = dzi.MYZ;
        AppMethodBeat.o(95730);
        return dzo;
    }

    public final boolean a(String str, dzj dzj) {
        AppMethodBeat.i(95731);
        boolean a2 = a(str, dzj, "");
        AppMethodBeat.o(95731);
        return a2;
    }

    public final synchronized boolean a(String str, dzj dzj, String str2) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(95732);
            e eVar = new e();
            eVar.DRR = str;
            eVar.DIb = dzj;
            eVar.DRS = (int) Util.nowSecond();
            eVar.DRT = str2;
            switch (dzj.MZb.oUv) {
                case 1:
                    this.DJX.DRL.add(eVar);
                    if (Ju(dzj.Id)) {
                        z = false;
                        break;
                    }
                    break;
                case 2:
                    this.DJX.DRM.add(eVar);
                    break;
                case 3:
                    this.DJX.DRN.add(eVar);
                    break;
                case 5:
                    this.DJX.DRO.add(eVar);
                    break;
                case 7:
                    this.DJX.DRL.add(eVar);
                    if (Ju(dzj.Id)) {
                        z = false;
                        break;
                    }
                    break;
                case 8:
                case 16:
                    this.DJX.DRM.add(eVar);
                    break;
            }
            if (!fao()) {
                Log.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
            }
            AppMethodBeat.o(95732);
        }
        return z;
    }

    public final void i(long j2, int i2, String str) {
        AppMethodBeat.i(95733);
        an.fbo();
        j(j2, i2, str);
        AppMethodBeat.o(95733);
    }

    private synchronized void j(long j2, int i2, String str) {
        AppMethodBeat.i(95734);
        switch (i2) {
            case 1:
                a(j2, this.DJX.DRL, str);
                break;
            case 2:
                a(j2, this.DJX.DRM, str);
                break;
            case 3:
                a(j2, this.DJX.DRN, str);
                break;
            case 5:
                a(j2, this.DJX.DRO, str);
                break;
            case 7:
                a(j2, this.DJX.DRL, str);
                break;
            case 8:
            case 16:
                a(j2, this.DJX.DRM, str);
                break;
        }
        fao();
        AppMethodBeat.o(95734);
    }

    private static void a(long j2, LinkedList<e> linkedList, String str) {
        AppMethodBeat.i(95735);
        a(j2, linkedList, str, false);
        AppMethodBeat.o(95735);
    }

    private static boolean a(long j2, LinkedList<e> linkedList, String str, boolean z) {
        e eVar;
        AppMethodBeat.i(95736);
        Iterator<e> it = linkedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                eVar = null;
                break;
            }
            eVar = it.next();
            if (eVar.DIb.Id == j2 && (z || eVar.DRR.equals(str))) {
                break;
            }
        }
        if (eVar != null) {
            linkedList.remove(eVar);
            AppMethodBeat.o(95736);
            return true;
        }
        AppMethodBeat.o(95736);
        return false;
    }

    public final synchronized boolean Jt(long j2) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(95737);
            f fVar = new f();
            fVar.DRU = j2;
            fVar.DRS = (int) Util.nowSecond();
            this.DJX.DRQ.add(fVar);
            fao();
            if (!a(j2, this.DJX.DRL, "", true)) {
                AppMethodBeat.o(95737);
            } else {
                z = false;
                AppMethodBeat.o(95737);
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean Ju(long j2) {
        f fVar;
        boolean z;
        AppMethodBeat.i(95738);
        Iterator<f> it = this.DJX.DRQ.iterator();
        while (true) {
            if (!it.hasNext()) {
                fVar = null;
                break;
            }
            fVar = it.next();
            if (fVar.DRU == j2) {
                break;
            }
        }
        if (fVar != null) {
            this.DJX.DRQ.remove(fVar);
            z = true;
        } else {
            z = false;
        }
        fao();
        AppMethodBeat.o(95738);
        return z;
    }

    private synchronized boolean fao() {
        boolean z;
        AppMethodBeat.i(95739);
        try {
            byte[] byteArray = this.DJX.toByteArray();
            if (s.f(this.path, byteArray, byteArray.length) == 0) {
                z = true;
                AppMethodBeat.o(95739);
            } else {
                AppMethodBeat.o(95739);
                z = false;
            }
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e2, "listToFile failed: " + this.path, new Object[0]);
            s.deleteFile(this.path);
            AppMethodBeat.o(95739);
            z = false;
        }
        return z;
    }

    private synchronized boolean fap() {
        boolean z;
        AppMethodBeat.i(95740);
        byte[] aW = s.aW(this.path, 0, -1);
        if (aW == null) {
            AppMethodBeat.o(95740);
            z = false;
        } else {
            try {
                this.DJX = (d) new d().parseFrom(aW);
                z = true;
                AppMethodBeat.o(95740);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e2, "", new Object[0]);
                s.deleteFile(this.path);
                AppMethodBeat.o(95740);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean Yt(int i2) {
        boolean contains;
        AppMethodBeat.i(95741);
        contains = this.DJY.contains(Integer.valueOf(i2));
        AppMethodBeat.o(95741);
        return contains;
    }

    public final synchronized boolean Yu(int i2) {
        boolean z;
        AppMethodBeat.i(95742);
        if (this.DJY.contains(Integer.valueOf(i2))) {
            z = false;
            AppMethodBeat.o(95742);
        } else {
            this.DJY.add(Integer.valueOf(i2));
            z = true;
            AppMethodBeat.o(95742);
        }
        return z;
    }

    public final synchronized boolean Yv(int i2) {
        AppMethodBeat.i(95743);
        this.DJY.remove(Integer.valueOf(i2));
        AppMethodBeat.o(95743);
        return true;
    }

    public final synchronized boolean isDownloading(String str) {
        boolean containsKey;
        AppMethodBeat.i(95744);
        containsKey = this.DJZ.containsKey(str);
        AppMethodBeat.o(95744);
        return containsKey;
    }

    public final synchronized boolean aPh(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(95745);
            if (this.DJZ.containsKey(str)) {
                AppMethodBeat.o(95745);
            } else {
                this.DJZ.put(str, 0);
                z = true;
                AppMethodBeat.o(95745);
            }
        }
        return z;
    }

    public final synchronized boolean aPi(String str) {
        AppMethodBeat.i(95746);
        this.DJZ.remove(str);
        AppMethodBeat.o(95746);
        return true;
    }

    public final synchronized int faq() {
        int size;
        AppMethodBeat.i(95747);
        size = this.DJZ.size();
        AppMethodBeat.o(95747);
        return size;
    }

    public final synchronized boolean Yw(int i2) {
        boolean z;
        AppMethodBeat.i(95748);
        if (this.DKa.contains(Integer.valueOf(i2))) {
            z = false;
            AppMethodBeat.o(95748);
        } else {
            this.DKa.add(Integer.valueOf(i2));
            z = true;
            AppMethodBeat.o(95748);
        }
        return z;
    }

    public final synchronized boolean Yx(int i2) {
        AppMethodBeat.i(95749);
        this.DKa.remove(Integer.valueOf(i2));
        this.DKb.remove(Integer.valueOf(i2));
        AppMethodBeat.o(95749);
        return true;
    }

    public final synchronized boolean iv(int i2, int i3) {
        AppMethodBeat.i(95750);
        this.DKb.put(Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(95750);
        return true;
    }

    public final synchronized boolean Yy(int i2) {
        AppMethodBeat.i(95751);
        this.DKb.remove(Integer.valueOf(i2));
        AppMethodBeat.o(95751);
        return true;
    }

    public final synchronized int Yz(int i2) {
        int i3;
        AppMethodBeat.i(95752);
        if (this.DKb.containsKey(Integer.valueOf(i2))) {
            i3 = this.DKb.get(Integer.valueOf(i2)).intValue();
            AppMethodBeat.o(95752);
        } else {
            i3 = -1;
            AppMethodBeat.o(95752);
        }
        return i3;
    }
}
