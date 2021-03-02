package com.tencent.mm.ui.widget.b;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;

public class a implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
    private static int kuv;
    private static int kuw;
    private static boolean vUN = false;
    public o.g HLY;
    private m HMc;
    private View PHi = null;
    private MMListPopupWindow Pfj;
    public AbstractC2139a QSA;
    public boolean QSB = true;
    public boolean QSC = false;
    private b QSm = null;
    private p QSn;
    private p QSo;
    private int QSp;
    private boolean QSq = false;
    public View QSr;
    public View.OnCreateContextMenuListener QSs;
    public o.e QSt;
    public boolean QSu = false;
    public boolean QSv = false;
    public boolean QSw = false;
    public boolean QSx = false;
    public boolean QSy = true;
    private boolean QSz = true;
    public PopupWindow.OnDismissListener QwU;
    private DisplayMetrics dfz;
    private Context mContext = null;
    private LayoutInflater mInflater;
    public long startTime = 0;
    private View yTH;

    /* renamed from: com.tencent.mm.ui.widget.b.a$a  reason: collision with other inner class name */
    public interface AbstractC2139a {
        View a(Context context, MenuItem menuItem);
    }

    public a(Context context, View view) {
        AppMethodBeat.i(159474);
        this.mContext = context;
        this.PHi = view;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        initView();
        hcc();
        AppMethodBeat.o(159474);
    }

    public a(Context context) {
        AppMethodBeat.i(159475);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        initView();
        AppMethodBeat.o(159475);
    }

    public final void a(View.OnCreateContextMenuListener onCreateContextMenuListener) {
        this.QSs = onCreateContextMenuListener;
    }

    public final void a(o.g gVar) {
        this.HLY = gVar;
    }

    public final void c(View view, final View.OnCreateContextMenuListener onCreateContextMenuListener, o.g gVar) {
        AppMethodBeat.i(159476);
        this.PHi = view;
        hcc();
        this.HLY = gVar;
        if (view instanceof AbsListView) {
            as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
            ((AbsListView) view).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.ui.widget.b.a.AnonymousClass1 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(159465);
                    a.this.HMc.clear();
                    as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
                    AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(view, i2, j2);
                    onCreateContextMenuListener.onCreateContextMenu(a.this.HMc, view, adapterContextMenuInfo);
                    Iterator<MenuItem> it = a.this.HMc.ORD.iterator();
                    while (it.hasNext()) {
                        ((n) it.next()).ORH = adapterContextMenuInfo;
                    }
                    a.this.ez(0, 0);
                    AppMethodBeat.o(159465);
                    return true;
                }
            });
            AppMethodBeat.o(159476);
            return;
        }
        as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.ui.widget.b.a.AnonymousClass2 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(159466);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
                a.this.HMc.clear();
                a.this.PHi = view;
                onCreateContextMenuListener.onCreateContextMenu(a.this.HMc, view, null);
                if (view.getTag(R.id.iu_) instanceof int[]) {
                    int[] iArr = (int[]) view.getTag(R.id.iu_);
                    if (iArr == null) {
                        a.this.ez(0, 0);
                    } else {
                        a.this.ez(iArr[0], iArr[1]);
                    }
                } else {
                    a.this.ez(0, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(159466);
                return true;
            }
        });
        AppMethodBeat.o(159476);
    }

    public final void a(final View view, final o.e eVar, o.g gVar) {
        AppMethodBeat.i(198366);
        this.PHi = view;
        hcc();
        this.HLY = gVar;
        if (view instanceof AbsListView) {
            as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
            ((AbsListView) view).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.ui.widget.b.a.AnonymousClass3 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(198360);
                    a.this.HMc.clear();
                    as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
                    AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(view, i2, j2);
                    eVar.a(a.this.HMc, view);
                    Iterator<MenuItem> it = a.this.HMc.ORD.iterator();
                    while (it.hasNext()) {
                        ((n) it.next()).ORH = adapterContextMenuInfo;
                    }
                    a.this.ez(0, 0);
                    AppMethodBeat.o(198360);
                    return true;
                }
            });
            AppMethodBeat.o(198366);
            return;
        }
        as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.ui.widget.b.a.AnonymousClass4 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(198361);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
                a.this.HMc.clear();
                a.this.PHi = view;
                eVar.a(a.this.HMc, view);
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int width = iArr[0] + ((int) (((float) view.getWidth()) / 2.0f));
                int i2 = iArr[1];
                if (width == 0 && i2 == 0) {
                    a.this.ez(0, 0);
                } else {
                    a.this.ez(width, i2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(198361);
                return true;
            }
        });
        AppMethodBeat.o(198366);
    }

    public final void a(View view, int i2, long j2, View.OnCreateContextMenuListener onCreateContextMenuListener, o.g gVar, int i3, int i4) {
        AppMethodBeat.i(159477);
        this.HLY = gVar;
        this.PHi = view;
        hcc();
        this.HMc.clear();
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(view, i2, j2);
        onCreateContextMenuListener.onCreateContextMenu(this.HMc, view, adapterContextMenuInfo);
        Iterator<MenuItem> it = this.HMc.ORD.iterator();
        while (it.hasNext()) {
            ((n) it.next()).ORH = adapterContextMenuInfo;
        }
        if (i3 == 0 && i4 == 0) {
            ez(0, 0);
            AppMethodBeat.o(159477);
            return;
        }
        ez(i3, i4);
        AppMethodBeat.o(159477);
    }

    public final void a(View view, View.OnCreateContextMenuListener onCreateContextMenuListener, o.g gVar, int i2, int i3) {
        AppMethodBeat.i(159478);
        this.HLY = gVar;
        this.PHi = view;
        if (!(view instanceof TextView) && (i2 == 0 || i3 == 0)) {
            hcc();
        }
        this.HMc.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.HMc, view, null);
        if (i2 == 0 && i3 == 0) {
            ez(0, 0);
            AppMethodBeat.o(159478);
            return;
        }
        ez(i2, i3);
        AppMethodBeat.o(159478);
    }

    public final void a(View view, o.e eVar, o.g gVar, int i2, int i3) {
        AppMethodBeat.i(198367);
        this.HLY = gVar;
        this.PHi = view;
        if (!(view instanceof TextView) && (i2 == 0 || i3 == 0)) {
            hcc();
        }
        this.HMc.clear();
        eVar.a(this.HMc, view);
        if (i2 == 0 && i3 == 0) {
            ez(0, 0);
            AppMethodBeat.o(198367);
            return;
        }
        ez(i2, i3);
        AppMethodBeat.o(198367);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean lJ(int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 500
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.b.a.lJ(int, int):boolean");
    }

    private void lK(int i2, int i3) {
        AppMethodBeat.i(159480);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ir);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.hs);
        this.QSn = new p(this.mContext);
        this.QSn.setOnDismissListener(this);
        this.QSn.setWidth(-2);
        this.QSn.setHeight(-2);
        this.QSn.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.coj));
        this.QSn.setFocusable(this.QSw);
        this.QSn.setOutsideTouchable(this.QSx);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(this.mContext.getResources().getColor(R.color.f3048f));
        for (final int i4 = 0; i4 < this.HMc.size(); i4++) {
            TextView textView = (TextView) this.mInflater.inflate(R.layout.auw, (ViewGroup) null, false);
            textView.setBackgroundResource(R.drawable.aol);
            if (i4 == 0) {
                textView.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset, 0);
            } else if (i4 == this.HMc.size() - 1) {
                textView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset2, 0);
            }
            textView.setText(this.HMc.ORD.get(i4).getTitle());
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.widget.b.a.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(198363);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (a.this.HLY != null) {
                        a.this.HLY.onMMMenuItemSelected(a.this.HMc.getItem(i4), i4);
                    }
                    a.this.QSn.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(198363);
                }
            });
            linearLayout.addView(textView);
        }
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = linearLayout.getMeasuredHeight();
        this.QSn.setWidth(linearLayout.getMeasuredWidth() + at.fromDPToPix(this.mContext, 24));
        this.QSn.setContentView(linearLayout);
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing()) {
            this.QSn.showAtLocation(this.PHi, 0, i2, i3 - measuredHeight);
        }
        AppMethodBeat.o(159480);
    }

    private void lL(int i2, int i3) {
        boolean z;
        View view;
        AppMethodBeat.i(198368);
        this.QSo = new p(this.mContext);
        this.QSo.setOnDismissListener(this);
        this.QSo.setWidth(-2);
        this.QSo.setHeight(-2);
        this.QSo.setFocusable(this.QSy);
        this.QSo.setOutsideTouchable(true);
        this.QSo.setAnimationStyle(R.style.s6);
        this.QSo.setInputMethodMode(2);
        View inflate = View.inflate(this.mContext, R.layout.atr, null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.fdb);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.fdc);
        View findViewById = inflate.findViewById(R.id.fd3);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bjj);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.bjk);
        linearLayout.setVisibility(0);
        linearLayout.removeAllViews();
        if (this.HMc.size() > 5) {
            linearLayout2.setVisibility(0);
            linearLayout2.removeAllViews();
            findViewById.setVisibility(0);
        } else {
            int i4 = 0;
            while (true) {
                if (i4 >= this.HMc.size()) {
                    z = false;
                    break;
                } else if (((n) this.HMc.getItem(i4)).ORJ) {
                    z = true;
                    break;
                } else {
                    i4++;
                }
            }
            if (z) {
                linearLayout2.setVisibility(0);
                linearLayout2.removeAllViews();
                findViewById.setVisibility(0);
            }
        }
        for (final int i5 = 0; i5 < this.HMc.size(); i5++) {
            View view2 = null;
            if (this.QSA != null) {
                view2 = this.QSA.a(this.mContext, this.HMc.ORD.get(i5));
            }
            if (view2 == null) {
                View inflate2 = View.inflate(this.mContext, R.layout.big, null);
                WeImageView weImageView = (WeImageView) inflate2.findViewById(R.id.dt5);
                TextView textView = (TextView) inflate2.findViewById(R.id.ipm);
                weImageView.setImageDrawable(this.HMc.ORD.get(i5).getIcon());
                textView.setText(this.HMc.ORD.get(i5).getTitle());
                view = inflate2;
            } else {
                view = view2;
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.widget.b.a.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(198364);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (a.this.HLY != null) {
                        a.this.HLY.onMMMenuItemSelected(a.this.HMc.getItem(i5), i5);
                    }
                    a.this.QSo.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(198364);
                }
            });
            if (((n) this.HMc.ORD.get(i5)).ORJ) {
                if (linearLayout2.getChildCount() < 5) {
                    linearLayout2.addView(view);
                }
            } else if (linearLayout.getChildCount() < 5) {
                linearLayout.addView(view);
            } else if (linearLayout2.getChildCount() < 5) {
                linearLayout2.addView(view);
            }
        }
        this.QSo.setContentView(inflate);
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = inflate.getMeasuredHeight();
        int measuredWidth = inflate.getMeasuredWidth();
        int fromDPToPix = at.fromDPToPix(this.mContext, 12);
        int i6 = i2 - ((int) (((float) measuredWidth) / 2.0f));
        if (i6 + measuredWidth > this.dfz.widthPixels - fromDPToPix) {
            i6 = (this.dfz.widthPixels - fromDPToPix) - measuredWidth;
        } else if (i6 < fromDPToPix) {
            i6 = fromDPToPix;
        }
        int aH = (i3 - measuredHeight) - at.aH(this.mContext, R.dimen.bt);
        if (aH < 0) {
            aH = at.aH(this.mContext, R.dimen.bt) + this.PHi.getHeight() + i3;
            imageView2.setVisibility(0);
            imageView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView2.getLayoutParams();
            layoutParams.leftMargin = (i2 - i6) - at.fromDPToPix(this.mContext, 7);
            imageView2.setLayoutParams(layoutParams);
        } else {
            imageView2.setVisibility(8);
            imageView.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = (i2 - i6) - at.fromDPToPix(this.mContext, 7);
            imageView.setLayoutParams(layoutParams2);
        }
        if (this.HMc.size() == 0) {
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
        }
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing()) {
            this.QSo.showAtLocation(this.PHi, 0, i6, aH);
            this.startTime = System.currentTimeMillis();
        }
        AppMethodBeat.o(198368);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(159481);
        if (this.Pfj == null || !this.Pfj.kuK.isShowing()) {
            AppMethodBeat.o(159481);
            return false;
        }
        AppMethodBeat.o(159481);
        return true;
    }

    private boolean hbZ() {
        AppMethodBeat.i(159482);
        if (this.QSn == null || !this.QSn.isShowing()) {
            AppMethodBeat.o(159482);
            return false;
        }
        AppMethodBeat.o(159482);
        return true;
    }

    public final boolean hca() {
        AppMethodBeat.i(198369);
        if (this.QSo == null || !this.QSo.isShowing()) {
            AppMethodBeat.o(198369);
            return false;
        }
        AppMethodBeat.o(198369);
        return true;
    }

    public final boolean gNq() {
        AppMethodBeat.i(159483);
        if (isShowing()) {
            if (this.Pfj != null) {
                this.Pfj.dismiss();
            }
            AppMethodBeat.o(159483);
            return true;
        } else if (hbZ()) {
            if (this.QSn != null) {
                this.QSn.dismiss();
            }
            AppMethodBeat.o(159483);
            return true;
        } else if (hca()) {
            if (this.QSo != null) {
                this.QSo.dismiss();
            }
            AppMethodBeat.o(159483);
            return true;
        } else {
            AppMethodBeat.o(159483);
            return false;
        }
    }

    public final void hcb() {
        this.QSv = true;
    }

    public final boolean gTx() {
        AppMethodBeat.i(258270);
        boolean ez = ez(0, 0);
        AppMethodBeat.o(258270);
        return ez;
    }

    public boolean ez(int i2, int i3) {
        int i4;
        AppMethodBeat.i(159484);
        if (((this.PHi != null && !this.PHi.equals(this.yTH)) || !vUN) && !(i2 == 0 && i3 == 0)) {
            kuv = i2;
            kuw = i3;
        }
        this.yTH = null;
        int i5 = kuv;
        int i6 = kuw;
        vUN = false;
        if (this.dfz == null) {
            this.dfz = this.mContext.getResources().getDisplayMetrics();
        }
        if (this.PHi != null) {
            int[] iArr = new int[2];
            this.PHi.getLocationOnScreen(iArr);
            if (i5 == 0) {
                i5 = iArr[0] + (this.PHi.getWidth() / 2);
            }
            int i7 = iArr[1];
            int height = iArr[1] + this.PHi.getHeight();
            if (i7 < 0) {
                i7 = 0;
            }
            if (height > this.dfz.heightPixels) {
                height = this.dfz.heightPixels;
            }
            if (i6 == 0) {
                i4 = (i7 + height) / 2;
                as.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4));
                if (isShowing() || !hbZ() || !hca()) {
                    boolean lJ = lJ(i5, i4);
                    AppMethodBeat.o(159484);
                    return lJ;
                }
                boolean lJ2 = lJ(i5, i4) & gNq();
                AppMethodBeat.o(159484);
                return lJ2;
            }
        }
        i4 = i6;
        as.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4));
        if (isShowing()) {
        }
        boolean lJ3 = lJ(i5, i4);
        AppMethodBeat.o(159484);
        return lJ3;
    }

    private void initView() {
        AppMethodBeat.i(159485);
        gNq();
        this.HMc = new m(this.mContext);
        this.QSm = new b(this, (byte) 0);
        this.dfz = this.mContext.getResources().getDisplayMetrics();
        AppMethodBeat.o(159485);
    }

    private void hcc() {
        AppMethodBeat.i(159486);
        this.PHi.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.widget.b.a.AnonymousClass8 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(198365);
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        int unused = a.kuv = (int) motionEvent.getRawX();
                        int unused2 = a.kuw = (int) motionEvent.getRawY();
                        a.this.yTH = a.this.PHi;
                        boolean unused3 = a.vUN = true;
                        as.i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + a.kuv + "y_down=" + a.kuw, new Object[0]);
                        break;
                }
                AppMethodBeat.o(198365);
                return false;
            }
        });
        AppMethodBeat.o(159486);
    }

    private int b(ListAdapter listAdapter) {
        AppMethodBeat.i(159487);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        while (i2 < count) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                view = null;
            } else {
                itemViewType = i3;
            }
            view = listAdapter.getView(i2, view, new FrameLayout(this.mContext));
            if (view != null) {
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i4 = Math.max(i4, view.getMeasuredWidth());
            }
            i2++;
            i3 = itemViewType;
        }
        AppMethodBeat.o(159487);
        return i4;
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(198371);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        bVar.pH(i2);
        bVar.bm(keyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(198371);
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(198372);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(198372);
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.QwU = onDismissListener;
    }

    public void onDismiss() {
        AppMethodBeat.i(159488);
        if (!this.QSq) {
            if (this.QSr != null) {
                this.QSr.setSelected(false);
            } else {
                this.PHi.setSelected(false);
            }
        }
        if (this.QwU != null) {
            this.QwU.onDismiss();
        }
        AppMethodBeat.o(159488);
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(159470);
            int size = a.this.HMc.size();
            AppMethodBeat.o(159470);
            return size;
        }

        private String getItem(int i2) {
            AppMethodBeat.i(159471);
            String str = (String) a.this.HMc.ORD.get(i2).getTitle();
            AppMethodBeat.o(159471);
            return str;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(159472);
            TextView textView = null;
            if (view == null) {
                textView = (TextView) a.this.mInflater.inflate(R.layout.bii, viewGroup, false);
            } else if (view instanceof TextView) {
                textView = (TextView) view;
            }
            String item = getItem(i2);
            if (textView != null) {
                textView.setTag(item);
                textView.setText(item);
                textView.setBackgroundResource(R.drawable.aol);
            }
            AppMethodBeat.o(159472);
            return textView;
        }
    }
}
