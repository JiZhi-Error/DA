package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.gridviewheaders.e;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b extends BaseAdapter implements e {
    private static int qql = 0;
    private boolean bqX;
    boolean isStop = false;
    ArrayList<com.tencent.mm.plugin.clean.c.c> kgc;
    HashSet<Integer> oMG;
    AdapterView.OnItemClickListener ppw = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.plugin.clean.ui.fileindexui.b.AnonymousClass4 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            String str;
            AppMethodBeat.i(22859);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            Log.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d, count=%d", Integer.valueOf(i2), Integer.valueOf(b.this.getCount()));
            if (i2 < 0 || i2 >= b.this.getCount()) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(22859);
                return;
            }
            com.tencent.mm.plugin.clean.c.c EP = b.this.EP(i2);
            Intent intent = new Intent();
            switch (EP.type) {
                case 1:
                    intent.putExtra("key_title", b.this.qqk.getString(R.string.b4u));
                    intent.putExtra("show_menu", false);
                    if (s.YS(EP.filePath)) {
                        str = EP.filePath;
                    } else {
                        str = EP.thumbPath;
                    }
                    intent.putExtra("key_image_path", str);
                    com.tencent.mm.br.c.f(b.this.qqk, ".ui.tools.ShowImageUI", intent);
                    break;
                case 3:
                    intent.setAction("android.intent.action.VIEW");
                    FileProviderHelper.setIntentDataAndType((Context) b.this.qqk, intent, new o(EP.filePath), "video/*", false);
                    try {
                        CleanChattingDetailUI cleanChattingDetailUI = b.this.qqk;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(Intent.createChooser(intent, b.this.qqk.getString(R.string.hxu)));
                        com.tencent.mm.hellhoundlib.a.a.a(cleanChattingDetailUI, bl.axQ(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        cleanChattingDetailUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(cleanChattingDetailUI, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                    } catch (Exception e2) {
                        break;
                    }
                case 4:
                    intent.putExtra("app_msg_id", EP.dFm);
                    com.tencent.mm.br.c.f(b.this.qqk, ".ui.chatting.AppAttachDownloadUI", intent);
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(22859);
        }
    };
    private CleanChattingDetailUI qqk;
    GridHeadersGridView.c qqm = new GridHeadersGridView.c() {
        /* class com.tencent.mm.plugin.clean.ui.fileindexui.b.AnonymousClass3 */

        @Override // com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c
        public final void dE(View view) {
            AppMethodBeat.i(22858);
            b.a(b.this, (a) view.getTag());
            b.this.notifyDataSetChanged();
            AppMethodBeat.o(22858);
        }
    };
    private MMHandler qqn = new MMHandler() {
        /* class com.tencent.mm.plugin.clean.ui.fileindexui.b.AnonymousClass5 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(22860);
            if (!b.this.bqX) {
                b.this.notifyDataSetChanged();
            }
            AppMethodBeat.o(22860);
        }
    };
    AbsListView.OnScrollListener qqo = new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.plugin.clean.ui.fileindexui.b.AnonymousClass6 */

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(22861);
            q.bcV().onScrollStateChanged(i2);
            if (i2 != 2) {
                b.this.bqX = false;
                b.this.qqn.removeCallbacksAndMessages(null);
                b.this.qqn.sendEmptyMessageDelayed(0, 200);
                AppMethodBeat.o(22861);
                return;
            }
            b.this.bqX = true;
            AppMethodBeat.o(22861);
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }
    };
    private String username;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(22872);
        com.tencent.mm.plugin.clean.c.c EP = EP(i2);
        AppMethodBeat.o(22872);
        return EP;
    }

    public b(CleanChattingDetailUI cleanChattingDetailUI, String str) {
        AppMethodBeat.i(22864);
        this.qqk = cleanChattingDetailUI;
        this.oMG = new HashSet<>();
        this.kgc = new ArrayList<>();
        this.username = str;
        AppMethodBeat.o(22864);
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.b$b  reason: collision with other inner class name */
    class RunnableC0926b implements Runnable {
        private RunnableC0926b() {
        }

        /* synthetic */ RunnableC0926b(b bVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(22862);
            PLong pLong = new PLong();
            PLong pLong2 = new PLong();
            com.tencent.mm.plugin.f.b.b crX = com.tencent.mm.plugin.f.b.crW().crX();
            String str = b.this.username;
            long currentTicks = Util.currentTicks();
            String str2 = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + str + "' and msgType in (43,62,44,3,49,486539313,268435505 )";
            Cursor cursor = null;
            try {
                Cursor rawQuery = crX.db.rawQuery(str2, null);
                if (rawQuery != null && rawQuery.moveToFirst()) {
                    pLong.value = rawQuery.getLong(0);
                    pLong2.value = rawQuery.getLong(1);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WxFileIndexStorage", e2, " sql [%s]", str2);
                if (0 != 0) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                AppMethodBeat.o(22862);
                throw th;
            }
            Log.i("MicroMsg.WxFileIndexStorage", "getMediaMsgTimeByUsername [%s] cost[%d]", str, Long.valueOf(Util.ticksToNow(currentTicks)));
            pLong2.value--;
            long j2 = pLong.value;
            long max = Math.max(j2 - 604800000, pLong2.value);
            try {
                if (b.this.isStop) {
                    AppMethodBeat.o(22862);
                    return;
                }
                if (max == j2) {
                    max--;
                }
                db(com.tencent.mm.plugin.f.b.crW().crX().v(b.this.username, j2, max));
                b.c(b.this);
                while (!b.this.isStop && max > pLong2.value) {
                    max = Math.max(max - 15552000000L, pLong2.value);
                    if (max == max) {
                        max--;
                    }
                    db(com.tencent.mm.plugin.f.b.crW().crX().v(b.this.username, max, max));
                    b.c(b.this);
                }
                AppMethodBeat.o(22862);
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.CleanChattingDetailAdapter", e3, "", new Object[0]);
                AppMethodBeat.o(22862);
            }
        }

        private void db(List<com.tencent.mm.plugin.f.b.a> list) {
            AppMethodBeat.i(22863);
            int size = list.size();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                com.tencent.mm.plugin.f.b.a aVar = list.get(i2);
                com.tencent.mm.plugin.clean.c.c cVar = (com.tencent.mm.plugin.clean.c.c) hashMap.get(Long.valueOf(aVar.field_msgId));
                if (cVar == null) {
                    cVar = new com.tencent.mm.plugin.clean.c.c();
                    hashMap.put(Long.valueOf(aVar.field_msgId), cVar);
                    arrayList.add(cVar);
                }
                cVar.qpJ.add(aVar);
                cVar.jsm = aVar.field_msgtime;
                cVar.userName = aVar.field_username;
                cVar.dFm = aVar.field_msgId;
                if (!com.tencent.mm.plugin.f.a.Ea(aVar.field_msgSubType)) {
                    cVar.size += aVar.field_size;
                }
                cVar.msgType = aVar.field_msgType;
                switch (aVar.field_msgSubType) {
                    case 1:
                        cVar.filePath = g.aAh().hqF + aVar.field_path;
                        cVar.type = 3;
                        break;
                    case 2:
                        if (aVar.field_msgType == 486539313) {
                            cVar.thumbPath = aVar.field_path;
                        } else {
                            cVar.thumbPath = g.aAh().hqF + aVar.field_path;
                        }
                        cVar.type = 3;
                        break;
                    case 20:
                        cVar.filePath = g.aAh().hqF + aVar.field_path;
                        cVar.type = 1;
                        break;
                    case 21:
                        cVar.thumbPath = g.aAh().hqF + aVar.field_path;
                        cVar.type = 1;
                        break;
                    case 30:
                        cVar.filePath = g.aAh().hqF + aVar.field_path;
                        cVar.type = 1;
                        break;
                    case 31:
                        cVar.thumbPath = g.aAh().hqF + aVar.field_path;
                        cVar.type = 1;
                        break;
                    case 32:
                        cVar.filePath = g.aAh().hqF + aVar.field_path;
                        cVar.type = 4;
                        break;
                    case 33:
                        cVar.thumbPath = g.aAh().hqF + aVar.field_path;
                        cVar.type = 4;
                        break;
                    case 34:
                        cVar.filePath = g.aAh().hqF + aVar.field_path;
                        cVar.type = 4;
                        break;
                    case 35:
                        cVar.thumbPath = g.aAh().hqF + aVar.field_path;
                        cVar.type = 4;
                        break;
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((com.tencent.mm.plugin.clean.c.c) it.next()).size <= 0) {
                    it.remove();
                }
            }
            b.this.kgc.addAll(arrayList);
            AppMethodBeat.o(22863);
        }
    }

    public final int getCount() {
        AppMethodBeat.i(22865);
        int size = this.kgc.size();
        AppMethodBeat.o(22865);
        return size;
    }

    public final com.tencent.mm.plugin.clean.c.c EP(int i2) {
        AppMethodBeat.i(22866);
        com.tencent.mm.plugin.clean.c.c cVar = this.kgc.get(i2);
        AppMethodBeat.o(22866);
        return cVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(final int i2, View view, ViewGroup viewGroup) {
        c cVar;
        AppMethodBeat.i(22867);
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.qqk.getLayoutInflater().inflate(R.layout.um, viewGroup, false);
            c cVar2 = new c();
            cVar2.qqt = (MMImageView) view.findViewById(R.id.bew);
            cVar2.jVQ = (CheckBox) view.findViewById(R.id.hhc);
            cVar2.qqv = view.findViewById(R.id.hhe);
            cVar2.qqw = view.findViewById(R.id.hiy);
            cVar2.qqu = (ImageView) view.findViewById(R.id.gch);
            cVar2.kgE = (TextView) view.findViewById(R.id.fti);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        com.tencent.mm.plugin.clean.c.c EP = EP(i2);
        cVar.qqt.setTag(EP.filePath);
        cVar.qqv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.b.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(22857);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.a(b.this, i2);
                b.this.notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22857);
            }
        });
        if (this.oMG.contains(Integer.valueOf(i2))) {
            cVar.jVQ.setChecked(true);
            cVar.qqw.setVisibility(0);
        } else {
            cVar.jVQ.setChecked(false);
            cVar.qqw.setVisibility(8);
        }
        if (EP.type == 3) {
            cVar.qqu.setVisibility(0);
        } else {
            cVar.qqu.setVisibility(8);
        }
        if (EP.type == 4) {
            q.bcV().a(EP.thumbPath, cVar.qqt);
            cVar.qqt.setImageResource(r.bdt(s.akC(EP.filePath)));
            cVar.kgE.setText(new o(EP.filePath).getName());
            cVar.kgE.setVisibility(0);
        } else {
            if (qql == 0) {
                qql = view.getMeasuredWidth();
            }
            c.a aVar = new c.a();
            aVar.jbi = 1;
            aVar.jbg = false;
            aVar.hZA = qql;
            aVar.hZz = qql;
            if (EP.type == 1 || EP.msgType != 486539313) {
                aVar.fullPath = EP.thumbPath;
                q.bcV().a(EP.thumbPath, cVar.qqt, aVar.bdv());
            } else {
                aVar.fullPath = com.tencent.mm.pluginsdk.model.s.bdu(EP.thumbPath);
                aVar.jbi = 5;
                q.bcV().a(EP.thumbPath, cVar.qqt, aVar.bdv());
            }
            cVar.kgE.setVisibility(8);
        }
        Log.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(22867);
        return view;
    }

    @Override // com.tencent.mm.ui.gridviewheaders.e
    public final long EQ(int i2) {
        AppMethodBeat.i(22868);
        long cyL = this.kgc.get(i2).cyL();
        AppMethodBeat.o(22868);
        return cyL;
    }

    @Override // com.tencent.mm.ui.gridviewheaders.e
    public final View a(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(22869);
        if (view == null) {
            Log.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.qqk.getLayoutInflater().inflate(R.layout.un, viewGroup, false);
            aVar = new a();
            aVar.qqq = (TextView) view.findViewById(R.id.dp0);
            aVar.qqr = (TextView) view.findViewById(R.id.dor);
            aVar.qqs = (CheckBox) view.findViewById(R.id.doq);
            view.setTag(aVar);
        } else {
            Log.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.clean.c.c EP = EP(i2);
        aVar.position = i2;
        aVar.qqq.setText(f.formatTime(this.qqk.getString(R.string.dgl), EP.jsm / 1000));
        long cyL = EP.cyL();
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < this.kgc.size(); i3++) {
            if (this.kgc.get(i3).cyL() == cyL) {
                hashSet.add(Integer.valueOf(i3));
            }
        }
        Iterator it = hashSet.iterator();
        boolean z = true;
        while (it.hasNext()) {
            z = !this.oMG.contains(Integer.valueOf(((Integer) it.next()).intValue())) ? false : z;
        }
        if (z) {
            aVar.qqs.setChecked(true);
        } else {
            aVar.qqs.setChecked(false);
        }
        AppMethodBeat.o(22869);
        return view;
    }

    /* access modifiers changed from: package-private */
    public final void cyT() {
        boolean z;
        AppMethodBeat.i(22870);
        this.qqk.ER(this.oMG.size());
        CleanChattingDetailUI cleanChattingDetailUI = this.qqk;
        if (this.oMG.size() == this.kgc.size()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            cleanChattingDetailUI.qqA.setChecked(true);
        } else {
            cleanChattingDetailUI.qqA.setChecked(false);
        }
        Iterator<Integer> it = this.oMG.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            j2 = this.kgc.get(it.next().intValue()).size + j2;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.qqk;
        if (j2 > 0) {
            cleanChattingDetailUI2.qqB.setText(cleanChattingDetailUI2.getString(R.string.bli, new Object[]{Util.getSizeKB(j2)}));
            AppMethodBeat.o(22870);
            return;
        }
        cleanChattingDetailUI2.qqB.setText("");
        AppMethodBeat.o(22870);
    }

    class c {
        CheckBox jVQ;
        TextView kgE;
        MMImageView qqt;
        ImageView qqu;
        View qqv;
        View qqw;

        c() {
        }
    }

    /* access modifiers changed from: package-private */
    public class a {
        int position;
        TextView qqq;
        TextView qqr;
        CheckBox qqs;

        a() {
        }
    }

    public final void cyS() {
        AppMethodBeat.i(22871);
        this.oMG.clear();
        cyT();
        AppMethodBeat.o(22871);
    }

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(22873);
        if (!bVar.isStop) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.clean.ui.fileindexui.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(22856);
                    b.this.notifyDataSetChanged();
                    AppMethodBeat.o(22856);
                }
            });
        }
        AppMethodBeat.o(22873);
    }

    static /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(22874);
        Log.i("MicroMsg.CleanChattingDetailAdapter", "select position=%d", Integer.valueOf(i2));
        if (!bVar.oMG.remove(Integer.valueOf(i2))) {
            bVar.oMG.add(Integer.valueOf(i2));
        }
        bVar.cyT();
        AppMethodBeat.o(22874);
    }

    static /* synthetic */ void a(b bVar, a aVar) {
        AppMethodBeat.i(22875);
        long EQ = bVar.EQ(aVar.position);
        Log.i("MicroMsg.CleanChattingDetailAdapter", "select header position=%d | headerId=%d", Integer.valueOf(aVar.position), Long.valueOf(EQ));
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < bVar.kgc.size(); i2++) {
            if (bVar.kgc.get(i2).cyL() == EQ) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        Iterator it = hashSet.iterator();
        boolean z = true;
        while (it.hasNext()) {
            z = !bVar.oMG.remove(Integer.valueOf(((Integer) it.next()).intValue())) ? false : z;
        }
        if (!z) {
            bVar.oMG.addAll(hashSet);
        }
        bVar.cyT();
        AppMethodBeat.o(22875);
    }
}
