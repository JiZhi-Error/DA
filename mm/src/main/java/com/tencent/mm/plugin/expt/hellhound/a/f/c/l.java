package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.IOException;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPairDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class l {
    public static final a sIL = new a((byte) 0);

    static {
        AppMethodBeat.i(221126);
        AppMethodBeat.o(221126);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\u000e\u001a\u00020\tH\u0007J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPairDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionPair;", "_write", "", "pair", "get", SharePatchInfo.FINGER_PRINT, "sessionPair", "reset", "setCurSession", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "setCurUnKnown", "page", "Lcom/tencent/mm/protocal/protobuf/Page;", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static void a(dvl dvl) {
            AppMethodBeat.i(221124);
            if (dvl == null) {
                AppMethodBeat.o(221124);
                return;
            }
            try {
                byte[] byteArray = dvl.toByteArray();
                if (byteArray == null) {
                    AppMethodBeat.o(221124);
                    return;
                }
                b.o("mmkv_sionpairD_table_hell", byteArray);
                AppMethodBeat.o(221124);
            } catch (IOException e2) {
                Log.printErrStackTrace("HABBYGE-MALI.SessionPairDao", e2, "SessionPair, _write: %s", e2.getMessage());
                AppMethodBeat.o(221124);
            }
        }

        static dvl cQE() {
            AppMethodBeat.i(221125);
            byte[] bytes = b.getBytes("mmkv_sionpairD_table_hell");
            if (bytes != null) {
                if (!(bytes.length == 0)) {
                    dvl dvl = new dvl();
                    try {
                        dvl.parseFrom(bytes);
                        AppMethodBeat.o(221125);
                        return dvl;
                    } catch (IOException e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.SessionPairDao", e2, "SessionPair, _read: %s", e2.getMessage());
                        AppMethodBeat.o(221125);
                        return null;
                    }
                }
            }
            AppMethodBeat.o(221125);
            return null;
        }
    }

    public static final void o(cyl cyl) {
        AppMethodBeat.i(221127);
        if (cyl == null) {
            AppMethodBeat.o(221127);
            return;
        }
        int cNT = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cNT();
        if (cNT == 7 || cNT == 8) {
            Log.i("HABBYGE-MALI.SessionPairDao", "setCurSession, activityMethod: ".concat(String.valueOf(cNT)));
            AppMethodBeat.o(221127);
            return;
        }
        dvl cQE = a.cQE();
        if (cQE == null) {
            cQE = new dvl();
        }
        if (cQE.MWx) {
            cQE.MWs = cQE.MWu;
        } else {
            cQE.MWt = cQE.MWv;
        }
        cQE.MWw = cQE.MWx;
        cQE.MWx = true;
        cQE.MWu = cyl;
        a.a(cQE);
        AppMethodBeat.o(221127);
    }

    public static final void c(cyh cyh) {
        AppMethodBeat.i(221128);
        dvl cQE = a.cQE();
        if (cQE == null) {
            cQE = new dvl();
        }
        if (cQE.MWx) {
            cQE.MWs = cQE.MWu;
        } else {
            cQE.MWt = cQE.MWv;
        }
        cQE.MWw = cQE.MWx;
        cQE.MWx = false;
        cQE.MWv = cyh;
        a.a(cQE);
        AppMethodBeat.o(221128);
    }

    public static final dvl cQD() {
        AppMethodBeat.i(221129);
        dvl cQE = a.cQE();
        AppMethodBeat.o(221129);
        return cQE;
    }

    public static final void reset() {
        AppMethodBeat.i(221130);
        b.o("mmkv_sionpairD_table_hell", new byte[0]);
        AppMethodBeat.o(221130);
    }
}
