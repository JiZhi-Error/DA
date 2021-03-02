package com.tencent.mm.plugin.multitask.ui.minusscreen.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitask.f.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/helper/MultiTaskManager;", "", "()V", "Companion", "ui-multitask_release"})
public final class a {
    public static final C1527a Aeo = new C1527a((byte) 0);
    private static final String TAG = TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/helper/MultiTaskManager$Companion;", "", "()V", "EVENTDATA", "", "EVENTTYPE", "TAG", "getTAG", "()Ljava/lang/String;", "convertBallInfo2MultiTaskInfo", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "extraBallInfo", "Landroid/os/Bundle;", "ui-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.ui.minusscreen.c.a$a  reason: collision with other inner class name */
    public static final class C1527a {
        private C1527a() {
        }

        public /* synthetic */ C1527a(byte b2) {
            this();
        }

        public static void a(MultiTaskInfo multiTaskInfo, BallInfo ballInfo, Bundle bundle) {
            AppMethodBeat.i(258183);
            p.h(multiTaskInfo, "multiTaskInfo");
            p.h(ballInfo, "ballInfo");
            p.h(bundle, "extraBallInfo");
            try {
                switch (ballInfo.type) {
                    case 1:
                        er erVar = new er();
                        erVar.appId = ballInfo.jkf.getString("appId");
                        erVar.username = ballInfo.jkf.getString(ch.COL_USERNAME);
                        erVar.iOo = ballInfo.jkf.getInt("versionType");
                        multiTaskInfo.field_data = erVar.toByteArray();
                        cru cru = multiTaskInfo.field_showData;
                        if (cru != null) {
                            cru.MwR = ballInfo.icon;
                        }
                        cru cru2 = multiTaskInfo.field_showData;
                        if (cru2 != null) {
                            cru2.nickname = ballInfo.name;
                            AppMethodBeat.o(258183);
                            return;
                        }
                        AppMethodBeat.o(258183);
                        return;
                    case 2:
                        fah fah = new fah();
                        b.a(bundle, fah);
                        multiTaskInfo.field_data = fah.toByteArray();
                        AppMethodBeat.o(258183);
                        return;
                    case 3:
                        String string = bundle.getString("eventData");
                        int i2 = bundle.getInt("eventType");
                        ctx ctx = new ctx();
                        ctx.Mzh = string;
                        ctx.dRq = i2;
                        multiTaskInfo.field_data = ctx.toByteArray();
                        AppMethodBeat.o(258183);
                        return;
                    case 4:
                        aoe aoe = new aoe();
                        b.a(bundle, aoe);
                        multiTaskInfo.field_showData.gCr = aoe.gCr;
                        multiTaskInfo.field_showData.title = ballInfo.name;
                        multiTaskInfo.field_data = aoe.toByteArray();
                        AppMethodBeat.o(258183);
                        return;
                    case 5:
                        fah fah2 = new fah();
                        b.a(bundle, fah2);
                        multiTaskInfo.field_data = fah2.toByteArray();
                        AppMethodBeat.o(258183);
                        return;
                    case 8:
                        multiTaskInfo.field_data = bundle.getByteArray("key_context");
                        AppMethodBeat.o(258183);
                        return;
                    case 22:
                        multiTaskInfo.field_data = ballInfo.getByteArrayExtra("KEY_FLOAT_BALL_INFO");
                        multiTaskInfo.erh().title = ballInfo.name;
                        multiTaskInfo.erh().MwR = ballInfo.icon;
                        AppMethodBeat.o(258183);
                        return;
                    default:
                        AppMethodBeat.o(258183);
                        return;
                }
            } catch (Throwable th) {
                Log.printErrStackTrace(a.TAG, th, "convertBallInfo2MultiTaskInfo", new Object[0]);
                AppMethodBeat.o(258183);
            }
        }
    }

    static {
        AppMethodBeat.i(236503);
        AppMethodBeat.o(236503);
    }
}
