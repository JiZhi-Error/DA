package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class d {
    final e szL;
    final com.tencent.mm.hellhoundlib.d szM = new com.tencent.mm.hellhoundlib.d() {
        /* class com.tencent.mm.plugin.expt.hellhound.core.b.a.d.AnonymousClass1 */

        @Override // com.tencent.mm.hellhoundlib.d
        public final void b(Object obj, Intent intent) {
            AppMethodBeat.i(121948);
            Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivity: %s, %d", obj.getClass().getName(), Integer.valueOf(obj.hashCode()));
            if (d.this.szL != null) {
                if (obj instanceof Activity) {
                    d.this.szL.a((Activity) obj, intent);
                    AppMethodBeat.o(121948);
                    return;
                }
                d.this.szL.a(null, intent);
            }
            AppMethodBeat.o(121948);
        }

        @Override // com.tencent.mm.hellhoundlib.d
        public final void a(Object obj, Intent[] intentArr) {
            AppMethodBeat.i(121949);
            Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivities: %s, %d", obj.getClass().getName(), Integer.valueOf(obj.hashCode()));
            if (d.this.szL == null || intentArr == null || intentArr.length <= 0) {
                AppMethodBeat.o(121949);
                return;
            }
            d.this.szL.a((Activity) obj, intentArr[0]);
            AppMethodBeat.o(121949);
        }

        @Override // com.tencent.mm.hellhoundlib.d
        public final void x(Activity activity) {
            AppMethodBeat.i(121950);
            Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, finish: %s, %d", activity.getClass().getName(), Integer.valueOf(activity.hashCode()));
            if (d.this.szL != null) {
                d.this.szL.P(activity);
            }
            AppMethodBeat.o(121950);
        }

        @Override // com.tencent.mm.hellhoundlib.d
        public final void c(Object obj, boolean z) {
            AppMethodBeat.i(121951);
            Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, moveTaskToBack: %s, %d", obj.getClass().getName(), Integer.valueOf(obj.hashCode()));
            if (d.this.szL != null) {
                d.this.szL.b((Activity) obj, z);
            }
            AppMethodBeat.o(121951);
        }

        @Override // com.tencent.mm.hellhoundlib.d
        public final void bf(Object obj) {
            AppMethodBeat.i(121952);
            Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onCreate: %s, %d", obj.getClass().getName(), Integer.valueOf(obj.hashCode()));
            if (d.this.szL != null) {
                Activity activity = (Activity) obj;
                d.this.szL.d(activity.getIntent(), activity);
            }
            AppMethodBeat.o(121952);
        }

        @Override // com.tencent.mm.hellhoundlib.d
        public final void c(Object obj, Intent intent) {
            AppMethodBeat.i(121953);
            Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onNewIntent: %s, %d", obj.getClass().getName(), Integer.valueOf(obj.hashCode()));
            if (d.this.szL != null) {
                d.this.szL.e(intent, (Activity) obj);
            }
            AppMethodBeat.o(121953);
        }

        @Override // com.tencent.mm.hellhoundlib.d
        public final void bg(Object obj) {
            AppMethodBeat.i(121954);
            Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onResume: %s, %d", obj.getClass().getName(), Integer.valueOf(obj.hashCode()));
            if (d.this.szL != null) {
                d.this.szL.Q((Activity) obj);
            }
            AppMethodBeat.o(121954);
        }

        @Override // com.tencent.mm.hellhoundlib.d
        public final void bh(Object obj) {
            AppMethodBeat.i(121955);
            Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onPostResume: %s, %d", obj.getClass().getName(), Integer.valueOf(obj.hashCode()));
            if (d.this.szL != null) {
                d.this.szL.R((Activity) obj);
            }
            AppMethodBeat.o(121955);
        }

        @Override // com.tencent.mm.hellhoundlib.d
        public final void bi(Object obj) {
            AppMethodBeat.i(121956);
            Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onPause: %s, %d", obj.getClass().getName(), Integer.valueOf(obj.hashCode()));
            if (d.this.szL != null) {
                d.this.szL.S((Activity) obj);
                d.this.szL.T((Activity) obj);
            }
            AppMethodBeat.o(121956);
        }

        @Override // com.tencent.mm.hellhoundlib.d
        public final void bj(Object obj) {
            AppMethodBeat.i(121957);
            Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onStop: %s, %d", obj.getClass().getName(), Integer.valueOf(obj.hashCode()));
            if (d.this.szL != null) {
                d.this.szL.U((Activity) obj);
            }
            AppMethodBeat.o(121957);
        }

        @Override // com.tencent.mm.hellhoundlib.d
        public final void bk(Object obj) {
            AppMethodBeat.i(121958);
            Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, onDestroy: %s, %d", obj.getClass().getName(), Integer.valueOf(obj.hashCode()));
            if (d.this.szL != null) {
                d.this.szL.V((Activity) obj);
            }
            AppMethodBeat.o(121958);
        }
    };
    final b szN = new b() {
        /* class com.tencent.mm.plugin.expt.hellhound.core.b.a.d.AnonymousClass2 */

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void c(String str, String str2, String str3, String str4, Object obj, Object[] objArr) {
            AppMethodBeat.i(220429);
            if (obj == null || objArr == null || objArr.length <= 0) {
                AppMethodBeat.o(220429);
                return;
            }
            if ((obj instanceof Context) && !(obj instanceof Activity)) {
                if ("startActivity".equals(str4)) {
                    if (d.this.szL != null && (objArr[0] instanceof Intent)) {
                        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivity: %s, %s, %s, %d, %s", str, str2, obj.getClass().getName(), Integer.valueOf(obj.hashCode()), "from: mContextListener");
                        d.this.szL.a(null, (Intent) objArr[0]);
                        AppMethodBeat.o(220429);
                        return;
                    }
                } else if ("startActivities".equals(str4) && d.this.szL != null && (objArr[0] instanceof Intent[])) {
                    Intent[] intentArr = (Intent[]) objArr[0];
                    if (intentArr.length > 0) {
                        Log.i("HABBYGE-MALI.HellActivityStub", "mOnActivityListener, startActivities: %s, %s, %s, %d, %s", str, str2, obj.getClass().getName(), Integer.valueOf(obj.hashCode()), "from: mContextListener");
                        d.this.szL.a(null, intentArr[0]);
                    }
                }
            }
            AppMethodBeat.o(220429);
        }

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void a(String str, String str2, String str3, Object obj) {
        }
    };

    d(e eVar) {
        AppMethodBeat.i(121959);
        this.szL = eVar;
        AppMethodBeat.o(121959);
    }
}
