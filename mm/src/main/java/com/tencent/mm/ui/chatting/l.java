package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.z;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.d.m;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class l {
    private static a Pgw = new a((byte) 0);

    static /* synthetic */ boolean c(Context context, List list, boolean z, String str, z zVar) {
        AppMethodBeat.i(232870);
        boolean b2 = b(context, list, z, str, zVar);
        AppMethodBeat.o(232870);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        boolean Pdm;
        List<ca> PgD;
        d PgE;
        z Pgm;
        cz dWX;
        String from;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(34453);
        AppMethodBeat.o(34453);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0286, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(final android.content.Context r11, final java.util.List<com.tencent.mm.storage.ca> r12, final boolean r13, final java.lang.String r14, final com.tencent.mm.ag.z r15) {
        /*
        // Method dump skipped, instructions count: 713
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.l.a(android.content.Context, java.util.List, boolean, java.lang.String, com.tencent.mm.ag.z):boolean");
    }

    private static void e(Context context, List<ca> list) {
        AppMethodBeat.i(34444);
        for (ca caVar : list) {
            if (br.B(caVar)) {
                switch (caVar.getType() & 65535) {
                    case 1:
                        caVar.setContent(context.getString(R.string.z_));
                        break;
                    case 3:
                        caVar.setContent(context.getString(R.string.xr));
                        caVar.setType(1);
                        break;
                    case 43:
                        caVar.setContent(context.getString(R.string.zv));
                        caVar.setType(1);
                        break;
                    case 49:
                        caVar.setContent(context.getString(R.string.zj));
                        caVar.setType(1);
                        break;
                    case 536936497:
                        caVar.setContent(context.getString(R.string.zj));
                        caVar.setType(1);
                        break;
                }
                br.L(caVar);
            }
        }
        AppMethodBeat.o(34444);
    }

    private static boolean b(Context context, List<ca> list, boolean z, String str, final z zVar) {
        int i2;
        String R;
        int i3;
        AppMethodBeat.i(232866);
        if (k.jj(list)) {
            h.a(context, context.getString(R.string.bin), "", context.getString(R.string.f3148e), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.l.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(232860);
                    if (zVar != null) {
                        zVar.a(z.a.trans);
                    }
                    AppMethodBeat.o(232860);
                }
            });
            AppMethodBeat.o(232866);
            return false;
        }
        e(context, list);
        Pgw.PgD = new LinkedList(list);
        Pgw.Pdm = z;
        Pgw.Pgm = zVar;
        Pgw.from = str;
        Intent intent = new Intent(context, MsgRetransmitUI.class);
        if (zVar != null && zVar.aSE()) {
            intent.putExtra("Retr_MsgFromMoreSelectRetransmit", true);
        }
        if (list.size() == 1) {
            ca caVar = list.get(0);
            if (caVar.dOQ() || caVar.gAt()) {
                String JX = ad.JX(new StringBuilder().append(caVar.field_msgSvrId).toString());
                ad.b G = ad.aVe().G(JX, true);
                G.l("prePublishId", "msg_" + caVar.field_msgSvrId);
                G.l("preUsername", c.a(caVar, z, false));
                G.l("preChatName", caVar.field_talker);
                G.l("preMsgIndex", 0);
                G.l("sendAppMsgScene", 1);
                G.l("moreRetrAction", Boolean.TRUE);
                if (z) {
                    G.l("fromScene", 2);
                } else {
                    G.l("fromScene", 1);
                }
                ((j) g.af(j.class)).a("adExtStr", G, caVar);
                intent.putExtra("reportSessionId", JX);
            }
            String str2 = caVar.field_content;
            int i4 = 12;
            if (caVar.dOS()) {
                i4 = 9;
            } else if (caVar.gDn()) {
                i4 = 5;
                intent.putExtra("Retr_File_Name", caVar.field_imgPath);
            } else if (caVar.gDl()) {
                i4 = 8;
            } else if (caVar.isText()) {
                i4 = 4;
                if (z && caVar.field_isSend == 0) {
                    str2 = bp.Kt(str2);
                }
            } else if (caVar.gAz()) {
                com.tencent.mm.av.g gVar = null;
                if (caVar.field_msgId > 0) {
                    gVar = q.bcR().H(caVar.field_talker, caVar.field_msgId);
                }
                if ((gVar == null || gVar.localId <= 0) && caVar.field_msgSvrId > 0) {
                    gVar = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
                }
                if (gVar.offset < gVar.iKP || gVar.iKP == 0) {
                    R = q.bcR().R(caVar.field_imgPath, true);
                } else {
                    R = q.bcR().o(com.tencent.mm.av.h.c(gVar), "", "");
                }
                intent.putExtra("Retr_File_Name", R);
                i4 = 0;
            } else if (caVar.cWL()) {
                s QN = u.QN(caVar.field_imgPath);
                if (QN != null) {
                    intent.putExtra("Retr_length", QN.iFw);
                }
                i4 = 11;
                intent.putExtra("Retr_File_Name", caVar.field_imgPath);
            } else if (caVar.cWJ()) {
                s QN2 = u.QN(caVar.field_imgPath);
                if (QN2 != null) {
                    intent.putExtra("Retr_length", QN2.iFw);
                }
                i4 = 1;
                intent.putExtra("Retr_File_Name", caVar.field_imgPath);
            } else if (caVar.cWK()) {
                i4 = 1;
            } else if (caVar.dOQ()) {
                k.b HD = k.b.HD(str2);
                if (HD != null && 71 == HD.type) {
                    i4 = 26;
                } else if (HD != null && 73 == HD.type) {
                    i4 = 22;
                } else if (HD != null && 51 == HD.type) {
                    i4 = 18;
                } else if (HD != null && 19 == HD.type) {
                    i4 = 10;
                } else if (HD != null && 24 == HD.type) {
                    i4 = 10;
                } else if (HD != null && 16 == HD.type) {
                    i4 = 14;
                } else if (HD == null || 63 != HD.type) {
                    if (HD != null && 75 == HD.type) {
                        switch (com.tencent.mm.plugin.i.a.l.d(HD.izF, HD.izD)) {
                            case 2:
                                i4 = 28;
                                break;
                            case 3:
                                i4 = 27;
                                break;
                        }
                    } else {
                        i4 = 2;
                    }
                } else {
                    i4 = 23;
                }
                if (caVar.gAt()) {
                    intent.putExtra("is_group_chat", z);
                }
            }
            if (caVar.gAt()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            if (zVar == null || zVar.aSC()) {
                intent.putExtra("Retr_Msg_Type", i4);
            } else {
                intent.putExtra("Retr_Msg_Type", 13);
                intent.putExtra("Retr_Multi_Msg_List_from", str);
            }
            intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
            intent.putExtra("Retr_Msg_content", str2);
            intent.putExtra("Edit_Mode_Sigle_Msg", true);
            i2 = i3;
        } else if ((zVar == null || !zVar.aSC()) && ((!ab.IT(str) || com.tencent.mm.al.g.DQ(str)) && !ab.JF(str))) {
            intent.putExtra("Retr_Msg_Type", 13);
            intent.putExtra("Retr_Multi_Msg_List_from", str);
            i2 = 2;
        } else {
            intent.putExtra("Retr_Msg_Type", 12);
            i2 = 2;
        }
        intent.putExtra("Retr_MsgFromScene", i2);
        intent.putExtra("Retr_show_success_tips", true);
        if (zVar == null || !zVar.aSD()) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        m.jl(Pgw.PgD);
        if (zVar != null && zVar.aSD()) {
            zVar.B(intent.getExtras());
        }
        AppMethodBeat.o(232866);
        return true;
    }

    public static int gNw() {
        AppMethodBeat.i(232867);
        if (Pgw.PgD != null) {
            int size = Pgw.PgD.size();
            AppMethodBeat.o(232867);
            return size;
        }
        AppMethodBeat.o(232867);
        return 0;
    }

    public static Pair<Long, Boolean> m(Context context, String str, boolean z) {
        AppMethodBeat.i(232868);
        Pair<Long, Boolean> c2 = c(context, str, z, str);
        AppMethodBeat.o(232868);
        return c2;
    }

    public static Pair<Long, Boolean> c(Context context, String str, boolean z, String str2) {
        f fVar;
        AppMethodBeat.i(232869);
        rc rcVar = new rc();
        rcVar.dXF.type = 5;
        rcVar.dXF.dXK = Pgw.PgD;
        rcVar.dXF.toUser = str;
        rcVar.dXF.from = Pgw.from;
        rcVar.dXF.context = context;
        rcVar.dXF.dWX = Pgw.dWX;
        rcVar.dXF.dXM = Pgw.PgE;
        rcVar.dXF.dXO = str2;
        EventCenter.instance.publish(rcVar);
        if (Pgw.PgD != null) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10811, 8, Integer.valueOf(Pgw.PgD.size()), Integer.valueOf(Pgw.PgD.size() - k.jh(Pgw.PgD)));
            LinkedList linkedList = new LinkedList();
            for (ca caVar : Pgw.PgD) {
                long nowSecond = Util.nowSecond();
                k.b HD = k.b.HD(Util.processXml(caVar.field_content));
                if (HD != null && HD.type == 5 && !Util.isNullOrNil(HD.url)) {
                    int i2 = caVar.gAt() ? 1 : 2;
                    String str3 = "";
                    try {
                        str3 = URLEncoder.encode(HD.url, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    } catch (UnsupportedEncodingException e2) {
                        Log.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e2, "", new Object[0]);
                    }
                    Log.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", 13378, HD.url, Long.valueOf(nowSecond), Integer.valueOf(i2), 1, 1);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13378, str3, Long.valueOf(nowSecond), Integer.valueOf(i2), 1, 1);
                } else if (!(HD == null || HD.type != 51 || (fVar = (f) HD.as(f.class)) == null)) {
                    linkedList.add(new Pair(fVar.jlg.objectId, fVar.jlg.objectNonceId));
                }
            }
            if (linkedList.size() > 0) {
                ((aj) g.ah(aj.class)).shareStatsReport(linkedList, false);
            }
        }
        if (z && Pgw.Pgm != null) {
            Pgw.Pgm.c(z.a.trans);
        }
        Pair<Long, Boolean> pair = new Pair<>(Long.valueOf(rcVar.dXG.msgId), Boolean.valueOf(rcVar.dXG.dXS));
        AppMethodBeat.o(232869);
        return pair;
    }

    public static void BM(boolean z) {
        AppMethodBeat.i(34447);
        if (z && Pgw.Pgm != null) {
            Pgw.Pgm.c(z.a.trans);
        }
        AppMethodBeat.o(34447);
    }

    public static rc ki(Context context) {
        AppMethodBeat.i(34448);
        rc rcVar = new rc();
        rcVar.dXF.type = 10;
        rcVar.dXF.dXK = Pgw.PgD;
        rcVar.dXF.from = Pgw.from;
        rcVar.dXF.context = context;
        EventCenter.instance.publish(rcVar);
        Pgw.dWX = rcVar.dXG.dWX;
        Pgw.PgE = rcVar.dXG.dXM;
        AppMethodBeat.o(34448);
        return rcVar;
    }

    public static boolean gNx() {
        AppMethodBeat.i(34449);
        if (Pgw.PgD == null || Pgw.PgD.isEmpty()) {
            AppMethodBeat.o(34449);
            return false;
        }
        for (ca caVar : Pgw.PgD) {
            bg.aVF();
            ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(caVar.field_content);
            if (aEK.dkU == null || aEK.dkU.length() <= 0) {
                Log.e("MicroMsg.ChattingEditModeRetransmitMsg", "getView : parse possible friend msg failed");
            }
            if (!ab.rR(aEK.IOs) && caVar.getType() == 42 && caVar.gDD()) {
                AppMethodBeat.o(34449);
                return true;
            }
        }
        AppMethodBeat.o(34449);
        return false;
    }

    public static void n(final Context context, final String str, final boolean z) {
        AppMethodBeat.i(34450);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
            AppMethodBeat.o(34450);
        } else if (Pgw.PgD == null || Pgw.PgD.isEmpty()) {
            Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
            AppMethodBeat.o(34450);
        } else {
            Log.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", str);
            m.PnZ.add(new QueueWorkerThread.ThreadObject() {
                /* class com.tencent.mm.ui.chatting.l.AnonymousClass5 */
                final /* synthetic */ Runnable val$callback = null;

                @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                public final boolean doInBackground() {
                    AppMethodBeat.i(232861);
                    if (l.Pgw.PgD == null) {
                        AppMethodBeat.o(232861);
                        return false;
                    }
                    for (ca caVar : l.Pgw.PgD) {
                        l.d(context, str, caVar, l.Pgw.Pdm);
                    }
                    AppMethodBeat.o(232861);
                    return true;
                }

                @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                public final boolean onPostExecute() {
                    i iVar;
                    f fVar;
                    AppMethodBeat.i(232862);
                    if (l.Pgw.PgD != null) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10811, 5, Integer.valueOf(l.Pgw.PgD.size()), Integer.valueOf(l.Pgw.PgD.size() - k.jh(l.Pgw.PgD)));
                    }
                    List<ca> list = l.Pgw.PgD;
                    if (list != null) {
                        LinkedList linkedList = new LinkedList();
                        LinkedList linkedList2 = new LinkedList();
                        for (ca caVar : list) {
                            if (caVar.dOQ()) {
                                k.b HD = k.b.HD(Util.processXml(caVar.field_content));
                                if (!(HD == null || HD.type != 51 || (fVar = (f) HD.as(f.class)) == null)) {
                                    linkedList.add(new Pair(fVar.jlg.objectId, fVar.jlg.objectNonceId));
                                }
                                if (!(HD == null || HD.type != 71 || (iVar = (i) HD.as(i.class)) == null)) {
                                    linkedList2.add(new Pair(iVar.jlh.objectId, iVar.jlh.objectNonceId));
                                }
                            }
                        }
                        if (linkedList.size() > 0) {
                            ((aj) g.ah(aj.class)).shareStatsReport(linkedList, false);
                        }
                        if (linkedList2.size() > 0) {
                            ((aj) g.ah(aj.class)).shareStatsReport(linkedList2, true);
                        }
                    }
                    if (z) {
                        if (this.val$callback != null) {
                            Log.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
                            this.val$callback.run();
                        }
                        if (l.Pgw.Pgm != null) {
                            l.Pgw.Pgm.c(z.a.trans);
                        }
                        l.gNy();
                    }
                    AppMethodBeat.o(232862);
                    return true;
                }
            });
            AppMethodBeat.o(34450);
        }
    }

    public static void gNy() {
        Pgw.PgD = null;
        Pgw.Pdm = false;
        Pgw.Pgm = null;
        Pgw.from = null;
        Pgw.dWX = null;
        Pgw.PgE = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x038e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void d(final android.content.Context r10, final java.lang.String r11, final com.tencent.mm.storage.ca r12, final boolean r13) {
        /*
        // Method dump skipped, instructions count: 1297
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.l.d(android.content.Context, java.lang.String, com.tencent.mm.storage.ca, boolean):void");
    }
}
