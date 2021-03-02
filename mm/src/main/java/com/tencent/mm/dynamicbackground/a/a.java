package com.tencent.mm.dynamicbackground.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.GregorianCalendar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 11}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0003\u000b\f\rB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0005\u001a\u00060\u0006R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "", "()V", "bgSystemColorConfig", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$BgSystemColorConfig;", "color", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "getColor", "()Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "updateColor", "", "BgSystemColorConfig", "ColorConfig", "Companion", "dynamicbg_release"})
public final class a {
    private static final String TAG = TAG;
    public static final c gRm = new c((byte) 0);
    public final b gRk = new b();
    private final C0313a gRl = new C0313a();

    public a() {
        AppMethodBeat.i(103089);
        this.gRk.h(new float[]{0.0f, 0.0f, 0.0f, 0.0f});
        this.gRk.i(new float[]{0.0f, 0.0f, 0.0f, 0.0f});
        this.gRl.gRn.h(c.pb(11064532));
        this.gRl.gRn.i(c.pb(2770276));
        this.gRl.gRo.h(c.pb(8553090));
        this.gRl.gRo.i(c.pb(0));
        this.gRl.gRp.h(c.pb(5260629));
        this.gRl.gRp.i(c.pb(0));
        AppMethodBeat.o(103089);
    }

    public final void atO() {
        b bVar;
        b bVar2;
        AppMethodBeat.i(103088);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        float f2 = (float) (currentTimeMillis - ((currentTimeMillis - ((long) (gregorianCalendar.get(13) + (((gregorianCalendar.get(11) * 60) * 60) + (gregorianCalendar.get(12) * 60))))) + 36000));
        if (f2 < 0.0f) {
            f2 += 86400.0f;
        }
        float f3 = (f2 * 1.0f) / 28800.0f;
        if (f3 > 2.0f) {
            f3 -= 2.0f;
            bVar = this.gRl.gRp;
            bVar2 = this.gRl.gRn;
        } else if (f3 > 1.0f) {
            f3 -= 1.0f;
            bVar = this.gRl.gRo;
            bVar2 = this.gRl.gRp;
        } else {
            bVar = this.gRl.gRn;
            bVar2 = this.gRl.gRo;
        }
        c.b(this.gRk.gRr, bVar, bVar2, 0, f3);
        c.b(this.gRk.gRs, bVar, bVar2, 1, f3);
        AppMethodBeat.o(103088);
    }

    @l(hxD = {1, 1, 11}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "", "(Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;)V", "bgColor1", "", "getBgColor1", "()[F", "setBgColor1", "([F)V", "bgColor2", "getBgColor2", "setBgColor2", "dynamicbg_release"})
    public final class b {
        public float[] gRr = new float[4];
        public float[] gRs = new float[4];

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            AppMethodBeat.i(103084);
            AppMethodBeat.o(103084);
        }

        public final void h(float[] fArr) {
            AppMethodBeat.i(103082);
            p.h(fArr, "<set-?>");
            this.gRr = fArr;
            AppMethodBeat.o(103082);
        }

        public final void i(float[] fArr) {
            AppMethodBeat.i(103083);
            p.h(fArr, "<set-?>");
            this.gRs = fArr;
            AppMethodBeat.o(103083);
        }
    }

    @l(hxD = {1, 1, 11}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00060\u0004R\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00060\u0004R\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00060\u0004R\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$BgSystemColorConfig;", "", "(Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;)V", "endColorConfig", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "getEndColorConfig", "()Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "setEndColorConfig", "(Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;)V", "middleColorConfig", "getMiddleColorConfig", "setMiddleColorConfig", "startColorConfig", "getStartColorConfig", "setStartColorConfig", "dynamicbg_release"})
    /* renamed from: com.tencent.mm.dynamicbackground.a.a$a  reason: collision with other inner class name */
    public final class C0313a {
        b gRn;
        b gRo;
        b gRp;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C0313a() {
            AppMethodBeat.i(103081);
            this.gRn = new b();
            this.gRo = new b();
            this.gRp = new b();
            AppMethodBeat.o(103081);
        }
    }

    @l(hxD = {1, 1, 11}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ:\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\u0010\f\u001a\u00060\rR\u00020\u000e2\n\u0010\u000f\u001a\u00060\rR\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$Companion;", "", "()V", "TAG", "", "colorArrayToInt", "", "color", "", "getBGColorFromStartConfig", "", "result", "startConfig", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper$ColorConfig;", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "endConfig", "colorIndex", "portion", "", "getVector4ColorFromHex", "hex", "alpha", "mixColorWithA", "aColor", "bColor", "dynamicbg_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }

        public static final /* synthetic */ void b(float[] fArr, b bVar, b bVar2, int i2, float f2) {
            AppMethodBeat.i(103087);
            a(fArr, bVar, bVar2, i2, f2);
            AppMethodBeat.o(103087);
        }

        public static int j(float[] fArr) {
            AppMethodBeat.i(103085);
            p.h(fArr, "color");
            int i2 = ((((int) (fArr[0] * 255.0f)) & 255) << 16) + ((((int) (fArr[3] * 255.0f)) & 255) << 24) + ((((int) (fArr[1] * 255.0f)) & 255) << 8) + (((int) (fArr[2] * 255.0f)) & 255);
            AppMethodBeat.o(103085);
            return i2;
        }

        private static void a(float[] fArr, b bVar, b bVar2, int i2, float f2) {
            AppMethodBeat.i(103086);
            if (i2 == 0) {
                if (fArr == null) {
                    p.hyc();
                }
                float[] fArr2 = bVar.gRr;
                if (fArr2 == null) {
                    p.hyc();
                }
                float[] fArr3 = bVar2.gRr;
                if (fArr3 == null) {
                    p.hyc();
                }
                a(fArr, fArr2, fArr3, f2);
                AppMethodBeat.o(103086);
                return;
            }
            if (i2 == 1) {
                if (fArr == null) {
                    p.hyc();
                }
                float[] fArr4 = bVar.gRs;
                if (fArr4 == null) {
                    p.hyc();
                }
                float[] fArr5 = bVar2.gRs;
                if (fArr5 == null) {
                    p.hyc();
                }
                a(fArr, fArr4, fArr5, f2);
            }
            AppMethodBeat.o(103086);
        }

        static float[] pb(int i2) {
            return new float[]{((float) ((16711680 & i2) >> 16)) / 255.0f, ((float) ((65280 & i2) >> 8)) / 255.0f, ((float) ((i2 & 255) >> 0)) / 255.0f, 1.0f};
        }

        private static void a(float[] fArr, float[] fArr2, float[] fArr3, float f2) {
            fArr[0] = (fArr3[0] * f2) + (fArr2[0] * (1.0f - f2));
            fArr[1] = (fArr3[1] * f2) + (fArr2[1] * (1.0f - f2));
            fArr[2] = (fArr3[2] * f2) + (fArr2[2] * (1.0f - f2));
            fArr[3] = (fArr3[3] * f2) + (fArr2[3] * (1.0f - f2));
        }
    }

    static {
        AppMethodBeat.i(103090);
        AppMethodBeat.o(103090);
    }
}
