package com.tencent.mm.plugin.normsg.d;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.WeakHashMap;

public final class c {
    private static final Map<View, Class<? extends IEvent>> AGe = new WeakHashMap();
    private static final Map<View, Boolean> AGf = new WeakHashMap();

    static {
        AppMethodBeat.i(149088);
        AppMethodBeat.o(149088);
    }

    public static void a(View view, Class<? extends IEvent> cls) {
        View.OnClickListener onClickListener;
        View.OnTouchListener onTouchListener;
        AppMethodBeat.i(149087);
        if (view == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("target is null.");
            AppMethodBeat.o(149087);
            throw illegalArgumentException;
        } else if (cls == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("reportEventClass is null.");
            AppMethodBeat.o(149087);
            throw illegalArgumentException2;
        } else {
            Object b2 = i.b(view, "getListenerInfo", (Class<?>[]) null, new Object[0]);
            if (b2 != null) {
                onTouchListener = (View.OnTouchListener) i.d(b2, "mOnTouchListener");
                onClickListener = (View.OnClickListener) i.d(b2, "mOnClickListener");
            } else {
                onClickListener = null;
                onTouchListener = null;
            }
            if (onTouchListener == null) {
                view.setOnTouchListener(new b(null));
            } else if (!(onTouchListener instanceof b)) {
                view.setOnTouchListener(new b(onTouchListener));
            }
            if (onClickListener == null) {
                view.setOnClickListener(new a(null));
            } else if (!(onClickListener instanceof a)) {
                view.setOnClickListener(new a(onClickListener));
            }
            synchronized (AGe) {
                try {
                    AGe.put(view, cls);
                } finally {
                    AppMethodBeat.o(149087);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b implements View.OnTouchListener {
        private final View.OnTouchListener AGh;

        b(View.OnTouchListener onTouchListener) {
            this.AGh = onTouchListener;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(149086);
            synchronized (c.AGe) {
                try {
                    if (c.AGe.containsKey(view)) {
                        synchronized (c.AGf) {
                            try {
                                c.AGf.put(view, Boolean.TRUE);
                            } catch (Throwable th) {
                                AppMethodBeat.o(149086);
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.o(149086);
                    throw th2;
                }
            }
            if (this.AGh != null) {
                boolean onTouch = this.AGh.onTouch(view, motionEvent);
                AppMethodBeat.o(149086);
                return onTouch;
            }
            AppMethodBeat.o(149086);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a implements View.OnClickListener {
        private final View.OnClickListener AGg;

        a(View.OnClickListener onClickListener) {
            this.AGg = onClickListener;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(149085);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            synchronized (c.AGe) {
                try {
                    if (c.AGe.containsKey(view)) {
                        synchronized (c.AGf) {
                            try {
                                if (!c.AGf.containsKey(view)) {
                                    Class cls = (Class) c.AGe.get(view);
                                    if (cls != null) {
                                        try {
                                            EventCenter.instance.publish((IEvent) cls.newInstance());
                                        } catch (Throwable th) {
                                            Log.printErrStackTrace("MicroMsg.CBCH", th, "failure to instantiate event class: " + cls.getName(), new Object[0]);
                                        }
                                    }
                                } else {
                                    c.AGf.remove(view);
                                }
                            } catch (Throwable th2) {
                                AppMethodBeat.o(149085);
                                throw th2;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    AppMethodBeat.o(149085);
                    throw th3;
                }
            }
            if (this.AGg != null) {
                this.AGg.onClick(view);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(149085);
        }
    }
}
