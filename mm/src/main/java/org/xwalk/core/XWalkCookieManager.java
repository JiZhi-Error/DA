package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import org.xwalk.core.util.WebAddress;

public class XWalkCookieManager {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkCookieManager.class.desiredAssertionStatus());
    private static final String TAG = "XWalkCookieManager";
    private ReflectMethod acceptCookieMethod = new ReflectMethod((Class<?>) null, "acceptCookie", (Class<?>[]) new Class[0]);
    private ReflectMethod allowFileSchemeCookiesMethod = new ReflectMethod((Class<?>) null, "allowFileSchemeCookies", (Class<?>[]) new Class[0]);
    private Object bridge;
    private ArrayList<Object> constructorParams = new ArrayList<>();
    private ArrayList<Object> constructorTypes = new ArrayList<>();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod flushCookieStoreMethod = new ReflectMethod((Class<?>) null, "flushCookieStore", (Class<?>[]) new Class[0]);
    private ReflectMethod getCookieStringMethod = new ReflectMethod((Class<?>) null, "getCookie", (Class<?>[]) new Class[0]);
    private ReflectMethod hasCookiesMethod = new ReflectMethod((Class<?>) null, "hasCookies", (Class<?>[]) new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod removeAllCookieMethod = new ReflectMethod((Class<?>) null, "removeAllCookie", (Class<?>[]) new Class[0]);
    private ReflectMethod removeExpiredCookieMethod = new ReflectMethod((Class<?>) null, "removeExpiredCookie", (Class<?>[]) new Class[0]);
    private ReflectMethod removeSessionCookieMethod = new ReflectMethod((Class<?>) null, "removeSessionCookie", (Class<?>[]) new Class[0]);
    private ReflectMethod setAcceptCookiebooleanMethod = new ReflectMethod((Class<?>) null, "setAcceptCookie", (Class<?>[]) new Class[0]);
    private ReflectMethod setAcceptFileSchemeCookiesbooleanMethod = new ReflectMethod((Class<?>) null, "setAcceptFileSchemeCookies", (Class<?>[]) new Class[0]);
    private ReflectMethod setCookieStringStringMethod = new ReflectMethod((Class<?>) null, "setCookie", (Class<?>[]) new Class[0]);

    static {
        AppMethodBeat.i(154642);
        AppMethodBeat.o(154642);
    }

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkCookieManager() {
        AppMethodBeat.i(154629);
        reflectionInit();
        AppMethodBeat.o(154629);
    }

    public void setAcceptCookie(boolean z) {
        AppMethodBeat.i(154630);
        try {
            this.setAcceptCookiebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154630);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154630);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154630);
        }
    }

    public boolean acceptCookie() {
        AppMethodBeat.i(154631);
        try {
            boolean booleanValue = ((Boolean) this.acceptCookieMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154631);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154631);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154631);
            return false;
        }
    }

    public void setCookie(String str, String str2) {
        AppMethodBeat.i(154632);
        try {
            str = new WebAddress(str).toString();
        } catch (Exception e2) {
            Log.e(TAG, "setCookie transform url to WebAddress failed");
        }
        try {
            this.setCookieStringStringMethod.invoke(str, str2);
            AppMethodBeat.o(154632);
        } catch (UnsupportedOperationException e3) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154632);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e3);
            AppMethodBeat.o(154632);
        }
    }

    public String getCookie(String str) {
        AppMethodBeat.i(154633);
        try {
            str = new WebAddress(str).toString();
        } catch (Exception e2) {
            Log.e(TAG, "getCookie transform url to WebAddress failed");
        }
        try {
            String str2 = (String) this.getCookieStringMethod.invoke(str);
            AppMethodBeat.o(154633);
            return str2;
        } catch (UnsupportedOperationException e3) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154633);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e3);
            AppMethodBeat.o(154633);
            return null;
        }
    }

    public void removeSessionCookie() {
        AppMethodBeat.i(154634);
        try {
            this.removeSessionCookieMethod.invoke(new Object[0]);
            AppMethodBeat.o(154634);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154634);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154634);
        }
    }

    public void removeAllCookie() {
        AppMethodBeat.i(154635);
        try {
            this.removeAllCookieMethod.invoke(new Object[0]);
            AppMethodBeat.o(154635);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154635);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154635);
        }
    }

    public boolean hasCookies() {
        AppMethodBeat.i(154636);
        try {
            boolean booleanValue = ((Boolean) this.hasCookiesMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154636);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154636);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154636);
            return false;
        }
    }

    public void removeExpiredCookie() {
        AppMethodBeat.i(154637);
        try {
            this.removeExpiredCookieMethod.invoke(new Object[0]);
            AppMethodBeat.o(154637);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154637);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154637);
        }
    }

    public void flushCookieStore() {
        AppMethodBeat.i(154638);
        try {
            this.flushCookieStoreMethod.invoke(new Object[0]);
            AppMethodBeat.o(154638);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154638);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154638);
        }
    }

    public boolean allowFileSchemeCookies() {
        AppMethodBeat.i(154639);
        try {
            boolean booleanValue = ((Boolean) this.allowFileSchemeCookiesMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(154639);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154639);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154639);
            return false;
        }
    }

    public void setAcceptFileSchemeCookies(boolean z) {
        AppMethodBeat.i(154640);
        try {
            this.setAcceptFileSchemeCookiesbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(154640);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154640);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154640);
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154641);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154641);
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
                AppMethodBeat.o(154641);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkCookieManagerBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.setAcceptCookiebooleanMethod.init(this.bridge, null, "setAcceptCookieSuper", Boolean.TYPE);
            this.acceptCookieMethod.init(this.bridge, null, "acceptCookieSuper", new Class[0]);
            this.setCookieStringStringMethod.init(this.bridge, null, "setCookieSuper", String.class, String.class);
            this.getCookieStringMethod.init(this.bridge, null, "getCookieSuper", String.class);
            this.removeSessionCookieMethod.init(this.bridge, null, "removeSessionCookieSuper", new Class[0]);
            this.removeAllCookieMethod.init(this.bridge, null, "removeAllCookieSuper", new Class[0]);
            this.hasCookiesMethod.init(this.bridge, null, "hasCookiesSuper", new Class[0]);
            this.removeExpiredCookieMethod.init(this.bridge, null, "removeExpiredCookieSuper", new Class[0]);
            this.flushCookieStoreMethod.init(this.bridge, null, "flushCookieStoreSuper", new Class[0]);
            this.allowFileSchemeCookiesMethod.init(this.bridge, null, "allowFileSchemeCookiesSuper", new Class[0]);
            this.setAcceptFileSchemeCookiesbooleanMethod.init(this.bridge, null, "setAcceptFileSchemeCookiesSuper", Boolean.TYPE);
            AppMethodBeat.o(154641);
        } catch (UnsupportedOperationException e2) {
            AppMethodBeat.o(154641);
        }
    }
}
