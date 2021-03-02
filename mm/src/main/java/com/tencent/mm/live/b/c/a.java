package com.tencent.mm.live.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J6\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/live/model/storage/LiveAnchorStorage;", "", "()V", "EXPIRATION_TIME", "", "FILE_NAME", "", "PATH", "TAG", "cleanCache", "", "getLiveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "hasLiveAnchorInfo", "", "liveFinish", "liveId", "", "liveStart", "roomId", "rotation", "liveName", "createTimeS", "anchorName", "plugin-logic_release"})
public final class a {
    private static final String FILE_NAME = FILE_NAME;
    private static final String PATH;
    private static final String TAG = TAG;
    private static final int hLb = 86400;
    public static final a hLc = new a();

    static {
        AppMethodBeat.i(207847);
        StringBuilder sb = new StringBuilder();
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        PATH = sb.append(aAh.getAccPath()).append("live/").toString();
        AppMethodBeat.o(207847);
    }

    private a() {
    }

    public static void a(long j2, String str, int i2, String str2, int i3, String str3) {
        AppMethodBeat.i(207843);
        p.h(str, "roomId");
        p.h(str2, "liveName");
        p.h(str3, "anchorName");
        Log.i(TAG, "liveStart liveId:" + j2 + ", roomId:" + str + ", rotation:" + i2 + ", liveName:" + str2 + ", createTime:" + i3);
        if (!s.YS(PATH)) {
            s.boN(PATH);
        }
        cip cip = new cip();
        cip.hyH = j2;
        cip.MnB = str;
        cip.rotation = i2;
        cip.LpF = str2;
        cip.Gaz = i3;
        cip.MnC = str3;
        s.C(PATH + FILE_NAME, cip.toByteArray());
        AppMethodBeat.o(207843);
    }

    public static void zE(long j2) {
        boolean z;
        AppMethodBeat.i(207844);
        Log.i(TAG, "liveFinish liveId:".concat(String.valueOf(j2)));
        cip cip = new cip();
        byte[] aW = s.aW(PATH + FILE_NAME, 0, -1);
        if (aW != null) {
            if (!(aW.length == 0)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                try {
                    cip.parseFrom(aW);
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                }
            }
        }
        if (cip.hyH == j2) {
            cip.hyH = 0;
            cip.MnB = "";
            cip.rotation = -1;
            cip.LpF = "";
            cip.Gaz = 0;
            cip.MnC = "";
            s.C(PATH + FILE_NAME, cip.toByteArray());
        }
        AppMethodBeat.o(207844);
    }

    public static cip aHm() {
        boolean z;
        AppMethodBeat.i(207845);
        cip cip = new cip();
        byte[] aW = s.aW(PATH + FILE_NAME, 0, -1);
        if (aW != null) {
            if (!(aW.length == 0)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                try {
                    cip.parseFrom(aW);
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                }
                if (cip.Gaz > 0 && cl.aWB() - cip.Gaz >= hLb) {
                    Log.i(TAG, "liveAnchorInfo expirated, liveId:" + cip.hyH);
                    cip.hyH = 0;
                    cip.MnB = "";
                    cip.rotation = -1;
                    cip.LpF = "";
                    cip.Gaz = 0;
                    cip.MnC = "";
                    s.C(PATH + FILE_NAME, cip.toByteArray());
                }
            }
        }
        AppMethodBeat.o(207845);
        return cip;
    }

    public static void aHn() {
        AppMethodBeat.i(207846);
        Log.i(TAG, "liveAnchorInfo cleanCache");
        cip cip = new cip();
        cip.hyH = 0;
        cip.MnB = "";
        cip.rotation = -1;
        cip.LpF = "";
        cip.Gaz = 0;
        cip.MnC = "";
        s.C(PATH + FILE_NAME, cip.toByteArray());
        AppMethodBeat.o(207846);
    }
}
