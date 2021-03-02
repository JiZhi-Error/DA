package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H&J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0013H&¢\u0006\u0002\u0010\u0017J,\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J-\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00028\u00002\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b2\b\b\u0002\u0010 \u001a\u00020!¢\u0006\u0002\u0010\"R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R+\u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "T", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "waitQueue", "Ljava/util/LinkedHashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "getWaitQueue", "()Ljava/util/LinkedHashMap;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "(Ljava/lang/Object;)Lcom/tencent/mm/protobuf/ByteString;", "getCmdId", "", "handleUpdateResult", "", "retCode", "(Ljava/lang/Object;I)V", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "tryDoNext", "callback", "isMegaVideo", "", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;Z)V", "plugin-finder_release"})
public abstract class k<T> implements i {
    private final LinkedHashMap<T, WeakReference<ai<T>>> txP = new LinkedHashMap<>();

    public abstract b di(T t);

    public abstract int getCmdId();

    public abstract String getTAG();

    public abstract void n(T t, int i2);

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        T t;
        ai<T> aiVar;
        Integer num;
        boolean z = false;
        Log.i(getTAG(), "errType " + i2 + " errCode " + i3 + " errMsg " + str);
        if (qVar == null) {
            throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
        }
        List<apg> cYN = ((bx) qVar).cYN();
        List<apf> cYM = ((bx) qVar).cYM();
        Iterator<apf> it = cYM.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            if (it.next().cmdId == getCmdId()) {
                break;
            }
            i4++;
        }
        if (i4 < 0) {
            String tag = getTAG();
            StringBuilder sb = new StringBuilder("not cares cmdId: ");
            apf apf = (apf) j.kt(cYM);
            if (apf != null) {
                num = Integer.valueOf(apf.cmdId);
            } else {
                num = null;
            }
            Log.i(tag, sb.append(num).toString());
            return;
        }
        Log.i(getTAG(), "retList " + cYN.size());
        synchronized (this.txP) {
            if (!this.txP.isEmpty()) {
                Iterator<Map.Entry<T, WeakReference<ai<T>>>> it2 = this.txP.entrySet().iterator();
                Map.Entry<T, WeakReference<ai<T>>> next = it2.next();
                T key = next.getKey();
                it2.remove();
                t = key;
                aiVar = next.getValue().get();
            } else {
                t = null;
                aiVar = null;
            }
            x xVar = x.SXb;
        }
        if (i2 == 0 && i3 == 0) {
            Iterator<apg> it3 = cYN.iterator();
            int i5 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    i5 = -1;
                    break;
                }
                if (it3.next().cmdId == getCmdId()) {
                    break;
                }
                i5++;
            }
            if (!(i5 == -1 || t == null)) {
                n(t, cYN.get(i5).retCode);
                if (aiVar != null) {
                    aiVar.a(t, cYN.get(i5));
                }
            }
        } else if (!(t == null || aiVar == null)) {
            apg apg = new apg();
            apg.cmdId = getCmdId();
            apg.retCode = -1;
            aiVar.a(t, apg);
        }
        synchronized (this.txP) {
            if (!this.txP.isEmpty()) {
                z = true;
            }
            if (z) {
                Map.Entry<T, WeakReference<ai<T>>> next2 = this.txP.entrySet().iterator().next();
                a(next2.getKey(), next2.getValue().get(), false);
            }
            x xVar2 = x.SXb;
        }
    }

    public final void a(T t, ai<T> aiVar, boolean z) {
        synchronized (this.txP) {
            apf apf = new apf();
            apf.cmdId = getCmdId();
            apf.LBo = di(t);
            this.txP.put(t, new WeakReference<>(aiVar));
            com.tencent.mm.ak.t azz = g.azz();
            String aUg = z.aUg();
            if (aUg == null) {
                p.hyc();
            }
            azz.b(new bx(aUg, j.listOf(apf), z));
        }
    }
}
