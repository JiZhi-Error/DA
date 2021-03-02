package com.tencent.mm.plugin.multitalk.d;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.q;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/utils/AppCmdUtil;", "", "()V", "closeHWDecoder", "", "sendIntCommand", "", FirebaseAnalytics.b.METHOD, "value", "sendOrientation", "ori", "setNeedBigVideo", "need", "", "memberId", "plugin-multitalk_release"})
public final class a {
    public static final a zYP = new a();

    static {
        AppMethodBeat.i(240091);
        AppMethodBeat.o(240091);
    }

    private a() {
    }

    public static void epL() {
        boolean z = false;
        AppMethodBeat.i(240088);
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putShort(0);
        allocate.putShort(8);
        allocate.putShort(0);
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        if (eom.enn() != null) {
            q eom2 = ac.eom();
            p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
            z = ac.eom().aFW(eom2.enn().hjv());
        }
        if (z) {
            com.tencent.mm.plugin.multitalk.b.p pVar = com.tencent.mm.plugin.multitalk.b.p.INSTANCE;
            com.tencent.mm.plugin.multitalk.b.p.f(39, allocate.array(), 6);
            AppMethodBeat.o(240088);
            return;
        }
        o eol = ac.eol();
        p.g(eol, "SubCoreMultiTalk.getMultiEngine()");
        eol.emG().setAppCmd(39, allocate.array(), 6);
        AppMethodBeat.o(240088);
    }

    public static int R(boolean z, int i2) {
        AppMethodBeat.i(240089);
        if (!z) {
            i2 = -1;
        }
        int hj = hj(22, i2);
        if (hj < 0) {
            AppMethodBeat.o(240089);
            return -1;
        }
        AppMethodBeat.o(240089);
        return hj;
    }

    public static int hj(int i2, int i3) {
        AppMethodBeat.i(240090);
        boolean z = false;
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        if (eom.enn() != null) {
            q eom2 = ac.eom();
            p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
            z = ac.eom().aFW(eom2.enn().hjv());
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(i3);
        if (z) {
            com.tencent.mm.plugin.multitalk.b.p pVar = com.tencent.mm.plugin.multitalk.b.p.INSTANCE;
            int f2 = com.tencent.mm.plugin.multitalk.b.p.f(i2, allocate.array(), 4);
            AppMethodBeat.o(240090);
            return f2;
        }
        o eol = ac.eol();
        p.g(eol, "SubCoreMultiTalk.getMultiEngine()");
        int appCmd = eol.emG().setAppCmd(i2, allocate.array(), 4);
        AppMethodBeat.o(240090);
        return appCmd;
    }
}
