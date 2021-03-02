package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.i;

public class ArtistHeader extends LinearLayout implements c.b {
    private he EnQ = null;
    private b EnV;
    private ImageView EnW;
    private ProgressBar EnX;
    private Context context = null;
    private View maskView;
    private i wGm = null;

    public interface a {
    }

    public ArtistHeader(Context context2) {
        super(context2);
        AppMethodBeat.i(97731);
        init(context2);
        AppMethodBeat.o(97731);
    }

    public ArtistHeader(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(97732);
        init(context2);
        AppMethodBeat.o(97732);
    }

    private void init(final Context context2) {
        AppMethodBeat.i(97733);
        View inflate = LayoutInflater.from(context2).inflate(R.layout.bv9, (ViewGroup) this, true);
        this.context = context2;
        this.EnV = new b();
        this.EnV.gyr = (ImageView) inflate.findViewById(R.id.uv);
        this.EnV.hPW = (TextView) inflate.findViewById(R.id.a3);
        this.EnV.zQY = (TextView) inflate.findViewById(R.id.a6);
        this.EnV.Eob = (TextView) inflate.findViewById(R.id.a4);
        this.EnV.titleTv = (TextView) inflate.findViewById(R.id.a5);
        this.EnV.gyr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.ArtistHeader.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(97728);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ArtistHeader.this.wGm != null && ArtistHeader.this.wGm.isShowing()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(97728);
                } else if (ArtistHeader.this.EnQ == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(97728);
                } else {
                    View inflate = LayoutInflater.from(ArtistHeader.this.getContext()).inflate(R.layout.c5w, (ViewGroup) null);
                    ArtistHeader.this.wGm = new i(ArtistHeader.this.getContext(), R.style.a65);
                    inflate.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.ArtistHeader.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(97726);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/ArtistHeader$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            ArtistHeader.this.wGm.dismiss();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(97726);
                        }
                    });
                    ArtistHeader.this.wGm.setCanceledOnTouchOutside(true);
                    ArtistHeader.this.wGm.setContentView(inflate);
                    ArtistHeader.this.wGm.show();
                    ArtistHeader.this.EnW = (ImageView) inflate.findViewById(R.id.dnf);
                    ArtistHeader.this.EnX = (ProgressBar) inflate.findViewById(R.id.dng);
                    ArtistHeader.this.maskView = inflate.findViewById(R.id.dnh);
                    aj.faL().a(ArtistHeader.this.EnQ.KKO.KKP, (View) ArtistHeader.this.EnW, context2.hashCode(), true, bp.Oqt, false, (g.e) new g.e() {
                        /* class com.tencent.mm.plugin.sns.ui.ArtistHeader.AnonymousClass1.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.sns.model.g.e
                        public final void ax(Bitmap bitmap) {
                            AppMethodBeat.i(97727);
                            if (r.M(bitmap)) {
                                ArtistHeader.a(ArtistHeader.this, bitmap);
                                ArtistHeader.this.EnX.setVisibility(4);
                                ArtistHeader.this.maskView.setVisibility(4);
                                AppMethodBeat.o(97727);
                                return;
                            }
                            aj.faL().b(ArtistHeader.this.EnQ.KKO.KKP, ArtistHeader.this.EnW, context2.hashCode(), bp.Oqt);
                            AppMethodBeat.o(97727);
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(97728);
                }
            }
        });
        AppMethodBeat.o(97733);
    }

    public void setUserName(he heVar) {
        AppMethodBeat.i(97734);
        if (heVar == null) {
            Log.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
            AppMethodBeat.o(97734);
            return;
        }
        this.EnQ = heVar;
        aj.faL().b(heVar.KKO.KKP, this.EnV.gyr, this.context.hashCode(), bp.Oqt);
        this.EnV.zQY.setText(heVar.Name);
        this.EnV.hPW.setText(heVar.KHk);
        this.EnV.titleTv.setText(heVar.Title);
        this.EnV.Eob.setText(heVar.KKN);
        AppMethodBeat.o(97734);
    }

    public void setBackClickListener(a aVar) {
    }

    /* access modifiers changed from: package-private */
    public class b {
        TextView Eob;
        ImageView gyr;
        TextView hPW;
        TextView titleTv;
        TextView zQY;

        b() {
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void aOG(String str) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void ci(String str, boolean z) {
        AppMethodBeat.i(97735);
        if (this.EnQ == null) {
            AppMethodBeat.o(97735);
            return;
        }
        if (this.wGm != null && this.wGm.isShowing()) {
            if (!z) {
                cnb cnb = this.EnQ.KKO.KKP;
                if (cnb.Id != null && cnb.Id.equals(str)) {
                    Toast.makeText(this.context, this.context.getString(R.string.h5t), 0).show();
                    AppMethodBeat.o(97735);
                    return;
                }
            }
            if (this.EnW != null) {
                this.EnW.post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.ArtistHeader.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(97730);
                        aj.faL().a(ArtistHeader.this.EnQ.KKO.KKP, (View) ArtistHeader.this.EnW, ArtistHeader.this.context.hashCode(), true, bp.Oqt, false, (g.e) new g.e() {
                            /* class com.tencent.mm.plugin.sns.ui.ArtistHeader.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.sns.model.g.e
                            public final void ax(Bitmap bitmap) {
                                AppMethodBeat.i(97729);
                                if (r.M(bitmap)) {
                                    ArtistHeader.a(ArtistHeader.this, bitmap);
                                    ArtistHeader.this.EnX.setVisibility(4);
                                    ArtistHeader.this.maskView.setVisibility(4);
                                }
                                AppMethodBeat.o(97729);
                            }
                        });
                        AppMethodBeat.o(97730);
                    }
                });
            }
        }
        AppMethodBeat.o(97735);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void cj(String str, boolean z) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void eZJ() {
    }

    static /* synthetic */ void a(ArtistHeader artistHeader, Bitmap bitmap) {
        AppMethodBeat.i(97736);
        if (artistHeader.EnW != null) {
            artistHeader.EnW.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(97736);
    }
}
