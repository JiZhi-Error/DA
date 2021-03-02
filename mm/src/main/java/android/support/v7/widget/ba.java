package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.aa;
import android.support.v4.view.u;
import android.support.v4.view.y;
import android.support.v7.a.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mm.R;

public final class ba implements u {
    CharSequence Hn;
    private CharSequence Md;
    private Drawable Xw;
    Window.Callback ZW;
    private View ahJ;
    private ActionMenuPresenter aht;
    Toolbar azk;
    private int azl;
    private View azm;
    private Drawable azn;
    private Drawable azo;
    private boolean azp;
    private CharSequence azq;
    boolean azr;
    private int azs;
    private int azt;
    private Drawable azu;

    public ba(Toolbar toolbar, boolean z) {
        this(toolbar, z, (byte) 0);
    }

    private ba(Toolbar toolbar, boolean z, byte b2) {
        this.azs = 0;
        this.azt = 0;
        this.azk = toolbar;
        this.Hn = toolbar.getTitle();
        this.Md = toolbar.getSubtitle();
        this.azp = this.Hn != null;
        this.azo = toolbar.getNavigationIcon();
        az a2 = az.a(toolbar.getContext(), null, a.C0040a.ActionBar, R.attr.a1, 0);
        this.azu = a2.getDrawable(15);
        if (z) {
            CharSequence text = a2.getText(27);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = a2.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                this.Md = text2;
                if ((this.azl & 8) != 0) {
                    this.azk.setSubtitle(text2);
                }
            }
            Drawable drawable = a2.getDrawable(20);
            if (drawable != null) {
                setLogo(drawable);
            }
            Drawable drawable2 = a2.getDrawable(17);
            if (drawable2 != null) {
                setIcon(drawable2);
            }
            if (this.azo == null && this.azu != null) {
                this.azo = this.azu;
                nf();
            }
            setDisplayOptions(a2.getInt(10, 0));
            int resourceId = a2.getResourceId(9, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.azk.getContext()).inflate(resourceId, (ViewGroup) this.azk, false));
                setDisplayOptions(this.azl | 16);
            }
            int layoutDimension = a2.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.azk.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.azk.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = a2.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = a2.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                Toolbar toolbar2 = this.azk;
                int max = Math.max(dimensionPixelOffset, 0);
                int max2 = Math.max(dimensionPixelOffset2, 0);
                toolbar2.nd();
                toolbar2.ayP.aA(max, max2);
            }
            int resourceId2 = a2.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar3 = this.azk;
                Context context = this.azk.getContext();
                toolbar3.ayH = resourceId2;
                if (toolbar3.ayz != null) {
                    toolbar3.ayz.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = a2.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar4 = this.azk;
                Context context2 = this.azk.getContext();
                toolbar4.ayI = resourceId3;
                if (toolbar4.ayA != null) {
                    toolbar4.ayA.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = a2.getResourceId(22, 0);
            if (resourceId4 != 0) {
                this.azk.setPopupTheme(resourceId4);
            }
        } else {
            int i2 = 11;
            if (this.azk.getNavigationIcon() != null) {
                this.azu = this.azk.getNavigationIcon();
                i2 = 15;
            }
            this.azl = i2;
        }
        a2.ayy.recycle();
        if (R.string.ba != this.azt) {
            this.azt = R.string.ba;
            if (TextUtils.isEmpty(this.azk.getNavigationContentDescription())) {
                setNavigationContentDescription(this.azt);
            }
        }
        this.azq = this.azk.getNavigationContentDescription();
        this.azk.setNavigationOnClickListener(new View.OnClickListener() {
            /* class android.support.v7.widget.ba.AnonymousClass1 */
            final android.support.v7.view.menu.a azv = new android.support.v7.view.menu.a(ba.this.azk.getContext(), ba.this.Hn);

            public final void onClick(View view) {
                if (ba.this.ZW != null && ba.this.azr) {
                    ba.this.ZW.onMenuItemSelected(0, this.azv);
                }
            }
        });
    }

    @Override // android.support.v7.widget.u
    public final ViewGroup jC() {
        return this.azk;
    }

    @Override // android.support.v7.widget.u
    public final Context getContext() {
        return this.azk.getContext();
    }

    @Override // android.support.v7.widget.u
    public final boolean hasExpandedActionView() {
        Toolbar toolbar = this.azk;
        return (toolbar.azc == null || toolbar.azc.azg == null) ? false : true;
    }

    @Override // android.support.v7.widget.u
    public final void collapseActionView() {
        this.azk.collapseActionView();
    }

    @Override // android.support.v7.widget.u
    public final void setWindowCallback(Window.Callback callback) {
        this.ZW = callback;
    }

    @Override // android.support.v7.widget.u
    public final void setWindowTitle(CharSequence charSequence) {
        if (!this.azp) {
            r(charSequence);
        }
    }

    @Override // android.support.v7.widget.u
    public final CharSequence getTitle() {
        return this.azk.getTitle();
    }

    @Override // android.support.v7.widget.u
    public final void setTitle(CharSequence charSequence) {
        this.azp = true;
        r(charSequence);
    }

    private void r(CharSequence charSequence) {
        this.Hn = charSequence;
        if ((this.azl & 8) != 0) {
            this.azk.setTitle(charSequence);
        }
    }

    @Override // android.support.v7.widget.u
    public final void setIcon(int i2) {
        setIcon(i2 != 0 ? android.support.v7.c.a.a.l(this.azk.getContext(), i2) : null);
    }

    @Override // android.support.v7.widget.u
    public final void setIcon(Drawable drawable) {
        this.Xw = drawable;
        ne();
    }

    @Override // android.support.v7.widget.u
    public final void setLogo(int i2) {
        setLogo(i2 != 0 ? android.support.v7.c.a.a.l(this.azk.getContext(), i2) : null);
    }

    @Override // android.support.v7.widget.u
    public final void setLogo(Drawable drawable) {
        this.azn = drawable;
        ne();
    }

    private void ne() {
        Drawable drawable = null;
        if ((this.azl & 2) != 0) {
            if ((this.azl & 1) != 0) {
                drawable = this.azn != null ? this.azn : this.Xw;
            } else {
                drawable = this.Xw;
            }
        }
        this.azk.setLogo(drawable);
    }

    @Override // android.support.v7.widget.u
    public final boolean iB() {
        Toolbar toolbar = this.azk;
        return toolbar.getVisibility() == 0 && toolbar.ahs != null && toolbar.ahs.aiu;
    }

    @Override // android.support.v7.widget.u
    public final boolean isOverflowMenuShowing() {
        return this.azk.isOverflowMenuShowing();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    @Override // android.support.v7.widget.u
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean iC() {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            android.support.v7.widget.Toolbar r2 = r4.azk
            android.support.v7.widget.ActionMenuView r3 = r2.ahs
            if (r3 == 0) goto L_0x0025
            android.support.v7.widget.ActionMenuView r2 = r2.ahs
            android.support.v7.widget.ActionMenuPresenter r3 = r2.aiT
            if (r3 == 0) goto L_0x0023
            android.support.v7.widget.ActionMenuPresenter r2 = r2.aiT
            android.support.v7.widget.ActionMenuPresenter$c r3 = r2.aiI
            if (r3 != 0) goto L_0x001a
            boolean r2 = r2.isOverflowMenuShowing()
            if (r2 == 0) goto L_0x0021
        L_0x001a:
            r2 = r0
        L_0x001b:
            if (r2 == 0) goto L_0x0023
            r2 = r0
        L_0x001e:
            if (r2 == 0) goto L_0x0025
        L_0x0020:
            return r0
        L_0x0021:
            r2 = r1
            goto L_0x001b
        L_0x0023:
            r2 = r1
            goto L_0x001e
        L_0x0025:
            r0 = r1
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ba.iC():boolean");
    }

    @Override // android.support.v7.widget.u
    public final boolean showOverflowMenu() {
        return this.azk.showOverflowMenu();
    }

    @Override // android.support.v7.widget.u
    public final boolean hideOverflowMenu() {
        boolean z;
        Toolbar toolbar = this.azk;
        if (toolbar.ahs != null) {
            ActionMenuView actionMenuView = toolbar.ahs;
            if (actionMenuView.aiT == null || !actionMenuView.aiT.hideOverflowMenu()) {
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

    @Override // android.support.v7.widget.u
    public final void iD() {
        this.azr = true;
    }

    @Override // android.support.v7.widget.u
    public final void a(Menu menu, o.a aVar) {
        if (this.aht == null) {
            this.aht = new ActionMenuPresenter(this.azk.getContext());
            this.aht.mId = R.id.d2;
        }
        this.aht.afg = aVar;
        this.azk.a((h) menu, this.aht);
    }

    @Override // android.support.v7.widget.u
    public final void dismissPopupMenus() {
        Toolbar toolbar = this.azk;
        if (toolbar.ahs != null) {
            toolbar.ahs.dismissPopupMenus();
        }
    }

    @Override // android.support.v7.widget.u
    public final int getDisplayOptions() {
        return this.azl;
    }

    @Override // android.support.v7.widget.u
    public final void setDisplayOptions(int i2) {
        int i3 = this.azl ^ i2;
        this.azl = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    ng();
                }
                nf();
            }
            if ((i3 & 3) != 0) {
                ne();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.azk.setTitle(this.Hn);
                    this.azk.setSubtitle(this.Md);
                } else {
                    this.azk.setTitle((CharSequence) null);
                    this.azk.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0 && this.ahJ != null) {
                if ((i2 & 16) != 0) {
                    this.azk.addView(this.ahJ);
                } else {
                    this.azk.removeView(this.ahJ);
                }
            }
        }
    }

    @Override // android.support.v7.widget.u
    public final void a(ar arVar) {
        if (this.azm != null && this.azm.getParent() == this.azk) {
            this.azk.removeView(this.azm);
        }
        this.azm = arVar;
        if (arVar != null && this.azs == 2) {
            this.azk.addView(this.azm, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.azm.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            arVar.setAllowCollapse(true);
        }
    }

    @Override // android.support.v7.widget.u
    public final void setCollapsible(boolean z) {
        this.azk.setCollapsible(z);
    }

    @Override // android.support.v7.widget.u
    public final int getNavigationMode() {
        return this.azs;
    }

    @Override // android.support.v7.widget.u
    public final void setCustomView(View view) {
        if (!(this.ahJ == null || (this.azl & 16) == 0)) {
            this.azk.removeView(this.ahJ);
        }
        this.ahJ = view;
        if (view != null && (this.azl & 16) != 0) {
            this.azk.addView(this.ahJ);
        }
    }

    @Override // android.support.v7.widget.u
    public final View getCustomView() {
        return this.ahJ;
    }

    @Override // android.support.v7.widget.u
    public final y c(final int i2, long j2) {
        return u.ah(this.azk).y(i2 == 0 ? 1.0f : 0.0f).j(j2).a(new aa() {
            /* class android.support.v7.widget.ba.AnonymousClass2 */
            private boolean mCanceled = false;

            @Override // android.support.v4.view.aa, android.support.v4.view.z
            public final void aI(View view) {
                ba.this.azk.setVisibility(0);
            }

            @Override // android.support.v4.view.aa, android.support.v4.view.z
            public final void aJ(View view) {
                if (!this.mCanceled) {
                    ba.this.azk.setVisibility(i2);
                }
            }

            @Override // android.support.v4.view.aa, android.support.v4.view.z
            public final void aK(View view) {
                this.mCanceled = true;
            }
        });
    }

    private void nf() {
        if ((this.azl & 4) != 0) {
            this.azk.setNavigationIcon(this.azo != null ? this.azo : this.azu);
        } else {
            this.azk.setNavigationIcon((Drawable) null);
        }
    }

    private void setNavigationContentDescription(CharSequence charSequence) {
        this.azq = charSequence;
        ng();
    }

    @Override // android.support.v7.widget.u
    public final void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 == 0 ? null : this.azk.getContext().getString(i2));
    }

    private void ng() {
        if ((this.azl & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.azq)) {
            this.azk.setNavigationContentDescription(this.azt);
        } else {
            this.azk.setNavigationContentDescription(this.azq);
        }
    }

    @Override // android.support.v7.widget.u
    public final void setBackgroundDrawable(Drawable drawable) {
        u.a(this.azk, drawable);
    }

    @Override // android.support.v7.widget.u
    public final int getHeight() {
        return this.azk.getHeight();
    }

    @Override // android.support.v7.widget.u
    public final void setVisibility(int i2) {
        this.azk.setVisibility(i2);
    }

    @Override // android.support.v7.widget.u
    public final int getVisibility() {
        return this.azk.getVisibility();
    }

    @Override // android.support.v7.widget.u
    public final void a(o.a aVar, h.a aVar2) {
        Toolbar toolbar = this.azk;
        toolbar.aiU = aVar;
        toolbar.aiV = aVar2;
        if (toolbar.ahs != null) {
            toolbar.ahs.a(aVar, aVar2);
        }
    }

    @Override // android.support.v7.widget.u
    public final Menu getMenu() {
        return this.azk.getMenu();
    }
}
