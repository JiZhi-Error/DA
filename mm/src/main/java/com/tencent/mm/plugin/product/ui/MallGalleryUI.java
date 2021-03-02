package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.product.ui.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.List;

@a(3)
public class MallGalleryUI extends MallBaseUI {
    private List<String> BaA;
    private int BaB = 0;
    private boolean BaC;
    private ViewPager Bay;
    private g Baz;
    private final String TAG = "MicroMsg.MallGalleryUI";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.product.ui.MallBaseUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.biw;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.product.ui.MallBaseUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(66947);
        super.onCreate(bundle);
        this.BaA = getIntent().getStringArrayListExtra("keys_img_urls");
        hideTitleView();
        this.BaC = false;
        initView();
        AppMethodBeat.o(66947);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(66948);
        super.onResume();
        this.Baz.setData(this.BaA);
        this.Baz.notifyDataSetChanged();
        if (this.BaA != null) {
            this.BaA.size();
        }
        AppMethodBeat.o(66948);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(66949);
        this.Bay = (ViewPager) findViewById(R.id.f70);
        this.Bay.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.tencent.mm.plugin.product.ui.MallGalleryUI.AnonymousClass1 */

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                AppMethodBeat.i(66942);
                Log.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", Integer.valueOf(i2));
                MallGalleryUI.this.BaB = i2;
                if (MallGalleryUI.this.BaC) {
                    MallGalleryUI.this.hideTitleView();
                    MallGalleryUI.this.BaC = false;
                }
                AppMethodBeat.o(66942);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final synchronized void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i2) {
            }
        });
        this.Baz = new g(this);
        this.Baz.BaX = new g.a() {
            /* class com.tencent.mm.plugin.product.ui.MallGalleryUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.product.ui.g.a
            public final void eDz() {
                AppMethodBeat.i(66943);
                MallGalleryUI.c(MallGalleryUI.this);
                AppMethodBeat.o(66943);
            }
        };
        this.Bay.setAdapter(this.Baz);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallGalleryUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(66944);
                MallGalleryUI.this.finish();
                AppMethodBeat.o(66944);
                return false;
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallGalleryUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] stringArray;
                AppMethodBeat.i(66946);
                if (c.aZU("favorite")) {
                    stringArray = MallGalleryUI.this.getResources().getStringArray(R.array.a0);
                } else {
                    stringArray = MallGalleryUI.this.getResources().getStringArray(R.array.a1);
                }
                h.b(MallGalleryUI.this.getContext(), null, stringArray, null, new h.d() {
                    /* class com.tencent.mm.plugin.product.ui.MallGalleryUI.AnonymousClass4.AnonymousClass1 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(66945);
                        switch (i2) {
                            case 0:
                                MallGalleryUI mallGalleryUI = MallGalleryUI.this;
                                Intent intent = new Intent();
                                intent.putExtra("Retr_Msg_content", "");
                                intent.putExtra("Retr_Msg_Type", 0);
                                if (!Util.isNullOrNil(mallGalleryUI.eDy())) {
                                    intent.putExtra("Retr_File_Name", mallGalleryUI.eDy());
                                    intent.putExtra("Retr_go_to_chattingUI", false);
                                    intent.putExtra("Retr_show_success_tips", true);
                                    c.f(mallGalleryUI, ".ui.transmit.MsgRetransmitUI", intent);
                                    AppMethodBeat.o(66945);
                                    return;
                                }
                                Log.e("MicroMsg.MallGalleryUI", "url is null or nil");
                                AppMethodBeat.o(66945);
                                return;
                            case 1:
                                MallGalleryUI mallGalleryUI2 = MallGalleryUI.this;
                                String eDy = mallGalleryUI2.eDy();
                                if (!Util.isNullOrNil(eDy)) {
                                    Log.d("MicroMsg.MallGalleryUI", "can save. img path: %s", eDy);
                                    s.l(eDy, mallGalleryUI2);
                                    AppMethodBeat.o(66945);
                                    return;
                                }
                                Log.w("MicroMsg.MallGalleryUI", "save error.");
                                AppMethodBeat.o(66945);
                                return;
                            case 2:
                                MallGalleryUI mallGalleryUI3 = MallGalleryUI.this;
                                String eDy2 = mallGalleryUI3.eDy();
                                if (Util.isNullOrNil(eDy2)) {
                                    Log.w("MicroMsg.MallGalleryUI", "file path invalid");
                                    break;
                                } else {
                                    Log.d("MicroMsg.MallGalleryUI", "file path valid");
                                    cz czVar = new cz();
                                    if (Util.isNullOrNil(eDy2)) {
                                        Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                                        czVar.dFZ.dGe = R.string.c_2;
                                    } else {
                                        Log.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", eDy2, 9);
                                        anb anb = new anb();
                                        anh anh = new anh();
                                        aml aml = new aml();
                                        aml.ajd(2);
                                        aml.bgt(eDy2);
                                        aml.bgs(com.tencent.mm.b.g.getMessageDigest((aml.toString() + 2 + System.currentTimeMillis()).getBytes()));
                                        hb hbVar = new hb();
                                        hbVar.dLm.type = 27;
                                        hbVar.dLm.dLo = aml;
                                        EventCenter.instance.publish(hbVar);
                                        String str = hbVar.dLn.thumbPath;
                                        BitmapUtil.createThumbNail(eDy2, 150, 150, Bitmap.CompressFormat.JPEG, 90, str, true);
                                        aml.bgu(str);
                                        anh.bhf(z.aTY());
                                        anh.bhg(z.aTY());
                                        anh.ajm(9);
                                        anh.MA(Util.nowMilliSecond());
                                        anb.a(anh);
                                        anb.ppH.add(aml);
                                        czVar.dFZ.title = aml.title;
                                        czVar.dFZ.dGb = anb;
                                        czVar.dFZ.type = 2;
                                    }
                                    czVar.dFZ.dGf = 4;
                                    czVar.dFZ.activity = mallGalleryUI3;
                                    EventCenter.instance.publish(czVar);
                                    AppMethodBeat.o(66945);
                                    return;
                                }
                        }
                        AppMethodBeat.o(66945);
                    }
                });
                AppMethodBeat.o(66946);
                return true;
            }
        });
        AppMethodBeat.o(66949);
    }

    /* access modifiers changed from: package-private */
    public final String eDy() {
        String str;
        AppMethodBeat.i(66950);
        if (this.BaA == null || this.BaA.size() < this.BaB + 1) {
            Log.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
            str = null;
        } else {
            str = this.BaA.get(this.BaB);
        }
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
            AppMethodBeat.o(66950);
            return null;
        }
        String aKj = c.aKj(str);
        AppMethodBeat.o(66950);
        return aKj;
    }

    static /* synthetic */ void c(MallGalleryUI mallGalleryUI) {
        AppMethodBeat.i(66951);
        mallGalleryUI.BaC = !mallGalleryUI.BaC;
        if (mallGalleryUI.BaC) {
            mallGalleryUI.showTitleView();
            AppMethodBeat.o(66951);
            return;
        }
        mallGalleryUI.hideTitleView();
        AppMethodBeat.o(66951);
    }
}
