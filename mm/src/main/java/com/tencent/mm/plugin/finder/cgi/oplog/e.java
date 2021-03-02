package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016J0\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModProfileSticky;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModProfileSticky;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyStickyFeed", "feedId", "", "opType", "nonceId", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Companion", "plugin-finder_release"})
public final class e extends k<aze> implements s {
    public static final a txI = new a((byte) 0);
    private final String TAG = "Finder.FinderModProfileStickySetting";

    static {
        AppMethodBeat.i(242656);
        AppMethodBeat.o(242656);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ b di(aze aze) {
        AppMethodBeat.i(242655);
        aze aze2 = aze;
        p.h(aze2, "cmdBufItem");
        b cD = b.cD(aze2.toByteArray());
        p.g(cD, "ByteString.copyFrom(cmdBufItem.toByteArray())");
        AppMethodBeat.o(242655);
        return cD;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ void n(aze aze, int i2) {
        AppMethodBeat.i(242653);
        aze aze2 = aze;
        p.h(aze2, "cmdBufItem");
        Log.i(this.TAG, "retcode:".concat(String.valueOf(i2)));
        if (i2 == 0) {
            int aWB = aze2.dYx == 0 ? cl.aWB() : 0;
            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
            FinderItem Fy = e.a.Fy(aze2.LIV);
            if (Fy != null) {
                Fy.setStickyTime(aWB);
            }
            hm hmVar = new hm();
            hmVar.dLV.type = 1000;
            hmVar.dLV.id = aze2.LIV;
            hmVar.dLV.stickyTime = aWB;
            EventCenter.instance.publish(hmVar);
        }
        AppMethodBeat.o(242653);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModProfileSticky$Companion;", "", "()V", "PROFILE_STICK_EVENT_TYPE", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final int getCmdId() {
        AppMethodBeat.i(242652);
        bx.a aVar = bx.tvW;
        int i2 = bx.tvT;
        AppMethodBeat.o(242652);
        return i2;
    }

    @Override // com.tencent.mm.plugin.i.a.s
    public final void a(long j2, int i2, String str, ai<aze> aiVar) {
        AppMethodBeat.i(242654);
        p.h(str, "nonceId");
        aze aze = new aze();
        aze.LIV = j2;
        aze.dYx = i2;
        aze.objectNonceId = str;
        a(aze, aiVar, false);
        AppMethodBeat.o(242654);
    }
}
