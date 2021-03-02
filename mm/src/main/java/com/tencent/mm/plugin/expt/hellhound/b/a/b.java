package com.tencent.mm.plugin.expt.hellhound.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellResponseDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class b {
    public static final a sJM = new a((byte) 0);

    static {
        AppMethodBeat.i(221173);
        AppMethodBeat.o(221173);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellResponseDao$Companion;", "", "()V", "FLAG_DEL", "", "MMKV_KEY", "", "TAG", "_doSetResp", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "getConfigIds", "", "Lcom/tencent/mm/protocal/protobuf/ConfigId;", "read", "reset", "setResp", "write", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boj cRe() {
            AppMethodBeat.i(221172);
            byte[] bytes = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_resp_mkv_key");
            if (bytes != null) {
                if (!(bytes.length == 0)) {
                    boj boj = new boj();
                    try {
                        boj.parseFrom(bytes);
                        AppMethodBeat.o(221172);
                        return boj;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.HellResponseDao", e2, "HellResponseDao, read: " + e2.getMessage(), new Object[0]);
                        AppMethodBeat.o(221172);
                        return null;
                    }
                }
            }
            AppMethodBeat.o(221172);
            return null;
        }
    }
}
