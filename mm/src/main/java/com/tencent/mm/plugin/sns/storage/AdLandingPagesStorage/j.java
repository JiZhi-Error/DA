package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class j {
    private static j Ely = new j();
    ConcurrentLinkedQueue<String> Elx = new ConcurrentLinkedQueue<>();

    static {
        AppMethodBeat.i(97391);
        AppMethodBeat.o(97391);
    }

    public static j fez() {
        return Ely;
    }

    private j() {
        AppMethodBeat.i(97385);
        AppMethodBeat.o(97385);
    }

    private boolean aQh(String str) {
        AppMethodBeat.i(97386);
        boolean contains = this.Elx.contains(str);
        AppMethodBeat.o(97386);
        return contains;
    }

    private void a(String str, z zVar) {
        AppMethodBeat.i(97387);
        if (i.Zi(zVar.type)) {
            ArrayList<z> arrayList = new ArrayList();
            if (i.Zj(zVar.type)) {
                arrayList.addAll(((ak) zVar).eXg());
            } else if (i.Zm(zVar.type)) {
                arrayList.addAll(((x) zVar).aQz);
            } else if (i.Zk(zVar.type)) {
                arrayList.addAll(((aa) zVar).eXg());
            } else if (i.Zl(zVar.type)) {
                arrayList.addAll(((y) zVar).eXg());
            } else if (i.Zn(zVar.type)) {
                arrayList.addAll(((b) zVar).eXg());
            }
            for (z zVar2 : arrayList) {
                a(str, zVar2);
            }
            if (i.Zn(zVar.type)) {
                b bVar = (b) zVar;
                final int i2 = bVar.DZj;
                final String str2 = bVar.DtQ;
                if (TextUtils.isEmpty(str2)) {
                    Log.w("AdLandingPagesPreDownloadResHelper", "predownload imgUrl==null, compType=".concat(String.valueOf(i2)));
                    AppMethodBeat.o(97387);
                    return;
                } else if (aQh(str2)) {
                    Log.w("AdLandingPagesPreDownloadResHelper", "predownload img busy, compType=" + i2 + ", url=" + str2);
                    AppMethodBeat.o(97387);
                    return;
                } else {
                    this.Elx.add(str2);
                    h.a(str, str2, true, i2, new f.a() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass5 */

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void eWN() {
                        }

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void eWO() {
                            AppMethodBeat.i(203168);
                            Log.e("AdLandingPagesPreDownloadResHelper", "predownload img err, compType=" + i2 + ", url=" + str2);
                            j.a(j.this, str2);
                            AppMethodBeat.o(203168);
                        }

                        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                        public final void aNH(String str) {
                            AppMethodBeat.i(203169);
                            Log.d("AdLandingPagesPreDownloadResHelper", "predownload img succ, compType=" + i2 + ", url=" + str2);
                            j.a(j.this, str2);
                            AppMethodBeat.o(203169);
                        }
                    });
                }
            }
            AppMethodBeat.o(97387);
        } else if (zVar.DZj == 41) {
            final t tVar = (t) zVar;
            if (aQh(tVar.DYK)) {
                AppMethodBeat.o(97387);
                return;
            }
            this.Elx.add(tVar.DYK);
            h.a(str, tVar.DYK, true, zVar.DZj, new f.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                    AppMethodBeat.i(97360);
                    Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + tVar.DYK + "is error");
                    j.a(j.this, tVar.DYK);
                    AppMethodBeat.o(97360);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(97361);
                    j.a(j.this, tVar.DYK);
                    AppMethodBeat.o(97361);
                }
            });
            AppMethodBeat.o(97387);
        } else if (zVar.DZj == 44) {
            final s sVar = (s) zVar;
            if (aQh(sVar.DYK)) {
                AppMethodBeat.o(97387);
                return;
            }
            this.Elx.add(sVar.DYK);
            h.a(str, sVar.DYK, true, zVar.DZj, new f.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass10 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                    AppMethodBeat.i(97367);
                    Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + sVar.DYK + "is error");
                    j.a(j.this, sVar.DYK);
                    AppMethodBeat.o(97367);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(97368);
                    j.a(j.this, sVar.DYK);
                    AppMethodBeat.o(97368);
                }
            });
            AppMethodBeat.o(97387);
        } else if (zVar.DZj == 45) {
            final t tVar2 = (t) zVar;
            if (aQh(tVar2.DYK)) {
                AppMethodBeat.o(97387);
                return;
            }
            this.Elx.add(tVar2.DYK);
            h.a(str, tVar2.DYK, true, zVar.DZj, new f.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass11 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                    AppMethodBeat.i(97369);
                    Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + tVar2.DYK + "is error");
                    j.a(j.this, tVar2.DYK);
                    AppMethodBeat.o(97369);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(String str) {
                    AppMethodBeat.i(97370);
                    j.a(j.this, tVar2.DYK);
                    AppMethodBeat.o(97370);
                }
            });
            AppMethodBeat.o(97387);
        } else if (zVar.DZj == 61) {
            final v vVar = (v) zVar;
            if (!aQh(vVar.DYQ)) {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                d.baW();
                if (d.a(pInt, pInt2)) {
                    this.Elx.add(vVar.DYQ);
                    if (!vVar.DYZ) {
                        h.b(str, vVar.DYQ, true, 61, new f.a() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass12 */

                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                            public final void eWN() {
                            }

                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                            public final void eWO() {
                                AppMethodBeat.i(97371);
                                Log.e("AdLandingPagesPreDownloadResHelper", "pre download sight by http error:" + vVar.DYQ);
                                j.a(j.this, vVar.DYQ);
                                AppMethodBeat.o(97371);
                            }

                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                            public final void aNH(String str) {
                                AppMethodBeat.i(97372);
                                j.a(j.this, vVar.DYQ);
                                AppMethodBeat.o(97372);
                            }
                        });
                    } else {
                        h.b(str, vVar.DYQ, new f.a() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass13 */

                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                            public final void eWN() {
                            }

                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                            public final void eWO() {
                                AppMethodBeat.i(97373);
                                Log.e("AdLandingPagesPreDownloadResHelper", "pre download sight by cdn error:" + vVar.DYQ);
                                j.a(j.this, vVar.DYQ);
                                AppMethodBeat.o(97373);
                            }

                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                            public final void aNH(String str) {
                                AppMethodBeat.i(97374);
                                j.a(j.this, vVar.DYQ);
                                AppMethodBeat.o(97374);
                            }
                        });
                    }
                }
            }
            if (!aQh(vVar.DYR)) {
                this.Elx.add(vVar.DYR);
                h.a(str, vVar.DYR, true, 1000000001, new f.a() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass14 */

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void eWN() {
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void eWO() {
                        AppMethodBeat.i(203174);
                        Log.e("AdLandingPagesPreDownloadResHelper", "pre download sight thumb error:" + vVar.DYR);
                        j.a(j.this, vVar.DYR);
                        AppMethodBeat.o(203174);
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void aNH(String str) {
                        AppMethodBeat.i(203175);
                        j.a(j.this, vVar.DYR);
                        AppMethodBeat.o(203175);
                    }
                });
            }
            AppMethodBeat.o(97387);
        } else if (zVar.DZj == 62) {
            boolean z = h.aqJ().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0;
            Log.i("AdLandingPagesPreDownloadResHelper", "pre down video value: ".concat(String.valueOf(z)));
            final am amVar = (am) zVar;
            if (z && !aQh(amVar.DYS)) {
                this.Elx.add(amVar.DYS);
                String str3 = amVar.DYS;
                int i3 = zVar.DZj;
                AnonymousClass15 r5 = new c.a() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass15 */

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c.a
                    public final void dx(String str, int i2) {
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c.a
                    public final void aas(String str) {
                        AppMethodBeat.i(203176);
                        Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + amVar.DYS + "is error");
                        j.a(j.this, amVar.DYS);
                        AppMethodBeat.o(203176);
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c.a
                    public final void Hn(String str) {
                        AppMethodBeat.i(203177);
                        j.a(j.this, amVar.DYS);
                        AppMethodBeat.o(203177);
                    }
                };
                if (Util.isNullOrNil(str3) || Util.isNullOrNil(str)) {
                    r5.aas("the res or adId is null");
                } else {
                    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download video for " + str3 + " for adid:" + str);
                    String few = h.few();
                    String str4 = str + "_stream_" + MD5Util.getMD5String(str3);
                    String str5 = few + str4;
                    if (Util.isNullOrNil(str5)) {
                        MMHandlerThread.postToMainThread(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x02d9: INVOKE  
                              (wrap: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$6 : 0x02d6: CONSTRUCTOR  (r1v23 com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$6) = (r5v4 'r5' com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j$15) call: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.6.<init>(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c$a):void type: CONSTRUCTOR)
                             type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.a(java.lang.String, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z):void, file: classes3.dex
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
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x02d6: CONSTRUCTOR  (r1v23 com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e$6) = (r5v4 'r5' com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j$15) call: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.6.<init>(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c$a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.a(java.lang.String, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z):void, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 44 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 50 more
                            */
                        /*
                        // Method dump skipped, instructions count: 926
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.a(java.lang.String, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z):void");
                    }

                    private void aQi(final String str) {
                        AppMethodBeat.i(97388);
                        if (TextUtils.isEmpty(str)) {
                            AppMethodBeat.o(97388);
                        } else if (aQh(str)) {
                            AppMethodBeat.o(97388);
                        } else {
                            this.Elx.add(str);
                            h.a("adId", str, true, 0, new f.a() {
                                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass4 */

                                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                public final void eWN() {
                                }

                                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                public final void eWO() {
                                    AppMethodBeat.i(203166);
                                    Log.e("AdLandingPagesPreDownloadResHelper", " pre download " + str + "is error");
                                    j.a(j.this, str);
                                    AppMethodBeat.o(203166);
                                }

                                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                public final void aNH(String str) {
                                    AppMethodBeat.i(203167);
                                    j.a(j.this, str);
                                    AppMethodBeat.o(203167);
                                }
                            });
                            AppMethodBeat.o(97388);
                        }
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c5 A[Catch:{ Throwable -> 0x00f8 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:48:0x0089 A[SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void h(java.lang.String r13, java.lang.String r14, java.lang.String r15, int r16) {
                        /*
                        // Method dump skipped, instructions count: 416
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.h(java.lang.String, java.lang.String, java.lang.String, int):void");
                    }

                    public static void d(LinkedList<ds> linkedList, boolean z) {
                        AppMethodBeat.i(203178);
                        if (linkedList == null) {
                            AppMethodBeat.o(203178);
                            return;
                        }
                        for (int i2 = 0; i2 < linkedList.size(); i2++) {
                            a(linkedList.get(i2), z);
                        }
                        AppMethodBeat.o(203178);
                    }

                    public static void a(final ds dsVar, final boolean z) {
                        AppMethodBeat.i(203179);
                        final String a2 = com.tencent.mm.platformtools.z.a(dsVar.KHG.MYI);
                        if (!Util.isNullOrNil(a2)) {
                            ThreadPool.post(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass6 */

                                public final void run() {
                                    AppMethodBeat.i(203170);
                                    if (new ADXml(a2).isLandingPagesAd() && i.aQg(a2)) {
                                        int i2 = 0;
                                        if (z) {
                                            i2 = 6;
                                        }
                                        String str = "";
                                        try {
                                            str = r.Jb(dsVar.KHG.MYH.Id);
                                        } catch (Exception e2) {
                                        }
                                        Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPages, scene=" + i2 + ", snsId=" + str);
                                        j.fez().h("adId", a2, com.tencent.mm.g.c.f.COL_ADXML, i2);
                                        String gestureCanvasInfo = ADXml.getGestureCanvasInfo(a2);
                                        if (i.aQg(gestureCanvasInfo)) {
                                            int i3 = 1;
                                            if (z) {
                                                i3 = 7;
                                            }
                                            Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPages for gestureAdXml, scene=" + i3 + ", snsId=" + str);
                                            j.fez().h("adId", gestureCanvasInfo, com.tencent.mm.g.c.f.COL_ADXML, i3);
                                        }
                                    }
                                    AppMethodBeat.o(203170);
                                }
                            }, "predownloadAdLandingPages");
                        }
                        AppMethodBeat.o(203179);
                    }

                    public static void br(LinkedList<SnsObject> linkedList) {
                        SnsInfo JJ;
                        AppMethodBeat.i(203180);
                        if (linkedList == null) {
                            AppMethodBeat.o(203180);
                            return;
                        }
                        n faO = aj.faO();
                        for (int i2 = 0; i2 < linkedList.size(); i2++) {
                            SnsObject snsObject = linkedList.get(i2);
                            if (!(snsObject == null || (JJ = faO.JJ(snsObject.Id)) == null)) {
                                TimeLineObject timeLine = JJ.getTimeLine();
                                final String str = timeLine == null ? "" : timeLine.canvasInfo;
                                if (!Util.isNullOrNil(str)) {
                                    final String snsId = JJ.getSnsId();
                                    ThreadPool.post(new Runnable() {
                                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass7 */

                                        public final void run() {
                                            AppMethodBeat.i(203171);
                                            if (i.aQg(str)) {
                                                Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForSnsObject, snsId=" + snsId);
                                                j.fez().h("adId", str, com.tencent.mm.g.c.f.COL_ADXML, 4);
                                                AppMethodBeat.o(203171);
                                                return;
                                            }
                                            Log.w("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForSnsObject, invalid canvas, snsId=" + snsId);
                                            AppMethodBeat.o(203171);
                                        }
                                    }, "preDownloadAdLandingPagesForSnsObject");
                                }
                            }
                        }
                        AppMethodBeat.o(203180);
                    }

                    public static void aQj(final String str) {
                        AppMethodBeat.i(203181);
                        if (Util.isNullOrNil(str)) {
                            AppMethodBeat.o(203181);
                            return;
                        }
                        ThreadPool.post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass8 */

                            public final void run() {
                                AppMethodBeat.i(203172);
                                if (i.aQg(str)) {
                                    Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForMsg");
                                    j.fez().h("adId", str, com.tencent.mm.g.c.f.COL_ADXML, 5);
                                    AppMethodBeat.o(203172);
                                    return;
                                }
                                Log.w("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForMsg, invalid canvas");
                                AppMethodBeat.o(203172);
                            }
                        }, "preDownloadAdLandingPagesForMsg");
                        AppMethodBeat.o(203181);
                    }

                    public static void aQk(final String str) {
                        AppMethodBeat.i(203182);
                        if (Util.isNullOrNil(str)) {
                            AppMethodBeat.o(203182);
                            return;
                        }
                        ThreadPool.post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.AnonymousClass9 */

                            public final void run() {
                                AppMethodBeat.i(203173);
                                if (i.aQg(str)) {
                                    Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForAtMsg");
                                    j.fez().h("adId", str, com.tencent.mm.g.c.f.COL_ADXML, 2);
                                    String gestureCanvasInfo = ADXml.getGestureCanvasInfo(str);
                                    if (i.aQg(gestureCanvasInfo)) {
                                        Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForAtMsg for gestureAdXml");
                                        j.fez().h("adId", gestureCanvasInfo, com.tencent.mm.g.c.f.COL_ADXML, 3);
                                    }
                                    AppMethodBeat.o(203173);
                                    return;
                                }
                                Log.w("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForAtMsg, inValidCanvas");
                                AppMethodBeat.o(203173);
                            }
                        }, "preDownloadAdLandingPagesForAtMsg");
                        AppMethodBeat.o(203182);
                    }

                    static /* synthetic */ void a(j jVar, String str) {
                        AppMethodBeat.i(97390);
                        jVar.Elx.remove(str);
                        AppMethodBeat.o(97390);
                    }
                }
