package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.a.a.b;
import android.support.v4.view.b;
import android.support.v7.view.menu.p;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;

public final class j implements b {
    private int FV = 16;
    private CharSequence Hn;
    h aaQ;
    private final int aeE;
    private final int aeF;
    final int aeG;
    private CharSequence aeH;
    private char aeI;
    int aeJ = 4096;
    private char aeK;
    int aeL = 4096;
    private Drawable aeM;
    private int aeN = 0;
    private MenuItem.OnMenuItemClickListener aeO;
    private CharSequence aeP;
    private CharSequence aeQ;
    private ColorStateList aeR = null;
    private PorterDuff.Mode aeS = null;
    private boolean aeT = false;
    private boolean aeU = false;
    private u agN;
    private Runnable agO;
    private boolean agP = false;
    private int agQ = 0;
    private View agR;
    public android.support.v4.view.b agS;
    private MenuItem.OnActionExpandListener agT;
    private boolean agU = false;
    ContextMenu.ContextMenuInfo agV;
    private final int mId;
    private Intent mIntent;

    j(h hVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.aaQ = hVar;
        this.mId = i3;
        this.aeE = i2;
        this.aeF = i4;
        this.aeG = i5;
        this.Hn = charSequence;
        this.agQ = i6;
    }

    public final boolean ij() {
        if (this.aeO != null && this.aeO.onMenuItemClick(this)) {
            return true;
        }
        if (this.aaQ.d(this.aaQ, this)) {
            return true;
        }
        if (this.agO != null) {
            this.agO.run();
            return true;
        }
        if (this.mIntent != null) {
            try {
                Context context = this.aaQ.mContext;
                a bl = new a().bl(this.mIntent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "android/support/v7/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "android/support/v7/view/menu/MenuItemImpl", "invoke", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                return true;
            } catch (ActivityNotFoundException e2) {
            }
        }
        return this.agS != null && this.agS.onPerformDefaultAction();
    }

    public final boolean isEnabled() {
        return (this.FV & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.FV |= 16;
        } else {
            this.FV &= -17;
        }
        this.aaQ.r(false);
        return this;
    }

    public final int getGroupId() {
        return this.aeE;
    }

    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.mId;
    }

    public final int getOrder() {
        return this.aeF;
    }

    public final Intent getIntent() {
        return this.mIntent;
    }

    public final MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.aeK;
    }

    public final MenuItem setAlphabeticShortcut(char c2) {
        if (this.aeK != c2) {
            this.aeK = Character.toLowerCase(c2);
            this.aaQ.r(false);
        }
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (!(this.aeK == c2 && this.aeL == i2)) {
            this.aeK = Character.toLowerCase(c2);
            this.aeL = KeyEvent.normalizeMetaState(i2);
            this.aaQ.r(false);
        }
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final int getAlphabeticModifiers() {
        return this.aeL;
    }

    public final char getNumericShortcut() {
        return this.aeI;
    }

    @Override // android.support.v4.a.a.b
    public final int getNumericModifiers() {
        return this.aeJ;
    }

    public final MenuItem setNumericShortcut(char c2) {
        if (this.aeI != c2) {
            this.aeI = c2;
            this.aaQ.r(false);
        }
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final MenuItem setNumericShortcut(char c2, int i2) {
        if (!(this.aeI == c2 && this.aeJ == i2)) {
            this.aeI = c2;
            this.aeJ = KeyEvent.normalizeMetaState(i2);
            this.aaQ.r(false);
        }
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3) {
        this.aeI = c2;
        this.aeK = Character.toLowerCase(c3);
        this.aaQ.r(false);
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.aeI = c2;
        this.aeJ = KeyEvent.normalizeMetaState(i2);
        this.aeK = Character.toLowerCase(c3);
        this.aeL = KeyEvent.normalizeMetaState(i3);
        this.aaQ.r(false);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final char ik() {
        return this.aaQ.hY() ? this.aeK : this.aeI;
    }

    /* access modifiers changed from: package-private */
    public final String il() {
        char ik = ik();
        if (ik == 0) {
            return "";
        }
        Resources resources = this.aaQ.mContext.getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.aaQ.mContext).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.c1));
        }
        int i2 = this.aaQ.hY() ? this.aeL : this.aeJ;
        a(sb, i2, 65536, resources.getString(R.string.bx));
        a(sb, i2, 4096, resources.getString(R.string.bt));
        a(sb, i2, 2, resources.getString(R.string.bs));
        a(sb, i2, 1, resources.getString(R.string.by));
        a(sb, i2, 4, resources.getString(R.string.c0));
        a(sb, i2, 8, resources.getString(R.string.bw));
        switch (ik) {
            case '\b':
                sb.append(resources.getString(R.string.bu));
                break;
            case '\n':
                sb.append(resources.getString(R.string.bv));
                break;
            case ' ':
                sb.append(resources.getString(R.string.bz));
                break;
            default:
                sb.append(ik);
                break;
        }
        return sb.toString();
    }

    static void a(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean im() {
        return this.aaQ.hZ() && ik() != 0;
    }

    public final SubMenu getSubMenu() {
        return this.agN;
    }

    public final boolean hasSubMenu() {
        return this.agN != null;
    }

    public final void b(u uVar) {
        this.agN = uVar;
        uVar.setHeaderTitle(getTitle());
    }

    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.Hn;
    }

    /* access modifiers changed from: package-private */
    public final CharSequence a(p.a aVar) {
        if (aVar.bC()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.Hn = charSequence;
        this.aaQ.r(false);
        if (this.agN != null) {
            this.agN.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i2) {
        return setTitle(this.aaQ.mContext.getString(i2));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.aeH != null ? this.aeH : this.Hn;
        if (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.aeH = charSequence;
        this.aaQ.r(false);
        return this;
    }

    public final Drawable getIcon() {
        if (this.aeM != null) {
            return o(this.aeM);
        }
        if (this.aeN == 0) {
            return null;
        }
        Drawable l = android.support.v7.c.a.a.l(this.aaQ.mContext, this.aeN);
        this.aeN = 0;
        this.aeM = l;
        return o(l);
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.aeN = 0;
        this.aeM = drawable;
        this.agP = true;
        this.aaQ.r(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i2) {
        this.aeM = null;
        this.aeN = i2;
        this.agP = true;
        this.aaQ.r(false);
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.aeR = colorStateList;
        this.aeT = true;
        this.agP = true;
        this.aaQ.r(false);
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final ColorStateList getIconTintList() {
        return this.aeR;
    }

    @Override // android.support.v4.a.a.b
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.aeS = mode;
        this.aeU = true;
        this.agP = true;
        this.aaQ.r(false);
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final PorterDuff.Mode getIconTintMode() {
        return this.aeS;
    }

    private Drawable o(Drawable drawable) {
        if (drawable != null && this.agP && (this.aeT || this.aeU)) {
            drawable = android.support.v4.graphics.drawable.a.i(drawable).mutate();
            if (this.aeT) {
                android.support.v4.graphics.drawable.a.a(drawable, this.aeR);
            }
            if (this.aeU) {
                android.support.v4.graphics.drawable.a.a(drawable, this.aeS);
            }
            this.agP = false;
        }
        return drawable;
    }

    public final boolean isCheckable() {
        return (this.FV & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        int i2 = this.FV;
        this.FV = (z ? 1 : 0) | (this.FV & -2);
        if (i2 != this.FV) {
            this.aaQ.r(false);
        }
        return this;
    }

    public final void ab(boolean z) {
        this.FV = (z ? 4 : 0) | (this.FV & -5);
    }

    public final boolean in() {
        return (this.FV & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.FV & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.FV & 4) != 0) {
            h hVar = this.aaQ;
            int groupId = getGroupId();
            int size = hVar.mItems.size();
            hVar.ia();
            for (int i2 = 0; i2 < size; i2++) {
                j jVar = hVar.mItems.get(i2);
                if (jVar.getGroupId() == groupId && jVar.in() && jVar.isCheckable()) {
                    jVar.ac(jVar == this);
                }
            }
            hVar.ib();
        } else {
            ac(z);
        }
        return this;
    }

    private void ac(boolean z) {
        int i2;
        int i3 = this.FV;
        int i4 = this.FV & -3;
        if (z) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        this.FV = i2 | i4;
        if (i3 != this.FV) {
            this.aaQ.r(false);
        }
    }

    public final boolean isVisible() {
        return (this.agS == null || !this.agS.overridesItemVisibility()) ? (this.FV & 8) == 0 : (this.FV & 8) == 0 && this.agS.isVisible();
    }

    /* access modifiers changed from: package-private */
    public final boolean ad(boolean z) {
        int i2 = this.FV;
        this.FV = (z ? 0 : 8) | (this.FV & -9);
        if (i2 != this.FV) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (ad(z)) {
            this.aaQ.ic();
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.aeO = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        if (this.Hn != null) {
            return this.Hn.toString();
        }
        return null;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.agV;
    }

    public final boolean ip() {
        return (this.FV & 32) == 32;
    }

    public final boolean iq() {
        return (this.agQ & 1) == 1;
    }

    public final boolean ir() {
        return (this.agQ & 2) == 2;
    }

    public final void ae(boolean z) {
        if (z) {
            this.FV |= 32;
        } else {
            this.FV &= -33;
        }
    }

    public final boolean is() {
        return (this.agQ & 4) == 4;
    }

    @Override // android.support.v4.a.a.b
    public final void setShowAsAction(int i2) {
        switch (i2 & 3) {
            case 0:
            case 1:
            case 2:
                this.agQ = i2;
                this.aaQ.ie();
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bc */
    public b setActionView(View view) {
        this.agR = view;
        this.agS = null;
        if (view != null && view.getId() == -1 && this.mId > 0) {
            view.setId(this.mId);
        }
        this.aaQ.ie();
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final View getActionView() {
        if (this.agR != null) {
            return this.agR;
        }
        if (this.agS == null) {
            return null;
        }
        this.agR = this.agS.onCreateActionView(this);
        return this.agR;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.support.v4.a.a.b
    public final android.support.v4.view.b eJ() {
        return this.agS;
    }

    @Override // android.support.v4.a.a.b
    public final b a(android.support.v4.view.b bVar) {
        if (this.agS != null) {
            android.support.v4.view.b bVar2 = this.agS;
            bVar2.Pp = null;
            bVar2.Po = null;
        }
        this.agR = null;
        this.agS = bVar;
        this.aaQ.r(true);
        if (this.agS != null) {
            this.agS.a(new b.AbstractC0037b() {
                /* class android.support.v7.view.menu.j.AnonymousClass1 */

                @Override // android.support.v4.view.b.AbstractC0037b
                public final void fz() {
                    j.this.aaQ.ic();
                }
            });
        }
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final boolean expandActionView() {
        if (!it()) {
            return false;
        }
        if (this.agT == null || this.agT.onMenuItemActionExpand(this)) {
            return this.aaQ.g(this);
        }
        return false;
    }

    @Override // android.support.v4.a.a.b
    public final boolean collapseActionView() {
        if ((this.agQ & 8) == 0) {
            return false;
        }
        if (this.agR == null) {
            return true;
        }
        if (this.agT == null || this.agT.onMenuItemActionCollapse(this)) {
            return this.aaQ.h(this);
        }
        return false;
    }

    public final boolean it() {
        if ((this.agQ & 8) == 0) {
            return false;
        }
        if (this.agR == null && this.agS != null) {
            this.agR = this.agS.onCreateActionView(this);
        }
        if (this.agR != null) {
            return true;
        }
        return false;
    }

    public final void af(boolean z) {
        this.agU = z;
        this.aaQ.r(false);
    }

    @Override // android.support.v4.a.a.b
    public final boolean isActionViewExpanded() {
        return this.agU;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.agT = onActionExpandListener;
        return this;
    }

    @Override // android.support.v4.a.a.b
    /* renamed from: k */
    public final android.support.v4.a.a.b setContentDescription(CharSequence charSequence) {
        this.aeP = charSequence;
        this.aaQ.r(false);
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final CharSequence getContentDescription() {
        return this.aeP;
    }

    @Override // android.support.v4.a.a.b
    /* renamed from: l */
    public final android.support.v4.a.a.b setTooltipText(CharSequence charSequence) {
        this.aeQ = charSequence;
        this.aaQ.r(false);
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final CharSequence getTooltipText() {
        return this.aeQ;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final /* synthetic */ MenuItem setActionView(int i2) {
        Context context = this.aaQ.mContext;
        setActionView(LayoutInflater.from(context).inflate(i2, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final /* synthetic */ MenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }
}
