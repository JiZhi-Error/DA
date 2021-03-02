package io.flutter.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Keep;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Keep
public class AccessibilityViewEmbedder {
    private static final String TAG = "AccessibilityBridge";
    private final Map<View, Rect> embeddedViewToDisplayBounds;
    private final SparseArray<b> flutterIdToOrigin = new SparseArray<>();
    private int nextFlutterId;
    private final Map<b, Integer> originToFlutterId;
    private final a reflectionAccessors = new a((byte) 0);
    private final View rootAccessibilityView;

    AccessibilityViewEmbedder(View view, int i2) {
        AppMethodBeat.i(214912);
        this.rootAccessibilityView = view;
        this.nextFlutterId = i2;
        this.originToFlutterId = new HashMap();
        this.embeddedViewToDisplayBounds = new HashMap();
        AppMethodBeat.o(214912);
    }

    public AccessibilityNodeInfo getRootNode(View view, int i2, Rect rect) {
        AppMethodBeat.i(214913);
        AccessibilityNodeInfo createAccessibilityNodeInfo = view.createAccessibilityNodeInfo();
        Long b2 = this.reflectionAccessors.b(createAccessibilityNodeInfo);
        if (b2 == null) {
            AppMethodBeat.o(214913);
            return null;
        }
        this.embeddedViewToDisplayBounds.put(view, rect);
        cacheVirtualIdMappings(view, (int) (b2.longValue() >> 32), i2);
        AccessibilityNodeInfo convertToFlutterNode = convertToFlutterNode(createAccessibilityNodeInfo, i2, view);
        AppMethodBeat.o(214913);
        return convertToFlutterNode;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
        AppMethodBeat.i(214914);
        b bVar = this.flutterIdToOrigin.get(i2);
        if (bVar == null) {
            AppMethodBeat.o(214914);
            return null;
        } else if (!this.embeddedViewToDisplayBounds.containsKey(bVar.view)) {
            AppMethodBeat.o(214914);
            return null;
        } else if (bVar.view.getAccessibilityNodeProvider() == null) {
            AppMethodBeat.o(214914);
            return null;
        } else {
            AccessibilityNodeInfo createAccessibilityNodeInfo = bVar.view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(bVar.id);
            if (createAccessibilityNodeInfo == null) {
                AppMethodBeat.o(214914);
                return null;
            }
            AccessibilityNodeInfo convertToFlutterNode = convertToFlutterNode(createAccessibilityNodeInfo, i2, bVar.view);
            AppMethodBeat.o(214914);
            return convertToFlutterNode;
        }
    }

    private AccessibilityNodeInfo convertToFlutterNode(AccessibilityNodeInfo accessibilityNodeInfo, int i2, View view) {
        AppMethodBeat.i(9785);
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, i2);
        obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain.setSource(this.rootAccessibilityView, i2);
        obtain.setClassName(accessibilityNodeInfo.getClassName());
        copyAccessibilityFields(accessibilityNodeInfo, obtain);
        setFlutterNodesTranslateBounds(accessibilityNodeInfo, this.embeddedViewToDisplayBounds.get(view), obtain);
        addChildrenToFlutterNode(accessibilityNodeInfo, view, obtain);
        setFlutterNodeParent(accessibilityNodeInfo, view, obtain);
        AppMethodBeat.o(9785);
        return obtain;
    }

    private void setFlutterNodeParent(AccessibilityNodeInfo accessibilityNodeInfo, View view, AccessibilityNodeInfo accessibilityNodeInfo2) {
        AppMethodBeat.i(9786);
        Long c2 = this.reflectionAccessors.c(accessibilityNodeInfo);
        if (c2 == null) {
            AppMethodBeat.o(9786);
            return;
        }
        Integer num = this.originToFlutterId.get(new b(view, (int) (c2.longValue() >> 32), (byte) 0));
        if (num != null) {
            accessibilityNodeInfo2.setParent(this.rootAccessibilityView, num.intValue());
        }
        AppMethodBeat.o(9786);
    }

    private void addChildrenToFlutterNode(AccessibilityNodeInfo accessibilityNodeInfo, View view, AccessibilityNodeInfo accessibilityNodeInfo2) {
        int i2;
        AppMethodBeat.i(9787);
        for (int i3 = 0; i3 < accessibilityNodeInfo.getChildCount(); i3++) {
            Long a2 = this.reflectionAccessors.a(accessibilityNodeInfo, i3);
            if (a2 != null) {
                int longValue = (int) (a2.longValue() >> 32);
                b bVar = new b(view, longValue, (byte) 0);
                if (this.originToFlutterId.containsKey(bVar)) {
                    i2 = this.originToFlutterId.get(bVar).intValue();
                } else {
                    i2 = this.nextFlutterId;
                    this.nextFlutterId = i2 + 1;
                    cacheVirtualIdMappings(view, longValue, i2);
                }
                accessibilityNodeInfo2.addChild(this.rootAccessibilityView, i2);
            }
        }
        AppMethodBeat.o(9787);
    }

    private void cacheVirtualIdMappings(View view, int i2, int i3) {
        AppMethodBeat.i(9788);
        b bVar = new b(view, i2, (byte) 0);
        this.originToFlutterId.put(bVar, Integer.valueOf(i3));
        this.flutterIdToOrigin.put(i3, bVar);
        AppMethodBeat.o(9788);
    }

    private void setFlutterNodesTranslateBounds(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect, AccessibilityNodeInfo accessibilityNodeInfo2) {
        AppMethodBeat.i(9789);
        Rect rect2 = new Rect();
        accessibilityNodeInfo.getBoundsInParent(rect2);
        accessibilityNodeInfo2.setBoundsInParent(rect2);
        Rect rect3 = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect3);
        rect3.offset(rect.left, rect.top);
        accessibilityNodeInfo2.setBoundsInScreen(rect3);
        AppMethodBeat.o(9789);
    }

    private void copyAccessibilityFields(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        AppMethodBeat.i(9790);
        accessibilityNodeInfo2.setAccessibilityFocused(accessibilityNodeInfo.isAccessibilityFocused());
        accessibilityNodeInfo2.setCheckable(accessibilityNodeInfo.isCheckable());
        accessibilityNodeInfo2.setChecked(accessibilityNodeInfo.isChecked());
        accessibilityNodeInfo2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityNodeInfo2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityNodeInfo2.setClickable(accessibilityNodeInfo.isClickable());
        accessibilityNodeInfo2.setFocusable(accessibilityNodeInfo.isFocusable());
        accessibilityNodeInfo2.setFocused(accessibilityNodeInfo.isFocused());
        accessibilityNodeInfo2.setLongClickable(accessibilityNodeInfo.isLongClickable());
        accessibilityNodeInfo2.setMovementGranularities(accessibilityNodeInfo.getMovementGranularities());
        accessibilityNodeInfo2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityNodeInfo2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityNodeInfo2.setSelected(accessibilityNodeInfo.isSelected());
        accessibilityNodeInfo2.setText(accessibilityNodeInfo.getText());
        accessibilityNodeInfo2.setVisibleToUser(accessibilityNodeInfo.isVisibleToUser());
        if (Build.VERSION.SDK_INT >= 18) {
            accessibilityNodeInfo2.setEditable(accessibilityNodeInfo.isEditable());
        }
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityNodeInfo2.setCanOpenPopup(accessibilityNodeInfo.canOpenPopup());
            accessibilityNodeInfo2.setCollectionInfo(accessibilityNodeInfo.getCollectionInfo());
            accessibilityNodeInfo2.setCollectionItemInfo(accessibilityNodeInfo.getCollectionItemInfo());
            accessibilityNodeInfo2.setContentInvalid(accessibilityNodeInfo.isContentInvalid());
            accessibilityNodeInfo2.setDismissable(accessibilityNodeInfo.isDismissable());
            accessibilityNodeInfo2.setInputType(accessibilityNodeInfo.getInputType());
            accessibilityNodeInfo2.setLiveRegion(accessibilityNodeInfo.getLiveRegion());
            accessibilityNodeInfo2.setMultiLine(accessibilityNodeInfo.isMultiLine());
            accessibilityNodeInfo2.setRangeInfo(accessibilityNodeInfo.getRangeInfo());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            accessibilityNodeInfo2.setError(accessibilityNodeInfo.getError());
            accessibilityNodeInfo2.setMaxTextLength(accessibilityNodeInfo.getMaxTextLength());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            accessibilityNodeInfo2.setContextClickable(accessibilityNodeInfo.isContextClickable());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            accessibilityNodeInfo2.setDrawingOrder(accessibilityNodeInfo.getDrawingOrder());
            accessibilityNodeInfo2.setImportantForAccessibility(accessibilityNodeInfo.isImportantForAccessibility());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            accessibilityNodeInfo2.setAvailableExtraData(accessibilityNodeInfo.getAvailableExtraData());
            accessibilityNodeInfo2.setHintText(accessibilityNodeInfo.getHintText());
            accessibilityNodeInfo2.setShowingHintText(accessibilityNodeInfo.isShowingHintText());
        }
        AppMethodBeat.o(9790);
    }

    public boolean requestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(214915);
        AccessibilityEvent obtain = AccessibilityEvent.obtain(accessibilityEvent);
        Long a2 = this.reflectionAccessors.a(accessibilityEvent);
        if (a2 == null) {
            AppMethodBeat.o(214915);
            return false;
        }
        int longValue = (int) (a2.longValue() >> 32);
        Integer num = this.originToFlutterId.get(new b(view, longValue, (byte) 0));
        if (num == null) {
            int i2 = this.nextFlutterId;
            this.nextFlutterId = i2 + 1;
            num = Integer.valueOf(i2);
            cacheVirtualIdMappings(view, longValue, num.intValue());
        }
        obtain.setSource(this.rootAccessibilityView, num.intValue());
        obtain.setClassName(accessibilityEvent.getClassName());
        obtain.setPackageName(accessibilityEvent.getPackageName());
        for (int i3 = 0; i3 < obtain.getRecordCount(); i3++) {
            AccessibilityRecord record = obtain.getRecord(i3);
            Long a3 = this.reflectionAccessors.a(record);
            if (a3 == null) {
                AppMethodBeat.o(214915);
                return false;
            }
            b bVar = new b(view, (int) (a3.longValue() >> 32), (byte) 0);
            if (!this.originToFlutterId.containsKey(bVar)) {
                AppMethodBeat.o(214915);
                return false;
            }
            record.setSource(this.rootAccessibilityView, this.originToFlutterId.get(bVar).intValue());
        }
        boolean requestSendAccessibilityEvent = this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(view2, obtain);
        AppMethodBeat.o(214915);
        return requestSendAccessibilityEvent;
    }

    public boolean performAction(int i2, int i3, Bundle bundle) {
        AppMethodBeat.i(214916);
        b bVar = this.flutterIdToOrigin.get(i2);
        if (bVar == null) {
            AppMethodBeat.o(214916);
            return false;
        }
        AccessibilityNodeProvider accessibilityNodeProvider = bVar.view.getAccessibilityNodeProvider();
        if (accessibilityNodeProvider == null) {
            AppMethodBeat.o(214916);
            return false;
        }
        boolean performAction = accessibilityNodeProvider.performAction(bVar.id, i3, bundle);
        AppMethodBeat.o(214916);
        return performAction;
    }

    public Integer getRecordFlutterId(View view, AccessibilityRecord accessibilityRecord) {
        AppMethodBeat.i(214917);
        Long a2 = this.reflectionAccessors.a(accessibilityRecord);
        if (a2 == null) {
            AppMethodBeat.o(214917);
            return null;
        }
        Integer num = this.originToFlutterId.get(new b(view, (int) (a2.longValue() >> 32), (byte) 0));
        AppMethodBeat.o(214917);
        return num;
    }

    public boolean onAccessibilityHoverEvent(int i2, MotionEvent motionEvent) {
        AppMethodBeat.i(9791);
        b bVar = this.flutterIdToOrigin.get(i2);
        if (bVar == null) {
            AppMethodBeat.o(9791);
            return false;
        }
        Rect rect = this.embeddedViewToDisplayBounds.get(bVar.view);
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i3 = 0; i3 < motionEvent.getPointerCount(); i3++) {
            pointerPropertiesArr[i3] = new MotionEvent.PointerProperties();
            motionEvent.getPointerProperties(i3, pointerPropertiesArr[i3]);
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i3, pointerCoords);
            pointerCoordsArr[i3] = new MotionEvent.PointerCoords(pointerCoords);
            pointerCoordsArr[i3].x -= (float) rect.left;
            pointerCoordsArr[i3].y -= (float) rect.top;
        }
        boolean dispatchGenericMotionEvent = bVar.view.dispatchGenericMotionEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getPointerCount(), pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags()));
        AppMethodBeat.o(9791);
        return dispatchGenericMotionEvent;
    }

    public View platformViewOfNode(int i2) {
        AppMethodBeat.i(214918);
        b bVar = this.flutterIdToOrigin.get(i2);
        if (bVar == null) {
            AppMethodBeat.o(214918);
            return null;
        }
        View view = bVar.view;
        AppMethodBeat.o(214918);
        return view;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        final int id;
        final View view;

        /* synthetic */ b(View view2, int i2, byte b2) {
            this(view2, i2);
        }

        private b(View view2, int i2) {
            this.view = view2;
            this.id = i2;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(9826);
            if (this == obj) {
                AppMethodBeat.o(9826);
                return true;
            } else if (!(obj instanceof b)) {
                AppMethodBeat.o(9826);
                return false;
            } else {
                b bVar = (b) obj;
                if (this.id != bVar.id || !this.view.equals(bVar.view)) {
                    AppMethodBeat.o(9826);
                    return false;
                }
                AppMethodBeat.o(9826);
                return true;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(9827);
            int hashCode = ((this.view.hashCode() + 31) * 31) + this.id;
            AppMethodBeat.o(9827);
            return hashCode;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private final Method SVY;
        private final Method SVZ;
        private final Method SWa;
        private final Method SWb;
        private final Field SWc;
        private final Method SWd;

        /* synthetic */ a(byte b2) {
            this();
        }

        @SuppressLint({"PrivateApi"})
        private a() {
            Method method;
            Method method2;
            Method method3;
            Field field;
            Method method4;
            Method method5;
            AppMethodBeat.i(9792);
            try {
                method = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", new Class[0]);
            } catch (NoSuchMethodException e2) {
                method = null;
            }
            try {
                method2 = AccessibilityRecord.class.getMethod("getSourceNodeId", new Class[0]);
            } catch (NoSuchMethodException e3) {
                method2 = null;
            }
            if (Build.VERSION.SDK_INT <= 26) {
                try {
                    method5 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", new Class[0]);
                } catch (NoSuchMethodException e4) {
                    method5 = null;
                }
                try {
                    method4 = AccessibilityNodeInfo.class.getMethod("getChildId", Integer.TYPE);
                    method3 = null;
                    field = null;
                } catch (NoSuchMethodException e5) {
                    method3 = null;
                    field = null;
                    method4 = null;
                }
            } else {
                try {
                    field = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
                    field.setAccessible(true);
                    method3 = Class.forName("android.util.LongArray").getMethod("get", Integer.TYPE);
                    method4 = null;
                    method5 = null;
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException e6) {
                    method3 = null;
                    field = null;
                    method4 = null;
                    method5 = null;
                }
            }
            this.SVY = method;
            this.SVZ = method5;
            this.SWa = method2;
            this.SWb = method4;
            this.SWc = field;
            this.SWd = method3;
            AppMethodBeat.o(9792);
        }

        /* access modifiers changed from: package-private */
        public final Long b(AccessibilityNodeInfo accessibilityNodeInfo) {
            AppMethodBeat.i(9793);
            if (this.SVY == null) {
                AppMethodBeat.o(9793);
                return null;
            }
            try {
                Long l = (Long) this.SVY.invoke(accessibilityNodeInfo, new Object[0]);
                AppMethodBeat.o(9793);
                return l;
            } catch (IllegalAccessException | InvocationTargetException e2) {
                AppMethodBeat.o(9793);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public final Long a(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
            AppMethodBeat.i(9794);
            if (this.SWb == null && (this.SWc == null || this.SWd == null)) {
                AppMethodBeat.o(9794);
                return null;
            } else if (this.SWb != null) {
                try {
                    Long l = (Long) this.SWb.invoke(accessibilityNodeInfo, Integer.valueOf(i2));
                    AppMethodBeat.o(9794);
                    return l;
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    AppMethodBeat.o(9794);
                    return null;
                }
            } else {
                try {
                    Long valueOf = Long.valueOf(((Long) this.SWd.invoke(this.SWc.get(accessibilityNodeInfo), Integer.valueOf(i2))).longValue());
                    AppMethodBeat.o(9794);
                    return valueOf;
                } catch (ArrayIndexOutOfBoundsException | IllegalAccessException | InvocationTargetException e3) {
                    AppMethodBeat.o(9794);
                    return null;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final Long c(AccessibilityNodeInfo accessibilityNodeInfo) {
            Long l;
            AppMethodBeat.i(9795);
            if (this.SVZ != null) {
                try {
                    Long valueOf = Long.valueOf(((Long) this.SVZ.invoke(accessibilityNodeInfo, new Object[0])).longValue());
                    AppMethodBeat.o(9795);
                    return valueOf;
                } catch (IllegalAccessException | InvocationTargetException e2) {
                }
            }
            if (Build.VERSION.SDK_INT < 26) {
                AppMethodBeat.o(9795);
                return null;
            }
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            Parcel obtain2 = Parcel.obtain();
            obtain2.setDataPosition(0);
            obtain.writeToParcel(obtain2, 0);
            obtain2.setDataPosition(0);
            long readLong = obtain2.readLong();
            if (at(readLong, 0)) {
                obtain2.readInt();
            }
            if (at(readLong, 1)) {
                obtain2.readLong();
            }
            if (at(readLong, 2)) {
                obtain2.readInt();
            }
            if (at(readLong, 3)) {
                l = Long.valueOf(obtain2.readLong());
            } else {
                l = null;
            }
            obtain2.recycle();
            AppMethodBeat.o(9795);
            return l;
        }

        private static boolean at(long j2, int i2) {
            return ((1 << i2) & j2) != 0;
        }

        /* access modifiers changed from: package-private */
        public final Long a(AccessibilityRecord accessibilityRecord) {
            AppMethodBeat.i(9796);
            if (this.SWa == null) {
                AppMethodBeat.o(9796);
                return null;
            }
            try {
                Long l = (Long) this.SWa.invoke(accessibilityRecord, new Object[0]);
                AppMethodBeat.o(9796);
                return l;
            } catch (IllegalAccessException | InvocationTargetException e2) {
                AppMethodBeat.o(9796);
                return null;
            }
        }
    }
}
