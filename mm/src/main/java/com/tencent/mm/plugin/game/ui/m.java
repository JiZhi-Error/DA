package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
public abstract class m extends a<c> {
    protected Context mContext;
    protected int xGR = 0;
    private a xPj;
    protected int xQD = 14;
    private k.a xQH = new k.a() {
        /* class com.tencent.mm.plugin.game.ui.m.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.game.model.k.a
        public final void e(int i2, String str, boolean z) {
            AppMethodBeat.i(42249);
            if (!z || m.this.xUa == null || str == null) {
                AppMethodBeat.o(42249);
                return;
            }
            try {
                for (l lVar : m.this.xUa.values()) {
                    if (!(lVar == null || lVar.xEP == null)) {
                        if (lVar.xEP.field_appId.equals(str) || lVar.xEP.field_packageName.equals(str)) {
                            lVar.gi(m.this.mContext);
                            lVar.cCq();
                        }
                    }
                }
                for (int i3 = 0; i3 < m.this.xHv.size(); i3++) {
                    c cVar = (c) m.this.xHv.get(i3);
                    if (cVar.type == 0 && ((cVar.field_appId.equals(str) || cVar.field_packageName.equals(str)) && m.this.xPj != null)) {
                        m.this.xPj.Os(i3);
                        AppMethodBeat.o(42249);
                        return;
                    }
                }
                AppMethodBeat.o(42249);
            } catch (Exception e2) {
                Log.e("MicroMsg.GameListAdapter", e2.getMessage());
                AppMethodBeat.o(42249);
            }
        }
    };
    protected d xQI;
    private DialogInterface.OnClickListener xRs = new DialogInterface.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.m.AnonymousClass5 */

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(42251);
            m.this.notifyDataSetChanged();
            AppMethodBeat.o(42251);
        }
    };
    protected View.OnClickListener xRt = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.m.AnonymousClass4 */

        public final void onClick(View view) {
            AppMethodBeat.i(42250);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(view.getTag() instanceof c)) {
                Log.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(42250);
                return;
            }
            c cVar = (c) view.getTag();
            if (!m.this.xUa.containsKey(cVar.field_appId)) {
                Log.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(42250);
                return;
            }
            l lVar = m.this.xUa.get(cVar.field_appId);
            lVar.gi(m.this.mContext);
            m.this.xQI.xOl = cVar.xEl;
            m.this.xQI.xGR = m.this.xGR;
            m.this.xQI.a(cVar, lVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameListAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42250);
        }
    };
    protected int xTV;
    protected boolean xTW = true;
    protected boolean xTX = false;
    protected boolean xTY = false;
    protected int xTZ;
    protected ConcurrentHashMap<String, l> xUa;
    protected SparseArray<View> xUb;

    public interface a {
        void Os(int i2);
    }

    /* access modifiers changed from: package-private */
    public abstract void a(c cVar, b bVar);

    /* access modifiers changed from: package-private */
    public abstract void a(c cVar, b bVar, int i2);

    public m(Context context) {
        super(context);
        this.mContext = context;
        this.xUa = new ConcurrentHashMap<>();
        k.a(this.xQH);
        this.xUb = new SparseArray<>();
        this.xQI = new d(context);
        this.xQI.xOA = this.xRs;
    }

    public void setSourceScene(int i2) {
        this.xGR = i2;
    }

    public void Ot(int i2) {
        this.xTZ = i2;
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    @Override // com.tencent.mm.plugin.game.ui.a
    public void aU(final LinkedList<c> linkedList) {
        if (linkedList != null) {
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.game.ui.m.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(42246);
                    m.a(m.this, linkedList);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.m.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(42245);
                            AnonymousClass1.super.aU(linkedList);
                            Log.i("MicroMsg.GameListAdapter", "add size: %d", Integer.valueOf(linkedList.size()));
                            AppMethodBeat.o(42245);
                        }
                    });
                    AppMethodBeat.o(42246);
                }
            });
        }
    }

    @Override // com.tencent.mm.plugin.game.ui.a
    public void aV(final LinkedList<c> linkedList) {
        if (linkedList != null) {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.game.ui.m.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(42248);
                    m.a(m.this, linkedList);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.m.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(42247);
                            AnonymousClass2.super.aV(linkedList);
                            Log.i("MicroMsg.GameListAdapter", "set size: %d", Integer.valueOf(linkedList.size()));
                            AppMethodBeat.o(42247);
                        }
                    });
                    AppMethodBeat.o(42248);
                }
            }, "game_get_download_info");
        }
    }

    /* access modifiers changed from: protected */
    public static class b {
        public ViewGroup xPa;
        public TextView xTl;
        public TextView xUg;
        public ImageView xUh;
        public TextView xUi;
        public TextView xUj;
        public TextView xUk;
        public Button xUl;
        public TextProgressBar xUm;
        public GameListSocialView xUn;
        public ViewGroup xUo;
        public LinearLayout xUp;

        protected b() {
        }
    }

    public int getItemViewType(int i2) {
        return ((c) getItem(i2)).type;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        int i3;
        c cVar = (c) getItem(i2);
        if (view == null) {
            Context context = this.mContext;
            switch (cVar.type) {
                case 0:
                    i3 = this.xTV;
                    break;
                case 1:
                    i3 = R.layout.aog;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            view = View.inflate(context, i3, null);
            b bVar2 = new b();
            bVar2.xPa = (ViewGroup) view.findViewById(R.id.f6s);
            bVar2.xUg = (TextView) view.findViewById(R.id.di_);
            bVar2.xUh = (ImageView) view.findViewById(R.id.dg3);
            bVar2.xTl = (TextView) view.findViewById(R.id.dhv);
            bVar2.xUi = (TextView) view.findViewById(R.id.fx6);
            bVar2.xUj = (TextView) view.findViewById(R.id.dg_);
            bVar2.xUk = (TextView) view.findViewById(R.id.ddn);
            bVar2.xUl = (Button) view.findViewById(R.id.dfb);
            bVar2.xUm = (TextProgressBar) view.findViewById(R.id.dfd);
            bVar2.xUp = (LinearLayout) view.findViewById(R.id.dcz);
            bVar2.xUn = (GameListSocialView) view.findViewById(R.id.dio);
            bVar2.xUo = (ViewGroup) view.findViewById(R.id.bk0);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (cVar.type) {
            case 0:
                a(cVar, bVar, i2);
                if (this.xTZ == 2 && !cVar.xEm) {
                    com.tencent.mm.plugin.game.d.a.b(this.mContext, 10, 1004, cVar.position, cVar.field_appId, this.xGR, cVar.xEl);
                    cVar.xEm = true;
                    break;
                }
            case 1:
                a(cVar, bVar);
                break;
        }
        return view;
    }

    public void f(SparseArray<View> sparseArray) {
        if (sparseArray != null) {
            this.xUb = sparseArray;
        } else {
            this.xUb = new SparseArray<>();
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.xPj = aVar;
    }

    public void aj(View view, int i2) {
        b bVar = (b) view.getTag();
        c cVar = (c) this.xHv.get(i2);
        if (bVar != null) {
            this.xQI.a(bVar.xUm, bVar.xUl, cVar, this.xUa.get(cVar.field_appId));
            return;
        }
        Log.e("MicroMsg.GameListAdapter", "holder should not be null, %d", Integer.valueOf(i2));
    }

    @Override // com.tencent.mm.plugin.game.ui.a
    public void clear() {
        super.clear();
        k.b(this.xQH);
    }

    public void aAB(String str) {
        l lVar;
        if (!Util.isNullOrNil(str) && this.xUa.containsKey(str) && (lVar = this.xUa.get(str)) != null) {
            lVar.cCq();
        }
    }

    public void aAA(String str) {
        l lVar;
        if (!Util.isNullOrNil(str) && this.xUa.containsKey(str) && (lVar = this.xUa.get(str)) != null) {
            lVar.dVj();
        }
    }

    public void aAC(String str) {
        c cVar;
        int i2 = 0;
        while (true) {
            if (i2 >= this.xHv.size()) {
                cVar = null;
                break;
            } else if (((c) this.xHv.get(i2)).field_appId.equals(str)) {
                cVar = (c) this.xHv.get(i2);
                break;
            } else {
                i2++;
            }
        }
        if (cVar != null) {
            if (!this.xUa.containsKey(cVar.field_appId)) {
                Log.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
                return;
            }
            this.xQI.a(cVar, this.xUa.get(cVar.field_appId));
        }
    }

    static /* synthetic */ void a(m mVar, LinkedList linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!(mVar.xUa.containsKey(cVar.field_appId) || cVar.type == 1 || cVar == null)) {
                l lVar = mVar.xUa.get(cVar.field_appId);
                if (lVar == null) {
                    lVar = new l(cVar);
                    mVar.xUa.put(cVar.field_appId, lVar);
                }
                lVar.gi(mVar.mContext);
                lVar.cCq();
            }
        }
    }
}
