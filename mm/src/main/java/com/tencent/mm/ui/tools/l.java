package com.tencent.mm.ui.tools;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;

public final class l implements AdapterView.OnItemClickListener {
    public o.f HLX;
    public o.g HLY;
    public o.b HMa;
    public o.c HMb;
    private m HMc;
    public e QuS;
    private e.b QuT;
    private m QuU;
    private Context mContext;
    private LayoutInflater mInflater;

    public l(Context context) {
        AppMethodBeat.i(143164);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.QuS = new e(context, 1, false);
        this.HMc = new m(context);
        this.QuU = new m(context);
        AppMethodBeat.o(143164);
    }

    public final void a(View view, final View.OnCreateContextMenuListener onCreateContextMenuListener, o.g gVar) {
        AppMethodBeat.i(143165);
        this.HLY = gVar;
        Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
        if (view instanceof AbsListView) {
            Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
            ((AbsListView) view).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.ui.tools.l.AnonymousClass1 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(143157);
                    l.this.QuU.clear();
                    Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
                    AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(view, i2, j2);
                    onCreateContextMenuListener.onCreateContextMenu(l.this.QuU, view, adapterContextMenuInfo);
                    Iterator<MenuItem> it = l.this.QuU.ORD.iterator();
                    while (it.hasNext()) {
                        ((n) it.next()).ORH = adapterContextMenuInfo;
                    }
                    l.this.HLX = new o.f() {
                        /* class com.tencent.mm.ui.tools.l.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(143156);
                            mVar.clear();
                            for (MenuItem menuItem : l.this.QuU.ORD) {
                                mVar.g(menuItem);
                            }
                            AppMethodBeat.o(143156);
                        }
                    };
                    l.this.QuS.wjN = true;
                    l.this.gXI();
                    AppMethodBeat.o(143157);
                    return true;
                }
            });
            AppMethodBeat.o(143165);
        } else if (view instanceof MMWebView) {
            Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.ui.tools.l.AnonymousClass2 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(143159);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/tools/MMListMenuHelper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
                    l.this.QuU.clear();
                    onCreateContextMenuListener.onCreateContextMenu(l.this.QuU, view, null);
                    l.this.HLX = new o.f() {
                        /* class com.tencent.mm.ui.tools.l.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(143158);
                            mVar.clear();
                            for (MenuItem menuItem : l.this.QuU.ORD) {
                                mVar.g(menuItem);
                            }
                            AppMethodBeat.o(143158);
                        }
                    };
                    l.this.QuS.wjN = true;
                    l.this.gXI();
                    if (l.this.QuU.size() > 0) {
                        a.a(true, (Object) this, "com/tencent/mm/ui/tools/MMListMenuHelper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(143159);
                        return true;
                    }
                    a.a(false, (Object) this, "com/tencent/mm/ui/tools/MMListMenuHelper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(143159);
                    return false;
                }
            });
            AppMethodBeat.o(143165);
        } else {
            Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.ui.tools.l.AnonymousClass3 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(143161);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/tools/MMListMenuHelper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
                    l.this.QuU.clear();
                    onCreateContextMenuListener.onCreateContextMenu(l.this.QuU, view, null);
                    l.this.HLX = new o.f() {
                        /* class com.tencent.mm.ui.tools.l.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(143160);
                            mVar.clear();
                            for (MenuItem menuItem : l.this.QuU.ORD) {
                                mVar.g(menuItem);
                            }
                            AppMethodBeat.o(143160);
                        }
                    };
                    l.this.QuS.wjN = true;
                    l.this.gXI();
                    a.a(true, (Object) this, "com/tencent/mm/ui/tools/MMListMenuHelper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(143161);
                    return true;
                }
            });
            AppMethodBeat.o(143165);
        }
    }

    public final void a(View view, int i2, long j2, View.OnCreateContextMenuListener onCreateContextMenuListener, o.g gVar) {
        AppMethodBeat.i(143166);
        if (!(this.mContext instanceof MMFragmentActivity) || !((MMFragmentActivity) this.mContext).isSwiping()) {
            this.HLY = gVar;
            this.QuU.clear();
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(view, i2, j2);
            onCreateContextMenuListener.onCreateContextMenu(this.QuU, view, adapterContextMenuInfo);
            Iterator<MenuItem> it = this.QuU.ORD.iterator();
            while (it.hasNext()) {
                ((n) it.next()).ORH = adapterContextMenuInfo;
            }
            this.HLX = new o.f() {
                /* class com.tencent.mm.ui.tools.l.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(143162);
                    mVar.clear();
                    for (MenuItem menuItem : l.this.QuU.ORD) {
                        mVar.g(menuItem);
                    }
                    AppMethodBeat.o(143162);
                }
            };
            this.QuS.wjN = true;
            gXI();
            AppMethodBeat.o(143166);
            return;
        }
        Log.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
        AppMethodBeat.o(143166);
    }

    public final void a(View view, View.OnCreateContextMenuListener onCreateContextMenuListener, o.g gVar, e.b bVar) {
        AppMethodBeat.i(143167);
        if (!(this.mContext instanceof MMFragmentActivity) || !((MMFragmentActivity) this.mContext).isSwiping()) {
            this.QuT = bVar;
            this.HLY = gVar;
            this.QuU.clear();
            onCreateContextMenuListener.onCreateContextMenu(this.QuU, view, null);
            this.HLX = new o.f() {
                /* class com.tencent.mm.ui.tools.l.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(143163);
                    mVar.clear();
                    for (MenuItem menuItem : l.this.QuU.ORD) {
                        mVar.g(menuItem);
                    }
                    AppMethodBeat.o(143163);
                }
            };
            this.QuS.wjN = true;
            gXI();
            AppMethodBeat.o(143167);
            return;
        }
        Log.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
        AppMethodBeat.o(143167);
    }

    @Deprecated
    public final void b(View view, View.OnCreateContextMenuListener onCreateContextMenuListener, o.g gVar) {
        AppMethodBeat.i(143168);
        a(view, onCreateContextMenuListener, gVar, null);
        AppMethodBeat.o(143168);
    }

    public final void a(o.f fVar) {
        this.HLX = fVar;
    }

    public final void a(o.g gVar) {
        this.HLY = gVar;
    }

    public final void a(e.b bVar) {
        this.QuT = bVar;
        this.QuS.PGl = bVar;
    }

    public final void a(e.a aVar) {
        this.QuS.QNO = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(143169);
        b bVar = new b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        a.b("com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        n nVar = (n) this.HMc.ORD.get(i2);
        if (nVar.performClick()) {
            Log.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
            dismiss();
            a.a(this, "com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(143169);
            return;
        }
        if (this.HLY != null) {
            this.HLY.onMMMenuItemSelected(nVar, i2);
        }
        dismiss();
        a.a(this, "com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(143169);
    }

    public final void dismiss() {
        AppMethodBeat.i(143170);
        if (this.QuS.isShowing()) {
            this.QuS.bMo();
        }
        AppMethodBeat.o(143170);
    }

    public final Dialog gXI() {
        AppMethodBeat.i(143171);
        if (this.HLX != null) {
            this.HMc.clear();
            this.HMc = new m(this.mContext);
            this.HLX.onCreateMMMenu(this.HMc);
        }
        if (this.HMc.gKQ()) {
            Log.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
            AppMethodBeat.o(143171);
        } else {
            this.QuS.HLX = this.HLX;
            this.QuS.HLY = this.HLY;
            this.QuS.PGl = this.QuT;
            this.QuS.HMb = this.HMb;
            this.QuS.dGm();
            AppMethodBeat.o(143171);
        }
        return null;
    }
}
