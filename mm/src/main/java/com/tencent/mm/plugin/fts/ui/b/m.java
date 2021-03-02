package com.tencent.mm.plugin.fts.ui.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0013\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0003J\t\u0010*\u001a\u00020\u000fHÖ\u0001J\u000e\u0010+\u001a\u00020%2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010,\u001a\u00020(2\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010-\u001a\u00020\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001a\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/fts/ui/logic/FTSEducationRedDot;", "", "msgId", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "bizType", "", "getBizType", "()J", "setBizType", "(J)V", "clientVersion", "", "getClientVersion", "()I", "setClientVersion", "(I)V", "exposeExpiredTime", "getExposeExpiredTime", "setExposeExpiredTime", "exposeTimestamp", "getExposeTimestamp", "setExposeTimestamp", "h5Version", "getH5Version", "setH5Version", "getMsgId", "setMsgId", "redDotAction", "getRedDotAction", "setRedDotAction", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "fromJSONStr", "", "value", "hashCode", "needShowRedDot", "showRedDot", "toJSONStr", "toString", "ui-fts_release"})
public final class m {
    long Rrq;
    final String TAG;
    long UWR;
    long UWS;
    long UWT;
    int UWU;
    int jjS;
    String msgId;

    public final boolean equals(Object obj) {
        AppMethodBeat.i(258235);
        if (this == obj || ((obj instanceof m) && p.j(this.msgId, ((m) obj).msgId))) {
            AppMethodBeat.o(258235);
            return true;
        }
        AppMethodBeat.o(258235);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(258234);
        String str = this.msgId;
        if (str != null) {
            int hashCode = str.hashCode();
            AppMethodBeat.o(258234);
            return hashCode;
        }
        AppMethodBeat.o(258234);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(258233);
        String str = "FTSEducationRedDot(msgId=" + this.msgId + ")";
        AppMethodBeat.o(258233);
        return str;
    }

    public /* synthetic */ m() {
        this("");
        AppMethodBeat.i(258232);
        AppMethodBeat.o(258232);
    }

    private m(String str) {
        p.h(str, "msgId");
        AppMethodBeat.i(258231);
        this.msgId = str;
        this.TAG = "MicroMsg.FTS.FTSEducationRedDot";
        this.UWT = -1;
        AppMethodBeat.o(258231);
    }

    public final boolean RO(long j2) {
        boolean z;
        AppMethodBeat.i(258229);
        long aWA = this.Rrq == 0 ? cl.aWA() : this.Rrq;
        if (this.UWT != j2 || this.UWU != 1 || aWA + (this.UWS * 1000) < cl.aWA() || d.KyO < this.jjS || ((long) ai.aft(0)) < this.UWR) {
            z = false;
        } else {
            z = true;
        }
        Log.i(this.TAG, "needShowRedDot " + z + ' ' + j2);
        AppMethodBeat.o(258229);
        return z;
    }

    public final String hVL() {
        AppMethodBeat.i(258230);
        i iVar = new i();
        iVar.h("msgId", this.msgId);
        iVar.v("h5Version", this.UWR);
        iVar.v("exposeExpiredTime", this.UWS);
        iVar.v("bizType", this.UWT);
        iVar.U("redDotAction", this.UWU);
        iVar.v("exposeTimestamp", this.Rrq);
        String iVar2 = iVar.toString();
        p.g(iVar2, "json.toString()");
        AppMethodBeat.o(258230);
        return iVar2;
    }
}
