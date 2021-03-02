package com.tencent.matrix.iocanary.b;

import com.tencent.matrix.g.c;
import com.tencent.matrix.iocanary.c.a;
import com.tencent.matrix.report.d;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends d implements InvocationHandler {
    private final Object cUC;

    public b(d.a aVar, Object obj) {
        super(aVar);
        this.cUC = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        c.i("Matrix.CloseGuardInvocationHandler", "invoke method: %s", method.getName());
        if (!method.getName().equals("report")) {
            return method.invoke(this.cUC, objArr);
        }
        if (objArr.length != 2) {
            c.e("Matrix.CloseGuardInvocationHandler", "closeGuard report should has 2 params, current: %d", Integer.valueOf(objArr.length));
            return null;
        } else if (!(objArr[1] instanceof Throwable)) {
            c.e("Matrix.CloseGuardInvocationHandler", "closeGuard report args 1 should be throwable, current: %s", objArr[1]);
            return null;
        } else {
            String throwableStack = a.getThrowableStack((Throwable) objArr[1]);
            if (eC(throwableStack)) {
                c.d("Matrix.CloseGuardInvocationHandler", "close leak issue already published; key:%s", throwableStack);
            } else {
                com.tencent.matrix.report.c cVar = new com.tencent.matrix.report.c(4);
                cVar.key = throwableStack;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(SharePluginInfo.ISSUE_KEY_STACK, throwableStack);
                } catch (JSONException e2) {
                    c.e("Matrix.CloseGuardInvocationHandler", "json content error: %s", e2);
                }
                cVar.cWe = jSONObject;
                b(cVar);
                c.i("Matrix.CloseGuardInvocationHandler", "close leak issue publish, key:%s", throwableStack);
                eB(throwableStack);
            }
            return null;
        }
    }
}
