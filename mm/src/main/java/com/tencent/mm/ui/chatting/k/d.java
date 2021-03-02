package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI;
import java.util.Date;
import java.util.LinkedList;

public final class d extends b {
    int PEu = 0;
    int gCo = -1;
    private int qpr = -1;

    public d(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final int getType() {
        return 6;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final void gRY() {
        AppMethodBeat.i(36486);
        Log.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", Boolean.TRUE);
        this.PEm.gSc();
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.chatting.k.d.AnonymousClass1 */
            final /* synthetic */ boolean qoy = true;

            public final void run() {
                ah ahVar;
                k.b HD;
                boolean z;
                AppMethodBeat.i(36479);
                LinkedList linkedList = new LinkedList();
                bg.aVF();
                Cursor ez = c.aSQ().ez(d.this.gAn, d.this.gCo);
                if (ez == null) {
                    Log.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
                    AppMethodBeat.o(36479);
                    return;
                }
                if (ab.Eq(d.this.gAn)) {
                    bg.aVF();
                    ahVar = c.aSX().Kd(d.this.gAn);
                } else {
                    ahVar = null;
                }
                long j2 = 0;
                while (ez.moveToNext()) {
                    try {
                        ca caVar = new ca();
                        caVar.convertFrom(ez);
                        String str = caVar.field_content;
                        if (!(str == null || (HD = k.b.HD(str)) == null)) {
                            if (6 == HD.type) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                long b2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(caVar.field_createTime));
                                if (j2 != b2) {
                                    linkedList.add(new c.C2089c(caVar.field_createTime));
                                    d.this.PEu++;
                                }
                                String b3 = d.b(caVar, ab.Eq(d.this.gAn));
                                as Kn = ((l) g.af(l.class)).aSN().Kn(b3);
                                String str2 = "";
                                if (ahVar != null) {
                                    str2 = ahVar.getDisplayName(b3);
                                }
                                int asl = e.asl(HD.iwJ);
                                a aVar = new a(caVar.field_createTime, HD.type, HD.title, caVar.field_msgId, Kn.field_username, Kn.arI(), Kn.field_conRemark, str2);
                                aVar.iconRes = asl;
                                aVar.desc = Util.getSizeKB((long) HD.iwI);
                                linkedList.add(aVar);
                                if (linkedList.size() % 20 == 0) {
                                    if (d.this.mDataList.size() > 0 && ((c.b) d.this.mDataList.get(d.this.mDataList.size() - 1)).getType() == 2147483646) {
                                        d.this.mDataList.remove(d.this.mDataList.size() - 1);
                                    }
                                    d.this.mDataList.addAll(linkedList);
                                    d.this.mDataList.add(new c.g());
                                    d.this.PEo = d.this.mDataList;
                                    linkedList.clear();
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.ui.chatting.k.d.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(36478);
                                            if (d.this.PEm != null) {
                                                d.this.PEm.D(AnonymousClass1.this.qoy, d.this.mDataList.size());
                                            }
                                            AppMethodBeat.o(36478);
                                        }
                                    });
                                }
                                j2 = b2;
                            }
                        }
                    } catch (Throwable th) {
                        ez.close();
                        AppMethodBeat.o(36479);
                        throw th;
                    }
                }
                ez.close();
                if (d.this.mDataList.size() > 0 && ((c.b) d.this.mDataList.get(d.this.mDataList.size() - 1)).getType() == 2147483646) {
                    d.this.mDataList.remove(d.this.mDataList.size() - 1);
                }
                d.this.mDataList.addAll(linkedList);
                d.this.PEo = d.this.mDataList;
                linkedList.clear();
                Log.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", Integer.valueOf(d.this.mDataList.size()));
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.k.d.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(233480);
                        if (d.this.PEm != null) {
                            d.this.PEm.D(AnonymousClass1.this.qoy, d.this.mDataList.size());
                        }
                        AppMethodBeat.o(233480);
                    }
                });
                AppMethodBeat.o(36479);
            }
        });
        AppMethodBeat.o(36486);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final String bmB() {
        AppMethodBeat.i(36487);
        String string = this.mContext.getString(R.string.gp);
        AppMethodBeat.o(36487);
        return string;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final String gSb() {
        AppMethodBeat.i(36488);
        String string = this.mContext.getString(R.string.gp);
        AppMethodBeat.o(36488);
        return string;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final c.e gRZ() {
        AppMethodBeat.i(36489);
        AnonymousClass2 r0 = new c.e() {
            /* class com.tencent.mm.ui.chatting.k.d.AnonymousClass2 */

            @Override // com.tencent.mm.ui.chatting.a.c.e
            public final void a(View view, int i2, c.b bVar) {
                AppMethodBeat.i(36482);
                Log.i("MicroMsg.FileHistoryListPresenter", "[onItemClick] position:%s", Integer.valueOf(i2));
                d.a(d.this, bVar);
                AppMethodBeat.o(36482);
            }

            @Override // com.tencent.mm.ui.chatting.a.c.e
            public final void b(View view, int i2, final c.b bVar) {
                AppMethodBeat.i(36483);
                Log.i("MicroMsg.FileHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i2));
                new com.tencent.mm.ui.tools.l(view.getContext()).b(view, new View.OnCreateContextMenuListener() {
                    /* class com.tencent.mm.ui.chatting.k.d.AnonymousClass2.AnonymousClass1 */

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(36480);
                        contextMenu.add(0, 0, 0, view.getContext().getString(R.string.g5j));
                        if (!as.bjp(bVar.username) && !ab.Iy(bVar.username)) {
                            contextMenu.add(0, 1, 0, view.getContext().getString(R.string.ay9));
                        }
                        contextMenu.add(0, 2, 0, view.getContext().getString(R.string.b06));
                        AppMethodBeat.o(36480);
                    }
                }, new o.g() {
                    /* class com.tencent.mm.ui.chatting.k.d.AnonymousClass2.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(36481);
                        bg.aVF();
                        d.this.d(menuItem.getItemId(), com.tencent.mm.model.c.aSQ().Hb(bVar.msgId));
                        AppMethodBeat.o(36481);
                    }
                });
                AppMethodBeat.o(36483);
            }
        };
        AppMethodBeat.o(36489);
        return r0;
    }

    @Override // com.tencent.mm.ui.chatting.a.c.f
    public final RecyclerView.v N(ViewGroup viewGroup) {
        AppMethodBeat.i(36490);
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a8s, viewGroup, false));
        AppMethodBeat.o(36490);
        return bVar;
    }

    @Override // com.tencent.mm.ui.chatting.a.c.f
    public final void a(c.a aVar, int i2) {
        AppMethodBeat.i(36491);
        b bVar = (b) aVar;
        a aVar2 = (a) amy(i2);
        if (Util.isNullOrNil(aVar2.desc)) {
            bVar.jBR.setVisibility(8);
        } else {
            bVar.jBR.setVisibility(0);
            bVar.jBR.setText(Util.nullAs(aVar2.desc, ""));
        }
        bVar.nnL.setImageResource(aVar2.iconRes);
        AppMethodBeat.o(36491);
    }

    class b extends c.a {
        TextView jBR;
        ImageView nnL;

        public b(View view) {
            super(view);
            AppMethodBeat.i(36485);
            this.nnL = (ImageView) view.findViewById(R.id.cc2);
            this.jVO.setSingleLine(false);
            this.jVO.setMaxLines(2);
            this.jBR = (TextView) view.findViewById(R.id.cbo);
            AppMethodBeat.o(36485);
        }
    }

    class a extends c.b {
        public String desc;
        public int iconRes;

        public a(long j2, int i2, String str, long j3, String str2, String str3, String str4, String str5) {
            super(j2, i2, str, j3, str2, str3, str4, str5);
        }

        @Override // com.tencent.mm.ui.chatting.a.c.b
        public final boolean bmC(String str) {
            AppMethodBeat.i(36484);
            if (str != null) {
                boolean bmC = super.bmC(str.toLowerCase());
                AppMethodBeat.o(36484);
                return bmC;
            }
            AppMethodBeat.o(36484);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.a.c.b
        public final int getType() {
            return 6;
        }
    }

    static /* synthetic */ void a(d dVar, c.b bVar) {
        AppMethodBeat.i(36492);
        if (!dVar.gSk()) {
            u.g(dVar.mContext, null);
            AppMethodBeat.o(36492);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(dVar.mContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        intent.putExtra("app_msg_id", bVar.msgId);
        if (dVar.qpr == 3) {
            intent.putExtra("scene", 3);
            intent.putExtra("app_show_share", false);
            ((MediaHistoryListUI) dVar.mContext).startActivityForResult(intent, 4);
            AppMethodBeat.o(36492);
            return;
        }
        Context context = dVar.mContext;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/presenter/FileHistoryListPresenter", "enterFileProfile", "(Lcom/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseMediaHistoryListItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/presenter/FileHistoryListPresenter", "enterFileProfile", "(Lcom/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseMediaHistoryListItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36492);
    }
}
