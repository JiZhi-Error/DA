package com.tencent.h.b;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.h.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class a {
    private static final g<a> SpT = new g<a>() {
        /* class com.tencent.h.b.a.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.h.c.g
        public final /* synthetic */ a oR() {
            AppMethodBeat.i(214607);
            a aVar = new a();
            AppMethodBeat.o(214607);
            return aVar;
        }
    };
    public final Map<Integer, Set<b>> SpR = new HashMap();
    private final Map<Integer, Set<Object>> SpS = new HashMap();

    public a() {
        AppMethodBeat.i(214609);
        AppMethodBeat.o(214609);
    }

    static {
        AppMethodBeat.i(214613);
        AppMethodBeat.o(214613);
    }

    public static a hpS() {
        AppMethodBeat.i(214610);
        a aVar = SpT.get();
        AppMethodBeat.o(214610);
        return aVar;
    }

    /* renamed from: com.tencent.h.b.a$a  reason: collision with other inner class name */
    public class View$OnTouchListenerC0141a implements View.OnTouchListener {
        private final View.OnTouchListener kjS;

        public View$OnTouchListenerC0141a(View.OnTouchListener onTouchListener) {
            this.kjS = onTouchListener;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(214608);
            if (a.this.SpR != null && !a.this.SpR.isEmpty()) {
                for (b bVar : (Set) a.this.SpR.get(Integer.valueOf(view.hashCode()))) {
                    bVar.onTouch(view, motionEvent);
                }
            }
            if (this.kjS != null) {
                boolean onTouch = this.kjS.onTouch(view, motionEvent);
                AppMethodBeat.o(214608);
                return onTouch;
            }
            AppMethodBeat.o(214608);
            return false;
        }
    }

    public static Object c(Class<?> cls, String str, Object obj) {
        AppMethodBeat.i(214611);
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            AppMethodBeat.o(214611);
            return obj2;
        } catch (Throwable th) {
            AppMethodBeat.o(214611);
            return null;
        }
    }

    public static Object hO(View view) {
        AppMethodBeat.i(214612);
        try {
            Method declaredMethod = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(view, new Object[0]);
            AppMethodBeat.o(214612);
            return invoke;
        } catch (Throwable th) {
            AppMethodBeat.o(214612);
            return null;
        }
    }
}
