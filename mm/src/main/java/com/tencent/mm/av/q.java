package com.tencent.mm.av;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.app.o;
import com.tencent.mm.av.i;
import com.tencent.mm.blink.b;
import com.tencent.mm.cache.g;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;

public class q implements bd {
    private static HashMap<Integer, h.b> baseDBFactories = new HashMap<>();
    private static byte[] zpR = new byte[0];
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.av.q.AnonymousClass2 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(150746);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    b.ake().arrange(new Runnable() {
                        /* class com.tencent.mm.av.q.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(150745);
                            q.bcP().run();
                            AppMethodBeat.o(150745);
                        }
                    });
                    q.bcT().setForeground(true);
                }
            }
            AppMethodBeat.o(150746);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(150747);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    q.bcT().setForeground(false);
                }
            }
            AppMethodBeat.o(150747);
        }
    };
    private i jah;
    private k jai;
    private d jaj;
    private l jak = new l();
    private e jal = null;
    private j jam = new j();
    private b jan = null;
    private r jao = null;
    private IListener jap = new IListener<tv>() {
        /* class com.tencent.mm.av.q.AnonymousClass1 */

        {
            AppMethodBeat.i(161776);
            this.__eventId = tv.class.getName().hashCode();
            AppMethodBeat.o(161776);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tv tvVar) {
            AppMethodBeat.i(150744);
            ca caVar = tvVar.eap.dCM;
            k bcP = q.bcP();
            g H = q.bcR().H(caVar.field_talker, caVar.field_msgId);
            H.te(0);
            q.bcR().a(Long.valueOf(H.localId), H);
            int i2 = H.bcv() ? 1 : 0;
            String o = q.bcR().o(H.iXm, "", "");
            if (o == null || o.equals("") || !s.YS(o)) {
                Log.e("MicroMsg.ImgService", "sendMsgImage: filePath is null or empty");
            } else {
                MMHandlerThread.postToMainThread(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0069: INVOKE  
                      (wrap: com.tencent.mm.av.k$6 : 0x0066: CONSTRUCTOR  (r4v6 com.tencent.mm.av.k$6) = (r2v0 'bcP' com.tencent.mm.av.k), (r3v1 'H' com.tencent.mm.av.g), (r0v5 'i2' int) call: com.tencent.mm.av.k.6.<init>(com.tencent.mm.av.k, com.tencent.mm.av.g, int):void type: CONSTRUCTOR)
                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.av.q.1.callback(com.tencent.mm.g.a.tv):boolean, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0066: CONSTRUCTOR  (r4v6 com.tencent.mm.av.k$6) = (r2v0 'bcP' com.tencent.mm.av.k), (r3v1 'H' com.tencent.mm.av.g), (r0v5 'i2' int) call: com.tencent.mm.av.k.6.<init>(com.tencent.mm.av.k, com.tencent.mm.av.g, int):void type: CONSTRUCTOR in method: com.tencent.mm.av.q.1.callback(com.tencent.mm.g.a.tv):boolean, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.av.k, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 25 more
                    */
                /*
                // Method dump skipped, instructions count: 109
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.av.q.AnonymousClass1.callback(com.tencent.mm.sdk.event.IEvent):boolean");
            }
        };
        private com.tencent.mm.av.a.a jaq = null;
        private SFSContext jar = null;
        private SFSContext jas = null;

        public q() {
            AppMethodBeat.i(150748);
            AppMethodBeat.o(150748);
        }

        static {
            AppMethodBeat.i(150759);
            Iterator<i.c> it = i.d.iYu.iterator();
            while (it.hasNext()) {
                final i.c next = it.next();
                baseDBFactories.put(Integer.valueOf(next.table.hashCode()), new h.b() {
                    /* class com.tencent.mm.av.q.AnonymousClass3 */

                    @Override // com.tencent.mm.storagebase.h.b
                    public final String[] getSQLs() {
                        return next.iYr;
                    }
                });
            }
            AppMethodBeat.o(150759);
        }

        private static q bcO() {
            q qVar;
            AppMethodBeat.i(150749);
            synchronized (zpR) {
                try {
                    qVar = (q) y.at(q.class);
                } finally {
                    AppMethodBeat.o(150749);
                }
            }
            return qVar;
        }

        public static k bcP() {
            AppMethodBeat.i(150750);
            if (bcO().jai == null) {
                bcO().jai = new k();
            }
            k kVar = bcO().jai;
            AppMethodBeat.o(150750);
            return kVar;
        }

        public static d bcQ() {
            AppMethodBeat.i(150751);
            g.aAf().azk();
            if (bcO().jaj == null) {
                bcO().jaj = new d();
            }
            d dVar = bcO().jaj;
            AppMethodBeat.o(150751);
            return dVar;
        }

        public static i bcR() {
            AppMethodBeat.i(150752);
            g.aAf().azk();
            if (bcO().jah == null) {
                bcO().jah = new i(g.aAh().hqK);
            }
            i iVar = bcO().jah;
            AppMethodBeat.o(150752);
            return iVar;
        }

        public static e bcS() {
            AppMethodBeat.i(150753);
            g.aAf().azk();
            if (bcO().jal == null) {
                bcO().jal = new e();
            }
            e eVar = bcO().jal;
            AppMethodBeat.o(150753);
            return eVar;
        }

        public static b bcT() {
            AppMethodBeat.i(150754);
            g.aAf().azk();
            if (bcO().jan == null) {
                bcO().jan = new b(Looper.getMainLooper());
            }
            b bVar = bcO().jan;
            AppMethodBeat.o(150754);
            return bVar;
        }

        public static r bcU() {
            AppMethodBeat.i(150755);
            g.aAf().azk();
            if (bcO().jao == null) {
                bcO().jao = new r();
            }
            r rVar = bcO().jao;
            AppMethodBeat.o(150755);
            return rVar;
        }

        public static com.tencent.mm.av.a.a bcV() {
            AppMethodBeat.i(150756);
            g.aAf().azk();
            if (bcO().jaq == null) {
                bcO().jaq = com.tencent.mm.av.a.a.bdb();
            }
            com.tencent.mm.av.a.a aVar = bcO().jaq;
            AppMethodBeat.o(150756);
            return aVar;
        }

        public static SFSContext bcW() {
            return null;
        }

        @Override // com.tencent.mm.model.bd
        public void onAccountRelease() {
            AppMethodBeat.i(150757);
            q bcO = bcO();
            this.appForegroundListener.dead();
            if (bcO.jai != null) {
                k kVar = bcO.jai;
                kVar.dAF = 0;
                g.aAg().hqi.b(110, kVar);
            }
            if (bcO.jan != null) {
                b bVar = bcO.jan;
                synchronized (bVar.iWI) {
                    try {
                        bVar.iWI.clear();
                        bVar.iWJ = 0;
                        bcS().a(bVar);
                    } catch (Throwable th) {
                        AppMethodBeat.o(150757);
                        throw th;
                    }
                }
                EventCenter.instance.removeListener(bVar.iWS);
                EventCenter.instance.removeListener(bVar.iWT);
            }
            if (bcO.jal != null) {
                e eVar = bcO.jal;
                Log.i("ModelImage.DownloadImgService", "on detach");
                Log.i("ModelImage.DownloadImgService", "cancel all net scene");
                eVar.iXf = true;
                eVar.b(eVar.iXd);
                while (eVar.iXb.size() > 0) {
                    eVar.b(eVar.iXb.get(0));
                }
                eVar.bco();
                g.aAg().hqi.b(109, eVar);
            }
            if (bcO.jao != null) {
                r rVar = bcO.jao;
                Log.i("MicroMsg.UrlImageCacheService", "detach");
                rVar.jaw.clear();
                rVar.jay = true;
            }
            i iVar = bcO().jah;
            if (iVar != null) {
                Log.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", Util.getStack());
                iVar.iXW.clear();
            }
            com.tencent.mm.av.a.a aVar = bcO().jaq;
            if (aVar != null) {
                aVar.detach();
            }
            h.d.b(3, this.jam);
            h.d.b(23, this.jam);
            g.a.a("local_cdn_img_cache", (com.tencent.mm.cache.g) null);
            EventCenter.instance.removeListener(this.jap);
            if (bcO.jaq != null) {
                bcO.jaq.detach();
                bcO.jaq = null;
            }
            if (bcO.jar != null) {
                bcO.jar.release();
                bcO.jar = null;
            }
            if (bcO.jas != null) {
                bcO.jas.release();
                bcO.jas = null;
            }
            AppMethodBeat.o(150757);
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
            AppMethodBeat.i(150758);
            h.d.a(3, this.jam);
            h.d.a(23, this.jam);
            g.a.a("local_cdn_img_cache", this.jak);
            EventCenter.instance.addListener(this.jap);
            this.appForegroundListener.alive();
            AppMethodBeat.o(150758);
        }

        @Override // com.tencent.mm.model.bd
        public void onSdcardMount(boolean z) {
        }
    }
