package com.tencent.mm.plugin.multitalk.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.app.o;
import com.tencent.mm.blink.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.multitalk.b.p;
import com.tencent.mm.plugin.multitalk.c.c;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.protocal.protobuf.ert;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Map;

public class ac implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.multitalk.model.ac.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(114620);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!com.tencent.mm.kernel.a.azj()) {
                    b.ake().arrange(new Runnable() {
                        /* class com.tencent.mm.plugin.multitalk.model.ac.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(114619);
                            if (ac.eom().czl()) {
                                Log.i("MicroMsg.SubCoreMultiTalk", "multitalk resume on app foreground");
                                q eom = ac.eom();
                                if (eom.zNe != null) {
                                    Log.i("MicroMsg.MT.MultiTalkManager", "on multitalk resume");
                                    eom.a(eom.zNe.zNs, eom.zNe.zNt);
                                    eom.enB();
                                }
                                AppMethodBeat.o(114619);
                                return;
                            }
                            Log.i("MicroMsg.SubCoreMultiTalk", "do not need resume multitalk ");
                            AppMethodBeat.o(114619);
                        }
                    });
                }
            }
            AppMethodBeat.o(114620);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(114621);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                com.tencent.mm.kernel.a.azj();
            }
            AppMethodBeat.o(114621);
        }
    };
    private cm.a wUb = new cm.a() {
        /* class com.tencent.mm.plugin.multitalk.model.ac.AnonymousClass4 */

        @Override // com.tencent.mm.model.cm.a
        public final boolean aWC() {
            AppMethodBeat.i(114622);
            Log.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
            if (ac.this.zOP != null) {
                ac.this.zOP.qm(true);
                if (ac.this.zOP.zME != null) {
                    Log.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", v.g(ac.this.zOP.zME));
                }
            }
            AppMethodBeat.o(114622);
            return true;
        }
    };
    private o zOO;
    private q zOP;
    private n zOQ;
    private m zOR;
    private u zOS;
    private a zOT;
    private s zOU;
    private com.tencent.mm.plugin.multitalk.c.a zOV;
    private c zOW;
    private r zOX;

    public ac() {
        AppMethodBeat.i(114624);
        AppMethodBeat.o(114624);
    }

    static {
        AppMethodBeat.i(114636);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.multitalk.model.ac.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.multitalk.c.a.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("MULTITALKMEMBER_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.multitalk.model.ac.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return c.SQL_CREATE;
            }
        });
        AppMethodBeat.o(114636);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    private static ac eoh() {
        AppMethodBeat.i(114625);
        ac acVar = (ac) y.at(ac.class);
        AppMethodBeat.o(114625);
        return acVar;
    }

    public static com.tencent.mm.plugin.multitalk.c.a eoi() {
        AppMethodBeat.i(114626);
        g.aAf();
        if (com.tencent.mm.kernel.a.getUin() == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(114626);
            throw bVar;
        }
        if (eoh().zOV == null) {
            eoh().zOV = new com.tencent.mm.plugin.multitalk.c.a(g.aAh().hqK);
        }
        com.tencent.mm.plugin.multitalk.c.a aVar = eoh().zOV;
        AppMethodBeat.o(114626);
        return aVar;
    }

    public static c eoj() {
        AppMethodBeat.i(114627);
        g.aAf();
        if (com.tencent.mm.kernel.a.getUin() == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(114627);
            throw bVar;
        }
        if (eoh().zOW == null) {
            eoh().zOW = new c(g.aAh().hqK);
        }
        c cVar = eoh().zOW;
        AppMethodBeat.o(114627);
        return cVar;
    }

    public static u eok() {
        AppMethodBeat.i(114628);
        g.aAf().azk();
        if (eoh().zOS == null) {
            eoh().zOS = new u();
        }
        u uVar = eoh().zOS;
        AppMethodBeat.o(114628);
        return uVar;
    }

    public static o eol() {
        AppMethodBeat.i(114629);
        g.aAf().azk();
        if (eoh().zOO == null) {
            eoh().zOO = new o();
        }
        o oVar = eoh().zOO;
        AppMethodBeat.o(114629);
        return oVar;
    }

    public static q eom() {
        AppMethodBeat.i(114630);
        g.aAf().azk();
        if (eoh().zOP == null) {
            eoh().zOP = new q();
        }
        q qVar = eoh().zOP;
        AppMethodBeat.o(114630);
        return qVar;
    }

    public static n eon() {
        AppMethodBeat.i(239430);
        g.aAf().azk();
        if (eoh().zOQ == null) {
            eoh().zOQ = new n();
        }
        n nVar = eoh().zOQ;
        AppMethodBeat.o(239430);
        return nVar;
    }

    public static m eoo() {
        AppMethodBeat.i(239431);
        g.aAf().azk();
        if (eoh().zOR == null) {
            eoh().zOR = new m();
        }
        m mVar = eoh().zOR;
        AppMethodBeat.o(239431);
        return mVar;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(114632);
        this.zOT = new a();
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("multivoip", (cj.a) this.zOT, true);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("voipmt", (cj.a) this.zOT, true);
        g.aAj().a(this.wUb);
        this.appForegroundListener.alive();
        g.b(d.class, eop());
        eop().enU();
        AppMethodBeat.o(114632);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(114633);
        if (this.zOO != null) {
            o oVar = this.zOO;
            g.azz().b(1918, oVar);
            g.azz().b(1919, oVar);
            g.azz().b(1927, oVar);
            g.azz().b(1928, oVar);
            g.azz().b(1929, oVar);
            g.azz().b(1931, oVar);
            g.azz().b(1932, oVar);
            g.azz().b(1933, oVar);
            g.azz().b(1935, oVar);
            g.azz().b(1937, oVar);
            g.azz().b(1938, oVar);
            g.azz().b(1939, oVar);
            oVar.emL();
            this.zOO = null;
        }
        if (this.zOP != null) {
            q qVar = this.zOP;
            MMApplicationContext.getContext().unregisterReceiver(qVar.zNh);
            EventCenter.instance.removeListener(qVar.hXn);
            qVar.j(false, false, false);
            Log.i("MicroMsg.MT.MultiTalkManager", "steve: account release. uninit ilink so");
            p pVar = p.INSTANCE;
            pVar.aj(pVar.qtQ);
            if (qVar.zNb != null) {
                qVar.zNb.clear();
            }
            this.zOP = null;
        }
        if (this.zOS != null) {
            this.zOS.reset();
            this.zOS = null;
        }
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("multivoip", this.zOT, true);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("voipmt", this.zOT, true);
        g.aAj().b(this.wUb);
        g.ag(d.class);
        AppMethodBeat.o(114633);
    }

    class a implements cj.a {
        a() {
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(114623);
            r eoq = ac.eoq();
            String a2 = z.a(aVar.heO.KHn);
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml.get(".sysmsg.multivoip.notfriendnotifydata") != null) {
                Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:".concat(String.valueOf(a2)));
                AppMethodBeat.o(114623);
                return;
            }
            String str = parseXml.get(".sysmsg.multivoip.notifydata");
            if (str != null) {
                byte[] decode = Base64.decode(Util.nullAs(str, "").getBytes(), 0);
                Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + z.a(aVar.heO.KHn) + " buffer len " + decode.length);
                ac.eol().zMd.dr(Util.nullAsNil((Integer) g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
                ac.eol().zMd.cR(decode);
                AppMethodBeat.o(114623);
                return;
            }
            String str2 = parseXml.get(".sysmsg.multivoip.banner");
            if (str2 != null) {
                eoq.a(str2, aVar);
                AppMethodBeat.o(114623);
                return;
            }
            String str3 = parseXml.get(".sysmsg.voipmt.invite");
            if (str3 != null) {
                byte[] decode2 = Base64.decode(Util.nullAs(str3, "").getBytes(), 0);
                Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive invite " + z.a(aVar.heO.KHn) + " buffer len " + decode2.length);
                p.INSTANCE.y((long) Util.nullAsNil((Integer) g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
                p pVar = p.INSTANCE;
                ert ert = new ert();
                try {
                    ert.parseFrom(decode2);
                    if (pVar.zIX != null && pVar.zIX.get(Long.valueOf(ert.Lnw)) == null) {
                        pVar.zIX.put(Long.valueOf(ert.Lnw), ert);
                    }
                    pVar.qtA = true;
                    pVar.a(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0148: INVOKE  
                          (r0v37 'pVar' com.tencent.mm.plugin.multitalk.b.p)
                          (wrap: com.tencent.mm.plugin.multitalk.b.p$3 : 0x0145: CONSTRUCTOR  (r1v7 com.tencent.mm.plugin.multitalk.b.p$3) = (r0v37 'pVar' com.tencent.mm.plugin.multitalk.b.p), (r2v13 'ert' com.tencent.mm.protocal.protobuf.ert) call: com.tencent.mm.plugin.multitalk.b.p.3.<init>(com.tencent.mm.plugin.multitalk.b.p, com.tencent.mm.protocal.protobuf.ert):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.plugin.multitalk.b.p.a(com.tencent.mm.plugin.multitalk.b.b):void in method: com.tencent.mm.plugin.multitalk.model.ac.a.a(com.tencent.mm.ak.h$a):void, file: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0145: CONSTRUCTOR  (r1v7 com.tencent.mm.plugin.multitalk.b.p$3) = (r0v37 'pVar' com.tencent.mm.plugin.multitalk.b.p), (r2v13 'ert' com.tencent.mm.protocal.protobuf.ert) call: com.tencent.mm.plugin.multitalk.b.p.3.<init>(com.tencent.mm.plugin.multitalk.b.p, com.tencent.mm.protocal.protobuf.ert):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.multitalk.model.ac.a.a(com.tencent.mm.ak.h$a):void, file: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 36 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.multitalk.b.p, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 42 more
                        */
                    /*
                    // Method dump skipped, instructions count: 457
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.ac.a.a(com.tencent.mm.ak.h$a):void");
                }

                @Override // com.tencent.mm.model.cj.a
                public final void a(h.c cVar) {
                }
            }

            public static s eop() {
                AppMethodBeat.i(114634);
                if (eoh().zOU == null) {
                    eoh().zOU = new s();
                }
                s sVar = eoh().zOU;
                AppMethodBeat.o(114634);
                return sVar;
            }

            public static r eoq() {
                AppMethodBeat.i(114635);
                if (eoh().zOX == null) {
                    eoh().zOX = new r();
                }
                r rVar = eoh().zOX;
                AppMethodBeat.o(114635);
                return rVar;
            }
        }
