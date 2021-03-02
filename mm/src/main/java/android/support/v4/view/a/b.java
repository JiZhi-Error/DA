package android.support.v4.view.a;

import android.view.accessibility.AccessibilityManager;

public final class b {

    public interface a {
        void onTouchExplorationStateChanged(boolean z);
    }

    /* renamed from: android.support.v4.view.a.b$b  reason: collision with other inner class name */
    public static class accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0035b implements AccessibilityManager.TouchExplorationStateChangeListener {
        final a Rn;

        public accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0035b(a aVar) {
            this.Rn = aVar;
        }

        public final int hashCode() {
            return this.Rn.hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.Rn.equals(((accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0035b) obj).Rn);
        }

        public final void onTouchExplorationStateChanged(boolean z) {
            this.Rn.onTouchExplorationStateChanged(z);
        }
    }
}
