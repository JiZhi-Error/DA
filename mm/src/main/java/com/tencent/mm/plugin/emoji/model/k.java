package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.b;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.e.b;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.a;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.e;
import com.tencent.mm.storage.emotion.g;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.view.SmileyPanelImpl;
import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;

public class k implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private d rbQ;
    private c rbR;
    private bf rbS;
    private f rbT;
    private l rbU;
    private h rbV;
    private f rbW;
    private a<c> rbX;
    private volatile g rbY;
    private volatile b rbZ;
    private volatile i rca;
    private com.tencent.mm.av.a.a rcb;

    private static k cGb() {
        AppMethodBeat.i(108641);
        k kVar = (k) y.at(k.class);
        AppMethodBeat.o(108641);
        return kVar;
    }

    public static com.tencent.mm.av.a.a cGc() {
        AppMethodBeat.i(108642);
        com.tencent.mm.kernel.g.aAf().azk();
        if (cGb().rcb == null) {
            b.a aVar = new b.a(MMApplicationContext.getContext());
            aVar.jaU = new com.tencent.mm.plugin.emoji.d.a();
            aVar.jaS = new com.tencent.mm.view.c.a();
            com.tencent.mm.av.a.a.b bdd = aVar.bdd();
            cGb().rcb = new com.tencent.mm.av.a.a(bdd);
        }
        com.tencent.mm.av.a.a aVar2 = cGb().rcb;
        AppMethodBeat.o(108642);
        return aVar2;
    }

    public static d cGd() {
        AppMethodBeat.i(108643);
        com.tencent.mm.kernel.g.aAf().azk();
        if (cGb().rbQ == null) {
            cGb().rbQ = new d();
        }
        d dVar = cGb().rbQ;
        AppMethodBeat.o(108643);
        return dVar;
    }

    public static c cGe() {
        AppMethodBeat.i(240152);
        com.tencent.mm.kernel.g.aAf().azk();
        if (cGb().rbR == null) {
            cGb().rbR = new c();
        }
        c cVar = cGb().rbR;
        AppMethodBeat.o(240152);
        return cVar;
    }

    public static bf getEmojiDescMgr() {
        AppMethodBeat.i(108644);
        if (cGb().rbS == null) {
            cGb().rbS = bf.gCF();
        }
        bf bfVar = cGb().rbS;
        AppMethodBeat.o(108644);
        return bfVar;
    }

    public static f cGf() {
        AppMethodBeat.i(108645);
        com.tencent.mm.kernel.g.aAf().azk();
        if (cGb().rbT == null) {
            cGb().rbT = new f();
        }
        f fVar = cGb().rbT;
        AppMethodBeat.o(108645);
        return fVar;
    }

    public static a<c> cGg() {
        AppMethodBeat.i(108646);
        com.tencent.mm.kernel.g.aAf().azk();
        if (cGb().rbX == null) {
            cGb().rbX = new a<>();
        }
        a<c> aVar = cGb().rbX;
        AppMethodBeat.o(108646);
        return aVar;
    }

    private static synchronized g cGh() {
        g gVar;
        synchronized (k.class) {
            AppMethodBeat.i(108647);
            com.tencent.mm.kernel.g.aAf().azk();
            if (cGb().rbY == null) {
                cGb().rbY = new g();
            }
            gVar = cGb().rbY;
            AppMethodBeat.o(108647);
        }
        return gVar;
    }

    private static com.tencent.mm.plugin.emoji.e.b cGi() {
        AppMethodBeat.i(108648);
        com.tencent.mm.kernel.g.aAf().azk();
        if (cGb().rbZ == null) {
            cGb().rbZ = new com.tencent.mm.plugin.emoji.e.b();
        }
        com.tencent.mm.plugin.emoji.e.b bVar = cGb().rbZ;
        AppMethodBeat.o(108648);
        return bVar;
    }

    public static bj getEmojiStorageMgr() {
        AppMethodBeat.i(108649);
        bj gCJ = bj.gCJ();
        AppMethodBeat.o(108649);
        return gCJ;
    }

    public static i cGj() {
        AppMethodBeat.i(108650);
        com.tencent.mm.kernel.g.aAf().azk();
        if (cGb().rca == null) {
            cGb().rca = new i();
        }
        i iVar = cGb().rca;
        AppMethodBeat.o(108650);
        return iVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(108651);
        Log.i("MicroMsg.emoji.SubCoreEmoji", "onAccountRelease: ");
        g cGh = cGh();
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("emotionstore", cGh.qZE, true);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("NewRecommendEmotion", cGh.qZF, true);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("EmojiBackup", cGh.qZG, true);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("EmotionBackup", cGh.qZG, true);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("SelfieEmojiBackup", cGh.qZG, true);
        com.tencent.mm.plugin.emoji.e.b cGi = cGi();
        com.tencent.mm.plugin.emoji.e.b.appForegroundListener.dead();
        EventCenter.instance.removeListener(cGi.qZf);
        EventCenter.instance.removeListener(cGi.qZj);
        EventCenter.instance.removeListener(cGi.qZk);
        EventCenter.instance.removeListener(cGi.qZl);
        EventCenter.instance.removeListener(cGi.qZm);
        EventCenter.instance.removeListener(cGi.qZn);
        EventCenter.instance.removeListener(cGi.checkLanguageChangeIListener);
        EventCenter.instance.removeListener(cGi.qZo);
        EventCenter.instance.removeListener(cGi.qZp);
        EventCenter.instance.removeListener(cGi.qZg);
        EventCenter.instance.removeListener(cGi.qZh);
        EventCenter.instance.removeListener(cGi.qZq);
        EventCenter.instance.removeListener(cGi.qZr);
        EventCenter.instance.removeListener(cGi.qZi);
        bj gCJ = bj.gCJ();
        gCJ.OpN.remove(gCJ.wKf);
        gCJ.OpO.remove(gCJ.Oqf);
        gCJ.OpP.remove(gCJ.Oqg);
        EventCenter.instance.removeListener(gCJ.wKg);
        j jVar = gCJ.Oqb;
        if (jVar.gXk != null) {
            jVar.gXk.clear();
        }
        jVar.gXl.evictAll();
        getEmojiDescMgr().clear();
        ((d) com.tencent.mm.kernel.g.ah(d.class)).removeEmojiMgr();
        d cGd = cGd();
        com.tencent.mm.kernel.g.aAg().hqi.b(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, cGd);
        cGd.rba.clear();
        cGd.rbe.clear();
        c cGe = cGe();
        com.tencent.mm.kernel.g.aAg().hqi.b(3862, cGe);
        com.tencent.mm.kernel.g.aAg().hqi.b(697, cGe);
        cGe.rba.clear();
        cGe.rbb.clear();
        i cGj = cGj();
        cGj.raB = null;
        if (cGj.raC != null) {
            cGj.raC.clear();
        }
        BKGLoaderManager bKGLoaderManager = cGg().rds;
        Log.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
        bKGLoaderManager.cGB();
        EventCenter.instance.removeListener(bKGLoaderManager.rdQ);
        EventCenter.instance.removeListener(bKGLoaderManager.rdR);
        if (bKGLoaderManager.rdM != null) {
            MMApplicationContext.getContext().unregisterReceiver(bKGLoaderManager.rdM);
            bKGLoaderManager.rdM = null;
        }
        if (this.rbU != null) {
            l lVar = this.rbU;
            EventCenter.instance.removeListener(lVar.rcg);
            EventCenter.instance.removeListener(lVar.rch);
        }
        if (this.rbV != null) {
            h hVar = this.rbV;
            hVar.rby.clear();
            cGd().rbg = null;
            hVar.rbz.dead();
        }
        if (this.rcb != null) {
            this.rcb.detach();
        }
        com.tencent.mm.aq.b.bby().iUx.dead();
        EmojiSyncManager.a aVar = EmojiSyncManager.hda;
        EmojiSyncManager.a.awn().destroy();
        EmojiSyncManager.a aVar2 = EmojiSyncManager.hda;
        EmojiSyncManager.a.awo().destroy();
        AppMethodBeat.o(108651);
    }

    static {
        AppMethodBeat.i(108654);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("EMOJIINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.storage.emotion.f.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("EMOJIGROUPINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass10 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.storage.emotion.c.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass11 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return e.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass12 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return m.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass13 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.storage.emotion.s.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass14 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return o.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass15 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.storage.emotion.k.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass16 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return q.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass17 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return t.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return u.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.storage.emotion.i.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("EmojiDesignerProductStorage_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.storage.emotion.b.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("EmojiSuggestCacheStorage".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                AppMethodBeat.i(240149);
                g.a aVar = com.tencent.mm.storage.emotion.g.OsH;
                String[] frw = com.tencent.mm.storage.emotion.g.frw();
                AppMethodBeat.o(240149);
                return frw;
            }
        });
        baseDBFactories.put(Integer.valueOf("DELETE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass6 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return new String[]{"DROP TABLE IF EXISTS EmotionDetail ", "DROP TABLE IF EXISTS EmojiSummaryInfo", "DROP TABLE IF EXISTS RewardMagicInfo"};
            }
        });
        AppMethodBeat.o(108654);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        long j2;
        AppMethodBeat.i(108652);
        Log.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
        com.tencent.mm.pluginsdk.ui.chat.e.Knc = new e.b() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass7 */

            @Override // com.tencent.mm.pluginsdk.ui.chat.e.b
            public final ChatFooterPanel eZ(Context context) {
                AppMethodBeat.i(240150);
                SmileyPanelImpl smileyPanelImpl = new SmileyPanelImpl(context, false);
                AppMethodBeat.o(240150);
                return smileyPanelImpl;
            }
        };
        com.tencent.mm.pluginsdk.ui.chat.e.Knd = new e.a() {
            /* class com.tencent.mm.plugin.emoji.model.k.AnonymousClass8 */
        };
        bj.gCJ().gCK();
        ((d) com.tencent.mm.kernel.g.ah(d.class)).setEmojiMgr();
        com.tencent.mm.plugin.emoji.e.g cGh = cGh();
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("emotionstore", (cj.a) cGh.qZE, true);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("NewRecommendEmotion", (cj.a) cGh.qZF, true);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("EmojiBackup", (cj.a) cGh.qZG, true);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("EmotionBackup", (cj.a) cGh.qZG, true);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("SelfieEmojiBackup", (cj.a) cGh.qZG, true);
        com.tencent.mm.plugin.emoji.e.b cGi = cGi();
        EventCenter.instance.addListener(cGi.qZf);
        EventCenter.instance.addListener(cGi.qZj);
        EventCenter.instance.addListener(cGi.qZk);
        EventCenter.instance.addListener(cGi.qZl);
        com.tencent.mm.plugin.emoji.e.b.appForegroundListener.alive();
        EventCenter.instance.addListener(cGi.qZm);
        EventCenter.instance.addListener(cGi.qZn);
        EventCenter.instance.addListener(cGi.checkLanguageChangeIListener);
        EventCenter.instance.addListener(cGi.qZo);
        EventCenter.instance.addListener(cGi.qZp);
        EventCenter.instance.addListener(cGi.qZg);
        EventCenter.instance.addListener(cGi.qZh);
        EventCenter.instance.addListener(cGi.qZq);
        EventCenter.instance.addListener(cGi.qZr);
        EventCenter.instance.addListener(cGi.qZi);
        bj gCJ = bj.gCJ();
        gCJ.OpN.add(gCJ.wKf);
        gCJ.OpO.add(gCJ.Oqf);
        gCJ.OpP.add(gCJ.Oqg);
        EventCenter.instance.addListener(gCJ.wKg);
        getEmojiDescMgr();
        i cGj = cGj();
        String value = com.tencent.mm.n.h.aqJ().getValue("EmotionRewardTipsLimit");
        if (!Util.isNullOrNil(value)) {
            Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", value);
            String[] split = value.split(",");
            if (split != null && split.length == 3) {
                if (Util.getInt(split[0], 0) == 0) {
                    j2 = 863913600000L;
                } else {
                    j2 = ((long) Util.getInt(split[0], 0)) * Util.MILLSECONDS_OF_DAY;
                }
                cGj.raz = j2;
                cGj.raA = Util.getInt(split[1], 20) - 1;
                cGj.cSs = Util.getInt(split[2], 80) - 1;
            }
        }
        boolean auW = n.auW();
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_EMOJI_REWARD_TIP_ENABLE_BOOLEAN, Boolean.TRUE)).booleanValue();
        cGj.ray = auW && booleanValue;
        Log.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", Boolean.valueOf(cGj.ray), Boolean.valueOf(auW), Boolean.valueOf(booleanValue));
        com.tencent.mm.kernel.g.aAk().postToWorker(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01cc: INVOKE  
              (wrap: com.tencent.mm.sdk.platformtools.MMHandlerThread : 0x01c3: INVOKE  (r0v41 com.tencent.mm.sdk.platformtools.MMHandlerThread) =  type: STATIC call: com.tencent.mm.kernel.g.aAk():com.tencent.mm.sdk.platformtools.MMHandlerThread)
              (wrap: com.tencent.mm.plugin.emoji.e.i$1 : 0x01c9: CONSTRUCTOR  (r1v27 com.tencent.mm.plugin.emoji.e.i$1) = (r2v21 'cGj' com.tencent.mm.plugin.emoji.e.i) call: com.tencent.mm.plugin.emoji.e.i.1.<init>(com.tencent.mm.plugin.emoji.e.i):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToWorker(java.lang.Runnable):int in method: com.tencent.mm.plugin.emoji.model.k.onAccountPostReset(boolean):void, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01c9: CONSTRUCTOR  (r1v27 com.tencent.mm.plugin.emoji.e.i$1) = (r2v21 'cGj' com.tencent.mm.plugin.emoji.e.i) call: com.tencent.mm.plugin.emoji.e.i.1.<init>(com.tencent.mm.plugin.emoji.e.i):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.emoji.model.k.onAccountPostReset(boolean):void, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.emoji.e.i, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 1134
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.model.k.onAccountPostReset(boolean):void");
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    public static f cGk() {
        AppMethodBeat.i(108653);
        com.tencent.mm.kernel.g.aAf().azk();
        if (cGb().rbW == null) {
            cGb().rbW = new f();
        }
        f fVar = cGb().rbW;
        AppMethodBeat.o(108653);
        return fVar;
    }
}
