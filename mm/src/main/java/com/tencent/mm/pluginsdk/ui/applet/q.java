package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class q {
    ContactListExpandPreference.a FjO;
    private String Kfj;
    private HashMap<String, Preference> Kfk = new HashMap<>();
    private boolean Kfl = false;
    private boolean Kfm;
    private boolean Kfn;
    public r Kfo;
    s.b Kfp;
    private View.OnClickListener Kfq;
    private View.OnClickListener Kfr;
    private View.OnClickListener Kfs;
    private s.b Kft;
    private s.a Kfu;
    private r.a Kfv;
    private Context context;
    private View kgo;
    public View.OnClickListener ko;
    private View psf;
    f screen;
    String username;

    public q(Context context2) {
        boolean z = false;
        AppMethodBeat.i(152183);
        this.Kfm = this.Kfl ? true : z;
        this.Kfp = null;
        this.ko = null;
        this.FjO = null;
        this.Kfs = new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.q.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(152179);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/pluginsdk/ui/applet/ContactListAnchor$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.ContactListArchor", "OnClickListener = onClick ");
                a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ContactListAnchor$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(152179);
            }
        };
        this.Kft = new s.b() {
            /* class com.tencent.mm.pluginsdk.ui.applet.q.AnonymousClass2 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.s.b
            public final boolean oi(int i2) {
                AppMethodBeat.i(152180);
                if (!q.this.Kfo.KfG || !q.this.Kfo.ain(i2)) {
                    AppMethodBeat.o(152180);
                } else {
                    if (!q.this.Kfo.ail(i2)) {
                        Log.d("MicroMsg.ContactListArchor", "onItemLongClick ".concat(String.valueOf(i2)));
                    }
                    AppMethodBeat.o(152180);
                }
                return true;
            }
        };
        this.Kfu = new s.a() {
            /* class com.tencent.mm.pluginsdk.ui.applet.q.AnonymousClass3 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.s.a
            public final void m(ViewGroup viewGroup, int i2) {
                boolean z;
                boolean z2;
                boolean z3 = true;
                AppMethodBeat.i(207172);
                if (!(q.this.FjO == null || q.this.Kfo == null)) {
                    r rVar = q.this.Kfo;
                    if (rVar.KfG) {
                        z = !rVar.gyp && i2 == rVar.KfE + 2;
                    } else {
                        z = !rVar.gyp && i2 == rVar.KfE + 1;
                    }
                    if (!z) {
                        r rVar2 = q.this.Kfo;
                        if (rVar2.gyp || i2 != rVar2.KfE) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            r rVar3 = q.this.Kfo;
                            if (rVar3.gyp || i2 != rVar3.KfE + 1) {
                                z3 = false;
                            }
                            if (z3) {
                                if (q.this.Kfo.KfG) {
                                    if (ab.Eq(q.this.username)) {
                                        q.this.FjO.og(i2);
                                        AppMethodBeat.o(207172);
                                        return;
                                    }
                                    q.this.Kfo.ail(0);
                                    AppMethodBeat.o(207172);
                                    return;
                                }
                            } else if (q.this.Kfo.gyp && q.this.Kfo.ain(i2)) {
                                q.this.FjO.og(i2);
                                AppMethodBeat.o(207172);
                                return;
                            } else if (q.this.Kfo.gyp && !q.this.Kfo.ain(i2)) {
                                q.this.FjO.amF();
                                AppMethodBeat.o(207172);
                                return;
                            } else if (!q.this.Kfo.gyp && q.this.Kfo.ain(i2)) {
                                q.this.FjO.e(viewGroup, i2);
                            }
                        } else if (q.this.Kfo.KfH) {
                            q.this.FjO.oh(i2);
                            AppMethodBeat.o(207172);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(207172);
            }
        };
        this.Kfv = new r.a() {
            /* class com.tencent.mm.pluginsdk.ui.applet.q.AnonymousClass4 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.r.a
            public final void cCu() {
                AppMethodBeat.i(152182);
                if (q.this.screen != null) {
                    q.this.screen.notifyDataSetChanged();
                }
                AppMethodBeat.o(152182);
            }
        };
        this.context = context2;
        this.Kfo = new r(this.context);
        this.Kfo.Kfy = this.Kfv;
        AppMethodBeat.o(152183);
    }

    public final void H(String str, List<String> list) {
        AppMethodBeat.i(152184);
        this.username = str;
        if (list == null) {
            list = new ArrayList<>(0);
        }
        this.Kfo.gX(list);
        aDj(str);
        AppMethodBeat.o(152184);
    }

    public final void bg(ArrayList<as> arrayList) {
        AppMethodBeat.i(152185);
        if (arrayList == null) {
            arrayList = new ArrayList<>(0);
        }
        this.Kfo.bh(arrayList);
        aDj(null);
        AppMethodBeat.o(152185);
    }

    private void aDj(String str) {
        AppMethodBeat.i(152186);
        this.Kfo.setUsername(str);
        this.Kfo.KfK = this.Kfm;
        this.Kfo.amZ();
        cax();
        AppMethodBeat.o(152186);
    }

    public final void a(f fVar, String str) {
        AppMethodBeat.i(152187);
        if (fVar == null || str == null) {
            AppMethodBeat.o(152187);
            return;
        }
        this.screen = fVar;
        this.Kfj = str;
        fVar.m38do(str, true);
        AppMethodBeat.o(152187);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r2 != false) goto L_0x0020;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aij(int r15) {
        /*
        // Method dump skipped, instructions count: 431
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.applet.q.aij(int):void");
    }

    private void removeAll() {
        AppMethodBeat.i(152189);
        for (String str : this.Kfk.keySet()) {
            this.screen.bmi(str);
        }
        this.Kfk.clear();
        AppMethodBeat.o(152189);
    }

    private static String aik(int i2) {
        AppMethodBeat.i(152190);
        if (i2 >= 0) {
            String concat = "pref_contact_list_row_".concat(String.valueOf(i2));
            AppMethodBeat.o(152190);
            return concat;
        }
        String str = "unkown";
        if (i2 == -1) {
            str = TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER;
        } else if (i2 == -2) {
            str = "footer";
        }
        String concat2 = "pref_contact_list_row_".concat(String.valueOf(str));
        AppMethodBeat.o(152190);
        return concat2;
    }

    public final void cax() {
        AppMethodBeat.i(152191);
        if (this.screen == null || this.Kfj == null) {
            AppMethodBeat.o(152191);
            return;
        }
        removeAll();
        aij(this.screen.indexOf(this.Kfj));
        zT(this.Kfn);
        AppMethodBeat.o(152191);
    }

    public final void gpA() {
        boolean z = false;
        this.Kfl = false;
        if (this.Kfl) {
            z = true;
        }
        this.Kfm = z;
    }

    public final void zT(boolean z) {
        AppMethodBeat.i(207173);
        this.Kfn = z;
        for (Preference preference : this.Kfk.values()) {
            if (preference instanceof ContactListExpandPreference) {
                ((ContactListExpandPreference) preference).zT(z);
            }
        }
        AppMethodBeat.o(207173);
    }
}
