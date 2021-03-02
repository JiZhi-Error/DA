package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkNavigationHistory {
    private Object bridge;
    private ReflectMethod canGoBackMethod = new ReflectMethod((Class<?>) null, "canGoBack", (Class<?>[]) new Class[0]);
    private ReflectMethod canGoForwardMethod = new ReflectMethod((Class<?>) null, "canGoForward", (Class<?>[]) new Class[0]);
    private ReflectMethod clearMethod = new ReflectMethod((Class<?>) null, "clear", (Class<?>[]) new Class[0]);
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod enumDirectionClassValueOfMethod = new ReflectMethod();
    private ReflectMethod getCurrentIndexMethod = new ReflectMethod((Class<?>) null, "getCurrentIndex", (Class<?>[]) new Class[0]);
    private ReflectMethod getCurrentItemMethod = new ReflectMethod((Class<?>) null, "getCurrentItem", (Class<?>[]) new Class[0]);
    private ReflectMethod getItemAtintMethod = new ReflectMethod((Class<?>) null, "getItemAt", (Class<?>[]) new Class[0]);
    private ReflectMethod hasItemAtintMethod = new ReflectMethod((Class<?>) null, "hasItemAt", (Class<?>[]) new Class[0]);
    private ReflectMethod navigateDirectionInternalintMethod = new ReflectMethod((Class<?>) null, "navigate", (Class<?>[]) new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod sizeMethod = new ReflectMethod((Class<?>) null, "size", (Class<?>[]) new Class[0]);

    public enum Direction {
        BACKWARD,
        FORWARD;

        public static Direction valueOf(String str) {
            AppMethodBeat.i(154810);
            Direction direction = (Direction) Enum.valueOf(Direction.class, str);
            AppMethodBeat.o(154810);
            return direction;
        }

        static {
            AppMethodBeat.i(154811);
            AppMethodBeat.o(154811);
        }
    }

    private Object ConvertDirection(Direction direction) {
        AppMethodBeat.i(154812);
        Object invoke = this.enumDirectionClassValueOfMethod.invoke(direction.toString());
        AppMethodBeat.o(154812);
        return invoke;
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkNavigationHistory(Object obj) {
        AppMethodBeat.i(154813);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(154813);
    }

    public int size() {
        AppMethodBeat.i(154814);
        try {
            int intValue = ((Integer) this.sizeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(154814);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154814);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154814);
            return 0;
        }
    }

    public boolean hasItemAt(int i2) {
        AppMethodBeat.i(154815);
        try {
            boolean booleanValue = ((Boolean) this.hasItemAtintMethod.invoke(Integer.valueOf(i2))).booleanValue();
            AppMethodBeat.o(154815);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154815);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154815);
            return false;
        }
    }

    public XWalkNavigationItem getItemAt(int i2) {
        AppMethodBeat.i(154816);
        try {
            XWalkNavigationItem xWalkNavigationItem = (XWalkNavigationItem) this.coreWrapper.getWrapperObject(this.getItemAtintMethod.invoke(Integer.valueOf(i2)));
            AppMethodBeat.o(154816);
            return xWalkNavigationItem;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154816);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154816);
            return null;
        }
    }

    public XWalkNavigationItem getCurrentItem() {
        AppMethodBeat.i(154817);
        try {
            XWalkNavigationItem xWalkNavigationItem = (XWalkNavigationItem) this.coreWrapper.getWrapperObject(this.getCurrentItemMethod.invoke(new Object[0]));
            AppMethodBeat.o(154817);
            return xWalkNavigationItem;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154817);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154817);
            return null;
        }
    }

    public boolean canGoBack() {
        AppMethodBeat.i(154818);
        try {
            boolean booleanValue = ((Boolean) this.canGoBackMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154818);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154818);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154818);
            return false;
        }
    }

    public boolean canGoForward() {
        AppMethodBeat.i(154819);
        try {
            boolean booleanValue = ((Boolean) this.canGoForwardMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154819);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154819);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154819);
            return false;
        }
    }

    public void navigate(Direction direction, int i2) {
        AppMethodBeat.i(154820);
        try {
            this.navigateDirectionInternalintMethod.invoke(ConvertDirection(direction), Integer.valueOf(i2));
            AppMethodBeat.o(154820);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154820);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154820);
        }
    }

    public int getCurrentIndex() {
        AppMethodBeat.i(154821);
        try {
            int intValue = ((Integer) this.getCurrentIndexMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(154821);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154821);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154821);
            return 0;
        }
    }

    public void clear() {
        AppMethodBeat.i(154822);
        try {
            this.clearMethod.invoke(new Object[0]);
            AppMethodBeat.o(154822);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154822);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154822);
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154823);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154823);
            return;
        }
        this.enumDirectionClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkNavigationHistoryInternal$DirectionInternal"), "valueOf", String.class);
        this.sizeMethod.init(this.bridge, null, "sizeSuper", new Class[0]);
        this.hasItemAtintMethod.init(this.bridge, null, "hasItemAtSuper", Integer.TYPE);
        this.getItemAtintMethod.init(this.bridge, null, "getItemAtSuper", Integer.TYPE);
        this.getCurrentItemMethod.init(this.bridge, null, "getCurrentItemSuper", new Class[0]);
        this.canGoBackMethod.init(this.bridge, null, "canGoBackSuper", new Class[0]);
        this.canGoForwardMethod.init(this.bridge, null, "canGoForwardSuper", new Class[0]);
        this.navigateDirectionInternalintMethod.init(this.bridge, null, "navigateSuper", this.coreWrapper.getBridgeClass("XWalkNavigationHistoryInternal$DirectionInternal"), Integer.TYPE);
        this.getCurrentIndexMethod.init(this.bridge, null, "getCurrentIndexSuper", new Class[0]);
        this.clearMethod.init(this.bridge, null, "clearSuper", new Class[0]);
        AppMethodBeat.o(154823);
    }
}
