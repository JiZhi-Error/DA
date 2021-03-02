package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Build;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.handler.glfont.j;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

public final class i implements IMBFontHandler {
    public b cMZ;
    private g cNj;
    private e cNk;
    public f cNs;
    private j cNt;
    private c cNu;
    private boolean cNv = false;

    public final void a(c cVar) {
        this.cNu = cVar;
        if (this.cNj != null) {
            this.cNj.cNb.cNo = this.cNu;
        }
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public final void init(int i2, int i3) {
        AppMethodBeat.i(140041);
        c.C0193c.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + i2 + "], m_atlasHeight = [" + i3 + "]", new Object[0]);
        this.cNk = new e(i2, i3);
        this.cNs = new f(this.cMZ);
        this.cNj = new g(this.cNk, this.cNu);
        this.cNt = new j("normal", j.a.NORMAL);
        AppMethodBeat.o(140041);
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public final String loadFont(String str) {
        String str2 = null;
        AppMethodBeat.i(140042);
        f fVar = this.cNs;
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(140042);
        } else if (fVar.cMZ == null) {
            c.C0193c.i("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
            AppMethodBeat.o(140042);
        } else {
            String dl = fVar.cMZ.dl(str);
            Typeface dg = fVar.cMZ.dg(dl);
            if (dg == null) {
                AppMethodBeat.o(140042);
            } else {
                str2 = f.ea(dl);
                if (h.isNullOrNil(str2)) {
                    if (a.Rx() != null) {
                        a.Rx().ik(0);
                    }
                    str2 = "font" + dg.hashCode();
                }
                c.C0193c.i("MicroMsg.MBFont", "familyName:".concat(String.valueOf(str2)), new Object[0]);
                fVar.cMX.put(str2, dg);
                AppMethodBeat.o(140042);
            }
        }
        return str2;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public final void useFont(String str, String str2, float f2, boolean z, boolean z2) {
        j.a aVar;
        Typeface create;
        int i2;
        boolean z3;
        AppMethodBeat.i(206813);
        j.a j2 = j.a.j(z, z2);
        j jVar = this.cNt;
        f fVar = this.cNs;
        if (j2 == null) {
            aVar = j.a.NORMAL;
        } else {
            aVar = j2;
        }
        if (h.isNullOrNil(str2) && Build.VERSION.SDK_INT >= 28) {
            Typeface create2 = Typeface.create(str, aVar.cND);
            if (h.isNullOrNil(str2) || !fVar.cMY.containsKey(str2)) {
                i2 = 400;
            } else {
                i2 = fVar.cMY.get(str2).intValue();
            }
            if (aVar.isItalic()) {
                z3 = true;
            } else {
                z3 = false;
            }
            create = Typeface.create(create2, i2, z3);
        } else if (str == null || str.length() == 0) {
            create = Typeface.create((String) null, aVar.cND);
        } else {
            create = fVar.cMX.get(str);
            if (create == null) {
                create = Typeface.create(str, aVar.cND);
            } else if (create.getStyle() != aVar.cND) {
                create = Typeface.create(create, aVar.cND);
            }
        }
        jVar.sB = create;
        this.cNt.cNw = str2;
        this.cNt.fontSize = f2;
        this.cNt.cNy = j2;
        AppMethodBeat.o(206813);
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public final void enableStroke(boolean z) {
        this.cNt.cNx = z;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public final void setStrokeWidth(float f2) {
        this.cNt.strokeWidth = f2;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public final FloatBuffer drawText(String str) {
        AppMethodBeat.i(140044);
        this.cNj.a(this.cNt);
        FloatBuffer eb = this.cNj.eb(str);
        if (eb == null) {
            c.C0193c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", str, this.cNt);
            clear();
            eb = this.cNj.eb(str);
        }
        if (eb == null) {
            c.C0193c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", str, this.cNt);
            AppMethodBeat.o(140044);
            return null;
        }
        AppMethodBeat.o(140044);
        return eb;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public final Bitmap getBitmapAtlas() {
        if (this.cNk != null) {
            return this.cNk.cMT;
        }
        return null;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public final int[] checkAndFlushDirtySignal() {
        boolean z;
        AppMethodBeat.i(140045);
        if (this.cNk != null) {
            e eVar = this.cNk;
            if (!eVar.cMV.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(140045);
                return null;
            }
            eVar.cMW[0] = eVar.cMV.left;
            eVar.cMW[1] = eVar.cMV.top;
            eVar.cMW[2] = eVar.cMV.right;
            eVar.cMW[3] = eVar.cMV.bottom;
            eVar.cMV.setEmpty();
            int[] iArr = eVar.cMW;
            AppMethodBeat.o(140045);
            return iArr;
        }
        AppMethodBeat.o(140045);
        return null;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public final boolean checkAndFlushClearSignal() {
        boolean z = this.cNv;
        this.cNv = false;
        return z;
    }

    private void clear() {
        AppMethodBeat.i(140046);
        c.C0193c.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
        if (this.cNk != null) {
            this.cNk.clear();
        }
        if (this.cNj != null) {
            this.cNj.clear();
        }
        this.cNv = true;
        AppMethodBeat.o(140046);
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public final float measureText(String str) {
        AppMethodBeat.i(140047);
        this.cNj.a(this.cNt);
        float ed = this.cNj.ed(str);
        if (ed == -1.0f) {
            c.C0193c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", str, this.cNt);
            clear();
            ed = this.cNj.ed(str);
        }
        if (ed == -1.0f) {
            c.C0193c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", str, this.cNt);
            AppMethodBeat.o(140047);
            return 0.0f;
        }
        AppMethodBeat.o(140047);
        return ed;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public final void release() {
        AppMethodBeat.i(140048);
        if (this.cNk != null) {
            e eVar = this.cNk;
            if (eVar.cMT != null) {
                eVar.cMT.recycle();
            }
            this.cNk = null;
        }
        if (this.cNs != null) {
            f fVar = this.cNs;
            if (fVar.cMX != null) {
                fVar.cMX.clear();
                fVar.cMX = null;
            }
            this.cNs = null;
        }
        if (this.cNj != null) {
            g gVar = this.cNj;
            if (gVar.cNb != null) {
                gVar.cNb = null;
            }
            this.cNj = null;
        }
        AppMethodBeat.o(140048);
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public final float getTextLineHeight(String str) {
        AppMethodBeat.i(140049);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(140049);
            return 0.0f;
        } else if (this.cNs == null || this.cNj == null) {
            AppMethodBeat.o(140049);
            return 0.0f;
        } else {
            this.cNj.a(this.cNt);
            h hVar = this.cNj.cNb;
            if (hVar.cNr == null) {
                AppMethodBeat.o(140049);
                return 0.0f;
            }
            float f2 = (hVar.cNr.bottom - hVar.cNr.ascent) + 1.0f;
            AppMethodBeat.o(140049);
            return f2;
        }
    }
}
