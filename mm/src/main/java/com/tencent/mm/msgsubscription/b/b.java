package com.tencent.mm.msgsubscription.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgUpdateStrategy;", "", "()V", "TAG", "", "checkSubscribeStatusNeedUpdate", "", "subscribeMsgTmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "plugin-comm_release"})
public final class b {
    public static final b jzH = new b();

    static {
        AppMethodBeat.i(223272);
        AppMethodBeat.o(223272);
    }

    private b() {
    }

    public static boolean b(SubscribeMsgTmpItem subscribeMsgTmpItem) {
        boolean z;
        String str;
        Long l = null;
        AppMethodBeat.i(223271);
        if (subscribeMsgTmpItem == null || subscribeMsgTmpItem.jyC == 0) {
            Object[] objArr = new Object[1];
            if (subscribeMsgTmpItem != null) {
                str = subscribeMsgTmpItem.ixM;
            } else {
                str = null;
            }
            objArr[0] = str;
            Log.i("MicroMsg.SubscribeMsgUpdateStrategy", "alvinluo checkSubscribeStatusNeedUpdate first time and do update templateId: %s", objArr);
            z = true;
        } else if (subscribeMsgTmpItem.jyC < System.currentTimeMillis()) {
            Log.i("MicroMsg.SubscribeMsgUpdateStrategy", "alvinluo checkSubscribeStatusNeedUpdate updateTimestamp expired and do update, templateId: %s", subscribeMsgTmpItem.ixM);
            z = true;
        } else {
            z = false;
        }
        Object[] objArr2 = new Object[3];
        if (subscribeMsgTmpItem != null) {
            l = Long.valueOf(subscribeMsgTmpItem.jyC);
        }
        objArr2[0] = l;
        objArr2[1] = Long.valueOf(System.currentTimeMillis());
        objArr2[2] = Boolean.valueOf(z);
        Log.v("MicroMsg.SubscribeMsgUpdateStrategy", "alvinluo checkSubscribeStatusNeedUpdate updateTimestamp: %s, now: %s, needUpdate: %b", objArr2);
        AppMethodBeat.o(223271);
        return z;
    }
}
