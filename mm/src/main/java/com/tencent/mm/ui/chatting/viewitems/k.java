package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.q;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.util.Map;

public final class k {

    public static class c extends c implements View.OnClickListener {
        c() {
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 671088689) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36917);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.r_);
                view.setTag(new b().gP(view));
            }
            AppMethodBeat.o(36917);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(36919);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a aVar = (a) view.getTag();
            if (aVar == null) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(36919);
                return;
            }
            if (aVar.state != 1) {
                ((com.tencent.mm.plugin.downloader_app.api.c) g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(view.getContext(), (Intent) null, (a.c) null);
            } else if (h.s(view.getContext(), aVar.appId)) {
                ((com.tencent.mm.plugin.downloader_app.api.c) g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).at(view.getContext(), aVar.appId);
            } else {
                ((com.tencent.mm.plugin.downloader_app.api.c) g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(view.getContext(), new Intent().putExtra("appId", aVar.appId), (a.c) null);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(36919);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            String format;
            AppMethodBeat.i(36918);
            String str2 = caVar.field_content;
            k.b bVar = null;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            }
            if (bVar == null) {
                AppMethodBeat.o(36918);
                return;
            }
            b bVar2 = (b) aVar;
            a aVar3 = (a) bVar.as(a.class);
            if (bVar2.maskView != null) {
                bVar2.maskView.setVisibility(8);
            }
            if (bVar2.checkBox != null) {
                bVar2.checkBox.setVisibility(8);
            }
            if (aVar3.state == 1) {
                bVar2.PKa.setVisibility(0);
                bVar2.PKc.setVisibility(8);
                bVar2.oeJ.setText(aVar3.appName);
                TextView textView = bVar2.PKb;
                long j2 = (long) aVar3.PJZ;
                if (j2 >= TPAudioFrame.TP_CH_STEREO_RIGHT) {
                    format = String.format("%.1fGB", Float.valueOf(((((float) j2) / 1024.0f) / 1024.0f) / 1024.0f));
                } else if (j2 >= 1048576) {
                    format = String.format("%.1fMB", Float.valueOf((((float) j2) / 1024.0f) / 1024.0f));
                } else {
                    format = String.format("%.2fMB", Float.valueOf((((float) j2) / 1024.0f) / 1024.0f));
                }
                textView.setText(format);
                q.bcV().loadImage(aVar3.iconUrl, bVar2.qLw);
                if (h.s(aVar2.Pwc.getContext(), aVar3.appId)) {
                    bVar2.PKg.setText(R.string.bow);
                } else {
                    bVar2.PKg.setText(R.string.bou);
                }
            } else {
                bVar2.PKa.setVisibility(8);
                bVar2.PKc.setVisibility(0);
                bVar2.PKd.setText(aVar2.gOZ());
                a.b.c(bVar2.PKe, aVar2.getTalkerUserName());
                bVar2.PKf.setText(aVar2.Pwc.getContext().getResources().getString(R.string.bp8, aVar3.appName));
                bVar2.PKg.setText(R.string.boz);
            }
            bVar2.puO.setTag(aVar3);
            bVar2.puO.setOnClickListener(this);
            AppMethodBeat.o(36918);
        }
    }

    protected static class b extends c.a {
        View PKa;
        TextView PKb;
        View PKc;
        TextView PKd;
        ImageView PKe;
        TextView PKf;
        TextView PKg;
        TextView oeJ;
        View puO;
        ImageView qLw;

        protected b() {
        }

        public final b gP(View view) {
            AppMethodBeat.i(36916);
            super.create(view);
            this.puO = view.findViewById(R.id.g8o);
            this.PKa = view.findViewById(R.id.bex);
            this.qLw = (ImageView) view.findViewById(R.id.rw);
            this.oeJ = (TextView) view.findViewById(R.id.s_);
            this.PKb = (TextView) view.findViewById(R.id.sg);
            this.PKc = view.findViewById(R.id.jmx);
            this.PKd = (TextView) view.findViewById(R.id.gdf);
            this.PKe = (ImageView) view.findViewById(R.id.gd5);
            this.PKf = (TextView) view.findViewById(R.id.jmu);
            this.PKg = (TextView) view.findViewById(R.id.a_y);
            this.checkBox = (CheckBox) this.convertView.findViewById(R.id.aue);
            this.maskView = this.convertView.findViewById(R.id.ax3);
            AppMethodBeat.o(36916);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PKa;
        }
    }

    public static class a extends f {
        public int PJZ;
        public String appId;
        public String appName;
        public String iconUrl;
        public int state;

        @Override // com.tencent.mm.ag.f
        public final f aHj() {
            AppMethodBeat.i(36913);
            a aVar = new a();
            AppMethodBeat.o(36913);
            return aVar;
        }

        @Override // com.tencent.mm.ag.f
        public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        }

        @Override // com.tencent.mm.ag.f
        public final void a(Map<String, String> map, k.b bVar) {
            AppMethodBeat.i(36914);
            if (bVar.type == 671088689) {
                Log.i("MicroMsg.ChattingItemAppMsgDownloader", "values: %s", map.toString());
                this.state = Util.getInt(Q(map, "state"), 0);
                this.appId = Q(map, "appid");
                this.appName = Q(map, "appname");
                this.PJZ = Util.getInt(Q(map, "appsize"), 0);
                this.iconUrl = Q(map, "iconurl");
            }
            AppMethodBeat.o(36914);
        }

        private static String Q(Map<String, String> map, String str) {
            AppMethodBeat.i(36915);
            String nullAsNil = Util.nullAsNil(map.get(".msg.appmsg.downloaderapp.".concat(String.valueOf(str))));
            AppMethodBeat.o(36915);
            return nullAsNil;
        }
    }
}
