package com.tencent.i.a.c.c.a.a;

import android.app.Activity;
import android.app.Application;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.h.c.g;
import com.tencent.h.c.h;
import com.tencent.i.a.c.c.a.a.a.c;
import com.tencent.i.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static MMHandler PvY;
    private static final g<a> SpT = new g<a>() {
        /* class com.tencent.i.a.c.c.a.a.a.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.h.c.g
        public final /* synthetic */ a oR() {
            AppMethodBeat.i(214795);
            a aVar = new a((byte) 0);
            AppMethodBeat.o(214795);
            return aVar;
        }
    };
    private static boolean sInit = false;
    public final Map<String, b> SsZ;
    public com.tencent.i.a.c.c.a.a.a.a Sta;
    public final c Stb;
    public final f Stc;
    public com.tencent.h.b.b Std;

    /* synthetic */ a(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(214808);
        AppMethodBeat.o(214808);
    }

    public static a hqF() {
        AppMethodBeat.i(214801);
        a aVar = SpT.get();
        AppMethodBeat.o(214801);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(214802);
        this.SsZ = new HashMap();
        this.Sta = null;
        this.Stb = new c() {
            /* class com.tencent.i.a.c.c.a.a.a.AnonymousClass3 */

            @Override // com.tencent.i.a.c.c.a.a.a.c
            public final void b(String str, MotionEvent motionEvent) {
                AppMethodBeat.i(214797);
                if (TextUtils.isEmpty(str) || motionEvent == null) {
                    AppMethodBeat.o(214797);
                    return;
                }
                h.i("TuringTouch", "[method: onTouch sMyTouchCallback] " + motionEvent.getActionMasked());
                a.a(a.this, str, motionEvent);
                AppMethodBeat.o(214797);
            }
        };
        this.Stc = new f() {
            /* class com.tencent.i.a.c.c.a.a.a.AnonymousClass4 */

            @Override // com.tencent.i.a.f
            public final boolean a(com.tencent.i.a.g gVar, MotionEvent motionEvent) {
                AppMethodBeat.i(214798);
                if (gVar == null || motionEvent == null) {
                    AppMethodBeat.o(214798);
                } else {
                    String eH = a.eH(gVar);
                    if (!a.this.SsZ.containsKey(eH)) {
                        AppMethodBeat.o(214798);
                    } else {
                        h.i("TuringTouch", "[method: onTouch ] " + motionEvent.getAction());
                        a.a(a.this, eH, motionEvent);
                        AppMethodBeat.o(214798);
                    }
                }
                return false;
            }
        };
        this.Std = new com.tencent.h.b.b() {
            /* class com.tencent.i.a.c.c.a.a.a.AnonymousClass5 */

            @Override // com.tencent.h.b.b
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(214799);
                if (view == null || motionEvent == null) {
                    AppMethodBeat.o(214799);
                } else {
                    h.i("TuringTouch", "[method: onTouch ] " + motionEvent.getAction());
                    a.a(a.this, a.eH(view), motionEvent);
                    AppMethodBeat.o(214799);
                }
                return false;
            }
        };
        if (!sInit) {
            sInit = true;
            hqG();
        }
        AppMethodBeat.o(214802);
    }

    private synchronized void hqG() {
        AppMethodBeat.i(214803);
        h.i("TuringTouch", "doInitDispatch");
        PvY = new C0144a("TuringDispatch");
        AppMethodBeat.o(214803);
    }

    public static void a(Activity activity, com.tencent.i.a.c.c.a.a.a.a aVar) {
        AppMethodBeat.i(214804);
        if (activity == null || aVar == null) {
            AppMethodBeat.o(214804);
            return;
        }
        Application application = activity.getApplication();
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(aVar);
        }
        AppMethodBeat.o(214804);
    }

    public static String eG(Object obj) {
        AppMethodBeat.i(214805);
        String valueOf = String.valueOf(obj.hashCode());
        AppMethodBeat.o(214805);
        return valueOf;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.i.a.c.c.a.a.a$a  reason: collision with other inner class name */
    public class C0144a extends MMHandler implements com.tencent.i.a.c.c.a.b {
        public C0144a(String str) {
            super(str);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(214800);
            switch (message.what) {
                case 1:
                    try {
                        if (message.obj == null) {
                            AppMethodBeat.o(214800);
                            return;
                        } else if (!(message.obj instanceof b)) {
                            AppMethodBeat.o(214800);
                            return;
                        } else {
                            b bVar = (b) message.obj;
                            if (a.this.SsZ == null || !a.this.SsZ.containsKey(bVar.key)) {
                                AppMethodBeat.o(214800);
                                return;
                            }
                            b bVar2 = (b) a.this.SsZ.get(bVar.key);
                            if (bVar2 != null) {
                                bVar2.a(bVar.Sth, this);
                            }
                            AppMethodBeat.o(214800);
                            return;
                        }
                    } catch (Throwable th) {
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(214800);
        }

        @Override // com.tencent.i.a.c.c.a.b
        public final MMHandler hqz() {
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        MotionEvent Sth;
        String key;

        private b() {
        }

        /* synthetic */ b(a aVar, byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(a aVar, String str, MotionEvent motionEvent) {
        AppMethodBeat.i(214806);
        try {
            b bVar = new b(aVar, (byte) 0);
            bVar.key = str;
            bVar.Sth = MotionEvent.obtain(motionEvent);
            if (PvY != null) {
                PvY.obtainMessage(1, bVar).sendToTarget();
            }
            AppMethodBeat.o(214806);
        } catch (Throwable th) {
            AppMethodBeat.o(214806);
        }
    }

    static /* synthetic */ String eH(Object obj) {
        AppMethodBeat.i(214807);
        String valueOf = String.valueOf(obj.hashCode());
        AppMethodBeat.o(214807);
        return valueOf;
    }
}
