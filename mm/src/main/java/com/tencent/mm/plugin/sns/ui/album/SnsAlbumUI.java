package com.tencent.mm.plugin.sns.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsGalleryUI;
import com.tencent.mm.plugin.sns.ui.SnsUserUI;
import com.tencent.mm.plugin.sns.ui.album.a;
import com.tencent.mm.plugin.sns.ui.album.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMFragment;
import java.util.List;

public class SnsAlbumUI extends MMFragment implements i.a, a.AbstractC1735a {
    private boolean ELe = false;
    private String ELj = null;
    private int ELl = 0;
    private aq.a EQi = null;
    private Runnable EQz = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(99876);
            if (SnsAlbumUI.this.ETE != null) {
                SnsAlbumUI.this.ETE.fiE();
                SnsAlbumUI.this.ETE.vw(true);
            }
            AppMethodBeat.o(99876);
        }
    };
    private LinearLayout ETC = null;
    private LinearLayout ETD = null;
    private a ETE = null;
    private int ETF = 0;
    private String mRa = null;
    private RecyclerView mRecyclerView = null;

    public SnsAlbumUI() {
        AppMethodBeat.i(99882);
        AppMethodBeat.o(99882);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void dealContentView(View view) {
        AppMethodBeat.i(99883);
        super.dealContentView(view);
        this.EQi = aj.faE();
        this.ELl = getActivity().getIntent().getIntExtra("sns_source", 0);
        this.mRa = getActivity().getIntent().getStringExtra("sns_userName");
        this.ELj = z.aTY();
        this.ETE = new a(getContext(), this.mRa, this);
        this.ETE.ETj = new c.a() {
            /* class com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.sns.ui.album.c.a
            public final void cw(int i2, String str) {
                AppMethodBeat.i(99878);
                Log.i("MicroMsg.SnsAlbumUI", "onClickItem localId=%s, mediaId=%s", Integer.valueOf(i2), str);
                SnsAlbumUI.a(SnsAlbumUI.this, i2, str);
                AppMethodBeat.o(99878);
            }
        };
        this.ETC = (LinearLayout) view.findViewById(R.id.ks);
        this.ETD = (LinearLayout) view.findViewById(R.id.kr);
        this.mRecyclerView = (RecyclerView) view.findViewById(R.id.ku);
        this.ETD.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(99879);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SnsAlbumUI.this.getActivity(), SnsUserUI.class);
                intent.putExtra("sns_rpt_scene", 21);
                intent.putExtra("sns_userName", SnsAlbumUI.this.mRa);
                FragmentActivity activity = SnsAlbumUI.this.getActivity();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99879);
            }
        });
        this.mRecyclerView.setAdapter(this.ETE);
        RecyclerView recyclerView = this.mRecyclerView;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.mRecyclerView.a(new d() {
            /* class com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.sns.ui.album.d
            public final void onLoadMore() {
                AppMethodBeat.i(99880);
                Log.d("MicroMsg.SnsAlbumUI", "onLoadMore");
                SnsAlbumUI.this.EQi.b(10, SnsAlbumUI.this.mRa, true, SnsAlbumUI.this.ELl);
                aj.dRd().postDelayed(SnsAlbumUI.this.EQz, 3000);
                AppMethodBeat.o(99880);
            }
        });
        this.mRecyclerView.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(99881);
                if (SnsAlbumUI.this.ELe) {
                    Log.w("MicroMsg.SnsAlbumUI", "too fast that it finish");
                    AppMethodBeat.o(99881);
                    return;
                }
                SnsAlbumUI.this.EQi.a(10, SnsAlbumUI.this.mRa, SnsAlbumUI.this);
                SnsAlbumUI.this.EQi.a(10, SnsAlbumUI.this.mRa, true, SnsAlbumUI.this.ELl);
                AppMethodBeat.o(99881);
            }
        }, 500);
        AppMethodBeat.o(99883);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public int getLayoutId() {
        return R.layout.bv7;
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(99884);
        super.onCreate(bundle);
        setMMTitle(R.string.gl);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(99877);
                if (SnsAlbumUI.this.getActivity() != null) {
                    SnsAlbumUI.this.getActivity().finish();
                }
                AppMethodBeat.o(99877);
                return true;
            }
        });
        AppMethodBeat.o(99884);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onViewCreated(View view, Bundle bundle) {
        AppMethodBeat.i(99885);
        Log.d("MicroMsg.SnsAlbumUI", "onViewCreated");
        super.onViewCreated(view, bundle);
        AppMethodBeat.o(99885);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
        if (r0 != false) goto L_0x0079;
     */
    @Override // com.tencent.mm.plugin.sns.b.i.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r8, boolean r9, int r10, com.tencent.mm.plugin.sns.b.b r11) {
        /*
        // Method dump skipped, instructions count: 141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.a(java.lang.String, boolean, int, com.tencent.mm.plugin.sns.b.b):void");
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void b(String str, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
        AppMethodBeat.i(99887);
        aj.dRd().removeCallbacks(this.EQz);
        if (this.ELj.equals(this.mRa) && bVar.eZf() != 0) {
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(bVar.eZf()));
            this.ETE.JR(bVar.eZf());
        }
        if (bVar.eZa()) {
            this.ETE.aRn(bVar.eZg());
            if (this.ETE.getItemCount() > 0) {
                this.ETE.ci(this.ETE.getItemCount() - 1);
                AppMethodBeat.o(99887);
                return;
            }
        } else if (this.ETE != null) {
            this.ETE.ETd = bVar.eZc();
            this.ETE.ETb = str;
            this.ETE.fiE();
            this.ETE.vw(true);
        }
        AppMethodBeat.o(99887);
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void a(String str, String str2, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onDestroy() {
        AppMethodBeat.i(99888);
        super.onDestroy();
        this.ELe = true;
        aj.dRd().removeCallbacks(this.EQz);
        g.aAi();
        if (g.aAf().azp() && this.EQi != null) {
            this.EQi.a(this, 10);
        }
        AppMethodBeat.o(99888);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean supportNavigationSwipeBack() {
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.album.a.AbstractC1735a
    public final void hh(List<a.b> list) {
        AppMethodBeat.i(99889);
        if (list == null || list.isEmpty()) {
            this.mRecyclerView.setVisibility(8);
            this.ETC.setVisibility(0);
            AppMethodBeat.o(99889);
            return;
        }
        this.mRecyclerView.setVisibility(0);
        this.ETC.setVisibility(8);
        AppMethodBeat.o(99889);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4;
        int i5;
        AppMethodBeat.i(99890);
        super.onActivityResult(i2, i3, intent);
        Log.d("MicroMsg.SnsAlbumUI", "onActivityResult result=%s request=%s intent=%s", Integer.valueOf(i3), Integer.valueOf(i2), intent);
        if (i2 == 8 && intent != null && intent.getParcelableExtra("sns_cmd_list") != null && (intent.getParcelableExtra("sns_cmd_list") instanceof SnsCmdList)) {
            for (Integer num : ((SnsCmdList) intent.getParcelableExtra("sns_cmd_list")).DEl) {
                int intValue = num.intValue();
                a aVar = this.ETE;
                RecyclerView recyclerView = this.mRecyclerView;
                int i6 = 0;
                while (true) {
                    if (i6 >= aVar.ETa.size()) {
                        i4 = -1;
                        break;
                    }
                    for (SnsInfo snsInfo : aVar.ETa.get(i6).ETm) {
                        if (intValue == snsInfo.localid) {
                            i4 = i6;
                            break;
                        }
                    }
                    i6++;
                }
                if (i4 != -1) {
                    RecyclerView.v ch = recyclerView.ch(i4);
                    if (ch instanceof a.f) {
                        c a2 = a.f.a((a.f) ch);
                        int i7 = -1;
                        int i8 = 1;
                        for (int i9 = 0; i9 < a2.ETw.size(); i9++) {
                            if (a2.ETw.get(i9).ecf == intValue) {
                                if (i7 == -1) {
                                    i7 = i9;
                                } else {
                                    i8++;
                                }
                            }
                        }
                        if (i7 != -1) {
                            for (int i10 = 0; i10 < i8; i10++) {
                                a2.ETw.remove(i7);
                            }
                            i5 = a2.ETw.size();
                            a2.at(i7, i8);
                        } else {
                            i5 = 0;
                        }
                        if (i5 <= 0) {
                            aVar.ETa.remove(i4);
                            aVar.ck(i4);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(99890);
    }

    static /* synthetic */ void a(SnsAlbumUI snsAlbumUI, int i2, String str) {
        AppMethodBeat.i(99891);
        Intent intent = new Intent(snsAlbumUI.getActivity(), SnsGalleryUI.class);
        intent.putExtra("sns_gallery_userName", snsAlbumUI.mRa);
        intent.putExtra("sns_gallery_is_self", Util.isEqual(snsAlbumUI.ELj, snsAlbumUI.mRa));
        intent.putExtra("sns_gallery_localId", i2);
        intent.putExtra("sns_source", snsAlbumUI.ELl);
        intent.putExtra("sns_video_scene", 3);
        intent.putExtra("key_from_scene", 5);
        if (snsAlbumUI.ETE != null) {
            intent.putExtra("sns_gallery_limit_seq", snsAlbumUI.ETE.ETc);
            snsAlbumUI.EQi.l(snsAlbumUI.mRa, snsAlbumUI.ETE.cv(i2, str));
            intent.putExtra("sns_gallery_position", snsAlbumUI.ETE.ETg);
        }
        snsAlbumUI.startActivityForResult(intent, 8);
        AppMethodBeat.o(99891);
    }
}
