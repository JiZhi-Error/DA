package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public final class a implements cj.a {
    IListener FJi = new IListener<nz>() {
        /* class com.tencent.mm.plugin.subapp.jdbiz.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161439);
            this.__eventId = nz.class.getName().hashCode();
            AppMethodBeat.o(161439);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(nz nzVar) {
            AppMethodBeat.i(28863);
            nz nzVar2 = nzVar;
            if (!(nzVar2 instanceof nz)) {
                AppMethodBeat.o(28863);
            } else if (nzVar2.dUc.params == null || nzVar2.dUc.dUd == null || !"bizjd".equals(nzVar2.dUc.dUd)) {
                AppMethodBeat.o(28863);
            } else {
                String nullAs = Util.nullAs(nzVar2.dUc.params.getString("activity_id"), "");
                String nullAs2 = Util.nullAs(nzVar2.dUc.params.getString("jump_url"), "");
                h.INSTANCE.a(11179, nullAs2, d.fsQ().fsV().FJm, 4);
                c fsV = d.fsQ().fsV();
                if (!(fsV == null || fsV.FJm == null || !fsV.FJm.equals(nullAs))) {
                    d.fsQ();
                    d.fsU();
                    d.fsQ();
                    d.fsT();
                }
                EventCenter.instance.removeListener(a.this.FJi);
                AppMethodBeat.o(28863);
            }
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(28865);
        AppMethodBeat.o(28865);
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        boolean containsKey;
        AppMethodBeat.i(28866);
        Log.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
        de deVar = aVar.heO;
        if (deVar == null) {
            Log.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(28866);
            return;
        }
        final c cVar = new c();
        cVar.feed(z.a(deVar.KHn));
        Log.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + Util.nullAs(cVar.FJl, ""));
        if (Util.isNullOrNil(cVar.FJl)) {
            Log.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
        } else if (Util.isNullOrNil(cVar.FJm)) {
            Log.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
        } else if (!cVar.a(d.fsQ().fsV())) {
            Log.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
        } else if (!d.fsQ().fsY()) {
            Log.e("MicroMsg.JDSysMsgNotifyLsn", "no config entrance, ignore msg");
        } else if (cVar.FJl.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            deVar.KHr = null;
            if (Util.isNullOrNil(cVar.FJw) || Util.isNullOrNil(cVar.jumpUrl) || Util.isNullOrNil(cVar.FJx) || Util.isNullOrNil(cVar.FJy) || Util.isNullOrNil(cVar.FJv)) {
                Log.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
            } else if (cVar.dMp()) {
                Log.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            } else {
                d fsQ = d.fsQ();
                String str = cVar.FJm;
                if (Util.isNullOrNil(str)) {
                    containsKey = false;
                } else {
                    containsKey = fsQ.FJE.containsKey(str);
                }
                if (containsKey) {
                    Log.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + cVar.FJm);
                } else if (!cVar.a(d.fsQ().fsV())) {
                    Log.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
                } else {
                    d fsQ2 = d.fsQ();
                    String str2 = cVar.FJm;
                    if (!Util.isNullOrNil(str2)) {
                        fsQ2.FJE.put(str2, 1);
                    }
                    Log.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + cVar.FJm);
                    new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.mm.plugin.subapp.jdbiz.a.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(28864);
                            a aVar = a.this;
                            c cVar = cVar;
                            bg.aVF();
                            int intValue = ((Integer) c.azQ().get(15, (Object) 0)).intValue();
                            if (!bg.azz().foreground || 1 != intValue) {
                                String fO = d.fO(cVar.jumpUrl, 4);
                                Bundle bundle = new Bundle();
                                bundle.putString("activity_id", cVar.FJm);
                                bundle.putString("jump_url", fO);
                                ((ba) bg.getNotification()).a(37, MMApplicationContext.getContext().getString(R.string.y7), cVar.FJv, fO, "bizjd", bundle);
                                EventCenter.instance.addListener(aVar.FJi);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11178, fO, d.fsQ().fsV().FJm, 4);
                                AppMethodBeat.o(28864);
                                return;
                            }
                            String fO2 = d.fO(cVar.jumpUrl, 5);
                            JDRemindDialog.a(MMApplicationContext.getContext(), cVar.FJw, cVar.FJx, cVar.FJy, fO2, cVar.FJm);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11178, fO2, d.fsQ().fsV().FJm, 5);
                            AppMethodBeat.o(28864);
                        }
                    });
                }
            }
            d.b(cVar);
        } else if (cVar.FJl.equals("1")) {
            d.b(cVar);
        } else if (cVar.FJl.equals("2")) {
            d.b(cVar);
            String str3 = d.fsQ().ftd().username;
            if (Util.isNullOrNil(str3)) {
                str3 = d.fsQ().ftc();
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11178, str3, cVar.FJm, 3, 1);
        }
        bg.aVF();
        c.azQ().gBI();
        AppMethodBeat.o(28866);
    }
}
