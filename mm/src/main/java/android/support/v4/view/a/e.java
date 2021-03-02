package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

public final class e {
    private final AccessibilityRecord Sb;

    @Deprecated
    private e(Object obj) {
        this.Sb = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static e fJ() {
        return new e(AccessibilityRecord.obtain());
    }

    @Deprecated
    public final void setScrollable(boolean z) {
        this.Sb.setScrollable(z);
    }

    @Deprecated
    public final void setItemCount(int i2) {
        this.Sb.setItemCount(i2);
    }

    @Deprecated
    public final void setFromIndex(int i2) {
        this.Sb.setFromIndex(i2);
    }

    @Deprecated
    public final void setToIndex(int i2) {
        this.Sb.setToIndex(i2);
    }

    @Deprecated
    public final int hashCode() {
        if (this.Sb == null) {
            return 0;
        }
        return this.Sb.hashCode();
    }

    @Deprecated
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.Sb == null ? eVar.Sb == null : this.Sb.equals(eVar.Sb);
    }
}
