package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/ui/chatting/ChattingCheckUtil;", "", "()V", "TAG", "", "checkIfExceedSingleFileLimit", "", "selectItems", "", "Lcom/tencent/mm/storage/MsgInfo;", "maxSingleFileSize", "", "checkIfOverRecordMsgLimit", "maxGroupSize", "sumSelectedMsgFileSize", "app_release"})
public final class h {
    public static final h Pgg = new h();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(231175);
        AppMethodBeat.o(231175);
    }

    private h() {
    }

    public static boolean i(List<? extends ca> list, long j2) {
        k.b HD;
        AppMethodBeat.i(231174);
        p.h(list, "selectItems");
        for (ca caVar : list) {
            if (caVar.dOQ() && (HD = k.b.HD(caVar.getContent())) != null && HD.type == 6 && ((long) HD.iwI) > j2) {
                Log.w(TAG, "file is too large, %s", Util.getSizeKB((long) HD.iwI));
                AppMethodBeat.o(231174);
                return true;
            }
        }
        AppMethodBeat.o(231174);
        return false;
    }

    public static boolean h(List<? extends ca> list, long j2) {
        int i2;
        int i3;
        AppMethodBeat.i(231173);
        p.h(list, "selectItems");
        long j3 = 0;
        for (ca caVar : list) {
            if (caVar.cWJ() || caVar.cWL()) {
                s QN = u.QN(caVar.ajP());
                int bcq = QN != null ? QN.bcq() : 0;
                j3 += (long) bcq;
                Log.d(TAG, "sumSelectedMsgFileSize, videoSize:%s", Integer.valueOf(bcq));
            } else if (caVar.gAz()) {
                g G = q.bcR().G(caVar.ajO(), caVar.ajM());
                p.g(G, "img");
                j3 += (long) G.bcq();
                Log.d(TAG, "sumSelectedMsgFileSize, imgSize:%s", Integer.valueOf(G.bcq()));
            } else if (caVar.dOQ()) {
                k.b HD = k.b.HD(caVar.getContent());
                if (HD != null && HD.type == 6) {
                    j3 += (long) HD.iwI;
                    Log.d(TAG, "sumSelectedMsgFileSize, fileSize:%s", Integer.valueOf(HD.iwI));
                } else if (HD != null && (HD.type == 24 || HD.type == 19)) {
                    c aKY = com.tencent.mm.plugin.record.b.p.aKY(HD.ixl);
                    if (aKY != null) {
                        Iterator<aml> it = aKY.iAd.iterator();
                        i2 = 0;
                        while (it.hasNext()) {
                            aml next = it.next();
                            p.g(next, "dataItem");
                            if (next.getDataType() == 17) {
                                c aKY2 = com.tencent.mm.plugin.record.b.p.aKY(next.gue());
                                if (aKY2 != null) {
                                    Iterator<aml> it2 = aKY2.iAd.iterator();
                                    i3 = 0;
                                    while (it2.hasNext()) {
                                        aml next2 = it2.next();
                                        p.g(next2, "innerDataItem");
                                        i3 = ((int) next2.gub()) + i3;
                                    }
                                } else {
                                    i3 = 0;
                                }
                                i2 += i3;
                            } else {
                                i2 = ((int) next.gub()) + i2;
                            }
                        }
                    } else {
                        i2 = 0;
                    }
                    j3 += (long) i2;
                    Log.d(TAG, "sumSelectedMsgFileSize, noteSize:%s", Integer.valueOf(i2));
                }
            }
        }
        Log.i(TAG, "sumSelectedMsgFileSize, totalSize:%s", Long.valueOf(j3));
        if (j3 > j2) {
            AppMethodBeat.o(231173);
            return true;
        }
        AppMethodBeat.o(231173);
        return false;
    }
}
