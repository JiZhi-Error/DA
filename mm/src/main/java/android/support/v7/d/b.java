package android.support.v7.d;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseBooleanArray;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class b {
    static final AbstractC0047b abu = new AbstractC0047b() {
        /* class android.support.v7.d.b.AnonymousClass1 */

        @Override // android.support.v7.d.b.AbstractC0047b
        public final boolean e(float[] fArr) {
            boolean z;
            boolean z2;
            boolean z3;
            if (fArr[2] >= 0.95f) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (fArr[2] <= 0.05f) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (fArr[0] < 10.0f || fArr[0] > 37.0f || fArr[1] > 0.82f) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        return true;
                    }
                }
            }
            return false;
        }
    };
    private final List<d> abp;
    private final List<c> abq;
    private final Map<c, d> abr = new android.support.v4.e.a();
    private final SparseBooleanArray abs = new SparseBooleanArray();
    public final d abt = hj();

    /* renamed from: android.support.v7.d.b$b  reason: collision with other inner class name */
    public interface AbstractC0047b {
        boolean e(float[] fArr);
    }

    public interface c {
        void a(b bVar);
    }

    public static a d(Bitmap bitmap) {
        return new a(bitmap);
    }

    b(List<d> list, List<c> list2) {
        this.abp = list;
        this.abq = list2;
    }

    public final d hh() {
        return this.abt;
    }

    /* access modifiers changed from: package-private */
    public final void hi() {
        boolean z;
        int i2;
        int size = this.abq.size();
        for (int i3 = 0; i3 < size; i3++) {
            c cVar = this.abq.get(i3);
            float f2 = 0.0f;
            int length = cVar.abS.length;
            for (int i4 = 0; i4 < length; i4++) {
                float f3 = cVar.abS[i4];
                if (f3 > 0.0f) {
                    f2 += f3;
                }
            }
            if (f2 != 0.0f) {
                int length2 = cVar.abS.length;
                for (int i5 = 0; i5 < length2; i5++) {
                    if (cVar.abS[i5] > 0.0f) {
                        float[] fArr = cVar.abS;
                        fArr[i5] = fArr[i5] / f2;
                    }
                }
            }
            Map<c, d> map = this.abr;
            float f4 = 0.0f;
            d dVar = null;
            int size2 = this.abp.size();
            int i6 = 0;
            while (i6 < size2) {
                d dVar2 = this.abp.get(i6);
                float[] hn = dVar2.hn();
                if (hn[1] < cVar.abQ[0] || hn[1] > cVar.abQ[2] || hn[2] < cVar.abR[0] || hn[2] > cVar.abR[2] || this.abs.get(dVar2.abF)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    float[] hn2 = dVar2.hn();
                    float f5 = 0.0f;
                    float f6 = 0.0f;
                    if (this.abt != null) {
                        i2 = this.abt.abg;
                    } else {
                        i2 = 1;
                    }
                    if (cVar.abS[0] > 0.0f) {
                        f5 = cVar.abS[0] * (1.0f - Math.abs(hn2[1] - cVar.abQ[1]));
                    }
                    if (cVar.abS[1] > 0.0f) {
                        f6 = cVar.abS[1] * (1.0f - Math.abs(hn2[2] - cVar.abR[1]));
                    }
                    float f7 = (cVar.abS[2] > 0.0f ? (((float) dVar2.abg) / ((float) i2)) * cVar.abS[2] : 0.0f) + f5 + f6;
                    if (dVar == null || f7 > f4) {
                        f4 = f7;
                        i6++;
                        dVar = dVar2;
                    }
                }
                dVar2 = dVar;
                i6++;
                dVar = dVar2;
            }
            if (dVar != null && cVar.abT) {
                this.abs.append(dVar.abF, true);
            }
            map.put(cVar, dVar);
        }
        this.abs.clear();
    }

    private d hj() {
        int i2 = Integer.MIN_VALUE;
        d dVar = null;
        int size = this.abp.size();
        int i3 = 0;
        while (i3 < size) {
            d dVar2 = this.abp.get(i3);
            if (dVar2.abg > i2) {
                i2 = dVar2.abg;
            } else {
                dVar2 = dVar;
            }
            i3++;
            dVar = dVar2;
        }
        return dVar;
    }

    public static final class d {
        private final int abC;
        private final int abD;
        private final int abE;
        public final int abF;
        private boolean abG;
        private int abH;
        private int abI;
        private float[] abJ;
        final int abg;

        public d(int i2, int i3) {
            this.abC = Color.red(i2);
            this.abD = Color.green(i2);
            this.abE = Color.blue(i2);
            this.abF = i2;
            this.abg = i3;
        }

        public final int hm() {
            return this.abF;
        }

        public final float[] hn() {
            if (this.abJ == null) {
                this.abJ = new float[3];
            }
            android.support.v4.graphics.b.a(this.abC, this.abD, this.abE, this.abJ);
            return this.abJ;
        }

        public final int ho() {
            hp();
            return this.abI;
        }

        private void hp() {
            int x;
            int x2;
            if (!this.abG) {
                int d2 = android.support.v4.graphics.b.d(-1, this.abF, 4.5f);
                int d3 = android.support.v4.graphics.b.d(-1, this.abF, 3.0f);
                if (d2 == -1 || d3 == -1) {
                    int d4 = android.support.v4.graphics.b.d(WebView.NIGHT_MODE_COLOR, this.abF, 4.5f);
                    int d5 = android.support.v4.graphics.b.d(WebView.NIGHT_MODE_COLOR, this.abF, 3.0f);
                    if (d4 == -1 || d5 == -1) {
                        if (d2 != -1) {
                            x = android.support.v4.graphics.b.x(-1, d2);
                        } else {
                            x = android.support.v4.graphics.b.x(WebView.NIGHT_MODE_COLOR, d4);
                        }
                        this.abI = x;
                        if (d3 != -1) {
                            x2 = android.support.v4.graphics.b.x(-1, d3);
                        } else {
                            x2 = android.support.v4.graphics.b.x(WebView.NIGHT_MODE_COLOR, d5);
                        }
                        this.abH = x2;
                        this.abG = true;
                        return;
                    }
                    this.abI = android.support.v4.graphics.b.x(WebView.NIGHT_MODE_COLOR, d4);
                    this.abH = android.support.v4.graphics.b.x(WebView.NIGHT_MODE_COLOR, d5);
                    this.abG = true;
                    return;
                }
                this.abI = android.support.v4.graphics.b.x(-1, d2);
                this.abH = android.support.v4.graphics.b.x(-1, d3);
                this.abG = true;
            }
        }

        public final String toString() {
            StringBuilder append = new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.abF)).append(']').append(" [HSL: ").append(Arrays.toString(hn())).append(']').append(" [Population: ").append(this.abg).append(']').append(" [Title Text: #");
            hp();
            return append.append(Integer.toHexString(this.abH)).append(']').append(" [Body Text: #").append(Integer.toHexString(ho())).append(']').toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.abg == dVar.abg && this.abF == dVar.abF;
        }

        public final int hashCode() {
            return (this.abF * 31) + this.abg;
        }
    }

    public static final class a {
        private final List<d> abp;
        private final List<c> abq = new ArrayList();
        private int abv = 16;
        private int abw = 12544;
        private int abx = -1;
        private final List<AbstractC0047b> aby = new ArrayList();
        private Rect abz;
        private final Bitmap mBitmap;

        public a(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            this.aby.add(b.abu);
            this.mBitmap = bitmap;
            this.abp = null;
            this.abq.add(c.abK);
            this.abq.add(c.abL);
            this.abq.add(c.abM);
            this.abq.add(c.abN);
            this.abq.add(c.abO);
            this.abq.add(c.abP);
        }

        public final b hk() {
            List<d> list;
            int max;
            Bitmap createScaledBitmap;
            AbstractC0047b[] bVarArr;
            if (this.mBitmap != null) {
                Bitmap bitmap = this.mBitmap;
                double d2 = -1.0d;
                if (this.abw > 0) {
                    int width = bitmap.getWidth() * bitmap.getHeight();
                    if (width > this.abw) {
                        d2 = Math.sqrt(((double) this.abw) / ((double) width));
                    }
                } else if (this.abx > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > this.abx) {
                    d2 = ((double) this.abx) / ((double) max);
                }
                if (d2 <= 0.0d) {
                    createScaledBitmap = bitmap;
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * d2), (int) Math.ceil(d2 * ((double) bitmap.getHeight())), false);
                }
                Rect rect = this.abz;
                if (!(createScaledBitmap == this.mBitmap || rect == null)) {
                    double width2 = ((double) createScaledBitmap.getWidth()) / ((double) this.mBitmap.getWidth());
                    rect.left = (int) Math.floor(((double) rect.left) * width2);
                    rect.top = (int) Math.floor(((double) rect.top) * width2);
                    rect.right = Math.min((int) Math.ceil(((double) rect.right) * width2), createScaledBitmap.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(width2 * ((double) rect.bottom)), createScaledBitmap.getHeight());
                }
                int[] e2 = e(createScaledBitmap);
                int i2 = this.abv;
                if (this.aby.isEmpty()) {
                    bVarArr = null;
                } else {
                    bVarArr = (AbstractC0047b[]) this.aby.toArray(new AbstractC0047b[this.aby.size()]);
                }
                a aVar = new a(e2, i2, bVarArr);
                if (createScaledBitmap != this.mBitmap) {
                    createScaledBitmap.recycle();
                }
                list = aVar.aaZ;
            } else if (this.abp != null) {
                list = this.abp;
            } else {
                throw new AssertionError();
            }
            b bVar = new b(list, this.abq);
            bVar.hi();
            return bVar;
        }

        public final AsyncTask<Bitmap, Void, b> a(final c cVar) {
            return new AsyncTask<Bitmap, Void, b>() {
                /* class android.support.v7.d.b.a.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public final /* synthetic */ b doInBackground(Bitmap[] bitmapArr) {
                    return hl();
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public final /* synthetic */ void onPostExecute(b bVar) {
                    cVar.a(bVar);
                }

                private b hl() {
                    try {
                        return a.this.hk();
                    } catch (Exception e2) {
                        return null;
                    }
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.mBitmap);
        }

        private int[] e(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            if (this.abz == null) {
                return iArr;
            }
            int width2 = this.abz.width();
            int height2 = this.abz.height();
            int[] iArr2 = new int[(width2 * height2)];
            for (int i2 = 0; i2 < height2; i2++) {
                System.arraycopy(iArr, ((this.abz.top + i2) * width) + this.abz.left, iArr2, i2 * width2, width2);
            }
            return iArr2;
        }
    }
}
