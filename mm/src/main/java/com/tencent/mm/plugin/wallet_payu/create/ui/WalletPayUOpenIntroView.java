package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.ArrayList;

public class WalletPayUOpenIntroView extends LinearLayout {
    private MMAutoHeightViewPager Iti;
    private MMPageControlView Itj;
    private a Itk;
    private d[] Itl;
    private ArrayList<View> axq;
    private Context mContext;

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(72033);
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.bhp, (ViewGroup) this, true);
        this.Iti = (MMAutoHeightViewPager) inflate.findViewById(R.id.g8f);
        this.Itj = (MMPageControlView) inflate.findViewById(R.id.bft);
        this.Itj.setVisibility(0);
        this.Iti.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUOpenIntroView.AnonymousClass1 */

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                AppMethodBeat.i(72029);
                if (WalletPayUOpenIntroView.this.Iti.getParent() != null) {
                    WalletPayUOpenIntroView.this.Iti.getParent().requestDisallowInterceptTouchEvent(true);
                }
                WalletPayUOpenIntroView.this.Itj.setPage(i2);
                AppMethodBeat.o(72029);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i2) {
            }
        });
        AppMethodBeat.o(72033);
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setPagerData(d[] dVarArr) {
        AppMethodBeat.i(72034);
        this.Itl = dVarArr;
        this.axq = new ArrayList<>();
        if (this.Itl != null) {
            for (int i2 = 0; i2 < this.Itl.length; i2++) {
                this.axq.add(LayoutInflater.from(this.mContext).inflate(R.layout.bhq, (ViewGroup) null));
            }
        }
        this.Itk = new a(this, (byte) 0);
        this.Iti.setAdapter(this.Itk);
        this.Itj.kX(this.Itl == null ? 0 : this.Itl.length, 0);
        AppMethodBeat.o(72034);
    }

    /* access modifiers changed from: package-private */
    public class a extends q {
        private a() {
        }

        /* synthetic */ a(WalletPayUOpenIntroView walletPayUOpenIntroView, byte b2) {
            this();
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            AppMethodBeat.i(72030);
            if (WalletPayUOpenIntroView.this.Itl == null) {
                AppMethodBeat.o(72030);
                return 0;
            }
            int length = WalletPayUOpenIntroView.this.Itl.length;
            AppMethodBeat.o(72030);
            return length;
        }

        @Override // android.support.v4.view.q
        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(72031);
            View view = (View) WalletPayUOpenIntroView.this.axq.get(i2);
            viewGroup.addView(view);
            d dVar = WalletPayUOpenIntroView.this.Itl[i2];
            ((ImageView) view.findViewById(R.id.esi)).setImageResource(dVar.Itg);
            ((TextView) view.findViewById(R.id.io4)).setText(dVar.titleRes);
            ((TextView) view.findViewById(R.id.dpc)).setText(dVar.Ith);
            AppMethodBeat.o(72031);
            return view;
        }

        @Override // android.support.v4.view.q
        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.q
        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(72032);
            viewGroup.removeView((View) WalletPayUOpenIntroView.this.axq.get(i2));
            AppMethodBeat.o(72032);
        }
    }
}
