package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class c extends s<com.tencent.mm.plugin.masssend.a.a> {
    private static short znL = 1;
    private static short znM = 2;
    private static short znN = 3;
    private static short znO = 4;
    int gAZ;
    private MMActivity gte;
    private LayoutInflater kgB;
    int qdp;
    private short[] znP;
    private List<String> znQ;
    String znR = "";
    e znS;

    /* access modifiers changed from: package-private */
    public interface e {
        String aDQ(String str);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ com.tencent.mm.plugin.masssend.a.a a(com.tencent.mm.plugin.masssend.a.a aVar, Cursor cursor) {
        AppMethodBeat.i(26415);
        com.tencent.mm.plugin.masssend.a.a aVar2 = aVar;
        if (aVar2 == null) {
            aVar2 = new com.tencent.mm.plugin.masssend.a.a();
        }
        aVar2.convertFrom(cursor);
        AppMethodBeat.o(26415);
        return aVar2;
    }

    public c(Context context) {
        super(context, new com.tencent.mm.plugin.masssend.a.a());
        AppMethodBeat.i(26409);
        this.gte = (MMActivity) context;
        this.znQ = new LinkedList();
        this.qdp = 10;
        this.gAZ = this.qdp;
        this.kgB = aa.jQ(context);
        AppMethodBeat.o(26409);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(26410);
        anp();
        AppMethodBeat.o(26410);
    }

    public final boolean cwg() {
        return this.qdp >= this.gAZ;
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(26411);
        this.gAZ = h.ehF().ehA();
        setCursor(h.ehF().Pf(this.qdp));
        ehR();
        super.notifyDataSetChanged();
        AppMethodBeat.o(26411);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.masssend.a.a aVar;
        String str;
        ArrayList<String> arrayList;
        AppMethodBeat.i(26412);
        com.tencent.mm.plugin.masssend.a.a aVar2 = (com.tencent.mm.plugin.masssend.a.a) getItem(i2);
        if (i2 != 0) {
            long j2 = ((com.tencent.mm.plugin.masssend.a.a) getItem(i2 - 1)).createTime;
            com.tencent.mm.plugin.masssend.a.a aVar3 = (com.tencent.mm.plugin.masssend.a.a) getItem(i2);
            long j3 = aVar3.createTime;
            boolean z = j3 - j2 < Util.MILLSECONDS_OF_MINUTE;
            boolean z2 = (j3 - j2) / 180000 < 1;
            if (z || z2) {
                this.znP[i2] = 2;
                aVar = aVar3;
            } else {
                this.znP[i2] = 1;
                aVar = aVar3;
            }
        } else {
            this.znP[i2] = 1;
            aVar = aVar2;
        }
        boolean z3 = this.znP[i2] == 1 && aVar.createTime > 1000;
        switch (aVar.msgType) {
            case 1:
                f fVar = new f();
                if (view == null || ((f) view.getTag()).zob != znL) {
                    view = this.kgB.inflate(R.layout.b6l, (ViewGroup) null);
                    fVar.znU = (TextView) view.findViewById(R.id.faj);
                    fVar.znV = (TextView) view.findViewById(R.id.fam);
                    fVar.znW = (TextView) view.findViewById(R.id.fan);
                    fVar.znY = (TextView) view.findViewById(R.id.fah);
                    fVar.pwO = (TextView) view.findViewById(R.id.fas);
                    fVar.zoa = view.findViewById(R.id.fai);
                    fVar.zob = znL;
                    view.setTag(fVar);
                    break;
                }
            case 3:
                f fVar2 = new f();
                if (view == null || ((f) view.getTag()).zob != znM) {
                    view = this.kgB.inflate(R.layout.b6k, (ViewGroup) null);
                    fVar2.znU = (TextView) view.findViewById(R.id.faj);
                    fVar2.znV = (TextView) view.findViewById(R.id.fam);
                    fVar2.mEx = (ImageView) view.findViewById(R.id.fao);
                    fVar2.znY = (TextView) view.findViewById(R.id.fah);
                    fVar2.pwO = (TextView) view.findViewById(R.id.fas);
                    fVar2.zoa = view.findViewById(R.id.fai);
                    fVar2.zob = znM;
                    view.setTag(fVar2);
                    break;
                }
            case 34:
                f fVar3 = new f();
                if (view == null || ((f) view.getTag()).zob != znO) {
                    view = this.kgB.inflate(R.layout.b6n, (ViewGroup) null);
                    fVar3.znU = (TextView) view.findViewById(R.id.faj);
                    fVar3.znV = (TextView) view.findViewById(R.id.fam);
                    fVar3.znX = (TextView) view.findViewById(R.id.fak);
                    fVar3.znW = (TextView) view.findViewById(R.id.far);
                    fVar3.znZ = (AnimImageView) view.findViewById(R.id.faq);
                    fVar3.znY = (TextView) view.findViewById(R.id.fah);
                    fVar3.pwO = (TextView) view.findViewById(R.id.fas);
                    fVar3.zoa = view.findViewById(R.id.fai);
                    fVar3.zob = znO;
                    view.setTag(fVar3);
                    break;
                }
            case 43:
                f fVar4 = new f();
                if (view == null || ((f) view.getTag()).zob != znN) {
                    view = this.kgB.inflate(R.layout.b6m, (ViewGroup) null);
                    fVar4.znU = (TextView) view.findViewById(R.id.faj);
                    fVar4.znV = (TextView) view.findViewById(R.id.fam);
                    fVar4.mEx = (ImageView) view.findViewById(R.id.fao);
                    fVar4.znX = (TextView) view.findViewById(R.id.fap);
                    fVar4.znY = (TextView) view.findViewById(R.id.fah);
                    fVar4.pwO = (TextView) view.findViewById(R.id.fas);
                    fVar4.zoa = view.findViewById(R.id.fai);
                    fVar4.zob = znN;
                    view.setTag(fVar4);
                    break;
                }
        }
        f fVar5 = (f) view.getTag();
        if (z3) {
            fVar5.pwO.setVisibility(0);
            fVar5.pwO.setText(com.tencent.mm.pluginsdk.i.f.c(this.gte, aVar.createTime, false));
        } else {
            fVar5.pwO.setVisibility(8);
        }
        switch (aVar.msgType) {
            case 1:
                f fVar6 = (f) view.getTag();
                fVar6.znW.setText(aVar.ehx());
                l.p(fVar6.znW, 1);
                break;
            case 3:
                f fVar7 = (f) view.getTag();
                bg.aVF();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    h.ehF();
                    Bitmap aDK = com.tencent.mm.plugin.masssend.a.b.aDK(aVar.ehx());
                    if (aDK != null) {
                        fVar7.mEx.setImageBitmap(aDK);
                    } else {
                        h.ehF();
                        fVar7.mEx.setImageBitmap(com.tencent.mm.plugin.masssend.a.b.h(aVar.ehy(), com.tencent.mm.cb.a.getDensity(fVar7.mEx.getContext())));
                    }
                } else {
                    fVar7.mEx.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, R.drawable.bjn));
                }
                fVar7.mEx.setOnClickListener(new a(aVar.ehx(), aVar.znr));
                break;
            case 34:
                f fVar8 = (f) view.getTag();
                float AO = com.tencent.mm.modelvoice.s.AO((long) aVar.zno);
                if (aVar.ehw().equals(this.znR)) {
                    fVar8.znZ.setVisibility(0);
                    fVar8.znZ.bWT();
                    fVar8.znW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    fVar8.znZ.setVisibility(8);
                    fVar8.znZ.cEA();
                    fVar8.znW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.gte.getResources().getDrawable(R.raw.chatto_voice_playing), (Drawable) null);
                }
                fVar8.znX.setText(this.gte.getString(R.string.dgc, new Object[]{Integer.valueOf((int) AO)}));
                fVar8.znW.setWidth(com.tencent.mm.cb.a.fromDPToPix(fVar8.znW.getContext(), Qi((int) AO)));
                fVar8.znZ.setWidth(com.tencent.mm.cb.a.fromDPToPix(fVar8.znW.getContext(), Qi((int) AO)));
                fVar8.znW.setOnClickListener(new d(aVar.ehw()));
                break;
            case 43:
                f fVar9 = (f) view.getTag();
                o.bhj();
                Bitmap a2 = q.bcR().a(t.Qx(aVar.ehx()), com.tencent.mm.cb.a.getDensity(fVar9.mEx.getContext()), -1);
                if (a2 == null) {
                    bg.aVF();
                    if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                        fVar9.mEx.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, R.raw.video_no_sd_icon));
                    } else {
                        fVar9.mEx.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, R.color.u6));
                    }
                } else {
                    fVar9.mEx.setImageBitmap(a2);
                }
                fVar9.mEx.setOnClickListener(new View$OnClickListenerC1471c(aVar.ehx(), aVar.videoSource, aVar.djh, aVar.zno));
                if (aVar.videoSource == 2) {
                    fVar9.znX.setVisibility(8);
                    break;
                } else {
                    fVar9.znX.setVisibility(0);
                    fVar9.znX.setText(Util.formatSecToMin(aVar.zno));
                    break;
                }
        }
        f fVar10 = (f) view.getTag();
        fVar10.znU.setText(this.gte.getResources().getQuantityString(R.plurals.t, aVar.znn, Integer.valueOf(aVar.znn)));
        if (this.znQ.contains(aVar.ehw())) {
            fVar10.znV.setSingleLine(false);
            fVar10.znV.setEllipsize(null);
        } else {
            fVar10.znV.setSingleLine(true);
            fVar10.znV.setEllipsize(TextUtils.TruncateAt.END);
        }
        TextView textView = fVar10.znV;
        MMActivity mMActivity = this.gte;
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (aVar.ehz() == null || aVar.ehz().equals("")) {
            str = "";
        } else {
            String[] split = aVar.ehz().split(";");
            if (split == null || split.length <= 0) {
                arrayList = arrayList2;
            } else {
                arrayList = Util.stringsToList(split);
            }
            if (arrayList == null) {
                str = "";
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    String displayName = com.tencent.mm.model.aa.getDisplayName(arrayList.get(i3));
                    if (i3 == arrayList.size() - 1) {
                        sb.append(displayName);
                    } else {
                        sb.append(displayName + ", ");
                    }
                }
                str = sb.toString();
            }
        }
        textView.setText(l.b(mMActivity, str, fVar10.znV.getTextSize()));
        String charSequence = fVar10.znV.getText().toString();
        com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 255);
        Paint paint = new Paint();
        paint.setTextSize((float) ((int) fVar10.znV.getTextSize()));
        paint.measureText(charSequence);
        fVar10.znY.setOnClickListener(new b(aVar.ehw()));
        AppMethodBeat.o(26412);
        return view;
    }

    public final void aDP(String str) {
        AppMethodBeat.i(26413);
        this.znR = str;
        notifyDataSetChanged();
        AppMethodBeat.o(26413);
    }

    class b implements View.OnClickListener {
        private String id;

        public b(String str) {
            this.id = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(26406);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.masssend.a.a aDL = h.ehF().aDL(this.id);
            Intent intent = new Intent(c.this.gte, MassSendMsgUI.class);
            intent.putExtra("mass_send_contact_list", aDL.ehz());
            intent.putExtra("mass_send_again", true);
            MMActivity mMActivity = c.this.gte;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            mMActivity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26406);
        }
    }

    class a implements View.OnClickListener {
        private String fileName;
        private int znr;

        public a(String str, int i2) {
            this.fileName = str;
            this.znr = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(26405);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
            bg.aVF();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                u.g(c.this.gte, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26405);
                return;
            }
            StringBuilder sb = new StringBuilder();
            bg.aVF();
            String sb2 = sb.append(com.tencent.mm.model.c.aSY()).append(this.fileName).toString();
            if (sb2 == null || sb2.equals("") || !com.tencent.mm.vfs.s.YS(sb2)) {
                Log.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26405);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_compress_type", this.znr);
            intent.putExtra("key_favorite", false);
            intent.putExtra("key_image_path", sb2);
            com.tencent.mm.plugin.masssend.a.jRt.d(c.this.gte, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26405);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.c$c  reason: collision with other inner class name */
    class View$OnClickListenerC1471c implements View.OnClickListener {
        private String fileName;
        private int length;
        private int size;
        private int videoSource;

        public View$OnClickListenerC1471c(String str, int i2, int i3, int i4) {
            this.fileName = str;
            this.videoSource = i2;
            this.length = i4;
            this.size = i3;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(26407);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            bg.aVF();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                u.g(c.this.gte, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26407);
                return;
            }
            boolean z = this.videoSource == 2;
            o.bhj();
            boolean Ql = r.Ql(t.Qw(this.fileName));
            Log.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", this.fileName, Boolean.valueOf(z), Boolean.valueOf(Ql));
            com.tencent.mm.plugin.masssend.a.jRt.a(z, Ql, c.this.gte, this.fileName, this.length, this.size);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26407);
        }
    }

    class d implements View.OnClickListener {
        private String id;

        public d(String str) {
            this.id = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(26408);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVoiceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
            if (c.this.znS != null) {
                c.this.znR = c.this.znS.aDQ(this.id);
                c.this.notifyDataSetChanged();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVoiceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26408);
        }
    }

    private static int Qi(int i2) {
        if (i2 <= 2) {
            return 100;
        }
        if (i2 < 10) {
            return ((i2 - 2) * 8) + 100;
        }
        if (i2 < 60) {
            return (((i2 / 10) + 7) * 8) + 100;
        }
        return 204;
    }

    private void ehR() {
        AppMethodBeat.i(26414);
        int count = getCount();
        if (count <= 0) {
            AppMethodBeat.o(26414);
            return;
        }
        this.znP = new short[count];
        AppMethodBeat.o(26414);
    }

    static class f {
        ImageView mEx;
        TextView pwO;
        TextView znU;
        TextView znV;
        TextView znW;
        TextView znX;
        TextView znY;
        AnimImageView znZ;
        View zoa;
        short zob;

        f() {
        }
    }
}
