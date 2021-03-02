package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.LoadingMoreView;
import com.tencent.mm.plugin.sns.ui.SnsUserUI;
import com.tencent.mm.plugin.sns.ui.album.b;
import com.tencent.mm.plugin.sns.ui.album.c;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a extends RecyclerView.a {
    private final int ESX = 0;
    private final int ESY = 1;
    private final int ESZ = 2;
    List<b> ETa = new ArrayList();
    String ETb = "";
    String ETc = "";
    boolean ETd = false;
    private long ETe = 0;
    private long ETf = 0;
    int ETg = 0;
    private int ETh = 0;
    private b ETi = null;
    c.a ETj = null;
    private AbstractC1735a ETk = null;
    private boolean EqY = false;
    private String goe = "";
    private Context mContext = null;
    private String ppP = "";
    private boolean qhf = false;
    private String wUp = null;

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.a$a */
    public interface AbstractC1735a {
        void hh(List<b> list);
    }

    public static class d {
        public cnb ETo = null;
        public int ecf = 0;
    }

    public a(Context context, String str, AbstractC1735a aVar) {
        AppMethodBeat.i(99856);
        this.mContext = context;
        this.ETk = aVar;
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(this.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.mContext);
        Log.d("MicroMsg.SnsAlbumAdapter", "filterLan temp ".concat(String.valueOf(loadApplicationLanguage)));
        if (!loadApplicationLanguage.equals(LocaleUtil.CHINA) && !loadApplicationLanguage.equals(LocaleUtil.ENGLISH) && !loadApplicationLanguage.equals(LocaleUtil.TAIWAN)) {
            loadApplicationLanguage = loadApplicationLanguage.equals(LocaleUtil.HONGKONG) ? LocaleUtil.TAIWAN : LocaleUtil.ENGLISH;
        }
        this.wUp = loadApplicationLanguage;
        this.goe = str;
        g.aAi();
        if (this.goe.equals((String) g.aAh().azQ().get(2, (Object) null))) {
            this.EqY = true;
        }
        this.ETi = new b(new b.a() {
            /* class com.tencent.mm.plugin.sns.ui.album.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.ui.album.b.a
            public final void hg(List<b> list) {
                AppMethodBeat.i(99849);
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
                Log.d("MicroMsg.SnsAlbumAdapter", "onLoadingFinish list.size=%s", objArr);
                a.this.ETa.clear();
                b bVar = new b();
                bVar.label = "my_timeline";
                a.this.ETa.add(bVar);
                a.this.ETa.addAll(list);
                a.this.ETh = a.b(a.this);
                if (!list.isEmpty()) {
                    b bVar2 = new b();
                    bVar2.label = "loading";
                    a.this.ETa.add(bVar2);
                }
                a.this.atj.notifyChanged();
                if (a.this.ETk != null) {
                    a.this.ETk.hh(list);
                }
                AppMethodBeat.o(99849);
            }
        }, this.goe, this.EqY);
        JS(0);
        Log.d("MicroMsg.SnsAlbumAdapter", "limitId=%s", this.ETc);
        vw(false);
        AppMethodBeat.o(99856);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        int i3;
        AppMethodBeat.i(99857);
        if ("loading".equals(this.ETa.get(i2).label)) {
            i3 = 1;
        } else {
            i3 = "my_timeline".equals(this.ETa.get(i2).label) ? 2 : 0;
        }
        AppMethodBeat.o(99857);
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        RecyclerView.v fVar;
        AppMethodBeat.i(99858);
        Log.d("MicroMsg.SnsAlbumAdapter", "onCreateViewHolder %s", Integer.valueOf(i2));
        if (i2 == 1) {
            fVar = new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bv4, viewGroup, false));
        } else if (i2 == 2) {
            fVar = new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bv6, viewGroup, false));
        } else {
            fVar = new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bv3, viewGroup, false));
        }
        AppMethodBeat.o(99858);
        return fVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(99859);
        Log.d("MicroMsg.SnsAlbumAdapter", "onBindViewHolder %s", Integer.valueOf(i2));
        if (vVar instanceof c) {
            c cVar = (c) vVar;
            Log.d("MicroMsg.SnsAlbumAdapter", "SnsAlbumLoadingHolder onBind");
            if (a.this.qhf) {
                cVar.ETn.setVisibility(0);
                cVar.ETn.aQU(a.this.ppP);
                AppMethodBeat.o(99859);
                return;
            }
            cVar.ETn.setVisibility(0);
            AppMethodBeat.o(99859);
            return;
        }
        if (vVar instanceof f) {
            f fVar = (f) vVar;
            b bVar = a.this.ETa.get(i2);
            b bVar2 = i2 > 1 ? a.this.ETa.get(i2 - 1) : null;
            int head = bVar.ETm.get(0).getHead();
            int head2 = bVar2 == null ? 0 : bVar2.ETm.get(0).getHead();
            int i3 = head / 10000;
            int i4 = head2 / 10000;
            Log.d("MicroMsg.SnsAlbumAdapter", "handleDateTv prehead=%s head=%s", Integer.valueOf(head2), Integer.valueOf(head));
            if ((head2 != 0 || i3 == bm.getYear()) && (head2 == 0 || i3 == i4)) {
                fVar.jUO.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = fVar.aus.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.topMargin = com.tencent.mm.cb.a.aH(fVar.jUO.getContext(), R.dimen.f3062g);
                    fVar.aus.setLayoutParams(marginLayoutParams);
                }
            } else {
                fVar.jUO.setText(String.format(a.this.mContext.getResources().getString(R.string.hc5), Integer.valueOf(i3)));
                fVar.jUO.setVisibility(0);
                ViewGroup.LayoutParams layoutParams2 = fVar.aus.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    if (head2 != 0) {
                        marginLayoutParams2.topMargin = com.tencent.mm.cb.a.fromDPToPix(fVar.jUO.getContext(), 70);
                    } else {
                        marginLayoutParams2.topMargin = com.tencent.mm.cb.a.aH(fVar.jUO.getContext(), R.dimen.f3062g);
                    }
                    fVar.aus.setLayoutParams(marginLayoutParams2);
                }
            }
            String str = bVar.label;
            if (str.indexOf(":") != -1) {
                String[] split = str.split(":");
                if (split.length > 1) {
                    fVar.timeTv.setText(split[1]);
                }
            } else {
                fVar.timeTv.setText(str);
            }
            fVar.ETu.setLayoutManager(fVar.opj);
            fVar.ETu.setAdapter(fVar.ETt);
            c cVar2 = fVar.ETt;
            List<SnsInfo> list = bVar.ETm;
            cVar2.ETw.clear();
            for (SnsInfo snsInfo : list) {
                Iterator<cnb> it = snsInfo.getTimeLine().ContentObj.LoV.iterator();
                while (it.hasNext()) {
                    d dVar = new d();
                    dVar.ecf = snsInfo.localid;
                    dVar.ETo = it.next();
                    cVar2.ETw.add(dVar);
                }
            }
            cVar2.atj.notifyChanged();
        }
        AppMethodBeat.o(99859);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(99860);
        int size = this.ETa.size();
        AppMethodBeat.o(99860);
        return size;
    }

    public final void aRn(String str) {
        AppMethodBeat.i(99861);
        Log.d("MicroMsg.SnsAlbumAdapter", "snsactivty onIsDownAll ");
        this.qhf = true;
        this.ppP = str;
        AppMethodBeat.o(99861);
    }

    public final void fiE() {
        long j2;
        AppMethodBeat.i(99862);
        Log.d("MicroMsg.SnsAlbumAdapter", "i addSize ");
        if (this.ETa.size() > 1) {
            List<SnsInfo> list = this.ETa.get(this.ETa.size() - 2).ETm;
            if (!list.isEmpty()) {
                j2 = list.get(list.size() - 1).field_snsId;
                JS(j2);
                AppMethodBeat.o(99862);
            }
        }
        j2 = 0;
        JS(j2);
        AppMethodBeat.o(99862);
    }

    private void JS(long j2) {
        a aVar;
        AppMethodBeat.i(99863);
        String Jc = r.Jc(aj.faO().Y(j2, aj.faE().aPn(this.goe)));
        if (this.ETb.equals("")) {
            aVar = this;
        } else if (Jc.compareTo(this.ETb) < 0) {
            aVar = this;
        } else {
            Jc = this.ETb;
            aVar = this;
        }
        aVar.ETc = Jc;
        ami feM = aj.faS().aQr(this.goe).feM();
        if (feM.Lvc == 0) {
            AppMethodBeat.o(99863);
            return;
        }
        String Jc2 = r.Jc(feM.Lvc);
        if (this.ETc.equals("")) {
            this.ETc = Jc2;
            AppMethodBeat.o(99863);
            return;
        }
        Log.d("MicroMsg.SnsAlbumAdapter", "updateLimieSeq getListId=%s mLimitSeq=%s", Long.valueOf(j2), this.ETc);
        if (Jc2.compareTo(this.ETc) <= 0) {
            Jc2 = this.ETc;
        }
        this.ETc = Jc2;
        AppMethodBeat.o(99863);
    }

    public final void vw(boolean z) {
        AppMethodBeat.i(99864);
        Log.d("MicroMsg.SnsAlbumAdapter", "limitSeq " + this.ETc);
        if (this.ETi != null) {
            this.ETi.k(this.ETc, this.ETd, z);
        }
        AppMethodBeat.o(99864);
    }

    public final void JR(long j2) {
        if (0 == this.ETe) {
            this.ETe = j2;
            this.ETf = 0;
        }
    }

    public final ArrayList<com.tencent.mm.plugin.sns.j.b> cv(int i2, String str) {
        AppMethodBeat.i(99865);
        Log.d("MicroMsg.SnsAlbumAdapter", "snsLocalId=%s", Integer.valueOf(i2));
        ArrayList<com.tencent.mm.plugin.sns.j.b> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.ETa.size(); i3++) {
            for (SnsInfo snsInfo : this.ETa.get(i3).ETm) {
                int i4 = snsInfo.localid;
                if (!(snsInfo.getTimeLine() == null || snsInfo.getTimeLine().ContentObj == null || snsInfo.getTimeLine().ContentObj.LoV.size() == 0)) {
                    if (snsInfo.getTimeLine().ContentObj.LoU == 1 || snsInfo.getTimeLine().ContentObj.LoU == 15) {
                        if (i4 == i2) {
                            Log.d("MicroMsg.SnsAlbumAdapter", "mFixPosition=%s", Integer.valueOf(this.ETg));
                            this.ETg = arrayList.size();
                        }
                        int i5 = 0;
                        Iterator<cnb> it = snsInfo.getTimeLine().ContentObj.LoV.iterator();
                        while (it.hasNext()) {
                            cnb next = it.next();
                            if (Util.isEqual(next.Id, str)) {
                                this.ETg += i5;
                            }
                            com.tencent.mm.plugin.sns.j.b bVar = new com.tencent.mm.plugin.sns.j.b();
                            bVar.ebR = next;
                            bVar.parentId = y.bq("sns_table_", (long) i4);
                            bVar.iXu = snsInfo.getCreateTime();
                            i5++;
                            bVar.DRJ = i5;
                            arrayList.add(bVar);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(99865);
        return arrayList;
    }

    class f extends RecyclerView.v {
        private LinearLayout EIn = null;
        c ETt = null;
        RecyclerView ETu = null;
        TextView jUO = null;
        GridLayoutManager opj = null;
        TextView timeTv = null;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(View view) {
            super(view);
            a.this = r4;
            AppMethodBeat.i(99855);
            this.jUO = (TextView) view.findViewById(R.id.hwh);
            this.timeTv = (TextView) view.findViewById(R.id.hwn);
            this.ETu = (RecyclerView) view.findViewById(R.id.hwm);
            Context unused = r4.mContext;
            this.opj = new GridLayoutManager(3);
            this.ETt = new c();
            this.ETt.ETx = r4.ETj;
            AppMethodBeat.o(99855);
        }
    }

    class c extends RecyclerView.v {
        LoadingMoreView ETn = null;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            a.this = r3;
            AppMethodBeat.i(99852);
            this.ETn = (LoadingMoreView) view.findViewById(R.id.hwi);
            AppMethodBeat.o(99852);
        }
    }

    /* access modifiers changed from: package-private */
    public class e extends RecyclerView.v {
        private TextView ETp = null;
        private WeImageView ETq = null;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(View view) {
            super(view);
            a.this = r4;
            AppMethodBeat.i(99854);
            this.ETp = (TextView) view.findViewById(R.id.kq);
            this.ETq = (WeImageView) view.findViewById(R.id.kp);
            this.ETp.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.album.a.e.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(99853);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumAdapter$SnsAlbumTimelineHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    a.f(a.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumAdapter$SnsAlbumTimelineHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99853);
                }
            });
            AppMethodBeat.o(99854);
        }
    }

    public static class b {
        public List<SnsInfo> ETm = new ArrayList();
        public String label = "";

        public b() {
            AppMethodBeat.i(99850);
            AppMethodBeat.o(99850);
        }

        public final String toString() {
            AppMethodBeat.i(99851);
            StringBuilder sb = new StringBuilder();
            for (SnsInfo snsInfo : this.ETm) {
                sb.append("\t[localId=").append(snsInfo.localid).append(", snsId=").append(snsInfo.field_snsId).append("\n");
            }
            String str = this.label + "\n" + sb.toString();
            AppMethodBeat.o(99851);
            return str;
        }
    }

    static /* synthetic */ int b(a aVar) {
        AppMethodBeat.i(163128);
        int i2 = 0;
        for (b bVar : aVar.ETa) {
            i2 = bVar.ETm.size() + i2;
        }
        AppMethodBeat.o(163128);
        return i2;
    }

    static /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(163129);
        Intent intent = new Intent(aVar.mContext, SnsUserUI.class);
        intent.putExtra("sns_userName", aVar.goe);
        intent.putExtra("sns_rpt_scene", 21);
        Context context = aVar.mContext;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/ui/album/SnsAlbumAdapter", "goMyTimeline", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumAdapter", "goMyTimeline", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(163129);
    }
}
