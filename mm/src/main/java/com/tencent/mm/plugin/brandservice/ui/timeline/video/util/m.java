package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;

public final class m {
    private static WeakReference<m> pLK;
    public static final a pLL = new a((byte) 0);
    private final String TAG = "MicroMsg.MPDataReportHelper";
    public int height;
    public b pIL;
    public WeakReference<MPVideoView> pKJ;
    public int pLA;
    public int pLB;
    public int pLC;
    public String pLD = "";
    public boolean pLE;
    public boolean pLF = true;
    public int pLG;
    public int pLH;
    public int pLI = 1;
    private String pLJ = "";
    private final String pLz = ",";
    public int width;

    static {
        AppMethodBeat.i(179021);
        AppMethodBeat.o(179021);
    }

    public static final void DR(int i2) {
        AppMethodBeat.i(179022);
        a.DR(i2);
        AppMethodBeat.o(179022);
    }

    public final void L(LinkedList<gh> linkedList) {
        AppMethodBeat.i(7321);
        p.h(linkedList, "urlInfos");
        StringBuilder sb = new StringBuilder();
        Iterator<gh> it = linkedList.iterator();
        while (it.hasNext()) {
            gh next = it.next();
            if (sb.length() > 0) {
                sb.append(";");
            }
            sb.append(next.KKg);
        }
        String sb2 = sb.toString();
        p.g(sb2, "sb.toString()");
        this.pLJ = sb2;
        AppMethodBeat.o(7321);
    }

    public final void ff(int i2, int i3) {
        AppMethodBeat.i(7322);
        if (i2 < 0 || ((long) i2) > Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(7322);
            return;
        }
        er(i3, i2);
        if (this.pLF) {
            this.pLF = false;
            er(16, i2);
            Log.v(this.TAG, "[KEY_TIME] reportBuffering firstBuffering = ".concat(String.valueOf(i2)));
            AppMethodBeat.o(7322);
            return;
        }
        er(17, i2);
        AppMethodBeat.o(7322);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0290, code lost:
        if (r0 != null) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02ab, code lost:
        if (r0 != null) goto L_0x02b0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x033b  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void er(int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 878
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.er(int, int):void");
    }

    private final MPVideoView cpZ() {
        AppMethodBeat.i(7324);
        if (this.pKJ == null) {
            AppMethodBeat.o(7324);
            return null;
        }
        WeakReference<MPVideoView> weakReference = this.pKJ;
        if (weakReference != null) {
            MPVideoView mPVideoView = weakReference.get();
            AppMethodBeat.o(7324);
            return mPVideoView;
        }
        AppMethodBeat.o(7324);
        return null;
    }

    public static int DQ(int i2) {
        switch (i2) {
            case 0:
                return 3;
            case 1:
            case 2:
            default:
                return 4;
            case 3:
                return 9;
            case 4:
                return 10;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void DR(int i2) {
            m mVar;
            AppMethodBeat.i(179020);
            WeakReference weakReference = m.pLK;
            if (weakReference == null || (mVar = (m) weakReference.get()) == null) {
                AppMethodBeat.o(179020);
                return;
            }
            mVar.er(i2, 0);
            AppMethodBeat.o(179020);
        }
    }
}
