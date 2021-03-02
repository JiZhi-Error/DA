package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.util.ArrayList;

public final class a extends RecyclerView.a<C0948a> {
    private Context mContext;
    ArrayList<b> mDataList = new ArrayList<>();
    private DownloadSearchListView qLp;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(C0948a aVar, int i2) {
        int i3 = 0;
        AppMethodBeat.i(8932);
        C0948a aVar2 = aVar;
        b bVar = this.mDataList.get(i2);
        switch (bVar.type) {
            case 1:
                aVar2.qLq.setVisibility(0);
                aVar2.qLs.setVisibility(8);
                aVar2.qLv.setVisibility(8);
                AppMethodBeat.o(8932);
                return;
            case 2:
                aVar2.qLq.setVisibility(8);
                aVar2.qLs.setVisibility(0);
                aVar2.qLv.setVisibility(8);
                aVar2.qLt.setText(bVar.qLO);
                aVar2.qLu.setTag(bVar);
                AppMethodBeat.o(8932);
                return;
            case 3:
                aVar2.qLq.setVisibility(8);
                aVar2.qLs.setVisibility(8);
                aVar2.qLv.setVisibility(0);
                q.bcV().loadImage(bVar.iconUrl, aVar2.qLw);
                aVar2.jBQ.setText(Html.fromHtml(bVar.qLP));
                aVar2.qLy.removeAllViews();
                if (!Util.isNullOrNil(bVar.qLQ)) {
                    while (i3 < bVar.qLQ.size() && i3 <= 2) {
                        View inflate = LayoutInflater.from(a.this.mContext).inflate(R.layout.c1f, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.ih8)).setText(bVar.qLQ.get(i3));
                        aVar2.qLy.addView(inflate);
                        i3++;
                    }
                }
                aVar2.qLz.setText(C0948a.CJ(bVar.size));
                aVar2.qLx.setTag(bVar);
                switch (bVar.state) {
                    case 1:
                        aVar2.setButtonText(R.string.bn7);
                        AppMethodBeat.o(8932);
                        return;
                    case 2:
                        aVar2.setButtonText(R.string.edq);
                        AppMethodBeat.o(8932);
                        return;
                    case 3:
                        aVar2.setButtonText(R.string.hsx);
                        AppMethodBeat.o(8932);
                        return;
                    case 4:
                        aVar2.setButtonText(R.string.e3m);
                        break;
                }
        }
        AppMethodBeat.o(8932);
    }

    a(Context context, DownloadSearchListView downloadSearchListView) {
        AppMethodBeat.i(8929);
        this.mContext = context;
        this.qLp = downloadSearchListView;
        AppMethodBeat.o(8929);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(8930);
        int i3 = this.mDataList.get(i2).type;
        AppMethodBeat.o(8930);
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(8931);
        int size = this.mDataList.size();
        AppMethodBeat.o(8931);
        return size;
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.search.a$a  reason: collision with other inner class name */
    public class C0948a extends RecyclerView.v {
        public View contentView;
        public TextView jBQ;
        public View qLq = this.contentView.findViewById(R.id.he2);
        public TextView qLr = ((TextView) this.contentView.findViewById(R.id.dpk));
        public View qLs;
        public TextView qLt;
        public ImageView qLu;
        public View qLv;
        public ImageView qLw;
        public Button qLx;
        public LinearLayout qLy;
        public TextView qLz;

        public C0948a(View view) {
            super(view);
            AppMethodBeat.i(8927);
            this.contentView = view;
            this.qLr.setOnClickListener(new View.OnClickListener(a.this) {
                /* class com.tencent.mm.plugin.downloader_app.search.a.C0948a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(8924);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    DownloadSearchListView downloadSearchListView = a.this.qLp;
                    downloadSearchListView.mContext.getSharedPreferences("search_history_href", 0).edit().putString("search_history_list", "").commit();
                    if (downloadSearchListView.qLE != null) {
                        downloadSearchListView.qLE.clear();
                    }
                    downloadSearchListView.setData(null);
                    com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, 21, 81, "", "", "");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(8924);
                }
            });
            this.qLs = this.contentView.findViewById(R.id.he5);
            this.qLt = (TextView) this.contentView.findViewById(R.id.hef);
            this.qLu = (ImageView) this.contentView.findViewById(R.id.hdr);
            this.qLu.setOnClickListener(new View.OnClickListener(a.this) {
                /* class com.tencent.mm.plugin.downloader_app.search.a.C0948a.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(8925);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    b bVar2 = (b) view.getTag();
                    DownloadSearchListView downloadSearchListView = a.this.qLp;
                    String str = bVar2.qLO;
                    if (!Util.isNullOrNil(str)) {
                        b.av(downloadSearchListView.mContext, str);
                        downloadSearchListView.qLE = b.eX(downloadSearchListView.mContext);
                        downloadSearchListView.setData(downloadSearchListView.qLE);
                    }
                    com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, bVar2.position, 81, "", "", "");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(8925);
                }
            });
            this.qLv = this.contentView.findViewById(R.id.hez);
            this.qLw = (ImageView) this.contentView.findViewById(R.id.rw);
            this.qLx = (Button) this.contentView.findViewById(R.id.e1z);
            this.qLx.setOnClickListener(new View.OnClickListener(a.this) {
                /* class com.tencent.mm.plugin.downloader_app.search.a.C0948a.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(8926);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    b bVar2 = (b) view.getTag();
                    a.this.qLp.alC(bVar2.qLO);
                    if (a.this.mContext.getResources().getString(R.string.edq).equals(C0948a.this.qLx.getText().toString())) {
                        com.tencent.mm.plugin.downloader.i.a.as(a.this.mContext, bVar2.appId);
                        com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, bVar2.position, 22, bVar2.appId, "", "");
                    } else if (a.this.mContext.getResources().getString(R.string.e3m).equals(C0948a.this.qLx.getText().toString())) {
                        com.tencent.mm.plugin.downloader.g.a alb = d.alb(bVar2.appId);
                        if (alb == null) {
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(8926);
                            return;
                        } else if (s.YS(alb.field_filePath)) {
                            com.tencent.mm.plugin.downloader.i.a.a(alb.field_downloadId, false, null);
                            com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, bVar2.position, 44, bVar2.appId, "", "");
                        }
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("appId", bVar2.appId);
                        intent.addFlags(67108864);
                        ((c) g.af(c.class)).a(a.this.mContext, intent, (a.c) null);
                        com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, bVar2.position, 23, bVar2.appId, "", "");
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(8926);
                }
            });
            this.jBQ = (TextView) this.contentView.findViewById(R.id.sa);
            this.qLy = (LinearLayout) this.contentView.findViewById(R.id.sl);
            this.qLz = (TextView) this.contentView.findViewById(R.id.sh);
            AppMethodBeat.o(8927);
        }

        static String CJ(long j2) {
            AppMethodBeat.i(8928);
            if (j2 >= TPAudioFrame.TP_CH_STEREO_RIGHT) {
                String format = String.format("%.1fGB", Float.valueOf(((((float) j2) / 1024.0f) / 1024.0f) / 1024.0f));
                AppMethodBeat.o(8928);
                return format;
            } else if (j2 >= 1048576) {
                String format2 = String.format("%.1fMB", Float.valueOf((((float) j2) / 1024.0f) / 1024.0f));
                AppMethodBeat.o(8928);
                return format2;
            } else {
                String format3 = String.format("%.2fMB", Float.valueOf((((float) j2) / 1024.0f) / 1024.0f));
                AppMethodBeat.o(8928);
                return format3;
            }
        }

        /* access modifiers changed from: package-private */
        public final void setButtonText(int i2) {
            AppMethodBeat.i(183809);
            if (i2 == R.string.e3m) {
                this.qLx.setBackgroundColor(android.support.v4.content.b.n(a.this.mContext, R.color.Brand));
                this.qLx.setTextColor(android.support.v4.content.b.n(a.this.mContext, R.color.afz));
            } else {
                this.qLx.setBackgroundColor(android.support.v4.content.b.n(a.this.mContext, R.color.BW_0_Alpha_0_0_5));
                this.qLx.setTextColor(android.support.v4.content.b.n(a.this.mContext, R.color.Brand_90));
            }
            this.qLx.setText(i2);
            AppMethodBeat.o(183809);
        }
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ C0948a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(8933);
        C0948a aVar = new C0948a(LayoutInflater.from(this.mContext).inflate(R.layout.bp0, viewGroup, false));
        AppMethodBeat.o(8933);
        return aVar;
    }
}
