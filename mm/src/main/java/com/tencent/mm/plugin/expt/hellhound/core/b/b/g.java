package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.d;
import com.tencent.mm.plugin.expt.hellhound.core.e;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public final class g implements d, e {
    private final f sAj = new f(this);
    private d.b sAk;
    private final a sAl = new a() {
        /* class com.tencent.mm.plugin.expt.hellhound.core.b.b.g.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a
        public final void X(int i2, long j2) {
            AppMethodBeat.i(184317);
            Log.i("HABBYGE-MALI.FragmentMonitor", "mHijackCallback, event: %d", Integer.valueOf(i2));
            if (g.this.szI) {
                c.cNJ().m(b.GU(i2), Long.valueOf(j2));
                AppMethodBeat.o(184317);
                return;
            }
            g.this.W(i2, j2);
            AppMethodBeat.o(184317);
        }
    };
    final boolean szI = com.tencent.mm.plugin.expt.hellhound.a.cNt();

    public g() {
        AppMethodBeat.i(121997);
        AppMethodBeat.o(121997);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.e
    public final void b(d.b bVar) {
        AppMethodBeat.i(220436);
        this.sAk = bVar;
        k.a(this);
        AppMethodBeat.o(220436);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.e
    public final void a(Activity activity, long j2) {
        FragmentActivity fragmentActivity;
        int i2;
        com.tencent.mm.plugin.expt.hellhound.core.d dVar;
        Class<?> cls;
        String str = null;
        AppMethodBeat.i(184318);
        if (!com.tencent.mm.plugin.expt.hellhound.a.cNo()) {
            AppMethodBeat.o(184318);
            return;
        }
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity2 = (FragmentActivity) activity;
            e eVar = this.sAj.sAi;
            if (eVar.sAa != null) {
                a.C1025a aVar = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.szr;
                if (a.C1025a.b(fragmentActivity2, eVar.sAa)) {
                    if (!(fragmentActivity2 instanceof MMFragmentActivity)) {
                        fragmentActivity = null;
                    } else {
                        fragmentActivity = fragmentActivity2;
                    }
                    MMFragmentActivity mMFragmentActivity = (MMFragmentActivity) fragmentActivity;
                    Fragment aa = h.aa(mMFragmentActivity);
                    if (aa != null) {
                        Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume: " + aa.getClass().getName());
                        if (eVar.szZ != null) {
                            if (!(mMFragmentActivity == null || (cls = mMFragmentActivity.getClass()) == null)) {
                                str = cls.getCanonicalName();
                            }
                            String canonicalName = aa.getClass().getCanonicalName();
                            int hashCode = aa.hashCode();
                            Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFActivityWhenResume, %s, %s", str, canonicalName);
                            if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoy(str) && (dVar = eVar.szZ) != null) {
                                dVar.a(mMFragmentActivity, aa, canonicalName, hashCode, j2, true);
                            }
                        }
                    } else {
                        Log.w("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume curFragment == null");
                        Fragment c2 = h.c(mMFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.syW);
                        if (c2 != null) {
                            i2 = c2.hashCode();
                        } else {
                            i2 = 0;
                        }
                        com.tencent.mm.plugin.expt.hellhound.core.d dVar2 = eVar.szZ;
                        if (dVar2 != null) {
                            dVar2.a(mMFragmentActivity, null, com.tencent.mm.plugin.expt.hellhound.core.b.syW, i2, j2, true);
                        }
                    }
                    if (mMFragmentActivity != null) {
                        eVar.mActivityRef = new WeakReference<>(mMFragmentActivity);
                        com.tencent.mm.hellhoundlib.a.axP();
                        com.tencent.mm.hellhoundlib.a.e(eVar.sAe, eVar.sAd);
                    }
                    b bVar = eVar.sAb;
                    if (bVar != null) {
                        a.szV.a(bVar.szX);
                        AppMethodBeat.o(184318);
                        return;
                    }
                }
            }
            AppMethodBeat.o(184318);
            return;
        }
        AppMethodBeat.o(184318);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.e
    public final void b(Activity activity, long j2) {
        AppMethodBeat.i(184319);
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            e eVar = this.sAj.sAi;
            a.C1025a aVar = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.szr;
            if (a.C1025a.b(fragmentActivity, eVar.sAa)) {
                com.tencent.mm.hellhoundlib.a.axP();
                com.tencent.mm.hellhoundlib.a.f(eVar.sAe, eVar.sAd);
                if (fragmentActivity != null) {
                    try {
                        if (com.tencent.mm.plugin.expt.hellhound.core.b.aoy(fragmentActivity.getClass().getCanonicalName())) {
                            AppMethodBeat.o(184319);
                            return;
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.FragmentLauncherUIMonitor", e2, "fragmentGoneCallback", new Object[0]);
                    }
                    Fragment aa = h.aa(fragmentActivity);
                    if (aa != null) {
                        String canonicalName = aa.getClass().getCanonicalName();
                        Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragmentPauseCallback: curFragment = ".concat(String.valueOf(canonicalName)));
                        com.tencent.mm.plugin.expt.hellhound.core.d dVar = eVar.szZ;
                        if (dVar != null) {
                            dVar.a(fragmentActivity, canonicalName, aa.hashCode(), j2, true);
                            AppMethodBeat.o(184319);
                            return;
                        }
                        AppMethodBeat.o(184319);
                        return;
                    }
                    Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragmentGoneCallback unmonitor: curFragment = null");
                }
            }
        }
        AppMethodBeat.o(184319);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.d
    public final void a(FragmentActivity fragmentActivity, Fragment fragment, String str, int i2, long j2, boolean z) {
        Bundle arguments;
        AppMethodBeat.i(220437);
        if (fragment != null) {
            com.tencent.mm.plugin.expt.hellhound.core.a.cNx().df(fragment);
        }
        if (!z) {
            a(fragmentActivity, fragment, str, i2, j2);
            AppMethodBeat.o(220437);
        } else if (this.szI) {
            bfk bfk = new bfk();
            if (!(fragment == null || (arguments = fragment.getArguments()) == null)) {
                bfk.LPa = arguments.getString("Chat_User");
            }
            bfk.LOY = str;
            bfk.LOZ = i2;
            bfk.LPb = true;
            bfk.timestamp = j2;
            bfk.LOX = new eih();
            if (fragmentActivity != null) {
                bfk.LOX.activityName = fragmentActivity.getClass().getCanonicalName();
                bfk.LOX.aHK = fragmentActivity.hashCode();
                bfk.LOX.timestamp = j2;
            }
            if (fragmentActivity != null) {
                bfk.LPc = a(fragmentActivity, str);
                if (com.tencent.mm.plugin.expt.hellhound.core.b.syZ.equals(str)) {
                    b.cOl().a(fragmentActivity, this.sAl);
                }
            }
            c.cNJ().m(5, bfk);
            AppMethodBeat.o(220437);
        } else {
            a(fragmentActivity, fragment, str, i2, j2);
            AppMethodBeat.o(220437);
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.e
    public final void a(bfk bfk) {
        AppMethodBeat.i(184321);
        String str = bfk.LPa;
        if (!TextUtils.isEmpty(str)) {
            c.go("Chat_User", str);
        }
        eih eih = bfk.LOX;
        String str2 = bfk.LOY;
        int i2 = bfk.LOZ;
        boolean z = bfk.LPc;
        long j2 = bfk.timestamp;
        if (eih == null) {
            if (this.sAk != null) {
                this.sAk.b("Biz", str2, i2, j2);
            }
            AppMethodBeat.o(184321);
            return;
        }
        if (!TextUtils.isEmpty(eih.activityName)) {
            Log.i("HABBYGE-MALI.FragmentMonitor", "_onResume: %s, %s", eih.activityName, str2);
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.L(eih.activityName, str2, i2);
            if (com.tencent.mm.plugin.expt.hellhound.core.b.syZ.equals(str2)) {
                Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, onResume-1");
                int i3 = b.cOl().mRl;
                if (i3 == 1 || i3 == -1) {
                    Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onResume-2");
                } else if (i3 == 0) {
                    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onResume: %b", Boolean.valueOf(z));
                    if (z && this.sAk != null) {
                        this.sAk.R(2, j2);
                    }
                    AppMethodBeat.o(184321);
                    return;
                }
            }
            if (this.sAk != null) {
                this.sAk.b(eih.activityName, str2, i2, j2);
            }
        }
        AppMethodBeat.o(184321);
    }

    private void a(FragmentActivity fragmentActivity, Fragment fragment, String str, int i2, long j2) {
        AppMethodBeat.i(220438);
        if (fragment != null) {
            c.ah(fragment.getArguments());
        }
        b(fragmentActivity, fragment, str, i2, j2);
        AppMethodBeat.o(220438);
    }

    private void b(FragmentActivity fragmentActivity, Fragment fragment, String str, int i2, long j2) {
        AppMethodBeat.i(220439);
        if (fragmentActivity == null && fragment == null && str == null) {
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
            bn cNR = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
            if (cNR != null) {
                Log.i("HABBYGE-MALI.FragmentMonitor", "onFragmentResume -> _onResumeForBiz --2");
                if (this.sAk != null) {
                    this.sAk.b("Biz", cNR.KFh.activityName, i2, j2);
                }
            }
            AppMethodBeat.o(220439);
        } else if (fragmentActivity == null) {
            AppMethodBeat.o(220439);
        } else {
            String canonicalName = fragmentActivity.getClass().getCanonicalName();
            Log.i("HABBYGE-MALI.FragmentMonitor", "_onFragmentResume: %s, %s", canonicalName, str);
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.L(canonicalName, str, i2);
            if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.syZ)) {
                Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, onResume-1");
                b cOl = b.cOl();
                cOl.a(fragmentActivity, this.sAl);
                int i3 = cOl.mRl;
                if (i3 == 1 || i3 == -1) {
                    Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onResume-2");
                } else if (i3 == 0) {
                    boolean a2 = a(fragmentActivity, str);
                    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onResume: %b", Boolean.valueOf(a2));
                    if (a2 && this.sAk != null) {
                        this.sAk.R(2, j2);
                    }
                    AppMethodBeat.o(220439);
                    return;
                }
            }
            if (this.sAk != null) {
                this.sAk.b(canonicalName, str, i2, j2);
            }
            AppMethodBeat.o(220439);
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.e
    public final void a(bfj bfj) {
        AppMethodBeat.i(184324);
        eih eih = bfj.LOX;
        String str = bfj.LOY;
        int i2 = bfj.LOZ;
        long j2 = bfj.timestamp;
        if (eih == null || TextUtils.isEmpty(eih.activityName)) {
            Log.i("HABBYGE-MALI.FragmentMonitor", "_onFragmentPause, Biz");
            if (this.sAk != null) {
                this.sAk.c("Biz", str, i2, j2);
            }
            AppMethodBeat.o(184324);
            return;
        }
        Log.i("HABBYGE-MALI.FragmentMonitor", "_onPause: %s, %s", eih.activityName, str);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.M(eih.activityName, str, i2);
        if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.syZ)) {
            Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-1");
            b cOl = b.cOl();
            int i3 = cOl.mRl;
            if (i3 == 1 || i3 == -1) {
                Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
            } else if (i3 == 0) {
                Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onPause");
                cOl.mRl = -1;
                if (this.sAk != null) {
                    this.sAk.S(3, j2);
                }
                AppMethodBeat.o(184324);
                return;
            }
        }
        if (this.sAk != null) {
            this.sAk.c(eih.activityName, str, i2, j2);
        }
        AppMethodBeat.o(184324);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.d
    public final void a(FragmentActivity fragmentActivity, String str, int i2, long j2, boolean z) {
        AppMethodBeat.i(220440);
        if (!z) {
            a(fragmentActivity, str, i2, j2);
            AppMethodBeat.o(220440);
        } else if (this.szI) {
            bfj bfj = new bfj();
            bfj.LOX = new eih();
            if (fragmentActivity != null) {
                bfj.LOX.activityName = fragmentActivity.getClass().getCanonicalName();
                bfj.LOX.aHK = fragmentActivity.hashCode();
                bfj.LOX.timestamp = j2;
            }
            bfj.LOY = str;
            bfj.LOZ = i2;
            bfj.timestamp = j2;
            if (fragmentActivity != null && com.tencent.mm.plugin.expt.hellhound.core.b.syZ.equals(str)) {
                Log.i("HABBYGE-MALI.FragmentMonitor", "stopStoryMonitor: %s", str);
                b.cOl().e(fragmentActivity);
            }
            c.cNJ().m(6, bfj);
            AppMethodBeat.o(220440);
        } else {
            a(fragmentActivity, str, i2, j2);
            AppMethodBeat.o(220440);
        }
    }

    private void a(FragmentActivity fragmentActivity, String str, int i2, long j2) {
        AppMethodBeat.i(220441);
        if (fragmentActivity == null && str == null) {
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
            bn cNR = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
            if (cNR != null) {
                l(cNR.KFh.activityName, i2, j2);
            }
            AppMethodBeat.o(220441);
        } else if (fragmentActivity == null) {
            AppMethodBeat.o(220441);
        } else {
            String canonicalName = fragmentActivity.getClass().getCanonicalName();
            Log.i("HABBYGE-MALI.FragmentMonitor", "_onPause: %s, %s", canonicalName, str);
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.M(canonicalName, str, i2);
            if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.syZ)) {
                Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
                b cOl = b.cOl();
                cOl.e(fragmentActivity);
                int i3 = cOl.mRl;
                if (i3 == 1 || i3 == -1) {
                    Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
                } else if (i3 == 0) {
                    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onPause");
                    cOl.mRl = -1;
                    if (this.sAk != null) {
                        this.sAk.S(3, j2);
                    }
                    AppMethodBeat.o(220441);
                    return;
                }
            }
            if (this.sAk != null) {
                this.sAk.c(canonicalName, str, i2, j2);
            }
            AppMethodBeat.o(220441);
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.e
    public final void T(int i2, long j2) {
        AppMethodBeat.i(184327);
        b bVar = this.sAj.sAi.sAb;
        if (bVar != null) {
            bVar.V(i2, j2);
            AppMethodBeat.o(184327);
            return;
        }
        AppMethodBeat.o(184327);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.d
    public final void a(FragmentActivity fragmentActivity, long j2) {
        int hashCode;
        AppMethodBeat.i(220442);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        Fragment c2 = h.c(fragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.sza);
        String str = com.tencent.mm.plugin.expt.hellhound.core.b.sza;
        if (c2 == null) {
            hashCode = 0;
        } else {
            hashCode = c2.hashCode();
        }
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.M("com.tencent.mm.ui.LauncherUI", str, hashCode);
        Log.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor onChattingUIFragmentFinish");
        if (this.sAk != null) {
            this.sAk.Dm(j2);
        }
        AppMethodBeat.o(220442);
    }

    private void l(String str, int i2, long j2) {
        AppMethodBeat.i(220443);
        if (this.sAk != null) {
            this.sAk.c("Biz", str, i2, j2);
        }
        AppMethodBeat.o(220443);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.core.e
    public final void U(int i2, long j2) {
        AppMethodBeat.i(184330);
        W(b.GV(i2), j2);
        AppMethodBeat.o(184330);
    }

    /* access modifiers changed from: package-private */
    public final void W(int i2, long j2) {
        AppMethodBeat.i(184331);
        Log.i("HABBYGE-MALI.FragmentMonitor", "_onStoryCallback: %d", Integer.valueOf(i2));
        if (i2 == 0) {
            if (this.sAk != null) {
                this.sAk.R(0, j2);
                AppMethodBeat.o(184331);
                return;
            }
        } else if (i2 == 1 && this.sAk != null) {
            this.sAk.S(1, j2);
        }
        AppMethodBeat.o(184331);
    }

    private static boolean a(FragmentActivity fragmentActivity, String str) {
        boolean z;
        AppMethodBeat.i(122012);
        try {
            Fragment c2 = h.c(fragmentActivity, str);
            Field declaredField = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.syZ).getDeclaredField("storyGallery");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(c2);
            Field declaredField2 = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("mIsActive");
            declaredField2.setAccessible(true);
            z = ((Boolean) declaredField2.get(obj)).booleanValue();
        } catch (Exception e2) {
            z = false;
        }
        Log.d("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryActive: %b", Boolean.valueOf(z));
        AppMethodBeat.o(122012);
        return z;
    }

    public static boolean b(FragmentActivity fragmentActivity, String str) {
        View view;
        boolean z;
        AppMethodBeat.i(122013);
        try {
            Fragment c2 = h.c(fragmentActivity, str);
            Field declaredField = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.syZ).getDeclaredField("storyGallery");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(c2);
            Field declaredField2 = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("holderView");
            declaredField2.setAccessible(true);
            view = (View) declaredField2.get(obj);
        } catch (Exception e2) {
            view = null;
        }
        if (view == null) {
            Log.i("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryShow = NULL");
            AppMethodBeat.o(122013);
            return false;
        }
        if (view.getVisibility() != 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryShow: %b", Boolean.valueOf(z));
        AppMethodBeat.o(122013);
        return z;
    }
}
