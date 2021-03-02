package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.f.e.a;
import com.tencent.f.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.contact.ad;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;

public final class f implements d {
    @Override // com.tencent.mm.plugin.messenger.a.d
    public final void ad(String str, String str2, int i2) {
        AppMethodBeat.i(39447);
        if (str == null || str2 == null) {
            Log.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", str, str2);
            AppMethodBeat.o(39447);
            return;
        }
        o.e Pl = o.Pl(str);
        Pl.toUser = str;
        Pl.content = str2;
        o.e tD = Pl.tD(i2);
        tD.cSx = 0;
        tD.jdR = 4;
        tD.bdQ().execute();
        AppMethodBeat.o(39447);
    }

    @Override // com.tencent.mm.plugin.messenger.a.d
    public final void a(Context context, String str, String str2, String str3, int i2, int i3, String str4, String str5) {
        AppMethodBeat.i(163391);
        a(context, str, str2, str3, i2, i3, null, str4, str5, null);
        AppMethodBeat.o(163391);
    }

    @Override // com.tencent.mm.plugin.messenger.a.d
    public final void a(Context context, String str, String str2, String str3, int i2, String str4, String str5, d.a aVar) {
        AppMethodBeat.i(234534);
        a(context, str, str2, str3, 1, i2, null, str4, str5, aVar);
        AppMethodBeat.o(234534);
    }

    @Override // com.tencent.mm.plugin.messenger.a.d
    public final void a(Context context, String str, String str2, String str3, int i2, int i3, eeq eeq, String str4, String str5) {
        AppMethodBeat.i(163392);
        a(context, str, str2, str3, i2, i3, eeq, str4, str5, null);
        AppMethodBeat.o(163392);
    }

    private void a(Context context, String str, String str2, String str3, int i2, int i3, eeq eeq, String str4, String str5, d.a aVar) {
        AppMethodBeat.i(234535);
        if (context == null) {
            Log.w("MicroMsg.SendMsgMgr", "send vedio context is null");
            AppMethodBeat.o(234535);
        } else if (str == null || str2 == null) {
            Log.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", str, str2);
            AppMethodBeat.o(234535);
        } else {
            bg.aVF();
            if (!c.isSDCardAvailable()) {
                Log.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
                e.eD(context).hmq().a(new a<Context, Object>() {
                    /* class com.tencent.mm.ui.transmit.f.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.f.e.a
                    public final /* synthetic */ Object bT(Context context) {
                        AppMethodBeat.i(180112);
                        Toast.makeText(context, (int) R.string.f4n, 1).show();
                        AppMethodBeat.o(180112);
                        return null;
                    }
                });
                AppMethodBeat.o(234535);
                return;
            }
            final MsgRetransmitUI.a aVar2 = new MsgRetransmitUI.a();
            aVar2.context = context;
            aVar2.fileName = str2;
            aVar2.QyR = str3;
            aVar2.tipDialog = (Dialog) e.eD(context).hmq().a(new a<Context, Dialog>() {
                /* class com.tencent.mm.ui.transmit.f.AnonymousClass2 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.f.e.a
                public final /* synthetic */ Dialog bT(Context context) {
                    AppMethodBeat.i(180113);
                    Context context2 = context;
                    context2.getResources().getString(R.string.zb);
                    q a2 = h.a(context2, context2.getResources().getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.ui.transmit.f.AnonymousClass2.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            aVar2.QyQ = true;
                        }
                    });
                    AppMethodBeat.o(180113);
                    return a2;
                }
            }).take();
            aVar2.userName = str;
            aVar2.ean = str4;
            aVar2.QyU = false;
            if (62 == i2) {
                aVar2.jqs = 11;
            }
            aVar2.Qyk = i2 > 0 ? 1 : 0;
            aVar2.iFw = i3;
            aVar2.QyS = false;
            aVar2.QyV = eeq;
            aVar2.jsz = str5;
            aVar2.QyY = aVar;
            aVar2.execute(new Object[0]);
            AppMethodBeat.o(234535);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.a.d
    public final void a(final Context context, String str, String str2, int i2, String str3, String str4, long j2, String str5) {
        AppMethodBeat.i(163393);
        if (str == null || str2 == null) {
            Log.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", str, str2);
            AppMethodBeat.o(163393);
            return;
        }
        bg.aVF();
        if (!c.isSDCardAvailable()) {
            Log.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.transmit.f.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(180114);
                    Toast.makeText(context, (int) R.string.f4n, 1).show();
                    AppMethodBeat.o(180114);
                }
            });
            AppMethodBeat.o(163393);
            return;
        }
        String aTY = z.aTY();
        o.e tc = o.a(o.d.jdL).tc(4);
        tc.dRL = aTY;
        tc.toUser = str;
        tc.iZt = str2;
        tc.iXp = i2;
        tc.jdS = null;
        tc.dQd = 0;
        tc.iXy = str3;
        tc.thumbPath = str4;
        tc.jdV = true;
        tc.jdU = R.drawable.c3h;
        tc.jdW = j2;
        tc.jdY = str5;
        tc.jdR = 13;
        tc.bdQ().execute();
        cf.aWl().f(cf.iFI, null);
        AppMethodBeat.o(163393);
    }

    @Override // com.tencent.mm.plugin.messenger.a.d
    public final void a(String str, byte[] bArr, String str2, String str3) {
        AppMethodBeat.i(39451);
        if (str == null) {
            Log.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
            AppMethodBeat.o(39451);
            return;
        }
        Log.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", str2);
        k.b HD = k.b.HD(Util.processXml(str2));
        if (HD == null) {
            Log.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
            AppMethodBeat.o(39451);
            return;
        }
        com.tencent.mm.pluginsdk.model.app.c cVar = new com.tencent.mm.pluginsdk.model.app.c();
        Log.i("MicroMsg.SendMsgMgr", "content.attachid %s", HD.dCK);
        if (!Util.isNullOrNil(HD.dCK)) {
            long j2 = Util.getLong(HD.dCK, -1);
            if (j2 != -1) {
                ao.cgO().get(j2, cVar);
                if (cVar.systemRowid != j2) {
                    cVar = ao.cgO().bdx(HD.dCK);
                    if (cVar == null || !cVar.field_mediaSvrId.equals(HD.dCK)) {
                        cVar = null;
                    }
                    if (cVar == null) {
                        Log.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", HD.dCK);
                    } else {
                        Log.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", HD.dCK, Long.valueOf(cVar.systemRowid), cVar.field_fileFullPath);
                    }
                }
            } else {
                cVar = ao.cgO().bdx(HD.dCK);
                if (cVar == null || !cVar.field_mediaSvrId.equals(HD.dCK)) {
                    cVar = null;
                }
                if (cVar == null) {
                    Log.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", HD.dCK);
                } else {
                    Log.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", HD.dCK, Long.valueOf(cVar.systemRowid), cVar.field_fileFullPath);
                }
            }
        }
        String str4 = "";
        if (!(cVar == null || cVar.field_fileFullPath == null || cVar.field_fileFullPath.equals(""))) {
            bg.aVF();
            str4 = m.aB(c.aTg(), HD.title, HD.iwJ);
            s.nw(cVar.field_fileFullPath, str4);
            Log.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", cVar.field_fileFullPath, str4, Long.valueOf(s.boW(cVar.field_fileFullPath)));
        }
        k.b a2 = k.b.a(HD);
        a2.iwL = 3;
        com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) a2.as(com.tencent.mm.ag.a.class);
        if (aVar != null) {
            aVar.ivq = false;
        }
        m.a(a2, HD.appId, HD.appName, str, str4, bArr, str3);
        AppMethodBeat.o(39451);
    }

    @Override // com.tencent.mm.plugin.messenger.a.d
    public final void s(String str, String str2, boolean z) {
        AppMethodBeat.i(39452);
        if (z) {
            String nullAs = Util.nullAs(str2, "");
            String bnD = ad.bnD(str);
            o.e Pl = o.Pl(nullAs);
            Pl.toUser = nullAs;
            Pl.content = bnD;
            o.e tD = Pl.tD(as.bjp(str) ? 66 : 42);
            tD.cSx = 0;
            tD.jdR = 4;
            tD.bdQ().execute();
            AppMethodBeat.o(39452);
            return;
        }
        ArrayList<String> stringsToList = Util.stringsToList(Util.nullAs(str2, "").split(","));
        String bnD2 = ad.bnD(str);
        for (int i2 = 0; i2 < stringsToList.size(); i2++) {
            String str3 = stringsToList.get(i2);
            o.e Pl2 = o.Pl(str3);
            Pl2.toUser = str3;
            Pl2.content = bnD2;
            o.e tD2 = Pl2.tD(as.bjp(str) ? 66 : 42);
            tD2.cSx = 0;
            tD2.jdR = 4;
            tD2.bdQ().execute();
        }
        AppMethodBeat.o(39452);
    }

    @Override // com.tencent.mm.plugin.messenger.a.d
    public final void e(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(234536);
        if (z) {
            String nullAs = Util.nullAs(str2, "");
            o.e Pl = o.Pl(nullAs);
            Pl.toUser = nullAs;
            Pl.content = str3;
            o.e tD = Pl.tD(as.bjp(str) ? 66 : 42);
            tD.cSx = 0;
            tD.jdR = 4;
            tD.bdQ().execute();
            AppMethodBeat.o(234536);
            return;
        }
        ArrayList<String> stringsToList = Util.stringsToList(Util.nullAs(str2, "").split(","));
        for (int i2 = 0; i2 < stringsToList.size(); i2++) {
            String str4 = stringsToList.get(i2);
            o.e Pl2 = o.Pl(str4);
            Pl2.toUser = str4;
            Pl2.content = str3;
            o.e tD2 = Pl2.tD(as.bjp(str) ? 66 : 42);
            tD2.cSx = 0;
            tD2.jdR = 4;
            tD2.bdQ().execute();
        }
        AppMethodBeat.o(234536);
    }

    @Override // com.tencent.mm.plugin.messenger.a.d
    public final void iF(String str, String str2) {
        AppMethodBeat.i(39453);
        ArrayList<String> stringsToList = Util.stringsToList(Util.nullAs(str2, "").split(","));
        if (!TextUtils.isEmpty(str)) {
            for (String str3 : stringsToList) {
                tw twVar = new tw();
                twVar.eaq.dkV = str3;
                twVar.eaq.content = str;
                twVar.eaq.type = ab.JG(str3);
                twVar.eaq.flags = 0;
                EventCenter.instance.publish(twVar);
            }
        }
        AppMethodBeat.o(39453);
    }
}
