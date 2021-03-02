package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.davemorrissey.labs.subscaleview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.e;
import com.tencent.mm.av.h;
import com.tencent.mm.av.m;
import com.tencent.mm.av.q;
import com.tencent.mm.b.p;
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.ImageOptimLib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.gallery.b;
import com.tencent.mm.ui.chatting.gallery.e;
import com.tencent.mm.ui.chatting.gallery.g;
import com.tencent.mm.vfs.s;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class d extends a implements e.a, e.a {
    private static boolean PxT = true;
    private static long PxU = ((long) (((double) Runtime.getRuntime().maxMemory()) * 0.05d));
    private HashMap<String, WeakReference<Bitmap>> JeH = new HashMap<>();
    private IListener PxN;
    n PxO;
    public HashMap<Long, Integer> PxP = new HashMap<>();
    public final e PxQ = new e(this);
    private HashMap<ca, String> PxR = new HashMap<>();
    private HashMap<ca, String> PxS = new HashMap<>();
    private long PxV = 0;
    int mScrollState = 0;

    static /* synthetic */ void a(ca caVar, k kVar) {
        AppMethodBeat.i(233296);
        a(caVar, kVar, 5);
        AppMethodBeat.o(233296);
    }

    static /* synthetic */ void a(k kVar) {
        AppMethodBeat.i(36045);
        a(kVar, true, false);
        AppMethodBeat.o(36045);
    }

    public d(b bVar) {
        super(bVar);
        AppMethodBeat.i(36007);
        EventCenter eventCenter = EventCenter.instance;
        al alVar = new al(al.a.IMAGE_GALLERY_UI, bVar.Pwv);
        this.PxN = alVar;
        eventCenter.addListener(alVar);
        this.PxQ.cg(g.a.Pyr.xqj.snapshot());
        l.gTf().PBn = this;
        AppMethodBeat.o(36007);
    }

    @Override // com.tencent.mm.ui.chatting.gallery.a
    public final void detach() {
        AppMethodBeat.i(36008);
        super.detach();
        EventCenter.instance.removeListener(this.PxN);
        if (this.JeH != null) {
            for (String str : this.JeH.keySet()) {
                Bitmap bitmap = this.JeH.get(str).get();
                if (bitmap != null && !bitmap.isRecycled()) {
                    Log.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
            }
        }
        e eVar = this.PxQ;
        eVar.Pyc = null;
        eVar.xqf.clear();
        eVar.xqi.clear();
        eVar.xqh.clear();
        eVar.xqg.clear();
        eVar.Pyb.clear();
        eVar.dSj();
        if (eVar.CQj != null && !eVar.CQj.isRecycled()) {
            Log.i("MicroMsg.ImageGalleryLazyLoader", "bitmap recycle %s", eVar.CQj.toString());
            eVar.CQj.recycle();
            eVar.CQj = null;
        }
        q.bcS().a(this);
        l gTf = l.gTf();
        if (equals(gTf.PBn)) {
            gTf.PBn = null;
        }
        AppMethodBeat.o(36008);
    }

    public final int cy(ca caVar) {
        AppMethodBeat.i(36009);
        if (caVar == null || !this.PxP.containsKey(Long.valueOf(caVar.field_msgId))) {
            AppMethodBeat.o(36009);
            return 0;
        }
        int intValue = this.PxP.get(Long.valueOf(caVar.field_msgId)).intValue();
        AppMethodBeat.o(36009);
        return intValue;
    }

    private void h(ca caVar, int i2) {
        AppMethodBeat.i(36010);
        this.PxP.put(Long.valueOf(caVar.field_msgId), Integer.valueOf(i2));
        AppMethodBeat.o(36010);
    }

    private void ap(long j2, int i2) {
        AppMethodBeat.i(36011);
        this.PxP.put(Long.valueOf(j2), Integer.valueOf(i2));
        AppMethodBeat.o(36011);
    }

    @Override // com.tencent.mm.ui.chatting.gallery.a
    public final boolean a(k kVar, ca caVar, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        int i3;
        AppMethodBeat.i(36012);
        super.a(kVar, caVar, i2);
        if (kVar == null || caVar == null || i2 < 0) {
            AppMethodBeat.o(36012);
            return false;
        }
        int cy = cy(caVar);
        Log.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s currentState : %s", Integer.valueOf(kVar.PBc.hashCode()), Integer.valueOf(i2), Integer.valueOf(cy));
        k.ai(kVar.PAT, 8);
        try {
            com.tencent.mm.av.g i4 = i(caVar, false);
            if (i4 == null) {
                z = false;
            } else {
                switch (cy) {
                    case 0:
                        Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
                        Log.i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
                        if (caVar.field_isSend == 1) {
                            z3 = caVar.gDB();
                        } else if (caVar.gDB()) {
                            z3 = true;
                        } else {
                            String d2 = d(caVar, i4);
                            if (!i4.bcu() || (d2 != null && s.YS(d2))) {
                                long aWy = cl.aWy();
                                long j2 = caVar.field_createTime;
                                if (aWy - j2 <= 259200000 || (!Util.isNullOrNil(d2) && s.YS(d2))) {
                                    z2 = false;
                                } else {
                                    Log.i("MicroMsg.ImageGalleryHolderImage", "cur time: %s, msg time: %s, path: %s.", Long.valueOf(aWy), Long.valueOf(j2), d2);
                                    z2 = true;
                                }
                                if (z2) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            } else {
                                z3 = true;
                            }
                        }
                        if (!z3) {
                            if (a(kVar, caVar, i4, i2)) {
                                boolean z4 = false;
                                com.tencent.mm.av.g U = q.bcR().U(caVar);
                                Log.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc temp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", Long.valueOf(U.localId), Long.valueOf(U.iXv), Long.valueOf(U.dTS), Integer.valueOf(U.iXx), Integer.valueOf(U.iKP));
                                if (U != null) {
                                    if (!Util.isEqual(U.iXx, 0)) {
                                        com.tencent.mm.av.g tl = q.bcR().tl(U.iXx);
                                        Log.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc hdTemp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", Long.valueOf(tl.localId), Long.valueOf(tl.iXv), Long.valueOf(tl.dTS), Integer.valueOf(tl.iXx), Integer.valueOf(tl.iKP));
                                        i3 = tl.iKP;
                                    } else {
                                        i3 = U.iKP;
                                    }
                                    int boW = (int) s.boW(q.bcR().o(i4.iXm, "", ""));
                                    if (caVar.field_isSend == 1 && Util.isEqual(i3, boW)) {
                                        z4 = true;
                                    }
                                    Log.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() sizeInDb:%s oriSize:%s noNeedDownLoad:%s", Integer.valueOf(i3), Integer.valueOf(boW), Boolean.valueOf(z4));
                                } else {
                                    Log.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() temp == null");
                                }
                                if (z4 || i4.bcu()) {
                                    h(caVar, 4);
                                    break;
                                } else {
                                    h(caVar, 1);
                                }
                            } else {
                                Log.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc dealSucc() == false");
                                h(caVar, 2);
                            }
                            ab.ab(caVar);
                            int a2 = q.bcS().a(i4.localId, caVar.field_msgId, 0, Integer.valueOf(i2), R.drawable.c3h, this, 0, true);
                            if (this.Pwu != null) {
                                this.Pwu.j(caVar, false);
                            }
                            Log.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", Integer.valueOf(a2));
                            if (a2 != -2) {
                                a(kVar, caVar, i4, false, i2);
                                break;
                            } else {
                                Log.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
                                com.tencent.mm.av.g i5 = i(caVar, true);
                                if (i5 != null) {
                                    if (!a(kVar, caVar, i5, i2)) {
                                        h(caVar, 2);
                                    } else if (caVar.field_isSend == 1 || i5.bcu()) {
                                        h(caVar, 4);
                                        break;
                                    } else {
                                        h(caVar, 1);
                                    }
                                    Log.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", Long.valueOf(i5.localId), Boolean.valueOf(i5.bcu()));
                                    a(kVar, caVar, i5, false, i2);
                                    break;
                                } else {
                                    Log.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
                                    break;
                                }
                            }
                        } else {
                            h(caVar, 5);
                            a(caVar, kVar, 5);
                            break;
                        }
                        break;
                    case 1:
                    case 4:
                        a(kVar, caVar, i4, i2);
                        break;
                    case 2:
                        a(kVar, caVar, i4, false, i2);
                        break;
                    case 3:
                        a(kVar, caVar, i4, true, i2);
                        break;
                    case 5:
                    case 6:
                        a(caVar, kVar, cy);
                        kVar.convertView.invalidate();
                        break;
                }
                z = true;
            }
        } catch (NullPointerException e2) {
            Log.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", e2, "", new Object[0]);
            z = false;
        }
        kVar.PBc.OVa = br.H(caVar);
        if (kVar.PBc.OVa != 0.0f) {
            jc jcVar = new jc();
            jcVar.emN = caVar.field_msgSvrId;
            jcVar.eLn = (long) caVar.getType();
            jcVar.eQu = (long) br.C(caVar);
            jcVar.ejA = 2;
            jcVar.bfK();
        }
        AppMethodBeat.o(36012);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        if (r0.localId == 0) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.av.g k(com.tencent.mm.storage.ca r7) {
        /*
            r6 = 36013(0x8cad, float:5.0465E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            boolean r0 = com.tencent.mm.ui.chatting.gallery.b.j(r7)
            if (r0 != 0) goto L_0x0011
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0010:
            return r0
        L_0x0011:
            int r0 = r7.field_isSend
            r1 = 1
            if (r0 != r1) goto L_0x002a
            long r0 = r7.field_msgId
            com.tencent.mm.av.i r2 = com.tencent.mm.av.q.bcR()
            java.lang.String r3 = r7.field_talker
            com.tencent.mm.av.g r0 = r2.H(r3, r0)
            long r2 = r0.localId
            r4 = 0
            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0036
        L_0x002a:
            long r0 = r7.field_msgSvrId
            com.tencent.mm.av.i r2 = com.tencent.mm.av.q.bcR()
            java.lang.String r3 = r7.field_talker
            com.tencent.mm.av.g r0 = r2.G(r3, r0)
        L_0x0036:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.d.k(com.tencent.mm.storage.ca):com.tencent.mm.av.g");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        if (r2.localId == 0) goto L_0x0078;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.av.g i(com.tencent.mm.storage.ca r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.d.i(com.tencent.mm.storage.ca, boolean):com.tencent.mm.av.g");
    }

    private String d(ca caVar, com.tencent.mm.av.g gVar) {
        AppMethodBeat.i(36015);
        String str = this.PxR.get(caVar);
        if (str == null) {
            str = a(caVar, gVar, false);
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(36015);
                return null;
            }
            this.PxR.put(caVar, str);
        }
        AppMethodBeat.o(36015);
        return str;
    }

    private boolean a(k kVar, ca caVar, com.tencent.mm.av.g gVar, int i2) {
        AppMethodBeat.i(36016);
        Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
        String d2 = d(caVar, gVar);
        k.ai(kVar.PAY, 8);
        String str = this.PxS.get(caVar);
        if (str == null) {
            str = q.bcR().R(caVar.field_imgPath, true);
            this.PxS.put(caVar, str);
        }
        boolean a2 = a(kVar, str, d2, caVar);
        if (i2 == this.Pwu.Pwv.getCurrentItem() && this.Pwu.Pwz) {
            this.Pwu.cu(caVar);
            this.Pwu.Pwz = false;
        }
        AppMethodBeat.o(36016);
        return a2;
    }

    private void a(k kVar, ca caVar, com.tencent.mm.av.g gVar, boolean z, int i2) {
        AppMethodBeat.i(36017);
        a(kVar, caVar, gVar, z, true, i2);
        AppMethodBeat.o(36017);
    }

    private void a(k kVar, ca caVar, com.tencent.mm.av.g gVar, boolean z, boolean z2, int i2) {
        AppMethodBeat.i(36018);
        Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = ".concat(String.valueOf(z)));
        k.ai(kVar.PAZ, 8);
        String str = null;
        if (!z) {
            kVar.PBc.setVisibility(0);
        }
        com.tencent.mm.av.g a2 = h.a(gVar);
        if (z && i2 == this.Pwu.Pwv.getCurrentItem()) {
            this.Pwu.Pwv.gST();
        }
        if (z) {
            str = a(caVar, gVar, true);
        }
        if (Util.isNullOrNil(str)) {
            str = q.bcR().o(a2.iXo, "", "");
        }
        String R = q.bcR().R(caVar.field_imgPath, true);
        if (z2) {
            a(kVar, R, str, caVar);
        }
        if (!z) {
            int i3 = gVar.iKP;
            if (Math.max(1, (int) (i3 != 0 ? ((((long) gVar.offset) * 100) / ((long) i3)) - 1 : 0)) > 50) {
                kVar.gTb().PAY.setVisibility(8);
            } else {
                kVar.gTb().PAY.setVisibility(0);
            }
        }
        kVar.gTb().PAW.setVisibility(8);
        kVar.gTb().PAV.setVisibility(8);
        kVar.gTb().PAU.setVisibility(8);
        AppMethodBeat.o(36018);
    }

    private static void a(ca caVar, k kVar, int i2) {
        AppMethodBeat.i(36019);
        Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
        String R = q.bcR().R(caVar.field_imgPath, true);
        k.ai(kVar.PAY, 8);
        k.ai(kVar.PAT, 8);
        k.ai(kVar.PBc, 8);
        k.ai(kVar.PBd, 8);
        kVar.gTc().PAZ.setVisibility(0);
        kVar.gTc().PBb.setImageResource(R.raw.image_download_fail_icon);
        if (R == null || !s.YS(R)) {
            kVar.gTc().PBa.setText(R.string.e36);
            AppMethodBeat.o(36019);
        } else if (i2 == 6) {
            kVar.gTc().PBa.setText(R.string.e34);
            AppMethodBeat.o(36019);
        } else if (caVar.gDB()) {
            kVar.gTc().PBa.setText(R.string.e32);
            AppMethodBeat.o(36019);
        } else {
            kVar.gTc().PBa.setText(R.string.e33);
            AppMethodBeat.o(36019);
        }
    }

    private boolean a(k kVar, String str, String str2, ca caVar) {
        AppMethodBeat.i(36020);
        boolean b2 = b(kVar, str, str2, caVar);
        AppMethodBeat.o(36020);
        return b2;
    }

    private boolean b(k kVar, String str, String str2, ca caVar) {
        AppMethodBeat.i(36021);
        k.ai(kVar.PBc, 0);
        k.ai(kVar.PAT, 8);
        k.ai(kVar.PAY, 8);
        k.ai(kVar.PAZ, 8);
        boolean a2 = a(kVar.PBc, str, str2, kVar.mPosition, caVar, kVar);
        AppMethodBeat.o(36021);
        return a2;
    }

    protected static BitmapFactory.Options bmT(String str) {
        AppMethodBeat.i(36022);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        AppMethodBeat.o(36022);
        return options;
    }

    static {
        AppMethodBeat.i(36048);
        AppMethodBeat.o(36048);
    }

    public static void gSn() {
        PxT = false;
    }

    private boolean a(MultiTouchImageView multiTouchImageView, String str, String str2, int i2, ca caVar, k kVar) {
        AppMethodBeat.i(36024);
        boolean a2 = a(true, multiTouchImageView, str, str2, false, i2, caVar, kVar, null, false);
        AppMethodBeat.o(36024);
        return a2;
    }

    private boolean a(boolean z, MultiTouchImageView multiTouchImageView, String str, String str2, boolean z2, final int i2, final ca caVar, final k kVar, com.tencent.mm.av.g gVar, boolean z3) {
        AppMethodBeat.i(36025);
        Log.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", Integer.valueOf(multiTouchImageView.hashCode()), str2, Integer.valueOf(i2));
        final String str3 = null;
        boolean z4 = true;
        if (str2 == null || !s.YS(str2)) {
            z4 = false;
        } else {
            str3 = s.k(str2, false);
        }
        if (str3 == null && str != null && s.YS(str)) {
            str3 = s.k(str, false);
            if (s.YS(str + "hd")) {
                str3 = s.k(str + "hd", false);
            }
        }
        if (str3 == null) {
            Log.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", str2);
            AppMethodBeat.o(36025);
            return false;
        } else if (kVar == null) {
            Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo initImageView holder is null");
            AppMethodBeat.o(36025);
            return false;
        } else {
            boolean z5 = !str3.equals(str) && !z3 && bmU(str3);
            Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt result: %b, path: %s", Boolean.valueOf(z5), str3);
            boolean z6 = z5 && !(kVar.PBd != null && kVar.PBd.getVisibility() == 0);
            if (!z5 && !z2 && this.PxQ.xqj.check(str3)) {
                Bitmap aT = this.PxQ.xqj.aT(str3);
                if (!aT.isRecycled()) {
                    Log.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", str3);
                    a(caVar != null ? caVar.field_msgId : 0, multiTouchImageView, str3, aT);
                    AppMethodBeat.o(36025);
                    return true;
                }
            }
            if (z) {
                multiTouchImageView.setImageBitmap(null);
            }
            if (z5) {
                if (kVar.PBd == null) {
                    AppMethodBeat.o(36025);
                    return false;
                }
                if (gVar == null) {
                    gVar = i(caVar, true);
                }
                kVar.PBd.setOnImageLoadEventListener(new b() {
                    /* class com.tencent.mm.ui.chatting.gallery.d.AnonymousClass1 */

                    @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                    public final void sb() {
                        AppMethodBeat.i(35998);
                        Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo SubsamplingImageView onPreviewLoaded");
                        AppMethodBeat.o(35998);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                    public final void n(Bitmap bitmap) {
                        long j2;
                        AppMethodBeat.i(35999);
                        if (!(bitmap == null || d.this.PxQ == null)) {
                            Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo onImageLoaded cache bitmap, cacheImagePath: %s", str3);
                            d.this.PxQ.e(i2 > 0 ? i2 : kVar.mPosition, bitmap);
                        }
                        d.a(kVar);
                        if (d.this.PxO != null) {
                            if (caVar != null) {
                                j2 = caVar.field_msgId;
                            } else {
                                j2 = 0;
                            }
                            d.this.PxO.b(j2, kVar.PBd, str3, bitmap);
                        }
                        AppMethodBeat.o(35999);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                    public final void a(c cVar) {
                        AppMethodBeat.i(36000);
                        Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onPreviewLoadError errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.errMsg);
                        AppMethodBeat.o(36000);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                    public final void b(c cVar) {
                        AppMethodBeat.i(36001);
                        Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onImageLoadError errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.errMsg);
                        com.tencent.mm.cq.c.aqq(cVar.errCode);
                        d.a(d.this, str3, kVar, i2);
                        if (cVar.errCode == 4) {
                            d.gSn();
                        }
                        AppMethodBeat.o(36001);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                    public final void c(c cVar) {
                        AppMethodBeat.i(36002);
                        Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onTileLoadError errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.errMsg);
                        d.a(caVar, kVar);
                        AppMethodBeat.o(36002);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                    public final void sc() {
                    }
                });
            }
            if (!this.Pwu.PwG) {
                if (i2 >= 0) {
                    Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", Integer.valueOf(i2));
                    a(kVar, false, true);
                    this.PxQ.c(multiTouchImageView, i2);
                }
            } else if (z5) {
                String e2 = e(caVar, gVar);
                a(kVar, true, z6);
                a(kVar.PBd, str3, e2 != null ? com.davemorrissey.labs.subscaleview.view.a.aP(e2) : null);
                AppMethodBeat.o(36025);
                return z4;
            } else {
                Bitmap bmW = bmW(str3);
                if (bmW == null) {
                    bmW = bmW(str);
                }
                if (bmW != null) {
                    a(kVar, false, true);
                    a(caVar != null ? caVar.field_msgId : 0, (View) multiTouchImageView, str3, bmW);
                    if (str3.equals(str2)) {
                        this.PxQ.w(str3, bmW);
                        this.PxQ.e(i2, bmW);
                    }
                    AppMethodBeat.o(36025);
                    return z4;
                }
            }
            if (z5) {
                a(kVar, true, z6);
                String e3 = e(caVar, gVar);
                e eVar = this.PxQ;
                WxImageView wxImageView = kVar.PBd;
                if (i2 < 0) {
                    i2 = kVar.mPosition;
                }
                eVar.b(wxImageView, str3, e3, i2);
            } else {
                a(kVar, false, true);
                e eVar2 = this.PxQ;
                if (i2 < 0) {
                    i2 = kVar.mPosition;
                }
                eVar2.f(multiTouchImageView, str3, i2);
            }
            AppMethodBeat.o(36025);
            return z4;
        }
    }

    private static void a(k kVar, boolean z, boolean z2) {
        int i2 = 8;
        AppMethodBeat.i(36026);
        if (kVar != null) {
            if (kVar.PBd != null) {
                kVar.PBd.setVisibility(z ? 0 : 8);
                if (z) {
                    kVar.PBe = true;
                } else {
                    kVar.PBe = false;
                }
            }
            if (kVar.PBc != null) {
                MultiTouchImageView multiTouchImageView = kVar.PBc;
                if (z2) {
                    i2 = 0;
                }
                multiTouchImageView.setVisibility(i2);
                if (z2) {
                    kVar.PBe = false;
                }
            }
        }
        AppMethodBeat.o(36026);
    }

    @Override // com.tencent.mm.ui.chatting.gallery.e.a
    public final void a(long j2, View view, String str, Bitmap bitmap) {
        AppMethodBeat.i(233291);
        if (bitmap == null) {
            AppMethodBeat.o(233291);
            return;
        }
        if (view != null) {
            int hashCode = view.hashCode();
            int hashCode2 = bitmap.hashCode();
            int indexOfValue = this.PxQ.xqk.indexOfValue(hashCode);
            if (indexOfValue >= 0) {
                this.PxQ.xqk.removeAt(indexOfValue);
            }
            this.PxQ.xqk.put(hashCode2, hashCode);
            if (view instanceof MultiTouchImageView) {
                a(j2, (MultiTouchImageView) view, str, bitmap);
                AppMethodBeat.o(233291);
                return;
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageBitmap(bitmap);
            }
        }
        AppMethodBeat.o(233291);
    }

    @Override // com.tencent.mm.ui.chatting.gallery.e.a
    public final Bitmap bmV(String str) {
        AppMethodBeat.i(258941);
        Bitmap bmW = bmW(str);
        AppMethodBeat.o(258941);
        return bmW;
    }

    @Override // com.tencent.mm.ui.chatting.gallery.e.a
    public final void a(WxImageView wxImageView, String str, com.davemorrissey.labs.subscaleview.view.a aVar) {
        AppMethodBeat.i(36029);
        BitmapFactory.Options bmT = bmT(str);
        wxImageView.setOrientation(BackwardSupportUtil.ExifHelper.getExifOrientation(str));
        wxImageView.cN(bmT.outWidth, bmT.outHeight);
        wxImageView.gKy();
        wxImageView.a(str, aVar);
        AppMethodBeat.o(36029);
    }

    public final p gSe() {
        AppMethodBeat.i(233293);
        ca gSg = this.Pwu.gSg();
        if (gSg == null) {
            Log.i("MicroMsg.ImageGalleryHolderImage", "getCurResourceState, msgInfo is null");
            AppMethodBeat.o(233293);
            return null;
        }
        int cy = cy(gSg);
        Log.i("MicroMsg.ImageGalleryHolderImage", "getCurResourceState, msgState: ".concat(String.valueOf(cy)));
        switch (cy) {
            case 4:
                p pVar = p.DOWNLOADED;
                AppMethodBeat.o(233293);
                return pVar;
            case 5:
            case 6:
                p pVar2 = p.EXPIRED;
                AppMethodBeat.o(233293);
                return pVar2;
            default:
                p pVar3 = p.NOT_DOWNLOADED;
                AppMethodBeat.o(233293);
                return pVar3;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static HashMap<String, a> Pya = new HashMap<>();
        private int PxY = 0;
        private int PxZ = 0;
        private long addTime = 0;
        private int height;
        private int iKP;
        private int width;
        private String zGG = "";

        private a() {
        }

        static {
            AppMethodBeat.i(36006);
            AppMethodBeat.o(36006);
        }

        public static void hf(String str, int i2) {
            AppMethodBeat.i(36004);
            try {
                if (Util.isNullOrNil(str) || i2 == 0) {
                    AppMethodBeat.o(36004);
                    return;
                }
                a aVar = Pya.get(str);
                if (aVar != null) {
                    aVar.iKP = i2;
                }
                HashSet<String> hashSet = new HashSet();
                for (String str2 : Pya.keySet()) {
                    a aVar2 = Pya.get(str2);
                    if (aVar2 != null) {
                        long milliSecondsToNow = Util.milliSecondsToNow(aVar2.addTime);
                        Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", Long.valueOf(milliSecondsToNow), Integer.valueOf(aVar2.iKP), Integer.valueOf(aVar2.width), Integer.valueOf(aVar2.height), Integer.valueOf(aVar2.PxY), Integer.valueOf(aVar2.PxZ), aVar2.zGG, str2);
                        if (milliSecondsToNow >= Util.MILLSECONDS_OF_MINUTE) {
                            if (aVar2.iKP > 0 && !Util.isNullOrNil(aVar2.zGG)) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11713, 0, 0, 41, 1, 0, 0, 0, 0, Integer.valueOf(aVar2.iKP), Integer.valueOf(aVar2.width), Integer.valueOf(aVar2.height), Integer.valueOf(aVar2.PxY), Integer.valueOf(aVar2.PxZ), aVar2.zGG);
                            }
                            hashSet.add(str2);
                        }
                    }
                }
                for (String str3 : hashSet) {
                    Pya.remove(str3);
                }
                AppMethodBeat.o(36004);
            } catch (Throwable th) {
                Log.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", Util.stackTraceToString(th));
                AppMethodBeat.o(36004);
            }
        }

        public static void t(String str, int i2, int i3, int i4) {
            AppMethodBeat.i(36005);
            try {
                if (Util.isNullOrNil(str) || i2 == 0 || i3 == 0) {
                    AppMethodBeat.o(36005);
                    return;
                }
                a aVar = Pya.get(str);
                if (aVar == null) {
                    aVar = new a();
                    aVar.addTime = Util.nowMilliSecond();
                    Pya.put(str, aVar);
                }
                aVar.height = i3;
                aVar.width = i2;
                aVar.zGG += i4 + "|";
                if (i4 > 0) {
                    if (aVar.PxY == 0) {
                        aVar.PxY = i4;
                    }
                } else if (aVar.PxY != 0) {
                    aVar.PxZ++;
                    aVar.PxY = 0;
                }
                Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(aVar.PxY), Integer.valueOf(aVar.PxZ), aVar.zGG, str);
                AppMethodBeat.o(36005);
            } catch (Throwable th) {
                Log.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", Util.stackTraceToString(th));
                AppMethodBeat.o(36005);
            }
        }
    }

    private static Bitmap aT(String str, int i2, int i3) {
        Throwable th;
        Bitmap bitmap;
        AppMethodBeat.i(36030);
        String str2 = str + "_tmp.jpg";
        try {
            if (com.tencent.mm.compatible.util.d.oE(16)) {
                AppMethodBeat.o(36030);
                return null;
            }
            if (!CrashReportFactory.hasDebuger()) {
                try {
                    int i4 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("UseOptImageRecv"), 0);
                    bg.aVF();
                    p pVar = new p(com.tencent.mm.model.c.getUin());
                    Log.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", Integer.valueOf(i4), Long.valueOf(pVar.longValue()), Long.valueOf(pVar.longValue() / 100), Boolean.valueOf(CrashReportFactory.hasDebuger()), Integer.valueOf(Build.VERSION.SDK_INT));
                    if ((((int) (pVar.longValue() / 100)) % 100) + 1 > i4) {
                        AppMethodBeat.o(36030);
                        return null;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", Util.stackTraceToString(e2));
                    AppMethodBeat.o(36030);
                    return null;
                }
            }
            s.boN(s.boZ(str2));
            s.nw(str, str2);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str2);
            boolean isProgressive = MMNativeJpeg.isProgressive(str2);
            boolean checkIntegrity = ImageOptimLib.checkIntegrity(str2);
            int boW = (int) s.boW(str2);
            if (!IsJpegFile || !isProgressive) {
                bitmap = null;
            } else {
                if (checkIntegrity) {
                    bitmap = MMNativeJpeg.decodeAsBitmap(str2);
                } else {
                    bitmap = null;
                }
                try {
                    a.t(str, i3, i2, bitmap != null ? boW : 0 - boW);
                } catch (Throwable th2) {
                    th = th2;
                    Log.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", str, Util.stackTraceToString(th));
                    s.deleteFile(str2);
                    AppMethodBeat.o(36030);
                    return bitmap;
                }
            }
            Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", Boolean.valueOf(IsJpegFile), Boolean.valueOf(isProgressive), Boolean.valueOf(checkIntegrity), Integer.valueOf(boW), Integer.valueOf(i3), Integer.valueOf(i2), bitmap, str);
            s.deleteFile(str2);
            AppMethodBeat.o(36030);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            bitmap = null;
            Log.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", str, Util.stackTraceToString(th));
            s.deleteFile(str2);
            AppMethodBeat.o(36030);
            return bitmap;
        }
    }

    private static Bitmap bmW(String str) {
        int i2;
        int i3;
        Bitmap e2;
        AppMethodBeat.i(36031);
        if (str == null) {
            AppMethodBeat.o(36031);
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            Log.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", decodeFile.toString());
            decodeFile.recycle();
        }
        int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        try {
            long max = Math.max((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()) - PxU, 0L);
            long j2 = (long) (options.outWidth * options.outHeight * 4);
            Log.i("MicroMsg.ImageGalleryHolderImage", "hy: current free memory: %d, previewDecodedBmLength: %d", Long.valueOf(max), Long.valueOf(j2));
            if (max < j2) {
                double sqrt = Math.sqrt(((double) max) / ((double) j2));
                Log.v("MicroMsg.ImageGalleryHolderImage", "hy: sample is %f", Double.valueOf(sqrt));
                i4 = (int) (((double) i4) * sqrt);
                i5 = (int) (((double) i5) * sqrt);
            }
            Bitmap aT = aT(str, i5, i4);
            if (aT == null) {
                aT = BitmapUtil.getBitmapNative(str, i4, i5, 0.0f);
            }
            if (aT == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                aT = MMNativeJpeg.decodeAsBitmap(str);
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(aT == null);
                Log.i("MicroMsg.ImageGalleryHolderImage", "Progressive jpeg, result isNull:%b", objArr);
            }
            e2 = aT;
        } catch (OutOfMemoryError e3) {
            Log.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", e3, "hy: out of memory! try use fallback bitmap", new Object[0]);
            Context context = MMApplicationContext.getContext();
            if (context == null) {
                i2 = 0;
            } else {
                i2 = context.getResources().getDisplayMetrics().widthPixels;
            }
            Context context2 = MMApplicationContext.getContext();
            if (context2 == null) {
                i3 = 0;
            } else {
                i3 = context2.getResources().getDisplayMetrics().heightPixels;
            }
            e2 = e(str, i4, i5, i2, i3);
        }
        if (e2 == null) {
            Log.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
            AppMethodBeat.o(36031);
            return null;
        }
        Bitmap rotate = BitmapUtil.rotate(e2, (float) exifOrientation);
        if (rotate != e2 || exifOrientation % v2helper.VOIP_ENC_HEIGHT_LV1 == 0) {
            AppMethodBeat.o(36031);
            return rotate;
        }
        Log.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", Integer.valueOf(exifOrientation));
        AppMethodBeat.o(36031);
        return null;
    }

    private static Bitmap e(String str, int i2, int i3, int i4, int i5) {
        Bitmap bitmap = null;
        AppMethodBeat.i(36032);
        Log.e("MicroMsg.ImageGalleryHolderImage", "hy: enter fallback bitmap logic");
        int i6 = i2 * i3;
        int i7 = i4 * i5;
        Log.i("MicroMsg.ImageGalleryHolderImage", "hy: oriImgPixelRate %d, displayPixelRate %d", Integer.valueOf(i6), Integer.valueOf(i7));
        if (i6 > i7) {
            try {
                bitmap = BitmapUtil.getBitmapNative(str, i4, i5, 0.0f);
                AppMethodBeat.o(36032);
            } catch (OutOfMemoryError e2) {
                Log.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", e2, "hy: oom in fallback bitmap!", new Object[0]);
                AppMethodBeat.o(36032);
            }
        } else {
            Log.e("MicroMsg.ImageGalleryHolderImage", "hy: the picture is even smaller the screen! display nothing");
            AppMethodBeat.o(36032);
        }
        return bitmap;
    }

    public static String a(ca caVar, com.tencent.mm.av.g gVar) {
        AppMethodBeat.i(36033);
        String a2 = a(caVar, gVar, false);
        AppMethodBeat.o(36033);
        return a2;
    }

    private static String e(ca caVar, com.tencent.mm.av.g gVar) {
        AppMethodBeat.i(36035);
        if (caVar == null || gVar == null) {
            AppMethodBeat.o(36035);
            return null;
        } else if (caVar.field_isSend == 1) {
            String str = gVar.iXo;
            String str2 = q.bcR().o(str, "", "") + "hd";
            Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", str, str2);
            if (Util.isNullOrNil(str2) || !s.YS(str2)) {
                String o = q.bcR().o(str, "", "");
                Log.d("MicroMsg.ImageGalleryHolderImage", "preview fileName: %s, fullPath:%s", str, o);
                if (Util.isNullOrNil(o) || !s.YS(o)) {
                    AppMethodBeat.o(36035);
                    return null;
                }
                Log.d("MicroMsg.ImageGalleryHolderImage", "preview image exist");
                AppMethodBeat.o(36035);
                return o;
            }
            Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
            AppMethodBeat.o(36035);
            return str2;
        } else if (!gVar.bcu()) {
            Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo get previewPath img not completed");
            AppMethodBeat.o(36035);
            return null;
        } else {
            String str3 = gVar.iXo;
            String str4 = q.bcR().o(str3, "", "") + "hd";
            Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", str3, str4);
            if (Util.isNullOrNil(str4) || !s.YS(str4)) {
                AppMethodBeat.o(36035);
                return null;
            }
            Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
            AppMethodBeat.o(36035);
            return str4;
        }
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, com.tencent.mm.ak.q qVar) {
        Object obj2;
        int i6;
        AppMethodBeat.i(36036);
        if (this.Pwu == null || this.Pwu.Pwv == null) {
            AppMethodBeat.o(36036);
        } else if (this.mScrollState != 0) {
            AppMethodBeat.o(36036);
        } else {
            if (l.gTf().NS(j3)) {
                int d2 = d(j3, obj);
                if (d2 == -1) {
                    AppMethodBeat.o(36036);
                    return;
                }
                obj2 = Integer.valueOf(d2);
            } else {
                obj2 = obj;
            }
            if (!(obj2 instanceof Integer)) {
                Log.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
                AppMethodBeat.o(36036);
                return;
            }
            int intValue = ((Integer) obj2).intValue();
            Log.i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", Integer.valueOf(intValue), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i2), Long.valueOf(j2));
            if (intValue == -1) {
                Log.e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
                AppMethodBeat.o(36036);
            } else if (this.Pwu.abm(intValue) == null) {
                AppMethodBeat.o(36036);
            } else {
                k kVar = (k) this.Pwu.abm(intValue).getTag();
                if (kVar == null) {
                    AppMethodBeat.o(36036);
                    return;
                }
                if (i4 == 0) {
                    i6 = 0;
                } else {
                    i6 = (int) (i5 != 0 ? ((((float) i4) / ((float) i5)) * 100.0f) - 1.0f : 0.0f);
                }
                int max = Math.max(1, i6);
                if (intValue == this.Pwu.Pwv.getCurrentItem() && amZ(i2)) {
                    Log.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", Integer.valueOf(max), Long.valueOf(System.currentTimeMillis()));
                    this.Pwu.Pwv.ani(max);
                }
                m mVar = (m) qVar;
                boolean isProgressive = MMNativeJpeg.isProgressive(mVar.iYV);
                boolean z = mVar.iYX;
                long ticksToNow = Util.ticksToNow(this.PxV);
                a.hf(mVar.iYV, i5);
                Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", Boolean.valueOf(z), Boolean.valueOf(isProgressive), Long.valueOf(ticksToNow), Integer.valueOf(i4), Integer.valueOf(i5), mVar.iYV);
                if (z && isProgressive && ticksToNow > 1000) {
                    this.PxV = Util.currentTicks();
                    ca amt = this.Pwu.amt(intValue);
                    if (amt == null) {
                        Log.e("MicroMsg.ImageGalleryHolderImage", "msg is null! pos:%s", Integer.valueOf(intValue));
                        AppMethodBeat.o(36036);
                        return;
                    }
                    com.tencent.mm.av.g i7 = i(amt, true);
                    if (a(false, kVar.PBc, q.bcR().R(amt.field_imgPath, true), a(amt, i7, true), true, -1, amt, kVar, i7, true)) {
                        k.ai(kVar.PAW, 8);
                        k.ai(kVar.PAZ, 8);
                        if (intValue == this.Pwu.Pwv.getCurrentItem() && !amZ(i2)) {
                            if (max > 50) {
                                k.ai(kVar.PAY, 8);
                                if (this.Pwu != null) {
                                    this.Pwu.a(amt, i7, i2, x.a.ok);
                                    AppMethodBeat.o(36036);
                                    return;
                                }
                            } else {
                                k.ai(kVar.PAY, 0);
                            }
                        }
                    }
                }
                AppMethodBeat.o(36036);
            }
        }
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, com.tencent.mm.ak.q qVar) {
        Object obj2;
        AppMethodBeat.i(36037);
        if (this.Pwu == null || this.Pwu.Pwv == null) {
            AppMethodBeat.o(36037);
            return;
        }
        if (l.gTf().NS(j3)) {
            int d2 = d(j3, obj);
            if (d2 == -1) {
                bg.aVF();
                a(com.tencent.mm.model.c.aSQ().Hb(j3), "background", false);
                AppMethodBeat.o(36037);
                return;
            }
            obj2 = Integer.valueOf(d2);
        } else {
            obj2 = obj;
        }
        if (!(obj2 instanceof Integer)) {
            Log.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
            AppMethodBeat.o(36037);
            return;
        }
        final int intValue = ((Integer) obj2).intValue();
        Log.i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = ".concat(String.valueOf(intValue)));
        if (intValue == -1) {
            Log.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 3, 1, true);
            AppMethodBeat.o(36037);
            return;
        }
        k kVar = null;
        if (this.Pwu.abm(intValue) != null) {
            kVar = (k) this.Pwu.abm(intValue).getTag();
        }
        boolean NS = l.gTf().NS(j3);
        if (i4 == 0 && i5 == 0) {
            if (NS) {
                a(this.Pwu.amt(intValue), "hd_suc:".concat(String.valueOf(intValue)), intValue == this.Pwu.Pwv.getCurrentItem());
            }
            Log.i("MicroMsg.ImageGalleryHolderImage", "pos = " + intValue + ", selectedPos = " + this.Pwu.Pwv.getCurrentItem(), new Object[0]);
            ap(j3, 4);
            ca amt = this.Pwu.amt(intValue);
            com.tencent.mm.av.g i6 = i(amt, true);
            if (amt == null || i6 == null) {
                AppMethodBeat.o(36037);
                return;
            }
            if (this.PxO != null) {
                this.PxO.ar(amt.field_msgId, i2);
            }
            if (kVar != null) {
                if (intValue == this.Pwu.Pwv.getCurrentItem()) {
                    if (amZ(i2)) {
                        ImageGalleryUI imageGalleryUI = this.Pwu.Pwv;
                        imageGalleryUI.gSF();
                        imageGalleryUI.gSF();
                        Animation anh = ImageGalleryUI.anh(1000);
                        anh.setAnimationListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01f2: INVOKE  
                              (r5v30 'anh' android.view.animation.Animation)
                              (wrap: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$38 : 0x01ef: CONSTRUCTOR  (r6v17 com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$38) = (r4v62 'imageGalleryUI' com.tencent.mm.ui.chatting.gallery.ImageGalleryUI) call: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.38.<init>(com.tencent.mm.ui.chatting.gallery.ImageGalleryUI):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.view.animation.Animation.setAnimationListener(android.view.animation.Animation$AnimationListener):void in method: com.tencent.mm.ui.chatting.gallery.d.a(long, long, int, int, java.lang.Object, int, int, java.lang.String, com.tencent.mm.ak.q):void, file: classes5.dex
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
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01ef: CONSTRUCTOR  (r6v17 com.tencent.mm.ui.chatting.gallery.ImageGalleryUI$38) = (r4v62 'imageGalleryUI' com.tencent.mm.ui.chatting.gallery.ImageGalleryUI) call: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.38.<init>(com.tencent.mm.ui.chatting.gallery.ImageGalleryUI):void type: CONSTRUCTOR in method: com.tencent.mm.ui.chatting.gallery.d.a(long, long, int, int, java.lang.Object, int, int, java.lang.String, com.tencent.mm.ak.q):void, file: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 52 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 58 more
                            */
                        /*
                        // Method dump skipped, instructions count: 693
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.d.a(long, long, int, int, java.lang.Object, int, int, java.lang.String, com.tencent.mm.ak.q):void");
                    }

                    private int d(long j2, Object obj) {
                        int intValue;
                        ca amt;
                        AppMethodBeat.i(36038);
                        if (!(obj instanceof Integer) || (amt = this.Pwu.amt((intValue = ((Integer) obj).intValue()))) == null || amt.field_msgId != j2) {
                            for (Integer num : this.Pwu.OUz.values()) {
                                int intValue2 = num.intValue();
                                ca amt2 = this.Pwu.amt(intValue2);
                                if (amt2 != null && amt2.field_msgId == j2) {
                                    AppMethodBeat.o(36038);
                                    return intValue2;
                                }
                            }
                            AppMethodBeat.o(36038);
                            return -1;
                        }
                        AppMethodBeat.o(36038);
                        return intValue;
                    }

                    private static void a(ca caVar, String str, boolean z) {
                        AppMethodBeat.i(36039);
                        Log.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", Long.valueOf(caVar.field_msgId), str);
                        b.c(MMApplicationContext.getContext(), caVar, z);
                        AppMethodBeat.o(36039);
                    }

                    public static boolean amZ(int i2) {
                        return i2 == 1;
                    }

                    @Override // com.tencent.mm.av.e.a
                    public final void a(long j2, long j3, int i2, int i3, Object obj) {
                        AppMethodBeat.i(36040);
                        if (!(obj instanceof Integer)) {
                            Log.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
                            AppMethodBeat.o(36040);
                            return;
                        }
                        Log.i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos ".concat(String.valueOf(((Integer) obj).intValue())), new Object[0]);
                        AppMethodBeat.o(36040);
                    }

                    public final void bH(int i2, boolean z) {
                        AppMethodBeat.i(36041);
                        Log.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = ".concat(String.valueOf(i2)));
                        ca amt = this.Pwu.amt(i2);
                        if (amt == null || amt.field_msgId == 0) {
                            Log.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
                            AppMethodBeat.o(36041);
                        } else if (!b.j(amt)) {
                            Log.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
                            AppMethodBeat.o(36041);
                        } else {
                            com.tencent.mm.av.g i3 = i(amt, true);
                            if (i3 == null || i3.localId == 0) {
                                Log.e("MicroMsg.ImageGalleryHolderImage", "viewHdImg fail, msgLocalId = " + (amt == null ? BuildConfig.COMMAND : Long.valueOf(amt.field_msgId)) + ", imgLocalId = " + (i3 == null ? BuildConfig.COMMAND : Long.valueOf(i3.localId)));
                                AppMethodBeat.o(36041);
                                return;
                            }
                            h(amt, 3);
                            if (amM(i2) != null) {
                                a(amM(i2), amt, i3, true, false, i2);
                            }
                            if (this.Pwu != null) {
                                this.Pwu.j(amt, true);
                            }
                            if (z) {
                                l gTf = l.gTf();
                                Log.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", Long.valueOf(amt.field_msgId));
                                gTf.PBm.add(Long.valueOf(amt.field_msgId));
                                q.bcS().a(i3.localId, amt.field_msgId, Integer.valueOf(i2), gTf);
                                AppMethodBeat.o(36041);
                                return;
                            }
                            q.bcS().a(i3.localId, amt.field_msgId, Integer.valueOf(i2), this);
                            AppMethodBeat.o(36041);
                        }
                    }

                    public final void cz(ca caVar) {
                        AppMethodBeat.i(36042);
                        com.tencent.mm.av.g k = k(caVar);
                        if (k == null || caVar == null) {
                            AppMethodBeat.o(36042);
                            return;
                        }
                        if (this.Pwu != null) {
                            this.Pwu.a(caVar, null, 1, x.a.cancel);
                        }
                        if (l.gTf().NS(caVar.field_msgId)) {
                            l gTf = l.gTf();
                            gTf.PBm.remove(Long.valueOf(caVar.field_msgId));
                            q.bcS().a(k.localId, caVar.field_msgId, 1, gTf);
                            q.bcS().C(k.localId, caVar.field_msgId);
                            AppMethodBeat.o(36042);
                            return;
                        }
                        q.bcS().a(k.localId, caVar.field_msgId, 1, this);
                        q.bcS().C(k.localId, caVar.field_msgId);
                        AppMethodBeat.o(36042);
                    }

                    @TargetApi(11)
                    private void a(long j2, MultiTouchImageView multiTouchImageView, String str, Bitmap bitmap) {
                        AppMethodBeat.i(233294);
                        if (this.Pwu == null || this.Pwu.Pwv == null) {
                            AppMethodBeat.o(233294);
                            return;
                        }
                        Log.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", Integer.valueOf(multiTouchImageView.hashCode()), Integer.valueOf(bitmap.hashCode()));
                        if (Build.VERSION.SDK_INT == 20) {
                            multiTouchImageView.setLayerType(1, null);
                        } else {
                            ForceGpuUtil.decideLayerType((View) multiTouchImageView.getParent(), bitmap.getWidth(), bitmap.getHeight());
                        }
                        multiTouchImageView.setEnableHorLongBmpMode(false);
                        multiTouchImageView.cN(bitmap.getWidth(), bitmap.getHeight());
                        multiTouchImageView.setImageBitmap(null);
                        multiTouchImageView.setImageBitmap(bitmap);
                        multiTouchImageView.invalidate();
                        if (this.PxO != null) {
                            this.PxO.b(j2, multiTouchImageView, str, bitmap);
                        }
                        AppMethodBeat.o(233294);
                    }

                    @Override // com.tencent.mm.ui.chatting.gallery.e.a
                    public final Bitmap ana(int i2) {
                        AppMethodBeat.i(36044);
                        if (this.Pwu == null) {
                            AppMethodBeat.o(36044);
                            return null;
                        }
                        ca amY = this.Pwu.Pww.amY(i2);
                        if (amY != null) {
                            b.EnumC2096b cr = b.cr(amY);
                            if (cr == b.EnumC2096b.video || cr == b.EnumC2096b.sight) {
                                AppMethodBeat.o(36044);
                                return null;
                            }
                            String str = this.PxS.get(amY);
                            if (str == null) {
                                str = q.bcR().R(amY.field_imgPath, true);
                                this.PxS.put(amY, str);
                            }
                            String str2 = str + "hd";
                            if (s.YS(str2)) {
                                Bitmap bmW = bmW(str2);
                                AppMethodBeat.o(36044);
                                return bmW;
                            }
                            Bitmap bmW2 = bmW(str);
                            AppMethodBeat.o(36044);
                            return bmW2;
                        }
                        AppMethodBeat.o(36044);
                        return null;
                    }

                    private boolean bmU(String str) {
                        AppMethodBeat.i(36023);
                        if (!PxT) {
                            Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not enable BigImageOpt");
                            AppMethodBeat.o(36023);
                            return false;
                        } else if (br.D(this.Pwu.gSg())) {
                            AppMethodBeat.o(36023);
                            return false;
                        } else {
                            boolean adl = com.tencent.mm.cq.b.adl(str);
                            AppMethodBeat.o(36023);
                            return adl;
                        }
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c8  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private static java.lang.String a(com.tencent.mm.storage.ca r10, com.tencent.mm.av.g r11, boolean r12) {
                        /*
                        // Method dump skipped, instructions count: 234
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.d.a(com.tencent.mm.storage.ca, com.tencent.mm.av.g, boolean):java.lang.String");
                    }

                    static /* synthetic */ void a(d dVar, String str, k kVar, int i2) {
                        AppMethodBeat.i(233295);
                        try {
                            Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo tryLoadBitmap after big image load error, imgPath: %s", str);
                            a(kVar, false, true);
                            dVar.PxQ.f(kVar.PBc, str, i2);
                            AppMethodBeat.o(233295);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", e2, "alvinluo tryLoadBitmap exception", new Object[0]);
                            AppMethodBeat.o(233295);
                        }
                    }
                }
