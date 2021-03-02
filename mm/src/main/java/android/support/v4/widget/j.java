package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.e.o;
import android.support.v4.view.a.c;
import android.support.v4.view.a.d;
import android.support.v4.view.u;
import android.support.v4.view.x;
import android.support.v4.widget.k;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class j extends android.support.v4.view.a {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final k.a<c> NODE_ADAPTER = new k.a<c>() {
        /* class android.support.v4.widget.j.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.graphics.Rect] */
        @Override // android.support.v4.widget.k.a
        public final /* synthetic */ void b(c cVar, Rect rect) {
            cVar.getBoundsInParent(rect);
        }
    };
    private static final k.b<o<c>, c> SPARSE_VALUES_ADAPTER = new k.b<o<c>, c>() {
        /* class android.support.v4.widget.j.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.v4.widget.k.b
        public final /* synthetic */ int L(o<c> oVar) {
            return oVar.size();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
        @Override // android.support.v4.widget.k.b
        public final /* synthetic */ c get(o<c> oVar, int i2) {
            return oVar.valueAt(i2);
        }
    };
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    private final View mHost;
    public int mHoveredVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private final AccessibilityManager mManager;
    private a mNodeProvider;
    private final int[] mTempGlobalRect = new int[2];
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();

    /* access modifiers changed from: protected */
    public abstract int getVirtualViewAt(float f2, float f3);

    /* access modifiers changed from: protected */
    public abstract void getVisibleVirtualViews(List<Integer> list);

    /* access modifiers changed from: protected */
    public abstract boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void onPopulateNodeForVirtualView(int i2, c cVar);

    public j(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.mHost = view;
        this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (u.Y(view) == 0) {
            u.p(view, 1);
        }
    }

    @Override // android.support.v4.view.a
    public d getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new a();
        }
        return this.mNodeProvider;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 7:
            case 9:
                int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                updateHoveredVirtualView(virtualViewAt);
                return virtualViewAt != Integer.MIN_VALUE;
            case 8:
            default:
                return false;
            case 10:
                if (this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
                    return false;
                }
                updateHoveredVirtualView(Integer.MIN_VALUE);
                return true;
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (keyEvent.hasNoModifiers()) {
                        int keyToDirection = keyToDirection(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        int i2 = 0;
                        boolean z = false;
                        while (i2 < repeatCount && moveFocus(keyToDirection, null)) {
                            i2++;
                            z = true;
                        }
                        return z;
                    }
                    break;
                case 23:
                case 66:
                    if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                        clickKeyboardFocusedVirtualView();
                        return true;
                    }
                case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                    if (keyEvent.hasNoModifiers()) {
                        return moveFocus(2, null);
                    }
                    if (keyEvent.hasModifiers(1)) {
                        return moveFocus(1, null);
                    }
                    break;
            }
        }
        return false;
    }

    public final void onFocusChanged(boolean z, int i2, Rect rect) {
        if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
        }
        if (z) {
            moveFocus(i2, rect);
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    private static int keyToDirection(int i2) {
        switch (i2) {
            case 19:
                return 33;
            case 20:
            default:
                return 130;
            case 21:
                return 17;
            case 22:
                return 66;
        }
    }

    private void getBoundsInParent(int i2, Rect rect) {
        obtainAccessibilityNodeInfo(i2).getBoundsInParent(rect);
    }

    private boolean moveFocus(int i2, Rect rect) {
        c cVar;
        Object obj;
        o<c> allNodes = getAllNodes();
        int i3 = this.mKeyboardFocusedVirtualViewId;
        c cVar2 = i3 == Integer.MIN_VALUE ? null : allNodes.get(i3, null);
        switch (i2) {
            case 1:
            case 2:
                boolean z = u.Z(this.mHost) == 1;
                k.b<o<c>, c> bVar = SPARSE_VALUES_ADAPTER;
                k.a<c> aVar = NODE_ADAPTER;
                int L = bVar.L(allNodes);
                ArrayList arrayList = new ArrayList(L);
                for (int i4 = 0; i4 < L; i4++) {
                    arrayList.add(bVar.get(allNodes, i4));
                }
                Collections.sort(arrayList, new k.c(z, aVar));
                switch (i2) {
                    case 1:
                        int size = arrayList.size();
                        if (cVar2 != null) {
                            size = arrayList.indexOf(cVar2);
                        }
                        int i5 = size - 1;
                        if (i5 >= 0) {
                            obj = arrayList.get(i5);
                            break;
                        } else {
                            obj = null;
                            break;
                        }
                    case 2:
                        int size2 = arrayList.size();
                        int lastIndexOf = (cVar2 == null ? -1 : arrayList.lastIndexOf(cVar2)) + 1;
                        if (lastIndexOf < size2) {
                            obj = arrayList.get(lastIndexOf);
                            break;
                        } else {
                            obj = null;
                            break;
                        }
                    default:
                        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                }
                cVar = (c) obj;
                break;
            case 17:
            case 33:
            case 66:
            case 130:
                Rect rect2 = new Rect();
                if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
                    getBoundsInParent(this.mKeyboardFocusedVirtualViewId, rect2);
                } else if (rect != null) {
                    rect2.set(rect);
                } else {
                    guessPreviouslyFocusedRect(this.mHost, i2, rect2);
                }
                cVar = (c) k.a(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, cVar2, rect2, i2);
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return requestKeyboardFocusForVirtualView(cVar == null ? Integer.MIN_VALUE : allNodes.keyAt(allNodes.indexOfValue(cVar)));
    }

    private o<c> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        o<c> oVar = new o<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            oVar.put(i2, createNodeForChild(i2));
        }
        return oVar;
    }

    private static Rect guessPreviouslyFocusedRect(View view, int i2, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        switch (i2) {
            case 17:
                rect.set(width, 0, width, height);
                break;
            case 33:
                rect.set(0, height, width, height);
                break;
            case 66:
                rect.set(-1, 0, -1, height);
                break;
            case 130:
                rect.set(0, -1, width, -1);
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        return this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE && onPerformActionForVirtualView(this.mKeyboardFocusedVirtualViewId, 16, null);
    }

    public final boolean sendEventForVirtualView(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return x.a(parent, this.mHost, createEvent(i2, i3));
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i2) {
        invalidateVirtualView(i2, 0);
    }

    public final void invalidateVirtualView(int i2, int i3) {
        ViewParent parent;
        if (i2 != Integer.MIN_VALUE && this.mManager.isEnabled() && (parent = this.mHost.getParent()) != null) {
            AccessibilityEvent createEvent = createEvent(i2, 2048);
            android.support.v4.view.a.a.a(createEvent, i3);
            x.a(parent, this.mHost, createEvent);
        }
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    /* access modifiers changed from: protected */
    public void onVirtualViewKeyboardFocusChanged(int i2, boolean z) {
    }

    public void updateHoveredVirtualView(int i2) {
        if (this.mHoveredVirtualViewId != i2) {
            int i3 = this.mHoveredVirtualViewId;
            this.mHoveredVirtualViewId = i2;
            sendEventForVirtualView(i2, 128);
            sendEventForVirtualView(i3, 256);
        }
    }

    private AccessibilityEvent createEvent(int i2, int i3) {
        switch (i2) {
            case -1:
                return createEventForHost(i3);
            default:
                return createEventForChild(i2, i3);
        }
    }

    private AccessibilityEvent createEventForHost(int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @Override // android.support.v4.view.a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    private AccessibilityEvent createEventForChild(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        c obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i2);
        obtain.getText().add(obtainAccessibilityNodeInfo.Ro.getText());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.Ro.getContentDescription());
        obtain.setScrollable(obtainAccessibilityNodeInfo.Ro.isScrollable());
        obtain.setPassword(obtainAccessibilityNodeInfo.Ro.isPassword());
        obtain.setEnabled(obtainAccessibilityNodeInfo.Ro.isEnabled());
        obtain.setChecked(obtainAccessibilityNodeInfo.Ro.isChecked());
        onPopulateEventForVirtualView(i2, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(obtainAccessibilityNodeInfo.Ro.getClassName());
            View view = this.mHost;
            if (Build.VERSION.SDK_INT >= 16) {
                obtain.setSource(view, i2);
            }
            obtain.setPackageName(this.mHost.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    /* access modifiers changed from: package-private */
    public c obtainAccessibilityNodeInfo(int i2) {
        if (i2 == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i2);
    }

    private c createNodeForHost() {
        c a2 = c.a(AccessibilityNodeInfo.obtain(this.mHost));
        u.onInitializeAccessibilityNodeInfo(this.mHost, a2);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (a2.Ro.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.mHost;
                int intValue = ((Integer) arrayList.get(i2)).intValue();
                if (Build.VERSION.SDK_INT >= 16) {
                    a2.Ro.addChild(view, intValue);
                }
            }
            return a2;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    @Override // android.support.v4.view.a
    public void onInitializeAccessibilityNodeInfo(View view, c cVar) {
        super.onInitializeAccessibilityNodeInfo(view, cVar);
        onPopulateNodeForHost(cVar);
    }

    /* access modifiers changed from: package-private */
    public boolean performAction(int i2, int i3, Bundle bundle) {
        switch (i2) {
            case -1:
                return performActionForHost(i3, bundle);
            default:
                return performActionForChild(i2, i3, bundle);
        }
    }

    private boolean performActionForHost(int i2, Bundle bundle) {
        return u.performAccessibilityAction(this.mHost, i2, bundle);
    }

    private boolean performActionForChild(int i2, int i3, Bundle bundle) {
        switch (i3) {
            case 1:
                return requestKeyboardFocusForVirtualView(i2);
            case 2:
                return clearKeyboardFocusForVirtualView(i2);
            case 64:
                return requestAccessibilityFocus(i2);
            case 128:
                return clearAccessibilityFocus(i2);
            default:
                return onPerformActionForVirtualView(i2, i3, bundle);
        }
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty()) {
            return false;
        }
        if (this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            return true;
        }
        return false;
    }

    private boolean requestAccessibilityFocus(int i2) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || this.mAccessibilityFocusedVirtualViewId == i2) {
            return false;
        }
        if (this.mAccessibilityFocusedVirtualViewId != Integer.MIN_VALUE) {
            clearAccessibilityFocus(this.mAccessibilityFocusedVirtualViewId);
        }
        this.mAccessibilityFocusedVirtualViewId = i2;
        this.mHost.invalidate();
        sendEventForVirtualView(i2, 32768);
        return true;
    }

    private boolean clearAccessibilityFocus(int i2) {
        if (this.mAccessibilityFocusedVirtualViewId != i2) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(i2, 65536);
        return true;
    }

    public final boolean requestKeyboardFocusForVirtualView(int i2) {
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || this.mKeyboardFocusedVirtualViewId == i2) {
            return false;
        }
        if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
        }
        this.mKeyboardFocusedVirtualViewId = i2;
        onVirtualViewKeyboardFocusChanged(i2, true);
        sendEventForVirtualView(i2, 8);
        return true;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i2) {
        if (this.mKeyboardFocusedVirtualViewId != i2) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i2, false);
        sendEventForVirtualView(i2, 8);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPopulateEventForVirtualView(int i2, AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateNodeForHost(c cVar) {
    }

    class a extends d {
        a() {
        }

        @Override // android.support.v4.view.a.d
        public final c aQ(int i2) {
            return c.a(j.this.obtainAccessibilityNodeInfo(i2));
        }

        @Override // android.support.v4.view.a.d
        public final boolean performAction(int i2, int i3, Bundle bundle) {
            return j.this.performAction(i2, i3, bundle);
        }

        @Override // android.support.v4.view.a.d
        public final c aR(int i2) {
            int i3 = i2 == 2 ? j.this.mAccessibilityFocusedVirtualViewId : j.this.mKeyboardFocusedVirtualViewId;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return aQ(i3);
        }
    }

    private c createNodeForChild(int i2) {
        c a2 = c.a(AccessibilityNodeInfo.obtain());
        a2.setEnabled(true);
        a2.setFocusable(true);
        a2.setClassName(DEFAULT_CLASS_NAME);
        a2.setBoundsInParent(INVALID_PARENT_BOUNDS);
        a2.setBoundsInScreen(INVALID_PARENT_BOUNDS);
        a2.setParent(this.mHost);
        onPopulateNodeForVirtualView(i2, a2);
        if (a2.Ro.getText() == null && a2.Ro.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        a2.getBoundsInParent(this.mTempParentRect);
        if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = a2.Ro.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else {
            a2.setPackageName(this.mHost.getContext().getPackageName());
            View view = this.mHost;
            if (Build.VERSION.SDK_INT >= 16) {
                a2.Ro.setSource(view, i2);
            }
            if (this.mAccessibilityFocusedVirtualViewId == i2) {
                a2.setAccessibilityFocused(true);
                a2.addAction(128);
            } else {
                a2.setAccessibilityFocused(false);
                a2.addAction(64);
            }
            boolean z = this.mKeyboardFocusedVirtualViewId == i2;
            if (z) {
                a2.addAction(2);
            } else if (a2.Ro.isFocusable()) {
                a2.addAction(1);
            }
            a2.setFocused(z);
            this.mHost.getLocationOnScreen(this.mTempGlobalRect);
            a2.getBoundsInScreen(this.mTempScreenRect);
            if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
                a2.getBoundsInParent(this.mTempScreenRect);
                if (a2.Rp != -1) {
                    c a3 = c.a(AccessibilityNodeInfo.obtain());
                    for (int i3 = a2.Rp; i3 != -1; i3 = a3.Rp) {
                        View view2 = this.mHost;
                        a3.Rp = -1;
                        if (Build.VERSION.SDK_INT >= 16) {
                            a3.Ro.setParent(view2, -1);
                        }
                        a3.setBoundsInParent(INVALID_PARENT_BOUNDS);
                        onPopulateNodeForVirtualView(i3, a3);
                        a3.getBoundsInParent(this.mTempParentRect);
                        this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                    }
                    a3.Ro.recycle();
                }
                this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            }
            if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                    a2.setBoundsInScreen(this.mTempScreenRect);
                    if (isVisibleToUser(this.mTempScreenRect)) {
                        a2.setVisibleToUser(true);
                    }
                }
            }
            return a2;
        }
    }
}
