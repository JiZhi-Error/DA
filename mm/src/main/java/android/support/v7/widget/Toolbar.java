package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.d;
import android.support.v4.view.u;
import android.support.v7.a.a;
import android.support.v7.app.ActionBar;
import android.support.v7.view.c;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int Ku;
    private int abH;
    private Context ahr;
    ActionMenuView ahs;
    private boolean ahw;
    private boolean ahx;
    private int aiS;
    o.a aiU;
    h.a aiV;
    TextView ayA;
    private ImageButton ayB;
    private ImageView ayC;
    private Drawable ayD;
    private CharSequence ayE;
    ImageButton ayF;
    View ayG;
    int ayH;
    int ayI;
    int ayJ;
    private int ayK;
    private int ayL;
    private int ayM;
    private int ayN;
    private int ayO;
    ap ayP;
    private int ayQ;
    private int ayR;
    private CharSequence ayS;
    private CharSequence ayT;
    private int ayU;
    private final ArrayList<View> ayV;
    final ArrayList<View> ayW;
    private final int[] ayX;
    b ayY;
    private final ActionMenuView.d ayZ;
    TextView ayz;
    private ba aza;
    private ActionMenuPresenter azb;
    a azc;
    private boolean azd;
    private final Runnable aze;

    public interface b {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return nb();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return d(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.a3h);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Ku = 8388627;
        this.ayV = new ArrayList<>();
        this.ayW = new ArrayList<>();
        this.ayX = new int[2];
        this.ayZ = new ActionMenuView.d() {
            /* class android.support.v7.widget.Toolbar.AnonymousClass1 */

            @Override // android.support.v7.widget.ActionMenuView.d
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.ayY != null) {
                    return Toolbar.this.ayY.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.aze = new Runnable() {
            /* class android.support.v7.widget.Toolbar.AnonymousClass2 */

            public final void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        az a2 = az.a(getContext(), attributeSet, a.C0040a.Toolbar, i2, 0);
        this.ayH = a2.getResourceId(27, 0);
        this.ayI = a2.getResourceId(18, 0);
        this.Ku = a2.getInteger(0, this.Ku);
        this.ayJ = a2.getInteger(2, 48);
        int dimensionPixelOffset = a2.getDimensionPixelOffset(21, 0);
        dimensionPixelOffset = a2.hasValue(26) ? a2.getDimensionPixelOffset(26, dimensionPixelOffset) : dimensionPixelOffset;
        this.ayO = dimensionPixelOffset;
        this.ayN = dimensionPixelOffset;
        this.ayM = dimensionPixelOffset;
        this.ayL = dimensionPixelOffset;
        int dimensionPixelOffset2 = a2.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.ayL = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = a2.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.ayM = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = a2.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.ayN = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = a2.getDimensionPixelOffset(22, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.ayO = dimensionPixelOffset5;
        }
        this.ayK = a2.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = a2.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = a2.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = a2.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = a2.getDimensionPixelSize(8, 0);
        nd();
        this.ayP.aB(dimensionPixelSize, dimensionPixelSize2);
        if (!(dimensionPixelOffset6 == Integer.MIN_VALUE && dimensionPixelOffset7 == Integer.MIN_VALUE)) {
            this.ayP.aA(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.ayQ = a2.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.ayR = a2.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.ayD = a2.getDrawable(4);
        this.ayE = a2.getText(3);
        CharSequence text = a2.getText(20);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = a2.getText(17);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.ahr = getContext();
        setPopupTheme(a2.getResourceId(16, 0));
        Drawable drawable = a2.getDrawable(15);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = a2.getText(14);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = a2.getDrawable(11);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = a2.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (a2.hasValue(28)) {
            setTitleTextColor(a2.getColor(28, -1));
        }
        if (a2.hasValue(19)) {
            setSubtitleTextColor(a2.getColor(19, -1));
        }
        a2.ayy.recycle();
    }

    public void setPopupTheme(int i2) {
        if (this.aiS != i2) {
            this.aiS = i2;
            if (i2 == 0) {
                this.ahr = getContext();
            } else {
                this.ahr = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public int getPopupTheme() {
        return this.aiS;
    }

    public int getTitleMarginStart() {
        return this.ayL;
    }

    public void setTitleMarginStart(int i2) {
        this.ayL = i2;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.ayN;
    }

    public void setTitleMarginTop(int i2) {
        this.ayN = i2;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.ayM;
    }

    public void setTitleMarginEnd(int i2) {
        this.ayM = i2;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.ayO;
    }

    public void setTitleMarginBottom(int i2) {
        this.ayO = i2;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i2) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i2);
        }
        nd();
        ap apVar = this.ayP;
        if (i2 != 1) {
            z = false;
        }
        if (z != apVar.mIsRtl) {
            apVar.mIsRtl = z;
            if (!apVar.avk) {
                apVar.Al = apVar.avi;
                apVar.An = apVar.avj;
            } else if (z) {
                apVar.Al = apVar.Pc != Integer.MIN_VALUE ? apVar.Pc : apVar.avi;
                apVar.An = apVar.avh != Integer.MIN_VALUE ? apVar.avh : apVar.avj;
            } else {
                apVar.Al = apVar.avh != Integer.MIN_VALUE ? apVar.avh : apVar.avi;
                apVar.An = apVar.Pc != Integer.MIN_VALUE ? apVar.Pc : apVar.avj;
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(android.support.v7.c.a.a.l(getContext(), i2));
    }

    public final boolean isOverflowMenuShowing() {
        boolean z;
        if (this.ahs != null) {
            ActionMenuView actionMenuView = this.ahs;
            if (actionMenuView.aiT == null || !actionMenuView.aiT.isOverflowMenuShowing()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean showOverflowMenu() {
        boolean z;
        if (this.ahs != null) {
            ActionMenuView actionMenuView = this.ahs;
            if (actionMenuView.aiT == null || !actionMenuView.aiT.showOverflowMenu()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void a(h hVar, ActionMenuPresenter actionMenuPresenter) {
        if (hVar != null || this.ahs != null) {
            mX();
            h hVar2 = this.ahs.aaQ;
            if (hVar2 != hVar) {
                if (hVar2 != null) {
                    hVar2.b(this.azb);
                    hVar2.b(this.azc);
                }
                if (this.azc == null) {
                    this.azc = new a();
                }
                actionMenuPresenter.aiC = true;
                if (hVar != null) {
                    hVar.a(actionMenuPresenter, this.ahr);
                    hVar.a(this.azc, this.ahr);
                } else {
                    actionMenuPresenter.a(this.ahr, (h) null);
                    this.azc.a(this.ahr, (h) null);
                    actionMenuPresenter.p(true);
                    this.azc.p(true);
                }
                this.ahs.setPopupTheme(this.aiS);
                this.ahs.setPresenter(actionMenuPresenter);
                this.azb = actionMenuPresenter;
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            mV();
            if (!bP(this.ayC)) {
                i(this.ayC, true);
            }
        } else if (this.ayC != null && bP(this.ayC)) {
            removeView(this.ayC);
            this.ayW.remove(this.ayC);
        }
        if (this.ayC != null) {
            this.ayC.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        if (this.ayC != null) {
            return this.ayC.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            mV();
        }
        if (this.ayC != null) {
            this.ayC.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        if (this.ayC != null) {
            return this.ayC.getContentDescription();
        }
        return null;
    }

    private void mV() {
        if (this.ayC == null) {
            this.ayC = new AppCompatImageView(getContext());
        }
    }

    public final void collapseActionView() {
        j jVar = this.azc == null ? null : this.azc.azg;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.ayS;
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.ayz == null) {
                Context context = getContext();
                this.ayz = new AppCompatTextView(context);
                this.ayz.setSingleLine();
                this.ayz.setEllipsize(TextUtils.TruncateAt.END);
                if (this.ayH != 0) {
                    this.ayz.setTextAppearance(context, this.ayH);
                }
                if (this.abH != 0) {
                    this.ayz.setTextColor(this.abH);
                }
            }
            if (!bP(this.ayz)) {
                i(this.ayz, true);
            }
        } else if (this.ayz != null && bP(this.ayz)) {
            removeView(this.ayz);
            this.ayW.remove(this.ayz);
        }
        if (this.ayz != null) {
            this.ayz.setText(charSequence);
        }
        this.ayS = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.ayT;
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.ayA == null) {
                Context context = getContext();
                this.ayA = new AppCompatTextView(context);
                this.ayA.setSingleLine();
                this.ayA.setEllipsize(TextUtils.TruncateAt.END);
                if (this.ayI != 0) {
                    this.ayA.setTextAppearance(context, this.ayI);
                }
                if (this.ayU != 0) {
                    this.ayA.setTextColor(this.ayU);
                }
            }
            if (!bP(this.ayA)) {
                i(this.ayA, true);
            }
        } else if (this.ayA != null && bP(this.ayA)) {
            removeView(this.ayA);
            this.ayW.remove(this.ayA);
        }
        if (this.ayA != null) {
            this.ayA.setText(charSequence);
        }
        this.ayT = charSequence;
    }

    public void setTitleTextColor(int i2) {
        this.abH = i2;
        if (this.ayz != null) {
            this.ayz.setTextColor(i2);
        }
    }

    public void setSubtitleTextColor(int i2) {
        this.ayU = i2;
        if (this.ayA != null) {
            this.ayA.setTextColor(i2);
        }
    }

    public CharSequence getNavigationContentDescription() {
        if (this.ayB != null) {
            return this.ayB.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            mZ();
        }
        if (this.ayB != null) {
            this.ayB.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(android.support.v7.c.a.a.l(getContext(), i2));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            mZ();
            if (!bP(this.ayB)) {
                i(this.ayB, true);
            }
        } else if (this.ayB != null && bP(this.ayB)) {
            removeView(this.ayB);
            this.ayW.remove(this.ayB);
        }
        if (this.ayB != null) {
            this.ayB.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        if (this.ayB != null) {
            return this.ayB.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        mZ();
        this.ayB.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        mW();
        return this.ahs.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        mW();
        this.ahs.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        mW();
        return this.ahs.getOverflowIcon();
    }

    private void mW() {
        mX();
        if (this.ahs.aaQ == null) {
            h hVar = (h) this.ahs.getMenu();
            if (this.azc == null) {
                this.azc = new a();
            }
            this.ahs.setExpandedActionViewsExclusive(true);
            hVar.a(this.azc, this.ahr);
        }
    }

    private void mX() {
        if (this.ahs == null) {
            this.ahs = new ActionMenuView(getContext());
            this.ahs.setPopupTheme(this.aiS);
            this.ahs.setOnMenuItemClickListener(this.ayZ);
            this.ahs.a(this.aiU, this.aiV);
            LayoutParams nb = nb();
            nb.gravity = 8388613 | (this.ayJ & 112);
            this.ahs.setLayoutParams(nb);
            i(this.ahs, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new g(getContext());
    }

    public void setOnMenuItemClickListener(b bVar) {
        this.ayY = bVar;
    }

    public int getContentInsetStart() {
        if (this.ayP == null) {
            return 0;
        }
        ap apVar = this.ayP;
        return apVar.mIsRtl ? apVar.An : apVar.Al;
    }

    public int getContentInsetEnd() {
        if (this.ayP == null) {
            return 0;
        }
        ap apVar = this.ayP;
        return apVar.mIsRtl ? apVar.Al : apVar.An;
    }

    public final void mY() {
        nd();
        this.ayP.aB(0, 0);
    }

    public int getContentInsetLeft() {
        if (this.ayP != null) {
            return this.ayP.Al;
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.ayP != null) {
            return this.ayP.An;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        if (this.ayQ != Integer.MIN_VALUE) {
            return this.ayQ;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.ayQ) {
            this.ayQ = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.ayR != Integer.MIN_VALUE) {
            return this.ayR;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.ayR) {
            this.ayR = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.ayQ, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        boolean z;
        if (this.ahs != null) {
            h hVar = this.ahs.aaQ;
            z = hVar != null && hVar.hasVisibleItems();
        } else {
            z = false;
        }
        if (z) {
            return Math.max(getContentInsetEnd(), Math.max(this.ayR, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (u.Z(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (u.Z(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void mZ() {
        if (this.ayB == null) {
            this.ayB = new AppCompatImageButton(getContext(), null, R.attr.a3g);
            LayoutParams nb = nb();
            nb.gravity = 8388611 | (this.ayJ & 112);
            this.ayB.setLayoutParams(nb);
        }
    }

    /* access modifiers changed from: package-private */
    public final void na() {
        if (this.ayF == null) {
            this.ayF = new AppCompatImageButton(getContext(), null, R.attr.a3g);
            this.ayF.setImageDrawable(this.ayD);
            this.ayF.setContentDescription(this.ayE);
            LayoutParams nb = nb();
            nb.gravity = 8388611 | (this.ayJ & 112);
            nb.azh = 2;
            this.ayF.setLayoutParams(nb);
            this.ayF.setOnClickListener(new View.OnClickListener() {
                /* class android.support.v7.widget.Toolbar.AnonymousClass3 */

                public final void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void i(View view, boolean z) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = nb();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = d(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.azh = 1;
        if (!z || this.ayG == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.ayW.add(view);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.azc == null || this.azc.azg == null)) {
            savedState.azi = this.azc.azg.getItemId();
        }
        savedState.azj = isOverflowMenuShowing();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        h hVar;
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.Pm);
        if (this.ahs != null) {
            hVar = this.ahs.aaQ;
        } else {
            hVar = null;
        }
        if (!(savedState.azi == 0 || this.azc == null || hVar == null || (findItem = hVar.findItem(savedState.azi)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.azj) {
            removeCallbacks(this.aze);
            post(this.aze);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.aze);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.ahw = false;
        }
        if (!this.ahw) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.ahw = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.ahw = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.ahx = false;
        }
        if (!this.ahx) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.ahx = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.ahx = false;
        }
        return true;
    }

    private void j(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, marginLayoutParams.width), getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        int[] iArr = this.ayX;
        if (bh.d(this)) {
            c2 = 0;
            c3 = 1;
        } else {
            c2 = 1;
            c3 = 0;
        }
        int i8 = 0;
        if (bM(this.ayB)) {
            j(this.ayB, i2, 0, i3, this.ayK);
            i8 = this.ayB.getMeasuredWidth() + bN(this.ayB);
            int max = Math.max(0, this.ayB.getMeasuredHeight() + bO(this.ayB));
            i4 = View.combineMeasuredStates(0, this.ayB.getMeasuredState());
            i5 = max;
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (bM(this.ayF)) {
            j(this.ayF, i2, 0, i3, this.ayK);
            i8 = this.ayF.getMeasuredWidth() + bN(this.ayF);
            i5 = Math.max(i5, this.ayF.getMeasuredHeight() + bO(this.ayF));
            i4 = View.combineMeasuredStates(i4, this.ayF.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = Math.max(currentContentInsetStart, i8) + 0;
        iArr[c3] = Math.max(0, currentContentInsetStart - i8);
        int i9 = 0;
        if (bM(this.ahs)) {
            j(this.ahs, i2, max2, i3, this.ayK);
            i9 = this.ahs.getMeasuredWidth() + bN(this.ahs);
            i5 = Math.max(i5, this.ahs.getMeasuredHeight() + bO(this.ahs));
            i4 = View.combineMeasuredStates(i4, this.ahs.getMeasuredState());
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max2 + Math.max(currentContentInsetEnd, i9);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i9);
        if (bM(this.ayG)) {
            max3 += a(this.ayG, i2, max3, i3, 0, iArr);
            i5 = Math.max(i5, this.ayG.getMeasuredHeight() + bO(this.ayG));
            i4 = View.combineMeasuredStates(i4, this.ayG.getMeasuredState());
        }
        if (bM(this.ayC)) {
            max3 += a(this.ayC, i2, max3, i3, 0, iArr);
            i5 = Math.max(i5, this.ayC.getMeasuredHeight() + bO(this.ayC));
            i4 = View.combineMeasuredStates(i4, this.ayC.getMeasuredState());
        }
        int childCount = getChildCount();
        int i10 = 0;
        int i11 = i4;
        int i12 = i5;
        while (i10 < childCount) {
            View childAt = getChildAt(i10);
            if (((LayoutParams) childAt.getLayoutParams()).azh != 0 || !bM(childAt)) {
                i6 = i11;
                i7 = i12;
            } else {
                max3 += a(childAt, i2, max3, i3, 0, iArr);
                int max4 = Math.max(i12, childAt.getMeasuredHeight() + bO(childAt));
                i6 = View.combineMeasuredStates(i11, childAt.getMeasuredState());
                i7 = max4;
            }
            i10++;
            i11 = i6;
            i12 = i7;
        }
        int i13 = 0;
        int i14 = 0;
        int i15 = this.ayN + this.ayO;
        int i16 = this.ayL + this.ayM;
        if (bM(this.ayz)) {
            a(this.ayz, i2, max3 + i16, i3, i15, iArr);
            i13 = bN(this.ayz) + this.ayz.getMeasuredWidth();
            i14 = this.ayz.getMeasuredHeight() + bO(this.ayz);
            i11 = View.combineMeasuredStates(i11, this.ayz.getMeasuredState());
        }
        if (bM(this.ayA)) {
            i13 = Math.max(i13, a(this.ayA, i2, max3 + i16, i3, i15 + i14, iArr));
            i14 += this.ayA.getMeasuredHeight() + bO(this.ayA);
            i11 = View.combineMeasuredStates(i11, this.ayA.getMeasuredState());
        }
        int max5 = Math.max(i12, i14);
        int paddingLeft = i13 + max3 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max5 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, -16777216 & i11);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, i11 << 16);
        if (this.azd) {
            int childCount2 = getChildCount();
            int i17 = 0;
            while (true) {
                if (i17 >= childCount2) {
                    z = true;
                    break;
                }
                View childAt2 = getChildAt(i17);
                if (bM(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                    z = false;
                    break;
                }
                i17++;
            }
        } else {
            z = false;
        }
        if (z) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z2 = u.Z(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i18 = width - paddingRight;
        int[] iArr = this.ayX;
        iArr[1] = 0;
        iArr[0] = 0;
        int ag = u.ag(this);
        int min = ag >= 0 ? Math.min(ag, i5 - i3) : 0;
        if (!bM(this.ayB)) {
            i6 = i18;
            i7 = paddingLeft;
        } else if (z2) {
            i6 = b(this.ayB, i18, iArr, min);
            i7 = paddingLeft;
        } else {
            i7 = a(this.ayB, paddingLeft, iArr, min);
            i6 = i18;
        }
        if (bM(this.ayF)) {
            if (z2) {
                i6 = b(this.ayF, i6, iArr, min);
            } else {
                i7 = a(this.ayF, i7, iArr, min);
            }
        }
        if (bM(this.ahs)) {
            if (z2) {
                i7 = a(this.ahs, i7, iArr, min);
            } else {
                i6 = b(this.ahs, i6, iArr, min);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i7);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - i6));
        int max = Math.max(i7, currentContentInsetLeft);
        int min2 = Math.min(i6, (width - paddingRight) - currentContentInsetRight);
        if (bM(this.ayG)) {
            if (z2) {
                min2 = b(this.ayG, min2, iArr, min);
            } else {
                max = a(this.ayG, max, iArr, min);
            }
        }
        if (!bM(this.ayC)) {
            i8 = min2;
            i9 = max;
        } else if (z2) {
            i8 = b(this.ayC, min2, iArr, min);
            i9 = max;
        } else {
            i8 = min2;
            i9 = a(this.ayC, max, iArr, min);
        }
        boolean bM = bM(this.ayz);
        boolean bM2 = bM(this.ayA);
        int i19 = 0;
        if (bM) {
            LayoutParams layoutParams = (LayoutParams) this.ayz.getLayoutParams();
            i19 = layoutParams.bottomMargin + layoutParams.topMargin + this.ayz.getMeasuredHeight() + 0;
        }
        if (bM2) {
            LayoutParams layoutParams2 = (LayoutParams) this.ayA.getLayoutParams();
            i10 = layoutParams2.bottomMargin + layoutParams2.topMargin + this.ayA.getMeasuredHeight() + i19;
        } else {
            i10 = i19;
        }
        if (bM || bM2) {
            TextView textView = bM ? this.ayz : this.ayA;
            TextView textView2 = bM2 ? this.ayA : this.ayz;
            LayoutParams layoutParams3 = (LayoutParams) textView.getLayoutParams();
            LayoutParams layoutParams4 = (LayoutParams) textView2.getLayoutParams();
            boolean z3 = (bM && this.ayz.getMeasuredWidth() > 0) || (bM2 && this.ayA.getMeasuredWidth() > 0);
            switch (this.Ku & 112) {
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    i11 = layoutParams3.topMargin + getPaddingTop() + this.ayN;
                    break;
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                    i11 = (((height - paddingBottom) - layoutParams4.bottomMargin) - this.ayO) - i10;
                    break;
                default:
                    int i20 = (((height - paddingTop) - paddingBottom) - i10) / 2;
                    if (i20 < layoutParams3.topMargin + this.ayN) {
                        i17 = layoutParams3.topMargin + this.ayN;
                    } else {
                        int i21 = (((height - paddingBottom) - i10) - i20) - paddingTop;
                        if (i21 < layoutParams3.bottomMargin + this.ayO) {
                            i17 = Math.max(0, i20 - ((layoutParams4.bottomMargin + this.ayO) - i21));
                        } else {
                            i17 = i20;
                        }
                    }
                    i11 = paddingTop + i17;
                    break;
            }
            if (z2) {
                int i22 = (z3 ? this.ayL : 0) - iArr[1];
                int max2 = i8 - Math.max(0, i22);
                iArr[1] = Math.max(0, -i22);
                if (bM) {
                    int measuredWidth = max2 - this.ayz.getMeasuredWidth();
                    int measuredHeight = this.ayz.getMeasuredHeight() + i11;
                    this.ayz.layout(measuredWidth, i11, max2, measuredHeight);
                    int i23 = measuredWidth - this.ayM;
                    i11 = measuredHeight + ((LayoutParams) this.ayz.getLayoutParams()).bottomMargin;
                    i14 = i23;
                } else {
                    i14 = max2;
                }
                if (bM2) {
                    LayoutParams layoutParams5 = (LayoutParams) this.ayA.getLayoutParams();
                    int i24 = layoutParams5.topMargin + i11;
                    this.ayA.layout(max2 - this.ayA.getMeasuredWidth(), i24, max2, this.ayA.getMeasuredHeight() + i24);
                    int i25 = layoutParams5.bottomMargin;
                    i15 = max2 - this.ayM;
                } else {
                    i15 = max2;
                }
                if (z3) {
                    i16 = Math.min(i14, i15);
                } else {
                    i16 = max2;
                }
                i8 = i16;
            } else {
                int i26 = (z3 ? this.ayL : 0) - iArr[0];
                i9 += Math.max(0, i26);
                iArr[0] = Math.max(0, -i26);
                if (bM) {
                    int measuredWidth2 = this.ayz.getMeasuredWidth() + i9;
                    int measuredHeight2 = this.ayz.getMeasuredHeight() + i11;
                    this.ayz.layout(i9, i11, measuredWidth2, measuredHeight2);
                    int i27 = ((LayoutParams) this.ayz.getLayoutParams()).bottomMargin + measuredHeight2;
                    i12 = measuredWidth2 + this.ayM;
                    i11 = i27;
                } else {
                    i12 = i9;
                }
                if (bM2) {
                    LayoutParams layoutParams6 = (LayoutParams) this.ayA.getLayoutParams();
                    int i28 = layoutParams6.topMargin + i11;
                    int measuredWidth3 = this.ayA.getMeasuredWidth() + i9;
                    this.ayA.layout(i9, i28, measuredWidth3, this.ayA.getMeasuredHeight() + i28);
                    int i29 = layoutParams6.bottomMargin;
                    i13 = this.ayM + measuredWidth3;
                } else {
                    i13 = i9;
                }
                if (z3) {
                    i9 = Math.max(i12, i13);
                }
            }
        }
        a(this.ayV, 3);
        int size = this.ayV.size();
        int i30 = i9;
        for (int i31 = 0; i31 < size; i31++) {
            i30 = a(this.ayV.get(i31), i30, iArr, min);
        }
        a(this.ayV, 5);
        int size2 = this.ayV.size();
        int i32 = 0;
        int i33 = i8;
        while (i32 < size2) {
            int b2 = b(this.ayV.get(i32), i33, iArr, min);
            i32++;
            i33 = b2;
        }
        a(this.ayV, 1);
        ArrayList<View> arrayList = this.ayV;
        int i34 = iArr[0];
        int i35 = iArr[1];
        int size3 = arrayList.size();
        int i36 = 0;
        int i37 = 0;
        while (i36 < size3) {
            View view = arrayList.get(i36);
            LayoutParams layoutParams7 = (LayoutParams) view.getLayoutParams();
            int i38 = layoutParams7.leftMargin - i34;
            int i39 = layoutParams7.rightMargin - i35;
            int max3 = Math.max(0, i38);
            int max4 = Math.max(0, i39);
            i34 = Math.max(0, -i38);
            i35 = Math.max(0, -i39);
            i36++;
            i37 += view.getMeasuredWidth() + max3 + max4;
        }
        int i40 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (i37 / 2);
        int i41 = i40 + i37;
        if (i40 < i30) {
            i40 = i30;
        } else if (i41 > i33) {
            i40 -= i41 - i33;
        }
        int size4 = this.ayV.size();
        int i42 = 0;
        int i43 = i40;
        while (i42 < size4) {
            i42++;
            i43 = a(this.ayV.get(i42), i43, iArr, min);
        }
        this.ayV.clear();
    }

    private int a(View view, int i2, int[] iArr, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i4) + i2;
        iArr[0] = Math.max(0, -i4);
        int G = G(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, G, max + measuredWidth, view.getMeasuredHeight() + G);
        return layoutParams.rightMargin + measuredWidth + max;
    }

    private int b(View view, int i2, int[] iArr, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int G = G(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, G, max, view.getMeasuredHeight() + G);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int G(View view, int i2) {
        int max;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        switch (cW(layoutParams.gravity)) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                return getPaddingTop() - i3;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i3;
            default:
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i4 < layoutParams.topMargin) {
                    max = layoutParams.topMargin;
                } else {
                    int i5 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
                    max = i5 < layoutParams.bottomMargin ? Math.max(0, i4 - (layoutParams.bottomMargin - i5)) : i4;
                }
                return max + paddingTop;
        }
    }

    private int cW(int i2) {
        int i3 = i2 & 112;
        switch (i3) {
            case 16:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                return i3;
            default:
                return this.Ku & 112;
        }
    }

    private void a(List<View> list, int i2) {
        boolean z = true;
        if (u.Z(this) != 1) {
            z = false;
        }
        int childCount = getChildCount();
        int absoluteGravity = d.getAbsoluteGravity(i2, u.Z(this));
        list.clear();
        if (z) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.azh == 0 && bM(childAt) && cX(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.azh == 0 && bM(childAt2) && cX(layoutParams2.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    private int cX(int i2) {
        int Z = u.Z(this);
        int absoluteGravity = d.getAbsoluteGravity(i2, Z) & 7;
        switch (absoluteGravity) {
            case 1:
            case 3:
            case 5:
                return absoluteGravity;
            case 2:
            case 4:
            default:
                return Z == 1 ? 5 : 3;
        }
    }

    private boolean bM(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private static int bN(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return android.support.v4.view.g.b(marginLayoutParams) + android.support.v4.view.g.a(marginLayoutParams);
    }

    private static int bO(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private static LayoutParams d(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected static LayoutParams nb() {
        return new LayoutParams(-2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public u getWrapper() {
        if (this.aza == null) {
            this.aza = new ba(this, true);
        }
        return this.aza;
    }

    /* access modifiers changed from: package-private */
    public final void nc() {
        for (int size = this.ayW.size() - 1; size >= 0; size--) {
            addView(this.ayW.get(size));
        }
        this.ayW.clear();
    }

    private boolean bP(View view) {
        return view.getParent() == this || this.ayW.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.azd = z;
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public final void nd() {
        if (this.ayP == null) {
            this.ayP = new ap();
        }
    }

    /* access modifiers changed from: package-private */
    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.azb;
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.ahr;
    }

    public static class LayoutParams extends ActionBar.LayoutParams {
        int azh = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i2) {
            super(i2, -2);
            this.gravity = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.azh = layoutParams.azh;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class android.support.v7.widget.Toolbar.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        int azi;
        boolean azj;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.azi = parcel.readInt();
            this.azj = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.azi);
            parcel.writeInt(this.azj ? 1 : 0);
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements o {
        h aaQ;
        j azg;

        a() {
        }

        @Override // android.support.v7.view.menu.o
        public final void a(Context context, h hVar) {
            if (!(this.aaQ == null || this.azg == null)) {
                this.aaQ.h(this.azg);
            }
            this.aaQ = hVar;
        }

        @Override // android.support.v7.view.menu.o
        public final void p(boolean z) {
            boolean z2 = false;
            if (this.azg != null) {
                if (this.aaQ != null) {
                    int size = this.aaQ.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (this.aaQ.getItem(i2) == this.azg) {
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (!z2) {
                    c(this.azg);
                }
            }
        }

        @Override // android.support.v7.view.menu.o
        public final void a(o.a aVar) {
        }

        @Override // android.support.v7.view.menu.o
        public final boolean a(android.support.v7.view.menu.u uVar) {
            return false;
        }

        @Override // android.support.v7.view.menu.o
        public final void a(h hVar, boolean z) {
        }

        @Override // android.support.v7.view.menu.o
        public final boolean bF() {
            return false;
        }

        @Override // android.support.v7.view.menu.o
        public final boolean b(j jVar) {
            Toolbar.this.na();
            ViewParent parent = Toolbar.this.ayF.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.ayF);
                }
                Toolbar.this.addView(Toolbar.this.ayF);
            }
            Toolbar.this.ayG = jVar.getActionView();
            this.azg = jVar;
            ViewParent parent2 = Toolbar.this.ayG.getParent();
            if (parent2 != Toolbar.this) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(Toolbar.this.ayG);
                }
                LayoutParams nb = Toolbar.nb();
                nb.gravity = 8388611 | (Toolbar.this.ayJ & 112);
                nb.azh = 2;
                Toolbar.this.ayG.setLayoutParams(nb);
                Toolbar.this.addView(Toolbar.this.ayG);
            }
            Toolbar toolbar = Toolbar.this;
            for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = toolbar.getChildAt(childCount);
                if (!(((LayoutParams) childAt.getLayoutParams()).azh == 2 || childAt == toolbar.ahs)) {
                    toolbar.removeViewAt(childCount);
                    toolbar.ayW.add(childAt);
                }
            }
            Toolbar.this.requestLayout();
            jVar.af(true);
            if (Toolbar.this.ayG instanceof c) {
                ((c) Toolbar.this.ayG).onActionViewExpanded();
            }
            return true;
        }

        @Override // android.support.v7.view.menu.o
        public final boolean c(j jVar) {
            if (Toolbar.this.ayG instanceof c) {
                ((c) Toolbar.this.ayG).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.ayG);
            Toolbar.this.removeView(Toolbar.this.ayF);
            Toolbar.this.ayG = null;
            Toolbar.this.nc();
            this.azg = null;
            Toolbar.this.requestLayout();
            jVar.af(false);
            return true;
        }

        @Override // android.support.v7.view.menu.o
        public final int getId() {
            return 0;
        }

        @Override // android.support.v7.view.menu.o
        public final Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // android.support.v7.view.menu.o
        public final void onRestoreInstanceState(Parcelable parcelable) {
        }
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
