package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class j extends BitmapDrawable implements e.a {
    protected static final MMHandler iuH = new MMHandler(Looper.getMainLooper());
    protected final a Boe;
    protected boolean CfV;
    protected boolean Kcf = false;
    private int Kcg = 0;
    private int Kch = 0;
    protected boolean Kci;
    protected float Kcj = 1.0f;
    private PaintFlagsDrawFilter Kck = new PaintFlagsDrawFilter(0, 3);
    public c Kcl;
    protected final Paint iuG = new Paint();
    private Runnable iuJ;
    private Path lR;
    private Paint paint = new Paint();
    private Rect rect = new Rect();
    protected String tag;
    protected boolean zxm = false;

    public interface a {
        Bitmap Wg();

        Bitmap a(String str, int i2, int i3, int i4);

        void a(j jVar);

        Bitmap fZ(String str);

        Bitmap ga(String str);
    }

    public interface b {
        boolean aub(String str);
    }

    public interface c {
        boolean auc(String str);
    }

    static {
        AppMethodBeat.i(152146);
        AppMethodBeat.o(152146);
    }

    public j(a aVar, String str) {
        super(aVar.Wg());
        AppMethodBeat.i(152139);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setFlags(1);
        this.paint.setAntiAlias(true);
        this.lR = new Path();
        this.iuJ = new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(152138);
                j.this.invalidateSelf();
                AppMethodBeat.o(152138);
            }
        };
        this.iuG.setAntiAlias(true);
        this.iuG.setFilterBitmap(true);
        this.Boe = aVar;
        this.tag = str;
        this.Boe.a(this);
        AppMethodBeat.o(152139);
    }

    public j(a aVar, String str, byte b2) {
        super(aVar.Wg());
        AppMethodBeat.i(152140);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setFlags(1);
        this.paint.setAntiAlias(true);
        this.lR = new Path();
        this.iuJ = new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(152138);
                j.this.invalidateSelf();
                AppMethodBeat.o(152138);
            }
        };
        this.iuG.setAntiAlias(true);
        this.iuG.setFilterBitmap(true);
        this.zxm = false;
        this.Boe = aVar;
        this.tag = str;
        this.Boe.a(this);
        AppMethodBeat.o(152140);
    }

    public final void setTag(String str) {
        AppMethodBeat.i(152141);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(152141);
            return;
        }
        if (!str.equals(this.tag)) {
            this.tag = str;
            iuH.post(this.iuJ);
        }
        AppMethodBeat.o(152141);
    }

    public final String getTag() {
        return this.tag;
    }

    public final void zO(boolean z) {
        this.Kcf = z;
    }

    public void draw(Canvas canvas) {
        Bitmap fZ;
        AppMethodBeat.i(152142);
        if (this.Kcf) {
            fZ = this.Boe.a(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else if (this.Kci) {
            fZ = this.Boe.ga(this.tag);
        } else {
            fZ = this.Boe.fZ(this.tag);
        }
        if (fZ == null || fZ.isRecycled()) {
            fZ = this.Boe.Wg();
            if (this.Kci) {
                this.CfV = true;
            } else {
                this.CfV = false;
            }
        } else {
            this.CfV = false;
        }
        Rect bounds = getBounds();
        Rect rect2 = null;
        if (this.Kcj > 1.0f || this.zxm) {
            int height = (fZ.getHeight() / 15) / 2;
            int width = (fZ.getWidth() / 15) / 2;
            rect2 = new Rect(width, height, fZ.getWidth() - width, fZ.getHeight() - height);
        }
        canvas.drawBitmap(fZ, rect2, bounds, this.iuG);
        AppMethodBeat.o(152142);
    }

    public void Mr(String str) {
        AppMethodBeat.i(152143);
        if (this.Kcl != null) {
            this.Kcl.auc(str);
            AppMethodBeat.o(152143);
        } else if (str == null || !str.equals(this.tag)) {
            AppMethodBeat.o(152143);
        } else {
            Log.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", str);
            iuH.post(this.iuJ);
            AppMethodBeat.o(152143);
        }
    }

    public final void goH() {
        AppMethodBeat.i(223847);
        iuH.post(this.iuJ);
        AppMethodBeat.o(223847);
    }

    public final void goI() {
        this.Kci = true;
    }

    public final void goJ() {
        AppMethodBeat.i(152144);
        if (!this.Kci) {
            AppMethodBeat.o(152144);
            return;
        }
        this.Kci = false;
        if (this.CfV) {
            this.CfV = false;
            invalidateSelf();
        }
        AppMethodBeat.o(152144);
    }

    @Override // com.tencent.mm.pluginsdk.ui.e.a
    public void onScrollStateChanged(boolean z) {
        AppMethodBeat.i(152145);
        if (z) {
            this.Kci = true;
            AppMethodBeat.o(152145);
            return;
        }
        goJ();
        AppMethodBeat.o(152145);
    }
}
