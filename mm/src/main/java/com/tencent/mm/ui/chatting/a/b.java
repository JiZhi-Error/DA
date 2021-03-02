package com.tencent.mm.ui.chatting.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.gallery.h;
import java.util.Date;
import java.util.List;

public final class b extends RecyclerView.a {
    private long PlX;
    public AbstractC2088b PlY;
    private String gAn;
    private com.tencent.mm.av.a.a.c gzE = null;
    private Context mContext;
    public List<c> opg = null;
    private boolean qoo = true;
    public boolean qor;
    private boolean tca = false;
    public boolean tkA = false;

    /* renamed from: com.tencent.mm.ui.chatting.a.b$b  reason: collision with other inner class name */
    public interface AbstractC2088b {
        void a(boolean z, c cVar, int i2);
    }

    public b(Context context, List<c> list, String str) {
        AppMethodBeat.i(35029);
        this.opg = list;
        this.gAn = str;
        bg.aVF();
        this.qoo = com.tencent.mm.model.c.isSDCardAvailable();
        this.mContext = context;
        kj(context);
        AppMethodBeat.o(35029);
    }

    public b(Context context, List<c> list, String str, long j2) {
        AppMethodBeat.i(35030);
        this.opg = list;
        this.PlX = j2;
        this.gAn = str;
        bg.aVF();
        this.qoo = com.tencent.mm.model.c.isSDCardAvailable();
        this.tca = true;
        this.mContext = context;
        kj(context);
        AppMethodBeat.o(35030);
    }

    private void kj(Context context) {
        AppMethodBeat.i(35031);
        c.a aVar = new c.a();
        aVar.jbi = 1;
        aVar.jby = true;
        aVar.hZA = com.tencent.mm.cb.a.jn(context) / 4;
        aVar.hZz = com.tencent.mm.cb.a.jn(context) / 4;
        aVar.jbt = R.color.a3k;
        this.gzE = aVar.bdv();
        AppMethodBeat.o(35031);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(35032);
        int i3 = amx(i2).type;
        AppMethodBeat.o(35032);
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(35033);
        if (i2 == Integer.MAX_VALUE) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.aoc, viewGroup, false));
            AppMethodBeat.o(35033);
            return aVar;
        }
        d dVar = new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ava, viewGroup, false));
        AppMethodBeat.o(35033);
        return dVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2, List list) {
        AppMethodBeat.i(35034);
        if (list == null || list.size() <= 0 || !(vVar instanceof d)) {
            super.a(vVar, i2, list);
            AppMethodBeat.o(35034);
        } else if (((Integer) list.get(0)).intValue() == 0) {
            ((d) vVar).checkBox.setChecked(false);
            ((d) vVar).checkBox.setVisibility(0);
            ((d) vVar).tkM.setVisibility(0);
            AppMethodBeat.o(35034);
        } else {
            ((d) vVar).checkBox.setChecked(false);
            ((d) vVar).checkBox.setVisibility(8);
            ((d) vVar).tkM.setVisibility(8);
            AppMethodBeat.o(35034);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(35035);
        if (!this.qoo) {
            Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", Boolean.valueOf(this.qoo));
            AppMethodBeat.o(35035);
            return;
        }
        c amx = amx(i2);
        if (vVar.auw != Integer.MAX_VALUE) {
            ((d) vVar).tkI.setTag(Integer.valueOf(i2));
            ((d) vVar).tkM.setTag(Integer.valueOf(i2));
            if (amx.tkE) {
                String bdu = s.bdu(amx.imagePath);
                com.tencent.mm.av.a.a bcV = q.bcV();
                String str = amx.imagePath;
                ImageView imageView = ((d) vVar).tkI;
                c.a aVar = new c.a();
                aVar.fullPath = bdu;
                aVar.jbf = true;
                bcV.a(str, imageView, aVar.bdv());
            } else {
                q.bcV().a(amx.imagePath, ((d) vVar).tkI, this.gzE);
            }
            if (amx.tkD || amx.tkE) {
                ((d) vVar).tkJ.setVisibility(0);
                ((d) vVar).qog.setVisibility(0);
                ((d) vVar).qog.setText(Util.nullAs(amx.Pma.tkG, ""));
            } else {
                ((d) vVar).qog.setVisibility(8);
                ((d) vVar).tkJ.setVisibility(8);
            }
            if (this.tkA) {
                ((d) vVar).tkM.setVisibility(0);
                ((d) vVar).checkBox.setVisibility(0);
                if (h.a.Pys.cE(amx.dTX)) {
                    ((d) vVar).tkK.setVisibility(0);
                    ((d) vVar).checkBox.setChecked(true);
                    AppMethodBeat.o(35035);
                    return;
                }
                ((d) vVar).tkK.setVisibility(8);
                ((d) vVar).checkBox.setChecked(false);
                AppMethodBeat.o(35035);
                return;
            }
            ((d) vVar).tkM.setVisibility(8);
            ((d) vVar).checkBox.setVisibility(8);
            AppMethodBeat.o(35035);
        } else if (i2 == getItemCount() - 1 || Cd(amx(i2 + 1).timeStamp) != Cd(amx.timeStamp)) {
            ((a) vVar).jUO.setVisibility(8);
            AppMethodBeat.o(35035);
        } else {
            ((a) vVar).jUO.setVisibility(0);
            ((a) vVar).jUO.setText(Cc(amx.timeStamp));
            if (this.qor) {
                ((a) vVar).progressBar.setVisibility(0);
                AppMethodBeat.o(35035);
                return;
            }
            ((a) vVar).progressBar.setVisibility(8);
            AppMethodBeat.o(35035);
        }
    }

    public final String Cc(long j2) {
        AppMethodBeat.i(35036);
        String a2 = com.tencent.mm.ui.gridviewheaders.a.gWr().a(new Date(j2), this.mContext);
        AppMethodBeat.o(35036);
        return a2;
    }

    private static long Cd(long j2) {
        AppMethodBeat.i(35037);
        long b2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(j2));
        AppMethodBeat.o(35037);
        return b2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(35038);
        int size = this.opg.size();
        AppMethodBeat.o(35038);
        return size;
    }

    public final c amx(int i2) {
        AppMethodBeat.i(35039);
        c cVar = this.opg.get(i2);
        AppMethodBeat.o(35039);
        return cVar;
    }

    public class d extends RecyclerView.v {
        CheckBox checkBox;
        TextView qog;
        ImageView tkI;
        View tkJ;
        ImageView tkK;
        View tkL;
        View tkM;

        public d(View view) {
            super(view);
            AppMethodBeat.i(35028);
            this.tkI = (ImageView) view.findViewById(R.id.dl0);
            this.tkJ = view.findViewById(R.id.j6s);
            this.tkL = view.findViewById(R.id.hry);
            this.qog = (TextView) view.findViewById(R.id.j6p);
            this.tkK = (ImageView) view.findViewById(R.id.dl3);
            this.checkBox = (CheckBox) view.findViewById(R.id.fbe);
            this.tkM = view.findViewById(R.id.fbf);
            this.tkM.setVisibility(8);
            this.checkBox.setVisibility(8);
            this.tkJ.setVisibility(8);
            this.qog.setVisibility(8);
            this.tkL.setVisibility(8);
            this.tkI.setOnClickListener(new View.OnClickListener(b.this) {
                /* class com.tencent.mm.ui.chatting.a.b.d.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(35026);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (view.getTag() == null || !(view.getTag() instanceof Integer)) {
                        Log.e("MicroMsg.MediaHistoryGalleryAdapter", "getTag is %s", view.getTag());
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(35026);
                        return;
                    }
                    c amx = b.this.amx(((Integer) view.getTag()).intValue());
                    if (amx == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(35026);
                        return;
                    }
                    b.a(b.this, view, amx);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(35026);
                }
            });
            this.tkM.setOnClickListener(new View.OnClickListener(b.this) {
                /* class com.tencent.mm.ui.chatting.a.b.d.AnonymousClass2 */

                public final void onClick(View view) {
                    boolean z;
                    AppMethodBeat.i(35027);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!d.this.checkBox.isChecked()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (h.a.Pys.tkt.size() < 9) {
                        d.this.checkBox.setChecked(z);
                        if (d.this.tkK != null) {
                            if (!z) {
                                d.this.tkK.setVisibility(8);
                            } else {
                                d.this.tkK.setVisibility(0);
                            }
                        }
                    } else if (!z) {
                        d.this.checkBox.setChecked(false);
                    }
                    if (b.this.PlY != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        b.this.PlY.a(z, b.this.amx(intValue), intValue);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(35027);
                }
            });
            AppMethodBeat.o(35028);
        }
    }

    public class a extends RecyclerView.v {
        TextView jUO;
        ProgressBar progressBar;

        public a(View view) {
            super(view);
            AppMethodBeat.i(35022);
            this.jUO = (TextView) view.findViewById(R.id.bkk);
            this.progressBar = (ProgressBar) view.findViewById(R.id.ep4);
            AppMethodBeat.o(35022);
        }
    }

    public static class c {
        public a Pma = new a();
        public ca dTX;
        public String imagePath;
        public long timeStamp;
        boolean tkD;
        boolean tkE = false;
        public int type = 0;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(35023);
            if (this.dTX == null || !(obj instanceof ca) || obj == null) {
                boolean equals = super.equals(obj);
                AppMethodBeat.o(35023);
                return equals;
            } else if (this.dTX.field_msgId == ((ca) obj).field_msgId) {
                AppMethodBeat.o(35023);
                return true;
            } else {
                AppMethodBeat.o(35023);
                return false;
            }
        }

        class a {
            public k.b dXm;
            public String tkG;

            a() {
            }
        }

        public c(ca caVar) {
            com.tencent.mm.pluginsdk.model.app.c bdx;
            AppMethodBeat.i(35024);
            this.dTX = caVar;
            String str = "";
            if (caVar.cWJ() || caVar.cWL()) {
                this.tkD = true;
                o.bhj();
                str = t.Qx(caVar.field_imgPath);
                com.tencent.mm.modelvideo.s QN = u.QN(caVar.field_imgPath);
                if (QN != null) {
                    this.Pma.tkG = Util.formatSecToMin(QN.iFw);
                }
                this.Pma.dXm = k.b.aD(caVar.field_content, caVar.field_reserved);
            } else if (caVar.cWK()) {
                this.tkE = true;
                k.b HD = k.b.HD(caVar.field_content);
                if (HD != null) {
                    String str2 = HD.thumburl;
                    e eVar = (e) HD.as(e.class);
                    if (!(eVar == null || eVar.iwi == null)) {
                        this.Pma.tkG = Util.formatSecToMin(eVar.iwi.videoDuration);
                    }
                    str = str2;
                }
            } else {
                str = q.bcR().d(caVar.field_imgPath, false, false);
                if (!Util.isNullOrNil(str) && !str.endsWith("hd") && com.tencent.mm.vfs.s.YS(str + "hd")) {
                    str = str + "hd";
                }
            }
            if (caVar.gDr()) {
                k.b HD2 = k.b.HD(caVar.field_content);
                String str3 = null;
                if (!(HD2 == null || HD2.dCK == null || HD2.dCK.length() <= 0 || (bdx = ao.cgO().bdx(HD2.dCK)) == null)) {
                    str3 = bdx.field_fileFullPath;
                }
                if (str3 != null) {
                    str = str3;
                }
            }
            this.imagePath = str;
            this.timeStamp = caVar.field_createTime;
            AppMethodBeat.o(35024);
        }

        public c(long j2) {
            AppMethodBeat.i(35025);
            this.timeStamp = j2;
            this.type = Integer.MAX_VALUE;
            AppMethodBeat.o(35025);
        }
    }

    static /* synthetic */ void a(b bVar, View view, c cVar) {
        AppMethodBeat.i(163306);
        Intent intent = new Intent();
        intent.putExtra("key_biz_chat_id", bVar.PlX);
        intent.putExtra("key_is_biz_chat", bVar.tca);
        intent.putExtra("KOpenArticleSceneFromScene", 140);
        if (cVar == null) {
            Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
            AppMethodBeat.o(163306);
            return;
        }
        ca caVar = cVar.dTX;
        if (caVar == null) {
            Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
            AppMethodBeat.o(163306);
            return;
        }
        int i2 = bVar.mContext.getResources().getConfiguration().orientation;
        int i3 = 0;
        int i4 = 0;
        int[] iArr = new int[2];
        if (view != null) {
            i3 = view.getWidth();
            i4 = view.getHeight();
            view.getLocationInWindow(iArr);
        }
        intent.addFlags(536870912);
        intent.putExtra("img_gallery_msg_id", caVar.field_msgId).putExtra("img_gallery_msg_svr_id", caVar.field_msgSvrId).putExtra("img_gallery_talker", caVar.field_talker).putExtra("img_gallery_chatroom_name", caVar.field_talker).putExtra("img_gallery_orientation", i2);
        if (view != null) {
            intent.putExtra("img_gallery_width", i3).putExtra("img_gallery_height", i4).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
        } else {
            intent.putExtra("img_gallery_back_from_grid", true);
        }
        if (br.D(caVar)) {
            intent.putExtra("msg_type", 2);
        }
        com.tencent.mm.br.c.f(bVar.mContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
        ((Activity) bVar.mContext).overridePendingTransition(0, 0);
        AppMethodBeat.o(163306);
    }
}
