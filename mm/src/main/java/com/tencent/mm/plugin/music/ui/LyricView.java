package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.api.TPOptionalID;

public class LyricView extends View {
    private static int AmU = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    private static int AmV = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 10);
    private TextPaint AmN;
    private TextPaint AmO;
    private Paint.Align AmP;
    private boolean AmQ;
    private int AmR;
    private int AmS;
    private int AmT;
    private int AmW;
    private boolean AmX;
    private boolean AmY;
    private int AmZ;
    private e Amv;
    private int[] Ana;
    private int[] Anb;
    private float dep;
    private float gZZ;
    private float haa;
    private int height;
    private long iGC;
    private GestureDetector jKk;
    private int mode;
    private int paddingBottom;
    private int paddingTop;
    private int textSize;
    private int width;
    private int ygL;

    public void setLyricObj(e eVar) {
        AppMethodBeat.i(63182);
        this.Amv = eVar;
        invalidate();
        AppMethodBeat.o(63182);
    }

    public void setMode(int i2) {
        boolean z = true;
        this.mode = i2;
        if (1 != i2) {
            z = false;
        }
        this.AmQ = z;
    }

    public void setCurrentTime(long j2) {
        AppMethodBeat.i(63183);
        if (this.iGC != j2) {
            this.iGC = j2;
            if (this.Amv == null || this.Amv.Akn.size() == 0) {
                AppMethodBeat.o(63183);
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (i3 < this.Amv.Akn.size() && this.Amv.SQ(i3).timestamp < j2) {
                if (!this.Amv.SQ(i3).Akt) {
                    i2 = i3;
                }
                i3++;
            }
            if (!this.AmY && i2 != this.AmT) {
                this.AmT = i2;
                this.AmR = this.AmW * this.AmT;
                this.AmS = this.AmW * ((this.Amv.Akn.size() - this.AmT) - 1);
                if (this.ygL == 0) {
                    this.ygL = -this.AmW;
                }
                this.AmX = true;
                invalidate();
            }
        }
        AppMethodBeat.o(63183);
    }

    public LyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(63184);
        this.mode = 1;
        this.AmP = Paint.Align.CENTER;
        this.AmQ = false;
        this.paddingTop = 0;
        this.textSize = AmU;
        this.paddingBottom = AmV;
        this.AmT = -1;
        this.AmW = this.paddingTop + this.textSize + this.paddingBottom;
        this.ygL = this.AmW;
        this.Ana = new int[2];
        this.Anb = new int[2];
        initView();
        AppMethodBeat.o(63184);
    }

    public LyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(63185);
        this.mode = 1;
        this.AmP = Paint.Align.CENTER;
        this.AmQ = false;
        this.paddingTop = 0;
        this.textSize = AmU;
        this.paddingBottom = AmV;
        this.AmT = -1;
        this.AmW = this.paddingTop + this.textSize + this.paddingBottom;
        this.ygL = this.AmW;
        this.Ana = new int[2];
        this.Anb = new int[2];
        initView();
        AppMethodBeat.o(63185);
    }

    public final void a(Paint.Align align, int i2, int i3, int i4) {
        AppMethodBeat.i(219873);
        this.AmQ = true;
        this.AmP = align;
        this.AmN.setTextAlign(align);
        this.AmN.setFakeBoldText(false);
        this.AmO.setTextAlign(align);
        this.AmN.setFakeBoldText(false);
        this.paddingTop = i3;
        this.textSize = i2;
        this.paddingBottom = i4;
        this.AmW = i3 + i2 + i4;
        this.ygL = this.AmW;
        this.AmN.setTextSize((float) i2);
        this.AmO.setTextSize((float) i2);
        AppMethodBeat.o(219873);
    }

    public void setTextSize(float f2) {
        AppMethodBeat.i(219874);
        this.AmN.setTextSize(f2);
        this.AmO.setTextSize(f2);
        AppMethodBeat.o(219874);
    }

    public float getTextSize() {
        AppMethodBeat.i(219875);
        float textSize2 = (float) ((int) this.AmN.getTextSize());
        AppMethodBeat.o(219875);
        return textSize2;
    }

    static {
        AppMethodBeat.i(63192);
        AppMethodBeat.o(63192);
    }

    private void initView() {
        AppMethodBeat.i(63186);
        setNestedScrollingEnabled(true);
        this.AmN = new TextPaint();
        this.AmN.setTextSize((float) this.textSize);
        this.AmN.setColor(-1);
        this.AmN.setAntiAlias(true);
        this.AmN.setTextAlign(this.AmP);
        this.AmO = new TextPaint();
        this.AmO.setTextSize((float) this.textSize);
        this.AmO.setColor(-1);
        this.AmO.setAlpha(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        this.AmO.setAntiAlias(true);
        this.AmO.setTextAlign(this.AmP);
        this.jKk = new GestureDetector(getContext(), new a(this, (byte) 0));
        this.jKk.setIsLongpressEnabled(false);
        AppMethodBeat.o(63186);
    }

    public void setLyricColor(int i2) {
        AppMethodBeat.i(63187);
        this.AmN.setColor(i2);
        this.AmN.setAlpha(255);
        this.AmO.setColor(i2);
        this.AmO.setAlpha(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        AppMethodBeat.o(63187);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z;
        int descent;
        AppMethodBeat.i(63188);
        super.onDraw(canvas);
        if (this.Amv == null || this.Amv.Akn.size() <= 2) {
            Log.d("MicroMsg.Music.LyricView", "lyricObj is null | no lyric");
            int i2 = this.height;
            if (i2 > 300) {
                i2 = this.AmW;
            }
            int descent2 = ((i2 / 2) + this.paddingTop) - (((int) (this.AmN.descent() + this.AmN.ascent())) / 2);
            if (descent2 < i2 && descent2 > 0) {
                canvas.drawText("", 0.0f, (float) descent2, this.AmN);
            }
            AppMethodBeat.o(63188);
            return;
        }
        if (this.height == 0 || this.width == 0) {
            this.height = getMeasuredHeight();
            this.width = getMeasuredWidth();
        }
        if (this.AmT < 0) {
            AppMethodBeat.o(63188);
            return;
        }
        if (Paint.Align.LEFT == this.AmP) {
            int i3 = this.ygL;
            if (this.Amv != null && this.Amv.Akn.size() > this.AmT) {
                this.AmW = this.paddingTop + this.textSize + this.paddingBottom;
                if (!this.AmQ) {
                    int i4 = this.paddingTop + ((this.height / 2) - i3);
                    if (i4 < this.height && i4 > 0 && this.Amv.SQ(this.AmT) != null && !this.Amv.SQ(this.AmT).isEmpty()) {
                        canvas.drawText(this.Amv.SQ(this.AmT).content, 0.0f, (float) i4, this.AmN);
                    }
                    for (int i5 = this.AmT - 1; i5 >= 0; i5--) {
                        int i6 = i4 - ((this.AmT - i5) * this.AmW);
                        if (i6 > 0 && i6 < this.height && this.Amv.SQ(i5) != null && !this.Amv.SQ(i5).isEmpty()) {
                            canvas.drawText(this.Amv.SQ(i5).content, 0.0f, (float) i6, this.AmO);
                        }
                    }
                    int i7 = this.AmT;
                    while (true) {
                        i7++;
                        if (i7 >= this.Amv.Akn.size()) {
                            break;
                        }
                        int i8 = ((i7 - this.AmT) * this.AmW) + i4;
                        if (i8 < this.height && i8 > 0 && this.Amv.SQ(i7) != null && !this.Amv.SQ(i7).isEmpty()) {
                            canvas.drawText(this.Amv.SQ(i7).content, 0.0f, (float) i8, this.AmO);
                        }
                    }
                } else if (this.Amv != null && this.Amv.Akn.size() > this.AmT && (descent = ((this.height / 2) + this.paddingTop) - (((int) (this.AmN.descent() + this.AmN.ascent())) / 2)) < this.height && descent > 0 && this.Amv.SQ(this.AmT) != null && !this.Amv.SQ(this.AmT).isEmpty()) {
                    canvas.drawText(this.Amv.SQ(this.AmT).content, 0.0f, (float) descent, this.AmN);
                }
            }
        } else {
            int i9 = this.ygL;
            if (this.Amv != null && this.Amv.Akn.size() > this.AmT) {
                int i10 = this.paddingTop + ((this.height / 2) - i9);
                if (i10 < this.height && i10 > 0 && this.Amv.SQ(this.AmT) != null) {
                    canvas.drawText(this.Amv.SQ(this.AmT).content, (float) (this.width / 2), (float) i10, this.AmN);
                }
                for (int i11 = this.AmT - 1; i11 >= 0; i11--) {
                    int i12 = i10 - ((this.AmT - i11) * this.AmW);
                    if (i12 > 0 && i12 < this.height && this.Amv.SQ(i11) != null) {
                        canvas.drawText(this.Amv.SQ(i11).content, (float) (this.width / 2), (float) i12, this.AmO);
                    }
                }
                int i13 = this.AmT;
                while (true) {
                    i13++;
                    if (i13 >= this.Amv.Akn.size()) {
                        break;
                    }
                    int i14 = ((i13 - this.AmT) * this.AmW) + i10;
                    if (i14 < this.height && i14 > 0 && this.Amv.SQ(i13) != null) {
                        canvas.drawText(this.Amv.SQ(i13).content, (float) (this.width / 2), (float) i14, this.AmO);
                    }
                }
            }
        }
        if (this.AmX) {
            if (this.ygL != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.ygL = (int) (((float) this.ygL) * 0.9f);
                invalidate();
            }
        }
        AppMethodBeat.o(63188);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(63189);
        super.onSizeChanged(i2, i3, i4, i5);
        this.height = i3;
        this.width = i2;
        AppMethodBeat.o(63189);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(63190);
        GestureDetector gestureDetector = this.jKk;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/music/ui/LyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/music/ui/LyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        int pointerId = motionEvent.getPointerId(0);
        switch (motionEvent.getAction()) {
            case 0:
                this.haa = motionEvent.getY();
                this.gZZ = motionEvent.getX();
                this.AmZ = this.ygL;
                this.AmY = true;
                this.AmX = false;
                this.dep = h(motionEvent, pointerId);
                if (this.dep != -1.0f) {
                    if (2 == this.mode) {
                        startNestedScroll(2);
                        break;
                    }
                } else {
                    AppMethodBeat.o(63190);
                    return false;
                }
                break;
            case 1:
                this.AmY = false;
                break;
            case 2:
                int x = (int) (motionEvent.getX() - this.gZZ);
                int y = (int) (motionEvent.getY() - this.haa);
                int i2 = this.AmZ - y;
                if (i2 > 0) {
                    this.ygL = i2 > this.AmS ? this.AmS : i2;
                } else {
                    this.ygL = i2 < (-this.AmR) ? -this.AmR : i2;
                }
                invalidate();
                Log.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(i2), Integer.valueOf(this.AmZ));
                if (2 == this.mode) {
                    float h2 = h(motionEvent, pointerId);
                    if (h2 != -1.0f) {
                        float f2 = h2 - this.dep;
                        dispatchNestedPreScroll(0, 0, this.Ana, this.Anb);
                        dispatchNestedScroll(0, (int) f2, 0, 0, null);
                        break;
                    } else {
                        AppMethodBeat.o(63190);
                        return false;
                    }
                }
                break;
        }
        AppMethodBeat.o(63190);
        return true;
    }

    /* access modifiers changed from: package-private */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(219872);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(219872);
            return onContextClick;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(219871);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(219871);
            return onDoubleTap;
        }

        private a() {
        }

        /* synthetic */ a(LyricView lyricView, byte b2) {
            this();
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(63181);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            String a2 = LyricView.a(LyricView.this, motionEvent.getX(), motionEvent.getY());
            if (!Util.isNullOrNil(a2)) {
                ClipboardHelper.setText(MMApplicationContext.getContext(), "MicroMsg.Music", a2);
                Toast.makeText(LyricView.this.getContext(), LyricView.this.getContext().getString(R.string.f7t, a2), 0).show();
            } else {
                Log.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(63181);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(219870);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(219870);
            return false;
        }
    }

    private static float h(MotionEvent motionEvent, int i2) {
        AppMethodBeat.i(219876);
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        if (findPointerIndex < 0) {
            AppMethodBeat.o(219876);
            return -1.0f;
        }
        float y = motionEvent.getY(findPointerIndex);
        AppMethodBeat.o(219876);
        return y;
    }

    static /* synthetic */ String a(LyricView lyricView, float f2, float f3) {
        int i2;
        AppMethodBeat.i(63191);
        Log.i("MicroMsg.Music.LyricView", "getSentenceByXY %f, %f", Float.valueOf(f2), Float.valueOf(f3));
        if (lyricView.Amv != null && lyricView.Amv.Akn.size() > 0) {
            int i3 = (lyricView.height / 2) - lyricView.ygL;
            int i4 = i3 - (lyricView.AmW / 2);
            int i5 = i3 + (lyricView.AmW / 2);
            if (f3 < ((float) i4) || f3 > ((float) i5)) {
                if (f3 < ((float) i4)) {
                    int i6 = (lyricView.AmT - (((int) (((float) i4) - f3)) / lyricView.AmW)) - 1;
                    if (i6 < lyricView.Amv.Akn.size() && i6 >= 0) {
                        if (lyricView.Amv.SQ(i6) != null) {
                            String str = lyricView.Amv.SQ(i6).content;
                            AppMethodBeat.o(63191);
                            return str;
                        }
                        AppMethodBeat.o(63191);
                        return "";
                    }
                } else if (f3 > ((float) i5) && (i2 = (((int) (f3 - ((float) i5))) / lyricView.AmW) + lyricView.AmT + 1) < lyricView.Amv.Akn.size() && i2 >= 0) {
                    if (lyricView.Amv.SQ(i2) != null) {
                        String str2 = lyricView.Amv.SQ(i2).content;
                        AppMethodBeat.o(63191);
                        return str2;
                    }
                    AppMethodBeat.o(63191);
                    return "";
                }
            } else if (lyricView.Amv.SQ(lyricView.AmT) != null) {
                String str3 = lyricView.Amv.SQ(lyricView.AmT).content;
                AppMethodBeat.o(63191);
                return str3;
            } else {
                AppMethodBeat.o(63191);
                return "";
            }
        }
        AppMethodBeat.o(63191);
        return "";
    }
}
