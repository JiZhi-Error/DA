package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class v extends LinearLayout implements y {
    b EqB = new b();
    private SnsInfo EqC = null;
    private a EqD;
    private View.OnTouchListener EqE = Util.genLinearPressedListener();
    private boolean EqF = true;
    private Context context;
    private boolean dJM = false;
    private int dJN;
    private String dJX = "";
    private String gna = "";
    private int qcr = 0;

    public interface a {
        void ffk();
    }

    public final void setVisibility(int i2) {
        boolean z = false;
        AppMethodBeat.i(97886);
        if (this.qcr == 2 || this.qcr == 3) {
            super.setVisibility(i2);
            if (i2 != 8) {
                z = true;
            }
            this.EqF = z;
            AppMethodBeat.o(97886);
        } else if (this.EqC != null && !this.EqC.isExtFlag()) {
            AppMethodBeat.o(97886);
        } else if (i2 == 8) {
            this.EqB.EqI.setVisibility(8);
            this.EqF = false;
            AppMethodBeat.o(97886);
        } else {
            if (i2 == 0) {
                this.EqB.EqI.setVisibility(0);
                this.EqF = true;
            }
            AppMethodBeat.o(97886);
        }
    }

    public v(Context context2, int i2, boolean z) {
        super(context2);
        AppMethodBeat.i(97887);
        this.qcr = i2;
        this.dJM = z;
        init(context2);
        AppMethodBeat.o(97887);
    }

    public final void setSnsSource(int i2) {
        this.dJN = i2;
    }

    public final void setType(int i2) {
        AppMethodBeat.i(97888);
        this.qcr = i2;
        init(this.context);
        AppMethodBeat.o(97888);
    }

    public final void setCallBack(a aVar) {
        this.EqD = aVar;
    }

    private void init(final Context context2) {
        AppMethodBeat.i(97889);
        this.context = context2;
        if (this.qcr == -1) {
            AppMethodBeat.o(97889);
            return;
        }
        this.gna = z.aTY();
        View inflate = LayoutInflater.from(context2).inflate(R.layout.bvw, (ViewGroup) this, true);
        this.EqB.EqI = (LinearLayout) inflate.findViewById(R.id.i4w);
        this.EqB.EqQ = (LinearLayout) inflate.findViewById(R.id.j7i);
        this.EqB.EqL = (LinearLayout) inflate.findViewById(R.id.ebl);
        this.EqB.EqL.setOnTouchListener(this.EqE);
        this.EqB.hQj = (ImageView) inflate.findViewById(R.id.dxb);
        this.EqB.EqM = (LinearLayout) inflate.findViewById(R.id.b95);
        this.EqB.EqM.setOnTouchListener(this.EqE);
        this.EqB.EqN = (LinearLayout) inflate.findViewById(R.id.bev);
        this.EqB.hOf = (TextView) inflate.findViewById(R.id.hx6);
        this.EqB.EqP = (TextView) inflate.findViewById(R.id.hx7);
        this.EqB.EqO = (TextView) inflate.findViewById(R.id.dn_);
        this.EqB.EqJ = (TextView) inflate.findViewById(R.id.hl5);
        this.EqB.EqK = (LinearLayout) inflate.findViewById(R.id.hl6);
        this.EqB.hPW = (TextView) inflate.findViewById(R.id.hxk);
        this.EqB.EqU = (LinearLayout) inflate.findViewById(R.id.dy7);
        ((LinearLayout) inflate.findViewById(R.id.dy7)).getBackground().setAlpha(50);
        this.EqB.gyr = (ImageView) inflate.findViewById(R.id.xg);
        this.EqB.EqR = (ImageView) inflate.findViewById(R.id.er3);
        this.EqB.EqS = (ImageView) inflate.findViewById(R.id.c4m);
        this.EqB.EqT = (LinearLayout) inflate.findViewById(R.id.blm);
        this.EqB.EqV = (TextView) inflate.findViewById(R.id.blo);
        if (this.qcr == 2) {
            this.EqB.EqQ.setVisibility(8);
            this.EqB.EqT.setVisibility(8);
            this.EqB.EqK.setVisibility(0);
        } else if (this.qcr == 3) {
            this.EqB.EqQ.setVisibility(8);
            this.EqB.EqK.setVisibility(8);
            this.EqB.EqT.setVisibility(0);
        } else {
            this.EqB.EqQ.setVisibility(0);
            this.EqB.EqK.setVisibility(8);
            this.EqB.EqT.setVisibility(8);
        }
        this.EqB.EqL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.v.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(97881);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (v.this.EqC == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(97881);
                    return;
                }
                if (v.this.EqC.getLikeFlag() == 0) {
                    if (v.this.EqC.isExtFlag()) {
                        aq.a.a(v.this.EqC, 1, "", "", v.this.dJN);
                    } else {
                        aq.a.a(v.this.EqC.field_userName, 5, "", v.this.EqC, v.this.dJN);
                    }
                    v.this.EqC.setLikeFlag(1);
                    aj.faO().S(v.this.EqC);
                    e.DUQ.fcy().eOB = 2;
                } else {
                    v.this.EqC.setLikeFlag(0);
                    aj.faO().S(v.this.EqC);
                    aq.a.aPo(v.this.EqC.getSnsId());
                    v.this.EqC = aj.faO().JJ(v.this.EqC.field_snsId);
                    e.DUQ.fcy().eOB = 4;
                }
                h.INSTANCE.a(11989, 1, v.this.EqC.field_snsId == 0 ? "" : r.Jb(v.this.EqC.field_snsId), 0);
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.v.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(97880);
                        v.this.refresh();
                        AppMethodBeat.o(97880);
                    }
                }, 500);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97881);
            }
        });
        this.EqB.EqM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.v.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(97882);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.GalleryFooter", "comment cmd");
                if (v.this.EqC == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(97882);
                    return;
                }
                int i2 = v.this.EqC.localid;
                Intent intent = new Intent();
                intent.putExtra("sns_comment_localId", i2);
                intent.putExtra("sns_source", v.this.dJN);
                intent.setClass(context2, SnsCommentUI.class);
                h.INSTANCE.a(11989, 2, v.this.EqC.field_snsId == 0 ? "" : r.Jb(v.this.EqC.field_snsId), 0);
                Context context = context2;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97882);
            }
        });
        this.EqB.EqN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.v.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(97883);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (v.this.EqC == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(97883);
                    return;
                }
                h.INSTANCE.a(11989, 3, v.this.EqC.field_snsId == 0 ? "" : r.Jb(v.this.EqC.field_snsId), 0);
                int i2 = v.this.EqC.localid;
                Intent intent = new Intent();
                intent.setClass(context2, SnsCommentDetailUI.class);
                intent.putExtra("INTENT_TALKER", v.this.EqC.getUserName());
                intent.putExtra("INTENT_SNS_LOCAL_ID", y.bq("sns_table_", (long) i2));
                intent.putExtra("INTENT_FROMGALLERY", true);
                ((MMActivity) context2).startActivityForResult(intent, 1);
                e.DUQ.fcy().eOt = 1;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97883);
            }
        });
        this.EqB.EqJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.v.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(97884);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (v.this.EqD != null) {
                    v.this.EqD.ffk();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97884);
            }
        });
        this.EqB.EqV.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.v.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(97885);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (v.this.EqD != null) {
                    a unused = v.this.EqD;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97885);
            }
        });
        AppMethodBeat.o(97889);
    }

    public final void refresh() {
        AppMethodBeat.i(97890);
        if (this.qcr == -1) {
            AppMethodBeat.o(97890);
            return;
        }
        this.EqC = aj.faO().aQm(this.dJX);
        if (Util.isNullOrNil(this.dJX) || this.EqC == null) {
            AppMethodBeat.o(97890);
            return;
        }
        this.EqB.EqS.setVisibility(8);
        if (an.aQ(this.EqC.getLocalPrivate(), this.dJM)) {
            this.EqB.EqM.setVisibility(8);
            this.EqB.EqL.setVisibility(8);
        } else if (!this.EqC.isExtFlag()) {
            this.EqB.EqU.setVisibility(0);
            this.EqB.EqQ.setVisibility(0);
            this.EqB.EqI.setVisibility(8);
            this.EqB.EqN.setVisibility(8);
            this.EqB.EqM.setVisibility(8);
            this.EqB.EqL.setVisibility(8);
        } else {
            if (this.EqF) {
                this.EqB.EqI.setVisibility(0);
            }
            this.EqB.EqN.setVisibility(0);
            this.EqB.EqM.setVisibility(0);
            this.EqB.EqL.setVisibility(0);
            this.EqB.EqQ.setVisibility(0);
        }
        SnsObject C = an.C(this.EqC);
        if (C != null) {
            if (this.EqC.isExtFlag()) {
                int i2 = C.CommentCount;
                if (i2 > 0) {
                    this.EqB.EqP.setText(String.valueOf(i2));
                    this.EqB.EqP.setVisibility(0);
                } else {
                    this.EqB.EqP.setVisibility(8);
                }
                int i3 = C.LikeCount;
                if (i3 > 0) {
                    this.EqB.hOf.setText(String.valueOf(i3));
                    this.EqB.hOf.setVisibility(0);
                } else {
                    this.EqB.hOf.setVisibility(8);
                }
                Log.d("MicroMsg.GalleryFooter", "commentCount " + i2 + " " + i3);
                if (this.EqC.getLikeFlag() == 1) {
                    this.EqB.EqO.setText(getResources().getString(R.string.h6n));
                    this.EqB.hQj.setImageResource(R.raw.friendactivity_comment_likeicon_havon);
                } else {
                    this.EqB.EqO.setText(String.valueOf(getResources().getString(R.string.h6o)));
                    this.EqB.hQj.setImageResource(R.raw.friendactivity_comment_likeicon_normal);
                }
                e.DUQ.fcy().eOy = (long) i2;
                e.DUQ.fcy().eOz = (long) i3;
            }
            if (this.gna.equals(this.EqC.getUserName()) || !this.dJM) {
                this.EqB.gyr.setVisibility(8);
            } else {
                this.EqB.gyr.setVisibility(0);
                a.b.c(this.EqB.gyr, this.EqC.getUserName());
            }
        }
        if (this.EqC.getTimeLine() == null) {
            this.EqB.hPW.setVisibility(8);
            AppMethodBeat.o(97890);
            return;
        }
        String str = this.EqC.getTimeLine().ContentDesc;
        if (str == null || str.equals("")) {
            this.EqB.hPW.setText("");
            this.EqB.hPW.setVisibility(8);
        } else {
            this.EqB.hPW.setText(l.b(getContext(), str + " ", this.EqB.hPW.getTextSize()));
            this.EqB.hPW.setVisibility(0);
            e.DUQ.fcy().eOq = 1;
        }
        if (an.aQ(this.EqC.getLocalPrivate(), this.dJM)) {
            this.EqB.EqR.setVisibility(0);
            this.EqB.hPW.setVisibility(0);
        } else {
            this.EqB.EqR.setVisibility(8);
        }
        if (this.dJM && this.EqC.isDieItem()) {
            this.EqB.EqN.setVisibility(0);
            this.EqB.hPW.setVisibility(0);
            this.EqB.EqS.setVisibility(0);
        }
        AppMethodBeat.o(97890);
    }

    public final void setFooter(String str) {
        AppMethodBeat.i(97891);
        this.dJX = str;
        refresh();
        AppMethodBeat.o(97891);
    }

    /* access modifiers changed from: package-private */
    public class b {
        LinearLayout EqI;
        TextView EqJ;
        LinearLayout EqK;
        LinearLayout EqL;
        LinearLayout EqM;
        LinearLayout EqN;
        TextView EqO;
        TextView EqP;
        LinearLayout EqQ;
        ImageView EqR;
        ImageView EqS;
        LinearLayout EqT;
        LinearLayout EqU;
        TextView EqV;
        ImageView gyr;
        TextView hOf;
        TextView hPW;
        ImageView hQj;

        b() {
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.y
    public final void aQQ(String str) {
        AppMethodBeat.i(97892);
        setFooter(str);
        AppMethodBeat.o(97892);
    }

    public final int getFooterH() {
        AppMethodBeat.i(97893);
        if (this.EqB.EqI != null) {
            int height = this.EqB.EqI.getHeight();
            AppMethodBeat.o(97893);
            return height;
        }
        AppMethodBeat.o(97893);
        return 10;
    }
}
