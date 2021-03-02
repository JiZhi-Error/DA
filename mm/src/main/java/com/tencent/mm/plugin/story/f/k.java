package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.jt;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.x;

public final class k {
    public static final k FmH = new k();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(118723);
        AppMethodBeat.o(118723);
    }

    private k() {
    }

    public static /* synthetic */ void aRQ(String str) {
        AppMethodBeat.i(118717);
        a(str, 0, 0, null, null, 0);
        AppMethodBeat.o(118717);
    }

    public static void a(String str, long j2, int i2, String str2, String str3, long j3) {
        f fVar;
        AppMethodBeat.i(118716);
        p.h(str, ch.COL_USERNAME);
        j.b bVar = j.Fmy;
        g fod = j.b.fod();
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        p.h(str, "userName");
        p.h(str2, "thumb");
        p.h(str3, "videoUrl");
        f aSv = fod.aSv(str);
        if (aSv == null) {
            fVar = fod.aSt(str);
        } else {
            fVar = aSv;
        }
        boolean frA = fVar.frA();
        boolean isValid = fVar.isValid();
        f.a aVar = f.Fwe;
        if (((Boolean) f.Fwd.invoke(Long.valueOf(fVar.field_syncId), Long.valueOf(j2))).booleanValue()) {
            fVar.field_updateTime = ((long) i2) * 1000;
        }
        fVar.field_syncId = j2;
        if (fVar.field_preloadStoryId != fVar.field_syncId) {
            fVar.field_preloadStoryId = 0;
            fVar.aSs("");
            fVar.field_preLoadResource = 0;
        }
        fVar.field_storyPostTime = i2;
        p.h(str2, "value");
        fVar.field_newThumbUrl = str2;
        p.h(str3, "value");
        fVar.field_newVideoUrl = str3;
        fVar.field_duration = j3;
        boolean b2 = fod.b(fVar);
        boolean frA2 = fVar.frA();
        boolean isValid2 = fVar.isValid();
        if (b2 && isValid && !isValid2) {
            fod.doNotify("notify_story_invalid", 4, fVar);
            AppMethodBeat.o(118716);
        } else if (b2 && !frA && frA2) {
            fod.doNotify("notify_story_unread", 2, fVar);
            AppMethodBeat.o(118716);
        } else if (b2 && frA && !frA2) {
            fod.doNotify("notify_story_read", 1, fVar);
            AppMethodBeat.o(118716);
        } else if (!b2 || isValid || !isValid2) {
            if (b2 && frA && frA2) {
                fod.doNotify("notify_story_unread", 2, fVar);
            }
            AppMethodBeat.o(118716);
        } else {
            fod.doNotify("notify_story_valid", 5, fVar);
            AppMethodBeat.o(118716);
        }
    }

    public static void a(String str, com.tencent.mm.plugin.story.i.j jVar) {
        AppMethodBeat.i(118718);
        p.h(str, ch.COL_USERNAME);
        if (jVar != null) {
            eek frG = jVar.frG();
            if (!(frG == null || frG.NeB.LoV.size() <= 0 || frG.NeB.LoV.get(0).Msz == null || frG.NeB.LoV.get(0).Url == null)) {
                a(str, jVar.field_storyID, jVar.field_createTime, frG.NeB.LoV.get(0).Msz, frG.NeB.LoV.get(0).Url, (long) (frG.NeB.LoV.get(0).Ned * 1000.0f));
            }
            AppMethodBeat.o(118718);
            return;
        }
        AppMethodBeat.o(118718);
    }

    public static void aRR(String str) {
        AppMethodBeat.i(118719);
        p.h(str, ch.COL_USERNAME);
        j.b bVar = j.Fmy;
        g fod = j.b.fod();
        p.h(str, ch.COL_USERNAME);
        f aSt = fod.aSt(str);
        boolean frA = aSt.frA();
        if (aSt.field_readId != aSt.field_syncId) {
            aSt.field_readId = aSt.field_syncId;
            aSt.field_readTime = cl.aWz();
            boolean b2 = fod.b(aSt);
            boolean frA2 = aSt.frA();
            if (b2 && frA && !frA2) {
                fod.doNotify("notify_story_read", 1, aSt);
            }
        }
        AppMethodBeat.o(118719);
    }

    public static f aRS(String str) {
        AppMethodBeat.i(118720);
        p.h(str, "userName");
        j.b bVar = j.Fmy;
        f aRS = j.b.fod().aRS(str);
        AppMethodBeat.o(118720);
        return aRS;
    }

    public static boolean aRT(String str) {
        boolean z;
        AppMethodBeat.i(118721);
        if (str != null) {
            j.b bVar = j.Fmy;
            f aSw = j.b.fod().aSw(str);
            if (aSw != null && aSw.frA()) {
                z = true;
                Log.d(TAG, "getWithNotify ".concat(String.valueOf(z)));
                AppMethodBeat.o(118721);
                return z;
            }
        }
        z = false;
        Log.d(TAG, "getWithNotify ".concat(String.valueOf(z)));
        AppMethodBeat.o(118721);
        return z;
    }

    public static void reportWaitPlayList(List<String> list, long j2) {
        AppMethodBeat.i(118722);
        p.h(list, "srcuserList");
        h hVar = h.FuH;
        long ahy = h.fqi().ahy();
        ArrayList arrayList = new ArrayList();
        List<String> list2 = list;
        synchronized (list2) {
            try {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(118722);
                throw th;
            }
        }
        d.b("reportWaitPlayList", new a(ahy, j2, arrayList));
        AppMethodBeat.o(118722);
    }

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ long FmI;
        final /* synthetic */ ArrayList FmJ;
        final /* synthetic */ long iNN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(long j2, long j3, ArrayList arrayList) {
            super(0);
            this.iNN = j2;
            this.FmI = j3;
            this.FmJ = arrayList;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118715);
            c cVar = new c("reportWaitPlayList");
            jt jtVar = new jt();
            jtVar.sP(this.iNN);
            jtVar.sQ(this.FmI);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            Iterator it = this.FmJ.iterator();
            int i2 = 1;
            while (it.hasNext()) {
                String str = (String) it.next();
                k kVar = k.FmH;
                p.g(str, ch.COL_USERNAME);
                long j2 = k.aRS(str).field_syncId;
                int length = String.valueOf(j2).length();
                if (sb.length() + length < 1000) {
                    sb.append(j2).append("|");
                } else if (sb2.length() + length < 1000) {
                    sb2.append(j2).append("|");
                } else if (length + sb3.length() < 1000) {
                    sb3.append(j2).append("|");
                } else {
                    jtVar.xc(sb.substring(0, sb.length()).toString());
                    jtVar.xd(sb2.substring(0, sb2.length()).toString());
                    jtVar.xe(sb3.substring(0, sb3.length()).toString());
                    jtVar.sR((long) i2);
                    k kVar2 = k.FmH;
                    Log.i(k.TAG, "split reportWaitPlayList " + this.iNN + ' ' + i2 + ' ' + jtVar.ahQ().length() + ' ' + jtVar.ahQ() + jtVar.ahR().length() + ' ' + jtVar.ahR() + jtVar.ahS().length() + ' ' + jtVar.ahS());
                    jtVar.bfK();
                    jtVar = new jt();
                    jtVar.sP(this.iNN);
                    jtVar.sQ(this.FmI);
                    n.h(sb);
                    n.h(sb2);
                    n.h(sb3);
                    i2++;
                }
            }
            jtVar.xc(sb.substring(0, sb.length()).toString());
            jtVar.xd(sb2.substring(0, sb2.length()).toString());
            jtVar.xe(sb3.substring(0, sb3.length()).toString());
            jtVar.sR((long) i2);
            k kVar3 = k.FmH;
            Log.i(k.TAG, "final reportWaitPlayList " + this.iNN + ' ' + i2 + ' ' + jtVar.ahQ().length() + ' ' + jtVar.ahQ() + jtVar.ahR().length() + ' ' + jtVar.ahR() + jtVar.ahS().length() + ' ' + jtVar.ahS());
            jtVar.bfK();
            new jt();
            cVar.aBw();
            x xVar = x.SXb;
            AppMethodBeat.o(118715);
            return xVar;
        }
    }
}
