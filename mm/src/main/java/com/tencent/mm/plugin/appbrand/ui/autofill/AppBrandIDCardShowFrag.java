package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.protocal.protobuf.dyd;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aa;
import java.util.List;

public class AppBrandIDCardShowFrag extends MMFragment {
    private ImageView gBZ;
    private LinearLayout gCh;
    private TextView hPW;
    private RecyclerView hak;
    private com.tencent.mm.ui.a mActionBarHelper;
    AppBrandIDCardUI.a nZf;
    private View nZg;
    private TextView nZh;
    private Button nZi;
    private CheckBox nZj;
    private TextView nZk;
    private LinearLayout nZl;
    private View nZm;
    private TextView nZn;
    private TextView nZo;

    @Override // com.tencent.mm.ui.MMFragment
    public void dealContentView(View view) {
        AppMethodBeat.i(48920);
        if (this.nZf == null || this.nZf.bXU() == null) {
            Log.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
            AppMethodBeat.o(48920);
            return;
        }
        this.gCh = (LinearLayout) view.findViewById(R.id.or);
        this.gBZ = (ImageView) view.findViewById(R.id.oo);
        this.hPW = (TextView) view.findViewById(R.id.on);
        this.hak = (RecyclerView) view.findViewById(R.id.ot);
        this.nZh = (TextView) view.findViewById(R.id.ok);
        this.nZi = (Button) view.findViewById(R.id.om);
        this.nZj = (CheckBox) view.findViewById(R.id.ol);
        this.nZk = (TextView) view.findViewById(R.id.r7);
        this.nZl = (LinearLayout) view.findViewById(R.id.oj);
        this.nZm = view.findViewById(R.id.ow);
        this.nZn = (TextView) view.findViewById(R.id.ou);
        this.nZo = (TextView) view.findViewById(R.id.ov);
        this.nZg = aa.jQ(getContext()).inflate(R.layout.bb, (ViewGroup) null);
        this.nZg.setBackgroundColor(getResources().getColor(R.color.a2r));
        this.mActionBarHelper = new com.tencent.mm.ui.a(this.nZg);
        this.gCh.addView(this.nZg, 0, new LinearLayout.LayoutParams(-1, b.eu(getActivity())));
        final dyd bXU = this.nZf.bXU();
        this.mActionBarHelper.setTitle(bXU.title);
        this.mActionBarHelper.setClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(48909);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (AppBrandIDCardShowFrag.this.nZf != null) {
                    AppBrandIDCardShowFrag.this.nZf.back();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(48909);
            }
        });
        com.tencent.mm.modelappbrand.a.b.aXY().a(this.gBZ, bXU.Mzt, com.tencent.mm.modelappbrand.a.a.aXX(), g.iJB);
        this.hPW.setText(bXU.ixZ + " " + bXU.MTK);
        if (bXU.MXI != null) {
            this.hak.setVisibility(0);
            RecyclerView recyclerView = this.hak;
            getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager());
            this.hak.setAdapter(new a(bXU.MXI));
        } else {
            Log.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
            this.hak.setVisibility(8);
        }
        this.nZh.setText(bXU.MXJ);
        if (!Util.isNullOrNil(bXU.MXK)) {
            this.nZi.setText(bXU.MXK);
        } else {
            this.nZi.setText(getString(R.string.m6));
        }
        Log.i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", Boolean.valueOf(bXU.MXO));
        this.nZj.setChecked(bXU.MXO);
        this.nZi.setEnabled(bXU.MXO);
        if (!Util.isNullOrNil(bXU.MXP)) {
            this.nZj.setText(bXU.MXP);
        } else {
            this.nZj.setText(getString(R.string.m7));
        }
        this.nZj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.AnonymousClass2 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(48910);
                if (AppBrandIDCardShowFrag.this.nZi != null) {
                    AppBrandIDCardShowFrag.this.nZi.setEnabled(z);
                }
                AppMethodBeat.o(48910);
            }
        });
        this.nZi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(48911);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
                if (AppBrandIDCardShowFrag.this.nZf != null) {
                    AppBrandIDCardShowFrag.this.nZf.bXS();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(48911);
            }
        });
        if (bXU.MXL != null) {
            this.nZk.setText(bXU.MXL.name);
            this.nZk.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(48912);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (AppBrandIDCardShowFrag.this.nZf != null) {
                        AppBrandIDCardShowFrag.this.nZf.aft(bXU.MXL.url);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(48912);
                }
            });
        }
        if (bXU.MXM != null) {
            Log.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", Integer.valueOf(bXU.MXM.size()));
            if (bXU.MXM.size() == 0) {
                this.nZl.setVisibility(8);
                AppMethodBeat.o(48920);
                return;
            } else if (bXU.MXM.size() == 1) {
                this.nZl.setVisibility(0);
                this.nZm.setVisibility(8);
                this.nZo.setVisibility(8);
                if (bXU.MXM.get(0) != null) {
                    this.nZn.setText(bXU.MXM.get(0).name);
                    this.nZn.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.AnonymousClass5 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(48913);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (AppBrandIDCardShowFrag.this.nZf != null) {
                                AppBrandIDCardShowFrag.this.nZf.afu(bXU.MXM.get(0).url);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(48913);
                        }
                    });
                    AppMethodBeat.o(48920);
                    return;
                }
            } else {
                this.nZl.setVisibility(0);
                this.nZm.setVisibility(0);
                this.nZo.setVisibility(0);
                if (bXU.MXM.get(0) != null) {
                    this.nZn.setText(bXU.MXM.get(0).name);
                    this.nZn.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.AnonymousClass6 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(48914);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
                            if (AppBrandIDCardShowFrag.this.nZf != null) {
                                AppBrandIDCardShowFrag.this.nZf.afu(bXU.MXM.get(0).url);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(48914);
                        }
                    });
                }
                if (bXU.MXM.get(1) != null) {
                    this.nZo.setText(bXU.MXM.get(1).name);
                    this.nZo.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.AnonymousClass7 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(48915);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (AppBrandIDCardShowFrag.this.nZf != null) {
                                AppBrandIDCardShowFrag.this.nZf.afv(bXU.MXM.get(1).url);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(48915);
                        }
                    });
                }
            }
        }
        AppMethodBeat.o(48920);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean noActionBar() {
        return true;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean supportNavigationSwipeBack() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public int getLayoutId() {
        return R.layout.e3;
    }

    public static class a extends RecyclerView.a<C0804a> {
        private List<hs> nZr;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(C0804a aVar, int i2) {
            AppMethodBeat.i(48918);
            C0804a aVar2 = aVar;
            hs hsVar = this.nZr.get(i2);
            if (hsVar != null) {
                aVar2.gxs.setText(hsVar.key);
                aVar2.nZs.setText(hsVar.iFF);
            }
            AppMethodBeat.o(48918);
        }

        public a(List<hs> list) {
            this.nZr = list;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(48917);
            if (this.nZr == null) {
                AppMethodBeat.o(48917);
                return 0;
            }
            int size = this.nZr.size();
            AppMethodBeat.o(48917);
            return size;
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag$a$a  reason: collision with other inner class name */
        public static class C0804a extends RecyclerView.v {
            public TextView gxs;
            public TextView nZs;

            public C0804a(View view) {
                super(view);
                AppMethodBeat.i(48916);
                this.gxs = (TextView) view.findViewById(R.id.op);
                this.nZs = (TextView) view.findViewById(R.id.oq);
                AppMethodBeat.o(48916);
            }
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ C0804a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(48919);
            C0804a aVar = new C0804a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.e2, viewGroup, false));
            AppMethodBeat.o(48919);
            return aVar;
        }
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void onSwipeBack() {
        AppMethodBeat.i(48921);
        if (this.nZf != null) {
            this.nZf.onSwipeBack();
        }
        AppMethodBeat.o(48921);
    }
}
