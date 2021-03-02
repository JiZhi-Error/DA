package com.tencent.mm.plugin.byp.b;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.byp.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.su;
import com.tencent.mm.protocal.protobuf.sv;
import com.tencent.mm.protocal.protobuf.sw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J4\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001e0\u001dH\u0016J\n\u0010\u001f\u001a\u00020\u0017*\u00020\u0010R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSync;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BypSyncResponse;", "selector", "", "", "source", "Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "(Ljava/util/List;Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;)V", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/BypSyncRequest;", "getSource", "()Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "mergeSyncKey", "", "req", "Lcom/tencent/mm/protocal/protobuf/BypSyncKeyBuff;", "resp", "onCgiBack", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onFailed", "onSuccessfully", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", SharePatchInfo.FINGER_PRINT, "Companion", "plugin-byp_release"})
public final class f extends c<sw> {
    public static final a pPI = new a((byte) 0);
    private final sv pPG = new sv();
    private final c.b pPH;

    static {
        AppMethodBeat.i(199129);
        AppMethodBeat.o(199129);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSync$Companion;", "", "()V", "TAG", "", "plugin-byp_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public f(List<Integer> list, c.b bVar) {
        p.h(list, "selector");
        p.h(bVar, "source");
        AppMethodBeat.i(199128);
        this.pPH = bVar;
        d.a aVar = new d.a();
        this.pPG.LaF = new LinkedList<>(list);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().get(ar.a.USERINFO_BYP_KEY_BUFF_STRING_SYNC, "");
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        Object obj = aAh2.azQ().get(ar.a.USERINFO_BYP_KEY_BUFF_STRING_SYNC, "");
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(199128);
            throw tVar;
        }
        byte[] decodeHexString = Util.decodeHexString((String) obj);
        sv svVar = this.pPG;
        st stVar = new st();
        stVar.parseFrom(decodeHexString);
        svVar.LaN = stVar;
        this.pPG.scene = this.pPH.value;
        aVar.c(this.pPG);
        sw swVar = new sw();
        swVar.setBaseResponse(new BaseResponse());
        swVar.getBaseResponse().ErrMsg = new dqi();
        aVar.d(swVar);
        aVar.MB("/cgi-bin/micromsg-bin/bypsync");
        aVar.sG(3673);
        c(aVar.aXF());
        Log.i("Byp.CgiBypSync", "[CgiBypSync] selector=" + this.pPG.LaF + " scene=" + this.pPH.value + " size=" + decodeHexString.length);
        AppMethodBeat.o(199128);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, sw swVar, q qVar) {
        AppMethodBeat.i(199125);
        sw swVar2 = swVar;
        p.h(swVar2, "resp");
        super.a(i2, i3, str, swVar2, qVar);
        Log.i("Byp.CgiBypSync", "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " selector=" + this.pPG.LaF);
        if (i2 == 0 && i3 == 0) {
            st stVar = swVar2.LaP;
            st stVar2 = this.pPG.LaN;
            if (stVar2 == null) {
                p.hyc();
            }
            boolean z = stVar != null ? stVar.EHr : false;
            Log.i("Byp.CgiBypSync", "[onSuccessfully] isReset=" + z + ", item size=" + swVar2.LaQ.size());
            if (z) {
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_BYP_KEY_BUFF_STRING_SYNC, "");
                AppMethodBeat.o(199125);
                return;
            }
            a(stVar2, stVar);
            AppMethodBeat.o(199125);
            return;
        }
        Log.i("Byp.CgiBypSync", "[onFailed] " + this.pPG.LaF);
        AppMethodBeat.o(199125);
    }

    @Override // com.tencent.mm.ak.c
    public final com.tencent.mm.co.f<c.a<sw>> aYI() {
        AppMethodBeat.i(199124);
        h.INSTANCE.n(1465, (long) this.pPH.value, 1);
        com.tencent.mm.co.f<c.a<sw>> aYI = super.aYI();
        p.g(aYI, "super.run()");
        AppMethodBeat.o(199124);
        return aYI;
    }

    private static boolean a(st stVar, st stVar2) {
        boolean z;
        boolean z2;
        LinkedList<su> linkedList;
        T t;
        boolean z3;
        AppMethodBeat.i(199126);
        Log.i("Byp.CgiBypSync", "[mergeSyncKey] req: " + a(stVar) + " resp: " + (stVar2 != null ? a(stVar2) : null));
        if (stVar2 == null || (linkedList = stVar2.LaK) == null) {
            z2 = false;
            z = false;
        } else {
            z2 = false;
            z = false;
            for (T t2 : linkedList) {
                LinkedList<su> linkedList2 = stVar.LaK;
                p.g(linkedList2, "req.sync_key_pair_list");
                Iterator<T> it = linkedList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (next.LaL == t2.LaL) {
                        z3 = true;
                        continue;
                    } else {
                        z3 = false;
                        continue;
                    }
                    if (z3) {
                        t = next;
                        break;
                    }
                }
                T t3 = t;
                if (t3 == null) {
                    Log.i("Byp.CgiBypSync", "[mergeSyncKey] insert " + t2.LaL + '=' + t2.LaM);
                    stVar.LaK.add(t2);
                    z2 = true;
                } else if (t3.LaM < t2.LaM) {
                    t3.LaM = t2.LaM;
                    Log.i("Byp.CgiBypSync", "[mergeSyncKey] modify " + t2.LaL + '=' + t2.LaM);
                    z = true;
                } else {
                    Log.e("Byp.CgiBypSync", "[mergeSyncKey] value(" + t2.LaM + ") is invalid, client value=" + t3.LaM + ' ');
                }
            }
        }
        if (z || z2) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_BYP_KEY_BUFF_STRING_SYNC, Util.encodeHexString(stVar.toByteArray()));
        }
        AppMethodBeat.o(199126);
        return z;
    }

    private static String a(st stVar) {
        AppMethodBeat.i(199127);
        p.h(stVar, "$this$print");
        StringBuilder sb = new StringBuilder();
        LinkedList<su> linkedList = stVar.LaK;
        p.g(linkedList, "sync_key_pair_list");
        for (T t : linkedList) {
            sb.append(t.LaL).append("=").append(t.LaM).append(", ");
        }
        String sb2 = sb.toString();
        p.g(sb2, "ss.toString()");
        AppMethodBeat.o(199127);
        return sb2;
    }
}
