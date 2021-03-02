package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.bx.a.a;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;

public final class c extends a implements e.a {
    private float Kbf;
    private Paint Kbg;
    int[] Kbh;
    Bitmap pqA;

    private c(String str) {
        super(a.b.gov(), str);
        AppMethodBeat.i(152111);
        this.Kbf = 0.5f;
        this.pqA = null;
        this.Kbg = new Paint();
        this.Kbh = new int[2];
        AppMethodBeat.o(152111);
    }

    public c(String str, float f2) {
        this(str);
        this.Kbf = f2;
    }

    @Override // com.tencent.mm.aj.e.a, com.tencent.mm.pluginsdk.ui.a, com.tencent.mm.pluginsdk.ui.j
    public final void Mr(String str) {
        AppMethodBeat.i(152112);
        super.Mr(str);
        AppMethodBeat.o(152112);
    }

    @Override // com.tencent.mm.pluginsdk.ui.j
    public final void draw(Canvas canvas) {
        Bitmap fZ;
        boolean z;
        Bitmap bitmap = null;
        AppMethodBeat.i(152113);
        String str = this.tag + "-" + this.Kbf;
        com.tencent.mm.bx.a.a aVar = a.C0284a.NAL;
        if (aVar != null) {
            bitmap = a.C0284a.NAL.aCX(str);
        }
        if (bitmap == null || bitmap.isRecycled()) {
            if (this.Kcf) {
                fZ = this.Boe.a(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
            } else {
                fZ = this.Boe.fZ(this.tag);
            }
            if (this.Boe instanceof j.b) {
                z = ((j.b) this.Boe).aub(this.tag);
            } else {
                z = true;
            }
            if (fZ != null) {
                if (z) {
                    fZ = BitmapUtil.getRoundedCornerBitmap(fZ, false, this.Kbf * ((float) fZ.getWidth()));
                }
                if (aVar != null) {
                    aVar.p(str, fZ);
                }
                if (fZ != null && !fZ.isRecycled()) {
                    a(canvas, fZ);
                }
            } else if (fZ == null || fZ.isRecycled()) {
                if (this.pqA == null) {
                    try {
                        this.pqA = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
                        this.pqA = BitmapUtil.getRoundedCornerBitmap(this.pqA, false, this.Kbf * ((float) this.pqA.getWidth()));
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.AvatarRoundDrawable", e2, "", new Object[0]);
                    }
                }
                Bitmap bitmap2 = this.pqA;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    a(canvas, bitmap2);
                }
            }
        } else {
            a(canvas, bitmap);
        }
        if (this.pressed) {
            this.Kbg.setColor(WebView.NIGHT_MODE_COLOR);
            this.Kbg.setAlpha(76);
            this.Kbg.setAntiAlias(true);
            RectF rectF = new RectF(getBounds());
            canvas.drawRoundRect(rectF, this.Kbf * rectF.width(), this.Kbf * rectF.height(), this.Kbg);
        }
        AppMethodBeat.o(152113);
    }

    private void a(Canvas canvas, Bitmap bitmap) {
        AppMethodBeat.i(152114);
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.Kcj > 1.0f || this.zxm) {
            int height = (bitmap.getHeight() / 15) / 2;
            int width = (bitmap.getWidth() / 15) / 2;
            rect = new Rect(width, height, bitmap.getWidth() - width, bitmap.getHeight() - height);
        }
        canvas.drawBitmap(bitmap, rect, bounds, this.iuG);
        AppMethodBeat.o(152114);
    }

    public final void aib(int i2) {
        AppMethodBeat.i(152115);
        this.iuG.setAlpha(i2);
        AppMethodBeat.o(152115);
    }
}
