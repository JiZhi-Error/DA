package com.tencent.mm.z;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.r;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class c implements Cloneable {
    public float dhh = 1.0f;
    public boolean gwn;
    private Rect hoe;
    public String hoh;
    public r hoi;
    public Bitmap hoj;
    public PointF hok;
    private float hol = 1.0f;
    public PointF hom;
    private float hon;
    private float hoo;
    public boolean hop = false;
    List<PointF> hoq = new ArrayList();
    private float hor;
    private float hos;
    protected Context mContext;
    private Matrix mMatrix;
    public int mRotation = 0;

    @Override // java.lang.Object
    public /* synthetic */ Object clone() {
        AppMethodBeat.i(9265);
        c ayz = ayz();
        AppMethodBeat.o(9265);
        return ayz;
    }

    public c(Context context, Matrix matrix, String str, r rVar, Rect rect) {
        AppMethodBeat.i(9250);
        this.hoh = str;
        this.mMatrix = matrix;
        this.hoi = rVar;
        this.mContext = context;
        this.hoe = rect;
        this.hok = new PointF();
        this.hom = new PointF();
        AppMethodBeat.o(9250);
    }

    public c(Context context, Matrix matrix, String str, Rect rect) {
        AppMethodBeat.i(9251);
        this.hoh = str;
        this.mMatrix = matrix;
        this.mContext = context;
        this.hoe = rect;
        this.hok = new PointF();
        this.hom = new PointF();
        AppMethodBeat.o(9251);
    }

    public final void a(float f2, float f3, float f4, int i2) {
        AppMethodBeat.i(9252);
        this.hoj = B(ayx());
        this.hon = (1.2f * ((float) this.hoe.width())) / ((float) this.hoj.getWidth());
        this.hoo = (0.1f * ((float) this.hoe.width())) / ((float) this.hoj.getWidth());
        this.hon *= f4;
        this.hoo *= f4;
        this.hol = (float) (((double) this.hoo) + (0.28d * ((double) (this.hon - this.hoo))));
        this.mRotation = i2;
        this.dhh *= this.hol;
        Log.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", Float.valueOf(this.hon), Float.valueOf(this.hoo), Float.valueOf(this.hol));
        this.hok.set(f2, f3);
        Log.d("MicroMsg.EmojiItem", "[setPoint] point:%s", this.hok);
        ayy();
        AppMethodBeat.o(9252);
    }

    public final boolean ayu() {
        AppMethodBeat.i(9253);
        Log.d("MicroMsg.EmojiItem", "[checkBitmap]");
        if (this.hoj == null || this.hoj.isRecycled()) {
            this.hoj = B(ayx());
            AppMethodBeat.o(9253);
            return true;
        }
        AppMethodBeat.o(9253);
        return false;
    }

    public final boolean z(float f2, float f3) {
        AppMethodBeat.i(9254);
        this.hoq.clear();
        this.hoq.add(ar(this.hor - 180.0f));
        this.hoq.add(ar(-this.hor));
        this.hoq.add(ar(this.hor));
        this.hoq.add(ar((-this.hor) + 180.0f));
        a aVar = new a(this.hoq);
        int i2 = aVar.hov - 1;
        boolean z = false;
        for (int i3 = 0; i3 < aVar.hov; i3++) {
            if ((aVar.hou[i3] < f3 && aVar.hou[i2] >= f3) || (aVar.hou[i2] < f3 && aVar.hou[i3] >= f3)) {
                if (((aVar.hot[i2] - aVar.hot[i3]) * ((f3 - aVar.hou[i3]) / (aVar.hou[i2] - aVar.hou[i3]))) + aVar.hot[i3] < f2) {
                    z = !z;
                }
            }
            i2 = i3;
        }
        AppMethodBeat.o(9254);
        return z;
    }

    public void setSelected(boolean z) {
        this.gwn = z;
    }

    public final void b(float f2, float f3, float f4, int i2) {
        AppMethodBeat.i(9255);
        this.hok.offset(f2, f3);
        if (0.0f != f4) {
            this.dhh = f4;
        }
        this.mRotation = i2;
        AppMethodBeat.o(9255);
    }

    public final void clear() {
        AppMethodBeat.i(9256);
        Log.i("MicroMsg.EmojiItem", "[clear]");
        if (this.hoj != null && !this.hoj.isRecycled()) {
            Log.i("MicroMsg.EmojiItem", "bitmap recycle %s", this.hoj.toString());
            this.hoj.recycle();
            this.hoj = null;
        }
        AppMethodBeat.o(9256);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(9257);
        if (this.hoj == null || this.hoj.isRecycled()) {
            Log.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
            AppMethodBeat.o(9257);
            return;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        if (this.hon < this.dhh) {
            this.dhh = this.hon;
        } else if (this.hoo > this.dhh) {
            this.dhh = this.hoo;
        }
        canvas.save();
        canvas.translate(this.hok.x, this.hok.y);
        canvas.rotate((float) this.mRotation);
        canvas.scale(this.dhh, this.dhh);
        canvas.setDensity(this.hoj.getDensity());
        if (this.gwn) {
            canvas.drawBitmap(this.hoj, (float) ((-ayv()) / 2), (float) ((-ayw()) / 2), (Paint) null);
        } else {
            canvas.clipRect(((float) ((-ayv()) / 2)) + 40.0f, ((float) ((-ayw()) / 2)) + 40.0f, ((float) (this.hoj.getWidth() / 2)) - 40.0f, ((float) (this.hoj.getHeight() / 2)) - 40.0f);
            canvas.drawBitmap(this.hoj, (float) ((-ayv()) / 2), (float) ((-ayw()) / 2), (Paint) null);
        }
        canvas.restore();
        canvas.setDrawFilter(null);
        AppMethodBeat.o(9257);
    }

    private int ayv() {
        AppMethodBeat.i(9258);
        if (this.hoj != null) {
            int width = this.hoj.getWidth();
            AppMethodBeat.o(9258);
            return width;
        }
        AppMethodBeat.o(9258);
        return 0;
    }

    private int ayw() {
        AppMethodBeat.i(9259);
        if (this.hoj != null) {
            int height = this.hoj.getHeight();
            AppMethodBeat.o(9259);
            return height;
        }
        AppMethodBeat.o(9259);
        return 0;
    }

    /* access modifiers changed from: protected */
    public Bitmap ayx() {
        AppMethodBeat.i(9260);
        if (this.hoj == null || this.hoj.isRecycled()) {
            this.hoj = this.hoi.A(this.mContext, 480);
        }
        if (this.hoj == null) {
            Log.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
            new BitmapUtil();
            this.hoj = BitmapUtil.createBitmap(120, 120, Bitmap.Config.ARGB_4444);
            new Canvas(this.hoj).drawColor(-7829368);
        }
        Bitmap bitmap = this.hoj;
        AppMethodBeat.o(9260);
        return bitmap;
    }

    private Bitmap B(Bitmap bitmap) {
        AppMethodBeat.i(9261);
        int width = (int) (((float) bitmap.getWidth()) + 80.0f);
        int height = (int) (((float) bitmap.getHeight()) + 80.0f);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 40.0f, 40.0f, (Paint) null);
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.emoji_box), BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.emoji_box).getNinePatchChunk(), new Rect(), null);
        ninePatchDrawable.setBounds(0, 0, width, height);
        ninePatchDrawable.draw(canvas);
        AppMethodBeat.o(9261);
        return createBitmap;
    }

    public final void ayy() {
        AppMethodBeat.i(9262);
        float f2 = this.hol;
        double ayv = (double) (((((float) ayv()) * 1.0f) / 2.0f) * f2);
        double ayw = (double) (f2 * ((((float) ayw()) * 1.0f) / 2.0f));
        this.hos = (float) Math.sqrt((ayv * ayv) + (ayw * ayw));
        this.hor = (float) Math.toDegrees(Math.atan(ayw / ayv));
        AppMethodBeat.o(9262);
    }

    private PointF ar(float f2) {
        AppMethodBeat.i(9263);
        float f3 = (this.dhh / this.hol) / 2.0f;
        double ayv = (double) (((((float) ayv()) * 1.0f) / 2.0f) * f3);
        double ayw = (double) (f3 * ((((float) ayw()) * 1.0f) / 2.0f));
        this.hos = (float) Math.sqrt((ayw * ayw) + (ayv * ayv));
        PointF pointF = new PointF();
        double d2 = (((double) (((float) this.mRotation) + f2)) * 3.141592653589793d) / 180.0d;
        pointF.x = this.hok.x + ((float) (((double) this.hos) * Math.cos(d2)));
        pointF.y = this.hok.y + ((float) (Math.sin(d2) * ((double) this.hos)));
        AppMethodBeat.o(9263);
        return pointF;
    }

    public final c ayz() {
        CloneNotSupportedException e2;
        c cVar;
        AppMethodBeat.i(9264);
        try {
            cVar = (c) super.clone();
            try {
                cVar.hok = new PointF(this.hok.x, this.hok.y);
                cVar.hoi = this.hoi;
            } catch (CloneNotSupportedException e3) {
                e2 = e3;
                Log.printErrStackTrace("MicroMsg.EmojiItem", e2, "", new Object[0]);
                AppMethodBeat.o(9264);
                return cVar;
            }
        } catch (CloneNotSupportedException e4) {
            e2 = e4;
            cVar = null;
            Log.printErrStackTrace("MicroMsg.EmojiItem", e2, "", new Object[0]);
            AppMethodBeat.o(9264);
            return cVar;
        }
        AppMethodBeat.o(9264);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public class a {
        float[] hot = new float[this.hov];
        float[] hou = new float[this.hov];
        int hov;

        public a(List<PointF> list) {
            AppMethodBeat.i(9249);
            this.hov = list.size();
            for (int i2 = 0; i2 < this.hov; i2++) {
                this.hot[i2] = list.get(i2).x;
                this.hou[i2] = list.get(i2).y;
            }
            new StringBuilder("lasso size:").append(this.hov);
            AppMethodBeat.o(9249);
        }
    }
}
