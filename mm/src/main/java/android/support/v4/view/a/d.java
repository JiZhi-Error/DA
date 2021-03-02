package android.support.v4.view.a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public class d {
    public final Object RZ;

    static class a extends AccessibilityNodeProvider {
        final d Sa;

        a(d dVar) {
            this.Sa = dVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            c aQ = this.Sa.aQ(i2);
            if (aQ == null) {
                return null;
            }
            return aQ.Ro;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
            return null;
        }

        public boolean performAction(int i2, int i3, Bundle bundle) {
            return this.Sa.performAction(i2, i3, bundle);
        }
    }

    static class b extends a {
        b(d dVar) {
            super(dVar);
        }

        public final AccessibilityNodeInfo findFocus(int i2) {
            c aR = this.Sa.aR(i2);
            if (aR == null) {
                return null;
            }
            return aR.Ro;
        }
    }

    public d() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.RZ = new b(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.RZ = new a(this);
        } else {
            this.RZ = null;
        }
    }

    public d(Object obj) {
        this.RZ = obj;
    }

    public c aQ(int i2) {
        return null;
    }

    public boolean performAction(int i2, int i3, Bundle bundle) {
        return false;
    }

    public c aR(int i2) {
        return null;
    }
}
