package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public final class c {
    public final AccessibilityNodeInfo Ro;
    public int Rp = -1;

    public static class a {
        public static final a RA = new a(1024);
        public static final a RB = new a(2048);
        public static final a RC = new a(4096);
        public static final a RD = new a(8192);
        public static final a RE = new a(16384);
        public static final a RF = new a(32768);
        public static final a RG = new a(65536);
        public static final a RH = new a(131072);
        public static final a RI = new a((int) TPMediaCodecProfileLevel.HEVCMainTierLevel52);
        public static final a RJ = new a(524288);
        public static final a RK = new a(1048576);
        public static final a RL = new a((int) TPMediaCodecProfileLevel.HEVCHighTierLevel6);
        public static final a RM;
        public static final a RN = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null);
        public static final a RO;
        public static final a RP;
        public static final a RQ;
        public static final a RR;
        public static final a RS;
        public static final a RT;
        public static final a RU = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null);
        public static final a RV;
        public static final a RW;
        public static final a Rq = new a(1);
        public static final a Rr = new a(2);
        public static final a Rs = new a(4);
        public static final a Rt = new a(8);
        public static final a Ru = new a(16);
        public static final a Rv = new a(32);
        public static final a Rw = new a(64);
        public static final a Rx = new a(128);
        public static final a Ry = new a(256);
        public static final a Rz = new a(512);
        public final Object RX;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9 = null;
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
            } else {
                accessibilityAction = null;
            }
            RM = new a(accessibilityAction);
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
            } else {
                accessibilityAction2 = null;
            }
            RO = new a(accessibilityAction2);
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityAction3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
            } else {
                accessibilityAction3 = null;
            }
            RP = new a(accessibilityAction3);
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityAction4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
            } else {
                accessibilityAction4 = null;
            }
            RQ = new a(accessibilityAction4);
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityAction5 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
            } else {
                accessibilityAction5 = null;
            }
            RR = new a(accessibilityAction5);
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityAction6 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
            } else {
                accessibilityAction6 = null;
            }
            RS = new a(accessibilityAction6);
            if (Build.VERSION.SDK_INT >= 24) {
                accessibilityAction7 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            } else {
                accessibilityAction7 = null;
            }
            RT = new a(accessibilityAction7);
            if (Build.VERSION.SDK_INT >= 28) {
                accessibilityAction8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            } else {
                accessibilityAction8 = null;
            }
            RV = new a(accessibilityAction8);
            if (Build.VERSION.SDK_INT >= 28) {
                accessibilityAction9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            RW = new a(accessibilityAction9);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private a(int r4) {
            /*
                r3 = this;
                r1 = 0
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 21
                if (r0 < r2) goto L_0x0010
                android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction r0 = new android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
                r0.<init>(r4, r1)
            L_0x000c:
                r3.<init>(r0)
                return
            L_0x0010:
                r0 = r1
                goto L_0x000c
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.a.c.a.<init>(int):void");
        }

        private a(Object obj) {
            this.RX = obj;
        }
    }

    public static class b {
        public final Object RY;

        public b(Object obj) {
            this.RY = obj;
        }
    }

    /* renamed from: android.support.v4.view.a.c$c  reason: collision with other inner class name */
    public static class C0036c {
        final Object RY;

        public static C0036c a(int i2, int i3, int i4, int i5, boolean z) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new C0036c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z, false));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new C0036c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z));
            }
            return new C0036c(null);
        }

        private C0036c(Object obj) {
            this.RY = obj;
        }
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.Ro = accessibilityNodeInfo;
    }

    public static c a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    public static c a(c cVar) {
        return a(AccessibilityNodeInfo.obtain(cVar.Ro));
    }

    public final void setSource(View view) {
        this.Ro.setSource(view);
    }

    public final void addChild(View view) {
        this.Ro.addChild(view);
    }

    public final void addAction(int i2) {
        this.Ro.addAction(i2);
    }

    public final boolean a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.Ro.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.RX);
        }
        return false;
    }

    public final void setParent(View view) {
        this.Ro.setParent(view);
    }

    public final void getBoundsInParent(Rect rect) {
        this.Ro.getBoundsInParent(rect);
    }

    public final void setBoundsInParent(Rect rect) {
        this.Ro.setBoundsInParent(rect);
    }

    public final void getBoundsInScreen(Rect rect) {
        this.Ro.getBoundsInScreen(rect);
    }

    public final void setBoundsInScreen(Rect rect) {
        this.Ro.setBoundsInScreen(rect);
    }

    public final void setCheckable(boolean z) {
        this.Ro.setCheckable(z);
    }

    public final void setFocusable(boolean z) {
        this.Ro.setFocusable(z);
    }

    public final void setFocused(boolean z) {
        this.Ro.setFocused(z);
    }

    public final boolean isVisibleToUser() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.Ro.isVisibleToUser();
        }
        return false;
    }

    public final void setVisibleToUser(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.Ro.setVisibleToUser(z);
        }
    }

    public final boolean isAccessibilityFocused() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.Ro.isAccessibilityFocused();
        }
        return false;
    }

    public final void setAccessibilityFocused(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.Ro.setAccessibilityFocused(z);
        }
    }

    public final void setSelected(boolean z) {
        this.Ro.setSelected(z);
    }

    public final void setClickable(boolean z) {
        this.Ro.setClickable(z);
    }

    public final void setLongClickable(boolean z) {
        this.Ro.setLongClickable(z);
    }

    public final void setEnabled(boolean z) {
        this.Ro.setEnabled(z);
    }

    public final void setScrollable(boolean z) {
        this.Ro.setScrollable(z);
    }

    public final void setPackageName(CharSequence charSequence) {
        this.Ro.setPackageName(charSequence);
    }

    public final void setClassName(CharSequence charSequence) {
        this.Ro.setClassName(charSequence);
    }

    public final void setText(CharSequence charSequence) {
        this.Ro.setText(charSequence);
    }

    public final void setContentDescription(CharSequence charSequence) {
        this.Ro.setContentDescription(charSequence);
    }

    public final void H(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.Ro.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0036c) obj).RY);
        }
    }

    public final void setDismissable(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.Ro.setDismissable(z);
        }
    }

    public final int hashCode() {
        if (this.Ro == null) {
            return 0;
        }
        return this.Ro.hashCode();
    }

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
        c cVar = (c) obj;
        return this.Ro == null ? cVar.Ro == null : this.Ro.equals(cVar.Ro);
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: ".concat(String.valueOf(rect)));
        getBoundsInScreen(rect);
        sb.append("; boundsInScreen: ".concat(String.valueOf(rect)));
        sb.append("; packageName: ").append(this.Ro.getPackageName());
        sb.append("; className: ").append(this.Ro.getClassName());
        sb.append("; text: ").append(this.Ro.getText());
        sb.append("; contentDescription: ").append(this.Ro.getContentDescription());
        StringBuilder append = sb.append("; viewId: ");
        if (Build.VERSION.SDK_INT >= 18) {
            str = this.Ro.getViewIdResourceName();
        } else {
            str = null;
        }
        append.append(str);
        sb.append("; checkable: ").append(this.Ro.isCheckable());
        sb.append("; checked: ").append(this.Ro.isChecked());
        sb.append("; focusable: ").append(this.Ro.isFocusable());
        sb.append("; focused: ").append(this.Ro.isFocused());
        sb.append("; selected: ").append(this.Ro.isSelected());
        sb.append("; clickable: ").append(this.Ro.isClickable());
        sb.append("; longClickable: ").append(this.Ro.isLongClickable());
        sb.append("; enabled: ").append(this.Ro.isEnabled());
        sb.append("; password: ").append(this.Ro.isPassword());
        sb.append("; scrollable: " + this.Ro.isScrollable());
        sb.append("; [");
        int actions = this.Ro.getActions();
        while (actions != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
            int i2 = (numberOfTrailingZeros ^ -1) & actions;
            switch (numberOfTrailingZeros) {
                case 1:
                    str2 = "ACTION_FOCUS";
                    break;
                case 2:
                    str2 = "ACTION_CLEAR_FOCUS";
                    break;
                case 4:
                    str2 = "ACTION_SELECT";
                    break;
                case 8:
                    str2 = "ACTION_CLEAR_SELECTION";
                    break;
                case 16:
                    str2 = "ACTION_CLICK";
                    break;
                case 32:
                    str2 = "ACTION_LONG_CLICK";
                    break;
                case 64:
                    str2 = "ACTION_ACCESSIBILITY_FOCUS";
                    break;
                case 128:
                    str2 = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    break;
                case 256:
                    str2 = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    break;
                case 512:
                    str2 = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    break;
                case 1024:
                    str2 = "ACTION_NEXT_HTML_ELEMENT";
                    break;
                case 2048:
                    str2 = "ACTION_PREVIOUS_HTML_ELEMENT";
                    break;
                case 4096:
                    str2 = "ACTION_SCROLL_FORWARD";
                    break;
                case 8192:
                    str2 = "ACTION_SCROLL_BACKWARD";
                    break;
                case 16384:
                    str2 = "ACTION_COPY";
                    break;
                case 32768:
                    str2 = "ACTION_PASTE";
                    break;
                case 65536:
                    str2 = "ACTION_CUT";
                    break;
                case 131072:
                    str2 = "ACTION_SET_SELECTION";
                    break;
                default:
                    str2 = "ACTION_UNKNOWN";
                    break;
            }
            sb.append(str2);
            if (i2 != 0) {
                sb.append(", ");
            }
            actions = i2;
        }
        sb.append("]");
        return sb.toString();
    }
}
