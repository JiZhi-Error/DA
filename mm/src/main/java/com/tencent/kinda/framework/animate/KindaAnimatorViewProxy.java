package com.tencent.kinda.framework.animate;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import com.tencent.kinda.framework.widget.base.MMKView;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Deprecated
public class KindaAnimatorViewProxy implements InvocationHandler {
    private static final String TAG = "MicroMsg.Kinda.KindaAnimatorViewProxy";
    private static ArgbEvaluator defaultArgbEvaluator = new ArgbEvaluator();
    private static DoubleEvaluator defaultDoubleEvaluator = new DoubleEvaluator();
    private static LongEvaluator defaultLongEvaluator = new LongEvaluator();
    private MMKView target = null;

    public void setTarget(MMKView mMKView) {
        this.target = mMKView;
    }

    public MMKView getTarget() {
        return this.target;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String propName;
        Method method2;
        ValueAnimator buildAnimator;
        AppMethodBeat.i(18311);
        try {
            if (!KindaGlobalAnimator.hasAnimate() || !method.getName().startsWith("set") || !checkHasPrimitiveTypeParams(objArr) || method.getReturnType() != Void.TYPE || (propName = propName(method)) == null || propName.length() <= 0 || (method2 = getterMethod(this.target.getClass(), propName)) == null || (buildAnimator = buildAnimator(method, method2, objArr[0])) == null) {
                Object invoke = method.invoke(this.target, unwrapProxyParams(objArr));
                AppMethodBeat.o(18311);
                return invoke;
            }
            KindaGlobalAnimator.addAnimator(buildAnimator);
            AppMethodBeat.o(18311);
            return null;
        } catch (InvocationTargetException e2) {
            Log.printErrStackTrace(TAG, e2, "invoke %s error: %s %s", method.getName(), e2.getMessage(), this.target);
            AppMethodBeat.o(18311);
            return null;
        } catch (IllegalAccessException e3) {
            Log.printErrStackTrace(TAG, e3, "invoke %s error: %s %s", method.getName(), e3.getMessage(), this.target);
            AppMethodBeat.o(18311);
            return null;
        } catch (IllegalArgumentException e4) {
            Log.printErrStackTrace(TAG, e4, "invoke %s error: %s %s", method.getName(), e4.getMessage(), this.target);
            AppMethodBeat.o(18311);
            return null;
        }
    }

    private Object[] unwrapProxyParams(Object[] objArr) {
        AppMethodBeat.i(18312);
        if (objArr == null || objArr.length <= 0) {
            AppMethodBeat.o(18312);
            return objArr;
        }
        Object[] objArr2 = new Object[objArr.length];
        int i2 = 0;
        for (Object obj : objArr) {
            objArr2[i2] = obj;
            if (obj instanceof Proxy) {
                try {
                    InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
                    if (invocationHandler instanceof KindaAnimatorViewProxy) {
                        objArr2[i2] = ((KindaAnimatorViewProxy) invocationHandler).target;
                    }
                } catch (Exception e2) {
                    objArr2[i2] = obj;
                }
            }
            i2++;
        }
        AppMethodBeat.o(18312);
        return objArr2;
    }

    public static KView unWrapRealObj(Object obj) {
        AppMethodBeat.i(18313);
        if (obj instanceof Proxy) {
            try {
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
                if (invocationHandler instanceof KindaAnimatorViewProxy) {
                    MMKView mMKView = ((KindaAnimatorViewProxy) invocationHandler).target;
                    AppMethodBeat.o(18313);
                    return mMKView;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "unWrapRealObj %s", e2.getMessage());
            }
        }
        if (obj instanceof KView) {
            KView kView = (KView) obj;
            AppMethodBeat.o(18313);
            return kView;
        }
        AppMethodBeat.o(18313);
        return null;
    }

    /* access modifiers changed from: package-private */
    public static class LongEvaluator implements TypeEvaluator<Number> {
        LongEvaluator() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Number evaluate(float f2, Number number, Number number2) {
            AppMethodBeat.i(18310);
            Number evaluate = evaluate(f2, number, number2);
            AppMethodBeat.o(18310);
            return evaluate;
        }

        public Number evaluate(float f2, Number number, Number number2) {
            AppMethodBeat.i(18309);
            long longValue = number.longValue();
            Long valueOf = Long.valueOf((long) ((((float) (number2.longValue() - longValue)) * f2) + ((float) longValue)));
            AppMethodBeat.o(18309);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    public static class DoubleEvaluator implements TypeEvaluator<Number> {
        DoubleEvaluator() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Number evaluate(float f2, Number number, Number number2) {
            AppMethodBeat.i(18308);
            Number evaluate = evaluate(f2, number, number2);
            AppMethodBeat.o(18308);
            return evaluate;
        }

        public Number evaluate(float f2, Number number, Number number2) {
            AppMethodBeat.i(18307);
            double doubleValue = number.doubleValue();
            Double valueOf = Double.valueOf(doubleValue + (((double) f2) * (number2.doubleValue() - doubleValue)));
            AppMethodBeat.o(18307);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(18319);
        AppMethodBeat.o(18319);
    }

    private ValueAnimator buildAnimator(final Method method, Method method2, Object obj) {
        AppMethodBeat.i(18314);
        if (obj.getClass().equals(Integer.class)) {
            ValueAnimator ofInt = ValueAnimator.ofInt(((Integer) method2.invoke(this.target, new Object[0])).intValue(), ((Integer) obj).intValue());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.kinda.framework.animate.KindaAnimatorViewProxy.AnonymousClass1 */

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(18302);
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    try {
                        method.invoke(KindaAnimatorViewProxy.this.target, Integer.valueOf(intValue));
                        AppMethodBeat.o(18302);
                    } catch (Exception e2) {
                        AppMethodBeat.o(18302);
                    }
                }
            });
            ofInt.setDuration(KindaGlobalAnimator.animateDuration());
            AppMethodBeat.o(18314);
            return ofInt;
        }
        if (obj.getClass().equals(Long.class)) {
            if (method.getName().equals(u.NAME)) {
                ValueAnimator.ofObject(defaultArgbEvaluator, Integer.valueOf((int) ((Long) method2.invoke(this.target, new Object[0])).longValue()), Integer.valueOf((int) ((Long) obj).longValue())).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.kinda.framework.animate.KindaAnimatorViewProxy.AnonymousClass2 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(18303);
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        try {
                            method.invoke(KindaAnimatorViewProxy.this.target, Long.valueOf((long) intValue));
                            AppMethodBeat.o(18303);
                        } catch (Exception e2) {
                            AppMethodBeat.o(18303);
                        }
                    }
                });
            } else {
                ValueAnimator ofObject = ValueAnimator.ofObject(defaultLongEvaluator, (Long) method2.invoke(this.target, new Object[0]), (Long) obj);
                ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.kinda.framework.animate.KindaAnimatorViewProxy.AnonymousClass3 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(18304);
                        long longValue = ((Long) valueAnimator.getAnimatedValue()).longValue();
                        try {
                            method.invoke(KindaAnimatorViewProxy.this.target, Long.valueOf(longValue));
                            AppMethodBeat.o(18304);
                        } catch (Exception e2) {
                            AppMethodBeat.o(18304);
                        }
                    }
                });
                ofObject.setDuration(KindaGlobalAnimator.animateDuration());
                AppMethodBeat.o(18314);
                return ofObject;
            }
        } else if (obj.getClass().equals(Float.class)) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) method2.invoke(this.target, new Object[0])).floatValue(), ((Float) obj).floatValue());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.kinda.framework.animate.KindaAnimatorViewProxy.AnonymousClass4 */

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(18305);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    try {
                        method.invoke(KindaAnimatorViewProxy.this.target, Float.valueOf(floatValue));
                        AppMethodBeat.o(18305);
                    } catch (Exception e2) {
                        AppMethodBeat.o(18305);
                    }
                }
            });
            ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
            AppMethodBeat.o(18314);
            return ofFloat;
        } else if (obj.getClass().equals(Double.class)) {
            ValueAnimator ofObject2 = ValueAnimator.ofObject(defaultDoubleEvaluator, (Double) method2.invoke(this.target, new Object[0]), (Double) obj);
            ofObject2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.kinda.framework.animate.KindaAnimatorViewProxy.AnonymousClass5 */

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(18306);
                    double doubleValue = ((Double) valueAnimator.getAnimatedValue()).doubleValue();
                    try {
                        method.invoke(KindaAnimatorViewProxy.this.target, Double.valueOf(doubleValue));
                        AppMethodBeat.o(18306);
                    } catch (Exception e2) {
                        AppMethodBeat.o(18306);
                    }
                }
            });
            ofObject2.setDuration(KindaGlobalAnimator.animateDuration());
            AppMethodBeat.o(18314);
            return ofObject2;
        }
        AppMethodBeat.o(18314);
        return null;
    }

    private Method getterMethod(Class cls, String str) {
        AppMethodBeat.i(18315);
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getName().toLowerCase().endsWith(str.toLowerCase())) {
                AppMethodBeat.o(18315);
                return method;
            }
        }
        AppMethodBeat.o(18315);
        return null;
    }

    private String propName(Method method) {
        AppMethodBeat.i(18316);
        if (method == null || !method.getName().startsWith("set")) {
            AppMethodBeat.o(18316);
            return null;
        }
        String substring = method.getName().substring(3);
        AppMethodBeat.o(18316);
        return substring;
    }

    private boolean checkHasPrimitiveTypeParams(Object[] objArr) {
        AppMethodBeat.i(18317);
        if (objArr == null || objArr.length <= 0) {
            AppMethodBeat.o(18317);
            return false;
        }
        if (objArr.length == 1) {
            Object obj = objArr[0];
            if (obj.getClass().isPrimitive()) {
                AppMethodBeat.o(18317);
                return true;
            } else if (obj.getClass().equals(Integer.class) || obj.getClass().equals(Long.class) || obj.getClass().equals(Float.class) || obj.getClass().equals(Double.class)) {
                AppMethodBeat.o(18317);
                return true;
            }
        }
        AppMethodBeat.o(18317);
        return false;
    }

    public static Object unwrapProxyObject(Object obj) {
        AppMethodBeat.i(18318);
        if (obj instanceof Proxy) {
            try {
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
                if (invocationHandler instanceof KindaAnimatorViewProxy) {
                    obj = ((KindaAnimatorViewProxy) invocationHandler).target;
                    AppMethodBeat.o(18318);
                    return obj;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(18318);
            }
        }
        AppMethodBeat.o(18318);
        return obj;
    }
}
