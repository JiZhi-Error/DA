package com.tencent.i.a.b;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.h.b.a;
import com.tencent.i.a.b.c.a.b;
import com.tencent.i.a.b.c.a.c;
import com.tencent.i.a.b.c.a.d;
import com.tencent.i.a.b.c.a.f;
import com.tencent.i.a.b.c.b;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.h;
import com.tencent.i.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class a extends com.tencent.i.a.a.a implements b, c, f, com.tencent.i.a.c.d.b {
    protected com.tencent.i.a.a.c SqM;
    protected h.a SqZ;
    protected b Sra;
    private com.tencent.i.a.c.a Srb;

    public a(String str, com.tencent.i.a.a.c cVar, b bVar) {
        super(str);
        this.SqM = cVar;
        this.Sra = bVar;
    }

    @Override // com.tencent.i.a.c.d.b
    public final void b(int i2, com.tencent.i.a.c.b.a aVar) {
        if (this.Srb != null) {
            this.Srb.a(i2, aVar);
        }
    }

    @Override // com.tencent.i.a.b.c.a.b
    public boolean hqe() {
        return false;
    }

    @Override // com.tencent.i.a.b.c.a.b
    public boolean hqf() {
        return false;
    }

    public boolean a(i.a aVar, long j2) {
        return false;
    }

    @Override // com.tencent.i.a.b.c.a.b
    public boolean hqg() {
        return false;
    }

    public void destroy() {
    }

    @Override // com.tencent.i.a.b.c.a.b
    public boolean YY() {
        return false;
    }

    public boolean YZ() {
        return false;
    }

    @Override // com.tencent.i.a.b.c.a.b
    public final h.a hqh() {
        return this.SqZ;
    }

    @Override // com.tencent.i.a.a.a
    public final void q(Throwable th) {
        if (this.SqM != null && this.SqM.SqP != null) {
            this.SqM.SqP.b(th, "turing_engine");
        }
    }

    @Override // com.tencent.i.a.b.c.a.c
    public final void kf(List<g> list) {
        j(3, 1, list);
    }

    @Override // com.tencent.i.a.b.c.a.f
    public final void a(com.tencent.i.a.c.b.i iVar) {
        com.tencent.h.c.h.i("sensor_AbsEngine", "[method: onTouchEventCallBack ] ");
        j(3, 11, iVar);
    }

    /* access modifiers changed from: protected */
    public final boolean hqi() {
        Set<com.tencent.h.b.b> set;
        char c2;
        com.tencent.h.c.h.i("sensor_AbsEngine", "[method: monitorView ] 111");
        if (this.SqZ == null) {
            return false;
        }
        d dVar = this.Sra.Sre.wLb.get(10);
        if (dVar instanceof com.tencent.i.a.b.c.b) {
            com.tencent.i.a.b.c.b bVar = (com.tencent.i.a.b.c.b) dVar;
            if (this.SqZ.Sqt != null) {
                com.tencent.h.c.h.i("sensor_AbsEngine", "[method: monitorView ] MonitorActivity");
                com.tencent.i.a.c.c.a.a.a hqF = com.tencent.i.a.c.c.a.a.a.hqF();
                Activity activity = this.SqZ.Sqt;
                AnonymousClass1 r5 = new com.tencent.i.a.c.c.a.a.a.a() {
                    /* class com.tencent.i.a.b.a.AnonymousClass1 */

                    @Override // com.tencent.i.a.c.c.a.a.a.a
                    public final void s(Activity activity, String str) {
                        AppMethodBeat.i(214697);
                        com.tencent.h.c.h.i("sensor_AbsEngine", "[method: onTryMonitor ] stopTasksImmediately when activity pause");
                        a.this.hqg();
                        AppMethodBeat.o(214697);
                    }
                };
                if (activity == null || bVar == null) {
                    return false;
                }
                String name = activity.getClass().getName();
                if (hqF.SsZ != null && !TextUtils.isEmpty(name) && !hqF.SsZ.containsKey(name)) {
                    hqF.SsZ.put(name, bVar);
                }
                com.tencent.i.a.c.c.a.a.a.a(activity, hqF.Sta);
                if (activity != null) {
                    hqF.Sta = new com.tencent.i.a.c.c.a.a.a.a(activity, r5) {
                        /* class com.tencent.i.a.c.c.a.a.a.AnonymousClass2 */
                        final /* synthetic */ Activity Ste;
                        final /* synthetic */ com.tencent.i.a.c.c.a.a.a.a Stf;

                        {
                            this.Ste = r2;
                            this.Stf = r3;
                        }

                        @Override // com.tencent.i.a.c.c.a.a.a.a
                        public final void s(Activity activity, String str) {
                            AppMethodBeat.i(214796);
                            if (activity != null && activity == this.Ste) {
                                com.tencent.h.c.h.i("TuringTouch", "[method: onTryMonitor ] " + activity + ", stateName : " + str);
                                if (this.Stf != null) {
                                    this.Stf.s(activity, str);
                                }
                            }
                            AppMethodBeat.o(214796);
                        }
                    };
                    Application application = activity.getApplication();
                    if (application != null) {
                        application.registerActivityLifecycleCallbacks(hqF.Sta);
                    }
                }
                com.tencent.h.c.h.i("TuringTouch", "[method: doInitActivity ] ");
                com.tencent.i.a.c.c.a.a.a.c cVar = hqF.Stb;
                Window window = activity.getWindow();
                Window.Callback callback = window.getCallback();
                if (callback == null) {
                    com.tencent.h.c.h.i("sensor_WindowCallbackManager", "not set callback");
                    return false;
                } else if (callback instanceof com.tencent.i.a.c.c.a.a.a.d) {
                    com.tencent.h.c.h.i("sensor_WindowCallbackManager", "[method: monitor ] callback is WindowCallbackWrapper");
                    return true;
                } else {
                    com.tencent.h.c.h.i("sensor_WindowCallbackManager", "set " + activity.getClass().getName() + " WindowCallback");
                    window.setCallback(new com.tencent.i.a.c.c.a.a.a.d(callback, cVar, activity.getClass().getName()));
                    return true;
                }
            } else if (this.SqZ.Squ != null) {
                com.tencent.h.c.h.i("sensor_AbsEngine", "[method: monitorView ] MonitorView");
                com.tencent.i.a.c.c.a.a.a hqF2 = com.tencent.i.a.c.c.a.a.a.hqF();
                View view = this.SqZ.Squ;
                if (view == null || bVar == null) {
                    return false;
                }
                String eG = com.tencent.i.a.c.c.a.a.a.eG(view);
                if (hqF2.SsZ != null && !TextUtils.isEmpty(eG) && !hqF2.SsZ.containsKey(eG)) {
                    hqF2.SsZ.put(eG, bVar);
                }
                com.tencent.h.b.a hpS = com.tencent.h.b.a.hpS();
                com.tencent.h.b.b bVar2 = hqF2.Std;
                Set<com.tencent.h.b.b> set2 = hpS.SpR.get(Integer.valueOf(view.hashCode()));
                if (set2 == null) {
                    set = new HashSet<>();
                    set.add(bVar2);
                } else {
                    set = set2;
                }
                set.add(bVar2);
                hpS.SpR.put(Integer.valueOf(view.hashCode()), set);
                com.tencent.h.b.a hpS2 = com.tencent.h.b.a.hpS();
                if (view == null) {
                    c2 = 65535;
                } else {
                    Object hO = com.tencent.h.b.a.hO(view);
                    if (hO == null) {
                        c2 = 65534;
                    } else {
                        Object c3 = com.tencent.h.b.a.c(hO.getClass(), "mOnTouchListener", hO);
                        if (c3 == null || !(c3 instanceof a.View$OnTouchListenerC0141a)) {
                            a.View$OnTouchListenerC0141a aVar = new a.View$OnTouchListenerC0141a((View.OnTouchListener) c3);
                            com.tencent.h.c.h.i("sensor_TouchEventWrapperManager", "[method: wrapperViewTouchEvent ] set TouchListenerWrapper");
                            view.setOnTouchListener(aVar);
                        }
                        c2 = 0;
                    }
                }
                return c2 == 0;
            } else if (this.SqZ.Sqv != null) {
                com.tencent.h.c.h.i("sensor_AbsEngine", "[method: monitorView ] MonitorTouchWrapper");
                com.tencent.i.a.c.c.a.a.a hqF3 = com.tencent.i.a.c.c.a.a.a.hqF();
                com.tencent.i.a.g gVar = this.SqZ.Sqv;
                if (gVar == null || bVar == null) {
                    return false;
                }
                String eG2 = com.tencent.i.a.c.c.a.a.a.eG(gVar);
                if (hqF3.SsZ != null && !TextUtils.isEmpty(eG2) && !hqF3.SsZ.containsKey(eG2)) {
                    hqF3.SsZ.put(eG2, bVar);
                }
                return gVar.a(hqF3.Stc);
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void hqj() {
        Set<com.tencent.h.b.b> set;
        com.tencent.h.c.h.i("sensor_AbsEngine", "[method: unMonitorView ] ");
        if (this.SqZ != null) {
            if (this.SqZ.Sqt != null) {
                com.tencent.h.c.h.i("sensor_AbsEngine", "[method: unMonitorView ] MonitorActivity");
                com.tencent.i.a.c.c.a.a.a hqF = com.tencent.i.a.c.c.a.a.a.hqF();
                Activity activity = this.SqZ.Sqt;
                if (activity != null) {
                    if (hqF.SsZ != null) {
                        hqF.SsZ.remove(activity.getClass().getName());
                    }
                    com.tencent.i.a.c.c.a.a.a.a(activity, hqF.Sta);
                }
            } else if (this.SqZ.Squ != null) {
                com.tencent.h.c.h.i("sensor_AbsEngine", "[method: unMonitorView ] MonitorView");
                com.tencent.i.a.c.c.a.a.a hqF2 = com.tencent.i.a.c.c.a.a.a.hqF();
                View view = this.SqZ.Squ;
                if (view != null) {
                    if (hqF2.SsZ != null) {
                        hqF2.SsZ.remove(com.tencent.i.a.c.c.a.a.a.eG(view));
                    }
                    com.tencent.h.b.a hpS = com.tencent.h.b.a.hpS();
                    com.tencent.h.b.b bVar = hqF2.Std;
                    if (!(view == null || bVar == null || hpS.SpR == null || hpS.SpR.isEmpty() || (set = hpS.SpR.get(Integer.valueOf(view.hashCode()))) == null || set.isEmpty())) {
                        Iterator<com.tencent.h.b.b> it = set.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                com.tencent.h.b.b next = it.next();
                                if (next == bVar) {
                                    set.remove(next);
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (set.isEmpty() && view != null) {
                            hpS.SpR.remove(Integer.valueOf(view.hashCode()));
                        }
                    }
                }
            } else if (this.SqZ.Sqv != null) {
                com.tencent.h.c.h.i("sensor_AbsEngine", "[method: unMonitorView ] MonitorTouchWrapper");
                com.tencent.i.a.c.c.a.a.a hqF3 = com.tencent.i.a.c.c.a.a.a.hqF();
                com.tencent.i.a.g gVar = this.SqZ.Sqv;
                if (!(gVar == null || hqF3.SsZ == null)) {
                    hqF3.SsZ.remove(com.tencent.i.a.c.c.a.a.a.eG(gVar));
                }
            }
            this.SqZ.Sqt = null;
            this.SqZ.Squ = null;
            this.SqZ.Sqv = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void hqk() {
        d dVar = this.Sra.Sre.wLb.get(10);
        if (dVar instanceof com.tencent.i.a.b.c.b) {
            b.AbstractC0143b bVar = null;
            if (this.SqZ.Sqr == com.tencent.i.a.c.GESTURETYPE_SINGLE) {
                bVar = new com.tencent.i.a.c.c.a.g(this.SqM, this);
            } else if (this.SqZ.Sqr == com.tencent.i.a.c.GESTURETYPE_MULTI) {
                bVar = new com.tencent.i.a.c.c.a.f(this.SqM, this);
            }
            if (bVar != null) {
                ((com.tencent.i.a.b.c.b) dVar).Srq = bVar;
            }
        }
    }

    /* renamed from: com.tencent.i.a.b.a$a  reason: collision with other inner class name */
    public class C0142a {
        public Object[] Srd;

        public C0142a(Object... objArr) {
            this.Srd = objArr;
        }
    }

    public boolean a(h.a aVar, c cVar) {
        if (!(cVar instanceof com.tencent.i.a.c.a)) {
            return false;
        }
        this.Srb = (com.tencent.i.a.c.a) cVar;
        return false;
    }
}
