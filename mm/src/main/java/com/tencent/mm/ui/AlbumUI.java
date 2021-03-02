package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.DoubleTabView;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.HashMap;

@i
public class AlbumUI extends MMSecDataActivity {
    private DoubleTabView OwQ = null;
    private HashMap<Integer, MMFragment> OwR = new HashMap<>();
    private boolean OwS = false;
    private boolean OwT = false;
    private CustomViewPager mViewPager = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AlbumUI() {
        AppMethodBeat.i(32932);
        AppMethodBeat.o(32932);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(32933);
        fixStatusbar(true);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        AppMethodBeat.o(32933);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public void dealContentView(View view) {
        AppMethodBeat.i(32934);
        super.dealContentView(view);
        this.OwS = getIntent().getBooleanExtra("story_only", false);
        this.OwT = getIntent().getBooleanExtra("story_dot", false);
        this.OwQ = (DoubleTabView) findViewById(R.id.la);
        if (this.OwS) {
            this.OwQ.setVisibility(8);
        } else {
            this.OwQ.setFirstTabString(getResources().getString(R.string.gi));
            this.OwQ.setSecondTabString(p.fvC() ? getResources().getString(R.string.gj) : getResources().getString(R.string.gk));
            if (p.fvC()) {
                addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.ui.AlbumUI.AnonymousClass1 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(232432);
                        ((c) g.ah(c.class)).goLikeListFromSelfHistory(AlbumUI.this.getContext());
                        ((c) g.ah(c.class)).report22208(18, "");
                        AppMethodBeat.o(232432);
                        return true;
                    }
                });
                showOptionMenu(false);
            }
            this.OwQ.setOnTabClickListener(new DoubleTabView.a() {
                /* class com.tencent.mm.ui.AlbumUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.DoubleTabView.a
                public final void onTabClick(int i2) {
                    AppMethodBeat.i(232433);
                    AlbumUI.this.mViewPager.setCurrentItem(i2, true);
                    AppMethodBeat.o(232433);
                }
            });
        }
        this.mViewPager = (CustomViewPager) findViewById(R.id.lf);
        this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.tencent.mm.ui.AlbumUI.AnonymousClass3 */

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i2, float f2, int i3) {
                AppMethodBeat.i(232434);
                AlbumUI.this.OwQ.p(i2, f2);
                AppMethodBeat.o(232434);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                AppMethodBeat.i(232435);
                AlbumUI.this.OwQ.setTo(i2);
                if (i2 == 0) {
                    h hVar = h.FuH;
                    h.fqm().erR = 3;
                } else {
                    h hVar2 = h.FuH;
                    h.fqm().erR = 2;
                    if (AlbumUI.this.OwT) {
                        DoubleTabView doubleTabView = AlbumUI.this.OwQ;
                        if (doubleTabView.OAr != null) {
                            doubleTabView.OAr.Bk(false);
                        }
                        g.aAh().azQ().set(ar.a.USERINFO_STORY_NEED_DISPLAY_ALBUM_GUIDE_BOOLEAN_SYNC, Boolean.FALSE);
                    }
                }
                h hVar3 = h.FuH;
                h.fqn();
                if (!p.fvC() || i2 != 1) {
                    AlbumUI.this.showOptionMenu(false);
                    AppMethodBeat.o(232435);
                    return;
                }
                ((c) g.ah(c.class)).report22208(13, "");
                AlbumUI.this.showOptionMenu(true);
                AppMethodBeat.o(232435);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i2) {
            }
        });
        this.mViewPager.setAdapter(new a(getSupportFragmentManager()));
        h hVar = h.FuH;
        h.fqm().erR = 3;
        h hVar2 = h.FuH;
        h.fqn();
        AppMethodBeat.o(32934);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b7e;
    }

    class a extends j {
        public a(android.support.v4.app.g gVar) {
            super(gVar);
        }

        @Override // android.support.v4.app.j
        public final Fragment getItem(int i2) {
            AppMethodBeat.i(32931);
            MMFragment a2 = AlbumUI.a(AlbumUI.this, i2);
            AppMethodBeat.o(32931);
            return a2;
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            AppMethodBeat.i(232436);
            if (AlbumUI.this.OwS) {
                AppMethodBeat.o(232436);
                return 1;
            }
            AppMethodBeat.o(232436);
            return 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.tencent.mm.ui.MMFragment a(com.tencent.mm.ui.AlbumUI r8, int r9) {
        /*
        // Method dump skipped, instructions count: 164
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.AlbumUI.a(com.tencent.mm.ui.AlbumUI, int):com.tencent.mm.ui.MMFragment");
    }
}
