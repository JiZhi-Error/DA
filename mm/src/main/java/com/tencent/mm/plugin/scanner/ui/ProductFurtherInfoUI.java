package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.scanner.model.r;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductFurtherInfoUI extends MMPreference {
    private MMPageControlView CKK;
    private n.a.C1680a CKL;
    private String CKM;
    private ViewPager Qp;
    protected f nRm;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(51827);
        super.onCreate(bundle);
        n.a fn = r.fn(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (fn == null || fn.CUy == null) {
            Log.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
            finish();
            AppMethodBeat.o(51827);
            return;
        }
        this.CKL = fn.CUy;
        this.CKM = fn.field_feedbackurl;
        initView();
        AppMethodBeat.o(51827);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(51828);
        setMMTitle(getIntent().getStringExtra("key_title"));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(51815);
                ProductFurtherInfoUI.this.finish();
                AppMethodBeat.o(51815);
                return false;
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(51817);
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                linkedList.add(ProductFurtherInfoUI.this.getString(R.string.gdo));
                linkedList2.add(0);
                h.b(ProductFurtherInfoUI.this.getContext(), "", linkedList, linkedList2, "", new h.e() {
                    /* class com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.e
                    public final void cy(int i2, int i3) {
                        AppMethodBeat.i(51816);
                        switch (i3) {
                            case 0:
                                if (!Util.isNullOrNil(ProductFurtherInfoUI.this.CKM)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", ProductFurtherInfoUI.this.CKM);
                                    c.b(ProductFurtherInfoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.o(51816);
                    }
                });
                AppMethodBeat.o(51817);
                return true;
            }
        });
        this.nRm = getPreferenceScreen();
        ArrayList arrayList = new ArrayList();
        Iterator<n.a.C1680a.C1681a> it = this.CKL.CUz.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().link);
        }
        this.Qp = (ViewPager) findViewById(R.id.g8f);
        this.CKK = (MMPageControlView) findViewById(R.id.dxu);
        this.CKK.setIndicatorLayoutRes(R.layout.bh8);
        this.CKK.setVisibility(0);
        this.Qp.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(51818);
                if (!(view == null || view.getParent() == null)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                AppMethodBeat.o(51818);
                return false;
            }
        });
        this.Qp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.AnonymousClass4 */

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                AppMethodBeat.i(51819);
                if (ProductFurtherInfoUI.this.Qp.getParent() != null) {
                    ProductFurtherInfoUI.this.Qp.getParent().requestDisallowInterceptTouchEvent(true);
                }
                ProductFurtherInfoUI.this.CKK.setPage(i2);
                AppMethodBeat.o(51819);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i2) {
            }
        });
        a aVar = new a(this);
        this.Qp.setAdapter(aVar);
        if (arrayList.size() > 0) {
            aVar.CKP = arrayList;
            ProductFurtherInfoUI.this.CKK.kX(arrayList.size(), 0);
            aVar.notifyDataSetChanged();
            this.Qp.setVisibility(0);
        }
        for (int i2 = 0; i2 < this.CKL.CUA.size(); i2++) {
            n.a.C1680a.b bVar = this.CKL.CUA.get(i2);
            Preference preference = new Preference(this);
            preference.setKey(String.valueOf(i2));
            preference.setLayoutResource(R.layout.bch);
            preference.setTitle(bVar.title);
            preference.setSummary(bVar.desc);
            this.nRm.c(preference);
        }
        this.nRm.notifyDataSetChanged();
        AppMethodBeat.o(51828);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bu;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.base.preference.MMPreference
    public int getLayoutId() {
        return R.layout.biu;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getHeaderResourceId() {
        return R.layout.biv;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public class a extends q implements u.a {
        List<String> CKP = new ArrayList();
        private Map<String, ImageView> CKQ = new HashMap();
        private int CKR;
        private Context mContext;

        public a(Context context) {
            AppMethodBeat.i(51821);
            this.mContext = context;
            u.a(this);
            this.CKR = this.mContext.getResources().getColor(R.color.uk);
            AppMethodBeat.o(51821);
        }

        private ImageView aMI(String str) {
            AppMethodBeat.i(51822);
            if (this.CKQ.containsKey(str)) {
                ImageView imageView = this.CKQ.get(str);
                AppMethodBeat.o(51822);
                return imageView;
            }
            ImageView imageView2 = new ImageView(this.mContext);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.CKQ.put(str, imageView2);
            AppMethodBeat.o(51822);
            return imageView2;
        }

        @Override // android.support.v4.view.q
        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(51823);
            String str = this.CKP.get(i2);
            ImageView aMI = aMI(str);
            Bitmap a2 = u.a(new com.tencent.mm.plugin.scanner.util.q(str));
            if (a2 == null || a2.isRecycled()) {
                aMI.setImageBitmap(null);
                aMI.setBackgroundColor(this.CKR);
            } else {
                aMI.setImageBitmap(a2);
                aMI.setBackgroundColor(0);
            }
            try {
                viewGroup.addView(aMI);
            } catch (Exception e2) {
                Log.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + e2.getMessage());
            }
            AppMethodBeat.o(51823);
            return aMI;
        }

        @Override // android.support.v4.view.q
        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(51824);
            viewGroup.removeView((ImageView) obj);
            String str = this.CKP.get(i2);
            if (this.CKQ.containsKey(str)) {
                this.CKQ.remove(str);
            }
            AppMethodBeat.o(51824);
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            AppMethodBeat.i(51825);
            int size = this.CKP.size();
            AppMethodBeat.o(51825);
            return size;
        }

        @Override // android.support.v4.view.q
        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
            r0 = aMI(r4);
         */
        @Override // com.tencent.mm.platformtools.u.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void k(java.lang.String r4, final android.graphics.Bitmap r5) {
            /*
                r3 = this;
                r2 = 51826(0xca72, float:7.2624E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r5 == 0) goto L_0x0022
                boolean r0 = r5.isRecycled()
                if (r0 != 0) goto L_0x0022
                boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r4)
                if (r0 != 0) goto L_0x0022
                android.widget.ImageView r0 = r3.aMI(r4)
                if (r0 == 0) goto L_0x0022
                com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI$a$1 r1 = new com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI$a$1
                r1.<init>(r0, r5)
                com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r1)
            L_0x0022:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.a.k(java.lang.String, android.graphics.Bitmap):void");
        }
    }
}
