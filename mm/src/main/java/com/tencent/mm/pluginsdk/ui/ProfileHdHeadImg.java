package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.o;
import com.tencent.mm.bx.a.a;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.MMGestureGallery;

@a(3)
public class ProfileHdHeadImg extends MMActivity {
    private GetHdHeadImageGalleryView CZq;
    private f CZr;
    private String KcQ = null;
    private String dMf = null;
    private String username = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(ProfileHdHeadImg profileHdHeadImg, Bitmap bitmap, String str) {
        AppMethodBeat.i(31231);
        profileHdHeadImg.d(bitmap, str);
        AppMethodBeat.o(31231);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.atg;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        final Bitmap a2;
        AppMethodBeat.i(31228);
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.username = getIntent().getStringExtra(ch.COL_USERNAME);
        this.dMf = getIntent().getStringExtra("brand_icon_url");
        setActionbarColor(getResources().getColor(R.color.BW_0));
        setNavigationbarColor(getResources().getColor(R.color.BW_0));
        this.CZq = (GetHdHeadImageGalleryView) findViewById(R.id.dci);
        this.CZq.setUsername(this.username);
        this.CZq.setSingleClickOverListener(new MMGestureGallery.f() {
            /* class com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg.AnonymousClass1 */

            @Override // com.tencent.mm.ui.tools.MMGestureGallery.f
            public final void bmt() {
                AppMethodBeat.i(31226);
                ProfileHdHeadImg.this.finish();
                AppMethodBeat.o(31226);
            }
        });
        bg.aVF();
        if (!c.isSDCardAvailable()) {
            u.g(this, null);
            d(p.aYn().cW(this), null);
            AppMethodBeat.o(31228);
            return;
        }
        if (!Util.isNullOrNil(this.dMf)) {
            a2 = o.bg(this.username, this.dMf);
        } else {
            a2 = com.tencent.mm.aj.c.a(this.username, true, -1, null);
        }
        if (a2 == null) {
            a2 = BitmapFactory.decodeResource(getResources(), R.drawable.bca);
        }
        if (a2 == null || a2.isRecycled()) {
            Log.i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is not in the cache, use default avatar", this.username);
        } else {
            Log.i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is in the cache", this.username);
            this.CZq.setThumbImage(a2);
        }
        if (!Util.isNullOrNil(this.KcQ)) {
            this.username = this.KcQ;
        }
        p.aYn();
        Bitmap Mo = e.Mo(this.username);
        if (Mo == null || Mo.isRecycled()) {
            this.CZr = new f();
            this.CZr.a(this.username, new f.c() {
                /* class com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg.AnonymousClass2 */

                @Override // com.tencent.mm.aj.f.c
                public final int dp(int i2, int i3) {
                    AppMethodBeat.i(31227);
                    ProfileHdHeadImg.this.CZr.sQ();
                    Log.i("MicroMsg.ProfileHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 == 0 && i3 == 0) {
                        p.aYn();
                        Bitmap Mo = e.Mo(ProfileHdHeadImg.this.username);
                        if (Mo != null) {
                            ProfileHdHeadImg profileHdHeadImg = ProfileHdHeadImg.this;
                            p.aYn();
                            ProfileHdHeadImg.a(profileHdHeadImg, Mo, e.L(ProfileHdHeadImg.this.username, true));
                        } else {
                            ProfileHdHeadImg.a(ProfileHdHeadImg.this, a2, null);
                        }
                        AppMethodBeat.o(31227);
                    } else {
                        ProfileHdHeadImg.a(ProfileHdHeadImg.this, a2, null);
                        AppMethodBeat.o(31227);
                    }
                    return 0;
                }
            });
            AppMethodBeat.o(31228);
            return;
        }
        Log.i("MicroMsg.ProfileHdHeadImg", "The HDAvatar of %s is already exists", this.username);
        p.aYn();
        d(Mo, e.L(this.username, true));
        AppMethodBeat.o(31228);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(31229);
        super.onDestroy();
        AppMethodBeat.o(31229);
    }

    private void d(Bitmap bitmap, String str) {
        AppMethodBeat.i(31230);
        try {
            Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, 0.1f);
            a.C0284a.NAL.p(this.username, roundedCornerBitmap);
            if (bitmap.getWidth() < 480) {
                float width = (float) (480 / bitmap.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                roundedCornerBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
            Log.d("MicroMsg.ProfileHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(roundedCornerBitmap.getWidth()), Integer.valueOf(roundedCornerBitmap.getHeight()));
            this.CZq.setHdHeadImage(roundedCornerBitmap);
            this.CZq.setHdHeadImagePath(str);
            AppMethodBeat.o(31230);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ProfileHdHeadImg", e2, "", new Object[0]);
            AppMethodBeat.o(31230);
        }
    }
}
