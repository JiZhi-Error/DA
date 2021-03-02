package com.tencent.mm.plugin.festival.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.model.m;
import com.tencent.mm.plugin.festival.model.z;
import com.tencent.mm.plugin.festival.ui.StarryNight;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Future;
import kotlin.a.ab;
import kotlin.a.j;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.k.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "canvas", "Lcom/tencent/mm/plugin/festival/ui/StarryNight;", "getCanvas", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight;", "getContext", "()Landroid/content/Context;", "decoder", "Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$CanvasDataDecodeLogic;", "value", "Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$OnDataReady;", "onCanvasDataReadyListener", "getOnCanvasDataReadyListener", "()Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$OnDataReady;", "setOnCanvasDataReadyListener", "(Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$OnDataReady;)V", "mount", "", "pause", "resume", "unmount", "BitmapAndPixel", "CanvasDataDecodeLogic", "Companion", "OnDataReady", "plugin-festival_release"})
public final class c {
    public static final C1078c UBr = new C1078c((byte) 0);
    private final b UBo = new b();
    public d UBp;
    public final StarryNight UBq;
    private final Context context;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$OnDataReady;", "", "onReady", "", "plugin-festival_release"})
    public interface d {
        void onReady();
    }

    static {
        AppMethodBeat.i(263205);
        AppMethodBeat.o(263205);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    /* renamed from: com.tencent.mm.plugin.festival.ui.c$c  reason: collision with other inner class name */
    public static final class C1078c {
        private C1078c() {
        }

        public /* synthetic */ C1078c(byte b2) {
            this();
        }
    }

    public c(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(263204);
        this.context = context2;
        StarryNight starryNight = new StarryNight(this.context);
        starryNight.setLogger(new e());
        ArrayList arrayList = new ArrayList();
        f fVar = new f(0, 35);
        ArrayList arrayList2 = new ArrayList(j.a(fVar, 10));
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            int nextInt = ((ab) it).nextInt();
            ae aeVar = ae.SYK;
            String format = String.format("festival2021/fest_meteor/meteor1/%05d.png", Arrays.copyOf(new Object[]{Integer.valueOf(nextInt)}, 1));
            p.g(format, "java.lang.String.format(format, *args)");
            arrayList2.add(BitmapFactory.decodeStream(this.context.getAssets().open(format)));
        }
        arrayList.add(arrayList2);
        f fVar2 = new f(0, 35);
        ArrayList arrayList3 = new ArrayList(j.a(fVar2, 10));
        Iterator it2 = fVar2.iterator();
        while (it2.hasNext()) {
            int nextInt2 = ((ab) it2).nextInt();
            ae aeVar2 = ae.SYK;
            String format2 = String.format("festival2021/fest_meteor/meteor2/%05d.png", Arrays.copyOf(new Object[]{Integer.valueOf(nextInt2)}, 1));
            p.g(format2, "java.lang.String.format(format, *args)");
            arrayList3.add(BitmapFactory.decodeStream(this.context.getAssets().open(format2)));
        }
        arrayList.add(arrayList3);
        f fVar3 = new f(0, 35);
        ArrayList arrayList4 = new ArrayList(j.a(fVar3, 10));
        Iterator it3 = fVar3.iterator();
        while (it3.hasNext()) {
            int nextInt3 = ((ab) it3).nextInt();
            ae aeVar3 = ae.SYK;
            String format3 = String.format("festival2021/fest_meteor/meteor3/%05d.png", Arrays.copyOf(new Object[]{Integer.valueOf(nextInt3)}, 1));
            p.g(format3, "java.lang.String.format(format, *args)");
            arrayList4.add(BitmapFactory.decodeStream(this.context.getAssets().open(format3)));
        }
        arrayList.add(arrayList4);
        f fVar4 = new f(0, 35);
        ArrayList arrayList5 = new ArrayList(j.a(fVar4, 10));
        Iterator it4 = fVar4.iterator();
        while (it4.hasNext()) {
            int nextInt4 = ((ab) it4).nextInt();
            ae aeVar4 = ae.SYK;
            String format4 = String.format("festival2021/fest_meteor/meteor4/%05d.png", Arrays.copyOf(new Object[]{Integer.valueOf(nextInt4)}, 1));
            p.g(format4, "java.lang.String.format(format, *args)");
            arrayList5.add(BitmapFactory.decodeStream(this.context.getAssets().open(format4)));
        }
        arrayList.add(arrayList5);
        starryNight.setMeteorBitmap(arrayList);
        f fVar5 = new f(0, 47);
        ArrayList arrayList6 = new ArrayList(j.a(fVar5, 10));
        Iterator it5 = fVar5.iterator();
        while (it5.hasNext()) {
            int nextInt5 = ((ab) it5).nextInt();
            ae aeVar5 = ae.SYK;
            String format5 = String.format("festival2021/fest_flash_star/flash_star_%05d.png", Arrays.copyOf(new Object[]{Integer.valueOf(nextInt5)}, 1));
            p.g(format5, "java.lang.String.format(format, *args)");
            arrayList6.add(BitmapFactory.decodeStream(this.context.getAssets().open(format5)));
        }
        starryNight.setFlashStarBitmap(arrayList6);
        f fVar6 = new f(0, 30);
        ArrayList arrayList7 = new ArrayList(j.a(fVar6, 10));
        Iterator it6 = fVar6.iterator();
        while (it6.hasNext()) {
            int nextInt6 = ((ab) it6).nextInt();
            ae aeVar6 = ae.SYK;
            Locale locale = Locale.ENGLISH;
            p.g(locale, "Locale.ENGLISH");
            String format6 = String.format(locale, "festival2021/click_ripple/click_effect_@2x_%05d.png", Arrays.copyOf(new Object[]{Integer.valueOf(nextInt6)}, 1));
            p.g(format6, "java.lang.String.format(locale, format, *args)");
            arrayList7.add(BitmapFactory.decodeStream(this.context.getAssets().open(format6)));
        }
        starryNight.setRippleBitmap(arrayList7);
        starryNight.setSmoothUpdateStarBitmapIntervalMs(((long) z.Uzb.hRC().UAG) * 1000);
        this.UBq = starryNight;
        AppMethodBeat.o(263204);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$canvas$1$1", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$Logger;", "e", "", "tag", "", "log", "i", "plugin-festival_release"})
    public static final class e implements StarryNight.g {
        e() {
        }

        @Override // com.tencent.mm.plugin.festival.ui.StarryNight.g
        public final void i(String str, String str2) {
            AppMethodBeat.i(263200);
            p.h(str, "tag");
            p.h(str2, "log");
            Log.i(str, str2);
            AppMethodBeat.o(263200);
        }

        @Override // com.tencent.mm.plugin.festival.ui.StarryNight.g
        public final void e(String str, String str2) {
            AppMethodBeat.i(263201);
            p.h(str, "tag");
            p.h(str2, "log");
            Log.e(str, str2);
            AppMethodBeat.o(263201);
        }
    }

    public final void resume() {
        AppMethodBeat.i(263202);
        this.UBq.setSmoothUpdateStarBitmapIntervalMs(((long) z.Uzb.hRC().UAG) * 1000);
        this.UBo.resume();
        this.UBq.onResume();
        AppMethodBeat.o(263202);
    }

    public final void pause() {
        AppMethodBeat.i(263203);
        this.UBq.onPause();
        this.UBo.pause();
        AppMethodBeat.o(263203);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$BitmapAndPixel;", "", "bitmap", "Landroid/graphics/Bitmap;", "pixels", "", "(Landroid/graphics/Bitmap;[I)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getPixels", "()[I", "recycle", "", "plugin-festival_release"})
    public static final class a {
        final Bitmap bitmap;
        final int[] pixels;

        public a(Bitmap bitmap2, int[] iArr) {
            p.h(bitmap2, "bitmap");
            p.h(iArr, "pixels");
            AppMethodBeat.i(263188);
            this.bitmap = bitmap2;
            this.pixels = iArr;
            AppMethodBeat.o(263188);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0003J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0003J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0007J\b\u0010\u0019\u001a\u00020\u0010H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\f\u0018\u00010\nR\u00060\u0000R\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$CanvasDataDecodeLogic;", "Lcom/tencent/mm/plugin/festival/model/FestivalLiveCanvasDataProviderContract$OnCanvasDataUpdateListener;", "(Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic;)V", "currentFile", "Lcom/tencent/mm/vfs/VFSFile;", "getCurrentFile", "()Lcom/tencent/mm/vfs/VFSFile;", "setCurrentFile", "(Lcom/tencent/mm/vfs/VFSFile;)V", "decodingTask", "Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$CanvasDataDecodeLogic$DecodeTask;", "Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic;", "isMount", "", "renderReady", "decode", "", "file", "notifyFail", "notifyReady", "bitmap", "Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$BitmapAndPixel;", "onCanvasDataUpdated", "vfsFile", "pause", "resume", "DecodeTask", "plugin-festival_release"})
    public final class b implements m.a {
        boolean UBs;
        a UBt;
        boolean UBu;
        o UBv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        public final void resume() {
            AppMethodBeat.i(263196);
            Log.i("MicroMsg.FestivalCanvas", "CanvasDataDecodeLogic, mount");
            if (this.UBs) {
                Log.i("MicroMsg.FestivalCanvas", "logic is mounted");
                AppMethodBeat.o(263196);
                return;
            }
            this.UBs = true;
            com.tencent.mm.plugin.festival.model.l lVar = com.tencent.mm.plugin.festival.model.l.Uyp;
            com.tencent.mm.plugin.festival.model.l.a(this);
            com.tencent.mm.plugin.festival.model.l lVar2 = com.tencent.mm.plugin.festival.model.l.Uyp;
            o gXc = com.tencent.mm.plugin.festival.model.l.gXc();
            if (gXc == null) {
                Log.i("MicroMsg.FestivalCanvas", "FestivalLiveCanvasDataProvider.getLatestCanvasData() null");
                Log.i("MicroMsg.FestivalCanvas", "CanvasDataDecodeLogic, notifyFail");
                AppMethodBeat.o(263196);
                return;
            }
            Log.i("MicroMsg.FestivalCanvas", "CanvasDataDecodeLogic, decoding latest");
            this.UBv = gXc;
            ar(gXc);
            AppMethodBeat.o(263196);
        }

        public final void pause() {
            AppMethodBeat.i(263197);
            Log.i("MicroMsg.FestivalCanvas", "CanvasDataDecodeLogic, unmount");
            this.UBs = false;
            a aVar = this.UBt;
            if (aVar != null) {
                aVar.cancel();
            }
            this.UBt = null;
            com.tencent.mm.plugin.festival.model.l lVar = com.tencent.mm.plugin.festival.model.l.Uyp;
            com.tencent.mm.plugin.festival.model.l.b(this);
            AppMethodBeat.o(263197);
        }

        @Override // com.tencent.mm.plugin.festival.model.m.a
        public final void aq(o oVar) {
            AppMethodBeat.i(263198);
            p.h(oVar, "vfsFile");
            Log.i("MicroMsg.FestivalCanvas", "dl: CanvasDataDecodeLogic, decoding onCanvasDataUpdated");
            h.RTc.aV(new RunnableC1077c(this, oVar));
            AppMethodBeat.o(263198);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.festival.ui.c$b$c  reason: collision with other inner class name */
        static final class RunnableC1077c implements Runnable {
            final /* synthetic */ o UBB;
            final /* synthetic */ b UBx;

            RunnableC1077c(b bVar, o oVar) {
                this.UBx = bVar;
                this.UBB = oVar;
            }

            public final void run() {
                AppMethodBeat.i(263195);
                if (p.j(this.UBx.UBv, this.UBB)) {
                    Log.d("MicroMsg.FestivalCanvas", "dl: onCanvasDataUpdated skip duplicated for " + this.UBB + " & " + this.UBx.UBv);
                    AppMethodBeat.o(263195);
                    return;
                }
                this.UBx.UBv = this.UBB;
                this.UBx.ar(this.UBB);
                AppMethodBeat.o(263195);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.festival.ui.c$b$b  reason: collision with other inner class name */
        public static final class RunnableC1076b implements Runnable {
            final /* synthetic */ o UBA;
            final /* synthetic */ b UBx;

            RunnableC1076b(b bVar, o oVar) {
                this.UBx = bVar;
                this.UBA = oVar;
            }

            public final void run() {
                a aVar;
                AppMethodBeat.i(263194);
                if (!this.UBx.UBs) {
                    AppMethodBeat.o(263194);
                    return;
                }
                if (!(this.UBx.UBt == null || (aVar = this.UBx.UBt) == null)) {
                    aVar.cancel();
                }
                a aVar2 = new a(this.UBx, this.UBA);
                this.UBx.UBt = aVar2;
                aVar2.dBz = h.RTc.aY(aVar2);
                AppMethodBeat.o(263194);
            }
        }

        /* access modifiers changed from: package-private */
        public final void ar(o oVar) {
            AppMethodBeat.i(263199);
            h.RTc.aV(new RunnableC1076b(this, oVar));
            AppMethodBeat.o(263199);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$CanvasDataDecodeLogic$DecodeTask;", "Ljava/lang/Runnable;", "file", "Lcom/tencent/mm/vfs/VFSFile;", "(Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$CanvasDataDecodeLogic;Lcom/tencent/mm/vfs/VFSFile;)V", "getFile", "()Lcom/tencent/mm/vfs/VFSFile;", "future", "Ljava/util/concurrent/Future;", "getFuture", "()Ljava/util/concurrent/Future;", "setFuture", "(Ljava/util/concurrent/Future;)V", "cancel", "", "process", "Lcom/tencent/mm/plugin/festival/ui/FestivalCanvasViewLogic$BitmapAndPixel;", "run", "plugin-festival_release"})
        public final class a implements Runnable {
            final /* synthetic */ b UBx;
            Future<?> dBz;
            final o file;

            public a(b bVar, o oVar) {
                p.h(oVar, "file");
                this.UBx = bVar;
                AppMethodBeat.i(263193);
                this.file = oVar;
                AppMethodBeat.o(263193);
            }

            public final void cancel() {
                AppMethodBeat.i(263191);
                Future<?> future = this.dBz;
                if (future != null) {
                    future.cancel(true);
                    AppMethodBeat.o(263191);
                    return;
                }
                AppMethodBeat.o(263191);
            }

            public final void run() {
                a aVar;
                AppMethodBeat.i(263192);
                Log.i("MicroMsg.FestivalCanvas", "CanvasDataDecodeLogic, processing");
                o oVar = this.file;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inMutable = true;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap decodeFile = BitmapFactory.decodeFile(oVar.getAbsolutePath(), options);
                if (decodeFile == null) {
                    aVar = null;
                } else {
                    int[] iArr = new int[(decodeFile.getWidth() * decodeFile.getHeight())];
                    decodeFile.getPixels(iArr, 0, decodeFile.getWidth(), 0, 0, decodeFile.getWidth(), decodeFile.getHeight());
                    StarryNight.b bVar = StarryNight.UDl;
                    StarryNight.b.i(iArr, decodeFile.getWidth(), decodeFile.getHeight());
                    decodeFile.setPixels(iArr, 0, decodeFile.getWidth(), 0, 0, decodeFile.getWidth(), decodeFile.getHeight());
                    aVar = new a(decodeFile, iArr);
                }
                if (aVar == null) {
                    h.RTc.aV(new RunnableC1074a(this));
                    AppMethodBeat.o(263192);
                    return;
                }
                h.RTc.aV(new RunnableC1075b(this, aVar));
                AppMethodBeat.o(263192);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.festival.ui.c$b$a$b  reason: collision with other inner class name */
            static final class RunnableC1075b implements Runnable {
                final /* synthetic */ a UBy;
                final /* synthetic */ a UBz;

                RunnableC1075b(a aVar, a aVar2) {
                    this.UBy = aVar;
                    this.UBz = aVar2;
                }

                public final void run() {
                    o oVar;
                    ValueAnimator valueAnimator;
                    StarryNight.s sVar;
                    ValueAnimator valueAnimator2;
                    d dVar;
                    StarryNight.s sVar2;
                    ValueAnimator valueAnimator3;
                    boolean z = false;
                    AppMethodBeat.i(263190);
                    b bVar = this.UBy.UBx;
                    o oVar2 = this.UBy.file;
                    a aVar = this.UBz;
                    if (bVar.UBt != null) {
                        a aVar2 = bVar.UBt;
                        if (aVar2 != null) {
                            oVar = aVar2.file;
                        } else {
                            oVar = null;
                        }
                        if (!(!p.j(oVar, oVar2))) {
                            Log.i("MicroMsg.FestivalCanvas", "CanvasDataDecodeLogic, notifyReady");
                            long currentTimeMillis = System.currentTimeMillis();
                            Log.i("MicroMsg.FestivalCanvas", "dlUIThread 1");
                            if (!bVar.UBu) {
                                StarryNight starryNight = c.this.UBq;
                                int[] iArr = aVar.pixels;
                                int width = aVar.bitmap.getWidth();
                                int height = aVar.bitmap.getHeight();
                                p.h(iArr, "pixels");
                                StarryNight.g gVar = starryNight.UCc;
                                if (gVar != null) {
                                    gVar.i("StarryNight", "updateStarBitmap2");
                                }
                                if (width != starryNight.srcWidth || height != starryNight.srcHeight) {
                                    StarryNight.g gVar2 = starryNight.UCc;
                                    if (gVar2 != null) {
                                        gVar2.i("StarryNight", "updateStarBitmap2: fail1: width not match");
                                    }
                                } else if (iArr.length != width * height) {
                                    StarryNight.g gVar3 = starryNight.UCc;
                                    if (gVar3 != null) {
                                        gVar3.i("StarryNight", "updateStarBitmap2: fail2: pixel size not match");
                                    }
                                } else {
                                    if (!(starryNight.UCS == null || (sVar2 = starryNight.UCS) == null || (valueAnimator3 = sVar2.animator) == null)) {
                                        valueAnimator3.cancel();
                                    }
                                    starryNight.UCy.setPixels(iArr, 0, width, 0, 0, width, height);
                                    StarryNight.g gVar4 = starryNight.UCc;
                                    if (gVar4 != null) {
                                        gVar4.i("StarryNight", "updateStarBitmap2: done");
                                    }
                                }
                                bVar.UBu = true;
                                z = true;
                            } else {
                                StarryNight starryNight2 = c.this.UBq;
                                int[] iArr2 = aVar.pixels;
                                int width2 = aVar.bitmap.getWidth();
                                int height2 = aVar.bitmap.getHeight();
                                p.h(iArr2, "pixels");
                                StarryNight.g gVar5 = starryNight2.UCc;
                                if (gVar5 != null) {
                                    gVar5.i("StarryNight", "smoothUpdateStarBitmap2");
                                }
                                if (width2 == starryNight2.srcWidth && height2 == starryNight2.srcHeight) {
                                    if (!(starryNight2.UCS == null || (sVar = starryNight2.UCS) == null || (valueAnimator2 = sVar.animator) == null)) {
                                        valueAnimator2.cancel();
                                    }
                                    starryNight2.UCS = new StarryNight.s(starryNight2, iArr2, width2, height2, (byte) 0);
                                    StarryNight.s sVar3 = starryNight2.UCS;
                                    if (!(sVar3 == null || (valueAnimator = sVar3.animator) == null)) {
                                        valueAnimator.start();
                                    }
                                    StarryNight.g gVar6 = starryNight2.UCc;
                                    if (gVar6 != null) {
                                        gVar6.i("StarryNight", "smoothUpdateStarBitmap, start");
                                    }
                                } else {
                                    StarryNight.g gVar7 = starryNight2.UCc;
                                    if (gVar7 != null) {
                                        gVar7.i("StarryNight", "smoothUpdateStarBitmap, pixel size not match");
                                    }
                                }
                            }
                            Log.i("MicroMsg.FestivalCanvas", "dlUIThread 2");
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 16) {
                                Log.i("MicroMsg.FestivalCanvas", "dlUIThread kkkkkkk ".concat(String.valueOf(currentTimeMillis2)));
                            }
                            aVar.bitmap.recycle();
                            if (!z || (dVar = c.this.UBp) == null) {
                                AppMethodBeat.o(263190);
                                return;
                            }
                            dVar.onReady();
                            AppMethodBeat.o(263190);
                            return;
                        }
                    }
                    Log.i("MicroMsg.FestivalCanvas", "CanvasDataDecodeLogic, notifyReady, but miss");
                    aVar.bitmap.recycle();
                    AppMethodBeat.o(263190);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.festival.ui.c$b$a$a  reason: collision with other inner class name */
            static final class RunnableC1074a implements Runnable {
                final /* synthetic */ a UBy;

                RunnableC1074a(a aVar) {
                    this.UBy = aVar;
                }

                public final void run() {
                    AppMethodBeat.i(263189);
                    Log.i("MicroMsg.FestivalCanvas", "CanvasDataDecodeLogic, notifyFail");
                    AppMethodBeat.o(263189);
                }
            }
        }
    }
}
