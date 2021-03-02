package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class c extends b {
    private HashMap<String, Bitmap> EuX = new HashMap<>();
    boolean Eva;
    private int FbB;
    private boolean FbC;
    private boolean FbD;
    a FbE;
    private int FbF = 0;

    public interface a {
        void iK(int i2, int i3);

        void removeItem(int i2);
    }

    /* access modifiers changed from: package-private */
    public class d {
        public Object data;
        public int id;

        private d() {
        }

        /* synthetic */ d(c cVar, byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(100267);
            String obj = this.data.toString();
            AppMethodBeat.o(100267);
            return obj;
        }

        public final int hashCode() {
            return this.id;
        }
    }

    public c(Context context, List<?> list, boolean z, a aVar) {
        super(context);
        AppMethodBeat.i(100268);
        super.hl(hm(list));
        this.FbB = 9;
        this.FbC = z;
        this.FbE = aVar;
        fku();
        fkv();
        AppMethodBeat.o(100268);
    }

    private List<d> hm(List<?> list) {
        AppMethodBeat.i(100269);
        ArrayList arrayList = new ArrayList(list.size());
        int i2 = 0;
        for (Object obj : list) {
            d dVar = new d(this, (byte) 0);
            dVar.data = obj;
            dVar.id = i2;
            arrayList.add(dVar);
            i2++;
        }
        AppMethodBeat.o(100269);
        return arrayList;
    }

    public final void fkv() {
        AppMethodBeat.i(100271);
        Log.v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", Boolean.valueOf(this.FbC), Integer.valueOf(getCount()), Integer.valueOf(this.FbA), Integer.valueOf(this.FbB), Boolean.valueOf(this.FbD));
        if (!this.FbC || fkw() >= this.FbB) {
            this.FbD = false;
        } else if (!this.FbD) {
            this.FbD = true;
            add("");
            AppMethodBeat.o(100271);
            return;
        }
        AppMethodBeat.o(100271);
    }

    @Override // com.tencent.mm.plugin.sns.ui.previewimageview.b
    public final void clear() {
        AppMethodBeat.i(100272);
        super.clear();
        this.FbD = false;
        AppMethodBeat.o(100272);
    }

    @Override // com.tencent.mm.plugin.sns.ui.previewimageview.b
    public final void hl(List<?> list) {
        AppMethodBeat.i(100273);
        super.hl(hm(list));
        fku();
        fkv();
        AppMethodBeat.o(100273);
    }

    public final int fkw() {
        AppMethodBeat.i(100274);
        int count = (getCount() - this.FbA) - (this.FbD ? 1 : 0);
        AppMethodBeat.o(100274);
        return count;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(100275);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.bwy, viewGroup, false);
            bVar = new b(this, view, (byte) 0);
            view.setTag(R.id.dxg, bVar);
            ImageView imageView = bVar.dKU;
            if (this.FbF == 0) {
                aj.faD();
                int screenWidth = r.getScreenWidth();
                if (screenWidth != 0) {
                    this.FbF = ((screenWidth - (this.mContext.getResources().getDimensionPixelSize(R.dimen.akd) * 4)) - (this.mContext.getResources().getDimensionPixelSize(R.dimen.hv) * 2)) / 3;
                }
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.FbF;
            layoutParams.height = this.FbF;
            imageView.setLayoutParams(layoutParams);
        } else {
            bVar = (b) view.getTag(R.id.dxg);
        }
        String obj = getItem(i2).toString();
        ImageView imageView2 = bVar.dKU;
        if (TextUtils.isEmpty(obj)) {
            imageView2.setBackgroundResource(R.color.a9q);
            imageView2.setImageResource(R.raw.album_post_add_picture_btn);
            imageView2.setContentDescription(bVar.dKU.getContext().getString(R.string.h4w));
            int i3 = (c.this.FbF * 35) / 100;
            imageView2.setPadding(i3, i3, i3, i3);
            if (i2 > 0) {
                bVar.view.setTag(-1);
            } else if (i2 < c.this.FbA) {
                bVar.view.setTag(Integer.MAX_VALUE);
            }
        } else {
            bVar.view.setTag(Integer.valueOf(i2 - c.this.FbA));
            imageView2.setBackgroundDrawable(null);
            imageView2.setTag(obj);
            imageView2.setContentDescription(bVar.dKU.getContext().getString(R.string.h71));
            imageView2.setPadding(0, 0, 0, 0);
            Bitmap bitmap = c.this.EuX.get(obj);
            if (!com.tencent.mm.plugin.sns.data.r.M(bitmap)) {
                new C1740c(imageView2, obj).y("");
            } else {
                imageView2.setImageBitmap(bitmap);
            }
        }
        if (i2 < this.FbA) {
            bVar.dKU.setVisibility(4);
        } else {
            bVar.dKU.setVisibility(0);
            view.setVisibility(0);
        }
        AppMethodBeat.o(100275);
        return view;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(100276);
        if (TextUtils.isEmpty(getItem(i2).toString())) {
            AppMethodBeat.o(100276);
            return 1;
        }
        AppMethodBeat.o(100276);
        return 0;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    class b {
        ImageView dKU;
        View view;

        /* synthetic */ b(c cVar, View view2, byte b2) {
            this(view2);
        }

        private b(View view2) {
            AppMethodBeat.i(100263);
            this.view = view2;
            this.dKU = (ImageView) view2.findViewById(R.id.e44);
            AppMethodBeat.o(100263);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.previewimageview.b, com.tencent.mm.plugin.sns.ui.previewimageview.d
    public final void iT(int i2, int i3) {
        AppMethodBeat.i(100279);
        super.iT(i2, i3);
        if (this.FbE != null) {
            this.FbE.iK(i2 - this.FbA, i3 - this.FbA);
        }
        AppMethodBeat.o(100279);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.c$c  reason: collision with other inner class name */
    class C1740c extends h<String, Integer, Boolean> {
        private ImageView dPk;
        private Bitmap iKs;
        private String path;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.sns.model.h
        public final /* synthetic */ void onPostExecute(Boolean bool) {
            AppMethodBeat.i(100265);
            super.onPostExecute(bool);
            if (!c.this.Eva && com.tencent.mm.plugin.sns.data.r.M(this.iKs)) {
                c.this.EuX.put(this.path, this.iKs);
                if (this.dPk.getTag() != null && (this.dPk.getTag() instanceof String) && this.dPk.getTag().equals(this.path)) {
                    this.dPk.setImageBitmap(this.iKs);
                }
            }
            AppMethodBeat.o(100265);
        }

        public C1740c(ImageView imageView, String str) {
            this.dPk = imageView;
            this.path = str;
        }

        @Override // com.tencent.mm.plugin.sns.model.h
        public final ExecutorService eGk() {
            AppMethodBeat.i(179372);
            ExecutorService fay = aj.fay();
            AppMethodBeat.o(179372);
            return fay;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // com.tencent.mm.plugin.sns.model.h
        public final /* synthetic */ Boolean doInBackground(String[] strArr) {
            AppMethodBeat.i(259468);
            if (c.this.Eva) {
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(259468);
                return bool;
            }
            this.iKs = BitmapUtil.extractThumbNail(this.path, aj.fbb(), aj.fbb(), true);
            int orientationInDegree = Exif.fromFile(this.path).getOrientationInDegree();
            Log.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", this.path, Integer.valueOf(orientationInDegree));
            this.iKs = BitmapUtil.rotate(this.iKs, (float) orientationInDegree);
            Boolean bool2 = Boolean.TRUE;
            AppMethodBeat.o(259468);
            return bool2;
        }
    }

    private void fku() {
        AppMethodBeat.i(100270);
        for (int i2 = 0; i2 < this.FbA; i2++) {
            d dVar = new d(this, (byte) 0);
            dVar.data = "";
            dVar.id = getCount();
            dVar.id = getCount();
            add(i2, dVar);
        }
        AppMethodBeat.o(100270);
    }

    @Override // com.tencent.mm.plugin.sns.ui.previewimageview.b, com.tencent.mm.plugin.sns.ui.previewimageview.d
    public final boolean aaf(int i2) {
        AppMethodBeat.i(100277);
        if (i2 < this.FbA) {
            AppMethodBeat.o(100277);
            return false;
        } else if (!this.FbD) {
            boolean aaf = super.aaf(i2);
            AppMethodBeat.o(100277);
            return aaf;
        } else if (i2 != getCount() - 1) {
            AppMethodBeat.o(100277);
            return true;
        } else {
            AppMethodBeat.o(100277);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.previewimageview.b, com.tencent.mm.plugin.sns.ui.previewimageview.d
    public final boolean aag(int i2) {
        AppMethodBeat.i(100278);
        if (i2 < this.FbA) {
            AppMethodBeat.o(100278);
            return false;
        } else if (!this.FbD) {
            boolean aag = super.aag(i2);
            AppMethodBeat.o(100278);
            return aag;
        } else if (i2 != getCount() - 1) {
            AppMethodBeat.o(100278);
            return true;
        } else {
            AppMethodBeat.o(100278);
            return false;
        }
    }
}
