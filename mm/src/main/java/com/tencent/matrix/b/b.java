package com.tencent.matrix.b;

import android.content.ComponentName;
import android.support.v4.e.k;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.a.b.a;
import com.tencent.matrix.a.b.a.b;
import com.tencent.matrix.a.b.a.c;
import com.tencent.matrix.a.b.a.d;
import com.tencent.matrix.a.b.a.e;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.b.a.h;
import com.tencent.matrix.a.b.a.i;
import com.tencent.matrix.c.a;
import com.tencent.matrix.c.c;
import com.tencent.matrix.report.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class b extends a.C0204a {
    a.C0219a cUJ;
    h.a cUK;
    private c cUL;
    private d cUM;
    boolean cUN = false;

    @Override // com.tencent.matrix.a.b.a.C0204a, com.tencent.matrix.a.b.c.AbstractC0217c
    public final void Sa() {
        super.Sa();
        Log.i("Matrix.battery.listener", "#onTraceBegin");
        this.cUJ = a.C0219a.SI();
        if (((h) this.cRw.aa(h.class)) != null) {
            this.cUK = h.aZ(com.tencent.matrix.a.b.c.getContext());
        }
    }

    @Override // com.tencent.matrix.a.b.a.C0204a, com.tencent.matrix.a.b.c.AbstractC0217c
    public final void cz(boolean z) {
        super.cz(z);
        this.cUN = z;
        Log.i("Matrix.battery.listener", "#onTraceEnd, fg = ".concat(String.valueOf(z)));
        this.cUL = (c) this.cRw.aa(c.class);
        this.cUM = (d) this.cRw.aa(d.class);
    }

    @Override // com.tencent.matrix.a.b.a.C0204a, com.tencent.matrix.a.b.a.i.b
    @Deprecated
    public final void a(int i2, i.d.b bVar) {
        Log.i("Matrix.battery.listener", "#onWakeLockTimeout tag=%s packageName=%s warningCount=%s", bVar.tag, bVar.packageName, Integer.valueOf(i2));
        if (i2 <= 1) {
            e.INSTANCE.idkeyStat(1013, 201, 1, false);
        }
        if (((long) i2) == com.tencent.matrix.c.a.SG() && !TextUtils.isEmpty(bVar.stack)) {
            long Sp = bVar.Sp();
            if (this.cUL != null) {
                c.b bb = this.cUL.bb(Sp);
                if (bb.cTq) {
                    long longValue = ((Long) bb.cSO.cTz).longValue();
                    k<String, Integer> Ss = this.cUL.bc(Sp).Ss();
                    if (Ss != null) {
                        F f2 = Ss.first;
                        long intValue = Ss.second == null ? 0 : (long) Ss.second.intValue();
                        if (this.cUM != null) {
                            d.C0208d bd = this.cUM.bd(Sp);
                            if (bd.cTq) {
                                long longValue2 = ((Long) bd.cTb.cTz).longValue();
                                Log.w("Matrix.battery.listener", "#onWakeLockTimeout report as exception!");
                                int SP = com.tencent.matrix.report.a.SP();
                                int SQ = com.tencent.matrix.report.a.SQ();
                                Log.i("Matrix.battery.BatteryReporter", "#reportWakeLocksOvertime, count = ".concat(String.valueOf(i2)));
                                a.b.a(1, com.tencent.matrix.report.a.SN(), bVar.packageName + "-" + bVar.tag, SP, SQ, "wakeWarningException", (long) i2, "lockMils", bVar.Sp(), "flag", (long) bVar.flags, f2, bVar.stack, longValue, longValue2, intValue);
                            }
                        }
                    }
                }
            }
        }
        if (i2 <= 300 && bVar.Sp() <= 36000000 && com.tencent.matrix.c.a.SA()) {
            int SP2 = com.tencent.matrix.report.a.SP();
            int SQ2 = com.tencent.matrix.report.a.SQ();
            String SO = com.tencent.matrix.report.a.SO();
            Log.i("Matrix.battery.BatteryReporter", "#statWakeLocks, count = ".concat(String.valueOf(i2)));
            a.b.a(0, com.tencent.matrix.report.a.SN(), bVar.packageName + "-" + bVar.tag, SP2, SQ2, "wakeWarning", (long) i2, "lockMils", bVar.Sp(), "flag", (long) bVar.flags, SO, bVar.stack, 0, 0, 0);
        }
    }

    @Override // com.tencent.matrix.a.b.a.C0204a, com.tencent.matrix.a.b.a.i.b
    public final void a(i.d.b bVar, long j2) {
        Log.i("Matrix.battery.listener", "#onBgWakeLockTimeout tag=%s packageName=%s millis=%s", bVar.tag, bVar.packageName, Long.valueOf(j2));
        e.INSTANCE.idkeyStat(1540, 50, 1, false);
        if (!TextUtils.isEmpty(bVar.stack)) {
            long Sp = bVar.Sp();
            if (this.cUL != null) {
                c.b bb = this.cUL.bb(Sp);
                if (bb.cTq) {
                    long longValue = ((Long) bb.cSO.cTz).longValue();
                    k<String, Integer> Ss = this.cUL.bc(Sp).Ss();
                    if (Ss != null) {
                        F f2 = Ss.first;
                        long intValue = Ss.second == null ? 0 : (long) Ss.second.intValue();
                        if (this.cUM != null) {
                            d.C0208d bd = this.cUM.bd(Sp);
                            if (bd.cTq) {
                                long longValue2 = ((Long) bd.cTb.cTz).longValue();
                                Log.w("Matrix.battery.listener", "#onBgWakeLockTimeout report as exception!");
                                int SP = com.tencent.matrix.report.a.SP();
                                int SQ = com.tencent.matrix.report.a.SQ();
                                Log.i("Matrix.battery.BatteryReporter", "#reportWakeLocksOvertimeBg, mills = ".concat(String.valueOf(j2)));
                                a.b.a(1, com.tencent.matrix.report.a.SN(), bVar.packageName + "-" + bVar.tag, SP, SQ, "wakeBgException", j2, "lockMils", bVar.Sp(), "flag", (long) bVar.flags, f2, bVar.stack, longValue, longValue2, intValue);
                            }
                        }
                    }
                }
            }
        }
        if (bVar.Sp() <= 36000000 && com.tencent.matrix.c.a.SA()) {
            int SP2 = com.tencent.matrix.report.a.SP();
            int SQ2 = com.tencent.matrix.report.a.SQ();
            String SO = com.tencent.matrix.report.a.SO();
            Log.i("Matrix.battery.BatteryReporter", "#statBgWakeLocks, millis = ".concat(String.valueOf(j2)));
            a.b.a(0, com.tencent.matrix.report.a.SN(), bVar.packageName + "-" + bVar.tag, SP2, SQ2, "wakeBgWarning", j2, "lockMils", bVar.Sp(), "flag", (long) bVar.flags, SO, bVar.stack, 0, 0, 0);
        }
    }

    @Override // com.tencent.matrix.a.b.a.c.a, com.tencent.matrix.a.b.a.C0204a
    public final void a(boolean z, int i2, int i3, ComponentName componentName, long j2) {
        String str;
        if (z || MMApplicationContext.isMainProcess()) {
            Log.i("Matrix.battery.listener", "statForegroundServiceLeak");
            if (com.tencent.matrix.c.a.SA()) {
                String SN = com.tencent.matrix.report.a.SN();
                String className = componentName == null ? BuildConfig.COMMAND : componentName.getClassName();
                int SP = com.tencent.matrix.report.a.SP();
                int SQ = com.tencent.matrix.report.a.SQ();
                String SO = com.tencent.matrix.report.a.SO();
                Log.i("Matrix.battery.BatteryReporter", "#statForegroundServiceLeak, isMyself = ".concat(String.valueOf(z)));
                if (z) {
                    str = "statMyImportance";
                } else {
                    str = "statOtherImportance";
                }
                a.b.a(0, SN, className, SP, SQ, str, (long) i2, "gblIpt", (long) i3, "duringMin", j2, SO, "", 0, 0, 0);
            }
        }
    }

    @Override // com.tencent.matrix.a.b.a.C0204a
    public final void Sb() {
        super.Sb();
        com.tencent.matrix.c.c cVar = (com.tencent.matrix.c.c) this.cRw.aa(com.tencent.matrix.c.c.class);
        if (cVar != null) {
            final List<g.a.AbstractC0209a<c.b>> SJ = cVar.SJ();
            if (!SJ.isEmpty()) {
                a("thread_pool(" + SJ.size() + ")", new android.support.v4.e.c<a.C0204a.C0205a>() {
                    /* class com.tencent.matrix.b.b.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.support.v4.e.c
                    public final /* synthetic */ void accept(a.C0204a.C0205a aVar) {
                        String str;
                        String str2;
                        a.C0204a.C0205a aVar2 = aVar;
                        int i2 = 0;
                        boolean z = false;
                        boolean z2 = false;
                        while (i2 < SJ.size()) {
                            g.a.AbstractC0209a aVar3 = (g.a.AbstractC0209a) SJ.get(i2);
                            if (i2 <= 8) {
                                long longValue = ((Long) ((c.b) aVar3.cTt).cVo.cTz).longValue() / Math.max(1L, aVar3.cTu / Util.MILLSECONDS_OF_MINUTE);
                                if (longValue > 0) {
                                    aVar2.aO("|   -> (").aO(((c.b) aVar3.cTt).isFinished ? "-" : "~").aO(",").aO(Integer.valueOf(((c.b) aVar3.cTt).cVp)).aO("-").aO(Integer.valueOf(((c.b) aVar3.cTt).cVq)).aO(")").aO(((c.b) aVar3.cTt).name).aO("(").aO(Integer.valueOf(((c.b) aVar3.cTt).tid)).aO(")\t").aO(Long.valueOf(longValue)).aO(FilePathGenerator.ANDROID_DIR_SEP).aO(((c.b) aVar3.cTt).cVo.cTz).aO("\tjiffies").aO("\n");
                                    if (longValue > com.tencent.matrix.c.a.SE() && !z2) {
                                        z2 = true;
                                    }
                                    if (!aVar3.isValid()) {
                                        z = true;
                                    }
                                }
                                b.e(aVar3);
                            }
                            i2++;
                            z = z;
                        }
                        aVar2.aO("|\t\t......\n");
                        if (z2 || z) {
                            a.C0204a.C0205a aO = aVar2.aO("|  ");
                            if (z2) {
                                str = " #overHeat";
                            } else {
                                str = "";
                            }
                            a.C0204a.C0205a aO2 = aO.aO(str);
                            if (z) {
                                str2 = " #invalid";
                            } else {
                                str2 = "";
                            }
                            aO2.aO(str2).aO("\n");
                        }
                    }
                });
                cVar.SK();
            }
        }
        if (this.cUJ != null) {
            a("extra_info", new android.support.v4.e.c<a.C0204a.C0205a>() {
                /* class com.tencent.matrix.b.b.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.support.v4.e.c
                public final /* synthetic */ void accept(a.C0204a.C0205a aVar) {
                    h.a aZ;
                    a.C0204a.C0205a aVar2 = aVar;
                    a.C0219a SI = a.C0219a.SI();
                    a.C0219a.AnonymousClass1 r12 = new g.a.AbstractC0209a<a.C0219a>(b.this.cUJ, SI) {
                        /* class com.tencent.matrix.c.a.C0219a.AnonymousClass1 */

                        /* Return type fixed from 'com.tencent.matrix.a.b.a.g$a' to match base method */
                        @Override // com.tencent.matrix.a.b.a.g.a.AbstractC0209a
                        public final /* synthetic */ C0219a Si() {
                            C0219a aVar = new C0219a();
                            aVar.cVb = g.a.b.C0211b.a(((C0219a) this.cTs).cVb, ((C0219a) this.cTr).cVb);
                            aVar.cVc = g.a.b.C0211b.a(((C0219a) this.cTs).cVc, ((C0219a) this.cTr).cVc);
                            return aVar;
                        }
                    };
                    e.INSTANCE.idkeyStat(1013, 200, (long) ((Integer) ((a.C0219a) r12.cTt).cVc.cTz).intValue(), false);
                    aVar2.en("during");
                    long max = Math.max(1L, r12.cTu / Util.MILLSECONDS_OF_MINUTE);
                    aVar2.em(r12.cTu + "(mls)\t" + max + "(min)");
                    long intValue = ((long) ((Integer) ((a.C0219a) r12.cTt).cVc.cTz).intValue()) / max;
                    aVar2.J("avgAlarmCount", String.valueOf(intValue));
                    aVar2.J("avgAddMsgCount", String.valueOf(((Long) ((a.C0219a) r12.cTt).cVb.cTz).longValue() / max));
                    if (r12.cTu >= com.tencent.matrix.c.a.SD()) {
                        boolean z = b.this.cUN;
                        int intValue2 = ((Integer) SI.cVc.cTz).intValue();
                        if (com.tencent.matrix.c.a.SA()) {
                            String SN = com.tencent.matrix.report.a.SN();
                            int cA = com.tencent.matrix.report.a.cA(z);
                            int SQ = com.tencent.matrix.report.a.SQ();
                            String SO = com.tencent.matrix.report.a.SO();
                            Log.i("Matrix.battery.BatteryReporter", "#statAlarm, count = ".concat(String.valueOf(intValue)));
                            a.b.a(0, SN, "", cA, SQ, "avgAlarm", intValue, "ttlAlarm", (long) intValue2, "duringMin", max, SO, "", 0, 0, 0);
                        }
                    }
                    if (((h) b.this.cRw.aa(h.class)) != null && b.this.cUK != null && (aZ = h.aZ(com.tencent.matrix.a.b.c.getContext())) != null) {
                        aVar2.en("traffic");
                        h.a.AnonymousClass1 r4 = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0129: CONSTRUCTOR  (r4v7 'r4' com.tencent.matrix.a.b.a.h$a$1) = 
                              (r2v40 'aZ' com.tencent.matrix.a.b.a.h$a)
                              (wrap: com.tencent.matrix.a.b.a.h$a : 0x0125: IGET  (r3v6 com.tencent.matrix.a.b.a.h$a) = 
                              (wrap: com.tencent.matrix.b.b : 0x0123: IGET  (r3v5 com.tencent.matrix.b.b) = (r24v0 'this' com.tencent.matrix.b.b$2 A[IMMUTABLE_TYPE, THIS]) com.tencent.matrix.b.b.2.cUP com.tencent.matrix.b.b)
                             com.tencent.matrix.b.b.cUK com.tencent.matrix.a.b.a.h$a)
                              (r2v40 'aZ' com.tencent.matrix.a.b.a.h$a)
                             call: com.tencent.matrix.a.b.a.h.a.1.<init>(com.tencent.matrix.a.b.a.h$a, com.tencent.matrix.a.b.a.h$a, com.tencent.matrix.a.b.a.h$a):void type: CONSTRUCTOR in method: com.tencent.matrix.b.b.2.accept(com.tencent.matrix.a.b.a$a$a):void, file: classes4.dex
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.matrix.a.b.a.h, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 21 more
                            */
                        /*
                        // Method dump skipped, instructions count: 495
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.b.b.AnonymousClass2.accept(java.lang.Object):void");
                    }
                });
            }
        }

        @Override // com.tencent.matrix.a.b.a.C0204a
        public final void a(g.a.AbstractC0209a<e.b> aVar) {
            long intValue;
            int i2;
            int i3 = 20;
            if (!this.cUN) {
                long longValue = ((Long) ((e.b) aVar.cTt).cTd.cTz).longValue();
                ArrayList<IDKey> arrayList = new ArrayList<>(4);
                IDKey iDKey = new IDKey();
                iDKey.SetID(1013);
                int i4 = -1;
                int i5 = -1;
                if (MMApplicationContext.isMainProcess()) {
                    i5 = 0;
                } else if (MMApplicationContext.isToolsProcess()) {
                    i5 = 20;
                } else if (MMApplicationContext.isPushProcess()) {
                    i5 = 40;
                } else if (MMApplicationContext.isExdeviceProcess()) {
                    i5 = 60;
                } else if (MMApplicationContext.isSandBoxProcess()) {
                    i5 = 80;
                } else if (MMApplicationContext.isAppBrandProcess()) {
                    i5 = 100;
                } else if (MMApplicationContext.isToolsMpProcess()) {
                    i5 = 120;
                }
                if (i5 >= 0) {
                    if (longValue > 2000) {
                        i4 = i5 + 0;
                    } else if (longValue > 1500) {
                        i4 = i5 + 1;
                    } else if (longValue > 1000) {
                        i4 = i5 + 2;
                    } else if (longValue > 800) {
                        i4 = i5 + 3;
                    } else if (longValue > 600) {
                        i4 = i5 + 4;
                    } else if (longValue > 300) {
                        i4 = i5 + 5;
                    }
                }
                iDKey.SetKey(i4);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
                IDKey iDKey2 = new IDKey();
                iDKey2.SetValue(longValue);
                iDKey2.SetID(1013);
                if (MMApplicationContext.isMainProcess()) {
                    i2 = 0;
                } else if (MMApplicationContext.isToolsProcess()) {
                    i2 = 20;
                } else if (MMApplicationContext.isPushProcess()) {
                    i2 = 40;
                } else if (MMApplicationContext.isExdeviceProcess()) {
                    i2 = 60;
                } else if (MMApplicationContext.isSandBoxProcess()) {
                    i2 = 80;
                } else if (MMApplicationContext.isAppBrandProcess()) {
                    i2 = 100;
                } else if (MMApplicationContext.isToolsMpProcess()) {
                    i2 = 120;
                } else {
                    i2 = 0;
                }
                iDKey2.SetKey(i2 + 17);
                arrayList.add(iDKey2);
                IDKey iDKey3 = new IDKey();
                iDKey3.SetID(1013);
                if (MMApplicationContext.isMainProcess()) {
                    i3 = 0;
                } else if (!MMApplicationContext.isToolsProcess()) {
                    if (MMApplicationContext.isPushProcess()) {
                        i3 = 40;
                    } else if (MMApplicationContext.isExdeviceProcess()) {
                        i3 = 60;
                    } else if (MMApplicationContext.isSandBoxProcess()) {
                        i3 = 80;
                    } else if (MMApplicationContext.isAppBrandProcess()) {
                        i3 = 100;
                    } else if (MMApplicationContext.isToolsMpProcess()) {
                        i3 = 120;
                    } else {
                        i3 = 0;
                    }
                }
                iDKey3.SetKey(i3 + 18);
                iDKey3.SetValue(1);
                arrayList.add(iDKey3);
                com.tencent.mm.plugin.report.e.INSTANCE.b(arrayList, false);
            }
            if (aVar.cTu >= com.tencent.matrix.c.a.SB() && aVar.isValid()) {
                String SO = com.tencent.matrix.report.a.SO();
                long j2 = 100;
                long j3 = 100;
                if (this.cUL != null) {
                    c.b bb = this.cUL.bb(aVar.cTu);
                    if (bb.cTq) {
                        long longValue2 = ((Long) bb.cSO.cTz).longValue();
                        k<String, Integer> Ss = this.cUL.bc(aVar.cTu).Ss();
                        if (Ss != null) {
                            F f2 = Ss.first;
                            if (Ss.second == null) {
                                intValue = 0;
                            } else {
                                intValue = (long) Ss.second.intValue();
                            }
                            j3 = intValue;
                            j2 = longValue2;
                            SO = f2;
                        } else {
                            j2 = longValue2;
                        }
                    } else {
                        return;
                    }
                }
                long j4 = 100;
                if (this.cUM != null) {
                    d.C0208d bd = this.cUM.bd(aVar.cTu);
                    if (bd.cTq) {
                        j4 = ((Long) bd.cTb.cTz).longValue();
                    } else {
                        return;
                    }
                }
                long longValue3 = ((Long) ((e.b) aVar.cTt).cTd.cTz).longValue() / Math.max(1L, aVar.cTu / Util.MILLSECONDS_OF_MINUTE);
                if (this.cUN || longValue3 < com.tencent.matrix.c.a.SC()) {
                    a.C0226a.cD(false);
                    a.b.C0228b.a(this.cUN, aVar);
                    return;
                }
                Log.w("Matrix.battery.listener", "#onReportJiffies report as exception!");
                a.C0226a.cD(true);
                a.b.C0227a.a(aVar, j2, j4, SO, j3);
            }
        }

        @Override // com.tencent.matrix.a.b.a.C0204a
        public final void b(g.a.AbstractC0209a<i.c> aVar) {
            BEAN bean;
            if (aVar.cTu >= com.tencent.matrix.c.a.SB() && aVar.isValid()) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < 3; i2++) {
                    if (((i.c) aVar.cTt).cTN.list.size() > i2 && (bean = ((g.a.c.C0212a) ((i.c) aVar.cTt).cTN.list.get(i2)).value) != null && !bean.isFinished()) {
                        sb.append(bean.packageName).append("-").append(bean.tag).append(bean.Sp()).append("|");
                    }
                }
                long max = Math.max(1L, aVar.cTu / Util.MILLSECONDS_OF_MINUTE);
                int intValue = ((Integer) ((i.c) aVar.cTt).cTM.cTz).intValue();
                long longValue = ((Long) ((i.c) aVar.cTt).cTL.cTz).longValue();
                boolean z = this.cUN;
                long j2 = (long) intValue;
                String sb2 = sb.toString();
                if (com.tencent.matrix.c.a.SA()) {
                    String SN = com.tencent.matrix.report.a.SN();
                    int cA = com.tencent.matrix.report.a.cA(z);
                    int SQ = com.tencent.matrix.report.a.SQ();
                    String SO = com.tencent.matrix.report.a.SO();
                    Log.i("Matrix.battery.BatteryReporter", "#statWakeLocks, info = ".concat(String.valueOf(sb2)));
                    a.b.a(0, SN, sb2, cA, SQ, "diffWakeLocks", j2, "diffWakeLockTime", longValue, "duringMin", max, SO, "", 0, 0, 0);
                }
            }
        }

        @Override // com.tencent.matrix.a.b.a.C0204a
        public final void c(g.a.AbstractC0209a<b.c> aVar) {
            int i2;
            List list;
            if (aVar.cTu >= com.tencent.matrix.c.a.SB() && aVar.isValid()) {
                long max = Math.max(1L, aVar.cTu / Util.MILLSECONDS_OF_MINUTE);
                int intValue = ((Integer) ((b.c) aVar.cTt).cSz.cTz).intValue();
                int i3 = 0;
                String str = "";
                HashMap hashMap = new HashMap();
                for (ITEM item : ((b.c) aVar.cTt).cSD.list) {
                    BEAN bean = item.value;
                    String str2 = !TextUtils.isEmpty(bean.stack) ? bean.stack : BuildConfig.KINDA_DEFAULT;
                    List list2 = (List) hashMap.get(str2);
                    if (list2 == null) {
                        list2 = new ArrayList();
                        hashMap.put(str2, list2);
                    }
                    list2.add(bean);
                }
                int size = hashMap.keySet().size();
                for (String str3 : hashMap.keySet()) {
                    if (str3.equals(BuildConfig.KINDA_DEFAULT) || (list = (List) hashMap.get(str3)) == null || list.size() <= i3 || str.equals(str3)) {
                        i2 = i3;
                    } else {
                        i2 = list.size();
                        str = str3;
                    }
                    i3 = i2;
                }
                boolean z = this.cUN;
                if (com.tencent.matrix.c.a.SA()) {
                    String SN = com.tencent.matrix.report.a.SN();
                    String concat = "dpl=".concat(String.valueOf(size));
                    int cA = com.tencent.matrix.report.a.cA(z);
                    int SQ = com.tencent.matrix.report.a.SQ();
                    String SO = com.tencent.matrix.report.a.SO();
                    Log.i("Matrix.battery.BatteryReporter", "#statAlarmSnapshot, count = ".concat(String.valueOf(intValue)));
                    a.b.a(0, SN, concat, cA, SQ, "diffAlarm", (long) intValue, "diffTop1Count", (long) i3, "duringMin", max, SO, str, 0, 0, 0);
                }
            }
        }

        @Override // com.tencent.matrix.a.b.a.C0204a
        public final void d(g.a.AbstractC0209a<d.a> aVar) {
            if (aVar.cTu >= com.tencent.matrix.c.a.SB() && aVar.isValid()) {
                long max = Math.max(1L, aVar.cTu / Util.MILLSECONDS_OF_MINUTE);
                int intValue = ((Integer) ((d.a) aVar.cTt).cSS.cTz).intValue();
                int intValue2 = ((Integer) ((d.a) aVar.cTs).cSS.cTz).intValue();
                boolean z = this.cUN;
                if (com.tencent.matrix.c.a.SA()) {
                    String SN = com.tencent.matrix.report.a.SN();
                    int cA = com.tencent.matrix.report.a.cA(z);
                    int SQ = com.tencent.matrix.report.a.SQ();
                    String SO = com.tencent.matrix.report.a.SO();
                    Log.i("Matrix.battery.BatteryReporter", "#statTemperature, curr = ".concat(String.valueOf(intValue2)));
                    a.b.a(0, SN, "", cA, SQ, "diffBatTemp", (long) intValue, "currBatTemp", (long) intValue2, "duringMin", max, SO, "", 0, 0, 0);
                }
            }
        }

        public static void e(g.a.AbstractC0209a<c.b> aVar) {
            if (aVar.cTu >= com.tencent.matrix.c.a.SD() && aVar.isValid()) {
                boolean z = ((c.b) aVar.cTt).cVp == 1;
                long longValue = ((Long) ((c.b) aVar.cTt).cVo.cTz).longValue() / Math.max(1L, aVar.cTu / Util.MILLSECONDS_OF_MINUTE);
                if (z || longValue < com.tencent.matrix.c.a.SE()) {
                    a.C0226a.cE(false);
                    if (com.tencent.matrix.c.a.SA()) {
                        String SN = com.tencent.matrix.report.a.SN();
                        StringBuilder sb = new StringBuilder();
                        int i2 = ((c.b) aVar.cTt).cVp;
                        int i3 = ((c.b) aVar.cTt).cVq;
                        String SO = com.tencent.matrix.report.a.SO();
                        long max = Math.max(1L, aVar.cTu / Util.MILLSECONDS_OF_MINUTE);
                        long longValue2 = ((Long) ((c.b) aVar.cTt).cVo.cTz).longValue() / max;
                        Log.i("Matrix.battery.BatteryReporter", "#statTaskJiffies");
                        StringBuilder append = sb.append("finish=").append(((c.b) aVar.cTt).isFinished);
                        append.append("|batTemp=").append(com.tencent.matrix.a.c.c.ba(MMApplicationContext.getContext()));
                        int[] Sq = com.tencent.matrix.a.c.c.Sq();
                        if (Sq.length > 0) {
                            append.append("|cupFreq=").append(Arrays.toString(Sq));
                        }
                        a.b.a(0, SN, append.toString(), i2, i3, "avgTaskJiffies", longValue2, ((c.b) aVar.cTt).name, ((Long) ((c.b) aVar.cTs).cVo.cTz).longValue(), "duringMin", max, SO, "", 0, 0, 0);
                        return;
                    }
                    return;
                }
                Log.w("Matrix.battery.listener", "#onReportTaskJiffies report as exception!");
                a.C0226a.cE(true);
                String SN2 = com.tencent.matrix.report.a.SN();
                StringBuilder sb2 = new StringBuilder();
                int i4 = ((c.b) aVar.cTt).cVp;
                int i5 = ((c.b) aVar.cTt).cVq;
                long max2 = Math.max(1L, aVar.cTu / Util.MILLSECONDS_OF_MINUTE);
                long longValue3 = ((Long) ((c.b) aVar.cTt).cVo.cTz).longValue() / max2;
                Log.i("Matrix.battery.BatteryReporter", "#reportTaskJiffies");
                StringBuilder append2 = sb2.append("finish=").append(((c.b) aVar.cTt).isFinished);
                append2.append("|batTemp=").append(com.tencent.matrix.a.c.c.ba(MMApplicationContext.getContext()));
                int[] Sq2 = com.tencent.matrix.a.c.c.Sq();
                if (Sq2.length > 0) {
                    append2.append("|cupFreq=").append(Arrays.toString(Sq2));
                }
                a.b.a(1, SN2, append2.toString(), i4, i5, "avgTaskJiffiesException", longValue3, ((c.b) aVar.cTt).name, ((Long) ((c.b) aVar.cTs).cVo.cTz).longValue(), "duringMin", max2, ((c.b) aVar.cTt).scene, "", ((c.b) aVar.cTt).cVr, ((c.b) aVar.cTt).cVs, ((c.b) aVar.cTt).cVt);
            }
        }

        @Override // com.tencent.matrix.a.b.a.C0204a, com.tencent.matrix.a.b.a.e.a
        public final void ce(int i2, int i3) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1540, 6, 1, false);
            if (com.tencent.matrix.c.a.SA()) {
                String SN = com.tencent.matrix.report.a.SN();
                String eu = com.tencent.matrix.a.c.c.eu(i3 == 0 ? "/proc/" + i2 + "/stat" : "/proc/" + i2 + "/task/" + i3 + "/stat");
                int SP = com.tencent.matrix.report.a.SP();
                int SQ = com.tencent.matrix.report.a.SQ();
                String SO = com.tencent.matrix.report.a.SO();
                Log.i("Matrix.battery.BatteryReporter", "#statJiffiesParseError");
                a.b.a(0, SN, eu, SP, SQ, "statError", 0, "pid", (long) i2, "tid", (long) i3, SO, "", 0, 0, 0);
            }
        }
    }
