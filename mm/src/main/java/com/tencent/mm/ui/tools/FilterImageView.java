package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pointers.PIntArray;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMHorList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView extends LinearLayout {
    static c[] QqF = {new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12)};
    private int DEz = 0;
    Bitmap QqA;
    private MMHorList QqB;
    private a QqC;
    private Runnable QqD;
    private Runnable QqE;
    int[] Qqw;
    private View Qqx;
    private ImageView Qqy;
    CropImageView Qqz;
    private Activity dKq;

    static /* synthetic */ boolean a(FilterImageView filterImageView, String str, int i2, int i3) {
        AppMethodBeat.i(143077);
        boolean aV = filterImageView.aV(str, i2, i3);
        AppMethodBeat.o(143077);
        return aV;
    }

    public FilterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143069);
        this.dKq = (Activity) context;
        View inflate = View.inflate(this.dKq, R.layout.yr, this);
        this.Qqz = (CropImageView) inflate.findViewById(R.id.bip);
        this.Qqy = (ImageView) inflate.findViewById(R.id.biy);
        this.Qqx = inflate.findViewById(R.id.bit);
        this.Qqz.setOnTouchListener(null);
        this.QqB = (MMHorList) inflate.findViewById(R.id.bim);
        this.QqC = new a();
        this.QqB.setAdapter((ListAdapter) this.QqC);
        this.QqB.invalidate();
        this.QqB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.tools.FilterImageView.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(143067);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/FilterImageView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                a aVar = FilterImageView.this.QqC;
                aVar.va = i2;
                aVar.notifyDataSetChanged();
                try {
                    FilterImageView.this.DEz = FilterImageView.QqF[i2].QqQ;
                    FilterImageView.a(FilterImageView.this, FilterImageView.QqF[i2].QqN, FilterImageView.QqF[i2].QqO, FilterImageView.QqF[i2].QqP);
                } catch (Exception e2) {
                    Log.e("MicroMsg.FilterView", e2.toString());
                    Log.printErrStackTrace("MicroMsg.FilterView", e2, "", new Object[0]);
                } catch (OutOfMemoryError e3) {
                    Log.e("MicroMsg.FilterView", e3.toString());
                    Log.printErrStackTrace("MicroMsg.FilterView", e3, "", new Object[0]);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/FilterImageView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(143067);
            }
        });
        AppMethodBeat.o(143069);
    }

    public void setOnConfirmImp(Runnable runnable) {
        this.QqD = runnable;
    }

    public void setOnExitImp(Runnable runnable) {
        this.QqE = runnable;
    }

    public Bitmap getFilterBmp() {
        return this.QqA;
    }

    public void setLimitZoomIn(boolean z) {
        AppMethodBeat.i(143070);
        if (this.Qqz != null) {
            this.Qqz.setLimitZoomIn(z);
        }
        AppMethodBeat.o(143070);
    }

    public void setMatrix(Matrix matrix) {
        AppMethodBeat.i(143071);
        if (this.Qqz != null) {
            this.Qqz.setImageMatrix(matrix);
        }
        AppMethodBeat.o(143071);
    }

    public void setImage(Bitmap bitmap) {
        this.QqA = bitmap;
    }

    public CropImageView getCropImageIV() {
        return this.Qqz;
    }

    public View getCropAreaView() {
        return this.Qqx;
    }

    public void setCropMaskVisible(int i2) {
        AppMethodBeat.i(143072);
        if (this.Qqy != null) {
            this.Qqy.setVisibility(i2);
        }
        AppMethodBeat.o(143072);
    }

    public void setCropMaskBackground(int i2) {
        AppMethodBeat.i(143073);
        if (this.Qqy != null) {
            this.Qqy.setBackgroundResource(i2);
        }
        AppMethodBeat.o(143073);
    }

    public final void hl(String str, int i2) {
        AppMethodBeat.i(143074);
        Log.i("MicroMsg.FilterView", "filePath before fiterBmp:".concat(String.valueOf(str)));
        if (this.QqA == null || this.QqA.isRecycled()) {
            this.QqA = BitmapUtil.rotate(BitmapUtil.extractThumbNail(str, 480, 480, false), (float) i2);
        }
        Log.d("MicroMsg.FilterView", "filterBmp w:" + this.QqA.getWidth() + " h:" + this.QqA.getHeight());
        this.Qqw = new int[(this.QqA.getWidth() * this.QqA.getHeight())];
        this.QqA.getPixels(this.Qqw, 0, this.QqA.getWidth(), 0, 0, this.QqA.getWidth(), this.QqA.getHeight());
        this.Qqz.setImageBitmap(this.QqA);
        AppMethodBeat.o(143074);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(143075);
        if (i2 == 0) {
            this.QqC.notifyDataSetChanged();
            this.QqB.invalidate();
        }
        super.setVisibility(i2);
        AppMethodBeat.o(143075);
    }

    public int getFilterId() {
        return this.DEz;
    }

    private boolean aV(String str, int i2, int i3) {
        AppMethodBeat.i(143076);
        if (i3 == 0) {
            this.QqA.setPixels(this.Qqw, 0, this.QqA.getWidth(), 0, 0, this.QqA.getWidth(), this.QqA.getHeight());
            this.Qqz.invalidate();
            AppMethodBeat.o(143076);
            return true;
        }
        int width = this.QqA.getWidth() * this.QqA.getHeight();
        Log.d("MicroMsg.FilterView", "len:" + width + "  maskCount:" + i2);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, i2, width);
        for (int i4 = 0; i4 < i2; i4++) {
            InputStream inputStream = null;
            try {
                inputStream = this.dKq.getAssets().open("filter/".concat(String.valueOf(String.format(str, Integer.valueOf(i4)))));
                byte[] bArr = new byte[width];
                inputStream.read(bArr);
                Bitmap decodeByteArray = BitmapUtil.decodeByteArray(bArr);
                inputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (decodeByteArray == null) {
                    AppMethodBeat.o(143076);
                    return false;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, this.QqA.getWidth(), this.QqA.getHeight(), true);
                if (decodeByteArray != createScaledBitmap) {
                    Log.i("MicroMsg.FilterView", "recycle bitmap:%s", decodeByteArray.toString());
                    decodeByteArray.recycle();
                }
                if (createScaledBitmap == null) {
                    AppMethodBeat.o(143076);
                    return false;
                }
                createScaledBitmap.getPixels(iArr[i4], 0, createScaledBitmap.getWidth(), 0, 0, createScaledBitmap.getWidth(), createScaledBitmap.getHeight());
                Log.i("MicroMsg.FilterView", "recycle bitmap:%s", createScaledBitmap.toString());
                createScaledBitmap.recycle();
            } catch (Exception e2) {
                AppMethodBeat.o(143076);
                throw e2;
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                AppMethodBeat.o(143076);
                throw th;
            }
        }
        PIntArray pIntArray = new PIntArray();
        Log.e("MicroMsg.FilterView", "src.len:" + this.Qqw.length);
        for (int i5 = 0; i5 < iArr.length; i5++) {
            Log.e("MicroMsg.FilterView", "mask[" + i5 + "].len:" + iArr[i5].length);
        }
        Log.e("MicroMsg.FilterView", "before filter");
        ImgFilter.FilterInt(i3, this.Qqw, iArr, i2, this.QqA.getWidth(), this.QqA.getHeight(), pIntArray);
        Log.e("MicroMsg.FilterView", "after filter");
        this.QqA.setPixels(pIntArray.value, 0, this.QqA.getWidth(), 0, 0, this.QqA.getWidth(), this.QqA.getHeight());
        this.Qqz.invalidate();
        AppMethodBeat.o(143076);
        return true;
    }

    static class b {
        String QqK;
        String QqL;
        String zGG;

        b(String str, String str2, String str3) {
            this.zGG = str;
            this.QqK = str2;
            this.QqL = str3;
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        b QqM;
        String QqN;
        int QqO;
        int QqP;
        int QqQ;
        String icon;

        c(b bVar, String str, int i2, int i3, String str2, int i4) {
            this.QqM = bVar;
            this.QqN = str;
            this.QqO = i2;
            this.QqP = i3;
            this.icon = str2;
            this.QqQ = i4;
        }
    }

    static {
        AppMethodBeat.i(143078);
        AppMethodBeat.o(143078);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        int va = 0;

        a() {
        }

        public final int getCount() {
            return FilterImageView.QqF.length;
        }

        public final Object getItem(int i2) {
            return FilterImageView.QqF[i2];
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C2127a aVar;
            String str;
            AppMethodBeat.i(143068);
            c cVar = (c) getItem(i2);
            if (view == null || !(view.getTag() instanceof C2127a)) {
                view = View.inflate(FilterImageView.this.dKq, R.layout.a8z, null);
                C2127a aVar2 = new C2127a();
                aVar2.vr = (TextView) view.findViewById(R.id.ciw);
                aVar2.QqH = (ImageView) view.findViewById(R.id.civ);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C2127a) view.getTag();
                if (aVar.QqI != null) {
                    Log.i("MicroMsg.FilterView", "recycle bitmap:%s", aVar.QqI.toString());
                    aVar.QqI.recycle();
                }
            }
            TextView textView = aVar.vr;
            b bVar = cVar.QqM;
            String applicationLanguage = LocaleUtil.getApplicationLanguage();
            if (applicationLanguage.equals(LocaleUtil.CHINA)) {
                str = bVar.zGG;
            } else if (applicationLanguage.equals(LocaleUtil.TAIWAN) || applicationLanguage.equals(LocaleUtil.HONGKONG)) {
                str = bVar.QqK;
            } else {
                str = bVar.QqL;
            }
            textView.setText(str);
            try {
                InputStream open = FilterImageView.this.dKq.getAssets().open("filter/" + cVar.icon);
                aVar.QqI = BackwardSupportUtil.BitmapFactory.decodeStream(open);
                open.close();
                aVar.QqH.setImageBitmap(aVar.QqI);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.FilterView", e2, "", new Object[0]);
            }
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            if (i2 == this.va) {
                view.findViewById(R.id.civ).setBackgroundResource(R.drawable.bay);
            } else {
                view.findViewById(R.id.civ).setBackgroundResource(R.drawable.baz);
            }
            AppMethodBeat.o(143068);
            return view;
        }

        /* renamed from: com.tencent.mm.ui.tools.FilterImageView$a$a  reason: collision with other inner class name */
        class C2127a {
            ImageView QqH;
            Bitmap QqI;
            TextView vr;

            C2127a() {
            }
        }
    }
}
