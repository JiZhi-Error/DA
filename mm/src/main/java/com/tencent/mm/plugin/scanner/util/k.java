package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.d.b;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.TextPaint;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.protocal.protobuf.ekt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class k {
    private static ExecutorService executorService = h.RTc.bqp("ScanTranslationRender");
    public volatile int CUc;
    public volatile b CUd;
    public a CUe;

    public interface b {
        void d(int i2, Bitmap bitmap);
    }

    static {
        AppMethodBeat.i(184649);
        AppMethodBeat.o(184649);
    }

    public final void a(int i2, List<ekt> list, float f2, Bitmap bitmap, b bVar) {
        AppMethodBeat.i(120952);
        if (!(i2 == 0 || list == null || list.size() <= 0)) {
            if (!(this.CUc == 0 || i2 == this.CUc)) {
                Log.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", Integer.valueOf(this.CUc), Integer.valueOf(i2));
                eRW();
            }
            this.CUc = i2;
            this.CUd = bVar;
            this.CUe = new a(i2, list, f2, bitmap);
            this.CUe.y(new Void[0]);
        }
        AppMethodBeat.o(120952);
    }

    public final void eRW() {
        this.CUc = 0;
        this.CUd = null;
    }

    public class a extends n<Void, Void, Bitmap> {
        private Bitmap CMI;
        private int CUf;
        private Bitmap CUg;
        private Matrix CUh;
        private Matrix CUi;
        private List<ekt> CUj;
        private Set<ekt> CUk = new HashSet();
        private Map<Integer, List<ekt>> CUl = new HashMap();
        private Canvas aTi;
        private float angle;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // com.tencent.mm.pluginsdk.model.n
        public final /* synthetic */ Bitmap doInBackground(Void[] voidArr) {
            AppMethodBeat.i(200117);
            Bitmap rL = rL();
            AppMethodBeat.o(200117);
            return rL;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.pluginsdk.model.n
        public final /* synthetic */ void onPostExecute(Bitmap bitmap) {
            AppMethodBeat.i(120950);
            Bitmap bitmap2 = bitmap;
            Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "task session %d, curSession %d", Integer.valueOf(this.CUf), Integer.valueOf(k.this.CUc));
            if (this.CUf != k.this.CUc) {
                Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "ignore this translation result");
                AppMethodBeat.o(120950);
                return;
            }
            if (!(k.this.CUd == null || bitmap2 == null || bitmap2 == null)) {
                k.this.CUd.d(this.CUf, bitmap2);
            }
            AppMethodBeat.o(120950);
        }

        public a(int i2, List<ekt> list, float f2, Bitmap bitmap) {
            boolean z;
            AppMethodBeat.i(120947);
            this.CUf = i2;
            this.CUj = list;
            this.angle = f2;
            this.CMI = bitmap;
            Iterator<ekt> it = this.CUj.iterator();
            while (it.hasNext()) {
                ekt next = it.next();
                if (next.Width <= 1 || next.Height <= 1 || next.Width == Integer.MAX_VALUE || next.Height == Integer.MAX_VALUE || next.X < 0 || next.Y < 0 || next.X == Integer.MAX_VALUE || next.Y == Integer.MAX_VALUE) {
                    Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "invalid translation info (%d,%d) %d %d", Integer.valueOf(next.X), Integer.valueOf(next.Y), Integer.valueOf(next.Width), Integer.valueOf(next.Height));
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "remove invalid translation info");
                    it.remove();
                }
            }
            for (ekt ekt : this.CUj) {
                if (ekt.Ltr > 0) {
                    if (!this.CUl.containsKey(Integer.valueOf(ekt.Ltr))) {
                        this.CUl.put(Integer.valueOf(ekt.Ltr), new ArrayList());
                    }
                    this.CUl.get(Integer.valueOf(ekt.Ltr)).add(ekt);
                } else {
                    this.CUk.add(ekt);
                }
            }
            AppMethodBeat.o(120947);
        }

        private Bitmap rL() {
            AppMethodBeat.i(120948);
            try {
                Bitmap copy = this.CMI.copy(Bitmap.Config.ARGB_8888, true);
                this.CUh = new Matrix();
                float[] fArr = {0.0f, 0.0f, (float) this.CMI.getWidth(), (float) this.CMI.getHeight()};
                float[] fArr2 = {0.0f, (float) (((double) this.CMI.getWidth()) * Math.abs(Math.sin((double) this.angle))), (float) ((((double) this.CMI.getWidth()) * Math.abs(Math.cos((double) this.angle))) + (((double) this.CMI.getHeight()) * Math.abs(Math.sin((double) this.angle)))), (float) (((double) this.CMI.getHeight()) * Math.abs(Math.cos((double) this.angle)))};
                this.CUh.setPolyToPoly(fArr, 0, fArr2, 0, 2);
                this.CUh.setRotate(-this.angle);
                this.CUi = new Matrix();
                this.CUi.setPolyToPoly(fArr2, 0, fArr, 0, 2);
                this.CUi.setRotate(this.angle);
                Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "angle %s", Float.valueOf(this.angle));
                long currentTimeMillis = System.currentTimeMillis();
                this.CUg = Bitmap.createBitmap(copy, 0, 0, this.CMI.getWidth(), this.CMI.getHeight(), this.CUh, true);
                Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "originalBitmap %d, %d  rotatedBitmap %d %d", Integer.valueOf(this.CMI.getWidth()), Integer.valueOf(this.CMI.getHeight()), Integer.valueOf(this.CUg.getWidth()), Integer.valueOf(this.CUg.getHeight()));
                this.aTi = new Canvas(this.CUg);
                Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "create rotated bitmap cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                long currentTimeMillis2 = System.currentTimeMillis();
                for (ekt ekt : this.CUj) {
                    Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "x %s, y %s, width %s, height %s, text.length %s", Integer.valueOf(ekt.X), Integer.valueOf(ekt.Y), Integer.valueOf(ekt.Width), Integer.valueOf(ekt.Height), Integer.valueOf(ekt.Nkb.length()));
                    k.a(ekt, this.CUg);
                    Bitmap a2 = k.a(this.CUg, new Rect(ekt.X, ekt.Y, ekt.X + ekt.Width, ekt.Y + ekt.Height));
                    Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "area bitmap %d, %d", Integer.valueOf(a2.getWidth()), Integer.valueOf(a2.getHeight()));
                    int[] aq = k.aq(a2);
                    k.a(aq[0], ekt, this.aTi);
                    if (this.CUk.contains(ekt)) {
                        k.a(k.a(ekt), aq[1], ekt, this.aTi);
                    }
                }
                Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "draw all translation bg cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                long currentTimeMillis3 = System.currentTimeMillis();
                for (Integer num : this.CUl.keySet()) {
                    int intValue = num.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (ekt ekt2 : this.CUl.get(Integer.valueOf(intValue))) {
                        arrayList.add(Float.valueOf(k.a(ekt2)));
                    }
                    float floatValue = ((Float) Collections.min(arrayList)).floatValue();
                    List<ekt> list = this.CUl.get(Integer.valueOf(intValue));
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        ekt ekt3 = list.get(i2);
                        Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "x %s, y %s, width %s, height %s", Integer.valueOf(ekt3.X), Integer.valueOf(ekt3.Y), Integer.valueOf(ekt3.Width), Integer.valueOf(ekt3.Height));
                        Bitmap a3 = k.a(this.CUg, new Rect(ekt3.X, ekt3.Y, ekt3.X + ekt3.Width, ekt3.Y + ekt3.Height));
                        Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "area bitmap %d, %d", Integer.valueOf(a3.getWidth()), Integer.valueOf(a3.getHeight()));
                        k.a(floatValue, k.aq(a3)[1], ekt3, this.aTi);
                    }
                }
                Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "draw all translation text cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                Bitmap createBitmap = Bitmap.createBitmap(this.CUg, 0, 0, this.CUg.getWidth(), this.CUg.getHeight(), this.CUi, true);
                Log.i("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", "resultBitmap width %d, height %d", Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight()));
                int[] iArr = new int[(this.CMI.getWidth() * this.CMI.getHeight())];
                createBitmap.getPixels(iArr, 0, this.CMI.getWidth(), (createBitmap.getWidth() - this.CMI.getWidth()) / 2, (createBitmap.getHeight() - this.CMI.getHeight()) / 2, this.CMI.getWidth(), this.CMI.getHeight());
                Bitmap createBitmapByPixels = BitmapUtil.createBitmapByPixels(iArr, this.CMI.getWidth(), this.CMI.getHeight(), Bitmap.Config.ARGB_8888);
                AppMethodBeat.o(120948);
                return createBitmapByPixels;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ScanTranslationRender.RenderTranslationInfoTask", e2, "render translation info error", new Object[0]);
                AppMethodBeat.o(120948);
                return null;
            }
        }

        @Override // com.tencent.mm.pluginsdk.model.n
        public final ExecutorService eGk() {
            AppMethodBeat.i(184646);
            ExecutorService executorService = k.executorService;
            AppMethodBeat.o(184646);
            return executorService;
        }
    }

    static /* synthetic */ void a(ekt ekt, Bitmap bitmap) {
        AppMethodBeat.i(184647);
        if (ekt.X + ekt.Width > bitmap.getWidth()) {
            ekt.Width = bitmap.getWidth() - ekt.X;
        }
        if (ekt.Y + ekt.Height > bitmap.getHeight()) {
            ekt.Height = bitmap.getHeight() - ekt.Y;
        }
        AppMethodBeat.o(184647);
    }

    static /* synthetic */ Bitmap a(Bitmap bitmap, Rect rect) {
        int i2;
        AppMethodBeat.i(120953);
        int width = (int) (((float) rect.width()) * 0.1f);
        int height = (int) (((float) rect.height()) * 0.1f);
        rect.left = rect.left - (width / 2) >= 0 ? rect.left - (width / 2) : 0;
        if (rect.top - (height / 2) >= 0) {
            i2 = rect.top - (height / 2);
        } else {
            i2 = 0;
        }
        rect.top = i2;
        rect.right = rect.right + (width / 2) > bitmap.getWidth() ? bitmap.getWidth() : rect.right + (width / 2);
        rect.bottom = rect.bottom + (height / 2) > bitmap.getHeight() ? bitmap.getHeight() : rect.bottom + (height / 2);
        Log.i("MicroMsg.ScanTranslationRender", "get bg area rect %s", rect);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
        AppMethodBeat.o(120953);
        return createBitmap;
    }

    static /* synthetic */ int[] aq(Bitmap bitmap) {
        AppMethodBeat.i(120954);
        b.d dVar = android.support.v7.d.b.d(bitmap).hk().abt;
        if (dVar == null) {
            Log.i("MicroMsg.ScanTranslationRender", "can not find suitable swatch");
            int[] i2 = ao.i(bitmap, bitmap.getWidth(), bitmap.getHeight());
            AppMethodBeat.o(120954);
            return i2;
        }
        int[] iArr = {dVar.abF, dVar.ho()};
        AppMethodBeat.o(120954);
        return iArr;
    }

    static /* synthetic */ void a(int i2, ekt ekt, Canvas canvas) {
        AppMethodBeat.i(184648);
        Paint paint = new Paint();
        Rect rect = new Rect(ekt.X, ekt.Y, ekt.Width + ekt.X, ekt.Height + ekt.Y);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(i2);
        paint.setAntiAlias(true);
        canvas.drawRect(rect, paint);
        AppMethodBeat.o(184648);
    }

    static /* synthetic */ float a(ekt ekt) {
        AppMethodBeat.i(120955);
        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(16.0f);
        DynamicLayout dynamicLayout = new DynamicLayout(ekt.Nkb, textPaint, ekt.Width, Layout.Alignment.ALIGN_NORMAL, 1.5f, 0.0f, true);
        while (dynamicLayout.getLineBottom(dynamicLayout.getLineCount() - 1) < ekt.Height) {
            textPaint.setTextSize(textPaint.getTextSize() + 0.5f);
            Log.d("MicroMsg.ScanTranslationRender", "try bigger text size %f", Float.valueOf(textPaint.getTextSize()));
            dynamicLayout = new DynamicLayout(ekt.Nkb, textPaint, ekt.Width, Layout.Alignment.ALIGN_NORMAL, 1.5f, 0.0f, true);
        }
        while (dynamicLayout.getLineBottom(dynamicLayout.getLineCount() - 1) > ekt.Height && textPaint.getTextSize() > 1.0f) {
            textPaint.setTextSize(textPaint.getTextSize() - 0.5f);
            Log.d("MicroMsg.ScanTranslationRender", "try smaller text size %f", Float.valueOf(textPaint.getTextSize()));
            dynamicLayout = new DynamicLayout(ekt.Nkb, textPaint, ekt.Width, Layout.Alignment.ALIGN_NORMAL, 1.5f, 0.0f, true);
        }
        float textSize = textPaint.getTextSize();
        AppMethodBeat.o(120955);
        return textSize;
    }

    static /* synthetic */ void a(float f2, int i2, ekt ekt, Canvas canvas) {
        AppMethodBeat.i(120956);
        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(i2);
        textPaint.setTextSize(f2);
        textPaint.setAntiAlias(true);
        Log.i("MicroMsg.ScanTranslationRender", "alignment %d", Integer.valueOf(ekt.Nkd));
        DynamicLayout dynamicLayout = new DynamicLayout(ekt.Nkb, textPaint, ekt.Width, ekt.Nkd == 2 ? Layout.Alignment.ALIGN_CENTER : Layout.Alignment.ALIGN_NORMAL, 1.5f, 0.0f, true);
        canvas.save();
        Log.i("MicroMsg.ScanTranslationRender", "translate %d, %d, textHeight %d, rect Height %d", Integer.valueOf(ekt.X), Integer.valueOf(ekt.Y), Integer.valueOf(dynamicLayout.getHeight()), Integer.valueOf(ekt.Height));
        if (dynamicLayout.getHeight() < ekt.Height) {
            canvas.translate((float) ekt.X, (float) (ekt.Y + ((ekt.Height - dynamicLayout.getHeight()) / 2)));
        } else {
            canvas.translate((float) ekt.X, (float) ekt.Y);
        }
        dynamicLayout.draw(canvas);
        canvas.restore();
        AppMethodBeat.o(120956);
    }
}
