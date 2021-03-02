package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.d;
import java.util.ArrayList;
import java.util.List;

public class MultiTabView extends LinearLayout implements n {
    private List<View> QEd;
    private View QEe;
    private GridLayout QEf;
    private a QEg;
    private int bxP;
    private q uP;
    private o wqs;
    private CustomViewPager xYa;

    public interface a {
    }

    public MultiTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MultiTabView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(164227);
        this.QEd = new ArrayList();
        this.wqs = new o(this);
        this.bxP = -1;
        this.QEf = new GridLayout(getContext());
        this.QEf.setRowCount(1);
        setOrientation(1);
        this.xYa = new CustomViewPager(getContext());
        this.uP = new d(getContext()) {
            /* class com.tencent.mm.ui.widget.MultiTabView.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.d
            public final View a(View view, ViewGroup viewGroup, int i2) {
                AppMethodBeat.i(164223);
                View view2 = (View) MultiTabView.this.QEd.get(i2);
                AppMethodBeat.o(164223);
                return view2;
            }

            @Override // com.tencent.mm.ui.base.d
            public final void Te(int i2) {
            }

            @Override // com.tencent.mm.ui.base.d
            public final int evg() {
                AppMethodBeat.i(164224);
                int size = MultiTabView.this.QEd.size();
                AppMethodBeat.o(164224);
                return size;
            }

            @Override // android.support.v4.view.q
            public final int getCount() {
                AppMethodBeat.i(164225);
                int size = MultiTabView.this.QEd.size();
                AppMethodBeat.o(164225);
                return size;
            }
        };
        this.xYa.setAdapter(this.uP);
        this.xYa.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.tencent.mm.ui.widget.MultiTabView.AnonymousClass2 */

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                AppMethodBeat.i(164226);
                if (i2 != MultiTabView.this.bxP) {
                    if (MultiTabView.this.QEg != null) {
                        a unused = MultiTabView.this.QEg;
                    }
                    MultiTabView.this.bxP = i2;
                }
                AppMethodBeat.o(164226);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i2) {
            }
        });
        addView(this.QEf, new LinearLayout.LayoutParams(-1, -2));
        addView(this.xYa, new LinearLayout.LayoutParams(-1, -2));
        AppMethodBeat.o(164227);
    }

    public int getSelectedIndex() {
        return this.bxP;
    }

    public void setTabListener(a aVar) {
        this.QEg = aVar;
    }

    @Override // android.support.v4.view.n
    public final boolean a(View view, View view2, int i2, int i3) {
        return true;
    }

    @Override // android.support.v4.view.n
    public final void b(View view, View view2, int i2, int i3) {
        this.wqs.Qb = i2;
    }

    @Override // android.support.v4.view.n
    public final void k(View view, int i2) {
        this.wqs.Qb = 0;
    }

    @Override // android.support.v4.view.n
    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
    }

    private void aov(int i2) {
        AppMethodBeat.i(164231);
        ViewGroup.LayoutParams layoutParams = this.xYa.getLayoutParams();
        if (layoutParams.height == -2) {
            layoutParams.height = this.xYa.getHeight() + i2;
        } else {
            layoutParams.height += i2;
        }
        this.xYa.setLayoutParams(layoutParams);
        AppMethodBeat.o(164231);
    }

    @Override // android.support.v4.view.n
    public final void a(View view, int i2, int i3, int[] iArr, int i4) {
        AppMethodBeat.i(164232);
        if (this.QEe != null) {
            Rect rect = new Rect();
            this.QEe.getLocalVisibleRect(rect);
            if (Math.abs(i2) - Math.abs(i3) > 0) {
                iArr[1] = i3;
                AppMethodBeat.o(164232);
                return;
            }
            if (i3 > 0 && !view.canScrollVertically(-1) && rect.bottom > 0) {
                Log.d("MicroMsg.MultiTabView", "scrollUp topBar, dy %d topBar visible rect %s", Integer.valueOf(i3), rect);
                iArr[1] = Math.min(i3, rect.height());
                aov(iArr[1]);
                scrollBy(0, iArr[1]);
            }
            if (i3 < 0 && !view.canScrollVertically(-1) && rect.top != 0) {
                Log.d("MicroMsg.MultiTabView", "scrollDown topBar, dy %d topBar visible rect %s", Integer.valueOf(i3), rect);
                iArr[1] = Math.max(i3, -Math.abs(rect.top));
                aov(iArr[1]);
                scrollBy(0, iArr[1]);
            }
        }
        AppMethodBeat.o(164232);
    }
}
