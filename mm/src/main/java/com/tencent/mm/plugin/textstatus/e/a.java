package com.tencent.mm.plugin.textstatus.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.b.g;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.j.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import kotlin.g.b.p;

public final class a {
    public static final a FYI = new a();

    static {
        AppMethodBeat.i(216169);
        AppMethodBeat.o(216169);
    }

    private a() {
    }

    public static final /* synthetic */ Bitmap b(Bitmap bitmap, boolean z, Context context) {
        AppMethodBeat.i(216170);
        Bitmap a2 = a(bitmap, z, context);
        AppMethodBeat.o(216170);
        return a2;
    }

    public static /* synthetic */ void a(Context context, ImageView imageView, String str, com.tencent.mm.plugin.textstatus.f.f.a aVar) {
        AppMethodBeat.i(216163);
        p.h(context, "context");
        p.h(imageView, "iv");
        p.h(str, ch.COL_USERNAME);
        p.h(aVar, "info");
        int hashCode = aVar.hashCode();
        imageView.setTag(R.id.bul, Integer.valueOf(hashCode));
        String str2 = aVar.field_MediaThumbUrl;
        if (!Util.isNullOrNil(str2)) {
            q.bcQ();
            Bitmap EP = d.EP(str2);
            if (EP == null) {
                com.tencent.mm.plugin.textstatus.j.a aVar2 = com.tencent.mm.plugin.textstatus.j.a.GfU;
                p.g(str2, "imgUrl");
                p.h(str2, "url");
                String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
                p.g(ceA, "Account.username()");
                p.h(str2, "url");
                p.h(ceA, ch.COL_USERNAME);
                StringBuilder append = new StringBuilder().append(com.tencent.mm.plugin.textstatus.j.a.fwF()).append("history/");
                byte[] bytes = ceA.getBytes(kotlin.n.d.UTF_8);
                p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                String sb = append.append(g.getMessageDigest(bytes)).toString();
                if (!s.YS(sb)) {
                    s.boN(sb);
                }
                StringBuilder append2 = new StringBuilder().append(sb).append(FilePathGenerator.ANDROID_DIR_SEP);
                byte[] bytes2 = str2.getBytes(kotlin.n.d.UTF_8);
                p.g(bytes2, "(this as java.lang.String).getBytes(charset)");
                String sb2 = append2.append(g.getMessageDigest(bytes2)).toString();
                if (s.YS(sb2)) {
                    Bitmap decodeFileWithSample = BitmapUtil.decodeFileWithSample(sb2);
                    imageView.setImageBitmap(a(decodeFileWithSample, aVar.fvV(), context));
                    q.bcQ();
                    d.g(str2, decodeFileWithSample);
                    AppMethodBeat.o(216163);
                    return;
                }
                e eVar = e.Ggj;
                imageView.setImageResource(e.aTr(aVar.field_backgroundId));
                q.bcU().a(str2, new C1818a(sb2, aVar, str2, imageView, hashCode, context));
                AppMethodBeat.o(216163);
                return;
            }
            imageView.setImageBitmap(a(EP, aVar.fvV(), context));
            AppMethodBeat.o(216163);
            return;
        }
        e eVar2 = e.Ggj;
        imageView.setImageResource(e.aTr(aVar.field_backgroundId));
        AppMethodBeat.o(216163);
    }

    /* renamed from: com.tencent.mm.plugin.textstatus.e.a$a */
    public static final class C1818a implements r.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.tencent.mm.plugin.textstatus.f.f.a FYF;
        final /* synthetic */ ImageView FYJ;
        final /* synthetic */ int FYK;
        final /* synthetic */ String Vdx;
        final /* synthetic */ String msC;

        C1818a(String str, com.tencent.mm.plugin.textstatus.f.f.a aVar, String str2, ImageView imageView, int i2, Context context) {
            this.msC = str;
            this.FYF = aVar;
            this.Vdx = str2;
            this.FYJ = imageView;
            this.FYK = i2;
            this.$context = context;
        }

        @Override // com.tencent.mm.av.r.a
        public final void a(String str, final Bitmap bitmap, String str2) {
            AppMethodBeat.i(216160);
            h.RTc.aX(new Runnable(this) {
                /* class com.tencent.mm.plugin.textstatus.e.a.C1818a.AnonymousClass1 */
                final /* synthetic */ C1818a FYL;

                {
                    this.FYL = r1;
                }

                public final void run() {
                    AppMethodBeat.i(216159);
                    Log.i("MicroMsg.TxtStatus.StatusImgHandler", "handleImgOnlyByUrl update " + this.FYL.msC + ' ' + this.FYL.FYF.field_StatusID);
                    a aVar = a.FYI;
                    Bitmap bitmap = bitmap;
                    p.g(bitmap, "bitmap");
                    a.j(bitmap, this.FYL.msC);
                    final Bitmap decodeFileWithSample = BitmapUtil.decodeFileWithSample(this.FYL.msC);
                    q.bcQ();
                    d.g(this.FYL.Vdx, decodeFileWithSample);
                    h.RTc.aV(new Runnable(this) {
                        /* class com.tencent.mm.plugin.textstatus.e.a.C1818a.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 Vdy;

                        {
                            this.Vdy = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(258392);
                            this.Vdy.FYL.FYJ.post(new Runnable(this) {
                                /* class com.tencent.mm.plugin.textstatus.e.a.C1818a.AnonymousClass1.AnonymousClass1.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass1 VdA;

                                {
                                    this.VdA = r1;
                                }

                                public final void run() {
                                    AppMethodBeat.i(258391);
                                    if (!p.j(this.VdA.Vdy.FYL.FYJ.getTag(R.id.bul), Integer.valueOf(this.VdA.Vdy.FYL.FYK))) {
                                        AppMethodBeat.o(258391);
                                        return;
                                    }
                                    ImageView imageView = this.VdA.Vdy.FYL.FYJ;
                                    a aVar = a.FYI;
                                    imageView.setImageBitmap(a.b(decodeFileWithSample, this.VdA.Vdy.FYL.FYF.fvV(), this.VdA.Vdy.FYL.$context));
                                    AppMethodBeat.o(258391);
                                }
                            });
                            AppMethodBeat.o(258392);
                        }
                    });
                    AppMethodBeat.o(216159);
                }
            });
            AppMethodBeat.o(216160);
        }
    }

    public static /* synthetic */ void a(a aVar, Context context, String str, ImageView imageView) {
        AppMethodBeat.i(216165);
        a(context, str, imageView, true);
        AppMethodBeat.o(216165);
    }

    public static void a(Context context, String str, ImageView imageView, boolean z) {
        AppMethodBeat.i(216164);
        p.h(context, "context");
        p.h(str, ch.COL_USERNAME);
        p.h(imageView, "iv");
        f fVar = f.FXJ;
        com.tencent.mm.plugin.textstatus.f.f.a aTf = f.aTf(str);
        if (aTf == null) {
            AppMethodBeat.o(216164);
            return;
        }
        p.h(context, "context");
        p.h(imageView, "iv");
        p.h(str, ch.COL_USERNAME);
        p.h(aTf, "info");
        int hashCode = aTf.hashCode();
        imageView.setTag(R.id.bul, Integer.valueOf(hashCode));
        String str2 = z ? aTf.field_MediaThumbUrl : aTf.field_MediaUrl;
        if (!Util.isNullOrNil(str2)) {
            q.bcQ();
            Bitmap EP = d.EP(str2);
            if (EP == null) {
                com.tencent.mm.plugin.textstatus.j.a aVar = com.tencent.mm.plugin.textstatus.j.a.GfU;
                String lf = com.tencent.mm.plugin.textstatus.j.a.lf(z ? "thumb" : "image", str);
                if (s.YS(lf)) {
                    Bitmap decodeFileWithSample = BitmapUtil.decodeFileWithSample(lf);
                    imageView.setImageBitmap(a(decodeFileWithSample, aTf.fvV(), context));
                    q.bcQ();
                    d.g(str2, decodeFileWithSample);
                    AppMethodBeat.o(216164);
                    return;
                }
                e eVar = e.Ggj;
                imageView.setImageResource(e.aTr(aTf.field_backgroundId));
                q.bcU().a(str2, new b(aTf.field_StatusID, lf, str, str2, imageView, hashCode, aTf, context));
                AppMethodBeat.o(216164);
                return;
            }
            imageView.setImageBitmap(a(EP, aTf.fvV(), context));
            AppMethodBeat.o(216164);
        } else if (!Util.isNullOrNil(aTf.field_backgroundId)) {
            e eVar2 = e.Ggj;
            imageView.setImageResource(e.aTr(aTf.field_backgroundId));
            AppMethodBeat.o(216164);
        } else {
            com.tencent.mm.plugin.textstatus.j.a aVar2 = com.tencent.mm.plugin.textstatus.j.a.GfU;
            String lf2 = com.tencent.mm.plugin.textstatus.j.a.lf(z ? "thumb" : "image", str);
            if (s.YS(lf2)) {
                imageView.setImageBitmap(a(BitmapUtil.decodeFileWithSample(lf2), aTf.fvV(), context));
                AppMethodBeat.o(216164);
                return;
            }
            e eVar3 = e.Ggj;
            imageView.setImageResource(e.aTr(aTf.field_backgroundId));
            AppMethodBeat.o(216164);
        }
    }

    public static final class b implements r.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.tencent.mm.plugin.textstatus.f.f.a FYF;
        final /* synthetic */ ImageView FYJ;
        final /* synthetic */ int FYK;
        final /* synthetic */ String Gdu;
        final /* synthetic */ String Vdx;
        final /* synthetic */ String hLl;
        final /* synthetic */ String msC;

        b(String str, String str2, String str3, String str4, ImageView imageView, int i2, com.tencent.mm.plugin.textstatus.f.f.a aVar, Context context) {
            this.Gdu = str;
            this.msC = str2;
            this.hLl = str3;
            this.Vdx = str4;
            this.FYJ = imageView;
            this.FYK = i2;
            this.FYF = aVar;
            this.$context = context;
        }

        @Override // com.tencent.mm.av.r.a
        public final void a(String str, final Bitmap bitmap, String str2) {
            AppMethodBeat.i(216162);
            h.RTc.aX(new Runnable(this) {
                /* class com.tencent.mm.plugin.textstatus.e.a.b.AnonymousClass1 */
                final /* synthetic */ b FYM;

                {
                    this.FYM = r1;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:5:0x007a, code lost:
                    if (r0 == null) goto L_0x007c;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 166
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.textstatus.e.a.b.AnonymousClass1.run():void");
                }

                /* access modifiers changed from: package-private */
                /* renamed from: com.tencent.mm.plugin.textstatus.e.a$b$1$a */
                public static final class RunnableC1819a implements Runnable {
                    final /* synthetic */ AnonymousClass1 VdB;
                    final /* synthetic */ Bitmap Vdz;

                    RunnableC1819a(Bitmap bitmap, AnonymousClass1 r2) {
                        this.Vdz = bitmap;
                        this.VdB = r2;
                    }

                    public final void run() {
                        AppMethodBeat.i(258394);
                        this.VdB.FYM.FYJ.post(new Runnable(this) {
                            /* class com.tencent.mm.plugin.textstatus.e.a.b.AnonymousClass1.RunnableC1819a.AnonymousClass1 */
                            final /* synthetic */ RunnableC1819a VdC;

                            {
                                this.VdC = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(258393);
                                if (!p.j(this.VdC.VdB.FYM.FYJ.getTag(R.id.bul), Integer.valueOf(this.VdC.VdB.FYM.FYK))) {
                                    AppMethodBeat.o(258393);
                                    return;
                                }
                                a aVar = a.FYI;
                                this.VdC.VdB.FYM.FYJ.setImageBitmap(a.b(this.VdC.Vdz, this.VdC.VdB.FYM.FYF.fvV(), this.VdC.VdB.FYM.$context));
                                AppMethodBeat.o(258393);
                            }
                        });
                        AppMethodBeat.o(258394);
                    }
                }
            });
            AppMethodBeat.o(216162);
        }
    }

    public static void c(String str, com.tencent.mm.plugin.textstatus.f.f.a aVar) {
        AppMethodBeat.i(258397);
        p.h(str, ch.COL_USERNAME);
        p.h(aVar, "info");
        String str2 = aVar.field_MediaType == 2 ? aVar.field_MediaThumbUrl : aVar.field_MediaUrl;
        if (!Util.isNullOrNil(str2)) {
            q.bcQ();
            if (d.EP(str2) == null) {
                com.tencent.mm.plugin.textstatus.j.a aVar2 = com.tencent.mm.plugin.textstatus.j.a.GfU;
                String lf = com.tencent.mm.plugin.textstatus.j.a.lf(aVar.field_MediaType == 2 ? "thumb" : "image", str);
                if (!s.YS(lf)) {
                    String str3 = aVar.field_StatusID;
                    Log.i("MicroMsg.TxtStatus.StatusImgHandler", "triggerDownloadThumb start " + lf + ' ' + str3);
                    q.bcU().a(str2, new c(str3, lf, str, str2));
                }
            }
        }
        AppMethodBeat.o(258397);
    }

    public static final class c implements r.a {
        final /* synthetic */ String Gdu;
        final /* synthetic */ String Vdx;
        final /* synthetic */ String hLl;
        final /* synthetic */ String msC;

        c(String str, String str2, String str3, String str4) {
            this.Gdu = str;
            this.msC = str2;
            this.hLl = str3;
            this.Vdx = str4;
        }

        @Override // com.tencent.mm.av.r.a
        public final void a(String str, final Bitmap bitmap, String str2) {
            AppMethodBeat.i(258396);
            h.RTc.aX(new Runnable(this) {
                /* class com.tencent.mm.plugin.textstatus.e.a.c.AnonymousClass1 */
                final /* synthetic */ c VdD;

                {
                    this.VdD = r1;
                }

                public final void run() {
                    AppMethodBeat.i(258395);
                    Log.i("MicroMsg.TxtStatus.StatusImgHandler", "triggerDownloadThumb update " + this.VdD.Gdu + ' ' + this.VdD.msC);
                    f fVar = f.FXJ;
                    com.tencent.mm.plugin.textstatus.f.f.a aTl = f.fvM().aTl(this.VdD.hLl);
                    if (aTl == null) {
                        Log.e("MicroMsg.TxtStatus.StatusImgHandler", "triggerDownloadThumb TextStatus is null");
                        AppMethodBeat.o(258395);
                    } else if (Util.isEqual(this.VdD.Gdu, aTl.field_StatusID)) {
                        Log.i("MicroMsg.TxtStatus.StatusImgHandler", "triggerDownloadThumb update " + this.VdD.msC + ' ' + this.VdD.Gdu);
                        a aVar = a.FYI;
                        Bitmap bitmap = bitmap;
                        p.g(bitmap, "bitmap");
                        a.j(bitmap, this.VdD.msC);
                        Bitmap decodeFileWithSample = BitmapUtil.decodeFileWithSample(this.VdD.msC);
                        q.bcQ();
                        d.g(this.VdD.Vdx, decodeFileWithSample);
                        AppMethodBeat.o(258395);
                    } else {
                        Log.e("MicroMsg.TxtStatus.StatusImgHandler", "triggerDownloadThumb getLatest:" + aTl.field_StatusID);
                        AppMethodBeat.o(258395);
                    }
                }
            });
            AppMethodBeat.o(258396);
        }
    }

    private static Bitmap a(Bitmap bitmap, boolean z, Context context) {
        AppMethodBeat.i(216168);
        if (bitmap == null || !z) {
            AppMethodBeat.o(216168);
            return bitmap;
        }
        com.tencent.mm.plugin.textstatus.j.f fVar = com.tencent.mm.plugin.textstatus.j.f.Ggk;
        Bitmap a2 = com.tencent.mm.plugin.textstatus.j.f.a(bitmap, context, 10.0f);
        AppMethodBeat.o(216168);
        return a2;
    }

    public static final /* synthetic */ void j(Bitmap bitmap, String str) {
        AppMethodBeat.i(258398);
        try {
            BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, str, false);
            AppMethodBeat.o(258398);
        } catch (IOException e2) {
            Log.e("MicroMsg.TxtStatus.StatusImgHandler", "save bitmap to image failed: ".concat(String.valueOf(e2)));
            AppMethodBeat.o(258398);
        }
    }
}
