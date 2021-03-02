package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class ClientCertRequestHandler implements ClientCertRequest {
    private Object bridge;
    private ReflectMethod cancelMethod = new ReflectMethod((Class<?>) null, "cancel", (Class<?>[]) new Class[0]);
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getHostMethod = new ReflectMethod((Class<?>) null, "getHost", (Class<?>[]) new Class[0]);
    private ReflectMethod getKeyTypesMethod = new ReflectMethod((Class<?>) null, "getKeyTypes", (Class<?>[]) new Class[0]);
    private ReflectMethod getPortMethod = new ReflectMethod((Class<?>) null, "getPort", (Class<?>[]) new Class[0]);
    private ReflectMethod getPrincipalsMethod = new ReflectMethod((Class<?>) null, "getPrincipals", (Class<?>[]) new Class[0]);
    private ReflectMethod ignoreMethod = new ReflectMethod((Class<?>) null, "ignore", (Class<?>[]) new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod proceedPrivateKeyListMethod = new ReflectMethod((Class<?>) null, "proceed", (Class<?>[]) new Class[0]);

    /* access modifiers changed from: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public ClientCertRequestHandler(Object obj) {
        AppMethodBeat.i(154590);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(154590);
    }

    @Override // org.xwalk.core.ClientCertRequest
    public void proceed(PrivateKey privateKey, List<X509Certificate> list) {
        AppMethodBeat.i(154591);
        try {
            this.proceedPrivateKeyListMethod.invoke(privateKey, list);
            AppMethodBeat.o(154591);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154591);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154591);
        }
    }

    @Override // org.xwalk.core.ClientCertRequest
    public void ignore() {
        AppMethodBeat.i(154592);
        try {
            this.ignoreMethod.invoke(new Object[0]);
            AppMethodBeat.o(154592);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154592);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154592);
        }
    }

    @Override // org.xwalk.core.ClientCertRequest
    public void cancel() {
        AppMethodBeat.i(154593);
        try {
            this.cancelMethod.invoke(new Object[0]);
            AppMethodBeat.o(154593);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154593);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154593);
        }
    }

    @Override // org.xwalk.core.ClientCertRequest
    public String getHost() {
        AppMethodBeat.i(154594);
        try {
            String str = (String) this.getHostMethod.invoke(new Object[0]);
            AppMethodBeat.o(154594);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154594);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154594);
            return null;
        }
    }

    @Override // org.xwalk.core.ClientCertRequest
    public int getPort() {
        AppMethodBeat.i(154595);
        try {
            int intValue = ((Integer) this.getPortMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(154595);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154595);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154595);
            return 0;
        }
    }

    @Override // org.xwalk.core.ClientCertRequest
    public String[] getKeyTypes() {
        AppMethodBeat.i(154596);
        try {
            String[] strArr = (String[]) this.getKeyTypesMethod.invoke(new Object[0]);
            AppMethodBeat.o(154596);
            return strArr;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154596);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154596);
            return null;
        }
    }

    @Override // org.xwalk.core.ClientCertRequest
    public Principal[] getPrincipals() {
        AppMethodBeat.i(154597);
        try {
            Principal[] principalArr = (Principal[]) this.getPrincipalsMethod.invoke(new Object[0]);
            AppMethodBeat.o(154597);
            return principalArr;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(154597);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(154597);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(154598);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(154598);
            return;
        }
        this.proceedPrivateKeyListMethod.init(this.bridge, null, "proceedSuper", PrivateKey.class, List.class);
        this.ignoreMethod.init(this.bridge, null, "ignoreSuper", new Class[0]);
        this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
        this.getHostMethod.init(this.bridge, null, "getHostSuper", new Class[0]);
        this.getPortMethod.init(this.bridge, null, "getPortSuper", new Class[0]);
        this.getKeyTypesMethod.init(this.bridge, null, "getKeyTypesSuper", new Class[0]);
        this.getPrincipalsMethod.init(this.bridge, null, "getPrincipalsSuper", new Class[0]);
        AppMethodBeat.o(154598);
    }
}
