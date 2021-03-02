package com.tencent.mm.audio.mix.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.audio.mix.b.a.d;
import com.tencent.mm.audio.mix.c.f;
import com.tencent.mm.audio.mix.d.a;
import com.tencent.mm.audio.mix.d.i;
import com.tencent.mm.audio.mix.d.l;
import com.tencent.mm.audio.mix.i.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class c {
    public String appId;
    public d dxa = new d();
    public a dxb = new a(this.dxa);
    public HashMap<String, Boolean> dxc = new HashMap<>();
    private f dxd;
    public d dxe;
    private volatile boolean dxf = false;

    public c() {
        AppMethodBeat.i(136888);
        this.dxa.dxb = this.dxb;
        this.dxd = new f();
        this.dxe = new d();
        AppMethodBeat.o(136888);
    }

    public final void ZH() {
        l lVar;
        AppMethodBeat.i(136889);
        a aVar = this.dxb;
        b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
        Iterator<String> it = aVar.dve.iterator();
        while (it.hasNext()) {
            com.tencent.mm.audio.mix.d.b bVar = aVar.dvb.get(it.next());
            if (bVar != null && !bVar.dvh && !bVar.YT() && (lVar = bVar.dvi) != null && !lVar.YY()) {
                lVar.YV();
            }
        }
        d dVar = this.dxa;
        b.i("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
        dVar.dxo.Zs();
        dVar.ZL();
        f fVar = this.dxd;
        fVar.appId = this.appId;
        if (f.duW == 0) {
            f.duW = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f.duW <= f.duT.longValue()) {
            b.e("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
        } else {
            f.duW = currentTimeMillis;
            b.i("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
            i.a(new f.a("clean audio mix convert cache"));
        }
        com.tencent.mm.audio.mix.b.f YL = com.tencent.mm.audio.mix.b.f.YL();
        synchronized (YL.dup) {
            try {
                Iterator<String> it2 = YL.duo.iterator();
                while (it2.hasNext()) {
                    com.tencent.mm.audio.mix.a.d dVar2 = YL.cache.get(it2.next());
                    if (dVar2 != null && dVar2.aBQ && dVar2.dtV) {
                        dVar2.Ys();
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(136889);
                throw th;
            }
        }
        com.tencent.mm.audio.mix.b.a.Yw().Yy();
        AppMethodBeat.o(136889);
    }

    public final void clearCache() {
        AppMethodBeat.i(136890);
        this.dxb.clearCache();
        this.dxa.clearCache();
        AppMethodBeat.o(136890);
    }

    public final void f(com.tencent.mm.ai.b bVar) {
        e<Integer> eVar;
        boolean z;
        AppMethodBeat.i(136891);
        this.appId = bVar.appId;
        b.i("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", bVar.dtX);
        com.tencent.mm.audio.mix.b.a Yw = com.tencent.mm.audio.mix.b.a.Yw();
        String str = this.appId;
        com.tencent.mm.audio.mix.b.a.f fVar = null;
        if (!TextUtils.isEmpty(Yw.currentAppId) && !str.equals(Yw.currentAppId)) {
            b.i("MicroMsg.Mix.AudioCachePathMgr", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
            String str2 = Yw.currentAppId;
            Yw.currentAppId = str;
            fVar = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0041: CONSTRUCTOR  (r0v65 'fVar' com.tencent.mm.audio.mix.b.a.f) = (r3v1 'Yw' com.tencent.mm.audio.mix.b.a), (r5v17 'str2' java.lang.String), (r4v1 'str' java.lang.String) call: com.tencent.mm.audio.mix.b.a.1.<init>(com.tencent.mm.audio.mix.b.a, java.lang.String, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.audio.mix.g.c.f(com.tencent.mm.ai.b):void, file: classes4.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.audio.mix.b.a, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                */
            /*
            // Method dump skipped, instructions count: 535
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.mix.g.c.f(com.tencent.mm.ai.b):void");
        }

        public final void g(com.tencent.mm.ai.b bVar) {
            AppMethodBeat.i(136892);
            this.dxa.dvc.put(bVar.dtX, bVar);
            this.dxb.dvc.put(bVar.dtX, bVar);
            AppMethodBeat.o(136892);
        }

        public final void h(com.tencent.mm.ai.b bVar) {
            AppMethodBeat.i(136893);
            d dVar = this.dxa;
            if (dVar.dvc.containsKey(bVar.dtX)) {
                dVar.dvc.put(bVar.dtX, bVar);
            }
            a aVar = this.dxb;
            if (aVar.dvc.containsKey(bVar.dtX)) {
                aVar.dvc.put(bVar.dtX, bVar);
            }
            AppMethodBeat.o(136893);
        }

        private com.tencent.mm.ai.b ha(String str) {
            AppMethodBeat.i(136894);
            com.tencent.mm.ai.b ha = this.dxa.ha(str);
            AppMethodBeat.o(136894);
            return ha;
        }

        public final boolean gD(String str) {
            AppMethodBeat.i(136895);
            if (this.dxa.dvc.containsKey(str)) {
                AppMethodBeat.o(136895);
                return true;
            }
            AppMethodBeat.o(136895);
            return false;
        }

        public final void hb(String str) {
            AppMethodBeat.i(136896);
            b.i("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", str, Integer.valueOf(this.dxa.hq(str)));
            i(this.dxa.ha(str));
            d dVar = this.dxa;
            dVar.dxj.set(false);
            dVar.dxi.set(false);
            dVar.ZQ();
            dVar.ZM();
            synchronized (dVar.dxm) {
                try {
                    dVar.dwo.put(str, Boolean.FALSE);
                } catch (Throwable th) {
                    AppMethodBeat.o(136896);
                    throw th;
                }
            }
            dVar.dxo.gQ(str);
            dVar.dxs.remove(str);
            dVar.dxt.put(str, Boolean.TRUE);
            if (dVar.dxb.gN(str) && dVar.dxb.gO(str)) {
                dVar.q(0, str);
            }
            this.dxb.gL(str);
            AppMethodBeat.o(136896);
        }

        private void i(com.tencent.mm.ai.b bVar) {
            AppMethodBeat.i(136897);
            bVar.dtU = true;
            int hj = this.dxa.hj(bVar.dtX);
            int ZR = this.dxa.ZR();
            if (!this.dxf) {
                if (hj <= 2000) {
                    bVar.dtU = false;
                }
                if (hj >= 5000 || ZR > 5) {
                    bVar.dtU = true;
                } else {
                    bVar.dtU = false;
                }
                if (bVar.filePath.contains("scale_intro")) {
                    bVar.dtU = false;
                }
            }
            if (ZR > 5) {
                ArrayList<String> ZS = this.dxa.ZS();
                if (ZS.contains(bVar.dtX)) {
                    ZS.remove(bVar.dtX);
                }
                if (ZS.size() > 2) {
                    b.i("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", Integer.valueOf(ZS.size()));
                    Iterator<String> it = ZS.iterator();
                    while (it.hasNext()) {
                        he(it.next());
                    }
                }
            }
            b.i("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", Integer.valueOf(ZR), Integer.valueOf(hj), Boolean.valueOf(bVar.dtU));
            AppMethodBeat.o(136897);
        }

        public final void hc(String str) {
            AppMethodBeat.i(136898);
            b.i("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", str, Integer.valueOf(this.dxa.hq(str)));
            i(this.dxa.ha(str));
            d dVar = this.dxa;
            dVar.dxj.set(false);
            dVar.dxi.set(false);
            dVar.ZQ();
            dVar.ZM();
            synchronized (dVar.dxm) {
                try {
                    dVar.dwo.put(str, Boolean.FALSE);
                } catch (Throwable th) {
                    AppMethodBeat.o(136898);
                    throw th;
                }
            }
            dVar.dxo.gQ(str);
            dVar.dxs.remove(str);
            dVar.dxt.put(str, Boolean.TRUE);
            if (dVar.dxb.gN(str) && dVar.dxb.gO(str)) {
                dVar.q(1, str);
            }
            this.dxb.gL(str);
            AppMethodBeat.o(136898);
        }

        public final void hd(String str) {
            AppMethodBeat.i(136899);
            b.i("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", str, Integer.valueOf(this.dxa.hq(str)));
            d dVar = this.dxa;
            dVar.dxo.gR(str);
            if (dVar.dxb.gN(str) && dVar.dxb.gO(str)) {
                dVar.q(2, str);
            }
            a aVar = this.dxb;
            b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", str);
            com.tencent.mm.audio.mix.d.b bVar = aVar.dvb.get(str);
            if (bVar == null) {
                b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
                AppMethodBeat.o(136899);
            } else if (bVar.dvh) {
                b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
                AppMethodBeat.o(136899);
            } else if (bVar.YT()) {
                b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
                AppMethodBeat.o(136899);
            } else {
                l lVar = bVar.dvi;
                if (lVar != null) {
                    lVar.pause();
                }
                AppMethodBeat.o(136899);
            }
        }

        public final void he(String str) {
            AppMethodBeat.i(136900);
            b.i("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", str, Integer.valueOf(this.dxa.hq(str)));
            this.dxa.he(str);
            this.dxb.gM(str);
            AppMethodBeat.o(136900);
        }

        public final void remove(String str) {
            AppMethodBeat.i(136901);
            b.i("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", str);
            d dVar = this.dxa;
            dVar.dvc.remove(str);
            dVar.dxs.remove(str);
            dVar.dxt.remove(str);
            synchronized (dVar.dxm) {
                try {
                    dVar.dxu.remove(str);
                    dVar.dwo.remove(str);
                } catch (Throwable th) {
                    AppMethodBeat.o(136901);
                    throw th;
                }
            }
            dVar.dxv.remove(str);
            a aVar = this.dxb;
            if (aVar.dvb.containsKey(str) && aVar.dve.contains(str)) {
                aVar.gM(str);
            }
            aVar.dvc.remove(str);
            aVar.dve.remove(str);
            AppMethodBeat.o(136901);
        }

        public final boolean A(String str, int i2) {
            boolean c2;
            AppMethodBeat.i(136902);
            b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", str, Integer.valueOf(i2));
            boolean z = this.dxb.z(str, i2);
            if (!z) {
                b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", Integer.valueOf(i2));
                AppMethodBeat.o(136902);
                return false;
            }
            q(10, str);
            long hp = (long) this.dxa.hp(str);
            int hq = this.dxa.hq(str);
            if (!hm(str)) {
                b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo cache is not exist");
                c2 = true;
            } else if (hj(str) <= 2000) {
                b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
                if (!this.dxb.gN(str)) {
                    z = this.dxb.y(str, i2);
                    c2 = true;
                } else {
                    c2 = true;
                }
            } else if (Math.abs(((long) i2) - hp) <= 3000) {
                b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo time is not support seek");
                c2 = true;
            } else if (hq != 0 && hq != 1 && hq != 2) {
                b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo state is not support seek");
                c2 = true;
            } else if (!this.dxb.gN(str)) {
                this.dxa.dxo.c(str, i2, false);
                z = this.dxb.y(str, i2);
                c2 = true;
            } else {
                c2 = this.dxa.dxo.c(str, i2, true);
            }
            q(6, str);
            if (!c2 || !z) {
                AppMethodBeat.o(136902);
                return false;
            }
            AppMethodBeat.o(136902);
            return true;
        }

        public final boolean gO(String str) {
            AppMethodBeat.i(136903);
            boolean gO = this.dxa.gO(str);
            AppMethodBeat.o(136903);
            return gO;
        }

        public final boolean hf(String str) {
            AppMethodBeat.i(136904);
            d dVar = this.dxa;
            if (dVar.dxt.containsKey(str)) {
                boolean booleanValue = dVar.dxt.get(str).booleanValue();
                AppMethodBeat.o(136904);
                return booleanValue;
            }
            AppMethodBeat.o(136904);
            return false;
        }

        public final boolean hg(String str) {
            e<Integer> eVar;
            AppMethodBeat.i(136905);
            d dVar = this.dxa;
            if (dVar.dxu.containsKey(str) && (eVar = dVar.dxu.get(str)) != null) {
                if (eVar.f(9)) {
                    AppMethodBeat.o(136905);
                    return true;
                }
            }
            AppMethodBeat.o(136905);
            return false;
        }

        public final boolean hh(String str) {
            e<Integer> eVar;
            AppMethodBeat.i(136906);
            d dVar = this.dxa;
            if (dVar.dxu.containsKey(str) && (eVar = dVar.dxu.get(str)) != null) {
                if (eVar.f(7)) {
                    AppMethodBeat.o(136906);
                    return true;
                }
            }
            AppMethodBeat.o(136906);
            return false;
        }

        public final boolean isPaused(String str) {
            e<Integer> eVar;
            AppMethodBeat.i(136907);
            d dVar = this.dxa;
            if (dVar.dxu.containsKey(str) && (eVar = dVar.dxu.get(str)) != null) {
                if (eVar.f(2)) {
                    AppMethodBeat.o(136907);
                    return true;
                }
            }
            AppMethodBeat.o(136907);
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0047, code lost:
            if (r0.f(5) != false) goto L_0x0049;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean hi(java.lang.String r7) {
            /*
                r6 = this;
                r5 = 136908(0x216cc, float:1.91849E-40)
                r1 = 1
                r2 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                com.tencent.mm.audio.mix.g.d r0 = r6.dxa
                java.util.HashMap<java.lang.String, com.tencent.mm.audio.mix.g.e<java.lang.Integer>> r3 = r0.dxu
                boolean r3 = r3.containsKey(r7)
                if (r3 == 0) goto L_0x004e
                java.util.HashMap<java.lang.String, com.tencent.mm.audio.mix.g.e<java.lang.Integer>> r0 = r0.dxu
                java.lang.Object r0 = r0.get(r7)
                com.tencent.mm.audio.mix.g.e r0 = (com.tencent.mm.audio.mix.g.e) r0
                if (r0 == 0) goto L_0x004e
                java.lang.Integer[] r3 = new java.lang.Integer[r1]
                r4 = 3
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                r3[r2] = r4
                boolean r3 = r0.f(r3)
                if (r3 != 0) goto L_0x0049
                java.lang.Integer[] r3 = new java.lang.Integer[r1]
                r4 = 4
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                r3[r2] = r4
                boolean r3 = r0.f(r3)
                if (r3 != 0) goto L_0x0049
                java.lang.Integer[] r3 = new java.lang.Integer[r1]
                r4 = 5
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                r3[r2] = r4
                boolean r0 = r0.f(r3)
                if (r0 == 0) goto L_0x004e
            L_0x0049:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                r0 = r1
            L_0x004d:
                return r0
            L_0x004e:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                r0 = r2
                goto L_0x004d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.mix.g.c.hi(java.lang.String):boolean");
        }

        public final boolean ZI() {
            AppMethodBeat.i(136909);
            boolean z = this.dxa.dxj.get();
            AppMethodBeat.o(136909);
            return z;
        }

        public final int hj(String str) {
            AppMethodBeat.i(136910);
            int hj = this.dxa.hj(str);
            AppMethodBeat.o(136910);
            return hj;
        }

        public final void a(b bVar) {
            this.dxa.dxp = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00b0  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00b5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.ai.d hk(java.lang.String r15) {
            /*
            // Method dump skipped, instructions count: 183
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.mix.g.c.hk(java.lang.String):com.tencent.mm.ai.d");
        }

        public final void q(int i2, String str) {
            AppMethodBeat.i(136912);
            this.dxa.q(i2, str);
            AppMethodBeat.o(136912);
        }

        public final void a(g gVar) {
            this.dxa.dxr = gVar;
        }

        public final void ZJ() {
            AppMethodBeat.i(136913);
            String str = this.appId;
            b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", str);
            d.a(new com.tencent.mm.audio.mix.b.a.c(str), "AudioPcmDataTrackRecycleCacheTask");
            this.dxc.clear();
            AppMethodBeat.o(136913);
        }

        public final void hl(String str) {
            AppMethodBeat.i(136914);
            String str2 = this.appId;
            b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", str2, str);
            d.a(new com.tencent.mm.audio.mix.b.a.a(str2, str), "AudioPcmDataTrackCacheToFileTask");
            AppMethodBeat.o(136914);
        }

        public final boolean hm(String str) {
            AppMethodBeat.i(136915);
            com.tencent.mm.ai.b ha = ha(str);
            if (ha == null) {
                AppMethodBeat.o(136915);
                return false;
            } else if (this.dxc.containsKey(ha.filePath)) {
                boolean booleanValue = this.dxc.get(ha.filePath).booleanValue();
                AppMethodBeat.o(136915);
                return booleanValue;
            } else {
                boolean gG = com.tencent.mm.audio.mix.b.f.YL().gG(ha.filePath);
                if (gG) {
                    this.dxc.put(ha.filePath, Boolean.valueOf(gG));
                }
                AppMethodBeat.o(136915);
                return gG;
            }
        }

        public final boolean hn(String str) {
            AppMethodBeat.i(136916);
            if (this.dxc.containsKey(str)) {
                boolean booleanValue = this.dxc.get(str).booleanValue();
                AppMethodBeat.o(136916);
                return booleanValue;
            }
            boolean gG = com.tencent.mm.audio.mix.b.f.YL().gG(str);
            if (gG) {
                this.dxc.put(str, Boolean.valueOf(gG));
            }
            AppMethodBeat.o(136916);
            return gG;
        }

        public final boolean ho(String str) {
            AppMethodBeat.i(198128);
            boolean gK = this.dxb.gK(str);
            AppMethodBeat.o(198128);
            return gK;
        }

        public final long ZK() {
            return this.dxa.dxo.dwr;
        }
    }
