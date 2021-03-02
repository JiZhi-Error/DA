package org.xwalk.core;

import android.os.ResultReceiver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkExtendTextAreaClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkExtendTextAreaClient.class.desiredAssertionStatus());
    private static final String TAG = "XWalkExtendTextAreaClient";
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private XWalkView mXWalkView;
    private ReflectMethod onKeyboardHeightChangedbooleanintbooleanMethod = new ReflectMethod((Class<?>) null, "onKeyboardHeightChanged", (Class<?>[]) new Class[0]);
    private ReflectMethod postWrapperMethod;

    static {
        AppMethodBeat.i(154728);
        AppMethodBeat.o(154728);
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkExtendTextAreaClient(XWalkView xWalkView) {
        AppMethodBeat.i(154725);
        this.mXWalkView = xWalkView;
        this.constructorTypes = new ArrayList<>();
        this.constructorTypes.add("XWalkViewBridge");
        this.constructorParams = new ArrayList<>();
        this.constructorParams.add(xWalkView);
        reflectionInit();
        AppMethodBeat.o(154725);
    }

    public XWalkView getXWalkView() {
        return this.mXWalkView;
    }

    public void onKeyboardHeightChanged(boolean z, int i2, boolean z2) {
        AppMethodBeat.i(154726);
        try {
            Log.i(TAG, "onKeyboardHeightChanged isKeyboardShowing:" + z + ",keyboardHeight:" + i2 + ",usingDefaultKeyboard:" + z2);
            this.onKeyboardHeightChangedbooleanintbooleanMethod.invoke(Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2));
            AppMethodBeat.o(154726);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154726);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154726);
        }
    }

    public boolean onShowKeyboard(String str, InputConnection inputConnection, ResultReceiver resultReceiver) {
        return false;
    }

    public boolean onHideKeyboard(String str, InputConnection inputConnection) {
        return false;
    }

    public boolean onShowKeyboardConfig(int i2, int i3, String str, int i4, int i5, EditorInfo editorInfo) {
        return false;
    }

    public int getToolBarHeight(int i2) {
        return 0;
    }

    public boolean performEditorAction(int i2) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154727);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154727);
            return;
        }
        int size = this.constructorTypes.size();
        Class[] clsArr = new Class[(size + 1)];
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = this.constructorTypes.get(i2);
            if (obj instanceof String) {
                clsArr[i2] = this.coreWrapper.getBridgeClass((String) obj);
                this.constructorParams.set(i2, this.coreWrapper.getBridgeObject(this.constructorParams.get(i2)));
            } else if (obj instanceof Class) {
                clsArr[i2] = (Class) obj;
            } else if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(154727);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtendTextAreaClientBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.onKeyboardHeightChangedbooleanintbooleanMethod.init(this.bridge, null, "onKeyboardHeightChanged", Boolean.TYPE, Integer.TYPE, Boolean.TYPE);
            AppMethodBeat.o(154727);
        } catch (UnsupportedOperationException e2) {
            AppMethodBeat.o(154727);
        }
    }
}
