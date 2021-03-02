package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.opengl.GLES30;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.xlabeffect.b;
import com.tencent.mm.sticker.e;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;

public final class n implements l {
    private String hDj = "";
    private ArrayList<Runnable> hgk = new ArrayList<>();
    private boolean isInit = false;
    private b oGV = null;
    private float oGW = 0.0f;
    private float oGX = 0.0f;
    private float oGY = 0.0f;
    private float oGZ = 0.0f;
    private long oHa = 0;
    private long oHb = 0;
    private long oHc = 0;
    private long oHd = 0;
    private long oHe = 0;
    private long oHf = 0;
    private long oHg = 0;
    private long oHh = 0;
    private int[] oHi = new int[1];

    public n() {
        AppMethodBeat.i(227855);
        AppMethodBeat.o(227855);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final boolean isEnabled() {
        return true;
    }

    private void queueEvent(Runnable runnable) {
        AppMethodBeat.i(227856);
        synchronized (this) {
            try {
                this.hgk.add(runnable);
            } finally {
                AppMethodBeat.o(227856);
            }
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void a(final l.a aVar, final float f2) {
        AppMethodBeat.i(227857);
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        final int i2 = (int) (100.0f * f2);
        queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.xweb_ext.a.n.AnonymousClass1 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            public final void run() {
                AppMethodBeat.i(227848);
                if (!n.this.isInit) {
                    AppMethodBeat.o(227848);
                    return;
                }
                switch (AnonymousClass7.oHq[aVar.ordinal()]) {
                    case 1:
                        n.this.oGV.kx(3, i2);
                        n.this.oGW = f2;
                        AppMethodBeat.o(227848);
                        return;
                    case 2:
                        n.this.oGV.kx(0, i2);
                        n.this.oGX = f2;
                        AppMethodBeat.o(227848);
                        return;
                    case 3:
                        n.this.oGV.kx(2, i2 * 2);
                        n.this.oGY = f2 * 2.0f;
                        AppMethodBeat.o(227848);
                        return;
                    case 4:
                        n.this.oGV.kx(1, i2);
                        n.this.oGZ = f2;
                        break;
                }
                AppMethodBeat.o(227848);
            }
        });
        AppMethodBeat.o(227857);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void b(final String str, final float f2) {
        AppMethodBeat.i(227858);
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (!str.isEmpty()) {
            try {
                if (!new File(str).exists()) {
                    AppMethodBeat.o(227858);
                    return;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(227858);
                return;
            }
        }
        queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.xweb_ext.a.n.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(227849);
                if (!n.this.isInit) {
                    AppMethodBeat.o(227849);
                    return;
                }
                n.this.oGV.m(str, f2);
                n.this.hDj = str;
                AppMethodBeat.o(227849);
            }
        });
        AppMethodBeat.o(227858);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void a(final l.c cVar, final String str) {
        AppMethodBeat.i(227859);
        queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.xweb_ext.a.n.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(227850);
                if (!n.this.isInit) {
                    AppMethodBeat.o(227850);
                    return;
                }
                e eVar = new e();
                try {
                    eVar.bip(str);
                    eVar.au(h.FE(s.boY(str + "/config.json")));
                    switch (AnonymousClass7.oHr[cVar.ordinal()]) {
                        case 1:
                            if (n.this.oHb != 0) {
                                n.this.oGV.Ml(n.this.oHb);
                                n.this.oHb = 0;
                            }
                            n.this.oGV.bu(12, true);
                            n.this.oHb = n.this.oGV.a(eVar);
                            n.this.oGV.zG(true);
                            AppMethodBeat.o(227850);
                            return;
                        case 2:
                            if (n.this.oHc != 0) {
                                n.this.oGV.Ml(n.this.oHc);
                                n.this.oHc = 0;
                            }
                            n.this.oGV.bu(13, true);
                            n.this.oHc = n.this.oGV.a(eVar);
                            AppMethodBeat.o(227850);
                            return;
                        case 3:
                            if (n.this.oHa != 0) {
                                n.this.oGV.Ml(n.this.oHa);
                                n.this.oHa = 0;
                            }
                            n.this.oGV.bu(11, true);
                            n.this.oHa = n.this.oGV.a(eVar);
                            AppMethodBeat.o(227850);
                            return;
                        default:
                            AppMethodBeat.o(227850);
                            return;
                    }
                } catch (JSONException e2) {
                    AppMethodBeat.o(227850);
                } catch (IOException e3) {
                    AppMethodBeat.o(227850);
                }
            }
        });
        AppMethodBeat.o(227859);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void clearFilters() {
        AppMethodBeat.i(227860);
        b("", 0.0f);
        AppMethodBeat.o(227860);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void Qf() {
        AppMethodBeat.i(227861);
        queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.xweb_ext.a.n.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(227851);
                if (!n.this.isInit) {
                    AppMethodBeat.o(227851);
                    return;
                }
                n.this.oGV.Ml(n.this.oHb);
                n.this.oGV.bu(12, false);
                n.this.oGV.Ml(n.this.oHc);
                n.this.oGV.bu(13, false);
                n.this.oGV.Ml(n.this.oHa);
                n.this.oGV.bu(11, false);
                n.this.oGV.zG(false);
                n.this.oHb = 0;
                n.this.oHc = 0;
                n.this.oHa = 0;
                AppMethodBeat.o(227851);
            }
        });
        AppMethodBeat.o(227861);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void a(final l.b bVar, final String str) {
        AppMethodBeat.i(227862);
        queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.xweb_ext.a.n.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(227852);
                if (!n.this.isInit) {
                    AppMethodBeat.o(227852);
                    return;
                }
                switch (AnonymousClass7.cIK[bVar.ordinal()]) {
                    case 1:
                        if (n.this.oHd != 0) {
                            n.this.oGV.Ml(n.this.oHd);
                            n.this.oHd = 0;
                        }
                        n.this.oGV.bu(14, true);
                        n.this.oHd = n.this.oGV.db(0, str);
                        AppMethodBeat.o(227852);
                        return;
                    case 2:
                        if (n.this.oHe != 0) {
                            n.this.oGV.Ml(n.this.oHe);
                            n.this.oHe = 0;
                        }
                        n.this.oGV.bu(15, true);
                        n.this.oHe = n.this.oGV.db(1, str);
                        AppMethodBeat.o(227852);
                        return;
                    case 3:
                        if (n.this.oHf != 0) {
                            n.this.oGV.Ml(n.this.oHf);
                            n.this.oHf = 0;
                        }
                        n.this.oGV.bu(16, true);
                        n.this.oHf = n.this.oGV.db(2, str);
                        AppMethodBeat.o(227852);
                        return;
                    case 4:
                        if (n.this.oHg != 0) {
                            n.this.oGV.Ml(n.this.oHg);
                            n.this.oHg = 0;
                        }
                        n.this.oGV.bu(17, true);
                        n.this.oHg = n.this.oGV.db(3, str);
                        AppMethodBeat.o(227852);
                        return;
                    case 5:
                        if (n.this.oHh != 0) {
                            n.this.oGV.Ml(n.this.oHh);
                            n.this.oHh = 0;
                        }
                        n.this.oGV.bu(18, true);
                        n.this.oHh = n.this.oGV.db(4, str);
                        AppMethodBeat.o(227852);
                        return;
                    default:
                        AppMethodBeat.o(227852);
                        return;
                }
            }
        });
        AppMethodBeat.o(227862);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.xweb_ext.a.n$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] cIK = new int[l.b.values().length];
        static final /* synthetic */ int[] oHq = new int[l.a.values().length];
        static final /* synthetic */ int[] oHr = new int[l.c.values().length];

        static {
            AppMethodBeat.i(227854);
            try {
                cIK[l.b.MAKEUP_LIP_STICK.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                cIK[l.b.MAKEUP_EYE_SHADOW.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                cIK[l.b.MAKEUP_BLUSHER_STICK.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                cIK[l.b.MAKEUP_FACE_CONTOUR.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                cIK[l.b.MAKEUP_EYE_BROW.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                oHr[l.c.STICKER_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                oHr[l.c.STICKER_FRONT.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                oHr[l.c.STICKER_2D.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            try {
                oHq[l.a.SKIN_BRIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            try {
                oHq[l.a.SKIN_SMOOTH.ordinal()] = 2;
            } catch (NoSuchFieldError e11) {
            }
            try {
                oHq[l.a.FACE_THIN.ordinal()] = 3;
            } catch (NoSuchFieldError e12) {
            }
            try {
                oHq[l.a.EYE_BIGGER.ordinal()] = 4;
                AppMethodBeat.o(227854);
            } catch (NoSuchFieldError e13) {
                AppMethodBeat.o(227854);
            }
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void Qg() {
        AppMethodBeat.i(227863);
        queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.xweb_ext.a.n.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(227853);
                if (!n.this.isInit) {
                    AppMethodBeat.o(227853);
                    return;
                }
                n.this.oGV.bu(14, false);
                n.this.oGV.bu(15, false);
                n.this.oGV.bu(16, false);
                n.this.oGV.bu(17, false);
                n.this.oGV.bu(18, false);
                n.this.oGV.Ml(n.this.oHd);
                n.this.oGV.Ml(n.this.oHe);
                n.this.oGV.Ml(n.this.oHf);
                n.this.oGV.Ml(n.this.oHg);
                n.this.oGV.Ml(n.this.oHh);
                n.this.oHd = 0;
                n.this.oHe = 0;
                n.this.oHf = 0;
                n.this.oHg = 0;
                n.this.oHh = 0;
                AppMethodBeat.o(227853);
            }
        });
        AppMethodBeat.o(227863);
    }

    @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
    public final int onTextureCustomProcess(int i2, int i3, int i4) {
        boolean z;
        AppMethodBeat.i(227864);
        synchronized (this) {
            try {
                if (!this.isInit) {
                    this.oGV = new b();
                    GLES30.glGenTextures(1, this.oHi, 0);
                    GLES30.glBindTexture(3553, this.oHi[0]);
                    GLES30.glTexParameteri(3553, 10241, 9729);
                    GLES30.glTexParameteri(3553, Task.EXTRAS_LIMIT_BYTES, 9728);
                    GLES30.glTexParameteri(3553, 10242, 33071);
                    GLES30.glTexParameteri(3553, 10243, 33071);
                    GLES30.glBindTexture(3553, 0);
                    this.isInit = true;
                }
                while (!this.hgk.isEmpty()) {
                    this.hgk.remove(0).run();
                }
                if (this.oGW == 0.0f && this.oGX == 0.0f && this.oGY == 0.0f && this.oGZ == 0.0f && this.hDj.isEmpty() && this.oHa == 0 && this.oHb == 0 && this.oHc == 0 && this.oHd == 0 && this.oHe == 0 && this.oHf == 0 && this.oHg == 0 && this.oHh == 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    GLES30.glBindTexture(3553, this.oHi[0]);
                    GLES30.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, i3, i4, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                    this.oGV.setSize(i3, i4);
                    this.oGV.kw(i2, 0);
                    b.a(this.oGV, i2, this.oHi[0], false, 60);
                    i2 = this.oHi[0];
                } else {
                    AppMethodBeat.o(227864);
                }
            } finally {
                AppMethodBeat.o(227864);
            }
        }
        return i2;
    }

    @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
    public final void onDetectFacePoints(float[] fArr) {
    }

    @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
    public final void onTextureDestoryed() {
        AppMethodBeat.i(227865);
        synchronized (this) {
            try {
                if (this.isInit) {
                    this.oGV.destroy();
                    GLES30.glDeleteTextures(1, this.oHi, 0);
                    this.isInit = false;
                }
            } finally {
                AppMethodBeat.o(227865);
            }
        }
    }
}
