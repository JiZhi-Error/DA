package com.tencent.mm.plugin.festival.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 M2\u00020\u0001:\u0003LMNB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ \u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u00162\u0006\u0010?\u001a\u000204H\u0002J\u0006\u0010@\u001a\u00020 J\u000e\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DJ\u0010\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020\tH\u0002J\u000e\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020IJ\u000e\u0010J\u001a\u00020B2\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0011H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020201X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/ParticleSystemLogic;", "", "viewGroup", "Landroid/view/ViewGroup;", "starry", "Lcom/tencent/mm/plugin/festival/ui/StarryNight;", "effect", "Lcom/tencent/mm/plugin/festival/ui/FestivalEffect;", "particle1", "", "particle2", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/festival/ui/StarryNight;Lcom/tencent/mm/plugin/festival/ui/FestivalEffect;Ljava/lang/String;Ljava/lang/String;)V", "accelerateInterpolator", "Landroid/view/animation/Interpolator;", "callFairyWandDisappearEndRunnable", "Ljava/lang/Runnable;", "colorPalette", "", "Landroid/graphics/ColorFilter;", "colorPalettePack", "Landroid/graphics/PorterDuffColorFilter;", "colorStride", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "disappearRunnable", "getEffect", "()Lcom/tencent/mm/plugin/festival/ui/FestivalEffect;", "setEffect", "(Lcom/tencent/mm/plugin/festival/ui/FestivalEffect;)V", "enable", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/festival/ui/FairyWandListener;", "getListener", "()Lcom/tencent/mm/plugin/festival/ui/FairyWandListener;", "setListener", "(Lcom/tencent/mm/plugin/festival/ui/FairyWandListener;)V", "logger", "Lcom/tencent/mm/plugin/festival/ui/ParticleSystemLogic$Logger;", "getLogger", "()Lcom/tencent/mm/plugin/festival/ui/ParticleSystemLogic$Logger;", "setLogger", "(Lcom/tencent/mm/plugin/festival/ui/ParticleSystemLogic$Logger;)V", "particleImage1", "Landroid/graphics/Bitmap;", "particleImage2", "ps", "", "Lcom/plattysoft/leonids/ParticleSystem;", "touchHitRectBottomPadding", "", "getTouchHitRectBottomPadding", "()F", "setTouchHitRectBottomPadding", "(F)V", "touchHitRectTopPadding", "getTouchHitRectTopPadding", "setTouchHitRectTopPadding", "blendARGB", "color1", "color2", "ratio", "disappearIfNeeded", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getImageFromAssets", "path", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setEnable", "updateColorPalette", "ColorModifier", "Companion", "Logger", "plugin-festival_release"})
public final class e {
    public static final c UBX = new c((byte) 0);
    public d UBJ;
    public a UBK;
    private final Bitmap UBL;
    private final Bitmap UBM;
    public float UBN;
    public float UBO;
    private final Interpolator UBP;
    private final List<List<PorterDuffColorFilter>> UBQ;
    private final int UBR;
    private List<? extends List<? extends ColorFilter>> UBS;
    public final List<com.plattysoft.leonids.b> UBT;
    public final Runnable UBU;
    public final Runnable UBV;
    private StarryNight UBW;
    private d Uxt;
    private final Context context = this.zQH.getContext();
    public boolean enable;
    public ViewGroup zQH;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/ParticleSystemLogic$Logger;", "", "e", "", "tag", "", "log", "i", "plugin-festival_release"})
    public interface d {
        void i(String str, String str2);
    }

    static {
        AppMethodBeat.i(263229);
        AppMethodBeat.o(263229);
    }

    public e(ViewGroup viewGroup, StarryNight starryNight, d dVar, String str, String str2) {
        p.h(viewGroup, "viewGroup");
        p.h(starryNight, "starry");
        p.h(dVar, "effect");
        p.h(str, "particle1");
        p.h(str2, "particle2");
        AppMethodBeat.i(263228);
        this.zQH = viewGroup;
        this.UBW = starryNight;
        this.Uxt = dVar;
        this.UBL = bxy(str);
        this.UBM = bxy(str2);
        this.UBP = animation.InterpolatorC1079e.UCa;
        List<Number> mutableListOf = j.mutableListOf(4290351871L, 4283363003L, 4294957008L, 4294931572L, 4294932343L, 4284504575L, 4294950725L, 4282878205L);
        ArrayList arrayList = new ArrayList(j.a(mutableListOf, 10));
        for (Number number : mutableListOf) {
            long longValue = number.longValue();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 256; i2++) {
                int i3 = (int) longValue;
                float f2 = ((float) i2) / 255.0f;
                float f3 = 1.0f - f2;
                arrayList2.add(new PorterDuffColorFilter(Color.argb((int) ((((float) Color.alpha(i3)) * f3) + (((float) Color.alpha(-1)) * f2)), (int) ((((float) Color.red(i3)) * f3) + (((float) Color.red(-1)) * f2)), (int) ((((float) Color.green(i3)) * f3) + (((float) Color.green(-1)) * f2)), (int) ((((float) Color.blue(i3)) * f3) + (f2 * ((float) Color.blue(-1))))), PorterDuff.Mode.SRC_IN));
            }
            arrayList.add(arrayList2);
        }
        this.UBQ = arrayList;
        this.UBR = 2;
        this.UBS = hSh();
        ArrayList arrayList3 = new ArrayList();
        com.plattysoft.leonids.b bVar = new com.plattysoft.leonids.b(this.zQH, this.Uxt.UBD, MAlarmHandler.NEXT_FIRE_INTERVAL, (byte) 0);
        if (this.Uxt.UBD > 1000) {
            bVar.aL(0.5f, 0.7f);
            bVar.zY(35);
        } else {
            bVar.aL(0.8f, 1.0f);
            bVar.zY(30);
        }
        bVar.rf(this.Uxt.UBE);
        bVar.aK(10.0f, 25.0f);
        bVar.Pz(500);
        bVar.qh();
        b bVar2 = new b();
        bVar.a((com.plattysoft.leonids.a.b) bVar2);
        bVar.a((com.plattysoft.leonids.b.b) bVar2);
        arrayList3.add(bVar);
        com.plattysoft.leonids.b bVar3 = new com.plattysoft.leonids.b(this.zQH, 300, 1000, (byte) 0);
        bVar3.aL(0.5f, 0.7f);
        bVar3.aK(20.0f, 30.0f);
        bVar3.Pz(1000);
        bVar3.qh();
        bVar3.rf(200);
        bVar3.zY(40);
        b bVar4 = new b();
        bVar3.a((com.plattysoft.leonids.a.b) bVar4);
        bVar3.a((com.plattysoft.leonids.b.b) bVar4);
        arrayList3.add(bVar3);
        this.UBT = arrayList3;
        Iterator<T> it = this.UBT.iterator();
        while (it.hasNext()) {
            it.next().a(new a(this));
        }
        this.enable = true;
        this.UBU = new g(this);
        this.UBV = new f(this);
        AppMethodBeat.o(263228);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/ParticleSystemLogic$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    private final Bitmap bxy(String str) {
        AppMethodBeat.i(263224);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Context context2 = this.context;
        p.g(context2, "context");
        Bitmap decodeStream = BitmapFactory.decodeStream(context2.getAssets().open(str), null, options);
        if (decodeStream == null) {
            p.hyc();
        }
        AppMethodBeat.o(263224);
        return decodeStream;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "getInterpolation"})
    /* renamed from: com.tencent.mm.plugin.festival.ui.e$e  reason: collision with other inner class name */
    static final class animation.InterpolatorC1079e implements Interpolator {
        public static final animation.InterpolatorC1079e UCa = new animation.InterpolatorC1079e();

        static {
            AppMethodBeat.i(263221);
            AppMethodBeat.o(263221);
        }

        animation.InterpolatorC1079e() {
        }

        public final float getInterpolation(float f2) {
            AppMethodBeat.i(263220);
            float pow = (float) Math.pow((double) f2, 0.3d);
            AppMethodBeat.o(263220);
            return pow;
        }
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.List<? extends java.util.List<? extends android.graphics.ColorFilter>>, java.util.List<java.util.List<android.graphics.ColorFilter>> */
    private final List<List<ColorFilter>> hSh() {
        AppMethodBeat.i(263225);
        List<List<PorterDuffColorFilter>> list = this.UBQ;
        int i2 = this.UBR;
        int nextInt = kotlin.j.d.Pf(System.currentTimeMillis()).nextInt(0, this.UBQ.size() / i2);
        this.UBS = list.subList(nextInt * i2, i2 + (nextInt * i2));
        List list2 = this.UBS;
        AppMethodBeat.o(263225);
        return list2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/ParticleSystemLogic$ColorModifier;", "Lcom/plattysoft/leonids/initializers/ParticleInitializer;", "Lcom/plattysoft/leonids/modifiers/ParticleModifier;", "accelerate", "", "(Lcom/tencent/mm/plugin/festival/ui/ParticleSystemLogic;Z)V", "getAccelerate", "()Z", "setAccelerate", "(Z)V", "apply", "", "particle", "Lcom/plattysoft/leonids/Particle;", "miliseconds", "", "initParticle", "p", "r", "Ljava/util/Random;", "plugin-festival_release"})
    final class b implements com.plattysoft.leonids.a.b, com.plattysoft.leonids.b.b {
        private boolean UBZ = false;

        /* JADX WARN: Incorrect types in method signature: (Z)V */
        public b() {
        }

        @Override // com.plattysoft.leonids.a.b
        public final void a(com.plattysoft.leonids.a aVar, Random random) {
            AppMethodBeat.i(263218);
            p.h(aVar, "p");
            p.h(random, "r");
            aVar.hMT = (List) e.this.UBS.get(random.nextInt(e.this.UBR));
            aVar.hHt = 1500;
            aVar.hHu = 0;
            AppMethodBeat.o(263218);
        }

        @Override // com.plattysoft.leonids.b.b
        public final void a(com.plattysoft.leonids.a aVar, long j2) {
            AppMethodBeat.i(263219);
            p.h(aVar, "particle");
            if (j2 <= aVar.hHu) {
                AppMethodBeat.o(263219);
                return;
            }
            aVar.hHu = j2;
            float f2 = ((float) j2) / ((float) aVar.hHt);
            if (this.UBZ) {
                f2 = e.this.UBP.getInterpolation(f2);
            }
            List<ColorFilter> list = aVar.hMT;
            int max = Math.max(0, Math.min((int) (f2 * ((float) list.size())), list.size() - 1));
            Paint paint = aVar.mPaint;
            p.g(paint, "particle.mPaint");
            paint.setColorFilter(list.get(max));
            AppMethodBeat.o(263219);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "particle", "Lcom/plattysoft/leonids/Particle;", "kotlin.jvm.PlatformType", "random", "Ljava/util/Random;", "initParticle", "com/tencent/mm/plugin/festival/ui/ParticleSystemLogic$1$1"})
    static final class a implements com.plattysoft.leonids.a.b {
        final /* synthetic */ e UBY;

        a(e eVar) {
            this.UBY = eVar;
        }

        @Override // com.plattysoft.leonids.a.b
        public final void a(com.plattysoft.leonids.a aVar, Random random) {
            AppMethodBeat.i(263217);
            if (((double) random.nextFloat()) < 0.3d) {
                aVar.gtH = this.UBY.UBL;
                AppMethodBeat.o(263217);
                return;
            }
            aVar.gtH = this.UBY.UBM;
            AppMethodBeat.o(263217);
        }
    }

    public final void setEnable(boolean z) {
        AppMethodBeat.i(263226);
        d dVar = this.UBJ;
        if (dVar != null) {
            dVar.i("ParticleSystemLogic", "setEnable = ".concat(String.valueOf(z)));
        }
        this.enable = z;
        if (!z) {
            Iterator<T> it = this.UBT.iterator();
            while (it.hasNext()) {
                it.next().aff();
            }
        }
        AppMethodBeat.o(263226);
    }

    public final boolean hSi() {
        AppMethodBeat.i(263227);
        boolean acZ = this.UBT.get(0).acZ();
        d dVar = this.UBJ;
        if (dVar != null) {
            dVar.i("ParticleSystemLogic", "disappear " + acZ + ' ' + 2000L);
        }
        if (acZ) {
            this.UBW.hSj();
            a aVar = this.UBK;
            if (aVar != null) {
                aVar.dMl();
            }
            hSh();
            this.zQH.removeCallbacks(this.UBV);
            this.zQH.postDelayed(this.UBV, 2000);
        }
        AppMethodBeat.o(263227);
        return acZ;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ e UBY;

        g(e eVar) {
            this.UBY = eVar;
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(263223);
            if (!((com.plattysoft.leonids.b) this.UBY.UBT.get(0)).isEmpty()) {
                a aVar = this.UBY.UBK;
                if (aVar != null) {
                    z = aVar.dJf();
                } else {
                    z = false;
                }
                d dVar = this.UBY.UBJ;
                if (dVar != null) {
                    dVar.i("ParticleSystemLogic", "disappearRunnable: true " + z);
                }
                if (!z) {
                    this.UBY.hSi();
                    AppMethodBeat.o(263223);
                    return;
                }
            } else {
                d dVar2 = this.UBY.UBJ;
                if (dVar2 != null) {
                    dVar2.i("ParticleSystemLogic", "disappearRunnable: false");
                    AppMethodBeat.o(263223);
                    return;
                }
            }
            AppMethodBeat.o(263223);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ e UBY;

        f(e eVar) {
            this.UBY = eVar;
        }

        public final void run() {
            AppMethodBeat.i(263222);
            a aVar = this.UBY.UBK;
            if (aVar != null) {
                aVar.dMs();
                AppMethodBeat.o(263222);
                return;
            }
            AppMethodBeat.o(263222);
        }
    }
}
