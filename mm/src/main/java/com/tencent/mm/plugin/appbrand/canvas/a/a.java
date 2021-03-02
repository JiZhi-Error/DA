package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.k;
import java.io.Serializable;

public final class a extends Paint implements Serializable {
    public EnumC0560a laj = EnumC0560a.NORMAL;
    private float lak;
    private String lal;
    private int lam;
    private float lan = Float.MAX_VALUE;
    private int lao = Integer.MAX_VALUE;
    private int mColor;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.a.a$a  reason: collision with other inner class name */
    public enum EnumC0560a {
        NORMAL,
        TOP,
        BOTTOM,
        MIDDLE;

        public static EnumC0560a valueOf(String str) {
            AppMethodBeat.i(145334);
            EnumC0560a aVar = (EnumC0560a) Enum.valueOf(EnumC0560a.class, str);
            AppMethodBeat.o(145334);
            return aVar;
        }

        static {
            AppMethodBeat.i(145335);
            AppMethodBeat.o(145335);
        }
    }

    public a() {
        AppMethodBeat.i(145336);
        init();
        AppMethodBeat.o(145336);
    }

    private void init() {
        AppMethodBeat.i(145337);
        this.lak = 0.0f;
        this.mColor = 0;
        this.lal = null;
        this.lam = 0;
        if (this.lan == Float.MAX_VALUE) {
            this.lak = ((float) getAlpha()) / 255.0f;
            this.lan = this.lak;
        } else {
            this.lak = this.lan;
        }
        if (this.lao == Integer.MAX_VALUE) {
            this.mColor = getColor();
            this.lao = this.mColor;
            AppMethodBeat.o(145337);
            return;
        }
        this.mColor = this.lao;
        AppMethodBeat.o(145337);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(145338);
        Object clone = super.clone();
        AppMethodBeat.o(145338);
        return clone;
    }

    public final a bzu() {
        Shader shader;
        AppMethodBeat.i(145339);
        a aVar = new a();
        aVar.setColor(getColor());
        aVar.setFlags(getFlags());
        aVar.setDither(isDither());
        Shader shader2 = getShader();
        if (shader2 != null) {
            Object a2 = k.a(Shader.class, "copy", shader2, new Class[0], new Object[0]);
            if (a2 == null || !(a2 instanceof Shader)) {
                shader = shader2;
            } else {
                shader = (Shader) a2;
            }
            aVar.setShader(shader);
        }
        aVar.setStrokeJoin(getStrokeJoin());
        aVar.setStrokeMiter(getStrokeMiter());
        aVar.setStrokeWidth(getStrokeWidth());
        aVar.setStrokeCap(getStrokeCap());
        aVar.setStyle(getStyle());
        aVar.setTextSize(getTextSize());
        aVar.setTextAlign(getTextAlign());
        aVar.setTypeface(getTypeface());
        aVar.laj = this.laj;
        AppMethodBeat.o(145339);
        return aVar;
    }

    public final a b(a aVar) {
        Shader shader;
        AppMethodBeat.i(145340);
        aVar.setColor(getColor());
        aVar.setFlags(getFlags());
        aVar.setDither(isDither());
        Shader shader2 = getShader();
        if (shader2 != null) {
            Object a2 = k.a(Shader.class, "copy", shader2, new Class[0], new Object[0]);
            if (a2 == null || !(a2 instanceof Shader)) {
                shader = shader2;
            } else {
                shader = (Shader) a2;
            }
            aVar.setShader(shader);
        }
        aVar.setStrokeJoin(getStrokeJoin());
        aVar.setStrokeMiter(getStrokeMiter());
        aVar.setStrokeWidth(getStrokeWidth());
        aVar.setStrokeCap(getStrokeCap());
        aVar.setStyle(getStyle());
        aVar.setTextSize(getTextSize());
        aVar.setTextAlign(getTextAlign());
        aVar.setTypeface(getTypeface());
        aVar.laj = this.laj;
        AppMethodBeat.o(145340);
        return aVar;
    }

    public final void aG(float f2) {
        AppMethodBeat.i(145341);
        this.lak = f2;
        setColor(this.mColor);
        AppMethodBeat.o(145341);
    }

    @Override // android.graphics.Paint
    public final void setColor(int i2) {
        AppMethodBeat.i(145342);
        this.mColor = i2;
        super.setColor(((((int) (((float) Color.alpha(i2)) * this.lak)) & 255) << 24) | (16777215 & i2));
        AppMethodBeat.o(145342);
    }

    public final void reset() {
        AppMethodBeat.i(145343);
        super.reset();
        this.laj = EnumC0560a.NORMAL;
        AppMethodBeat.o(145343);
    }

    public final void release() {
        AppMethodBeat.i(145344);
        reset();
        init();
        AppMethodBeat.o(145344);
    }

    public final void WF(String str) {
        AppMethodBeat.i(145345);
        this.lal = str;
        setTypeface(Typeface.create(str, this.lam));
        AppMethodBeat.o(145345);
    }

    public final void we(int i2) {
        AppMethodBeat.i(145346);
        this.lam = i2;
        setTypeface(Typeface.create(this.lal, i2));
        AppMethodBeat.o(145346);
    }
}
