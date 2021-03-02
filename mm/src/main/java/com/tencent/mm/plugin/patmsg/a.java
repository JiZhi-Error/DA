package com.tencent.mm.plugin.patmsg;

import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.g.b.a.hu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.plugin.patmsg.b.c;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.dtz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.util.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a implements i, b {
    private static final int AQU = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_send_pat_frequency_limit_interval, 10000);
    private static Map<String, Long> AQV = new HashMap();
    public static final int AQY = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_pat_send_pat_msg_delay_interval, 5000);
    private static final int AQZ = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_pat_avatar_revoke_pat_msg_interval, 10000);
    private Set<Long> AQW = new HashSet();
    private c AQX;
    public final q ARa = new q() {
        /* class com.tencent.mm.plugin.patmsg.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, final Map<String, String> map, final h.a aVar) {
            AppMethodBeat.i(206912);
            if ("pat".equals(str)) {
                com.tencent.f.h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.patmsg.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(206911);
                        String str = (String) map.get(".sysmsg.pat.fromusername");
                        String str2 = (String) map.get(".sysmsg.pat.chatusername");
                        String str3 = (String) map.get(".sysmsg.pat.pattedusername");
                        String str4 = (String) map.get(".sysmsg.pat.template");
                        Log.i("MicroMsg.PatMsgExtension", "fromUser: %s, chatUser: %s, pattedUser: %s, template:%s", str, str2, str3, str4);
                        if (!((PluginPatMsg) g.ah(PluginPatMsg.class)).isPatEnable()) {
                            AppMethodBeat.o(206911);
                        } else if (((l) g.af(l.class)).eiy().Hd(aVar.heO.Brn)) {
                            Log.w("MicroMsg.PatMsgExtension", "ignore insert, msg %d should be deleted!", Long.valueOf(aVar.heO.Brn));
                            AppMethodBeat.o(206911);
                        } else {
                            a.b(str2, str, str3, str4, aVar.heO.CreateTime, aVar.heO.Brn);
                            AppMethodBeat.o(206911);
                        }
                    }
                }, "HandlePatMsg");
            }
            AppMethodBeat.o(206912);
        }
    };
    private MMHandler ARb = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback() {
        /* class com.tencent.mm.plugin.patmsg.a.AnonymousClass2 */

        public final boolean handleMessage(Message message) {
            czg boC;
            czh a2;
            int i2;
            int i3;
            AppMethodBeat.i(206913);
            if (message.what == 291) {
                c cVar = (c) message.obj;
                Log.i("MicroMsg.PatMsgExtension", "send pat msg, msgId:%d, createTime:%d scene:%d, talker:%s, patUser:%s", cVar.ARo.first, cVar.ARo.second, Integer.valueOf(cVar.scene), cVar.talker, cVar.ARq);
                a aVar = a.this;
                int i4 = cVar.scene;
                Pair<Long, Long> pair = cVar.ARo;
                boolean z = cVar.ARr;
                Log.i("MicroMsg.PatMsgExtension", "send pat, scene %d, msg (%d,%d)", Integer.valueOf(i4), pair.first, pair.second);
                if (((PluginPatMsg) g.ah(PluginPatMsg.class)).isPatEnable()) {
                    ca Hb = ((l) g.af(l.class)).eiy().Hb(((Long) pair.first).longValue());
                    if (Hb.field_msgId == ((Long) pair.first).longValue() && (a2 = aVar.a((boC = e.boC(Hb.field_content)), ((Long) pair.second).longValue())) != null) {
                        if (!aVar.J(i4, boC.gnh, a2.MEA)) {
                            Log.w("MicroMsg.PatMsgExtension", "cannot pat, scene %d, talker %s, patUser %s", Integer.valueOf(i4), boC.gnh, a2.MEA);
                        } else {
                            hu huVar = new hu();
                            huVar.enq = i4;
                            if (ab.Ix(boC.gnh)) {
                                huVar.vz(boC.gnh);
                            }
                            huVar.eMu = ((Long) pair.second).longValue() - ((com.tencent.mm.plugin.patmsg.a.b) g.af(com.tencent.mm.plugin.patmsg.a.b.class)).b(boC.gnh, pair);
                            if (a.a(boC.gnh, pair)) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            huVar.eMw = i2;
                            huVar.eMx = aVar.b(boC, ((Long) pair.second).longValue()) + 1;
                            huVar.vx(a2.dRL);
                            huVar.vy(a2.MEA);
                            huVar.eLQ = a2.createTime;
                            huVar.vA(c.aJL(a2.MEA));
                            if (z) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            huVar.eMy = i3;
                            com.tencent.mm.plugin.patmsg.b.b bVar = new com.tencent.mm.plugin.patmsg.b.b(pair, boC.gnh, a2.MEA);
                            bVar.ARp = huVar;
                            g.azz().a(bVar, 0);
                        }
                    }
                }
            }
            AppMethodBeat.o(206913);
            return false;
        }
    });

    public a() {
        AppMethodBeat.i(206916);
        AppMethodBeat.o(206916);
    }

    static /* synthetic */ Pair b(String str, String str2, String str3, String str4, int i2, long j2) {
        AppMethodBeat.i(206935);
        Pair<Long, Long> a2 = a(str, str2, str3, str4, i2, j2);
        AppMethodBeat.o(206935);
        return a2;
    }

    static {
        AppMethodBeat.i(206936);
        AppMethodBeat.o(206936);
    }

    private static Pair<Long, Long> a(String str, String str2, String str3, String str4, int i2, long j2) {
        ca aEx;
        long j3;
        AppMethodBeat.i(206917);
        if (!Util.isNullOrNil(str2, str, str3)) {
            if (str.equals(z.aTY())) {
                str = str2;
            }
            if (!ab.Ix(str) || ((l) g.af(l.class)).eit().aEf(str) || (aEx = ((l) g.af(l.class)).eiy().aEx(str)) == null || aEx.field_msgId <= 0 || aEx.getType() != 922746929) {
                long C = bp.C(str, (long) i2);
                ca caVar = new ca();
                czg czg = new czg();
                czg.gnh = str;
                czh czh = new czh();
                czh.iBd = str4;
                czh.createTime = C;
                czh.dRL = str2;
                czh.MEA = str3;
                czh.oNJ = j2;
                String a2 = g.aAh().azQ().a(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC, "");
                long a3 = g.aAh().azQ().a(ar.a.USERINFO_PAT_SUFFIX_MODIFY_TIP_TIMESTAMP_LONG, 0);
                int i3 = g.aAh().azQ().getInt(ar.a.USERINFO_PAT_SUFFIX_MODIFY_TIP_COUNT_INT, 0);
                if (str3.equals(z.aTY()) && !Util.isNullOrNil(a2) && cl.aWA() - a3 > 604800000 && i3 < 5) {
                    Log.i("MicroMsg.PatMsgExtension", "show modify tip %s %s %s %s %s", Long.valueOf(j2), str2, Long.valueOf(a3), Integer.valueOf(i3), a2);
                    czh.MEC = 1;
                    g.aAh().azQ().set(ar.a.USERINFO_PAT_SUFFIX_MODIFY_TIP_TIMESTAMP_LONG, Long.valueOf(cl.aWA()));
                    g.aAh().azQ().set(ar.a.USERINFO_PAT_SUFFIX_MODIFY_TIP_COUNT_INT, Integer.valueOf(i3 + 1));
                }
                czg.yVw.add(czh);
                k.b bVar = new k.b();
                com.tencent.mm.plugin.patmsg.a.a aVar = new com.tencent.mm.plugin.patmsg.a.a();
                aVar.ARl = czg;
                bVar.a(aVar);
                bVar.type = 62;
                bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
                bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
                caVar.setContent(k.b.a(bVar, "", null));
                caVar.nv(0);
                caVar.Cy(str);
                caVar.yF(j2);
                caVar.setCreateTime(C);
                caVar.setType(922746929);
                ((PluginPatMsg) g.ah(PluginPatMsg.class)).addRecvRecord(caVar.field_msgSvrId, czh);
                long x = bp.x(caVar);
                Log.i("MicroMsg.PatMsgExtension", "insert pat msg %d %s %s", Long.valueOf(x), Integer.toHexString(caVar.getType()), Integer.toHexString(922746929));
                Pair<Long, Long> create = Pair.create(Long.valueOf(x), Long.valueOf(C));
                AppMethodBeat.o(206917);
                return create;
            }
            long j4 = ((long) i2) * 1000;
            if (j4 <= aEx.field_createTime) {
                j3 = aEx.field_createTime + 1;
            } else {
                j3 = j4;
            }
            czh czh2 = new czh();
            czh2.iBd = str4;
            czh2.createTime = j3;
            czh2.dRL = str2;
            czh2.MEA = str3;
            czh2.oNJ = j2;
            czg boC = e.boC(aEx.field_content);
            boC.yVw.add(czh2);
            k.b bVar2 = new k.b();
            com.tencent.mm.plugin.patmsg.a.a aVar2 = new com.tencent.mm.plugin.patmsg.a.a();
            aVar2.ARl = boC;
            bVar2.a(aVar2);
            bVar2.type = 62;
            bVar2.title = MMApplicationContext.getContext().getString(R.string.enf);
            bVar2.url = MMApplicationContext.getContext().getString(R.string.eng);
            aEx.setContent(k.b.a(bVar2, "", null));
            long j5 = aEx.field_msgId;
            if (j5 != 0) {
                ((l) g.af(l.class)).eiy().a(j5, aEx);
            }
            ((PluginPatMsg) g.ah(PluginPatMsg.class)).addRecvRecord(aEx.field_msgSvrId, czh2);
            Log.i("MicroMsg.PatMsgExtension", "update pat msg %d, index %d", Long.valueOf(j5), Integer.valueOf(boC.yVw.size() - 1));
            Pair<Long, Long> create2 = Pair.create(Long.valueOf(j5), Long.valueOf(j3));
            AppMethodBeat.o(206917);
            return create2;
        }
        Pair<Long, Long> create3 = Pair.create(0L, 0L);
        AppMethodBeat.o(206917);
        return create3;
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final String a(czg czg) {
        AppMethodBeat.i(206918);
        k.b bVar = new k.b();
        com.tencent.mm.plugin.patmsg.a.a aVar = new com.tencent.mm.plugin.patmsg.a.a();
        aVar.ARl = czg;
        bVar.a(aVar);
        bVar.type = 62;
        bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
        bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
        String a2 = k.b.a(bVar, null, null);
        AppMethodBeat.o(206918);
        return a2;
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final czg aJJ(String str) {
        AppMethodBeat.i(206919);
        czg boC = e.boC(str);
        AppMethodBeat.o(206919);
        return boC;
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final boolean HD(long j2) {
        boolean z;
        AppMethodBeat.i(206920);
        if (this.AQW.contains(Long.valueOf(j2))) {
            AppMethodBeat.o(206920);
            return true;
        }
        ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
        if (Hb.field_msgId > 0) {
            Iterator<czh> it = e.boC(Hb.field_content).yVw.iterator();
            boolean z2 = true;
            while (it.hasNext()) {
                if (it.next().MEB == 1) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z & z2;
            }
            if (z2) {
                this.AQW.add(Long.valueOf(j2));
                AppMethodBeat.o(206920);
                return true;
            }
        }
        AppMethodBeat.o(206920);
        return false;
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final boolean J(int i2, String str, String str2) {
        List<String> Ic;
        AppMethodBeat.i(206921);
        if ((i2 == 3 || i2 == 4 || i2 == 5) && ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_pat_msg_profile_entry, 0) == 0) {
            AppMethodBeat.o(206921);
            return false;
        } else if ((!ab.Ix(str) && !ab.Iu(str)) || ab.Jz(str) || ab.JF(str) || ab.Jv(str) || ab.IT(str)) {
            Log.i("MicroMsg.PatMsgExtension", "cannot pat, talker %s", str);
            AppMethodBeat.o(206921);
            return false;
        } else if (!ab.Iu(str2) || ab.Jz(str2) || ab.JF(str2) || ab.Jv(str2) || ab.IT(str2)) {
            Log.i("MicroMsg.PatMsgExtension", "cannot pat, user %s", str2);
            AppMethodBeat.o(206921);
            return false;
        } else if (!ab.Ix(str) || (Ic = v.Ic(str)) == null || Ic.contains(str2)) {
            AppMethodBeat.o(206921);
            return true;
        } else {
            Log.w("MicroMsg.PatMsgExtension", "chatroom %s members %s, not contain %s", str, Ic, str2);
            AppMethodBeat.o(206921);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final Pair<Long, Long> K(int i2, String str, String str2) {
        AppMethodBeat.i(206922);
        Log.i("MicroMsg.PatMsgExtension", "preSend pat, scene %d, talker %s, user %s", Integer.valueOf(i2), str, str2);
        long aWz = cl.aWz();
        if (!((PluginPatMsg) g.ah(PluginPatMsg.class)).isPatEnable()) {
            AppMethodBeat.o(206922);
            return null;
        } else if (!J(i2, str, str2)) {
            Log.w("MicroMsg.PatMsgExtension", "cannot pat, scene %d, talker %s, user %s", Integer.valueOf(i2), str, str2);
            AppMethodBeat.o(206922);
            return null;
        } else {
            String aTY = z.aTY();
            hu huVar = new hu();
            huVar.enq = i2;
            if (ab.Ix(str)) {
                huVar.vz(str);
            }
            huVar.vx(aTY);
            huVar.vy(str2);
            huVar.eLQ = aWz;
            huVar.vA(c.aJL(str2));
            ca aEx = ((l) g.af(l.class)).eiy().aEx(str);
            if (aEx != null && aEx.field_msgId > 0) {
                if (aEx.getType() == 922746929) {
                    czg boC = e.boC(aEx.field_content);
                    if (boC.yVw.size() > 0) {
                        huVar.eMu = aWz - boC.yVw.getLast().createTime;
                    }
                } else {
                    huVar.eMu = aWz - aEx.field_createTime;
                }
            }
            if (!AQV.containsKey(str2) || aWz - AQV.get(str2).longValue() >= ((long) AQU)) {
                this.AQX = null;
                AQV.put(str2, Long.valueOf(aWz));
                Pair<Long, Long> a2 = a(str, aTY, str2, aJK(str2), (int) (aWz / 1000), 0);
                if (((Long) a2.first).longValue() > 0) {
                    g.azz().a(new com.tencent.mm.plugin.patmsg.b.b(a2, str, str2, 1), 0);
                    c cVar = new c();
                    cVar.scene = i2;
                    cVar.talker = str;
                    cVar.ARq = str2;
                    cVar.ARo = a2;
                    this.ARb.sendMessageDelayed(this.ARb.obtainMessage(291, cVar), (long) AQY);
                    this.AQX = cVar;
                }
                AppMethodBeat.o(206922);
                return a2;
            }
            Log.w("MicroMsg.PatMsgExtension", "pat (%s) last time from now < %d", str2, Integer.valueOf(AQU));
            huVar.eMv = 1;
            huVar.bfK();
            com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
            com.tencent.mm.util.b.a(huVar);
            AppMethodBeat.o(206922);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final czh a(czg czg, long j2) {
        AppMethodBeat.i(206923);
        Iterator<czh> it = czg.yVw.iterator();
        while (it.hasNext()) {
            czh next = it.next();
            if (next.createTime == j2) {
                AppMethodBeat.o(206923);
                return next;
            }
        }
        AppMethodBeat.o(206923);
        return null;
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final int b(czg czg, long j2) {
        AppMethodBeat.i(206924);
        int i2 = -1;
        for (int i3 = 0; i3 < czg.yVw.size(); i3++) {
            if (czg.yVw.get(i3).createTime == j2) {
                i2 = i3;
            }
        }
        AppMethodBeat.o(206924);
        return i2;
    }

    static boolean a(String str, Pair<Long, Long> pair) {
        AppMethodBeat.i(206925);
        if (((Long) pair.second).longValue() <= ((l) g.af(l.class)).eiy().aEP(str)) {
            AppMethodBeat.o(206925);
            return true;
        }
        AppMethodBeat.o(206925);
        return false;
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final long b(String str, Pair<Long, Long> pair) {
        AppMethodBeat.i(206926);
        List<ca> f2 = ((l) g.af(l.class)).eiy().f(str, ((Long) pair.second).longValue(), 1);
        if (!f2.isEmpty() && f2.get(0).field_msgId > 0) {
            if (f2.get(0).getType() == 922746929) {
                czg boC = e.boC(f2.get(0).field_content);
                if (boC.yVw.size() == 0) {
                    AppMethodBeat.o(206926);
                    return 0;
                } else if (((Long) pair.first).longValue() == f2.get(0).field_msgId) {
                    int b2 = b(boC, ((Long) pair.second).longValue());
                    if (b2 > 1) {
                        long j2 = boC.yVw.get(b2 - 1).createTime;
                        AppMethodBeat.o(206926);
                        return j2;
                    }
                } else {
                    long j3 = boC.yVw.getLast().createTime;
                    AppMethodBeat.o(206926);
                    return j3;
                }
            } else {
                long j4 = f2.get(0).field_createTime;
                AppMethodBeat.o(206926);
                return j4;
            }
        }
        AppMethodBeat.o(206926);
        return 0;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        int i4;
        czg boC;
        czh a2;
        czg boC2;
        czh a3;
        AppMethodBeat.i(206927);
        Log.i("MicroMsg.PatMsgExtension", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        hu huVar = ((com.tencent.mm.plugin.patmsg.b.b) qVar).ARp;
        if (huVar != null) {
            huVar.eqN = i3;
        }
        int i5 = ((dty) ((com.tencent.mm.plugin.patmsg.b.b) qVar).iUB.iLK.iLR).Scene;
        Log.i("MicroMsg.PatMsgExtension", "onSceneEnd, pat scene %d", Integer.valueOf(i5));
        if (i2 == 0 && i3 == 0) {
            Pair<Long, Long> pair = ((com.tencent.mm.plugin.patmsg.b.b) qVar).ARo;
            String str2 = ((dty) ((com.tencent.mm.plugin.patmsg.b.b) qVar).iUB.iLK.iLR).MVI;
            if (i5 == 1) {
                String nullAsNil = Util.nullAsNil(((dtz) ((com.tencent.mm.plugin.patmsg.b.b) qVar).iUB.iLL.iLR).MvT);
                if (!Util.isNullOrNil(str2)) {
                    c.jk(str2, nullAsNil);
                    if (((Long) pair.first).longValue() > 0) {
                        ca Hb = ((l) g.af(l.class)).eiy().Hb(((Long) pair.first).longValue());
                        if (Hb.field_msgId == ((Long) pair.first).longValue() && (a3 = a((boC2 = e.boC(Hb.field_content)), ((Long) pair.second).longValue())) != null) {
                            if (str2.equalsIgnoreCase(a3.MEA)) {
                                a3.iBd = aJK(str2);
                                Hb.setContent(a(boC2));
                                Hb.setType(922746929);
                                ((l) g.af(l.class)).eiy().a(((Long) pair.first).longValue(), Hb);
                                Log.i("MicroMsg.PatMsgExtension", "update pat msg suffix %d, createTime %d", pair.first, pair.second);
                            } else {
                                Log.w("MicroMsg.PatMsgExtension", "update pat msg suffix %d, pattedUser (%s,%s) not match", pair.first, str2, a3.MEA);
                            }
                        }
                        if (!Util.isNullOrNil(nullAsNil) && Util.isNullOrNil((String) g.aAh().azQ().get(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC, (Object) null)) && g.aAh().azQ().getBoolean(ar.a.USERINFO_PAT_SUFFIX_INTRO_BOOLEAN_SYNC, true)) {
                            g.aAh().azQ().set(ar.a.USERINFO_PAT_SUFFIX_INTRO_BOOLEAN_SYNC, Boolean.FALSE);
                            String str3 = Hb.field_talker;
                            String format = String.format(MMApplicationContext.getContext().getResources().getString(R.string.fjq), "<_wc_custom_link_ href='weixin://jump/setpat/'>", "</_wc_custom_link_>");
                            ca caVar = new ca();
                            caVar.nv(0);
                            caVar.Cy(str3);
                            caVar.setStatus(3);
                            caVar.setContent(format);
                            caVar.setCreateTime(bp.C(str3, System.currentTimeMillis() / 1000));
                            caVar.setType(10000);
                            caVar.setFlag(caVar.field_flag);
                            bp.x(caVar);
                            if (this.AQX != null) {
                                this.AQX.ARr = true;
                            }
                        }
                    }
                    pf pfVar = new pf();
                    pfVar.dVk.dVl = str2;
                    pfVar.dVk.dVm = nullAsNil;
                    pfVar.dVk.dVn = i5;
                    EventCenter.instance.publish(pfVar);
                }
            } else {
                Map<String, String> parseXml = XmlParser.parseXml(((dtz) ((com.tencent.mm.plugin.patmsg.b.b) qVar).iUB.iLL.iLR).MVJ, "sysmsg", null);
                if (parseXml != null) {
                    i4 = Util.safeParseInt(parseXml.get(".sysmsg.pat.patsuffixversion"));
                } else {
                    i4 = 0;
                }
                c.fa(str2, i4);
                long j2 = ((dtz) ((com.tencent.mm.plugin.patmsg.b.b) qVar).iUB.iLL.iLR).KMm;
                if (j2 != 0 && ((Long) pair.first).longValue() > 0) {
                    ca Hb2 = ((l) g.af(l.class)).eiy().Hb(((Long) pair.first).longValue());
                    Log.i("MicroMsg.PatMsgExtension", "update pat msg %d, svrId %d", pair.first, Long.valueOf(j2));
                    if (Hb2.field_msgId == ((Long) pair.first).longValue() && (a2 = a((boC = e.boC(Hb2.field_content)), ((Long) pair.second).longValue())) != null) {
                        if (str2.equalsIgnoreCase(a2.MEA)) {
                            a2.oNJ = j2;
                            if (Hb2.field_msgSvrId == 0) {
                                Hb2.yF(j2);
                            }
                            Hb2.setContent(a(boC));
                            Hb2.setType(922746929);
                            ((l) g.af(l.class)).eiy().a(((Long) pair.first).longValue(), Hb2);
                            Log.i("MicroMsg.PatMsgExtension", "update pat msg svrId %d, createTime %d", pair.first, pair.second);
                        } else {
                            Log.w("MicroMsg.PatMsgExtension", "update pat msg svrId %d, pattedUser (%s,%s) not match", pair.first, str2, a2.MEA);
                        }
                    }
                }
            }
        } else if (i5 == 1) {
            AppMethodBeat.o(206927);
            return;
        } else {
            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.u5) + "(" + i2 + "," + i3 + ")", 0).show();
            final String str4 = ((dty) ((com.tencent.mm.plugin.patmsg.b.b) qVar).iUB.iLK.iLR).MVH;
            if (!(i3 == -22 || i3 == -44)) {
                com.tencent.f.h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.patmsg.a.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(206914);
                        ca caVar = new ca();
                        caVar.setContent(MMApplicationContext.getContext().getString(R.string.gk6));
                        caVar.setType(10000);
                        caVar.nv(0);
                        caVar.Cy(str4);
                        caVar.setCreateTime(System.currentTimeMillis());
                        Log.i("MicroMsg.PatMsgExtension", "insert pat failed msg %d", Long.valueOf(bp.x(caVar)));
                        AppMethodBeat.o(206914);
                    }
                });
            }
        }
        if (huVar != null) {
            huVar.bfK();
            com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
            com.tencent.mm.util.b.a(huVar);
        }
        AppMethodBeat.o(206927);
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final boolean ae(long j2, long j3) {
        czh czh;
        AppMethodBeat.i(206928);
        Log.i("MicroMsg.PatMsgExtension", "delete svr pat msg (%d,%d)", Long.valueOf(j2), Long.valueOf(j3));
        ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
        if (Hb.field_msgId == j2 && j3 != 0) {
            czg boC = e.boC(Hb.field_content);
            Log.i("MicroMsg.PatMsgExtension", "pat record list size %d", Integer.valueOf(boC.yVw.size()));
            Iterator<czh> it = boC.yVw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    czh = null;
                    break;
                }
                czh = it.next();
                if (czh.oNJ == j3) {
                    break;
                }
            }
            if (czh != null) {
                boC.yVw.remove(czh);
                if (boC.yVw.isEmpty()) {
                    ((l) g.af(l.class)).eiy().Hc(j2);
                } else {
                    Hb.setContent(a(boC));
                    Hb.setType(922746929);
                    ((l) g.af(l.class)).eiy().a(j2, Hb);
                }
                AppMethodBeat.o(206928);
                return true;
            }
        }
        AppMethodBeat.o(206928);
        return false;
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final String aJK(String str) {
        String string;
        AppMethodBeat.i(206929);
        String aTY = z.aTY();
        int aJM = c.aJM(str);
        Log.i("MicroMsg.PatMsgExtension", "pattedUser %s, version %d", str, Integer.valueOf(aJM));
        if (str.equals(aTY)) {
            String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC, (Object) null);
            if (Util.isNullOrNil(str2)) {
                string = MMApplicationContext.getContext().getString(R.string.gk7);
            } else if (aJM == 0) {
                string = MMApplicationContext.getContext().getString(R.string.gk9, str2);
            } else {
                string = MMApplicationContext.getContext().getString(R.string.gk8, str2);
            }
        } else {
            String aJL = c.aJL(str);
            Log.i("MicroMsg.PatMsgExtension", "pattedUser %s, suffix %s", str, aJL);
            if (Util.isNullOrNil(aJL)) {
                string = MMApplicationContext.getContext().getString(R.string.gk_) + "\"" + aa.getDisplayName(str) + "\"";
            } else if (aJM == 0) {
                string = MMApplicationContext.getContext().getString(R.string.gkb, "\"" + aa.getDisplayName(str) + "\"", aJL);
            } else {
                string = MMApplicationContext.getContext().getString(R.string.gka, "\"" + aa.getDisplayName(str) + "\"", aJL);
            }
        }
        AppMethodBeat.o(206929);
        return string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0042, code lost:
        r9 = com.tencent.mm.util.e.boC(r1.field_content);
     */
    @Override // com.tencent.mm.plugin.patmsg.a.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.util.Pair<java.lang.Long, java.lang.Long> r12, int r13) {
        /*
        // Method dump skipped, instructions count: 652
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.patmsg.a.a(android.util.Pair, int):void");
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final void bd(String str, long j2) {
        AppMethodBeat.i(206931);
        Log.i("MicroMsg.PatMsgExtension", "do revoke svr pat msg %d from talker %s", Long.valueOf(j2), str);
        czi recvRecord = ((PluginPatMsg) g.ah(PluginPatMsg.class)).getRecvRecord(j2);
        if (recvRecord != null) {
            long j3 = recvRecord.MED;
            ca aJ = ((l) g.af(l.class)).eiy().aJ(str, j3);
            if (aJ.field_msgSvrId == j3) {
                Log.i("MicroMsg.PatMsgExtension", "revoke pat msg %d,%d", Long.valueOf(aJ.field_msgId), Long.valueOf(j2));
                ae(aJ.field_msgId, j2);
            }
        }
        AppMethodBeat.o(206931);
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final String d(Pair<Long, Long> pair) {
        AppMethodBeat.i(206932);
        String str = z.aTY() + "_" + pair.first + "_" + pair.second;
        AppMethodBeat.o(206932);
        return str;
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final boolean e(Pair<Long, Long> pair) {
        AppMethodBeat.i(206933);
        if (((PluginPatMsg) g.ah(PluginPatMsg.class)).isRevokePatMsgEnable() && this.AQX != null && this.AQX.ARo != null && this.AQX.ARo.equals(pair) && ((int) (System.currentTimeMillis() - this.AQX.createTime)) < AQZ) {
            Log.i("MicroMsg.PatMsgExtension", "try revoke last pat, msgId:%d, createTime:%d, scene:%d, talker:%s, patUser:%s", this.AQX.ARo.first, this.AQX.ARo.second, Integer.valueOf(this.AQX.scene), this.AQX.talker, this.AQX.ARq);
            czh a2 = a(e.boC(((l) g.af(l.class)).eiy().Hb(((Long) this.AQX.ARo.first).longValue()).field_content), ((Long) pair.second).longValue());
            if (a2 != null) {
                boolean equalsIgnoreCase = this.AQX.ARq.equalsIgnoreCase(a2.MEA);
                AppMethodBeat.o(206933);
                return equalsIgnoreCase;
            }
        }
        AppMethodBeat.o(206933);
        return false;
    }

    @Override // com.tencent.mm.plugin.patmsg.a.b
    public final List<ca> HE(long j2) {
        int size;
        AppMethodBeat.i(206934);
        ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
        if (Hb.getType() == 922746929) {
            ArrayList arrayList = new ArrayList();
            czg boC = e.boC(Hb.field_content);
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(j2);
            if (boC.yVw == null) {
                size = 0;
            } else {
                size = boC.yVw.size();
            }
            objArr[1] = Integer.valueOf(size);
            Log.i("MicroMsg.PatMsgExtension", "split pat msg [%d] to %d child msg", objArr);
            Iterator<czh> it = boC.yVw.iterator();
            while (it.hasNext()) {
                czh next = it.next();
                ca caVar = new ca();
                czg czg = new czg();
                czg.gnh = boC.gnh;
                e.a aVar = new e.a();
                aVar.iBd = next.iBd;
                aVar.QYI = next.iBd;
                aVar.createTime = next.createTime;
                aVar.dRL = next.dRL;
                aVar.MEA = next.MEA;
                aVar.oNJ = next.oNJ;
                czg.yVw.add(aVar);
                k.b bVar = new k.b();
                com.tencent.mm.plugin.patmsg.a.a aVar2 = new com.tencent.mm.plugin.patmsg.a.a();
                aVar2.ARl = czg;
                bVar.a(aVar2);
                bVar.type = 62;
                bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
                bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
                caVar.setContent(k.b.a(bVar, "", null));
                caVar.setType(922746929);
                caVar.nv(0);
                caVar.Cy(boC.gnh);
                caVar.yF(next.oNJ);
                caVar.setCreateTime(next.createTime);
                arrayList.add(caVar);
            }
            AppMethodBeat.o(206934);
            return arrayList;
        }
        AppMethodBeat.o(206934);
        return null;
    }
}
