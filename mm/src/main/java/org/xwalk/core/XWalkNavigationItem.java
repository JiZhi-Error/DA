package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkNavigationItem {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getOriginalUrlMethod = new ReflectMethod((Class<?>) null, "getOriginalUrl", (Class<?>[]) new Class[0]);
    private ReflectMethod getTitleMethod = new ReflectMethod((Class<?>) null, "getTitle", (Class<?>[]) new Class[0]);
    private ReflectMethod getUrlMethod = new ReflectMethod((Class<?>) null, "getUrl", (Class<?>[]) new Class[0]);
    private ReflectMethod postWrapperMethod;

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkNavigationItem(Object obj) {
        AppMethodBeat.i(154824);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(154824);
    }

    public String getUrl() {
        AppMethodBeat.i(154825);
        try {
            String str = (String) this.getUrlMethod.invoke(new Object[0]);
            AppMethodBeat.o(154825);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154825);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154825);
            return null;
        }
    }

    public String getOriginalUrl() {
        AppMethodBeat.i(154826);
        try {
            String str = (String) this.getOriginalUrlMethod.invoke(new Object[0]);
            AppMethodBeat.o(154826);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154826);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154826);
            return null;
        }
    }

    public String getTitle() {
        AppMethodBeat.i(154827);
        try {
            String str = (String) this.getTitleMethod.invoke(new Object[0]);
            AppMethodBeat.o(154827);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154827);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154827);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154828);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154828);
            return;
        }
        this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
        this.getOriginalUrlMethod.init(this.bridge, null, "getOriginalUrlSuper", new Class[0]);
        this.getTitleMethod.init(this.bridge, null, "getTitleSuper", new Class[0]);
        AppMethodBeat.o(154828);
    }
}
