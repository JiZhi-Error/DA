package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.scanner.model.b;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g extends Preference {
    List<b.a> Bar = null;
    private Context mContext = null;
    private View mView = null;

    public g(Context context) {
        super(context);
        AppMethodBeat.i(51840);
        this.mContext = context;
        setLayoutResource(R.layout.bix);
        AppMethodBeat.o(51840);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(51841);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(51841);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(51842);
        super.onBindView(view);
        b bVar = new b();
        ((GridView) this.mView.findViewById(R.id.f6a)).setAdapter((ListAdapter) bVar);
        if (this.Bar != null) {
            bVar.gD(this.Bar);
        }
        AppMethodBeat.o(51842);
    }

    /* access modifiers changed from: package-private */
    public final class b extends BaseAdapter implements u.a {
        private Map<String, WeakReference<ImageView>> CKQ = new HashMap();
        private int CKT;
        private List<b.a> CKU = new ArrayList();
        private LayoutInflater mInflater = null;

        public b() {
            AppMethodBeat.i(51834);
            this.mInflater = LayoutInflater.from(g.this.mContext);
            u.a(this);
            this.CKT = g.this.mContext.getResources().getColor(R.color.u9);
            AppMethodBeat.o(51834);
        }

        public final void gD(List<b.a> list) {
            AppMethodBeat.i(51835);
            this.CKQ.clear();
            this.CKU.clear();
            this.CKU = list;
            notifyDataSetChanged();
            AppMethodBeat.o(51835);
        }

        public final int getCount() {
            AppMethodBeat.i(51836);
            int size = this.CKU.size();
            AppMethodBeat.o(51836);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(51837);
            b.a aVar = this.CKU.get(i2);
            AppMethodBeat.o(51837);
            return aVar;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(51838);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.biy, viewGroup, false);
                aVar = new a();
                aVar.CJe = (ImageView) view.findViewById(R.id.dl2);
                aVar.jVn = (TextView) view.findViewById(R.id.dl1);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            final b.a aVar2 = this.CKU.get(i2);
            Bitmap a2 = u.a(new a(aVar2.iconUrl));
            if (a2 == null || a2.isRecycled()) {
                aVar.CJe.setBackgroundColor(this.CKT);
                aVar.CJe.setImageBitmap(null);
            } else {
                aVar.CJe.setImageBitmap(a2);
                aVar.CJe.setBackgroundColor(0);
            }
            final String str = aVar2.CEN;
            aVar.CJe.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.scanner.ui.g.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(51832);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductGridPreference$ProductGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.kernel.g.azz().a(new p(str, aVar2.CEM, aVar2.type, str, b.this.getCount(), aVar2.dDG), 0);
                    if (!Util.isNullOrNil(str)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_Product_ID", str);
                        c.b(((Preference) g.this).mContext, "scanner", ".ui.ProductUI", intent);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductGridPreference$ProductGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(51832);
                }
            });
            aVar.CJe.setTag(aVar2.iconUrl);
            this.CKQ.put(aVar2.iconUrl, new WeakReference<>(aVar.CJe));
            aVar.jVn.setText(aVar2.name);
            AppMethodBeat.o(51838);
            return view;
        }

        class a {
            ImageView CJe;
            TextView jVn;

            a() {
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
            r0 = r4.CKQ.get(r5).get();
         */
        @Override // com.tencent.mm.platformtools.u.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void k(java.lang.String r5, final android.graphics.Bitmap r6) {
            /*
                r4 = this;
                r3 = 51839(0xca7f, float:7.2642E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                if (r6 == 0) goto L_0x0053
                boolean r0 = r6.isRecycled()
                if (r0 != 0) goto L_0x0053
                boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r5)
                if (r0 != 0) goto L_0x0053
                java.lang.String r0 = "MicroMsg.ProductGridPreference"
                java.lang.String r1 = "On get pic, notifyKey="
                java.lang.String r2 = java.lang.String.valueOf(r5)
                java.lang.String r1 = r1.concat(r2)
                com.tencent.mm.sdk.platformtools.Log.v(r0, r1)
                java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.widget.ImageView>> r0 = r4.CKQ
                java.lang.Object r0 = r0.get(r5)
                java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
                if (r0 == 0) goto L_0x0053
                java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.widget.ImageView>> r0 = r4.CKQ
                java.lang.Object r0 = r0.get(r5)
                java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
                java.lang.Object r0 = r0.get()
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                if (r0 == 0) goto L_0x0053
                java.lang.Object r1 = r0.getTag()
                java.lang.String r1 = (java.lang.String) r1
                boolean r1 = r5.equals(r1)
                if (r1 == 0) goto L_0x0053
                com.tencent.mm.plugin.scanner.ui.g$b$2 r1 = new com.tencent.mm.plugin.scanner.ui.g$b$2
                r1.<init>(r0, r6)
                com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r1)
            L_0x0053:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.g.b.k(java.lang.String, android.graphics.Bitmap):void");
        }
    }

    static final class a implements s {
        private String mPicUrl = null;

        public a(String str) {
            this.mPicUrl = str;
        }

        @Override // com.tencent.mm.platformtools.s
        public final String blA() {
            AppMethodBeat.i(51829);
            String jP = j.eOR().jP(this.mPicUrl, "@S");
            AppMethodBeat.o(51829);
            return jP;
        }

        @Override // com.tencent.mm.platformtools.s
        public final String blB() {
            return this.mPicUrl;
        }

        @Override // com.tencent.mm.platformtools.s
        public final String blC() {
            return this.mPicUrl;
        }

        @Override // com.tencent.mm.platformtools.s
        public final String getCacheKey() {
            return this.mPicUrl;
        }

        @Override // com.tencent.mm.platformtools.s
        public final boolean blD() {
            return false;
        }

        @Override // com.tencent.mm.platformtools.s
        public final boolean blE() {
            return false;
        }

        @Override // com.tencent.mm.platformtools.s
        public final Bitmap a(Bitmap bitmap, s.a aVar, String str) {
            AppMethodBeat.i(51830);
            if (s.a.NET == aVar) {
                try {
                    BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.ProductGridPreference", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(51830);
            return bitmap;
        }

        @Override // com.tencent.mm.platformtools.s
        public final void blG() {
        }

        @Override // com.tencent.mm.platformtools.s
        public final void ad(String str, boolean z) {
        }

        @Override // com.tencent.mm.platformtools.s
        public final void a(s.a aVar, String str) {
        }

        @Override // com.tencent.mm.platformtools.s
        public final Bitmap blF() {
            AppMethodBeat.i(51831);
            if (MMApplicationContext.getContext() == null) {
                AppMethodBeat.o(51831);
                return null;
            }
            Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
            AppMethodBeat.o(51831);
            return decodeResource;
        }

        @Override // com.tencent.mm.platformtools.s
        public final s.b blz() {
            return null;
        }
    }
}
