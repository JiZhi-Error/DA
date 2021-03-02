package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView extends LinearLayout implements View.OnClickListener {
    private static Map<String, Integer> xTn = new HashMap();
    private static int xTp = 6;
    private static int xTq = 7;
    private int count = 0;
    private Context mContext;
    private int xGR = 0;
    private LinkedList<g> xHv = new LinkedList<>();
    private k.a xQH = new k.a() {
        /* class com.tencent.mm.plugin.game.ui.GameInstalledView.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.game.model.k.a
        public final void e(int i2, String str, boolean z) {
            AppMethodBeat.i(42185);
            switch (i2) {
                case 1:
                case 2:
                    AppMethodBeat.o(42185);
                    return;
                case 3:
                    ((e) com.tencent.mm.kernel.g.af(e.class)).dSI().init(GameInstalledView.this.mContext);
                    GameInstalledView.this.refresh(false);
                    break;
            }
            AppMethodBeat.o(42185);
        }
    };
    private LinearLayout xTj;
    private ImageView xTk;
    private TextView xTl;
    private TextView xTm;
    private final DisplayMetrics xTo = new DisplayMetrics();
    private int xTr = 4;
    private int xTs = 1;
    private int xTt = 999;
    private a xTu;
    private LinkedList<c> xTv;
    LinearLayout.LayoutParams xTw = new LinearLayout.LayoutParams(-1, -2);

    public static class a {
        public String iconUrl = "";
        public String lDS = "";
        public String title = "";
    }

    static /* synthetic */ int b(GameInstalledView gameInstalledView) {
        int i2 = gameInstalledView.count + 1;
        gameInstalledView.count = i2;
        return i2;
    }

    static {
        AppMethodBeat.i(42192);
        AppMethodBeat.o(42192);
    }

    public GameInstalledView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42186);
        this.mContext = context;
        AppMethodBeat.o(42186);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42187);
        super.onFinishInflate();
        this.xTj = (LinearLayout) findViewById(R.id.dgd);
        k.a(this.xQH);
        AppMethodBeat.o(42187);
    }

    public final void refresh(boolean z) {
        AppMethodBeat.i(42188);
        if (Util.isNullOrNil(this.xTv)) {
            setVisibility(8);
            AppMethodBeat.o(42188);
            return;
        }
        setVisibility(0);
        if (z) {
            this.xHv = com.tencent.mm.plugin.game.model.e.dUQ();
            if (!Util.isNullOrNil(this.xTv) && !Util.isNullOrNil(this.xHv)) {
                Iterator<c> it = this.xTv.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (this.xHv.contains(next)) {
                        this.xHv.remove(next);
                        this.xHv.addFirst(next);
                    }
                }
            }
        } else {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.xHv);
            LinkedList linkedList2 = new LinkedList();
            linkedList2.addAll(com.tencent.mm.plugin.game.model.e.dUQ());
            LinkedList linkedList3 = new LinkedList();
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                g gVar = (g) it2.next();
                if (!linkedList2.contains(gVar) && !linkedList3.contains(gVar)) {
                    linkedList3.add(gVar);
                }
            }
            Iterator it3 = linkedList.iterator();
            while (it3.hasNext()) {
                g gVar2 = (g) it3.next();
                if (linkedList2.contains(gVar2)) {
                    linkedList2.remove(gVar2);
                } else if (!h.a(this.mContext, gVar2)) {
                    linkedList3.add(gVar2);
                }
            }
            if (linkedList2.size() > 0) {
                Iterator it4 = linkedList2.iterator();
                while (it4.hasNext()) {
                    g gVar3 = (g) it4.next();
                    if (!linkedList.contains(gVar3)) {
                        linkedList.addFirst(gVar3);
                    }
                }
            }
            if (linkedList3.size() > 0) {
                linkedList.removeAll(linkedList3);
            }
            LinkedList<g> linkedList4 = new LinkedList<>();
            Iterator it5 = linkedList.iterator();
            while (it5.hasNext()) {
                linkedList4.add(h.o(((g) it5.next()).field_appId, true, false));
            }
            this.xHv = linkedList4;
        }
        dWr();
        AppMethodBeat.o(42188);
    }

    private void dWr() {
        AppMethodBeat.i(42189);
        if (Util.isNullOrNil(this.xHv)) {
            setVisibility(8);
            AppMethodBeat.o(42189);
            return;
        }
        setVisibility(0);
        this.xTj.removeAllViews();
        this.count = 0;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (this.xHv.size() >= this.xTr - 1) {
            xTq = 7;
            xTp = 6;
            int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (float) ((xTp << 1) + 84));
            ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.xTo);
            int i2 = (int) (((float) (this.xTo.widthPixels * 160)) / ((float) this.xTo.densityDpi));
            this.xTr = ((this.xTo.widthPixels - 1) / fromDPToPix) + 1;
            if (this.xTr == 3) {
                xTq = 3;
            }
            int i3 = (xTp << 1) + 84;
            int i4 = xTp + 6 + xTq;
            int i5 = (i2 - 16) % i3;
            if (i5 < i4) {
                xTp -= 2;
                BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (float) ((xTp << 1) + 84));
            } else if (i5 > i3 - i4) {
                xTp = ((i5 - (i3 >> 1)) / this.xTr) + xTp;
                BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (float) ((xTp << 1) + 84));
            }
        }
        this.xTw.setMargins(BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (float) xTp), 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (float) xTp), 0);
        Iterator<g> it = this.xHv.iterator();
        while (it.hasNext()) {
            g next = it.next();
            View inflate = layoutInflater.inflate(R.layout.aw3, (ViewGroup) null);
            this.xTk = (ImageView) inflate.findViewById(R.id.dg3);
            this.xTl = (TextView) inflate.findViewById(R.id.dhv);
            this.xTm = (TextView) inflate.findViewById(R.id.din);
            Bitmap c2 = h.c(next.field_appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
            if (c2 != null) {
                this.xTk.setImageBitmap(c2);
            } else {
                this.xTk.setImageResource(R.drawable.ba4);
            }
            this.xTl.setText(h.a(this.mContext, next, (String) null));
            if (h.a(this.mContext, next)) {
                int aAH = com.tencent.mm.plugin.game.e.c.aAH(next.field_packageName);
                if (xTn.containsKey(next.field_appId) && xTn.get(next.field_appId).intValue() > aAH) {
                    FileDownloadTaskInfo alg = f.cBv().alg(next.field_appId);
                    this.xTm.setTextColor(this.mContext.getResources().getColor(R.color.t1));
                    if (alg.status == 1) {
                        this.xTm.setText(R.string.dnm);
                    } else {
                        this.xTm.setText(R.string.dnl);
                    }
                } else if (!Util.isNullOrNil(next.fmI)) {
                    this.xTm.setText(next.fmI);
                    this.xTm.setTextColor(this.mContext.getResources().getColor(R.color.th));
                } else {
                    this.xTm.setText("");
                }
            } else {
                this.xTm.setTextColor(this.mContext.getResources().getColor(R.color.t1));
                this.xTm.setText(R.string.dq4);
            }
            inflate.setTag(next);
            inflate.setOnClickListener(this);
            this.xTj.addView(inflate, this.xTw);
        }
        if (!(this.xTu == null || this.xTu.iconUrl == null || this.xTu.title == null)) {
            final View inflate2 = layoutInflater.inflate(R.layout.aw3, (ViewGroup) null);
            this.xTk = (ImageView) inflate2.findViewById(R.id.dg3);
            this.xTl = (TextView) inflate2.findViewById(R.id.dhv);
            this.xTm = (TextView) inflate2.findViewById(R.id.din);
            com.tencent.mm.av.a.a bcV = q.bcV();
            String str = this.xTu.iconUrl;
            ImageView imageView = this.xTk;
            c.a aVar = new c.a();
            aVar.jbe = true;
            bcV.a(str, imageView, aVar.bdv(), new com.tencent.mm.av.a.c.h() {
                /* class com.tencent.mm.plugin.game.ui.GameInstalledView.AnonymousClass1 */

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view) {
                }

                @Override // com.tencent.mm.av.a.c.h
                public final Bitmap a(String str, View view, b bVar) {
                    return null;
                }

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view, b bVar) {
                    AppMethodBeat.i(42184);
                    if (bVar.status == 0) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.game.ui.GameInstalledView.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(42183);
                                if (GameInstalledView.this.count == 0) {
                                    GameInstalledView.b(GameInstalledView.this);
                                    GameInstalledView.this.xTj.addView(inflate2, GameInstalledView.this.xTw);
                                }
                                AppMethodBeat.o(42183);
                            }
                        });
                    }
                    AppMethodBeat.o(42184);
                }
            });
            this.xTl.setText(this.xTu.title);
            this.xTm.setVisibility(8);
            inflate2.setTag(this.xTu);
            inflate2.setOnClickListener(this);
        }
        AppMethodBeat.o(42189);
    }

    public void setMoreGameInfo(a aVar) {
        this.xTu = aVar;
    }

    public void setInstalledGameInfo(LinkedList<com.tencent.mm.plugin.game.model.c> linkedList) {
        this.xTv = linkedList;
    }

    public void setSourceScene(int i2) {
        this.xGR = i2;
    }

    public void setVersionCodes(Map<String, Integer> map) {
        AppMethodBeat.i(42190);
        if (map == null || map.isEmpty()) {
            AppMethodBeat.o(42190);
            return;
        }
        xTn = map;
        AppMethodBeat.o(42190);
    }

    public void onClick(View view) {
        int D;
        AppMethodBeat.i(42191);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42191);
            return;
        }
        if (view.getTag() instanceof g) {
            g gVar = (g) view.getTag();
            if (gVar == null || Util.isNullOrNil(gVar.field_appId)) {
                Log.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(42191);
                return;
            } else if (h.a(this.mContext, gVar)) {
                int aAH = com.tencent.mm.plugin.game.e.c.aAH(gVar.field_packageName);
                if (!xTn.containsKey(gVar.field_appId) || xTn.get(gVar.field_appId).intValue() <= aAH) {
                    com.tencent.mm.plugin.game.model.e.at(this.mContext, gVar.field_appId);
                    com.tencent.mm.game.report.f.a(this.mContext, 10, 1002, this.xTs, 3, 0, gVar.field_appId, this.xGR, 0, null, null, null);
                    this.xHv.remove(gVar);
                    this.xHv.addFirst(gVar);
                } else {
                    FileDownloadTaskInfo alg = f.cBv().alg(gVar.field_appId);
                    if (alg.status == 1) {
                        f.cBv().Cn(alg.id);
                    } else {
                        if (alg.status == 3) {
                            if (!s.YS(alg.path) || com.tencent.mm.plugin.game.e.c.aAJ(alg.path) <= aAH) {
                                f.cBv().Cn(alg.id);
                            } else {
                                r.b(this.mContext, alg.path, null, false);
                            }
                        }
                        k.r(gVar.fmE, gVar.fmJ, gVar.field_appId, "");
                        g.a aVar = new g.a();
                        aVar.alj(gVar.fmE);
                        aVar.all(h.a(this.mContext, gVar, (String) null));
                        aVar.setAppId(gVar.field_appId);
                        aVar.setFileMD5(gVar.fmJ);
                        aVar.kS(true);
                        aVar.Fl(1);
                        f.cBv().a(aVar.qIY);
                    }
                }
                refresh(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(42191);
                return;
            } else {
                FileDownloadTaskInfo alg2 = f.cBv().alg(gVar.field_appId);
                if (alg2 == null || alg2.status != 3) {
                    Log.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", gVar.field_appName);
                    refresh(false);
                } else {
                    if (Util.isNullOrNil(alg2.path) || !s.YS(alg2.path)) {
                        Log.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", alg2.path);
                        f.cBv().Cn(alg2.id);
                        refresh(false);
                    } else {
                        r.b(this.mContext, alg2.path, null, false);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(42191);
                    return;
                }
            }
        } else if (view.getTag() instanceof a) {
            a aVar2 = (a) view.getTag();
            Intent intent = new Intent();
            if (Util.isNullOrNil(aVar2.lDS)) {
                intent.setClass(this.mContext, GameLibraryUI.class);
                intent.putExtra("game_report_from_scene", 1002);
                Context context = this.mContext;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                D = 6;
            } else {
                D = com.tencent.mm.plugin.game.e.c.D(this.mContext, aVar2.lDS, "game_center_installed_more");
            }
            com.tencent.mm.game.report.f.a(this.mContext, 10, 1002, this.xTt, D, 0, null, this.xGR, 0, null, null, null);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42191);
    }
}
