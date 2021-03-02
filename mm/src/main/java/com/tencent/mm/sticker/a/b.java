package com.tencent.mm.sticker.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.a.c;
import com.tencent.mm.sticker.c.c;
import com.tencent.mm.sticker.c.d;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\fJ\u0006\u0010\u001a\u001a\u00020\fJ\u0006\u0010\u001b\u001a\u00020\u0004J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001eJ\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u001eJ\u0006\u0010 \u001a\u00020\fJ\u0006\u0010!\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\fJ\u0014\u0010&\u001a\u00020\f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u001eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, hxF = {"Lcom/tencent/mm/sticker/model/LensInfoUserCache;", "", "()V", "TAG", "", "checkingSize", "", "historyFile", "historyList", "Lcom/tencent/mm/protocal/protobuf/LensInfoList;", "historyListener", "Lkotlin/Function0;", "", "getHistoryListener", "()Lkotlin/jvm/functions/Function0;", "setHistoryListener", "(Lkotlin/jvm/functions/Function0;)V", "recommendFile", "recommendList", "stickerData", "getStickerData", "()Ljava/lang/String;", "appendHistory", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "checkHistory", "cleanHistory", "getCacheDir", "getCacheDirInMM", "getHistory", "", "getRecommendList", "parseHistory", "parseRecommend", "removeHistory", "lensId", "saveHistory", "saveRecommend", "updateRecommend", "list", "IPCGetCacheDir", "plugin-sticker_release"})
public final class b {
    private static final String NOb;
    private static final String NOc = (NOb + "recommend.proto");
    private static final String NOd = (NOb + "history.proto");
    private static final cia NOe = new cia();
    static final cia NOf = new cia();
    private static int NOg = 0;
    private static kotlin.g.a.a<x> NOh = null;
    public static final b NOi = new b();
    private static final String TAG = TAG;

    static {
        String str;
        AppMethodBeat.i(105971);
        if (MMApplicationContext.isMainProcess()) {
            str = gzi();
        } else {
            Bundle bundle = (Bundle) h.a(MMApplicationContext.getPackageName(), null, a.class);
            if (bundle == null || (str = bundle.getString("data")) == null) {
                str = "";
            }
        }
        NOb = str;
        byte[] aW = s.aW(NOc, 0, -1);
        if (aW != null) {
            if (!(aW.length == 0)) {
                try {
                    NOe.parseFrom(aW);
                } catch (Exception e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                }
                Log.i(TAG, "parseRecommend: " + NOc + ' ' + NOe.Mnt.size());
            }
        }
        gze();
        AppMethodBeat.o(105971);
    }

    private b() {
    }

    public static final /* synthetic */ String gzj() {
        AppMethodBeat.i(105972);
        String gzi = gzi();
        AppMethodBeat.o(105972);
        return gzi;
    }

    public static void ae(kotlin.g.a.a<x> aVar) {
        NOh = aVar;
    }

    public static void iA(List<? extends chz> list) {
        AppMethodBeat.i(105964);
        p.h(list, "list");
        NOe.Mnt.clear();
        NOe.Mnt.addAll(list);
        byte[] byteArray = NOe.toByteArray();
        s.boN(NOb);
        s.C(NOc, byteArray);
        Log.i(TAG, "saveRecommend: " + NOe.Mnt.size());
        AppMethodBeat.o(105964);
    }

    private static void gze() {
        AppMethodBeat.i(105965);
        byte[] aW = s.aW(NOd, 0, -1);
        if (aW != null) {
            if (!(aW.length == 0)) {
                try {
                    NOf.parseFrom(aW);
                } catch (Exception e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                }
                LinkedList<chz> linkedList = NOf.Mnt;
                p.g(linkedList, "historyList.lensInfoList");
                ArrayList arrayList = new ArrayList();
                for (T t : linkedList) {
                    String str = t.Lso;
                    if (!(str == null || n.aL(str))) {
                        arrayList.add(t);
                    }
                }
                NOf.Mnt.clear();
                NOf.Mnt.addAll(arrayList);
                Log.i(TAG, "parseHistory: " + NOd + ' ' + NOf.Mnt.size());
            }
        }
        AppMethodBeat.o(105965);
    }

    public static void bqy() {
        AppMethodBeat.i(105966);
        kotlin.g.a.a<x> aVar = NOh;
        if (aVar != null) {
            aVar.invoke();
        }
        byte[] byteArray = NOf.toByteArray();
        s.boN(NOb);
        s.C(NOd, byteArray);
        Log.i(TAG, "saveHistory: " + NOf.Mnt.size());
        AppMethodBeat.o(105966);
    }

    public static List<chz> gzf() {
        AppMethodBeat.i(105967);
        LinkedList<chz> linkedList = NOf.Mnt;
        p.g(linkedList, "historyList.lensInfoList");
        LinkedList<chz> linkedList2 = linkedList;
        AppMethodBeat.o(105967);
        return linkedList2;
    }

    public static void f(chz chz) {
        AppMethodBeat.i(194232);
        p.h(chz, "lensInfo");
        LinkedList<chz> linkedList = NOf.Mnt;
        p.g(linkedList, "historyList.lensInfoList");
        Iterator<chz> it = linkedList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (p.j(it.next().Lso, chz.Lso)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0 && i2 < NOf.Mnt.size()) {
            NOf.Mnt.remove(i2);
        }
        NOf.Mnt.add(0, chz);
        if (NOf.Mnt.size() > 4) {
            NOf.Mnt.remove(NOf.Mnt.size() - 1);
        }
        bqy();
        AppMethodBeat.o(194232);
    }

    public static void gzg() {
        AppMethodBeat.i(105968);
        Log.i(TAG, "checkHistory: " + NOg);
        if (NOg > 0) {
            AppMethodBeat.o(105968);
            return;
        }
        LinkedList<chz> linkedList = NOf.Mnt;
        p.g(linkedList, "historyList.lensInfoList");
        for (T t : linkedList) {
            NOg++;
            Log.i(TAG, "checkHistory: " + t.Lso);
            d.a aVar = d.NOm;
            String str = t.Lso;
            p.g(str, "it.LensId");
            d.a.a(null, str, new C2064b(t));
        }
        AppMethodBeat.o(105968);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/sticker/model/LensInfoUserCache$checkHistory$1$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-sticker_release"})
    /* renamed from: com.tencent.mm.sticker.a.b$b  reason: collision with other inner class name */
    public static final class C2064b implements c {
        final /* synthetic */ chz NOj;

        C2064b(chz chz) {
            this.NOj = chz;
        }

        @Override // com.tencent.mm.sticker.c.c
        public final void a(int i2, chz chz) {
            AppMethodBeat.i(105962);
            b bVar = b.NOi;
            Log.i(b.TAG, "onResult: " + this.NOj.Lso + ", " + i2);
            com.tencent.mm.ac.d.h(new a(this, i2, chz));
            AppMethodBeat.o(105962);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.sticker.a.b$b$a */
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ int $errType;
            final /* synthetic */ C2064b NOk;
            final /* synthetic */ chz ron;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2064b bVar, int i2, chz chz) {
                super(0);
                this.NOk = bVar;
                this.$errType = i2;
                this.ron = chz;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                int i2 = 0;
                AppMethodBeat.i(105961);
                b bVar = b.NOi;
                b.NOg--;
                if (this.$errType == 2) {
                    b bVar2 = b.NOi;
                    String str = this.NOk.NOj.Lso;
                    p.g(str, "it.LensId");
                    p.h(str, "lensId");
                    LinkedList<chz> linkedList = b.NOf.Mnt;
                    p.g(linkedList, "historyList.lensInfoList");
                    Iterator<chz> it = linkedList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i2 = -1;
                            break;
                        } else if (p.j(it.next().Lso, str)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        b.NOf.Mnt.remove(i2);
                        b.bqy();
                    }
                } else if (this.$errType == 0 && this.ron != null) {
                    b bVar3 = b.NOi;
                    LinkedList<chz> linkedList2 = b.NOf.Mnt;
                    p.g(linkedList2, "historyList.lensInfoList");
                    Iterator<chz> it2 = linkedList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            i2 = -1;
                            break;
                        } else if (p.j(it2.next().Lso, this.ron.Lso)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 > 0) {
                        c.a aVar = c.NOl;
                        chz chz = this.ron;
                        b bVar4 = b.NOi;
                        chz chz2 = b.NOf.Mnt.get(i2);
                        p.g(chz2, "historyList.lensInfoList[index]");
                        chz chz3 = chz2;
                        p.h(chz, "from");
                        p.h(chz3, "to");
                        chz3.Lso = chz.Lso;
                        chz3.Mns = chz.Mns;
                        chz3.Mnr = chz.Mnr;
                        chz3.Name = chz.Name;
                        chz3.LVe = chz.LVe;
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(105961);
                return xVar;
            }
        }
    }

    public static void gzh() {
        AppMethodBeat.i(105969);
        NOf.Mnt.clear();
        bqy();
        AppMethodBeat.o(105969);
    }

    private static String gzi() {
        String str = null;
        AppMethodBeat.i(105970);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_STICKER_USER_CACHE_DIR_STRING, (Object) null);
        if (obj instanceof String) {
            str = obj;
        }
        String str2 = str;
        if (Util.isNullOrNil(str2)) {
            str2 = "lens_" + System.currentTimeMillis();
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_STICKER_USER_CACHE_DIR_STRING, str2);
        }
        String str3 = com.tencent.mm.loader.j.b.aKC() + "sticker/data/" + str2 + '/';
        AppMethodBeat.o(105970);
        return str3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/sticker/model/LensInfoUserCache$IPCGetCacheDir;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-sticker_release"})
    public static final class a implements k<Bundle, Bundle> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(Bundle bundle) {
            AppMethodBeat.i(105960);
            Bundle bundle2 = new Bundle();
            b bVar = b.NOi;
            bundle2.putString("data", b.gzj());
            AppMethodBeat.o(105960);
            return bundle2;
        }
    }
}
