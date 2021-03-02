package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Vector;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionManager;", "", "()V", "TAG", "", "approveMentionList", "Ljava/util/Vector;", "", "getApplyMentionState", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "removeMentionOp", "", "mentionId", "setMentionApprovedOp", "plugin-finder_release"})
public final class f {
    private static final String TAG = TAG;
    private static final Vector<Long> vGU = new Vector<>();
    public static final f vGV = new f();

    static {
        AppMethodBeat.i(252096);
        AppMethodBeat.o(252096);
    }

    private f() {
    }

    public static void c(ao aoVar) {
        AppMethodBeat.i(252093);
        p.h(aoVar, "mention");
        vGU.add(Long.valueOf(aoVar.field_id));
        AppMethodBeat.o(252093);
    }

    public static void FW(long j2) {
        AppMethodBeat.i(252094);
        vGU.remove(Long.valueOf(j2));
        AppMethodBeat.o(252094);
    }

    public static int d(ao aoVar) {
        AppMethodBeat.i(252095);
        p.h(aoVar, "mention");
        Log.i(TAG, "getApplyMentionState, cache exist:" + vGU.contains(Long.valueOf(aoVar.field_id)) + ", item flag: " + aoVar.field_extFlag + ", createTime:" + aoVar.field_createTime);
        if (vGU.contains(Long.valueOf(aoVar.field_id))) {
            AppMethodBeat.o(252095);
            return 2;
        } else if ((aoVar.field_extFlag & 8) > 0) {
            AppMethodBeat.o(252095);
            return 4;
        } else if ((aoVar.field_extFlag & 4) > 0) {
            AppMethodBeat.o(252095);
            return 2;
        } else if (((long) cl.aWB()) > aoVar.field_followExpireTime) {
            AppMethodBeat.o(252095);
            return 3;
        } else {
            AppMethodBeat.o(252095);
            return 1;
        }
    }
}
