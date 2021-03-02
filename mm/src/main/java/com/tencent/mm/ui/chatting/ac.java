package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.a;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.l;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e;
import com.tencent.mm.av.g;
import com.tencent.mm.av.h;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;

public final class ac<T> {
    private String PjI = "";

    private static boolean bz(ca caVar) {
        AppMethodBeat.i(34813);
        g G = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
        if (G.offset < G.iKP || G.iKP == 0) {
            AppMethodBeat.o(34813);
            return false;
        }
        AppMethodBeat.o(34813);
        return true;
    }

    public static boolean bB(ca caVar) {
        k.b HD;
        AppMethodBeat.i(34815);
        if (caVar == null || !caVar.dOQ() || (HD = k.b.HD(caVar.field_content)) == null || HD.type != 40) {
            AppMethodBeat.o(34815);
            return true;
        }
        AppMethodBeat.o(34815);
        return false;
    }

    public static boolean bC(ca caVar) {
        a aVar;
        AppMethodBeat.i(232911);
        if (caVar == null) {
            AppMethodBeat.o(232911);
            return true;
        } else if (as.bjp(caVar.field_talker) || as.bjp(bp.Ks(caVar.field_content))) {
            if (caVar.dOQ()) {
                k.b HD = k.b.HD(caVar.field_content);
                if (HD == null) {
                    AppMethodBeat.o(232911);
                    return true;
                } else if (HD.type == 6 && !Util.isNullOrNil(HD.iwN)) {
                    c c2 = m.c(caVar, HD.dCK);
                    if (c2 != null && (!s.YS(c2.field_fileFullPath) || s.boW(c2.field_fileFullPath) != c2.field_totalLen)) {
                        AppMethodBeat.o(232911);
                        return false;
                    }
                } else if (HD.type == 19) {
                    Iterator<aml> it = p.aKY(HD.ixl).iAd.iterator();
                    while (it.hasNext()) {
                        aml next = it.next();
                        String c3 = p.c(next, caVar.field_msgId);
                        if (Util.isNullOrNil(next.LwF) || s.YS(c3)) {
                            String f2 = p.f(next, caVar.field_msgId);
                            if (!Util.isNullOrNil(next.iwO) && !s.YS(f2)) {
                                AppMethodBeat.o(232911);
                                return false;
                            }
                        } else {
                            AppMethodBeat.o(232911);
                            return false;
                        }
                    }
                } else if (HD.type == 48 && ((aVar = (a) HD.as(a.class)) == null || Util.isNullOrNil(aVar.ivm) || Util.isNullOrNil(aVar.ivo))) {
                    Log.w("MicroMsg.FavMsgHandle", "hy: can not fav or retransmit because of not having remote url");
                    AppMethodBeat.o(232911);
                    return false;
                }
            }
            if (caVar.gAz() && !bz(caVar)) {
                AppMethodBeat.o(232911);
                return false;
            } else if ((caVar.cWJ() || caVar.cWL()) && !bA(caVar)) {
                AppMethodBeat.o(232911);
                return false;
            } else {
                AppMethodBeat.o(232911);
                return true;
            }
        } else {
            AppMethodBeat.o(232911);
            return true;
        }
    }

    public final void a(final T t, Context context, final com.tencent.mm.plugin.fav.b.c.a aVar) {
        boolean z;
        int i2;
        boolean z2;
        int i3;
        AppMethodBeat.i(34816);
        String str = aVar.dCM.field_msgId + " ";
        if (str.equals(this.PjI)) {
            u.makeText(context, context.getString(R.string.c8i), 0).show();
            AppMethodBeat.o(34816);
            return;
        }
        this.PjI = str;
        if (aVar.dCM.dOQ()) {
            k.b HD = k.b.HD(aVar.dCM.field_content);
            if (HD.type == 6 && !Util.isNullOrNil(HD.iwN)) {
                final c c2 = m.c(aVar.dCM, HD.dCK);
                if (c2 != null && (!s.YS(c2.field_fileFullPath) || s.boW(c2.field_fileFullPath) != c2.field_totalLen)) {
                    com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                    gVar.taskName = "task_FavMsgHandle_2";
                    gVar.gqy = new g.a() {
                        /* class com.tencent.mm.ui.chatting.ac.AnonymousClass4 */

                        @Override // com.tencent.mm.i.g.a
                        public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
                            AppMethodBeat.i(34812);
                            if (i2 == 0 && cVar != null) {
                                c2.field_offset = cVar.field_finishedLength;
                                ao.cgO().a(c2, new String[0]);
                            }
                            if (i2 == 0 && dVar != null && dVar.field_retCode == 0) {
                                c2.field_status = 199;
                                c2.field_offset = c2.field_totalLen;
                                ao.cgO().a(c2, new String[0]);
                                aVar.dCM.setStatus(3);
                                bg.aVF();
                                com.tencent.mm.model.c.aSQ().a(aVar.dCM.field_msgId, aVar.dCM);
                                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.ac.AnonymousClass4.AnonymousClass1 */

                                    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.ui.chatting.ac */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    public final void run() {
                                        AppMethodBeat.i(34811);
                                        ac.this.a(t, aVar);
                                        AppMethodBeat.o(34811);
                                    }
                                });
                            }
                            AppMethodBeat.o(34812);
                            return 0;
                        }

                        @Override // com.tencent.mm.i.g.a
                        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                        }

                        @Override // com.tencent.mm.i.g.a
                        public final byte[] f(String str, byte[] bArr) {
                            return new byte[0];
                        }
                    };
                    gVar.field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), aVar.dCM.field_talker, new StringBuilder().append(aVar.dCM.field_msgId).toString());
                    gVar.field_aesKey = HD.aesKey;
                    gVar.field_fileType = 19;
                    gVar.field_authKey = HD.iwT;
                    gVar.gqB = HD.iwN;
                    if (c2 == null || Util.isNullOrNil(c2.field_fileFullPath)) {
                        bg.aVF();
                        gVar.field_fullpath = m.aB(com.tencent.mm.model.c.aTg(), HD.title, HD.iwJ);
                    } else {
                        gVar.field_fullpath = c2.field_fileFullPath;
                    }
                    if (!f.baQ().b(gVar, -1)) {
                        Log.e("MicroMsg.FavMsgHandle", "openim attach download failed before rescend");
                    }
                    AppMethodBeat.o(34816);
                    return;
                }
            } else if (HD.type == 19) {
                com.tencent.mm.protocal.b.a.c aKY = p.aKY(HD.ixl);
                HashSet<String> hashSet = new HashSet<>();
                if (!(aKY == null || aKY.iAd == null)) {
                    Iterator<aml> it = aKY.iAd.iterator();
                    while (it.hasNext()) {
                        aml next = it.next();
                        String c3 = p.c(next, aVar.dCM.field_msgId);
                        if (!Util.isNullOrNil(next.LwF) && !s.YS(c3)) {
                            a(t, aVar, next.LwF, next.LwC, next.iwT, c3, p.g(next.dLl, aVar.dCM.field_msgId, true), aVar.dCM, hashSet);
                        }
                        String f2 = p.f(next, aVar.dCM.field_msgId);
                        if (!Util.isNullOrNil(next.iwO) && !s.YS(f2)) {
                            a(t, aVar, next.iwO, next.iwU, next.iwT, f2, p.g(p.arI(next.dLl), aVar.dCM.field_msgId, true), aVar.dCM, hashSet);
                        }
                    }
                }
                if (!hashSet.isEmpty()) {
                    AppMethodBeat.o(34816);
                    return;
                }
            }
        }
        if (aVar.dCM.gAz()) {
            com.tencent.mm.av.g G = q.bcR().G(aVar.dCM.field_talker, aVar.dCM.field_msgSvrId);
            if (aVar.dCM.field_isSend == 1) {
                if (G.bcv()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                i2 = i3;
            } else if (!G.bcv()) {
                i2 = 0;
            } else {
                if (!s.YS(q.bcR().o(h.a(G).iXm, "", ""))) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
            }
            if (G.offset < G.iKP || G.iKP == 0) {
                Log.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav start  msgID:%d", Long.valueOf(aVar.dCM.field_msgId));
                q.bcS().a(G.localId, aVar.dCM.field_msgId, i2, aVar.dCM, R.drawable.c3h, new e.a() {
                    /* class com.tencent.mm.ui.chatting.ac.AnonymousClass3 */

                    @Override // com.tencent.mm.av.e.a
                    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, com.tencent.mm.ak.q qVar) {
                    }

                    @Override // com.tencent.mm.av.e.a
                    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(34809);
                        Log.i("MicroMsg.FavMsgHandle", "oreh downloadImreportHandler.removeMessagesreportHandler.removeMessagesgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", Boolean.valueOf(i4 == 0 && i5 == 0), Long.valueOf(aVar.dCM.field_msgId), Integer.valueOf(i4), Integer.valueOf(i5));
                        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.ac.AnonymousClass3.AnonymousClass1 */

                            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.ui.chatting.ac */
                            /* JADX WARN: Multi-variable type inference failed */
                            public final void run() {
                                AppMethodBeat.i(34808);
                                ac.this.a(t, aVar);
                                AppMethodBeat.o(34808);
                            }
                        });
                        AppMethodBeat.o(34809);
                    }

                    @Override // com.tencent.mm.av.e.a
                    public final void a(long j2, long j3, int i2, int i3, Object obj) {
                        AppMethodBeat.i(34810);
                        Log.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav download image taskcancel: msgID:%d", Long.valueOf(aVar.dCM.field_msgId));
                        AppMethodBeat.o(34810);
                    }
                });
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                AppMethodBeat.o(34816);
                return;
            }
        }
        if (aVar.dCM.cWJ() || aVar.dCM.cWL()) {
            com.tencent.mm.modelvideo.s QN = com.tencent.mm.modelvideo.u.QN(aVar.dCM.field_imgPath);
            if (QN == null || QN.status == 199) {
                z = false;
            } else {
                o.bhj().a(new t.a() {
                    /* class com.tencent.mm.ui.chatting.ac.AnonymousClass2 */

                    @Override // com.tencent.mm.modelvideo.t.a
                    public final void a(t.a.C0460a aVar) {
                        AppMethodBeat.i(34807);
                        if (aVar.dCM.field_imgPath.equals(aVar.fileName)) {
                            com.tencent.mm.modelvideo.s QN = com.tencent.mm.modelvideo.u.QN(aVar.fileName);
                            if (QN == null || !QN.bhy()) {
                                Log.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", Long.valueOf(aVar.dCM.field_msgId), aVar.fileName);
                            } else {
                                Log.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", Long.valueOf(aVar.dCM.field_msgId), aVar.fileName);
                                o.bhj().a(this);
                                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.ac.AnonymousClass2.AnonymousClass1 */

                                    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.ui.chatting.ac */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    public final void run() {
                                        AppMethodBeat.i(34806);
                                        ac.this.a(t, aVar);
                                        AppMethodBeat.o(34806);
                                    }
                                });
                                AppMethodBeat.o(34807);
                                return;
                            }
                        }
                        AppMethodBeat.o(34807);
                    }
                }, Looper.getMainLooper());
                Log.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", Long.valueOf(aVar.dCM.field_msgId), aVar.dCM.field_imgPath);
                if (QN.bhx()) {
                    Log.i("MicroMsg.FavMsgHandle", "start complete online video");
                    com.tencent.mm.modelvideo.u.QT(aVar.dCM.field_imgPath);
                } else {
                    Log.i("MicroMsg.FavMsgHandle", "start complete offline video");
                    com.tencent.mm.modelvideo.u.QI(aVar.dCM.field_imgPath);
                }
                z = true;
            }
            if (z) {
                AppMethodBeat.o(34816);
                return;
            }
        }
        this.PjI = "";
        a(t, aVar);
        AppMethodBeat.o(34816);
    }

    private void a(final T t, final com.tencent.mm.plugin.fav.b.c.a aVar, String str, String str2, String str3, final String str4, String str5, final ca caVar, final HashSet<String> hashSet) {
        AppMethodBeat.i(34817);
        Log.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl msgId:%d, mediaId:%s, path:%s", Long.valueOf(caVar.field_msgId), str5, str4);
        hashSet.add(str5);
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.taskName = "task_FavMsgHandle_1";
        gVar.field_fileType = 19;
        gVar.field_authKey = str3;
        gVar.field_aesKey = str2;
        gVar.gqB = str;
        gVar.field_fullpath = str4;
        gVar.field_mediaId = str5;
        gVar.gqy = new g.a() {
            /* class com.tencent.mm.ui.chatting.ac.AnonymousClass1 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
                AppMethodBeat.i(34805);
                boolean z2 = false;
                if (i2 == 0 && dVar != null && dVar.field_retCode == 0) {
                    Log.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl done msgId:%d, mediaId:%s, path:%s", Long.valueOf(caVar.field_msgId), str, str4);
                    z2 = true;
                }
                if (!(i2 == 0 && (dVar == null || dVar.field_retCode == 0))) {
                    Object[] objArr = new Object[5];
                    objArr[0] = Long.valueOf(caVar.field_msgId);
                    objArr[1] = str;
                    objArr[2] = str4;
                    objArr[3] = Integer.valueOf(i2);
                    objArr[4] = Integer.valueOf(dVar == null ? 0 : dVar.field_retCode);
                    Log.e("MicroMsg.FavMsgHandle", "oreh downloadTpUrl error msgId:%d, mediaId:%s, path:%s, err:(%d,%d)", objArr);
                    z2 = true;
                }
                if (!z2) {
                    AppMethodBeat.o(34805);
                    return 0;
                }
                hashSet.remove(str);
                if (hashSet.isEmpty()) {
                    new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.ac.AnonymousClass1.AnonymousClass1 */

                        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.ui.chatting.ac */
                        /* JADX WARN: Multi-variable type inference failed */
                        public final void run() {
                            AppMethodBeat.i(34804);
                            ac.this.a(t, aVar);
                            AppMethodBeat.o(34804);
                        }
                    });
                }
                AppMethodBeat.o(34805);
                return 0;
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                return new byte[0];
            }
        };
        if (!f.baQ().b(gVar, -1)) {
            Log.e("MicroMsg.FavMsgHandle", "recv openim record, add task failed");
        }
        AppMethodBeat.o(34817);
    }

    /* access modifiers changed from: package-private */
    public final void a(T t, com.tencent.mm.plugin.fav.b.c.a aVar) {
        AppMethodBeat.i(34818);
        this.PjI = "";
        cz czVar = new cz();
        com.tencent.mm.pluginsdk.model.h.d(czVar, aVar.dCM);
        if (t instanceof MMFragment) {
            czVar.dFZ.fragment = t;
        } else if (t instanceof Activity) {
            czVar.dFZ.activity = t;
        }
        czVar.dFZ.dGf = 43;
        EventCenter.instance.publish(czVar);
        if (czVar.dGa.ret == 0) {
            if (aVar.dCM.dOQ()) {
                b.jmd.c(aVar.dCM, l.t(aVar.dCM));
            } else {
                b.jmd.ac(aVar.dCM);
            }
            if (aVar.dCM.dOQ() || aVar.dCM.gAt()) {
                String JX = ad.JX(new StringBuilder().append(aVar.dCM.field_msgSvrId).toString());
                ad.b G = ad.aVe().G(JX, true);
                G.l("prePublishId", "msg_" + aVar.dCM.field_msgSvrId);
                G.l("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(aVar.dCM, aVar.tcb, aVar.tca));
                G.l("preChatName", aVar.talker);
                G.l("preMsgIndex", 0);
                G.l("sendAppMsgScene", 1);
                ((j) com.tencent.mm.kernel.g.af(j.class)).a("adExtStr", G, aVar.dCM);
                czVar.dFZ.sessionId = JX;
            }
            k.b HD = k.b.HD(Util.processXml(aVar.dCM.field_content));
            if (!(HD == null || HD.type != 5 || HD.url == null)) {
                long nowSecond = Util.nowSecond();
                Log.d("MicroMsg.FavMsgHandle", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", 13378, HD.url, Long.valueOf(nowSecond), 2, 2, 1);
                String str = "";
                try {
                    str = URLEncoder.encode(HD.url, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.FavMsgHandle", e2, "", new Object[0]);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13378, str, Long.valueOf(nowSecond), 2, 2, 1);
            }
            if (aVar.tcc != null) {
                aVar.tcc.cVq();
            }
            a.a(a.c.Fav, a.d.Samll, aVar.dCM, 0);
        }
        AppMethodBeat.o(34818);
    }

    private static boolean bA(ca caVar) {
        AppMethodBeat.i(34814);
        com.tencent.mm.modelvideo.s QN = com.tencent.mm.modelvideo.u.QN(caVar.field_imgPath);
        if (QN == null || QN.status == 199) {
            AppMethodBeat.o(34814);
            return true;
        }
        AppMethodBeat.o(34814);
        return false;
    }
}
