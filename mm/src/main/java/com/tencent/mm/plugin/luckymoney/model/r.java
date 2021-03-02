package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.b;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.co.c;
import com.tencent.mm.co.h;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.edn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.wallet_core.c.a;
import java.util.Iterator;

public final class r implements com.tencent.mm.plugin.luckymoney.a.a {
    private static h<com.tencent.mm.av.a.a> yVK = new h<>(new c<com.tencent.mm.av.a.a>() {
        /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ com.tencent.mm.av.a.a get() {
            AppMethodBeat.i(65190);
            b.a aVar = new b.a(MMApplicationContext.getContext());
            aVar.jaZ = com.tencent.mm.av.a.a.a.tv(b.jaO);
            com.tencent.mm.av.a.a aVar2 = new com.tencent.mm.av.a.a(aVar.bdd());
            AppMethodBeat.o(65190);
            return aVar2;
        }
    });

    /* access modifiers changed from: package-private */
    public interface a {
        void b(Bitmap bitmap, int i2, String str);
    }

    static /* synthetic */ void aw(Runnable runnable) {
        AppMethodBeat.i(174329);
        runInMainThread(runnable);
        AppMethodBeat.o(174329);
    }

    static {
        AppMethodBeat.i(65215);
        AppMethodBeat.o(65215);
    }

    @Override // com.tencent.mm.plugin.luckymoney.a.a
    public final void W(boolean z, boolean z2) {
        AppMethodBeat.i(163554);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger laod envelope after receive: %s, %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, (Object) 1);
        if (z) {
            com.tencent.mm.y.c.axV().a(ar.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, true);
        }
        g.azz().a(new aq("v1.0", 1), 0);
        if (!z2) {
            AppMethodBeat.o(163554);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(163547);
                k eeZ = k.eeZ();
                eeZ.b(new d("", 1));
                eeZ.a(new a.AbstractC2168a<bvi>() {
                    /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass9.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
                    @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
                    public final /* synthetic */ void d(bvi bvi, int i2, int i3) {
                        AppMethodBeat.i(258574);
                        bvi bvi2 = bvi;
                        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do get show source net callback");
                        if (bvi2 != null) {
                            Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "retcode: %s", Integer.valueOf(bvi2.dDN));
                            if (bvi2.dDN == 0 && bvi2.Mbs != null) {
                                Iterator<cbe> it = bvi2.Mbs.iterator();
                                while (it.hasNext()) {
                                    cbe next = it.next();
                                    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load resource: %s, %s", next.MgB, next.Lot);
                                    if (next.subType <= 0) {
                                        r.this.a(next);
                                    }
                                }
                            }
                        }
                        AppMethodBeat.o(258574);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
                    public final /* bridge */ /* synthetic */ void dx(bvi bvi) {
                    }
                }, 0);
                AppMethodBeat.o(163547);
            }
        });
        AppMethodBeat.o(163554);
    }

    @Override // com.tencent.mm.plugin.luckymoney.a.a
    public final void a(com.tencent.mm.ag.g gVar) {
        AppMethodBeat.i(163555);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do trigger load red packet story: %s, %s", gVar.iwu, Boolean.valueOf(gVar.iwx));
        ay(gVar.iwv, gVar.iww, gVar.iwu);
        if (!Util.isNullOrNil(gVar.iwu) && gVar.iwx) {
            com.tencent.mm.plugin.luckymoney.story.b.a aVar = new com.tencent.mm.plugin.luckymoney.story.b.a();
            aVar.field_packet_id = gVar.iwu;
            boolean z = com.tencent.mm.plugin.luckymoney.b.a.eex().eeu().get(aVar, new String[0]);
            if (System.currentTimeMillis() - aVar.field_update_time > Util.MILLSECONDS_OF_DAY) {
                Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "need refetch story data");
                z = false;
            }
            Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load red packet story resource: %s", Boolean.valueOf(z));
            if (!z) {
                com.tencent.mm.plugin.luckymoney.story.a.b bVar = new com.tencent.mm.plugin.luckymoney.story.a.b();
                bVar.b(new com.tencent.mm.plugin.luckymoney.story.a.a(gVar.iwu, false));
                bVar.a(new a.AbstractC2168a<buh>() {
                    /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass10 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
                    @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
                    public final /* synthetic */ void d(buh buh, int i2, int i3) {
                        AppMethodBeat.i(258575);
                        buh buh2 = buh;
                        if (buh2 != null) {
                            if (buh2.MaT != null) {
                                buh2.MaT.VjK = buh2.VjK;
                            }
                            r.this.a(buh2.MaT, false);
                        }
                        AppMethodBeat.o(258575);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
                    public final /* bridge */ /* synthetic */ void dx(buh buh) {
                    }
                }, 50);
            }
        }
        AppMethodBeat.o(163555);
    }

    @Override // com.tencent.mm.plugin.luckymoney.a.a
    public final void a(dlt dlt, boolean z) {
        AppMethodBeat.i(258576);
        if (dlt == null) {
            AppMethodBeat.o(258576);
            return;
        }
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do preload red packet: %s", dlt.iwu);
        if (!Util.isNullOrNil(dlt.iwv)) {
            ay(dlt.iwv, dlt.iww, dlt.iwu);
        }
        if (!dlt.MPo.isEmpty()) {
            for (int i2 = 0; i2 < dlt.MPo.size(); i2++) {
                edn edn = dlt.MPo.get(i2);
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                if (edn.Gat == 1) {
                    a(edn.Gav, edn.NdO, dlt.iwu, new a() {
                        /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass11 */

                        @Override // com.tencent.mm.plugin.luckymoney.model.r.a
                        public final void b(Bitmap bitmap, int i2, String str) {
                            AppMethodBeat.i(65194);
                            r.a((ImageView) null, str, 4, i2, elapsedRealtime);
                            AppMethodBeat.o(65194);
                        }
                    });
                } else {
                    a(edn.NdP, edn.NdQ, dlt.iwu, new a() {
                        /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass12 */

                        @Override // com.tencent.mm.plugin.luckymoney.model.r.a
                        public final void b(Bitmap bitmap, int i2, String str) {
                            AppMethodBeat.i(65196);
                            r.a((ImageView) null, str, 4, i2, elapsedRealtime);
                            AppMethodBeat.o(65196);
                        }
                    });
                    if (z && (NetStatusUtil.isWifi(MMApplicationContext.getContext()) || NetStatusUtil.is4G(MMApplicationContext.getContext()))) {
                        String aDz = EnvelopeStoryVideoManager.aDz(edn.Gav);
                        String aDA = EnvelopeStoryVideoManager.aDA(edn.Gav);
                        boolean z2 = EnvelopeStoryVideoManager.VQ().getInt(aDz, 0) == 1;
                        boolean YS = s.YS(aDA);
                        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "do story video preload: %s, %s", Boolean.valueOf(z2), Boolean.valueOf(YS));
                        if (!YS && !z2) {
                            if (EnvelopeStoryVideoManager.dD(dlt.VjK, t.nk(dlt.VjK, i2))) {
                                Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] has local video，do not preload");
                                AppMethodBeat.o(258576);
                                return;
                            }
                            EnvelopeStoryVideoManager.a(aDz, aDA, edn.Gav, edn.NdO, true, null, new h.a() {
                                /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass13 */

                                @Override // com.tencent.mm.i.h.a
                                public final void Ds(String str) {
                                }

                                @Override // com.tencent.mm.i.h.a
                                public final void a(String str, long j2, long j3, String str2) {
                                }

                                @Override // com.tencent.mm.i.h.a
                                public final void onDataAvailable(String str, long j2, long j3) {
                                }

                                @Override // com.tencent.mm.i.h.a
                                public final void i(String str, long j2, long j3) {
                                }

                                @Override // com.tencent.mm.i.h.a
                                public final void a(String str, int i2, d dVar) {
                                }
                            });
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(258576);
    }

    @Override // com.tencent.mm.plugin.luckymoney.a.a
    public final void a(cbe cbe) {
        AppMethodBeat.i(163557);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "trigger load envelope resources");
        if (cbe == null || cbe.MgC == null) {
            AppMethodBeat.o(163557);
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        cbf cbf = cbe.MgC;
        if (!Util.isNullOrNil(cbf.MgU) && !Util.isNullOrNil(cbf.MgW)) {
            a(cbf.MgU, cbf.MgW, cbe.Lot, new a() {
                /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass14 */

                @Override // com.tencent.mm.plugin.luckymoney.model.r.a
                public final void b(Bitmap bitmap, int i2, String str) {
                    AppMethodBeat.i(65200);
                    r.a((ImageView) null, str, 1, i2, elapsedRealtime);
                    AppMethodBeat.o(65200);
                }
            });
        }
        if (!Util.isNullOrNil(cbf.MgV) && !Util.isNullOrNil(cbf.MgY)) {
            a(cbf.MgV, cbf.MgY, cbe.Lot, new a() {
                /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass15 */

                @Override // com.tencent.mm.plugin.luckymoney.model.r.a
                public final void b(Bitmap bitmap, int i2, String str) {
                    AppMethodBeat.i(163551);
                    r.a((ImageView) null, str, 3, i2, elapsedRealtime);
                    AppMethodBeat.o(163551);
                }
            });
        }
        if (!Util.isNullOrNil(cbf.MgT) && !Util.isNullOrNil(cbf.MgZ)) {
            ay(cbf.MgT, cbf.MgZ, cbe.Lot);
        }
        if (!Util.isNullOrNil(cbf.igW) && !Util.isNullOrNil(cbf.MgX)) {
            a(cbf.igW, cbf.MgX, cbe.Lot, new a() {
                /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass16 */

                @Override // com.tencent.mm.plugin.luckymoney.model.r.a
                public final void b(Bitmap bitmap, int i2, String str) {
                    AppMethodBeat.i(163553);
                    r.a((ImageView) null, str, 2, i2, elapsedRealtime);
                    AppMethodBeat.o(163553);
                }
            });
        }
        AppMethodBeat.o(163557);
    }

    private void a(cbe cbe, int i2, a aVar) {
        AppMethodBeat.i(65203);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get envelope: %s", Integer.valueOf(i2));
        if (cbe == null) {
            AppMethodBeat.o(65203);
            return;
        }
        if (cbe.subType > 0) {
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_lucky_money_load_local_photo_res_config, true);
            Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", " [static luckymoney resource switch]canGetLuckyMoneyLocalPhotoRes ：%s", Boolean.valueOf(a2));
            if (a2) {
                Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use local：LuckyMoneyLocalPhotoRes：%s,type：%s", Integer.valueOf(cbe.subType), Integer.valueOf(i2));
                int i3 = cbe.subType;
                Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap subtype: %s, %s", Integer.valueOf(i3), Integer.valueOf(i2));
                String PK = t.PK(i3);
                u uVar = new u();
                uVar.field_subtype = i3;
                Bitmap bitmap = null;
                if (!com.tencent.mm.plugin.luckymoney.b.a.eex().eet().get(uVar, new String[0])) {
                    t.efh();
                    Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", Integer.valueOf(i3));
                } else if (i2 == 0) {
                    o oVar = new o(PK, "bubble.png");
                    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "");
                    bitmap = f(oVar, uVar.field_bubbleMd5);
                } else if (i2 == 1) {
                    bitmap = f(new o(PK, "cover.png"), uVar.field_coverMd5);
                } else if (i2 == 3) {
                    bitmap = f(new o(PK, "minilogo.png"), uVar.field_minilogoMd5);
                } else if (i2 == 2) {
                    bitmap = f(new o(PK, "detail.png"), uVar.field_detailMd5);
                }
                if (bitmap == null) {
                    Log.e("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use local：LuckyMoneyLocalPhotoRes fail");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(991, 5);
                }
                if (bitmap != null || cbe.MgC == null) {
                    aVar.b(bitmap, cbe.subType, "");
                    AppMethodBeat.o(65203);
                    return;
                }
                Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load subtype fail, try load from url: %s", Integer.valueOf(cbe.subType));
                b(cbe, i2, aVar);
                AppMethodBeat.o(65203);
                return;
            }
        }
        if (cbe.MgC != null) {
            Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use net: LuckyMoneyLocalPhotoRes：%s,type：%s", Integer.valueOf(cbe.subType), Integer.valueOf(i2));
            b(cbe, i2, aVar);
            AppMethodBeat.o(65203);
            return;
        }
        Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "source object is null");
        AppMethodBeat.o(65203);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void b(cbe cbe, int i2, a aVar) {
        AppMethodBeat.i(163558);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get bitmap by url: %s", Integer.valueOf(i2));
        if (cbe == null || cbe.MgC == null) {
            AppMethodBeat.o(163558);
            return;
        }
        cbf cbf = cbe.MgC;
        switch (i2) {
            case 0:
                a(cbf.MgU, cbf.MgW, cbe.Lot, aVar);
                AppMethodBeat.o(163558);
                return;
            case 1:
                com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX);
                com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 480);
                a(cbf.igW, cbf.MgX, cbe.Lot, false, aVar);
                AppMethodBeat.o(163558);
                return;
            case 2:
                a(cbf.MgV, cbf.MgY, cbe.Lot, aVar);
                AppMethodBeat.o(163558);
                return;
            case 3:
                MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.ab9);
                a(cbf.MgT, cbf.MgZ, cbe.Lot, false, aVar);
                break;
        }
        AppMethodBeat.o(163558);
    }

    private void ay(String str, String str2, String str3) {
        AppMethodBeat.i(163559);
        a(str, str2, str3, 0, 0, false, false, 0, null);
        AppMethodBeat.o(163559);
    }

    private void a(String str, String str2, String str3, a aVar) {
        AppMethodBeat.i(163560);
        a(str, str2, str3, 0, 0, false, false, 0, aVar);
        AppMethodBeat.o(163560);
    }

    private void a(String str, String str2, String str3, boolean z, a aVar) {
        AppMethodBeat.i(163561);
        a(str, str2, str3, 0, 0, z, false, 0, aVar);
        AppMethodBeat.o(163561);
    }

    private void a(String str, final String str2, final String str3, int i2, int i3, boolean z, boolean z2, int i4, final a aVar) {
        AppMethodBeat.i(213303);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load image: %s, %s", str, str2);
        if (Util.isNullOrNil(str)) {
            if (aVar != null) {
                aVar.b(null, 0, str);
            }
            AppMethodBeat.o(213303);
            return;
        }
        efg().a(str, (ImageView) null, a(i3, i2, z, false, i4).bdv(), new com.tencent.mm.av.a.c.h() {
            /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass2 */

            @Override // com.tencent.mm.av.a.c.h
            public final void b(String str, View view) {
            }

            @Override // com.tencent.mm.av.a.c.h
            public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                return null;
            }

            @Override // com.tencent.mm.av.a.c.h
            public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                AppMethodBeat.i(174317);
                Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load finish url: %s, %s, %s", str, Integer.valueOf(bVar.status), Integer.valueOf(bVar.from));
                if (bVar.status == 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(991, 6);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(18888, 1, str3, str);
                    if (bVar.data != null) {
                        String mD5String = MD5Util.getMD5String(bVar.data);
                        if (!Util.isNullOrNil(str2) && !mD5String.equals(str2)) {
                            Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "md5 not match: %s, %s", mD5String, str2);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(991, 8);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16543, str, str2, mD5String);
                        }
                    }
                } else if (bVar.status == 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(991, 7);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(18888, 2, str3, str);
                } else if (bVar.status == 2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(991, 8);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(18888, 2, str3, str);
                } else if (bVar.bitmap == null || bVar.bitmap.isRecycled()) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(991, 9);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(18888, 2, str3, str);
                }
                if (aVar != null) {
                    aVar.b(bVar.bitmap, bVar.from, str);
                }
                AppMethodBeat.o(174317);
            }
        });
        AppMethodBeat.o(213303);
    }

    private static Bitmap n(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(258577);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get StoryBitmap subtype: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        Bitmap bitmap = null;
        if (i3 == 4) {
            bitmap = a(new o(t.awX(i2), "detail_image_" + i4 + ".png"), i5, i6);
        } else if (i3 == 5) {
            bitmap = a(new o(t.awX(i2), "detail_video_thumb_" + i4 + ".png"), i5, i6);
        } else if (i3 == 2) {
            bitmap = a(new o(t.PK(i2), "detail.png"), i5, i6);
        } else {
            t.efh();
            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "can't find subtype res: %s", Integer.valueOf(i2));
        }
        if (bitmap == null) {
            Log.e("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use local：LuckyMoneyEnvelopeLocalPhotoRes fail");
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(991, 5);
        }
        AppMethodBeat.o(258577);
        return bitmap;
    }

    private static Bitmap f(o oVar, String str) {
        AppMethodBeat.i(174327);
        boolean exists = oVar.exists();
        boolean isFile = oVar.isFile();
        String bhK = s.bhK(aa.z(oVar.mUri));
        if (Util.isNullOrNil(bhK)) {
            AppMethodBeat.o(174327);
            return null;
        }
        boolean equals = bhK.equals(str);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s, %s", Boolean.valueOf(exists), Boolean.valueOf(isFile), Boolean.valueOf(equals));
        if (!exists || !isFile || !equals) {
            if (!equals) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(991, 3);
            }
            if (!exists) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(991, 4);
            }
            t.efh();
            AppMethodBeat.o(174327);
            return null;
        }
        Bitmap decodeFile = BitmapUtil.decodeFile(aa.z(oVar.her()));
        AppMethodBeat.o(174327);
        return decodeFile;
    }

    @Override // com.tencent.mm.plugin.luckymoney.a.a
    public final void a(final ImageView imageView, cbe cbe) {
        AppMethodBeat.i(65207);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load crop view");
        if (imageView == null || cbe == null) {
            AppMethodBeat.o(65207);
            return;
        }
        a(cbe, 3, new a() {
            /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.luckymoney.model.r.a
            public final void b(final Bitmap bitmap, int i2, String str) {
                AppMethodBeat.i(163543);
                if (bitmap == null || bitmap.isRecycled()) {
                    Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i2), str);
                    AppMethodBeat.o(163543);
                    return;
                }
                r.aw(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(163542);
                        imageView.setImageBitmap(bitmap);
                        AppMethodBeat.o(163542);
                    }
                });
                AppMethodBeat.o(163543);
            }
        });
        AppMethodBeat.o(65207);
    }

    @Override // com.tencent.mm.plugin.luckymoney.a.a
    public final void a(final ImageView imageView, cbe cbe, final a.AbstractC1465a aVar) {
        AppMethodBeat.i(65209);
        if (imageView == null || cbe == null) {
            AppMethodBeat.o(65209);
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load cover view: %s", cbe.Lot);
        imageView.setTag(R.id.f0n, cbe.MgC.igW);
        imageView.setTag(R.id.f0j, Integer.valueOf(cbe.subType));
        a(cbe, 1, new a() {
            /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.luckymoney.model.r.a
            public final void b(final Bitmap bitmap, final int i2, final String str) {
                AppMethodBeat.i(174319);
                if (bitmap == null || bitmap.isRecycled()) {
                    Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i2), str);
                    if (aVar != null) {
                        aVar.ei(false);
                    }
                    AppMethodBeat.o(174319);
                    return;
                }
                r.aw(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(174318);
                        int intValue = ((Integer) imageView.getTag(R.id.f0j)).intValue();
                        if (intValue <= 0 || intValue != i2) {
                            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", Integer.valueOf(intValue), Integer.valueOf(i2));
                        } else {
                            imageView.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(bitmap, false, (float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
                            if (aVar != null) {
                                aVar.ei(true);
                            }
                            r.a(imageView, str, 2, i2, elapsedRealtime);
                        }
                        String str = (String) imageView.getTag(R.id.f0n);
                        if (Util.isNullOrNil(str) || !str.equals(str)) {
                            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", str, str);
                            AppMethodBeat.o(174318);
                            return;
                        }
                        imageView.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(bitmap, false, (float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
                        if (aVar != null) {
                            aVar.ei(true);
                        }
                        r.a(imageView, str, 2, i2, elapsedRealtime);
                        AppMethodBeat.o(174318);
                    }
                });
                AppMethodBeat.o(174319);
            }
        });
        AppMethodBeat.o(65209);
    }

    @Override // com.tencent.mm.plugin.luckymoney.a.a
    public final void a(final ImageView imageView, final int i2, final int i3, cbe cbe, final boolean z) {
        AppMethodBeat.i(65210);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load chatting view: %s", Boolean.valueOf(z));
        if (imageView == null) {
            AppMethodBeat.o(65210);
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        imageView.setTag(R.id.f0n, cbe.MgC.MgU);
        imageView.setTag(R.id.f0j, Integer.valueOf(cbe.subType));
        a(cbe, 0, new a() {
            /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.luckymoney.model.r.a
            public final void b(final Bitmap bitmap, final int i2, final String str) {
                AppMethodBeat.i(174321);
                if (bitmap == null || bitmap.isRecycled()) {
                    Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i2), str);
                    AppMethodBeat.o(174321);
                    return;
                }
                r.aw(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(174320);
                        int intValue = ((Integer) imageView.getTag(R.id.f0j)).intValue();
                        if (intValue <= 0 || intValue != i2) {
                            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", Integer.valueOf(intValue), Integer.valueOf(i2));
                        } else {
                            imageView.setImageBitmap(r.a(bitmap, i2, i3, z));
                        }
                        String str = (String) imageView.getTag(R.id.f0n);
                        if (Util.isNullOrNil(str) || !str.equals(str)) {
                            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", str, str);
                        } else {
                            imageView.setImageBitmap(r.a(bitmap, i2, i3, z));
                        }
                        r.a(imageView, str, 1, i2, elapsedRealtime);
                        AppMethodBeat.o(174320);
                    }
                });
                AppMethodBeat.o(174321);
            }
        });
        AppMethodBeat.o(65210);
    }

    @Override // com.tencent.mm.plugin.luckymoney.a.a
    public final void a(String str, String str2, String str3, final a.AbstractC1465a aVar) {
        AppMethodBeat.i(163563);
        a(str, str2, str3, new a() {
            /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.luckymoney.model.r.a
            public final void b(Bitmap bitmap, int i2, String str) {
                AppMethodBeat.i(174322);
                if (bitmap == null || bitmap.isRecycled()) {
                    aVar.ei(false);
                    AppMethodBeat.o(174322);
                    return;
                }
                aVar.ei(true);
                AppMethodBeat.o(174322);
            }
        });
        AppMethodBeat.o(163563);
    }

    @Override // com.tencent.mm.plugin.luckymoney.a.a
    public final void a(final ImageView imageView, String str, String str2, String str3) {
        AppMethodBeat.i(163564);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load logo view");
        if (imageView == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(163564);
            return;
        }
        imageView.setTag(R.id.f0n, str);
        a(str, str2, str3, true, (a) new a() {
            /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.luckymoney.model.r.a
            public final void b(final Bitmap bitmap, int i2, final String str) {
                AppMethodBeat.i(174324);
                if (bitmap == null || bitmap.isRecycled()) {
                    Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i2), str);
                    AppMethodBeat.o(174324);
                    return;
                }
                r.aw(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass7.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(174323);
                        String str = (String) imageView.getTag(R.id.f0n);
                        if (Util.isNullOrNil(str) || !str.equals(str)) {
                            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", str, str);
                            AppMethodBeat.o(174323);
                            return;
                        }
                        imageView.setImageBitmap(bitmap);
                        AppMethodBeat.o(174323);
                    }
                });
                AppMethodBeat.o(174324);
            }
        });
        AppMethodBeat.o(163564);
    }

    @Override // com.tencent.mm.plugin.luckymoney.a.a
    public final void a(ImageView imageView, String str, String str2, String str3, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(258578);
        a(imageView, str, str2, str3, i2, i3, 0, null, i4, 5, i5);
        AppMethodBeat.o(258578);
    }

    @Override // com.tencent.mm.plugin.luckymoney.a.a
    public final void a(final ImageView imageView, final String str, String str2, String str3, int i2, int i3, int i4, final a.AbstractC1465a aVar, final int i5, int i6, int i7) {
        AppMethodBeat.i(258579);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load story view");
        if (imageView == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(258579);
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        imageView.setTag(R.id.f0n, str);
        imageView.setTag(R.id.f0j, Integer.valueOf(i5));
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "subTypeID：%s，envelopeType：%s,index:%s", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
        if (i5 > 0 && hWb()) {
            Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use local：LuckyMoneyEnvelopeLocalPhotoRes - subTypeID：%s，envelopeType：%s,index:%s ", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
            final Bitmap n = n(i5, i6, i7, i2, i3);
            if (n != null) {
                runInMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(258571);
                        if (n == null || n.isRecycled()) {
                            Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i5), str);
                            if (aVar != null) {
                                aVar.ei(false);
                            }
                            AppMethodBeat.o(258571);
                            return;
                        }
                        int intValue = ((Integer) imageView.getTag(R.id.f0j)).intValue();
                        if (intValue <= 0 || intValue != i5) {
                            Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subType: %s, %s", Integer.valueOf(intValue), Integer.valueOf(i5));
                        } else {
                            imageView.setImageBitmap(n);
                        }
                        if (aVar != null) {
                            aVar.ei(true);
                        }
                        if (imageView.getId() == R.id.iad) {
                            r.a(imageView, str, 3, i5, elapsedRealtime);
                        }
                        AppMethodBeat.o(258571);
                    }
                });
                AppMethodBeat.o(258579);
                return;
            }
        }
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "[static luckymoney resource] use net：LuckyMoneyEnvelopeLocalPhotoRes - subTypeID：%s，envelopeType：%s,index:%s ", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
        a(str, str2, str3, i3, i2, false, false, i4, new a() {
            /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass17 */

            @Override // com.tencent.mm.plugin.luckymoney.model.r.a
            public final void b(final Bitmap bitmap, final int i2, final String str) {
                AppMethodBeat.i(258573);
                r.aw(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.model.r.AnonymousClass17.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(258572);
                        if (bitmap == null || bitmap.isRecycled()) {
                            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", Integer.valueOf(i2), str);
                            if (aVar != null) {
                                aVar.ei(false);
                            }
                            AppMethodBeat.o(258572);
                            return;
                        }
                        String str = (String) imageView.getTag(R.id.f0n);
                        if (Util.isNullOrNil(str) || !str.equals(str)) {
                            Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", str, str);
                        } else {
                            imageView.setImageBitmap(bitmap);
                        }
                        if (aVar != null) {
                            aVar.ei(true);
                        }
                        if (imageView.getId() == R.id.iad) {
                            r.a(imageView, str, 3, i2, elapsedRealtime);
                        }
                        AppMethodBeat.o(258572);
                    }
                });
                AppMethodBeat.o(258573);
            }
        });
        AppMethodBeat.o(258579);
    }

    private static void runInMainThread(Runnable runnable) {
        AppMethodBeat.i(258580);
        if (MMHandlerThread.isMainThread()) {
            runnable.run();
            AppMethodBeat.o(258580);
            return;
        }
        MMHandlerThread.postToMainThread(runnable);
        AppMethodBeat.o(258580);
    }

    private static com.tencent.mm.av.a.a efg() {
        AppMethodBeat.i(65211);
        com.tencent.mm.av.a.a aVar = yVK.get();
        AppMethodBeat.o(65211);
        return aVar;
    }

    private static c.a a(int i2, int i3, boolean z, boolean z2, int i4) {
        AppMethodBeat.i(213304);
        if (i2 <= 0) {
            i2 = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext());
        }
        if (i3 <= 0) {
            i3 = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
        }
        c.a aVar = new c.a();
        com.tencent.mm.plugin.luckymoney.b.a.eex();
        aVar.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.eeA();
        aVar.hZz = i3;
        aVar.hZA = i2;
        aVar.iaT = z;
        aVar.jbl = z2;
        aVar.jbm = i4;
        aVar.jbf = true;
        AppMethodBeat.o(213304);
        return aVar;
    }

    private static Bitmap a(o oVar, int i2, int i3) {
        AppMethodBeat.i(258581);
        boolean exists = oVar.exists();
        boolean isFile = oVar.isFile();
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "get from file: %s, %s", Boolean.valueOf(exists), Boolean.valueOf(isFile));
        if (!exists || !isFile) {
            t.efh();
            AppMethodBeat.o(258581);
            return null;
        }
        Bitmap bitmapNative = BitmapUtil.getBitmapNative(aa.z(oVar.her()), i3, i2);
        AppMethodBeat.o(258581);
        return bitmapNative;
    }

    private static boolean hWb() {
        AppMethodBeat.i(258582);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_lucky_money_envelope_load_local_photo_res_config, true);
        Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", " [static luckymoney resource switch]canGetLuckyMoneyEnvelopeLocalPhotoRes ：%s", Boolean.valueOf(a2));
        AppMethodBeat.o(258582);
        return a2;
    }

    static /* synthetic */ void a(ImageView imageView, String str, int i2, int i3, long j2) {
        int i4;
        AppMethodBeat.i(174328);
        if (imageView == null) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(19232, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3 + 1), Long.valueOf(SystemClock.elapsedRealtime() - j2), str);
        AppMethodBeat.o(174328);
    }

    static /* synthetic */ Bitmap a(Bitmap bitmap, int i2, int i3, boolean z) {
        int i4;
        AppMethodBeat.i(174330);
        Log.d("MicroMsg.LuckyMoneyEnvelopeLogic", "th: %s, tw: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (z) {
            i3 -= com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6);
        }
        Bitmap centerCropBitmap = BitmapUtil.getCenterCropBitmap(bitmap, i3, i2, false);
        if (z) {
            i4 = R.drawable.c3d;
        } else {
            i4 = R.drawable.c3o;
        }
        Bitmap createChattingImage = BitmapUtil.createChattingImage(centerCropBitmap, i4);
        AppMethodBeat.o(174330);
        return createChattingImage;
    }
}
