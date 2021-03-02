package com.tencent.mm.plugin.handoff.c;

import android.os.Build;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.handoff.model.HandOffMG;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\f\u0010\t\u001a\u00020\u0004*\u0004\u0018\u00010\u0004J\f\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/BallHelper;", "", "()V", "TAG", "", "canDrawOverlays", "", "getAvailableActiveBallCount", "", "safeString", "toHandOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "plugin-handoff_release"})
public final class a {
    public static final a yhP = new a();

    static {
        AppMethodBeat.i(199150);
        AppMethodBeat.o(199150);
    }

    private a() {
    }

    public static final int dYp() {
        boolean z;
        AppMethodBeat.i(199148);
        if (ao.isMultiTaskMode()) {
            AppMethodBeat.o(199148);
            return 1000;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            z = Settings.canDrawOverlays(MMApplicationContext.getContext());
        } else {
            z = true;
        }
        if (z) {
            com.tencent.mm.kernel.c.a af = g.af(b.class);
            p.g(af, "MMKernel.service(IFloatBallService::class.java)");
            int size = 5 - d.cg(((b) af).chQ()).size();
            AppMethodBeat.o(199148);
            return size;
        }
        AppMethodBeat.o(199148);
        return -1;
    }

    private static String aBB(String str) {
        return str != null ? str : "";
    }

    public static HandOff f(MultiTaskInfo multiTaskInfo) {
        HandOffFile fromMultiTask;
        HandOffMG handOffMP;
        AppMethodBeat.i(199149);
        p.h(multiTaskInfo, "$this$toHandOff");
        try {
            cru cru = multiTaskInfo.field_showData;
            String aBB = aBB(cru != null ? cru.MwR : null);
            cru cru2 = multiTaskInfo.field_showData;
            String aBB2 = aBB(cru2 != null ? cru2.title : null);
            cru cru3 = multiTaskInfo.field_showData;
            String aBB3 = aBB(cru3 != null ? cru3.nickname : null);
            long j2 = multiTaskInfo.field_createTime;
            switch (multiTaskInfo.field_type) {
                case 1:
                    er erVar = new er();
                    erVar.parseFrom(multiTaskInfo.field_data);
                    if (erVar.cyo == 4) {
                        String aBB4 = aBB(erVar.appId);
                        String aBB5 = aBB(erVar.username);
                        String str = multiTaskInfo.field_id;
                        p.g(str, "field_id");
                        handOffMP = new HandOffMG(aBB, aBB3, aBB4, "", aBB5, 2, null, null, str, 192, null);
                    } else {
                        String aBB6 = aBB(erVar.appId);
                        String aBB7 = aBB(erVar.username);
                        String str2 = multiTaskInfo.field_id;
                        p.g(str2, "field_id");
                        handOffMP = new HandOffMP(aBB, aBB3, aBB6, "", aBB7, 2, null, null, str2, 192, null);
                    }
                    fromMultiTask = handOffMP;
                    break;
                case 2:
                    fah fah = new fah();
                    fah.parseFrom(multiTaskInfo.field_data);
                    String str3 = fah.Nwh;
                    String aBB8 = !(str3 == null || n.aL(str3)) ? fah.Nwh : aBB(fah.edo);
                    p.g(aBB8, "showUrl");
                    String str4 = multiTaskInfo.field_id;
                    p.g(str4, "field_id");
                    HandOffURL handOffURL = new HandOffURL(aBB2, aBB8, aBB, 2, null, null, str4, 48, null);
                    handOffURL.setNickname(aBB3);
                    fromMultiTask = handOffURL;
                    break;
                case 3:
                default:
                    fromMultiTask = null;
                    break;
                case 4:
                    HandOffFile.a aVar = HandOffFile.Companion;
                    fromMultiTask = HandOffFile.a.fromMultiTask(multiTaskInfo);
                    break;
            }
            if (fromMultiTask != null) {
                String str5 = multiTaskInfo.field_id;
                p.g(str5, "field_id");
                fromMultiTask.setKey(str5);
                fromMultiTask.setCreateTime(j2);
                AppMethodBeat.o(199149);
                return fromMultiTask;
            }
            AppMethodBeat.o(199149);
            return null;
        } catch (Exception e2) {
            Log.e("MicroMsg.BallHelper", "parse multiTaskInfo[id:" + multiTaskInfo.field_id + ", type:" + multiTaskInfo.field_type + "] fail:" + e2.getLocalizedMessage());
            AppMethodBeat.o(199149);
            return null;
        }
    }
}
