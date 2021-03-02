package com.tencent.mm.remoteservice;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class a extends b.a {
    protected RemoteService NCu;
    public b NCv;
    private final d gVN;

    public a(d dVar) {
        this.gVN = dVar;
    }

    @Override // com.tencent.mm.remoteservice.b
    public void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(152734);
        Log.d("MicroMsg.BaseClientRequest", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            Method[] methods = getClass().getMethods();
            int length = methods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Method method2 = methods[i2];
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
                i2++;
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() != Void.TYPE) {
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
            AppMethodBeat.o(152734);
        } catch (Exception e2) {
            Log.e("MicroMsg.BaseClientRequest", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(152734);
        }
    }

    public Object REMOTE_CALL(final String str, final Object... objArr) {
        AppMethodBeat.i(152735);
        if (this.gVN.isConnected()) {
            Bundle objectsToBundle = objectsToBundle(objArr);
            this.gVN.a(this, str, objectsToBundle);
            objectsToBundle.setClassLoader(getClass().getClassLoader());
            Object obj = objectsToBundle.get("result_key");
            AppMethodBeat.o(152735);
            return obj;
        }
        this.gVN.connect(new Runnable() {
            /* class com.tencent.mm.remoteservice.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(152733);
                a.this.gVN.a(a.this, str, a.this.objectsToBundle(objArr));
                AppMethodBeat.o(152733);
            }
        });
        AppMethodBeat.o(152735);
        return null;
    }

    public Object CLIENT_CALL(String str, Object... objArr) {
        AppMethodBeat.i(152736);
        Bundle objectsToBundle = objectsToBundle(objArr);
        try {
            this.NCv.onCallback(str, objectsToBundle, true);
        } catch (Exception e2) {
            Log.e("MicroMsg.BaseClientRequest", "exception:%s", Util.stackTraceToString(e2));
        }
        Object obj = objectsToBundle.get("result_key");
        AppMethodBeat.o(152736);
        return obj;
    }

    /* access modifiers changed from: protected */
    public Bundle objectsToBundle(Object... objArr) {
        AppMethodBeat.i(152737);
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (objArr[i2] instanceof Bundle) {
                bundle.putBundle(String.valueOf(i2), (Bundle) objArr[i2]);
            } else if (objArr[i2] instanceof Parcelable) {
                bundle.putParcelable(String.valueOf(i2), (Parcelable) objArr[i2]);
            } else {
                bundle.putSerializable(String.valueOf(i2), (Serializable) objArr[i2]);
            }
        }
        AppMethodBeat.o(152737);
        return bundle;
    }

    public Object[] getArgs(Bundle bundle) {
        AppMethodBeat.i(152738);
        LinkedList linkedList = new LinkedList();
        int size = bundle.size();
        for (int i2 = 0; i2 < size; i2++) {
            String valueOf = String.valueOf(i2);
            if (bundle.containsKey(valueOf)) {
                linkedList.add(bundle.get(valueOf));
            }
        }
        Object[] array = linkedList.toArray();
        AppMethodBeat.o(152738);
        return array;
    }
}
