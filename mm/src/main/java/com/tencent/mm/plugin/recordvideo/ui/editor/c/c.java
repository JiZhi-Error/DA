package com.tencent.mm.plugin.recordvideo.ui.editor.c;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Vibrator;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0002fgB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020SJ\u0010\u0010T\u001a\u00020U2\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010V\u001a\u00020\u0004H\u0002J\b\u0010W\u001a\u00020\u0004H\u0002J\b\u0010X\u001a\u00020\u0004H\u0002J\b\u0010Y\u001a\u00020\u0004H\u0002J\u0010\u0010Z\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+H\u0002J(\u0010[\u001a\u00020\u00142\u0006\u0010\\\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u0004H\u0002J\b\u0010`\u001a\u00020UH\u0002J\u000e\u0010a\u001a\u00020U2\u0006\u0010b\u001a\u00020+J\u0010\u0010c\u001a\u00020U2\u0006\u0010R\u001a\u00020SH\u0002J\u0012\u0010d\u001a\u00020\u0014*\u00020\u00042\u0006\u0010e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR\u000e\u0010'\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001a\u00103\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\u000e\u00106\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001e\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u001708j\b\u0012\u0004\u0012\u00020\u0017`9X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u001708j\b\u0012\u0004\u0012\u00020\u0017`9X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\n\"\u0004\bK\u0010\fR\u000e\u0010L\u001a\u00020MX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010N\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0019\"\u0004\bP\u0010\u001b¨\u0006h"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "", "()V", "CalibrationDistance", "", "TAG", "", "boundArrayDst", "", "getBoundArrayDst", "()[F", "setBoundArrayDst", "([F)V", "boundArrayOut", "getBoundArrayOut", "setBoundArrayOut", "boundArraySrc", "getBoundArraySrc", "setBoundArraySrc", "clockwise", "", "hasInit", "height", "", "getHeight", "()I", "setHeight", "(I)V", "holdX", "getHoldX", "()F", "setHoldX", "(F)V", "holdY", "getHoldY", "setHoldY", "holdingThreshold", "getHoldingThreshold", "setHoldingThreshold", "lastDrag", "lastRotate", "lastStardAngle", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "needVibrator", "pIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pIndices", "pivotDst", "pivotType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$PivotType;", "pointDownRotate", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "selfCalibration", "state", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$TouchState;", "transStart", "transformBoundArray", "getTransformBoundArray", "setTransformBoundArray", "vibrator", "Landroid/os/Vibrator;", "width", "getWidth", "setWidth", "appendTouchEvent", "event", "Landroid/view/MotionEvent;", "findIndices", "", "findMaxBottom", "findMaxRight", "findMinLeft", "findMinTop", "getRotate", "inSafeArea", "newLeft", "newTop", "newRight", "newBottom", "resetHold", "updateMatrix", "m", "updateState", "isEqual", "input", "PivotType", "TouchState", "plugin-recordvideo_release"})
public final class c {
    public Rect BKm;
    private ArrayList<Integer> CgV = new ArrayList<>();
    private ArrayList<Integer> CgW = new ArrayList<>();
    private float[] CgX = new float[2];
    private float[] CgY = new float[4];
    private float[] CgZ = new float[2];
    private b Cha = b.NONE;
    public int Chb;
    private float Chc;
    private float Chd;
    private float[] Che = new float[8];
    private float[] Chf = new float[8];
    public float[] Chg = new float[4];
    private float[] Chh = new float[4];
    private a Chi = a.FREE;
    private boolean Chj = true;
    private float Chk = 15.0f;
    private float Chl;
    private float Chm;
    private boolean Chn;
    private boolean Cho;
    private int Chp;
    private final String TAG = "TouchTracker";
    public float aXt = 10.0f;
    public float aXu = 0.1f;
    public Matrix gT = new Matrix();
    private boolean hasInit;
    public int height;
    private final Vibrator paT;
    public int width;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$PivotType;", "", "(Ljava/lang/String;I)V", "FREE", "CENTER", "plugin-recordvideo_release"})
    public enum a {
        FREE,
        CENTER;

        static {
            AppMethodBeat.i(237930);
            AppMethodBeat.o(237930);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(237932);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(237932);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$TouchState;", "", "(Ljava/lang/String;I)V", "NONE", "DRAG", "SCALE", "plugin-recordvideo_release"})
    public enum b {
        NONE,
        DRAG,
        SCALE;

        static {
            AppMethodBeat.i(237933);
            AppMethodBeat.o(237933);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(237935);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(237935);
            return bVar;
        }
    }

    public c() {
        AppMethodBeat.i(237950);
        Object systemService = MMApplicationContext.getContext().getSystemService("vibrator");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.os.Vibrator");
            AppMethodBeat.o(237950);
            throw tVar;
        }
        this.paT = (Vibrator) systemService;
        this.Cho = true;
        this.gT.setScale(1.0f, 1.0f);
        AppMethodBeat.o(237950);
    }

    public final void setMatrix(Matrix matrix) {
        AppMethodBeat.i(237937);
        p.h(matrix, "<set-?>");
        this.gT = matrix;
        AppMethodBeat.o(237937);
    }

    public final void o(float[] fArr) {
        AppMethodBeat.i(237938);
        p.h(fArr, "<set-?>");
        this.Che = fArr;
        AppMethodBeat.o(237938);
    }

    public final boolean Y(MotionEvent motionEvent) {
        float f2;
        boolean z;
        AppMethodBeat.i(237939);
        p.h(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                float[] fArr = new float[2];
                Matrix matrix = new Matrix();
                this.gT.invert(matrix);
                matrix.mapPoints(fArr, new float[]{motionEvent.getX(), motionEvent.getY()});
                if (fArr[0] >= 0.0f && fArr[0] <= ((float) this.width) && fArr[1] >= 0.0f && fArr[1] <= ((float) this.height)) {
                    this.CgV.add(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
                    this.CgW.add(Integer.valueOf(motionEvent.getActionIndex()));
                    Z(motionEvent);
                    if (!this.hasInit) {
                        Integer num = this.CgW.get(0);
                        p.g(num, "pIndices[0]");
                        float x = motionEvent.getX(num.intValue());
                        Integer num2 = this.CgW.get(0);
                        p.g(num2, "pIndices[0]");
                        float y = motionEvent.getY(num2.intValue());
                        this.gT.postTranslate(x - this.CgX[0], y - this.CgX[1]);
                        this.CgX[0] = x;
                        this.CgX[1] = y;
                        this.gT.mapPoints(this.Chf, this.Che);
                        this.Chg[0] = eMy();
                        this.Chg[1] = eMz();
                        this.Chg[2] = eMA();
                        this.Chg[3] = eMB();
                        this.hasInit = true;
                        break;
                    }
                } else {
                    AppMethodBeat.o(237939);
                    return false;
                }
                break;
            case 1:
            case 3:
                this.Cha = b.NONE;
                this.CgV.clear();
                this.CgW.clear();
                break;
            case 2:
                aa(motionEvent);
                if (motionEvent.getPointerCount() == 1) {
                    this.Cha = b.DRAG;
                }
                switch (d.$EnumSwitchMapping$0[this.Cha.ordinal()]) {
                    case 1:
                        Integer num3 = this.CgW.get(0);
                        p.g(num3, "pIndices[0]");
                        float x2 = motionEvent.getX(num3.intValue());
                        Integer num4 = this.CgW.get(0);
                        p.g(num4, "pIndices[0]");
                        float y2 = motionEvent.getY(num4.intValue());
                        float f3 = x2 - this.CgX[0];
                        float f4 = y2 - this.CgX[1];
                        this.gT.postTranslate(f3, f4);
                        this.CgX[0] = x2;
                        this.CgX[1] = y2;
                        this.gT.mapPoints(this.Chf, this.Che);
                        this.Chg[0] = eMy();
                        this.Chg[1] = eMz();
                        this.Chg[2] = eMA();
                        this.Chg[3] = eMB();
                        if (this.BKm != null && !r(this.Chg[0] + f3, this.Chg[1] + f4, this.Chg[2] + f3, this.Chg[3] + f4)) {
                            float abs = Math.abs(f3);
                            float abs2 = Math.abs(f4);
                            Rect rect = this.BKm;
                            if (rect == null) {
                                p.hyc();
                            }
                            if (((float) rect.left) >= this.Chg[0] && this.Chc <= ((float) this.Chb)) {
                                Matrix matrix2 = this.gT;
                                Rect rect2 = this.BKm;
                                if (rect2 == null) {
                                    p.hyc();
                                }
                                matrix2.postTranslate(((float) rect2.left) - this.Chg[0], 0.0f);
                                this.Chc += abs;
                            }
                            Rect rect3 = this.BKm;
                            if (rect3 == null) {
                                p.hyc();
                            }
                            if (((float) rect3.top) >= this.Chg[1] && this.Chd <= ((float) this.Chb)) {
                                Matrix matrix3 = this.gT;
                                Rect rect4 = this.BKm;
                                if (rect4 == null) {
                                    p.hyc();
                                }
                                matrix3.postTranslate(0.0f, ((float) rect4.top) - this.Chg[1]);
                                this.Chd += abs2;
                            }
                            Rect rect5 = this.BKm;
                            if (rect5 == null) {
                                p.hyc();
                            }
                            if (((float) rect5.right) <= this.Chg[2] && this.Chc <= ((float) this.Chb)) {
                                Matrix matrix4 = this.gT;
                                Rect rect6 = this.BKm;
                                if (rect6 == null) {
                                    p.hyc();
                                }
                                matrix4.postTranslate(((float) rect6.right) - this.Chg[2], 0.0f);
                                this.Chc = abs + this.Chc;
                            }
                            Rect rect7 = this.BKm;
                            if (rect7 == null) {
                                p.hyc();
                            }
                            if (((float) rect7.bottom) <= this.Chg[3] && this.Chd <= ((float) this.Chb)) {
                                Matrix matrix5 = this.gT;
                                Rect rect8 = this.BKm;
                                if (rect8 == null) {
                                    p.hyc();
                                }
                                matrix5.postTranslate(0.0f, ((float) rect8.bottom) - this.Chg[3]);
                                this.Chd += abs2;
                                break;
                            }
                        } else {
                            eMx();
                            break;
                        }
                        break;
                    case 2:
                        Integer num5 = this.CgW.get(0);
                        p.g(num5, "pIndices[0]");
                        Integer num6 = this.CgW.get(0);
                        p.g(num6, "pIndices[0]");
                        Integer num7 = this.CgW.get(1);
                        p.g(num7, "pIndices[1]");
                        Integer num8 = this.CgW.get(1);
                        p.g(num8, "pIndices[1]");
                        this.gT.setPolyToPoly(this.CgY, 0, new float[]{motionEvent.getX(num5.intValue()), motionEvent.getY(num6.intValue()), motionEvent.getX(num7.intValue()), motionEvent.getY(num8.intValue())}, 0, 2);
                        Integer num9 = this.CgW.get(0);
                        p.g(num9, "pIndices[0]");
                        float x3 = motionEvent.getX(num9.intValue());
                        Integer num10 = this.CgW.get(1);
                        p.g(num10, "pIndices[1]");
                        Integer num11 = this.CgW.get(0);
                        p.g(num11, "pIndices[0]");
                        float y3 = motionEvent.getY(num11.intValue());
                        Integer num12 = this.CgW.get(1);
                        p.g(num12, "pIndices[1]");
                        float[] fArr2 = {(motionEvent.getX(num10.intValue()) + x3) / 2.0f, (motionEvent.getY(num12.intValue()) + y3) / 2.0f};
                        if (this.Chj) {
                            float h2 = h(this.gT);
                            if (Math.abs(h2 - this.Chl) <= this.Chk) {
                                this.gT.postRotate(h2 - this.Chl, fArr2[0], fArr2[1]);
                                if (!ag(this.Chm, this.Chl) && ((int) this.Chl) % 90 == 0 && this.Cho) {
                                    Vibrator vibrator = this.paT;
                                    if (vibrator != null) {
                                        vibrator.vibrate(10);
                                    }
                                    this.Cho = false;
                                    this.Chm = this.Chl;
                                }
                                if (h2 < this.Chl) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                this.Chn = z;
                            } else {
                                if (h2 - this.Chl > 0.0f) {
                                    f2 = this.Chk;
                                } else {
                                    f2 = -this.Chk;
                                }
                                this.gT.postRotate(f2, fArr2[0], fArr2[1]);
                                float h3 = h(this.gT);
                                if ((!this.Chn || ((double) h3) > ((double) this.Chm) + 0.5d) && ((double) h3) > ((double) this.Chm) - 0.5d) {
                                    int i2 = ((int) ((90.0f + h3) / 90.0f)) * 90;
                                    if (Math.abs(h3 - ((float) i2)) <= this.Chk && h3 <= ((float) i2)) {
                                        this.gT.postRotate(h3 - ((float) i2), fArr2[0], fArr2[1]);
                                        if (!ag(this.Chl, (float) i2) || this.Cho) {
                                            this.Chl = (float) i2;
                                            this.Cho = false;
                                            Vibrator vibrator2 = this.paT;
                                            if (vibrator2 != null) {
                                                vibrator2.vibrate(10);
                                            }
                                        }
                                    }
                                    if (this.Chp != i2) {
                                        this.Chp = i2;
                                        this.Cho = true;
                                    }
                                    this.Chn = false;
                                } else {
                                    int i3 = ((int) ((h3 - 90.0f) / 90.0f)) * 90;
                                    if (Math.abs(h3 - ((float) i3)) <= this.Chk && h3 >= ((float) i3)) {
                                        this.gT.postRotate(h3 - ((float) i3), fArr2[0], fArr2[1]);
                                        if (!ag(this.Chl, (float) i3) || this.Cho) {
                                            this.Chl = (float) i3;
                                            this.Cho = false;
                                            Vibrator vibrator3 = this.paT;
                                            if (vibrator3 != null) {
                                                vibrator3.vibrate(10);
                                            }
                                        }
                                    }
                                    if (this.Chp != i3) {
                                        this.Chp = i3;
                                        this.Cho = true;
                                    }
                                    this.Chn = true;
                                }
                                this.Chm = h3;
                            }
                        }
                        if (this.Chi == a.CENTER) {
                            float[] fArr3 = new float[2];
                            this.gT.mapPoints(fArr3, new float[]{((float) this.width) / 2.0f, ((float) this.height) / 2.0f});
                            this.gT.postTranslate(this.CgZ[0] - fArr3[0], this.CgZ[1] - fArr3[1]);
                        }
                        b.a aVar = b.CgU;
                        b.a.a(this.gT, fArr2, this.aXu, this.aXt);
                        this.gT.mapPoints(this.Chf, this.Che);
                        this.Chg[0] = eMy();
                        this.Chg[1] = eMz();
                        this.Chg[2] = eMA();
                        this.Chg[3] = eMB();
                        break;
                }
            case 5:
                this.CgV.add(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
                this.CgW.add(Integer.valueOf(motionEvent.getActionIndex()));
                Z(motionEvent);
                if (motionEvent.getPointerCount() == 2) {
                    this.Chm = 0.0f;
                    this.Chl = h(this.gT);
                    this.Chm = this.Chl;
                    Log.i(this.TAG, "downRotate :" + this.Chl);
                    break;
                }
                break;
            case 6:
                aa(motionEvent);
                int indexOf = this.CgW.indexOf(Integer.valueOf(motionEvent.getActionIndex()));
                this.CgW.remove(indexOf);
                this.CgV.remove(indexOf);
                Z(motionEvent);
                break;
        }
        AppMethodBeat.o(237939);
        return true;
    }

    public final void g(Matrix matrix) {
        AppMethodBeat.i(237940);
        p.h(matrix, "m");
        this.gT.set(matrix);
        this.gT.mapPoints(this.Chf, this.Che);
        this.Chg[0] = eMy();
        this.Chg[1] = eMz();
        this.Chg[2] = eMA();
        this.Chg[3] = eMB();
        AppMethodBeat.o(237940);
    }

    private final float h(Matrix matrix) {
        AppMethodBeat.i(237941);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float atan2 = (float) (Math.atan2((double) fArr[1], (double) fArr[0]) * 57.29577951308232d);
        if (this.Chm < -90.0f && atan2 > 0.0f) {
            atan2 -= 360.0f;
        } else if (this.Chm > 90.0f && atan2 < 0.0f) {
            atan2 += 360.0f;
        }
        AppMethodBeat.o(237941);
        return atan2;
    }

    private final void Z(MotionEvent motionEvent) {
        AppMethodBeat.i(237942);
        if (this.CgV.size() == 1) {
            this.Cha = b.DRAG;
            float[] fArr = this.CgX;
            Integer num = this.CgW.get(0);
            p.g(num, "pIndices[0]");
            fArr[0] = motionEvent.getX(num.intValue());
            float[] fArr2 = this.CgX;
            Integer num2 = this.CgW.get(0);
            p.g(num2, "pIndices[0]");
            fArr2[1] = motionEvent.getY(num2.intValue());
            AppMethodBeat.o(237942);
            return;
        }
        if (this.CgV.size() == 2) {
            this.Cha = b.SCALE;
            if (this.Chi == a.CENTER) {
                this.gT.mapPoints(this.CgZ, new float[]{((float) this.width) / 2.0f, ((float) this.height) / 2.0f});
            }
            Matrix matrix = new Matrix();
            this.gT.invert(matrix);
            aa(motionEvent);
            if (p.compare(this.CgW.get(0).intValue(), motionEvent.getPointerCount()) < 0 && p.compare(this.CgW.get(1).intValue(), motionEvent.getPointerCount()) < 0) {
                float[] fArr3 = this.CgY;
                Integer num3 = this.CgW.get(0);
                p.g(num3, "pIndices[0]");
                Integer num4 = this.CgW.get(0);
                p.g(num4, "pIndices[0]");
                Integer num5 = this.CgW.get(1);
                p.g(num5, "pIndices[1]");
                Integer num6 = this.CgW.get(1);
                p.g(num6, "pIndices[1]");
                matrix.mapPoints(fArr3, new float[]{motionEvent.getX(num3.intValue()), motionEvent.getY(num4.intValue()), motionEvent.getX(num5.intValue()), motionEvent.getY(num6.intValue())});
            }
        }
        AppMethodBeat.o(237942);
    }

    private final void aa(MotionEvent motionEvent) {
        AppMethodBeat.i(237943);
        Iterator it = j.r((Collection<?>) this.CgV).iterator();
        while (it.hasNext()) {
            int nextInt = ((ab) it).nextInt();
            ArrayList<Integer> arrayList = this.CgW;
            Integer num = this.CgV.get(nextInt);
            p.g(num, "pIds[i]");
            arrayList.set(nextInt, Integer.valueOf(motionEvent.findPointerIndex(num.intValue())));
        }
        AppMethodBeat.o(237943);
    }

    private final boolean r(float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(237944);
        Rect rect = this.BKm;
        if (rect == null) {
            p.hyc();
        }
        if (f2 > ((float) rect.left)) {
            Rect rect2 = this.BKm;
            if (rect2 == null) {
                p.hyc();
            }
            if (f2 < ((float) rect2.right)) {
                Rect rect3 = this.BKm;
                if (rect3 == null) {
                    p.hyc();
                }
                if (f3 > ((float) rect3.top)) {
                    Rect rect4 = this.BKm;
                    if (rect4 == null) {
                        p.hyc();
                    }
                    if (f3 < ((float) rect4.bottom)) {
                        Rect rect5 = this.BKm;
                        if (rect5 == null) {
                            p.hyc();
                        }
                        if (f4 > ((float) rect5.left)) {
                            Rect rect6 = this.BKm;
                            if (rect6 == null) {
                                p.hyc();
                            }
                            if (f4 < ((float) rect6.right)) {
                                Rect rect7 = this.BKm;
                                if (rect7 == null) {
                                    p.hyc();
                                }
                                if (f5 > ((float) rect7.top)) {
                                    Rect rect8 = this.BKm;
                                    if (rect8 == null) {
                                        p.hyc();
                                    }
                                    if (f5 < ((float) rect8.bottom)) {
                                        AppMethodBeat.o(237944);
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(237944);
        return false;
    }

    private final void eMx() {
        this.Chc = 0.0f;
        this.Chd = 0.0f;
    }

    private final float eMy() {
        AppMethodBeat.i(237945);
        float f2 = this.Chf[0];
        float[] fArr = this.Chf;
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            float f3 = fArr[i2];
            int i4 = i3 + 1;
            switch (i3) {
                case 2:
                    f2 = Math.min(f2, f3);
                    break;
                case 4:
                    f2 = Math.min(f2, f3);
                    break;
                case 6:
                    f2 = Math.min(f2, f3);
                    break;
            }
            i2++;
            i3 = i4;
        }
        AppMethodBeat.o(237945);
        return f2;
    }

    private final float eMz() {
        AppMethodBeat.i(237946);
        float f2 = this.Chf[1];
        float[] fArr = this.Chf;
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            float f3 = fArr[i2];
            int i4 = i3 + 1;
            switch (i3) {
                case 3:
                    f2 = Math.min(f2, f3);
                    break;
                case 5:
                    f2 = Math.min(f2, f3);
                    break;
                case 7:
                    f2 = Math.min(f2, f3);
                    break;
            }
            i2++;
            i3 = i4;
        }
        AppMethodBeat.o(237946);
        return f2;
    }

    private final float eMA() {
        AppMethodBeat.i(237947);
        float f2 = this.Chf[0];
        float[] fArr = this.Chf;
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            float f3 = fArr[i2];
            int i4 = i3 + 1;
            switch (i3) {
                case 2:
                    f2 = Math.max(f2, f3);
                    break;
                case 4:
                    f2 = Math.max(f2, f3);
                    break;
                case 6:
                    f2 = Math.max(f2, f3);
                    break;
            }
            i2++;
            i3 = i4;
        }
        AppMethodBeat.o(237947);
        return f2;
    }

    private final float eMB() {
        AppMethodBeat.i(237948);
        float f2 = this.Chf[1];
        float[] fArr = this.Chf;
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            float f3 = fArr[i2];
            int i4 = i3 + 1;
            switch (i3) {
                case 3:
                    f2 = Math.max(f2, f3);
                    break;
                case 5:
                    f2 = Math.max(f2, f3);
                    break;
                case 7:
                    f2 = Math.max(f2, f3);
                    break;
            }
            i2++;
            i3 = i4;
        }
        AppMethodBeat.o(237948);
        return f2;
    }

    private static boolean ag(float f2, float f3) {
        AppMethodBeat.i(237949);
        if (Math.abs(f2 - f3) < 0.2f) {
            AppMethodBeat.o(237949);
            return true;
        }
        AppMethodBeat.o(237949);
        return false;
    }
}
