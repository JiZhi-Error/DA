package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.c;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a implements i {
    public static a Gjc;
    public List<String> FjN;
    public List<String> Gjd;
    public long Gje = 1;
    public long Gjf = 1;
    public c Gjg;
    public c Gjh;
    private List<String> Gji;
    private List<String> Gjj;
    public AbstractC1838a Gjk;
    public b Gjl;

    /* renamed from: com.tencent.mm.plugin.topstory.a.b.a$a  reason: collision with other inner class name */
    public interface AbstractC1838a {
        void awp();
    }

    public interface b {
        void awp();
    }

    public static a fxV() {
        AppMethodBeat.i(88469);
        if (Gjc == null) {
            Gjc = new a();
        }
        a aVar = Gjc;
        AppMethodBeat.o(88469);
        return aVar;
    }

    private static final String aee(String str) {
        AppMethodBeat.i(88470);
        String str2 = (g.aAh().hqG + "topstory/") + str;
        AppMethodBeat.o(88470);
        return str2;
    }

    public a() {
        AppMethodBeat.i(88471);
        String aee = aee("blacklist");
        if (s.YS(aee)) {
            try {
                this.FjN = Util.stringToList(s.boY(aee), ",");
                this.Gje = g.aAh().azQ().a(ar.a.USERINFO_TOP_STORY_BLACK_LIST_VERSION_LONG, 1);
                Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "black version %d", Long.valueOf(this.Gje));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TopStory.TopStoryBlackListMgr", e2, "read black cache file", new Object[0]);
            }
        }
        if (this.FjN == null) {
            this.FjN = new ArrayList();
        }
        String aee2 = aee("unlikelist");
        if (s.YS(aee2)) {
            try {
                this.FjN = Util.stringToList(s.boY(aee2), ",");
                this.Gjf = g.aAh().azQ().a(ar.a.USERINFO_TOP_STORY_UNLIKE_LIST_VERSION_LONG, 1);
                Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "unlike version %d", Long.valueOf(this.Gjf));
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.TopStory.TopStoryBlackListMgr", e3, "read unlike cache file", new Object[0]);
            }
        }
        if (this.Gjd == null) {
            this.Gjd = new ArrayList();
        }
        g.azz().a(2748, this);
        AppMethodBeat.o(88471);
    }

    public final void ae(long j2, int i2) {
        AppMethodBeat.i(88472);
        if (this.Gjg != null) {
            g.azz().a(this.Gjg);
        }
        Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request black version %d offset %d", Long.valueOf(j2), Integer.valueOf(i2));
        this.Gjg = new c(1, j2, i2);
        g.aAg().hqi.a(this.Gjg, 0);
        AppMethodBeat.o(88472);
    }

    public final void af(long j2, int i2) {
        AppMethodBeat.i(88473);
        if (this.Gjh != null) {
            g.azz().a(this.Gjh);
        }
        Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request unlike version %d offset %d", Long.valueOf(j2), Integer.valueOf(i2));
        this.Gjh = new c(3, j2, i2);
        g.aAg().hqi.a(this.Gjh, 0);
        AppMethodBeat.o(88473);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(88474);
        if (qVar.equals(this.Gjg)) {
            if (i2 == 0 && i3 == 0) {
                bln fya = this.Gjg.fya();
                int i4 = fya.KLm;
                if (i4 == 1) {
                    if (this.Gji == null) {
                        this.Gji = new ArrayList();
                    }
                    Iterator<qq> it = fya.KKx.iterator();
                    while (it.hasNext()) {
                        this.Gji.add(it.next().Username);
                    }
                    if (fya.KZh == 1) {
                        Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync black size %d version %d", Integer.valueOf(fya.KKx.size()), Long.valueOf(fya.LRV));
                        ae(fya.LRV, fya.KZk);
                        AppMethodBeat.o(88474);
                        return;
                    }
                    this.FjN = this.Gji;
                    this.Gji = null;
                    this.Gje = fya.LRV;
                    Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update black version %d total item %d", Long.valueOf(this.Gje), Integer.valueOf(this.FjN.size()));
                    g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_BLACK_LIST_VERSION_LONG, Long.valueOf(this.Gje));
                    fxW();
                    if (this.Gjk != null) {
                        this.Gjk.awp();
                        AppMethodBeat.o(88474);
                        return;
                    }
                } else if (i4 == 2) {
                    Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "no need to update black list");
                    AppMethodBeat.o(88474);
                    return;
                } else if (i4 == 3) {
                    Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "resync black list");
                    this.Gji = null;
                    ae(this.Gje, 0);
                    AppMethodBeat.o(88474);
                    return;
                } else {
                    Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid black update flag %d", Integer.valueOf(i4));
                }
                AppMethodBeat.o(88474);
                return;
            }
        } else if (qVar.equals(this.Gjh) && i2 == 0 && i3 == 0) {
            bln fya2 = this.Gjh.fya();
            int i5 = fya2.KLm;
            if (i5 == 1) {
                if (this.Gjj == null) {
                    this.Gjj = new ArrayList();
                }
                Iterator<qq> it2 = fya2.KKx.iterator();
                while (it2.hasNext()) {
                    this.Gjj.add(it2.next().Username);
                }
                if (fya2.KZh == 1) {
                    Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync unlike size %d version", Integer.valueOf(fya2.KKx.size()), Long.valueOf(fya2.LRV));
                    af(fya2.LRV, fya2.KZk);
                    AppMethodBeat.o(88474);
                    return;
                }
                this.Gjd = this.Gjj;
                this.Gjj = null;
                this.Gjf = fya2.LRV;
                Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update unlike version %d total item %d", Long.valueOf(this.Gjf), Integer.valueOf(this.Gjd.size()));
                g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_UNLIKE_LIST_VERSION_LONG, Long.valueOf(this.Gjf));
                fxX();
                if (this.Gjl != null) {
                    this.Gjl.awp();
                    AppMethodBeat.o(88474);
                    return;
                }
            } else if (i5 == 2) {
                Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "no need to update unlike list");
                AppMethodBeat.o(88474);
                return;
            } else if (i5 == 3) {
                Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "resync unlike list");
                this.Gjj = null;
                af(this.Gjf, 0);
                AppMethodBeat.o(88474);
                return;
            } else {
                Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid unlike update flag %d", Integer.valueOf(i5));
            }
        }
        AppMethodBeat.o(88474);
    }

    public final void fxW() {
        AppMethodBeat.i(88475);
        String listToString = Util.listToString(this.FjN, ",");
        String aee = aee("blacklist");
        byte[] bytes = listToString.getBytes();
        s.f(aee, bytes, bytes.length);
        AppMethodBeat.o(88475);
    }

    public final void fxX() {
        AppMethodBeat.i(88476);
        String listToString = Util.listToString(this.Gjd, ",");
        String aee = aee("unlikelist");
        byte[] bytes = listToString.getBytes();
        s.f(aee, bytes, bytes.length);
        AppMethodBeat.o(88476);
    }
}
