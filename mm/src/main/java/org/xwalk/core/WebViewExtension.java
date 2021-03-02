package org.xwalk.core;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebViewExtension {
    static final /* synthetic */ boolean $assertionsDisabled = (!WebViewExtension.class.desiredAssertionStatus());
    public static final String EXTENSION_ADD_FILTER_RESOURCES = "AddFilterResources";
    private static final String TAG = "XWalkLib.WebViewExtension";
    private static WebViewExtensionInterface mWebViewExtensionInterface;
    private static WebViewExtensionListener mWebViewExtensionListener;
    private static WebViewExtension sInstance;
    private ReflectMethod SetExtensionMethod = new ReflectMethod((Class<?>) null, "SetExtension", (Class<?>[]) new Class[0]);
    private Object bridge;
    private ArrayList<Object> constructorParams = new ArrayList<>();
    private ArrayList<Object> constructorTypes = new ArrayList<>();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;

    static {
        AppMethodBeat.i(154624);
        AppMethodBeat.o(154624);
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    private static WebViewExtension getInstance() {
        AppMethodBeat.i(154617);
        if (sInstance == null) {
            sInstance = new WebViewExtension();
        }
        WebViewExtension webViewExtension = sInstance;
        AppMethodBeat.o(154617);
        return webViewExtension;
    }

    public WebViewExtension() {
        AppMethodBeat.i(154618);
        reflectionInit();
        AppMethodBeat.o(154618);
    }

    public static void SetExtension(WebViewExtensionListener webViewExtensionListener) {
        AppMethodBeat.i(154619);
        Log.i(TAG, "SetExtension WebViewExtensionInterface");
        mWebViewExtensionListener = webViewExtensionListener;
        try {
            updateExtension(true);
            AppMethodBeat.o(154619);
        } catch (Exception e2) {
            Log.i(TAG, "SetExtension refelction not ready, updateExtension when available:" + e2.getMessage());
            AppMethodBeat.o(154619);
        }
    }

    public static void updateExtension(boolean z) {
        AppMethodBeat.i(154620);
        if (mWebViewExtensionListener != null && (z || mWebViewExtensionInterface == null)) {
            getInstance();
            Log.i(TAG, "updateExtension");
            mWebViewExtensionInterface = new WebViewExtensionInterface() {
                /* class org.xwalk.core.WebViewExtension.AnonymousClass1 */

                @Override // org.xwalk.core.WebViewExtensionInterface
                public final Object onMiscCallBack(String str, Object... objArr) {
                    AppMethodBeat.i(154615);
                    if (WebViewExtension.mWebViewExtensionListener != null) {
                        Object onMiscCallBack = WebViewExtension.mWebViewExtensionListener.onMiscCallBack(str, objArr);
                        AppMethodBeat.o(154615);
                        return onMiscCallBack;
                    }
                    AppMethodBeat.o(154615);
                    return null;
                }

                @Override // org.xwalk.core.WebViewExtensionInterface
                public final int getHostByName(String str, List<String> list) {
                    AppMethodBeat.i(154616);
                    if (WebViewExtension.mWebViewExtensionListener != null) {
                        int hostByName = WebViewExtension.mWebViewExtensionListener.getHostByName(str, list);
                        AppMethodBeat.o(154616);
                        return hostByName;
                    }
                    AppMethodBeat.o(154616);
                    return 0;
                }
            };
            getInstance().SetExtensionMethod.invoke(mWebViewExtensionInterface.getBridge());
        }
        AppMethodBeat.o(154620);
    }

    public static boolean addFilterResources(Resources resources, Map<Long, Integer> map) {
        AppMethodBeat.i(154621);
        boolean invokeExtensionMethod = invokeExtensionMethod(EXTENSION_ADD_FILTER_RESOURCES, resources, map);
        AppMethodBeat.o(154621);
        return invokeExtensionMethod;
    }

    public static boolean invokeExtensionMethod(String str, Object... objArr) {
        AppMethodBeat.i(154622);
        if (mWebViewExtensionListener != null) {
            mWebViewExtensionListener.onMiscCallBack(str, objArr);
            AppMethodBeat.o(154622);
            return true;
        }
        Log.e(TAG, "InvokeExtensionMethod interface is null,method:".concat(String.valueOf(str)));
        AppMethodBeat.o(154622);
        return false;
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154623);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154623);
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
                AppMethodBeat.o(154623);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("WebViewExtensionBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.SetExtensionMethod.init(this.bridge, null, "SetExtensionSuper", this.coreWrapper.getBridgeClass("WebViewExtensionInterfaceBridge"));
            AppMethodBeat.o(154623);
        } catch (UnsupportedOperationException e2) {
            AppMethodBeat.o(154623);
        }
    }
}
