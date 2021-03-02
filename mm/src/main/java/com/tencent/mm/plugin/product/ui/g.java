package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.q;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class g extends q {
    private List<String> BaA;
    private ArrayList<b> BaV;
    private boolean BaW;
    a BaX;
    Context mContext;

    public interface a {
        void eDz();
    }

    public g(Context context) {
        this(context, (byte) 0);
    }

    private g(Context context, byte b2) {
        AppMethodBeat.i(66978);
        this.BaW = false;
        this.BaX = null;
        this.mContext = context;
        this.BaA = null;
        setData(this.BaA);
        AppMethodBeat.o(66978);
    }

    private void eDD() {
        AppMethodBeat.i(66979);
        if (this.BaV == null) {
            this.BaV = new ArrayList<>();
        } else {
            this.BaV.clear();
        }
        for (String str : this.BaA) {
            this.BaV.add(new b(str));
        }
        AppMethodBeat.o(66979);
    }

    public final void setData(List<String> list) {
        AppMethodBeat.i(66980);
        if (list != null) {
            if (list.size() > 0) {
                this.BaA = list;
            }
            eDD();
        }
        AppMethodBeat.o(66980);
    }

    @Override // android.support.v4.view.q
    public final int getCount() {
        AppMethodBeat.i(66981);
        if (this.BaA == null) {
            AppMethodBeat.o(66981);
            return 0;
        } else if (this.BaW) {
            AppMethodBeat.o(66981);
            return Integer.MAX_VALUE;
        } else {
            int size = this.BaA.size();
            AppMethodBeat.o(66981);
            return size;
        }
    }

    @Override // android.support.v4.view.q
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.q
    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        AppMethodBeat.i(66982);
        Log.d("MicroMsg.MallProductImageAdapter", "destroy item");
        if (this.BaV != null) {
            viewGroup.removeView(this.BaV.get(i2).dPk);
        }
        AppMethodBeat.o(66982);
    }

    @Override // android.support.v4.view.q
    public final int getItemPosition(Object obj) {
        return -2;
    }

    @Override // android.support.v4.view.q
    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(66983);
        if (this.BaV != null) {
            Log.d("MicroMsg.MallProductImageAdapter", "data valid");
            viewGroup.addView(this.BaV.get(i2).dPk, 0);
            ImageView imageView = this.BaV.get(i2).dPk;
            AppMethodBeat.o(66983);
            return imageView;
        }
        Object instantiateItem = super.instantiateItem(viewGroup, i2);
        AppMethodBeat.o(66983);
        return instantiateItem;
    }

    /* access modifiers changed from: package-private */
    public class b implements u.a {
        public ImageView dPk = null;
        public String url;

        public b(String str) {
            AppMethodBeat.i(66976);
            this.url = str;
            this.dPk = (ImageView) ((LayoutInflater) g.this.mContext.getSystemService("layout_inflater")).inflate(R.layout.bj0, (ViewGroup) null);
            this.dPk.setImageBitmap(u.a(new c(str)));
            this.dPk.setOnClickListener(new View.OnClickListener(g.this) {
                /* class com.tencent.mm.plugin.product.ui.g.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(66974);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductImageAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
                    if (g.this.BaX != null) {
                        g.this.BaX.eDz();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductImageAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66974);
                }
            });
            u.a(this);
            AppMethodBeat.o(66976);
        }

        @Override // com.tencent.mm.platformtools.u.a
        public final void k(String str, final Bitmap bitmap) {
            AppMethodBeat.i(66977);
            Log.d("MicroMsg.MallProductImageAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.url == null) {
                AppMethodBeat.o(66977);
                return;
            }
            if (str.equals(this.url)) {
                this.dPk.post(new Runnable() {
                    /* class com.tencent.mm.plugin.product.ui.g.b.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(66975);
                        b.this.dPk.setImageBitmap(bitmap);
                        AppMethodBeat.o(66975);
                    }
                });
            }
            AppMethodBeat.o(66977);
        }
    }
}
