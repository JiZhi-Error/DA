package com.tencent.mm.ui.widget.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class AnimatedExpandableListView extends ExpandableListView {
    private static final String TAG = a.class.getSimpleName();
    private a QRl;

    static /* synthetic */ int a(AnimatedExpandableListView animatedExpandableListView) {
        AppMethodBeat.i(159431);
        int animationDuration = animatedExpandableListView.getAnimationDuration();
        AppMethodBeat.o(159431);
        return animationDuration;
    }

    static {
        AppMethodBeat.i(159432);
        AppMethodBeat.o(159432);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.widget.ExpandableListView
    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        AppMethodBeat.i(159428);
        super.setAdapter(expandableListAdapter);
        if (expandableListAdapter instanceof a) {
            this.QRl = (a) expandableListAdapter;
            this.QRl.QRn = this;
            AppMethodBeat.o(159428);
            return;
        }
        ClassCastException classCastException = new ClassCastException(expandableListAdapter.toString() + " must implement AnimatedExpandableListAdapter");
        AppMethodBeat.o(159428);
        throw classCastException;
    }

    @SuppressLint({"NewApi"})
    public final boolean api(int i2) {
        int firstVisiblePosition;
        AppMethodBeat.i(159429);
        int flatListPosition = getFlatListPosition(getPackedPositionForGroup(i2));
        if (flatListPosition == -1 || (firstVisiblePosition = flatListPosition - getFirstVisiblePosition()) >= getChildCount() || getChildAt(firstVisiblePosition).getBottom() < getBottom()) {
            a.a(this.QRl, i2);
            boolean expandGroup = expandGroup(i2);
            AppMethodBeat.o(159429);
            return expandGroup;
        }
        this.QRl.apl(i2);
        boolean expandGroup2 = expandGroup(i2);
        AppMethodBeat.o(159429);
        return expandGroup2;
    }

    public final boolean apj(int i2) {
        AppMethodBeat.i(159430);
        int flatListPosition = getFlatListPosition(getPackedPositionForGroup(i2));
        if (flatListPosition != -1) {
            int firstVisiblePosition = flatListPosition - getFirstVisiblePosition();
            if (firstVisiblePosition < 0 || firstVisiblePosition >= getChildCount()) {
                boolean collapseGroup = collapseGroup(i2);
                AppMethodBeat.o(159430);
                return collapseGroup;
            } else if (getChildAt(firstVisiblePosition).getBottom() >= getBottom()) {
                boolean collapseGroup2 = collapseGroup(i2);
                AppMethodBeat.o(159430);
                return collapseGroup2;
            }
        }
        long expandableListPosition = getExpandableListPosition(getFirstVisiblePosition());
        int packedPositionChild = getPackedPositionChild(expandableListPosition);
        int packedPositionGroup = getPackedPositionGroup(expandableListPosition);
        if (packedPositionChild == -1 || packedPositionGroup != i2) {
            packedPositionChild = 0;
        }
        a.a(this.QRl, i2, packedPositionChild);
        this.QRl.notifyDataSetChanged();
        boolean isGroupExpanded = isGroupExpanded(i2);
        AppMethodBeat.o(159430);
        return isGroupExpanded;
    }

    private int getAnimationDuration() {
        return 150;
    }

    /* access modifiers changed from: package-private */
    public static class d {
        boolean DMe;
        boolean QRw;
        int QRx;
        int QRy;

        private d() {
            this.DMe = false;
            this.QRw = false;
            this.QRy = -1;
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    public static abstract class a extends BaseExpandableListAdapter {
        private SparseArray<d> QRm = new SparseArray<>();
        private AnimatedExpandableListView QRn;

        public abstract int ZO(int i2);

        public abstract View d(int i2, int i3, View view);

        static /* synthetic */ void a(a aVar, int i2) {
            d apk = aVar.apk(i2);
            apk.DMe = true;
            apk.QRx = 0;
            apk.QRw = true;
        }

        private d apk(int i2) {
            d dVar = this.QRm.get(i2);
            if (dVar != null) {
                return dVar;
            }
            d dVar2 = new d((byte) 0);
            this.QRm.put(i2, dVar2);
            return dVar2;
        }

        public final void apl(int i2) {
            apk(i2).QRy = -1;
        }

        public final int getChildType(int i2, int i3) {
            if (apk(i2).DMe) {
                return 0;
            }
            return 1;
        }

        public final int getChildTypeCount() {
            return 2;
        }

        public final View getChildView(final int i2, int i3, boolean z, View view, ViewGroup viewGroup) {
            View view2;
            int intValue;
            final d apk = apk(i2);
            if (!apk.DMe) {
                return d(i2, i3, view);
            }
            if (!(view instanceof b)) {
                view2 = new b(viewGroup.getContext(), (byte) 0);
                view2.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
            } else {
                view2 = view;
            }
            if (i3 < apk.QRx) {
                view2.getLayoutParams().height = 0;
                return view2;
            }
            final ExpandableListView expandableListView = (ExpandableListView) viewGroup;
            final b bVar = (b) view2;
            bVar.uZF.clear();
            b.a(bVar, expandableListView.getDivider(), viewGroup.getMeasuredWidth(), expandableListView.getDividerHeight());
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int i4 = 0;
            int height = viewGroup.getHeight();
            int ZO = ZO(i2);
            int i5 = apk.QRx;
            while (true) {
                if (i5 >= ZO) {
                    break;
                }
                View d2 = d(i2, i5, null);
                d2.measure(makeMeasureSpec, makeMeasureSpec2);
                i4 += d2.getMeasuredHeight();
                if (i4 >= height) {
                    bVar.hy(d2);
                    i4 += ((ZO - i5) - 1) * (i4 / (i5 + 1));
                    break;
                }
                bVar.hy(d2);
                i5++;
            }
            Object tag = bVar.getTag();
            if (tag == null) {
                intValue = 0;
            } else {
                intValue = ((Integer) tag).intValue();
            }
            if (apk.QRw && intValue != 1) {
                c cVar = new c(bVar, 0, i4, apk, (byte) 0);
                cVar.setDuration((long) AnimatedExpandableListView.a(this.QRn));
                cVar.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a.AnonymousClass1 */

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(159418);
                        a.b(a.this, i2);
                        a.this.notifyDataSetChanged();
                        bVar.setTag(0);
                        AppMethodBeat.o(159418);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                bVar.startAnimation(cVar);
                bVar.setTag(1);
                return view2;
            } else if (apk.QRw || intValue == 2) {
                return view2;
            } else {
                if (apk.QRy == -1) {
                    apk.QRy = i4;
                }
                c cVar2 = new c(bVar, apk.QRy, 0, apk, (byte) 0);
                cVar2.setDuration((long) AnimatedExpandableListView.a(this.QRn));
                cVar2.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a.AnonymousClass2 */

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(159419);
                        a.b(a.this, i2);
                        expandableListView.collapseGroup(i2);
                        a.this.notifyDataSetChanged();
                        apk.QRy = -1;
                        bVar.setTag(0);
                        AppMethodBeat.o(159419);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                bVar.startAnimation(cVar2);
                bVar.setTag(2);
                return view2;
            }
        }

        public final int getChildrenCount(int i2) {
            d apk = apk(i2);
            if (apk.DMe) {
                return apk.QRx + 1;
            }
            return ZO(i2);
        }

        static /* synthetic */ void a(a aVar, int i2, int i3) {
            d apk = aVar.apk(i2);
            apk.DMe = true;
            apk.QRx = i3;
            apk.QRw = false;
        }

        static /* synthetic */ void b(a aVar, int i2) {
            aVar.apk(i2).DMe = false;
        }
    }

    static class b extends View {
        private int QRs;
        private int dividerHeight;
        private Drawable kjR;
        List<View> uZF;

        /* synthetic */ b(Context context, byte b2) {
            this(context);
        }

        private b(Context context) {
            super(context);
            AppMethodBeat.i(159420);
            this.uZF = new ArrayList();
            AppMethodBeat.o(159420);
        }

        public final void hy(View view) {
            AppMethodBeat.i(159421);
            view.layout(0, 0, getWidth(), getHeight());
            this.uZF.add(view);
            AppMethodBeat.o(159421);
        }

        /* access modifiers changed from: protected */
        public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(159422);
            super.onLayout(z, i2, i3, i4, i5);
            int size = this.uZF.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.uZF.get(i6).layout(i2, i3, i4, i5);
            }
            AppMethodBeat.o(159422);
        }

        public final void dispatchDraw(Canvas canvas) {
            AppMethodBeat.i(159423);
            canvas.save();
            if (this.kjR != null) {
                this.kjR.setBounds(0, 0, this.QRs, this.dividerHeight);
            }
            int size = this.uZF.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.uZF.get(i2);
                view.draw(canvas);
                canvas.translate(0.0f, (float) view.getMeasuredHeight());
                if (this.kjR != null) {
                    this.kjR.draw(canvas);
                    canvas.translate(0.0f, (float) this.dividerHeight);
                }
            }
            canvas.restore();
            AppMethodBeat.o(159423);
        }

        static /* synthetic */ void a(b bVar, Drawable drawable, int i2, int i3) {
            AppMethodBeat.i(159424);
            if (drawable != null) {
                bVar.kjR = drawable;
                bVar.QRs = i2;
                bVar.dividerHeight = i3;
                drawable.setBounds(0, 0, i2, i3);
            }
            AppMethodBeat.o(159424);
        }
    }

    static class c extends Animation {
        private int QRt;
        private int QRu;
        private d QRv;
        private View view;

        /* synthetic */ c(View view2, int i2, int i3, d dVar, byte b2) {
            this(view2, i2, i3, dVar);
        }

        private c(View view2, int i2, int i3, d dVar) {
            AppMethodBeat.i(159426);
            this.QRt = i2;
            this.QRu = i3 - i2;
            this.view = view2;
            this.QRv = dVar;
            this.view.getLayoutParams().height = i2;
            this.view.requestLayout();
            AppMethodBeat.o(159426);
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f2, Transformation transformation) {
            AppMethodBeat.i(159427);
            super.applyTransformation(f2, transformation);
            if (f2 < 1.0f) {
                int i2 = this.QRt + ((int) (((float) this.QRu) * f2));
                this.view.getLayoutParams().height = i2;
                this.QRv.QRy = i2;
                this.view.requestLayout();
                AppMethodBeat.o(159427);
                return;
            }
            int i3 = this.QRt + this.QRu;
            this.view.getLayoutParams().height = i3;
            this.QRv.QRy = i3;
            this.view.requestLayout();
            AppMethodBeat.o(159427);
        }
    }
}
