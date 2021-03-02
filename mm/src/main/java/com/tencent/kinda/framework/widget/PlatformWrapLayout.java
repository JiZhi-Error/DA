package com.tencent.kinda.framework.widget;

import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.animate.KindaAnimatorViewProxy;
import com.tencent.kinda.framework.widget.base.MMKView;
import com.tencent.kinda.framework.widget.base.MMKViewLayout;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class PlatformWrapLayout extends MMKViewLayout {
    public PlatformWrapLayout(YogaLayout yogaLayout) {
        AppMethodBeat.i(18724);
        setView(yogaLayout);
        AppMethodBeat.o(18724);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKViewLayout, com.tencent.kinda.gen.KViewLayout
    public void addView(KView kView) {
        KView kView2;
        AppMethodBeat.i(18725);
        Object unwrapProxyObj = unwrapProxyObj(kView);
        Log.i("MMKViewLayout", "PlatformWrapLayout addView: %s %s", kView, unwrapProxyObj);
        if (unwrapProxyObj != null) {
            kView2 = (KView) unwrapProxyObj;
        } else {
            kView2 = kView;
        }
        super.addView(kView2);
        AppMethodBeat.o(18725);
    }

    private Object unwrapProxyObj(Object obj) {
        AppMethodBeat.i(18726);
        if (obj instanceof Proxy) {
            try {
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
                if (invocationHandler instanceof KindaAnimatorViewProxy) {
                    MMKView target = ((KindaAnimatorViewProxy) invocationHandler).getTarget();
                    AppMethodBeat.o(18726);
                    return target;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(18726);
                return 0;
            }
        }
        AppMethodBeat.o(18726);
        return obj;
    }
}
