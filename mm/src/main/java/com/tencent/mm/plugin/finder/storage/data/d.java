package com.tencent.mm.plugin.finder.storage.data;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.c;
import com.tencent.mm.plugin.finder.cgi.br;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.k;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007\b\u0012¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J,\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u0018\u0010\u001a\u001a\u00020\u00102\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0002J\u0018\u0010\u001e\u001a\u00020\u00102\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001cH\u0002J\u0006\u0010 \u001a\u00020\u0010J\u0006\u0010!\u001a\u00020\u0010R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "blackList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getBlackList", "()Ljava/util/ArrayList;", "setBlackList", "(Ljava/util/ArrayList;)V", "getBaseCachePath", "getCacheFilePath", "name", "getFileName", "onAlive", "", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "readCache", "refreshByBatchSetBlackList", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeResInfo;", "refreshByGetTagContact", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "refreshDataFromNet", "saveCache", "Companion", "plugin-finder_release"})
public final class d implements i {
    private static final String TAG = TAG;
    private static final f iax = g.a(k.SYNCHRONIZED, b.vFT);
    public static final a vFS = new a((byte) 0);
    private ArrayList<String> ldu;

    public /* synthetic */ d(byte b2) {
        this();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "getInstance", "()Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "instance$delegate", "Lkotlin/Lazy;", "plugin-finder_release"})
    public static final class a {
        public static d dyw() {
            AppMethodBeat.i(251955);
            f fVar = d.iax;
            a aVar = d.vFS;
            d dVar = (d) fVar.getValue();
            AppMethodBeat.o(251955);
            return dVar;
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251966);
        AppMethodBeat.o(251966);
    }

    private static String aee(String str) {
        AppMethodBeat.i(251956);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String sb3 = sb.append(sb2.append(aAh.azM()).append("finder/black_list/").toString()).append(str).toString();
        AppMethodBeat.o(251956);
        return sb3;
    }

    private static String getFileName() {
        AppMethodBeat.i(251957);
        String aUg = z.aUg();
        p.g(aUg, "finderUserName");
        Charset charset = kotlin.n.d.UTF_8;
        if (aUg == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(251957);
            throw tVar;
        }
        byte[] bytes = aUg.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 0);
        p.g(encodeToString, "Base64.encodeToString(fi…eArray(), Base64.DEFAULT)");
        AppMethodBeat.o(251957);
        return encodeToString;
    }

    private d() {
        AppMethodBeat.i(251965);
        this.ldu = new ArrayList<>();
        AppMethodBeat.o(251965);
    }

    public final void onAlive() {
        AppMethodBeat.i(251958);
        com.tencent.mm.kernel.g.azz().a(3528, this);
        com.tencent.mm.kernel.g.azz().a(3990, this);
        AppMethodBeat.o(251958);
    }

    public final void onDetach() {
        AppMethodBeat.i(251959);
        com.tencent.mm.kernel.g.azz().b(3528, this);
        com.tencent.mm.kernel.g.azz().b(3990, this);
        AppMethodBeat.o(251959);
    }

    public static void dyu() {
        AppMethodBeat.i(251960);
        br.a aVar = br.tvA;
        com.tencent.mm.kernel.g.azz().b(new br(br.cYG()));
        AppMethodBeat.o(251960);
    }

    private final void ay(LinkedList<bdk> linkedList) {
        String str;
        AppMethodBeat.i(251961);
        Log.d(TAG, "refreshByGetTagContact size " + (linkedList != null ? Integer.valueOf(linkedList.size()) : null));
        this.ldu.clear();
        if (linkedList != null) {
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                ArrayList<String> arrayList = this.ldu;
                FinderContact finderContact = it.next().contact;
                if (finderContact == null || (str = finderContact.username) == null) {
                    str = "";
                }
                arrayList.add(str);
            }
            AppMethodBeat.o(251961);
            return;
        }
        AppMethodBeat.o(251961);
    }

    private final void az(LinkedList<cpn> linkedList) {
        AppMethodBeat.i(251962);
        Log.d(TAG, "refreshByBatchSetBlackList size " + (linkedList != null ? Integer.valueOf(linkedList.size()) : null));
        if (linkedList != null) {
            for (T t : linkedList) {
                switch (t.MvE.MvD) {
                    case 1:
                        if (!this.ldu.contains(t.MvE.UserName)) {
                            Log.d(TAG, "refreshByBatchSetBlackList add " + t.MvE.UserName);
                            this.ldu.add(t.MvE.UserName);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (this.ldu.contains(t.MvE.UserName)) {
                            Log.d(TAG, "refreshByBatchSetBlackList del " + t.MvE.UserName);
                            this.ldu.remove(t.MvE.UserName);
                            break;
                        } else {
                            break;
                        }
                }
            }
            AppMethodBeat.o(251962);
            return;
        }
        AppMethodBeat.o(251962);
    }

    public final ArrayList<String> dyv() {
        AppMethodBeat.i(251963);
        if (this.ldu.isEmpty()) {
            String aee = aee(getFileName());
            if (s.YS(aee)) {
                try {
                    List<String> stringToList = Util.stringToList(s.boY(aee), ",");
                    p.g(stringToList, "Util.stringToList(content, \",\")");
                    for (T t : stringToList) {
                        Log.d(TAG, "read cahe:".concat(String.valueOf(t)));
                        this.ldu.clear();
                        this.ldu.add(t);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace(TAG, e2, "read unlike cache file", new Object[0]);
                }
            }
        }
        ArrayList<String> arrayList = this.ldu;
        AppMethodBeat.o(251963);
        return arrayList;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(251964);
        if (qVar instanceof br) {
            Log.i(TAG, "NetSceneFinderGetTagContact errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
            if (i2 == 0 && i3 == 0) {
                ay(((br) qVar).cYF());
            }
        } else if (qVar instanceof c) {
            Log.i(TAG, "NetSceneBatchSetBlackList errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
            if (i2 == 0 && i3 == 0) {
                az(((c) qVar).bdI().KOP);
            }
        }
        Log.d(TAG, "saveCache,size = " + this.ldu.size());
        String listToString = Util.listToString(this.ldu, ",");
        String aee = aee(getFileName());
        p.g(listToString, "content");
        Charset charset = kotlin.n.d.UTF_8;
        if (listToString == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(251964);
            throw tVar;
        }
        byte[] bytes = listToString.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        s.C(aee, bytes);
        AppMethodBeat.o(251964);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<d> {
        public static final b vFT = new b();

        static {
            AppMethodBeat.i(251954);
            AppMethodBeat.o(251954);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ d invoke() {
            AppMethodBeat.i(251953);
            d dVar = new d((byte) 0);
            AppMethodBeat.o(251953);
            return dVar;
        }
    }
}
