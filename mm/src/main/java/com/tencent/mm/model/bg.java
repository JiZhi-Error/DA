package com.tencent.mm.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.t;
import com.tencent.mm.ak.x;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b.d;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bm;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.account.friend.a.s;
import com.tencent.mm.plugin.account.friend.a.t;
import com.tencent.mm.plugin.account.friend.a.u;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.plugin.appbrand.jsapi.ce;
import com.tencent.mm.plugin.appbrand.jsapi.dg;
import com.tencent.mm.plugin.appbrand.jsapi.storage.j;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.report.b.b;
import com.tencent.mm.plugin.report.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.n;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.blg;
import com.tencent.mm.protocal.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.u;
import com.tencent.mm.storagebase.h;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public final class bg {
    private static bg iDx = null;
    private static final cg iDz = new cg();
    private final int iDA = 1;
    final c.a iDB;
    private ck iDC = new ck();
    private cc iDD = new cc();
    private e iDE = new e();
    private cn iDF = new cn();
    private ae iDG = new ae();
    private bv.a iDH = new bv.a() {
        /* class com.tencent.mm.model.bg.AnonymousClass4 */

        @Override // com.tencent.mm.storage.bv.a
        public final as Kn(String str) {
            return null;
        }

        @Override // com.tencent.mm.storage.bv.a
        public final int b(as asVar, boolean z) {
            return 0;
        }

        @Override // com.tencent.mm.storage.bv.a
        public final void a(bv bvVar, as asVar) {
            as asVar2;
            AppMethodBeat.i(20325);
            String str = asVar.field_username;
            if (as.IG(asVar.field_username)) {
                asVar.setUsername(as.bjz(asVar.field_username));
            }
            if (Util.isNullOrNil(asVar.ajz())) {
                asVar.BF(f.Si(asVar.field_nickname));
            }
            if (Util.isNullOrNil(asVar.ajA())) {
                asVar.BG(f.Sh(asVar.field_nickname));
            }
            if (Util.isNullOrNil(asVar.field_conRemarkPYShort)) {
                asVar.BJ(f.Si(asVar.field_conRemark));
            }
            if (Util.isNullOrNil(asVar.field_conRemarkPYFull)) {
                asVar.BI(f.Sh(asVar.field_conRemark));
            }
            if (ab.p(asVar)) {
                asVar.nd(43);
                asVar.BF(f.Si(asVar.arI()));
                asVar.BG(f.Sh(asVar.arI()));
                asVar.BI(f.Sh(asVar.arJ()));
                asVar.BJ(asVar.arJ());
                AppMethodBeat.o(20325);
                return;
            }
            if (ab.JE(str)) {
                asVar.aqQ();
                asVar.ni(4);
                asVar.nd(33);
                if (asVar == null) {
                    asVar2 = new as();
                } else {
                    asVar2 = asVar;
                }
                asVar2.setUsername(str);
                asVar2.aqQ();
                ak.M(asVar2);
                asVar2.aqZ();
            }
            if (asVar.arA()) {
                asVar.nd(asVar.aqN());
            }
            if (ab.Js(str)) {
                Log.i("MicroMsg.MMCore", "update official account helper showhead %d", 31);
                asVar.nd(31);
            }
            if (asVar.ary()) {
                bg.aVF();
                c.aST().c(new String[]{str}, "@blacklist");
            }
            Log.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", asVar.field_username, asVar.ajz());
            AppMethodBeat.o(20325);
        }
    };
    private bw.a iDI = new bw.a() {
        /* class com.tencent.mm.model.bg.AnonymousClass5 */

        @Override // com.tencent.mm.storage.bw.a
        public final void a(az azVar, bw bwVar) {
            boolean z;
            az azVar2;
            AppMethodBeat.i(20326);
            if (azVar == null) {
                AppMethodBeat.o(20326);
            } else if (!as.bjm(azVar.field_username) && !as.bjo(azVar.field_username) && !as.IG(azVar.field_username) && !ab.IT(azVar.field_username) && !as.bjp(azVar.field_username)) {
                AppMethodBeat.o(20326);
            } else if (as.IG(azVar.field_username)) {
                az bjY = bwVar.bjY("floatbottle");
                if (bjY == null) {
                    z = true;
                    azVar2 = new az("floatbottle");
                } else {
                    z = false;
                    azVar2 = bjY;
                }
                azVar2.nu(1);
                azVar2.nt(s.aTQ());
                bg.aVF();
                ca aEA = c.aSQ().aEA(" and not ( type = 10000 and isSend != 2 ) ");
                if (aEA == null || aEA.field_msgId <= 0) {
                    azVar2.gCr();
                } else {
                    azVar2.aX(aEA);
                    azVar2.setContent(as.bjz(aEA.field_talker) + ":" + aEA.field_content);
                    azVar2.Cl(Integer.toString(aEA.getType()));
                    bw.b Xh = bwVar.Xh();
                    if (Xh != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        aEA.Cy("floatbottle");
                        aEA.setContent(azVar2.field_content);
                        Xh.a(aEA, pString, pString2, pInt, false);
                        azVar2.Cm(pString.value);
                        azVar2.Cn(pString2.value);
                        azVar2.nw(pInt.value);
                    }
                }
                if (z) {
                    bwVar.e(azVar2);
                    AppMethodBeat.o(20326);
                    return;
                }
                bwVar.a(azVar2, azVar2.field_username);
                AppMethodBeat.o(20326);
            } else if (as.bjm(azVar.field_username) || as.bjo(azVar.field_username)) {
                AppMethodBeat.o(20326);
            } else {
                g.af(q.class);
                u.b(azVar, bwVar);
                if ("@blacklist".equals(azVar.field_parentRef)) {
                    bg.aVF();
                    as Kn = c.aSN().Kn(azVar.field_username);
                    if (Kn != null && !Util.isNullOrNil(Kn.field_username) && !Kn.ary()) {
                        bg.aVF();
                        c.aST().c(new String[]{azVar.field_username}, "");
                    }
                }
                AppMethodBeat.o(20326);
            }
        }
    };
    private bw.a iDJ = new bw.a() {
        /* class com.tencent.mm.model.bg.AnonymousClass6 */

        @Override // com.tencent.mm.storage.bw.a
        public final void a(az azVar, bw bwVar) {
            if (azVar == null) {
            }
        }
    };
    private f iDK = new f();
    private final c iDn;
    private final aw iDw;
    private com.tencent.mm.compatible.b.g iDy = null;

    static /* synthetic */ bg aVI() {
        AppMethodBeat.i(20359);
        bg aVC = aVC();
        AppMethodBeat.o(20359);
        return aVC;
    }

    static {
        AppMethodBeat.i(20360);
        AppMethodBeat.o(20360);
    }

    public static boolean aVy() {
        return iDx == null;
    }

    public static void a(p pVar) {
        AppMethodBeat.i(20331);
        g.aAi();
        g.aAg().a(pVar);
        AppMethodBeat.o(20331);
    }

    public static void b(p pVar) {
        AppMethodBeat.i(20332);
        g.aAi();
        g.aAg().b(pVar);
        AppMethodBeat.o(20332);
    }

    public static void a(av avVar) {
        AppMethodBeat.i(20333);
        b.a(avVar);
        AppMethodBeat.o(20333);
    }

    public static void FM(String str) {
        AppMethodBeat.i(20334);
        com.tencent.mm.kernel.a.FM(str);
        AppMethodBeat.o(20334);
    }

    public static cg aVz() {
        AppMethodBeat.i(20335);
        aVC();
        cg cgVar = iDz;
        AppMethodBeat.o(20335);
        return cgVar;
    }

    public static boolean aVA() {
        AppMethodBeat.i(20336);
        boolean azi = com.tencent.mm.kernel.a.azi();
        AppMethodBeat.o(20336);
        return azi;
    }

    public static void aVB() {
        AppMethodBeat.i(20337);
        com.tencent.mm.kernel.a.es(false);
        AppMethodBeat.o(20337);
    }

    public static void a(aw awVar, t.a aVar) {
        AppMethodBeat.i(20338);
        iDx = new bg(awVar, aVar);
        o.dh(MMApplicationContext.getContext());
        AppMethodBeat.o(20338);
    }

    public static ax getNotification() {
        AppMethodBeat.i(20339);
        ax notification = aVC().iDw.getNotification();
        AppMethodBeat.o(20339);
        return notification;
    }

    public static an Xi() {
        AppMethodBeat.i(20340);
        an Xi = aVC().iDw.Xi();
        AppMethodBeat.o(20340);
        return Xi;
    }

    class a implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.c, e, com.tencent.mm.kernel.c.a {
        a() {
        }

        @Override // com.tencent.mm.kernel.api.c
        public void onAccountInitialized(e.c cVar) {
            AppMethodBeat.i(20327);
            if (cVar.hrc) {
                com.tencent.mm.y.c.axV().A(262145, false);
            }
            h.INSTANCE.idkeyStat(598, 13, 1, false);
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", Long.valueOf(Thread.currentThread().getId()));
            c cVar2 = bg.this.iDn;
            com.tencent.mm.storagebase.h hVar = g.aAh().hqK;
            g.aAh();
            i eiy = ((l) g.af(l.class)).eiy();
            eiy.a(new bk(eiy));
            com.tencent.mm.storage.h hVar2 = new com.tencent.mm.storage.h(eiy);
            cVar2.iBq = hVar2;
            eiy.a(hVar2);
            com.tencent.mm.storage.i iVar = new com.tencent.mm.storage.i(eiy);
            cVar2.iBr = iVar;
            eiy.a(iVar);
            cVar2.iBo = new cb(hVar, ((l) g.af(l.class)).aST());
            cVar2.iBp = new ca(hVar, ((l) g.af(l.class)).aSN());
            cVar2.iBs = new com.tencent.mm.model.b.c();
            cVar2.iBt = new d();
            cVar2.iBx = new com.tencent.mm.model.b.b();
            cVar2.iBu = new k(hVar);
            cVar2.iBv = new com.tencent.mm.storage.o(hVar);
            cVar2.iBw = new m(hVar);
            h.INSTANCE.idkeyStat(598, 14, 1, false);
            Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            c.a aVar = bg.this.iDB;
            c unused = bg.this.iDn;
            aVar.fo(cVar.hrc);
            h.INSTANCE.idkeyStat(598, 15, 1, false);
            Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            com.tencent.mm.compatible.util.e.apn();
            h.INSTANCE.idkeyStat(598, 16, 1, false);
            Log.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(20327);
        }

        @Override // com.tencent.mm.kernel.api.c
        public void onAccountRelease() {
        }

        @Override // com.tencent.mm.kernel.a.b.b
        public void parallelsDependency() {
            AppMethodBeat.i(20328);
            com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(g.ah(s.class));
            AppMethodBeat.o(20328);
        }

        @Override // com.tencent.mm.kernel.api.e
        public void onDataBaseOpened(com.tencent.mm.storagebase.h hVar, com.tencent.mm.storagebase.h hVar2) {
            AppMethodBeat.i(20329);
            c unused = bg.this.iDn;
            AppMethodBeat.o(20329);
        }

        @Override // com.tencent.mm.kernel.api.e
        public void onDataBaseClosed(com.tencent.mm.storagebase.h hVar, com.tencent.mm.storagebase.h hVar2) {
        }

        @Override // com.tencent.mm.kernel.api.a
        public HashMap<Integer, h.b> collectDatabaseFactory() {
            AppMethodBeat.i(20330);
            Log.i("MicroMsg.MMCore", "collectDatabaseFactory ");
            HashMap<Integer, h.b> hashMap = new HashMap<>();
            hashMap.putAll(c.baseDBFactories);
            AppMethodBeat.o(20330);
            return hashMap;
        }
    }

    private bg(aw awVar, t.a aVar) {
        AppMethodBeat.i(20341);
        this.iDw = awVar;
        this.iDB = new c.a() {
            /* class com.tencent.mm.model.bg.AnonymousClass1 */

            @Override // com.tencent.mm.model.c.a
            public final void fo(boolean z) {
                AppMethodBeat.i(CdnLogic.kMediaTypeHWDevice);
                Log.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", Long.valueOf(Thread.currentThread().getId()), Util.getStack());
                bg.b(bg.this);
                long currentTimeMillis = System.currentTimeMillis();
                bg.aVF();
                long beginTransaction = c.getDataDB().beginTransaction(Thread.currentThread().getId());
                c unused = bg.this.iDn;
                if (z) {
                    Log.i("MicroMsg.MMCore", "[doAccountPostReset] updated is true");
                    c.aSN().aNa("readerapp");
                    c.azQ().set(256, Boolean.TRUE);
                    Log.i("MicroMsg.MMCore", "[doAccountPostReset] begin to updated HardCodeUpdate");
                    List<as> aUZ = ab.aUZ();
                    Log.i("MicroMsg.HardCodeUpdateTask", "[updateHelperIndexFor50] size:%s", Integer.valueOf(aUZ.size()));
                    for (as asVar : aUZ) {
                        if (!(asVar == null || ((int) asVar.gMZ) == 0 || asVar.field_showHead != 32)) {
                            asVar.nd(asVar.aqN());
                            Log.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + asVar.field_username);
                            bg.aVF();
                            c.aSN().c(asVar.field_username, asVar);
                        }
                    }
                    String[] strArr = ab.iCO;
                    for (String str : strArr) {
                        as Kn = c.aSN().Kn(str);
                        if (Kn != null && (((int) Kn.gMZ) != 0 || com.tencent.mm.contact.c.oR(Kn.field_type))) {
                            Kn.aqZ();
                            c.aSN().c(str, Kn);
                        }
                    }
                    al.aVk();
                    br.KA("ver" + com.tencent.mm.protocal.d.KyO);
                }
                br.b(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_media_fade_switch, 1), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_media_fade_thumb_scale, 0.75f), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_media_fade_image_preview_scale, 0.4f), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_media_fade_image_preview_scale, 0.4f));
                new ak(bg.this.iDn);
                if (z) {
                    ak.L(c.aSN().Kn("filehelper"));
                    String aTY = z.aTY();
                    if (!Util.isNullOrNil(aTY)) {
                        as Kn2 = c.aSN().Kn(aTY);
                        if (((int) Kn2.gMZ) == 0) {
                            Kn2.setUsername(aTY);
                            Kn2.aqQ();
                            bg.aVF();
                            c.aSN().ap(Kn2);
                        } else if (!com.tencent.mm.contact.c.oR(Kn2.field_type)) {
                            Kn2.aqQ();
                            bg.aVF();
                            c.aSN().c(aTY, Kn2);
                        }
                    }
                    ak.a(z, "qqmail", false);
                    ak.a(z, "floatbottle", false);
                    ak.a(z, "shakeapp", false);
                    ak.a(z, "lbsapp", false);
                    ak.a(z, "medianote", false);
                    ak.a(z, "newsapp", true);
                    c.aST().bjW("blogapp");
                    c.aSQ().aEE("blogapp");
                    c.aSN().aNa("blogapp");
                    ak.a(z, "facebookapp", true);
                    ak.a(z, "qqfriend", false);
                    ak.a(z, "masssendapp", true);
                    ak.a(z, "feedsapp", true);
                    c.aST().bjW("tmessage");
                    c.aSN().aNa("tmessage");
                    as Kn3 = c.aSN().Kn("voip");
                    as Kn4 = c.aSN().Kn("voipapp");
                    if (Kn4 == null) {
                        Kn4 = new as();
                    }
                    if (!(Kn3 == null || ((int) Kn3.gMZ) == 0)) {
                        c.aSN().aNa("voip");
                    }
                    if (((int) Kn4.gMZ) == 0) {
                        Kn4.setUsername("voipapp");
                        Kn4.aqQ();
                        ak.M(Kn4);
                        Kn4.ni(4);
                        Kn4.aqZ();
                        c.aSN().aq(Kn4);
                    } else if (z) {
                        Kn4.aqZ();
                        c.aSN().c("voipapp", Kn4);
                    }
                    as Kn5 = c.aSN().Kn("officialaccounts");
                    if (Kn5 == null) {
                        Kn5 = new as();
                    }
                    Log.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) Kn5.gMZ));
                    if (((int) Kn5.gMZ) == 0) {
                        Kn5.setUsername("officialaccounts");
                        Kn5.aqR();
                        ak.M(Kn5);
                        Kn5.ni(3);
                        c.aSN().aq(Kn5);
                    } else if (z) {
                        Log.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        Kn5.aqR();
                        c.aSN().c("officialaccounts", Kn5);
                    }
                    as Kn6 = c.aSN().Kn("voipaudio");
                    as Kn7 = c.aSN().Kn("voicevoipapp");
                    if (Kn7 == null) {
                        Kn7 = new as();
                    }
                    if (!(Kn6 == null || ((int) Kn6.gMZ) == 0)) {
                        c.aSN().aNa("voipaudio");
                    }
                    if (((int) Kn7.gMZ) == 0) {
                        Kn7.setUsername("voicevoipapp");
                        Kn7.aqQ();
                        ak.M(Kn7);
                        Kn7.ni(4);
                        Kn7.aqZ();
                        c.aSN().aq(Kn7);
                    } else if (z) {
                        Kn7.aqZ();
                        c.aSN().c("voicevoipapp", Kn7);
                    }
                    ak.a(z, "voiceinputapp", false);
                    ak.a(z, "linkedinplugin", false);
                    as Kn8 = c.aSN().Kn("notifymessage");
                    if (Kn8 == null) {
                        Kn8 = new as();
                    }
                    Log.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) Kn8.gMZ));
                    if (((int) Kn8.gMZ) == 0) {
                        Kn8.setUsername("notifymessage");
                        Kn8.aqR();
                        ak.M(Kn8);
                        Kn8.ni(3);
                        c.aSN().aq(Kn8);
                    } else if (z) {
                        Log.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        Kn8.aqR();
                        c.aSN().c("notifymessage", Kn8);
                    }
                    as Kn9 = c.aSN().Kn("appbrandcustomerservicemsg");
                    if (Kn9 == null) {
                        Kn9 = new as();
                    }
                    Log.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) Kn9.gMZ));
                    if (((int) Kn9.gMZ) == 0) {
                        Kn9.setUsername("appbrandcustomerservicemsg");
                        Kn9.aqR();
                        ak.M(Kn9);
                        Kn9.setType(0);
                        Kn9.ni(3);
                        c.aSN().aq(Kn9);
                    } else if (z) {
                        Log.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
                        Kn9.aqR();
                        c.aSN().c("appbrandcustomerservicemsg", Kn9);
                    }
                    as Kn10 = c.aSN().Kn("appbrand_notify_message");
                    if (Kn10 == null) {
                        Kn10 = new as();
                    }
                    Log.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandNotifyMessage:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) Kn10.gMZ));
                    if (((int) Kn10.gMZ) == 0) {
                        Kn10.setUsername("appbrand_notify_message");
                        Kn10.aqR();
                        ak.M(Kn10);
                        Kn10.ni(3);
                        c.aSN().aq(Kn10);
                    } else if (z) {
                        Log.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
                        Kn10.aqR();
                        c.aSN().c("appbrand_notify_message", Kn10);
                    }
                    ak.a(z, "downloaderapp", true);
                    if (z) {
                        bg.aVF();
                        c.aST().bjW("Weixin");
                        bg.aVF();
                        c.aSN().aNa("Weixin");
                    }
                }
                bg.aVF();
                c.getDataDB().endTransaction(beginTransaction);
                Log.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", Boolean.valueOf(z), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Util.getStack());
                c unused2 = bg.this.iDn;
                c.aST().a(bg.aVI().iDw.Xh());
                AppMethodBeat.o(CdnLogic.kMediaTypeHWDevice);
            }
        };
        g.aAi();
        g.b(a.class, new a());
        g.aAi().hro.add(aVar);
        this.iDn = new c();
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(99, 142, 1, false);
        x.a(new com.tencent.mm.plugin.zero.a.e() {
            /* class com.tencent.mm.model.bg.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.zero.a.e
            public final byte[] a(l.d dVar, int i2) {
                AppMethodBeat.i(20323);
                switch (i2) {
                    case 107:
                        byte[] byteArray = ((v.a) dVar).keW.KPW.getBuffer().toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray;
                    case 145:
                        byte[] byteArray2 = ((n.a) dVar).KzI.KPW.getBuffer().toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray2;
                    case v2helper.EMethodSetIosMicAbCheckOff /*{ENCODED_INT: 429}*/:
                        byte[] byteArray3 = ((u.a) dVar).keU.KPW.getBuffer().toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray3;
                    case com.tencent.mm.plugin.appbrand.jsapi.audio.n.CTRL_INDEX /*{ENCODED_INT: 481}*/:
                        byte[] byteArray4 = ((s.a) dVar).keR.KPW.getBuffer().toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray4;
                    case j.CTRL_INDEX /*{ENCODED_INT: 499}*/:
                        byte[] byteArray5 = ((c.a) dVar).CxL.KPW.getBuffer().toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray5;
                    case 572:
                        byte[] byteArray6 = ((t.a) dVar).keT.KPW.getBuffer().toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray6;
                    case 616:
                        byte[] byteArray7 = ((bk.a) dVar).iDS.KPW.getBuffer().toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray7;
                    case 617:
                        byte[] byteArray8 = ((bm.a) dVar).iDW.KPW.getBuffer().toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray8;
                    case ce.CTRL_INDEX /*{ENCODED_INT: 618}*/:
                        byte[] byteArray9 = ((bl.a) dVar).iDU.KPW.getBuffer().toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray9;
                    case 694:
                        byte[] byteArray10 = ((b.a) dVar).CxL.KPW.getBuffer().toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray10;
                    case 722:
                        byte[] byteArray11 = ((q.a) dVar).KzQ.LsW.KPW.getBuffer().toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray11;
                    case 987:
                    case TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR /*{ENCODED_INT: 997}*/:
                        byte[] byteArray12 = ((aak) ((d.b) dVar).iLR).LlC.toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray12;
                    case dg.CTRL_INDEX /*{ENCODED_INT: 989}*/:
                        byte[] byteArray13 = ((blg) ((d.b) dVar).iLR).LlC.toByteArray();
                        AppMethodBeat.o(20323);
                        return byteArray13;
                    case 1000:
                        byte[] bArr = ((k.a) dVar).KzD;
                        AppMethodBeat.o(20323);
                        return bArr;
                    default:
                        AppMethodBeat.o(20323);
                        return null;
                }
            }
        });
        g.aAi();
        com.tencent.mm.kernel.b aAg = g.aAg();
        aAg.hqh.add(new com.tencent.mm.kernel.api.d() {
            /* class com.tencent.mm.model.bg.AnonymousClass3 */

            @Override // com.tencent.mm.kernel.api.d
            public final void b(com.tencent.mm.network.g gVar) {
                AppMethodBeat.i(20324);
                com.tencent.mm.modelstat.q.d(gVar);
                com.tencent.mm.modelstat.q.e(gVar);
                AppMethodBeat.o(20324);
            }
        });
        AppMethodBeat.o(20341);
    }

    private static bg aVC() {
        AppMethodBeat.i(20342);
        Assert.assertNotNull("MMCore not initialized by MMApplication", iDx);
        bg bgVar = iDx;
        AppMethodBeat.o(20342);
        return bgVar;
    }

    public static an aVD() {
        AppMethodBeat.i(20343);
        g.aAi();
        an anVar = g.aAh().hqB;
        AppMethodBeat.o(20343);
        return anVar;
    }

    @Deprecated
    public static MMHandlerThread aAk() {
        AppMethodBeat.i(20344);
        MMHandlerThread aAk = g.aAk();
        AppMethodBeat.o(20344);
        return aAk;
    }

    public static cj getSysCmdMsgExtension() {
        AppMethodBeat.i(20345);
        cj sysCmdMsgExtension = ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension();
        AppMethodBeat.o(20345);
        return sysCmdMsgExtension;
    }

    public static String azt() {
        AppMethodBeat.i(20346);
        String azt = com.tencent.mm.kernel.a.azt();
        AppMethodBeat.o(20346);
        return azt;
    }

    public static void aVE() {
        AppMethodBeat.i(20347);
        EventCenter.instance.publish(new ae());
        AppMethodBeat.o(20347);
    }

    public static c aVF() {
        AppMethodBeat.i(20348);
        c cVar = aVC().iDn;
        Assert.assertTrue("MMCore has not been initialize ?", cVar != null);
        AppMethodBeat.o(20348);
        return cVar;
    }

    public static com.tencent.mm.ak.t azz() {
        AppMethodBeat.i(20349);
        g.aAi();
        com.tencent.mm.ak.t tVar = g.aAg().hqi;
        AppMethodBeat.o(20349);
        return tVar;
    }

    public static boolean aVG() {
        AppMethodBeat.i(20351);
        g.aAf();
        boolean azo = com.tencent.mm.kernel.a.azo();
        AppMethodBeat.o(20351);
        return azo;
    }

    public static boolean aAc() {
        AppMethodBeat.i(20352);
        if (!MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(20352);
            return false;
        }
        boolean aAc = g.aAc();
        AppMethodBeat.o(20352);
        return aAc;
    }

    public static boolean azj() {
        AppMethodBeat.i(20353);
        boolean azj = com.tencent.mm.kernel.a.azj();
        AppMethodBeat.o(20353);
        return azj;
    }

    public static void hold() {
        AppMethodBeat.i(20354);
        com.tencent.mm.kernel.a.hold();
        AppMethodBeat.o(20354);
    }

    public static void unhold() {
        AppMethodBeat.i(20355);
        com.tencent.mm.kernel.a.unhold();
        AppMethodBeat.o(20355);
    }

    public static String ayX() {
        AppMethodBeat.i(20356);
        g.aAi();
        g.aAf();
        String ayX = com.tencent.mm.kernel.a.ayX();
        AppMethodBeat.o(20356);
        return ayX;
    }

    public static f aVH() {
        AppMethodBeat.i(20357);
        f fVar = aVC().iDK;
        AppMethodBeat.o(20357);
        return fVar;
    }

    static /* synthetic */ void b(bg bgVar) {
        AppMethodBeat.i(20358);
        c.aSN().a(bgVar.iDH);
        c.aST().c(bgVar.iDJ);
        c.aST().a(bgVar.iDI);
        h.d.a(9999, bgVar.iDC);
        h.d.a(41, bgVar.iDD);
        h.d.a(21, bgVar.iDE);
        h.d.a(35, bgVar.iDE);
        h.d.a(-1879048175, bgVar.iDF);
        h.d.a(-1879048174, bgVar.iDG);
        cj sysCmdMsgExtension = ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension();
        sysCmdMsgExtension.a("addcontact", bgVar.iDK);
        sysCmdMsgExtension.a("dynacfg", bgVar.iDK);
        sysCmdMsgExtension.a("dynacfg_split", bgVar.iDK);
        sysCmdMsgExtension.a("banner", bgVar.iDK);
        sysCmdMsgExtension.a("midinfo", bgVar.iDK);
        sysCmdMsgExtension.a("revokemsg", bgVar.iDK);
        sysCmdMsgExtension.a("clouddelmsg", bgVar.iDK);
        sysCmdMsgExtension.a("updatepackage", bgVar.iDK);
        sysCmdMsgExtension.a("deletepackage", bgVar.iDK);
        sysCmdMsgExtension.a("delchatroommember", bgVar.iDK);
        sysCmdMsgExtension.a("WakenPush", bgVar.iDK);
        sysCmdMsgExtension.a("DisasterNotice", bgVar.iDK);
        sysCmdMsgExtension.a("EmotionKv", bgVar.iDK);
        sysCmdMsgExtension.a("globalalert", bgVar.iDK);
        sysCmdMsgExtension.a("yybsigcheck", bgVar.iDK);
        sysCmdMsgExtension.a("qy_status_notify", bgVar.iDK);
        sysCmdMsgExtension.a("qy_chat_update", bgVar.iDK);
        sysCmdMsgExtension.a("qy_revoke_msg", bgVar.iDK);
        sysCmdMsgExtension.a("bindmobiletip", bgVar.iDK);
        sysCmdMsgExtension.a("ClientCheckConsistency", bgVar.iDK);
        sysCmdMsgExtension.a("ClientCheckHook", bgVar.iDK);
        sysCmdMsgExtension.a("ClientCheckGetAppList", bgVar.iDK);
        sysCmdMsgExtension.a("ClientCheckGetExtInfo", bgVar.iDK);
        sysCmdMsgExtension.a("functionmsg", bgVar.iDK);
        sysCmdMsgExtension.a("paymsg", bgVar.iDK);
        AppMethodBeat.o(20358);
    }
}
