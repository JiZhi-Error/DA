package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Map;

public abstract class b {
    protected o tdg = null;
    public final a tle = new a();

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.b$b  reason: collision with other inner class name */
    public static class C1049b {
        public CheckBox jVQ;
        public TextView kgE;
        public g tbr;
        public TextView timeTV;
        public View tlh;
        public WeImageView tli;
        public TextView tlj;
        public ImageView tlk;
        public LinearLayout tll;
        public TextView tlm;
    }

    public interface c {
        void Ec(long j2);
    }

    public abstract View a(View view, ViewGroup viewGroup, g gVar);

    public abstract void a(View view, and and);

    public b(o oVar) {
        this.tdg = oVar;
    }

    public static class a {
        public String gzZ;
        public long lastUpdateTime;
        public boolean poG;
        public boolean thl;
        public Map<String, g> thm;
        public boolean tht;
        public c tlg;

        public final String toString() {
            AppMethodBeat.i(107448);
            StringBuilder sb = new StringBuilder();
            sb.append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
            sb.append("isSearching:").append(this.poG).append('\n');
            sb.append("search str:").append(this.gzZ).append('\n');
            String sb2 = sb.toString();
            AppMethodBeat.o(107448);
            return sb2;
        }
    }

    /* access modifiers changed from: protected */
    public final View a(View view, C1049b bVar, g gVar) {
        if (view == null) {
            throw new NullPointerException("base item view is null");
        }
        bVar.tlh = view.findViewById(R.id.cdr);
        if (bVar.tlh == null) {
            throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
        }
        bVar.tli = (WeImageView) view.findViewById(R.id.cdq);
        if (bVar.tli == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_type_iv");
        }
        bVar.kgE = (TextView) view.findViewById(R.id.ccm);
        if (bVar.kgE == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_name");
        }
        bVar.tlj = (TextView) view.findViewById(R.id.cdu);
        if (bVar.tlj == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_version_info");
        }
        bVar.timeTV = (TextView) view.findViewById(R.id.cdl);
        if (bVar.timeTV == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_time");
        }
        bVar.jVQ = (CheckBox) view.findViewById(R.id.cbc);
        if (bVar.jVQ == null) {
            throw new IllegalArgumentException("base item view do not contain id named checkbox");
        }
        bVar.tlk = (ImageView) view.findViewById(R.id.cdi);
        if (bVar.tlk == null) {
            throw new IllegalArgumentException("base item view do not contain id named tagIV");
        }
        bVar.jVQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.fav.ui.d.b.AnonymousClass1 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(107446);
                if (compoundButton.getTag() == null) {
                    AppMethodBeat.o(107446);
                    return;
                }
                g gVar = (g) compoundButton.getTag();
                if (z) {
                    g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(gVar.field_localId);
                    if (gVar.tad) {
                        gVar.tae = DY;
                        b.this.tle.thm.put(gVar.dLb, gVar);
                    } else {
                        b.this.tle.thm.put(Util.notNullToString(Long.valueOf(gVar.field_localId)), DY);
                    }
                } else if (gVar.tad) {
                    b.this.tle.thm.remove(gVar.dLb);
                } else {
                    b.this.tle.thm.remove(Util.notNullToString(Long.valueOf(gVar.field_localId)));
                }
                if (b.this.tle.tlg != null) {
                    b.this.tle.tlg.Ec(gVar.field_localId);
                }
                AppMethodBeat.o(107446);
            }
        });
        bVar.tbr = gVar;
        view.setTag(bVar);
        bVar.tll = (LinearLayout) view.findViewById(R.id.cdf);
        bVar.tlm = (TextView) view.findViewById(R.id.cde);
        bVar.tlm.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.d.b.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(107447);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.FavBaseListItem", "manual restart upload");
                if (view.getTag() instanceof g) {
                    com.tencent.mm.plugin.fav.a.b.l((g) view.getTag());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107447);
            }
        });
        return view;
    }

    /* access modifiers changed from: protected */
    public final void a(C1049b bVar, g gVar) {
        boolean z = true;
        bVar.tbr = gVar;
        if (bVar.tbr.field_type == 18) {
            bVar.tlh.setVisibility(0);
        } else {
            bVar.tlh.setVisibility(8);
        }
        if (!this.tle.tht) {
            bVar.timeTV.setText(m.h(bVar.timeTV.getContext(), bVar.tbr.field_updateTime));
        } else {
            bVar.timeTV.setText(com.tencent.mm.plugin.fav.a.b.DP(bVar.tbr.field_datatotalsize));
        }
        a(bVar);
        if (bVar.tbr.cUy()) {
            bVar.tll.setVisibility(0);
        } else {
            bVar.tll.setVisibility(8);
        }
        bVar.jVQ.setTag(gVar);
        if (this.tle.thl || this.tle.tht) {
            bVar.jVQ.setVisibility(0);
            if (gVar.tad) {
                CheckBox checkBox = bVar.jVQ;
                if (this.tle.thm.get(gVar.dLb) == null) {
                    z = false;
                }
                checkBox.setChecked(z);
            } else {
                CheckBox checkBox2 = bVar.jVQ;
                if (this.tle.thm.get(Util.notNullToString(Long.valueOf(gVar.field_localId))) == null) {
                    z = false;
                }
                checkBox2.setChecked(z);
            }
        } else {
            bVar.jVQ.setVisibility(8);
        }
        bVar.tlm.setTag(gVar);
        if (gVar.field_tagProto.Lyo == null || gVar.field_tagProto.Lyo.isEmpty()) {
            bVar.tlk.setVisibility(8);
        } else {
            bVar.tlk.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void a(C1049b bVar) {
        String arL;
        Context context = bVar.kgE.getContext();
        as bjK = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjK(bVar.tbr.field_fromUser);
        if (bjK == null || !bjK.field_username.equals(bVar.tbr.field_fromUser)) {
            Log.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", bVar.tbr.field_fromUser);
            bVar.kgE.setText("");
            ay.a.iDq.a(bVar.tbr.field_fromUser, "", null);
            return;
        }
        if (ab.Eq(bVar.tbr.field_fromUser)) {
            anh anh = bVar.tbr.field_favProto.Lya;
            if (z.aTY().equals(anh.dRL)) {
                arL = com.tencent.mm.plugin.fav.a.b.arL(anh.toUser);
            } else {
                arL = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(anh.dRL);
            }
        } else {
            arL = com.tencent.mm.plugin.fav.a.b.arL(bjK.field_username);
        }
        bVar.kgE.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, arL, bVar.kgE.getTextSize()));
    }
}
