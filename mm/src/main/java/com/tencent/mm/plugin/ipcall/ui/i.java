package com.tencent.mm.plugin.ipcall.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class i extends AlertDialog implements ViewPager.OnPageChangeListener {
    private CharSequence Hn;
    private TextView Xy;
    private View jBN;
    private Context mContext;
    private MMDotView oxc;
    private b yyK;
    private IPCallShareViewPager yyL;
    private View.OnClickListener yyM;
    private LinkedList<Integer> yyN;

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(25972);
        super.onCreate(bundle);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        setContentView(this.jBN);
        AppMethodBeat.o(25972);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.Hn = charSequence;
        } else {
            this.Hn = null;
        }
    }

    public final void show() {
        int i2 = 0;
        AppMethodBeat.i(25974);
        if (this.yyN == null || this.yyN.size() == 0) {
            AppMethodBeat.o(25974);
            return;
        }
        this.yyL.setOnPageChangeListener(this);
        b bVar = new b();
        bVar.yyO = this.yyM;
        bVar.yyT = this.yyN;
        if (bVar.yyT.size() > 0) {
            bVar.mCount = ((bVar.yyT.size() - 1) / 9) + 1;
        } else {
            bVar.mCount = 0;
        }
        while (i2 < bVar.mCount) {
            View inflate = ((LayoutInflater) i.this.mContext.getSystemService("layout_inflater")).inflate(R.layout.ax7, (ViewGroup) null);
            GridView gridView = (GridView) inflate.findViewById(R.id.e1r);
            ArrayList arrayList = new ArrayList();
            int i3 = i2 * 9;
            while (i3 < bVar.yyT.size() && i3 < (i2 * 9) + 9) {
                arrayList.add(bVar.yyT.get(i3));
                i3++;
            }
            a aVar = new a(i.this.getContext());
            aVar.yyO = bVar.yyO;
            aVar.cvc = arrayList;
            gridView.setAdapter((ListAdapter) aVar);
            bVar.yyU.add(inflate);
            i2++;
        }
        this.yyK = bVar;
        this.yyL.setAdapter(this.yyK);
        this.Xy.setText(this.Hn);
        super.show();
        AppMethodBeat.o(25974);
    }

    public final void dismiss() {
        AppMethodBeat.i(25975);
        try {
            super.dismiss();
            AppMethodBeat.o(25975);
        } catch (Exception e2) {
            Log.e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + e2.getMessage());
            AppMethodBeat.o(25975);
        }
    }

    public class b extends q {
        int mCount = 0;
        View.OnClickListener yyO;
        LinkedList<Integer> yyT;
        ArrayList<View> yyU = new ArrayList<>();

        public b() {
            AppMethodBeat.i(25968);
            AppMethodBeat.o(25968);
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            return this.mCount;
        }

        @Override // android.support.v4.view.q
        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.q
        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(25969);
            Log.v("MicroMsg.IPCallShareDialog", "destroy item: %d", Integer.valueOf(i2));
            viewGroup.removeView((View) obj);
            AppMethodBeat.o(25969);
        }

        @Override // android.support.v4.view.q
        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            View view;
            AppMethodBeat.i(25970);
            if (this.yyU.get(i2) != null) {
                view = this.yyU.get(i2);
            } else {
                view = null;
            }
            if (view != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                if (viewGroup != null) {
                    viewGroup.addView(view, 0);
                }
            }
            AppMethodBeat.o(25970);
            return view;
        }

        @Override // android.support.v4.view.q
        public final int getItemPosition(Object obj) {
            AppMethodBeat.i(25971);
            int itemPosition = super.getItemPosition(obj);
            AppMethodBeat.o(25971);
            return itemPosition;
        }
    }

    public static class a extends BaseAdapter {
        List<Integer> cvc = null;
        private Context mContext;
        View.OnClickListener yyO;

        public a(Context context) {
            AppMethodBeat.i(25964);
            Assert.assertTrue(context != null);
            this.mContext = context;
            AppMethodBeat.o(25964);
        }

        public final int getCount() {
            AppMethodBeat.i(25965);
            if (this.cvc == null) {
                AppMethodBeat.o(25965);
                return 0;
            }
            int size = this.cvc.size();
            AppMethodBeat.o(25965);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(25966);
            if (this.cvc != null) {
                Integer num = this.cvc.get(i2);
                AppMethodBeat.o(25966);
                return num;
            }
            AppMethodBeat.o(25966);
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1449a aVar;
            AppMethodBeat.i(25967);
            if (view == null) {
                view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.ax8, viewGroup, false);
                aVar = new C1449a();
                aVar.yyQ = (RelativeLayout) view.findViewById(R.id.e95);
                aVar.yyR = (TextView) view.findViewById(R.id.e1q);
                aVar.yyS = (ImageView) view.findViewById(R.id.e1p);
                view.setTag(aVar);
            } else {
                aVar = (C1449a) view.getTag();
            }
            Object item = getItem(i2);
            if (item == null) {
                AppMethodBeat.o(25967);
            } else {
                aVar.id = ((Integer) item).intValue();
                IPCallShareCouponCardUI.a(this.mContext, aVar.id, aVar.yyR, aVar.yyS);
                aVar.yyQ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.i.a.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(25963);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareDialog$IPCallShareItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (a.this.yyO != null) {
                            a.this.yyO.onClick(view);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareDialog$IPCallShareItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(25963);
                    }
                });
                AppMethodBeat.o(25967);
            }
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.ipcall.ui.i$a$a  reason: collision with other inner class name */
        public class C1449a {
            int id;
            RelativeLayout yyQ;
            TextView yyR;
            ImageView yyS;

            public C1449a() {
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i2) {
        AppMethodBeat.i(25973);
        if (this.yyK.getCount() <= 1) {
            this.oxc.setVisibility(4);
            AppMethodBeat.o(25973);
            return;
        }
        this.oxc.setVisibility(0);
        this.oxc.setDotCount(this.yyK.getCount());
        this.oxc.setSelectedDot(i2);
        AppMethodBeat.o(25973);
    }
}
