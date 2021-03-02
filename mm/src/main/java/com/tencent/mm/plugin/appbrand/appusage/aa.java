package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.protocal.protobuf.ech;
import com.tencent.mm.protocal.protobuf.emq;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.List;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\t\nB\u001d\b\u0010\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "opList", "", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "opReason", "", "(Ljava/util/List;I)V", "Companion", "UpdateReason", "plugin-appbrand-integration_release"})
public final class aa extends c<emr> {
    private static final int[] kVH = {1, 2, 3, 4};
    public static final a kVI = new a((byte) 0);

    public static final ech a(ecg ecg) {
        AppMethodBeat.i(50290);
        ech a2 = a.a(ecg);
        AppMethodBeat.o(50290);
        return a2;
    }

    public static final ech a(ecg ecg, ecg ecg2) {
        AppMethodBeat.i(261641);
        ech a2 = a.a(ecg, null, ecg2);
        AppMethodBeat.o(261641);
        return a2;
    }

    public aa(List<? extends ech> list, int i2) {
        p.h(list, "opList");
        AppMethodBeat.i(50287);
        if (a.byt()) {
            boolean z = !list.isEmpty() && e.contains(kVH, i2);
            if (kotlin.aa.SXc && !z) {
                AssertionError assertionError = new AssertionError("Assertion failed");
                AppMethodBeat.o(50287);
                throw assertionError;
            }
        }
        d.a aVar = new d.a();
        aVar.d(new emr());
        aVar.MB("/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord");
        aVar.sG(1839);
        emq emq = new emq();
        emq.NkN.addAll(list);
        emq.bDZ = i2;
        aVar.c(emq);
        c(aVar.aXF());
        AppMethodBeat.o(50287);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "None", "Timeout", "ClosePullDown", "CloseCollectionList", "History", "plugin-appbrand-integration_release"})
    public enum b {
        None(0),
        Timeout(1),
        ClosePullDown(2),
        CloseCollectionList(3),
        History(4);
        
        final int intValue;

        public static b valueOf(String str) {
            AppMethodBeat.i(50286);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(50286);
            return bVar;
        }

        private b(int i2) {
            this.intValue = i2;
        }

        static {
            AppMethodBeat.i(50284);
            AppMethodBeat.o(50284);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J$\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0007J0\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$Companion;", "", "()V", "UpdateWxaRecordReason_CloseStarList", "", "UpdateWxaRecordReason_CloseTask", "UpdateWxaRecordReason_FromHistory", "UpdateWxaRecordReason_Timeout", "legalReasons", "", "add", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "self", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "prev", "next", "checkParams", "", "delete", "move", "op", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static boolean byt() {
            return BuildInfo.IS_FLAVOR_RED;
        }

        public static ech a(ecg ecg, ecg ecg2, ecg ecg3) {
            AppMethodBeat.i(50281);
            p.h(ecg, "self");
            ech a2 = a(1, ecg, ecg2, ecg3);
            AppMethodBeat.o(50281);
            return a2;
        }

        private static ech a(int i2, ecg ecg, ecg ecg2, ecg ecg3) {
            AppMethodBeat.i(50283);
            ech ech = new ech();
            ech.Ncw = ecg;
            ech.Ncz = i2;
            ech.Ncx = ecg2;
            ech.Ncy = ecg3;
            AppMethodBeat.o(50283);
            return ech;
        }

        public static ech a(ecg ecg) {
            AppMethodBeat.i(50282);
            p.h(ecg, "self");
            ech a2 = a(2, ecg, null, null);
            AppMethodBeat.o(50282);
            return a2;
        }
    }

    static {
        AppMethodBeat.i(50288);
        AppMethodBeat.o(50288);
    }
}
